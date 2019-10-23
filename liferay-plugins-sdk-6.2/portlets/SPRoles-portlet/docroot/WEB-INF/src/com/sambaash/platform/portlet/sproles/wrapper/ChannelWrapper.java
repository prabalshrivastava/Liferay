package com.sambaash.platform.portlet.sproles.wrapper;

public class ChannelWrapper {

	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public boolean isChild() {
		return child;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setChild(boolean child) {
		this.child = child;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	private long categoryId;
	private String categoryName;
	private boolean child = false;
	private long parentCategoryId;

}