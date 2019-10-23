package com.sambaash.platform.portlet.spneo4j.wrapper;

public class CommentJsonWrapper {

	public CommentJsonWrapper(String html) {
		this.html = html;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	private String html;

}