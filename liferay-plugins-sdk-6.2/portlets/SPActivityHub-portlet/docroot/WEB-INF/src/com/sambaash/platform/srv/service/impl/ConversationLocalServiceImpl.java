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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.sambaash.platform.srv.model.Conversation;
import com.sambaash.platform.srv.service.base.ConversationLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.ConversationUtil;

/**
 * The implementation of the conversation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ConversationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author aishwarya
 * @see com.sambaash.platform.srv.service.base.ConversationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ConversationLocalServiceUtil
 */
public class ConversationLocalServiceImpl
	extends ConversationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ConversationLocalServiceUtil} to access the conversation local service.
	 */
	
	public Conversation fetchByentityClassIdEntityIdParentConverstationId(long entityClassId, long entityId, long parentConverstationId) throws SystemException {
		Conversation conversation = null;
		conversation = ConversationUtil.fetchByentityClassIdEntityIdParentConverstationId(entityClassId, entityId, parentConverstationId);
		return conversation;
	}
	
	public List<Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(long associatedWith, int restricted, long entityId, long entityClassId, int status) throws SystemException {
		List<Conversation> conversationList = null;
		OrderByComparator comparator = OrderByComparatorFactoryUtil.create("SPConversation", "createDate", false);
		conversationList = ConversationUtil.findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith, restricted, entityId, entityClassId, status, -1, -1, comparator);
		return conversationList;
	}
	
	
	public List<Conversation> findByentityClassIdEntityIdStatus(long entityClassId, long entityId, int status) throws SystemException {
		List<Conversation> conversationList = null;
		OrderByComparator comparator = OrderByComparatorFactoryUtil.create("SPConversation", "createDate", false);
		conversationList = ConversationUtil.findByentityClassIdEntityIdStatus(entityClassId, entityId, status, -1, -1, comparator);
		return conversationList;
	}
	
	public Conversation updateConversation(Conversation spConversation) throws SystemException{
		Conversation conversation = null;
		try {
			conversation = conversationPersistence.update(spConversation);
			Indexer indexer = IndexerRegistryUtil.getIndexer(Conversation.class);
			indexer.reindex(conversation);
		} catch (SearchException e) {
			_log.error(e);
		}
		return conversation;
	}
	
	private static Log _log = LogFactoryUtil.getLog(ConversationLocalServiceImpl.class);
}