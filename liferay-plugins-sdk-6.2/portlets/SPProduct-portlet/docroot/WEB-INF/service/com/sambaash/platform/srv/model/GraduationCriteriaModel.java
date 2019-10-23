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
 * The base model interface for the GraduationCriteria service. Represents a row in the &quot;SPGraduationCriteria&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see GraduationCriteria
 * @see com.sambaash.platform.srv.model.impl.GraduationCriteriaImpl
 * @see com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl
 * @generated
 */
public interface GraduationCriteriaModel extends BaseModel<GraduationCriteria>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a graduation criteria model instance should use the {@link GraduationCriteria} interface instead.
	 */

	/**
	 * Returns the primary key of this graduation criteria.
	 *
	 * @return the primary key of this graduation criteria
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this graduation criteria.
	 *
	 * @param primaryKey the primary key of this graduation criteria
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp graduation criteria ID of this graduation criteria.
	 *
	 * @return the sp graduation criteria ID of this graduation criteria
	 */
	public long getSpGraduationCriteriaId();

	/**
	 * Sets the sp graduation criteria ID of this graduation criteria.
	 *
	 * @param spGraduationCriteriaId the sp graduation criteria ID of this graduation criteria
	 */
	public void setSpGraduationCriteriaId(long spGraduationCriteriaId);

	/**
	 * Returns the group ID of this graduation criteria.
	 *
	 * @return the group ID of this graduation criteria
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this graduation criteria.
	 *
	 * @param groupId the group ID of this graduation criteria
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this graduation criteria.
	 *
	 * @return the company ID of this graduation criteria
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this graduation criteria.
	 *
	 * @param companyId the company ID of this graduation criteria
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this graduation criteria.
	 *
	 * @return the user ID of this graduation criteria
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this graduation criteria.
	 *
	 * @param userId the user ID of this graduation criteria
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this graduation criteria.
	 *
	 * @return the user uuid of this graduation criteria
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this graduation criteria.
	 *
	 * @param userUuid the user uuid of this graduation criteria
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this graduation criteria.
	 *
	 * @return the user name of this graduation criteria
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this graduation criteria.
	 *
	 * @param userName the user name of this graduation criteria
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this graduation criteria.
	 *
	 * @return the create date of this graduation criteria
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this graduation criteria.
	 *
	 * @param createDate the create date of this graduation criteria
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this graduation criteria.
	 *
	 * @return the modified date of this graduation criteria
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this graduation criteria.
	 *
	 * @param modifiedDate the modified date of this graduation criteria
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the criteria type of this graduation criteria.
	 *
	 * @return the criteria type of this graduation criteria
	 */
	public long getCriteriaType();

	/**
	 * Sets the criteria type of this graduation criteria.
	 *
	 * @param criteriaType the criteria type of this graduation criteria
	 */
	public void setCriteriaType(long criteriaType);

	/**
	 * Returns the criteria level of this graduation criteria.
	 *
	 * @return the criteria level of this graduation criteria
	 */
	public long getCriteriaLevel();

	/**
	 * Sets the criteria level of this graduation criteria.
	 *
	 * @param criteriaLevel the criteria level of this graduation criteria
	 */
	public void setCriteriaLevel(long criteriaLevel);

	/**
	 * Returns the criteria value range of this graduation criteria.
	 *
	 * @return the criteria value range of this graduation criteria
	 */
	@AutoEscape
	public String getCriteriaValueRange();

	/**
	 * Sets the criteria value range of this graduation criteria.
	 *
	 * @param criteriaValueRange the criteria value range of this graduation criteria
	 */
	public void setCriteriaValueRange(String criteriaValueRange);

	/**
	 * Returns the criteria desc of this graduation criteria.
	 *
	 * @return the criteria desc of this graduation criteria
	 */
	@AutoEscape
	public String getCriteriaDesc();

	/**
	 * Sets the criteria desc of this graduation criteria.
	 *
	 * @param criteriaDesc the criteria desc of this graduation criteria
	 */
	public void setCriteriaDesc(String criteriaDesc);

	/**
	 * Returns the sp course ID of this graduation criteria.
	 *
	 * @return the sp course ID of this graduation criteria
	 */
	public long getSpCourseId();

	/**
	 * Sets the sp course ID of this graduation criteria.
	 *
	 * @param spCourseId the sp course ID of this graduation criteria
	 */
	public void setSpCourseId(long spCourseId);

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
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.GraduationCriteria> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}