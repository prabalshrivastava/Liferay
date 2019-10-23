package com.sambaash.platform.product.util;

public enum Status {
	CREATED(0, "Created"), PUBLISH(1, "Published"), UNPUBLISH(2, "Un-published"), DELETED(3, "Deleted");

	private final int code;
	private final String description;

	Status(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}
