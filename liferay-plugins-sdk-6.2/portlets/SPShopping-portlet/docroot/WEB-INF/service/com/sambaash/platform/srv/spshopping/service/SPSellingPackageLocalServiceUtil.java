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

package com.sambaash.platform.srv.spshopping.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPSellingPackage. This utility wraps
 * {@link com.sambaash.platform.srv.spshopping.service.impl.SPSellingPackageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPSellingPackageLocalService
 * @see com.sambaash.platform.srv.spshopping.service.base.SPSellingPackageLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spshopping.service.impl.SPSellingPackageLocalServiceImpl
 * @generated
 */
public class SPSellingPackageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spshopping.service.impl.SPSellingPackageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p selling package to the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackage the s p selling package
	* @return the s p selling package that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage addSPSellingPackage(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPSellingPackage(spSellingPackage);
	}

	/**
	* Creates a new s p selling package with the primary key. Does not add the s p selling package to the database.
	*
	* @param spSellingPackageId the primary key for the new s p selling package
	* @return the new s p selling package
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage createSPSellingPackage(
		long spSellingPackageId) {
		return getService().createSPSellingPackage(spSellingPackageId);
	}

	/**
	* Deletes the s p selling package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package that was removed
	* @throws PortalException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage deleteSPSellingPackage(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSellingPackage(spSellingPackageId);
	}

	/**
	* Deletes the s p selling package from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackage the s p selling package
	* @return the s p selling package that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage deleteSPSellingPackage(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSellingPackage(spSellingPackage);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage fetchSPSellingPackage(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPSellingPackage(spSellingPackageId);
	}

	/**
	* Returns the s p selling package with the primary key.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package
	* @throws PortalException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage getSPSellingPackage(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSellingPackage(spSellingPackageId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p selling packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling packages
	* @param end the upper bound of the range of s p selling packages (not inclusive)
	* @return the range of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> getSPSellingPackages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSellingPackages(start, end);
	}

	/**
	* Returns the number of s p selling packages.
	*
	* @return the number of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPSellingPackagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSellingPackagesCount();
	}

	/**
	* Updates the s p selling package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackage the s p selling package
	* @return the s p selling package that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPackage updateSPSellingPackage(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPSellingPackage(spSellingPackage);
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

	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findSPSellingPackage(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSPSellingPackage(active);
	}

	public static java.lang.Boolean hasPromoCode(long spSellingPackageId) {
		return getService().hasPromoCode(spSellingPackageId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPSellingPackageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPSellingPackageLocalService.class.getName());

			if (invokableLocalService instanceof SPSellingPackageLocalService) {
				_service = (SPSellingPackageLocalService)invokableLocalService;
			}
			else {
				_service = new SPSellingPackageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPSellingPackageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPSellingPackageLocalService service) {
	}

	private static SPSellingPackageLocalService _service;
}