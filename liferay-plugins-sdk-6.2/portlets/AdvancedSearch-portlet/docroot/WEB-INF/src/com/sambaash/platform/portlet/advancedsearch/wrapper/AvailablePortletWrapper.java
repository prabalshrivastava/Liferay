package com.sambaash.platform.portlet.advancedsearch.wrapper;

public class AvailablePortletWrapper {

	public AvailablePortletWrapper() {
	}

	public AvailablePortletWrapper(String portletTitle, String portletId, String portletIdLabel, String searchFieldsJson, String disabled) {
		this.portletTitle = portletTitle;
		this.portletId = portletId;
		this.portletIdLabel = portletIdLabel;
		this.searchFieldsJson = searchFieldsJson;
		this.disabled = disabled;
	}

	public String getDisabled() {
		return disabled;
	}

	public String getPortletId() {
		return portletId;
	}

	public String getPortletTitle() {
		return portletTitle;
	}

	public String getSearchFieldsJson() {
		return searchFieldsJson;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	} public String getPortletIdLabel() {
		return portletIdLabel;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}

	public void setPortletIdLabel(String portletIdLabel) {
		this.portletIdLabel = portletIdLabel;
	}

	public void setPortletTitle(String portletTitle) {
		this.portletTitle = portletTitle;
	}

	public void setSearchFieldsJson(String searchFieldsJson) {
		this.searchFieldsJson = searchFieldsJson;
	}

	private String disabled;
	private String portletId;
	private String portletIdLabel;
	private String portletTitle;
	private String searchFieldsJson;

}