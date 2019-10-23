package com.sambaash.platform.model.aws;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mail {

	@JsonProperty
	private String timestamp;
	
	private String source;
	
	@JsonProperty
	private String messageId;
	
	@JsonProperty
	private String [] destination;

	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSource() {
		return source;
	}

	
	public void setSource(String source) {
		this.source = source;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String [] getDestination() {
		return destination;
	}

	public void setDestination(String [] destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Mail [timestamp=" + timestamp + ", source=" + source + ", messageId=" + messageId + ", destination="
				+ Arrays.toString(destination) + "]";
	}

	
	
}
