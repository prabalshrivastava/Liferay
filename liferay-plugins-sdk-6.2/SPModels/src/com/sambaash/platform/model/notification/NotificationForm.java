package com.sambaash.platform.model.notification;

import java.util.List;


public class NotificationForm {


	private String status;
	private String communityName;
	private String subject;
	private String content;
	private String detailLink;
	private String msgDetailId;
	private String from;
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	private String target;
	
	
	private List<String> receivers;

	public NotificationForm(){
		
	}

	public NotificationForm(String status,String communityName,String subject,String content,String detailLink,String msgDetailId,List<String>receivers){
		this.status = status;
		this.communityName = communityName;
		this.subject = subject;
		this.content = content;
		this.detailLink = detailLink;
		this.msgDetailId = msgDetailId;
		this.receivers = receivers;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public List<String> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
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

	public String getMsgDetailId() {
		return msgDetailId;
	}

	public void setMsgDetailId(String msgDetailId) {
		this.msgDetailId = msgDetailId;
	}
	
	
}
