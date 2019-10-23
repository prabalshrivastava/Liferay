package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.exception.PEException;

abstract public class PEDataSubmittableMultiOutputNode extends MultiOutputNodeImpl implements PEDataSubmittable {

	private boolean submittableByUser;
	private String submitterRoleIds;
	private String waitMsg;
	private String editConfiguration;

	@Override
	public boolean isDataSubmittable() {
		return true;
	}

	public String getSubmitterRoleIds() {
		return submitterRoleIds;
	}
	
	@XmlElement(name ="submitterRoleIds")
	public void setSubmitterRoleIds(String submitterRoleIds) {
		this.submitterRoleIds = submitterRoleIds;
	}

	public boolean isSubmittableByUser() {
		return submittableByUser;
	}

	@XmlElement(name ="submittableByApplicant")
	public void setSubmittableByUser(boolean submittableByUser) {
		this.submittableByUser = submittableByUser;
	}
	
	public List<Long> getSubmitterRoleIdsAsList(){
		String ids[] = GetterUtil.getString(submitterRoleIds).split(StringPool.COMMA);
		List<Long>roleIdList = new ArrayList<Long>();
		for (String idStr : ids) {
			long id = GetterUtil.getLong(idStr);
			if(id > 0){
				roleIdList.add(id);
			}
		}
		
		return roleIdList;
	}

	public String getWaitMsg() {
		return waitMsg;
	}

	@XmlElement(name ="waitMsg")
	public void setWaitMsg(String waitMsg) {
		this.waitMsg = waitMsg;
	}

	public boolean canProceedToNextStep(PEDataSource dataSource) throws SystemException, PEException, PortalException{
		return false;
	}

	public String getEditConfiguration() {
		return editConfiguration;
	}

	@XmlElement(name ="editConfiguration")
	public void setEditConfiguration(String editConfiguration) {
		this.editConfiguration = editConfiguration;
	}

}
