package com.lidl.shopping.service.exceptions;

public class ErrorInfo {

    private String errorMessage;
    private String url;
    private Integer status;
    
    public ErrorInfo(int status, String url, String errorMessage) {
        this.status = status;
        this.url = url;
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
}
