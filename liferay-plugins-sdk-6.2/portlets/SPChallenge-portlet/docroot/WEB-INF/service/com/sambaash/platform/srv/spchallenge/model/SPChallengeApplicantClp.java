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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spchallenge.service.ClpSerializer;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPChallengeApplicantClp extends BaseModelImpl<SPChallengeApplicant>
	implements SPChallengeApplicant {
	public SPChallengeApplicantClp() {
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
	public long getPrimaryKey() {
		return _spChallengeApplicantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpChallengeApplicantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spChallengeApplicantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpChallengeApplicantId() {
		return _spChallengeApplicantId;
	}

	@Override
	public void setSpChallengeApplicantId(long spChallengeApplicantId) {
		_spChallengeApplicantId = spChallengeApplicantId;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setSpChallengeApplicantId",
						long.class);

				method.invoke(_spChallengeApplicantRemoteModel,
					spChallengeApplicantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spChallengeApplicantRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spChallengeApplicantRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spChallengeApplicantRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spChallengeApplicantRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spChallengeApplicantRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicantRefId() {
		return _applicantRefId;
	}

	@Override
	public void setApplicantRefId(long applicantRefId) {
		_applicantRefId = applicantRefId;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantRefId", long.class);

				method.invoke(_spChallengeApplicantRemoteModel, applicantRefId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicantType() {
		return _applicantType;
	}

	@Override
	public void setApplicantType(String applicantType) {
		_applicantType = applicantType;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantType", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, applicantType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpChallengeId() {
		return _spChallengeId;
	}

	@Override
	public void setSpChallengeId(long spChallengeId) {
		_spChallengeId = spChallengeId;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setSpChallengeId", long.class);

				method.invoke(_spChallengeApplicantRemoteModel, spChallengeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ1() {
		return _q1;
	}

	@Override
	public void setQ1(String q1) {
		_q1 = q1;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ1", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ2() {
		return _q2;
	}

	@Override
	public void setQ2(String q2) {
		_q2 = q2;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ2", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ3() {
		return _q3;
	}

	@Override
	public void setQ3(String q3) {
		_q3 = q3;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ3", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ4() {
		return _q4;
	}

	@Override
	public void setQ4(String q4) {
		_q4 = q4;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ4", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ5() {
		return _q5;
	}

	@Override
	public void setQ5(String q5) {
		_q5 = q5;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ5", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ6() {
		return _q6;
	}

	@Override
	public void setQ6(String q6) {
		_q6 = q6;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ6", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ7() {
		return _q7;
	}

	@Override
	public void setQ7(String q7) {
		_q7 = q7;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ7", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ8() {
		return _q8;
	}

	@Override
	public void setQ8(String q8) {
		_q8 = q8;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ8", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ9() {
		return _q9;
	}

	@Override
	public void setQ9(String q9) {
		_q9 = q9;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ9", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ10() {
		return _q10;
	}

	@Override
	public void setQ10(String q10) {
		_q10 = q10;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ10", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ11() {
		return _q11;
	}

	@Override
	public void setQ11(String q11) {
		_q11 = q11;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ11", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q11);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ12() {
		return _q12;
	}

	@Override
	public void setQ12(String q12) {
		_q12 = q12;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ12", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q12);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ13() {
		return _q13;
	}

	@Override
	public void setQ13(String q13) {
		_q13 = q13;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ13", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q13);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ14() {
		return _q14;
	}

	@Override
	public void setQ14(String q14) {
		_q14 = q14;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ14", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q14);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ15() {
		return _q15;
	}

	@Override
	public void setQ15(String q15) {
		_q15 = q15;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ15", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q15);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ16() {
		return _q16;
	}

	@Override
	public void setQ16(String q16) {
		_q16 = q16;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ16", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q16);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ17() {
		return _q17;
	}

	@Override
	public void setQ17(String q17) {
		_q17 = q17;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ17", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q17);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ18() {
		return _q18;
	}

	@Override
	public void setQ18(String q18) {
		_q18 = q18;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ18", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q18);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ19() {
		return _q19;
	}

	@Override
	public void setQ19(String q19) {
		_q19 = q19;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ19", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q19);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQ20() {
		return _q20;
	}

	@Override
	public void setQ20(String q20) {
		_q20 = q20;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setQ20", String.class);

				method.invoke(_spChallengeApplicantRemoteModel, q20);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCustomStatus1() {
		return _customStatus1;
	}

	@Override
	public boolean isCustomStatus1() {
		return _customStatus1;
	}

	@Override
	public void setCustomStatus1(boolean customStatus1) {
		_customStatus1 = customStatus1;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomStatus1",
						boolean.class);

				method.invoke(_spChallengeApplicantRemoteModel, customStatus1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCustomStatus2() {
		return _customStatus2;
	}

	@Override
	public boolean isCustomStatus2() {
		return _customStatus2;
	}

	@Override
	public void setCustomStatus2(boolean customStatus2) {
		_customStatus2 = customStatus2;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomStatus2",
						boolean.class);

				method.invoke(_spChallengeApplicantRemoteModel, customStatus2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spChallengeApplicantRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApplicationStatus() {
		return _applicationStatus;
	}

	@Override
	public void setApplicationStatus(int applicationStatus) {
		_applicationStatus = applicationStatus;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationStatus",
						int.class);

				method.invoke(_spChallengeApplicantRemoteModel,
					applicationStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNotificationStatus() {
		return _notificationStatus;
	}

	@Override
	public void setNotificationStatus(int notificationStatus) {
		_notificationStatus = notificationStatus;

		if (_spChallengeApplicantRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeApplicantRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationStatus",
						int.class);

				method.invoke(_spChallengeApplicantRemoteModel,
					notificationStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPChallengeApplicant.class.getName()));
	}

	public BaseModel<?> getSPChallengeApplicantRemoteModel() {
		return _spChallengeApplicantRemoteModel;
	}

	public void setSPChallengeApplicantRemoteModel(
		BaseModel<?> spChallengeApplicantRemoteModel) {
		_spChallengeApplicantRemoteModel = spChallengeApplicantRemoteModel;
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

		Class<?> remoteModelClass = _spChallengeApplicantRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spChallengeApplicantRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPChallengeApplicantLocalServiceUtil.addSPChallengeApplicant(this);
		}
		else {
			SPChallengeApplicantLocalServiceUtil.updateSPChallengeApplicant(this);
		}
	}

	@Override
	public SPChallengeApplicant toEscapedModel() {
		return (SPChallengeApplicant)ProxyUtil.newProxyInstance(SPChallengeApplicant.class.getClassLoader(),
			new Class[] { SPChallengeApplicant.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPChallengeApplicantClp clone = new SPChallengeApplicantClp();

		clone.setUuid(getUuid());
		clone.setSpChallengeApplicantId(getSpChallengeApplicantId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setApplicantRefId(getApplicantRefId());
		clone.setApplicantType(getApplicantType());
		clone.setSpChallengeId(getSpChallengeId());
		clone.setQ1(getQ1());
		clone.setQ2(getQ2());
		clone.setQ3(getQ3());
		clone.setQ4(getQ4());
		clone.setQ5(getQ5());
		clone.setQ6(getQ6());
		clone.setQ7(getQ7());
		clone.setQ8(getQ8());
		clone.setQ9(getQ9());
		clone.setQ10(getQ10());
		clone.setQ11(getQ11());
		clone.setQ12(getQ12());
		clone.setQ13(getQ13());
		clone.setQ14(getQ14());
		clone.setQ15(getQ15());
		clone.setQ16(getQ16());
		clone.setQ17(getQ17());
		clone.setQ18(getQ18());
		clone.setQ19(getQ19());
		clone.setQ20(getQ20());
		clone.setCustomStatus1(getCustomStatus1());
		clone.setCustomStatus2(getCustomStatus2());
		clone.setActive(getActive());
		clone.setApplicationStatus(getApplicationStatus());
		clone.setNotificationStatus(getNotificationStatus());

		return clone;
	}

	@Override
	public int compareTo(SPChallengeApplicant spChallengeApplicant) {
		long primaryKey = spChallengeApplicant.getPrimaryKey();

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

		if (!(obj instanceof SPChallengeApplicantClp)) {
			return false;
		}

		SPChallengeApplicantClp spChallengeApplicant = (SPChallengeApplicantClp)obj;

		long primaryKey = spChallengeApplicant.getPrimaryKey();

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
		StringBundler sb = new StringBundler(73);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spChallengeApplicantId=");
		sb.append(getSpChallengeApplicantId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", applicantRefId=");
		sb.append(getApplicantRefId());
		sb.append(", applicantType=");
		sb.append(getApplicantType());
		sb.append(", spChallengeId=");
		sb.append(getSpChallengeId());
		sb.append(", q1=");
		sb.append(getQ1());
		sb.append(", q2=");
		sb.append(getQ2());
		sb.append(", q3=");
		sb.append(getQ3());
		sb.append(", q4=");
		sb.append(getQ4());
		sb.append(", q5=");
		sb.append(getQ5());
		sb.append(", q6=");
		sb.append(getQ6());
		sb.append(", q7=");
		sb.append(getQ7());
		sb.append(", q8=");
		sb.append(getQ8());
		sb.append(", q9=");
		sb.append(getQ9());
		sb.append(", q10=");
		sb.append(getQ10());
		sb.append(", q11=");
		sb.append(getQ11());
		sb.append(", q12=");
		sb.append(getQ12());
		sb.append(", q13=");
		sb.append(getQ13());
		sb.append(", q14=");
		sb.append(getQ14());
		sb.append(", q15=");
		sb.append(getQ15());
		sb.append(", q16=");
		sb.append(getQ16());
		sb.append(", q17=");
		sb.append(getQ17());
		sb.append(", q18=");
		sb.append(getQ18());
		sb.append(", q19=");
		sb.append(getQ19());
		sb.append(", q20=");
		sb.append(getQ20());
		sb.append(", customStatus1=");
		sb.append(getCustomStatus1());
		sb.append(", customStatus2=");
		sb.append(getCustomStatus2());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", applicationStatus=");
		sb.append(getApplicationStatus());
		sb.append(", notificationStatus=");
		sb.append(getNotificationStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spChallengeApplicantId</column-name><column-value><![CDATA[");
		sb.append(getSpChallengeApplicantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantRefId</column-name><column-value><![CDATA[");
		sb.append(getApplicantRefId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantType</column-name><column-value><![CDATA[");
		sb.append(getApplicantType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spChallengeId</column-name><column-value><![CDATA[");
		sb.append(getSpChallengeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q1</column-name><column-value><![CDATA[");
		sb.append(getQ1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q2</column-name><column-value><![CDATA[");
		sb.append(getQ2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q3</column-name><column-value><![CDATA[");
		sb.append(getQ3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q4</column-name><column-value><![CDATA[");
		sb.append(getQ4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q5</column-name><column-value><![CDATA[");
		sb.append(getQ5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q6</column-name><column-value><![CDATA[");
		sb.append(getQ6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q7</column-name><column-value><![CDATA[");
		sb.append(getQ7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q8</column-name><column-value><![CDATA[");
		sb.append(getQ8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q9</column-name><column-value><![CDATA[");
		sb.append(getQ9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q10</column-name><column-value><![CDATA[");
		sb.append(getQ10());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q11</column-name><column-value><![CDATA[");
		sb.append(getQ11());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q12</column-name><column-value><![CDATA[");
		sb.append(getQ12());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q13</column-name><column-value><![CDATA[");
		sb.append(getQ13());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q14</column-name><column-value><![CDATA[");
		sb.append(getQ14());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q15</column-name><column-value><![CDATA[");
		sb.append(getQ15());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q16</column-name><column-value><![CDATA[");
		sb.append(getQ16());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q17</column-name><column-value><![CDATA[");
		sb.append(getQ17());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q18</column-name><column-value><![CDATA[");
		sb.append(getQ18());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q19</column-name><column-value><![CDATA[");
		sb.append(getQ19());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>q20</column-name><column-value><![CDATA[");
		sb.append(getQ20());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customStatus1</column-name><column-value><![CDATA[");
		sb.append(getCustomStatus1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customStatus2</column-name><column-value><![CDATA[");
		sb.append(getCustomStatus2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationStatus</column-name><column-value><![CDATA[");
		sb.append(getApplicationStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationStatus</column-name><column-value><![CDATA[");
		sb.append(getNotificationStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spChallengeApplicantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _spChallengeApplicantRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spchallenge.service.ClpSerializer.class;
}