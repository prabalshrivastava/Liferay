package com.sambaash.platform.portlet.filesharing.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.sambaash.platform.util.PermissionUtil;
public class FileSharingUtils {

private static Log _log = LogFactoryUtil.getLog(FileSharingUtils.class);

	public static void addDefaultFilePermissions(long companyId,long fileEntryId,String roleNamePrefix){
		if(companyId != 0 && fileEntryId != 0 && Validator.isNotNull(roleNamePrefix)){
			try{
				long roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix+ "-User").getRoleId();
				PermissionUtil.addResourcePermission(companyId, roleId, DLFileEntry.class.getName(),
						fileEntryId, new String[]{ActionKeys.VIEW});
				
				String []allKeys = new String[]{ActionKeys.VIEW,ActionKeys.UPDATE,ActionKeys.ADD_DISCUSSION,ActionKeys.UPDATE_DISCUSSION,ActionKeys.DELETE_DISCUSSION,
						ActionKeys.DELETE,ActionKeys.PERMISSIONS,"SHARE"};
				roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix+ "-Doc_Control").getRoleId();
				PermissionUtil.addResourcePermission(companyId, roleId, DLFileEntry.class.getName(),
						fileEntryId, allKeys);

				roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix+ "-Admin").getRoleId();
				PermissionUtil.addResourcePermission(companyId, roleId, DLFileEntry.class.getName(),
						fileEntryId, allKeys);
			}catch(Exception ex){
				PermissionUtil.addDefaultRoleResourcePermission(companyId,
						DLFileEntry.class.getName(), fileEntryId, new String[] {
					ActionKeys.VIEW });
			}
		}
	}
	public static void addDefaultFolderPermissions(long companyId,long folderId,String roleNamePrefix){
		if(companyId != 0 &&folderId != 0 && Validator.isNotNull(roleNamePrefix)){
			try{
				long roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix+ "-User").getRoleId();
				PermissionUtil.addResourcePermission(companyId, roleId, DLFolder.class.getName(),
						folderId, new String[]{ActionKeys.VIEW});
				
				String []allKeys= new String[]{ActionKeys.VIEW,ActionKeys.UPDATE,ActionKeys.ADD_DOCUMENT,ActionKeys.ADD_SUBFOLDER,ActionKeys.ADD_SHORTCUT,
						ActionKeys.DELETE,ActionKeys.PERMISSIONS,"SHARE"};
				roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix+ "-Doc_Control").getRoleId();
				PermissionUtil.addResourcePermission(companyId, roleId, DLFolder.class.getName(),
						folderId,allKeys );
			
				roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix+ "-Admin").getRoleId();
				PermissionUtil.addResourcePermission(companyId, roleId, DLFolder.class.getName(),
						folderId, allKeys);
			}catch(Exception ex){
				PermissionUtil.addDefaultRoleResourcePermission(companyId,
						DLFolder.class.getName(), folderId, new String[] {
					ActionKeys.ADD_DOCUMENT, ActionKeys.VIEW});
			
			}
		}
	}
	
	
	public static void initializePermissionChecker() throws Exception {
		Role adminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(),"Administrator");
		List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
		PrincipalThreadLocal.setName(adminUsers.get(0).getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUsers.get(0), true);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
	}

	public static Map<String, String> getFile4mIndexer(long compnayId,
			long fileEntryId) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(DLFileEntry.class
				.getName());
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(compnayId);
		searchContext.setStart(0);
		searchContext.setEnd(1);

		BooleanClause[] booleanClauses = new BooleanClause[1];
		BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
		bq.addExactTerm(Field.ENTRY_CLASS_PK, fileEntryId);
		BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext, bq, BooleanClauseOccur.MUST.getName());
		booleanClauses[0] = bc;
		searchContext.setBooleanClauses(booleanClauses);

		Hits results = null;
		Map<String, String>map = new HashMap<String, String>();
		try {
			results = indexer.search(searchContext);

			if (results != null) {
				int length = results.getDocs().length;

				if (length > 0) {
					Document doc = results.doc(0);
					String title = GetterUtil.getString(doc.get(Field.TITLE));
					map.put(Field.TITLE, title);
					map.put(FileSharingConstants.FILE_ENTRY_ID, fileEntryId + "");
					map.put(Field.FOLDER_ID, GetterUtil.getString(doc.get(Field.FOLDER_ID)));
					map.put(Field.DESCRIPTION, GetterUtil.getString(doc.get(Field.DESCRIPTION)));
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return map;
	}

}