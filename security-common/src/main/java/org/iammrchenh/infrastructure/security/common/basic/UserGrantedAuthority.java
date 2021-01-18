package org.iammrchenh.infrastructure.security.common.basic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author chenh
 * @date 2021/1/18
 */
@Getter
@Setter
public class UserGrantedAuthority implements GrantedAuthority {

    /**
     * 资源 /**
     */
    private String authority;
    /**
     * 资源唯一标识
     */
    private String uniqueCode;

    @Override
    public String getAuthority() {
        return authority;
    }
}
