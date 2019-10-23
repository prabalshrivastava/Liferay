package com.sambaash.platform.portlet.pe.helper;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.pe.helpers.PEUploadHelper;

public class WebUploadHelper extends PEUploadHelper {

	private PortletRequest request;
	private PortletResponse response;
	
	private static Log _log = LogFactoryUtil.getLog(WebUploadHelper.class.getName());
	
	
	public static  WebUploadHelper getInstance(PortletRequest request, PortletResponse response,long scopeGrpId,long companyId ){
		return new WebUploadHelper(request, response, scopeGrpId, companyId);
	}
	private WebUploadHelper(PortletRequest request, PortletResponse response,long scopeGrpId,long companyId ){
		super(scopeGrpId,companyId);
		this.request = request;
		this.response = response;
	}

	public JSONObject uploadFileToTemp() throws PortalException, SystemException, IOException {

		JSONObject responseJson = JSONFactoryUtil.createJSONObject();

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest( request);

		InputStream is = uploadPortletRequest.getFileAsStream("file");
		String contentType = uploadPortletRequest.getContentType("file");
		long size = uploadPortletRequest.getSize("file");
		String name = uploadPortletRequest.getFileName("file");
		
		Folder temp = getTempFolder();
		FileEntry fileEntry = storeFile(temp, name, contentType, is, size);
		responseJson.put("tempFileEntryId", fileEntry.getFileEntryId());

		return responseJson;
	}
	
	public FileEntry storeFile(Folder folder,String name,String contentType, InputStream is, long size) throws PortalException, SystemException{
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
				request);
		_log.debug("Storing file. Folder Id="+folder.getFolderId() + " file Name= " + name + " ContentType " + contentType + " Size " + size);
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, folder.getFolderId(),
					name, contentType, name, StringPool.BLANK, StringPool.BLANK, is, size, serviceContext);
		} catch (DuplicateFileException dfe) {
			name = generateUniqueName(name);
			_log.debug("new name : " + name);
			fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, folder.getFolderId(),
					name, contentType, name, StringPool.BLANK, StringPool.BLANK, is, size, serviceContext);
			_log.debug("fileEntry.getFileEntryId() : " + fileEntry.getFileEntryId());
		} finally {
			StreamUtil.cleanUp(is);
		}

		addDefaultFilePermissions(fileEntry.getFileEntryId());

		return fileEntry;
	}
}
