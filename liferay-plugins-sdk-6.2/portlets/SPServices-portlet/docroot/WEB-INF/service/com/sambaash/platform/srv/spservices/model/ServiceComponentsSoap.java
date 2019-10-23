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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class ServiceComponentsSoap implements Serializable {
	public static ServiceComponentsSoap toSoapModel(ServiceComponents model) {
		ServiceComponentsSoap soapModel = new ServiceComponentsSoap();

		soapModel.setScId(model.getScId());
		soapModel.setScgId(model.getScgId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setTechnologyComponent(model.getTechnologyComponent());
		soapModel.setPhase(model.getPhase());
		soapModel.setStatus(model.getStatus());
		soapModel.setVersion(model.getVersion());
		soapModel.setServiceType(model.getServiceType());
		soapModel.setServiceExposureType(model.getServiceExposureType());
		soapModel.setUserType(model.getUserType());
		soapModel.setPlatformType(model.getPlatformType());
		soapModel.setIslaCarteService(model.getIslaCarteService());
		soapModel.setIsExternal(model.getIsExternal());
		soapModel.setTag(model.getTag());
		soapModel.setWebserviceURL(model.getWebserviceURL());
		soapModel.setDeploymentCluster(model.getDeploymentCluster());
		soapModel.setDeploymentLocation(model.getDeploymentLocation());
		soapModel.setChannelID(model.getChannelID());
		soapModel.setTestPlan(model.getTestPlan());
		soapModel.setPerformanceProfile(model.getPerformanceProfile());
		soapModel.setUsageStatistics(model.getUsageStatistics());
		soapModel.setDateAdded(model.getDateAdded());
		soapModel.setDateModified(model.getDateModified());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());
		soapModel.setExtra6(model.getExtra6());
		soapModel.setServiceCharges(model.getServiceCharges());

		return soapModel;
	}

	public static ServiceComponentsSoap[] toSoapModels(
		ServiceComponents[] models) {
		ServiceComponentsSoap[] soapModels = new ServiceComponentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceComponentsSoap[][] toSoapModels(
		ServiceComponents[][] models) {
		ServiceComponentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceComponentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceComponentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceComponentsSoap[] toSoapModels(
		List<ServiceComponents> models) {
		List<ServiceComponentsSoap> soapModels = new ArrayList<ServiceComponentsSoap>(models.size());

		for (ServiceComponents model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceComponentsSoap[soapModels.size()]);
	}

	public ServiceComponentsSoap() {
	}

	public long getPrimaryKey() {
		return _scId;
	}

	public void setPrimaryKey(long pk) {
		setScId(pk);
	}

	public long getScId() {
		return _scId;
	}

	public void setScId(long scId) {
		_scId = scId;
	}

	public long getScgId() {
		return _scgId;
	}

	public void setScgId(long scgId) {
		_scgId = scgId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getTechnologyComponent() {
		return _technologyComponent;
	}

	public void setTechnologyComponent(String technologyComponent) {
		_technologyComponent = technologyComponent;
	}

	public String getPhase() {
		return _phase;
	}

	public void setPhase(String phase) {
		_phase = phase;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getServiceType() {
		return _serviceType;
	}

	public void setServiceType(String serviceType) {
		_serviceType = serviceType;
	}

	public String getServiceExposureType() {
		return _ServiceExposureType;
	}

	public void setServiceExposureType(String ServiceExposureType) {
		_ServiceExposureType = ServiceExposureType;
	}

	public String getUserType() {
		return _userType;
	}

	public void setUserType(String userType) {
		_userType = userType;
	}

	public String getPlatformType() {
		return _platformType;
	}

	public void setPlatformType(String platformType) {
		_platformType = platformType;
	}

	public boolean getIslaCarteService() {
		return _islaCarteService;
	}

	public boolean isIslaCarteService() {
		return _islaCarteService;
	}

	public void setIslaCarteService(boolean islaCarteService) {
		_islaCarteService = islaCarteService;
	}

	public boolean getIsExternal() {
		return _isExternal;
	}

	public boolean isIsExternal() {
		return _isExternal;
	}

	public void setIsExternal(boolean isExternal) {
		_isExternal = isExternal;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public String getWebserviceURL() {
		return _webserviceURL;
	}

	public void setWebserviceURL(String webserviceURL) {
		_webserviceURL = webserviceURL;
	}

	public String getDeploymentCluster() {
		return _deploymentCluster;
	}

	public void setDeploymentCluster(String deploymentCluster) {
		_deploymentCluster = deploymentCluster;
	}

	public String getDeploymentLocation() {
		return _deploymentLocation;
	}

	public void setDeploymentLocation(String deploymentLocation) {
		_deploymentLocation = deploymentLocation;
	}

	public String getChannelID() {
		return _channelID;
	}

	public void setChannelID(String channelID) {
		_channelID = channelID;
	}

	public String getTestPlan() {
		return _testPlan;
	}

	public void setTestPlan(String testPlan) {
		_testPlan = testPlan;
	}

	public String getPerformanceProfile() {
		return _performanceProfile;
	}

	public void setPerformanceProfile(String performanceProfile) {
		_performanceProfile = performanceProfile;
	}

	public String getUsageStatistics() {
		return _usageStatistics;
	}

	public void setUsageStatistics(String usageStatistics) {
		_usageStatistics = usageStatistics;
	}

	public Date getDateAdded() {
		return _dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;
	}

	public Date getDateModified() {
		return _dateModified;
	}

	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getExtra1() {
		return _extra1;
	}

	public void setExtra1(String extra1) {
		_extra1 = extra1;
	}

	public String getExtra2() {
		return _extra2;
	}

	public void setExtra2(String extra2) {
		_extra2 = extra2;
	}

	public String getExtra3() {
		return _extra3;
	}

	public void setExtra3(String extra3) {
		_extra3 = extra3;
	}

	public String getExtra4() {
		return _extra4;
	}

	public void setExtra4(String extra4) {
		_extra4 = extra4;
	}

	public Date getExtra5() {
		return _extra5;
	}

	public void setExtra5(Date extra5) {
		_extra5 = extra5;
	}

	public Date getExtra6() {
		return _extra6;
	}

	public void setExtra6(Date extra6) {
		_extra6 = extra6;
	}

	public float getServiceCharges() {
		return _serviceCharges;
	}

	public void setServiceCharges(float serviceCharges) {
		_serviceCharges = serviceCharges;
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
}