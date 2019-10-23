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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.EmployeeInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmployeeInfo in entity cache.
 *
 * @author pradeep
 * @see EmployeeInfo
 * @generated
 */
public class EmployeeInfoCacheModel implements CacheModel<EmployeeInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeInfoId=");
		sb.append(employeeInfoId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", employees=");
		sb.append(employees);
		sb.append(", directors=");
		sb.append(directors);
		sb.append(", financeEmployees=");
		sb.append(financeEmployees);
		sb.append(", professionalCandidates=");
		sb.append(professionalCandidates);
		sb.append(", foundationCandidates=");
		sb.append(foundationCandidates);
		sb.append(", accountancyCandidates=");
		sb.append(accountancyCandidates);
		sb.append(", ISCAAccountants=");
		sb.append(ISCAAccountants);
		sb.append(", ICASAccountants=");
		sb.append(ICASAccountants);
		sb.append(", ICAEWAccountants=");
		sb.append(ICAEWAccountants);
		sb.append(", CAIAccountants=");
		sb.append(CAIAccountants);
		sb.append(", ACCAAccountants=");
		sb.append(ACCAAccountants);
		sb.append(", CPAAccountants=");
		sb.append(CPAAccountants);
		sb.append(", CAANZAccountants=");
		sb.append(CAANZAccountants);
		sb.append(", CPACanadaAccountants=");
		sb.append(CPACanadaAccountants);
		sb.append(", HKCPAAccountants=");
		sb.append(HKCPAAccountants);
		sb.append(", SAICAAccountants=");
		sb.append(SAICAAccountants);
		sb.append(", JICPAAccountants=");
		sb.append(JICPAAccountants);
		sb.append(", AICPAAccountants=");
		sb.append(AICPAAccountants);
		sb.append(", CIMAAccountants=");
		sb.append(CIMAAccountants);
		sb.append(", othersAccountants=");
		sb.append(othersAccountants);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeInfo toEntityModel() {
		EmployeeInfoImpl employeeInfoImpl = new EmployeeInfoImpl();

		if (uuid == null) {
			employeeInfoImpl.setUuid(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setUuid(uuid);
		}

		employeeInfoImpl.setEmployeeInfoId(employeeInfoId);
		employeeInfoImpl.setOrganizationId(organizationId);

		if (employees == null) {
			employeeInfoImpl.setEmployees(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setEmployees(employees);
		}

		if (directors == null) {
			employeeInfoImpl.setDirectors(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setDirectors(directors);
		}

		if (financeEmployees == null) {
			employeeInfoImpl.setFinanceEmployees(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setFinanceEmployees(financeEmployees);
		}

		if (professionalCandidates == null) {
			employeeInfoImpl.setProfessionalCandidates(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setProfessionalCandidates(professionalCandidates);
		}

		if (foundationCandidates == null) {
			employeeInfoImpl.setFoundationCandidates(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setFoundationCandidates(foundationCandidates);
		}

		if (accountancyCandidates == null) {
			employeeInfoImpl.setAccountancyCandidates(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setAccountancyCandidates(accountancyCandidates);
		}

		if (ISCAAccountants == null) {
			employeeInfoImpl.setISCAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setISCAAccountants(ISCAAccountants);
		}

		if (ICASAccountants == null) {
			employeeInfoImpl.setICASAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setICASAccountants(ICASAccountants);
		}

		if (ICAEWAccountants == null) {
			employeeInfoImpl.setICAEWAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setICAEWAccountants(ICAEWAccountants);
		}

		if (CAIAccountants == null) {
			employeeInfoImpl.setCAIAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setCAIAccountants(CAIAccountants);
		}

		if (ACCAAccountants == null) {
			employeeInfoImpl.setACCAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setACCAAccountants(ACCAAccountants);
		}

		if (CPAAccountants == null) {
			employeeInfoImpl.setCPAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setCPAAccountants(CPAAccountants);
		}

		if (CAANZAccountants == null) {
			employeeInfoImpl.setCAANZAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setCAANZAccountants(CAANZAccountants);
		}

		if (CPACanadaAccountants == null) {
			employeeInfoImpl.setCPACanadaAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setCPACanadaAccountants(CPACanadaAccountants);
		}

		if (HKCPAAccountants == null) {
			employeeInfoImpl.setHKCPAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setHKCPAAccountants(HKCPAAccountants);
		}

		if (SAICAAccountants == null) {
			employeeInfoImpl.setSAICAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setSAICAAccountants(SAICAAccountants);
		}

		if (JICPAAccountants == null) {
			employeeInfoImpl.setJICPAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setJICPAAccountants(JICPAAccountants);
		}

		if (AICPAAccountants == null) {
			employeeInfoImpl.setAICPAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setAICPAAccountants(AICPAAccountants);
		}

		if (CIMAAccountants == null) {
			employeeInfoImpl.setCIMAAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setCIMAAccountants(CIMAAccountants);
		}

		if (othersAccountants == null) {
			employeeInfoImpl.setOthersAccountants(StringPool.BLANK);
		}
		else {
			employeeInfoImpl.setOthersAccountants(othersAccountants);
		}

		employeeInfoImpl.resetOriginalValues();

		return employeeInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		employeeInfoId = objectInput.readLong();
		organizationId = objectInput.readLong();
		employees = objectInput.readUTF();
		directors = objectInput.readUTF();
		financeEmployees = objectInput.readUTF();
		professionalCandidates = objectInput.readUTF();
		foundationCandidates = objectInput.readUTF();
		accountancyCandidates = objectInput.readUTF();
		ISCAAccountants = objectInput.readUTF();
		ICASAccountants = objectInput.readUTF();
		ICAEWAccountants = objectInput.readUTF();
		CAIAccountants = objectInput.readUTF();
		ACCAAccountants = objectInput.readUTF();
		CPAAccountants = objectInput.readUTF();
		CAANZAccountants = objectInput.readUTF();
		CPACanadaAccountants = objectInput.readUTF();
		HKCPAAccountants = objectInput.readUTF();
		SAICAAccountants = objectInput.readUTF();
		JICPAAccountants = objectInput.readUTF();
		AICPAAccountants = objectInput.readUTF();
		CIMAAccountants = objectInput.readUTF();
		othersAccountants = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeInfoId);
		objectOutput.writeLong(organizationId);

		if (employees == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employees);
		}

		if (directors == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(directors);
		}

		if (financeEmployees == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financeEmployees);
		}

		if (professionalCandidates == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(professionalCandidates);
		}

		if (foundationCandidates == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(foundationCandidates);
		}

		if (accountancyCandidates == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accountancyCandidates);
		}

		if (ISCAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ISCAAccountants);
		}

		if (ICASAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ICASAccountants);
		}

		if (ICAEWAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ICAEWAccountants);
		}

		if (CAIAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CAIAccountants);
		}

		if (ACCAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ACCAAccountants);
		}

		if (CPAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CPAAccountants);
		}

		if (CAANZAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CAANZAccountants);
		}

		if (CPACanadaAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CPACanadaAccountants);
		}

		if (HKCPAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(HKCPAAccountants);
		}

		if (SAICAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(SAICAAccountants);
		}

		if (JICPAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(JICPAAccountants);
		}

		if (AICPAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(AICPAAccountants);
		}

		if (CIMAAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CIMAAccountants);
		}

		if (othersAccountants == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(othersAccountants);
		}
	}

	public String uuid;
	public long employeeInfoId;
	public long organizationId;
	public String employees;
	public String directors;
	public String financeEmployees;
	public String professionalCandidates;
	public String foundationCandidates;
	public String accountancyCandidates;
	public String ISCAAccountants;
	public String ICASAccountants;
	public String ICAEWAccountants;
	public String CAIAccountants;
	public String ACCAAccountants;
	public String CPAAccountants;
	public String CAANZAccountants;
	public String CPACanadaAccountants;
	public String HKCPAAccountants;
	public String SAICAAccountants;
	public String JICPAAccountants;
	public String AICPAAccountants;
	public String CIMAAccountants;
	public String othersAccountants;
}