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

package com.liferay.saml.resolver;

import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.saml.util.PortletPropsKeys;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mika Koivisto
 */
public class AttributeResolverFactory {

	public static AttributeResolver getAttributeResolver(String entityId) {
		long companyId = CompanyThreadLocal.getCompanyId();

		AttributeResolver attributeResolver = _attributeResolvers.get(
			companyId + "," + entityId);

		if (attributeResolver != null) {
			return attributeResolver;
		}

		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		try {
			String samlIdpMetadataAttributeResolver = PropsUtil.get(
				PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTE_RESOLVER,
				new Filter(entityId));

			if (Validator.isNull(samlIdpMetadataAttributeResolver)) {
				samlIdpMetadataAttributeResolver = PropsUtil.get(
					PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTE_RESOLVER);
			}

			try {
				if (Validator.isNotNull(samlIdpMetadataAttributeResolver)) {
					attributeResolver =
						(AttributeResolver)InstanceFactory.newInstance(
							classLoader, samlIdpMetadataAttributeResolver);
				}
			}
			catch (ClassNotFoundException cnfe) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to load attribute resolver class " +
							samlIdpMetadataAttributeResolver);
				}
			}

			if (attributeResolver == null) {
				attributeResolver = _attributeResolver;
			}

			_attributeResolvers.put(
				companyId + "," + entityId, attributeResolver);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return attributeResolver;
	}

	private static Log _log = LogFactoryUtil.getLog(
		AttributeResolverFactory.class);

	private static AttributeResolver _attributeResolver =
		new DefaultAttributeResolver();
	private static Map<String, AttributeResolver> _attributeResolvers =
		new ConcurrentHashMap<String, AttributeResolver>();

}