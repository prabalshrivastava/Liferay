package com.sambaash.platform.model.aws;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SNS {

	@JsonProperty("MessageId")
	private String messageId;

	@JsonProperty("SigningCertURL")
	private String signingCertURL;

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("SignatureVersion")
	private String signatureVersion;

	@JsonProperty("Signature")
	private String signature;

	@JsonProperty("Timestamp")
	private String timestamp;

	@JsonProperty("TopicArn")
	private String topicArn;

	@JsonProperty("SubscribeURL")
	private String subscribeURL;

	@JsonProperty("UnsubscribeURL")
	private String unsubscribeURL;

	public String getMessageId() {
		return messageId;
	}

	public String getSigningCertURL() {
		return signingCertURL;
	}

	public void setSigningCertURL(String signingCertURL) {
		this.signingCertURL = signingCertURL;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSignatureVersion() {
		return signatureVersion;
	}

	public void setSignatureVersion(String signatureVersion) {
		this.signatureVersion = signatureVersion;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTopicArn() {
		return topicArn;
	}

	public void setTopicArn(String topicArn) {
		this.topicArn = topicArn;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSubscribeURL() {
		return subscribeURL;
	}

	public void setSubscribeURL(String subscribeURL) {
		this.subscribeURL = subscribeURL;
	}

	public String getUnsubscribeURL() {
		return unsubscribeURL;
	}

	public void setUnsubscribeURL(String unsubscribeURL) {
		this.unsubscribeURL = unsubscribeURL;
	}

	@Override
	public String toString() {
		return "SNS [messageId=" + messageId + ", signingCertURL=" + signingCertURL + ", message=" + message
				+ ", type=" + type + ", signatureVersion=" + signatureVersion + ", signature=" + signature
				+ ", timestamp=" + timestamp + ", topicArn=" + topicArn + ", subscribeURL=" + subscribeURL
				+ ", unsubscribeURL=" + unsubscribeURL + "]";
	}

}
