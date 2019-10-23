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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.saml.NoSuchSpSessionException;
import com.liferay.saml.model.SamlSpSession;
import com.liferay.saml.service.base.SamlSpSessionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Mika Koivisto
 */
public class SamlSpSessionLocalServiceImpl
	extends SamlSpSessionLocalServiceBaseImpl {


	public SamlSpSession addSamlSpSession(
			String samlSpSessionKey, String assertionXml, String jSessionId,
			String nameIdFormat, String nameIdValue, String sessionIndex,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userLocalService.getUserById(serviceContext.getUserId());
		Date now = new Date();

		long samlSpSessionId = counterLocalService.increment(
			SamlSpSession.class.getName());

		SamlSpSession samlSpSession = samlSpSessionPersistence.create(
			samlSpSessionId);

		samlSpSession.setCompanyId(serviceContext.getCompanyId());
		samlSpSession.setGroupId(serviceContext.getScopeGroupId());
		samlSpSession.setUserId(user.getUserId());
		samlSpSession.setUserName(user.getFullName());
		samlSpSession.setCreateDate(now);
		samlSpSession.setModifiedDate(now);
		samlSpSession.setSamlSpSessionKey(samlSpSessionKey);
		samlSpSession.setAssertionXml(assertionXml);
		samlSpSession.setJSessionId(jSessionId);
		samlSpSession.setNameIdFormat(nameIdFormat);
		samlSpSession.setNameIdValue(nameIdValue);
		samlSpSession.setSessionIndex(sessionIndex);
		samlSpSession.setTerminated(false);

		samlSpSessionPersistence.update(samlSpSession);

		return samlSpSession;
	}


	public SamlSpSession fetchSamlSpSessionByJSessionId(String jSessionId)
		throws SystemException {

		return samlSpSessionPersistence.fetchByJSessionId(jSessionId);
	}


	public SamlSpSession fetchSamlSpSessionBySamlSpSessionKey(
			String samlSpSessionKey)
		throws SystemException {

		return samlSpSessionPersistence.fetchBySamlSpSessionKey(
			samlSpSessionKey);
	}


	public SamlSpSession fetchSamlSpSessionBySessionIndex(String sessionIndex)
		throws SystemException {

		if (Validator.isNull(sessionIndex)) {
			return null;
		}

		return samlSpSessionPersistence.fetchBySessionIndex(sessionIndex);
	}


	public SamlSpSession getSamlSpSessionByJSessionId(String jSessionId)
		throws PortalException, SystemException {

		return samlSpSessionPersistence.findByJSessionId(jSessionId);
	}


	public SamlSpSession getSamlSpSessionBySamlSpSessionKey(
			String samlSpSessionKey)
		throws PortalException, SystemException {

		return samlSpSessionPersistence.findBySamlSpSessionKey(
			samlSpSessionKey);
	}


	public SamlSpSession getSamlSpSessionBySessionIndex(String sessionIndex)
		throws PortalException, SystemException {

		if (Validator.isNull(sessionIndex)) {
			throw new NoSuchSpSessionException();
		}

		return samlSpSessionPersistence.findBySessionIndex(sessionIndex);
	}


	public List<SamlSpSession> getSamlSpSessions(String nameIdValue)
		throws SystemException {

		return samlSpSessionPersistence.findByNameIdValue(nameIdValue);
	}


	public SamlSpSession updateSamlSpSession(
			long samlSpSessionId, String samlSpSessionKey, String assertionXml,
			String jSessionId, String nameIdFormat, String nameIdValue,
			String sessionIndex, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userLocalService.getUserById(serviceContext.getUserId());

		SamlSpSession samlSpSession = samlSpSessionPersistence.findByPrimaryKey(
			samlSpSessionId);

		samlSpSession.setCompanyId(serviceContext.getCompanyId());
		samlSpSession.setGroupId(serviceContext.getScopeGroupId());
		samlSpSession.setUserId(user.getUserId());
		samlSpSession.setUserName(user.getFullName());
		samlSpSession.setModifiedDate(new Date());
		samlSpSession.setSamlSpSessionKey(samlSpSessionKey);
		samlSpSession.setAssertionXml(assertionXml);
		samlSpSession.setJSessionId(jSessionId);
		samlSpSession.setNameIdFormat(nameIdFormat);
		samlSpSession.setNameIdValue(nameIdValue);
		samlSpSession.setSessionIndex(sessionIndex);

		return samlSpSession;
	}

}