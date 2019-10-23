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

package com.sambaash.platform.srv.spgroup.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelHintsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.model.notification.NotificationForm;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.SPGroupDescriptionException;
import com.sambaash.platform.srv.spgroup.SPGroupImageNameException;
import com.sambaash.platform.srv.spgroup.SPGroupImageSizeException;
import com.sambaash.platform.srv.spgroup.SPGroupTitleException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.service.base.SPGroupLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the s p group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SPGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.service.base.SPGroupLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SPGroupLocalServiceUtil
 */
public class SPGroupLocalServiceImpl extends SPGroupLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SPGroupLocalServiceUtil} to
	 * access the s p group local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(SPGroupLocalServiceImpl.class);

	public List<SPGroup> findByUserIdAndStatus(long userId, int status)
			throws SystemException {
		return spGroupPersistence.findByUserIdAndStatus(userId, status);
	}

	public List<SPGroup> findByUserIdAndStatus(long userId, int status,
			int start, int end) throws SystemException {
		return spGroupPersistence.findByUserIdAndStatus(userId, status, start,
				end);
	}

	public List<SPGroup> findByUserIdAndStatus(long userId, int status,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		return spGroupPersistence.findByUserIdAndStatus(userId, status, start,
				end, orderByComparator);
	}

	public SPGroup findByUserIdAndStatus_First(long userId, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchSPGroupException {
		return spGroupPersistence.findByUserIdAndStatus_First(userId, status,
				orderByComparator);
	}

	public SPGroup findByUserIdAndStatus_Last(long userId, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchSPGroupException {
		return spGroupPersistence.findByUserIdAndStatus_Last(userId, status,
				orderByComparator);
	}

	public SPGroup[] findByUserIdAndStatus_PrevAndNext(long spGroupId,
			long userId, int status, OrderByComparator orderByComparator)
			throws SystemException, NoSuchSPGroupException {
		return spGroupPersistence.findByUserIdAndStatus_PrevAndNext(spGroupId,
				userId, status, orderByComparator);
	}

	public SPGroup findByURLTitleAndGroupId(long groupId,
			String urlTitle) throws SystemException,
			NoSuchSPGroupException {
		return spGroupPersistence.findByURLTitleAndGroupId(groupId, urlTitle);
	}

	public SPGroup fetchByURLTitleAndGroupId(long groupId,
			String urlTitle) throws SystemException {
		return spGroupPersistence.fetchByURLTitleAndGroupId(groupId, urlTitle);
	}

	public SPGroup fetchByURLTitleAndGroupId(long groupId,
			String urlTitle, boolean retrieveFromCache)
			throws SystemException {
		return spGroupPersistence.fetchByURLTitleAndGroupId(groupId, urlTitle,
				retrieveFromCache);
	}

	public List<SPGroup> findByTypeAndStatus(int type, int status)
			throws SystemException {
		return spGroupPersistence.findByTypeAndStatus(type, status);
	}

	public List<SPGroup> findByTypeAndStatus(int type, int status, int start,
			int end) throws SystemException {
		return spGroupPersistence.findByTypeAndStatus(type, status, start, end);
	}

	public List<SPGroup> findByTypeAndStatus(int type, int status, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		return spGroupPersistence.findByTypeAndStatus(type, status, start, end,
				orderByComparator);
	}

	public SPGroup findByTypeAndStatus_First(int type, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchSPGroupException {
		return spGroupPersistence.findByTypeAndStatus_First(type, status,
				orderByComparator);
	}

	public SPGroup findByTypeAndStatus_Last(int type, int status,
			OrderByComparator orderByComparator) throws SystemException,
			NoSuchSPGroupException {
		return spGroupPersistence.findByTypeAndStatus_Last(type, status,
				orderByComparator);
	}

	public SPGroup[] findByTypeAndStatus_PrevAndNext(long spGroupId, int type,
			int status, OrderByComparator orderByComparator)
			throws SystemException, NoSuchSPGroupException {
		return spGroupPersistence.findByTypeAndStatus_PrevAndNext(spGroupId,
				type, status, orderByComparator);
	}

	public SPGroup addSPGroup(long userId, int type, String title,
			String description, int status, String imageFileName,
			InputStream imageInputStream, long imageMaxSize,
			String[] imageExtensions, ServiceContext serviceContext)
			throws PortalException, SystemException {

		// Entry

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		byte[] imageBytes = null;

		try {
			if (imageInputStream != null) {
				imageBytes = FileUtil.getBytes(imageInputStream);
			}
		} catch (IOException ioe) {
		}

		// mandatory

		if (imageBytes == null) {
			throw new SPGroupImageSizeException();
		}

		validate(title, description, imageFileName, imageBytes, imageMaxSize,
				imageExtensions);

		long spGroupId = counterLocalService.increment();

		SPGroup spGroup = spGroupPersistence.create(spGroupId);
		spGroup.setUuid(serviceContext.getUuid());
		spGroup.setGroupId(groupId);
		spGroup.setCompanyId(user.getCompanyId());
		spGroup.setUserId(user.getUserId());
		spGroup.setUserName(user.getFullName());
		spGroup.setType(type);
		spGroup.setCreateDate(serviceContext.getCreateDate(now));
		spGroup.setModifiedDate(serviceContext.getModifiedDate(now));
		spGroup.setTitle(title);
		spGroup.setUrlTitle(getUniqueUrlTitle(spGroupId, groupId, title));
		spGroup.setDescription(description);
		spGroup.setImageId(counterLocalService.increment());
		spGroup.setStatus(status);

		spGroupPersistence.update(spGroup);

		// Small image

		saveImages(spGroup.getImageId(), imageBytes);

		// Asset

		updateAsset(userId, spGroup, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		return spGroup;
	}

	public SPGroup updateSPGroup(long userId, long spGroupId, int type,
			String title, String description, int status, String imageFileName,
			InputStream imageInputStream, long imageMaxSize,
			String[] imageExtensions, ServiceContext serviceContext)
			throws PortalException, SystemException {

		// Entry

		byte[] imageBytes = null;

		try {
			if (imageInputStream != null) {
				imageBytes = FileUtil.getBytes(imageInputStream);
			}
		} catch (IOException ioe) {
		}

		validate(title, description, imageFileName, imageBytes, imageMaxSize,
				imageExtensions);

		SPGroup spGroup = spGroupPersistence.findByPrimaryKey(spGroupId);

		spGroup.setModifiedDate(serviceContext.getModifiedDate(null));
		spGroup.setType(type);
		spGroup.setTitle(title);
		spGroup.setUrlTitle(getUniqueUrlTitle(spGroupId, spGroup.getGroupId(),
				title));
		spGroup.setDescription(description);
		spGroup.setStatus(status);

		spGroup.setExpandoBridgeAttributes(serviceContext);

		spGroupPersistence.update(spGroup);

		// Small image

		long imageId = spGroup.getImageId();

		if (imageId == 0) {
			imageId = counterLocalService.increment();
		}

		saveImages(imageId, imageBytes);

		// Asset

		updateAsset(userId, spGroup, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		return spGroup;
	}

	public void updateAsset(long userId, SPGroup spGroup,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;

		String summary = HtmlUtil.extractText(StringUtil.shorten(
				spGroup.getDescription(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				spGroup.getGroupId(), SPGroup.class.getName(),
				spGroup.getSpGroupId(), spGroup.getUuid(), 0, assetCategoryIds,
				assetTagNames, visible, null, null, spGroup.getCreateDate(),
				null, ContentTypes.TEXT_HTML, spGroup.getTitle(), null,
				summary, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	public void sendSoicalNetworkInvitation(String[] snIdArray, String body)
			throws PortalException, SystemException {
	}

	private void saveImages(long imageId, byte[] imageBytes)
			throws PortalException, SystemException {
		if (imageBytes != null) {
			imageLocalService.updateImage(imageId, imageBytes);
		}
	}

	private void validate(String title, String description,
			String imageFileName, byte[] imageBytes, long imageMaxSize,
			String[] imageExtensions) throws PortalException, SystemException {

		if (Validator.isNull(title)) {
			throw new SPGroupTitleException();
		} else if (Validator.isNull(description)) {
			throw new SPGroupDescriptionException();
		}

		if (imageBytes != null) {
			if (imageFileName != null) {
				boolean validImageExtension = false;

				for (String _imageExtension : imageExtensions) {
					if (StringPool.STAR.equals(_imageExtension)
							|| StringUtil.endsWith(imageFileName,
									_imageExtension)) {

						validImageExtension = true;

						break;
					}
				}

				if (!validImageExtension) {
					throw new SPGroupImageNameException(imageFileName);
				}
			}

			if (imageBytes.length > imageMaxSize) {
				throw new SPGroupImageSizeException();
			}
		}
	}

	private String getUniqueUrlTitle(long spGroupId, long groupId, String title)
			throws SystemException {

		String urlTitle = getUrlTitle(spGroupId, title);

		String newUrlTitle = ModelHintsUtil.trimString(SPGroup.class.getName(),
				"urlTitle", urlTitle);

		for (int i = 1;; i++) {

			SPGroup spGroup = null;
			try {
				spGroup = spGroupPersistence.findByURLTitleAndGroupId(groupId,
						newUrlTitle);
			} catch (NoSuchSPGroupException e) {

				// do nothing

			}

			if ((spGroup == null) || (spGroup.getSpGroupId() == spGroupId)) {
				break;
			} else {
				String suffix = StringPool.DASH + i;

				String prefix = newUrlTitle;

				if (newUrlTitle.length() > suffix.length()) {
					prefix = newUrlTitle.substring(0, newUrlTitle.length()
							- suffix.length());
				}

				newUrlTitle = prefix + suffix;
			}
		}

		return newUrlTitle;
	}

	private String getUrlTitle(long entryId, String title) {
		title = title.trim().toLowerCase();

		if (Validator.isNull(title) || Validator.isNumber(title)
				|| title.equals("rss")) {

			return String.valueOf(entryId);
		} else {
			return FriendlyURLNormalizerUtil.normalize(title);
		}
	}

	public String pushRealtimeActivityFeed(NotificationForm notificationForm) {

		// Doing the REST call and then displaying the result This is code to
		// post and return a object

		try {
			RestTemplate rt = new RestTemplate();
			rt.getMessageConverters().add(
					new MappingJacksonHttpMessageConverter());
			rt.getMessageConverters().add(new StringHttpMessageConverter());

			String uri = new String(SambaashUtil.getWebSocketHostUrl()
					+ "/push_realtime_notifications");
			return rt.postForObject(uri, notificationForm, String.class);

		} catch (Exception ex) {
			_log.error(ex.getMessage());
		}

		return "";
	}

}