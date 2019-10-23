package com.sambaash.platform.portlet.legalandcontract.download;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;


public class DownloadServlet extends HttpServlet {


	private static Log logger = LogFactoryUtil.getLog(DownloadServlet.class);

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		logger.info("ServletName : " + servletConfig.getServletName());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("In DownloadServlet service method ");
		download(request, response);
	}

	protected void download(HttpServletRequest request, HttpServletResponse response) {

		try {
			String fileName = ParamUtil.getString(request, "fileName");
			String contentType = MimeTypesUtil.getContentType(fileName);
			File file = new File(fileName);
			boolean exists = file.exists();
			if (!exists) {
				logger.info("File does not exists");
			}

			Integer length = new Integer(file.length() + "");
			response.setContentType(contentType);
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			logger.info("File length ==" + file.length());

			final FileInputStream fos = new FileInputStream(file);
			BufferedOutputStream output = null;
			output = new BufferedOutputStream(response.getOutputStream(), length);
			byte[] buffer = new byte[length];
			while ((length = fos.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			if (fos != null) {
				fos.close();
			}

		} catch (Exception e) {
			if (logger.isWarnEnabled()) {
				logger.warn(e, e);
			}
		}
	}
}