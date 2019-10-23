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

package com.sambaash.platform.srv.graph.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.model.spneo4j.form.FollowGraphForm;
import com.sambaash.platform.model.spneo4j.form.JoinGraphForm;
import com.sambaash.platform.model.spneo4j.form.LikeGraphForm;
import com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm;
import com.sambaash.platform.model.spneo4j.form.UserGraphForm;
import com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphAlsoLikeWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper;
import com.sambaash.platform.portlet.spneo4j.util.ClassUtil;
import com.sambaash.platform.srv.graph.service.base.SPNeoforjLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.NoSuchSPLikesException;
import com.sambaash.platform.srv.spservices.model.SPLikes;
import com.sambaash.platform.srv.spservices.service.SPLikesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.persistence.SPLikesUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p neoforj local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SPNeoforjLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.service.base.SPNeoforjLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SPNeoforjLocalServiceUtil
 */
public class SPNeoforjLocalServiceImpl extends SPNeoforjLocalServiceBaseImpl {

	private static Log logger = LogFactoryUtil.getLog(SPNeoforjLocalServiceImpl.class);

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public String addAssetCategoryGraph(AssetCategoryGraphForm assetCategoryGraphForm) {
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/category/add");

			return rt.postForObject(uri, assetCategoryGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public String addAssetEntitiesInBatch(List<AssetEntityGraphForm> assetEntityGraphForms) {

		try {
			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/assetEntity/add_in_batch");

			return rt.postForObject(uri, assetEntityGraphForms, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public String addAssetEntityGraph(AssetEntityGraphForm assetEntityGraphForm) {
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/assetEntity/add");

			return rt.postForObject(uri, assetEntityGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public String addCategoriesInBatch(List<AssetCategoryGraphForm> assetCategoryGraphs) {

		try {
			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/category/add_in_batch");

			return rt.postForObject(uri, assetCategoryGraphs, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public String addUserGraph(UserGraphForm userGraphForm) {
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/user/add");

			return rt.postForObject(uri, userGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public String addUsersInBatch(List<UserGraphForm> userGrpahs) {

		try {
			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/user/add_in_batch");
			return rt.postForObject(uri, userGrpahs, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public ActivityFeedsWrapper findActivityFeeds(long userId, Long companyId, Long groupId, Long layoutSetId,
			String filterType, int start, int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));
			vars.put("filterType", filterType);
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_acitivity_feeds/{filterType}/{start}/{offset}");
			return restTemplate.getForObject(uri, ActivityFeedsWrapper.class, vars);
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());

			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return null;
	}

	public List<AssetEntityGraphAlsoLikeWrapper> findAlsoLikeAssetEntities(Long companyId, Long groupId,
			Long layoutSetId, String className, long classPK, int start, int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("className", className);
			vars.put("classPK", String.valueOf(classPK));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/assetEntity/{className}/{classPK}/find_also_like_asset_entities/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, AssetEntityGraphAlsoLikeWrapper[].class, vars));
		} catch (Exception e) {
			logger.error("Error : ", e);
		}

		return null;
	}

	public UserLikesWrapper findAssetEntitiesUserLikes(long userId, Long companyId, Long groupId, Long layoutSetId,
			int start, int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("id", String.valueOf(userId));
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_asset_entities_user_Likes/{start}/{offset}");
			return restTemplate.getForObject(uri, UserLikesWrapper.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}

		return null;
	}

	public int findAssetEntitiesUserLikesCount(long userId, Long companyId, Long groupId, Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_asset_entities_user_likes_count");

			return rt.getForObject(uri, Integer.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return -1;
	}

	public List<AssetEntityGraphWrapper> findAssetEntitiesUserMayBeInterested(long userId, Long companyId, Long groupId,
			Long layoutSetId) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_asset_entities_user_may_be_interested");
			return Arrays.asList(restTemplate.getForObject(uri, AssetEntityGraphWrapper[].class, vars));
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public AssetEntityGraphWrapper findAssetEntityGraph(Long companyId, Long groupId, Long layoutSetId,
			String className, long classPK) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("className", String.valueOf(className));
			vars.put("classPK", String.valueOf(classPK));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(
					SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}/assetEntity/{className}/{classPK}");
			return restTemplate.getForObject(uri, AssetEntityGraphWrapper.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public List<Long> findMyInterestedCategoryIds(long userId, Long companyId, Long groupId, Long layoutSetId) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}/user/{id}/interests");
			return Arrays.asList(restTemplate.getForObject(uri, Long[].class, vars));
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public List<UserGraphWrapper> findPeopleUserMayFollow(long userId, Long companyId, Long groupId, Long layoutSetId,
			int start, int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_people_user_may_follow/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, UserGraphWrapper[].class, vars));
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public ActivityFeedsWrapper findUserActivity(long userId, Long companyId, Long groupId, Long layoutSetId, int start,
			int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_user_acitivity/{start}/{offset}");
			return restTemplate.getForObject(uri, ActivityFeedsWrapper.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public List<UserGraphWrapper> findUserFollowers(long userId, Long companyId, Long groupId, Long layoutSetId,
			int start, int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_user_followers/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, UserGraphWrapper[].class, vars));
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public int findUserFollowersCount(long userId, Long companyId, Long groupId, Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			RestTemplate rt = newRestTemplate();

			String uri = new String(
					SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}//user/{id}/find_user_followers_count");

			return rt.getForObject(uri, Integer.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return -1;
	}

	public List<UserGraphWrapper> findUserFollowing(long userId, Long companyId, Long groupId, Long layoutSetId,
			int start, int offset) {

		try {
			// Setting up data to be sent to REST service

			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_user_following/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, UserGraphWrapper[].class, vars));
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public int findUserFollowingCount(long userId, Long companyId, Long groupId, Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			RestTemplate rt = newRestTemplate();

			String uri = new String(
					SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}/user/{id}/find_user_following_count");

			return rt.getForObject(uri, Integer.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return -1;
	}

	public ActivityFeedsWrapper findUserPosts(long userId, Long companyId, Long groupId, Long layoutSetId, int start,
			int offset) {

		try {
			// Setting up data to be sent to REST service
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{id}/find_user_posts/{start}/{offset}");
			return restTemplate.getForObject(uri, ActivityFeedsWrapper.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return null;
	}

	public int findUserPostsCount(long userId, Long companyId, Long groupId, Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			RestTemplate rt = newRestTemplate();

			String uri = new String(
					SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}/user/{id}/find_user_posts_count");

			return rt.getForObject(uri, Integer.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return -1;
	}

	public int findUsersWhoLikeCount(Long companyId, Long groupId, Long layoutSetId, String endEntityClassName,
			Long endEntityClassPK) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("endEntityClassName", endEntityClassName);
			vars.put("endEntityClassPK", String.valueOf(endEntityClassPK));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/find_user_who_like_count/{endEntityClassName}/{endEntityClassPK}");

			return rt.getForObject(uri, Integer.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return -1;
	}

	public String follow(FollowGraphForm followGraphForm) {

		try {
			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/follow");

			return rt.postForObject(uri, followGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public String follow(Long companyId, Long groupId, Long layoutSetId, String action, long startUserId,
			String endEntityClassName, long endEntityClassPK) {
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/follow");

			Date now = new Date();
			FollowGraphForm followGraphForm = new FollowGraphForm(null, action, startUserId, endEntityClassName,
					endEntityClassPK, now);

			Neo4jHelper.fillMandatoryFields(followGraphForm, companyId, groupId, layoutSetId);

			return rt.postForObject(uri, followGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}

		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public boolean isFollowing(Long companyId, Long groupId, Long layoutSetId, long startUserId,
			String endEntityClassName, long endEntityClassPK) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("startUserId", String.valueOf(startUserId));
			vars.put("endEntityClassName", endEntityClassName);
			vars.put("endEntityClassPK", String.valueOf(endEntityClassPK));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{startUserId}/is_following/{endEntityClassName}/{endEntityClassPK}");

			return rt.getForObject(uri, Boolean.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return false;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public boolean isJoined(Long companyId, Long groupId, Long layoutSetId, long startUserId, String endEntityClassName,
			long endEntityClassPK) {

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("startUserId", String.valueOf(startUserId));
			vars.put("endEntityClassName", endEntityClassName);
			vars.put("endEntityClassPK", String.valueOf(endEntityClassPK));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{startUserId}/is_joined/{endEntityClassName}/{endEntityClassPK}");

			return rt.getForObject(uri, Boolean.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return false;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public boolean isLiking(Long companyId, Long groupId, Long layoutSetId, long startUserId, String endEntityClassName,
			long endEntityClassPK) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("startUserId", String.valueOf(startUserId));
			vars.put("endEntityClassName", endEntityClassName);
			vars.put("endEntityClassPK", String.valueOf(endEntityClassPK));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/user/{startUserId}/is_liking/{endEntityClassName}/{endEntityClassPK}");

			return rt.getForObject(uri, Boolean.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return false;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public String join(String action, long startUserId, String endEntityClassName, long endEntityClassPK, int type,
			int status, Long companyId, Long groupId, Long layoutSetId) {
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/join");
			Date now = new Date();
			JoinGraphForm joinGraphForm = new JoinGraphForm(action, startUserId, endEntityClassName, endEntityClassPK,
					type, status, now);

			Neo4jHelper.fillMandatoryFields(joinGraphForm, companyId, groupId, layoutSetId);

			return rt.postForObject(uri, joinGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public String like(LikeGraphForm likeGraphForm) {

		try {
			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/like");

			return rt.postForObject(uri, likeGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Doing the REST call and then displaying the result. This is code to post
	 * and return a object.
	 *
	 */
	public String like(Long companyId, Long groupId, Long layoutSetId, String action, long startUserId,
			String endEntityClassName, long endEntityClassPK) {
		return like(companyId, groupId, layoutSetId, action, startUserId, endEntityClassName, endEntityClassPK, true);			
	}
	
	public String like(Long companyId, Long groupId, Long layoutSetId, String action, long startUserId,
			String endEntityClassName, long endEntityClassPK, boolean saveToDB) {
		try {
			if (saveToDB) {
				storeLikeInDatabase(companyId, groupId, layoutSetId, action, startUserId, endEntityClassName, endEntityClassPK);
			}
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/like");
			Date now = new Date();
			LikeGraphForm likeGraphForm = new LikeGraphForm(null, action, startUserId, endEntityClassName,
					endEntityClassPK, now);

			Neo4jHelper.fillMandatoryFields(likeGraphForm, companyId, groupId, layoutSetId);

			return rt.postForObject(uri, likeGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	private void storeLikeInDatabase(Long companyId, Long groupId,
			Long layoutSetId, String action, long startUserId,
			String endEntityClassName, long endEntityClassPK) throws SystemException {
		SPLikes spLike = null;
		Date now = new Date();
		try {
			spLike = SPLikesUtil.findByUserIdWithClassNameAndClassPK(companyId, groupId, startUserId, endEntityClassName, endEntityClassPK);
		} catch (NoSuchSPLikesException e) {
			logger.debug("Like record not found.", e);
		}
		if (spLike == null) {
			spLike = SPLikesLocalServiceUtil.createSPLikes(CounterLocalServiceUtil.increment(SPLikes.class.getName()));
			spLike.setCreateDate(now);
		}
		spLike.setModifiedDate(now);
		spLike.setCompanyId(companyId);
		spLike.setGroupId(groupId);
		spLike.setLayoutSetId(layoutSetId);
		spLike.setAction(action);
		spLike.setUserId(startUserId);
		spLike.setActorUserId(startUserId);
		spLike.setClassName(endEntityClassName);
		spLike.setClassPK(endEntityClassPK);
		spLike.setClassId(ClassUtil.getClassId(endEntityClassName));
		SPLikesLocalServiceUtil.updateSPLikes(spLike);
	}

	public String pushRealtimeActivityFeed(RealtimeActivityFeedForm realtimeActivityFeedForm) {

		try {
			// Doing the REST call and then displaying the result This is code
			// to
			// post and return a object

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getWebSocketHostUrl() + "/push_realtime_activity_feed");

			return rt.postForObject(uri, realtimeActivityFeedForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String removeAssetCategoryGraph(long categoryId, Long companyId, Long groupId, Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(categoryId));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}/category/delete/{id}");

			return rt.getForObject(uri, String.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String removeAssetEntityGraph(String className, long classPK, Long companyId, Long groupId,
			Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("className", className);
			vars.put("classPK", String.valueOf(classPK));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/assetEntity/delete/{className}/{classPK}");

			return rt.getForObject(uri, String.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String removeUserGraph(long userId, Long companyId, Long groupId, Long layoutSetId) {
		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("id", String.valueOf(userId));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/{virtualHost}/{groupId}/user/delete/{id}");

			return rt.getForObject(uri, String.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String updateAssetCategoryGraph(AssetCategoryGraphForm assetCategoryGraphForm) {

		try {
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("id", String.valueOf(assetCategoryGraphForm.getCategoryId()));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/category/update/{id}");

			return rt.postForObject(uri, assetCategoryGraphForm, String.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String updateAssetEntityGraph(AssetEntityGraphForm assetEntityGraphForm) {
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/assetEntity/update");

			return rt.postForObject(uri, assetEntityGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String updateJoinGraph(JoinGraphForm joinGraphForm) {
		try {
			Map<String, String> vars = new HashMap<String, String>();

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/assetEntity/join/update");

			return rt.postForObject(uri, joinGraphForm, String.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	/**
	 * Setting up data to be sent to REST service. Doing the REST call and then
	 * displaying the result. This is code to post and return a object.
	 *
	 */
	public String updateUserGraph(UserGraphForm userGraphForm) {
		try {
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("id", String.valueOf(userGraphForm.getUserId()));

			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/user/update/{id}");

			return rt.postForObject(uri, userGraphForm, String.class, vars);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public String updateUserInterests(long userId, List<Long> interestIds, Long companyId, Long groupId,
			Long layoutSetId) {

		// Doing the REST call and then displaying the result This is code to
		// post and return a object
		try {
			RestTemplate rt = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl() + "/user/update_interests");

			UserGraphForm userGraphForm = new UserGraphForm();
			userGraphForm.setUserId(userId);
			userGraphForm.setInterestIds(interestIds);
			Neo4jHelper.fillMandatoryFields(userGraphForm, companyId, groupId, layoutSetId);

			return rt.postForObject(uri, userGraphForm, String.class);
		} catch (Exception e) {
			logger.error("Error : ", e);
		}
		return StringPool.BLANK;
	}

	public List<AssetEntityGraphWrapper> findDiscussions (
			Long companyId, Long groupId, Long layoutSetId, 
			Long classNameId, Long classPk,	int start, int offset ) {

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("classNameId", String.valueOf(classNameId));
			vars.put("classPk", String.valueOf(classPk));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/discussion/class/{classNameId}/classPk/{classPk}/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, AssetEntityGraphWrapper[].class, vars)); 
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return null;
	}

	public Long countDiscussions (
			Long companyId, Long groupId, Long layoutSetId, 
			Long classNameId, Long classPk ) {

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("classNameId", String.valueOf(classNameId));
			vars.put("classPk", String.valueOf(classPk));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/discussion/class/{classNameId}/classPk/{classPk}/count");
			return restTemplate.getForObject(uri, Long.class, vars);
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return 0L;
	}

	public List<AssetEntityGraphWrapper> findDiscussionComments (
			Long companyId, Long groupId, Long layoutSetId, 
			Long discussionId, int start, int offset )	{

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("discussionId", String.valueOf(discussionId));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/discussion/id/{discussionId}/comments/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, AssetEntityGraphWrapper[].class, vars)); 
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return null;
	}

	public Long countDiscussionComments (
			Long companyId, Long groupId, Long layoutSetId, 
			Long discussionId )	{

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("discussionId", String.valueOf(discussionId));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/discussion/id/{discussionId}/comments/count");
			return restTemplate.getForObject(uri, Long.class, vars);
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return 0L;
	}
	
	public Long countGroupComments (
			Long companyId, Long groupId, Long layoutSetId, 
			Long spGroupId )	{

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("classPk", String.valueOf(spGroupId));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/spGroup/id/{classPk}/comments/count");
			return restTemplate.getForObject(uri, Long.class, vars);
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return 0L;
	}

	public List<AssetEntityGraphWrapper> findDocumentComments (
			Long companyId, Long groupId, Long layoutSetId, 
			Long classNameId, Long classPk, int start, int offset )	{

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("classNameId", String.valueOf(classNameId));
			vars.put("classPk", String.valueOf(classPk));
			vars.put("start", String.valueOf(start));
			vars.put("offset", String.valueOf(offset));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/document/{classNameId}/{classPk}/comments/{start}/{offset}");
			return Arrays.asList(restTemplate.getForObject(uri, AssetEntityGraphWrapper[].class, vars)); 
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return null;
	}

	public Long countDocumentComments (
			Long companyId, Long groupId, Long layoutSetId, 
			Long classNameId, Long classPk )	{

		try {
			String virtualHost = Neo4jHelper.getVirtualHost(companyId, groupId, layoutSetId);

			Map<String, String> vars = new HashMap<String, String>();
			vars.put("virtualHost", virtualHost);
			vars.put("groupId", groupId + "");
			vars.put("classNameId", String.valueOf(classNameId));
			vars.put("classPk", String.valueOf(classPk));

			RestTemplate restTemplate = newRestTemplate();

			String uri = new String(SambaashUtil.getNeo4jHostUrl()
					+ "/{virtualHost}/{groupId}/document/{classNameId}/{classPk}/comments/count");
			return restTemplate.getForObject(uri, Long.class, vars);
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error(e);
			}
		}
		return 0L;
	}
	
	
	private RestTemplate newRestTemplate() {
		RestTemplate rt = new RestTemplate();
		rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		rt.getMessageConverters().add(new StringHttpMessageConverter());
		return rt;
	}
	
}