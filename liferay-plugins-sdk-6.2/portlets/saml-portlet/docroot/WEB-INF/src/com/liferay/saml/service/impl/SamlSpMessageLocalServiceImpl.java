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
import com.liferay.portal.service.ServiceContext;
import com.liferay.saml.model.SamlSpMessage;
import com.liferay.saml.service.base.SamlSpMessageLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Mika Koivisto
 */
public class SamlSpMessageLocalServiceImpl
	extends SamlSpMessageLocalServiceBaseImpl {


	public SamlSpMessage addSamlSpMessage(
			String samlIdpEntityId, String samlIdpResponseKey,
			Date expirationDate, ServiceContext serviceContext)
		throws SystemException {

		long samlSpMessageId = counterLocalService.increment(
			SamlSpMessage.class.getName());

		SamlSpMessage samlSpMessage = samlSpMessagePersistence.create(
			samlSpMessageId);

		samlSpMessage.setCompanyId(serviceContext.getCompanyId());
		samlSpMessage.setCreateDate(new Date());
		samlSpMessage.setSamlIdpEntityId(samlIdpEntityId);
		samlSpMessage.setSamlIdpResponseKey(samlIdpResponseKey);
		samlSpMessage.setExpirationDate(expirationDate);

		samlSpMessagePersistence.update(samlSpMessage);

		return samlSpMessage;
	}


	public SamlSpMessage fetchSamlSpMessage(
			String samlIdpEntityId, String samlIdpResponseKey)
		throws SystemException {

		return samlSpMessagePersistence.fetchBySIEI_SIRK(
			samlIdpEntityId, samlIdpResponseKey);
	}


	public SamlSpMessage getSamlSpMessage(
			String samlIdpEntityId, String samlIdpResponseKey)
		throws PortalException, SystemException {

		return samlSpMessagePersistence.findBySIEI_SIRK(
			samlIdpEntityId, samlIdpResponseKey);
	}

}