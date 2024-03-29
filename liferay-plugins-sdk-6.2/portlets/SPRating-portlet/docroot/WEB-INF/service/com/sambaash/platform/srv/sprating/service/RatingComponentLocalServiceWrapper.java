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

package com.sambaash.platform.srv.sprating.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RatingComponentLocalService}.
 *
 * @author harini
 * @see RatingComponentLocalService
 * @generated
 */
public class RatingComponentLocalServiceWrapper
	implements RatingComponentLocalService,
		ServiceWrapper<RatingComponentLocalService> {
	public RatingComponentLocalServiceWrapper(
		RatingComponentLocalService ratingComponentLocalService) {
		_ratingComponentLocalService = ratingComponentLocalService;
	}

	/**
	* Adds the rating component to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingComponent the rating component
	* @return the rating component that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent addRatingComponent(
		com.sambaash.platform.srv.sprating.model.RatingComponent ratingComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.addRatingComponent(ratingComponent);
	}

	/**
	* Creates a new rating component with the primary key. Does not add the rating component to the database.
	*
	* @param spRatingComponentId the primary key for the new rating component
	* @return the new rating component
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent createRatingComponent(
		long spRatingComponentId) {
		return _ratingComponentLocalService.createRatingComponent(spRatingComponentId);
	}

	/**
	* Deletes the rating component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRatingComponentId the primary key of the rating component
	* @return the rating component that was removed
	* @throws PortalException if a rating component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent deleteRatingComponent(
		long spRatingComponentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.deleteRatingComponent(spRatingComponentId);
	}

	/**
	* Deletes the rating component from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingComponent the rating component
	* @return the rating component that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent deleteRatingComponent(
		com.sambaash.platform.srv.sprating.model.RatingComponent ratingComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.deleteRatingComponent(ratingComponent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ratingComponentLocalService.dynamicQuery();
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
		return _ratingComponentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ratingComponentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ratingComponentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _ratingComponentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ratingComponentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent fetchRatingComponent(
		long spRatingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.fetchRatingComponent(spRatingComponentId);
	}

	/**
	* Returns the rating component with the matching UUID and company.
	*
	* @param uuid the rating component's UUID
	* @param companyId the primary key of the company
	* @return the matching rating component, or <code>null</code> if a matching rating component could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent fetchRatingComponentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.fetchRatingComponentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rating component matching the UUID and group.
	*
	* @param uuid the rating component's UUID
	* @param groupId the primary key of the group
	* @return the matching rating component, or <code>null</code> if a matching rating component could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent fetchRatingComponentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.fetchRatingComponentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the rating component with the primary key.
	*
	* @param spRatingComponentId the primary key of the rating component
	* @return the rating component
	* @throws PortalException if a rating component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent getRatingComponent(
		long spRatingComponentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getRatingComponent(spRatingComponentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rating component with the matching UUID and company.
	*
	* @param uuid the rating component's UUID
	* @param companyId the primary key of the company
	* @return the matching rating component
	* @throws PortalException if a matching rating component could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent getRatingComponentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getRatingComponentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rating component matching the UUID and group.
	*
	* @param uuid the rating component's UUID
	* @param groupId the primary key of the group
	* @return the matching rating component
	* @throws PortalException if a matching rating component could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent getRatingComponentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getRatingComponentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the rating components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating components
	* @param end the upper bound of the range of rating components (not inclusive)
	* @return the range of rating components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingComponent> getRatingComponents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getRatingComponents(start, end);
	}

	/**
	* Returns the number of rating components.
	*
	* @return the number of rating components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRatingComponentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getRatingComponentsCount();
	}

	/**
	* Updates the rating component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingComponent the rating component
	* @return the rating component that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent updateRatingComponent(
		com.sambaash.platform.srv.sprating.model.RatingComponent ratingComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.updateRatingComponent(ratingComponent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ratingComponentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ratingComponentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ratingComponentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public long generateNewComponentId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.generateNewComponentId();
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent getNewRatingComponent()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getNewRatingComponent();
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent saveRatingComponent(
		java.lang.String name, long classNameId,
		com.liferay.portal.model.User user, java.lang.String action, long compId)
		throws java.lang.Exception {
		return _ratingComponentLocalService.saveRatingComponent(name,
			classNameId, user, action, compId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingComponent> getAllRatingComponents()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.getAllRatingComponents();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingComponent> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.findByName(name);
	}

	@Override
	public boolean isComponentNameExists(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponentLocalService.isComponentNameExists(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RatingComponentLocalService getWrappedRatingComponentLocalService() {
		return _ratingComponentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRatingComponentLocalService(
		RatingComponentLocalService ratingComponentLocalService) {
		_ratingComponentLocalService = ratingComponentLocalService;
	}

	@Override
	public RatingComponentLocalService getWrappedService() {
		return _ratingComponentLocalService;
	}

	@Override
	public void setWrappedService(
		RatingComponentLocalService ratingComponentLocalService) {
		_ratingComponentLocalService = ratingComponentLocalService;
	}

	private RatingComponentLocalService _ratingComponentLocalService;
}