package com.sambaash.portlet.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.gu.helper.GUUploadRequestHelper;

public class GUAction extends MVCPortlet {


	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException {

		String action = ParamUtil.getString(request, "action");
		if ("downloadFile".equalsIgnoreCase(action)) {
			String fileName = ParamUtil.getString(request, "file");
			if ("sampleTemplate".equalsIgnoreCase(fileName)) {
				wrtiFile("/resources/sampleTemplate.xlsx", response);
			}
		}else if("upload".equalsIgnoreCase(action)){
			GUUploadRequestHelper.handleUploadRequest(request, response);;
		}else if("getUploadLog".equalsIgnoreCase(action)){
			GUUploadRequestHelper.handleLogRequest(request, response);;
		}
	}

	private void wrtiFile(String filePath, ResourceResponse response) throws IOException {
		URL url = this.getClass().getResource(filePath);
		File file = new File(url.getPath());
		FileInputStream is = new FileInputStream(file);
		response.setContentType("application/xlsx");
		// response.setContentType(contentType);
		response.setContentLength((int) file.length());
		response.addProperty("Content-Disposition", "attachment; filename=\""
				+ file.getName() + "\"");
		response.addProperty(HttpHeaders.CACHE_CONTROL,
				"max-age=3600, must-revalidate");
		OutputStream os = response.getPortletOutputStream();
		IOUtils.copy(is, os);
		is.close();
		os.flush();
		os.close();
	}

}
