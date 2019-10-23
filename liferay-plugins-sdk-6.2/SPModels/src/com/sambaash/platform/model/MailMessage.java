package com.sambaash.platform.model;

import java.util.ArrayList;
import java.util.List;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import sun.org.mozilla.javascript.internal.json.JsonParser;

public class MailMessage {

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	public String getHtmlBody() {
		return htmlBody;
	}

	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public List<FileAttachment> getFileAttachments() {
		return fileAttachments;
	}

	public void setFileAttachments(List<FileAttachment> fileAttachments) {
		this.fileAttachments = fileAttachments;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public boolean isHtmlFormat() {
		return htmlFormat;
	}

	public void setHtmlFormat(boolean htmlFormat) {
		this.htmlFormat = htmlFormat;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}
	
	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public boolean isMultiPart() {
		return multiPart;
	}

	public void setMultiPart(boolean multiPart) {
		this.multiPart = multiPart;
	}

	@Override
	public String toString() {
		
		JSONObject mailMessage = JSONFactoryUtil.createJSONObject();
		mailMessage.put("textBody", textBody);
		mailMessage.put("htmlBody", htmlBody);
		mailMessage.put("companyId", companyId);
		mailMessage.put("fileAttachments", fileAttachments.toString());
		mailMessage.put("fromAddress", fromAddress);
		mailMessage.put("fromName", fromName);
		
		mailMessage.put("htmlFormat", htmlFormat);
		mailMessage.put("mailId", mailId);
		mailMessage.put("subject", subject);
		
		mailMessage.put("userId", userId);
		mailMessage.put("toAddress", toAddress);
		mailMessage.put("bccAddress", bccAddress);
		mailMessage.put("ccAddress", ccAddress);
		mailMessage.put("multiPart", multiPart);
		
		return mailMessage.toString();
		/*
		return "MailMessage [textBody=" + textBody + ", htmlBody=" + htmlBody + ", companyId=" + companyId
				+ ", fileAttachments=" + fileAttachments + ", fromAddress=" + fromAddress + ", fromName=" + fromName
				+ ", htmlFormat=" + htmlFormat + ", mailId=" + mailId + ", subject=" + subject + ", userId=" + userId
				+ ", toAddress=" + toAddress + ", bccAddress=" + bccAddress+ ", ccAddress=" + ccAddress+ ", multiPart=" + multiPart + "]";
				
		*/
	}

	protected String textBody;
	protected String htmlBody;
	protected long companyId;
	protected List<FileAttachment> fileAttachments = new ArrayList<FileAttachment>();
	protected String fromAddress;
	protected String fromName;
	protected boolean htmlFormat;
	protected String mailId;
	protected String subject;
	protected long userId;
	protected String toAddress;
	protected String bccAddress;
	protected String ccAddress;
	protected boolean multiPart;

}
