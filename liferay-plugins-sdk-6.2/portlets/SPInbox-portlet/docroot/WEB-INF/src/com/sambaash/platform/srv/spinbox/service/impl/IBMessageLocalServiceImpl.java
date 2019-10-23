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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.sambaash.platform.portlet.spinbox.helper.InboxUtil;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.service.base.IBMessageLocalServiceBaseImpl;

/**
 * The implementation of the i b message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.portlet.spinbox.srv.service.IBMessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.portlet.spinbox.srv.service.base.IBMessageLocalServiceBaseImpl
 * @see com.sambaash.platform.portlet.spinbox.srv.service.IBMessageLocalServiceUtil
 */
public class IBMessageLocalServiceImpl extends IBMessageLocalServiceBaseImpl {


	public IBMessage addMessage(String uuid, long parentMessageId,
			long groupId, long companyId, String subject, String content,
			Date createDate, String from, String to, String createBy,
			String createByUserId, boolean isAllowOpen, boolean isDraft,
			String draftStatus, boolean isSentMeCopy, boolean deleteStatus, long belongToGroupDetailId) throws PortalException,
			SystemException {

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
		message.setDeleteStatus(deleteStatus);
		message.setBelongToGroupDetailId(belongToGroupDetailId);

		ibMessagePersistence.update(message, false);

		return message;
	}

	public List<IBMessage> findByCreateUserId(User user, String createByUserId,
			boolean deleteStatus) throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreateUserId(createByUserId,
					deleteStatus);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreateUserId(User user, String createByUserId,
			boolean deleteStatus, int start, int end) throws SystemException {

		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreateUserId(createByUserId,
					deleteStatus, start, end);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreateUserId(User user, String createByUserId,
			boolean deleteStatus, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {

		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreateUserId(createByUserId,
					deleteStatus, start, end, orderByComparator);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreatorName(User user, String createBy,
			boolean deleteStatus) throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreatorName(createBy, deleteStatus);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreatorName(User user, String createBy,
			boolean deleteStatus, int start, int end) throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreatorName(createBy, deleteStatus,
					start, end);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreatorName(User user, String createBy,
			boolean deleteStatus, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreatorName(createBy, deleteStatus,
					start, end, orderByComparator);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreateUserIdAndDraft(User user,
			String createByUserId, boolean deleteStatus, boolean draft)
			throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreateUserIdAndDraft(createByUserId,
					deleteStatus, draft);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreateUserIdAndDraft(User user,
			String createByUserId, boolean deleteStatus,
			boolean draft, int start, int end) throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreateUserIdAndDraft(createByUserId,
					deleteStatus, draft, start, end);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreateUserIdAndDraft(User user,
			String createByUserId, boolean deleteStatus,
			boolean draft, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreateUserIdAndDraft(createByUserId,
					deleteStatus, draft, start, end, orderByComparator);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreatorNameAndDraft(User user, String createBy,
			boolean deleteStatus, boolean draft) throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreatorNameAndDraft(createBy,
					deleteStatus, draft);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreatorNameAndDraft(User user, String createBy,
			boolean deleteStatus, boolean draft, int start, int end)
			throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreatorNameAndDraft(createBy,
					deleteStatus, draft, start, end);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}

	public List<IBMessage> findByCreatorNameAndDraft(User user, String createBy,
			boolean deleteStatus, boolean draft, int start, int end,
			OrderByComparator orderByComparator)
			throws SystemException {
		if (InboxUtil.checkAccessForService(user, "/inbox/sent")) {
			return ibMessagePersistence.findByCreatorNameAndDraft(createBy,
					deleteStatus, draft, start, end, orderByComparator);
		}else{
			return new ArrayList<IBMessage>(0);
		}
	}


}