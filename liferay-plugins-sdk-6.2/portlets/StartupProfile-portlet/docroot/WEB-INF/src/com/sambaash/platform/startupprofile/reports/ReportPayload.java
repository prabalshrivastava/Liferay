package com.sambaash.platform.startupprofile.reports;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.liferay.portal.kernel.util.Validator;

@XmlRootElement(name="profile")
public class ReportPayload {

	private String name;
	private String description;
	private String logoUrl;
	private String authorLogoUrl;
	private String timestamp;
	private String profileUrl;
	private String applicantUrl;
	private Map<String, String> data;
	private List<ReportSections> reportSectionsList;
	
	private ReportSection application;
	
	public void addReportSections(ReportSections sections){
		if(Validator.isNull(reportSectionsList)){
			reportSectionsList = new ArrayList<ReportSections>();
		}
		reportSectionsList.add(sections);
	}
	
	public void addData(String key,String value){
		if(Validator.isNull(data)){
			data  = new LinkedHashMap<String, String>();
		}
		data.put(key, value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public List<ReportSections> getReportSectionsList() {
		return reportSectionsList;
	}

	@XmlElement(name="sections")
	public void setReportSectionsList(List<ReportSections> reportSectionsList) {
		this.reportSectionsList = reportSectionsList;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAuthorLogoUrl() {
		return authorLogoUrl;
	}

	public void setAuthorLogoUrl(String authorLogoUrl) {
		this.authorLogoUrl = authorLogoUrl;
	}

	public ReportSection getApplication() {
		return application;
	}
	
	@XmlElement(name="application")
	public void setApplication(ReportSection application) {
		this.application = application;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getApplicantUrl() {
		return applicantUrl;
	}

	public void setApplicantUrl(String applicantUrl) {
		this.applicantUrl = applicantUrl;
	}
}