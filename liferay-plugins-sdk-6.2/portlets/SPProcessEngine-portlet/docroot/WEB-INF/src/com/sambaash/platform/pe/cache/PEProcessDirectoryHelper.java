package com.sambaash.platform.pe.cache;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEDataMapping;
import com.sambaash.platform.pe.jaxb.PEDataMappingElement;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.jaxb.PEFormList;
import com.sambaash.platform.pe.jaxb.PEFormV2;
import com.sambaash.platform.pe.jaxb.PEFormV2List;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jaxb.PEJSPList;
import com.sambaash.platform.pe.jaxb.PEStatus;
import com.sambaash.platform.pe.jaxb.PEStatusList;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

public class PEProcessDirectoryHelper {

	private PEProcessDirectory directory;
	
	private PEProcessDirectoryHelper(PEProcessDirectory directory) {
		this.directory = directory;
	}

	public static PEProcessDirectoryHelper getPEDirectoryHelper(PEProcessDirectory directory){
		return new PEProcessDirectoryHelper(directory);
	}
	
	public List<Long> getStatusApprovers(){
		List<Long>approverRoleIds = new ArrayList<Long>();
		
		PEStatusList peStatusList = directory.getProcessDefinition().getActions().getStatuses();
		List<PEStatus> statusList = peStatusList.getList();
		StringBuilder sb = new StringBuilder();
		for (PEStatus peStatus : statusList) {
			String idsStr = peStatus.getApproverRoleIds();
			if(Validator.isNotNull(idsStr)){
				if(sb.length() > 0){
					sb.append(StringPool.COMMA);
				}
				sb.append(idsStr);
			}
		}
		
		String ids[] = sb.toString().split(StringPool.COMMA);
		for (String idStr : ids) {
			long id = GetterUtil.getLong(idStr);
			if(id > 0){
				approverRoleIds.add(id);
			}
		}
		
		return approverRoleIds;
	}
	
	public List<Long> getFormAndJspSubmitters(){
		List<Long>submitterRoleIds = new ArrayList<Long>();
		
		PEFormList peFormList = directory.getProcessDefinition().getForms();
		List<PEForm> formList = peFormList.getList();
		StringBuilder sb = new StringBuilder();
		for (PEForm peForm : formList) {
			String idsStr = peForm.getSubmitterRoleIds();
			if(Validator.isNotNull(idsStr)){
				if(sb.length() > 0){
					sb.append(StringPool.COMMA);
				}
				sb.append(idsStr);
			}
		}
		
		sb.append(StringPool.COMMA);
		
		List<PEJSP> jspList = directory.getProcessDefinition().getJsps().getList();
		for (PEJSP peForm : jspList) {
			String idsStr = peForm.getSubmitterRoleIds();
			if(Validator.isNotNull(idsStr)){
				sb.append(idsStr);
			}
		}
		
		
		String ids[] = sb.toString().split(StringPool.COMMA);
		for (String idStr : ids) {
			long id = GetterUtil.getLong(idStr);
			if(id > 0){
				submitterRoleIds.add(id);
			}
		}
		
		return submitterRoleIds;
	}
	
	public PEForm getNodeForFieldId(String fieldId){
		PEFormList formList = directory.getProcessDefinition().getForms();
		List<PEForm> forms = formList.getList();
		for (PEForm peForm : forms) {
			PEDataMapping mapping  =peForm.getDataMapping();
			List<PEDataMappingElement> list = mapping.getElmnts();
			for (PEDataMappingElement element : list) {
				if(fieldId.equals(element.getProcessFieldId())){
					return peForm;
				}
			}
		}
		//TODO:
			/*    PEJSPList jspList = directory.getProcessDefinition().getJsps();
	    List<PEJSP> jsps = jspList.getList();
	    for (PEJSP peForm : jsps) {
	    	PEDataMapping mapping  =peForm.getDataMapping();
	    	List<PEDataMappingElement> list = mapping.getElmnts();
	    	for (PEDataMappingElement element : list) {
	    		if(fieldId.equals(element.getProcessFieldId())){
	    			return peForm.getNodeId();
	    		}
	    	}
	    }*/
		return null;
	}
	
	public long getNodeIdForFieldId(String fieldId){
	   PEForm form =  getNodeForFieldId(fieldId);
	   if(form != null){
		   return form.getNodeId();
	   }
	    //TODO:
	/*    PEJSPList jspList = directory.getProcessDefinition().getJsps();
	    List<PEJSP> jsps = jspList.getList();
	    for (PEJSP peForm : jsps) {
	    	PEDataMapping mapping  =peForm.getDataMapping();
	    	List<PEDataMappingElement> list = mapping.getElmnts();
	    	for (PEDataMappingElement element : list) {
	    		if(fieldId.equals(element.getProcessFieldId())){
	    			return peForm.getNodeId();
	    		}
	    	}
	    }*/
	    return 0;
	}
	
	public String getFormFieldIdForProcessField(String fieldId){
		PEFormList formList = directory.getProcessDefinition().getForms();
		List<PEForm> forms = formList.getList();
		for (PEForm peForm : forms) {
			PEDataMapping mapping  =peForm.getDataMapping();
			List<PEDataMappingElement> list = mapping.getElmnts();
			for (PEDataMappingElement element : list) {
				if(fieldId.equals(element.getProcessFieldId())){
					return   element.getFieldId();
				}
			}
		}
		
		return StringPool.BLANK;
	}
	
	
	
	// this method returns list of form ids used in the process
	public List<Long> getFormIds() throws PortalException, SystemException{
	    PEFormList formList = directory.getProcessDefinition().getForms();
	    List<PEForm> forms = formList.getList();
	    List<Long>ids  = new ArrayList<Long>();
	    for (PEForm peForm : forms) {
	    	// TODO: change it to dynamic query
	    	long rulesetId = peForm.getRuleSetId();
	    	PERuleSet ruleset = PERuleSetLocalServiceUtil.getPERuleSet(rulesetId);
	    	ids.add(GetterUtil.getLong(ruleset.getComponentId()));
		}
		return ids;
	}
	
	public PEForm getFirstForm(){
	  PEFormList formList = directory.getProcessDefinition().getForms();
	    List<PEForm> forms = formList.getList();
	    if(forms != null && !forms.isEmpty()){
	    	return forms.get(0);
	    }
	    return null;
	}

	/**
	 *  this method used to get NodeId using formId.
	 *  
	 *  1. Get all Form nodes in the process definiton
	 *  2. Get rulesetId from each form node. 
	 *  3. Compare the componentId in ruleset object and formId argument. If matches return the corresponding nodeId
	 *  4. Return 0, if none of the form nodes pointing give formId
	 *  
	 * @param formId
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	
	public long getNodeIdForForm(long formId) throws PortalException, SystemException{
		PEFormList formList = directory.getProcessDefinition().getForms();
	    List<PEForm> forms = formList.getList();
	    for (PEForm peForm : forms) {
	    	// TODO: change it to dynamic query
	    	long rulesetId = peForm.getRuleSetId();
	    	PERuleSet ruleset = PERuleSetLocalServiceUtil.getPERuleSet(rulesetId);
	    	if(GetterUtil.getLong(ruleset.getComponentId()) == formId){
	    		return peForm.getNodeId();
	    	}
	    }
		return 0;
	}

	public long getNodeIdForFormV2(long formId) throws PEException{
		PEFormV2List formList = directory.getProcessDefinition().getFormsV2();
	    List<PEFormV2> forms = formList.getList();
	    for (PEFormV2 peForm : forms) {
	    	if(peForm.getFormId() == formId){
	    		return peForm.getNodeId();
	    	}
	    }
		return 0;
	}

	public PEFormV2 getFirstFormV2() {
		PEFormV2List formList = directory.getProcessDefinition().getFormsV2();
	    List<PEFormV2> forms = formList.getList();
	    if(forms != null && !forms.isEmpty()){
	    	return forms.get(0);
	    }
	    return null;
	}
}
