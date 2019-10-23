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

package com.sambaash.platform.srv.spsocialsharing.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialsharing.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPSocialSharingClp extends BaseModelImpl<SPSocialSharing>
	implements SPSocialSharing {
	public SPSocialSharingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSocialSharing.class;
	}

	@Override
	public String getModelClassName() {
		return SPSocialSharing.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSocialSharingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSocialSharingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSocialSharingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSocialSharingId", getSpSocialSharingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());
		attributes.put("linkedin", getLinkedin());
		attributes.put("yahoo", getYahoo());
		attributes.put("google", getGoogle());
		attributes.put("facebookPage", getFacebookPage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSocialSharingId = (Long)attributes.get("spSocialSharingId");

		if (spSocialSharingId != null) {
			setSpSocialSharingId(spSocialSharingId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer facebook = (Integer)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		Integer twitter = (Integer)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		Integer linkedin = (Integer)attributes.get("linkedin");

		if (linkedin != null) {
			setLinkedin(linkedin);
		}

		Integer yahoo = (Integer)attributes.get("yahoo");

		if (yahoo != null) {
			setYahoo(yahoo);
		}

		Integer google = (Integer)attributes.get("google");

		if (google != null) {
			setGoogle(google);
		}

		Integer facebookPage = (Integer)attributes.get("facebookPage");

		if (facebookPage != null) {
			setFacebookPage(facebookPage);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spSocialSharingRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpSocialSharingId() {
		return _spSocialSharingId;
	}

	@Override
	public void setSpSocialSharingId(long spSocialSharingId) {
		_spSocialSharingId = spSocialSharingId;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSocialSharingId",
						long.class);

				method.invoke(_spSocialSharingRemoteModel, spSocialSharingId);
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

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSocialSharingRemoteModel, groupId);
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

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSocialSharingRemoteModel, companyId);
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

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSocialSharingRemoteModel, userId);
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

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSocialSharingRemoteModel, userName);
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

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSocialSharingRemoteModel, createDate);
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

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSocialSharingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_spSocialSharingRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_spSocialSharingRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFacebook() {
		return _facebook;
	}

	@Override
	public void setFacebook(int facebook) {
		_facebook = facebook;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebook", int.class);

				method.invoke(_spSocialSharingRemoteModel, facebook);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTwitter() {
		return _twitter;
	}

	@Override
	public void setTwitter(int twitter) {
		_twitter = twitter;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitter", int.class);

				method.invoke(_spSocialSharingRemoteModel, twitter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLinkedin() {
		return _linkedin;
	}

	@Override
	public void setLinkedin(int linkedin) {
		_linkedin = linkedin;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkedin", int.class);

				method.invoke(_spSocialSharingRemoteModel, linkedin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYahoo() {
		return _yahoo;
	}

	@Override
	public void setYahoo(int yahoo) {
		_yahoo = yahoo;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setYahoo", int.class);

				method.invoke(_spSocialSharingRemoteModel, yahoo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGoogle() {
		return _google;
	}

	@Override
	public void setGoogle(int google) {
		_google = google;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setGoogle", int.class);

				method.invoke(_spSocialSharingRemoteModel, google);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFacebookPage() {
		return _facebookPage;
	}

	@Override
	public void setFacebookPage(int facebookPage) {
		_facebookPage = facebookPage;

		if (_spSocialSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSocialSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebookPage", int.class);

				method.invoke(_spSocialSharingRemoteModel, facebookPage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPSocialSharing.class.getName()), getClassNameId());
	}

	public BaseModel<?> getSPSocialSharingRemoteModel() {
		return _spSocialSharingRemoteModel;
	}

	public void setSPSocialSharingRemoteModel(
		BaseModel<?> spSocialSharingRemoteModel) {
		_spSocialSharingRemoteModel = spSocialSharingRemoteModel;
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

		Class<?> remoteModelClass = _spSocialSharingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSocialSharingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSocialSharingLocalServiceUtil.addSPSocialSharing(this);
		}
		else {
			SPSocialSharingLocalServiceUtil.updateSPSocialSharing(this);
		}
	}

	@Override
	public SPSocialSharing toEscapedModel() {
		return (SPSocialSharing)ProxyUtil.newProxyInstance(SPSocialSharing.class.getClassLoader(),
			new Class[] { SPSocialSharing.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSocialSharingClp clone = new SPSocialSharingClp();

		clone.setUuid(getUuid());
		clone.setSpSocialSharingId(getSpSocialSharingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setFacebook(getFacebook());
		clone.setTwitter(getTwitter());
		clone.setLinkedin(getLinkedin());
		clone.setYahoo(getYahoo());
		clone.setGoogle(getGoogle());
		clone.setFacebookPage(getFacebookPage());

		return clone;
	}

	@Override
	public int compareTo(SPSocialSharing spSocialSharing) {
		long primaryKey = spSocialSharing.getPrimaryKey();

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

		if (!(obj instanceof SPSocialSharingClp)) {
			return false;
		}

		SPSocialSharingClp spSocialSharing = (SPSocialSharingClp)obj;

		long primaryKey = spSocialSharing.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spSocialSharingId=");
		sb.append(getSpSocialSharingId());
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
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", facebook=");
		sb.append(getFacebook());
		sb.append(", twitter=");
		sb.append(getTwitter());
		sb.append(", linkedin=");
		sb.append(getLinkedin());
		sb.append(", yahoo=");
		sb.append(getYahoo());
		sb.append(", google=");
		sb.append(getGoogle());
		sb.append(", facebookPage=");
		sb.append(getFacebookPage());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spSocialSharingId</column-name><column-value><![CDATA[");
		sb.append(getSpSocialSharingId());
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
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebook</column-name><column-value><![CDATA[");
		sb.append(getFacebook());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitter</column-name><column-value><![CDATA[");
		sb.append(getTwitter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkedin</column-name><column-value><![CDATA[");
		sb.append(getLinkedin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yahoo</column-name><column-value><![CDATA[");
		sb.append(getYahoo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>google</column-name><column-value><![CDATA[");
		sb.append(getGoogle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebookPage</column-name><column-value><![CDATA[");
		sb.append(getFacebookPage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spSocialSharingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private int _facebook;
	private int _twitter;
	private int _linkedin;
	private int _yahoo;
	private int _google;
	private int _facebookPage;
	private BaseModel<?> _spSocialSharingRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialsharing.service.ClpSerializer.class;
}