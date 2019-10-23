/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv.spinbox.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.service.base.IBMessageDetailServiceBaseImpl;

/**
 * The implementation of the i b message detail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.portlet.spinbox.srv.service.IBMessageDetailService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.portlet.spinbox.srv.service.base.IBMessageDetailServiceBaseImpl
 * @see com.sambaash.platform.portlet.spinbox.srv.service.IBMessageDetailServiceUtil
 */
public class IBMessageDetailServiceImpl extends IBMessageDetailServiceBaseImpl {

	public IBMessageDetail addMessageDetail(long messageId, long receiverId, String receiveBy, Date receiveDate, String category,
			boolean archived, Date updateDate, String updateBy, String receiverMsgStatus, String senderMsgStatus) throws PortalException, SystemException {

		long msgDetailId = counterLocalService.increment();
		IBMessageDetail msgDetail = ibMessageDetailPersistence.create(msgDetailId);

		msgDetail.setMessageId(messageId);
		msgDetail.setReceiverId(receiverId);
		msgDetail.setReceiveBy(receiveBy);
		msgDetail.setReceiveDate(receiveDate);
		msgDetail.setCategory(category);
		msgDetail.setArchived(archived);
		msgDetail.setUpdateDate(updateDate);
		msgDetail.setUpdateBy(updateBy);
		msgDetail.setReceiverMsgStatus(receiverMsgStatus);
		msgDetail.setSenderMsgStatus(senderMsgStatus);

		ibMessageDetailPersistence.update(msgDetail, false);

		return msgDetail;
	}

}