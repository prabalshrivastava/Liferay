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
 * Provides a wrapper for {@link RsvpTicketLocalService}.
 *
 * @author gauravvijayvergia
 * @see RsvpTicketLocalService
 * @generated
 */
public class RsvpTicketLocalServiceWrapper implements RsvpTicketLocalService,
	ServiceWrapper<RsvpTicketLocalService> {
	public RsvpTicketLocalServiceWrapper(
		RsvpTicketLocalService rsvpTicketLocalService) {
		_rsvpTicketLocalService = rsvpTicketLocalService;
	}

	/**
	* Adds the rsvp ticket to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicket the rsvp ticket
	* @return the rsvp ticket that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket addRsvpTicket(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.addRsvpTicket(rsvpTicket);
	}

	/**
	* Creates a new rsvp ticket with the primary key. Does not add the rsvp ticket to the database.
	*
	* @param rsvpTicketId the primary key for the new rsvp ticket
	* @return the new rsvp ticket
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket createRsvpTicket(
		long rsvpTicketId) {
		return _rsvpTicketLocalService.createRsvpTicket(rsvpTicketId);
	}

	/**
	* Deletes the rsvp ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicketId the primary key of the rsvp ticket
	* @return the rsvp ticket that was removed
	* @throws PortalException if a rsvp ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket deleteRsvpTicket(
		long rsvpTicketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.deleteRsvpTicket(rsvpTicketId);
	}

	/**
	* Deletes the rsvp ticket from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicket the rsvp ticket
	* @return the rsvp ticket that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket deleteRsvpTicket(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.deleteRsvpTicket(rsvpTicket);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rsvpTicketLocalService.dynamicQuery();
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
		return _rsvpTicketLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpTicketLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpTicketLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _rsvpTicketLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rsvpTicketLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket fetchRsvpTicket(
		long rsvpTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.fetchRsvpTicket(rsvpTicketId);
	}

	/**
	* Returns the rsvp ticket with the matching UUID and company.
	*
	* @param uuid the rsvp ticket's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket fetchRsvpTicketByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.fetchRsvpTicketByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp ticket matching the UUID and group.
	*
	* @param uuid the rsvp ticket's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket fetchRsvpTicketByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.fetchRsvpTicketByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the rsvp ticket with the primary key.
	*
	* @param rsvpTicketId the primary key of the rsvp ticket
	* @return the rsvp ticket
	* @throws PortalException if a rsvp ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket getRsvpTicket(
		long rsvpTicketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.getRsvpTicket(rsvpTicketId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp ticket with the matching UUID and company.
	*
	* @param uuid the rsvp ticket's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp ticket
	* @throws PortalException if a matching rsvp ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket getRsvpTicketByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.getRsvpTicketByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp ticket matching the UUID and group.
	*
	* @param uuid the rsvp ticket's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp ticket
	* @throws PortalException if a matching rsvp ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket getRsvpTicketByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.getRsvpTicketByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the rsvp tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp tickets
	* @param end the upper bound of the range of rsvp tickets (not inclusive)
	* @return the range of rsvp tickets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpTicket> getRsvpTickets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.getRsvpTickets(start, end);
	}

	/**
	* Returns the number of rsvp tickets.
	*
	* @return the number of rsvp tickets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRsvpTicketsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.getRsvpTicketsCount();
	}

	/**
	* Updates the rsvp ticket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicket the rsvp ticket
	* @return the rsvp ticket that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket updateRsvpTicket(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.updateRsvpTicket(rsvpTicket);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rsvpTicketLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rsvpTicketLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rsvpTicketLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil} to
	* access the rsvp ticket local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpTicket> findByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicketLocalService.findByrsvpId(rsvpId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RsvpTicketLocalService getWrappedRsvpTicketLocalService() {
		return _rsvpTicketLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRsvpTicketLocalService(
		RsvpTicketLocalService rsvpTicketLocalService) {
		_rsvpTicketLocalService = rsvpTicketLocalService;
	}

	@Override
	public RsvpTicketLocalService getWrappedService() {
		return _rsvpTicketLocalService;
	}

	@Override
	public void setWrappedService(RsvpTicketLocalService rsvpTicketLocalService) {
		_rsvpTicketLocalService = rsvpTicketLocalService;
	}

	private RsvpTicketLocalService _rsvpTicketLocalService;
}