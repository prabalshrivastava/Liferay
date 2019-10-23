package com.sambaash.platform.pe.helpers;

import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.jaxb.PEDataSubmittable;
import com.sambaash.platform.pe.jaxb.PENodeSubType;
import com.sambaash.platform.pe.jaxb.PEPayment;
import com.sambaash.platform.pe.jaxb.PEPaymentV2;
import com.sambaash.platform.pe.jaxb.PEPricing;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEProcessHelper {

	public static boolean isAgent(User user, PEProcess process) throws SystemException {
		String temp[] = process.getAgentRoleIds().split(StringPool.COMMA);
		boolean isAgent = false;

		for (String roleId : temp) {
			if (UserLocalServiceUtil.hasRoleUser(GetterUtil.getLong(roleId), user.getUserId())) {
				isAgent = true; break;
			}
		}

		return isAgent;
	}
	public static boolean isSupervisor(User user, PEProcess process) throws SystemException {
		String temp[] = process.getSupervisorRoleIds().split(StringPool.COMMA);
		boolean isSupervisor = false;
		
		for (String roleId : temp) {
			if (UserLocalServiceUtil.hasRoleUser(GetterUtil.getLong(roleId), user.getUserId())) {
				isSupervisor = true; 
				break;
			}
		}
		
		return isSupervisor;
	}
	public static boolean isGlobalStatusTypeApprover(User user, PEProcess process) throws SystemException {
		String temp[] = process.getApproveRoleIds().split(StringPool.COMMA);
		boolean isApprover = false;

		for (String roleId : temp) {
			if (UserLocalServiceUtil.hasRoleUser(GetterUtil.getLong(roleId), user.getUserId())) {
				isApprover = true;
				break;
			}
		}
		
		return isApprover;
	}

	public static boolean isApplicant(User user, PEProcessState processState ) throws SystemException {
		boolean isOwner = false;

		if (processState.getUserIdProcess() != 0 && user.getUserId() == processState.getUserIdProcess()) {
			isOwner = true;
		}

		return isOwner;
	}
	
	/**
	 *  Process Engine for an application can be run by one of below users
	 *  
	 *  1. Candidate of Application
	 *  2. Agent
	 *  3. Global status type approver
	 *      Process contains multiple steps (Status Types). Each can be approved/rejected by different role. 
	 *  4. At least One of the status type approver
	 *      Process contains multiple form/jsps. Each can be submitted by different role.
	 *  5. At least one of the form submiters  
	 * 
	 * @param user
	 * @param ds
	 * @return
	 * @throws SystemException 
	 */
	public static boolean canRunProcessEngine(User user, PEDataSource ds) throws SystemException{
		
		PEProcessState processState = ds.getProcessState();
		PERequestData requestData = ds.getRequestData();
		if(processState.isNew() || isApplicant(user,ds.getProcessState() ) || ds.isAgentLoggedInUser() || ds.isSupervisorLoggedInUser() || processState.getUserIdCreator() == requestData.getUserId() || isGlobalStatusTypeApprover(user, ds.getProcess())){
			return true;
		}
		
		PEProcessDirectory directory = ds.getDirectory();
		List<Long>roleIds = directory.getApproverRoleIds();
		roleIds.addAll(directory.getSubmitterRoleIds());
		
		for (Long roleId : roleIds) {
			if(roleId == ds.getProcess().getApplicantRoleId()){
				// ignore applicant role id.
				continue;
			}
			if (UserLocalServiceUtil.hasRoleUser(GetterUtil.getLong(roleId), user.getUserId())) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean supportedDevice(PortletRequest request){
		boolean supported = true;
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
		if(BrowserSnifferUtil.isMobile(httpServletRequest)){
			PortletPreferences preferences = request.getPreferences();
			supported = GetterUtil.getBoolean(preferences.getValue(PEConstants.PREF_MOBILE_SUPPORT, "false"));
		}
		return supported;
	}

	public static boolean canSubmitData(PEDataSource ds ,PEDataSubmittable submittable){
		
		try {
			// Submission is possible only once. If node trying to submit is different from current node then return false
			// allow this for payment
			boolean isPaymentV1 = (submittable instanceof PEPayment);
			boolean isPaymentV2 = (submittable instanceof PEPaymentV2);
			boolean isPayment = isPaymentV1 || isPaymentV2;
			if(!isPayment && ds.getProcessState().getNodeId() != 0&& !ds.isFirstRequest() && ds.isFirstRequest() && submittable.getNodeId() != ds.getProcessState().getNodeId()){
				return false;
			}
			if(isPayment || ds.isApplicantLoggedInUser()) {
				if( (isPaymentV1 && ((PEPayment)submittable).isSubmittableByUser(ds)) || 
					(isPaymentV2 && ((PEPaymentV2)submittable).isSubmittableByUser(ds)) || 
					submittable.isSubmittableByUser())
				{
					return true;
				}
			}
			
			boolean isPricing = (submittable instanceof PEPricing);
			if (isPricing && ((PEPricing)submittable).isSubmittableByUser(ds)) {
				return true;
			}
			List<Long> submitterRoleIds = submittable.getSubmitterRoleIdsAsList();
			User loggedInUser = ds.getLoggedInUser();
			for (Long roleId : submitterRoleIds) {
				if(UserLocalServiceUtil.hasRoleUser(roleId, loggedInUser.getUserId())){
					return true;
				}
			}
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
		return false;
	}
	
	public static boolean isForm(String type){
		return PEAuditConstants.TYPE_FORM.equalsIgnoreCase(type);
	}
	public static boolean isFormV2(String type){
		return PEAuditConstants.TYPE_FORMV2.equalsIgnoreCase(type);
	}
	public static boolean isJSP(String type){
		return PEAuditConstants.TYPE_JSP.equalsIgnoreCase(type);
	}
	public static boolean isForm(PEProcessableNode node){
		if(node == null) return false;
		return isForm(node.getNodeSubType());
	}
	public static boolean isFormV2(PEProcessableNode node){
		if(node == null) return false;
		return isFormV2(node.getNodeSubType());
	}
	public static boolean isJSP(PEProcessableNode node){
		if(node == null) return false;
		return isJSP(node.getNodeSubType());
	}
	public static boolean isPayment(PEProcessableNode node){
		if(node == null) return false;
		return isPayment(node.getNodeSubType());
	}
	public static boolean isForm(PENodeSubType type){
		return PENodeSubType.FORM == type;
	}
	public static boolean isFormV2(PENodeSubType type){
		return PENodeSubType.FORMV2 == type;
	}
	public static boolean isJSP(PENodeSubType type){
		return PENodeSubType.JSP == type;
	}	
	public static boolean isPayment(PENodeSubType type){
		return PENodeSubType.PAYMENT == type || PENodeSubType.PAYMENTV2 == type;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PEProcessHelper.class);
}