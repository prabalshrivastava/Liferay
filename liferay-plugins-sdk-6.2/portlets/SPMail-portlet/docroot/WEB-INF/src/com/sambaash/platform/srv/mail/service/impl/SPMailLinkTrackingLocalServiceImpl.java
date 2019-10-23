/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.DateUtil;

import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;
import com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailLinkTrackingLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the s p mail link tracking local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailLinkTrackingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil
 */
public class SPMailLinkTrackingLocalServiceImpl extends SPMailLinkTrackingLocalServiceBaseImpl {
	public List<Object[]> countOpenedMailByLink(long spMailCampaignId) throws SystemException {
		//select count(status), status, link from SPMailLinkTracking where spMailCampaignId = 801 group by link, status
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailLinkTracking.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("status"));
			proList.add(ProjectionFactoryUtil.groupProperty("link"));
			proList.add(ProjectionFactoryUtil.groupProperty("status"));
			proList.add(ProjectionFactoryUtil.groupProperty("label"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailLinkTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
			//			for (Object[] obj : result) {
			//				_log.error(String.valueOf(((Boolean) obj[1])));
			//				_log.error((String) obj[2]);
			//			}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<Object[]> countOpenedMailByLink(long spMailCampaignId,long mailType) throws SystemException {
		//select count(status), status, link from SPMailLinkTracking where spMailCampaignId = 801 group by link, status
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailLinkTracking.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignEDMId").eq(new Long(mailType)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("status"));
			proList.add(ProjectionFactoryUtil.groupProperty("link"));
			proList.add(ProjectionFactoryUtil.groupProperty("status"));
			proList.add(ProjectionFactoryUtil.groupProperty("label"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailLinkTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
						for (Object[] obj : result) {
			//				_log.error(String.valueOf(((Boolean) obj[1])));
			//				_log.error((String) obj[2]);
						}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}
	
	public List<Object[]> getMailLinkInteractionCount(long spMailCampaignId,long spMailCampaignSubscribersId) throws SystemException {
		//select count(status), status, link from SPMailLinkTracking where spMailCampaignId = 801 group by link, status
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailLinkTracking.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignSubscribersId").eq(new Long(spMailCampaignSubscribersId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("status"));
			proList.add(ProjectionFactoryUtil.groupProperty("link"));
			proList.add(ProjectionFactoryUtil.groupProperty("status"));
			proList.add(ProjectionFactoryUtil.groupProperty("label"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailLinkTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
						for (Object[] obj : result) {
							//_log.error("count " + String.valueOf(((Boolean) obj[1])));
							//_log.error("count " + (String) obj[2]);
						}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	
	public List<SPMailLinkTracking> findByCampaignIdAndSubscribersId(long campaignId, long subscriberId)
			throws SystemException {

		return spMailLinkTrackingPersistence.findByCampaignIdAndSubscribersId(campaignId, subscriberId);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil} to access the s p mail link tracking
	 * local service.
	 */

	public void trackLink(long trackingId) {
		try {
			SPMailLinkTracking spMailLinkTracking = spMailLinkTrackingLocalService.getSPMailLinkTracking(trackingId);

			if (!spMailLinkTracking.isStatus()) {
				spMailLinkTracking.setOpenedDate(DateUtil.newDate());
				spMailLinkTracking.setStatus(true);
				spMailLinkTrackingLocalService.updateSPMailLinkTracking(spMailLinkTracking);
			}
		} catch (Exception e) {
			_log.error("Link not found. It means it is a test template workflow.");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPMailLinkTrackingLocalServiceImpl.class);

}