package com.liferay.saml.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.wtberks.configuration.service.ConfigurationPropertyLocalServiceUtil;

public class SamlConfigUtil {

	public static boolean getBoolean(long companyId, long groupId, String key) {
		return getBoolean(companyId, groupId, key, false);
	}
	
	public static boolean getBoolean(long companyId, long groupId, String key, Boolean defaultValue) {
		try {
			Boolean value = ConfigurationPropertyLocalServiceUtil.getBoolean(companyId, groupId, key);
			if (value == null) {
				_log.info(String.format("%s is not in the configs for (%s, &s) -- looking in the property file.", key, companyId, groupId));
				return PortletPrefsPropsUtil.getBoolean(companyId, key, defaultValue);
			}
			else
				return value.booleanValue();
		} catch (Exception e) {
			_log.error(String.format("Unable to get '%s' property for (%s, %s)s.  ", key, groupId, companyId) + e);
		}
		return defaultValue;
	}

	public static boolean getBoolean(long userId, long companyId, long groupId, String key, Boolean defaultValue) {
		try {
			Boolean value = ConfigurationPropertyLocalServiceUtil.getBoolean(
					userId, companyId, groupId, key, defaultValue);
			if (value == null) {
				_log.info(String.format("%s is not in the configs for (%s, &s) -- looking in the property file.", key, companyId, groupId));
				return PortletPrefsPropsUtil.getBoolean(
						companyId, key, defaultValue);
			}
			else
				return value.booleanValue();
		} catch (Exception e) {
			_log.error(String.format("Unable to get '%s' property for (%s, %s)s.  ", key, groupId, companyId) + e);
		}
		return defaultValue;
	}

	public static Integer getInteger(long companyId, long groupId, String key) {
		return getInteger(companyId, groupId, key, 0);
	}
	
	public static Integer getInteger(long companyId, long groupId, String key, Integer defaultValue) {
		try {
			Integer value = ConfigurationPropertyLocalServiceUtil.getInteger(companyId, groupId, key);
			if (value == null) {
				_log.info(String.format("%s is not in the configs for (%s, &s) -- looking in the property file.", key, companyId, groupId));
				return PortletPrefsPropsUtil.getInteger(companyId, key, defaultValue);
			}
			else
				return value;
		} catch (Exception e) {
			_log.error(String.format("Unable to get '%s' property for (%s, %s)s.  ", key, groupId, companyId) + e);
		}
		return defaultValue;
	}

	public static Integer getInteger(long userId, long companyId, long groupId, String key, Integer defaultValue) {
		try {
			Integer value = ConfigurationPropertyLocalServiceUtil.getInteger(
					userId, companyId, groupId, key, defaultValue);
			if (value == null) {
				_log.info(String.format("%s is not in the configs for (%s, &s) -- looking in the property file.", key, companyId, groupId));
				return PortletPrefsPropsUtil.getInteger(
						companyId, key, defaultValue);
			}
			else
				return value;
		} catch (Exception e) {
			_log.error(String.format("Unable to get '%s' property for (%s, %s)s.  ", key, groupId, companyId) + e);
		}
		return defaultValue;
	}

	public static String getString(long companyId, long groupId, String key) {
		return getString(companyId, groupId, key, StringPool.BLANK);
	}
	
	public static String getString(long companyId, long groupId, String key, String defaultvValue) {
		try {
			String value = ConfigurationPropertyLocalServiceUtil.getString(companyId, groupId, key);
			if (value == null) {
				_log.info(String.format("%s is not in the configs for (%s, &s) -- looking in the property file.", key, companyId, groupId));
				return PortletPrefsPropsUtil.getString(companyId, key, defaultvValue);
			}
			else
				return value;
		} catch (Exception e) {
			_log.error(String.format("Unable to get '%s' property for (%s, %s)s.  ", key, groupId, companyId) + e);
		}
		return defaultvValue;
	}

	public static String getString(long userId, long companyId, long groupId, String key, String defaultValue) {
		try {
			String value = ConfigurationPropertyLocalServiceUtil.getString(
					userId, companyId, groupId, key, defaultValue);
			if (value == null) {
				_log.info(String.format("%s is not in the configs for (%s, &s) -- looking in the property file.", key, companyId, groupId));
				return PortletPrefsPropsUtil.getString(
						companyId, key, defaultValue);
			}
			else
				return value;
		} catch (Exception e) {
			_log.error(String.format("Unable to get '%s' property for (%s, %s)s.  ", key, groupId, companyId) + e);
		}
		return defaultValue;
	}
	
	public static void setBoolean(long userId, long companyId, long groupId, String key, Boolean value) {
		try {
			ConfigurationPropertyLocalServiceUtil.setBoolean(userId, companyId, groupId, key, value);
		} catch (Exception e) {
			_log.error(String.format("Unable to set property '%s' for (%s, %s).  ", key, companyId, groupId) + e);
		}
	}
	
	public static void setInteger(long userId, long companyId, long groupId, String key, Integer value) {
		try {
			ConfigurationPropertyLocalServiceUtil.setInteger(userId, companyId, groupId, key, value);
		} catch (Exception e) {
			_log.error(String.format("Unable to set property '%s' for (%s, %s).  ", key, companyId, groupId) + e);
		}
	}
	
	public static void setString(long userId, long companyId, long groupId, String key, String value) {
		try {
			ConfigurationPropertyLocalServiceUtil.setString(userId, companyId, groupId, key, value);
		} catch (Exception e) {
			_log.error(String.format("Unable to set property '%s' for (%s, %s).  ", key, companyId, groupId) + e);
		}
	}
	
	private final static Log _log = LogFactoryUtil.getLog(SamlConfigUtil.class);


}
