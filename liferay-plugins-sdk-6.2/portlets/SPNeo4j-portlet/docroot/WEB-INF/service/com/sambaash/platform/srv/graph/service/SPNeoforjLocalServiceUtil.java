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

package com.sambaash.platform.srv.graph.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPNeoforj. This utility wraps
 * {@link com.sambaash.platform.srv.graph.service.impl.SPNeoforjLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see SPNeoforjLocalService
 * @see com.sambaash.platform.srv.graph.service.base.SPNeoforjLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.graph.service.impl.SPNeoforjLocalServiceImpl
 * @generated
 */
public class SPNeoforjLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.graph.service.impl.SPNeoforjLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static java.lang.String addAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm) {
		return getService().addAssetCategoryGraph(assetCategoryGraphForm);
	}

	public static java.lang.String addAssetEntitiesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm> assetEntityGraphForms) {
		return getService().addAssetEntitiesInBatch(assetEntityGraphForms);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static java.lang.String addAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm) {
		return getService().addAssetEntityGraph(assetEntityGraphForm);
	}

	public static java.lang.String addCategoriesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm> assetCategoryGraphs) {
		return getService().addCategoriesInBatch(assetCategoryGraphs);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static java.lang.String addUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm) {
		return getService().addUserGraph(userGraphForm);
	}

	public static java.lang.String addUsersInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.UserGraphForm> userGrpahs) {
		return getService().addUsersInBatch(userGrpahs);
	}

	public static com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findActivityFeeds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String filterType, int start,
		int offset) {
		return getService()
				   .findActivityFeeds(userId, companyId, groupId, layoutSetId,
			filterType, start, offset);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphAlsoLikeWrapper> findAlsoLikeAssetEntities(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK,
		int start, int offset) {
		return getService()
				   .findAlsoLikeAssetEntities(companyId, groupId, layoutSetId,
			className, classPK, start, offset);
	}

	public static com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper findAssetEntitiesUserLikes(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return getService()
				   .findAssetEntitiesUserLikes(userId, companyId, groupId,
			layoutSetId, start, offset);
	}

	public static int findAssetEntitiesUserLikesCount(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .findAssetEntitiesUserLikesCount(userId, companyId, groupId,
			layoutSetId);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findAssetEntitiesUserMayBeInterested(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .findAssetEntitiesUserMayBeInterested(userId, companyId,
			groupId, layoutSetId);
	}

	public static com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper findAssetEntityGraph(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK) {
		return getService()
				   .findAssetEntityGraph(companyId, groupId, layoutSetId,
			className, classPK);
	}

	public static java.util.List<java.lang.Long> findMyInterestedCategoryIds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .findMyInterestedCategoryIds(userId, companyId, groupId,
			layoutSetId);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findPeopleUserMayFollow(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return getService()
				   .findPeopleUserMayFollow(userId, companyId, groupId,
			layoutSetId, start, offset);
	}

	public static com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserActivity(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return getService()
				   .findUserActivity(userId, companyId, groupId, layoutSetId,
			start, offset);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowers(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return getService()
				   .findUserFollowers(userId, companyId, groupId, layoutSetId,
			start, offset);
	}

	public static int findUserFollowersCount(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .findUserFollowersCount(userId, companyId, groupId,
			layoutSetId);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowing(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return getService()
				   .findUserFollowing(userId, companyId, groupId, layoutSetId,
			start, offset);
	}

	public static int findUserFollowingCount(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .findUserFollowingCount(userId, companyId, groupId,
			layoutSetId);
	}

	public static com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserPosts(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return getService()
				   .findUserPosts(userId, companyId, groupId, layoutSetId,
			start, offset);
	}

	public static int findUserPostsCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return getService()
				   .findUserPostsCount(userId, companyId, groupId, layoutSetId);
	}

	public static int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityClassPK) {
		return getService()
				   .findUsersWhoLikeCount(companyId, groupId, layoutSetId,
			endEntityClassName, endEntityClassPK);
	}

	public static java.lang.String follow(
		com.sambaash.platform.model.spneo4j.form.FollowGraphForm followGraphForm) {
		return getService().follow(followGraphForm);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return getService()
				   .follow(companyId, groupId, layoutSetId, action,
			startUserId, endEntityClassName, endEntityClassPK);
	}

	/**
	* Setting up data to be sent to REST service Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return getService()
				   .isFollowing(companyId, groupId, layoutSetId, startUserId,
			endEntityClassName, endEntityClassPK);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static boolean isJoined(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return getService()
				   .isJoined(companyId, groupId, layoutSetId, startUserId,
			endEntityClassName, endEntityClassPK);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static boolean isLiking(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return getService()
				   .isLiking(companyId, groupId, layoutSetId, startUserId,
			endEntityClassName, endEntityClassPK);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static java.lang.String join(java.lang.String action,
		long startUserId, java.lang.String endEntityClassName,
		long endEntityClassPK, int type, int status, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return getService()
				   .join(action, startUserId, endEntityClassName,
			endEntityClassPK, type, status, companyId, groupId, layoutSetId);
	}

	public static java.lang.String like(
		com.sambaash.platform.model.spneo4j.form.LikeGraphForm likeGraphForm) {
		return getService().like(likeGraphForm);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public static java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return getService()
				   .like(companyId, groupId, layoutSetId, action, startUserId,
			endEntityClassName, endEntityClassPK);
	}

	public static java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK,
		boolean saveToDB) {
		return getService()
				   .like(companyId, groupId, layoutSetId, action, startUserId,
			endEntityClassName, endEntityClassPK, saveToDB);
	}

	public static java.lang.String pushRealtimeActivityFeed(
		com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm realtimeActivityFeedForm) {
		return getService().pushRealtimeActivityFeed(realtimeActivityFeedForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String removeAssetCategoryGraph(long categoryId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .removeAssetCategoryGraph(categoryId, companyId, groupId,
			layoutSetId);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String removeAssetEntityGraph(
		java.lang.String className, long classPK, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return getService()
				   .removeAssetEntityGraph(className, classPK, companyId,
			groupId, layoutSetId);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String removeUserGraph(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return getService()
				   .removeUserGraph(userId, companyId, groupId, layoutSetId);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String updateAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm) {
		return getService().updateAssetCategoryGraph(assetCategoryGraphForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String updateAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm) {
		return getService().updateAssetEntityGraph(assetEntityGraphForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm) {
		return getService().updateJoinGraph(joinGraphForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public static java.lang.String updateUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm) {
		return getService().updateUserGraph(userGraphForm);
	}

	public static java.lang.String updateUserInterests(long userId,
		java.util.List<java.lang.Long> interestIds, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return getService()
				   .updateUserInterests(userId, interestIds, companyId,
			groupId, layoutSetId);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussions(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset) {
		return getService()
				   .findDiscussions(companyId, groupId, layoutSetId,
			classNameId, classPk, start, offset);
	}

	public static java.lang.Long countDiscussions(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk) {
		return getService()
				   .countDiscussions(companyId, groupId, layoutSetId,
			classNameId, classPk);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussionComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long discussionId, int start,
		int offset) {
		return getService()
				   .findDiscussionComments(companyId, groupId, layoutSetId,
			discussionId, start, offset);
	}

	public static java.lang.Long countDiscussionComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long discussionId) {
		return getService()
				   .countDiscussionComments(companyId, groupId, layoutSetId,
			discussionId);
	}

	public static java.lang.Long countGroupComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long spGroupId) {
		return getService()
				   .countGroupComments(companyId, groupId, layoutSetId,
			spGroupId);
	}

	public static java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDocumentComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset) {
		return getService()
				   .findDocumentComments(companyId, groupId, layoutSetId,
			classNameId, classPk, start, offset);
	}

	public static java.lang.Long countDocumentComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk) {
		return getService()
				   .countDocumentComments(companyId, groupId, layoutSetId,
			classNameId, classPk);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPNeoforjLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPNeoforjLocalService.class.getName());

			if (invokableLocalService instanceof SPNeoforjLocalService) {
				_service = (SPNeoforjLocalService)invokableLocalService;
			}
			else {
				_service = new SPNeoforjLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPNeoforjLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPNeoforjLocalService service) {
	}

	private static SPNeoforjLocalService _service;
}