package com.sambaash.gu.custom.uploader;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.portlet.ResourceRequest;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.model.User;
import com.sambaash.gu.helper.GUModal;
import com.sambaash.gu.helper.GUUploadHelper;
import com.sambaash.gu.helper.GUWBHelper;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.msg.GUMsgHelper;

public abstract class GUCustomUploader {
	final long groupId ;
	final long companyId ;
	final User logedInUser;
	final Workbook wb;
	final GUModal modal;
	final GUMsgHelper msgHelper;
	final GUUploadHelper uploadHelper;
	final GUWBRowHelper rowHelper;
	final Set<Integer>successRowSet; 
	private ResourceRequest request;
	private Set<GUField> keys;
	private Map<String, GUModal> modalMap;
	private Map<String, Integer>mdClmnNameIndexMap ;
	
	public GUCustomUploader(long companyId, long groupId,User logedInUser,Workbook wb,GUModal modal,GUMsgHelper msgHelper	){
		this.companyId = companyId;
		this.groupId = groupId;
		this.logedInUser = logedInUser;
		this.msgHelper = msgHelper;
		this.wb = wb;
		this.modal = modal;
		this.uploadHelper = new GUUploadHelper(companyId, groupId, logedInUser);
		this.successRowSet = new LinkedHashSet<Integer>();
		this.rowHelper = createRowHelper();
	}
	
	private GUWBRowHelper createRowHelper(){
		Sheet sheet = wb.getSheet(modal.getSheetName());
		Row headerRow = sheet.getRow(0);
		Map<String, Integer> clmnIndexMap = GUWBHelper.getClmnIndexMap(headerRow);
		return new GUWBRowHelper(clmnIndexMap);
	}
	
	public abstract void upload();
	public abstract Set<Integer> getSuccessRowSet();
	
	public void afterUpload(){
		
	}
	public boolean validate(){
		return true;
	}
	public boolean isCustomUpload() {
		return true;
	}

	public ResourceRequest getRequest() {
		return request;
	}

	public void setRequest(ResourceRequest request) {
		this.request = request;
	}

	public Set<GUField> getKeys() {
		return keys;
	}

	public void setKeys(Set<GUField> keys) {
		this.keys = keys;
	}

	public Map<String, GUModal> getModalMap() {
		return modalMap;
	}

	public void setModalMap(Map<String, GUModal> modalMap) {
		this.modalMap = modalMap;
	}

	public Map<String, Integer> getMdClmnNameIndexMap() {
		return mdClmnNameIndexMap;
	}

	public void setMdClmnNameIndexMap(Map<String, Integer> mdClmnNameIndexMap) {
		this.mdClmnNameIndexMap = mdClmnNameIndexMap;
	}
}
