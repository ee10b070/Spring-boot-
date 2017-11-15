package com.memorytest.test;


import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.memorytest.properties.Properties;
import com.memorytest.properties.ServerProperties;
import com.memorytest.service.FileUploadService;
import com.memorytest.serviceImpl.FileUploadServiceImpl;

@RestController
@EnableAutoConfiguration 
public class TestController {
	 private static final Logger LOGGER = Logger.getLogger(TestController.class);
	
	 @Autowired
	 Properties properties;
	 
	 @Autowired
     ServerProperties serverProperties;
	 @Autowired
	 FileUploadServiceImpl fileUploadService;
	 

@RequestMapping(value="/uploadFiles",method=RequestMethod.POST)
public @ResponseBody String uploadFiles(@RequestParam("file") MultipartFile[] files) {
	LOGGER.info(this.getClass().getName());
	String success="";
    if(files.length!=0) {
    	success=fileUploadService.uploadFile(files);
    }
	return success; 
}
	
}

