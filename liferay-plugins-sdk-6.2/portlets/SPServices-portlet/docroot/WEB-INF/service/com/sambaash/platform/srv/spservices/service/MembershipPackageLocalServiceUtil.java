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
 * Provides the local service utility for MembershipPackage. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.MembershipPackageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.MembershipPackageLocalServiceImpl
 * @generated
 */
public class MembershipPackageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.MembershipPackageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the membership package to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackage the membership package
	* @return the membership package that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackage addMembershipPackage(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMembershipPackage(membershipPackage);
	}

	/**
	* Creates a new membership package with the primary key. Does not add the membership package to the database.
	*
	* @param mpId the primary key for the new membership package
	* @return the new membership package
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackage createMembershipPackage(
		long mpId) {
		return getService().createMembershipPackage(mpId);
	}

	/**
	* Deletes the membership package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpId the primary key of the membership package
	* @return the membership package that was removed
	* @throws PortalException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackage deleteMembershipPackage(
		long mpId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMembershipPackage(mpId);
	}

	/**
	* Deletes the membership package from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackage the membership package
	* @return the membership package that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackage deleteMembershipPackage(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMembershipPackage(membershipPackage);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.MembershipPackage fetchMembershipPackage(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMembershipPackage(mpId);
	}

	/**
	* Returns the membership package with the primary key.
	*
	* @param mpId the primary key of the membership package
	* @return the membership package
	* @throws PortalException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackage getMembershipPackage(
		long mpId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackage(mpId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @return the range of membership packages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> getMembershipPackages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackages(start, end);
	}

	/**
	* Returns the number of membership packages.
	*
	* @return the number of membership packages
	* @throws SystemException if a system exception occurred
	*/
	public static int getMembershipPackagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackagesCount();
	}

	/**
	* Updates the membership package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipPackage the membership package
	* @return the membership package that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackage updateMembershipPackage(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMembershipPackage(membershipPackage);
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

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageName(name);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageName(name, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByRoleId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleId(extra1);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByRoleId(
		java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRoleId(extra1, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageType(type);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageType(type, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static MembershipPackageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MembershipPackageLocalService.class.getName());

			if (invokableLocalService instanceof MembershipPackageLocalService) {
				_service = (MembershipPackageLocalService)invokableLocalService;
			}
			else {
				_service = new MembershipPackageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MembershipPackageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MembershipPackageLocalService service) {
	}

	private static MembershipPackageLocalService _service;
}