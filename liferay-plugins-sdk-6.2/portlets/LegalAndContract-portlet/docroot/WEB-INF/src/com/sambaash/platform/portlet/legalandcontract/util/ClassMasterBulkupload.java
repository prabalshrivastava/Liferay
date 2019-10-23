package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.srv.legalandcontract.service.ClassMasterLocalServiceUtil;

public class ClassMasterBulkupload extends BulkUpload {

	private ClassMaster latestClassInDb ;
	public ClassMasterBulkupload(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		super(request, response);
	}
	
	protected void init(){
		
		XSLColumn clmn = new XSLColumn(ClassMasterConstants.CLASS_CODE_COLUMN, true, STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.COUNTRY_COLUMN, true,STRING,true,ClassMasterConstants.COUNTRY_VOC_ID);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.DESCRIPTION_COLUMN, true,STRING,true,ClassMasterConstants.DESCRIPTION_VOC_ID);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.FILED_BY_COLUMN, true,STRING,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.CUSTOM_FIELD_1_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.CUSTOM_FIELD_2_COLUMN, false,STRING,LegalConstants.TEXT_FIELD_LENGTH);
		columnList.add(clmn);
	
		clmn = new XSLColumn(ClassMasterConstants.CUSTOM_DATE_1_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.CUSTOM_DATE_2_COLUMN, false,DATE,LegalConstants.NOT_APPLICABLE_LENGTH);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.CUSTOM_LIST_1_COLUMN, false,STRING,true,ClassMasterConstants.CUSTOM_LIST_1_VOC_ID);
		columnList.add(clmn);
		
		clmn = new XSLColumn(ClassMasterConstants.CUSTOM_LIST_2_COLUMN, false,STRING,true,ClassMasterConstants.CUSTOM_LIST_2_VOC_ID);
		columnList.add(clmn);
	}

	@Override
	protected Object fillModel(Map<String, String> rmap, Date[] dates,Object extra) throws Exception {
		String code = rmap.get(ClassMasterConstants.CLASS_CODE_COLUMN);
		String country = rmap.get(ClassMasterConstants.COUNTRY_COLUMN);
		latestClassInDb = ClassMasterLocalServiceUtil.getLatestClassByCodeCountry(code, country);
		ClassMaster cm = ClassMasterLocalServiceUtil.getNewClassMaster();
		cm.setCountry(country);
		cm.setCode(code);
		cm.setFiledBy(rmap.get(ClassMasterConstants.FILED_BY_COLUMN));
		cm.setCustomField1(rmap.get(ClassMasterConstants.CUSTOM_FIELD_1_COLUMN));
		cm.setCustomField2(rmap.get(ClassMasterConstants.CUSTOM_FIELD_2_COLUMN));
		cm.setCustomDate1(dates[0]);
		cm.setCustomDate2(dates[1]);
		cm.setGroupId(serviceContext.getScopeGroupId());
		cm.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		
		return cm;
	}

	@Override
	protected Object addorUpdate(Map<String, String> rmap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isNew(Object obj) {
		boolean isNew = false;
		if(latestClassInDb == null){
			isNew = true;
		}
		return isNew;
	}

	@Override
	protected void add(Object obj, long[] catIds,Object extra) throws Exception {
		ClassMasterLocalServiceUtil.addNewClass(themeDisplay.getUserId(), (ClassMaster)obj, catIds);
	}

	@Override
	protected void update(Object obj, long[] catIds,Object extra) throws Exception {
		ClassMaster newCm = (ClassMaster)obj;
		ClassMaster oldCm = latestClassInDb;
		ClassMasterLocalServiceUtil.addNewClassVersion(themeDisplay.getUserId(),oldCm,newCm, catIds);
	}

	@Override
	protected XSLErrorField isDuplicate(int sheetNo,int rowNo,List validRows, Map<String, String> rmap) {
		ClassMaster tempcm;
		String code = rmap.get(ClassMasterConstants.CLASS_CODE_COLUMN);
		String country = rmap.get(ClassMasterConstants.COUNTRY_COLUMN);
		XSLErrorField error = null;
		for (int i=0; i<validRows.size();i++) {
			tempcm = (ClassMaster)validRows.get(i);
			 if(code.equals(tempcm.getCode() ) && country.equals(tempcm.getCountry())){
				 error = new XSLErrorField(sheetNo,rowNo,ClassMasterConstants.CLASS_CODE_COLUMN + ", " + ClassMasterConstants.COUNTRY_COLUMN,String.format(ClassMasterConstants.CLASS_DUPLICATE_ROW_FORMAT, code,country));
				 break; 
			 }
		}
		return error;
	}

}
