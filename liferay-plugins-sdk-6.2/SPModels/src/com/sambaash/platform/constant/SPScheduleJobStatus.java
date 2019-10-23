package com.sambaash.platform.constant;

public enum SPScheduleJobStatus {

	INACTIVE(-1), ACTIVE(0), SUCCESS(1), PAUSED(2), RUNNING(3), FAILURE(4);

	private int value;

	private SPScheduleJobStatus(int i) {
		value = i;
	}

	public int intValue() {
		return value;
	}

	public static String stringValue(int i) {
		if (i == INACTIVE.intValue()) {
			return "InActive/Deleted";
		} else if (i == ACTIVE.intValue()) {
			return "Active(Yet to run)";
		} else if (i == SUCCESS.intValue()) {
			return "Successfully Executed";
		} else if (i == PAUSED.intValue()) {
			return "Paused";
		} else if (i == RUNNING.intValue()) {
			return "Running";
		} else if (i == FAILURE.intValue()) {
			return "Error";
		} else {
			return "Invalid status code";
		}
	}

}
