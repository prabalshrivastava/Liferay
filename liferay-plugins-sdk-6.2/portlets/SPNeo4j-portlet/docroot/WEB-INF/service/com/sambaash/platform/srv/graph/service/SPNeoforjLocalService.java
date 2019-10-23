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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPNeoforj. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author harini
 * @see SPNeoforjLocalServiceUtil
 * @see com.sambaash.platform.srv.graph.service.base.SPNeoforjLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.graph.service.impl.SPNeoforjLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPNeoforjLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPNeoforjLocalServiceUtil} to access the s p neoforj local service. Add custom service methods to {@link com.sambaash.platform.srv.graph.service.impl.SPNeoforjLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

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

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public java.lang.String addAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm);

	public java.lang.String addAssetEntitiesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm> assetEntityGraphForms);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public java.lang.String addAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm);

	public java.lang.String addCategoriesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm> assetCategoryGraphs);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public java.lang.String addUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm);

	public java.lang.String addUsersInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.UserGraphForm> userGrpahs);

	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findActivityFeeds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String filterType, int start,
		int offset);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphAlsoLikeWrapper> findAlsoLikeAssetEntities(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK,
		int start, int offset);

	public com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper findAssetEntitiesUserLikes(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset);

	public int findAssetEntitiesUserLikesCount(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findAssetEntitiesUserMayBeInterested(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	public com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper findAssetEntityGraph(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK);

	public java.util.List<java.lang.Long> findMyInterestedCategoryIds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findPeopleUserMayFollow(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset);

	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserActivity(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowers(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset);

	public int findUserFollowersCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowing(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset);

	public int findUserFollowingCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId);

	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserPosts(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset);

	public int findUserPostsCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId);

	public int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityClassPK);

	public java.lang.String follow(
		com.sambaash.platform.model.spneo4j.form.FollowGraphForm followGraphForm);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK);

	/**
	* Setting up data to be sent to REST service Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isJoined(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isLiking(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public java.lang.String join(java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK, int type,
		int status, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	public java.lang.String like(
		com.sambaash.platform.model.spneo4j.form.LikeGraphForm likeGraphForm);

	/**
	* Doing the REST call and then displaying the result. This is code to post
	* and return a object.
	*/
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK);

	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK,
		boolean saveToDB);

	public java.lang.String pushRealtimeActivityFeed(
		com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm realtimeActivityFeedForm);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String removeAssetCategoryGraph(long categoryId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String removeAssetEntityGraph(java.lang.String className,
		long classPK, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String removeUserGraph(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String updateAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String updateAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm);

	/**
	* Setting up data to be sent to REST service. Doing the REST call and then
	* displaying the result. This is code to post and return a object.
	*/
	public java.lang.String updateUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm);

	public java.lang.String updateUserInterests(long userId,
		java.util.List<java.lang.Long> interestIds, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussions(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset);

	public java.lang.Long countDiscussions(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussionComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long discussionId, int start,
		int offset);

	public java.lang.Long countDiscussionComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long discussionId);

	public java.lang.Long countGroupComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long spGroupId);

	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDocumentComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset);

	public java.lang.Long countDocumentComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk);
}