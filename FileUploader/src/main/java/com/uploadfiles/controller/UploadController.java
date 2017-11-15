package com.uploadfiles.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.uploadfiles.model.Response;
import com.uploadfiles.properties.Properties;
import com.uploadfiles.properties.ServerProperties;
import com.uploadfiles.serviceImpl.FileUpoloadServiceImpl;


@RestController
public class UploadController {
	 private static final Logger LOGGER = Logger.getLogger(UploadController.class);
	 @Autowired
	 Properties properties;
	 @Autowired
	 FileUpoloadServiceImpl fileUploadService;
	 @Autowired
	 ServerProperties serverproperties;
	 @RequestMapping(value="/uploadFiles",method=RequestMethod.POST)
	 public @ResponseBody Response uploadfiles(@RequestParam("file") MultipartFile[] files,@RequestParam("type") String DocType) throws IOException {
	 	 LOGGER.info(this.getClass().getName());
	     Response response = new Response();
	     LOGGER.info(files.length);
	     if(files.length!=0) {
	    	 response=fileUploadService.uploadFile(files,DocType);
	     }else {
	    	 response.setStatusMessage(properties.getFilesEmptyMessage());
	     }
	 	return response;    
	 }
}
