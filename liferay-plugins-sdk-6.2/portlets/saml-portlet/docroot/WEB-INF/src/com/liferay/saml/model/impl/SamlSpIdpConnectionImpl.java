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

package com.liferay.saml.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.saml.util.SamlUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Mika Koivisto
 */
public class SamlSpIdpConnectionImpl extends SamlSpIdpConnectionBaseImpl {

	public SamlSpIdpConnectionImpl() {
	}

	public Map<String, String> getUserAttributeMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		String userAttributeMappings = this.getUserAttributeMappings();

		try {
			Properties properties;
			if (Validator.isNotNull(userAttributeMappings)) 
				properties = PropertiesUtil.load(userAttributeMappings);
			else
				properties = new Properties();
				
			// Use the attribut list because we want to ensure tht even unused attributes show up
			for (SamlUtil.UserAttribute attribute : SamlUtil.UserAttribute.values())
				map.put(attribute.getValue(), properties.getProperty(attribute.getValue()));
			
		} catch (IOException e) {
			_log.error("Unable to get userAttributeMappings. " + e);
		}
		
		return map;
	}
	
	public void setUserAttributeMap(Map<String, String> map) {
		Properties props = new Properties();
		props.putAll(map);
		
		StringWriter writer = new StringWriter();
		try {
			props.store(writer, null);
		} catch (IOException e) {
			_log.error("Unable to set userAttributeMappings. " + e);
		}
		this.setUserAttributeMappings(writer.toString());
	}

	private final static Log _log = LogFactoryUtil.getLog(SamlIdpSpConnectionImpl.class);
}