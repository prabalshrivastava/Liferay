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
 * This class is a wrapper for {@link SPMailCampaign}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaign
 * @generated
 */
public class SPMailCampaignWrapper implements SPMailCampaign,
	ModelWrapper<SPMailCampaign> {
	public SPMailCampaignWrapper(SPMailCampaign spMailCampaign) {
		_spMailCampaign = spMailCampaign;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailCampaign.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailCampaign.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignName", getCampaignName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("mainTempalteId", getMainTempalteId());
		attributes.put("rem1TempalteId", getRem1TempalteId());
		attributes.put("rem2TempalteId", getRem2TempalteId());
		attributes.put("rem3TempalteId", getRem3TempalteId());
		attributes.put("thankyouTempalteId", getThankyouTempalteId());
		attributes.put("missedyouTempalteId", getMissedyouTempalteId());
		attributes.put("mainScheduledDate", getMainScheduledDate());
		attributes.put("rem1ScheduledDate", getRem1ScheduledDate());
		attributes.put("rem2ScheduledDate", getRem2ScheduledDate());
		attributes.put("rem3ScheduledDate", getRem3ScheduledDate());
		attributes.put("thankYouScheduledDate", getThankYouScheduledDate());
		attributes.put("missedyouScheduledDate", getMissedyouScheduledDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("dlFileEntryId", getDlFileEntryId());
		attributes.put("sentBy", getSentBy());
		attributes.put("sentDate", getSentDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("archive", getArchive());
		attributes.put("campaignType", getCampaignType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String campaignName = (String)attributes.get("campaignName");

		if (campaignName != null) {
			setCampaignName(campaignName);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long mainTempalteId = (Long)attributes.get("mainTempalteId");

		if (mainTempalteId != null) {
			setMainTempalteId(mainTempalteId);
		}

		Long rem1TempalteId = (Long)attributes.get("rem1TempalteId");

		if (rem1TempalteId != null) {
			setRem1TempalteId(rem1TempalteId);
		}

		Long rem2TempalteId = (Long)attributes.get("rem2TempalteId");

		if (rem2TempalteId != null) {
			setRem2TempalteId(rem2TempalteId);
		}

		Long rem3TempalteId = (Long)attributes.get("rem3TempalteId");

		if (rem3TempalteId != null) {
			setRem3TempalteId(rem3TempalteId);
		}

		Long thankyouTempalteId = (Long)attributes.get("thankyouTempalteId");

		if (thankyouTempalteId != null) {
			setThankyouTempalteId(thankyouTempalteId);
		}

		Long missedyouTempalteId = (Long)attributes.get("missedyouTempalteId");

		if (missedyouTempalteId != null) {
			setMissedyouTempalteId(missedyouTempalteId);
		}

		Date mainScheduledDate = (Date)attributes.get("mainScheduledDate");

		if (mainScheduledDate != null) {
			setMainScheduledDate(mainScheduledDate);
		}

		Date rem1ScheduledDate = (Date)attributes.get("rem1ScheduledDate");

		if (rem1ScheduledDate != null) {
			setRem1ScheduledDate(rem1ScheduledDate);
		}

		Date rem2ScheduledDate = (Date)attributes.get("rem2ScheduledDate");

		if (rem2ScheduledDate != null) {
			setRem2ScheduledDate(rem2ScheduledDate);
		}

		Date rem3ScheduledDate = (Date)attributes.get("rem3ScheduledDate");

		if (rem3ScheduledDate != null) {
			setRem3ScheduledDate(rem3ScheduledDate);
		}

		Date thankYouScheduledDate = (Date)attributes.get(
				"thankYouScheduledDate");

		if (thankYouScheduledDate != null) {
			setThankYouScheduledDate(thankYouScheduledDate);
		}

		Date missedyouScheduledDate = (Date)attributes.get(
				"missedyouScheduledDate");

		if (missedyouScheduledDate != null) {
			setMissedyouScheduledDate(missedyouScheduledDate);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long dlFileEntryId = (Long)attributes.get("dlFileEntryId");

		if (dlFileEntryId != null) {
			setDlFileEntryId(dlFileEntryId);
		}

		Long sentBy = (Long)attributes.get("sentBy");

		if (sentBy != null) {
			setSentBy(sentBy);
		}

		Date sentDate = (Date)attributes.get("sentDate");

		if (sentDate != null) {
			setSentDate(sentDate);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String campaignType = (String)attributes.get("campaignType");

		if (campaignType != null) {
			setCampaignType(campaignType);
		}
	}

	/**
	* Returns the primary key of this s p mail campaign.
	*
	* @return the primary key of this s p mail campaign
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailCampaign.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail campaign.
	*
	* @param primaryKey the primary key of this s p mail campaign
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailCampaign.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail campaign ID of this s p mail campaign.
	*
	* @return the sp mail campaign ID of this s p mail campaign
	*/
	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaign.getSpMailCampaignId();
	}

	/**
	* Sets the sp mail campaign ID of this s p mail campaign.
	*
	* @param spMailCampaignId the sp mail campaign ID of this s p mail campaign
	*/
	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaign.setSpMailCampaignId(spMailCampaignId);
	}

	/**
	* Returns the group ID of this s p mail campaign.
	*
	* @return the group ID of this s p mail campaign
	*/
	@Override
	public long getGroupId() {
		return _spMailCampaign.getGroupId();
	}

	/**
	* Sets the group ID of this s p mail campaign.
	*
	* @param groupId the group ID of this s p mail campaign
	*/
	@Override
	public void setGroupId(long groupId) {
		_spMailCampaign.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p mail campaign.
	*
	* @return the company ID of this s p mail campaign
	*/
	@Override
	public long getCompanyId() {
		return _spMailCampaign.getCompanyId();
	}

	/**
	* Sets the company ID of this s p mail campaign.
	*
	* @param companyId the company ID of this s p mail campaign
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spMailCampaign.setCompanyId(companyId);
	}

	/**
	* Returns the campaign name of this s p mail campaign.
	*
	* @return the campaign name of this s p mail campaign
	*/
	@Override
	public java.lang.String getCampaignName() {
		return _spMailCampaign.getCampaignName();
	}

	/**
	* Sets the campaign name of this s p mail campaign.
	*
	* @param campaignName the campaign name of this s p mail campaign
	*/
	@Override
	public void setCampaignName(java.lang.String campaignName) {
		_spMailCampaign.setCampaignName(campaignName);
	}

	/**
	* Returns the category ID of this s p mail campaign.
	*
	* @return the category ID of this s p mail campaign
	*/
	@Override
	public long getCategoryId() {
		return _spMailCampaign.getCategoryId();
	}

	/**
	* Sets the category ID of this s p mail campaign.
	*
	* @param categoryId the category ID of this s p mail campaign
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_spMailCampaign.setCategoryId(categoryId);
	}

	/**
	* Returns the main tempalte ID of this s p mail campaign.
	*
	* @return the main tempalte ID of this s p mail campaign
	*/
	@Override
	public long getMainTempalteId() {
		return _spMailCampaign.getMainTempalteId();
	}

	/**
	* Sets the main tempalte ID of this s p mail campaign.
	*
	* @param mainTempalteId the main tempalte ID of this s p mail campaign
	*/
	@Override
	public void setMainTempalteId(long mainTempalteId) {
		_spMailCampaign.setMainTempalteId(mainTempalteId);
	}

	/**
	* Returns the rem1 tempalte ID of this s p mail campaign.
	*
	* @return the rem1 tempalte ID of this s p mail campaign
	*/
	@Override
	public long getRem1TempalteId() {
		return _spMailCampaign.getRem1TempalteId();
	}

	/**
	* Sets the rem1 tempalte ID of this s p mail campaign.
	*
	* @param rem1TempalteId the rem1 tempalte ID of this s p mail campaign
	*/
	@Override
	public void setRem1TempalteId(long rem1TempalteId) {
		_spMailCampaign.setRem1TempalteId(rem1TempalteId);
	}

	/**
	* Returns the rem2 tempalte ID of this s p mail campaign.
	*
	* @return the rem2 tempalte ID of this s p mail campaign
	*/
	@Override
	public long getRem2TempalteId() {
		return _spMailCampaign.getRem2TempalteId();
	}

	/**
	* Sets the rem2 tempalte ID of this s p mail campaign.
	*
	* @param rem2TempalteId the rem2 tempalte ID of this s p mail campaign
	*/
	@Override
	public void setRem2TempalteId(long rem2TempalteId) {
		_spMailCampaign.setRem2TempalteId(rem2TempalteId);
	}

	/**
	* Returns the rem3 tempalte ID of this s p mail campaign.
	*
	* @return the rem3 tempalte ID of this s p mail campaign
	*/
	@Override
	public long getRem3TempalteId() {
		return _spMailCampaign.getRem3TempalteId();
	}

	/**
	* Sets the rem3 tempalte ID of this s p mail campaign.
	*
	* @param rem3TempalteId the rem3 tempalte ID of this s p mail campaign
	*/
	@Override
	public void setRem3TempalteId(long rem3TempalteId) {
		_spMailCampaign.setRem3TempalteId(rem3TempalteId);
	}

	/**
	* Returns the thankyou tempalte ID of this s p mail campaign.
	*
	* @return the thankyou tempalte ID of this s p mail campaign
	*/
	@Override
	public long getThankyouTempalteId() {
		return _spMailCampaign.getThankyouTempalteId();
	}

	/**
	* Sets the thankyou tempalte ID of this s p mail campaign.
	*
	* @param thankyouTempalteId the thankyou tempalte ID of this s p mail campaign
	*/
	@Override
	public void setThankyouTempalteId(long thankyouTempalteId) {
		_spMailCampaign.setThankyouTempalteId(thankyouTempalteId);
	}

	/**
	* Returns the missedyou tempalte ID of this s p mail campaign.
	*
	* @return the missedyou tempalte ID of this s p mail campaign
	*/
	@Override
	public long getMissedyouTempalteId() {
		return _spMailCampaign.getMissedyouTempalteId();
	}

	/**
	* Sets the missedyou tempalte ID of this s p mail campaign.
	*
	* @param missedyouTempalteId the missedyou tempalte ID of this s p mail campaign
	*/
	@Override
	public void setMissedyouTempalteId(long missedyouTempalteId) {
		_spMailCampaign.setMissedyouTempalteId(missedyouTempalteId);
	}

	/**
	* Returns the main scheduled date of this s p mail campaign.
	*
	* @return the main scheduled date of this s p mail campaign
	*/
	@Override
	public java.util.Date getMainScheduledDate() {
		return _spMailCampaign.getMainScheduledDate();
	}

	/**
	* Sets the main scheduled date of this s p mail campaign.
	*
	* @param mainScheduledDate the main scheduled date of this s p mail campaign
	*/
	@Override
	public void setMainScheduledDate(java.util.Date mainScheduledDate) {
		_spMailCampaign.setMainScheduledDate(mainScheduledDate);
	}

	/**
	* Returns the rem1 scheduled date of this s p mail campaign.
	*
	* @return the rem1 scheduled date of this s p mail campaign
	*/
	@Override
	public java.util.Date getRem1ScheduledDate() {
		return _spMailCampaign.getRem1ScheduledDate();
	}

	/**
	* Sets the rem1 scheduled date of this s p mail campaign.
	*
	* @param rem1ScheduledDate the rem1 scheduled date of this s p mail campaign
	*/
	@Override
	public void setRem1ScheduledDate(java.util.Date rem1ScheduledDate) {
		_spMailCampaign.setRem1ScheduledDate(rem1ScheduledDate);
	}

	/**
	* Returns the rem2 scheduled date of this s p mail campaign.
	*
	* @return the rem2 scheduled date of this s p mail campaign
	*/
	@Override
	public java.util.Date getRem2ScheduledDate() {
		return _spMailCampaign.getRem2ScheduledDate();
	}

	/**
	* Sets the rem2 scheduled date of this s p mail campaign.
	*
	* @param rem2ScheduledDate the rem2 scheduled date of this s p mail campaign
	*/
	@Override
	public void setRem2ScheduledDate(java.util.Date rem2ScheduledDate) {
		_spMailCampaign.setRem2ScheduledDate(rem2ScheduledDate);
	}

	/**
	* Returns the rem3 scheduled date of this s p mail campaign.
	*
	* @return the rem3 scheduled date of this s p mail campaign
	*/
	@Override
	public java.util.Date getRem3ScheduledDate() {
		return _spMailCampaign.getRem3ScheduledDate();
	}

	/**
	* Sets the rem3 scheduled date of this s p mail campaign.
	*
	* @param rem3ScheduledDate the rem3 scheduled date of this s p mail campaign
	*/
	@Override
	public void setRem3ScheduledDate(java.util.Date rem3ScheduledDate) {
		_spMailCampaign.setRem3ScheduledDate(rem3ScheduledDate);
	}

	/**
	* Returns the thank you scheduled date of this s p mail campaign.
	*
	* @return the thank you scheduled date of this s p mail campaign
	*/
	@Override
	public java.util.Date getThankYouScheduledDate() {
		return _spMailCampaign.getThankYouScheduledDate();
	}

	/**
	* Sets the thank you scheduled date of this s p mail campaign.
	*
	* @param thankYouScheduledDate the thank you scheduled date of this s p mail campaign
	*/
	@Override
	public void setThankYouScheduledDate(java.util.Date thankYouScheduledDate) {
		_spMailCampaign.setThankYouScheduledDate(thankYouScheduledDate);
	}

	/**
	* Returns the missedyou scheduled date of this s p mail campaign.
	*
	* @return the missedyou scheduled date of this s p mail campaign
	*/
	@Override
	public java.util.Date getMissedyouScheduledDate() {
		return _spMailCampaign.getMissedyouScheduledDate();
	}

	/**
	* Sets the missedyou scheduled date of this s p mail campaign.
	*
	* @param missedyouScheduledDate the missedyou scheduled date of this s p mail campaign
	*/
	@Override
	public void setMissedyouScheduledDate(java.util.Date missedyouScheduledDate) {
		_spMailCampaign.setMissedyouScheduledDate(missedyouScheduledDate);
	}

	/**
	* Returns the rsvp ID of this s p mail campaign.
	*
	* @return the rsvp ID of this s p mail campaign
	*/
	@Override
	public long getRsvpId() {
		return _spMailCampaign.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this s p mail campaign.
	*
	* @param rsvpId the rsvp ID of this s p mail campaign
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_spMailCampaign.setRsvpId(rsvpId);
	}

	/**
	* Returns the dl file entry ID of this s p mail campaign.
	*
	* @return the dl file entry ID of this s p mail campaign
	*/
	@Override
	public long getDlFileEntryId() {
		return _spMailCampaign.getDlFileEntryId();
	}

	/**
	* Sets the dl file entry ID of this s p mail campaign.
	*
	* @param dlFileEntryId the dl file entry ID of this s p mail campaign
	*/
	@Override
	public void setDlFileEntryId(long dlFileEntryId) {
		_spMailCampaign.setDlFileEntryId(dlFileEntryId);
	}

	/**
	* Returns the sent by of this s p mail campaign.
	*
	* @return the sent by of this s p mail campaign
	*/
	@Override
	public long getSentBy() {
		return _spMailCampaign.getSentBy();
	}

	/**
	* Sets the sent by of this s p mail campaign.
	*
	* @param sentBy the sent by of this s p mail campaign
	*/
	@Override
	public void setSentBy(long sentBy) {
		_spMailCampaign.setSentBy(sentBy);
	}

	/**
	* Returns the sent date of this s p mail campaign.
	*
	* @return the sent date of this s p mail campaign
	*/
	@Override
	public java.util.Date getSentDate() {
		return _spMailCampaign.getSentDate();
	}

	/**
	* Sets the sent date of this s p mail campaign.
	*
	* @param sentDate the sent date of this s p mail campaign
	*/
	@Override
	public void setSentDate(java.util.Date sentDate) {
		_spMailCampaign.setSentDate(sentDate);
	}

	/**
	* Returns the create by of this s p mail campaign.
	*
	* @return the create by of this s p mail campaign
	*/
	@Override
	public long getCreateBy() {
		return _spMailCampaign.getCreateBy();
	}

	/**
	* Sets the create by of this s p mail campaign.
	*
	* @param createBy the create by of this s p mail campaign
	*/
	@Override
	public void setCreateBy(long createBy) {
		_spMailCampaign.setCreateBy(createBy);
	}

	/**
	* Returns the create date of this s p mail campaign.
	*
	* @return the create date of this s p mail campaign
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spMailCampaign.getCreateDate();
	}

	/**
	* Sets the create date of this s p mail campaign.
	*
	* @param createDate the create date of this s p mail campaign
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spMailCampaign.setCreateDate(createDate);
	}

	/**
	* Returns the modified by of this s p mail campaign.
	*
	* @return the modified by of this s p mail campaign
	*/
	@Override
	public long getModifiedBy() {
		return _spMailCampaign.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p mail campaign.
	*
	* @param modifiedBy the modified by of this s p mail campaign
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spMailCampaign.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the modified date of this s p mail campaign.
	*
	* @return the modified date of this s p mail campaign
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spMailCampaign.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p mail campaign.
	*
	* @param modifiedDate the modified date of this s p mail campaign
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spMailCampaign.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this s p mail campaign.
	*
	* @return the status of this s p mail campaign
	*/
	@Override
	public int getStatus() {
		return _spMailCampaign.getStatus();
	}

	/**
	* Sets the status of this s p mail campaign.
	*
	* @param status the status of this s p mail campaign
	*/
	@Override
	public void setStatus(int status) {
		_spMailCampaign.setStatus(status);
	}

	/**
	* Returns the archive of this s p mail campaign.
	*
	* @return the archive of this s p mail campaign
	*/
	@Override
	public boolean getArchive() {
		return _spMailCampaign.getArchive();
	}

	/**
	* Returns <code>true</code> if this s p mail campaign is archive.
	*
	* @return <code>true</code> if this s p mail campaign is archive; <code>false</code> otherwise
	*/
	@Override
	public boolean isArchive() {
		return _spMailCampaign.isArchive();
	}

	/**
	* Sets whether this s p mail campaign is archive.
	*
	* @param archive the archive of this s p mail campaign
	*/
	@Override
	public void setArchive(boolean archive) {
		_spMailCampaign.setArchive(archive);
	}

	/**
	* Returns the campaign type of this s p mail campaign.
	*
	* @return the campaign type of this s p mail campaign
	*/
	@Override
	public java.lang.String getCampaignType() {
		return _spMailCampaign.getCampaignType();
	}

	/**
	* Sets the campaign type of this s p mail campaign.
	*
	* @param campaignType the campaign type of this s p mail campaign
	*/
	@Override
	public void setCampaignType(java.lang.String campaignType) {
		_spMailCampaign.setCampaignType(campaignType);
	}

	@Override
	public boolean isNew() {
		return _spMailCampaign.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailCampaign.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailCampaign.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailCampaign.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailCampaign.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailCampaign.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailCampaign.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailCampaign.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailCampaign.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailCampaign.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailCampaign.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailCampaignWrapper((SPMailCampaign)_spMailCampaign.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign) {
		return _spMailCampaign.compareTo(spMailCampaign);
	}

	@Override
	public int hashCode() {
		return _spMailCampaign.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailCampaign> toCacheModel() {
		return _spMailCampaign.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign toEscapedModel() {
		return new SPMailCampaignWrapper(_spMailCampaign.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaign toUnescapedModel() {
		return new SPMailCampaignWrapper(_spMailCampaign.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailCampaign.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailCampaign.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailCampaign.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailCampaignWrapper)) {
			return false;
		}

		SPMailCampaignWrapper spMailCampaignWrapper = (SPMailCampaignWrapper)obj;

		if (Validator.equals(_spMailCampaign,
					spMailCampaignWrapper._spMailCampaign)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailCampaign getWrappedSPMailCampaign() {
		return _spMailCampaign;
	}

	@Override
	public SPMailCampaign getWrappedModel() {
		return _spMailCampaign;
	}

	@Override
	public void resetOriginalValues() {
		_spMailCampaign.resetOriginalValues();
	}

	private SPMailCampaign _spMailCampaign;
}