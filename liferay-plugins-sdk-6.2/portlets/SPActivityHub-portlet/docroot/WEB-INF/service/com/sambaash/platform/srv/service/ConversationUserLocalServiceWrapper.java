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
 * Provides a wrapper for {@link ConversationUserLocalService}.
 *
 * @author aishwarya
 * @see ConversationUserLocalService
 * @generated
 */
public class ConversationUserLocalServiceWrapper
	implements ConversationUserLocalService,
		ServiceWrapper<ConversationUserLocalService> {
	public ConversationUserLocalServiceWrapper(
		ConversationUserLocalService conversationUserLocalService) {
		_conversationUserLocalService = conversationUserLocalService;
	}

	/**
	* Adds the conversation user to the database. Also notifies the appropriate model listeners.
	*
	* @param conversationUser the conversation user
	* @return the conversation user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ConversationUser addConversationUser(
		com.sambaash.platform.srv.model.ConversationUser conversationUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.addConversationUser(conversationUser);
	}

	/**
	* Creates a new conversation user with the primary key. Does not add the conversation user to the database.
	*
	* @param spConversationUserId the primary key for the new conversation user
	* @return the new conversation user
	*/
	@Override
	public com.sambaash.platform.srv.model.ConversationUser createConversationUser(
		long spConversationUserId) {
		return _conversationUserLocalService.createConversationUser(spConversationUserId);
	}

	/**
	* Deletes the conversation user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spConversationUserId the primary key of the conversation user
	* @return the conversation user that was removed
	* @throws PortalException if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ConversationUser deleteConversationUser(
		long spConversationUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.deleteConversationUser(spConversationUserId);
	}

	/**
	* Deletes the conversation user from the database. Also notifies the appropriate model listeners.
	*
	* @param conversationUser the conversation user
	* @return the conversation user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ConversationUser deleteConversationUser(
		com.sambaash.platform.srv.model.ConversationUser conversationUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.deleteConversationUser(conversationUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _conversationUserLocalService.dynamicQuery();
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
		return _conversationUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _conversationUserLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _conversationUserLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _conversationUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _conversationUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.ConversationUser fetchConversationUser(
		long spConversationUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.fetchConversationUser(spConversationUserId);
	}

	/**
	* Returns the conversation user with the primary key.
	*
	* @param spConversationUserId the primary key of the conversation user
	* @return the conversation user
	* @throws PortalException if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ConversationUser getConversationUser(
		long spConversationUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.getConversationUser(spConversationUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the conversation users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @return the range of conversation users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> getConversationUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.getConversationUsers(start, end);
	}

	/**
	* Returns the number of conversation users.
	*
	* @return the number of conversation users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getConversationUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.getConversationUsersCount();
	}

	/**
	* Updates the conversation user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param conversationUser the conversation user
	* @return the conversation user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ConversationUser updateConversationUser(
		com.sambaash.platform.srv.model.ConversationUser conversationUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.updateConversationUser(conversationUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _conversationUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_conversationUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _conversationUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserId, int status, long entityClassId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.findBysentToUserIdStatusEntityClassIdEntityId(sentToUserId,
			status, entityClassId, entityId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findByspConversationId(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUserLocalService.findByspConversationId(spConversationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConversationUserLocalService getWrappedConversationUserLocalService() {
		return _conversationUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConversationUserLocalService(
		ConversationUserLocalService conversationUserLocalService) {
		_conversationUserLocalService = conversationUserLocalService;
	}

	@Override
	public ConversationUserLocalService getWrappedService() {
		return _conversationUserLocalService;
	}

	@Override
	public void setWrappedService(
		ConversationUserLocalService conversationUserLocalService) {
		_conversationUserLocalService = conversationUserLocalService;
	}

	private ConversationUserLocalService _conversationUserLocalService;
}