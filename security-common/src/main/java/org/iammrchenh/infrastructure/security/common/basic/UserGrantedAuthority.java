package org.iammrchenh.infrastructure.security.common.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author chenh
 * @date 2021/1/18
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGrantedAuthority implements GrantedAuthority {

    /**
     * 资源唯一标识
     */
    private String uniqueCode;
    /**
     * 资源URL
     */
    private String antUrl;
    /**
     * 请求方法
     */
    private String method;

    @Override
    public String getAuthority() {
        return uniqueCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof UserGrantedAuthority) {
            return uniqueCode.equals(((UserGrantedAuthority) o).getUniqueCode());
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return uniqueCode.hashCode();
    }
}
