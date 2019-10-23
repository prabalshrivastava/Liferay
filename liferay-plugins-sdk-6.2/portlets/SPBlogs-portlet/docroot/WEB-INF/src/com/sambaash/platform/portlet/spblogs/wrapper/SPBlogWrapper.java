package com.sambaash.platform.portlet.spblogs.wrapper;

import java.util.Date;
public class SPBlogWrapper {

	private long entryId;
	private String title;
	private String content;
	private String description;
	private String author;
	private String displayDateString;
	private String imageUrl;
	private String detailUrl;
	private Date displayDate;
	private String timeDifference;
	private String urlTitle;

	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getDisplayDateString() {
		return displayDateString;
	}

	public void setDisplayDateString(String displayDateString) {
		this.displayDateString = displayDateString;
	}

	public Date getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}

	public String getTimeDifference() {
		return timeDifference;
	}

	public void setTimeDifference(String timeDifference) {
		this.timeDifference = timeDifference;
	}

	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof SPBlogWrapper) {
			if ((new Long(entryId)).compareTo(((SPBlogWrapper) obj).getEntryId()) == 0) {
				return true;
			}
		}

		return false;
	}

}
