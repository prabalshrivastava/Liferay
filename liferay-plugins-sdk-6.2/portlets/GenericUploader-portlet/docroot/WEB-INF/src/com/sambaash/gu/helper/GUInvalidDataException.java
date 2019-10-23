package com.sambaash.gu.helper;

public class GUInvalidDataException extends GUException{
	public GUInvalidDataException(){
		super();
	}
	public GUInvalidDataException(String msg){
		super(msg);
	}
	
	public String getMsg(){
		return super.getMsg();
	}
}
