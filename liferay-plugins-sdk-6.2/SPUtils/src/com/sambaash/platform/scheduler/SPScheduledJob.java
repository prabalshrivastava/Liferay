package com.sambaash.platform.scheduler;

import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

/**
 * Base Scheduler Job class which needs to be extended and implemented thru an
 * abstract <code>execute</code> method. It new inherited class can be used to
 * call the quartz scheduler thru a Liferay's implementation of Quartz or thru
 * Sambaash Platform implementation
 */
public abstract class SPScheduledJob implements Job, MessageListener {

	Message message;
	JobExecutionContext jobContext;

	@Override
	public void execute(JobExecutionContext jobContext)
			throws JobExecutionException {
		this.jobContext = jobContext;
		try {
			preProcess();
			executeJob();
			postProcess();
		} catch (Exception e) {
			handleException(e);
			throw new JobExecutionException(e);
		}
	}

	@Override
	public void receive(Message message) throws MessageListenerException {
		this.message = message;
		try {
			preProcess();
			executeJob();
			postProcess();
		} catch (Exception e) {
			handleException(e);
			throw new MessageListenerException(e);
		}
	}

	public abstract void executeJob();

	public Message getMessage() {
		return message;
	}

	public JobExecutionContext getJobExecutionContext() {
		return jobContext;
	}

	// TODO fix the below methods for liferay flow
	protected final Map<String, Object> getExtrasMap() {
		if (jobContext != null) {
			return jobContext.getJobDetail().getJobDataMap().getWrappedMap();
		} else {
			return null;
		}
	}

	protected final Long getSPJobEntryId() {
		return GetterUtil.getLong(getExtrasMap().get(
				SPSchedulerConstants.DATA_SP_JOB_ID));
	}

	private void preProcess() {
		SPJobDatabaseLogger.updateJobStatus(getSPJobEntryId(),
				SPScheduleJobStatus.RUNNING, "Inprogress");
	}

	private void handleException(Throwable e) {
		SPJobDatabaseLogger.updateJobStatus(getSPJobEntryId(),
				SPScheduleJobStatus.FAILURE, "Error while running" + e.getMessage());
	}

	private void postProcess() {
		SPJobDatabaseLogger.updateJobStatus(getSPJobEntryId(),
				SPScheduleJobStatus.SUCCESS, "Success");
	}

}
