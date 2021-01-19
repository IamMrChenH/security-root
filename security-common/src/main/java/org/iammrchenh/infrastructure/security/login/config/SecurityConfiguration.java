package org.iammrchenh.infrastructure.security.login.config;

import org.iammrchenh.infrastructure.security.login.SecurityCoreProperties;
import org.iammrchenh.infrastructure.security.login.handler.LoginFailureHandler;
import org.iammrchenh.infrastructure.security.login.handler.LoginSuccessHandler;
import org.iammrchenh.infrastructure.security.login.handler.LogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author chenh
 * @date 2021/1/18
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityCoreProperties properties;

    /**
     * http网络请求配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin()
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailureHandler())
                .and()
                .logout()
                .logoutUrl(properties.getLogoutUrl())
                .logoutSuccessHandler(new LogoutSuccessHandler())
                .and()
                .authorizeRequests()
                .and()
                .sessionManagement()
                .maximumSessions(properties.getMaximumSessions());

    }

    /**
     * 认证管理配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /**
     * 网页请求配置
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/**", "/**/*.js", "/**/*.html");

    }
}
