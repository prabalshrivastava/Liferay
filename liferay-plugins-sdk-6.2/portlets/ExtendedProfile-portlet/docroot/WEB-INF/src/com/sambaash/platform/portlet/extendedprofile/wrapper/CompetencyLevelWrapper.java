package com.sambaash.platform.portlet.extendedprofile.wrapper;

public class CompetencyLevelWrapper {

	public long getCompetencyId() {
		return competencyId;
	}

	public String getCompetencyName() {
		return competencyName;
	}

	public long getLevelId() {
		return levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setCompetencyId(long competencyId) {
		this.competencyId = competencyId;
	}

	public void setCompetencyName(String competencyName) {
		this.competencyName = competencyName;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	} private String competencyName;

	private long competencyId;
	private long levelId;
	private String levelName;

}