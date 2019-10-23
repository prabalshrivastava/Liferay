package com.sambaash.platform.pe;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PEError implements Cloneable {
	
	private static Log _log = LogFactoryUtil.getLog(PEError.class);

	private String msg = StringPool.BLANK;
	private String msgDesc = StringPool.BLANK;
	private long code;
	private Throwable error;
	
	
	public PEError(String msg){
		this.msg = msg;
	}
	
	public PEError(long code){
		this.code = code;
	}
	public PEError(String msg,long code){
		this.code = code;
		this.msg = msg;
	}
	
	public PEError(String msg,String msgDesc,long code){
		this.code = code;
		this.msg = msg;
		this.msgDesc = msgDesc;
	}
	
	public PEError(Throwable error){
		this.error = error;
	}
	
	public PEError(){
		
	}
	
	public static PEError createError(String msg){
		return new PEError(msg);
	}
	public static PEError createError(Throwable throwable){
		return new PEError(throwable.getMessage());
	}
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public Throwable getError() {
		return error;
	}
	public void setError(Throwable error) {
		this.error = error;
	}
	
	public String toString(){
		String format = "%s - %s";
		return String.format(format,code,msg);
	}
	
	public PEError clone(){
		try {
			return (PEError) super.clone();
		} catch (CloneNotSupportedException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public String getMsgDesc() {
		return msgDesc;
	}
	public void setMsgDesc(String desc) {
		this.msgDesc = desc;
	}
}
