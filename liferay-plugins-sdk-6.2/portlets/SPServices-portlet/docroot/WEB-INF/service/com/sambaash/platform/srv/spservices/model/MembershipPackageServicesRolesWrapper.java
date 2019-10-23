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
 * This class is a wrapper for {@link MembershipPackageServicesRoles}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageServicesRoles
 * @generated
 */
public class MembershipPackageServicesRolesWrapper
	implements MembershipPackageServicesRoles,
		ModelWrapper<MembershipPackageServicesRoles> {
	public MembershipPackageServicesRolesWrapper(
		MembershipPackageServicesRoles membershipPackageServicesRoles) {
		_membershipPackageServicesRoles = membershipPackageServicesRoles;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageServicesRoles.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageServicesRoles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpgsrlId", getMpgsrlId());
		attributes.put("mpId", getMpId());
		attributes.put("serviceId", getServiceId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("roleId", getRoleId());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpgsrlId = (Long)attributes.get("mpgsrlId");

		if (mpgsrlId != null) {
			setMpgsrlId(mpgsrlId);
		}

		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		Date extra5 = (Date)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		Date extra6 = (Date)attributes.get("extra6");

		if (extra6 != null) {
			setExtra6(extra6);
		}
	}

	/**
	* Returns the primary key of this membership package services roles.
	*
	* @return the primary key of this membership package services roles
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipPackageServicesRoles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership package services roles.
	*
	* @param primaryKey the primary key of this membership package services roles
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipPackageServicesRoles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mpgsrl ID of this membership package services roles.
	*
	* @return the mpgsrl ID of this membership package services roles
	*/
	@Override
	public long getMpgsrlId() {
		return _membershipPackageServicesRoles.getMpgsrlId();
	}

	/**
	* Sets the mpgsrl ID of this membership package services roles.
	*
	* @param mpgsrlId the mpgsrl ID of this membership package services roles
	*/
	@Override
	public void setMpgsrlId(long mpgsrlId) {
		_membershipPackageServicesRoles.setMpgsrlId(mpgsrlId);
	}

	/**
	* Returns the mp ID of this membership package services roles.
	*
	* @return the mp ID of this membership package services roles
	*/
	@Override
	public long getMpId() {
		return _membershipPackageServicesRoles.getMpId();
	}

	/**
	* Sets the mp ID of this membership package services roles.
	*
	* @param mpId the mp ID of this membership package services roles
	*/
	@Override
	public void setMpId(long mpId) {
		_membershipPackageServicesRoles.setMpId(mpId);
	}

	/**
	* Returns the service ID of this membership package services roles.
	*
	* @return the service ID of this membership package services roles
	*/
	@Override
	public long getServiceId() {
		return _membershipPackageServicesRoles.getServiceId();
	}

	/**
	* Sets the service ID of this membership package services roles.
	*
	* @param serviceId the service ID of this membership package services roles
	*/
	@Override
	public void setServiceId(long serviceId) {
		_membershipPackageServicesRoles.setServiceId(serviceId);
	}

	/**
	* Returns the fully qualified class name of this membership package services roles.
	*
	* @return the fully qualified class name of this membership package services roles
	*/
	@Override
	public java.lang.String getClassName() {
		return _membershipPackageServicesRoles.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_membershipPackageServicesRoles.setClassName(className);
	}

	/**
	* Returns the class name ID of this membership package services roles.
	*
	* @return the class name ID of this membership package services roles
	*/
	@Override
	public long getClassNameId() {
		return _membershipPackageServicesRoles.getClassNameId();
	}

	/**
	* Sets the class name ID of this membership package services roles.
	*
	* @param classNameId the class name ID of this membership package services roles
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_membershipPackageServicesRoles.setClassNameId(classNameId);
	}

	/**
	* Returns the role ID of this membership package services roles.
	*
	* @return the role ID of this membership package services roles
	*/
	@Override
	public long getRoleId() {
		return _membershipPackageServicesRoles.getRoleId();
	}

	/**
	* Sets the role ID of this membership package services roles.
	*
	* @param roleId the role ID of this membership package services roles
	*/
	@Override
	public void setRoleId(long roleId) {
		_membershipPackageServicesRoles.setRoleId(roleId);
	}

	/**
	* Returns the extra1 of this membership package services roles.
	*
	* @return the extra1 of this membership package services roles
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipPackageServicesRoles.getExtra1();
	}

	/**
	* Sets the extra1 of this membership package services roles.
	*
	* @param extra1 the extra1 of this membership package services roles
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipPackageServicesRoles.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership package services roles.
	*
	* @return the extra2 of this membership package services roles
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipPackageServicesRoles.getExtra2();
	}

	/**
	* Sets the extra2 of this membership package services roles.
	*
	* @param extra2 the extra2 of this membership package services roles
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipPackageServicesRoles.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership package services roles.
	*
	* @return the extra3 of this membership package services roles
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipPackageServicesRoles.getExtra3();
	}

	/**
	* Sets the extra3 of this membership package services roles.
	*
	* @param extra3 the extra3 of this membership package services roles
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipPackageServicesRoles.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership package services roles.
	*
	* @return the extra4 of this membership package services roles
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipPackageServicesRoles.getExtra4();
	}

	/**
	* Sets the extra4 of this membership package services roles.
	*
	* @param extra4 the extra4 of this membership package services roles
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipPackageServicesRoles.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership package services roles.
	*
	* @return the extra5 of this membership package services roles
	*/
	@Override
	public java.util.Date getExtra5() {
		return _membershipPackageServicesRoles.getExtra5();
	}

	/**
	* Sets the extra5 of this membership package services roles.
	*
	* @param extra5 the extra5 of this membership package services roles
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_membershipPackageServicesRoles.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this membership package services roles.
	*
	* @return the extra6 of this membership package services roles
	*/
	@Override
	public java.util.Date getExtra6() {
		return _membershipPackageServicesRoles.getExtra6();
	}

	/**
	* Sets the extra6 of this membership package services roles.
	*
	* @param extra6 the extra6 of this membership package services roles
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_membershipPackageServicesRoles.setExtra6(extra6);
	}

	@Override
	public boolean isNew() {
		return _membershipPackageServicesRoles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipPackageServicesRoles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipPackageServicesRoles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipPackageServicesRoles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipPackageServicesRoles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipPackageServicesRoles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipPackageServicesRoles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipPackageServicesRoles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipPackageServicesRoles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipPackageServicesRoles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipPackageServicesRoles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipPackageServicesRolesWrapper((MembershipPackageServicesRoles)_membershipPackageServicesRoles.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles) {
		return _membershipPackageServicesRoles.compareTo(membershipPackageServicesRoles);
	}

	@Override
	public int hashCode() {
		return _membershipPackageServicesRoles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> toCacheModel() {
		return _membershipPackageServicesRoles.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles toEscapedModel() {
		return new MembershipPackageServicesRolesWrapper(_membershipPackageServicesRoles.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles toUnescapedModel() {
		return new MembershipPackageServicesRolesWrapper(_membershipPackageServicesRoles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipPackageServicesRoles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipPackageServicesRoles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipPackageServicesRoles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipPackageServicesRolesWrapper)) {
			return false;
		}

		MembershipPackageServicesRolesWrapper membershipPackageServicesRolesWrapper =
			(MembershipPackageServicesRolesWrapper)obj;

		if (Validator.equals(_membershipPackageServicesRoles,
					membershipPackageServicesRolesWrapper._membershipPackageServicesRoles)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipPackageServicesRoles getWrappedMembershipPackageServicesRoles() {
		return _membershipPackageServicesRoles;
	}

	@Override
	public MembershipPackageServicesRoles getWrappedModel() {
		return _membershipPackageServicesRoles;
	}

	@Override
	public void resetOriginalValues() {
		_membershipPackageServicesRoles.resetOriginalValues();
	}

	private MembershipPackageServicesRoles _membershipPackageServicesRoles;
}