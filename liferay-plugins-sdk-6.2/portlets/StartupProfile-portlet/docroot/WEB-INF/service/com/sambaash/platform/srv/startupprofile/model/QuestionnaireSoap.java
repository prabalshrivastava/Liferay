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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class QuestionnaireSoap implements Serializable {
	public static QuestionnaireSoap toSoapModel(Questionnaire model) {
		QuestionnaireSoap soapModel = new QuestionnaireSoap();

		soapModel.setQuestionnaireId(model.getQuestionnaireId());
		soapModel.setEntryClassPK(model.getEntryClassPK());
		soapModel.setEntryClassName(model.getEntryClassName());
		soapModel.setAnswer1(model.getAnswer1());
		soapModel.setAnswer2(model.getAnswer2());
		soapModel.setAnswer3(model.getAnswer3());
		soapModel.setAnswer4(model.getAnswer4());
		soapModel.setAnswer5(model.getAnswer5());
		soapModel.setAnswer6(model.getAnswer6());
		soapModel.setAnswer7(model.getAnswer7());
		soapModel.setAnswer8(model.getAnswer8());
		soapModel.setAnswer9(model.getAnswer9());
		soapModel.setAnswer10(model.getAnswer10());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static QuestionnaireSoap[] toSoapModels(Questionnaire[] models) {
		QuestionnaireSoap[] soapModels = new QuestionnaireSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionnaireSoap[][] toSoapModels(Questionnaire[][] models) {
		QuestionnaireSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionnaireSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionnaireSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionnaireSoap[] toSoapModels(List<Questionnaire> models) {
		List<QuestionnaireSoap> soapModels = new ArrayList<QuestionnaireSoap>(models.size());

		for (Questionnaire model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionnaireSoap[soapModels.size()]);
	}

	public QuestionnaireSoap() {
	}

	public long getPrimaryKey() {
		return _questionnaireId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionnaireId(pk);
	}

	public long getQuestionnaireId() {
		return _questionnaireId;
	}

	public void setQuestionnaireId(long questionnaireId) {
		_questionnaireId = questionnaireId;
	}

	public long getEntryClassPK() {
		return _entryClassPK;
	}

	public void setEntryClassPK(long entryClassPK) {
		_entryClassPK = entryClassPK;
	}

	public String getEntryClassName() {
		return _entryClassName;
	}

	public void setEntryClassName(String entryClassName) {
		_entryClassName = entryClassName;
	}

	public String getAnswer1() {
		return _answer1;
	}

	public void setAnswer1(String answer1) {
		_answer1 = answer1;
	}

	public String getAnswer2() {
		return _answer2;
	}

	public void setAnswer2(String answer2) {
		_answer2 = answer2;
	}

	public String getAnswer3() {
		return _answer3;
	}

	public void setAnswer3(String answer3) {
		_answer3 = answer3;
	}

	public String getAnswer4() {
		return _answer4;
	}

	public void setAnswer4(String answer4) {
		_answer4 = answer4;
	}

	public String getAnswer5() {
		return _answer5;
	}

	public void setAnswer5(String answer5) {
		_answer5 = answer5;
	}

	public String getAnswer6() {
		return _answer6;
	}

	public void setAnswer6(String answer6) {
		_answer6 = answer6;
	}

	public String getAnswer7() {
		return _answer7;
	}

	public void setAnswer7(String answer7) {
		_answer7 = answer7;
	}

	public String getAnswer8() {
		return _answer8;
	}

	public void setAnswer8(String answer8) {
		_answer8 = answer8;
	}

	public String getAnswer9() {
		return _answer9;
	}

	public void setAnswer9(String answer9) {
		_answer9 = answer9;
	}

	public String getAnswer10() {
		return _answer10;
	}

	public void setAnswer10(String answer10) {
		_answer10 = answer10;
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
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}