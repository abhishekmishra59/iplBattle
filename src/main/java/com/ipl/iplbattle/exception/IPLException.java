package com.ipl.iplbattle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;

public class IPLException extends RuntimeException{
	private static final long serialVersionUID = 1L;
    private int errorCode = 0;
    private String errorDescription;
    private String errorMessage;
    private HttpStatus status;
    private StopWatch stopWatch;
    private String targetClass;
    private String targetMethod;
    
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public StopWatch getStopWatch() {
		return stopWatch;
	}
	public void setStopWatch(StopWatch stopWatch) {
		this.stopWatch = stopWatch;
	}
	
	public String getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public IPLException() {
		super();
	}
	public IPLException(int errorCode, String errorDescription, String errorMessage, HttpStatus status) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorMessage = errorMessage;
		this.status = status;
	}
	public IPLException(int errorCode, String errorDescription, String errorMessage, HttpStatus status,
			StopWatch stopWatch) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorMessage = errorMessage;
		this.status = status;
		this.stopWatch = stopWatch;
	}
	public IPLException(int errorCode, String errorDescription, String errorMessage, HttpStatus status,
			StopWatch stopWatch, String targetClass, String targetMethod) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorMessage = errorMessage;
		this.status = status;
		this.stopWatch = stopWatch;
		this.targetClass = targetClass;
		this.targetMethod = targetMethod;
	}
	
    
}
