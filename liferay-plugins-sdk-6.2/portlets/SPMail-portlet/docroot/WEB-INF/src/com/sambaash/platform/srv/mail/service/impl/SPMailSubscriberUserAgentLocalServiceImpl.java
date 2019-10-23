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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;
import com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent;
import com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailSubscriberUserAgentLocalServiceBaseImpl;
import com.sambaash.platform.util.CachedUserAgentStringParserUtil;

import java.util.List;

import net.sf.uadetector.ReadableUserAgent;

/**
 * The implementation of the s p mail subscriber user agent local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailSubscriberUserAgentLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalServiceUtil
 */
public class SPMailSubscriberUserAgentLocalServiceImpl extends SPMailSubscriberUserAgentLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(SPMailSubscriberUserAgentLocalServiceImpl.class);
	
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalServiceUtil} to access the s p mail
	 * subscriber user agent local service.
	 */

	public void addUserAgent(long spMailCampaignId, long spMailCampaignSubscribersId, String userAgent)
			throws SystemException {

		SPMailSubscriberUserAgent subscriberUserAgent = null;

		try {
			subscriberUserAgent = spMailSubscriberUserAgentPersistence.findByCampaignIdAndSubscribersId(
					spMailCampaignId, spMailCampaignSubscribersId);
		} catch (NoSuchSubscriberUserAgentException nua) {
			try {
				CachedUserAgentStringParserUtil util = new CachedUserAgentStringParserUtil();
				ReadableUserAgent rua = util.parse(userAgent);

				subscriberUserAgent = spMailSubscriberUserAgentLocalService
						.createSPMailSubscriberUserAgent(CounterLocalServiceUtil
								.increment("SPMailSubscriberUserAgent.class"));
				subscriberUserAgent.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
				subscriberUserAgent.setSpMailCampaignId(spMailCampaignId);

				subscriberUserAgent.setDeviceCategory(rua.getDeviceCategory().getCategory().getName());
				subscriberUserAgent.setFamily(rua.getFamily().getName());
				subscriberUserAgent.setName(rua.getName());
				subscriberUserAgent.setType(rua.getType().getName());
				subscriberUserAgent.setTypeName(rua.getTypeName());
				subscriberUserAgent.setOperatingSystem(rua.getOperatingSystem().getName());
				subscriberUserAgent.setVersionNumber(rua.getVersionNumber().getMajor());
				subscriberUserAgent.setUserAgent(userAgent);

				spMailSubscriberUserAgentLocalService.updateSPMailSubscriberUserAgent(subscriberUserAgent);

			} catch (Exception e) {

				// if any error occurred while parsing and saving then at least save the complete userAgent details.

				subscriberUserAgent = spMailSubscriberUserAgentLocalService
						.createSPMailSubscriberUserAgent(CounterLocalServiceUtil
								.increment("SPMailSubscriberUserAgent.class"));
				subscriberUserAgent.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
				subscriberUserAgent.setSpMailCampaignId(spMailCampaignId);
				subscriberUserAgent.setUserAgent(userAgent);
				spMailSubscriberUserAgentLocalService.updateSPMailSubscriberUserAgent(subscriberUserAgent);
			}
		}
	}

	public List<Object[]> countMailSubscriberByDeviceCatogory(long spMailCampaignId) throws SystemException {
		//SELECT operatingSystem,COUNT(operatingSystem) FROM SPMailSubscriberUserAgent GROUP BY typeName;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailSubscriberUserAgent.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("deviceCategory"));
			proList.add(ProjectionFactoryUtil.groupProperty("deviceCategory"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailSubscriberUserAgentLocalServiceUtil.dynamicQuery(dynamicQuery);
//						for (Object[] obj : result) {
//							_log.error((String) obj[1]);
//							_log.error((String) obj[2]);
//						}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<Object[]> countMailSubscriberByFamily(long spMailCampaignId) throws SystemException {
		//SELECT operatingSystem,COUNT(operatingSystem) FROM SPMailSubscriberUserAgent GROUP BY typeName;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailSubscriberUserAgent.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("family"));
			proList.add(ProjectionFactoryUtil.groupProperty("family"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailSubscriberUserAgentLocalServiceUtil.dynamicQuery(dynamicQuery);
//						for (Object[] obj : result) {
//							_log.error((String) obj[1]);
//							_log.error((String) obj[2]);
//						}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<Object[]> countMailSubscriberByName(long spMailCampaignId) throws SystemException {
		//SELECT operatingSystem,COUNT(operatingSystem) FROM SPMailSubscriberUserAgent GROUP BY typeName;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailSubscriberUserAgent.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("name"));
			proList.add(ProjectionFactoryUtil.groupProperty("name"));
			Order defaultOrder = OrderFactoryUtil.asc("name");
			dynamicQuery.addOrder(defaultOrder);
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailSubscriberUserAgentLocalServiceUtil.dynamicQuery(dynamicQuery);


			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<Object[]> countMailSubscriberByOS(long spMailCampaignId) throws SystemException {
		//SELECT operatingSystem,COUNT(operatingSystem) FROM SPMailSubscriberUserAgent GROUP BY typeName;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailSubscriberUserAgent.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			//proList.add(ProjectionFactoryUtil.count("userAgent"));
			proList.add(ProjectionFactoryUtil.count("operatingSystem"));
			//proList.add(ProjectionFactoryUtil.groupProperty("userAgent"));
			proList.add(ProjectionFactoryUtil.groupProperty("operatingSystem"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailSubscriberUserAgentLocalServiceUtil.dynamicQuery(dynamicQuery);
//						for (Object[] obj : result) {
//							_log.error((String) obj[1]);
//							_log.error((String) obj[2]);
//						}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<Object[]> countMailSubscriberByType(long spMailCampaignId) throws SystemException {
		//SELECT operatingSystem,COUNT(operatingSystem) FROM SPMailSubscriberUserAgent GROUP BY typeName;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailSubscriberUserAgent.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("type"));
			proList.add(ProjectionFactoryUtil.groupProperty("type"));
			Order defaultOrder = OrderFactoryUtil.asc("type");
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailSubscriberUserAgentLocalServiceUtil.dynamicQuery(dynamicQuery);


			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<Object[]> countMailSubscriberByTypeName(long spMailCampaignId) throws SystemException {
		//SELECT typeName,COUNT(typeName) FROM SPMailSubscriberUserAgent GROUP BY typeName;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailSubscriberUserAgent.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("typeName"));
			//proList.add(ProjectionFactoryUtil.countDistinct("userAgent"));
			//proList.add(ProjectionFactoryUtil.countDistinct("operatingSystem"));
			proList.add(ProjectionFactoryUtil.groupProperty("typeName"));
			//proList.add(ProjectionFactoryUtil.groupProperty("userAgent"));
			//proList.add(ProjectionFactoryUtil.groupProperty("operatingSystem"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = SPMailSubscriberUserAgentLocalServiceUtil.dynamicQuery(dynamicQuery);
//						for (Object[] obj : result) {
//							_log.error((String) obj[1]);
//							_log.error((String) obj[2]);
//						}

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

}