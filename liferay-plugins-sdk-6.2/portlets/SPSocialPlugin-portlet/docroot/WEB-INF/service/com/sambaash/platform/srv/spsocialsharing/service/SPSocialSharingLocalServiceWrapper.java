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

package com.sambaash.platform.srv.spsocialsharing.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPSocialSharingLocalService}.
 *
 * @author harini
 * @see SPSocialSharingLocalService
 * @generated
 */
public class SPSocialSharingLocalServiceWrapper
	implements SPSocialSharingLocalService,
		ServiceWrapper<SPSocialSharingLocalService> {
	public SPSocialSharingLocalServiceWrapper(
		SPSocialSharingLocalService spSocialSharingLocalService) {
		_spSocialSharingLocalService = spSocialSharingLocalService;
	}

	/**
	* Adds the s p social sharing to the database. Also notifies the appropriate model listeners.
	*
	* @param spSocialSharing the s p social sharing
	* @return the s p social sharing that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing addSPSocialSharing(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.addSPSocialSharing(spSocialSharing);
	}

	/**
	* Creates a new s p social sharing with the primary key. Does not add the s p social sharing to the database.
	*
	* @param spSocialSharingId the primary key for the new s p social sharing
	* @return the new s p social sharing
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing createSPSocialSharing(
		long spSocialSharingId) {
		return _spSocialSharingLocalService.createSPSocialSharing(spSocialSharingId);
	}

	/**
	* Deletes the s p social sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSocialSharingId the primary key of the s p social sharing
	* @return the s p social sharing that was removed
	* @throws PortalException if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing deleteSPSocialSharing(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.deleteSPSocialSharing(spSocialSharingId);
	}

	/**
	* Deletes the s p social sharing from the database. Also notifies the appropriate model listeners.
	*
	* @param spSocialSharing the s p social sharing
	* @return the s p social sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing deleteSPSocialSharing(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.deleteSPSocialSharing(spSocialSharing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSocialSharingLocalService.dynamicQuery();
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
		return _spSocialSharingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSocialSharingLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSocialSharingLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spSocialSharingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSocialSharingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchSPSocialSharing(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.fetchSPSocialSharing(spSocialSharingId);
	}

	/**
	* Returns the s p social sharing with the matching UUID and company.
	*
	* @param uuid the s p social sharing's UUID
	* @param companyId the primary key of the company
	* @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchSPSocialSharingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.fetchSPSocialSharingByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p social sharing matching the UUID and group.
	*
	* @param uuid the s p social sharing's UUID
	* @param groupId the primary key of the group
	* @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchSPSocialSharingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.fetchSPSocialSharingByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the s p social sharing with the primary key.
	*
	* @param spSocialSharingId the primary key of the s p social sharing
	* @return the s p social sharing
	* @throws PortalException if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing getSPSocialSharing(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.getSPSocialSharing(spSocialSharingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p social sharing with the matching UUID and company.
	*
	* @param uuid the s p social sharing's UUID
	* @param companyId the primary key of the company
	* @return the matching s p social sharing
	* @throws PortalException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing getSPSocialSharingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.getSPSocialSharingByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p social sharing matching the UUID and group.
	*
	* @param uuid the s p social sharing's UUID
	* @param groupId the primary key of the group
	* @return the matching s p social sharing
	* @throws PortalException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing getSPSocialSharingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.getSPSocialSharingByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the s p social sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @return the range of s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> getSPSocialSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.getSPSocialSharings(start, end);
	}

	/**
	* Returns the number of s p social sharings.
	*
	* @return the number of s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSocialSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.getSPSocialSharingsCount();
	}

	/**
	* Updates the s p social sharing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSocialSharing the s p social sharing
	* @return the s p social sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateSPSocialSharing(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharingLocalService.updateSPSocialSharing(spSocialSharing);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSocialSharingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSocialSharingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSocialSharingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link sambaash.platform .srv.socialplugins.service.SocialSharingLocalServiceUtil}
	* to access the social sharing local service.
	*/
	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByClassNameIdAndClassPK(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		return _spSocialSharingLocalService.findByClassNameIdAndClassPK(classNameId,
			classPK);
	}

	/**
	* This method will auto-share blog entry link to different social networks,
	* given that a user has been linked his account to his profile 1. Facebook
	* - The link to the published blog will be posted to the wall/timeline 2.
	* Twitter - The link to the published blog will be posted as a new tweet 3.
	* Linkedin - The link to the published blog will be posted as a status
	* update
	*
	* Parameters: blogId - Id of the blog entry Title - the title of the blog
	* entry altMessage - Assign a value to override the default message that
	* will be posted to social network url - The link of the blog imgUrl - URL
	* of the image
	*
	* (non-Javadoc)
	*
	* @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	#postBlogToSocialNetwork(long, java.lang.String, java.lang.String,
	java.lang.String, java.lang.String, long, long,
	sambaash.platform.srv.socialprofile.model.SocialProfile,
	com.liferay.portal.model.User)
	*/
	@Override
	public void postBlogToSocialNetwork(long blogId, java.lang.String title,
		java.lang.String altMessage, java.lang.String url,
		java.lang.String imgUrl, long companyId, long groupId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user) {
		_spSocialSharingLocalService.postBlogToSocialNetwork(blogId, title,
			altMessage, url, imgUrl, companyId, groupId, socialProfile, user);
	}

	/**
	* (non-Javadoc)
	*
	* @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	#postEventToSocialNetworks(long, java.lang.String, java.lang.String,
	java.lang.String, java.lang.String, long, long,
	com.liferay.portal.model.User)
	*/
	@Override
	public void postEventToSocialNetworks(long eventId, java.lang.String title,
		java.lang.String altMessage, java.lang.String url,
		java.lang.String imgUrl, long companyId, long groupId,
		com.liferay.portal.model.User user) {
		_spSocialSharingLocalService.postEventToSocialNetworks(eventId, title,
			altMessage, url, imgUrl, companyId, groupId, user);
	}

	@Override
	public void postGroupToSocialNetworks(long groupDetailId,
		java.lang.String title, java.lang.String altMessage,
		java.lang.String url, java.lang.String imgUrl, long companyId,
		long groupId, com.liferay.portal.model.User user, long classNameId) {
		_spSocialSharingLocalService.postGroupToSocialNetworks(groupDetailId,
			title, altMessage, url, imgUrl, companyId, groupId, user,
			classNameId);
	}

	/**
	* (non-Javadoc)
	*
	* @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	#postJobsToSocialNetworks(long, java.lang.String, java.lang.String,
	java.lang.String, java.lang.String, long, long,
	com.liferay.portal.model.User)
	*/
	@Override
	public void postJobsToSocialNetworks(long jobId, java.lang.String title,
		java.lang.String altMessage, java.lang.String url,
		java.lang.String imgUrl, long companyId, long groupId,
		com.liferay.portal.model.User user) {
		_spSocialSharingLocalService.postJobsToSocialNetworks(jobId, title,
			altMessage, url, imgUrl, companyId, groupId, user);
	}

	/**
	* This method will auto-share Individual profile link to different social
	* networks upon signing up using social networks 1. Facebook - The link to
	* the published profile will be posted to the wall/timeline 2. Twitter -
	* The link to the published profile will be posted as a new tweet 3.
	* Linkedin - The link to the published profile will be posted as a status
	* update
	*
	* (non-Javadoc)
	*
	* @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	#postProfileToSocialNetwork(com.liferay.portal.model.User,
	sambaash.platform.srv.socialprofile.model.SocialProfile)
	*/
	@Override
	public void postProfileToSocialNetwork(com.liferay.portal.model.User user,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		_spSocialSharingLocalService.postProfileToSocialNetwork(user,
			socialProfile);
	}

	@Override
	public void postSPAssetToSocialNetwork(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		java.lang.String url, java.lang.String imgUrl) {
		_spSocialSharingLocalService.postSPAssetToSocialNetwork(spAssetEntry,
			url, imgUrl);
	}

	@Override
	public void postSPGroupToSocialNetworks(long classNameId, long classPK,
		java.lang.String title, java.lang.String altMessage,
		java.lang.String url, java.lang.String imgUrl, long companyId,
		long groupId, com.liferay.portal.model.User user, boolean enableFB,
		boolean enableIn, boolean enableGoogle, boolean enableTW) {
		_spSocialSharingLocalService.postSPGroupToSocialNetworks(classNameId,
			classPK, title, altMessage, url, imgUrl, companyId, groupId, user,
			enableFB, enableIn, enableGoogle, enableTW);
	}

	@Override
	public int publishToFacebook(java.lang.String title,
		java.lang.String message, java.lang.String link,
		java.lang.String pictureUrl, long groupId, long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		return _spSocialSharingLocalService.publishToFacebook(title, message,
			link, pictureUrl, groupId, companyId, socialProfile);
	}

	@Override
	public int publishToFacebookPage(java.lang.String title,
		java.lang.String message, java.lang.String link,
		java.lang.String pictureUrl, long groupId, long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		return _spSocialSharingLocalService.publishToFacebookPage(title,
			message, link, pictureUrl, groupId, companyId, socialProfile);
	}

	@Override
	public int publishToLinkedIn(java.lang.String title,
		java.lang.String message, java.lang.String link,
		java.lang.String pictureUrl, long groupId, long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		return _spSocialSharingLocalService.publishToLinkedIn(title, message,
			link, pictureUrl, groupId, companyId, socialProfile);
	}

	@Override
	public int publishToTwitter(java.lang.String message,
		java.lang.String link, java.lang.String pictureUrl, long groupId,
		long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		return _spSocialSharingLocalService.publishToTwitter(message, link,
			pictureUrl, groupId, companyId, socialProfile);
	}

	/**
	* This method converts the image from url to bytes Saves the portrait image
	* which was obtained from social networks (non-Javadoc)
	*
	* @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	#saveProfileImage(java.lang.String, long)
	*/
	@Override
	public void saveProfileImage(java.lang.String pictureUrl, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.upload.UploadException {
		_spSocialSharingLocalService.saveProfileImage(pictureUrl, userId);
	}

	/**
	* Sends email notification to the admin when an error occurs when
	* publishing to other social sites
	*
	* @param fromAddress
	* @param fromName
	* @param body
	* @param subject
	* @param companyId
	*/
	@Override
	public void sendNotificationAdmin(java.lang.String fromAddress,
		java.lang.String fromName, java.lang.String body,
		java.lang.String subject, long companyId, long groupId) {
		_spSocialSharingLocalService.sendNotificationAdmin(fromAddress,
			fromName, body, subject, companyId, groupId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateFacebookPageShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		return _spSocialSharingLocalService.updateFacebookPageShareStatus(classNameId,
			classPK, status);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateFacebookShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		return _spSocialSharingLocalService.updateFacebookShareStatus(classNameId,
			classPK, status);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateLinkedInShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		return _spSocialSharingLocalService.updateLinkedInShareStatus(classNameId,
			classPK, status);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateTwitterShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		return _spSocialSharingLocalService.updateTwitterShareStatus(classNameId,
			classPK, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSocialSharingLocalService getWrappedSPSocialSharingLocalService() {
		return _spSocialSharingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSocialSharingLocalService(
		SPSocialSharingLocalService spSocialSharingLocalService) {
		_spSocialSharingLocalService = spSocialSharingLocalService;
	}

	@Override
	public SPSocialSharingLocalService getWrappedService() {
		return _spSocialSharingLocalService;
	}

	@Override
	public void setWrappedService(
		SPSocialSharingLocalService spSocialSharingLocalService) {
		_spSocialSharingLocalService = spSocialSharingLocalService;
	}

	private SPSocialSharingLocalService _spSocialSharingLocalService;
}