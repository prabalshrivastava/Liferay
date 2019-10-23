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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.ServiceComponentsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ServiceComponentsClp extends BaseModelImpl<ServiceComponents>
	implements ServiceComponents {
	public ServiceComponentsClp() {
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
	public long getPrimaryKey() {
		return _scId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getScId() {
		return _scId;
	}

	@Override
	public void setScId(long scId) {
		_scId = scId;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setScId", long.class);

				method.invoke(_serviceComponentsRemoteModel, scId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScgId() {
		return _scgId;
	}

	@Override
	public void setScgId(long scgId) {
		_scgId = scgId;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setScgId", long.class);

				method.invoke(_serviceComponentsRemoteModel, scgId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_serviceComponentsRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_serviceComponentsRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTechnologyComponent() {
		return _technologyComponent;
	}

	@Override
	public void setTechnologyComponent(String technologyComponent) {
		_technologyComponent = technologyComponent;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setTechnologyComponent",
						String.class);

				method.invoke(_serviceComponentsRemoteModel, technologyComponent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhase() {
		return _phase;
	}

	@Override
	public void setPhase(String phase) {
		_phase = phase;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setPhase", String.class);

				method.invoke(_serviceComponentsRemoteModel, phase);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_serviceComponentsRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_serviceComponentsRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceType() {
		return _serviceType;
	}

	@Override
	public void setServiceType(String serviceType) {
		_serviceType = serviceType;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceType", String.class);

				method.invoke(_serviceComponentsRemoteModel, serviceType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceExposureType() {
		return _ServiceExposureType;
	}

	@Override
	public void setServiceExposureType(String ServiceExposureType) {
		_ServiceExposureType = ServiceExposureType;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceExposureType",
						String.class);

				method.invoke(_serviceComponentsRemoteModel, ServiceExposureType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserType() {
		return _userType;
	}

	@Override
	public void setUserType(String userType) {
		_userType = userType;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserType", String.class);

				method.invoke(_serviceComponentsRemoteModel, userType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlatformType() {
		return _platformType;
	}

	@Override
	public void setPlatformType(String platformType) {
		_platformType = platformType;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setPlatformType", String.class);

				method.invoke(_serviceComponentsRemoteModel, platformType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIslaCarteService() {
		return _islaCarteService;
	}

	@Override
	public boolean isIslaCarteService() {
		return _islaCarteService;
	}

	@Override
	public void setIslaCarteService(boolean islaCarteService) {
		_islaCarteService = islaCarteService;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setIslaCarteService",
						boolean.class);

				method.invoke(_serviceComponentsRemoteModel, islaCarteService);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsExternal() {
		return _isExternal;
	}

	@Override
	public boolean isIsExternal() {
		return _isExternal;
	}

	@Override
	public void setIsExternal(boolean isExternal) {
		_isExternal = isExternal;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setIsExternal", boolean.class);

				method.invoke(_serviceComponentsRemoteModel, isExternal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTag() {
		return _tag;
	}

	@Override
	public void setTag(String tag) {
		_tag = tag;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setTag", String.class);

				method.invoke(_serviceComponentsRemoteModel, tag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebserviceURL() {
		return _webserviceURL;
	}

	@Override
	public void setWebserviceURL(String webserviceURL) {
		_webserviceURL = webserviceURL;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setWebserviceURL", String.class);

				method.invoke(_serviceComponentsRemoteModel, webserviceURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeploymentCluster() {
		return _deploymentCluster;
	}

	@Override
	public void setDeploymentCluster(String deploymentCluster) {
		_deploymentCluster = deploymentCluster;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDeploymentCluster",
						String.class);

				method.invoke(_serviceComponentsRemoteModel, deploymentCluster);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeploymentLocation() {
		return _deploymentLocation;
	}

	@Override
	public void setDeploymentLocation(String deploymentLocation) {
		_deploymentLocation = deploymentLocation;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDeploymentLocation",
						String.class);

				method.invoke(_serviceComponentsRemoteModel, deploymentLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChannelID() {
		return _channelID;
	}

	@Override
	public void setChannelID(String channelID) {
		_channelID = channelID;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setChannelID", String.class);

				method.invoke(_serviceComponentsRemoteModel, channelID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTestPlan() {
		return _testPlan;
	}

	@Override
	public void setTestPlan(String testPlan) {
		_testPlan = testPlan;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setTestPlan", String.class);

				method.invoke(_serviceComponentsRemoteModel, testPlan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPerformanceProfile() {
		return _performanceProfile;
	}

	@Override
	public void setPerformanceProfile(String performanceProfile) {
		_performanceProfile = performanceProfile;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerformanceProfile",
						String.class);

				method.invoke(_serviceComponentsRemoteModel, performanceProfile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUsageStatistics() {
		return _usageStatistics;
	}

	@Override
	public void setUsageStatistics(String usageStatistics) {
		_usageStatistics = usageStatistics;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUsageStatistics",
						String.class);

				method.invoke(_serviceComponentsRemoteModel, usageStatistics);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateAdded() {
		return _dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDateAdded", Date.class);

				method.invoke(_serviceComponentsRemoteModel, dateAdded);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateModified() {
		return _dateModified;
	}

	@Override
	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDateModified", Date.class);

				method.invoke(_serviceComponentsRemoteModel, dateModified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_serviceComponentsRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra1() {
		return _extra1;
	}

	@Override
	public void setExtra1(String extra1) {
		_extra1 = extra1;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_serviceComponentsRemoteModel, extra1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra2() {
		return _extra2;
	}

	@Override
	public void setExtra2(String extra2) {
		_extra2 = extra2;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_serviceComponentsRemoteModel, extra2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra3() {
		return _extra3;
	}

	@Override
	public void setExtra3(String extra3) {
		_extra3 = extra3;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_serviceComponentsRemoteModel, extra3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra4() {
		return _extra4;
	}

	@Override
	public void setExtra4(String extra4) {
		_extra4 = extra4;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_serviceComponentsRemoteModel, extra4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExtra5() {
		return _extra5;
	}

	@Override
	public void setExtra5(Date extra5) {
		_extra5 = extra5;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", Date.class);

				method.invoke(_serviceComponentsRemoteModel, extra5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExtra6() {
		return _extra6;
	}

	@Override
	public void setExtra6(Date extra6) {
		_extra6 = extra6;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra6", Date.class);

				method.invoke(_serviceComponentsRemoteModel, extra6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getServiceCharges() {
		return _serviceCharges;
	}

	@Override
	public void setServiceCharges(float serviceCharges) {
		_serviceCharges = serviceCharges;

		if (_serviceComponentsRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentsRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceCharges", float.class);

				method.invoke(_serviceComponentsRemoteModel, serviceCharges);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getServiceComponentsRemoteModel() {
		return _serviceComponentsRemoteModel;
	}

	public void setServiceComponentsRemoteModel(
		BaseModel<?> serviceComponentsRemoteModel) {
		_serviceComponentsRemoteModel = serviceComponentsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _serviceComponentsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_serviceComponentsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceComponentsLocalServiceUtil.addServiceComponents(this);
		}
		else {
			ServiceComponentsLocalServiceUtil.updateServiceComponents(this);
		}
	}

	@Override
	public ServiceComponents toEscapedModel() {
		return (ServiceComponents)ProxyUtil.newProxyInstance(ServiceComponents.class.getClassLoader(),
			new Class[] { ServiceComponents.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceComponentsClp clone = new ServiceComponentsClp();

		clone.setScId(getScId());
		clone.setScgId(getScgId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setTechnologyComponent(getTechnologyComponent());
		clone.setPhase(getPhase());
		clone.setStatus(getStatus());
		clone.setVersion(getVersion());
		clone.setServiceType(getServiceType());
		clone.setServiceExposureType(getServiceExposureType());
		clone.setUserType(getUserType());
		clone.setPlatformType(getPlatformType());
		clone.setIslaCarteService(getIslaCarteService());
		clone.setIsExternal(getIsExternal());
		clone.setTag(getTag());
		clone.setWebserviceURL(getWebserviceURL());
		clone.setDeploymentCluster(getDeploymentCluster());
		clone.setDeploymentLocation(getDeploymentLocation());
		clone.setChannelID(getChannelID());
		clone.setTestPlan(getTestPlan());
		clone.setPerformanceProfile(getPerformanceProfile());
		clone.setUsageStatistics(getUsageStatistics());
		clone.setDateAdded(getDateAdded());
		clone.setDateModified(getDateModified());
		clone.setAuthor(getAuthor());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());
		clone.setExtra3(getExtra3());
		clone.setExtra4(getExtra4());
		clone.setExtra5(getExtra5());
		clone.setExtra6(getExtra6());
		clone.setServiceCharges(getServiceCharges());

		return clone;
	}

	@Override
	public int compareTo(ServiceComponents serviceComponents) {
		int value = 0;

		if (getScgId() < serviceComponents.getScgId()) {
			value = -1;
		}
		else if (getScgId() > serviceComponents.getScgId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(serviceComponents.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceComponentsClp)) {
			return false;
		}

		ServiceComponentsClp serviceComponents = (ServiceComponentsClp)obj;

		long primaryKey = serviceComponents.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{scId=");
		sb.append(getScId());
		sb.append(", scgId=");
		sb.append(getScgId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", technologyComponent=");
		sb.append(getTechnologyComponent());
		sb.append(", phase=");
		sb.append(getPhase());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", serviceType=");
		sb.append(getServiceType());
		sb.append(", ServiceExposureType=");
		sb.append(getServiceExposureType());
		sb.append(", userType=");
		sb.append(getUserType());
		sb.append(", platformType=");
		sb.append(getPlatformType());
		sb.append(", islaCarteService=");
		sb.append(getIslaCarteService());
		sb.append(", isExternal=");
		sb.append(getIsExternal());
		sb.append(", tag=");
		sb.append(getTag());
		sb.append(", webserviceURL=");
		sb.append(getWebserviceURL());
		sb.append(", deploymentCluster=");
		sb.append(getDeploymentCluster());
		sb.append(", deploymentLocation=");
		sb.append(getDeploymentLocation());
		sb.append(", channelID=");
		sb.append(getChannelID());
		sb.append(", testPlan=");
		sb.append(getTestPlan());
		sb.append(", performanceProfile=");
		sb.append(getPerformanceProfile());
		sb.append(", usageStatistics=");
		sb.append(getUsageStatistics());
		sb.append(", dateAdded=");
		sb.append(getDateAdded());
		sb.append(", dateModified=");
		sb.append(getDateModified());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", extra1=");
		sb.append(getExtra1());
		sb.append(", extra2=");
		sb.append(getExtra2());
		sb.append(", extra3=");
		sb.append(getExtra3());
		sb.append(", extra4=");
		sb.append(getExtra4());
		sb.append(", extra5=");
		sb.append(getExtra5());
		sb.append(", extra6=");
		sb.append(getExtra6());
		sb.append(", serviceCharges=");
		sb.append(getServiceCharges());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(100);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.ServiceComponents");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scId</column-name><column-value><![CDATA[");
		sb.append(getScId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scgId</column-name><column-value><![CDATA[");
		sb.append(getScgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>technologyComponent</column-name><column-value><![CDATA[");
		sb.append(getTechnologyComponent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phase</column-name><column-value><![CDATA[");
		sb.append(getPhase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceType</column-name><column-value><![CDATA[");
		sb.append(getServiceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ServiceExposureType</column-name><column-value><![CDATA[");
		sb.append(getServiceExposureType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userType</column-name><column-value><![CDATA[");
		sb.append(getUserType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>platformType</column-name><column-value><![CDATA[");
		sb.append(getPlatformType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>islaCarteService</column-name><column-value><![CDATA[");
		sb.append(getIslaCarteService());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isExternal</column-name><column-value><![CDATA[");
		sb.append(getIsExternal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webserviceURL</column-name><column-value><![CDATA[");
		sb.append(getWebserviceURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deploymentCluster</column-name><column-value><![CDATA[");
		sb.append(getDeploymentCluster());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deploymentLocation</column-name><column-value><![CDATA[");
		sb.append(getDeploymentLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>channelID</column-name><column-value><![CDATA[");
		sb.append(getChannelID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testPlan</column-name><column-value><![CDATA[");
		sb.append(getTestPlan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>performanceProfile</column-name><column-value><![CDATA[");
		sb.append(getPerformanceProfile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usageStatistics</column-name><column-value><![CDATA[");
		sb.append(getUsageStatistics());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateAdded</column-name><column-value><![CDATA[");
		sb.append(getDateAdded());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateModified</column-name><column-value><![CDATA[");
		sb.append(getDateModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra1</column-name><column-value><![CDATA[");
		sb.append(getExtra1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra2</column-name><column-value><![CDATA[");
		sb.append(getExtra2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra3</column-name><column-value><![CDATA[");
		sb.append(getExtra3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra4</column-name><column-value><![CDATA[");
		sb.append(getExtra4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra5</column-name><column-value><![CDATA[");
		sb.append(getExtra5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra6</column-name><column-value><![CDATA[");
		sb.append(getExtra6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceCharges</column-name><column-value><![CDATA[");
		sb.append(getServiceCharges());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scId;
	private long _scgId;
	private String _name;
	private String _description;
	private String _technologyComponent;
	private String _phase;
	private String _status;
	private String _version;
	private String _serviceType;
	private String _ServiceExposureType;
	private String _userType;
	private String _platformType;
	private boolean _islaCarteService;
	private boolean _isExternal;
	private String _tag;
	private String _webserviceURL;
	private String _deploymentCluster;
	private String _deploymentLocation;
	private String _channelID;
	private String _testPlan;
	private String _performanceProfile;
	private String _usageStatistics;
	private Date _dateAdded;
	private Date _dateModified;
	private String _author;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
	private float _serviceCharges;
	private BaseModel<?> _serviceComponentsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}