package com.sambaash.platform.model.aws;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BouncedRecipients {

	@JsonProperty
	private String diagnosticCode;

	@JsonProperty
	private String status;

	@JsonProperty
	private String action;

	@JsonProperty
	private String emailAddress;

	public String getDiagnosticCode() {
		return diagnosticCode;
	}

	public void setDiagnosticCode(String diagnosticCode) {
		this.diagnosticCode = diagnosticCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "BouncedRecipients [diagnosticCode=" + diagnosticCode + ", status=" + status + ", action=" + action
				+ ", emailAddress=" + emailAddress + "]";
	}

}
