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

package com.sambaash.platform.srv.spsocialprofile.model;

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
public class SocialProfileLikeSoap implements Serializable {
	public static SocialProfileLikeSoap toSoapModel(SocialProfileLike model) {
		SocialProfileLikeSoap soapModel = new SocialProfileLikeSoap();

		soapModel.setSocialProfileLikeId(model.getSocialProfileLikeId());
		soapModel.setSocialNetworkProfileId(model.getSocialNetworkProfileId());
		soapModel.setName(model.getName());
		soapModel.setCategory(model.getCategory());
		soapModel.setSocialNetworkLikeId(model.getSocialNetworkLikeId());
		soapModel.setSocialNetworkType(model.getSocialNetworkType());
		soapModel.setSocialNetworkCreateDate(model.getSocialNetworkCreateDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SocialProfileLikeSoap[] toSoapModels(
		SocialProfileLike[] models) {
		SocialProfileLikeSoap[] soapModels = new SocialProfileLikeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileLikeSoap[][] toSoapModels(
		SocialProfileLike[][] models) {
		SocialProfileLikeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialProfileLikeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialProfileLikeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileLikeSoap[] toSoapModels(
		List<SocialProfileLike> models) {
		List<SocialProfileLikeSoap> soapModels = new ArrayList<SocialProfileLikeSoap>(models.size());

		for (SocialProfileLike model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialProfileLikeSoap[soapModels.size()]);
	}

	public SocialProfileLikeSoap() {
	}

	public long getPrimaryKey() {
		return _socialProfileLikeId;
	}

	public void setPrimaryKey(long pk) {
		setSocialProfileLikeId(pk);
	}

	public long getSocialProfileLikeId() {
		return _socialProfileLikeId;
	}

	public void setSocialProfileLikeId(long socialProfileLikeId) {
		_socialProfileLikeId = socialProfileLikeId;
	}

	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialNetworkProfileId = socialNetworkProfileId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public long getSocialNetworkLikeId() {
		return _socialNetworkLikeId;
	}

	public void setSocialNetworkLikeId(long socialNetworkLikeId) {
		_socialNetworkLikeId = socialNetworkLikeId;
	}

	public int getSocialNetworkType() {
		return _socialNetworkType;
	}

	public void setSocialNetworkType(int socialNetworkType) {
		_socialNetworkType = socialNetworkType;
	}

	public Date getSocialNetworkCreateDate() {
		return _socialNetworkCreateDate;
	}

	public void setSocialNetworkCreateDate(Date socialNetworkCreateDate) {
		_socialNetworkCreateDate = socialNetworkCreateDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _socialProfileLikeId;
	private long _socialNetworkProfileId;
	private String _name;
	private String _category;
	private long _socialNetworkLikeId;
	private int _socialNetworkType;
	private Date _socialNetworkCreateDate;
	private Date _createDate;
	private Date _modifiedDate;
}