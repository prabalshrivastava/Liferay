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

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.util.OpenSamlUtil;

import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDPolicy;

/**
 * @author Mika Koivisto
 */
public class DefaultNameIdResolver implements NameIdResolver {


	public NameID resolve(
		User user, long companyId, long groupId, String entityId, NameIDPolicy nameIdPolicy) {

		String nameIdFormat = getNameIdFormat(companyId, groupId, entityId, nameIdPolicy);
		String nameIdValue = getNameIdValue(user, companyId, entityId);

		String spNameQualifier = null;

		if ((nameIdPolicy != null) &&
			Validator.isNotNull(nameIdPolicy.getSPNameQualifier())) {

			spNameQualifier = nameIdPolicy.getSPNameQualifier();
		}

		return OpenSamlUtil.buildNameId(
			nameIdFormat, nameIdValue, spNameQualifier);
	}

	protected String getNameIdAttributeName(long companyId,String entityId) {
		return MetadataManagerUtil.getNameIdAttribute(companyId, entityId);
	}

	protected String getNameIdFormat(
		long companyId, long groupId,
		String entityId, NameIDPolicy nameIdPolicy) {

		if ((nameIdPolicy != null) &&
			Validator.isNotNull(nameIdPolicy.getFormat())) {

			return nameIdPolicy.getFormat();
		}

		return MetadataManagerUtil.getNameIdFormat(companyId, groupId, entityId);
	}

	protected String getNameIdValue(User user, long companyId, String entityId) {
		String nameIdAttributeName = getNameIdAttributeName(companyId, entityId);

		String nameIdValue = user.getEmailAddress();

		if (Validator.isNull(nameIdAttributeName)) {
			return nameIdValue;
		}

		if (nameIdAttributeName.startsWith("expando:")) {
			String attributeName = nameIdAttributeName.substring(8);

			ExpandoBridge expandoBridge = user.getExpandoBridge();

			nameIdValue = String.valueOf(
				expandoBridge.getAttribute(attributeName));
		}
		else if (nameIdAttributeName.startsWith("static:")) {
			nameIdValue = nameIdAttributeName.substring(7);
		}
		else {
			nameIdValue = String.valueOf(
				BeanPropertiesUtil.getObject(user, nameIdAttributeName));
		}

		return nameIdValue;
	}

}