package com.sambaash.platform.portlet.spneo4j.wrapper;

public class CommentAddJsonWrapper {

	public CommentAddJsonWrapper(String html, String topicId) {
		this.html = html;
		this.topicId = topicId;
	}

	public String getHtml() {
		return html;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	private String html;
	private String topicId;

}