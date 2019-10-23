package com.sambaash.platform.portlet.advancedsearch.wrapper;

import java.io.Serializable;
public class SPDiscussionWrapper implements Serializable {

	public SPDiscussionWrapper() {
	}

	public SPDiscussionWrapper(String title, String detailUrl, String content) {
		this.title = title;
		this.detailUrl = detailUrl;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private static final long serialVersionUID = 1L;

	private String content;
	private String detailUrl;
	private String title;

}