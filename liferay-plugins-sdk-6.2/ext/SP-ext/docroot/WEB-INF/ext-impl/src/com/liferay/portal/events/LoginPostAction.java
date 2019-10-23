/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.events;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;

import com.liferay.portal.kernel.cluster.ClusterExecutorUtil;
import com.liferay.portal.kernel.cluster.ClusterNode;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class LoginPostAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Running " + request.getRemoteUser());
			}

			HttpSession session = request.getSession();

			long companyId = PortalUtil.getCompanyId(request);
			long userId = 0;

			// Language

			session.removeAttribute(Globals.LOCALE_KEY);

			// Live users

			if (PropsValues.LIVE_USERS_ENABLED) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				ClusterNode clusterNode = ClusterExecutorUtil.getLocalClusterNode();

				if (clusterNode != null) {
					jsonObject.put("clusterNodeId", clusterNode.getClusterNodeId());
				}

				jsonObject.put("command", "signIn");
				jsonObject.put("companyId", companyId);
				jsonObject.put("remoteAddr", request.getRemoteAddr());
				jsonObject.put("remoteHost", request.getRemoteHost());
				jsonObject.put("sessionId", session.getId());

				String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

				jsonObject.put("userAgent", userAgent);

				userId = PortalUtil.getUserId(request);

				jsonObject.put("userId", userId);

				MessageBusUtil.sendMessage(DestinationNames.LIVE_USERS, jsonObject.toString());
			}

			if (PrefsPropsUtil.getBoolean(companyId, PropsKeys.ADMIN_SYNC_DEFAULT_ASSOCIATIONS)) {

				if (userId == 0) {
					userId = PortalUtil.getUserId(request);
				}

				UserLocalServiceUtil.addDefaultGroups(userId);

				try {
					User user = UserLocalServiceUtil.getUser(userId);
					SPParameter spParam = SPParameterLocalServiceUtil.findSPParameterOrAdd("customised.role",
							StringPool.BLANK, StringPool.BLANK, "System", SambaashConstants.DEFAULT_GROUP_ID_LONG);

					SPParameter spParamRemoveRoles = SPParameterLocalServiceUtil.findSPParameterOrAdd("remove.role",
							StringPool.BLANK,
							"This parameter is used to remove if the user has any role defined in customised.role parameter. Refer LoginPostAction.",
							"System", SambaashConstants.DEFAULT_GROUP_ID_LONG);

					String customRoles[] = spParam.getValue().split(StringPool.COMMA);
					String removeRoles[] = spParamRemoveRoles.getValue().split(StringPool.COMMA);

					List<Role> userRoles = user.getRoles();
					boolean isCustomisedRole = false;

					_log.info("userRoles size " + userRoles.size());

					label: for (Role role : SambaashUtil.emptyIfNull(userRoles)) {
						if (ArrayUtil.isNotEmpty(customRoles)) {
							for (String roleName : customRoles) {
								if (roleName.equalsIgnoreCase(role.getName())) {
									isCustomisedRole = true;
									break label;
								}
							}
						}
					}

					if (isCustomisedRole) {
						if (ArrayUtil.isNotEmpty(removeRoles)) {
							for (String roleName : removeRoles) {
								Role roleToRemove = RoleLocalServiceUtil.getRole(companyId, roleName);
								UserLocalServiceUtil.deleteRoleUser(roleToRemove.getRoleId(), user);
								_log.error(String.format("Deleted %s role from user %s ", roleToRemove.getName(),
										user.getUserId()));
							}
						}
					} else {
						UserLocalServiceUtil.addDefaultRoles(userId);
					}

				} catch (Exception e) {
					_log.error(e.getMessage());
				}

				UserLocalServiceUtil.addDefaultUserGroups(userId);
			}
		} catch (Exception e) {
			throw new ActionException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LoginPostAction.class);

}