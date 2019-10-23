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
import com.liferay.portal.kernel.util.StringBundler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.security.KeyStore;
import java.security.KeyStoreException;

/**
 * @author Mika Koivisto
 */
public class FileSystemKeyStoreManagerImpl extends BaseKeyStoreManagerImpl {

	public FileSystemKeyStoreManagerImpl() {
		init();
	}


	public KeyStore getKeyStore() {
		if (_keyStore == null) {
			init();
		}

		return _keyStore;
	}


	public void saveKeyStore(KeyStore keyStore) throws Exception {
		String samlKeyStorePath = getSamlKeyStorePath();
		String samlKeyStorePassword = getSamlKeyStorePassword();

		keyStore.store(
			new FileOutputStream(samlKeyStorePath),
			samlKeyStorePassword.toCharArray());
	}

	protected void init() {
		InputStream inputStream = null;

		String samlKeyStoreType = getSamlKeyStoreType();

		try {
			_keyStore = KeyStore.getInstance(samlKeyStoreType);
		}
		catch (KeyStoreException kse) {
			_log.error(
				"Unable instantiate keystore with type " + samlKeyStoreType,
				kse);

			return;
		}

		String samlKeyStorePath = getSamlKeyStorePath();

		if (samlKeyStorePath.startsWith("classpath:")) {
			Class<?> clazz = getClass();

			inputStream = clazz.getResourceAsStream(
				samlKeyStorePath.substring(10));
		}
		else {
			try {
				inputStream = new FileInputStream(samlKeyStorePath);
			}
			catch (FileNotFoundException fnfe) {
				try {
					String samlKeyStorePassword = getSamlKeyStorePassword();

					if (_log.isWarnEnabled()) {
						StringBundler sb = new StringBundler(5);

						sb.append("Keystore ");
						sb.append(samlKeyStorePath);
						sb.append(" not found. Creating a new default ");
						sb.append("keystore with password ");
						sb.append(samlKeyStorePassword);

						_log.warn(sb.toString());
					}

					_keyStore.load(null, null);

					_keyStore.store(
						new FileOutputStream(samlKeyStorePath),
						samlKeyStorePassword.toCharArray());

					inputStream = new FileInputStream(samlKeyStorePath);
				}
				catch (Exception e) {
					_log.error(
						"Unable to create keystore " + samlKeyStorePath, e);

					return;
				}
			}
		}

		try {
			String samlKeyStorePassword = getSamlKeyStorePassword();

			_keyStore.load(inputStream, samlKeyStorePassword.toCharArray());
		}
		catch (Exception e) {
			_log.error("Unable to load keystore", e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		FileSystemKeyStoreManagerImpl.class);

	private KeyStore _keyStore;

}