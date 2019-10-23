package com.sambaash.platform.model.microservice.pricing.dto;

import com.sambaash.platform.model.microservice.pricing.enums.SubjectType;

public class SubjectDto {
	private String subjectCode;
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public SubjectType getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	private SubjectType subjectType;
}
