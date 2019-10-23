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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductCourse}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductCourse
 * @generated
 */
public class ProductCourseWrapper implements ProductCourse,
	ModelWrapper<ProductCourse> {
	public ProductCourseWrapper(ProductCourse productCourse) {
		_productCourse = productCourse;
	}

	@Override
	public Class<?> getModelClass() {
		return ProductCourse.class;
	}

	@Override
	public String getModelClassName() {
		return ProductCourse.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProductCourseId", getSpProductCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spProductId", getSpProductId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProductCourseId = (Long)attributes.get("spProductCourseId");

		if (spProductCourseId != null) {
			setSpProductCourseId(spProductCourseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long spProductId = (Long)attributes.get("spProductId");

		if (spProductId != null) {
			setSpProductId(spProductId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this product course.
	*
	* @return the primary key of this product course
	*/
	@Override
	public long getPrimaryKey() {
		return _productCourse.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product course.
	*
	* @param primaryKey the primary key of this product course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_productCourse.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp product course ID of this product course.
	*
	* @return the sp product course ID of this product course
	*/
	@Override
	public long getSpProductCourseId() {
		return _productCourse.getSpProductCourseId();
	}

	/**
	* Sets the sp product course ID of this product course.
	*
	* @param spProductCourseId the sp product course ID of this product course
	*/
	@Override
	public void setSpProductCourseId(long spProductCourseId) {
		_productCourse.setSpProductCourseId(spProductCourseId);
	}

	/**
	* Returns the group ID of this product course.
	*
	* @return the group ID of this product course
	*/
	@Override
	public long getGroupId() {
		return _productCourse.getGroupId();
	}

	/**
	* Sets the group ID of this product course.
	*
	* @param groupId the group ID of this product course
	*/
	@Override
	public void setGroupId(long groupId) {
		_productCourse.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product course.
	*
	* @return the company ID of this product course
	*/
	@Override
	public long getCompanyId() {
		return _productCourse.getCompanyId();
	}

	/**
	* Sets the company ID of this product course.
	*
	* @param companyId the company ID of this product course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_productCourse.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product course.
	*
	* @return the user ID of this product course
	*/
	@Override
	public long getUserId() {
		return _productCourse.getUserId();
	}

	/**
	* Sets the user ID of this product course.
	*
	* @param userId the user ID of this product course
	*/
	@Override
	public void setUserId(long userId) {
		_productCourse.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product course.
	*
	* @return the user uuid of this product course
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCourse.getUserUuid();
	}

	/**
	* Sets the user uuid of this product course.
	*
	* @param userUuid the user uuid of this product course
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_productCourse.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this product course.
	*
	* @return the user name of this product course
	*/
	@Override
	public java.lang.String getUserName() {
		return _productCourse.getUserName();
	}

	/**
	* Sets the user name of this product course.
	*
	* @param userName the user name of this product course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_productCourse.setUserName(userName);
	}

	/**
	* Returns the create date of this product course.
	*
	* @return the create date of this product course
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _productCourse.getCreateDate();
	}

	/**
	* Sets the create date of this product course.
	*
	* @param createDate the create date of this product course
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_productCourse.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product course.
	*
	* @return the modified date of this product course
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _productCourse.getModifiedDate();
	}

	/**
	* Sets the modified date of this product course.
	*
	* @param modifiedDate the modified date of this product course
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productCourse.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp product ID of this product course.
	*
	* @return the sp product ID of this product course
	*/
	@Override
	public long getSpProductId() {
		return _productCourse.getSpProductId();
	}

	/**
	* Sets the sp product ID of this product course.
	*
	* @param spProductId the sp product ID of this product course
	*/
	@Override
	public void setSpProductId(long spProductId) {
		_productCourse.setSpProductId(spProductId);
	}

	/**
	* Returns the sp course ID of this product course.
	*
	* @return the sp course ID of this product course
	*/
	@Override
	public long getSpCourseId() {
		return _productCourse.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this product course.
	*
	* @param spCourseId the sp course ID of this product course
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_productCourse.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _productCourse.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_productCourse.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _productCourse.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_productCourse.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _productCourse.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _productCourse.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productCourse.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productCourse.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_productCourse.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_productCourse.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productCourse.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductCourseWrapper((ProductCourse)_productCourse.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ProductCourse productCourse) {
		return _productCourse.compareTo(productCourse);
	}

	@Override
	public int hashCode() {
		return _productCourse.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ProductCourse> toCacheModel() {
		return _productCourse.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ProductCourse toEscapedModel() {
		return new ProductCourseWrapper(_productCourse.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ProductCourse toUnescapedModel() {
		return new ProductCourseWrapper(_productCourse.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productCourse.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _productCourse.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productCourse.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductCourseWrapper)) {
			return false;
		}

		ProductCourseWrapper productCourseWrapper = (ProductCourseWrapper)obj;

		if (Validator.equals(_productCourse, productCourseWrapper._productCourse)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProductCourse getWrappedProductCourse() {
		return _productCourse;
	}

	@Override
	public ProductCourse getWrappedModel() {
		return _productCourse;
	}

	@Override
	public void resetOriginalValues() {
		_productCourse.resetOriginalValues();
	}

	private ProductCourse _productCourse;
}