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

package com.sambaash.platform.srv.spservices.model;

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
 * The base model interface for the SPParameter service. Represents a row in the &quot;SPParameter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spservices.model.impl.SPParameterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spservices.model.impl.SPParameterImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPParameter
 * @see com.sambaash.platform.srv.spservices.model.impl.SPParameterImpl
 * @see com.sambaash.platform.srv.spservices.model.impl.SPParameterModelImpl
 * @generated
 */
public interface SPParameterModel extends BaseModel<SPParameter>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p parameter model instance should use the {@link SPParameter} interface instead.
	 */

	/**
	 * Returns the primary key of this s p parameter.
	 *
	 * @return the primary key of this s p parameter
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p parameter.
	 *
	 * @param primaryKey the primary key of this s p parameter
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this s p parameter.
	 *
	 * @return the uuid of this s p parameter
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this s p parameter.
	 *
	 * @param uuid the uuid of this s p parameter
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp parameter ID of this s p parameter.
	 *
	 * @return the sp parameter ID of this s p parameter
	 */
	public long getSpParameterId();

	/**
	 * Sets the sp parameter ID of this s p parameter.
	 *
	 * @param spParameterId the sp parameter ID of this s p parameter
	 */
	public void setSpParameterId(long spParameterId);

	/**
	 * Returns the group ID of this s p parameter.
	 *
	 * @return the group ID of this s p parameter
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this s p parameter.
	 *
	 * @param groupId the group ID of this s p parameter
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this s p parameter.
	 *
	 * @return the company ID of this s p parameter
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p parameter.
	 *
	 * @param companyId the company ID of this s p parameter
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p parameter.
	 *
	 * @return the user ID of this s p parameter
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this s p parameter.
	 *
	 * @param userId the user ID of this s p parameter
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p parameter.
	 *
	 * @return the user uuid of this s p parameter
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p parameter.
	 *
	 * @param userUuid the user uuid of this s p parameter
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this s p parameter.
	 *
	 * @return the user name of this s p parameter
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this s p parameter.
	 *
	 * @param userName the user name of this s p parameter
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this s p parameter.
	 *
	 * @return the create date of this s p parameter
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p parameter.
	 *
	 * @param createDate the create date of this s p parameter
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p parameter.
	 *
	 * @return the modified date of this s p parameter
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p parameter.
	 *
	 * @param modifiedDate the modified date of this s p parameter
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the category of this s p parameter.
	 *
	 * @return the category of this s p parameter
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this s p parameter.
	 *
	 * @param category the category of this s p parameter
	 */
	public void setCategory(String category);

	/**
	 * Returns the description of this s p parameter.
	 *
	 * @return the description of this s p parameter
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this s p parameter.
	 *
	 * @param description the description of this s p parameter
	 */
	public void setDescription(String description);

	/**
	 * Returns the name of this s p parameter.
	 *
	 * @return the name of this s p parameter
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this s p parameter.
	 *
	 * @param name the name of this s p parameter
	 */
	public void setName(String name);

	/**
	 * Returns the value of this s p parameter.
	 *
	 * @return the value of this s p parameter
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this s p parameter.
	 *
	 * @param value the value of this s p parameter
	 */
	public void setValue(String value);

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
		com.sambaash.platform.srv.spservices.model.SPParameter spParameter);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spservices.model.SPParameter> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.SPParameter toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.SPParameter toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}