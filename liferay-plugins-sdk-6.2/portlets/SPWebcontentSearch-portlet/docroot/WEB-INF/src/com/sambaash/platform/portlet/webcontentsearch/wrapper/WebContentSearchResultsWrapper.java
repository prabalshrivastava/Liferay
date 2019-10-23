package com.sambaash.platform.portlet.webcontentsearch.wrapper;

public class WebContentSearchResultsWrapper {
	
	public String title;

	public String description;
	
	public String duration;
	
	public String durationType;
	
	public String size;
	
	public String type;
	
	public String specialization;
	
	public String link;
	
	public String logo;
	
	public String imageUrl;
	
	
	public WebContentSearchResultsWrapper() {
		super();
	}

	public WebContentSearchResultsWrapper(String title, String description, String duration, String durationType, String size, String type, String specialization, String link, String logo, String imageUrl) {
		super();
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.size = size;
		this.type = type;
		this.specialization = specialization;
		this.link = link;
		this.logo = logo;
		this.imageUrl = imageUrl;
		this.durationType = durationType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	
}
