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

package com.sambaash.platform.srv.spdashboard.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class SPAnalyticsConfigSoap implements Serializable {
	public static SPAnalyticsConfigSoap toSoapModel(SPAnalyticsConfig model) {
		SPAnalyticsConfigSoap soapModel = new SPAnalyticsConfigSoap();

		soapModel.setSpAnalyticsConfigId(model.getSpAnalyticsConfigId());
		soapModel.setName(model.getName());
		soapModel.setConfig(model.getConfig());
		soapModel.setType(model.getType());
		soapModel.setQuery(model.getQuery());
		soapModel.setWarId(model.getWarId());

		return soapModel;
	}

	public static SPAnalyticsConfigSoap[] toSoapModels(
		SPAnalyticsConfig[] models) {
		SPAnalyticsConfigSoap[] soapModels = new SPAnalyticsConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPAnalyticsConfigSoap[][] toSoapModels(
		SPAnalyticsConfig[][] models) {
		SPAnalyticsConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPAnalyticsConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPAnalyticsConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPAnalyticsConfigSoap[] toSoapModels(
		List<SPAnalyticsConfig> models) {
		List<SPAnalyticsConfigSoap> soapModels = new ArrayList<SPAnalyticsConfigSoap>(models.size());

		for (SPAnalyticsConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPAnalyticsConfigSoap[soapModels.size()]);
	}

	public SPAnalyticsConfigSoap() {
	}

	public long getPrimaryKey() {
		return _spAnalyticsConfigId;
	}

	public void setPrimaryKey(long pk) {
		setSpAnalyticsConfigId(pk);
	}

	public long getSpAnalyticsConfigId() {
		return _spAnalyticsConfigId;
	}

	public void setSpAnalyticsConfigId(long spAnalyticsConfigId) {
		_spAnalyticsConfigId = spAnalyticsConfigId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getConfig() {
		return _config;
	}

	public void setConfig(String config) {
		_config = config;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getQuery() {
		return _query;
	}

	public void setQuery(String query) {
		_query = query;
	}

	public String getWarId() {
		return _warId;
	}

	public void setWarId(String warId) {
		_warId = warId;
	}

	private long _spAnalyticsConfigId;
	private String _name;
	private String _config;
	private int _type;
	private String _query;
	private String _warId;
}