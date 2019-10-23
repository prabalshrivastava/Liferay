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

package com.sambaash.platform.srv.processbuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.processbuilder.model.PEProcess;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PEProcess in entity cache.
 *
 * @author nareshchebolu
 * @see PEProcess
 * @generated
 */
public class PEProcessCacheModel implements CacheModel<PEProcess>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEProcessId=");
		sb.append(spPEProcessId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", definiton=");
		sb.append(definiton);
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", agentEnabled=");
		sb.append(agentEnabled);
		sb.append(", agentRoleIds=");
		sb.append(agentRoleIds);
		sb.append(", approveRoleIds=");
		sb.append(approveRoleIds);
		sb.append(", miscData=");
		sb.append(miscData);
		sb.append(", diagramData=");
		sb.append(diagramData);
		sb.append(", entityTitle=");
		sb.append(entityTitle);
		sb.append(", approverPageName=");
		sb.append(approverPageName);
		sb.append(", userPageName=");
		sb.append(userPageName);
		sb.append(", agentPageName=");
		sb.append(agentPageName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", applicantRoleId=");
		sb.append(applicantRoleId);
		sb.append(", supervisorRoleIds=");
		sb.append(supervisorRoleIds);
		sb.append(", supervisorPageName=");
		sb.append(supervisorPageName);
		sb.append(", closedReasonVocId=");
		sb.append(closedReasonVocId);
		sb.append(", accountCreationEmailEnabled=");
		sb.append(accountCreationEmailEnabled);
		sb.append(", enableAssignment=");
		sb.append(enableAssignment);
		sb.append(", editFeeDetails=");
		sb.append(editFeeDetails);
		sb.append(", scheduleModelId=");
		sb.append(scheduleModelId);
		sb.append(", enableSingleSubmission=");
		sb.append(enableSingleSubmission);
		sb.append(", orientation=");
		sb.append(orientation);
		sb.append(", showHeader=");
		sb.append(showHeader);
		sb.append(", enableFirstStepProgress=");
		sb.append(enableFirstStepProgress);
		sb.append(", subProductTypeId=");
		sb.append(subProductTypeId);
		sb.append(", productTypeId=");
		sb.append(productTypeId);
		sb.append(", singleSubmissionErrorMsg=");
		sb.append(singleSubmissionErrorMsg);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PEProcess toEntityModel() {
		PEProcessImpl peProcessImpl = new PEProcessImpl();

		if (uuid == null) {
			peProcessImpl.setUuid(StringPool.BLANK);
		}
		else {
			peProcessImpl.setUuid(uuid);
		}

		peProcessImpl.setSpPEProcessId(spPEProcessId);
		peProcessImpl.setGroupId(groupId);
		peProcessImpl.setCompanyId(companyId);
		peProcessImpl.setUserId(userId);

		if (userName == null) {
			peProcessImpl.setUserName(StringPool.BLANK);
		}
		else {
			peProcessImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peProcessImpl.setCreateDate(null);
		}
		else {
			peProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peProcessImpl.setModifiedDate(null);
		}
		else {
			peProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			peProcessImpl.setName(StringPool.BLANK);
		}
		else {
			peProcessImpl.setName(name);
		}

		if (definiton == null) {
			peProcessImpl.setDefiniton(StringPool.BLANK);
		}
		else {
			peProcessImpl.setDefiniton(definiton);
		}

		peProcessImpl.setEntityClassId(entityClassId);
		peProcessImpl.setAgentEnabled(agentEnabled);

		if (agentRoleIds == null) {
			peProcessImpl.setAgentRoleIds(StringPool.BLANK);
		}
		else {
			peProcessImpl.setAgentRoleIds(agentRoleIds);
		}

		if (approveRoleIds == null) {
			peProcessImpl.setApproveRoleIds(StringPool.BLANK);
		}
		else {
			peProcessImpl.setApproveRoleIds(approveRoleIds);
		}

		if (miscData == null) {
			peProcessImpl.setMiscData(StringPool.BLANK);
		}
		else {
			peProcessImpl.setMiscData(miscData);
		}

		if (diagramData == null) {
			peProcessImpl.setDiagramData(StringPool.BLANK);
		}
		else {
			peProcessImpl.setDiagramData(diagramData);
		}

		if (entityTitle == null) {
			peProcessImpl.setEntityTitle(StringPool.BLANK);
		}
		else {
			peProcessImpl.setEntityTitle(entityTitle);
		}

		if (approverPageName == null) {
			peProcessImpl.setApproverPageName(StringPool.BLANK);
		}
		else {
			peProcessImpl.setApproverPageName(approverPageName);
		}

		if (userPageName == null) {
			peProcessImpl.setUserPageName(StringPool.BLANK);
		}
		else {
			peProcessImpl.setUserPageName(userPageName);
		}

		if (agentPageName == null) {
			peProcessImpl.setAgentPageName(StringPool.BLANK);
		}
		else {
			peProcessImpl.setAgentPageName(agentPageName);
		}

		peProcessImpl.setStatus(status);
		peProcessImpl.setApplicantRoleId(applicantRoleId);

		if (supervisorRoleIds == null) {
			peProcessImpl.setSupervisorRoleIds(StringPool.BLANK);
		}
		else {
			peProcessImpl.setSupervisorRoleIds(supervisorRoleIds);
		}

		if (supervisorPageName == null) {
			peProcessImpl.setSupervisorPageName(StringPool.BLANK);
		}
		else {
			peProcessImpl.setSupervisorPageName(supervisorPageName);
		}

		peProcessImpl.setClosedReasonVocId(closedReasonVocId);
		peProcessImpl.setAccountCreationEmailEnabled(accountCreationEmailEnabled);
		peProcessImpl.setEnableAssignment(enableAssignment);
		peProcessImpl.setEditFeeDetails(editFeeDetails);
		peProcessImpl.setScheduleModelId(scheduleModelId);
		peProcessImpl.setEnableSingleSubmission(enableSingleSubmission);

		if (orientation == null) {
			peProcessImpl.setOrientation(StringPool.BLANK);
		}
		else {
			peProcessImpl.setOrientation(orientation);
		}

		peProcessImpl.setShowHeader(showHeader);
		peProcessImpl.setEnableFirstStepProgress(enableFirstStepProgress);
		peProcessImpl.setSubProductTypeId(subProductTypeId);
		peProcessImpl.setProductTypeId(productTypeId);

		if (singleSubmissionErrorMsg == null) {
			peProcessImpl.setSingleSubmissionErrorMsg(StringPool.BLANK);
		}
		else {
			peProcessImpl.setSingleSubmissionErrorMsg(singleSubmissionErrorMsg);
		}

		peProcessImpl.resetOriginalValues();

		return peProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEProcessId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		definiton = objectInput.readUTF();
		entityClassId = objectInput.readLong();
		agentEnabled = objectInput.readBoolean();
		agentRoleIds = objectInput.readUTF();
		approveRoleIds = objectInput.readUTF();
		miscData = objectInput.readUTF();
		diagramData = objectInput.readUTF();
		entityTitle = objectInput.readUTF();
		approverPageName = objectInput.readUTF();
		userPageName = objectInput.readUTF();
		agentPageName = objectInput.readUTF();
		status = objectInput.readInt();
		applicantRoleId = objectInput.readLong();
		supervisorRoleIds = objectInput.readUTF();
		supervisorPageName = objectInput.readUTF();
		closedReasonVocId = objectInput.readLong();
		accountCreationEmailEnabled = objectInput.readBoolean();
		enableAssignment = objectInput.readBoolean();
		editFeeDetails = objectInput.readBoolean();
		scheduleModelId = objectInput.readLong();
		enableSingleSubmission = objectInput.readBoolean();
		orientation = objectInput.readUTF();
		showHeader = objectInput.readBoolean();
		enableFirstStepProgress = objectInput.readBoolean();
		subProductTypeId = objectInput.readLong();
		productTypeId = objectInput.readLong();
		singleSubmissionErrorMsg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(spPEProcessId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (definiton == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(definiton);
		}

		objectOutput.writeLong(entityClassId);
		objectOutput.writeBoolean(agentEnabled);

		if (agentRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agentRoleIds);
		}

		if (approveRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(approveRoleIds);
		}

		if (miscData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(miscData);
		}

		if (diagramData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diagramData);
		}

		if (entityTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityTitle);
		}

		if (approverPageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(approverPageName);
		}

		if (userPageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userPageName);
		}

		if (agentPageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agentPageName);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(applicantRoleId);

		if (supervisorRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supervisorRoleIds);
		}

		if (supervisorPageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supervisorPageName);
		}

		objectOutput.writeLong(closedReasonVocId);
		objectOutput.writeBoolean(accountCreationEmailEnabled);
		objectOutput.writeBoolean(enableAssignment);
		objectOutput.writeBoolean(editFeeDetails);
		objectOutput.writeLong(scheduleModelId);
		objectOutput.writeBoolean(enableSingleSubmission);

		if (orientation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orientation);
		}

		objectOutput.writeBoolean(showHeader);
		objectOutput.writeBoolean(enableFirstStepProgress);
		objectOutput.writeLong(subProductTypeId);
		objectOutput.writeLong(productTypeId);

		if (singleSubmissionErrorMsg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(singleSubmissionErrorMsg);
		}
	}

	public String uuid;
	public long spPEProcessId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String definiton;
	public long entityClassId;
	public boolean agentEnabled;
	public String agentRoleIds;
	public String approveRoleIds;
	public String miscData;
	public String diagramData;
	public String entityTitle;
	public String approverPageName;
	public String userPageName;
	public String agentPageName;
	public int status;
	public long applicantRoleId;
	public String supervisorRoleIds;
	public String supervisorPageName;
	public long closedReasonVocId;
	public boolean accountCreationEmailEnabled;
	public boolean enableAssignment;
	public boolean editFeeDetails;
	public long scheduleModelId;
	public boolean enableSingleSubmission;
	public String orientation;
	public boolean showHeader;
	public boolean enableFirstStepProgress;
	public long subProductTypeId;
	public long productTypeId;
	public String singleSubmissionErrorMsg;
}