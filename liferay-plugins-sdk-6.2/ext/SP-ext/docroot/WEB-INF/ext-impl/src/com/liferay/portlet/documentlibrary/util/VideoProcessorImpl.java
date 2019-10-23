/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.documentlibrary.util;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.Group;
import com.liferay.portal.repository.liferayrepository.model.LiferayFileVersion;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

/**
 * @author Juan González
 * @author Sergio González
 * @author Mika Koivisto
 * @author Ivica Cardic
 */
/**
 * 
 *   
 *   
 *  Naresh April 19,2016 - This file has been modified lot to use custom ( zencoder api) video converter inteated of liferay xuggler. 
 *
 */
public class VideoProcessorImpl
	extends DLPreviewableProcessor implements VideoProcessor {

	@Override
	public void afterPropertiesSet() {
		FileUtil.mkdirs(PREVIEW_TMP_PATH);
		FileUtil.mkdirs(THUMBNAIL_TMP_PATH);
	}

	@Override
	public void generateVideo(
			FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception {

		_generateVideo(sourceFileVersion, destinationFileVersion);
	}

	@Override
	public InputStream getPreviewAsStream(FileVersion fileVersion, String type)
		throws Exception {

		return doGetPreviewAsStream(fileVersion, type);
	}

	@Override
	public long getPreviewFileSize(FileVersion fileVersion, String type)
		throws Exception {

		return doGetPreviewFileSize(fileVersion, type);
	}

	@Override
	public InputStream getThumbnailAsStream(FileVersion fileVersion, int index)
		throws Exception {

		return doGetThumbnailAsStream(fileVersion, index);
	}

	@Override
	public long getThumbnailFileSize(FileVersion fileVersion, int index)
		throws Exception {

		return doGetThumbnailFileSize(fileVersion, index);
	}

	@Override
	public Set<String> getVideoMimeTypes() {
		return _videoMimeTypes;
	}

	@Override
	public boolean hasVideo(FileVersion fileVersion) {
		boolean hasVideo = false;

		try {
			hasVideo = _hasVideo(fileVersion);
			_log.debug( " hasVideo = " + hasVideo + " for " + fileVersion );
			if (!hasVideo && isSupported(fileVersion)) {
				_log.debug("Video not exist so Adding to queue");
				_queueGeneration(null, fileVersion);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return hasVideo;
	}

	@Override
	public boolean isSupported(String mimeType) {
		if (Validator.isNull(mimeType)) {
			return false;
		}

		try {
			return _videoMimeTypes.contains(mimeType);
		}
		catch (Exception e) {
		}

		return false;
	}

	@Override
	public boolean isVideoSupported(FileVersion fileVersion) {
		return isSupported(fileVersion);
	}

	@Override
	public boolean isVideoSupported(String mimeType) {
		return isSupported(mimeType);
	}

	@Override
	public void trigger(
		FileVersion sourceFileVersion, FileVersion destinationFileVersion) {

		super.trigger(sourceFileVersion, destinationFileVersion);

		_queueGeneration(sourceFileVersion, destinationFileVersion);
	}

	@Override
	protected void doExportGeneratedFiles(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			Element fileEntryElement)
		throws Exception {
		// nothing
	}

	@Override
	protected void doImportGeneratedFiles(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			FileEntry importedFileEntry, Element fileEntryElement)
		throws Exception {
		// nothing
	}

	protected void exportPreviews(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			Element fileEntryElement)
		throws Exception {
		// do nothing
	}

	@Override
	protected List<Long> getFileVersionIds() {
		return _fileVersionIds;
	}

	@Override
	protected String getPreviewType(FileVersion fileVersion) {
		return _PREVIEW_TYPES[0];
	}

	@Override
	protected String[] getPreviewTypes() {
		return _PREVIEW_TYPES;
	}

	@Override
	protected String getThumbnailType(FileVersion fileVersion) {
		return THUMBNAIL_TYPE;
	}

	protected void importPreviews(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			FileEntry importedFileEntry, Element fileEntryElement)
		throws Exception {
		// do nothing
	}

	private void _generateVideo(
			FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception {

		_log.debug(" call received to  _generateVideo");
		if (_hasVideo(destinationFileVersion)) {
			return;
		}

		try {
			if (sourceFileVersion != null) {
				copy(sourceFileVersion, destinationFileVersion);

				return;
			}
			// call video converter
			Group grp = GroupLocalServiceUtil.getGroup(destinationFileVersion.getGroupId());
			_log.debug("Calling VideoFileEntryLocalServiceUtil.addVideoFileEntry "  );
			
			VideoFileEntryLocalServiceUtil.addVideoFileEntry(
					grp.getName(),
					destinationFileVersion, SambaashUtil.getDLFileUrl(destinationFileVersion.getFileEntryId()));
					
		}
		catch (Exception nsfee) {
			_log.error(nsfee);
		}finally{
			_fileVersionIds.remove(destinationFileVersion.getFileVersionId());
		}
	}

	private boolean _hasVideo(FileVersion fileVersion) throws Exception {
		if (!isSupported(fileVersion)) {
			return false;
		}
		//TODO: override below two methods
		return hasPreviews(fileVersion);
	}
	
	protected boolean hasThumbnails(FileVersion fileVersion){
		try{
			return hasPreviews(fileVersion);
		}catch(Exception ex){
			_log.error(ex);
		}
		return false;
	}
	
	protected boolean hasPreviews(FileVersion fileVersion)  {
		try{
			Group grp = GroupLocalServiceUtil.getGroup(fileVersion.getGroupId());
			String videoBaseUrl = ThumbnailUtil.getVideoBaseUrl(grp.getName(), fileVersion);
			return ThumbnailUtil.hasVideo(videoBaseUrl);
		}catch(Exception ex){
			_log.error(ex);
		}
		return false;
	}

	private void _queueGeneration(
		FileVersion sourceFileVersion, FileVersion destinationFileVersion) {

		if (_fileVersionIds.contains(
				destinationFileVersion.getFileVersionId()) ||
			!isSupported(destinationFileVersion)) {

			return;
		}

		_fileVersionIds.add(destinationFileVersion.getFileVersionId());

		sendGenerationMessage(
			DestinationNames.DOCUMENT_LIBRARY_VIDEO_PROCESSOR,
			sourceFileVersion, destinationFileVersion);
	}

	private static final String[] _PREVIEW_TYPES =
		PropsValues.DL_FILE_ENTRY_PREVIEW_VIDEO_CONTAINERS;

	private static Log _log = LogFactoryUtil.getLog(VideoProcessorImpl.class);

	private List<Long> _fileVersionIds = new Vector<Long>();
	private Set<String> _videoMimeTypes = SetUtil.fromArray(
		PropsValues.DL_FILE_ENTRY_PREVIEW_VIDEO_MIME_TYPES);
}