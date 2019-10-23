package com.sambaash.platform.portlet.upcomingevents.wrapper;

public class UpcomingEventsWrapper {
	
	public String title;

	public String description;

	public String url;

	public UpcomingEventsWrapper() {
		super();
	}

	public UpcomingEventsWrapper(String title, String description, String url) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
