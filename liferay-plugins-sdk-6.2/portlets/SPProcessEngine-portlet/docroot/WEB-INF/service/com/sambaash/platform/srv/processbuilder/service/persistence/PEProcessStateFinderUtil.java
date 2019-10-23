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

package com.sambaash.platform.srv.processbuilder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author nareshchebolu
 */
public class PEProcessStateFinderUtil {
	public static java.util.List<java.lang.Object> getOfflineFinancereport(
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date startDate1, java.util.Date endDate1,
		java.util.Date startDate2, java.util.Date endDate2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getOfflineFinancereport(startDate, endDate, startDate1,
			endDate1, startDate2, endDate2);
	}

	public static java.util.List<java.lang.Object> getOnlineFinancereport(
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date startDate1, java.util.Date endDate1,
		java.util.Date startDate2, java.util.Date endDate2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getOnlineFinancereport(startDate, endDate, startDate1,
			endDate1, startDate2, endDate2);
	}

	public static java.util.List<java.lang.Object> getOfflineFinancereport(
		java.util.Date arg0, java.util.Date arg1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getOfflineFinancereport(arg0, arg1);
	}

	public static java.util.List<java.lang.Object> getOnlineFinancereport(
		java.util.Date arg0, java.util.Date arg1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getOnlineFinancereport(arg0, arg1);
	}

	public static PEProcessStateFinder getFinder() {
		if (_finder == null) {
			_finder = (PEProcessStateFinder)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.getServletContextName(),
					PEProcessStateFinder.class.getName());

			ReferenceRegistry.registerReference(PEProcessStateFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PEProcessStateFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PEProcessStateFinderUtil.class,
			"_finder");
	}

	private static PEProcessStateFinder _finder;
}