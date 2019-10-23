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

package com.sambaash.platform.srv.spasset.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author harini
 */
public class SPAssetEntryFinderUtil {
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> findSPAssetFileEntriesForGuest(
		long groupId, long spAssetTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findSPAssetFileEntriesForGuest(groupId, spAssetTypeId,
			start, end);
	}

	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> findSPAssetFileEntries(
		long groupId, long spAssetTypeId, long signedinUserId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findSPAssetFileEntries(groupId, spAssetTypeId,
			signedinUserId, start, end);
	}

	public static SPAssetEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (SPAssetEntryFinder)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spasset.service.ClpSerializer.getServletContextName(),
					SPAssetEntryFinder.class.getName());

			ReferenceRegistry.registerReference(SPAssetEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SPAssetEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SPAssetEntryFinderUtil.class,
			"_finder");
	}

	private static SPAssetEntryFinder _finder;
}