package com.uploadfiles.service;

import org.springframework.web.multipart.MultipartFile;
import com.uploadfiles.model.Response;
public interface FileUploadService {
	public Response uploadFile(MultipartFile[] file,String DocType);
}
