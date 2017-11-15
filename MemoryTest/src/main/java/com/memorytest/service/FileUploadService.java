package com.memorytest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public String uploadFile(MultipartFile[] file);

}
