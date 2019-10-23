package com.sambaash.platform.spdashboard.model;

import java.util.ArrayList;
import java.util.List;

public class SPDashboardRow {

	private String label;
	private String url;
	private String iconUrl;
	private long[] roleIds;
	private int position;
	private String portletWarName;
	
	private List<SPDashboardChild> children = new ArrayList<SPDashboardChild>();

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

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getPortletWarName() {
		return portletWarName;
	}

	public void setPortletWarName(String portletWarName) {
		this.portletWarName = portletWarName;
	}

	public List<SPDashboardChild> getChildren() {
		return children;
	}

	public void setChildren(List<SPDashboardChild> children) {
		this.children = children;
	}

	public long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(long[] roleIds) {
		this.roleIds = roleIds;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "SPDashboardRow [label=" + label + ", url=" + url + ", iconUrl="
				+ iconUrl + ", roleIds=" + roleIds + ", portletWarName="
				+ portletWarName + "]";
	}

	public void addChild(SPDashboardChild childRow) {
		this.children.add(childRow);
	}

}
