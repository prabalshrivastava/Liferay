package com.sambaash.platform.portlet.spevent.model;

public class QuartzCronTriggers {

	public String getCornExpression() {
		return cornExpression;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public String getTriggerGroup() {
		return triggerGroup;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setCornExpression(String cornExpression) {
		this.cornExpression = cornExpression;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String cornExpression;
	public String timeZoneId;
	public String triggerGroup;
	public String triggerName;

}