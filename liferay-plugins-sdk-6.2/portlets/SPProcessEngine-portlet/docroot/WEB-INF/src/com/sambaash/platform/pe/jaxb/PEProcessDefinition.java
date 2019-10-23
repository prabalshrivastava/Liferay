package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "process")
public class PEProcessDefinition {
	private PEActions actions;
	private PEFormList forms;
	private PEFormV2List formsV2;
	private PEJSPList jsps;
	private PEPaymentList payments;
	private PEMsgList msgs;
	private PEPreviewList previews;
	private PEProcessNodeList processes;
	private PETimerList timers;
	private long startNodeId;
	private PEPaymentV2List paymentV2s;
	private PEApiNodeList apis;
	private PEPricingList pricings;
	private PEEntityNodeList entities;

	public PEActions getActions() {
		return actions;
	}

	public PEJSPList getJsps() {
		return jsps;
	}

	public PEPaymentList getPayments() {
		return payments;
	}

	public PEMsgList getMsgs() {
		return msgs;
	}

	public PEProcessNodeList getProcesses() {
		return processes;
	}

	public long getStartNodeId() {
		return startNodeId;
	}

	@XmlElement (name ="actions")
	public void setActions(PEActions actions) {
		this.actions = actions;
	} 
	
	public PEFormList getForms() {
		return forms;
	}

	@XmlElement (name = "forms")
	public void setForms(PEFormList forms) {
		this.forms = forms;
	}

	public PEFormV2List getFormsV2() {
		return formsV2;
	}

	@XmlElement (name = "formsV2")
	public void setFormsV2(PEFormV2List formsV2) {
		this.formsV2 = formsV2;
	}

	@XmlElement (name = "jsps")
	public void setJsps(PEJSPList jsps) {
		this.jsps = jsps;
	}

	@XmlElement (name = "payments")
	public void setPayments(PEPaymentList payments) {
		this.payments = payments;
	}

	@XmlElement (name = "msgs")
	public void setMsgs(PEMsgList msgs) {
		this.msgs = msgs;
	}

	@XmlElement (name = "processes")
	public void setProcesses(PEProcessNodeList processes) {
		this.processes = processes;
	}

	@XmlElement(name ="startNodeId")
	public void setStartNodeId(long startNodeId) {
		this.startNodeId = startNodeId;
	}

	public PETimerList getTimers() {
		return timers;
	}

	@XmlElement(name ="timers")
	public void setTimers(PETimerList timers) {
		this.timers = timers;
	}
	
	public PEPreviewList getPreviews() {
		return previews;
	}

	@XmlElement(name ="previews")
	public void setPreviews(PEPreviewList previews) {
		this.previews = previews;
	}

	public PEPaymentV2List getPaymentV2s() {
		return paymentV2s;
	}

	@XmlElement(name ="paymentV2s")
	public void setPaymentV2s(PEPaymentV2List paymentV2s) {
		this.paymentV2s = paymentV2s;
	}

	public PEApiNodeList getApis() {
		return apis;
	}

	@XmlElement(name ="apis")
	public void setApis(PEApiNodeList apis) {
		this.apis = apis;
	}

	public PEPricingList getPricings() {
		return pricings;
	}

	@XmlElement(name ="pricings")
	public void setPricings(PEPricingList pricings) {
		this.pricings = pricings;
	}

	public PEEntityNodeList getEntities() {
		return entities;
	}

	@XmlElement(name ="entities")
	public void setEntities(PEEntityNodeList entities) {
		this.entities = entities;
	}

}