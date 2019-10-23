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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.PwdGenerator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.model.SPApiAuditLogs;
import com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileServiceBaseImpl;

/**
 * The implementation of the social profile remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SocialProfileService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.SocialProfileServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SocialProfileServiceUtil
 */
public class SocialProfileServiceImpl extends SocialProfileServiceBaseImpl {
	public User addUser(String apiKey, String firstName, String lastName,
			String emailAdddress) {
		return addUser(apiKey, firstName, lastName, emailAdddress, false);
	}

	public User addUser(String apiKey, String firstName, String lastName,
			String emailAdddress, boolean sendPasswordEmail) {

		if (!apiKey
				.equalsIgnoreCase("cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==")
				&& !apiKey.equalsIgnoreCase("vNqbdas112rew/TWWada3Ad==")) {
			return null;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("apiKey:").append(apiKey).append(":firstName:")
				.append(firstName).append(":lastName:").append(lastName)
				.append(":emailAdddress:").append(emailAdddress);
		addAuditLogs("addUser", sb.toString(), StringPool.BLANK);
		return SocialProfileLocalServiceUtil.addUserPlatform(firstName,
				lastName, emailAdddress, PwdGenerator.getPassword(),
				sendPasswordEmail, new ServiceContext());
	}

	public User addUser(String apiKey, String firstName, String lastName,
			String emailAdddress, String password, boolean sendPasswordEmail) {
		if (!apiKey
				.equalsIgnoreCase("cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==")
				&& !apiKey.equalsIgnoreCase("vNqbdas112rew/TWWada3Ad==")) {
			return null;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("apiKey:").append(apiKey).append(":firstName:")
				.append(firstName).append(":lastName:").append(lastName)
				.append(":emailAdddress:").append(emailAdddress);
		addAuditLogs("addUser", sb.toString(), StringPool.BLANK);
		return SocialProfileLocalServiceUtil.addUserPlatform(firstName,
				lastName, emailAdddress, password, sendPasswordEmail,
				new ServiceContext());
	}

	public boolean addUser(String apiKey, String firstName, String lastName,
			String emailAdddress, String password, String facebookId,
			String gender, String profileImageUrl) {
		if (apiKey
				.equalsIgnoreCase("mXqb6XuR+SVQXix3y1MQUxtIy1W4NbY/MLLZfv4RA==")
				|| apiKey.equalsIgnoreCase("vNqbdas112rew/TWWada3Ad==")) {
			StringBuffer sb = new StringBuffer();
			sb.append("apiKey:").append(apiKey).append(":firstName:")
					.append(firstName).append(":lastName:").append(lastName)
					.append(":emailAdddress:").append(emailAdddress)
					.append(":password:").append(password)
					.append(":facebookId:").append(facebookId)
					.append(":gender:").append(gender)
					.append(":profileImageUrl:").append(profileImageUrl);
			addAuditLogs("addUser", sb.toString(), StringPool.BLANK);
			addUserPlatform(firstName, lastName, emailAdddress, password,
					facebookId, gender, profileImageUrl);
			return true;
		} else {
			return false;
		}
	}

	private void addAuditLogs(String apiName, String parameters, String result) {
		long apiAuditLogsId;
		try {
			apiAuditLogsId = CounterLocalServiceUtil
					.increment("ApiAuditLogs.class");

			SPApiAuditLogs apiAuditLogs = SPApiAuditLogsLocalServiceUtil
					.createSPApiAuditLogs(apiAuditLogsId);
			apiAuditLogs.setApiName(apiName);
			apiAuditLogs.setCompanyId(PortalUtil.getDefaultCompanyId());
			apiAuditLogs.setParameters(parameters);
			apiAuditLogs.setResult(result);
			apiAuditLogs.setCreateDate(DateUtil.newDate());
			SPApiAuditLogsLocalServiceUtil.updateSPApiAuditLogs(apiAuditLogs);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	private void addUserPlatform(String firstName, String lastName,
			String emailAddress, String password, String facebookId,
			String gender, String profileImageUrl) {
		try {
			User userByEmail = null;
			User userByFacebookId = null;
			long companyId = PortalUtil.getDefaultCompanyId();
			try {
				userByEmail = UserLocalServiceUtil.getUserByEmailAddress(
						companyId, emailAddress);
			} catch (NoSuchUserException e) {
			}

			try {
				if (Long.parseLong(facebookId) > 0) {
					userByFacebookId = UserLocalServiceUtil
							.getUserByFacebookId(companyId,
									Long.parseLong(facebookId));
				}
			} catch (NoSuchUserException e) {
			}

			if (userByEmail != null || userByFacebookId != null) {
				if (userByFacebookId == null) {
					userByEmail.setFacebookId(Long.parseLong(facebookId));
					userByEmail.setStatus(0);
					userByEmail.setEmailAddressVerified(true);
					userByEmail.setAgreedToTermsOfUse(true);
					UserLocalServiceUtil.updateUser(userByEmail);
				}

			} else {
				User user = UserServiceUtil.addUser(companyId,
						false, // auto

						// password

						password,
						password,
						true, // auto

						// screen name

						StringPool.BLANK, // screen name
						emailAddress,
						Long.parseLong(facebookId), // facebook

						// id

						StringPool.BLANK, // open id
						LocaleUtil.getDefault(), firstName,
						StringPool.BLANK, // middle

						// name

						lastName,
						0, // prefix id
						0, // suffix id
						gender.equalsIgnoreCase("male") ? true : false, 1, 1,
						1970, // birthdate
						StringPool.BLANK, // job title
						null, // group ids
						null, // organization ids
						null, // role ids
						null, // usegroup ids
						false, // send email
						new ServiceContext());

				user.setStatus(0);
				user.setEmailAddressVerified(true);
				user.setAgreedToTermsOfUse(true);
				user.setPasswordEncrypted(true);
				user.setPassword(password);
				UserLocalServiceUtil.updateUser(user);

				SocialProfile socialProfile = SocialProfileLocalServiceUtil
						.getSocialProfile(user.getUserId());
				socialProfile
						.setUserRegistrationStatus(SambaashConstants.REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);
				SocialProfileLocalServiceUtil
						.updateSocialProfile(socialProfile);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public List<User> getCompanyUsers(long companyId, int start, int end) throws PortalException, SystemException {
		return SocialProfileLocalServiceUtil.getUsersList(companyId, start, end);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public User getUser(long userId) {
		try {
			return UserLocalServiceUtil.getUser(userId);
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}

		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public User getUser(String emailAddress) {
		try {
			return UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}

		return null;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SocialProfileServiceUtil} to
	 * access the social profile remote service.
	 */

	private static Log _log = LogFactoryUtil
			.getLog(SocialProfileServiceImpl.class);

}