package com.sambaash.platform.pe.exception;

import com.sambaash.platform.pe.PEError;
public class PEException extends Exception {

	public PEException(PEError error, Throwable cause) {
		super(cause);
		this.error = error;
	}
	public PEException(PEError error ) {
		this.error = error;
	}
	
	public PEException(String msg){
		this.customMsg = msg;
		error = PEError.createError(msg);
	}

	public PEError getError() {
		return error;
	}
	
	private String customMsg;
	private PEError error;

	public String getMsg() {
		return customMsg;
	}

}