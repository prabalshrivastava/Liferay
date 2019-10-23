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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Outcome}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Outcome
 * @generated
 */
public class OutcomeWrapper implements Outcome, ModelWrapper<Outcome> {
	public OutcomeWrapper(Outcome outcome) {
		_outcome = outcome;
	}

	@Override
	public Class<?> getModelClass() {
		return Outcome.class;
	}

	@Override
	public String getModelClassName() {
		return Outcome.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spOutcomeId", getSpOutcomeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("outcomeCode", getOutcomeCode());
		attributes.put("outcomeDesc", getOutcomeDesc());
		attributes.put("outcomeType", getOutcomeType());
		attributes.put("outcomeFolderId", getOutcomeFolderId());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spOutcomeId = (Long)attributes.get("spOutcomeId");

		if (spOutcomeId != null) {
			setSpOutcomeId(spOutcomeId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String outcomeCode = (String)attributes.get("outcomeCode");

		if (outcomeCode != null) {
			setOutcomeCode(outcomeCode);
		}

		String outcomeDesc = (String)attributes.get("outcomeDesc");

		if (outcomeDesc != null) {
			setOutcomeDesc(outcomeDesc);
		}

		Long outcomeType = (Long)attributes.get("outcomeType");

		if (outcomeType != null) {
			setOutcomeType(outcomeType);
		}

		Long outcomeFolderId = (Long)attributes.get("outcomeFolderId");

		if (outcomeFolderId != null) {
			setOutcomeFolderId(outcomeFolderId);
		}

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}
	}

	/**
	* Returns the primary key of this outcome.
	*
	* @return the primary key of this outcome
	*/
	@Override
	public long getPrimaryKey() {
		return _outcome.getPrimaryKey();
	}

	/**
	* Sets the primary key of this outcome.
	*
	* @param primaryKey the primary key of this outcome
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_outcome.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp outcome ID of this outcome.
	*
	* @return the sp outcome ID of this outcome
	*/
	@Override
	public long getSpOutcomeId() {
		return _outcome.getSpOutcomeId();
	}

	/**
	* Sets the sp outcome ID of this outcome.
	*
	* @param spOutcomeId the sp outcome ID of this outcome
	*/
	@Override
	public void setSpOutcomeId(long spOutcomeId) {
		_outcome.setSpOutcomeId(spOutcomeId);
	}

	/**
	* Returns the group ID of this outcome.
	*
	* @return the group ID of this outcome
	*/
	@Override
	public long getGroupId() {
		return _outcome.getGroupId();
	}

	/**
	* Sets the group ID of this outcome.
	*
	* @param groupId the group ID of this outcome
	*/
	@Override
	public void setGroupId(long groupId) {
		_outcome.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this outcome.
	*
	* @return the company ID of this outcome
	*/
	@Override
	public long getCompanyId() {
		return _outcome.getCompanyId();
	}

	/**
	* Sets the company ID of this outcome.
	*
	* @param companyId the company ID of this outcome
	*/
	@Override
	public void setCompanyId(long companyId) {
		_outcome.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this outcome.
	*
	* @return the user ID of this outcome
	*/
	@Override
	public long getUserId() {
		return _outcome.getUserId();
	}

	/**
	* Sets the user ID of this outcome.
	*
	* @param userId the user ID of this outcome
	*/
	@Override
	public void setUserId(long userId) {
		_outcome.setUserId(userId);
	}

	/**
	* Returns the user uuid of this outcome.
	*
	* @return the user uuid of this outcome
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcome.getUserUuid();
	}

	/**
	* Sets the user uuid of this outcome.
	*
	* @param userUuid the user uuid of this outcome
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_outcome.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this outcome.
	*
	* @return the user name of this outcome
	*/
	@Override
	public java.lang.String getUserName() {
		return _outcome.getUserName();
	}

	/**
	* Sets the user name of this outcome.
	*
	* @param userName the user name of this outcome
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_outcome.setUserName(userName);
	}

	/**
	* Returns the create date of this outcome.
	*
	* @return the create date of this outcome
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _outcome.getCreateDate();
	}

	/**
	* Sets the create date of this outcome.
	*
	* @param createDate the create date of this outcome
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_outcome.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this outcome.
	*
	* @return the modified date of this outcome
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _outcome.getModifiedDate();
	}

	/**
	* Sets the modified date of this outcome.
	*
	* @param modifiedDate the modified date of this outcome
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_outcome.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this outcome.
	*
	* @return the country ID of this outcome
	*/
	@Override
	public long getCountryId() {
		return _outcome.getCountryId();
	}

	/**
	* Sets the country ID of this outcome.
	*
	* @param countryId the country ID of this outcome
	*/
	@Override
	public void setCountryId(long countryId) {
		_outcome.setCountryId(countryId);
	}

	/**
	* Returns the outcome code of this outcome.
	*
	* @return the outcome code of this outcome
	*/
	@Override
	public java.lang.String getOutcomeCode() {
		return _outcome.getOutcomeCode();
	}

	/**
	* Sets the outcome code of this outcome.
	*
	* @param outcomeCode the outcome code of this outcome
	*/
	@Override
	public void setOutcomeCode(java.lang.String outcomeCode) {
		_outcome.setOutcomeCode(outcomeCode);
	}

	/**
	* Returns the outcome desc of this outcome.
	*
	* @return the outcome desc of this outcome
	*/
	@Override
	public java.lang.String getOutcomeDesc() {
		return _outcome.getOutcomeDesc();
	}

	/**
	* Sets the outcome desc of this outcome.
	*
	* @param outcomeDesc the outcome desc of this outcome
	*/
	@Override
	public void setOutcomeDesc(java.lang.String outcomeDesc) {
		_outcome.setOutcomeDesc(outcomeDesc);
	}

	/**
	* Returns the outcome type of this outcome.
	*
	* @return the outcome type of this outcome
	*/
	@Override
	public long getOutcomeType() {
		return _outcome.getOutcomeType();
	}

	/**
	* Sets the outcome type of this outcome.
	*
	* @param outcomeType the outcome type of this outcome
	*/
	@Override
	public void setOutcomeType(long outcomeType) {
		_outcome.setOutcomeType(outcomeType);
	}

	/**
	* Returns the outcome folder ID of this outcome.
	*
	* @return the outcome folder ID of this outcome
	*/
	@Override
	public long getOutcomeFolderId() {
		return _outcome.getOutcomeFolderId();
	}

	/**
	* Sets the outcome folder ID of this outcome.
	*
	* @param outcomeFolderId the outcome folder ID of this outcome
	*/
	@Override
	public void setOutcomeFolderId(long outcomeFolderId) {
		_outcome.setOutcomeFolderId(outcomeFolderId);
	}

	/**
	* Returns the sp competency unit ID of this outcome.
	*
	* @return the sp competency unit ID of this outcome
	*/
	@Override
	public long getSpCompetencyUnitId() {
		return _outcome.getSpCompetencyUnitId();
	}

	/**
	* Sets the sp competency unit ID of this outcome.
	*
	* @param spCompetencyUnitId the sp competency unit ID of this outcome
	*/
	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_outcome.setSpCompetencyUnitId(spCompetencyUnitId);
	}

	@Override
	public boolean isNew() {
		return _outcome.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_outcome.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _outcome.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_outcome.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _outcome.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _outcome.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_outcome.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _outcome.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_outcome.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_outcome.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_outcome.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OutcomeWrapper((Outcome)_outcome.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Outcome outcome) {
		return _outcome.compareTo(outcome);
	}

	@Override
	public int hashCode() {
		return _outcome.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Outcome> toCacheModel() {
		return _outcome.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Outcome toEscapedModel() {
		return new OutcomeWrapper(_outcome.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Outcome toUnescapedModel() {
		return new OutcomeWrapper(_outcome.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _outcome.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _outcome.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_outcome.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OutcomeWrapper)) {
			return false;
		}

		OutcomeWrapper outcomeWrapper = (OutcomeWrapper)obj;

		if (Validator.equals(_outcome, outcomeWrapper._outcome)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Outcome getWrappedOutcome() {
		return _outcome;
	}

	@Override
	public Outcome getWrappedModel() {
		return _outcome;
	}

	@Override
	public void resetOriginalValues() {
		_outcome.resetOriginalValues();
	}

	private Outcome _outcome;
}