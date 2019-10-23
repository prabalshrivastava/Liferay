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

package com.sambaash.platform.srv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ModuleCompetencyUnitLocalService}.
 *
 * @author gauravvijayvergia
 * @see ModuleCompetencyUnitLocalService
 * @generated
 */
public class ModuleCompetencyUnitLocalServiceWrapper
	implements ModuleCompetencyUnitLocalService,
		ServiceWrapper<ModuleCompetencyUnitLocalService> {
	public ModuleCompetencyUnitLocalServiceWrapper(
		ModuleCompetencyUnitLocalService moduleCompetencyUnitLocalService) {
		_moduleCompetencyUnitLocalService = moduleCompetencyUnitLocalService;
	}

	/**
	* Adds the module competency unit to the database. Also notifies the appropriate model listeners.
	*
	* @param moduleCompetencyUnit the module competency unit
	* @return the module competency unit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit addModuleCompetencyUnit(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.addModuleCompetencyUnit(moduleCompetencyUnit);
	}

	/**
	* Creates a new module competency unit with the primary key. Does not add the module competency unit to the database.
	*
	* @param spModuleCompetencyUnitId the primary key for the new module competency unit
	* @return the new module competency unit
	*/
	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit createModuleCompetencyUnit(
		long spModuleCompetencyUnitId) {
		return _moduleCompetencyUnitLocalService.createModuleCompetencyUnit(spModuleCompetencyUnitId);
	}

	/**
	* Deletes the module competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spModuleCompetencyUnitId the primary key of the module competency unit
	* @return the module competency unit that was removed
	* @throws PortalException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit deleteModuleCompetencyUnit(
		long spModuleCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.deleteModuleCompetencyUnit(spModuleCompetencyUnitId);
	}

	/**
	* Deletes the module competency unit from the database. Also notifies the appropriate model listeners.
	*
	* @param moduleCompetencyUnit the module competency unit
	* @return the module competency unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit deleteModuleCompetencyUnit(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.deleteModuleCompetencyUnit(moduleCompetencyUnit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _moduleCompetencyUnitLocalService.dynamicQuery();
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
		return _moduleCompetencyUnitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _moduleCompetencyUnitLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _moduleCompetencyUnitLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _moduleCompetencyUnitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _moduleCompetencyUnitLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit fetchModuleCompetencyUnit(
		long spModuleCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.fetchModuleCompetencyUnit(spModuleCompetencyUnitId);
	}

	/**
	* Returns the module competency unit with the primary key.
	*
	* @param spModuleCompetencyUnitId the primary key of the module competency unit
	* @return the module competency unit
	* @throws PortalException if a module competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit getModuleCompetencyUnit(
		long spModuleCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.getModuleCompetencyUnit(spModuleCompetencyUnitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the module competency units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module competency units
	* @param end the upper bound of the range of module competency units (not inclusive)
	* @return the range of module competency units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> getModuleCompetencyUnits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.getModuleCompetencyUnits(start,
			end);
	}

	/**
	* Returns the number of module competency units.
	*
	* @return the number of module competency units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getModuleCompetencyUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.getModuleCompetencyUnitsCount();
	}

	/**
	* Updates the module competency unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param moduleCompetencyUnit the module competency unit
	* @return the module competency unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit updateModuleCompetencyUnit(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.updateModuleCompetencyUnit(moduleCompetencyUnit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _moduleCompetencyUnitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_moduleCompetencyUnitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _moduleCompetencyUnitLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.findByModuleIdAndGroupId(spModuleId,
			groupId);
	}

	@Override
	public void clearCache() {
		_moduleCompetencyUnitLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnitLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ModuleCompetencyUnitLocalService getWrappedModuleCompetencyUnitLocalService() {
		return _moduleCompetencyUnitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedModuleCompetencyUnitLocalService(
		ModuleCompetencyUnitLocalService moduleCompetencyUnitLocalService) {
		_moduleCompetencyUnitLocalService = moduleCompetencyUnitLocalService;
	}

	@Override
	public ModuleCompetencyUnitLocalService getWrappedService() {
		return _moduleCompetencyUnitLocalService;
	}

	@Override
	public void setWrappedService(
		ModuleCompetencyUnitLocalService moduleCompetencyUnitLocalService) {
		_moduleCompetencyUnitLocalService = moduleCompetencyUnitLocalService;
	}

	private ModuleCompetencyUnitLocalService _moduleCompetencyUnitLocalService;
}