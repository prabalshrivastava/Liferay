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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PEProcess service. Represents a row in the &quot;SPPEProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcess
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PEProcessImpl
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl
 * @generated
 */
public interface PEProcessModel extends BaseModel<PEProcess>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p e process model instance should use the {@link PEProcess} interface instead.
	 */

	/**
	 * Returns the primary key of this p e process.
	 *
	 * @return the primary key of this p e process
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p e process.
	 *
	 * @param primaryKey the primary key of this p e process
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this p e process.
	 *
	 * @return the uuid of this p e process
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this p e process.
	 *
	 * @param uuid the uuid of this p e process
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp p e process ID of this p e process.
	 *
	 * @return the sp p e process ID of this p e process
	 */
	public long getSpPEProcessId();

	/**
	 * Sets the sp p e process ID of this p e process.
	 *
	 * @param spPEProcessId the sp p e process ID of this p e process
	 */
	public void setSpPEProcessId(long spPEProcessId);

	/**
	 * Returns the group ID of this p e process.
	 *
	 * @return the group ID of this p e process
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this p e process.
	 *
	 * @param groupId the group ID of this p e process
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this p e process.
	 *
	 * @return the company ID of this p e process
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this p e process.
	 *
	 * @param companyId the company ID of this p e process
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this p e process.
	 *
	 * @return the user ID of this p e process
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this p e process.
	 *
	 * @param userId the user ID of this p e process
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this p e process.
	 *
	 * @return the user uuid of this p e process
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p e process.
	 *
	 * @param userUuid the user uuid of this p e process
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this p e process.
	 *
	 * @return the user name of this p e process
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this p e process.
	 *
	 * @param userName the user name of this p e process
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this p e process.
	 *
	 * @return the create date of this p e process
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this p e process.
	 *
	 * @param createDate the create date of this p e process
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this p e process.
	 *
	 * @return the modified date of this p e process
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this p e process.
	 *
	 * @param modifiedDate the modified date of this p e process
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this p e process.
	 *
	 * @return the name of this p e process
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this p e process.
	 *
	 * @param name the name of this p e process
	 */
	public void setName(String name);

	/**
	 * Returns the definiton of this p e process.
	 *
	 * @return the definiton of this p e process
	 */
	@AutoEscape
	public String getDefiniton();

	/**
	 * Sets the definiton of this p e process.
	 *
	 * @param definiton the definiton of this p e process
	 */
	public void setDefiniton(String definiton);

	/**
	 * Returns the entity class ID of this p e process.
	 *
	 * @return the entity class ID of this p e process
	 */
	public long getEntityClassId();

	/**
	 * Sets the entity class ID of this p e process.
	 *
	 * @param entityClassId the entity class ID of this p e process
	 */
	public void setEntityClassId(long entityClassId);

	/**
	 * Returns the agent enabled of this p e process.
	 *
	 * @return the agent enabled of this p e process
	 */
	public boolean getAgentEnabled();

	/**
	 * Returns <code>true</code> if this p e process is agent enabled.
	 *
	 * @return <code>true</code> if this p e process is agent enabled; <code>false</code> otherwise
	 */
	public boolean isAgentEnabled();

	/**
	 * Sets whether this p e process is agent enabled.
	 *
	 * @param agentEnabled the agent enabled of this p e process
	 */
	public void setAgentEnabled(boolean agentEnabled);

	/**
	 * Returns the agent role IDs of this p e process.
	 *
	 * @return the agent role IDs of this p e process
	 */
	@AutoEscape
	public String getAgentRoleIds();

	/**
	 * Sets the agent role IDs of this p e process.
	 *
	 * @param agentRoleIds the agent role IDs of this p e process
	 */
	public void setAgentRoleIds(String agentRoleIds);

	/**
	 * Returns the approve role IDs of this p e process.
	 *
	 * @return the approve role IDs of this p e process
	 */
	@AutoEscape
	public String getApproveRoleIds();

	/**
	 * Sets the approve role IDs of this p e process.
	 *
	 * @param approveRoleIds the approve role IDs of this p e process
	 */
	public void setApproveRoleIds(String approveRoleIds);

	/**
	 * Returns the misc data of this p e process.
	 *
	 * @return the misc data of this p e process
	 */
	@AutoEscape
	public String getMiscData();

	/**
	 * Sets the misc data of this p e process.
	 *
	 * @param miscData the misc data of this p e process
	 */
	public void setMiscData(String miscData);

	/**
	 * Returns the diagram data of this p e process.
	 *
	 * @return the diagram data of this p e process
	 */
	@AutoEscape
	public String getDiagramData();

	/**
	 * Sets the diagram data of this p e process.
	 *
	 * @param diagramData the diagram data of this p e process
	 */
	public void setDiagramData(String diagramData);

	/**
	 * Returns the entity title of this p e process.
	 *
	 * @return the entity title of this p e process
	 */
	@AutoEscape
	public String getEntityTitle();

	/**
	 * Sets the entity title of this p e process.
	 *
	 * @param entityTitle the entity title of this p e process
	 */
	public void setEntityTitle(String entityTitle);

	/**
	 * Returns the approver page name of this p e process.
	 *
	 * @return the approver page name of this p e process
	 */
	@AutoEscape
	public String getApproverPageName();

	/**
	 * Sets the approver page name of this p e process.
	 *
	 * @param approverPageName the approver page name of this p e process
	 */
	public void setApproverPageName(String approverPageName);

	/**
	 * Returns the user page name of this p e process.
	 *
	 * @return the user page name of this p e process
	 */
	@AutoEscape
	public String getUserPageName();

	/**
	 * Sets the user page name of this p e process.
	 *
	 * @param userPageName the user page name of this p e process
	 */
	public void setUserPageName(String userPageName);

	/**
	 * Returns the agent page name of this p e process.
	 *
	 * @return the agent page name of this p e process
	 */
	@AutoEscape
	public String getAgentPageName();

	/**
	 * Sets the agent page name of this p e process.
	 *
	 * @param agentPageName the agent page name of this p e process
	 */
	public void setAgentPageName(String agentPageName);

	/**
	 * Returns the status of this p e process.
	 *
	 * @return the status of this p e process
	 */
	public int getStatus();

	/**
	 * Sets the status of this p e process.
	 *
	 * @param status the status of this p e process
	 */
	public void setStatus(int status);

	/**
	 * Returns the applicant role ID of this p e process.
	 *
	 * @return the applicant role ID of this p e process
	 */
	public long getApplicantRoleId();

	/**
	 * Sets the applicant role ID of this p e process.
	 *
	 * @param applicantRoleId the applicant role ID of this p e process
	 */
	public void setApplicantRoleId(long applicantRoleId);

	/**
	 * Returns the supervisor role IDs of this p e process.
	 *
	 * @return the supervisor role IDs of this p e process
	 */
	@AutoEscape
	public String getSupervisorRoleIds();

	/**
	 * Sets the supervisor role IDs of this p e process.
	 *
	 * @param supervisorRoleIds the supervisor role IDs of this p e process
	 */
	public void setSupervisorRoleIds(String supervisorRoleIds);

	/**
	 * Returns the supervisor page name of this p e process.
	 *
	 * @return the supervisor page name of this p e process
	 */
	@AutoEscape
	public String getSupervisorPageName();

	/**
	 * Sets the supervisor page name of this p e process.
	 *
	 * @param supervisorPageName the supervisor page name of this p e process
	 */
	public void setSupervisorPageName(String supervisorPageName);

	/**
	 * Returns the closed reason voc ID of this p e process.
	 *
	 * @return the closed reason voc ID of this p e process
	 */
	public long getClosedReasonVocId();

	/**
	 * Sets the closed reason voc ID of this p e process.
	 *
	 * @param closedReasonVocId the closed reason voc ID of this p e process
	 */
	public void setClosedReasonVocId(long closedReasonVocId);

	/**
	 * Returns the account creation email enabled of this p e process.
	 *
	 * @return the account creation email enabled of this p e process
	 */
	public boolean getAccountCreationEmailEnabled();

	/**
	 * Returns <code>true</code> if this p e process is account creation email enabled.
	 *
	 * @return <code>true</code> if this p e process is account creation email enabled; <code>false</code> otherwise
	 */
	public boolean isAccountCreationEmailEnabled();

	/**
	 * Sets whether this p e process is account creation email enabled.
	 *
	 * @param accountCreationEmailEnabled the account creation email enabled of this p e process
	 */
	public void setAccountCreationEmailEnabled(
		boolean accountCreationEmailEnabled);

	/**
	 * Returns the enable assignment of this p e process.
	 *
	 * @return the enable assignment of this p e process
	 */
	public boolean getEnableAssignment();

	/**
	 * Returns <code>true</code> if this p e process is enable assignment.
	 *
	 * @return <code>true</code> if this p e process is enable assignment; <code>false</code> otherwise
	 */
	public boolean isEnableAssignment();

	/**
	 * Sets whether this p e process is enable assignment.
	 *
	 * @param enableAssignment the enable assignment of this p e process
	 */
	public void setEnableAssignment(boolean enableAssignment);

	/**
	 * Returns the edit fee details of this p e process.
	 *
	 * @return the edit fee details of this p e process
	 */
	public boolean getEditFeeDetails();

	/**
	 * Returns <code>true</code> if this p e process is edit fee details.
	 *
	 * @return <code>true</code> if this p e process is edit fee details; <code>false</code> otherwise
	 */
	public boolean isEditFeeDetails();

	/**
	 * Sets whether this p e process is edit fee details.
	 *
	 * @param editFeeDetails the edit fee details of this p e process
	 */
	public void setEditFeeDetails(boolean editFeeDetails);

	/**
	 * Returns the schedule model ID of this p e process.
	 *
	 * @return the schedule model ID of this p e process
	 */
	public long getScheduleModelId();

	/**
	 * Sets the schedule model ID of this p e process.
	 *
	 * @param scheduleModelId the schedule model ID of this p e process
	 */
	public void setScheduleModelId(long scheduleModelId);

	/**
	 * Returns the enable single submission of this p e process.
	 *
	 * @return the enable single submission of this p e process
	 */
	public boolean getEnableSingleSubmission();

	/**
	 * Returns <code>true</code> if this p e process is enable single submission.
	 *
	 * @return <code>true</code> if this p e process is enable single submission; <code>false</code> otherwise
	 */
	public boolean isEnableSingleSubmission();

	/**
	 * Sets whether this p e process is enable single submission.
	 *
	 * @param enableSingleSubmission the enable single submission of this p e process
	 */
	public void setEnableSingleSubmission(boolean enableSingleSubmission);

	/**
	 * Returns the orientation of this p e process.
	 *
	 * @return the orientation of this p e process
	 */
	@AutoEscape
	public String getOrientation();

	/**
	 * Sets the orientation of this p e process.
	 *
	 * @param orientation the orientation of this p e process
	 */
	public void setOrientation(String orientation);

	/**
	 * Returns the show header of this p e process.
	 *
	 * @return the show header of this p e process
	 */
	public boolean getShowHeader();

	/**
	 * Returns <code>true</code> if this p e process is show header.
	 *
	 * @return <code>true</code> if this p e process is show header; <code>false</code> otherwise
	 */
	public boolean isShowHeader();

	/**
	 * Sets whether this p e process is show header.
	 *
	 * @param showHeader the show header of this p e process
	 */
	public void setShowHeader(boolean showHeader);

	/**
	 * Returns the enable first step progress of this p e process.
	 *
	 * @return the enable first step progress of this p e process
	 */
	public boolean getEnableFirstStepProgress();

	/**
	 * Returns <code>true</code> if this p e process is enable first step progress.
	 *
	 * @return <code>true</code> if this p e process is enable first step progress; <code>false</code> otherwise
	 */
	public boolean isEnableFirstStepProgress();

	/**
	 * Sets whether this p e process is enable first step progress.
	 *
	 * @param enableFirstStepProgress the enable first step progress of this p e process
	 */
	public void setEnableFirstStepProgress(boolean enableFirstStepProgress);

	/**
	 * Returns the sub product type ID of this p e process.
	 *
	 * @return the sub product type ID of this p e process
	 */
	public long getSubProductTypeId();

	/**
	 * Sets the sub product type ID of this p e process.
	 *
	 * @param subProductTypeId the sub product type ID of this p e process
	 */
	public void setSubProductTypeId(long subProductTypeId);

	/**
	 * Returns the product type ID of this p e process.
	 *
	 * @return the product type ID of this p e process
	 */
	public long getProductTypeId();

	/**
	 * Sets the product type ID of this p e process.
	 *
	 * @param productTypeId the product type ID of this p e process
	 */
	public void setProductTypeId(long productTypeId);

	/**
	 * Returns the single submission error msg of this p e process.
	 *
	 * @return the single submission error msg of this p e process
	 */
	@AutoEscape
	public String getSingleSubmissionErrorMsg();

	/**
	 * Sets the single submission error msg of this p e process.
	 *
	 * @param singleSubmissionErrorMsg the single submission error msg of this p e process
	 */
	public void setSingleSubmissionErrorMsg(String singleSubmissionErrorMsg);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcess> toCacheModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcess toEscapedModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcess toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}