package com.sambaash.platform.model.aws;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bounce {

	@JsonProperty
	private String timestamp;

	@JsonProperty
	private String reportingMTA;

	@JsonProperty
	private String bounceSubType;

	@JsonProperty
	private String feedbackId;

	@JsonProperty
	private String bounceType;

	@JsonProperty
	private List<BouncedRecipients> bouncedRecipients;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getReportingMTA() {
		return reportingMTA;
	}

	public void setReportingMTA(String reportingMTA) {
		this.reportingMTA = reportingMTA;
	}

	public String getBounceSubType() {
		return bounceSubType;
	}

	public void setBounceSubType(String bounceSubType) {
		this.bounceSubType = bounceSubType;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getBounceType() {
		return bounceType;
	}

	public void setBounceType(String bounceType) {
		this.bounceType = bounceType;
	}

	public List<BouncedRecipients> getBouncedRecipients() {
		return bouncedRecipients;
	}

	public void setBouncedRecipients(List<BouncedRecipients> bouncedRecipients) {
		this.bouncedRecipients = bouncedRecipients;
	}

	@Override
	public String toString() {
		return "Bounce [timestamp=" + timestamp + ", reportingMTA=" + reportingMTA + ", bounceSubType=" + bounceSubType
				+ ", feedbackId=" + feedbackId + ", bounceType=" + bounceType + ", bouncedRecipients="
				+ (bouncedRecipients != null ? bouncedRecipients() : bouncedRecipients) + "]";
	}

	public String bouncedRecipients() {
		StringBuffer sb = new StringBuffer();
		for (BouncedRecipients recipients : bouncedRecipients) {
			sb.append("\n ").append(recipients.toString());
		}
		return sb.toString();
	}

}
