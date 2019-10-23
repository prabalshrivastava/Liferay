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
 * This class is a wrapper for {@link Litigation}.
 * </p>
 *
 * @author nareshchebolu
 * @see Litigation
 * @generated
 */
public class LitigationWrapper implements Litigation, ModelWrapper<Litigation> {
	public LitigationWrapper(Litigation litigation) {
		_litigation = litigation;
	}

	@Override
	public Class<?> getModelClass() {
		return Litigation.class;
	}

	@Override
	public String getModelClassName() {
		return Litigation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spLitigationId", getSpLitigationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("country", getCountry());
		attributes.put("filedBy", getFiledBy());
		attributes.put("filedOn", getFiledOn());
		attributes.put("filedAtCountry", getFiledAtCountry());
		attributes.put("claimsRemarks", getClaimsRemarks());
		attributes.put("responseDeadline", getResponseDeadline());
		attributes.put("actualResponseDate", getActualResponseDate());
		attributes.put("status", getStatus());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customField3", getCustomField3());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("customDate3", getCustomDate3());
		attributes.put("legalConfRemarks", getLegalConfRemarks());
		attributes.put("version", getVersion());
		attributes.put("spTrademarksId", getSpTrademarksId());
		attributes.put("rootSpLitigationId", getRootSpLitigationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spLitigationId = (Long)attributes.get("spLitigationId");

		if (spLitigationId != null) {
			setSpLitigationId(spLitigationId);
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

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String filedBy = (String)attributes.get("filedBy");

		if (filedBy != null) {
			setFiledBy(filedBy);
		}

		Date filedOn = (Date)attributes.get("filedOn");

		if (filedOn != null) {
			setFiledOn(filedOn);
		}

		String filedAtCountry = (String)attributes.get("filedAtCountry");

		if (filedAtCountry != null) {
			setFiledAtCountry(filedAtCountry);
		}

		String claimsRemarks = (String)attributes.get("claimsRemarks");

		if (claimsRemarks != null) {
			setClaimsRemarks(claimsRemarks);
		}

		Date responseDeadline = (Date)attributes.get("responseDeadline");

		if (responseDeadline != null) {
			setResponseDeadline(responseDeadline);
		}

		Date actualResponseDate = (Date)attributes.get("actualResponseDate");

		if (actualResponseDate != null) {
			setActualResponseDate(actualResponseDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

		String legalConfRemarks = (String)attributes.get("legalConfRemarks");

		if (legalConfRemarks != null) {
			setLegalConfRemarks(legalConfRemarks);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long spTrademarksId = (Long)attributes.get("spTrademarksId");

		if (spTrademarksId != null) {
			setSpTrademarksId(spTrademarksId);
		}

		Long rootSpLitigationId = (Long)attributes.get("rootSpLitigationId");

		if (rootSpLitigationId != null) {
			setRootSpLitigationId(rootSpLitigationId);
		}
	}

	/**
	* Returns the primary key of this litigation.
	*
	* @return the primary key of this litigation
	*/
	@Override
	public long getPrimaryKey() {
		return _litigation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this litigation.
	*
	* @param primaryKey the primary key of this litigation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_litigation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this litigation.
	*
	* @return the uuid of this litigation
	*/
	@Override
	public java.lang.String getUuid() {
		return _litigation.getUuid();
	}

	/**
	* Sets the uuid of this litigation.
	*
	* @param uuid the uuid of this litigation
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_litigation.setUuid(uuid);
	}

	/**
	* Returns the sp litigation ID of this litigation.
	*
	* @return the sp litigation ID of this litigation
	*/
	@Override
	public long getSpLitigationId() {
		return _litigation.getSpLitigationId();
	}

	/**
	* Sets the sp litigation ID of this litigation.
	*
	* @param spLitigationId the sp litigation ID of this litigation
	*/
	@Override
	public void setSpLitigationId(long spLitigationId) {
		_litigation.setSpLitigationId(spLitigationId);
	}

	/**
	* Returns the group ID of this litigation.
	*
	* @return the group ID of this litigation
	*/
	@Override
	public long getGroupId() {
		return _litigation.getGroupId();
	}

	/**
	* Sets the group ID of this litigation.
	*
	* @param groupId the group ID of this litigation
	*/
	@Override
	public void setGroupId(long groupId) {
		_litigation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this litigation.
	*
	* @return the company ID of this litigation
	*/
	@Override
	public long getCompanyId() {
		return _litigation.getCompanyId();
	}

	/**
	* Sets the company ID of this litigation.
	*
	* @param companyId the company ID of this litigation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_litigation.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this litigation.
	*
	* @return the user ID of this litigation
	*/
	@Override
	public long getUserId() {
		return _litigation.getUserId();
	}

	/**
	* Sets the user ID of this litigation.
	*
	* @param userId the user ID of this litigation
	*/
	@Override
	public void setUserId(long userId) {
		_litigation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this litigation.
	*
	* @return the user uuid of this litigation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigation.getUserUuid();
	}

	/**
	* Sets the user uuid of this litigation.
	*
	* @param userUuid the user uuid of this litigation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_litigation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this litigation.
	*
	* @return the user name of this litigation
	*/
	@Override
	public java.lang.String getUserName() {
		return _litigation.getUserName();
	}

	/**
	* Sets the user name of this litigation.
	*
	* @param userName the user name of this litigation
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_litigation.setUserName(userName);
	}

	/**
	* Returns the create date of this litigation.
	*
	* @return the create date of this litigation
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _litigation.getCreateDate();
	}

	/**
	* Sets the create date of this litigation.
	*
	* @param createDate the create date of this litigation
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_litigation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this litigation.
	*
	* @return the modified date of this litigation
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _litigation.getModifiedDate();
	}

	/**
	* Sets the modified date of this litigation.
	*
	* @param modifiedDate the modified date of this litigation
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_litigation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country of this litigation.
	*
	* @return the country of this litigation
	*/
	@Override
	public java.lang.String getCountry() {
		return _litigation.getCountry();
	}

	/**
	* Sets the country of this litigation.
	*
	* @param country the country of this litigation
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_litigation.setCountry(country);
	}

	/**
	* Returns the filed by of this litigation.
	*
	* @return the filed by of this litigation
	*/
	@Override
	public java.lang.String getFiledBy() {
		return _litigation.getFiledBy();
	}

	/**
	* Sets the filed by of this litigation.
	*
	* @param filedBy the filed by of this litigation
	*/
	@Override
	public void setFiledBy(java.lang.String filedBy) {
		_litigation.setFiledBy(filedBy);
	}

	/**
	* Returns the filed on of this litigation.
	*
	* @return the filed on of this litigation
	*/
	@Override
	public java.util.Date getFiledOn() {
		return _litigation.getFiledOn();
	}

	/**
	* Sets the filed on of this litigation.
	*
	* @param filedOn the filed on of this litigation
	*/
	@Override
	public void setFiledOn(java.util.Date filedOn) {
		_litigation.setFiledOn(filedOn);
	}

	/**
	* Returns the filed at country of this litigation.
	*
	* @return the filed at country of this litigation
	*/
	@Override
	public java.lang.String getFiledAtCountry() {
		return _litigation.getFiledAtCountry();
	}

	/**
	* Sets the filed at country of this litigation.
	*
	* @param filedAtCountry the filed at country of this litigation
	*/
	@Override
	public void setFiledAtCountry(java.lang.String filedAtCountry) {
		_litigation.setFiledAtCountry(filedAtCountry);
	}

	/**
	* Returns the claims remarks of this litigation.
	*
	* @return the claims remarks of this litigation
	*/
	@Override
	public java.lang.String getClaimsRemarks() {
		return _litigation.getClaimsRemarks();
	}

	/**
	* Sets the claims remarks of this litigation.
	*
	* @param claimsRemarks the claims remarks of this litigation
	*/
	@Override
	public void setClaimsRemarks(java.lang.String claimsRemarks) {
		_litigation.setClaimsRemarks(claimsRemarks);
	}

	/**
	* Returns the response deadline of this litigation.
	*
	* @return the response deadline of this litigation
	*/
	@Override
	public java.util.Date getResponseDeadline() {
		return _litigation.getResponseDeadline();
	}

	/**
	* Sets the response deadline of this litigation.
	*
	* @param responseDeadline the response deadline of this litigation
	*/
	@Override
	public void setResponseDeadline(java.util.Date responseDeadline) {
		_litigation.setResponseDeadline(responseDeadline);
	}

	/**
	* Returns the actual response date of this litigation.
	*
	* @return the actual response date of this litigation
	*/
	@Override
	public java.util.Date getActualResponseDate() {
		return _litigation.getActualResponseDate();
	}

	/**
	* Sets the actual response date of this litigation.
	*
	* @param actualResponseDate the actual response date of this litigation
	*/
	@Override
	public void setActualResponseDate(java.util.Date actualResponseDate) {
		_litigation.setActualResponseDate(actualResponseDate);
	}

	/**
	* Returns the status of this litigation.
	*
	* @return the status of this litigation
	*/
	@Override
	public java.lang.String getStatus() {
		return _litigation.getStatus();
	}

	/**
	* Sets the status of this litigation.
	*
	* @param status the status of this litigation
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_litigation.setStatus(status);
	}

	/**
	* Returns the custom field1 of this litigation.
	*
	* @return the custom field1 of this litigation
	*/
	@Override
	public java.lang.String getCustomField1() {
		return _litigation.getCustomField1();
	}

	/**
	* Sets the custom field1 of this litigation.
	*
	* @param customField1 the custom field1 of this litigation
	*/
	@Override
	public void setCustomField1(java.lang.String customField1) {
		_litigation.setCustomField1(customField1);
	}

	/**
	* Returns the custom field2 of this litigation.
	*
	* @return the custom field2 of this litigation
	*/
	@Override
	public java.lang.String getCustomField2() {
		return _litigation.getCustomField2();
	}

	/**
	* Sets the custom field2 of this litigation.
	*
	* @param customField2 the custom field2 of this litigation
	*/
	@Override
	public void setCustomField2(java.lang.String customField2) {
		_litigation.setCustomField2(customField2);
	}

	/**
	* Returns the custom field3 of this litigation.
	*
	* @return the custom field3 of this litigation
	*/
	@Override
	public java.lang.String getCustomField3() {
		return _litigation.getCustomField3();
	}

	/**
	* Sets the custom field3 of this litigation.
	*
	* @param customField3 the custom field3 of this litigation
	*/
	@Override
	public void setCustomField3(java.lang.String customField3) {
		_litigation.setCustomField3(customField3);
	}

	/**
	* Returns the custom date1 of this litigation.
	*
	* @return the custom date1 of this litigation
	*/
	@Override
	public java.util.Date getCustomDate1() {
		return _litigation.getCustomDate1();
	}

	/**
	* Sets the custom date1 of this litigation.
	*
	* @param customDate1 the custom date1 of this litigation
	*/
	@Override
	public void setCustomDate1(java.util.Date customDate1) {
		_litigation.setCustomDate1(customDate1);
	}

	/**
	* Returns the custom date2 of this litigation.
	*
	* @return the custom date2 of this litigation
	*/
	@Override
	public java.util.Date getCustomDate2() {
		return _litigation.getCustomDate2();
	}

	/**
	* Sets the custom date2 of this litigation.
	*
	* @param customDate2 the custom date2 of this litigation
	*/
	@Override
	public void setCustomDate2(java.util.Date customDate2) {
		_litigation.setCustomDate2(customDate2);
	}

	/**
	* Returns the custom date3 of this litigation.
	*
	* @return the custom date3 of this litigation
	*/
	@Override
	public java.util.Date getCustomDate3() {
		return _litigation.getCustomDate3();
	}

	/**
	* Sets the custom date3 of this litigation.
	*
	* @param customDate3 the custom date3 of this litigation
	*/
	@Override
	public void setCustomDate3(java.util.Date customDate3) {
		_litigation.setCustomDate3(customDate3);
	}

	/**
	* Returns the legal conf remarks of this litigation.
	*
	* @return the legal conf remarks of this litigation
	*/
	@Override
	public java.lang.String getLegalConfRemarks() {
		return _litigation.getLegalConfRemarks();
	}

	/**
	* Sets the legal conf remarks of this litigation.
	*
	* @param legalConfRemarks the legal conf remarks of this litigation
	*/
	@Override
	public void setLegalConfRemarks(java.lang.String legalConfRemarks) {
		_litigation.setLegalConfRemarks(legalConfRemarks);
	}

	/**
	* Returns the version of this litigation.
	*
	* @return the version of this litigation
	*/
	@Override
	public java.lang.String getVersion() {
		return _litigation.getVersion();
	}

	/**
	* Sets the version of this litigation.
	*
	* @param version the version of this litigation
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_litigation.setVersion(version);
	}

	/**
	* Returns the sp trademarks ID of this litigation.
	*
	* @return the sp trademarks ID of this litigation
	*/
	@Override
	public long getSpTrademarksId() {
		return _litigation.getSpTrademarksId();
	}

	/**
	* Sets the sp trademarks ID of this litigation.
	*
	* @param spTrademarksId the sp trademarks ID of this litigation
	*/
	@Override
	public void setSpTrademarksId(long spTrademarksId) {
		_litigation.setSpTrademarksId(spTrademarksId);
	}

	/**
	* Returns the root sp litigation ID of this litigation.
	*
	* @return the root sp litigation ID of this litigation
	*/
	@Override
	public long getRootSpLitigationId() {
		return _litigation.getRootSpLitigationId();
	}

	/**
	* Sets the root sp litigation ID of this litigation.
	*
	* @param rootSpLitigationId the root sp litigation ID of this litigation
	*/
	@Override
	public void setRootSpLitigationId(long rootSpLitigationId) {
		_litigation.setRootSpLitigationId(rootSpLitigationId);
	}

	@Override
	public boolean isNew() {
		return _litigation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_litigation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _litigation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_litigation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _litigation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _litigation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_litigation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _litigation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_litigation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_litigation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_litigation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LitigationWrapper((Litigation)_litigation.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation) {
		return _litigation.compareTo(litigation);
	}

	@Override
	public int hashCode() {
		return _litigation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.legalandcontract.model.Litigation> toCacheModel() {
		return _litigation.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation toEscapedModel() {
		return new LitigationWrapper(_litigation.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation toUnescapedModel() {
		return new LitigationWrapper(_litigation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _litigation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _litigation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_litigation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LitigationWrapper)) {
			return false;
		}

		LitigationWrapper litigationWrapper = (LitigationWrapper)obj;

		if (Validator.equals(_litigation, litigationWrapper._litigation)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _litigation.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Litigation getWrappedLitigation() {
		return _litigation;
	}

	@Override
	public Litigation getWrappedModel() {
		return _litigation;
	}

	@Override
	public void resetOriginalValues() {
		_litigation.resetOriginalValues();
	}

	private Litigation _litigation;
}