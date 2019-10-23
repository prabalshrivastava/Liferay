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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPIPGeoLocationSoap implements Serializable {
	public static SPIPGeoLocationSoap toSoapModel(SPIPGeoLocation model) {
		SPIPGeoLocationSoap soapModel = new SPIPGeoLocationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpIPGeoLocationId(model.getSpIPGeoLocationId());
		soapModel.setIpPrefix(model.getIpPrefix());
		soapModel.setCountry(model.getCountry());

		return soapModel;
	}

	public static SPIPGeoLocationSoap[] toSoapModels(SPIPGeoLocation[] models) {
		SPIPGeoLocationSoap[] soapModels = new SPIPGeoLocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPIPGeoLocationSoap[][] toSoapModels(
		SPIPGeoLocation[][] models) {
		SPIPGeoLocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPIPGeoLocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPIPGeoLocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPIPGeoLocationSoap[] toSoapModels(
		List<SPIPGeoLocation> models) {
		List<SPIPGeoLocationSoap> soapModels = new ArrayList<SPIPGeoLocationSoap>(models.size());

		for (SPIPGeoLocation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPIPGeoLocationSoap[soapModels.size()]);
	}

	public SPIPGeoLocationSoap() {
	}

	public long getPrimaryKey() {
		return _spIPGeoLocationId;
	}

	public void setPrimaryKey(long pk) {
		setSpIPGeoLocationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpIPGeoLocationId() {
		return _spIPGeoLocationId;
	}

	public void setSpIPGeoLocationId(long spIPGeoLocationId) {
		_spIPGeoLocationId = spIPGeoLocationId;
	}

	public String getIpPrefix() {
		return _ipPrefix;
	}

	public void setIpPrefix(String ipPrefix) {
		_ipPrefix = ipPrefix;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	private String _uuid;
	private long _spIPGeoLocationId;
	private String _ipPrefix;
	private String _country;
}