package com.sambaash.platform.portlet.spevent.action;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.spevent.util.CalUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPEventAction
 */
public class SPEventAction extends MVCPortlet {

	private SimpleDateFormat calDate = new SimpleDateFormat("dd");
	private SimpleDateFormat calMonth = new SimpleDateFormat("MMM");
	private SimpleDateFormat coverDate = new SimpleDateFormat("MM");
	private SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
	private SimpleDateFormat formatHour = new SimpleDateFormat("HH");
	private SimpleDateFormat formatMinute = new SimpleDateFormat("mm");
	private static Log _log = LogFactoryUtil.getLog(SPEventAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		Calendar cal = Calendar.getInstance();
		HashMap<String, List<String>> filesMap = null;
		List<CalendarBooking> events = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isAdmin = false;
		isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		renderRequest.setAttribute("isAdmin", isAdmin);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		PortletPreferences preferences = renderRequest.getPreferences();
		String eventsImagesMigrated = preferences.getValue("eventsImagesMigrated", StringPool.BLANK);

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		String pageName = preferences.getValue("pageName", StringPool.BLANK);
		String groupId = String.valueOf(themeDisplay.getCompanyId());// preferences.getValue("groupId",
																		// StringPool.BLANK);
		String responsive = preferences.getValue("responsive", "false");
		String minWidth = preferences.getValue("minWidth", StringPool.BLANK);
		String liferayDetailFlag = preferences.getValue("liferaydetail", StringPool.BLANK);
		String createPage = preferences.getValue("createPage", StringPool.BLANK);
		String eventId = preferences.getValue("eventId", "0");
		String flagDetail = "";
		try {
			events = getEvents(Long.parseLong(groupId), cal, "", null, null);
			filesMap = getEventsImageMap(themeDisplay.getScopeGroupId(), events);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		if (liferayDetailFlag != null && liferayDetailFlag != "") {
			flagDetail = "true";
		} else {
			flagDetail = "false";
		}

		renderRequest.setAttribute("eventId", eventId);

		if (Validator.isNotNull(eventId)) {
			try {
				CalendarBooking event = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(eventId));
				renderRequest.setAttribute("event", event);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}

		renderRequest.setAttribute("pageName", pageName);
		renderRequest.setAttribute("responsive", responsive);
		renderRequest.setAttribute("minWidth", minWidth);
		renderRequest.setAttribute("liferaydetail", liferayDetailFlag);
		// _log.debug("from java events size " + events.size());
		renderRequest.setAttribute("events", events);
		renderRequest.setAttribute("lstEvents", "");
		renderRequest.setAttribute("Images", filesMap);
		renderRequest.setAttribute("pageno", "0");
		renderRequest.setAttribute("imagePathTheme",
				themeDisplay.getTheme().getName() + "-theme/" + themeDisplay.getTheme().getImagesPath());
		renderRequest.setAttribute("flagDetail", flagDetail);
		renderRequest.setAttribute("createPage", createPage);
		try {
			Layout previewPageLayout = LayoutLocalServiceUtil
					.getFriendlyURLLayout(themeDisplay.getScopeGroup().getGroupId(), false, "/" + createPage);

			PortletURL calEventURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(renderRequest), "8",
					previewPageLayout.getPlid(), "RENDER_PHASE");
			calEventURL.setParameter("struts_action", "CreateEvent");
			calEventURL.setParameter("redirect", PortalUtil.getCurrentURL(renderRequest));

			renderRequest.setAttribute("calEventURL", calEventURL.toString());

		} catch (Exception e) {
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String pageName = preferences.getValue("pageName", StringPool.BLANK);
			String responsive = preferences.getValue("responsive", "false");
			String minWidth = preferences.getValue("minWidth", StringPool.BLANK);
			String liferayDetailFlag = preferences.getValue("liferaydetail", StringPool.BLANK);
			String groupId = String.valueOf(themeDisplay.getCompanyId());// preferences.getValue("groupId",
																			// StringPool.BLANK);
			String createPage = preferences.getValue("createPage", StringPool.BLANK);

			List<Group> lstGroup = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());
			List<Group> resultGroup = new ArrayList<Group>();

			for (Group group : lstGroup) {
				if (group.getSite() && (group.getType() == 1) && (!group.getName().equalsIgnoreCase("guest"))) {
					resultGroup.add(group);
				}
			}

			renderRequest.setAttribute("pageName", pageName);
			renderRequest.setAttribute("groupId", groupId);
			renderRequest.setAttribute("minWidth", minWidth);
			renderRequest.setAttribute("responsive", responsive);
			renderRequest.setAttribute("liferaydetail", liferayDetailFlag);
			renderRequest.setAttribute("resultGroup", resultGroup);
			renderRequest.setAttribute("createPage", createPage);

		} catch (Exception e) {
		}

		super.doEdit(renderRequest, renderResponse);
	}

	public List<CalendarBooking> getEvents(long groupId, Calendar cal, String type, String filter, String filterTitle)
			throws SystemException {

		List<CalendarBooking> events = new ArrayList<CalendarBooking>();
		Calendar localCal = Calendar.getInstance();
		localCal.set(Calendar.MINUTE, 0);
		localCal.set(Calendar.HOUR, 0);
		localCal.set(Calendar.SECOND, 0);
		localCal.set(Calendar.MILLISECOND, 0);

		int causeFilter = 0;

		/**
		 * TODO: Migration Issue (change null to type 2nd parameter in method by
		 * Gaurav)
		 **/
		int count = CalEventLocalServiceUtil.getEventsCount(groupId, type);

		/** Till here **/
		List<CalendarBooking> eventsAll = new ArrayList<CalendarBooking>();
		List<CalendarBooking> eventsResult = new ArrayList<CalendarBooking>();
		// eventsAll = CalEventLocalServiceUtil.getEvents(groupId, type, 0,
		// count);
		boolean titleCheck = false;
		int[] statuses = { 0 };
		eventsAll = CalendarBookingLocalServiceUtil.getCalendarBookings(statuses);
		if (filterTitle != null) {
			if (!filterTitle.trim().equals("")) {
				titleCheck = true;
			}
		}
		if (filter == null || filter.equals("")) {
			causeFilter = 1;
		} else if (filter.equals("Summary")) {
			causeFilter = 1;
		} else if (filter.equals("Past Events")) {
			causeFilter = 2;
		} else if (filter.equals("Upcoming Events")) {
			causeFilter = 3;

		} else if (filter.equals("Current Events")) {
			causeFilter = 4;

		} else if (filter.equals("All Events")) {
			causeFilter = 5;
		}
		if (eventsAll != null) {

			// Iterator<CalEvent> itrLatest = eventsAll.iterator();

			Calendar currentDate = Calendar.getInstance();

			for (int i = 0; i < eventsAll.size(); i++) {
				CalendarBooking calEvent = eventsAll.get(i);

				// CalEvent calEventEndDate = SimpleDateFormat df = new
				// SimpleDateFormat(":mm");

				Calendar calEndDate = Calendar.getInstance();
				calEndDate.setTimeInMillis(calEvent.getEndTime());
				calEndDate.set(Calendar.DAY_OF_MONTH, calEndDate.get(Calendar.DAY_OF_MONTH) - 1);

				calEndDate.set(Calendar.HOUR, Integer.parseInt(formatHour.format(CalUtil.getEndTime(calEvent))) + 12);
				calEndDate.set(Calendar.MINUTE, Integer.parseInt(formatMinute.format(CalUtil.getEndTime(calEvent))));
				// _log.debug("time comparison for event " + calEvent.getTitle()
				// + " start Date "
				// + calEvent.getStartTime() + " currentDAte " +
				// currentDate.getTime() + " end Date " +
				// calEvent.getEndTime());
				switch (causeFilter) {
				case 1:
					if (calEvent.isRecurring()) {
						if (calEvent.getEndTime() > (currentDate.getTimeInMillis())) {
							if (titleCheck) {
								if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
									eventsResult.add(calEvent);
								} else {
									_log.debug("****repeating no filetr event not added startDate "
											+ calEvent.getStartTime() + " currentDate " + currentDate.getTime()
											+ "eventEnd date " + calEvent.getEndTime());
								}
							} else {
								eventsResult.add(calEvent);

								// _log.debug("###repeating no filetr events no
								// titlecheck addded startDate "
								// + calEvent.getStartDate() + " currentDate " +
								// currentDate.getTime() + "eventEnd date " +
								// calEvent.getEndDate());

							}

						} else {
							_log.debug("@@@@repeating no filetr events not addded after filter startDate "
									+ calEvent.getStartTime() + " currentDate " + currentDate.getTime()
									+ "eventEnd date " + calEvent.getEndTime());
						}
					} else {
						if (calEvent.getEndTime() > (currentDate.getTimeInMillis())) {
							if (titleCheck) {
								if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
									eventsResult.add(calEvent);
								} else {
									_log.debug("*****no filetr not repeating event not added startDate "
											+ calEvent.getStartTime() + " currentDate " + currentDate.getTime()
											+ "eventEnd date " + calEvent.getEndTime());
								}
							} else {
								eventsResult.add(calEvent);

								// _log.debug("####no filetr not repeating no
								// title check event added startDate "
								// + calEvent.getStartDate() + " currentDate " +
								// currentDate.getTime() + "eventEnd date " +
								// calEvent.getEndDate());

							}

						} else {
							_log.debug("%%%%not repeating no filetr events not addded after filter startDate "
									+ calEvent.getStartTime() + " currentDate " + currentDate.getTime()
									+ "eventEnd date " + calEvent.getEndTime());
						}
					}

					break;
				case 2:
					if (calEvent.isRecurring()) {
						if (calEndDate.getTimeInMillis() < (currentDate.getTimeInMillis())) {
							if (titleCheck) {
								if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
									eventsResult.add(calEvent);
									_log.debug("Past Events Repeating event addded calEndDate.getTime() "
											+ calEndDate.getTime() + " currentDate.getTime() " + currentDate.getTime());
								} else {
									_log.error("****Past Events Repeating event not added calEndDate.getTime() "
											+ calEndDate.getTime() + " currentDate.getTime() " + currentDate.getTime());
								}
							} else {
								eventsResult.add(calEvent);
								_log.error(
										"####Past Events repeating title check failed Repeating calEndDate.getTime() "
												+ calEndDate.getTime() + " currentDate.getTime() "
												+ currentDate.getTime());
							}
						}
					} else {
						if (calEvent.getEndTime() < (currentDate.getTimeInMillis())) {
							if (titleCheck) {
								if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
									eventsResult.add(calEvent);
									_log.error("Past Events not repeating events added CalUtil.getEndTime(calEvent) "
											+ CalUtil.getEndTime(calEvent) + " currentDate.getTime() "
											+ currentDate.getTime());
								} else {
									_log.error(
											"***Past Events not repeating events not added CalUtil.getEndTime(calEvent) "
													+ CalUtil.getEndTime(calEvent) + " currentDate.getTime() "
													+ currentDate.getTime());
								}
							} else {
								eventsResult.add(calEvent);
								_log.error(
										"###Past Events not repeating title check failed CalUtil.getEndTime(calEvent) "
												+ CalUtil.getEndTime(calEvent) + " currentDate.getTime() "
												+ currentDate.getTime());
							}
						}
					}

					break;
				case 3:
					_log.debug("upcoming Events calEvent.getStartDate() " + calEvent.getStartTime()
							+ " currentDate.getTime() " + currentDate.getTime());

					if (calEvent.getStartTime() > (currentDate.getTimeInMillis())) {
						if (titleCheck) {
							if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
								eventsResult.add(calEvent);
							}
						} else {
							eventsResult.add(calEvent);
						}
					}

					break;

				case 4:
					if (calEvent.isRecurring()) {
						if (((calEvent.getStartTime() < (currentDate.getTimeInMillis())
								|| calEvent.getStartTime() == (currentDate.getTimeInMillis()))
								&& calEvent.getEndTime() > (currentDate.getTimeInMillis()))) {
							if (titleCheck) {
								if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
									eventsResult.add(calEvent);
									_log.debug("Current Events repeating added calEvent.getStartDate()"
											+ calEvent.getStartTime() + " currentDate.getTime() "
											+ currentDate.getTime() + " calEndDate.getTime() " + calEndDate.getTime());
								} else {
									_log.debug("****Current Events repeating not added calEvent.getStartDate()"
											+ calEvent.getStartTime() + " currentDate.getTime() "
											+ currentDate.getTime() + " calEndDate.getTime() " + calEndDate.getTime());
								}
							} else {
								eventsResult.add(calEvent);
								_log.error(
										"#### isRecurring Current Events repeating title chk failed calEvent.getStartDate()"
												+ calEvent.getTitle() + "++++++++++" + calEvent.getStartTime()
												+ " currentDate.getTime() " + currentDate.getTime()
												+ " calEndDate.getTime() " + calEndDate.getTime());
							}
						} else {
							_log.error(
									"@@@@ isRecurring Current Events repeating not added filter failed calEvent.getStartDate()"
											+ calEvent.getTitle() + "++++++++++" + calEvent.getStartTime()
											+ " currentDate.getTime() " + currentDate.getTime()
											+ " calEndDate.getTime() " + calEndDate.getTime());
						}
					} else {
						if (calEvent.getStartTime() < currentDate.getTimeInMillis()
								&& calEvent.getEndTime() > currentDate.getTimeInMillis()) {
							if (titleCheck) {
								if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
									eventsResult.add(calEvent);
									_log.debug("Current Events not repeating added calEvent.getStartTime()"
											+ calEvent.getTitle() + "++++++++++" + calEvent.getStartTime()
											+ " currentDate.getTime() " + currentDate.getTimeInMillis()
											+ " calEndDate.getTime() " + calEvent.getEndTime());
								} else {
									_log.error("****Current Events not repeating not added calEvent.getStartTime()"
											+ calEvent.getTitle() + "++++++++++" + calEvent.getStartTime()
											+ " currentDate.getTime() " + currentDate.getTimeInMillis()
											+ " calEndDate.getTime() " + calEvent.getEndTime());
								}
							} else {
								eventsResult.add(calEvent);
								_log.error("###Current Events title not repeating check failed calEvent.getStartTime()"
										+ calEvent.getTitle() + "++++++++++" + calEvent.getStartTime()
										+ " currentDate.getTime() " + currentDate.getTimeInMillis()
										+ " calEndDate.getTime() " + calEvent.getEndTime());
							}
						} else {
							_log.debug("%%%Current Events not added filter failed calEvent.getStartTime()"
									+ calEvent.getTitle() + "++++++++++" + calEvent.getStartTime()
									+ " currentDate.getTime() " + currentDate.getTimeInMillis()
									+ " calEndDate.getTime() " + calEvent.getEndTime());
						}
					}

					break;
				case 5:
					if (titleCheck) {
						if (calEvent.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
							eventsResult.add(calEvent);
						}
					} else {
						eventsResult.add(calEvent);
					}

					break;

				default:
					_log.debug("upcoming Events calEndDate.getTime() " + calEndDate.getTime()
							+ " currentDate.getTime() " + currentDate.getTime());

					if (calEndDate.getTime().after(currentDate.getTime())) {
						eventsResult.add(calEvent);
					}

					break;
				}

			}

			events.addAll(eventsResult);

			// Collections.sort(events, new EventsCreateDateComparator());

		}

		return events;
	}

	private HashMap<String, List<String>> getEventsImageMap(long respositoryId, List<CalendarBooking> events) {
		HashMap<String, List<String>> eventImageFiles = new HashMap<String, List<String>>();
		long parentFolderId = 0;
		List<String> imageUrl = null;
		for (CalendarBooking cal : events) {
		try {
			Folder folder = DLAppServiceUtil.getFolder(cal.getGroupId(), 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER);

			if (folder != null) {
				parentFolderId = folder.getFolderId();
				_log.debug("parentFolderId " + parentFolderId + "respositoryId " + cal.getGroupId());
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		
			imageUrl = new ArrayList<String>();
			try {
				Folder subFolder = DLAppServiceUtil.getFolder(cal.getGroupId(), parentFolderId,
						"Events_" + cal.getCalendarBookingId());

				List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(cal.getGroupId(), subFolder.getFolderId());

				for (FileEntry file : fileEntries) {
					imageUrl.add("/documents/" + respositoryId + "/" + subFolder.getFolderId() + "/" + file.getTitle());
				}
				_log.debug("eventId cal " + cal.getCalendarBookingId() +  " imageUrl " + imageUrl);
				eventImageFiles.put(String.valueOf(cal.getCalendarBookingId()), imageUrl);

			} catch (Exception e) {
				_log.error(e.getMessage());
			}

		}

		return eventImageFiles;
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		try {
			String action = actionRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();
				String pageName = actionRequest.getParameter("pageName");
				String responsive = actionRequest.getParameter("responsive");
				String minWidth = actionRequest.getParameter("minWidth");
				String liferayDetailFlag = actionRequest.getParameter("liferaydetail");
				String groupId = actionRequest.getParameter("groupId");
				String createPage = actionRequest.getParameter("createPage");
				preferences.setValue("liferaydetail", liferayDetailFlag);
				preferences.setValue("pageName", pageName);
				preferences.setValue("responsive", responsive);
				preferences.setValue("minWidth", minWidth);
				preferences.setValue("groupId", groupId);
				preferences.setValue("createPage", createPage);

				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			}
			if ("eventDetail".equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();
				String eventId = actionRequest.getParameter("currentEventId");
				String detailPageName = preferences.getValue("pageName", "");
				String flagDetail = preferences.getValue("liferaydetail", "false");
				preferences.setValue("eventId", eventId);

				preferences.store();
				actionRequest.setAttribute("eventId", eventId);
				// actionResponse.setRenderParameter("jspPage",
				// "/html/spevent/view.jsp");
				// actionResponse.setRenderParameter("eventId",eventId);
				actionResponse.sendRedirect(
						"/" + detailPageName + "/-/event/view_event/" + eventId + "?flagDetail=" + flagDetail);

			} else {
				String calId = ParamUtil.getString(actionRequest, "calId");
				actionRequest.setAttribute("calId", calId);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String clientWidth = resourceRequest.getParameter("clientWidth");
		String CMD = resourceRequest.getParameter("CMD");
		String dataString = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String rightImages = themeDisplay.getPathThemeImages() + "/common/right.png";
		String leftImages = themeDisplay.getPathThemeImages() + "/common/leftarrow.png";

		if ("fetchLstEvents".equalsIgnoreCase(CMD)) {
			String monthIndex = resourceRequest.getParameter("monthIndex");
			String filter = resourceRequest.getParameter("filter");
			String filterTitle = resourceRequest.getParameter("filterTitle");

			if ("undefined".equals(monthIndex)) {
				monthIndex = "0";
			}

			dataString = fetchLstEvents(resourceRequest, resourceResponse, clientWidth, monthIndex, rightImages,
					leftImages, filter, filterTitle);

		} else if ("readMore".equalsIgnoreCase(CMD)) {
			String eventId = resourceRequest.getParameter("eventId");
			dataString = readMore(eventId, resourceRequest, resourceResponse, clientWidth, rightImages, leftImages);

		} else if ("fetchLstEventsByType".equalsIgnoreCase(CMD)) {
			String filter = resourceRequest.getParameter("filter");
			String filterTitle = resourceRequest.getParameter("filterTitle");
			dataString = fetchLstEvents(resourceRequest, resourceResponse, clientWidth, "0", rightImages, leftImages,
					filter, filterTitle);
		} else {
			String filter = resourceRequest.getParameter("filter");
			String filterTitle = resourceRequest.getParameter("filterTitle");
			dataString = shiftEvent(resourceRequest, resourceResponse, clientWidth, rightImages, leftImages, filter,
					filterTitle);
		}

		resourceResponse.getWriter().write(dataString);
	}

	private String shiftEvent(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String clientWidth,
			String rightImages, String leftImages, String filter, String filterTitle) {

		String currentMonth = resourceRequest.getParameter("currentMonth");
		String currentYear = resourceRequest.getParameter("currentYear");
		String flag = resourceRequest.getParameter("flag");
		String pageno = resourceRequest.getParameter("pageno");
		Calendar cal = Calendar.getInstance();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		StringBuffer sb = new StringBuffer();
		HashMap<String, List<String>> imageMaps = new HashMap<String, List<String>>();

		PortletPreferences preferences = resourceRequest.getPreferences();
		String responsive = preferences.getValue("responsive", "false");
		String minWidth = preferences.getValue("minWidth", StringPool.BLANK);
		int colCount = (Integer.parseInt(clientWidth) / (Integer.parseInt(minWidth)));
		int marginleft = ((Integer.parseInt(clientWidth) - (Integer.parseInt(minWidth) * colCount)) / 2) - 24;
		int width = Integer.parseInt(minWidth) * colCount;

		if (width > 1200 && colCount == 4) {
			width = 1230;
		}

		if (marginleft < 0 && (colCount <= 2)) {
			colCount = 1;
			width = Integer.parseInt(minWidth) + 50;
			marginleft = ((Integer.parseInt(clientWidth) - width) / 2);

		} else {
			if (width == Integer.parseInt(minWidth)) {
				colCount = 1;
				width = Integer.parseInt(minWidth) + 50;

				if (marginleft < 100 && colCount == 1) {
					if (marginleft > 59) {
						marginleft = marginleft - 50;
					}

				}

			}
		}

		if (responsive == null) {
			colCount = 3;
			width = 930;
		}

		int startIndex = 0;
		try {
			List<CalendarBooking> calEventLst = getEvents(themeDisplay.getScopeGroupId(), cal, "", filter, filterTitle);
			imageMaps = getEventsImageMap(themeDisplay.getScopeGroupId(), calEventLst);
			List<CalendarBooking> calByMonths = new ArrayList<CalendarBooking>();

			for (CalendarBooking calevent : calEventLst) {
				if (Integer.parseInt(coverDate.format(calevent.getStartTime())) == Integer.parseInt(currentMonth)) {
					calByMonths.add(calevent);
				}
			}

			// Collections.sort(calByMonths, new EventsCreateDateComparator());

			if (flag.endsWith("right")) {
				startIndex = Integer.parseInt(pageno) + 1;
				int nextpage = Integer.parseInt(pageno) + 1;
				sb.append("<div id='divMonthLeft" + currentMonth + "' class='event-arrow'>"
						+ "<a href='#' onclick=\"preventDefault(event);newRequest('" + currentMonth + "','"
						+ currentYear + "','left','" + nextpage + "');\" ><img alt=\"Next\" src='" + leftImages + "' /></a></div> ");
				int total = 0;
				while (total <= colCount - 1) {
					String url = "";
					List<String> allImages = null;
					try {
						allImages = imageMaps.get(String.valueOf(calByMonths.get(startIndex).getCalendarBookingId()));
						if (allImages.size() > 0) {
							url = allImages.get(allImages.size()-1);
						} else {
							url = themeDisplay.getPathThemeImages() + "/common/defaultEvent.png";
						}
					} catch (Exception e) {
						_log.error("exception " + e.getMessage());
					}
					sb.append("<div id='" + calByMonths.get(startIndex).getCalendarBookingId()
							+ "' class='event-box overflow-hidden inline-block width-25 font-std align-top box-sizing-border padding-quarter'>");
					
					sb.append("<div class='infobox-event overflow-hidden full-width relative'><figure class='event-list-thumb relative full-width padding-none margin-none'> <img alt='Event Image' class='daily-event block full-width' src='"
							+ url + "?imageThumbnail=3'/> </figure>");

					sb.append(
							"<div class='more absolute padding-quarter box-sizing-border full-width full-height '> <div class='table full-width full-height text-center align-middle'> "
									+ "<a class='link full-width full-height relative table-cell align-middle font-14 light font-up' href='#' onclick='loadEventDetail("
									+ calByMonths.get(startIndex).getCalendarBookingId() + ");' >Read More &gt;");
					sb.append("</a> </div> </div> </div> ");

					sb.append(
							"<table class='event-box-head table full-width overflow-hidden'> <tr> <td class='table-cell div-cal width-25 theme-bg-3 text-left padding-quarter box-sizing-border "
									+ calMonth.format(calByMonths.get(startIndex).getStartTime())
									+ "'><div class='event-box-date-text block text-center'><span class='event-box-date-month block font-10 white font-up '>"
									+ calMonth.format(calByMonths.get(startIndex).getStartTime())
									+ "</span><span class='event-box-date-day block font-16 bold white '>"
									+ calDate.format(calByMonths.get(startIndex).getStartTime()));
					sb.append("</span></div></td>");

					String xmlContent = calByMonths.get(startIndex).getTitle().trim();
					String eventTitle = StringPool.BLANK;
					if (xmlContent.contains("</Title>")) {
						com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);
						if (Validator.isNotNull(document.selectSingleNode("/root/Title"))) {
							eventTitle = document.selectSingleNode("/root/Title").getText();
						}
					} else {
						eventTitle = xmlContent;
					}

					if (eventTitle.length() < 39) {
						sb.append(
								"<td class='table-cell div-title width-75 padding-quarter box-sizing-border lt-50 '><span class='font-14'>"
										+ eventTitle);
					} else {
						sb.append(
								"<td class='table-cell div-title width-75 padding-quarter box-sizing-border gt-50 '><span class='font-14'>"
										+ eventTitle.substring(0, 38) + "...");
					}

					sb.append("</span></td> </tr> </table>");
					sb.append("</div>");
					total++;
					startIndex++;

				}

				int next = Integer.parseInt(pageno) + 1;

				if ((startIndex) != calByMonths.size()) {
					sb.append("<div id='divMonthLeft" + currentMonth + "' class='event-arrow'>"
							+ "<a href='#' onclick=\"preventDefault(event);newRequest('" + currentMonth + "','"
							+ currentYear + "','right','" + next + "');\" ><img alt=\"Next\" src='" + rightImages
							+ "' /></a></div> ");
				}

			} else {
				int previous = Integer.parseInt(pageno) - 1;
				int total = 0;
				startIndex = Integer.parseInt(pageno) - 1;

				if (previous != 0) {
					sb.append("<div id='divMonthLeft" + currentMonth + "' class='event-arrow'>"
							+ "<a href='#' onclick=\"preventDefault(event);newRequest('" + currentMonth + "','"
							+ currentYear + "','left','" + startIndex + "');\" ><img alt=\"Next\" src='" + leftImages
							+ "' /></a></div> ");
				} else {
					sb.append("<div id='divMonthLeft" + currentMonth + "' class='event-arrow'>"
							+ "<a style='visibility:hidden;' href='#' onclick=\"preventDefault(event);newRequest('"
							+ currentMonth + "','" + currentYear + "','left','" + startIndex + "');\" ><img alt=\"Next\" src='"
							+ leftImages + "' /></a></div> ");

				}
				while (total <= colCount - 1) {
					String url = "";
					List<String> allImages = null;
					try {
						allImages = imageMaps.get(String.valueOf(calByMonths.get(startIndex).getCalendarBookingId()));

						if (allImages.size() > 0) {
							url = allImages.get(0);
						}else {
							url = themeDisplay.getPathThemeImages() + "/common/defaultEvent.png";
						}
					} catch (Exception e) {

					}

					sb.append("<div id='"
							+ calByMonths.get(startIndex).getCalendarBookingId()
							+ "' class='event-box overflow-hidden inline-block width-25 font-std align-top box-sizing-border padding-quarter'>");

					sb.append(
							"<div class='infobox-event overflow-hidden full-width relative'><figure class='event-list-thumb relative full-width padding-none margin-none'> <img alt='Event Image' class='daily-event block full-width' src='"
									+ url + "?imageThumbnail=3'/> </figure>");

					sb.append(
							"<div class='more absolute padding-quarter box-sizing-border full-width full-height '> <div class='table full-width full-height text-center align-middle'> "
									+ "<a class='link full-width full-height relative table-cell align-middle font-14 light font-up' href='#' onclick='loadEventDetail("
									+ calByMonths.get(startIndex).getCalendarBookingId() + ");' >Read More &gt;");
					sb.append("</a> </div> </div> </div> ");

					sb.append(
							"<table class='event-box-head table full-width  overflow-hidden'> <tr> <td class='table-cell div-cal width-25 theme-bg-3 text-left padding-quarter box-sizing-border "
									+ calMonth.format(calByMonths.get(startIndex).getStartTime())
									+ "'><div class='event-box-date-text block text-center'><span class='event-box-date-month block font-10 white font-up '>"
									+ calMonth.format(calByMonths.get(startIndex).getStartTime())
									+ "</span><span class='event-box-date-day block font-16 bold white '>"
									+ calDate.format(calByMonths.get(startIndex).getStartTime()));
					sb.append("</span></div></td>");

					String xmlContent = calByMonths.get(startIndex).getTitle().trim();
					String eventTitle = StringPool.BLANK;
					if (xmlContent.contains("</Title>")) {
						com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);
						if (Validator.isNotNull(document.selectSingleNode("/root/Title"))) {
							eventTitle = document.selectSingleNode("/root/Title").getText();
						}
					} else {
						eventTitle = xmlContent;
					}

					if (eventTitle.length() < 39) {
						sb.append(
								"<td class='table-cell div-title width-75 padding-quarter box-sizing-border lt-50 '><span class='font-14'>"
										+ eventTitle);
					} else {
						sb.append(
								"<td class='table-cell div-title width-75 padding-quarter box-sizing-border gt-50 '><span class='font-14'>"
										+ eventTitle.substring(0, 38) + "...");
					}

					sb.append("</span></td> </tr> </table>");
					sb.append("</div>");
					total++;
					startIndex++;
				}

				sb.append("<div id='divMonthLeft" + currentMonth + "' class='event-arrow'>"
						+ "<a href='#' onclick=\"preventDefault(event);newRequest('" + currentMonth + "','"
						+ currentYear + "','right','" + previous + "');\" ><img alt=\"Next\" src='" + rightImages
						+ "' /></a></div> ");

			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return sb.toString();
	}

	private String fetchLstEvents(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			String clientWidth, String monthIndex, String rightImages, String leftImages, String filter,
			String filterTitle) {
		StringBuffer sb = new StringBuffer();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Calendar cal = Calendar.getInstance();
		List<CalendarBooking> events = null;
		HashMap<String, List<String>> imageMaps = new HashMap<String, List<String>>();

		PortletPreferences preferences = resourceRequest.getPreferences();
		String responsive = preferences.getValue("responsive", "false");
		String minWidth = preferences.getValue("minWidth", StringPool.BLANK);

		int colCount = (Integer.parseInt(clientWidth) / (Integer.parseInt(minWidth)));
		int marginleft = ((Integer.parseInt(clientWidth) - (Integer.parseInt(minWidth) * colCount)) / 2) - 24;
		int width = Integer.parseInt(minWidth) * colCount;
		int divmargin = 0;
		int totalMonthCount = 1;
		int monthInd = Integer.parseInt(monthIndex) + 3;
		boolean loadmore = false;

		if (Integer.parseInt(clientWidth) < 400) {
			divmargin = 3;
		} else {
			divmargin = 10;
		}

		if (width > 1200 && colCount == 4) {
			width = 1230;
		} else {
			width += 20;
		}

		if (marginleft < 0 && (colCount <= 2)) {
			colCount = 1;
			width = Integer.parseInt(minWidth) + 50;
			marginleft = ((Integer.parseInt(clientWidth) - Integer.parseInt(minWidth)) / 2);

		} else {
			if (width == Integer.parseInt(minWidth)) {
				colCount = 1;
				width = Integer.parseInt(minWidth) + 50;

				if (marginleft < 100 && colCount == 1) {
					if (marginleft > 59) {
						marginleft = marginleft - 50;
					}

				}

			}
		}

		if (marginleft > 100 && colCount == 1) {
			if (marginleft > 60) {
				marginleft = marginleft - 55;
			}

		}

		if (responsive == null) {
			colCount = 3;
			width = 930;
			marginleft = 0;
		}

		sb.append("<div class='event_wrap block full-width'>");

		try {
			events = getEvents(themeDisplay.getScopeGroupId(), cal, "", filter, filterTitle);

			imageMaps = getEventsImageMap(themeDisplay.getScopeGroupId(), events);
			int indexMonth = 0;
			int monthCount = 0;
			int indexYear = 0;

			for (CalendarBooking indexCal : events) {
				indexMonth = Integer.parseInt(coverDate.format(indexCal.getStartTime()));
				indexYear = Integer.parseInt(formatYear.format(indexCal.getStartTime()));
				break;
			}

			for (CalendarBooking calEvent : events) {
				int currentMonth = Integer.parseInt(coverDate.format(calEvent.getStartTime()));
				int currentYear = Integer.parseInt(formatYear.format(calEvent.getStartTime()));

				if ((indexMonth != currentMonth) || (currentYear != indexYear)) {
					sb.append("</div>");
					monthCount = 0;
					indexMonth = Integer.parseInt(coverDate.format(calEvent.getStartTime()));
					indexYear = Integer.parseInt(formatYear.format(calEvent.getStartTime()));
					totalMonthCount++;

					if (totalMonthCount > monthInd) {
						loadmore = true;
						break;
					}

				}

				if (monthCount < colCount
						&& indexMonth == Integer.parseInt(coverDate.format(calEvent.getStartTime()))) {
					if (monthCount == 0) {

						sb.append(
								"<div class='div-month-title block '><span class='font-up month-title font-14 theme-color "
										+ calMonth.format(calEvent.getStartTime()) + "'>"
										+ calMonth.format(calEvent.getStartTime()) + " /  "
										+ formatYear.format(calEvent.getStartTime()) + "</span></div>");
						sb.append("<div id='main-" + Integer.parseInt(coverDate.format(calEvent.getStartTime())) + "-"
								+ Integer.parseInt(formatYear.format(calEvent.getStartTime()))
								+ "' class='events_list_wrap block full-width font-none relative padding-bottom-half '> ");
						sb.append("<div id='divMonthLeft" + currentMonth + "' class='event-arrow'>"
								+ "<a style='visibility:hidden;' href='#' onclick=\"preventDefault(event);newRequest('"
								+ currentMonth + "','" + currentYear + "','left','" + "0" + "');\" ><img alt=\"Next\" src='"
								+ leftImages + "' /></a></div> ");

					}

					List<String> allImages = new ArrayList<String>();

					allImages = imageMaps.get(String.valueOf(calEvent.getCalendarBookingId()));

					String url = "";

					if (allImages != null) {
						if (allImages.size() > 0) {
							url = allImages.get(allImages.size()-1);
						} else {
							url = themeDisplay.getPathThemeImages() + "/common/defaultEvent.png";
						}
					} else {
						url = themeDisplay.getPathThemeImages() + "/common/defaultEvent.png";
					}
					sb.append("<div id='" + calEvent.getCalendarBookingId()
							+ "' class='event-box overflow-hidden inline-block width-25 font-std align-top box-sizing-border padding-quarter '>");

					sb.append(
							"<div class='infobox-event overflow-hidden full-width relative'> <figure class='event-list-thumb relative full-width padding-none margin-none'> <img alt='Event Image' class='daily-event block full-width' src='"
									+ url + "?version=1.0&imageThumbnail=3'> </figure>");
					sb.append(
							"<div class='more absolute padding-quarter box-sizing-border full-width full-height '> <div class='table full-width full-height text-center align-middle'><a class='link full-width full-height relative table-cell align-middle font-14 light font-up' onclick='loadEventDetail("
									+ calEvent.getCalendarBookingId() + ");' href='#'>Read More &gt;");
					sb.append("</a> </div> </div> </div> ");

					sb.append(
							"<table class='event-box-head table full-width overflow-hidden'> <tr> <td class='table-cell div-cal width-25 theme-bg-3 text-left padding-quarter box-sizing-border "
									+ calMonth.format(calEvent.getStartTime())
									+ "'><div class='event-box-date-text block text-center'><span class='event-box-date-month block font-10 white font-up '>"
									+ calMonth.format(calEvent.getStartTime())
									+ "</span><span class='event-box-date-day block font-16 bold white '>"
									+ calDate.format(calEvent.getStartTime()));
					sb.append("</span></div></td>");

					String xmlContent = calEvent.getTitle().trim();

					String eventTitle = StringPool.BLANK;
					if (xmlContent.contains("</Title>")) {
						com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);
						if (Validator.isNotNull(document.selectSingleNode("/root/Title"))) {
							eventTitle = document.selectSingleNode("/root/Title").getText();
						}
					} else {
						eventTitle = xmlContent;
					}

					if (eventTitle.length() < 39) {
						sb.append(
								"<td class='table-cell div-title width-75 padding-quarter box-sizing-border lt-50 '><span class='font-14'>"
										+ eventTitle);
					} else {
						sb.append(
								"<td class='table-cell div-title width-75 padding-quarter box-sizing-border gt-50 '><span class='font-14'>"
										+ eventTitle.substring(0, 38) + "...");
					}

					sb.append("</span></td> </tr> </table>");

					sb.append("</div>");
					if (indexMonth == Integer.parseInt(coverDate.format(calEvent.getStartTime()))) {
						monthCount++;

					}

				} else {

					if (monthCount == colCount) {
						sb.append("<div id='divMonth" + Integer.parseInt(coverDate.format(calEvent.getStartTime()))
								+ "' class='event-arrow'>" + "<a href='#' onclick=\"preventDefault(event); newRequest('"
								+ Integer.parseInt(coverDate.format(calEvent.getStartTime())) + "','"
								+ Integer.parseInt(formatYear.format(calEvent.getStartTime()))
								+ "','right','0');\" ><img alt=\"Next\" src='" + rightImages + "' /></a></div> ");
					}

					monthCount++;
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		sb.append("</div>");

		if (loadmore) {
			sb.append(
					"<div class='sp-event-loadmorediv '><a class='sp-event-loadmore bar-link btn-bar' onclick='fetchEvents("
							+ clientWidth + "," + (Integer.parseInt(monthIndex) + 1) + ");'>Load More</a></div>");
		}

		return sb.toString();
	}

	private String readMore(String eventId, ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			String clientWidth, String rightImages, String leftImages) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		StringBuffer sb = new StringBuffer();
		CalendarBooking event = null;
		List<String> lstFiles = null;
		try {
			event = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(eventId));
			HashMap<String, List<String>> fileEntries = getEventsImageMap(event.getGroupId(),
					Long.parseLong(eventId));
			lstFiles = fileEntries.get(eventId);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		
		sb.append("<div class='event-detail-left inline-block align-top width-55'>");

		

		if (lstFiles != null && lstFiles.size() != 0) {
			int countFile = 1;
			sb.append("<div id='images'>");

			for (String url : lstFiles) {
				if (countFile == lstFiles.size()) {
					sb.append("<img alt='After' id='image" + countFile + "' src='" + url
							+ "?version=1.0&imageThumbnail=4' class='full-width aftermove'/>");

				} else {
					sb.append("<img alt='Before' id='image" + countFile + "' src='" + url
							+ "?version=1.0&imageThumbnail=4' class='full-width beforemove'/>");

				}

				countFile++;
			}

			countFile = 1;
			sb.append("</div><div id='sliderevent' class='hide'>");
			for (String url : lstFiles) {
				sb.append("<a href='#' onclick='changeImage(" + countFile + "," + lstFiles.size() + ")'><img alt='Image' src='"
						+ url + "'/></a>");
				countFile++;
			}

			sb.append("</div>");
		} else {
			sb.append("<div class='defaultImage full-width full-height align-middle'>");
			sb.append("<figure class='table-cell full-width full-height align-middle text-center'> <img alt='Default Image' src= '"
					+ themeDisplay.getPathThemeImages() + "/common/defaultEvent.png"
					+ "' class='emptyimage-eventdetail full-width'/></figure></div>");
		}

		sb.append("</div>");

		sb.append("<div id='event-detail-right' class='event-detail-right inline-block align-top width-45'>");

		sb.append("<table class='table full-width full-height font-std'>");
		sb.append(
				"<tr><td class='event-detail-rightRow1 table-cell padding-half box-sizing-border border-bottom'><span class='event-detail-icon icon-title inline-block line-none align-middle padding-none inline-block box-sizing-border width-5'><img class='full-width' src='"
						+ themeDisplay.getPathThemeImages() + "/calendar/title.png'/></span>");

		PortletPreferences preferences = resourceRequest.getPreferences();
		String createPage = preferences.getValue("createPage", StringPool.BLANK);

		String xmlContent = event.getTitle().trim();

		String eventTitle = StringPool.BLANK;
		try {
			if (xmlContent.contains("</Title>")) {
				com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);
				if (Validator.isNotNull(document.selectSingleNode("/root/Title"))) {
					eventTitle = document.selectSingleNode("/root/Title").getText();
				}
			} else {
				eventTitle = xmlContent;
			}
		} catch (DocumentException e1) {
			_log.error(e1.getMessage());
		}

		if (eventTitle.length() < 50) {
			sb.append(
					"<span class='event-detail-title inline-block align-middle padding-right-quarter box-sizing-border width-90'><h2 class='h2'>"
							+ eventTitle + "</h2></span>");
		} else {
			sb.append(
					"<span class='event-detail-title inline-block align-middle padding-right-quarter box-sizing-border width-90'><h2 class='h2'>"
							+ eventTitle.substring(0, 49) + "... </h2></span>");
		}

		try {
			Layout previewPageLayout = LayoutLocalServiceUtil
					.getFriendlyURLLayout(themeDisplay.getScopeGroup().getGroupId(), false, "/" + createPage);

			PortletURL calEventURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(resourceRequest),
					"8", previewPageLayout.getPlid(), "RENDER_PHASE");
			calEventURL.setParameter("struts_action", "CreateEvent");
			calEventURL.setParameter("redirect", PortalUtil.getCurrentURL(resourceRequest));

			sb.append(
					"<span class='event-detail-add-cta inline-block align-middle width-5 text-right'><a class='inline-block line-none' title='Add' href='"
							+ calEventURL.toString() + "' ><img class='inline-block' alt='Add' src='"
							+ themeDisplay.getPathThemeImages() + "/common/add.png' /></a></span></td></tr>");

		} catch (Exception e) {

		}

		sb.append("<tr><td class='event-detail-rightRow1 table-cell box-sizing-border border-bottom'>");
		
		 Calendar scal = null;

         scal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
      scal.setTime(new Date(event.getStartTime()));
      
      Calendar ecal = null;

      ecal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
      ecal.setTime(new Date(event.getEndTime()));
      
      SimpleDateFormat format1 =
              new SimpleDateFormat("dd MMM");

		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

		String description = event.getDescription(themeDisplay.getLocale()).trim();

		if (description.length() > 200) {
			description = description.substring(0, 199) + "...";
		}

		Date StartDate = new Date(event.getStartTime());
        Date EndDate = new Date(event.getEndTime());
        String dateString = format.format(event.getStartTime());
        if(EndDate != StartDate){
    	        	if(ecal.get(Calendar.YEAR) == scal.get(Calendar.YEAR)){
        	        	if(ecal.get(Calendar.MONTH) == scal.get(Calendar.MONTH)){
        	        		dateString = scal.get(Calendar.DAY_OF_MONTH) + " - " + format.format(event.getEndTime());
        	        	}else{
        	        		dateString = format1.format(event.getStartTime()) + " - " + format.format(event.getEndTime());
        	        	}
    	        	}else{
    	        		dateString = format.format(event.getStartTime()) + " - " + format.format(event.getEndTime());
    	        	}	
    	        }
    	        
		sb.append("<div class='event-detail-date inline-block align-top padding-half  box-sizing-border half-width'>");
		sb.append(
				"<span class='event-detail-date-text inline-block align-top box-sizing-border padding-right-quarter'><span class='event-detail-icon icon-date inline-block align-middle line-none box-sizing-border padding-none'><img src='"
						+ themeDisplay.getPathThemeImages()
						+ "/calendar/calendar.png' alt='Calendar'/></span><span class='event-detail-text inline-block align-middle'>"
						+ dateString );

		if (event.isRecurring()) {
			try {
				CalendarBooking calEventEndDate = CalendarBookingLocalServiceUtil
						.fetchCalendarBooking(event.getCalendarBookingId());
				long val = calEventEndDate.getEndTime();
				Date date = new Date(val);
				SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
				String dateText = df2.format(date);
				Date calEndDate = date;
				
				sb.append("-" + format.format(calEndDate));
			} catch (Exception e) {

			}

		}

		Calendar cal = null;

		// if (event.getTimeZoneSensitive()) {
		cal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
		// } else {
		// cal = CalendarFactoryUtil.getCalendar();
		// }

		cal.setTime(new Date(event.getStartTime()));
		int starthour = cal.get(Calendar.HOUR);
		int startmin = cal.get(Calendar.MINUTE);
		String startPm = "";

		if (cal.get(Calendar.AM_PM) == 0) {
			startPm = "AM";
		} else {
			startPm = "PM";
		}

		DecimalFormat df = new DecimalFormat("00");
		Calendar cal1 = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
        cal1.setTime(new Date(event.getEndTime()));
        int endmin = cal1.get(Calendar.MINUTE);

        int endhour = cal1.get(Calendar.HOUR);

        if (endmin > 59) {
            endmin = endmin - 60;
            endhour++;
        }

        String endPm = "";
        if (cal1.get(Calendar.AM_PM) == 0) {
        	endPm = "AM";
        } else {
        	endPm = "PM";
        }
		sb.append("</span></span></div>");
		sb.append(
				"<div class='event-detail-time-venue inline-block align-top padding-half box-sizing-border half-width border-left'>");
		sb.append(
				"<span class='event-detail-time-text inline-block align-top box-sizing-border padding-right-quarter'><span class='event-detail-icon icon-time align-middle line-none box-sizing-border padding-none inline-block'><img  src='"
						+ themeDisplay.getPathThemeImages()
						+ "/calendar/clock.png' alt='Clock' /></span><span class='event-detail-text inline-block align-middle'>"
						+ df.format(starthour) + ":" + df.format(startmin) + startPm + "-" + df.format(endhour) + ":"
						+ df.format(endmin) + endPm + "</span></span>");
		sb.append(
				"<span class='event-detail-venue-text inline-block align-top box-sizing-border padding-right-quarter'><span class='event-detail-icon icon-venue align-middle line-none box-sizing-border padding-none inline-block'><img  src='"
						+ themeDisplay.getPathThemeImages()
						+ "/calendar/location.png' alt='Location'/></span><span class='event-detail-text inline-block align-middle'>"
						+ event.getLocation() + "</span></span></div>");
		sb.append("</td></tr>");

		String url = "";

		if (event.getExpandoBridge().getAttributes().get("reference-url") != null) {
			if (event.getExpandoBridge().getAttributes().get("reference-url") != "") {
				url = event.getExpandoBridge().getAttributes().get("reference-url").toString();

				sb.append(
						"<tr><td class='event-detail-rightRow1 event-detail-view table-cell padding-half box-sizing-border border-bottom'>");
				sb.append(
						"<span class='event-detail-icon icon-view align-middle line-none box-sizing-border padding-none inline-block'><img src='"
								+ themeDisplay.getPathThemeImages()
								+ "/calendar/link.png' alt='Link'/></span><span class='event-detail-text inline-block align-top'><a class='urlLink link' target='_blank' href='"
								+ url + "'>" + "View Link" + "</a>");
				sb.append("</span></td></tr>");
			}

		}
		sb.append(
				"<tr> <td class='event-detail-rightRow1 event-detail-description table-cell padding-half box-sizing-border border-bottom'> ");
		sb.append(
				"<span class='event-detail-icon icon-details align-middle line-none box-sizing-border padding-none inline-block'><img src='"
						+ themeDisplay.getPathThemeImages() + "/calendar/description.png' alt='Description'/></span>");
		sb.append(
				"<span id='description' class='event-description event-detail-text inline-block align-top width-95 box-sizing-border'>"
						+ description + "</span></td> </tr>");

		String pageName = preferences.getValue("pageName", StringPool.BLANK);
		String liferaydetail = preferences.getValue("liferaydetail", "false");

		if (liferaydetail == null) {
			liferaydetail = "false";
		}

		sb.append(
				"<tr><td class='event-detail-rightRow1 event-detail-cta table-cell padding-half box-sizing-border'> <div class='event-cta text-right' ><a class='inline-block btn-primary read-more' href='"
						+ pageName + "/-/event/view_event/" + event.getCalendarBookingId() + "?flagDetail="
						+ liferaydetail + "' >Read More</a></div>");
		if (event.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
			if (event.getExpandoBridge().getAttributes().get("rsvp-url").toString().trim().length() > 0) {
				sb.append(
						"<div class='event-cta text-right'><a class='inline-block btn-primary read-more btn-rsvp margin-left-quarter' href='"
								+ event.getExpandoBridge().getAttributes().get("rsvp-url").toString() + "'>");
				if (event.getExpandoBridge().getAttributes().get("rsvp-label") != null) {
					if (event.getExpandoBridge().getAttributes().get("rsvp-label").toString().trim().length() > 0) {
						sb.append(event.getExpandoBridge().getAttributes().get("rsvp-label").toString() + "</a></div>");
					} else {
						sb.append("RSVP</a></div>");
					}
				}
			}

		}
		sb.append(" </td> </tr></table> </div>");
		return sb.toString();
	}

	private HashMap<String, List<String>> getEventsImageMap(long respositoryId, long eventId) {
		HashMap<String, List<String>> eventImageFiles = new HashMap<String, List<String>>();
		long parentFolderId = 0;
		List<String> imageUrl = new ArrayList<String>();

		try {
			Folder folder = DLAppServiceUtil.getFolder(respositoryId, 0, SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER);
			if (folder != null) {
				parentFolderId = folder.getFolderId();
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		imageUrl = new ArrayList<String>();
		try {
			Folder subFolder = DLAppServiceUtil.getFolder(respositoryId, parentFolderId, "Events_" + eventId);

			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(respositoryId, subFolder.getFolderId());

			for (FileEntry file : fileEntries) {
				imageUrl.add("/documents/" + respositoryId + "/" + subFolder.getFolderId() + "/" + file.getTitle());
			}

			_log.debug("eventId " + eventId +  " imageUrl " + imageUrl);
			eventImageFiles.put(String.valueOf(eventId), imageUrl);

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return eventImageFiles;
	}
}
