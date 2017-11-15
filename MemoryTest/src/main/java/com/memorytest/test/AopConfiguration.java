package com.memorytest.test;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.JamonPerformanceMonitorInterceptor;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.memorytest.properties.Properties;
import com.memorytest.properties.ServerProperties;


import java.time.LocalDate;
import java.time.Month;
@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {
	     private static final Logger LOGGER = Logger.getLogger(AopConfiguration.class);
	
	    @Pointcut("execution(public String com.memorytest.test.PersonService.getFullName(..))")
	    public void monitor() {
	    	LOGGER.info(this.getClass().getName()+"-->>incide monitor");
	    }
	    
	    @Pointcut("execution(public int com.memorytest.test.PersonService.getAge(..))")
	    public void myMonitor() {
	    	LOGGER.info(this.getClass().getName()+"-->>incide myMonitor");
	    }
	    
	    @Pointcut("execution(public int com.memorytest.test.PersonService.getNameAge(..))")
	    public void myMonitor1() {
	    	LOGGER.info(this.getClass().getName()+"-->>incide myMonitor1");
	    }
	 
	    @Bean
	    public Person person(){
	        return new Person("John","Smith", LocalDate.of(1980, Month.JANUARY, 12));
	    }
	    
	    
	   @Bean
	    public JamonPerformanceMonitorInterceptor  jamonPerformanceMonitorInterceptor() {
	        return new JamonPerformanceMonitorInterceptor(true); 
	    }
	    
	    @Bean
	    public PerformanceMonitorInterceptor  performanceMonitorInterceptor() {
	        return new PerformanceMonitorInterceptor(true);
	    }

	    @Bean
	    public Advisor performanceMonitorAdvisor() {
	    	LOGGER.trace(this.getClass().getName()+"-->>incide advisor");
	        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	        pointcut.setExpression("com.memorytest.test.AopConfiguration.monitor()");
	        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
	    }
	    
	  
	    @Bean
	    public PersonService personService(){
	        return new PersonService();
	    }
	    
	    @Bean
	    public MyPerformanceMonitorInterceptor myPerformanceMonitorInterceptor() {
	        return new MyPerformanceMonitorInterceptor(true);
	    }
	    
	    @Bean
	    public Advisor myPerformanceMonitorAdvisor( PerformanceMonitorInterceptor performanceMonitorInterceptor) {
	        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	        pointcut.setExpression("com.memorytest.test.AopConfiguration.myMonitor()");
	        return new DefaultPointcutAdvisor(pointcut, myPerformanceMonitorInterceptor());
	    }
	    
	    @Bean
	    public Advisor myjamonPerformanceMonitorAdvisor() {
	        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	        pointcut.setExpression("com.memorytest.test.AopConfiguration.myMonitor1()");
	        return new DefaultPointcutAdvisor(pointcut, jamonPerformanceMonitorInterceptor());
	    }    
	   @Bean
	    public ServerProperties ServerProperties(){
	        return new ServerProperties();
	    }
	
    
}
