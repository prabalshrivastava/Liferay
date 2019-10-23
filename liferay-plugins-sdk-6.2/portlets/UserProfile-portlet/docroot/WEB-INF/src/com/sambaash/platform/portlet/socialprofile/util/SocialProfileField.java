package com.sambaash.platform.portlet.socialprofile.util;

import com.liferay.portal.kernel.util.StringPool;

public class SocialProfileField {
	public SocialProfileField() {
	}

	public SocialProfileField(String fieldName, String fieldLabel) {
		this.fieldName = fieldName;
		this.fieldLabel = fieldLabel;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public String getFieldName() {
		return fieldName;
	}

	public int getMaxlength() {
		return maxlength;
	}

	public String getOptions() {
		return options;
	}

	public String getType() {
		return type;
	}

	public int getValidationType() {
		return validationType;
	}

	public boolean isDisplay() {
		return display;
	}

	public boolean isEdittable() {
		return edittable;
	}

	public boolean isIndexable() {
		return indexable;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public boolean isPrivateView() {
		return privateView;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public boolean isSystemField() {
		return systemField;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public void setEdittable(boolean edittable) {
		this.edittable = edittable;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setIndexable(boolean indexable) {
		this.indexable = indexable;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public void setMaxlength(int maxlength) {
		this.maxlength = maxlength;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public void setPrivateView(boolean privateView) {
		this.privateView = privateView;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public void setSystemField(boolean systemField) {
		this.systemField = systemField;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValidationType(int validationType) {
		this.validationType = validationType;
	}

	private String defaultValue = StringPool.BLANK;
	private boolean display;
	private boolean edittable;
	private String fieldLabel;
	private String fieldName;
	private boolean indexable;
	private boolean mandatory;
	private int maxlength = 100;
	private String options;
	private boolean privateView;
	private boolean searchable;
	private boolean systemField;
	private String type;
	private int validationType;
	private String levelValue;
	public String getLevelValue() {
		return levelValue;
	}

	public void setLevelValue(String levelValue) {
		this.levelValue = levelValue;
	}
	
}