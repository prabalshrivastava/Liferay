package com.sambaash.platform.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.CronTrigger;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

/**
 * Class to use the default Liferay schedulers. Use SPSchedulerEngine to
 * schedule jobs for custom scheduling and logging of events.
 * @see SPSchedulerUtil
 */
public class SchedulerUtil {

	private static Log _log = LogFactoryUtil.getLog(SchedulerUtil.class);

	/**
	 * @param String
	 *            portletId
	 * @param String
	 *            schedulerListenerClassName
	 * @param String
	 *            campaignId
	 * @param Calendar
	 *            calendar
	 * @param int (SPMailType) mailType
	 */
	private static final String portletId = "SPMailCampaignCreate_WAR_SPMailportlet";
	public static void schedule(String portletId, String schedulerListenerClassName, Calendar calendar, String jobId) {

		SchedulerEntry entry = new SchedulerEntryImpl();

		StringBundler sb = new StringBundler(13);
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

		entry.setEventListenerClass(schedulerListenerClassName);
		entry.setTriggerValue(sb.toString());
		entry.setTriggerType(TriggerType.CRON);
		entry.setDescription(jobId);

		try {
			unschedule(schedulerListenerClassName, jobId);
			SchedulerEngineHelperUtil.schedule(entry, StorageType.MEMORY, portletId, 5);
		} catch (SchedulerException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}
	
	
	public static void schedule(String portletId, String schedulerListenerClassName, Calendar calendar, String jobId,Map<String,String>map) {
	 	 
	 	SchedulerEntry entry = new SchedulerEntryImpl();
	 	 
	 	StringBundler sb = new StringBundler(13);
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
	 	 
	 	entry.setEventListenerClass(schedulerListenerClassName);
	 	entry.setTriggerValue(sb.toString());
	 	entry.setTriggerType(TriggerType.CRON);
	 	entry.setDescription(jobId);
	 	 
	 	try {
	 	unschedule(schedulerListenerClassName, jobId);
	 	//SchedulerEngineHelperUtil.schedule(entry, StorageType.MEMORY, portletId, 5);
	 	 
	 	Message message = new Message();
	 	message.put("map",map);
	 	//SchedulerEngineHelperUtil.schedule(entry, stType, portletId, 5);
	 	SchedulerEngineHelperUtil.schedule(entry.getTrigger(), StorageType.MEMORY, "", DestinationNames.SCHEDULER_DISPATCH, message, 5);
	 	 
	 	} catch (SchedulerException e) {
	 	_log.error(e);
	 	} catch (SystemException e) {
	 	_log.error(e);
	 	}
	 	 
	 }

	public static void schedule(String portletId, String schedulerListenerClassName, String cronExpression, String jobId) {

		SchedulerEntry entry = new SchedulerEntryImpl();

		entry.setEventListenerClass(schedulerListenerClassName);
		entry.setTriggerValue(cronExpression);
		entry.setTriggerType(TriggerType.CRON);
		entry.setDescription(jobId);

		try {
			unschedule(schedulerListenerClassName, jobId);
			SchedulerEngineHelperUtil.schedule(entry, StorageType.MEMORY, portletId, 5);
		} catch (SchedulerException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}
	public static void schedule(String portletId, String schedulerListenerClassName, String cronExpression, String jobId,StorageType stType) {
		
		SchedulerEntry entry = new SchedulerEntryImpl();
		
		entry.setEventListenerClass(schedulerListenerClassName);
		entry.setTriggerValue(cronExpression);
		entry.setTriggerType(TriggerType.CRON);
		entry.setDescription(jobId);
		
		try {
			unschedule(schedulerListenerClassName, jobId);
			SchedulerEngineHelperUtil.schedule(entry, stType, portletId, 5);
		} catch (SchedulerException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}
	
	public static void schedule(String portletId, String schedulerListenerClassName, String cronExpression, String jobId,StorageType stType, Date startDate,Map<String,String>map) {
		SchedulerEntry entry = new SchedulerEntryImpl();
		
		entry.setEventListenerClass(schedulerListenerClassName);
		entry.setTriggerValue(cronExpression);
		entry.setTriggerType(TriggerType.CRON);
		entry.setDescription(jobId);
		
		if(startDate != null){
			try {
				  CronTrigger trigger = (CronTrigger)entry.getTrigger();
				  trigger.setStartDate(startDate);
			} catch (Exception e) {
				_log.error(e);
			}
			
		}
		try {
			unschedule(schedulerListenerClassName, jobId);
			//SchedulerEngineHelperUtil.schedule(entry, stType, portletId, 5);
			Message message = new Message();
		 	message.put("map",map);
		 	_log.error("schedule " + entry.getTrigger() + " cronExpression " + cronExpression);
			SchedulerEngineHelperUtil.schedule(entry.getTrigger(), StorageType.MEMORY, "", DestinationNames.SCHEDULER_DISPATCH, message, 5);
			_log.error("SchedulerEngineHelperUtil  end");
		} catch (SchedulerException | SystemException e) {
			_log.error(e);
		} 
	}

	public static void schedule(ClassLoader cl, String schedulerListenerClassName, String cronExpression, String jobId,StorageType stType, Date startDate) {
		SchedulerEntry entry = new SchedulerEntryImpl();
		
		entry.setEventListenerClass(schedulerListenerClassName);
		entry.setTriggerValue(cronExpression);
		entry.setTriggerType(TriggerType.CRON);
		entry.setDescription(jobId);
		
		if(startDate != null){
			try {
				  CronTrigger trigger = (CronTrigger)entry.getTrigger();
				  trigger.setStartDate(startDate);
			} catch (Exception e) {
				_log.error(e);
			}
			
		}
		try {
			unschedule(schedulerListenerClassName, jobId);
			SchedulerEngineHelperUtil.schedule(entry, stType, portletId, 5);
		} catch (SchedulerException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public static void unschedule(String schedulerListenerClassName, String jobId) throws SchedulerException,
			SystemException {
		_log.error("schedulerListenerClassName : " + schedulerListenerClassName);
		
		List<SchedulerResponse> schedulerResponses = SchedulerEngineHelperUtil.getScheduledJobs(schedulerListenerClassName,
				StorageType.MEMORY);
		for (SchedulerResponse sr : schedulerResponses) {
			if (sr.getTrigger() != null) {
				_log.error("sr.getTrigger().getJobName() : " + sr.getTrigger().getJobName() + " : jobId :" + jobId);
				if (sr.getTrigger().getJobName().equalsIgnoreCase(jobId)) {
					try {
						SchedulerEngineHelperUtil.unschedule(sr.getTrigger().getJobName(), sr.getTrigger().getGroupName(),
								StorageType.MEMORY);
					} catch (Exception e) {
						_log.error("Unable to unschedule :" + jobId);
					}
					try {
						SchedulerEngineHelperUtil.delete(sr.getTrigger().getJobName(), sr.getTrigger().getGroupName(),
								StorageType.MEMORY);
					} catch (Exception e) {
						_log.error("Unable to delete :" + jobId);
					}
				}
			}
		}
	}

}
