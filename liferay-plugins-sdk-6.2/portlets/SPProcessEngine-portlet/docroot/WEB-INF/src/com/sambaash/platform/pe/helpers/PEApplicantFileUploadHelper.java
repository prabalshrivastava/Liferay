package com.sambaash.platform.pe.helpers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;

public class PEApplicantFileUploadHelper extends PEUploadHelper {

	private long processStateId;
	
	private PEApplicantFileUploadHelper(long scopeGroupId, long companyId, long processStateId){
		super(scopeGroupId, companyId);
		this.processStateId = processStateId;
	}
	
	public static PEApplicantFileUploadHelper getInstance(long scopeGroupId, long companyId, long processStateId){
		return new PEApplicantFileUploadHelper(scopeGroupId, companyId, processStateId);
	}
	
	public Folder getApplicantFolder() throws PortalException, SystemException{
		return getApplicantFolder(this.processStateId);
	}
	
	public void moveFileToApplicantFolder(long fileEntryId) throws PortalException, SystemException{
		if(fileEntryId != 0){
			Folder appliant = getApplicantFolder();
			 moveFile(fileEntryId,appliant.getFolderId());
		}
	}
	
	public FileEntry storeFileToApplicantFolder(String url,String destFileName) throws PortalException, SystemException, MalformedURLException, IOException{
		 File file = download(url);
		 FileEntry fileEntry = storeFile(file, getApplicantFolder().getFolderId(), destFileName);
		 return fileEntry;
	}
	
}
