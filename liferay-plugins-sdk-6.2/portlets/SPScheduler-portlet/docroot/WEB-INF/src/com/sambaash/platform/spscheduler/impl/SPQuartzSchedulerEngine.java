package com.sambaash.platform.spscheduler.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.spscheduler.SPJobInstanceData;
import com.sambaash.platform.spscheduler.SPSchedulerEngine;

/**
 * Can handle only StorageType.PERSISTED jobs. Shouldnt be used directly, use
 * SPSchedulerUtil
 * 
 * @see StorageType
 * @see SPSchedulerUtil
 */
class SPQuartzSchedulerEngine implements SPSchedulerEngine {
	public static SPQuartzSchedulerEngine getInstance() {
		return _instance;
	}
	
	private static final Log logger = LogFactoryUtil
			.getLog(SPQuartzSchedulerEngine.class);
	
	private Scheduler scheduler;

	private static final SPQuartzSchedulerEngine _instance = new SPQuartzSchedulerEngine();

	private SPQuartzSchedulerEngine() {
		// initialize Quartz stuff
		try {
			StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Properties properties = PropsUtil.getProperties("sambaash.scheduler.", true);
			schedulerFactory.initialize(properties);
			scheduler = schedulerFactory.getScheduler();
		} catch (Exception e) {
			scheduler = null;
			logger.error("Error creating scheduler", e);
		}

	}


	@Override
	public void delete(String jobName, String groupName)
			throws SchedulerException {

		JobKey key = getJobKey(jobName, groupName);
		logger.info("deleting job " + jobName);
		scheduler.deleteJob(key);
	}

	@Override
	public SPJobInstanceData getScheduledJob(String jobName, String groupName)
			throws SchedulerException {
		try {
			JobKey jobKey = getJobKey(jobName, groupName);

			SPJobInstanceData jobInstance = new SPJobInstanceData();

			JobDetail jobDetail = scheduler.getJobDetail(jobKey);
			jobInstance.setJobClassName(jobDetail.getJobClass().getName());
			jobInstance.setJobName(jobName);
			jobInstance.setGroupName(groupName);
			jobInstance.setStorageType(StorageType.PERSISTED);
			jobInstance.setDescription(jobDetail.getDescription());
			jobInstance.setCronExpression(jobDetail.getJobDataMap().getString(
					SPSchedulerConstants.DATA_JOB_CRON_EXP));
			jobInstance.setSpJobEntryId(GetterUtil.getLong(jobDetail
					.getJobDataMap().getString(
							SPSchedulerConstants.DATA_SP_JOB_ID)));
			jobInstance.setExtras(jobDetail.getJobDataMap().getWrappedMap());
			jobInstance.setTriggerState(null);
			jobInstance.setPortletId(jobDetail.getJobDataMap().getString(
					SPSchedulerConstants.DATA_PORTLET_ID));
			return jobInstance;
		} catch (Exception e) {
			logger.error("Error while getting the scheduled jobs");
			return null;
		}
	}

	@Override
	public List<SPJobInstanceData> getScheduledJobs() throws SchedulerException {

		List<String> jobGroupNames = scheduler.getJobGroupNames();

		List<SPJobInstanceData> jobs = new ArrayList<SPJobInstanceData>();
		for (String groupName : jobGroupNames) {
			Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher
					.jobGroupEquals(groupName));
			for (JobKey jobKey : jobKeys) {
				logger.info("Found scheduled job = " + jobKey);
				SPJobInstanceData scheduledJob = getScheduledJob(
						jobKey.getName(), jobKey.getGroup());
				if (scheduledJob != null) {
					jobs.add(scheduledJob);
				}
			}
		}

		return jobs;
	}

	@Override
	public void pause(String jobName, String groupName)
			throws SchedulerException {

		JobKey jobKey = getJobKey(jobName, groupName);
		logger.info("Pausing job " + jobName);
		scheduler.getJobDetail(jobKey);
		scheduler.pauseJob(jobKey);
	}

	@Override
	public void resume(String jobName, String groupName)
			throws SchedulerException {

		JobKey jobKey = getJobKey(jobName, groupName);
		logger.info("Resuming job " + jobName);
		scheduler.resumeJob(jobKey);
	}

	@Override
	public void schedule(JobDetail jobDetail, Trigger trigger)
			throws SchedulerException {
		synchronized (this) {
			scheduler.deleteJob(trigger.getJobKey());
			scheduler.scheduleJob(jobDetail, trigger);
		}
	}

	@Override
	public void shutdown() throws SchedulerException {
		logger.info("stopping SPQuartzScheduler");
		this.scheduler.shutdown();
		logger.info("SPQuartzScheduler stopped succesfully");
	}

	@Override
	public void start() throws SchedulerException {
		logger.info("starting SPQuartzScheduler");
		this.scheduler.start();
		logger.info("SPQuartzScheduler successfully");
	}

	@Override
	public void unschedule(String jobName, String groupName)
			throws SchedulerException {

		jobName = shortenLength(jobName,
				SPSchedulerConstants.JOB_NAME_MAX_LENGTH);
		groupName = shortenLength(groupName,
				SPSchedulerConstants.GROUP_NAME_MAX_LENGTH);

		TriggerKey triggerKey = new TriggerKey(jobName, groupName);
		logger.info("Unscheduled job " + jobName);
		scheduler.unscheduleJob(triggerKey);
	}

	private JobKey getJobKey(String jobName, String groupName) {

		if (jobName == null)
			throw new IllegalArgumentException("jobName cant be null");
		if (groupName == null) {
			groupName = SPSchedulerConstants.DEFAULT_GROUP_NAME;
			// throw new IllegalArgumentException("groupName cant be null");
		}

		jobName = shortenLength(jobName,
				SPSchedulerConstants.JOB_NAME_MAX_LENGTH);
		groupName = shortenLength(groupName,
				SPSchedulerConstants.GROUP_NAME_MAX_LENGTH);

		return new JobKey(jobName, groupName);
	}

	private String shortenLength(String name, int len) {
		if (name.length() > len) {
			name = name.substring(0, len);
		}
		return name;
	}

}
