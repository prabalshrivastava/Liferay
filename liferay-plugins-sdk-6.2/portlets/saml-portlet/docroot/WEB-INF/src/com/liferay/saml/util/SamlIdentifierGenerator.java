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

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeFormatter;

import java.security.SecureRandom;

import org.opensaml.common.IdentifierGenerator;

/**
 * @author Mika Koivisto
 */
public class SamlIdentifierGenerator implements IdentifierGenerator {


	public String generateIdentifier() {
		return generateIdentifier(16);
	}


	public String generateIdentifier(int size) {
		byte[] bytes = new byte[size];

		_secureRandom.nextBytes(bytes);

		return StringPool.UNDERLINE.concat(UnicodeFormatter.bytesToHex(bytes));
	}

	private SecureRandom _secureRandom = new SecureRandom();

}