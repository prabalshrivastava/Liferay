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

package com.sambaash.platform.srv.rsvp.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Rsvp}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Rsvp
 * @generated
 */
public class RsvpWrapper implements Rsvp, ModelWrapper<Rsvp> {
	public RsvpWrapper(Rsvp rsvp) {
		_rsvp = rsvp;
	}

	@Override
	public Class<?> getModelClass() {
		return Rsvp.class;
	}

	@Override
	public String getModelClassName() {
		return Rsvp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("eventId", getEventId());
		attributes.put("spAssetTypeId", getSpAssetTypeId());
		attributes.put("status", getStatus());
		attributes.put("rsvpUrl", getRsvpUrl());
		attributes.put("processing", getProcessing());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tax", getTax());
		attributes.put("accountId", getAccountId());
		attributes.put("paymentFlag", getPaymentFlag());
		attributes.put("registerFlag", getRegisterFlag());
		attributes.put("ticketFlag", getTicketFlag());
		attributes.put("dynamicSectionName", getDynamicSectionName());
		attributes.put("ccEmail", getCcEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long spAssetTypeId = (Long)attributes.get("spAssetTypeId");

		if (spAssetTypeId != null) {
			setSpAssetTypeId(spAssetTypeId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String rsvpUrl = (String)attributes.get("rsvpUrl");

		if (rsvpUrl != null) {
			setRsvpUrl(rsvpUrl);
		}

		Integer processing = (Integer)attributes.get("processing");

		if (processing != null) {
			setProcessing(processing);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String tax = (String)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		String accountId = (String)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Boolean paymentFlag = (Boolean)attributes.get("paymentFlag");

		if (paymentFlag != null) {
			setPaymentFlag(paymentFlag);
		}

		Boolean registerFlag = (Boolean)attributes.get("registerFlag");

		if (registerFlag != null) {
			setRegisterFlag(registerFlag);
		}

		Boolean ticketFlag = (Boolean)attributes.get("ticketFlag");

		if (ticketFlag != null) {
			setTicketFlag(ticketFlag);
		}

		String dynamicSectionName = (String)attributes.get("dynamicSectionName");

		if (dynamicSectionName != null) {
			setDynamicSectionName(dynamicSectionName);
		}

		Boolean ccEmail = (Boolean)attributes.get("ccEmail");

		if (ccEmail != null) {
			setCcEmail(ccEmail);
		}
	}

	/**
	* Returns the primary key of this rsvp.
	*
	* @return the primary key of this rsvp
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp.
	*
	* @param primaryKey the primary key of this rsvp
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp.
	*
	* @return the uuid of this rsvp
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvp.getUuid();
	}

	/**
	* Sets the uuid of this rsvp.
	*
	* @param uuid the uuid of this rsvp
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvp.setUuid(uuid);
	}

	/**
	* Returns the rsvp ID of this rsvp.
	*
	* @return the rsvp ID of this rsvp
	*/
	@Override
	public long getRsvpId() {
		return _rsvp.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this rsvp.
	*
	* @param rsvpId the rsvp ID of this rsvp
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_rsvp.setRsvpId(rsvpId);
	}

	/**
	* Returns the group ID of this rsvp.
	*
	* @return the group ID of this rsvp
	*/
	@Override
	public long getGroupId() {
		return _rsvp.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp.
	*
	* @param groupId the group ID of this rsvp
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvp.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp.
	*
	* @return the company ID of this rsvp
	*/
	@Override
	public long getCompanyId() {
		return _rsvp.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp.
	*
	* @param companyId the company ID of this rsvp
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvp.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rsvp.
	*
	* @return the user ID of this rsvp
	*/
	@Override
	public long getUserId() {
		return _rsvp.getUserId();
	}

	/**
	* Sets the user ID of this rsvp.
	*
	* @param userId the user ID of this rsvp
	*/
	@Override
	public void setUserId(long userId) {
		_rsvp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp.
	*
	* @return the user uuid of this rsvp
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvp.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp.
	*
	* @param userUuid the user uuid of this rsvp
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvp.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rsvp.
	*
	* @return the user name of this rsvp
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvp.getUserName();
	}

	/**
	* Sets the user name of this rsvp.
	*
	* @param userName the user name of this rsvp
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvp.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp.
	*
	* @return the create date of this rsvp
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvp.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp.
	*
	* @param createDate the create date of this rsvp
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvp.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp.
	*
	* @return the modified date of this rsvp
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvp.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp.
	*
	* @param modifiedDate the modified date of this rsvp
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvp.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this rsvp.
	*
	* @return the title of this rsvp
	*/
	@Override
	public java.lang.String getTitle() {
		return _rsvp.getTitle();
	}

	/**
	* Sets the title of this rsvp.
	*
	* @param title the title of this rsvp
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_rsvp.setTitle(title);
	}

	/**
	* Returns the description of this rsvp.
	*
	* @return the description of this rsvp
	*/
	@Override
	public java.lang.String getDescription() {
		return _rsvp.getDescription();
	}

	/**
	* Sets the description of this rsvp.
	*
	* @param description the description of this rsvp
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_rsvp.setDescription(description);
	}

	/**
	* Returns the event ID of this rsvp.
	*
	* @return the event ID of this rsvp
	*/
	@Override
	public long getEventId() {
		return _rsvp.getEventId();
	}

	/**
	* Sets the event ID of this rsvp.
	*
	* @param eventId the event ID of this rsvp
	*/
	@Override
	public void setEventId(long eventId) {
		_rsvp.setEventId(eventId);
	}

	/**
	* Returns the sp asset type ID of this rsvp.
	*
	* @return the sp asset type ID of this rsvp
	*/
	@Override
	public long getSpAssetTypeId() {
		return _rsvp.getSpAssetTypeId();
	}

	/**
	* Sets the sp asset type ID of this rsvp.
	*
	* @param spAssetTypeId the sp asset type ID of this rsvp
	*/
	@Override
	public void setSpAssetTypeId(long spAssetTypeId) {
		_rsvp.setSpAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the status of this rsvp.
	*
	* @return the status of this rsvp
	*/
	@Override
	public boolean getStatus() {
		return _rsvp.getStatus();
	}

	/**
	* Returns <code>true</code> if this rsvp is status.
	*
	* @return <code>true</code> if this rsvp is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _rsvp.isStatus();
	}

	/**
	* Sets whether this rsvp is status.
	*
	* @param status the status of this rsvp
	*/
	@Override
	public void setStatus(boolean status) {
		_rsvp.setStatus(status);
	}

	/**
	* Returns the rsvp url of this rsvp.
	*
	* @return the rsvp url of this rsvp
	*/
	@Override
	public java.lang.String getRsvpUrl() {
		return _rsvp.getRsvpUrl();
	}

	/**
	* Sets the rsvp url of this rsvp.
	*
	* @param rsvpUrl the rsvp url of this rsvp
	*/
	@Override
	public void setRsvpUrl(java.lang.String rsvpUrl) {
		_rsvp.setRsvpUrl(rsvpUrl);
	}

	/**
	* Returns the processing of this rsvp.
	*
	* @return the processing of this rsvp
	*/
	@Override
	public int getProcessing() {
		return _rsvp.getProcessing();
	}

	/**
	* Sets the processing of this rsvp.
	*
	* @param processing the processing of this rsvp
	*/
	@Override
	public void setProcessing(int processing) {
		_rsvp.setProcessing(processing);
	}

	/**
	* Returns the price of this rsvp.
	*
	* @return the price of this rsvp
	*/
	@Override
	public java.lang.String getPrice() {
		return _rsvp.getPrice();
	}

	/**
	* Sets the price of this rsvp.
	*
	* @param price the price of this rsvp
	*/
	@Override
	public void setPrice(java.lang.String price) {
		_rsvp.setPrice(price);
	}

	/**
	* Returns the currency of this rsvp.
	*
	* @return the currency of this rsvp
	*/
	@Override
	public java.lang.String getCurrency() {
		return _rsvp.getCurrency();
	}

	/**
	* Sets the currency of this rsvp.
	*
	* @param currency the currency of this rsvp
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_rsvp.setCurrency(currency);
	}

	/**
	* Returns the tax of this rsvp.
	*
	* @return the tax of this rsvp
	*/
	@Override
	public java.lang.String getTax() {
		return _rsvp.getTax();
	}

	/**
	* Sets the tax of this rsvp.
	*
	* @param tax the tax of this rsvp
	*/
	@Override
	public void setTax(java.lang.String tax) {
		_rsvp.setTax(tax);
	}

	/**
	* Returns the account ID of this rsvp.
	*
	* @return the account ID of this rsvp
	*/
	@Override
	public java.lang.String getAccountId() {
		return _rsvp.getAccountId();
	}

	/**
	* Sets the account ID of this rsvp.
	*
	* @param accountId the account ID of this rsvp
	*/
	@Override
	public void setAccountId(java.lang.String accountId) {
		_rsvp.setAccountId(accountId);
	}

	/**
	* Returns the payment flag of this rsvp.
	*
	* @return the payment flag of this rsvp
	*/
	@Override
	public boolean getPaymentFlag() {
		return _rsvp.getPaymentFlag();
	}

	/**
	* Returns <code>true</code> if this rsvp is payment flag.
	*
	* @return <code>true</code> if this rsvp is payment flag; <code>false</code> otherwise
	*/
	@Override
	public boolean isPaymentFlag() {
		return _rsvp.isPaymentFlag();
	}

	/**
	* Sets whether this rsvp is payment flag.
	*
	* @param paymentFlag the payment flag of this rsvp
	*/
	@Override
	public void setPaymentFlag(boolean paymentFlag) {
		_rsvp.setPaymentFlag(paymentFlag);
	}

	/**
	* Returns the register flag of this rsvp.
	*
	* @return the register flag of this rsvp
	*/
	@Override
	public boolean getRegisterFlag() {
		return _rsvp.getRegisterFlag();
	}

	/**
	* Returns <code>true</code> if this rsvp is register flag.
	*
	* @return <code>true</code> if this rsvp is register flag; <code>false</code> otherwise
	*/
	@Override
	public boolean isRegisterFlag() {
		return _rsvp.isRegisterFlag();
	}

	/**
	* Sets whether this rsvp is register flag.
	*
	* @param registerFlag the register flag of this rsvp
	*/
	@Override
	public void setRegisterFlag(boolean registerFlag) {
		_rsvp.setRegisterFlag(registerFlag);
	}

	/**
	* Returns the ticket flag of this rsvp.
	*
	* @return the ticket flag of this rsvp
	*/
	@Override
	public boolean getTicketFlag() {
		return _rsvp.getTicketFlag();
	}

	/**
	* Returns <code>true</code> if this rsvp is ticket flag.
	*
	* @return <code>true</code> if this rsvp is ticket flag; <code>false</code> otherwise
	*/
	@Override
	public boolean isTicketFlag() {
		return _rsvp.isTicketFlag();
	}

	/**
	* Sets whether this rsvp is ticket flag.
	*
	* @param ticketFlag the ticket flag of this rsvp
	*/
	@Override
	public void setTicketFlag(boolean ticketFlag) {
		_rsvp.setTicketFlag(ticketFlag);
	}

	/**
	* Returns the dynamic section name of this rsvp.
	*
	* @return the dynamic section name of this rsvp
	*/
	@Override
	public java.lang.String getDynamicSectionName() {
		return _rsvp.getDynamicSectionName();
	}

	/**
	* Sets the dynamic section name of this rsvp.
	*
	* @param dynamicSectionName the dynamic section name of this rsvp
	*/
	@Override
	public void setDynamicSectionName(java.lang.String dynamicSectionName) {
		_rsvp.setDynamicSectionName(dynamicSectionName);
	}

	/**
	* Returns the cc email of this rsvp.
	*
	* @return the cc email of this rsvp
	*/
	@Override
	public boolean getCcEmail() {
		return _rsvp.getCcEmail();
	}

	/**
	* Returns <code>true</code> if this rsvp is cc email.
	*
	* @return <code>true</code> if this rsvp is cc email; <code>false</code> otherwise
	*/
	@Override
	public boolean isCcEmail() {
		return _rsvp.isCcEmail();
	}

	/**
	* Sets whether this rsvp is cc email.
	*
	* @param ccEmail the cc email of this rsvp
	*/
	@Override
	public void setCcEmail(boolean ccEmail) {
		_rsvp.setCcEmail(ccEmail);
	}

	@Override
	public boolean isNew() {
		return _rsvp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpWrapper((Rsvp)_rsvp.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.rsvp.model.Rsvp rsvp) {
		return _rsvp.compareTo(rsvp);
	}

	@Override
	public int hashCode() {
		return _rsvp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.Rsvp> toCacheModel() {
		return _rsvp.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp toEscapedModel() {
		return new RsvpWrapper(_rsvp.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.Rsvp toUnescapedModel() {
		return new RsvpWrapper(_rsvp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpWrapper)) {
			return false;
		}

		RsvpWrapper rsvpWrapper = (RsvpWrapper)obj;

		if (Validator.equals(_rsvp, rsvpWrapper._rsvp)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvp.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Rsvp getWrappedRsvp() {
		return _rsvp;
	}

	@Override
	public Rsvp getWrappedModel() {
		return _rsvp;
	}

	@Override
	public void resetOriginalValues() {
		_rsvp.resetOriginalValues();
	}

	private Rsvp _rsvp;
}