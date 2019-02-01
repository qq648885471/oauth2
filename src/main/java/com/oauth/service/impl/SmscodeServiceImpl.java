package com.oauth.service.impl;

import com.oauth.service.SmscodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author ：zhangqiang
 * @create ：2019-01-23 16:26
 **/
@Service
public class SmscodeServiceImpl implements SmscodeService {
	private static final Logger logger = LoggerFactory.getLogger(SmscodeServiceImpl.class);
	@Value("${goodfather.send_code}")
	private String GOODFATHER_SEND_CODE_URL;
	@Value("${goodfather.register}")
	private String GOODFATHER_REGISTER_URL;


	@Override
	public String sendSmscode(String mobile) {
		logger.info("手机号码：{} 开始获取验证码", mobile);
		//发验证码逻辑 省略。。。
		return "验证码发送成功";
	}

	@Override
	public boolean checkSmscode(String mobile, String code) {
		logger.info("手机号码：{} 短信验证码：{}", mobile, code);
		//验证逻辑自定义
		return "123".equals(code);
	}
}
