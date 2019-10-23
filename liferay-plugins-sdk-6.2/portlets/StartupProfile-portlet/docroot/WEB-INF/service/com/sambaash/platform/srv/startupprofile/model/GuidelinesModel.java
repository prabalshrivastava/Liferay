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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Guidelines service. Represents a row in the &quot;SPGuidelines&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesImpl}.
 * </p>
 *
 * @author pradeep
 * @see Guidelines
 * @see com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl
 * @generated
 */
public interface GuidelinesModel extends BaseModel<Guidelines> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a guidelines model instance should use the {@link Guidelines} interface instead.
	 */

	/**
	 * Returns the primary key of this guidelines.
	 *
	 * @return the primary key of this guidelines
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this guidelines.
	 *
	 * @param primaryKey the primary key of this guidelines
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this guidelines.
	 *
	 * @return the uuid of this guidelines
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this guidelines.
	 *
	 * @param uuid the uuid of this guidelines
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the guideline ID of this guidelines.
	 *
	 * @return the guideline ID of this guidelines
	 */
	public long getGuidelineId();

	/**
	 * Sets the guideline ID of this guidelines.
	 *
	 * @param guidelineId the guideline ID of this guidelines
	 */
	public void setGuidelineId(long guidelineId);

	/**
	 * Returns the organization ID of this guidelines.
	 *
	 * @return the organization ID of this guidelines
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this guidelines.
	 *
	 * @param organizationId the organization ID of this guidelines
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the principle ID of this guidelines.
	 *
	 * @return the principle ID of this guidelines
	 */
	public long getPrincipleId();

	/**
	 * Sets the principle ID of this guidelines.
	 *
	 * @param principleId the principle ID of this guidelines
	 */
	public void setPrincipleId(long principleId);

	/**
	 * Returns the guideline1 of this guidelines.
	 *
	 * @return the guideline1 of this guidelines
	 */
	public boolean getGuideline1();

	/**
	 * Returns <code>true</code> if this guidelines is guideline1.
	 *
	 * @return <code>true</code> if this guidelines is guideline1; <code>false</code> otherwise
	 */
	public boolean isGuideline1();

	/**
	 * Sets whether this guidelines is guideline1.
	 *
	 * @param guideline1 the guideline1 of this guidelines
	 */
	public void setGuideline1(boolean guideline1);

	/**
	 * Returns the guideline2 of this guidelines.
	 *
	 * @return the guideline2 of this guidelines
	 */
	public boolean getGuideline2();

	/**
	 * Returns <code>true</code> if this guidelines is guideline2.
	 *
	 * @return <code>true</code> if this guidelines is guideline2; <code>false</code> otherwise
	 */
	public boolean isGuideline2();

	/**
	 * Sets whether this guidelines is guideline2.
	 *
	 * @param guideline2 the guideline2 of this guidelines
	 */
	public void setGuideline2(boolean guideline2);

	/**
	 * Returns the guideline3 of this guidelines.
	 *
	 * @return the guideline3 of this guidelines
	 */
	public boolean getGuideline3();

	/**
	 * Returns <code>true</code> if this guidelines is guideline3.
	 *
	 * @return <code>true</code> if this guidelines is guideline3; <code>false</code> otherwise
	 */
	public boolean isGuideline3();

	/**
	 * Sets whether this guidelines is guideline3.
	 *
	 * @param guideline3 the guideline3 of this guidelines
	 */
	public void setGuideline3(boolean guideline3);

	/**
	 * Returns the guideline4 of this guidelines.
	 *
	 * @return the guideline4 of this guidelines
	 */
	public boolean getGuideline4();

	/**
	 * Returns <code>true</code> if this guidelines is guideline4.
	 *
	 * @return <code>true</code> if this guidelines is guideline4; <code>false</code> otherwise
	 */
	public boolean isGuideline4();

	/**
	 * Sets whether this guidelines is guideline4.
	 *
	 * @param guideline4 the guideline4 of this guidelines
	 */
	public void setGuideline4(boolean guideline4);

	/**
	 * Returns the guideline5 of this guidelines.
	 *
	 * @return the guideline5 of this guidelines
	 */
	public boolean getGuideline5();

	/**
	 * Returns <code>true</code> if this guidelines is guideline5.
	 *
	 * @return <code>true</code> if this guidelines is guideline5; <code>false</code> otherwise
	 */
	public boolean isGuideline5();

	/**
	 * Sets whether this guidelines is guideline5.
	 *
	 * @param guideline5 the guideline5 of this guidelines
	 */
	public void setGuideline5(boolean guideline5);

	/**
	 * Returns the guideline6 of this guidelines.
	 *
	 * @return the guideline6 of this guidelines
	 */
	public boolean getGuideline6();

	/**
	 * Returns <code>true</code> if this guidelines is guideline6.
	 *
	 * @return <code>true</code> if this guidelines is guideline6; <code>false</code> otherwise
	 */
	public boolean isGuideline6();

	/**
	 * Sets whether this guidelines is guideline6.
	 *
	 * @param guideline6 the guideline6 of this guidelines
	 */
	public void setGuideline6(boolean guideline6);

	/**
	 * Returns the guideline7 of this guidelines.
	 *
	 * @return the guideline7 of this guidelines
	 */
	public boolean getGuideline7();

	/**
	 * Returns <code>true</code> if this guidelines is guideline7.
	 *
	 * @return <code>true</code> if this guidelines is guideline7; <code>false</code> otherwise
	 */
	public boolean isGuideline7();

	/**
	 * Sets whether this guidelines is guideline7.
	 *
	 * @param guideline7 the guideline7 of this guidelines
	 */
	public void setGuideline7(boolean guideline7);

	/**
	 * Returns the guideline8 of this guidelines.
	 *
	 * @return the guideline8 of this guidelines
	 */
	public boolean getGuideline8();

	/**
	 * Returns <code>true</code> if this guidelines is guideline8.
	 *
	 * @return <code>true</code> if this guidelines is guideline8; <code>false</code> otherwise
	 */
	public boolean isGuideline8();

	/**
	 * Sets whether this guidelines is guideline8.
	 *
	 * @param guideline8 the guideline8 of this guidelines
	 */
	public void setGuideline8(boolean guideline8);

	/**
	 * Returns the more info of this guidelines.
	 *
	 * @return the more info of this guidelines
	 */
	@AutoEscape
	public String getMoreInfo();

	/**
	 * Sets the more info of this guidelines.
	 *
	 * @param moreInfo the more info of this guidelines
	 */
	public void setMoreInfo(String moreInfo);

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
		com.sambaash.platform.srv.startupprofile.model.Guidelines guidelines);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.startupprofile.model.Guidelines> toCacheModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Guidelines toEscapedModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Guidelines toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}