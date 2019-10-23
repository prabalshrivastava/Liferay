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
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class QuestionnaireClp extends BaseModelImpl<Questionnaire>
	implements Questionnaire {
	public QuestionnaireClp() {
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionnaireId", long.class);

				method.invoke(_questionnaireRemoteModel, questionnaireId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntryClassPK() {
		return _entryClassPK;
	}

	@Override
	public void setEntryClassPK(long entryClassPK) {
		_entryClassPK = entryClassPK;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryClassPK", long.class);

				method.invoke(_questionnaireRemoteModel, entryClassPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntryClassName() {
		return _entryClassName;
	}

	@Override
	public void setEntryClassName(String entryClassName) {
		_entryClassName = entryClassName;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryClassName",
						String.class);

				method.invoke(_questionnaireRemoteModel, entryClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer1() {
		return _answer1;
	}

	@Override
	public void setAnswer1(String answer1) {
		_answer1 = answer1;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer1", String.class);

				method.invoke(_questionnaireRemoteModel, answer1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer2() {
		return _answer2;
	}

	@Override
	public void setAnswer2(String answer2) {
		_answer2 = answer2;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer2", String.class);

				method.invoke(_questionnaireRemoteModel, answer2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer3() {
		return _answer3;
	}

	@Override
	public void setAnswer3(String answer3) {
		_answer3 = answer3;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer3", String.class);

				method.invoke(_questionnaireRemoteModel, answer3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer4() {
		return _answer4;
	}

	@Override
	public void setAnswer4(String answer4) {
		_answer4 = answer4;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer4", String.class);

				method.invoke(_questionnaireRemoteModel, answer4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer5() {
		return _answer5;
	}

	@Override
	public void setAnswer5(String answer5) {
		_answer5 = answer5;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer5", String.class);

				method.invoke(_questionnaireRemoteModel, answer5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer6() {
		return _answer6;
	}

	@Override
	public void setAnswer6(String answer6) {
		_answer6 = answer6;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer6", String.class);

				method.invoke(_questionnaireRemoteModel, answer6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer7() {
		return _answer7;
	}

	@Override
	public void setAnswer7(String answer7) {
		_answer7 = answer7;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer7", String.class);

				method.invoke(_questionnaireRemoteModel, answer7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer8() {
		return _answer8;
	}

	@Override
	public void setAnswer8(String answer8) {
		_answer8 = answer8;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer8", String.class);

				method.invoke(_questionnaireRemoteModel, answer8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer9() {
		return _answer9;
	}

	@Override
	public void setAnswer9(String answer9) {
		_answer9 = answer9;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer9", String.class);

				method.invoke(_questionnaireRemoteModel, answer9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer10() {
		return _answer10;
	}

	@Override
	public void setAnswer10(String answer10) {
		_answer10 = answer10;

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer10", String.class);

				method.invoke(_questionnaireRemoteModel, answer10);
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_questionnaireRemoteModel, groupId);
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_questionnaireRemoteModel, companyId);
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_questionnaireRemoteModel, userId);
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_questionnaireRemoteModel, userName);
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_questionnaireRemoteModel, createDate);
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

		if (_questionnaireRemoteModel != null) {
			try {
				Class<?> clazz = _questionnaireRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_questionnaireRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getQuestionnaireRemoteModel() {
		return _questionnaireRemoteModel;
	}

	public void setQuestionnaireRemoteModel(
		BaseModel<?> questionnaireRemoteModel) {
		_questionnaireRemoteModel = questionnaireRemoteModel;
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

		Class<?> remoteModelClass = _questionnaireRemoteModel.getClass();

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

		Object returnValue = method.invoke(_questionnaireRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			QuestionnaireLocalServiceUtil.addQuestionnaire(this);
		}
		else {
			QuestionnaireLocalServiceUtil.updateQuestionnaire(this);
		}
	}

	@Override
	public Questionnaire toEscapedModel() {
		return (Questionnaire)ProxyUtil.newProxyInstance(Questionnaire.class.getClassLoader(),
			new Class[] { Questionnaire.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionnaireClp clone = new QuestionnaireClp();

		clone.setQuestionnaireId(getQuestionnaireId());
		clone.setEntryClassPK(getEntryClassPK());
		clone.setEntryClassName(getEntryClassName());
		clone.setAnswer1(getAnswer1());
		clone.setAnswer2(getAnswer2());
		clone.setAnswer3(getAnswer3());
		clone.setAnswer4(getAnswer4());
		clone.setAnswer5(getAnswer5());
		clone.setAnswer6(getAnswer6());
		clone.setAnswer7(getAnswer7());
		clone.setAnswer8(getAnswer8());
		clone.setAnswer9(getAnswer9());
		clone.setAnswer10(getAnswer10());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
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

		if (!(obj instanceof QuestionnaireClp)) {
			return false;
		}

		QuestionnaireClp questionnaire = (QuestionnaireClp)obj;

		long primaryKey = questionnaire.getPrimaryKey();

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

	private long _questionnaireId;
	private long _entryClassPK;
	private String _entryClassName;
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
	private BaseModel<?> _questionnaireRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}