package com.uploadfiles.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.JamonPerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.uploadfiles.properties.ServerProperties;


@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AppConfiguration {
	 private static final Logger LOGGER = Logger.getLogger(AppConfiguration.class);
	 @Bean
	 public ServerProperties ServerProperties(){
	        return new ServerProperties();
	 }
	 @Pointcut("within(com.uploadfiles.serviceImpl..*)") 
	 public void performanceMonitor() {
	 }
	 @Bean
	 public JamonPerformanceMonitorInterceptor  jamonPerformanceMonitorInterceptor() {
	        return new JamonPerformanceMonitorInterceptor(true);   
	 }
	 @Bean
     public Advisor performanceAdvisor() {
	  LOGGER.trace("performanceAdvisor() called" );
      AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
      pointcut.setExpression("within(com.uploadfiles.config..*)");
      return new DefaultPointcutAdvisor(pointcut, jamonPerformanceMonitorInterceptor());
     }
}
