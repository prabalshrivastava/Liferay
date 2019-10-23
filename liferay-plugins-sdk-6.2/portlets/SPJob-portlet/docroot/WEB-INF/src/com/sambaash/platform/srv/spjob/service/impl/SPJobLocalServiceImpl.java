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

package com.sambaash.platform.srv.spjob.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.srv.spjob.SPJobCategoriesException;
import com.sambaash.platform.srv.spjob.SPJobDescriptionException;
import com.sambaash.platform.srv.spjob.SPJobImageNameException;
import com.sambaash.platform.srv.spjob.SPJobImageSizeException;
import com.sambaash.platform.srv.spjob.SPJobLocationException;
import com.sambaash.platform.srv.spjob.SPJobNameException;
import com.sambaash.platform.srv.spjob.SPJobTagsException;
import com.sambaash.platform.srv.spjob.SPJobTypeException;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
import com.sambaash.platform.srv.spjob.service.base.SPJobLocalServiceBaseImpl;

/**
 * The implementation of the s p job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SPJobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.service.base.SPJobLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SPJobLocalServiceUtil
 */
public class SPJobLocalServiceImpl extends SPJobLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.SPJobLocalServiceUtil} to access the s
	 * p job local service.
	 */

	public void closeJob(long spJobId) throws SystemException, PortalException {
		SPJob spJob = SPJobLocalServiceUtil.getSPJob(spJobId);
		spJob.setStatus("Closed");
		spJob = SPJobLocalServiceUtil.updateSPJob(spJob);
		deleteIndexer(spJob);
	}

	private void deleteIndexer(SPJob spJob) throws SearchException {
		Indexer indexer = IndexerRegistryUtil.getIndexer(SPJob.class.getName());
		indexer.delete(spJob);
	}

	public SPJob addSPJob(long userId, String corporateName, String jobTitle,
			String jobType, String jobLocation, String yoe,
			String jobDescription, String status, String imageFileName,
			InputStream imageInputStream, long imageMaxSize,
			String[] imageExtensions, String currency, String salary,
			String rate, Date startDate, Date endDate, Date closingDate,
			String notefTo, ServiceContext serviceContext)
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
			throw new SPJobImageSizeException();
		}

		validate(jobTitle, jobDescription, jobType, jobLocation,
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetCategoryIds(), imageFileName,
				imageBytes, imageMaxSize, imageExtensions);

		long spJobId = counterLocalService.increment();

		SPJob spJob = spJobPersistence.create(spJobId);
		spJob.setUuid(serviceContext.getUuid());
		spJob.setGroupId(groupId);
		spJob.setCompanyId(user.getCompanyId());
		spJob.setUserId(user.getUserId());
		spJob.setCreatedBy(user.getUserId());
		spJob.setCreateDate(serviceContext.getCreateDate(now));
		spJob.setModifiedDate(serviceContext.getModifiedDate(now));
		spJob.setCorporateName(corporateName);
		spJob.setJobTitle(jobTitle);
		spJob.setJobDescription(jobDescription);
		spJob.setJobType(jobType);
		spJob.setJobLocation(jobLocation);
		spJob.setYearsOfExperience(yoe);

		if (imageBytes != null) {
			String imageId = String.valueOf(counterLocalService.increment());
			spJob.setExtra1(imageId);
			spJob.setExtra2(imageId);
		}

		spJob.setCurrency(currency);
		double salaryD = 0.0;
		try {
			salaryD = Double.valueOf(salary);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		spJob.setSalary(salaryD);
		spJob.setRate(rate);

		spJob.setStartDate(startDate);
		spJob.setEndDate(endDate);
		spJob.setClosingDate(closingDate);
		spJob.setStatus(status);
		spJob.setNotefto(notefTo);

		spJobPersistence.update(spJob);

		// Small image

		if (imageBytes != null) {
			saveImages(Long.valueOf(spJob.getExtra1()), imageBytes);
		}

		// Asset

		updateAsset(userId, spJob, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		return spJob;
	}

	public SPJob updateSPJob(long userId, long spJobId, String corporateName,
			String jobTitle, String jobType, String jobLocation, String yoe,
			String jobDescription, String status, String imageFileName,
			InputStream imageInputStream, long imageMaxSize,
			String[] imageExtensions, String currency, String salary,
			String rate, Date startDate, Date endDate, Date closingDate,
			String notefTo, ServiceContext serviceContext)
			throws PortalException, SystemException {

		// Entry

		byte[] imageBytes = null;

		try {
			if (imageInputStream != null) {
				imageBytes = FileUtil.getBytes(imageInputStream);
			}
		} catch (IOException ioe) {
		}

		validate(jobTitle, jobDescription, jobType, jobLocation,
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetCategoryIds(), imageFileName,
				imageBytes, imageMaxSize, imageExtensions);

		SPJob spJob = spJobPersistence.findByPrimaryKey(spJobId);

		spJob.setModifiedDate(serviceContext.getModifiedDate(null));
		spJob.setCorporateName(corporateName);
		spJob.setJobTitle(jobTitle);
		spJob.setJobType(jobType);
		spJob.setJobLocation(jobLocation);
		spJob.setYearsOfExperience(yoe);
		spJob.setJobDescription(jobDescription);
		spJob.setCurrency(currency);
		double salaryD = 0.0;
		try {
			salaryD = Double.valueOf(salary);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		spJob.setSalary(salaryD);
		spJob.setRate(rate);
		spJob.setStartDate(startDate);
		spJob.setEndDate(endDate);
		spJob.setClosingDate(closingDate);
		spJob.setStatus(status);

		spJob.setExpandoBridgeAttributes(serviceContext);
		spJob.setNotefto(notefTo);

		spJobPersistence.update(spJob);

		// Small image

		long imageId = Long.valueOf(spJob.getExtra1());
		if (imageId == 0) {
			imageId = counterLocalService.increment();
		}

		saveImages(imageId, imageBytes);

		// Asset

		updateAsset(userId, spJob, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(),
				serviceContext.getAssetLinkEntryIds());

		return spJob;
	}

	public void updateAsset(long userId, SPJob spJob, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds)
			throws PortalException, SystemException {

		boolean visible = true;

		String summary = HtmlUtil.extractText(StringUtil.shorten(
				spJob.getJobDescription(), 500));

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				spJob.getGroupId(), SPJob.class.getName(), spJob.getSpJobId(),
				spJob.getUuid(), 0, assetCategoryIds, assetTagNames, visible,
				null, null, spJob.getCreateDate(), null,
				ContentTypes.TEXT_HTML, spJob.getJobTitle(), null, summary,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}

	private void saveImages(long imageId, byte[] imageBytes)
			throws PortalException, SystemException {
		if (imageBytes != null) {
			imageLocalService.updateImage(imageId, imageBytes);
		}
	}

	private void validate(String jobTitle, String jobDescription,
			String jobType, String jobLocation, String[] assetTagNames,
			long[] assetCategoryIds, String imageFileName, byte[] imageBytes,
			long imageMaxSize, String[] imageExtensions)
			throws PortalException, SystemException {

		if (Validator.isNull(jobTitle)) {
			throw new SPJobNameException();
		} else if (Validator.isNull(jobDescription)) {
			throw new SPJobDescriptionException();
		} else if (Validator.isNull(jobType)) {
			throw new SPJobTypeException();
		} else if (Validator.isNull(jobLocation)) {
			throw new SPJobLocationException();
		} else if (assetTagNames.length <= 0) {
			throw new SPJobTagsException();
		} else if (assetCategoryIds.length <= 0) {
			throw new SPJobCategoriesException();
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
					throw new SPJobImageNameException(imageFileName);
				}
			}

			if (imageBytes.length > imageMaxSize) {

				throw new SPJobImageSizeException();
			}
		}
	}

}