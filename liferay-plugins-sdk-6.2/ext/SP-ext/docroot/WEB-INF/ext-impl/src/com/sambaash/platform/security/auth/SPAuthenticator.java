package com.sambaash.platform.security.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.admin.util.OmniadminUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.security.util.PasswordUtil;
import com.sambaash.platform.session.SPAuthContext;
import com.sambaash.platform.srv.spservices.model.SPSite;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.thread.SPThreadLocal;
import com.sambaash.platform.util.SambaashUtil;

public class SPAuthenticator implements Authenticator {
	private static Log _log = LogFactoryUtil.getLog(SPAuthenticator.class);

	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap) throws AuthException {

		User liferayUser = findUser(companyId, emailAddress);
		if (liferayUser == null) {
			// no Liferay user, then invalid
			return Authenticator.FAILURE;
		} else if (OmniadminUtil.isOmniadmin(liferayUser)) {
			return Authenticator.SUCCESS;
		}

		boolean liferayLogin = false;
		boolean byDomain = false;
		String spLoginType = SambaashUtil.getSPLoginType(companyId);
		int authResult = Authenticator.DNE;

		HttpSession loginSession = (HttpSession) SPThreadLocal.getValue(SPThreadLocal.Key.LOGIN_SESSION, true);
		long virtualhostId = 0;

		// either is a backoffice or has no setup in SPSiteSetup table
		// comment this if we want to use SPSite validation instead
		try {
			virtualhostId = (long) SPThreadLocal.getValue(SPThreadLocal.Key.SP_VIRTUALHOST_ID);
			boolean hasNoSetup = SPSiteSetupLocalServiceUtil.findByVirtualHostId(virtualhostId).isEmpty();
			if (hasNoSetup && SPSiteLocalServiceUtil.findByUserId(liferayUser.getUserId()).isEmpty()) {
				// then do default Liferay login
				spLoginType = SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN;
			}
		} catch (Exception e) {
			_log.error("No setup, defaulting to Liferay login.");
			spLoginType = SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN;
		}

		List<SPSite> spAuthUserList = new ArrayList<>();
		switch (spLoginType) {
		case SambaashConstants.SP_USER_BY_DOMAIN_LOGIN:
			spAuthUserList = SPSiteLocalServiceUtil.findByUserIdAndVirtualHostId(liferayUser.getUserId(),
					virtualhostId);
			byDomain = true;
			break;
		case SambaashConstants.SP_USER_BY_SPSITE_LOGIN:
			// Authenticate using SPSite entries
			String subProductIds = (String) SPThreadLocal.getValue(SPThreadLocal.Key.SP_SUB_PRODUCT_IDS);
			SPSiteSetup siteSetup = null;
			try {
				for (String subProductId : subProductIds.split(",")) {
					siteSetup = SPSiteSetupLocalServiceUtil.findBySubProductId(Long.parseLong(subProductId)).get(0);
					spAuthUserList.addAll(SPSiteLocalServiceUtil.findByUserIdAndAuthAccessId(liferayUser.getUserId(),
							siteSetup.getSpSiteSetupId()));
				}
			} catch (Exception e) {
				_log.error("Error getting setup info for sub products -> " + subProductIds);
			}
			break;
		case SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN:
			// return SUCCESS to proceed with Liferay default Authenticator
			liferayLogin = true;
			authResult = Authenticator.SUCCESS;
			break;
		default:
			break;
		}

		if (!liferayLogin && spAuthUserList.isEmpty()) {
			authResult = Authenticator.FAILURE;
		} else if (!spAuthUserList.isEmpty()) {
			for (SPSite spAuthUser : spAuthUserList) {
				String encryptedPlainPassword = PasswordUtil.encryptPassword(password, spAuthUser.getPassword());
				if (encryptedPlainPassword.equals(spAuthUser.getPassword())) {
					// ideally, there should only be 1 record
					// just in case, process all records while successful
					authResult = Authenticator.SKIP_LIFERAY_CHECK;
				} else {
					authResult = Authenticator.FAILURE;
					// on failure, stop further check
					break;
				}
			}
		}

		if (!liferayLogin && authResult == Authenticator.SKIP_LIFERAY_CHECK) {
			// set shared session data
			List<Long> spAuthAccessList = new ArrayList<>();
			List<SPSite> userSpAuthAccessList;
			if (byDomain) {
				userSpAuthAccessList = SPSiteLocalServiceUtil.findByUserIdAndVirtualHostId(liferayUser.getUserId(),
						virtualhostId);
			} else {
				userSpAuthAccessList = SPSiteLocalServiceUtil.findByUserId(liferayUser.getUserId());
			}

			for (SPSite spAuthAccess : userSpAuthAccessList) {
				if (spAuthAccess.getAuthAccessId() > 0) {
					spAuthAccessList.add(spAuthAccess.getAuthAccessId());
				}
			}

			long layoutSetId = (long) SPThreadLocal.getValue(SPThreadLocal.Key.SP_LOGIN_LAYOUTSET_ID);
			String subProductIds = (String) SPThreadLocal.getValue(SPThreadLocal.Key.SP_SUB_PRODUCT_IDS);

			SPThreadLocal.setValue(SPThreadLocal.Key.SPSITE_AUTH_ACCESS, spAuthAccessList);

			SPAuthContext.setValue(loginSession, SPAuthContext.Key.SPSITE_AUTH_ACCESS, spAuthAccessList);
			SPAuthContext.setValue(loginSession, SPAuthContext.Key.SP_LOGIN_TYPE, Long.parseLong(spLoginType));
			SPAuthContext.setValue(loginSession, SPAuthContext.Key.SP_LOGIN_LAYOUTSET_ID, layoutSetId);
			SPAuthContext.setValue(loginSession, SPAuthContext.Key.SP_VIRTUALHOST_ID, virtualhostId);
			addSiteProductIds(loginSession, virtualhostId, subProductIds);

			// additional check for Back Office users, must be registered back
			// office user
			// if ((boolean) SPAuthContext.getValue(loginSession,
			// SPAuthContext.Key.IS_BACK_OFFICE)
			// &&
			// SPSiteLocalServiceUtil.findByUserIdAndVirtualHostId(liferayUser.getUserId(),
			// virtualhostId).isEmpty()
			// ) {
			// authResult = Authenticator.FAILURE;
			// }

			// additional check for Back Office users. Handled in line 52
			// instead. Default to Liferay login
			// if ((boolean) SPAuthContext.getValue(loginSession,
			// SPAuthContext.Key.IS_BACK_OFFICE)) {
			// // Let Liferay handle the authentication for BackOffice users
			// authResult = Authenticator.SUCCESS;
			// }

		}

		return authResult;
	}

	private void addSiteProductIds(HttpSession loginSession, long virtualHostId, String subProductIds) {
		List<SPSiteSetup> clientSiteList = new ArrayList<>();
		try {
			boolean isBackOffice = SPSiteSetupLocalServiceUtil.findByVirtualHostId(virtualHostId).isEmpty();
			SPAuthContext.setValue(loginSession, SPAuthContext.Key.IS_BACK_OFFICE, isBackOffice);
			if (isBackOffice) {
				// get all site with backoffice as the current virtualhost
				clientSiteList = SPSiteSetupLocalServiceUtil.findByBackOfficeVirtualHostId(virtualHostId);
			} else {
				// otherwise, just get those specified on the page settings
				for (String subProductId : subProductIds.split(",")) {
					clientSiteList.addAll(SPSiteSetupLocalServiceUtil.findBySubProductId(Long.parseLong(subProductId)));
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		Long[] productIds = new Long[clientSiteList.size()];
		for (int i = 0; i < clientSiteList.size(); i++) {
			SPSiteSetup site = clientSiteList.get(i);
			productIds[i] = site.getSpSiteSetupId();
		}
		SPAuthContext.setValue(loginSession, SPAuthContext.Key.SPSITE_PRODUCT_IDS, productIds);
	}

	@Override
	public int authenticateByScreenName(long arg0, String arg1, String arg2, Map<String, String[]> arg3,
			Map<String, String[]> arg4) throws AuthException {
		return 0;
	}

	@Override
	public int authenticateByUserId(long arg0, long arg1, String arg2, Map<String, String[]> arg3,
			Map<String, String[]> arg4) throws AuthException {
		return 0;
	}

	private User findUser(long companyId, String emailAddress) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
		} catch (Exception e) {
			_log.error("User not found, companyId : " + companyId + " : emailAddress : " + emailAddress);
		}

		return user;
	}

}
