package com.sambaash.platform.model;

public enum SPMailStatus {

	NOT_SCHEDULED(0), SCHEDULED(1), PROCESSING(2), SENT(3), NOT_REQUIRED(4), DELETED(5), ERROR(6), ARCHIVE(7);

	private int status;

	private SPMailStatus(int status) {
		this.status = status;
	}

	public String getValue() {

		switch (status) {
		case 0:
			return "Not Scheduled";
		case 1:
			return "Scheduled";
		case 2:
			return "Processing";
		case 3:
			return "Sent";
		case 4:
			return "Not Required";
		case 5:
			return "Deleted";
		case 6:
			return "Error";
		case 7:
			return "Archive";
		}

		return null;
	}

	public int getStatus() {
		return status;
	}

}
