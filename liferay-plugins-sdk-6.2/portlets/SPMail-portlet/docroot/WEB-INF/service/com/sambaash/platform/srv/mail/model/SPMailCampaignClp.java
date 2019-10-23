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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailCampaignClp extends BaseModelImpl<SPMailCampaign>
	implements SPMailCampaign {
	public SPMailCampaignClp() {
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
	public long getPrimaryKey() {
		return _spMailCampaignId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailCampaignId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailCampaignId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignId",
						long.class);

				method.invoke(_spMailCampaignRemoteModel, spMailCampaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spMailCampaignRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spMailCampaignRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCampaignName() {
		return _campaignName;
	}

	@Override
	public void setCampaignName(String campaignName) {
		_campaignName = campaignName;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignName", String.class);

				method.invoke(_spMailCampaignRemoteModel, campaignName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_spMailCampaignRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMainTempalteId() {
		return _mainTempalteId;
	}

	@Override
	public void setMainTempalteId(long mainTempalteId) {
		_mainTempalteId = mainTempalteId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setMainTempalteId", long.class);

				method.invoke(_spMailCampaignRemoteModel, mainTempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRem1TempalteId() {
		return _rem1TempalteId;
	}

	@Override
	public void setRem1TempalteId(long rem1TempalteId) {
		_rem1TempalteId = rem1TempalteId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRem1TempalteId", long.class);

				method.invoke(_spMailCampaignRemoteModel, rem1TempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRem2TempalteId() {
		return _rem2TempalteId;
	}

	@Override
	public void setRem2TempalteId(long rem2TempalteId) {
		_rem2TempalteId = rem2TempalteId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRem2TempalteId", long.class);

				method.invoke(_spMailCampaignRemoteModel, rem2TempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRem3TempalteId() {
		return _rem3TempalteId;
	}

	@Override
	public void setRem3TempalteId(long rem3TempalteId) {
		_rem3TempalteId = rem3TempalteId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRem3TempalteId", long.class);

				method.invoke(_spMailCampaignRemoteModel, rem3TempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getThankyouTempalteId() {
		return _thankyouTempalteId;
	}

	@Override
	public void setThankyouTempalteId(long thankyouTempalteId) {
		_thankyouTempalteId = thankyouTempalteId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setThankyouTempalteId",
						long.class);

				method.invoke(_spMailCampaignRemoteModel, thankyouTempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMissedyouTempalteId() {
		return _missedyouTempalteId;
	}

	@Override
	public void setMissedyouTempalteId(long missedyouTempalteId) {
		_missedyouTempalteId = missedyouTempalteId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setMissedyouTempalteId",
						long.class);

				method.invoke(_spMailCampaignRemoteModel, missedyouTempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getMainScheduledDate() {
		return _mainScheduledDate;
	}

	@Override
	public void setMainScheduledDate(Date mainScheduledDate) {
		_mainScheduledDate = mainScheduledDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setMainScheduledDate",
						Date.class);

				method.invoke(_spMailCampaignRemoteModel, mainScheduledDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRem1ScheduledDate() {
		return _rem1ScheduledDate;
	}

	@Override
	public void setRem1ScheduledDate(Date rem1ScheduledDate) {
		_rem1ScheduledDate = rem1ScheduledDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRem1ScheduledDate",
						Date.class);

				method.invoke(_spMailCampaignRemoteModel, rem1ScheduledDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRem2ScheduledDate() {
		return _rem2ScheduledDate;
	}

	@Override
	public void setRem2ScheduledDate(Date rem2ScheduledDate) {
		_rem2ScheduledDate = rem2ScheduledDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRem2ScheduledDate",
						Date.class);

				method.invoke(_spMailCampaignRemoteModel, rem2ScheduledDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRem3ScheduledDate() {
		return _rem3ScheduledDate;
	}

	@Override
	public void setRem3ScheduledDate(Date rem3ScheduledDate) {
		_rem3ScheduledDate = rem3ScheduledDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRem3ScheduledDate",
						Date.class);

				method.invoke(_spMailCampaignRemoteModel, rem3ScheduledDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getThankYouScheduledDate() {
		return _thankYouScheduledDate;
	}

	@Override
	public void setThankYouScheduledDate(Date thankYouScheduledDate) {
		_thankYouScheduledDate = thankYouScheduledDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setThankYouScheduledDate",
						Date.class);

				method.invoke(_spMailCampaignRemoteModel, thankYouScheduledDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getMissedyouScheduledDate() {
		return _missedyouScheduledDate;
	}

	@Override
	public void setMissedyouScheduledDate(Date missedyouScheduledDate) {
		_missedyouScheduledDate = missedyouScheduledDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setMissedyouScheduledDate",
						Date.class);

				method.invoke(_spMailCampaignRemoteModel, missedyouScheduledDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpId() {
		return _rsvpId;
	}

	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_spMailCampaignRemoteModel, rsvpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDlFileEntryId() {
		return _dlFileEntryId;
	}

	@Override
	public void setDlFileEntryId(long dlFileEntryId) {
		_dlFileEntryId = dlFileEntryId;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setDlFileEntryId", long.class);

				method.invoke(_spMailCampaignRemoteModel, dlFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSentBy() {
		return _sentBy;
	}

	@Override
	public void setSentBy(long sentBy) {
		_sentBy = sentBy;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setSentBy", long.class);

				method.invoke(_spMailCampaignRemoteModel, sentBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSentDate() {
		return _sentDate;
	}

	@Override
	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setSentDate", Date.class);

				method.invoke(_spMailCampaignRemoteModel, sentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(long createBy) {
		_createBy = createBy;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateBy", long.class);

				method.invoke(_spMailCampaignRemoteModel, createBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spMailCampaignRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spMailCampaignRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spMailCampaignRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_spMailCampaignRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getArchive() {
		return _archive;
	}

	@Override
	public boolean isArchive() {
		return _archive;
	}

	@Override
	public void setArchive(boolean archive) {
		_archive = archive;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setArchive", boolean.class);

				method.invoke(_spMailCampaignRemoteModel, archive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCampaignType() {
		return _campaignType;
	}

	@Override
	public void setCampaignType(String campaignType) {
		_campaignType = campaignType;

		if (_spMailCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignType", String.class);

				method.invoke(_spMailCampaignRemoteModel, campaignType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailCampaignRemoteModel() {
		return _spMailCampaignRemoteModel;
	}

	public void setSPMailCampaignRemoteModel(
		BaseModel<?> spMailCampaignRemoteModel) {
		_spMailCampaignRemoteModel = spMailCampaignRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _spMailCampaignRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_spMailCampaignRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailCampaignLocalServiceUtil.addSPMailCampaign(this);
		}
		else {
			SPMailCampaignLocalServiceUtil.updateSPMailCampaign(this);
		}
	}

	@Override
	public SPMailCampaign toEscapedModel() {
		return (SPMailCampaign)ProxyUtil.newProxyInstance(SPMailCampaign.class.getClassLoader(),
			new Class[] { SPMailCampaign.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailCampaignClp clone = new SPMailCampaignClp();

		clone.setSpMailCampaignId(getSpMailCampaignId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCampaignName(getCampaignName());
		clone.setCategoryId(getCategoryId());
		clone.setMainTempalteId(getMainTempalteId());
		clone.setRem1TempalteId(getRem1TempalteId());
		clone.setRem2TempalteId(getRem2TempalteId());
		clone.setRem3TempalteId(getRem3TempalteId());
		clone.setThankyouTempalteId(getThankyouTempalteId());
		clone.setMissedyouTempalteId(getMissedyouTempalteId());
		clone.setMainScheduledDate(getMainScheduledDate());
		clone.setRem1ScheduledDate(getRem1ScheduledDate());
		clone.setRem2ScheduledDate(getRem2ScheduledDate());
		clone.setRem3ScheduledDate(getRem3ScheduledDate());
		clone.setThankYouScheduledDate(getThankYouScheduledDate());
		clone.setMissedyouScheduledDate(getMissedyouScheduledDate());
		clone.setRsvpId(getRsvpId());
		clone.setDlFileEntryId(getDlFileEntryId());
		clone.setSentBy(getSentBy());
		clone.setSentDate(getSentDate());
		clone.setCreateBy(getCreateBy());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedBy(getModifiedBy());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());
		clone.setArchive(getArchive());
		clone.setCampaignType(getCampaignType());

		return clone;
	}

	@Override
	public int compareTo(SPMailCampaign spMailCampaign) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				spMailCampaign.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailCampaignClp)) {
			return false;
		}

		SPMailCampaignClp spMailCampaign = (SPMailCampaignClp)obj;

		long primaryKey = spMailCampaign.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", campaignName=");
		sb.append(getCampaignName());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", mainTempalteId=");
		sb.append(getMainTempalteId());
		sb.append(", rem1TempalteId=");
		sb.append(getRem1TempalteId());
		sb.append(", rem2TempalteId=");
		sb.append(getRem2TempalteId());
		sb.append(", rem3TempalteId=");
		sb.append(getRem3TempalteId());
		sb.append(", thankyouTempalteId=");
		sb.append(getThankyouTempalteId());
		sb.append(", missedyouTempalteId=");
		sb.append(getMissedyouTempalteId());
		sb.append(", mainScheduledDate=");
		sb.append(getMainScheduledDate());
		sb.append(", rem1ScheduledDate=");
		sb.append(getRem1ScheduledDate());
		sb.append(", rem2ScheduledDate=");
		sb.append(getRem2ScheduledDate());
		sb.append(", rem3ScheduledDate=");
		sb.append(getRem3ScheduledDate());
		sb.append(", thankYouScheduledDate=");
		sb.append(getThankYouScheduledDate());
		sb.append(", missedyouScheduledDate=");
		sb.append(getMissedyouScheduledDate());
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
		sb.append(", dlFileEntryId=");
		sb.append(getDlFileEntryId());
		sb.append(", sentBy=");
		sb.append(getSentBy());
		sb.append(", sentDate=");
		sb.append(getSentDate());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", archive=");
		sb.append(getArchive());
		sb.append(", campaignType=");
		sb.append(getCampaignType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailCampaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignName</column-name><column-value><![CDATA[");
		sb.append(getCampaignName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainTempalteId</column-name><column-value><![CDATA[");
		sb.append(getMainTempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem1TempalteId</column-name><column-value><![CDATA[");
		sb.append(getRem1TempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem2TempalteId</column-name><column-value><![CDATA[");
		sb.append(getRem2TempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem3TempalteId</column-name><column-value><![CDATA[");
		sb.append(getRem3TempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thankyouTempalteId</column-name><column-value><![CDATA[");
		sb.append(getThankyouTempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>missedyouTempalteId</column-name><column-value><![CDATA[");
		sb.append(getMissedyouTempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainScheduledDate</column-name><column-value><![CDATA[");
		sb.append(getMainScheduledDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem1ScheduledDate</column-name><column-value><![CDATA[");
		sb.append(getRem1ScheduledDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem2ScheduledDate</column-name><column-value><![CDATA[");
		sb.append(getRem2ScheduledDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem3ScheduledDate</column-name><column-value><![CDATA[");
		sb.append(getRem3ScheduledDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thankYouScheduledDate</column-name><column-value><![CDATA[");
		sb.append(getThankYouScheduledDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>missedyouScheduledDate</column-name><column-value><![CDATA[");
		sb.append(getMissedyouScheduledDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dlFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getDlFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentBy</column-name><column-value><![CDATA[");
		sb.append(getSentBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentDate</column-name><column-value><![CDATA[");
		sb.append(getSentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archive</column-name><column-value><![CDATA[");
		sb.append(getArchive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignType</column-name><column-value><![CDATA[");
		sb.append(getCampaignType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _spMailCampaignRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}