package com.sambaash.platform.model;

public enum ProfileType {
	USER(1), MARKETER(2), STARTUP(3), SCOUT(4);

	private int type;

	private ProfileType(int type) {
		this.type = type;
	}

	public String getValue() {
		switch (type) {
		case 1:
			return "User";
		case 2:
			return "Marketer";
		case 3:
			return "Startup";
		case 4:
			return "Scout";
		}
		return null;
	}
}
