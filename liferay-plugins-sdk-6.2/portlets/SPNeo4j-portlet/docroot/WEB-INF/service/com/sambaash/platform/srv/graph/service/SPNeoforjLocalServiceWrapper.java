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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPNeoforjLocalService}.
 *
 * @author harini
 * @see SPNeoforjLocalService
 * @generated
 */
public class SPNeoforjLocalServiceWrapper implements SPNeoforjLocalService,
	ServiceWrapper<SPNeoforjLocalService> {
	public SPNeoforjLocalServiceWrapper(
		SPNeoforjLocalService spNeoforjLocalService) {
		_spNeoforjLocalService = spNeoforjLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spNeoforjLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spNeoforjLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spNeoforjLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public java.lang.String addAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm) {
		return _spNeoforjLocalService.addAssetCategoryGraph(assetCategoryGraphForm);
	}

	@Override
	public java.lang.String addAssetEntitiesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm> assetEntityGraphForms) {
		return _spNeoforjLocalService.addAssetEntitiesInBatch(assetEntityGraphForms);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public java.lang.String addAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm) {
		return _spNeoforjLocalService.addAssetEntityGraph(assetEntityGraphForm);
	}

	@Override
	public java.lang.String addCategoriesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm> assetCategoryGraphs) {
		return _spNeoforjLocalService.addCategoriesInBatch(assetCategoryGraphs);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public java.lang.String addUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm) {
		return _spNeoforjLocalService.addUserGraph(userGraphForm);
	}

	@Override
	public java.lang.String addUsersInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.UserGraphForm> userGrpahs) {
		return _spNeoforjLocalService.addUsersInBatch(userGrpahs);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findActivityFeeds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String filterType, int start,
		int offset) {
		return _spNeoforjLocalService.findActivityFeeds(userId, companyId,
			groupId, layoutSetId, filterType, start, offset);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphAlsoLikeWrapper> findAlsoLikeAssetEntities(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK,
		int start, int offset) {
		return _spNeoforjLocalService.findAlsoLikeAssetEntities(companyId,
			groupId, layoutSetId, className, classPK, start, offset);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper findAssetEntitiesUserLikes(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return _spNeoforjLocalService.findAssetEntitiesUserLikes(userId,
			companyId, groupId, layoutSetId, start, offset);
	}

	@Override
	public int findAssetEntitiesUserLikesCount(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.findAssetEntitiesUserLikesCount(userId,
			companyId, groupId, layoutSetId);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findAssetEntitiesUserMayBeInterested(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.findAssetEntitiesUserMayBeInterested(userId,
			companyId, groupId, layoutSetId);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper findAssetEntityGraph(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK) {
		return _spNeoforjLocalService.findAssetEntityGraph(companyId, groupId,
			layoutSetId, className, classPK);
	}

	@Override
	public java.util.List<java.lang.Long> findMyInterestedCategoryIds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.findMyInterestedCategoryIds(userId,
			companyId, groupId, layoutSetId);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findPeopleUserMayFollow(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return _spNeoforjLocalService.findPeopleUserMayFollow(userId,
			companyId, groupId, layoutSetId, start, offset);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserActivity(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return _spNeoforjLocalService.findUserActivity(userId, companyId,
			groupId, layoutSetId, start, offset);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowers(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return _spNeoforjLocalService.findUserFollowers(userId, companyId,
			groupId, layoutSetId, start, offset);
	}

	@Override
	public int findUserFollowersCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.findUserFollowersCount(userId, companyId,
			groupId, layoutSetId);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowing(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return _spNeoforjLocalService.findUserFollowing(userId, companyId,
			groupId, layoutSetId, start, offset);
	}

	@Override
	public int findUserFollowingCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.findUserFollowingCount(userId, companyId,
			groupId, layoutSetId);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserPosts(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		return _spNeoforjLocalService.findUserPosts(userId, companyId, groupId,
			layoutSetId, start, offset);
	}

	@Override
	public int findUserPostsCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.findUserPostsCount(userId, companyId,
			groupId, layoutSetId);
	}

	@Override
	public int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityClassPK) {
		return _spNeoforjLocalService.findUsersWhoLikeCount(companyId, groupId,
			layoutSetId, endEntityClassName, endEntityClassPK);
	}

	@Override
	public java.lang.String follow(
		com.sambaash.platform.model.spneo4j.form.FollowGraphForm followGraphForm) {
		return _spNeoforjLocalService.follow(followGraphForm);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return _spNeoforjLocalService.follow(companyId, groupId, layoutSetId,
			action, startUserId, endEntityClassName, endEntityClassPK);
	}

	/**
	* Setting up data to be sent to REST service Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return _spNeoforjLocalService.isFollowing(companyId, groupId,
			layoutSetId, startUserId, endEntityClassName, endEntityClassPK);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public boolean isJoined(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return _spNeoforjLocalService.isJoined(companyId, groupId, layoutSetId,
			startUserId, endEntityClassName, endEntityClassPK);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public boolean isLiking(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return _spNeoforjLocalService.isLiking(companyId, groupId, layoutSetId,
			startUserId, endEntityClassName, endEntityClassPK);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public java.lang.String join(java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK, int type,
		int status, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.join(action, startUserId,
			endEntityClassName, endEntityClassPK, type, status, companyId,
			groupId, layoutSetId);
	}

	@Override
	public java.lang.String like(
		com.sambaash.platform.model.spneo4j.form.LikeGraphForm likeGraphForm) {
		return _spNeoforjLocalService.like(likeGraphForm);
	}

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Override
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return _spNeoforjLocalService.like(companyId, groupId, layoutSetId,
			action, startUserId, endEntityClassName, endEntityClassPK);
	}

	@Override
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK,
		boolean saveToDB) {
		return _spNeoforjLocalService.like(companyId, groupId, layoutSetId,
			action, startUserId, endEntityClassName, endEntityClassPK, saveToDB);
	}

	@Override
	public java.lang.String pushRealtimeActivityFeed(
		com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm realtimeActivityFeedForm) {
		return _spNeoforjLocalService.pushRealtimeActivityFeed(realtimeActivityFeedForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String removeAssetCategoryGraph(long categoryId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.removeAssetCategoryGraph(categoryId,
			companyId, groupId, layoutSetId);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String removeAssetEntityGraph(java.lang.String className,
		long classPK, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.removeAssetEntityGraph(className,
			classPK, companyId, groupId, layoutSetId);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String removeUserGraph(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.removeUserGraph(userId, companyId,
			groupId, layoutSetId);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String updateAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm) {
		return _spNeoforjLocalService.updateAssetCategoryGraph(assetCategoryGraphForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String updateAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm) {
		return _spNeoforjLocalService.updateAssetEntityGraph(assetEntityGraphForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm) {
		return _spNeoforjLocalService.updateJoinGraph(joinGraphForm);
	}

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Override
	public java.lang.String updateUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm) {
		return _spNeoforjLocalService.updateUserGraph(userGraphForm);
	}

	@Override
	public java.lang.String updateUserInterests(long userId,
		java.util.List<java.lang.Long> interestIds, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return _spNeoforjLocalService.updateUserInterests(userId, interestIds,
			companyId, groupId, layoutSetId);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussions(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset) {
		return _spNeoforjLocalService.findDiscussions(companyId, groupId,
			layoutSetId, classNameId, classPk, start, offset);
	}

	@Override
	public java.lang.Long countDiscussions(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk) {
		return _spNeoforjLocalService.countDiscussions(companyId, groupId,
			layoutSetId, classNameId, classPk);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussionComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long discussionId, int start,
		int offset) {
		return _spNeoforjLocalService.findDiscussionComments(companyId,
			groupId, layoutSetId, discussionId, start, offset);
	}

	@Override
	public java.lang.Long countDiscussionComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long discussionId) {
		return _spNeoforjLocalService.countDiscussionComments(companyId,
			groupId, layoutSetId, discussionId);
	}

	@Override
	public java.lang.Long countGroupComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long spGroupId) {
		return _spNeoforjLocalService.countGroupComments(companyId, groupId,
			layoutSetId, spGroupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDocumentComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset) {
		return _spNeoforjLocalService.findDocumentComments(companyId, groupId,
			layoutSetId, classNameId, classPk, start, offset);
	}

	@Override
	public java.lang.Long countDocumentComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk) {
		return _spNeoforjLocalService.countDocumentComments(companyId, groupId,
			layoutSetId, classNameId, classPk);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPNeoforjLocalService getWrappedSPNeoforjLocalService() {
		return _spNeoforjLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPNeoforjLocalService(
		SPNeoforjLocalService spNeoforjLocalService) {
		_spNeoforjLocalService = spNeoforjLocalService;
	}

	@Override
	public SPNeoforjLocalService getWrappedService() {
		return _spNeoforjLocalService;
	}

	@Override
	public void setWrappedService(SPNeoforjLocalService spNeoforjLocalService) {
		_spNeoforjLocalService = spNeoforjLocalService;
	}

	private SPNeoforjLocalService _spNeoforjLocalService;
}