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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClassMasterLocalService}.
 *
 * @author nareshchebolu
 * @see ClassMasterLocalService
 * @generated
 */
public class ClassMasterLocalServiceWrapper implements ClassMasterLocalService,
	ServiceWrapper<ClassMasterLocalService> {
	public ClassMasterLocalServiceWrapper(
		ClassMasterLocalService classMasterLocalService) {
		_classMasterLocalService = classMasterLocalService;
	}

	/**
	* Adds the class master to the database. Also notifies the appropriate model listeners.
	*
	* @param classMaster the class master
	* @return the class master that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster addClassMaster(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.addClassMaster(classMaster);
	}

	/**
	* Creates a new class master with the primary key. Does not add the class master to the database.
	*
	* @param spClassId the primary key for the new class master
	* @return the new class master
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster createClassMaster(
		long spClassId) {
		return _classMasterLocalService.createClassMaster(spClassId);
	}

	/**
	* Deletes the class master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spClassId the primary key of the class master
	* @return the class master that was removed
	* @throws PortalException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster deleteClassMaster(
		long spClassId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.deleteClassMaster(spClassId);
	}

	/**
	* Deletes the class master from the database. Also notifies the appropriate model listeners.
	*
	* @param classMaster the class master
	* @return the class master that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster deleteClassMaster(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.deleteClassMaster(classMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _classMasterLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchClassMaster(
		long spClassId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.fetchClassMaster(spClassId);
	}

	/**
	* Returns the class master with the matching UUID and company.
	*
	* @param uuid the class master's UUID
	* @param companyId the primary key of the company
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchClassMasterByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.fetchClassMasterByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the class master matching the UUID and group.
	*
	* @param uuid the class master's UUID
	* @param groupId the primary key of the group
	* @return the matching class master, or <code>null</code> if a matching class master could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster fetchClassMasterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.fetchClassMasterByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the class master with the primary key.
	*
	* @param spClassId the primary key of the class master
	* @return the class master
	* @throws PortalException if a class master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster getClassMaster(
		long spClassId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getClassMaster(spClassId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster getClassMasterByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getClassMasterByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster getClassMasterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getClassMasterByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> getClassMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getClassMasters(start, end);
	}

	/**
	* Returns the number of class masters.
	*
	* @return the number of class masters
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getClassMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getClassMastersCount();
	}

	/**
	* Updates the class master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param classMaster the class master
	* @return the class master that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster updateClassMaster(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.updateClassMaster(classMaster);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _classMasterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_classMasterLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _classMasterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addNewClass(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster,
		long[] assetCategoryIds) {
		_classMasterLocalService.addNewClass(userId, classMaster,
			assetCategoryIds);
	}

	@Override
	public void addClass(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster,
		long[] assetCategoryIds) throws java.lang.Exception {
		_classMasterLocalService.addClass(userId, classMaster, assetCategoryIds);
	}

	@Override
	public void addNewClassVersion(long userId, long oldClassId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster newClassMaster,
		long[] assetCategoryIds) {
		_classMasterLocalService.addNewClassVersion(userId, oldClassId,
			newClassMaster, assetCategoryIds);
	}

	@Override
	public void addNewClassVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster oldClassMaster,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster newClassMaster,
		long[] assetCategoryIds) {
		_classMasterLocalService.addNewClassVersion(userId, oldClassMaster,
			newClassMaster, assetCategoryIds);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster getNewClassMaster()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMasterLocalService.getNewClassMaster();
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_classMasterLocalService.updateAsset(userId, classMaster,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster findByCodeCountry(
		java.lang.String code, java.lang.String country) {
		return _classMasterLocalService.findByCodeCountry(code, country);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster getLatestClassByCodeCountry(
		java.lang.String code, java.lang.String country)
		throws java.lang.Exception {
		return _classMasterLocalService.getLatestClassByCodeCountry(code,
			country);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ClassMasterLocalService getWrappedClassMasterLocalService() {
		return _classMasterLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedClassMasterLocalService(
		ClassMasterLocalService classMasterLocalService) {
		_classMasterLocalService = classMasterLocalService;
	}

	@Override
	public ClassMasterLocalService getWrappedService() {
		return _classMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ClassMasterLocalService classMasterLocalService) {
		_classMasterLocalService = classMasterLocalService;
	}

	private ClassMasterLocalService _classMasterLocalService;
}