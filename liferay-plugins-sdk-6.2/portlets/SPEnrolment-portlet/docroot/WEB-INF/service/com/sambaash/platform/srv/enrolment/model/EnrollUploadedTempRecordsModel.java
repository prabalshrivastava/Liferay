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

package com.sambaash.platform.srv.enrolment.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EnrollUploadedTempRecords service. Represents a row in the &quot;enrolment_EnrollUploadedTempRecords&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsImpl}.
 * </p>
 *
 * @author Baxture
 * @see EnrollUploadedTempRecords
 * @see com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsImpl
 * @see com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl
 * @generated
 */
public interface EnrollUploadedTempRecordsModel extends BaseModel<EnrollUploadedTempRecords> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a enroll uploaded temp records model instance should use the {@link EnrollUploadedTempRecords} interface instead.
	 */

	/**
	 * Returns the primary key of this enroll uploaded temp records.
	 *
	 * @return the primary key of this enroll uploaded temp records
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this enroll uploaded temp records.
	 *
	 * @param primaryKey the primary key of this enroll uploaded temp records
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uploaded rec ID of this enroll uploaded temp records.
	 *
	 * @return the uploaded rec ID of this enroll uploaded temp records
	 */
	public long getUploadedRecId();

	/**
	 * Sets the uploaded rec ID of this enroll uploaded temp records.
	 *
	 * @param uploadedRecId the uploaded rec ID of this enroll uploaded temp records
	 */
	public void setUploadedRecId(long uploadedRecId);

	/**
	 * Returns the upload transact ID of this enroll uploaded temp records.
	 *
	 * @return the upload transact ID of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getUploadTransactId();

	/**
	 * Sets the upload transact ID of this enroll uploaded temp records.
	 *
	 * @param uploadTransactId the upload transact ID of this enroll uploaded temp records
	 */
	public void setUploadTransactId(String uploadTransactId);

	/**
	 * Returns the spr code of this enroll uploaded temp records.
	 *
	 * @return the spr code of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getSprCode();

	/**
	 * Sets the spr code of this enroll uploaded temp records.
	 *
	 * @param sprCode the spr code of this enroll uploaded temp records
	 */
	public void setSprCode(String sprCode);

	/**
	 * Returns the title of this enroll uploaded temp records.
	 *
	 * @return the title of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this enroll uploaded temp records.
	 *
	 * @param title the title of this enroll uploaded temp records
	 */
	public void setTitle(String title);

	/**
	 * Returns the full official name of this enroll uploaded temp records.
	 *
	 * @return the full official name of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getFullOfficialName();

	/**
	 * Sets the full official name of this enroll uploaded temp records.
	 *
	 * @param fullOfficialName the full official name of this enroll uploaded temp records
	 */
	public void setFullOfficialName(String fullOfficialName);

	/**
	 * Returns the gender of this enroll uploaded temp records.
	 *
	 * @return the gender of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this enroll uploaded temp records.
	 *
	 * @param gender the gender of this enroll uploaded temp records
	 */
	public void setGender(String gender);

	/**
	 * Returns the dateof birth of this enroll uploaded temp records.
	 *
	 * @return the dateof birth of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getDateofBirth();

	/**
	 * Sets the dateof birth of this enroll uploaded temp records.
	 *
	 * @param dateofBirth the dateof birth of this enroll uploaded temp records
	 */
	public void setDateofBirth(String dateofBirth);

	/**
	 * Returns the email of this enroll uploaded temp records.
	 *
	 * @return the email of this enroll uploaded temp records
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this enroll uploaded temp records.
	 *
	 * @param email the email of this enroll uploaded temp records
	 */
	public void setEmail(String email);

	/**
	 * Returns the user ID of this enroll uploaded temp records.
	 *
	 * @return the user ID of this enroll uploaded temp records
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this enroll uploaded temp records.
	 *
	 * @param userId the user ID of this enroll uploaded temp records
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this enroll uploaded temp records.
	 *
	 * @return the user uuid of this enroll uploaded temp records
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this enroll uploaded temp records.
	 *
	 * @param userUuid the user uuid of this enroll uploaded temp records
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this enroll uploaded temp records.
	 *
	 * @return the create date of this enroll uploaded temp records
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this enroll uploaded temp records.
	 *
	 * @param createDate the create date of this enroll uploaded temp records
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this enroll uploaded temp records.
	 *
	 * @return the modified date of this enroll uploaded temp records
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this enroll uploaded temp records.
	 *
	 * @param modifiedDate the modified date of this enroll uploaded temp records
	 */
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
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> toCacheModel();

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords toEscapedModel();

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}