/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.mail.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.sambaash.platform.srv.mail.model.SPEMailAudit;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPEMailAuditLocalServiceBaseImpl;
import com.sambaash.platform.srv.mail.service.persistence.SPEMailAuditUtil;

/**
 * The implementation of the s p e mail audit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.mail.service.SPEMailAuditLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.mail.service.base.SPEMailAuditLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPEMailAuditLocalServiceUtil
 */
public class SPEMailAuditLocalServiceImpl extends SPEMailAuditLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPEMailAuditLocalServiceUtil} to
	 * access the s p e mail audit local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SPEMailAuditLocalServiceImpl.class);

	public List<SPEMailAudit> findEMails(long processStateId, long nodeId, long userId, long orgId) {

		try {
			return SPEMailAuditUtil.findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId, nodeId, userId,
					orgId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public List<SPEMailAudit> findEMails(long processStateId, long nodeId, long orgId) {

		try {
			return SPEMailAuditUtil.findByProcessStateIdAndNodeIdAndOrgId(processStateId, nodeId, orgId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public List<Object> findEMailsTriggered(long processStateId, long nodeId, long orgId) {

		try {

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailTemplate.class,
					PortletClassLoaderUtil.getClassLoader("SPMail_WAR_SPMailportlet"));

			dynamicQuery.add(PropertyFactoryUtil.forName("nodeId").eq(new Long(nodeId)))
					.add(PropertyFactoryUtil.forName("processStateId").eq(new Long(processStateId)))
					.add(PropertyFactoryUtil.forName("orgId").eq(new Long(orgId)));
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.property("category"));
			projectionList.add(ProjectionFactoryUtil.groupProperty("category"));

			dynamicQuery.setProjection(projectionList);

			List<Object> resultsItr = SPMailTemplateLocalServiceUtil.dynamicQuery(dynamicQuery);
			return resultsItr;
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

}