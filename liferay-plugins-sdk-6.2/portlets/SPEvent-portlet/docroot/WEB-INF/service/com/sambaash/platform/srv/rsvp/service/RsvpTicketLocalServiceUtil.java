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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RsvpTicket. This utility wraps
 * {@link com.sambaash.platform.srv.rsvp.service.impl.RsvpTicketLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see RsvpTicketLocalService
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpTicketLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.impl.RsvpTicketLocalServiceImpl
 * @generated
 */
public class RsvpTicketLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.rsvp.service.impl.RsvpTicketLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rsvp ticket to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicket the rsvp ticket
	* @return the rsvp ticket that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket addRsvpTicket(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRsvpTicket(rsvpTicket);
	}

	/**
	* Creates a new rsvp ticket with the primary key. Does not add the rsvp ticket to the database.
	*
	* @param rsvpTicketId the primary key for the new rsvp ticket
	* @return the new rsvp ticket
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket createRsvpTicket(
		long rsvpTicketId) {
		return getService().createRsvpTicket(rsvpTicketId);
	}

	/**
	* Deletes the rsvp ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicketId the primary key of the rsvp ticket
	* @return the rsvp ticket that was removed
	* @throws PortalException if a rsvp ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket deleteRsvpTicket(
		long rsvpTicketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRsvpTicket(rsvpTicketId);
	}

	/**
	* Deletes the rsvp ticket from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicket the rsvp ticket
	* @return the rsvp ticket that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket deleteRsvpTicket(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRsvpTicket(rsvpTicket);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket fetchRsvpTicket(
		long rsvpTicketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRsvpTicket(rsvpTicketId);
	}

	/**
	* Returns the rsvp ticket with the matching UUID and company.
	*
	* @param uuid the rsvp ticket's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket fetchRsvpTicketByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRsvpTicketByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rsvp ticket matching the UUID and group.
	*
	* @param uuid the rsvp ticket's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket fetchRsvpTicketByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRsvpTicketByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rsvp ticket with the primary key.
	*
	* @param rsvpTicketId the primary key of the rsvp ticket
	* @return the rsvp ticket
	* @throws PortalException if a rsvp ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket getRsvpTicket(
		long rsvpTicketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpTicket(rsvpTicketId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket getRsvpTicketByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpTicketByUuidAndCompanyId(uuid, companyId);
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
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket getRsvpTicketByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpTicketByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpTicket> getRsvpTickets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpTickets(start, end);
	}

	/**
	* Returns the number of rsvp tickets.
	*
	* @return the number of rsvp tickets
	* @throws SystemException if a system exception occurred
	*/
	public static int getRsvpTicketsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpTicketsCount();
	}

	/**
	* Updates the rsvp ticket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpTicket the rsvp ticket
	* @return the rsvp ticket that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpTicket updateRsvpTicket(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRsvpTicket(rsvpTicket);
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

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil} to
	* access the rsvp ticket local service.
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpTicket> findByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByrsvpId(rsvpId);
	}

	public static void clearService() {
		_service = null;
	}

	public static RsvpTicketLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RsvpTicketLocalService.class.getName());

			if (invokableLocalService instanceof RsvpTicketLocalService) {
				_service = (RsvpTicketLocalService)invokableLocalService;
			}
			else {
				_service = new RsvpTicketLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RsvpTicketLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RsvpTicketLocalService service) {
	}

	private static RsvpTicketLocalService _service;
}