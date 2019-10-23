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
 * The base model interface for the CourseLearning service. Represents a row in the &quot;SPCourseLearning&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.CourseLearningModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.CourseLearningImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseLearning
 * @see com.sambaash.platform.srv.model.impl.CourseLearningImpl
 * @see com.sambaash.platform.srv.model.impl.CourseLearningModelImpl
 * @generated
 */
public interface CourseLearningModel extends BaseModel<CourseLearning>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a course learning model instance should use the {@link CourseLearning} interface instead.
	 */

	/**
	 * Returns the primary key of this course learning.
	 *
	 * @return the primary key of this course learning
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this course learning.
	 *
	 * @param primaryKey the primary key of this course learning
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp course learning ID of this course learning.
	 *
	 * @return the sp course learning ID of this course learning
	 */
	public long getSpCourseLearningId();

	/**
	 * Sets the sp course learning ID of this course learning.
	 *
	 * @param spCourseLearningId the sp course learning ID of this course learning
	 */
	public void setSpCourseLearningId(long spCourseLearningId);

	/**
	 * Returns the group ID of this course learning.
	 *
	 * @return the group ID of this course learning
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this course learning.
	 *
	 * @param groupId the group ID of this course learning
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this course learning.
	 *
	 * @return the company ID of this course learning
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this course learning.
	 *
	 * @param companyId the company ID of this course learning
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this course learning.
	 *
	 * @return the user ID of this course learning
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this course learning.
	 *
	 * @param userId the user ID of this course learning
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this course learning.
	 *
	 * @return the user uuid of this course learning
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this course learning.
	 *
	 * @param userUuid the user uuid of this course learning
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this course learning.
	 *
	 * @return the user name of this course learning
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this course learning.
	 *
	 * @param userName the user name of this course learning
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this course learning.
	 *
	 * @return the create date of this course learning
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this course learning.
	 *
	 * @param createDate the create date of this course learning
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this course learning.
	 *
	 * @return the modified date of this course learning
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this course learning.
	 *
	 * @param modifiedDate the modified date of this course learning
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp course ID of this course learning.
	 *
	 * @return the sp course ID of this course learning
	 */
	public long getSpCourseId();

	/**
	 * Sets the sp course ID of this course learning.
	 *
	 * @param spCourseId the sp course ID of this course learning
	 */
	public void setSpCourseId(long spCourseId);

	/**
	 * Returns the intro of this course learning.
	 *
	 * @return the intro of this course learning
	 */
	@AutoEscape
	public String getIntro();

	/**
	 * Sets the intro of this course learning.
	 *
	 * @param intro the intro of this course learning
	 */
	public void setIntro(String intro);

	/**
	 * Returns the option title of this course learning.
	 *
	 * @return the option title of this course learning
	 */
	@AutoEscape
	public String getOptionTitle();

	/**
	 * Sets the option title of this course learning.
	 *
	 * @param optionTitle the option title of this course learning
	 */
	public void setOptionTitle(String optionTitle);

	/**
	 * Returns the option1 of this course learning.
	 *
	 * @return the option1 of this course learning
	 */
	@AutoEscape
	public String getOption1();

	/**
	 * Sets the option1 of this course learning.
	 *
	 * @param option1 the option1 of this course learning
	 */
	public void setOption1(String option1);

	/**
	 * Returns the option2 of this course learning.
	 *
	 * @return the option2 of this course learning
	 */
	@AutoEscape
	public String getOption2();

	/**
	 * Sets the option2 of this course learning.
	 *
	 * @param option2 the option2 of this course learning
	 */
	public void setOption2(String option2);

	/**
	 * Returns the note of this course learning.
	 *
	 * @return the note of this course learning
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this course learning.
	 *
	 * @param note the note of this course learning
	 */
	public void setNote(String note);

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
		com.sambaash.platform.srv.model.CourseLearning courseLearning);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.CourseLearning> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.CourseLearning toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.CourseLearning toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}