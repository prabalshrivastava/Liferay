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

package com.sambaash.platform.srv.spsocialsharing.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author harini
 * @generated
 */
public class SPSocialSharingSoap implements Serializable {
	public static SPSocialSharingSoap toSoapModel(SPSocialSharing model) {
		SPSocialSharingSoap soapModel = new SPSocialSharingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpSocialSharingId(model.getSpSocialSharingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setFacebook(model.getFacebook());
		soapModel.setTwitter(model.getTwitter());
		soapModel.setLinkedin(model.getLinkedin());
		soapModel.setYahoo(model.getYahoo());
		soapModel.setGoogle(model.getGoogle());
		soapModel.setFacebookPage(model.getFacebookPage());

		return soapModel;
	}

	public static SPSocialSharingSoap[] toSoapModels(SPSocialSharing[] models) {
		SPSocialSharingSoap[] soapModels = new SPSocialSharingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSocialSharingSoap[][] toSoapModels(
		SPSocialSharing[][] models) {
		SPSocialSharingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSocialSharingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSocialSharingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSocialSharingSoap[] toSoapModels(
		List<SPSocialSharing> models) {
		List<SPSocialSharingSoap> soapModels = new ArrayList<SPSocialSharingSoap>(models.size());

		for (SPSocialSharing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSocialSharingSoap[soapModels.size()]);
	}

	public SPSocialSharingSoap() {
	}

	public long getPrimaryKey() {
		return _spSocialSharingId;
	}

	public void setPrimaryKey(long pk) {
		setSpSocialSharingId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpSocialSharingId() {
		return _spSocialSharingId;
	}

	public void setSpSocialSharingId(long spSocialSharingId) {
		_spSocialSharingId = spSocialSharingId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public int getFacebook() {
		return _facebook;
	}

	public void setFacebook(int facebook) {
		_facebook = facebook;
	}

	public int getTwitter() {
		return _twitter;
	}

	public void setTwitter(int twitter) {
		_twitter = twitter;
	}

	public int getLinkedin() {
		return _linkedin;
	}

	public void setLinkedin(int linkedin) {
		_linkedin = linkedin;
	}

	public int getYahoo() {
		return _yahoo;
	}

	public void setYahoo(int yahoo) {
		_yahoo = yahoo;
	}

	public int getGoogle() {
		return _google;
	}

	public void setGoogle(int google) {
		_google = google;
	}

	public int getFacebookPage() {
		return _facebookPage;
	}

	public void setFacebookPage(int facebookPage) {
		_facebookPage = facebookPage;
	}

	private String _uuid;
	private long _spSocialSharingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private int _facebook;
	private int _twitter;
	private int _linkedin;
	private int _yahoo;
	private int _google;
	private int _facebookPage;
}