package org.iammrchenh.infrastructure.security.login.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author chenh
 * @date 2021/1/19
 * 密码加密配置
 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    @ConditionalOnMissingBean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
