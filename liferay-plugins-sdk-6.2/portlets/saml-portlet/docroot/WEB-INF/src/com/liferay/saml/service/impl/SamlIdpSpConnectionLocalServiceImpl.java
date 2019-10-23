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

package com.liferay.saml.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.saml.DuplicateSamlIdpSpConnectionSamlSpEntityIdException;
import com.liferay.saml.SamlIdpSpConnectionMetadataUrlException;
import com.liferay.saml.SamlIdpSpConnectionMetadataXmlException;
import com.liferay.saml.SamlIdpSpConnectionNameException;
import com.liferay.saml.SamlIdpSpConnectionSamlSpEntityIdException;
import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.service.base.SamlIdpSpConnectionLocalServiceBaseImpl;
import com.liferay.saml.util.MetadataUtil;

import java.io.InputStream;

import java.util.Date;
import java.util.List;

/**
 * @author Mika Koivisto
 */
public class SamlIdpSpConnectionLocalServiceImpl
	extends SamlIdpSpConnectionLocalServiceBaseImpl {


	public SamlIdpSpConnection addSamlIdpSpConnection(
			String samlSpEntityId, int assertionLifetime, String attributeNames,
			boolean attributesEnabled, boolean attributesNamespaceEnabled,
			boolean enabled, String metadataUrl,
			InputStream metadataXmlInputStream, String name,
			String nameIdAttribute, String nameIdFormat,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		if (Validator.isNull(samlSpEntityId)) {
			throw new SamlIdpSpConnectionSamlSpEntityIdException();
		}

		if (Validator.isNull(name)) {
			throw new SamlIdpSpConnectionNameException();
		}

		if (samlIdpSpConnectionPersistence.fetchByC_SSEI(
				serviceContext.getCompanyId(), samlSpEntityId) != null) {

			throw new DuplicateSamlIdpSpConnectionSamlSpEntityIdException();
		}

		long samlIdpSpConnectionId = counterLocalService.increment(
			SamlIdpSpConnection.class.getName());

		SamlIdpSpConnection samlIdpSpConnection =
			samlIdpSpConnectionPersistence.create(samlIdpSpConnectionId);

		samlIdpSpConnection.setCompanyId(serviceContext.getCompanyId());
		samlIdpSpConnection.setCreateDate(now);
		samlIdpSpConnection.setModifiedDate(now);
		samlIdpSpConnection.setSamlSpEntityId(samlSpEntityId);
		samlIdpSpConnection.setAssertionLifetime(assertionLifetime);
		samlIdpSpConnection.setAttributeNames(attributeNames);
		samlIdpSpConnection.setAttributesEnabled(attributesEnabled);
		samlIdpSpConnection.setAttributesNamespaceEnabled(
			attributesNamespaceEnabled);
		samlIdpSpConnection.setEnabled(enabled);
		samlIdpSpConnection.setMetadataUpdatedDate(now);

		if ((metadataXmlInputStream == null) &&
			Validator.isNotNull(metadataUrl)) {

			samlIdpSpConnection.setMetadataUrl(metadataUrl);

			metadataXmlInputStream = MetadataUtil.getMetadata(metadataUrl);
		}

		if (metadataXmlInputStream == null) {
			throw new SamlIdpSpConnectionMetadataUrlException();
		}

		samlIdpSpConnection.setMetadataXml(
			getMetadataXml(metadataXmlInputStream, samlSpEntityId));
		samlIdpSpConnection.setName(name);
		samlIdpSpConnection.setNameIdAttribute(nameIdAttribute);
		samlIdpSpConnection.setNameIdFormat(nameIdFormat);

		samlIdpSpConnectionPersistence.update(samlIdpSpConnection);

		return samlIdpSpConnection;
	}


	public SamlIdpSpConnection getSamlIdpSpConnection(
			long companyId, String samlSpEntityId)
		throws PortalException, SystemException {

		return samlIdpSpConnectionPersistence.findByC_SSEI(
			companyId, samlSpEntityId);
	}


	public List<SamlIdpSpConnection> getSamlIdpSpConnections(long companyId)
		throws SystemException {

		return samlIdpSpConnectionPersistence.findByCompanyId(companyId);
	}


	public List<SamlIdpSpConnection> getSamlIdpSpConnections(
			long companyId, int start, int end)
		throws SystemException {

		return samlIdpSpConnectionPersistence.findByCompanyId(
			companyId, start, end);
	}


	public List<SamlIdpSpConnection> getSamlIdpSpConnections(
			long companyId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return samlIdpSpConnectionPersistence.findByCompanyId(
			companyId, start, end, orderByComparator);
	}


	public int getSamlIdpSpConnectionsCount(long companyId)
		throws SystemException {

		return samlIdpSpConnectionPersistence.countByCompanyId(companyId);
	}


	public void updateMetadata(long samlIdpSpConnectionId)
		throws PortalException, SystemException {

		SamlIdpSpConnection samlIdpSpConnection =
			samlIdpSpConnectionPersistence.findByPrimaryKey(
				samlIdpSpConnectionId);

		String metadataUrl = samlIdpSpConnection.getMetadataUrl();

		if (Validator.isNull(metadataUrl)) {
			return;
		}

		InputStream metadataXmlInputStream = MetadataUtil.getMetadata(
			metadataUrl);

		if (metadataXmlInputStream == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to get metadata from " + metadataUrl);
			}

			return;
		}

		String metadataXml = StringPool.BLANK;

		try {
			metadataXml = MetadataUtil.parseMetadataXml(
				metadataXmlInputStream,
				samlIdpSpConnection.getSamlSpEntityId());
		}
		catch (Exception e) {
			_log.warn("Unable to parse metadata", e);
		}

		if (Validator.isNotNull(metadataXml)) {
			samlIdpSpConnection.setMetadataUpdatedDate(new Date());
			samlIdpSpConnection.setMetadataXml(metadataXml);

			samlIdpSpConnectionPersistence.update(samlIdpSpConnection);
		}
	}


	public SamlIdpSpConnection updateSamlIdpSpConnection(
			long samlIdpSpConnectionId, String samlSpEntityId,
			int assertionLifetime, String attributeNames,
			boolean attributesEnabled, boolean attributesNamespaceEnabled,
			boolean enabled, String metadataUrl,
			InputStream metadataXmlInputStream, String name,
			String nameIdAttribute, String nameIdFormat,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		if (Validator.isNull(samlSpEntityId)) {
			throw new SamlIdpSpConnectionSamlSpEntityIdException();
		}

		SamlIdpSpConnection samlIdpSpConnection =
			samlIdpSpConnectionPersistence.fetchByPrimaryKey(
				samlIdpSpConnectionId);

		if (!samlSpEntityId.equals(samlIdpSpConnection.getSamlSpEntityId())) {
			if (samlIdpSpConnectionPersistence.fetchByC_SSEI(
					serviceContext.getCompanyId(),samlSpEntityId) != null) {

				throw new DuplicateSamlIdpSpConnectionSamlSpEntityIdException();
			}
		}

		samlIdpSpConnection.setModifiedDate(now);
		samlIdpSpConnection.setSamlSpEntityId(samlSpEntityId);
		samlIdpSpConnection.setAssertionLifetime(assertionLifetime);
		samlIdpSpConnection.setAttributeNames(attributeNames);
		samlIdpSpConnection.setAttributesEnabled(attributesEnabled);
		samlIdpSpConnection.setAttributesNamespaceEnabled(
			attributesNamespaceEnabled);
		samlIdpSpConnection.setEnabled(enabled);

		if ((metadataXmlInputStream == null) &&
			Validator.isNotNull(metadataUrl)) {

			samlIdpSpConnection.setMetadataUrl(metadataUrl);

			metadataXmlInputStream = MetadataUtil.getMetadata(metadataUrl);
		}

		String metadataXml = StringPool.BLANK;

		if (metadataXmlInputStream != null) {
			metadataXml = getMetadataXml(
				metadataXmlInputStream, samlSpEntityId);
		}

		if (Validator.isNotNull(metadataXml)) {
			samlIdpSpConnection.setMetadataUpdatedDate(now);
			samlIdpSpConnection.setMetadataXml(metadataXml);
		}

		samlIdpSpConnection.setName(name);
		samlIdpSpConnection.setNameIdAttribute(nameIdAttribute);
		samlIdpSpConnection.setNameIdFormat(nameIdFormat);

		samlIdpSpConnectionPersistence.update(samlIdpSpConnection);

		return samlIdpSpConnection;
	}

	protected String getMetadataXml(
			InputStream metadataXmlInputStream, String samlSpEntityId)
		throws PortalException {

		String metadataXml = StringPool.BLANK;

		try {
			metadataXml = MetadataUtil.parseMetadataXml(
				metadataXmlInputStream, samlSpEntityId);
		}
		catch (Exception e) {
			throw new SamlIdpSpConnectionMetadataXmlException(e);
		}

		if (Validator.isNull(metadataXml)) {
			throw new SamlIdpSpConnectionSamlSpEntityIdException();
		}

		return metadataXml;
	}

	private static Log _log = LogFactoryUtil.getLog(
		SamlIdpSpConnectionLocalServiceImpl.class);

}