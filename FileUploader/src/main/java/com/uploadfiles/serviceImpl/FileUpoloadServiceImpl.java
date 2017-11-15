package com.uploadfiles.serviceImpl;

import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uploadfiles.FeignSpringFormEncoder;
import com.uploadfiles.controller.UploadController;
import com.uploadfiles.properties.Properties;
import com.uploadfiles.properties.ServerProperties;
import com.uploadfiles.service.FileUploadService;
import com.uploadfiles.service.VirusScanner;
import com.uploadfiles.model.Response;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.slf4j.Slf4jLogger;
import com.google.gson.JsonObject;

@Service
public class FileUpoloadServiceImpl implements FileUploadService {
	 private static final Logger LOGGER = Logger.getLogger(UploadController.class);
	 @Autowired
	 Properties properties;
	 @Autowired
	 ServerProperties serverproperties;
	 @Autowired
	 FeignSpringFormEncoder feinencoder;
	
	 @Override
     public Response uploadFile(MultipartFile[] files,String DocType) {
		Response response = new Response(); 
        String mainPath=serverproperties.getUrl()+File.separator+DocType;
        File dir = new File(mainPath);
        if(isDirExist(dir)) {
        	response=saveFilesToDirectory(files,mainPath);
        }else {
         	dir.mkdirs();
         	response=saveFilesToDirectory(files,mainPath);
        }
		return response;
	 }
	 public Response saveFilesToDirectory(MultipartFile[] files,String mainPath) {
		ArrayList<String> infectedFiles=new ArrayList<String>();
		Response response = new Response();
		boolean success=false;
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
		    try {
		    	int infect_count=VirusScan(file);
		    	if(infect_count==0) {
		    		byte[] bytes = file.getBytes();
			    	File newFile=new File(mainPath+File.separator+file.getOriginalFilename());
			    	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
			    	stream.write(bytes);
			    	success=true;
		    	}else {
		    		infectedFiles.add(file.getOriginalFilename());
		    		LOGGER.info("infected file "+file.getOriginalFilename());
		    	}
		    }catch(Exception e) {
		    	LOGGER.info(this.getClass().getName()+e.getMessage());
		    }
			}
		if(infectedFiles.size()!=0) {
			response.setData(infectedFiles);
			response.setSuccess(success);
			response.setStatusMessage(properties.getUploadPartialMessage());
		}else {
			response.setSuccess(success);
			response.setStatusMessage(properties.getUploadSuccessMessage());
		}
		return response;
	 }
	 
     public boolean isDirExist(File directory) {
    	boolean result=false;
    	if(directory.exists()) {
    		result=true;
    	}
    	return result;
     }
    
     public int VirusScan(MultipartFile file) {
    	String apikey=properties.getApikey();
    	//feign builder for file VirusScan
    	VirusScanner virusScanner = Feign.builder()
 	                               .encoder(feinencoder)
 	                               .decoder(new GsonDecoder())
 	                               .logger(new Slf4jLogger(VirusScanner.class))
 			                       .target(VirusScanner.class,properties.getVirusScanApi());
    	JsonObject response=virusScanner.virusScan(apikey,file);
        String resource=response.get("resource").getAsString();
        //feign builder for scanner report 
    	VirusScanner virusScannerReport = Feign.builder()
                                          .encoder(feinencoder) 
                                          .decoder(new GsonDecoder())
                                          .logger(new Slf4jLogger(VirusScanner.class))
	                                      .target(VirusScanner.class,properties.getVirusScanReportApi());
    	JsonObject responseReport=virusScannerReport.virusScanReport(apikey, resource);
    	LOGGER.info("responseReport "+responseReport);
    	return responseReport.get("positives").getAsInt();
     }
     
 
}