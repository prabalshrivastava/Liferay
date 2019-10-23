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

package com.sambaash.platform.srv.startupprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class EmployeeInfoSoap implements Serializable {
	public static EmployeeInfoSoap toSoapModel(EmployeeInfo model) {
		EmployeeInfoSoap soapModel = new EmployeeInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeeInfoId(model.getEmployeeInfoId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setEmployees(model.getEmployees());
		soapModel.setDirectors(model.getDirectors());
		soapModel.setFinanceEmployees(model.getFinanceEmployees());
		soapModel.setProfessionalCandidates(model.getProfessionalCandidates());
		soapModel.setFoundationCandidates(model.getFoundationCandidates());
		soapModel.setAccountancyCandidates(model.getAccountancyCandidates());
		soapModel.setISCAAccountants(model.getISCAAccountants());
		soapModel.setICASAccountants(model.getICASAccountants());
		soapModel.setICAEWAccountants(model.getICAEWAccountants());
		soapModel.setCAIAccountants(model.getCAIAccountants());
		soapModel.setACCAAccountants(model.getACCAAccountants());
		soapModel.setCPAAccountants(model.getCPAAccountants());
		soapModel.setCAANZAccountants(model.getCAANZAccountants());
		soapModel.setCPACanadaAccountants(model.getCPACanadaAccountants());
		soapModel.setHKCPAAccountants(model.getHKCPAAccountants());
		soapModel.setSAICAAccountants(model.getSAICAAccountants());
		soapModel.setJICPAAccountants(model.getJICPAAccountants());
		soapModel.setAICPAAccountants(model.getAICPAAccountants());
		soapModel.setCIMAAccountants(model.getCIMAAccountants());
		soapModel.setOthersAccountants(model.getOthersAccountants());

		return soapModel;
	}

	public static EmployeeInfoSoap[] toSoapModels(EmployeeInfo[] models) {
		EmployeeInfoSoap[] soapModels = new EmployeeInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeInfoSoap[][] toSoapModels(EmployeeInfo[][] models) {
		EmployeeInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeInfoSoap[] toSoapModels(List<EmployeeInfo> models) {
		List<EmployeeInfoSoap> soapModels = new ArrayList<EmployeeInfoSoap>(models.size());

		for (EmployeeInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeInfoSoap[soapModels.size()]);
	}

	public EmployeeInfoSoap() {
	}

	public long getPrimaryKey() {
		return _employeeInfoId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeInfoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeeInfoId() {
		return _employeeInfoId;
	}

	public void setEmployeeInfoId(long employeeInfoId) {
		_employeeInfoId = employeeInfoId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getEmployees() {
		return _employees;
	}

	public void setEmployees(String employees) {
		_employees = employees;
	}

	public String getDirectors() {
		return _directors;
	}

	public void setDirectors(String directors) {
		_directors = directors;
	}

	public String getFinanceEmployees() {
		return _financeEmployees;
	}

	public void setFinanceEmployees(String financeEmployees) {
		_financeEmployees = financeEmployees;
	}

	public String getProfessionalCandidates() {
		return _professionalCandidates;
	}

	public void setProfessionalCandidates(String professionalCandidates) {
		_professionalCandidates = professionalCandidates;
	}

	public String getFoundationCandidates() {
		return _foundationCandidates;
	}

	public void setFoundationCandidates(String foundationCandidates) {
		_foundationCandidates = foundationCandidates;
	}

	public String getAccountancyCandidates() {
		return _accountancyCandidates;
	}

	public void setAccountancyCandidates(String accountancyCandidates) {
		_accountancyCandidates = accountancyCandidates;
	}

	public String getISCAAccountants() {
		return _ISCAAccountants;
	}

	public void setISCAAccountants(String ISCAAccountants) {
		_ISCAAccountants = ISCAAccountants;
	}

	public String getICASAccountants() {
		return _ICASAccountants;
	}

	public void setICASAccountants(String ICASAccountants) {
		_ICASAccountants = ICASAccountants;
	}

	public String getICAEWAccountants() {
		return _ICAEWAccountants;
	}

	public void setICAEWAccountants(String ICAEWAccountants) {
		_ICAEWAccountants = ICAEWAccountants;
	}

	public String getCAIAccountants() {
		return _CAIAccountants;
	}

	public void setCAIAccountants(String CAIAccountants) {
		_CAIAccountants = CAIAccountants;
	}

	public String getACCAAccountants() {
		return _ACCAAccountants;
	}

	public void setACCAAccountants(String ACCAAccountants) {
		_ACCAAccountants = ACCAAccountants;
	}

	public String getCPAAccountants() {
		return _CPAAccountants;
	}

	public void setCPAAccountants(String CPAAccountants) {
		_CPAAccountants = CPAAccountants;
	}

	public String getCAANZAccountants() {
		return _CAANZAccountants;
	}

	public void setCAANZAccountants(String CAANZAccountants) {
		_CAANZAccountants = CAANZAccountants;
	}

	public String getCPACanadaAccountants() {
		return _CPACanadaAccountants;
	}

	public void setCPACanadaAccountants(String CPACanadaAccountants) {
		_CPACanadaAccountants = CPACanadaAccountants;
	}

	public String getHKCPAAccountants() {
		return _HKCPAAccountants;
	}

	public void setHKCPAAccountants(String HKCPAAccountants) {
		_HKCPAAccountants = HKCPAAccountants;
	}

	public String getSAICAAccountants() {
		return _SAICAAccountants;
	}

	public void setSAICAAccountants(String SAICAAccountants) {
		_SAICAAccountants = SAICAAccountants;
	}

	public String getJICPAAccountants() {
		return _JICPAAccountants;
	}

	public void setJICPAAccountants(String JICPAAccountants) {
		_JICPAAccountants = JICPAAccountants;
	}

	public String getAICPAAccountants() {
		return _AICPAAccountants;
	}

	public void setAICPAAccountants(String AICPAAccountants) {
		_AICPAAccountants = AICPAAccountants;
	}

	public String getCIMAAccountants() {
		return _CIMAAccountants;
	}

	public void setCIMAAccountants(String CIMAAccountants) {
		_CIMAAccountants = CIMAAccountants;
	}

	public String getOthersAccountants() {
		return _othersAccountants;
	}

	public void setOthersAccountants(String othersAccountants) {
		_othersAccountants = othersAccountants;
	}

	private String _uuid;
	private long _employeeInfoId;
	private long _organizationId;
	private String _employees;
	private String _directors;
	private String _financeEmployees;
	private String _professionalCandidates;
	private String _foundationCandidates;
	private String _accountancyCandidates;
	private String _ISCAAccountants;
	private String _ICASAccountants;
	private String _ICAEWAccountants;
	private String _CAIAccountants;
	private String _ACCAAccountants;
	private String _CPAAccountants;
	private String _CAANZAccountants;
	private String _CPACanadaAccountants;
	private String _HKCPAAccountants;
	private String _SAICAAccountants;
	private String _JICPAAccountants;
	private String _AICPAAccountants;
	private String _CIMAAccountants;
	private String _othersAccountants;
}