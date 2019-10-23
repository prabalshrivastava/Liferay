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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SocialProfile. This utility wraps
 * {@link com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gauravvijayvergia
 * @see SocialProfileLocalService
 * @see com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileLocalServiceImpl
 * @generated
 */
public class SocialProfileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the social profile to the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSocialProfile(socialProfile);
	}

	/**
	* Creates a new social profile with the primary key. Does not add the social profile to the database.
	*
	* @param userId the primary key for the new social profile
	* @return the new social profile
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile createSocialProfile(
		long userId) {
		return getService().createSocialProfile(userId);
	}

	/**
	* Deletes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the social profile
	* @return the social profile that was removed
	* @throws PortalException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSocialProfile(userId);
	}

	/**
	* Deletes the social profile from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSocialProfile(socialProfile);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfile(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSocialProfile(userId);
	}

	/**
	* Returns the social profile with the matching UUID and company.
	*
	* @param uuid the social profile's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSocialProfileByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the social profile matching the UUID and group.
	*
	* @param uuid the social profile's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSocialProfileByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the social profile with the primary key.
	*
	* @param userId the primary key of the social profile
	* @return the social profile
	* @throws PortalException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSocialProfile(userId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSocialProfileByUuidAndCompanyId(uuid, companyId);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSocialProfileByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> getSocialProfiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSocialProfiles(start, end);
	}

	/**
	* Returns the number of social profiles.
	*
	* @return the number of social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int getSocialProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSocialProfilesCount();
	}

	/**
	* Updates the social profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSocialProfile(socialProfile);
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

	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findBymemberPackageId(
		java.lang.String memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBymemberPackageId(memberPackage);
	}

	public static java.lang.String getIndProfilePublicUrl(long companyId,
		long scopeGroupId, long userId) {
		return getService()
				   .getIndProfilePublicUrl(companyId, scopeGroupId, userId);
	}

	public static java.lang.String getIndProfilePrivateUrl(long companyId,
		long scopeGroupId, long userId) {
		return getService()
				   .getIndProfilePrivateUrl(companyId, scopeGroupId, userId);
	}

	public static java.lang.String getIndProfileLandingUrl(long companyId,
		long scopeGroupId, long userId) {
		return getService()
				   .getIndProfileLandingUrl(companyId, scopeGroupId, userId);
	}

	public static java.lang.String getCorpProfilePublicUrl(long companyId,
		long scopeGroupId, long userId) {
		return getService()
				   .getCorpProfilePublicUrl(companyId, scopeGroupId, userId);
	}

	public static java.lang.String getCorpProfilePrivateUrl(long companyId,
		long scopeGroupId, java.lang.String userId) {
		return getService()
				   .getCorpProfilePrivateUrl(companyId, scopeGroupId, userId);
	}

	public static java.lang.String getCorpProfileLandingUrl(long companyId,
		long scopeGroupId, java.lang.String userId) {
		return getService()
				   .getCorpProfileLandingUrl(companyId, scopeGroupId, userId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForIndividualUser(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSocialProfileForIndividualUser(userId, emailAddress,
			companyId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForCorporate(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSocialProfileForCorporate(userId, emailAddress, companyId);
	}

	public static int incrementProfileViewCount(long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().incrementProfileViewCount(userId, companyId);
	}

	public static int getProfileViewCount(long userId, long companyId) {
		return getService().getProfileViewCount(userId, companyId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByuserIdCompIdAndRegStatus(
		long userId, long companyId, java.lang.String userRegistrationStatus) {
		return getService()
				   .findByuserIdCompIdAndRegStatus(userId, companyId,
			userRegistrationStatus);
	}

	public static boolean isIndividualUser(long userId, long companyId) {
		return getService().isIndividualUser(userId, companyId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfileAndTags(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		java.lang.String[] assetTagNames, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSocialProfileAndTags(profile, assetTagNames, groupId);
	}

	public static java.lang.String getUserScreenName(long userId) {
		return getService().getUserScreenName(userId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getService().getSocialProfile(userId, companyId);
	}

	public static void reIndex(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.search.SearchException {
		getService().reIndex(profile);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile_No_Indexing(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSocialProfile_No_Indexing(profile);
	}

	public static com.liferay.portlet.asset.model.AssetEntry addOrUpdateAsset(
		long userId, long groupId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		boolean visible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateAsset(userId, groupId, profile,
			assetCategoryIds, assetTagNames, visible);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateSocialProfile(socialProfile, user, booleanMerge,
			scopeGroupId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId, boolean fromListener)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateSocialProfile(socialProfile, user, booleanMerge,
			scopeGroupId, fromListener);
	}

	public static void updateBirthday(com.liferay.portal.model.User user,
		java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateBirthday(user, birthday);
	}

	public static void updateGender(com.liferay.portal.model.User user,
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateGender(user, gender);
	}

	public static java.lang.String updateSingleNodeField(java.lang.String xml,
		java.lang.String nodeToUpdate, java.lang.String val)
		throws java.lang.Exception {
		return getService().updateSingleNodeField(xml, nodeToUpdate, val);
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
	public static int deleteXMLInstance(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		return getService()
				   .deleteXMLInstance(categoryName, categoryDetails, instance,
			profileUser);
	}

	public static void deleteAllWorkHistory(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		getService().deleteAllWorkHistory(profileUser);
	}

	public static void addOrUpdateWorkHistory(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details) {
		getService()
			.addOrUpdateWorkHistory(categoryName, categoryDetails, instance,
			profileUser, scopeGroupId, details);
	}

	public static void addOrUpdateWorkHistoryFromFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details) {
		getService()
			.addOrUpdateWorkHistoryFromFormData(categoryName, categoryDetails,
			instance, profileUser, scopeGroupId, details);
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserWorkHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		return getService().getUserWorkHistoryDetails(profileUser);
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserTransactionHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String formName, java.lang.String formTagName,
		java.lang.String[] formFields) {
		return getService()
				   .getUserTransactionHistoryDetails(profileUser, formName,
			formTagName, formFields);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.lang.String categoryName, java.lang.String categoryDetail,
		java.lang.String value) throws java.lang.Exception {
		return getService()
				   .addNetworkInfo(socialProfile, categoryName, categoryDetail,
			value);
	}

	public static void addOrUpdateAvailability(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		getService()
			.addOrUpdateAvailability(categoryName, categoryDetails, instance,
			profileUser, groupId, details);
	}

	public static void addOrUpdateDynamicSection(
		java.lang.String categoryName, java.lang.String categoryDetails,
		java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		getService()
			.addOrUpdateDynamicSection(categoryName, categoryDetails, instance,
			profileUser, groupId, details);
	}

	public static void addOrUpdateDynamicSection(
		java.lang.String categoryName, java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		getService()
			.addOrUpdateDynamicSection(categoryName, categoryDetails,
			profileUser, groupId, details);
	}

	public static com.liferay.portal.model.User updateUser(
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUser(user);
	}

	public static void updateUserScreenName(long userId,
		java.lang.String newScreenName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateUserScreenName(userId, newScreenName);
	}

	public static java.util.List<com.liferay.portal.model.Website> getUserWebSites(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserWebSites(userId, companyId);
	}

	public static java.util.List<com.liferay.portal.model.Phone> getUserPhoneList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserPhoneList(userId, companyId);
	}

	public static java.util.List<com.liferay.portal.model.Contact> getContacts(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContacts(userId, companyId);
	}

	public static java.util.List<com.liferay.portal.model.EmailAddress> getUserEmailAddressList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEmailAddressList(userId, companyId);
	}

	public static java.util.List<com.liferay.portal.model.Address> getUserAddresses(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserAddresses(userId, companyId);
	}

	public static void updateWebsites(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Website> websites)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateWebsites(socialProfile, websites);
	}

	public static void updateContactInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateContactInfo(socialProfile, phoneNumbers);
	}

	public static void updateNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Contact> contactList)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateNetworkInfo(socialProfile, contactList);
	}

	public static void updateEmailAddresses(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.EmailAddress> emailAddresses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateEmailAddresses(socialProfile, emailAddresses);
	}

	public static void updateAddress(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Address> addresses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateAddress(socialProfile, addresses);
	}

	public static void updateMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateMobileNo(socialProfile, phoneNumbers);
	}

	public static void updateLocationAndMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateLocationAndMobileNo(socialProfile, phoneNumbers);
	}

	public static void updateXMLFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateXMLFromSocialProfile(socialProfile);
	}

	public static void updatePersonalInfoWhenReg(
		com.liferay.portal.model.User user,
		com.liferay.portal.kernel.json.JSONObject extraFieldsJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updatePersonalInfoWhenReg(user, extraFieldsJSONObject);
	}

	public static void updatePersonalInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updatePersonalInfo(socialProfile, user);
	}

	/**
	* Transforms XML and populate with data from user and Liferay tables
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile transformSocialProfileXML(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().transformSocialProfileXML(socialProfile, user);
	}

	public static void saveContactInfoXMLData(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sData, java.lang.String categoryName) {
		getService().saveContactInfoXMLData(profileUser, sData, categoryName);
	}

	public static com.liferay.portal.model.Contact updateUserNetworkInfoFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		return getService().updateUserNetworkInfoFromSocialProfile(socialProfile);
	}

	public static void addSocialProfileDetail(java.lang.String companyName,
		java.lang.String jobId, long userId, java.lang.String projectList) {
		getService()
			.addSocialProfileDetail(companyName, jobId, userId, projectList);
	}

	public static java.lang.String getExpertiseTags() {
		return getService().getExpertiseTags();
	}

	public static java.lang.String getExpertiseTags(long userId) {
		return getService().getExpertiseTags(userId);
	}

	public static java.lang.String getProfileCompletion(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		return getService().getProfileCompletion(profileUser);
	}

	public static void saveAvailabilityInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		getService().saveAvailabilityInfo(profileUser);
	}

	public static void saveWorkHistorySorted(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sortedXml) {
		getService().saveWorkHistorySorted(profileUser, sortedXml);
	}

	public static void updateSPParameter(java.lang.String key, long groupId,
		java.lang.String value, java.lang.String description) {
		getService().updateSPParameter(key, groupId, value, description);
	}

	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserTypeAndRegStatus(userType, userRegistrationStatus);
	}

	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserTypeAndRegStatus(userType,
			userRegistrationStatus, start, end);
	}

	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserTypeAndRegStatus(userType,
			userRegistrationStatus, start, end, orderByComparator);
	}

	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByU1_S1_S_E(
		java.lang.String userRegistrationStatus, boolean active, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByU1_S1_S_E(userRegistrationStatus, active, start, end);
	}

	public static java.lang.String getFieldValue(long userId,
		java.lang.String xml, java.lang.String fieldName) {
		return getService().getFieldValue(userId, xml, fieldName);
	}

	public static java.lang.String findSocialProfileLocation()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSocialProfileLocation();
	}

	public static void addOrUpdateProfileSPListTypes(java.lang.String key,
		java.lang.String[] arrSPList, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addOrUpdateProfileSPListTypes(key, arrSPList, scopeGroupId);
	}

	public static void updateWorkHistoryRelatedProjects(
		java.lang.String companyName, java.lang.String companyId, long userId,
		java.lang.String url, java.lang.String addOrDelete, int start) {
		getService()
			.updateWorkHistoryRelatedProjects(companyName, companyId, userId,
			url, addOrDelete, start);
	}

	public static void refreshAllSocialProfileXML(long scopeGroupId,
		javax.portlet.ResourceRequest request) {
		getService().refreshAllSocialProfileXML(scopeGroupId, request);
	}

	public static void refreshSocialProfileXML(java.lang.String category,
		java.lang.String categoryDetails, long scopeGroupId, long userId,
		javax.portlet.ResourceRequest request) {
		getService()
			.refreshSocialProfileXML(category, categoryDetails, scopeGroupId,
			userId, request);
	}

	public static java.lang.String addAddress(java.lang.String addressXml) {
		return getService().addAddress(addressXml);
	}

	public static java.lang.String getAddress(java.lang.String emailAddress) {
		return getService().getAddress(emailAddress);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetCategory> getAssetCategories(
		long scopeGroupId, long vocabularyId) {
		return getService().getAssetCategories(scopeGroupId, vocabularyId);
	}

	public static void addAsMentor(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().addAsMentor(user, serviceContext);
	}

	public static com.liferay.portlet.asset.model.AssetVocabulary addAssetVocabulary(
		long userId, java.lang.String title,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addAssetVocabulary(userId, title, serviceContext);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getService().findByTwitterId(companyId, twitterId);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getService().findByLinkedinId(companyId, linkedinId);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getService().findByYahooId(companyId, yahooId);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getService().findByGoogleId(companyId, googleId);
	}

	public static java.util.ArrayList<java.lang.String> fetchSocialProfileDBColNames() {
		return getService().fetchSocialProfileDBColNames();
	}

	public static com.liferay.portal.model.User addUserPlatform(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password,
		boolean passwordEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addUserPlatform(firstName, lastName, emailAddress,
			password, passwordEmail, serviceContext);
	}

	public static void sendPasswordEmail(com.liferay.portal.model.User user,
		java.lang.String password,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().sendPasswordEmail(user, password, serviceContext);
	}

	public static void sendWelcomeEmail(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().sendWelcomeEmail(user, serviceContext);
	}

	public static void updateProfileType(com.liferay.portal.model.User user,
		com.sambaash.platform.model.ProfileType profileType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().updateProfileType(user, profileType, serviceContext);
	}

	public static com.liferay.portlet.asset.model.AssetCategory addAssetCategory(
		long userId, long parentCategoryId, java.lang.String title,
		long vocabularyId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAssetCategory(userId, parentCategoryId, title,
			vocabularyId, serviceContext);
	}

	public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> getIndexableFieldsMap(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getIndexableFieldsMap(companyId);
	}

	public static org.w3c.dom.NodeList getProfileFields(java.lang.String userId) {
		return getService().getProfileFields(userId);
	}

	public static java.lang.String EducationStringValue(java.lang.String i) {
		return getService().EducationStringValue(i);
	}

	public static java.lang.String EmploymentStatusValue(java.lang.String i) {
		return getService().EmploymentStatusValue(i);
	}

	public static void mergeFormJsonToProfile(java.lang.String jsonArrStr,
		long companyId, long groupId) {
		getService().mergeFormJsonToProfile(jsonArrStr, companyId, groupId);
	}

	public static void addOrUpdateDynamicSectionWithFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId,
		java.util.Map<java.lang.String, java.lang.String> details,
		java.lang.String instance1) {
		getService()
			.addOrUpdateDynamicSectionWithFormData(categoryName,
			categoryDetails, profileUser, groupId, details, instance1);
	}

	public static java.lang.String saveProfileInfo(java.lang.String fieldName,
		java.lang.String value,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		com.liferay.portal.model.User user, long scopeGroupId) {
		return getService()
				   .saveProfileInfo(fieldName, value, profileUser, user,
			scopeGroupId);
	}

	public static java.lang.String[] getAssetTags(java.lang.String expertise) {
		return getService().getAssetTags(expertise);
	}

	/**
	* Applicable for single instance sections like basic info, personal info , contact info etc..
	*
	* @param userId
	* @param formName
	* @param fieldName
	* @return
	*/
	public static java.lang.String getFormFieldValue(long userId,
		java.lang.String formName, java.lang.String fieldName) {
		return getService().getFormFieldValue(userId, formName, fieldName);
	}

	public static java.util.List<com.liferay.portal.model.User> getUsersList(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUsersList(companyId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static SocialProfileLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SocialProfileLocalService.class.getName());

			if (invokableLocalService instanceof SocialProfileLocalService) {
				_service = (SocialProfileLocalService)invokableLocalService;
			}
			else {
				_service = new SocialProfileLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SocialProfileLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SocialProfileLocalService service) {
	}

	private static SocialProfileLocalService _service;
}