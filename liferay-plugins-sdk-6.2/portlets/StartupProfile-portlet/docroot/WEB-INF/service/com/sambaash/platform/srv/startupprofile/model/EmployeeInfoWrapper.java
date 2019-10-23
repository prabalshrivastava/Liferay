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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeInfo}.
 * </p>
 *
 * @author pradeep
 * @see EmployeeInfo
 * @generated
 */
public class EmployeeInfoWrapper implements EmployeeInfo,
	ModelWrapper<EmployeeInfo> {
	public EmployeeInfoWrapper(EmployeeInfo employeeInfo) {
		_employeeInfo = employeeInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeInfo.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("employeeInfoId", getEmployeeInfoId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("employees", getEmployees());
		attributes.put("directors", getDirectors());
		attributes.put("financeEmployees", getFinanceEmployees());
		attributes.put("professionalCandidates", getProfessionalCandidates());
		attributes.put("foundationCandidates", getFoundationCandidates());
		attributes.put("accountancyCandidates", getAccountancyCandidates());
		attributes.put("ISCAAccountants", getISCAAccountants());
		attributes.put("ICASAccountants", getICASAccountants());
		attributes.put("ICAEWAccountants", getICAEWAccountants());
		attributes.put("CAIAccountants", getCAIAccountants());
		attributes.put("ACCAAccountants", getACCAAccountants());
		attributes.put("CPAAccountants", getCPAAccountants());
		attributes.put("CAANZAccountants", getCAANZAccountants());
		attributes.put("CPACanadaAccountants", getCPACanadaAccountants());
		attributes.put("HKCPAAccountants", getHKCPAAccountants());
		attributes.put("SAICAAccountants", getSAICAAccountants());
		attributes.put("JICPAAccountants", getJICPAAccountants());
		attributes.put("AICPAAccountants", getAICPAAccountants());
		attributes.put("CIMAAccountants", getCIMAAccountants());
		attributes.put("othersAccountants", getOthersAccountants());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long employeeInfoId = (Long)attributes.get("employeeInfoId");

		if (employeeInfoId != null) {
			setEmployeeInfoId(employeeInfoId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String employees = (String)attributes.get("employees");

		if (employees != null) {
			setEmployees(employees);
		}

		String directors = (String)attributes.get("directors");

		if (directors != null) {
			setDirectors(directors);
		}

		String financeEmployees = (String)attributes.get("financeEmployees");

		if (financeEmployees != null) {
			setFinanceEmployees(financeEmployees);
		}

		String professionalCandidates = (String)attributes.get(
				"professionalCandidates");

		if (professionalCandidates != null) {
			setProfessionalCandidates(professionalCandidates);
		}

		String foundationCandidates = (String)attributes.get(
				"foundationCandidates");

		if (foundationCandidates != null) {
			setFoundationCandidates(foundationCandidates);
		}

		String accountancyCandidates = (String)attributes.get(
				"accountancyCandidates");

		if (accountancyCandidates != null) {
			setAccountancyCandidates(accountancyCandidates);
		}

		String ISCAAccountants = (String)attributes.get("ISCAAccountants");

		if (ISCAAccountants != null) {
			setISCAAccountants(ISCAAccountants);
		}

		String ICASAccountants = (String)attributes.get("ICASAccountants");

		if (ICASAccountants != null) {
			setICASAccountants(ICASAccountants);
		}

		String ICAEWAccountants = (String)attributes.get("ICAEWAccountants");

		if (ICAEWAccountants != null) {
			setICAEWAccountants(ICAEWAccountants);
		}

		String CAIAccountants = (String)attributes.get("CAIAccountants");

		if (CAIAccountants != null) {
			setCAIAccountants(CAIAccountants);
		}

		String ACCAAccountants = (String)attributes.get("ACCAAccountants");

		if (ACCAAccountants != null) {
			setACCAAccountants(ACCAAccountants);
		}

		String CPAAccountants = (String)attributes.get("CPAAccountants");

		if (CPAAccountants != null) {
			setCPAAccountants(CPAAccountants);
		}

		String CAANZAccountants = (String)attributes.get("CAANZAccountants");

		if (CAANZAccountants != null) {
			setCAANZAccountants(CAANZAccountants);
		}

		String CPACanadaAccountants = (String)attributes.get(
				"CPACanadaAccountants");

		if (CPACanadaAccountants != null) {
			setCPACanadaAccountants(CPACanadaAccountants);
		}

		String HKCPAAccountants = (String)attributes.get("HKCPAAccountants");

		if (HKCPAAccountants != null) {
			setHKCPAAccountants(HKCPAAccountants);
		}

		String SAICAAccountants = (String)attributes.get("SAICAAccountants");

		if (SAICAAccountants != null) {
			setSAICAAccountants(SAICAAccountants);
		}

		String JICPAAccountants = (String)attributes.get("JICPAAccountants");

		if (JICPAAccountants != null) {
			setJICPAAccountants(JICPAAccountants);
		}

		String AICPAAccountants = (String)attributes.get("AICPAAccountants");

		if (AICPAAccountants != null) {
			setAICPAAccountants(AICPAAccountants);
		}

		String CIMAAccountants = (String)attributes.get("CIMAAccountants");

		if (CIMAAccountants != null) {
			setCIMAAccountants(CIMAAccountants);
		}

		String othersAccountants = (String)attributes.get("othersAccountants");

		if (othersAccountants != null) {
			setOthersAccountants(othersAccountants);
		}
	}

	/**
	* Returns the primary key of this employee info.
	*
	* @return the primary key of this employee info
	*/
	@Override
	public long getPrimaryKey() {
		return _employeeInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee info.
	*
	* @param primaryKey the primary key of this employee info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employeeInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this employee info.
	*
	* @return the uuid of this employee info
	*/
	@Override
	public java.lang.String getUuid() {
		return _employeeInfo.getUuid();
	}

	/**
	* Sets the uuid of this employee info.
	*
	* @param uuid the uuid of this employee info
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_employeeInfo.setUuid(uuid);
	}

	/**
	* Returns the employee info ID of this employee info.
	*
	* @return the employee info ID of this employee info
	*/
	@Override
	public long getEmployeeInfoId() {
		return _employeeInfo.getEmployeeInfoId();
	}

	/**
	* Sets the employee info ID of this employee info.
	*
	* @param employeeInfoId the employee info ID of this employee info
	*/
	@Override
	public void setEmployeeInfoId(long employeeInfoId) {
		_employeeInfo.setEmployeeInfoId(employeeInfoId);
	}

	/**
	* Returns the organization ID of this employee info.
	*
	* @return the organization ID of this employee info
	*/
	@Override
	public long getOrganizationId() {
		return _employeeInfo.getOrganizationId();
	}

	/**
	* Sets the organization ID of this employee info.
	*
	* @param organizationId the organization ID of this employee info
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_employeeInfo.setOrganizationId(organizationId);
	}

	/**
	* Returns the employees of this employee info.
	*
	* @return the employees of this employee info
	*/
	@Override
	public java.lang.String getEmployees() {
		return _employeeInfo.getEmployees();
	}

	/**
	* Sets the employees of this employee info.
	*
	* @param employees the employees of this employee info
	*/
	@Override
	public void setEmployees(java.lang.String employees) {
		_employeeInfo.setEmployees(employees);
	}

	/**
	* Returns the directors of this employee info.
	*
	* @return the directors of this employee info
	*/
	@Override
	public java.lang.String getDirectors() {
		return _employeeInfo.getDirectors();
	}

	/**
	* Sets the directors of this employee info.
	*
	* @param directors the directors of this employee info
	*/
	@Override
	public void setDirectors(java.lang.String directors) {
		_employeeInfo.setDirectors(directors);
	}

	/**
	* Returns the finance employees of this employee info.
	*
	* @return the finance employees of this employee info
	*/
	@Override
	public java.lang.String getFinanceEmployees() {
		return _employeeInfo.getFinanceEmployees();
	}

	/**
	* Sets the finance employees of this employee info.
	*
	* @param financeEmployees the finance employees of this employee info
	*/
	@Override
	public void setFinanceEmployees(java.lang.String financeEmployees) {
		_employeeInfo.setFinanceEmployees(financeEmployees);
	}

	/**
	* Returns the professional candidates of this employee info.
	*
	* @return the professional candidates of this employee info
	*/
	@Override
	public java.lang.String getProfessionalCandidates() {
		return _employeeInfo.getProfessionalCandidates();
	}

	/**
	* Sets the professional candidates of this employee info.
	*
	* @param professionalCandidates the professional candidates of this employee info
	*/
	@Override
	public void setProfessionalCandidates(
		java.lang.String professionalCandidates) {
		_employeeInfo.setProfessionalCandidates(professionalCandidates);
	}

	/**
	* Returns the foundation candidates of this employee info.
	*
	* @return the foundation candidates of this employee info
	*/
	@Override
	public java.lang.String getFoundationCandidates() {
		return _employeeInfo.getFoundationCandidates();
	}

	/**
	* Sets the foundation candidates of this employee info.
	*
	* @param foundationCandidates the foundation candidates of this employee info
	*/
	@Override
	public void setFoundationCandidates(java.lang.String foundationCandidates) {
		_employeeInfo.setFoundationCandidates(foundationCandidates);
	}

	/**
	* Returns the accountancy candidates of this employee info.
	*
	* @return the accountancy candidates of this employee info
	*/
	@Override
	public java.lang.String getAccountancyCandidates() {
		return _employeeInfo.getAccountancyCandidates();
	}

	/**
	* Sets the accountancy candidates of this employee info.
	*
	* @param accountancyCandidates the accountancy candidates of this employee info
	*/
	@Override
	public void setAccountancyCandidates(java.lang.String accountancyCandidates) {
		_employeeInfo.setAccountancyCandidates(accountancyCandidates);
	}

	/**
	* Returns the i s c a accountants of this employee info.
	*
	* @return the i s c a accountants of this employee info
	*/
	@Override
	public java.lang.String getISCAAccountants() {
		return _employeeInfo.getISCAAccountants();
	}

	/**
	* Sets the i s c a accountants of this employee info.
	*
	* @param ISCAAccountants the i s c a accountants of this employee info
	*/
	@Override
	public void setISCAAccountants(java.lang.String ISCAAccountants) {
		_employeeInfo.setISCAAccountants(ISCAAccountants);
	}

	/**
	* Returns the i c a s accountants of this employee info.
	*
	* @return the i c a s accountants of this employee info
	*/
	@Override
	public java.lang.String getICASAccountants() {
		return _employeeInfo.getICASAccountants();
	}

	/**
	* Sets the i c a s accountants of this employee info.
	*
	* @param ICASAccountants the i c a s accountants of this employee info
	*/
	@Override
	public void setICASAccountants(java.lang.String ICASAccountants) {
		_employeeInfo.setICASAccountants(ICASAccountants);
	}

	/**
	* Returns the i c a e w accountants of this employee info.
	*
	* @return the i c a e w accountants of this employee info
	*/
	@Override
	public java.lang.String getICAEWAccountants() {
		return _employeeInfo.getICAEWAccountants();
	}

	/**
	* Sets the i c a e w accountants of this employee info.
	*
	* @param ICAEWAccountants the i c a e w accountants of this employee info
	*/
	@Override
	public void setICAEWAccountants(java.lang.String ICAEWAccountants) {
		_employeeInfo.setICAEWAccountants(ICAEWAccountants);
	}

	/**
	* Returns the c a i accountants of this employee info.
	*
	* @return the c a i accountants of this employee info
	*/
	@Override
	public java.lang.String getCAIAccountants() {
		return _employeeInfo.getCAIAccountants();
	}

	/**
	* Sets the c a i accountants of this employee info.
	*
	* @param CAIAccountants the c a i accountants of this employee info
	*/
	@Override
	public void setCAIAccountants(java.lang.String CAIAccountants) {
		_employeeInfo.setCAIAccountants(CAIAccountants);
	}

	/**
	* Returns the a c c a accountants of this employee info.
	*
	* @return the a c c a accountants of this employee info
	*/
	@Override
	public java.lang.String getACCAAccountants() {
		return _employeeInfo.getACCAAccountants();
	}

	/**
	* Sets the a c c a accountants of this employee info.
	*
	* @param ACCAAccountants the a c c a accountants of this employee info
	*/
	@Override
	public void setACCAAccountants(java.lang.String ACCAAccountants) {
		_employeeInfo.setACCAAccountants(ACCAAccountants);
	}

	/**
	* Returns the c p a accountants of this employee info.
	*
	* @return the c p a accountants of this employee info
	*/
	@Override
	public java.lang.String getCPAAccountants() {
		return _employeeInfo.getCPAAccountants();
	}

	/**
	* Sets the c p a accountants of this employee info.
	*
	* @param CPAAccountants the c p a accountants of this employee info
	*/
	@Override
	public void setCPAAccountants(java.lang.String CPAAccountants) {
		_employeeInfo.setCPAAccountants(CPAAccountants);
	}

	/**
	* Returns the c a a n z accountants of this employee info.
	*
	* @return the c a a n z accountants of this employee info
	*/
	@Override
	public java.lang.String getCAANZAccountants() {
		return _employeeInfo.getCAANZAccountants();
	}

	/**
	* Sets the c a a n z accountants of this employee info.
	*
	* @param CAANZAccountants the c a a n z accountants of this employee info
	*/
	@Override
	public void setCAANZAccountants(java.lang.String CAANZAccountants) {
		_employeeInfo.setCAANZAccountants(CAANZAccountants);
	}

	/**
	* Returns the c p a canada accountants of this employee info.
	*
	* @return the c p a canada accountants of this employee info
	*/
	@Override
	public java.lang.String getCPACanadaAccountants() {
		return _employeeInfo.getCPACanadaAccountants();
	}

	/**
	* Sets the c p a canada accountants of this employee info.
	*
	* @param CPACanadaAccountants the c p a canada accountants of this employee info
	*/
	@Override
	public void setCPACanadaAccountants(java.lang.String CPACanadaAccountants) {
		_employeeInfo.setCPACanadaAccountants(CPACanadaAccountants);
	}

	/**
	* Returns the h k c p a accountants of this employee info.
	*
	* @return the h k c p a accountants of this employee info
	*/
	@Override
	public java.lang.String getHKCPAAccountants() {
		return _employeeInfo.getHKCPAAccountants();
	}

	/**
	* Sets the h k c p a accountants of this employee info.
	*
	* @param HKCPAAccountants the h k c p a accountants of this employee info
	*/
	@Override
	public void setHKCPAAccountants(java.lang.String HKCPAAccountants) {
		_employeeInfo.setHKCPAAccountants(HKCPAAccountants);
	}

	/**
	* Returns the s a i c a accountants of this employee info.
	*
	* @return the s a i c a accountants of this employee info
	*/
	@Override
	public java.lang.String getSAICAAccountants() {
		return _employeeInfo.getSAICAAccountants();
	}

	/**
	* Sets the s a i c a accountants of this employee info.
	*
	* @param SAICAAccountants the s a i c a accountants of this employee info
	*/
	@Override
	public void setSAICAAccountants(java.lang.String SAICAAccountants) {
		_employeeInfo.setSAICAAccountants(SAICAAccountants);
	}

	/**
	* Returns the j i c p a accountants of this employee info.
	*
	* @return the j i c p a accountants of this employee info
	*/
	@Override
	public java.lang.String getJICPAAccountants() {
		return _employeeInfo.getJICPAAccountants();
	}

	/**
	* Sets the j i c p a accountants of this employee info.
	*
	* @param JICPAAccountants the j i c p a accountants of this employee info
	*/
	@Override
	public void setJICPAAccountants(java.lang.String JICPAAccountants) {
		_employeeInfo.setJICPAAccountants(JICPAAccountants);
	}

	/**
	* Returns the a i c p a accountants of this employee info.
	*
	* @return the a i c p a accountants of this employee info
	*/
	@Override
	public java.lang.String getAICPAAccountants() {
		return _employeeInfo.getAICPAAccountants();
	}

	/**
	* Sets the a i c p a accountants of this employee info.
	*
	* @param AICPAAccountants the a i c p a accountants of this employee info
	*/
	@Override
	public void setAICPAAccountants(java.lang.String AICPAAccountants) {
		_employeeInfo.setAICPAAccountants(AICPAAccountants);
	}

	/**
	* Returns the c i m a accountants of this employee info.
	*
	* @return the c i m a accountants of this employee info
	*/
	@Override
	public java.lang.String getCIMAAccountants() {
		return _employeeInfo.getCIMAAccountants();
	}

	/**
	* Sets the c i m a accountants of this employee info.
	*
	* @param CIMAAccountants the c i m a accountants of this employee info
	*/
	@Override
	public void setCIMAAccountants(java.lang.String CIMAAccountants) {
		_employeeInfo.setCIMAAccountants(CIMAAccountants);
	}

	/**
	* Returns the others accountants of this employee info.
	*
	* @return the others accountants of this employee info
	*/
	@Override
	public java.lang.String getOthersAccountants() {
		return _employeeInfo.getOthersAccountants();
	}

	/**
	* Sets the others accountants of this employee info.
	*
	* @param othersAccountants the others accountants of this employee info
	*/
	@Override
	public void setOthersAccountants(java.lang.String othersAccountants) {
		_employeeInfo.setOthersAccountants(othersAccountants);
	}

	@Override
	public boolean isNew() {
		return _employeeInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employeeInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employeeInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employeeInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employeeInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employeeInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employeeInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employeeInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employeeInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employeeInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employeeInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeInfoWrapper((EmployeeInfo)_employeeInfo.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.EmployeeInfo employeeInfo) {
		return _employeeInfo.compareTo(employeeInfo);
	}

	@Override
	public int hashCode() {
		return _employeeInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.EmployeeInfo> toCacheModel() {
		return _employeeInfo.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.EmployeeInfo toEscapedModel() {
		return new EmployeeInfoWrapper(_employeeInfo.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.EmployeeInfo toUnescapedModel() {
		return new EmployeeInfoWrapper(_employeeInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employeeInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employeeInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeInfoWrapper)) {
			return false;
		}

		EmployeeInfoWrapper employeeInfoWrapper = (EmployeeInfoWrapper)obj;

		if (Validator.equals(_employeeInfo, employeeInfoWrapper._employeeInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmployeeInfo getWrappedEmployeeInfo() {
		return _employeeInfo;
	}

	@Override
	public EmployeeInfo getWrappedModel() {
		return _employeeInfo;
	}

	@Override
	public void resetOriginalValues() {
		_employeeInfo.resetOriginalValues();
	}

	private EmployeeInfo _employeeInfo;
}