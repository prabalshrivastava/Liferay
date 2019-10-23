package com.sambaash.platform.pe.course.enroll;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jaxb.PEPreview;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.silanis.esl.sdk.EslClient;
import com.silanis.esl.sdk.PackageId;
import com.silanis.esl.sdk.SigningStatus;

public class CourseEnrollEsignHelper {
	

	public static String getServletTestKey(){
		return "XYZABC312BCSDIS!*@MIDSFQERASDF";
	}
	public static String getApiKey(PEDataSource ds){
		//return SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_ESIGN_API_KEY, 0);
		List<PEPreview> pePreviewList = ds.getDirectory().getProcessDefinition().getPreviews().getList();
		String apiKey = StringPool.BLANK;
		for (PEPreview pePreview : pePreviewList){
			if (Validator.isNotNull(pePreview.getEsignApiKey())){
				apiKey = pePreview.getEsignApiKey();
				break;
			}
		}
		return apiKey;
	}
	public static String getApiUrl(PEDataSource ds){
		//return SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_ESIGN_API_URL, 0);
		List<PEPreview> pePreviewList = ds.getDirectory().getProcessDefinition().getPreviews().getList();
		String apiUrl = StringPool.BLANK;
		for (PEPreview pePreview : pePreviewList){
			if (Validator.isNotNull(pePreview.getEsignApiUrl())){
				apiUrl = pePreview.getEsignApiUrl();
				break;
			}
		}
		return apiUrl;
	}

	public static String getWebPageUrl(PERequestData requestData){
		return requestData.getPortalUrl();
	}
	
	public static String getPackageName(User user){
		String format = "%s-%s-%s";
		return String.format(format, user.getFullName() ,user.getUserId(),(new SimpleDateFormat("HH:mm:ss")).format(DateUtil.newDate()));
	}
	
	public static String getSignerId(){
		String signerId = UUID.randomUUID().toString();
		return signerId;
	}
	
	public static String getHandOverLink(){
		return SambaashUtil.getParameter("esign.student.contract.handover.url", 0);
	}
	
	public static String getStatus(EslClient eslClient,CourseEnrollEsignInfo esignInfo){
		PackageId packageId = new PackageId(esignInfo.getPackageId());
		SigningStatus signingStatus = eslClient.getSigningStatus(packageId, null,null);
		return signingStatus.getToken();
	}
	
	public static void updateEsignInfo(CourseEnrollEsignInfo esignInfo, PERequestData requestData) throws SystemException{
		PEHelper.fillAudit(esignInfo, requestData, esignInfo.isNew());
		CourseEnrollEsignInfoLocalServiceUtil.updateCourseEnrollEsignInfo(esignInfo);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollEsignHelper.class);
}
