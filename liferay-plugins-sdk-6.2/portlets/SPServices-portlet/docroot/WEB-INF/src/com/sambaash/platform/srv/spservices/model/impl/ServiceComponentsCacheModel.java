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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.ServiceComponents;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceComponents in entity cache.
 *
 * @author gauravvijayvergia
 * @see ServiceComponents
 * @generated
 */
public class ServiceComponentsCacheModel implements CacheModel<ServiceComponents>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{scId=");
		sb.append(scId);
		sb.append(", scgId=");
		sb.append(scgId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", technologyComponent=");
		sb.append(technologyComponent);
		sb.append(", phase=");
		sb.append(phase);
		sb.append(", status=");
		sb.append(status);
		sb.append(", version=");
		sb.append(version);
		sb.append(", serviceType=");
		sb.append(serviceType);
		sb.append(", ServiceExposureType=");
		sb.append(ServiceExposureType);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", platformType=");
		sb.append(platformType);
		sb.append(", islaCarteService=");
		sb.append(islaCarteService);
		sb.append(", isExternal=");
		sb.append(isExternal);
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", webserviceURL=");
		sb.append(webserviceURL);
		sb.append(", deploymentCluster=");
		sb.append(deploymentCluster);
		sb.append(", deploymentLocation=");
		sb.append(deploymentLocation);
		sb.append(", channelID=");
		sb.append(channelID);
		sb.append(", testPlan=");
		sb.append(testPlan);
		sb.append(", performanceProfile=");
		sb.append(performanceProfile);
		sb.append(", usageStatistics=");
		sb.append(usageStatistics);
		sb.append(", dateAdded=");
		sb.append(dateAdded);
		sb.append(", dateModified=");
		sb.append(dateModified);
		sb.append(", author=");
		sb.append(author);
		sb.append(", extra1=");
		sb.append(extra1);
		sb.append(", extra2=");
		sb.append(extra2);
		sb.append(", extra3=");
		sb.append(extra3);
		sb.append(", extra4=");
		sb.append(extra4);
		sb.append(", extra5=");
		sb.append(extra5);
		sb.append(", extra6=");
		sb.append(extra6);
		sb.append(", serviceCharges=");
		sb.append(serviceCharges);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceComponents toEntityModel() {
		ServiceComponentsImpl serviceComponentsImpl = new ServiceComponentsImpl();

		serviceComponentsImpl.setScId(scId);
		serviceComponentsImpl.setScgId(scgId);

		if (name == null) {
			serviceComponentsImpl.setName(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setName(name);
		}

		if (description == null) {
			serviceComponentsImpl.setDescription(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setDescription(description);
		}

		if (technologyComponent == null) {
			serviceComponentsImpl.setTechnologyComponent(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setTechnologyComponent(technologyComponent);
		}

		if (phase == null) {
			serviceComponentsImpl.setPhase(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setPhase(phase);
		}

		if (status == null) {
			serviceComponentsImpl.setStatus(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setStatus(status);
		}

		if (version == null) {
			serviceComponentsImpl.setVersion(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setVersion(version);
		}

		if (serviceType == null) {
			serviceComponentsImpl.setServiceType(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setServiceType(serviceType);
		}

		if (ServiceExposureType == null) {
			serviceComponentsImpl.setServiceExposureType(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setServiceExposureType(ServiceExposureType);
		}

		if (userType == null) {
			serviceComponentsImpl.setUserType(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setUserType(userType);
		}

		if (platformType == null) {
			serviceComponentsImpl.setPlatformType(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setPlatformType(platformType);
		}

		serviceComponentsImpl.setIslaCarteService(islaCarteService);
		serviceComponentsImpl.setIsExternal(isExternal);

		if (tag == null) {
			serviceComponentsImpl.setTag(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setTag(tag);
		}

		if (webserviceURL == null) {
			serviceComponentsImpl.setWebserviceURL(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setWebserviceURL(webserviceURL);
		}

		if (deploymentCluster == null) {
			serviceComponentsImpl.setDeploymentCluster(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setDeploymentCluster(deploymentCluster);
		}

		if (deploymentLocation == null) {
			serviceComponentsImpl.setDeploymentLocation(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setDeploymentLocation(deploymentLocation);
		}

		if (channelID == null) {
			serviceComponentsImpl.setChannelID(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setChannelID(channelID);
		}

		if (testPlan == null) {
			serviceComponentsImpl.setTestPlan(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setTestPlan(testPlan);
		}

		if (performanceProfile == null) {
			serviceComponentsImpl.setPerformanceProfile(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setPerformanceProfile(performanceProfile);
		}

		if (usageStatistics == null) {
			serviceComponentsImpl.setUsageStatistics(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setUsageStatistics(usageStatistics);
		}

		if (dateAdded == Long.MIN_VALUE) {
			serviceComponentsImpl.setDateAdded(null);
		}
		else {
			serviceComponentsImpl.setDateAdded(new Date(dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			serviceComponentsImpl.setDateModified(null);
		}
		else {
			serviceComponentsImpl.setDateModified(new Date(dateModified));
		}

		if (author == null) {
			serviceComponentsImpl.setAuthor(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setAuthor(author);
		}

		if (extra1 == null) {
			serviceComponentsImpl.setExtra1(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			serviceComponentsImpl.setExtra2(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			serviceComponentsImpl.setExtra3(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			serviceComponentsImpl.setExtra4(StringPool.BLANK);
		}
		else {
			serviceComponentsImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			serviceComponentsImpl.setExtra5(null);
		}
		else {
			serviceComponentsImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			serviceComponentsImpl.setExtra6(null);
		}
		else {
			serviceComponentsImpl.setExtra6(new Date(extra6));
		}

		serviceComponentsImpl.setServiceCharges(serviceCharges);

		serviceComponentsImpl.resetOriginalValues();

		return serviceComponentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scId = objectInput.readLong();
		scgId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		technologyComponent = objectInput.readUTF();
		phase = objectInput.readUTF();
		status = objectInput.readUTF();
		version = objectInput.readUTF();
		serviceType = objectInput.readUTF();
		ServiceExposureType = objectInput.readUTF();
		userType = objectInput.readUTF();
		platformType = objectInput.readUTF();
		islaCarteService = objectInput.readBoolean();
		isExternal = objectInput.readBoolean();
		tag = objectInput.readUTF();
		webserviceURL = objectInput.readUTF();
		deploymentCluster = objectInput.readUTF();
		deploymentLocation = objectInput.readUTF();
		channelID = objectInput.readUTF();
		testPlan = objectInput.readUTF();
		performanceProfile = objectInput.readUTF();
		usageStatistics = objectInput.readUTF();
		dateAdded = objectInput.readLong();
		dateModified = objectInput.readLong();
		author = objectInput.readUTF();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readLong();
		extra6 = objectInput.readLong();
		serviceCharges = objectInput.readFloat();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scId);
		objectOutput.writeLong(scgId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (technologyComponent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(technologyComponent);
		}

		if (phase == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phase);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (serviceType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceType);
		}

		if (ServiceExposureType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ServiceExposureType);
		}

		if (userType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userType);
		}

		if (platformType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(platformType);
		}

		objectOutput.writeBoolean(islaCarteService);
		objectOutput.writeBoolean(isExternal);

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}

		if (webserviceURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(webserviceURL);
		}

		if (deploymentCluster == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deploymentCluster);
		}

		if (deploymentLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deploymentLocation);
		}

		if (channelID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(channelID);
		}

		if (testPlan == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(testPlan);
		}

		if (performanceProfile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(performanceProfile);
		}

		if (usageStatistics == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(usageStatistics);
		}

		objectOutput.writeLong(dateAdded);
		objectOutput.writeLong(dateModified);

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (extra1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra1);
		}

		if (extra2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra2);
		}

		if (extra3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra3);
		}

		if (extra4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra4);
		}

		objectOutput.writeLong(extra5);
		objectOutput.writeLong(extra6);
		objectOutput.writeFloat(serviceCharges);
	}

	public long scId;
	public long scgId;
	public String name;
	public String description;
	public String technologyComponent;
	public String phase;
	public String status;
	public String version;
	public String serviceType;
	public String ServiceExposureType;
	public String userType;
	public String platformType;
	public boolean islaCarteService;
	public boolean isExternal;
	public String tag;
	public String webserviceURL;
	public String deploymentCluster;
	public String deploymentLocation;
	public String channelID;
	public String testPlan;
	public String performanceProfile;
	public String usageStatistics;
	public long dateAdded;
	public long dateModified;
	public String author;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public long extra5;
	public long extra6;
	public float serviceCharges;
}