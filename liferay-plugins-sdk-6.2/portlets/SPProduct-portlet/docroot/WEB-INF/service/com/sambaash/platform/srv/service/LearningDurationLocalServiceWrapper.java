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
 * Provides a wrapper for {@link LearningDurationLocalService}.
 *
 * @author gauravvijayvergia
 * @see LearningDurationLocalService
 * @generated
 */
public class LearningDurationLocalServiceWrapper
	implements LearningDurationLocalService,
		ServiceWrapper<LearningDurationLocalService> {
	public LearningDurationLocalServiceWrapper(
		LearningDurationLocalService learningDurationLocalService) {
		_learningDurationLocalService = learningDurationLocalService;
	}

	/**
	* Adds the learning duration to the database. Also notifies the appropriate model listeners.
	*
	* @param learningDuration the learning duration
	* @return the learning duration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LearningDuration addLearningDuration(
		com.sambaash.platform.srv.model.LearningDuration learningDuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.addLearningDuration(learningDuration);
	}

	/**
	* Creates a new learning duration with the primary key. Does not add the learning duration to the database.
	*
	* @param spLearningDurationId the primary key for the new learning duration
	* @return the new learning duration
	*/
	@Override
	public com.sambaash.platform.srv.model.LearningDuration createLearningDuration(
		long spLearningDurationId) {
		return _learningDurationLocalService.createLearningDuration(spLearningDurationId);
	}

	/**
	* Deletes the learning duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLearningDurationId the primary key of the learning duration
	* @return the learning duration that was removed
	* @throws PortalException if a learning duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LearningDuration deleteLearningDuration(
		long spLearningDurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.deleteLearningDuration(spLearningDurationId);
	}

	/**
	* Deletes the learning duration from the database. Also notifies the appropriate model listeners.
	*
	* @param learningDuration the learning duration
	* @return the learning duration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LearningDuration deleteLearningDuration(
		com.sambaash.platform.srv.model.LearningDuration learningDuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.deleteLearningDuration(learningDuration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _learningDurationLocalService.dynamicQuery();
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
		return _learningDurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _learningDurationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _learningDurationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _learningDurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _learningDurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.LearningDuration fetchLearningDuration(
		long spLearningDurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.fetchLearningDuration(spLearningDurationId);
	}

	/**
	* Returns the learning duration with the primary key.
	*
	* @param spLearningDurationId the primary key of the learning duration
	* @return the learning duration
	* @throws PortalException if a learning duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LearningDuration getLearningDuration(
		long spLearningDurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.getLearningDuration(spLearningDurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the learning durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learning durations
	* @param end the upper bound of the range of learning durations (not inclusive)
	* @return the range of learning durations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.LearningDuration> getLearningDurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.getLearningDurations(start, end);
	}

	/**
	* Returns the number of learning durations.
	*
	* @return the number of learning durations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLearningDurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.getLearningDurationsCount();
	}

	/**
	* Updates the learning duration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learningDuration the learning duration
	* @return the learning duration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LearningDuration updateLearningDuration(
		com.sambaash.platform.srv.model.LearningDuration learningDuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDurationLocalService.updateLearningDuration(learningDuration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _learningDurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_learningDurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _learningDurationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LearningDurationLocalService getWrappedLearningDurationLocalService() {
		return _learningDurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLearningDurationLocalService(
		LearningDurationLocalService learningDurationLocalService) {
		_learningDurationLocalService = learningDurationLocalService;
	}

	@Override
	public LearningDurationLocalService getWrappedService() {
		return _learningDurationLocalService;
	}

	@Override
	public void setWrappedService(
		LearningDurationLocalService learningDurationLocalService) {
		_learningDurationLocalService = learningDurationLocalService;
	}

	private LearningDurationLocalService _learningDurationLocalService;
}