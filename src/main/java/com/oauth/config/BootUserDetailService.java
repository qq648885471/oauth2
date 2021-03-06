package com.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootUserDetailService implements UserDetailsService {
//    @Autowired
//    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);


        User user=new User(username,passwordEncoder.encode(username),authorities);
        if(user==null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
