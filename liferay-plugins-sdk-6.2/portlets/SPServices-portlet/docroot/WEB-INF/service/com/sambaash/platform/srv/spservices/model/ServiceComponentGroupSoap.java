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
public class ServiceComponentGroupSoap implements Serializable {
	public static ServiceComponentGroupSoap toSoapModel(
		ServiceComponentGroup model) {
		ServiceComponentGroupSoap soapModel = new ServiceComponentGroupSoap();

		soapModel.setScgId(model.getScgId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setPhase(model.getPhase());
		soapModel.setStatus(model.getStatus());
		soapModel.setVersion(model.getVersion());
		soapModel.setDeploymentCluster(model.getDeploymentCluster());
		soapModel.setCommunity(model.getCommunity());
		soapModel.setDateAdded(model.getDateAdded());
		soapModel.setDateModified(model.getDateModified());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());
		soapModel.setExtra6(model.getExtra6());

		return soapModel;
	}

	public static ServiceComponentGroupSoap[] toSoapModels(
		ServiceComponentGroup[] models) {
		ServiceComponentGroupSoap[] soapModels = new ServiceComponentGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceComponentGroupSoap[][] toSoapModels(
		ServiceComponentGroup[][] models) {
		ServiceComponentGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceComponentGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceComponentGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceComponentGroupSoap[] toSoapModels(
		List<ServiceComponentGroup> models) {
		List<ServiceComponentGroupSoap> soapModels = new ArrayList<ServiceComponentGroupSoap>(models.size());

		for (ServiceComponentGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceComponentGroupSoap[soapModels.size()]);
	}

	public ServiceComponentGroupSoap() {
	}

	public long getPrimaryKey() {
		return _scgId;
	}

	public void setPrimaryKey(long pk) {
		setScgId(pk);
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

	public String getDeploymentCluster() {
		return _deploymentCluster;
	}

	public void setDeploymentCluster(String deploymentCluster) {
		_deploymentCluster = deploymentCluster;
	}

	public String getCommunity() {
		return _community;
	}

	public void setCommunity(String community) {
		_community = community;
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

	private long _scgId;
	private String _name;
	private String _description;
	private String _phase;
	private String _status;
	private String _version;
	private String _deploymentCluster;
	private String _community;
	private Date _dateAdded;
	private Date _dateModified;
	private String _author;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
}