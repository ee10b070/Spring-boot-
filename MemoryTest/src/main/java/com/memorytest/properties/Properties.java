package com.memorytest.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	@Value("${File_Path}")
	private String filePath;
	
	@Value("${max-file-size}")
	private Long fileSize;
	
	@Value("${upload_success_message}")
	private String uploadSuccessMessage;
	
	@Value("${upload_error_message}")
	private String uploadErrorMessage;
	
	

	public String getUploadSuccessMessage() {
		return uploadSuccessMessage;
	}

	public void setUploadSuccessMessage(String uploadSuccessMessage) {
		this.uploadSuccessMessage = uploadSuccessMessage;
	}

	public String getUploadErrorMessage() {
		return uploadErrorMessage;
	}

	public void setUploadErrorMessage(String uploadErrorMessage) {
		this.uploadErrorMessage = uploadErrorMessage;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
}
