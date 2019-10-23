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

package com.sambaash.platform.srv.legalandcontract.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrademarksLocalService}.
 *
 * @author nareshchebolu
 * @see TrademarksLocalService
 * @generated
 */
public class TrademarksLocalServiceWrapper implements TrademarksLocalService,
	ServiceWrapper<TrademarksLocalService> {
	public TrademarksLocalServiceWrapper(
		TrademarksLocalService trademarksLocalService) {
		_trademarksLocalService = trademarksLocalService;
	}

	/**
	* Adds the trademarks to the database. Also notifies the appropriate model listeners.
	*
	* @param trademarks the trademarks
	* @return the trademarks that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks addTrademarks(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.addTrademarks(trademarks);
	}

	/**
	* Creates a new trademarks with the primary key. Does not add the trademarks to the database.
	*
	* @param spTrademarksId the primary key for the new trademarks
	* @return the new trademarks
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks createTrademarks(
		long spTrademarksId) {
		return _trademarksLocalService.createTrademarks(spTrademarksId);
	}

	/**
	* Deletes the trademarks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTrademarksId the primary key of the trademarks
	* @return the trademarks that was removed
	* @throws PortalException if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks deleteTrademarks(
		long spTrademarksId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.deleteTrademarks(spTrademarksId);
	}

	/**
	* Deletes the trademarks from the database. Also notifies the appropriate model listeners.
	*
	* @param trademarks the trademarks
	* @return the trademarks that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks deleteTrademarks(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.deleteTrademarks(trademarks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trademarksLocalService.dynamicQuery();
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
		return _trademarksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _trademarksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _trademarksLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _trademarksLocalService.dynamicQueryCount(dynamicQuery);
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
		return _trademarksLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchTrademarks(
		long spTrademarksId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.fetchTrademarks(spTrademarksId);
	}

	/**
	* Returns the trademarks with the matching UUID and company.
	*
	* @param uuid the trademarks's UUID
	* @param companyId the primary key of the company
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchTrademarksByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.fetchTrademarksByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the trademarks matching the UUID and group.
	*
	* @param uuid the trademarks's UUID
	* @param groupId the primary key of the group
	* @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks fetchTrademarksByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.fetchTrademarksByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the trademarks with the primary key.
	*
	* @param spTrademarksId the primary key of the trademarks
	* @return the trademarks
	* @throws PortalException if a trademarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks getTrademarks(
		long spTrademarksId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getTrademarks(spTrademarksId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the trademarks with the matching UUID and company.
	*
	* @param uuid the trademarks's UUID
	* @param companyId the primary key of the company
	* @return the matching trademarks
	* @throws PortalException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks getTrademarksByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getTrademarksByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the trademarks matching the UUID and group.
	*
	* @param uuid the trademarks's UUID
	* @param groupId the primary key of the group
	* @return the matching trademarks
	* @throws PortalException if a matching trademarks could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks getTrademarksByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getTrademarksByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the trademarkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trademarkses
	* @param end the upper bound of the range of trademarkses (not inclusive)
	* @return the range of trademarkses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Trademarks> getTrademarkses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getTrademarkses(start, end);
	}

	/**
	* Returns the number of trademarkses.
	*
	* @return the number of trademarkses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTrademarksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getTrademarksesCount();
	}

	/**
	* Updates the trademarks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trademarks the trademarks
	* @return the trademarks that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks updateTrademarks(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.updateTrademarks(trademarks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _trademarksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trademarksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _trademarksLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addTrademarks(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks,
		long[] assetCategoryIds) throws java.lang.Exception {
		_trademarksLocalService.addTrademarks(userId, trademarks,
			assetCategoryIds);
	}

	@Override
	public void addNewTrademarksVersion(long userId, long oldTrademarksId,
		com.sambaash.platform.srv.legalandcontract.model.Trademarks newTrademarks,
		long[] assetCategoryIds) throws java.lang.Exception {
		_trademarksLocalService.addNewTrademarksVersion(userId,
			oldTrademarksId, newTrademarks, assetCategoryIds);
	}

	@Override
	public void addNewTrademarksVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Trademarks oldTrademarks,
		com.sambaash.platform.srv.legalandcontract.model.Trademarks newTrademarks,
		long[] assetCategoryIds) throws java.lang.Exception {
		_trademarksLocalService.addNewTrademarksVersion(userId, oldTrademarks,
			newTrademarks, assetCategoryIds);
	}

	@Override
	public void addNewTrademarks(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks,
		long[] assetCategoryIds) throws java.lang.Exception {
		_trademarksLocalService.addNewTrademarks(userId, trademarks,
			assetCategoryIds);
	}

	@Override
	public void reIndex(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks) {
		_trademarksLocalService.reIndex(trademarks);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks getNewTrademarks()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trademarksLocalService.getNewTrademarks();
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_trademarksLocalService.updateAsset(userId, trademarks,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks findByRegistrationNumberCountry(
		java.lang.String regNum, java.lang.String country) {
		return _trademarksLocalService.findByRegistrationNumberCountry(regNum,
			country);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks findByApplicationNoCountry(
		java.lang.String applicationNo, java.lang.String country) {
		return _trademarksLocalService.findByApplicationNoCountry(applicationNo,
			country);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks getLatestTrademarksByNumberCountry(
		java.lang.String number, java.lang.String country) {
		return _trademarksLocalService.getLatestTrademarksByNumberCountry(number,
			country);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Trademarks getLatestTrademarksByApplicationNoCountry(
		java.lang.String number, java.lang.String country) {
		return _trademarksLocalService.getLatestTrademarksByApplicationNoCountry(number,
			country);
	}

	/**
	* @param number
	* @param country
	* @return
	*/
	@Override
	public java.util.List<java.lang.Object[]> getLatestTrademarkIdAndVersionNumber(
		java.lang.String number, java.lang.String country) {
		return _trademarksLocalService.getLatestTrademarkIdAndVersionNumber(number,
			country);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TrademarksLocalService getWrappedTrademarksLocalService() {
		return _trademarksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTrademarksLocalService(
		TrademarksLocalService trademarksLocalService) {
		_trademarksLocalService = trademarksLocalService;
	}

	@Override
	public TrademarksLocalService getWrappedService() {
		return _trademarksLocalService;
	}

	@Override
	public void setWrappedService(TrademarksLocalService trademarksLocalService) {
		_trademarksLocalService = trademarksLocalService;
	}

	private TrademarksLocalService _trademarksLocalService;
}