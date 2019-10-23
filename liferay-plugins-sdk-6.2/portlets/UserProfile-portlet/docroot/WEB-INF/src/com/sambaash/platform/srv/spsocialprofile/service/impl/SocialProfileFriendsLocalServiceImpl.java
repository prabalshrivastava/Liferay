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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends;
import com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileFriendsLocalServiceBaseImpl;

/**
 * The implementation of the social profile friends local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SocialProfileFriendsLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.SocialProfileFriendsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SocialProfileFriendsLocalServiceUtil
 */
public class SocialProfileFriendsLocalServiceImpl extends
		SocialProfileFriendsLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SocialProfileFriendsLocalServiceUtil}
	 * to access the social profile friends local service.
	 */

	public java.util.List<SocialProfileFriends> findByUserIdAndSocialNetworkType(
			long companyId, long belongsToUserId, int socialNetworkType)
			throws com.liferay.portal.kernel.exception.SystemException {
		return socialProfileFriendsPersistence
				.findByUserIdAndSocialNetworkType(companyId, belongsToUserId,
						socialNetworkType);
	}

	public java.util.List<SocialProfileFriends> findByUserIdAndSocialNetworkType(
			long companyId, long belongsToUserId, int socialNetworkType,
			int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		return socialProfileFriendsPersistence
				.findByUserIdAndSocialNetworkType(companyId, belongsToUserId,
						socialNetworkType, start, end);
	}

	public java.util.List<SocialProfileFriends> findByUserIdAndSocialNetworkType(
			long companyId, long belongsToUserId, int socialNetworkType,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
			throws com.liferay.portal.kernel.exception.SystemException {
		return socialProfileFriendsPersistence
				.findByUserIdAndSocialNetworkType(companyId, belongsToUserId,
						socialNetworkType, start, end, orderByComparator);
	}

	public int countByUserIdAndSocialNetworkType(long companyId,
			long belongsToUserId, int socialNetworkType)
			throws com.liferay.portal.kernel.exception.SystemException {
		return socialProfileFriendsPersistence
				.countByUserIdAndSocialNetworkType(companyId, belongsToUserId,
						socialNetworkType);
	}

}