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

package com.liferay.saml.provider;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.saml.NoSuchIdpSpConnectionException;
import com.liferay.saml.NoSuchSpIdpConnectionException;
import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.service.SamlIdpSpConnectionLocalServiceUtil;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;
import com.liferay.saml.util.OpenSamlUtil;
import com.liferay.saml.util.SamlUtil;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;

import org.joda.time.DateTime;
import org.opensaml.saml2.common.Extensions;
import org.opensaml.saml2.metadata.EntitiesDescriptor;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.RoleDescriptor;
import org.opensaml.saml2.metadata.provider.BaseMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.xml.Namespace;
import org.opensaml.xml.NamespaceManager;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.parse.ParserPool;
import org.opensaml.xml.schema.XSBooleanValue;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.util.IDIndex;
import org.opensaml.xml.util.LazySet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Mika Koivisto
 */
public class DBMetadataProvider extends BaseMetadataProvider {
	
	public DBMetadataProvider(long companyId, long groupId) {
		this.companyId = companyId;
		this.groupId = groupId;
	}


	public EntitiesDescriptor getEntitiesDescriptor(String name) {
		return null;
	}


	public EntityDescriptor getEntityDescriptor(String entityId)
		throws MetadataProviderException {

		_log.debug("Get the entity descriptor for " + entityId);
		try {
			String metadataXml = getMetadataXml(entityId);

			if (Validator.isNull(metadataXml)) {
				return null;
			}

			Document document = _parserPool.parse(
				new StringReader(metadataXml));

			XMLObject metadataXmlObject = OpenSamlUtil.unmarshallXMLObject(
				document.getDocumentElement());

			EntityDescriptor entityDescriptor =
				SamlUtil.getEntityDescriptorById(entityId, metadataXmlObject);

			return entityDescriptor;
		}
		catch (Exception e) {
			throw new MetadataProviderException(e);
		}
	}


	public XMLObject getMetadata() {
		return new DBEntitiesDescriptor();
	}


	public List<RoleDescriptor> getRole(String entityId, QName qName)
		throws MetadataProviderException {

		EntityDescriptor entityDescriptor = getEntityDescriptor(entityId);

		if (entityDescriptor != null) {
			return entityDescriptor.getRoleDescriptors(qName);
		}

		return null;
	}


	public RoleDescriptor getRole(
			String entityId, QName qName, String supportedProtocol)
		throws MetadataProviderException {

		List<RoleDescriptor> roleDescriptors = getRole(entityId, qName);

		if ((roleDescriptors == null) || roleDescriptors.isEmpty()) {
			return null;
		}

		for (RoleDescriptor roleDescriptor : roleDescriptors) {
			if (roleDescriptor.isSupportedProtocol(supportedProtocol)) {
				return roleDescriptor;
			}
		}

		return null;
	}

	public void setParserPool(ParserPool parserPool) {
		_parserPool = parserPool;
	}

	protected String getMetadataXml(
			String entityId) throws Exception {

		if (SamlUtil.isRoleIdp(companyId)) {
			try {
				SamlIdpSpConnection samlIdpSpConnection =
					SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
						this.companyId, entityId);

				if (!samlIdpSpConnection.isEnabled()) {
					return null;
				}

				return samlIdpSpConnection.getMetadataXml();
			}
			catch (NoSuchIdpSpConnectionException nsisce) {
				return null;
			}
		}
		else if (SamlUtil.isRoleSp(this.companyId)) {
			try {
				SamlSpIdpConnection samlSpIdpConnection =
					SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(
						this.companyId, this.groupId);

				if (!samlSpIdpConnection.isEnabled()) {
					return null;
				}

				return samlSpIdpConnection.getMetadataXml();
			}
			catch (NoSuchSpIdpConnectionException nssice) {
				return null;
			}
		}

		return null;
	}

	private ParserPool _parserPool;
	private long companyId;
	private long groupId;

	private class DBEntitiesDescriptor implements EntitiesDescriptor {

		public DBEntitiesDescriptor() {
		}


		public void addNamespace(Namespace namespace) {
		}


		@SuppressWarnings("rawtypes")
		public void deregisterValidator(
			org.opensaml.xml.validation.Validator validator) {
		}


		public void detach() {
		}


		public Long getCacheDuration() {
			return null;
		}


		public Element getDOM() {
			return null;
		}


		public QName getElementQName() {
			return EntitiesDescriptor.DEFAULT_ELEMENT_NAME;
		}


		public List<EntitiesDescriptor> getEntitiesDescriptors() {
			List<EntitiesDescriptor> entitiesDescriptors =
				new ArrayList<EntitiesDescriptor>();

			for (XMLObject xmlObject : _xmlObjects) {
				if (xmlObject instanceof EntitiesDescriptor) {
					EntitiesDescriptor entitiesDescriptor =
						(EntitiesDescriptor)xmlObject;

					entitiesDescriptors.add(entitiesDescriptor);
				}
			}

			return entitiesDescriptors;
		}


		public List<EntityDescriptor> getEntityDescriptors() {
			List<EntityDescriptor> entityDescriptors =
				new ArrayList<EntityDescriptor>();

			for (XMLObject xmlObject : _xmlObjects) {
				if (xmlObject instanceof EntityDescriptor) {
					EntityDescriptor entityDescriptor =
						(EntityDescriptor)xmlObject;

					entityDescriptors.add(entityDescriptor);
				}
			}

			return entityDescriptors;
		}


		public Extensions getExtensions() {
			return null;
		}


		public String getID() {
			return null;
		}


		public IDIndex getIDIndex() {
			return null;
		}


		public String getName() {
			return null;
		}


		public NamespaceManager getNamespaceManager() {
			return null;
		}


		public Set<Namespace> getNamespaces() {
			return new LazySet<Namespace>();
		}


		public String getNoNamespaceSchemaLocation() {
			return null;
		}


		public List<XMLObject> getOrderedChildren() {
			return new ArrayList<XMLObject>();
		}


		public XMLObject getParent() {
			return null;
		}


		public String getSchemaLocation() {
			return null;
		}


		public QName getSchemaType() {
			return EntitiesDescriptor.TYPE_NAME;
		}


		public Signature getSignature() {
			return null;
		}


		public String getSignatureReferenceID() {
			return null;
		}


		@SuppressWarnings("rawtypes")
		public List<org.opensaml.xml.validation.Validator> getValidators() {
			return new ArrayList<org.opensaml.xml.validation.Validator>();
		}


		public DateTime getValidUntil() {
			return null;
		}


		public boolean hasChildren() {
			List<XMLObject> xmlObjects = getOrderedChildren();

			return !xmlObjects.isEmpty();
		}


		public boolean hasParent() {
			return false;
		}


		public Boolean isNil() {
			return Boolean.FALSE;
		}


		public XSBooleanValue isNilXSBoolean() {
			return new XSBooleanValue(Boolean.FALSE, false);
		}


		public boolean isSigned() {
			return false;
		}


		public boolean isValid() {
			return true;
		}


		@SuppressWarnings("rawtypes")
		public void registerValidator(
			org.opensaml.xml.validation.Validator validator) {
		}


		public void releaseChildrenDOM(boolean propagateRelease) {
		}


		public void releaseDOM() {
		}


		public void releaseParentDOM(boolean propagateRelease) {
		}


		public void removeNamespace(Namespace namespace) {
		}


		public XMLObject resolveID(String id) {
			return null;
		}


		public XMLObject resolveIDFromRoot(String id) {
			return null;
		}


		public void setCacheDuration(Long duration) {
		}


		public void setDOM(Element element) {
		}


		public void setExtensions(Extensions extensions) {
		}


		public void setID(String id) {
		}


		public void setName(String name) {
		}


		public void setNil(Boolean value) {
		}


		public void setNil(XSBooleanValue value) {
		}


		public void setNoNamespaceSchemaLocation(String location) {
		}


		public void setParent(XMLObject xmlObject) {
		}


		public void setSchemaLocation(String location) {
		}


		public void setSignature(Signature signature) {
		}


		public void setValidUntil(DateTime validUntil) {
		}


		public void validate(boolean validateDescendants) {
		}

		private List<XMLObject> _xmlObjects;
	}

	private final static Log _log = LogFactoryUtil.getLog(DBMetadataProvider.class);
}