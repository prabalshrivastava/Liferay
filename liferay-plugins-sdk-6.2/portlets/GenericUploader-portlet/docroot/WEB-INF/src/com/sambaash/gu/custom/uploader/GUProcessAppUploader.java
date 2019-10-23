package com.sambaash.gu.custom.uploader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.gu.helper.GUConstants;
import com.sambaash.gu.helper.GUException;
import com.sambaash.gu.helper.GUFileHelper;
import com.sambaash.gu.helper.GUModal;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.helper.GUUploadHelper;
import com.sambaash.gu.helper.GUWBHelper;
import com.sambaash.gu.msg.GUMsgHelper;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEFormField;
import com.sambaash.platform.pe.PESubmitAppRequest;
import com.sambaash.platform.pe.PESubmitAppResponse;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;

public class GUProcessAppUploader extends GUCustomUploader{
	
	private static final String PROCESS_NAME = "processName";
	private static final String ENTITY_ID = "entityId";
	private static final String ENTITY_CLASS_NAME = "entityClassName";
	private static final String SUPRESS_MAIL_NOTIFICATIONS = "supressMailNotifications";


	private static Log _log = LogFactoryUtil.getLog(GUProcessAppUploader.class);

	public GUProcessAppUploader(long companyId, long groupId, User logedInUser,
			Workbook wb, GUModal modal, GUMsgHelper msgHelper) {
		super(companyId, groupId, logedInUser, wb, modal, msgHelper);
	}

	@Override
	public void upload() {
		final String sheetName = modal.getSheetName();
		if(Validator.isNull(sheetName)){
			return;
		}
		final Sheet sheet = wb.getSheet(sheetName);
		final Map<String, GUField> fields = modal.getFieldsMap();
		PEProcess process = null;
		try {
			process = getProcess();
		} catch (SystemException e1) {
			_log.error(e1);
			msgHelper.createError("Error while getting the process ");
			return ;
		}
		
		outer:for(int rn = 2 ; rn <= sheet.getLastRowNum(); rn++){
			Row row = sheet.getRow(rn);
			if(GUWBHelper.isRowEmpty(row)) {
				//msgHelper.createMsg("Empty row. Ignoring the row " ,sheetName,rn);
				continue;
			}
			GUField field = null;
			try {
				field = modal.getField(ENTITY_ID);
				String entityIdStr = rowHelper.getCellValue(row, field);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(field.getClmnName())));
				long entityId = GetterUtil.getLong(entityIdStr);
				if(entityId == 0){
					msgHelper.createError("Entity does not exist in the system with id = " + entityId,sheetName,row.getRowNum() ,field.getClmnName() );
					continue;
				}
				
				field = modal.getField(ENTITY_CLASS_NAME);
				String entityClass = rowHelper.getCellValue(row, field);
				long entityClassId = PortalUtil.getClassNameId(entityClass);
				if(entityClassId == 0){
					msgHelper.createError("Entity class not exist in the system with name = " + entityClass,sheetName,row.getRowNum() ,field.getClmnName() );
					continue;
				}
				
				try {
					PEEntity peEntity = PEEngineLocalServiceUtil.getPeEntity(entityClassId, entityId);
					if(peEntity == null){
						throw new Exception();
					}
				} catch (Exception e) {
					msgHelper.createError("Invalid entity Id or Entity class id. " , sheetName,row.getRowNum() );
					continue;
				}
				
				Map<String,PEFormField> formFields = new LinkedHashMap<String, PEFormField>();
				for (Entry<String,GUField> fieldEntry : fields.entrySet()) {
					field = fieldEntry.getValue();
					final String fieldName = field.getFieldName();
					final String cellValue =  rowHelper.getCellValue(row, field);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(field.getClmnName())));
					
					PEFormField formField = new PEFormField(field.getFieldName());
					
					if(GUUploadHelper.isFile_Folder_type(field.getDocumentType())){
						try {
							  List<Long> ids = getFileEntry(field, row);
							  for (Long id : ids) {
								formField.addValue(String.valueOf(id));
							}
						} catch (GUException e) {
							continue outer;
						}
					}else{
						if(cellValue.indexOf(GUConstants.CELL_VALUE_SEPARATOR) == -1){
							formField.addValue(cellValue);
						}else{
							String values[] = cellValue.split(GUConstants.CELL_VALUE_SEPARATOR_ESCAPED);
							formField.addAllValues(values);
						}
					}
					
					formFields.put(fieldName, formField);
				}
				GUField fieldSupressMails = modal.getField(SUPRESS_MAIL_NOTIFICATIONS);
				boolean supress = GetterUtil.getBoolean(rowHelper.getCellValue(row, fieldSupressMails));
				
				PESubmitAppRequest submitAppRequest = new PESubmitAppRequest(logedInUser.getUserId(), process.getSpPEProcessId(), entityId, formFields, entityClassId);
				submitAppRequest.setSupressMailNotifications(supress);
				PESubmitAppResponse peresponse = PEEngineLocalServiceUtil.submitApplciaiton(submitAppRequest);

				if(peresponse == null){
					msgHelper.createError("Error while submitting the application",sheetName,row.getRowNum());
				}else if(peresponse.getProcessStateId() > 0){
					successRowSet.add(row.getRowNum());
					msgHelper.createMsg("Application submitted successfully. Application Id : " + peresponse.getProcessStateId() ,sheetName,row.getRowNum());
				}else if(peresponse.getErrors() != null && peresponse.getErrors().size() > 0){
					for(String errorMsg : peresponse.getErrors()){
						msgHelper.createError(errorMsg,sheetName,row.getRowNum());
					}
				}
				
			} catch (Exception e) {
				_log.error(e);
				msgHelper.createError("Error while processing row",sheetName,row.getRowNum() ,field != null ? field.getClmnName() : "");
			}
		}
	}
	
	private List<Long> getFileEntry(GUField field,Row row) throws SystemException, PortalException, GUException{
		List<Long>ids = new ArrayList<Long>(); 
		if(Validator.isNull(field.getSrcPath())){
			return ids;
		}

		String cellValue = rowHelper.getCellValue(row, field);
		if(Validator.isNull(cellValue)){
			return ids;
			
		}

		long sourceFolderId = GUFileHelper.getFolderId(groupId, field.getSrcPath(), false);
		// In case of mulitiple files.. this is added for future.. multiple files not supported by PESubmitApplication
		if(cellValue.contains(StringPool.COMMA)){
			String fileNames[] = cellValue.split(StringPool.COMMA);
			
			for (String fileName : fileNames) {
				fileName = fileName.trim();
				if(Validator.isNull(fileName)){
					continue;
				}
				try {
					 FileEntry fe = DLAppServiceUtil.getFileEntry(groupId, sourceFolderId,fileName);
					 ids.add(fe.getFileEntryId());
				} catch (NoSuchFileEntryException | NoSuchFileException e) {
					msgHelper.createError("File does not exist " + fileName, row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());
					throw new GUException();
				}
			}
		}else{
			String fileName = cellValue;
			try {
				 FileEntry fe = DLAppServiceUtil.getFileEntry(groupId, sourceFolderId,fileName);
				 ids.add(fe.getFileEntryId());
			} catch (NoSuchFileEntryException | NoSuchFileException e) {
				msgHelper.createError("File does not exist " + fileName, row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());
				throw new GUException();
			}
		}
		return ids;
	}
	private PEProcess getProcess() throws  SystemException{
		GUField field = modal.getField(PROCESS_NAME);
		try {
			PEProcess process = PEProcessLocalServiceUtil.findByName(field.getDefaultValue());
			return process;
		} catch (NoSuchPEProcessException e) {
			msgHelper.createError("Process does not exist with name " + field.getDefaultValue());
		}
		return null;
	}
	
	private long getEntityId(long entityClassId,String entityName) throws PortalException, SystemException{
		ClassName cname = ClassNameLocalServiceUtil.getClassName(entityClassId);
		if(cname.getClassName().equalsIgnoreCase(PEDummyEntity.class.getName())){
			PEDummyEntity de = PEDummyEntityLocalServiceUtil.getDummyEntityByName(entityName);
			return de.getSpPEDummyEntityId();
		}
		return 0;
	}

	@Override
	public Set<Integer> getSuccessRowSet() {
		return successRowSet;
	}

	public boolean validate(){
		boolean valid = true;
		Sheet sheet = wb.getSheet(modal.getSheetName());
		Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(sheet.getRow(0));

		// Verify if Process Column column exists
		GUField fieldProcess = modal.getField(PROCESS_NAME);
		if(Validator.isNull(fieldProcess)){
			valid = false;
			msgHelper.createError("Required field is missing :" + PROCESS_NAME , GUConstants.SHEET_META_DATA);
		}else{
			if(Validator.isNull(fieldProcess.getDefaultValue())){
				valid = false;
				msgHelper.createError("Process Name is required under Default Value column " , modal.getSheetName());
			}else{
				try {
					PEProcess process = getProcess();
				} catch (Exception e1) {
					_log.error(e1);
					valid = false;
					msgHelper.createError("Error while getting the process ");
				}
			}
		}
		
		GUField fieldEntity = modal.getField(ENTITY_ID);
		if(Validator.isNull(fieldEntity)){
			valid = false;
			msgHelper.createError("Required field is missing :" + ENTITY_ID , GUConstants.SHEET_META_DATA);
		}else{
			String clmnName = fieldEntity.getClmnName();
			if(clmnIndexMap.get(clmnName) == null){
				valid = false;
				msgHelper.createError("Column for Entity Name does not exist." , modal.getSheetName(),0, fieldProcess.getClmnName());
			}
		}
		GUField fieldEntityClass = modal.getField(ENTITY_CLASS_NAME);
		if(Validator.isNull(fieldEntityClass)){
			valid = false;
			msgHelper.createError("Required field is missing :" + ENTITY_CLASS_NAME , GUConstants.SHEET_META_DATA);
		}else{
			// Entity name mostly will have default value
		}
		return valid;
	}
	
}
