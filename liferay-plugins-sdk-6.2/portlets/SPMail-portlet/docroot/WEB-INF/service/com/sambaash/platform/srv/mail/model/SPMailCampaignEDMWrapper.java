/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailCampaignEDM}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignEDM
 * @generated
 */
public class SPMailCampaignEDMWrapper implements SPMailCampaignEDM,
	ModelWrapper<SPMailCampaignEDM> {
	public SPMailCampaignEDMWrapper(SPMailCampaignEDM spMailCampaignEDM) {
		_spMailCampaignEDM = spMailCampaignEDM;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailCampaignEDM.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailCampaignEDM.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailCampaignEDMId", getSpMailCampaignEDMId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("spMailTemplateId", getSpMailTemplateId());
		attributes.put("seqNo", getSeqNo());
		attributes.put("dayOfWeek", getDayOfWeek());
		attributes.put("dayOfMonth", getDayOfMonth());
		attributes.put("delayUnit", getDelayUnit());
		attributes.put("status", getStatus());
		attributes.put("delayAmount", getDelayAmount());
		attributes.put("croneType", getCroneType());
		attributes.put("nextScheduleDateTime", getNextScheduleDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailCampaignEDMId = (Long)attributes.get("spMailCampaignEDMId");

		if (spMailCampaignEDMId != null) {
			setSpMailCampaignEDMId(spMailCampaignEDMId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long spMailTemplateId = (Long)attributes.get("spMailTemplateId");

		if (spMailTemplateId != null) {
			setSpMailTemplateId(spMailTemplateId);
		}

		Integer seqNo = (Integer)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Integer dayOfWeek = (Integer)attributes.get("dayOfWeek");

		if (dayOfWeek != null) {
			setDayOfWeek(dayOfWeek);
		}

		Integer dayOfMonth = (Integer)attributes.get("dayOfMonth");

		if (dayOfMonth != null) {
			setDayOfMonth(dayOfMonth);
		}

		String delayUnit = (String)attributes.get("delayUnit");

		if (delayUnit != null) {
			setDelayUnit(delayUnit);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer delayAmount = (Integer)attributes.get("delayAmount");

		if (delayAmount != null) {
			setDelayAmount(delayAmount);
		}

		String croneType = (String)attributes.get("croneType");

		if (croneType != null) {
			setCroneType(croneType);
		}

		Date nextScheduleDateTime = (Date)attributes.get("nextScheduleDateTime");

		if (nextScheduleDateTime != null) {
			setNextScheduleDateTime(nextScheduleDateTime);
		}
	}

	/**
	* Returns the primary key of this s p mail campaign e d m.
	*
	* @return the primary key of this s p mail campaign e d m
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailCampaignEDM.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail campaign e d m.
	*
	* @param primaryKey the primary key of this s p mail campaign e d m
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailCampaignEDM.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail campaign e d m ID of this s p mail campaign e d m.
	*
	* @return the sp mail campaign e d m ID of this s p mail campaign e d m
	*/
	@Override
	public long getSpMailCampaignEDMId() {
		return _spMailCampaignEDM.getSpMailCampaignEDMId();
	}

	/**
	* Sets the sp mail campaign e d m ID of this s p mail campaign e d m.
	*
	* @param spMailCampaignEDMId the sp mail campaign e d m ID of this s p mail campaign e d m
	*/
	@Override
	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailCampaignEDM.setSpMailCampaignEDMId(spMailCampaignEDMId);
	}

	/**
	* Returns the group ID of this s p mail campaign e d m.
	*
	* @return the group ID of this s p mail campaign e d m
	*/
	@Override
	public long getGroupId() {
		return _spMailCampaignEDM.getGroupId();
	}

	/**
	* Sets the group ID of this s p mail campaign e d m.
	*
	* @param groupId the group ID of this s p mail campaign e d m
	*/
	@Override
	public void setGroupId(long groupId) {
		_spMailCampaignEDM.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p mail campaign e d m.
	*
	* @return the company ID of this s p mail campaign e d m
	*/
	@Override
	public long getCompanyId() {
		return _spMailCampaignEDM.getCompanyId();
	}

	/**
	* Sets the company ID of this s p mail campaign e d m.
	*
	* @param companyId the company ID of this s p mail campaign e d m
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spMailCampaignEDM.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p mail campaign e d m.
	*
	* @return the user ID of this s p mail campaign e d m
	*/
	@Override
	public long getUserId() {
		return _spMailCampaignEDM.getUserId();
	}

	/**
	* Sets the user ID of this s p mail campaign e d m.
	*
	* @param userId the user ID of this s p mail campaign e d m
	*/
	@Override
	public void setUserId(long userId) {
		_spMailCampaignEDM.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p mail campaign e d m.
	*
	* @return the user uuid of this s p mail campaign e d m
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignEDM.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p mail campaign e d m.
	*
	* @param userUuid the user uuid of this s p mail campaign e d m
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spMailCampaignEDM.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p mail campaign e d m.
	*
	* @return the user name of this s p mail campaign e d m
	*/
	@Override
	public java.lang.String getUserName() {
		return _spMailCampaignEDM.getUserName();
	}

	/**
	* Sets the user name of this s p mail campaign e d m.
	*
	* @param userName the user name of this s p mail campaign e d m
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spMailCampaignEDM.setUserName(userName);
	}

	/**
	* Returns the create date of this s p mail campaign e d m.
	*
	* @return the create date of this s p mail campaign e d m
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spMailCampaignEDM.getCreateDate();
	}

	/**
	* Sets the create date of this s p mail campaign e d m.
	*
	* @param createDate the create date of this s p mail campaign e d m
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spMailCampaignEDM.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p mail campaign e d m.
	*
	* @return the modified date of this s p mail campaign e d m
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spMailCampaignEDM.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p mail campaign e d m.
	*
	* @param modifiedDate the modified date of this s p mail campaign e d m
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spMailCampaignEDM.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this s p mail campaign e d m.
	*
	* @return the name of this s p mail campaign e d m
	*/
	@Override
	public java.lang.String getName() {
		return _spMailCampaignEDM.getName();
	}

	/**
	* Sets the name of this s p mail campaign e d m.
	*
	* @param name the name of this s p mail campaign e d m
	*/
	@Override
	public void setName(java.lang.String name) {
		_spMailCampaignEDM.setName(name);
	}

	/**
	* Returns the sp mail campaign ID of this s p mail campaign e d m.
	*
	* @return the sp mail campaign ID of this s p mail campaign e d m
	*/
	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaignEDM.getSpMailCampaignId();
	}

	/**
	* Sets the sp mail campaign ID of this s p mail campaign e d m.
	*
	* @param spMailCampaignId the sp mail campaign ID of this s p mail campaign e d m
	*/
	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignEDM.setSpMailCampaignId(spMailCampaignId);
	}

	/**
	* Returns the sp mail template ID of this s p mail campaign e d m.
	*
	* @return the sp mail template ID of this s p mail campaign e d m
	*/
	@Override
	public long getSpMailTemplateId() {
		return _spMailCampaignEDM.getSpMailTemplateId();
	}

	/**
	* Sets the sp mail template ID of this s p mail campaign e d m.
	*
	* @param spMailTemplateId the sp mail template ID of this s p mail campaign e d m
	*/
	@Override
	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailCampaignEDM.setSpMailTemplateId(spMailTemplateId);
	}

	/**
	* Returns the seq no of this s p mail campaign e d m.
	*
	* @return the seq no of this s p mail campaign e d m
	*/
	@Override
	public int getSeqNo() {
		return _spMailCampaignEDM.getSeqNo();
	}

	/**
	* Sets the seq no of this s p mail campaign e d m.
	*
	* @param seqNo the seq no of this s p mail campaign e d m
	*/
	@Override
	public void setSeqNo(int seqNo) {
		_spMailCampaignEDM.setSeqNo(seqNo);
	}

	/**
	* Returns the day of week of this s p mail campaign e d m.
	*
	* @return the day of week of this s p mail campaign e d m
	*/
	@Override
	public int getDayOfWeek() {
		return _spMailCampaignEDM.getDayOfWeek();
	}

	/**
	* Sets the day of week of this s p mail campaign e d m.
	*
	* @param dayOfWeek the day of week of this s p mail campaign e d m
	*/
	@Override
	public void setDayOfWeek(int dayOfWeek) {
		_spMailCampaignEDM.setDayOfWeek(dayOfWeek);
	}

	/**
	* Returns the day of month of this s p mail campaign e d m.
	*
	* @return the day of month of this s p mail campaign e d m
	*/
	@Override
	public int getDayOfMonth() {
		return _spMailCampaignEDM.getDayOfMonth();
	}

	/**
	* Sets the day of month of this s p mail campaign e d m.
	*
	* @param dayOfMonth the day of month of this s p mail campaign e d m
	*/
	@Override
	public void setDayOfMonth(int dayOfMonth) {
		_spMailCampaignEDM.setDayOfMonth(dayOfMonth);
	}

	/**
	* Returns the delay unit of this s p mail campaign e d m.
	*
	* @return the delay unit of this s p mail campaign e d m
	*/
	@Override
	public java.lang.String getDelayUnit() {
		return _spMailCampaignEDM.getDelayUnit();
	}

	/**
	* Sets the delay unit of this s p mail campaign e d m.
	*
	* @param delayUnit the delay unit of this s p mail campaign e d m
	*/
	@Override
	public void setDelayUnit(java.lang.String delayUnit) {
		_spMailCampaignEDM.setDelayUnit(delayUnit);
	}

	/**
	* Returns the status of this s p mail campaign e d m.
	*
	* @return the status of this s p mail campaign e d m
	*/
	@Override
	public java.lang.String getStatus() {
		return _spMailCampaignEDM.getStatus();
	}

	/**
	* Sets the status of this s p mail campaign e d m.
	*
	* @param status the status of this s p mail campaign e d m
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_spMailCampaignEDM.setStatus(status);
	}

	/**
	* Returns the delay amount of this s p mail campaign e d m.
	*
	* @return the delay amount of this s p mail campaign e d m
	*/
	@Override
	public int getDelayAmount() {
		return _spMailCampaignEDM.getDelayAmount();
	}

	/**
	* Sets the delay amount of this s p mail campaign e d m.
	*
	* @param delayAmount the delay amount of this s p mail campaign e d m
	*/
	@Override
	public void setDelayAmount(int delayAmount) {
		_spMailCampaignEDM.setDelayAmount(delayAmount);
	}

	/**
	* Returns the crone type of this s p mail campaign e d m.
	*
	* @return the crone type of this s p mail campaign e d m
	*/
	@Override
	public java.lang.String getCroneType() {
		return _spMailCampaignEDM.getCroneType();
	}

	/**
	* Sets the crone type of this s p mail campaign e d m.
	*
	* @param croneType the crone type of this s p mail campaign e d m
	*/
	@Override
	public void setCroneType(java.lang.String croneType) {
		_spMailCampaignEDM.setCroneType(croneType);
	}

	/**
	* Returns the next schedule date time of this s p mail campaign e d m.
	*
	* @return the next schedule date time of this s p mail campaign e d m
	*/
	@Override
	public java.util.Date getNextScheduleDateTime() {
		return _spMailCampaignEDM.getNextScheduleDateTime();
	}

	/**
	* Sets the next schedule date time of this s p mail campaign e d m.
	*
	* @param nextScheduleDateTime the next schedule date time of this s p mail campaign e d m
	*/
	@Override
	public void setNextScheduleDateTime(java.util.Date nextScheduleDateTime) {
		_spMailCampaignEDM.setNextScheduleDateTime(nextScheduleDateTime);
	}

	@Override
	public boolean isNew() {
		return _spMailCampaignEDM.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailCampaignEDM.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailCampaignEDM.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailCampaignEDM.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailCampaignEDM.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailCampaignEDM.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailCampaignEDM.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailCampaignEDM.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailCampaignEDM.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailCampaignEDM.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailCampaignEDM.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailCampaignEDMWrapper((SPMailCampaignEDM)_spMailCampaignEDM.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailCampaignEDM spMailCampaignEDM) {
		return _spMailCampaignEDM.compareTo(spMailCampaignEDM);
	}

	@Override
	public int hashCode() {
		return _spMailCampaignEDM.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> toCacheModel() {
		return _spMailCampaignEDM.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM toEscapedModel() {
		return new SPMailCampaignEDMWrapper(_spMailCampaignEDM.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM toUnescapedModel() {
		return new SPMailCampaignEDMWrapper(_spMailCampaignEDM.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailCampaignEDM.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailCampaignEDM.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailCampaignEDM.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailCampaignEDMWrapper)) {
			return false;
		}

		SPMailCampaignEDMWrapper spMailCampaignEDMWrapper = (SPMailCampaignEDMWrapper)obj;

		if (Validator.equals(_spMailCampaignEDM,
					spMailCampaignEDMWrapper._spMailCampaignEDM)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailCampaignEDM getWrappedSPMailCampaignEDM() {
		return _spMailCampaignEDM;
	}

	@Override
	public SPMailCampaignEDM getWrappedModel() {
		return _spMailCampaignEDM;
	}

	@Override
	public void resetOriginalValues() {
		_spMailCampaignEDM.resetOriginalValues();
	}

	private SPMailCampaignEDM _spMailCampaignEDM;
}