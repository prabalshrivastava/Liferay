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

package com.liferay.calendar.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.persistence.CalendarBookingActionableDynamicQuery;
import com.liferay.calendar.workflow.CalendarBookingWorkflowConstants;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.trash.util.TrashUtil;

/**
 * @author Adam Victor Brandizzi
 * @author Eduardo Lundgren
 */
public class CalendarBookingIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { CalendarBooking.class.getName() };

	public static final String PORTLET_ID = PortletKeys.CALENDAR;

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public Map<String, String> getIndexedFields() {
		Map<String, String> map = new HashMap<String, String>(super.getIndexedFields());
		map.put("calendarBookingId", "Calendar Booking Id");
		map.put("defaultLanguageId", "Default Language Id");
		map.put("endTime_", "End Time");
		map.put("startTime_", "Start Time");
		map.put("location", "Location");
		return map;
	}
	
	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		CalendarBooking calendarBooking = (CalendarBooking)obj;

		deleteDocument(calendarBooking.getCompanyId(), calendarBooking.getCalendarBookingId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		CalendarBooking calendarBooking = (CalendarBooking)obj;

		Document document = getBaseModelDocument(PORTLET_ID, calendarBooking);

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		String descriptionDefaultLanguageId = LocalizationUtil.getDefaultLanguageId(calendarBooking.getDescription());

		String[] descriptionLanguageIds = getLanguageIds(defaultLanguageId, calendarBooking.getDescription());

		for (String descriptionLanguageId : descriptionLanguageIds) {
			String description = calendarBooking.getDescription(descriptionLanguageId);

			if (descriptionLanguageId.equals(descriptionDefaultLanguageId)) {
				document.addText(Field.DESCRIPTION, description);
			}

			document.addText(Field.DESCRIPTION.concat(StringPool.UNDERLINE).concat(descriptionLanguageId), description);
		}

		String titleDefaultLanguageId = LocalizationUtil.getDefaultLanguageId(calendarBooking.getTitle());

		String[] titleLanguageIds = getLanguageIds(defaultLanguageId, calendarBooking.getTitle());

		for (String titleLanguageId : titleLanguageIds) {
			String title = calendarBooking.getTitle(titleLanguageId);

			if (titleLanguageId.equals(titleDefaultLanguageId)) {
				document.addText(Field.TITLE, title);
			}

			document.addText(Field.TITLE.concat(StringPool.UNDERLINE).concat(titleLanguageId), title);
		}

		String calendarBookingId = String.valueOf(calendarBooking.getCalendarBookingId());

		if (calendarBooking.isInTrash()) {
			calendarBookingId = TrashUtil.getOriginalTitle(calendarBookingId);
		}

		document.addKeyword("calendarBookingId", calendarBookingId);
		
		document.addText("defaultLanguageId", defaultLanguageId);
		document.addNumber("endTime", calendarBooking.getEndTime());
		document.addNumber("startTime", calendarBooking.getStartTime());
		document.addText("location", calendarBooking.getLocation());
		document.addText("groupId", String.valueOf(calendarBooking.getGroupId()));
		// added below fields for generic search; date formats are different, and dont want to remove existing fields
		document.addDate("endTime_", new Date(calendarBooking.getEndTime()));
		document.addDate("startTime_", new Date(calendarBooking.getStartTime()));
		
		Map<String, Serializable> expandoFileds = calendarBooking.getExpandoBridge().getAttributes();

		for (Map.Entry<String, Serializable> entry : expandoFileds.entrySet()) {
			int type = calendarBooking.getExpandoBridge().getAttributeType(entry.getKey());

			if (type == ExpandoColumnConstants.STRING) {
				if (_log.isDebugEnabled()) {
					_log.debug(" String type : entry.getKey() " + entry.getKey() + " : entry.getValue() : " +
							entry.getValue());
				}

				String value = (String)entry.getValue();
				document.addText(entry.getKey(), value);
			} else {
				if (_log.isDebugEnabled()) {
					_log.debug(" Not adding to indexer : entry.getKey() " + entry.getKey() + " : entry.getValue() : " +
							entry.getValue());
				}
			}
		}

		StringBuilder fileUrls = null;

		for (Map.Entry<String, List<String>> entry : CalendarUtil.getEventsImageMap(calendarBooking.getGroupId(),
				calendarBooking.getCalendarBookingId()).entrySet()) {
			for (String url : entry.getValue()) {
				if (Validator.isNull(fileUrls)) {
					fileUrls = new StringBuilder();
				} else {
					fileUrls.append(StringPool.NEW_LINE);
				}

				fileUrls.append(url);
			}
		}

		if (Validator.isNotNull(fileUrls)) {
			if (_log.isDebugEnabled()) {
				_log.debug("Adding images to document : " + fileUrls.toString());
			}

			document.addText(CalendarConstants.DOCUMENT_FILE_URLS, fileUrls.toString());
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {

		String calendarBookingId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("mvcPath", "/view_calendar_booking.jsp");
		portletURL.setParameter("calendarBookingId", calendarBookingId);

		Summary summary = createSummary(document, Field.TITLE, Field.DESCRIPTION);

		summary.setMaxContentLength(200);
		summary.setPortletURL(portletURL);

		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		CalendarBooking calendarBooking = (CalendarBooking)obj;

		int status = calendarBooking.getStatus();

		if ((status == CalendarBookingWorkflowConstants.STATUS_APPROVED) ||
			(status == CalendarBookingWorkflowConstants.STATUS_MAYBE)) {

			Document document = getDocument(calendarBooking);

			SearchEngineUtil.updateDocument(getSearchEngineId(), calendarBooking.getCompanyId(), document, true);
		} else if ((status == CalendarBookingWorkflowConstants.STATUS_DENIED)
				|| (status == CalendarBookingWorkflowConstants.STATUS_IN_TRASH)) {

			doDelete(calendarBooking);
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);

		doReindex(calendarBooking);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexCalendarBookings(companyId);
	}

	protected String[] getLanguageIds(String defaultLanguageId, String content) {

		String[] languageIds = LocalizationUtil.getAvailableLanguageIds(content);

		if (languageIds.length == 0) {
			languageIds = new String[] { defaultLanguageId };
		}

		return languageIds;
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexCalendarBookings(long companyId) throws PortalException, SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

//		ActionableDynamicQuery actionableDynamicQuery = new CalendarBookingActionableDynamicQuery() {
//
//			@Override
//			protected void addCriteria(DynamicQuery dynamicQuery) {
//				Property statusProperty = PropertyFactoryUtil.forName("status");
//
//				int[] statuses = { CalendarBookingWorkflowConstants.STATUS_APPROVED,
//						CalendarBookingWorkflowConstants.STATUS_MAYBE };
//
//				dynamicQuery.add(statusProperty.in(statuses));
//			}
//
//			@Override
//			protected void performAction(Object object) throws PortalException {
//				CalendarBooking calendarBooking = (CalendarBooking)object;
//
//				Document document = getDocument(calendarBooking);
//
//				documents.add(document);
//			}
//
//		};
		
		int[] statuses = { CalendarBookingWorkflowConstants.STATUS_APPROVED,
		CalendarBookingWorkflowConstants.STATUS_MAYBE };
		List<CalendarBooking> calendarBookings = CalendarBookingLocalServiceUtil.getCalendarBookings(statuses);

		for (CalendarBooking calendarBooking : calendarBookings) {
			Document document = getDocument(calendarBooking);
			documents.add(document);
		}

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents, true);
	}

	
	private static Log _log = LogFactoryUtil.getLog(CalendarBookingIndexer.class);

}