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

package com.sambaash.platform.srv.roles.model;

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
public class SPCategoriesMappingSoap implements Serializable {
	public static SPCategoriesMappingSoap toSoapModel(SPCategoriesMapping model) {
		SPCategoriesMappingSoap soapModel = new SPCategoriesMappingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpCategoryMappingId(model.getSpCategoryMappingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedVocabularyId(model.getCreatedVocabularyId());
		soapModel.setMainCategoryId(model.getMainCategoryId());
		soapModel.setSubCategoryId(model.getSubCategoryId());

		return soapModel;
	}

	public static SPCategoriesMappingSoap[] toSoapModels(
		SPCategoriesMapping[] models) {
		SPCategoriesMappingSoap[] soapModels = new SPCategoriesMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPCategoriesMappingSoap[][] toSoapModels(
		SPCategoriesMapping[][] models) {
		SPCategoriesMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPCategoriesMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPCategoriesMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPCategoriesMappingSoap[] toSoapModels(
		List<SPCategoriesMapping> models) {
		List<SPCategoriesMappingSoap> soapModels = new ArrayList<SPCategoriesMappingSoap>(models.size());

		for (SPCategoriesMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPCategoriesMappingSoap[soapModels.size()]);
	}

	public SPCategoriesMappingSoap() {
	}

	public long getPrimaryKey() {
		return _spCategoryMappingId;
	}

	public void setPrimaryKey(long pk) {
		setSpCategoryMappingId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpCategoryMappingId() {
		return _spCategoryMappingId;
	}

	public void setSpCategoryMappingId(long spCategoryMappingId) {
		_spCategoryMappingId = spCategoryMappingId;
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

	public long getCreatedVocabularyId() {
		return _createdVocabularyId;
	}

	public void setCreatedVocabularyId(long createdVocabularyId) {
		_createdVocabularyId = createdVocabularyId;
	}

	public long getMainCategoryId() {
		return _mainCategoryId;
	}

	public void setMainCategoryId(long mainCategoryId) {
		_mainCategoryId = mainCategoryId;
	}

	public long getSubCategoryId() {
		return _subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		_subCategoryId = subCategoryId;
	}

	private String _uuid;
	private long _spCategoryMappingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createdVocabularyId;
	private long _mainCategoryId;
	private long _subCategoryId;
}