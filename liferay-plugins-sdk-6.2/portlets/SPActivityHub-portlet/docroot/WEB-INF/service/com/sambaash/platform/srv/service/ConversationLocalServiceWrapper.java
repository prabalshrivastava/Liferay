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

package com.sambaash.platform.srv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConversationLocalService}.
 *
 * @author aishwarya
 * @see ConversationLocalService
 * @generated
 */
public class ConversationLocalServiceWrapper implements ConversationLocalService,
	ServiceWrapper<ConversationLocalService> {
	public ConversationLocalServiceWrapper(
		ConversationLocalService conversationLocalService) {
		_conversationLocalService = conversationLocalService;
	}

	/**
	* Adds the conversation to the database. Also notifies the appropriate model listeners.
	*
	* @param conversation the conversation
	* @return the conversation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation addConversation(
		com.sambaash.platform.srv.model.Conversation conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.addConversation(conversation);
	}

	/**
	* Creates a new conversation with the primary key. Does not add the conversation to the database.
	*
	* @param spConversationId the primary key for the new conversation
	* @return the new conversation
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation createConversation(
		long spConversationId) {
		return _conversationLocalService.createConversation(spConversationId);
	}

	/**
	* Deletes the conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation that was removed
	* @throws PortalException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation deleteConversation(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.deleteConversation(spConversationId);
	}

	/**
	* Deletes the conversation from the database. Also notifies the appropriate model listeners.
	*
	* @param conversation the conversation
	* @return the conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation deleteConversation(
		com.sambaash.platform.srv.model.Conversation conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.deleteConversation(conversation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _conversationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.Conversation fetchConversation(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.fetchConversation(spConversationId);
	}

	/**
	* Returns the conversation with the matching UUID and company.
	*
	* @param uuid the conversation's UUID
	* @param companyId the primary key of the company
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation fetchConversationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.fetchConversationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the conversation matching the UUID and group.
	*
	* @param uuid the conversation's UUID
	* @param groupId the primary key of the group
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation fetchConversationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.fetchConversationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the conversation with the primary key.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation
	* @throws PortalException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation getConversation(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.getConversation(spConversationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the conversation with the matching UUID and company.
	*
	* @param uuid the conversation's UUID
	* @param companyId the primary key of the company
	* @return the matching conversation
	* @throws PortalException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation getConversationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.getConversationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the conversation matching the UUID and group.
	*
	* @param uuid the conversation's UUID
	* @param groupId the primary key of the group
	* @return the matching conversation
	* @throws PortalException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation getConversationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.getConversationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the conversations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @return the range of conversations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.Conversation> getConversations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.getConversations(start, end);
	}

	/**
	* Returns the number of conversations.
	*
	* @return the number of conversations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getConversationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.getConversationsCount();
	}

	/**
	* Updates the conversation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param conversation the conversation
	* @return the conversation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Conversation updateConversation(
		com.sambaash.platform.srv.model.Conversation conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.updateConversation(conversation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _conversationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_conversationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _conversationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.fetchByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationLocalService.findByentityClassIdEntityIdStatus(entityClassId,
			entityId, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConversationLocalService getWrappedConversationLocalService() {
		return _conversationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConversationLocalService(
		ConversationLocalService conversationLocalService) {
		_conversationLocalService = conversationLocalService;
	}

	@Override
	public ConversationLocalService getWrappedService() {
		return _conversationLocalService;
	}

	@Override
	public void setWrappedService(
		ConversationLocalService conversationLocalService) {
		_conversationLocalService = conversationLocalService;
	}

	private ConversationLocalService _conversationLocalService;
}