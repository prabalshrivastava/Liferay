package com.sambaash.platform.mastertimetable.ajax;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class FileDownloadActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(FileDownloadActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			String fileName = uploadRequest.getParameter("fileName");
			Map response11 = SystemLocalServiceUtil.fetchDocumentS3(request, fileName);
			HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(response);
			httpRes.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			httpRes.setHeader("Content-Transfer-Encoding", "binary");
			httpRes.setContentType(response11.get("contentType").toString());
			ServletResponseUtil.write(httpRes, (byte[]) response11.get("content"));
		} catch (IOException e) {
			log.error(e);
		}
	}
}
