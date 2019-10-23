package com.sambaash.platform.portlet.advancedsearch.wrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ASWrapper implements Serializable {

	public ASWrapper() {
	}

	public ASWrapper(String title, String detailUrl, String content, String image, String author, String profileUrl, Date modifiedDate, String displayDate) {
		this.title = title;
		this.detailUrl = detailUrl;
		this.content = content;
		this.image = image;
		this.author = author;
		this.profileUrl = profileUrl;
		this.modifiedDate = modifiedDate;
		this.displayDate = displayDate;
	}

	public ASWrapper(String title, String detailUrl, String content, String image, String author, String profileUrl, Date modifiedDate, String displayDate, boolean active, long classPK) {
		this.title = title;
		this.detailUrl = detailUrl;
		this.content = content;
		this.image = image;
		this.author = author;
		this.profileUrl = profileUrl;
		this.modifiedDate = modifiedDate;
		this.displayDate = displayDate;
		this.active = active;
		this.classPK = classPK;
	}

	public ASWrapper(String title, String detailUrl, String content, String image, String author, String profileUrl, Date modifiedDate, String displayDate,
			List<SPDiscussionWrapper> spDiscussionWrappers) {
		this.title = title;
		this.detailUrl = detailUrl;
		this.content = content;
		this.image = image;
		this.author = author;
		this.profileUrl = profileUrl;
		this.modifiedDate = modifiedDate;
		this.displayDate = displayDate;
		this.spDiscussionWrappers = spDiscussionWrappers;
	}

	public String getAuthor() {
		return author;
	}

	public long getClassPK() {
		return classPK;
	}

	public String getContent() {
		return content;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public String getImage() {
		return image;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public List<SPDiscussionWrapper> getSpDiscussionWrappers() {
		return spDiscussionWrappers;
	}

	public String getTitle() {
		return title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public void setSpDiscussionWrappers(
			List<SPDiscussionWrapper> spDiscussionWrappers) {
		this.spDiscussionWrappers = spDiscussionWrappers;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private static final long serialVersionUID = 1L;

	private boolean active;
	private String author;
	private long classPK;
	private String content;
	private String detailUrl;
	private String displayDate;
	private String image;
	private Date modifiedDate;
	private String profileUrl;
	private List<SPDiscussionWrapper> spDiscussionWrappers = new ArrayList<SPDiscussionWrapper>();
	private String title;

}