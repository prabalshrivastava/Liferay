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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPAssetEntryLocalService}.
 *
 * @author harini
 * @see SPAssetEntryLocalService
 * @generated
 */
public class SPAssetEntryLocalServiceWrapper implements SPAssetEntryLocalService,
	ServiceWrapper<SPAssetEntryLocalService> {
	public SPAssetEntryLocalServiceWrapper(
		SPAssetEntryLocalService spAssetEntryLocalService) {
		_spAssetEntryLocalService = spAssetEntryLocalService;
	}

	/**
	* Adds the s p asset entry to the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntry the s p asset entry
	* @return the s p asset entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry addSPAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.addSPAssetEntry(spAssetEntry);
	}

	/**
	* Creates a new s p asset entry with the primary key. Does not add the s p asset entry to the database.
	*
	* @param spAssetEntryId the primary key for the new s p asset entry
	* @return the new s p asset entry
	*/
	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry createSPAssetEntry(
		long spAssetEntryId) {
		return _spAssetEntryLocalService.createSPAssetEntry(spAssetEntryId);
	}

	/**
	* Deletes the s p asset entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry that was removed
	* @throws PortalException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry deleteSPAssetEntry(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.deleteSPAssetEntry(spAssetEntryId);
	}

	/**
	* Deletes the s p asset entry from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntry the s p asset entry
	* @return the s p asset entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry deleteSPAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.deleteSPAssetEntry(spAssetEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spAssetEntryLocalService.dynamicQuery();
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
		return _spAssetEntryLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spAssetEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spAssetEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry fetchSPAssetEntry(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.fetchSPAssetEntry(spAssetEntryId);
	}

	/**
	* Returns the s p asset entry with the primary key.
	*
	* @param spAssetEntryId the primary key of the s p asset entry
	* @return the s p asset entry
	* @throws PortalException if a s p asset entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry getSPAssetEntry(
		long spAssetEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.getSPAssetEntry(spAssetEntryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> getSPAssetEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.getSPAssetEntries(start, end);
	}

	/**
	* Returns the number of s p asset entries.
	*
	* @return the number of s p asset entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPAssetEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.getSPAssetEntriesCount();
	}

	/**
	* Updates the s p asset entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spAssetEntry the s p asset entry
	* @return the s p asset entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry updateSPAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.updateSPAssetEntry(spAssetEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAssetEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAssetEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAssetEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry addSPAssetEntry(
		long groupId, long companyId, long userId, long spAssetTypeId,
		java.lang.String spAssetEntrySubType, long coverFileEntryId,
		long classNameId, java.lang.String title, java.lang.String description,
		java.lang.String content, java.lang.String link, boolean status,
		java.lang.String statusByUserName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.addSPAssetEntry(groupId, companyId,
			userId, spAssetTypeId, spAssetEntrySubType, coverFileEntryId,
			classNameId, title, description, content, link, status,
			statusByUserName, serviceContext);
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry updateSpAssetEntry(
		long spAssetEntryId, long groupId, long companyId, long userId,
		long spAssetTypeId, java.lang.String spAssetEntrySubType,
		long coverFileEntryId, long classNameId, java.lang.String title,
		java.lang.String description, java.lang.String content,
		java.lang.String link, boolean status,
		java.lang.String statusByUserName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.updateSpAssetEntry(spAssetEntryId,
			groupId, companyId, userId, spAssetTypeId, spAssetEntrySubType,
			coverFileEntryId, classNameId, title, description, content, link,
			status, statusByUserName, serviceContext);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetEntries(
		long groupId, long spAssetTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetEntries(groupId,
			spAssetTypeId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetEntries(
		long groupId, long spAssetTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetEntries(groupId,
			spAssetTypeId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetEntriesStatus(
		long groupId, long spAssetTypeId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetEntriesStatus(groupId,
			spAssetTypeId, status);
	}

	@Override
	public int countBySpAssetEntries(long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.countBySpAssetEntries(spAssetTypeId,
			groupId);
	}

	@Override
	public java.util.ArrayList<java.lang.String> fetchSPAssetEntryDBColNames() {
		return _spAssetEntryLocalService.fetchSPAssetEntryDBColNames();
	}

	@Override
	public java.util.ArrayList<com.sambaash.platform.srv.spasset.model.SPAssetEntry> fetchSPAssetEntriesByDLFolderId(
		long folderId) {
		return _spAssetEntryLocalService.fetchSPAssetEntriesByDLFolderId(folderId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetTypeIdStatus(spAssetTypeId,
			groupId, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, int start, int end, boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetTypeIdStatus(spAssetTypeId,
			groupId, start, end, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetTypeIdStatus(spAssetTypeId,
			groupId, status, start, end, orderByComparator);
	}

	@Override
	public int countBySpAssetTypeIdStatus(long spAssetTypeId, long groupId,
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.countBySpAssetTypeIdStatus(spAssetTypeId,
			groupId, status);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetTypeId(spAssetTypeId,
			groupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetTypeId(spAssetTypeId,
			groupId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spasset.model.SPAssetEntry> findBySpAssetTypeId(
		long spAssetTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findBySpAssetTypeId(spAssetTypeId,
			groupId, start, end, orderByComparator);
	}

	@Override
	public int countBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.countBySpAssetTypeId(spAssetTypeId,
			groupId);
	}

	@Override
	public com.liferay.portlet.documentlibrary.model.DLFileEntry findByUUID_G(
		long groupId, java.lang.String coverPicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileEntryException {
		return _spAssetEntryLocalService.findByUUID_G(groupId, coverPicId);
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry getSPAssetEntryByUrlTitle(
		java.lang.String urlTitle, long groupId) {
		return _spAssetEntryLocalService.getSPAssetEntryByUrlTitle(urlTitle,
			groupId);
	}

	@Override
	public java.lang.String getUniqueUrlTitle(long assetEntryId, long groupId,
		java.lang.String title) {
		return _spAssetEntryLocalService.getUniqueUrlTitle(assetEntryId,
			groupId, title);
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry addAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.addAssetEntry(spAssetEntry,
			serviceContext);
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry updateAssetEntry(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.updateAssetEntry(spAssetEntry,
			serviceContext);
	}

	@Override
	public void updateModelResources(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spAssetEntryLocalService.updateModelResources(spAssetEntry,
			serviceContext);
	}

	@Override
	public void addModelResource(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spAssetEntryLocalService.addModelResource(spAssetEntry, serviceContext);
	}

	@Override
	public void updateSPAssetEntryStatus(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		_spAssetEntryLocalService.updateSPAssetEntryStatus(spAssetEntry, user);
	}

	@Override
	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> findSPAssetFileEntriesForGuest(
		long groupId, long spAssetTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findSPAssetFileEntriesForGuest(groupId,
			spAssetTypeId, start, end);
	}

	@Override
	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> findSPAssetFileEntries(
		long groupId, long spAssetTypeId, long signedinUserId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntryLocalService.findSPAssetFileEntries(groupId,
			spAssetTypeId, signedinUserId, start, end);
	}

	@Override
	public void updateAsset(long userId,
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		long[] assetCategoryIds, java.lang.String[] assetTagNames)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spAssetEntryLocalService.updateAsset(userId, spAssetEntry,
			assetCategoryIds, assetTagNames);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPAssetEntryLocalService getWrappedSPAssetEntryLocalService() {
		return _spAssetEntryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPAssetEntryLocalService(
		SPAssetEntryLocalService spAssetEntryLocalService) {
		_spAssetEntryLocalService = spAssetEntryLocalService;
	}

	@Override
	public SPAssetEntryLocalService getWrappedService() {
		return _spAssetEntryLocalService;
	}

	@Override
	public void setWrappedService(
		SPAssetEntryLocalService spAssetEntryLocalService) {
		_spAssetEntryLocalService = spAssetEntryLocalService;
	}

	private SPAssetEntryLocalService _spAssetEntryLocalService;
}