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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nareshchebolu
 * @generated
 */
public class PEProcessSoap implements Serializable {
	public static PEProcessSoap toSoapModel(PEProcess model) {
		PEProcessSoap soapModel = new PEProcessSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPEProcessId(model.getSpPEProcessId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDefiniton(model.getDefiniton());
		soapModel.setEntityClassId(model.getEntityClassId());
		soapModel.setAgentEnabled(model.getAgentEnabled());
		soapModel.setAgentRoleIds(model.getAgentRoleIds());
		soapModel.setApproveRoleIds(model.getApproveRoleIds());
		soapModel.setMiscData(model.getMiscData());
		soapModel.setDiagramData(model.getDiagramData());
		soapModel.setEntityTitle(model.getEntityTitle());
		soapModel.setApproverPageName(model.getApproverPageName());
		soapModel.setUserPageName(model.getUserPageName());
		soapModel.setAgentPageName(model.getAgentPageName());
		soapModel.setStatus(model.getStatus());
		soapModel.setApplicantRoleId(model.getApplicantRoleId());
		soapModel.setSupervisorRoleIds(model.getSupervisorRoleIds());
		soapModel.setSupervisorPageName(model.getSupervisorPageName());
		soapModel.setClosedReasonVocId(model.getClosedReasonVocId());
		soapModel.setAccountCreationEmailEnabled(model.getAccountCreationEmailEnabled());
		soapModel.setEnableAssignment(model.getEnableAssignment());
		soapModel.setEditFeeDetails(model.getEditFeeDetails());
		soapModel.setScheduleModelId(model.getScheduleModelId());
		soapModel.setEnableSingleSubmission(model.getEnableSingleSubmission());
		soapModel.setOrientation(model.getOrientation());
		soapModel.setShowHeader(model.getShowHeader());
		soapModel.setEnableFirstStepProgress(model.getEnableFirstStepProgress());
		soapModel.setSubProductTypeId(model.getSubProductTypeId());
		soapModel.setProductTypeId(model.getProductTypeId());
		soapModel.setSingleSubmissionErrorMsg(model.getSingleSubmissionErrorMsg());

		return soapModel;
	}

	public static PEProcessSoap[] toSoapModels(PEProcess[] models) {
		PEProcessSoap[] soapModels = new PEProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PEProcessSoap[][] toSoapModels(PEProcess[][] models) {
		PEProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PEProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PEProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PEProcessSoap[] toSoapModels(List<PEProcess> models) {
		List<PEProcessSoap> soapModels = new ArrayList<PEProcessSoap>(models.size());

		for (PEProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PEProcessSoap[soapModels.size()]);
	}

	public PEProcessSoap() {
	}

	public long getPrimaryKey() {
		return _spPEProcessId;
	}

	public void setPrimaryKey(long pk) {
		setSpPEProcessId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	public void setSpPEProcessId(long spPEProcessId) {
		_spPEProcessId = spPEProcessId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDefiniton() {
		return _definiton;
	}

	public void setDefiniton(String definiton) {
		_definiton = definiton;
	}

	public long getEntityClassId() {
		return _entityClassId;
	}

	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;
	}

	public boolean getAgentEnabled() {
		return _agentEnabled;
	}

	public boolean isAgentEnabled() {
		return _agentEnabled;
	}

	public void setAgentEnabled(boolean agentEnabled) {
		_agentEnabled = agentEnabled;
	}

	public String getAgentRoleIds() {
		return _agentRoleIds;
	}

	public void setAgentRoleIds(String agentRoleIds) {
		_agentRoleIds = agentRoleIds;
	}

	public String getApproveRoleIds() {
		return _approveRoleIds;
	}

	public void setApproveRoleIds(String approveRoleIds) {
		_approveRoleIds = approveRoleIds;
	}

	public String getMiscData() {
		return _miscData;
	}

	public void setMiscData(String miscData) {
		_miscData = miscData;
	}

	public String getDiagramData() {
		return _diagramData;
	}

	public void setDiagramData(String diagramData) {
		_diagramData = diagramData;
	}

	public String getEntityTitle() {
		return _entityTitle;
	}

	public void setEntityTitle(String entityTitle) {
		_entityTitle = entityTitle;
	}

	public String getApproverPageName() {
		return _approverPageName;
	}

	public void setApproverPageName(String approverPageName) {
		_approverPageName = approverPageName;
	}

	public String getUserPageName() {
		return _userPageName;
	}

	public void setUserPageName(String userPageName) {
		_userPageName = userPageName;
	}

	public String getAgentPageName() {
		return _agentPageName;
	}

	public void setAgentPageName(String agentPageName) {
		_agentPageName = agentPageName;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getApplicantRoleId() {
		return _applicantRoleId;
	}

	public void setApplicantRoleId(long applicantRoleId) {
		_applicantRoleId = applicantRoleId;
	}

	public String getSupervisorRoleIds() {
		return _supervisorRoleIds;
	}

	public void setSupervisorRoleIds(String supervisorRoleIds) {
		_supervisorRoleIds = supervisorRoleIds;
	}

	public String getSupervisorPageName() {
		return _supervisorPageName;
	}

	public void setSupervisorPageName(String supervisorPageName) {
		_supervisorPageName = supervisorPageName;
	}

	public long getClosedReasonVocId() {
		return _closedReasonVocId;
	}

	public void setClosedReasonVocId(long closedReasonVocId) {
		_closedReasonVocId = closedReasonVocId;
	}

	public boolean getAccountCreationEmailEnabled() {
		return _accountCreationEmailEnabled;
	}

	public boolean isAccountCreationEmailEnabled() {
		return _accountCreationEmailEnabled;
	}

	public void setAccountCreationEmailEnabled(
		boolean accountCreationEmailEnabled) {
		_accountCreationEmailEnabled = accountCreationEmailEnabled;
	}

	public boolean getEnableAssignment() {
		return _enableAssignment;
	}

	public boolean isEnableAssignment() {
		return _enableAssignment;
	}

	public void setEnableAssignment(boolean enableAssignment) {
		_enableAssignment = enableAssignment;
	}

	public boolean getEditFeeDetails() {
		return _editFeeDetails;
	}

	public boolean isEditFeeDetails() {
		return _editFeeDetails;
	}

	public void setEditFeeDetails(boolean editFeeDetails) {
		_editFeeDetails = editFeeDetails;
	}

	public long getScheduleModelId() {
		return _scheduleModelId;
	}

	public void setScheduleModelId(long scheduleModelId) {
		_scheduleModelId = scheduleModelId;
	}

	public boolean getEnableSingleSubmission() {
		return _enableSingleSubmission;
	}

	public boolean isEnableSingleSubmission() {
		return _enableSingleSubmission;
	}

	public void setEnableSingleSubmission(boolean enableSingleSubmission) {
		_enableSingleSubmission = enableSingleSubmission;
	}

	public String getOrientation() {
		return _orientation;
	}

	public void setOrientation(String orientation) {
		_orientation = orientation;
	}

	public boolean getShowHeader() {
		return _showHeader;
	}

	public boolean isShowHeader() {
		return _showHeader;
	}

	public void setShowHeader(boolean showHeader) {
		_showHeader = showHeader;
	}

	public boolean getEnableFirstStepProgress() {
		return _enableFirstStepProgress;
	}

	public boolean isEnableFirstStepProgress() {
		return _enableFirstStepProgress;
	}

	public void setEnableFirstStepProgress(boolean enableFirstStepProgress) {
		_enableFirstStepProgress = enableFirstStepProgress;
	}

	public long getSubProductTypeId() {
		return _subProductTypeId;
	}

	public void setSubProductTypeId(long subProductTypeId) {
		_subProductTypeId = subProductTypeId;
	}

	public long getProductTypeId() {
		return _productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		_productTypeId = productTypeId;
	}

	public String getSingleSubmissionErrorMsg() {
		return _singleSubmissionErrorMsg;
	}

	public void setSingleSubmissionErrorMsg(String singleSubmissionErrorMsg) {
		_singleSubmissionErrorMsg = singleSubmissionErrorMsg;
	}

	private String _uuid;
	private long _spPEProcessId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}