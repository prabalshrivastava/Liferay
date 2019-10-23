package com.sambaash.platform.pe.course.enroll;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;

public class CourseEnrollEsignInfoHelper {

	
	public static CourseEnrollEsignInfo getEsignInfo(long processStateId,boolean create) throws SystemException{
		CourseEnrollEsignInfo esignInfo = null;
		try {
			esignInfo = CourseEnrollEsignInfoLocalServiceUtil.findByProcessStateId(processStateId);
		} catch (NoSuchCourseEnrollEsignInfoException e) {
			_log.error("Esign Info does not exist for processstateid="+processStateId);
			
			if(create){
				esignInfo = CourseEnrollEsignInfoLocalServiceUtil.create();
				esignInfo.setSpPEProcessStateId(processStateId);
			}
		}
		return esignInfo;
	}
	
	
	public static boolean isEsignInfoExists(long processStateId) throws SystemException{
		CourseEnrollEsignInfo info = getEsignInfo(processStateId, false);
		if(info == null || Validator.isNull(info.getSignerId()) && Validator.isNull(info.getPackageId()) && Validator.isNull(info.getDocumentId())){
			return false;
		}
		return true;
	}
	
	

	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollEsignInfoHelper.class);
	
}
