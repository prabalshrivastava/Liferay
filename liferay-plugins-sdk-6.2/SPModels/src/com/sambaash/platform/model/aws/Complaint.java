package com.sambaash.platform.model.aws;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Complaint {

	@JsonProperty
	private String userAgent;

	@JsonProperty
	private String complaintFeedbackType;

	@JsonProperty
	private String arrivalDate;

	@JsonProperty
	private String timestamp;

	@JsonProperty
	private String feedbackId;

	@JsonProperty
	private List<ComplainedRecipients> complainedRecipients;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getComplaintFeedbackType() {
		return complaintFeedbackType;
	}

	public void setComplaintFeedbackType(String complaintFeedbackType) {
		this.complaintFeedbackType = complaintFeedbackType;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public List<ComplainedRecipients> getComplainedRecipients() {
		return complainedRecipients;
	}

	public void setComplainedRecipients(List<ComplainedRecipients> complainedRecipients) {
		this.complainedRecipients = complainedRecipients;
	}

	@Override
	public String toString() {
		return "Complaint [userAgent=" + userAgent + ", complaintFeedbackType=" + complaintFeedbackType
				+ ", arrivalDate=" + arrivalDate + ", timestamp=" + timestamp + ", feedbackId=" + feedbackId
				+ ", complainedRecipients="
				+ (complainedRecipients != null ? complainedRecipients() : complainedRecipients) + "]";
	}

	public String complainedRecipients() {
		StringBuffer sb = new StringBuffer();
		for (ComplainedRecipients recipients : complainedRecipients) {
			sb.append("\n ").append(recipients.toString());
		}
		return sb.toString();
	}

}
