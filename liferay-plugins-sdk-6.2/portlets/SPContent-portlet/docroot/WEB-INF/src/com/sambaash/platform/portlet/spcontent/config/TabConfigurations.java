package com.sambaash.platform.portlet.spcontent.config;

import java.io.Serializable;

public class TabConfigurations implements Serializable {
	private static final long serialVersionUID = 1752330103111966089L;
	private TabConfiguration[] tabs;

	public TabConfiguration[] getTabs() {
		if (tabs==null) {
			tabs = new TabConfiguration[0];
		}
		return tabs;
	}

	public void setTabs(TabConfiguration[] tabs) {
		this.tabs = tabs;
	}
}
