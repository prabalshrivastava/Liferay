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
public class NameIdResolverFactory {

	public static NameIdResolver getNameIdResolver(String entityId) {
		long companyId = CompanyThreadLocal.getCompanyId();

		NameIdResolver nameIdResolver = _nameIdResolvers.get(
			companyId + "," + entityId);

		if (nameIdResolver != null) {
			return nameIdResolver;
		}

		Thread currentThread = Thread.currentThread();

		ClassLoader classLoader = currentThread.getContextClassLoader();

		try {
			String samlIdpMetadataNameIdResolver = PropsUtil.get(
				PortletPropsKeys.SAML_IDP_METADATA_NAME_ID_RESOLVER,
				new Filter(entityId));

			if (Validator.isNull(samlIdpMetadataNameIdResolver)) {
				samlIdpMetadataNameIdResolver = PropsUtil.get(
					PortletPropsKeys.SAML_IDP_METADATA_NAME_ID_RESOLVER);
			}

			try {
				if (Validator.isNotNull(samlIdpMetadataNameIdResolver)) {
					nameIdResolver =
						(NameIdResolver)InstanceFactory.newInstance(
							classLoader, samlIdpMetadataNameIdResolver);
				}
			}
			catch (ClassNotFoundException cnfe) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to load name ID resolver class " +
										samlIdpMetadataNameIdResolver);
				}
			}

			if (nameIdResolver == null) {
				nameIdResolver = _nameIdResolver;
			}

			_nameIdResolvers.put(companyId + "," + entityId, nameIdResolver);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return nameIdResolver;
	}

	private static Log _log = LogFactoryUtil.getLog(
		NameIdResolverFactory.class);

	private static NameIdResolver _nameIdResolver = new DefaultNameIdResolver();
	private static Map<String, NameIdResolver> _nameIdResolvers =
		new ConcurrentHashMap<String, NameIdResolver>();

}