package com.sambaash.gu.custom.uploader;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.gu.helper.GUConstants;
import com.sambaash.gu.helper.GUEntityHelper;
import com.sambaash.gu.helper.GUModal;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.helper.GUUploadHelper;
import com.sambaash.gu.helper.GUWBHelper;
import com.sambaash.gu.msg.GUMsgHelper;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

//Startup profile project status
public class GUStartupContactUploader extends GUCustomUploader{

	private static Log _log = LogFactoryUtil.getLog(GUStartupContactUploader.class);
	public GUStartupContactUploader(long companyId, long groupId,
			User logedInUser, Workbook wb, GUModal modal, GUMsgHelper msgHelper) {
		super(companyId, groupId, logedInUser, wb, modal, msgHelper);
	}

	@Override
	public void upload() {
		_log.error("This is not supposed to be executed. `");
		
	}
	public boolean isCustomUpload() {
		return false;
	}

	@Override
	public Set<Integer> getSuccessRowSet() {
		return successRowSet;
	}
	private static final String ORG_NAME = "organizationId";
	private static final String ORG_CONTACT_FIRSTNAME = "firstName";
	private static final String ORG_CONTACT_LASTNAME = "lastName";
	private static final String ORG_CONTACT_EMAILID = "emailId";
	private static final String ORG_CONTACT_MOBILE = "mobile";
	private static final String ORG_CONTACT_DESIGNATION = "designation";
	private static final String ORG_CONTACT_PRIMARYCONTACT = "primaryContact";
	
	private static final String VIDEO_LINKS = "videoLinks";
	
	public boolean validate(){
		boolean valid = true;
		Map<String, String> duplicateEmailIndex = new HashMap<String, String>();
		Map<String, String> duplicatePrimary = new HashMap<String, String>();
		
		Sheet sheet = wb.getSheet(modal.getSheetName());
		String sheetName = modal.getSheetName();
		final Map<String, GUField> fields = modal.getFieldsMap();
		_log.error(fields);
		
		_log.error(" Inside Organization contact upload...");
		
		
		outer:for(int rn = 2 ; rn <= sheet.getLastRowNum(); rn++){
			Row row = sheet.getRow(rn);
			if(GUWBHelper.isRowEmpty(row)) {
				//msgHelper.createMsg("Empty row. Ignoring the row " ,sheetName,rn);
				continue;
			}
			GUField fieldEmail = modal.getField(ORG_CONTACT_EMAILID);
			GUField fieldStartup = modal.getField(ORG_NAME);
			GUField fieldPrimary = modal.getField(ORG_CONTACT_PRIMARYCONTACT);
			String entityIdEmail = rowHelper.getCellValue(row, fieldEmail);
			String entityIdStr = row.getCell(0).getStringCellValue();
			String entityIdPrimary = rowHelper.getCellValue(row, fieldPrimary);
			
			_log.error(fieldStartup.getClmnName() + " : " + row.getCell(0));
			if(duplicateEmailIndex.containsKey(entityIdStr+entityIdEmail)) {
				msgHelper.createError("Duplicate contact exists = " + entityIdEmail, sheetName,row.getRowNum() ,fieldEmail.getClmnName() );
				continue;
			}
			if(duplicatePrimary.containsKey(entityIdStr+entityIdPrimary)) {
				msgHelper.createError("Duplicate primary contact exists = " + entityIdStr, sheetName,row.getRowNum() ,fieldEmail.getClmnName() );
				continue;
			}
			duplicateEmailIndex.put(entityIdStr+entityIdEmail, entityIdEmail);
			if("TRUE".equalsIgnoreCase(entityIdPrimary)) {
				duplicatePrimary.put(entityIdStr+entityIdPrimary, entityIdStr);
			}
			
			
		}
		
		
		
		return valid;
	}
}
