package com.sambaash.platform.model;

public enum SPMailType {
	MAIN(0), REMINDER1(1), REMINDER2(2), REMINDER3(3), THANKYOU(4), MISSEDYOU(5), TEST(6);

	private int value;

	private SPMailType(int value) {
		this.value = value;
	}

	public String getValue() {

		switch (value) {
		case 0:
			return "Main";
		case 1:
			return "Reminder 1";
		case 2:
			return "Reminder 2";
		case 3:
			return "Reminder 3";
		case 4:
			return "Thank You";
		case 5:
			return "Missed You";
		case 6:
			return "Test";
		}

		return null;
	}

	public int getCode() {
		return value;
	}

}
