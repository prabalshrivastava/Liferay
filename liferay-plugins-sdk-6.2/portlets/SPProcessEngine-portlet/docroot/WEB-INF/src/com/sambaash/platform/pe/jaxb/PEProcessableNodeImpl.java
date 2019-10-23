package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.exception.PEException;
public abstract class PEProcessableNodeImpl implements PEProcessableNode {

	private long nodeId;
	String nodeType;
	private String allowReprocess;

	@Override
	public long getNodeId() {
		return nodeId;
	}

	@Override
	@XmlElement(name = "nodeId")
	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getAllowReprocess() {
		return allowReprocess;
	}

	@XmlElement(name = "allowReprocess")
	public void setAllowReprocess(String allowReprocess) {
		this.allowReprocess = allowReprocess;
	}

	public String toString() {
		return "NodeImpl [nodeId=" + nodeId + ", nodeType=" + nodeType + "]";
	}

	@Override
	public boolean isDisplayable() {
		return false;
	}

	@Override
	public boolean isDataSubmittable() {
		return false;
	}
	
	public boolean canProceedToNextStep(PEDataSource dataSource) throws SystemException, PEException, PortalException{
		return true;
	}
	
	public boolean isReprocessable() {
		return Boolean.valueOf(allowReprocess);
	}
}