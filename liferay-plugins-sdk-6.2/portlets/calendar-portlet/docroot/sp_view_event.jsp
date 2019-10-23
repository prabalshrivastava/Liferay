<%--
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
--%>

<%-- <%@ include file="/init.jsp" %> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.calendar.CalendarBookingDurationException" %><%@
page import="com.liferay.calendar.CalendarNameException" %><%@
page import="com.liferay.calendar.CalendarResourceCodeException" %><%@
page import="com.liferay.calendar.CalendarResourceNameException" %><%@
page import="com.liferay.calendar.DuplicateCalendarResourceException" %><%@
page import="com.liferay.calendar.NoSuchResourceException" %><%@
page import="com.liferay.calendar.model.Calendar" %><%@
page import="com.liferay.calendar.model.CalendarBooking" %><%@
page import="com.liferay.calendar.model.CalendarNotificationTemplate" %><%@
page import="com.liferay.calendar.model.CalendarNotificationTemplateConstants" %><%@
page import="com.liferay.calendar.model.CalendarResource" %><%@
page import="com.liferay.calendar.notification.NotificationField" %><%@
page import="com.liferay.calendar.notification.NotificationTemplateType" %><%@
page import="com.liferay.calendar.notification.NotificationType" %><%@
page import="com.liferay.calendar.recurrence.Frequency" %><%@
page import="com.liferay.calendar.recurrence.PositionalWeekday" %><%@
page import="com.liferay.calendar.recurrence.Recurrence" %><%@
page import="com.liferay.calendar.recurrence.Weekday" %><%@
page import="com.liferay.calendar.search.CalendarResourceDisplayTerms" %><%@
page import="com.liferay.calendar.search.CalendarResourceSearch" %><%@
page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil" %><%@
page import="com.liferay.calendar.service.CalendarBookingServiceUtil" %><%@
page import="com.liferay.calendar.service.CalendarNotificationTemplateLocalServiceUtil" %><%@
page import="com.liferay.calendar.service.CalendarResourceServiceUtil" %><%@
page import="com.liferay.calendar.service.CalendarServiceUtil" %><%@
page import="com.liferay.calendar.service.permission.CalendarPermission" %><%@
page import="com.liferay.calendar.service.permission.CalendarPortletPermission" %><%@
page import="com.liferay.calendar.service.permission.CalendarResourcePermission" %><%@
page import="com.liferay.calendar.util.ActionKeys" %><%@
page import="com.liferay.calendar.util.CalendarResourceUtil" %><%@
page import="com.liferay.calendar.util.CalendarUtil" %><%@
page import="com.liferay.calendar.util.ColorUtil" %><%@
page import="com.liferay.calendar.util.JCalendarUtil" %><%@
page import="com.liferay.calendar.util.NotificationUtil" %><%@
page import="com.liferay.calendar.util.PortletPropsValues" %><%@
page import="com.liferay.calendar.util.RecurrenceUtil" %><%@
page import="com.liferay.calendar.util.WebKeys" %><%@
page import="com.liferay.calendar.util.comparator.CalendarNameComparator" %><%@
page import="com.liferay.calendar.workflow.CalendarBookingWorkflowConstants" %><%@
page import="com.liferay.compat.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.json.JSONArray" %><%@
page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %><%@
page import="com.liferay.portal.kernel.json.JSONObject" %><%@
page import="com.liferay.portal.kernel.json.JSONSerializer" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.servlet.BrowserSnifferUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatConstants" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.Time" %><%@
page import="com.liferay.portal.kernel.util.UnicodeFormatter" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.security.auth.PrincipalException" %><%@
page import="com.liferay.portal.service.GroupServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.util.SessionClicks" %><%@
page import="com.liferay.portal.util.comparator.UserScreenNameComparator" %><%@
page import="com.liferay.portlet.asset.model.AssetEntry" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.util.RSSUtil" %>
<%@ page import="java.net.URLEncoder" %>

<%@ page import="java.text.Format" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Date" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.List" %><%@
page import="java.util.TimeZone" %>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>
<%@ page import="javax.portlet.PortletURL" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />



<%
String currentURL1 = PortalUtil.getCurrentURL(request);

String timeZoneId1 = portletPreferences.getValue("timeZoneId", user.getTimeZoneId());
boolean usePortalTimeZone1 = GetterUtil.getBoolean(portletPreferences.getValue("usePortalTimeZone", Boolean.TRUE.toString()));

if (usePortalTimeZone1) {
	timeZoneId1 = user.getTimeZoneId();
}

TimeZone userTimeZone1 = TimeZone.getTimeZone(timeZoneId1);

Format dateFormatLongDate1 = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, timeZone);

%>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.sambaash.platform.util.PermissionUtil" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>

<%
String backURL = ParamUtil.getString(request, "backURL");
		 
CalendarBooking calendarBooking = (CalendarBooking)request.getAttribute("CALENDAR_BOOKING");
		 
int instanceIndex = BeanParamUtil.getInteger(calendarBooking, request, "instanceIndex");

calendarBooking = RecurrenceUtil.getCalendarBookingInstance(calendarBooking, instanceIndex);

Calendar calendar = calendarBooking.getCalendar();

long startTime = calendarBooking.getStartTime();

java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(startTime, userTimeZone1);

long endTime = calendarBooking.getEndTime();

java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(endTime, userTimeZone1);

boolean allDay = BeanParamUtil.getBoolean(calendarBooking, request, "allDay");

AssetEntry layoutAssetEntry = AssetEntryLocalServiceUtil.getEntry(CalendarBooking.class.getName(), calendarBooking.getCalendarBookingId());

HashMap<String, List<String>> fileEntries = (HashMap<String, List<String>>) request.getAttribute("Images");

List<String> lstFiles = null;

%>

 <% 
 String eventTitle1 = StringPool.BLANK;
 String imageUrl = themeDisplay.getPathThemeImages()+"/common/defaultEvent.png";
 if (calendarBooking != null) { 
                String xmlContent = calendarBooking.getTitle().trim();
				if(xmlContent.contains("</Title>")){
					com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);
					if (Validator.isNotNull(document.selectSingleNode("/root/Title"))) {
						eventTitle1 = document.selectSingleNode("/root/Title").getText();
					}
				}else{
					eventTitle1 = xmlContent;
				}
				if(fileEntries != null){
			        lstFiles = fileEntries.get(String.valueOf(calendarBooking.getCalendarBookingId()));
			        for (String url : lstFiles) {
			        	imageUrl = PortalUtil.getPortalURL(request) + url+"?version=1.0&imageThumbnail=4";
			        }
				}
 }
                %>

<liferay-util:html-top>                                                                                                                                                    
        <meta property="og:title" content="<%=eventTitle1%>"/>                                                                                                                   
        <meta property="og:description" content="<%= calendarBooking.getDescription(locale) %>"/>                                                                                                       
        <meta property="og:image" content="<%= imageUrl%>"/>                                                                                                                   
        <meta property="og:url" content="<%= URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8")%>"/>                                                                                                                       
        <meta property="og:type" content="Event"/>                                                                                                                       
</liferay-util:html-top> 

<portlet:actionURL var="editeventURL">
    <portlet:param name="struts_action" value="/calendar/edit_event"/>
    <portlet:param name="eventId" value="<%= String.valueOf(calendarBooking.getCalendarBookingId()) %>"/>
    <portlet:param name="cmd" value="edit"/>
</portlet:actionURL>

<%-- <liferay-ui:header
	backURL="<%= backURL %>"
	title="<%= calendarBooking.getTitle(locale) %>"
/> --%>
<div class="event-maindiv border-all max-width block box-sizing-border padding-left-75 padding-right-75 padding-top-one padding-bottom-one">
<div class="event-detail-table1 block font-none white-bg">

<div class="event-detail-left inline-block align-top width-55">

<% if (calendarBooking != null) {%>

    <%
	if(fileEntries != null){
        lstFiles = fileEntries.get(String.valueOf(calendarBooking.getCalendarBookingId()));
	}
        //lstFiles = null;
        if (lstFiles != null && lstFiles.size() != 0) {
            int countFile = 1;
    %>

    <div id="images">
        <%
            for (String url : lstFiles) {
                if (countFile == lstFiles.size()) { %>

        <img id="image<%= countFile %>" src="<%=url %>?version=1.0&imageThumbnail=4" class="aftermove full-width " alt="Image Thumbnail"/>

        <% } else {%>
        <img id="image<%= countFile %>" src="<%=url %>?version=1.0&imageThumbnail=4" class="beforemove full-width " alt="Image Thumbnail"/>
        <% }
            countFile++;
        }
            countFile = 1; %>
    </div>

    <div id="sliderevent" class="hide">
        <%
            for (String url : lstFiles) {
        %>
        <a href="#" onclick="changeImage('<%= countFile%>','<%=lstFiles.size() %>')">
        	<img src="<%= url %>" height="16"  width="16" alt="Image"/>
       	</a>
        <% countFile++;
        } %>
    </div>

    <% } else {%>
    <div class="defaultImage full-width full-height align-middle">
    	<figure class="table-cell full-width full-height align-middle text-center">
    		<img src="<%= themeDisplay.getPathThemeImages()%>/common/defaultEvent.png" class="daily-eventdetail full-width full-height" alt="Event default image">
    	</figure>
    </div>
    <%
        }
    } else {
    %>
   <div class="defaultImage full-width full-height align-middle">
   	 <figure class="table-cell full-width full-height align-middle text-center">
  	 	<img src="<%= themeDisplay.getPathThemeImages()%>/common/defaultEvent.png" class="daily-eventdetail full-width full-height" alt="Event default image">
  	 </figure>
   </div>
    <%}%>
    </div>
    
    <div class="event-detail-right inline-block align-top width-45 full-height box-sizing-border" id="event-detail-right">
    <%
    if (calendarBooking != null) { %>
    <table class="table full-width full-height font-std">
        <tr>
            <td class="event-detail-rightRow1 table-cell padding-half box-sizing-border border-bottom">
                <span class="event-detail-icon icon-title inline-block line-none align-middle padding-none inline-block box-sizing-border width-5">
                	<img src="<%= themeDisplay.getPathThemeImages()%>/calendar/title.png" alt="Title"/>
               	</span>
                <span class="event-detail-title inline-block align-middle padding-right-quarter box-sizing-border width-90">
                <% 
                String xmlContent = calendarBooking.getTitle().trim();
				String eventTitle = StringPool.BLANK;
				if(xmlContent.contains("</Title>")){
					com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);
					if (Validator.isNotNull(document.selectSingleNode("/root/Title"))) {
						eventTitle = document.selectSingleNode("/root/Title").getText();
					}
				}else{
					eventTitle = xmlContent;
				}
                %>
                	<h2 class="h2 "><%= eventTitle %></h2>
                </span>
				<%-- <c:if test="<%= PermissionUtil.containsCalEvent(permissionChecker, calendarBooking, ActionKeys.UPDATE) %>"> --%>
	                <form class="block text-right inline-block" name="UploadForm" action="<%= editeventURL %>" enctype="multipart/form-data" method="POST" id="fm1" name="fm1">
	                    <input class="inline-block" type="hidden" name="title" id="title" value="<%= eventTitle %>"/>
	                           <span class="event-edit event-create-cta font-none">
	                           <% if ((themeDisplay.getUserId() == calendarBooking.getUserId()) || (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))){%>
	                           <a href="/create-events?eventId=<%=calendarBooking.getCalendarBookingId() %>" class="font-none"><img src="<%= themeDisplay.getPathThemeImages()%>/common/edit.png" alt="Edit"/>Edit</a>
	                           <% } %>
	                    </span>
	                </form>
                <%-- </c:if> --%>
			</td>
        </tr>
        <%
            String dateString = String.valueOf(startTime);
        java.util.Calendar scal = null;

        scal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
     scal.setTime(new Date(calendarBooking.getStartTime()));
     
     java.util.Calendar ecal = null;

     ecal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
     ecal.setTime(new Date(calendarBooking.getEndTime()));
     
         SimpleDateFormat format =
                 new SimpleDateFormat("dd MMM yyyy");
         
         SimpleDateFormat format1 =
                 new SimpleDateFormat("dd MMM");
         
            SimpleDateFormat formatTime =
                    new SimpleDateFormat("kk:mm aa");

            String description = "";
            if (calendarBooking.getDescription().length() > 200) {
                description = calendarBooking.getDescription().substring(0, 199) + "...";
            } else {
                description = calendarBooking.getDescription();
            }

            Date StartDate = new Date(calendarBooking.getStartTime());
            Date EndDate = new Date(calendarBooking.getEndTime());
           
        	        if(EndDate.getDate() != (StartDate.getDate())){
        	        	if(ecal.get(java.util.Calendar.YEAR) == scal.get(java.util.Calendar.YEAR)){
            	        	if(ecal.get(java.util.Calendar.MONTH) == scal.get(java.util.Calendar.MONTH)){
            	        		dateString = scal.get(java.util.Calendar.DAY_OF_MONTH) + " - " + format.format(calendarBooking.getEndTime());
            	        	}else{
            	        		dateString = format1.format(calendarBooking.getStartTime()) + " - " + format.format(calendarBooking.getEndTime());
            	        	}
        	        	}else{
        	        		dateString = format.format(calendarBooking.getStartTime()) + " - " + format.format(calendarBooking.getEndTime());
        	        	}	
        	        }else{
        	        	dateString = format.format(calendarBooking.getStartTime());
        	        }
        %>
        <tr>
            <td class="event-detail-rightRow1 table-cell box-sizing-border border-bottom font-none">
            			<div class="event-detail-date inline-block align-top padding-half  box-sizing-border half-width font-std">
	            			<span class="event-detail-date-text inline-block align-top box-sizing-border padding-right-quarter">
		                        <span class="event-detail-icon icon-date inline-block align-middle line-none box-sizing-border padding-none">
		                        	<img src="<%= themeDisplay.getPathThemeImages()%>/calendar/calendar.png" alt="Calendar"/>
		                        </span>
		                        <span class="event-detail-text inline-block align-middle">
		                            <%=dateString %>
		                        </span>
	                        </span>
                        </div>
                        <div class="event-detail-time-venue inline-block align-top padding-half box-sizing-border half-width border-left font-std">
	                        <span class="event-detail-time-text inline-block align-top box-sizing-border">
		                        <span class="event-detail-icon icon-time align-middle line-none box-sizing-border padding-none inline-block">
		                        	<img src="<%= themeDisplay.getPathThemeImages()%>/calendar/clock.png" alt="Clock"/>
		                       	</span>
		                       	<span class="event-detail-text inline-block align-middle">
			                        <%

			                        java.util.Calendar cal = null;
			                           //if (calendarBooking.getTimeZone() > 0) {
			                                cal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
			                            //} else {
			                              //  cal = CalendarFactoryUtil.getCalendar();
			                            //}
			                            cal.setTime(new Date(calendarBooking.getStartTime()));
			                            int starthour = cal.get(java.util.Calendar.HOUR);
			                            int startmin = cal.get(java.util.Calendar.MINUTE);
			                            String startPm = "";
			                           if (cal.get(java.util.Calendar.AM_PM) == 0) {
			                                startPm = "AM";
			                            } else {
			                                startPm = "PM";
			                            }
			                           java.text.DecimalFormat df = new java.text.DecimalFormat("00");
			                           
			                           java.util.Calendar cal1 = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
			                            cal1.setTime(new Date(calendarBooking.getEndTime()));
			                            int endmin = cal1.get(java.util.Calendar.MINUTE);
			
			                            int endhour = cal1.get(java.util.Calendar.HOUR);
			
			                            if (endmin > 59) {
			                                endmin = endmin - 60;
			                                endhour++;
			                            }
			
			                            String endPm = "";
			                            if (cal1.get(java.util.Calendar.AM_PM) == 0) {
			                            	endPm = "AM";
			                            } else {
			                            	endPm = "PM";
			                            }
			                        %>
			                       
			                        <%= df.format(starthour) %>:<%= df.format(startmin) + startPm %> -
			                        <%= df.format(endhour) %>:<%= df.format(endmin) + endPm %>
			                        
		                        </span>
	                        </span>
	                        <span class="event-detail-venue-text inline-block align-top box-sizing-border ">
		                        <span class="event-detail-icon icon-venue align-middle line-none box-sizing-border padding-none inline-block">
	                				<img src="<%= themeDisplay.getPathThemeImages()%>/calendar/location.png" alt="Location"/>
	                			</span>
	                			<span class="event-detail-text inline-block align-middle">
	                				<%= calendarBooking.getLocation() %>
	                		    </span>
                		    </span>
                        </div>

            </td>
        </tr>
         <%

                                if (calendarBooking.getExpandoBridge().getAttributes().get("reference-url") != null) {
                                    if (calendarBooking.getExpandoBridge().getAttributes().get("reference-url") != "") {
                            %>
        <tr>

            <td class="event-detail-rightRow1 event-detail-view table-cell padding-half box-sizing-border border-bottom">
                        <span class="event-detail-icon icon-view align-middle line-none box-sizing-border padding-none inline-block">
                            <img src="<%= themeDisplay.getPathThemeImages()%>/calendar/link.png" alt="Link"/>
                        </span>
                        <span class="event-detail-text inline-block align-top">
                           
                            <a href="<%= calendarBooking.getExpandoBridge().getAttributes().get("reference-url") %>" target="_blank" class="urlLink link">
                                View Link
                            </a>
                           
                        </span>
            </td>
        </tr>
         <%
                                    }
                                }
                            %>
        <tr>
            <td class="event-detail-rightRow1 event-detail-description table-cell padding-half box-sizing-border border-bottom">
                <div class="block">
                    <div id="geoMap">
                        <article class="block text-center padding-half box-sizing-border">
                        </article>
                    </div>

                    <%
                        String rsvpURL = "";
                        if (calendarBooking.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
                            rsvpURL = calendarBooking.getExpandoBridge().getAttributes().get("rsvp-url").toString();
                        }
                    %>

                    <%

                        if (calendarBooking.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
                            if (calendarBooking.getExpandoBridge().getAttributes().get("rsvp-url").toString().trim().length() > 0) {
                    %>
                    <div class="btn-rsvp event-cta text-right">
                    	<a href="<%= rsvpURL%>" class="inline-block btn-primary read-more">
                        <%if (calendarBooking.getExpandoBridge().getAttributes().get("rsvp-label") != null) {%>

                        <%=calendarBooking.getExpandoBridge().getAttributes().get("rsvp-label") %>
                        <%} else { %>
                        RSVP
                        <% } %>
                    	</a>
                    </div>
                    <% }
                    } %>
                </div>
            </td>
        </tr>


    </table>
    <%} else { %>
    <div class="noEvent table full-width full-height align-middle text-center">
    	<img src="<%= themeDisplay.getPathThemeImages()%>/common/no_event.jpg" alt="No Event"/>
    </div>
    <% } %>
</div>
    
    
<aui:fieldset>

	<%-- <liferay-ui:custom-attributes-available className="<%= CalendarBooking.class.getName() %>">
		<liferay-ui:custom-attribute-list
			className="<%= CalendarBooking.class.getName() %>"
			classPK="<%= calendarBooking.getCalendarBookingId() %>"
			editable="<%= false %>"
			label="<%= true %>"
		/>
	</liferay-ui:custom-attributes-available> --%>

	<p>
		<%= calendarBooking.getDescription(locale) %>
	</p>

	<div class="entry-categories">
		<liferay-ui:asset-categories-summary
			className="<%= CalendarBooking.class.getName() %>"
			classPK="<%= calendarBooking.getCalendarBookingId() %>"
		/>
	</div>

	<div class="entry-tags">
		<liferay-ui:asset-tags-summary
			className="<%= CalendarBooking.class.getName() %>"
			classPK="<%= calendarBooking.getCalendarBookingId() %>"
			message="tags"
		/>
	</div>

	<div class="entry-links">
		<liferay-ui:asset-links
			assetEntryId="<%= layoutAssetEntry.getEntryId() %>"
		/>
	</div>

	<c:if test="<%= calendar.isEnableRatings() %>">
		<div class="entry-ratings">
			<liferay-ui:ratings
				className="<%= CalendarBooking.class.getName() %>"
				classPK="<%= calendarBooking.getCalendarBookingId() %>"
			/>
		</div>
	</c:if>
</aui:fieldset>

</div>
	<%-- <c:if test="<%= calendar.isEnableComments() %>"> --%>
	<aui:fieldset>
		<liferay-ui:panel-container extended="<%= false %>" id="calendarBookingPanelContainer" persistState="<%= true %>">
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" id="calendarBookingCommentsPanel" persistState="<%= true %>" title="comments">
				<liferay-portlet:actionURL name="updateDiscussion" var="updateDiscussionURL" />

				<liferay-ui:discussion
					className="<%= CalendarBooking.class.getName() %>"
					classPK="<%= calendarBooking.getCalendarBookingId() %>"
					formAction="<%= updateDiscussionURL %>"
					formName="fm2"
					ratingsEnabled="true"
					redirect="<%= currentURL1 %>"
					subject="<%= calendarBooking.getTitle(locale) %>"
					userId="<%= calendarBooking.getUserId() %>"
				/>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</aui:fieldset>
<%-- </c:if> --%>
</div>
<portlet:actionURL name="invokeTransition" var="invokeTransitionURL" />

<aui:form action="<%= invokeTransitionURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL1 %>" />
	<aui:input name="calendarBookingId" type="hidden" value="<%= calendarBooking.getCalendarBookingId() %>" />
	<aui:input name="status" type="hidden" />

	<aui:fieldset>
		<aui:button-row>

			<%
			boolean hasManageBookingsPermission = CalendarPermission.contains(permissionChecker, calendar, ActionKeys.MANAGE_BOOKINGS);
			%>

			<c:if test="<%= hasManageBookingsPermission && (calendarBooking.getStatus() != CalendarBookingWorkflowConstants.STATUS_APPROVED) %>">
				<aui:button onClick='<%= renderResponse.getNamespace() + "invokeTransition(" + CalendarBookingWorkflowConstants.STATUS_APPROVED + ");" %>' value="accept" />
			</c:if>

			<c:if test="<%= hasManageBookingsPermission && (calendarBooking.getStatus() != CalendarBookingWorkflowConstants.STATUS_MAYBE) %>">
				<aui:button onClick='<%= renderResponse.getNamespace() + "invokeTransition(" + CalendarBookingWorkflowConstants.STATUS_MAYBE + ");" %>' value="maybe" />
			</c:if>

			<c:if test="<%= hasManageBookingsPermission && (calendarBooking.getStatus() != CalendarBookingWorkflowConstants.STATUS_DENIED) %>">
				<aui:button onClick='<%= renderResponse.getNamespace() + "invokeTransition(" + CalendarBookingWorkflowConstants.STATUS_DENIED + ");" %>' value="decline" />
			</c:if>
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />invokeTransition(status) {
		document.<portlet:namespace />fm.<portlet:namespace />status.value = status;

		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>

<c:if test="<%= calendarBooking.isRecurring() %>">
	<aui:script use="liferay-calendar-recurrence-util">
		var summaryNode = A.one('#<portlet:namespace />recurrenceSummary');

		var endValue = 'never';
		var untilDate = null;

		<%
		Recurrence recurrence = calendarBooking.getRecurrenceObj();

		java.util.Calendar untilJCalendar = recurrence.getUntilJCalendar();
		%>

		<c:choose>
			<c:when test="<%= (untilJCalendar != null) %>">
				endValue = 'on';

				untilDate = new Date('<%= dateFormatLongDate1.format(untilJCalendar.getTimeInMillis()) %>');
			</c:when>
			<c:when test="<%= (recurrence.getCount() > 0) %>">
				endValue = 'after';
			</c:when>
		</c:choose>

		<%
		JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();

		List<Weekday> weekdays = new ArrayList<Weekday>();

		for (PositionalWeekday positionalWeekday : recurrence.getPositionalWeekdays()) {
			weekdays.add(positionalWeekday.getWeekday());
		}
		%>

		var recurrence = {
			count: <%= recurrence.getCount() %>,
			endValue: endValue,
			frequency: '<%= String.valueOf(recurrence.getFrequency()) %>',
			interval: <%= recurrence.getInterval() %>,
			untilDate: untilDate,
			weekdays: <%= jsonSerializer.serialize(weekdays) %>
		}

		var recurrenceSummary = Liferay.RecurrenceUtil.getSummary(recurrence);

		summaryNode.html(recurrenceSummary);
	</aui:script>
</c:if>
<script>
function editEvent() {
    document.getElementById("fm1").submit();
}

</script>
