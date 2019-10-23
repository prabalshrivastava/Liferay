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

package com.sambaash.platform.srv.spshopping.model;

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
 * The base model interface for the SPTax service. Represents a row in the &quot;SPTax&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spshopping.model.impl.SPTaxImpl}.
 * </p>
 *
 * @author pradeep
 * @see SPTax
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPTaxImpl
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl
 * @generated
 */
public interface SPTaxModel extends BaseModel<SPTax>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p tax model instance should use the {@link SPTax} interface instead.
	 */

	/**
	 * Returns the primary key of this s p tax.
	 *
	 * @return the primary key of this s p tax
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p tax.
	 *
	 * @param primaryKey the primary key of this s p tax
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp tax ID of this s p tax.
	 *
	 * @return the sp tax ID of this s p tax
	 */
	public long getSpTaxId();

	/**
	 * Sets the sp tax ID of this s p tax.
	 *
	 * @param spTaxId the sp tax ID of this s p tax
	 */
	public void setSpTaxId(long spTaxId);

	/**
	 * Returns the group ID of this s p tax.
	 *
	 * @return the group ID of this s p tax
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this s p tax.
	 *
	 * @param groupId the group ID of this s p tax
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the currency code of this s p tax.
	 *
	 * @return the currency code of this s p tax
	 */
	@AutoEscape
	public String getCurrencyCode();

	/**
	 * Sets the currency code of this s p tax.
	 *
	 * @param currencyCode the currency code of this s p tax
	 */
	public void setCurrencyCode(String currencyCode);

	/**
	 * Returns the tax name of this s p tax.
	 *
	 * @return the tax name of this s p tax
	 */
	@AutoEscape
	public String getTaxName();

	/**
	 * Sets the tax name of this s p tax.
	 *
	 * @param taxName the tax name of this s p tax
	 */
	public void setTaxName(String taxName);

	/**
	 * Returns the tax value of this s p tax.
	 *
	 * @return the tax value of this s p tax
	 */
	public long getTaxValue();

	/**
	 * Sets the tax value of this s p tax.
	 *
	 * @param taxValue the tax value of this s p tax
	 */
	public void setTaxValue(long taxValue);

	/**
	 * Returns the company ID of this s p tax.
	 *
	 * @return the company ID of this s p tax
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p tax.
	 *
	 * @param companyId the company ID of this s p tax
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p tax.
	 *
	 * @return the user ID of this s p tax
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this s p tax.
	 *
	 * @param userId the user ID of this s p tax
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p tax.
	 *
	 * @return the user uuid of this s p tax
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p tax.
	 *
	 * @param userUuid the user uuid of this s p tax
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this s p tax.
	 *
	 * @return the user name of this s p tax
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this s p tax.
	 *
	 * @param userName the user name of this s p tax
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this s p tax.
	 *
	 * @return the create date of this s p tax
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p tax.
	 *
	 * @param createDate the create date of this s p tax
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p tax.
	 *
	 * @return the modified date of this s p tax
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p tax.
	 *
	 * @param modifiedDate the modified date of this s p tax
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

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
	public int compareTo(com.sambaash.platform.srv.spshopping.model.SPTax spTax);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spshopping.model.SPTax> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPTax toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPTax toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}