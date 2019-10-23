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

package com.sambaash.platform.srv.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.sambaash.platform.srv.model.ConversationUser;
import com.sambaash.platform.srv.service.base.ConversationUserLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.ConversationUserUtil;

/**
 * The implementation of the conversation user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ConversationUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author aishwarya
 * @see com.sambaash.platform.srv.service.base.ConversationUserLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ConversationUserLocalServiceUtil
 */
public class ConversationUserLocalServiceImpl
	extends ConversationUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ConversationUserLocalServiceUtil} to access the conversation user local service.
	 */
	
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(long[] sentToUserId, int status, long entityClassId, long entityId) throws SystemException {
		List<ConversationUser> conversationUserList = null;
		OrderByComparator comparator = OrderByComparatorFactoryUtil.create("SPConversationUser", "spConversationId", false);
		conversationUserList = ConversationUserUtil.findBysentToUserIdStatusEntityClassIdEntityId(sentToUserId, status, entityClassId, entityId, -1, -1, comparator);
		return conversationUserList;
	}

	public List<ConversationUser> findByspConversationId(long spConversationId) throws SystemException {
		List<ConversationUser> conversationUserList = null;
		conversationUserList = ConversationUserUtil.findByspConversationId(spConversationId);
		return conversationUserList;
	}

}