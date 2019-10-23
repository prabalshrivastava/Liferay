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

import com.liferay.portal.model.User;

import java.util.List;

import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.saml2.core.Attribute;

/**
 * @author Mika Koivisto
 */
public interface AttributeResolver {

	public List<Attribute> resolve(
		long companyId, User user, SAMLMessageContext<?, ?, ?> samlMessageContext);

}