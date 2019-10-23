package com.sambaash.platform.pe.jaxb;

public interface PEScheduledJob {
	public String getCronSchedule();
	public void setCronSchedule(String cronSchedule);
	public String getExecOnce();
	public void setExecOnce(String execOnce);
	public boolean isExecuteOnceOnly();
	public String getJobListener();
	public void setJobListener(String jobListener);
}