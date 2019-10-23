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

package com.sambaash.platform.srv.graph.service.base;

import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;

import java.util.Arrays;

/**
 * @author harini
 * @generated
 */
public class SPNeoforjLocalServiceClpInvoker {
	public SPNeoforjLocalServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "addAssetCategoryGraph";

		_methodParameterTypes20 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm"
			};

		_methodName21 = "addAssetEntitiesInBatch";

		_methodParameterTypes21 = new String[] { "java.util.List" };

		_methodName22 = "addAssetEntityGraph";

		_methodParameterTypes22 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm"
			};

		_methodName23 = "addCategoriesInBatch";

		_methodParameterTypes23 = new String[] { "java.util.List" };

		_methodName24 = "addUserGraph";

		_methodParameterTypes24 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.UserGraphForm"
			};

		_methodName25 = "addUsersInBatch";

		_methodParameterTypes25 = new String[] { "java.util.List" };

		_methodName26 = "findActivityFeeds";

		_methodParameterTypes26 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "int", "int"
			};

		_methodName27 = "findAlsoLikeAssetEntities";

		_methodParameterTypes27 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "int", "int"
			};

		_methodName28 = "findAssetEntitiesUserLikes";

		_methodParameterTypes28 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName29 = "findAssetEntitiesUserLikesCount";

		_methodParameterTypes29 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName30 = "findAssetEntitiesUserMayBeInterested";

		_methodParameterTypes30 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName31 = "findAssetEntityGraph";

		_methodParameterTypes31 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long"
			};

		_methodName32 = "findMyInterestedCategoryIds";

		_methodParameterTypes32 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName33 = "findPeopleUserMayFollow";

		_methodParameterTypes33 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName34 = "findUserActivity";

		_methodParameterTypes34 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName35 = "findUserFollowers";

		_methodParameterTypes35 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName36 = "findUserFollowersCount";

		_methodParameterTypes36 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName37 = "findUserFollowing";

		_methodParameterTypes37 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName38 = "findUserFollowingCount";

		_methodParameterTypes38 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName39 = "findUserPosts";

		_methodParameterTypes39 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName40 = "findUserPostsCount";

		_methodParameterTypes40 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName41 = "findUsersWhoLikeCount";

		_methodParameterTypes41 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "java.lang.Long"
			};

		_methodName42 = "follow";

		_methodParameterTypes42 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.FollowGraphForm"
			};

		_methodName43 = "follow";

		_methodParameterTypes43 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName44 = "isFollowing";

		_methodParameterTypes44 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName45 = "isJoined";

		_methodParameterTypes45 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName46 = "isLiking";

		_methodParameterTypes46 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName47 = "join";

		_methodParameterTypes47 = new String[] {
				"java.lang.String", "long", "java.lang.String", "long", "int",
				"int", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName48 = "like";

		_methodParameterTypes48 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.LikeGraphForm"
			};

		_methodName49 = "like";

		_methodParameterTypes49 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName50 = "like";

		_methodParameterTypes50 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long",
				"boolean"
			};

		_methodName52 = "pushRealtimeActivityFeed";

		_methodParameterTypes52 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm"
			};

		_methodName53 = "removeAssetCategoryGraph";

		_methodParameterTypes53 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName54 = "removeAssetEntityGraph";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName55 = "removeUserGraph";

		_methodParameterTypes55 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName56 = "updateAssetCategoryGraph";

		_methodParameterTypes56 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm"
			};

		_methodName57 = "updateAssetEntityGraph";

		_methodParameterTypes57 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm"
			};

		_methodName58 = "updateJoinGraph";

		_methodParameterTypes58 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.JoinGraphForm"
			};

		_methodName59 = "updateUserGraph";

		_methodParameterTypes59 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.UserGraphForm"
			};

		_methodName60 = "updateUserInterests";

		_methodParameterTypes60 = new String[] {
				"long", "java.util.List", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName61 = "findDiscussions";

		_methodParameterTypes61 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "int", "int"
			};

		_methodName62 = "countDiscussions";

		_methodParameterTypes62 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long"
			};

		_methodName63 = "findDiscussionComments";

		_methodParameterTypes63 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "int", "int"
			};

		_methodName64 = "countDiscussionComments";

		_methodParameterTypes64 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName65 = "countGroupComments";

		_methodParameterTypes65 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName66 = "findDocumentComments";

		_methodParameterTypes66 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "int", "int"
			};

		_methodName67 = "countDocumentComments";

		_methodParameterTypes67 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPNeoforjLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.addAssetCategoryGraph((com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm)arguments[0]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.addAssetEntitiesInBatch((java.util.List<com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm>)arguments[0]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.addAssetEntityGraph((com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm)arguments[0]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.addCategoriesInBatch((java.util.List<com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm>)arguments[0]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.addUserGraph((com.sambaash.platform.model.spneo4j.form.UserGraphForm)arguments[0]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.addUsersInBatch((java.util.List<com.sambaash.platform.model.spneo4j.form.UserGraphForm>)arguments[0]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findActivityFeeds(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findAlsoLikeAssetEntities((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findAssetEntitiesUserLikes(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findAssetEntitiesUserLikesCount(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findAssetEntitiesUserMayBeInterested(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findAssetEntityGraph((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findMyInterestedCategoryIds(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findPeopleUserMayFollow(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserActivity(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserFollowers(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserFollowersCount(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserFollowing(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserFollowingCount(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserPosts(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUserPostsCount(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findUsersWhoLikeCount((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3], (java.lang.Long)arguments[4]);
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.follow((com.sambaash.platform.model.spneo4j.form.FollowGraphForm)arguments[0]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.follow((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], ((Long)arguments[6]).longValue());
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.isFollowing((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.isJoined((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.isLiking((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.join((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(java.lang.Long)arguments[6], (java.lang.Long)arguments[7],
				(java.lang.Long)arguments[8]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.like((com.sambaash.platform.model.spneo4j.form.LikeGraphForm)arguments[0]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.like((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], ((Long)arguments[6]).longValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.like((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Boolean)arguments[7]).booleanValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.pushRealtimeActivityFeed((com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm)arguments[0]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.removeAssetCategoryGraph(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.removeAssetEntityGraph((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.removeUserGraph(((Long)arguments[0]).longValue(),
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.updateAssetCategoryGraph((com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm)arguments[0]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.updateAssetEntityGraph((com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.updateJoinGraph((com.sambaash.platform.model.spneo4j.form.JoinGraphForm)arguments[0]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.updateUserGraph((com.sambaash.platform.model.spneo4j.form.UserGraphForm)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.updateUserInterests(((Long)arguments[0]).longValue(),
				(java.util.List<java.lang.Long>)arguments[1],
				(java.lang.Long)arguments[2], (java.lang.Long)arguments[3],
				(java.lang.Long)arguments[4]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findDiscussions((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.countDiscussions((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findDiscussionComments((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.countDiscussionComments((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.countGroupComments((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.findDocumentComments((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return SPNeoforjLocalServiceUtil.countDocumentComments((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
}