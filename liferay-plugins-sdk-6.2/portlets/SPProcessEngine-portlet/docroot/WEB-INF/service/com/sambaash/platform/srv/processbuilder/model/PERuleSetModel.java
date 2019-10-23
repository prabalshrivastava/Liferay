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
 * The base model interface for the PERuleSet service. Represents a row in the &quot;SPPERuleSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PERuleSet
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetImpl
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl
 * @generated
 */
public interface PERuleSetModel extends BaseModel<PERuleSet>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p e rule set model instance should use the {@link PERuleSet} interface instead.
	 */

	/**
	 * Returns the primary key of this p e rule set.
	 *
	 * @return the primary key of this p e rule set
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p e rule set.
	 *
	 * @param primaryKey the primary key of this p e rule set
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this p e rule set.
	 *
	 * @return the uuid of this p e rule set
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this p e rule set.
	 *
	 * @param uuid the uuid of this p e rule set
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp p e rule set ID of this p e rule set.
	 *
	 * @return the sp p e rule set ID of this p e rule set
	 */
	public long getSpPERuleSetId();

	/**
	 * Sets the sp p e rule set ID of this p e rule set.
	 *
	 * @param spPERuleSetId the sp p e rule set ID of this p e rule set
	 */
	public void setSpPERuleSetId(long spPERuleSetId);

	/**
	 * Returns the group ID of this p e rule set.
	 *
	 * @return the group ID of this p e rule set
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this p e rule set.
	 *
	 * @param groupId the group ID of this p e rule set
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this p e rule set.
	 *
	 * @return the company ID of this p e rule set
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this p e rule set.
	 *
	 * @param companyId the company ID of this p e rule set
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this p e rule set.
	 *
	 * @return the user ID of this p e rule set
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this p e rule set.
	 *
	 * @param userId the user ID of this p e rule set
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this p e rule set.
	 *
	 * @return the user uuid of this p e rule set
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p e rule set.
	 *
	 * @param userUuid the user uuid of this p e rule set
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this p e rule set.
	 *
	 * @return the user name of this p e rule set
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this p e rule set.
	 *
	 * @param userName the user name of this p e rule set
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this p e rule set.
	 *
	 * @return the create date of this p e rule set
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this p e rule set.
	 *
	 * @param createDate the create date of this p e rule set
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this p e rule set.
	 *
	 * @return the modified date of this p e rule set
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this p e rule set.
	 *
	 * @param modifiedDate the modified date of this p e rule set
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this p e rule set.
	 *
	 * @return the name of this p e rule set
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this p e rule set.
	 *
	 * @param name the name of this p e rule set
	 */
	public void setName(String name);

	/**
	 * Returns the component type of this p e rule set.
	 *
	 * @return the component type of this p e rule set
	 */
	@AutoEscape
	public String getComponentType();

	/**
	 * Sets the component type of this p e rule set.
	 *
	 * @param componentType the component type of this p e rule set
	 */
	public void setComponentType(String componentType);

	/**
	 * Returns the component ID of this p e rule set.
	 *
	 * @return the component ID of this p e rule set
	 */
	@AutoEscape
	public String getComponentId();

	/**
	 * Sets the component ID of this p e rule set.
	 *
	 * @param componentId the component ID of this p e rule set
	 */
	public void setComponentId(String componentId);

	/**
	 * Returns the status of this p e rule set.
	 *
	 * @return the status of this p e rule set
	 */
	public long getStatus();

	/**
	 * Sets the status of this p e rule set.
	 *
	 * @param status the status of this p e rule set
	 */
	public void setStatus(long status);

	/**
	 * Returns the form version of this p e rule set.
	 *
	 * @return the form version of this p e rule set
	 */
	@AutoEscape
	public String getFormVersion();

	/**
	 * Sets the form version of this p e rule set.
	 *
	 * @param formVersion the form version of this p e rule set
	 */
	public void setFormVersion(String formVersion);

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
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.processbuilder.model.PERuleSet> toCacheModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet toEscapedModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}