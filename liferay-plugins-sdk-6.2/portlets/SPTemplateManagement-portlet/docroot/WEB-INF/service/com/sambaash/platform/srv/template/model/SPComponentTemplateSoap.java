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

package com.sambaash.platform.srv.template.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author WattabyteIT
 * @generated
 */
public class SPComponentTemplateSoap implements Serializable {
	public static SPComponentTemplateSoap toSoapModel(SPComponentTemplate model) {
		SPComponentTemplateSoap soapModel = new SPComponentTemplateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpComponentTemplateId(model.getSpComponentTemplateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setSpTemplateId(model.getSpTemplateId());
		soapModel.setLevel0ClassNameId(model.getLevel0ClassNameId());
		soapModel.setLevel0FormId(model.getLevel0FormId());
		soapModel.setLevel1ClassNameId(model.getLevel1ClassNameId());
		soapModel.setLevel1FormId(model.getLevel1FormId());
		soapModel.setLevel2ClassNameId(model.getLevel2ClassNameId());
		soapModel.setLevel2FormId(model.getLevel2FormId());
		soapModel.setLevel3ClassNameId(model.getLevel3ClassNameId());
		soapModel.setLevel3FormId(model.getLevel3FormId());
		soapModel.setLevel4ClassNameId(model.getLevel4ClassNameId());
		soapModel.setLevel4FormId(model.getLevel4FormId());
		soapModel.setLevel5ClassNameId(model.getLevel5ClassNameId());
		soapModel.setLevel5FormId(model.getLevel5FormId());
		soapModel.setLevel6ClassNameId(model.getLevel6ClassNameId());
		soapModel.setLevel6FormId(model.getLevel6FormId());
		soapModel.setLevel7ClassNameId(model.getLevel7ClassNameId());
		soapModel.setLevel7FormId(model.getLevel7FormId());
		soapModel.setLevel8ClassNameId(model.getLevel8ClassNameId());
		soapModel.setLevel8FormId(model.getLevel8FormId());
		soapModel.setLevel9ClassNameId(model.getLevel9ClassNameId());
		soapModel.setLevel9FormId(model.getLevel9FormId());
		soapModel.setLevel10ClassNameId(model.getLevel10ClassNameId());
		soapModel.setLevel10FormId(model.getLevel10FormId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SPComponentTemplateSoap[] toSoapModels(
		SPComponentTemplate[] models) {
		SPComponentTemplateSoap[] soapModels = new SPComponentTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPComponentTemplateSoap[][] toSoapModels(
		SPComponentTemplate[][] models) {
		SPComponentTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPComponentTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPComponentTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPComponentTemplateSoap[] toSoapModels(
		List<SPComponentTemplate> models) {
		List<SPComponentTemplateSoap> soapModels = new ArrayList<SPComponentTemplateSoap>(models.size());

		for (SPComponentTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPComponentTemplateSoap[soapModels.size()]);
	}

	public SPComponentTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _spComponentTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setSpComponentTemplateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpComponentTemplateId() {
		return _spComponentTemplateId;
	}

	public void setSpComponentTemplateId(long spComponentTemplateId) {
		_spComponentTemplateId = spComponentTemplateId;
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

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public long getSpTemplateId() {
		return _spTemplateId;
	}

	public void setSpTemplateId(long spTemplateId) {
		_spTemplateId = spTemplateId;
	}

	public long getLevel0ClassNameId() {
		return _level0ClassNameId;
	}

	public void setLevel0ClassNameId(long level0ClassNameId) {
		_level0ClassNameId = level0ClassNameId;
	}

	public long getLevel0FormId() {
		return _level0FormId;
	}

	public void setLevel0FormId(long level0FormId) {
		_level0FormId = level0FormId;
	}

	public long getLevel1ClassNameId() {
		return _level1ClassNameId;
	}

	public void setLevel1ClassNameId(long level1ClassNameId) {
		_level1ClassNameId = level1ClassNameId;
	}

	public long getLevel1FormId() {
		return _level1FormId;
	}

	public void setLevel1FormId(long level1FormId) {
		_level1FormId = level1FormId;
	}

	public long getLevel2ClassNameId() {
		return _level2ClassNameId;
	}

	public void setLevel2ClassNameId(long level2ClassNameId) {
		_level2ClassNameId = level2ClassNameId;
	}

	public long getLevel2FormId() {
		return _level2FormId;
	}

	public void setLevel2FormId(long level2FormId) {
		_level2FormId = level2FormId;
	}

	public long getLevel3ClassNameId() {
		return _level3ClassNameId;
	}

	public void setLevel3ClassNameId(long level3ClassNameId) {
		_level3ClassNameId = level3ClassNameId;
	}

	public long getLevel3FormId() {
		return _level3FormId;
	}

	public void setLevel3FormId(long level3FormId) {
		_level3FormId = level3FormId;
	}

	public long getLevel4ClassNameId() {
		return _level4ClassNameId;
	}

	public void setLevel4ClassNameId(long level4ClassNameId) {
		_level4ClassNameId = level4ClassNameId;
	}

	public long getLevel4FormId() {
		return _level4FormId;
	}

	public void setLevel4FormId(long level4FormId) {
		_level4FormId = level4FormId;
	}

	public long getLevel5ClassNameId() {
		return _level5ClassNameId;
	}

	public void setLevel5ClassNameId(long level5ClassNameId) {
		_level5ClassNameId = level5ClassNameId;
	}

	public long getLevel5FormId() {
		return _level5FormId;
	}

	public void setLevel5FormId(long level5FormId) {
		_level5FormId = level5FormId;
	}

	public long getLevel6ClassNameId() {
		return _level6ClassNameId;
	}

	public void setLevel6ClassNameId(long level6ClassNameId) {
		_level6ClassNameId = level6ClassNameId;
	}

	public long getLevel6FormId() {
		return _level6FormId;
	}

	public void setLevel6FormId(long level6FormId) {
		_level6FormId = level6FormId;
	}

	public long getLevel7ClassNameId() {
		return _level7ClassNameId;
	}

	public void setLevel7ClassNameId(long level7ClassNameId) {
		_level7ClassNameId = level7ClassNameId;
	}

	public long getLevel7FormId() {
		return _level7FormId;
	}

	public void setLevel7FormId(long level7FormId) {
		_level7FormId = level7FormId;
	}

	public long getLevel8ClassNameId() {
		return _level8ClassNameId;
	}

	public void setLevel8ClassNameId(long level8ClassNameId) {
		_level8ClassNameId = level8ClassNameId;
	}

	public long getLevel8FormId() {
		return _level8FormId;
	}

	public void setLevel8FormId(long level8FormId) {
		_level8FormId = level8FormId;
	}

	public long getLevel9ClassNameId() {
		return _level9ClassNameId;
	}

	public void setLevel9ClassNameId(long level9ClassNameId) {
		_level9ClassNameId = level9ClassNameId;
	}

	public long getLevel9FormId() {
		return _level9FormId;
	}

	public void setLevel9FormId(long level9FormId) {
		_level9FormId = level9FormId;
	}

	public long getLevel10ClassNameId() {
		return _level10ClassNameId;
	}

	public void setLevel10ClassNameId(long level10ClassNameId) {
		_level10ClassNameId = level10ClassNameId;
	}

	public long getLevel10FormId() {
		return _level10FormId;
	}

	public void setLevel10FormId(long level10FormId) {
		_level10FormId = level10FormId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _spComponentTemplateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createBy;
	private long _modifiedBy;
	private long _spTemplateId;
	private long _level0ClassNameId;
	private long _level0FormId;
	private long _level1ClassNameId;
	private long _level1FormId;
	private long _level2ClassNameId;
	private long _level2FormId;
	private long _level3ClassNameId;
	private long _level3FormId;
	private long _level4ClassNameId;
	private long _level4FormId;
	private long _level5ClassNameId;
	private long _level5FormId;
	private long _level6ClassNameId;
	private long _level6FormId;
	private long _level7ClassNameId;
	private long _level7FormId;
	private long _level8ClassNameId;
	private long _level8FormId;
	private long _level9ClassNameId;
	private long _level9FormId;
	private long _level10ClassNameId;
	private long _level10FormId;
	private int _status;
}