package org.kuro.vhr.auth;

import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功的处理方案
 * @Author: Kuro
 * @Date: 2020/12/23 16:37
 */
@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
            throws IOException, ServletException {
        Hr hr = (Hr) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成token
        String token = jwtTokenUtil.generateToken(hr);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("hr", hr);
        Result result = Result.ok(ResultCode.LOGIN_SUCCESS).data(map);
        this.WriteJson(req, res, result);
    }
}
