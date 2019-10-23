package com.sambaash.gu.helper;

import java.io.File;
import java.io.IOException;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.FileUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;
import com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil;

public class GUUploadRequestHelper {

	private static Log _log = LogFactoryUtil.getLog(GUUploadRequestHelper.class);
	
	
	public static void handleUploadRequest(ResourceRequest request, ResourceResponse response) throws IOException {
		
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(request);
		File[] files = uploadPortletRequest.getFiles("file");
		File file = files[0];
		
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		if(file == null){
			obj.put("error", "Please upload file");
			response.getWriter().write(obj.toString());
			return;
		}
		
		file  = copyFile(file);

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		GUUploader uploader = null;
		try {
			uploader = new GUUploader(file, themeDisplay.getUser(),
					themeDisplay.getCompanyId(), groupId);
			uploader.setRequest(request);
		} catch (SystemException e) {
			obj.put("error", "Error while handling upload");
			response.getWriter().write(obj.toString());
			_log.error(e);
			return;
		}
		GUUploadLog uploadLog = uploader.getUploadLog();
		
		GULogUpdater logUpdater = new GULogUpdater(uploadLog);
		logUpdater.run();
		
		
		uploader.run();
		
		response.getWriter().write(GUUploadRequestHelper.getJson(uploadLog).toString());
		
	}
	
	private static  File copyFile(File srcFile) throws IOException{
		/*File destF = new File((System.getProperty("java.io.tmpdir") + "/" + System.nanoTime() + srcFile.getName()));
		FileUtils.copyFile(srcFile, destF);
		//destF.renameTo(new File((System.nanoTime() + srcFile.getName())));
		return destF; */
		
		File tempFolder = FileUtil.createTempFolder();
		String path = tempFolder.getAbsolutePath() + File.separator + srcFile.getName();
		File tempFile = new File(path);
		FileUtils.copyFile(srcFile, tempFile);
		return tempFile;
	}
	
	public static JSONObject getJson(GUUploadLog uploadLog){
		//String str = JSONFactoryUtil.serialize(uploadLog);
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("uploadLogId", uploadLog.getSPGUUploadLogId());
		obj.put("successCount", uploadLog.getSuccessCount());
		obj.put("startTime", uploadLog.getStartTime());
		obj.put("endTime", uploadLog.getEndTime());
		obj.put("status", uploadLog.getStatus());
		obj.put("errors", uploadLog.getErrors());
		obj.put("msgs", uploadLog.getMsgs());
		
		if(uploadLog.getUploadedFileEntryId() > 0){
			obj.put("uploadedFileUrl", getDownloadUrl(uploadLog.getUploadedFileEntryId()));
		}
		if(uploadLog.getErrorFileEntryId() > 0){
			obj.put("errorFileUrl", getDownloadUrl(uploadLog.getErrorFileEntryId()));
		}
		return obj;
	}
	
	public static String getDownloadUrl(long fileEntryId){
		FileEntry file;
		try {
			file = DLAppServiceUtil.getFileEntry(fileEntryId);
			return "/documents/" + file.getGroupId() + "/" + file.getFolderId() + "/"
			+ file.getTitle() + "/" + file.getUuid();
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		return "";
	}
	
	public static void handleLogRequest(PortletRequest request,ResourceResponse response) throws IOException {
		long logId = ParamUtil.getLong(request, "uploadLogId");
		if(logId == 0) return;
		GUUploadLog uploadLog;
		try {
			uploadLog = GUUploadLogLocalServiceUtil.getGUUploadLog(logId);
			response.getWriter().write(GUUploadRequestHelper.getJson(uploadLog).toString());
			return;
		} catch (PortalException | SystemException e) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("error", "Error while handling upload log request");
			response.getWriter().write(obj.toString());
		}
	}
	
}
