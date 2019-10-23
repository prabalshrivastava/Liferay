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
 * Provides a wrapper for {@link GraduationCriteriaLocalService}.
 *
 * @author gauravvijayvergia
 * @see GraduationCriteriaLocalService
 * @generated
 */
public class GraduationCriteriaLocalServiceWrapper
	implements GraduationCriteriaLocalService,
		ServiceWrapper<GraduationCriteriaLocalService> {
	public GraduationCriteriaLocalServiceWrapper(
		GraduationCriteriaLocalService graduationCriteriaLocalService) {
		_graduationCriteriaLocalService = graduationCriteriaLocalService;
	}

	/**
	* Adds the graduation criteria to the database. Also notifies the appropriate model listeners.
	*
	* @param graduationCriteria the graduation criteria
	* @return the graduation criteria that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria addGraduationCriteria(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.addGraduationCriteria(graduationCriteria);
	}

	/**
	* Creates a new graduation criteria with the primary key. Does not add the graduation criteria to the database.
	*
	* @param spGraduationCriteriaId the primary key for the new graduation criteria
	* @return the new graduation criteria
	*/
	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria createGraduationCriteria(
		long spGraduationCriteriaId) {
		return _graduationCriteriaLocalService.createGraduationCriteria(spGraduationCriteriaId);
	}

	/**
	* Deletes the graduation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria that was removed
	* @throws PortalException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria deleteGraduationCriteria(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.deleteGraduationCriteria(spGraduationCriteriaId);
	}

	/**
	* Deletes the graduation criteria from the database. Also notifies the appropriate model listeners.
	*
	* @param graduationCriteria the graduation criteria
	* @return the graduation criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria deleteGraduationCriteria(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.deleteGraduationCriteria(graduationCriteria);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _graduationCriteriaLocalService.dynamicQuery();
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
		return _graduationCriteriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _graduationCriteriaLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _graduationCriteriaLocalService.dynamicQuery(dynamicQuery,
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
		return _graduationCriteriaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _graduationCriteriaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria fetchGraduationCriteria(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.fetchGraduationCriteria(spGraduationCriteriaId);
	}

	/**
	* Returns the graduation criteria with the primary key.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria
	* @throws PortalException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria getGraduationCriteria(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.getGraduationCriteria(spGraduationCriteriaId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the graduation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @return the range of graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> getGraduationCriterias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.getGraduationCriterias(start, end);
	}

	/**
	* Returns the number of graduation criterias.
	*
	* @return the number of graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGraduationCriteriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.getGraduationCriteriasCount();
	}

	/**
	* Updates the graduation criteria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param graduationCriteria the graduation criteria
	* @return the graduation criteria that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria updateGraduationCriteria(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.updateGraduationCriteria(graduationCriteria);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _graduationCriteriaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_graduationCriteriaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _graduationCriteriaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.findByCourseIdAndGroupId(spCourseId,
			groupId);
	}

	@Override
	public void clearCache() {
		_graduationCriteriaLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteriaLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GraduationCriteriaLocalService getWrappedGraduationCriteriaLocalService() {
		return _graduationCriteriaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGraduationCriteriaLocalService(
		GraduationCriteriaLocalService graduationCriteriaLocalService) {
		_graduationCriteriaLocalService = graduationCriteriaLocalService;
	}

	@Override
	public GraduationCriteriaLocalService getWrappedService() {
		return _graduationCriteriaLocalService;
	}

	@Override
	public void setWrappedService(
		GraduationCriteriaLocalService graduationCriteriaLocalService) {
		_graduationCriteriaLocalService = graduationCriteriaLocalService;
	}

	private GraduationCriteriaLocalService _graduationCriteriaLocalService;
}