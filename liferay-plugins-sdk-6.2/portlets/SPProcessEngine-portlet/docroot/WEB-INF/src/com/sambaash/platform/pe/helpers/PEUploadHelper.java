package com.sambaash.platform.pe.helpers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PEUploadHelper {

	private static Log _log = LogFactoryUtil.getLog(PEUploadHelper.class.getName());

	private final String DEFAULT_ROOT = "Process Engine Content";

	final protected long scopeGroupId;
	final protected long companyId;

	public PEUploadHelper(long scopeGroupId, long companyId) {
		this.scopeGroupId = scopeGroupId;
		this.companyId = companyId;
	}

	public String getPEFolderName() {
		String name = SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_PE_ROOT_FOLDR, 0);
		if (Validator.isNull(name)) {
			name = DEFAULT_ROOT;
		}
		return name;
	}

	public String getApplicantFolderName(long processStateId) {
		return String.valueOf(processStateId);
	}

	public Folder getRootFolder() throws PortalException, SystemException {
		String folderName = getPEFolderName();
		Folder folder = getAdminFolder(0, folderName);
		return folder;
	}

	public Folder getTempFolder() throws PortalException, SystemException {
		Folder root = getRootFolder();
		Folder temp = getAdminFolder(root.getFolderId(), "temp");
		return temp;
	}

	public Folder getApplicationsFolder() throws PortalException, SystemException {
		Folder root = getRootFolder();
		Folder temp = getAdminFolder(root.getFolderId(), "applications");
		return temp;
	}

	// Process State Id is used as applicant folder Id
	public Folder getApplicantFolder(long processStateId) throws PortalException, SystemException {
		Folder application = getApplicationsFolder();
		Folder applicant = getFolder(application.getFolderId(), getApplicantFolderName(processStateId));
		return applicant;
	}

	public Folder getFolder(long parentFolderId, String folderName) throws PortalException, SystemException {
		Folder folder;
		try {
			folder = DLAppServiceUtil.getFolder(scopeGroupId, parentFolderId, folderName);
		} catch (NoSuchFolderException e) {
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(scopeGroupId);
			folder = DLAppServiceUtil.addFolder(scopeGroupId, parentFolderId, folderName, folderName, serviceContext);
			addDefaultFolderPermissions(folder.getFolderId());
		}
		return folder;
	}

	/**
	 * Admin folders are high previliged folders and must be created by admin as
	 * owner.
	 * 
	 * Below is the folder structure. (root ,temp and applications are admin
	 * folders)
	 * 
	 * Process Engine Content -- Temp -- Applications --68283 (sub folders-named
	 * with process state id) --83473
	 * 
	 * @param parentFolderId
	 * @param folderName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Folder getAdminFolder(long parentFolderId, String folderName) throws PortalException, SystemException {
		Folder folder;
		try {
			folder = DLAppServiceUtil.getFolder(scopeGroupId, parentFolderId, folderName);
		} catch (NoSuchFolderException e) {
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(scopeGroupId);
			try {
				PermissionUtil.initializeAdminPermissionChecker();
			} catch (Exception e1) {
				_log.error(e1);
			}
			folder = DLAppServiceUtil.addFolder(scopeGroupId, parentFolderId, folderName, folderName, serviceContext);
			addDefaultAdminFolderPermissions(folder.getFolderId());
		}
		return folder;
	}

	public void addDefaultFilePermissions(long fileEntryId) {
		String[] privilegedRoles = getDefaultRoles();
		String actions[] = { ActionKeys.DELETE, ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.OVERRIDE_CHECKOUT };

		for (String roleName : privilegedRoles) {
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFileEntry.class.getName(),
						fileEntryId, actions);
			} catch (Exception e) {
				_log.error("Error while assigning permissions to roles " + e.getMessage());
			}
		}

	}

	private String[] getDefaultRoles() {
		String defaultRoleNames[] = new String[] {};
		try {
			String[] ADMIN_DEFAULT_ROLE_NAMES = StringUtil
					.splitLines(PropsUtil.get(PropsKeys.ADMIN_DEFAULT_ROLE_NAMES));
			defaultRoleNames = PrefsPropsUtil.getStringArray(companyId, PropsKeys.ADMIN_DEFAULT_ROLE_NAMES,
					StringPool.NEW_LINE, ADMIN_DEFAULT_ROLE_NAMES);
		} catch (SystemException e1) {
			_log.error("Error while getting default roles", e1);
		}
		return defaultRoleNames;
	}

	public void addDefaultFolderPermissions(long folderId) {

		String[] privilegedRoles = getDefaultRoles();
		String actions[] = { ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER, ActionKeys.VIEW, ActionKeys.UPDATE };

		for (String roleName : privilegedRoles) {
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFolder.class.getName(), folderId,
						actions);
			} catch (Exception e) {
				_log.error("Error while assigning permissions to roles " + e.getMessage());
			}
		}
	}

	public void addDefaultAdminFolderPermissions(long folderId) {

		String[] privilegedRoles = getDefaultRoles();
		String actions[] = { ActionKeys.VIEW };

		for (String roleName : privilegedRoles) {
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId, role.getRoleId(), DLFolder.class.getName(), folderId,
						actions);
			} catch (Exception e) {
				_log.error("Error while assigning permissions to roles " + e.getMessage());
			}
		}
	}

	public String generateUniqueName(String name) {
		name = name + "-" + DateUtil.newDate().getTime();
		return name;
	}

	public void updateFileTitle(DLFileEntry dfe, String title) throws PortalException, SystemException {
		if (Validator.isNotNull(title)) {
			dfe.setTitle(title);
			dfe.setName(title);
			DLFileEntryLocalServiceUtil.updateDLFileEntry(dfe);
		}
	}

	public void moveFile(long fileEntryId, long destFolderId) throws PortalException, SystemException {
		ServiceContext serviceContext = new ServiceContext();
		DLFileEntry dfe = null;
		try {
			dfe = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			if (dfe.getFolderId() != destFolderId) {
				DLAppServiceUtil.moveFileEntry(fileEntryId, destFolderId, serviceContext);
			}
		} catch (DuplicateFileException fe) {
			String newName = generateUniqueName(dfe.getTitle());
			DLAppServiceUtil.updateFileEntry(fileEntryId, newName, dfe.getMimeType(), newName,
					"Renamed from " + dfe.getTitle() + " to " + newName, "", true, dfe.getContentStream(),
					dfe.getSize(), serviceContext);
			DLAppServiceUtil.moveFileEntry(fileEntryId, destFolderId, serviceContext);
		}
	}

	public FileEntry storeFile(File file, long destFolderId, String destFileName)
			throws PortalException, SystemException, IOException {
		ServiceContext serviceContext = new ServiceContext();
		FileEntry dfe = null;
		String mimeType = Files.probeContentType(file.toPath());
		// BufferedInputStream bis = new BufferedInputStream(new
		// FileInputStream(file));
		try {
			dfe = DLAppServiceUtil.addFileEntry(scopeGroupId, destFolderId, destFileName, mimeType, destFileName,
					"Copied from " + file.getAbsolutePath(), StringPool.BLANK, file, serviceContext);
		} catch (DuplicateFileException fe) {
			String newName = generateUniqueName(destFileName);
			_log.debug("Found file with same name. Hence generating new name. Old=" + destFileName + " New=" + newName);
			dfe = DLAppServiceUtil.addFileEntry(scopeGroupId, destFolderId, newName, mimeType, newName,
					"Copied from " + file.getAbsolutePath(), StringPool.BLANK, file, serviceContext);
		}
		addDefaultFilePermissions(dfe.getFileEntryId());
		return dfe;
	}

	public static File download(String url)
			throws PortalException, SystemException, MalformedURLException, IOException {
		File temp = FileUtil.createTempFile();
		FileUtils.copyURLToFile(new URL(url), temp);
		return temp;
	}

	public static File download(String url, String destName)
			throws PortalException, SystemException, MalformedURLException, IOException {
		File tempF = FileUtil.createTempFolder();
		File file = new File(tempF, destName);
		FileUtils.copyURLToFile(new URL(url), file);
		return file;
	}

	/*
	 * public File download(String url,String fileName) throws PortalException,
	 * SystemException, MalformedURLException, IOException{
	 * 
	 * String path = System.getProperty("java.io.tmpdir") + File.separator +
	 * fileName; File file = new File(path); if(file.exists()){ String tempName
	 * = generateUniqueName(fileName); path =
	 * System.getProperty("java.io.tmpdir") + File.separator + tempName; file =
	 * new File(path); } FileUtils.copyURLToFile(new URL(url), file); return
	 * file; }
	 */

}
