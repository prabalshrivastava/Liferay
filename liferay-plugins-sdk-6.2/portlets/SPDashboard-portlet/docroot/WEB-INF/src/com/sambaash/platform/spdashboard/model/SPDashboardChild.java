package com.sambaash.platform.spdashboard.model;

public class SPDashboardChild {
	
	private String label;
	private String url;
	private String type;
	private Integer chartType;
	private Long analyticsId;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getChartType() {
		return chartType;
	}
	public void setChartType(Integer chartType) {
		this.chartType = chartType;
	}
	public Long getAnalyticsId() {
		return analyticsId;
	}
	public void setAnalyticsId(Long analyticsId) {
		this.analyticsId = analyticsId;
	}
	@Override
	public String toString() {
		return "SPDashboardChild [label=" + label + ", url=" + url + ", type="
				+ type + ", chartType=" + chartType + ", analyticsId="
				+ analyticsId + "]";
	}

}
