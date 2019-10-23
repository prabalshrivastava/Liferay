package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.handlers.PEPricingHandler;
import com.sambaash.platform.pe.pricing.PEPricingHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEPricing extends PEDataSubmittableMultiOutputNode {

	private String name;
	private String scheme;
	private String subScheme;
	private boolean outstanding;
	private boolean consolidate;
	private long nextNodeId = -1;
		
	public String getJspName(){
		return "pricing";
	}
	
	public void fillOutput(PEOutput output) {
		// name - for jsp file name - fixed as "payment.jsp"
		output.setName(getJspName());

		// heading
		output.setHeading(WordUtils.capitalizeFully(getName()));
	}

	public String getName() {
		if (StringUtils.isEmpty(name)) {
			name = getJspName();
		}
		return name;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.PRICING;
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
			PENodeHandler handler = new PEPricingHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@Override
	// use the other one due to condition in PEProcessHelper.canSubmitData() which allows sales agents to submit for the user.
	public boolean isSubmittableByUser() { 
		return false;
	}

	public boolean canProceedToNextStep(PEDataSource dataSource) throws SystemException, PEException, PortalException{
		PEPricingHelper helper = new PEPricingHelper(dataSource, this);
		
		return helper.canProceedToNextStep();
	}

	@XmlElement(name ="name")
	public void setName(String name) {
		this.name = name;
	} 

	public String getScheme() {
		return scheme;
	}

	@XmlElement(name ="scheme")
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getSubScheme() {
		return subScheme;
	}

	@XmlElement(name ="subScheme")
	public void setSubScheme(String subScheme) {
		this.subScheme = subScheme;
	}

	public Boolean getOutstanding() {
		return outstanding;
	}

	@XmlElement(name ="outstanding")
	public void setOutstanding(Boolean outstanding) {
		this.outstanding = outstanding;
	}

	public Boolean getConsolidate() {
		return consolidate;
	}

	@XmlElement(name ="consolidate")
	public void setConsolidate(Boolean consolidate) {
		this.consolidate = consolidate;
	}

	public long getNextNodeId() {
		return this.nextNodeId;
	}

	@XmlElement(name = "nextNodeId")
	public void setNextNodeId(long nodeId) {
		this.nextNodeId = nodeId;
	}
	
	public boolean isSubmittableByUser(PEDataSource ds) {
		try {
			return ds.isApplicantLoggedInUser() || ds.isAgentLoggedInUser();			
		} catch (Exception e) {
			return false;
		}
	}
}