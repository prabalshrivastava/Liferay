package com.sambaash.platform.portlet.pe.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;

/**
 * Portlet implementation class PEGuestPage
 */
public class PEGuestPageAction extends MVCPortlet {
 
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		String page = ParamUtil.getString(request, "pepage");
		if(Validator.isNull(page)){
			page = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter("pepage");
		}
		
		if("esign".equalsIgnoreCase(page)){
			String packageId = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter("packageId");
			try {
				CourseEnrollEsignInfo esignInfo = CourseEnrollEsignInfoLocalServiceUtil.findByPackageId(packageId);
				request.setAttribute("esignInfo", esignInfo);
			} catch (Exception e) {
				_log.error(e);
			} 
			include("/html/guestpages/esignGuest.jsp", request, response);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(PEGuestPageAction.class);

}
