package com.sambaash.platform.spscheduler.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.scheduler.SPJobDatabaseLogger;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.spscheduler.SPJobInstanceData;
import com.sambaash.platform.spscheduler.SPSchedulerEngine;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

/**
 * Base class to schedule/delete/pause and resume jobs. SPSchedulerEngine as of
 * now handles persistent jobs, in case a request of MEMORY storage type is used
 * request is redirected to Liferay scheduler.
 * 
 * TODO scheduler injection needs to be done thru spring based on the
 * implementation needed. Quartz is used for now.
 * 
 * @see SPScheduledJob
 */
public class SPSchedulerUtil {

	private static Log _log = LogFactoryUtil.getLog(SPSchedulerUtil.class);

	private static SPSchedulerEngine schedulerEngine = SPQuartzSchedulerEngine.getInstance();

	public static void init() {
		try {
			_log.info("Starting Sambaash Scheduler Engine..");
			schedulerEngine.start();
			_log.info("Successfully started the Quartz engine");
		} catch (Exception e) {
			_log.error("Error while starting Sambaash Scheduler", e);
		}
	}

	public static long schedule(String portletId, String jobClassName, String description, Calendar calendar,
			String jobName, Map<String, Object> jobData) {

		StringBuilder sb = new StringBuilder(13);
		sb.append(String.valueOf(calendar.get(Calendar.SECOND)));
		sb.append(StringPool.SPACE);
		sb.append(String.valueOf(calendar.get(Calendar.MINUTE)));
		sb.append(StringPool.SPACE);
		sb.append(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
		sb.append(StringPool.SPACE);
		sb.append(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
		sb.append(StringPool.SPACE);
		sb.append(String.valueOf(calendar.get(Calendar.MONTH) + 1));
		sb.append(StringPool.SPACE);
		sb.append(StringPool.QUESTION);
		sb.append(StringPool.SPACE);
		sb.append(String.valueOf(calendar.get(Calendar.YEAR)));

		return schedule(portletId, jobClassName, description, sb.toString(), jobName, jobData);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static long schedule(String portletId, String jobClassName, String description, String cronExpression,
			String jobName, Map<String, Object> jobData) {

		Class jobClass = SPQuartzClassLoaderHelper.loadJobClass(jobClassName, portletId);
		_log.info("Trying to schedule task : " + jobName + portletId + jobClassName + cronExpression);
		SPJobEntry entry = null;
		try {

			entry = SPJobDatabaseLogger.createNewJob(portletId, jobClassName, cronExpression, jobName);
			jobName = getQuartzJobName(entry);

			jobData.put(SPSchedulerConstants.DATA_JOB_CRON_EXP, cronExpression);
			jobData.put(SPSchedulerConstants.DATA_PORTLET_ID, portletId);
			jobData.put(SPSchedulerConstants.DATA_SP_JOB_ID, entry.getSpJobEntryId());
			JobDataMap map = new JobDataMap(jobData);
			JobBuilder builder = JobBuilder.newJob(jobClass);
			builder.withDescription(description).withIdentity(jobName, SPSchedulerConstants.DEFAULT_GROUP_NAME)
					.usingJobData(map);

			JobDetail jobDetail = builder.build();

			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			triggerBuilder.forJob(jobDetail).withIdentity(jobName, SPSchedulerConstants.DEFAULT_GROUP_NAME)
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionFireAndProceed());

			if (jobData.containsKey(SPSchedulerConstants.START_DATE)) {
				Date startDate = (Date) jobData.get(SPSchedulerConstants.START_DATE);
				_log.info("Start Date for job : " + startDate.toString());
				triggerBuilder.startAt(startDate);
			} else {
				_log.info("Start Date not set.");
			}

			Trigger trigger = triggerBuilder.build();

			schedulerEngine.schedule(jobDetail, trigger);
			_log.info("schedule success!");
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(entry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE, e.getMessage());
			_log.error(e);
			return 0;
		}
		return entry.getSpJobEntryId();
	}

	// TODO not used for now...just need UI changes to plug this.
	public static boolean reSchedule(Long spSchedulerLogId, String cronExpression) {
		SPJobEntry jobEntry = null;
		try {
			_log.debug("Trying to reschedule task : " + spSchedulerLogId + cronExpression);
			jobEntry = SPJobEntryLocalServiceUtil.fetchSPJobEntry(spSchedulerLogId);
			SPJobInstanceData scheduledJob = schedulerEngine.getScheduledJob(getQuartzJobName(jobEntry),
					SPSchedulerConstants.DEFAULT_GROUP_NAME);
			// schedule new
			schedule(scheduledJob.getPortletId(), scheduledJob.getJobClassName(), scheduledJob.getDescription(),
					cronExpression, jobEntry.getJobName(), scheduledJob.getExtras());

			// delete old
			delete(jobEntry.getSpJobEntryId());

		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error rescheduling :: " + e.toString());
			_log.error("Error while rescheduling job with jobId = " + spSchedulerLogId, e);
			return false;
		}
		return false;
	}

	public static boolean delete(Long spSchedulerLogId) {
		SPJobEntry jobEntry = null;
		try {
			jobEntry = SPJobEntryLocalServiceUtil.fetchSPJobEntry(spSchedulerLogId);
			return delete(jobEntry);
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error deleting :: " + e.toString());
			_log.error("Error while deleting job with jobId = " + spSchedulerLogId, e);
			return false;
		}
	}

	public static boolean delete(SPJobEntry jobEntry) {
		try {
			schedulerEngine.delete(getQuartzJobName(jobEntry), SPSchedulerConstants.DEFAULT_GROUP_NAME);
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.INACTIVE, "Delete");
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error deleting :: " + e.toString());
			_log.error("Error while deleting job with jobId = " + jobEntry.getSpJobEntryId(), e);
			return false;
		}
		return true;
	}

	public static boolean pause(Long spSchedulerLogId) {
		SPJobEntry jobEntry = null;
		try {
			jobEntry = SPJobEntryLocalServiceUtil.fetchSPJobEntry(spSchedulerLogId);
			schedulerEngine.pause(getQuartzJobName(jobEntry), SPSchedulerConstants.DEFAULT_GROUP_NAME);
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.PAUSED, SPScheduleJobStatus.PAUSED.toString());
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error pausing :: " + e.toString());
			_log.error("Error while pausing job with jobId = " + spSchedulerLogId, e);
			return false;
		}
		return true;
	}

	public static boolean resume(Long spSchedulerLogId) {
		SPJobEntry jobEntry = null;
		try {
			jobEntry = SPJobEntryLocalServiceUtil.fetchSPJobEntry(spSchedulerLogId);
			schedulerEngine.resume(getQuartzJobName(jobEntry), SPSchedulerConstants.DEFAULT_GROUP_NAME);
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.ACTIVE, SPScheduleJobStatus.ACTIVE.toString());
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error resuming :: " + e.toString());
			_log.error("Error while resuming job with jobId = " + spSchedulerLogId, e);
			return false;
		}
		return true;
	}

	public static boolean unSchedule(Long spSchedulerLogId) {
		SPJobEntry jobEntry = null;
		try {
			jobEntry = SPJobEntryLocalServiceUtil.fetchSPJobEntry(spSchedulerLogId);
			return unSchedule(jobEntry);
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error unscheduling :: " + e.toString());
			_log.error("Error while unscheduling job with jobId = " + spSchedulerLogId, e);
			return false;
		}
	}

	public static boolean unSchedule(SPJobEntry jobEntry) {
		try {
			schedulerEngine.unschedule(getQuartzJobName(jobEntry), SPSchedulerConstants.DEFAULT_GROUP_NAME);
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.INACTIVE, SPScheduleJobStatus.INACTIVE.toString());
		} catch (Exception e) {
			SPJobDatabaseLogger.updateJobStatus(jobEntry.getSpJobEntryId(), SPScheduleJobStatus.FAILURE,
					"Error unscheduling :: " + e.toString());
			_log.error("Error while unscheduling job with jobId = " + jobEntry.getSpJobEntryId(), e);
			return false;
		}
		return true;
	}

	public static List<SPJobInstanceData> getScheduledJobs() {
		try {
			return schedulerEngine.getScheduledJobs();
		} catch (Exception e) {
			_log.error("Error while getting list of jobs", e);
			return null;
		}
	}

	private static String getQuartzJobName(SPJobEntry jobEntry) {
		return jobEntry.getJobName() + "-" + jobEntry.getSpJobEntryId();
	}

	public static void shutdown() {
		try {
			_log.debug("Attempting to shutdown Sambaash Quartz Engine");
			schedulerEngine.shutdown();
			_log.debug("Shutdown successful");
		} catch (SchedulerException e) {
			_log.error(e);
			_log.fatal("Error shutting down Sambaash scheduler, it is recommended to restart the server");
		}
	}

}
