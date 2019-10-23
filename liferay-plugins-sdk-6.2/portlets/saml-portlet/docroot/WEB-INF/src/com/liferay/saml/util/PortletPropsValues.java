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

package com.liferay.saml.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Mika Koivisto
 */
public class PortletPropsValues {

	public static final String SAML_KEYSTORE_MANAGER_IMPL = PortletProps.get(
		PortletPropsKeys.SAML_KEYSTORE_MANAGER_IMPL);

	public static final long SAML_METADATA_MAX_REFRESH_DELAY =
		GetterUtil.getLong(
			PortletProps.get(
				PortletPropsKeys.SAML_METADATA_MAX_REFRESH_DELAY), 14400000);

	public static final int SAML_METADATA_MIN_REFRESH_DELAY =
		GetterUtil.getInteger(
			PortletProps.get(
				PortletPropsKeys.SAML_METADATA_MIN_REFRESH_DELAY), 300000);

}