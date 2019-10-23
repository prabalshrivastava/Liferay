package com.sambaash.gu.helper;

import java.io.InputStream;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.msg.GUMsgHelper;

public class GUFileHelper {

	private static final Log _log = LogFactoryUtil.getLog(GUFileHelper.class);
	
	long groupId;
	GUMsgHelper msgHelper;
	
	public GUFileHelper(long groupId, GUMsgHelper msgHelper){
		this.groupId = groupId;
		this.msgHelper = msgHelper;
	}
	public long handleUpload(Object dbObj,Row row,Map<String, Integer> clmnIndexMap,GUField field) throws PortalException, SystemException, GUException{
		if(!GUUploadHelper.isFile_Folder_type(field.getDocumentType())){
			return 0 ;
		}
		
		String cellValue = GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(field.getClmnName())));
		String pathTemplate= field.getDestinationPath();
		String destPath;
		// This path is used to identify folder id which needs to saved to db
		String folderMatchingPath = StringPool.BLANK;
		try {
			destPath = GUFilePathParser.replacePlaceHolders(field.getModalName(), dbObj, pathTemplate);
			String fmTempate = field.getFolderMatchingPath();
			if(Validator.isNotNull(fmTempate)){
				folderMatchingPath = GUFilePathParser.replacePlaceHolders(field.getModalName(), dbObj, fmTempate);
			}
		} catch (Exception e) {
			msgHelper.createError("Invalid place holder", row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());
			throw new GUException();
		}
		ServiceContext fileServiceContext = new ServiceContext();
		setDefaultFilePermissions(fileServiceContext);
		_log.error("Source file path : " + field.getSrcPath());
		long destFolderId = getFolderId(groupId, destPath, true);
		long sourceFolderId = getFolderId(groupId, field.getSrcPath(), false);
		long IdToReurn = 0;
		
		// If single file
		if(GUConstants.DOCUMENT_TYPE_FILE.equalsIgnoreCase(field.getDocumentType())){
			String fileName = cellValue;
			if(Validator.isNull(fileName)){
				return 0;
			}
			FileEntry srcFe  = null;
			try {
				 srcFe = DLAppServiceUtil.getFileEntry(groupId, sourceFolderId, fileName);
			} catch (NoSuchFileEntryException | NoSuchFileException e) {
				msgHelper.createError("File does not exist " + fileName, row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());
				throw new GUException();
			}
			//DLAppServiceUtil.moveFileEntry(srcFe.getFileEntryId(), destFolderId, fileServiceContext);
			FileEntry destFe = copyFile(srcFe, destFolderId);
			msgHelper.createMsg("File uploaded : " + fileName , row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());
			IdToReurn = destFe.getFileEntryId();
		}else if(GUConstants.DOCUMENT_TYPE_Folder.equalsIgnoreCase(field.getDocumentType())){
			// multiple files
			String fileNamesStr = cellValue;
			if(Validator.isNull(fileNamesStr)){
				return 0;
			}
			String fileNames[] = fileNamesStr.split(GUConstants.CELL_VALUE_SEPARATOR_ESCAPED);
			StringBuilder sb = new StringBuilder();
			
			
			// check for existance of files
			for (String fileName : fileNames) {
				if(Validator.isNull(fileName)){
					continue;
				}
				fileName = fileName.trim();
				try {
					 DLAppServiceUtil.getFileEntry(groupId, sourceFolderId,fileName);
				} catch (NoSuchFileEntryException | NoSuchFileException e) {
					msgHelper.createError("File does not exist " + fileName, row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());
					throw new GUException();
				}
			}
			
			// all files exists, start copying to destination
			for (String fileName : fileNames) {
				fileName = fileName.trim();
				if(Validator.isNull(fileName)){
					continue;
				}
				if(sb.length() > 0){
					sb.append(StringPool.COMMA);
				}
				FileEntry  srcFe = DLAppServiceUtil.getFileEntry(groupId, sourceFolderId,fileName);
				copy_update_File(srcFe, destFolderId);
				sb.append(fileName);
			}
			msgHelper.createMsg("Files uploaded : " + sb.toString() , row.getSheet().getSheetName(), row.getRowNum(), field.getClmnName());

			// In case of multiple file upload return the folder id based on matching path
			if(Validator.isNotNull(folderMatchingPath)){
				long matchedFolderId = getFolderId(groupId, folderMatchingPath, true);
				IdToReurn = matchedFolderId;
			}
		}
		return IdToReurn;

	}

	private FileEntry copyFile(FileEntry srcFe,long destFolderId) throws PortalException, SystemException{
		ServiceContext fileServiceContext = new ServiceContext();
		setDefaultFilePermissions(fileServiceContext);
		
		InputStream is = srcFe.getContentStream();
		FileEntry newFe = null;
		try {
			newFe = DLAppServiceUtil.addFileEntry(groupId, destFolderId, srcFe.getTitle(), srcFe.getMimeType(), srcFe.getTitle(), srcFe.getDescription(), "", is, srcFe.getSize(), fileServiceContext);
		} catch (DuplicateFileException ex) {
			_log.debug("Cannot add file as other file exists with same name. Trying to rename the file and upload");
			String name = DateUtil.newDate().getTime() + "-" + srcFe.getTitle();
			newFe = DLAppServiceUtil.addFileEntry(groupId, destFolderId, name, srcFe.getMimeType(), name, srcFe.getDescription(), "", is, srcFe.getSize(), fileServiceContext);
		}finally {
			StreamUtil.cleanUp(is);
		}
		
		return newFe;
	}
	private FileEntry copy_update_File(FileEntry srcFe,long destFolderId) throws PortalException, SystemException{
		ServiceContext fileServiceContext = new ServiceContext();
		setDefaultFilePermissions(fileServiceContext);
		
		InputStream is = srcFe.getContentStream();
		FileEntry newFe = null;
		try {
			newFe = DLAppServiceUtil.addFileEntry(groupId, destFolderId, srcFe.getTitle(), srcFe.getMimeType(), srcFe.getTitle(), srcFe.getDescription(), "", is, srcFe.getSize(), fileServiceContext);
		} catch (DuplicateFileException ex) {
			newFe = DLAppServiceUtil.getFileEntry(groupId, destFolderId, srcFe.getTitle());
			newFe = DLAppServiceUtil.updateFileEntry(newFe.getFileEntryId(), newFe.getTitle(), newFe.getMimeType(), newFe.getTitle(), "", "", true, is, srcFe.getSize(), fileServiceContext);
		}finally {
			StreamUtil.cleanUp(is);
		}
		
		return newFe;
	}
	
	public static long getFolderId(long groupId,String path, boolean create) throws SystemException, PortalException{
		String names[] = path.split("/");
		long folderId = 0;
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(groupId);
		setDefaultFolderPermissions(serviceContext);
		for(String name: names){
			if(Validator.isNull(name)){
				continue;
			}
			name = name.trim();
			Folder folder = null;
			try {
				 folder = DLAppServiceUtil.getFolder(groupId, folderId,
						name);
				folderId = folder.getFolderId();
			} catch (NoSuchFolderException e) {
				_log.error("Folder does not exist. ParentFolderId = " + folderId + " Folder Name Searched: " + name);
				if(create){
					folder = DLAppServiceUtil.addFolder(groupId, folderId,
							name,name, serviceContext);
				}else{
					throw e;
				}
			}
			folderId = folder.getFolderId();
		}
		
		return folderId;
	}
	
	public static void setDefaultFolderPermissions(ServiceContext serviceContext) {
		serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
		serviceContext.setGroupPermissions(
				new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER });
	}
	public static void setDefaultFilePermissions(ServiceContext serviceContext) {
		serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
		serviceContext.setGroupPermissions(
				new String[] { ActionKeys.VIEW, ActionKeys.UPDATE}	);
	}
}
