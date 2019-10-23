package com.sambaash.platform.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;

public class DynamicFormDocumentServlet extends HttpServlet {

	private static final long serialVersionUID = 3784987635248697316L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {

			String path = HttpUtil.fixPath(request.getPathInfo());

			String[] pathArray = StringUtil.split(path, CharPool.SLASH);
			if (_log.isDebugEnabled()) {
				_log.debug("path : " + path);
				_log.debug("pathArray : " + pathArray.length);
				_log.debug("PortalUtil.getPortalURL(request) : " + PortalUtil.getPortalURL(request));
			}

			String link = SPMailLocalServiceUtil.decryptLink(pathArray[0]);

			String[] params = StringUtil.split(link, CharPool.SLASH);

			DDLRecord record;

			record = DDLRecordLocalServiceUtil.getRecord(Long.valueOf(params[0]));

			Serializable fieldValue = record.getFieldValue(params[2]);

			JSONObject fileJSONObject = JSONFactoryUtil.createJSONObject(String.valueOf(fieldValue));

			String fileName = fileJSONObject.getString("name");
			String filePath = fileJSONObject.getString("path");

			inputStream = DLStoreUtil.getFileAsStream(record.getCompanyId(), CompanyConstants.SYSTEM, filePath);
			long contentLength = DLStoreUtil.getFileSize(record.getCompanyId(), CompanyConstants.SYSTEM, filePath);
			String contentType = MimeTypesUtil.getContentType(fileName);

			// modifies response
			response.setContentType(contentType);
			response.setContentLength((int) contentLength);

			// forces download
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", fileName);
			response.setHeader(headerKey, headerValue);

			// obtains response's output stream
			outputStream = response.getOutputStream();

			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
			PortalUtil.sendError(e, request, response);
		} catch (SystemException e) {
			_log.error(e);
		} catch (Exception e) {
			PortalUtil.sendError(e, request, response);
		} finally {
			if (Validator.isNotNull(inputStream)) {
				inputStream.close();
			}
			if (Validator.isNotNull(outputStream)) {
				outputStream.close();
			}
		}

	}

	private static Log _log = LogFactoryUtil.getLog(DynamicFormDocumentServlet.class);

}