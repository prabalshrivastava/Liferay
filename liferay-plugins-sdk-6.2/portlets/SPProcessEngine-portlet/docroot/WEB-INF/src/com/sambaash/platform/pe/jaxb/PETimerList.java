package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
public class PETimerList  {

	private PEScheduledJobList scheduledJobList;

	public PEScheduledJobList getScheduledJobList() {
		return scheduledJobList;
	}

	@XmlElement(name="scheduledJobs")
	public void setScheduledJobList(PEScheduledJobList scheduledJobList) {
		this.scheduledJobList = scheduledJobList;
	}

}