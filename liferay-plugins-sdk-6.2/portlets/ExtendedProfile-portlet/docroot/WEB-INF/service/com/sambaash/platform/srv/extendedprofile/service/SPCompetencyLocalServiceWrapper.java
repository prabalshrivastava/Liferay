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

package com.sambaash.platform.srv.extendedprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPCompetencyLocalService}.
 *
 * @author harini
 * @see SPCompetencyLocalService
 * @generated
 */
public class SPCompetencyLocalServiceWrapper implements SPCompetencyLocalService,
	ServiceWrapper<SPCompetencyLocalService> {
	public SPCompetencyLocalServiceWrapper(
		SPCompetencyLocalService spCompetencyLocalService) {
		_spCompetencyLocalService = spCompetencyLocalService;
	}

	/**
	* Adds the s p competency to the database. Also notifies the appropriate model listeners.
	*
	* @param spCompetency the s p competency
	* @return the s p competency that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency addSPCompetency(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.addSPCompetency(spCompetency);
	}

	/**
	* Creates a new s p competency with the primary key. Does not add the s p competency to the database.
	*
	* @param classpk the primary key for the new s p competency
	* @return the new s p competency
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency createSPCompetency(
		long classpk) {
		return _spCompetencyLocalService.createSPCompetency(classpk);
	}

	/**
	* Deletes the s p competency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency that was removed
	* @throws PortalException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency deleteSPCompetency(
		long classpk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.deleteSPCompetency(classpk);
	}

	/**
	* Deletes the s p competency from the database. Also notifies the appropriate model listeners.
	*
	* @param spCompetency the s p competency
	* @return the s p competency that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency deleteSPCompetency(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.deleteSPCompetency(spCompetency);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spCompetencyLocalService.dynamicQuery();
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
		return _spCompetencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spCompetencyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spCompetencyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spCompetencyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spCompetencyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchSPCompetency(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.fetchSPCompetency(classpk);
	}

	/**
	* Returns the s p competency with the primary key.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency
	* @throws PortalException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency getSPCompetency(
		long classpk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.getSPCompetency(classpk);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p competencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @return the range of s p competencies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> getSPCompetencies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.getSPCompetencies(start, end);
	}

	/**
	* Returns the number of s p competencies.
	*
	* @return the number of s p competencies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPCompetenciesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.getSPCompetenciesCount();
	}

	/**
	* Updates the s p competency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spCompetency the s p competency
	* @return the s p competency that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency updateSPCompetency(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.updateSPCompetency(spCompetency);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spCompetencyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spCompetencyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spCompetencyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCategoryId(userId, categoryId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCategoryId(userId, categoryId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCategoryId(userId, categoryId,
			start, end, orderByComparator);
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return _spCompetencyLocalService.findByCategoryIdAndCompetencyId(userId,
			categoryId, competencyId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCompetencyList(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCompetencyList(userId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCompetencyList(userId, start,
			end, orderByComparator);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil} to access the s p competency local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetencyLocalService.findByCompetencyListByJobRole(belongsToJobRole);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPCompetencyLocalService getWrappedSPCompetencyLocalService() {
		return _spCompetencyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPCompetencyLocalService(
		SPCompetencyLocalService spCompetencyLocalService) {
		_spCompetencyLocalService = spCompetencyLocalService;
	}

	@Override
	public SPCompetencyLocalService getWrappedService() {
		return _spCompetencyLocalService;
	}

	@Override
	public void setWrappedService(
		SPCompetencyLocalService spCompetencyLocalService) {
		_spCompetencyLocalService = spCompetencyLocalService;
	}

	private SPCompetencyLocalService _spCompetencyLocalService;
}