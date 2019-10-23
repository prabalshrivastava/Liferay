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
 * Provides the local service utility for SPSellingPrice. This utility wraps
 * {@link com.sambaash.platform.srv.spshopping.service.impl.SPSellingPriceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPSellingPriceLocalService
 * @see com.sambaash.platform.srv.spshopping.service.base.SPSellingPriceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spshopping.service.impl.SPSellingPriceLocalServiceImpl
 * @generated
 */
public class SPSellingPriceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spshopping.service.impl.SPSellingPriceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p selling price to the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPrice the s p selling price
	* @return the s p selling price that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice addSPSellingPrice(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPSellingPrice(spSellingPrice);
	}

	/**
	* Creates a new s p selling price with the primary key. Does not add the s p selling price to the database.
	*
	* @param spSellingPriceId the primary key for the new s p selling price
	* @return the new s p selling price
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice createSPSellingPrice(
		long spSellingPriceId) {
		return getService().createSPSellingPrice(spSellingPriceId);
	}

	/**
	* Deletes the s p selling price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price that was removed
	* @throws PortalException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice deleteSPSellingPrice(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSellingPrice(spSellingPriceId);
	}

	/**
	* Deletes the s p selling price from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPrice the s p selling price
	* @return the s p selling price that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice deleteSPSellingPrice(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPSellingPrice(spSellingPrice);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchSPSellingPrice(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPSellingPrice(spSellingPriceId);
	}

	/**
	* Returns the s p selling price with the primary key.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price
	* @throws PortalException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice getSPSellingPrice(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSellingPrice(spSellingPriceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p selling prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling prices
	* @param end the upper bound of the range of s p selling prices (not inclusive)
	* @return the range of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> getSPSellingPrices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSellingPrices(start, end);
	}

	/**
	* Returns the number of s p selling prices.
	*
	* @return the number of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPSellingPricesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPSellingPricesCount();
	}

	/**
	* Updates the s p selling price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSellingPrice the s p selling price
	* @return the s p selling price that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice updateSPSellingPrice(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPSellingPrice(spSellingPrice);
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

	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findPriceByItemId(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findPriceByItemId(spSellingItemId);
	}

	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice findPriceByPackageId(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getService().findPriceByPackageId(spSellingPackageId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPSellingPriceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPSellingPriceLocalService.class.getName());

			if (invokableLocalService instanceof SPSellingPriceLocalService) {
				_service = (SPSellingPriceLocalService)invokableLocalService;
			}
			else {
				_service = new SPSellingPriceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPSellingPriceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPSellingPriceLocalService service) {
	}

	private static SPSellingPriceLocalService _service;
}