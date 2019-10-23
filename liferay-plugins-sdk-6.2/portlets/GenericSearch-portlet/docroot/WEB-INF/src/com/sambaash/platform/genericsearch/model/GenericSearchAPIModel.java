package com.sambaash.platform.genericsearch.model;

public class GenericSearchAPIModel {

	private String apiKey;
	private String title;
	private String defaultSettings;
	
	public GenericSearchAPIModel(String apiKey, String title){
		this.apiKey = apiKey;
		this.title = title;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDefaultSettings() {
		return defaultSettings;
	}
	public void setDefaultSettings(String defaultSettings) {
		this.defaultSettings = defaultSettings;
	}
	
	
	
}
