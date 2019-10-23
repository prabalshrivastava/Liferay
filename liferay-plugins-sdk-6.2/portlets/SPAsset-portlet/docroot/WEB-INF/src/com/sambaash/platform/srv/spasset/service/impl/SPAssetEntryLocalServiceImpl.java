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

package com.sambaash.platform.srv.spasset.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ModelHintsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryBaseImpl;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.base.SPAssetEntryLocalServiceBaseImpl;
import com.sambaash.platform.util.SPAssetConstants;

/**
 * The implementation of the s p asset entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.spasset.service.base.SPAssetEntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil
 */
public class SPAssetEntryLocalServiceImpl extends
		SPAssetEntryLocalServiceBaseImpl {

	public SPAssetEntry addSPAssetEntry(long groupId, long companyId,
			long userId, long spAssetTypeId, String spAssetEntrySubType,
			long coverFileEntryId, long classNameId, String title,
			String description, String content, String link, boolean status,
			String statusByUserName, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		SPAssetEntry spAssetEntry = spAssetEntryPersistence
				.create(counterLocalService.increment("SPAssetEntry.class"));

		Folder spAssetEntryFolder = null;

		long spAssetFolderId = DLAppServiceUtil.getFolder(groupId, 0,
				SPAssetConstants.SPASSET_ROOT_FOLDER_NAME).getFolderId();

		long spAssetTypeFolderId = DLAppServiceUtil.getFolder(groupId,
				spAssetFolderId, String.valueOf(spAssetTypeId)).getFolderId();

		spAssetEntryFolder = DLAppServiceUtil.addFolder(groupId,
				spAssetTypeFolderId,
				String.valueOf(spAssetEntry.getSpAssetEntryId()), title,
				serviceContext);
		spAssetEntry.setGroupId(groupId);
		spAssetEntry.setCompanyId(companyId);
		spAssetEntry.setUserId(userId);
		spAssetEntry.setUserName(user.getFullName());
		spAssetEntry.setCreateDate(serviceContext.getCreateDate(now));
		spAssetEntry.setModifiedDate(serviceContext.getModifiedDate(now));

		spAssetEntry.setModifiedBy(user.getFullName());
		spAssetEntry.setDlFolderId(spAssetEntryFolder.getFolderId());
		spAssetEntry.setCoverFileEntryId(coverFileEntryId);
		spAssetEntry.setSpAssetEntrySubType(spAssetEntrySubType);
		spAssetEntry.setCorporateProfileUserId(userId);
		spAssetEntry.setClassNameId(classNameId);
		spAssetEntry.setTitle(title);
		spAssetEntry.setUrlTitle(title);
		spAssetEntry.setSpAssetTypeId(spAssetTypeId);
		spAssetEntry.setDescription(description);
		spAssetEntry.setContent(content);
		spAssetEntry.setLink(link);
		spAssetEntry.setStatus(status);
		spAssetEntry.setStatusByUserName(user.getFullName());

		spAssetEntryPersistence.update(spAssetEntry);

		updateAsset(userId, spAssetEntry, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());

		updateSPAssetEntryIndexer(spAssetEntry);

		return spAssetEntry;

	}

	public SPAssetEntry updateSpAssetEntry(long spAssetEntryId, long groupId,
			long companyId, long userId, long spAssetTypeId,
			String spAssetEntrySubType, long coverFileEntryId,
			long classNameId, String title, String description, String content,
			String link, boolean status, String statusByUserName,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		SPAssetEntry spAssetEntry = spAssetEntryPersistence
				.fetchByPrimaryKey(spAssetEntryId);

		// fill the data in persistance object

		spAssetEntry.setGroupId(groupId);
		spAssetEntry.setCompanyId(companyId);
		spAssetEntry.setUserId(userId);
		spAssetEntry.setUserName(user.getFullName());
		spAssetEntry.setCreateDate(serviceContext.getCreateDate(now));
		spAssetEntry.setModifiedDate(serviceContext.getModifiedDate(now));

		spAssetEntry.setModifiedBy(user.getFullName());
		spAssetEntry.setDlFolderId(spAssetEntry.getDlFolderId());
		spAssetEntry.setCoverFileEntryId(coverFileEntryId);
		spAssetEntry.setSpAssetEntrySubType(spAssetEntrySubType);
		spAssetEntry.setCorporateProfileUserId(userId);
		spAssetEntry.setClassNameId(classNameId);
		spAssetEntry.setTitle(title);
		spAssetEntry.setUrlTitle(title);
		spAssetEntry.setSpAssetTypeId(spAssetTypeId);
		spAssetEntry.setDescription(description);
		spAssetEntry.setContent(content);
		spAssetEntry.setLink(link);
		spAssetEntry.setStatus(status);
		spAssetEntry.setStatusByUserName(user.getFullName());

		spAssetEntryPersistence.update(spAssetEntry);

		updateAsset(userId, spAssetEntry, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());

		Indexer indexer = IndexerRegistryUtil.getIndexer(SPAssetEntry.class);
		try {
			indexer.reindex(spAssetEntry);
		} catch (SearchException e) {
			_log.error(e.getMessage());
		}

		// Adding social activity
		// SocialActivityLocalServiceUtil.addActivity(userId, groupId,
		// SPAssetEntry.class.getName(), spAssetEntryId,
		// SPAssetActivityKeys.UPDATE_ENTRY, StringPool.BLANK, 0);

		// SocialActivityLocalServiceUtil.addActivity(userId, groupId,
		// SPAssetEntry.class.getName(), spAssetEntryId,
		// Integer.parseInt(SPAssetConstants.ACTION_KEY_ADD), "", 0);

		return spAssetEntry;

	}

	public List<SPAssetEntry> findBySpAssetEntries(long groupId,
			long spAssetTypeId) throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeId(spAssetTypeId,
				groupId);

	}

	public List<SPAssetEntry> findBySpAssetEntries(long groupId,
			long spAssetTypeId, int start, int end) throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeId(spAssetTypeId,
				groupId, start, end);

	}

	public List<SPAssetEntry> findBySpAssetEntriesStatus(long groupId,
			long spAssetTypeId, boolean status) throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeIdStatus(spAssetTypeId,
				groupId, status);

	}

	public int countBySpAssetEntries(long spAssetTypeId, long groupId)
			throws SystemException {
		return spAssetEntryPersistence.countBySpAssetTypeId(spAssetTypeId,
				groupId);

	}


	public ArrayList<String> fetchSPAssetEntryDBColNames() {
		ArrayList<String> dbColNamesList = new ArrayList<String>();
		Object[][] tableColumns = SPAssetEntryBaseImpl.TABLE_COLUMNS;

		for (Object[] outerArray : tableColumns) {
			dbColNamesList.add((String) outerArray[0]);
		}

		return dbColNamesList;
	}

	public ArrayList<SPAssetEntry> fetchSPAssetEntriesByDLFolderId(long folderId) {
		ArrayList<SPAssetEntry> spAssetEntryList = new ArrayList<SPAssetEntry>();

		return spAssetEntryList;
	}

	public List<SPAssetEntry> findBySpAssetTypeIdStatus(long spAssetTypeId,
			long groupId, boolean status) throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeIdStatus(spAssetTypeId,
				groupId, status);
	}

	public List<SPAssetEntry> findBySpAssetTypeIdStatus(long spAssetTypeId,
			long groupId, int start, int end, boolean status)
			throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeIdStatus(spAssetTypeId,
				groupId, status, start, end);
	}

	public List<SPAssetEntry> findBySpAssetTypeIdStatus(long spAssetTypeId,
			long groupId, boolean status, int start, int end,
			OrderByComparator orderByComparator)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeIdStatus(spAssetTypeId,
				groupId, status, start, end, orderByComparator);
	}

	public int countBySpAssetTypeIdStatus(long spAssetTypeId, long groupId,
			boolean status) throws SystemException {
		return spAssetEntryPersistence.countBySpAssetTypeIdStatus(
				spAssetTypeId, groupId, status);
	}

	public List<SPAssetEntry> findBySpAssetTypeId(long spAssetTypeId,
			long groupId) throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeId(spAssetTypeId,
				groupId);
	}

	public List<SPAssetEntry> findBySpAssetTypeId(long spAssetTypeId,
			long groupId, int start, int end) throws SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeId(spAssetTypeId,
				groupId, start, end);
	}

	public List<SPAssetEntry> findBySpAssetTypeId(long spAssetTypeId,
			long groupId, int start, int end,
			OrderByComparator orderByComparator)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spAssetEntryPersistence.findBySpAssetTypeId(spAssetTypeId,
				groupId, start, end, orderByComparator);
	}

	public int countBySpAssetTypeId(long spAssetTypeId, long groupId)
			throws SystemException {
		return spAssetEntryPersistence.countBySpAssetTypeId(spAssetTypeId,
				groupId);
	}

	public DLFileEntry findByUUID_G(long groupId, String coverPicId)
			throws NoSuchFileEntryException, SystemException {
		DLFileEntry dlFileEntry = dlFileEntryPersistence.findByUUID_G(
				coverPicId, groupId);
		return dlFileEntry;
	}

	public SPAssetEntry getSPAssetEntryByUrlTitle(String urlTitle, long groupId) {
		SPAssetEntry _assetEntry = null;

		try {
			_assetEntry = spAssetEntryPersistence.fetchByurlTitle(urlTitle,
					groupId);
		} catch (SystemException e) {
			_log.error(e);
		}
		return _assetEntry;
	}

	public String getUniqueUrlTitle(long assetEntryId, long groupId,
			String title) {
		String urlTitle = FriendlyURLNormalizerUtil.normalize(title,
				_friendlyURLPattern);
		String newUrlTitle = ModelHintsUtil.trimString(
				SPAssetEntry.class.getName(), "urlTitle", urlTitle);

		while (newUrlTitle.endsWith("-")) {
			newUrlTitle = newUrlTitle.substring(0, newUrlTitle.length() - 1);
		}

		try {
			for (int i = 1;; i++) {
				SPAssetEntry _assetEntry = spAssetEntryPersistence
						.fetchByurlTitle(newUrlTitle, groupId);
				if (_assetEntry == null
						|| _assetEntry.getSpAssetEntryId() == assetEntryId) {
					break;
				}
				String suffix = StringPool.DASH + i;
				String prefix = newUrlTitle;

				if (newUrlTitle.length() > suffix.length()) {
					prefix = newUrlTitle.substring(0, newUrlTitle.length()
							- suffix.length());
				}
				newUrlTitle = prefix + suffix;
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return newUrlTitle;
	}

	public SPAssetEntry addAssetEntry(SPAssetEntry spAssetEntry,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		SPAssetEntry _spAssetEntry = SPAssetEntryLocalServiceUtil
				.addSPAssetEntry(spAssetEntry);

		if (serviceContext != null) {
			AssetEntryLocalServiceUtil.updateEntry(_spAssetEntry.getUserId(),
					_spAssetEntry.getGroupId(), SPAssetEntry.class.getName(),
					_spAssetEntry.getSpAssetEntryId(),
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());
			updateSPAssetEntryIndexer(spAssetEntry);
		}
		return _spAssetEntry;
	}

	public SPAssetEntry updateAssetEntry(SPAssetEntry spAssetEntry,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		SPAssetEntry _spAssetEntry = SPAssetEntryLocalServiceUtil
				.updateSPAssetEntry(spAssetEntry);
		if (serviceContext != null) {
			AssetEntryLocalServiceUtil.updateEntry(_spAssetEntry.getUserId(),
					_spAssetEntry.getGroupId(), SPAssetEntry.class.getName(),
					_spAssetEntry.getSpAssetEntryId(),
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());
			updateSPAssetEntryIndexer(spAssetEntry);
		}
		return _spAssetEntry;
	}

	public void updateModelResources(SPAssetEntry spAssetEntry,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		ResourceLocalServiceUtil.updateResources(spAssetEntry.getCompanyId(),
				spAssetEntry.getGroupId(), SPAssetEntry.class.getName(),
				spAssetEntry.getSpAssetEntryId(),
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
	}

	public void addModelResource(SPAssetEntry spAssetEntry,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		ResourceLocalServiceUtil.addModelResources(spAssetEntry.getCompanyId(),
				spAssetEntry.getGroupId(), spAssetEntry.getUserId(),
				SPAssetEntry.class.getName(), spAssetEntry.getSpAssetEntryId(),
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
	}

	public void updateSPAssetEntryStatus(SPAssetEntry spAssetEntry, User user)
			throws SystemException {
		spAssetEntry.setStatus(false);
		spAssetEntry.setModifiedDate(new Date());
		spAssetEntryLocalService.updateSPAssetEntry(spAssetEntry);
		deleteSPAssetEntryIndexer(spAssetEntry);
	}

	private void updateSPAssetEntryIndexer(SPAssetEntry spAssetEntry) {
		Indexer indexer = IndexerRegistryUtil.getIndexer(SPAssetEntry.class
				.getName());
		try {
			indexer.reindex(spAssetEntry);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
	}

	private void deleteSPAssetEntryIndexer(SPAssetEntry spAssetEntry) {
		Indexer indexer = IndexerRegistryUtil.getIndexer(SPAssetEntry.class
				.getName());
		try {
			indexer.delete(spAssetEntry);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public java.util.List<DLFileEntry> findSPAssetFileEntriesForGuest(
			long groupId, long spAssetTypeId, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spAssetEntryFinder.findSPAssetFileEntriesForGuest(groupId,
				spAssetTypeId, start, end);

	}

	public java.util.List<DLFileEntry> findSPAssetFileEntries(long groupId,
			long spAssetTypeId, long signedinUserId, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spAssetEntryFinder.findSPAssetFileEntries(groupId,
				spAssetTypeId, signedinUserId, start, end);
	}

	public void updateAsset(long userId, SPAssetEntry spAssetEntry,
			long[] assetCategoryIds, String[] assetTagNames)
			throws PortalException, SystemException {
		AssetEntryLocalServiceUtil.updateEntry(spAssetEntry.getUserId(),
				spAssetEntry.getGroupId(), SPAssetEntry.class.getName(),
				spAssetEntry.getSpAssetEntryId(), assetCategoryIds,
				assetTagNames);
	}

	private static Pattern _friendlyURLPattern = Pattern.compile("[^a-z0-9_-]");

	private static Log _log = LogFactoryUtil
			.getLog(SPAssetEntryLocalServiceImpl.class);

}