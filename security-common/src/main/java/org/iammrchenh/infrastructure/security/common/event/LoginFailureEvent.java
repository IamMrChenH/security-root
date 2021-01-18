package org.iammrchenh.infrastructure.security.common.event;

import org.iammrchenh.infrastructure.security.common.event.dto.LoginSuccessEventModel;
import org.springframework.context.ApplicationEvent;

/**
 * @author chenh
 * @date 2021/1/18
 */
public class LoginFailureEvent extends ApplicationEvent {

    public LoginFailureEvent(LoginSuccessEventModel source) {
        super(source);
    }

    public static LoginFailureEvent createEvent(String username) {
        return new LoginFailureEvent(new LoginSuccessEventModel(username));
    }
}
