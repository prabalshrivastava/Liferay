package com.sambaash.platform.model.notification;

public interface Notification {
	
	String getStatus();
	String getSubject();
	String getContent();
	String getDetailLink();
	String getMsgDetailId();
	
	void setStatus(String status);
	void setSubject(String subject);
	void setContent(String content);
	void setDetailLink(String detailLink);
	void setMsgDetailId(String msgDetailId);
}
