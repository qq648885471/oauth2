package com.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
    @Autowired
    private BootUserDetailService userDetailService;
    @Autowired
    private SmscodeProvider smscodeProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().and()
//                .requestMatchers()
//                .antMatchers("/login","/oauth/authorize","/re")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
        http
                .requestMatchers()
                .antMatchers("/login","/oauth/authorize","/re")
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and().formLogin()
                .loginPage("自定义")//登录页面
                .loginProcessingUrl("自定义") //登录处理页面
                .and()
                .httpBasic()
                .disable()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //账号密码
//        auth.userDetailsService(userDetailService);
        auth.authenticationProvider(smscodeProvider);//短信验证码形式
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
