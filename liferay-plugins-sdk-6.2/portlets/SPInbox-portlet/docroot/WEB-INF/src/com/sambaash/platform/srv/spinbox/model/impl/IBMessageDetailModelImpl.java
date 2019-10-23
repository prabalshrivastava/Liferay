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

package com.sambaash.platform.srv.spinbox.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetailModel;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetailSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the IBMessageDetail service. Represents a row in the &quot;SPInboxMessageDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.spinbox.model.IBMessageDetailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IBMessageDetailImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessageDetailImpl
 * @see com.sambaash.platform.srv.spinbox.model.IBMessageDetail
 * @see com.sambaash.platform.srv.spinbox.model.IBMessageDetailModel
 * @generated
 */
@JSON(strict = true)
public class IBMessageDetailModelImpl extends BaseModelImpl<IBMessageDetail>
	implements IBMessageDetailModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a i b message detail model instance should use the {@link com.sambaash.platform.srv.spinbox.model.IBMessageDetail} interface instead.
	 */
	public static final String TABLE_NAME = "SPInboxMessageDetail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ibMsgDetailId", Types.BIGINT },
			{ "receiverId", Types.BIGINT },
			{ "messageId", Types.BIGINT },
			{ "receiverMsgStatus", Types.VARCHAR },
			{ "senderMsgStatus", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "receiveDate", Types.TIMESTAMP },
			{ "receiveBy", Types.VARCHAR },
			{ "archived", Types.BOOLEAN },
			{ "updateDate", Types.TIMESTAMP },
			{ "updateBy", Types.VARCHAR },
			{ "category", Types.VARCHAR },
			{ "processId", Types.BIGINT },
			{ "corpProfileId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPInboxMessageDetail (ibMsgDetailId BIGINT(20) not null primary key,receiverId BIGINT(20),messageId BIGINT(20),receiverMsgStatus VARCHAR(75) null,senderMsgStatus VARCHAR(75) null,status VARCHAR(75) null,receiveDate DATETIME null,receiveBy VARCHAR(75) null,archived BOOLEAN,updateDate DATETIME null,updateBy VARCHAR(75) null,category VARCHAR(75) null,processId BIGINT(20),corpProfileId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPInboxMessageDetail";
	public static final String ORDER_BY_JPQL = " ORDER BY ibMessageDetail.receiveDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SPInboxMessageDetail.receiveDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.spinbox.model.IBMessageDetail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.spinbox.model.IBMessageDetail"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.spinbox.model.IBMessageDetail"),
			true);
	public static long ARCHIVED_COLUMN_BITMASK = 1L;
	public static long CATEGORY_COLUMN_BITMASK = 2L;
	public static long CORPPROFILEID_COLUMN_BITMASK = 4L;
	public static long MESSAGEID_COLUMN_BITMASK = 8L;
	public static long RECEIVERID_COLUMN_BITMASK = 16L;
	public static long RECEIVERMSGSTATUS_COLUMN_BITMASK = 32L;
	public static long SENDERMSGSTATUS_COLUMN_BITMASK = 64L;
	public static long RECEIVEDATE_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static IBMessageDetail toModel(IBMessageDetailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		IBMessageDetail model = new IBMessageDetailImpl();

		model.setIbMsgDetailId(soapModel.getIbMsgDetailId());
		model.setReceiverId(soapModel.getReceiverId());
		model.setMessageId(soapModel.getMessageId());
		model.setReceiverMsgStatus(soapModel.getReceiverMsgStatus());
		model.setSenderMsgStatus(soapModel.getSenderMsgStatus());
		model.setStatus(soapModel.getStatus());
		model.setReceiveDate(soapModel.getReceiveDate());
		model.setReceiveBy(soapModel.getReceiveBy());
		model.setArchived(soapModel.getArchived());
		model.setUpdateDate(soapModel.getUpdateDate());
		model.setUpdateBy(soapModel.getUpdateBy());
		model.setCategory(soapModel.getCategory());
		model.setProcessId(soapModel.getProcessId());
		model.setCorpProfileId(soapModel.getCorpProfileId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<IBMessageDetail> toModels(
		IBMessageDetailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<IBMessageDetail> models = new ArrayList<IBMessageDetail>(soapModels.length);

		for (IBMessageDetailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.spinbox.model.IBMessageDetail"));

	public IBMessageDetailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ibMsgDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIbMsgDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ibMsgDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return IBMessageDetail.class;
	}

	@Override
	public String getModelClassName() {
		return IBMessageDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ibMsgDetailId", getIbMsgDetailId());
		attributes.put("receiverId", getReceiverId());
		attributes.put("messageId", getMessageId());
		attributes.put("receiverMsgStatus", getReceiverMsgStatus());
		attributes.put("senderMsgStatus", getSenderMsgStatus());
		attributes.put("status", getStatus());
		attributes.put("receiveDate", getReceiveDate());
		attributes.put("receiveBy", getReceiveBy());
		attributes.put("archived", getArchived());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updateBy", getUpdateBy());
		attributes.put("category", getCategory());
		attributes.put("processId", getProcessId());
		attributes.put("corpProfileId", getCorpProfileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ibMsgDetailId = (Long)attributes.get("ibMsgDetailId");

		if (ibMsgDetailId != null) {
			setIbMsgDetailId(ibMsgDetailId);
		}

		Long receiverId = (Long)attributes.get("receiverId");

		if (receiverId != null) {
			setReceiverId(receiverId);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String receiverMsgStatus = (String)attributes.get("receiverMsgStatus");

		if (receiverMsgStatus != null) {
			setReceiverMsgStatus(receiverMsgStatus);
		}

		String senderMsgStatus = (String)attributes.get("senderMsgStatus");

		if (senderMsgStatus != null) {
			setSenderMsgStatus(senderMsgStatus);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date receiveDate = (Date)attributes.get("receiveDate");

		if (receiveDate != null) {
			setReceiveDate(receiveDate);
		}

		String receiveBy = (String)attributes.get("receiveBy");

		if (receiveBy != null) {
			setReceiveBy(receiveBy);
		}

		Boolean archived = (Boolean)attributes.get("archived");

		if (archived != null) {
			setArchived(archived);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		String updateBy = (String)attributes.get("updateBy");

		if (updateBy != null) {
			setUpdateBy(updateBy);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long processId = (Long)attributes.get("processId");

		if (processId != null) {
			setProcessId(processId);
		}

		Long corpProfileId = (Long)attributes.get("corpProfileId");

		if (corpProfileId != null) {
			setCorpProfileId(corpProfileId);
		}
	}

	@JSON
	@Override
	public long getIbMsgDetailId() {
		return _ibMsgDetailId;
	}

	@Override
	public void setIbMsgDetailId(long ibMsgDetailId) {
		_ibMsgDetailId = ibMsgDetailId;
	}

	@JSON
	@Override
	public long getReceiverId() {
		return _receiverId;
	}

	@Override
	public void setReceiverId(long receiverId) {
		_columnBitmask |= RECEIVERID_COLUMN_BITMASK;

		if (!_setOriginalReceiverId) {
			_setOriginalReceiverId = true;

			_originalReceiverId = _receiverId;
		}

		_receiverId = receiverId;
	}

	public long getOriginalReceiverId() {
		return _originalReceiverId;
	}

	@JSON
	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_columnBitmask |= MESSAGEID_COLUMN_BITMASK;

		if (!_setOriginalMessageId) {
			_setOriginalMessageId = true;

			_originalMessageId = _messageId;
		}

		_messageId = messageId;
	}

	public long getOriginalMessageId() {
		return _originalMessageId;
	}

	@JSON
	@Override
	public String getReceiverMsgStatus() {
		if (_receiverMsgStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _receiverMsgStatus;
		}
	}

	@Override
	public void setReceiverMsgStatus(String receiverMsgStatus) {
		_columnBitmask |= RECEIVERMSGSTATUS_COLUMN_BITMASK;

		if (_originalReceiverMsgStatus == null) {
			_originalReceiverMsgStatus = _receiverMsgStatus;
		}

		_receiverMsgStatus = receiverMsgStatus;
	}

	public String getOriginalReceiverMsgStatus() {
		return GetterUtil.getString(_originalReceiverMsgStatus);
	}

	@JSON
	@Override
	public String getSenderMsgStatus() {
		if (_senderMsgStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _senderMsgStatus;
		}
	}

	@Override
	public void setSenderMsgStatus(String senderMsgStatus) {
		_columnBitmask |= SENDERMSGSTATUS_COLUMN_BITMASK;

		if (_originalSenderMsgStatus == null) {
			_originalSenderMsgStatus = _senderMsgStatus;
		}

		_senderMsgStatus = senderMsgStatus;
	}

	public String getOriginalSenderMsgStatus() {
		return GetterUtil.getString(_originalSenderMsgStatus);
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@JSON
	@Override
	public Date getReceiveDate() {
		return _receiveDate;
	}

	@Override
	public void setReceiveDate(Date receiveDate) {
		_columnBitmask = -1L;

		_receiveDate = receiveDate;
	}

	@JSON
	@Override
	public String getReceiveBy() {
		if (_receiveBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _receiveBy;
		}
	}

	@Override
	public void setReceiveBy(String receiveBy) {
		_receiveBy = receiveBy;
	}

	@JSON
	@Override
	public boolean getArchived() {
		return _archived;
	}

	@Override
	public boolean isArchived() {
		return _archived;
	}

	@Override
	public void setArchived(boolean archived) {
		_columnBitmask |= ARCHIVED_COLUMN_BITMASK;

		if (!_setOriginalArchived) {
			_setOriginalArchived = true;

			_originalArchived = _archived;
		}

		_archived = archived;
	}

	public boolean getOriginalArchived() {
		return _originalArchived;
	}

	@JSON
	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	@JSON
	@Override
	public String getUpdateBy() {
		if (_updateBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _updateBy;
		}
	}

	@Override
	public void setUpdateBy(String updateBy) {
		_updateBy = updateBy;
	}

	@JSON
	@Override
	public String getCategory() {
		if (_category == null) {
			return StringPool.BLANK;
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		_columnBitmask |= CATEGORY_COLUMN_BITMASK;

		if (_originalCategory == null) {
			_originalCategory = _category;
		}

		_category = category;
	}

	public String getOriginalCategory() {
		return GetterUtil.getString(_originalCategory);
	}

	@JSON
	@Override
	public long getProcessId() {
		return _processId;
	}

	@Override
	public void setProcessId(long processId) {
		_processId = processId;
	}

	@JSON
	@Override
	public long getCorpProfileId() {
		return _corpProfileId;
	}

	@Override
	public void setCorpProfileId(long corpProfileId) {
		_columnBitmask |= CORPPROFILEID_COLUMN_BITMASK;

		if (!_setOriginalCorpProfileId) {
			_setOriginalCorpProfileId = true;

			_originalCorpProfileId = _corpProfileId;
		}

		_corpProfileId = corpProfileId;
	}

	public long getOriginalCorpProfileId() {
		return _originalCorpProfileId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			IBMessageDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public IBMessageDetail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (IBMessageDetail)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IBMessageDetailImpl ibMessageDetailImpl = new IBMessageDetailImpl();

		ibMessageDetailImpl.setIbMsgDetailId(getIbMsgDetailId());
		ibMessageDetailImpl.setReceiverId(getReceiverId());
		ibMessageDetailImpl.setMessageId(getMessageId());
		ibMessageDetailImpl.setReceiverMsgStatus(getReceiverMsgStatus());
		ibMessageDetailImpl.setSenderMsgStatus(getSenderMsgStatus());
		ibMessageDetailImpl.setStatus(getStatus());
		ibMessageDetailImpl.setReceiveDate(getReceiveDate());
		ibMessageDetailImpl.setReceiveBy(getReceiveBy());
		ibMessageDetailImpl.setArchived(getArchived());
		ibMessageDetailImpl.setUpdateDate(getUpdateDate());
		ibMessageDetailImpl.setUpdateBy(getUpdateBy());
		ibMessageDetailImpl.setCategory(getCategory());
		ibMessageDetailImpl.setProcessId(getProcessId());
		ibMessageDetailImpl.setCorpProfileId(getCorpProfileId());

		ibMessageDetailImpl.resetOriginalValues();

		return ibMessageDetailImpl;
	}

	@Override
	public int compareTo(IBMessageDetail ibMessageDetail) {
		int value = 0;

		value = DateUtil.compareTo(getReceiveDate(),
				ibMessageDetail.getReceiveDate());

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

		if (!(obj instanceof IBMessageDetail)) {
			return false;
		}

		IBMessageDetail ibMessageDetail = (IBMessageDetail)obj;

		long primaryKey = ibMessageDetail.getPrimaryKey();

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
		IBMessageDetailModelImpl ibMessageDetailModelImpl = this;

		ibMessageDetailModelImpl._originalReceiverId = ibMessageDetailModelImpl._receiverId;

		ibMessageDetailModelImpl._setOriginalReceiverId = false;

		ibMessageDetailModelImpl._originalMessageId = ibMessageDetailModelImpl._messageId;

		ibMessageDetailModelImpl._setOriginalMessageId = false;

		ibMessageDetailModelImpl._originalReceiverMsgStatus = ibMessageDetailModelImpl._receiverMsgStatus;

		ibMessageDetailModelImpl._originalSenderMsgStatus = ibMessageDetailModelImpl._senderMsgStatus;

		ibMessageDetailModelImpl._originalArchived = ibMessageDetailModelImpl._archived;

		ibMessageDetailModelImpl._setOriginalArchived = false;

		ibMessageDetailModelImpl._originalCategory = ibMessageDetailModelImpl._category;

		ibMessageDetailModelImpl._originalCorpProfileId = ibMessageDetailModelImpl._corpProfileId;

		ibMessageDetailModelImpl._setOriginalCorpProfileId = false;

		ibMessageDetailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<IBMessageDetail> toCacheModel() {
		IBMessageDetailCacheModel ibMessageDetailCacheModel = new IBMessageDetailCacheModel();

		ibMessageDetailCacheModel.ibMsgDetailId = getIbMsgDetailId();

		ibMessageDetailCacheModel.receiverId = getReceiverId();

		ibMessageDetailCacheModel.messageId = getMessageId();

		ibMessageDetailCacheModel.receiverMsgStatus = getReceiverMsgStatus();

		String receiverMsgStatus = ibMessageDetailCacheModel.receiverMsgStatus;

		if ((receiverMsgStatus != null) && (receiverMsgStatus.length() == 0)) {
			ibMessageDetailCacheModel.receiverMsgStatus = null;
		}

		ibMessageDetailCacheModel.senderMsgStatus = getSenderMsgStatus();

		String senderMsgStatus = ibMessageDetailCacheModel.senderMsgStatus;

		if ((senderMsgStatus != null) && (senderMsgStatus.length() == 0)) {
			ibMessageDetailCacheModel.senderMsgStatus = null;
		}

		ibMessageDetailCacheModel.status = getStatus();

		String status = ibMessageDetailCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			ibMessageDetailCacheModel.status = null;
		}

		Date receiveDate = getReceiveDate();

		if (receiveDate != null) {
			ibMessageDetailCacheModel.receiveDate = receiveDate.getTime();
		}
		else {
			ibMessageDetailCacheModel.receiveDate = Long.MIN_VALUE;
		}

		ibMessageDetailCacheModel.receiveBy = getReceiveBy();

		String receiveBy = ibMessageDetailCacheModel.receiveBy;

		if ((receiveBy != null) && (receiveBy.length() == 0)) {
			ibMessageDetailCacheModel.receiveBy = null;
		}

		ibMessageDetailCacheModel.archived = getArchived();

		Date updateDate = getUpdateDate();

		if (updateDate != null) {
			ibMessageDetailCacheModel.updateDate = updateDate.getTime();
		}
		else {
			ibMessageDetailCacheModel.updateDate = Long.MIN_VALUE;
		}

		ibMessageDetailCacheModel.updateBy = getUpdateBy();

		String updateBy = ibMessageDetailCacheModel.updateBy;

		if ((updateBy != null) && (updateBy.length() == 0)) {
			ibMessageDetailCacheModel.updateBy = null;
		}

		ibMessageDetailCacheModel.category = getCategory();

		String category = ibMessageDetailCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			ibMessageDetailCacheModel.category = null;
		}

		ibMessageDetailCacheModel.processId = getProcessId();

		ibMessageDetailCacheModel.corpProfileId = getCorpProfileId();

		return ibMessageDetailCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{ibMsgDetailId=");
		sb.append(getIbMsgDetailId());
		sb.append(", receiverId=");
		sb.append(getReceiverId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", receiverMsgStatus=");
		sb.append(getReceiverMsgStatus());
		sb.append(", senderMsgStatus=");
		sb.append(getSenderMsgStatus());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", receiveDate=");
		sb.append(getReceiveDate());
		sb.append(", receiveBy=");
		sb.append(getReceiveBy());
		sb.append(", archived=");
		sb.append(getArchived());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append(", updateBy=");
		sb.append(getUpdateBy());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", processId=");
		sb.append(getProcessId());
		sb.append(", corpProfileId=");
		sb.append(getCorpProfileId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spinbox.model.IBMessageDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ibMsgDetailId</column-name><column-value><![CDATA[");
		sb.append(getIbMsgDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverId</column-name><column-value><![CDATA[");
		sb.append(getReceiverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverMsgStatus</column-name><column-value><![CDATA[");
		sb.append(getReceiverMsgStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderMsgStatus</column-name><column-value><![CDATA[");
		sb.append(getSenderMsgStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiveDate</column-name><column-value><![CDATA[");
		sb.append(getReceiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiveBy</column-name><column-value><![CDATA[");
		sb.append(getReceiveBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archived</column-name><column-value><![CDATA[");
		sb.append(getArchived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateBy</column-name><column-value><![CDATA[");
		sb.append(getUpdateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processId</column-name><column-value><![CDATA[");
		sb.append(getProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corpProfileId</column-name><column-value><![CDATA[");
		sb.append(getCorpProfileId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = IBMessageDetail.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			IBMessageDetail.class
		};
	private long _ibMsgDetailId;
	private long _receiverId;
	private long _originalReceiverId;
	private boolean _setOriginalReceiverId;
	private long _messageId;
	private long _originalMessageId;
	private boolean _setOriginalMessageId;
	private String _receiverMsgStatus;
	private String _originalReceiverMsgStatus;
	private String _senderMsgStatus;
	private String _originalSenderMsgStatus;
	private String _status;
	private Date _receiveDate;
	private String _receiveBy;
	private boolean _archived;
	private boolean _originalArchived;
	private boolean _setOriginalArchived;
	private Date _updateDate;
	private String _updateBy;
	private String _category;
	private String _originalCategory;
	private long _processId;
	private long _corpProfileId;
	private long _originalCorpProfileId;
	private boolean _setOriginalCorpProfileId;
	private long _columnBitmask;
	private IBMessageDetail _escapedModel;
}