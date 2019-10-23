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

package com.sambaash.platform.srv.spsocialprofile.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.oauth.SocialNetworkService;
import com.sambaash.oauth.facebook.model.contacts.ContactList;
import com.sambaash.oauth.facebook.model.likes.LikeList;
import com.sambaash.oauth.model.Contact;
import com.sambaash.oauth.model.Like;
import com.sambaash.oauth.model.Profile;
import com.sambaash.oauth.util.SocialNetworkServiceFactory;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.SOCIALNETWORK_TYPES;
import com.sambaash.platform.listener.PullLikesJob;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileFriendsLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfilePullAuditLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileLikeLocalServiceBaseImpl;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileFriendsUtil;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileLikeUtil;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the social profile like local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SocialProfileLikeLocalService}
 * interface.
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.SocialProfileLikeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SocialProfileLikeLocalServiceUtil
 */
public class SocialProfileLikeLocalServiceImpl extends
		SocialProfileLikeLocalServiceBaseImpl {

	public void addContactsAndLikes(User user, long scopeGroupId) {

		try {
			SocialProfile socialProfile = SocialProfileLocalServiceUtil
					.getSocialProfile(user.getUserId());
			String apiKey = PrefsPropsUtil.getString(
					PortalUtil.getDefaultCompanyId(),
					PropsKeys.FACEBOOK_CONNECT_APP_ID);
			String apiSecret = PrefsPropsUtil.getString(
					PortalUtil.getDefaultCompanyId(),
					PropsKeys.FACEBOOK_CONNECT_APP_SECRET);
			SocialNetworkService service = SocialNetworkServiceFactory
					.getSocialNetworkService(SocialNetworkService.FACEBOOK_SERVICE);
			service.setApiKey(apiKey);
			service.setApiSecret(apiSecret);
			service.setAccessToken(socialProfile.getFacebookAuthToken(),
					socialProfile.getFacebookAuthSecret());

			String profileServiceUrl = SambaashUtil.getParameter(
					SambaashConstants.FACEBOOK_PROFILE_URL, scopeGroupId);
			service.setServiceUrl(profileServiceUrl);

			Profile myProfile = service.retrieveProfile();

			// adding users likes

			if (myProfile != null && Validator.isNotNull(myProfile.getId())) {
				addLikes(user, myProfile.getLikeList(), scopeGroupId,
						Long.parseLong(myProfile.getId()));
			} else {
				if (_log.isDebugEnabled()) {
					_log.debug("Error : addLikesForUser : profile is null or socialNetworkProfileId is null for userId : "
							+ user.getUserId());
				}
			}

			boolean isPullFriends = StringPool.TRUE
					.equalsIgnoreCase(SambaashUtil.getParameter(
							SambaashConstants.FACEBOOK_PULL_FRIENDS,
							Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true
					: false;

			if (isPullFriends) {
				ContactList contacts = myProfile.getContactList();

				if (contacts != null && contacts.getContacts() != null
						&& contacts.getContacts().size() > 0) {
					for (Contact contact : contacts.getContacts()) {
						String friendUrl = SambaashUtil.getParameter(
								SambaashConstants.FACEBOOK_FRIENDS_URL,
								scopeGroupId);
						friendUrl = friendUrl.replace("$1", contact.getId());
						service.setServiceUrl(friendUrl);
						service.setAccessToken(
								socialProfile.getFacebookAuthToken(),
								socialProfile.getFacebookAuthSecret());
						Profile profile = service.retrieveProfile();

						if (profile != null
								&& Validator.isNotNull(profile.getId())) {

							if (_log.isDebugEnabled()) {
								_log.debug("user.getCompanyId() : "
										+ user.getCompanyId()
										+ " : user.getUserId() : "
										+ user.getUserId()
										+ " : profile.getId() : "
										+ profile.getId());
							}

							SocialProfileFriends socialProfileFriends = getFriend(
									user.getCompanyId(), user.getUserId(),
									Long.parseLong(profile.getId()));

							if (socialProfileFriends == null) {
								Date now = new Date();
								long socialProfileFriendsId = CounterLocalServiceUtil
										.increment("SocialProfileFriends.class");
								socialProfileFriends = SocialProfileFriendsLocalServiceUtil
										.createSocialProfileFriends(socialProfileFriendsId);
								socialProfileFriends.setFirstName(profile
										.getFirstname());
								socialProfileFriends.setLastName(profile
										.getLastname());
								socialProfileFriends.setBirthday(profile
										.getBirthday());
								socialProfileFriends.setPictureUrl(profile
										.getPictureUrl());
								socialProfileFriends.setLocation(profile
										.getLocation());
								socialProfileFriends.setCompanyId(user
										.getCompanyId());
								socialProfileFriends
										.setGender("male"
												.equalsIgnoreCase(profile
														.getGender()) ? 1 : 0);
								socialProfileFriends.setUserName(profile
										.getUsername());
								socialProfileFriends
										.setSocialNetworkProfileId(Long
												.parseLong(profile.getId()));
								socialProfileFriends.setBelongsToUserId(user
										.getUserId());
								socialProfileFriends
										.setSocialNetworkType(SOCIALNETWORK_TYPES.FACEBOOK);
								socialProfileFriends.setCreateDate(now);
								socialProfileFriends.setModifiedDate(now);
								try {
									SocialProfileFriendsLocalServiceUtil
											.updateSocialProfileFriends(socialProfileFriends);
								} catch (Exception e) {
									if (_log.isDebugEnabled()) {
										_log.error(e.getMessage());
									}
								}
							}

							// add users friends likes

							boolean isPullFriendsLike = StringPool.TRUE
									.equalsIgnoreCase(SambaashUtil
											.getParameter(
													SambaashConstants.FACEBOOK_PULL_FRIENDS_LIKES,
													Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true
									: false;

							if (isPullFriendsLike) {
								addLikes(user, profile.getLikeList(),
										scopeGroupId,
										Long.parseLong(profile.getId()));
							} else {
								if (_log.isDebugEnabled()) {
									_log.debug(SambaashConstants.FACEBOOK_PULL_FRIENDS_LIKES
											+ " parameter is false.");
								}
							}

						} else {
							if (_log.isDebugEnabled()) {
								_log.debug("Error : addLikesForUserFriend : profile is null or socialNetworkProfileId is null.");
							}
						}
					}
				}

				if (myProfile != null && contacts != null
						&& contacts.getContacts() != null) {
					SocialProfilePullAudit socialProfilePullAudit = null;
					try {
						socialProfilePullAudit = SocialProfilePullAuditUtil
								.findByUserIdAndSocialNetworkProfileId(
										PortalUtil.getDefaultCompanyId(),
										user.getUserId(),
										Long.parseLong(myProfile.getId()));
					} catch (NoSuchSocialProfilePullAuditException e) {
					}

					if (socialProfilePullAudit == null) {
						SocialProfilePullAuditPK socialProfilePullAuditPK = new SocialProfilePullAuditPK(
								user.getUserId(), Long.parseLong(myProfile
										.getId()));
						socialProfilePullAudit = SocialProfilePullAuditLocalServiceUtil
								.createSocialProfilePullAudit(socialProfilePullAuditPK);
						socialProfilePullAudit.setLastQueriedDate(new Date());
						socialProfilePullAudit.setCompanyId(PortalUtil
								.getDefaultCompanyId());
						socialProfilePullAudit.setCreateDate(new Date());
						SocialProfilePullAuditLocalServiceUtil
								.updateSocialProfilePullAudit(socialProfilePullAudit);
					} else {
						socialProfilePullAudit.setLastQueriedDate(new Date());
						SocialProfilePullAuditLocalServiceUtil
								.updateSocialProfilePullAudit(socialProfilePullAudit);
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public SocialProfileLike findByLikeIdAndSocialNetworkProfileId(
			long socialNetworkProfileId, long socialNetworkLikeId,
			int socialNetworkType) throws SystemException {

		try {
			return SocialProfileLikeUtil.findByLikeIdAndSocialNetworkProfileId(
					socialNetworkLikeId, socialNetworkProfileId,
					socialNetworkType);
		} catch (NoSuchSocialProfileLikeException e) {
			_log.debug("SocialProfileLike not found with socialNetworkProfileId : "
					+ socialNetworkProfileId
					+ " : socialNetworkLikeId : "
					+ socialNetworkLikeId);
		}

		return null;
	}

	/**
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SocialProfileLikeLocalServiceUtil}
	 * to access the social profile like local service.
	 */

	public List<SocialProfileLike> findBySocialNetworkProfileId(long companyId,
			long socialNetworkProfileId, int socialNetworkType)
			throws SystemException {

		return SocialProfileLikeUtil.findBySocialNetworkProfileId(
				socialNetworkProfileId, socialNetworkType);
	}

	public SocialProfileFriends getFriend(long companyId, long belongsToUserId,
			long socialNetworkProfileId) throws SystemException {

		try {
			return SocialProfileFriendsUtil.findByUserIdAndSNProfileId(
					companyId, belongsToUserId, socialNetworkProfileId);
		} catch (NoSuchSocialProfileFriendsException e) {
			_log.debug("SocialProfileFriend not found with socialNetworkProfileId : "
					+ socialNetworkProfileId);
		}

		return null;
	}

	public void scheduleLikesJob(long userId, long socialNetworkProfileId)
			throws SystemException {

		SocialProfilePullAudit socialProfilePullAudit = null;

		Calendar curTime = Calendar.getInstance();
		boolean allowSheduling = true;

		boolean isPullUserLike = StringPool.TRUE.equalsIgnoreCase(SambaashUtil
				.getParameter(SambaashConstants.FACEBOOK_PULL_LIKES,
						Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true
				: false;

		int timeBetweenNextJob = Integer.parseInt(SambaashUtil.getParameter(
				SambaashConstants.FACEBOOK_DIFFERENCE_IN_HOURS,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID)));

		curTime.add(Calendar.HOUR_OF_DAY, -timeBetweenNextJob);

		try {
			socialProfilePullAudit = SocialProfilePullAuditUtil
					.findByUserIdAndSocialNetworkProfileId(
							PortalUtil.getDefaultCompanyId(), userId,
							socialNetworkProfileId);
		} catch (NoSuchSocialProfilePullAuditException e) {
		}

		if (socialProfilePullAudit != null) {
			if (socialProfilePullAudit.getLastQueriedDate().after(
					curTime.getTime())) {
				allowSheduling = false;
			}

			if (_log.isInfoEnabled()) {
				_log.info("socialProfilePullAudit.getLastQueriedDate() : "
						+ socialProfilePullAudit.getLastQueriedDate()
						+ " : allowSheduling : " + allowSheduling);
			}
		}

		if (isPullUserLike && allowSheduling) {
			Calendar _startDate = CalendarFactoryUtil.getCalendar(
					TimeZoneUtil.getDefault(), LocaleUtil.getDefault());
			_startDate.add(Calendar.MINUTE, 2);
			StringBundler sb = new StringBundler(13);
			sb.append(String.valueOf(_startDate.get(Calendar.SECOND)));
			sb.append(StringPool.SPACE);
			sb.append(String.valueOf(_startDate.get(Calendar.MINUTE)));
			sb.append(StringPool.SPACE);
			sb.append(String.valueOf(_startDate.get(Calendar.HOUR_OF_DAY)));
			sb.append(StringPool.SPACE);
			sb.append(String.valueOf(_startDate.get(Calendar.DAY_OF_MONTH)));
			sb.append(StringPool.SPACE);
			sb.append(String.valueOf(_startDate.get(Calendar.MONTH) + 1));
			sb.append(StringPool.SPACE);
			sb.append(StringPool.QUESTION);
			sb.append(StringPool.SPACE);
			sb.append(String.valueOf(_startDate.get(Calendar.YEAR)));

			if (_log.isDebugEnabled()) {
				_log.debug(userId + " : cron time to pull likes : "
						+ sb.toString());
			}

			SchedulerEntry entry = new SchedulerEntryImpl();
			entry.setEventListenerClass(PullLikesJob.class.getName());
			entry.setTriggerValue(sb.toString());
			entry.setTriggerType(TriggerType.CRON);
			entry.setDescription(String.valueOf(userId)
					+ ":pull_likes_asynchronously");

			try {
				unschedule(userId);
				SchedulerEngineHelperUtil.schedule(entry,
						StorageType.PERSISTED,
						"UserProfile_WAR_UserProfileportlet", 5);
			} catch (SchedulerException e) {
				_log.error(e);
			}
		} else {
			if (_log.isInfoEnabled()) {
				_log.info(SambaashConstants.FACEBOOK_PULL_LIKES
						+ " parameter is false. Likes job will not be scheduled.");
			}
		}
	}

	public void unschedule(long userId) throws SchedulerException,
			SystemException {

		List<SchedulerResponse> schedulerResponses = SchedulerEngineHelperUtil
				.getScheduledJobs(PullLikesJob.class.getName(),
						StorageType.PERSISTED);

		for (SchedulerResponse sr : schedulerResponses) {
			if (sr.getTrigger() != null) {
				if (sr.getTrigger()
						.getJobName()
						.equalsIgnoreCase(
								String.valueOf(userId)
										+ ":pull_likes_asynchronously")) {
					try {
						SchedulerEngineHelperUtil.unschedule(sr.getTrigger()
								.getJobName(), sr.getTrigger().getGroupName(),
								StorageType.PERSISTED);
					} catch (Exception e) {
						_log.error("Unable to unschedule");
					}

					try {
						SchedulerEngineHelperUtil.delete(sr.getTrigger()
								.getJobName(), sr.getTrigger().getGroupName(),
								StorageType.PERSISTED);
					} catch (Exception e) {
						_log.error("Unable to delete");
					}
				}
			}
		}
	}

	private void addLikes(User user, LikeList likeList, long scopeGroupId,
			long socialNetworkProfileId) {

		try {
			if (likeList != null && likeList.getLikes() != null
					&& likeList.getLikes().size() > 0) {

				if (_log.isDebugEnabled()) {
					_log.debug("addLikes : likeList.getLikes().size() : "
							+ likeList.getLikes().size());
				}

				Date now = new Date();

				for (Like like : likeList.getLikes()) {
					try {
						SocialProfileLike socialProfileLike = findByLikeIdAndSocialNetworkProfileId(
								socialNetworkProfileId,
								Long.parseLong(like.getId()),
								SOCIALNETWORK_TYPES.FACEBOOK);

						if (socialProfileLike == null) {
							socialProfileLike = SocialProfileLikeLocalServiceUtil
									.createSocialProfileLike(CounterLocalServiceUtil
											.increment("SocialProfileLike.class"));
							socialProfileLike
									.setSocialNetworkProfileId(socialNetworkProfileId);
							socialProfileLike.setSocialNetworkLikeId(Long
									.parseLong(like.getId()));
							socialProfileLike.setCategory(like.getCategory());
							socialProfileLike.setName(like.getName());
							socialProfileLike.setSocialNetworkCreateDate(like
									.getCreateDate());
							socialProfileLike
									.setSocialNetworkType(SambaashConstants.SOCIALNETWORK_TYPES.FACEBOOK);
							socialProfileLike.setCreateDate(now);
							socialProfileLike.setModifiedDate(now);
							SocialProfileLikeLocalServiceUtil
									.updateSocialProfileLike(socialProfileLike);

						} else {
							if (_log.isDebugEnabled()) {
								_log.debug("addLikes : Update" + like.getName());
							}
						}
					} catch (Exception e) {
						_log.error("addLikes : Error inserting like : "
								+ like.getName());
					}
				}
			} else {
				_log.error("addLikes : likeList.getLikes() is null for "
						+ socialNetworkProfileId);
			}

		} catch (Exception e) {
			_log.error("addLikes : Error inserting likes.");
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(SocialProfileLikeLocalServiceImpl.class);

}