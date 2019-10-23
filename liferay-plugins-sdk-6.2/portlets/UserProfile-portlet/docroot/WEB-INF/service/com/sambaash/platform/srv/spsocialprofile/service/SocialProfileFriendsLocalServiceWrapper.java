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
 * Provides a wrapper for {@link SocialProfileFriendsLocalService}.
 *
 * @author gauravvijayvergia
 * @see SocialProfileFriendsLocalService
 * @generated
 */
public class SocialProfileFriendsLocalServiceWrapper
	implements SocialProfileFriendsLocalService,
		ServiceWrapper<SocialProfileFriendsLocalService> {
	public SocialProfileFriendsLocalServiceWrapper(
		SocialProfileFriendsLocalService socialProfileFriendsLocalService) {
		_socialProfileFriendsLocalService = socialProfileFriendsLocalService;
	}

	/**
	* Adds the social profile friends to the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileFriends the social profile friends
	* @return the social profile friends that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends addSocialProfileFriends(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.addSocialProfileFriends(socialProfileFriends);
	}

	/**
	* Creates a new social profile friends with the primary key. Does not add the social profile friends to the database.
	*
	* @param socialProfileFriendsId the primary key for the new social profile friends
	* @return the new social profile friends
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends createSocialProfileFriends(
		long socialProfileFriendsId) {
		return _socialProfileFriendsLocalService.createSocialProfileFriends(socialProfileFriendsId);
	}

	/**
	* Deletes the social profile friends with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileFriendsId the primary key of the social profile friends
	* @return the social profile friends that was removed
	* @throws PortalException if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends deleteSocialProfileFriends(
		long socialProfileFriendsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.deleteSocialProfileFriends(socialProfileFriendsId);
	}

	/**
	* Deletes the social profile friends from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileFriends the social profile friends
	* @return the social profile friends that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends deleteSocialProfileFriends(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.deleteSocialProfileFriends(socialProfileFriends);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialProfileFriendsLocalService.dynamicQuery();
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
		return _socialProfileFriendsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialProfileFriendsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialProfileFriendsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _socialProfileFriendsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _socialProfileFriendsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchSocialProfileFriends(
		long socialProfileFriendsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.fetchSocialProfileFriends(socialProfileFriendsId);
	}

	/**
	* Returns the social profile friends with the primary key.
	*
	* @param socialProfileFriendsId the primary key of the social profile friends
	* @return the social profile friends
	* @throws PortalException if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends getSocialProfileFriends(
		long socialProfileFriendsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.getSocialProfileFriends(socialProfileFriendsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the social profile friendses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @return the range of social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> getSocialProfileFriendses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.getSocialProfileFriendses(start,
			end);
	}

	/**
	* Returns the number of social profile friendses.
	*
	* @return the number of social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSocialProfileFriendsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.getSocialProfileFriendsesCount();
	}

	/**
	* Updates the social profile friends in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialProfileFriends the social profile friends
	* @return the social profile friends that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends updateSocialProfileFriends(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.updateSocialProfileFriends(socialProfileFriends);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _socialProfileFriendsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_socialProfileFriendsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _socialProfileFriendsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.service.SocialProfileFriendsLocalServiceUtil}
	* to access the social profile friends local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.findByUserIdAndSocialNetworkType(companyId,
			belongsToUserId, socialNetworkType);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.findByUserIdAndSocialNetworkType(companyId,
			belongsToUserId, socialNetworkType, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.findByUserIdAndSocialNetworkType(companyId,
			belongsToUserId, socialNetworkType, start, end, orderByComparator);
	}

	@Override
	public int countByUserIdAndSocialNetworkType(long companyId,
		long belongsToUserId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriendsLocalService.countByUserIdAndSocialNetworkType(companyId,
			belongsToUserId, socialNetworkType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SocialProfileFriendsLocalService getWrappedSocialProfileFriendsLocalService() {
		return _socialProfileFriendsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSocialProfileFriendsLocalService(
		SocialProfileFriendsLocalService socialProfileFriendsLocalService) {
		_socialProfileFriendsLocalService = socialProfileFriendsLocalService;
	}

	@Override
	public SocialProfileFriendsLocalService getWrappedService() {
		return _socialProfileFriendsLocalService;
	}

	@Override
	public void setWrappedService(
		SocialProfileFriendsLocalService socialProfileFriendsLocalService) {
		_socialProfileFriendsLocalService = socialProfileFriendsLocalService;
	}

	private SocialProfileFriendsLocalService _socialProfileFriendsLocalService;
}