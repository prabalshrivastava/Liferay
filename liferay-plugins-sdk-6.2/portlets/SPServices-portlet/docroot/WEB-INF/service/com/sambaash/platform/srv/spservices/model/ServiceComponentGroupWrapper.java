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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceComponentGroup}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentGroup
 * @generated
 */
public class ServiceComponentGroupWrapper implements ServiceComponentGroup,
	ModelWrapper<ServiceComponentGroup> {
	public ServiceComponentGroupWrapper(
		ServiceComponentGroup serviceComponentGroup) {
		_serviceComponentGroup = serviceComponentGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceComponentGroup.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceComponentGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scgId", getScgId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("phase", getPhase());
		attributes.put("status", getStatus());
		attributes.put("version", getVersion());
		attributes.put("deploymentCluster", getDeploymentCluster());
		attributes.put("community", getCommunity());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("author", getAuthor());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scgId = (Long)attributes.get("scgId");

		if (scgId != null) {
			setScgId(scgId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String phase = (String)attributes.get("phase");

		if (phase != null) {
			setPhase(phase);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String deploymentCluster = (String)attributes.get("deploymentCluster");

		if (deploymentCluster != null) {
			setDeploymentCluster(deploymentCluster);
		}

		String community = (String)attributes.get("community");

		if (community != null) {
			setCommunity(community);
		}

		Date dateAdded = (Date)attributes.get("dateAdded");

		if (dateAdded != null) {
			setDateAdded(dateAdded);
		}

		Date dateModified = (Date)attributes.get("dateModified");

		if (dateModified != null) {
			setDateModified(dateModified);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		Date extra5 = (Date)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		Date extra6 = (Date)attributes.get("extra6");

		if (extra6 != null) {
			setExtra6(extra6);
		}
	}

	/**
	* Returns the primary key of this service component group.
	*
	* @return the primary key of this service component group
	*/
	@Override
	public long getPrimaryKey() {
		return _serviceComponentGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service component group.
	*
	* @param primaryKey the primary key of this service component group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_serviceComponentGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the scg ID of this service component group.
	*
	* @return the scg ID of this service component group
	*/
	@Override
	public long getScgId() {
		return _serviceComponentGroup.getScgId();
	}

	/**
	* Sets the scg ID of this service component group.
	*
	* @param scgId the scg ID of this service component group
	*/
	@Override
	public void setScgId(long scgId) {
		_serviceComponentGroup.setScgId(scgId);
	}

	/**
	* Returns the name of this service component group.
	*
	* @return the name of this service component group
	*/
	@Override
	public java.lang.String getName() {
		return _serviceComponentGroup.getName();
	}

	/**
	* Sets the name of this service component group.
	*
	* @param name the name of this service component group
	*/
	@Override
	public void setName(java.lang.String name) {
		_serviceComponentGroup.setName(name);
	}

	/**
	* Returns the description of this service component group.
	*
	* @return the description of this service component group
	*/
	@Override
	public java.lang.String getDescription() {
		return _serviceComponentGroup.getDescription();
	}

	/**
	* Sets the description of this service component group.
	*
	* @param description the description of this service component group
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_serviceComponentGroup.setDescription(description);
	}

	/**
	* Returns the phase of this service component group.
	*
	* @return the phase of this service component group
	*/
	@Override
	public java.lang.String getPhase() {
		return _serviceComponentGroup.getPhase();
	}

	/**
	* Sets the phase of this service component group.
	*
	* @param phase the phase of this service component group
	*/
	@Override
	public void setPhase(java.lang.String phase) {
		_serviceComponentGroup.setPhase(phase);
	}

	/**
	* Returns the status of this service component group.
	*
	* @return the status of this service component group
	*/
	@Override
	public java.lang.String getStatus() {
		return _serviceComponentGroup.getStatus();
	}

	/**
	* Sets the status of this service component group.
	*
	* @param status the status of this service component group
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_serviceComponentGroup.setStatus(status);
	}

	/**
	* Returns the version of this service component group.
	*
	* @return the version of this service component group
	*/
	@Override
	public java.lang.String getVersion() {
		return _serviceComponentGroup.getVersion();
	}

	/**
	* Sets the version of this service component group.
	*
	* @param version the version of this service component group
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_serviceComponentGroup.setVersion(version);
	}

	/**
	* Returns the deployment cluster of this service component group.
	*
	* @return the deployment cluster of this service component group
	*/
	@Override
	public java.lang.String getDeploymentCluster() {
		return _serviceComponentGroup.getDeploymentCluster();
	}

	/**
	* Sets the deployment cluster of this service component group.
	*
	* @param deploymentCluster the deployment cluster of this service component group
	*/
	@Override
	public void setDeploymentCluster(java.lang.String deploymentCluster) {
		_serviceComponentGroup.setDeploymentCluster(deploymentCluster);
	}

	/**
	* Returns the community of this service component group.
	*
	* @return the community of this service component group
	*/
	@Override
	public java.lang.String getCommunity() {
		return _serviceComponentGroup.getCommunity();
	}

	/**
	* Sets the community of this service component group.
	*
	* @param community the community of this service component group
	*/
	@Override
	public void setCommunity(java.lang.String community) {
		_serviceComponentGroup.setCommunity(community);
	}

	/**
	* Returns the date added of this service component group.
	*
	* @return the date added of this service component group
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _serviceComponentGroup.getDateAdded();
	}

	/**
	* Sets the date added of this service component group.
	*
	* @param dateAdded the date added of this service component group
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_serviceComponentGroup.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this service component group.
	*
	* @return the date modified of this service component group
	*/
	@Override
	public java.util.Date getDateModified() {
		return _serviceComponentGroup.getDateModified();
	}

	/**
	* Sets the date modified of this service component group.
	*
	* @param dateModified the date modified of this service component group
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_serviceComponentGroup.setDateModified(dateModified);
	}

	/**
	* Returns the author of this service component group.
	*
	* @return the author of this service component group
	*/
	@Override
	public java.lang.String getAuthor() {
		return _serviceComponentGroup.getAuthor();
	}

	/**
	* Sets the author of this service component group.
	*
	* @param author the author of this service component group
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_serviceComponentGroup.setAuthor(author);
	}

	/**
	* Returns the extra1 of this service component group.
	*
	* @return the extra1 of this service component group
	*/
	@Override
	public java.lang.String getExtra1() {
		return _serviceComponentGroup.getExtra1();
	}

	/**
	* Sets the extra1 of this service component group.
	*
	* @param extra1 the extra1 of this service component group
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_serviceComponentGroup.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this service component group.
	*
	* @return the extra2 of this service component group
	*/
	@Override
	public java.lang.String getExtra2() {
		return _serviceComponentGroup.getExtra2();
	}

	/**
	* Sets the extra2 of this service component group.
	*
	* @param extra2 the extra2 of this service component group
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_serviceComponentGroup.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this service component group.
	*
	* @return the extra3 of this service component group
	*/
	@Override
	public java.lang.String getExtra3() {
		return _serviceComponentGroup.getExtra3();
	}

	/**
	* Sets the extra3 of this service component group.
	*
	* @param extra3 the extra3 of this service component group
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_serviceComponentGroup.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this service component group.
	*
	* @return the extra4 of this service component group
	*/
	@Override
	public java.lang.String getExtra4() {
		return _serviceComponentGroup.getExtra4();
	}

	/**
	* Sets the extra4 of this service component group.
	*
	* @param extra4 the extra4 of this service component group
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_serviceComponentGroup.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this service component group.
	*
	* @return the extra5 of this service component group
	*/
	@Override
	public java.util.Date getExtra5() {
		return _serviceComponentGroup.getExtra5();
	}

	/**
	* Sets the extra5 of this service component group.
	*
	* @param extra5 the extra5 of this service component group
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_serviceComponentGroup.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this service component group.
	*
	* @return the extra6 of this service component group
	*/
	@Override
	public java.util.Date getExtra6() {
		return _serviceComponentGroup.getExtra6();
	}

	/**
	* Sets the extra6 of this service component group.
	*
	* @param extra6 the extra6 of this service component group
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_serviceComponentGroup.setExtra6(extra6);
	}

	@Override
	public boolean isNew() {
		return _serviceComponentGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceComponentGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceComponentGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceComponentGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceComponentGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceComponentGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceComponentGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceComponentGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceComponentGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceComponentGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceComponentGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceComponentGroupWrapper((ServiceComponentGroup)_serviceComponentGroup.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup) {
		return _serviceComponentGroup.compareTo(serviceComponentGroup);
	}

	@Override
	public int hashCode() {
		return _serviceComponentGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> toCacheModel() {
		return _serviceComponentGroup.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup toEscapedModel() {
		return new ServiceComponentGroupWrapper(_serviceComponentGroup.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup toUnescapedModel() {
		return new ServiceComponentGroupWrapper(_serviceComponentGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceComponentGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceComponentGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceComponentGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceComponentGroupWrapper)) {
			return false;
		}

		ServiceComponentGroupWrapper serviceComponentGroupWrapper = (ServiceComponentGroupWrapper)obj;

		if (Validator.equals(_serviceComponentGroup,
					serviceComponentGroupWrapper._serviceComponentGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceComponentGroup getWrappedServiceComponentGroup() {
		return _serviceComponentGroup;
	}

	@Override
	public ServiceComponentGroup getWrappedModel() {
		return _serviceComponentGroup;
	}

	@Override
	public void resetOriginalValues() {
		_serviceComponentGroup.resetOriginalValues();
	}

	private ServiceComponentGroup _serviceComponentGroup;
}