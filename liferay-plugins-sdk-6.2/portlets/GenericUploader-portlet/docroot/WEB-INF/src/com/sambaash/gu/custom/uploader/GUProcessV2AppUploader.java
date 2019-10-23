package com.sambaash.gu.custom.uploader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.gu.helper.GUException;
import com.sambaash.gu.helper.GUFileHelper;
import com.sambaash.gu.helper.GUModal;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.helper.GUWBHelper;
import com.sambaash.gu.msg.GUMsgHelper;
import com.sambaash.platform.pe.v2.PESubmitAppRequestV2;
import com.sambaash.platform.pe.v2.PESubmitAppResponseV2;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;

public class GUProcessV2AppUploader extends GUCustomUploader {

	private static final String PROCESS_NAME = "processName";
	private static final String ENTITY_ID = "entityId";
	private static final String ENTITY_CLASS_NAME = "entityClassName";
	private static final String SUPRESS_MAIL_NOTIFICATIONS = "supressMailNotifications";
	private static final String MODAL_DATE_FIELD_LIST = "modalDateFieldList";
	private static final String MODAL_DATE_FORMAT = "modalDateFormat";
	private static final SimpleDateFormat FORMIO_DATE_FORMATTER = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssXXX");

	private static Log _log = LogFactoryUtil
			.getLog(GUProcessV2AppUploader.class);

	public GUProcessV2AppUploader(long companyId, long groupId,
			User logedInUser, Workbook wb, GUModal modal, GUMsgHelper msgHelper) {
		super(companyId, groupId, logedInUser, wb, modal, msgHelper);
	}

	@Override
	public void upload() {
		Map<Long, Map<String, JSONObject>> modalMap = new HashMap<>();
		Map<String, GUModal> parentModalMap = getModalMap();
		String mainSheetName = null;
		Map<String, Integer> dataKeyRowMap = new HashMap<>();
		GUField primaryField = null;
		for (Entry<String, GUModal> entry : parentModalMap.entrySet()) {
			GUModal modal = entry.getValue();
			try {
				final String sheetName = modal.getSheetName();
				if (mainSheetName == null) {
					mainSheetName = sheetName;
				}
				String formNodeId="0";
				Map<String, JSONObject> formNodeData = new HashMap<>();
				for(String nid: modal.getFormNodeId().split(",")) {
					formNodeId = nid;
					modalMap.put(Long.parseLong(formNodeId),formNodeData);				
				}

				if (Validator.isNull(sheetName)) {
					return;
				}
				final Sheet sheet = wb.getSheet(sheetName);
				final Map<String, GUField> fields = modal.getFieldsMap();
				Map<String, List<String>> arraysFields = new HashMap<String, List<String>>();
				List<String> simpleFields = new ArrayList<>();
				String primaryKeyFieldName = "";

				Row headerRow = sheet.getRow(0);
				Map<String, Integer> clmnIndexMap = GUWBHelper
						.getClmnIndexMap(headerRow);
				GUWBRowHelper rowHelper = new GUWBRowHelper(clmnIndexMap);				

				//prepare list of fields if they are normal fields or array and prepare list of objectName 
				for (Entry<String, GUField> fieldEntry : fields.entrySet()) {

					GUField field = fieldEntry.getValue();
					if (field.getArrayFieldName() != null
							&& !field.getArrayFieldName().equals("")) {
						if (arraysFields.containsKey(field.getArrayFieldName())) {
							List<String> objects = arraysFields.get(field
									.getArrayFieldName());
							objects.add(field.getFieldName());
							arraysFields
									.put(field.getArrayFieldName(), objects);
						} else {
							List<String> objects = new ArrayList<>();
							objects.add(field.getFieldName());
							arraysFields
									.put(field.getArrayFieldName(), objects);
						}
					} else {
						simpleFields.add(field.getFieldName());
					}
					if (field.isKey()) {
						primaryKeyFieldName = field.getFieldName();
					}
				}
				
				String primaryKey = "";
				// data begins in row 3
				SimpleDateFormat inputDateFormatter = null;
				List<String> dateFieldList = new ArrayList<>();
				int currSheetRow = 0;
				try {
					for (int rn = 2; rn <= (sheet.getLastRowNum() + 1); rn++) {
						currSheetRow = rn;
						if ("ProcessV2".equals(modal.getName())) {
							primaryField = modal.getField(primaryKeyFieldName);
						}
						Row row = sheet.getRow(rn);
						if (row == null || checkIfRowIsEmpty(row)) {
						     continue;
						}
							final String cellValuePrimary = rowHelper.getCellValue(row,
								primaryField);
						if (!StringUtils.isEmpty(cellValuePrimary)) {
							primaryKey = cellValuePrimary;
							if ("ProcessV2".equals(modal.getName())) {
								// will be use later for logging purposes
								dataKeyRowMap.put(primaryKey, rn);
							}						
						}
						JSONObject step1Map = JSONFactoryUtil.createJSONObject();
						
						if (inputDateFormatter==null) {
							inputDateFormatter = new SimpleDateFormat(modal.getField(MODAL_DATE_FORMAT).getDefaultValue());
							dateFieldList = Arrays.asList(modal.getField(MODAL_DATE_FIELD_LIST).getDefaultValue().split(","));
						}
	
						GUField field = null;
	
						Map<String, JSONObject> arrayMap = new HashMap<>();
						if (modalMap.containsKey(Long.parseLong(formNodeId))) {
							arrayMap = modalMap.get(Long.parseLong(formNodeId));
						}
						for (String simpleField : simpleFields) {
							field = modal.getField(simpleField);
							String cellValue = "";
							try {
								cellValue = rowHelper.getCellValue(row, field);
							} catch (Exception ex) {
								_log.error(ex);
							}
							if (!arrayMap.containsKey(primaryKey)) {
								assignFieldValue(step1Map, simpleField, cellValue, inputDateFormatter, dateFieldList);
							}
						}
	
						if (arrayMap.containsKey(primaryKey)) {
							JSONObject oldJsonObject = arrayMap.get(primaryKey);
							for (Entry<String, List<String>> fieldEntry : arraysFields
									.entrySet()) {
								if (oldJsonObject.has(fieldEntry.getKey())) {
									JSONArray oldArray = oldJsonObject
													.getJSONArray(fieldEntry.getKey());
									JSONObject aryObj = JSONFactoryUtil
											.createJSONObject();
									for (String arrayField : fieldEntry.getValue()) {
										field = modal.getField(arrayField);
										final String cellValue = rowHelper
												.getCellValue(row, field);
										if (!StringUtils.isEmpty(cellValue)) {
	//										aryObj.put(arrayField, cellValue);
											assignFieldValue(aryObj, arrayField, cellValue, inputDateFormatter, dateFieldList);
										}
									}
									if (aryObj.length() != 0) {
										oldArray.put(aryObj);
									}
									step1Map.put(fieldEntry.getKey(),
											oldArray);
								} else {
									JSONArray array = JSONFactoryUtil
											.createJSONArray();
									JSONObject aryObj = JSONFactoryUtil
											.createJSONObject();
									for (String arrayField : fieldEntry.getValue()) {
										field = modal.getField(arrayField);
										final String cellValue = rowHelper
												.getCellValue(row, field);
										if (!StringUtils.isEmpty(cellValue)) {
	//										aryObj.put(arrayField, cellValue);
											assignFieldValue(aryObj, arrayField, cellValue, inputDateFormatter, dateFieldList);
										}
									}
									if (aryObj.length() != 0) {
										array.put(aryObj);
									}
									step1Map.put(fieldEntry.getKey(),
											array);
								}
	
							}
	
						} else {
							for (Entry<String, List<String>> fieldEntry : arraysFields
									.entrySet()) {
								JSONArray array = JSONFactoryUtil.createJSONArray();
								JSONObject aryObj = JSONFactoryUtil
										.createJSONObject();
								for (String arrayField : fieldEntry.getValue()) {
									field = modal.getField(arrayField);
									final String cellValue = rowHelper
											.getCellValue(row, field);
									if (!StringUtils.isEmpty(cellValue)) {
	//									aryObj.put(arrayField, cellValue);
										assignFieldValue(aryObj, arrayField, cellValue, inputDateFormatter, dateFieldList);
									}
								}
								if (aryObj.length() != 0) {
									array.put(aryObj);
								}
								step1Map.put(fieldEntry.getKey(), array);
							}
						}
						if (!primaryKey.equals("")) {
							arrayMap.put(primaryKey, step1Map);
							modalMap.put(Long.parseLong(formNodeId), arrayMap);
						}
	
					}
				} catch (Exception parseExcp) {
					msgHelper.createError("Error while parsing the data - "+parseExcp.toString(), sheetName, currSheetRow);
					_log.error(parseExcp);
					return;
				}
			} catch (Exception ex) {
				msgHelper.createError("Error while parsing the data - "+ex.toString());
				_log.error(ex);
				return;
			}
		}
        
		PEProcess process = null;
		try {
			process = getProcess();
		} catch (SystemException e1) {
			_log.error(e1);
		}
		if (process == null) {
			msgHelper.createError("Error while getting the process ");
			return;
		}
		
		String entityIdStr = modal.getField(ENTITY_ID)
				.getDefaultValue();
		long entityId = GetterUtil.getLong(entityIdStr);
		if (entityId == 0) {
			msgHelper
					.createError("Entity does not exist in the system with id = "
							+ entityId);
			return;
		}

		String entityClass = modal.getField(ENTITY_CLASS_NAME)
				.getDefaultValue();
		long entityClassId = PortalUtil.getClassNameId(entityClass);
		if (entityClassId == 0) {
			msgHelper
					.createError("Entity class not exist in the system with name = "
							+ entityClass);
			return;
		}
		
		boolean supress = GetterUtil.getBoolean(modal.getField(SUPRESS_MAIL_NOTIFICATIONS).getDefaultValue());
		long currentNodeId = 1L;
		GUField keyField = getKeys().iterator().next();
		int currentRow = 3;
        for (Map.Entry<String, JSONObject> entry : modalMap.get(currentNodeId).entrySet()) {
        	JSONObject firstPageData = entry.getValue();
        	String dataKey = firstPageData.getString(keyField.getFieldName());
        	currentRow = dataKeyRowMap.containsKey(dataKey) ? dataKeyRowMap.get(dataKey) : 0;
       
        	Map<Long, JSONObject> formDataByNodeMap = constructFormDataByNodeMap(dataKey, modalMap);
    		PESubmitAppRequestV2 submitAppRequest = new PESubmitAppRequestV2(getRequest(), currentNodeId, logedInUser.getUserId(),process.getSpPEProcessId(), entityId, formDataByNodeMap, entityClassId);
    		submitAppRequest.setEnableSingleSubmission(process.isEnableSingleSubmission());
    		
    		submitAppRequest.setSupressMailNotifications(supress);
    		PESubmitAppResponseV2 peresponse = PEEngineLocalServiceUtil.submitApplicationV2(submitAppRequest);

    		if(peresponse == null){
    			msgHelper.createError("Error while submitting the application for "+dataKey,mainSheetName,currentRow);
    		}else if(peresponse.getErrors() != null && peresponse.getErrors().size() > 0){
    			for(String errorMsg : peresponse.getErrors()){
    				msgHelper.createError(String.format("[%s] - %s", dataKey, errorMsg),mainSheetName, currentRow);
    			}
    		}else if(peresponse.getProcessStateId() > 0){
    			successRowSet.add(currentRow);
    			msgHelper.createMsg(String.format("%s application submitted successfully. Application Id: %d", dataKey, peresponse.getProcessStateId()), mainSheetName, currentRow);
    		}            
        }
		
	}

	private void assignFieldValue(JSONObject dataObject, String dataField, String cellValue,
			SimpleDateFormat inputDateFormatter, List<String> dateFieldList) throws ParseException {
		if (dateFieldList.contains(dataField) && StringUtils.isNotEmpty(cellValue)) {					
			dataObject.put(dataField, FORMIO_DATE_FORMATTER.format(inputDateFormatter.parse(cellValue)));
		} else {
			dataObject.put(dataField, cellValue);								
		}
	}

	private Map<Long, JSONObject> constructFormDataByNodeMap(String dataKey,
			Map<Long, Map<String, JSONObject>> modalMap) {
		Map<Long, JSONObject> formDataByNodeMap = new HashMap<>();
		for (Map.Entry<Long, Map<String, JSONObject>> entry : modalMap
				.entrySet()) {
			Long nodeId = entry.getKey();
			JSONObject formData = entry.getValue().get(dataKey);
			if (formData != null) {
				formDataByNodeMap.put(nodeId, formData);
			}
		}
		return formDataByNodeMap;
	}

	private List<Long> getFileEntry(GUField field, Row row)
			throws SystemException, PortalException, GUException {
		List<Long> ids = new ArrayList<Long>();
		if (Validator.isNull(field.getSrcPath())) {
			return ids;
		}

		String cellValue = rowHelper.getCellValue(row, field);
		if (Validator.isNull(cellValue)) {
			return ids;

		}

		long sourceFolderId = GUFileHelper.getFolderId(groupId,
				field.getSrcPath(), false);
		// In case of mulitiple files.. this is added for future.. multiple
		// files not supported by PESubmitApplication
		if (cellValue.contains(StringPool.COMMA)) {
			String fileNames[] = cellValue.split(StringPool.COMMA);

			for (String fileName : fileNames) {
				fileName = fileName.trim();
				if (Validator.isNull(fileName)) {
					continue;
				}
				try {
					FileEntry fe = DLAppServiceUtil.getFileEntry(groupId,
							sourceFolderId, fileName);
					ids.add(fe.getFileEntryId());
				} catch (NoSuchFileEntryException | NoSuchFileException e) {
					msgHelper.createError("File does not exist " + fileName,
							row.getSheet().getSheetName(), row.getRowNum(),
							field.getClmnName());
					throw new GUException();
				}
			}
		} else {
			String fileName = cellValue;
			try {
				FileEntry fe = DLAppServiceUtil.getFileEntry(groupId,
						sourceFolderId, fileName);
				ids.add(fe.getFileEntryId());
			} catch (NoSuchFileEntryException | NoSuchFileException e) {
				msgHelper.createError("File does not exist " + fileName, row
						.getSheet().getSheetName(), row.getRowNum(), field
						.getClmnName());
				throw new GUException();
			}
		}
		return ids;
	}

	private PEProcess getProcess() throws SystemException {
		GUField field = modal.getField(PROCESS_NAME);
		try {
			PEProcess process = PEProcessLocalServiceUtil.findByName(field
					.getDefaultValue());
			return process;
		} catch (NoSuchPEProcessException e) {
			msgHelper.createError("Process does not exist with name "
					+ field.getDefaultValue());
		}
		return null;
	}

	@Override
	public Set<Integer> getSuccessRowSet() {
		return successRowSet;
	}
	
	private boolean checkIfRowIsEmpty(Row row) {
	    if (row == null) {
	        return true;
	    }
	    if (row.getLastCellNum() <= 0) {
	        return true;
	    }
	    for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
	        Cell cell = row.getCell(cellNum);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && StringUtils.isNotBlank(cell.toString())) {
	            return false;
	        }
	    }
	    return true;
	}

}
