package org.iammrchenh.infrastructure.security.common.event;

import org.iammrchenh.infrastructure.security.common.event.dto.LoginSuccessEventModel;
import org.springframework.context.ApplicationEvent;

/**
 * @author chenh
 * @date 2021/1/18
 */
public class LoginSuccessEvent extends ApplicationEvent {

    public LoginSuccessEvent(LoginSuccessEventModel source) {
        super(source);
    }

    public static LoginSuccessEvent createEvent(String username) {
        return new LoginSuccessEvent(new LoginSuccessEventModel(username));
    }
}
