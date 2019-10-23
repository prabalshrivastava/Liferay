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

import com.sambaash.platform.srv.spjob.service.persistence.SPJobApplicantsPortfolioPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author harini
 * @generated
 */
public class SPJobApplicantsPortfolioSoap implements Serializable {
	public static SPJobApplicantsPortfolioSoap toSoapModel(
		SPJobApplicantsPortfolio model) {
		SPJobApplicantsPortfolioSoap soapModel = new SPJobApplicantsPortfolioSoap();

		soapModel.setJobApplyId(model.getJobApplyId());
		soapModel.setPorfolioId(model.getPorfolioId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());

		return soapModel;
	}

	public static SPJobApplicantsPortfolioSoap[] toSoapModels(
		SPJobApplicantsPortfolio[] models) {
		SPJobApplicantsPortfolioSoap[] soapModels = new SPJobApplicantsPortfolioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPJobApplicantsPortfolioSoap[][] toSoapModels(
		SPJobApplicantsPortfolio[][] models) {
		SPJobApplicantsPortfolioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPJobApplicantsPortfolioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPJobApplicantsPortfolioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPJobApplicantsPortfolioSoap[] toSoapModels(
		List<SPJobApplicantsPortfolio> models) {
		List<SPJobApplicantsPortfolioSoap> soapModels = new ArrayList<SPJobApplicantsPortfolioSoap>(models.size());

		for (SPJobApplicantsPortfolio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPJobApplicantsPortfolioSoap[soapModels.size()]);
	}

	public SPJobApplicantsPortfolioSoap() {
	}

	public SPJobApplicantsPortfolioPK getPrimaryKey() {
		return new SPJobApplicantsPortfolioPK(_jobApplyId, _porfolioId);
	}

	public void setPrimaryKey(SPJobApplicantsPortfolioPK pk) {
		setJobApplyId(pk.jobApplyId);
		setPorfolioId(pk.porfolioId);
	}

	public long getJobApplyId() {
		return _jobApplyId;
	}

	public void setJobApplyId(long jobApplyId) {
		_jobApplyId = jobApplyId;
	}

	public long getPorfolioId() {
		return _porfolioId;
	}

	public void setPorfolioId(long porfolioId) {
		_porfolioId = porfolioId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getExtra1() {
		return _extra1;
	}

	public void setExtra1(String extra1) {
		_extra1 = extra1;
	}

	public String getExtra2() {
		return _extra2;
	}

	public void setExtra2(String extra2) {
		_extra2 = extra2;
	}

	private long _jobApplyId;
	private long _porfolioId;
	private long _userId;
	private long _createdBy;
	private long _updatedBy;
	private Date _createDate;
	private Date _modifiedDate;
	private String _extra1;
	private String _extra2;
}