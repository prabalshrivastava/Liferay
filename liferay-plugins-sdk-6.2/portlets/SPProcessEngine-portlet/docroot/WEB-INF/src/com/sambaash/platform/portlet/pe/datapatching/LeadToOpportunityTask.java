package com.sambaash.platform.portlet.pe.datapatching;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.portlet.PortletRequest;
import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEEntityClassRegister;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.convert.PEConvertApplicationHelper;
import com.sambaash.platform.pe.convert.PEFormDS;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;

public class LeadToOpportunityTask implements Callable<Map<String,String>>{

	Map<String,String> result = new LinkedHashMap<String,String>();
	PortletRequest request;
	PEProcessState processState;
	JSONObject processConfig ;
	long targetProcessId;
	public LeadToOpportunityTask(PortletRequest request,PEProcessState processState,JSONObject processConfig,long targetProcessId ) throws JSONException {
		this.request = request;
		this.processState = processState;
		
		this.processConfig = JSONFactoryUtil.createJSONObject(processConfig.toString()) ;
		this.targetProcessId = targetProcessId;
	}
	@Override
	public Map<String,String> call() throws Exception {
		
		try {
			result.put(PEConstantsGlobal.PROCESS_STATE_ID ,String.valueOf(processState.getSpPEProcessStateId()));
			result.put(PEConstantsGlobal.PROCESS_ID ,String.valueOf(processState.getSpPEProcessId()));

			
			// Prepare Data Source
			User user = UserLocalServiceUtil.getUser(processState.getUserId());
			PERequestData requestData = PERequestData.getRequestData(request, user);
			PEDataSource dataSource ;
			try {
				dataSource = new PEDataSource(requestData,processState);
				dataSource.setSuppressMailNotifications(true);
				result.put("processName" , dataSource.getProcessName());
			} catch (PEException e) {
				_log.error(e);
				result.put("remarks", "Ignoring. Error while making datasource");
				return result;
			}
			
			// Form Data Source
			PEProcessDirectory directory = dataSource.getDirectory();
			
			
			//Filtering
			if(PEConstantsGlobal.STATUS_REJECTED.equalsIgnoreCase(processState.getStatus())){
				String str = "Ignoring. It's Rejected Applicaiton. ProcessStateId = " + processState.getSpPEProcessStateId();
				log(str );
				result.put("remarks", str);
				return result;
			}
			if(processState.getClosedStageId() > 0){
				String str = "Ignoring. It's Closed Applicaiton. ProcessStateId = " + processState.getSpPEProcessStateId();
				log(str );
				result.put("remarks", str);
				return result;
			}
			if(!PEProcessStateHelper.isActiveApplicaiton(processState)){
				String str = "Ignoring. It's Inactive Applicaiton. ProcessStateId = " + processState.getSpPEProcessStateId();
				log(str );
				result.put("remarks", str);
				return result;
			}
			
			
			//Form Data Source
			PEForm formNode = directory.getFirstForm();
			PEFormDS formDs = new PEFormDS(dataSource, formNode);
			
			if(!formDs.isValid()){
				String str = "Ignoring. Found Invalid Audit Record. So can not migrate tha applicaiton. Process State Id " + processState.getSpPEProcessStateId();
				log(str);
				result.put("remarks", str);
				return result;
			}
			
			PEProcess process = dataSource.getProcess();
			long targetEntityId = 0;
			long targetEntityClass = PEConstantsGlobal.PROCESS_DEFAULT_ENTITY;
			if(process.getName().toLowerCase().startsWith("mini")){
				try{
					PEDummyEntity targetEntity = PEDummyEntityLocalServiceUtil.getDummyEntityByName(process.getName());
					targetEntityId = targetEntity.getSpPEDummyEntityId();
				}catch(Exception ex){
					targetEntityId = 1;
				}
			}else if(process.getName().equalsIgnoreCase("Modular") || process.getName().equalsIgnoreCase("Qualification") ||
					process.getName().equalsIgnoreCase("Qualification-Entrance")){
				// For theses process continue migration only if applicant is at Register Interest step
				try{
					  PEProcessStatusType status = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(processState.getStatusTypeId());
					  if(!"Register Interest".equalsIgnoreCase(status.getStatusName())){
						  result.put("remarks", "Ignoring. User is not at Register Interest step for processStateId = " + processState.getSpPEProcessStateId());
						  return result;
					  }
					  targetEntityId = processState.getEntityId();
					  targetEntityClass = PEEntityClassRegister.getEntityClassId(Product.class.getName());
				}catch(Exception ex){
					result.put("remarks", "Ignoring. Error while checking Register Interest step for processStateId = " + processState.getSpPEProcessStateId());
					return result;
				}
			}
			
			//overriding targetProcessId with process level configuration
			JSONObject fieldsConfig = processConfig.getJSONObject("config");
			long tempTargetProcessId = processConfig.getLong("targetProcessId");
			if(tempTargetProcessId > 0){
				targetProcessId = tempTargetProcessId;
			}
			
			// add default fields - firstname, lastname and emailaddrss
			fieldsConfig = addDefaultField(fieldsConfig);
			
			// checking for targets
			if(targetProcessId < 1) {
				log("Invalid Target Process ="+targetProcessId);
				result.put("remarks", "Ignoring. Invalid Target Process Id " + targetProcessId);
				return result;
			}
			if(targetEntityId < 1) {
				log("Invalid Target Entity  =" + targetEntityId);
				result.put("remarks", "Ignoring. Invalid Entity  Id " + targetEntityId);
				return result;
			}
			// Prepare helper 
			PEConvertApplicationHelper helper = PEConvertApplicationHelper.getInstance(dataSource, formDs, fieldsConfig, targetProcessId,targetEntityClass, targetEntityId);
			try {
				PEProcessState newProcessState = helper.convert(false);
				log("Application Successfully Migrated. OldProcessStateId = " + dataSource.getProcessState().getSpPEProcessStateId() + " New Process State = " + newProcessState.getSpPEProcessStateId());
				result.put("remarks", "Migrated.");
				result.put("newProcessStateId", String.valueOf(newProcessState.getSpPEProcessStateId()));
				processState.setActiveStatus(PEConstantsGlobal.ACTIVE_STATUS_IN_ACTIVE);
				PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
			} catch (PEConfigException | FileNotFoundException
					| PEProcessStateException | JAXBException e) {
				result.put("remarks", "Ignoring. Error while migrating the applciation. " + e.getMessage());
				_log.error("Error while migrating the application. ProcessStateId = " + processState.getSpPEProcessStateId() );
				_log.error(e);
			}
		} catch (Exception e) {
			result.put("remarks", "Ignoring. Error while migrating." + e.getMessage());
			_log.error(e);
		}
		return result;
	}
	
	private void log(String msg){
		if(_log.isDebugEnabled()){
			_log.debug(msg);
		}
	}

	private JSONObject addDefaultField(JSONObject fieldsConfig){
		try {
			JSONArray fieldMap = JSONFactoryUtil.createJSONArray(fieldsConfig.getString("fieldMap"));
			
			JSONObject fn = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"firstName\", \"destField\": \"firstName\", \"type\": \"text\"}");
			JSONObject ln = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"lastName\", \"destField\": \"lastName\", \"type\": \"text\"}");
			JSONObject emailAddress = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"emailAddress\", \"destField\": \"emailAddress\", \"type\": \"text\"}");

			JSONObject countryName = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"country_name_1\", \"destField\": \"country_name_1\", \"type\": \"text\"}");
			JSONObject minisiteUrl = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"minisite_url_2\", \"destField\": \"minisite_url_2\", \"type\": \"text\"}");
			JSONObject persona = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"persona_3\", \"destField\": \"persona_3\", \"type\": \"text\"}");
			JSONObject purpose = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"purpose_4\", \"destField\": \"purpose_4\", \"type\": \"text\"}");
			JSONObject productInerest = JSONFactoryUtil.createJSONObject("{	\"srcField\": \"product_interest_5\", \"destField\": \"product_interest_5\", \"type\": \"text\"}");
			
			
			
			fieldMap.put(fn);
			fieldMap.put(ln);
			fieldMap.put(emailAddress);
			fieldMap.put(countryName);
			fieldMap.put(minisiteUrl);
			fieldMap.put(persona);
			fieldMap.put(purpose);
			fieldMap.put(productInerest);
			
			
			fieldsConfig.put("fieldMap", fieldMap);
			return fieldsConfig;
			
		} catch (JSONException e) {
			_log.error(e);
		}
		return null;
	}
	private static Log _log = LogFactoryUtil.getLog(LeadToOpportunityTask.class
			.getName());
}