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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPSiteSetup}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPSiteSetup
 * @generated
 */
public class SPSiteSetupWrapper implements SPSiteSetup,
	ModelWrapper<SPSiteSetup> {
	public SPSiteSetupWrapper(SPSiteSetup spSiteSetup) {
		_spSiteSetup = spSiteSetup;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSiteSetup.class;
	}

	@Override
	public String getModelClassName() {
		return SPSiteSetup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSiteSetupId", getSpSiteSetupId());
		attributes.put("groupId", getGroupId());
		attributes.put("productId", getProductId());
		attributes.put("productName", getProductName());
		attributes.put("subProductId", getSubProductId());
		attributes.put("subProductName", getSubProductName());
		attributes.put("virtualHostId", getVirtualHostId());
		attributes.put("backOfficeVirtualHostId", getBackOfficeVirtualHostId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSiteSetupId = (Long)attributes.get("spSiteSetupId");

		if (spSiteSetupId != null) {
			setSpSiteSetupId(spSiteSetupId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		Long subProductId = (Long)attributes.get("subProductId");

		if (subProductId != null) {
			setSubProductId(subProductId);
		}

		String subProductName = (String)attributes.get("subProductName");

		if (subProductName != null) {
			setSubProductName(subProductName);
		}

		Long virtualHostId = (Long)attributes.get("virtualHostId");

		if (virtualHostId != null) {
			setVirtualHostId(virtualHostId);
		}

		Long backOfficeVirtualHostId = (Long)attributes.get(
				"backOfficeVirtualHostId");

		if (backOfficeVirtualHostId != null) {
			setBackOfficeVirtualHostId(backOfficeVirtualHostId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this s p site setup.
	*
	* @return the primary key of this s p site setup
	*/
	@Override
	public long getPrimaryKey() {
		return _spSiteSetup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p site setup.
	*
	* @param primaryKey the primary key of this s p site setup
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSiteSetup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p site setup.
	*
	* @return the uuid of this s p site setup
	*/
	@Override
	public java.lang.String getUuid() {
		return _spSiteSetup.getUuid();
	}

	/**
	* Sets the uuid of this s p site setup.
	*
	* @param uuid the uuid of this s p site setup
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spSiteSetup.setUuid(uuid);
	}

	/**
	* Returns the sp site setup ID of this s p site setup.
	*
	* @return the sp site setup ID of this s p site setup
	*/
	@Override
	public long getSpSiteSetupId() {
		return _spSiteSetup.getSpSiteSetupId();
	}

	/**
	* Sets the sp site setup ID of this s p site setup.
	*
	* @param spSiteSetupId the sp site setup ID of this s p site setup
	*/
	@Override
	public void setSpSiteSetupId(long spSiteSetupId) {
		_spSiteSetup.setSpSiteSetupId(spSiteSetupId);
	}

	/**
	* Returns the group ID of this s p site setup.
	*
	* @return the group ID of this s p site setup
	*/
	@Override
	public long getGroupId() {
		return _spSiteSetup.getGroupId();
	}

	/**
	* Sets the group ID of this s p site setup.
	*
	* @param groupId the group ID of this s p site setup
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSiteSetup.setGroupId(groupId);
	}

	/**
	* Returns the product ID of this s p site setup.
	*
	* @return the product ID of this s p site setup
	*/
	@Override
	public long getProductId() {
		return _spSiteSetup.getProductId();
	}

	/**
	* Sets the product ID of this s p site setup.
	*
	* @param productId the product ID of this s p site setup
	*/
	@Override
	public void setProductId(long productId) {
		_spSiteSetup.setProductId(productId);
	}

	/**
	* Returns the product name of this s p site setup.
	*
	* @return the product name of this s p site setup
	*/
	@Override
	public java.lang.String getProductName() {
		return _spSiteSetup.getProductName();
	}

	/**
	* Sets the product name of this s p site setup.
	*
	* @param productName the product name of this s p site setup
	*/
	@Override
	public void setProductName(java.lang.String productName) {
		_spSiteSetup.setProductName(productName);
	}

	/**
	* Returns the sub product ID of this s p site setup.
	*
	* @return the sub product ID of this s p site setup
	*/
	@Override
	public long getSubProductId() {
		return _spSiteSetup.getSubProductId();
	}

	/**
	* Sets the sub product ID of this s p site setup.
	*
	* @param subProductId the sub product ID of this s p site setup
	*/
	@Override
	public void setSubProductId(long subProductId) {
		_spSiteSetup.setSubProductId(subProductId);
	}

	/**
	* Returns the sub product name of this s p site setup.
	*
	* @return the sub product name of this s p site setup
	*/
	@Override
	public java.lang.String getSubProductName() {
		return _spSiteSetup.getSubProductName();
	}

	/**
	* Sets the sub product name of this s p site setup.
	*
	* @param subProductName the sub product name of this s p site setup
	*/
	@Override
	public void setSubProductName(java.lang.String subProductName) {
		_spSiteSetup.setSubProductName(subProductName);
	}

	/**
	* Returns the virtual host ID of this s p site setup.
	*
	* @return the virtual host ID of this s p site setup
	*/
	@Override
	public long getVirtualHostId() {
		return _spSiteSetup.getVirtualHostId();
	}

	/**
	* Sets the virtual host ID of this s p site setup.
	*
	* @param virtualHostId the virtual host ID of this s p site setup
	*/
	@Override
	public void setVirtualHostId(long virtualHostId) {
		_spSiteSetup.setVirtualHostId(virtualHostId);
	}

	/**
	* Returns the back office virtual host ID of this s p site setup.
	*
	* @return the back office virtual host ID of this s p site setup
	*/
	@Override
	public long getBackOfficeVirtualHostId() {
		return _spSiteSetup.getBackOfficeVirtualHostId();
	}

	/**
	* Sets the back office virtual host ID of this s p site setup.
	*
	* @param backOfficeVirtualHostId the back office virtual host ID of this s p site setup
	*/
	@Override
	public void setBackOfficeVirtualHostId(long backOfficeVirtualHostId) {
		_spSiteSetup.setBackOfficeVirtualHostId(backOfficeVirtualHostId);
	}

	/**
	* Returns the company ID of this s p site setup.
	*
	* @return the company ID of this s p site setup
	*/
	@Override
	public long getCompanyId() {
		return _spSiteSetup.getCompanyId();
	}

	/**
	* Sets the company ID of this s p site setup.
	*
	* @param companyId the company ID of this s p site setup
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSiteSetup.setCompanyId(companyId);
	}

	/**
	* Returns the created by of this s p site setup.
	*
	* @return the created by of this s p site setup
	*/
	@Override
	public long getCreatedBy() {
		return _spSiteSetup.getCreatedBy();
	}

	/**
	* Sets the created by of this s p site setup.
	*
	* @param createdBy the created by of this s p site setup
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spSiteSetup.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this s p site setup.
	*
	* @return the modified by of this s p site setup
	*/
	@Override
	public long getModifiedBy() {
		return _spSiteSetup.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p site setup.
	*
	* @param modifiedBy the modified by of this s p site setup
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spSiteSetup.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the created date of this s p site setup.
	*
	* @return the created date of this s p site setup
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _spSiteSetup.getCreatedDate();
	}

	/**
	* Sets the created date of this s p site setup.
	*
	* @param createdDate the created date of this s p site setup
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_spSiteSetup.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this s p site setup.
	*
	* @return the modified date of this s p site setup
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSiteSetup.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p site setup.
	*
	* @param modifiedDate the modified date of this s p site setup
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSiteSetup.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spSiteSetup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSiteSetup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSiteSetup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSiteSetup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSiteSetup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSiteSetup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSiteSetup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSiteSetup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSiteSetup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSiteSetup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSiteSetup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSiteSetupWrapper((SPSiteSetup)_spSiteSetup.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup) {
		return _spSiteSetup.compareTo(spSiteSetup);
	}

	@Override
	public int hashCode() {
		return _spSiteSetup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPSiteSetup> toCacheModel() {
		return _spSiteSetup.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup toEscapedModel() {
		return new SPSiteSetupWrapper(_spSiteSetup.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSiteSetup toUnescapedModel() {
		return new SPSiteSetupWrapper(_spSiteSetup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSiteSetup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSiteSetup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSiteSetup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSiteSetupWrapper)) {
			return false;
		}

		SPSiteSetupWrapper spSiteSetupWrapper = (SPSiteSetupWrapper)obj;

		if (Validator.equals(_spSiteSetup, spSiteSetupWrapper._spSiteSetup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSiteSetup getWrappedSPSiteSetup() {
		return _spSiteSetup;
	}

	@Override
	public SPSiteSetup getWrappedModel() {
		return _spSiteSetup;
	}

	@Override
	public void resetOriginalValues() {
		_spSiteSetup.resetOriginalValues();
	}

	private SPSiteSetup _spSiteSetup;
}