package org.iammrchenh.infrastructure.security.common.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenh
 * @date 2021/1/19
 * 登录失败事件
 */
@Getter
@Setter
public class LoginFailureEvent extends ApplicationEvent {

    /**
     * 请求
     */
    private HttpServletRequest request;
    /**
     * 响应
     */
    private HttpServletResponse response;
    /**
     * 失败的异常
     */
    private AuthenticationException e;

    public LoginFailureEvent(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        super(null);
        this.request = request;
        this.response = response;
        this.e = e;
    }
}
