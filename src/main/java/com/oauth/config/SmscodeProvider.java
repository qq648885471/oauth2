package com.oauth.config;

import com.alibaba.fastjson.JSONObject;
import com.oauth.service.SmscodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhangqiang
 * @create ：2019-01-23 16:23
 **/
@Component
public class SmscodeProvider implements AuthenticationProvider {
	private static final Logger logger = LoggerFactory.getLogger(SmscodeProvider.class);
	@Autowired
	private SmscodeService smscodeService;


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		logger.info("自定义的Credentials={}",JSONObject.toJSONString(authentication.getCredentials()));
		String mobile=authentication.getName();
		String code=authentication.getCredentials().toString();
		logger.info("账号：{}，密码：{}",mobile,code);

		if(!smscodeService.checkSmscode(mobile,code)) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		//手机号作为账号 加密后的手机号作为密码
		return new UsernamePasswordAuthenticationToken(mobile,new BCryptPasswordEncoder().encode(mobile),authorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}
}
