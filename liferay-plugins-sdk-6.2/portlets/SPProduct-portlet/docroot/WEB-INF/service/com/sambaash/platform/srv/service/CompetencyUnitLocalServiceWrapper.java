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
 * Provides a wrapper for {@link CompetencyUnitLocalService}.
 *
 * @author gauravvijayvergia
 * @see CompetencyUnitLocalService
 * @generated
 */
public class CompetencyUnitLocalServiceWrapper
	implements CompetencyUnitLocalService,
		ServiceWrapper<CompetencyUnitLocalService> {
	public CompetencyUnitLocalServiceWrapper(
		CompetencyUnitLocalService competencyUnitLocalService) {
		_competencyUnitLocalService = competencyUnitLocalService;
	}

	/**
	* Adds the competency unit to the database. Also notifies the appropriate model listeners.
	*
	* @param competencyUnit the competency unit
	* @return the competency unit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit addCompetencyUnit(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.addCompetencyUnit(competencyUnit);
	}

	/**
	* Creates a new competency unit with the primary key. Does not add the competency unit to the database.
	*
	* @param spCompetencyUnitId the primary key for the new competency unit
	* @return the new competency unit
	*/
	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit createCompetencyUnit(
		long spCompetencyUnitId) {
		return _competencyUnitLocalService.createCompetencyUnit(spCompetencyUnitId);
	}

	/**
	* Deletes the competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit that was removed
	* @throws PortalException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit deleteCompetencyUnit(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.deleteCompetencyUnit(spCompetencyUnitId);
	}

	/**
	* Deletes the competency unit from the database. Also notifies the appropriate model listeners.
	*
	* @param competencyUnit the competency unit
	* @return the competency unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit deleteCompetencyUnit(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.deleteCompetencyUnit(competencyUnit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _competencyUnitLocalService.dynamicQuery();
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
		return _competencyUnitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _competencyUnitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _competencyUnitLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _competencyUnitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _competencyUnitLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit fetchCompetencyUnit(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.fetchCompetencyUnit(spCompetencyUnitId);
	}

	/**
	* Returns the competency unit with the primary key.
	*
	* @param spCompetencyUnitId the primary key of the competency unit
	* @return the competency unit
	* @throws PortalException if a competency unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit getCompetencyUnit(
		long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.getCompetencyUnit(spCompetencyUnitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the competency units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of competency units
	* @param end the upper bound of the range of competency units (not inclusive)
	* @return the range of competency units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CompetencyUnit> getCompetencyUnits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.getCompetencyUnits(start, end);
	}

	/**
	* Returns the number of competency units.
	*
	* @return the number of competency units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCompetencyUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.getCompetencyUnitsCount();
	}

	/**
	* Updates the competency unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param competencyUnit the competency unit
	* @return the competency unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit updateCompetencyUnit(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.updateCompetencyUnit(competencyUnit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _competencyUnitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_competencyUnitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _competencyUnitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnitLocalService.create();
	}

	@Override
	public void clearCache() {
		_competencyUnitLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit findByCompetencyUnitCode(
		java.lang.String competencyUnitCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCompetencyUnitException {
		return _competencyUnitLocalService.findByCompetencyUnitCode(competencyUnitCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CompetencyUnitLocalService getWrappedCompetencyUnitLocalService() {
		return _competencyUnitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCompetencyUnitLocalService(
		CompetencyUnitLocalService competencyUnitLocalService) {
		_competencyUnitLocalService = competencyUnitLocalService;
	}

	@Override
	public CompetencyUnitLocalService getWrappedService() {
		return _competencyUnitLocalService;
	}

	@Override
	public void setWrappedService(
		CompetencyUnitLocalService competencyUnitLocalService) {
		_competencyUnitLocalService = competencyUnitLocalService;
	}

	private CompetencyUnitLocalService _competencyUnitLocalService;
}