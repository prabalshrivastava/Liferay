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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author gauravvijayvergia
 */
public class SocialProfileFinderUtil {
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByU1_S1_S_E(
		java.lang.String userRegistrationStatus, boolean active, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByU1_S1_S_E(userRegistrationStatus, active, start, end);
	}

	public static java.lang.String findSocialProfileLocation()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findSocialProfileLocation();
	}

	public static SocialProfileFinder getFinder() {
		if (_finder == null) {
			_finder = (SocialProfileFinder)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.getServletContextName(),
					SocialProfileFinder.class.getName());

			ReferenceRegistry.registerReference(SocialProfileFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SocialProfileFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SocialProfileFinderUtil.class,
			"_finder");
	}

	private static SocialProfileFinder _finder;
}