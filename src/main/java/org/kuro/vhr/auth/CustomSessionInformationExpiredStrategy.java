package org.kuro.vhr.auth;

import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 17:36
 */
@Component("customSessionInformationExpiredStrategy")
public class CustomSessionInformationExpiredStrategy extends JSONAuthentication implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent)
            throws IOException, ServletException {
        Result result = Result.error(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
        HttpServletRequest request = sessionInformationExpiredEvent.getRequest();
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        this.WriteJson(request, response, result);
    }
}
