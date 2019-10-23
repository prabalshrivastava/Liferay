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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.video.model.VideoFileEntry;

/**
 * The persistence interface for the video file entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see VideoFileEntryPersistenceImpl
 * @see VideoFileEntryUtil
 * @generated
 */
public interface VideoFileEntryPersistence extends BasePersistence<VideoFileEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoFileEntryUtil} to access the video file entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or throws a {@link com.sambaash.platform.srv.video.NoSuchVideoFileEntryException} if it could not be found.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the matching video file entry
	* @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a matching video file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry findByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException;

	/**
	* Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the matching video file entry, or <code>null</code> if a matching video file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry fetchByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching video file entry, or <code>null</code> if a matching video file entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry fetchByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the video file entry where fileEntryId = &#63; and fileVersionId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the video file entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry removeByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException;

	/**
	* Returns the number of video file entries where fileEntryId = &#63; and fileVersionId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param fileVersionId the file version ID
	* @return the number of matching video file entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the video file entry in the entity cache if it is enabled.
	*
	* @param videoFileEntry the video file entry
	*/
	public void cacheResult(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry);

	/**
	* Caches the video file entries in the entity cache if it is enabled.
	*
	* @param videoFileEntries the video file entries
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> videoFileEntries);

	/**
	* Creates a new video file entry with the primary key. Does not add the video file entry to the database.
	*
	* @param spVideoFileEntryId the primary key for the new video file entry
	* @return the new video file entry
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry create(
		long spVideoFileEntryId);

	/**
	* Removes the video file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry that was removed
	* @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry remove(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException;

	public com.sambaash.platform.srv.video.model.VideoFileEntry updateImpl(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video file entry with the primary key or throws a {@link com.sambaash.platform.srv.video.NoSuchVideoFileEntryException} if it could not be found.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry
	* @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry findByPrimaryKey(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.video.NoSuchVideoFileEntryException;

	/**
	* Returns the video file entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry, or <code>null</code> if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.video.model.VideoFileEntry fetchByPrimaryKey(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video file entries.
	*
	* @return the video file entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video file entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video file entries.
	*
	* @return the number of video file entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}