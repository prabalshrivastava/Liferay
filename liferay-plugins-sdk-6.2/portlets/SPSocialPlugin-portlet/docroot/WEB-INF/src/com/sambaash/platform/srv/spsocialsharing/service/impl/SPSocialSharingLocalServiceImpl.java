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

package com.sambaash.platform.srv.spsocialsharing.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.mail.internet.InternetAddress;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.calendar.model.CalEvent;
import com.sambaash.oauth.SocialNetworkException;
import com.sambaash.oauth.SocialNetworkService;
import com.sambaash.oauth.model.Post;
import com.sambaash.oauth.util.SocialNetworkServiceFactory;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.socialplugin.util.SocialPluginsConstants;
import com.sambaash.platform.portlet.socialplugin.util.SocialSharingUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;
import com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing;
import com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalServiceUtil;
import com.sambaash.platform.srv.spsocialsharing.service.base.SPSocialSharingLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p social sharing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.spsocialsharing.service.base.SPSocialSharingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalServiceUtil
 */
public class SPSocialSharingLocalServiceImpl extends
		SPSocialSharingLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link sambaash.platform .srv.socialplugins.service.SocialSharingLocalServiceUtil}
	 * to access the social sharing local service.
	 */
	public SPSocialSharing findByClassNameIdAndClassPK(long classNameId,
			long classPK) throws NoSuchSPSocialSharingException,
			SystemException {
		return spSocialSharingPersistence.findByclassNameIdAndClassPK(
				classNameId, classPK);
	}

	/**
	 * This method will auto-share blog entry link to different social networks,
	 * given that a user has been linked his account to his profile 1. Facebook
	 * - The link to the published blog will be posted to the wall/timeline 2.
	 * Twitter - The link to the published blog will be posted as a new tweet 3.
	 * Linkedin - The link to the published blog will be posted as a status
	 * update
	 *
	 * Parameters: blogId - Id of the blog entry Title - the title of the blog
	 * entry altMessage - Assign a value to override the default message that
	 * will be posted to social network url - The link of the blog imgUrl - URL
	 * of the image
	 *
	 * (non-Javadoc)
	 *
	 * @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	 *      #postBlogToSocialNetwork(long, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, long, long,
	 *      sambaash.platform.srv.socialprofile.model.SocialProfile,
	 *      com.liferay.portal.model.User)
	 */
	public void postBlogToSocialNetwork(long blogId, String title,
			String altMessage, String url, String imgUrl, long companyId,
			long groupId, SocialProfile socialProfile, User user) {

		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(BlogsEntry.class);
		SPSocialSharing SPSocialSharing = null;

		try {
			SPSocialSharing = SPSocialSharingLocalServiceUtil
					.findByClassNameIdAndClassPK(classNameId, blogId);
		} catch (NoSuchSPSocialSharingException e) {
			_log.error("SPSocialSharing record not found. ");
		} catch (SystemException e) {
			_log.error(e);
		}

		if (Validator.isNull(SPSocialSharing)) {
			_log.info("Creating SPSocialSharing entry...");
			long shareId;
			try {
				shareId = CounterLocalServiceUtil
						.increment("SPSocialSharing.class");
				SPSocialSharing = SPSocialSharingLocalServiceUtil
						.createSPSocialSharing(shareId);
				SPSocialSharing.setClassNameId(classNameId);
				SPSocialSharing.setClassPK(blogId);
				SPSocialSharing.setCreateDate(new Date());
				SPSocialSharing.setModifiedDate(new Date());
				SPSocialSharingLocalServiceUtil
						.updateSPSocialSharing(SPSocialSharing);
			} catch (SystemException e) {
				_log.error("Error adding social sharing", e);
			}
		}

		String message = SocialSharingUtil.getMessageResourceBundle(
				SocialPluginsConstants.POST_BLOGS, groupId);

		if (Validator.isNull(message)) {
			message = altMessage;
		}

		if (SPSocialSharing.getFacebook() == 0) {

			// publish to Facebook

			try {
				int fbStatus = SPSocialSharingLocalServiceUtil
						.publishToFacebook(title, message, url, imgUrl,
								groupId, companyId, socialProfile);

				if (fbStatus == 200) {
					SPSocialSharingLocalServiceUtil.updateFacebookShareStatus(
							classNameId, blogId, 1);
				}
			} catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.error("Error sharing blog to Facebook. ", e);
				}

				SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
						user.getEmailAddress(), user.getFullName(),
						e.getMessage(),
						"Blogs: Error publishing to Facebook - " + title,
						user.getCompanyId(), groupId);
			}
		}

		if (SPSocialSharing.getLinkedin() == 0) {

			// share to linkedin

			try {
				int linkedinStatus = SPSocialSharingLocalServiceUtil
						.publishToLinkedIn(title, message, url, imgUrl,
								groupId, companyId, socialProfile);

				if (linkedinStatus == 201) {
					SPSocialSharingLocalServiceUtil.updateLinkedInShareStatus(
							classNameId, blogId, 1);
				}
			} catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.error("Error sharing blog to Linkedin. ", e);
				}

				SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
						user.getEmailAddress(), user.getFullName(),
						e.getMessage(),
						"Blogs: Error publishing to linkedin - " + title,
						user.getCompanyId(), groupId);
			}
		}

		if (SPSocialSharing.getTwitter() == 0) {

			// share to twitter

			try {
				int twitterStatus = SPSocialSharingLocalServiceUtil
						.publishToTwitter(message, url, imgUrl, groupId,
								companyId, socialProfile);

				if (twitterStatus == 200) {
					SPSocialSharingLocalServiceUtil.updateTwitterShareStatus(
							classNameId, blogId, 1);
				}
			} catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.error("Error sharing blog to Twitter. ", e);
				}

				SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
						user.getEmailAddress(), user.getFullName(),
						e.getMessage(), "Blogs: Error publishing to twitter - "
								+ title, user.getCompanyId(), groupId);
			}
		}

		if (SPSocialSharing.getFacebookPage() == 0) {

			// share to facebook page

			try {
				int fbPageStatus = SPSocialSharingLocalServiceUtil
						.publishToFacebookPage(title, message, url, imgUrl,
								groupId, companyId, socialProfile);

				if (fbPageStatus == 200) {
					SPSocialSharingLocalServiceUtil
							.updateFacebookPageShareStatus(classNameId, blogId,
									1);
				}
			} catch (SocialNetworkException e) {

				// Send email notification to admin when error encountered while
				// publishing to Facebook

				SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
						user.getEmailAddress(), user.getFullName(),
						e.getMessage(),
						"Blogs: Error publishing to Facebook - " + title,
						user.getCompanyId(), groupId);
			} catch (Exception e) {
				SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
						user.getEmailAddress(), user.getFullName(),
						e.getMessage(),
						"Blogs: Error publishing to Facebook - " + title,
						user.getCompanyId(), groupId);
			}
		}
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	 *      #postEventToSocialNetworks(long, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, long, long,
	 *      com.liferay.portal.model.User)
	 */
	public void postEventToSocialNetworks(long eventId, String title,
			String altMessage, String url, String imgUrl, long companyId,
			long groupId, User user) {

		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(CalEvent.class);
		SPSocialSharing SPSocialSharing = null;
		SocialProfile socialProfile = null;

		try {
			if (Validator.isNotNull(url)) {
				url = url.substring(0, url.indexOf(StringPool.QUESTION));
				url += StringPool.QUESTION + "eventViewId=" + eventId;
			}

			socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user
					.getUserId());

			try {
				SPSocialSharing = SPSocialSharingLocalServiceUtil
						.findByClassNameIdAndClassPK(classNameId, eventId);
			} catch (NoSuchSPSocialSharingException e) {
				_log.error("SPSocialSharing record not found. ");
			} catch (SystemException e) {
				_log.error(e);
			}

			if (Validator.isNull(SPSocialSharing)) {
				_log.info("Creating SPSocialSharing entry...");
				long shareId;
				try {
					shareId = CounterLocalServiceUtil
							.increment("SPSocialSharing.class");
					SPSocialSharing = SPSocialSharingLocalServiceUtil
							.createSPSocialSharing(shareId);
					SPSocialSharing.setClassNameId(classNameId);
					SPSocialSharing.setClassPK(eventId);
					SPSocialSharing.setCreateDate(new Date());
					SPSocialSharing.setModifiedDate(new Date());
					SPSocialSharingLocalServiceUtil
							.updateSPSocialSharing(SPSocialSharing);
				} catch (SystemException e) {
					_log.error("Error adding social sharing", e);
				}
			}

			String message = SocialSharingUtil.getMessageResourceBundle(
					SocialPluginsConstants.POST_EVENTS, groupId);

			if (Validator.isNull(message)) {
				message = altMessage;
			}

			if (SPSocialSharing.getFacebook() == 0) {

				// share to facebook

				try {
					int fbStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebook(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookShareStatus(classNameId,
										eventId, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing events to Facebook. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Events: Error publishing to Facebook - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to linkedin

			if (SPSocialSharing.getLinkedin() == 0) {
				try {
					int linkedinStatus = SPSocialSharingLocalServiceUtil
							.publishToLinkedIn(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (linkedinStatus == 201) {
						SPSocialSharingLocalServiceUtil
								.updateLinkedInShareStatus(classNameId,
										eventId, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing events to Linkedin. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to LinkedIn

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Events: Error publishing to LinkedIn - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to twitter

			if (SPSocialSharing.getTwitter() == 0) {
				try {
					int twitterStatus = SPSocialSharingLocalServiceUtil
							.publishToTwitter(message, url, imgUrl, groupId,
									companyId, socialProfile);

					if (twitterStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateTwitterShareStatus(classNameId, eventId,
										1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing events to Twitter. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Twitter

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Events: Error publishing to Twitter - " + title,
							user.getCompanyId(), groupId);
				}
			}

			if (SPSocialSharing.getFacebookPage() == 0) {

				// share to facebook page

				try {
					int fbPageStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebookPage(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbPageStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookPageShareStatus(classNameId,
										eventId, 1);
					}
				} catch (SocialNetworkException e) {

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Events: Error publishing to Facebook Page - "
									+ title, user.getCompanyId(), groupId);
				} catch (Exception e) {
					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Events: Error publishing to Facebook Page - "
									+ title, user.getCompanyId(), groupId);
				}
			}

		} catch (PortalException e) {
			_log.error("Error sharing events to social networks. ", e);
		} catch (SystemException e) {
			_log.error("Error sharing events to social networks. ", e);
		} catch (Exception e) {
			_log.error("Error sharing events to social networks. ", e);
		}
	}

	public void postGroupToSocialNetworks(long groupDetailId, String title,
			String altMessage, String url, String imgUrl, long companyId,
			long groupId, User user, long classNameId) {

		SocialProfile socialProfile = null;
		SPSocialSharing SPSocialSharing = null;

		try {
			socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user
					.getUserId());

			try {
				SPSocialSharing = SPSocialSharingLocalServiceUtil
						.findByClassNameIdAndClassPK(classNameId, groupDetailId);
			} catch (NoSuchSPSocialSharingException e) {
				_log.error("SPSocialSharing record not found. ");
			} catch (SystemException e) {
				_log.error(e);
			}

			if (Validator.isNull(SPSocialSharing)) {
				_log.info("Creating SPSocialSharing entry...");
				long shareId;
				try {
					shareId = CounterLocalServiceUtil
							.increment("SPSocialSharing.class");
					SPSocialSharing = SPSocialSharingLocalServiceUtil
							.createSPSocialSharing(shareId);
					SPSocialSharing.setClassNameId(classNameId);
					SPSocialSharing.setClassPK(groupDetailId);
					SPSocialSharing.setCreateDate(new Date());
					SPSocialSharing.setModifiedDate(new Date());
					SPSocialSharingLocalServiceUtil
							.updateSPSocialSharing(SPSocialSharing);
				} catch (SystemException e) {
					_log.error("Error adding social sharing", e);
				}
			}

			String message = SocialSharingUtil.getMessageResourceBundle(
					SocialPluginsConstants.POST_GROUPS, groupId);

			if (Validator.isNull(message)) {
				message = altMessage;
			}

			if (SPSocialSharing.getFacebook() == 0) {

				// share to facebook

				try {
					int fbStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebook(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookShareStatus(classNameId,
										groupDetailId, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing group to Facebook. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Facebook - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to linkedin

			if (SPSocialSharing.getLinkedin() == 0) {
				try {
					int linkedinStatus = SPSocialSharingLocalServiceUtil
							.publishToLinkedIn(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (linkedinStatus == 201) {
						SPSocialSharingLocalServiceUtil
								.updateLinkedInShareStatus(classNameId,
										groupDetailId, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing group to Linkedin. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to LinkedIn

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to LinkedIn - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to twitter

			if (SPSocialSharing.getTwitter() == 0) {
				try {
					int twitterStatus = SPSocialSharingLocalServiceUtil
							.publishToTwitter(message, url, imgUrl, groupId,
									companyId, socialProfile);

					if (twitterStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateTwitterShareStatus(classNameId,
										groupDetailId, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing group to Twitter. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Twitter

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Twitter - " + title,
							user.getCompanyId(), groupId);
				}
			}

			if (SPSocialSharing.getFacebookPage() == 0) {

				// share to facebook page

				try {
					int fbPageStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebookPage(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbPageStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookPageShareStatus(classNameId,
										groupDetailId, 1);
					}
				} catch (SocialNetworkException e) {

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Facebook Page - "
									+ title, user.getCompanyId(), groupId);
				} catch (Exception e) {
					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Facebook Page - "
									+ title, user.getCompanyId(), groupId);
				}
			}

		} catch (PortalException e) {
			_log.error("Error sharing groups to social networks. ", e);
		} catch (SystemException e) {
			_log.error("Error sharing groups to social networks. ", e);
		} catch (Exception e) {
			_log.error("Error sharing groups to social networks. ", e);
		}
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	 *      #postJobsToSocialNetworks(long, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, long, long,
	 *      com.liferay.portal.model.User)
	 */
	public void postJobsToSocialNetworks(long jobId, String title,
			String altMessage, String url, String imgUrl, long companyId,
			long groupId, User user) {
		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(SPJob.class);

		SocialProfile socialProfile = null;
		SPSocialSharing SPSocialSharing = null;

		try {
			socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user
					.getUserId());

			try {
				SPSocialSharing = SPSocialSharingLocalServiceUtil
						.findByClassNameIdAndClassPK(classNameId, jobId);
			} catch (NoSuchSPSocialSharingException e) {
				_log.error("SPSocialSharing record not found.");
			} catch (SystemException e) {
				_log.error(e);
			}

			if (Validator.isNull(SPSocialSharing)) {
				_log.info("Creating SPSocialSharing entry...");
				long shareId;
				try {
					shareId = CounterLocalServiceUtil
							.increment("SPSocialSharing.class");
					SPSocialSharing = SPSocialSharingLocalServiceUtil
							.createSPSocialSharing(shareId);
					SPSocialSharing.setClassNameId(classNameId);
					SPSocialSharing.setClassPK(jobId);
					SPSocialSharing.setCreateDate(new Date());
					SPSocialSharing.setModifiedDate(new Date());
					SPSocialSharingLocalServiceUtil
							.updateSPSocialSharing(SPSocialSharing);
				} catch (SystemException e) {
					_log.error("Error adding social sharing", e);
				}
			}

			String message = SocialSharingUtil.getMessageResourceBundle(
					SocialPluginsConstants.POST_JOBS, groupId);

			if (Validator.isNull(message)) {
				message = altMessage;
			}

			if (SPSocialSharing.getFacebook() == 0) {

				// share to facebook

				try {
					int fbStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebook(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookShareStatus(classNameId, jobId,
										1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing jobs to Facebook. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Jobs: Error publishing to Facebook - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to linkedin

			if (SPSocialSharing.getLinkedin() == 0) {
				try {
					int linkedinStatus = SPSocialSharingLocalServiceUtil
							.publishToLinkedIn(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (linkedinStatus == 201) {
						SPSocialSharingLocalServiceUtil
								.updateLinkedInShareStatus(classNameId, jobId,
										1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing jobs to Linkedin. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to linkedin

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Jobs: Error publishing to Linkedin - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to twitter

			if (SPSocialSharing.getTwitter() == 0) {
				try {
					int twitterStatus = SPSocialSharingLocalServiceUtil
							.publishToTwitter(message, url, imgUrl, groupId,
									companyId, socialProfile);

					if (twitterStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateTwitterShareStatus(classNameId, jobId, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing jobs to Twitter. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Twitter

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Jobs: Error publishing to Twitter - " + title,
							user.getCompanyId(), groupId);
				}
			}

			if (SPSocialSharing.getFacebookPage() == 0) {

				// share to facebook page

				try {
					int fbPageStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebookPage(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbPageStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookPageShareStatus(classNameId,
										jobId, 1);
					}
				} catch (SocialNetworkException e) {

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil
							.sendNotificationAdmin(user.getEmailAddress(),
									user.getFullName(), e.getMessage(),
									"Job: Error publishing to Facebook Page - "
											+ title, user.getCompanyId(),
									groupId);
				} catch (Exception e) {
					SPSocialSharingLocalServiceUtil
							.sendNotificationAdmin(user.getEmailAddress(),
									user.getFullName(), e.getMessage(),
									"Job: Error publishing to Facebook Page - "
											+ title, user.getCompanyId(),
									groupId);
				}
			}
		} catch (PortalException e) {
			_log.error("Error sharing Jobs to social networks. ", e);
		} catch (SystemException e) {
			_log.error("Error sharing Jobs to social networks. ", e);
		}
	}

	/**
	 * This method will auto-share Individual profile link to different social
	 * networks upon signing up using social networks 1. Facebook - The link to
	 * the published profile will be posted to the wall/timeline 2. Twitter -
	 * The link to the published profile will be posted as a new tweet 3.
	 * Linkedin - The link to the published profile will be posted as a status
	 * update
	 *
	 * (non-Javadoc)
	 *
	 * @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	 *      #postProfileToSocialNetwork(com.liferay.portal.model.User,
	 *      sambaash.platform.srv.socialprofile.model.SocialProfile)
	 */
	public void postProfileToSocialNetwork(User user,
			SocialProfile socialProfile) {
		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(SocialProfile.class);
		SPSocialSharing SPSocialSharing = null;
		long userId = user.getUserId();

		long shareId;
		try {
			shareId = CounterLocalServiceUtil
					.increment("SPSocialSharing.class");
			SPSocialSharing = SPSocialSharingLocalServiceUtil
					.createSPSocialSharing(shareId);
			SPSocialSharing.setClassNameId(classNameId);
			SPSocialSharing.setClassPK(userId);
			SPSocialSharing.setCreateDate(new Date());
			SPSocialSharing.setModifiedDate(new Date());

			SPSocialSharingLocalServiceUtil
					.updateSPSocialSharing(SPSocialSharing);

		} catch (SystemException e) {
			_log.error("Error adding social sharing", e);
		}

		String portalUrl = StringPool.BLANK;
		String publicUrl = StringPool.BLANK;

		try {
			portalUrl = SambaashUtil.getPortalURL(user.getCompanyId(),
					user.getGroupId());
			publicUrl = portalUrl + StringPool.SLASH + user.getScreenName();

			long groupId = user.getGroupId();
			long companyId = user.getCompanyId();

			Group group = GroupLocalServiceUtil.getGroup(user.getCompanyId(),
					PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));

			if (Validator.isNotNull(group)) {
				groupId = group.getGroupId();
			}

			String message = SocialSharingUtil.getMessageResourceBundle(
					SocialPluginsConstants.POST_PROFILE, groupId);

			if (SPSocialSharing.getFacebook() == 0) {

				// share to facebook

				try {
					int fbStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebook(message, StringPool.BLANK,
									publicUrl, SambaashUtil.getProfileImageURL(
											portalUrl, user), groupId,
									companyId, socialProfile);

					if (fbStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookShareStatus(classNameId,
										socialProfile.getUserId(), 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing profile to Facebook. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(),
							user.getFullName(),
							e.getMessage(),
							"Profile: Error publishing to Facebook - "
									+ user.getFullName(), user.getCompanyId(),
							groupId);
				}
			}

			if (SPSocialSharing.getLinkedin() == 0) {

				// share to linkedin

				try {
					int linkedinStatus = SPSocialSharingLocalServiceUtil
							.publishToLinkedIn(message, StringPool.BLANK,
									publicUrl, SambaashUtil.getProfileImageURL(
											portalUrl, user), groupId,
									companyId, socialProfile);

					if (linkedinStatus == 201) {
						SPSocialSharingLocalServiceUtil
								.updateLinkedInShareStatus(classNameId,
										socialProfile.getUserId(), 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing profile to Linkedin. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Linkedin

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(),
							user.getFullName(),
							e.getMessage(),
							"Profile: Error publishing to Linkedin - "
									+ user.getFullName(), user.getCompanyId(),
							groupId);
				}
			}

			if (SPSocialSharing.getTwitter() == 0) {

				// share to twitter

				try {
					int twittertatus = SPSocialSharingLocalServiceUtil
							.publishToTwitter(message, publicUrl, SambaashUtil
									.getProfileImageURL(portalUrl, user),
									groupId, companyId, socialProfile);

					if (twittertatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateTwitterShareStatus(classNameId,
										socialProfile.getUserId(), 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing profile to Twitter. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Twitter

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(),
							user.getFullName(),
							e.getMessage(),
							"Profile: Error publishing to Twitter - "
									+ user.getFullName(), user.getCompanyId(),
							groupId);
				}
			}

			if (SPSocialSharing.getFacebookPage() == 0) {

				// share to facebook page

				try {
					int fbPageStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebookPage(message, StringPool.BLANK,
									publicUrl, SambaashUtil.getProfileImageURL(
											portalUrl, user), groupId,
									companyId, socialProfile);

					if (fbPageStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookPageShareStatus(classNameId,
										socialProfile.getUserId(), 1);
					}
				} catch (SocialNetworkException e) {

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(),
							user.getFullName(),
							e.getMessage(),
							"Blogs: Error publishing to Facebook - "
									+ user.getFullName(), user.getCompanyId(),
							groupId);
				} catch (Exception e) {
					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(),
							user.getFullName(),
							e.getMessage(),
							"Blogs: Error publishing to Facebook - "
									+ user.getFullName(), user.getCompanyId(),
							groupId);
				}
			}

		} catch (PortalException e) {
			_log.error("Error sharing profile to social networks. ", e);
		} catch (SystemException e) {
			_log.error("Error sharing profile to social networks. ", e);
		}
	}

	public void postSPAssetToSocialNetwork(SPAssetEntry spAssetEntry,
			String url, String imgUrl) {

		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(SPAssetEntry.class);
		SPSocialSharing SPSocialSharing = null;
		SocialProfile socialProfile = null;

		try {
			socialProfile = SocialProfileLocalServiceUtil
					.getSocialProfile(spAssetEntry.getUserId());
		} catch (NoSuchSocialProfileException e) {
			if (_log.isDebugEnabled()) {
				_log.error("Error getting social profile. ");
			}
		} catch (Exception e) {
			_log.error("Error adding social sharing", e);
		}

		if (socialProfile != null) {
			String message = SocialSharingUtil.getMessageResourceBundle(
					SocialPluginsConstants.POST_GALLERY,
					spAssetEntry.getGroupId());

			try {
				SPSocialSharing = SPSocialSharingLocalServiceUtil
						.findByClassNameIdAndClassPK(classNameId,
								spAssetEntry.getSpAssetEntryId());
			} catch (NoSuchSPSocialSharingException e) {
				if (_log.isDebugEnabled()) {
					_log.error("Error getting social sharing record. ");
				}
			} catch (Exception e) {
				_log.error("Error getting social sharing record.");
			}

			if (Validator.isNull(SPSocialSharing)) {
				_log.info("Creating SPSocialSharing entry...");
				long shareId;
				try {
					shareId = CounterLocalServiceUtil
							.increment("SPSocialSharing.class");
					SPSocialSharing = SPSocialSharingLocalServiceUtil
							.createSPSocialSharing(shareId);
					SPSocialSharing.setClassNameId(classNameId);
					SPSocialSharing
							.setClassPK(spAssetEntry.getSpAssetEntryId());
					SPSocialSharing.setCreateDate(new Date());
					SPSocialSharing.setModifiedDate(new Date());
					SPSocialSharingLocalServiceUtil
							.updateSPSocialSharing(SPSocialSharing);
				} catch (SystemException e) {
					_log.error("Error adding social sharing");
				}
			}

			message = StringUtil.replace(message, "{galleryName}",
					spAssetEntry.getTitle());

			if (SPSocialSharing.getFacebook() == 0) {

				// publish to Facebook

				try {
					int fbStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebook(spAssetEntry.getTitle(),
									message, url, imgUrl,
									spAssetEntry.getGroupId(),
									spAssetEntry.getCompanyId(), socialProfile);

					if (fbStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookShareStatus(classNameId,
										spAssetEntry.getSpAssetEntryId(), 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing gallery to Facebook.");
					}
				}
			}

			if (SPSocialSharing.getLinkedin() == 0) {

				// share to linkedin

				try {
					int linkedinStatus = SPSocialSharingLocalServiceUtil
							.publishToLinkedIn(spAssetEntry.getTitle(),
									message, url, imgUrl,
									spAssetEntry.getGroupId(),
									spAssetEntry.getCompanyId(), socialProfile);

					if (linkedinStatus == 201) {
						SPSocialSharingLocalServiceUtil
								.updateLinkedInShareStatus(classNameId,
										spAssetEntry.getSpAssetEntryId(), 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing gallery to Linkedin.");
					}
				}
			}

			if (SPSocialSharing.getTwitter() == 0) {

				// share to twitter

				try {
					int twitterStatus = SPSocialSharingLocalServiceUtil
							.publishToTwitter(message, url, imgUrl,
									spAssetEntry.getGroupId(),
									spAssetEntry.getCompanyId(), socialProfile);

					if (twitterStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateTwitterShareStatus(classNameId,
										spAssetEntry.getSpAssetEntryId(), 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing gallery to Twitter.");
					}
				}
			}

			if (SPSocialSharing.getFacebookPage() == 0) {

				// share to facebook page

				try {
					int fbPageStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebookPage(spAssetEntry.getTitle(),
									message, url, imgUrl,
									spAssetEntry.getGroupId(),
									spAssetEntry.getCompanyId(), socialProfile);

					if (fbPageStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookPageShareStatus(classNameId,
										spAssetEntry.getSpAssetEntryId(), 1);
					}
				} catch (SocialNetworkException e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing on facebook page.");
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing on facebook page.");
					}
				}
			}
		}
	}

	public void postSPGroupToSocialNetworks(long classNameId, long classPK,
			String title, String altMessage, String url, String imgUrl,
			long companyId, long groupId, User user, boolean enableFB,
			boolean enableIn, boolean enableGoogle, boolean enableTW) {

		SocialProfile socialProfile = null;
		SPSocialSharing SPSocialSharing = null;

		try {
			socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user
					.getUserId());

			try {
				SPSocialSharing = SPSocialSharingLocalServiceUtil
						.findByClassNameIdAndClassPK(classNameId, classPK);
			} catch (NoSuchSPSocialSharingException e) {
				_log.error("SPSocialSharing record not found. ");
			} catch (SystemException e) {
				_log.error(e);
			}

			if (Validator.isNull(SPSocialSharing)) {
				_log.info("Creating SPSocialSharing entry...");
				long shareId;
				try {
					shareId = CounterLocalServiceUtil
							.increment("SPSocialSharing.class");
					SPSocialSharing = SPSocialSharingLocalServiceUtil
							.createSPSocialSharing(shareId);
					SPSocialSharing.setClassNameId(classNameId);
					SPSocialSharing.setClassPK(classPK);
					SPSocialSharing.setCreateDate(new Date());
					SPSocialSharing.setModifiedDate(new Date());
					SPSocialSharingLocalServiceUtil
							.updateSPSocialSharing(SPSocialSharing);
				} catch (SystemException e) {
					_log.error("Error adding social sharing", e);
				}
			}

			String message = SocialSharingUtil.getMessageResourceBundle(
					SocialPluginsConstants.POST_GROUPS, groupId);

			if (Validator.isNull(message)) {
				message = altMessage;
			}

			if (SPSocialSharing.getFacebook() == 0 && enableFB) {

				// share to facebook

				try {
					int fbStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebook(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookShareStatus(classNameId,
										classPK, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing group to Facebook. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Facebook - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to linkedin

			if (SPSocialSharing.getLinkedin() == 0 && enableIn) {
				try {
					int linkedinStatus = SPSocialSharingLocalServiceUtil
							.publishToLinkedIn(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (linkedinStatus == 201) {
						SPSocialSharingLocalServiceUtil
								.updateLinkedInShareStatus(classNameId,
										classPK, 1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing group to Linkedin. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to LinkedIn

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to LinkedIn - " + title,
							user.getCompanyId(), groupId);
				}
			}

			// share to twitter

			if (SPSocialSharing.getTwitter() == 0 && enableTW) {
				try {
					int twitterStatus = SPSocialSharingLocalServiceUtil
							.publishToTwitter(message, url, imgUrl, groupId,
									companyId, socialProfile);

					if (twitterStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateTwitterShareStatus(classNameId, classPK,
										1);
					}
				} catch (Exception e) {
					if (_log.isDebugEnabled()) {
						_log.error("Error sharing group to Twitter. ", e);
					}

					// Send email notification to admin when error encountered
					// while publishing to Twitter

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Twitter - " + title,
							user.getCompanyId(), groupId);
				}
			}

			if (SPSocialSharing.getFacebookPage() == 0 && enableFB) {

				// share to facebook page

				try {
					int fbPageStatus = SPSocialSharingLocalServiceUtil
							.publishToFacebookPage(title, message, url, imgUrl,
									groupId, companyId, socialProfile);

					if (fbPageStatus == 200) {
						SPSocialSharingLocalServiceUtil
								.updateFacebookPageShareStatus(classNameId,
										classPK, 1);
					}
				} catch (SocialNetworkException e) {

					// Send email notification to admin when error encountered
					// while publishing to Facebook

					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Facebook Page - "
									+ title, user.getCompanyId(), groupId);
				} catch (Exception e) {
					SPSocialSharingLocalServiceUtil.sendNotificationAdmin(
							user.getEmailAddress(), user.getFullName(),
							e.getMessage(),
							"Group: Error publishing to Facebook Page - "
									+ title, user.getCompanyId(), groupId);
				}
			}

		} catch (PortalException e) {
			_log.error("Error sharing groups to social networks. ", e);
		} catch (SystemException e) {
			_log.error("Error sharing groups to social networks. ", e);
		} catch (Exception e) {
			_log.error("Error sharing groups to social networks. ", e);
		}
	}

	public int publishToFacebook(String title, String message, String link,
			String pictureUrl, long groupId, long companyId,
			SocialProfile socialProfile) throws Exception {

		String autoShareEnabled = SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK_SHARING, groupId);

		if (Validator.isNull(autoShareEnabled) || autoShareEnabled.equals("0")) {
			return 0;
		}

		String apiKey = PrefsPropsUtil.getString(companyId,
				PropsKeys.FACEBOOK_CONNECT_APP_ID);
		String apiSecret = PrefsPropsUtil.getString(companyId,
				PropsKeys.FACEBOOK_CONNECT_APP_SECRET);
		String callbackUrl = PrefsPropsUtil.getString(companyId,
				PropsKeys.FACEBOOK_CONNECT_OAUTH_REDIRECT_URL);
		String permission = SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK.PERMISSION, groupId);
		String serviceUrl = SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK.POST, groupId);

		SocialNetworkService service = SocialNetworkServiceFactory
				.getSocialNetworkService(SocialNetworkService.FACEBOOK_SERVICE);
		service.setApiKey(apiKey);
		service.setApiSecret(apiSecret);
		service.setCallbackUrl(callbackUrl);
		service.setScope(permission);
		service.setAccessToken(socialProfile.getFacebookAuthToken(), apiSecret);
		service.setServiceUrl(serviceUrl);

		Post content = new Post(title, message, link, pictureUrl);

		int status = service.post(content);

		_log.info("publishToFacebook Status: " + status);
		return status;
	}

	public int publishToFacebookPage(String title, String message, String link,
			String pictureUrl, long groupId, long companyId,
			SocialProfile socialProfile) throws Exception {

		String autoShareEnabled = SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK_PAGE_SHARING, groupId);

		if (Validator.isNull(autoShareEnabled) || autoShareEnabled.equals("0")) {
			return 0;
		}

		String apiKey = PrefsPropsUtil.getString(companyId,
				PropsKeys.FACEBOOK_CONNECT_APP_ID);
		String apiSecret = PrefsPropsUtil.getString(companyId,
				PropsKeys.FACEBOOK_CONNECT_APP_SECRET);
		String callbackUrl = PrefsPropsUtil.getString(companyId,
				PropsKeys.FACEBOOK_CONNECT_OAUTH_REDIRECT_URL);
		String permission = SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK.PERMISSION, groupId);
		String serviceUrl = SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK.POST_PAGE, groupId);

		SocialNetworkService service = SocialNetworkServiceFactory
				.getSocialNetworkService(SocialNetworkService.FACEBOOK_SERVICE);
		service.setApiKey(apiKey);
		service.setApiSecret(apiSecret);
		service.setCallbackUrl(callbackUrl);
		service.setScope(permission);
		service.setAccessToken(socialProfile.getFacebookAuthToken(), apiSecret);
		service.setServiceUrl(serviceUrl);

		Post content = new Post(title, message, link, pictureUrl);

		int status = service.post(content);

		_log.info("publishToFacebookPage Status: " + status);
		return status;
	}

	public int publishToLinkedIn(String title, String message, String link,
			String pictureUrl, long groupId, long companyId,
			SocialProfile socialProfile) throws Exception {

		String autoShareEnabled = SambaashUtil.getParameter(
				SocialPluginsConstants.LINKEDIN_SHARING, groupId);

		if (Validator.isNull(autoShareEnabled) || autoShareEnabled.equals("0")) {
			return 0;
		}

		String apiKey = SambaashUtil.getParameter(
				SambaashConstants.LINKEDIN_API_KEY, groupId);
		String apiSecret = SambaashUtil.getParameter(
				SambaashConstants.LINKEDIN_SECRET_KEY, groupId);
		String serviceUrl = SambaashUtil.getParameter(
				SocialPluginsConstants.LINKEDIN.POST, groupId);

		SocialNetworkService service = SocialNetworkServiceFactory
				.getSocialNetworkService(SocialNetworkService.LINKEDIN_SERVICE);
		service.setApiKey(apiKey);
		service.setApiSecret(apiSecret);
		service.setAccessToken(socialProfile.getLinkedinAuthToken(),
				socialProfile.getLinkedinAuthSecret());
		service.setServiceUrl(serviceUrl);

		Post content = new Post(title, message, link, pictureUrl);

		int status = service.post(content);

		_log.info("publishToLinkedIn Status: " + status);
		return status;
	}

	public int publishToTwitter(String message, String link, String pictureUrl,
			long groupId, long companyId, SocialProfile socialProfile)
			throws Exception {

		String autoShareEnabled = SambaashUtil.getParameter(
				SocialPluginsConstants.TWITTER_SHARING, groupId);

		if (Validator.isNull(autoShareEnabled) || autoShareEnabled.equals("0")) {
			return 0;
		}

		String apiKey = SambaashUtil.getParameter(
				SambaashConstants.TWITTER_API_KEY, groupId);
		String apiSecret = SambaashUtil.getParameter(
				SambaashConstants.TWITTER_SECRET_KEY, groupId);
		String serviceUrl = SambaashUtil.getParameter(
				SocialPluginsConstants.TWITTER.POST, groupId);

		SocialNetworkService service = SocialNetworkServiceFactory
				.getSocialNetworkService(SocialNetworkService.TWITTER_SERVICE);
		service.setApiKey(apiKey);
		service.setApiSecret(apiSecret);
		service.setAccessToken(socialProfile.getTwitterAuthToken(),
				socialProfile.getTwitterAuthSecret());
		service.setServiceUrl(serviceUrl);

		Post content = new Post(StringPool.BLANK, message, link, pictureUrl);

		int status = service.post(content);

		_log.info("publishToTwitter Status: " + status);
		return status;
	}

	/**
	 * This method converts the image from url to bytes Saves the portrait image
	 * which was obtained from social networks (non-Javadoc)
	 *
	 * @see sambaash.platform.srv.socialplugins.service.SPSocialSharingLocalService
	 *      #saveProfileImage(java.lang.String, long)
	 */
	public void saveProfileImage(String pictureUrl, long userId)
			throws PortalException, SystemException, UploadException {
		try {
			URL url = new URL(pictureUrl);
			URLConnection urlCon = url.openConnection();
			InputStream is = urlCon.getInputStream();

			byte[] bytes = FileUtil.getBytes(is);

			if ((bytes == null) || (bytes.length == 0)) {
				throw new UploadException();
			}

			UserServiceUtil.updatePortrait(userId, bytes);

			SocialProfile userProfile = SocialProfileLocalServiceUtil
					.getSocialProfile(userId);
			Indexer indexer = IndexerRegistryUtil
					.getIndexer(SocialProfile.class.getName());
			indexer.reindex(userProfile);
		} catch (IOException e) {
			_log.error("Error while saving profile image", e);
		}
	}

	/**
	 * Sends email notification to the admin when an error occurs when
	 * publishing to other social sites
	 *
	 * @param fromAddress
	 * @param fromName
	 * @param body
	 * @param subject
	 * @param companyId
	 */
	public void sendNotificationAdmin(String fromAddress, String fromName,
			String body, String subject, long companyId, long groupId) {
		_log.debug("sendNotificationAdmin..." + body);
		try {
			String toName = PrefsPropsUtil.getString(companyId,
					PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String notifyEnabled = SambaashUtil.getParameter(
					SocialPluginsConstants.EMAIL_NOTIFICATION_ENABLED, groupId);

			if (Validator.isNotNull(notifyEnabled)
					&& "true".equals(notifyEnabled)) {
				String emailAddress = SambaashUtil
						.getParameter(
								SocialPluginsConstants.EMAIL_NOTIFICATION_EMAIL_ADDRESS,
								groupId);
				InternetAddress from = new InternetAddress(fromAddress,
						fromName);
				MailMessage message = new MailMessage();

				if (Validator.isNotNull(emailAddress)) {
					String[] recipients = emailAddress.split(",");
					InternetAddress[] addressTo = new InternetAddress[recipients.length];

					for (int i = 0; i < recipients.length; i++) {
						addressTo[i] = new InternetAddress(recipients[i]);
					}

					message.setTo(addressTo);
				} else {
					InternetAddress to = new InternetAddress(emailAddress,
							toName);
					message.setTo(to);
				}

				message.setFrom(from);
				message.setSubject(subject);
				message.setBody(body);
				message.setHTMLFormat(true);
				MailServiceUtil.sendEmail(message);
			} else {
				_log.info("Email notification not enabled: " + subject);
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	public SPSocialSharing updateFacebookPageShareStatus(long classNameId,
			long classPK, int status) throws NoSuchSPSocialSharingException,
			SystemException {
		SPSocialSharing ss = SPSocialSharingLocalServiceUtil
				.findByClassNameIdAndClassPK(classNameId, classPK);
		ss.setFacebookPage(status);
		updateSPSocialSharing(ss);
		return ss;
	}

	public SPSocialSharing updateFacebookShareStatus(long classNameId,
			long classPK, int status) throws NoSuchSPSocialSharingException,
			SystemException {
		SPSocialSharing ss = SPSocialSharingLocalServiceUtil
				.findByClassNameIdAndClassPK(classNameId, classPK);
		ss.setFacebook(status);
		updateSPSocialSharing(ss);
		return ss;
	}

	public SPSocialSharing updateLinkedInShareStatus(long classNameId,
			long classPK, int status) throws NoSuchSPSocialSharingException,
			SystemException {
		SPSocialSharing ss = SPSocialSharingLocalServiceUtil
				.findByClassNameIdAndClassPK(classNameId, classPK);
		ss.setLinkedin(status);
		updateSPSocialSharing(ss);
		return ss;
	}

	public SPSocialSharing updateTwitterShareStatus(long classNameId,
			long classPK, int status) throws NoSuchSPSocialSharingException,
			SystemException {
		SPSocialSharing ss = SPSocialSharingLocalServiceUtil
				.findByClassNameIdAndClassPK(classNameId, classPK);
		ss.setTwitter(status);
		updateSPSocialSharing(ss);
		return ss;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SPSocialSharingLocalServiceUtil}
	 * to access the s p social sharing local service.
	 */

	private static Log _log = LogFactoryUtil
			.getLog(SPSocialSharingLocalServiceImpl.class);

}