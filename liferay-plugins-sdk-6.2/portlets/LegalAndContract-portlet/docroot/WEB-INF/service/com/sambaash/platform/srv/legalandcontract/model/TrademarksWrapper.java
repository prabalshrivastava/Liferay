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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Trademarks}.
 * </p>
 *
 * @author nareshchebolu
 * @see Trademarks
 * @generated
 */
public class TrademarksWrapper implements Trademarks, ModelWrapper<Trademarks> {
	public TrademarksWrapper(Trademarks trademarks) {
		_trademarks = trademarks;
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

	/**
	* Returns the primary key of this trademarks.
	*
	* @return the primary key of this trademarks
	*/
	@Override
	public long getPrimaryKey() {
		return _trademarks.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trademarks.
	*
	* @param primaryKey the primary key of this trademarks
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_trademarks.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this trademarks.
	*
	* @return the uuid of this trademarks
	*/
	@Override
	public java.lang.String getUuid() {
		return _trademarks.getUuid();
	}

	/**
	* Sets the uuid of this trademarks.
	*
	* @param uuid the uuid of this trademarks
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_trademarks.setUuid(uuid);
	}

	/**
	* Returns the sp trademarks ID of this trademarks.
	*
	* @return the sp trademarks ID of this trademarks
	*/
	@Override
	public long getSpTrademarksId() {
		return _trademarks.getSpTrademarksId();
	}

	/**
	* Sets the sp trademarks ID of this trademarks.
	*
	* @param spTrademarksId the sp trademarks ID of this trademarks
	*/
	@Override
	public void setSpTrademarksId(long spTrademarksId) {
		_trademarks.setSpTrademarksId(spTrademarksId);
	}

	/**
	* Returns the group ID of this trademarks.
	*
	* @return the group ID of this trademarks
	*/
	@Override
	public long getGroupId() {
		return _trademarks.getGroupId();
	}

	/**
	* Sets the group ID of this trademarks.
	*
	* @param groupId the group ID of this trademarks
	*/
	@Override
	public void setGroupId(long groupId) {
		_trademarks.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this trademarks.
	*
	* @return the company ID of this trademarks
	*/
	@Override
	public long getCompanyId() {
		return _trademarks.getCompanyId();
	}

	/**
	* Sets the company ID of this trademarks.
	*
	* @param companyId the company ID of this trademarks
	*/
	@Override
	public void setCompanyId(long companyId) {
		_trademarks.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this trademarks.
	*
	* @return the user ID of this trademarks
	*/
	@Override
	public long getUserId() {
		return _trademarks.getUserId();
	}

	/**
	* Sets the user ID of this trademarks.
	*
	* @param userId the user ID of this trademarks
	*/
	@Override
	public void setUserId(long userId) {
		_trademarks.setUserId(userId);
	}

	/**
	* Returns the user uuid of this trademarks.
	*
	* @return the user uuid of this trademarks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarks.getUserUuid();
	}

	/**
	* Sets the user uuid of this trademarks.
	*
	* @param userUuid the user uuid of this trademarks
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_trademarks.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this trademarks.
	*
	* @return the user name of this trademarks
	*/
	@Override
	public java.lang.String getUserName() {
		return _trademarks.getUserName();
	}

	/**
	* Sets the user name of this trademarks.
	*
	* @param userName the user name of this trademarks
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_trademarks.setUserName(userName);
	}

	/**
	* Returns the create date of this trademarks.
	*
	* @return the create date of this trademarks
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _trademarks.getCreateDate();
	}

	/**
	* Sets the create date of this trademarks.
	*
	* @param createDate the create date of this trademarks
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_trademarks.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this trademarks.
	*
	* @return the modified date of this trademarks
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _trademarks.getModifiedDate();
	}

	/**
	* Sets the modified date of this trademarks.
	*
	* @param modifiedDate the modified date of this trademarks
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_trademarks.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the registration number of this trademarks.
	*
	* @return the registration number of this trademarks
	*/
	@Override
	public java.lang.String getRegistrationNumber() {
		return _trademarks.getRegistrationNumber();
	}

	/**
	* Sets the registration number of this trademarks.
	*
	* @param registrationNumber the registration number of this trademarks
	*/
	@Override
	public void setRegistrationNumber(java.lang.String registrationNumber) {
		_trademarks.setRegistrationNumber(registrationNumber);
	}

	/**
	* Returns the application no of this trademarks.
	*
	* @return the application no of this trademarks
	*/
	@Override
	public java.lang.String getApplicationNo() {
		return _trademarks.getApplicationNo();
	}

	/**
	* Sets the application no of this trademarks.
	*
	* @param applicationNo the application no of this trademarks
	*/
	@Override
	public void setApplicationNo(java.lang.String applicationNo) {
		_trademarks.setApplicationNo(applicationNo);
	}

	/**
	* Returns the country of this trademarks.
	*
	* @return the country of this trademarks
	*/
	@Override
	public java.lang.String getCountry() {
		return _trademarks.getCountry();
	}

	/**
	* Sets the country of this trademarks.
	*
	* @param country the country of this trademarks
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_trademarks.setCountry(country);
	}

	/**
	* Returns the trademark of this trademarks.
	*
	* @return the trademark of this trademarks
	*/
	@Override
	public java.lang.String getTrademark() {
		return _trademarks.getTrademark();
	}

	/**
	* Sets the trademark of this trademarks.
	*
	* @param trademark the trademark of this trademarks
	*/
	@Override
	public void setTrademark(java.lang.String trademark) {
		_trademarks.setTrademark(trademark);
	}

	/**
	* Returns the trademark localized of this trademarks.
	*
	* @return the trademark localized of this trademarks
	*/
	@Override
	public java.lang.String getTrademarkLocalized() {
		return _trademarks.getTrademarkLocalized();
	}

	/**
	* Sets the trademark localized of this trademarks.
	*
	* @param trademarkLocalized the trademark localized of this trademarks
	*/
	@Override
	public void setTrademarkLocalized(java.lang.String trademarkLocalized) {
		_trademarks.setTrademarkLocalized(trademarkLocalized);
	}

	/**
	* Returns the registered owner of this trademarks.
	*
	* @return the registered owner of this trademarks
	*/
	@Override
	public java.lang.String getRegisteredOwner() {
		return _trademarks.getRegisteredOwner();
	}

	/**
	* Sets the registered owner of this trademarks.
	*
	* @param registeredOwner the registered owner of this trademarks
	*/
	@Override
	public void setRegisteredOwner(java.lang.String registeredOwner) {
		_trademarks.setRegisteredOwner(registeredOwner);
	}

	/**
	* Returns the application date of this trademarks.
	*
	* @return the application date of this trademarks
	*/
	@Override
	public java.util.Date getApplicationDate() {
		return _trademarks.getApplicationDate();
	}

	/**
	* Sets the application date of this trademarks.
	*
	* @param applicationDate the application date of this trademarks
	*/
	@Override
	public void setApplicationDate(java.util.Date applicationDate) {
		_trademarks.setApplicationDate(applicationDate);
	}

	/**
	* Returns the first registration date of this trademarks.
	*
	* @return the first registration date of this trademarks
	*/
	@Override
	public java.util.Date getFirstRegistrationDate() {
		return _trademarks.getFirstRegistrationDate();
	}

	/**
	* Sets the first registration date of this trademarks.
	*
	* @param firstRegistrationDate the first registration date of this trademarks
	*/
	@Override
	public void setFirstRegistrationDate(java.util.Date firstRegistrationDate) {
		_trademarks.setFirstRegistrationDate(firstRegistrationDate);
	}

	/**
	* Returns the renewal date of this trademarks.
	*
	* @return the renewal date of this trademarks
	*/
	@Override
	public java.util.Date getRenewalDate() {
		return _trademarks.getRenewalDate();
	}

	/**
	* Sets the renewal date of this trademarks.
	*
	* @param renewalDate the renewal date of this trademarks
	*/
	@Override
	public void setRenewalDate(java.util.Date renewalDate) {
		_trademarks.setRenewalDate(renewalDate);
	}

	/**
	* Returns the goods services of this trademarks.
	*
	* @return the goods services of this trademarks
	*/
	@Override
	public java.lang.String getGoodsServices() {
		return _trademarks.getGoodsServices();
	}

	/**
	* Sets the goods services of this trademarks.
	*
	* @param goodsServices the goods services of this trademarks
	*/
	@Override
	public void setGoodsServices(java.lang.String goodsServices) {
		_trademarks.setGoodsServices(goodsServices);
	}

	/**
	* Returns the pending comments of this trademarks.
	*
	* @return the pending comments of this trademarks
	*/
	@Override
	public java.lang.String getPendingComments() {
		return _trademarks.getPendingComments();
	}

	/**
	* Sets the pending comments of this trademarks.
	*
	* @param pendingComments the pending comments of this trademarks
	*/
	@Override
	public void setPendingComments(java.lang.String pendingComments) {
		_trademarks.setPendingComments(pendingComments);
	}

	/**
	* Returns the sp agency ID of this trademarks.
	*
	* @return the sp agency ID of this trademarks
	*/
	@Override
	public long getSpAgencyId() {
		return _trademarks.getSpAgencyId();
	}

	/**
	* Sets the sp agency ID of this trademarks.
	*
	* @param spAgencyId the sp agency ID of this trademarks
	*/
	@Override
	public void setSpAgencyId(long spAgencyId) {
		_trademarks.setSpAgencyId(spAgencyId);
	}

	/**
	* Returns the class description of this trademarks.
	*
	* @return the class description of this trademarks
	*/
	@Override
	public java.lang.String getClassDescription() {
		return _trademarks.getClassDescription();
	}

	/**
	* Sets the class description of this trademarks.
	*
	* @param classDescription the class description of this trademarks
	*/
	@Override
	public void setClassDescription(java.lang.String classDescription) {
		_trademarks.setClassDescription(classDescription);
	}

	/**
	* Returns the legal conf remarks of this trademarks.
	*
	* @return the legal conf remarks of this trademarks
	*/
	@Override
	public java.lang.String getLegalConfRemarks() {
		return _trademarks.getLegalConfRemarks();
	}

	/**
	* Sets the legal conf remarks of this trademarks.
	*
	* @param legalConfRemarks the legal conf remarks of this trademarks
	*/
	@Override
	public void setLegalConfRemarks(java.lang.String legalConfRemarks) {
		_trademarks.setLegalConfRemarks(legalConfRemarks);
	}

	/**
	* Returns the workflow status of this trademarks.
	*
	* @return the workflow status of this trademarks
	*/
	@Override
	public long getWorkflowStatus() {
		return _trademarks.getWorkflowStatus();
	}

	/**
	* Sets the workflow status of this trademarks.
	*
	* @param workflowStatus the workflow status of this trademarks
	*/
	@Override
	public void setWorkflowStatus(long workflowStatus) {
		_trademarks.setWorkflowStatus(workflowStatus);
	}

	/**
	* Returns the custom field1 of this trademarks.
	*
	* @return the custom field1 of this trademarks
	*/
	@Override
	public java.lang.String getCustomField1() {
		return _trademarks.getCustomField1();
	}

	/**
	* Sets the custom field1 of this trademarks.
	*
	* @param customField1 the custom field1 of this trademarks
	*/
	@Override
	public void setCustomField1(java.lang.String customField1) {
		_trademarks.setCustomField1(customField1);
	}

	/**
	* Returns the custom field2 of this trademarks.
	*
	* @return the custom field2 of this trademarks
	*/
	@Override
	public java.lang.String getCustomField2() {
		return _trademarks.getCustomField2();
	}

	/**
	* Sets the custom field2 of this trademarks.
	*
	* @param customField2 the custom field2 of this trademarks
	*/
	@Override
	public void setCustomField2(java.lang.String customField2) {
		_trademarks.setCustomField2(customField2);
	}

	/**
	* Returns the custom field3 of this trademarks.
	*
	* @return the custom field3 of this trademarks
	*/
	@Override
	public java.lang.String getCustomField3() {
		return _trademarks.getCustomField3();
	}

	/**
	* Sets the custom field3 of this trademarks.
	*
	* @param customField3 the custom field3 of this trademarks
	*/
	@Override
	public void setCustomField3(java.lang.String customField3) {
		_trademarks.setCustomField3(customField3);
	}

	/**
	* Returns the custom date1 of this trademarks.
	*
	* @return the custom date1 of this trademarks
	*/
	@Override
	public java.util.Date getCustomDate1() {
		return _trademarks.getCustomDate1();
	}

	/**
	* Sets the custom date1 of this trademarks.
	*
	* @param customDate1 the custom date1 of this trademarks
	*/
	@Override
	public void setCustomDate1(java.util.Date customDate1) {
		_trademarks.setCustomDate1(customDate1);
	}

	/**
	* Returns the custom date2 of this trademarks.
	*
	* @return the custom date2 of this trademarks
	*/
	@Override
	public java.util.Date getCustomDate2() {
		return _trademarks.getCustomDate2();
	}

	/**
	* Sets the custom date2 of this trademarks.
	*
	* @param customDate2 the custom date2 of this trademarks
	*/
	@Override
	public void setCustomDate2(java.util.Date customDate2) {
		_trademarks.setCustomDate2(customDate2);
	}

	/**
	* Returns the custom date3 of this trademarks.
	*
	* @return the custom date3 of this trademarks
	*/
	@Override
	public java.util.Date getCustomDate3() {
		return _trademarks.getCustomDate3();
	}

	/**
	* Sets the custom date3 of this trademarks.
	*
	* @param customDate3 the custom date3 of this trademarks
	*/
	@Override
	public void setCustomDate3(java.util.Date customDate3) {
		_trademarks.setCustomDate3(customDate3);
	}

	/**
	* Returns the class codes of this trademarks.
	*
	* @return the class codes of this trademarks
	*/
	@Override
	public java.lang.String getClassCodes() {
		return _trademarks.getClassCodes();
	}

	/**
	* Sets the class codes of this trademarks.
	*
	* @param classCodes the class codes of this trademarks
	*/
	@Override
	public void setClassCodes(java.lang.String classCodes) {
		_trademarks.setClassCodes(classCodes);
	}

	/**
	* Returns the version of this trademarks.
	*
	* @return the version of this trademarks
	*/
	@Override
	public java.lang.String getVersion() {
		return _trademarks.getVersion();
	}

	/**
	* Sets the version of this trademarks.
	*
	* @param version the version of this trademarks
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_trademarks.setVersion(version);
	}

	/**
	* Returns the trademark type of this trademarks.
	*
	* @return the trademark type of this trademarks
	*/
	@Override
	public java.lang.String getTrademarkType() {
		return _trademarks.getTrademarkType();
	}

	/**
	* Sets the trademark type of this trademarks.
	*
	* @param trademarkType the trademark type of this trademarks
	*/
	@Override
	public void setTrademarkType(java.lang.String trademarkType) {
		_trademarks.setTrademarkType(trademarkType);
	}

	/**
	* Returns the root sp trademarks ID of this trademarks.
	*
	* @return the root sp trademarks ID of this trademarks
	*/
	@Override
	public long getRootSpTrademarksId() {
		return _trademarks.getRootSpTrademarksId();
	}

	/**
	* Sets the root sp trademarks ID of this trademarks.
	*
	* @param rootSpTrademarksId the root sp trademarks ID of this trademarks
	*/
	@Override
	public void setRootSpTrademarksId(long rootSpTrademarksId) {
		_trademarks.setRootSpTrademarksId(rootSpTrademarksId);
	}

	@Override
	public boolean isNew() {
		return _trademarks.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_trademarks.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _trademarks.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_trademarks.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _trademarks.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _trademarks.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trademarks.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trademarks.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_trademarks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_trademarks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trademarks.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrademarksWrapper((Trademarks)_trademarks.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks) {
		return _trademarks.compareTo(trademarks);
	}

	@Override
	public int hashCode() {
		return _trademarks.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.legalandcontract.model.Trademarks> toCacheModel() {
		return _trademarks.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks toEscapedModel() {
		return new TrademarksWrapper(_trademarks.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks toUnescapedModel() {
		return new TrademarksWrapper(_trademarks.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trademarks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _trademarks.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trademarks.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrademarksWrapper)) {
			return false;
		}

		TrademarksWrapper trademarksWrapper = (TrademarksWrapper)obj;

		if (Validator.equals(_trademarks, trademarksWrapper._trademarks)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _trademarks.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Trademarks getWrappedTrademarks() {
		return _trademarks;
	}

	@Override
	public Trademarks getWrappedModel() {
		return _trademarks;
	}

	@Override
	public void resetOriginalValues() {
		_trademarks.resetOriginalValues();
	}

	private Trademarks _trademarks;
}