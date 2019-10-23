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

package com.sambaash.platform.srv.spjob.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPJobApplicantsPortfolio}.
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPortfolio
 * @generated
 */
public class SPJobApplicantsPortfolioWrapper implements SPJobApplicantsPortfolio,
	ModelWrapper<SPJobApplicantsPortfolio> {
	public SPJobApplicantsPortfolioWrapper(
		SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		_spJobApplicantsPortfolio = spJobApplicantsPortfolio;
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobApplicantsPortfolio.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobApplicantsPortfolio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobApplyId", getJobApplyId());
		attributes.put("porfolioId", getPorfolioId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobApplyId = (Long)attributes.get("jobApplyId");

		if (jobApplyId != null) {
			setJobApplyId(jobApplyId);
		}

		Long porfolioId = (Long)attributes.get("porfolioId");

		if (porfolioId != null) {
			setPorfolioId(porfolioId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}
	}

	/**
	* Returns the primary key of this s p job applicants portfolio.
	*
	* @return the primary key of this s p job applicants portfolio
	*/
	@Override
	public com.sambaash.platform.srv.spjob.service.persistence.SPJobApplicantsPortfolioPK getPrimaryKey() {
		return _spJobApplicantsPortfolio.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p job applicants portfolio.
	*
	* @param primaryKey the primary key of this s p job applicants portfolio
	*/
	@Override
	public void setPrimaryKey(
		com.sambaash.platform.srv.spjob.service.persistence.SPJobApplicantsPortfolioPK primaryKey) {
		_spJobApplicantsPortfolio.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job apply ID of this s p job applicants portfolio.
	*
	* @return the job apply ID of this s p job applicants portfolio
	*/
	@Override
	public long getJobApplyId() {
		return _spJobApplicantsPortfolio.getJobApplyId();
	}

	/**
	* Sets the job apply ID of this s p job applicants portfolio.
	*
	* @param jobApplyId the job apply ID of this s p job applicants portfolio
	*/
	@Override
	public void setJobApplyId(long jobApplyId) {
		_spJobApplicantsPortfolio.setJobApplyId(jobApplyId);
	}

	/**
	* Returns the porfolio ID of this s p job applicants portfolio.
	*
	* @return the porfolio ID of this s p job applicants portfolio
	*/
	@Override
	public long getPorfolioId() {
		return _spJobApplicantsPortfolio.getPorfolioId();
	}

	/**
	* Sets the porfolio ID of this s p job applicants portfolio.
	*
	* @param porfolioId the porfolio ID of this s p job applicants portfolio
	*/
	@Override
	public void setPorfolioId(long porfolioId) {
		_spJobApplicantsPortfolio.setPorfolioId(porfolioId);
	}

	/**
	* Returns the user ID of this s p job applicants portfolio.
	*
	* @return the user ID of this s p job applicants portfolio
	*/
	@Override
	public long getUserId() {
		return _spJobApplicantsPortfolio.getUserId();
	}

	/**
	* Sets the user ID of this s p job applicants portfolio.
	*
	* @param userId the user ID of this s p job applicants portfolio
	*/
	@Override
	public void setUserId(long userId) {
		_spJobApplicantsPortfolio.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p job applicants portfolio.
	*
	* @return the user uuid of this s p job applicants portfolio
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobApplicantsPortfolio.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p job applicants portfolio.
	*
	* @param userUuid the user uuid of this s p job applicants portfolio
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spJobApplicantsPortfolio.setUserUuid(userUuid);
	}

	/**
	* Returns the created by of this s p job applicants portfolio.
	*
	* @return the created by of this s p job applicants portfolio
	*/
	@Override
	public long getCreatedBy() {
		return _spJobApplicantsPortfolio.getCreatedBy();
	}

	/**
	* Sets the created by of this s p job applicants portfolio.
	*
	* @param createdBy the created by of this s p job applicants portfolio
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spJobApplicantsPortfolio.setCreatedBy(createdBy);
	}

	/**
	* Returns the updated by of this s p job applicants portfolio.
	*
	* @return the updated by of this s p job applicants portfolio
	*/
	@Override
	public long getUpdatedBy() {
		return _spJobApplicantsPortfolio.getUpdatedBy();
	}

	/**
	* Sets the updated by of this s p job applicants portfolio.
	*
	* @param updatedBy the updated by of this s p job applicants portfolio
	*/
	@Override
	public void setUpdatedBy(long updatedBy) {
		_spJobApplicantsPortfolio.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the create date of this s p job applicants portfolio.
	*
	* @return the create date of this s p job applicants portfolio
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spJobApplicantsPortfolio.getCreateDate();
	}

	/**
	* Sets the create date of this s p job applicants portfolio.
	*
	* @param createDate the create date of this s p job applicants portfolio
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spJobApplicantsPortfolio.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p job applicants portfolio.
	*
	* @return the modified date of this s p job applicants portfolio
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spJobApplicantsPortfolio.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p job applicants portfolio.
	*
	* @param modifiedDate the modified date of this s p job applicants portfolio
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spJobApplicantsPortfolio.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the extra1 of this s p job applicants portfolio.
	*
	* @return the extra1 of this s p job applicants portfolio
	*/
	@Override
	public java.lang.String getExtra1() {
		return _spJobApplicantsPortfolio.getExtra1();
	}

	/**
	* Sets the extra1 of this s p job applicants portfolio.
	*
	* @param extra1 the extra1 of this s p job applicants portfolio
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_spJobApplicantsPortfolio.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this s p job applicants portfolio.
	*
	* @return the extra2 of this s p job applicants portfolio
	*/
	@Override
	public java.lang.String getExtra2() {
		return _spJobApplicantsPortfolio.getExtra2();
	}

	/**
	* Sets the extra2 of this s p job applicants portfolio.
	*
	* @param extra2 the extra2 of this s p job applicants portfolio
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_spJobApplicantsPortfolio.setExtra2(extra2);
	}

	@Override
	public boolean isNew() {
		return _spJobApplicantsPortfolio.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spJobApplicantsPortfolio.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spJobApplicantsPortfolio.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spJobApplicantsPortfolio.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spJobApplicantsPortfolio.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spJobApplicantsPortfolio.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spJobApplicantsPortfolio.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spJobApplicantsPortfolio.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spJobApplicantsPortfolio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spJobApplicantsPortfolio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spJobApplicantsPortfolio.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPJobApplicantsPortfolioWrapper((SPJobApplicantsPortfolio)_spJobApplicantsPortfolio.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		return _spJobApplicantsPortfolio.compareTo(spJobApplicantsPortfolio);
	}

	@Override
	public int hashCode() {
		return _spJobApplicantsPortfolio.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio> toCacheModel() {
		return _spJobApplicantsPortfolio.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio toEscapedModel() {
		return new SPJobApplicantsPortfolioWrapper(_spJobApplicantsPortfolio.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio toUnescapedModel() {
		return new SPJobApplicantsPortfolioWrapper(_spJobApplicantsPortfolio.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spJobApplicantsPortfolio.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spJobApplicantsPortfolio.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spJobApplicantsPortfolio.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobApplicantsPortfolioWrapper)) {
			return false;
		}

		SPJobApplicantsPortfolioWrapper spJobApplicantsPortfolioWrapper = (SPJobApplicantsPortfolioWrapper)obj;

		if (Validator.equals(_spJobApplicantsPortfolio,
					spJobApplicantsPortfolioWrapper._spJobApplicantsPortfolio)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPJobApplicantsPortfolio getWrappedSPJobApplicantsPortfolio() {
		return _spJobApplicantsPortfolio;
	}

	@Override
	public SPJobApplicantsPortfolio getWrappedModel() {
		return _spJobApplicantsPortfolio;
	}

	@Override
	public void resetOriginalValues() {
		_spJobApplicantsPortfolio.resetOriginalValues();
	}

	private SPJobApplicantsPortfolio _spJobApplicantsPortfolio;
}