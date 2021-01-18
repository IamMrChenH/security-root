package org.iammrchenh.infrastructure.security.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenh
 * @date 2021/1/18
 */
@Data
@Configuration
@ConfigurationProperties("infrastructure.security.core")
public class SecurityCoreProperties {

    /**
     * 登录地址
     */
    private String loginUrl = "/v1/login";
    /**
     * 注销地址
     */
    private String logoutUrl = "/v1/logout";
    /**
     * 同时允许登录个数，sesstion数量，
     */
    private Integer sessionMaxCount = 1;

}
