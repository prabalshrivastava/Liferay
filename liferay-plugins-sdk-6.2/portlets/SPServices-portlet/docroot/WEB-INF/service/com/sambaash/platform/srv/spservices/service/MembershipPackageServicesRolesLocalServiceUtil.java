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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MembershipPackageServicesRoles. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.MembershipPackageServicesRolesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageServicesRolesLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageServicesRolesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.MembershipPackageServicesRolesLocalServiceImpl
 * @generated
 */
public class MembershipPackageServicesRolesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.MembershipPackageServicesRolesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the membership package services roles to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	* @return the membership package services roles that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles addMembershipPackageServicesRoles(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMembershipPackageServicesRoles(membershipPackageServicesRoles);
	}

	/**
	* Creates a new membership package services roles with the primary key. Does not add the membership package services roles to the database.
	*
	* @param mpgsrlId the primary key for the new membership package services roles
	* @return the new membership package services roles
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles createMembershipPackageServicesRoles(
		long mpgsrlId) {
		return getService().createMembershipPackageServicesRoles(mpgsrlId);
	}

	/**
	* Deletes the membership package services roles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles that was removed
	* @throws PortalException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles deleteMembershipPackageServicesRoles(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMembershipPackageServicesRoles(mpgsrlId);
	}

	/**
	* Deletes the membership package services roles from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	* @return the membership package services roles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles deleteMembershipPackageServicesRoles(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteMembershipPackageServicesRoles(membershipPackageServicesRoles);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles fetchMembershipPackageServicesRoles(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMembershipPackageServicesRoles(mpgsrlId);
	}

	/**
	* Returns the membership package services roles with the primary key.
	*
	* @param mpgsrlId the primary key of the membership package services roles
	* @return the membership package services roles
	* @throws PortalException if a membership package services roles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles getMembershipPackageServicesRoles(
		long mpgsrlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackageServicesRoles(mpgsrlId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership package services roleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package services roleses
	* @param end the upper bound of the range of membership package services roleses (not inclusive)
	* @return the range of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> getMembershipPackageServicesRoleses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackageServicesRoleses(start, end);
	}

	/**
	* Returns the number of membership package services roleses.
	*
	* @return the number of membership package services roleses
	* @throws SystemException if a system exception occurred
	*/
	public static int getMembershipPackageServicesRolesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackageServicesRolesesCount();
	}

	/**
	* Updates the membership package services roles in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageServicesRoles the membership package services roles
	* @return the membership package services roles that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles updateMembershipPackageServicesRoles(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMembershipPackageServicesRoles(membershipPackageServicesRoles);
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

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findBygetMembershipPackageServiceRoles(
		long mpId, long classNameId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findBygetMembershipPackageServiceRoles(mpId, classNameId,
			serviceId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackage(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackage(mpId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageId(mpId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByMembershipPackageRole(
		long mpId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageRole(mpId, roleId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByRoleId(
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleId(roleId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceId(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByServiceId(serviceId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByServiceNameMpId(mpId, extra1);
	}

	public static java.util.List<com.liferay.portal.model.Role> getUserMembershipRoles(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserMembershipRoles(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static MembershipPackageServicesRolesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MembershipPackageServicesRolesLocalService.class.getName());

			if (invokableLocalService instanceof MembershipPackageServicesRolesLocalService) {
				_service = (MembershipPackageServicesRolesLocalService)invokableLocalService;
			}
			else {
				_service = new MembershipPackageServicesRolesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MembershipPackageServicesRolesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MembershipPackageServicesRolesLocalService service) {
	}

	private static MembershipPackageServicesRolesLocalService _service;
}