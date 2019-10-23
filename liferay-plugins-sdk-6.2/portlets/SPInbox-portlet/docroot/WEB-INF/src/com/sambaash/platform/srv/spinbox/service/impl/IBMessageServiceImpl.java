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
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.service.base.IBMessageServiceBaseImpl;

/**
 * The implementation of the i b message remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.portlet.spinbox.srv.service.IBMessageService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.portlet.spinbox.srv.service.base.IBMessageServiceBaseImpl
 * @see com.sambaash.platform.portlet.spinbox.srv.service.IBMessageServiceUtil
 */
public class IBMessageServiceImpl extends IBMessageServiceBaseImpl {


	public IBMessage addMessage(String uuid, long parentMessageId, long groupId, long companyId, String subject, String content,
			Date createDate, String from, String to, String createBy, String createByUserId, boolean isAllowOpen, boolean isDraft,
			String draftStatus, boolean isSentMeCopy) throws PortalException, SystemException {

		long messageId = counterLocalService.increment();
		IBMessage message = ibMessagePersistence.create(messageId);

		message.setUuid(uuid);
		message.setParentMessageId(parentMessageId);
		message.setGroupId(groupId);
		message.setCompanyId(companyId);
		message.setSubject(subject);
		message.setContent(content);
		message.setCreateDate(createDate);
		message.setFrom(from);
		message.setTo(to);
		message.setCreateBy(createBy);
		message.setCreateByUserId(createByUserId);
		message.setAllowOpen(isAllowOpen);
		message.setDraft(isDraft);
		message.setDraftStatus(draftStatus);
		message.setSentMeCopy(isSentMeCopy);

		ibMessagePersistence.update(message, false);

		return message;
	}


}