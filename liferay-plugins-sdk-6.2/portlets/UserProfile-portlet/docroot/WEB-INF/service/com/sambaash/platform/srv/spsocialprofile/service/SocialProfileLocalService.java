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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for SocialProfile. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author gauravvijayvergia
 * @see SocialProfileLocalServiceUtil
 * @see com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SocialProfileLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfileLocalServiceUtil} to access the social profile local service. Add custom service methods to {@link com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the social profile to the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new social profile with the primary key. Does not add the social profile to the database.
	*
	* @param userId the primary key for the new social profile
	* @return the new social profile
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile createSocialProfile(
		long userId);

	/**
	* Deletes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the social profile
	* @return the social profile that was removed
	* @throws PortalException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the social profile from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfile(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile with the matching UUID and company.
	*
	* @param uuid the social profile's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile matching the UUID and group.
	*
	* @param uuid the social profile's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile with the primary key.
	*
	* @param userId the primary key of the social profile
	* @return the social profile
	* @throws PortalException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile with the matching UUID and company.
	*
	* @param uuid the social profile's UUID
	* @param companyId the primary key of the company
	* @return the matching social profile
	* @throws PortalException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile matching the UUID and group.
	*
	* @param uuid the social profile's UUID
	* @param groupId the primary key of the group
	* @return the matching social profile
	* @throws PortalException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> getSocialProfiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profiles.
	*
	* @return the number of social profiles
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSocialProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the social profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialProfile the social profile
	* @return the social profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findBymemberPackageId(
		java.lang.String memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getIndProfilePublicUrl(long companyId,
		long scopeGroupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getIndProfilePrivateUrl(long companyId,
		long scopeGroupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getIndProfileLandingUrl(long companyId,
		long scopeGroupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCorpProfilePublicUrl(long companyId,
		long scopeGroupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCorpProfilePrivateUrl(long companyId,
		long scopeGroupId, java.lang.String userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCorpProfileLandingUrl(long companyId,
		long scopeGroupId, java.lang.String userId);

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForIndividualUser(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForCorporate(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int incrementProfileViewCount(long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProfileViewCount(long userId, long companyId);

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByuserIdCompIdAndRegStatus(
		long userId, long companyId, java.lang.String userRegistrationStatus);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isIndividualUser(long userId, long companyId);

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfileAndTags(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		java.lang.String[] assetTagNames, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUserScreenName(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	public void reIndex(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.search.SearchException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile_No_Indexing(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.asset.model.AssetEntry addOrUpdateAsset(
		long userId, long groupId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		boolean visible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId, boolean fromListener)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateBirthday(com.liferay.portal.model.User user,
		java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateGender(com.liferay.portal.model.User user,
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String updateSingleNodeField(java.lang.String xml,
		java.lang.String nodeToUpdate, java.lang.String val)
		throws java.lang.Exception;

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
	public int deleteXMLInstance(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser);

	public void deleteAllWorkHistory(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser);

	public void addOrUpdateWorkHistory(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details);

	public void addOrUpdateWorkHistoryFromFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getUserWorkHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getUserTransactionHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String formName, java.lang.String formTagName,
		java.lang.String[] formFields);

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.lang.String categoryName, java.lang.String categoryDetail,
		java.lang.String value) throws java.lang.Exception;

	public void addOrUpdateAvailability(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details);

	public void addOrUpdateDynamicSection(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details);

	public void addOrUpdateDynamicSection(java.lang.String categoryName,
		java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details);

	public com.liferay.portal.model.User updateUser(
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateUserScreenName(long userId, java.lang.String newScreenName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Website> getUserWebSites(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Phone> getUserPhoneList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Contact> getContacts(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.EmailAddress> getUserEmailAddressList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Address> getUserAddresses(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateWebsites(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Website> websites)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateContactInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Contact> contactList)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateEmailAddresses(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.EmailAddress> emailAddresses)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateAddress(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Address> addresses)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateLocationAndMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateXMLFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updatePersonalInfoWhenReg(com.liferay.portal.model.User user,
		com.liferay.portal.kernel.json.JSONObject extraFieldsJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updatePersonalInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Transforms XML and populate with data from user and Liferay tables
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile transformSocialProfileXML(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void saveContactInfoXMLData(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sData, java.lang.String categoryName);

	public com.liferay.portal.model.Contact updateUserNetworkInfoFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile);

	public void addSocialProfileDetail(java.lang.String companyName,
		java.lang.String jobId, long userId, java.lang.String projectList);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getExpertiseTags();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getExpertiseTags(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getProfileCompletion(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser);

	public void saveAvailabilityInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser);

	public void saveWorkHistorySorted(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sortedXml);

	public void updateSPParameter(java.lang.String key, long groupId,
		java.lang.String value, java.lang.String description);

	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByU1_S1_S_E(
		java.lang.String userRegistrationStatus, boolean active, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFieldValue(long userId, java.lang.String xml,
		java.lang.String fieldName);

	public java.lang.String findSocialProfileLocation()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void addOrUpdateProfileSPListTypes(java.lang.String key,
		java.lang.String[] arrSPList, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateWorkHistoryRelatedProjects(java.lang.String companyName,
		java.lang.String companyId, long userId, java.lang.String url,
		java.lang.String addOrDelete, int start);

	public void refreshAllSocialProfileXML(long scopeGroupId,
		javax.portlet.ResourceRequest request);

	public void refreshSocialProfileXML(java.lang.String category,
		java.lang.String categoryDetails, long scopeGroupId, long userId,
		javax.portlet.ResourceRequest request);

	public java.lang.String addAddress(java.lang.String addressXml);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getAddress(java.lang.String emailAddress);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getAssetCategories(
		long scopeGroupId, long vocabularyId);

	public void addAsMentor(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.liferay.portlet.asset.model.AssetVocabulary addAssetVocabulary(
		long userId, java.lang.String title,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.ArrayList<java.lang.String> fetchSocialProfileDBColNames();

	public com.liferay.portal.model.User addUserPlatform(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password,
		boolean passwordEmail,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void sendPasswordEmail(com.liferay.portal.model.User user,
		java.lang.String password,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void sendWelcomeEmail(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateProfileType(com.liferay.portal.model.User user,
		com.sambaash.platform.model.ProfileType profileType,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.liferay.portlet.asset.model.AssetCategory addAssetCategory(
		long userId, long parentCategoryId, java.lang.String title,
		long vocabularyId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getIndexableFieldsMap(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.w3c.dom.NodeList getProfileFields(java.lang.String userId);

	public java.lang.String EducationStringValue(java.lang.String i);

	public java.lang.String EmploymentStatusValue(java.lang.String i);

	public void mergeFormJsonToProfile(java.lang.String jsonArrStr,
		long companyId, long groupId);

	public void addOrUpdateDynamicSectionWithFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId,
		java.util.Map<java.lang.String, java.lang.String> details,
		java.lang.String instance1);

	public java.lang.String saveProfileInfo(java.lang.String fieldName,
		java.lang.String value,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		com.liferay.portal.model.User user, long scopeGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String[] getAssetTags(java.lang.String expertise);

	/**
	* Applicable for single instance sections like basic info, personal info , contact info etc..
	*
	* @param userId
	* @param formName
	* @param fieldName
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFormFieldValue(long userId,
		java.lang.String formName, java.lang.String fieldName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.User> getUsersList(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}