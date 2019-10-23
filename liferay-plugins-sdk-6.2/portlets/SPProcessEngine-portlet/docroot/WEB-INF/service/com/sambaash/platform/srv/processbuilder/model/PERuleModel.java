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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PERule service. Represents a row in the &quot;SPPERule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PERule
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PERuleImpl
 * @see com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl
 * @generated
 */
public interface PERuleModel extends BaseModel<PERule>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p e rule model instance should use the {@link PERule} interface instead.
	 */

	/**
	 * Returns the primary key of this p e rule.
	 *
	 * @return the primary key of this p e rule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p e rule.
	 *
	 * @param primaryKey the primary key of this p e rule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this p e rule.
	 *
	 * @return the uuid of this p e rule
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this p e rule.
	 *
	 * @param uuid the uuid of this p e rule
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp p e rule ID of this p e rule.
	 *
	 * @return the sp p e rule ID of this p e rule
	 */
	public long getSpPERuleId();

	/**
	 * Sets the sp p e rule ID of this p e rule.
	 *
	 * @param spPERuleId the sp p e rule ID of this p e rule
	 */
	public void setSpPERuleId(long spPERuleId);

	/**
	 * Returns the group ID of this p e rule.
	 *
	 * @return the group ID of this p e rule
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this p e rule.
	 *
	 * @param groupId the group ID of this p e rule
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this p e rule.
	 *
	 * @return the company ID of this p e rule
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this p e rule.
	 *
	 * @param companyId the company ID of this p e rule
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this p e rule.
	 *
	 * @return the user ID of this p e rule
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this p e rule.
	 *
	 * @param userId the user ID of this p e rule
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this p e rule.
	 *
	 * @return the user uuid of this p e rule
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p e rule.
	 *
	 * @param userUuid the user uuid of this p e rule
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this p e rule.
	 *
	 * @return the user name of this p e rule
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this p e rule.
	 *
	 * @param userName the user name of this p e rule
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this p e rule.
	 *
	 * @return the create date of this p e rule
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this p e rule.
	 *
	 * @param createDate the create date of this p e rule
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this p e rule.
	 *
	 * @return the modified date of this p e rule
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this p e rule.
	 *
	 * @param modifiedDate the modified date of this p e rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp p e rule set ID of this p e rule.
	 *
	 * @return the sp p e rule set ID of this p e rule
	 */
	public long getSpPERuleSetId();

	/**
	 * Sets the sp p e rule set ID of this p e rule.
	 *
	 * @param spPERuleSetId the sp p e rule set ID of this p e rule
	 */
	public void setSpPERuleSetId(long spPERuleSetId);

	/**
	 * Returns the name of this p e rule.
	 *
	 * @return the name of this p e rule
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this p e rule.
	 *
	 * @param name the name of this p e rule
	 */
	public void setName(String name);

	/**
	 * Returns the type of this p e rule.
	 *
	 * @return the type of this p e rule
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this p e rule.
	 *
	 * @param type the type of this p e rule
	 */
	public void setType(String type);

	/**
	 * Returns the definition of this p e rule.
	 *
	 * @return the definition of this p e rule
	 */
	@AutoEscape
	public String getDefinition();

	/**
	 * Sets the definition of this p e rule.
	 *
	 * @param definition the definition of this p e rule
	 */
	public void setDefinition(String definition);

	/**
	 * Returns the sequence n o of this p e rule.
	 *
	 * @return the sequence n o of this p e rule
	 */
	public long getSequenceNO();

	/**
	 * Sets the sequence n o of this p e rule.
	 *
	 * @param sequenceNO the sequence n o of this p e rule
	 */
	public void setSequenceNO(long sequenceNO);

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
		com.sambaash.platform.srv.processbuilder.model.PERule peRule);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.processbuilder.model.PERule> toCacheModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERule toEscapedModel();

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERule toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}