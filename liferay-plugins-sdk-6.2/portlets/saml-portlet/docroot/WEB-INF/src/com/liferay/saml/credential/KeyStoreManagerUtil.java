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

import java.security.KeyStore;

/**
 * @author Mika Koivisto
 */
public class KeyStoreManagerUtil {

	public static KeyStore getKeyStore() {
		KeyStoreManager keyStoreManager = KeyStoreManagerFactory.getInstance();

		return keyStoreManager.getKeyStore();
	}

	public static void saveKeyStore(KeyStore keyStore) throws Exception {
		KeyStoreManager keyStoreManager = KeyStoreManagerFactory.getInstance();

		keyStoreManager.saveKeyStore(keyStore);
	}

}