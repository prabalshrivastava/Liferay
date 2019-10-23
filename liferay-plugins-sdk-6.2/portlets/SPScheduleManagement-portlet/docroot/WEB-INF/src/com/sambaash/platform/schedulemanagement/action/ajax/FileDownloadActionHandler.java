package com.sambaash.platform.schedulemanagement.action.ajax;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class FileDownloadActionHandler implements ServeResourceActionHandler {

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try {
			
			UploadPortletRequest uploadRequest   =  PortalUtil.getUploadPortletRequest(request);
			String fileName = uploadRequest.getParameter("fileName");
			//String fileName = "cuphothand-f9ef4d17-69df-400b-98b5-fb25e4e6377b.jpg";
			Map response11 = SystemLocalServiceUtil.fetchDocumentS3(request, fileName);
			HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(response);
			httpRes.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			httpRes.setHeader("Content-Transfer-Encoding", "binary");
			httpRes.setContentType(response11.get("contentType").toString());
			ServletResponseUtil.write(httpRes, (byte[]) response11.get("content"));

		} catch (IOException e) {

		}

	}
}
