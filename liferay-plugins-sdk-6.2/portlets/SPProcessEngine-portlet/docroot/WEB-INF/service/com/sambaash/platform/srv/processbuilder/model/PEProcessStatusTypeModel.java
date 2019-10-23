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
 * The base model interface for the PEProcessStatusType service. Represents a row in the &quot;SPPEProcessStatusType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatusType
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeImpl
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl
 * @generated
 */
public interface PEProcessStatusTypeModel extends BaseModel<PEProcessStatusType>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p e process status type model instance should use the {@link PEProcessStatusType} interface instead.
	 */

	/**
	 * Returns the primary key of this p e process status type.
	 *
	 * @return the primary key of this p e process status type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p e process status type.
	 *
	 * @param primaryKey the primary key of this p e process status type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this p e process status type.
	 *
	 * @return the uuid of this p e process status type
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this p e process status type.
	 *
	 * @param uuid the uuid of this p e process status type
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp p e process status type ID of this p e process status type.
	 *
	 * @return the sp p e process status type ID of this p e process status type
	 */
	public long getSpPEProcessStatusTypeId();

	/**
	 * Sets the sp p e process status type ID of this p e process status type.
	 *
	 * @param spPEProcessStatusTypeId the sp p e process status type ID of this p e process status type
	 */
	public void setSpPEProcessStatusTypeId(long spPEProcessStatusTypeId);

	/**
	 * Returns the group ID of this p e process status type.
	 *
	 * @return the group ID of this p e process status type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this p e process status type.
	 *
	 * @param groupId the group ID of this p e process status type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this p e process status type.
	 *
	 * @return the company ID of this p e process status type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this p e process status type.
	 *
	 * @param companyId the company ID of this p e process status type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this p e process status type.
	 *
	 * @return the user ID of this p e process status type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this p e process status type.
	 *
	 * @param userId the user ID of this p e process status type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this p e process status type.
	 *
	 * @return the user uuid of this p e process status type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p e process status type.
	 *
	 * @param userUuid the user uuid of this p e process status type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this p e process status type.
	 *
	 * @return the user name of this p e process status type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this p e process status type.
	 *
	 * @param userName the user name of this p e process status type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this p e process status type.
	 *
	 * @return the create date of this p e process status type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this p e process status type.
	 *
	 * @param createDate the create date of this p e process status type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this p e process status type.
	 *
	 * @return the modified date of this p e process status type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this p e process status type.
	 *
	 * @param modifiedDate the modified date of this p e process status type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp p e process ID of this p e process status type.
	 *
	 * @return the sp p e process ID of this p e process status type
	 */
	public long getSpPEProcessId();

	/**
	 * Sets the sp p e process ID of this p e process status type.
	 *
	 * @param spPEProcessId the sp p e process ID of this p e process status type
	 */
	public void setSpPEProcessId(long spPEProcessId);

	/**
	 * Returns the status name of this p e process status type.
	 *
	 * @return the status name of this p e process status type
	 */
	@AutoEscape
	public String getStatusName();

	/**
	 * Sets the status name of this p e process status type.
	 *
	 * @param statusName the status name of this p e process status type
	 */
	public void setStatusName(String statusName);

	/**
	 * Returns the seq no of this p e process status type.
	 *
	 * @return the seq no of this p e process status type
	 */
	public long getSeqNo();

	/**
	 * Sets the seq no of this p e process status type.
	 *
	 * @param seqNo the seq no of this p e process status type
	 */
	public void setSeqNo(long seqNo);

	/**
	 * Returns the approve template ID of this p e process status type.
	 *
	 * @return the approve template ID of this p e process status type
	 */
	public long getApproveTemplateId();

	/**
	 * Sets the approve template ID of this p e process status type.
	 *
	 * @param approveTemplateId the approve template ID of this p e process status type
	 */
	public void setApproveTemplateId(long approveTemplateId);

	/**
	 * Returns the reject template ID of this p e process status type.
	 *
	 * @return the reject template ID of this p e process status type
	 */
	public long getRejectTemplateId();

	/**
	 * Sets the reject template ID of this p e process status type.
	 *
	 * @param rejectTemplateId the reject template ID of this p e process status type
	 */
	public void setRejectTemplateId(long rejectTemplateId);

	/**
	 * Returns the sp p e process stage ID of this p e process status type.
	 *
	 * @return the sp p e process stage ID of this p e process status type
	 */
	public long getSpPEProcessStageId();

	/**
	 * Sets the sp p e process stage ID of this p e process status type.
	 *
	 * @param spPEProcessStageId the sp p e process stage ID of this p e process status type
	 */
	public void setSpPEProcessStageId(long spPEProcessStageId);

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
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> toCacheModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType toEscapedModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}