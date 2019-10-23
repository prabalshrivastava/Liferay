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

package com.sambaash.platform.srv.spsocialprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialProfileLocalService}.
 *
 * @author gauravvijayvergia
 * @see SocialProfileLocalService
 * @generated
 */
public class SocialProfileLocalServiceWrapper
	implements SocialProfileLocalService,
		ServiceWrapper<SocialProfileLocalService> {
	public SocialProfileLocalServiceWrapper(
		SocialProfileLocalService socialProfileLocalService) {
		_socialProfileLocalService = socialProfileLocalService;
	}

	/**
	* Adds the social profile to the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addSocialProfile(socialProfile);
	}

	/**
	* Creates a new social profile with the primary key. Does not add the social profile to the database.
	*
	* @param userId the primary key for the new social profile
	* @return the new social profile
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile createSocialProfile(
		long userId) {
		return _socialProfileLocalService.createSocialProfile(userId);
	}

	/**
	* Deletes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the social profile
	* @return the social profile that was removed
	* @throws PortalException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.deleteSocialProfile(userId);
	}

	/**
	* Deletes the social profile from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.deleteSocialProfile(socialProfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialProfileLocalService.dynamicQuery();
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
		return _socialProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialProfileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialProfileLocalService.dynamicQuery(dynamicQuery, start,
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
		return _socialProfileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _socialProfileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfile(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.fetchSocialProfile(userId);
	}

	/**
	* Returns the social profile with the matching UUID and company.
	*
	* @param uuid the social profile's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.fetchSocialProfileByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the social profile matching the UUID and group.
	*
	* @param uuid the social profile's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.fetchSocialProfileByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the social profile with the primary key.
	*
	* @param userId the primary key of the social profile
	* @return the social profile
	* @throws PortalException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getSocialProfile(userId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the social profile with the matching UUID and company.
	*
	* @param uuid the social profile's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile
	* @throws PortalException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getSocialProfileByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the social profile matching the UUID and group.
	*
	* @param uuid the social profile's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile
	* @throws PortalException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getSocialProfileByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the social profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @return the range of social profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> getSocialProfiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getSocialProfiles(start, end);
	}

	/**
	* Returns the number of social profiles.
	*
	* @return the number of social profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSocialProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getSocialProfilesCount();
	}

	/**
	* Updates the social profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.updateSocialProfile(socialProfile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _socialProfileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_socialProfileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _socialProfileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findBymemberPackageId(
		java.lang.String memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.findBymemberPackageId(memberPackage);
	}

	@Override
	public java.lang.String getIndProfilePublicUrl(long companyId,
		long scopeGroupId, long userId) {
		return _socialProfileLocalService.getIndProfilePublicUrl(companyId,
			scopeGroupId, userId);
	}

	@Override
	public java.lang.String getIndProfilePrivateUrl(long companyId,
		long scopeGroupId, long userId) {
		return _socialProfileLocalService.getIndProfilePrivateUrl(companyId,
			scopeGroupId, userId);
	}

	@Override
	public java.lang.String getIndProfileLandingUrl(long companyId,
		long scopeGroupId, long userId) {
		return _socialProfileLocalService.getIndProfileLandingUrl(companyId,
			scopeGroupId, userId);
	}

	@Override
	public java.lang.String getCorpProfilePublicUrl(long companyId,
		long scopeGroupId, long userId) {
		return _socialProfileLocalService.getCorpProfilePublicUrl(companyId,
			scopeGroupId, userId);
	}

	@Override
	public java.lang.String getCorpProfilePrivateUrl(long companyId,
		long scopeGroupId, java.lang.String userId) {
		return _socialProfileLocalService.getCorpProfilePrivateUrl(companyId,
			scopeGroupId, userId);
	}

	@Override
	public java.lang.String getCorpProfileLandingUrl(long companyId,
		long scopeGroupId, java.lang.String userId) {
		return _socialProfileLocalService.getCorpProfileLandingUrl(companyId,
			scopeGroupId, userId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForIndividualUser(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addSocialProfileForIndividualUser(userId,
			emailAddress, companyId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForCorporate(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addSocialProfileForCorporate(userId,
			emailAddress, companyId);
	}

	@Override
	public int incrementProfileViewCount(long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.incrementProfileViewCount(userId,
			companyId);
	}

	@Override
	public int getProfileViewCount(long userId, long companyId) {
		return _socialProfileLocalService.getProfileViewCount(userId, companyId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByuserIdCompIdAndRegStatus(
		long userId, long companyId, java.lang.String userRegistrationStatus) {
		return _socialProfileLocalService.findByuserIdCompIdAndRegStatus(userId,
			companyId, userRegistrationStatus);
	}

	@Override
	public boolean isIndividualUser(long userId, long companyId) {
		return _socialProfileLocalService.isIndividualUser(userId, companyId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfileAndTags(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		java.lang.String[] assetTagNames, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.updateSocialProfileAndTags(profile,
			assetTagNames, groupId);
	}

	@Override
	public java.lang.String getUserScreenName(long userId) {
		return _socialProfileLocalService.getUserScreenName(userId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return _socialProfileLocalService.getSocialProfile(userId, companyId);
	}

	@Override
	public void reIndex(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.search.SearchException {
		_socialProfileLocalService.reIndex(profile);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile_No_Indexing(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.updateSocialProfile_No_Indexing(profile);
	}

	@Override
	public com.liferay.portlet.asset.model.AssetEntry addOrUpdateAsset(
		long userId, long groupId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		boolean visible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addOrUpdateAsset(userId, groupId,
			profile, assetCategoryIds, assetTagNames, visible);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addOrUpdateSocialProfile(socialProfile,
			user, booleanMerge, scopeGroupId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId, boolean fromListener)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addOrUpdateSocialProfile(socialProfile,
			user, booleanMerge, scopeGroupId, fromListener);
	}

	@Override
	public void updateBirthday(com.liferay.portal.model.User user,
		java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateBirthday(user, birthday);
	}

	@Override
	public void updateGender(com.liferay.portal.model.User user,
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateGender(user, gender);
	}

	@Override
	public java.lang.String updateSingleNodeField(java.lang.String xml,
		java.lang.String nodeToUpdate, java.lang.String val)
		throws java.lang.Exception {
		return _socialProfileLocalService.updateSingleNodeField(xml,
			nodeToUpdate, val);
	}

	/**
	* Deletes the node of the corresponding attributes
	*
	* @param categoryName
	* @param categoryDetails
	* @param instance
	* @param response
	* @param profileUser
	* @param scopeGroupId
	* @return deleted node position
	*/
	@Override
	public int deleteXMLInstance(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		return _socialProfileLocalService.deleteXMLInstance(categoryName,
			categoryDetails, instance, profileUser);
	}

	@Override
	public void deleteAllWorkHistory(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		_socialProfileLocalService.deleteAllWorkHistory(profileUser);
	}

	@Override
	public void addOrUpdateWorkHistory(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details) {
		_socialProfileLocalService.addOrUpdateWorkHistory(categoryName,
			categoryDetails, instance, profileUser, scopeGroupId, details);
	}

	@Override
	public void addOrUpdateWorkHistoryFromFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details) {
		_socialProfileLocalService.addOrUpdateWorkHistoryFromFormData(categoryName,
			categoryDetails, instance, profileUser, scopeGroupId, details);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserWorkHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		return _socialProfileLocalService.getUserWorkHistoryDetails(profileUser);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserTransactionHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String formName, java.lang.String formTagName,
		java.lang.String[] formFields) {
		return _socialProfileLocalService.getUserTransactionHistoryDetails(profileUser,
			formName, formTagName, formFields);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.lang.String categoryName, java.lang.String categoryDetail,
		java.lang.String value) throws java.lang.Exception {
		return _socialProfileLocalService.addNetworkInfo(socialProfile,
			categoryName, categoryDetail, value);
	}

	@Override
	public void addOrUpdateAvailability(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		_socialProfileLocalService.addOrUpdateAvailability(categoryName,
			categoryDetails, instance, profileUser, groupId, details);
	}

	@Override
	public void addOrUpdateDynamicSection(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		_socialProfileLocalService.addOrUpdateDynamicSection(categoryName,
			categoryDetails, instance, profileUser, groupId, details);
	}

	@Override
	public void addOrUpdateDynamicSection(java.lang.String categoryName,
		java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		_socialProfileLocalService.addOrUpdateDynamicSection(categoryName,
			categoryDetails, profileUser, groupId, details);
	}

	@Override
	public com.liferay.portal.model.User updateUser(
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.updateUser(user);
	}

	@Override
	public void updateUserScreenName(long userId, java.lang.String newScreenName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateUserScreenName(userId, newScreenName);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Website> getUserWebSites(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getUserWebSites(userId, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Phone> getUserPhoneList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getUserPhoneList(userId, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Contact> getContacts(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getContacts(userId, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.EmailAddress> getUserEmailAddressList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getUserEmailAddressList(userId,
			companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Address> getUserAddresses(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getUserAddresses(userId, companyId);
	}

	@Override
	public void updateWebsites(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Website> websites)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateWebsites(socialProfile, websites);
	}

	@Override
	public void updateContactInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateContactInfo(socialProfile, phoneNumbers);
	}

	@Override
	public void updateNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Contact> contactList)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateNetworkInfo(socialProfile, contactList);
	}

	@Override
	public void updateEmailAddresses(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.EmailAddress> emailAddresses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateEmailAddresses(socialProfile,
			emailAddresses);
	}

	@Override
	public void updateAddress(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Address> addresses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateAddress(socialProfile, addresses);
	}

	@Override
	public void updateMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateMobileNo(socialProfile, phoneNumbers);
	}

	@Override
	public void updateLocationAndMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateLocationAndMobileNo(socialProfile,
			phoneNumbers);
	}

	@Override
	public void updateXMLFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updateXMLFromSocialProfile(socialProfile);
	}

	@Override
	public void updatePersonalInfoWhenReg(com.liferay.portal.model.User user,
		com.liferay.portal.kernel.json.JSONObject extraFieldsJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updatePersonalInfoWhenReg(user,
			extraFieldsJSONObject);
	}

	@Override
	public void updatePersonalInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.updatePersonalInfo(socialProfile, user);
	}

	/**
	* Transforms XML and populate with data from user and Liferay tables
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile transformSocialProfileXML(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.transformSocialProfileXML(socialProfile,
			user);
	}

	@Override
	public void saveContactInfoXMLData(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sData, java.lang.String categoryName) {
		_socialProfileLocalService.saveContactInfoXMLData(profileUser, sData,
			categoryName);
	}

	@Override
	public com.liferay.portal.model.Contact updateUserNetworkInfoFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		return _socialProfileLocalService.updateUserNetworkInfoFromSocialProfile(socialProfile);
	}

	@Override
	public void addSocialProfileDetail(java.lang.String companyName,
		java.lang.String jobId, long userId, java.lang.String projectList) {
		_socialProfileLocalService.addSocialProfileDetail(companyName, jobId,
			userId, projectList);
	}

	@Override
	public java.lang.String getExpertiseTags() {
		return _socialProfileLocalService.getExpertiseTags();
	}

	@Override
	public java.lang.String getExpertiseTags(long userId) {
		return _socialProfileLocalService.getExpertiseTags(userId);
	}

	@Override
	public java.lang.String getProfileCompletion(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		return _socialProfileLocalService.getProfileCompletion(profileUser);
	}

	@Override
	public void saveAvailabilityInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		_socialProfileLocalService.saveAvailabilityInfo(profileUser);
	}

	@Override
	public void saveWorkHistorySorted(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sortedXml) {
		_socialProfileLocalService.saveWorkHistorySorted(profileUser, sortedXml);
	}

	@Override
	public void updateSPParameter(java.lang.String key, long groupId,
		java.lang.String value, java.lang.String description) {
		_socialProfileLocalService.updateSPParameter(key, groupId, value,
			description);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.findByUserTypeAndRegStatus(userType,
			userRegistrationStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.findByUserTypeAndRegStatus(userType,
			userRegistrationStatus, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.findByUserTypeAndRegStatus(userType,
			userRegistrationStatus, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByU1_S1_S_E(
		java.lang.String userRegistrationStatus, boolean active, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.findByU1_S1_S_E(userRegistrationStatus,
			active, start, end);
	}

	@Override
	public java.lang.String getFieldValue(long userId, java.lang.String xml,
		java.lang.String fieldName) {
		return _socialProfileLocalService.getFieldValue(userId, xml, fieldName);
	}

	@Override
	public java.lang.String findSocialProfileLocation()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.findSocialProfileLocation();
	}

	@Override
	public void addOrUpdateProfileSPListTypes(java.lang.String key,
		java.lang.String[] arrSPList, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.addOrUpdateProfileSPListTypes(key,
			arrSPList, scopeGroupId);
	}

	@Override
	public void updateWorkHistoryRelatedProjects(java.lang.String companyName,
		java.lang.String companyId, long userId, java.lang.String url,
		java.lang.String addOrDelete, int start) {
		_socialProfileLocalService.updateWorkHistoryRelatedProjects(companyName,
			companyId, userId, url, addOrDelete, start);
	}

	@Override
	public void refreshAllSocialProfileXML(long scopeGroupId,
		javax.portlet.ResourceRequest request) {
		_socialProfileLocalService.refreshAllSocialProfileXML(scopeGroupId,
			request);
	}

	@Override
	public void refreshSocialProfileXML(java.lang.String category,
		java.lang.String categoryDetails, long scopeGroupId, long userId,
		javax.portlet.ResourceRequest request) {
		_socialProfileLocalService.refreshSocialProfileXML(category,
			categoryDetails, scopeGroupId, userId, request);
	}

	@Override
	public java.lang.String addAddress(java.lang.String addressXml) {
		return _socialProfileLocalService.addAddress(addressXml);
	}

	@Override
	public java.lang.String getAddress(java.lang.String emailAddress) {
		return _socialProfileLocalService.getAddress(emailAddress);
	}

	@Override
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getAssetCategories(
		long scopeGroupId, long vocabularyId) {
		return _socialProfileLocalService.getAssetCategories(scopeGroupId,
			vocabularyId);
	}

	@Override
	public void addAsMentor(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfileLocalService.addAsMentor(user, serviceContext);
	}

	@Override
	public com.liferay.portlet.asset.model.AssetVocabulary addAssetVocabulary(
		long userId, java.lang.String title,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addAssetVocabulary(userId, title,
			serviceContext);
	}

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63;
	* or throws a {@link NoSuchSocialProfileException} if it could not be
	* found.
	*
	* @param companyId
	the company ID
	* @param twitterId
	the twitter ID
	* @return the matching social profile
	* @throws NoSuchSocialProfileException
	if a matching social profile could not be found
	* @throws SystemException
	if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return _socialProfileLocalService.findByTwitterId(companyId, twitterId);
	}

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63;
	* or throws a {@link NoSuchSocialProfileException} if it could not be
	* found.
	*
	* @param companyId
	the company ID
	* @param linkedinId
	the linkedin ID
	* @return the matching social profile
	* @throws NoSuchSocialProfileException
	if a matching social profile could not be found
	* @throws SystemException
	if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return _socialProfileLocalService.findByLinkedinId(companyId, linkedinId);
	}

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or
	* throws a {@link NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId
	the company ID
	* @param yahooId
	the yahoo ID
	* @return the matching social profile
	* @throws NoSuchSocialProfileException
	if a matching social profile could not be found
	* @throws SystemException
	if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return _socialProfileLocalService.findByYahooId(companyId, yahooId);
	}

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63;
	* or throws a {@link NoSuchSocialProfileException} if it could not be
	* found.
	*
	* @param companyId
	the company ID
	* @param googleId
	the google ID
	* @return the matching social profile
	* @throws NoSuchSocialProfileException
	if a matching social profile could not be found
	* @throws SystemException
	if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return _socialProfileLocalService.findByGoogleId(companyId, googleId);
	}

	@Override
	public java.util.ArrayList<java.lang.String> fetchSocialProfileDBColNames() {
		return _socialProfileLocalService.fetchSocialProfileDBColNames();
	}

	@Override
	public com.liferay.portal.model.User addUserPlatform(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password,
		boolean passwordEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _socialProfileLocalService.addUserPlatform(firstName, lastName,
			emailAddress, password, passwordEmail, serviceContext);
	}

	@Override
	public void sendPasswordEmail(com.liferay.portal.model.User user,
		java.lang.String password,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.sendPasswordEmail(user, password,
			serviceContext);
	}

	@Override
	public void sendWelcomeEmail(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLocalService.sendWelcomeEmail(user, serviceContext);
	}

	@Override
	public void updateProfileType(com.liferay.portal.model.User user,
		com.sambaash.platform.model.ProfileType profileType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfileLocalService.updateProfileType(user, profileType,
			serviceContext);
	}

	@Override
	public com.liferay.portlet.asset.model.AssetCategory addAssetCategory(
		long userId, long parentCategoryId, java.lang.String title,
		long vocabularyId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.addAssetCategory(userId,
			parentCategoryId, title, vocabularyId, serviceContext);
	}

	@Override
	public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getIndexableFieldsMap(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getIndexableFieldsMap(companyId);
	}

	@Override
	public org.w3c.dom.NodeList getProfileFields(java.lang.String userId) {
		return _socialProfileLocalService.getProfileFields(userId);
	}

	@Override
	public java.lang.String EducationStringValue(java.lang.String i) {
		return _socialProfileLocalService.EducationStringValue(i);
	}

	@Override
	public java.lang.String EmploymentStatusValue(java.lang.String i) {
		return _socialProfileLocalService.EmploymentStatusValue(i);
	}

	@Override
	public void mergeFormJsonToProfile(java.lang.String jsonArrStr,
		long companyId, long groupId) {
		_socialProfileLocalService.mergeFormJsonToProfile(jsonArrStr,
			companyId, groupId);
	}

	@Override
	public void addOrUpdateDynamicSectionWithFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId,
		java.util.Map<java.lang.String, java.lang.String> details,
		java.lang.String instance1) {
		_socialProfileLocalService.addOrUpdateDynamicSectionWithFormData(categoryName,
			categoryDetails, profileUser, groupId, details, instance1);
	}

	@Override
	public java.lang.String saveProfileInfo(java.lang.String fieldName,
		java.lang.String value,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		com.liferay.portal.model.User user, long scopeGroupId) {
		return _socialProfileLocalService.saveProfileInfo(fieldName, value,
			profileUser, user, scopeGroupId);
	}

	@Override
	public java.lang.String[] getAssetTags(java.lang.String expertise) {
		return _socialProfileLocalService.getAssetTags(expertise);
	}

	/**
	* Applicable for single instance sections like basic info, personal info , contact info etc..
	*
	* @param userId
	* @param formName
	* @param fieldName
	* @return
	*/
	@Override
	public java.lang.String getFormFieldValue(long userId,
		java.lang.String formName, java.lang.String fieldName) {
		return _socialProfileLocalService.getFormFieldValue(userId, formName,
			fieldName);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersList(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLocalService.getUsersList(companyId, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SocialProfileLocalService getWrappedSocialProfileLocalService() {
		return _socialProfileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSocialProfileLocalService(
		SocialProfileLocalService socialProfileLocalService) {
		_socialProfileLocalService = socialProfileLocalService;
	}

	@Override
	public SocialProfileLocalService getWrappedService() {
		return _socialProfileLocalService;
	}

	@Override
	public void setWrappedService(
		SocialProfileLocalService socialProfileLocalService) {
		_socialProfileLocalService = socialProfileLocalService;
	}

	private SocialProfileLocalService _socialProfileLocalService;
}