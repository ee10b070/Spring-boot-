package com.memorytest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.memorytest.properties.ServerProperties;
import com.memorytest.test.AopConfiguration;


@SpringBootApplication
@ComponentScan("com.memorytest")
public class MemoryTestApplication implements CommandLineRunner {
	
	@Autowired
    private ServerProperties serverProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(MemoryTestApplication.class, args);	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);  
}
	@Override
	public void run(String... arg0) throws Exception {
	System.out.println(serverProperties);
	}
	
	}
