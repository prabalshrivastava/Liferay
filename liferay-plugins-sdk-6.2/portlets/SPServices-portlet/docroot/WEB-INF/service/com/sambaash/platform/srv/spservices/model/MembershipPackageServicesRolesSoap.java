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
public class MembershipPackageServicesRolesSoap implements Serializable {
	public static MembershipPackageServicesRolesSoap toSoapModel(
		MembershipPackageServicesRoles model) {
		MembershipPackageServicesRolesSoap soapModel = new MembershipPackageServicesRolesSoap();

		soapModel.setMpgsrlId(model.getMpgsrlId());
		soapModel.setMpId(model.getMpId());
		soapModel.setServiceId(model.getServiceId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());
		soapModel.setExtra6(model.getExtra6());

		return soapModel;
	}

	public static MembershipPackageServicesRolesSoap[] toSoapModels(
		MembershipPackageServicesRoles[] models) {
		MembershipPackageServicesRolesSoap[] soapModels = new MembershipPackageServicesRolesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MembershipPackageServicesRolesSoap[][] toSoapModels(
		MembershipPackageServicesRoles[][] models) {
		MembershipPackageServicesRolesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MembershipPackageServicesRolesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MembershipPackageServicesRolesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MembershipPackageServicesRolesSoap[] toSoapModels(
		List<MembershipPackageServicesRoles> models) {
		List<MembershipPackageServicesRolesSoap> soapModels = new ArrayList<MembershipPackageServicesRolesSoap>(models.size());

		for (MembershipPackageServicesRoles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MembershipPackageServicesRolesSoap[soapModels.size()]);
	}

	public MembershipPackageServicesRolesSoap() {
	}

	public long getPrimaryKey() {
		return _mpgsrlId;
	}

	public void setPrimaryKey(long pk) {
		setMpgsrlId(pk);
	}

	public long getMpgsrlId() {
		return _mpgsrlId;
	}

	public void setMpgsrlId(long mpgsrlId) {
		_mpgsrlId = mpgsrlId;
	}

	public long getMpId() {
		return _mpId;
	}

	public void setMpId(long mpId) {
		_mpId = mpId;
	}

	public long getServiceId() {
		return _serviceId;
	}

	public void setServiceId(long serviceId) {
		_serviceId = serviceId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
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

	private long _mpgsrlId;
	private long _mpId;
	private long _serviceId;
	private long _classNameId;
	private long _roleId;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
}