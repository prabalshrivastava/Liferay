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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PESupervisorLocalService}.
 *
 * @author nareshchebolu
 * @see PESupervisorLocalService
 * @generated
 */
public class PESupervisorLocalServiceWrapper implements PESupervisorLocalService,
	ServiceWrapper<PESupervisorLocalService> {
	public PESupervisorLocalServiceWrapper(
		PESupervisorLocalService peSupervisorLocalService) {
		_peSupervisorLocalService = peSupervisorLocalService;
	}

	/**
	* Adds the p e supervisor to the database. Also notifies the appropriate model listeners.
	*
	* @param peSupervisor the p e supervisor
	* @return the p e supervisor that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor addPESupervisor(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.addPESupervisor(peSupervisor);
	}

	/**
	* Creates a new p e supervisor with the primary key. Does not add the p e supervisor to the database.
	*
	* @param spPESupervisorId the primary key for the new p e supervisor
	* @return the new p e supervisor
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor createPESupervisor(
		long spPESupervisorId) {
		return _peSupervisorLocalService.createPESupervisor(spPESupervisorId);
	}

	/**
	* Deletes the p e supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor that was removed
	* @throws PortalException if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor deletePESupervisor(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.deletePESupervisor(spPESupervisorId);
	}

	/**
	* Deletes the p e supervisor from the database. Also notifies the appropriate model listeners.
	*
	* @param peSupervisor the p e supervisor
	* @return the p e supervisor that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor deletePESupervisor(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.deletePESupervisor(peSupervisor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _peSupervisorLocalService.dynamicQuery();
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
		return _peSupervisorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peSupervisorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _peSupervisorLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _peSupervisorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _peSupervisorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor fetchPESupervisor(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.fetchPESupervisor(spPESupervisorId);
	}

	/**
	* Returns the p e supervisor with the primary key.
	*
	* @param spPESupervisorId the primary key of the p e supervisor
	* @return the p e supervisor
	* @throws PortalException if a p e supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor getPESupervisor(
		long spPESupervisorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.getPESupervisor(spPESupervisorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the p e supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e supervisors
	* @param end the upper bound of the range of p e supervisors (not inclusive)
	* @return the range of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PESupervisor> getPESupervisors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.getPESupervisors(start, end);
	}

	/**
	* Returns the number of p e supervisors.
	*
	* @return the number of p e supervisors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPESupervisorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.getPESupervisorsCount();
	}

	/**
	* Updates the p e supervisor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param peSupervisor the p e supervisor
	* @return the p e supervisor that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor updatePESupervisor(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.updatePESupervisor(peSupervisor);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peSupervisorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peSupervisorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peSupervisorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public long getSupervisor(
		java.util.List<java.util.Map.Entry<java.lang.String, java.lang.String>> listEntry,
		java.lang.String filterType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisorLocalService.getSupervisor(listEntry, filterType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PESupervisorLocalService getWrappedPESupervisorLocalService() {
		return _peSupervisorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPESupervisorLocalService(
		PESupervisorLocalService peSupervisorLocalService) {
		_peSupervisorLocalService = peSupervisorLocalService;
	}

	@Override
	public PESupervisorLocalService getWrappedService() {
		return _peSupervisorLocalService;
	}

	@Override
	public void setWrappedService(
		PESupervisorLocalService peSupervisorLocalService) {
		_peSupervisorLocalService = peSupervisorLocalService;
	}

	private PESupervisorLocalService _peSupervisorLocalService;
}