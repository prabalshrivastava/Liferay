package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.search.LitigationSearch;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.util.PermissionUtil;

public class LitigationBulkupload extends BulkUpload {

	private Litigation latestLitigationIndb;
	public LitigationBulkupload(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		super(request, response);
	}
	
	protected void init(){
		
		XSLColumn clmn = new XSLColumn(LitigationConstants.TRADEMARK_APP_NUMBER_COLUMN, true, STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.COUNTRY_COLUMN, true,STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.PROCEEDING_TYPE_COLUMN, false,STRING,true,LitigationConstants.PROCEEDING_TYPE_VOC_ID);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.FILED_BY_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.FILED_ON_COLUMN, false, DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);

		//clmn = new XSLColumn(LitigationConstants.FILED_AT_COUNTRY_COLUMN, true,STRING,true,LitigationConstants.FILED_AT_COUNTRY_VOC_ID);
		//columnList.add(clmn);

		clmn = new XSLColumn(LitigationConstants.CLAIMS_REMARKS_COLUMN, false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN,false,STRING,LegalConstants.UNLIMITED_LENGTH);
		columnList.add(clmn);

		//clmn = new XSLColumn(LitigationConstants.RESPONSE_DEADLINE_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
	//	columnList.add(clmn);

	//	clmn = new XSLColumn(LitigationConstants.ALERT_BEFORE_COLUMN, false,INTEGER, true, LitigationConstants.ALERT_BEFORE_VOC_ID);
	//	columnList.add(clmn);

		//clmn = new XSLColumn(LitigationConstants.ACTUAL_RESPONSE_COLUMN, true,DATE);
		//columnList.add(clmn);

		clmn = new XSLColumn(LitigationConstants.STATUS_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);

		
		clmn = new XSLColumn(LitigationConstants.FILES_COLUMN, false,STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.CONFIDENTIAL_FILES_COLUMN, false,STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		
		clmn = new XSLColumn(LitigationConstants.LAW_FIRM_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.THRID_PARTY_APP_NUMBER_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);

	/*	clmn = new XSLColumn(LitigationConstants.CUSTOM_FIELD_3_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
	
		clmn = new XSLColumn(LitigationConstants.CUSTOM_DATE_1_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.CUSTOM_DATE_2_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);

		clmn = new XSLColumn(LitigationConstants.CUSTOM_DATE_3_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.CUSTOM_LIST_1_COLUMN, false,STRING,true,LitigationConstants.CUSTOM_LIST_1_VOC_ID);
		columnList.add(clmn);
		
		clmn = new XSLColumn(LitigationConstants.CUSTOM_LIST_2_COLUMN, false,STRING,true,LitigationConstants.CUSTOM_LIST_2_VOC_ID);
		columnList.add(clmn);

		clmn = new XSLColumn(LitigationConstants.CUSTOM_LIST_3_COLUMN, false,STRING,true,LitigationConstants.CUSTOM_LIST_3_VOC_ID);
		columnList.add(clmn); */
		
		
	}

	@Override
	protected Object fillModel(Map<String, String> rmap, Date[] dates,Object extra) throws Exception {
		String regNum = rmap.get(LitigationConstants.TRADEMARK_APP_NUMBER_COLUMN);
		String country = rmap.get(LitigationConstants.COUNTRY_COLUMN);
		Trademarks tm = TrademarksLocalServiceUtil.getLatestTrademarksByApplicationNoCountry(regNum, country);
		
		//TODO:
		latestLitigationIndb = null;//LitigationLocalServiceUtil.getLatestLitigationByTrademarkRegNumberCountry(regNum, country);//findByTrademarkRegNumberCountry(code, country);
		Litigation litigation = LitigationLocalServiceUtil.getNewLitigation();
		litigation.setSpTrademarksId(tm.getRootSpTrademarksId());;
		litigation.setCountry(tm.getCountry());
		litigation.setFiledBy(rmap.get(LitigationConstants.FILED_BY_COLUMN));
		litigation.setFiledOn(dates[0]);
		litigation.setClaimsRemarks(rmap.get(LitigationConstants.CLAIMS_REMARKS_COLUMN));
		//litigation.setResponseDeadline(dates[1]);
		//litigation.setActualResponseDate(dates[2]);
		litigation.setStatus(rmap.get(LitigationConstants.STATUS_COLUMN));
		litigation.setCustomField1(rmap.get(LitigationConstants.LAW_FIRM_COLUMN));
		litigation.setCustomField2(rmap.get(LitigationConstants.THRID_PARTY_APP_NUMBER_COLUMN));
/*		litigation.setCustomField3(rmap.get(LitigationConstants.CUSTOM_FIELD_3_COLUMN));
		litigation.setCustomDate1(dates[1]);
		litigation.setCustomDate2(dates[2]);
		litigation.setCustomDate3(dates[3]); */
		litigation.setGroupId(serviceContext.getScopeGroupId());
		litigation.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		
		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
		if(authorized){
			litigation.setLegalConfRemarks(rmap.get(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN));
		}
		
		return litigation;
	}

	@Override
	protected Object addorUpdate(Map<String, String> rmap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isNew(Object obj) {
		boolean isNew = false;
		if(latestLitigationIndb == null){
			isNew = true;
		}
		return isNew;
	}

	@Override
	protected void add(Object obj, long[] catIds,Object extra) throws Exception {
		LitigationLocalServiceUtil.addNewLitigation(themeDisplay.getUserId(), (Litigation)obj, catIds);
		addRDLs(extra, (Litigation)obj);
	}

	private void addRDLs(Object extra,Litigation litigation){
		if(Validator.isNotNull(extra)){
			List<Map<String,Object>> rawlist = (List<Map<String,Object>>)extra;
			 for (Map<String, Object> map : rawlist) {
				 try{
					 RDL rdl = RDLLocalServiceUtil.getNewRDL();
					 rdl.setResponseDeadline((Date)map.get(LitigationConstants.RESPONSE_DEADLINE));
					 rdl.setAlertBefore((Long)map.get(LitigationConstants.ALERT_BEFORE));
					 rdl.setClaimsRemarks((String)map.get(LitigationConstants.CLAIMS_REMARKS));
					 rdl.setSpLitigationId(litigation.getSpLitigationId());
					 rdl.setGroupId(litigation.getGroupId());
					 RDLLocalServiceUtil.addRDL(rdl, themeDisplay.getUserId(), new long[]{rdl.getAlertBefore()});
				 }catch(Exception ex){
					_log.error("Error while adding rdl " + ex.getMessage()); 
				 }
				}
		}
	}
	@Override
	protected void update(Object obj, long[] catIds,Object extra) throws Exception {
		Litigation newl = (Litigation)obj;
		Litigation oldl =  latestLitigationIndb;
		
		LitigationLocalServiceUtil.addNewLitigationVersion(themeDisplay.getUserId(), oldl, newl, catIds);
		addRDLs(extra, newl);
	}

	@Override
	protected XSLErrorField isDuplicate(int sheetNo,int rowNo,List validRows, Map<String, String> rmap) {
		//TODO: have to check the duplcate logic
	/*	Litigation tempcm;
		String regNum = rmap.get(LitigationConstants.TRADEMARK_REG_NUMBER_COLUMN);
		String country = rmap.get(LitigationConstants.COUNTRY_COLUMN);
		XSLErrorField error = null;
		for (int i=0; i<validRows.size();i++) {
			tempcm = (Litigation)validRows.get(i);
			 if(regNum.equals(tempcm.getTrademarkRegNumber() ) && country.equals(tempcm.getCountry())){
				 error = new XSLErrorField(sheetNo,rowNo,LitigationConstants.TRADEMARK_REG_NUMBER_COLUMN + ", " + LitigationConstants.COUNTRY_COLUMN,String.format(LitigationConstants.LITIGATION_DUPLICATE_ROW_FORMAT, regNum,country));
				 break; 
			 }
		}*/
		XSLErrorField error = null;
		String applicationNo = rmap.get(LitigationConstants.TRADEMARK_APP_NUMBER_COLUMN);
		String country = rmap.get(LitigationConstants.COUNTRY_COLUMN);
		if(Validator.isNotNull(applicationNo) && Validator.isNotNull(country)){
			Trademarks tm = TrademarksLocalServiceUtil.getLatestTrademarksByApplicationNoCountry(applicationNo, country);
			if(Validator.isNull(tm)){
				error = new XSLErrorField(sheetNo,rowNo,LitigationConstants.TRADEMARK_APP_NUMBER_COLUMN + ", " + LitigationConstants.COUNTRY_COLUMN,String.format(LitigationConstants.TRADEMARK_NOT_EXISS_ROW_FORMAT, applicationNo,country));
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
		Litigation litigation = (Litigation)obj;
		String srcPath = LegalConstants.BULK_UPLOAD_FOLDER_NAME + "/" + LitigationConstants.LITIGATION_ROOT_FOLDER_NAME ; 
		String litigationFName = LitigationSearch.getLitigationFolderName(litigation.getSpLitigationId());
		String litigationFPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/" + LitigationConstants.LITIGATION_ROOT_FOLDER_NAME  + "/" + litigationFName;
		String attachmentPath = litigationFPath + "/" + LitigationConstants.FOLDER_NAME_ATTACHEMENTS;
		String confAttachPath = litigationFPath + "/" + LitigationConstants.FOLDER_NAME_CONF_ATTACHEMENTS;
		try {
			Folder srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, srcPath, 
						LegalConstants.FOLDER, false, false, false);
			if(Validator.isNotNull(srcFolder)){
//				List<FileEntry>list = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), srcFolder.getFolderId());
				
				
				Folder attachF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, attachmentPath, 
						LegalConstants.FOLDER, false, true, true);
				
				Folder confAttacF = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, confAttachPath, 
						LegalConstants.FOLDER, false, true, true);
				
				FilesUpload fu = new FilesUpload(loginUser.getUserId(), actionRequest);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						DLFileEntry.class.getName(), actionRequest);
				String filesStr = rmap.get(LitigationConstants.FILES_COLUMN);
				if(Validator.isNotNull(filesStr)){
					String files[] = filesStr.split(",");
					for(String name:files){
						name = GetterUtil.getString(name).trim();
						if(Validator.isNotNull(name)){
							try{
								FileEntry fe = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), srcFolder.getFolderId(), name);
								//fu.moveFileEntry(srcFolder.getFolderId(), attachF.getFolderId(), fe, serviceContext, name);
								fu.addOrUpadateFile(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), attachF.getFolderId(), name, 
										fe.getMimeType(), fe.getSize(), fe.getContentStream(), serviceContext);
							}catch(NoSuchFileEntryException fex){
							}
							catch(Exception ex){
								
							}
						}
					}
					fu.updateFileEntries(attachF.getFolderId());
				}

				// Confidential Attchements
				boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(loginUser.getUserId());
				if(authorized){
					String confFilesStr = rmap.get(LitigationConstants.CONFIDENTIAL_FILES_COLUMN);
					if(Validator.isNotNull(confFilesStr)){
						String files[] = confFilesStr.split(",");
						for(String name:files){
							name = GetterUtil.getString(name).trim();
							if(Validator.isNotNull(name)){
								try{
									FileEntry fe = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), srcFolder.getFolderId(), name);
									//fu.moveFileEntry(srcFolder.getFolderId(), confAttacF.getFolderId(), fe, serviceContext, name);
									fu.addOrUpadateFile(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), confAttacF.getFolderId(), name, 
											fe.getMimeType(), fe.getSize(), fe.getContentStream(), serviceContext);
								}catch(Exception ex){
								}
							}
						}
						fu.updateFileEntries(confAttacF.getFolderId());
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
	
	protected List<XSLErrorField> extraValidations(int sheetNo,int rowNo,List validRows,Map<String,String>rmap){
		XSLErrorField error = null;
		List<XSLErrorField>errors = new ArrayList<XSLErrorField>();
		User loginUser = themeDisplay.getUser();
		try{
			PermissionUtil.initializeAdminPermissionChecker();
		}catch(Exception ex){
			_log.error("Error while initialize admin permission checker " + ex.getMessage());
			return errors;
		}
		String srcPath = LegalConstants.BULK_UPLOAD_FOLDER_NAME + "/" + LitigationConstants.LITIGATION_ROOT_FOLDER_NAME ; 
		try {
			Folder srcFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, srcPath, 
					LegalConstants.FOLDER, false, false, false);
			if(Validator.isNotNull(srcFolder)){
				String filesStr = rmap.get(LitigationConstants.FILES_COLUMN);
				String filesNotFound = "";
				if(Validator.isNotNull(filesStr)){
					String files[] = filesStr.split(",");
					for(String name:files){
						name = GetterUtil.getString(name).trim();
						if(Validator.isNotNull(name)){
							try{
								FileEntry fe = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), srcFolder.getFolderId(), name);
							}catch(NoSuchFileEntryException fex){
								filesNotFound = filesNotFound + ", " + name;
							}
							catch(Exception ex){
								
							}
						}
					}
				}
				
				String confFilesStr = rmap.get(LitigationConstants.CONFIDENTIAL_FILES_COLUMN);
				if(Validator.isNotNull(confFilesStr)){
					String files[] = confFilesStr.split(",");
					for(String name:files){
						name = GetterUtil.getString(name).trim();
						if(Validator.isNotNull(name)){
							try{
								FileEntry fe = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), srcFolder.getFolderId(), name);
							}catch(Exception ex){
								filesNotFound = filesNotFound + ", " + name;
							}
						}
					}
				}
				
				if(Validator.isNotNull(filesNotFound)){
					error = new XSLErrorField(sheetNo,rowNo,LitigationConstants.FILES_COLUMN + " or  " + LitigationConstants.CONFIDENTIAL_FILES_COLUMN,  "Files does not exists " + filesNotFound);
					errors.add(error);
				}
				
			}else{
				
			}
		} catch (Exception e) {
			_log.error("Error while doing file validations in litigaiton bulk upload " + e.getMessage() );
		}
		
		try{
			PermissionUtil.resetPermissionChecker(loginUser);;
		}catch(Exception ex){
			_log.error("Error while resetting admin permission checker " + ex.getMessage());
		}
		
	
		
		
		return errors;
		
	}
	
	protected Object[] extraProcessing(int sheetNo,int rowNo,  Map<String,String>rmap){
			  Object []objs = processRDLS(sheetNo, rowNo, rmap.get(LitigationConstants.CLAIMS_REMARKS_COLUMN));
		/*	 List<XSLErrorField>tempErrors = (List<XSLErrorField>)objs[0];
			 if(!tempErrors.isEmpty()){
				 errors.addAll(tempErrors);
			 }else{
				 List<Map<String,Object>>rdls = (List<Map<String,Object>>)objs[1];
				 for (Map<String, Object> map : rdls) {
					RDL rdl = RDLLocalServiceUtil.getNewRDL();
					rdl.set
				}
			 } */
			  return objs;
		
	}
	
	public  Object[] processRDLS(int sheetNo,int rowNo,String str) {
		XSLErrorField error;
		List<XSLErrorField>errors = new ArrayList<XSLErrorField>();
		List<Map<String , Object>> rdlList = new ArrayList<Map<String,Object>>();
		Map<String , Object> rdlMap;
		if(Validator.isNotNull(str)){
			// First split by line separator which 3 or more cap symbols
			String rdls[] = str.split("\\^\\^\\^(\\^)*");
			if(Validator.isNotNull(rdls)){
				//response deadlin
				String rd;
				// alert before
				String ab;
				//remarks
				String remarks;
				// First pipe position
				int fpp;
				// Second pipe position
				int spp;
				String rdlsub;
				for (String rdl : rdls) {
					try {
						_log.debug("processing rdl " + rdl);
						fpp = rdl.indexOf('|');
						rd = rdl.substring(0, fpp);
						if (rdl.charAt(fpp + 1) == '|') {
							ab = "";
							spp = fpp + 1;
							remarks = rdl.substring(spp + 1);
						} else {
							rdlsub = rdl.substring(fpp + 1);
							spp = rdlsub.indexOf('|');
							ab = rdlsub.substring(0, spp);
							remarks = rdlsub.substring(spp + 1);
						}
						
						if (!checkEscape('|', remarks)) {
							error = new XSLErrorField(sheetNo,rowNo,LitigationConstants.CLAIMS_REMARKS_COLUMN,  "Incorrect format.Either line separator missing(^^^) or not escaped the pipe symbol (|) in remarks. Check the record " + rdl);
							errors.add(error);
							_log.error("Incorrect format. Either line separator missing or not escaped the pipe");
						}
						if (!checkEscape('^', remarks)) {
							error = new XSLErrorField(sheetNo,rowNo,LitigationConstants.CLAIMS_REMARKS_COLUMN,  "Incorrect format.Not escaped the cap symbol(^) in remarks. Check the record " + rdl);
							errors.add(error);
							_log.error("Incorrect format. Escape the cap symbol.");
						}
						
						remarks = remarks.replaceAll("\\\\\\|", "|");
						remarks = remarks.replaceAll("\\\\\\^", "^");
						
						Date rdDate = null;
						long abCatId = 0l;
						try{
						  rdDate = Utils.getDate4rDDMMYYYY(rd.trim());
						}catch(Exception ex){
						  error = new XSLErrorField(sheetNo,rowNo,LitigationConstants.CLAIMS_REMARKS_COLUMN,
								  String.format(FIELD_NOT_VALID_FORMAT, rd) + " check Response Deadline in the record " + rdl + ". Date must follow dd/mm/yyyy format. Example:25/02/2003");
						  errors.add(error);
						}
					  
						if(Validator.isNotNull(ab)){
							try{
								long vocId = GetterUtil.getLong(preferences.getValue(LitigationConstants.ALERT_BEFORE_VOC_ID, ""));
								abCatId = Utils.getCategoryIdIgnoreCase(vocId,ab.trim());
								if(abCatId == 0){
									error = new XSLErrorField(sheetNo,rowNo, LitigationConstants.CLAIMS_REMARKS_COLUMN,
											"Given value " + ab +" for Alert Before does not exist in the system. Check alert before in  record " + rdl);
									errors.add(error);
								}else{
									//if alert before is there means, response deadline should present
									if(Validator.isNull(rd)){

										error = new XSLErrorField(sheetNo,rowNo, LitigationConstants.CLAIMS_REMARKS_COLUMN,
												"Response Deadline is required in the record " + rdl);
										errors.add(error);
									
									}
								}
								
							}catch(Exception ex){
								error = new XSLErrorField(sheetNo,rowNo, LitigationConstants.CLAIMS_REMARKS_COLUMN,
									"Given value " + ab +" for Alert Before does not exist in the system. Check alert before in  record " + rdl);
								errors.add(error);}
							
						}
						
						rdlMap = new HashMap<String, Object>();
						rdlMap.put(LitigationConstants.RESPONSE_DEADLINE, rdDate);
						rdlMap.put(LitigationConstants.ALERT_BEFORE, abCatId);
						rdlMap.put(LitigationConstants.CLAIMS_REMARKS, remarks);
						rdlList.add(rdlMap);
						  
						_log.error("'" + rd + "'");
						_log.error("'" + ab + "'");
						_log.error("'" + remarks + "'");
					} catch (Exception ex) {

						error = new XSLErrorField(sheetNo,rowNo, LitigationConstants.CLAIMS_REMARKS_COLUMN,
							"Incorrect format. Check the record " + rdl);
						errors.add(error);
					}

				}
				
			}
			
		}
		
		Object objs[ ] = new Object[]{
				errors,rdlList
		};
		return objs;
	}

	private static boolean checkEscape(char ch, String remarks) {
		boolean escaped = true;
		if (remarks != null) {
			for (int i = 0; i < remarks.length(); i++) {
				if (remarks.charAt(i) == ch) {
					if (i == 0) {
						escaped = false;
					} else {
						if (remarks.charAt(i - 1) != '\\') {
							escaped = false;
						}
					}

				}

			}
		}
		return escaped;
	}
	
	private static Log _log = LogFactoryUtil.getLog(LitigationBulkupload.class.getName());
}
