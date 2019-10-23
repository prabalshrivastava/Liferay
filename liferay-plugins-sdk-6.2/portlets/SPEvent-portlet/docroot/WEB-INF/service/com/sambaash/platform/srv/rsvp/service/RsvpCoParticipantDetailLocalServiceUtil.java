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
 * Provides the local service utility for RsvpCoParticipantDetail. This utility wraps
 * {@link com.sambaash.platform.srv.rsvp.service.impl.RsvpCoParticipantDetailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see RsvpCoParticipantDetailLocalService
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpCoParticipantDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.impl.RsvpCoParticipantDetailLocalServiceImpl
 * @generated
 */
public class RsvpCoParticipantDetailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.rsvp.service.impl.RsvpCoParticipantDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rsvp co participant detail to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpCoParticipantDetail the rsvp co participant detail
	* @return the rsvp co participant detail that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail addRsvpCoParticipantDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRsvpCoParticipantDetail(rsvpCoParticipantDetail);
	}

	/**
	* Creates a new rsvp co participant detail with the primary key. Does not add the rsvp co participant detail to the database.
	*
	* @param rsvpCoParticipantDetailId the primary key for the new rsvp co participant detail
	* @return the new rsvp co participant detail
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail createRsvpCoParticipantDetail(
		long rsvpCoParticipantDetailId) {
		return getService()
				   .createRsvpCoParticipantDetail(rsvpCoParticipantDetailId);
	}

	/**
	* Deletes the rsvp co participant detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	* @return the rsvp co participant detail that was removed
	* @throws PortalException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail deleteRsvpCoParticipantDetail(
		long rsvpCoParticipantDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRsvpCoParticipantDetail(rsvpCoParticipantDetailId);
	}

	/**
	* Deletes the rsvp co participant detail from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpCoParticipantDetail the rsvp co participant detail
	* @return the rsvp co participant detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail deleteRsvpCoParticipantDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRsvpCoParticipantDetail(rsvpCoParticipantDetail);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchRsvpCoParticipantDetail(
		long rsvpCoParticipantDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchRsvpCoParticipantDetail(rsvpCoParticipantDetailId);
	}

	/**
	* Returns the rsvp co participant detail with the matching UUID and company.
	*
	* @param uuid the rsvp co participant detail's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchRsvpCoParticipantDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchRsvpCoParticipantDetailByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp co participant detail matching the UUID and group.
	*
	* @param uuid the rsvp co participant detail's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail fetchRsvpCoParticipantDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchRsvpCoParticipantDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rsvp co participant detail with the primary key.
	*
	* @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	* @return the rsvp co participant detail
	* @throws PortalException if a rsvp co participant detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail getRsvpCoParticipantDetail(
		long rsvpCoParticipantDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpCoParticipantDetail(rsvpCoParticipantDetailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp co participant detail with the matching UUID and company.
	*
	* @param uuid the rsvp co participant detail's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp co participant detail
	* @throws PortalException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail getRsvpCoParticipantDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRsvpCoParticipantDetailByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rsvp co participant detail matching the UUID and group.
	*
	* @param uuid the rsvp co participant detail's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp co participant detail
	* @throws PortalException if a matching rsvp co participant detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail getRsvpCoParticipantDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRsvpCoParticipantDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rsvp co participant details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp co participant details
	* @param end the upper bound of the range of rsvp co participant details (not inclusive)
	* @return the range of rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> getRsvpCoParticipantDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpCoParticipantDetails(start, end);
	}

	/**
	* Returns the number of rsvp co participant details.
	*
	* @return the number of rsvp co participant details
	* @throws SystemException if a system exception occurred
	*/
	public static int getRsvpCoParticipantDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpCoParticipantDetailsCount();
	}

	/**
	* Updates the rsvp co participant detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpCoParticipantDetail the rsvp co participant detail
	* @return the rsvp co participant detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail updateRsvpCoParticipantDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRsvpCoParticipantDetail(rsvpCoParticipantDetail);
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
	* com.sambaash.platform
	* .srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil} to access the
	* rsvp co participant detail local service.
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailId(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getService().findByRsvpDetailId(rsvpDetailId);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long spRsvpPaymentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpException {
		return getService()
				   .findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
			spRsvpPaymentId);
	}

	public static com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail findByTicketNumber(
		java.lang.String ticketNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException {
		return getService().findByTicketNumber(ticketNumber);
	}

	public static void clearService() {
		_service = null;
	}

	public static RsvpCoParticipantDetailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RsvpCoParticipantDetailLocalService.class.getName());

			if (invokableLocalService instanceof RsvpCoParticipantDetailLocalService) {
				_service = (RsvpCoParticipantDetailLocalService)invokableLocalService;
			}
			else {
				_service = new RsvpCoParticipantDetailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RsvpCoParticipantDetailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RsvpCoParticipantDetailLocalService service) {
	}

	private static RsvpCoParticipantDetailLocalService _service;
}