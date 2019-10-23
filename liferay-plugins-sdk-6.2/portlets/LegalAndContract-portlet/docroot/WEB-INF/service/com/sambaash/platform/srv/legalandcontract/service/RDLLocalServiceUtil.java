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

package com.sambaash.platform.srv.legalandcontract.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RDL. This utility wraps
 * {@link com.sambaash.platform.srv.legalandcontract.service.impl.RDLLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see RDLLocalService
 * @see com.sambaash.platform.srv.legalandcontract.service.base.RDLLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.impl.RDLLocalServiceImpl
 * @generated
 */
public class RDLLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.legalandcontract.service.impl.RDLLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the r d l to the database. Also notifies the appropriate model listeners.
	*
	* @param rdl the r d l
	* @return the r d l that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL addRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRDL(rdl);
	}

	/**
	* Creates a new r d l with the primary key. Does not add the r d l to the database.
	*
	* @param spRdlId the primary key for the new r d l
	* @return the new r d l
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL createRDL(
		long spRdlId) {
		return getService().createRDL(spRdlId);
	}

	/**
	* Deletes the r d l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l that was removed
	* @throws PortalException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL deleteRDL(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRDL(spRdlId);
	}

	/**
	* Deletes the r d l from the database. Also notifies the appropriate model listeners.
	*
	* @param rdl the r d l
	* @return the r d l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL deleteRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRDL(rdl);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchRDL(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRDL(spRdlId);
	}

	/**
	* Returns the r d l with the matching UUID and company.
	*
	* @param uuid the r d l's UUID
	* @param companyId the primary key of the company
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchRDLByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRDLByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the r d l matching the UUID and group.
	*
	* @param uuid the r d l's UUID
	* @param groupId the primary key of the group
	* @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL fetchRDLByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRDLByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the r d l with the primary key.
	*
	* @param spRdlId the primary key of the r d l
	* @return the r d l
	* @throws PortalException if a r d l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL getRDL(
		long spRdlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDL(spRdlId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the r d l with the matching UUID and company.
	*
	* @param uuid the r d l's UUID
	* @param companyId the primary key of the company
	* @return the matching r d l
	* @throws PortalException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL getRDLByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDLByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the r d l matching the UUID and group.
	*
	* @param uuid the r d l's UUID
	* @param groupId the primary key of the group
	* @return the matching r d l
	* @throws PortalException if a matching r d l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL getRDLByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDLByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the r d ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d ls
	* @param end the upper bound of the range of r d ls (not inclusive)
	* @return the range of r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> getRDLs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDLs(start, end);
	}

	/**
	* Returns the number of r d ls.
	*
	* @return the number of r d ls
	* @throws SystemException if a system exception occurred
	*/
	public static int getRDLsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDLsCount();
	}

	/**
	* Updates the r d l in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rdl the r d l
	* @return the r d l that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.RDL updateRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRDL(rdl);
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

	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.RDL> findBylitigationId(
		long litigationId) {
		return getService().findBylitigationId(litigationId);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.RDL getNewRDL()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewRDL();
	}

	public static com.sambaash.platform.srv.legalandcontract.model.RDL addRDL(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl, long userId,
		long[] assetCategoryIds) throws java.lang.Exception {
		return getService().addRDL(rdl, userId, assetCategoryIds);
	}

	public static void reIndex(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl) {
		getService().reIndex(rdl);
	}

	public static void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, rdl, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static RDLLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RDLLocalService.class.getName());

			if (invokableLocalService instanceof RDLLocalService) {
				_service = (RDLLocalService)invokableLocalService;
			}
			else {
				_service = new RDLLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RDLLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RDLLocalService service) {
	}

	private static RDLLocalService _service;
}