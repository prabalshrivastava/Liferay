package com.sambaash.platform.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.jets3t.service.S3ServiceException;
import org.jets3t.service.security.AWSCredentials;
import org.jets3t.service.S3Service;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.quartz.CronExpression;

import com.sambaash.platform.portlet.LogsManagementConstants;

/**
 * Portlet implementation class SPLogsManagementPortlet
 */
public class LogsManagementAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(LogManagingJob.class);

	static String jobClassName = LogsManagementConstants.JOB_CLASS_NAME;
	static String portletId = LogsManagementConstants.PORTLET_ID;
	static String description = LogsManagementConstants.DESCREPTION;
	static String jobName = LogsManagementConstants.JOB_NAME;

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		String status = portletPreferences.getValue("status", "");
		String cronEx = portletPreferences.getValue("cronExpression", "");

		if (status.equalsIgnoreCase("true")) {
			try {
				CronExpression cronExpression = new CronExpression(cronEx);
				Date date = new Date();
				renderRequest.setAttribute("status",
						cronExpression.getNextValidTimeAfter(date));
				renderRequest.setAttribute("buttonState1", "true");
				renderRequest.setAttribute("buttonState2", "false");
			} catch (ParseException e) {
				_log.error(e);
			}
		} else {
			renderRequest.setAttribute("status",
					"The job is unschedled. Please schedule it.");
			renderRequest.setAttribute("buttonState1", "false");
			renderRequest.setAttribute("buttonState2", "true");
		}

		super.doView(renderRequest, renderResponse);

	}

	public void scheduleLogs(ActionRequest request, ActionResponse response)
			throws S3ServiceException, NullPointerException, ReadOnlyException,
			ValidatorException, IOException {
		try {

			PortletPreferences portletPreferences = request.getPreferences();

			Map<String, Object> jobData = new HashMap<String, Object>();
			String accessKeyId = portletPreferences.getValue("accessKeyId", "");
			String secretAccessKey = portletPreferences.getValue(
					"secretAccessKey", "");
			String bucket = portletPreferences.getValue("bucketName", "");
			String rootFolder = portletPreferences.getValue("rootFolder", "");
			String logFilePath = portletPreferences.getValue("logFilePath", "");
			String cronEx = portletPreferences.getValue("cronExpression", "");
			boolean creationDate = GetterUtil.getBoolean(portletPreferences
					.getValue("creationDate", ""));
			boolean deleteFile = GetterUtil.getBoolean(portletPreferences
					.getValue("deleteFile", ""));

			AWSCredentials credentials = AWSCredentials(accessKeyId,
					secretAccessKey);
			S3Service s3Service = new RestS3Service(credentials);

			S3Bucket s3bucket = s3Service.getBucket(bucket);
			if (s3bucket == null) {
				_log.debug("S3bucket invalid. BucketName " + bucket);
				SessionErrors.add(request, "unauthorized.s3.bucketName");
				return;
			}

			jobData.put("accessKeyId", accessKeyId);
			jobData.put("secretAccessKey", secretAccessKey);
			jobData.put("bucketName", bucket);
			jobData.put("rootFolder", rootFolder);
			jobData.put("logFilePath", logFilePath);
			jobData.put("creationDate", creationDate);
			jobData.put("deleteFile", deleteFile);

			SPJobEntryLocalServiceUtil.schedule(portletId, jobClassName,
					description, cronEx, jobName, jobData);

			portletPreferences.setValue("status", "true");
			portletPreferences.store();

		} catch (S3ServiceException e) {
			_log.error(e);
			if (e.getErrorCode().equalsIgnoreCase("InvalidAccessKeyId")) {
				SessionErrors.add(request, "unauthorized.s3.accesKey");
			} else if (e.getErrorCode().equalsIgnoreCase(
					"SignatureDoesNotMatch")) {
				SessionErrors.add(request, "unauthorized.s3.secretKey");
			}

		}
	}

	public static AWSCredentials AWSCredentials(String accessKey,
			String secretKey) {
		return new AWSCredentials(accessKey, secretKey);
	}

	public void unScheduleLogs(ActionRequest request, ActionResponse response)
			throws ReadOnlyException, ValidatorException, IOException {

		PortletPreferences portletPreferences = request.getPreferences();
		// SPJobEntryLocalServiceUtil.unSchedule(jobName, jobClassName);
		SPJobEntryLocalServiceUtil.delete(jobName, jobClassName);

		portletPreferences.setValue("status", "false");
		portletPreferences.store();

	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException, IllegalArgumentException {

		JSONObject data = JSONFactoryUtil.createJSONObject();

		try {

			HttpServletRequest request = PortalUtil
					.getHttpServletRequest(resourceRequest);
			Map params = PortalUtil.getOriginalServletRequest(request)
					.getParameterMap();
			String logFilePath = ((String[]) params.get("logFilePath"))[0];
			String creationDate = ((String[]) params.get("creationDate"))[0];

			if ((creationDate.equalsIgnoreCase("false"))
					&& (logFilePath.indexOf(".") == logFilePath
							.lastIndexOf("."))) {
				data.put("result",
						"Either choose creation date or enter a valid file pattern");
			} else if (logFilePath.indexOf(".") != logFilePath.lastIndexOf(".")) {
				String datePattern = logFilePath.substring(
						logFilePath.indexOf(".") + 1,
						logFilePath.lastIndexOf("."));

				DateFormat sdf = new SimpleDateFormat(datePattern);

				Date date = new Date();
				sdf.format(date);
				data.put("result", "Details saved successfully");
			} else {
				data.put("result", "Details saved successfully");
			}

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			data.put("result", "Please enter a valid file pattern");
			// throw new IOException();
		}

		resourceResponse.getWriter().write(data.toString());

	}

}
