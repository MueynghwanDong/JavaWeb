package com.ssafy.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ssafy.pms.controller.MainController;

@Configuration // 자바 환경 설정
//<context:component-scan base-package="com.ssafy.pms.controller"/> 
@ComponentScan(basePackageClasses = { MainController.class }) // 클래스가 속해있는 패키지를 찾는 것
//<mvc:annotation-driven />
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
//	<mvc:resources location="/resources/" 	mapping="/**"/>

//	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//    <property name="prefix" value="/"/>
//    <property name="suffix" value=".jsp"/>
//</bean>
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
