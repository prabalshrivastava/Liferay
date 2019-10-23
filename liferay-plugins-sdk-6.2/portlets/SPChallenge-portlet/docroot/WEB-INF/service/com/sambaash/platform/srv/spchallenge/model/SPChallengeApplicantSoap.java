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

package com.sambaash.platform.srv.spchallenge.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class SPChallengeApplicantSoap implements Serializable {
	public static SPChallengeApplicantSoap toSoapModel(
		SPChallengeApplicant model) {
		SPChallengeApplicantSoap soapModel = new SPChallengeApplicantSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpChallengeApplicantId(model.getSpChallengeApplicantId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApplicantRefId(model.getApplicantRefId());
		soapModel.setApplicantType(model.getApplicantType());
		soapModel.setSpChallengeId(model.getSpChallengeId());
		soapModel.setQ1(model.getQ1());
		soapModel.setQ2(model.getQ2());
		soapModel.setQ3(model.getQ3());
		soapModel.setQ4(model.getQ4());
		soapModel.setQ5(model.getQ5());
		soapModel.setQ6(model.getQ6());
		soapModel.setQ7(model.getQ7());
		soapModel.setQ8(model.getQ8());
		soapModel.setQ9(model.getQ9());
		soapModel.setQ10(model.getQ10());
		soapModel.setQ11(model.getQ11());
		soapModel.setQ12(model.getQ12());
		soapModel.setQ13(model.getQ13());
		soapModel.setQ14(model.getQ14());
		soapModel.setQ15(model.getQ15());
		soapModel.setQ16(model.getQ16());
		soapModel.setQ17(model.getQ17());
		soapModel.setQ18(model.getQ18());
		soapModel.setQ19(model.getQ19());
		soapModel.setQ20(model.getQ20());
		soapModel.setCustomStatus1(model.getCustomStatus1());
		soapModel.setCustomStatus2(model.getCustomStatus2());
		soapModel.setActive(model.getActive());
		soapModel.setApplicationStatus(model.getApplicationStatus());
		soapModel.setNotificationStatus(model.getNotificationStatus());

		return soapModel;
	}

	public static SPChallengeApplicantSoap[] toSoapModels(
		SPChallengeApplicant[] models) {
		SPChallengeApplicantSoap[] soapModels = new SPChallengeApplicantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPChallengeApplicantSoap[][] toSoapModels(
		SPChallengeApplicant[][] models) {
		SPChallengeApplicantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPChallengeApplicantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPChallengeApplicantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPChallengeApplicantSoap[] toSoapModels(
		List<SPChallengeApplicant> models) {
		List<SPChallengeApplicantSoap> soapModels = new ArrayList<SPChallengeApplicantSoap>(models.size());

		for (SPChallengeApplicant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPChallengeApplicantSoap[soapModels.size()]);
	}

	public SPChallengeApplicantSoap() {
	}

	public long getPrimaryKey() {
		return _spChallengeApplicantId;
	}

	public void setPrimaryKey(long pk) {
		setSpChallengeApplicantId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpChallengeApplicantId() {
		return _spChallengeApplicantId;
	}

	public void setSpChallengeApplicantId(long spChallengeApplicantId) {
		_spChallengeApplicantId = spChallengeApplicantId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getApplicantRefId() {
		return _applicantRefId;
	}

	public void setApplicantRefId(long applicantRefId) {
		_applicantRefId = applicantRefId;
	}

	public String getApplicantType() {
		return _applicantType;
	}

	public void setApplicantType(String applicantType) {
		_applicantType = applicantType;
	}

	public long getSpChallengeId() {
		return _spChallengeId;
	}

	public void setSpChallengeId(long spChallengeId) {
		_spChallengeId = spChallengeId;
	}

	public String getQ1() {
		return _q1;
	}

	public void setQ1(String q1) {
		_q1 = q1;
	}

	public String getQ2() {
		return _q2;
	}

	public void setQ2(String q2) {
		_q2 = q2;
	}

	public String getQ3() {
		return _q3;
	}

	public void setQ3(String q3) {
		_q3 = q3;
	}

	public String getQ4() {
		return _q4;
	}

	public void setQ4(String q4) {
		_q4 = q4;
	}

	public String getQ5() {
		return _q5;
	}

	public void setQ5(String q5) {
		_q5 = q5;
	}

	public String getQ6() {
		return _q6;
	}

	public void setQ6(String q6) {
		_q6 = q6;
	}

	public String getQ7() {
		return _q7;
	}

	public void setQ7(String q7) {
		_q7 = q7;
	}

	public String getQ8() {
		return _q8;
	}

	public void setQ8(String q8) {
		_q8 = q8;
	}

	public String getQ9() {
		return _q9;
	}

	public void setQ9(String q9) {
		_q9 = q9;
	}

	public String getQ10() {
		return _q10;
	}

	public void setQ10(String q10) {
		_q10 = q10;
	}

	public String getQ11() {
		return _q11;
	}

	public void setQ11(String q11) {
		_q11 = q11;
	}

	public String getQ12() {
		return _q12;
	}

	public void setQ12(String q12) {
		_q12 = q12;
	}

	public String getQ13() {
		return _q13;
	}

	public void setQ13(String q13) {
		_q13 = q13;
	}

	public String getQ14() {
		return _q14;
	}

	public void setQ14(String q14) {
		_q14 = q14;
	}

	public String getQ15() {
		return _q15;
	}

	public void setQ15(String q15) {
		_q15 = q15;
	}

	public String getQ16() {
		return _q16;
	}

	public void setQ16(String q16) {
		_q16 = q16;
	}

	public String getQ17() {
		return _q17;
	}

	public void setQ17(String q17) {
		_q17 = q17;
	}

	public String getQ18() {
		return _q18;
	}

	public void setQ18(String q18) {
		_q18 = q18;
	}

	public String getQ19() {
		return _q19;
	}

	public void setQ19(String q19) {
		_q19 = q19;
	}

	public String getQ20() {
		return _q20;
	}

	public void setQ20(String q20) {
		_q20 = q20;
	}

	public boolean getCustomStatus1() {
		return _customStatus1;
	}

	public boolean isCustomStatus1() {
		return _customStatus1;
	}

	public void setCustomStatus1(boolean customStatus1) {
		_customStatus1 = customStatus1;
	}

	public boolean getCustomStatus2() {
		return _customStatus2;
	}

	public boolean isCustomStatus2() {
		return _customStatus2;
	}

	public void setCustomStatus2(boolean customStatus2) {
		_customStatus2 = customStatus2;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public int getApplicationStatus() {
		return _applicationStatus;
	}

	public void setApplicationStatus(int applicationStatus) {
		_applicationStatus = applicationStatus;
	}

	public int getNotificationStatus() {
		return _notificationStatus;
	}

	public void setNotificationStatus(int notificationStatus) {
		_notificationStatus = notificationStatus;
	}

	private String _uuid;
	private long _spChallengeApplicantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _applicantRefId;
	private String _applicantType;
	private long _spChallengeId;
	private String _q1;
	private String _q2;
	private String _q3;
	private String _q4;
	private String _q5;
	private String _q6;
	private String _q7;
	private String _q8;
	private String _q9;
	private String _q10;
	private String _q11;
	private String _q12;
	private String _q13;
	private String _q14;
	private String _q15;
	private String _q16;
	private String _q17;
	private String _q18;
	private String _q19;
	private String _q20;
	private boolean _customStatus1;
	private boolean _customStatus2;
	private boolean _active;
	private int _applicationStatus;
	private int _notificationStatus;
}