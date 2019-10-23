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
 * The base model interface for the CourseEnrollEsignInfo service. Represents a row in the &quot;SPCourseEnrollEsignInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollEsignInfo
 * @see com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoImpl
 * @see com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl
 * @generated
 */
public interface CourseEnrollEsignInfoModel extends BaseModel<CourseEnrollEsignInfo>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a course enroll esign info model instance should use the {@link CourseEnrollEsignInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this course enroll esign info.
	 *
	 * @return the primary key of this course enroll esign info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this course enroll esign info.
	 *
	 * @param primaryKey the primary key of this course enroll esign info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp esign info ID of this course enroll esign info.
	 *
	 * @return the sp esign info ID of this course enroll esign info
	 */
	public long getSpEsignInfoId();

	/**
	 * Sets the sp esign info ID of this course enroll esign info.
	 *
	 * @param spEsignInfoId the sp esign info ID of this course enroll esign info
	 */
	public void setSpEsignInfoId(long spEsignInfoId);

	/**
	 * Returns the group ID of this course enroll esign info.
	 *
	 * @return the group ID of this course enroll esign info
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this course enroll esign info.
	 *
	 * @param groupId the group ID of this course enroll esign info
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this course enroll esign info.
	 *
	 * @return the company ID of this course enroll esign info
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this course enroll esign info.
	 *
	 * @param companyId the company ID of this course enroll esign info
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this course enroll esign info.
	 *
	 * @return the user ID of this course enroll esign info
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this course enroll esign info.
	 *
	 * @param userId the user ID of this course enroll esign info
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this course enroll esign info.
	 *
	 * @return the user uuid of this course enroll esign info
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this course enroll esign info.
	 *
	 * @param userUuid the user uuid of this course enroll esign info
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this course enroll esign info.
	 *
	 * @return the user name of this course enroll esign info
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this course enroll esign info.
	 *
	 * @param userName the user name of this course enroll esign info
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this course enroll esign info.
	 *
	 * @return the create date of this course enroll esign info
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this course enroll esign info.
	 *
	 * @param createDate the create date of this course enroll esign info
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this course enroll esign info.
	 *
	 * @return the modified date of this course enroll esign info
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this course enroll esign info.
	 *
	 * @param modifiedDate the modified date of this course enroll esign info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the signer ID of this course enroll esign info.
	 *
	 * @return the signer ID of this course enroll esign info
	 */
	@AutoEscape
	public String getSignerId();

	/**
	 * Sets the signer ID of this course enroll esign info.
	 *
	 * @param signerId the signer ID of this course enroll esign info
	 */
	public void setSignerId(String signerId);

	/**
	 * Returns the package ID of this course enroll esign info.
	 *
	 * @return the package ID of this course enroll esign info
	 */
	@AutoEscape
	public String getPackageId();

	/**
	 * Sets the package ID of this course enroll esign info.
	 *
	 * @param packageId the package ID of this course enroll esign info
	 */
	public void setPackageId(String packageId);

	/**
	 * Returns the document ID of this course enroll esign info.
	 *
	 * @return the document ID of this course enroll esign info
	 */
	@AutoEscape
	public String getDocumentId();

	/**
	 * Sets the document ID of this course enroll esign info.
	 *
	 * @param documentId the document ID of this course enroll esign info
	 */
	public void setDocumentId(String documentId);

	/**
	 * Returns the last generated url of this course enroll esign info.
	 *
	 * @return the last generated url of this course enroll esign info
	 */
	@AutoEscape
	public String getLastGeneratedUrl();

	/**
	 * Sets the last generated url of this course enroll esign info.
	 *
	 * @param lastGeneratedUrl the last generated url of this course enroll esign info
	 */
	public void setLastGeneratedUrl(String lastGeneratedUrl);

	/**
	 * Returns the sp p e process state ID of this course enroll esign info.
	 *
	 * @return the sp p e process state ID of this course enroll esign info
	 */
	public long getSpPEProcessStateId();

	/**
	 * Sets the sp p e process state ID of this course enroll esign info.
	 *
	 * @param spPEProcessStateId the sp p e process state ID of this course enroll esign info
	 */
	public void setSpPEProcessStateId(long spPEProcessStateId);

	/**
	 * Returns the extra info of this course enroll esign info.
	 *
	 * @return the extra info of this course enroll esign info
	 */
	@AutoEscape
	public String getExtraInfo();

	/**
	 * Sets the extra info of this course enroll esign info.
	 *
	 * @param extraInfo the extra info of this course enroll esign info
	 */
	public void setExtraInfo(String extraInfo);

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
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}