package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public interface PEProcessableNode extends PENode {

	long getNodeId();
	void setNodeId(long nodeId);
	public String getAllowReprocess();
	public void setAllowReprocess(String allowReprocess);
	//TODO: can remove processState argument since datasource already contains same reference
	PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds);
	PENodeType getNodeType();
	PENodeSubType getNodeSubType();

	// if true then must implement Pedisplayable interface. Instance Of check is time consuming so going with this approach
	boolean isDisplayable();
	
	boolean isDataSubmittable();
	boolean canProceedToNextStep(PEDataSource dataSource) throws SystemException, PEException, PortalException;
	public boolean isReprocessable();
}