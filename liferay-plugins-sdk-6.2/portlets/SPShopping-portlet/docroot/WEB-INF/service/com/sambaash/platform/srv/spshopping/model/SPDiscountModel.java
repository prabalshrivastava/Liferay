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
 * The base model interface for the SPDiscount service. Represents a row in the &quot;SPDiscount&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountImpl}.
 * </p>
 *
 * @author pradeep
 * @see SPDiscount
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPDiscountImpl
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl
 * @generated
 */
public interface SPDiscountModel extends BaseModel<SPDiscount>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p discount model instance should use the {@link SPDiscount} interface instead.
	 */

	/**
	 * Returns the primary key of this s p discount.
	 *
	 * @return the primary key of this s p discount
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p discount.
	 *
	 * @param primaryKey the primary key of this s p discount
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp discount ID of this s p discount.
	 *
	 * @return the sp discount ID of this s p discount
	 */
	public long getSpDiscountId();

	/**
	 * Sets the sp discount ID of this s p discount.
	 *
	 * @param spDiscountId the sp discount ID of this s p discount
	 */
	public void setSpDiscountId(long spDiscountId);

	/**
	 * Returns the group ID of this s p discount.
	 *
	 * @return the group ID of this s p discount
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this s p discount.
	 *
	 * @param groupId the group ID of this s p discount
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the title of this s p discount.
	 *
	 * @return the title of this s p discount
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this s p discount.
	 *
	 * @param title the title of this s p discount
	 */
	public void setTitle(String title);

	/**
	 * Returns the percent of this s p discount.
	 *
	 * @return the percent of this s p discount
	 */
	public boolean getPercent();

	/**
	 * Returns <code>true</code> if this s p discount is percent.
	 *
	 * @return <code>true</code> if this s p discount is percent; <code>false</code> otherwise
	 */
	public boolean isPercent();

	/**
	 * Sets whether this s p discount is percent.
	 *
	 * @param percent the percent of this s p discount
	 */
	public void setPercent(boolean percent);

	/**
	 * Returns the package ID of this s p discount.
	 *
	 * @return the package ID of this s p discount
	 */
	public long getPackageId();

	/**
	 * Sets the package ID of this s p discount.
	 *
	 * @param packageId the package ID of this s p discount
	 */
	public void setPackageId(long packageId);

	/**
	 * Returns the value of this s p discount.
	 *
	 * @return the value of this s p discount
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this s p discount.
	 *
	 * @param value the value of this s p discount
	 */
	public void setValue(String value);

	/**
	 * Returns the coupon code of this s p discount.
	 *
	 * @return the coupon code of this s p discount
	 */
	@AutoEscape
	public String getCouponCode();

	/**
	 * Sets the coupon code of this s p discount.
	 *
	 * @param couponCode the coupon code of this s p discount
	 */
	public void setCouponCode(String couponCode);

	/**
	 * Returns the description of this s p discount.
	 *
	 * @return the description of this s p discount
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this s p discount.
	 *
	 * @param description the description of this s p discount
	 */
	public void setDescription(String description);

	/**
	 * Returns the start date of this s p discount.
	 *
	 * @return the start date of this s p discount
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this s p discount.
	 *
	 * @param startDate the start date of this s p discount
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this s p discount.
	 *
	 * @return the end date of this s p discount
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this s p discount.
	 *
	 * @param endDate the end date of this s p discount
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the min quantity of this s p discount.
	 *
	 * @return the min quantity of this s p discount
	 */
	public int getMinQuantity();

	/**
	 * Sets the min quantity of this s p discount.
	 *
	 * @param minQuantity the min quantity of this s p discount
	 */
	public void setMinQuantity(int minQuantity);

	/**
	 * Returns the max quantity of this s p discount.
	 *
	 * @return the max quantity of this s p discount
	 */
	public int getMaxQuantity();

	/**
	 * Sets the max quantity of this s p discount.
	 *
	 * @param maxQuantity the max quantity of this s p discount
	 */
	public void setMaxQuantity(int maxQuantity);

	/**
	 * Returns the active of this s p discount.
	 *
	 * @return the active of this s p discount
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this s p discount is active.
	 *
	 * @return <code>true</code> if this s p discount is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this s p discount is active.
	 *
	 * @param active the active of this s p discount
	 */
	public void setActive(boolean active);

	/**
	 * Returns the company ID of this s p discount.
	 *
	 * @return the company ID of this s p discount
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p discount.
	 *
	 * @param companyId the company ID of this s p discount
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p discount.
	 *
	 * @return the user ID of this s p discount
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this s p discount.
	 *
	 * @param userId the user ID of this s p discount
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p discount.
	 *
	 * @return the user uuid of this s p discount
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p discount.
	 *
	 * @param userUuid the user uuid of this s p discount
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this s p discount.
	 *
	 * @return the user name of this s p discount
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this s p discount.
	 *
	 * @param userName the user name of this s p discount
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this s p discount.
	 *
	 * @return the create date of this s p discount
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p discount.
	 *
	 * @param createDate the create date of this s p discount
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p discount.
	 *
	 * @return the modified date of this s p discount
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p discount.
	 *
	 * @param modifiedDate the modified date of this s p discount
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
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spshopping.model.SPDiscount> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}