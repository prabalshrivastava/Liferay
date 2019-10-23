package com.sambaash.platform.spchallenge.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.sambaash.platform.util.PermissionUtil;

public class SPChallengeDLHelper {

	private static final Log logger = LogFactoryUtil.getLog(SPChallengeDLHelper.class);
	
	
	public static FileEntry uploadLogoToTemp(PortletRequest request, PortletResponse response) throws PortalException, SystemException{
		Object objs[] = null;
		FileEntry fe = null;
		try {
			objs = parseFileUploadRequest(request, response);
		} catch (FileUploadException e) {
			logger.error("Error while parsing file upload request" + e.getMessage());
		}
		if(Validator.isNotNull(objs)){
//			Map<String, String> paramMap = (Map<String, String>) objs[0];
			List<FileItem> files = (List<FileItem>) objs[1];
			if(Validator.isNotNull(files) && !files.isEmpty()){
				if(isLogoTypAllowed(files.get(0).getContentType())){
					fe = uploadLogoToTemp(request, files.get(0));
				}
			}
		}
		return fe;
	}
	public static boolean isLogoTypAllowed(String type){
		return type.equalsIgnoreCase("image/jpeg") || type.equalsIgnoreCase("image/jpg") || type.equalsIgnoreCase("image/png");
	}
	public static String getUserFolderName(long userId){
		String folderName = "User_" + userId;
		return folderName;
	}
	
	public static Folder getChallengesFolder(PortletRequest request) throws PortalException, SystemException{
		Folder folder = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		try {
			// Get the folder
			folder = DLAppServiceUtil.getFolder(groupId, SPChallengeConstants.DL_ROOT_FOLDER_ID,SPChallengeConstants.CHALLENGES_FOLERNAME);
		}catch (NoSuchFolderException ex) {
			folder = DLAppServiceUtil.addFolder(groupId,
					SPChallengeConstants.DL_ROOT_FOLDER_ID, SPChallengeConstants.CHALLENGES_FOLERNAME,"", serviceContext);
			addDefaultFolderPermissions(themeDisplay.getCompanyId(),folder.getFolderId());
			// TODO: Add defatul permissions.
		}
		catch (Exception e) {
			logger.error("Error while getting challenges folder" + e.getMessage());
		}
		return folder;
	}
	public static Folder getChallengesTempFolder(PortletRequest request) throws PortalException, SystemException{
		Folder folder = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		String tempFName = getUserFolderName(userId);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		try {
			folder = getChallengesFolder(request);
			folder = DLAppServiceUtil.getFolder(groupId, folder.getFolderId(),tempFName );
		} catch (NoSuchFolderException ex) {
				folder = DLAppServiceUtil.addFolder(groupId,
						folder.getFolderId(), tempFName, tempFName, serviceContext);
				
			}
			catch (Exception e) {
			logger.error("Error while getting challenges folder" + e.getMessage());
			}
		return folder;
	}

	public static void addDefaultFilePermissions(long companyId,long fileEntryId){
		
		
		//TODO: Assign permission to default roles. Presently hard coding to Site member
		String temp =  "Site Member";//GetterUtil.getString(SambaashUtil.getParameter(SambaashConstants.LEGAL_HIGH_PRIVILIGED_ROLES,0));
		String []privilegedRoles = temp.split(",");
		String actions[] = {"SHARE",ActionKeys.DELETE,ActionKeys.PERMISSIONS, ActionKeys.VIEW, ActionKeys.UPDATE};

		for(String roleName:privilegedRoles){
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFileEntry.class.getName(),
						fileEntryId, actions);
			} catch (Exception e) {
				logger.error("Error while assigning permissions to roles " + e.getMessage());
			}
		}
	
	}
	public static void addDefaultFolderPermissions(long companyId,long folderId){
		
		String actions[] = {ActionKeys.ADD_DOCUMENT,ActionKeys.DELETE, ActionKeys.VIEW, ActionKeys.UPDATE,ActionKeys.ADD_SUBFOLDER};

		try {
			Role role = RoleLocalServiceUtil.getRole(companyId, "Site Member");
			PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFolder.class.getName(),
					folderId, actions);
		} catch (Exception e) {
			logger.error("Error while assigning permissions to roles " + e.getMessage());
		}
		
	}

	public static void clearFolderContents(Folder folder){
		if(Validator.isNotNull(folder)){
			try {
					List<FileEntry>list = DLAppServiceUtil.getFileEntries(folder.getRepositoryId(), folder.getFolderId());
					for(FileEntry fe:list){
						DLAppServiceUtil.deleteFileEntry(fe.getFileEntryId());
					}
			} catch (Exception e) {
			}
		}
	}
	public static FileEntry uploadLogoToTemp(PortletRequest request,
			FileItem item) throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		// 1. GET Temp folder
		Folder tempF = getChallengesTempFolder(request);
		// 2. Clear the temp
		clearFolderContents(tempF);
		final long folderId = tempF.getFolderId();
		String name = item.getName();
		FileEntry fileEntry = null;
		try {
			// 3. Store the file into temp folder
			fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId,
					folderId, name, item.getContentType(), name,
					StringPool.BLANK, StringPool.BLANK,
					item.getInputStream(), item.getSize(),
					serviceContext);
			addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
		} catch (DuplicateFileException ex) {
			// 4. this wont happen 
			fileEntry = DLAppServiceUtil.getFileEntry(scopeGroupId,
					folderId, name);
			DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(),false);
			if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
				fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
				DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
			}
			try{
				fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(
						fileEntry.getFileEntryId(),
						fileEntry.getTitle(), item.getContentType(),
						name, "", "", true, item.getInputStream(),
						item.getSize(), serviceContext);
				addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
			}catch(FileSizeException fs){
				logger.error("File size exceeds maximum allowed limit" + fs.getMessage());
			}catch(Exception ex1){
			   logger.error("Error while uploading file " + ex1.getMessage());
			}
		}catch(FileSizeException ex){
			logger.error("File size exceeds maximum allowed limit" + ex.getMessage());
		}catch(Exception ex){
			logger.error("Error while uploading file " + ex.getMessage());
    	}
		if(Validator.isNotNull(fileEntry)){
			updateFileTitle(fileEntry.getFileEntryId(),String.valueOf(fileEntry.getFileEntryId()));
		}
		return fileEntry;
	}
	public static void updateFileTitle(long fileEntryId, String title){
		
		if(Validator.isNotNull(title)){
			DLFileEntry dfe;
			try {
				dfe = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
				dfe.setTitle(title);
				DLFileEntryLocalServiceUtil.updateDLFileEntry(dfe);
			} catch (Exception e) {
				logger.error("Error while updating file title");
			} 
		}
	}
	public static FileEntry updateOrMoveLogo(PortletRequest request, long existingFeId) throws PortalException, SystemException{
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		// 1. Get destination folder
		Folder destFolder = getChallengesFolder(request);
		// 2. Get source folder
		Folder tempF = getChallengesTempFolder(request);
		// 3. Get the file from temp folder to store it in acutal folder
		List<FileEntry>list = DLAppServiceUtil.getFileEntries(tempF.getRepositoryId(), tempF.getFolderId());
		FileEntry fe = null;
		if(Validator.isNotNull(list) && !list.isEmpty()){
			// Mostly temp folder will have only one file.
			fe = list.get(0);
			try {
				if(existingFeId == 0){
					// If no logo is uploaded yet, just move the the file from temp folder to destination
					fe = DLAppServiceUtil.moveFileEntry(fe.getFileEntryId(), destFolder.getFolderId(), serviceContext);
					addDefaultFilePermissions(companyId, fe.getFileEntryId());
				}else{
					// Updating existing logo
					FileEntry existing = DLAppServiceUtil.getFileEntry(existingFeId);
					fe = DLAppServiceUtil.updateFileEntryAndCheckIn(
							existing.getFileEntryId(),
							existing.getTitle(), fe.getMimeType(),
							existing.getTitle(), "", "", true, fe.getContentStream(),
							fe.getSize(), serviceContext);
					addDefaultFilePermissions(companyId, existing.getFileEntryId());
				}
			}catch(NoSuchFileEntryException ex){
				fe = DLAppServiceUtil.moveFileEntry(fe.getFileEntryId(), destFolder.getFolderId(), serviceContext);
				addDefaultFilePermissions(companyId, fe.getFileEntryId());	
			}
			catch (DuplicateFileException ex) {
				
			}catch(FileSizeException ex){
				logger.error("File size exceeds maximum allowed limit" + ex.getMessage());
			}catch(Exception ex){
				logger.error("Error while uploading file " + ex.getMessage());
			}
		}
		return fe;
	}
	public static Object[] parseFileUploadRequest(PortletRequest actionRequest,
			PortletResponse actionResponse) throws FileUploadException {
		Object[] objs = new Object[2];
		Map<String, String> paramMap = new HashMap<String, String>();
		List<FileItem> files = new ArrayList<FileItem>();

		HttpServletRequest request_ = PortalUtil
				.getHttpServletRequest(actionRequest);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(request_);
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(httpRequest);
			String key;
			for (FileItem item : items) {
				if (item.isFormField()) {
					key = item.getFieldName();
					//key = key.substring(actionResponse.getNamespace().length());
					paramMap.put(key, item.getString());
				} else {
					files.add(item);
				}
			}

		} catch (FileUploadException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

		objs[0] = paramMap;
		objs[1] = files;

		return objs;
	}
}
