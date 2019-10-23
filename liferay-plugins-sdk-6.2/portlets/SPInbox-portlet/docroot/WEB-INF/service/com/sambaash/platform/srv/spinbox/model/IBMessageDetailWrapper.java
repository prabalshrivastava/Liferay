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

package com.sambaash.platform.srv.spinbox.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IBMessageDetail}.
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessageDetail
 * @generated
 */
public class IBMessageDetailWrapper implements IBMessageDetail,
	ModelWrapper<IBMessageDetail> {
	public IBMessageDetailWrapper(IBMessageDetail ibMessageDetail) {
		_ibMessageDetail = ibMessageDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return IBMessageDetail.class;
	}

	@Override
	public String getModelClassName() {
		return IBMessageDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ibMsgDetailId", getIbMsgDetailId());
		attributes.put("receiverId", getReceiverId());
		attributes.put("messageId", getMessageId());
		attributes.put("receiverMsgStatus", getReceiverMsgStatus());
		attributes.put("senderMsgStatus", getSenderMsgStatus());
		attributes.put("status", getStatus());
		attributes.put("receiveDate", getReceiveDate());
		attributes.put("receiveBy", getReceiveBy());
		attributes.put("archived", getArchived());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updateBy", getUpdateBy());
		attributes.put("category", getCategory());
		attributes.put("processId", getProcessId());
		attributes.put("corpProfileId", getCorpProfileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ibMsgDetailId = (Long)attributes.get("ibMsgDetailId");

		if (ibMsgDetailId != null) {
			setIbMsgDetailId(ibMsgDetailId);
		}

		Long receiverId = (Long)attributes.get("receiverId");

		if (receiverId != null) {
			setReceiverId(receiverId);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String receiverMsgStatus = (String)attributes.get("receiverMsgStatus");

		if (receiverMsgStatus != null) {
			setReceiverMsgStatus(receiverMsgStatus);
		}

		String senderMsgStatus = (String)attributes.get("senderMsgStatus");

		if (senderMsgStatus != null) {
			setSenderMsgStatus(senderMsgStatus);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date receiveDate = (Date)attributes.get("receiveDate");

		if (receiveDate != null) {
			setReceiveDate(receiveDate);
		}

		String receiveBy = (String)attributes.get("receiveBy");

		if (receiveBy != null) {
			setReceiveBy(receiveBy);
		}

		Boolean archived = (Boolean)attributes.get("archived");

		if (archived != null) {
			setArchived(archived);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		String updateBy = (String)attributes.get("updateBy");

		if (updateBy != null) {
			setUpdateBy(updateBy);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long processId = (Long)attributes.get("processId");

		if (processId != null) {
			setProcessId(processId);
		}

		Long corpProfileId = (Long)attributes.get("corpProfileId");

		if (corpProfileId != null) {
			setCorpProfileId(corpProfileId);
		}
	}

	/**
	* Returns the primary key of this i b message detail.
	*
	* @return the primary key of this i b message detail
	*/
	@Override
	public long getPrimaryKey() {
		return _ibMessageDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i b message detail.
	*
	* @param primaryKey the primary key of this i b message detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ibMessageDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ib msg detail ID of this i b message detail.
	*
	* @return the ib msg detail ID of this i b message detail
	*/
	@Override
	public long getIbMsgDetailId() {
		return _ibMessageDetail.getIbMsgDetailId();
	}

	/**
	* Sets the ib msg detail ID of this i b message detail.
	*
	* @param ibMsgDetailId the ib msg detail ID of this i b message detail
	*/
	@Override
	public void setIbMsgDetailId(long ibMsgDetailId) {
		_ibMessageDetail.setIbMsgDetailId(ibMsgDetailId);
	}

	/**
	* Returns the receiver ID of this i b message detail.
	*
	* @return the receiver ID of this i b message detail
	*/
	@Override
	public long getReceiverId() {
		return _ibMessageDetail.getReceiverId();
	}

	/**
	* Sets the receiver ID of this i b message detail.
	*
	* @param receiverId the receiver ID of this i b message detail
	*/
	@Override
	public void setReceiverId(long receiverId) {
		_ibMessageDetail.setReceiverId(receiverId);
	}

	/**
	* Returns the message ID of this i b message detail.
	*
	* @return the message ID of this i b message detail
	*/
	@Override
	public long getMessageId() {
		return _ibMessageDetail.getMessageId();
	}

	/**
	* Sets the message ID of this i b message detail.
	*
	* @param messageId the message ID of this i b message detail
	*/
	@Override
	public void setMessageId(long messageId) {
		_ibMessageDetail.setMessageId(messageId);
	}

	/**
	* Returns the receiver msg status of this i b message detail.
	*
	* @return the receiver msg status of this i b message detail
	*/
	@Override
	public java.lang.String getReceiverMsgStatus() {
		return _ibMessageDetail.getReceiverMsgStatus();
	}

	/**
	* Sets the receiver msg status of this i b message detail.
	*
	* @param receiverMsgStatus the receiver msg status of this i b message detail
	*/
	@Override
	public void setReceiverMsgStatus(java.lang.String receiverMsgStatus) {
		_ibMessageDetail.setReceiverMsgStatus(receiverMsgStatus);
	}

	/**
	* Returns the sender msg status of this i b message detail.
	*
	* @return the sender msg status of this i b message detail
	*/
	@Override
	public java.lang.String getSenderMsgStatus() {
		return _ibMessageDetail.getSenderMsgStatus();
	}

	/**
	* Sets the sender msg status of this i b message detail.
	*
	* @param senderMsgStatus the sender msg status of this i b message detail
	*/
	@Override
	public void setSenderMsgStatus(java.lang.String senderMsgStatus) {
		_ibMessageDetail.setSenderMsgStatus(senderMsgStatus);
	}

	/**
	* Returns the status of this i b message detail.
	*
	* @return the status of this i b message detail
	*/
	@Override
	public java.lang.String getStatus() {
		return _ibMessageDetail.getStatus();
	}

	/**
	* Sets the status of this i b message detail.
	*
	* @param status the status of this i b message detail
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_ibMessageDetail.setStatus(status);
	}

	/**
	* Returns the receive date of this i b message detail.
	*
	* @return the receive date of this i b message detail
	*/
	@Override
	public java.util.Date getReceiveDate() {
		return _ibMessageDetail.getReceiveDate();
	}

	/**
	* Sets the receive date of this i b message detail.
	*
	* @param receiveDate the receive date of this i b message detail
	*/
	@Override
	public void setReceiveDate(java.util.Date receiveDate) {
		_ibMessageDetail.setReceiveDate(receiveDate);
	}

	/**
	* Returns the receive by of this i b message detail.
	*
	* @return the receive by of this i b message detail
	*/
	@Override
	public java.lang.String getReceiveBy() {
		return _ibMessageDetail.getReceiveBy();
	}

	/**
	* Sets the receive by of this i b message detail.
	*
	* @param receiveBy the receive by of this i b message detail
	*/
	@Override
	public void setReceiveBy(java.lang.String receiveBy) {
		_ibMessageDetail.setReceiveBy(receiveBy);
	}

	/**
	* Returns the archived of this i b message detail.
	*
	* @return the archived of this i b message detail
	*/
	@Override
	public boolean getArchived() {
		return _ibMessageDetail.getArchived();
	}

	/**
	* Returns <code>true</code> if this i b message detail is archived.
	*
	* @return <code>true</code> if this i b message detail is archived; <code>false</code> otherwise
	*/
	@Override
	public boolean isArchived() {
		return _ibMessageDetail.isArchived();
	}

	/**
	* Sets whether this i b message detail is archived.
	*
	* @param archived the archived of this i b message detail
	*/
	@Override
	public void setArchived(boolean archived) {
		_ibMessageDetail.setArchived(archived);
	}

	/**
	* Returns the update date of this i b message detail.
	*
	* @return the update date of this i b message detail
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _ibMessageDetail.getUpdateDate();
	}

	/**
	* Sets the update date of this i b message detail.
	*
	* @param updateDate the update date of this i b message detail
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_ibMessageDetail.setUpdateDate(updateDate);
	}

	/**
	* Returns the update by of this i b message detail.
	*
	* @return the update by of this i b message detail
	*/
	@Override
	public java.lang.String getUpdateBy() {
		return _ibMessageDetail.getUpdateBy();
	}

	/**
	* Sets the update by of this i b message detail.
	*
	* @param updateBy the update by of this i b message detail
	*/
	@Override
	public void setUpdateBy(java.lang.String updateBy) {
		_ibMessageDetail.setUpdateBy(updateBy);
	}

	/**
	* Returns the category of this i b message detail.
	*
	* @return the category of this i b message detail
	*/
	@Override
	public java.lang.String getCategory() {
		return _ibMessageDetail.getCategory();
	}

	/**
	* Sets the category of this i b message detail.
	*
	* @param category the category of this i b message detail
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_ibMessageDetail.setCategory(category);
	}

	/**
	* Returns the process ID of this i b message detail.
	*
	* @return the process ID of this i b message detail
	*/
	@Override
	public long getProcessId() {
		return _ibMessageDetail.getProcessId();
	}

	/**
	* Sets the process ID of this i b message detail.
	*
	* @param processId the process ID of this i b message detail
	*/
	@Override
	public void setProcessId(long processId) {
		_ibMessageDetail.setProcessId(processId);
	}

	/**
	* Returns the corp profile ID of this i b message detail.
	*
	* @return the corp profile ID of this i b message detail
	*/
	@Override
	public long getCorpProfileId() {
		return _ibMessageDetail.getCorpProfileId();
	}

	/**
	* Sets the corp profile ID of this i b message detail.
	*
	* @param corpProfileId the corp profile ID of this i b message detail
	*/
	@Override
	public void setCorpProfileId(long corpProfileId) {
		_ibMessageDetail.setCorpProfileId(corpProfileId);
	}

	@Override
	public boolean isNew() {
		return _ibMessageDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ibMessageDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ibMessageDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ibMessageDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ibMessageDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ibMessageDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ibMessageDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ibMessageDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ibMessageDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ibMessageDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ibMessageDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IBMessageDetailWrapper((IBMessageDetail)_ibMessageDetail.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail) {
		return _ibMessageDetail.compareTo(ibMessageDetail);
	}

	@Override
	public int hashCode() {
		return _ibMessageDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> toCacheModel() {
		return _ibMessageDetail.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail toEscapedModel() {
		return new IBMessageDetailWrapper(_ibMessageDetail.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail toUnescapedModel() {
		return new IBMessageDetailWrapper(_ibMessageDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ibMessageDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ibMessageDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ibMessageDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IBMessageDetailWrapper)) {
			return false;
		}

		IBMessageDetailWrapper ibMessageDetailWrapper = (IBMessageDetailWrapper)obj;

		if (Validator.equals(_ibMessageDetail,
					ibMessageDetailWrapper._ibMessageDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public IBMessageDetail getWrappedIBMessageDetail() {
		return _ibMessageDetail;
	}

	@Override
	public IBMessageDetail getWrappedModel() {
		return _ibMessageDetail;
	}

	@Override
	public void resetOriginalValues() {
		_ibMessageDetail.resetOriginalValues();
	}

	private IBMessageDetail _ibMessageDetail;
}