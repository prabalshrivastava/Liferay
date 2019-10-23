package com.sambaash.platform.pe.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.ProcessEngine;
import com.sambaash.platform.pe.ProcessEngineImpl;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEFormV2;
import com.sambaash.platform.pe.v2.PESubmitAppRequestV2;
import com.sambaash.platform.pe.v2.PESubmitAppResponseV2;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStateUtil;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;

public class PESubmitApplicationV2 {

	private static final Log _log = LogFactoryUtil.getLog(PESubmitApplicationV2.class);
	private PESubmitAppRequestV2 submitRequest;
	private PESubmitAppResponseV2 peresponse = new PESubmitAppResponseV2();
	
	public PESubmitApplicationV2(PESubmitAppRequestV2 request){
		this.submitRequest = request;
	}
	
	public PESubmitAppResponseV2 submit() throws PortalException, SystemException, JAXBException, FileNotFoundException, PEException{
		Map<Long, JSONObject> formDataByNodeMap = submitRequest.getFormDataByNodeMap();
		
		PEProcessDirectory directory = PEProcessCache.getInstance().getProcessDirectory(submitRequest.getProcessId());
		PEFormV2 form = directory.getFirstFormV2();
		_log.error("Identified the target form from target process. Form " + form);

		Map<String,String[]>params = new LinkedHashMap<String, String[]>();
		params.put(PEConstants.PARAM_SUPPRESS_MAIL_NOTIFICATIONS, new String[]{String.valueOf(submitRequest.isSupressMailNotifications())});
		
		long currentNodeId = 1L;
		boolean exitLoop = false;
		PEProcessState processState = null;
		while (!formDataByNodeMap.isEmpty() && !exitLoop) {
			_log.error("Current Node Id => "+currentNodeId);
			form = (PEFormV2) directory.getNode(currentNodeId);
			JSONObject formDataToSubmit = formDataByNodeMap.remove(currentNodeId);

			_log.error("Preparing data to submit to process engine");		
			String formBResponse = SPDynamicFormsLocalServiceUtil.persistFormJsonData(submitRequest.getThemeDisplay(), form.getFormId(), 0L, formDataToSubmit);
			_log.error("Got form save response : "+formBResponse);
			if(Validator.isNull(formBResponse)){
				_log.error("Errors in request. So won't be submitted to process engine");
				return peresponse;
			}
			
			JSONObject obj  = JSONFactoryUtil.createJSONObject(formBResponse);
			long formStorageId = obj.getLong("formStorageId");
			_log.error("Submiting the data  to Process Engine -> " + formStorageId);
			
			if (currentNodeId==1L) {
				_log.error("Creating new process.");		
				String emailAddress = formDataToSubmit.getString("emailAddress");
				long existingApplication = getUserExistingApplication(submitRequest, emailAddress);
				if (submitRequest.isEnableSingleSubmission() && existingApplication > 0) {
					peresponse.addError("Single submission is enabled and existing application exists: "+existingApplication);
					exitLoop = true;
					continue;
				} else {
					try {
						processState = PEEngineLocalServiceUtil
								.runProcessEngineUsingFormIdWithException(
										submitRequest.getRequest(),
										submitRequest.getEntityClassId(), 
										submitRequest.getEntityId(),
										submitRequest.getProcessId(), form.getFormId(),
										formBResponse, params);
						if(processState != null && processState.getSpPEProcessStateId() > 0){
							_log.error(String.format("PE Application %d submitted for %s", processState.getSpPEProcessStateId(), emailAddress));
							peresponse.setProcessStateId(processState.getSpPEProcessStateId());			
						}else{
							_log.error("*** Error while processing submit application" );
							peresponse.addError("Error submitting application");
							exitLoop = true;
							continue;
						}
					} catch (Exception e) {
						peresponse.addError("System Error : "+e.toString());
						exitLoop = true;
						continue;
					}
				}
			} else {
				ProcessEngine processEngine = new ProcessEngineImpl();
				PERequestData requestData = PERequestData.getRequestDataForFormSubmssion(submitRequest.getProcessId(), form.getFormId(), formBResponse,params, processState.getUserIdProcess(), currentNodeId);
				PEOutput output = processEngine.executeByProcessStateId(processState.getSpPEProcessStateId(), 0L, requestData);
				if (output.errorExists()) {
					peresponse.addError(output.getError().getMsg());
					exitLoop = true;
					continue;
				} else {
					processState = output.getProcessState();			
				}
			}
			currentNodeId = processState.getNodeId();
			_log.error("Next node id => " + currentNodeId);
			exitLoop = !formDataByNodeMap.containsKey(currentNodeId);
		}
		
		
		
		return peresponse;
	}
	
	private long getUserExistingApplication(PESubmitAppRequestV2 submitRequest2, String emailAddress) {
		long applicationId = 0;
		try {
			User u = UserLocalServiceUtil.fetchUserByEmailAddress(submitRequest2.getThemeDisplay().getCompanyId(), emailAddress);
			for (PEProcessState application :PEProcessStateUtil.findByuserIdProcessPEProcessId(u.getUserId(), submitRequest2.getProcessId())) {
				if (application.getActiveStatus()==1) {
					applicationId = application.getSpPEProcessStateId();
					break;
				}
			}
		} catch (Exception e) {
			_log.error("No Existing Application: "+ e.toString());
		}
		return applicationId;
	}

	public File getLocallyStoredFile(long feId) throws PortalException, SystemException{
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(feId);;
		File file = null;
		if(fileEntry != null){
			file = PEDS.storeFileLocally(fileEntry);
		}
		return file;
	}
}
