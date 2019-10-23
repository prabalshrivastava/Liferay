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

package com.sambaash.platform.srv.spinbox.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for IBMessage. This utility wraps
 * {@link com.sambaash.platform.srv.spinbox.service.impl.IBMessageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see IBMessageLocalService
 * @see com.sambaash.platform.srv.spinbox.service.base.IBMessageLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spinbox.service.impl.IBMessageLocalServiceImpl
 * @generated
 */
public class IBMessageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spinbox.service.impl.IBMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the i b message to the database. Also notifies the appropriate model listeners.
	*
	* @param ibMessage the i b message
	* @return the i b message that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage addIBMessage(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addIBMessage(ibMessage);
	}

	/**
	* Creates a new i b message with the primary key. Does not add the i b message to the database.
	*
	* @param messageId the primary key for the new i b message
	* @return the new i b message
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage createIBMessage(
		long messageId) {
		return getService().createIBMessage(messageId);
	}

	/**
	* Deletes the i b message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message that was removed
	* @throws PortalException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage deleteIBMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteIBMessage(messageId);
	}

	/**
	* Deletes the i b message from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMessage the i b message
	* @return the i b message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage deleteIBMessage(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteIBMessage(ibMessage);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchIBMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchIBMessage(messageId);
	}

	/**
	* Returns the i b message with the matching UUID and company.
	*
	* @param uuid the i b message's UUID
	* @param companyId the primary key of the company
	* @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchIBMessageByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchIBMessageByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the i b message matching the UUID and group.
	*
	* @param uuid the i b message's UUID
	* @param groupId the primary key of the group
	* @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage fetchIBMessageByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchIBMessageByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the i b message with the primary key.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message
	* @throws PortalException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage getIBMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessage(messageId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the i b message with the matching UUID and company.
	*
	* @param uuid the i b message's UUID
	* @param companyId the primary key of the company
	* @return the matching i b message
	* @throws PortalException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage getIBMessageByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessageByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the i b message matching the UUID and group.
	*
	* @param uuid the i b message's UUID
	* @param groupId the primary key of the group
	* @return the matching i b message
	* @throws PortalException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage getIBMessageByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessageByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the i b messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> getIBMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessages(start, end);
	}

	/**
	* Returns the number of i b messages.
	*
	* @return the number of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public static int getIBMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessagesCount();
	}

	/**
	* Updates the i b message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ibMessage the i b message
	* @return the i b message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessage updateIBMessage(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateIBMessage(ibMessage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.sambaash.platform.srv.spinbox.model.IBMessage addMessage(
		java.lang.String uuid, long parentMessageId, long groupId,
		long companyId, java.lang.String subject, java.lang.String content,
		java.util.Date createDate, java.lang.String from, java.lang.String to,
		java.lang.String createBy, java.lang.String createByUserId,
		boolean isAllowOpen, boolean isDraft, java.lang.String draftStatus,
		boolean isSentMeCopy, boolean deleteStatus, long belongToGroupDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMessage(uuid, parentMessageId, groupId, companyId,
			subject, content, createDate, from, to, createBy, createByUserId,
			isAllowOpen, isDraft, draftStatus, isSentMeCopy, deleteStatus,
			belongToGroupDetailId);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		com.liferay.portal.model.User user, java.lang.String createByUserId,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreateUserId(user, createByUserId, deleteStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		com.liferay.portal.model.User user, java.lang.String createByUserId,
		boolean deleteStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreateUserId(user, createByUserId, deleteStatus,
			start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		com.liferay.portal.model.User user, java.lang.String createByUserId,
		boolean deleteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreateUserId(user, createByUserId, deleteStatus,
			start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		com.liferay.portal.model.User user, java.lang.String createBy,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCreatorName(user, createBy, deleteStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		com.liferay.portal.model.User user, java.lang.String createBy,
		boolean deleteStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreatorName(user, createBy, deleteStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		com.liferay.portal.model.User user, java.lang.String createBy,
		boolean deleteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreatorName(user, createBy, deleteStatus, start, end,
			orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		com.liferay.portal.model.User user, java.lang.String createByUserId,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreateUserIdAndDraft(user, createByUserId,
			deleteStatus, draft);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		com.liferay.portal.model.User user, java.lang.String createByUserId,
		boolean deleteStatus, boolean draft, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreateUserIdAndDraft(user, createByUserId,
			deleteStatus, draft, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		com.liferay.portal.model.User user, java.lang.String createByUserId,
		boolean deleteStatus, boolean draft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreateUserIdAndDraft(user, createByUserId,
			deleteStatus, draft, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		com.liferay.portal.model.User user, java.lang.String createBy,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreatorNameAndDraft(user, createBy, deleteStatus,
			draft);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		com.liferay.portal.model.User user, java.lang.String createBy,
		boolean deleteStatus, boolean draft, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreatorNameAndDraft(user, createBy, deleteStatus,
			draft, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		com.liferay.portal.model.User user, java.lang.String createBy,
		boolean deleteStatus, boolean draft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCreatorNameAndDraft(user, createBy, deleteStatus,
			draft, start, end, orderByComparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static IBMessageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					IBMessageLocalService.class.getName());

			if (invokableLocalService instanceof IBMessageLocalService) {
				_service = (IBMessageLocalService)invokableLocalService;
			}
			else {
				_service = new IBMessageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(IBMessageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(IBMessageLocalService service) {
	}

	private static IBMessageLocalService _service;
}