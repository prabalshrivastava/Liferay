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
 * Provides the local service utility for SPUserTypeConfig. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.SPUserTypeConfigLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPUserTypeConfigLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.SPUserTypeConfigLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.SPUserTypeConfigLocalServiceImpl
 * @generated
 */
public class SPUserTypeConfigLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.SPUserTypeConfigLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p user type config to the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeConfig the s p user type config
	* @return the s p user type config that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig addSPUserTypeConfig(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPUserTypeConfig(spUserTypeConfig);
	}

	/**
	* Creates a new s p user type config with the primary key. Does not add the s p user type config to the database.
	*
	* @param spUserTypeConfigId the primary key for the new s p user type config
	* @return the new s p user type config
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig createSPUserTypeConfig(
		long spUserTypeConfigId) {
		return getService().createSPUserTypeConfig(spUserTypeConfigId);
	}

	/**
	* Deletes the s p user type config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeConfigId the primary key of the s p user type config
	* @return the s p user type config that was removed
	* @throws PortalException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig deleteSPUserTypeConfig(
		long spUserTypeConfigId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPUserTypeConfig(spUserTypeConfigId);
	}

	/**
	* Deletes the s p user type config from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeConfig the s p user type config
	* @return the s p user type config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig deleteSPUserTypeConfig(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPUserTypeConfig(spUserTypeConfig);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchSPUserTypeConfig(
		long spUserTypeConfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPUserTypeConfig(spUserTypeConfigId);
	}

	/**
	* Returns the s p user type config with the matching UUID and company.
	*
	* @param uuid the s p user type config's UUID
	* @param companyId the primary key of the company
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchSPUserTypeConfigByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSPUserTypeConfigByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p user type config matching the UUID and group.
	*
	* @param uuid the s p user type config's UUID
	* @param groupId the primary key of the group
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchSPUserTypeConfigByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPUserTypeConfigByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p user type config with the primary key.
	*
	* @param spUserTypeConfigId the primary key of the s p user type config
	* @return the s p user type config
	* @throws PortalException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig getSPUserTypeConfig(
		long spUserTypeConfigId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypeConfig(spUserTypeConfigId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p user type config with the matching UUID and company.
	*
	* @param uuid the s p user type config's UUID
	* @param companyId the primary key of the company
	* @return the matching s p user type config
	* @throws PortalException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig getSPUserTypeConfigByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSPUserTypeConfigByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p user type config matching the UUID and group.
	*
	* @param uuid the s p user type config's UUID
	* @param groupId the primary key of the group
	* @return the matching s p user type config
	* @throws PortalException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig getSPUserTypeConfigByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypeConfigByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p user type configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @return the range of s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> getSPUserTypeConfigs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypeConfigs(start, end);
	}

	/**
	* Returns the number of s p user type configs.
	*
	* @return the number of s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPUserTypeConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPUserTypeConfigsCount();
	}

	/**
	* Updates the s p user type config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeConfig the s p user type config
	* @return the s p user type config that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig updateSPUserTypeConfig(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPUserTypeConfig(spUserTypeConfig);
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

	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUserTypeAndVirtualHostId(
		java.lang.String userType, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserTypeAndVirtualHostId(userType, virtualHostId);
	}

	public static com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUserTypeIdAndVirtualHostId(
		long userTypeId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserTypeIdAndVirtualHostId(userTypeId, virtualHostId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUserTypeId(
		long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserTypeId(userTypeId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByVirtualHostId(
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByVirtualHostId(virtualHostId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPUserTypeConfigLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPUserTypeConfigLocalService.class.getName());

			if (invokableLocalService instanceof SPUserTypeConfigLocalService) {
				_service = (SPUserTypeConfigLocalService)invokableLocalService;
			}
			else {
				_service = new SPUserTypeConfigLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPUserTypeConfigLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPUserTypeConfigLocalService service) {
	}

	private static SPUserTypeConfigLocalService _service;
}