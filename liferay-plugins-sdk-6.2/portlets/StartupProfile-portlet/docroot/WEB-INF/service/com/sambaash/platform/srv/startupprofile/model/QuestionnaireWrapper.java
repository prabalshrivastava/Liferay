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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Questionnaire}.
 * </p>
 *
 * @author pradeep
 * @see Questionnaire
 * @generated
 */
public class QuestionnaireWrapper implements Questionnaire,
	ModelWrapper<Questionnaire> {
	public QuestionnaireWrapper(Questionnaire questionnaire) {
		_questionnaire = questionnaire;
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

	/**
	* Returns the primary key of this questionnaire.
	*
	* @return the primary key of this questionnaire
	*/
	@Override
	public long getPrimaryKey() {
		return _questionnaire.getPrimaryKey();
	}

	/**
	* Sets the primary key of this questionnaire.
	*
	* @param primaryKey the primary key of this questionnaire
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_questionnaire.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the questionnaire ID of this questionnaire.
	*
	* @return the questionnaire ID of this questionnaire
	*/
	@Override
	public long getQuestionnaireId() {
		return _questionnaire.getQuestionnaireId();
	}

	/**
	* Sets the questionnaire ID of this questionnaire.
	*
	* @param questionnaireId the questionnaire ID of this questionnaire
	*/
	@Override
	public void setQuestionnaireId(long questionnaireId) {
		_questionnaire.setQuestionnaireId(questionnaireId);
	}

	/**
	* Returns the entry class p k of this questionnaire.
	*
	* @return the entry class p k of this questionnaire
	*/
	@Override
	public long getEntryClassPK() {
		return _questionnaire.getEntryClassPK();
	}

	/**
	* Sets the entry class p k of this questionnaire.
	*
	* @param entryClassPK the entry class p k of this questionnaire
	*/
	@Override
	public void setEntryClassPK(long entryClassPK) {
		_questionnaire.setEntryClassPK(entryClassPK);
	}

	/**
	* Returns the entry class name of this questionnaire.
	*
	* @return the entry class name of this questionnaire
	*/
	@Override
	public java.lang.String getEntryClassName() {
		return _questionnaire.getEntryClassName();
	}

	/**
	* Sets the entry class name of this questionnaire.
	*
	* @param entryClassName the entry class name of this questionnaire
	*/
	@Override
	public void setEntryClassName(java.lang.String entryClassName) {
		_questionnaire.setEntryClassName(entryClassName);
	}

	/**
	* Returns the answer1 of this questionnaire.
	*
	* @return the answer1 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer1() {
		return _questionnaire.getAnswer1();
	}

	/**
	* Sets the answer1 of this questionnaire.
	*
	* @param answer1 the answer1 of this questionnaire
	*/
	@Override
	public void setAnswer1(java.lang.String answer1) {
		_questionnaire.setAnswer1(answer1);
	}

	/**
	* Returns the answer2 of this questionnaire.
	*
	* @return the answer2 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer2() {
		return _questionnaire.getAnswer2();
	}

	/**
	* Sets the answer2 of this questionnaire.
	*
	* @param answer2 the answer2 of this questionnaire
	*/
	@Override
	public void setAnswer2(java.lang.String answer2) {
		_questionnaire.setAnswer2(answer2);
	}

	/**
	* Returns the answer3 of this questionnaire.
	*
	* @return the answer3 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer3() {
		return _questionnaire.getAnswer3();
	}

	/**
	* Sets the answer3 of this questionnaire.
	*
	* @param answer3 the answer3 of this questionnaire
	*/
	@Override
	public void setAnswer3(java.lang.String answer3) {
		_questionnaire.setAnswer3(answer3);
	}

	/**
	* Returns the answer4 of this questionnaire.
	*
	* @return the answer4 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer4() {
		return _questionnaire.getAnswer4();
	}

	/**
	* Sets the answer4 of this questionnaire.
	*
	* @param answer4 the answer4 of this questionnaire
	*/
	@Override
	public void setAnswer4(java.lang.String answer4) {
		_questionnaire.setAnswer4(answer4);
	}

	/**
	* Returns the answer5 of this questionnaire.
	*
	* @return the answer5 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer5() {
		return _questionnaire.getAnswer5();
	}

	/**
	* Sets the answer5 of this questionnaire.
	*
	* @param answer5 the answer5 of this questionnaire
	*/
	@Override
	public void setAnswer5(java.lang.String answer5) {
		_questionnaire.setAnswer5(answer5);
	}

	/**
	* Returns the answer6 of this questionnaire.
	*
	* @return the answer6 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer6() {
		return _questionnaire.getAnswer6();
	}

	/**
	* Sets the answer6 of this questionnaire.
	*
	* @param answer6 the answer6 of this questionnaire
	*/
	@Override
	public void setAnswer6(java.lang.String answer6) {
		_questionnaire.setAnswer6(answer6);
	}

	/**
	* Returns the answer7 of this questionnaire.
	*
	* @return the answer7 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer7() {
		return _questionnaire.getAnswer7();
	}

	/**
	* Sets the answer7 of this questionnaire.
	*
	* @param answer7 the answer7 of this questionnaire
	*/
	@Override
	public void setAnswer7(java.lang.String answer7) {
		_questionnaire.setAnswer7(answer7);
	}

	/**
	* Returns the answer8 of this questionnaire.
	*
	* @return the answer8 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer8() {
		return _questionnaire.getAnswer8();
	}

	/**
	* Sets the answer8 of this questionnaire.
	*
	* @param answer8 the answer8 of this questionnaire
	*/
	@Override
	public void setAnswer8(java.lang.String answer8) {
		_questionnaire.setAnswer8(answer8);
	}

	/**
	* Returns the answer9 of this questionnaire.
	*
	* @return the answer9 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer9() {
		return _questionnaire.getAnswer9();
	}

	/**
	* Sets the answer9 of this questionnaire.
	*
	* @param answer9 the answer9 of this questionnaire
	*/
	@Override
	public void setAnswer9(java.lang.String answer9) {
		_questionnaire.setAnswer9(answer9);
	}

	/**
	* Returns the answer10 of this questionnaire.
	*
	* @return the answer10 of this questionnaire
	*/
	@Override
	public java.lang.String getAnswer10() {
		return _questionnaire.getAnswer10();
	}

	/**
	* Sets the answer10 of this questionnaire.
	*
	* @param answer10 the answer10 of this questionnaire
	*/
	@Override
	public void setAnswer10(java.lang.String answer10) {
		_questionnaire.setAnswer10(answer10);
	}

	/**
	* Returns the group ID of this questionnaire.
	*
	* @return the group ID of this questionnaire
	*/
	@Override
	public long getGroupId() {
		return _questionnaire.getGroupId();
	}

	/**
	* Sets the group ID of this questionnaire.
	*
	* @param groupId the group ID of this questionnaire
	*/
	@Override
	public void setGroupId(long groupId) {
		_questionnaire.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this questionnaire.
	*
	* @return the company ID of this questionnaire
	*/
	@Override
	public long getCompanyId() {
		return _questionnaire.getCompanyId();
	}

	/**
	* Sets the company ID of this questionnaire.
	*
	* @param companyId the company ID of this questionnaire
	*/
	@Override
	public void setCompanyId(long companyId) {
		_questionnaire.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this questionnaire.
	*
	* @return the user ID of this questionnaire
	*/
	@Override
	public long getUserId() {
		return _questionnaire.getUserId();
	}

	/**
	* Sets the user ID of this questionnaire.
	*
	* @param userId the user ID of this questionnaire
	*/
	@Override
	public void setUserId(long userId) {
		_questionnaire.setUserId(userId);
	}

	/**
	* Returns the user uuid of this questionnaire.
	*
	* @return the user uuid of this questionnaire
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionnaire.getUserUuid();
	}

	/**
	* Sets the user uuid of this questionnaire.
	*
	* @param userUuid the user uuid of this questionnaire
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_questionnaire.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this questionnaire.
	*
	* @return the user name of this questionnaire
	*/
	@Override
	public java.lang.String getUserName() {
		return _questionnaire.getUserName();
	}

	/**
	* Sets the user name of this questionnaire.
	*
	* @param userName the user name of this questionnaire
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_questionnaire.setUserName(userName);
	}

	/**
	* Returns the create date of this questionnaire.
	*
	* @return the create date of this questionnaire
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _questionnaire.getCreateDate();
	}

	/**
	* Sets the create date of this questionnaire.
	*
	* @param createDate the create date of this questionnaire
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_questionnaire.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this questionnaire.
	*
	* @return the modified date of this questionnaire
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _questionnaire.getModifiedDate();
	}

	/**
	* Sets the modified date of this questionnaire.
	*
	* @param modifiedDate the modified date of this questionnaire
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_questionnaire.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _questionnaire.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_questionnaire.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _questionnaire.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_questionnaire.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _questionnaire.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _questionnaire.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_questionnaire.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _questionnaire.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_questionnaire.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_questionnaire.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_questionnaire.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionnaireWrapper((Questionnaire)_questionnaire.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire) {
		return _questionnaire.compareTo(questionnaire);
	}

	@Override
	public int hashCode() {
		return _questionnaire.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Questionnaire> toCacheModel() {
		return _questionnaire.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire toEscapedModel() {
		return new QuestionnaireWrapper(_questionnaire.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Questionnaire toUnescapedModel() {
		return new QuestionnaireWrapper(_questionnaire.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _questionnaire.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _questionnaire.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_questionnaire.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionnaireWrapper)) {
			return false;
		}

		QuestionnaireWrapper questionnaireWrapper = (QuestionnaireWrapper)obj;

		if (Validator.equals(_questionnaire, questionnaireWrapper._questionnaire)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Questionnaire getWrappedQuestionnaire() {
		return _questionnaire;
	}

	@Override
	public Questionnaire getWrappedModel() {
		return _questionnaire;
	}

	@Override
	public void resetOriginalValues() {
		_questionnaire.resetOriginalValues();
	}

	private Questionnaire _questionnaire;
}