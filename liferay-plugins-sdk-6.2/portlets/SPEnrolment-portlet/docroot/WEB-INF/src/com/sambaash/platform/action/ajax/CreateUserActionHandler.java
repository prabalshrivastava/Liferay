package com.sambaash.platform.action.ajax;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.util.SambaashUtil;

public class CreateUserActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(CreateUserActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String userJson = request.getParameter("data");
		JSONObject userData;
		try {
			userData = JSONFactoryUtil.createJSONObject(userJson);
			User user = this.addUser(request, userData.getString("PrimaryEmailAddress"), userData.getString("FirstName"), userData.getString("LastName"));
			response.getWriter().write(String.valueOf(user.getUserId()));

		} catch (JSONException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}

	}

	protected User addUser(ResourceRequest request, String email, String fName, String lName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String defaultTempPw = SPAuthenticationUtil.getEnrolmentDefaultTempPassword(themeDisplay);

		Date date = new Date();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUuid(UUID.randomUUID().toString());
		serviceContext.setCreateDate(date);
		serviceContext.setModifiedDate(date);
		long companyId = PortalUtil.getDefaultCompanyId();
		long creatorUserId = 0;
		boolean autoPassword = false;
		boolean autoScreenName = false;
		boolean male = true;
		boolean sendEmail = false;
		int prefixId = 1;
		int suffixId = 1;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String firstName = fName;
		String lastName = lName;
		String screenName = firstName+ " " + lastName;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] userGroupIds = null;
		String password1 = defaultTempPw;
		String password2 = defaultTempPw;
		String emailAddress = email;
		long facebookId = 0;
		String openId = "";
		Locale locale = LocaleUtil.getDefault();
		Role rolePu;
		User user = null;
		try {
			rolePu = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
			long[] roleIds = { rolePu.getRoleId() };

			user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1,
					password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, "",
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			user.setPassword(defaultTempPw);
			user.setPasswordEncrypted(false);
			user.setPasswordReset(true);
			UserLocalServiceUtil.updateUser(user);
			SPAuthenticationUtil.addSiteMembership(request, user);
			SPAuthenticationUtil.addOrUpdateSPSiteUser(request, user.getUserId(), user.getPassword());
		} catch (SystemException e) {
			_log.error(e);
		} catch (DuplicateUserEmailAddressException e) {
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			} catch (PortalException e1) {
				_log.error(e1);
			} catch (SystemException e1) {
				_log.error(e1);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		
		return user;
	}
}
