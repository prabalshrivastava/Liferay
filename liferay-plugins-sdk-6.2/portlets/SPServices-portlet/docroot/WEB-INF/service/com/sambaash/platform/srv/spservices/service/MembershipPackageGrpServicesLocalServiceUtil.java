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
 * Provides the local service utility for MembershipPackageGrpServices. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.MembershipPackageGrpServicesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageGrpServicesLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageGrpServicesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.MembershipPackageGrpServicesLocalServiceImpl
 * @generated
 */
public class MembershipPackageGrpServicesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.MembershipPackageGrpServicesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the membership package grp services to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageGrpServices the membership package grp services
	* @return the membership package grp services that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices addMembershipPackageGrpServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMembershipPackageGrpServices(membershipPackageGrpServices);
	}

	/**
	* Creates a new membership package grp services with the primary key. Does not add the membership package grp services to the database.
	*
	* @param mpgsscId the primary key for the new membership package grp services
	* @return the new membership package grp services
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices createMembershipPackageGrpServices(
		long mpgsscId) {
		return getService().createMembershipPackageGrpServices(mpgsscId);
	}

	/**
	* Deletes the membership package grp services with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services that was removed
	* @throws PortalException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices deleteMembershipPackageGrpServices(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMembershipPackageGrpServices(mpgsscId);
	}

	/**
	* Deletes the membership package grp services from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageGrpServices the membership package grp services
	* @return the membership package grp services that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices deleteMembershipPackageGrpServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteMembershipPackageGrpServices(membershipPackageGrpServices);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices fetchMembershipPackageGrpServices(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMembershipPackageGrpServices(mpgsscId);
	}

	/**
	* Returns the membership package grp services with the primary key.
	*
	* @param mpgsscId the primary key of the membership package grp services
	* @return the membership package grp services
	* @throws PortalException if a membership package grp services with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices getMembershipPackageGrpServices(
		long mpgsscId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackageGrpServices(mpgsscId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership package grp serviceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package grp serviceses
	* @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	* @return the range of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> getMembershipPackageGrpServiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackageGrpServiceses(start, end);
	}

	/**
	* Returns the number of membership package grp serviceses.
	*
	* @return the number of membership package grp serviceses
	* @throws SystemException if a system exception occurred
	*/
	public static int getMembershipPackageGrpServicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMembershipPackageGrpServicesesCount();
	}

	/**
	* Updates the membership package grp services in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipPackageGrpServices the membership package grp services
	* @return the membership package grp services that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices updateMembershipPackageGrpServices(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMembershipPackageGrpServices(membershipPackageGrpServices);
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

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageGrpServicesScgId(scgId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		java.lang.String scgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByMembershipPackageGrpServicesScgId(scgId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageGrpServicesScId(scId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		java.lang.String scId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByMembershipPackageGrpServicesScId(scId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMembershipPackageGrpServicesMpId(mpId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByMembershipPackageGrpServicesMpId(mpId, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> findByServiceNameMpId(
		long mpId, java.lang.String extra2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByServiceNameMpId(mpId, extra2);
	}

	public static void clearService() {
		_service = null;
	}

	public static MembershipPackageGrpServicesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MembershipPackageGrpServicesLocalService.class.getName());

			if (invokableLocalService instanceof MembershipPackageGrpServicesLocalService) {
				_service = (MembershipPackageGrpServicesLocalService)invokableLocalService;
			}
			else {
				_service = new MembershipPackageGrpServicesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MembershipPackageGrpServicesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MembershipPackageGrpServicesLocalService service) {
	}

	private static MembershipPackageGrpServicesLocalService _service;
}