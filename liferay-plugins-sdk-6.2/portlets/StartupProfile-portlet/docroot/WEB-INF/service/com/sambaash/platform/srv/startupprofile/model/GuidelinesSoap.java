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
public class GuidelinesSoap implements Serializable {
	public static GuidelinesSoap toSoapModel(Guidelines model) {
		GuidelinesSoap soapModel = new GuidelinesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGuidelineId(model.getGuidelineId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setPrincipleId(model.getPrincipleId());
		soapModel.setGuideline1(model.getGuideline1());
		soapModel.setGuideline2(model.getGuideline2());
		soapModel.setGuideline3(model.getGuideline3());
		soapModel.setGuideline4(model.getGuideline4());
		soapModel.setGuideline5(model.getGuideline5());
		soapModel.setGuideline6(model.getGuideline6());
		soapModel.setGuideline7(model.getGuideline7());
		soapModel.setGuideline8(model.getGuideline8());
		soapModel.setMoreInfo(model.getMoreInfo());

		return soapModel;
	}

	public static GuidelinesSoap[] toSoapModels(Guidelines[] models) {
		GuidelinesSoap[] soapModels = new GuidelinesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GuidelinesSoap[][] toSoapModels(Guidelines[][] models) {
		GuidelinesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GuidelinesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GuidelinesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GuidelinesSoap[] toSoapModels(List<Guidelines> models) {
		List<GuidelinesSoap> soapModels = new ArrayList<GuidelinesSoap>(models.size());

		for (Guidelines model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GuidelinesSoap[soapModels.size()]);
	}

	public GuidelinesSoap() {
	}

	public long getPrimaryKey() {
		return _guidelineId;
	}

	public void setPrimaryKey(long pk) {
		setGuidelineId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGuidelineId() {
		return _guidelineId;
	}

	public void setGuidelineId(long guidelineId) {
		_guidelineId = guidelineId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getPrincipleId() {
		return _principleId;
	}

	public void setPrincipleId(long principleId) {
		_principleId = principleId;
	}

	public boolean getGuideline1() {
		return _guideline1;
	}

	public boolean isGuideline1() {
		return _guideline1;
	}

	public void setGuideline1(boolean guideline1) {
		_guideline1 = guideline1;
	}

	public boolean getGuideline2() {
		return _guideline2;
	}

	public boolean isGuideline2() {
		return _guideline2;
	}

	public void setGuideline2(boolean guideline2) {
		_guideline2 = guideline2;
	}

	public boolean getGuideline3() {
		return _guideline3;
	}

	public boolean isGuideline3() {
		return _guideline3;
	}

	public void setGuideline3(boolean guideline3) {
		_guideline3 = guideline3;
	}

	public boolean getGuideline4() {
		return _guideline4;
	}

	public boolean isGuideline4() {
		return _guideline4;
	}

	public void setGuideline4(boolean guideline4) {
		_guideline4 = guideline4;
	}

	public boolean getGuideline5() {
		return _guideline5;
	}

	public boolean isGuideline5() {
		return _guideline5;
	}

	public void setGuideline5(boolean guideline5) {
		_guideline5 = guideline5;
	}

	public boolean getGuideline6() {
		return _guideline6;
	}

	public boolean isGuideline6() {
		return _guideline6;
	}

	public void setGuideline6(boolean guideline6) {
		_guideline6 = guideline6;
	}

	public boolean getGuideline7() {
		return _guideline7;
	}

	public boolean isGuideline7() {
		return _guideline7;
	}

	public void setGuideline7(boolean guideline7) {
		_guideline7 = guideline7;
	}

	public boolean getGuideline8() {
		return _guideline8;
	}

	public boolean isGuideline8() {
		return _guideline8;
	}

	public void setGuideline8(boolean guideline8) {
		_guideline8 = guideline8;
	}

	public String getMoreInfo() {
		return _moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		_moreInfo = moreInfo;
	}

	private String _uuid;
	private long _guidelineId;
	private long _organizationId;
	private long _principleId;
	private boolean _guideline1;
	private boolean _guideline2;
	private boolean _guideline3;
	private boolean _guideline4;
	private boolean _guideline5;
	private boolean _guideline6;
	private boolean _guideline7;
	private boolean _guideline8;
	private String _moreInfo;
}