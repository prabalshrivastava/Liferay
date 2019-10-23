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

package com.sambaash.platform.srv.spdynamicforms.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPFormStorage. This utility wraps
 * {@link com.sambaash.platform.srv.spdynamicforms.service.impl.SPFormStorageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author glenn
 * @see SPFormStorageLocalService
 * @see com.sambaash.platform.srv.spdynamicforms.service.base.SPFormStorageLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spdynamicforms.service.impl.SPFormStorageLocalServiceImpl
 * @generated
 */
public class SPFormStorageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spdynamicforms.service.impl.SPFormStorageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p form storage to the database. Also notifies the appropriate model listeners.
	*
	* @param spFormStorage the s p form storage
	* @return the s p form storage that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage addSPFormStorage(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPFormStorage(spFormStorage);
	}

	/**
	* Creates a new s p form storage with the primary key. Does not add the s p form storage to the database.
	*
	* @param formStorageId the primary key for the new s p form storage
	* @return the new s p form storage
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage createSPFormStorage(
		long formStorageId) {
		return getService().createSPFormStorage(formStorageId);
	}

	/**
	* Deletes the s p form storage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage that was removed
	* @throws PortalException if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage deleteSPFormStorage(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPFormStorage(formStorageId);
	}

	/**
	* Deletes the s p form storage from the database. Also notifies the appropriate model listeners.
	*
	* @param spFormStorage the s p form storage
	* @return the s p form storage that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage deleteSPFormStorage(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPFormStorage(spFormStorage);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage fetchSPFormStorage(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPFormStorage(formStorageId);
	}

	/**
	* Returns the s p form storage with the primary key.
	*
	* @param formStorageId the primary key of the s p form storage
	* @return the s p form storage
	* @throws PortalException if a s p form storage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage getSPFormStorage(
		long formStorageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPFormStorage(formStorageId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p form storages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p form storages
	* @param end the upper bound of the range of s p form storages (not inclusive)
	* @return the range of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> getSPFormStorages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPFormStorages(start, end);
	}

	/**
	* Returns the number of s p form storages.
	*
	* @return the number of s p form storages
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPFormStoragesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPFormStoragesCount();
	}

	/**
	* Updates the s p form storage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spFormStorage the s p form storage
	* @return the s p form storage that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage updateSPFormStorage(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPFormStorage(spFormStorage);
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

	public static void clearService() {
		_service = null;
	}

	public static SPFormStorageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPFormStorageLocalService.class.getName());

			if (invokableLocalService instanceof SPFormStorageLocalService) {
				_service = (SPFormStorageLocalService)invokableLocalService;
			}
			else {
				_service = new SPFormStorageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPFormStorageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPFormStorageLocalService service) {
	}

	private static SPFormStorageLocalService _service;
}