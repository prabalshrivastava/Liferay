package com.sambaash.platform.scheduler;

import java.text.DateFormat;
import java.util.Date;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

/**
 * Used to Log all scheduler events to database and generated Ids will be used
 * as part of the jobNames to make them unique for any third party scheduler
 * implementation
 * 
 */
public class SPJobDatabaseLogger {

	private static Log logger = LogFactoryUtil
			.getLog(SPJobDatabaseLogger.class);
	
	private static final String NEW_LINE = "<br/>";

	public static SPJobEntry createNewJob(String portletId,
			String jobClassName, String cronExpression, String jobName) {
		SPJobEntry log = null;
		try {
			log = SPJobEntryLocalServiceUtil.createNewSPJobEntry();
			log.setJobName(jobName);
			log.setJobClass(jobClassName);
			log.setStatus(SPScheduleJobStatus.ACTIVE.intValue());
			StringBuilder str = new StringBuilder(" ::: Log ::: ");
			str.append(NEW_LINE);
			str.append("New Job");
			str.append(NEW_LINE);
			log.setStatusMsg(str.toString());
			log.setPortletId(portletId);
			log.setCronExpression(cronExpression);
			log = SPJobEntryLocalServiceUtil.addSPJobEntry(log);
		} catch (Exception e) {
			logger.error("Error logging scheduler event" + log, e);
		}
		return log;
	}

	public static SPJobEntry updateJobStatus(Long jobId, SPScheduleJobStatus status,
			String statusMsg) {
		try {
			SPJobEntry entry = SPJobEntryLocalServiceUtil
					.fetchSPJobEntry(jobId);
			
			if(entry.getStatus() == 2){
				//do nothing
			}else{
				entry.setStatus(status.intValue());
			}
			StringBuilder str = null;
			if (Validator.isNull(entry.getStatusMsg())) {
				str = new StringBuilder(" ::: Log ::: ");
				str.append(NEW_LINE);
			} else {
				str = new StringBuilder(entry.getStatusMsg());
			}
			Date modified = new Date();
			if (Validator.isNotNull(statusMsg)) {
				str.append(statusMsg);
				str.append(" : ");
				DateFormat format = DateFormat.getDateTimeInstance();
				str.append(format.format(modified));
				str.append(NEW_LINE);
			}
			int len = str.length();
			entry.setStatusMsg(len > 500?str.substring(len - 499):str.toString());
			entry.setModifiedDate(new Date());
			SPJobEntryLocalServiceUtil.updateSPJobEntry(entry);
			return entry;

		} catch (Exception e) {
			logger.error("Error logging scheduler event for jobId" + jobId, e);
			return null;
		}
	}

}
