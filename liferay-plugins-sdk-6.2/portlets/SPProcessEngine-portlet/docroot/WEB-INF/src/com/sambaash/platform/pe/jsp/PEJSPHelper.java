package com.sambaash.platform.pe.jsp;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;

public class PEJSPHelper {


	protected final PEDataSource ds;
	protected final PEJSP jspNode;
	
	public PEJSPHelper(PEDataSource ds,PEJSP jspNode) {
		this.ds = ds;
		this.jspNode = jspNode;
	}
	
	public PESimpleOutput save() throws PEException{
		audit();
		return new PESimpleOutput();
	}
	
	public static void preprocess(PEDataSource ds,PEJSP jspNode){
		PEJSPHelper helper = PEJSPRegistry.getRegistry().getJspHelper(ds, jspNode);
		helper.preprocess();
	}
	public void preprocess(){
		
	}
	
	public void extraCallBackAfterSubmit(){
		
	}
	public void audit() throws PEException{
		audit(ds.getFormJspData());
	}
	
	public void audit(String data) throws PEException{
		// Audit the form submission
		PEAuditHelper auditHelper = ds.getAuditHelper();
		if(ds.isSubmitRequest() || ds.isForceSubmit()){
			auditHelper.logJSPSubmit(String.valueOf(ds.getRequestData().getUserId()), jspNode.getRuleSetId(), jspNode.getNodeId(),data);
		}else{
			auditHelper.logJSPSave(String.valueOf(ds.getRequestData().getUserId()), jspNode.getRuleSetId(), jspNode.getNodeId(),data);
		}
	}
	
	/**
	 * To check if underlying jsp data submission is to external system.
	 * For example, if your jsp has iframe containing link to some external system. In such cases, submit can not be audited and has to be handled 
	 * by underlying jsp handler.
	 * 
	 * 
	 * @return
	 */
	public boolean isExternalDataSubmission(){
		return false;
	}
	
	public void auditExternalDataSubmission() throws PEException{
		audit(StringPool.BLANK);
	}
	
	public boolean isCompleted(){
		try {
			PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), jspNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
			return true;
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return false;
		}
	}
	
	public void setForceSubmit(){
		
	}
	private static Log _log = LogFactoryUtil.getLog(PEJSPHelper.class);
}
