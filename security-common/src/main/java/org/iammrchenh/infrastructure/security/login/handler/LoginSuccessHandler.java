package org.iammrchenh.infrastructure.security.login.handler;

import lombok.extern.slf4j.Slf4j;
import org.iammrchenh.infrastructure.security.common.basic.AuthorityUser;
import org.iammrchenh.infrastructure.security.common.event.LoginSuccessEvent;
import org.iammrchenh.infrastructure.security.common.utils.ApplicationContextUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenh
 * @date 2021/1/18
 * 登录成功的处理程序
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        log.info("{}", authentication.getDetails());
        log.info("{}", authentication.getPrincipal());
        log.info("{}", authentication.getCredentials());
        log.info("{}", authentication.getName());

        //发布登录成功事件
        if (authentication.getDetails() instanceof AuthorityUser) {
            final String username = ((AuthorityUser) authentication.getDetails()).getUsername();
            ApplicationContextUtils.publishEvent(new LoginSuccessEvent(request, response, authentication));
        }

    }
}
