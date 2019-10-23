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

package com.sambaash.platform.srv.spsocialprofile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar;
import com.sambaash.platform.srv.spsocialprofile.service.base.UserAvailabilityCalendarLocalServiceBaseImpl;

/**
 * The implementation of the user availability calendar local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.UserAvailabilityCalendarLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.UserAvailabilityCalendarLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.UserAvailabilityCalendarLocalServiceUtil
 */
public class UserAvailabilityCalendarLocalServiceImpl extends
		UserAvailabilityCalendarLocalServiceBaseImpl {
	public UserAvailabilityCalendar addUserAvailabilityCalendar(long userId,
			long companyId, String availableFor, Date startDate, Date endDate)
			throws PortalException, SystemException {
		UserAvailabilityCalendar cal = userAvailabilityCalendarPersistence
				.create(counterLocalService.increment());

		cal.setActive(true);
		cal.setAvailableFor(availableFor);
		cal.setUserId(userId);
		cal.setCompanyId(companyId);
		cal.setStartDate(startDate);
		cal.setEndDate(endDate);
		cal.setCreateDate(new Date());
		updateUserAvailabilityCal(cal);
		// SocialProfileIndexer.updateDocument(userId, companyId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class
				.getName());
		try {
			indexer.reindex(SocialProfile.class.getName(), userId);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}

		return cal;
	}

	public void deleteUserAvailabilityInfo(UserAvailabilityCalendar info)
			throws PortalException, SystemException {
		info.setActive(false);
		deleteUserAvailabilityCalendar(info.getUserAvailabilityCalendarId());
	}

	public void delUserAvailabilityCalendar(long availabilityId)
			throws SystemException, PortalException {
		UserAvailabilityCalendar cal = userAvailabilityCalendarPersistence
				.findByPrimaryKey(availabilityId);
		cal.setActive(false);
		cal.setModifiedDate(new Date());
		updateUserAvailabilityCalendar(cal);
	}

	public List<UserAvailabilityCalendar> getActiveCalendarListByUserId(
			Long userId, Long companyId) throws SystemException {
		List<UserAvailabilityCalendar> resultList = new ArrayList<UserAvailabilityCalendar>();
		List<UserAvailabilityCalendar> results = getUserAvailabilityList(
				userId, companyId);

		if (results != null && results.size() > 0) {
			for (UserAvailabilityCalendar cal : results) {
				if (!cal.getActive()
						|| (cal.getEndDate() != null && cal.getEndDate()
								.before(new Date()))) {
					continue;
				}

				resultList.add(cal);
			}
		}

		return resultList;
	}

	public List<UserAvailabilityCalendar> getUserAvailabilityList(Long userId,
			Long companyId) throws SystemException {
		return userAvailabilityCalendarPersistence.findByUserIdAndCompanyId(
				companyId, userId);
	}

	public void updateUserAvailabilityCal(
			UserAvailabilityCalendar userAvailabilityCalendar)
			throws PortalException, SystemException {

		userAvailabilityCalendar.setModifiedDate(new Date());
		userAvailabilityCalendarPersistence.update(userAvailabilityCalendar);
		// SocialProfileIndexer.updateDocument(userAvailabilityCalendar.getUserId(),
		// userAvailabilityCalendar.getCompanyId());

		Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class
				.getName());
		try {
			indexer.reindex(SocialProfile.class.getName(),
					userAvailabilityCalendar.getUserId());
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.service.UserAvailabilityCalendarLocalServiceUtil}
	 * to access the user availability calendar local service.
	 */

	private static Log _log = LogFactoryUtil
			.getLog(UserAvailabilityCalendarLocalServiceImpl.class);

}