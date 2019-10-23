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

package com.sambaash.platform.srv.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sambaash.platform.srv.model.LogActivity;
import com.sambaash.platform.srv.service.base.LogActivityLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.LogActivityUtil;

/**
 * The implementation of the log activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.LogActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author aishwarya
 * @see com.sambaash.platform.srv.service.base.LogActivityLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.LogActivityLocalServiceUtil
 */
public class LogActivityLocalServiceImpl extends LogActivityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.LogActivityLocalServiceUtil} to access the log activity local service.
	 */
	
	public LogActivity fetchByentityClassIdEntityIdParentLogActivityId(long entityClassId, long entityId, long parentLogActivityId) throws SystemException {
		LogActivity logActivity = null;
		logActivity = LogActivityUtil.fetchByentityClassIdEntityIdParentLogActivityId(entityClassId, entityId, parentLogActivityId);
		return logActivity;
	}
	
	public LogActivity updateLogActivity(LogActivity spLogActivity) throws SystemException{
		LogActivity logActivity = null;
		try {
			logActivity = logActivityPersistence.update(spLogActivity);
			Indexer indexer = IndexerRegistryUtil.getIndexer(LogActivity.class);
			indexer.reindex(logActivity);
		} catch (SearchException e) {
			_log.error(e);
		}
		return logActivity;
	}
	
	private static Log _log = LogFactoryUtil.getLog(LogActivityLocalServiceImpl.class);
}