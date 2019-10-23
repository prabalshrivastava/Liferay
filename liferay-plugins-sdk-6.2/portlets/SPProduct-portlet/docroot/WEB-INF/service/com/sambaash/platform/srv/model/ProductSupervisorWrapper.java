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
 * This class is a wrapper for {@link ProductSupervisor}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductSupervisor
 * @generated
 */
public class ProductSupervisorWrapper implements ProductSupervisor,
	ModelWrapper<ProductSupervisor> {
	public ProductSupervisorWrapper(ProductSupervisor productSupervisor) {
		_productSupervisor = productSupervisor;
	}

	@Override
	public Class<?> getModelClass() {
		return ProductSupervisor.class;
	}

	@Override
	public String getModelClassName() {
		return ProductSupervisor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProductSupervisorId", getSpProductSupervisorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryName", getCountryName());
		attributes.put("countryId", getCountryId());
		attributes.put("productId", getProductId());
		attributes.put("supervisorId", getSupervisorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProductSupervisorId = (Long)attributes.get(
				"spProductSupervisorId");

		if (spProductSupervisorId != null) {
			setSpProductSupervisorId(spProductSupervisorId);
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

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long supervisorId = (Long)attributes.get("supervisorId");

		if (supervisorId != null) {
			setSupervisorId(supervisorId);
		}
	}

	/**
	* Returns the primary key of this product supervisor.
	*
	* @return the primary key of this product supervisor
	*/
	@Override
	public long getPrimaryKey() {
		return _productSupervisor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product supervisor.
	*
	* @param primaryKey the primary key of this product supervisor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_productSupervisor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp product supervisor ID of this product supervisor.
	*
	* @return the sp product supervisor ID of this product supervisor
	*/
	@Override
	public long getSpProductSupervisorId() {
		return _productSupervisor.getSpProductSupervisorId();
	}

	/**
	* Sets the sp product supervisor ID of this product supervisor.
	*
	* @param spProductSupervisorId the sp product supervisor ID of this product supervisor
	*/
	@Override
	public void setSpProductSupervisorId(long spProductSupervisorId) {
		_productSupervisor.setSpProductSupervisorId(spProductSupervisorId);
	}

	/**
	* Returns the group ID of this product supervisor.
	*
	* @return the group ID of this product supervisor
	*/
	@Override
	public long getGroupId() {
		return _productSupervisor.getGroupId();
	}

	/**
	* Sets the group ID of this product supervisor.
	*
	* @param groupId the group ID of this product supervisor
	*/
	@Override
	public void setGroupId(long groupId) {
		_productSupervisor.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product supervisor.
	*
	* @return the company ID of this product supervisor
	*/
	@Override
	public long getCompanyId() {
		return _productSupervisor.getCompanyId();
	}

	/**
	* Sets the company ID of this product supervisor.
	*
	* @param companyId the company ID of this product supervisor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_productSupervisor.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product supervisor.
	*
	* @return the user ID of this product supervisor
	*/
	@Override
	public long getUserId() {
		return _productSupervisor.getUserId();
	}

	/**
	* Sets the user ID of this product supervisor.
	*
	* @param userId the user ID of this product supervisor
	*/
	@Override
	public void setUserId(long userId) {
		_productSupervisor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product supervisor.
	*
	* @return the user uuid of this product supervisor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisor.getUserUuid();
	}

	/**
	* Sets the user uuid of this product supervisor.
	*
	* @param userUuid the user uuid of this product supervisor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_productSupervisor.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this product supervisor.
	*
	* @return the user name of this product supervisor
	*/
	@Override
	public java.lang.String getUserName() {
		return _productSupervisor.getUserName();
	}

	/**
	* Sets the user name of this product supervisor.
	*
	* @param userName the user name of this product supervisor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_productSupervisor.setUserName(userName);
	}

	/**
	* Returns the create date of this product supervisor.
	*
	* @return the create date of this product supervisor
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _productSupervisor.getCreateDate();
	}

	/**
	* Sets the create date of this product supervisor.
	*
	* @param createDate the create date of this product supervisor
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_productSupervisor.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product supervisor.
	*
	* @return the modified date of this product supervisor
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _productSupervisor.getModifiedDate();
	}

	/**
	* Sets the modified date of this product supervisor.
	*
	* @param modifiedDate the modified date of this product supervisor
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productSupervisor.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country name of this product supervisor.
	*
	* @return the country name of this product supervisor
	*/
	@Override
	public java.lang.String getCountryName() {
		return _productSupervisor.getCountryName();
	}

	/**
	* Sets the country name of this product supervisor.
	*
	* @param countryName the country name of this product supervisor
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_productSupervisor.setCountryName(countryName);
	}

	/**
	* Returns the country ID of this product supervisor.
	*
	* @return the country ID of this product supervisor
	*/
	@Override
	public long getCountryId() {
		return _productSupervisor.getCountryId();
	}

	/**
	* Sets the country ID of this product supervisor.
	*
	* @param countryId the country ID of this product supervisor
	*/
	@Override
	public void setCountryId(long countryId) {
		_productSupervisor.setCountryId(countryId);
	}

	/**
	* Returns the product ID of this product supervisor.
	*
	* @return the product ID of this product supervisor
	*/
	@Override
	public long getProductId() {
		return _productSupervisor.getProductId();
	}

	/**
	* Sets the product ID of this product supervisor.
	*
	* @param productId the product ID of this product supervisor
	*/
	@Override
	public void setProductId(long productId) {
		_productSupervisor.setProductId(productId);
	}

	/**
	* Returns the supervisor ID of this product supervisor.
	*
	* @return the supervisor ID of this product supervisor
	*/
	@Override
	public long getSupervisorId() {
		return _productSupervisor.getSupervisorId();
	}

	/**
	* Sets the supervisor ID of this product supervisor.
	*
	* @param supervisorId the supervisor ID of this product supervisor
	*/
	@Override
	public void setSupervisorId(long supervisorId) {
		_productSupervisor.setSupervisorId(supervisorId);
	}

	@Override
	public boolean isNew() {
		return _productSupervisor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_productSupervisor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _productSupervisor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_productSupervisor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _productSupervisor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _productSupervisor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productSupervisor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productSupervisor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_productSupervisor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_productSupervisor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productSupervisor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductSupervisorWrapper((ProductSupervisor)_productSupervisor.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor) {
		return _productSupervisor.compareTo(productSupervisor);
	}

	@Override
	public int hashCode() {
		return _productSupervisor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ProductSupervisor> toCacheModel() {
		return _productSupervisor.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor toEscapedModel() {
		return new ProductSupervisorWrapper(_productSupervisor.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor toUnescapedModel() {
		return new ProductSupervisorWrapper(_productSupervisor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productSupervisor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _productSupervisor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productSupervisor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductSupervisorWrapper)) {
			return false;
		}

		ProductSupervisorWrapper productSupervisorWrapper = (ProductSupervisorWrapper)obj;

		if (Validator.equals(_productSupervisor,
					productSupervisorWrapper._productSupervisor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProductSupervisor getWrappedProductSupervisor() {
		return _productSupervisor;
	}

	@Override
	public ProductSupervisor getWrappedModel() {
		return _productSupervisor;
	}

	@Override
	public void resetOriginalValues() {
		_productSupervisor.resetOriginalValues();
	}

	private ProductSupervisor _productSupervisor;
}