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
 * Provides the local service utility for SPParameter. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.SPParameterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SPParameterLocalService
 * @see com.sambaash.platform.srv.spservices.service.base.SPParameterLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.SPParameterLocalServiceImpl
 * @generated
 */
public class SPParameterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.SPParameterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p parameter to the database. Also notifies the appropriate model listeners.
	*
	* @param spParameter the s p parameter
	* @return the s p parameter that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter addSPParameter(
		com.sambaash.platform.srv.spservices.model.SPParameter spParameter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPParameter(spParameter);
	}

	/**
	* Creates a new s p parameter with the primary key. Does not add the s p parameter to the database.
	*
	* @param spParameterId the primary key for the new s p parameter
	* @return the new s p parameter
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter createSPParameter(
		long spParameterId) {
		return getService().createSPParameter(spParameterId);
	}

	/**
	* Deletes the s p parameter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spParameterId the primary key of the s p parameter
	* @return the s p parameter that was removed
	* @throws PortalException if a s p parameter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter deleteSPParameter(
		long spParameterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPParameter(spParameterId);
	}

	/**
	* Deletes the s p parameter from the database. Also notifies the appropriate model listeners.
	*
	* @param spParameter the s p parameter
	* @return the s p parameter that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter deleteSPParameter(
		com.sambaash.platform.srv.spservices.model.SPParameter spParameter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPParameter(spParameter);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spservices.model.SPParameter fetchSPParameter(
		long spParameterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPParameter(spParameterId);
	}

	/**
	* Returns the s p parameter with the matching UUID and company.
	*
	* @param uuid the s p parameter's UUID
	* @param companyId the primary key of the company
	* @return the matching s p parameter, or <code>null</code> if a matching s p parameter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter fetchSPParameterByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPParameterByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p parameter matching the UUID and group.
	*
	* @param uuid the s p parameter's UUID
	* @param groupId the primary key of the group
	* @return the matching s p parameter, or <code>null</code> if a matching s p parameter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter fetchSPParameterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPParameterByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p parameter with the primary key.
	*
	* @param spParameterId the primary key of the s p parameter
	* @return the s p parameter
	* @throws PortalException if a s p parameter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter getSPParameter(
		long spParameterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPParameter(spParameterId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p parameter with the matching UUID and company.
	*
	* @param uuid the s p parameter's UUID
	* @param companyId the primary key of the company
	* @return the matching s p parameter
	* @throws PortalException if a matching s p parameter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter getSPParameterByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPParameterByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p parameter matching the UUID and group.
	*
	* @param uuid the s p parameter's UUID
	* @param groupId the primary key of the group
	* @return the matching s p parameter
	* @throws PortalException if a matching s p parameter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter getSPParameterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPParameterByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p parameters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPParameterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p parameters
	* @param end the upper bound of the range of s p parameters (not inclusive)
	* @return the range of s p parameters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPParameter> getSPParameters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPParameters(start, end);
	}

	/**
	* Returns the number of s p parameters.
	*
	* @return the number of s p parameters
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPParametersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPParametersCount();
	}

	/**
	* Updates the s p parameter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spParameter the s p parameter
	* @return the s p parameter that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPParameter updateSPParameter(
		com.sambaash.platform.srv.spservices.model.SPParameter spParameter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPParameter(spParameter);
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

	public static com.sambaash.platform.srv.spservices.model.SPParameter findBySPParameterGroupIdAndName(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPParameterException {
		return getService().findBySPParameterGroupIdAndName(groupId, name);
	}

	public static com.sambaash.platform.srv.spservices.model.SPParameter findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPParameterException {
		return getService()
				   .findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(groupId,
			name);
	}

	public static com.sambaash.platform.srv.spservices.model.SPParameter getNewSPParameter()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewSPParameter();
	}

	public static void addNewSPParameter(long userId,
		com.sambaash.platform.srv.spservices.model.SPParameter spParameter)
		throws java.lang.Exception {
		getService().addNewSPParameter(userId, spParameter);
	}

	public static com.sambaash.platform.srv.spservices.model.SPParameter findSPParameterOrAdd(
		java.lang.String name, java.lang.String value,
		java.lang.String description, java.lang.String category,
		java.lang.Long groupId) {
		return getService()
				   .findSPParameterOrAdd(name, value, description, category,
			groupId);
	}

	public static void updateSPParameter(java.lang.String paramName,
		java.lang.String paramValue) {
		getService().updateSPParameter(paramName, paramValue);
	}

	public static void clearSPParameterPool(long groupId, java.lang.String name) {
		getService().clearSPParameterPool(groupId, name);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPParameter> getSPParameterByPrefix(
		java.lang.String prefix, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPParameterByPrefix(prefix, start, end);
	}

	public static java.util.List<com.liferay.portal.model.Group> getSPParameterGroupIdAndName() {
		return getService().getSPParameterGroupIdAndName();
	}

	public static void clearService() {
		_service = null;
	}

	public static SPParameterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPParameterLocalService.class.getName());

			if (invokableLocalService instanceof SPParameterLocalService) {
				_service = (SPParameterLocalService)invokableLocalService;
			}
			else {
				_service = new SPParameterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPParameterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPParameterLocalService service) {
	}

	private static SPParameterLocalService _service;
}