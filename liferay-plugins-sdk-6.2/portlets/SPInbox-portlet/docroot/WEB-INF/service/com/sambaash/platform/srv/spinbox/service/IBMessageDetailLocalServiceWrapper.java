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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IBMessageDetailLocalService}.
 *
 * @author nareshchebolu
 * @see IBMessageDetailLocalService
 * @generated
 */
public class IBMessageDetailLocalServiceWrapper
	implements IBMessageDetailLocalService,
		ServiceWrapper<IBMessageDetailLocalService> {
	public IBMessageDetailLocalServiceWrapper(
		IBMessageDetailLocalService ibMessageDetailLocalService) {
		_ibMessageDetailLocalService = ibMessageDetailLocalService;
	}

	/**
	* Adds the i b message detail to the database. Also notifies the appropriate model listeners.
	*
	* @param ibMessageDetail the i b message detail
	* @return the i b message detail that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail addIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.addIBMessageDetail(ibMessageDetail);
	}

	/**
	* Creates a new i b message detail with the primary key. Does not add the i b message detail to the database.
	*
	* @param ibMsgDetailId the primary key for the new i b message detail
	* @return the new i b message detail
	*/
	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail createIBMessageDetail(
		long ibMsgDetailId) {
		return _ibMessageDetailLocalService.createIBMessageDetail(ibMsgDetailId);
	}

	/**
	* Deletes the i b message detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail that was removed
	* @throws PortalException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail deleteIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.deleteIBMessageDetail(ibMsgDetailId);
	}

	/**
	* Deletes the i b message detail from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMessageDetail the i b message detail
	* @return the i b message detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail deleteIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.deleteIBMessageDetail(ibMessageDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ibMessageDetailLocalService.dynamicQuery();
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
		return _ibMessageDetailLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.dynamicQuery(dynamicQuery, start,
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
		return _ibMessageDetailLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ibMessageDetailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.fetchIBMessageDetail(ibMsgDetailId);
	}

	/**
	* Returns the i b message detail with the primary key.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail
	* @throws PortalException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail getIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getIBMessageDetail(ibMsgDetailId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getIBMessageDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getIBMessageDetails(start, end);
	}

	/**
	* Returns the number of i b message details.
	*
	* @return the number of i b message details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getIBMessageDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getIBMessageDetailsCount();
	}

	/**
	* Updates the i b message detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ibMessageDetail the i b message detail
	* @return the i b message detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail updateIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.updateIBMessageDetail(ibMessageDetail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ibMessageDetailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ibMessageDetailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ibMessageDetailLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail addMessageDetail(
		long messageId, long receiverId, java.lang.String receiveBy,
		java.util.Date receiveDate, java.lang.String category,
		boolean archived, java.util.Date updateDate, java.lang.String updateBy,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		java.lang.String status, long processId, long corpProfileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.addMessageDetail(messageId,
			receiverId, receiveBy, receiveDate, category, archived, updateDate,
			updateBy, receiverMsgStatus, senderMsgStatus, status, processId,
			corpProfileId);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceiverIdmessageId(
		long receiverId, long msgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceiverIdmessageId(receiverId,
			msgId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceId(receiverId, archived);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceId(receiverId, archived,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceId(receiverId, archived,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndRms(receiverId,
			archived, receiverMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndRms(receiverId,
			archived, receiverMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndRms(receiverId,
			archived, receiverMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndSms(receiverId,
			archived, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndSms(receiverId,
			archived, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndSms(receiverId,
			archived, senderMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdRmsAndSms(receiverId,
			archived, receiverMsgStatus, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdRmsAndSms(receiverId,
			archived, receiverMsgStatus, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdRmsAndSms(receiverId,
			archived, receiverMsgStatus, senderMsgStatus, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndCty(receiverId,
			archived, category);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndCty(receiverId,
			archived, category, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdAndCty(receiverId,
			archived, category, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyAndRms(receiverId,
			archived, category, receiverMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyAndRms(receiverId,
			archived, category, receiverMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyAndRms(receiverId,
			archived, category, receiverMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyAndSms(receiverId,
			archived, category, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyAndSms(receiverId,
			archived, category, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyAndSms(receiverId,
			archived, category, senderMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyRmsAndSms(receiverId,
			archived, category, receiverMsgStatus, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyRmsAndSms(receiverId,
			archived, category, receiverMsgStatus, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByReceIdCtyRmsAndSms(receiverId,
			archived, category, receiverMsgStatus, senderMsgStatus, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpId(corpProfileId, archived);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpId(corpProfileId,
			archived, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpId(corpProfileId,
			archived, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndRms(corpProfileId,
			archived, receiverMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndRms(corpProfileId,
			archived, receiverMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndRms(corpProfileId,
			archived, receiverMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndSms(corpProfileId,
			archived, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndSms(corpProfileId,
			archived, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndSms(corpProfileId,
			archived, senderMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdRmsAndSms(corpProfileId,
			archived, receiverMsgStatus, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdRmsAndSms(corpProfileId,
			archived, receiverMsgStatus, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdRmsAndSms(corpProfileId,
			archived, receiverMsgStatus, senderMsgStatus, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndCty(corpProfileId,
			archived, category);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndCty(corpProfileId,
			archived, category, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdAndCty(corpProfileId,
			archived, category, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyAndRms(corpProfileId,
			archived, category, receiverMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyAndRms(corpProfileId,
			archived, category, receiverMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyAndRms(corpProfileId,
			archived, category, receiverMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyAndSms(corpProfileId,
			archived, category, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyAndSms(corpProfileId,
			archived, category, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyAndSms(corpProfileId,
			archived, category, senderMsgStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyRmsAndSms(corpProfileId,
			archived, category, receiverMsgStatus, senderMsgStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyRmsAndSms(corpProfileId,
			archived, category, receiverMsgStatus, senderMsgStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByCorpIdCtyRmsAndSms(corpProfileId,
			archived, category, receiverMsgStatus, senderMsgStatus, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByReceiveId(
		com.liferay.portal.model.User user, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		java.lang.String comparator, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getAvailableMDListByReceiveId(user,
			receiverId, archived, category, receiverMsgStatus, senderMsgStatus,
			start, end, comparator, scopeGroupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByReceiveId(
		com.liferay.portal.model.User user, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getAvailableMDListByReceiveId(user,
			receiverId, archived, category, receiverMsgStatus, senderMsgStatus,
			start, end, orderByComparator, scopeGroupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByCorpProfileId(
		com.liferay.portal.model.User user, long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.getAvailableMDListByCorpProfileId(user,
			corpProfileId, archived, category, receiverMsgStatus,
			senderMsgStatus, start, end, orderByComparator, scopeGroupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByMessageId(messageId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByMessageId(messageId, start,
			end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailLocalService.findByMessageId(messageId, start,
			end, orderByComparator);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IBMessageDetailLocalService getWrappedIBMessageDetailLocalService() {
		return _ibMessageDetailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIBMessageDetailLocalService(
		IBMessageDetailLocalService ibMessageDetailLocalService) {
		_ibMessageDetailLocalService = ibMessageDetailLocalService;
	}

	@Override
	public IBMessageDetailLocalService getWrappedService() {
		return _ibMessageDetailLocalService;
	}

	@Override
	public void setWrappedService(
		IBMessageDetailLocalService ibMessageDetailLocalService) {
		_ibMessageDetailLocalService = ibMessageDetailLocalService;
	}

	private IBMessageDetailLocalService _ibMessageDetailLocalService;
}