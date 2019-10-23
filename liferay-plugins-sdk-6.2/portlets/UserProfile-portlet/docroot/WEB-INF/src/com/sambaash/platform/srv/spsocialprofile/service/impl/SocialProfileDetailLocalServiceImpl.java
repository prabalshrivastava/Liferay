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

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail;
import com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileDetailLocalServiceBaseImpl;

/**
 * The implementation of the social profile detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SocialProfileDetailLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.SocialProfileDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SocialProfileDetailLocalServiceUtil
 */
public class SocialProfileDetailLocalServiceImpl extends
		SocialProfileDetailLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.SocialProfileDetailLocalServiceUtil}
	 * to access the social profile detail local service.
	 */

	public List<SocialProfileDetail> findByUserId(long userId)
			throws SystemException {
		return socialProfileDetailPersistence.findByUserId(userId);
	}

	public SocialProfileDetail findByUserIdAndCompanyName(String companyName,
			long userId) throws SystemException,
			NoSuchSocialProfileDetailException {
		return socialProfileDetailPersistence.findByUserIdAndCompanyName(
				companyName, userId);
	}

	public SocialProfileDetail findByUserIdAndUserJobId(String userJobId,
			long userId) throws SystemException,
			NoSuchSocialProfileDetailException {
		return socialProfileDetailPersistence.findByUserIdAndUserJobId(
				userJobId, userId);
	}

}