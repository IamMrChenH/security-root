package org.iammrchenh.infrastructure.security.common.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenh
 * @date 2021/1/19
 * 登录失败事件
 */
@Getter
@Setter
public class LoginSuccessEvent extends ApplicationEvent {

    /**
     * 请求
     */
    private HttpServletRequest request;
    /**
     * 响应
     */
    private HttpServletResponse response;
    /**
     * 用户信息
     */
    private Authentication authentication;


    public LoginSuccessEvent(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        super(null);
        this.request = request;
        this.response = response;
        this.authentication = authentication;
    }
}
