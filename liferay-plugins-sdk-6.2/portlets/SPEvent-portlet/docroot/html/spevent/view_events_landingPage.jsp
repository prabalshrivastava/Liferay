<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>

<style type="text/css">

	.vp320 .portlet-content-container {
		margin-left: 0;
		margin-right: 0px;
	}

	.vp320 #main-content-section {
		padding: 12px 2px;
		width: 100%;
	}
</style>
<portlet:defineObjects/>

<portlet:renderURL var="editEventURL">

	<portlet:param name="struts_action" value="/calendar/edit_event" />
	<portlet:param name="cmd" value="add-event" />
</portlet:renderURL>

<liferay-theme:defineObjects/>

<div class="SPEvent-portlet event-maindiv max-width block box-sizing-border padding-left-75 padding-right-75 padding-top-one padding-bottom-one">
	<div class="event-maindiv-title hide"><span>Events Calendar</span></div>


	<%
String themeImage = themeDisplay.getPathThemeImages();
String pageno = request.getAttribute("pageno").toString();
String innerHTML = request.getAttribute("lstEvents").toString();

String calId = "";
long fileSize = 0;

List<String> lstFiles = null;
if (request.getAttribute("calId") != null) {
	calId = request.getAttribute("calId").toString();
}

List<CalendarBooking> events = (List<CalendarBooking>) request.getAttribute("events");
CalendarBooking calEventDetaill = null;

HashMap<String, List<String>> fileEntries = (HashMap<String, List<String>>) request.getAttribute("Images");
if (!calId.trim().equals("")) {

	calEventDetaill = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(calId));
} else {
    if(events != null){
        
        for(CalendarBooking calMain : events){
            calEventDetaill = calMain;
            calId = String.valueOf(calMain.getCalendarBookingId());break;
        }        
    }
}
%>
    <%     
    if(calEventDetaill == null){
        %>
        
    
	<c:if test="<%= PermissionUtil.containsCalendar(permissionChecker, scopeGroupId, ActionKeys.ADD_EVENT) %>">
        <c:if test="<%= themeDisplay.isSignedIn() %>">
			<div class="eventCreateWrap block text-right padding-bottom-half">
			    <span class="event-create-cta inline-block ">
			    	<a href="${createPage}" class="btn-primary inline-block">
			    		<span class="inline-block align-middle"><img alt="Add" src="<%= themeImage%>/common/add.png"/></span>
			    		<span class="inline-block align-middle"><liferay-ui:message key="label.create.event" /></span>
			    	</a>
			    </span>
			</div>
		</c:if>
	</c:if>
    <%
    } %>

<div class="event-detail-table block font-none white-bg border-all" id="event-detail-table">


<% if (calEventDetaill != null) { %>
<div class="event-detail-left inline-block align-top width-55">
<% } else { %>
<div class="event-detail-left inline-block align-top width-55" >
    <%} %>
    <% if (calEventDetaill != null) { %>

    <%

        lstFiles = fileEntries.get(String.valueOf(calEventDetaill.getCalendarBookingId()));
        //lstFiles = null;
        if (lstFiles != null && lstFiles.size() != 0) {
            fileSize = lstFiles.size();

            int countFile = 1;
    %>

    <div id="images ">
        <%
            for (String url : lstFiles) {
                if (countFile == 1) { %>

        <img alt="Event Image" id="image<%= countFile %>" src="<%=url %>?version=1.0&imageThumbnail=4" class="aftermove full-width"/>

        <% } else {%>
        <img alt="Event Image" id="image<%= countFile %>" src="<%=url %>?version=1.0&imageThumbnail=4" class="beforemove full-width"/>
        <% }
            countFile++;
        }
            countFile = 1; %>
    </div>

    <div id="sliderevent" class="hide">
        <%
            for (String url : lstFiles) {

        %>

        <a href="#" onclick="changeImage('<%= countFile%>','<%=lstFiles.size() %>')"><img alt="Event Image" src="<%= url %>" height="16" width="16"/></a>
        <% countFile++;
        } %>
    </div>

    <% } else {%>
    <div class="defaultImage full-width full-height align-middle">
    	<figure class="table-cell full-width full-height align-middle text-center">
    		<img alt="Default Image" src="<%= themeImage%>/common/defaultEvent.png" class="emptyimage-eventdetail full-width full-height">
    	</figure>
    </div>
    <%
        }
    } else {
    %>
    <div class="defaultImage full-width full-height align-middle">
	    <figure class="table-cell full-width full-height align-middle text-center">
	    	<img alt="Default Image" src="<%= themeImage%>/common/defaultEvent.png" class="daily-eventdetail full-width full-height">
	    </figure>
    </div>
    <%}%>

</div>
<div class="event-detail-right inline-block align-top width-45 full-height box-sizing-border" id="event-detail-right">
    <%if (calEventDetaill != null) { %>
    <table class="table full-width full-height font-std">

        <tr>
            <td class="event-detail-rightRow1 table-cell padding-half box-sizing-border border-bottom font-none">
                        <span class="event-detail-icon icon-title inline-block line-none align-middle padding-none inline-block box-sizing-border width-5">
                        	<img alt="title" src="<%= themeImage%>/calendar/title.png"/>
                        </span>
                <span class="event-detail-title inline-block align-middle padding-right-quarter box-sizing-border width-90 font-std">
                <%
                String xmlContent = calEventDetaill.getTitle().trim();
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
                	<h2 class="h2"><%= eventTitle %></h2>
                </span>
                <%
                if(themeDisplay.isSignedIn()) {
                 %>
                 	<c:if test="<%= PermissionUtil.containsCalendar(permissionChecker, scopeGroupId, ActionKeys.ADD_EVENT) %>">
	                	<span class="event-detail-add-cta inline-block align-middle width-5 text-right">
		                	<a href="${createPage}" class="inline-block line-none font-none">
		                		<img alt="Add" src="<%= themeImage%>/common/add.png"/><liferay-ui:message key="label.create.event" />
		                	</a>
	                	</span>
               		</c:if>
                <% } %>
            </td>
        </tr>
        <%
            String dateString = String.valueOf(calEventDetaill.getStartTime());

        Calendar scal = null;

           scal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
        scal.setTime(new Date(calEventDetaill.getStartTime()));
        
        Calendar ecal = null;

        ecal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
        ecal.setTime(new Date(calEventDetaill.getEndTime()));
        
            SimpleDateFormat format =
                    new SimpleDateFormat("dd MMM yyyy");
            
            SimpleDateFormat format1 =
                    new SimpleDateFormat("dd MMM");
            
            SimpleDateFormat formatTime =
                    new SimpleDateFormat("HH:mm aa");

            String description = calEventDetaill.getDescription(themeDisplay.getLocale()).trim();
            String mobileDes = "";
            if (description.length() > 200) {
                description = description.substring(0, 199) + "...";
                mobileDes = description.substring(0, 60) + "...";
            } else {
                description = description;

            }
            
            Date StartDate = new Date(calEventDetaill.getStartTime());
            Date EndDate = new Date(calEventDetaill.getEndTime());
            
        	        if(EndDate != StartDate){
        	        	if(ecal.get(Calendar.YEAR) == scal.get(Calendar.YEAR)){
	        	        	if(ecal.get(Calendar.MONTH) == scal.get(Calendar.MONTH)){
	        	        		dateString = scal.get(Calendar.DAY_OF_MONTH) + " - " + format.format(calEventDetaill.getEndTime());
	        	        	}else{
	        	        		dateString = format1.format(calEventDetaill.getStartTime()) + " - " + format.format(calEventDetaill.getEndTime());
	        	        	}
        	        	}else{
        	        		dateString = format.format(calEventDetaill.getStartTime()) + " - " + format.format(calEventDetaill.getEndTime());
        	        	}	
        	        }else{
        	        	dateString = format.format(calEventDetaill.getStartTime());
        	        }
	
        %>
        <tr>
            <td class="event-detail-rightRow1 table-cell box-sizing-border border-bottom font-none">
            		<div class="event-detail-date inline-block align-top padding-half  box-sizing-border half-width font-std">	
            			<span class="event-detail-date-text inline-block align-top box-sizing-border padding-right-quarter">
	                        <span class="event-detail-icon icon-date inline-block align-middle line-none box-sizing-border padding-none">
	                        	<img alt="Calendar" src="<%= themeImage%>/calendar/calendar.png"/>
	                        </span>
	                        <span class="event-detail-text inline-block align-middle font-std">
	                            <%=dateString %>
	                            
	                        </span>
                        </span>
                     </div>
                     <div class="event-detail-time-venue inline-block align-top padding-half box-sizing-border half-width border-left font-std">
                        <span class="event-detail-time-text inline-block align-top box-sizing-border">
	                        <span class="event-detail-icon icon-time align-middle line-none box-sizing-border padding-none inline-block">
	                        
	                        	<img alt="Clock" src="<%= themeImage%>/calendar/clock.png"/>
	                        
	                        </span>
	                        
	                        <span class="event-detail-text inline-block align-middle font-std">
	
	                        
	                        <%
	                            Calendar cal = null;
	                            //if (calEventDetaill.getTimeZone() > 0) { // need to chk this
	
	                               cal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
	                            //} else {
	                                //cal = CalendarFactoryUtil.getCalendar();
	                            //}
	                            cal.setTime(new Date(calEventDetaill.getStartTime()));
	                            
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
	                            cal1.setTime(new Date(calEventDetaill.getEndTime()));
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
	                        %>
	                      
	
	                        <%= df.format(starthour) %>:<%= df.format(startmin) + startPm %> 
	                        - <%= df.format(endhour) %>:<%= df.format(endmin) + endPm %> 
	                        </span>
                        </span>
                        <span class="event-detail-venue-text inline-block align-top box-sizing-border ">
	                		<span class="event-detail-icon icon-venue align-middle line-none box-sizing-border padding-none inline-block">
	                			<img alt="Location" src="<%= themeImage%>/calendar/location.png"/>
	                		</span>
	                		<span class="event-detail-text inline-block align-middle font-std">	
	                			<%= calEventDetaill.getLocation() %>
	                		</span>
                		</span>
                	</div>

            </td>
        </tr>
         <%
                                if (calEventDetaill.getExpandoBridge().getAttributes().get("reference-url") != null) {
                                    if (calEventDetaill.getExpandoBridge().getAttributes().get("reference-url") != "") {
                                        %>       
        <tr>

         
            <td class="event-detail-rightRow1 event-detail-view table-cell padding-half box-sizing-border border-bottom font-none">
                        <span class="event-detail-icon icon-view align-middle line-none box-sizing-border padding-none inline-block">
                            <img alt="Link" src="<%= themeImage%>/calendar/link.png"/>
                        </span>
                        <span class="event-detail-text inline-block align-middle font-std">
                          	
                 
                            <a href="<%= calEventDetaill.getExpandoBridge().getAttributes().get("reference-url") %>"
                               target="_blank" class="urlLink">
								<liferay-ui:message key="label.view.link" />
                            </a>
                        
                        </span>
            </td>
        </tr>
         <%
                                    }
                                }
                            %>
        <tr>
            <td class="event-detail-rightRow1 event-detail-description table-cell padding-half box-sizing-border border-bottom font-std">

                <div class=" " id="normal-description">
                    <span class="event-description-icon event-detail-icon icon-details align-top line-none box-sizing-border padding-none inline-block" >
                    	<img alt="Description" src="<%= themeImage%>/calendar/description.png"/>
                    </span>
                    <span class="event-description event-detail-text inline-block align-top width-95 box-sizing-border font-std"><%= description %></span>
                </div>

                <div id="mobile-description" class="hide">
                    <div class="event-description-icon"><img alt="Description" src="<%= themeImage%>/calendar/description.png"/></div>
                    <div class="event-description font-std" id="divdescription"><span><%= mobileDes %></span></div>

                </div>

               
            </td>
        </tr>
        <tr>
        	<td class="event-detail-rightRow1 event-detail-cta table-cell padding-half box-sizing-border">
        		 <%
                    String rsvpURL = "";
                   /*  if (calEventDetaill.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
                        rsvpURL = calEventDetaill.getExpandoBridge().getAttributes().get("rsvp-url").toString();
                    } */
                %>
                <portlet:actionURL var="eventDetailURL">
					<portlet:param name="action" value="eventDetail" />
					
				</portlet:actionURL>
                <div class="event-detail-CTA event-cta text-right">
                    <div class="btn-readmore inline-block align-middle box-sizing-border">
                    	<input type="hidden" name="currentEventId" id="currentEventId" value="<%=calEventDetaill.getCalendarBookingId() %>">
	                  <a class="inline-block btn-primary read-more"
	                            href="${pageName}/-/event/view_event/<%=calEventDetaill.getCalendarBookingId() %>?flagDetail=${flagDetail}"><liferay-ui:message key="label.read.more" />
	                           	</a> 
                    </div>
                     <%

                        if (calEventDetaill.getExpandoBridge().getAttributes().get("rsvp-url") != null) {
                            if (calEventDetaill.getExpandoBridge().getAttributes().get("rsvp-url").toString().trim().length() > 0) {

                    %> 
                    <div class="btn-rsvp inline-block align-middle padding-left-quarter box-sizing-border">
                    	<a class="inline-block btn-primary read-more" href="<%= rsvpURL%>">
                        <%if (calEventDetaill.getExpandoBridge().getAttributes().get("rsvp-label") != null) {%>

                        <%=calEventDetaill.getExpandoBridge().getAttributes().get("rsvp-label") %> 
						 <liferay-ui:message key="label.rsvp" />
                      <%} else { %>
                        <liferay-ui:message key="label.rsvp" />
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
		<figure class="table-cell full-width full-height align-middle text-center line-none">
			<img alt="No Event" class="full-width block" src="<%= themeImage%>/common/no_event.jpg" />
		</figure>
    </div>
    <% } %> 
</div>

</div>

<div class="allevent-div">
    <form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>">
                </portlet:actionURL>" class="uni-form" method="post" name="<portlet:namespace />fm" id="myform">
        <input type="hidden" value="<%= calId %>" name="<portlet:namespace />calId" id="calId"/>
        <input type="hidden" value="<%= fileSize %>" name="<portlet:namespace />fileSize" id="fileSize"/>
        <input type="hidden" value="<%= lstFiles %>" name="<portlet:namespace />lstFiles" id="lstFiles"/>

        <div class="event-filter block text-right padding-top-quarter padding-bottom-quarter">
        	<div class="filter-dropdown dropdown-single inline-block box-sizing-border align-middle">
	            <span class="hide"><liferay-ui:message key="label.filter.by" /></span>
	            <select name="<portlet:namespace />eventFilter" id="eventFilter" onChange="filterEvents()">
	                <option value="Summary"> Current & Upcoming Events</option>
	                <option value="All Events"> All Events</option>
	                <option value="Past Events"> Past Events</option>
	                <option value="Upcoming Events"> Upcoming Events</option>
	                <option value="Current Events"> Current Events</option>
	
	            </select>
            </div>
            <div class="filter-textInput text-input inline-block box-sizing-border padding-left-quarter align-middle">
            	<span class="hide"><liferay-ui:message key="label.filter.title" /></span>
	            <input type="text" name="<portlet:namespace />filterTitle" placeholder="Search by Title" id="filterTitle" onblur="filterEvents()"
	                   onkeydown="if (event.keyCode == 13) {filterEvents();return false;}"/>
            </div>
            

        </div>
        <div id="detailEve" class="block">
            <%= innerHTML%>
        </div>

		<div>
		</div>
	</form>

</div>

</div>
<portlet:defineObjects/>
<script type="text/javascript">
	<!--

	//-->

	AUI().ready(function(A) {
		fetchEvents(window.innerWidth, '0');

	});
</script>
<script>

	function fetchEvents(clientWidth, monthIndex) {
		var e = document.getElementById("eventFilter");
		var filter = e.options[e.selectedIndex].value;
		if (clientWidth >= 1280) {
			clientWidth = 1280;
		}

		var title = document.getElementById("filterTitle");
		var filterTitle = title.value;
		console.log("reqRenUrl " + reqRenUrl);
		var reqRenUrl = '<portlet:resourceURL id="" />' + '&clientWidth=' + clientWidth + '&CMD=fetchLstEvents&monthIndex=' + monthIndex + "&filter=" + filter + "&filterTitle=" + filterTitle;
	
		if (window.XMLHttpRequest) {
			var reqRender = new XMLHttpRequest();
			reqRender.open("POST", reqRenUrl, true);
			reqRender.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			reqRender.onreadystatechange = function() {
				if (reqRender.readyState == 4 && reqRender.status == 200) {
					document.getElementById("detailEve").innerHTML = reqRender.responseText;

				}
			}
			reqRender.send();
		}
	}

	function filterEvents() {

		var e = document.getElementById("eventFilter");
		var filter = e.options[e.selectedIndex].value;
		var title = document.getElementById("filterTitle");
		var filterTitle = title.value;

		var cw = window.innerWidth;

		if (cw >= 1280) {
			cw = 1280;
		}

		var reqRenUrl = '<portlet:resourceURL id="" />' + '&clientWidth=' + cw + '&CMD=fetchLstEventsByType&filter=' + filter + "&filterTitle=" + filterTitle;

		if (window.XMLHttpRequest) {
			var reqRender = new XMLHttpRequest();
			reqRender.open("POST", reqRenUrl, true);
			reqRender.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			reqRender.onreadystatechange = function() {
				if (reqRender.readyState == 4 && reqRender.status == 200) {
					document.getElementById("detailEve").innerHTML = reqRender.responseText;
				}
			}
			reqRender.send();
		}

	}
	function loadEventDetail(eventId) {
		document.getElementById("calId").value = eventId;
		readMore(eventId);
		//document.getElementById("myform").submit();
	}

	function readMore(eventId) {
		var reqRenUrl = '<portlet:resourceURL id="" />' + '&clientWidth=' + window.innerWidth + '&CMD=readMore&eventId=' + eventId;
		if (window.XMLHttpRequest) {
			var reqRender = new XMLHttpRequest();
			reqRender.open("POST", reqRenUrl, true);
			reqRender.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			reqRender.onreadystatechange = function() {
				if (reqRender.readyState == 4 && reqRender.status == 200) {
					document.getElementById("event-detail-table").innerHTML = reqRender.responseText;
				}
			}
			reqRender.send();

		}
	}

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

	var req;
	var reqUrl;

	// Get an XMLHttpRequest object in a portable way.
	function newRequest(currentMonth, currentYear, flag, pageno) {
		var e = document.getElementById("eventFilter");
		var filter = e.options[e.selectedIndex].value;

		var title = document.getElementById("filterTitle");
		var filterTitle = title.value;

		req = false;
		reqUrl = '<portlet:resourceURL id="" />' + '&currentMonth=' + currentMonth + "&currentYear=" + currentYear + '&flag=' + flag + '&pageno=' + pageno + '&clientWidth=' + window.innerWidth + '&CMD=shiftEvents&filter=' + filter + "&filterTitle=" + filterTitle;

		// For Safari, Firefox, and other non-MS browsers
		if (window.XMLHttpRequest) {
			try {
				req = new XMLHttpRequest();
				req.open("POST", reqUrl, true);
				req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				req.onreadystatechange = function() {
					if (req.readyState == 4 && req.status == 200) {
						var data = req.responseText;
						document.getElementById("main-" + currentMonth + "-" + currentYear).innerHTML = data;
					}

				}
				req.send();
			} catch (e) {
				req = false;
			}
		} else if (window.ActiveXObject) {
			// For Internet Explorer on Windows
			try {
				req = new ActiveXObject("Msxml2.XMLHTTP");
				req.send();
			} catch (e) {
				alert(e);
				try {
					alert(new ActiveXObject("Microsoft.XMLHTTP"));
					req = new ActiveXObject("Microsoft.XMLHTTP");
					req.send();
				} catch (e) {
					req = false;
				}
			}
		}
	}

	(function(win, documentElement) {

		var addEvent = (win.addEventListener) ? function(type, node, fn) {
					node.addEventListener(type, fn, false);
				} : function(type, node, fn) {
					node.attachEvent(
							'on' + type,
							function(e) {
								fn.apply(node, [e]);
							}
					);
				},

		// Debounce function
				debounce = function(func, threshold) {
					var timeout;
					return function() {
						var obj = this,
								args = arguments,
								delayed = function() {
									func.apply(obj, args);
									timeout = null;
								};
						if (timeout) clearTimeout(timeout);
						timeout = setTimeout(delayed, 50);
					};
				},

				viewportChange = function() {
					fetchEvents(window.innerWidth);
					var width = 1220;
					var diffWidth = screen.width - window.innerWidth;
					var diff = 0;

				};

		// Attach function to events
		addEvent('resize', win, debounce(viewportChange));
		addEvent('orientationchange', win, viewportChange);

		viewportChange();
	})(this, document.documentElement);

</script>
