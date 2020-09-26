package com.ipl.iplbattle.advice;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseMsg.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseMsg {

    /** The error code. */
    private int errorCode;
    
    /** The message. */
    private String message;
    
    /** The return status. */
    @JsonProperty("status")
    private String status;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResponseMsg(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public ResponseMsg(int errorCode, String message, String status) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.status = status;
	}

	public ResponseMsg() {
		super();
	}
    
    


}
