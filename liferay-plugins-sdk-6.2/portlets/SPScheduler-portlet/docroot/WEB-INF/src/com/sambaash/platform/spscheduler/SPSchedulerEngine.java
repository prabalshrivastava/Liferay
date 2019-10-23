package com.sambaash.platform.spscheduler;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.sambaash.platform.spscheduler.impl.SPSchedulerUtil;

/**
 * Interface to be implemented to interact with third party scheduler. Shouldnt
 * be called directly, use SPSchedulerUtil.
 * 
 * @see SPSchedulerUtil
 */
public interface SPSchedulerEngine {

	void delete(String jobName, String groupName) throws SchedulerException;

	void pause(String jobName, String groupName) throws SchedulerException;

	void resume(String jobName, String groupName) throws SchedulerException;

	void schedule(JobDetail jobDetail, Trigger trigger)
			throws SchedulerException;

	void shutdown() throws SchedulerException;

	void start() throws SchedulerException;

	void unschedule(String jobName, String groupName) throws SchedulerException;

	SPJobInstanceData getScheduledJob(String jobName, String groupName)
			throws SchedulerException;

	List<SPJobInstanceData> getScheduledJobs() throws SchedulerException;

}