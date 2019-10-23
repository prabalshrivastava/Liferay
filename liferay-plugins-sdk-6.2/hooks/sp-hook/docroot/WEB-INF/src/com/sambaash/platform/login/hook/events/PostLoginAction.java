package com.sambaash.platform.login.hook.events;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Bruno Farache
 */
public class PostLoginAction extends Action {

	private static final Log _log = LogFactoryUtil.getLog(PostLoginAction.class
			.getName());

	private void debug(String msg) {
		if (_log.isDebugEnabled()) {
			_log.debug(msg);
		}
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {
		// long scopeGrpId = PortalUtil.getScopeGroupId(request);
		try {
			debug("In PostLoginAction");
			processCountryDeptRolesForUser(request, response);
		} catch (Exception ex) {

		}
		try {
			roleMgmtNonAdUser(request, response);
		} catch (Exception ex) {

		}
	}

	public void roleMgmtNonAdUser(HttpServletRequest request,
			HttpServletResponse response) {
		long userId = PortalUtil.getUserId(request);
		debug("roleMgmtNonAdUser: userId " + userId);
		long companyId = PortalUtil.getCompanyId(request);
		try {
			User user = UserLocalServiceUtil.getUserById(companyId, userId);
			if (SambaashUtil.isLdapEnabled() && SambaashUtil.isNonAdUser(user)) {
				// delete all roles assigned to non ad user then assign just non
				// ad role
				List<Role> roleList = RoleLocalServiceUtil.getUserRoles(userId);
				for (Role role : roleList) {
					UserLocalServiceUtil.deleteRoleUser(role.getRoleId(),
							userId);
				}
				Role defaultNonADRole = null;
				try {
					defaultNonADRole = RoleLocalServiceUtil.getRole(companyId,
							SambaashConstants.DEFAULT_NON_AD_ROLE);
				} catch (NoSuchRoleException ne) {
					_log.error("Default Non AD role not found, will add it",ne);
					SambaashUtil.addRole(companyId, SambaashConstants.DEFAULT_NON_AD_ROLE);
				}
				RoleLocalServiceUtil.addUserRole(userId,
						defaultNonADRole.getRoleId());
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

	public void processCountryDeptRolesForUser(HttpServletRequest request,
			HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);
		long companyId = PortalUtil.getCompanyId(request);
		debug("processCountryDeptRolesForUser: userId: " + userId + " companyId :" + companyId);
		try {
			// TODO: Have to look into right way to get scope group id.Below
			// approach may fail in case multiple sites running under same
			// lifeary instance.
			long scopeGrpId = SambaashUtil.getGroupId(companyId);
			User user = UserLocalServiceUtil.getUserById(companyId, userId);
			if (SambaashUtil.isLdapEnabled() && !SambaashUtil.isNonAdUser(user)) {
				// Sept 4, 2015 Naresh - Below code added to create
				// country-department folder if it does not exist. Applicable
				// for esn ldap profiles.
				if (Validator.isNotNull(user)) {
					String country = SambaashUtil.getUserCountry(user
							.getUserId());
					String dept = SambaashUtil.getUserDepartment(user
							.getUserId());
					debug("user country :" + country + " dept :" + dept);
					PermissionUtil.initializeAdminPermissionChecker();
					if (Validator.isNotNull(country)
							&& Validator.isNotNull(dept)) {
						SambaashUtil.addCountryDeptRoles(user.getUserId(),
								companyId, country, dept);
						String countryDeptFolderFormat = "%s-%s";
						String folderName = String.format(
								countryDeptFolderFormat, country, dept);
						try {
							DLAppLocalServiceUtil.getFolder(scopeGrpId, 0,
									folderName);
						} catch (NoSuchFolderException e) {
							long adminId = SambaashUtil.getAdminUserId();
							ServiceContext serviceContext = ServiceContextFactory
									.getInstance(request);
							// .getInstance(DLFolder.class.getName(),);
							Folder folder = DLAppLocalServiceUtil.addFolder(
									adminId, scopeGrpId, 0, folderName,
									folderName, serviceContext);
							PermissionUtil
									.adDefaultFolderPermissionsForCountryDeptRoles(
											companyId, folder.getFolderId(),
											folderName);
						}
					}else{
						debug("Either country or dept is null. So country dept roles will not be assigned");
					}
					PermissionUtil.resetPermissionChecker(user);
				}
			}
		} catch (Exception ex) {

		}
	}

}