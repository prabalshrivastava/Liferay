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

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailTemplateClp extends BaseModelImpl<SPMailTemplate>
	implements SPMailTemplate {
	public SPMailTemplateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailTemplate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMailTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailTemplateId", getSpMailTemplateId());
		attributes.put("productTypeId", getProductTypeId());
		attributes.put("subProductTypeId", getSubProductTypeId());
		attributes.put("templateName", getTemplateName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("subject", getSubject());
		attributes.put("htmlContent", getHtmlContent());
		attributes.put("textContent", getTextContent());
		attributes.put("htmlUpload", getHtmlUpload());
		attributes.put("status", getStatus());
		attributes.put("createBy", getCreateBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentTempalteId", getParentTempalteId());
		attributes.put("versionNumber", getVersionNumber());
		attributes.put("fromAddress", getFromAddress());
		attributes.put("fromName", getFromName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailTemplateId = (Long)attributes.get("spMailTemplateId");

		if (spMailTemplateId != null) {
			setSpMailTemplateId(spMailTemplateId);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}

		Long subProductTypeId = (Long)attributes.get("subProductTypeId");

		if (subProductTypeId != null) {
			setSubProductTypeId(subProductTypeId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String htmlContent = (String)attributes.get("htmlContent");

		if (htmlContent != null) {
			setHtmlContent(htmlContent);
		}

		String textContent = (String)attributes.get("textContent");

		if (textContent != null) {
			setTextContent(textContent);
		}

		Boolean htmlUpload = (Boolean)attributes.get("htmlUpload");

		if (htmlUpload != null) {
			setHtmlUpload(htmlUpload);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long parentTempalteId = (Long)attributes.get("parentTempalteId");

		if (parentTempalteId != null) {
			setParentTempalteId(parentTempalteId);
		}

		String versionNumber = (String)attributes.get("versionNumber");

		if (versionNumber != null) {
			setVersionNumber(versionNumber);
		}

		String fromAddress = (String)attributes.get("fromAddress");

		if (fromAddress != null) {
			setFromAddress(fromAddress);
		}

		String fromName = (String)attributes.get("fromName");

		if (fromName != null) {
			setFromName(fromName);
		}
	}

	@Override
	public long getSpMailTemplateId() {
		return _spMailTemplateId;
	}

	@Override
	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailTemplateId = spMailTemplateId;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailTemplateId",
						long.class);

				method.invoke(_spMailTemplateRemoteModel, spMailTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductTypeId() {
		return _productTypeId;
	}

	@Override
	public void setProductTypeId(long productTypeId) {
		_productTypeId = productTypeId;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setProductTypeId", long.class);

				method.invoke(_spMailTemplateRemoteModel, productTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubProductTypeId() {
		return _subProductTypeId;
	}

	@Override
	public void setSubProductTypeId(long subProductTypeId) {
		_subProductTypeId = subProductTypeId;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProductTypeId",
						long.class);

				method.invoke(_spMailTemplateRemoteModel, subProductTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateName() {
		return _templateName;
	}

	@Override
	public void setTemplateName(String templateName) {
		_templateName = templateName;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateName", String.class);

				method.invoke(_spMailTemplateRemoteModel, templateName);
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

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spMailTemplateRemoteModel, groupId);
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

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spMailTemplateRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_spMailTemplateRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtmlContent() {
		return _htmlContent;
	}

	@Override
	public void setHtmlContent(String htmlContent) {
		_htmlContent = htmlContent;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmlContent", String.class);

				method.invoke(_spMailTemplateRemoteModel, htmlContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTextContent() {
		return _textContent;
	}

	@Override
	public void setTextContent(String textContent) {
		_textContent = textContent;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTextContent", String.class);

				method.invoke(_spMailTemplateRemoteModel, textContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHtmlUpload() {
		return _htmlUpload;
	}

	@Override
	public boolean isHtmlUpload() {
		return _htmlUpload;
	}

	@Override
	public void setHtmlUpload(boolean htmlUpload) {
		_htmlUpload = htmlUpload;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmlUpload", boolean.class);

				method.invoke(_spMailTemplateRemoteModel, htmlUpload);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_spMailTemplateRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(long createBy) {
		_createBy = createBy;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateBy", long.class);

				method.invoke(_spMailTemplateRemoteModel, createBy);
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

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spMailTemplateRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spMailTemplateRemoteModel, modifiedBy);
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

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spMailTemplateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentTempalteId() {
		return _parentTempalteId;
	}

	@Override
	public void setParentTempalteId(long parentTempalteId) {
		_parentTempalteId = parentTempalteId;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setParentTempalteId",
						long.class);

				method.invoke(_spMailTemplateRemoteModel, parentTempalteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersionNumber() {
		return _versionNumber;
	}

	@Override
	public void setVersionNumber(String versionNumber) {
		_versionNumber = versionNumber;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setVersionNumber", String.class);

				method.invoke(_spMailTemplateRemoteModel, versionNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromAddress() {
		return _fromAddress;
	}

	@Override
	public void setFromAddress(String fromAddress) {
		_fromAddress = fromAddress;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setFromAddress", String.class);

				method.invoke(_spMailTemplateRemoteModel, fromAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromName() {
		return _fromName;
	}

	@Override
	public void setFromName(String fromName) {
		_fromName = fromName;

		if (_spMailTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setFromName", String.class);

				method.invoke(_spMailTemplateRemoteModel, fromName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailTemplateRemoteModel() {
		return _spMailTemplateRemoteModel;
	}

	public void setSPMailTemplateRemoteModel(
		BaseModel<?> spMailTemplateRemoteModel) {
		_spMailTemplateRemoteModel = spMailTemplateRemoteModel;
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

		Class<?> remoteModelClass = _spMailTemplateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailTemplateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailTemplateLocalServiceUtil.addSPMailTemplate(this);
		}
		else {
			SPMailTemplateLocalServiceUtil.updateSPMailTemplate(this);
		}
	}

	@Override
	public SPMailTemplate toEscapedModel() {
		return (SPMailTemplate)ProxyUtil.newProxyInstance(SPMailTemplate.class.getClassLoader(),
			new Class[] { SPMailTemplate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailTemplateClp clone = new SPMailTemplateClp();

		clone.setSpMailTemplateId(getSpMailTemplateId());
		clone.setProductTypeId(getProductTypeId());
		clone.setSubProductTypeId(getSubProductTypeId());
		clone.setTemplateName(getTemplateName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setSubject(getSubject());
		clone.setHtmlContent(getHtmlContent());
		clone.setTextContent(getTextContent());
		clone.setHtmlUpload(getHtmlUpload());
		clone.setStatus(getStatus());
		clone.setCreateBy(getCreateBy());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedBy(getModifiedBy());
		clone.setModifiedDate(getModifiedDate());
		clone.setParentTempalteId(getParentTempalteId());
		clone.setVersionNumber(getVersionNumber());
		clone.setFromAddress(getFromAddress());
		clone.setFromName(getFromName());

		return clone;
	}

	@Override
	public int compareTo(SPMailTemplate spMailTemplate) {
		int value = 0;

		if (getParentTempalteId() < spMailTemplate.getParentTempalteId()) {
			value = -1;
		}
		else if (getParentTempalteId() > spMailTemplate.getParentTempalteId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getVersionNumber().compareTo(spMailTemplate.getVersionNumber());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getModifiedDate(),
				spMailTemplate.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailTemplateClp)) {
			return false;
		}

		SPMailTemplateClp spMailTemplate = (SPMailTemplateClp)obj;

		long primaryKey = spMailTemplate.getPrimaryKey();

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

		sb.append("{spMailTemplateId=");
		sb.append(getSpMailTemplateId());
		sb.append(", productTypeId=");
		sb.append(getProductTypeId());
		sb.append(", subProductTypeId=");
		sb.append(getSubProductTypeId());
		sb.append(", templateName=");
		sb.append(getTemplateName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", htmlContent=");
		sb.append(getHtmlContent());
		sb.append(", textContent=");
		sb.append(getTextContent());
		sb.append(", htmlUpload=");
		sb.append(getHtmlUpload());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", parentTempalteId=");
		sb.append(getParentTempalteId());
		sb.append(", versionNumber=");
		sb.append(getVersionNumber());
		sb.append(", fromAddress=");
		sb.append(getFromAddress());
		sb.append(", fromName=");
		sb.append(getFromName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailTemplateId</column-name><column-value><![CDATA[");
		sb.append(getSpMailTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productTypeId</column-name><column-value><![CDATA[");
		sb.append(getProductTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subProductTypeId</column-name><column-value><![CDATA[");
		sb.append(getSubProductTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateName</column-name><column-value><![CDATA[");
		sb.append(getTemplateName());
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
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmlContent</column-name><column-value><![CDATA[");
		sb.append(getHtmlContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textContent</column-name><column-value><![CDATA[");
		sb.append(getTextContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmlUpload</column-name><column-value><![CDATA[");
		sb.append(getHtmlUpload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentTempalteId</column-name><column-value><![CDATA[");
		sb.append(getParentTempalteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versionNumber</column-name><column-value><![CDATA[");
		sb.append(getVersionNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromAddress</column-name><column-value><![CDATA[");
		sb.append(getFromAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromName</column-name><column-value><![CDATA[");
		sb.append(getFromName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailTemplateId;
	private long _productTypeId;
	private long _subProductTypeId;
	private String _templateName;
	private long _groupId;
	private long _companyId;
	private String _subject;
	private String _htmlContent;
	private String _textContent;
	private boolean _htmlUpload;
	private boolean _status;
	private long _createBy;
	private Date _createDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private long _parentTempalteId;
	private String _versionNumber;
	private String _fromAddress;
	private String _fromName;
	private BaseModel<?> _spMailTemplateRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}