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
import com.liferay.portal.service.ServiceContext;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.Response;

/**
 * @author Mika Koivisto
 */
public class UserResolverUtil {

	public static UserResolver getUserResolver() {
		return _userResolver;
	}

	public static User resolveUser(
			long companyId,
			long groupId,
			Assertion assertion,
			SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext,
			ServiceContext serviceContext)
		throws Exception {

		return getUserResolver().resolveUser(
			companyId, groupId,
			assertion, samlMessageContext, serviceContext);
	}

	public void setUserResolver(UserResolver userResolver) {
		_userResolver = userResolver;
	}

	private static UserResolver _userResolver;

}