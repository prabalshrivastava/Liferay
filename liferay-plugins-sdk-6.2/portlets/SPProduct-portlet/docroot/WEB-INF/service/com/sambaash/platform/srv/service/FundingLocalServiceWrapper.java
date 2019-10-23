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
 * Provides a wrapper for {@link FundingLocalService}.
 *
 * @author gauravvijayvergia
 * @see FundingLocalService
 * @generated
 */
public class FundingLocalServiceWrapper implements FundingLocalService,
	ServiceWrapper<FundingLocalService> {
	public FundingLocalServiceWrapper(FundingLocalService fundingLocalService) {
		_fundingLocalService = fundingLocalService;
	}

	/**
	* Adds the funding to the database. Also notifies the appropriate model listeners.
	*
	* @param funding the funding
	* @return the funding that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Funding addFunding(
		com.sambaash.platform.srv.model.Funding funding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.addFunding(funding);
	}

	/**
	* Creates a new funding with the primary key. Does not add the funding to the database.
	*
	* @param spFundingId the primary key for the new funding
	* @return the new funding
	*/
	@Override
	public com.sambaash.platform.srv.model.Funding createFunding(
		long spFundingId) {
		return _fundingLocalService.createFunding(spFundingId);
	}

	/**
	* Deletes the funding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFundingId the primary key of the funding
	* @return the funding that was removed
	* @throws PortalException if a funding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Funding deleteFunding(
		long spFundingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.deleteFunding(spFundingId);
	}

	/**
	* Deletes the funding from the database. Also notifies the appropriate model listeners.
	*
	* @param funding the funding
	* @return the funding that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Funding deleteFunding(
		com.sambaash.platform.srv.model.Funding funding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.deleteFunding(funding);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundingLocalService.dynamicQuery();
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
		return _fundingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _fundingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.model.Funding fetchFunding(
		long spFundingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.fetchFunding(spFundingId);
	}

	/**
	* Returns the funding with the primary key.
	*
	* @param spFundingId the primary key of the funding
	* @return the funding
	* @throws PortalException if a funding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Funding getFunding(long spFundingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.getFunding(spFundingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fundings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fundings
	* @param end the upper bound of the range of fundings (not inclusive)
	* @return the range of fundings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.Funding> getFundings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.getFundings(start, end);
	}

	/**
	* Returns the number of fundings.
	*
	* @return the number of fundings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFundingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.getFundingsCount();
	}

	/**
	* Updates the funding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param funding the funding
	* @return the funding that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Funding updateFunding(
		com.sambaash.platform.srv.model.Funding funding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.updateFunding(funding);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fundingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fundingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fundingLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Funding> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.findByCourseIdAndGroupId(spCourseId, groupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Funding> findByCourseIdOrderByFundOrder(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.findByCourseIdOrderByFundOrder(spCourseId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.Funding> findBySponsorByCourseId(
		long sponsorBy, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.findBySponsorByCourseId(sponsorBy,
			spCourseId);
	}

	@Override
	public void clearCache() {
		_fundingLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.Funding create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FundingLocalService getWrappedFundingLocalService() {
		return _fundingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFundingLocalService(
		FundingLocalService fundingLocalService) {
		_fundingLocalService = fundingLocalService;
	}

	@Override
	public FundingLocalService getWrappedService() {
		return _fundingLocalService;
	}

	@Override
	public void setWrappedService(FundingLocalService fundingLocalService) {
		_fundingLocalService = fundingLocalService;
	}

	private FundingLocalService _fundingLocalService;
}