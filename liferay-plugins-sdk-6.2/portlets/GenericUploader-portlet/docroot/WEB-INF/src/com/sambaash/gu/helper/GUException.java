package com.sambaash.gu.helper;

public class GUException extends Exception {
	private String msg;
	public GUException(){
		
	}
	public GUException(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg;
	}
}
