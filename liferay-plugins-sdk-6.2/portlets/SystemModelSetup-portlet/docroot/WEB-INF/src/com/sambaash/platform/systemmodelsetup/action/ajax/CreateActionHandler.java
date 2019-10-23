package com.sambaash.platform.systemmodelsetup.action.ajax;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class CreateActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output = "";// formType
		if (request.getParameter("formStorageId").isEmpty() || request.getParameter("formStorageId").equals("0")) {
			output = SystemLocalServiceUtil.createRecord(request, response);
		} else {
			output = SystemLocalServiceUtil.updateRecord(request, response);
		}
		if (request.getParameter("formType").equalsIgnoreCase("ExamBody")) {
			createExamBodyRole(output);
		}
		
		if (request.getParameter("formType").equalsIgnoreCase("ChildNavigation")) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String layoutid = "";
			try {
				
				JSONObject dataJSON =  JSONFactoryUtil.createJSONObject(request.getParameter("data"));
				
				JSONArray childLayout = dataJSON.getJSONArray("ChildLayout");
				JSONArray roles = dataJSON.getJSONArray("Roles");
				long plid = 0;
				long groupId = themeDisplay.getScopeGroupId();
				for(int i = 0; i < childLayout.length(); i++){
					layoutid = childLayout.getString(i);
					Layout ellayout = LayoutLocalServiceUtil.getLayout(groupId, false, Long.parseLong(layoutid));
					plid = ellayout.getPlid();
					
					for(int j=0; j < roles.length(); j++){
						ResourcePermissionLocalServiceUtil.setResourcePermissions(
								themeDisplay.getCompanyId(),
								Layout.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(plid),
								roles.getLong(j),
								new String[] { ActionKeys.VIEW });
					}
				}
				
				
				
				
			} catch (PortalException | SystemException e) {
				log.error(e.getMessage());
			}
			
		}
		
		
		
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			log.error(e);
		}
	}

	public void createExamBodyRole(String output) {
		try {
			JSONObject obj = JSONFactoryUtil.createJSONObject(output);
			if (obj.has("contentJson")) {
				JSONArray arrJS =  JSONFactoryUtil.createJSONArray(obj.getJSONObject("contentJson").getString("SelectPerson"));  
				Long defaultCompanyId = PortalUtil.getDefaultCompanyId();
				for (int i = 0; i < arrJS.length(); i++) {
					String roleName = arrJS.getString(i) + " " + obj.getJSONObject("contentJson").getString("ExamBody");
					String roleTitle = arrJS.getString(i) + " "
							+ obj.getJSONObject("contentJson").getString("ExamBody");
					String roleDescription = arrJS.getString(i) + " "
							+ obj.getJSONObject("contentJson").getString("Description");
					int roleType = 2;
					createSiteRole(defaultCompanyId, roleName, roleTitle, roleDescription, roleType);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private Role createSiteRole(long companyId, String roleName, String roleTitle, String roleDescription, int roleType)
			throws PortalException {

		Role checkRole = null;
		Role newRole = null;

		try {
			log.info("Checking for " + roleTitle + " Role...");
			checkRole = RoleLocalServiceUtil.fetchRole(companyId, roleName);
			if (checkRole == null) {
				log.info(roleTitle + " Role not found!");
				log.info("Creating " + roleTitle + " Role...");

				Date now = new Date();
				Long userId = UserLocalServiceUtil.getDefaultUserId(companyId);
				Long roleClassNameId = ClassNameLocalServiceUtil.getClassNameId(Role.class);
				Long roleId = CounterLocalServiceUtil.increment();

				Role role = RoleLocalServiceUtil.createRole(roleId);
				role.setName(roleName);
				role.setTitle(roleTitle);
				role.setDescription(roleDescription);
				role.setType(roleType);
				role.setUserId(userId);
				role.setCompanyId(companyId);
				role.setClassNameId(roleClassNameId);
				role.setClassPK(roleId);
				role.setCreateDate(now);
				role.setModifiedDate(now);

				/* Add the new role */
				newRole = RoleLocalServiceUtil.addRole(role);

				/* Set permissions for document view */
				addRoleResourcePermissions(newRole);
			} else {

				log.info(roleTitle + " Role exists already.");
			}

		} catch (SystemException e) {
			log.debug("createSiteRole", e);

		}

		return newRole;
	}

	private void addRoleResourcePermissions(Role role) throws PortalException, SystemException {

		log.info("Setting view documents permissions...");
		ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
				DLFolder.class.getName(), ResourceConstants.SCOPE_COMPANY,
				String.valueOf(CompanyThreadLocal.getCompanyId()), role.getRoleId(), new String[] { ActionKeys.VIEW });

		ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
				DLFileEntry.class.getName(), ResourceConstants.SCOPE_COMPANY,
				String.valueOf(CompanyThreadLocal.getCompanyId()), role.getRoleId(), new String[] { ActionKeys.VIEW });
	}
	private void AssignLayoutPermissions(String response) throws PortalException, SystemException {

	}
}
