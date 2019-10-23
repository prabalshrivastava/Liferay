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

package com.sambaash.platform.srv.video.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.video.model.VideoFileEntry;
import com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil;

/**
 * @author gauravvijayvergia
 * @generated
 */
public abstract class VideoFileEntryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public VideoFileEntryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(VideoFileEntryLocalServiceUtil.getService());
		setClass(VideoFileEntry.class);

		setClassLoader(com.sambaash.platform.srv.video.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("spVideoFileEntryId");
	}
}