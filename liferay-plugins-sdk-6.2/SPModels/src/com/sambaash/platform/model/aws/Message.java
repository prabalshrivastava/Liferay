package com.sambaash.platform.model.aws;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	@JsonProperty
	private Mail mail;

	@JsonProperty
	private String notificationType;

	@JsonProperty
	private Bounce bounce;

	@JsonProperty
	private Complaint complaint;

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public Bounce getBounce() {
		return bounce;
	}

	public void setBounce(Bounce bounce) {
		this.bounce = bounce;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	@Override
	public String toString() {
		return "Message [ \n mail=" + (mail != null ? mail.toString() : mail) + ",  \n notificationType="
				+ notificationType + ",  \n bounce=" + (bounce != null ? bounce.toString() : bounce)
				+ ",  \n complaint=" + (complaint != null ? complaint.toString() : complaint) + " \n ]";
	}

}
