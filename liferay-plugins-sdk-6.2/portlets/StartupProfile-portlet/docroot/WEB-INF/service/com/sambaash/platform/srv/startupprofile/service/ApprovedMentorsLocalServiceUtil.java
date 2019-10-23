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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ApprovedMentors. This utility wraps
 * {@link com.sambaash.platform.srv.startupprofile.service.impl.ApprovedMentorsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see ApprovedMentorsLocalService
 * @see com.sambaash.platform.srv.startupprofile.service.base.ApprovedMentorsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.impl.ApprovedMentorsLocalServiceImpl
 * @generated
 */
public class ApprovedMentorsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.startupprofile.service.impl.ApprovedMentorsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the approved mentors to the database. Also notifies the appropriate model listeners.
	*
	* @param approvedMentors the approved mentors
	* @return the approved mentors that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors addApprovedMentors(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addApprovedMentors(approvedMentors);
	}

	/**
	* Creates a new approved mentors with the primary key. Does not add the approved mentors to the database.
	*
	* @param mentorId the primary key for the new approved mentors
	* @return the new approved mentors
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors createApprovedMentors(
		long mentorId) {
		return getService().createApprovedMentors(mentorId);
	}

	/**
	* Deletes the approved mentors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mentorId the primary key of the approved mentors
	* @return the approved mentors that was removed
	* @throws PortalException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors deleteApprovedMentors(
		long mentorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteApprovedMentors(mentorId);
	}

	/**
	* Deletes the approved mentors from the database. Also notifies the appropriate model listeners.
	*
	* @param approvedMentors the approved mentors
	* @return the approved mentors that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors deleteApprovedMentors(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteApprovedMentors(approvedMentors);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors fetchApprovedMentors(
		long mentorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchApprovedMentors(mentorId);
	}

	/**
	* Returns the approved mentors with the primary key.
	*
	* @param mentorId the primary key of the approved mentors
	* @return the approved mentors
	* @throws PortalException if a approved mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors getApprovedMentors(
		long mentorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getApprovedMentors(mentorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the approved mentorses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approved mentorses
	* @param end the upper bound of the range of approved mentorses (not inclusive)
	* @return the range of approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> getApprovedMentorses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getApprovedMentorses(start, end);
	}

	/**
	* Returns the number of approved mentorses.
	*
	* @return the number of approved mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int getApprovedMentorsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getApprovedMentorsesCount();
	}

	/**
	* Updates the approved mentors in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param approvedMentors the approved mentors
	* @return the approved mentors that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.startupprofile.model.ApprovedMentors updateApprovedMentors(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateApprovedMentors(approvedMentors);
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

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationId(
		long organizationId) {
		return getService().findByOrganizationId(organizationId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByUserId(
		java.lang.String userId) {
		return getService().findByUserId(userId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, java.lang.String userId) {
		return getService().findByOrganizationAndUserId(organizationId, userId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationId(
		long organizationId) {
		return getService().findApprovedMentorsByOrganizationId(organizationId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(
		long organizationId) {
		return getService()
				   .findApprovedMentorsByOrganizationIdWithOthers(organizationId);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(
		long organizationId, int status) {
		return getService()
				   .findApprovedMentorsByOrganizationIdAndStatus(organizationId,
			status);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByUserIdAndStatus(
		long userId, int status) {
		return getService().findApprovedMentorsByUserIdAndStatus(userId, status);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findApprovedMentorsByStatus(
		int status) {
		return getService().findApprovedMentorsByStatus(status);
	}

	public static java.util.List<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> findMentorsByOrganizationId(
		long organizationId) {
		return getService().findMentorsByOrganizationId(organizationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ApprovedMentorsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ApprovedMentorsLocalService.class.getName());

			if (invokableLocalService instanceof ApprovedMentorsLocalService) {
				_service = (ApprovedMentorsLocalService)invokableLocalService;
			}
			else {
				_service = new ApprovedMentorsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ApprovedMentorsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ApprovedMentorsLocalService service) {
	}

	private static ApprovedMentorsLocalService _service;
}