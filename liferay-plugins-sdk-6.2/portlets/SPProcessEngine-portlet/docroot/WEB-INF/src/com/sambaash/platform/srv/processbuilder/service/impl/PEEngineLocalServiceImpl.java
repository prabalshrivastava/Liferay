/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.processbuilder.service.impl;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.xml.bind.JAXBException;

import com.liferay.compat.portal.kernel.util.ArrayUtil;
import com.liferay.compat.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.PESubmitAppRequest;
import com.sambaash.platform.pe.PESubmitAppResponse;
import com.sambaash.platform.pe.ProcessEngine;
import com.sambaash.platform.pe.ProcessEngineImpl;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.convert.PESubmitApplication;
import com.sambaash.platform.pe.convert.PESubmitApplicationV2;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.helpers.PEUrlHelper;
import com.sambaash.platform.pe.v2.PESubmitAppRequestV2;
import com.sambaash.platform.pe.v2.PESubmitAppResponseV2;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.PEEngineLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the p e engine local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.processbuilder.service.PEEngineLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEEngineLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil
 */
public class PEEngineLocalServiceImpl extends PEEngineLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform .srv.processbuilder.service.PEEngineLocalServiceUtil}
	 * to access the p e engine local service.
	 */

	public String getStatusString(long userIdProcess, long processId, long classNameId, long classPK)
			throws PortalException, SystemException {
		PEProcessState processState = PEProcessStateLocalServiceUtil.findByPEProcessStatePK(userIdProcess, processId,
				classPK);
		PEProcessStatusType stausType = PEProcessStatusTypeLocalServiceUtil
				.getPEProcessStatusType(processState.getStatusTypeId());
		return stausType.getStatusName()
				+ (Validator.isNotNull(processState.getStatus()) ? " - " + processState.getStatus() : StringPool.BLANK);
	}

	public String getStatusString(long processStateId) throws PortalException, SystemException {
		PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
		PEProcessStatusType stausType = PEProcessStatusTypeLocalServiceUtil
				.getPEProcessStatusType(processState.getStatusTypeId());
		return stausType.getStatusName()
				+ (Validator.isNotNull(processState.getStatus()) ? " - " + processState.getStatus() : StringPool.BLANK);
	}

	/**
	 * This method is being called by EsignNotificationServlet. It's call back
	 * servlet.After completing the contract signing, esignlive will call the
	 * servlet.
	 * 
	 */
	public void runProcessEngineUsingEsignPackagId(String packageId) throws SystemException, PortalException {
		_log.debug("Start runProcessEngineUsingEsignPackagId, packageId=" + packageId);
		CourseEnrollEsignInfo esignData = CourseEnrollEsignInfoLocalServiceUtil.findByPackageId(packageId);
		PEProcessState processState = PEProcessStateLocalServiceUtil
				.getPEProcessState(esignData.getSpPEProcessStateId());

		PERequestData requestData = PERequestData.getRequestDataUsingEsignData(esignData, processState);

		ProcessEngine processEngine = new ProcessEngineImpl();
		PEOutput output = processEngine.execute(processState, 0, requestData);

		if (output.errorExists()) {
			_log.error("Error while runProcessEngineUsingEsignPackagId.  " + output.getError().toString());
		}
		_log.debug("End runProcessEngineUsingEsignPackagId, packageId=" + packageId);

		return;

	}

	public PEProcessState runProcessEngineUsingFormId(long entityClassId,long classPK, long processId, long formId, String formData,Map<String,String[]> params) {
		
		_log.debug("Start runProcessEngineUsingFormId entityClassId=" + entityClassId + " classPK=" + classPK + "processId=" + processId + "formId=" + formId + "formData=" + formData);
		
		try {
			PERequestData requestData = PERequestData.getRequestDataForFormSubmssion(processId, formId, formData,params);
			ProcessEngine engine = new ProcessEngineImpl();
			PEOutput output = engine.executeByEntityIdProcessId(entityClassId,classPK, processId, PEConstants.DEFAULT_STATUS_TYPE_ID,
					requestData);
			if (output.getError()!=null) {
				_log.error("Error in runProcessEngineUsingFormId: "+output.getError().toString());
			}
			return output.getProcessState();
		} catch (PortalException | SystemException | PEConfigException | JAXBException e) {
			_log.error(e);
		}
		
		_log.debug("End runProcessEngineUsingFormId entityClassId=" + entityClassId + " classPK=" + classPK + "processId=" + processId + "formId=" + formId + "formData=" + formData);
		
		
		return null;
		
	}

	public PEProcessState runProcessEngineUsingFormIdWithException(PortletRequest portletRequest, long entityClassId,long classPK, long processId, long formId, String formData,Map<String,String[]> params) throws Exception {
		try {
			PERequestData requestData = PERequestData.getRequestDataForFormSubmssion(processId, formId, formData,params);
			requestData.setPortletRequest(portletRequest);
			ProcessEngine engine = new ProcessEngineImpl();
			PEOutput output = engine.executeByEntityIdProcessId(entityClassId,classPK, processId, PEConstants.DEFAULT_STATUS_TYPE_ID,
					requestData);
			if (output.getError()!=null) {
				_log.error("Error in runProcessEngineUsingFormIdWithException: "+output.getError().toString());
				throw new Exception(output.getError().toString());
			}
			return output.getProcessState();
		} catch (PortalException | SystemException | PEConfigException | JAXBException e) {
			_log.error(e);
			throw new Exception(e);
		}
	}
	
	public void runProcessEngineProductApp(long entityClassId,long classPK, long processId, long formId, String countryName,
			String formData) {

		_log.debug("Call received to process engine classpk=" + classPK + " processId=" + processId + " formId="
					+ formId + " countryName=" + countryName + " formData=" + formData);
		

		Map<String,String[]> params = new LinkedHashMap<>();
		params.put("paramName_Country", new String[]{countryName});
		PEProcessState processState = runProcessEngineUsingFormId(entityClassId,classPK, processId, formId, formData,params);

		// report process execution error for manual investigation if any
		if (Validator.isNotNull(processState) && Validator.isNotNull(processState.getLastErrorCode())) {
			reportError("Process Execution Error", classPK, processId, formId, countryName, formData, processState);
		}
		//assignSupervisor(countryName, processState);
	}
	
	public PESubmitAppResponse submitApplciaiton(PESubmitAppRequest submitAppRequest){
		PESubmitAppResponse response = null;
		try {
			  PESubmitApplication submitApplication = new PESubmitApplication(submitAppRequest);
			  response = submitApplication.submit();
		} catch (Exception e) {
			_log.error(e);
		}
		
		if(response == null){
			response = new PESubmitAppResponse();
			response.addError("Error while processing the application");
		}
		return response;
	}
	
	public PESubmitAppResponseV2 submitApplicationV2(PESubmitAppRequestV2 request) {
		PESubmitAppResponseV2 response = null;
		
		try {
			  PESubmitApplicationV2 submitApplication = new PESubmitApplicationV2(request);
			  response = submitApplication.submit();
		} catch (Exception e) {
			_log.error(e);
		}

		if(response == null){
			response = new PESubmitAppResponseV2();
			response.addError("Error while processing the application");
		}
		return response;
	}

	private void assignSupervisor(String entityName, PEProcessState processState) {
		boolean assigned = false;
		long supervisorId = 0L;
		if (processState != null) {
			try {

				// TODO: This is a temporary logic. Process builder needs to be
				// enhanced to cover these
				// scenarios to pick supervisor based on the key defined in each
				// process .
				try {
					JSONObject dataJ = JSONFactoryUtil.createJSONObject(GetterUtil.getString(processState.getData()));

					String district = dataJ.getString("districtName");
					String careerAdvisory = dataJ.getString("career_advisory");
					String employers = dataJ.getString("employers");
					String ictMentor = dataJ.getString("ict_mentor");
					String trainingAdvisory = dataJ.getString("training_advisory");

					if (Validator.isNotNull(district)) {
						entityName = district;
					} else if (Validator.isNotNull(careerAdvisory)) {
						entityName = careerAdvisory;
					} else if (Validator.isNotNull(employers)) {
						entityName = employers;
					} else if (Validator.isNotNull(ictMentor)) {
						entityName = ictMentor;
					} else if (Validator.isNotNull(trainingAdvisory)) {
						entityName = trainingAdvisory;
					}

				} catch (Exception e) {
					_log.error("Failed to parse data map.");
				}

				// Till here.

				supervisorId = ProductSupervisorLocalServiceUtil.getSupervisor(entityName, 0, 0);
				if (supervisorId > 0) {

					_log.error(" entityName : " + entityName + " : supervisorId : " + supervisorId);
					
					processState.setUserIdSupervisor(supervisorId);
					processState = PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
					assigned = true;
					try {
						Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(PEProcessState.class.getName());
						indexer.reindex(processState);
					} catch (Exception e) {
						_log.error("Failed to reindex after assigning supervisorId");
					}
				}
			} catch (SystemException e) {
				_log.error("Error while getting supervisor Id entityName = " + entityName);
			}
		}

		// report assignment error
		if (!assigned) {
			reportError("Failed to assign supervisor", 0, 0, 0, entityName, StringPool.BLANK, processState);
		}

	}

	private void reportError(String subject, long classPK, long processId, long formId, String countryName,
			String formData, PEProcessState processState) {

		StringBuilder msg = new StringBuilder(Calendar.getInstance().getTime().toString());
		msg.append(StringPool.NEW_LINE);
		try {

			// add passed parameters
			msg.append(" : classPK : ").append(classPK).append(StringPool.NEW_LINE).append(" : processId : ")
					.append(processId).append(StringPool.NEW_LINE).append(" : formId : ").append(formId)
					.append(StringPool.NEW_LINE).append(" : countryName : ").append(countryName)
					.append(StringPool.NEW_LINE).append(" : formData : ").append(formData).append(StringPool.NEW_LINE);

			// add execution parameters
			if (Validator.isNotNull(processState) && Validator.isNotNull(processState.getLastErrorCode())) {
				if (Validator.isNotNull(processState.getSpPEProcessId())) {
					msg.append("Process Id : ").append(String.valueOf(processState.getSpPEProcessId()))
							.append(StringPool.NEW_LINE);
				}

				if (Validator.isNotNull(processState.getSpPEProcessStateId())) {
					msg.append(("Process State Id : ")).append(processState.getSpPEProcessStateId())
							.append(StringPool.NEW_LINE);
				}

				msg.append(processState.getLastErrorDate().toString()).append(StringPool.NEW_LINE)
						.append(processState.getLastErrorCode()).append(StringPool.NEW_LINE)
						.append(processState.getLastErrorMsg()).append(StringPool.NEW_LINE);
			}
		} catch (Exception e) {
		}

		SambaashUtil.notifySystemAdmin(subject, msg.toString());

	}
	
	public long getFirstFormIdToLoad(long processId){
		long formId = 0;
		try {
			formId = PEProcessCache.getInstance().getProcessDirectory(processId).getFirstForm().getFormId();
		} catch (PortalException | SystemException | PEConfigException
				| JAXBException e) {
			_log.error(e);
		}
		return formId;
	}
	
	
	public boolean isAgent(User user, long processId) {
		boolean isAgent = false;
		try {

			PEProcess peProcess = PEProcessLocalServiceUtil
					.getPEProcess(processId);
			isAgent = PEProcessHelper.isAgent(user, peProcess);

		} catch (Exception e) {
			_log.error(e);
		}

		return isAgent;
	}

	public boolean isSupervisor(User user, long processId) {
		boolean isSupervisor = false;
		try {

			PEProcess peProcess = PEProcessLocalServiceUtil
					.getPEProcess(processId);
			isSupervisor = PEProcessHelper.isSupervisor(user, peProcess);

		} catch (Exception e) {
			_log.error(e);
		}

		return isSupervisor;
	}

	public String addExtraParamsToFormUrl(boolean isSignedIn, User user, long processId,String urlLoadForm) {
		try {
			boolean isAgent = isAgent(user, processId);
			boolean isSupervisor = isSupervisor(user,
					processId);
			if (isSignedIn && !isAgent && !isSupervisor) {
				urlLoadForm = HttpUtil.addParameter(urlLoadForm, "firstName",user.getFirstName());
				urlLoadForm = HttpUtil.addParameter(urlLoadForm, "lastName",user.getLastName());
				urlLoadForm = HttpUtil.addParameter(urlLoadForm,"emailAddress",user.getEmailAddress());
			}
		} catch (Exception e) {
			_log.error(e);
		}

		String decodedUrl = HttpUtil.decodeURL(urlLoadForm);
		
		return decodedUrl;

	}

	public long[] getNonDealStageIds(){
		String idsStr = SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_NON_DEAL_STAGE_IDS,0);
		String idsArr [] = idsStr.split(StringPool.COMMA);
		long ids[] = toLong(idsArr);
		return ids;
	}
	public long[] getDealStageIds(){
		long wonId = GetterUtil.getLong(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_CLOSED_WON_STAGE_ID,0));
		long lostId = GetterUtil.getLong(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_CLOSED_LOST_STAGE_ID,0));
		long ids[] = {wonId,lostId};
		return ids;
	}
	
	public long getLeadProcessId(){
		long leadProcessId = GetterUtil.getLong(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_LEAD_PROCESS_ID, 0));
		return leadProcessId;
	}
	public long[] getOpportunityProcessIds(){
		String idsStr = SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_OPPORTUNITY_PROCESS_IDS,0);
		String idsArr [] = idsStr.split(StringPool.COMMA);
		long ids[] = toLong(idsArr);
		return ids;
	}
	
	public long[] toLong(String strArr[]){
		long ids[] = new long[strArr.length];
		int j = 0;
		for(int i = 0 ; i < ids.length; i++){
			long id = GetterUtil.getLong(strArr[i]);
			if(id > 0){
				ids[j++] = id;
			}
		}
		ids = ArrayUtil.subset(ids, 0, j);
		return ids;
	}
	
	public boolean isOpenApplication(PEProcessState processState){
		return  PEProcessStateHelper.isOpenApplication(processState);
	}
	
	
	public boolean isRejectedApplicaiton(PEProcessState processState){
		return PEProcessStateHelper.isRejectedApplicaiton(processState);
	}
	
	public boolean isActiveApplicaiton(PEProcessState processState){
		return PEProcessStateHelper.isActiveApplicaiton(processState);
	}
	
	public boolean isConvertedToOtherApplication(PEProcessState processState){
		return PEProcessStateHelper.isConvertedToOtherApplication(processState);
	}
	
	public String getApplicationDisplayUrl(User loggedInUser,long processStateId, ThemeDisplay themedisplay){
		try {
				PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
				PERequestData requestData  = PERequestData.getRequestData(loggedInUser, processState.getGroupId(), themedisplay);
				PEDataSource ds = new PEDataSource(requestData,processState);
				PEUrlHelper helper = PEUrlHelper.getUrlHelper(ds);
				return helper.getApplicationDisplayUrl();
			
		} catch (Exception e) {
			_log.error("Error While generating the url", e);
		}
		return StringPool.BLANK;
	}
	
	public String getApplicationDisplayFriendlyUrl(User loggedInUser,long processStateId, ThemeDisplay themeDisplay){
		try {
				PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
				PERequestData requestData  = PERequestData.getRequestData(loggedInUser, processState.getGroupId(), themeDisplay);
				PEDataSource ds = new PEDataSource(requestData,processState);
				PEUrlHelper helper = PEUrlHelper.getUrlHelper(ds);
				return helper.getApplicationDisplayFriendlyUrl();
			
		} catch (Exception e) {
			_log.error("Error While generating the url", e);
		}
		return StringPool.BLANK;
	}
	
	public PEEntity getPeEntity(long classNameId, long classPk){
		return PEEntityHelper.getEntity(classNameId, classPk);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PEEngineLocalServiceImpl.class);
}