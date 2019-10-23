package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.handlers.PEJspHandler;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.helpers.PEJSPHelperOld;
import com.sambaash.platform.pe.helpers.PERuleSetHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import javax.xml.bind.annotation.XmlElement;
public class PEJSP extends PEDataSubmittableMultiOutputNode {

	public String getJspName(){
		return PERuleSetHelper.getJspName(getRuleSetId(), getRuleVersion());
	}
	public void fillOutput(PEOutput output) {

		// name - for jsp file name - get from ruleset table

		output.setName(PERuleSetHelper.getJspName(getRuleSetId(), getRuleVersion()));

		// heading

		output.setHeading(name);
	}

	public String getName() {
		return name;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.JSP;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.DATA_COLLECTING;
	}

	@Override
	public boolean isDisplayable() {
		return true;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEJspHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@XmlElement(name ="name")
	public void setName(String name) {
		this.name = name;
	} 

	public String getRuleVersion() {
		return ruleVersion;
	}
	
	@XmlElement(name ="ruleVersion")
	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}
	public boolean canProceedToNextStep(PEDataSource dataSource) throws SystemException, PEException, PortalException{
		PEJSPHelperOld helper = PEJSPHelperOld.getJspHelper(dataSource, this);
		
		return helper.canProceedToNextStep();
	}
	// name represent heading to be displayed in on browser. // Actual jsp file name stored in ruleset table

	private String name;
    private String ruleVersion = PEConstants.RULE_VERSION_1; // default to version 1 for backward compatibility
}