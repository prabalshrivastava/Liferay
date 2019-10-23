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

package com.sambaash.platform.srv.startupprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class PrinciplesSoap implements Serializable {
	public static PrinciplesSoap toSoapModel(Principles model) {
		PrinciplesSoap soapModel = new PrinciplesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSiteId(model.getSiteId());
		soapModel.setPrincipleId(model.getPrincipleId());
		soapModel.setPrincipleText(model.getPrincipleText());
		soapModel.setGuideline1(model.getGuideline1());
		soapModel.setGuideline2(model.getGuideline2());
		soapModel.setGuideline3(model.getGuideline3());
		soapModel.setGuideline4(model.getGuideline4());
		soapModel.setGuideline5(model.getGuideline5());
		soapModel.setGuideline6(model.getGuideline6());
		soapModel.setGuideline7(model.getGuideline7());
		soapModel.setGuideline8(model.getGuideline8());

		return soapModel;
	}

	public static PrinciplesSoap[] toSoapModels(Principles[] models) {
		PrinciplesSoap[] soapModels = new PrinciplesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PrinciplesSoap[][] toSoapModels(Principles[][] models) {
		PrinciplesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PrinciplesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PrinciplesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PrinciplesSoap[] toSoapModels(List<Principles> models) {
		List<PrinciplesSoap> soapModels = new ArrayList<PrinciplesSoap>(models.size());

		for (Principles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PrinciplesSoap[soapModels.size()]);
	}

	public PrinciplesSoap() {
	}

	public long getPrimaryKey() {
		return _principleId;
	}

	public void setPrimaryKey(long pk) {
		setPrincipleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	public long getPrincipleId() {
		return _principleId;
	}

	public void setPrincipleId(long principleId) {
		_principleId = principleId;
	}

	public String getPrincipleText() {
		return _principleText;
	}

	public void setPrincipleText(String principleText) {
		_principleText = principleText;
	}

	public String getGuideline1() {
		return _guideline1;
	}

	public void setGuideline1(String guideline1) {
		_guideline1 = guideline1;
	}

	public String getGuideline2() {
		return _guideline2;
	}

	public void setGuideline2(String guideline2) {
		_guideline2 = guideline2;
	}

	public String getGuideline3() {
		return _guideline3;
	}

	public void setGuideline3(String guideline3) {
		_guideline3 = guideline3;
	}

	public String getGuideline4() {
		return _guideline4;
	}

	public void setGuideline4(String guideline4) {
		_guideline4 = guideline4;
	}

	public String getGuideline5() {
		return _guideline5;
	}

	public void setGuideline5(String guideline5) {
		_guideline5 = guideline5;
	}

	public String getGuideline6() {
		return _guideline6;
	}

	public void setGuideline6(String guideline6) {
		_guideline6 = guideline6;
	}

	public String getGuideline7() {
		return _guideline7;
	}

	public void setGuideline7(String guideline7) {
		_guideline7 = guideline7;
	}

	public String getGuideline8() {
		return _guideline8;
	}

	public void setGuideline8(String guideline8) {
		_guideline8 = guideline8;
	}

	private String _uuid;
	private long _siteId;
	private long _principleId;
	private String _principleText;
	private String _guideline1;
	private String _guideline2;
	private String _guideline3;
	private String _guideline4;
	private String _guideline5;
	private String _guideline6;
	private String _guideline7;
	private String _guideline8;
}