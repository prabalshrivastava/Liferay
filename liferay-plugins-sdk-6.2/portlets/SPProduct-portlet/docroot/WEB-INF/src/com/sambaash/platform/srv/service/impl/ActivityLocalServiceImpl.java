/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.model.Activity;
import com.sambaash.platform.srv.service.ActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.base.ActivityLocalServiceBaseImpl;

/**
 * The implementation of the activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ActivityLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ActivityLocalServiceUtil
 */
public class ActivityLocalServiceImpl extends ActivityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ActivityLocalServiceUtil} to access the activity local service.
	 */
	
	public List<Activity> findByGroupIdAndModuleId(
			long groupId, long spModuleId) throws SystemException {
		return activityPersistence.findByGroupIdAndModuleId(groupId, spModuleId);
	}
	
	public List<Activity> findByGroupIdAndScheduleId(
			long groupId, long spScheduleId) throws SystemException {
		return activityPersistence.findByGroupIdAndScheduleId(groupId, spScheduleId);
	}
	
	public void clearCache() {
		activityPersistence.clearCache();
	}

	public Activity create() throws SystemException{
		long spActivityId = CounterLocalServiceUtil.increment("Activity.class");
		Activity activity = ActivityLocalServiceUtil.createActivity(spActivityId);
		return activity;
	}
}