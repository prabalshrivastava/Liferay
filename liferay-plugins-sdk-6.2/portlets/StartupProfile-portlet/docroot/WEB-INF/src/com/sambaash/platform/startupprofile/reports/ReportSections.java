package com.sambaash.platform.startupprofile.reports;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.liferay.portal.kernel.util.Validator;

public class ReportSections {
	private String name;
	private List<ReportSection>sectionList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ReportSection> getSectionList() {
		return sectionList;
	}
	@XmlElement(name="section")
	public void setSectionList(List<ReportSection> sectionList) {
		this.sectionList = sectionList;
	}
	
	public void addReportSection(ReportSection section){
		if(Validator.isNull(sectionList)){
			sectionList = new ArrayList<ReportSection>();
		}
		sectionList.add(section);
	}
	public void addReportSection(ReportSection section,int index){

		if(Validator.isNull(sectionList)){
			sectionList = new ArrayList<ReportSection>();
		}
		sectionList.add(0, section);
	
	}
}
