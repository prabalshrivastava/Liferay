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

package com.liferay.calendar.portlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.calendar.CalendarBookingDurationException;
import com.liferay.calendar.CalendarNameException;
import com.liferay.calendar.CalendarResourceCodeException;
import com.liferay.calendar.CalendarResourceNameException;
import com.liferay.calendar.DuplicateCalendarResourceException;
import com.liferay.calendar.NoSuchResourceException;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarBookingConstants;
import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarNotificationTemplateConstants;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.notification.NotificationTemplateContextFactory;
import com.liferay.calendar.notification.NotificationTemplateType;
import com.liferay.calendar.notification.NotificationType;
import com.liferay.calendar.recurrence.Frequency;
import com.liferay.calendar.recurrence.PositionalWeekday;
import com.liferay.calendar.recurrence.Recurrence;
import com.liferay.calendar.recurrence.RecurrenceSerializer;
import com.liferay.calendar.recurrence.Weekday;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarBookingServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarNotificationTemplateServiceUtil;
import com.liferay.calendar.service.CalendarResourceServiceUtil;
import com.liferay.calendar.service.CalendarServiceUtil;
import com.liferay.calendar.service.permission.CalendarPermission;
import com.liferay.calendar.util.ActionKeys;
import com.liferay.calendar.util.CalendarConstants;
import com.liferay.calendar.util.CalendarDataFormat;
import com.liferay.calendar.util.CalendarDataHandler;
import com.liferay.calendar.util.CalendarDataHandlerFactory;
import com.liferay.calendar.util.CalendarResourceUtil;
import com.liferay.calendar.util.CalendarUtil;
import com.liferay.calendar.util.JCalendarUtil;
import com.liferay.calendar.util.PortletKeys;
import com.liferay.calendar.util.RSSUtil;
import com.liferay.calendar.util.WebKeys;
import com.liferay.calendar.util.comparator.CalendarResourceNameComparator;
import com.liferay.calendar.workflow.CalendarBookingWorkflowConstants;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.comparator.UserFirstNameComparator;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 * @author Andrea Di Giorgi
 * @author Marcellus Tavares
 * @author Bruno Basto
 * @author Pier Paolo Ramon
 */
public class CalendarPortlet extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(CalendarPortlet.class);

	public void deleteCalendar(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarId = ParamUtil.getLong(actionRequest, "calendarId");

		CalendarServiceUtil.deleteCalendar(calendarId);
	}

	public void deleteCalendarResource(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarResourceId = ParamUtil.getLong(actionRequest, "calendarResourceId");

		CalendarResourceServiceUtil.deleteCalendarResource(calendarResourceId);
	}

	@Override
	public void init() throws PortletException {
		super.init();

		NotificationTemplateContextFactory.setPortletConfig(getPortletConfig());
	}

	public void invokeTransition(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarBookingId = ParamUtil.getLong(actionRequest, "calendarBookingId");

		if (Validator.isNull(calendarBookingId)) {
			String currentUrl = PortalUtil.getCurrentURL(actionRequest);
			int x = currentUrl.indexOf("view_event", 1);
			int y = currentUrl.indexOf("?", 1);

			calendarBookingId = Long.parseLong(currentUrl.substring(x + 11, y));
		}

		int status = ParamUtil.getInteger(actionRequest, "status");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(CalendarBooking.class.getName(),
				actionRequest);

		CalendarBookingServiceUtil.invokeTransition(calendarBookingId, status, serviceContext);
	}

	public void moveCalendarBookingToTrash(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarBookingId = ParamUtil.getLong(actionRequest, "calendarBookingId");

		if (Validator.isNull(calendarBookingId)) {
			if (Validator.isNotNull(actionRequest.getParameter("eventId"))) {
				calendarBookingId = Long.parseLong(actionRequest.getParameter("eventId"));
			} else {
				String currentUrl = PortalUtil.getCurrentURL(actionRequest);
				int x = currentUrl.indexOf("view_event", 1);
				int y = currentUrl.indexOf("?", 1);
				calendarBookingId = Long.parseLong(currentUrl.substring(x + 11, y));
			}
		}

		CalendarBookingServiceUtil.moveCalendarBookingToTrash(calendarBookingId);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		renderRequest.setAttribute("struts_action", "CreateEvent");
		try {
			getCalendar(renderRequest);
			getCalendarBooking(renderRequest);
			getCalendarResource(renderRequest);
		} catch (Exception e) {
			if (e instanceof NoSuchResourceException || e instanceof PrincipalException) {
				SessionErrors.add(renderRequest, e.getClass());
			} else {
				throw new PortletException(e);
			}
		}

		// }

		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		try {
			String resourceID = resourceRequest.getResourceID();
			String action = ParamUtil.getString(resourceRequest, "action");
			if ("imageUpload".equalsIgnoreCase(action)) {
				addTempFileEntry(resourceRequest, resourceResponse);
			}

			if ("calendarBookingInvitees".equals(resourceID)) {
				serveCalendarBookingInvitees(resourceRequest, resourceResponse);
			} else if ("calendarBookings".equals(resourceID)) {
				serveCalendarBookings(resourceRequest, resourceResponse);
			} else if ("calendarBookingsRSS".equals(resourceID)) {
				serveCalendarBookingsRSS(resourceRequest, resourceResponse);
			} else if ("calendarRenderingRules".equals(resourceID)) {
				serveCalendarRenderingRules(resourceRequest, resourceResponse);
			} else if ("calendarResources".equals(resourceID)) {
				serveCalendarResources(resourceRequest, resourceResponse);
			} else if ("exportCalendar".equals(resourceID)) {
				serveExportCalendar(resourceRequest, resourceResponse);
			} else if ("importCalendar".equals(resourceID)) {
				serveImportCalendar(resourceRequest, resourceResponse);
			} else if ("resourceCalendars".equals(resourceID)) {
				serveResourceCalendars(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void updateCalendar(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarId = ParamUtil.getLong(actionRequest, "calendarId");

		long calendarResourceId = ParamUtil.getLong(actionRequest, "calendarResourceId");
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(actionRequest, "name");
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
		int color = ParamUtil.getInteger(actionRequest, "color");
		boolean defaultCalendar = ParamUtil.getBoolean(actionRequest, "defaultCalendar");
		boolean enableComments = ParamUtil.getBoolean(actionRequest, "enableComments");
		boolean enableRatings = ParamUtil.getBoolean(actionRequest, "enableRatings");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Calendar.class.getName(), actionRequest);

		Calendar calendar = null;

		if (calendarId <= 0) {
			CalendarResource calendarResource = CalendarResourceServiceUtil.getCalendarResource(calendarResourceId);

			calendar = CalendarServiceUtil.addCalendar(calendarResource.getGroupId(), calendarResourceId, nameMap,
					descriptionMap, color, defaultCalendar, enableComments, enableRatings, serviceContext);
		} else {
			calendar = CalendarServiceUtil.updateCalendar(calendarId, nameMap, descriptionMap, color, defaultCalendar,
					enableComments, enableRatings, serviceContext);
		}

		String redirect = getEditCalendarURL(actionRequest, actionResponse, calendar);

		actionRequest.setAttribute(WebKeys.REDIRECT, redirect);
	}

	public void updateCalendarBooking(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarBookingId = ParamUtil.getLong(actionRequest, "calendarBookingId");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long parentFolderId = 0;
		
		long calendarId = ParamUtil.getLong(actionRequest, "calendarId");
		long[] childCalendarIds = ParamUtil.getLongValues(actionRequest, "childCalendarIds");
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(actionRequest, "title");
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
		String eventTempFolderId = ParamUtil.getString(actionRequest, "eventTempFolderId");
		String eventTempFileEntryId = ParamUtil.getString(actionRequest, "eventTempFileEntryId");
		String location = ParamUtil.getString(actionRequest, "location");
		java.util.Calendar startTimeJCalendar = getJCalendar(actionRequest, "startTime");
		java.util.Calendar endTimeJCalendar = getJCalendar(actionRequest, "endTime");
		boolean allDay = ParamUtil.getBoolean(actionRequest, "allDay");
		String recurrence = getRecurrence(actionRequest);
		long[] reminders = getReminders(actionRequest);
		String[] remindersType = getRemindersType(actionRequest);
		int status = ParamUtil.getInteger(actionRequest, "status");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(CalendarBooking.class.getName(),
				actionRequest);

		CalendarBooking calendarBooking = null;

		_log.error("parentFolderId : " + parentFolderId);
		_log.error("eventTempFileEntryId : " + eventTempFileEntryId);

		if (calendarBookingId <= 0) {
			calendarBooking = CalendarBookingServiceUtil.addCalendarBooking(calendarId, childCalendarIds,
					CalendarBookingConstants.PARENT_CALENDAR_BOOKING_ID_DEFAULT, titleMap, descriptionMap, location,
					startTimeJCalendar.getTimeInMillis(), endTimeJCalendar.getTimeInMillis(), allDay, recurrence,
					reminders[0], remindersType[0], reminders[1], remindersType[1], serviceContext);
			try {
				Folder folder1 = DLAppServiceUtil.getFolder(calendarBooking.getGroupId(), 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER);
				parentFolderId = folder1.getFolderId();
			} catch (Exception e) {
				_log.error(e.getMessage());
				_log.error("Creating new Folder");
				//PermissionUtil.initializeAdminPermissionChecker();
//				Folder folder1 = DLAppServiceUtil.addFolder(calendarBooking.getGroupId(), 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER,
//						"Folder to store Events Images",
//						ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest));
				
				ServiceContext dlFolderServiceContext = new ServiceContext();
				dlFolderServiceContext.setCompanyId(themeDisplay.getCompanyId());
				dlFolderServiceContext.setScopeGroupId(calendarBooking.getGroupId());

				String[] grpperms = { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
						ActionKeys.ADD_SUBFOLDER };
				dlFolderServiceContext.setGroupPermissions(grpperms);
				dlFolderServiceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				Folder folder1 = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(),
						calendarBooking.getGroupId(), 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER, "Folder to store Events Images based on calendar",
						dlFolderServiceContext);

				parentFolderId = folder1.getFolderId();
				//PermissionUtil.resetPermissionChecker(themeDisplay.getUser());
				_log.error("parentFolderId catch " + parentFolderId);
			}
			
			if (Validator.isNotNull(eventTempFileEntryId) && !"0".equalsIgnoreCase(eventTempFileEntryId)) {
				ServiceContext dlFolderServiceContext = new ServiceContext();
				dlFolderServiceContext.setCompanyId(themeDisplay.getCompanyId());
				dlFolderServiceContext.setScopeGroupId(calendarBooking.getGroupId());

				String[] grpperms = { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
						ActionKeys.ADD_SUBFOLDER };
				dlFolderServiceContext.setGroupPermissions(grpperms);
				dlFolderServiceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				Folder folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(),
						calendarBooking.getGroupId(), parentFolderId, CalendarConstants.CALENDAR_FOLDER
								+ calendarBooking.getCalendarBookingId(), "Folder to store individual Events Images",
						dlFolderServiceContext);
				long secFolderId = folder.getFolderId();

				ServiceContext fileEntryServiceContext = new ServiceContext();
				fileEntryServiceContext.setCompanyId(themeDisplay.getCompanyId());
				fileEntryServiceContext.setScopeGroupId(calendarBooking.getGroupId());
				String[] filegrpperms = { ActionKeys.VIEW, ActionKeys.UPDATE };
				fileEntryServiceContext.setGroupPermissions(filegrpperms);
				fileEntryServiceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
//				List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getLayout().getGroupId(),
//						Long.parseLong(eventTempFolderId));
				String[] fileEntryIdArary = eventTempFileEntryId.split(StringPool.COMMA);
				try{
				for (String fEntry : fileEntryIdArary) {
					if(!"0".equalsIgnoreCase(fEntry) && !fEntry.isEmpty() && Validator.isNotNull(fEntry)){
						DLAppServiceUtil.moveFileEntry(Long.parseLong(fEntry), secFolderId, fileEntryServiceContext);
					}	
				}
				}catch(Exception e){
					_log.error("move file enrty failed " + e.getMessage());
				}

				if (fileEntryIdArary.length > 0) {
					Indexer indexer = IndexerRegistryUtil.getIndexer(CalendarBooking.class);
					indexer.reindex(calendarBooking);
				}
			}

		} else {
			int instanceIndex = ParamUtil.getInteger(actionRequest, "instanceIndex");

			boolean updateCalendarBookingInstance = ParamUtil
					.getBoolean(actionRequest, "updateCalendarBookingInstance");

			if (updateCalendarBookingInstance) {
				calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId);

				boolean allFollowing = ParamUtil.getBoolean(actionRequest, "allFollowing");

				calendarBooking = CalendarBookingServiceUtil.updateCalendarBookingInstance(calendarBookingId,
						instanceIndex, calendarId, childCalendarIds, titleMap, descriptionMap, location,
						startTimeJCalendar.getTimeInMillis(), endTimeJCalendar.getTimeInMillis(), allDay, recurrence,
						allFollowing, reminders[0], remindersType[0], reminders[1], remindersType[1], status,
						serviceContext);
			} else {
				calendarBooking = CalendarBookingServiceUtil.getCalendarBookingInstance(calendarBookingId,
						instanceIndex);

				long duration = (endTimeJCalendar.getTimeInMillis() - startTimeJCalendar.getTimeInMillis());
				long offset = (startTimeJCalendar.getTimeInMillis() - calendarBooking.getStartTime());

				calendarBooking = CalendarBookingServiceUtil.getNewStartTimeAndDurationCalendarBooking(
						calendarBookingId, offset, duration);

				calendarBooking = CalendarBookingServiceUtil.updateCalendarBooking(calendarBookingId, calendarId,
						childCalendarIds, titleMap, descriptionMap, location, calendarBooking.getStartTime(),
						calendarBooking.getEndTime(), allDay, recurrence, reminders[0], remindersType[0], reminders[1],
						remindersType[1], status, serviceContext);
			}
			
			try {
				Folder folder1 = DLAppServiceUtil.getFolder(calendarBooking.getGroupId(), 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER);
				parentFolderId = folder1.getFolderId();
			} catch (Exception e) {
				_log.error(e.getMessage());
				_log.error("Creating new Folder");
				Folder folder1 = DLAppServiceUtil.addFolder(calendarBooking.getGroupId(), 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER,
						"Folder to store Events Images",
						ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest));
				parentFolderId = folder1.getFolderId();
				_log.error("parentFolderId " + parentFolderId);
			}
			

			if (Validator.isNotNull(eventTempFileEntryId) && !"0".equalsIgnoreCase(eventTempFileEntryId)) {
				ServiceContext dlFolderServiceContext = new ServiceContext();
				dlFolderServiceContext.setCompanyId(themeDisplay.getCompanyId());
				dlFolderServiceContext.setScopeGroupId(calendarBooking.getGroupId());

				String[] grpperms = { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
						ActionKeys.ADD_SUBFOLDER };
				dlFolderServiceContext.setGroupPermissions(grpperms);
				dlFolderServiceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });

				Folder folder = null;

				try {
					folder = DLAppServiceUtil.getFolder(calendarBooking.getGroupId(), parentFolderId,
							CalendarConstants.CALENDAR_FOLDER + calendarBooking.getCalendarBookingId());
				} catch (Exception e) {
					_log.error("Creating new Folder");

					folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), calendarBooking.getGroupId(),
							parentFolderId, CalendarConstants.CALENDAR_FOLDER + calendarBooking.getCalendarBookingId(),
							"Folder to store individual Events Images", dlFolderServiceContext);
				}
				if (folder != null) {
					long secFolderId = folder.getFolderId();
					ServiceContext fileEntryServiceContext = new ServiceContext();
					fileEntryServiceContext.setCompanyId(themeDisplay.getCompanyId());
					fileEntryServiceContext.setScopeGroupId(calendarBooking.getGroupId());
					String[] filegrpperms = { ActionKeys.VIEW, ActionKeys.UPDATE };
					fileEntryServiceContext.setGroupPermissions(filegrpperms);
					fileEntryServiceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
//					List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getLayout().getGroupId(),
//							Long.parseLong(eventTempFolderId));

					
					String[] fileEntryIdArary = eventTempFileEntryId.split(StringPool.COMMA);
					
					for (String fEntry : fileEntryIdArary) {
						try{
							if(!"0".equalsIgnoreCase(fEntry) && !fEntry.isEmpty() && Validator.isNotNull(fEntry)){
								DLAppServiceUtil.moveFileEntry(Long.parseLong(fEntry), secFolderId, fileEntryServiceContext);
							}	
						}catch(Exception e){
							_log.error("move file enrty failed " + e.getMessage());
						}
	
					}
					

					if (fileEntryIdArary.length > 0) {
						Indexer indexer = IndexerRegistryUtil.getIndexer(CalendarBooking.class);
						indexer.reindex(calendarBooking);
					}
				}
			}
		}

		actionRequest.setAttribute(WebKeys.CALENDAR_BOOKING, calendarBooking);

		String redirect = getRedirect(actionRequest, actionResponse);

		redirect = HttpUtil.setParameter(redirect, actionResponse.getNamespace() + "calendarBookingId",
				calendarBooking.getCalendarBookingId());

		actionRequest.setAttribute(WebKeys.REDIRECT, redirect);
	}

	@SuppressWarnings("unchecked")
	public void addTempFileEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws FileUploadException, IOException, PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request_ = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request_);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest);

		FileEntry tempFileEntry = null;
		boolean isDuplicate = false;
		List<FileItem> items = null;
		Folder folder = null;
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String fileEntryIds = StringPool.BLANK;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getLayout().getGroupId(), 0, "TempEventsImages");
		} catch (Exception e) {
			_log.error("Creating new Folder");
			folder = DLAppServiceUtil.addFolder(themeDisplay.getLayout().getGroupId(), 0, "TempEventsImages",
					"Folder to store Temp Events Images", serviceContext);
		}

		items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);

		if (Validator.isNotNull(items)) {
			for (FileItem item : items) {
				String name = SambaashUtil.getValidFileName(item.getName());
				try {
					tempFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getLayout().getGroupId(), folder.getFolderId(),
							name, item.getContentType(), name, "TempEventsImages", null, item.getInputStream(),
							item.getSize(), serviceContext);
					fileEntryIds = String.valueOf(tempFileEntry.getFileEntryId());
					// tempFileEntry =
					// DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),
					// folder.getFolderId(), name,"TempEventsImages" ,
					// item.getInputStream(),item.getContentType());

				} catch (DuplicateFileException dfe) {
					String newFileName = name + "_" + java.util.Calendar.getInstance().getTimeInMillis();
					tempFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getLayout().getGroupId(), folder.getFolderId(),
							newFileName, item.getContentType(), newFileName, "TempEventsImages", null,
							item.getInputStream(), item.getSize(), serviceContext);

					// tempFileEntry =
					// DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(),
					// folder.getFolderId(), newFileName,"TempEventsImages" ,
					// item.getInputStream(),item.getContentType());

				}
			}
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			dataJSONObject.put("isDuplicate", isDuplicate);

			if (tempFileEntry != null) {
				dataJSONObject.put("eventTempFolderId", tempFileEntry.getFolderId());
				dataJSONObject.put("fileEntryIds", fileEntryIds);
			} else {
				dataJSONObject.put("eventTempFolderId", 0);
				dataJSONObject.put("fileEntryIds", 0);
			}

			resourceResponse.getWriter().write(dataJSONObject.toString());
		}

	}

	public long initFolder(long companyId, long repositoryId, ServiceContext serviceContext, long eventId, User user)
			throws PortalException {

		Folder folder = null;
		long folderId = 0;

		String[] grpperms = { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER };
		serviceContext.setGroupPermissions(grpperms);
		serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
		long parentFolderId = 0;

		try {
			try {
				parentFolderId = DLAppServiceUtil.getFolder(repositoryId, 0, CalendarConstants.CALENDAR_PARENT_FOLDER)
						.getFolderId();
			} catch (Exception e) {
				if (parentFolderId == 0) {
					PermissionUtil.initializeAdminPermissionChecker();

					Folder folderParent = DLAppServiceUtil.addFolder(repositoryId, 0,
							CalendarConstants.CALENDAR_PARENT_FOLDER, StringPool.BLANK, serviceContext);

					if (folderParent.getFolderId() > 0) {
						try {
							PermissionUtil.addDefaultRoleResourcePermission(companyId, DLFolder.class.getName(),
									folderParent.getFolderId(), new String[] { ActionKeys.VIEW, ActionKeys.UPDATE,
											ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER });
							PermissionUtil.resetPermissionChecker(user);
						} catch (Exception ie) {
							_log.error("permissionutil error @@@@ " + ie.getMessage());
						}
					}

					parentFolderId = folderParent.getFolderId();
				}
			}

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, CalendarConstants.CALENDAR_FOLDER +
						String.valueOf(eventId));
			} catch (NoSuchFolderException e) {
				_log.error("DLAppServiceUtil getfolder error #### " + e.getMessage());
			}

			if (folder == null) {
				folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, CalendarConstants.CALENDAR_FOLDER
						+ String.valueOf(eventId), CalendarConstants.CALENDAR_FOLDER + String.valueOf(eventId),
						serviceContext);

				PermissionUtil.addDefaultRoleResourcePermission(companyId, DLFolder.class.getName(),
						folder.getFolderId(), new String[] { ActionKeys.VIEW, ActionKeys.UPDATE,
								ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER });
			}

			if (folder != null) {
				folderId = folder.getFolderId();
			}

		} catch (Exception e) {
			_log.error("initFolder error $$$$$ " + e.getMessage());
		}

		return folderId;
	}

	public void updateCalendarNotificationTemplate(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		long calendarNotificationTemplateId = ParamUtil.getLong(actionRequest, "calendarNotificationTemplateId");

		long calendarId = ParamUtil.getLong(actionRequest, "calendarId");
		NotificationType notificationType = NotificationType.parse(ParamUtil.getString(actionRequest,
				"notificationType"));
		NotificationTemplateType notificationTemplateType = NotificationTemplateType.parse(
				ParamUtil.getString(actionRequest, "notificationTemplateType"));
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(CalendarNotificationTemplate.class.getName(),
				actionRequest);

		if (calendarNotificationTemplateId <= 0) {
			CalendarNotificationTemplateServiceUtil.addCalendarNotificationTemplate(calendarId, notificationType,
					getNotificationTypeSettings(actionRequest, notificationType), notificationTemplateType, subject,
					body, serviceContext);
		} else {
			CalendarNotificationTemplateServiceUtil.updateCalendarNotificationTemplate(calendarNotificationTemplateId,
					getNotificationTypeSettings(actionRequest, notificationType), subject, body, serviceContext);
		}
	}

	public void updateCalendarResource(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long calendarResourceId = ParamUtil.getLong(actionRequest, "calendarResourceId");

		long defaultCalendarId = ParamUtil.getLong(actionRequest, "defaultCalendarId");
		String code = ParamUtil.getString(actionRequest, "code");
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(actionRequest, "name");
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
		boolean active = ParamUtil.getBoolean(actionRequest, "active");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(CalendarResource.class.getName(),
				actionRequest);

		if (calendarResourceId <= 0) {
			CalendarResourceServiceUtil.addCalendarResource(serviceContext.getScopeGroupId(),
					PortalUtil.getClassNameId(CalendarResource.class), 0, PortalUUIDUtil.generate(), code, nameMap,
					descriptionMap, active, serviceContext);
		} else {
			CalendarResourceServiceUtil.updateCalendarResource(calendarResourceId, nameMap, descriptionMap, active,
					serviceContext);

			if (defaultCalendarId > 0) {
				CalendarLocalServiceUtil.updateCalendar(defaultCalendarId, true);
			}
		}
	}

	public void updateDiscussion(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
			updateMessage(actionRequest);
		} else if (cmd.equals(Constants.DELETE)) {
			deleteMessage(actionRequest);
		} else if (cmd.equals(Constants.SUBSCRIBE_TO_COMMENTS)) {
			subscribeToComments(actionRequest, true);
		} else if (cmd.equals(Constants.UNSUBSCRIBE_FROM_COMMENTS)) {
			subscribeToComments(actionRequest, false);
		}
	}

	protected void addCalendarJSONObject(PortletRequest portletRequest, JSONArray jsonArray, long classNameId,
			long classPK) throws PortalException, SystemException {

		CalendarResource calendarResource = CalendarResourceUtil.getCalendarResource(portletRequest, classNameId,
				classPK);

		if (calendarResource == null) {
			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		List<Calendar> calendars = CalendarLocalServiceUtil.getCalendarResourceCalendars(calendarResource.getGroupId(),
				calendarResource.getCalendarResourceId());

		for (Calendar calendar : calendars) {
			if (!CalendarPermission.contains(permissionChecker, calendar, ActionKeys.VIEW)) {
				continue;
			}

			JSONObject jsonObject = CalendarUtil.toCalendarJSONObject(themeDisplay, calendar);

			jsonArray.put(jsonObject);
		}
	}

	protected void deleteMessage(ActionRequest actionRequest) throws Exception {
		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		String permissionClassName = ParamUtil.getString(actionRequest, "permissionClassName");
		long permissionClassPK = ParamUtil.getLong(actionRequest, "permissionClassPK");
		long permissionOwnerId = ParamUtil.getLong(actionRequest, "permissionOwnerId");

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.deleteDiscussionMessage(groupId, className, classPK, permissionClassName,
				permissionClassPK, permissionOwnerId, messageId);
	}

	@Override
	protected void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException,
			PortletException {

		if (SessionErrors.contains(renderRequest, NoSuchResourceException.class.getName())
				|| SessionErrors.contains(renderRequest, PrincipalException.class.getName())) {

			include("/error.jsp", renderRequest, renderResponse);
		} else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	protected void getCalendar(PortletRequest portletRequest) throws Exception {
		long calendarId = ParamUtil.getLong(portletRequest, "calendarId");

		if (calendarId <= 0) {
			return;
		}

		Calendar calendar = CalendarServiceUtil.getCalendar(calendarId);

		portletRequest.setAttribute(WebKeys.CALENDAR, calendar);
	}

	protected void getCalendarBooking(PortletRequest portletRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (portletRequest.getAttribute(WebKeys.CALENDAR_BOOKING) != null) {
			return;
		}

		HashMap<String, List<String>> filesMap = null;
		long calendarBookingId = ParamUtil.getLong(portletRequest, "calendarBookingId");

		if (Validator.isNull(calendarBookingId)) {
			if (Validator.isNotNull(portletRequest.getParameter("eventId"))) {
				calendarBookingId = Long.parseLong(portletRequest.getParameter("eventId"));
			}

			if (calendarBookingId <= 0) {
				String currentUrl = PortalUtil.getCurrentURL(portletRequest);

				if (currentUrl.contains("view_event")) {
					int x = currentUrl.indexOf("view_event", 1);
					int y = currentUrl.indexOf("?", 1);
					calendarBookingId = Long.parseLong(currentUrl.substring(x + 11, y));
					portletRequest.setAttribute("ViewEventDetail", "ViewEventDetail");
				}
			}
		}

		if (calendarBookingId <= 0) {
			return;
		}

		CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId);
		try {
			filesMap = CalendarUtil.getEventsImageMap(calendarBooking.getGroupId(), calendarBookingId,themeDisplay.getUser());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		portletRequest.setAttribute("Images", filesMap);
		portletRequest.setAttribute(WebKeys.CALENDAR_BOOKING, calendarBooking);
	}

	protected void getCalendarResource(PortletRequest portletRequest) throws Exception {

		long calendarResourceId = ParamUtil.getLong(portletRequest, "calendarResourceId");

		long classNameId = ParamUtil.getLong(portletRequest, "classNameId");
		long classPK = ParamUtil.getLong(portletRequest, "classPK");

		CalendarResource calendarResource = null;

		if (calendarResourceId > 0) {
			calendarResource = CalendarResourceServiceUtil.getCalendarResource(calendarResourceId);
		} else if ((classNameId > 0) && (classPK > 0)) {
			calendarResource = CalendarResourceUtil.getCalendarResource(portletRequest, classNameId, classPK);
		}

		portletRequest.setAttribute(WebKeys.CALENDAR_RESOURCE, calendarResource);
	}

	protected String getEditCalendarURL(ActionRequest actionRequest, ActionResponse actionResponse, Calendar calendar)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String editCalendarURL = getRedirect(actionRequest, actionResponse);

		if (Validator.isNull(editCalendarURL)) {
			editCalendarURL = PortalUtil.getLayoutFullURL(themeDisplay);
		}

		String namespace = actionResponse.getNamespace();

		editCalendarURL = HttpUtil.setParameter(editCalendarURL, "p_p_id", PortletKeys.CALENDAR);
		editCalendarURL = HttpUtil.setParameter(editCalendarURL, namespace + "mvcPath", templatePath +
				"edit_calendar.jsp");
		editCalendarURL = HttpUtil.setParameter(editCalendarURL, namespace + "redirect",
				getRedirect(actionRequest, actionResponse));
		editCalendarURL = HttpUtil.setParameter(editCalendarURL, namespace + "backURL",
				ParamUtil.getString(actionRequest, "backURL"));
		editCalendarURL = HttpUtil.setParameter(editCalendarURL, namespace + "calendarId", calendar.getCalendarId());

		return editCalendarURL;
	}

	protected java.util.Calendar getJCalendar(PortletRequest portletRequest, String name) {

		int month = ParamUtil.getInteger(portletRequest, name + "Month");
		int day = ParamUtil.getInteger(portletRequest, name + "Day");
		int year = ParamUtil.getInteger(portletRequest, name + "Year");
		int hour = ParamUtil.getInteger(portletRequest, name + "Hour");
		int minute = ParamUtil.getInteger(portletRequest, name + "Minute");

		int amPm = ParamUtil.getInteger(portletRequest, name + "AmPm");

		if (amPm == java.util.Calendar.PM) {
			hour += 12;
		}

		return JCalendarUtil.getJCalendar(year, month, day, hour, minute, 0, 0, getTimeZone(portletRequest));
	}

	protected String getNotificationTypeSettings(ActionRequest actionRequest, NotificationType notificationType) {

		UnicodeProperties notificationTypeSettingsProperties = new UnicodeProperties(true);

		if (notificationType == NotificationType.EMAIL) {
			String fromAddress = ParamUtil.getString(actionRequest, "fromAddress");
			String fromName = ParamUtil.getString(actionRequest, "fromName");

			notificationTypeSettingsProperties.put(CalendarNotificationTemplateConstants.PROPERTY_FROM_ADDRESS,
					fromAddress);
			notificationTypeSettingsProperties.put(CalendarNotificationTemplateConstants.PROPERTY_FROM_NAME, fromName);
		}

		return notificationTypeSettingsProperties.toString();
	}

	protected String getRecurrence(ActionRequest actionRequest) {
		boolean repeat = ParamUtil.getBoolean(actionRequest, "repeat");

		if (!repeat) {
			return null;
		}

		Recurrence recurrence = new Recurrence();

		int count = 0;

		String ends = ParamUtil.getString(actionRequest, "ends");

		if (ends.equals("after")) {
			count = ParamUtil.getInteger(actionRequest, "count");
		}

		recurrence.setCount(count);

		Frequency frequency = Frequency.parse(ParamUtil.getString(actionRequest, "frequency"));

		recurrence.setFrequency(frequency);

		int interval = ParamUtil.getInteger(actionRequest, "interval");

		recurrence.setInterval(interval);

		java.util.Calendar untilJCalendar = null;

		if (ends.equals("on")) {
			int untilDateDay = ParamUtil.getInteger(actionRequest, "untilDateDay");
			int untilDateMonth = ParamUtil.getInteger(actionRequest, "untilDateMonth");
			int untilDateYear = ParamUtil.getInteger(actionRequest, "untilDateYear");

			untilJCalendar = CalendarFactoryUtil.getCalendar();

			untilJCalendar.set(java.util.Calendar.DATE, untilDateDay);
			untilJCalendar.set(java.util.Calendar.MONTH, untilDateMonth);
			untilJCalendar.set(java.util.Calendar.YEAR, untilDateYear);
		}

		recurrence.setUntilJCalendar(untilJCalendar);

		List<PositionalWeekday> positionalWeekdays = new ArrayList<PositionalWeekday>();

		if (frequency == Frequency.WEEKLY) {
			for (Weekday weekday : Weekday.values()) {
				boolean checked = ParamUtil.getBoolean(actionRequest, weekday.getValue());

				if (checked) {
					positionalWeekdays.add(new PositionalWeekday(weekday, 0));
				}
			}
		} else if ((frequency == Frequency.MONTHLY) || (frequency == Frequency.YEARLY)) {

			boolean repeatOnWeekday = ParamUtil.getBoolean(actionRequest, "repeatOnWeekday");

			if (repeatOnWeekday) {
				int position = ParamUtil.getInteger(actionRequest, "position");

				Weekday weekday = Weekday.parse(ParamUtil.getString(actionRequest, "weekday"));

				positionalWeekdays.add(new PositionalWeekday(weekday, position));
			}
		}

		recurrence.setPositionalWeekdays(positionalWeekdays);

		String[] exceptionDates = StringUtil.split(ParamUtil.getString(actionRequest, "exceptionDates"));

		for (String exceptionDate : exceptionDates) {
			recurrence.addExceptionDate(JCalendarUtil.getJCalendar(Long.valueOf(exceptionDate)));
		}

		return RecurrenceSerializer.serialize(recurrence);
	}

	protected long[] getReminders(PortletRequest portletRequest) {
		long firstReminder = ParamUtil.getInteger(portletRequest, "reminderValue0");
		long firstReminderDuration = ParamUtil.getInteger(portletRequest, "reminderDuration0");
		long secondReminder = ParamUtil.getInteger(portletRequest, "reminderValue1");
		long secondReminderDuration = ParamUtil.getInteger(portletRequest, "reminderDuration1");

		return new long[] { firstReminder * firstReminderDuration * Time.SECOND,
				secondReminder * secondReminderDuration * Time.SECOND };
	}

	protected String[] getRemindersType(PortletRequest portletRequest) {
		String firstReminderType = ParamUtil.getString(portletRequest, "reminderType0");
		String secondReminderType = ParamUtil.getString(portletRequest, "reminderType1");

		return new String[] { firstReminderType, secondReminderType };
	}

	protected TimeZone getTimeZone(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean allDay = ParamUtil.getBoolean(portletRequest, "allDay");

		if (allDay) {
			return TimeZoneUtil.getTimeZone(StringPool.UTC);
		}

		PortletPreferences preferences = portletRequest.getPreferences();

		User user = themeDisplay.getUser();

		String timeZoneId = preferences.getValue("timeZoneId", user.getTimeZoneId());

		if (Validator.isNull(timeZoneId)) {
			timeZoneId = user.getTimeZoneId();
		}

		return TimeZone.getTimeZone(timeZoneId);
	}

	@Override
	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof CalendarBookingDurationException || cause instanceof CalendarNameException
				|| cause instanceof CalendarResourceCodeException || cause instanceof CalendarResourceNameException
				|| cause instanceof DuplicateCalendarResourceException || cause instanceof PrincipalException) {

			return true;
		}

		return false;
	}

	protected void serveCalendarBookingInvitees(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long parentCalendarBookingId = ParamUtil.getLong(resourceRequest, "parentCalendarBookingId");

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		List<CalendarBooking> childCalendarBookings = CalendarBookingServiceUtil
				.getChildCalendarBookings(parentCalendarBookingId);

		// Naresh, may 5,2016 - Changes to show user status
		// (accepted,pending,maybe)

		/*
		 * Collection<CalendarResource> calendarResources = CalendarUtil
		 * .getCalendarResources(childCalendarBookings);
		 */

		for (CalendarBooking calendarBooking : childCalendarBookings) {
			JSONObject jsonObject = CalendarUtil.toCalendarResourceJSONObject(themeDisplay,
					calendarBooking.getCalendarResource());
			String[] status = CalendarUtil.getStatusStrings(themeDisplay.getLocale(), calendarBooking.getStatus());
			jsonObject.put("status", status[0]);
			jsonObject.put("statusNoi18n", status[1]);
			jsonArray.put(jsonObject);
		}

		writeJSON(resourceRequest, resourceResponse, jsonArray);
	}

	protected void serveCalendarBookings(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long[] calendarIds = ParamUtil.getLongValues(resourceRequest, "calendarIds");
		long endTime = ParamUtil.getLong(resourceRequest, "endTime");
		long startTime = ParamUtil.getLong(resourceRequest, "startTime");
		int[] statuses = ParamUtil.getIntegerValues(resourceRequest, "statuses");

		List<CalendarBooking> calendarBookings = CalendarBookingServiceUtil.search(themeDisplay.getCompanyId(),
				new long[0], calendarIds, new long[0], -1, null, startTime, endTime, true, statuses, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);

		JSONArray jsonArray = CalendarUtil.toCalendarBookingsJSONArray(themeDisplay, calendarBookings,
				getTimeZone(resourceRequest));

		writeJSON(resourceRequest, resourceResponse, jsonArray);
	}

	protected void serveCalendarBookingsRSS(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		if (!PortalUtil.isRSSFeedsEnabled()) {
			PortalUtil.sendRSSFeedsDisabledError(resourceRequest, resourceResponse);

			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long calendarId = ParamUtil.getLong(resourceRequest, "calendarId");

		PortletPreferences portletPreferences = resourceRequest.getPreferences();

		long timeInterval = GetterUtil.getLong(portletPreferences.getValue("rssTimeInterval", StringPool.BLANK),
				RSSUtil.TIME_INTERVAL_DEFAULT);

		long startTime = System.currentTimeMillis();

		long endTime = startTime + timeInterval;

		int max = GetterUtil.getInteger(portletPreferences.getValue("rssDelta", StringPool.BLANK),
				SearchContainer.DEFAULT_DELTA);
		String rssFeedType = portletPreferences.getValue("rssFeedType", RSSUtil.FORMAT_DEFAULT);
		String type = RSSUtil.getFormatType(rssFeedType);
		double version = RSSUtil.getFeedTypeVersion(rssFeedType);
		String displayStyle = portletPreferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_DEFAULT);

		String rss = CalendarBookingServiceUtil.getCalendarBookingsRSS(calendarId, startTime, endTime, max, type,
				version, displayStyle, themeDisplay);

		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, null, rss.getBytes(),
				ContentTypes.TEXT_XML_UTF8);
	}

	protected void serveCalendarRenderingRules(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long[] calendarIds = ParamUtil.getLongValues(resourceRequest, "calendarIds");
		int[] statuses = { CalendarBookingWorkflowConstants.STATUS_APPROVED,
				CalendarBookingWorkflowConstants.STATUS_MAYBE, CalendarBookingWorkflowConstants.STATUS_PENDING };
		long startTime = ParamUtil.getLong(resourceRequest, "startTime");
		long endTime = ParamUtil.getLong(resourceRequest, "endTime");
		String ruleName = ParamUtil.getString(resourceRequest, "ruleName");

		if (calendarIds.length > 0) {
			JSONObject jsonObject = CalendarUtil.getCalendarRenderingRules(themeDisplay, calendarIds, statuses,
					startTime, endTime, ruleName, getTimeZone(resourceRequest));

			writeJSON(resourceRequest, resourceResponse, jsonObject);
		}
	}

	protected void serveCalendarResources(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String keywords = ParamUtil.getString(resourceRequest, "keywords");

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		long classNameId = PortalUtil.getClassNameId(CalendarResource.class);

		List<CalendarResource> calendarResources = CalendarResourceServiceUtil.search(themeDisplay.getCompanyId(),
				new long[] { themeDisplay.getCompanyGroupId(), themeDisplay.getScopeGroupId() },
				new long[] { classNameId }, keywords, true, true, 0, SearchContainer.DEFAULT_DELTA,
				new CalendarResourceNameComparator());

		for (CalendarResource calendarResource : calendarResources) {
			addCalendarJSONObject(resourceRequest, jsonArray, calendarResource.getClassNameId(),
					calendarResource.getClassPK());
		}

		long groupClassNameId = PortalUtil.getClassNameId(Group.class);

		List<CalendarResource> companyCalendarResources = CalendarResourceServiceUtil.search(
				themeDisplay.getCompanyId(), new long[] { themeDisplay.getCompanyGroupId() },
				new long[] { groupClassNameId }, keywords, true, true, 0, SearchContainer.DEFAULT_DELTA,
				new CalendarResourceNameComparator());

		for (CalendarResource calendarResource : companyCalendarResources) {
			addCalendarJSONObject(resourceRequest, jsonArray, calendarResource.getClassNameId(),
					calendarResource.getClassPK());
		}

		String name = StringUtil.merge(CustomSQLUtil.keywords(keywords), StringPool.BLANK);

		LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

		params.put("usersGroups", themeDisplay.getUserId());

		List<Group> groups = GroupLocalServiceUtil.search(themeDisplay.getCompanyId(), name, null, params, true, 0,
				SearchContainer.DEFAULT_DELTA);

		for (Group group : groups) {
			addCalendarJSONObject(resourceRequest, jsonArray, groupClassNameId, group.getGroupId());
		}

		long userClassNameId = PortalUtil.getClassNameId(User.class);

		List<User> users = UserLocalServiceUtil.search(themeDisplay.getCompanyId(), keywords, 0, null, 0,
				SearchContainer.DEFAULT_DELTA, new UserFirstNameComparator());

		for (User user : users) {
			addCalendarJSONObject(resourceRequest, jsonArray, userClassNameId, user.getUserId());
		}

		writeJSON(resourceRequest, resourceResponse, jsonArray);
	}

	protected void serveExportCalendar(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long calendarId = ParamUtil.getLong(resourceRequest, "calendarId");

		Calendar calendar = CalendarLocalServiceUtil.getCalendar(calendarId);

		String fileName = calendar.getName(themeDisplay.getLocale()) + CharPool.PERIOD +
				String.valueOf(CalendarDataFormat.ICAL);

		CalendarDataHandler calendarDataHandler = CalendarDataHandlerFactory
				.getCalendarDataHandler(CalendarDataFormat.ICAL);

		String data = calendarDataHandler.exportCalendar(calendarId);

		String contentType = MimeTypesUtil.getContentType(fileName);

		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, data.getBytes(), contentType);
	}

	protected void serveImportCalendar(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long calendarId = ParamUtil.getLong(uploadPortletRequest, "calendarId");

		File file = uploadPortletRequest.getFile("file");

		String data = FileUtil.read(file);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		if (Validator.isNotNull(data)) {
			try {
				CalendarDataHandler calendarDataHandler = CalendarDataHandlerFactory
						.getCalendarDataHandler(CalendarDataFormat.ICAL);

				calendarDataHandler.importCalendar(calendarId, data);

				jsonObject.put("success", true);
			} catch (Exception e) {
				String message = themeDisplay.translate("an-unexpected-error-occurred-while-importing-your-" + "file");

				jsonObject.put("error", message);
			}
		} else {
			String message = themeDisplay.translate("failed-to-import-empty-file");

			jsonObject.put("error", message);
		}

		writeJSON(resourceRequest, resourceResponse, jsonObject);
	}

	protected void serveResourceCalendars(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long calendarResourceId = ParamUtil.getLong(resourceRequest, "calendarResourceId");

		List<Calendar> calendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), null,
				new long[] { calendarResourceId }, null, true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		JSONArray jsonObject = CalendarUtil.toCalendarsJSONArray(themeDisplay, calendars);

		writeJSON(resourceRequest, resourceResponse, jsonObject);
	}

	protected void subscribeToComments(ActionRequest actionRequest, boolean subscribe) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		if (subscribe) {
			SubscriptionLocalServiceUtil.addSubscription(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					className, classPK);
		} else {
			SubscriptionLocalServiceUtil.deleteSubscription(themeDisplay.getUserId(), className, classPK);
		}
	}

	protected MBMessage updateMessage(ActionRequest actionRequest) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String className = ParamUtil.getString(actionRequest, "className");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		String permissionClassName = ParamUtil.getString(actionRequest, "permissionClassName");
		long permissionClassPK = ParamUtil.getLong(actionRequest, "permissionClassPK");
		long permissionOwnerId = ParamUtil.getLong(actionRequest, "permissionOwnerId");

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		long threadId = ParamUtil.getLong(actionRequest, "threadId");
		long parentMessageId = ParamUtil.getLong(actionRequest, "parentMessageId");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), actionRequest);

		MBMessage message = null;

		if (messageId <= 0) {
			message = MBMessageServiceUtil.addDiscussionMessage(serviceContext.getScopeGroupId(), className, classPK,
					permissionClassName, permissionClassPK, permissionOwnerId, threadId, parentMessageId, subject,
					body, serviceContext);
		} else {
			message = MBMessageServiceUtil.updateDiscussionMessage(className, classPK, permissionClassName,
					permissionClassPK, permissionOwnerId, messageId, subject, body, serviceContext);
		}

		// Subscription

		boolean subscribe = ParamUtil.getBoolean(actionRequest, "subscribe");

		if (subscribe) {
			SubscriptionLocalServiceUtil.addSubscription(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					className, classPK);
		}

		return message;
	}

}