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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.startupprofile.model.Questionnaire;
import com.sambaash.platform.srv.startupprofile.model.QuestionnaireModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Questionnaire service. Represents a row in the &quot;SPQuestionnaire&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.startupprofile.model.QuestionnaireModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuestionnaireImpl}.
 * </p>
 *
 * @author pradeep
 * @see QuestionnaireImpl
 * @see com.sambaash.platform.srv.startupprofile.model.Questionnaire
 * @see com.sambaash.platform.srv.startupprofile.model.QuestionnaireModel
 * @generated
 */
public class QuestionnaireModelImpl extends BaseModelImpl<Questionnaire>
	implements QuestionnaireModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a questionnaire model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.Questionnaire} interface instead.
	 */
	public static final String TABLE_NAME = "SPQuestionnaire";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spQuestionnaireId", Types.BIGINT },
			{ "entryClassPK", Types.BIGINT },
			{ "entryClassName", Types.VARCHAR },
			{ "answer1", Types.VARCHAR },
			{ "answer2", Types.VARCHAR },
			{ "answer3", Types.VARCHAR },
			{ "answer4", Types.VARCHAR },
			{ "answer5", Types.VARCHAR },
			{ "answer6", Types.VARCHAR },
			{ "answer7", Types.VARCHAR },
			{ "answer8", Types.VARCHAR },
			{ "answer9", Types.VARCHAR },
			{ "answer10", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SPQuestionnaire (spQuestionnaireId BIGINT(20) not null primary key,entryClassPK BIGINT(20),entryClassName VARCHAR(75) null,answer1 LONGTEXT null,answer2 LONGTEXT null,answer3 LONGTEXT null,answer4 LONGTEXT null,answer5 LONGTEXT null,answer6 LONGTEXT null,answer7 LONGTEXT null,answer8 LONGTEXT null,answer9 LONGTEXT null,answer10 LONGTEXT null,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null)";
	public static final String TABLE_SQL_DROP = "drop table SPQuestionnaire";
	public static final String ORDER_BY_JPQL = " ORDER BY questionnaire.questionnaireId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPQuestionnaire.spQuestionnaireId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.startupprofile.model.Questionnaire"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.startupprofile.model.Questionnaire"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.startupprofile.model.Questionnaire"),
			true);
	public static long ENTRYCLASSNAME_COLUMN_BITMASK = 1L;
	public static long ENTRYCLASSPK_COLUMN_BITMASK = 2L;
	public static long QUESTIONNAIREID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.startupprofile.model.Questionnaire"));

	public QuestionnaireModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _questionnaireId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQuestionnaireId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionnaireId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Questionnaire.class;
	}

	@Override
	public String getModelClassName() {
		return Questionnaire.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionnaireId", getQuestionnaireId());
		attributes.put("entryClassPK", getEntryClassPK());
		attributes.put("entryClassName", getEntryClassName());
		attributes.put("answer1", getAnswer1());
		attributes.put("answer2", getAnswer2());
		attributes.put("answer3", getAnswer3());
		attributes.put("answer4", getAnswer4());
		attributes.put("answer5", getAnswer5());
		attributes.put("answer6", getAnswer6());
		attributes.put("answer7", getAnswer7());
		attributes.put("answer8", getAnswer8());
		attributes.put("answer9", getAnswer9());
		attributes.put("answer10", getAnswer10());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionnaireId = (Long)attributes.get("questionnaireId");

		if (questionnaireId != null) {
			setQuestionnaireId(questionnaireId);
		}

		Long entryClassPK = (Long)attributes.get("entryClassPK");

		if (entryClassPK != null) {
			setEntryClassPK(entryClassPK);
		}

		String entryClassName = (String)attributes.get("entryClassName");

		if (entryClassName != null) {
			setEntryClassName(entryClassName);
		}

		String answer1 = (String)attributes.get("answer1");

		if (answer1 != null) {
			setAnswer1(answer1);
		}

		String answer2 = (String)attributes.get("answer2");

		if (answer2 != null) {
			setAnswer2(answer2);
		}

		String answer3 = (String)attributes.get("answer3");

		if (answer3 != null) {
			setAnswer3(answer3);
		}

		String answer4 = (String)attributes.get("answer4");

		if (answer4 != null) {
			setAnswer4(answer4);
		}

		String answer5 = (String)attributes.get("answer5");

		if (answer5 != null) {
			setAnswer5(answer5);
		}

		String answer6 = (String)attributes.get("answer6");

		if (answer6 != null) {
			setAnswer6(answer6);
		}

		String answer7 = (String)attributes.get("answer7");

		if (answer7 != null) {
			setAnswer7(answer7);
		}

		String answer8 = (String)attributes.get("answer8");

		if (answer8 != null) {
			setAnswer8(answer8);
		}

		String answer9 = (String)attributes.get("answer9");

		if (answer9 != null) {
			setAnswer9(answer9);
		}

		String answer10 = (String)attributes.get("answer10");

		if (answer10 != null) {
			setAnswer10(answer10);
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
	}

	@Override
	public long getQuestionnaireId() {
		return _questionnaireId;
	}

	@Override
	public void setQuestionnaireId(long questionnaireId) {
		_questionnaireId = questionnaireId;
	}

	@Override
	public long getEntryClassPK() {
		return _entryClassPK;
	}

	@Override
	public void setEntryClassPK(long entryClassPK) {
		_columnBitmask |= ENTRYCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalEntryClassPK) {
			_setOriginalEntryClassPK = true;

			_originalEntryClassPK = _entryClassPK;
		}

		_entryClassPK = entryClassPK;
	}

	public long getOriginalEntryClassPK() {
		return _originalEntryClassPK;
	}

	@Override
	public String getEntryClassName() {
		if (_entryClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _entryClassName;
		}
	}

	@Override
	public void setEntryClassName(String entryClassName) {
		_columnBitmask |= ENTRYCLASSNAME_COLUMN_BITMASK;

		if (_originalEntryClassName == null) {
			_originalEntryClassName = _entryClassName;
		}

		_entryClassName = entryClassName;
	}

	public String getOriginalEntryClassName() {
		return GetterUtil.getString(_originalEntryClassName);
	}

	@Override
	public String getAnswer1() {
		if (_answer1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer1;
		}
	}

	@Override
	public void setAnswer1(String answer1) {
		_answer1 = answer1;
	}

	@Override
	public String getAnswer2() {
		if (_answer2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer2;
		}
	}

	@Override
	public void setAnswer2(String answer2) {
		_answer2 = answer2;
	}

	@Override
	public String getAnswer3() {
		if (_answer3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer3;
		}
	}

	@Override
	public void setAnswer3(String answer3) {
		_answer3 = answer3;
	}

	@Override
	public String getAnswer4() {
		if (_answer4 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer4;
		}
	}

	@Override
	public void setAnswer4(String answer4) {
		_answer4 = answer4;
	}

	@Override
	public String getAnswer5() {
		if (_answer5 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer5;
		}
	}

	@Override
	public void setAnswer5(String answer5) {
		_answer5 = answer5;
	}

	@Override
	public String getAnswer6() {
		if (_answer6 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer6;
		}
	}

	@Override
	public void setAnswer6(String answer6) {
		_answer6 = answer6;
	}

	@Override
	public String getAnswer7() {
		if (_answer7 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer7;
		}
	}

	@Override
	public void setAnswer7(String answer7) {
		_answer7 = answer7;
	}

	@Override
	public String getAnswer8() {
		if (_answer8 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer8;
		}
	}

	@Override
	public void setAnswer8(String answer8) {
		_answer8 = answer8;
	}

	@Override
	public String getAnswer9() {
		if (_answer9 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer9;
		}
	}

	@Override
	public void setAnswer9(String answer9) {
		_answer9 = answer9;
	}

	@Override
	public String getAnswer10() {
		if (_answer10 == null) {
			return StringPool.BLANK;
		}
		else {
			return _answer10;
		}
	}

	@Override
	public void setAnswer10(String answer10) {
		_answer10 = answer10;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Questionnaire.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Questionnaire toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Questionnaire)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		QuestionnaireImpl questionnaireImpl = new QuestionnaireImpl();

		questionnaireImpl.setQuestionnaireId(getQuestionnaireId());
		questionnaireImpl.setEntryClassPK(getEntryClassPK());
		questionnaireImpl.setEntryClassName(getEntryClassName());
		questionnaireImpl.setAnswer1(getAnswer1());
		questionnaireImpl.setAnswer2(getAnswer2());
		questionnaireImpl.setAnswer3(getAnswer3());
		questionnaireImpl.setAnswer4(getAnswer4());
		questionnaireImpl.setAnswer5(getAnswer5());
		questionnaireImpl.setAnswer6(getAnswer6());
		questionnaireImpl.setAnswer7(getAnswer7());
		questionnaireImpl.setAnswer8(getAnswer8());
		questionnaireImpl.setAnswer9(getAnswer9());
		questionnaireImpl.setAnswer10(getAnswer10());
		questionnaireImpl.setGroupId(getGroupId());
		questionnaireImpl.setCompanyId(getCompanyId());
		questionnaireImpl.setUserId(getUserId());
		questionnaireImpl.setUserName(getUserName());
		questionnaireImpl.setCreateDate(getCreateDate());
		questionnaireImpl.setModifiedDate(getModifiedDate());

		questionnaireImpl.resetOriginalValues();

		return questionnaireImpl;
	}

	@Override
	public int compareTo(Questionnaire questionnaire) {
		long primaryKey = questionnaire.getPrimaryKey();

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

		if (!(obj instanceof Questionnaire)) {
			return false;
		}

		Questionnaire questionnaire = (Questionnaire)obj;

		long primaryKey = questionnaire.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		QuestionnaireModelImpl questionnaireModelImpl = this;

		questionnaireModelImpl._originalEntryClassPK = questionnaireModelImpl._entryClassPK;

		questionnaireModelImpl._setOriginalEntryClassPK = false;

		questionnaireModelImpl._originalEntryClassName = questionnaireModelImpl._entryClassName;

		questionnaireModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Questionnaire> toCacheModel() {
		QuestionnaireCacheModel questionnaireCacheModel = new QuestionnaireCacheModel();

		questionnaireCacheModel.questionnaireId = getQuestionnaireId();

		questionnaireCacheModel.entryClassPK = getEntryClassPK();

		questionnaireCacheModel.entryClassName = getEntryClassName();

		String entryClassName = questionnaireCacheModel.entryClassName;

		if ((entryClassName != null) && (entryClassName.length() == 0)) {
			questionnaireCacheModel.entryClassName = null;
		}

		questionnaireCacheModel.answer1 = getAnswer1();

		String answer1 = questionnaireCacheModel.answer1;

		if ((answer1 != null) && (answer1.length() == 0)) {
			questionnaireCacheModel.answer1 = null;
		}

		questionnaireCacheModel.answer2 = getAnswer2();

		String answer2 = questionnaireCacheModel.answer2;

		if ((answer2 != null) && (answer2.length() == 0)) {
			questionnaireCacheModel.answer2 = null;
		}

		questionnaireCacheModel.answer3 = getAnswer3();

		String answer3 = questionnaireCacheModel.answer3;

		if ((answer3 != null) && (answer3.length() == 0)) {
			questionnaireCacheModel.answer3 = null;
		}

		questionnaireCacheModel.answer4 = getAnswer4();

		String answer4 = questionnaireCacheModel.answer4;

		if ((answer4 != null) && (answer4.length() == 0)) {
			questionnaireCacheModel.answer4 = null;
		}

		questionnaireCacheModel.answer5 = getAnswer5();

		String answer5 = questionnaireCacheModel.answer5;

		if ((answer5 != null) && (answer5.length() == 0)) {
			questionnaireCacheModel.answer5 = null;
		}

		questionnaireCacheModel.answer6 = getAnswer6();

		String answer6 = questionnaireCacheModel.answer6;

		if ((answer6 != null) && (answer6.length() == 0)) {
			questionnaireCacheModel.answer6 = null;
		}

		questionnaireCacheModel.answer7 = getAnswer7();

		String answer7 = questionnaireCacheModel.answer7;

		if ((answer7 != null) && (answer7.length() == 0)) {
			questionnaireCacheModel.answer7 = null;
		}

		questionnaireCacheModel.answer8 = getAnswer8();

		String answer8 = questionnaireCacheModel.answer8;

		if ((answer8 != null) && (answer8.length() == 0)) {
			questionnaireCacheModel.answer8 = null;
		}

		questionnaireCacheModel.answer9 = getAnswer9();

		String answer9 = questionnaireCacheModel.answer9;

		if ((answer9 != null) && (answer9.length() == 0)) {
			questionnaireCacheModel.answer9 = null;
		}

		questionnaireCacheModel.answer10 = getAnswer10();

		String answer10 = questionnaireCacheModel.answer10;

		if ((answer10 != null) && (answer10.length() == 0)) {
			questionnaireCacheModel.answer10 = null;
		}

		questionnaireCacheModel.groupId = getGroupId();

		questionnaireCacheModel.companyId = getCompanyId();

		questionnaireCacheModel.userId = getUserId();

		questionnaireCacheModel.userName = getUserName();

		String userName = questionnaireCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			questionnaireCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			questionnaireCacheModel.createDate = createDate.getTime();
		}
		else {
			questionnaireCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			questionnaireCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			questionnaireCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return questionnaireCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{questionnaireId=");
		sb.append(getQuestionnaireId());
		sb.append(", entryClassPK=");
		sb.append(getEntryClassPK());
		sb.append(", entryClassName=");
		sb.append(getEntryClassName());
		sb.append(", answer1=");
		sb.append(getAnswer1());
		sb.append(", answer2=");
		sb.append(getAnswer2());
		sb.append(", answer3=");
		sb.append(getAnswer3());
		sb.append(", answer4=");
		sb.append(getAnswer4());
		sb.append(", answer5=");
		sb.append(getAnswer5());
		sb.append(", answer6=");
		sb.append(getAnswer6());
		sb.append(", answer7=");
		sb.append(getAnswer7());
		sb.append(", answer8=");
		sb.append(getAnswer8());
		sb.append(", answer9=");
		sb.append(getAnswer9());
		sb.append(", answer10=");
		sb.append(getAnswer10());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.Questionnaire");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionnaireId</column-name><column-value><![CDATA[");
		sb.append(getQuestionnaireId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryClassPK</column-name><column-value><![CDATA[");
		sb.append(getEntryClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryClassName</column-name><column-value><![CDATA[");
		sb.append(getEntryClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer1</column-name><column-value><![CDATA[");
		sb.append(getAnswer1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer2</column-name><column-value><![CDATA[");
		sb.append(getAnswer2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer3</column-name><column-value><![CDATA[");
		sb.append(getAnswer3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer4</column-name><column-value><![CDATA[");
		sb.append(getAnswer4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer5</column-name><column-value><![CDATA[");
		sb.append(getAnswer5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer6</column-name><column-value><![CDATA[");
		sb.append(getAnswer6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer7</column-name><column-value><![CDATA[");
		sb.append(getAnswer7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer8</column-name><column-value><![CDATA[");
		sb.append(getAnswer8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer9</column-name><column-value><![CDATA[");
		sb.append(getAnswer9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer10</column-name><column-value><![CDATA[");
		sb.append(getAnswer10());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Questionnaire.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Questionnaire.class
		};
	private long _questionnaireId;
	private long _entryClassPK;
	private long _originalEntryClassPK;
	private boolean _setOriginalEntryClassPK;
	private String _entryClassName;
	private String _originalEntryClassName;
	private String _answer1;
	private String _answer2;
	private String _answer3;
	private String _answer4;
	private String _answer5;
	private String _answer6;
	private String _answer7;
	private String _answer8;
	private String _answer9;
	private String _answer10;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private Questionnaire _escapedModel;
}