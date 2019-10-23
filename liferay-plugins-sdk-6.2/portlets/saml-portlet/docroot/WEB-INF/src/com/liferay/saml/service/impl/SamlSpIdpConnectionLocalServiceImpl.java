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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.saml.DuplicateSamlSpIdpConnectionSamlIdpEntityIdException;
import com.liferay.saml.SamlSpIdpConnectionMetadataUrlException;
import com.liferay.saml.SamlSpIdpConnectionMetadataXmlException;
import com.liferay.saml.SamlSpIdpConnectionSamlIdpEntityIdException;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.service.base.SamlSpIdpConnectionLocalServiceBaseImpl;
import com.liferay.saml.util.MetadataUtil;


import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
 * @author Mika Koivisto
 */
public class SamlSpIdpConnectionLocalServiceImpl
	extends SamlSpIdpConnectionLocalServiceBaseImpl {


	public SamlSpIdpConnection addSamlSpIdpConnection(
			String samlIdpEntityId, boolean assertionSignatureRequired,
			long clockSkew, boolean enabled, boolean ldapImportEnabled,
			String metadataUrl, InputStream metadataXmlInputStream, String name,
			String nameIdFormat, boolean signAuthnRequest,
			String primaryKeyType, String primaryKeyAttribute,
			Map<String, String> userAttributeMap, String keepAliveUrl,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		if (Validator.isNull(samlIdpEntityId)) {
			throw new SamlSpIdpConnectionSamlIdpEntityIdException();
		}

		if (samlSpIdpConnectionPersistence.fetchByCompanyIdGroupId(
				serviceContext.getCompanyId(), serviceContext.getScopeGroupId()) != null) {

			throw new DuplicateSamlSpIdpConnectionSamlIdpEntityIdException();
		}

		long samlSpIdpConnectionId = counterLocalService.increment(
			SamlSpIdpConnection.class.getName());

		SamlSpIdpConnection samlSpIdpConnection =
			samlSpIdpConnectionPersistence.create(samlSpIdpConnectionId);

		samlSpIdpConnection.setCompanyId(serviceContext.getCompanyId());
		samlSpIdpConnection.setGroupId(serviceContext.getScopeGroupId());
		samlSpIdpConnection.setUserId(serviceContext.getUserId());
		samlSpIdpConnection.setCreateDate(now);
		samlSpIdpConnection.setModifiedDate(now);
		samlSpIdpConnection.setSamlIdpEntityId(samlIdpEntityId);
		samlSpIdpConnection.setAssertionSignatureRequired(
			assertionSignatureRequired);
		samlSpIdpConnection.setClockSkew(clockSkew);
		samlSpIdpConnection.setEnabled(enabled);
		samlSpIdpConnection.setLdapImportEnabled(ldapImportEnabled);
		samlSpIdpConnection.setMetadataUpdatedDate(now);
		samlSpIdpConnection.setKeepAliveUrl(keepAliveUrl);

		if ((metadataXmlInputStream == null) &&
			Validator.isNotNull(metadataUrl)) {

			samlSpIdpConnection.setMetadataUrl(metadataUrl);

			metadataXmlInputStream = MetadataUtil.getMetadata(metadataUrl);
		}

		if (metadataXmlInputStream == null) {
			throw new SamlSpIdpConnectionMetadataUrlException();
		}

		samlSpIdpConnection.setMetadataXml(
			getMetadataXml(metadataXmlInputStream, samlIdpEntityId));
		samlSpIdpConnection.setName(name);
		samlSpIdpConnection.setNameIdFormat(nameIdFormat);
		samlSpIdpConnection.setSamlIdpEntityId(samlIdpEntityId);
		samlSpIdpConnection.setSignAuthnRequest(signAuthnRequest);
		samlSpIdpConnection.setPrimaryKeyType(primaryKeyType);
		samlSpIdpConnection.setPrimaryKeyAttribute(primaryKeyAttribute);
		samlSpIdpConnection.setUserAttributeMap(userAttributeMap);

		samlSpIdpConnectionPersistence.update(samlSpIdpConnection);

		return samlSpIdpConnection;
	}


	public SamlSpIdpConnection getSamlSpIdpConnection(
			long companyId, long groupId)
		throws PortalException, SystemException {

		return samlSpIdpConnectionPersistence.findByCompanyIdGroupId(
			companyId, groupId);
	}


	public void updateMetadata(long samlSpIdpConnectionId)
		throws PortalException, SystemException {

		SamlSpIdpConnection samlSpIdpConnection =
			samlSpIdpConnectionPersistence.findByPrimaryKey(
				samlSpIdpConnectionId);

		String metadataUrl = samlSpIdpConnection.getMetadataUrl();

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
				samlSpIdpConnection.getSamlIdpEntityId());
		}
		catch (Exception e) {
			_log.warn("Unable to parse metadata", e);
		}

		if (Validator.isNotNull(metadataXml)) {
			samlSpIdpConnection.setMetadataUpdatedDate(new Date());
			samlSpIdpConnection.setMetadataXml(metadataXml);

			samlSpIdpConnectionPersistence.update(samlSpIdpConnection);
		}
	}


	public SamlSpIdpConnection updateSamlSpIdpConnection(
			long samlSpIdpConnectionId, String samlIdpEntityId,
			boolean assertionSignatureRequired, long clockSkew, boolean enabled,
			boolean ldapImportEnabled, String metadataUrl,
			InputStream metadataXmlInputStream, String name,
			String nameIdFormat, boolean signAuthnRequest,
			String primaryKeyType, String primaryKeyAttribute,
			Map<String, String> userAttributeMap, String keepAliveUrl,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		if (Validator.isNull(samlIdpEntityId)) {
			throw new SamlSpIdpConnectionSamlIdpEntityIdException();
		}

		SamlSpIdpConnection samlSpIdpConnection =
			samlSpIdpConnectionPersistence.findByPrimaryKey(
				samlSpIdpConnectionId);

//		if (!samlIdpEntityId.equals(samlSpIdpConnection.getSamlIdpEntityId())) {
//			if (samlSpIdpConnectionPersistence.fetchByCompanyIdGroupId(
//					serviceContext.getCompanyId(), serviceContext.getScopeGroupId()) != null) {
//
//				throw
//					new DuplicateSamlSpIdpConnectionSamlIdpEntityIdException();
//			}
//		}

		samlSpIdpConnection.setCompanyId(serviceContext.getCompanyId());
		samlSpIdpConnection.setGroupId(serviceContext.getScopeGroupId());
		samlSpIdpConnection.setUserId(serviceContext.getUserId());
		samlSpIdpConnection.setCreateDate(now);
		samlSpIdpConnection.setModifiedDate(now);
		samlSpIdpConnection.setSamlIdpEntityId(samlIdpEntityId);
		samlSpIdpConnection.setAssertionSignatureRequired(
			assertionSignatureRequired);
		samlSpIdpConnection.setClockSkew(clockSkew);
		samlSpIdpConnection.setEnabled(enabled);
		samlSpIdpConnection.setLdapImportEnabled(ldapImportEnabled);
		samlSpIdpConnection.setMetadataUpdatedDate(now);
		samlSpIdpConnection.setKeepAliveUrl(keepAliveUrl);

		if ((metadataXmlInputStream == null) &&
			Validator.isNotNull(metadataUrl)) {

			samlSpIdpConnection.setMetadataUrl(metadataUrl);

			_log.debug("Create an input stream using " + metadataUrl);
			metadataXmlInputStream = MetadataUtil.getMetadata(metadataUrl);
		}

		String metadataXml = StringPool.BLANK;

		if (metadataXmlInputStream != null) {
			metadataXml = getMetadataXml(
				metadataXmlInputStream, samlIdpEntityId);
		}
		else if (_log.isDebugEnabled()) {
			if (Validator.isNotNull(metadataUrl))
				_log.debug("Unable to get input stream from URL");
		}

		if (Validator.isNotNull(metadataXml)) {
			samlSpIdpConnection.setMetadataUpdatedDate(now);
			samlSpIdpConnection.setMetadataXml(metadataXml);
		}

		samlSpIdpConnection.setName(name);
		samlSpIdpConnection.setNameIdFormat(nameIdFormat);
		samlSpIdpConnection.setSamlIdpEntityId(samlIdpEntityId);
		samlSpIdpConnection.setSignAuthnRequest(signAuthnRequest);
		samlSpIdpConnection.setPrimaryKeyAttribute(primaryKeyAttribute);
		samlSpIdpConnection.setPrimaryKeyType(primaryKeyType);
		samlSpIdpConnection.setUserAttributeMap(userAttributeMap);

		samlSpIdpConnectionPersistence.update(samlSpIdpConnection);

		return samlSpIdpConnection;
	}

	protected String getMetadataXml(
			InputStream metadataXmlInputStream, String samlIdpEntityId)
		throws PortalException {

		_log.debug("Get metadata XML from input stream");
		String metadataXml = StringPool.BLANK;

		try {
			metadataXml = MetadataUtil.parseMetadataXml(
				metadataXmlInputStream, samlIdpEntityId);
		}
		catch (Exception e) {
			_log.debug("Unable to get metadata XML.  " + e);
			throw new SamlSpIdpConnectionMetadataXmlException(e);
		}

		if (Validator.isNull(metadataXml)) {
			throw new SamlSpIdpConnectionSamlIdpEntityIdException();
		}

		return metadataXml;
	}

	private static Log _log = LogFactoryUtil.getLog(
		SamlSpIdpConnectionLocalServiceImpl.class);

}