/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.wtberks.configuration.service.impl;

import org.apache.commons.lang.StringUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.wtberks.configuration.model.ConfigurationProperty;
import com.wtberks.configuration.service.base.ConfigurationPropertyLocalServiceBaseImpl;

/**
 * The implementation of the configuration property local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.wtberks.configuration.service.ConfigurationPropertyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see com.wtberks.configuration.service.base.ConfigurationPropertyLocalServiceBaseImpl
 * @see com.wtberks.configuration.service.ConfigurationPropertyLocalServiceUtil
 */
public class ConfigurationPropertyLocalServiceImpl
	extends ConfigurationPropertyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.wtberks.configuration.service.ConfigurationPropertyLocalServiceUtil} to access the configuration property local service.
	 */

	private static Log LOG = LogFactoryUtil.getLog(ConfigurationPropertyLocalServiceImpl.class);
	
	public String getString(long companyId, long groupId, String key) {
		return getString(companyId, groupId, key, true);
	}

	public String getString(long companyId, long groupId, String key, boolean localGroupOnly) {
		try {
			return getStringValue(companyId, groupId, key);
		} catch (SystemException e) {
			LOG.error(e);
			return null;
		}
	}
	
	public String getString(long userId, long companyId, long groupId, String key, String defaultValue) {
		return getString(userId, companyId, groupId, key, defaultValue, true);
	}
	
	public String getString(long userId, long companyId, long groupId, String key, String defaultValue, boolean localGroupOnly) {
		String sVal = null;
		try {
			sVal = getUserStringValue(userId, companyId, groupId, key);
		} catch (SystemException e) {
			LOG.error(e);
		}
		return StringUtils.isEmpty(sVal) ? defaultValue : sVal;
	}
	
	public Boolean getBoolean(long companyId, long groupId, String key) {
		return getBoolean(companyId, groupId, key, true);
	}
	
	public Boolean getBoolean(long companyId, long groupId, String key, boolean localGroupOnly) {
		try {
			return getBooleanValue(companyId, groupId, key);
		} catch (SystemException e) {
			LOG.error(e);
			return false;
		}
	}
	
	public Boolean getBoolean(long userId, long companyId, long groupId, String key, Boolean defaultValue) {
		return getBoolean(userId, companyId, groupId, key, defaultValue, true);
	}
	
	public Boolean getBoolean(long userId, long companyId, long groupId, String key, Boolean defaultValue, boolean localGroupOnly) {
		String sVal = null;
		try {
			sVal = getUserStringValue(userId, companyId, groupId, key);
		} catch (SystemException e) {
			LOG.error(e);
		}
		return StringUtils.isEmpty(sVal) ? defaultValue : new Boolean(sVal);
	}
	
	public Integer getInteger(long companyId, long groupId, String key) {
		return getInteger(companyId, groupId, key, true);
	}
	
	public Integer getInteger(long companyId, long groupId, String key, boolean localGroupOnly) {
		return getIntegerValue(companyId, groupId, key);
	}
	
	public Integer getInteger(long userId, long companyId, long groupId, String key, Integer defaultValue) {
		return 0;
	}
	
	public Integer getInteger(long userId, long companyId, long groupId, String key, Integer defaultValue, boolean localGroupOnly) {
		String sVal = null;
		try {
			sVal = getUserStringValue(userId, companyId, groupId, key);
		} catch (SystemException e) {
			LOG.error(e);
		}
		return StringUtils.isEmpty(sVal) ? defaultValue : new Integer(sVal);
	}
	
	public void setString(long userId, long companyId, long groupId, String key, String value) {
		try {
			ConfigurationProperty c = getConfig(userId, companyId, groupId, key);
			c.setValue(value);
			configurationPropertyPersistence.update(c);
		} catch (Exception e) {
			LOG.error(e);
		}
	}

	private ConfigurationProperty getConfig(long userId, long companyId,
			long groupId, String key) throws SystemException {
		ConfigurationProperty c;
		c = configurationPropertyPersistence.fetchByUserIdAndKey(userId, companyId, groupId, key);			
		if (c==null) {
			long configurationPropertyId = CounterLocalServiceUtil.increment("ConfigurationProperty");
			c = configurationPropertyPersistence.create(configurationPropertyId);
		}
		c.setUserId(userId);
		c.setCompanyId(companyId);
		c.setGroupId(groupId);
		c.setKey(key);
		return c;
	}
	
	public void setBoolean(long userId, long companyId, long groupId, String key, Boolean value) {
		try {
			ConfigurationProperty c = getConfig(userId, companyId, groupId, key);
			c.setValue(value.toString());
			configurationPropertyPersistence.update(c);
		} catch (Exception e) {
			LOG.error(e);
		}		
	}
	
	public void setInteger(long userId, long companyId, long groupId, String key, Integer value) {
		try {
			ConfigurationProperty c = getConfig(userId, companyId, groupId, key);
			c.setValue(value.toString());
			configurationPropertyPersistence.update(c);
		} catch (Exception e) {
			LOG.error(e);
		}		
	}
	
	private String getStringValue(long companyId, long groupId,
			String key) throws SystemException {
		ConfigurationProperty c = configurationPropertyPersistence.fetchByKey(companyId, groupId, key);
		return (c == null) ? null : c.getValue();
	}
	
	private Boolean getBooleanValue(long companyId, long groupId,
			String key) throws SystemException {
		return new Boolean(getStringValue(companyId, groupId, key));
	}
	
	private Integer getIntegerValue(long companyId, long groupId,
			String key) {
		try {
			String strVal = getStringValue(companyId, groupId, key);
			return StringUtils.isEmpty(strVal) ? null : new Integer(strVal);		
		} catch (Exception e) {
			LOG.error(e);
			return new Integer("-1");
		}
	}

	private String getUserStringValue(long userId, long companyId, long groupId,
			String key) throws SystemException {
		ConfigurationProperty c = configurationPropertyPersistence.fetchByUserIdAndKey(userId, companyId, groupId, key);
		return (c == null) ? null : c.getValue();
	}

}