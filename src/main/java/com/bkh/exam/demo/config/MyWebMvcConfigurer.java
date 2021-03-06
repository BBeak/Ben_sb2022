package com.bkh.exam.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bkh.exam.demo.interceptor.BeforeActionInterceptor;
import com.bkh.exam.demo.interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	// beforeActionInterceptor 불러오기
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	
	// needLoginInterceptor 불러오기
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;

	// 이 함수는 인터셉터를 적용하는 역할을 합니다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource")
				.excludePathPatterns("/error");

		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/write")
				.addPathPatterns("/usr/article/dowrite").addPathPatterns("/usr/article/modify")
				.addPathPatterns("/usr/article/doModify").addPathPatterns("/usr/article/doDelete");

	}
}