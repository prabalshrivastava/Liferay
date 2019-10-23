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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PEProcessStatusType. This utility wraps
 * {@link com.sambaash.platform.srv.processbuilder.service.impl.PEProcessStatusTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see PEProcessStatusTypeLocalService
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessStatusTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEProcessStatusTypeLocalServiceImpl
 * @generated
 */
public class PEProcessStatusTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEProcessStatusTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the p e process status type to the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessStatusType the p e process status type
	* @return the p e process status type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType addPEProcessStatusType(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPEProcessStatusType(peProcessStatusType);
	}

	/**
	* Creates a new p e process status type with the primary key. Does not add the p e process status type to the database.
	*
	* @param spPEProcessStatusTypeId the primary key for the new p e process status type
	* @return the new p e process status type
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType createPEProcessStatusType(
		long spPEProcessStatusTypeId) {
		return getService().createPEProcessStatusType(spPEProcessStatusTypeId);
	}

	/**
	* Deletes the p e process status type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessStatusTypeId the primary key of the p e process status type
	* @return the p e process status type that was removed
	* @throws PortalException if a p e process status type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType deletePEProcessStatusType(
		long spPEProcessStatusTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePEProcessStatusType(spPEProcessStatusTypeId);
	}

	/**
	* Deletes the p e process status type from the database. Also notifies the appropriate model listeners.
	*
	* @param peProcessStatusType the p e process status type
	* @return the p e process status type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType deletePEProcessStatusType(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePEProcessStatusType(peProcessStatusType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType fetchPEProcessStatusType(
		long spPEProcessStatusTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPEProcessStatusType(spPEProcessStatusTypeId);
	}

	/**
	* Returns the p e process status type with the matching UUID and company.
	*
	* @param uuid the p e process status type's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType fetchPEProcessStatusTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchPEProcessStatusTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the p e process status type matching the UUID and group.
	*
	* @param uuid the p e process status type's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType fetchPEProcessStatusTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchPEProcessStatusTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the p e process status type with the primary key.
	*
	* @param spPEProcessStatusTypeId the primary key of the p e process status type
	* @return the p e process status type
	* @throws PortalException if a p e process status type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType getPEProcessStatusType(
		long spPEProcessStatusTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessStatusType(spPEProcessStatusTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e process status type with the matching UUID and company.
	*
	* @param uuid the p e process status type's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process status type
	* @throws PortalException if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType getPEProcessStatusTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPEProcessStatusTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the p e process status type matching the UUID and group.
	*
	* @param uuid the p e process status type's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process status type
	* @throws PortalException if a matching p e process status type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType getPEProcessStatusTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessStatusTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the p e process status types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e process status types
	* @param end the upper bound of the range of p e process status types (not inclusive)
	* @return the range of p e process status types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> getPEProcessStatusTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessStatusTypes(start, end);
	}

	/**
	* Returns the number of p e process status types.
	*
	* @return the number of p e process status types
	* @throws SystemException if a system exception occurred
	*/
	public static int getPEProcessStatusTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessStatusTypesCount();
	}

	/**
	* Updates the p e process status type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peProcessStatusType the p e process status type
	* @return the p e process status type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType updatePEProcessStatusType(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePEProcessStatusType(peProcessStatusType);
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

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* com.sambaash.platform
	* .srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil} to
	* access the p e process status type local service.
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> findByProcessId(
		long processId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByProcessId(processId);
	}

	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> findByProcessIds(
		long[] processIdsArr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByProcessIds(processIdsArr);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static void clearService() {
		_service = null;
	}

	public static PEProcessStatusTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PEProcessStatusTypeLocalService.class.getName());

			if (invokableLocalService instanceof PEProcessStatusTypeLocalService) {
				_service = (PEProcessStatusTypeLocalService)invokableLocalService;
			}
			else {
				_service = new PEProcessStatusTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PEProcessStatusTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PEProcessStatusTypeLocalService service) {
	}

	private static PEProcessStatusTypeLocalService _service;
}