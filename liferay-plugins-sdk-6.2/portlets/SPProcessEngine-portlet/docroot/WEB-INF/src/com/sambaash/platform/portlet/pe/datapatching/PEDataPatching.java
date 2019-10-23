package com.sambaash.platform.portlet.pe.datapatching;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.util.IOUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.pe.constants.PEConstants;

/**
 * Portlet implementation class PEDataPatching
 */
public class PEDataPatching extends MVCPortlet {
	
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException{
		try {
			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		super.doView(request, response);
	}
	
	public void displayConvert(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage",
				"/html/datapatching/convertToOpportunity.jsp");
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		JSONObject data = JSONFactoryUtil.createJSONObject();

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String action = ParamUtil.getString(resourceRequest, "action");

		if ("convertToOpportunity".equals(action)) {
			PEDataPatchingConversionHelper helper = new PEDataPatchingConversionHelper(resourceRequest, resourceResponse);
			try {
				  helper.convert();
			} catch (Exception e) {
				_log.error(e);
				data.put("error", e.getMessage());
			}finally{
				String path = helper.exportResults();
				  data.put("filePath", path);
			}
			resourceResponse.getWriter().write(data.toString());
		} else if (PEConstants.ACTION_DOWNLOAD_FROM_TEMP.equals(action)) {
			String filePath = ParamUtil.getString(resourceRequest, "filePath");
			download(resourceRequest, resourceResponse, filePath);
			return;

		}
	}
	
	protected boolean download(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String filePath) {

		try {
			String contentType = MimeTypesUtil.getContentType(filePath);
			File file = new File(filePath);
			boolean exists = file.exists();
			if (!exists) {
				_log.info("File does not exists");
			}

			Integer length = new Integer(file.length() + "");
			resourceResponse.setContentType(contentType);
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
			resourceResponse.addProperty("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			resourceResponse.setContentLength(length);
			_log.info("File length ==" + file.length());
			if (file.length() <= 0) {
				return false;
			}

			final FileInputStream fis = new FileInputStream(file);
			OutputStream output = resourceResponse.getPortletOutputStream();
			IOUtils.copy(fis, output);
			output.flush();
			output.close();
			fis.close();

		} catch (Exception e) {
			_log.error(e);
		}
		return true;
	}
	
	private static Log _log = LogFactoryUtil.getLog(PEDataPatching.class
			.getName());
}
