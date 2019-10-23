package com.sambaash.gu.custom.uploader;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.Node;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.gu.helper.GUConstants;
import com.sambaash.gu.helper.GUException;
import com.sambaash.gu.helper.GUModal;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.helper.GUUploadHelper;
import com.sambaash.gu.helper.GUWBHelper;
import com.sambaash.gu.msg.GUMsgHelper;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;
import com.sambaash.platform.util.SambaashHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

public class GUUserProfileUploader extends GUCustomUploader {

	private static Log _log = LogFactoryUtil.getLog(GUUserProfileUploader.class);
	
	private static final String BASIC_INFO = "basic_info";
	private static final String PERSONAL_INFO = "personal_info";
	private static final String AVAILABILITY_INFO = "availability_info";
	private static final String NETWORK_INFO = "network_info";
	private static final String CONTACT_INFO = "contact_info";
	
	final String FIRST_NAME = "first_name";
	final String LAST_NAME = "last_name";
	final String EMAIL_ADDRESS= "emailAddress";
	final String ROLES = "roles";
	final String STATUS = "status";
	
	Map<String, Role> rolesCache = new HashMap<String, Role>();
	
	public GUUserProfileUploader(long companyId, long groupId,
			User logedInUser, Workbook wb, GUModal modal, GUMsgHelper msgHelper) {
		super(companyId, groupId, logedInUser, wb, modal, msgHelper);
	}

	private String getFormName(){
		final String modalName = modal.getName();
		final String formName = modalName.substring( modalName.indexOf(GUConstants.MODAL_NAME_SEPARATOR) + 1);
		return formName;
	}
	Map<Long, SocialProfile> profilesToIndex = new LinkedHashMap<Long, SocialProfile>();
	@Override
	public void upload() {
		final String sheetName = modal.getSheetName();
		if(Validator.isNull(sheetName)){
			return;
		}
		final String formName = GUUploadHelper.getSubModalName(modal.getName());
		final Sheet sheet = wb.getSheet(sheetName);
		
		if(Validator.isNull(formName)){
			msgHelper.createError("Form name can not be blank",GUConstants.SHEET_META_DATA);
			return;	
		}
		
		Row headerRow = sheet.getRow(0);
		Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(headerRow);
		Map<String, GUField> fields = modal.getFieldsMap();

		
		GUField multiInstanceField = null;
		// Finding if configuration enabled for deleting  multi instance records 
		for (Entry<String,GUField> fieldEntry : fields.entrySet()) {
			GUField field = fieldEntry.getValue();
			if(field.isMultiInstance() && field.isDeleteCreateMultiInstance()){
				multiInstanceField = field;
				break;
			}
		}
		
		Map<Long,Long>deleteDone = new LinkedHashMap<Long, Long>();
		
		GUField fieldEmail = modal.getField(EMAIL_ADDRESS);
		// row 0 - header
		// row 1 - help text
		// row 2 - onwards data
		outer:for(int rn = 2 ; rn <= sheet.getLastRowNum(); rn++){
			Row row = sheet.getRow(rn);
			if(GUWBHelper.isRowEmpty(row)) {
				//msgHelper.createMsg("Empty row. Ignoring the row " ,sheetName,rn);
				continue;
			}
			boolean error = false;
			GUField field = null;
			try {
				//Curent modal is multiinstance type and user configured it to delete and recreate
				if(multiInstanceField != null){
					
				}
				User user = null;
				if(formName.equalsIgnoreCase(BASIC_INFO)){
					// Creat/fetch user , Adding roles, updating status (active/inactive) 
					user = createUser(row, clmnIndexMap);
					if(user == null){
						continue;
					}
				}else {
					String email = rowHelper.getCellValue(row, fieldEmail);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(fieldEmail.getClmnName())));
					try {
						user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
					} catch (Exception e) {
						msgHelper.createError("Error while retrieving user record. User may not exists in the system. Email: " + email,sheetName,row.getRowNum() ,fieldEmail.getClmnName());
						continue;
					}
				}
				SocialProfile socialProfile = null;
				try {
					socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
				} catch (NoSuchSocialProfileException e) {
					msgHelper.createError("Social Profile does not exist for user : " + user.getEmailAddress(),sheetName,row.getRowNum() );
					continue;
				}

				String userXml = socialProfile.getUserInfo();
				XMLManipulator manipulator = new XMLManipulator(userXml);
				
				if( !(formName.startsWith(PERSONAL_INFO) || 
						  formName.startsWith(BASIC_INFO) ||
						  formName.startsWith(AVAILABILITY_INFO) ||
						  formName.startsWith(CONTACT_INFO) )){
					if(modal.isDeleteThenCreate() && deleteDone.get(socialProfile.getUserId()) == null){
						String nodeXQuery ;
						if(formName.startsWith("workhistory")){
							 nodeXQuery = "//" + formName + "/"
									+ "work_details";
							 manipulator.removeAllNodes(nodeXQuery);
						}else if (formName.startsWith(NETWORK_INFO)){
							 manipulator.cleanupXMLNetworkInfo();
						}else{
							
							 nodeXQuery = "//" + formName + "/"
									+ formName + "_details";
							 manipulator.removeAllNodes(nodeXQuery);
						}
						
						msgHelper.createMsg("Deleted existing data for modal:" + modal.getName() + " for user : " + user.getEmailAddress() ,sheetName,row.getRowNum());
						socialProfile.setUserInfo(manipulator.toString(null));
						SocialProfileLocalServiceUtil.updateSocialProfile_No_Indexing(socialProfile);
					}
					deleteDone.put(socialProfile.getUserId(), socialProfile.getUserId());
				}
				
				String instance = "";
				for (Entry<String,GUField> fieldEntry : fields.entrySet()) {
					field = fieldEntry.getValue();
					String cellValue = StringPool.BLANK;
					String fieldName = field.getFieldName();
					if(EMAIL_ADDRESS.equalsIgnoreCase(fieldName)){
						continue;
					}
					if(Validator.isNotNull(field.getClmnName())){
						 cellValue = rowHelper.getCellValue(row, field);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(field.getClmnName())));
					}
					if(Validator.isNull(cellValue)){
						cellValue = field.getDefaultValue();
					}
					String valueToSave = StringPool.BLANK;
					
					if(Validator.isNotNull(field.getVocabName()) && Validator.isNotNull(cellValue)){
						try {
							AssetCategory catg = uploadHelper.getAssetCategory(field.getAssetVocabulary(), cellValue, field.isCreateCatg());
							valueToSave = cellValue;//String.valueOf(catg.getCategoryId());
						} catch (NoSuchCategoryException e) {
							msgHelper.createError("Asset Category is not found.",sheetName,row.getRowNum() ,field.getClmnName());
							error = true;
							continue;
						}
					} 
					else {
						valueToSave =  cellValue;
					}
					Node node = null;
					if(formName.startsWith(PERSONAL_INFO) || 
							  formName.startsWith(BASIC_INFO) ||
							  formName.startsWith(AVAILABILITY_INFO) ||
							  formName.startsWith(CONTACT_INFO)){
						
						 node = manipulator.selectNode(formName,field.getFieldName());
						 if ( Validator.isNotNull(valueToSave)) {
								_log.debug("Updating single instance node : "	+ fieldName);

								if (formName.startsWith("basic_info")
										&& "gender".equalsIgnoreCase(fieldName)) {
									if ("M".equalsIgnoreCase(valueToSave)
											|| "MALE".equalsIgnoreCase(valueToSave)) {
										valueToSave = "1";
									} else if ("F".equalsIgnoreCase(valueToSave)
											|| "FEMALE".equalsIgnoreCase(valueToSave)) {
										valueToSave = "0";
									}
								}

								manipulator.setNodeValue(valueToSave,
											"//" + formName + "/" 	+ fieldName);
								
							}
					}else if(formName.startsWith(NETWORK_INFO)){
						String[] valuesToSave = null;
						if(Validator.isNotNull(field.getClmnName())){
							valuesToSave = rowHelper.getCellValues(row, field);
						}
						
						for (String value : valuesToSave){
							manipulator.setNodeValue(value, formName + StringPool.SLASH + fieldName, fieldName, 0, 0);
						}
						
					}else{
						if(Validator.isNull(instance)){
							try {
								instance = manipulator.createXml(formName,fieldName);
							} catch (GUException e) {
								msgHelper.createError("Error while processing row. " + e.getMsg(),sheetName,row.getRowNum() ,field != null ? field.getClmnName() : "");
								_log.error(e);
								error = true;
								continue;
							}
						}
						String q  = "";
						if(formName.startsWith("workhistory")){
							 q  = "//" + formName + StringPool.SLASH + "work_details[@id='" + instance + "']/" + fieldName ;
						}else{
							 q  = "//" + formName + StringPool.SLASH + formName +"_details[@id='" + instance + "']/" + fieldName ;
						}
						
						node = manipulator.selectNode(q);
						node.setTextContent(SambaashHtmlUtil.escape(valueToSave));
					}
					
			/*		Node node = manipulator.selectNode(formName,field.getFieldName());
					if (Validator.isNull(node)) {
						if (!(formName.startsWith(PERSONAL_INFO) || 
							  formName.startsWith(BASIC_INFO) ||
							  formName.startsWith(AVAILABILITY_INFO) ||
							  formName.startsWith(NETWORK_INFO) || formName.startsWith(CONTACT_INFO))) {
							
							// other_details
							instance = manipulator.createXml(formName,fieldName);
						}
					} */
					
					// field is null means multi-instance node
					if (Validator.isNull(node)) {
						// Handle Contact info here
						if (formName.startsWith("contact_info")) {
							_log.debug("Updating contact_info node : " + formName);
							String nodeXQuery = "//contact_info/contact_details/" + fieldName;

							Node cNode = manipulator.selectNode(nodeXQuery);
							if (Validator.isNull(cNode)) {
								nodeXQuery = "//contact_info/contact_details/address_details/"	+ fieldName;
								cNode = manipulator.selectNode(nodeXQuery);
							}
							if (Validator.isNull(cNode)) {
								nodeXQuery = "//contact_info/contact_details/phone_details/" + fieldName;
							}

							manipulator.setNodeValue(valueToSave, nodeXQuery);

						} 
				/*		// Handle Work hisotry here
						else if (formName.startsWith("workhistory")
								&& field.isMultiInstance()
								&& Validator.isNotNull(valueToSave)) {
							_log.debug("Updating Work History, MultiInstance node : "	+ fieldName);
							String nodeXQuery = "//" + formName + "/work_details[@id='" + instance + "']/" + fieldName;
							manipulator.setNodeValue(valueToSave, nodeXQuery);
						} 
						// All Custome Multi-Instance data here
						else if (field.isMultiInstance()	&& Validator.isNotNull(valueToSave)) {
							_log.debug("Updating MultiInstance node : "	+ fieldName);
							String nodeXQuery = "//" + formName + "/"
									+ formName + "_details[@id='"
									+ instance + "']/" + fieldName;
							manipulator.setNodeValue(valueToSave, nodeXQuery);
						}  
						
						else {

							node = manipulator.selectNode(formName,fieldName	);
							if (Validator.isNotNull(node)) {
								manipulator.setNodeValue(valueToSave,
										"//" + formName + "/"
												+ fieldName);
							} else {
								_log.debug("Error in data or node "
										+ fieldName);
							}
						}*/
					}else if (Validator.isNotNull(node)) {
						
						// Updating single instance fields like basic_info , profile_info will take place here
						
						
					}
				}
				
				// No errors exist, so can save
				if(!error){
					socialProfile.setUserInfo(manipulator.toString(null));
					SocialProfileLocalServiceUtil.updateSocialProfile_No_Indexing(socialProfile);
					msgHelper.createMsg("Success.Updated.Id=" +user.getUserId() + ". Email : " + user.getEmailAddress(),sheetName,row.getRowNum());
					successRowSet.add(row.getRowNum());
					profilesToIndex.put(socialProfile.getUserId(), socialProfile);
				}
			} catch (Exception e) {
				_log.error(e);
				msgHelper.createError("Error while processing row",sheetName,row.getRowNum() ,field != null ? field.getClmnName() : "");	
			}
		}
		
	}
	
	/**
	 *  Creating/updating user with baisch details, First and Last name, email address and status.
	 *  Logs in case of errors
	 *  
	 *  Returns null in case create/update fails.
	 *  
	 * 
	 */
	private User createUser(Row row, Map<String, Integer> clmnIndexMap  ){
		GUField fieldFn = modal.getField(FIRST_NAME);
		GUField fieldLn = modal.getField(LAST_NAME);
		GUField fieldEmail = modal.getField(EMAIL_ADDRESS);
		GUField fieldRoles = modal.getField(ROLES);
		GUField fieldStatus = modal.getField(STATUS);
		
		String firstName = rowHelper.getCellValue(row, fieldFn);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(fieldFn.getClmnName())));
		String lastName =  rowHelper.getCellValue(row, fieldLn);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(fieldLn.getClmnName())));
		String emailAddress = rowHelper.getCellValue(row, fieldEmail);//GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(fieldEmail.getClmnName())));
		String status = rowHelper.getCellValue(row, fieldStatus);
		
		boolean error = false;
		if(Validator.isNull(firstName)){
			error = true;
			msgHelper.createError("First Name can not be blank",row.getSheet().getSheetName(),row.getRowNum(),fieldFn.getClmnName() );
		}
		if(Validator.isNull(lastName)){
			error = true;
			msgHelper.createError("Last Name can not be blank",row.getSheet().getSheetName(),row.getRowNum(),fieldLn.getClmnName());
		}
		if(Validator.isNull(emailAddress)){
			error = true;
			msgHelper.createError("Email Address can not blank",row.getSheet().getSheetName(),row.getRowNum(),fieldEmail.getClmnName() );
		}

		if( error){
			return null;
		}
		
		int statusFlag;
		try {
			statusFlag = getStatus(status);
		} catch (GUException e1) {
			msgHelper.createError(e1.getMessage(),row.getSheet().getSheetName(),row.getRowNum(),fieldEmail.getClmnName() );
			return null;
		}
		
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			_log.error("user already exists");
		} catch (NoSuchUserException nsue) {
			_log.error("Will create user : " + emailAddress);
			String apiKey = "cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==";
			user = SocialProfileServiceUtil.addUser(apiKey, firstName, lastName, emailAddress, "zaq12wsx",
					false);
			msgHelper.createMsg("User Created. UserId: " + user.getUserId() + " Email: " + user.getEmailAddress(),row.getSheet().getSheetName(),row.getRowNum() );
		} catch (PortalException | SystemException e) {
			msgHelper.createError("Error while creating/updating user",row.getSheet().getSheetName(),row.getRowNum() );
			return null;
		}
		
		try {
			// Find if there is change. Update user object only if there is change.
			if(! (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getEmailAddress().equals(emailAddress)
					&& user.getStatus() == statusFlag) ){
				_log.debug("Change in user details.So changes will be updated.");
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setLastLoginDate(new Date());
				user.setStatus(statusFlag);
				UserLocalServiceUtil.updateUser(user);
				msgHelper.createMsg("Change in FirstName/LastName/Status. Updated. UserId:" + user.getUserId() + " Email: " + user.getEmailAddress(),row.getSheet().getSheetName(),row.getRowNum() );
			}
		} catch (SystemException e) {
			msgHelper.createError("Error while creating/updating user",row.getSheet().getSheetName(),row.getRowNum() );
			return null;
		}
		
		try{
			String[] roleNames = rowHelper.getCellValues(row, fieldRoles);
			assignRoles(user, roleNames);
		} catch (GUException e) {
			_log.error(e);
			msgHelper.createError("Error while assigning roles to user : " + user.getEmailAddress(),row.getSheet().getSheetName(),row.getRowNum() );
			return null;
		} catch (PortalException | SystemException e) {
			_log.error(e);
			msgHelper.createError("Error while assigning roles to user : " + user.getEmailAddress(),row.getSheet().getSheetName(),row.getRowNum() );
			return null;
		} 
		
		return user;
	}
	
	public int getStatus(String status) throws GUException{
	    if(Validator.isNull(status) || "active".equalsIgnoreCase(status) ){
	    	return WorkflowConstants.STATUS_APPROVED;
	    }
	    
	    if("inactive".equalsIgnoreCase(status)){
	    	return WorkflowConstants.STATUS_INACTIVE;
	    }
	   
	    if("incomplete".equalsIgnoreCase(status)){
	    	return WorkflowConstants.STATUS_INCOMPLETE;
	    }

	    if("draft".equalsIgnoreCase(status)){
	    	return WorkflowConstants.STATUS_DRAFT;
	    }

	    throw new GUException("Invalid status : " + status);
	    
	}

	public void assignRoles(User user, String[]roleNames) throws PortalException, SystemException, GUException{
		if(roleNames == null){
			return;
		}
		for (String roleName : roleNames) {
			if(Validator.isNull(roleName)){
				continue;
			}
			roleName = roleName.trim();
			Role role = null;
			if (rolesCache.containsKey(roleName)) {
				role = rolesCache.get(roleName);
			} else {
				role = SambaashUtil.addRoleIfNotExist(companyId, roleName);
				if(role == null){
					throw new GUException("Error while getting/adding role : " + roleName);
				}
				rolesCache.put(roleName, role);
			}
			if (role != null) {
				_log.debug("Adding " + role.getName() + " role to "
						+ user.getEmailAddress());
				UserLocalServiceUtil.addRoleUsers(role.getRoleId(),
						new long[] { user.getUserId() });
			}
		}
	}
	
	public boolean validate(){
		boolean valid = true;
		Sheet sheet = wb.getSheet(modal.getSheetName());
		Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(sheet.getRow(0));

		// Verify if email Address column exists
		GUField fieldEmail = modal.getField(EMAIL_ADDRESS);
		if(fieldEmail == null){
			valid = false;
			msgHelper.createError("Required field is missing :" + EMAIL_ADDRESS , GUConstants.SHEET_META_DATA);
		}else{
			String clmnName = fieldEmail.getClmnName();
			if(clmnIndexMap.get(clmnName) == null){
				valid = false;
				msgHelper.createError("Column for Email Address  does not exist." , modal.getSheetName(),0, fieldEmail.getClmnName());
			}
		}

		
		String formName = GUUploadHelper.getSubModalName(modal.getName());
		// Validate basic info
		if(formName.startsWith(BASIC_INFO)){
			GUField fieldFn = modal.getField(FIRST_NAME);
			if(fieldFn == null){
				valid = false;
				msgHelper.createError("Required field is missing :" + FIRST_NAME , GUConstants.SHEET_META_DATA);
			}else{
				String clmnName = fieldFn.getClmnName();
				if(clmnIndexMap.get(clmnName) == null){
					valid = false;
					msgHelper.createError("Column for First Name does not exist" , modal.getSheetName(),0, fieldEmail.getClmnName());
				}
			}
			
			GUField fieldLn = modal.getField(LAST_NAME);
			if(fieldLn == null){
				valid = false;
				msgHelper.createError("Required field is missing :" + LAST_NAME , GUConstants.SHEET_META_DATA);
			}else{
				String clmnName = fieldLn.getClmnName();
				if(clmnIndexMap.get(clmnName) == null){
					valid = false;
					msgHelper.createError("Column for Last Name does not exist" , modal.getSheetName(),0, fieldEmail.getClmnName());
				}
			}
		}
		
		return valid;
	}

	public void afterUpload(){
		for (Entry<Long, SocialProfile> entry : profilesToIndex.entrySet()) {
			SocialProfile profile = entry.getValue();
			try {
				SocialProfileLocalServiceUtil.reIndex(profile);
			} catch (SearchException e) {
				_log.error(e);
				msgHelper.createError("Error while reindexing the social profile: UserId :" + profile.getUserId(), modal.getSheetName());
			}
		}
	}

	@Override
	public Set<Integer> getSuccessRowSet() {
		return successRowSet;
	}
}
