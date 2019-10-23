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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class EmployeeInfoClp extends BaseModelImpl<EmployeeInfo>
	implements EmployeeInfo {
	public EmployeeInfoClp() {
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
	public long getPrimaryKey() {
		return _employeeInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_employeeInfoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeInfoId() {
		return _employeeInfoId;
	}

	@Override
	public void setEmployeeInfoId(long employeeInfoId) {
		_employeeInfoId = employeeInfoId;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeInfoId", long.class);

				method.invoke(_employeeInfoRemoteModel, employeeInfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_employeeInfoRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployees() {
		return _employees;
	}

	@Override
	public void setEmployees(String employees) {
		_employees = employees;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployees", String.class);

				method.invoke(_employeeInfoRemoteModel, employees);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDirectors() {
		return _directors;
	}

	@Override
	public void setDirectors(String directors) {
		_directors = directors;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDirectors", String.class);

				method.invoke(_employeeInfoRemoteModel, directors);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinanceEmployees() {
		return _financeEmployees;
	}

	@Override
	public void setFinanceEmployees(String financeEmployees) {
		_financeEmployees = financeEmployees;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFinanceEmployees",
						String.class);

				method.invoke(_employeeInfoRemoteModel, financeEmployees);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProfessionalCandidates() {
		return _professionalCandidates;
	}

	@Override
	public void setProfessionalCandidates(String professionalCandidates) {
		_professionalCandidates = professionalCandidates;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setProfessionalCandidates",
						String.class);

				method.invoke(_employeeInfoRemoteModel, professionalCandidates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFoundationCandidates() {
		return _foundationCandidates;
	}

	@Override
	public void setFoundationCandidates(String foundationCandidates) {
		_foundationCandidates = foundationCandidates;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFoundationCandidates",
						String.class);

				method.invoke(_employeeInfoRemoteModel, foundationCandidates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccountancyCandidates() {
		return _accountancyCandidates;
	}

	@Override
	public void setAccountancyCandidates(String accountancyCandidates) {
		_accountancyCandidates = accountancyCandidates;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountancyCandidates",
						String.class);

				method.invoke(_employeeInfoRemoteModel, accountancyCandidates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getISCAAccountants() {
		return _ISCAAccountants;
	}

	@Override
	public void setISCAAccountants(String ISCAAccountants) {
		_ISCAAccountants = ISCAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setISCAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, ISCAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getICASAccountants() {
		return _ICASAccountants;
	}

	@Override
	public void setICASAccountants(String ICASAccountants) {
		_ICASAccountants = ICASAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setICASAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, ICASAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getICAEWAccountants() {
		return _ICAEWAccountants;
	}

	@Override
	public void setICAEWAccountants(String ICAEWAccountants) {
		_ICAEWAccountants = ICAEWAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setICAEWAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, ICAEWAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCAIAccountants() {
		return _CAIAccountants;
	}

	@Override
	public void setCAIAccountants(String CAIAccountants) {
		_CAIAccountants = CAIAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCAIAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, CAIAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getACCAAccountants() {
		return _ACCAAccountants;
	}

	@Override
	public void setACCAAccountants(String ACCAAccountants) {
		_ACCAAccountants = ACCAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setACCAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, ACCAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCPAAccountants() {
		return _CPAAccountants;
	}

	@Override
	public void setCPAAccountants(String CPAAccountants) {
		_CPAAccountants = CPAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCPAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, CPAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCAANZAccountants() {
		return _CAANZAccountants;
	}

	@Override
	public void setCAANZAccountants(String CAANZAccountants) {
		_CAANZAccountants = CAANZAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCAANZAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, CAANZAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCPACanadaAccountants() {
		return _CPACanadaAccountants;
	}

	@Override
	public void setCPACanadaAccountants(String CPACanadaAccountants) {
		_CPACanadaAccountants = CPACanadaAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCPACanadaAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, CPACanadaAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHKCPAAccountants() {
		return _HKCPAAccountants;
	}

	@Override
	public void setHKCPAAccountants(String HKCPAAccountants) {
		_HKCPAAccountants = HKCPAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setHKCPAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, HKCPAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSAICAAccountants() {
		return _SAICAAccountants;
	}

	@Override
	public void setSAICAAccountants(String SAICAAccountants) {
		_SAICAAccountants = SAICAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSAICAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, SAICAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJICPAAccountants() {
		return _JICPAAccountants;
	}

	@Override
	public void setJICPAAccountants(String JICPAAccountants) {
		_JICPAAccountants = JICPAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setJICPAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, JICPAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAICPAAccountants() {
		return _AICPAAccountants;
	}

	@Override
	public void setAICPAAccountants(String AICPAAccountants) {
		_AICPAAccountants = AICPAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAICPAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, AICPAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCIMAAccountants() {
		return _CIMAAccountants;
	}

	@Override
	public void setCIMAAccountants(String CIMAAccountants) {
		_CIMAAccountants = CIMAAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCIMAAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, CIMAAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOthersAccountants() {
		return _othersAccountants;
	}

	@Override
	public void setOthersAccountants(String othersAccountants) {
		_othersAccountants = othersAccountants;

		if (_employeeInfoRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setOthersAccountants",
						String.class);

				method.invoke(_employeeInfoRemoteModel, othersAccountants);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmployeeInfoRemoteModel() {
		return _employeeInfoRemoteModel;
	}

	public void setEmployeeInfoRemoteModel(BaseModel<?> employeeInfoRemoteModel) {
		_employeeInfoRemoteModel = employeeInfoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _employeeInfoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_employeeInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeInfoLocalServiceUtil.addEmployeeInfo(this);
		}
		else {
			EmployeeInfoLocalServiceUtil.updateEmployeeInfo(this);
		}
	}

	@Override
	public EmployeeInfo toEscapedModel() {
		return (EmployeeInfo)ProxyUtil.newProxyInstance(EmployeeInfo.class.getClassLoader(),
			new Class[] { EmployeeInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeInfoClp clone = new EmployeeInfoClp();

		clone.setUuid(getUuid());
		clone.setEmployeeInfoId(getEmployeeInfoId());
		clone.setOrganizationId(getOrganizationId());
		clone.setEmployees(getEmployees());
		clone.setDirectors(getDirectors());
		clone.setFinanceEmployees(getFinanceEmployees());
		clone.setProfessionalCandidates(getProfessionalCandidates());
		clone.setFoundationCandidates(getFoundationCandidates());
		clone.setAccountancyCandidates(getAccountancyCandidates());
		clone.setISCAAccountants(getISCAAccountants());
		clone.setICASAccountants(getICASAccountants());
		clone.setICAEWAccountants(getICAEWAccountants());
		clone.setCAIAccountants(getCAIAccountants());
		clone.setACCAAccountants(getACCAAccountants());
		clone.setCPAAccountants(getCPAAccountants());
		clone.setCAANZAccountants(getCAANZAccountants());
		clone.setCPACanadaAccountants(getCPACanadaAccountants());
		clone.setHKCPAAccountants(getHKCPAAccountants());
		clone.setSAICAAccountants(getSAICAAccountants());
		clone.setJICPAAccountants(getJICPAAccountants());
		clone.setAICPAAccountants(getAICPAAccountants());
		clone.setCIMAAccountants(getCIMAAccountants());
		clone.setOthersAccountants(getOthersAccountants());

		return clone;
	}

	@Override
	public int compareTo(EmployeeInfo employeeInfo) {
		long primaryKey = employeeInfo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeInfoClp)) {
			return false;
		}

		EmployeeInfoClp employeeInfo = (EmployeeInfoClp)obj;

		long primaryKey = employeeInfo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", employeeInfoId=");
		sb.append(getEmployeeInfoId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", employees=");
		sb.append(getEmployees());
		sb.append(", directors=");
		sb.append(getDirectors());
		sb.append(", financeEmployees=");
		sb.append(getFinanceEmployees());
		sb.append(", professionalCandidates=");
		sb.append(getProfessionalCandidates());
		sb.append(", foundationCandidates=");
		sb.append(getFoundationCandidates());
		sb.append(", accountancyCandidates=");
		sb.append(getAccountancyCandidates());
		sb.append(", ISCAAccountants=");
		sb.append(getISCAAccountants());
		sb.append(", ICASAccountants=");
		sb.append(getICASAccountants());
		sb.append(", ICAEWAccountants=");
		sb.append(getICAEWAccountants());
		sb.append(", CAIAccountants=");
		sb.append(getCAIAccountants());
		sb.append(", ACCAAccountants=");
		sb.append(getACCAAccountants());
		sb.append(", CPAAccountants=");
		sb.append(getCPAAccountants());
		sb.append(", CAANZAccountants=");
		sb.append(getCAANZAccountants());
		sb.append(", CPACanadaAccountants=");
		sb.append(getCPACanadaAccountants());
		sb.append(", HKCPAAccountants=");
		sb.append(getHKCPAAccountants());
		sb.append(", SAICAAccountants=");
		sb.append(getSAICAAccountants());
		sb.append(", JICPAAccountants=");
		sb.append(getJICPAAccountants());
		sb.append(", AICPAAccountants=");
		sb.append(getAICPAAccountants());
		sb.append(", CIMAAccountants=");
		sb.append(getCIMAAccountants());
		sb.append(", othersAccountants=");
		sb.append(getOthersAccountants());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.EmployeeInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeInfoId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employees</column-name><column-value><![CDATA[");
		sb.append(getEmployees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>directors</column-name><column-value><![CDATA[");
		sb.append(getDirectors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financeEmployees</column-name><column-value><![CDATA[");
		sb.append(getFinanceEmployees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>professionalCandidates</column-name><column-value><![CDATA[");
		sb.append(getProfessionalCandidates());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foundationCandidates</column-name><column-value><![CDATA[");
		sb.append(getFoundationCandidates());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountancyCandidates</column-name><column-value><![CDATA[");
		sb.append(getAccountancyCandidates());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ISCAAccountants</column-name><column-value><![CDATA[");
		sb.append(getISCAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ICASAccountants</column-name><column-value><![CDATA[");
		sb.append(getICASAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ICAEWAccountants</column-name><column-value><![CDATA[");
		sb.append(getICAEWAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CAIAccountants</column-name><column-value><![CDATA[");
		sb.append(getCAIAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ACCAAccountants</column-name><column-value><![CDATA[");
		sb.append(getACCAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPAAccountants</column-name><column-value><![CDATA[");
		sb.append(getCPAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CAANZAccountants</column-name><column-value><![CDATA[");
		sb.append(getCAANZAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPACanadaAccountants</column-name><column-value><![CDATA[");
		sb.append(getCPACanadaAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HKCPAAccountants</column-name><column-value><![CDATA[");
		sb.append(getHKCPAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SAICAAccountants</column-name><column-value><![CDATA[");
		sb.append(getSAICAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JICPAAccountants</column-name><column-value><![CDATA[");
		sb.append(getJICPAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AICPAAccountants</column-name><column-value><![CDATA[");
		sb.append(getAICPAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CIMAAccountants</column-name><column-value><![CDATA[");
		sb.append(getCIMAAccountants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>othersAccountants</column-name><column-value><![CDATA[");
		sb.append(getOthersAccountants());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _employeeInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}