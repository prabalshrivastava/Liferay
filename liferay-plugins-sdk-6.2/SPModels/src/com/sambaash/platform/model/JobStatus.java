package com.sambaash.platform.model;

public enum JobStatus {

	PENDING(0), WAITING(1), PROCESSING(2), FINISHED(3), FAILED(4), CANCELED(5), QUEUED(
			6), ASSIGNING(7), NO_INPUT(8), SKIPPED(9);

	private int status;

	private JobStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}

	public String getDescription() {

		switch (status) {
		case 0:
			return "Pending";
		case 1:
			return "Waiting";
		case 2:
			return "Processing";
		case 3:
			return "Finished";
		case 4:
			return "Failed";
		case 5:
			return "Canceled";
		case 6:
			return "Queued";
		case 7:
			return "Assigning";
		case 8:
			return "No input";
		case 9:
			return "Skipped";
		}

		return "";
	}

}
