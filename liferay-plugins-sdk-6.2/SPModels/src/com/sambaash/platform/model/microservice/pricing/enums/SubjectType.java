package com.sambaash.platform.model.microservice.pricing.enums;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum SubjectType {
	@JsonProperty("FullUnit")
	FULL_UNIT("FullUnit"),
	@JsonProperty("FullUnitCoursework")
	FULL_UNIT_COURSEWORK("FullUnitCoursework"),
	@JsonProperty("FullUnitWritten")
	FULL_UNIT_WRITTEN("FullUnitWritten"),
	@JsonProperty("HalfUnit")
	HALF_UNIT("HalfUnit"),
	@JsonProperty("HalfUnitCoursework")
	HALF_UNIT_COURSEWORK("HalfUnitCoursework"),
	@JsonProperty("HalfUnitWritten")
	HALF_UNIT_WRITTEN("HalfUnitWritten"),
	@JsonProperty("LawUnit")
	LAW_UNIT("LawUnit"),
	@JsonProperty("LawUnitCoursework")
	LAW_UNIT_COURSEWORK("LawUnitCoursework"),
	@JsonProperty("LawUnitWritten")
	LAW_UNIT_WRITTEN("LawUnitWritten"),
	UNKNOWN("Unknown");

	private final String value;

	SubjectType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static SubjectType fromValue(String value) {
		if (value == null)
			return null;
		for (SubjectType subtype : SubjectType.values()) {
			if (subtype.value.equals(value)) {
				return subtype;
			}
		}
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
