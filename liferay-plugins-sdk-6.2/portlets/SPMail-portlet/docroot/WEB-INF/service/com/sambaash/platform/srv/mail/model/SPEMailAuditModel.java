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

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPEMailAudit service. Represents a row in the &quot;SPEMailAudit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPEMailAudit
 * @see com.sambaash.platform.srv.mail.model.impl.SPEMailAuditImpl
 * @see com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl
 * @generated
 */
public interface SPEMailAuditModel extends BaseModel<SPEMailAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p e mail audit model instance should use the {@link SPEMailAudit} interface instead.
	 */

	/**
	 * Returns the primary key of this s p e mail audit.
	 *
	 * @return the primary key of this s p e mail audit
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p e mail audit.
	 *
	 * @param primaryKey the primary key of this s p e mail audit
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp e mail audit of this s p e mail audit.
	 *
	 * @return the sp e mail audit of this s p e mail audit
	 */
	public long getSpEMailAudit();

	/**
	 * Sets the sp e mail audit of this s p e mail audit.
	 *
	 * @param spEMailAudit the sp e mail audit of this s p e mail audit
	 */
	public void setSpEMailAudit(long spEMailAudit);

	/**
	 * Returns the group ID of this s p e mail audit.
	 *
	 * @return the group ID of this s p e mail audit
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this s p e mail audit.
	 *
	 * @param groupId the group ID of this s p e mail audit
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this s p e mail audit.
	 *
	 * @return the company ID of this s p e mail audit
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p e mail audit.
	 *
	 * @param companyId the company ID of this s p e mail audit
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the sent to of this s p e mail audit.
	 *
	 * @return the sent to of this s p e mail audit
	 */
	@AutoEscape
	public String getSentTo();

	/**
	 * Sets the sent to of this s p e mail audit.
	 *
	 * @param sentTo the sent to of this s p e mail audit
	 */
	public void setSentTo(String sentTo);

	/**
	 * Returns the cc of this s p e mail audit.
	 *
	 * @return the cc of this s p e mail audit
	 */
	@AutoEscape
	public String getCc();

	/**
	 * Sets the cc of this s p e mail audit.
	 *
	 * @param cc the cc of this s p e mail audit
	 */
	public void setCc(String cc);

	/**
	 * Returns the bcc of this s p e mail audit.
	 *
	 * @return the bcc of this s p e mail audit
	 */
	@AutoEscape
	public String getBcc();

	/**
	 * Sets the bcc of this s p e mail audit.
	 *
	 * @param bcc the bcc of this s p e mail audit
	 */
	public void setBcc(String bcc);

	/**
	 * Returns the category of this s p e mail audit.
	 *
	 * @return the category of this s p e mail audit
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this s p e mail audit.
	 *
	 * @param category the category of this s p e mail audit
	 */
	public void setCategory(String category);

	/**
	 * Returns the subject of this s p e mail audit.
	 *
	 * @return the subject of this s p e mail audit
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this s p e mail audit.
	 *
	 * @param subject the subject of this s p e mail audit
	 */
	public void setSubject(String subject);

	/**
	 * Returns the content of this s p e mail audit.
	 *
	 * @return the content of this s p e mail audit
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this s p e mail audit.
	 *
	 * @param content the content of this s p e mail audit
	 */
	public void setContent(String content);

	/**
	 * Returns the sent date of this s p e mail audit.
	 *
	 * @return the sent date of this s p e mail audit
	 */
	public Date getSentDate();

	/**
	 * Sets the sent date of this s p e mail audit.
	 *
	 * @param sentDate the sent date of this s p e mail audit
	 */
	public void setSentDate(Date sentDate);

	/**
	 * Returns the messasge ID of this s p e mail audit.
	 *
	 * @return the messasge ID of this s p e mail audit
	 */
	@AutoEscape
	public String getMessasgeId();

	/**
	 * Sets the messasge ID of this s p e mail audit.
	 *
	 * @param messasgeId the messasge ID of this s p e mail audit
	 */
	public void setMessasgeId(String messasgeId);

	/**
	 * Returns the user ID of this s p e mail audit.
	 *
	 * @return the user ID of this s p e mail audit
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this s p e mail audit.
	 *
	 * @param userId the user ID of this s p e mail audit
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p e mail audit.
	 *
	 * @return the user uuid of this s p e mail audit
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p e mail audit.
	 *
	 * @param userUuid the user uuid of this s p e mail audit
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the org ID of this s p e mail audit.
	 *
	 * @return the org ID of this s p e mail audit
	 */
	public long getOrgId();

	/**
	 * Sets the org ID of this s p e mail audit.
	 *
	 * @param orgId the org ID of this s p e mail audit
	 */
	public void setOrgId(long orgId);

	/**
	 * Returns the process state ID of this s p e mail audit.
	 *
	 * @return the process state ID of this s p e mail audit
	 */
	public long getProcessStateId();

	/**
	 * Sets the process state ID of this s p e mail audit.
	 *
	 * @param processStateId the process state ID of this s p e mail audit
	 */
	public void setProcessStateId(long processStateId);

	/**
	 * Returns the node ID of this s p e mail audit.
	 *
	 * @return the node ID of this s p e mail audit
	 */
	public long getNodeId();

	/**
	 * Sets the node ID of this s p e mail audit.
	 *
	 * @param nodeId the node ID of this s p e mail audit
	 */
	public void setNodeId(long nodeId);

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
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.mail.model.SPEMailAudit> toCacheModel();

	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit toEscapedModel();

	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}