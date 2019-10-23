package com.sambaash.platform.model;

public class StrartupProfileBean {
	private String name;
	private String shortName;
	private String description;
	private String detailsUrl;
	private String editUrl;
	private String imageUrl;
	private long startupProfileId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetailsUrl() {
		return detailsUrl;
	}
	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}
	public String getEditUrl() {
		return editUrl;
	}
	public void setEditUrl(String editUrl) {
		this.editUrl = editUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getStartupProfileId() {
		return startupProfileId;
	}
	public void setStartupProfileId(long startupProfileId) {
		this.startupProfileId = startupProfileId;
	}
}
