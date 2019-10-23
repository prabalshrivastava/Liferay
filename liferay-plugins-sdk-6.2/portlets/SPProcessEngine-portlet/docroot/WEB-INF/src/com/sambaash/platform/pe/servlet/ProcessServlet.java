package com.sambaash.platform.pe.servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.service.PEEngineServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;

public class ProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Log _log = LogFactoryUtil.getLog(ProcessServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long startTime = System.nanoTime();

		String apiKey = (String) req.getParameter("apiKey");
		String processId = (String) req.getParameter("processId");
		String formId = (String) req.getParameter("formId");
		String formData = (String) req.getParameter("formData");
		String countryName = (String) req.getParameter("countryName");
		String source = (String) req.getParameter("source");
		String url = (String) req.getParameter("url");
		String productId = (String) req.getParameter("productId");
		String entityId = (String) req.getParameter("entityId");
		String suggestions = (String) req.getParameter("suggestions");
		String entityClassId = (String) req.getParameter("entityClassId");

		_log.error("procesId : " + processId + " : formId : " + formId + " : formData : " + formData
				+ " : countryName : " + countryName + " : source : " + source + " : url : " + url + " : productId : "
				+ productId + " : entityId : " + entityId + " : suggestions : " + suggestions + " : entityClassId : " + entityClassId);

		if ("cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==".equalsIgnoreCase(apiKey)) {
			_log.error("Api Key is validated ");
			if (Validator.isNumber(entityClassId)){
				_log.debug("Calling PEEngineServiceUtil. EntityClass Id is present ");
				long temp = GetterUtil.getLong(productId);
				if(temp == 0){
					temp=GetterUtil.getLong(entityId);
				}
				PEEngineServiceUtil.runPEProductApp(Long.parseLong(entityClassId), temp, Long.parseLong(processId),
						Long.parseLong(formId), countryName, formData);
			} else if (Validator.isNumber(productId)) {
				_log.debug("Calling PEEngineServiceUtil. Product Id is present ");
				PEEngineServiceUtil.runPEProductApp(PEConstantsGlobal.PROCESS_DEFAULT_ENTITY,Long.parseLong(productId), Long.parseLong(processId),
						Long.parseLong(formId), countryName, formData);

			} else if (Validator.isNumber(entityId)) {
				_log.debug("Calling PEEngineServiceUtil. Entity Id is present ");
				PEEngineServiceUtil.runPEProductApp(PEConstantsGlobal.PROCESS_DEFAULT_ENTITY,Long.parseLong(entityId), Long.parseLong(processId),
						Long.parseLong(formId), countryName, formData);
			} else {
				_log.debug("Calling PEEngineServiceUtil. None of the above condition satifies ");
				PEEngineServiceUtil.runPEProductAppDefaultEntity(PEConstantsGlobal.PROCESS_DEFAULT_ENTITY,Long.parseLong(processId), Long.parseLong(formId),
						countryName, formData);
			}
		}

		if (Validator.isNotNull(suggestions)) {
			try {
				PEProcess process = PEProcessLocalServiceUtil.getPEProcess(Long.parseLong(processId));

				SocialProfileLocalServiceUtil.mergeFormJsonToProfile(suggestions, process.getCompanyId(),
						process.getGroupId());
			} catch (Exception e) {
				_log.error("Failed to invoke form json to profile merging process.");
			}
		} else {
			if (_log.isDebugEnabled()) {
				_log.debug("No suggestions found.");
			}
		}

		long endTime = System.nanoTime();
		long runtime = endTime - startTime;

		resp.setStatus(HttpStatus.SC_OK);

		_log.error("Time taken to initiate process in nanoseconds : " + runtime + " : in seconds : "
				+ TimeUnit.SECONDS.convert(runtime, TimeUnit.NANOSECONDS));

	}

}
