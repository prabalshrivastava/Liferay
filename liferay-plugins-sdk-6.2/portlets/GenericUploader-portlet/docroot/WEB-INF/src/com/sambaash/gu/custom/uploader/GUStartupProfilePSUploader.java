package com.sambaash.gu.custom.uploader;

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
public class GUStartupProfilePSUploader extends GUCustomUploader{

	private static Log _log = LogFactoryUtil.getLog(GUStartupProfilePSUploader.class);
	public GUStartupProfilePSUploader(long companyId, long groupId,
			User logedInUser, Workbook wb, GUModal modal, GUMsgHelper msgHelper) {
		super(companyId, groupId, logedInUser, wb, modal, msgHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upload() {

		final String sheetName = modal.getSheetName();
		if(Validator.isNull(sheetName)){
			return;
		}
		final Sheet sheet = wb.getSheet(sheetName);
		
		final String submodal  = GUUploadHelper.getSubModalName(modal.getName());
		
		final Map<String, GUField> fields = modal.getFieldsMap();
		Map<Long,Long>deleteDone = new LinkedHashMap<Long, Long>();
		outer:for(int rn = 2 ; rn <= sheet.getLastRowNum(); rn++){
			Row row = sheet.getRow(rn);
			if(GUWBHelper.isRowEmpty(row)) {
				//msgHelper.createMsg("Empty row. Ignoring the row " ,sheetName,rn);
				continue;
			}
			GUField field = null;
			try {
				field = modal.getField(ORG_NAME);
				String orgName = rowHelper.getCellValue(row, field);
				Organization org  = null;
				try {
					 org = OrganizationLocalServiceUtil.findByName(orgName);
				} catch (SystemException e) {
					_log.error(e);
				}
				
				if(org == null){
					msgHelper.createError("Organization does not exist with name: " + orgName, modal.getSheetName(),row.getRowNum(), field.getClmnName());
					continue;
				}			
				
				if(isProjectStatus(submodal)){
					if(modal.isDeleteThenCreate() && deleteDone.get(org.getOrganizationId()) == null){
						org.setProjectsWorkedOn(StringPool.BLANK);
					}
					deleteDone.put(org.getOrganizationId(), org.getOrganizationId());
					
					JSONArray projectsWorkedOnArr = JSONFactoryUtil.createJSONArray(org.getProjectsWorkedOn());
					JSONObject project = JSONFactoryUtil.createJSONObject();
					for (Entry<String,GUField> fieldEntry : fields.entrySet()) {
						field = fieldEntry.getValue();
						String cellValue = rowHelper.getCellValue(row, field);
						String valueToSave;
						if(Validator.isNotNull(field.getVocabName()) && Validator.isNotNull(cellValue)){
							try {
								AssetCategory catg = uploadHelper.getAssetCategory(field.getAssetVocabulary(), cellValue, field.isCreateCatg());
								valueToSave = String.valueOf(catg.getCategoryId());
							} catch (NoSuchCategoryException e) {
								msgHelper.createError("Asset Category is not found." + e.getMessage(),sheetName,row.getRowNum() ,field.getClmnName());
								continue outer;
							}
						}else{
							valueToSave = cellValue;
						}
						project.put(field.getFieldName(), valueToSave);
					}
					projectsWorkedOnArr.put(project);
					org.setProjectsWorkedOn(projectsWorkedOnArr.toString());
					OrganizationLocalServiceUtil.updateOrganization(org);
					msgHelper.createMsg("Success.Updated: Org Id: " + org.getOrganizationId() + " Name: " + org.getName(),sheetName,row.getRowNum());
					successRowSet.add(row.getRowNum());
				}
				
				if(isVideoLInks(submodal)){
					if(modal.isDeleteThenCreate() && deleteDone.get(org.getOrganizationId()) == null){
						org.setVideoLinks(StringPool.BLANK);
					}
					deleteDone.put(org.getOrganizationId(), org.getOrganizationId());
					
					JSONArray videoLinks = JSONFactoryUtil.createJSONArray(org.getVideoLinks());
					String values[] = rowHelper.getCellValues(row, modal.getField(VIDEO_LINKS));
					
					if(values != null){
						for (String link : values) {
							videoLinks.put(link);
						}
					}
					org.setVideoLinks(videoLinks.toString());
					OrganizationLocalServiceUtil.updateOrganization(org);
					msgHelper.createMsg("Success.Updated: Org Id: " + org.getOrganizationId() + " Name: " + org.getName(),sheetName,row.getRowNum());
					successRowSet.add(row.getRowNum());
				}
				
			} catch (Exception e) {
				msgHelper.createError("Error while processing row",sheetName,row.getRowNum() ,field != null ? field.getClmnName() : "");
				_log.error(e);
			}
		}
	}
	
	
	public boolean isProjectStatus(String submodal){
		return GUEntityHelper.ENTITY_STATUP_PROFILE_PS.equalsIgnoreCase(submodal);
	}
	public boolean isVideoLInks(String submodal){
		return GUEntityHelper.ENTITY_STATUP_PROFILE_VL.equalsIgnoreCase(submodal);
	}
	

	@Override
	public Set<Integer> getSuccessRowSet() {
		return successRowSet;
	}
	private static final String ORG_NAME = "organizationName";
	private static final String VIDEO_LINKS = "videoLinks";
	
	public boolean validate(){
		boolean valid = true;
		// Verify if Process Column column exists
		GUField fieldOrg = modal.getField(ORG_NAME);
		if(Validator.isNull(fieldOrg) || Validator.isNull(fieldOrg.getClmnName())){
			valid = false;
			msgHelper.createError("Required field is missing :" + ORG_NAME , GUConstants.SHEET_META_DATA);
		}else{
			Sheet sheet = wb.getSheet(modal.getSheetName());
			Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(sheet.getRow(0));
			String clmnName = fieldOrg.getClmnName();
			if(clmnIndexMap.get(clmnName) == null){
				valid = false;
				msgHelper.createError("Column does not exist in sheet:" + modal.getSheetName() , modal.getSheetName(),0, fieldOrg.getClmnName());
			}
		}
		
		final String submodal  = GUUploadHelper.getSubModalName(modal.getName());
		if(isVideoLInks(submodal)){
			GUField fieldVL = modal.getField(VIDEO_LINKS);
			if(fieldVL == null){
				msgHelper.createError("Required field is missing :" + VIDEO_LINKS , GUConstants.SHEET_META_DATA);
				valid = false;
			}
		}
		return valid;
	}
}
