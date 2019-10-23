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
 * The base model interface for the SPSellingPrice service. Represents a row in the &quot;SPSellingPrice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl}.
 * </p>
 *
 * @author pradeep
 * @see SPSellingPrice
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl
 * @generated
 */
public interface SPSellingPriceModel extends BaseModel<SPSellingPrice>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p selling price model instance should use the {@link SPSellingPrice} interface instead.
	 */

	/**
	 * Returns the primary key of this s p selling price.
	 *
	 * @return the primary key of this s p selling price
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p selling price.
	 *
	 * @param primaryKey the primary key of this s p selling price
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp selling price ID of this s p selling price.
	 *
	 * @return the sp selling price ID of this s p selling price
	 */
	public long getSpSellingPriceId();

	/**
	 * Sets the sp selling price ID of this s p selling price.
	 *
	 * @param spSellingPriceId the sp selling price ID of this s p selling price
	 */
	public void setSpSellingPriceId(long spSellingPriceId);

	/**
	 * Returns the group ID of this s p selling price.
	 *
	 * @return the group ID of this s p selling price
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this s p selling price.
	 *
	 * @param groupId the group ID of this s p selling price
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the price ref ID of this s p selling price.
	 *
	 * @return the price ref ID of this s p selling price
	 */
	public long getPriceRefId();

	/**
	 * Sets the price ref ID of this s p selling price.
	 *
	 * @param priceRefId the price ref ID of this s p selling price
	 */
	public void setPriceRefId(long priceRefId);

	/**
	 * Returns the price ref type ID of this s p selling price.
	 *
	 * @return the price ref type ID of this s p selling price
	 */
	public long getPriceRefTypeId();

	/**
	 * Sets the price ref type ID of this s p selling price.
	 *
	 * @param priceRefTypeId the price ref type ID of this s p selling price
	 */
	public void setPriceRefTypeId(long priceRefTypeId);

	/**
	 * Returns the currency code of this s p selling price.
	 *
	 * @return the currency code of this s p selling price
	 */
	@AutoEscape
	public String getCurrencyCode();

	/**
	 * Sets the currency code of this s p selling price.
	 *
	 * @param currencyCode the currency code of this s p selling price
	 */
	public void setCurrencyCode(String currencyCode);

	/**
	 * Returns the base price of this s p selling price.
	 *
	 * @return the base price of this s p selling price
	 */
	@AutoEscape
	public String getBasePrice();

	/**
	 * Sets the base price of this s p selling price.
	 *
	 * @param basePrice the base price of this s p selling price
	 */
	public void setBasePrice(String basePrice);

	/**
	 * Returns the tax name of this s p selling price.
	 *
	 * @return the tax name of this s p selling price
	 */
	@AutoEscape
	public String getTaxName();

	/**
	 * Sets the tax name of this s p selling price.
	 *
	 * @param taxName the tax name of this s p selling price
	 */
	public void setTaxName(String taxName);

	/**
	 * Returns the tax value of this s p selling price.
	 *
	 * @return the tax value of this s p selling price
	 */
	@AutoEscape
	public String getTaxValue();

	/**
	 * Sets the tax value of this s p selling price.
	 *
	 * @param taxValue the tax value of this s p selling price
	 */
	public void setTaxValue(String taxValue);

	/**
	 * Returns the total price of this s p selling price.
	 *
	 * @return the total price of this s p selling price
	 */
	@AutoEscape
	public String getTotalPrice();

	/**
	 * Sets the total price of this s p selling price.
	 *
	 * @param totalPrice the total price of this s p selling price
	 */
	public void setTotalPrice(String totalPrice);

	/**
	 * Returns the company ID of this s p selling price.
	 *
	 * @return the company ID of this s p selling price
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p selling price.
	 *
	 * @param companyId the company ID of this s p selling price
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p selling price.
	 *
	 * @return the user ID of this s p selling price
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this s p selling price.
	 *
	 * @param userId the user ID of this s p selling price
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p selling price.
	 *
	 * @return the user uuid of this s p selling price
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p selling price.
	 *
	 * @param userUuid the user uuid of this s p selling price
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this s p selling price.
	 *
	 * @return the user name of this s p selling price
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this s p selling price.
	 *
	 * @param userName the user name of this s p selling price
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this s p selling price.
	 *
	 * @return the create date of this s p selling price
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p selling price.
	 *
	 * @param createDate the create date of this s p selling price
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p selling price.
	 *
	 * @return the modified date of this s p selling price
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p selling price.
	 *
	 * @param modifiedDate the modified date of this s p selling price
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
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}