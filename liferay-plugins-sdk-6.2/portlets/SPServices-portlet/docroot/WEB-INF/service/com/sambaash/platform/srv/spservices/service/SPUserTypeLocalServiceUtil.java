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
 * Provides the local service utility for SPUserType. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.SPUserTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPUserTypeLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.SPUserTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.SPUserTypeLocalServiceImpl
 * @generated
 */
public class SPUserTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.SPUserTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p user type to the database. Also notifies the appropriate model listeners.
	*
	* @param spUserType the s p user type
	* @return the s p user type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType addSPUserType(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPUserType(spUserType);
	}

	/**
	* Creates a new s p user type with the primary key. Does not add the s p user type to the database.
	*
	* @param spUserTypeId the primary key for the new s p user type
	* @return the new s p user type
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType createSPUserType(
		long spUserTypeId) {
		return getService().createSPUserType(spUserTypeId);
	}

	/**
	* Deletes the s p user type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type that was removed
	* @throws PortalException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType deleteSPUserType(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPUserType(spUserTypeId);
	}

	/**
	* Deletes the s p user type from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserType the s p user type
	* @return the s p user type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType deleteSPUserType(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPUserType(spUserType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.SPUserType fetchSPUserType(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPUserType(spUserTypeId);
	}

	/**
	* Returns the s p user type with the matching UUID and company.
	*
	* @param uuid the s p user type's UUID
	* @param companyId the primary key of the company
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType fetchSPUserTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPUserTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p user type matching the UUID and group.
	*
	* @param uuid the s p user type's UUID
	* @param groupId the primary key of the group
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType fetchSPUserTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPUserTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p user type with the primary key.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type
	* @throws PortalException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType getSPUserType(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserType(spUserTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p user type with the matching UUID and company.
	*
	* @param uuid the s p user type's UUID
	* @param companyId the primary key of the company
	* @return the matching s p user type
	* @throws PortalException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType getSPUserTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p user type matching the UUID and group.
	*
	* @param uuid the s p user type's UUID
	* @param groupId the primary key of the group
	* @return the matching s p user type
	* @throws PortalException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType getSPUserTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p user types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of s p user types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> getSPUserTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypes(start, end);
	}

	/**
	* Returns the number of s p user types.
	*
	* @return the number of s p user types
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPUserTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypesCount();
	}

	/**
	* Updates the s p user type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spUserType the s p user type
	* @return the s p user type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserType updateSPUserType(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPUserType(spUserType);
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

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteId(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBySpSiteId(spSiteId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserTypeId(
		long spSiteId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBySpSiteIdAndUserTypeId(spSiteId, userTypeId);
	}

	public static com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserIdAndUserTypeId(
		long spSiteId, long userId, long userTypeId) {
		return getService()
				   .findBySpSiteIdAndUserIdAndUserTypeId(spSiteId, userId,
			userTypeId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserId(
		long spSiteId, long userId) {
		return getService().findBySpSiteIdAndUserId(spSiteId, userId);
	}

	public static void addSPSiteAndUserType(java.lang.String userType,
		java.lang.String virtualHostId, com.liferay.portal.model.User user,
		java.lang.String productTypeId, java.lang.String subProductTypeId,
		java.lang.String password) {
		getService()
			.addSPSiteAndUserType(userType, virtualHostId, user, productTypeId,
			subProductTypeId, password);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPUserTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPUserTypeLocalService.class.getName());

			if (invokableLocalService instanceof SPUserTypeLocalService) {
				_service = (SPUserTypeLocalService)invokableLocalService;
			}
			else {
				_service = new SPUserTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPUserTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPUserTypeLocalService service) {
	}

	private static SPUserTypeLocalService _service;
}