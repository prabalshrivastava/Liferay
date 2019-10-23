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
 * Provides a wrapper for {@link SocialProfileLikeLocalService}.
 *
 * @author gauravvijayvergia
 * @see SocialProfileLikeLocalService
 * @generated
 */
public class SocialProfileLikeLocalServiceWrapper
	implements SocialProfileLikeLocalService,
		ServiceWrapper<SocialProfileLikeLocalService> {
	public SocialProfileLikeLocalServiceWrapper(
		SocialProfileLikeLocalService socialProfileLikeLocalService) {
		_socialProfileLikeLocalService = socialProfileLikeLocalService;
	}

	/**
	* Adds the social profile like to the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileLike the social profile like
	* @return the social profile like that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike addSocialProfileLike(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.addSocialProfileLike(socialProfileLike);
	}

	/**
	* Creates a new social profile like with the primary key. Does not add the social profile like to the database.
	*
	* @param socialProfileLikeId the primary key for the new social profile like
	* @return the new social profile like
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike createSocialProfileLike(
		long socialProfileLikeId) {
		return _socialProfileLikeLocalService.createSocialProfileLike(socialProfileLikeId);
	}

	/**
	* Deletes the social profile like with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like that was removed
	* @throws PortalException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike deleteSocialProfileLike(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.deleteSocialProfileLike(socialProfileLikeId);
	}

	/**
	* Deletes the social profile like from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileLike the social profile like
	* @return the social profile like that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike deleteSocialProfileLike(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.deleteSocialProfileLike(socialProfileLike);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialProfileLikeLocalService.dynamicQuery();
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
		return _socialProfileLikeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialProfileLikeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _socialProfileLikeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _socialProfileLikeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _socialProfileLikeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchSocialProfileLike(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.fetchSocialProfileLike(socialProfileLikeId);
	}

	/**
	* Returns the social profile like with the primary key.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like
	* @throws PortalException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike getSocialProfileLike(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.getSocialProfileLike(socialProfileLikeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the social profile likes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile likes
	* @param end the upper bound of the range of social profile likes (not inclusive)
	* @return the range of social profile likes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> getSocialProfileLikes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.getSocialProfileLikes(start, end);
	}

	/**
	* Returns the number of social profile likes.
	*
	* @return the number of social profile likes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSocialProfileLikesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.getSocialProfileLikesCount();
	}

	/**
	* Updates the social profile like in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param socialProfileLike the social profile like
	* @return the social profile like that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike updateSocialProfileLike(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.updateSocialProfileLike(socialProfileLike);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _socialProfileLikeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_socialProfileLikeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _socialProfileLikeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void addContactsAndLikes(com.liferay.portal.model.User user,
		long scopeGroupId) {
		_socialProfileLikeLocalService.addContactsAndLikes(user, scopeGroupId);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findByLikeIdAndSocialNetworkProfileId(
		long socialNetworkProfileId, long socialNetworkLikeId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.findByLikeIdAndSocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkLikeId, socialNetworkType);
	}

	/**
	* NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.service.SocialProfileLikeLocalServiceUtil}
	* to access the social profile like local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long companyId, long socialNetworkProfileId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.findBySocialNetworkProfileId(companyId,
			socialNetworkProfileId, socialNetworkType);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends getFriend(
		long companyId, long belongsToUserId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileLikeLocalService.getFriend(companyId,
			belongsToUserId, socialNetworkProfileId);
	}

	@Override
	public void scheduleLikesJob(long userId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLikeLocalService.scheduleLikesJob(userId,
			socialNetworkProfileId);
	}

	@Override
	public void unschedule(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.scheduler.SchedulerException {
		_socialProfileLikeLocalService.unschedule(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SocialProfileLikeLocalService getWrappedSocialProfileLikeLocalService() {
		return _socialProfileLikeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSocialProfileLikeLocalService(
		SocialProfileLikeLocalService socialProfileLikeLocalService) {
		_socialProfileLikeLocalService = socialProfileLikeLocalService;
	}

	@Override
	public SocialProfileLikeLocalService getWrappedService() {
		return _socialProfileLikeLocalService;
	}

	@Override
	public void setWrappedService(
		SocialProfileLikeLocalService socialProfileLikeLocalService) {
		_socialProfileLikeLocalService = socialProfileLikeLocalService;
	}

	private SocialProfileLikeLocalService _socialProfileLikeLocalService;
}