package com.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**全局请求过滤
 * @author ：zhangqiang
 * @create ：2018-08-16 16:27
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

//	@Autowired
//	private OpenServerInterceptor openServerInterceptor;
//
//	private final String[] excludePathPatterns=new String[]{"/","/server","/active","/test/**","/oauth/authorize"};
//
	//重写WebMvcConfigurationSupport类下的支持跨域方法
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("*")
				.maxAge(60*60);
	}
//
//	@Override
//	protected void addInterceptors(InterceptorRegistry registry) {
//		//过滤所有的请求，只排除例外
//		registry.addInterceptor(openServerInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
//	}

	/**
	 * springBoot2.0 之后的资源文件必须配置，否则无法访问静态资源
	 * @param registry
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("classpath:/resources/")
				.addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/public/");
		super.addResourceHandlers(registry);
	}
}
