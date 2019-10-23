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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ServiceComponentGroup service. Represents a row in the &quot;SPServiceComponentGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentGroup
 * @see com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupImpl
 * @see com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl
 * @generated
 */
public interface ServiceComponentGroupModel extends BaseModel<ServiceComponentGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a service component group model instance should use the {@link ServiceComponentGroup} interface instead.
	 */

	/**
	 * Returns the primary key of this service component group.
	 *
	 * @return the primary key of this service component group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this service component group.
	 *
	 * @param primaryKey the primary key of this service component group
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the scg ID of this service component group.
	 *
	 * @return the scg ID of this service component group
	 */
	public long getScgId();

	/**
	 * Sets the scg ID of this service component group.
	 *
	 * @param scgId the scg ID of this service component group
	 */
	public void setScgId(long scgId);

	/**
	 * Returns the name of this service component group.
	 *
	 * @return the name of this service component group
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this service component group.
	 *
	 * @param name the name of this service component group
	 */
	public void setName(String name);

	/**
	 * Returns the description of this service component group.
	 *
	 * @return the description of this service component group
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this service component group.
	 *
	 * @param description the description of this service component group
	 */
	public void setDescription(String description);

	/**
	 * Returns the phase of this service component group.
	 *
	 * @return the phase of this service component group
	 */
	@AutoEscape
	public String getPhase();

	/**
	 * Sets the phase of this service component group.
	 *
	 * @param phase the phase of this service component group
	 */
	public void setPhase(String phase);

	/**
	 * Returns the status of this service component group.
	 *
	 * @return the status of this service component group
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this service component group.
	 *
	 * @param status the status of this service component group
	 */
	public void setStatus(String status);

	/**
	 * Returns the version of this service component group.
	 *
	 * @return the version of this service component group
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this service component group.
	 *
	 * @param version the version of this service component group
	 */
	public void setVersion(String version);

	/**
	 * Returns the deployment cluster of this service component group.
	 *
	 * @return the deployment cluster of this service component group
	 */
	@AutoEscape
	public String getDeploymentCluster();

	/**
	 * Sets the deployment cluster of this service component group.
	 *
	 * @param deploymentCluster the deployment cluster of this service component group
	 */
	public void setDeploymentCluster(String deploymentCluster);

	/**
	 * Returns the community of this service component group.
	 *
	 * @return the community of this service component group
	 */
	@AutoEscape
	public String getCommunity();

	/**
	 * Sets the community of this service component group.
	 *
	 * @param community the community of this service component group
	 */
	public void setCommunity(String community);

	/**
	 * Returns the date added of this service component group.
	 *
	 * @return the date added of this service component group
	 */
	public Date getDateAdded();

	/**
	 * Sets the date added of this service component group.
	 *
	 * @param dateAdded the date added of this service component group
	 */
	public void setDateAdded(Date dateAdded);

	/**
	 * Returns the date modified of this service component group.
	 *
	 * @return the date modified of this service component group
	 */
	public Date getDateModified();

	/**
	 * Sets the date modified of this service component group.
	 *
	 * @param dateModified the date modified of this service component group
	 */
	public void setDateModified(Date dateModified);

	/**
	 * Returns the author of this service component group.
	 *
	 * @return the author of this service component group
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this service component group.
	 *
	 * @param author the author of this service component group
	 */
	public void setAuthor(String author);

	/**
	 * Returns the extra1 of this service component group.
	 *
	 * @return the extra1 of this service component group
	 */
	@AutoEscape
	public String getExtra1();

	/**
	 * Sets the extra1 of this service component group.
	 *
	 * @param extra1 the extra1 of this service component group
	 */
	public void setExtra1(String extra1);

	/**
	 * Returns the extra2 of this service component group.
	 *
	 * @return the extra2 of this service component group
	 */
	@AutoEscape
	public String getExtra2();

	/**
	 * Sets the extra2 of this service component group.
	 *
	 * @param extra2 the extra2 of this service component group
	 */
	public void setExtra2(String extra2);

	/**
	 * Returns the extra3 of this service component group.
	 *
	 * @return the extra3 of this service component group
	 */
	@AutoEscape
	public String getExtra3();

	/**
	 * Sets the extra3 of this service component group.
	 *
	 * @param extra3 the extra3 of this service component group
	 */
	public void setExtra3(String extra3);

	/**
	 * Returns the extra4 of this service component group.
	 *
	 * @return the extra4 of this service component group
	 */
	@AutoEscape
	public String getExtra4();

	/**
	 * Sets the extra4 of this service component group.
	 *
	 * @param extra4 the extra4 of this service component group
	 */
	public void setExtra4(String extra4);

	/**
	 * Returns the extra5 of this service component group.
	 *
	 * @return the extra5 of this service component group
	 */
	public Date getExtra5();

	/**
	 * Sets the extra5 of this service component group.
	 *
	 * @param extra5 the extra5 of this service component group
	 */
	public void setExtra5(Date extra5);

	/**
	 * Returns the extra6 of this service component group.
	 *
	 * @return the extra6 of this service component group
	 */
	public Date getExtra6();

	/**
	 * Sets the extra6 of this service component group.
	 *
	 * @param extra6 the extra6 of this service component group
	 */
	public void setExtra6(Date extra6);

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
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}