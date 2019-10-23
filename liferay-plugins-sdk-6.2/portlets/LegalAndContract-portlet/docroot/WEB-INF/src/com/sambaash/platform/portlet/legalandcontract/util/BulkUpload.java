package com.sambaash.platform.portlet.legalandcontract.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;

public abstract class BulkUpload {
	private static Log _log = LogFactoryUtil.getLog(BulkUpload.class.getName());
	private static final String ROWS_ADDED = "rowsAdded";
	private static final String ROWS_ADD_FAILD = "rowsAddFailed";
	private static final String ROWS_UPDATED = "rowsUpdated";
	private static final String ROWS_UPDATE_FAILD = "rowsUpdateFailed";
	private static final String ERRORS = "errors";
	private static final String HEADER_FAILED = "headerFailed";
	private static final String PROCESSED = "processed";
	protected static final String FIELD_NOT_VALID_FORMAT = "%s is not valid";
	
	private static final String FIELD_NOT_EXISTS_IN_SYSTEM_FORMAT = "'%s' does not exists in the system. Check with Administrator";
	
	protected static final String STRING = "string";
	protected static final String INTEGER = "integer";
	protected static final String LONG = "long";
	protected static final String DATE = "date";
	protected static final String BOOLEAN = "boolean";
	protected static final String FLOAT = "float";
	protected static String CLASS_CODE_SEPARATOR = ":";
	
	protected static String NEW_LINE_CHAR_ERROR = "Invalid Format.Value might have spanned to more than one line with enter key. Use cell wrap and space to span across more than one line.";
	
	
	protected ActionRequest actionRequest;
	protected ActionResponse actionResponse;
	protected ThemeDisplay themeDisplay;
	protected ServiceContext serviceContext;
	protected PortletPreferences preferences;
    protected List<XSLColumn> columnList;
    int catIdslength;
    int dateFieldslength;
	public BulkUpload(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
		this.actionRequest = request;
		this.actionResponse = response;
		this.themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		this.serviceContext = ServiceContextFactory.getInstance(
				ClassMaster.class.getName(), actionRequest);
		this.preferences = request.getPreferences();
		this.columnList = new ArrayList<XSLColumn>();
		init();
		catIdslength = getCatIdLength();
		dateFieldslength = getDateFieldsLength();
	}
	public void process() throws Exception{
		upload();
	}
	public  void upload() throws Exception{
		long userId = themeDisplay.getUserId();
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File[] files = uploadPortletRequest.getFiles("filesToUpload");
		List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		Map<String, Object> temp = null;
		List validRows = new ArrayList();
		int rowsAdded = 0;
		int addFailed = 0;
		int rowsUpdated = 0;
		int updateFailed = 0;
		for (File file : files) {
			if (_log.isDebugEnabled()) {
				_log.debug("---------------- fileName : " + file.getName());
			}
			Workbook wb = null;
			if (file.getName().endsWith(EXCEL.EXTENSION)) {
				wb = readFileXlsx(new FileInputStream(file));
			} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
				wb = readFileXls(new FileInputStream(file));
			} else {
				throw new FileFormatException(FileFormatException.FILE_TYPE_EXCEPTION);
			}
 
			if (wb == null) {
				throw new FileFormatException(FileFormatException.METADATA_EXCEPTION);
			}
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				temp = upload(i+1,wb.getSheetAt(i),userId,validRows);
				errors.addAll((List<XSLErrorField>)temp.get(ERRORS));
				rowsAdded = rowsAdded + (Integer)temp.get(ROWS_ADDED);
				addFailed = addFailed + (Integer)temp.get(ROWS_ADD_FAILD);
				rowsUpdated = rowsUpdated + (Integer)temp.get(ROWS_UPDATED);
				updateFailed = updateFailed + (Integer)temp.get(ROWS_UPDATE_FAILD);
			}
		}
		
		actionRequest.setAttribute(PROCESSED,true);
		actionRequest.setAttribute(ROWS_ADDED,rowsAdded);
		actionRequest.setAttribute(ROWS_ADD_FAILD,addFailed);
		actionRequest.setAttribute(ROWS_UPDATED,rowsUpdated);
		actionRequest.setAttribute(ROWS_UPDATE_FAILD,updateFailed);
		actionRequest.setAttribute(ERRORS,errors);
		actionRequest.setAttribute("successImage",themeDisplay.getPathThemeImages() + "/messages/success.png");
		actionRequest.setAttribute("failImage",themeDisplay.getPathThemeImages() + "/messages/error.png");
	}
	
	protected XSLColumn getColumn(String name){
		for(XSLColumn clmn:columnList){
			if(clmn.getName().equalsIgnoreCase(name)){
				return clmn;
			}
		}
		return null;
	}
	
	protected  Map<String, Object> upload(int sheetNo,Sheet sheet,long userId,List validRows) throws Exception {
			List<XSLErrorField> allErrors = new ArrayList<XSLErrorField>();
			List<XSLErrorField> rowErrors = null;
			Map<String, String> rmap = new LinkedHashMap<String, String>();
			Map<String, String> origmap = new LinkedHashMap<String, String>();
			Map<String, Object> result = new HashMap<String, Object>();
			Row headerRow = sheet.getRow(0);
			Object[]objs  = processHeaderRow(headerRow);
			XSLErrorField error = (XSLErrorField)objs[0];
			if(error != null){
				error.setSheetNo(sheetNo);
				error.setRowNo(1);
				allErrors.add(error);
				result.put(HEADER_FAILED, true);
				result.put(ERRORS,allErrors);
				result.put(ROWS_ADDED,0);
				result.put(ROWS_ADD_FAILD,0);
				result.put(ROWS_UPDATED,0);
				result.put(ROWS_UPDATE_FAILD,0);
				return result;
			}
			List<String>columnNames = (List<String>)objs[1];
			long []categoryIds;
			Date [] dates;
			int rowNo;
			int rowsAdded = 0;
			int addFailed = 0;
			int rowsUpdated = 0;
			int updateFailed = 0;
			
			//First row header , second row contains descriptions. So processing have to start from 3rd row
			for (int i = 2; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				rowNo = i + 1;
				_log.debug("Processing row " + rowNo + " Started" );
				if(Validator.isNotNull(row)){
					rowErrors = new ArrayList<XSLErrorField>();
					try{
						for(int index=0; index < columnNames.size(); index++){
							XSLColumn clmn = getColumn(columnNames.get(index));
							if(Validator.isNotNull(clmn)){
								origmap.put(columnNames.get(index), getCellValue(row.getCell(index),clmn.getDataType()));
								
							}
				    	}
				
						_log.debug( "Row No " + rowNo + " Data = " + origmap);
						rowErrors.addAll( validateRequiedFields(sheetNo, rowNo, origmap));
						rowErrors.addAll( maxLengthValidation(sheetNo, rowNo, origmap));
						
				   /* 	if(error != null){
				    		allErrors.add(error);
				    		continue;
				    	} */
				    	objs = convertRow(sheetNo, rowNo, origmap);
				    	rowErrors.addAll((List<XSLErrorField>)objs[0]);
				    	
				    	/*if(objs[0] != null){
				        	allErrors.add((XSLErrorField)objs[0]);
				        	continue;
				        }*/
				    	rmap = (Map<String,String>)objs[1];
				    	
				        objs = validateRetrieveCatIds(sheetNo, rowNo, rmap);
				     /*   if(objs[0] != null){
				        	allErrors.add((XSLErrorField)objs[0]);
				        	 */
				        categoryIds = (long[])objs[1];
				        rowErrors.addAll((List<XSLErrorField>)objs[0]);
				        
				        objs = validateParseDates(sheetNo, rowNo,rmap);
				        /*if(objs[0] != null){
				        	allErrors.add((XSLErrorField)objs[0]);
				        	continue;
				        } */
				        dates = (Date[])objs[1];
				        rowErrors.addAll((List<XSLErrorField>)objs[0]);
				        
				        error = isDuplicate(sheetNo, rowNo,validRows,rmap);
				        if(error != null){
				             //allErrors.add(error);
							// continue; 
				        	rowErrors.add(error);
				        }
				      
				        rowErrors.addAll(extraValidations(sheetNo, rowNo,validRows,rmap));
				      /*  if(error != null){
				        	allErrors.add(error);
				        	continue; 
				        } */
				        
				        objs = extraProcessing(sheetNo, rowNo, rmap);
				        rowErrors.addAll((List<XSLErrorField>)objs[0]);
				        
				        if(!rowErrors.isEmpty()){
				        	allErrors.addAll(rowErrors);
				        	continue;
				        }
				        
				        Object obj = fillModel(rmap,dates,objs[1]);
				        if(isNew(obj)){
				        	try{
				        		add(obj,categoryIds,objs[1]);
				        		uploadFiles(sheetNo,rowNo,obj,rmap);
				        		rowsAdded = rowsAdded + 1;
				        		error = new XSLErrorField(sheetNo, rowNo, "N/A", "Added");
								allErrors.add(error);
				        	}catch(Exception ex){
				        		addFailed = addFailed + 1;
				        	}
				        }else{
				        	try{
				        		update(obj,categoryIds,objs[1]);
				        		uploadFiles(sheetNo,rowNo,obj,rmap);
				        		rowsUpdated = rowsUpdated + 1;
				        		error = new XSLErrorField(sheetNo, rowNo, "N/A", "Updated");
								allErrors.add(error);
				        	}catch(Exception ex){
				        		updateFailed = updateFailed + 1;
				        	}
				        }
				        validRows.add(obj);
				        if(i == 1){
				        	saveInsertedFiles(sheet.getWorkbook(), rmap);
				        }
					}catch(Exception ex){
						error = new XSLErrorField(sheetNo, rowNo, "Not Applicable", "Error while processing row ");
						_log.error("Error while processing row " + rowNo + " " + ex.getMessage());
						allErrors.add(error);
					}
				}
			}
			result.put(ROWS_ADDED,rowsAdded);
			result.put(ROWS_ADD_FAILD,addFailed);
			result.put(ROWS_UPDATED,rowsUpdated);
			result.put(ROWS_UPDATE_FAILD,updateFailed);
			result.put(ERRORS,allErrors);
			
		//	if (_log.isDebugEnabled()) {
				_log.error("Printing excel upload errors - Start");
	
				for (XSLErrorField xslErrorField : allErrors) {
					_log.error(xslErrorField.toString());
				}
				_log.error("Printing Eexcelxcel upload errors - End");
		//	}
			
			return result;
		}
		protected abstract void init();
	 	protected abstract Object fillModel(Map<String,String>rmap,Date[] dates,Object extra) throws Exception;
		protected abstract Object addorUpdate(Map<String,String>rmap);
		protected abstract boolean isNew(Object obj);
		protected abstract void add(Object obj,long catIds[],Object extra) throws Exception;
		protected abstract void update(Object obj, long catIds[],Object extra) throws Exception;
		protected abstract XSLErrorField isDuplicate(int sheetNo,int rowNo,List validRows,Map<String,String>rmap);
		
		protected List<XSLErrorField> extraValidations(int sheetNo,int rowNo,List validRows,Map<String,String>rmap){
			return null;
		}
		protected XSLErrorField uploadFiles(int sheetNo,int rowNo, Object obj, Map<String,String>rmap){
			return null;
		}
		
		void saveInsertedFiles(Workbook wb, Map<String,String>rmap){
			
		}
		
		protected Object[] extraProcessing(int sheetNo,int rowNo,  Map<String,String>rmap){
			// obj[0]  for errors
			// obj[1] any other data
			return new Object[]{
					new ArrayList(),null
			};
		}
	
	
	private Object[] convertRow(int sheetNo, int rowNo, Map<String, String> orgRow) {
		XSLErrorField error = null;
		Map<String, String> rmap = new LinkedHashMap<String, String>();
		List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		Object objs[] = new Object[2];
		String data = "";
		String name = "";
		String expected = "";
		for (XSLColumn clmn : columnList) {
			try {
				name = clmn.getName();
				data = orgRow.get(name);
				expected = "";
				if (!Utils.nullOrEmpty(data)) {
					if (INTEGER.equalsIgnoreCase(clmn.getDataType())) {
						expected = "Numeric";
						rmap.put(name, (int) Float.parseFloat(data) + "");
					} else if (LONG.equalsIgnoreCase(clmn.getDataType())) {
						expected = "Numeric";
						rmap.put(name, (long) Float.parseFloat(data) + "");
					} else if (FLOAT.equalsIgnoreCase(clmn.getDataType())) {
						expected = "Numeric";
						rmap.put(name, Float.parseFloat(data) + "");
					} else if (BOOLEAN.equalsIgnoreCase(clmn.getDataType())) {
						expected = "boolean";
						rmap.put(name, Boolean.parseBoolean(data) + "");
					} else {
						// String type cells if contains number let's say 452
						// then POI api reading it as 452.0. Hence below logic
						// to trim the zero.
						boolean isNum = true;
						for (int i = 0; i < data.length(); i++) {
							if (!Validator.isDigit(data.charAt(i)) && data.charAt(i) != '.') {
								isNum = false;
								break;
							}
						}
						if (isNum) {
							if (data.endsWith(".0")) {
								data = data.substring(0, data.length() - 2);
							}
						}
						rmap.put(name, data);
					}
				}
			} catch (Exception ex) {
				error = new XSLErrorField(sheetNo, rowNo, name, "Invalid format " + data + " Expected " + expected);
				errors.add(error);
			}
		}
		objs[0] = errors;
		objs[1] = rmap;
		return objs;
	}
		
		private  Object[] processHeaderRow(Row headerRow) throws FileFormatException{
			XSLErrorField error = null;
			String clname;
			List<String>names = new ArrayList<String>();
			Object objs[] = new Object[2];
			Cell cell;
			try{
				for(int index=0; index < columnList.size(); index++){
					cell = headerRow.getCell(index);
					if(cell != null){
						names.add(headerRow.getCell(index).getStringCellValue());
					}
				}
				for(XSLColumn clmn: columnList){
					clname = clmn.getName();
					if(!names.contains(clname)){
						error = new XSLErrorField();
						error.setFieldName("Not Applicable");
						error.setMsg("Invalid Column names: Column '" + clname + "' not found. Expected Columns " + getColumnNames());
						break;
					}
				}
			}catch(Exception ex){
				_log.error(ex);
				error = new XSLErrorField();
				error.setFieldName("Not Applicable");
				error.setMsg("Exception while processing header row");
			}
			objs[0] = error;
			objs[1] = names;
			return objs;
		}
		
	private String getColumnNames(){
		StringBuilder sb = new StringBuilder();
		try{
			for(XSLColumn clmn: columnList){
				sb.append(clmn.getName());
				sb.append(" , ");
			}
			sb.replace(sb.lastIndexOf(","),sb.lastIndexOf(",")+1,"");
		}catch(Exception ex){
			
		}
		
		return sb.toString();
	}
	  private  List<XSLErrorField> validateRequiedFields(int sheetNo,int rowNo,Map<String, String>row){
		  XSLErrorField error = null;
		  List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		  for(XSLColumn clmn:columnList){
			  if(clmn.isRequiredField()){
				  if(Utils.nullOrEmpty(row.get(clmn.getName()))){
					  error = new XSLErrorField(sheetNo,rowNo,clmn.getName(),clmn.getName() + " is required");
					  errors.add(error);
				  }
			  }
		  }
		  return errors;
	  }
	  private  List<XSLErrorField> maxLengthValidation(int sheetNo,int rowNo,Map<String, String>row){
		  XSLErrorField error = null;
		  List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		  for(XSLColumn clmn:columnList){
			  String value = row.get(clmn.getName());
			  if(Validator.isNotNull(value)){
				  if(clmn.getLength() > 0 && value.length() > clmn.getLength()){
					  error = new XSLErrorField(sheetNo,rowNo,clmn.getName(), "Value exceeds the maximum allowed size " + clmn.getLength());
					  errors.add(error);
				  }
			  }
		  }
		  return errors;
	  }
	
	  protected long getVocId(String vocIdKey){
		  return Long.parseLong(preferences.getValue(vocIdKey,"0"));
	  }
	
	  protected  Object[] validateRetrieveCatIds(int sheetNo,int rowNo,Map<String,String>rmap){
		  XSLErrorField error = null;
		//  long catIds[] = new long[catIdslength];
		  List<Long>catIds = new ArrayList<Long>();
		  List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		  String categoryName;
		  for(XSLColumn clmn:columnList){
			  if(clmn.isCategoryField()){
				  categoryName = rmap.get(clmn.getName());
				  if(Utils.nullOrEmpty(categoryName)){
					  //catIds[index] = 0;
					  catIds.add(0l);
				  }else if(clmn.getName().toLowerCase().startsWith(TrademarksConstants.CC_P.toLowerCase())){
					  
					//  String value = rmap.get(clmn.getName());
					  long code = getClassCode(categoryName);
					  if(code > 0){
					//	  catIds[index] = Utils.getCategoryIdIgnoreCase(getVocId(clmn.getVocIdKey()),String.valueOf(code));
						  catIds.add(Utils.getCategoryIdIgnoreCase(getVocId(clmn.getVocIdKey()),String.valueOf(code)));
					  }
					  
					  if(Validator.isNotNull(categoryName) && code <= 0){
						  error = new XSLErrorField(sheetNo,rowNo,clmn.getName(), "Incorrect format or class code does not exist in the system");
						  errors.add(error);
					  }
				  }else{
					  try{
						//  catIds[index] = Utils.getCategoryIdIgnoreCase(getVocId(clmn.getVocIdKey()),categoryName);
						  long temp = Utils.getCategoryIdIgnoreCase(getVocId(clmn.getVocIdKey()),categoryName);
						  catIds.add(temp);
	//					  catIds[index] = Utils.getCategoryId(getVocId(clmn.getVocIdKey()),categoryName);
						  if(temp == 0){
							  error = new XSLErrorField(sheetNo,rowNo,clmn.getName(), String.format(FIELD_NOT_EXISTS_IN_SYSTEM_FORMAT, categoryName));
							  errors.add(error);
						  }
					  }catch(Exception ex){
						  error = new XSLErrorField(sheetNo,rowNo,clmn.getName(), String.format(FIELD_NOT_EXISTS_IN_SYSTEM_FORMAT, categoryName));
						  errors.add(error);
					  }
					  
				  }
				//  index = index + 1;
			  }
		  }
		  long catIdArray[] = Utils.getLongArray(catIds);
		  Object[] objs = new Object[]{errors,catIdArray};
		  return objs;
	  }
	  
	  protected long getClassCode(String value){
			long id = -1;
			try{
				if(Validator.isNotNull(value)){
					int separatorPos = value.indexOf(CLASS_CODE_SEPARATOR) ;
					if(separatorPos != -1){
						String codeStr = value.substring(0,separatorPos);
						id = GetterUtil.getLong(codeStr);
					}
				//	String str = value.substring(TrademarksConstants.CC_P.length());
				//	id = GetterUtil.getLong(str);
				} 
			}catch(Exception ex){
				_log.error("Error while parsing class codes " + ex.getMessage());
			}
			return id;
	  }
	  protected String  getClassCodeDesc(String value){
		  String desc= "";
		  try{
			  if(Validator.isNotNull(value)){
				  int separatorPos = value.indexOf(CLASS_CODE_SEPARATOR) ;
				  if(separatorPos != -1){
					  desc = value.substring(separatorPos +1);
				  }
			  } 
		  }catch(Exception ex){
			  _log.error("Error while parsing class codes " + ex.getMessage());
		  }
		  return desc;
	  }
	  private int getCatIdLength(){
		  int i = 0;
		  for(XSLColumn clmn: columnList){
			  if(clmn.isCategoryField()){
				  i = i + 1;
			  }
		  }
		  return i;
	  }
	  private int getDateFieldsLength(){
		  int i = 0;
		  for(XSLColumn clmn: columnList){
			  if(DATE.equalsIgnoreCase(clmn.getDataType())){
				  i = i + 1;
			  }
		  }
		  return i;
	  }
	
	  private  Object[] validateParseDates(int sheetNo,int rowNo,Map<String,String>rmap){
		  XSLErrorField error = null;
		  List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		  Date dates[] = new Date[dateFieldslength];
		  int index = 0 ;
		  String dateStr;
		  for(XSLColumn clmn: columnList){
			  if(DATE.equalsIgnoreCase(clmn.getDataType())){
				  dateStr = rmap.get(clmn.getName());
				  if(Utils.nullOrEmpty(dateStr)){
					  dates[index] = null;
				  }else{
					  try{
						  dates[index] = Utils.getDate4rDDMMYYYY(dateStr);
					  }catch(Exception ex){
						  error = new XSLErrorField(sheetNo,rowNo,clmn.getName(),String.format(FIELD_NOT_VALID_FORMAT, dateStr));
						  errors.add(error);
					  }
				  }
				  index = index + 1;
			  }
		  }
		  Object[] objs = new Object[]{errors,dates};
		  return objs;
	  }
	  
	  private static String getCellValue(Cell cell,String expectedType){
			String value = "";
			if(cell != null){
				if(DATE.equalsIgnoreCase(expectedType)){
					try{
						if (Cell.CELL_TYPE_NUMERIC == cell.getCellType() && DateUtil.isCellDateFormatted(cell)) {
							Date date = cell.getDateCellValue();
							value = Utils.getDateStrddMMYYYY(date);
						}else{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							value = cell.getStringCellValue();	
						}
					}catch(Exception ex){
						cell.setCellType(Cell.CELL_TYPE_STRING);
						value = cell.getStringCellValue();	
					}
				}else{
					cell.setCellType(Cell.CELL_TYPE_STRING);
					value = cell.getStringCellValue();
				}
			}
			if(Validator.isNotNull(value)){
				value = value.trim();
			}
			 return value;
		}
	  public static HSSFWorkbook readFileXls(InputStream inputStream) throws IOException {
			return new HSSFWorkbook(inputStream);
		}

		public static XSSFWorkbook readFileXlsx(InputStream inputStream) throws IOException {
			return new XSSFWorkbook(inputStream);
		}
}
