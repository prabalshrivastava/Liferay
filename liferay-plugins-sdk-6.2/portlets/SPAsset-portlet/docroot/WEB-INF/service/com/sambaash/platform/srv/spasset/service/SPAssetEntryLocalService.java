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

package com.sambaash.platform.srv.spasset.service;

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
 * Provides the local service interface for SPAssetEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author harini
 * @see SPAssetEntryLocalServiceUtil
 * @see com.sambaash.platform.srv.spasset.service.base.SPAssetEntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spasset.service.impl.SPAssetEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPAssetEntryLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPAssetEntryLocalServiceUtil} to access the s p asset entry local service. Add custom service methods to {@link com.sambaash.platform.srv.spasset.service.impl.SPAssetEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the s p asset entry to the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntry the s p asset entry
	* @return the s p asset entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry addSPAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new s p asset entry with the primary key. Does not add the s p asset entry to the database.
	*
	* @param spAssetEntryId the primary key for the new s p asset entry
	* @return the new s p asset entry
	*/
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry createSPAssetEntry(
		long spAssetEntryId);

	/**
	* Deletes the s p asset entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry that was removed
	* @throws PortalException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry deleteSPAssetEntry(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the s p asset entry from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntry the s p asset entry
	* @return the s p asset entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry deleteSPAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchSPAssetEntry(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p asset entry with the primary key.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry
	* @throws PortalException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry getSPAssetEntry(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p asset entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p asset entries
	* @param end the upper bound of the range of s p asset entries (not inclusive)
	* @return the range of s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> getSPAssetEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p asset entries.
	*
	* @return the number of s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSPAssetEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the s p asset entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntry the s p asset entry
	* @return the s p asset entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry updateSPAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
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

	public com.sambaash.platform.srv.spasset.model.SPAssetEntry addSPAssetEntry(
		long groupId, long companyId, long userId, long spAssetTypeId,
		java.lang.String spAssetEntrySubType, long coverFileEntryId,
		long classNameId, java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String link, boolean status,
		java.lang.String statusByUserName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spasset.model.SPAssetEntry updateSpAssetEntry(
		long spAssetEntryId, long groupId, long companyId, long userId,
		long spAssetTypeId, java.lang.String spAssetEntrySubType,
		long coverFileEntryId, long classNameId, java.lang.String title,
		java.lang.String description, java.lang.String content,
		java.lang.String link, boolean status,
		java.lang.String statusByUserName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetEntries(
		long groupId, long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetEntries(
		long groupId, long spAssetTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetEntriesStatus(
		long groupId, long spAssetTypeId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySpAssetEntries(long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.ArrayList<java.lang.String> fetchSPAssetEntryDBColNames();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.ArrayList<com.sambaash.platform.srv.spasset.model.SPAssetEntry> fetchSPAssetEntriesByDLFolderId(
		long folderId);

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, int start, int end, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySpAssetTypeIdStatus(long spAssetTypeId, long groupId,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.documentlibrary.model.DLFileEntry findByUUID_G(
		long groupId, java.lang.String coverPicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileEntryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry getSPAssetEntryByUrlTitle(
		java.lang.String urlTitle, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUniqueUrlTitle(long assetEntryId, long groupId,
		java.lang.String title);

	public com.sambaash.platform.srv.spasset.model.SPAssetEntry addAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spasset.model.SPAssetEntry updateAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateModelResources(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addModelResource(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateSPAssetEntryStatus(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> findSPAssetFileEntriesForGuest(
		long groupId, long spAssetTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> findSPAssetFileEntries(
		long groupId, long spAssetTypeId, long signedinUserId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public void updateAsset(long userId,
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		long[] assetCategoryIds, java.lang.String[] assetTagNames)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}