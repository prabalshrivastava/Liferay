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
 * The base model interface for the Outline service. Represents a row in the &quot;SPOutline&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.OutlineImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Outline
 * @see com.sambaash.platform.srv.model.impl.OutlineImpl
 * @see com.sambaash.platform.srv.model.impl.OutlineModelImpl
 * @generated
 */
public interface OutlineModel extends BaseModel<Outline>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a outline model instance should use the {@link Outline} interface instead.
	 */

	/**
	 * Returns the primary key of this outline.
	 *
	 * @return the primary key of this outline
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this outline.
	 *
	 * @param primaryKey the primary key of this outline
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp outline ID of this outline.
	 *
	 * @return the sp outline ID of this outline
	 */
	public long getSpOutlineId();

	/**
	 * Sets the sp outline ID of this outline.
	 *
	 * @param spOutlineId the sp outline ID of this outline
	 */
	public void setSpOutlineId(long spOutlineId);

	/**
	 * Returns the group ID of this outline.
	 *
	 * @return the group ID of this outline
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this outline.
	 *
	 * @param groupId the group ID of this outline
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this outline.
	 *
	 * @return the company ID of this outline
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this outline.
	 *
	 * @param companyId the company ID of this outline
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this outline.
	 *
	 * @return the user ID of this outline
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this outline.
	 *
	 * @param userId the user ID of this outline
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this outline.
	 *
	 * @return the user uuid of this outline
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this outline.
	 *
	 * @param userUuid the user uuid of this outline
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this outline.
	 *
	 * @return the user name of this outline
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this outline.
	 *
	 * @param userName the user name of this outline
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this outline.
	 *
	 * @return the create date of this outline
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this outline.
	 *
	 * @param createDate the create date of this outline
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this outline.
	 *
	 * @return the modified date of this outline
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this outline.
	 *
	 * @param modifiedDate the modified date of this outline
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp competency unit ID of this outline.
	 *
	 * @return the sp competency unit ID of this outline
	 */
	public long getSpCompetencyUnitId();

	/**
	 * Sets the sp competency unit ID of this outline.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID of this outline
	 */
	public void setSpCompetencyUnitId(long spCompetencyUnitId);

	/**
	 * Returns the outline type of this outline.
	 *
	 * @return the outline type of this outline
	 */
	public long getOutlineType();

	/**
	 * Sets the outline type of this outline.
	 *
	 * @param outlineType the outline type of this outline
	 */
	public void setOutlineType(long outlineType);

	/**
	 * Returns the outline desc of this outline.
	 *
	 * @return the outline desc of this outline
	 */
	@AutoEscape
	public String getOutlineDesc();

	/**
	 * Sets the outline desc of this outline.
	 *
	 * @param outlineDesc the outline desc of this outline
	 */
	public void setOutlineDesc(String outlineDesc);

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
	public int compareTo(com.sambaash.platform.srv.model.Outline outline);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.Outline> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.Outline toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.Outline toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}