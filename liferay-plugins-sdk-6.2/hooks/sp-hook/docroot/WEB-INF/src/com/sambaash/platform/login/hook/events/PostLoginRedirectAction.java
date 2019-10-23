package com.sambaash.platform.login.hook.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.CookieUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PostLoginRedirectAction extends Action {

	private static Log _log = LogFactoryUtil.getLog(PostLoginRedirectAction.class);

	public PostLoginRedirectAction() {
		super();
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {

		try {
			long groupId = PortalUtil.getScopeGroupId(request);
			String parameter = SambaashUtil.getParameter(SambaashConstants.SITE_SETTINGS.ACTIVITY_BASED_REDIRECT,
					groupId);
			Boolean activityRedirectFlag = GetterUtil.getBoolean(parameter);

			// redirect based on user activity, if enabled
			if (activityRedirectFlag) {
				String nextPath = CookieUtil.get(request, SambaashConstants.SITE_SETTINGS.USER_NEXT_PATH);

				if (Validator.isNotNull(nextPath)) {
					response.sendRedirect(nextPath);
					return;
				}

				String lastPath = CookieUtil.get(request, SambaashConstants.SITE_SETTINGS.USER_LAST_PATH);

				if (Validator.isNotNull(lastPath)) {
					response.sendRedirect(lastPath);
					return;
				}
			}

			// if disabled
//			String referee = ParamUtil.getString(request, "referee");
//			if (Validator.isNull(referee)) {
//				// no redirect found from request, so let's find if any
//				// thing configured
//				String redirect = SambaashUtil.getParameter(SambaashConstants.POST_LOGIN_REDIRECT, groupId);
//				if (Validator.isNotNull(redirect)) {
//					response.sendRedirect(redirect);
//				}
//			}
		} catch (Exception e) {
			_log.error(e);
		}

	}
}