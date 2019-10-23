package com.sambaash.platform.pe.jaxb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.handlers.PEPaymentV2Handler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEPaymentV2 extends PEDataSubmittableMultiOutputNode {

	public static final String DEFAULT_PAYMENT_PROVIDER = "stripe";

	private String name;
	private String provider;
	private String paySiteName;
	private String paySiteLogo;
	private String paymentCancel = "true";
	private String paymentRefundOn = "false";
	private String paidMsg;
	private String refundedMsg;
	private PEDataMapping dataMapping;
	private Map<String, String> simplifiedMap = new HashMap<String, String>();
	private boolean allowGuest = true;
	private String termsAndCondition;
	private String enableOfflinePayment = "false";

	public String getJspName(){
		return "paymentV2";
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
		return PENodeSubType.PAYMENTV2;
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
			PENodeHandler handler = new PEPaymentV2Handler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@Override
	// use the other one due to condition in PEProcessHelper.canSubmitData() which allows sales agents and supervisors to submit for the user.
	// payment needs credit card info that only the applicant should input
	public boolean isSubmittableByUser() { 
		return false;
	}

	@XmlElement(name ="name")
	public void setName(String name) {
		this.name = name;
	} 

	public boolean canProceedToNextStep(PEDataSource dataSource) throws SystemException, PEException, PortalException{
//		PEPaymentHelper helper = new PEPaymentHelper(dataSource, this);
//		
//		return helper.canProceedToNextStep();
		return true;
	}
	// name represent heading to be displayed in on browser. // Actual jsp file name stored in ruleset table

	public String getProvider() {
		if (StringUtils.isEmpty(provider)) {
			provider = DEFAULT_PAYMENT_PROVIDER;
		}
		return provider;
	}

	@XmlElement(name ="provider")
	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPaySiteName() {
		return paySiteName;
	}

	@XmlElement(name ="paySiteName")
	public void setPaySiteName(String paySiteName) {
		this.paySiteName = paySiteName;
	}

	public String getPaySiteLogo() {
		return paySiteLogo;
	}

	@XmlElement(name ="paySiteLogo")
	public void setPaySiteLogo(String paySiteLogo) {
		this.paySiteLogo = paySiteLogo;
	}

	public String getPaidMsg() {
		return paidMsg;
	}

	@XmlElement(name ="paidMsg")
	public void setPaidMsg(String paidMsg) {
		this.paidMsg = paidMsg;
	}

	public String getRefundedMsg() {
		return refundedMsg;
	}

	@XmlElement(name ="refundedMsg")
	public void setRefundedMsg(String refundedMsg) {
		this.refundedMsg = refundedMsg;
	}

	public PEDataMapping getDataMapping() {
		return dataMapping;
	}

	public String getPaymentCancel() {
		return paymentCancel;
	}
	@XmlElement(name ="paymentCancel")
	public void setPaymentCancel(String paymentCancel) {
		this.paymentCancel = paymentCancel;
	}

	public String getPaymentRefundOn() {
		return paymentRefundOn;
	}

	@XmlElement(name ="paymentRefundOn")
	public void setPaymentRefundOn(String paymentRefundOn) {
		this.paymentRefundOn = paymentRefundOn;
	}
	
	public String getTermsAndCondition() {
		return termsAndCondition;
	}

	@XmlElement(name ="termsAndCondition")
	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	@XmlElement(name ="dataMapping")
	public void setDataMapping(PEDataMapping dataMapping) {
		this.dataMapping = dataMapping;
		if (this.dataMapping != null && this.dataMapping.getElmnts() != null) {
			List<PEDataMappingElement> list = this.dataMapping.getElmnts();
			for (PEDataMappingElement element : list) {
				if (element.getFieldId().startsWith("stripe.")) {
					this.simplifiedMap.put(element.getFieldId(), element.getProcessFieldId());
				} else {
					this.simplifiedMap.put(element.getProcessFieldId(), element.getFieldId());
				}
			}
		}
	}
	
	public String[] getDatamapKeys() {
		return this.simplifiedMap.isEmpty() ? new String[0] : this.simplifiedMap.keySet().toArray(new String[0]);
	}
	
	public String getDatamap(PEDataSource ds, String key) {
		String value = "";
		if (this.simplifiedMap.containsKey(key)) {
			if (key.startsWith("stripe.")) {
				return this.simplifiedMap.get(key);  	// for stripe, it is the actually data. not a data key.
			} else {
				return ds.getData(this.simplifiedMap.get(key));
			}
		}
		return value;
	}

	public boolean isAllowGuest() {
		return allowGuest;
	}

	public void setAllowGuest(boolean allowGuest) {
		this.allowGuest = allowGuest;
	}

	@XmlElement(name ="enableOfflinePayment")
	public String getEnableOfflinePayment() {
		return enableOfflinePayment;
	}

	public void setEnableOfflinePayment(String enableOfflinePayment) {
		this.enableOfflinePayment = enableOfflinePayment;
	}

	public boolean isSubmittableByUser(PEDataSource ds) {
		try {
			// already submitted once for payment. Next succeeding submission is for refund.
			boolean refundSubmit = (ds.getProcessState().getNodeId() != 0&& !ds.isFirstRequest() && getNodeId() != ds.getProcessState().getNodeId());	
			// initial submit is applicant only (payment)
			// succeeding submit is for refund that is for supervisors only
			return (!refundSubmit && (ds.isApplicantLoggedInUser()||(!ds.isSignedInUser() && isAllowGuest()))) 
					|| (refundSubmit && ds.isSupervisorLoggedInUser());			
		} catch (Exception e) {
			return false;
		}
	}
}