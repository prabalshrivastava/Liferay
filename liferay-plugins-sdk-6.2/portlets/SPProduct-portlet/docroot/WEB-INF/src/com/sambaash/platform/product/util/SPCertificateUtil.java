package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPCertificateUtil {

	private static Log _log = LogFactoryUtil.getLog(SPCertificateUtil.class);

	public static JSONObject addCertificate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			_log.error("Adding Certificate");

			long certificateId = ParamUtil.getLong(resourceRequest, "spCertificatetId");
			boolean hasPermission = false;
			if(certificateId > 0){
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			}else{
			    // create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}
			
			if(!hasPermission){
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.noauth.add.certificate"));
				return response;
			}
			
			String certificateCode = resourceRequest.getParameter("certificateCode");
			String certificateDesc = resourceRequest.getParameter("certificateDesc");
			String certificateTitle = resourceRequest.getParameter("certificateTitle");
			String certificateFolderId = resourceRequest.getParameter("certificateFolderId");
			String certificateLevel = resourceRequest.getParameter("certificateLevel");
			String certificateType = resourceRequest.getParameter("certificateType");

			// check for Certificatecode uniqueness
			try {
				List<Certificate> existing = CertificateLocalServiceUtil.findByCertificateCode(certificateCode.trim());
				for (Certificate certificateExisting : existing) {
					if (certificateExisting.getSpCertificatetId() != certificateId) {
						response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.certificate.exist") + certificateCode + LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.unique.certificate"));
						return response;
					}
				}
			} catch (Exception e) {
							// it's new
			}

			Certificate certificate = null;

			if (certificateId > 0) {
				certificate = CertificateLocalServiceUtil.fetchCertificate(certificateId);
				certificate.setModifiedDate(DateUtil.newDate());
			} else {
				certificateId = CounterLocalServiceUtil.increment("Certificate.class");
				certificate = CertificateLocalServiceUtil.createCertificate(certificateId);
				certificate.setCreateDate(DateUtil.newDate());
				certificate.setCompanyId(themeDisplay.getCompanyId());
				certificate.setGroupId(themeDisplay.getScopeGroupId());
			}

			certificate.setUserId(themeDisplay.getUser().getUserId());
			certificate.setUserName(themeDisplay.getUser().getFullName());

			certificate.setTitle(certificateTitle);
			certificate.setDescription(certificateDesc);
			certificate.setCertificateCode(certificateCode);
			if (Validator.isNumber(certificateFolderId)) {
				certificate.setAttachmentFolderId(Long.parseLong(certificateFolderId));
				FileUtil.moveFolder(resourceRequest, themeDisplay, String.valueOf(certificate.getSpCertificatetId()),
						Long.parseLong(certificateFolderId), SPProductConstants.CERTIFICATE_FOLDER,
						SPProductConstants.CERTIFICATE_FOLDER);
			}
			certificate.setCertificateType(Long.parseLong(certificateType));
			certificate.setLevel(Long.parseLong(certificateLevel));

			CertificateLocalServiceUtil.updateCertificate(certificate);
			CertificateLocalServiceUtil.clearCache();

			response.put("saveFlag", "success");
			response.put("spCertificatetId", certificate.getSpCertificatetId());

		} catch (Exception e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.certificate.save.error"));
		}

		return response;

	}

}
