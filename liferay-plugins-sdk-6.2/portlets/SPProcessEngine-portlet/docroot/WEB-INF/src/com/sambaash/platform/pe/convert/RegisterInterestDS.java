package com.sambaash.platform.pe.convert;

import java.io.File;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.course.enroll.CourseEnrollRegisterInterestJSPHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;

public class RegisterInterestDS  extends PEDS{

	private PEDataSource ds;
	private PEJSP jspNode;
	private JSONObject data = null;
	
	private static Log _log = LogFactoryUtil.getLog(RegisterInterestDS.class
			.getName());
	
	public RegisterInterestDS(PEDataSource ds, PEJSP node){
		this.ds = ds;
		this.jspNode = node;
		configue();
	}
	
	private void configue(){
		CourseEnrollRegisterInterestJSPHelper helper = CourseEnrollRegisterInterestJSPHelper.getInstance(ds, jspNode);
		String dataStr = helper.getData();
		try {
				data = JSONFactoryUtil.createJSONObject(dataStr);
		} catch (JSONException e) {
				data  = JSONFactoryUtil.createJSONObject();
		}
	}
	
	public String getValue(String id){
		if(!data.has(id)){
			// for the fields stored in process state like country, ministie url, purposet etc..
			return ds.getDataFromProcessState(id);
		}
		return data.getString(id);
	}
	
	public File getFile(String id){
		FileEntry fileEntry = getFileEntryByFieldId(id);
		File file = null;
		if(fileEntry != null){
			file = storeFileLocally(fileEntry);
		}
		return file;
	}
}
