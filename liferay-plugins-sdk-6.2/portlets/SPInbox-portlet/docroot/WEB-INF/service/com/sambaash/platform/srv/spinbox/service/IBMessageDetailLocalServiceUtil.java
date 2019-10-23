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
 * Provides the local service utility for IBMessageDetail. This utility wraps
 * {@link com.sambaash.platform.srv.spinbox.service.impl.IBMessageDetailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see IBMessageDetailLocalService
 * @see com.sambaash.platform.srv.spinbox.service.base.IBMessageDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spinbox.service.impl.IBMessageDetailLocalServiceImpl
 * @generated
 */
public class IBMessageDetailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spinbox.service.impl.IBMessageDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the i b message detail to the database. Also notifies the appropriate model listeners.
	*
	* @param ibMessageDetail the i b message detail
	* @return the i b message detail that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail addIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addIBMessageDetail(ibMessageDetail);
	}

	/**
	* Creates a new i b message detail with the primary key. Does not add the i b message detail to the database.
	*
	* @param ibMsgDetailId the primary key for the new i b message detail
	* @return the new i b message detail
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail createIBMessageDetail(
		long ibMsgDetailId) {
		return getService().createIBMessageDetail(ibMsgDetailId);
	}

	/**
	* Deletes the i b message detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail that was removed
	* @throws PortalException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail deleteIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteIBMessageDetail(ibMsgDetailId);
	}

	/**
	* Deletes the i b message detail from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMessageDetail the i b message detail
	* @return the i b message detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail deleteIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteIBMessageDetail(ibMessageDetail);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchIBMessageDetail(ibMsgDetailId);
	}

	/**
	* Returns the i b message detail with the primary key.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail
	* @throws PortalException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail getIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessageDetail(ibMsgDetailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the i b message details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getIBMessageDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessageDetails(start, end);
	}

	/**
	* Returns the number of i b message details.
	*
	* @return the number of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int getIBMessageDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIBMessageDetailsCount();
	}

	/**
	* Updates the i b message detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ibMessageDetail the i b message detail
	* @return the i b message detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail updateIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateIBMessageDetail(ibMessageDetail);
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

	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail addMessageDetail(
		long messageId, long receiverId, java.lang.String receiveBy,
		java.util.Date receiveDate, java.lang.String category,
		boolean archived, java.util.Date updateDate, java.lang.String updateBy,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		java.lang.String status, long processId, long corpProfileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMessageDetail(messageId, receiverId, receiveBy,
			receiveDate, category, archived, updateDate, updateBy,
			receiverMsgStatus, senderMsgStatus, status, processId, corpProfileId);
	}

	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceiverIdmessageId(
		long receiverId, long msgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByReceiverIdmessageId(receiverId, msgId);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByReceId(receiverId, archived);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByReceId(receiverId, archived, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceId(receiverId, archived, start, end,
			orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndRms(receiverId, archived, receiverMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndRms(receiverId, archived, receiverMsgStatus,
			start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndRms(receiverId, archived, receiverMsgStatus,
			start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndSms(receiverId, archived, senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndSms(receiverId, archived, senderMsgStatus,
			start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndSms(receiverId, archived, senderMsgStatus,
			start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByReceIdAndCty(receiverId, archived, category);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndCty(receiverId, archived, category, start,
			end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdAndCty(receiverId, archived, category, start,
			end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCorpId(corpProfileId, archived);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCorpId(corpProfileId, archived, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpId(corpProfileId, archived, start, end,
			orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndSms(corpProfileId, archived, senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndSms(corpProfileId, archived,
			senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndSms(corpProfileId, archived,
			senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCorpIdAndCty(corpProfileId, archived, category);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndCty(corpProfileId, archived, category,
			start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdAndCty(corpProfileId, archived, category,
			start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByReceiveId(
		com.liferay.portal.model.User user, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		java.lang.String comparator, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAvailableMDListByReceiveId(user, receiverId, archived,
			category, receiverMsgStatus, senderMsgStatus, start, end,
			comparator, scopeGroupId);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByReceiveId(
		com.liferay.portal.model.User user, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAvailableMDListByReceiveId(user, receiverId, archived,
			category, receiverMsgStatus, senderMsgStatus, start, end,
			orderByComparator, scopeGroupId);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByCorpProfileId(
		com.liferay.portal.model.User user, long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAvailableMDListByCorpProfileId(user, corpProfileId,
			archived, category, receiverMsgStatus, senderMsgStatus, start, end,
			orderByComparator, scopeGroupId);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMessageId(messageId);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMessageId(messageId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByMessageId(messageId, start, end, orderByComparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static IBMessageDetailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					IBMessageDetailLocalService.class.getName());

			if (invokableLocalService instanceof IBMessageDetailLocalService) {
				_service = (IBMessageDetailLocalService)invokableLocalService;
			}
			else {
				_service = new IBMessageDetailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(IBMessageDetailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(IBMessageDetailLocalService service) {
	}

	private static IBMessageDetailLocalService _service;
}