package com.sambaash.platform.changepassword.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.compat.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.service.PasswordPolicyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class UpdateActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(UpdateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		JSONObject output;
		try {
			response.getWriter().write(updatePassword(request, response).toString());
		} catch (Exception e) {
			log.error(e);
		}

	}

	public JSONObject updatePassword(ResourceRequest actionRequest, ResourceResponse actionResponse)
			throws ValidatorException, IOException {
		JSONObject obj = new JSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String current = uploadRequest.getParameter(actionResponse.getNamespace() + "current");
		String password1 = uploadRequest.getParameter(actionResponse.getNamespace() + "password1");
		String password2 = uploadRequest.getParameter(actionResponse.getNamespace() + "password2");
		log.info(current + "   " + password1 + "   " + password2);
		try {
			long userId = UserLocalServiceUtil.authenticateForBasic(themeDisplay.getCompanyId(), "emailAddress",
					themeDisplay.getUser().getEmailAddress(), current);

			if (themeDisplay.getUserId() != userId) {
				obj.put("status", false);
				obj.put("msg", "Invalid Current Password.");

			} else if (!password1.equals(password2)) {
				obj.put("status", false);
				obj.put("msg", "New Password and Confirm Password mismatch.");

			} else {

				Long companyId = PortalUtil.getDefaultCompanyId();
				PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(companyId);
				ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
				Class<?> pwdToolkitUtilClass = portalClassLoader
						.loadClass("com.liferay.portal.security.pwd.PwdToolkitUtil");
				MethodKey methodKey = new MethodKey(pwdToolkitUtilClass, "validate", long.class, long.class,
						String.class, String.class, PasswordPolicy.class);
				PortalClassInvoker.invoke(true, methodKey, companyId, new Long(0), password2, password1,
						passwordPolicy);
				UserLocalServiceUtil.updatePassword(userId, password1, password2, false);
				obj.put("status", true);
				obj.put("msg", "Successfully Updated Password");

			}

		} catch (Exception exception) {
			try {
				obj.put("status", false);
				if (exception.getClass().equals(UserPasswordException.class)) {
					int type = ((UserPasswordException) exception).getType();
					log.trace("Exception type: " + type);
					switch (type) {
					case UserPasswordException.PASSWORD_SAME_AS_CURRENT:
						obj.put("msg", "Current password is equal to new password, no update necessary.");
						log.trace("Current password is equal to new password, no update necessary.");
						break;
					case UserPasswordException.PASSWORD_ALREADY_USED:
						obj.put("msg", "Password is already used");
						log.trace("Password is already used");
						break;
					case UserPasswordException.PASSWORD_TOO_YOUNG:
						obj.put("msg", "Password is too young");
						log.trace("Password is too young");
						break;
					case UserPasswordException.PASSWORDS_DO_NOT_MATCH:
						obj.put("msg", "Password do not match");
						log.trace("Password do not match");
						break;
					case UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS:
						obj.put("msg", "Password contens trivial words");
						log.trace("Password contens trivial words");
						break;
					case UserPasswordException.PASSWORD_INVALID:
						obj.put("msg", "Password Invalid");
						log.trace("Password Invalid");
						break;
					case UserPasswordException.PASSWORD_LENGTH:
						obj.put("msg", "Password should be grater then 6 character");
						log.trace("Password should be grater then 6 character");
						break;
					case UserPasswordException.PASSWORD_NOT_CHANGEABLE:
						obj.put("msg", "Password not chaingable");
						log.trace("Password not chaingable");
						break;
					case UserPasswordException.PASSWORD_TOO_TRIVIAL:
						obj.put("msg", "Password too trivial");
						log.trace("Password too trivial");
						break;

					default:
						obj.put("msg", exception.getLocalizedMessage());
						log.trace("Error updating User Test: " + exception + ", type " + type);
					}
				}
			} catch (JSONException e) {
				log.error(e.getMessage());
			}

			log.error(exception);
		}
		return obj;
	}

}
