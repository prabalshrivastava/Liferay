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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FeeType service. Represents a row in the &quot;SPFeeType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.FeeTypeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeType
 * @see com.sambaash.platform.srv.model.impl.FeeTypeImpl
 * @see com.sambaash.platform.srv.model.impl.FeeTypeModelImpl
 * @generated
 */
public interface FeeTypeModel extends BaseModel<FeeType>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fee type model instance should use the {@link FeeType} interface instead.
	 */

	/**
	 * Returns the primary key of this fee type.
	 *
	 * @return the primary key of this fee type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fee type.
	 *
	 * @param primaryKey the primary key of this fee type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp fee type ID of this fee type.
	 *
	 * @return the sp fee type ID of this fee type
	 */
	public long getSpFeeTypeId();

	/**
	 * Sets the sp fee type ID of this fee type.
	 *
	 * @param spFeeTypeId the sp fee type ID of this fee type
	 */
	public void setSpFeeTypeId(long spFeeTypeId);

	/**
	 * Returns the group ID of this fee type.
	 *
	 * @return the group ID of this fee type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this fee type.
	 *
	 * @param groupId the group ID of this fee type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this fee type.
	 *
	 * @return the company ID of this fee type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this fee type.
	 *
	 * @param companyId the company ID of this fee type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this fee type.
	 *
	 * @return the user ID of this fee type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this fee type.
	 *
	 * @param userId the user ID of this fee type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fee type.
	 *
	 * @return the user uuid of this fee type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fee type.
	 *
	 * @param userUuid the user uuid of this fee type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fee type.
	 *
	 * @return the user name of this fee type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this fee type.
	 *
	 * @param userName the user name of this fee type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fee type.
	 *
	 * @return the create date of this fee type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this fee type.
	 *
	 * @param createDate the create date of this fee type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this fee type.
	 *
	 * @return the modified date of this fee type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this fee type.
	 *
	 * @param modifiedDate the modified date of this fee type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fee type of this fee type.
	 *
	 * @return the fee type of this fee type
	 */
	@AutoEscape
	public String getFeeType();

	/**
	 * Sets the fee type of this fee type.
	 *
	 * @param feeType the fee type of this fee type
	 */
	public void setFeeType(String feeType);

	/**
	 * Returns the fee type name of this fee type.
	 *
	 * @return the fee type name of this fee type
	 */
	@AutoEscape
	public String getFeeTypeName();

	/**
	 * Sets the fee type name of this fee type.
	 *
	 * @param feeTypeName the fee type name of this fee type
	 */
	public void setFeeTypeName(String feeTypeName);

	/**
	 * Returns the fee type desc of this fee type.
	 *
	 * @return the fee type desc of this fee type
	 */
	@AutoEscape
	public String getFeeTypeDesc();

	/**
	 * Sets the fee type desc of this fee type.
	 *
	 * @param feeTypeDesc the fee type desc of this fee type
	 */
	public void setFeeTypeDesc(String feeTypeDesc);

	/**
	 * Returns the misc of this fee type.
	 *
	 * @return the misc of this fee type
	 */
	public boolean getMisc();

	/**
	 * Returns <code>true</code> if this fee type is misc.
	 *
	 * @return <code>true</code> if this fee type is misc; <code>false</code> otherwise
	 */
	public boolean isMisc();

	/**
	 * Sets whether this fee type is misc.
	 *
	 * @param misc the misc of this fee type
	 */
	public void setMisc(boolean misc);

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
	public int compareTo(com.sambaash.platform.srv.model.FeeType feeType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.FeeType> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.FeeType toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.FeeType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}