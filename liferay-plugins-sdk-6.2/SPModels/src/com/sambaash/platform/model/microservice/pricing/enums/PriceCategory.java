package com.sambaash.platform.model.microservice.pricing.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum PriceCategory {
	@JsonProperty("Subject")
	SUBJECT("Subject"),
	@JsonProperty("Invigilator")
	INVIGILATOR("Invigilator"),
	@JsonProperty("Unknown")
	UNKNOWN("Unknown");

	private final String value;

	PriceCategory(String value) {
		this.value = value;
	}

	@JsonCreator
	public static PriceCategory fromValue(String value) {
		for (PriceCategory cat : PriceCategory.values()) {
			if (cat.value.equals(value)) {
				return cat;
			}
		}
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
