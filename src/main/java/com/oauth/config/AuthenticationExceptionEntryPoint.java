package com.oauth.config;

import com.oauth.util.BaiduResultUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**自定义Oauth2认证不通过的异常
 * @author ：zhangqiang
 * @create ：2019-01-30 13:32
 **/
@Component
public class AuthenticationExceptionEntryPoint implements AuthenticationEntryPoint {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationExceptionEntryPoint.class);
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, org.springframework.security.core.AuthenticationException e) throws IOException, ServletException {
		try {
			logger.info("不正确的token，拒绝请求！");
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			ObjectMapper mapper=new ObjectMapper();
			mapper.writeValue(response.getOutputStream(),BaiduResultUtil.NotLogin());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
