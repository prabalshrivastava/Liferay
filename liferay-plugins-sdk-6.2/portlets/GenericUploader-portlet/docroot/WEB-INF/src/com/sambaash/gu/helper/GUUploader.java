package com.sambaash.gu.helper;


import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ResourceRequest;

import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.compat.portal.kernel.util.ArrayUtil;
import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.sambaash.gu.custom.uploader.GUCustomUploader;
import com.sambaash.gu.custom.uploader.GUCustomUploaderHelper;
import com.sambaash.gu.custom.uploader.GUWBRowHelper;
import static com.sambaash.gu.helper.GUConstants.*;
import com.sambaash.gu.helper.GUEntityHelper.GUDBEntity;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.msg.GUMsgHelper;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;
import com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class GUUploader {
	
	private static Log _log = LogFactoryUtil.getLog(GUUploader.class);
		
	// Modal name and Modal keys 
	private Map<String, Set<GUField>> modalKeys = new LinkedHashMap<String, Set<GUField>>();

	// Modal name and Modal 
	private Map<String, GUModal> modalMap = new LinkedHashMap<String, GUModal>();
	
	//Meta Data Column name and its index
	private Map<String, Integer>mdClmnNameIndexMap ;
	
	private Map<String,Set<Integer>> successRows = new LinkedHashMap<String, Set<Integer>>();

	
	File file;
	Workbook wb = null;
	private final long groupId ;
	private final long companyId ;
	private final User logedInUser;
	private final GUUploadLog uploadLog;
	private final GUMsgHelper msgHelper;
	private final GUUploadHelper uploadHelper;
	private GUCustomUploaderHelper customUploaderHelper;
	private final GUUploadLogHelper uploadLogHelper;
	private ResourceRequest request;
	
	public GUUploader(File file,User logedInUser,long companyId,long groupId) throws SystemException{
		this.file = file;
		this.logedInUser = logedInUser;
		this.companyId = companyId;
		this.groupId = groupId;
		
		this.uploadLog = GUUploadLogLocalServiceUtil.create();
		uploadLog.setStatus(STATUS_YET_TO_START);
		GUUploadLogLocalServiceUtil.updateGUUploadLog(uploadLog);

		this.msgHelper = new GUMsgHelper(uploadLog);
		this.uploadHelper = new GUUploadHelper(companyId, groupId, logedInUser);
		this.uploadLogHelper = new GUUploadLogHelper(companyId, groupId, logedInUser, uploadLog);
		
		//TODO: Upload the uploaded file to doc-lib
	}
	
	public GUUploadLog getUploadLog(){
		return uploadLog;
	}
	
	public void run(){
		uploadLog.setStatus(STATUS_STARTED);
		uploadLog.setStartTime(new Date());
		try {
			upload();
		} catch (Exception e) {
			_log.error(e);
		}
		uploadLog.setEndTime(new Date());
		try {
			GUUploadLogLocalServiceUtil.updateGUUploadLog(uploadLog);			
		} catch (Exception e) {
			_log.error("Error saving upload log.",e);
		}
	}
	
	public void upload(){
		try {
			// requires for file uploads
			initializePermissionChecker();
		} catch (Exception e1) {
			msgHelper.createError("System error. Error while initializing permision checker");
			return;
		}
		try {
			parseMetaData();
		} catch (Exception e) {
			_log.error(e);
			uploadLog.setStatus(STATUS_STOPED_META_DATA_ERROR);
			return;
		}
		
		if(uploadLog.getErrorCount() > 0){
			uploadLog.setStatus(STATUS_STOPED_META_DATA_ERROR);
			return;
		}
		
		try {
			processUpload();
		} catch (Exception e) {
			_log.error(e);
			uploadLog.setStatus(STATUS_STOPED_ERROR_IN_PROCESSING);
			return;
		}
		try {
			uploadLogHelper.saveUploadedFile(file);
		} catch (Exception e) {
			_log.error(e);
		}
		
		if(uploadLog.getErrorCount() > 0){
			try {
				uploadLogHelper.saveErrorFile(wb, successRows,file.getName());
			} catch (Exception e) {
				_log.error(e);
			}
		}
		
		if(uploadLog.getErrorCount() > 0){
			uploadLog.setStatus(STATUS_COMPLETED_WITH_ERRORS);
		}else{
			uploadLog.setStatus(STATUS_COMPLETED);
		}
	}
	public  void initializePermissionChecker() throws Exception {
		PrincipalThreadLocal.setName(logedInUser.getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(logedInUser);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
	}

	private void processUpload(){
		uploadLog.setStatus(STATUS_IN_PROGRESS);
		GUFileHelper fileHelper = new GUFileHelper(groupId, msgHelper);
		
		for(Entry<String, GUModal> entry: modalMap.entrySet()){
			GUModal modal = entry.getValue();
			String sheetName = modal.getSheetName();
			if(Validator.isNull(sheetName)){
				continue;
			}
			if (modal.getName().contains(MODAL_NAME_SEPARATOR) && "ProcessV2".equals(modal.getName().split(MODAL_NAME_SEPARATOR)[0])) {
				// unlike other sub sections, like StartupProfile, wherein each section is just an update or insert to a new table, ProcessV2 sections are actually form data to be submitted for the next step
				// do not process sub sections of ProcessV2 modal, as they are steps in the process and should be handled by the custom uploader
				
				// not needed in error log anymore
				Sheet toBeDeleted = wb.getSheet(modal.getName().split(MODAL_NAME_SEPARATOR)[1]);
				wb.removeSheetAt(wb.getSheetIndex(toBeDeleted));
				continue;
			}

			// Check if custom uploader exists
			try {
				String modalName = entry.getKey();
				GUCustomUploader customUploader = customUploaderHelper.getUploader(modalName, entry.getValue());
				if(customUploader != null && customUploader.isCustomUpload()){
					setOtherOptionalCustomUploaderDetails(modalName, customUploader, modalMap, mdClmnNameIndexMap);
					customUploader.upload();
					Set<Integer>successRowSet = customUploader.getSuccessRowSet();
					successRows.put(sheetName, successRowSet);
					if ("ProcessV2".equals(modalName)) {
						uploadLog.setSuccessCount(successRowSet.size());
					}
					customUploader.afterUpload();
					continue;
				}
			} catch (Exception e) {
				_log.error(e);
				msgHelper.createError("Error while uploading data for modal :" + modal.getName(),sheetName);
				continue;
			}
			Sheet sheet = wb.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(headerRow);
			GUWBRowHelper rowHelper = new GUWBRowHelper(clmnIndexMap);
			Map<String, GUField> fields = modal.getFieldsMap();
			// Used to hold the id's  of linked models whose multi instances got deleted 
			Map<Long, Long>processedLMIds = new LinkedHashMap<Long, Long>();
			GUEntityHelper entityHelper = new GUEntityHelper();

			GUField multiInstanceField = null;
			// Finding if configuration enabled for deleting  multi instance records 
			for (Entry<String,GUField> fieldEntry : fields.entrySet()) {
				GUField field = fieldEntry.getValue();
				if(Validator.isNotNull(field.getLinkedModal()) && field.isMultiInstance() && field.isDeleteCreateMultiInstance()){
					multiInstanceField = field;
					break;
				}
			}
			
			// row 0 - header
			// row 1 - help text
			// row 2 - onwards data
			outer:for(int rn = 2 ; rn <= sheet.getLastRowNum(); rn++){
				Row row = sheet.getRow(rn);
				if(GUWBHelper.isRowEmpty(row)){
					//msgHelper.createMsg("Empty row. Ignoring the row " ,sheetName,rn);
					continue;
				}
				// Used to keep asset categoires associated with record.These entries will be stored AssetEntry table
				Set<Long>assetCatgs = null;
				boolean error = false;
				GUField field = null;
				try {
					//Curent modal is multiinstance type and user configured it to delete and recreate
					if(multiInstanceField != null){
						try {
							Long fkey = getLinkedModalPropertyValue(multiInstanceField,sheetName,row,rowHelper);
							if(processedLMIds.get(fkey) == null){
								deleteMultiInstanceRecords(multiInstanceField, fkey);
							}
							processedLMIds.put(fkey, fkey);
						}catch(GUInvalidDataException e1){
							_log.error(e1);
							msgHelper.createError("Invalid data.",sheetName,row.getRowNum() );
							continue;
						}catch (Exception e) {
							_log.error(e);
							msgHelper.createError("Error while deleting multi-instance records",sheetName,row.getRowNum() );
							continue;
						}
						
					}
					
					boolean isNew = false;
					Object dbObj = null;
					try {
						 dbObj = getDBObjectUsingKeys(modal.getName(), row, rowHelper,0);
					}catch(GUException e1){
						_log.error(e1);
						msgHelper.createError(e1.getMsg(),sheetName,row.getRowNum() );
						continue;
					}catch (Exception e) {
						_log.error(e);
						msgHelper.createError("System error while trying to retrieve record",sheetName,row.getRowNum() );
						continue;
					}
					if(dbObj == null){
						_log.debug("Record does not exist in db.So create will be invoked.RowNum="+ row.getRowNum()  + " SheetName = " + sheetName);
						dbObj = entityHelper.create(modal.getName());
						isNew = true;
						if(dbObj == null){
							msgHelper.createError("System error while creating new record",sheetName,row.getRowNum() );
							continue;
						}
					}else{
						_log.debug("Record exists in db.So just update it.RowNum="+ row.getRowNum()  + " SheetName = " + sheetName);
					}
					for (Entry<String,GUField> fieldEntry : fields.entrySet()) {
						field = fieldEntry.getValue();
						String cellValue = StringPool.BLANK;
						if(Validator.isNotNull(field.getClmnName())){
							 cellValue = GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(field.getClmnName())));
						}
						// Override the blank value with default.. Default value usually for some system values..
						if(Validator.isNull(cellValue)){
							cellValue = field.getDefaultValue();
						}
						String valueToSave = StringPool.BLANK;
						// Case 1: Feild is Dependent (foriegn key) property, data of this field will come from other table. 
						if(Validator.isNotNull(field.getLinkedModal())){
							Long fkey = getLinkedModalPropertyValue(field,sheetName,row,rowHelper);
							if(fkey == null || fkey.longValue() == 0){
								msgHelper.createError("Can not find corresponding linked modal record",sheetName,row.getRowNum() ,field.getClmnName());
								error = true;
							}else{
								valueToSave = fkey.toString();
							}
						}
						// Case 2 : Field is for AssetCategories to be associated with record. In this case list of asset categories stored into asset entry table
						else if(field.getFieldName().startsWith(GUConstants.ASSET_CATEGORY_PREFIX)){
							try {
								Set<Long> tempCatIds = uploadHelper.getAssetCategoreis(row, field, rowHelper);
								if(tempCatIds != null){
									if(assetCatgs == null){
										assetCatgs = new LinkedHashSet<Long>();
									}
									assetCatgs.addAll(tempCatIds);
								}
							} catch (NoSuchCategoryException e) {
								msgHelper.createError("Asset Category is not found: " + e.getMessage(),sheetName,row.getRowNum() ,field.getClmnName());
								error = true;
							}
							
						}
						// Case 3 : Field is AssetCategory type. In this case Corresponding field in db stores the asset category id
						else if(Validator.isNotNull(field.getVocabName()) && Validator.isNotNull(cellValue)){
							try {
								Set<Long> tempCatIds = uploadHelper.getAssetCategoreis(row, field, rowHelper);
								valueToSave = StringUtil.merge(tempCatIds);
							} catch (NoSuchCategoryException e) {
								msgHelper.createError("Asset Category is not found: " + e.getMessage(),sheetName,row.getRowNum() ,field.getClmnName());
								error = true;
							}
							
						/*	AssetCategory catg = uploadHelper.getAssetCategory(field.getAssetVocabulary(), cellValue, field.isCreateCatg());
							if(catg == null){
								msgHelper.createError("Asset Category is not found.",sheetName,row.getRowNum() ,field.getClmnName());
								error = true;
							}else{
								valueToSave = String.valueOf(catg.getCategoryId());
							} */
						} 
						
						// Case 4 : Field is file/folder
						else if(GUUploadHelper.isFile_Folder_type(field.getDocumentType())){
							try {
								   if(Validator.isNotNull(cellValue)){
									   long id = fileHelper.handleUpload(dbObj, row, clmnIndexMap, field);
									   valueToSave = String.valueOf(id);
								   }
							} catch (GUException e) {
								continue outer;
							} catch (Exception e) {
								msgHelper.createError("Error while processing files.",sheetName,row.getRowNum() ,field.getClmnName());
								continue outer;
							}
						}
						else {
							valueToSave =  cellValue;
						}
						if(field.getFieldName().startsWith(DERIVED_PREFIX) || field.getFieldName().startsWith(ASSET_CATEGORY_PREFIX)){
							// DERIVED_PREFIX: This field does not exist in db.
							// It's introduced to support file uploads. 
							// EX: Some entities like startup profile stores it's document like Cover Image into doc-lib but it never keep reference of image into db.
							// ASSET_CATEGORY_PREFIX: this field does not exist in respective entity table. Entity related assets stored into asset entity table
						}else{
							try {
								
								GUEntityHelper.setValue(modal.getName(),dbObj, field.getFieldName(), valueToSave);
							} catch (GUInvalidDataException e) {
								msgHelper.createError("Invalid data.",sheetName,row.getRowNum() ,field.getClmnName());
							}
						}
					}
					
					// No errors exist, so can save
					if(!error){
						SambaashUtil.fillAudit((BaseModel)dbObj, logedInUser, companyId, groupId, isNew);
						boolean success = entityHelper.update(modal.getName(), dbObj);
						if(!success){
							msgHelper.createError("Error while saving the record.",sheetName,row.getRowNum() ,field.getClmnName());
						}else{
							String msg = "Updated";
							if(isNew){
								msg = "Created";	
							}
							long id = 0;
							try {
								id = GUEntityHelper.getPrimarykey(dbObj);
							} catch (Exception e) {
								_log.error("Error while getting primary key object");
							}
							msgHelper.createMsg("Success." +msg  + " Id="  + id,sheetName,row.getRowNum() );
							// update success rows
							Set<Integer>successSet = successRows.get(sheetName);
							if(successSet == null){
								successSet = new LinkedHashSet<Integer>();
								successRows.put(sheetName, successSet);
							}
							successSet.add(row.getRowNum());
							
							int count = uploadLog.getSuccessCount();
							uploadLog.setSuccessCount(count + 1);
							
							// Update assets
							try {
								if(assetCatgs != null && assetCatgs.size() > 0){
									long[]catgIds = ArrayUtil.toLongArray(assetCatgs);
									GUEntityHelper.updateAssetCategories(logedInUser.getUserId(), groupId, modal.getName(),dbObj, catgIds);
								}
							} catch (Exception e) {
								msgHelper.createError("Error while updating asset categories",sheetName,row.getRowNum());
							}
						}
					}
				}catch (GUException e) {
					msgHelper.createError("Error while processing row." + e.getMsg(),sheetName,row.getRowNum() ,field != null ? field.getClmnName() : "");
					_log.error(e);
				} catch (Exception e) {
					msgHelper.createError("Error while processing row",sheetName,row.getRowNum() ,field != null ? field.getClmnName() : "");
					_log.error(e);
				}
				
			}
			
		}
	}

	private void setOtherOptionalCustomUploaderDetails(String modalName, GUCustomUploader customUploader , Map<String, GUModal> modalMap,Map<String, Integer>mdClmnNameIndexMap) {
		try {
			customUploader.setRequest(getRequest());
			customUploader.setKeys(modalKeys.get(modalName));
			customUploader.setModalMap(modalMap);
			customUploader.setMdClmnNameIndexMap(mdClmnNameIndexMap);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void deleteMultiInstanceRecords(GUField multiInstanceField, Long fkey) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, GUInvalidDataException{
		if(fkey != null && fkey != 0){
			Map<String,String>criteriaMap = new LinkedHashMap<String, String>();
			criteriaMap.put(multiInstanceField.getFieldName(), String.valueOf(fkey.longValue()));
			GUEntityHelper.deleteRecords(multiInstanceField.getModalName(), criteriaMap); 
		}
	}
	private Long getLinkedModalPropertyValue(GUField field,String sheetName,Row row,GUWBRowHelper rowHelper ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, GUException, SystemException {
		Object lmDbObj = getDBObjectUsingKeys(field.getLinkedModal(), row, rowHelper,0);
		if(lmDbObj == null){
			//msgHelper.createError("Not able to find Corresponding Linked Modal Data.",sheetName,row.getRowNum(),field.getClmnName()));
			return null;
		}
		String getMethodName = "";
		String lm_prop = field.getLinkedModalProperty();
		if(Validator.isNotNull(lm_prop)){
			String fc = lm_prop.charAt(0) + "";
			getMethodName = "get" + lm_prop.replaceFirst(fc, fc.toUpperCase());
		}else{
			getMethodName = "getPrimaryKey";
		}
		
		Class entityClass = lmDbObj.getClass();
		try {
				Method getMethod = entityClass.getMethod(getMethodName, null);
				Long key =  (Long)getMethod.invoke(lmDbObj, null);
				return key;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			_log.error(e);
		}
		return null;
	}
	
	private Object getDBObjectUsingKeys(String modalName,Row row,GUWBRowHelper rowHelper, int count) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, GUException, SystemException{
		if(count > 10){
			throw new GUException("Linked Modals can not go deeper than 10 levels");
		}
		Set<GUField>lmkeys = modalKeys.get(modalName);
		if(lmkeys == null){
			return null;
		}
		/*List<GUField>allKeys = new ArrayList<GUModal.GUField>();
		//Recursively get linked modal keys
		for (GUField guField : lmkeys) {
			getAllKeys(guField, allKeys,0);
		}
		*/
		Map<String,String>data = new LinkedHashMap<String, String>();
		for (GUField guField : lmkeys) {
			if(Validator.isNotNull(guField.getLinkedModal())){
				Object obj = getDBObjectUsingKeys(guField.getLinkedModal(), row, rowHelper,count++);
				if(obj == null){
					throw new GUException("Record of " + guField.getLinkedModal() + " is not found.");
				}
				data.put(guField.getFieldName(), String.valueOf(GUEntityHelper.getPrimarykey(obj)));
			} else {
				// Cell cell =
				// row.getCell(clmnIndexMap.get(guField.getClmnName()));
				String cellValue = rowHelper.getCellValue(row, guField);// GUWBHelper.getCellValue(cell);
				if (Validator.isNotNull(guField.getVocabName())	&& Validator.isNotNull(cellValue)) {
					try {
						Set<Long> tempCatIds = uploadHelper.getAssetCategoreis(row, guField, rowHelper);
						String catgId_s = StringUtil.merge(tempCatIds);
						data.put(guField.getFieldName(),catgId_s );
					} catch (NoSuchCategoryException e) {
					//	msgHelper.createError("Asset Category is not found: " + e.getMessage(),sheetName,row.getRowNum() ,field.getClmnName());
						throw new GUException("Asset Category is not found: " + e.getMessage());
					}
					
				/*	AssetCategory catg = uploadHelper.getAssetCategory(
							guField.getAssetVocabulary(), cellValue,
							guField.isCreateCatg());
					if (catg == null) {
						throw new GUException(guField.getClmnName() + " value represent asset category and it does not exist in the system.");
					} */
				} else if (Validator.isNotNull(cellValue)) {
					data.put(guField.getFieldName(), cellValue);
				} else if (Validator.isNull(cellValue)) {
					throw new GUException(guField.getClmnName()
							+ " is key field. So it's value can not be blank.");
				//	data.put(guField.getFieldName(), cellValue);
				}
			}
		}
		GUEntityHelper entityHelper = new GUEntityHelper();
		Object obj = entityHelper.getOne(modalName, data);
		return obj;
	}
	
	private void parseMetaData(){
		uploadLog.setStatus(STATUS_VALIDATING);
		if(file == null){
			msgHelper.createError("No file is uploaded");
			return;
		}
		try {
			// Validated the file
			if (file.getName().endsWith(EXCEL.EXTENSION)) {
				wb = GUWBHelper.readFileXlsx(new FileInputStream(file));
			} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
				wb = GUWBHelper.readFileXls(new FileInputStream(file));
			} else {
				msgHelper.createError("Invalid File Type. Please provide either " + EXCEL.EXTENSION + " or " + EXCEL.EXTENSION_OLD + " file types");
				return;
			}
			if (wb == null) {
				msgHelper.createError("File format is not valid");
				return;
			}
		
		   this.customUploaderHelper = new GUCustomUploaderHelper(companyId, groupId, logedInUser,wb,msgHelper);
		   
		   // Checking for meta data sheet
		   Sheet sheet = wb.getSheet(SHEET_META_DATA);
		   if(sheet == null){
			   _log.error("Meta data sheet not found.");
			   msgHelper.createError("Sheet " + SHEET_META_DATA + " not found. Can not proceed further.");
			   return;
		   }
		 
		   // header row check
		   Row row = sheet.getRow(0);
		   if(GUWBHelper.isRowEmpty(row)){
			   msgHelper.createError("Header Row Missing.Can not proceed further.",SHEET_META_DATA);
			   return;
		   }
		   
		   // Map column name to index. Using this map, data can accessed using column
		   mdClmnNameIndexMap = GUWBHelper.getClmnIndexMap(row);
		   
		   // Validate if all columns are available
		   String mainModalName = getMetaData(sheet.getRow(2), CLMN_MODAL);
		   List<String> mainModalColumns = getModalColumns(mainModalName);
		   boolean allPresent = checkAllClmns(mainModalName);
		   if(!allPresent){
			   return;
		   }
		   int derivedCount = 0;
		   // rn - 0 Header
		   // rn - 1 Descriptions/Help text
		   // rn - 2 onwards need to proces
		   for(int rn = 2 ; rn <= sheet.getLastRowNum(); rn++){
			   row = sheet.getRow(rn);
			   if(GUWBHelper.isRowEmpty(row)){
				  // msgHelper.createMsg("Empty row. Ignoring the row " ,SHEET_META_DATA,rn);
				   continue;
			   }
			   String modalName = getMetaData(row, CLMN_MODAL);
			   if(Validator.isNull(modalName)){
				   msgHelper.createError("Modal Name is blank." ,SHEET_META_DATA,rn,CLMN_MODAL);
				   continue;
			   }
			   //Some custome modals, like some sections in User Profile, User Profile : basic_info
			   if(modalName.indexOf(MODAL_NAME_SEPARATOR) != -1){
				   String parentModal = modalName.substring(0, modalName.indexOf(MODAL_NAME_SEPARATOR));
				   GUDBEntity registred = GUEntityHelper.DB_MODALS_MAP.get(parentModal);
				   if(registred == null){
					   msgHelper.createError("Unkonw modal : " + parentModal ,SHEET_META_DATA,rn,CLMN_MODAL);
					   continue;
				   }
				   
			   }else{
				   GUDBEntity registred = GUEntityHelper.DB_MODALS_MAP.get(modalName);
				   if(registred == null){
					   msgHelper.createError("Unknown Modal : " + modalName ,SHEET_META_DATA,rn,CLMN_MODAL);
					   continue;
				   }
			   }
			   GUModal modal = modalMap.get(modalName);
			   if(modal == null){
				   modal = new GUModal(modalName);
				   modalMap.put(modalName, modal);
			   }
			   
			   // If this row is about model, then fields related columns must be ignored
			   boolean abtModal = GetterUtil.getBoolean(getMetaData(row, CLMN_ABOUT_MODAL));
			   if(abtModal){
				   String dataSheet = getMetaData(row, CLMN_DATA_SHEET_NAME);
				   modal.setSheetName(dataSheet);
				   addProcessV2FormInfo(modal, row);
				   if(Validator.isNull(dataSheet)){
					   msgHelper.createMsg("Warning:Data Sheet Name is blank for Modal  " + modalName + ". So there is nothing save in this modal", SHEET_META_DATA,row.getRowNum());
				   }else{
					   Sheet temp = wb.getSheet(dataSheet);
					   if(temp == null){
						   msgHelper.createError("Sheet does not exist with name = " + dataSheet + ". ", SHEET_META_DATA, rn, CLMN_DATA_SHEET_NAME );
					   }else{
						   Row headerRow = temp.getRow(0);
						   if(headerRow == null){
							   msgHelper.createError("Header row missing" , temp.getSheetName());
							   return;
							}
					   }
				   }
			   }else{
				   // This row is about field details, Process columns which are related to fields
				   String fieldName = getMetaData(row, CLMN_FIELD_IN_DB);
				   String docType = getMetaData(row, CLMN_DOCUMENT_TYPE);
				   if(Validator.isNotNull(docType)){
					  if(! GUUploadHelper.isFile_Folder_type(docType)){
						  msgHelper.createError("Invalid value for Document Type",SHEET_META_DATA, rn , CLMN_DOCUMENT_TYPE);
					  }
				   }
				   // Field Name can be blank if doc type is file/folder
				   if(Validator.isNull(fieldName) && Validator.isNull(docType)){
					   msgHelper.createError("Field Name is blank",SHEET_META_DATA, rn , CLMN_FIELD_IN_DB);
				   }else{
					   if(Validator.isNull(fieldName) ){
						   // Assuming it's derived type
						   fieldName = DERIVED_PREFIX + derivedCount++;
					   }
					   GUField field  = modal.getField(fieldName);
					   if(field == null){
						   field =  modal.new GUField(fieldName);
						   modal.putField(fieldName, field);
					   }
				   
					   
					   String clmnInExcel = getMetaData(row, CLMN_CLMN__NAME_IN_EXCEL);
					   String defaultValue = getMetaData(row, CLMN_CLMN__DEFAULT_VALUE);
					   String lmName = getMetaData(row, CLMN_LINKED_MODAL);
					   String lm_propery = getMetaData(row, CLMN_LINKED_MODAL_PROPERTY);
					   field.setLinkedModal(lmName);
					   field.setLinkedModalProperty(lm_propery);
					   field.setDefaultValue(defaultValue);
					   addProcessV2FormFieldDtl(row, field);
					   //If this field is dependent on other modal, then corresponding excel column is not required ( OR ), the modal just working ( No upload related to this modal) as linked modal to other.
					   // If the default value is specified column name is not required
					   if(Validator.isNull(clmnInExcel) && Validator.isNull(lmName) && Validator.isNotNull(modal.getSheetName())){
						   if(Validator.isNull(defaultValue)){
							   msgHelper.createError("Blank",SHEET_META_DATA, rn ,CLMN_CLMN__NAME_IN_EXCEL);
						   }
					   }

					   // Validate if column exists or not
					   if(Validator.isNotNull(clmnInExcel)){
						   Sheet temp = wb.getSheet(modal.getSheetName());
						   if(temp != null){
							   Row tempHeaderRow = temp.getRow(0);
							   Map<String,Integer>tempMp = null;
							   if(tempHeaderRow != null){
								   tempMp = GUWBHelper.getClmnIndexMap(tempHeaderRow);
							   }
							   if(tempMp == null || tempMp.get(clmnInExcel) == null){
								   msgHelper.createError(clmnInExcel + " does not exist in the sheet: " + modal.getSheetName(),SHEET_META_DATA, rn ,CLMN_CLMN__NAME_IN_EXCEL);
							   }
						   }
					   }
					   field.setClmnName(clmnInExcel);
					   boolean key = GetterUtil.getBoolean(getMetaData(row, CLMN_KEY_CLMN));
					   field.setKey(key);
					   
					   if(key){
						   Set<GUField> keys = modalKeys.get(modalName);
						   if(keys == null){
							   keys = new HashSet<GUModal.GUField>();
							   modalKeys.put(modalName, keys);
						   }
						   keys.add(field);
					   }
					  
					   if(Validator.isNotNull(lmName)){
						   validateLinkedModelProperty(field, row);
						   boolean multiInstance = GetterUtil.getBoolean(getMetaData(row, CLMN_MULTI_INSTANCE));
						   if(multiInstance){
							   field.setMultiInstance(multiInstance);
							   field.setDeleteCreateMultiInstance(GetterUtil.getBoolean(getMetaData(row, CLMN_DELETE_THEN_CREATE_MULTI_INSTANCE)));
						   }
					   }
					   
					   if (mainModalColumns.contains(CLMN_VOCABULARY_NAME)) {
						   String vocabulary = getMetaData(row, CLMN_VOCABULARY_NAME);
						   field.setVocabName(vocabulary);
						   if(Validator.isNotNull(vocabulary)){
							   try {
								   AssetVocabulary voc = uploadHelper.getAssetVocabulary(vocabulary);
								   if(voc == null){
									   msgHelper.createError("Asset Vocabulary does not exist in the system. Asset Vocabulary=" + vocabulary,SHEET_META_DATA,rn , CLMN_VOCABULARY_NAME);
								   }
								   field.setAssetVocabulary(voc);
							   } catch (Exception e) {
								   msgHelper.createError("Error while getting Asset Vocabulary=" + vocabulary,SHEET_META_DATA,rn , CLMN_VOCABULARY_NAME);
							   }
							   field.setCreateCatg(GetterUtil.getBoolean(getMetaData(row, CLMN_CREATE_CATEGORY)));
						   }						   
					   }
					   
					   if(Validator.isNotNull(docType)){
						   String srcPath = getMetaData(row, CLMN_SOURCE_PATH);
						   String destPath = getMetaData(row, CLMN_DESTINATION_PATH);
						   
						   if(Validator.isNull(srcPath)){
							   msgHelper.createError("Source Path can not be blank if Document Type is specified",SHEET_META_DATA,rn , CLMN_SOURCE_PATH);
						   }else{
							   try {
								   long srcFolderId = GUFileHelper.getFolderId(groupId, srcPath, false);
								
							   } catch (Exception e) {
								msgHelper.createError("Error while checking source path. Check path correctly",SHEET_META_DATA,rn , CLMN_SOURCE_PATH);
							}
						   }
						   // For Process applications destination path is not required as files will store into form storage
						   if(!GUEntityHelper.ENTITY_PROCESS.equalsIgnoreCase(modal.getName())){
							   if(Validator.isNull(destPath)){
								   msgHelper.createError("Destination Path can not be blank if Document Type is specified",SHEET_META_DATA,rn , CLMN_DESTINATION_PATH);
							   }
						   }
						   
						   String folderMatchingPath = getMetaData(row, CLMN_FOLDER_MATCHING_PATH);
						   String orgFieldName = getMetaData(row, CLMN_FIELD_IN_DB);
						   if(DOCUMENT_TYPE_Folder.equalsIgnoreCase(docType) && Validator.isNotNull(orgFieldName) && Validator.isNull(folderMatchingPath) ){
							   msgHelper.createError("If Document Type is folder and Field Name is specified, then Folder Matching Path can not be blank. Folder Matching Path is used to identify folder id to set to specified field",SHEET_META_DATA,rn , CLMN_DESTINATION_PATH);
						   }
						   if(DOCUMENT_TYPE_Folder.equalsIgnoreCase(docType) &&  Validator.isNotNull(folderMatchingPath) && destPath.indexOf(folderMatchingPath) == -1){
							   msgHelper.createError("Folder matching path must be sub-string of Destination path",SHEET_META_DATA,rn , CLMN_FOLDER_MATCHING_PATH);
						   }
						   
						   field.setDocumentType(docType);
						   field.setSrcPath(srcPath);
						   field.setDestinationPath(destPath);
						   field.setFolderMatchingPath(folderMatchingPath);

					   }
					   //TODO: check the existance of the field using reflection

				   }
				   
			   }
			   
		   }
		   
		   
		// checking for custome validations.. fire custome validations only if generic validations exists
			if (uploadLog.getErrorCount() == 0) {
				for (Entry<String, GUModal> entry : modalMap.entrySet()) {
					try {
						GUCustomUploader cuploader = customUploaderHelper.getUploader(entry.getKey(), entry.getValue());
						if (cuploader != null) {
							cuploader.validate();
						} else {
							// Custom uploader does not. So generic uploader
							// must exist.. this is already covered in modal
							// validation.
						}

					} catch (Exception e) {
						msgHelper.createError("System Error. Error while creating/validating custom uploader for modal "+ entry.getKey(), SHEET_META_DATA);
						_log.error(e);
					}
				}
			}
		   
		} catch (Exception e) {
			_log.error(e);
			msgHelper.createError("Error while reading meta-data");
		}
	}

	private void addProcessV2FormInfo(GUModal modal, Row row) {
		try {
			   String formNodeId = getMetaData(row, CLMN_FORM_NODE_ID);
			   modal.setFormNodeId(formNodeId);
			   modal.setDeleteThenCreate(GetterUtil.getBoolean(getMetaData(row, CLMN_DELETE_THEN_CREATE)));					
			} catch (Exception e) {
				// For ProcessV2 only. Other templates will not have this.
			}
	}

	private void addProcessV2FormFieldDtl(Row row, GUField field) {
		try {
			   String formNodeId = getMetaData(row , CLMN_FORM_NODE_ID);
			   String arrayFieldName = getMetaData(row , CLMN_ARRAY_FIELD_NAME);
			   field.setFormNodeId(formNodeId);
			   field.setArrayFieldName(arrayFieldName);						
			} catch (Exception e) {
				// Only for ProcessV2 Other templates will not have this.
			}
	}
	
	private String getMetaData(Row row,String clmnName){
		int index = GetterUtil.getInteger(mdClmnNameIndexMap.get(clmnName));
		Cell cell = row.getCell(index);
		return GUWBHelper.getCellValue(cell);
	}
	
	private boolean checkAllClmns(String modalName){
		boolean valid = true;
		for (String clmn : getModalColumns(modalName)) {
			Integer index = mdClmnNameIndexMap.get(clmn);
			if(index == null){
				valid = false;
				msgHelper.createError("Column is missing" ,SHEET_META_DATA,-1, clmn);
			}
		}
		return valid;
	}

	private List<String> getModalColumns(String modal) {
        String[] modalColumns = MODAL_METADATA_COLUMNS.get(modal);
        if (modalColumns == null) {
            modalColumns = ALL_META_DATA_CLMNS;
        }
        return Arrays.asList(modalColumns);
    }
	
	/**
	 * 
	 * @param field - (Foreign key) whose value depends on other model.
	 * @param sheetToVerify - This sheet must have all key columns of linked model
	 * @param row
	 * @throws GUException 
	 */
	private void validateLinkedModelProperty(GUField field, Row row) throws GUException{
		String lmName = field.getLinkedModal();
		if(Validator.isNull(lmName)){
			return;
		}
		
		if(Validator.isNotNull(lmName) && Validator.isNotNull(field.getClmnName())){
			msgHelper.createError("Please specify either Linked Model (Or) Column Name In Excel. Both can not be present" + lmName ,SHEET_META_DATA,row.getRowNum() ,CLMN_LINKED_MODAL);
			return;
		}
		
		Sheet sheetToVerify = wb.getSheet(field.getSheetName());
		if(sheetToVerify == null){
			return;
		}
		GUModal lm = modalMap.get(lmName);
		if(lm == null){
			msgHelper.createError("Not able to find Linked Modal: " + lmName ,SHEET_META_DATA,row.getRowNum() ,CLMN_LINKED_MODAL);
			return;
		}
		Row headerRow = sheetToVerify.getRow(0);
		if(headerRow == null){
			msgHelper.createError("Header row missing in sheet " + sheetToVerify.getSheetName(),SHEET_META_DATA,row.getRowNum());
			return;
		}
		Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(headerRow);
	
		Set<GUField>keys = modalKeys.get(lmName);
		if(keys == null || keys.size() == 0){
			msgHelper.createError("No keys found in Linked Modal: " + lmName,SHEET_META_DATA,row.getRowNum());
			return;
		}
		List<GUField>allKeys = new ArrayList<GUModal.GUField>();
		for (GUField keyField : keys) {
			getAllKeys(keyField, allKeys,0);
		}
		for (GUField keyField : allKeys) {
			Integer index = clmnIndexMap.get(keyField.getClmnName());
			if(index == null){
				msgHelper.createError("Key column is missing." + keyField.getClmnName() , sheetToVerify.getSheetName(),0 ,keyField.getClmnName());
			}
		}
	
	}
	/**
	 * This method recursively gets all keys.
	 * 
	 *   Let's say field1 depends on LM1,
	 *   LM1 has keys  ( key1 - normal, key2 - is value from LM2)
	 *   LM2 has keys (  key3 - normal,key4 - normal)
	 *   
	 *   now this method returns key1,key3,key4 for field1. Note: key2 wont be returned. bcz key2 can be identified using key3, key4
	 * 
	 * @param field
	 * @param allKeys
	 * @throws GUException 
	 */
	public void getAllKeys(GUField field, List<GUField> allKeys,int count) throws GUException{
		// This condition added to survie from any misconfigurations. 
		// Any misconfiguration can make system down as this method is recursive call. So limiting the recursive depth to 10
		if(count > 10){
			throw new GUException("Linked modals can not go beyond deeper of 10 levels");
		}
		if(Validator.isNotNull(field.getLinkedModal())){
			for (GUField fieldTemp : modalKeys.get(field.getLinkedModal())) {
				getAllKeys(fieldTemp, allKeys,count++);
			}
		}
		if(Validator.isNull(field.getLinkedModal())){
			allKeys.add(field);
		}
	}

	public ResourceRequest getRequest() {
		return request;
	}

	public void setRequest(ResourceRequest request) {
		this.request = request;
	}
	
}
