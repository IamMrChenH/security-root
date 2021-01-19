package org.iammrchenh.infrastructure.security.login.service;

import org.iammrchenh.infrastructure.security.common.basic.AuthorityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author chenh
 * @date 2021/1/19
 */
@Service
public class DefaultLoginUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return new AuthorityUser("admin", passwordEncoder.encode("123456"), new ArrayList<>());
        }
        return null;
    }
}
