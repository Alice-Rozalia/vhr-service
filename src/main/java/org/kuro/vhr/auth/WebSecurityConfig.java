package org.kuro.vhr.auth;

import org.kuro.vhr.filter.CustomFilter;
import org.kuro.vhr.filter.JwtAuthenticationTokenFilter;
import org.kuro.vhr.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 16:25
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 登录成功的处理逻辑
     */
    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    /**
     * 登录失败的处理逻辑
     */
    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;

    /**
     * 注销成功的处理逻辑
     */
    @Autowired
    private CustomLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private CustomFilter customFilter;

    @Autowired
    private CustomDecisionManager customDecisionManager;

    /**
     * 用户被挤下线处理逻辑
     */
    private CustomSessionInformationExpiredStrategy strategy;

    @Autowired
    private JwtAuthenticationTokenFilter tokenFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 替换默认的登录认证
        auth.userDetailsService(userDetailsService)
                // 替换默认的密码认证方式
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 解决跨域问题。cors 预检请求放行, 让 Spring security 放行所有preflight request（cors 预检请求）
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        // 让 Security永远不会创建 HttpSession，它不会使用 HttpSession来获取 SecurityContext
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().headers().cacheControl();

        // 在 UsernamePasswordAuthenticationFilter 之前添加 tokenFilter
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests()
                // 所有请求都要认证之后才能访问
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(customDecisionManager);
                        o.setSecurityMetadataSource(customFilter);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredSessionStrategy(strategy);
    }
}
