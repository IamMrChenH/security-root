package org.iammrchenh.infrastructure.security.common.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenh
 * @date 2021/1/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginFailureEventModel {

    /**
     * 用户名
     */
    private String username;

}
