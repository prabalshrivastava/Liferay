package com.sambaash.platform.portlet.extendedprofile.wrapper;

import java.util.List;
public class OtherCompetenciesWrapper {

private long categoryId;

	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getCompetenciesJSONData() {
		return competenciesJSONData;
	}

	public List<CompetencyLevelWrapper> getCompetencyLevelWrappers() {
		return competencyLevelWrappers;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCompetenciesJSONData(String competenciesJSONData) {
		this.competenciesJSONData = competenciesJSONData;
	}

	public void setCompetencyLevelWrappers(
			List<CompetencyLevelWrapper> competencyLevelWrappers) {
		this.competencyLevelWrappers = competencyLevelWrappers;
	}

	private String categoryName;
	private String competenciesJSONData;
	private List<CompetencyLevelWrapper> competencyLevelWrappers;

}