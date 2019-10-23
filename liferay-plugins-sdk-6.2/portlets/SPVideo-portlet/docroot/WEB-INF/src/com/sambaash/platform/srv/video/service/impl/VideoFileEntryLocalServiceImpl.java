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

package com.sambaash.platform.srv.video.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;

import com.brightcove.zencoder.client.ZencoderClient;
import com.brightcove.zencoder.client.model.ContainerFormat;
import com.brightcove.zencoder.client.model.Notification;
import com.brightcove.zencoder.client.model.NotificationFormat;
import com.brightcove.zencoder.client.model.Region;
import com.brightcove.zencoder.client.model.Thumbnail;
import com.brightcove.zencoder.client.model.UrlNotification;
import com.brightcove.zencoder.client.request.ZencoderCreateJobRequest;
import com.brightcove.zencoder.client.request.ZencoderOutput;
import com.brightcove.zencoder.client.response.ZencoderCreateJobResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.JobStatus;
import com.sambaash.platform.srv.video.NoSuchVideoFileEntryException;
import com.sambaash.platform.srv.video.model.VideoFileEntry;
import com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil;
import com.sambaash.platform.srv.video.service.base.VideoFileEntryLocalServiceBaseImpl;
import com.sambaash.platform.srv.video.service.persistence.VideoFileEntryUtil;

/**
 * The implementation of the video file entry local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.video.service.VideoFileEntryLocalService}
 * interface.
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.video.service.base.VideoFileEntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil
 */
public class VideoFileEntryLocalServiceImpl extends VideoFileEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil}
	 * to access the video file entry local service.
	 */

	public void addVideoFileEntry(String siteName, FileVersion fileVersion, String inputFileUrlDL) {

		_log.error(" siteName=" + siteName + " fileVersionId = " + fileVersion.getFileVersionId() + " inputFileUrl = "
				+ inputFileUrlDL);
		if (_log.isDebugEnabled()) {
			_log.debug(" siteName=" + siteName + " fileVersionId = " + fileVersion.getFileVersionId()
					+ " inputFileUrl = " + inputFileUrlDL);
		}
		String s3InputLocation = urlRelativeVideoToConvert(siteName, fileVersion);
		try {

			if (_log.isDebugEnabled()) {
				_log.debug("S3 path " + s3InputLocation);
			}

			Integer currentStatus = getVideoConversionStatus(fileVersion.getCompanyId(), fileVersion.getFileEntry());

			if (_log.isDebugEnabled()) {
				_log.debug("currentStatus : " + currentStatus.intValue());
			}

			if (JobStatus.PROCESSING.getStatus() == currentStatus.intValue()
					|| JobStatus.WAITING.getStatus() == currentStatus.intValue()
					|| JobStatus.QUEUED.getStatus() == currentStatus.intValue()
					|| JobStatus.PENDING.getStatus() == currentStatus.intValue()
					|| JobStatus.ASSIGNING.getStatus() == currentStatus.intValue()
					|| JobStatus.FINISHED.getStatus() == currentStatus.intValue()) {
				_log.error("Video is already uploaded to s3 and current status is : " + currentStatus.intValue()
						+ " Input Video Path : " + s3InputLocation);
				return;
			}

			// STEP 1 : Store the original Video file to S3 location from where
			// zencoder will read the file and convert.
			// Zencoder can not read file which is not having guest permission
			// in doc-lib. So store the file in S3 as well from there Zencoder
			// will read and conver.

			if (!inputAlreadyExists(bucketName, s3InputLocation)) {

				S3Object s3inputfile = new S3Object(s3InputLocation);
				FileEntry fileEntry = fileVersion.getFileEntry();
				s3inputfile.setDataInputStream(fileEntry.getContentStream());
				s3inputfile.setContentLength(fileEntry.getSize());
				s3Service.putObject(s3bucket, s3inputfile);
				if (_log.isDebugEnabled()) {
					_log.debug("Video uploaded to s3");
				}
			}
		} catch (Exception ex) {
			_log.error("Error while uploading video to s3");
			_log.error(ex);
			return;
		}

		try {

			VideoFileEntry videoFileEntry = findByFileEntryAndFileVersion(fileVersion.getFileEntryId(),
					fileVersion.getFileVersionId());

			if (Validator.isNull(videoFileEntry)) {
				videoFileEntry = videoFileEntryPersistence
						.create(counterLocalService.increment("VideoFileEntry.class"));
				videoFileEntry.setCreateDate(DateUtil.newDate());
				videoFileEntry.setUserId(fileVersion.getUserId());
				videoFileEntry.setUserName(fileVersion.getUserName());
			} else {
				if (_log.isDebugEnabled()) {
					_log.debug("Existing Video Entry : " + videoFileEntry.getSpVideoFileEntryId());
				}
				videoFileEntry.setModifiedDate(DateUtil.newDate());
			}

			videoFileEntry.setFileEntryId(fileVersion.getFileEntryId());
			videoFileEntry.setFolderId(fileVersion.getFileEntry().getFolderId());
			videoFileEntry.setCompanyId(fileVersion.getCompanyId());
			videoFileEntry.setGroupId(fileVersion.getGroupId());
			
			
			videoFileEntry.setFileVersionId(fileVersion.getFileVersionId());
			videoFileEntry.setStatus(JobStatus.PROCESSING.getStatus());

			videoFileEntry = videoFileEntryPersistence.update(videoFileEntry);
			
			_log.error("videoFileEntry created/updated : " + videoFileEntry.getSpVideoFileEntryId());
			

			ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
			// job.setInput(inputFileUrlDL);
			// STEP 2 : Supply the file location in S3. This is the input for
			// Zencoder
			job.setInput(urlAbsoluteVideoToConvert(siteName, fileVersion));
			// job.setInput("https://s3.amazonaws.com/gauravvijayvergia/643876021306767246016.mp4");
			List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();
			List<Thumbnail> thumbnails = new ArrayList<Thumbnail>();

			// STEP 3: output location
			String outputUrl = urlConvertedVideo(siteName, fileVersion);

			if (_log.isDebugEnabled()) {
				_log.debug("Converted video locations= " + outputUrl);
			}

			// STEP 4 : Define required formats and location for each format
			Thumbnail thumbnail = new Thumbnail();
			thumbnail.setWidth(1024);
			thumbnail.setHeight(768);
			thumbnail.setLabel("large");
			// thumbnail.setUrl(outputUrl+"_large");
			thumbnail.setBaseUrl(outputUrl);
			thumbnail.setFormat("png");
			thumbnail.setFilename("large");
			thumbnail.setPublicMode(true);
			thumbnails.add(thumbnail);

			thumbnail = new Thumbnail();
			thumbnail.setWidth(650);
			thumbnail.setHeight(450);
			thumbnail.setLabel("medium");
			// thumbnail.setUrl(outputUrl+"_medium");
			thumbnail.setBaseUrl(outputUrl);
			thumbnail.setFilename("medium");
			thumbnail.setFormat("png");
			thumbnail.setPublicMode(true);
			thumbnails.add(thumbnail);

			thumbnail = new Thumbnail();
			thumbnail.setWidth(450);
			thumbnail.setHeight(320);
			thumbnail.setLabel("small");
			// thumbnail.setUrl(outputUrl+"_small");
			thumbnail.setBaseUrl(outputUrl);
			thumbnail.setFilename("small");
			thumbnail.setFormat("png");
			thumbnail.setPublicMode(true);
			thumbnails.add(thumbnail);

			_log.error(" outputUrl : " + outputUrl);

			ZencoderOutput output1 = new ZencoderOutput(outputUrl + "_type1" + StringPool.PERIOD + ContainerFormat.MP4);
			output1.setFormat(ContainerFormat.MP4);
			output1.setLabel("mp4 high");
			output1.setThumbnails(thumbnails);
			output1.setPublic(true);
			outputs.add(output1);

			ZencoderOutput output2 = new ZencoderOutput(outputUrl + "_type2" + StringPool.PERIOD + ContainerFormat.WEBM);
			output2.setFormat(ContainerFormat.WEBM);
			output2.setLabel("webm");
			output2.setPublic(true);
			outputs.add(output2);

			ZencoderOutput output3 = new ZencoderOutput(outputUrl + "_type3" + StringPool.PERIOD + ContainerFormat.OGG);
			output3.setFormat(ContainerFormat.OGG);
			output3.setLabel("ogg");
			output3.setPublic(true);
			outputs.add(output3);

			job.setRegion(Region.ASIA_SINGAPORE);
			job.setOutputs(outputs);

			try {
				List<Notification> notificationList = new ArrayList<>();

				String notificationUrl = "https://"
						+ VirtualHostLocalServiceUtil.getVirtualHost(fileVersion.getCompanyId(), 0).getHostname()
						+ "/SPVideo-portlet/videonotification?vEntryId="
						+ Long.toString(videoFileEntry.getSpVideoFileEntryId());

				_log.error("notificationUrl : " + notificationUrl);

				notificationList.add(new UrlNotification(notificationUrl, NotificationFormat.JSON));

				job.setNotifications(notificationList);
			} catch (Exception e) {
				_log.error("Failes to add notificaiton for zencoder job");
			}

			ZencoderCreateJobResponse response = client.createZencoderJob(job);

			videoFileEntry.setJobId(response.getId());
			try {
				ObjectMapper mapper = new ObjectMapper();

				String input = mapper.writeValueAsString(job);

				if (_log.isDebugEnabled()) {
					_log.debug(input);
				}

				String jsonResponse = mapper.writeValueAsString(response);
				videoFileEntry.setJobResponse(jsonResponse);
			} catch (IOException e) {
				_log.error(e.getMessage());
			}

			videoFileEntryPersistence.update(videoFileEntry);

			updateFileEntryStatus(fileVersion.getCompanyId(), fileVersion.getFileEntry(),
					JobStatus.PROCESSING.getStatus());

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

	}

	// orginal video stored under this location. This will be input video, and
	// got converted to 3 types (mp4,webm, ogv)
	// example : mn/10154/13102/15969/264360/1.0/input/sample.mp4
	public String urlRelativeVideoToConvert(String siteName, FileVersion fileVersion) {

		String url = fileRelativeLocation(siteName, fileVersion) + StringPool.FORWARD_SLASH + "input"
				+ StringPool.FORWARD_SLASH + fileVersion.getTitle();

		return url;
	}

	// example: s3/sp.videos/mn/10154/13102/15969/264360/1.0/input/sample.mp4,
	public String urlAbsoluteVideoToConvert(String siteName, FileVersion fileVersion) {

		// String url = fileRelativeLocation(siteName, fileVersion) +
		// StringPool.FORWARD_SLASH + "input" + StringPool.FORWARD_SLASH +
		// fileVersion.getTitle();

		StringBuilder sb = new StringBuilder();

		sb.append("s3://").append(bucketName).append(StringPool.FORWARD_SLASH)
				.append(fileRelativeLocation(siteName, fileVersion)).append(StringPool.FORWARD_SLASH).append("input")
				.append(StringPool.FORWARD_SLASH).append(fileVersion.getTitle());

		return sb.toString();
	}

	// Converted video's stored under below location.This method just returns
	// base path, typ_x_xx will be added by calling method
	// example: s3/sp.videos/mn/10154/13102/15969/264360/1.0/sample.mp4,
	// s3/sp.videos/mn/10154/13102/15969/264360/1.0/sample.mp4_type2.webm
	// s3/sp.videos/mn/10154/13102/15969/264360/1.0/sample.mp4_type23.ogg
	private String urlConvertedVideo(String siteName, FileVersion fileVersion) {

		String url = getOutputBaseUrl(siteName, fileVersion) + StringPool.FORWARD_SLASH + fileVersion.getTitle();

		return url;

	}

	// example : s3/sp.videos/mn/10154/13102/15969/264360/1.0
	private String getOutputBaseUrl(String siteName, FileVersion fileVersion) {

		StringBuilder sb = new StringBuilder();

		sb.append("s3://").append(bucketName).append(StringPool.FORWARD_SLASH)
				.append(fileRelativeLocation(siteName, fileVersion));

		return sb.toString();

	}

	// Example : mn/10154/13102/15969/264360/1.0
	private String fileRelativeLocation(String siteName, FileVersion fileVersion) {

		StringBuilder sb = new StringBuilder();

		sb.append(siteName).append(StringPool.FORWARD_SLASH).append(fileVersion.getCompanyId())
				.append(StringPool.FORWARD_SLASH).append(fileVersion.getRepositoryId());

		try {
			sb.append(StringPool.FORWARD_SLASH).append(fileVersion.getFileEntry().getFolderId());
		} catch (Exception e) {
			_log.error("Error retrieving folderId from fileVersion for video upload path, will upload the file without folderId after conversion.");
		}

		sb.append(StringPool.FORWARD_SLASH).append(fileVersion.getFileEntryId()).append(StringPool.FORWARD_SLASH)
				.append(fileVersion.getVersion());
		// .append(StringPool.FORWARD_SLASH)
		// .append(fileVersion.getTitle());

		return sb.toString();

	}

	private static AWSCredentials getAWSCredentials() throws S3ServiceException {

		if (Validator.isNull(_ACCESS_KEY) || Validator.isNull(_SECRET_KEY)) {
			throw new S3ServiceException("S3 access and secret keys are not set");
		} else {
			return new AWSCredentials(_ACCESS_KEY, _SECRET_KEY);
		}
	}

	private static void initS3Service() throws S3ServiceException {

		AWSCredentials credentials = getAWSCredentials();

		s3Service = new RestS3Service(credentials);
	}

	private static void initS3Bucket() throws S3ServiceException {

		if (Validator.isNull(bucketName)) {
			throw new S3ServiceException("S3 bucket name is not set");
		} else {
			s3bucket = s3Service.getBucket(bucketName);
		}
	}

	public void updateVideoConversionStatus(VideoFileEntry videoFileEntry, FileEntry fileEntry, Integer conversionStatus) {

		try {
			videoFileEntry.setStatus(conversionStatus);
			videoFileEntry.setModifiedDate(DateUtil.newDate());

			VideoFileEntryLocalServiceUtil.updateVideoFileEntry(videoFileEntry);
			updateFileEntryStatus(videoFileEntry.getCompanyId(), fileEntry, conversionStatus);
		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}
	}

	public void updateFileEntryStatus(long companyId, FileEntry fileEntry, Integer conversionStatus)
			throws PortalException, SystemException {

		ExpandoTable table = null;
		try {
			table = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, _dlFileVersionClassName);
		} catch (NoSuchTableException nste) {
			table = ExpandoTableLocalServiceUtil.addDefaultTable(companyId, _dlFileVersionClassName);
		}
		if (Validator.isNotNull(table)) {
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(),
					SambaashConstants.VIDEO_CONVERSION_STATUS);

			if (Validator.isNull(column)) {
				column = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(),
						SambaashConstants.VIDEO_CONVERSION_STATUS, ExpandoColumnConstants.STRING);
			}

			ExpandoValueLocalServiceUtil.addValue(table.getClassNameId(), table.getTableId(), column.getColumnId(),
					fileEntry.getFileVersion().getFileVersionId(), String.valueOf(conversionStatus));
		} else {
			_log.error("Failed to add/get expando table for DLFileVersion");
		}
	}

	public Integer getVideoConversionStatus(long companyId, FileEntry fileEntry) throws PortalException,
			SystemException {

		String conversionStatus = ExpandoValueLocalServiceUtil.getData(companyId, _dlFileVersionClassName,
				ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.VIDEO_CONVERSION_STATUS, fileEntry
						.getFileVersion().getFileVersionId(), StringPool.BLANK);

		_log.error(" fileEntry.getFileEntryId() : " + fileEntry.getFileEntryId() + " : fileEntry.getFileVersion() : "
				+ fileEntry.getFileVersion() + " : fileEntry.getTitle() : " + fileEntry.getTitle()
				+ " : conversionStatus " + conversionStatus);

		if (Validator.isNumber(conversionStatus)) {
			return Integer.parseInt(conversionStatus);
		}

		return new Integer(-1);
	}

	private boolean inputAlreadyExists(String bucketName, String path) {

		try {
			if (s3Service.isObjectInBucket(bucketName, path)) {
				return true;
			}
		} catch (ServiceException e) {
			_log.error("Failed to check object in s3 bucket before uploading.");
		}

		return false;
	}

	public VideoFileEntry findByFileEntryAndFileVersion(long fileEntryId, long fileVersionId) {
		try {
			return VideoFileEntryUtil.findByFileEntryAndFileVersion(fileEntryId, fileVersionId);
		} catch (NoSuchVideoFileEntryException | SystemException e) {
			_log.error("Video entry not found. Will create by fileEntryId : " + fileEntryId + " : fileVersionId : "
					+ fileVersionId);
		}

		return null;
	}

	private static String _dlFileVersionClassName = DLFileVersion.class.getName();

	private static ZencoderClient client = new ZencoderClient("e90d1f8c44b7cd341d62f3113c48a5b5");

	private static String bucketName = PropsUtil.get(PropsKeys.DL_STORE_S3_BUCKET_NAME);

	private static final String _ACCESS_KEY = PropsUtil.get(PropsKeys.DL_STORE_S3_ACCESS_KEY);

	private static final String _SECRET_KEY = PropsUtil.get(PropsKeys.DL_STORE_S3_SECRET_KEY);

	private static Log _log = LogFactoryUtil.getLog(VideoFileEntryLocalServiceImpl.class);

	private static S3Service s3Service = null;
	private static S3Bucket s3bucket = null;
	static {
		try {
			initS3Service();
			initS3Bucket();
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

}
