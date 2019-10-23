package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.search.AgencySearch;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.util.PermissionUtil;

public class AgencyBulkupload extends BulkUpload {

	private Agency latestAgencyInDB ;
	public AgencyBulkupload(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		super(request, response);
	}
	
	protected void init(){
		
		XSLColumn clmn = new XSLColumn(AgencyConstants.NUMBER_COLUMN, true, STRING, LegalConstants.TEXT_FIELD_LENGTH);
	
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.NAME_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);

		clmn = new XSLColumn(AgencyConstants.REFERENCE_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.START_DATE_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.END_DATE_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.COUNTRY_COLUMN, true, STRING,true,AgencyConstants.COUNTRY_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.TYPE_COLUMN, false,STRING,true,AgencyConstants.TYPE_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.ADDRESS_COLUMN, false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.REMARKS_COLUMN, false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.STATUS_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		/*clmn = new XSLColumn(AgencyConstants.CUSTOM_FIELD_1_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_FIELD_2_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_FIELD_3_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_DATE_1_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_DATE_2_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_DATE_3_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_LIST_1_COLUMN, false,STRING,true,AgencyConstants.CUSTOM_LIST_1_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_LIST_2_COLUMN, false,STRING,true,AgencyConstants.CUSTOM_LIST_2_VOC_ID);
		columnList.add(clmn);
		clmn = new XSLColumn(AgencyConstants.CUSTOM_LIST_3_COLUMN, false,STRING,true,AgencyConstants.CUSTOM_LIST_3_VOC_ID);
		columnList.add(clmn); */
	}
	
	protected List<XSLErrorField> extraValidations(int sheetNo,int rowNo,List validRows,Map<String,String>rmap){
		String country = rmap.get(AgencyConstants.COUNTRY_COLUMN);
		List<XSLErrorField> errors = new ArrayList<XSLErrorField>();
		XSLErrorField error = null;
		if(Validator.isNotNull(country)){
			long countryVocId = Long.parseLong(preferences.getValue(AgencyConstants.COUNTRY_VOC_ID, "0"));
			long countryId = Utils.getCategoryIdIgnoreCase(countryVocId,country);
			// If country exists then only validate about permissions.
			if(countryId > 0){
				long userId  = themeDisplay.getUserId();
				long scopeGroupId = themeDisplay.getScopeGroupId();
				LegalPermissionUtil lpu = new LegalPermissionUtil();
				boolean permissiond = lpu.checkPermissionForUserOnCountry(userId, scopeGroupId, countryVocId,country);
				if(!permissiond){
					error = new XSLErrorField(sheetNo,rowNo, AgencyConstants.COUNTRY_COLUMN , String.format(AgencyConstants.USER_UNAUTHORIZED_ON_COUNTRY, country));
					errors.add(error);
				}
			}
		}
		
		String number = rmap.get(AgencyConstants.NUMBER_COLUMN);
		if(Validator.isNotNull(number)){
			if(number.contains("\n")){
				error = new XSLErrorField(sheetNo,rowNo, AgencyConstants.NUMBER_COLUMN , NEW_LINE_CHAR_ERROR);
				errors.add(error);
			}
		}
		
		return errors; 
	}

	@Override
	protected Object fillModel(Map<String, String> rmap, Date[] dates,Object extra) throws Exception {
		String number = rmap.get(AgencyConstants.NUMBER_COLUMN);
		String country = rmap.get(AgencyConstants.COUNTRY_COLUMN);
		Agency agency = AgencyLocalServiceUtil.getLatestAgencyByNumberCountry(number, country);
		latestAgencyInDB = agency;
		agency = AgencyLocalServiceUtil.getNewAgency();
		agency.setNumber(number);
		agency.setCountry(country);
		agency.setName(rmap.get(AgencyConstants.NAME_COLUMN));
		agency.setReference(rmap.get(AgencyConstants.REFERENCE_COLUMN));
		agency.setStartDate(rmap.get(AgencyConstants.START_DATE_COLUMN));
		agency.setEndDate(rmap.get(AgencyConstants.END_DATE_COLUMN));
		agency.setAddress(rmap.get(AgencyConstants.ADDRESS_COLUMN));
		agency.setRemarks(rmap.get(AgencyConstants.REMARKS_COLUMN));
		agency.setStatus(rmap.get(AgencyConstants.STATUS_COLUMN));
	/*	agency.setCustomField1(rmap.get(AgencyConstants.CUSTOM_FIELD_1_COLUMN));
		agency.setCustomField2(rmap.get(AgencyConstants.CUSTOM_FIELD_2_COLUMN));
		agency.setCustomField3(rmap.get(AgencyConstants.CUSTOM_FIELD_3_COLUMN));
		agency.setCustomDate1(dates[0]);
		agency.setCustomDate2(dates[1]);
		agency.setCustomDate3(dates[2]); */
		
		agency.setGroupId(serviceContext.getScopeGroupId());
		agency.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		
		return agency;
	}

	@Override
	protected Object addorUpdate(Map<String, String> rmap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isNew(Object obj) {
		boolean isNew = false;
		if(latestAgencyInDB == null){
			isNew = true;
		}
		return isNew;
	}

	@Override
	protected void add(Object obj, long[] catIds,Object extra) throws Exception {
		AgencyLocalServiceUtil.addNewAgency(themeDisplay.getUserId(), (Agency)obj, catIds);
	}
	

	@Override
	protected void update(Object obj, long[] catIds,Object extra) throws Exception {
		AgencyLocalServiceUtil.addNewAgencyVersion(themeDisplay.getUserId(),latestAgencyInDB, (Agency)obj, catIds);
	}

	@Override
	protected XSLErrorField isDuplicate(int sheetNo,int rowNo,List validRows, Map<String, String> rmap) {
		Agency tempcm;
		String country = rmap.get(AgencyConstants.COUNTRY_COLUMN);
		String number = rmap.get(AgencyConstants.NUMBER_COLUMN);
		XSLErrorField error = null;
		if(Validator.isNotNull(country) && Validator.isNotNull(number)){
			for (int i=0; i<validRows.size();i++) {
				tempcm = (Agency)validRows.get(i);
				if(number.equals(tempcm.getNumber() ) && country.equals(tempcm.getCountry())){
					error = new XSLErrorField(sheetNo,rowNo,AgencyConstants.NUMBER_COLUMN + ", " + AgencyConstants.COUNTRY_COLUMN ,String.format(AgencyConstants.AGENCY_DUPLICATE_ROW_FORMAT, number,country));
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
		Agency agency = (Agency)obj;
		String srcPath = LegalConstants.BULK_UPLOAD_FOLDER_NAME + "/" + AgencyConstants.AGENCY_ROOT_FOLDER_NAME + "/" + 
						agency.getNumber();
		String agencyFName = AgencySearch.getAgencyFolderName(agency.getRootSpAgencyId());
		String destPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/" + AgencyConstants.AGENCY_ROOT_FOLDER_NAME + "/" +
						agencyFName;
		try {
			Folder srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, srcPath, 
						LegalConstants.FOLDER, false, false, false);
			if(Validator.isNotNull(srcFolder)){
				Folder destFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, destPath, 
						LegalConstants.FOLDER, false, true, true);
				FilesUpload fu = new FilesUpload(loginUser.getUserId(), actionRequest);
				
				List<FileEntry> list= DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), srcFolder.getFolderId());
				for (FileEntry file : list) {
					try{
						fu.addOrUpadateFile(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), destFolder.getFolderId(), file.getTitle(), 
								file.getMimeType(), file.getSize(), file.getContentStream(), serviceContext);
					}catch(Exception ex){
						_log.error("Error while copying agency file " + file.getFileEntryId() +  " " + file.getTitle() + " " + ex.getMessage());
					}
				}
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
		private static Log _log = LogFactoryUtil.getLog(AgencyBulkupload.class);
}
