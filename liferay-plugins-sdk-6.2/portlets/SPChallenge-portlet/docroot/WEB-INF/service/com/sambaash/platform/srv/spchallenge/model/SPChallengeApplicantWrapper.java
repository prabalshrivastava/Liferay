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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPChallengeApplicant}.
 * </p>
 *
 * @author pradeep
 * @see SPChallengeApplicant
 * @generated
 */
public class SPChallengeApplicantWrapper implements SPChallengeApplicant,
	ModelWrapper<SPChallengeApplicant> {
	public SPChallengeApplicantWrapper(
		SPChallengeApplicant spChallengeApplicant) {
		_spChallengeApplicant = spChallengeApplicant;
	}

	@Override
	public Class<?> getModelClass() {
		return SPChallengeApplicant.class;
	}

	@Override
	public String getModelClassName() {
		return SPChallengeApplicant.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spChallengeApplicantId", getSpChallengeApplicantId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicantRefId", getApplicantRefId());
		attributes.put("applicantType", getApplicantType());
		attributes.put("spChallengeId", getSpChallengeId());
		attributes.put("q1", getQ1());
		attributes.put("q2", getQ2());
		attributes.put("q3", getQ3());
		attributes.put("q4", getQ4());
		attributes.put("q5", getQ5());
		attributes.put("q6", getQ6());
		attributes.put("q7", getQ7());
		attributes.put("q8", getQ8());
		attributes.put("q9", getQ9());
		attributes.put("q10", getQ10());
		attributes.put("q11", getQ11());
		attributes.put("q12", getQ12());
		attributes.put("q13", getQ13());
		attributes.put("q14", getQ14());
		attributes.put("q15", getQ15());
		attributes.put("q16", getQ16());
		attributes.put("q17", getQ17());
		attributes.put("q18", getQ18());
		attributes.put("q19", getQ19());
		attributes.put("q20", getQ20());
		attributes.put("customStatus1", getCustomStatus1());
		attributes.put("customStatus2", getCustomStatus2());
		attributes.put("active", getActive());
		attributes.put("applicationStatus", getApplicationStatus());
		attributes.put("notificationStatus", getNotificationStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spChallengeApplicantId = (Long)attributes.get(
				"spChallengeApplicantId");

		if (spChallengeApplicantId != null) {
			setSpChallengeApplicantId(spChallengeApplicantId);
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

		Long applicantRefId = (Long)attributes.get("applicantRefId");

		if (applicantRefId != null) {
			setApplicantRefId(applicantRefId);
		}

		String applicantType = (String)attributes.get("applicantType");

		if (applicantType != null) {
			setApplicantType(applicantType);
		}

		Long spChallengeId = (Long)attributes.get("spChallengeId");

		if (spChallengeId != null) {
			setSpChallengeId(spChallengeId);
		}

		String q1 = (String)attributes.get("q1");

		if (q1 != null) {
			setQ1(q1);
		}

		String q2 = (String)attributes.get("q2");

		if (q2 != null) {
			setQ2(q2);
		}

		String q3 = (String)attributes.get("q3");

		if (q3 != null) {
			setQ3(q3);
		}

		String q4 = (String)attributes.get("q4");

		if (q4 != null) {
			setQ4(q4);
		}

		String q5 = (String)attributes.get("q5");

		if (q5 != null) {
			setQ5(q5);
		}

		String q6 = (String)attributes.get("q6");

		if (q6 != null) {
			setQ6(q6);
		}

		String q7 = (String)attributes.get("q7");

		if (q7 != null) {
			setQ7(q7);
		}

		String q8 = (String)attributes.get("q8");

		if (q8 != null) {
			setQ8(q8);
		}

		String q9 = (String)attributes.get("q9");

		if (q9 != null) {
			setQ9(q9);
		}

		String q10 = (String)attributes.get("q10");

		if (q10 != null) {
			setQ10(q10);
		}

		String q11 = (String)attributes.get("q11");

		if (q11 != null) {
			setQ11(q11);
		}

		String q12 = (String)attributes.get("q12");

		if (q12 != null) {
			setQ12(q12);
		}

		String q13 = (String)attributes.get("q13");

		if (q13 != null) {
			setQ13(q13);
		}

		String q14 = (String)attributes.get("q14");

		if (q14 != null) {
			setQ14(q14);
		}

		String q15 = (String)attributes.get("q15");

		if (q15 != null) {
			setQ15(q15);
		}

		String q16 = (String)attributes.get("q16");

		if (q16 != null) {
			setQ16(q16);
		}

		String q17 = (String)attributes.get("q17");

		if (q17 != null) {
			setQ17(q17);
		}

		String q18 = (String)attributes.get("q18");

		if (q18 != null) {
			setQ18(q18);
		}

		String q19 = (String)attributes.get("q19");

		if (q19 != null) {
			setQ19(q19);
		}

		String q20 = (String)attributes.get("q20");

		if (q20 != null) {
			setQ20(q20);
		}

		Boolean customStatus1 = (Boolean)attributes.get("customStatus1");

		if (customStatus1 != null) {
			setCustomStatus1(customStatus1);
		}

		Boolean customStatus2 = (Boolean)attributes.get("customStatus2");

		if (customStatus2 != null) {
			setCustomStatus2(customStatus2);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Integer applicationStatus = (Integer)attributes.get("applicationStatus");

		if (applicationStatus != null) {
			setApplicationStatus(applicationStatus);
		}

		Integer notificationStatus = (Integer)attributes.get(
				"notificationStatus");

		if (notificationStatus != null) {
			setNotificationStatus(notificationStatus);
		}
	}

	/**
	* Returns the primary key of this s p challenge applicant.
	*
	* @return the primary key of this s p challenge applicant
	*/
	@Override
	public long getPrimaryKey() {
		return _spChallengeApplicant.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p challenge applicant.
	*
	* @param primaryKey the primary key of this s p challenge applicant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spChallengeApplicant.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p challenge applicant.
	*
	* @return the uuid of this s p challenge applicant
	*/
	@Override
	public java.lang.String getUuid() {
		return _spChallengeApplicant.getUuid();
	}

	/**
	* Sets the uuid of this s p challenge applicant.
	*
	* @param uuid the uuid of this s p challenge applicant
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spChallengeApplicant.setUuid(uuid);
	}

	/**
	* Returns the sp challenge applicant ID of this s p challenge applicant.
	*
	* @return the sp challenge applicant ID of this s p challenge applicant
	*/
	@Override
	public long getSpChallengeApplicantId() {
		return _spChallengeApplicant.getSpChallengeApplicantId();
	}

	/**
	* Sets the sp challenge applicant ID of this s p challenge applicant.
	*
	* @param spChallengeApplicantId the sp challenge applicant ID of this s p challenge applicant
	*/
	@Override
	public void setSpChallengeApplicantId(long spChallengeApplicantId) {
		_spChallengeApplicant.setSpChallengeApplicantId(spChallengeApplicantId);
	}

	/**
	* Returns the group ID of this s p challenge applicant.
	*
	* @return the group ID of this s p challenge applicant
	*/
	@Override
	public long getGroupId() {
		return _spChallengeApplicant.getGroupId();
	}

	/**
	* Sets the group ID of this s p challenge applicant.
	*
	* @param groupId the group ID of this s p challenge applicant
	*/
	@Override
	public void setGroupId(long groupId) {
		_spChallengeApplicant.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p challenge applicant.
	*
	* @return the company ID of this s p challenge applicant
	*/
	@Override
	public long getCompanyId() {
		return _spChallengeApplicant.getCompanyId();
	}

	/**
	* Sets the company ID of this s p challenge applicant.
	*
	* @param companyId the company ID of this s p challenge applicant
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spChallengeApplicant.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p challenge applicant.
	*
	* @return the user ID of this s p challenge applicant
	*/
	@Override
	public long getUserId() {
		return _spChallengeApplicant.getUserId();
	}

	/**
	* Sets the user ID of this s p challenge applicant.
	*
	* @param userId the user ID of this s p challenge applicant
	*/
	@Override
	public void setUserId(long userId) {
		_spChallengeApplicant.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p challenge applicant.
	*
	* @return the user uuid of this s p challenge applicant
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spChallengeApplicant.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p challenge applicant.
	*
	* @param userUuid the user uuid of this s p challenge applicant
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spChallengeApplicant.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p challenge applicant.
	*
	* @return the user name of this s p challenge applicant
	*/
	@Override
	public java.lang.String getUserName() {
		return _spChallengeApplicant.getUserName();
	}

	/**
	* Sets the user name of this s p challenge applicant.
	*
	* @param userName the user name of this s p challenge applicant
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spChallengeApplicant.setUserName(userName);
	}

	/**
	* Returns the create date of this s p challenge applicant.
	*
	* @return the create date of this s p challenge applicant
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spChallengeApplicant.getCreateDate();
	}

	/**
	* Sets the create date of this s p challenge applicant.
	*
	* @param createDate the create date of this s p challenge applicant
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spChallengeApplicant.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p challenge applicant.
	*
	* @return the modified date of this s p challenge applicant
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spChallengeApplicant.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p challenge applicant.
	*
	* @param modifiedDate the modified date of this s p challenge applicant
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spChallengeApplicant.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the applicant ref ID of this s p challenge applicant.
	*
	* @return the applicant ref ID of this s p challenge applicant
	*/
	@Override
	public long getApplicantRefId() {
		return _spChallengeApplicant.getApplicantRefId();
	}

	/**
	* Sets the applicant ref ID of this s p challenge applicant.
	*
	* @param applicantRefId the applicant ref ID of this s p challenge applicant
	*/
	@Override
	public void setApplicantRefId(long applicantRefId) {
		_spChallengeApplicant.setApplicantRefId(applicantRefId);
	}

	/**
	* Returns the applicant type of this s p challenge applicant.
	*
	* @return the applicant type of this s p challenge applicant
	*/
	@Override
	public java.lang.String getApplicantType() {
		return _spChallengeApplicant.getApplicantType();
	}

	/**
	* Sets the applicant type of this s p challenge applicant.
	*
	* @param applicantType the applicant type of this s p challenge applicant
	*/
	@Override
	public void setApplicantType(java.lang.String applicantType) {
		_spChallengeApplicant.setApplicantType(applicantType);
	}

	/**
	* Returns the sp challenge ID of this s p challenge applicant.
	*
	* @return the sp challenge ID of this s p challenge applicant
	*/
	@Override
	public long getSpChallengeId() {
		return _spChallengeApplicant.getSpChallengeId();
	}

	/**
	* Sets the sp challenge ID of this s p challenge applicant.
	*
	* @param spChallengeId the sp challenge ID of this s p challenge applicant
	*/
	@Override
	public void setSpChallengeId(long spChallengeId) {
		_spChallengeApplicant.setSpChallengeId(spChallengeId);
	}

	/**
	* Returns the q1 of this s p challenge applicant.
	*
	* @return the q1 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ1() {
		return _spChallengeApplicant.getQ1();
	}

	/**
	* Sets the q1 of this s p challenge applicant.
	*
	* @param q1 the q1 of this s p challenge applicant
	*/
	@Override
	public void setQ1(java.lang.String q1) {
		_spChallengeApplicant.setQ1(q1);
	}

	/**
	* Returns the q2 of this s p challenge applicant.
	*
	* @return the q2 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ2() {
		return _spChallengeApplicant.getQ2();
	}

	/**
	* Sets the q2 of this s p challenge applicant.
	*
	* @param q2 the q2 of this s p challenge applicant
	*/
	@Override
	public void setQ2(java.lang.String q2) {
		_spChallengeApplicant.setQ2(q2);
	}

	/**
	* Returns the q3 of this s p challenge applicant.
	*
	* @return the q3 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ3() {
		return _spChallengeApplicant.getQ3();
	}

	/**
	* Sets the q3 of this s p challenge applicant.
	*
	* @param q3 the q3 of this s p challenge applicant
	*/
	@Override
	public void setQ3(java.lang.String q3) {
		_spChallengeApplicant.setQ3(q3);
	}

	/**
	* Returns the q4 of this s p challenge applicant.
	*
	* @return the q4 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ4() {
		return _spChallengeApplicant.getQ4();
	}

	/**
	* Sets the q4 of this s p challenge applicant.
	*
	* @param q4 the q4 of this s p challenge applicant
	*/
	@Override
	public void setQ4(java.lang.String q4) {
		_spChallengeApplicant.setQ4(q4);
	}

	/**
	* Returns the q5 of this s p challenge applicant.
	*
	* @return the q5 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ5() {
		return _spChallengeApplicant.getQ5();
	}

	/**
	* Sets the q5 of this s p challenge applicant.
	*
	* @param q5 the q5 of this s p challenge applicant
	*/
	@Override
	public void setQ5(java.lang.String q5) {
		_spChallengeApplicant.setQ5(q5);
	}

	/**
	* Returns the q6 of this s p challenge applicant.
	*
	* @return the q6 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ6() {
		return _spChallengeApplicant.getQ6();
	}

	/**
	* Sets the q6 of this s p challenge applicant.
	*
	* @param q6 the q6 of this s p challenge applicant
	*/
	@Override
	public void setQ6(java.lang.String q6) {
		_spChallengeApplicant.setQ6(q6);
	}

	/**
	* Returns the q7 of this s p challenge applicant.
	*
	* @return the q7 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ7() {
		return _spChallengeApplicant.getQ7();
	}

	/**
	* Sets the q7 of this s p challenge applicant.
	*
	* @param q7 the q7 of this s p challenge applicant
	*/
	@Override
	public void setQ7(java.lang.String q7) {
		_spChallengeApplicant.setQ7(q7);
	}

	/**
	* Returns the q8 of this s p challenge applicant.
	*
	* @return the q8 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ8() {
		return _spChallengeApplicant.getQ8();
	}

	/**
	* Sets the q8 of this s p challenge applicant.
	*
	* @param q8 the q8 of this s p challenge applicant
	*/
	@Override
	public void setQ8(java.lang.String q8) {
		_spChallengeApplicant.setQ8(q8);
	}

	/**
	* Returns the q9 of this s p challenge applicant.
	*
	* @return the q9 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ9() {
		return _spChallengeApplicant.getQ9();
	}

	/**
	* Sets the q9 of this s p challenge applicant.
	*
	* @param q9 the q9 of this s p challenge applicant
	*/
	@Override
	public void setQ9(java.lang.String q9) {
		_spChallengeApplicant.setQ9(q9);
	}

	/**
	* Returns the q10 of this s p challenge applicant.
	*
	* @return the q10 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ10() {
		return _spChallengeApplicant.getQ10();
	}

	/**
	* Sets the q10 of this s p challenge applicant.
	*
	* @param q10 the q10 of this s p challenge applicant
	*/
	@Override
	public void setQ10(java.lang.String q10) {
		_spChallengeApplicant.setQ10(q10);
	}

	/**
	* Returns the q11 of this s p challenge applicant.
	*
	* @return the q11 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ11() {
		return _spChallengeApplicant.getQ11();
	}

	/**
	* Sets the q11 of this s p challenge applicant.
	*
	* @param q11 the q11 of this s p challenge applicant
	*/
	@Override
	public void setQ11(java.lang.String q11) {
		_spChallengeApplicant.setQ11(q11);
	}

	/**
	* Returns the q12 of this s p challenge applicant.
	*
	* @return the q12 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ12() {
		return _spChallengeApplicant.getQ12();
	}

	/**
	* Sets the q12 of this s p challenge applicant.
	*
	* @param q12 the q12 of this s p challenge applicant
	*/
	@Override
	public void setQ12(java.lang.String q12) {
		_spChallengeApplicant.setQ12(q12);
	}

	/**
	* Returns the q13 of this s p challenge applicant.
	*
	* @return the q13 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ13() {
		return _spChallengeApplicant.getQ13();
	}

	/**
	* Sets the q13 of this s p challenge applicant.
	*
	* @param q13 the q13 of this s p challenge applicant
	*/
	@Override
	public void setQ13(java.lang.String q13) {
		_spChallengeApplicant.setQ13(q13);
	}

	/**
	* Returns the q14 of this s p challenge applicant.
	*
	* @return the q14 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ14() {
		return _spChallengeApplicant.getQ14();
	}

	/**
	* Sets the q14 of this s p challenge applicant.
	*
	* @param q14 the q14 of this s p challenge applicant
	*/
	@Override
	public void setQ14(java.lang.String q14) {
		_spChallengeApplicant.setQ14(q14);
	}

	/**
	* Returns the q15 of this s p challenge applicant.
	*
	* @return the q15 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ15() {
		return _spChallengeApplicant.getQ15();
	}

	/**
	* Sets the q15 of this s p challenge applicant.
	*
	* @param q15 the q15 of this s p challenge applicant
	*/
	@Override
	public void setQ15(java.lang.String q15) {
		_spChallengeApplicant.setQ15(q15);
	}

	/**
	* Returns the q16 of this s p challenge applicant.
	*
	* @return the q16 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ16() {
		return _spChallengeApplicant.getQ16();
	}

	/**
	* Sets the q16 of this s p challenge applicant.
	*
	* @param q16 the q16 of this s p challenge applicant
	*/
	@Override
	public void setQ16(java.lang.String q16) {
		_spChallengeApplicant.setQ16(q16);
	}

	/**
	* Returns the q17 of this s p challenge applicant.
	*
	* @return the q17 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ17() {
		return _spChallengeApplicant.getQ17();
	}

	/**
	* Sets the q17 of this s p challenge applicant.
	*
	* @param q17 the q17 of this s p challenge applicant
	*/
	@Override
	public void setQ17(java.lang.String q17) {
		_spChallengeApplicant.setQ17(q17);
	}

	/**
	* Returns the q18 of this s p challenge applicant.
	*
	* @return the q18 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ18() {
		return _spChallengeApplicant.getQ18();
	}

	/**
	* Sets the q18 of this s p challenge applicant.
	*
	* @param q18 the q18 of this s p challenge applicant
	*/
	@Override
	public void setQ18(java.lang.String q18) {
		_spChallengeApplicant.setQ18(q18);
	}

	/**
	* Returns the q19 of this s p challenge applicant.
	*
	* @return the q19 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ19() {
		return _spChallengeApplicant.getQ19();
	}

	/**
	* Sets the q19 of this s p challenge applicant.
	*
	* @param q19 the q19 of this s p challenge applicant
	*/
	@Override
	public void setQ19(java.lang.String q19) {
		_spChallengeApplicant.setQ19(q19);
	}

	/**
	* Returns the q20 of this s p challenge applicant.
	*
	* @return the q20 of this s p challenge applicant
	*/
	@Override
	public java.lang.String getQ20() {
		return _spChallengeApplicant.getQ20();
	}

	/**
	* Sets the q20 of this s p challenge applicant.
	*
	* @param q20 the q20 of this s p challenge applicant
	*/
	@Override
	public void setQ20(java.lang.String q20) {
		_spChallengeApplicant.setQ20(q20);
	}

	/**
	* Returns the custom status1 of this s p challenge applicant.
	*
	* @return the custom status1 of this s p challenge applicant
	*/
	@Override
	public boolean getCustomStatus1() {
		return _spChallengeApplicant.getCustomStatus1();
	}

	/**
	* Returns <code>true</code> if this s p challenge applicant is custom status1.
	*
	* @return <code>true</code> if this s p challenge applicant is custom status1; <code>false</code> otherwise
	*/
	@Override
	public boolean isCustomStatus1() {
		return _spChallengeApplicant.isCustomStatus1();
	}

	/**
	* Sets whether this s p challenge applicant is custom status1.
	*
	* @param customStatus1 the custom status1 of this s p challenge applicant
	*/
	@Override
	public void setCustomStatus1(boolean customStatus1) {
		_spChallengeApplicant.setCustomStatus1(customStatus1);
	}

	/**
	* Returns the custom status2 of this s p challenge applicant.
	*
	* @return the custom status2 of this s p challenge applicant
	*/
	@Override
	public boolean getCustomStatus2() {
		return _spChallengeApplicant.getCustomStatus2();
	}

	/**
	* Returns <code>true</code> if this s p challenge applicant is custom status2.
	*
	* @return <code>true</code> if this s p challenge applicant is custom status2; <code>false</code> otherwise
	*/
	@Override
	public boolean isCustomStatus2() {
		return _spChallengeApplicant.isCustomStatus2();
	}

	/**
	* Sets whether this s p challenge applicant is custom status2.
	*
	* @param customStatus2 the custom status2 of this s p challenge applicant
	*/
	@Override
	public void setCustomStatus2(boolean customStatus2) {
		_spChallengeApplicant.setCustomStatus2(customStatus2);
	}

	/**
	* Returns the active of this s p challenge applicant.
	*
	* @return the active of this s p challenge applicant
	*/
	@Override
	public boolean getActive() {
		return _spChallengeApplicant.getActive();
	}

	/**
	* Returns <code>true</code> if this s p challenge applicant is active.
	*
	* @return <code>true</code> if this s p challenge applicant is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spChallengeApplicant.isActive();
	}

	/**
	* Sets whether this s p challenge applicant is active.
	*
	* @param active the active of this s p challenge applicant
	*/
	@Override
	public void setActive(boolean active) {
		_spChallengeApplicant.setActive(active);
	}

	/**
	* Returns the application status of this s p challenge applicant.
	*
	* @return the application status of this s p challenge applicant
	*/
	@Override
	public int getApplicationStatus() {
		return _spChallengeApplicant.getApplicationStatus();
	}

	/**
	* Sets the application status of this s p challenge applicant.
	*
	* @param applicationStatus the application status of this s p challenge applicant
	*/
	@Override
	public void setApplicationStatus(int applicationStatus) {
		_spChallengeApplicant.setApplicationStatus(applicationStatus);
	}

	/**
	* Returns the notification status of this s p challenge applicant.
	*
	* @return the notification status of this s p challenge applicant
	*/
	@Override
	public int getNotificationStatus() {
		return _spChallengeApplicant.getNotificationStatus();
	}

	/**
	* Sets the notification status of this s p challenge applicant.
	*
	* @param notificationStatus the notification status of this s p challenge applicant
	*/
	@Override
	public void setNotificationStatus(int notificationStatus) {
		_spChallengeApplicant.setNotificationStatus(notificationStatus);
	}

	@Override
	public boolean isNew() {
		return _spChallengeApplicant.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spChallengeApplicant.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spChallengeApplicant.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spChallengeApplicant.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spChallengeApplicant.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spChallengeApplicant.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spChallengeApplicant.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spChallengeApplicant.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spChallengeApplicant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spChallengeApplicant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spChallengeApplicant.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPChallengeApplicantWrapper((SPChallengeApplicant)_spChallengeApplicant.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant) {
		return _spChallengeApplicant.compareTo(spChallengeApplicant);
	}

	@Override
	public int hashCode() {
		return _spChallengeApplicant.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> toCacheModel() {
		return _spChallengeApplicant.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant toEscapedModel() {
		return new SPChallengeApplicantWrapper(_spChallengeApplicant.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant toUnescapedModel() {
		return new SPChallengeApplicantWrapper(_spChallengeApplicant.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spChallengeApplicant.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spChallengeApplicant.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spChallengeApplicant.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPChallengeApplicantWrapper)) {
			return false;
		}

		SPChallengeApplicantWrapper spChallengeApplicantWrapper = (SPChallengeApplicantWrapper)obj;

		if (Validator.equals(_spChallengeApplicant,
					spChallengeApplicantWrapper._spChallengeApplicant)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spChallengeApplicant.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPChallengeApplicant getWrappedSPChallengeApplicant() {
		return _spChallengeApplicant;
	}

	@Override
	public SPChallengeApplicant getWrappedModel() {
		return _spChallengeApplicant;
	}

	@Override
	public void resetOriginalValues() {
		_spChallengeApplicant.resetOriginalValues();
	}

	private SPChallengeApplicant _spChallengeApplicant;
}