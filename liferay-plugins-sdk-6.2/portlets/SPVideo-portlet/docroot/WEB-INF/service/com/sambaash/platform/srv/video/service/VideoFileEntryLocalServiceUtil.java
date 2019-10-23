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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VideoFileEntry. This utility wraps
 * {@link com.sambaash.platform.srv.video.service.impl.VideoFileEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see VideoFileEntryLocalService
 * @see com.sambaash.platform.srv.video.service.base.VideoFileEntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.video.service.impl.VideoFileEntryLocalServiceImpl
 * @generated
 */
public class VideoFileEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.video.service.impl.VideoFileEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the video file entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoFileEntry the video file entry
	* @return the video file entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry addVideoFileEntry(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVideoFileEntry(videoFileEntry);
	}

	/**
	* Creates a new video file entry with the primary key. Does not add the video file entry to the database.
	*
	* @param spVideoFileEntryId the primary key for the new video file entry
	* @return the new video file entry
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry createVideoFileEntry(
		long spVideoFileEntryId) {
		return getService().createVideoFileEntry(spVideoFileEntryId);
	}

	/**
	* Deletes the video file entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry that was removed
	* @throws PortalException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry deleteVideoFileEntry(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVideoFileEntry(spVideoFileEntryId);
	}

	/**
	* Deletes the video file entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoFileEntry the video file entry
	* @return the video file entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry deleteVideoFileEntry(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVideoFileEntry(videoFileEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.video.model.VideoFileEntry fetchVideoFileEntry(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVideoFileEntry(spVideoFileEntryId);
	}

	/**
	* Returns the video file entry with the primary key.
	*
	* @param spVideoFileEntryId the primary key of the video file entry
	* @return the video file entry
	* @throws PortalException if a video file entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry getVideoFileEntry(
		long spVideoFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoFileEntry(spVideoFileEntryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sambaash.platform.srv.video.model.VideoFileEntry> getVideoFileEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoFileEntries(start, end);
	}

	/**
	* Returns the number of video file entries.
	*
	* @return the number of video file entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getVideoFileEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoFileEntriesCount();
	}

	/**
	* Updates the video file entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoFileEntry the video file entry
	* @return the video file entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.video.model.VideoFileEntry updateVideoFileEntry(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoFileEntry(videoFileEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void addVideoFileEntry(java.lang.String siteName,
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion,
		java.lang.String inputFileUrlDL) {
		getService().addVideoFileEntry(siteName, fileVersion, inputFileUrlDL);
	}

	public static java.lang.String urlRelativeVideoToConvert(
		java.lang.String siteName,
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion) {
		return getService().urlRelativeVideoToConvert(siteName, fileVersion);
	}

	public static java.lang.String urlAbsoluteVideoToConvert(
		java.lang.String siteName,
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion) {
		return getService().urlAbsoluteVideoToConvert(siteName, fileVersion);
	}

	public static void updateVideoConversionStatus(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry,
		java.lang.Integer conversionStatus) {
		getService()
			.updateVideoConversionStatus(videoFileEntry, fileEntry,
			conversionStatus);
	}

	public static void updateFileEntryStatus(long companyId,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry,
		java.lang.Integer conversionStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateFileEntryStatus(companyId, fileEntry, conversionStatus);
	}

	public static java.lang.Integer getVideoConversionStatus(long companyId,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoConversionStatus(companyId, fileEntry);
	}

	public static com.sambaash.platform.srv.video.model.VideoFileEntry findByFileEntryAndFileVersion(
		long fileEntryId, long fileVersionId) {
		return getService()
				   .findByFileEntryAndFileVersion(fileEntryId, fileVersionId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VideoFileEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VideoFileEntryLocalService.class.getName());

			if (invokableLocalService instanceof VideoFileEntryLocalService) {
				_service = (VideoFileEntryLocalService)invokableLocalService;
			}
			else {
				_service = new VideoFileEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VideoFileEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VideoFileEntryLocalService service) {
	}

	private static VideoFileEntryLocalService _service;
}