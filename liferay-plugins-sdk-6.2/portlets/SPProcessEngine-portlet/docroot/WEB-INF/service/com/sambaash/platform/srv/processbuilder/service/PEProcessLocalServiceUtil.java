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
 * Provides the local service utility for PEProcess. This utility wraps
 * {@link com.sambaash.platform.srv.processbuilder.service.impl.PEProcessLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see PEProcessLocalService
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEProcessLocalServiceImpl
 * @generated
 */
public class PEProcessLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEProcessLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the p e process to the database. Also notifies the appropriate model listeners.
	*
	* @param peProcess the p e process
	* @return the p e process that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess addPEProcess(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPEProcess(peProcess);
	}

	/**
	* Creates a new p e process with the primary key. Does not add the p e process to the database.
	*
	* @param spPEProcessId the primary key for the new p e process
	* @return the new p e process
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess createPEProcess(
		long spPEProcessId) {
		return getService().createPEProcess(spPEProcessId);
	}

	/**
	* Deletes the p e process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPEProcessId the primary key of the p e process
	* @return the p e process that was removed
	* @throws PortalException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess deletePEProcess(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePEProcess(spPEProcessId);
	}

	/**
	* Deletes the p e process from the database. Also notifies the appropriate model listeners.
	*
	* @param peProcess the p e process
	* @return the p e process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess deletePEProcess(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePEProcess(peProcess);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchPEProcess(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPEProcess(spPEProcessId);
	}

	/**
	* Returns the p e process with the matching UUID and company.
	*
	* @param uuid the p e process's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchPEProcessByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPEProcessByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the p e process matching the UUID and group.
	*
	* @param uuid the p e process's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess fetchPEProcessByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPEProcessByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the p e process with the primary key.
	*
	* @param spPEProcessId the primary key of the p e process
	* @return the p e process
	* @throws PortalException if a p e process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess getPEProcess(
		long spPEProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcess(spPEProcessId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the p e process with the matching UUID and company.
	*
	* @param uuid the p e process's UUID
	* @param companyId the primary key of the company
	* @return the matching p e process
	* @throws PortalException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess getPEProcessByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the p e process matching the UUID and group.
	*
	* @param uuid the p e process's UUID
	* @param groupId the primary key of the group
	* @return the matching p e process
	* @throws PortalException if a matching p e process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess getPEProcessByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the p e processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e processes
	* @param end the upper bound of the range of p e processes (not inclusive)
	* @return the range of p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> getPEProcesses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcesses(start, end);
	}

	/**
	* Returns the number of p e processes.
	*
	* @return the number of p e processes
	* @throws SystemException if a system exception occurred
	*/
	public static int getPEProcessesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPEProcessesCount();
	}

	/**
	* Updates the p e process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peProcess the p e process
	* @return the p e process that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.processbuilder.model.PEProcess updatePEProcess(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePEProcess(peProcess);
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
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil}
	* to access the p e process local service.
	*/
	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> getPublished()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublished();
	}

	public static java.util.List<com.sambaash.platform.srv.processbuilder.model.PEProcess> findByProcessIds(
		long[] processIdsArr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByProcessIds(processIdsArr);
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcess create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create();
	}

	public static com.sambaash.platform.srv.processbuilder.model.PEProcess findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException {
		return getService().findByName(name);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEntitiesListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse,
		java.lang.String servercall, long entityClassId, boolean formatJSON) {
		return getService()
				   .getEntitiesListing(resourceRequest, resourceResponse,
			servercall, entityClassId, formatJSON);
	}

	public static com.sambaash.platform.pe.PEEntity getEntityDetail(
		long entityClassId, java.lang.String entityId, long userId, long siteId) {
		return getService()
				   .getEntityDetail(entityClassId, entityId, userId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getFeeDetailsForProcess(
		java.lang.String storageId, java.lang.String modelName, long userId,
		long siteId) {
		return getService()
				   .getFeeDetailsForProcess(storageId, modelName, userId, siteId);
	}

	public static double getTotalFeePayable(java.lang.String storageId,
		java.lang.String modelName, long userId, long siteId) {
		return getService()
				   .getTotalFeePayable(storageId, modelName, userId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEntitiesListingFormatedJSON(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse,
		java.lang.String servercall, long entityClassId) {
		return getService()
				   .getEntitiesListingFormatedJSON(resourceRequest,
			resourceResponse, servercall, entityClassId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PEProcessLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PEProcessLocalService.class.getName());

			if (invokableLocalService instanceof PEProcessLocalService) {
				_service = (PEProcessLocalService)invokableLocalService;
			}
			else {
				_service = new PEProcessLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PEProcessLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PEProcessLocalService service) {
	}

	private static PEProcessLocalService _service;
}