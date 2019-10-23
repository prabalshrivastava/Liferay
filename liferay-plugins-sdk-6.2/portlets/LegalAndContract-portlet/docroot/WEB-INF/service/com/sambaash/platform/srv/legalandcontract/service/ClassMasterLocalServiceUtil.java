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
 * Provides the local service utility for ClassMaster. This utility wraps
 * {@link com.sambaash.platform.srv.legalandcontract.service.impl.ClassMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see ClassMasterLocalService
 * @see com.sambaash.platform.srv.legalandcontract.service.base.ClassMasterLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.impl.ClassMasterLocalServiceImpl
 * @generated
 */
public class ClassMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.legalandcontract.service.impl.ClassMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the class master to the database. Also notifies the appropriate model listeners.
	*
	* @param classMaster the class master
	* @return the class master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster addClassMaster(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addClassMaster(classMaster);
	}

	/**
	* Creates a new class master with the primary key. Does not add the class master to the database.
	*
	* @param spClassId the primary key for the new class master
	* @return the new class master
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster createClassMaster(
		long spClassId) {
		return getService().createClassMaster(spClassId);
	}

	/**
	* Deletes the class master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spClassId the primary key of the class master
	* @return the class master that was removed
	* @throws PortalException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster deleteClassMaster(
		long spClassId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteClassMaster(spClassId);
	}

	/**
	* Deletes the class master from the database. Also notifies the appropriate model listeners.
	*
	* @param classMaster the class master
	* @return the class master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster deleteClassMaster(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteClassMaster(classMaster);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchClassMaster(
		long spClassId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClassMaster(spClassId);
	}

	/**
	* Returns the class master with the matching UUID and company.
	*
	* @param uuid the class master's UUID
	* @param companyId the primary key of the company
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchClassMasterByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClassMasterByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the class master matching the UUID and group.
	*
	* @param uuid the class master's UUID
	* @param groupId the primary key of the group
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchClassMasterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClassMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the class master with the primary key.
	*
	* @param spClassId the primary key of the class master
	* @return the class master
	* @throws PortalException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster getClassMaster(
		long spClassId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassMaster(spClassId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the class master with the matching UUID and company.
	*
	* @param uuid the class master's UUID
	* @param companyId the primary key of the company
	* @return the matching class master
	* @throws PortalException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster getClassMasterByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassMasterByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the class master matching the UUID and group.
	*
	* @param uuid the class master's UUID
	* @param groupId the primary key of the group
	* @return the matching class master
	* @throws PortalException if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster getClassMasterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the class masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of class masters
	* @param end the upper bound of the range of class masters (not inclusive)
	* @return the range of class masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> getClassMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassMasters(start, end);
	}

	/**
	* Returns the number of class masters.
	*
	* @return the number of class masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getClassMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassMastersCount();
	}

	/**
	* Updates the class master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param classMaster the class master
	* @return the class master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster updateClassMaster(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClassMaster(classMaster);
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

	public static void addNewClass(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster,
		long[] assetCategoryIds) {
		getService().addNewClass(userId, classMaster, assetCategoryIds);
	}

	public static void addClass(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster,
		long[] assetCategoryIds) throws java.lang.Exception {
		getService().addClass(userId, classMaster, assetCategoryIds);
	}

	public static void addNewClassVersion(long userId, long oldClassId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster newClassMaster,
		long[] assetCategoryIds) {
		getService()
			.addNewClassVersion(userId, oldClassId, newClassMaster,
			assetCategoryIds);
	}

	public static void addNewClassVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster oldClassMaster,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster newClassMaster,
		long[] assetCategoryIds) {
		getService()
			.addNewClassVersion(userId, oldClassMaster, newClassMaster,
			assetCategoryIds);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster getNewClassMaster()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewClassMaster();
	}

	public static void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, classMaster, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByCodeCountry(
		java.lang.String code, java.lang.String country) {
		return getService().findByCodeCountry(code, country);
	}

	public static com.sambaash.platform.srv.legalandcontract.model.ClassMaster getLatestClassByCodeCountry(
		java.lang.String code, java.lang.String country)
		throws java.lang.Exception {
		return getService().getLatestClassByCodeCountry(code, country);
	}

	public static void clearService() {
		_service = null;
	}

	public static ClassMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClassMasterLocalService.class.getName());

			if (invokableLocalService instanceof ClassMasterLocalService) {
				_service = (ClassMasterLocalService)invokableLocalService;
			}
			else {
				_service = new ClassMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ClassMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ClassMasterLocalService service) {
	}

	private static ClassMasterLocalService _service;
}