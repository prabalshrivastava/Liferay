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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.video.NoSuchVideoFileEntryException;
import com.sambaash.platform.srv.video.model.VideoFileEntry;
import com.sambaash.platform.srv.video.model.impl.VideoFileEntryImpl;
import com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video file entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see VideoFileEntryPersistence
 * @see VideoFileEntryUtil
 * @generated
 */
public class VideoFileEntryPersistenceImpl extends BasePersistenceImpl<VideoFileEntry>
	implements VideoFileEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoFileEntryUtil} to access the video file entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoFileEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoFileEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoFileEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION = new FinderPath(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoFileEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFileEntryAndFileVersion",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoFileEntryModelImpl.FILEENTRYID_COLUMN_BITMASK |
			VideoFileEntryModelImpl.FILEVERSIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEENTRYANDFILEVERSION = new FinderPath(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFileEntryAndFileVersion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or throws a {@link com.sambaash.platform.srv.video.NoSuchVideoFileEntryException} if it could not be found.
	 *
	 * @param fileEntryId the file entry ID
	 * @param fileVersionId the file version ID
	 * @return the matching video file entry
	 * @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a matching video file entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry findByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId)
		throws NoSuchVideoFileEntryException, SystemException {
		VideoFileEntry videoFileEntry = fetchByFileEntryAndFileVersion(fileEntryId,
				fileVersionId);

		if (videoFileEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fileEntryId=");
			msg.append(fileEntryId);

			msg.append(", fileVersionId=");
			msg.append(fileVersionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVideoFileEntryException(msg.toString());
		}

		return videoFileEntry;
	}

	/**
	 * Returns the video file entry where fileEntryId = &#63; and fileVersionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileEntryId the file entry ID
	 * @param fileVersionId the file version ID
	 * @return the matching video file entry, or <code>null</code> if a matching video file entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry fetchByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId) throws SystemException {
		return fetchByFileEntryAndFileVersion(fileEntryId, fileVersionId, true);
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
	@Override
	public VideoFileEntry fetchByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { fileEntryId, fileVersionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
					finderArgs, this);
		}

		if (result instanceof VideoFileEntry) {
			VideoFileEntry videoFileEntry = (VideoFileEntry)result;

			if ((fileEntryId != videoFileEntry.getFileEntryId()) ||
					(fileVersionId != videoFileEntry.getFileVersionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VIDEOFILEENTRY_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYANDFILEVERSION_FILEENTRYID_2);

			query.append(_FINDER_COLUMN_FILEENTRYANDFILEVERSION_FILEVERSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				qPos.add(fileVersionId);

				List<VideoFileEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VideoFileEntryPersistenceImpl.fetchByFileEntryAndFileVersion(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VideoFileEntry videoFileEntry = list.get(0);

					result = videoFileEntry;

					cacheResult(videoFileEntry);

					if ((videoFileEntry.getFileEntryId() != fileEntryId) ||
							(videoFileEntry.getFileVersionId() != fileVersionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
							finderArgs, videoFileEntry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (VideoFileEntry)result;
		}
	}

	/**
	 * Removes the video file entry where fileEntryId = &#63; and fileVersionId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @param fileVersionId the file version ID
	 * @return the video file entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry removeByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId)
		throws NoSuchVideoFileEntryException, SystemException {
		VideoFileEntry videoFileEntry = findByFileEntryAndFileVersion(fileEntryId,
				fileVersionId);

		return remove(videoFileEntry);
	}

	/**
	 * Returns the number of video file entries where fileEntryId = &#63; and fileVersionId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param fileVersionId the file version ID
	 * @return the number of matching video file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFileEntryAndFileVersion(long fileEntryId,
		long fileVersionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEENTRYANDFILEVERSION;

		Object[] finderArgs = new Object[] { fileEntryId, fileVersionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOFILEENTRY_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYANDFILEVERSION_FILEENTRYID_2);

			query.append(_FINDER_COLUMN_FILEENTRYANDFILEVERSION_FILEVERSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				qPos.add(fileVersionId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEENTRYANDFILEVERSION_FILEENTRYID_2 =
		"videoFileEntry.fileEntryId = ? AND ";
	private static final String _FINDER_COLUMN_FILEENTRYANDFILEVERSION_FILEVERSIONID_2 =
		"videoFileEntry.fileVersionId = ?";

	public VideoFileEntryPersistenceImpl() {
		setModelClass(VideoFileEntry.class);
	}

	/**
	 * Caches the video file entry in the entity cache if it is enabled.
	 *
	 * @param videoFileEntry the video file entry
	 */
	@Override
	public void cacheResult(VideoFileEntry videoFileEntry) {
		EntityCacheUtil.putResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryImpl.class, videoFileEntry.getPrimaryKey(),
			videoFileEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
			new Object[] {
				videoFileEntry.getFileEntryId(),
				videoFileEntry.getFileVersionId()
			}, videoFileEntry);

		videoFileEntry.resetOriginalValues();
	}

	/**
	 * Caches the video file entries in the entity cache if it is enabled.
	 *
	 * @param videoFileEntries the video file entries
	 */
	@Override
	public void cacheResult(List<VideoFileEntry> videoFileEntries) {
		for (VideoFileEntry videoFileEntry : videoFileEntries) {
			if (EntityCacheUtil.getResult(
						VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoFileEntryImpl.class, videoFileEntry.getPrimaryKey()) == null) {
				cacheResult(videoFileEntry);
			}
			else {
				videoFileEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video file entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoFileEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoFileEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video file entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoFileEntry videoFileEntry) {
		EntityCacheUtil.removeResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryImpl.class, videoFileEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(videoFileEntry);
	}

	@Override
	public void clearCache(List<VideoFileEntry> videoFileEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoFileEntry videoFileEntry : videoFileEntries) {
			EntityCacheUtil.removeResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoFileEntryImpl.class, videoFileEntry.getPrimaryKey());

			clearUniqueFindersCache(videoFileEntry);
		}
	}

	protected void cacheUniqueFindersCache(VideoFileEntry videoFileEntry) {
		if (videoFileEntry.isNew()) {
			Object[] args = new Object[] {
					videoFileEntry.getFileEntryId(),
					videoFileEntry.getFileVersionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEENTRYANDFILEVERSION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
				args, videoFileEntry);
		}
		else {
			VideoFileEntryModelImpl videoFileEntryModelImpl = (VideoFileEntryModelImpl)videoFileEntry;

			if ((videoFileEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoFileEntry.getFileEntryId(),
						videoFileEntry.getFileVersionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEENTRYANDFILEVERSION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
					args, videoFileEntry);
			}
		}
	}

	protected void clearUniqueFindersCache(VideoFileEntry videoFileEntry) {
		VideoFileEntryModelImpl videoFileEntryModelImpl = (VideoFileEntryModelImpl)videoFileEntry;

		Object[] args = new Object[] {
				videoFileEntry.getFileEntryId(),
				videoFileEntry.getFileVersionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYANDFILEVERSION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
			args);

		if ((videoFileEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION.getColumnBitmask()) != 0) {
			args = new Object[] {
					videoFileEntryModelImpl.getOriginalFileEntryId(),
					videoFileEntryModelImpl.getOriginalFileVersionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYANDFILEVERSION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILEENTRYANDFILEVERSION,
				args);
		}
	}

	/**
	 * Creates a new video file entry with the primary key. Does not add the video file entry to the database.
	 *
	 * @param spVideoFileEntryId the primary key for the new video file entry
	 * @return the new video file entry
	 */
	@Override
	public VideoFileEntry create(long spVideoFileEntryId) {
		VideoFileEntry videoFileEntry = new VideoFileEntryImpl();

		videoFileEntry.setNew(true);
		videoFileEntry.setPrimaryKey(spVideoFileEntryId);

		return videoFileEntry;
	}

	/**
	 * Removes the video file entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spVideoFileEntryId the primary key of the video file entry
	 * @return the video file entry that was removed
	 * @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry remove(long spVideoFileEntryId)
		throws NoSuchVideoFileEntryException, SystemException {
		return remove((Serializable)spVideoFileEntryId);
	}

	/**
	 * Removes the video file entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video file entry
	 * @return the video file entry that was removed
	 * @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry remove(Serializable primaryKey)
		throws NoSuchVideoFileEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoFileEntry videoFileEntry = (VideoFileEntry)session.get(VideoFileEntryImpl.class,
					primaryKey);

			if (videoFileEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoFileEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoFileEntry);
		}
		catch (NoSuchVideoFileEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected VideoFileEntry removeImpl(VideoFileEntry videoFileEntry)
		throws SystemException {
		videoFileEntry = toUnwrappedModel(videoFileEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videoFileEntry)) {
				videoFileEntry = (VideoFileEntry)session.get(VideoFileEntryImpl.class,
						videoFileEntry.getPrimaryKeyObj());
			}

			if (videoFileEntry != null) {
				session.delete(videoFileEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videoFileEntry != null) {
			clearCache(videoFileEntry);
		}

		return videoFileEntry;
	}

	@Override
	public VideoFileEntry updateImpl(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws SystemException {
		videoFileEntry = toUnwrappedModel(videoFileEntry);

		boolean isNew = videoFileEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (videoFileEntry.isNew()) {
				session.save(videoFileEntry);

				videoFileEntry.setNew(false);
			}
			else {
				session.merge(videoFileEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoFileEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoFileEntryImpl.class, videoFileEntry.getPrimaryKey(),
			videoFileEntry);

		clearUniqueFindersCache(videoFileEntry);
		cacheUniqueFindersCache(videoFileEntry);

		return videoFileEntry;
	}

	protected VideoFileEntry toUnwrappedModel(VideoFileEntry videoFileEntry) {
		if (videoFileEntry instanceof VideoFileEntryImpl) {
			return videoFileEntry;
		}

		VideoFileEntryImpl videoFileEntryImpl = new VideoFileEntryImpl();

		videoFileEntryImpl.setNew(videoFileEntry.isNew());
		videoFileEntryImpl.setPrimaryKey(videoFileEntry.getPrimaryKey());

		videoFileEntryImpl.setSpVideoFileEntryId(videoFileEntry.getSpVideoFileEntryId());
		videoFileEntryImpl.setGroupId(videoFileEntry.getGroupId());
		videoFileEntryImpl.setCompanyId(videoFileEntry.getCompanyId());
		videoFileEntryImpl.setUserId(videoFileEntry.getUserId());
		videoFileEntryImpl.setUserName(videoFileEntry.getUserName());
		videoFileEntryImpl.setCreateDate(videoFileEntry.getCreateDate());
		videoFileEntryImpl.setModifiedDate(videoFileEntry.getModifiedDate());
		videoFileEntryImpl.setFileEntryId(videoFileEntry.getFileEntryId());
		videoFileEntryImpl.setFileVersionId(videoFileEntry.getFileVersionId());
		videoFileEntryImpl.setFolderId(videoFileEntry.getFolderId());
		videoFileEntryImpl.setJobId(videoFileEntry.getJobId());
		videoFileEntryImpl.setJobResponse(videoFileEntry.getJobResponse());
		videoFileEntryImpl.setStatus(videoFileEntry.getStatus());

		return videoFileEntryImpl;
	}

	/**
	 * Returns the video file entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video file entry
	 * @return the video file entry
	 * @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoFileEntryException, SystemException {
		VideoFileEntry videoFileEntry = fetchByPrimaryKey(primaryKey);

		if (videoFileEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoFileEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videoFileEntry;
	}

	/**
	 * Returns the video file entry with the primary key or throws a {@link com.sambaash.platform.srv.video.NoSuchVideoFileEntryException} if it could not be found.
	 *
	 * @param spVideoFileEntryId the primary key of the video file entry
	 * @return the video file entry
	 * @throws com.sambaash.platform.srv.video.NoSuchVideoFileEntryException if a video file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry findByPrimaryKey(long spVideoFileEntryId)
		throws NoSuchVideoFileEntryException, SystemException {
		return findByPrimaryKey((Serializable)spVideoFileEntryId);
	}

	/**
	 * Returns the video file entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video file entry
	 * @return the video file entry, or <code>null</code> if a video file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VideoFileEntry videoFileEntry = (VideoFileEntry)EntityCacheUtil.getResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoFileEntryImpl.class, primaryKey);

		if (videoFileEntry == _nullVideoFileEntry) {
			return null;
		}

		if (videoFileEntry == null) {
			Session session = null;

			try {
				session = openSession();

				videoFileEntry = (VideoFileEntry)session.get(VideoFileEntryImpl.class,
						primaryKey);

				if (videoFileEntry != null) {
					cacheResult(videoFileEntry);
				}
				else {
					EntityCacheUtil.putResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoFileEntryImpl.class, primaryKey,
						_nullVideoFileEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VideoFileEntryModelImpl.ENTITY_CACHE_ENABLED,
					VideoFileEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videoFileEntry;
	}

	/**
	 * Returns the video file entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spVideoFileEntryId the primary key of the video file entry
	 * @return the video file entry, or <code>null</code> if a video file entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoFileEntry fetchByPrimaryKey(long spVideoFileEntryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spVideoFileEntryId);
	}

	/**
	 * Returns all the video file entries.
	 *
	 * @return the video file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VideoFileEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<VideoFileEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<VideoFileEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<VideoFileEntry> list = (List<VideoFileEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOFILEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOFILEENTRY;

				if (pagination) {
					sql = sql.concat(VideoFileEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VideoFileEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VideoFileEntry>(list);
				}
				else {
					list = (List<VideoFileEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the video file entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VideoFileEntry videoFileEntry : findAll()) {
			remove(videoFileEntry);
		}
	}

	/**
	 * Returns the number of video file entries.
	 *
	 * @return the number of video file entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOFILEENTRY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the video file entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.video.model.VideoFileEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoFileEntry>> listenersList = new ArrayList<ModelListener<VideoFileEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoFileEntry>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VideoFileEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIDEOFILEENTRY = "SELECT videoFileEntry FROM VideoFileEntry videoFileEntry";
	private static final String _SQL_SELECT_VIDEOFILEENTRY_WHERE = "SELECT videoFileEntry FROM VideoFileEntry videoFileEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOFILEENTRY = "SELECT COUNT(videoFileEntry) FROM VideoFileEntry videoFileEntry";
	private static final String _SQL_COUNT_VIDEOFILEENTRY_WHERE = "SELECT COUNT(videoFileEntry) FROM VideoFileEntry videoFileEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoFileEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoFileEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoFileEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoFileEntryPersistenceImpl.class);
	private static VideoFileEntry _nullVideoFileEntry = new VideoFileEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoFileEntry> toCacheModel() {
				return _nullVideoFileEntryCacheModel;
			}
		};

	private static CacheModel<VideoFileEntry> _nullVideoFileEntryCacheModel = new CacheModel<VideoFileEntry>() {
			@Override
			public VideoFileEntry toEntityModel() {
				return _nullVideoFileEntry;
			}
		};
}