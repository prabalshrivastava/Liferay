/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.model.impl;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.saml.util.PortletPropsKeys;

import java.util.Date;

/**
 * @author Mika Koivisto
 */
public class SamlIdpSsoSessionImpl extends SamlIdpSsoSessionBaseImpl {

	public SamlIdpSsoSessionImpl() {
	}


	public boolean isExpired() {
		long samlIdpSessionMaximumAge = GetterUtil.getLong(
			PropsUtil.get(PortletPropsKeys.SAML_IDP_SESSION_MAXIMUM_AGE));
		long samlIdpSessionTimeout = GetterUtil.getLong(
			PropsUtil.get(PortletPropsKeys.SAML_IDP_SESSION_TIMEOUT));

		if (samlIdpSessionMaximumAge > 0) {
			Date createDate = getCreateDate();

			long expirationTime =
				createDate.getTime() + samlIdpSessionMaximumAge * Time.SECOND;

			if (System.currentTimeMillis() > expirationTime) {
				return true;
			}
		}

		if (samlIdpSessionTimeout <= 0) {
			return false;
		}

		Date modifiedDate = getModifiedDate();

		long expirationTime =
			modifiedDate.getTime() + samlIdpSessionTimeout * Time.SECOND;

		if (System.currentTimeMillis() > expirationTime) {
			return true;
		}
		else {
			return false;
		}
	}

}