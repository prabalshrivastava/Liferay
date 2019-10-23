package com.sambaash.platform.pe.course.enroll;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jsp.PEJSPHelper;

public class CourseEnrollEntranceTestJSPHelper extends PEJSPHelper{

	private JSONObject params; 

	private CourseEnrollEntranceTestJSPHelper(PEDataSource ds, PEJSP jspNode){
		super(ds,jspNode);
	}
	
	private void initParams(String dataStr){
		try {
			params = JSONFactoryUtil.createJSONObject(dataStr);
		} catch (JSONException e) {
			_log.error(e);
		}
	}
	
	public static CourseEnrollEntranceTestJSPHelper getInstance(PEDataSource ds, PEJSP jspNode){
		return new CourseEnrollEntranceTestJSPHelper(ds, jspNode);
	}
	
	/**
	 *  Method used to get the data submitted by user.
	 *  //Entrance Test does not have any data to persist..
	 * @return
	 */
	public String getData(){
		String data = StringPool.BLANK;
		return data;
	}
	
	// No validations
	private String validate(){
		return StringPool.BLANK;
	}
	
	public PESimpleOutput save() throws PEException{
		// Audit
		audit(getData());
		PESimpleOutput output = new PESimpleOutput();
		return output;
	}
	
	public boolean isExternalDataSubmission(){
		return true;
	}

	public void setForceSubmit(){
		ds.setForceSubmit(true);
	}

	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollEntranceTestJSPHelper.class);
}
