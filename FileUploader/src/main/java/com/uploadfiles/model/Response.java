package com.uploadfiles.model;

public class Response {
	private String statusMessage;
    private boolean success;
    private Object data;
    
    public Response() { 
    }
	public Response(String statusMessage, boolean success) {
		this.statusMessage = statusMessage;
		this.success = success;
	
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String successMessage) {
		this.statusMessage = successMessage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}


	
}
