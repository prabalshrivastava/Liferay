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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.saml.util.PortletPropsValues;

/**
 * @author Mika Koivisto
 */
public class KeyStoreManagerFactory {

	public static KeyStoreManager getInstance() {
		if (_keyStoreManager != null) {
			return _keyStoreManager;
		}

		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		try {
			_keyStoreManager = (KeyStoreManager)InstanceFactory.newInstance(
				classLoader, PortletPropsValues.SAML_KEYSTORE_MANAGER_IMPL);
		}
		catch (Exception e) {
			_log.error(
				"Unable to load keystore manager class " +
					PortletPropsValues.SAML_KEYSTORE_MANAGER_IMPL,
				e);
		}

		return _keyStoreManager;
	}

	private static Log _log = LogFactoryUtil.getLog(
		KeyStoreManagerFactory.class);

	private static KeyStoreManager _keyStoreManager;

}