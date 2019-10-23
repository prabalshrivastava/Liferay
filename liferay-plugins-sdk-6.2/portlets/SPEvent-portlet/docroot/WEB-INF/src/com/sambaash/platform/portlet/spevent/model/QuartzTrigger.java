package com.sambaash.platform.portlet.spevent.model;

public class QuartzTrigger {

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public String getNextFireTime() {
		return nextFireTime;
	}

	public String getPrevFireTime() {
		return prevFireTime;
	}

	public String getScheduler() {
		return scheduler;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getTriggerGroup() {
		return triggerGroup;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public void setNextFireTime(String nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public void setPrevFireTime(String prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String categoryTitle;
	public String nextFireTime;
	public String prevFireTime;
	public String scheduler;
	public String startTime;
	public String triggerGroup;
	public String triggerName;
	public String triggerType;

}