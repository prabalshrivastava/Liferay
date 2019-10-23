package com.sambaash.platform.constant;

public interface SPSchedulerConstants {
	
	String DEFAULT_GROUP_NAME = "SambaashTask";
	String DATA_JOB_CRON_EXP = "data_job_cron_expr";
	String DATA_SP_JOB_ID = "data_sp_job_entry_id";
	
	int GROUP_NAME_MAX_LENGTH = 80;

	int JOB_NAME_MAX_LENGTH = 80;
	
	String DATA_PORTLET_ID = "data_portletId";
	
	String PORTLET_ID = "sambaashscheduleraction_WAR_SPSchedulerportlet";
	
	String ACTION = "action";
	
	String ERROR_MSG = "errorMsg";
	
	String PARAM_DELETE_JOB = "actionDeleteJob";
	
	String PARAM_PAUSE_JOB = "actionPauseJob";
	
	String PARAM_RESUME_JOB = "actionResumeJob";
	
	String PARAM_RESCHEDULE_JOB = "actionRescheduleJob";
	
	String CRON_EXPR = "cronExpr";
	
	String JOB_ID = "jobId";
	
	String START_DATE = "startDate";
	
	String END_DATE = "endDate";
	
}
