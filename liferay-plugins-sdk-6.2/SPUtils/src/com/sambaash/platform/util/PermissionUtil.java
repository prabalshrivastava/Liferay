
package com.sambaash.platform.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil;

/**
 * @author gauravvijayvergia
 *
 */
public class PermissionUtil {

	private static Log _log = LogFactoryUtil.getLog(PermissionUtil.class);

	public static boolean contains(PermissionChecker permissionChecker, String portlet, long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, portlet, groupId, actionId);
	}

	public static void check(PermissionChecker permissionChecker, String portlet, long groupId, String actionId)
			throws PortalException {

		if (!contains(permissionChecker, portlet, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void checkCalendar(PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException {

		if (!containsCalendar(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean containsCalendar(PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, "com.liferay.portlet.calendar", groupId, actionId);
	}

	public static void checkCalEvent(PermissionChecker permissionChecker, CalendarBooking event, String actionId)
			throws PortalException {

		if (!containsCalEvent(permissionChecker, event, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void checkCalEvent(PermissionChecker permissionChecker, long eventId, String actionId)
			throws PortalException, SystemException {

		if (!containsCalEvent(permissionChecker, eventId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean containsCalEvent(PermissionChecker permissionChecker, CalendarBooking event,
			String actionId) {

		if (permissionChecker.hasOwnerPermission(event.getCompanyId(), CalendarBooking.class.getName(),
				event.getCalendarBookingId(), event.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(event.getGroupId(), CalendarBooking.class.getName(),
				event.getCalendarBookingId(), actionId);
	}

	public static boolean containsCalEvent(PermissionChecker permissionChecker, long eventId, String actionId)
			throws PortalException, SystemException {

		CalendarBooking event = CalendarBookingLocalServiceUtil.getCalendarBooking(eventId);

		return containsCalEvent(permissionChecker, event, actionId);
	}

	public static List<Role> getRoles(long comapnyId, long userId) {
		List<Role> filteredRoles = new ArrayList<Role>();

		try {

			List<Role> roleListOfLoggedInUser = RoleServiceUtil.getUserRoles(userId);

			for (Role roles : roleListOfLoggedInUser) {
				long roleId = roles.getRoleId();

				List<SPRoles> spRolesList = SPRolesLocalServiceUtil.findByRoleId(SambaashUtil.getGroupId(comapnyId),
						roleId);

				if (!spRolesList.isEmpty()) {
					for (SPRoles spRoles : spRolesList) {
						List<SPRoles> spRolesListByCategoryId = SPRolesLocalServiceUtil
								.findByCategoryId1(SambaashUtil.getGroupId(comapnyId), spRoles.getCategoryId1());
						if (!spRolesListByCategoryId.isEmpty()) {
							for (SPRoles spRole : spRolesListByCategoryId) {
								try {
									Role role = RoleLocalServiceUtil.getRole(spRole.getRoleId());
									if (!filteredRoles.contains(role)) {
										filteredRoles.add(role);
									}
								} catch (Exception e) {
									_log.error(e);
								}
							}
						}
					}
				}
			}

		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}

		return filteredRoles;
	}

	/**
	 * @param companyId
	 * @param resourceClassName
	 * @param primaryKey
	 * @param listOfKeys
	 */
	public static void addDefaultRoleResourcePermission(long companyId, String resourceClassName, long primaryKey,
			String[] listOfKeys) {

		long roleId = SambaashUtil.getDefaultViewRoleId(companyId);

		addResourcePermission(companyId, roleId, resourceClassName, primaryKey, listOfKeys);
	}

	/**
	 * @param companyId
	 * @param roleId
	 * @param resourceClassName
	 * @param primaryKey
	 * @param listOfKeys
	 */
	public static void addResourcePermission(long companyId, long roleId, String resourceClassName, long primaryKey,
			String[] listOfKeys) {

		if (roleId > -1L && primaryKey > 0) {
			try {

				if (_log.isDebugEnabled()) {
					_log.debug("Adding fileEntry view access for roleId : " + roleId + " : resourceClassName : "
							+ resourceClassName + " : " + primaryKey);
				}

				ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, resourceClassName,
						ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(primaryKey), roleId, listOfKeys);
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			_log.error("**-----** Role ID doesn't exists or primaryKey is not valid. roleId : " + roleId
					+ " : resourceClassName : " + resourceClassName + " : " + primaryKey);
		}
	}

	public static void initializeAdminPermissionChecker() throws Exception {
		try {
			Role adminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			PrincipalThreadLocal.setName(adminUsers.get(0).getUserId());
			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUsers.get(0));
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
		} catch (Exception e) {
			_log.error("initializeAdminPermissionChecker FAILED");
		}
	}

	public static void initializeAdminPermissionCheckerByCompanyId(long companyId) throws Exception {
		try {
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			_log.debug("adminRole ID =" + adminRole.getRoleId());
			_log.debug("adminUsers size =" + adminUsers.size());
			PrincipalThreadLocal.setName(adminUsers.get(0).getUserId());
			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(adminUsers.get(0));
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
		} catch (Exception e) {
			_log.error("initializeAdminPermissionCheckerByCompanyId FAILED", e);
		}
	}

	public static void resetPermissionChecker(User user) throws Exception {

		PrincipalThreadLocal.setName(user.getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
	}

	public static void adDefaultFolderPermissionsForCountryDeptRoles(long companyId, long folderId,
			String roleNamePrefix) {
		if (companyId != 0 && folderId != 0 && Validator.isNotNull(roleNamePrefix)) {
			try {
				long roleId;
				String[] allKeys = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
						ActionKeys.ADD_SUBFOLDER, ActionKeys.ADD_SHORTCUT, ActionKeys.DELETE, ActionKeys.PERMISSIONS,
						"SHARE" };
				try {
					roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix + "-User").getRoleId();
					PermissionUtil.addResourcePermission(companyId, roleId, DLFolder.class.getName(), folderId,
							new String[] { ActionKeys.VIEW });

				} catch (Exception ex) {
					_log.error(ex);
				}
				try {
					roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix + "-Doc_Control").getRoleId();
					PermissionUtil.addResourcePermission(companyId, roleId, DLFolder.class.getName(), folderId,
							allKeys);
				} catch (Exception ex) {
					_log.error(ex);
				}
				try {
					roleId = RoleLocalServiceUtil.getRole(companyId, roleNamePrefix + "-Admin").getRoleId();
					PermissionUtil.addResourcePermission(companyId, roleId, DLFolder.class.getName(), folderId,
							allKeys);

				} catch (Exception ex) {
					_log.error(ex);
				}
			} catch (Exception ex) {

			}
		}
	}

	public static void inheritPermissionsForFile(long fileEntryId, String permOperation, List<Long> roleIds) {
		try {
			DLFileEntry dfe = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			inhertParentPermissions(dfe, permOperation, roleIds);
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

	public static void inheritPermissionsForFolder(long folderId, String permOperation, List<Long> roleIds) {
		try {
			DLFolder dlEntry = DLFolderLocalServiceUtil.getDLFolder(folderId);
			inhertParentPermissions(dlEntry, permOperation, roleIds);
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

	public static boolean isInheritPermissionModelEnabled() {
		return GetterUtil.getBoolean(PropsUtil.get(SambaashConstants.KEY_USE_PERMISSION_INHERITANCE_MODEL), false);
	}

	public static void inhertParentPermissions(DLFolder dlEntry, String permModel, List<Long> roleIds) {
		boolean useInheritanceModel = isInheritPermissionModelEnabled();
		// String permModel =
		// GetterUtil.getString(PropsUtil.get(SambaashConstants.KEY_USE_PERMISSION_OPERATION),
		// "SET");
		inhertParentPermissions(dlEntry, useInheritanceModel, permModel, roleIds);
	}

	public static void inhertParentPermissions(DLFileEntry addedFileEntry, String permModel, List<Long> roleIds) {

		boolean useInheritanceModel = isInheritPermissionModelEnabled();
		// String permModel =
		// GetterUtil.getString(PropsUtil.get(SambaashConstants.KEY_USE_PERMISSION_OPERATION),
		// "SET");
		inhertParentPermissions(addedFileEntry, useInheritanceModel, permModel, roleIds);
	}

	public static void inheritPermissionsToChilds(final long folderId, long groupId, long companyId, String operation,
			boolean includeCurrentFolder, List<Long> roleIds) throws PortalException, SystemException, IOException {
		try {
			boolean useInheritanceModel = isInheritPermissionModelEnabled();
			if (!useInheritanceModel) {
				_log.debug("inhertParentPermissions is false. so no permission operation will be performed ");
				return;
			}
			_log.debug("Process started for folder " + folderId + " operation = " + operation);
			if (folderId != 0) {
				try {
					if (includeCurrentFolder) {
						DLFolder folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
						// Ignore folders under root
						if (folder.getParentFolderId() != 0) {
							PermissionUtil.inhertParentPermissions(folder, true, operation, roleIds);
						} else {
							_log.debug("Skipping permisstion inheritance for folder " + folder.getName()
									+ ". This folder is directly under ROOT. So skipping");
						}
					}
				} catch (Exception ex) {
					_log.error("EXCEPTION while processing folder " + folderId);
				}
			} else {
				_log.debug("Skipping permisstion inheritance for folder " + folderId);
			}
			List<Folder> childFolders = DLAppServiceUtil.getFolders(groupId, folderId);
			for (Folder childFolder : childFolders) {
				DLFolder childDlF = DLFolderLocalServiceUtil.getDLFolder(childFolder.getFolderId());
				inheritPermissionsToChilds(childDlF.getFolderId(), groupId, companyId, operation, true, roleIds);
			}
			// Dont process for files directuly under root folder
			if (folderId != 0) {
				try {
					DLFolder folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
					// Ignore files under public folder
					/*
					 * if(!(folder.getParentFolderId() == 0 &&
					 * folder.getName().equalsIgnoreCase("Public Folder"))
					 * ){}else{ debug(
					 * "Ignoring permissions for files under public folder"); }
					 */

					List<FileEntry> fes = DLAppServiceUtil.getFileEntries(folder.getGroupId(), folder.getFolderId());
					for (FileEntry fe : fes) {
						try {
							DLFileEntry dlFe = DLFileEntryLocalServiceUtil.getDLFileEntry(fe.getFileEntryId());
							PermissionUtil.inhertParentPermissions(dlFe, true, operation, roleIds);
						} catch (Exception ex) {
							_log.error(
									"EXCEPTION : while assigning permissions for file entry id " + fe.getFileEntryId());
						}
					}

				} catch (Exception ex) {
					_log.error("EXCEPTION while assigning permissions " + ex.getMessage());
				}
			} else {
				_log.error("Skipping permisstion inheritance for files under root ");
			}
		} catch (Exception e) {
			_log.error("EXCEPTION while assigning permissions " + e.getMessage());
		}
	}

	public static void inhertParentPermissions(DLFolder dlEntry, boolean useInheritanceModel, String permModel,
			List<Long> roleIds) {
		_log.debug("Start of inhertParentPermissions dlEntry=" + dlEntry + " useInheritanceModel=" + useInheritanceModel
				+ " permisison operatio " + permModel);
		if (!useInheritanceModel) {
			_log.debug("inhertParentPermissions is false. so no permission operation will be performed");
			return;
		}
		try {
			// get parent
			DLFolder parentFolder = dlEntry.getParentFolder();
			// check for existence
			if (dlEntry.getFolderId() != 0 && parentFolder != null && parentFolder.getFolderId() != 0) {
				DLFolder addedFolderEntry = dlEntry;
				long companyId = parentFolder.getCompanyId();
				int scope = ResourceConstants.SCOPE_INDIVIDUAL;
				String parentPrimKey = String.valueOf(parentFolder.getFolderId());
				String newPrimKey = String.valueOf(addedFolderEntry.getFolderId());

				// Role guest = RoleLocalServiceUtil.getRole(companyId,
				// RoleConstants.GUEST);
				// PERMISSION INHERItance applicable only if guest view
				// permission is enabled
				/*
				 * if(!ResourcePermissionLocalServiceUtil.hasResourcePermission(
				 * companyId, DLFolder.class.getName(), scope, newPrimKey,
				 * guest.getRoleId(), "VIEW")){ debug(
				 * "Guest has no VIEW permission on given folder. Hence permission operation will not performed"
				 * ); return;
				 * 
				 * }
				 */

				// _log.error("Guest has VIEW permission on given folder.
				// permission
				// operation " + permModel + " is going to take place");
				// ----------------------------
				// V 6.0.5 avec Algo 6
				// ----------------------------

				// Get the list of roles and permissions associated each role.
				List<ResourcePermission> rpParent = ResourcePermissionLocalServiceUtil.getResourcePermissions(companyId,
						DLFolder.class.getName(), scope, parentPrimKey);
				// Get the list of actions associated with folder
				List<ResourceAction> lResourceAction = ResourceActionLocalServiceUtil
						.getResourceActions(DLFolder.class.getName());
				// We loop on the parent permissions_rôle
				for (int i = 0; i < rpParent.size(); i++) {
					// Permissions for a role
					ResourcePermission rp = rpParent.get(i);

					// If roleIds is null, which mean apply for all roles which
					// having permission on parent.
					// If roleIds is not null appply for only roles in roleIds
					// list
					if (Validator.isNotNull(roleIds)) {
						boolean applyPermissions = false;
						for (Long roleId : roleIds) {
							if (roleId == rp.getRoleId()) {
								applyPermissions = true;
								break;
							}
						}
						if (!applyPermissions) {
							continue;
						}
					}

					// List of action Ids to assign on each role for newly added
					// folder
					List<String> actionIds = new ArrayList<String>();

					if (SambaashConstants.PERMISSION_OPERATION_MERGE.equalsIgnoreCase(permModel)) {
						try {
							ResourcePermission existingRP = ResourcePermissionLocalServiceUtil.getResourcePermission(
									companyId, DLFolder.class.getName(), scope, newPrimKey, rp.getRoleId());
							for (ResourceAction action : lResourceAction) {
								if (ResourcePermissionLocalServiceUtil.hasActionId(existingRP, action)) {
									actionIds.add(action.getActionId());
								}
							}
						} catch (Exception ex) {

						}
						_log.debug("Existing permisison for role (id) " + rp.getRoleId() + " actionIds " + actionIds);
					}

					// For each action
					for (ResourceAction resourceAction : lResourceAction) {
						// Permission is it you for this action?
						if (ResourcePermissionLocalServiceUtil.hasActionId(rp, resourceAction)) {
							// If so, adding to the list of actions Ids
							actionIds.add(resourceAction.getActionId());

						}
					}

					_log.debug("ResourcePermission update about to take place.RoleId = " + rp.getRoleId() + " primKey "
							+ newPrimKey + " actionIds " + actionIds);

					// Call for service to set permissions for the new folder
					ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, DLFolder.class.getName(),
							scope, newPrimKey, rp.getRoleId(), actionIds.toArray(new String[actionIds.size()]));
				}

			}
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

	public static void inhertParentPermissions(DLFileEntry addedFileEntry, boolean useInheritanceModel,
			String permModel, List<Long> roleIds) {
		_log.debug("Start of inhertParentPermissions addedFileEntry=" + addedFileEntry + " useInheritanceModel="
				+ useInheritanceModel + " permisison operatio " + permModel);
		if (!useInheritanceModel) {
			_log.debug("inhertParentPermissions is false. so no permission operation will be performed");
			return;
		}
		try {
			DLFolder parentFolder = addedFileEntry.getFolder();
			if (addedFileEntry.getFileEntryId() != 0 && parentFolder != null && parentFolder.getFolderId() != 0) {
				long companyId = parentFolder.getCompanyId();
				String parentPrimKey = String.valueOf(parentFolder.getFolderId());
				String newPrimKey = String.valueOf(addedFileEntry.getFileEntryId());
				int scope = ResourceConstants.SCOPE_INDIVIDUAL;
				// Role guest = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);
				// PERMISSION INHERItance applicable only if guest view
				// permission is enabled
				/*
				 * if
				 * (!ResourcePermissionLocalServiceUtil.hasResourcePermission(
				 * companyId, DLFileEntry.class.getName(), scope, newPrimKey,
				 * guest.getRoleId(), "VIEW")) { debug(
				 * "Guest has no VIEW permission on given folder. Hence permission operation will not performed"
				 * ); return;
				 * 
				 * }
				 */

				/// _log.error("Guest has VIEW permission on given folder.
				/// permission
				/// operation " + permModel + " is going to take place");

				// Get the list of roles and permissions associated each role.
				List<ResourcePermission> rpParent = ResourcePermissionLocalServiceUtil.getResourcePermissions(companyId,
						DLFolder.class.getName(), scope, parentPrimKey);
				// Get the list of actions associated with folder
				List<ResourceAction> fileActions = ResourceActionLocalServiceUtil
						.getResourceActions(DLFileEntry.class.getName());
				List<ResourceAction> folderActions = ResourceActionLocalServiceUtil
						.getResourceActions(DLFolder.class.getName());
				// We loop on the parent permissions_rôle
				for (int i = 0; i < rpParent.size(); i++) {
					// Permissions for a role on parent folder
					ResourcePermission rp = rpParent.get(i);

					// If roleIds is null, which mean apply for all roles which
					// having permission on parent.
					// If roleIds is not null appply for only roles in roleIds
					// list
					if (Validator.isNotNull(roleIds)) {
						boolean applyPermissions = false;
						for (Long roleId : roleIds) {
							if (roleId == rp.getRoleId()) {
								applyPermissions = true;
								break;
							}
						}
						if (!applyPermissions) {
							continue;
						}
					}

					// List of action Ids to assign on each role for newly added
					// folder

					List<String> actionIds = new ArrayList<String>();

					try {
						ResourcePermission rpFile = ResourcePermissionLocalServiceUtil.getResourcePermission(companyId,
								DLFileEntry.class.getName(), scope, newPrimKey, rp.getRoleId());
						for (ResourceAction action : fileActions) {
							if (ResourcePermissionLocalServiceUtil.hasActionId(rpFile, action)) {
								actionIds.add(action.getActionId());
							}
						}
						_log.debug("Existing file permisisons for role (id) " + rp.getRoleId() + " actionIds=  "
								+ actionIds);
					} catch (Exception ex) {

					}
					// For each folder action
					for (ResourceAction resourceAction : folderActions) {
						// Permission is it you for this action?
						if (ResourcePermissionLocalServiceUtil.hasActionId(rp, resourceAction)) {
							// if same action availble on file also, then add it
							// action ids
							for (ResourceAction action : fileActions) {
								if (resourceAction.getActionId().equalsIgnoreCase(action.getActionId()))
									// If so, adding to the list of actions Ids
									actionIds.add(action.getActionId());
							}
						} else if (SambaashConstants.PERMISSION_OPERATION_SET.equalsIgnoreCase(permModel)) {
							Iterator<String> iterator = actionIds.listIterator();
							while (iterator.hasNext()) {
								String action = iterator.next();
								if (action.equalsIgnoreCase(resourceAction.getActionId())) {
									iterator.remove();
								}
							}
						}
					}
					_log.debug("ResourcePermission update about to take place.RoleId = " + rp.getRoleId() + " primKey "
							+ newPrimKey + " actionIds " + actionIds);
					// Call for service to set permissions for the new folder
					ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, DLFileEntry.class.getName(),
							scope, newPrimKey, rp.getRoleId(), actionIds.toArray(new String[actionIds.size()]));
				}
			}
		} catch (Exception ex) {
			_log.error(ex);
		}

	}

	public static void logUnauthorizedUser(PortletRequest request, String action) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		_log.error("Unauthorized user with id = " + themeDisplay.getUserId() + " trying to " + action);
	}

	public static boolean canViewListing(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {

			if ((authorize(request, SystemSetupConstants.ACTION_VIEW_LISTING))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "listing");

		return canView;
	}

	public static boolean canViewModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_VIEW_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "view");
		return canView;
	}

	public static boolean canMasterViewModel(PortletRequest request) {
		boolean canMasterView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_MASTERVIEW_MODEL))) {
				canMasterView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canMasterView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canMasterView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "view");
		return canMasterView;
	}

	public static boolean canAddModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_ADD_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Add");
		return canView;
	}

	public static boolean canRecordManuallyModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_RECORD_MANUALLY_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Record Manually");
		return canView;
	}

	public static boolean canSendInvoiceModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_SEND_INVOICE))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Send Invoice");
		return canView;
	}

	public static boolean canDownloadInvoiceModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_DOWNLOAD_INVOICE))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Download Invoice");
		return canView;
	}

	public static boolean canMakePaymentModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_MAKE_PAYMENT))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Make Payment");
		return canView;
	}

	public static boolean canMarkVerifiedModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_MARK_VERIFIED))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Mark As Verified");
		return canView;
	}

	public static boolean canMarkSelfSponsoredModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_MARK_SELF_SPONSORED))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Mark As Self-Sponsored");
		return canView;
	}

	public static boolean canRecordByBarcodeModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_RECORD_BY_BARCODE_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Record By Barcode Reader");
		return canView;
	}

	public static boolean canExportAsPdfModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_EXPORT_AS_PDF_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Export As PDF Model");
		return canView;
	}

	public static boolean canPrintModel(PortletRequest request) {
		boolean canPrint = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_PRINT_MODEL))) {
				canPrint = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canPrint = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canPrint && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Print");
		return canPrint;
	}

	public static boolean canEditModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_EDIT_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Edit");
		return canView;
	}

	public static boolean canDeleteModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_ARCHIVE_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Delete");
		return canView;
	}

	public static boolean canCopyModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_COPY_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Copy");
		return canView;
	}

	public static boolean canExportModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_EXPORT_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Export");
		return canView;
	}

	public static boolean canActivateModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_ACTIVATE_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Activate");
		return canView;
	}

	public static boolean canBlacklistModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_BLACLIST_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Blacklist");
		return canView;
	}

	public static boolean canConfirmModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_CONFIRM_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Confirm");
		return canView;
	}

	public static boolean canCancelModel(PortletRequest request) {
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_CANCEL_MODEL))) {
				canView = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canView = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canView && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Confirm");
		return canView;
	}

	public static boolean canSubmitRPEC(PortletRequest request) {
		boolean canSubmitRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.SUBMIT_RPEC))) {
				canSubmitRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canSubmitRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canSubmitRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Publish RPEC");
		return canSubmitRPEC;
	}

	public static boolean canPublishRPEC(PortletRequest request) {
		boolean canPublishRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_PUBLISH_REORD))) {
				canPublishRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canPublishRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canPublishRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Publish RPEC");
		return canPublishRPEC;
	}

	public static boolean canStandardReviewRPEC(PortletRequest request) {
		boolean canReviewRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_STANDARD_REVIEW))) {
				canReviewRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canReviewRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canReviewRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Review RPEC");
		return canReviewRPEC;
	}

	public static boolean canApprovedRPEC(PortletRequest request) {
		boolean canApproveRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_APPROVED))) {
				canApproveRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canApproveRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canApproveRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Approve RPEC");
		return canApproveRPEC;
	}

	public static boolean canRejectRPEC(PortletRequest request) {
		boolean canRejectRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_REJECTED))) {
				canRejectRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canRejectRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canRejectRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Reject RPEC");
		return canRejectRPEC;
	}

	public static boolean canFinalSignOff(PortletRequest request) {
		boolean canDoFinalSignOff = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_FINAL_SIGN_OFF))) {
				canDoFinalSignOff = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canDoFinalSignOff = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canDoFinalSignOff && _log.isWarnEnabled())
			logUnauthorizedUser(request, "final Sign Off RPEC");
		return canDoFinalSignOff;
	}

	public static boolean canFinalReview(PortletRequest request) {
		boolean canDoFinalReview = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_FINAL_REVIEW))) {
				canDoFinalReview = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canDoFinalReview = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canDoFinalReview && _log.isWarnEnabled())
			logUnauthorizedUser(request, "final review RPEC");
		return canDoFinalReview;
	}

	public static boolean canReviewContext(PortletRequest request) {
		boolean canReviewContext = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.RPEC_REVIEW_RECORD))) {
				canReviewContext = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canReviewContext = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canReviewContext && _log.isWarnEnabled())
			logUnauthorizedUser(request, "review RPEC");
		return canReviewContext;
	}

	public static boolean canNullifyRecord(PortletRequest request) {
		boolean canNullifyRecord = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.NULLIFY_RECORD))) {
				canNullifyRecord = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canNullifyRecord = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canNullifyRecord && _log.isWarnEnabled())
			logUnauthorizedUser(request, "review RPEC");
		return canNullifyRecord;
	}

	public static boolean canViewRPEC(PortletRequest request) {
		boolean canViewRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.VIEW_RPEC))) {
				canViewRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canViewRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canViewRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "View RPEC");
		return canViewRPEC;
	}

	public static boolean canEditRPEC(PortletRequest request) {
		boolean canEditRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.EDIT_RPEC))) {
				canEditRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canEditRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canEditRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Edit RPEC");
		return canEditRPEC;
	}

	public static boolean canAmendRPEC(PortletRequest request) {
		boolean canAmendRPEC = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.AMEND_RPEC))) {
				canAmendRPEC = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canAmendRPEC = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canAmendRPEC && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Amend RPEC");
		return canAmendRPEC;
	}

	public static boolean canArchiveRPECRecord(PortletRequest request) {
		boolean canArchiveRPECRecord = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ARCHIVE_RPEC))) {
				canArchiveRPECRecord = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canArchiveRPECRecord = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canArchiveRPECRecord && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Add RPEC Record");
		return canArchiveRPECRecord;
	}

	public static boolean canCreateRPECRecord(PortletRequest request) {
		boolean canCreateRPECRecord = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.CREATE_RPEC))) {
				canCreateRPECRecord = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canCreateRPECRecord = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!canCreateRPECRecord && _log.isWarnEnabled())
			logUnauthorizedUser(request, "Add RPEC Record");
		return canCreateRPECRecord;
	}

	public static boolean authorize(PortletRequest request, String action) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid, themeDisplay.getPortletDisplay().getId(), action);
		} catch (PrincipalException pe) {
			_log.error(pe.getMessage());
			return false;
		} catch (Exception e) {
			_log.error(e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean canSendNotificationForAttendance(PortletRequest request) {
		boolean sendNotification = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if ((authorize(request, SystemSetupConstants.ACTION_SEND_NOTIFICATION))) {
				sendNotification = true;
			}
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				sendNotification = true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		if (!sendNotification && _log.isWarnEnabled())
			logUnauthorizedUser(request, "SendNotificationForAttendance");
		return sendNotification;
	}
}
