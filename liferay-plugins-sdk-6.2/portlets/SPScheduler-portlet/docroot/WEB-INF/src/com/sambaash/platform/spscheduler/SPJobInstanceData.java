package com.sambaash.platform.spscheduler;

import java.util.Map;

import org.quartz.Trigger.TriggerState;

import com.liferay.portal.kernel.scheduler.StorageType;

public class SPJobInstanceData {

	private Long spJobEntryId;
	private String cronExpression;
	private String description;
	private Map<String, Object> extras;
	private String groupName;
	private String portletId;
	private String jobClassName;
	private String jobName;
	private StorageType storageType;
	private TriggerState triggerState;

	public String getCronExpression() {
		return cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getJobClassName() {
		return jobClassName;
	}

	public String getJobName() {
		return jobName;
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public TriggerState getTriggerState() {
		return triggerState;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public void setTriggerState(TriggerState triggerState) {
		this.triggerState = triggerState;
	}

	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}

	public Long getSpJobEntryId() {
		return spJobEntryId;
	}

	public void setSpJobEntryId(Long spJobEntryId) {
		this.spJobEntryId = spJobEntryId;
	}

}
