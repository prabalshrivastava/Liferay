package com.sambaash.platform.portlet.legalandcontract.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.fileupload.FileItem;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryTypeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.sambaash.platform.portlet.legalandcontract.action.TrademarksAction;

public class FilesUpload {
	private static Log _log = LogFactoryUtil.getLog(TrademarksAction.class);

	private static final String VERSIONS = "versions";
	private List<FileEntry> uploaded;
	private List<FileItem> filesToUpload;
	private Map<FileItem,String> failed;
	private PortletRequest request;
	private long folderId;
	private long rowId;
	private ThemeDisplay themeDisplay;
	private long groupId ;

	public FilesUpload(long rowId,PortletRequest request,
			List<FileItem> filesToUpload, long folderId) throws PortalException, SystemException{
		this.rowId = rowId;
		this.request = request;
		this.filesToUpload = filesToUpload;
		this.folderId = folderId;
		this.failed = new HashMap<FileItem, String>();
		this.uploaded = new ArrayList<FileEntry>();
		this.themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		this.groupId = themeDisplay.getScopeGroupId();
	}
	
	public FilesUpload(long id,PortletRequest request) throws PortalException, SystemException{
		this.rowId = id;
		this.failed = new HashMap<FileItem, String>();
		this.uploaded = new ArrayList<FileEntry>();
		this.request = request;
		this.themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		this.groupId = themeDisplay.getScopeGroupId();
		
	}
	public FilesUpload() throws PortalException, SystemException{
		this.failed = new HashMap<FileItem, String>();
		this.uploaded = new ArrayList<FileEntry>();
	}

	public void updateAndMoveDocuments(long srcFolderId,long destFolderId) throws Exception{
		updateFileInfo();
		moveDocuments(srcFolderId, destFolderId);
	}
	public void updateAndUploadTrademarkLogo(long srcFolderId,long destFolderId) throws Exception{
		updateFileInfo(true);
	    addReplaceTrademarkLogo( srcFolderId, destFolderId);
	}
	public List<FileEntry> moveDocuments(long srcFolderId,long destFolderId) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);
		long repositoryId = this.groupId;
		List<FileEntry> list= DLAppServiceUtil.getFileEntries(repositoryId, srcFolderId);
		FileEntry temp;
		for (FileEntry feSrc : list) {
		/*	result = false;
			temp = null;
			try{
				   temp = DLAppServiceUtil.moveFileEntry(feSrc.getFileEntryId(), destFolderId, serviceContext);
				   Utils.addDefaultFilePermissions(themeDisplay.getCompanyId(), temp.getFileEntryId());
				   result = true;
		       }catch(DuplicateFileException dfe){
					FileEntry feDest = DLAppServiceUtil.getFileEntry(repositoryId, destFolderId, feSrc.getTitle());
					DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(feDest.getFileEntryId(),false);
					if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
						fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
						DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
					}
					try{
						temp = DLAppServiceUtil.updateFileEntryAndCheckIn(
								feDest.getFileEntryId(),
								feSrc.getTitle(), feDest.getMimeType(),
								feSrc.getTitle(), feSrc.getDescription(), "", true, feSrc.getContentStream(),
								feSrc.getSize(), serviceContext);
						Utils.addDefaultFilePermissions(themeDisplay.getCompanyId(), temp.getFileEntryId());
						result = true;
						DLAppServiceUtil.deleteFileEntry(feSrc.getFileEntryId());
					}catch(FileSizeException fs){
						_log.error(fs);
					}catch(Exception ex1){
					   _log.error(ex1);
					}
			   }catch(Exception ex){
				   
			   } 
			
			   if(result){
				   uploaded.add(temp);
			   } */
				temp = moveFileEntry(srcFolderId, destFolderId, feSrc, serviceContext,"");
				if(Validator.isNotNull(temp)){
					uploaded.add(temp);
				}
			}
		updateFileEntries(destFolderId);
		return uploaded;
	}
	
	public FileEntry moveFileEntry(long srcFolder,long destFolderId,FileEntry feSrc,ServiceContext serviceContext,String title) throws PortalException, SystemException{
		long repositoryId = this.groupId;
		FileEntry temp = null;
		try{
			   temp = DLAppServiceUtil.moveFileEntry(feSrc.getFileEntryId(), destFolderId, serviceContext);
			   Utils.addDefaultFilePermissions(themeDisplay.getCompanyId(), temp.getFileEntryId());
			   updateFileTitle(temp.getFileEntryId(), title);
	       }catch(DuplicateFileException dfe){
				FileEntry feDest = DLAppServiceUtil.getFileEntry(repositoryId, destFolderId, feSrc.getTitle());
				DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(feDest.getFileEntryId(),false);
				if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
					fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
					DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
				}
				try{
					String tempTitle = feSrc.getTitle();
					if(Validator.isNotNull(title)){
						tempTitle = title;
					}
					temp = DLAppServiceUtil.updateFileEntryAndCheckIn(
							feDest.getFileEntryId(),
							tempTitle, feDest.getMimeType(),
							tempTitle, feSrc.getDescription(), "", true, feSrc.getContentStream(),
							feSrc.getSize(), serviceContext);
					Utils.addDefaultFilePermissions(themeDisplay.getCompanyId(), temp.getFileEntryId());
					DLAppServiceUtil.deleteFileEntry(feSrc.getFileEntryId());
				}catch(FileSizeException fs){
					_log.error(fs);
				}catch(Exception ex1){
				   _log.error(ex1);
				}
		   }catch(Exception ex){
			   _log.error("error whie moving file " + ex.getMessage());
		   }
		return temp;
	}
	public void updateFileTitle(long fileEntryId, String title){
		
		if(Validator.isNotNull(title)){
			DLFileEntry dfe;
			try {
				dfe = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
				dfe.setTitle(title);
				DLFileEntryLocalServiceUtil.updateDLFileEntry(dfe);
			} catch (Exception e) {
				_log.error("Error while updating file title");
			} 
		}
	}
	public void updateFileInfo() throws Exception{
		updateFileInfo(false);
	}
	public static String removeLogoExtension(String title){
		try{
			String []extns = {".jpg",".jpeg",".png",".gif"};
			for (String extn : extns) {
				if(title.toLowerCase().endsWith(extn)){
					title = title.replace(extn, StringPool.BLANK);
					break;
				}
			}
			
		}catch(Exception ex){
			
		}
		return title;
	}
	public void updateFileInfo(boolean removeExtension) throws Exception{
		Enumeration<String> names = request.getParameterNames();
		String TITLE_ = "title_";
		String FILE_DESC_ = "fileDesc_";
		String name;
		String title;
		String fileDesc;
		long fileEntryId;
		while(names.hasMoreElements()){
			name = names.nextElement();
			if(name.startsWith(TITLE_)){
				fileEntryId = GetterUtil.getLong(name.substring(TITLE_.length()));
				title = GetterUtil.getString(request.getParameter(name));
				fileDesc = GetterUtil.getString(request.getParameter(FILE_DESC_ + fileEntryId));
				try{
					DLFileEntry dfe = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
					if(Validator.isNull(title)){
						title = dfe.getTitle(); 
					}
					String orgDesc = GetterUtil.getString(dfe.getDescription());
					if((!dfe.getTitle().equalsIgnoreCase(title)) || (!orgDesc.equalsIgnoreCase(fileDesc))){
						if(removeExtension){
							title = removeLogoExtension(title);
						}
						dfe.setTitle(title);
						dfe.setDescription(fileDesc);
						DLFileEntryLocalServiceUtil.updateDLFileEntry(dfe);
					}
				}catch(Exception ex){
					throw new Exception("Error while updating file title", ex);
				}
			}
		}
	}
	public void updateFileEntries(long folderId){
		long fvId;
		try {
			 List<FileEntry> list =	DLAppServiceUtil.getFileEntries(groupId, folderId);
			 for (FileEntry fe : list) {
				 fvId = fe.getLatestFileVersion().getFileVersionId();
				 updateExtraSettingsDLFV(fvId);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}
	private void updateExtraSettingsDLFV(long fileVersionId){
		
		try{
			DLFileVersion dfv = DLFileVersionLocalServiceUtil.getDLFileVersion(fileVersionId);
			String settings = dfv.getExtraSettings();
			JSONObject data = null;
			String versions = "";
			try{
				data = JSONFactoryUtil.createJSONObject(settings);
				versions = data.getString(VERSIONS);
			}catch(Exception ex){
				data = JSONFactoryUtil.createJSONObject();
			}
			if(Utils.nullOrEmpty(versions)){
				versions = rowId + "";
			}else{
				versions = versions + "," + rowId;
			}
			data.put(VERSIONS, versions);
			dfv.setExtraSettings(data.toString());
			DLFileVersionLocalServiceUtil.updateDLFileVersion(dfv);
			
		}catch(Exception ex){
			_log.error(ex);
		}
	}

	public List<FileEntry> uploadDocuments() throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);
		uploadDocuments(serviceContext,groupId,filesToUpload,folderId,themeDisplay.getCompanyId());
	    updateFileEntries(folderId);
		return uploaded;
	}
	
	public List<FileEntry> uploadDocuments(PortletRequest request,
			List<FileItem> fileItems, long folderId) throws PortalException, SystemException{
		
		ServiceContext serviceContext;
		ThemeDisplay themeDisplay;
		serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);
		themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
	    long scopeGroupId = themeDisplay.getScopeGroupId();
	    long companyId = themeDisplay.getCompanyId();
	    
	    return uploadDocuments(serviceContext, scopeGroupId, fileItems, folderId,companyId);
	    
	}
	public List<FileEntry> uploadTrademarkLogo(PortletRequest request,
			List<FileItem> fileItems, long folderId) throws PortalException, SystemException{
		
		ServiceContext serviceContext;
		ThemeDisplay themeDisplay;
		serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);
		themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		return uploadTrademarkLogo(serviceContext, scopeGroupId, fileItems, folderId,companyId);
		
		
	}
	public List<FileEntry> uploadDocuments(ServiceContext serviceContext,long scopeGroupId,
			List<FileItem> fileItems, long folderId,long companyId) {
		boolean updateStatus = false;
		try {
			FileEntry fileEntry = null;
			for (FileItem item : fileItems) {
				updateStatus = false;
				if (!item.isFormField() && item.getName() != null
						&& !item.getName().equals("")) {
					String name = item.getName();
					String extension = item.getName().substring(
							item.getName().lastIndexOf(StringPool.PERIOD) + 1,
							item.getName().length());
					String type = DLUtil.getGenericName(extension);
					DLFileEntryType fileEntryType = null;
					try {
						fileEntryType = DLFileEntryTypeLocalServiceUtil
								.getFileEntryType(scopeGroupId,
										org.apache.commons.lang.WordUtils
												.capitalize(type));
						if (fileEntryType != null) {
							long fileEntryTypeId = fileEntryType
									.getFileEntryTypeId();
							serviceContext.setAttribute("fileEntryTypeId",
									fileEntryTypeId);
						}
					} catch (NoSuchFileEntryTypeException ex) {
						//_log.error(ex);
					}
					try {
						fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId,
								folderId, name, item.getContentType(), name,
								StringPool.BLANK, StringPool.BLANK,
								item.getInputStream(), item.getSize(),
								serviceContext);
						updateStatus = true;
						Utils.addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
					} catch (DuplicateFileException ex) {
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
							updateStatus = true;
							Utils.addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
						}catch(FileSizeException fs){
							failed.put(item, "File size exceeds maximum allowed limit");
							_log.error(fs);
						}catch(Exception ex1){
							failed.put(item, ex1.getMessage());
						   _log.error(ex1);
						}
						_log.error(ex.getMessage(), ex);
					}catch(FileSizeException ex){
						failed.put(item, "File size exceeds maximum allowed limit");
						_log.error(ex);
					}catch(Exception ex){
						failed.put(item, "Error while uploading file");
					_log.error(ex);
			    	}
					if(updateStatus){
						uploaded.add(fileEntry);
					}
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		
		return uploaded;
	}
	
	public FileEntry addOrUpadateFile(long companyId,long repositoryId,long folderId,String name,String contentType,long size,InputStream is,ServiceContext serviceContext){
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
					folderId, name, contentType, name,
					StringPool.BLANK, StringPool.BLANK,
					is, size,
					serviceContext);
			Utils.addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
		} catch (DuplicateFileException ex) {
			try{
				fileEntry = DLAppServiceUtil.getFileEntry(repositoryId,
					folderId, name);
				DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(),false);
				if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
					fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
					DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
				}
				fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(
						fileEntry.getFileEntryId(),
						name, contentType,
						name, "", "", true, is,
						size, serviceContext);
				Utils.addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
			}catch(FileSizeException fs){
				_log.error(fs);
			}catch(Exception ex1){
			   _log.error(ex1);
			}
		}catch(FileSizeException ex){
			_log.error(ex);
		}catch(Exception ex){
		_log.error(ex);
    	}
		
		return fileEntry;
	}
	public List<FileEntry> uploadTrademarkLogo(ServiceContext serviceContext,long scopeGroupId,
			List<FileItem> fileItems, long folderId,long companyId) throws PortalException, SystemException {
		boolean updateStatus = false;
		FileEntry fileEntry = null;
		for (FileItem item : fileItems) {
			if (!item.isFormField() && item.getName() != null
					&& !item.getName().equals("")) {
				try {
					fileEntry = updateTrademarkLogo(companyId,serviceContext, scopeGroupId, folderId, item.getName(), item.getContentType(), item.getSize(), item.getInputStream());
					if(Validator.isNull(fileEntry)){
						failed.put(item, "Error while uploading logo");
					}else{
						uploaded.add(fileEntry);
					}
				} catch (IOException e) {
				}
			}
		/*	updateStatus = false;
			if (!item.isFormField() && item.getName() != null
					&& !item.getName().equals("")) {
				String name = item.getName();
				List<FileEntry> fes = DLAppServiceUtil.getFileEntries(scopeGroupId, folderId, 0, 1);
				if(fes.size() > 0){
					fileEntry = fes.get(0);
				}
				if(Validator.isNotNull(fileEntry)){
					DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(),false);
					if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
						fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
						DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
					}
					try{
						fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(
								fileEntry.getFileEntryId(),
								name, item.getContentType(),
								name, "", "", true, item.getInputStream(),
								item.getSize(), serviceContext);
						updateStatus = true;
					}catch(FileSizeException fs){
						failed.put(item, "File size exceeds maximum allowed limit");
						_log.error(fs);
					}catch(Exception ex1){
						failed.put(item, ex1.getMessage());
						_log.error(ex1);
					}
				}else{
					try {
						fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId,
								folderId, name, item.getContentType(), name,
								StringPool.BLANK, StringPool.BLANK,
								item.getInputStream(), item.getSize(),
								serviceContext);
						updateStatus = true;
					} catch (DuplicateFileException ex) {
						// it won't come
					}catch(FileSizeException ex){
						failed.put(item, "File size exceeds maximum allowed limit");
						_log.error(ex);
					}catch(Exception ex){
						failed.put(item, ex.getMessage());
						_log.error(ex);
					}
				}
				if(updateStatus){
					uploaded.add(fileEntry);
				}
			} */
		}
		return uploaded;
	}
	
	public FileEntry updateTrademarkLogo(long companyId,ServiceContext serviceContext,long scopeGroupId, long folderId, String name ,String contentType,long size,
			InputStream is) throws PortalException, SystemException{
		FileEntry temp = null;
		if(Validator.isNotNull(is) && Validator.isNotNull(name)){
			FileEntry fileEntry = null;
			List<FileEntry> fes = DLAppServiceUtil.getFileEntries(scopeGroupId, folderId, 0, 1);
			if(fes.size() > 0){
				fileEntry = fes.get(0);
			}
			if(Validator.isNotNull(fileEntry)){
				DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(),false);
				if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
					fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
					DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
				}
				try{
					temp = DLAppServiceUtil.updateFileEntryAndCheckIn(
							fileEntry.getFileEntryId(),
							name, contentType,
							name, "", "", true, is,
							size, serviceContext);
					Utils.addDefaultFilePermissions(companyId, temp.getFileEntryId());
				}catch(FileSizeException fs){
					_log.error("error while updating trademark logo " + fs.getMessage());
				//	_log.error(fs);
				}catch(Exception ex1){
					_log.error("error while updating trademark logo " + ex1.getMessage());
	//				failed.put(item, ex1.getMessage());
			//		_log.error(ex1);
				}
			}else{
				try {
					temp = DLAppServiceUtil.addFileEntry(scopeGroupId,
							folderId, name, contentType, name,
							StringPool.BLANK, StringPool.BLANK,
							is, size,
							serviceContext);
					Utils.addDefaultFilePermissions(companyId, temp.getFileEntryId());
				} catch (DuplicateFileException ex) {
					// it won't come
				}catch(FileSizeException ex){
					_log.error("error while adding trademark logo " + ex.getMessage());
				}catch(Exception ex){
				//	failed.put(item, ex.getMessage());
					_log.error("error while adding trademark logo " + ex.getMessage());
				}
			}
		}
		
		return temp;
	}
	
	public List<FileEntry> addReplaceTrademarkLogo(long srcFolderId,long destFolderId) throws Exception {
		boolean updateStatus = false;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		try {
			FileEntry srcFileEntry = null;
			FileEntry destFileEntry = null;
			List<FileEntry> destfes = DLAppServiceUtil.getFileEntries(groupId, destFolderId, 0, 1);
			List<FileEntry> srcfes = DLAppServiceUtil.getFileEntries(groupId, srcFolderId, 0, 1);

			if(destfes.size() > 0){
				destFileEntry = destfes.get(0);
			}
			if(srcfes.size() > 0){
				srcFileEntry = srcfes.get(0);
			}
			if(Validator.isNotNull(srcFileEntry)){
				if(Validator.isNotNull(destFileEntry)){
					DLFileVersion fileVersion = DLFileVersionLocalServiceUtil.getLatestFileVersion(destFileEntry.getFileEntryId(),false);
					if(fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE){
						fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
						DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
					}
					try{
						destFileEntry= DLAppServiceUtil.updateFileEntryAndCheckIn(
								destFileEntry.getFileEntryId(),
								srcFileEntry.getTitle(), srcFileEntry.getMimeType(),
								srcFileEntry.getTitle(), srcFileEntry.getDescription(), "", true, srcFileEntry.getContentStream(),
								srcFileEntry.getSize(), serviceContext);
						updateStatus = true;
						 Utils.addDefaultFilePermissions(themeDisplay.getCompanyId(), destFileEntry.getFileEntryId());
						DLAppServiceUtil.deleteFileEntry(srcFileEntry.getFileEntryId());
					}catch(Exception ex1){
						_log.error(ex1);
						throw new Exception("Error while uploading logo",ex1);
					}
				}else{
					try {
						FileEntry fe = DLAppServiceUtil.moveFileEntry(srcFileEntry.getFileEntryId(), destFolderId, serviceContext);
						Utils.addDefaultFilePermissions(themeDisplay.getCompanyId(), fe.getFileEntryId());
						updateStatus = true;
					}catch(Exception ex){
						_log.error(ex);
						throw new Exception("Error while uploading logo",ex);
					}
				}
			}
			if(updateStatus){
				uploaded.add(destFileEntry);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			throw new Exception("Error while uploading logo",e);
		}
		return uploaded;
	}

	public PortletRequest getRequest() {
		return request;
	}

	public void setRequest(PortletRequest request) {
		this.request = request;
	}

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public List<FileEntry> getUploaded() {
		return uploaded;
	}

	public Map<FileItem, String> getFailed() {
		return failed;
	}
	
	public String getErrorMessage(FileItem item){
		return failed.get(item);
	}
	
	public int getFailedCount(){
		return failed.size();
	}
	public int getSuccessCount(){
		return uploaded.size();
	}
}
