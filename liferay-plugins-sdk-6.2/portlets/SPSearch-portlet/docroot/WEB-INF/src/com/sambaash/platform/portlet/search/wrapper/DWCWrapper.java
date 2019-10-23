package com.sambaash.platform.portlet.search.wrapper;

import java.io.Serializable;

import java.util.Date;

public class DWCWrapper implements Serializable{

	private static final long serialVersionUID = -7395844884040388673L;

	private String title;

	private String detailUrl;

	private String content;

	private String image;

	private String author;

	private String profileUrl;

	private Date modifiedDate;

	private String displayDate;

	public DWCWrapper() {

	}

	public DWCWrapper(String title, String detailUrl,
			String content, String image, String author, String profileUrl,
			Date modifiedDate, String displayDate) {
		this.title = title;
		this.detailUrl = detailUrl;
		this.content = content;
		this.image = image;
		this.author = author;
		this.profileUrl = profileUrl;
		this.modifiedDate = modifiedDate;
		this.displayDate = displayDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

}
