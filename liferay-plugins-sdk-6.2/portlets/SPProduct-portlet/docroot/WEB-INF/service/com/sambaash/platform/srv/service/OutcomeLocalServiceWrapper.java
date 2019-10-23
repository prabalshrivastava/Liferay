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
 * Provides a wrapper for {@link OutcomeLocalService}.
 *
 * @author gauravvijayvergia
 * @see OutcomeLocalService
 * @generated
 */
public class OutcomeLocalServiceWrapper implements OutcomeLocalService,
	ServiceWrapper<OutcomeLocalService> {
	public OutcomeLocalServiceWrapper(OutcomeLocalService outcomeLocalService) {
		_outcomeLocalService = outcomeLocalService;
	}

	/**
	* Adds the outcome to the database. Also notifies the appropriate model listeners.
	*
	* @param outcome the outcome
	* @return the outcome that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outcome addOutcome(
		com.sambaash.platform.srv.model.Outcome outcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.addOutcome(outcome);
	}

	/**
	* Creates a new outcome with the primary key. Does not add the outcome to the database.
	*
	* @param spOutcomeId the primary key for the new outcome
	* @return the new outcome
	*/
	@Override
	public com.sambaash.platform.srv.model.Outcome createOutcome(
		long spOutcomeId) {
		return _outcomeLocalService.createOutcome(spOutcomeId);
	}

	/**
	* Deletes the outcome with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome that was removed
	* @throws PortalException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outcome deleteOutcome(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.deleteOutcome(spOutcomeId);
	}

	/**
	* Deletes the outcome from the database. Also notifies the appropriate model listeners.
	*
	* @param outcome the outcome
	* @return the outcome that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outcome deleteOutcome(
		com.sambaash.platform.srv.model.Outcome outcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.deleteOutcome(outcome);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _outcomeLocalService.dynamicQuery();
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
		return _outcomeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _outcomeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _outcomeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _outcomeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _outcomeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.model.Outcome fetchOutcome(
		long spOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.fetchOutcome(spOutcomeId);
	}

	/**
	* Returns the outcome with the primary key.
	*
	* @param spOutcomeId the primary key of the outcome
	* @return the outcome
	* @throws PortalException if a outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outcome getOutcome(long spOutcomeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.getOutcome(spOutcomeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the outcomes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of outcomes
	* @param end the upper bound of the range of outcomes (not inclusive)
	* @return the range of outcomes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.Outcome> getOutcomes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.getOutcomes(start, end);
	}

	/**
	* Returns the number of outcomes.
	*
	* @return the number of outcomes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOutcomesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.getOutcomesCount();
	}

	/**
	* Updates the outcome in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param outcome the outcome
	* @return the outcome that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Outcome updateOutcome(
		com.sambaash.platform.srv.model.Outcome outcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.updateOutcome(outcome);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _outcomeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_outcomeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _outcomeLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Outcome> findByGroupIdAndCompetencyUnitId(
		long groupId, long spCompetencyUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outcomeLocalService.findByGroupIdAndCompetencyUnitId(groupId,
			spCompetencyUnitId);
	}

	@Override
	public void clearCache() {
		_outcomeLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OutcomeLocalService getWrappedOutcomeLocalService() {
		return _outcomeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOutcomeLocalService(
		OutcomeLocalService outcomeLocalService) {
		_outcomeLocalService = outcomeLocalService;
	}

	@Override
	public OutcomeLocalService getWrappedService() {
		return _outcomeLocalService;
	}

	@Override
	public void setWrappedService(OutcomeLocalService outcomeLocalService) {
		_outcomeLocalService = outcomeLocalService;
	}

	private OutcomeLocalService _outcomeLocalService;
}