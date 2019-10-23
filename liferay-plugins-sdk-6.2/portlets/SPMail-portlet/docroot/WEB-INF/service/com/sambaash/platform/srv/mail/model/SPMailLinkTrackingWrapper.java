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

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailLinkTracking}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTracking
 * @generated
 */
public class SPMailLinkTrackingWrapper implements SPMailLinkTracking,
	ModelWrapper<SPMailLinkTracking> {
	public SPMailLinkTrackingWrapper(SPMailLinkTracking spMailLinkTracking) {
		_spMailLinkTracking = spMailLinkTracking;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailLinkTracking.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailLinkTracking.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailLinkTrackingId", getSpMailLinkTrackingId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("spMailCampaignEDMId", getSpMailCampaignEDMId());
		attributes.put("spMailCampaignSubscribersId",
			getSpMailCampaignSubscribersId());
		attributes.put("label", getLabel());
		attributes.put("link", getLink());
		attributes.put("encryptedlink", getEncryptedlink());
		attributes.put("status", getStatus());
		attributes.put("openedDate", getOpenedDate());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailLinkTrackingId = (Long)attributes.get("spMailLinkTrackingId");

		if (spMailLinkTrackingId != null) {
			setSpMailLinkTrackingId(spMailLinkTrackingId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long spMailCampaignEDMId = (Long)attributes.get("spMailCampaignEDMId");

		if (spMailCampaignEDMId != null) {
			setSpMailCampaignEDMId(spMailCampaignEDMId);
		}

		Long spMailCampaignSubscribersId = (Long)attributes.get(
				"spMailCampaignSubscribersId");

		if (spMailCampaignSubscribersId != null) {
			setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String encryptedlink = (String)attributes.get("encryptedlink");

		if (encryptedlink != null) {
			setEncryptedlink(encryptedlink);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date openedDate = (Date)attributes.get("openedDate");

		if (openedDate != null) {
			setOpenedDate(openedDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this s p mail link tracking.
	*
	* @return the primary key of this s p mail link tracking
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailLinkTracking.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail link tracking.
	*
	* @param primaryKey the primary key of this s p mail link tracking
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailLinkTracking.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail link tracking ID of this s p mail link tracking.
	*
	* @return the sp mail link tracking ID of this s p mail link tracking
	*/
	@Override
	public long getSpMailLinkTrackingId() {
		return _spMailLinkTracking.getSpMailLinkTrackingId();
	}

	/**
	* Sets the sp mail link tracking ID of this s p mail link tracking.
	*
	* @param spMailLinkTrackingId the sp mail link tracking ID of this s p mail link tracking
	*/
	@Override
	public void setSpMailLinkTrackingId(long spMailLinkTrackingId) {
		_spMailLinkTracking.setSpMailLinkTrackingId(spMailLinkTrackingId);
	}

	/**
	* Returns the sp mail campaign ID of this s p mail link tracking.
	*
	* @return the sp mail campaign ID of this s p mail link tracking
	*/
	@Override
	public long getSpMailCampaignId() {
		return _spMailLinkTracking.getSpMailCampaignId();
	}

	/**
	* Sets the sp mail campaign ID of this s p mail link tracking.
	*
	* @param spMailCampaignId the sp mail campaign ID of this s p mail link tracking
	*/
	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailLinkTracking.setSpMailCampaignId(spMailCampaignId);
	}

	/**
	* Returns the sp mail campaign e d m ID of this s p mail link tracking.
	*
	* @return the sp mail campaign e d m ID of this s p mail link tracking
	*/
	@Override
	public long getSpMailCampaignEDMId() {
		return _spMailLinkTracking.getSpMailCampaignEDMId();
	}

	/**
	* Sets the sp mail campaign e d m ID of this s p mail link tracking.
	*
	* @param spMailCampaignEDMId the sp mail campaign e d m ID of this s p mail link tracking
	*/
	@Override
	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailLinkTracking.setSpMailCampaignEDMId(spMailCampaignEDMId);
	}

	/**
	* Returns the sp mail campaign subscribers ID of this s p mail link tracking.
	*
	* @return the sp mail campaign subscribers ID of this s p mail link tracking
	*/
	@Override
	public long getSpMailCampaignSubscribersId() {
		return _spMailLinkTracking.getSpMailCampaignSubscribersId();
	}

	/**
	* Sets the sp mail campaign subscribers ID of this s p mail link tracking.
	*
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID of this s p mail link tracking
	*/
	@Override
	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailLinkTracking.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
	}

	/**
	* Returns the label of this s p mail link tracking.
	*
	* @return the label of this s p mail link tracking
	*/
	@Override
	public java.lang.String getLabel() {
		return _spMailLinkTracking.getLabel();
	}

	/**
	* Sets the label of this s p mail link tracking.
	*
	* @param label the label of this s p mail link tracking
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_spMailLinkTracking.setLabel(label);
	}

	/**
	* Returns the link of this s p mail link tracking.
	*
	* @return the link of this s p mail link tracking
	*/
	@Override
	public java.lang.String getLink() {
		return _spMailLinkTracking.getLink();
	}

	/**
	* Sets the link of this s p mail link tracking.
	*
	* @param link the link of this s p mail link tracking
	*/
	@Override
	public void setLink(java.lang.String link) {
		_spMailLinkTracking.setLink(link);
	}

	/**
	* Returns the encryptedlink of this s p mail link tracking.
	*
	* @return the encryptedlink of this s p mail link tracking
	*/
	@Override
	public java.lang.String getEncryptedlink() {
		return _spMailLinkTracking.getEncryptedlink();
	}

	/**
	* Sets the encryptedlink of this s p mail link tracking.
	*
	* @param encryptedlink the encryptedlink of this s p mail link tracking
	*/
	@Override
	public void setEncryptedlink(java.lang.String encryptedlink) {
		_spMailLinkTracking.setEncryptedlink(encryptedlink);
	}

	/**
	* Returns the status of this s p mail link tracking.
	*
	* @return the status of this s p mail link tracking
	*/
	@Override
	public boolean getStatus() {
		return _spMailLinkTracking.getStatus();
	}

	/**
	* Returns <code>true</code> if this s p mail link tracking is status.
	*
	* @return <code>true</code> if this s p mail link tracking is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _spMailLinkTracking.isStatus();
	}

	/**
	* Sets whether this s p mail link tracking is status.
	*
	* @param status the status of this s p mail link tracking
	*/
	@Override
	public void setStatus(boolean status) {
		_spMailLinkTracking.setStatus(status);
	}

	/**
	* Returns the opened date of this s p mail link tracking.
	*
	* @return the opened date of this s p mail link tracking
	*/
	@Override
	public java.util.Date getOpenedDate() {
		return _spMailLinkTracking.getOpenedDate();
	}

	/**
	* Sets the opened date of this s p mail link tracking.
	*
	* @param openedDate the opened date of this s p mail link tracking
	*/
	@Override
	public void setOpenedDate(java.util.Date openedDate) {
		_spMailLinkTracking.setOpenedDate(openedDate);
	}

	/**
	* Returns the create date of this s p mail link tracking.
	*
	* @return the create date of this s p mail link tracking
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spMailLinkTracking.getCreateDate();
	}

	/**
	* Sets the create date of this s p mail link tracking.
	*
	* @param createDate the create date of this s p mail link tracking
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spMailLinkTracking.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _spMailLinkTracking.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailLinkTracking.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailLinkTracking.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailLinkTracking.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailLinkTracking.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailLinkTracking.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailLinkTracking.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailLinkTracking.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailLinkTracking.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailLinkTracking.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailLinkTracking.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailLinkTrackingWrapper((SPMailLinkTracking)_spMailLinkTracking.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking) {
		return _spMailLinkTracking.compareTo(spMailLinkTracking);
	}

	@Override
	public int hashCode() {
		return _spMailLinkTracking.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> toCacheModel() {
		return _spMailLinkTracking.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking toEscapedModel() {
		return new SPMailLinkTrackingWrapper(_spMailLinkTracking.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking toUnescapedModel() {
		return new SPMailLinkTrackingWrapper(_spMailLinkTracking.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailLinkTracking.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailLinkTracking.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailLinkTracking.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailLinkTrackingWrapper)) {
			return false;
		}

		SPMailLinkTrackingWrapper spMailLinkTrackingWrapper = (SPMailLinkTrackingWrapper)obj;

		if (Validator.equals(_spMailLinkTracking,
					spMailLinkTrackingWrapper._spMailLinkTracking)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailLinkTracking getWrappedSPMailLinkTracking() {
		return _spMailLinkTracking;
	}

	@Override
	public SPMailLinkTracking getWrappedModel() {
		return _spMailLinkTracking;
	}

	@Override
	public void resetOriginalValues() {
		_spMailLinkTracking.resetOriginalValues();
	}

	private SPMailLinkTracking _spMailLinkTracking;
}