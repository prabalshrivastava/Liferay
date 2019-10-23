package com.sambaash.platform.model.microservice.pricing.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum PriceType {
	@JsonProperty("ExamModular")
	EXAM_MODULAR("ExamModular", PriceCategory.SUBJECT),
	@JsonProperty("ExamNonModular")
	EXAM_NON_MODULAR("ExamNonModular", PriceCategory.SUBJECT),
	@JsonProperty("MiscFees")
	MISCELLANEOUS_FEES("MiscFees", PriceCategory.SUBJECT),
	@JsonProperty("BriefingRate")
	BRIEFING_RATE("BriefingRate", PriceCategory.INVIGILATOR),
	@JsonProperty("SessionRate")
	SESSION_RATE("SessionRate", PriceCategory.INVIGILATOR),
	@JsonProperty("DayRate")
	DAY_RATE("DayRate", PriceCategory.INVIGILATOR),
	@JsonProperty("Unknown")
	UNKNOWN("Unknown", PriceCategory.UNKNOWN);

	private final String value;
	private final PriceCategory priceCategory;

	PriceType(String value, PriceCategory priceCategory) {
		this.value = value;
		this.priceCategory = priceCategory;
	}

	@JsonCreator
	public static PriceType fromValue(String value) {
		for (PriceType type : PriceType.values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		return UNKNOWN;
	}

	public PriceCategory getPriceCategory() {
		return priceCategory;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
