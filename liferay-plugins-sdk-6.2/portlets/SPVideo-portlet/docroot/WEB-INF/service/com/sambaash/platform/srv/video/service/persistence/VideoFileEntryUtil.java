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

package com.sambaash.platform.srv.video.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.video.model.VideoFileEntry;

import java.util.List;

/**
 * The persistence utility for the video file entry service. This utility wraps {@link VideoFileEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see VideoFileEntryPersistence
 * @see VideoFileEntryPersistenceImpl
 * @generated
 */
public class VideoFileEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VideoFileEntry videoFileEntry) {
		getPersistence().clearCache(videoFileEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VideoFileEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoFileEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoFileEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VideoFileEntry update(VideoFileEntry videoFileEntry)
		throws SystemException {
		return getPersistence().update(videoFileEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VideoFileEntry update(VideoFileEntry videoFileEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoFileEntry, serviceContext);
	}

	/**
	* Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or throws a {@link com.sambaash.platform.srv.video.NoSuchVideoFileEntryException} if it could not be found.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the matching video file entry
	* @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a matching video file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry findByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException {
		return getPersistence()
				   .findByFileEntryAndFileVersion(fileEntryId, fileVersionId);
	}

	/**
	* Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the matching video file entry, or <code>null</code> if a matching video file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry fetchByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileEntryAndFileVersion(fileEntryId, fileVersionId);
	}

	/**
	* Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching video file entry, or <code>null</code> if a matching video file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry fetchByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileEntryAndFileVersion(fileEntryId, fileVersionId,
			retrieveFromCache);
	}

	/**
	* Removes the video file entry where fileEntryId = &#63; and fileVersionId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the video file entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry removeByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException {
		return getPersistence()
				   .removeByFileEntryAndFileVersion(fileEntryId, fileVersionId);
	}

	/**
	* Returns the number of video file entries where fileEntryId = &#63; and fileVersionId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the number of matching video file entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFileEntryAndFileVersion(fileEntryId, fileVersionId);
	}

	/**
	* Caches the video file entry in the entity cache if it is enabled.
	*
	* @param videoFileEntry the video file entry
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry) {
		getPersistence().cacheResult(videoFileEntry);
	}

	/**
	* Caches the video file entries in the entity cache if it is enabled.
	*
	* @param videoFileEntries the video file entries
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> videoFileEntries) {
		getPersistence().cacheResult(videoFileEntries);
	}

	/**
	* Creates a new video file entry with the primary key. Does not add the video file entry to the database.
	*
	* @param spVideoFileEntryId the primary key for the new video file entry
	* @return the new video file entry
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry create(
		long spVideoFileEntryId) {
		return getPersistence().create(spVideoFileEntryId);
	}

	/**
	* Removes the video file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry that was removed
	* @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry remove(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException {
		return getPersistence().remove(spVideoFileEntryId);
	}

	public static com.sambaash.platform.srv.video.model.VideoFileEntry updateImpl(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoFileEntry);
	}

	/**
	* Returns the video file entry with the primary key or throws a {@link com.sambaash.platform.srv.video.NoSuchVideoFileEntryException} if it could not be found.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry
	* @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry findByPrimaryKey(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException {
		return getPersistence().findByPrimaryKey(spVideoFileEntryId);
	}

	/**
	* Returns the video file entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry, or <code>null</code> if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry fetchByPrimaryKey(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spVideoFileEntryId);
	}

	/**
	* Returns all the video file entries.
	*
	* @return the video file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video file entries
	* @param end the upper bound of the range of video file entries (not inclusive)
	* @return the range of video file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video file entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video file entries
	* @param end the upper bound of the range of video file entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video file entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video file entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video file entries.
	*
	* @return the number of video file entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoFileEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoFileEntryPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.video.service.ClpSerializer.getServletContextName(),
					VideoFileEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoFileEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VideoFileEntryPersistence persistence) {
	}

	private static VideoFileEntryPersistence _persistence;
}