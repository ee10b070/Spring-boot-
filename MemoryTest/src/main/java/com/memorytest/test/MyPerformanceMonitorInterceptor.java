package com.memorytest.test;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

import java.util.Date;

@Aspect
public class MyPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {
    

	public MyPerformanceMonitorInterceptor() {
    }
    public MyPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
}
  
    private static final Logger LOGGER = Logger.getLogger(MyPerformanceMonitorInterceptor.class);

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log log) throws Throwable {
        
        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        LOGGER.trace("Method "+name+" execution started at:"+new Date());
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            LOGGER.trace("Method "+name+" execution lasted:"+time+" ms");
            LOGGER.trace("Method "+name+" execution ended at:"+new Date());
           
            if (time > 10){
            	LOGGER.warn("Method execution longer than 10 ms!");
            }
            
        }
    }
}
