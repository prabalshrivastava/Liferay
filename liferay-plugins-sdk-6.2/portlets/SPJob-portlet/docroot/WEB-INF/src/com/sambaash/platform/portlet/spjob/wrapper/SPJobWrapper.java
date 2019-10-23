package com.sambaash.platform.portlet.spjob.wrapper;

import java.util.Date;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class SPJobWrapper {

	private long jobId;
	private long userId;
	private String title;
	private String description;
	private String type;
	private String categoryNames;
	private String tagNames;
	private Date createDate;
	private String startDate;
	private String endDate;
	private String closeDate;
	private String status;
	private String previewImageUrl;
	private String detailUrl;
	private String jobLocation;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return StringUtil.shorten(title, 20, "...");
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		if (Validator.isNull(description)) {
			return "There is no description available for this job";
		}
		return StringUtil.shorten(description, 170, "...");
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategoryNames() {
		return categoryNames;
	}
	public void setCategoryNames(String categoryNames) {
		this.categoryNames = categoryNames;
	}
	public String getTagNames() {
		return tagNames;
	}
	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPreviewImageUrl() {
		return previewImageUrl;
	}
	public void setPreviewImageUrl(String previewImageUrl) {
		this.previewImageUrl = previewImageUrl;
	}
	public String getDetailUrl() {
		return detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

}
