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

package com.sambaash.platform.srv.spchat.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.spchat.jabber.JabberUtil;
import com.sambaash.platform.srv.spchat.model.Entry;
import com.sambaash.platform.srv.spchat.service.base.EntryLocalServiceBaseImpl;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spchat.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sambaash.platform.srv.spchat.service.base.EntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spchat.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {

	@Override
	public Entry addEntry(
			long createDate, long fromUserId, long toUserId, String content)
		throws SystemException {

		List<Entry> entries = entryFinder.findByEmptyContent(
			fromUserId, toUserId, 0, 5);

		for (Entry entry : entries) {
			entryPersistence.remove(entry);
		}

		if (Validator.isNull(content)) {
			content = StringPool.BLANK;
		}
		else {
			int contentMaxLength = 500;

			DB db = DBFactoryUtil.getDB();

			String dbType = db.getType();

			// LPS-33975

			if (dbType.equals(DB.TYPE_SQLSERVER)) {
				contentMaxLength = 442;
			}

			if (content.length() > contentMaxLength) {
				content = content.substring(0, contentMaxLength);
			}
		}

		long entryId = counterLocalService.increment();

		Entry entry = entryPersistence.create(entryId);

		entry.setCreateDate(createDate);
		entry.setFromUserId(fromUserId);
		entry.setToUserId(toUserId);
		entry.setContent(content);

		entryPersistence.update(entry);

		JabberUtil.sendMessage(fromUserId, toUserId, content);

		return entry;
	}

	@Override
	public Entry addEntry(long fromUserId, long toUserId, String content)
		throws SystemException {

		long createDate = System.currentTimeMillis();

		return addEntry(createDate, fromUserId, toUserId, content);
	}

	@Override
	public void deleteEntries(long userId) throws SystemException {
		entryPersistence.removeByFromUserId(userId);
		entryPersistence.removeByToUserId(userId);
	}

	@Override
	public List<Entry> getNewEntries(
			long userId, long createDate, int start, int end)
		throws SystemException {

		return entryFinder.findByNew(userId, createDate, start, end);
	}

	@Override
	public List<Entry> getOldEntries(long createDate, int start, int end)
		throws SystemException {

		return entryFinder.findByOld(createDate, start, end);
	}

}