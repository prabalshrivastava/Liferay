package com.sambaash.platform.portlet.spneo4j.wrapper;

public class CommentReplyJsonWrapper {

	public CommentReplyJsonWrapper(String html, String topicId, String parentId) {
		this.html = html;
		this.topicId = topicId;
		this.parentId = parentId;
	}

	public String getHtml() {
		return html;
	}

	public String getParentId() {
		return parentId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	private String html;
	private String parentId;
	private String topicId;

}