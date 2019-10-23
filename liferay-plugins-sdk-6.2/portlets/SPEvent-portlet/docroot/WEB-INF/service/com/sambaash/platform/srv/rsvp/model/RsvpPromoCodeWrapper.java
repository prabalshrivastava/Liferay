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
 * This class is a wrapper for {@link RsvpPromoCode}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCode
 * @generated
 */
public class RsvpPromoCodeWrapper implements RsvpPromoCode,
	ModelWrapper<RsvpPromoCode> {
	public RsvpPromoCodeWrapper(RsvpPromoCode rsvpPromoCode) {
		_rsvpPromoCode = rsvpPromoCode;
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpPromoCode.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpPromoCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpPromoCodeId", getRsvpPromoCodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("promoCode", getPromoCode());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("noOfTickets", getNoOfTickets());
		attributes.put("discount", getDiscount());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpPromoCodeId = (Long)attributes.get("rsvpPromoCodeId");

		if (rsvpPromoCodeId != null) {
			setRsvpPromoCodeId(rsvpPromoCodeId);
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

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
		}

		String promoCode = (String)attributes.get("promoCode");

		if (promoCode != null) {
			setPromoCode(promoCode);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Integer noOfTickets = (Integer)attributes.get("noOfTickets");

		if (noOfTickets != null) {
			setNoOfTickets(noOfTickets);
		}

		Integer discount = (Integer)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	/**
	* Returns the primary key of this rsvp promo code.
	*
	* @return the primary key of this rsvp promo code
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvpPromoCode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp promo code.
	*
	* @param primaryKey the primary key of this rsvp promo code
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvpPromoCode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp promo code.
	*
	* @return the uuid of this rsvp promo code
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvpPromoCode.getUuid();
	}

	/**
	* Sets the uuid of this rsvp promo code.
	*
	* @param uuid the uuid of this rsvp promo code
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvpPromoCode.setUuid(uuid);
	}

	/**
	* Returns the rsvp promo code ID of this rsvp promo code.
	*
	* @return the rsvp promo code ID of this rsvp promo code
	*/
	@Override
	public long getRsvpPromoCodeId() {
		return _rsvpPromoCode.getRsvpPromoCodeId();
	}

	/**
	* Sets the rsvp promo code ID of this rsvp promo code.
	*
	* @param rsvpPromoCodeId the rsvp promo code ID of this rsvp promo code
	*/
	@Override
	public void setRsvpPromoCodeId(long rsvpPromoCodeId) {
		_rsvpPromoCode.setRsvpPromoCodeId(rsvpPromoCodeId);
	}

	/**
	* Returns the group ID of this rsvp promo code.
	*
	* @return the group ID of this rsvp promo code
	*/
	@Override
	public long getGroupId() {
		return _rsvpPromoCode.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp promo code.
	*
	* @param groupId the group ID of this rsvp promo code
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvpPromoCode.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp promo code.
	*
	* @return the company ID of this rsvp promo code
	*/
	@Override
	public long getCompanyId() {
		return _rsvpPromoCode.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp promo code.
	*
	* @param companyId the company ID of this rsvp promo code
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvpPromoCode.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rsvp promo code.
	*
	* @return the user ID of this rsvp promo code
	*/
	@Override
	public long getUserId() {
		return _rsvpPromoCode.getUserId();
	}

	/**
	* Sets the user ID of this rsvp promo code.
	*
	* @param userId the user ID of this rsvp promo code
	*/
	@Override
	public void setUserId(long userId) {
		_rsvpPromoCode.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp promo code.
	*
	* @return the user uuid of this rsvp promo code
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCode.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp promo code.
	*
	* @param userUuid the user uuid of this rsvp promo code
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvpPromoCode.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rsvp promo code.
	*
	* @return the user name of this rsvp promo code
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvpPromoCode.getUserName();
	}

	/**
	* Sets the user name of this rsvp promo code.
	*
	* @param userName the user name of this rsvp promo code
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvpPromoCode.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp promo code.
	*
	* @return the create date of this rsvp promo code
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvpPromoCode.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp promo code.
	*
	* @param createDate the create date of this rsvp promo code
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvpPromoCode.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp promo code.
	*
	* @return the modified date of this rsvp promo code
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvpPromoCode.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp promo code.
	*
	* @param modifiedDate the modified date of this rsvp promo code
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvpPromoCode.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rsvp ID of this rsvp promo code.
	*
	* @return the rsvp ID of this rsvp promo code
	*/
	@Override
	public long getRsvpId() {
		return _rsvpPromoCode.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this rsvp promo code.
	*
	* @param rsvpId the rsvp ID of this rsvp promo code
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpPromoCode.setRsvpId(rsvpId);
	}

	/**
	* Returns the rsvp ticket ID of this rsvp promo code.
	*
	* @return the rsvp ticket ID of this rsvp promo code
	*/
	@Override
	public long getRsvpTicketId() {
		return _rsvpPromoCode.getRsvpTicketId();
	}

	/**
	* Sets the rsvp ticket ID of this rsvp promo code.
	*
	* @param rsvpTicketId the rsvp ticket ID of this rsvp promo code
	*/
	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpPromoCode.setRsvpTicketId(rsvpTicketId);
	}

	/**
	* Returns the promo code of this rsvp promo code.
	*
	* @return the promo code of this rsvp promo code
	*/
	@Override
	public java.lang.String getPromoCode() {
		return _rsvpPromoCode.getPromoCode();
	}

	/**
	* Sets the promo code of this rsvp promo code.
	*
	* @param promoCode the promo code of this rsvp promo code
	*/
	@Override
	public void setPromoCode(java.lang.String promoCode) {
		_rsvpPromoCode.setPromoCode(promoCode);
	}

	/**
	* Returns the from date of this rsvp promo code.
	*
	* @return the from date of this rsvp promo code
	*/
	@Override
	public java.util.Date getFromDate() {
		return _rsvpPromoCode.getFromDate();
	}

	/**
	* Sets the from date of this rsvp promo code.
	*
	* @param fromDate the from date of this rsvp promo code
	*/
	@Override
	public void setFromDate(java.util.Date fromDate) {
		_rsvpPromoCode.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this rsvp promo code.
	*
	* @return the to date of this rsvp promo code
	*/
	@Override
	public java.util.Date getToDate() {
		return _rsvpPromoCode.getToDate();
	}

	/**
	* Sets the to date of this rsvp promo code.
	*
	* @param toDate the to date of this rsvp promo code
	*/
	@Override
	public void setToDate(java.util.Date toDate) {
		_rsvpPromoCode.setToDate(toDate);
	}

	/**
	* Returns the no of tickets of this rsvp promo code.
	*
	* @return the no of tickets of this rsvp promo code
	*/
	@Override
	public int getNoOfTickets() {
		return _rsvpPromoCode.getNoOfTickets();
	}

	/**
	* Sets the no of tickets of this rsvp promo code.
	*
	* @param noOfTickets the no of tickets of this rsvp promo code
	*/
	@Override
	public void setNoOfTickets(int noOfTickets) {
		_rsvpPromoCode.setNoOfTickets(noOfTickets);
	}

	/**
	* Returns the discount of this rsvp promo code.
	*
	* @return the discount of this rsvp promo code
	*/
	@Override
	public int getDiscount() {
		return _rsvpPromoCode.getDiscount();
	}

	/**
	* Sets the discount of this rsvp promo code.
	*
	* @param discount the discount of this rsvp promo code
	*/
	@Override
	public void setDiscount(int discount) {
		_rsvpPromoCode.setDiscount(discount);
	}

	/**
	* Returns the modified by of this rsvp promo code.
	*
	* @return the modified by of this rsvp promo code
	*/
	@Override
	public long getModifiedBy() {
		return _rsvpPromoCode.getModifiedBy();
	}

	/**
	* Sets the modified by of this rsvp promo code.
	*
	* @param modifiedBy the modified by of this rsvp promo code
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_rsvpPromoCode.setModifiedBy(modifiedBy);
	}

	@Override
	public boolean isNew() {
		return _rsvpPromoCode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvpPromoCode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvpPromoCode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvpPromoCode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvpPromoCode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvpPromoCode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvpPromoCode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvpPromoCode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvpPromoCode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvpPromoCode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvpPromoCode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpPromoCodeWrapper((RsvpPromoCode)_rsvpPromoCode.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode) {
		return _rsvpPromoCode.compareTo(rsvpPromoCode);
	}

	@Override
	public int hashCode() {
		return _rsvpPromoCode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> toCacheModel() {
		return _rsvpPromoCode.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode toEscapedModel() {
		return new RsvpPromoCodeWrapper(_rsvpPromoCode.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode toUnescapedModel() {
		return new RsvpPromoCodeWrapper(_rsvpPromoCode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvpPromoCode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvpPromoCode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvpPromoCode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpPromoCodeWrapper)) {
			return false;
		}

		RsvpPromoCodeWrapper rsvpPromoCodeWrapper = (RsvpPromoCodeWrapper)obj;

		if (Validator.equals(_rsvpPromoCode, rsvpPromoCodeWrapper._rsvpPromoCode)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvpPromoCode.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RsvpPromoCode getWrappedRsvpPromoCode() {
		return _rsvpPromoCode;
	}

	@Override
	public RsvpPromoCode getWrappedModel() {
		return _rsvpPromoCode;
	}

	@Override
	public void resetOriginalValues() {
		_rsvpPromoCode.resetOriginalValues();
	}

	private RsvpPromoCode _rsvpPromoCode;
}