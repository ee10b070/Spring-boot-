package com.uploadfiles.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	@Value("${File_Path}")
	private String filePath;
	
	/*@Value("${max-file-size}")
	private Long fileSize;*/
	
	@Value("${upload_success_message}")
	private String uploadSuccessMessage;
	
	@Value("${upload_error_message}")
	private String uploadErrorMessage;
	
	@Value("${spring.profiles.active}")
	private String ActiveProfile;

	@Value("${files_empty_message}")
	private String filesEmptyMessage;
	
	@Value("${upload_partial_message}")
	private String uploadPartialMessage;
	
	@Value("${Virus_scan_api}")
	private String VirusScanApi;

	@Value("${apikey}")
	private String apikey;
	
	@Value("${Virus_scan_report_api}")
	private String VirusScanReportApi;
	

	public String getUploadPartialMessage() {
		return uploadPartialMessage;
	}

	public void setUploadPartialMessage(String uploadPartialMessage) {
		this.uploadPartialMessage = uploadPartialMessage;
	}
	
	public String getVirusScanReportApi() {
		return VirusScanReportApi; 
	}

	public void setVirusScanReportApi(String virusScanReportApi) {
		VirusScanReportApi = virusScanReportApi;
	}

	public String getVirusScanApi() {
		return VirusScanApi;
	}

	public void setVirusScanApi(String virusScanApi) {
		VirusScanApi = virusScanApi;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getFilesEmptyMessage() {
		return filesEmptyMessage;
	}

	public void setFilesEmptyMessage(String filesEmptyMessage) {
		this.filesEmptyMessage = filesEmptyMessage;
	}

	public String getActiveProfile() {
		return ActiveProfile;
	}

	public void setActiveProfile(String activeProfile) {
		ActiveProfile = activeProfile;
	}

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

	/*public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}*/

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
}
