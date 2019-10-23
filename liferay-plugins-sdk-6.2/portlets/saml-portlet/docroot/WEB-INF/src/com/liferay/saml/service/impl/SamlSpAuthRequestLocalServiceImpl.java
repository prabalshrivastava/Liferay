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
import com.liferay.saml.model.SamlSpAuthRequest;
import com.liferay.saml.service.base.SamlSpAuthRequestLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Mika Koivisto
 */
public class SamlSpAuthRequestLocalServiceImpl
	extends SamlSpAuthRequestLocalServiceBaseImpl {


	public SamlSpAuthRequest addSamlSpAuthRequest(
			String samlIdpEntityId, String samlSpAuthRequestKey,
			ServiceContext serviceContext)
		throws SystemException {

		long samlSpAuthRequestId = counterLocalService.increment(
			SamlSpAuthRequest.class.getName());

		SamlSpAuthRequest samlSpAuthRequest =
			samlSpAuthRequestPersistence.create(samlSpAuthRequestId);

		samlSpAuthRequest.setCompanyId(serviceContext.getCompanyId());
		samlSpAuthRequest.setCreateDate(new Date());
		samlSpAuthRequest.setSamlIdpEntityId(samlIdpEntityId);
		samlSpAuthRequest.setSamlSpAuthRequestKey(samlSpAuthRequestKey);

		samlSpAuthRequestPersistence.update(samlSpAuthRequest);

		return samlSpAuthRequest;
	}


	public SamlSpAuthRequest fetchSamlSpAuthRequest(
			String samlIdpEntityId, String samlSpAuthRequestKey)
		throws SystemException {

		return samlSpAuthRequestPersistence.fetchBySIEI_SSARK(
			samlIdpEntityId, samlSpAuthRequestKey);
	}


	public SamlSpAuthRequest getSamlSpAuthRequest(
			String samlIdpEntityId, String samlSpAuthRequestKey)
		throws PortalException, SystemException {

		return samlSpAuthRequestPersistence.findBySIEI_SSARK(
			samlIdpEntityId, samlSpAuthRequestKey);
	}

}