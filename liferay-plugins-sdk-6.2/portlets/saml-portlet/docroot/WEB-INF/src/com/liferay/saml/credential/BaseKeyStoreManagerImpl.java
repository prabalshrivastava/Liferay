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

package com.liferay.saml.credential;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.saml.util.PortletPropsKeys;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseKeyStoreManagerImpl implements KeyStoreManager {

	protected long getCompanyId() {
		return CompanyThreadLocal.getCompanyId();
	}

	protected String getDefaultSamlKeyStorePath() {
		String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);

		return liferayHome.concat("/data/keystore.jks");
	}

	protected String getSamlKeyStorePassword() {
		return GetterUtil.getString(
			PropsUtil.get(PortletPropsKeys.SAML_KEYSTORE_PASSWORD), "liferay");
	}

	protected String getSamlKeyStorePath() {
		return GetterUtil.getString(
			PropsUtil.get(PortletPropsKeys.SAML_KEYSTORE_PATH),
			getDefaultSamlKeyStorePath());
	}

	protected String getSamlKeyStoreType() {
		return GetterUtil.getString(
			PropsUtil.get(PortletPropsKeys.SAML_KEYSTORE_TYPE), "jks");
	}

}