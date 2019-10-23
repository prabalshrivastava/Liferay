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
 * The base model interface for the PEProcessState service. Represents a row in the &quot;SPPEProcessState&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessState
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateImpl
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl
 * @generated
 */
public interface PEProcessStateModel extends BaseModel<PEProcessState>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p e process state model instance should use the {@link PEProcessState} interface instead.
	 */

	/**
	 * Returns the primary key of this p e process state.
	 *
	 * @return the primary key of this p e process state
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p e process state.
	 *
	 * @param primaryKey the primary key of this p e process state
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this p e process state.
	 *
	 * @return the uuid of this p e process state
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this p e process state.
	 *
	 * @param uuid the uuid of this p e process state
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp p e process state ID of this p e process state.
	 *
	 * @return the sp p e process state ID of this p e process state
	 */
	public long getSpPEProcessStateId();

	/**
	 * Sets the sp p e process state ID of this p e process state.
	 *
	 * @param spPEProcessStateId the sp p e process state ID of this p e process state
	 */
	public void setSpPEProcessStateId(long spPEProcessStateId);

	/**
	 * Returns the group ID of this p e process state.
	 *
	 * @return the group ID of this p e process state
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this p e process state.
	 *
	 * @param groupId the group ID of this p e process state
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this p e process state.
	 *
	 * @return the company ID of this p e process state
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this p e process state.
	 *
	 * @param companyId the company ID of this p e process state
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this p e process state.
	 *
	 * @return the user ID of this p e process state
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this p e process state.
	 *
	 * @param userId the user ID of this p e process state
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this p e process state.
	 *
	 * @return the user uuid of this p e process state
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p e process state.
	 *
	 * @param userUuid the user uuid of this p e process state
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this p e process state.
	 *
	 * @return the user name of this p e process state
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this p e process state.
	 *
	 * @param userName the user name of this p e process state
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this p e process state.
	 *
	 * @return the create date of this p e process state
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this p e process state.
	 *
	 * @param createDate the create date of this p e process state
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this p e process state.
	 *
	 * @return the modified date of this p e process state
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this p e process state.
	 *
	 * @param modifiedDate the modified date of this p e process state
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp p e process ID of this p e process state.
	 *
	 * @return the sp p e process ID of this p e process state
	 */
	public long getSpPEProcessId();

	/**
	 * Sets the sp p e process ID of this p e process state.
	 *
	 * @param spPEProcessId the sp p e process ID of this p e process state
	 */
	public void setSpPEProcessId(long spPEProcessId);

	/**
	 * Returns the entity class ID of this p e process state.
	 *
	 * @return the entity class ID of this p e process state
	 */
	public long getEntityClassId();

	/**
	 * Sets the entity class ID of this p e process state.
	 *
	 * @param entityClassId the entity class ID of this p e process state
	 */
	public void setEntityClassId(long entityClassId);

	/**
	 * Returns the entity ID of this p e process state.
	 *
	 * @return the entity ID of this p e process state
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this p e process state.
	 *
	 * @param entityId the entity ID of this p e process state
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the user ID process of this p e process state.
	 *
	 * @return the user ID process of this p e process state
	 */
	public long getUserIdProcess();

	/**
	 * Sets the user ID process of this p e process state.
	 *
	 * @param userIdProcess the user ID process of this p e process state
	 */
	public void setUserIdProcess(long userIdProcess);

	/**
	 * Returns the user ID creator of this p e process state.
	 *
	 * @return the user ID creator of this p e process state
	 */
	public long getUserIdCreator();

	/**
	 * Sets the user ID creator of this p e process state.
	 *
	 * @param userIdCreator the user ID creator of this p e process state
	 */
	public void setUserIdCreator(long userIdCreator);

	/**
	 * Returns the status type ID of this p e process state.
	 *
	 * @return the status type ID of this p e process state
	 */
	public long getStatusTypeId();

	/**
	 * Sets the status type ID of this p e process state.
	 *
	 * @param statusTypeId the status type ID of this p e process state
	 */
	public void setStatusTypeId(long statusTypeId);

	/**
	 * Returns the sp p e process stage ID of this p e process state.
	 *
	 * @return the sp p e process stage ID of this p e process state
	 */
	public long getSpPEProcessStageId();

	/**
	 * Sets the sp p e process stage ID of this p e process state.
	 *
	 * @param spPEProcessStageId the sp p e process stage ID of this p e process state
	 */
	public void setSpPEProcessStageId(long spPEProcessStageId);

	/**
	 * Returns the status of this p e process state.
	 *
	 * @return the status of this p e process state
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this p e process state.
	 *
	 * @param status the status of this p e process state
	 */
	public void setStatus(String status);

	/**
	 * Returns the node ID of this p e process state.
	 *
	 * @return the node ID of this p e process state
	 */
	public long getNodeId();

	/**
	 * Sets the node ID of this p e process state.
	 *
	 * @param nodeId the node ID of this p e process state
	 */
	public void setNodeId(long nodeId);

	/**
	 * Returns the node ID last processed of this p e process state.
	 *
	 * @return the node ID last processed of this p e process state
	 */
	public long getNodeIdLastProcessed();

	/**
	 * Sets the node ID last processed of this p e process state.
	 *
	 * @param nodeIdLastProcessed the node ID last processed of this p e process state
	 */
	public void setNodeIdLastProcessed(long nodeIdLastProcessed);

	/**
	 * Returns the node ID last displayed of this p e process state.
	 *
	 * @return the node ID last displayed of this p e process state
	 */
	public long getNodeIdLastDisplayed();

	/**
	 * Sets the node ID last displayed of this p e process state.
	 *
	 * @param nodeIdLastDisplayed the node ID last displayed of this p e process state
	 */
	public void setNodeIdLastDisplayed(long nodeIdLastDisplayed);

	/**
	 * Returns the node ID last data submitted of this p e process state.
	 *
	 * @return the node ID last data submitted of this p e process state
	 */
	public long getNodeIdLastDataSubmitted();

	/**
	 * Sets the node ID last data submitted of this p e process state.
	 *
	 * @param nodeIdLastDataSubmitted the node ID last data submitted of this p e process state
	 */
	public void setNodeIdLastDataSubmitted(long nodeIdLastDataSubmitted);

	/**
	 * Returns the data of this p e process state.
	 *
	 * @return the data of this p e process state
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this p e process state.
	 *
	 * @param data the data of this p e process state
	 */
	public void setData(String data);

	/**
	 * Returns the last error code of this p e process state.
	 *
	 * @return the last error code of this p e process state
	 */
	public long getLastErrorCode();

	/**
	 * Sets the last error code of this p e process state.
	 *
	 * @param lastErrorCode the last error code of this p e process state
	 */
	public void setLastErrorCode(long lastErrorCode);

	/**
	 * Returns the last error msg of this p e process state.
	 *
	 * @return the last error msg of this p e process state
	 */
	@AutoEscape
	public String getLastErrorMsg();

	/**
	 * Sets the last error msg of this p e process state.
	 *
	 * @param lastErrorMsg the last error msg of this p e process state
	 */
	public void setLastErrorMsg(String lastErrorMsg);

	/**
	 * Returns the last error date of this p e process state.
	 *
	 * @return the last error date of this p e process state
	 */
	public Date getLastErrorDate();

	/**
	 * Sets the last error date of this p e process state.
	 *
	 * @param lastErrorDate the last error date of this p e process state
	 */
	public void setLastErrorDate(Date lastErrorDate);

	/**
	 * Returns the current status type approvers of this p e process state.
	 *
	 * @return the current status type approvers of this p e process state
	 */
	@AutoEscape
	public String getCurrentStatusTypeApprovers();

	/**
	 * Sets the current status type approvers of this p e process state.
	 *
	 * @param currentStatusTypeApprovers the current status type approvers of this p e process state
	 */
	public void setCurrentStatusTypeApprovers(String currentStatusTypeApprovers);

	/**
	 * Returns the current node submitters of this p e process state.
	 *
	 * @return the current node submitters of this p e process state
	 */
	@AutoEscape
	public String getCurrentNodeSubmitters();

	/**
	 * Sets the current node submitters of this p e process state.
	 *
	 * @param currentNodeSubmitters the current node submitters of this p e process state
	 */
	public void setCurrentNodeSubmitters(String currentNodeSubmitters);

	/**
	 * Returns the lock of this p e process state.
	 *
	 * @return the lock of this p e process state
	 */
	public int getLock();

	/**
	 * Sets the lock of this p e process state.
	 *
	 * @param lock the lock of this p e process state
	 */
	public void setLock(int lock);

	/**
	 * Returns the lock date of this p e process state.
	 *
	 * @return the lock date of this p e process state
	 */
	public Date getLockDate();

	/**
	 * Sets the lock date of this p e process state.
	 *
	 * @param lockDate the lock date of this p e process state
	 */
	public void setLockDate(Date lockDate);

	/**
	 * Returns the user ID supervisor of this p e process state.
	 *
	 * @return the user ID supervisor of this p e process state
	 */
	public long getUserIdSupervisor();

	/**
	 * Sets the user ID supervisor of this p e process state.
	 *
	 * @param userIdSupervisor the user ID supervisor of this p e process state
	 */
	public void setUserIdSupervisor(long userIdSupervisor);

	/**
	 * Returns the user ID agent of this p e process state.
	 *
	 * @return the user ID agent of this p e process state
	 */
	public long getUserIdAgent();

	/**
	 * Sets the user ID agent of this p e process state.
	 *
	 * @param userIdAgent the user ID agent of this p e process state
	 */
	public void setUserIdAgent(long userIdAgent);

	/**
	 * Returns the closed stage ID of this p e process state.
	 *
	 * @return the closed stage ID of this p e process state
	 */
	public long getClosedStageId();

	/**
	 * Sets the closed stage ID of this p e process state.
	 *
	 * @param closedStageId the closed stage ID of this p e process state
	 */
	public void setClosedStageId(long closedStageId);

	/**
	 * Returns the closed date of this p e process state.
	 *
	 * @return the closed date of this p e process state
	 */
	public Date getClosedDate();

	/**
	 * Sets the closed date of this p e process state.
	 *
	 * @param closedDate the closed date of this p e process state
	 */
	public void setClosedDate(Date closedDate);

	/**
	 * Returns the closed reason cat ID of this p e process state.
	 *
	 * @return the closed reason cat ID of this p e process state
	 */
	public long getClosedReasonCatId();

	/**
	 * Sets the closed reason cat ID of this p e process state.
	 *
	 * @param closedReasonCatId the closed reason cat ID of this p e process state
	 */
	public void setClosedReasonCatId(long closedReasonCatId);

	/**
	 * Returns the closed description of this p e process state.
	 *
	 * @return the closed description of this p e process state
	 */
	@AutoEscape
	public String getClosedDescription();

	/**
	 * Sets the closed description of this p e process state.
	 *
	 * @param closedDescription the closed description of this p e process state
	 */
	public void setClosedDescription(String closedDescription);

	/**
	 * Returns the converted from process state ID of this p e process state.
	 *
	 * @return the converted from process state ID of this p e process state
	 */
	public long getConvertedFromProcessStateId();

	/**
	 * Sets the converted from process state ID of this p e process state.
	 *
	 * @param convertedFromProcessStateId the converted from process state ID of this p e process state
	 */
	public void setConvertedFromProcessStateId(long convertedFromProcessStateId);

	/**
	 * Returns the converted to process state ID of this p e process state.
	 *
	 * @return the converted to process state ID of this p e process state
	 */
	public long getConvertedToProcessStateId();

	/**
	 * Sets the converted to process state ID of this p e process state.
	 *
	 * @param convertedToProcessStateId the converted to process state ID of this p e process state
	 */
	public void setConvertedToProcessStateId(long convertedToProcessStateId);

	/**
	 * Returns the active status of this p e process state.
	 *
	 * @return the active status of this p e process state
	 */
	public int getActiveStatus();

	/**
	 * Sets the active status of this p e process state.
	 *
	 * @param activeStatus the active status of this p e process state
	 */
	public void setActiveStatus(int activeStatus);

	/**
	 * Returns the amount of this p e process state.
	 *
	 * @return the amount of this p e process state
	 */
	@AutoEscape
	public String getAmount();

	/**
	 * Sets the amount of this p e process state.
	 *
	 * @param amount the amount of this p e process state
	 */
	public void setAmount(String amount);

	/**
	 * Returns the source class ID of this p e process state.
	 *
	 * @return the source class ID of this p e process state
	 */
	public long getSourceClassId();

	/**
	 * Sets the source class ID of this p e process state.
	 *
	 * @param sourceClassId the source class ID of this p e process state
	 */
	public void setSourceClassId(long sourceClassId);

	/**
	 * Returns the source entity i d of this p e process state.
	 *
	 * @return the source entity i d of this p e process state
	 */
	public long getSourceEntityID();

	/**
	 * Sets the source entity i d of this p e process state.
	 *
	 * @param sourceEntityID the source entity i d of this p e process state
	 */
	public void setSourceEntityID(long sourceEntityID);

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
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcessState> toCacheModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState toEscapedModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}