package com.sambaash.platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;

public class SPFileUtils {

	private static Log _log = LogFactoryUtil.getLog(SPFileUtils.class);
	
	public static FileEntry addOrUpdate(long repositoryId, long folderId,String title, String contentType,String description,
			String changeLog,long size,InputStream is,ServiceContext serviceContext) throws PortalException, SystemException{
		FileEntry fileEntry;
		try {
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
					folderId, title, contentType, title, description,changeLog,
					is,size,serviceContext);
		} catch (DuplicateFileException ex) {
			fileEntry = DLAppServiceUtil.getFileEntry(repositoryId,
					folderId, title);
			DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(),false);
			if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
				fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
				DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
			}

			//TODO: May be have to add logic to decide major or minor version
			boolean majorVersion = true;
			fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(
					fileEntry.getFileEntryId(),
					fileEntry.getTitle(), contentType,
					title, description, changeLog, majorVersion, is,
					size, serviceContext);
		}
		
		return fileEntry;
	}
	public static FileEntry addOrUpdate(long repositoryId, long folderId,String title, String contentType,String description,
			String changeLog,File file,ServiceContext serviceContext) throws IOException, PortalException, SystemException{

		FileInputStream fis = new FileInputStream(file);
		FileEntry fileEntry =addOrUpdate( repositoryId, folderId, title, contentType, description, changeLog, file.length(),fis, serviceContext);
		fis.close();
		return fileEntry;	
	}
	
	
	public static Folder getOrAddFolder(long repositoryId, long parentFolderId, String folderName, String description,ServiceContext serviceContext)
			throws PortalException, SystemException{
		Folder tempFolder;
		try {
			tempFolder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
		} catch (NoSuchFolderException ex) {
				tempFolder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, folderName, description, serviceContext);
		}
		
		return tempFolder;
	}
	
}
