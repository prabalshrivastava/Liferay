package com.liferay.portal.security.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.pwd.PwdAuthenticator;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

public class DBAuth implements Authenticator {

	private static Log _log = LogFactoryUtil.getLog(DBAuth.class);

	public int authenticateByEmailAddress(long companyId, String emailAddress, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap) throws AuthException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int authenticateByScreenName(long companyId, String screenName, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap) throws AuthException {
		int authResult = FAILURE;
		_log.error("authenticateByScreenName ");
		try {

			User user = null;

			try {
				user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			} catch (NoSuchUserException e) {
				_log.error("User not found. will import from ldap");
			}

			if (Validator.isNotNull(user)) {
				ExpandoBridge bridge = user.getExpandoBridge();
				Date startDate = (Date) ExpandoValueLocalServiceUtil.getData(companyId, bridge.getClassName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.USER.START_DATE, user.getUserId());
				Date endDate = (Date) ExpandoValueLocalServiceUtil.getData(companyId, bridge.getClassName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.USER.END_DATE, user.getUserId());
				boolean nonAdUser = ExpandoValueLocalServiceUtil.getData(companyId, bridge.getClassName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.USER.NON_AD, user.getUserId(),
						false);
				// If AD user,then return success
				if (!nonAdUser) {
					return SUCCESS;
				}
				//System.out.println("authenticateByScreenName " + user);
				Date now = new Date();
				if (now.compareTo(startDate) >= 0 && now.compareTo(endDate) <= 0) {
					boolean authenticated = PwdAuthenticator.authenticate(screenName, password, user.getPassword());
					if (authenticated) {
						authResult = SUCCESS;
						
						if(SambaashUtil.isAdmin(SambaashUtil.getGroupId(companyId), user.getUserId())){
							return authResult;
						}
						
						List<Role> roleList = RoleLocalServiceUtil.getUserRoles(user.getUserId());
						
						Role defaultNonADRole = null;

						try {
							defaultNonADRole = RoleLocalServiceUtil.getRole(user.getCompanyId(),
									SambaashConstants.DEFAULT_NON_AD_ROLE);
						} catch (NoSuchRoleException ne) {
							_log.error("Default Non AD role not found, will add it");
							Map<Locale, String> titleMap = new HashMap<Locale, String>();
							titleMap.put(LocaleUtil.getDefault(), SambaashConstants.DEFAULT_NON_AD_ROLE);

							Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
							descriptionMap.put(LocaleUtil.getDefault(),
									"This is default role for NON AD users with limited access");
						/*	defaultNonADRole = RoleLocalServiceUtil.addRole(SambaashUtil.getAdminUserId(),
									user.getCompanyId(), SambaashConstants.DEFAULT_NON_AD_ROLE, titleMap,
									descriptionMap, RoleConstants.TYPE_REGULAR); */
							defaultNonADRole = RoleLocalServiceUtil.addRole(SambaashUtil.getAdminUserId(), null, 0, SambaashConstants.DEFAULT_NON_AD_ROLE,
									titleMap, descriptionMap, RoleConstants.TYPE_REGULAR, null, null);
						}
						//System.out.println("defaultNonADRole " + defaultNonADRole );
						for (Role role : roleList) {
							//System.out.println("role " + role.getName() + "" + role.compareTo(defaultNonADRole));
							if(!(role.compareTo(defaultNonADRole) == 0)){
								_log.info("role condition " + role.getName());
								UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), user.getUserId());
							}
						}
						RoleLocalServiceUtil.addUserRoles(user.getUserId(), new long[]{defaultNonADRole.getRoleId()});

					} else {
						authResult = FAILURE;
					}
				} else {
					if(_log.isDebugEnabled()){
						_log.debug("Account expired. Start Date =" + startDate + " End Date= " + endDate);
					}
					authResult = FAILURE;
				}
			} else {
				authResult = DNE;
			}
		} catch (Exception e) {
		}
		return authResult;
	}

	public int authenticateByUserId(long companyId, long userId, String password, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		// TODO Auto-generated method stub
		return 0;
	}

}
