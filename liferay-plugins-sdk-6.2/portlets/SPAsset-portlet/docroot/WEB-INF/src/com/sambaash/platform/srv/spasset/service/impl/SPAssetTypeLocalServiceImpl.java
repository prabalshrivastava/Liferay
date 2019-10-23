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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.base.SPAssetTypeLocalServiceBaseImpl;

/**
 * The implementation of the s p asset type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.spasset.service.base.SPAssetTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil
 */
public class SPAssetTypeLocalServiceImpl extends
		SPAssetTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil} to
	 * access the s p asset type local service.
	 */

	public SPAssetType addSPAssetType(long userId, long groupId,
			long companyId, String spAssetTypeName, boolean status,
			String spAssetTypeCreateUrl, String spAssetTypeDetailUrl,
			String spAssetTypeInnerDetailUrl, boolean requiredTermsOfUse,
			boolean requiredLogin, boolean categoryMandatory,
			boolean notifyUponCreation, long notificationTemplateId,
			String allowedFileTypes, int maxFileSize, int minImageHeight,
			int minImageWidth, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		SPAssetType spAssetType = spAssetTypePersistence
				.create(counterLocalService.increment("SPAssetType.class"));

		// fill the data in persistance object

		spAssetType.setGroupId(groupId);
		spAssetType.setCompanyId(companyId);
		spAssetType.setUserId(userId);
		spAssetType.setUserName(user.getFullName());
		spAssetType.setCreateDate(serviceContext.getCreateDate(now));
		spAssetType.setModifiedDate(serviceContext.getModifiedDate(now));
		spAssetType.setModifiedBy(user.getFullName());
		spAssetType.setSpAssetTypeName(spAssetTypeName);
		spAssetType.setStatus(true);
		spAssetType.setSpAssetTypeCreateUrl(spAssetTypeCreateUrl);
		spAssetType.setSpAssetTypeDetailUrl(spAssetTypeDetailUrl);
		spAssetType.setSpAssetTypeInnerDetailUrl(spAssetTypeInnerDetailUrl);
		spAssetType.setRequiredTermsOfUse(true);
		spAssetType.setRequiredLogin(requiredLogin);
		spAssetType.setCategoryMandatory(true);
		spAssetType.setNotifyUponCreation(notifyUponCreation);
		spAssetType.setNotificationTemplateId(notificationTemplateId);
		spAssetType.setAllowedFileTypes(allowedFileTypes);
		spAssetType.setMaxFileSize(maxFileSize);
		spAssetType.setMinImageHeight(minImageHeight);
		spAssetType.setMinImageWidth(minImageWidth);

		return spAssetTypePersistence.update(spAssetType);

	}
	public SPAssetType updateSPAssetType(long spAssetTypeId, long userId, long groupId,
			long companyId, String spAssetTypeName, boolean status,
			String spAssetTypeCreateUrl, String spAssetTypeDetailUrl,
			String spAssetTypeInnerDetailUrl, boolean requiredTermsOfUse,
			boolean requiredLogin, boolean categoryMandatory,
			boolean notifyUponCreation, long notificationTemplateId,
			String allowedFileTypes, int maxFileSize, int minImageHeight,
			int minImageWidth, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		SPAssetType spAssetType = spAssetTypePersistence.fetchByPrimaryKey(spAssetTypeId);

		// fill the data in persistance object

		spAssetType.setGroupId(groupId);
		spAssetType.setCompanyId(companyId);
		spAssetType.setUserId(userId);
		spAssetType.setUserName(user.getFullName());
		spAssetType.setCreateDate(serviceContext.getCreateDate(now));
		spAssetType.setModifiedDate(serviceContext.getModifiedDate(now));
		spAssetType.setModifiedBy(user.getFullName());
		spAssetType.setSpAssetTypeName(spAssetTypeName);
		spAssetType.setStatus(true);
		spAssetType.setSpAssetTypeCreateUrl(spAssetTypeCreateUrl);
		spAssetType.setSpAssetTypeDetailUrl(spAssetTypeDetailUrl);
		spAssetType.setSpAssetTypeInnerDetailUrl(spAssetTypeInnerDetailUrl);
		spAssetType.setRequiredTermsOfUse(true);
		spAssetType.setRequiredLogin(requiredLogin);
		spAssetType.setCategoryMandatory(true);
		spAssetType.setNotifyUponCreation(notifyUponCreation);
		spAssetType.setNotificationTemplateId(notificationTemplateId);
		spAssetType.setAllowedFileTypes(allowedFileTypes);
		spAssetType.setMaxFileSize(maxFileSize);
		spAssetType.setMinImageHeight(minImageHeight);
		spAssetType.setMinImageWidth(minImageWidth);

		return spAssetTypePersistence.update(spAssetType);

	}	

	public List<SPAssetType> findByGroupId(long groupId) throws SystemException {
		return spAssetTypePersistence.findByGroupId(groupId);
	}
	
	public List<SPAssetType> findByGroupId(long groupId, int startIndex,
			int endIndex) throws SystemException {
		return spAssetTypePersistence.findByGroupId(groupId, startIndex,
				endIndex);
	}


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.asset.service.SPAssetTypeLocalServiceUtil} to access the s p asset type local service.
	 */

	public List<SPAssetType> findByStatus() throws SystemException {
		return findByStatus(false);
	}
	
	public List<SPAssetType> findByStatus(boolean status) throws SystemException {
		return spAssetTypePersistence.findBystatus(status);
	}
	

}