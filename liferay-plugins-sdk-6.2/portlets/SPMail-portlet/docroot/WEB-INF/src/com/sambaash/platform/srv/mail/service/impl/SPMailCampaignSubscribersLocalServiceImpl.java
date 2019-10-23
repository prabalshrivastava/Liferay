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

import com.amazonaws.services.cloudfront_2012_03_15.model.InvalidArgumentException;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.constant.SambaashConstants.LOCATION;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;
import com.sambaash.platform.srv.mail.SPMailCampaignSubscribersEmailException;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailCampaignSubscribersLocalServiceBaseImpl;
import com.sambaash.platform.srv.mail.service.persistence.SPMailCampaignSubscribersUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The implementation of the s p mail campaign subscribers local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailCampaignSubscribersLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil
 */
public class SPMailCampaignSubscribersLocalServiceImpl extends SPMailCampaignSubscribersLocalServiceBaseImpl {
	public SPMailCampaignSubscribers addNewsLetterCampaignSubscriber(String firstName, String lastName, String email,
			boolean emailOnly, long spMailCampaignId) throws PortalException, SystemException {

		SPMailCampaignSubscribers spMailCampaignSubscribers = null;
		try {
			spMailCampaignSubscribers = spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndEmailAddress(
					spMailCampaignId, SPMailType.MAIN.getCode(), email);
			throw new SPMailCampaignSubscribersEmailException("2");
		} catch (NoSuchCampaignSubscribersException ncsce) {
			spMailCampaignSubscribers = spMailCampaignSubscribersPersistence.create(counterLocalService
					.increment(SPMailCampaignSubscribers.class.getName()));
			spMailCampaignSubscribers.setCreateDate(DateUtil.newDate());
			spMailCampaignSubscribers.setSpMailCampaignId(spMailCampaignId);
			spMailCampaignSubscribers.setEmailAddress(email);
			spMailCampaignSubscribers.setStatus(SPMailStatus.NOT_SCHEDULED.getStatus());
			spMailCampaignSubscribers.setSpMailType(SPMailType.MAIN.getCode());

			if (!emailOnly) {
				spMailCampaignSubscribers.setFirstName(firstName);
				spMailCampaignSubscribers.setLastName(lastName);
			} else {
				spMailCampaignSubscribers.setFirstName("NA");
				spMailCampaignSubscribers.setLastName("NA");
			}

			spMailCampaignSubscribersPersistence.update(spMailCampaignSubscribers);
		}

		return spMailCampaignSubscribers;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform
	 * .srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil} to access the s p mail campaign subscribers local
	 * service.
	 */

	public void clearCache() {
		SPMailCampaignSubscribersUtil.clearCache();
	}

	public int countByCampaignId(long spMailCampaignId) throws SystemException {
		return spMailCampaignSubscribersPersistence.countByCampaignId(spMailCampaignId);
	}

	public int countByCampaignIdAndMailType(long spMailCampaignId, int spMailType) throws SystemException {
		return spMailCampaignSubscribersPersistence.countByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	public int countByCampaignIdAndOpened(long spMailCampaignId, boolean opened) throws SystemException {
		return spMailCampaignSubscribersPersistence.countByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	public int countByCampaignIdMailTypeAndOpened(long spMailCampaignId, int spMailType, boolean opened)
			throws SystemException {
		return spMailCampaignSubscribersPersistence.countByCampaignIdMailTypeAndOpened(spMailCampaignId, spMailType,
				opened);
	}

	public int countByCampaignIdMailTypeAndStatus(long spMailCampaignId, int spMailType, int status)
			throws SystemException {
		return spMailCampaignSubscribersPersistence.countByCampaignIdMailTypeAndStatus(spMailCampaignId, spMailType,
				status);
	}

	public List<Object[]> countOpenedMailByCountry(long spMailCampaignId, int spMailType) throws SystemException {

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailCampaignSubscribers.class,
					PortletClassLoaderUtil.getClassLoader("SPMailSubscriberListing_WAR_SPMailportlet"));
			dynamicQuery.add(PropertyFactoryUtil.forName("spMailCampaignId").eq(new Long(spMailCampaignId)))
					.add(PropertyFactoryUtil.forName("spMailType").eq(new Integer(spMailType)))
					.add(PropertyFactoryUtil.forName("opened").eq(new Boolean(true)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.count("countryName"));
			proList.add(ProjectionFactoryUtil.groupProperty("countryName"));
			dynamicQuery.setProjection(proList);

			@SuppressWarnings("unchecked")
			List<Object[]> result = spMailCampaignSubscribersLocalService.dynamicQuery(dynamicQuery);

			return result;
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	public List<SPMailCampaignSubscribers> findByCampaignId(long spMailCampaignId) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignId(spMailCampaignId);
	}

	public List<SPMailCampaignSubscribers> findByCampaignId(long spMailCampaignId, int start, int end)
			throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignId(spMailCampaignId, start, end);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(long spMailCampaignId, String emailAddress)
			throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndEmailAddress(spMailCampaignId, emailAddress);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndFirstName(long spMailCampaignId, String firstName)
			throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndFirstName(spMailCampaignId, firstName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndLastName(long spMailCampaignId, String lastName)
			throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndLastName(spMailCampaignId, lastName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndMailType(long spMailCampaignId, int spMailType)
			throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndMailType(long spMailCampaignId, int spMailType,
			int start, int end) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndMailType(spMailCampaignId, spMailType, start,
				end);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndOpened(long spMailCampaignId, boolean opened)
			throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdAndOpened(long spMailCampaignId, boolean opened, int start,
			int end) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdAndOpened(spMailCampaignId, opened, start, end);
	}

	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndEmailAddress(long spMailCampaignId, int spMailType,
			String emailAddress) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
				spMailType, emailAddress);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(long spMailCampaignId, int spMailType,
			String firstName) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndFirstName(spMailCampaignId, spMailType,
				firstName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(long spMailCampaignId, int spMailType,
			String lastName) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndLastName(spMailCampaignId, spMailType,
				lastName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(long spMailCampaignId, int spMailType,
			boolean opened) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndOpened(spMailCampaignId, spMailType,
				opened);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(long spMailCampaignId, int spMailType,
			boolean opened, int start, int end) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndOpened(spMailCampaignId, spMailType,
				opened, start, end);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(long spMailCampaignId, int spMailType,
			int status) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndStatus(spMailCampaignId, spMailType,
				status);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(long spMailCampaignId,
			int spMailType, boolean opened, String emailAddress) throws SystemException,
			NoSuchCampaignSubscribersException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
				spMailType, opened, emailAddress);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(long spMailCampaignId,
			int spMailType, boolean opened, String firstName) throws SystemException,
			NoSuchCampaignSubscribersException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
				spMailType, opened, firstName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(long spMailCampaignId,
			int spMailType, boolean opened, String lastName) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
				spMailType, opened, lastName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(long spMailCampaignId, boolean opened,
			String emailAddress) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdOpenedAndEmailAddress(spMailCampaignId, opened,
				emailAddress);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(long spMailCampaignId, boolean opened,
			String firstName) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdOpenedAndFirstName(spMailCampaignId, opened,
				firstName);
	}

	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(long spMailCampaignId, boolean opened,
			String lastName) throws NoSuchCampaignSubscribersException, SystemException {
		return spMailCampaignSubscribersPersistence.findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
				lastName);
	}

	public List<SPMailCampaignSubscribers> findByEmailAddress(String emailAddress) throws SystemException {
		return spMailCampaignSubscribersPersistence.findByEmailAddress(emailAddress);
	}

	public List<SPMailCampaignSubscribers> findByEmailAddress(String emailAddress, int start, int end)
			throws SystemException {
		return spMailCampaignSubscribersPersistence.findByEmailAddress(emailAddress, start, end);
	}

	public SPMailCampaignSubscribers findByMessageId(String messageId) throws SystemException,
			NoSuchCampaignSubscribersException {
		return spMailCampaignSubscribersPersistence.findByMessageId(messageId);
	}
	
	public List<SPMailCampaignSubscribers> findByUserId(long userId) throws SystemException,
	NoSuchCampaignSubscribersException {
		return spMailCampaignSubscribersPersistence.findByUserId(userId);
	}
	
	public int countByUserIdAndOpened(long userId, boolean opened) throws SystemException {
		return spMailCampaignSubscribersPersistence.countByUserIdAndOpened(userId, opened);
	}

	public SPMailCampaignSubscribers updateSubscriber(long subscriberId, String ipAddress, String userAgent) {

		try {
			SPMailCampaignSubscribers subscriber = SPMailCampaignSubscribersLocalServiceUtil
					.getSPMailCampaignSubscribers(subscriberId);
			boolean update = false;

			if (!subscriber.isOpened()) {
				try {
					spMailSubscriberUserAgentPersistence.findByCampaignIdAndSubscribersId(
							subscriber.getSpMailCampaignId(), subscriber.getSpMailCampaignSubscribersId());
				} catch (NoSuchSubscriberUserAgentException nssuae) {
					spMailSubscriberUserAgentLocalService.addUserAgent(subscriber.getSpMailCampaignId(),
							subscriber.getSpMailCampaignSubscribersId(), userAgent);
				}

				subscriber.setOpened(true);
				subscriber.setOpenedDate(DateUtil.newDate());
				subscriber.setIpAddress(ipAddress);
				update = true;
			}

			if (Validator.isNull(subscriber.getCountryName())) {
				JSONObject obj = getLocation(ipAddress);

				if (obj != null) {
					try {
						subscriber.setCountryName(obj.getString(LOCATION.COUNTRY_NAME));

						if (!obj.isNull(LOCATION.CITY_NAME)) {
							subscriber.setCity(obj.getString(LOCATION.CITY_NAME));
						}

						if (!obj.isNull(LOCATION.AREA_CODE) && Validator.isNotNull(obj.getString(LOCATION.AREA_CODE))
								&& Validator.isDigit(obj.getString(LOCATION.AREA_CODE))) {
							subscriber.setAreaCode(obj.getInt(LOCATION.AREA_CODE));
						}

						if (!obj.isNull(LOCATION.REGION_NAME)) {
							subscriber.setRegionName(obj.getString(LOCATION.REGION_NAME));
						}

						subscriber.setLatitude(String.valueOf((obj.getDouble(LOCATION.LATITUDE))));
						subscriber.setLongitude(String.valueOf(obj.getDouble(LOCATION.LONGITUDE)));
						update = true;
					} catch (JSONException e) {
						_log.error("Error occured while parsing json geo location result", e);
					}
				}
			}

			if (update) {
				spMailCampaignSubscribersLocalService.updateSPMailCampaignSubscribers(subscriber);
			}

			return subscriber;

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;
	}

	private JSONObject getLocation(String ipAddress) {
//		try {
//			BufferedReader br = null;
//			InputStreamReader isr = null;
//			StringBuffer response = new StringBuffer();
//			try {
//				if ("127.0.0.1".equalsIgnoreCase(ipAddress)) {
//					ipAddress = "203.92.72.130";
//				}
//
//				URL url = new URL("http://www.telize.com/geoip/" + ipAddress);
//				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//				isr = new InputStreamReader(conn.getInputStream());
//				br = new BufferedReader(isr);
//				String temp;
//				while ((temp = br.readLine()) != null) {
//					response.append(temp);
//				}
//
//			} catch (MalformedURLException e) {
//				_log.error(e);
//			} finally {
//				if (br != null)
//					br.close();
//
//				if (isr != null)
//					isr.close();
//			}
//
//			return new JSONObject(response.toString());
//		} catch (Exception e) {
//			_log.error("Error occured while calling geo location api for tracking.");
//		}

		return null;
	}

	public SPMailCampaignSubscribers create() throws SystemException{
		long spSubId = CounterLocalServiceUtil.increment("SPMailCampaignSubscribers.class");
		SPMailCampaignSubscribers sp = SPMailCampaignSubscribersLocalServiceUtil
				.createSPMailCampaignSubscribers(spSubId);
		return sp;
	}
	
	public void addSubscriber(long companyId, long createdBy,long spMailCampaignId,String firstName,String lastName,String emailAddress) throws SystemException {
		if(!Validator.isEmailAddress(emailAddress)){
			throw new InvalidArgumentException("Email Address is not valid");
		}
		List<SPMailCampaignEDM>edms = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(spMailCampaignId);
		long userId = 0;
		try {
			 User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			 userId = user.getUserId();
		} catch (Exception e) {
			_log.error("Error while fetching user. Email " + emailAddress + ". Error: " + e.getMessage());
		}
		for (SPMailCampaignEDM spMailCampaignEDM : edms) {
			try {
				 spMailCampaignSubscribersPersistence.findByCampaignIdMailTypeAndEmailAddress(
						spMailCampaignId, spMailCampaignEDM.getSeqNo(), emailAddress);
			} catch (NoSuchCampaignSubscribersException ncsce) {
				SPMailCampaignSubscribers sp = create();
				Calendar cal = Calendar.getInstance();
				
				sp.setFirstName(firstName);
				sp.setLastName(lastName);
				sp.setEmailAddress(emailAddress);
				sp.setCreateBy(createdBy);
				sp.setSpMailCampaignId(spMailCampaignId);
				sp.setSpMailType((int) spMailCampaignEDM.getSeqNo());
				sp.setUserId(userId);
				sp.setCreateDate(cal.getTime());
				sp.setParentSubscriberId(0);
				
				SPMailCampaignSubscribersLocalServiceUtil
				.addSPMailCampaignSubscribers(sp);
			}
		}
	
	}
	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignSubscribersLocalServiceImpl.class);

}