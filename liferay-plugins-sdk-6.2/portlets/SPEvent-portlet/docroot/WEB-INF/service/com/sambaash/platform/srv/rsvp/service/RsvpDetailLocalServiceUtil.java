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
 * Provides the local service utility for RsvpDetail. This utility wraps
 * {@link com.sambaash.platform.srv.rsvp.service.impl.RsvpDetailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see RsvpDetailLocalService
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.impl.RsvpDetailLocalServiceImpl
 * @generated
 */
public class RsvpDetailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.rsvp.service.impl.RsvpDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rsvp detail to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetail the rsvp detail
	* @return the rsvp detail that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail addRsvpDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRsvpDetail(rsvpDetail);
	}

	/**
	* Creates a new rsvp detail with the primary key. Does not add the rsvp detail to the database.
	*
	* @param rsvpDetailId the primary key for the new rsvp detail
	* @return the new rsvp detail
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail createRsvpDetail(
		long rsvpDetailId) {
		return getService().createRsvpDetail(rsvpDetailId);
	}

	/**
	* Deletes the rsvp detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail that was removed
	* @throws PortalException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail deleteRsvpDetail(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRsvpDetail(rsvpDetailId);
	}

	/**
	* Deletes the rsvp detail from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetail the rsvp detail
	* @return the rsvp detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail deleteRsvpDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRsvpDetail(rsvpDetail);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchRsvpDetail(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRsvpDetail(rsvpDetailId);
	}

	/**
	* Returns the rsvp detail with the matching UUID and company.
	*
	* @param uuid the rsvp detail's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchRsvpDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRsvpDetailByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rsvp detail matching the UUID and group.
	*
	* @param uuid the rsvp detail's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchRsvpDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRsvpDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rsvp detail with the primary key.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail
	* @throws PortalException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail getRsvpDetail(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpDetail(rsvpDetailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp detail with the matching UUID and company.
	*
	* @param uuid the rsvp detail's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp detail
	* @throws PortalException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail getRsvpDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpDetailByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rsvp detail matching the UUID and group.
	*
	* @param uuid the rsvp detail's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp detail
	* @throws PortalException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail getRsvpDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rsvp details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> getRsvpDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpDetails(start, end);
	}

	/**
	* Returns the number of rsvp details.
	*
	* @return the number of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	public static int getRsvpDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRsvpDetailsCount();
	}

	/**
	* Updates the rsvp detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetail the rsvp detail
	* @return the rsvp detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.rsvp.model.RsvpDetail updateRsvpDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRsvpDetail(rsvpDetail);
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
	* @param rsvpId
	* @param start
	* @param end
	* @return List<Object<[]Object>>
	BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	String firstName = (String) objectArray[1];
	String lastName = (String) objectArray[2];
	String emailAddress = (String) objectArray[3];
	int attendance = (Integer) objectArray[4];
	int numberOfPeople = (Integer) objectArray[5];
	String transactionId = (String) objectArray[6];
	double amount = (Double) objectArray[7];
	Date transactionDate = (Date) objectArray[8];
	String userInfo = (String) objectArray[9];
	BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	* @throws SystemException
	*/
	public static java.util.List<java.lang.Object> findByCustomSqlAndRsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCustomSqlAndRsvpId(rsvpId, start, end);
	}

	/**
	* @param rsvpId
	* @param emailAddress
	* @param start
	* @param end
	* @return List<Object<[]Object>>
	BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	String firstName = (String) objectArray[1];
	String lastName = (String) objectArray[2];
	String emailAddress = (String) objectArray[3];
	int attendance = (Integer) objectArray[4];
	int numberOfPeople = (Integer) objectArray[5];
	String transactionId = (String) objectArray[6];
	double amount = (Double) objectArray[7];
	Date transactionDate = (Date) objectArray[8];
	String userInfo = (String) objectArray[9];
	BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	* @throws SystemException
	*/
	public static java.util.List<java.lang.Object> findByCustomSqlRsvpIdAndEMailAddress(
		long rsvpId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCustomSqlRsvpIdAndEMailAddress(rsvpId, emailAddress,
			start, end);
	}

	/**
	* @param rsvpId
	* @param firstName
	* @param lastName
	* @param start
	* @param end
	* @return List<Object<[]Object>>
	BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	String firstName = (String) objectArray[1];
	String lastName = (String) objectArray[2];
	String emailAddress = (String) objectArray[3];
	int attendance = (Integer) objectArray[4];
	int numberOfPeople = (Integer) objectArray[5];
	String transactionId = (String) objectArray[6];
	double amount = (Double) objectArray[7];
	Date transactionDate = (Date) objectArray[8];
	String userInfo = (String) objectArray[9];
	BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	* @throws SystemException
	*/
	public static java.util.List<java.lang.Object> findByCustomSqlRsvpIdAndName(
		long rsvpId, java.lang.String firstName, java.lang.String lastName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCustomSqlRsvpIdAndName(rsvpId, firstName, lastName,
			start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByemailAddress(emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getService().findByemailAddressAndRsvpId(rsvpId, emailAddress);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getService().findBynameAndRsvpId(firstName, rsvpId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil} to access the rsvp detail local service.
	*/
	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getService().findByRsvpId(rsvpId);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return getService().findByRsvpId(rsvpId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByrsvpIdAndAttendance(rsvpId, attendance);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByrsvpIdAndAttendance(rsvpId, attendance, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByrsvpIdAndSource(rsvpId, source);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static RsvpDetailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RsvpDetailLocalService.class.getName());

			if (invokableLocalService instanceof RsvpDetailLocalService) {
				_service = (RsvpDetailLocalService)invokableLocalService;
			}
			else {
				_service = new RsvpDetailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RsvpDetailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RsvpDetailLocalService service) {
	}

	private static RsvpDetailLocalService _service;
}