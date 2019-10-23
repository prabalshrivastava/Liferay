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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailCampaignSoap implements Serializable {
	public static SPMailCampaignSoap toSoapModel(SPMailCampaign model) {
		SPMailCampaignSoap soapModel = new SPMailCampaignSoap();

		soapModel.setSpMailCampaignId(model.getSpMailCampaignId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCampaignName(model.getCampaignName());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setMainTempalteId(model.getMainTempalteId());
		soapModel.setRem1TempalteId(model.getRem1TempalteId());
		soapModel.setRem2TempalteId(model.getRem2TempalteId());
		soapModel.setRem3TempalteId(model.getRem3TempalteId());
		soapModel.setThankyouTempalteId(model.getThankyouTempalteId());
		soapModel.setMissedyouTempalteId(model.getMissedyouTempalteId());
		soapModel.setMainScheduledDate(model.getMainScheduledDate());
		soapModel.setRem1ScheduledDate(model.getRem1ScheduledDate());
		soapModel.setRem2ScheduledDate(model.getRem2ScheduledDate());
		soapModel.setRem3ScheduledDate(model.getRem3ScheduledDate());
		soapModel.setThankYouScheduledDate(model.getThankYouScheduledDate());
		soapModel.setMissedyouScheduledDate(model.getMissedyouScheduledDate());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setDlFileEntryId(model.getDlFileEntryId());
		soapModel.setSentBy(model.getSentBy());
		soapModel.setSentDate(model.getSentDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setArchive(model.getArchive());
		soapModel.setCampaignType(model.getCampaignType());

		return soapModel;
	}

	public static SPMailCampaignSoap[] toSoapModels(SPMailCampaign[] models) {
		SPMailCampaignSoap[] soapModels = new SPMailCampaignSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailCampaignSoap[][] toSoapModels(SPMailCampaign[][] models) {
		SPMailCampaignSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailCampaignSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailCampaignSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailCampaignSoap[] toSoapModels(List<SPMailCampaign> models) {
		List<SPMailCampaignSoap> soapModels = new ArrayList<SPMailCampaignSoap>(models.size());

		for (SPMailCampaign model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailCampaignSoap[soapModels.size()]);
	}

	public SPMailCampaignSoap() {
	}

	public long getPrimaryKey() {
		return _spMailCampaignId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailCampaignId(pk);
	}

	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getCampaignName() {
		return _campaignName;
	}

	public void setCampaignName(String campaignName) {
		_campaignName = campaignName;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getMainTempalteId() {
		return _mainTempalteId;
	}

	public void setMainTempalteId(long mainTempalteId) {
		_mainTempalteId = mainTempalteId;
	}

	public long getRem1TempalteId() {
		return _rem1TempalteId;
	}

	public void setRem1TempalteId(long rem1TempalteId) {
		_rem1TempalteId = rem1TempalteId;
	}

	public long getRem2TempalteId() {
		return _rem2TempalteId;
	}

	public void setRem2TempalteId(long rem2TempalteId) {
		_rem2TempalteId = rem2TempalteId;
	}

	public long getRem3TempalteId() {
		return _rem3TempalteId;
	}

	public void setRem3TempalteId(long rem3TempalteId) {
		_rem3TempalteId = rem3TempalteId;
	}

	public long getThankyouTempalteId() {
		return _thankyouTempalteId;
	}

	public void setThankyouTempalteId(long thankyouTempalteId) {
		_thankyouTempalteId = thankyouTempalteId;
	}

	public long getMissedyouTempalteId() {
		return _missedyouTempalteId;
	}

	public void setMissedyouTempalteId(long missedyouTempalteId) {
		_missedyouTempalteId = missedyouTempalteId;
	}

	public Date getMainScheduledDate() {
		return _mainScheduledDate;
	}

	public void setMainScheduledDate(Date mainScheduledDate) {
		_mainScheduledDate = mainScheduledDate;
	}

	public Date getRem1ScheduledDate() {
		return _rem1ScheduledDate;
	}

	public void setRem1ScheduledDate(Date rem1ScheduledDate) {
		_rem1ScheduledDate = rem1ScheduledDate;
	}

	public Date getRem2ScheduledDate() {
		return _rem2ScheduledDate;
	}

	public void setRem2ScheduledDate(Date rem2ScheduledDate) {
		_rem2ScheduledDate = rem2ScheduledDate;
	}

	public Date getRem3ScheduledDate() {
		return _rem3ScheduledDate;
	}

	public void setRem3ScheduledDate(Date rem3ScheduledDate) {
		_rem3ScheduledDate = rem3ScheduledDate;
	}

	public Date getThankYouScheduledDate() {
		return _thankYouScheduledDate;
	}

	public void setThankYouScheduledDate(Date thankYouScheduledDate) {
		_thankYouScheduledDate = thankYouScheduledDate;
	}

	public Date getMissedyouScheduledDate() {
		return _missedyouScheduledDate;
	}

	public void setMissedyouScheduledDate(Date missedyouScheduledDate) {
		_missedyouScheduledDate = missedyouScheduledDate;
	}

	public long getRsvpId() {
		return _rsvpId;
	}

	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;
	}

	public long getDlFileEntryId() {
		return _dlFileEntryId;
	}

	public void setDlFileEntryId(long dlFileEntryId) {
		_dlFileEntryId = dlFileEntryId;
	}

	public long getSentBy() {
		return _sentBy;
	}

	public void setSentBy(long sentBy) {
		_sentBy = sentBy;
	}

	public Date getSentDate() {
		return _sentDate;
	}

	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;
	}

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public boolean getArchive() {
		return _archive;
	}

	public boolean isArchive() {
		return _archive;
	}

	public void setArchive(boolean archive) {
		_archive = archive;
	}

	public String getCampaignType() {
		return _campaignType;
	}

	public void setCampaignType(String campaignType) {
		_campaignType = campaignType;
	}

	private long _spMailCampaignId;
	private long _groupId;
	private long _companyId;
	private String _campaignName;
	private long _categoryId;
	private long _mainTempalteId;
	private long _rem1TempalteId;
	private long _rem2TempalteId;
	private long _rem3TempalteId;
	private long _thankyouTempalteId;
	private long _missedyouTempalteId;
	private Date _mainScheduledDate;
	private Date _rem1ScheduledDate;
	private Date _rem2ScheduledDate;
	private Date _rem3ScheduledDate;
	private Date _thankYouScheduledDate;
	private Date _missedyouScheduledDate;
	private long _rsvpId;
	private long _dlFileEntryId;
	private long _sentBy;
	private Date _sentDate;
	private long _createBy;
	private Date _createDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private int _status;
	private boolean _archive;
	private String _campaignType;
}