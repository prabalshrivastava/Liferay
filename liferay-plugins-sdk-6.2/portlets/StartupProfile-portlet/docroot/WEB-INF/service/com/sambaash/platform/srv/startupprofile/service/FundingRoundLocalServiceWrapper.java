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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FundingRoundLocalService}.
 *
 * @author pradeep
 * @see FundingRoundLocalService
 * @generated
 */
public class FundingRoundLocalServiceWrapper implements FundingRoundLocalService,
	ServiceWrapper<FundingRoundLocalService> {
	public FundingRoundLocalServiceWrapper(
		FundingRoundLocalService fundingRoundLocalService) {
		_fundingRoundLocalService = fundingRoundLocalService;
	}

	/**
	* Adds the funding round to the database. Also notifies the appropriate model listeners.
	*
	* @param fundingRound the funding round
	* @return the funding round that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound addFundingRound(
		com.sambaash.platform.srv.startupprofile.model.FundingRound fundingRound)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.addFundingRound(fundingRound);
	}

	/**
	* Creates a new funding round with the primary key. Does not add the funding round to the database.
	*
	* @param fundingRoundId the primary key for the new funding round
	* @return the new funding round
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound createFundingRound(
		long fundingRoundId) {
		return _fundingRoundLocalService.createFundingRound(fundingRoundId);
	}

	/**
	* Deletes the funding round with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fundingRoundId the primary key of the funding round
	* @return the funding round that was removed
	* @throws PortalException if a funding round with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound deleteFundingRound(
		long fundingRoundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.deleteFundingRound(fundingRoundId);
	}

	/**
	* Deletes the funding round from the database. Also notifies the appropriate model listeners.
	*
	* @param fundingRound the funding round
	* @return the funding round that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound deleteFundingRound(
		com.sambaash.platform.srv.startupprofile.model.FundingRound fundingRound)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.deleteFundingRound(fundingRound);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundingRoundLocalService.dynamicQuery();
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
		return _fundingRoundLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.FundingRoundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundingRoundLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.FundingRoundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundingRoundLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _fundingRoundLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundingRoundLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound fetchFundingRound(
		long fundingRoundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.fetchFundingRound(fundingRoundId);
	}

	/**
	* Returns the funding round with the matching UUID and company.
	*
	* @param uuid the funding round's UUID
	* @param companyId the primary key of the company
	* @return the matching funding round, or <code>null</code> if a matching funding round could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound fetchFundingRoundByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.fetchFundingRoundByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the funding round matching the UUID and group.
	*
	* @param uuid the funding round's UUID
	* @param groupId the primary key of the group
	* @return the matching funding round, or <code>null</code> if a matching funding round could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound fetchFundingRoundByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.fetchFundingRoundByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the funding round with the primary key.
	*
	* @param fundingRoundId the primary key of the funding round
	* @return the funding round
	* @throws PortalException if a funding round with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound getFundingRound(
		long fundingRoundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.getFundingRound(fundingRoundId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the funding round with the matching UUID and company.
	*
	* @param uuid the funding round's UUID
	* @param companyId the primary key of the company
	* @return the matching funding round
	* @throws PortalException if a matching funding round could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound getFundingRoundByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.getFundingRoundByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the funding round matching the UUID and group.
	*
	* @param uuid the funding round's UUID
	* @param groupId the primary key of the group
	* @return the matching funding round
	* @throws PortalException if a matching funding round could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound getFundingRoundByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.getFundingRoundByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the funding rounds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.FundingRoundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding rounds
	* @param end the upper bound of the range of funding rounds (not inclusive)
	* @return the range of funding rounds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.FundingRound> getFundingRounds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.getFundingRounds(start, end);
	}

	/**
	* Returns the number of funding rounds.
	*
	* @return the number of funding rounds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFundingRoundsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.getFundingRoundsCount();
	}

	/**
	* Updates the funding round in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fundingRound the funding round
	* @return the funding round that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound updateFundingRound(
		com.sambaash.platform.srv.startupprofile.model.FundingRound fundingRound)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.updateFundingRound(fundingRound);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fundingRoundLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fundingRoundLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fundingRoundLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public long counterIncrement()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.counterIncrement();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRoundLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FundingRoundLocalService getWrappedFundingRoundLocalService() {
		return _fundingRoundLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFundingRoundLocalService(
		FundingRoundLocalService fundingRoundLocalService) {
		_fundingRoundLocalService = fundingRoundLocalService;
	}

	@Override
	public FundingRoundLocalService getWrappedService() {
		return _fundingRoundLocalService;
	}

	@Override
	public void setWrappedService(
		FundingRoundLocalService fundingRoundLocalService) {
		_fundingRoundLocalService = fundingRoundLocalService;
	}

	private FundingRoundLocalService _fundingRoundLocalService;
}