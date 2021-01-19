package org.iammrchenh.infrastructure.security.login.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.iammrchenh.infrastructure.security.common.event.LoginFailureEvent;
import org.iammrchenh.infrastructure.security.common.utils.ApplicationContextUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author chenh
 * @date 2021/1/18
 * 登录失败的处理程序
 */
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.error("登录失败 :", e);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        final ObjectMapper bean = ApplicationContextUtils.getBean(ObjectMapper.class);
        final String result = bean.writeValueAsString(new FailureResult(e.getMessage()));
        response.getOutputStream().write(result.getBytes(StandardCharsets.UTF_8));
        //发布登录失败事件
        // TODO: 2021/1/18 暂时不知道怎么获取username
        ApplicationContextUtils.publishEvent(new LoginFailureEvent(request, response, e));
    }

    @Data
    class FailureResult {
        /**
         * 时间戳
         */
        private long timestamp = System.currentTimeMillis();
        /**
         * 异常信息
         */
        private String message;

        public FailureResult(String message) {
            this.message = message;
        }
    }

}
