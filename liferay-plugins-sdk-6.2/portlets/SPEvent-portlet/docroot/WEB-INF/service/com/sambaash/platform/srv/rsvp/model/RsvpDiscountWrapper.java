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
 * This class is a wrapper for {@link RsvpDiscount}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDiscount
 * @generated
 */
public class RsvpDiscountWrapper implements RsvpDiscount,
	ModelWrapper<RsvpDiscount> {
	public RsvpDiscountWrapper(RsvpDiscount rsvpDiscount) {
		_rsvpDiscount = rsvpDiscount;
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpDiscount.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpDiscount.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpDiscountId", getRsvpDiscountId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("rsvpTicketId", getRsvpTicketId());
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

		Long rsvpDiscountId = (Long)attributes.get("rsvpDiscountId");

		if (rsvpDiscountId != null) {
			setRsvpDiscountId(rsvpDiscountId);
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

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	/**
	* Returns the primary key of this rsvp discount.
	*
	* @return the primary key of this rsvp discount
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvpDiscount.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp discount.
	*
	* @param primaryKey the primary key of this rsvp discount
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvpDiscount.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp discount.
	*
	* @return the uuid of this rsvp discount
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvpDiscount.getUuid();
	}

	/**
	* Sets the uuid of this rsvp discount.
	*
	* @param uuid the uuid of this rsvp discount
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvpDiscount.setUuid(uuid);
	}

	/**
	* Returns the rsvp discount ID of this rsvp discount.
	*
	* @return the rsvp discount ID of this rsvp discount
	*/
	@Override
	public long getRsvpDiscountId() {
		return _rsvpDiscount.getRsvpDiscountId();
	}

	/**
	* Sets the rsvp discount ID of this rsvp discount.
	*
	* @param rsvpDiscountId the rsvp discount ID of this rsvp discount
	*/
	@Override
	public void setRsvpDiscountId(long rsvpDiscountId) {
		_rsvpDiscount.setRsvpDiscountId(rsvpDiscountId);
	}

	/**
	* Returns the group ID of this rsvp discount.
	*
	* @return the group ID of this rsvp discount
	*/
	@Override
	public long getGroupId() {
		return _rsvpDiscount.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp discount.
	*
	* @param groupId the group ID of this rsvp discount
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvpDiscount.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp discount.
	*
	* @return the company ID of this rsvp discount
	*/
	@Override
	public long getCompanyId() {
		return _rsvpDiscount.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp discount.
	*
	* @param companyId the company ID of this rsvp discount
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvpDiscount.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rsvp discount.
	*
	* @return the user ID of this rsvp discount
	*/
	@Override
	public long getUserId() {
		return _rsvpDiscount.getUserId();
	}

	/**
	* Sets the user ID of this rsvp discount.
	*
	* @param userId the user ID of this rsvp discount
	*/
	@Override
	public void setUserId(long userId) {
		_rsvpDiscount.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp discount.
	*
	* @return the user uuid of this rsvp discount
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDiscount.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp discount.
	*
	* @param userUuid the user uuid of this rsvp discount
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvpDiscount.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rsvp discount.
	*
	* @return the user name of this rsvp discount
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvpDiscount.getUserName();
	}

	/**
	* Sets the user name of this rsvp discount.
	*
	* @param userName the user name of this rsvp discount
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvpDiscount.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp discount.
	*
	* @return the create date of this rsvp discount
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvpDiscount.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp discount.
	*
	* @param createDate the create date of this rsvp discount
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvpDiscount.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp discount.
	*
	* @return the modified date of this rsvp discount
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvpDiscount.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp discount.
	*
	* @param modifiedDate the modified date of this rsvp discount
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvpDiscount.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rsvp ID of this rsvp discount.
	*
	* @return the rsvp ID of this rsvp discount
	*/
	@Override
	public long getRsvpId() {
		return _rsvpDiscount.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this rsvp discount.
	*
	* @param rsvpId the rsvp ID of this rsvp discount
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpDiscount.setRsvpId(rsvpId);
	}

	/**
	* Returns the rsvp ticket ID of this rsvp discount.
	*
	* @return the rsvp ticket ID of this rsvp discount
	*/
	@Override
	public long getRsvpTicketId() {
		return _rsvpDiscount.getRsvpTicketId();
	}

	/**
	* Sets the rsvp ticket ID of this rsvp discount.
	*
	* @param rsvpTicketId the rsvp ticket ID of this rsvp discount
	*/
	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpDiscount.setRsvpTicketId(rsvpTicketId);
	}

	/**
	* Returns the from date of this rsvp discount.
	*
	* @return the from date of this rsvp discount
	*/
	@Override
	public java.util.Date getFromDate() {
		return _rsvpDiscount.getFromDate();
	}

	/**
	* Sets the from date of this rsvp discount.
	*
	* @param fromDate the from date of this rsvp discount
	*/
	@Override
	public void setFromDate(java.util.Date fromDate) {
		_rsvpDiscount.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this rsvp discount.
	*
	* @return the to date of this rsvp discount
	*/
	@Override
	public java.util.Date getToDate() {
		return _rsvpDiscount.getToDate();
	}

	/**
	* Sets the to date of this rsvp discount.
	*
	* @param toDate the to date of this rsvp discount
	*/
	@Override
	public void setToDate(java.util.Date toDate) {
		_rsvpDiscount.setToDate(toDate);
	}

	/**
	* Returns the no of tickets of this rsvp discount.
	*
	* @return the no of tickets of this rsvp discount
	*/
	@Override
	public int getNoOfTickets() {
		return _rsvpDiscount.getNoOfTickets();
	}

	/**
	* Sets the no of tickets of this rsvp discount.
	*
	* @param noOfTickets the no of tickets of this rsvp discount
	*/
	@Override
	public void setNoOfTickets(int noOfTickets) {
		_rsvpDiscount.setNoOfTickets(noOfTickets);
	}

	/**
	* Returns the discount of this rsvp discount.
	*
	* @return the discount of this rsvp discount
	*/
	@Override
	public double getDiscount() {
		return _rsvpDiscount.getDiscount();
	}

	/**
	* Sets the discount of this rsvp discount.
	*
	* @param discount the discount of this rsvp discount
	*/
	@Override
	public void setDiscount(double discount) {
		_rsvpDiscount.setDiscount(discount);
	}

	/**
	* Returns the modified by of this rsvp discount.
	*
	* @return the modified by of this rsvp discount
	*/
	@Override
	public long getModifiedBy() {
		return _rsvpDiscount.getModifiedBy();
	}

	/**
	* Sets the modified by of this rsvp discount.
	*
	* @param modifiedBy the modified by of this rsvp discount
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_rsvpDiscount.setModifiedBy(modifiedBy);
	}

	@Override
	public boolean isNew() {
		return _rsvpDiscount.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvpDiscount.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvpDiscount.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvpDiscount.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvpDiscount.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvpDiscount.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvpDiscount.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvpDiscount.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvpDiscount.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvpDiscount.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvpDiscount.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpDiscountWrapper((RsvpDiscount)_rsvpDiscount.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpDiscount rsvpDiscount) {
		return _rsvpDiscount.compareTo(rsvpDiscount);
	}

	@Override
	public int hashCode() {
		return _rsvpDiscount.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpDiscount> toCacheModel() {
		return _rsvpDiscount.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount toEscapedModel() {
		return new RsvpDiscountWrapper(_rsvpDiscount.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDiscount toUnescapedModel() {
		return new RsvpDiscountWrapper(_rsvpDiscount.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvpDiscount.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvpDiscount.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvpDiscount.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpDiscountWrapper)) {
			return false;
		}

		RsvpDiscountWrapper rsvpDiscountWrapper = (RsvpDiscountWrapper)obj;

		if (Validator.equals(_rsvpDiscount, rsvpDiscountWrapper._rsvpDiscount)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvpDiscount.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RsvpDiscount getWrappedRsvpDiscount() {
		return _rsvpDiscount;
	}

	@Override
	public RsvpDiscount getWrappedModel() {
		return _rsvpDiscount;
	}

	@Override
	public void resetOriginalValues() {
		_rsvpDiscount.resetOriginalValues();
	}

	private RsvpDiscount _rsvpDiscount;
}