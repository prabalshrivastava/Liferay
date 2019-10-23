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
 * This class is a wrapper for {@link ServiceComponents}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponents
 * @generated
 */
public class ServiceComponentsWrapper implements ServiceComponents,
	ModelWrapper<ServiceComponents> {
	public ServiceComponentsWrapper(ServiceComponents serviceComponents) {
		_serviceComponents = serviceComponents;
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceComponents.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceComponents.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scId", getScId());
		attributes.put("scgId", getScgId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("technologyComponent", getTechnologyComponent());
		attributes.put("phase", getPhase());
		attributes.put("status", getStatus());
		attributes.put("version", getVersion());
		attributes.put("serviceType", getServiceType());
		attributes.put("ServiceExposureType", getServiceExposureType());
		attributes.put("userType", getUserType());
		attributes.put("platformType", getPlatformType());
		attributes.put("islaCarteService", getIslaCarteService());
		attributes.put("isExternal", getIsExternal());
		attributes.put("tag", getTag());
		attributes.put("webserviceURL", getWebserviceURL());
		attributes.put("deploymentCluster", getDeploymentCluster());
		attributes.put("deploymentLocation", getDeploymentLocation());
		attributes.put("channelID", getChannelID());
		attributes.put("testPlan", getTestPlan());
		attributes.put("performanceProfile", getPerformanceProfile());
		attributes.put("usageStatistics", getUsageStatistics());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("author", getAuthor());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());
		attributes.put("serviceCharges", getServiceCharges());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scId = (Long)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
		}

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

		String technologyComponent = (String)attributes.get(
				"technologyComponent");

		if (technologyComponent != null) {
			setTechnologyComponent(technologyComponent);
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

		String serviceType = (String)attributes.get("serviceType");

		if (serviceType != null) {
			setServiceType(serviceType);
		}

		String ServiceExposureType = (String)attributes.get(
				"ServiceExposureType");

		if (ServiceExposureType != null) {
			setServiceExposureType(ServiceExposureType);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		String platformType = (String)attributes.get("platformType");

		if (platformType != null) {
			setPlatformType(platformType);
		}

		Boolean islaCarteService = (Boolean)attributes.get("islaCarteService");

		if (islaCarteService != null) {
			setIslaCarteService(islaCarteService);
		}

		Boolean isExternal = (Boolean)attributes.get("isExternal");

		if (isExternal != null) {
			setIsExternal(isExternal);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		String webserviceURL = (String)attributes.get("webserviceURL");

		if (webserviceURL != null) {
			setWebserviceURL(webserviceURL);
		}

		String deploymentCluster = (String)attributes.get("deploymentCluster");

		if (deploymentCluster != null) {
			setDeploymentCluster(deploymentCluster);
		}

		String deploymentLocation = (String)attributes.get("deploymentLocation");

		if (deploymentLocation != null) {
			setDeploymentLocation(deploymentLocation);
		}

		String channelID = (String)attributes.get("channelID");

		if (channelID != null) {
			setChannelID(channelID);
		}

		String testPlan = (String)attributes.get("testPlan");

		if (testPlan != null) {
			setTestPlan(testPlan);
		}

		String performanceProfile = (String)attributes.get("performanceProfile");

		if (performanceProfile != null) {
			setPerformanceProfile(performanceProfile);
		}

		String usageStatistics = (String)attributes.get("usageStatistics");

		if (usageStatistics != null) {
			setUsageStatistics(usageStatistics);
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

		Float serviceCharges = (Float)attributes.get("serviceCharges");

		if (serviceCharges != null) {
			setServiceCharges(serviceCharges);
		}
	}

	/**
	* Returns the primary key of this service components.
	*
	* @return the primary key of this service components
	*/
	@Override
	public long getPrimaryKey() {
		return _serviceComponents.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service components.
	*
	* @param primaryKey the primary key of this service components
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_serviceComponents.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sc ID of this service components.
	*
	* @return the sc ID of this service components
	*/
	@Override
	public long getScId() {
		return _serviceComponents.getScId();
	}

	/**
	* Sets the sc ID of this service components.
	*
	* @param scId the sc ID of this service components
	*/
	@Override
	public void setScId(long scId) {
		_serviceComponents.setScId(scId);
	}

	/**
	* Returns the scg ID of this service components.
	*
	* @return the scg ID of this service components
	*/
	@Override
	public long getScgId() {
		return _serviceComponents.getScgId();
	}

	/**
	* Sets the scg ID of this service components.
	*
	* @param scgId the scg ID of this service components
	*/
	@Override
	public void setScgId(long scgId) {
		_serviceComponents.setScgId(scgId);
	}

	/**
	* Returns the name of this service components.
	*
	* @return the name of this service components
	*/
	@Override
	public java.lang.String getName() {
		return _serviceComponents.getName();
	}

	/**
	* Sets the name of this service components.
	*
	* @param name the name of this service components
	*/
	@Override
	public void setName(java.lang.String name) {
		_serviceComponents.setName(name);
	}

	/**
	* Returns the description of this service components.
	*
	* @return the description of this service components
	*/
	@Override
	public java.lang.String getDescription() {
		return _serviceComponents.getDescription();
	}

	/**
	* Sets the description of this service components.
	*
	* @param description the description of this service components
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_serviceComponents.setDescription(description);
	}

	/**
	* Returns the technology component of this service components.
	*
	* @return the technology component of this service components
	*/
	@Override
	public java.lang.String getTechnologyComponent() {
		return _serviceComponents.getTechnologyComponent();
	}

	/**
	* Sets the technology component of this service components.
	*
	* @param technologyComponent the technology component of this service components
	*/
	@Override
	public void setTechnologyComponent(java.lang.String technologyComponent) {
		_serviceComponents.setTechnologyComponent(technologyComponent);
	}

	/**
	* Returns the phase of this service components.
	*
	* @return the phase of this service components
	*/
	@Override
	public java.lang.String getPhase() {
		return _serviceComponents.getPhase();
	}

	/**
	* Sets the phase of this service components.
	*
	* @param phase the phase of this service components
	*/
	@Override
	public void setPhase(java.lang.String phase) {
		_serviceComponents.setPhase(phase);
	}

	/**
	* Returns the status of this service components.
	*
	* @return the status of this service components
	*/
	@Override
	public java.lang.String getStatus() {
		return _serviceComponents.getStatus();
	}

	/**
	* Sets the status of this service components.
	*
	* @param status the status of this service components
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_serviceComponents.setStatus(status);
	}

	/**
	* Returns the version of this service components.
	*
	* @return the version of this service components
	*/
	@Override
	public java.lang.String getVersion() {
		return _serviceComponents.getVersion();
	}

	/**
	* Sets the version of this service components.
	*
	* @param version the version of this service components
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_serviceComponents.setVersion(version);
	}

	/**
	* Returns the service type of this service components.
	*
	* @return the service type of this service components
	*/
	@Override
	public java.lang.String getServiceType() {
		return _serviceComponents.getServiceType();
	}

	/**
	* Sets the service type of this service components.
	*
	* @param serviceType the service type of this service components
	*/
	@Override
	public void setServiceType(java.lang.String serviceType) {
		_serviceComponents.setServiceType(serviceType);
	}

	/**
	* Returns the service exposure type of this service components.
	*
	* @return the service exposure type of this service components
	*/
	@Override
	public java.lang.String getServiceExposureType() {
		return _serviceComponents.getServiceExposureType();
	}

	/**
	* Sets the service exposure type of this service components.
	*
	* @param ServiceExposureType the service exposure type of this service components
	*/
	@Override
	public void setServiceExposureType(java.lang.String ServiceExposureType) {
		_serviceComponents.setServiceExposureType(ServiceExposureType);
	}

	/**
	* Returns the user type of this service components.
	*
	* @return the user type of this service components
	*/
	@Override
	public java.lang.String getUserType() {
		return _serviceComponents.getUserType();
	}

	/**
	* Sets the user type of this service components.
	*
	* @param userType the user type of this service components
	*/
	@Override
	public void setUserType(java.lang.String userType) {
		_serviceComponents.setUserType(userType);
	}

	/**
	* Returns the platform type of this service components.
	*
	* @return the platform type of this service components
	*/
	@Override
	public java.lang.String getPlatformType() {
		return _serviceComponents.getPlatformType();
	}

	/**
	* Sets the platform type of this service components.
	*
	* @param platformType the platform type of this service components
	*/
	@Override
	public void setPlatformType(java.lang.String platformType) {
		_serviceComponents.setPlatformType(platformType);
	}

	/**
	* Returns the isla carte service of this service components.
	*
	* @return the isla carte service of this service components
	*/
	@Override
	public boolean getIslaCarteService() {
		return _serviceComponents.getIslaCarteService();
	}

	/**
	* Returns <code>true</code> if this service components is isla carte service.
	*
	* @return <code>true</code> if this service components is isla carte service; <code>false</code> otherwise
	*/
	@Override
	public boolean isIslaCarteService() {
		return _serviceComponents.isIslaCarteService();
	}

	/**
	* Sets whether this service components is isla carte service.
	*
	* @param islaCarteService the isla carte service of this service components
	*/
	@Override
	public void setIslaCarteService(boolean islaCarteService) {
		_serviceComponents.setIslaCarteService(islaCarteService);
	}

	/**
	* Returns the is external of this service components.
	*
	* @return the is external of this service components
	*/
	@Override
	public boolean getIsExternal() {
		return _serviceComponents.getIsExternal();
	}

	/**
	* Returns <code>true</code> if this service components is is external.
	*
	* @return <code>true</code> if this service components is is external; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsExternal() {
		return _serviceComponents.isIsExternal();
	}

	/**
	* Sets whether this service components is is external.
	*
	* @param isExternal the is external of this service components
	*/
	@Override
	public void setIsExternal(boolean isExternal) {
		_serviceComponents.setIsExternal(isExternal);
	}

	/**
	* Returns the tag of this service components.
	*
	* @return the tag of this service components
	*/
	@Override
	public java.lang.String getTag() {
		return _serviceComponents.getTag();
	}

	/**
	* Sets the tag of this service components.
	*
	* @param tag the tag of this service components
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_serviceComponents.setTag(tag);
	}

	/**
	* Returns the webservice u r l of this service components.
	*
	* @return the webservice u r l of this service components
	*/
	@Override
	public java.lang.String getWebserviceURL() {
		return _serviceComponents.getWebserviceURL();
	}

	/**
	* Sets the webservice u r l of this service components.
	*
	* @param webserviceURL the webservice u r l of this service components
	*/
	@Override
	public void setWebserviceURL(java.lang.String webserviceURL) {
		_serviceComponents.setWebserviceURL(webserviceURL);
	}

	/**
	* Returns the deployment cluster of this service components.
	*
	* @return the deployment cluster of this service components
	*/
	@Override
	public java.lang.String getDeploymentCluster() {
		return _serviceComponents.getDeploymentCluster();
	}

	/**
	* Sets the deployment cluster of this service components.
	*
	* @param deploymentCluster the deployment cluster of this service components
	*/
	@Override
	public void setDeploymentCluster(java.lang.String deploymentCluster) {
		_serviceComponents.setDeploymentCluster(deploymentCluster);
	}

	/**
	* Returns the deployment location of this service components.
	*
	* @return the deployment location of this service components
	*/
	@Override
	public java.lang.String getDeploymentLocation() {
		return _serviceComponents.getDeploymentLocation();
	}

	/**
	* Sets the deployment location of this service components.
	*
	* @param deploymentLocation the deployment location of this service components
	*/
	@Override
	public void setDeploymentLocation(java.lang.String deploymentLocation) {
		_serviceComponents.setDeploymentLocation(deploymentLocation);
	}

	/**
	* Returns the channel i d of this service components.
	*
	* @return the channel i d of this service components
	*/
	@Override
	public java.lang.String getChannelID() {
		return _serviceComponents.getChannelID();
	}

	/**
	* Sets the channel i d of this service components.
	*
	* @param channelID the channel i d of this service components
	*/
	@Override
	public void setChannelID(java.lang.String channelID) {
		_serviceComponents.setChannelID(channelID);
	}

	/**
	* Returns the test plan of this service components.
	*
	* @return the test plan of this service components
	*/
	@Override
	public java.lang.String getTestPlan() {
		return _serviceComponents.getTestPlan();
	}

	/**
	* Sets the test plan of this service components.
	*
	* @param testPlan the test plan of this service components
	*/
	@Override
	public void setTestPlan(java.lang.String testPlan) {
		_serviceComponents.setTestPlan(testPlan);
	}

	/**
	* Returns the performance profile of this service components.
	*
	* @return the performance profile of this service components
	*/
	@Override
	public java.lang.String getPerformanceProfile() {
		return _serviceComponents.getPerformanceProfile();
	}

	/**
	* Sets the performance profile of this service components.
	*
	* @param performanceProfile the performance profile of this service components
	*/
	@Override
	public void setPerformanceProfile(java.lang.String performanceProfile) {
		_serviceComponents.setPerformanceProfile(performanceProfile);
	}

	/**
	* Returns the usage statistics of this service components.
	*
	* @return the usage statistics of this service components
	*/
	@Override
	public java.lang.String getUsageStatistics() {
		return _serviceComponents.getUsageStatistics();
	}

	/**
	* Sets the usage statistics of this service components.
	*
	* @param usageStatistics the usage statistics of this service components
	*/
	@Override
	public void setUsageStatistics(java.lang.String usageStatistics) {
		_serviceComponents.setUsageStatistics(usageStatistics);
	}

	/**
	* Returns the date added of this service components.
	*
	* @return the date added of this service components
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _serviceComponents.getDateAdded();
	}

	/**
	* Sets the date added of this service components.
	*
	* @param dateAdded the date added of this service components
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_serviceComponents.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this service components.
	*
	* @return the date modified of this service components
	*/
	@Override
	public java.util.Date getDateModified() {
		return _serviceComponents.getDateModified();
	}

	/**
	* Sets the date modified of this service components.
	*
	* @param dateModified the date modified of this service components
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_serviceComponents.setDateModified(dateModified);
	}

	/**
	* Returns the author of this service components.
	*
	* @return the author of this service components
	*/
	@Override
	public java.lang.String getAuthor() {
		return _serviceComponents.getAuthor();
	}

	/**
	* Sets the author of this service components.
	*
	* @param author the author of this service components
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_serviceComponents.setAuthor(author);
	}

	/**
	* Returns the extra1 of this service components.
	*
	* @return the extra1 of this service components
	*/
	@Override
	public java.lang.String getExtra1() {
		return _serviceComponents.getExtra1();
	}

	/**
	* Sets the extra1 of this service components.
	*
	* @param extra1 the extra1 of this service components
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_serviceComponents.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this service components.
	*
	* @return the extra2 of this service components
	*/
	@Override
	public java.lang.String getExtra2() {
		return _serviceComponents.getExtra2();
	}

	/**
	* Sets the extra2 of this service components.
	*
	* @param extra2 the extra2 of this service components
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_serviceComponents.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this service components.
	*
	* @return the extra3 of this service components
	*/
	@Override
	public java.lang.String getExtra3() {
		return _serviceComponents.getExtra3();
	}

	/**
	* Sets the extra3 of this service components.
	*
	* @param extra3 the extra3 of this service components
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_serviceComponents.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this service components.
	*
	* @return the extra4 of this service components
	*/
	@Override
	public java.lang.String getExtra4() {
		return _serviceComponents.getExtra4();
	}

	/**
	* Sets the extra4 of this service components.
	*
	* @param extra4 the extra4 of this service components
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_serviceComponents.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this service components.
	*
	* @return the extra5 of this service components
	*/
	@Override
	public java.util.Date getExtra5() {
		return _serviceComponents.getExtra5();
	}

	/**
	* Sets the extra5 of this service components.
	*
	* @param extra5 the extra5 of this service components
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_serviceComponents.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this service components.
	*
	* @return the extra6 of this service components
	*/
	@Override
	public java.util.Date getExtra6() {
		return _serviceComponents.getExtra6();
	}

	/**
	* Sets the extra6 of this service components.
	*
	* @param extra6 the extra6 of this service components
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_serviceComponents.setExtra6(extra6);
	}

	/**
	* Returns the service charges of this service components.
	*
	* @return the service charges of this service components
	*/
	@Override
	public float getServiceCharges() {
		return _serviceComponents.getServiceCharges();
	}

	/**
	* Sets the service charges of this service components.
	*
	* @param serviceCharges the service charges of this service components
	*/
	@Override
	public void setServiceCharges(float serviceCharges) {
		_serviceComponents.setServiceCharges(serviceCharges);
	}

	@Override
	public boolean isNew() {
		return _serviceComponents.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceComponents.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceComponents.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceComponents.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceComponents.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceComponents.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceComponents.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceComponents.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceComponents.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceComponents.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceComponents.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceComponentsWrapper((ServiceComponents)_serviceComponents.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents) {
		return _serviceComponents.compareTo(serviceComponents);
	}

	@Override
	public int hashCode() {
		return _serviceComponents.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.ServiceComponents> toCacheModel() {
		return _serviceComponents.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents toEscapedModel() {
		return new ServiceComponentsWrapper(_serviceComponents.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents toUnescapedModel() {
		return new ServiceComponentsWrapper(_serviceComponents.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceComponents.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceComponents.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceComponents.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceComponentsWrapper)) {
			return false;
		}

		ServiceComponentsWrapper serviceComponentsWrapper = (ServiceComponentsWrapper)obj;

		if (Validator.equals(_serviceComponents,
					serviceComponentsWrapper._serviceComponents)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceComponents getWrappedServiceComponents() {
		return _serviceComponents;
	}

	@Override
	public ServiceComponents getWrappedModel() {
		return _serviceComponents;
	}

	@Override
	public void resetOriginalValues() {
		_serviceComponents.resetOriginalValues();
	}

	private ServiceComponents _serviceComponents;
}