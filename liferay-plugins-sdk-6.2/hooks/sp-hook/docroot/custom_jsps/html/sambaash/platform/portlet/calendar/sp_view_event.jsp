
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>
<%@ page import="com.sambaash.platform.util.PermissionUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="java.text.DecimalFormat" %>

<%

    String redirect = ParamUtil.getString(request, "redirect");

    CalEvent event = (CalEvent) request.getAttribute(WebKeys.CALENDAR_EVENT);

    HashMap<String, List<String>> fileEntries = (HashMap<String, List<String>>) request.getAttribute("images");

    Recurrence recurrence = null;

    List<String> lstFiles = null;

    int recurrenceType = ParamUtil.getInteger(request, "recurrenceType", Recurrence.NO_RECURRENCE);

    if (event.getRepeating()) {
        recurrence = event.getRecurrenceObj();
        recurrenceType = recurrence.getFrequency();
    }

    int endDateType = ParamUtil.getInteger(request, "endDateType");

    if ((event.getRepeating()) && (recurrence != null)) {
        if (recurrence.getUntil() != null) {
            endDateType = 2;
        } else if (recurrence.getOccurrence() > 0) {
            endDateType = 1;
        }
    }

    AssetEntry layoutAssetEntry = AssetEntryLocalServiceUtil.getEntry(CalEvent.class.getName(), event.getEventId());

    request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, layoutAssetEntry);

    request.setAttribute("view_event.jsp-event", event);
%>

<portlet:actionURL var="editeventURL">
    <portlet:param name="struts_action" value="/calendar/edit_event"/>
    <portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>"/>
    <portlet:param name="redirect" value="<%= currentURL%>"/>
    <portlet:param name="cmd" value="edit"/>
</portlet:actionURL>

<portlet:actionURL var="createEventURL">
    <portlet:param name="struts_action" value="/calendar/edit_event"/>
    <portlet:param name="cmd" value="add-event"/>
    <portlet:param name="redirect" value="<%= currentURL%>"/>
</portlet:actionURL>


<body>


<div class="event-maindiv">
<div class="event-detail-table1">

<div class="event-detail-left">
    <% if (event != null) {%>

    <%

        lstFiles = fileEntries.get(String.valueOf(event.getEventId()));
        //lstFiles = null;
        if (lstFiles != null && lstFiles.size() != 0) {
            int countFile = 1;
    %>

    <div id="images">
        <%
            for (String url : lstFiles) {
                if (countFile == 1) { %>

        <img id="image<%= countFile %>" src="<%=url %>?version=1.0&imageThumbnail=4" class="aftermove"/>

        <% } else {%>
        <img id="image<%= countFile %>" src="<%=url %>?version=1.0&imageThumbnail=4" class="beforemove"/>
        <% }
            countFile++;
        }
            countFile = 1; %>
    </div>

    <div id="sliderevent">
        <%
            for (String url : lstFiles) {
        %>
        <a href="#" onclick="changeImage('<%= countFile%>','<%=lstFiles.size() %>')"><img src="<%= url %>" height="16"
                                                                                          width="16px"/></a>
        <% countFile++;
        } %>
    </div>

    <% } else {%>
    <div style="width:50%"><img src="<%= themeDisplay.getPathThemeImages()%>/common/defaultEvent.png"
                                class="emptyimage-eventdetail"></div>
    <%
        }
    } else {
    %>
    <div style="width:50%"><img src="<%= themeDisplay.getPathThemeImages()%>/common/defaultEvent.png"
                                class="daily-eventdetail"></div>
    <%}%>
</div>
<div class="event-detail-right" id="event-detail-right">
    <%if (event != null) { %>
    <table style="width:100%;">
        <tr>
            <td class="event-detail-rightRow1" style="height:41px">
                        <span><img src="<%= themeDisplay.getPathThemeImages()%>/calendar/title.png"/>
                        </span>
                <span style="vertical-align:top;text-transform:uppercase;"><%= event.getTitle() %></span>
				 <c:if test="<%= PermissionUtil.containsCalEvent(permissionChecker, event, ActionKeys.UPDATE) %>">
	                <form name="UploadForm" action="<%= editeventURL %>" enctype="multipart/form-data" method="POST"
	                      id="fm1" name="fm1">
	                    <input type="hidden" name="<portlet:namespace />title" id="title" value="<%= event.getTitle() %>"/>
	                           <span class="event-edit event-create-cta">
	                           <% if (themeDisplay.getUserId() == event.getUserId()) {%>
	                           <a onclick="editEvent()"><img src="<%= themeDisplay.getPathThemeImages()%>/common/edit.png"/>Edit</a>
	                           <% } %>
	                           </span>
	                </form>
                </c:if>


            </td>
        </tr>
        <%
            String dateString = event.getStartDate().toString();
            SimpleDateFormat format =
                    new SimpleDateFormat("dd MMM yyyy");

            SimpleDateFormat formatTime =
                    new SimpleDateFormat("kk:mm aa");

            String description = "";
            if (event.getDescription().length() > 200) {
                description = event.getDescription().substring(0, 199) + "...";
            } else {
                description = event.getDescription();
            }

        %>
        <tr>
            <td class="event-detail-rightRow1" style="height:41px">
                        <span style="font-size:12px;"><img
                                src="<%= themeDisplay.getPathThemeImages()%>/calendar/calendar.png"/>
                            <%=format.format(event.getStartDate()) %>
                            
                            <% if (event.getRepeating()) {
                                CalEvent calEventEndDate = CalEventLocalServiceUtil.fetchCalEvent(event.getEventId());
                                Date calEndDate = calEventEndDate.getEndDate();
                            %>
                            -<%= format.format(calEndDate) %>
                            <% } %>
                        </span>
                        <span style="font-size:12px;"><img
                                src="<%= themeDisplay.getPathThemeImages()%>/calendar/clock.png"/>
                        <%

                            Calendar cal = null;
                            if (event.getTimeZoneSensitive()) {
                                cal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
                            } else {
                                cal = CalendarFactoryUtil.getCalendar();
                            }
                            cal.setTime(event.getStartDate());

                            int starthour = cal.get(Calendar.HOUR);
                            int startmin = cal.get(Calendar.MINUTE);
                            String startPm = "";
                            if (cal.get(Calendar.AM_PM) == 0) {
                                startPm = "AM";
                            } else {
                                startPm = "PM";
                            }
                            DecimalFormat df = new DecimalFormat("00");
                            int durationHour = event.getDurationHour();
                            int durationMin = event.getDurationMinute();


                            int endmin = cal.get(Calendar.MINUTE) + durationMin;

                            int endhour = cal.get(Calendar.HOUR) + durationHour;

                            if (endmin > 59) {
                                endmin = endmin - 60;
                                endhour++;
                            }

                            String endPm = "";
                            if (endhour > 12) {
                                endhour = endhour - 12;
                                endPm = "PM";
                            } else {
                                if (startPm.equals("PM")) {
                                    endPm = "PM";
                                } else {
                                    if (endhour == 12 && endmin > 0) {
                                        endPm = "PM";
                                    } else {
                                        endPm = "AM";
                                    }


                                }

                            }
                        %>
                        <!--  <%=formatTime.format(event.getStartDate())%>-<%=formatTime.format(CalUtil.getEndTime(event))%>-->
                        <%= df.format(starthour) %>:<%= df.format(startmin) + startPm %> -
                        <%= df.format(endhour) %>:<%= df.format(endmin) + endPm %> 
                        </span>
                <span style="font-size:12px;"><img
                        src="<%= themeDisplay.getPathThemeImages()%>/calendar/location.png"/><%= event.getLocation() %></span>
            </td>
        </tr>
        <tr>

            <%

            %>
            <td class="event-detail-rightRow1" style="height:41px">
                        <span>
                            <img src="<%= themeDisplay.getPathThemeImages()%>/calendar/link.png"/>
                            <%

                                if (event.getExpandoBridge().getAttributes().get("reference-url") != null) {
                                    if (event.getExpandoBridge().getAttributes().get("reference-url") != "") {
                            %>
                            <a href="<%= event.getExpandoBridge().getAttributes().get("reference-url") %>"
                               target="_blank" class="urlLink">
                                View Link
                            </a>
                            <%
                                    }
                                }
                            %>
                        </span>
            </td>
        </tr>
        <tr>
            <td class="event-detail-rightRow1 event-detail-description">
                <div>
                    <div id="geoMap">
                        <article>
                        </article>
                    </div>

                    <%
                        String rsvpURL = "";
                        if (event.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
                            rsvpURL = event.getExpandoBridge().getAttributes().get("rsvp-url").toString();
                        }
                    %>

                    <%

                        if (event.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
                            if (event.getExpandoBridge().getAttributes().get("rsvp-url").toString().trim().length() > 0) {
                    %>
                    <div class="btn-rsvp"><a href="<%= rsvpURL%>">
                        <%if (event.getExpandoBridge().getAttributes().get("rsvp-label") != null) {%>

                        <%=event.getExpandoBridge().getAttributes().get("rsvp-label") %>
                        <%} else { %>
                        RSVP
                        <% } %>
                    </a></div>
                    <% }
                    } %>
                </div>
            </td>
        </tr>


    </table>
    <%} else { %>
    <div style="width:100%;margin:0 auto;"><img src="<%= themeDisplay.getPathThemeImages()%>/common/no_event.jpg"
                                                style="height:300px;width:400px;"/></div>
    <% } %>
</div>


<%
if(SambaashUtil.isSocialShareEnabled()){
%>
<div class=spEventSocialBookmarks>
    <liferay-ui:social-bookmarks
            displayStyle="horizontal"
            target="_blank"
            title="<%= event.getTitle() %>"
            url="<%= currentURL %>"
            />

<%}%>

</div>
<div style="float:right;margin-top:20px;margin-right:20px;">
	<c:if test="<%= PermissionUtil.containsCalendar(permissionChecker, scopeGroupId, ActionKeys.ADD_EVENT) %>">
	    <form action="<%= createEventURL %>" enctype="multipart/form-data" method="POST" id="createEvent"
	          name="createEvent">
	        <span class="event-create-cta"><a onclick="addEvent()"><img src="<%= themeDisplay.getPathThemeImages()%>/common/add.png"/>Create
	            Event</a></span>
	    </form>
    </c:if>
</div>

</div>

<portlet:actionURL var="viewEventURL">
    <portlet:param name="struts_action" value="/calendar/view_event"/>
    <portlet:param name="redirect" value="<%= currentURL%>"/>
    <portlet:param name="eventId" value="<%= String.valueOf(event.getEventId())%>"/>
</portlet:actionURL>

<div class="allevent-div" style="padding: 45px 15px 15px;">

    <div class="description-title">
        <span> Description </span>
    </div>
    <%
        String descriptionEvent = event.getDescription();
        descriptionEvent.replaceAll("\"", "&#34");

    %>


    <div class="event-detaillink-description1" id="divdescription"><%= descriptionEvent %>
    </div>

    <div>
        <liferay-ui:panel-container extended="<%= false %>" id="calendarCommentsPanelContainer"
                                    persistState="<%= true %>">
            <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="calendarCommentsPanel"
                              persistState="<%= true %>" title="comments">
                <portlet:actionURL var="discussionURL">
                    <portlet:param name="struts_action" value="/calendar/edit_event_discussion"/>
                </portlet:actionURL>

                <liferay-ui:discussion
                        className="<%= CalEvent.class.getName() %>"
                        classPK="<%= event.getEventId() %>"
                        formAction="<%= discussionURL %>"
                        formName="fm2"
                        ratingsEnabled="true"
                        redirect="<%= currentURL %>"
                        subject="<%= event.getTitle() %>"
                        userId="<%= event.getUserId() %>"
                        />
            </liferay-ui:panel>
        </liferay-ui:panel-container>
    </div>
</div>

</div>

</body>
<script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    function changeImage(count, total) {
        var url = "";
        for (var i = 0; i < total; i++) {

            if (document.getElementById("image" + (i + 1)).className.toString() == "aftermove") {
                url = document.getElementById("image" + (i + 1)).src;
            }
        }
        document.getElementById("images").style.backgroundImage = "url('" + url + "')";
        for (var i = 0; i < total; i++) {
            document.getElementById("image" + (i + 1)).className = "beforemove";
        }
        document.getElementById("image" + count).className = "aftermove";


        return false;

    }

    AUI().ready(function (A) {
        var changeAddress = '<%= event.getLocation() %>';
        var mapcanvas = document.createElement('div');
        mapcanvas.id = 'mapcanvas';
        if (changeAddress != "") {
            document.querySelector('article').appendChild(mapcanvas);
        }

        var map = null;
        map = new google.maps.Map(document.getElementById("mapcanvas"), {
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            mapTypeControl: true,
            navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
            zoom: 8,
            streetViewControl: false
        });

        var image = "/html/portlet/calendar/currentlocation.png";


        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({ 'address': changeAddress}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                var latlng2 = new google.maps.LatLng(results[0].geometry.location.lat(), results[0].geometry.location.lng());
                var marker = new google.maps.Marker({
                    position: latlng2,
                    map: map,
                    title: changeAddress,

                });
                var latLng = marker.getPosition(); // returns LatLng object
                map.setCenter(latLng);

                var bounds = new google.maps.LatLngBounds();

                var secondlat = results[0].geometry.location.lat() + 0.00000001;
                var secondLog = results[0].geometry.location.lng() + 0.020;

                bounds.extend(new google.maps.LatLng(secondlat, secondLog));
                bounds.extend(new google.maps.LatLng(results[0].geometry.location.lat(), results[0].geometry.location.lng()));

                map.fitBounds(bounds);
                var latLng = marker.getPosition(); // returns LatLng object
                map.setCenter(latLng);
            } else {
                document.getElementById("mapcanvas").style.background = "#ffffff";
            }

        });

    });

    function editEvent() {
        document.getElementById("fm1").submit();
    }

    function addEvent() {
        document.getElementById("createEvent").submit();
    }
</script>
