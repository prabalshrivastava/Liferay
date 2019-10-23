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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.processbuilder.service.ClpSerializer;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PEProcessClp extends BaseModelImpl<PEProcess> implements PEProcess {
	public PEProcessClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcess.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcess.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPEProcessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEProcessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEProcessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("definiton", getDefiniton());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("agentEnabled", getAgentEnabled());
		attributes.put("agentRoleIds", getAgentRoleIds());
		attributes.put("approveRoleIds", getApproveRoleIds());
		attributes.put("miscData", getMiscData());
		attributes.put("diagramData", getDiagramData());
		attributes.put("entityTitle", getEntityTitle());
		attributes.put("approverPageName", getApproverPageName());
		attributes.put("userPageName", getUserPageName());
		attributes.put("agentPageName", getAgentPageName());
		attributes.put("status", getStatus());
		attributes.put("applicantRoleId", getApplicantRoleId());
		attributes.put("supervisorRoleIds", getSupervisorRoleIds());
		attributes.put("supervisorPageName", getSupervisorPageName());
		attributes.put("closedReasonVocId", getClosedReasonVocId());
		attributes.put("accountCreationEmailEnabled",
			getAccountCreationEmailEnabled());
		attributes.put("enableAssignment", getEnableAssignment());
		attributes.put("editFeeDetails", getEditFeeDetails());
		attributes.put("scheduleModelId", getScheduleModelId());
		attributes.put("enableSingleSubmission", getEnableSingleSubmission());
		attributes.put("orientation", getOrientation());
		attributes.put("showHeader", getShowHeader());
		attributes.put("enableFirstStepProgress", getEnableFirstStepProgress());
		attributes.put("subProductTypeId", getSubProductTypeId());
		attributes.put("productTypeId", getProductTypeId());
		attributes.put("singleSubmissionErrorMsg", getSingleSubmissionErrorMsg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessId = (Long)attributes.get("spPEProcessId");

		if (spPEProcessId != null) {
			setSpPEProcessId(spPEProcessId);
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

		String definiton = (String)attributes.get("definiton");

		if (definiton != null) {
			setDefiniton(definiton);
		}

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		Boolean agentEnabled = (Boolean)attributes.get("agentEnabled");

		if (agentEnabled != null) {
			setAgentEnabled(agentEnabled);
		}

		String agentRoleIds = (String)attributes.get("agentRoleIds");

		if (agentRoleIds != null) {
			setAgentRoleIds(agentRoleIds);
		}

		String approveRoleIds = (String)attributes.get("approveRoleIds");

		if (approveRoleIds != null) {
			setApproveRoleIds(approveRoleIds);
		}

		String miscData = (String)attributes.get("miscData");

		if (miscData != null) {
			setMiscData(miscData);
		}

		String diagramData = (String)attributes.get("diagramData");

		if (diagramData != null) {
			setDiagramData(diagramData);
		}

		String entityTitle = (String)attributes.get("entityTitle");

		if (entityTitle != null) {
			setEntityTitle(entityTitle);
		}

		String approverPageName = (String)attributes.get("approverPageName");

		if (approverPageName != null) {
			setApproverPageName(approverPageName);
		}

		String userPageName = (String)attributes.get("userPageName");

		if (userPageName != null) {
			setUserPageName(userPageName);
		}

		String agentPageName = (String)attributes.get("agentPageName");

		if (agentPageName != null) {
			setAgentPageName(agentPageName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long applicantRoleId = (Long)attributes.get("applicantRoleId");

		if (applicantRoleId != null) {
			setApplicantRoleId(applicantRoleId);
		}

		String supervisorRoleIds = (String)attributes.get("supervisorRoleIds");

		if (supervisorRoleIds != null) {
			setSupervisorRoleIds(supervisorRoleIds);
		}

		String supervisorPageName = (String)attributes.get("supervisorPageName");

		if (supervisorPageName != null) {
			setSupervisorPageName(supervisorPageName);
		}

		Long closedReasonVocId = (Long)attributes.get("closedReasonVocId");

		if (closedReasonVocId != null) {
			setClosedReasonVocId(closedReasonVocId);
		}

		Boolean accountCreationEmailEnabled = (Boolean)attributes.get(
				"accountCreationEmailEnabled");

		if (accountCreationEmailEnabled != null) {
			setAccountCreationEmailEnabled(accountCreationEmailEnabled);
		}

		Boolean enableAssignment = (Boolean)attributes.get("enableAssignment");

		if (enableAssignment != null) {
			setEnableAssignment(enableAssignment);
		}

		Boolean editFeeDetails = (Boolean)attributes.get("editFeeDetails");

		if (editFeeDetails != null) {
			setEditFeeDetails(editFeeDetails);
		}

		Long scheduleModelId = (Long)attributes.get("scheduleModelId");

		if (scheduleModelId != null) {
			setScheduleModelId(scheduleModelId);
		}

		Boolean enableSingleSubmission = (Boolean)attributes.get(
				"enableSingleSubmission");

		if (enableSingleSubmission != null) {
			setEnableSingleSubmission(enableSingleSubmission);
		}

		String orientation = (String)attributes.get("orientation");

		if (orientation != null) {
			setOrientation(orientation);
		}

		Boolean showHeader = (Boolean)attributes.get("showHeader");

		if (showHeader != null) {
			setShowHeader(showHeader);
		}

		Boolean enableFirstStepProgress = (Boolean)attributes.get(
				"enableFirstStepProgress");

		if (enableFirstStepProgress != null) {
			setEnableFirstStepProgress(enableFirstStepProgress);
		}

		Long subProductTypeId = (Long)attributes.get("subProductTypeId");

		if (subProductTypeId != null) {
			setSubProductTypeId(subProductTypeId);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}

		String singleSubmissionErrorMsg = (String)attributes.get(
				"singleSubmissionErrorMsg");

		if (singleSubmissionErrorMsg != null) {
			setSingleSubmissionErrorMsg(singleSubmissionErrorMsg);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peProcessRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_spPEProcessId = spPEProcessId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessId", long.class);

				method.invoke(_peProcessRemoteModel, spPEProcessId);
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

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peProcessRemoteModel, groupId);
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

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peProcessRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peProcessRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peProcessRemoteModel, userName);
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

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peProcessRemoteModel, createDate);
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

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peProcessRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_peProcessRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefiniton() {
		return _definiton;
	}

	@Override
	public void setDefiniton(String definiton) {
		_definiton = definiton;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setDefiniton", String.class);

				method.invoke(_peProcessRemoteModel, definiton);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassId() {
		return _entityClassId;
	}

	@Override
	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_peProcessRemoteModel, entityClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAgentEnabled() {
		return _agentEnabled;
	}

	@Override
	public boolean isAgentEnabled() {
		return _agentEnabled;
	}

	@Override
	public void setAgentEnabled(boolean agentEnabled) {
		_agentEnabled = agentEnabled;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setAgentEnabled", boolean.class);

				method.invoke(_peProcessRemoteModel, agentEnabled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgentRoleIds() {
		return _agentRoleIds;
	}

	@Override
	public void setAgentRoleIds(String agentRoleIds) {
		_agentRoleIds = agentRoleIds;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setAgentRoleIds", String.class);

				method.invoke(_peProcessRemoteModel, agentRoleIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproveRoleIds() {
		return _approveRoleIds;
	}

	@Override
	public void setApproveRoleIds(String approveRoleIds) {
		_approveRoleIds = approveRoleIds;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setApproveRoleIds",
						String.class);

				method.invoke(_peProcessRemoteModel, approveRoleIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiscData() {
		return _miscData;
	}

	@Override
	public void setMiscData(String miscData) {
		_miscData = miscData;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setMiscData", String.class);

				method.invoke(_peProcessRemoteModel, miscData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiagramData() {
		return _diagramData;
	}

	@Override
	public void setDiagramData(String diagramData) {
		_diagramData = diagramData;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setDiagramData", String.class);

				method.invoke(_peProcessRemoteModel, diagramData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityTitle() {
		return _entityTitle;
	}

	@Override
	public void setEntityTitle(String entityTitle) {
		_entityTitle = entityTitle;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityTitle", String.class);

				method.invoke(_peProcessRemoteModel, entityTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproverPageName() {
		return _approverPageName;
	}

	@Override
	public void setApproverPageName(String approverPageName) {
		_approverPageName = approverPageName;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverPageName",
						String.class);

				method.invoke(_peProcessRemoteModel, approverPageName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserPageName() {
		return _userPageName;
	}

	@Override
	public void setUserPageName(String userPageName) {
		_userPageName = userPageName;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setUserPageName", String.class);

				method.invoke(_peProcessRemoteModel, userPageName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgentPageName() {
		return _agentPageName;
	}

	@Override
	public void setAgentPageName(String agentPageName) {
		_agentPageName = agentPageName;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setAgentPageName", String.class);

				method.invoke(_peProcessRemoteModel, agentPageName);
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

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_peProcessRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicantRoleId() {
		return _applicantRoleId;
	}

	@Override
	public void setApplicantRoleId(long applicantRoleId) {
		_applicantRoleId = applicantRoleId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantRoleId", long.class);

				method.invoke(_peProcessRemoteModel, applicantRoleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupervisorRoleIds() {
		return _supervisorRoleIds;
	}

	@Override
	public void setSupervisorRoleIds(String supervisorRoleIds) {
		_supervisorRoleIds = supervisorRoleIds;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorRoleIds",
						String.class);

				method.invoke(_peProcessRemoteModel, supervisorRoleIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupervisorPageName() {
		return _supervisorPageName;
	}

	@Override
	public void setSupervisorPageName(String supervisorPageName) {
		_supervisorPageName = supervisorPageName;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorPageName",
						String.class);

				method.invoke(_peProcessRemoteModel, supervisorPageName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClosedReasonVocId() {
		return _closedReasonVocId;
	}

	@Override
	public void setClosedReasonVocId(long closedReasonVocId) {
		_closedReasonVocId = closedReasonVocId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setClosedReasonVocId",
						long.class);

				method.invoke(_peProcessRemoteModel, closedReasonVocId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAccountCreationEmailEnabled() {
		return _accountCreationEmailEnabled;
	}

	@Override
	public boolean isAccountCreationEmailEnabled() {
		return _accountCreationEmailEnabled;
	}

	@Override
	public void setAccountCreationEmailEnabled(
		boolean accountCreationEmailEnabled) {
		_accountCreationEmailEnabled = accountCreationEmailEnabled;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountCreationEmailEnabled",
						boolean.class);

				method.invoke(_peProcessRemoteModel, accountCreationEmailEnabled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableAssignment() {
		return _enableAssignment;
	}

	@Override
	public boolean isEnableAssignment() {
		return _enableAssignment;
	}

	@Override
	public void setEnableAssignment(boolean enableAssignment) {
		_enableAssignment = enableAssignment;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableAssignment",
						boolean.class);

				method.invoke(_peProcessRemoteModel, enableAssignment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEditFeeDetails() {
		return _editFeeDetails;
	}

	@Override
	public boolean isEditFeeDetails() {
		return _editFeeDetails;
	}

	@Override
	public void setEditFeeDetails(boolean editFeeDetails) {
		_editFeeDetails = editFeeDetails;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setEditFeeDetails",
						boolean.class);

				method.invoke(_peProcessRemoteModel, editFeeDetails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScheduleModelId() {
		return _scheduleModelId;
	}

	@Override
	public void setScheduleModelId(long scheduleModelId) {
		_scheduleModelId = scheduleModelId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setScheduleModelId", long.class);

				method.invoke(_peProcessRemoteModel, scheduleModelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableSingleSubmission() {
		return _enableSingleSubmission;
	}

	@Override
	public boolean isEnableSingleSubmission() {
		return _enableSingleSubmission;
	}

	@Override
	public void setEnableSingleSubmission(boolean enableSingleSubmission) {
		_enableSingleSubmission = enableSingleSubmission;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableSingleSubmission",
						boolean.class);

				method.invoke(_peProcessRemoteModel, enableSingleSubmission);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrientation() {
		return _orientation;
	}

	@Override
	public void setOrientation(String orientation) {
		_orientation = orientation;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setOrientation", String.class);

				method.invoke(_peProcessRemoteModel, orientation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getShowHeader() {
		return _showHeader;
	}

	@Override
	public boolean isShowHeader() {
		return _showHeader;
	}

	@Override
	public void setShowHeader(boolean showHeader) {
		_showHeader = showHeader;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setShowHeader", boolean.class);

				method.invoke(_peProcessRemoteModel, showHeader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableFirstStepProgress() {
		return _enableFirstStepProgress;
	}

	@Override
	public boolean isEnableFirstStepProgress() {
		return _enableFirstStepProgress;
	}

	@Override
	public void setEnableFirstStepProgress(boolean enableFirstStepProgress) {
		_enableFirstStepProgress = enableFirstStepProgress;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableFirstStepProgress",
						boolean.class);

				method.invoke(_peProcessRemoteModel, enableFirstStepProgress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubProductTypeId() {
		return _subProductTypeId;
	}

	@Override
	public void setSubProductTypeId(long subProductTypeId) {
		_subProductTypeId = subProductTypeId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProductTypeId",
						long.class);

				method.invoke(_peProcessRemoteModel, subProductTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductTypeId() {
		return _productTypeId;
	}

	@Override
	public void setProductTypeId(long productTypeId) {
		_productTypeId = productTypeId;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setProductTypeId", long.class);

				method.invoke(_peProcessRemoteModel, productTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSingleSubmissionErrorMsg() {
		return _singleSubmissionErrorMsg;
	}

	@Override
	public void setSingleSubmissionErrorMsg(String singleSubmissionErrorMsg) {
		_singleSubmissionErrorMsg = singleSubmissionErrorMsg;

		if (_peProcessRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setSingleSubmissionErrorMsg",
						String.class);

				method.invoke(_peProcessRemoteModel, singleSubmissionErrorMsg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEProcess.class.getName()));
	}

	public BaseModel<?> getPEProcessRemoteModel() {
		return _peProcessRemoteModel;
	}

	public void setPEProcessRemoteModel(BaseModel<?> peProcessRemoteModel) {
		_peProcessRemoteModel = peProcessRemoteModel;
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

		Class<?> remoteModelClass = _peProcessRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peProcessRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PEProcessLocalServiceUtil.addPEProcess(this);
		}
		else {
			PEProcessLocalServiceUtil.updatePEProcess(this);
		}
	}

	@Override
	public PEProcess toEscapedModel() {
		return (PEProcess)ProxyUtil.newProxyInstance(PEProcess.class.getClassLoader(),
			new Class[] { PEProcess.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PEProcessClp clone = new PEProcessClp();

		clone.setUuid(getUuid());
		clone.setSpPEProcessId(getSpPEProcessId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setDefiniton(getDefiniton());
		clone.setEntityClassId(getEntityClassId());
		clone.setAgentEnabled(getAgentEnabled());
		clone.setAgentRoleIds(getAgentRoleIds());
		clone.setApproveRoleIds(getApproveRoleIds());
		clone.setMiscData(getMiscData());
		clone.setDiagramData(getDiagramData());
		clone.setEntityTitle(getEntityTitle());
		clone.setApproverPageName(getApproverPageName());
		clone.setUserPageName(getUserPageName());
		clone.setAgentPageName(getAgentPageName());
		clone.setStatus(getStatus());
		clone.setApplicantRoleId(getApplicantRoleId());
		clone.setSupervisorRoleIds(getSupervisorRoleIds());
		clone.setSupervisorPageName(getSupervisorPageName());
		clone.setClosedReasonVocId(getClosedReasonVocId());
		clone.setAccountCreationEmailEnabled(getAccountCreationEmailEnabled());
		clone.setEnableAssignment(getEnableAssignment());
		clone.setEditFeeDetails(getEditFeeDetails());
		clone.setScheduleModelId(getScheduleModelId());
		clone.setEnableSingleSubmission(getEnableSingleSubmission());
		clone.setOrientation(getOrientation());
		clone.setShowHeader(getShowHeader());
		clone.setEnableFirstStepProgress(getEnableFirstStepProgress());
		clone.setSubProductTypeId(getSubProductTypeId());
		clone.setProductTypeId(getProductTypeId());
		clone.setSingleSubmissionErrorMsg(getSingleSubmissionErrorMsg());

		return clone;
	}

	@Override
	public int compareTo(PEProcess peProcess) {
		int value = 0;

		value = getName().compareTo(peProcess.getName());

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

		if (!(obj instanceof PEProcessClp)) {
			return false;
		}

		PEProcessClp peProcess = (PEProcessClp)obj;

		long primaryKey = peProcess.getPrimaryKey();

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
		StringBundler sb = new StringBundler(73);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEProcessId=");
		sb.append(getSpPEProcessId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", definiton=");
		sb.append(getDefiniton());
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", agentEnabled=");
		sb.append(getAgentEnabled());
		sb.append(", agentRoleIds=");
		sb.append(getAgentRoleIds());
		sb.append(", approveRoleIds=");
		sb.append(getApproveRoleIds());
		sb.append(", miscData=");
		sb.append(getMiscData());
		sb.append(", diagramData=");
		sb.append(getDiagramData());
		sb.append(", entityTitle=");
		sb.append(getEntityTitle());
		sb.append(", approverPageName=");
		sb.append(getApproverPageName());
		sb.append(", userPageName=");
		sb.append(getUserPageName());
		sb.append(", agentPageName=");
		sb.append(getAgentPageName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", applicantRoleId=");
		sb.append(getApplicantRoleId());
		sb.append(", supervisorRoleIds=");
		sb.append(getSupervisorRoleIds());
		sb.append(", supervisorPageName=");
		sb.append(getSupervisorPageName());
		sb.append(", closedReasonVocId=");
		sb.append(getClosedReasonVocId());
		sb.append(", accountCreationEmailEnabled=");
		sb.append(getAccountCreationEmailEnabled());
		sb.append(", enableAssignment=");
		sb.append(getEnableAssignment());
		sb.append(", editFeeDetails=");
		sb.append(getEditFeeDetails());
		sb.append(", scheduleModelId=");
		sb.append(getScheduleModelId());
		sb.append(", enableSingleSubmission=");
		sb.append(getEnableSingleSubmission());
		sb.append(", orientation=");
		sb.append(getOrientation());
		sb.append(", showHeader=");
		sb.append(getShowHeader());
		sb.append(", enableFirstStepProgress=");
		sb.append(getEnableFirstStepProgress());
		sb.append(", subProductTypeId=");
		sb.append(getSubProductTypeId());
		sb.append(", productTypeId=");
		sb.append(getProductTypeId());
		sb.append(", singleSubmissionErrorMsg=");
		sb.append(getSingleSubmissionErrorMsg());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.processbuilder.model.PEProcess");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>definiton</column-name><column-value><![CDATA[");
		sb.append(getDefiniton());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agentEnabled</column-name><column-value><![CDATA[");
		sb.append(getAgentEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agentRoleIds</column-name><column-value><![CDATA[");
		sb.append(getAgentRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approveRoleIds</column-name><column-value><![CDATA[");
		sb.append(getApproveRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>miscData</column-name><column-value><![CDATA[");
		sb.append(getMiscData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diagramData</column-name><column-value><![CDATA[");
		sb.append(getDiagramData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityTitle</column-name><column-value><![CDATA[");
		sb.append(getEntityTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverPageName</column-name><column-value><![CDATA[");
		sb.append(getApproverPageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userPageName</column-name><column-value><![CDATA[");
		sb.append(getUserPageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agentPageName</column-name><column-value><![CDATA[");
		sb.append(getAgentPageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantRoleId</column-name><column-value><![CDATA[");
		sb.append(getApplicantRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisorRoleIds</column-name><column-value><![CDATA[");
		sb.append(getSupervisorRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisorPageName</column-name><column-value><![CDATA[");
		sb.append(getSupervisorPageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closedReasonVocId</column-name><column-value><![CDATA[");
		sb.append(getClosedReasonVocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountCreationEmailEnabled</column-name><column-value><![CDATA[");
		sb.append(getAccountCreationEmailEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableAssignment</column-name><column-value><![CDATA[");
		sb.append(getEnableAssignment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editFeeDetails</column-name><column-value><![CDATA[");
		sb.append(getEditFeeDetails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleModelId</column-name><column-value><![CDATA[");
		sb.append(getScheduleModelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableSingleSubmission</column-name><column-value><![CDATA[");
		sb.append(getEnableSingleSubmission());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orientation</column-name><column-value><![CDATA[");
		sb.append(getOrientation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showHeader</column-name><column-value><![CDATA[");
		sb.append(getShowHeader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableFirstStepProgress</column-name><column-value><![CDATA[");
		sb.append(getEnableFirstStepProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subProductTypeId</column-name><column-value><![CDATA[");
		sb.append(getSubProductTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productTypeId</column-name><column-value><![CDATA[");
		sb.append(getProductTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>singleSubmissionErrorMsg</column-name><column-value><![CDATA[");
		sb.append(getSingleSubmissionErrorMsg());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPEProcessId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _definiton;
	private long _entityClassId;
	private boolean _agentEnabled;
	private String _agentRoleIds;
	private String _approveRoleIds;
	private String _miscData;
	private String _diagramData;
	private String _entityTitle;
	private String _approverPageName;
	private String _userPageName;
	private String _agentPageName;
	private int _status;
	private long _applicantRoleId;
	private String _supervisorRoleIds;
	private String _supervisorPageName;
	private long _closedReasonVocId;
	private boolean _accountCreationEmailEnabled;
	private boolean _enableAssignment;
	private boolean _editFeeDetails;
	private long _scheduleModelId;
	private boolean _enableSingleSubmission;
	private String _orientation;
	private boolean _showHeader;
	private boolean _enableFirstStepProgress;
	private long _subProductTypeId;
	private long _productTypeId;
	private String _singleSubmissionErrorMsg;
	private BaseModel<?> _peProcessRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}