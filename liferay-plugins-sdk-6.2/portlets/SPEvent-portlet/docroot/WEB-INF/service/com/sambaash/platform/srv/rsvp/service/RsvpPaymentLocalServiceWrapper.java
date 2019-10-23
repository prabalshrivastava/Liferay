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

package com.sambaash.platform.srv.rsvp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RsvpPaymentLocalService}.
 *
 * @author gauravvijayvergia
 * @see RsvpPaymentLocalService
 * @generated
 */
public class RsvpPaymentLocalServiceWrapper implements RsvpPaymentLocalService,
	ServiceWrapper<RsvpPaymentLocalService> {
	public RsvpPaymentLocalServiceWrapper(
		RsvpPaymentLocalService rsvpPaymentLocalService) {
		_rsvpPaymentLocalService = rsvpPaymentLocalService;
	}

	/**
	* Adds the rsvp payment to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPayment the rsvp payment
	* @return the rsvp payment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment addRsvpPayment(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.addRsvpPayment(rsvpPayment);
	}

	/**
	* Creates a new rsvp payment with the primary key. Does not add the rsvp payment to the database.
	*
	* @param rsvpPaymentId the primary key for the new rsvp payment
	* @return the new rsvp payment
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment createRsvpPayment(
		long rsvpPaymentId) {
		return _rsvpPaymentLocalService.createRsvpPayment(rsvpPaymentId);
	}

	/**
	* Deletes the rsvp payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment that was removed
	* @throws PortalException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment deleteRsvpPayment(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.deleteRsvpPayment(rsvpPaymentId);
	}

	/**
	* Deletes the rsvp payment from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPayment the rsvp payment
	* @return the rsvp payment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment deleteRsvpPayment(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.deleteRsvpPayment(rsvpPayment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rsvpPaymentLocalService.dynamicQuery();
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
		return _rsvpPaymentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpPaymentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpPaymentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _rsvpPaymentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rsvpPaymentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchRsvpPayment(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.fetchRsvpPayment(rsvpPaymentId);
	}

	/**
	* Returns the rsvp payment with the matching UUID and company.
	*
	* @param uuid the rsvp payment's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchRsvpPaymentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.fetchRsvpPaymentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp payment matching the UUID and group.
	*
	* @param uuid the rsvp payment's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment fetchRsvpPaymentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.fetchRsvpPaymentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the rsvp payment with the primary key.
	*
	* @param rsvpPaymentId the primary key of the rsvp payment
	* @return the rsvp payment
	* @throws PortalException if a rsvp payment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment getRsvpPayment(
		long rsvpPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.getRsvpPayment(rsvpPaymentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp payment with the matching UUID and company.
	*
	* @param uuid the rsvp payment's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp payment
	* @throws PortalException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment getRsvpPaymentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.getRsvpPaymentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp payment matching the UUID and group.
	*
	* @param uuid the rsvp payment's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp payment
	* @throws PortalException if a matching rsvp payment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment getRsvpPaymentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.getRsvpPaymentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the rsvp payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp payments
	* @param end the upper bound of the range of rsvp payments (not inclusive)
	* @return the range of rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> getRsvpPayments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.getRsvpPayments(start, end);
	}

	/**
	* Returns the number of rsvp payments.
	*
	* @return the number of rsvp payments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRsvpPaymentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.getRsvpPaymentsCount();
	}

	/**
	* Updates the rsvp payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpPayment the rsvp payment
	* @return the rsvp payment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment updateRsvpPayment(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.updateRsvpPayment(rsvpPayment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rsvpPaymentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rsvpPaymentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rsvpPaymentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil} to access the rsvp payment local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailId(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.findByRsvpDetailId(rsvpDetailId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, java.lang.String transactionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPaymentLocalService.findByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment findByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException {
		return _rsvpPaymentLocalService.findByTicketNumber(ticketNumber);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RsvpPaymentLocalService getWrappedRsvpPaymentLocalService() {
		return _rsvpPaymentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRsvpPaymentLocalService(
		RsvpPaymentLocalService rsvpPaymentLocalService) {
		_rsvpPaymentLocalService = rsvpPaymentLocalService;
	}

	@Override
	public RsvpPaymentLocalService getWrappedService() {
		return _rsvpPaymentLocalService;
	}

	@Override
	public void setWrappedService(
		RsvpPaymentLocalService rsvpPaymentLocalService) {
		_rsvpPaymentLocalService = rsvpPaymentLocalService;
	}

	private RsvpPaymentLocalService _rsvpPaymentLocalService;
}