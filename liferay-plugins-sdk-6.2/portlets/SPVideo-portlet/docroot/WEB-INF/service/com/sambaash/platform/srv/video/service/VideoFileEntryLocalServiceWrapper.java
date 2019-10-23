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

package com.sambaash.platform.srv.video.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VideoFileEntryLocalService}.
 *
 * @author gauravvijayvergia
 * @see VideoFileEntryLocalService
 * @generated
 */
public class VideoFileEntryLocalServiceWrapper
	implements VideoFileEntryLocalService,
		ServiceWrapper<VideoFileEntryLocalService> {
	public VideoFileEntryLocalServiceWrapper(
		VideoFileEntryLocalService videoFileEntryLocalService) {
		_videoFileEntryLocalService = videoFileEntryLocalService;
	}

	/**
	* Adds the video file entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoFileEntry the video file entry
	* @return the video file entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry addVideoFileEntry(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.addVideoFileEntry(videoFileEntry);
	}

	/**
	* Creates a new video file entry with the primary key. Does not add the video file entry to the database.
	*
	* @param spVideoFileEntryId the primary key for the new video file entry
	* @return the new video file entry
	*/
	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry createVideoFileEntry(
		long spVideoFileEntryId) {
		return _videoFileEntryLocalService.createVideoFileEntry(spVideoFileEntryId);
	}

	/**
	* Deletes the video file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry that was removed
	* @throws PortalException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry deleteVideoFileEntry(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.deleteVideoFileEntry(spVideoFileEntryId);
	}

	/**
	* Deletes the video file entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoFileEntry the video file entry
	* @return the video file entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry deleteVideoFileEntry(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.deleteVideoFileEntry(videoFileEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoFileEntryLocalService.dynamicQuery();
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
		return _videoFileEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoFileEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoFileEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _videoFileEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _videoFileEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry fetchVideoFileEntry(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.fetchVideoFileEntry(spVideoFileEntryId);
	}

	/**
	* Returns the video file entry with the primary key.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry
	* @throws PortalException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry getVideoFileEntry(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.getVideoFileEntry(spVideoFileEntryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> getVideoFileEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.getVideoFileEntries(start, end);
	}

	/**
	* Returns the number of video file entries.
	*
	* @return the number of video file entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVideoFileEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.getVideoFileEntriesCount();
	}

	/**
	* Updates the video file entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoFileEntry the video file entry
	* @return the video file entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry updateVideoFileEntry(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.updateVideoFileEntry(videoFileEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _videoFileEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoFileEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _videoFileEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addVideoFileEntry(java.lang.String siteName,
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion,
		java.lang.String inputFileUrlDL) {
		_videoFileEntryLocalService.addVideoFileEntry(siteName, fileVersion,
			inputFileUrlDL);
	}

	@Override
	public java.lang.String urlRelativeVideoToConvert(
		java.lang.String siteName,
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion) {
		return _videoFileEntryLocalService.urlRelativeVideoToConvert(siteName,
			fileVersion);
	}

	@Override
	public java.lang.String urlAbsoluteVideoToConvert(
		java.lang.String siteName,
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion) {
		return _videoFileEntryLocalService.urlAbsoluteVideoToConvert(siteName,
			fileVersion);
	}

	@Override
	public void updateVideoConversionStatus(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry,
		java.lang.Integer conversionStatus) {
		_videoFileEntryLocalService.updateVideoConversionStatus(videoFileEntry,
			fileEntry, conversionStatus);
	}

	@Override
	public void updateFileEntryStatus(long companyId,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry,
		java.lang.Integer conversionStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_videoFileEntryLocalService.updateFileEntryStatus(companyId, fileEntry,
			conversionStatus);
	}

	@Override
	public java.lang.Integer getVideoConversionStatus(long companyId,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntryLocalService.getVideoConversionStatus(companyId,
			fileEntry);
	}

	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry findByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId) {
		return _videoFileEntryLocalService.findByFileEntryAndFileVersion(fileEntryId,
			fileVersionId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VideoFileEntryLocalService getWrappedVideoFileEntryLocalService() {
		return _videoFileEntryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVideoFileEntryLocalService(
		VideoFileEntryLocalService videoFileEntryLocalService) {
		_videoFileEntryLocalService = videoFileEntryLocalService;
	}

	@Override
	public VideoFileEntryLocalService getWrappedService() {
		return _videoFileEntryLocalService;
	}

	@Override
	public void setWrappedService(
		VideoFileEntryLocalService videoFileEntryLocalService) {
		_videoFileEntryLocalService = videoFileEntryLocalService;
	}

	private VideoFileEntryLocalService _videoFileEntryLocalService;
}