package com.sambaash.platform.model;

public class UserMetaData {

	private String columnName;

	private String categoryName;

	private String categoryDetail;

	private boolean override;

	private boolean multiInstance;

	private String action;
	private long vocId;
	
	public UserMetaData(String columnName, String categoryName, String categoryDetail, boolean override,
			boolean multiInstance) {
		super();
		this.columnName = columnName;
		this.categoryName = categoryName;
		this.categoryDetail = categoryDetail;
		this.override = override;
		this.multiInstance = multiInstance;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDetail() {
		return categoryDetail;
	}

	public void setCategoryDetail(String categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public boolean isOverride() {
		return override;
	}

	public void setOverride(boolean override) {
		this.override = override;
	}

	public boolean isMultiInstance() {
		return multiInstance;
	}

	public void setMultiInstance(boolean multiInstance) {
		this.multiInstance = multiInstance;
	}

	@Override
	public String toString() {
		return "UserMetaData [columnName=" + columnName + ", categoryName=" + categoryName + ", categoryDetail="
				+ categoryDetail + ", override=" + override + ", multiInstance=" + multiInstance + "]";
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getVocId() {
		return vocId;
	}

	public void setVocId(long vocId) {
		this.vocId = vocId;
	}

}
