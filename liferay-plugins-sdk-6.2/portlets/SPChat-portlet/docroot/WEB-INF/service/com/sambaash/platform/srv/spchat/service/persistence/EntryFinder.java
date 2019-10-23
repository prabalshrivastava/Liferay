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

package com.sambaash.platform.srv.spchat.service.persistence;

/**
 * @author Brian Wing Shun Chan
 */
public interface EntryFinder {
	public java.util.List<com.sambaash.platform.srv.spchat.model.Entry> findByEmptyContent(
		long fromUserId, long toUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spchat.model.Entry> findByNew(
		long userId, long createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.sambaash.platform.srv.spchat.model.Entry> findByOld(
		long createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}