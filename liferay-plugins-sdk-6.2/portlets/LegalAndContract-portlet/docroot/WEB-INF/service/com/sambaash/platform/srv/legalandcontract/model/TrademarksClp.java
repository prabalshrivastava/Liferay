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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.legalandcontract.service.ClpSerializer;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class TrademarksClp extends BaseModelImpl<Trademarks>
	implements Trademarks {
	public TrademarksClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Trademarks.class;
	}

	@Override
	public String getModelClassName() {
		return Trademarks.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spTrademarksId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpTrademarksId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spTrademarksId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spTrademarksId", getSpTrademarksId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("registrationNumber", getRegistrationNumber());
		attributes.put("applicationNo", getApplicationNo());
		attributes.put("country", getCountry());
		attributes.put("trademark", getTrademark());
		attributes.put("trademarkLocalized", getTrademarkLocalized());
		attributes.put("registeredOwner", getRegisteredOwner());
		attributes.put("applicationDate", getApplicationDate());
		attributes.put("firstRegistrationDate", getFirstRegistrationDate());
		attributes.put("renewalDate", getRenewalDate());
		attributes.put("goodsServices", getGoodsServices());
		attributes.put("pendingComments", getPendingComments());
		attributes.put("spAgencyId", getSpAgencyId());
		attributes.put("classDescription", getClassDescription());
		attributes.put("legalConfRemarks", getLegalConfRemarks());
		attributes.put("workflowStatus", getWorkflowStatus());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customField3", getCustomField3());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("customDate3", getCustomDate3());
		attributes.put("classCodes", getClassCodes());
		attributes.put("version", getVersion());
		attributes.put("trademarkType", getTrademarkType());
		attributes.put("rootSpTrademarksId", getRootSpTrademarksId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spTrademarksId = (Long)attributes.get("spTrademarksId");

		if (spTrademarksId != null) {
			setSpTrademarksId(spTrademarksId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String registrationNumber = (String)attributes.get("registrationNumber");

		if (registrationNumber != null) {
			setRegistrationNumber(registrationNumber);
		}

		String applicationNo = (String)attributes.get("applicationNo");

		if (applicationNo != null) {
			setApplicationNo(applicationNo);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String trademark = (String)attributes.get("trademark");

		if (trademark != null) {
			setTrademark(trademark);
		}

		String trademarkLocalized = (String)attributes.get("trademarkLocalized");

		if (trademarkLocalized != null) {
			setTrademarkLocalized(trademarkLocalized);
		}

		String registeredOwner = (String)attributes.get("registeredOwner");

		if (registeredOwner != null) {
			setRegisteredOwner(registeredOwner);
		}

		Date applicationDate = (Date)attributes.get("applicationDate");

		if (applicationDate != null) {
			setApplicationDate(applicationDate);
		}

		Date firstRegistrationDate = (Date)attributes.get(
				"firstRegistrationDate");

		if (firstRegistrationDate != null) {
			setFirstRegistrationDate(firstRegistrationDate);
		}

		Date renewalDate = (Date)attributes.get("renewalDate");

		if (renewalDate != null) {
			setRenewalDate(renewalDate);
		}

		String goodsServices = (String)attributes.get("goodsServices");

		if (goodsServices != null) {
			setGoodsServices(goodsServices);
		}

		String pendingComments = (String)attributes.get("pendingComments");

		if (pendingComments != null) {
			setPendingComments(pendingComments);
		}

		Long spAgencyId = (Long)attributes.get("spAgencyId");

		if (spAgencyId != null) {
			setSpAgencyId(spAgencyId);
		}

		String classDescription = (String)attributes.get("classDescription");

		if (classDescription != null) {
			setClassDescription(classDescription);
		}

		String legalConfRemarks = (String)attributes.get("legalConfRemarks");

		if (legalConfRemarks != null) {
			setLegalConfRemarks(legalConfRemarks);
		}

		Long workflowStatus = (Long)attributes.get("workflowStatus");

		if (workflowStatus != null) {
			setWorkflowStatus(workflowStatus);
		}

		String customField1 = (String)attributes.get("customField1");

		if (customField1 != null) {
			setCustomField1(customField1);
		}

		String customField2 = (String)attributes.get("customField2");

		if (customField2 != null) {
			setCustomField2(customField2);
		}

		String customField3 = (String)attributes.get("customField3");

		if (customField3 != null) {
			setCustomField3(customField3);
		}

		Date customDate1 = (Date)attributes.get("customDate1");

		if (customDate1 != null) {
			setCustomDate1(customDate1);
		}

		Date customDate2 = (Date)attributes.get("customDate2");

		if (customDate2 != null) {
			setCustomDate2(customDate2);
		}

		Date customDate3 = (Date)attributes.get("customDate3");

		if (customDate3 != null) {
			setCustomDate3(customDate3);
		}

		String classCodes = (String)attributes.get("classCodes");

		if (classCodes != null) {
			setClassCodes(classCodes);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String trademarkType = (String)attributes.get("trademarkType");

		if (trademarkType != null) {
			setTrademarkType(trademarkType);
		}

		Long rootSpTrademarksId = (Long)attributes.get("rootSpTrademarksId");

		if (rootSpTrademarksId != null) {
			setRootSpTrademarksId(rootSpTrademarksId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_trademarksRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpTrademarksId() {
		return _spTrademarksId;
	}

	@Override
	public void setSpTrademarksId(long spTrademarksId) {
		_spTrademarksId = spTrademarksId;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setSpTrademarksId", long.class);

				method.invoke(_trademarksRemoteModel, spTrademarksId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_trademarksRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_trademarksRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_trademarksRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_trademarksRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_trademarksRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_trademarksRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegistrationNumber() {
		return _registrationNumber;
	}

	@Override
	public void setRegistrationNumber(String registrationNumber) {
		_registrationNumber = registrationNumber;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationNumber",
						String.class);

				method.invoke(_trademarksRemoteModel, registrationNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationNo() {
		return _applicationNo;
	}

	@Override
	public void setApplicationNo(String applicationNo) {
		_applicationNo = applicationNo;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationNo", String.class);

				method.invoke(_trademarksRemoteModel, applicationNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_trademarksRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrademark() {
		return _trademark;
	}

	@Override
	public void setTrademark(String trademark) {
		_trademark = trademark;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setTrademark", String.class);

				method.invoke(_trademarksRemoteModel, trademark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrademarkLocalized() {
		return _trademarkLocalized;
	}

	@Override
	public void setTrademarkLocalized(String trademarkLocalized) {
		_trademarkLocalized = trademarkLocalized;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setTrademarkLocalized",
						String.class);

				method.invoke(_trademarksRemoteModel, trademarkLocalized);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegisteredOwner() {
		return _registeredOwner;
	}

	@Override
	public void setRegisteredOwner(String registeredOwner) {
		_registeredOwner = registeredOwner;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRegisteredOwner",
						String.class);

				method.invoke(_trademarksRemoteModel, registeredOwner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getApplicationDate() {
		return _applicationDate;
	}

	@Override
	public void setApplicationDate(Date applicationDate) {
		_applicationDate = applicationDate;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationDate", Date.class);

				method.invoke(_trademarksRemoteModel, applicationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFirstRegistrationDate() {
		return _firstRegistrationDate;
	}

	@Override
	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		_firstRegistrationDate = firstRegistrationDate;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstRegistrationDate",
						Date.class);

				method.invoke(_trademarksRemoteModel, firstRegistrationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRenewalDate() {
		return _renewalDate;
	}

	@Override
	public void setRenewalDate(Date renewalDate) {
		_renewalDate = renewalDate;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewalDate", Date.class);

				method.invoke(_trademarksRemoteModel, renewalDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGoodsServices() {
		return _goodsServices;
	}

	@Override
	public void setGoodsServices(String goodsServices) {
		_goodsServices = goodsServices;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setGoodsServices", String.class);

				method.invoke(_trademarksRemoteModel, goodsServices);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPendingComments() {
		return _pendingComments;
	}

	@Override
	public void setPendingComments(String pendingComments) {
		_pendingComments = pendingComments;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setPendingComments",
						String.class);

				method.invoke(_trademarksRemoteModel, pendingComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAgencyId() {
		return _spAgencyId;
	}

	@Override
	public void setSpAgencyId(long spAgencyId) {
		_spAgencyId = spAgencyId;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAgencyId", long.class);

				method.invoke(_trademarksRemoteModel, spAgencyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassDescription() {
		return _classDescription;
	}

	@Override
	public void setClassDescription(String classDescription) {
		_classDescription = classDescription;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setClassDescription",
						String.class);

				method.invoke(_trademarksRemoteModel, classDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLegalConfRemarks() {
		return _legalConfRemarks;
	}

	@Override
	public void setLegalConfRemarks(String legalConfRemarks) {
		_legalConfRemarks = legalConfRemarks;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setLegalConfRemarks",
						String.class);

				method.invoke(_trademarksRemoteModel, legalConfRemarks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkflowStatus() {
		return _workflowStatus;
	}

	@Override
	public void setWorkflowStatus(long workflowStatus) {
		_workflowStatus = workflowStatus;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowStatus", long.class);

				method.invoke(_trademarksRemoteModel, workflowStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField1() {
		return _customField1;
	}

	@Override
	public void setCustomField1(String customField1) {
		_customField1 = customField1;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField1", String.class);

				method.invoke(_trademarksRemoteModel, customField1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField2() {
		return _customField2;
	}

	@Override
	public void setCustomField2(String customField2) {
		_customField2 = customField2;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField2", String.class);

				method.invoke(_trademarksRemoteModel, customField2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField3() {
		return _customField3;
	}

	@Override
	public void setCustomField3(String customField3) {
		_customField3 = customField3;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField3", String.class);

				method.invoke(_trademarksRemoteModel, customField3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate1() {
		return _customDate1;
	}

	@Override
	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate1", Date.class);

				method.invoke(_trademarksRemoteModel, customDate1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate2() {
		return _customDate2;
	}

	@Override
	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate2", Date.class);

				method.invoke(_trademarksRemoteModel, customDate2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate3() {
		return _customDate3;
	}

	@Override
	public void setCustomDate3(Date customDate3) {
		_customDate3 = customDate3;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate3", Date.class);

				method.invoke(_trademarksRemoteModel, customDate3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassCodes() {
		return _classCodes;
	}

	@Override
	public void setClassCodes(String classCodes) {
		_classCodes = classCodes;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setClassCodes", String.class);

				method.invoke(_trademarksRemoteModel, classCodes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_trademarksRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrademarkType() {
		return _trademarkType;
	}

	@Override
	public void setTrademarkType(String trademarkType) {
		_trademarkType = trademarkType;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setTrademarkType", String.class);

				method.invoke(_trademarksRemoteModel, trademarkType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRootSpTrademarksId() {
		return _rootSpTrademarksId;
	}

	@Override
	public void setRootSpTrademarksId(long rootSpTrademarksId) {
		_rootSpTrademarksId = rootSpTrademarksId;

		if (_trademarksRemoteModel != null) {
			try {
				Class<?> clazz = _trademarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRootSpTrademarksId",
						long.class);

				method.invoke(_trademarksRemoteModel, rootSpTrademarksId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Trademarks.class.getName()));
	}

	public BaseModel<?> getTrademarksRemoteModel() {
		return _trademarksRemoteModel;
	}

	public void setTrademarksRemoteModel(BaseModel<?> trademarksRemoteModel) {
		_trademarksRemoteModel = trademarksRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _trademarksRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_trademarksRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TrademarksLocalServiceUtil.addTrademarks(this);
		}
		else {
			TrademarksLocalServiceUtil.updateTrademarks(this);
		}
	}

	@Override
	public Trademarks toEscapedModel() {
		return (Trademarks)ProxyUtil.newProxyInstance(Trademarks.class.getClassLoader(),
			new Class[] { Trademarks.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TrademarksClp clone = new TrademarksClp();

		clone.setUuid(getUuid());
		clone.setSpTrademarksId(getSpTrademarksId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRegistrationNumber(getRegistrationNumber());
		clone.setApplicationNo(getApplicationNo());
		clone.setCountry(getCountry());
		clone.setTrademark(getTrademark());
		clone.setTrademarkLocalized(getTrademarkLocalized());
		clone.setRegisteredOwner(getRegisteredOwner());
		clone.setApplicationDate(getApplicationDate());
		clone.setFirstRegistrationDate(getFirstRegistrationDate());
		clone.setRenewalDate(getRenewalDate());
		clone.setGoodsServices(getGoodsServices());
		clone.setPendingComments(getPendingComments());
		clone.setSpAgencyId(getSpAgencyId());
		clone.setClassDescription(getClassDescription());
		clone.setLegalConfRemarks(getLegalConfRemarks());
		clone.setWorkflowStatus(getWorkflowStatus());
		clone.setCustomField1(getCustomField1());
		clone.setCustomField2(getCustomField2());
		clone.setCustomField3(getCustomField3());
		clone.setCustomDate1(getCustomDate1());
		clone.setCustomDate2(getCustomDate2());
		clone.setCustomDate3(getCustomDate3());
		clone.setClassCodes(getClassCodes());
		clone.setVersion(getVersion());
		clone.setTrademarkType(getTrademarkType());
		clone.setRootSpTrademarksId(getRootSpTrademarksId());

		return clone;
	}

	@Override
	public int compareTo(Trademarks trademarks) {
		long primaryKey = trademarks.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrademarksClp)) {
			return false;
		}

		TrademarksClp trademarks = (TrademarksClp)obj;

		long primaryKey = trademarks.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spTrademarksId=");
		sb.append(getSpTrademarksId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", registrationNumber=");
		sb.append(getRegistrationNumber());
		sb.append(", applicationNo=");
		sb.append(getApplicationNo());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", trademark=");
		sb.append(getTrademark());
		sb.append(", trademarkLocalized=");
		sb.append(getTrademarkLocalized());
		sb.append(", registeredOwner=");
		sb.append(getRegisteredOwner());
		sb.append(", applicationDate=");
		sb.append(getApplicationDate());
		sb.append(", firstRegistrationDate=");
		sb.append(getFirstRegistrationDate());
		sb.append(", renewalDate=");
		sb.append(getRenewalDate());
		sb.append(", goodsServices=");
		sb.append(getGoodsServices());
		sb.append(", pendingComments=");
		sb.append(getPendingComments());
		sb.append(", spAgencyId=");
		sb.append(getSpAgencyId());
		sb.append(", classDescription=");
		sb.append(getClassDescription());
		sb.append(", legalConfRemarks=");
		sb.append(getLegalConfRemarks());
		sb.append(", workflowStatus=");
		sb.append(getWorkflowStatus());
		sb.append(", customField1=");
		sb.append(getCustomField1());
		sb.append(", customField2=");
		sb.append(getCustomField2());
		sb.append(", customField3=");
		sb.append(getCustomField3());
		sb.append(", customDate1=");
		sb.append(getCustomDate1());
		sb.append(", customDate2=");
		sb.append(getCustomDate2());
		sb.append(", customDate3=");
		sb.append(getCustomDate3());
		sb.append(", classCodes=");
		sb.append(getClassCodes());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", trademarkType=");
		sb.append(getTrademarkType());
		sb.append(", rootSpTrademarksId=");
		sb.append(getRootSpTrademarksId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(103);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.legalandcontract.model.Trademarks");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spTrademarksId</column-name><column-value><![CDATA[");
		sb.append(getSpTrademarksId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationNumber</column-name><column-value><![CDATA[");
		sb.append(getRegistrationNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationNo</column-name><column-value><![CDATA[");
		sb.append(getApplicationNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trademark</column-name><column-value><![CDATA[");
		sb.append(getTrademark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trademarkLocalized</column-name><column-value><![CDATA[");
		sb.append(getTrademarkLocalized());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registeredOwner</column-name><column-value><![CDATA[");
		sb.append(getRegisteredOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationDate</column-name><column-value><![CDATA[");
		sb.append(getApplicationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstRegistrationDate</column-name><column-value><![CDATA[");
		sb.append(getFirstRegistrationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewalDate</column-name><column-value><![CDATA[");
		sb.append(getRenewalDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goodsServices</column-name><column-value><![CDATA[");
		sb.append(getGoodsServices());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pendingComments</column-name><column-value><![CDATA[");
		sb.append(getPendingComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAgencyId</column-name><column-value><![CDATA[");
		sb.append(getSpAgencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classDescription</column-name><column-value><![CDATA[");
		sb.append(getClassDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>legalConfRemarks</column-name><column-value><![CDATA[");
		sb.append(getLegalConfRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowStatus</column-name><column-value><![CDATA[");
		sb.append(getWorkflowStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField1</column-name><column-value><![CDATA[");
		sb.append(getCustomField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField2</column-name><column-value><![CDATA[");
		sb.append(getCustomField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField3</column-name><column-value><![CDATA[");
		sb.append(getCustomField3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate1</column-name><column-value><![CDATA[");
		sb.append(getCustomDate1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate2</column-name><column-value><![CDATA[");
		sb.append(getCustomDate2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate3</column-name><column-value><![CDATA[");
		sb.append(getCustomDate3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classCodes</column-name><column-value><![CDATA[");
		sb.append(getClassCodes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trademarkType</column-name><column-value><![CDATA[");
		sb.append(getTrademarkType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootSpTrademarksId</column-name><column-value><![CDATA[");
		sb.append(getRootSpTrademarksId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spTrademarksId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _registrationNumber;
	private String _applicationNo;
	private String _country;
	private String _trademark;
	private String _trademarkLocalized;
	private String _registeredOwner;
	private Date _applicationDate;
	private Date _firstRegistrationDate;
	private Date _renewalDate;
	private String _goodsServices;
	private String _pendingComments;
	private long _spAgencyId;
	private String _classDescription;
	private String _legalConfRemarks;
	private long _workflowStatus;
	private String _customField1;
	private String _customField2;
	private String _customField3;
	private Date _customDate1;
	private Date _customDate2;
	private Date _customDate3;
	private String _classCodes;
	private String _version;
	private String _trademarkType;
	private long _rootSpTrademarksId;
	private BaseModel<?> _trademarksRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.class;
}