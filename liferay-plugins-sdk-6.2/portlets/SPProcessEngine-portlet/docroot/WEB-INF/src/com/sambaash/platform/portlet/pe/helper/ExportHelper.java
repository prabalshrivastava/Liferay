package com.sambaash.platform.portlet.pe.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.support.tomcat.loader.PortalClassLoaderFactory;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.cache.PEProcessDirectoryHelper;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExportHelper {
	
	private static final Log _log = LogFactoryUtil.getLog(ExportHelper.class);
	private static final String ENTITY_NAME_KEY = "entityName";
	private static final long  FORMID_EXTRA_INFO= -1;
	public static final int  MAX_PARTICIPANTS_TO_SHOW= 20;
	public static final Map<String, String> PARTICIPANTS_FIELD_MAP;

	private long processId;
	PEProcessDirectory directory;
	private Map<Long,Map<String,String>>formsMap;
	private ProcessStateIXSLFile file ;
	private String path;
	
	static {
		Map<String, String> tMap = new LinkedHashMap<String, String>();
		tMap.put("firstName", "First Name");
		tMap.put("lastName", "Last Name");
		tMap.put("email", "Email Address");
		tMap.put("mobile", "Mobile Number");
		tMap.put("designation", "Designation");
		PARTICIPANTS_FIELD_MAP = Collections.unmodifiableMap(tMap);
	}
	
	private ExportHelper(long processId,String path){
		this.processId = processId;
		this.path = path;
	}
    public static ExportHelper getExportHelper(long processId,String filePath){
    	return new ExportHelper(processId,filePath);
    }
	public void export(List<Document> docs) throws SystemException, JAXBException, FileNotFoundException, IOException, PEConfigException, PortalException{
	   file = ProcessStateIXSLFile.createXslFile(path);
	   _log.debug("Excel file created (not yet saved). Path " + path);

	   configure();
	   prepareHeader();
	   
	   boolean hasParticipants = docs.size()>0 && !"NA".equals(docs.get(0).get(PEConstantsGlobal.PARTICIPANT_DETAILS));
	   file.writeHeader(formsMap, hasParticipants);

	   int batchSize = 10;
	   final int size = docs.size();
	   _log.debug("BatchSize " + batchSize + " Documents size to export " + size);
	   List<Document>batch = new ArrayList<Document>();
	   for (int i = 0 ; i < size ; i++) {
		    batch.add(docs.get(i));
		    if( (i+1) % batchSize == 0){
		    	try {
		    		_log.debug("Batch No: "  + ((i+1) / batchSize)  + " Started");
					writeBatch(batch);
					_log.debug("Batch No: "  + ((i+1) / batchSize)  + " written to excel done");
				} catch (JSONException e) {
					_log.error(e);
				}
		    	batch.clear(); // clear it for next batch
		    }
	   }
	   // last set of the docs
	   writeBatch(batch);
	   file.saveFile();
	   _log.debug("File saved");
	}
	
	private void configure() throws PEConfigException, JAXBException{
		directory = PEProcessCache.getInstance().getProcessDirectory(processId);
	}
	
	private void writeBatch(List<Document>docs) throws SystemException,  JAXBException, JSONException, PEConfigException{
		_log.debug("getting process state ids");
		List<Long> processStateIds = getProcessStateIds(docs);
		_log.debug("getting audit records");
		List<PEProcessAudit> auditList = getAuditRecords(processStateIds);
		_log.debug("getting storage ids");
		List<Long>storageIds = getStorageIds(auditList);
		_log.debug("createing map: ProcessStateId and it'scoressponding storages");
		Map<Long,List<Long>> psToStorageMap = getPSStorageIdsMap(auditList);
		_log.debug("createing map: StroageId and corresponding formid");
		Map<Long,Long> storageIdtoFormIdMap = getStorageIdToFormIdMap(auditList);
		_log.debug("ApI call to form builder to get stoarges");
		//api call
		JSONArray formStorages = getFormStoragesInStrFormat(storageIds);
		
		_log.debug("creating map : Storage Id and corresponding fields");
		// storage map. key is storage id value is corresponding data
		Map<Long, Map<String,String>> storagesMap = convertToMap(formStorages);
		
		// row data. key is formId, value is corresponding data
		Map<Long,Map<String,String>> rowData;
		for(int i = 0 ; i < docs.size() ; i++){
			Document doc = docs.get(i);
			long processStateId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			_log.debug("prepareing row data for process state id " + processStateId);
			rowData = new LinkedHashMap<Long, Map<String,String>>();
			_log.debug("Creating map (formId and fields) for process state Id " + processStateId);
			List<Long>psStorageIds = psToStorageMap.get(processStateId);
			if(psStorageIds == null){
				_log.debug("Can not find the storage ids. so skipping process state id" + processStateId);
				continue;
			}
			for(Long storageId : psStorageIds){
				long formId = storageIdtoFormIdMap.get(storageId);
				rowData.put(formId, storagesMap.get(storageId));
			}
			
			Map<String,String> extraInfo  = getExtraInfo(doc);
			
			rowData.put(FORMID_EXTRA_INFO, extraInfo);
			
			_log.debug("Data is ready to write to excel for process state Id " + processStateId);
			XSSFRow currentRow = file.writeRow(rowData);
			
			// add participant details
			file.writeParticipantDetails(currentRow, doc.get(PEConstantsGlobal.PARTICIPANT_DETAILS));
			_log.debug("Data is written to excel for process state Id " + processStateId);
		}
		
	}
	
	private Map<String,String> getExtraInfo(Document doc){
		long entityId = GetterUtil.getLong(doc.get(PEConstantsGlobal.ENTITY_ID));
		long entityClassId = GetterUtil.getLong(doc.get(PEConstantsGlobal.ENTITY_CLASS_ID));
		Map<String,String>extraInf = new LinkedHashMap<String, String>();
		PEEntity entity= PEEntityHelper.getEntity(entityClassId, entityId);
		
		extraInf.put(ENTITY_NAME_KEY, entity.getName());
		
		return extraInf;
	}
	private List<Long> getProcessStateIds(List<Document> docs) {
		Document doc;
		List<Long> processStateIds = new ArrayList<Long>();
		long processStateId ;
		for (int i = 0 ; i < docs.size() ; i++) {
			doc = docs.get(i);
			processStateId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			processStateIds.add(processStateId);
		}
		return processStateIds;
	}
	
	private List<Long> getStorageIds(List<PEProcessAudit>auditList){
		// stores
		List<Long> storageIds = new ArrayList<Long>();
		for(PEProcessAudit audit : auditList){
			storageIds.add(audit.getStorageId());
		}
		return storageIds;
	}

	// method used to return Map, contains key as Process State Id, and value as corresponding storages Ids
	private Map<Long,List<Long>> getPSStorageIdsMap(List<PEProcessAudit>auditList){
		// stores storage ids of specific process state
		List<Long> psStorageIds = null;

		// Map for process state and corresponding storage ids 
		Map<Long,List<Long>> psToStorageMap = new LinkedHashMap<Long, List<Long>>();
		
		long processStateId ;
		for(PEProcessAudit audit : auditList){
			processStateId = audit.getSpPEProcessStateId();
			psStorageIds = psToStorageMap.get(processStateId); 
			if( psStorageIds == null){
				psStorageIds = new ArrayList<Long>();
				psToStorageMap.put(processStateId, psStorageIds);
			}
			psStorageIds.add(audit.getStorageId());
		}
		return psToStorageMap;
	}
	
	// method used to return Map, contains key as storage Id, and value as corresponding form Id
	private Map<Long,Long> getStorageIdToFormIdMap(List<PEProcessAudit>auditList){
		Map<Long,Long> storageIdToFormIdMap = new LinkedHashMap<Long, Long>();
		for(PEProcessAudit audit : auditList){
			storageIdToFormIdMap.put(audit.getStorageId(), GetterUtil.getLong(audit.getField2()));
		}
		return storageIdToFormIdMap;
	}
	
	
	/** method used to convert storage data in json format to Map format.
	 * 
	 * @throws JSONException 
	 
	   @Returns Map:    Key is form storage Id
	         			Value is Map of ( fieldId -> fieldValue)
	           
	*/
	private Map<Long, Map<String,String>> convertToMap(JSONArray formStorages) throws JSONException{
	//	long formId ;
		long formStorageId;
		JSONObject storage;
		JSONArray fields;
		JSONObject field;
		JSONObject content;
		int fieldsLength;
		String fieldId;
		String fieldValue;
		Map<String,String>fieldsMap;
		Map<Long,Map<String,String>> storageMap = new LinkedHashMap<Long, Map<String,String>>();
		JSONArray storageArray = formStorages;//JSONFactoryUtil.createJSONArray(formStorages);
		int length = storageArray.length();
		/**
		 * Example response format:
		 *  [ { formStorageId:1,htmlFormId:2,content: { step1 :[{id:input1,value:test},{},{}] step2:[{},{}}] } } ,
		 *    { formStorageId:2,htmlFormId:21,content: { step1 :[{},{},{}] step2:[{},{}}] }}
		 *   ]
		 * 
		 */
		for(int i = 0 ; i < length ; i++){
			storage = storageArray.getJSONObject(i);
			formStorageId =  storage.getLong(FormConstants.KEY_FORM_STORAGE_ID);
	//		formId =  storage.getLong(FormConstants.KEY_HTML_FORM_ID);
			content = JSONFactoryUtil.createJSONObject(storage.getString(FormConstants.KEY_CONTENT));
			fieldsMap = new LinkedHashMap<>(); // fieldId and its value map
			
			// Content contains multiple steps in case multi step form ( step1, step2 etc..)Ex, content: { step1 :[{},{},{}] step2:[{},{}}] }
		    Iterator<String> keys = content.keys(); 
		    int counter = 0;
		    while(keys.hasNext()){
		    	String key = keys.next();
		    	if(key.startsWith(FormConstants.KEY_STEP)){
		    		counter = counter + 1;
		    		fields = content.getJSONArray(String.format(FormConstants.KEY_STEP_FORMAT, counter));
		    		fieldsLength = fields.length();
		    		for(int j = 0; j< fieldsLength; j++){
		    			field = fields.getJSONObject(j);
		    			fieldId = field.getString(FormConstants.KEY_ID);
		    			fieldValue = StringPool.BLANK;
		    			if(field.has(FormConstants.KEY_VALUE)){
		    				fieldValue = field.getString(FormConstants.KEY_VALUE);
		    			}else if(field.has(FormConstants.KEY_OPTIONS)){
		    				fieldValue = getOptionsValue(field);
		    			}else if(field.has(FormConstants.KEY_OPTION_LIST)){
		    				fieldValue = getOptionsListValue(field);
		    			}
		    			fieldsMap.put(fieldId, fieldValue);
		    		}
		    	}
		    }
		   storageMap.put(formStorageId, fieldsMap) ;		
		}
		return storageMap;
	}
	
	private String getOptionsValue(JSONObject field){
		StringBuilder sb = new StringBuilder();
		try{
			 JSONArray options = field.getJSONArray(FormConstants.KEY_OPTIONS);
			 int length = options.length();
			 for(int i = 0; i < length ; i++){
				 JSONObject temp = options.getJSONObject(i);
				 if(sb.length() > 0){
					 sb.append(StringPool.COMMA);
				 }
				 sb.append(temp.getString(FormConstants.KEY_VALUE));
			 }
		}catch(Exception ex){
			_log.error(ex);
		}
		return sb.toString();
	}
	private String getOptionsListValue(JSONObject field){
		StringBuilder sb = new StringBuilder();
		try{
			JSONArray options = field.getJSONArray(FormConstants.KEY_OPTION_LIST);
			int length = options.length();
			for(int i = 0; i < length ; i++){
				JSONObject temp = options.getJSONObject(i);
				if(sb.length() > 0){
					sb.append(StringPool.COMMA);
				}
				sb.append(temp.getString(FormConstants.KEY_TEXT));
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		return sb.toString();
	}
	
	// returns the list of audit records for given process state ids.
	// Only form type and latest will be returned ( for example if the same form submitted multiple times then latest record will be taken)
	@SuppressWarnings("unchecked")
	private List<PEProcessAudit> getAuditRecords(List<Long> processStateIds) throws SystemException{
		if(processStateIds == null || processStateIds.size() == 0){
			return new ArrayList<PEProcessAudit>();
		}
		DynamicQuery dynamicQuery = null;
		try {
			dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
					PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID_PROCESS_STATE));
		} catch (Exception e) {
			dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
					PortalClassLoaderFactory.getClassLoader());
		}
		dynamicQuery.add(PropertyFactoryUtil.forName(PEAuditConstants.COLUMN_TYPE).eq(PEAuditConstants.TYPE_FORM));
		dynamicQuery.add(PropertyFactoryUtil.forName(PEConstants.COLUMN_PE_PROCESS_STATE_ID).in(processStateIds));
		
		List<PEProcessAudit> list = PEProcessAuditLocalServiceUtil.dynamicQuery(dynamicQuery);
		return list;
	}
	
	public void prepareHeader() throws SystemException, JAXBException, PEConfigException, PortalException{
		List<Long>formIds = getFormIds();
		String response = getFormSchemasInStr(formIds);
		formsMap = convertToMapForHeader(response);
		
		Map<String,String>extraInf = new LinkedHashMap<String, String>();

		extraInf.put(ENTITY_NAME_KEY, directory.getProcess().getEntityTitle() + " Name");
		formsMap.put(FORMID_EXTRA_INFO, extraInf);
	}


	public String getFormSchemasInStr(List<Long>formIds) throws  SystemException, JAXBException{
		
		_log.debug("API call to get form schemas for formIds " + formIds);
		return FormBuilderLocalServiceUtil.getFormSchemas(directory.getProcess().getUserId(), StringUtil.merge(formIds, StringPool.COMMA)).toString();
	}

	/**
	 * Method takes the form schema as input and converts it into map representation
	 * 
	 * @param objs
	 * @return
	 * @throws JSONException
	 */
	public Map<Long,Map<String,String>> convertToMapForHeader(String response) throws JSONException{
		long formId ;
		//JSONObject form;
		JSONArray fields;
		JSONObject field;
		int fieldsLength;
		String fieldId;
		String fieldName;
		String component;
		Map<String,String>fieldsMap;
		Map<Long,Map<String,String>> formsMap = new LinkedHashMap<Long, Map<String,String>>();
		JSONObject form ;
		JSONArray forms = JSONFactoryUtil.createJSONArray(response);
		int length = forms.length();
		for(int i = 0 ; i < length ; i++){
			form = forms.getJSONObject(i);
			formId =  GetterUtil.getLong(form.getLong(FormConstants.KEY_HTML_FORM_ID));
			fields = JSONFactoryUtil.createJSONArray(form.getString(FormConstants.KEY_HTML_FORM_SCHEMA));
		    fieldsLength = fields.length();
		    fieldsMap = new LinkedHashMap<>();
		    for(int j = 0; j< fieldsLength; j++){
		    	field = fields.getJSONObject(j);
		    	component = field.getString(FormConstants.KEY_COMPONENT);
		    	// dont process it
		    	if(FormConstants.COMPONENT_FILE_UPLOAD.equalsIgnoreCase(component)){
		    		continue;
		    	}
		    	fieldId = field.getString(FormConstants.KEY_ID);
		    	fieldName = field.getString(FormConstants.KEY_LABEL);
		    	fieldsMap.put(fieldId, fieldName);
		    }
		   formsMap.put(formId, fieldsMap) ;		
		}
		return formsMap;
		
	}
	
	public JSONArray getFormStoragesInStrFormat(List<Long> storageIds) throws  SystemException, JAXBException{
//		_log.debug("API call to get form storage for storage ids "+ storageIds );
//		//String apiUrl = "https://api.forms.sambaash.com/v1/forms/find/formStorageIdList?applicationId=13213&authToken=121&formStorageIds=" + StringUtils.join(storageIds,StringPool.COMMA);
//		String apiUrl = SambaashUtil.getParameter(SambaashConstants.API_FORM_BUILDER_GET_FORM_STORAGES, 0);
//		apiUrl = apiUrl.replace(SambaashConstants.API_URL_PARAM_PLACEHOLDER, StringUtils.join(storageIds, StringPool.COMMA));
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//		RestTemplate restTemplate = new RestTemplate();
//	//	String url = "https://api.forms.sambaash.com/v1/forms/list/formsids?applicationId=131&authToken=1231&userId=131&formIds=1079";
//		ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
//		String responseBody = response.getBody();
		return FormBuilderLocalServiceUtil.getFormStorages(StringUtil.merge(storageIds,StringPool.COMMA));
	}
	
	private List<Long> getFormIds() throws PEConfigException, JAXBException, PortalException, SystemException{
		List<Long>formIds = PEProcessDirectoryHelper.getPEDirectoryHelper(directory).getFormIds();
		return formIds;
	}
	
	
}
