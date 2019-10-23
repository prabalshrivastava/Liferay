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
 * This class is a wrapper for {@link SPEMailAudit}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPEMailAudit
 * @generated
 */
public class SPEMailAuditWrapper implements SPEMailAudit,
	ModelWrapper<SPEMailAudit> {
	public SPEMailAuditWrapper(SPEMailAudit speMailAudit) {
		_speMailAudit = speMailAudit;
	}

	@Override
	public Class<?> getModelClass() {
		return SPEMailAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SPEMailAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spEMailAudit", getSpEMailAudit());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("sentTo", getSentTo());
		attributes.put("cc", getCc());
		attributes.put("bcc", getBcc());
		attributes.put("category", getCategory());
		attributes.put("subject", getSubject());
		attributes.put("content", getContent());
		attributes.put("sentDate", getSentDate());
		attributes.put("messasgeId", getMessasgeId());
		attributes.put("userId", getUserId());
		attributes.put("orgId", getOrgId());
		attributes.put("processStateId", getProcessStateId());
		attributes.put("nodeId", getNodeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spEMailAudit = (Long)attributes.get("spEMailAudit");

		if (spEMailAudit != null) {
			setSpEMailAudit(spEMailAudit);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String sentTo = (String)attributes.get("sentTo");

		if (sentTo != null) {
			setSentTo(sentTo);
		}

		String cc = (String)attributes.get("cc");

		if (cc != null) {
			setCc(cc);
		}

		String bcc = (String)attributes.get("bcc");

		if (bcc != null) {
			setBcc(bcc);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date sentDate = (Date)attributes.get("sentDate");

		if (sentDate != null) {
			setSentDate(sentDate);
		}

		String messasgeId = (String)attributes.get("messasgeId");

		if (messasgeId != null) {
			setMessasgeId(messasgeId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long orgId = (Long)attributes.get("orgId");

		if (orgId != null) {
			setOrgId(orgId);
		}

		Long processStateId = (Long)attributes.get("processStateId");

		if (processStateId != null) {
			setProcessStateId(processStateId);
		}

		Long nodeId = (Long)attributes.get("nodeId");

		if (nodeId != null) {
			setNodeId(nodeId);
		}
	}

	/**
	* Returns the primary key of this s p e mail audit.
	*
	* @return the primary key of this s p e mail audit
	*/
	@Override
	public long getPrimaryKey() {
		return _speMailAudit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p e mail audit.
	*
	* @param primaryKey the primary key of this s p e mail audit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_speMailAudit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp e mail audit of this s p e mail audit.
	*
	* @return the sp e mail audit of this s p e mail audit
	*/
	@Override
	public long getSpEMailAudit() {
		return _speMailAudit.getSpEMailAudit();
	}

	/**
	* Sets the sp e mail audit of this s p e mail audit.
	*
	* @param spEMailAudit the sp e mail audit of this s p e mail audit
	*/
	@Override
	public void setSpEMailAudit(long spEMailAudit) {
		_speMailAudit.setSpEMailAudit(spEMailAudit);
	}

	/**
	* Returns the group ID of this s p e mail audit.
	*
	* @return the group ID of this s p e mail audit
	*/
	@Override
	public long getGroupId() {
		return _speMailAudit.getGroupId();
	}

	/**
	* Sets the group ID of this s p e mail audit.
	*
	* @param groupId the group ID of this s p e mail audit
	*/
	@Override
	public void setGroupId(long groupId) {
		_speMailAudit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p e mail audit.
	*
	* @return the company ID of this s p e mail audit
	*/
	@Override
	public long getCompanyId() {
		return _speMailAudit.getCompanyId();
	}

	/**
	* Sets the company ID of this s p e mail audit.
	*
	* @param companyId the company ID of this s p e mail audit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_speMailAudit.setCompanyId(companyId);
	}

	/**
	* Returns the sent to of this s p e mail audit.
	*
	* @return the sent to of this s p e mail audit
	*/
	@Override
	public java.lang.String getSentTo() {
		return _speMailAudit.getSentTo();
	}

	/**
	* Sets the sent to of this s p e mail audit.
	*
	* @param sentTo the sent to of this s p e mail audit
	*/
	@Override
	public void setSentTo(java.lang.String sentTo) {
		_speMailAudit.setSentTo(sentTo);
	}

	/**
	* Returns the cc of this s p e mail audit.
	*
	* @return the cc of this s p e mail audit
	*/
	@Override
	public java.lang.String getCc() {
		return _speMailAudit.getCc();
	}

	/**
	* Sets the cc of this s p e mail audit.
	*
	* @param cc the cc of this s p e mail audit
	*/
	@Override
	public void setCc(java.lang.String cc) {
		_speMailAudit.setCc(cc);
	}

	/**
	* Returns the bcc of this s p e mail audit.
	*
	* @return the bcc of this s p e mail audit
	*/
	@Override
	public java.lang.String getBcc() {
		return _speMailAudit.getBcc();
	}

	/**
	* Sets the bcc of this s p e mail audit.
	*
	* @param bcc the bcc of this s p e mail audit
	*/
	@Override
	public void setBcc(java.lang.String bcc) {
		_speMailAudit.setBcc(bcc);
	}

	/**
	* Returns the category of this s p e mail audit.
	*
	* @return the category of this s p e mail audit
	*/
	@Override
	public java.lang.String getCategory() {
		return _speMailAudit.getCategory();
	}

	/**
	* Sets the category of this s p e mail audit.
	*
	* @param category the category of this s p e mail audit
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_speMailAudit.setCategory(category);
	}

	/**
	* Returns the subject of this s p e mail audit.
	*
	* @return the subject of this s p e mail audit
	*/
	@Override
	public java.lang.String getSubject() {
		return _speMailAudit.getSubject();
	}

	/**
	* Sets the subject of this s p e mail audit.
	*
	* @param subject the subject of this s p e mail audit
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_speMailAudit.setSubject(subject);
	}

	/**
	* Returns the content of this s p e mail audit.
	*
	* @return the content of this s p e mail audit
	*/
	@Override
	public java.lang.String getContent() {
		return _speMailAudit.getContent();
	}

	/**
	* Sets the content of this s p e mail audit.
	*
	* @param content the content of this s p e mail audit
	*/
	@Override
	public void setContent(java.lang.String content) {
		_speMailAudit.setContent(content);
	}

	/**
	* Returns the sent date of this s p e mail audit.
	*
	* @return the sent date of this s p e mail audit
	*/
	@Override
	public java.util.Date getSentDate() {
		return _speMailAudit.getSentDate();
	}

	/**
	* Sets the sent date of this s p e mail audit.
	*
	* @param sentDate the sent date of this s p e mail audit
	*/
	@Override
	public void setSentDate(java.util.Date sentDate) {
		_speMailAudit.setSentDate(sentDate);
	}

	/**
	* Returns the messasge ID of this s p e mail audit.
	*
	* @return the messasge ID of this s p e mail audit
	*/
	@Override
	public java.lang.String getMessasgeId() {
		return _speMailAudit.getMessasgeId();
	}

	/**
	* Sets the messasge ID of this s p e mail audit.
	*
	* @param messasgeId the messasge ID of this s p e mail audit
	*/
	@Override
	public void setMessasgeId(java.lang.String messasgeId) {
		_speMailAudit.setMessasgeId(messasgeId);
	}

	/**
	* Returns the user ID of this s p e mail audit.
	*
	* @return the user ID of this s p e mail audit
	*/
	@Override
	public long getUserId() {
		return _speMailAudit.getUserId();
	}

	/**
	* Sets the user ID of this s p e mail audit.
	*
	* @param userId the user ID of this s p e mail audit
	*/
	@Override
	public void setUserId(long userId) {
		_speMailAudit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p e mail audit.
	*
	* @return the user uuid of this s p e mail audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _speMailAudit.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p e mail audit.
	*
	* @param userUuid the user uuid of this s p e mail audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_speMailAudit.setUserUuid(userUuid);
	}

	/**
	* Returns the org ID of this s p e mail audit.
	*
	* @return the org ID of this s p e mail audit
	*/
	@Override
	public long getOrgId() {
		return _speMailAudit.getOrgId();
	}

	/**
	* Sets the org ID of this s p e mail audit.
	*
	* @param orgId the org ID of this s p e mail audit
	*/
	@Override
	public void setOrgId(long orgId) {
		_speMailAudit.setOrgId(orgId);
	}

	/**
	* Returns the process state ID of this s p e mail audit.
	*
	* @return the process state ID of this s p e mail audit
	*/
	@Override
	public long getProcessStateId() {
		return _speMailAudit.getProcessStateId();
	}

	/**
	* Sets the process state ID of this s p e mail audit.
	*
	* @param processStateId the process state ID of this s p e mail audit
	*/
	@Override
	public void setProcessStateId(long processStateId) {
		_speMailAudit.setProcessStateId(processStateId);
	}

	/**
	* Returns the node ID of this s p e mail audit.
	*
	* @return the node ID of this s p e mail audit
	*/
	@Override
	public long getNodeId() {
		return _speMailAudit.getNodeId();
	}

	/**
	* Sets the node ID of this s p e mail audit.
	*
	* @param nodeId the node ID of this s p e mail audit
	*/
	@Override
	public void setNodeId(long nodeId) {
		_speMailAudit.setNodeId(nodeId);
	}

	@Override
	public boolean isNew() {
		return _speMailAudit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_speMailAudit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _speMailAudit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_speMailAudit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _speMailAudit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _speMailAudit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_speMailAudit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _speMailAudit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_speMailAudit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_speMailAudit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_speMailAudit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPEMailAuditWrapper((SPEMailAudit)_speMailAudit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit) {
		return _speMailAudit.compareTo(speMailAudit);
	}

	@Override
	public int hashCode() {
		return _speMailAudit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPEMailAudit> toCacheModel() {
		return _speMailAudit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit toEscapedModel() {
		return new SPEMailAuditWrapper(_speMailAudit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPEMailAudit toUnescapedModel() {
		return new SPEMailAuditWrapper(_speMailAudit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _speMailAudit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _speMailAudit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_speMailAudit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPEMailAuditWrapper)) {
			return false;
		}

		SPEMailAuditWrapper speMailAuditWrapper = (SPEMailAuditWrapper)obj;

		if (Validator.equals(_speMailAudit, speMailAuditWrapper._speMailAudit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPEMailAudit getWrappedSPEMailAudit() {
		return _speMailAudit;
	}

	@Override
	public SPEMailAudit getWrappedModel() {
		return _speMailAudit;
	}

	@Override
	public void resetOriginalValues() {
		_speMailAudit.resetOriginalValues();
	}

	private SPEMailAudit _speMailAudit;
}