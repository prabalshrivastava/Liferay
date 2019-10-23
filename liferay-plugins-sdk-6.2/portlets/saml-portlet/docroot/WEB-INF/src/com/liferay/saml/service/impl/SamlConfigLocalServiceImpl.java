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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;
import com.liferay.saml.service.base.SamlConfigLocalServiceBaseImpl;
import com.liferay.saml.util.SamlUtil;

/**
 * The implementation of the saml config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.saml.service.SamlConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mika Koivisto
 * @see com.liferay.saml.service.base.SamlConfigLocalServiceBaseImpl
 * @see com.liferay.saml.service.SamlConfigLocalServiceUtil
 */
public class SamlConfigLocalServiceImpl extends SamlConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.saml.service.SamlConfigLocalServiceUtil} to access the saml config local service.
	 */
	
	public Boolean isEnabled(long companyId, long groupId) {
		try {
			return new Boolean(SamlUtil.isEnabled(companyId, groupId));
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
	
//	public String getLinkText(long companyId, long groupId) throws PortalException {
//		if (this.isEnabled(companyId, groupId)) {
//			try {
//				SamlSpIdpConnection connection = 
//						SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(companyId, groupId);
//				return connection.getLinkText();
//			} catch (Exception e) {
//				throw new PortalException(e);
//			}
//		}
//		else
//			return StringPool.BLANK;
//	}
//	
//	public String getLoginLink(long companyId, long groupId) throws PortalException {
//		if (this.isEnabled(companyId, groupId)) 
//			return SamlUtil.getLoginLink(groupId);
//		else
//			return StringPool.BLANK;
//	}
}