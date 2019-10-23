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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Litigation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author nareshchebolu
 * @see LitigationLocalServiceUtil
 * @see com.sambaash.platform.srv.legalandcontract.service.base.LitigationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.impl.LitigationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LitigationLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LitigationLocalServiceUtil} to access the litigation local service. Add custom service methods to {@link com.sambaash.platform.srv.legalandcontract.service.impl.LitigationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the litigation to the database. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation addLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new litigation with the primary key. Does not add the litigation to the database.
	*
	* @param spLitigationId the primary key for the new litigation
	* @return the new litigation
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation createLitigation(
		long spLitigationId);

	/**
	* Deletes the litigation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation that was removed
	* @throws PortalException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation deleteLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the litigation from the database. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation deleteLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation with the matching UUID and company.
	*
	* @param uuid the litigation's UUID
	* @param companyId the primary key of the company
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation matching the UUID and group.
	*
	* @param uuid the litigation's UUID
	* @param groupId the primary key of the group
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchLitigationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation with the primary key.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation
	* @throws PortalException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigation(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation with the matching UUID and company.
	*
	* @param uuid the litigation's UUID
	* @param companyId the primary key of the company
	* @return the matching litigation
	* @throws PortalException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation matching the UUID and group.
	*
	* @param uuid the litigation's UUID
	* @param groupId the primary key of the group
	* @return the matching litigation
	* @throws PortalException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getLitigationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> getLitigations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of litigations.
	*
	* @return the number of litigations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLitigationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the litigation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param litigation the litigation
	* @return the litigation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation updateLitigation(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void addNewLitigationVersion(long userId, long oldLitigationId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation newLitigation,
		long[] assetCategoryIds);

	public void addNewLitigationVersion(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation oldLitigation,
		com.sambaash.platform.srv.legalandcontract.model.Litigation newLitigation,
		long[] assetCategoryIds);

	public void addNewLitigation(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds);

	public void reIndex(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation);

	public void reIndexTrademark(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks);

	public void addLitigation(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.legalandcontract.model.Litigation getNewLitigation()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateAsset(long userId,
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Object[]> getLatestLitigation(
		long rootLitigationId);

	/**
	* @param trademarkId
	* @param country
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Object[]> getLatestLitigationsByTrademarkId(
		long trademarkId);
}