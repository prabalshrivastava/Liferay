package com.sambaash.platform.model.spneo4j.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetEntityGraphForm extends BaseGraphForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long classPK;
	private String className;
	private String title;
	private String urlTitle;
	private String content;
	private String imageUrl;
	private long userId;
	private int status;
	private Date createDate;
	private Date modifiedDate;

	// only applicable for spGroup discussion
	private long referenceId;
	private String referenceTitle;
	private String referenceUrlTitle;
	// added for saving MBMessage in graph db
	private long referenceClassId;

	// only applicable for spGroup
	private long type;
	
	private List<Long> categoryIds = new ArrayList<Long>();
	
	// for MBMessage parentMessageId. Used in forming the Discussion tree.
	private long parentId;
	
	public AssetEntityGraphForm() {
		
	}

	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(long referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceTitle() {
		return referenceTitle;
	}

	public void setReferenceTitle(String referenceTitle) {
		this.referenceTitle = referenceTitle;
	}

	public String getReferenceUrlTitle() {
		return referenceUrlTitle;
	}

	public void setReferenceUrlTitle(String referenceUrlTitle) {
		this.referenceUrlTitle = referenceUrlTitle;
	}

	public long getReferenceClassId() {
		return referenceClassId;
	}

	public void setReferenceClassId(long referenceClassId) {
		this.referenceClassId = referenceClassId;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
}
