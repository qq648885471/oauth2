package com.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：zhangqiang
 * @create ：2019-01-25 17:30
 **/
@Controller
public class LoginController {

	//重定向到自定义登录页面
	@GetMapping("/auth/login")
	public String loginPage(){
		return "index";
	}
}
