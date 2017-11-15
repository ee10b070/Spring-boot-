package com.uploadfiles.service;

import org.springframework.web.multipart.MultipartFile;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import com.google.gson.JsonObject;

public interface VirusScanner {	
	 @RequestLine("POST")
	 @Headers("Content-Type: multipart/form-data")
	 JsonObject virusScan(@Param("apikey") String apikey,@Param("file") MultipartFile file);
	 
	 @RequestLine("GET")
	 @Headers("Content-Type: multipart/form-data")
	 JsonObject virusScanReport(@Param("apikey") String apikey,@Param("resource") String resource);

}
