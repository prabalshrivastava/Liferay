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
 * The base model interface for the DurationType service. Represents a row in the &quot;SPDurationType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.DurationTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.DurationTypeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see DurationType
 * @see com.sambaash.platform.srv.model.impl.DurationTypeImpl
 * @see com.sambaash.platform.srv.model.impl.DurationTypeModelImpl
 * @generated
 */
public interface DurationTypeModel extends BaseModel<DurationType>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a duration type model instance should use the {@link DurationType} interface instead.
	 */

	/**
	 * Returns the primary key of this duration type.
	 *
	 * @return the primary key of this duration type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this duration type.
	 *
	 * @param primaryKey the primary key of this duration type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp duration type ID of this duration type.
	 *
	 * @return the sp duration type ID of this duration type
	 */
	public long getSpDurationTypeId();

	/**
	 * Sets the sp duration type ID of this duration type.
	 *
	 * @param spDurationTypeId the sp duration type ID of this duration type
	 */
	public void setSpDurationTypeId(long spDurationTypeId);

	/**
	 * Returns the group ID of this duration type.
	 *
	 * @return the group ID of this duration type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this duration type.
	 *
	 * @param groupId the group ID of this duration type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this duration type.
	 *
	 * @return the company ID of this duration type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this duration type.
	 *
	 * @param companyId the company ID of this duration type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this duration type.
	 *
	 * @return the user ID of this duration type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this duration type.
	 *
	 * @param userId the user ID of this duration type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this duration type.
	 *
	 * @return the user uuid of this duration type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this duration type.
	 *
	 * @param userUuid the user uuid of this duration type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this duration type.
	 *
	 * @return the user name of this duration type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this duration type.
	 *
	 * @param userName the user name of this duration type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this duration type.
	 *
	 * @return the create date of this duration type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this duration type.
	 *
	 * @param createDate the create date of this duration type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this duration type.
	 *
	 * @return the modified date of this duration type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this duration type.
	 *
	 * @param modifiedDate the modified date of this duration type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp learning duration ID of this duration type.
	 *
	 * @return the sp learning duration ID of this duration type
	 */
	public long getSpLearningDurationId();

	/**
	 * Sets the sp learning duration ID of this duration type.
	 *
	 * @param spLearningDurationId the sp learning duration ID of this duration type
	 */
	public void setSpLearningDurationId(long spLearningDurationId);

	/**
	 * Returns the sp course ID of this duration type.
	 *
	 * @return the sp course ID of this duration type
	 */
	public long getSpCourseId();

	/**
	 * Sets the sp course ID of this duration type.
	 *
	 * @param spCourseId the sp course ID of this duration type
	 */
	public void setSpCourseId(long spCourseId);

	/**
	 * Returns the title1 of this duration type.
	 *
	 * @return the title1 of this duration type
	 */
	@AutoEscape
	public String getTitle1();

	/**
	 * Sets the title1 of this duration type.
	 *
	 * @param title1 the title1 of this duration type
	 */
	public void setTitle1(String title1);

	/**
	 * Returns the duration1 of this duration type.
	 *
	 * @return the duration1 of this duration type
	 */
	public long getDuration1();

	/**
	 * Sets the duration1 of this duration type.
	 *
	 * @param duration1 the duration1 of this duration type
	 */
	public void setDuration1(long duration1);

	/**
	 * Returns the title2 of this duration type.
	 *
	 * @return the title2 of this duration type
	 */
	@AutoEscape
	public String getTitle2();

	/**
	 * Sets the title2 of this duration type.
	 *
	 * @param title2 the title2 of this duration type
	 */
	public void setTitle2(String title2);

	/**
	 * Returns the duration2 of this duration type.
	 *
	 * @return the duration2 of this duration type
	 */
	public long getDuration2();

	/**
	 * Sets the duration2 of this duration type.
	 *
	 * @param duration2 the duration2 of this duration type
	 */
	public void setDuration2(long duration2);

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
		com.sambaash.platform.srv.model.DurationType durationType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.DurationType> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.DurationType toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.DurationType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}