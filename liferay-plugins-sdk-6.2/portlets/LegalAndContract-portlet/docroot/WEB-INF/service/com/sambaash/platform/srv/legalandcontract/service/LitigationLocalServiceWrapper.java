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
 * Provides a wrapper for {@link LitigationLocalService}.
 *
 * @author nareshchebolu
 * @see LitigationLocalService
 * @generated
 */
public class LitigationLocalServiceWrapper implements LitigationLocalService,
	ServiceWrapper<LitigationLocalService> {
	public LitigationLocalServiceWrapper(
		LitigationLocalService litigationLocalService) {
		_litigationLocalService = litigationLocalService;
	}

	/**
	* Adds the litigation to the database. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation addLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.addLitigation(litigation);
	}

	/**
	* Creates a new litigation with the primary key. Does not add the litigation to the database.
	*
	* @param spLitigationId the primary key for the new litigation
	* @return the new litigation
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation createLitigation(
		long spLitigationId) {
		return _litigationLocalService.createLitigation(spLitigationId);
	}

	/**
	* Deletes the litigation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation that was removed
	* @throws PortalException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation deleteLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.deleteLitigation(spLitigationId);
	}

	/**
	* Deletes the litigation from the database. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation deleteLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.deleteLitigation(litigation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _litigationLocalService.dynamicQuery();
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
		return _litigationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _litigationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _litigationLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _litigationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _litigationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.fetchLitigation(spLitigationId);
	}

	/**
	* Returns the litigation with the matching UUID and company.
	*
	* @param uuid the litigation's UUID
	* @param companyId the primary key of the company
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.fetchLitigationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the litigation matching the UUID and group.
	*
	* @param uuid the litigation's UUID
	* @param groupId the primary key of the group
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.fetchLitigationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the litigation with the primary key.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation
	* @throws PortalException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getLitigation(spLitigationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the litigation with the matching UUID and company.
	*
	* @param uuid the litigation's UUID
	* @param companyId the primary key of the company
	* @return the matching litigation
	* @throws PortalException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getLitigationByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the litigation matching the UUID and group.
	*
	* @param uuid the litigation's UUID
	* @param groupId the primary key of the group
	* @return the matching litigation
	* @throws PortalException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getLitigationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the litigations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @return the range of litigations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> getLitigations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getLitigations(start, end);
	}

	/**
	* Returns the number of litigations.
	*
	* @return the number of litigations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLitigationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getLitigationsCount();
	}

	/**
	* Updates the litigation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation updateLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.updateLitigation(litigation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _litigationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_litigationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _litigationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addNewLitigationVersion(long userId, long oldLitigationId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation newLitigation,
		long[] assetCategoryIds) {
		_litigationLocalService.addNewLitigationVersion(userId,
			oldLitigationId, newLitigation, assetCategoryIds);
	}

	@Override
	public void addNewLitigationVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation oldLitigation,
		com.sambaash.platform.srv.legalandcontract.model.Litigation newLitigation,
		long[] assetCategoryIds) {
		_litigationLocalService.addNewLitigationVersion(userId, oldLitigation,
			newLitigation, assetCategoryIds);
	}

	@Override
	public void addNewLitigation(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds) {
		_litigationLocalService.addNewLitigation(userId, litigation,
			assetCategoryIds);
	}

	@Override
	public void reIndex(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation) {
		_litigationLocalService.reIndex(litigation);
	}

	@Override
	public void reIndexTrademark(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks) {
		_litigationLocalService.reIndexTrademark(trademarks);
	}

	@Override
	public void addLitigation(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds) throws java.lang.Exception {
		_litigationLocalService.addLitigation(userId, litigation,
			assetCategoryIds);
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getNewLitigation()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _litigationLocalService.getNewLitigation();
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_litigationLocalService.updateAsset(userId, litigation,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	@Override
	public java.util.List<java.lang.Object[]> getLatestLitigation(
		long rootLitigationId) {
		return _litigationLocalService.getLatestLitigation(rootLitigationId);
	}

	/**
	* @param trademarkId
	* @param country
	* @return
	*/
	@Override
	public java.util.List<java.lang.Object[]> getLatestLitigationsByTrademarkId(
		long trademarkId) {
		return _litigationLocalService.getLatestLitigationsByTrademarkId(trademarkId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LitigationLocalService getWrappedLitigationLocalService() {
		return _litigationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLitigationLocalService(
		LitigationLocalService litigationLocalService) {
		_litigationLocalService = litigationLocalService;
	}

	@Override
	public LitigationLocalService getWrappedService() {
		return _litigationLocalService;
	}

	@Override
	public void setWrappedService(LitigationLocalService litigationLocalService) {
		_litigationLocalService = litigationLocalService;
	}

	private LitigationLocalService _litigationLocalService;
}