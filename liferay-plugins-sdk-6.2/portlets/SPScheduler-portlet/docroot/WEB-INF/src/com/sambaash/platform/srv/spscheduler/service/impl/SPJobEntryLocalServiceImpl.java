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

package com.sambaash.platform.srv.spscheduler.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.spscheduler.impl.SPSchedulerUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.service.base.SPJobEntryLocalServiceBaseImpl;
import com.sambaash.platform.srv.spscheduler.service.persistence.SPJobEntryUtil;

/**
 * The implementation of the s p job entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spscheduler.service.base.SPJobEntryLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil
 */
public class SPJobEntryLocalServiceImpl extends SPJobEntryLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(SPJobEntryLocalServiceImpl.class);

	public SPJobEntry createNewSPJobEntry() throws SystemException {
		SPJobEntry spJobEntry = null;
		try {
			long spJobEntryId = counterLocalService.increment("SPJobEntry");
			spJobEntry = SPJobEntryLocalServiceUtil.createSPJobEntry(spJobEntryId);
			spJobEntry.setNew(true);
			spJobEntry.setCreateDate(new Date());
			spJobEntry.setModifiedDate(new Date());
		} catch (SystemException ex) {
			throw ex;
		}
		return spJobEntry;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getSavedPortletIds() {
		try {
			DynamicQuery query = dynamicQuery()
					.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("portletId")));
			List list = SPJobEntryLocalServiceUtil.dynamicQuery(query);
			return list;
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public List<SPJobEntry> getSPJobEntryByJobNameAndJobClass(String jobName, String jobClass) {

		List<SPJobEntry> jobEntryList = new ArrayList<SPJobEntry>();
		try {
			jobEntryList = SPJobEntryUtil.findByJobNameAndJobClass(jobName, jobClass);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return jobEntryList;
	}

	public long schedule(String portletId, String jobClassName, String description, Calendar calendar,
			String jobName, Map<String, Object> jobData) {
		return SPSchedulerUtil.schedule(portletId, jobClassName, description, calendar, jobName, jobData);
	}

	public long schedule(String portletId, String jobClassName, String description, String cronExpression,
			String jobName, Map<String, Object> jobData) {
		return SPSchedulerUtil.schedule(portletId, jobClassName, description, cronExpression, jobName, jobData);
	}

	public boolean delete(Long spSchedulerLogId) {
		return SPSchedulerUtil.delete(spSchedulerLogId);
	}

	public boolean pause(Long spSchedulerLogId) {
		return SPSchedulerUtil.pause(spSchedulerLogId);
	}

	public boolean resume(Long spSchedulerLogId) {
		return SPSchedulerUtil.resume(spSchedulerLogId);
	}

	public boolean unSchedule(Long spSchedulerLogId) {
		return SPSchedulerUtil.unSchedule(spSchedulerLogId);
	}

	public boolean delete(String jobName, String jobClass) {
		List<SPJobEntry> jobEntryList = getSPJobEntryByJobNameAndJobClass(jobName, jobClass);
		if (jobEntryList != null && jobEntryList.size() > 0) {
			for (SPJobEntry spJobEntry : jobEntryList) {
				SPSchedulerUtil.delete(spJobEntry);
			}
		}
		return true;
	}
	
	public boolean unSchedule(String jobName, String jobClass) {
		List<SPJobEntry> jobEntryList = getSPJobEntryByJobNameAndJobClass(jobName, jobClass);
		if (jobEntryList != null && jobEntryList.size() > 0) {
			for (SPJobEntry spJobEntry : jobEntryList) {
				SPSchedulerUtil.unSchedule(spJobEntry);
			}
		}
		return true;
	}

	// public List<SPJobInstanceData> getScheduledJobs() {
	// return SPSchedulerUtil.getScheduledJobs();
	// }
	
	public java.util.List<SPJobEntry> findByJobNameAndJobClass(String jobName, String jobClass) throws com.liferay.portal.kernel.exception.SystemException {
		return spJobEntryPersistence.findByJobNameAndJobClass(jobName, jobClass);
	}
}
