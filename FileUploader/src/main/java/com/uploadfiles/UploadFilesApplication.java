package com.uploadfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.uploadfiles.config.AppConfiguration;

@SpringBootApplication
public class UploadFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadFilesApplication.class, args);
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);  
	}
}
