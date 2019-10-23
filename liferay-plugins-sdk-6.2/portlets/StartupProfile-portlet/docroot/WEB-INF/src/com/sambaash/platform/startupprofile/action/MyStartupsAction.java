package com.sambaash.platform.startupprofile.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequestWrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.startupprofile.helper.StartupPermissionHelper;
import com.sambaash.platform.startupprofile.helper.StartupProfileHelper;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class MyStartupsAction
 */
public class MyStartupsAction extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(MyStartupsAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		HttpServletRequestWrapper httpRequest = StartupProfileHelper
				.getHttpRequestWrapper(resourceRequest);
		try {

			AuthTokenUtil.checkCSRFToken(httpRequest,
					MyStartupsAction.class.getName());

		} catch (PortalException e1) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(StartupConstants.ERROR_MSG,
					StartupConstants.UNAUTH_MSG_VIEW);
			logger.error(e1.getMessage());
			resourceResponse.getWriter().write(obj.toString());
			return;
		}
		String action = ParamUtil.getString(resourceRequest,
				StartupConstants.ACTION);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		if (action.equals(StartupConstants.PARAM_DELETE_PROFILE)) {
			Long orgId = ParamUtil.getLong(resourceRequest,
					StartupConstants.ORGANIZATION_ID);
			if (logger.isDebugEnabled())
				logger.debug("Request to delete organization Id" + orgId);
			if (StartupPermissionHelper
					.canDeleteStartup(resourceRequest, orgId)) {
				try {
					OrganizationLocalServiceUtil.deleteOrganization(orgId);
					resourceResponse.getWriter().write("SUCCESS");
					if (logger.isInfoEnabled()) 
						logger.info("Organization deleted successfully" + orgId);
					try {
						if (OrganizationLocalServiceUtil.getUserOrganizations(
								themeDisplay.getUserId()).size() == 0) {
							if(logger.isDebugEnabled()) {
								logger.debug("user doesnt have any active organizations, changing the usertype");
							}
							ServiceContext serviceContext = ServiceContextFactory
									.getInstance(Organization.class.getName(),
											resourceRequest);
							SocialProfileLocalServiceUtil.updateProfileType(
									themeDisplay.getUser(), ProfileType.USER,
									serviceContext);
						}
					} catch (Exception e) {
					}
				} catch (Exception e) {
					logger.error("error deleting organization", e);
					resourceResponse.getWriter().write("FAILED");
				}
			} else {
				resourceResponse.getWriter().write("FAILED");
				logger.error("Unauthorized delete profile requested [userid, orgId]"
						+ themeDisplay.getUserId() + " " + orgId);
			}
			return;
		}

		Long userId = ParamUtil.getLong(resourceRequest,
				StartupConstants.PARAM_USER_ID);
		List<Organization> orgs = null;
		try {
			orgs = OrganizationLocalServiceUtil.getUserOrganizations(userId);
		} catch (Exception e) {
			logger.error("Error getting user organziaitons");
		}
		if (orgs == null)
			return;
		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (Organization organization : orgs) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			String name = StringUtil.shorten(organization.getName(), 24);
			if (!organization.getCompleteness()) {
				String path = themeDisplay.getPathThemeImages() + "/messages/alert.png";
				name += "<img src='" + path + "' alt='Incomplete Profile' title='Incomplete Profile'/>";
			}
			obj.put(StartupConstants.NAME, name);
			obj.put(StartupConstants.LOGO_URL, SambaashUtil.getDLFileIconUrl(resourceRequest,
					organization.getLogoId()));
			obj.put(StartupConstants.ORGANIZATION_ID,
					organization.getOrganizationId());
			obj.put(StartupConstants.FRIENDLY_URL, StartupProfileHelper
				.displayStartupDetailsFriendlyURL(themeDisplay, organization.getOrganizationId()));
			obj.put(StartupConstants.EDIT_FRIENDLY_URL, StartupProfileHelper
				.editStartupFriendlyURL(themeDisplay, organization.getOrganizationId()));
			obj.put(StartupConstants.IS_PROFILE_COMPLETE,
					organization.getCompleteness());
			array.put(obj);
		}
		resourceResponse.getWriter().write(array.toString());
	}

}
