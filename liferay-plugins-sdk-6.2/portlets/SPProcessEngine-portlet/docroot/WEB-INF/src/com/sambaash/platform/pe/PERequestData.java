package com.sambaash.platform.pe;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.cache.PEProcessDirectoryHelper;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.util.ConvertUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PERequestData {
	private static final Log LOG = LogFactoryUtil.getLog(PERequestData.class);
			
	private Map<String,String[]> requestParams;
	
	// user  - indicates logged in user.
	private long userId;
	private User user;
	private boolean signedIn;
	private long scopeGroupId;
	private long companyId;
	private String showProcessProgress;
	private String enableTempStorageValidation;
	private String programmeCode;
	private boolean privateLayout;
	private String groupName;


	public String getProgrammeCode() {
		return programmeCode;
	}

	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}

	private String portalUrl;
	private String signInUrl;
	private PortletRequest portletRequest;
	
	public PortletRequest getPortletRequest() {
		return portletRequest;
	}

	public void setPortletRequest(PortletRequest portletRequest) {
		this.portletRequest = portletRequest;
	}

	private long curPlid;

	// read from preferences 
	private boolean supportedDevice;
	
	
	private PERequestData(long userId,long scopeGroupId,long companyId) throws PortalException, SystemException{
		this.userId = userId;
		this.user = UserLocalServiceUtil.getUser(userId);
		this.scopeGroupId = scopeGroupId;
		this.companyId = companyId;
	}

	private PERequestData(User user,long scopeGroupId,long companyId){
		this.userId = user.getUserId();
		this.user = user;
		this.scopeGroupId = scopeGroupId;
		this.companyId = companyId;
	}
	
	
	public Map<String, String[]> getRequestParams() {
		return requestParams;
	}
	public void setRequestParams(Map<String, String[]> requestParams) {
		this.requestParams = requestParams;
	}
	// equalent to themedisplay.getUserId()
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	// equalent to themedisplay.getUser()
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}

	public long getScopeGroupId() {
		return scopeGroupId;
	}
	public void setScopeGroupId(long scopeGroupId) {
		this.scopeGroupId = scopeGroupId;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	// equivalent to themedisplay.getPortalUrl()
	public String getPortalUrl() {
		return portalUrl;
	}

	public void setPortalUrl(String portalUrl) {
		this.portalUrl = portalUrl;
	}

	public boolean isSignedIn() {
		return signedIn;
	}
	
	
	public String getParameter(String key){
		if(requestParams == null){
			return StringPool.BLANK;
		}
		String val[] = requestParams.get(key);
		if(val != null && val.length > 0 ){
			return val[0];
		}
		return null;
	}
	
	//similar to ParamUtil.getString
	public String getStringParameter(String key){
		if(requestParams == null){
			return StringPool.BLANK;
		}
		String val[] = requestParams.get(key);
		if(val != null && val.length > 0 ){
			return GetterUtil.getString(val[0]);
		}
		return StringPool.BLANK;
	}
	
	// similar to Paramutil.getLong(request,param)
	public long getLongParameter(String key){
		if(requestParams == null){
			return 0;
		}
		String val[] = requestParams.get(key);
		long value = 0;
		if(val != null && val.length > 0 ){
			return GetterUtil.getLong(val[0]);
		}
		return value;
	}

	public long getNodeIdReceived(){
		return getLongParameter(PEConstants.NODE_ID);
	}
	public String[] getParameterValues(String key){
		if(requestParams == null){
			return new String[]{};
		}
		return requestParams.get(key);
	}
	
	public static PERequestData getRequestData(User user,long groupId, ThemeDisplay themeDisplay){
		PERequestData requestData = new PERequestData(user,groupId,user.getCompanyId());
		requestData.setPrivateLayout(themeDisplay.getLayout().isPrivateLayout());
		requestData.setGroupName(themeDisplay.getScopeGroup().getName());
		requestData.setCurPlid(themeDisplay.getPlid());
		requestData.setSignedIn(themeDisplay.isSignedIn());
		requestData.setSignInUrl(SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay));
		requestData.setPortalUrl(SambaashUtil.getPortalURL(user.getCompanyId(), groupId));
		return requestData;
	}

	public static PERequestData getRequestData(PortletRequest portletRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		PERequestData requestData = new PERequestData(themeDisplay.getUser(),groupId,themeDisplay.getCompanyId());
		requestData.setSignedIn(themeDisplay.isSignedIn());
		requestData.setPortalUrl(themeDisplay.getPortalURL());
		requestData.setSignInUrl(SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay));
		requestData.setRequestParams(portletRequest.getParameterMap());
		requestData.setShowProcessProgress(portletRequest.getPreferences().getValue(PEConstants.SHOW_PROCESS_PROGRESS, "1"));
		requestData.setEnableTempStorageValidation(portletRequest.getPreferences().getValue(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION, "false"));
		requestData.setProgrammeCode(portletRequest.getPreferences().getValue(PEConstants.PARAM_CLASS_PK_SAVED_CODE, "0"));
		requestData.setCurPlid(themeDisplay.getPlid());
		requestData.setSupportedDevice(PEProcessHelper.supportedDevice(portletRequest));
		requestData.setPrivateLayout(themeDisplay.getLayout().isPrivateLayout());
		requestData.setGroupName(themeDisplay.getScopeGroup().getName());
		requestData.setPortletRequest(portletRequest);
		return requestData;
	}
	public static PERequestData getRequestData(PortletRequest portletRequest,User user){
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		PERequestData requestData = new PERequestData(user,groupId,themeDisplay.getCompanyId());
		requestData.setSignedIn(false);
		requestData.setPortalUrl(themeDisplay.getPortalURL());
		requestData.setSignInUrl(SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay));
		requestData.setRequestParams(portletRequest.getParameterMap());
		requestData.setShowProcessProgress(portletRequest.getPreferences().getValue(PEConstants.SHOW_PROCESS_PROGRESS, "1"));
		requestData.setEnableTempStorageValidation(portletRequest.getPreferences().getValue(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION, "false"));
		requestData.setProgrammeCode(portletRequest.getPreferences().getValue(PEConstants.PARAM_CLASS_PK_SAVED_CODE, "0"));
		requestData.setCurPlid(themeDisplay.getPlid());
		requestData.setSupportedDevice(PEProcessHelper.supportedDevice(portletRequest));
		requestData.setPrivateLayout(themeDisplay.getLayout().isPrivateLayout());
		requestData.setGroupName(themeDisplay.getScopeGroup().getName());
		return requestData;
	}
	public static PERequestData getRequestDataUsingEsignData(CourseEnrollEsignInfo esignData,PEProcessState processState) throws PortalException, SystemException {
		
		User applicant = UserLocalServiceUtil.getUser(processState.getUserIdProcess());
		
		PERequestData requestData = new PERequestData(applicant,esignData.getGroupId(),esignData.getCompanyId());
		requestData.setSignedIn(true);
		try{
			JSONObject info = JSONFactoryUtil.createJSONObject(esignData.getExtraInfo());
			requestData.setPortalUrl(info.getString(PEConstants.KEY_PORTAL_URL));
			requestData.setSignInUrl(info.getString(PEConstants.KEY_SIGNIN_URL));
		}catch(Exception ex){
			
		}
		Map<String,String[]>requestMap = new HashMap<String, String[]>();
		requestData.setRequestParams(requestMap);
		requestData.setSupportedDevice(true);
		return requestData;
	}
	
	/**
	 * Prepare request data object required for Form submission. 
	 * Useful when we dont have portletrequest object in hand.
	 * For example, an external system can register for process using resp api call. In this case, portletrequest does not exist and 
	 * form submission has to be happen.
	 * 
	 * 
	 * @param processId
	 * @param formId
	 * @param formDataInJson
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 * @throws JAXBException 
	 * @throws PEConfigException 
	 */
	public static PERequestData getRequestDataForFormSubmssion(long processId,long formId, String formDataInJson,Map<String,String[]> params) throws PortalException, SystemException, PEConfigException, JAXBException {
		return getRequestDataForFormSubmssion(processId, formId, formDataInJson, params, 0);
	}
	
	public static PERequestData getRequestDataForFormSubmssion(long processId,long formId, String formDataInJson,Map<String,String[]> params, long applicantUserId) throws PortalException, SystemException, PEConfigException, JAXBException {
		return getRequestDataForFormSubmssion(processId, formId, formDataInJson, params, applicantUserId, 0);
	}
	
	public static PERequestData getRequestDataForFormSubmssion(long processId,long formId, String formDataInJson,Map<String,String[]> params, long applicantUserId, long preDeterminedNodeId) throws PortalException, SystemException, PEConfigException, JAXBException {
		
		PEProcess  process = PEProcessLocalServiceUtil.getPEProcess(processId);
		
		User applicant;
		boolean signedIn;
		if (applicantUserId > 0) {
			applicant = UserLocalServiceUtil.getUser(applicantUserId);
			signedIn = true;
		} else {
			// Assume he is guest
			applicant = UserLocalServiceUtil.getDefaultUser(process.getCompanyId());
			signedIn = false;
		}
		PERequestData requestData = new PERequestData(applicant,process.getGroupId(),process.getCompanyId());
		requestData.setSignedIn(signedIn);
		// Getting portalurl and signin url, useful while creating url's those could be embeeded in emails
		String portalUrl = SambaashUtil.getPortalURL(process.getCompanyId(), process.getGroupId());
		requestData.setPortalUrl(portalUrl);
		requestData.setSignInUrl(portalUrl + StringPool.FORWARD_SLASH + SambaashUtil.getParameter(SambaashConstants.SIGNIN_PAGE, 0));

		// Prepare Parameter map
		Map<String,String[]>requestMap = new HashMap<String, String[]>();
		//Get the nodeId using process directory helper
		PEProcessDirectory directory = PEProcessDirectory.loadPD(processId);
		PEProcessDirectoryHelper directoryHelper = PEProcessDirectoryHelper.getPEDirectoryHelper(directory);
		// NodeId represent the node in process from where processing will start.
		long nodeId = 0;
		if (preDeterminedNodeId > 0) {
			nodeId = preDeterminedNodeId;
		} else {
			try {
				nodeId = directoryHelper.getNodeIdForFormV2(formId);
			} catch (Exception e) {
				LOG.error("Error getting Node of Form V2 "+formId);
			}
			if (nodeId==0) {
				// not Form V2, then check in Form V1 instead
				nodeId = directoryHelper.getNodeIdForForm(formId);			
			}
		}
		requestMap.put(PEConstants.NODE_ID, new String[]{String.valueOf(nodeId)});
		requestMap.put(PEConstants.PARAM_FORM_DATA_SUBMITTED, new String[]{formDataInJson});
		requestMap.put(PEConstants.PARAM_ACTION_TYPE, new String[]{PEConstantsGlobal.ACTION_SUBMIT});
		
		
		requestData.setRequestParams(requestMap);
		
		if(params != null){
			requestMap.putAll(params);
		}
		
		requestData.setSupportedDevice(true);
		return requestData;
	}

	public static PERequestData getRequestDataUsingProcessStateId(long processStateId, boolean asApplicant) throws PortalException, SystemException {
		PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);		
		User user;
		if (asApplicant) {
			user = UserLocalServiceUtil.getUser(processState.getUserIdProcess());
		} else {
			user = UserLocalServiceUtil.getUser(SambaashUtil.getAdminUserId());
		}
		
		PERequestData requestData = new PERequestData(user,processState.getGroupId(),processState.getCompanyId());
		requestData.setSignedIn(true);
		try{
			Map<String,String[]>requestMap = ConvertUtil.Json.toStringArrayMap(JSONFactoryUtil.createJSONObject(processState.getData()));
			requestData.setRequestParams(requestMap);
			requestData.setSupportedDevice(true);
			
			String portalUrl = SambaashUtil.getPortalURL(processState.getCompanyId(), processState.getGroupId());
			requestData.setPortalUrl(portalUrl);
			requestData.setSignInUrl(portalUrl + StringPool.FORWARD_SLASH + SambaashUtil.getParameter(SambaashConstants.SIGNIN_PAGE, 0));
		}catch(Exception ex) {
			LOG.error(ex);
		}
		return requestData;
	}
	
	public boolean isSupportedDevice() {
		return supportedDevice;
	}

	public void setSupportedDevice(boolean supportedDevice) {
		this.supportedDevice = supportedDevice;
	}

	public String getSignInUrl() {
		return signInUrl;
	}

	public void setSignInUrl(String signInUrl) {
		this.signInUrl = signInUrl;
	}

	public long getCurPlid() {
		return curPlid;
	}

	public void setCurPlid(long curPlid) {
		this.curPlid = curPlid;
	}

	public String getShowProcessProgress() {
		return showProcessProgress;
	}

	public void setShowProcessProgress(String showProcessProgress) {
		this.showProcessProgress = showProcessProgress;
	}
	
	public String getEnableTempStorageValidation() {
		return enableTempStorageValidation;
	}

	public void setEnableTempStorageValidation(String enableTempStorageValidation) {
		this.enableTempStorageValidation = enableTempStorageValidation;
	}

	public boolean isPrivateLayout() {
		return privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		this.privateLayout = privateLayout;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
