package com.sambaash.platform.pe.jaxb;

import java.util.List;

public interface PEDataSubmittable extends PEDisplayable {

	public void setSubmittableByUser(boolean submittableByUser);
	public boolean isSubmittableByUser();
	
	/*public boolean isSubmittableByGuest();
	public void setSubmittableByGuest(boolean submittableByGuest);*/
	
	public void setSubmitterRoleIds(String submitterRoleIds);
	public String getSubmitterRoleIds();
	public List<Long> getSubmitterRoleIdsAsList();
	public void setWaitMsg(String waitMsg);
	public String getWaitMsg();
	public void setEditConfiguration(String editConfiguration);
	public String getEditConfiguration();
	
}
