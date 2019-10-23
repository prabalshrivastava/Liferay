package com.sambaash.platform.action.hook;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class EditRoleAction extends BaseStrutsPortletAction{
	private static Log _log = LogFactoryUtil.getLog(EditRoleAction.class);
			
	@Override
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
				
		originalStrutsPortletAction.processAction(
	            originalStrutsPortletAction, portletConfig, actionRequest,
	            actionResponse);
		try {
			ThemeDisplay themeDisplay =
		            (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
			Role role = null;
			if (cmd.equals(Constants.ADD)) {
				String name = ParamUtil.getString(actionRequest, "name");
				role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), name);
			} else if (cmd.equals(Constants.UPDATE)) {
				long roleId = ParamUtil.getLong(actionRequest, "roleId");
				role = RoleLocalServiceUtil.fetchRole(roleId);
			}
			if (role != null) {
				FormsMicroserviceLocalServiceUtil.synchroniseRole(SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()), role.getRoleId(), role.getName());				
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
    public String render(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws Exception {

    	return originalStrutsPortletAction.render(
            null, portletConfig, renderRequest, renderResponse);

    }

	@Override
    public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {

        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }
}
