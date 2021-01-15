package org.kuro.vhr.filter;

import org.apache.commons.lang3.StringUtils;
import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.service.impl.UserDetailsServiceImpl;
import org.kuro.vhr.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 17:16
 */
@Component("jwtAuthenticationTokenFilter")
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private String header = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
            throws ServletException, IOException {
        String headerToken = req.getHeader(this.header);
        if (!StringUtils.isEmpty(headerToken)) {
            //postMan测试时，自动加入的前缀，要去掉。
            String token = headerToken.replace("Bearer", "").trim();
            System.out.println("token = " + token);

            boolean check = false;
            try {
                check = this.jwtTokenUtil.isTokenExpired(token);
            } catch (Exception e) {
                new Throwable("令牌已过期，请重新登录。" + e.getMessage());
            }

            if (!check) {
                // 通过令牌获取用户名称
                String username = jwtTokenUtil.getUsernameFromToken(token);

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    // 验证令牌有效性
                    boolean validata = false;
                    try {
                        validata = jwtTokenUtil.validateToken(token, (Hr) userDetails);
                    } catch (Exception e) {
                        new Throwable("验证token无效:" + e.getMessage());
                    }
                    if (validata) {
                        // 将用户信息存入 authentication，方便后续校验
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                        // 将 authentication 存入 ThreadLocal，方便后续获取用户信息
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        }

        filterChain.doFilter(req, res);
    }
}
