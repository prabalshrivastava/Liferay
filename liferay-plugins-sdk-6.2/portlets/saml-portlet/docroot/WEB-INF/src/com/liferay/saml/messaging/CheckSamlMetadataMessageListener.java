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

package com.liferay.saml.messaging;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.service.SamlIdpSpConnectionLocalServiceUtil;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;
import com.liferay.saml.util.SamlUtil;

import java.util.List;

/**
 * @author Mika Koivisto
 */
public class CheckSamlMetadataMessageListener extends BaseMessageListener {


	protected void doReceive(Message message) throws Exception {
		List<Company> companies = CompanyLocalServiceUtil.getCompanies(false);

		for (Company company : companies) {
			if (!company.isActive()) {
				continue;
			}
			
			long companyId = company.getCompanyId();
			
			if (SamlUtil.isRoleIdp(companyId))
				updateSpMetadata(company);
			else if (SamlUtil.isRoleSp(companyId))
				updateIdpMetadata(companyId);
		}
	}
	
	protected void updateIdpMetadata(long companyId) throws SystemException {
		_log.trace("updateIdpMetadata -- company ID = " + companyId);
		try {
			List<Group> groups = GroupLocalServiceUtil.getLiveGroups();//getGroups(companyId, 0, true);
			for (Group group : groups) {
				try {
					if (group.isCompany()) continue;
					updateIdpMetadata(companyId, group.getGroupId());
				} catch (Exception e2) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Unable to refresh IdP metadata for group " +
								group.getName(),
							e2);
					}
					
				}
			}
		} catch (Exception e1) {
			if (_log.isWarnEnabled()) {
				_log.warn(
						"Unable to get organizations for company ID " + companyId, e1);
			}
		}
	}

	protected void updateIdpMetadata(long companyId, long groupId) throws SystemException, PortalException {
		if (!SamlUtil.isEnabled(companyId, groupId))
			return;
		
		_log.trace("updateIdpMetadata -- company ID = " + companyId + ", group ID = " + groupId);
		SamlSpIdpConnection samlSpIdpConnection =
			SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(
				companyId, groupId);

		if (!samlSpIdpConnection.isEnabled() ||
			Validator.isNull(samlSpIdpConnection.getMetadataUrl()))
			return;

		try {
			SamlSpIdpConnectionLocalServiceUtil.updateMetadata(
				samlSpIdpConnection.getSamlSpIdpConnectionId());
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to refresh IdP metadata for " +
						samlSpIdpConnection.getSamlIdpEntityId(),
					e);
			}
		}
	}

	protected void updateSpMetadata(Company company) throws SystemException, PortalException {
		_log.trace("updateSpMetadata -- company ID = " + company.getCompanyId());
		List<SamlIdpSpConnection> samlIdpSpConnections =
			SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnections(
				company.getCompanyId());

		for (SamlIdpSpConnection samlIdpSpConnection : samlIdpSpConnections) {
			if (!samlIdpSpConnection.isEnabled() ||
				Validator.isNull(samlIdpSpConnection.getMetadataUrl())) {

				continue;
			}

			try {
				_log.trace("Update metadata for " + samlIdpSpConnection.getName());
				SamlIdpSpConnectionLocalServiceUtil.updateMetadata(
					samlIdpSpConnection.getSamlIdpSpConnectionId());
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to refresh SP metadata for " +
							samlIdpSpConnection.getSamlSpEntityId(),
						e);
				}
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CheckSamlMetadataMessageListener.class);
}
