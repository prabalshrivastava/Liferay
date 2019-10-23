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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author gauravvijayvergia
 */
public class SPParameterFinderUtil {
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPParameter> findByNamePrefix(
		java.lang.String prefix, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNamePrefix(prefix, start, end);
	}

	public static SPParameterFinder getFinder() {
		if (_finder == null) {
			_finder = (SPParameterFinder)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					SPParameterFinder.class.getName());

			ReferenceRegistry.registerReference(SPParameterFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SPParameterFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SPParameterFinderUtil.class,
			"_finder");
	}

	private static SPParameterFinder _finder;
}