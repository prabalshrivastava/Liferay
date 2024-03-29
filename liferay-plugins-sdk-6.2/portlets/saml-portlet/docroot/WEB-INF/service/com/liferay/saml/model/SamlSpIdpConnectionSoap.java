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

package com.liferay.saml.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mika Koivisto, W. Berks
 * @generated
 */
public class SamlSpIdpConnectionSoap implements Serializable {
	public static SamlSpIdpConnectionSoap toSoapModel(SamlSpIdpConnection model) {
		SamlSpIdpConnectionSoap soapModel = new SamlSpIdpConnectionSoap();

		soapModel.setSamlSpIdpConnectionId(model.getSamlSpIdpConnectionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSamlIdpEntityId(model.getSamlIdpEntityId());
		soapModel.setAssertionSignatureRequired(model.getAssertionSignatureRequired());
		soapModel.setClockSkew(model.getClockSkew());
		soapModel.setEnabled(model.getEnabled());
		soapModel.setLdapImportEnabled(model.getLdapImportEnabled());
		soapModel.setMetadataUrl(model.getMetadataUrl());
		soapModel.setMetadataXml(model.getMetadataXml());
		soapModel.setMetadataUpdatedDate(model.getMetadataUpdatedDate());
		soapModel.setName(model.getName());
		soapModel.setNameIdFormat(model.getNameIdFormat());
		soapModel.setSignAuthnRequest(model.getSignAuthnRequest());
		soapModel.setUserAttributeMappings(model.getUserAttributeMappings());
		soapModel.setKeepAliveUrl(model.getKeepAliveUrl());
		soapModel.setPrimaryKeyType(model.getPrimaryKeyType());
		soapModel.setPrimaryKeyAttribute(model.getPrimaryKeyAttribute());

		return soapModel;
	}

	public static SamlSpIdpConnectionSoap[] toSoapModels(
		SamlSpIdpConnection[] models) {
		SamlSpIdpConnectionSoap[] soapModels = new SamlSpIdpConnectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SamlSpIdpConnectionSoap[][] toSoapModels(
		SamlSpIdpConnection[][] models) {
		SamlSpIdpConnectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SamlSpIdpConnectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SamlSpIdpConnectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SamlSpIdpConnectionSoap[] toSoapModels(
		List<SamlSpIdpConnection> models) {
		List<SamlSpIdpConnectionSoap> soapModels = new ArrayList<SamlSpIdpConnectionSoap>(models.size());

		for (SamlSpIdpConnection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SamlSpIdpConnectionSoap[soapModels.size()]);
	}

	public SamlSpIdpConnectionSoap() {
	}

	public long getPrimaryKey() {
		return _samlSpIdpConnectionId;
	}

	public void setPrimaryKey(long pk) {
		setSamlSpIdpConnectionId(pk);
	}

	public long getSamlSpIdpConnectionId() {
		return _samlSpIdpConnectionId;
	}

	public void setSamlSpIdpConnectionId(long samlSpIdpConnectionId) {
		_samlSpIdpConnectionId = samlSpIdpConnectionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getSamlIdpEntityId() {
		return _samlIdpEntityId;
	}

	public void setSamlIdpEntityId(String samlIdpEntityId) {
		_samlIdpEntityId = samlIdpEntityId;
	}

	public boolean getAssertionSignatureRequired() {
		return _assertionSignatureRequired;
	}

	public boolean isAssertionSignatureRequired() {
		return _assertionSignatureRequired;
	}

	public void setAssertionSignatureRequired(
		boolean assertionSignatureRequired) {
		_assertionSignatureRequired = assertionSignatureRequired;
	}

	public long getClockSkew() {
		return _clockSkew;
	}

	public void setClockSkew(long clockSkew) {
		_clockSkew = clockSkew;
	}

	public boolean getEnabled() {
		return _enabled;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	public boolean getLdapImportEnabled() {
		return _ldapImportEnabled;
	}

	public boolean isLdapImportEnabled() {
		return _ldapImportEnabled;
	}

	public void setLdapImportEnabled(boolean ldapImportEnabled) {
		_ldapImportEnabled = ldapImportEnabled;
	}

	public String getMetadataUrl() {
		return _metadataUrl;
	}

	public void setMetadataUrl(String metadataUrl) {
		_metadataUrl = metadataUrl;
	}

	public String getMetadataXml() {
		return _metadataXml;
	}

	public void setMetadataXml(String metadataXml) {
		_metadataXml = metadataXml;
	}

	public Date getMetadataUpdatedDate() {
		return _metadataUpdatedDate;
	}

	public void setMetadataUpdatedDate(Date metadataUpdatedDate) {
		_metadataUpdatedDate = metadataUpdatedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getNameIdFormat() {
		return _nameIdFormat;
	}

	public void setNameIdFormat(String nameIdFormat) {
		_nameIdFormat = nameIdFormat;
	}

	public boolean getSignAuthnRequest() {
		return _signAuthnRequest;
	}

	public boolean isSignAuthnRequest() {
		return _signAuthnRequest;
	}

	public void setSignAuthnRequest(boolean signAuthnRequest) {
		_signAuthnRequest = signAuthnRequest;
	}

	public String getUserAttributeMappings() {
		return _userAttributeMappings;
	}

	public void setUserAttributeMappings(String userAttributeMappings) {
		_userAttributeMappings = userAttributeMappings;
	}

	public String getKeepAliveUrl() {
		return _keepAliveUrl;
	}

	public void setKeepAliveUrl(String keepAliveUrl) {
		_keepAliveUrl = keepAliveUrl;
	}

	public String getPrimaryKeyType() {
		return _primaryKeyType;
	}

	public void setPrimaryKeyType(String primaryKeyType) {
		_primaryKeyType = primaryKeyType;
	}

	public String getPrimaryKeyAttribute() {
		return _primaryKeyAttribute;
	}

	public void setPrimaryKeyAttribute(String primaryKeyAttribute) {
		_primaryKeyAttribute = primaryKeyAttribute;
	}

	private long _samlSpIdpConnectionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _samlIdpEntityId;
	private boolean _assertionSignatureRequired;
	private long _clockSkew;
	private boolean _enabled;
	private boolean _ldapImportEnabled;
	private String _metadataUrl;
	private String _metadataXml;
	private Date _metadataUpdatedDate;
	private String _name;
	private String _nameIdFormat;
	private boolean _signAuthnRequest;
	private String _userAttributeMappings;
	private String _keepAliveUrl;
	private String _primaryKeyType;
	private String _primaryKeyAttribute;
}