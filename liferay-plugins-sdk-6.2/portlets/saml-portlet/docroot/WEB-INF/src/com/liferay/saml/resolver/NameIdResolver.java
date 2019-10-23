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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDPolicy;

/**
 * @author Mika Koivisto
 */
public interface NameIdResolver {

	public NameID resolve(User user, long companyId, long groupId, String entityId, NameIDPolicy nameIdPolicy)
		throws PortalException, SystemException;

}