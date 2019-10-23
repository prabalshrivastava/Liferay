package com.sambaash.platform.model.notification;


public class NotificationImpl implements Notification {


	private String status;
	private String subject;
	private String content;

	private String detailLink;
	private String msgDetailId;


	public String getMsgDetailId() {
		return msgDetailId;
	}
	public void setMsgDetailId(String msgDetailId) {
		this.msgDetailId = msgDetailId;
	}
	public String getDetailLink() {
		return detailLink;
	}
	public void setDetailLink(String detailLink) {
		this.detailLink = detailLink;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
