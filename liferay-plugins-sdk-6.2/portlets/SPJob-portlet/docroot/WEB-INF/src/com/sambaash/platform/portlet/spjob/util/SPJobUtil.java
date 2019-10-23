package com.sambaash.platform.portlet.spjob.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.bookmarks.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

public class SPJobUtil {

    public static long saveDocument(String folderName,long userId, long liferayCompanyId, File document, long groupId) throws UploadException, FileNotFoundException{
    	FileInputStream in = new FileInputStream(document);
    	long size = document.length();
    	return saveDocument(folderName,userId, groupId, liferayCompanyId,document, document.getName(), StringPool.BLANK, document.getName(), in, size);
    }

    public static long saveDocument(String folderName, long userId, long groupId, long liferayCompanyId, File file, String documentName, 
    		String documentDescription, String documentTitle, InputStream is, long size) throws UploadException{
        try {
            //get default folder storage
            DLFolder folder = getDefaultGroupFolder(folderName, userId, liferayCompanyId, groupId);

            String changeLog = StringPool.BLANK;
            ServiceContext serviceContext = new ServiceContext();
            try{
        		if (is == null) {
        			is = new UnsyncByteArrayInputStream(new byte[0]);
        			size = 0;
        		}

	            DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, groupId, folder.getFolderId(), 
						   documentName, null, documentTitle, documentDescription, changeLog,
			0, null, file, is, size, serviceContext);

	            //add role...
				long guestRoleId = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST).getRoleId();
				if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(fileEntry.getCompanyId(), DLFileEntry.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), guestRoleId, ActionKeys.VIEW)) {
					String[] actionIds = {ActionKeys.VIEW};
					ResourcePermissionLocalServiceUtil.setResourcePermissions(fileEntry.getCompanyId(), DLFileEntry.class.getName(),
							ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), guestRoleId, actionIds);

				}
	            //end add role...
				_log.debug(fileEntry.getUuid());
	            return fileEntry.getFileEntryId();
            }catch(DuplicateFileException e) {
            	_log.warn("Throw DuplicateFileException");
            	Calendar curDate = Calendar.getInstance();
            	StringBuffer documentName_ = new StringBuffer("");
            	if (documentName.lastIndexOf(".") != -1) {
            		documentName_= documentName_.append(documentName.substring(0, documentName.lastIndexOf("."))).append("_").
            		append(curDate.getTimeInMillis()).append(".").append(documentName.substring(documentName.lastIndexOf(".")+1,
            				documentName.length()));
            	} else {
            		documentName_ = documentName_.append(documentName).append("_").append(curDate.getTimeInMillis());
            	}

            	return saveDocument( folderName,userId, groupId, liferayCompanyId, file, documentName_.toString(),
            			documentDescription, documentTitle, null, 0);//Change name and save again
            }

        } catch (Exception e) {
        	_log.error(e.getMessage());
            throw new UploadException(e);
        }
    }

    public static DLFolder getDefaultGroupFolder(String folderName, long userId, long liferayCompanyId, long groupId) throws UploadException, NoSuchFolderException {
        return getDefaultGroupFolder(folderName, userId, liferayCompanyId, false, groupId);
    }

    private static DLFolder getDefaultGroupFolder(String yourfolderName, long userId, long companyId, boolean checkExistance, long groupId) throws UploadException, NoSuchFolderException {
        long parentFolderId = 0L;
        String folderName = yourfolderName + userId;
        String folderDescription="";
        ServiceContext serviceContext = new ServiceContext();

        //create folder if not exists
        try {

        	DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);

            //add role...
			long guestRoleId = RoleLocalServiceUtil.getRole(dlFolder.getCompanyId(), RoleConstants.GUEST).getRoleId();
        	if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(dlFolder.getCompanyId(), DLFolder.class.getName(),
        			ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, ActionKeys.ACCESS)) {
    			String[] actionIds = {ActionKeys.ACCESS};
    			ResourcePermissionLocalServiceUtil.setResourcePermissions(dlFolder.getCompanyId(), DLFolder.class.getName(),
    					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, actionIds);
        	}
            //end add role...
			return dlFolder;

        } catch (NoSuchModelException e) {
            _log.debug("Default folder does not exists");

            if (checkExistance) {
                throw new NoSuchFolderException(e);
            }
        } catch (Exception e) {
            throw new UploadException(e);
        }

        try {

        	DLFolder dlFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, ParamUtil.getBoolean(serviceContext, "mountPoint"),
    				parentFolderId, folderName, folderDescription, serviceContext);

            //add role...
			long guestRoleId = RoleLocalServiceUtil.getRole(dlFolder.getCompanyId(), RoleConstants.GUEST).getRoleId();
        	if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(dlFolder.getCompanyId(), DLFolder.class.getName(),
        			ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, ActionKeys.ACCESS)) {
    			String[] actionIds = {ActionKeys.ACCESS};
    			ResourcePermissionLocalServiceUtil.setResourcePermissions(dlFolder.getCompanyId(), DLFolder.class.getName(),
    					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlFolder.getFolderId()), guestRoleId, actionIds);
        	}
            //end add role...

            return dlFolder;

        } catch (Exception ex) {
            throw new UploadException(ex);
        }
    }
    
    public static String getPictureFileUuid(long documentId) {
        String uuid = StringPool.BLANK;
        try{
        	uuid = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId).getUuid();
        }catch(Exception e) {
        	if (e instanceof NoSuchFileEntryException) {
        		_log.info("_NO SUCH ENTITY WITH PRIMARY KEY "+ documentId);
        	}else{
        		_log.error(e.getMessage(), e);
        	}
        }
    	return uuid;
    }
    
    public static boolean enableNoteficationTo(){
    	return GetterUtil.getBoolean(SambaashUtil.getParameter(SambaashConstants.SPJOB_ENABLE_NOTIFICATION_TO, GetterUtil.getLong(SambaashConstants.DEFAULT_GROUP_ID)));
    }
	
	private static Log _log = LogFactoryUtil.getLog(SPJobUtil.class);

}
