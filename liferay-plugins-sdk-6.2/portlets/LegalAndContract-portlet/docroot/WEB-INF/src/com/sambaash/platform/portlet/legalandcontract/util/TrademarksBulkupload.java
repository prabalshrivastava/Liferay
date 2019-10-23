package com.sambaash.platform.portlet.legalandcontract.util;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.search.TrademarksSearch;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.util.PermissionUtil;

public class TrademarksBulkupload extends BulkUpload {
	private Trademarks latestinDb;

	public TrademarksBulkupload(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		super(request, response);
	}
	
	protected void init(){
		
		XSLColumn clmn = new XSLColumn(TrademarksConstants.REGISTRATION_NO_COLUMN, false, STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.COUNTRY_COLUMN, true,STRING,true,TrademarksConstants.COUNTRY_VOC_ID);
		columnList.add(clmn);
	
		clmn = new XSLColumn(TrademarksConstants.TRADEMARK_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);		
		
		clmn = new XSLColumn(TrademarksConstants.TRADEMARK_TYPE_COLUMN, true,STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(TrademarksConstants.TRADEMARK_IN_ENGLISH, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(TrademarksConstants.STATUS_COLUMN, false,STRING,true,TrademarksConstants.STATUS_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.APPLICATION_NO_COLUMN, true,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(TrademarksConstants.APPLICATION_DATE_COLUMN, false,DATE ,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.FIRST_REG_DATE_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.RENEWAL_ALERT_BEFORE_COLUMN, false,INTEGER,true,TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.EXPIRY_DATE_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
	
		clmn = new XSLColumn(TrademarksConstants.REMARKS_COLUMN,false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN,false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);

		clmn = new XSLColumn(TrademarksConstants.AGENCY_NUMBER_COLUMN,false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.AGENCY_COUNTRY_COLUMN,false,STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
	
		clmn = new XSLColumn(TrademarksConstants.ACTIVE_INGREDIANTS_COLUMN,false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.INTERNATIONAL_REG_NUM_COLUMN,false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.HISTORY_COLUMN,false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.PRIORITY_DATE_COLUMN,false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);

		clmn = new XSLColumn(TrademarksConstants.REGISTERED_OWNER_COLUMN,false,STRING,true,TrademarksConstants.REGISTERED_OWNER_VOC_ID);
		columnList.add(clmn);
		
		/*clmn = new XSLColumn(TrademarksConstants.CUSTOM_DATE_2_COLUMN,false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.CUSTOM_DATE_3_COLUMN,false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn); 
		clmn = new XSLColumn(TrademarksConstants.CUSTOM_LIST_2_COLUMN,false,STRING,true,TrademarksConstants.CUSTOM_LIST_2_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(TrademarksConstants.CUSTOM_LIST_3_COLUMN,false,STRING,true,TrademarksConstants.CUSTOM_LIST_3_VOC_ID);
		columnList.add(clmn); 
		*/
		long classCodeVocId = GetterUtil.getLong(preferences.getValue(TrademarksConstants.CLASS_CODE_VOC_ID, "0"));
		List<AssetCategory>list = Utils.getCategories(classCodeVocId);
		//TODO: change the size
		for (int i = 1 ; i <= list.size() ; i++) {
			String clmName = String.format(TrademarksConstants.CC_P_FORMAT,String.valueOf(i) );
			clmn = new XSLColumn(clmName,false,STRING,true,TrademarksConstants.CLASS_CODE_VOC_ID);
			columnList.add(clmn); 
		}
		
	}
	protected List<XSLErrorField> extraValidations(int sheetNo,int rowNo,List validRows,Map<String,String>rmap){
		// Validating Law Firm (Agency) details
		List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		String anumber = rmap.get(TrademarksConstants.AGENCY_NUMBER_COLUMN);
		String acountry = rmap.get(TrademarksConstants.AGENCY_COUNTRY_COLUMN);
		User loginUser = themeDisplay.getUser();
		
		XSLErrorField error = null;
		if(Validator.isNotNull(anumber) && Validator.isNotNull(acountry)){
			Agency agency = AgencyLocalServiceUtil.getLatestAgencyByNumberCountry(anumber, acountry);
			if(agency == null){
				error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.AGENCY_NUMBER_COLUMN + ", " + TrademarksConstants.AGENCY_COUNTRY_COLUMN,String.format(TrademarksConstants.AGENCY_ERROR_NAME_COUNTRY, anumber,acountry));
				errors.add(error);
			}
		} 
		else if(Validator.isNotNull(anumber) && Validator.isNull(acountry)){
			error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.AGENCY_NUMBER_COLUMN + ", " + TrademarksConstants.AGENCY_COUNTRY_COLUMN,"Company Registration Number is present but Law Firm Country is empty. Provide both or none");
			errors.add(error);
		}
		else if(Validator.isNotNull(acountry) && Validator.isNull(anumber)){
			error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.AGENCY_NUMBER_COLUMN + ", " + TrademarksConstants.AGENCY_COUNTRY_COLUMN,"Law Firm Country is present but Company Registration Number is empty. Provide both or none");
			errors.add(error);
		}
		String applicationNo = rmap.get(TrademarksConstants.APPLICATION_NO_COLUMN);
		// Validating Trademark Type 
		String tmType = rmap.get(TrademarksConstants.TRADEMARK_TYPE_COLUMN);
		if(TrademarksConstants.WORD.equalsIgnoreCase(tmType)){
			String tm = rmap.get(TrademarksConstants.TRADEMARK_COLUMN);
			String tmInLatin = rmap.get(TrademarksConstants.TRADEMARK_IN_ENGLISH);
			if(Validator.isNull(tm)){
				error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.TRADEMARK_COLUMN , "Trademark Type is word but corresponding trademark is empty.");
				errors.add(error);
			}else{
				boolean nonEnglishFound = Utils.checkNonEnglishChars(tm);
				if(nonEnglishFound){
					if(Validator.isNull(tmInLatin)){
						error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.TRADEMARK_IN_ENGLISH , "Non-Latin characters found in Trademark but corresponding Latin Translation not provided.");
						errors.add(error);
					}else{
						nonEnglishFound = Utils.checkNonEnglishChars(tmInLatin);
						if(nonEnglishFound){
							error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.TRADEMARK_IN_ENGLISH , "Non-Latin character found in this field. Enter only Latin characters.");
							errors.add(error);
						}
					}
				}
			}
		}else if(TrademarksConstants.LOGO.equalsIgnoreCase(tmType) && Validator.isNotNull(applicationNo)){
			try{
				PermissionUtil.initializeAdminPermissionChecker();
			}catch(Exception ex){
				_log.error("Error while initialize admin permission checker " + ex.getMessage());
				return errors;
			}
			boolean logoFound = false;
			String srcPath = LegalConstants.BULK_UPLOAD_FOLDER_NAME + "/" + TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME ;
			Folder srcFolder = null;
			try {
				 srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, srcPath, 
						LegalConstants.FOLDER, false, false, false);
			} catch (Exception e) {
			}
			String logoFormat = String.format(LOGO_FORMAT, applicationNo);
			if(Validator.isNotNull(srcFolder)){
				try {
					List<DLFileEntry> feList = Utils.getDLFileEntries(logoFormat,srcFolder.getFolderId());
					if(Validator.isNotNull(feList) && !feList.isEmpty()){
						logoFound = true;
					}
				/*	List<FileEntry>list = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), srcFolder.getFolderId());
					for (FileEntry fileEntry : list) {
						String title = fileEntry.getTitle();
						if(title.startsWith(logoFormat)){
							logoFound = true;
						}
					} */
				} catch (Exception e) {
				}
				
			}else{
				
			}
			
			if(!logoFound){
				 error = new XSLErrorField(sheetNo,rowNo, TrademarksConstants.TRADEMARK_TYPE_COLUMN , "Trademark Type is logo. But corresponding Logo does not exists. Logo name exptected to start with " +  logoFormat);
				 errors.add(error);
			}
			
			try{
				PermissionUtil.resetPermissionChecker(loginUser);;
			}catch(Exception ex){
				_log.error("Error while resetting admin permission checker " + ex.getMessage());
			}
			
		} 
		
		if( Validator.isNotNull(tmType) && ! (TrademarksConstants.WORD.equalsIgnoreCase(tmType) ||  TrademarksConstants.LOGO.equalsIgnoreCase(tmType) )){
			 error = new XSLErrorField(sheetNo,rowNo, TrademarksConstants.TRADEMARK_TYPE_COLUMN , "Trademark Type can be either logo or word.Any other value will not be accepted");
			 errors.add(error);
		}
	
		String country = rmap.get(TrademarksConstants.COUNTRY_COLUMN);
		if(Validator.isNotNull(country)){
			long countryVocId = Long.parseLong(preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "0"));
			long countryId = Utils.getCategoryIdIgnoreCase(countryVocId,country);
			if(countryId > 0){
				long userId  = themeDisplay.getUserId();
				long scopeGroupId = themeDisplay.getScopeGroupId();
				LegalPermissionUtil lpu = new LegalPermissionUtil();
				boolean permissiond = lpu.checkPermissionForUserOnCountry(userId, scopeGroupId,countryVocId, country);
				if(!permissiond){
					error = new XSLErrorField(sheetNo,rowNo, TrademarksConstants.COUNTRY_COLUMN , String.format(TrademarksConstants.USER_UNAUTHORIZED_ON_COUNTRY, country));
					errors.add(error);
				} 
			}
		}
		
		if(Validator.isNotNull(applicationNo)){
			if(applicationNo.contains("\n")){
				error = new XSLErrorField(sheetNo,rowNo, TrademarksConstants.APPLICATION_NO_COLUMN , NEW_LINE_CHAR_ERROR);
				errors.add(error);
			}
		}
		return errors;
	}
	
	@Override
	protected Object fillModel(Map<String, String> rmap, Date[] dates,Object extra) throws Exception {
		String regNum = rmap.get(TrademarksConstants.REGISTRATION_NO_COLUMN);
		String applicationNo = rmap.get(TrademarksConstants.APPLICATION_NO_COLUMN);
		String country = rmap.get(TrademarksConstants.COUNTRY_COLUMN);
//		latestinDb = TrademarksLocalServiceUtil.getLatestTrademarksByNumberCountry(regNum, country);
		latestinDb = TrademarksLocalServiceUtil.getLatestTrademarksByApplicationNoCountry(applicationNo, country);
		Trademarks trademarks;// = TrademarksLocalServiceUtil.getNewTrademarks();
		trademarks = TrademarksLocalServiceUtil.getNewTrademarks();
		trademarks.setApplicationNo(applicationNo);
		trademarks.setCountry(country);
		trademarks.setRegistrationNumber(regNum);
		String tmType = GetterUtil.getString(rmap.get(TrademarksConstants.TRADEMARK_TYPE_COLUMN));
		trademarks.setTrademarkType(tmType.toLowerCase());
		if(TrademarksConstants.WORD.equalsIgnoreCase(tmType)){
			String tm = rmap.get(TrademarksConstants.TRADEMARK_COLUMN);
			trademarks.setTrademark(tm);
			boolean nonEnglish = Utils.checkNonEnglishChars(tm);
			if(nonEnglish){
				trademarks.setTrademarkLocalized(rmap.get(TrademarksConstants.TRADEMARK_IN_ENGLISH));
			}else{
				trademarks.setTrademarkLocalized(StringPool.BLANK);
			}
		}else{
			trademarks.setTrademark(StringPool.BLANK);
			trademarks.setTrademarkLocalized(StringPool.BLANK);
		}
		trademarks.setRegisteredOwner(rmap.get(TrademarksConstants.REGISTERED_OWNER_COLUMN));
		trademarks.setApplicationDate(dates[0]);
		trademarks.setFirstRegistrationDate(dates[1]);
		trademarks.setRenewalDate(dates[2]);
		//trademarks.setGoodsServices(rmap.get(TrademarksConstants.GOODS_SERVICES_COLUMN));
		trademarks.setPendingComments(rmap.get(TrademarksConstants.REMARKS_COLUMN));
		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
		if(authorized){
			trademarks.setLegalConfRemarks(rmap.get(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN));
		}
		try{
			String anumber = rmap.get(TrademarksConstants.AGENCY_NUMBER_COLUMN);
			String acountry = rmap.get(TrademarksConstants.AGENCY_COUNTRY_COLUMN);
			if(Validator.isNotNull(anumber) && Validator.isNotNull(acountry)){
				Agency agency = AgencyLocalServiceUtil.getLatestAgencyByNumberCountry(anumber, acountry);
				if(Validator.isNotNull(agency)){
					trademarks.setSpAgencyId(agency.getRootSpAgencyId());
				}
			}
		}catch(Exception ex){
			
		}
		
		trademarks.setCustomField1(rmap.get(TrademarksConstants.ACTIVE_INGREDIANTS_COLUMN));
		trademarks.setCustomField2(rmap.get(TrademarksConstants.INTERNATIONAL_REG_NUM_COLUMN));
		trademarks.setCustomField3(rmap.get(TrademarksConstants.HISTORY_COLUMN));
		/*Date now = new Date();
		if(Validator.isNull(dates[3])){
			dates[3] = now;
		}
		if(Validator.isNull(dates[4])){
			dates[4] = now;
		}
		if(Validator.isNull(dates[5])){
			dates[5] = now;
		}*/
		trademarks.setCustomDate1(dates[3]);
		//trademarks.setCustomDate2(dates[4]);
		//trademarks.setCustomDate3(dates[5]);
		
		trademarks.setGroupId(serviceContext.getScopeGroupId());
		trademarks.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		
		Set<String>keys = rmap.keySet();
		JSONObject data ; 
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for(String key: keys){
			try{
				String value = rmap.get(key);
				if(key.toLowerCase().startsWith(TrademarksConstants.CC_P.toLowerCase()) && Validator.isNotNull(value) ){
					long code = getClassCode(value);
					if(code > 0){
					//	int separatorPos = value.indexOf(':') ;
						data = JSONFactoryUtil.createJSONObject();
						data.put(TrademarksConstants.CC_PREFIX, String.valueOf(code));
						data.put(TrademarksConstants.CC_SPEC_PREFIX, getClassCodeDesc(value));
						jsonArray.put(data);
					}
				}
				
			}catch(Exception ex){
				_log.error("Error while processing class code " + ex.getMessage());
			}
		}
		
		trademarks.setClassCodes(jsonArray.toString());
		return trademarks;
	}
	
	@Override
	protected Object addorUpdate(Map<String, String> rmap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isNew(Object obj) {
		boolean isNew = false;
		if(latestinDb == null){
			isNew = true;
		}
		return isNew;
	}

	@Override
	protected void add(Object obj, long[] catIds, Object extra) throws Exception {
		Trademarks trademark = (Trademarks)obj;
		trademark.setCountry(Utils.getCategoryName(catIds[0]));
		TrademarksLocalServiceUtil.addNewTrademarks(themeDisplay.getUserId(), (Trademarks)obj, catIds);
	}

	@Override
	protected void update(Object obj, long[] catIds,Object extra) throws Exception {
		Trademarks old = latestinDb;
		Trademarks newt = (Trademarks)obj;
		if(TrademarksConstants.LOGO.equalsIgnoreCase(old.getTrademarkType()) && TrademarksConstants.LOGO.equalsIgnoreCase(newt.getTrademarkType())){
			newt.setTrademark(old.getTrademark());
		}
		TrademarksLocalServiceUtil.addNewTrademarksVersion(themeDisplay.getUserId(),old, newt , catIds);
	}

	@Override
	protected XSLErrorField isDuplicate(int sheetNo,int rowNo,List validRows, Map<String, String> rmap) { 
		XSLErrorField error = null;
		Trademarks tempcm;
		String country = rmap.get(TrademarksConstants.COUNTRY_COLUMN);
		String number = rmap.get(TrademarksConstants.APPLICATION_NO_COLUMN);
		if(Validator.isNotNull(country) && Validator.isNotNull(number)){
			for (int i=0; i<validRows.size();i++) {
				tempcm = (Trademarks)validRows.get(i);
				if(number.equalsIgnoreCase(tempcm.getApplicationNo() ) && country.equalsIgnoreCase(tempcm.getCountry())){
					error = new XSLErrorField(sheetNo,rowNo,TrademarksConstants.APPLICATION_NO_COLUMN + ", " + TrademarksConstants.COUNTRY_COLUMN,String.format(TrademarksConstants.TRADEMARK_ALREADY_UPDATED_ROW_FORMAT, number,country));
					break; 
				}
			}
		}
		return error;
	}
	
	
	public XSLErrorField uploadFiles(int sheetNo,int rowNo,Object obj,Map<String,String>rmap){
		XSLErrorField error = null;
		User loginUser = themeDisplay.getUser();
		try{
			PermissionUtil.initializeAdminPermissionChecker();
		}catch(Exception ex){
			_log.error("Error while initialize admin permission checker " + ex.getMessage());
			return error;
		}
		Trademarks trademark = (Trademarks)obj;
		String srcPath = LegalConstants.BULK_UPLOAD_FOLDER_NAME + "/" + TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME ; 
		String trademarkFName = TrademarksSearch.getTrademarksFolderName(trademark.getRootSpTrademarksId());
		String trademarksFPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/" + TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME  + "/" +
				trademarkFName;
		String logoPath = trademarksFPath + "/" + TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS;
		String attachmentPath = trademarksFPath + "/" + TrademarksConstants.FOLDER_NAME_ATTACHEMENTS;
		String confAttachPath = trademarksFPath + "/" + TrademarksConstants.FOLDER_NAME_CONF_ATTACHEMENTS;
		try {
			Folder srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, srcPath, 
						LegalConstants.FOLDER, false, false, false);
			if(Validator.isNotNull(srcFolder)){
				Folder logoF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, logoPath, 
						LegalConstants.FOLDER, false, true, true);

				Folder attachF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, attachmentPath, 
						LegalConstants.FOLDER, false, true, true);
				
				Folder confAttacF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, confAttachPath, 
						LegalConstants.FOLDER, false, true, true);
				
				FilesUpload fu = new FilesUpload(loginUser.getUserId(), actionRequest);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						DLFileEntry.class.getName(), actionRequest);
				String logoFormat = String.format(LOGO_FORMAT, trademark.getApplicationNo());//"logo_" + trademark.getApplicationNo();
				String attachFormat = String.format(FILE_FORMAT, trademark.getApplicationNo()); //"file_" + trademark.getApplicationNo();
				String confFormat = String.format(CONF_FILE_FORMAT, trademark.getApplicationNo());//"confidential_" + trademark.getApplicationNo();
				
				//Logo
				try{
					if(TrademarksConstants.LOGO.equalsIgnoreCase(trademark.getTrademarkType())){
						List<DLFileEntry>logos = Utils.getDLFileEntries(logoFormat, srcFolder.getFolderId());
						if(!logos.isEmpty()){
							DLFileEntry logo = logos.get(0);
							String logoTitle = getFileTitle(logo.getTitle(), logoFormat.length());
							logoTitle = logoTitle.replace("logo_", "");
							fu.updateTrademarkLogo(themeDisplay.getCompanyId(),serviceContext, themeDisplay.getScopeGroupId(), logoF.getFolderId(), logoTitle, logoTitle , logo.getSize(), logo.getContentStream());
							trademark.setTrademark(logoTitle);
							trademark.setTrademarkLocalized(StringPool.BLANK);
							TrademarksLocalServiceUtil.updateTrademarks(trademark);
							TrademarksLocalServiceUtil.reIndex(trademark);
						}
					}
				}catch(Exception ex){
					_log.error("Error while uploading logo " + logoFormat + ex.getMessage());
				}
				
				// File Attachments
				try{
					List<DLFileEntry>files = Utils.getDLFileEntries(attachFormat, srcFolder.getFolderId());
					for (DLFileEntry file : files) {
						String title = getFileTitle(file.getTitle(), attachFormat.length());
						fu.addOrUpadateFile(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), attachF.getFolderId(), title, 
								file.getMimeType(), file.getSize(), file.getContentStream(), serviceContext);
					}
				}catch(Exception ex){
					_log.error("Error while uploading files " + attachFormat + ex.getMessage());
				}
				
				// Confidential Attchements
				boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(loginUser.getUserId());
				if(authorized){
					try{
						List<DLFileEntry>files = Utils.getDLFileEntries(confFormat, srcFolder.getFolderId());
						for (DLFileEntry file : files) {
							String title = getFileTitle(file.getTitle(), confFormat.length());
							fu.addOrUpadateFile(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), confAttacF.getFolderId(), title, 
									file.getMimeType(), file.getSize(), file.getContentStream(), serviceContext);
						}
					}catch(Exception ex){
						_log.error("Error while uploading files " + attachFormat + ex.getMessage());
					}
				}
				
			
 				fu.updateFileEntries(logoF.getFolderId());
 				fu.updateFileEntries(attachF.getFolderId());
 				fu.updateFileEntries(confAttacF.getFolderId());
			}
		} catch (Exception e) {
			_log.error("Error while moving agency files " + e.getMessage() );
		}
		
		try{
			PermissionUtil.resetPermissionChecker(loginUser);;
		}catch(Exception ex){
			_log.error("Error while resetting admin permission checker " + ex.getMessage());
		}
		
		return error;
		
	}
	
	private static String getFileTitle(String title,int offset){
		String destFileTitle = title;
		if(title.length() <= offset + 1){
			destFileTitle  = title;
		}else{
			destFileTitle  = title.substring(offset + 1);;
		}
		if(destFileTitle.charAt(0) == '.'){
			destFileTitle  = title;
		}
		return destFileTitle;
	}
	
	public XSLErrorField uploadFilesOld(int sheetNo,int rowNo,Object obj,Map<String,String>rmap){
		XSLErrorField error = null;
		User loginUser = themeDisplay.getUser();
		try{
			PermissionUtil.initializeAdminPermissionChecker();
		}catch(Exception ex){
			_log.error("Error while initialize admin permission checker " + ex.getMessage());
			return error;
		}
		Trademarks trademark = (Trademarks)obj;
		String srcPath = LegalConstants.BULK_UPLOAD_FOLDER_NAME + "/" + TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME ; 
		String trademarkFName = TrademarksSearch.getTrademarksFolderName(trademark.getRootSpTrademarksId());
		String trademarksFPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/" + TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME  + "/" +
				trademarkFName;
		String logoPath = trademarksFPath + "/" + TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS;
		String attachmentPath = trademarksFPath + "/" + TrademarksConstants.FOLDER_NAME_ATTACHEMENTS;
		String confAttachPath = trademarksFPath + "/" + TrademarksConstants.FOLDER_NAME_CONF_ATTACHEMENTS;
		try {
			Folder srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, srcPath, 
					LegalConstants.FOLDER, false, false, false);
			if(Validator.isNotNull(srcFolder)){
				Folder logoF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, logoPath, 
						LegalConstants.FOLDER, false, true, true);
				
				Folder attachF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, attachmentPath, 
						LegalConstants.FOLDER, false, true, true);
				
				Folder confAttacF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, confAttachPath, 
						LegalConstants.FOLDER, false, true, true);
				
				FilesUpload fu = new FilesUpload(loginUser.getUserId(), actionRequest);
				List<FileEntry>list = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), srcFolder.getFolderId());
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						DLFileEntry.class.getName(), actionRequest);
				String logoFormat = String.format(LOGO_FORMAT, trademark.getApplicationNo());//"logo_" + trademark.getApplicationNo();
				String attachFormat = String.format(FILE_FORMAT, trademark.getApplicationNo()); //"file_" + trademark.getApplicationNo();
				String confFormat = String.format(CONF_FILE_FORMAT, trademark.getApplicationNo());//"confidential_" + trademark.getApplicationNo();
				
				
				String title;
				long destFolderId;
				String destFileTitle;
				int offset;
				for (FileEntry fileEntry : list) {
					title = fileEntry.getTitle();
					destFolderId = 0;
					offset = 0;
					if(title.startsWith(logoFormat)){
						destFolderId = logoF.getFolderId();
						offset = logoFormat.length();
					}else if(title.startsWith(attachFormat)){
						destFolderId = attachF.getFolderId();
						offset = attachFormat.length();
					}else if(title.startsWith(confFormat)){
						destFolderId = confAttacF.getFolderId();
						offset = confFormat.length();
					}
					if(destFolderId != 0){
						if(title.length() <= offset + 1){
							destFileTitle  = title;
						}else{
							destFileTitle  = title.substring(offset + 1);;
						}
						if(destFileTitle.charAt(0) == '.'){
							destFileTitle  = title;
						}
						
						if(title.startsWith(logoFormat)){
							destFileTitle = destFileTitle.replace("logo_", "");
							fu.updateTrademarkLogo(themeDisplay.getCompanyId(),serviceContext, themeDisplay.getScopeGroupId(), destFolderId, destFileTitle, fileEntry.getTitle(), fileEntry.getSize(), fileEntry.getContentStream());
							try{
								if(TrademarksConstants.LOGO.equalsIgnoreCase(trademark.getTrademarkType())){
									trademark.setTrademark(destFileTitle);
									trademark.setTrademarkLocalized(StringPool.BLANK);
									TrademarksLocalServiceUtil.updateTrademarks(trademark);
									TrademarksLocalServiceUtil.reIndex(trademark);
								}
								DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
							}catch(Exception ex){
								
							}
						}else{
							fu.moveFileEntry(srcFolder.getFolderId(), destFolderId, fileEntry, serviceContext,destFileTitle);
						}
					}
				}
				fu.updateFileEntries(logoF.getFolderId());
				fu.updateFileEntries(attachF.getFolderId());
				fu.updateFileEntries(confAttacF.getFolderId());
			}
		} catch (Exception e) {
			_log.error("Error while moving agency files " + e.getMessage() );
		}
		
		try{
			PermissionUtil.resetPermissionChecker(loginUser);;
		}catch(Exception ex){
			_log.error("Error while resetting admin permission checker " + ex.getMessage());
		}
		
		return error;
		
	}
	
	void saveInsertedFiles(Workbook wb, Map<String,String>rmap){
		if(Validator.isNull(wb)){
			return;
		}
		HSSFWorkbook hw = null;
		if(wb instanceof HSSFWorkbook){
			hw = (HSSFWorkbook)wb;
		}else{
			XSSFWorkbook xwb = (XSSFWorkbook)wb;
			
			try{
				List<PackagePart>list  = xwb.getAllEmbedds();
				if(!list.isEmpty()){
					String country = rmap.get(TrademarksConstants.COUNTRY_COLUMN);
					String number = rmap.get(TrademarksConstants.APPLICATION_NO_COLUMN);
					String folderName = TrademarksSearch.getTrademarksFolderName("");
					long folderIds[] = TrademarksSearch.getFolderIds(actionRequest,folderName);
					
					String name = "";//"menarini.";
					for (PackagePart packagePart : list) {
						for (PackagePart pPart : xwb.getAllEmbedds()) {
							String contentType = pPart.getContentType();
							PackagePartName pname = pPart.getPartName();
							name = pname.getName();
							name = name.substring(name.lastIndexOf("/")+1);
							// Excel Workbook - either binary or OpenXML
							if (contentType.equals("application/vnd.ms-excel")) {
							//	HSSFWorkbook embeddedWorkbook = new HSSFWorkbook(pPart.getInputStream());
								//name = name + "xsl";
							}
							// Excel Workbook - OpenXML file format
							else if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
							//	OPCPackage docPackage = OPCPackage.open(pPart.getInputStream());
							//	XSSFWorkbook embeddedWorkbook = new XSSFWorkbook(docPackage);
								//name = name + ".xslx";
							}
							// Word Document - binary (OLE2CDF) file format
							else if (contentType.equals("application/msword")) {
							//	HWPFDocument document = new HWPFDocument(pPart.getInputStream());
							}
							// Word Document - OpenXML file format
							else if (contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
								
							}
							// PowerPoint Document - binary file format
							else if (contentType.equals("application/vnd.ms-powerpoint")) {
							//	HSLFSlideShow slideShow = new HSLFSlideShow(pPart.getInputStream());
							}
							// PowerPoint Document - OpenXML file format
							else if (contentType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
							//	OPCPackage docPackage = OPCPackage.open(pPart.getInputStream());
							//	XSLFSlideShow slideShow = new XSLFSlideShow(docPackage);
							}


							
							FileEntry fileEntry;
							InputStream inputStream = pPart.getInputStream();
							ServiceContext serviceContext = ServiceContextFactory.getInstance(
									DLFileEntry.class.getName(), actionRequest);
							try{
								DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),
										folderIds[0], name, contentType, name,
										StringPool.BLANK, StringPool.BLANK,
										inputStream, 800,
										serviceContext);
								
							}catch(Exception ex){

								fileEntry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(),
										folderIds[0], name);
								DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(),false);
								if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
									fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
									DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
								}
								try{
									fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(
											fileEntry.getFileEntryId(),
											fileEntry.getTitle(), "application/msword",
											name, "", "", true, inputStream,
											500, serviceContext);
								}catch(FileSizeException fs){
									_log.error(fs);
								}catch(Exception ex1){
								   _log.error(ex1);
								}
								_log.error(ex.getMessage(), ex);
							}
						}
					}
				}
				
			}catch(Exception ex){
				
			}
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(TrademarksBulkupload.class.getName());
	private static String LOGO_FORMAT = "logo_%s" ;
	private static String FILE_FORMAT = "file_%s" ;
	private static String CONF_FILE_FORMAT = "confidential_%s";
}
