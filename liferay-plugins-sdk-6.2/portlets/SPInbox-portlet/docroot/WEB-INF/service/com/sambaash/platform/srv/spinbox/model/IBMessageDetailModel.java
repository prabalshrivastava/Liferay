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

package com.sambaash.platform.srv.spinbox.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the IBMessageDetail service. Represents a row in the &quot;SPInboxMessageDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessageDetail
 * @see com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailImpl
 * @see com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl
 * @generated
 */
public interface IBMessageDetailModel extends BaseModel<IBMessageDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a i b message detail model instance should use the {@link IBMessageDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this i b message detail.
	 *
	 * @return the primary key of this i b message detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this i b message detail.
	 *
	 * @param primaryKey the primary key of this i b message detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ib msg detail ID of this i b message detail.
	 *
	 * @return the ib msg detail ID of this i b message detail
	 */
	public long getIbMsgDetailId();

	/**
	 * Sets the ib msg detail ID of this i b message detail.
	 *
	 * @param ibMsgDetailId the ib msg detail ID of this i b message detail
	 */
	public void setIbMsgDetailId(long ibMsgDetailId);

	/**
	 * Returns the receiver ID of this i b message detail.
	 *
	 * @return the receiver ID of this i b message detail
	 */
	public long getReceiverId();

	/**
	 * Sets the receiver ID of this i b message detail.
	 *
	 * @param receiverId the receiver ID of this i b message detail
	 */
	public void setReceiverId(long receiverId);

	/**
	 * Returns the message ID of this i b message detail.
	 *
	 * @return the message ID of this i b message detail
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this i b message detail.
	 *
	 * @param messageId the message ID of this i b message detail
	 */
	public void setMessageId(long messageId);

	/**
	 * Returns the receiver msg status of this i b message detail.
	 *
	 * @return the receiver msg status of this i b message detail
	 */
	@AutoEscape
	public String getReceiverMsgStatus();

	/**
	 * Sets the receiver msg status of this i b message detail.
	 *
	 * @param receiverMsgStatus the receiver msg status of this i b message detail
	 */
	public void setReceiverMsgStatus(String receiverMsgStatus);

	/**
	 * Returns the sender msg status of this i b message detail.
	 *
	 * @return the sender msg status of this i b message detail
	 */
	@AutoEscape
	public String getSenderMsgStatus();

	/**
	 * Sets the sender msg status of this i b message detail.
	 *
	 * @param senderMsgStatus the sender msg status of this i b message detail
	 */
	public void setSenderMsgStatus(String senderMsgStatus);

	/**
	 * Returns the status of this i b message detail.
	 *
	 * @return the status of this i b message detail
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this i b message detail.
	 *
	 * @param status the status of this i b message detail
	 */
	public void setStatus(String status);

	/**
	 * Returns the receive date of this i b message detail.
	 *
	 * @return the receive date of this i b message detail
	 */
	public Date getReceiveDate();

	/**
	 * Sets the receive date of this i b message detail.
	 *
	 * @param receiveDate the receive date of this i b message detail
	 */
	public void setReceiveDate(Date receiveDate);

	/**
	 * Returns the receive by of this i b message detail.
	 *
	 * @return the receive by of this i b message detail
	 */
	@AutoEscape
	public String getReceiveBy();

	/**
	 * Sets the receive by of this i b message detail.
	 *
	 * @param receiveBy the receive by of this i b message detail
	 */
	public void setReceiveBy(String receiveBy);

	/**
	 * Returns the archived of this i b message detail.
	 *
	 * @return the archived of this i b message detail
	 */
	public boolean getArchived();

	/**
	 * Returns <code>true</code> if this i b message detail is archived.
	 *
	 * @return <code>true</code> if this i b message detail is archived; <code>false</code> otherwise
	 */
	public boolean isArchived();

	/**
	 * Sets whether this i b message detail is archived.
	 *
	 * @param archived the archived of this i b message detail
	 */
	public void setArchived(boolean archived);

	/**
	 * Returns the update date of this i b message detail.
	 *
	 * @return the update date of this i b message detail
	 */
	public Date getUpdateDate();

	/**
	 * Sets the update date of this i b message detail.
	 *
	 * @param updateDate the update date of this i b message detail
	 */
	public void setUpdateDate(Date updateDate);

	/**
	 * Returns the update by of this i b message detail.
	 *
	 * @return the update by of this i b message detail
	 */
	@AutoEscape
	public String getUpdateBy();

	/**
	 * Sets the update by of this i b message detail.
	 *
	 * @param updateBy the update by of this i b message detail
	 */
	public void setUpdateBy(String updateBy);

	/**
	 * Returns the category of this i b message detail.
	 *
	 * @return the category of this i b message detail
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this i b message detail.
	 *
	 * @param category the category of this i b message detail
	 */
	public void setCategory(String category);

	/**
	 * Returns the process ID of this i b message detail.
	 *
	 * @return the process ID of this i b message detail
	 */
	public long getProcessId();

	/**
	 * Sets the process ID of this i b message detail.
	 *
	 * @param processId the process ID of this i b message detail
	 */
	public void setProcessId(long processId);

	/**
	 * Returns the corp profile ID of this i b message detail.
	 *
	 * @return the corp profile ID of this i b message detail
	 */
	public long getCorpProfileId();

	/**
	 * Sets the corp profile ID of this i b message detail.
	 *
	 * @param corpProfileId the corp profile ID of this i b message detail
	 */
	public void setCorpProfileId(long corpProfileId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}