package com.sambaash.platform.portlet.spblogs.wrapper;

public class ChannelWrapper {
	
	private long categoryId;

	private String categoryName;

	private boolean child = false;
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isChild() {
		return child;
	}

	public void setChild(boolean child) {
		this.child = child;
	}
	
}
