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
 * The base model interface for the Certificate service. Represents a row in the &quot;SPCertificate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.CertificateImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Certificate
 * @see com.sambaash.platform.srv.model.impl.CertificateImpl
 * @see com.sambaash.platform.srv.model.impl.CertificateModelImpl
 * @generated
 */
public interface CertificateModel extends BaseModel<Certificate>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a certificate model instance should use the {@link Certificate} interface instead.
	 */

	/**
	 * Returns the primary key of this certificate.
	 *
	 * @return the primary key of this certificate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this certificate.
	 *
	 * @param primaryKey the primary key of this certificate
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp certificatet ID of this certificate.
	 *
	 * @return the sp certificatet ID of this certificate
	 */
	public long getSpCertificatetId();

	/**
	 * Sets the sp certificatet ID of this certificate.
	 *
	 * @param spCertificatetId the sp certificatet ID of this certificate
	 */
	public void setSpCertificatetId(long spCertificatetId);

	/**
	 * Returns the group ID of this certificate.
	 *
	 * @return the group ID of this certificate
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this certificate.
	 *
	 * @param groupId the group ID of this certificate
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this certificate.
	 *
	 * @return the company ID of this certificate
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this certificate.
	 *
	 * @param companyId the company ID of this certificate
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this certificate.
	 *
	 * @return the user ID of this certificate
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this certificate.
	 *
	 * @param userId the user ID of this certificate
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this certificate.
	 *
	 * @return the user uuid of this certificate
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this certificate.
	 *
	 * @param userUuid the user uuid of this certificate
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this certificate.
	 *
	 * @return the user name of this certificate
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this certificate.
	 *
	 * @param userName the user name of this certificate
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this certificate.
	 *
	 * @return the create date of this certificate
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this certificate.
	 *
	 * @param createDate the create date of this certificate
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this certificate.
	 *
	 * @return the modified date of this certificate
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this certificate.
	 *
	 * @param modifiedDate the modified date of this certificate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the country ID of this certificate.
	 *
	 * @return the country ID of this certificate
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this certificate.
	 *
	 * @param countryId the country ID of this certificate
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the certificate code of this certificate.
	 *
	 * @return the certificate code of this certificate
	 */
	@AutoEscape
	public String getCertificateCode();

	/**
	 * Sets the certificate code of this certificate.
	 *
	 * @param certificateCode the certificate code of this certificate
	 */
	public void setCertificateCode(String certificateCode);

	/**
	 * Returns the certificate type of this certificate.
	 *
	 * @return the certificate type of this certificate
	 */
	public long getCertificateType();

	/**
	 * Sets the certificate type of this certificate.
	 *
	 * @param certificateType the certificate type of this certificate
	 */
	public void setCertificateType(long certificateType);

	/**
	 * Returns the title of this certificate.
	 *
	 * @return the title of this certificate
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this certificate.
	 *
	 * @param title the title of this certificate
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this certificate.
	 *
	 * @return the description of this certificate
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this certificate.
	 *
	 * @param description the description of this certificate
	 */
	public void setDescription(String description);

	/**
	 * Returns the level of this certificate.
	 *
	 * @return the level of this certificate
	 */
	public long getLevel();

	/**
	 * Sets the level of this certificate.
	 *
	 * @param level the level of this certificate
	 */
	public void setLevel(long level);

	/**
	 * Returns the attachment folder ID of this certificate.
	 *
	 * @return the attachment folder ID of this certificate
	 */
	public long getAttachmentFolderId();

	/**
	 * Sets the attachment folder ID of this certificate.
	 *
	 * @param attachmentFolderId the attachment folder ID of this certificate
	 */
	public void setAttachmentFolderId(long attachmentFolderId);

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
		com.sambaash.platform.srv.model.Certificate certificate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.Certificate> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.Certificate toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.Certificate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}