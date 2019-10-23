package com.sambaash.platform.dbutility.entity;

public class Column {
	private String name;
	private String type;
	private boolean isNull;
	private boolean isKey;
	private String defaultValue;
	private String extra;

	public Column(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Column(String name, String type, boolean isNull, boolean isKey, String defaultValue, String extra) {
		super();
		this.name = name;
		this.type = type;
		this.isNull = isNull;
		this.isKey = isKey;
		this.defaultValue = defaultValue;
		this.extra = extra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public boolean isKey() {
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String toString() {
		String nullStr = isNull ? "" : " NOT NULL ";
		String defaultStr = defaultValue == null ? "" : " DEFAULT " + defaultValue + " ";
		return "`" + name + "` " + type + nullStr + defaultStr + extra;
	}

}
