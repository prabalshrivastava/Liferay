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

/**
 * @author Mika Koivisto
 */
public interface PortletWebKeys {

	public static final String FORCE_REAUHENTICATION = "FORCE_REAUTHENTICATION";

	public static final String SAML_SESSION_KEEP_ALIVE_URLS =
		"SAML_SESSION_KEEP_ALIVE_URLS";

	public static final String SAML_SLO_CONTEXT = "SAML_SLO_CONTEXT";

	public static final String SAML_SLO_REQUEST_INFO = "SAML_SLO_REQUEST_INFO";

	public static final String SAML_SP_ATTRIBUTES = "SAML_SP_ATTRIBUTES";

	public static final String SAML_SP_NAME_ID_FORMAT =
		"SAML_SP_NAME_ID_FORMAT";

	public static final String SAML_SP_NAME_ID_VALUE = "SAML_SP_NAME_ID_VALUE";

	public static final String SAML_SP_SESSION_KEY = "SAML_SP_SESSION_KEY";

	public static final String SAML_SSO_REQUEST_CONTEXT =
		"SAML_SSO_REQUEST_CONTEXT";

	public static final String SAML_SSO_SESSION_ID = "SAML_SSO_SESSION_ID";

}