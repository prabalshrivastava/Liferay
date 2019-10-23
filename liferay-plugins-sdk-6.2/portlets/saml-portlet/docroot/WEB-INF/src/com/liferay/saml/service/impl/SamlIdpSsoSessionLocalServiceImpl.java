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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.saml.DuplicateSamlIdpSsoSessionException;
import com.liferay.saml.model.SamlIdpSsoSession;
import com.liferay.saml.service.base.SamlIdpSsoSessionLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Mika Koivisto
 */
public class SamlIdpSsoSessionLocalServiceImpl
	extends SamlIdpSsoSessionLocalServiceBaseImpl {


	public SamlIdpSsoSession addSamlIdpSsoSession(
			String samlIdpSsoSessionKey, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userLocalService.getUserById(serviceContext.getUserId());
		Date now = new Date();

		SamlIdpSsoSession samlIdpSsoSession =
			samlIdpSsoSessionPersistence.fetchBySamlIdpSsoSessionKey(
				samlIdpSsoSessionKey);

		if (samlIdpSsoSession != null) {
			throw new DuplicateSamlIdpSsoSessionException();
		}

		long samlIdpSsoSessionId = counterLocalService.increment(
			SamlIdpSsoSession.class.getName());

		samlIdpSsoSession = samlIdpSsoSessionPersistence.create(
			samlIdpSsoSessionId);

		samlIdpSsoSession.setCompanyId(serviceContext.getCompanyId());
		samlIdpSsoSession.setUserId(user.getUserId());
		samlIdpSsoSession.setUserName(user.getFullName());
		samlIdpSsoSession.setCreateDate(now);
		samlIdpSsoSession.setModifiedDate(now);
		samlIdpSsoSession.setSamlIdpSsoSessionKey(samlIdpSsoSessionKey);

		samlIdpSsoSessionPersistence.update(samlIdpSsoSession);

		return samlIdpSsoSession;
	}


	public SamlIdpSsoSession fetchSamlIdpSso(String samlIdpSsoSessionKey)
		throws SystemException {

		return samlIdpSsoSessionPersistence.fetchBySamlIdpSsoSessionKey(
			samlIdpSsoSessionKey);
	}


	public SamlIdpSsoSession getSamlIdpSso(String samlIdpSsoSessionKey)
		throws PortalException, SystemException {

		return samlIdpSsoSessionPersistence.findBySamlIdpSsoSessionKey(
			samlIdpSsoSessionKey);
	}


	public SamlIdpSsoSession updateModifiedDate(String samlIdpSsoSessionKey)
		throws PortalException, SystemException {

		SamlIdpSsoSession samlIdpSsoSession =
			samlIdpSsoSessionPersistence.findBySamlIdpSsoSessionKey(
				samlIdpSsoSessionKey);

		samlIdpSsoSession.setModifiedDate(new Date());

		samlIdpSsoSessionPersistence.update(samlIdpSsoSession);

		return samlIdpSsoSession;
	}

}