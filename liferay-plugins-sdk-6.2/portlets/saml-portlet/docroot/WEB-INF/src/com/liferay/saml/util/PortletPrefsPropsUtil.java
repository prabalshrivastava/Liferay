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

import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Mika Koivisto
 */
public class PortletPrefsPropsUtil {

	public static boolean getBoolean(long companyId, String key) {
		return GetterUtil.getBoolean(getString(companyId,key));
	}

	public static boolean getBoolean(long companyId, String key, boolean defaultValue) {
		return GetterUtil.getBoolean(getString(companyId,key), defaultValue);
	}

	public static int getInteger(long companyId, String key) {
		return GetterUtil.getInteger(getString(companyId,key));
	}

	public static int getInteger(long companyId, String key, int defaultValue) {
		return GetterUtil.getInteger(getString(companyId,key), defaultValue);
	}

	public static long getLong(long companyId, String key) {
		return GetterUtil.getLong(getString(companyId,key));
	}

	public static long getLong(long companyId, String key, long defaultValue) {
		return GetterUtil.getLong(getString(companyId,key), defaultValue);
	}

	public static String getString(long companyId, String key) {
		try {
			return PrefsPropsUtil.getString(companyId, key, PropsUtil.get(key));
		}
		catch (Exception e) {
		}

		return PropsUtil.get(key);
	}

	public static String getString(long companyId, String key, Filter filter) {
		String selector = filter.getSelectors()[0];

		String value = getString(companyId, key.concat("[").concat(selector).concat("]"));

		if (Validator.isNotNull(value)) {
			return value;
		}

		return PropsUtil.get(key, filter);
	}

	public static String getString(long companyId, String key, String defaultValue) {
		String value = getString(companyId, key);

		if (Validator.isNull(value)) {
			return defaultValue;
		}

		return value;
	}

}