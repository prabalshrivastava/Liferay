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

package com.sambaash.platform.srv.rsvp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author gauravvijayvergia
 */
public class RsvpDetailFinderUtil {
	public static java.util.List<java.lang.Object> findByRsvpId(long rsvpId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByRsvpId(rsvpId, start, end);
	}

	public static java.util.List<java.lang.Object> findByName(long rsvpId,
		java.lang.String firstName, java.lang.String lastName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByName(rsvpId, firstName, lastName, start, end);
	}

	public static java.util.List<java.lang.Object> findByEmailAddress(
		long rsvpId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByEmailAddress(rsvpId, emailAddress, start, end);
	}

	public static RsvpDetailFinder getFinder() {
		if (_finder == null) {
			_finder = (RsvpDetailFinder)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.rsvp.service.ClpSerializer.getServletContextName(),
					RsvpDetailFinder.class.getName());

			ReferenceRegistry.registerReference(RsvpDetailFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(RsvpDetailFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(RsvpDetailFinderUtil.class,
			"_finder");
	}

	private static RsvpDetailFinder _finder;
}