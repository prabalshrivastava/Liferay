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

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author harini
 * @generated
 */
public class SPNeoforjLocalServiceClp implements SPNeoforjLocalService {
	public SPNeoforjLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addAssetCategoryGraph";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm"
			};

		_methodName4 = "addAssetEntitiesInBatch";

		_methodParameterTypes4 = new String[] { "java.util.List" };

		_methodName5 = "addAssetEntityGraph";

		_methodParameterTypes5 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm"
			};

		_methodName6 = "addCategoriesInBatch";

		_methodParameterTypes6 = new String[] { "java.util.List" };

		_methodName7 = "addUserGraph";

		_methodParameterTypes7 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.UserGraphForm"
			};

		_methodName8 = "addUsersInBatch";

		_methodParameterTypes8 = new String[] { "java.util.List" };

		_methodName9 = "findActivityFeeds";

		_methodParameterTypes9 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "int", "int"
			};

		_methodName10 = "findAlsoLikeAssetEntities";

		_methodParameterTypes10 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "int", "int"
			};

		_methodName11 = "findAssetEntitiesUserLikes";

		_methodParameterTypes11 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName12 = "findAssetEntitiesUserLikesCount";

		_methodParameterTypes12 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName13 = "findAssetEntitiesUserMayBeInterested";

		_methodParameterTypes13 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName14 = "findAssetEntityGraph";

		_methodParameterTypes14 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long"
			};

		_methodName15 = "findMyInterestedCategoryIds";

		_methodParameterTypes15 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName16 = "findPeopleUserMayFollow";

		_methodParameterTypes16 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName17 = "findUserActivity";

		_methodParameterTypes17 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName18 = "findUserFollowers";

		_methodParameterTypes18 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName19 = "findUserFollowersCount";

		_methodParameterTypes19 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName20 = "findUserFollowing";

		_methodParameterTypes20 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName21 = "findUserFollowingCount";

		_methodParameterTypes21 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName22 = "findUserPosts";

		_methodParameterTypes22 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long",
				"int", "int"
			};

		_methodName23 = "findUserPostsCount";

		_methodParameterTypes23 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName24 = "findUsersWhoLikeCount";

		_methodParameterTypes24 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "java.lang.Long"
			};

		_methodName25 = "follow";

		_methodParameterTypes25 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.FollowGraphForm"
			};

		_methodName26 = "follow";

		_methodParameterTypes26 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName27 = "isFollowing";

		_methodParameterTypes27 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName28 = "isJoined";

		_methodParameterTypes28 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName29 = "isLiking";

		_methodParameterTypes29 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName30 = "join";

		_methodParameterTypes30 = new String[] {
				"java.lang.String", "long", "java.lang.String", "long", "int",
				"int", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName31 = "like";

		_methodParameterTypes31 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.LikeGraphForm"
			};

		_methodName32 = "like";

		_methodParameterTypes32 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName33 = "like";

		_methodParameterTypes33 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long",
				"boolean"
			};

		_methodName34 = "pushRealtimeActivityFeed";

		_methodParameterTypes34 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm"
			};

		_methodName35 = "removeAssetCategoryGraph";

		_methodParameterTypes35 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName36 = "removeAssetEntityGraph";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName37 = "removeUserGraph";

		_methodParameterTypes37 = new String[] {
				"long", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName38 = "updateAssetCategoryGraph";

		_methodParameterTypes38 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm"
			};

		_methodName39 = "updateAssetEntityGraph";

		_methodParameterTypes39 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm"
			};

		_methodName40 = "updateJoinGraph";

		_methodParameterTypes40 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.JoinGraphForm"
			};

		_methodName41 = "updateUserGraph";

		_methodParameterTypes41 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.UserGraphForm"
			};

		_methodName42 = "updateUserInterests";

		_methodParameterTypes42 = new String[] {
				"long", "java.util.List", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName43 = "findDiscussions";

		_methodParameterTypes43 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "int", "int"
			};

		_methodName44 = "countDiscussions";

		_methodParameterTypes44 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long"
			};

		_methodName45 = "findDiscussionComments";

		_methodParameterTypes45 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "int", "int"
			};

		_methodName46 = "countDiscussionComments";

		_methodParameterTypes46 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName47 = "countGroupComments";

		_methodParameterTypes47 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName48 = "findDocumentComments";

		_methodParameterTypes48 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "int", "int"
			};

		_methodName49 = "countDocumentComments";

		_methodParameterTypes49 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String addAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(assetCategoryGraphForm)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addAssetEntitiesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm> assetEntityGraphForms) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(assetEntityGraphForms)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(assetEntityGraphForm)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addCategoriesInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm> assetCategoryGraphs) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(assetCategoryGraphs)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(userGraphForm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addUsersInBatch(
		java.util.List<com.sambaash.platform.model.spneo4j.form.UserGraphForm> userGrpahs) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(userGrpahs) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findActivityFeeds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String filterType, int start,
		int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(filterType),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphAlsoLikeWrapper> findAlsoLikeAssetEntities(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK,
		int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(className),
						
					classPK,
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphAlsoLikeWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper findAssetEntitiesUserLikes(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int findAssetEntitiesUserLikesCount(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findAssetEntitiesUserMayBeInterested(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper findAssetEntityGraph(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.String className, long classPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(className),
						
					classPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<java.lang.Long> findMyInterestedCategoryIds(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.Long>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findPeopleUserMayFollow(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserActivity(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowers(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int findUserFollowersCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper> findUserFollowing(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int findUserFollowingCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper findUserPosts(
		long userId, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int findUserPostsCount(long userId, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(endEntityClassName),
						
					ClpSerializer.translateInput(endEntityClassPK)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.lang.String follow(
		com.sambaash.platform.model.spneo4j.form.FollowGraphForm followGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] { ClpSerializer.translateInput(followGraphForm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean isJoined(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean isLiking(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public java.lang.String join(java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK, int type,
		int status, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK,
						
					type,
						
					status,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String like(
		com.sambaash.platform.model.spneo4j.form.LikeGraphForm likeGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] { ClpSerializer.translateInput(likeGraphForm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK,
		boolean saveToDB) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK,
						
					saveToDB
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String pushRealtimeActivityFeed(
		com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm realtimeActivityFeedForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						ClpSerializer.translateInput(realtimeActivityFeedForm)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String removeAssetCategoryGraph(long categoryId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String removeAssetEntityGraph(java.lang.String className,
		long classPK, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						ClpSerializer.translateInput(className),
						
					classPK,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String removeUserGraph(long userId,
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateAssetCategoryGraph(
		com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm assetCategoryGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] {
						ClpSerializer.translateInput(assetCategoryGraphForm)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateAssetEntityGraph(
		com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm assetEntityGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] {
						ClpSerializer.translateInput(assetEntityGraphForm)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { ClpSerializer.translateInput(joinGraphForm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateUserGraph(
		com.sambaash.platform.model.spneo4j.form.UserGraphForm userGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] { ClpSerializer.translateInput(userGraphForm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String updateUserInterests(long userId,
		java.util.List<java.lang.Long> interestIds, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(interestIds),
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussions(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(classNameId),
						
					ClpSerializer.translateInput(classPk),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Long countDiscussions(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(classNameId),
						
					ClpSerializer.translateInput(classPk)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Long)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDiscussionComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long discussionId, int start,
		int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(discussionId),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Long countDiscussionComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long discussionId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(discussionId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Long)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Long countGroupComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long spGroupId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(spGroupId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Long)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper> findDocumentComments(
		java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, java.lang.Long classNameId,
		java.lang.Long classPk, int start, int offset) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(classNameId),
						
					ClpSerializer.translateInput(classPk),
						
					start,
						
					offset
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Long countDocumentComments(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.Long classNameId, java.lang.Long classPk) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(classNameId),
						
					ClpSerializer.translateInput(classPk)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Long)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
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
}