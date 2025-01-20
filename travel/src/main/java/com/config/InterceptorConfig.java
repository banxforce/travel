package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{
	
	@Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
        super.addInterceptors(registry);
	}
	
	/**
	 * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 将 /lvyouwangzhan/** 请求映射到 static 目录下
		registry.addResourceHandler("/lvyouwangzhan/**")
				.addResourceLocations("classpath:/static/");  // 根据你存放静态资源的目录调整路径

		// 配置其他静态资源路径
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/resources/")
				.addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/admin/")
				.addResourceLocations("classpath:/img/")
				.addResourceLocations("classpath:/front/")
				.addResourceLocations("classpath:/public/");

		super.addResourceHandlers(registry);
	}

}
