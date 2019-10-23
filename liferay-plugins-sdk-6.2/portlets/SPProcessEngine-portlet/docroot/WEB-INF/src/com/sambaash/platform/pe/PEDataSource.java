package com.sambaash.platform.pe;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.URIException;
import javax.xml.bind.JAXBException;
import com.liferay.portal.kernel.util.HttpUtil;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.util.DateUtils;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.URLUtil;
public class PEDataSource {

	public static final Pattern TOKEN_PATTERN = Pattern.compile("\\[\\$[a-zA-Z0-9_\\-\\(\\)]*\\$\\]");

	private static Log _log = LogFactoryUtil.getLog(PEDataSource.class);

	private PEProcessState processState;
	private PEProcessDirectory directory;
	private PEProcess process;
	private PEProcessStatusType statusTypeCurrent;
	private PEProcessStatusType statusTypeRequested;
	private PEEntity peEntity;

	//TOO: temporary fix for suppressing mail notifications
	private boolean suppressMailNotifications= false;
	private boolean firstRequest = false;
	private boolean firstFormSubmission = false;
	private User applicant; // process owner
	
	private PEProcessStateDataAdapter processDataAdapter;
	private PEFormDataAdapter formDataAdapter;

	// used to indicate the node id of form/jsp which is just submitted
	private long nodeIdDataSubmitted;
	
	// pending audits before account creation - will be updated upon creating account

	private PERequestData requestData ;
	public void setRequestData(PERequestData requestData) {
		this.requestData = requestData;
	}

	public PEDataSource(PERequestData requestData, PEProcessState processState) throws PEException, SystemException {
		if (Validator.isNull(processState)) {
			throw new PEException(PEErrors.PROCESS_STATE_NULL);
		}

		this.requestData = requestData;
		this.setProcessState(processState);
		try {
			this.setDirectory(PEProcessCache.getInstance().getProcessDirectory(processState.getSpPEProcessId()));
			this.setProcess(getDirectory().getProcess());
		} catch (PEConfigException e) {
			throw e;
		} catch (JAXBException e) {
			throw new PEException(PEErrors.PROCESS_DEF_PARSE_ERROR);
		}

		// underlying entity

		//peEntity = PEEntityHelper.getEntity(processState.getEntityClassId(), processState.getEntityId());
		peEntity = PEProcessLocalServiceUtil.getEntityDetail(processState.getEntityClassId(), String.valueOf(processState.getEntityId()), requestData.getUserId(), processState.getGroupId());
		
		processDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(processState);
		formDataAdapter = PEFormDataAdapter.getFormDataAdapter(processState);
		
		setSuppressMailNotifications(GetterUtil.getBoolean(requestData.getParameter(PEConstants.PARAM_SUPPRESS_MAIL_NOTIFICATIONS)));
	}

	public String getFullNameApplicant() {
		return getApplicant().getFullName();
	}

	public String getEmailApplicant() {
		return getApplicant().getEmailAddress();
	}

	public PEProcess getProcess() {
		return getDirectory().getProcess();
	}

	public String getDataFromRequest(String fieldName) {
		return requestData.getParameter(fieldName);
	}
	public String getFormJspData() {
		return requestData.getParameter(PEConstants.PARAM_FORM_DATA_SUBMITTED);
	}

	public String getDataFromProcessState(String fieldName) {
		// pass refresh = true, to get the latest data
		return processDataAdapter.getDataFromProcessState(fieldName,true);
	}

	public String getData(String fieldName) {
		String value = StringPool.BLANK;
		_log.debug("In  getData:  " + fieldName);
		try{
		if (getProcessState().isNew() && getProcessState().getUserIdProcess() == 0) {
			// guest user
			//TODO : paramsJson get the field from paramsJson and return it.
		}
		
		if(PEConstants.USER_ID.equalsIgnoreCase(fieldName)){
			value = String.valueOf(getProcessState().getUserIdProcess());
		}
		
		if(PEConstants.SITE_ID.equalsIgnoreCase(fieldName)){
			value = String.valueOf(SambaashUtil.getScopeGroupId(getProcessState().getGroupId()));
		}
		
		
		// Check if the field is entity field.
		if(PEEntityHelper.isEntityProperty(fieldName)){
			return PEEntityHelper.getPEEntityFieldValue(processState.getEntityClassId(), processState.getEntityId(), PEEntityHelper.stripEntityPropery(fieldName));
		}
		
		PEProcessableNode nodeReceived = directory.getNode(requestData.getNodeIdReceived());
		if(PEProcessHelper.isForm(nodeReceived)){
			// Try to , get the value from just submitted form
			value = formDataAdapter.getDataFromJustSubmittedForm(fieldName);
		} else if(PEProcessHelper.isFormV2(nodeReceived)){
			value = formDataAdapter.getDataFromJustSubmittedFormV2(fieldName);
		}else if(PEProcessHelper.isJSP(nodeReceived)){
			
		}
		
		// if not found, check in process state
		if (Validator.isNull(value)) {
			value = getDataFromProcessState(fieldName);
		}

		// if not found, check in request  object
		if (Validator.isNull(value)) {
			value = getDataFromRequest(fieldName);
		}
		}
		catch(Exception e){
			_log.debug("Exception "+ fieldName + " : "+ value);
		}
		_log.debug("Process State Data "+ fieldName + " : "+ value);
		return GetterUtil.getString(value);
	}
	
	public String getTokenizedData(String fieldName) {
		String storedData = getData(fieldName);
		return replaceTokensInData(storedData);
	}
	
	public String replaceTokensInData(String data) {
		return replaceTokensInData(data, false);
	}
	
	public String replaceTokensInData(String data, boolean encode) {
		_log.debug("IN replaceTokensInData :  data : " + data);
		
		Pattern patt = TOKEN_PATTERN;
		Matcher m = patt.matcher(data);
		StringBuffer sb = new StringBuffer(data.length());
		while (m.find()) {
			
		    try {
		    	 String text = m.group(0);
		    	 _log.debug("IN Matcher loop : " + text);
		    	 StringBuilder propSb = new StringBuilder(text);
		    	 propSb.replace(0, 2, ""); // replace [$
		    	 propSb.replace(propSb.length()-2, propSb.length(), ""); // replace $]
		    	 String token = propSb.toString();
		    	 String replacedData;
				if ("now()".equalsIgnoreCase(token)) {
		    		 replacedData = DateUtils.toDateTimeStringFormat(new Date());
		    	 } else if ("stateData()".equalsIgnoreCase(token)) {
		    		 replacedData = processState.getData();
		    	 } else if ("getSpPEProcessId()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(processState.getSpPEProcessId());
		    	 } else if ("getSpPEProcessStateId()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(processState.getSpPEProcessStateId());
		    	 } else if ("getUserIdCreator()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(processState.getUserIdCreator());
		    	 } else if ("getUserIdProcess()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(processState.getUserIdProcess());
		    	 } else if ("getUserIdProcessFullName()".equalsIgnoreCase(token)) {
		    		 replacedData = UserLocalServiceUtil.getUser(processState.getUserIdProcess()).getFullName();
		    	 } else if ("getUserIdProcessFirstName()".equalsIgnoreCase(token)) {
		    		 replacedData = UserLocalServiceUtil.getUser(processState.getUserIdProcess()).getFirstName();
		    	 } else if ("getUserIdProcessLastName()".equalsIgnoreCase(token)) {
		    		 replacedData = UserLocalServiceUtil.getUser(processState.getUserIdProcess()).getLastName();
		    	 } else if ("getUserIdProcessEmailAddress()".equalsIgnoreCase(token)) {
		    		 replacedData = UserLocalServiceUtil.getUser(processState.getUserIdProcess()).getEmailAddress();
		    	 } else if ("getScopeGroupId()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(SambaashUtil.getScopeGroupId(processState.getGroupId()));
		    	 } else if ("getProductTypeId()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(this.getProcess().getProductTypeId());
		    	 } else if ("getSubProductTypeId()".equalsIgnoreCase(token)) {
		    		 replacedData = String.valueOf(this.getProcess().getSubProductTypeId());
		    	 } else if (PEConstants.USER_ID.equalsIgnoreCase(token)){
		    		 replacedData = getData(token);
		    	 } else if (PEConstants.SITE_ID.equalsIgnoreCase(token)){
		    		 replacedData = getData(token);
		    	 } else {
		    		 replacedData = getData(token);
		    	 }
				if (encode) {
					replacedData = URLUtil.encodeValue(replacedData);
				}
				_log.debug("replaced data => " + replacedData);
				m.appendReplacement(sb,replacedData);
			} catch (Exception e) {
				_log.error("Error while processing token",e);
			}
		}
		
		m.appendTail(sb);	
		return sb.toString().trim();
	}

	public void rememberFormDataJustSubmitted() throws PEException{
			if(PEProcessHelper.isForm(directory.getNode(requestData.getNodeIdReceived()))
			  || PEProcessHelper.isFormV2(directory.getNode(requestData.getNodeIdReceived())))
			{
				// this must be send form client
				String data = requestData.getStringParameter(PEConstants.PARAM_FORM_DATA_SUBMITTED);
				if(Validator.isNull(data)){
					throw new PEException("Invalid data submitted from form");
				}
				JSONObject form;
				try {
					form = JSONFactoryUtil.createJSONObject(data);
				} catch (JSONException e) {
					throw new PEException("Invalid data submitted from form");
				}
				formDataAdapter.registerAsJustSubmitted(form);
			}
	}

	public String getProcessName() {
		return getProcess().getName();
	}
	
	public String getEntityName(){
		PEEntity entity = PEEntityHelper.getEntity(processState.getEntityClassId(), processState.getEntityId());
		String entityName = StringPool.BLANK;
		if (entity != null) {
			entityName = entity.getName();
		}
		return entityName;
	}

	
	public long getCompanyId(){
		return requestData.getCompanyId();
	}

	public boolean isSignedInUser() {
		return requestData.isSignedIn();
	}

	
	public PEProcessDirectory getDirectory() {
		return directory;
	}

	public void setDirectory(PEProcessDirectory directory) {
		this.directory = directory;
	}

	public void setProcess(PEProcess process) {
		this.process = process;
	}

	public PEProcessState getProcessState() {
		return processState;
	}

	public void setProcessState(PEProcessState processState) {
		this.processState = processState;
	}

	public PEProcessStatusType getStatusTypeRequested() {
		return statusTypeRequested;
	}

	public void setStatusTypeRequested(PEProcessStatusType statusTypeRequested) {
		this.statusTypeRequested = statusTypeRequested;
	}

	public boolean isFirstRequest() {
		return firstRequest;
	}

	public void setFirstRequest(boolean firstRequest) {
		this.firstRequest = firstRequest;
	}

	public boolean isFirstFormSubmission() {
		return firstFormSubmission;
	}

	public void setFirstFormSubmission(boolean firstFormSubmission) {
		this.firstFormSubmission = firstFormSubmission;
	}

	public PEEntity getPeEntity() {
		return peEntity;
	}

	public void setPeEntity(PEEntity peEntity) {
		this.peEntity = peEntity;
	}

	public User getApplicant() {
		// during first step user may not exist. So Account create handler will reset this user if user gets created
		if(applicant == null){
			try {
				setUser(UserLocalServiceUtil.fetchUser(processState.getUserIdProcess()));
			} catch (SystemException e) {
				_log.error(e);
			}
		}
		return applicant;
	}

	public void setUser(User user) {
		this.applicant = user;
	}

	public PEAuditHelper getAuditHelper(){
		if(auditHelper == null){
			auditHelper = PEAuditHelper.getAuditHelper(processState, this);
		}
		return auditHelper;
	}
	
	public PEFormDataAdapter getFormDataAdapter(){
		return  formDataAdapter;
	}
	
	public void setAuditHelper(PEAuditHelper helper){
		auditHelper = helper;
	}

	public PEProcessStatusType getStatusTypeCurrent() throws SystemException {
		if (statusTypeCurrent == null) {
			if (processState.getStatusTypeId() != 0){ // check, for new/guest it is zero initially
				statusTypeCurrent = PEProcessStatusTypeLocalServiceUtil.fetchPEProcessStatusType(processState.getStatusTypeId());
			}
		}

		return statusTypeCurrent;
	}

	private PEAuditHelper auditHelper;
	

	/**
	 * Method is used to determine whether logged in user can approve the pending application
	 * 
	 * Approver Role Ids are at two places
	 * 1) Process Level : (SPPeProcss table) These roles can approve the application irrespective the status type
	 * 2) Status Type (Step): Approvers can be defined at each status level. 
	 *
	 *  If logged in user satisfies one of above then he approve/reject the current pending application
	 * 
	 *  Method used to determine if the logged in user can approve the pending application.
	 *  Here pending refers to Current Step pending 
	 * 
	 * @return
	 * @throws SystemException
	 */
	public boolean isCurrentStatusApproverLoggedInUser() throws SystemException {
		User user = requestData.getUser();
		boolean isApprover = PEProcessHelper.isGlobalStatusTypeApprover(user, process);
		if(isApprover){
			return isApprover;
		}
		// status must be in pending state..
		if(PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus())){
			String currentStatusApprovers = GetterUtil.getString(processState.getCurrentStatusTypeApprovers());
			String temp[] = currentStatusApprovers.split(StringPool.COMMA);
			for (String roleId : temp) {
				if (UserLocalServiceUtil.hasRoleUser(GetterUtil.getLong(roleId), user.getUserId())) {
					return true;
				}
			}
		}
		return false;
	}

	// checks if the logged in user is actually process owner
	public boolean isApplicantLoggedInUser() throws SystemException {
		User user = requestData.getUser();
		return PEProcessHelper.isApplicant(user, processState);
	}
	
	public boolean isAgentLoggedInUser() throws SystemException {
		User user = requestData.getUser();
		return PEProcessHelper.isAgent(user, process);
	}
	public boolean isSupervisorLoggedInUser() throws SystemException {
		User user = requestData.getUser();
		return PEProcessHelper.isSupervisor(user, process);
	}
	
	public User getLoggedInUser(){
		return requestData.getUser();
	}
	public long getLoggedInUserId(){
		return requestData.getUserId();
	}

	public PERequestData getRequestData(){
		return requestData;
	}

	public long getNodeIdDataSubmitted() {
		return nodeIdDataSubmitted;
	}

	public void setNodeIdDataSubmitted(long nodeIdDataSubmitted) {
		this.nodeIdDataSubmitted = nodeIdDataSubmitted;
	}
	
	public boolean isSubmitRequest(){
		return PEConstantsGlobal.ACTION_SUBMIT.equalsIgnoreCase(requestData.getParameter(PEConstants.PARAM_ACTION_TYPE));
	}
	
	
	public boolean isSaveequest(){
		return PEConstantsGlobal.ACTION_SAVE.equalsIgnoreCase(requestData.getParameter(PEConstants.PARAM_ACTION_TYPE));
	}

	private boolean forceSubmit = false;
	public boolean isForceSubmit() {
		return forceSubmit;
	}
	public void setForceSubmit(boolean forceSubmit) {
		this.forceSubmit = forceSubmit;
	}

	public boolean isSuppressMailNotifications() {
		return suppressMailNotifications;
	}

	public void setSuppressMailNotifications(boolean suppressMailNotifications) {
		this.suppressMailNotifications = suppressMailNotifications;
	}
	
	public boolean isReProcessing() {
		return Boolean.parseBoolean(getDataFromProcessState(PEConstants.PE_REPROCESSING));
	}
	
	private boolean hasTokenPattern(String data) {
        return TOKEN_PATTERN.matcher(data).find();
    }

    public String nestedReplaceToken(String data) {
        String newData="";
        String currData = data;
        while(currData != null){   
            newData = replaceTokensInData(currData);
            currData = !currData.equals(newData) && hasTokenPattern(newData) ? newData : null;
        }
        return newData;
    }
	
}
