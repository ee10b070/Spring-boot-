package com.memorytest.serviceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.memorytest.properties.Properties;
import com.memorytest.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	 @Autowired
	 Properties properties;
	
	@Override
    public String uploadFile(MultipartFile[] files) {
      Long limit=properties.getFileSize();
      String success="";  
      for (int i = 0; i < files.length; i++) {
	       MultipartFile file = files[i];
	       String fileName = file.getOriginalFilename();
	       if(file.getSize() < limit) {
	         try {
		       byte[] bytes = file.getBytes();
	           String mainPath=properties.getFilePath();
	           File dir = new File(mainPath);
		       if(!dir.exists()) {
			   dir.mkdirs();
		     }
		  File newFile=new File(mainPath+File.separator+fileName);
		  BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
			stream.write(bytes);
			stream.close();
			
			success=properties.getUploadSuccessMessage();
	}catch(Exception e){
		success=properties.getUploadErrorMessage()+e.getMessage();
	}
	}else {
		throw new MaxUploadSizeExceededException(limit);
	
	}	
}
		return success;
	}
}



