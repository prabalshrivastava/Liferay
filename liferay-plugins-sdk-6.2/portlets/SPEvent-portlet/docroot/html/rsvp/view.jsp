
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.calendar.model.CalendarBooking" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.model.Theme" %>
<%@ page import="com.liferay.portal.service.ThemeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@ page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %>

<%@ page import="com.sambaash.platform.model.RsvpStatus" %>
<%@ page import="com.sambaash.platform.portlet.spevent.util.CalUtil" %>

<%@ page import="java.text.SimpleDateFormat" %>

<%@ include file="/html/common/init.jsp" %>

<portlet:defineObjects/>

<liferay-theme:defineObjects/>

<c:choose>
	<c:when test="${signInFlag && !themeDisplay.signedIn}">
		<h3>You don't have the permission to access this page!"</h3>
	</c:when>
	<c:otherwise>

		<style>
		    .error {
		        border: 1px solid red !important;
		    }

		    .msg {
		        width: 100%;
		        text-align: center;
		        vertical-align: middle;
		        padding-top: 30px;
		        font-size: 20px;
		    }
		</style>

		<% if (request.getAttribute("thankYouMsgWithoutPayment") != null) {
		%>

		<meta HTTP-EQUIV="REFRESH" content="10; url=<%= PortalUtil.getPortalURL(request) %>">
		<div id="paypalThankYou">
		    <br>
		    <br>
		    <br>
		    <div class="msg"><h1>Registration completed successfully.<h1>
		    <br>
		    <h3>You will be redirected in 10 seconds ....</h3> </div>
		</div>
		<% } else if (request.getAttribute("thankyouMsg") != null) {
		%>

		<meta HTTP-EQUIV="REFRESH" content="10; url=<%= PortalUtil.getPortalURL(request) %>">
		<div id="paypalThankYou">
		    <br>
		    <br>
		    <br>
		    <br>
		    <div class="msg"><h1>Thank you for your payment.<h1>
		    <br>
		    <h1>Your transaction has been completed successfully and a receipt for your purchase has been emailed to you. </h1>
		    <br>
		    <h3>You will be redirected in 10 seconds ....</h3></div>
		</div>

		<%
		    } else if (request.getAttribute("cancelMsg") != null) {
		%>
		<meta HTTP-EQUIV="REFRESH" content="10; url=<%=PortalUtil.getPortalURL(request)%>">
		<div id="paypalCancel" class="msg">
		    <br>
		    <br>
		    <br>
		    <br>
		    <div class="msg"><h1>Your transaction has been cancelled.</h1>
		    <br>
		    <h3>You will be redirected in 10 seconds ....</h3> </div>
		</div>

		<%
		    } else if (request.getAttribute("paypal") != null) {
		%>

		<script type="text/javascript">

		    AUI().ready(function(A) {
		        A.one("#paypalForm").submit();
		    });
		</script>
		<div class="msg" id="paypal">
		<form method="post" action="${paypal.paypalGatewayURL}" id="paypalForm" name="paypalForm" >
		    <input name="<portlet:namespace />cmd" type="hidden" value="_xclick"/>
		    <input name="<portlet:namespace />business" type="hidden" value="${paypal.paypalId}"/>
		    <input name="<portlet:namespace />lc" type="hidden" value="${paypal.location}"/>
		    <input name="<portlet:namespace />item_name" type="hidden" value="${paypal.itemName}"/>
		    <input name="<portlet:namespace />amount" type="hidden" value="${paypal.total}"/>
		    <input name="<portlet:namespace />currency_code" type="hidden" value="${paypal.currencyCode}"/>
		    <input name="<portlet:namespace />button_subtype" type="hidden" value="${paypal.subType}"/>
		    <input name="<portlet:namespace />no_shipping" type="hidden" value="${paypal.shippingFlag}"/>
		    <input name="<portlet:namespace />quantity" type="hidden" value="${paypal.quantity}"/>
		    <input name="<portlet:namespace />rm" type="hidden" value="${paypal.returnMethod}"/>
		    <input name="<portlet:namespace />return" type="hidden" value="${paypal.returnURL}"/>
		    <input name="<portlet:namespace />cancel_return" type="hidden" value="${paypal.cancelURL}"/>
		    <input name="<portlet:namespace />tax_rate" type="hidden" value="${paypal.taxRate}"/>
		    <input name="<portlet:namespace />shipping" type="hidden" value="${paypal.shippingRate}"/>
		    <input name="<portlet:namespace />cpp_logo_image" type="hidden" value="${paypal.logoUrl}"/>
		    <input name="<portlet:namespace />notify_url" type="hidden" value="${paypal.notificationURL}"/>
		    <input name="<portlet:namespace />image_url" type="hidden" value="${paypal.logoUrl}"/>
		    <input name="<portlet:namespace />cpp_payflow_color" type="hidden" value="${colorCode}"/>
		    <input name="<portlet:namespace />custom" type="hidden" value="${paypal.itemNumber}"/>
		    <input type="image" src="${paypal.imgURL1}" border="0"
		           name="submit" alt="PayPal - The safer, easier way to pay online!">
		    <img alt="PayPal Image" border="0" src="${paypal.imgURL2}" width="1"
		         height="1" />
		</form>
		<div>Redirecting to Paypal... please wait...</div>
		</div>

		<% } else {

		    CalendarBooking event = null;
		    String location = StringPool.BLANK;
		    if (request.getAttribute("event") != null) {
		        event = (CalendarBooking) request.getAttribute("event");
		        location = event.getLocation();
		    }
		    String email = StringPool.BLANK;
		    if (request.getAttribute("email") != null) {
		        email = request.getAttribute("email").toString();
		    }

		    String dynamicSectionName = StringPool.BLANK;
		    if (request.getAttribute("dynamicSectionName") != null) {
		    	dynamicSectionName = request.getAttribute("dynamicSectionName").toString();
		    }

		    String firstName = StringPool.BLANK;
		    if (request.getAttribute("firstName") != null) {
		        firstName = request.getAttribute("firstName").toString();
		    }

		    String lastName = StringPool.BLANK;
		    if (request.getAttribute("lastName") != null) {
		        lastName = request.getAttribute("lastName").toString();
		    }

		    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		    SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm aa");
		    String sbUserProfile = StringPool.BLANK;
		    if (request.getAttribute("userprofile") != null) {
		        sbUserProfile = request.getAttribute("userprofile").toString();
		    }

		    String subStringIndi = StringPool.BLANK;
		    if (renderRequest.getAttribute("subStringIndi") != null) {
		        subStringIndi = renderRequest.getAttribute("subStringIndi").toString();
		    }

		    String validationField = StringPool.BLANK;
		    if (renderRequest.getAttribute("validateField") != null) {
		        validationField = renderRequest.getAttribute("validateField").toString();
		    }

		    String mandatoryField = StringPool.BLANK;
		    if (renderRequest.getAttribute("mandatoryField") != null) {
		        mandatoryField = renderRequest.getAttribute("mandatoryField").toString();
		    }

		    String title = StringPool.BLANK;
		    if (request.getAttribute("title") != null) {
		        title = String.valueOf(request.getAttribute("title"));
		    }

		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		    boolean canEdit = false;
		    if (request.getAttribute("canEdit") != null) {
		        canEdit = Boolean.parseBoolean(String.valueOf(request.getAttribute("canEdit")));
		    }
		%>

		<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>">
		                  <portlet:param name="action" value="rsvpAction" />
		              </portlet:actionURL>" class="uni-form" method="post" name="fm" id="fm">
		<input type="hidden" name="<portlet:namespace />dynamicSectionName" id="dynamicSectionName" value="<%=dynamicSectionName %>"/>
		<input type="hidden" name="<portlet:namespace />validateField" id="validateField" value="<%=validationField %>"/>
		
		<div class="rsvp-maindiv">

		<div class="rsvpbox-title">
		    Registration
		</div>
		<div class="rsvpevent-title">
		    <%= title %>
		</div>
		<div class="body-rsvp">
		<c:if test="${!empty event}">

		    <div class="rsvp-leftbox">
		        <div class="rsvp-leftevent-box">
		            <div class="rsvp-leftbox-eventdetailheader">
		                <span class="rsvp-leftbox-titlelogo"><img
		                        src="<%= themeDisplay.getPathThemeImage() %>/calendar/calendar.png" alt="Calendar"/></span>
		                <span class="rsvp-leftbox-title">When & Where</span>
		            </div>
		            <div class="rsvp-leftbox-eventsummary">
		                <span style="color: #F2F2F2;font-size: 15px;"><%= event.getLocation() %></span>
		                <br />
		                <br />
		                <span style="color:#666666;font-size:13px;font-style: italic;"><%= dateFormat.format(event.getStartTime()) %> &nbsp;from &nbsp;<%= formatTime.format(event.getStartTime()) %>
		                &nbsp;to&nbsp;<%= formatTime.format(CalUtil.getEndTime(event)) %></span>

		            </div>

		        </div>

		        <div class="rsvp-leftevent-box">
		            <div class="rsvp-leftbox-eventdetailheader">
		                <span class="rsvp-leftbox-titlelogo"><img
		                        src="<%= themeDisplay.getPathThemeImage() %>/calendar/location.png" alt="Location"/></span>
		                <span class="rsvp-leftbox-title">Location</span>
		            </div>
		            <div style="background: none repeat scroll 0 0 #FCBE16;height: 100px;">
		                <div id="geoMap">
		                    <article>
		                    </article>
		                </div>
		            </div>

		        </div>

		    </div>

		</c:if>

		<c:choose>
		    <c:when test="${empty event}">
		        <div class="rsvp-form" id="rsvp-form">
		    </c:when>

		    <c:otherwise>
		        <div class="rsvp-form" id="rsvp-form">
		    </c:otherwise>
		</c:choose>

		<c:if test="${empty notAttend}">
		    <c:if test="${empty step }">
		        <%if (!canEdit) { %>
		        <div id="successMsgTemplate"
		             style="background:#f2f2f2;color:red;font-weight:bold;margin-top:10px;padding:10px;height:18px;width:97%;margin-bottom:10px;">
		            RSVP is closed.
		        </div>
		        <%} else { %>
		        <div id="singleDiv">
		            <div class='rsvp-label'>
		                <div style='width:40%;display:inline-block;vertical-align: top;'><span
		                        class='pets-rsvp-label'>Email<font style="color:red;">*</font></span></div>
		                <div style='width:58%;display:inline-block'>
		                    <c:if test="${!isSignIn}">
		                        <input type="text" id="email" name="<portlet:namespace />email" value="<%= email%>" class="rsvp-textbox"
		                               required="required"/>
		                    </c:if>
		                    <c:if test="${isSignIn}">
		                        <c:if test="${!isAdmin}">
		                            <input type="text" id="email" name="<portlet:namespace />email" disabled="disabled"
		                                   value="<%= email%>" class="rsvp-textbox" required="required"/>
		                        </c:if>
		                        <c:if test="${isAdmin}">
		                            <input type="text" id="email" name="<portlet:namespace />email" value="<%= email%>"
		                                   class="rsvp-textbox" required="required"/>
		                        </c:if>
		                    </c:if>
		                </div>
		            </div>
		            <c:if test="${passwordFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Password<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="password"  id="password" name="<portlet:namespace />password" 
			                          class="rsvp-textbox" required="required" autocomplete="off"/>
			                </div>
			            </div>
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Retype Password<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="password"  id="reTypePassword" name="<portlet:namespace />reTypePassword" 
			                          class="rsvp-textbox" required="required" autocomplete="off" onblur="javascript:validatePassword('password','reTypePassword');"/>
			                </div>
			            </div>
		            </c:if>

		            <div class='rsvp-label'>
		                <div style='width:40%;display:inline-block;vertical-align: top;'><span
		                        class='pets-rsvp-label'>First Name<font style="color:red;">*</font></span></div>
		                <div style='width:58%;display:inline-block'>
		                    <input type="text"  id="firstName" name="<portlet:namespace />firstName" value="<%= firstName%>"
		                          class="rsvp-textbox" required="required"/>
		                </div>
		            </div>
		            <div class='rsvp-label'>
		                <div style='width:40%;display:inline-block;vertical-align: top;'><span
		                        class='pets-rsvp-label'>Last Name<font style="color:red;">*</font></span></div>
		                <div style='width:58%;display:inline-block'>
		                    <input type="text" id="lastName" name="<portlet:namespace />lastName" value="<%= lastName%>"
		                           class="rsvp-textbox" required="required"/>
		                </div>
		            </div>

		            <c:if test="${identificationTypeFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Identification Type<font style="color:red;">*</font></span>
			                </div>
			                <div style='width:58%;display:inline-block'>
			                    <select id="identificationType" name="<portlet:namespace />identificationType">
			                    <option value="" selected="selected"><c:out value=''/></option> 
			                    <c:forEach var="assetCategory" items="${identificationTypeList}">
			                        <option value="${assetCategory.name}"><c:out value='${assetCategory.name}'/></option>
			                    </c:forEach>
			                    </select>
			                </div>
			            </div>
		            </c:if>

					<c:if test="${identificationNumberFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Identification Number<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="identificationNumber" name="<portlet:namespace />identificationNumber" 
			                           class="rsvp-textbox" required="required"/>
			                </div>
			            </div>
		            </c:if>

					<c:if test="${streetAddress1Flag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Street Address 1<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="streetAddress1" name="<portlet:namespace />streetAddress1" 
			                           class="rsvp-textbox" required="required" maxlength="200"/>
			                </div>
			            </div>
		            </c:if>
		            <c:if test="${streetAddress2Flag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Street Address 2</span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="streetAddress2" name="<portlet:namespace />streetAddress2" 
			                           class="rsvp-textbox" maxlength="200"/>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${postalCodeFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Postal Code<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="postalCode" name="<portlet:namespace />postalCode" 
			                           class="rsvp-textbox" required="required" maxlength="10"/>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${cityFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>City<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="city" name="<portlet:namespace />city" 
			                           class="rsvp-textbox" required="required"/>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${countryFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Country<font style="color:red;">*</font></span>
			                </div>
			                <div style='width:58%;display:inline-block'>
			                    <select id="countryId" name="<portlet:namespace />countryId">
			                    <option value="" selected="selected"><c:out value=''/></option>    
			                    <c:forEach var="country" items="${countries}">
			                        <option value="${country.name}"><c:out value='${country.name}'/></option>
			                    </c:forEach>
			                    </select>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${stateFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>State<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="state" name="<portlet:namespace />state" 
			                           class="rsvp-textbox" required="required"/>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${genderFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Select Gender</span>
			                </div>
			                <div style='width:58%;display:inline-block'>
			                    <select id="genderId" name="<portlet:namespace />genderId">
			                     <option value="" selected="selected"><c:out value=''/></option>  
			                     <option value="Female"><c:out value='Female'/></option>
			                     <option value="Male"><c:out value='Male'/></option>
			                    </select>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${phoneNumber1Flag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Phone Number<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                	<input type="text" id="phoneNumber1CountryCode" name="<portlet:namespace />phoneNumber1CountryCode" 
			                           class="rsvp-textbox" required="required" value="65" style="width:50px;display:inline-block;" maxlength="3"/>
			                    <input type="text" id="phoneNumber1" name="<portlet:namespace />phoneNumber1" 
			                           class="rsvp-textbox" required="required" style="width:83%;display:inline-block;"/>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${phoneNumber2Flag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Phone Number 2</span><span style="color:red;"></span></div>
			                <div style='width:58%;display:inline-block'>
			                	<input type="text" id="phoneNumber2CountryCode" name="<portlet:namespace />phoneNumber2CountryCode" 
			                           class="rsvp-textbox" value="65" maxlength="3" style="width:50px;display:inline-block;"/>
			                    <input type="text" id="phoneNumber2" name="<portlet:namespace />phoneNumber2" 
			                           class="rsvp-textbox" style="width:83%;display:inline-block;"/>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${ageGroupFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Age Group<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
			                	<select id="ageGroup" name="<portlet:namespace />ageGroup">    
				                    <c:forEach var="assetCategory" items="${ageGroupList}">
				                        <option value="${assetCategory.name}"><c:out value='${assetCategory.name}'/></option>
				                    </c:forEach>
			                    </select>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${hearAboutUsFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>How did you hear about us?<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
				                <select id="hearAboutUs" name="<portlet:namespace />hearAboutUs">
				                    <option value="" selected="selected"><c:out value=''/></option>
				                	<c:forEach var="assetCategory" items="${hearAboutUsList}">
				                   		<option value="${assetCategory.name}"><c:out value='${assetCategory.name}'/></option>
				                    </c:forEach>
				                </select>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${attendedWebinarFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Have you attended a Webinar about Introduction to Inner Engineering?<font style="color:red;">*</font></span>
			                </div>
			                <div style='width:58%;display:inline-block'>
			                    <select id="attendedWebinar" name="<portlet:namespace />attendedWebinar">
			                     <option value="" selected="selected"><c:out value=''/></option>  
			                     <option value="Yes"><c:out value='Yes'/></option>
			                     <option value="No"><c:out value='No'/></option>
			                    </select>
			                </div>
			            </div>
		            </c:if>

		            <c:if test="${numberOfPeopleFlag}">
		            <div class='rsvp-label'>
		                <div style='width:40%;display:inline-block;vertical-align: top;'><span
		                        class='pets-rsvp-label'>Number of People<font style="color:red;">*</font></span>
		                </div>
		                <div style='width:58%;display:inline-block'>
		                    <c:if test="${!empty noOfPeople}">
		                        <input type="text" id="noOfPeople" name="<portlet:namespace />noOfPeople" value="${noOfPeople}"
		                               class="rsvp-textbox" required="required" onchange="multipleRegister()"/>
		                    </c:if>
		                    <c:if test="${empty noOfPeople}">
		                        <input type="text" id="noOfPeople" name="<portlet:namespace />noOfPeople" value="1" class="rsvp-textbox"
		                               required="required" onchange="multipleRegister()"/>
		                    </c:if>
		                </div>
		            </div>
		            </c:if>
		            <c:if test="${customList1Flag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>${customList1Label}<font style="color:red;">*</font></span></div>
			                <div style='width:58%;display:inline-block'>
				                <select id="customField1" name="<portlet:namespace />customField1">
				                    <option value="" selected="selected"><c:out value=''/></option>
				                	<c:forEach var="assetCategory" items="${customList1}">
				                   		<option value="${assetCategory.name}"><c:out value='${assetCategory.name}'/></option>
				                    </c:forEach>
				                </select>
			                </div>
			            </div>	
		            </c:if>		            
		            
		            <c:if test="${!numberOfPeopleFlag}">
		            	 <input type="hidden" id="noOfPeople" name="<portlet:namespace />noOfPeople" value="1" class="rsvp-textbox"
		                               required="required"/>
		            </c:if>
		
		            <%=sbUserProfile %>
		
		            <c:if test="${!defaultStatusFlag}">
		            <div class='rsvp-label'>
		                <div style='width:40%;display:inline-block;vertical-align: top;'><span
		                        class='pets-rsvp-label'>RSVP status<font style="color:red;">*</font></span></div>
		                <div style='width:58%;display:inline-block'>
		                    <select name="<portlet:namespace />rsvpStatus" id="rsvpStatus">
		                        <c:if test="${rsvpStatus == 1 }">
		                            <option label="<%= RsvpStatus.ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.ATTENDING.ordinal() %>"
		                                    selected><%= RsvpStatus.ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.NOT_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.NOT_ATTENDING.ordinal() %>"><%= RsvpStatus.NOT_ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.MAYBE_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.MAYBE_ATTENDING.ordinal() %>"><%= RsvpStatus.MAYBE_ATTENDING.getValue() %>
		                            </option>
		                        </c:if>

		                        <c:if test="${rsvpStatus == 2 }">
		                            <option label="<%= RsvpStatus.ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.ATTENDING.ordinal() %>"><%= RsvpStatus.ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.NOT_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.NOT_ATTENDING.ordinal() %>"
		                                    selected="selected"><%= RsvpStatus.NOT_ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.MAYBE_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.MAYBE_ATTENDING.ordinal() %>"><%= RsvpStatus.MAYBE_ATTENDING.getValue() %>
		                            </option>
		                        </c:if>

		                        <c:if test="${rsvpStatus == 3 }">
		                            <option label="<%= RsvpStatus.ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.ATTENDING.ordinal() %>"><%= RsvpStatus.ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.NOT_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.NOT_ATTENDING.ordinal() %>"><%= RsvpStatus.NOT_ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.MAYBE_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.MAYBE_ATTENDING.ordinal() %>"
		                                    selected="selected"><%= RsvpStatus.MAYBE_ATTENDING.getValue() %>
		                            </option>
		                        </c:if>

		                        <c:if test="${empty rsvpStatus}">
		                            <option label="<%= RsvpStatus.ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.ATTENDING.ordinal() %>"
		                                    selected><%= RsvpStatus.ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.NOT_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.NOT_ATTENDING.ordinal() %>"><%= RsvpStatus.NOT_ATTENDING.getValue() %>
		                            </option>
		                            <option label="<%= RsvpStatus.MAYBE_ATTENDING.getValue() %>"
		                                    value="<%= RsvpStatus.MAYBE_ATTENDING.ordinal() %>"><%= RsvpStatus.MAYBE_ATTENDING.getValue() %>
		                            </option>
		                        </c:if>
		                    </select>
		                </div>
		            </div>
		            </c:if>


		
		            <input type="hidden" id="price" name="<portlet:namespace />price" value="${price}"/>
		            <input type="hidden" id="minPriceToCompare" name="<portlet:namespace />minPriceToCompare" value="${price}"/>
		            <input type="hidden" id="tax" name="<portlet:namespace />tax" value="${tax}"/>
		            <input type="hidden" id="currency" name="<portlet:namespace />currency" value="${currency}"/>
		            <input type="hidden" id="multiRegFlag" name="<portlet:namespace />multiRegFlag" value="${multiRegFlag}"/>
		            <input type="hidden" id="paymentFlag" name="<portlet:namespace />paymentFlag" value="${paymentFlag}"/>
		            <input type="hidden" id="numberOfPeopleFlag" name="<portlet:namespace />numberOfPeopleFlag" value="${numberOfPeopleFlag}"/>
		            <input type="hidden" id="discountFlag" name="<portlet:namespace />discountFlag" value="${discountFlag}"/>
		            <input type="hidden" id="promoCodeFlag" name="<portlet:namespace />promoCodeFlag" value="${promoCodeFlag}"/>
		            <input type="hidden" id="mandatoryFlagChild" name="<portlet:namespace />mandatoryFlagChild" value="${mandatoryFlagChild}"/>
		            <input type="hidden" id="discountValue" name="<portlet:namespace />discountValue" value="${discountValue}"/>
		             <input type="hidden" id="eventFlag" name="<portlet:namespace />eventFlag" value="${eventFlag}"/>
		            
		            <c:if test="${paymentFlag == 'true' }">
		                <div class='rsvp-label'>
		                    <div style='width:40%;display:inline-block;vertical-align: top;'><span
		                            class='pets-rsvp-label'>Amount<font style="color:red;">*</font></span>
		                    </div>
		                    <div style='width:58%;display:inline-block'>

		                                <c:if test="${priceListFlag == 'true'}">
		                                    <select id="priceList" name="<portlet:namespace />priceList" onChange="javascript:getNetTotal('priceList');">
		                                        <option value=""></option>
		                                        <c:forEach var="pList" items="${priceList}">
		                                        	<c:if test="${pList.quantity != pList.soldQuantity}">
		                                        		 <option value="${pList.spRsvpTicketId }"><c:out value='${pList.price }'/></option>
		                                        	</c:if>

		                                        </c:forEach>
		                                    </select>
		                                </c:if>

		                                <c:if test="${miniPriceFlag == 'true'}">
		                                    <input type="text" id="minPrice" name="<portlet:namespace />minPrice" value="${defaultPrice}" style="width:70px;" onchange="getNetTotal('minPrice')"/>
		                               </c:if>

		                                <c:out value=" ${currency}" />
		                    </div>
		                </div>

			            <c:if test="${promoCodeFlag}">
			            <div class='rsvp-label'>
			                <div style='width:40%;display:inline-block;vertical-align: top;'><span
			                        class='pets-rsvp-label'>Promo Code</span></div>
			                <div style='width:58%;display:inline-block'>
			                    <input type="text" id="promoCode" name="<portlet:namespace />promoCode" value=""
			                           class="rsvp-textbox" required="required" onblur="javascript:getNetTotal('promoCode');" />
			                </div>
			            </div>
			            </c:if>
		                </c:if>
		                <div id="multiregdiv">&nbsp;</div>
		                <c:if test="${paymentFlag == 'true' }">
		                <div id="priceDiv">

		                	<div style="float:right">*<c:out value=" ${currency}" />
		                	<%--
		                	<c:if test="${discountFlag}"><br />* 10% Discount till 30th Nov 2013</c:if>
		                	--%>
		                	</div>

		                    <table style="width:100%;border:1px solid #c5c5c5;background:#f8f8f8;padding-top: 10px; padding-right: 10px; padding-bottom: 10px; margin: 10px 10px 10px 0px; float: left; width: 98%;">
		                        <c:if test="${numberOfPeopleFlag}">
		                        <tr>
		                            <td style="padding:10px;">Amount</td>
		                            <td style="padding:10px;" id="priceCol">
		                                ${price}</td>
		                        </tr>
			                        <tr style="">
			                            <td style="padding:10px;">Number of People</td>
			                            <td style="padding:10px;">1</td>
			                        </tr>
			                     </c:if>
		                        <c:if test="${tax != '0'}">
		                        <tr style="">
		                            <td style="padding:10px;">Tax
		                            </td>
		                            <td style="padding:10px;"><c:out value="${tax}" />%</td>
		                        </tr>
		                        </c:if>

		                        <c:if test="${discountFlag}">
		                        	<tr style="">
			                            <td style="padding:10px;" id="discountColLbl">Discount
			                            </td>
			                            <td style="padding:10px;" id="discountCol">0</td>
		                        	</tr>
		                        </c:if>

		                        <%
		                                double price = 0;
		                                double tax = 0;
		                                double taxAmount = 0;
		                                String currency = "SGD";
		                                DecimalFormat doubleFT = null;
		                                if ((renderRequest.getAttribute("price") != null) && (renderRequest.getAttribute("price") != "")) {
		                                    price = Double.parseDouble(renderRequest.getAttribute("price").toString());
		                                    tax = Double.parseDouble(renderRequest.getAttribute("tax").toString());
		                                    currency = renderRequest.getAttribute("currency").toString();
		                                    doubleFT = new DecimalFormat("#.##");
		                                    taxAmount = (price * (tax / 100))+0.00;
		                                }
		                         %>

		                        <tr>
		                            <td style="padding:10px;">
		                                Net Total
		                            </td>
		                            <td style="padding:10px;" id="netTotalCol">
		                                <%= (taxAmount + price) %>
		                            </td>
		                        </tr>
		                    </table>

		                </div>

		            </c:if>
		        </div>

		        <c:if test="${ageRestrictionFlag}">
					<div class='rsvp-label'>
						<input type="checkbox" name="<portlet:namespace />ageRestriction"
							id="ageRestriction" /><span style="padding-left: 10px;">
							I certify that I am 14 years or older<font style="color:red;">*</font></span>

					</div>
				</c:if>

		        <c:if test="${termsOfUseFlag}">
					<div class='rsvp-label'>
						<input type="checkbox" name="<portlet:namespace />termsOfUse"
							id="termsOfUse" /><span style="padding-left: 10px;">
							I agree to the Terms and Conditions<font style="color:red;">*</font></span>
					</div>
				</c:if>

		        <div style="text-align:center;padding-top: 15px;">
		            <%if (canEdit) { %>
		            <c:choose>
		                <c:when test ="${paymentFlag}">
		                    <a onclick="validatePhone();">
		                        <img src="<%= themeDisplay.getPathThemeImages() %>/paypal/btn_xpressCheckout.gif" alt="CheckOut"/>
		                    </a>
		                </c:when>
		                <c:otherwise>
		                    <input type="button" value="Save" onclick="validatePhone();" class="btn-primary"/>
		                </c:otherwise>
		            </c:choose>
		            <%} else { %>
		            	<input type="button" value="Save" onclick="validatePhone();" class="btn-primary" disabled/>
		            <%} %>
		        </div>
		        <% } %>
		    </c:if>

		    <c:if test="${!empty step}">
		        <%= subStringIndi %>
		    </c:if>
		</c:if>
		<c:if test="${!empty notAttend}">
		    <div style="background:#f2f2f2;green;font-weight:bold;margin-top:10px;padding:10px;height:18px;width:97%;margin-bottom:10px;">
		        Thank you!
		    </div>
		</c:if>
		</div>
		</div>

		</div>

		</form>

		<script src="https://maps.google.com/maps/api/js?sensor=false" type="text/javascript"></script>
		<script type="text/javascript">

		function getNetTotal(id) {
		    var priceSelected = 0;
		    var promoCodeInput = document.getElementById("promoCode");
			var promoCode = "";
			if (promoCodeInput) {
				promoCode = promoCodeInput.value;
			}

			if (id == "priceList") {
		        var priceSel = document.getElementById("priceList");
		        priceSelected = getTicketPrice(priceSel.options[priceSel.selectedIndex].value);

		    }else if (id == "promoCode") {
		        var priceSel = document.getElementById("priceList");
		        priceSelected = getTicketPrice(priceSel.options[priceSel.selectedIndex].value);

		    }else {

		        var regex = /[0-9]|\./;
		        if (!regex.test(document.getElementById("minPrice").value)) {
		            alert("Please enter number only!");
		            flag = false;
		            document.getElementById("minPrice").className += " error";
		            return false;
		        }

		        priceSelected = parseFloat(document.getElementById("minPrice").value);
		        var minp = parseFloat(document.getElementById("minPriceToCompare").value);
		        if (minp > priceSelected) {
		            alert("Please make a minimum contribution of S$ " + minp);
		            return false;
		        }

		    }

		    if (document.getElementById("priceCol") != null) {
		    	document.getElementById("priceCol").innerHTML = parseFloat(Math.round(priceSelected * 100) / 100).toFixed(2);
		    }
		    var discount = 0.0;
		    var noOfpeopleVal = 1;
	    	if (document.getElementById("noOfPeople") != null) {
	    		noOfpeopleVal = document.getElementById("noOfPeople").value;
	    	}
		    if (id == "priceList") {
		    	var priceSel = document.getElementById("priceList");
		    	discount = loadDiscountRate(priceSel.options[priceSel.selectedIndex].value, noOfpeopleVal, promoCode);
		    	document.getElementById("price").value = priceSelected;
		    }else if (id == "promoCode") {
		    	var priceSel = document.getElementById("priceList");
		    	discount = loadDiscountRate(priceSel.options[priceSel.selectedIndex].value, noOfpeopleVal, promoCode);
		    	document.getElementById("price").value = priceSelected;
		    }else {
		    	priceSelected = document.getElementById("minPrice").value;
		    }

		    var noOfPeople = 1;
	        if (document.getElementById("noOfPeople") != null ) {
	            noOfPeople = document.getElementById("noOfPeople").value;
	        }
	        var tax = document.getElementById("tax").value;

	        var totPrice = priceSelected * noOfPeople;
	        taxAmount = totPrice * (tax / 100);
	        var discountAmount = 0.00 + (totPrice * discount/100);

	       if (document.getElementById("discountColLbl")) {
	    	   document.getElementById("discountColLbl").innerHTML = "Disount ( "+discount + "% )";
	           document.getElementById("discountCol").innerHTML = discountAmount.toFixed(2);
	           document.getElementById("discountValue").value = discountAmount.toFixed(2);
	       }

	        var netTotal = parseFloat(taxAmount) + parseFloat(totPrice) - discountAmount;

	        document.getElementById("netTotalCol").innerHTML = "Calculating...";
	        loadNetTotal(priceSelected, noOfPeople, tax, discount);

		}

		AUI().ready(function(A) {

			multipleRegister();
		    var changeAddress = '<%= location %>';
		    var mapcanvas = document.createElement('div');
		    mapcanvas.id = 'mapcanvasEvent';
		    if (changeAddress != "") {
		        document.querySelector('article').appendChild(mapcanvas);
		    }

		    var map = null;
		    var mapElement = document.getElementById("mapcanvasEvent");
		    if (mapElement != null) {
			    map = new google.maps.Map(document.getElementById("mapcanvasEvent"), {
			        mapTypeId: google.maps.MapTypeId.ROADMAP,
			        mapTypeControl: true,
			        navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
			        zoom: 8,
			        streetViewControl: false
			    });
		    }
		    var image = "/html/portlet/calendar/currentlocation.png";

		    var geocoder = new google.maps.Geocoder();
		    geocoder.geocode({ 'address': changeAddress}, function(results, status) {
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
		        }

		    });

		});
		function validatePhone() {
		    var flag = false;
		    if (document.getElementById("minPrice") == null) {

		    }else {
		    	var priceSelected = parseFloat(document.getElementById("minPrice").value);
		        var minp = parseFloat(document.getElementById("minPriceToCompare").value);
		        if (minp > priceSelected) {
		            alert("Please make a minimum contribution of S$ " + minp);
		            flag = false;
		             return false;
		        }

		        var regex = /[0-9]|\./;
		        if (!regex.test(document.getElementById("minPrice").value)) {
		            alert("Please enter number only!");
		            flag = false;
		            document.getElementById("minPrice").className += " error";
		            return false;
		        }
		    }

		    if (document.getElementById("email").value == "") {
		        alert("* Field should not be empty!");
		        document.getElementById("email").className += " error";
		        flag = false;
		        return false;
		    } else {
		        if (validateEmail(document.getElementById("email").value)) {
		            document.getElementById("email").className = "rsvp-textbox";
		            flag = true;
		        } else {
		            alert("Email format is not valid!");
		            document.getElementById("email").className += " error";
		            flag = false;
		            return false;
		        }

		    }

		    if (document.getElementById("firstName").value == "" && flag) {
		        alert("* Field should not be empty!");
		        document.getElementById("firstName").className += " error";
		        flag = false;
		        return false;
		    } else if (flag) {
		        document.getElementById("firstName").className += "rsvp-textbox";
		        flag = true;
		    }
		    if (document.getElementById("lastName").value == "" && flag) {
		        alert("* Field should not be empty!");
		        document.getElementById("lastName").className += " error";
		        flag = false;
		        return false;
		    } else if (flag) {
		        document.getElementById("lastName").className += "rsvp-textbox";
		        flag = true;
		    }

		    if (${passwordFlag}) {
			    if (document.getElementById("password").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("password").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("password").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${passwordFlag}) {
			    if (document.getElementById("reTypePassword").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("reTypePassword").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("reTypePassword").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${identificationTypeFlag}) {
			    if (document.getElementById("identificationType").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("identificationType").className += " error";
			        flag = false;
			        return false;
			    } else if (flag) {
			        document.getElementById("identificationType").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${identificationNumberFlag}) {
			    if (document.getElementById("identificationNumber").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("identificationNumber").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("identificationNumber").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${streetAddress1Flag}) {
			    if (document.getElementById("streetAddress1").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("streetAddress1").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("streetAddress1").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${postalCodeFlag}) {
			    if (document.getElementById("postalCode").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("postalCode").className += " error";
			        flag = false;
			        return false;
			    }else if (document.getElementById("postalCode").value != "" && flag) {
			    	var regex = /[0-9]|\./;
			    	if (!regex.test(document.getElementById("postalCode").value)) {
	                    alert("Please enter number only!");
	                    flag = false;
	                    document.getElementById("postalCode").className += " error";
	                    return false;
			    	}
			    }else if (flag) {
			        document.getElementById("postalCode").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${cityFlag}) {
			    if (document.getElementById("city").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("city").className += " error";
			        flag = false;
			        return false;
			    }else if (document.getElementById("city").value != "" && flag) {
			    	var regex = /^[a-zA-Z]+$/;
			    	if (!regex.test(document.getElementById("city").value)) {
	                    alert("Please enter alphabets only!");
	                    flag = false;
	                    document.getElementById("city").className += " error";
	                    return false;
			    	}
			    }else if (flag) {
			        document.getElementById("city").className += "rsvp-textbox";
			        flag = true;
			    }
		    }


		    if (${stateFlag}) {
			    if (document.getElementById("state").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("state").className += " error";
			        flag = false;
			        return false;
			    }else if (document.getElementById("state").value != "" && flag) {
			    	var regex = /^[a-zA-Z]+$/;
			    	if (!regex.test(document.getElementById("state").value)) {
	                    alert("Please enter alphabets only!");
	                    flag = false;
	                    document.getElementById("state").className += " error";
	                    return false;
			    	}
			    }else if (flag) {
			        document.getElementById("state").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${countryFlag}) {
			    if (document.getElementById("countryId").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("countryId").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("countryId").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${phoneNumber1Flag}) {
			    if (document.getElementById("phoneNumber1").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("phoneNumber1").className += " error";
			        flag = false;
			        return false;
			    }else if (document.getElementById("phoneNumber1").value != "" && flag) {
			    	var regex = /[0-9]|\./;
			    	if (!regex.test(document.getElementById("phoneNumber1").value)) {
	                    alert("Please enter number only!");
	                    flag = false;
	                    document.getElementById("phoneNumber1").className += " error";
	                    return false;
			    	}
			    }else if (flag) {
			        document.getElementById("phoneNumber1").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${phoneNumber1Flag}) {
			    if (document.getElementById("phoneNumber1CountryCode").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("phoneNumber1CountryCode").className += " error";
			        flag = false;
			        return false;
			    }else if (document.getElementById("phoneNumber1CountryCode").value != "" && flag) {
			    	var regex = /[0-9]|\./;
			    	if (!regex.test(document.getElementById("phoneNumber1CountryCode").value)) {
	                    alert("Please enter number only!");
	                    flag = false;
	                    document.getElementById("phoneNumber1CountryCode").className += " error";
	                    return false;
			    	}
			    }else if (flag) {
			        document.getElementById("phoneNumber1CountryCode").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

			    if (${phoneNumber2Flag}) {
				    if (document.getElementById("phoneNumber2").value != "" && flag) {
				    	var regex = /[0-9]|\./;
				    	if (!regex.test(document.getElementById("phoneNumber2").value)) {
		                    alert("Please enter number only!");
		                    flag = false;
		                    document.getElementById("phoneNumber2").className += " error";
		                    return false;
				    	}else if (flag) {
					        document.getElementById("phoneNumber2").className += "rsvp-textbox";
					        flag = true;
					    }
				    }
			    }

			    if (${phoneNumber2Flag}) {
				   if (document.getElementById("phoneNumber2CountryCode").value != "" && flag) {
				    	var regex = /[0-9]|\./;
				    	if (!regex.test(document.getElementById("phoneNumber2CountryCode").value)) {
		                    alert("Please enter number only!");
		                    flag = false;
		                    document.getElementById("phoneNumber2CountryCode").className += " error";
		                    return false;
				    	}else if (flag) {
					        document.getElementById("phoneNumber2CountryCode").className += "rsvp-textbox";
					        flag = true;
					    }
				    }
			    }


		    if (${ageGroupFlag}) {
			    if (document.getElementById("ageGroup").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("ageGroup").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("ageGroup").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${hearAboutUsFlag}) {
			    if (document.getElementById("hearAboutUs").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("hearAboutUs").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("hearAboutUs").className += "rsvp-textbox";
			        flag = true;
			    }
		    }
		    
		    if (${customList1Flag}) {
			    if (document.getElementById("customField1").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("customField1").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("customField1").className += "rsvp-textbox";
			        flag = true;
			    }
		    }
		    
		    if (${attendedWebinarFlag}) {
			    if (document.getElementById("attendedWebinar").value == "" && flag) {
			        alert("* Field should not be empty!");
			        document.getElementById("attendedWebinar").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("attendedWebinar").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${ageRestrictionFlag}) {
			    if (!document.getElementById("ageRestriction").checked && flag) {
			        alert("* Please accept your age is above 14");
			        document.getElementById("ageRestriction").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("ageRestriction").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (${termsOfUseFlag}) {
			    if (!document.getElementById("termsOfUse").checked && flag) {
			        alert("* Please accept Terms and Conditions");
			        document.getElementById("termsOfUse").className += " error";
			        flag = false;
			        return false;
			    }else if (flag) {
			        document.getElementById("termsOfUse").className += "rsvp-textbox";
			        flag = true;
			    }
		    }

		    if (document.getElementById("paymentFlag").value == 'true') {
		    	if (document.getElementById("priceList") == null) {

		    	}else {
		    		if (document.getElementById("priceList").value == "") {
		        		alert("Please select amount!");
		        		document.getElementById("priceList").className += " error";
		        		return false;
		        	}
		    	}

		    }

		    var mandatoryField = '<%= mandatoryField %>';
		    if (mandatoryField != "" && flag) {
		        var mandatoryFieldArray = mandatoryField.split(",");
		        var manTotal = mandatoryFieldArray.length;
		        var j;
		        for (j = 0; j < manTotal; j++) {
		        	if (document.getElementById(mandatoryFieldArray[j]) != null) {
		        		    if (document.getElementById(mandatoryFieldArray[j])) {
		                if (document.getElementById(mandatoryFieldArray[j]).type.indexOf("radio") == -1) {
		                    if (document.getElementById(mandatoryFieldArray[j]).value == "") {
		                        document.getElementById(mandatoryFieldArray[j]).className += " error";
		                        if (document.getElementsByName(mandatoryFieldArray[j]).length > 1) {
		                        	var radio_group = document.getElementById("radio"+j);
		                        	alert("* Field should not be empty!");
		                        	radio_group.className += " error";
		                        }
		                        flag = false;
		                        return false;
		                        break;
		                    } else {
		                        document.getElementById(mandatoryFieldArray[j]).className = "rsvp-textbox";
		                        flag = true;
		                    }
		                }
		            }

		        	}


		        }
		    }

		    var fields = '<%= validationField %>';

		    if (document.getElementById("numberOfPeopleFlag").value=='true') {

		        fields += ",noOfPeople:7";
		    }
		    if (fields == "" && flag) {
		        document.getElementById("fm").submit();
		    } else if (flag) {
		        var fieldsArray = fields.split(",");
		        var i;
		        var total = fieldsArray.length;
		        for (i = 0; i < total; i++) {
		            var itemArray = fieldsArray[i].split(":");
		            if (itemArray[1] == "4") {
		                if (phoneValidation(itemArray[0])) {
		                    flag = true;
		                    document.getElementById(itemArray[0]).className = "rsvp-textbox";
		                } else {
		                    alert("Please input phone number in following format, Country code followed by phone number +XX-XXXXXXXX.");
		                    document.getElementById(itemArray[0]).className += " error";
		                    flag = false;
		                    return false;
		                    break;
		                }
		            }
		            if (itemArray[1] == "7") {
		                var regex = /[0-9]|\./;
		                if (!regex.test(document.getElementById(itemArray[0]).value)) {
		                    alert("Please enter number only!");
		                    flag = false;
		                    document.getElementById(itemArray[0]).className += " error";
		                    return false;
		                } else {
		                    flag = true;
		                    document.getElementById(itemArray[0]).className = "rsvp-textbox";
		                }
		            }
		        }
		        if (document.getElementById("numberOfPeopleFlag").value=='true') {
			        if (document.getElementById("mandatoryFlagChild").value=='true') {
			        	var noOfpeopleVal = 1;
				    	if (document.getElementById("noOfPeople") != null) {
				    		noOfpeopleVal = document.getElementById("noOfPeople").value;
				    	}
				        if (noOfpeopleVal > 1) {

				            for (var k = 1; k < noOfpeopleVal; k++) {
				                if (document.getElementById("multiItemEmail" + k).value.length == 0) {
				                    alert("* Field should not be empty!");
				                    document.getElementById("multiItemEmail" + k).className += " error";
				                    flag = false;
				                    break;
				                } else {
				                    if (validateEmail(document.getElementById("multiItemEmail" + k).value)) {
				                        document.getElementById("multiItemEmail" + k).className = "rsvp-textbox";
				                        flag = true;
				                    } else {
				                        alert("Email format is not valid!");
				                        document.getElementById("multiItemEmail" + k).className += " error";
				                        flag = false;
				                        break;
				                    }
				                }

				                if (document.getElementById("multiItemFirstName" + k).value.length == 0) {
				                    alert("* Field should not be empty!");
				                    document.getElementById("multiItemFirstName" + k).className += " error";
				                    flag = false;
				                    break;
				                } else {
				                    document.getElementById("multiItemFirstName" + k).className = "rsvp-textbox";
				                    flag = true;
				                }

				                if (document.getElementById("multiItemLastName" + k).value.length == 0) {
				                    alert("* Field should not be empty!");
				                    document.getElementById("multiItemLastName" + k).className += " error";
				                    flag = false;
				                    break;
				                } else {
				                    document.getElementById("multiItemLastName" + k).className = "rsvp-textbox";
				                    flag = true;
				                }

				                if (document.getElementById("multiItemId" + k).value.length == 0) {
				                    alert("* Field should not be empty!");
				                    document.getElementById("multiItemId" + k).className += " error";
				                    flag = false;
				                    break;
				                } else {
				                    document.getElementById("multiItemId" + k).className = "rsvp-textbox";
				                    flag = true;
				                }
				            }
				        }
			        }
		        }

		        if (flag) {
		            document.getElementById("fm").submit();
		            // return false;
		        } else {
		            return false;
		        }

		    }

		}

		function phoneValidation(obj) {
		    var inputtxt = document.getElementById("validateField").value;
		    var phoneValue = document.getElementById(obj).value;
		    var reg =/^\+?([0-9]{2})\)?[-. ]?([0-9]{4})$/;
		    var invalid = false;
		    if (phoneValue.length > 0) {
		    	if (phoneValue.indexOf("+") == 0) {
		    		invalid = true;
		    	}else {
		    		return false;
		    	}
		    	if (phoneValue.indexOf("-") == 3 || phoneValue.indexOf("-") == 4) {
		    		invalid = true;
		    	}else {
		    		return false;
		    	}

		    	var subStringPhone = phoneValue.substring(1,phoneValue.indexOf("-"));
		    	if (subStringPhone.match(/^\d+/)) {
		    		if (subStringPhone.length>3) {
		    			return false;
		    		}
		    	}else {
		    		return false;
		    	}

		    	 subStringPhone = phoneValue.substring(phoneValue.indexOf("-")+1,phoneValue.length);
		    	 if (subStringPhone.match(/^\d+/)) {
		     		if (subStringPhone.length>30) {
		     			return false;
		     		}
		     	}else {
		     		return false;
		     	}

		    	 return true;

		    }

		}
		function validateEmail(email) {
		    var re = /\S+@\S+\.\S+/;
		    return re.test(email);
		}

		function getRadioButtonValue(vId) {
			var radio_group = document.getElementsByName("item"+vId);
		    for (var i = 0; i < radio_group.length; i++) {
		        var button = radio_group[i];
		        if (button.checked) {
		            document.getElementById("item"+vId).value = button.value;
		            document.getElementById("radio"+vId).className = "";
		        }
		    }
		}

		function multipleRegister() {
			var noOfpeopleVal = 1;
	    	if (document.getElementById("noOfPeople") != null) {
	    		noOfpeopleVal = document.getElementById("noOfPeople").value;
	    	}
		    if (noOfpeopleVal > 0) {
		        if (document.getElementById("paymentFlag").value == 'true') {

		            var price = document.getElementById("price").value;

		            if (document.getElementById("minPrice")) {
		            	price = document.getElementById("minPrice").value;
		            }
		            var tax = document.getElementById("tax").value;
		            var currency = document.getElementById("currency").value;
		            var noOfpeopleVal = 1;
			    	if (document.getElementById("noOfPeople") != null) {
			    		noOfpeopleVal = document.getElementById("noOfPeople").value;
			    	}
		            var noOfPeople = noOfpeopleVal;
		            var total = price * noOfPeople;
		            var taxAmount = total * (tax / 100);
		            var grandTotal = total+taxAmount;
		            var netTotal = 0.0;
		            var discountValue = 0.0;

		            var currencyDiv = document.createElement("div");
		            currencyDiv.setAttribute("style","float:right;");
		            currencyDiv.innerHTML = "* "+currency;
		            if (document.getElementById("discountFlag").value=='true') {
		            	//currencyDiv.innerHTML += "</br>* 10% Discount till 30th Nov 2013";
		            }

					var minimumPriceTocompage = document.getElementById("minPriceToCompare").value;

		            var table = document.createElement("table");
		            table.setAttribute("style", "width:100%;border:1px solid #c5c5c5;background:#f8f8f8;padding:10px;margin:10px 10px 10px 0;");

		            if (minimumPriceTocompage>0) {

					}else {
						var tr = document.createElement("tr");
		                var td = document.createElement("td");
		                td.setAttribute("style", "padding:10px;");
		                var priceLbl = document.createTextNode("Price ");
		                td.appendChild(priceLbl);
		                tr.appendChild(td);

		                td = document.createElement("td");
		                td.setAttribute("style", "padding:10px;");
		                var priceLbl = document.createTextNode(parseFloat(Math.round(price * 100) / 100).toFixed(2));
		                td.appendChild(priceLbl);
		                td.setAttribute("id","priceCol");
		                tr.appendChild(td);
		                table.appendChild(tr);
					}

		            if (document.getElementById("numberOfPeopleFlag")=='true') {
		            	tr = document.createElement("tr");
		                td = document.createElement("td");
		                td.setAttribute("style", "padding:10px;");
		                priceLbl = document.createTextNode("Number of People");
		                td.appendChild(priceLbl);
		                tr.appendChild(td);

		                td = document.createElement("td");
		                td.setAttribute("style", "padding:10px;");
		                priceLbl = document.createTextNode(document.getElementById("noOfPeople").value);
		                td.appendChild(priceLbl);
		                tr.appendChild(td);

		                table.appendChild(tr);
		            }

		            if (tax == '0') {

		            }else {
		                 tr = document.createElement("tr");
		                 td = document.createElement("td");
		                 td.setAttribute("style", "padding:10px;");
		                 priceLbl = document.createTextNode("Tax ");
		                 td.appendChild(priceLbl);
		                 tr.appendChild(td);

		                 td = document.createElement("td");
		                 td.setAttribute("style", "padding:10px;");
		                 priceLbl = document.createTextNode(tax + "%");
		                 td.appendChild(priceLbl);
		                 tr.appendChild(td);

		                 table.appendChild(tr);
		            }

		            if (document.getElementById("promoCodeFlag").value == 'true') {
		                var promoCodeInput = document.getElementById("promoCode");
		            	var promoCode = "";
		            	if (promoCodeInput) {
		            		promoCode = promoCodeInput.value;
		            	}
		            	if (document.getElementById("priceList")) {
		            		if (document.getElementById("priceList").value==null) {
		                		tr = document.createElement("tr");
		                        td = document.createElement("td");
		                        td.setAttribute("style", "padding:10px;");
		                        td.setAttribute("id","discountColLbl");
		                        priceLbl = document.createTextNode("Discount");
		                        td.appendChild(priceLbl);
		                        tr.appendChild(td);

		                        td = document.createElement("td");
		                        td.setAttribute("style", "padding:10px;");
		                        td.setAttribute("id","discountCol");
		                        priceLbl = document.createTextNode("0.00");
		                        td.appendChild(priceLbl);
		                        tr.appendChild(td);

		                        document.getElementById("discountValue").value ="0";

		                	}else {
		                		var noOfpeopleVal = 1;
		    			    	if (document.getElementById("noOfPeople") != null) {
		    			    		noOfpeopleVal = document.getElementById("noOfPeople").value;
		    			    	}
		                		var discountRate = loadDiscountRate(document.getElementById("priceList").value, noOfpeopleVal, promoCode);
		                		tr = document.createElement("tr");
		                        td = document.createElement("td");
		                        td.setAttribute("style", "padding:10px;");
		                        td.setAttribute("id","discountColLbl");
		                        priceLbl = document.createTextNode("Discount( "+discountRate+"% )");
		                        td.appendChild(priceLbl);
		                        tr.appendChild(td);
		                        td = document.createElement("td");
		                        td.setAttribute("style", "padding:10px;");
		                        td.setAttribute("id","discountCol");

		                        discountValue = 0.00+(total* (discountRate/100));
		                        priceLbl = document.createTextNode(discountValue.toFixed(2));
		                        td.appendChild(priceLbl);
		                        tr.appendChild(td);

		                        table.appendChild(tr);

		                        document.getElementById("discountValue").value =discountValue.toFixed(2);
		                	}
		            	}

		            }else if (document.getElementById("discountFlag").value == 'true') {

		               	if (document.getElementById("priceList")) {
		               		if (document.getElementById("priceList").value==null) {
		                   		tr = document.createElement("tr");
		                           td = document.createElement("td");
		                           td.setAttribute("style", "padding:10px;");
		                           td.setAttribute("id","discountColLbl");
		                           priceLbl = document.createTextNode("Discount");
		                           td.appendChild(priceLbl);
		                           tr.appendChild(td);

		                           td = document.createElement("td");
		                           td.setAttribute("style", "padding:10px;");
		                           td.setAttribute("id","discountCol");
		                           priceLbl = document.createTextNode("0.00");
		                           td.appendChild(priceLbl);
		                           tr.appendChild(td);

		                           document.getElementById("discountValue").value ="0";

		                   	}else {
		                   		var noOfpeopleVal = 1;
		    			    	if (document.getElementById("noOfPeople") != null) {
		    			    		noOfpeopleVal = document.getElementById("noOfPeople").value;
		    			    	}
		                   		var discountRate = loadDiscountRate(document.getElementById("priceList").value, noOfpeopleVal, '');
		                   		tr = document.createElement("tr");
		                           td = document.createElement("td");
		                           td.setAttribute("style", "padding:10px;");
		                           td.setAttribute("id","discountColLbl");
		                           priceLbl = document.createTextNode("Discount( "+discountRate+"% )");
		                           td.appendChild(priceLbl);
		                           tr.appendChild(td);
		                           td = document.createElement("td");
		                           td.setAttribute("style", "padding:10px;");
		                           td.setAttribute("id","discountCol");

		                           discountValue = 0.00+(total* (discountRate/100));
		                           priceLbl = document.createTextNode(discountValue.toFixed(2));
		                           td.appendChild(priceLbl);
		                           tr.appendChild(td);

		                           table.appendChild(tr);

		                           document.getElementById("discountValue").value =discountValue.toFixed(2);
		                   	}
		               	}

		            }

		            netTotal = grandTotal-discountValue;
		            tr = document.createElement("tr");
		            td = document.createElement("td");
		            td.setAttribute("style", "padding:10px;");
		            priceLbl = document.createTextNode("Net Total");
		            td.appendChild(priceLbl);
		            tr.appendChild(td);

		            td = document.createElement("td");
		            td.setAttribute("style", "padding:10px;");
		            td.setAttribute("id","netTotalCol");
		            priceLbl = document.createTextNode("Calculating...");
		            td.appendChild(priceLbl);
		            tr.appendChild(td);

		            table.appendChild(tr);

		            document.getElementById("priceDiv").innerHTML = "";
		            document.getElementById("priceDiv").appendChild(currencyDiv);
		            document.getElementById("priceDiv").appendChild(table);

			        // document.title += " -price: " + price + " -noOfPeople: " + noOfPeople + " -tax: " + tax + " -discount: " + discountRate;
			        loadNetTotal(price, noOfPeople, tax, discountRate);

		        }
		        if (document.getElementById("multiRegFlag").value == 'true') {
		        	var noOfpeopleVal = 1;
			    	if (document.getElementById("noOfPeople") != null) {
			    		noOfpeopleVal = document.getElementById("noOfPeople").value;
			    	}
		        	if (noOfpeopleVal > 1) {

		        		var mandatoryChild = null;
		        		if (document.getElementById("mandatoryFlagChild").value == "") {
		        			mandatoryChild = 'false';
		        		}else {
		        			mandatoryChild = 'true';
		        		}

		                var multiDiv = document.createElement("div");
		                multiDiv.setAttribute("id", "multiDiv");
		                multiDiv.setAttribute("style", "width: 98%; border: 1px solid #c5c5c5;background:#f8f8f8; padding-left: 10px;margin-bottom: 10px;");
		                var multiTitle = document.createElement("div");
		                multiTitle.setAttribute("style", "width: 100%; font-weight: bold; margin-top: 10px; margin-bottom: 10px; color: #666666;");
		                var multiTitleSpan = document.createTextNode("Please enter the details for multiple-registration.");
		                multiTitle.appendChild(multiTitleSpan);
		                multiDiv.appendChild(multiTitle);

		                if (document.getElementById("multiDiv")) {
		                    var div = document.getElementById("multiDiv");
		                    div.parentNode.removeChild(div);
		                }

		                for (var i = 1; i < noOfpeopleVal; i++) {
		                    if (i > 1) {
		                        var seperateDiv = document.createElement("div");
		                        seperateDiv.setAttribute("style", "height:2px;background:#c5c5c5;width:90%;margin:15px");

		                        multiDiv.appendChild(seperateDiv);
		                    }

		                    var multiItemDiv = document.createElement("div");
		                    multiItemDiv.setAttribute("class", "rsvp-label");

		                    var multiItemLeftDiv = document.createElement("div");
		                    multiItemLeftDiv.setAttribute("style", "width:40%;display:inline-block;vertical-align: top;");

		                    var multiItemLeftSpan1 = document.createElement("span");
		                    multiItemLeftSpan1.setAttribute("class", "pets-rsvp-label");
		                    var labelItem = document.createTextNode("Email");
		                    multiItemLeftSpan1.appendChild(labelItem);
		                    multiItemLeftDiv.appendChild(multiItemLeftSpan1);

		                    var multiItemLeftSpan2 = null;
		                    var requiredField = null;

							if (mandatoryChild == 'true') {
								multiItemLeftSpan2 = document.createElement("span");
			                    multiItemLeftSpan2.setAttribute("style", "color:red;");
			                    requiredField = document.createTextNode("*");
			                    multiItemLeftSpan2.appendChild(requiredField);
			                    multiItemLeftDiv.appendChild(multiItemLeftSpan2);
							}

		                    multiItemDiv.appendChild(multiItemLeftDiv);

		                    var multiItemRightDiv = document.createElement("div");
		                    multiItemRightDiv.setAttribute("style", "width:58%;display:inline-block");

		                    var inputItem = document.createElement("input");
		                    inputItem.setAttribute("id", "multiItemEmail" + i);
		                    inputItem.setAttribute("class", "rsvp-textbox");
		                    inputItem.setAttribute("type", "text");
		                    inputItem.setAttribute("name", "multiItemEmail" + i);
		                    multiItemRightDiv.appendChild(inputItem);
		                    multiItemDiv.appendChild(multiItemRightDiv);

		                    multiDiv.appendChild(multiItemDiv);

		                    //first Name

		                    multiItemDiv = document.createElement("div");
		                    multiItemDiv.setAttribute("class", "rsvp-label");

		                    multiItemLeftDiv = document.createElement("div");
		                    multiItemLeftDiv.setAttribute("style", "width:40%;display:inline-block;vertical-align: top;");

		                    multiItemLeftSpan1 = document.createElement("span");
		                    multiItemLeftSpan1.setAttribute("class", "pets-rsvp-label");
		                    labelItem = document.createTextNode("First Name");
		                    multiItemLeftSpan1.appendChild(labelItem);
		                    multiItemLeftDiv.appendChild(multiItemLeftSpan1);

		                    if (mandatoryChild == 'true') {
			                    multiItemLeftSpan2 = document.createElement("span");
			                    multiItemLeftSpan2.setAttribute("style", "color:red;");
			                    requiredField = document.createTextNode("*");
			                    multiItemLeftSpan2.appendChild(requiredField);
			                    multiItemLeftDiv.appendChild(multiItemLeftSpan2);
		                    }

		                    multiItemDiv.appendChild(multiItemLeftDiv);

		                    multiItemRightDiv = document.createElement("div");
		                    multiItemRightDiv.setAttribute("style", "width:58%;display:inline-block");

		                    inputItem = document.createElement("input");
		                    inputItem.setAttribute("id", "multiItemFirstName" + i);
		                    inputItem.setAttribute("class", "rsvp-textbox");
		                    inputItem.setAttribute("type", "text");
		                    inputItem.setAttribute("name", "multiItemFirstName" + i);
		                    multiItemRightDiv.appendChild(inputItem);
		                    multiItemDiv.appendChild(multiItemRightDiv);

		                    multiDiv.appendChild(multiItemDiv);

		                    //Last Name

		                    multiItemDiv = document.createElement("div");
		                    multiItemDiv.setAttribute("class", "rsvp-label");

		                    multiItemLeftDiv = document.createElement("div");
		                    multiItemLeftDiv.setAttribute("style", "width:40%;display:inline-block;vertical-align: top;");

		                    multiItemLeftSpan1 = document.createElement("span");
		                    multiItemLeftSpan1.setAttribute("class", "pets-rsvp-label");
		                    labelItem = document.createTextNode("Last Name");
		                    multiItemLeftSpan1.appendChild(labelItem);
		                    multiItemLeftDiv.appendChild(multiItemLeftSpan1);

		                    if (mandatoryChild == 'true') {
		                    	multiItemLeftSpan2 = document.createElement("span");
		                        multiItemLeftSpan2.setAttribute("style", "color:red;");
		                        requiredField = document.createTextNode("*");
		                        multiItemLeftSpan2.appendChild(requiredField);
		                        multiItemLeftDiv.appendChild(multiItemLeftSpan2);
		                    }

		                    multiItemDiv.appendChild(multiItemLeftDiv);

		                    multiItemRightDiv = document.createElement("div");
		                    multiItemRightDiv.setAttribute("style", "width:58%;display:inline-block");

		                    inputItem = document.createElement("input");
		                    inputItem.setAttribute("id", "multiItemLastName" + i);
		                    inputItem.setAttribute("class", "rsvp-textbox");
		                    inputItem.setAttribute("type", "text");
		                    inputItem.setAttribute("name", "multiItemLastName" + i);
		                    multiItemRightDiv.appendChild(inputItem);
		                    multiItemDiv.appendChild(multiItemRightDiv);

		                    multiDiv.appendChild(multiItemDiv);

		                    //Identification Number

		                    multiItemDiv = document.createElement("div");
		                    multiItemDiv.setAttribute("class", "rsvp-label");

		                    multiItemLeftDiv = document.createElement("div");
		                    multiItemLeftDiv.setAttribute("style", "width:40%;display:inline-block;vertical-align: top;");

		                    multiItemLeftSpan1 = document.createElement("span");
		                    multiItemLeftSpan1.setAttribute("class", "pets-rsvp-label");
		                    labelItem = document.createTextNode("Identification Number");
		                    multiItemLeftSpan1.appendChild(labelItem);
		                    multiItemLeftDiv.appendChild(multiItemLeftSpan1);

		                    if (mandatoryChild == 'true') {
		                    	multiItemLeftSpan2 = document.createElement("span");
		                        multiItemLeftSpan2.setAttribute("style", "color:red;");
		                        requiredField = document.createTextNode("*");
		                        multiItemLeftSpan2.appendChild(requiredField);
		                        multiItemLeftDiv.appendChild(multiItemLeftSpan2);
		                    }

		                    multiItemDiv.appendChild(multiItemLeftDiv);

		                    multiItemRightDiv = document.createElement("div");
		                    multiItemRightDiv.setAttribute("style", "width:58%;display:inline-block");

		                    inputItem = document.createElement("input");
		                    inputItem.setAttribute("id", "multiItemId" + i);
		                    inputItem.setAttribute("class", "rsvp-textbox");
		                    inputItem.setAttribute("type", "text");
		                    inputItem.setAttribute("name", "multiItemId" + i);
		                    multiItemRightDiv.appendChild(inputItem);
		                    multiItemDiv.appendChild(multiItemRightDiv);

		                    multiDiv.appendChild(multiItemDiv);

		                }
		                document.getElementById("multiregdiv").appendChild(multiDiv);
		        	} else {
		        		if(document.getElementById("multiregdiv")){
		        			document.getElementById("multiregdiv").innerHTML = "";
		        		}	
		        	}
		        }

		    } else {
		        var div = document.getElementById("multiDiv")
		        if (document.getElementById("multiDiv")) {
		            div.parentNode.removeChild(div);
		        }
		    }

		}

		function loadDiscountRate(priceSelected, noOfPeople, promoCode) {
			var A=AUI();
			var items = null;
			var reqUrl = '<portlet:resourceURL id="" />';
			var discount = 0.0;
		 	try{
			 	A.io.request(reqUrl, {
				    cache: false,
				    sync: true,
				    timeout: 1000,
				    dataType: 'json',
				    method: 'post',
				    data:{
				   	 filterValue:priceSelected,
				   	 filter:"loadDiscount",
				   	 noOfPeople:noOfPeople,
				   	 promoCode:promoCode
				    },

				    on: {
				        success: function() {
				       	 items = this.get('responseData');
				       	if (items) {
				       		discount = items["discount"];
				       	}
				        },
				        failure: function() {
				        }
				    }
				});

			 	return discount;
			}catch(err) {
			}
		}

			function getTicketPrice(selectedPriceId) {
				var A=AUI();
				var items = null;
				var reqUrl = '<portlet:resourceURL id="" />';
				var price = 0.0;
				try{
				 	A.io.request(reqUrl, {
					    cache: false,
					    sync: true,
					    timeout: 1000,
					    dataType: 'json',
					    method: 'post',
					    data:{
					   	 filterValue:selectedPriceId,
					   	 filter:"loadPrice",
					    },

					    on: {
					        success: function() {
					       	 items = this.get('responseData');
					       	if (items) {
					       		price = items["price"];
					       	}
					        },
					        failure: function() {
					        }
					    }
					});

				 	return price;
				}catch(err) {
				}
			}

			function loadNetTotal(priceSelected, noOfPeople, tax, discount) {
				var A=AUI();
				var netTotal = 0.0;
				var reqUrl = '<portlet:resourceURL id="" />';
				//alert("reqUrl " + reqUrl);
				//try{
				 	A.io.request(reqUrl, {
					    cache: false,
					    sync: true,
					    timeout: 1000,
					    dataType: 'json',
					    method: 'get',
					    data:{
					    	filter:"loadNetTotal",
					     	priceSelected:priceSelected,
					     	noOfPeople:noOfPeople,
					     	tax:tax,
					     	discount:discount,
					    },
					    on: {
					        success: function() {
					        	netTotal = this.get('responseData');
					        	//alert("netTotal " + netTotal);
						        document.getElementById("netTotalCol").innerHTML = netTotal;
					        },
					        failure: function() {
						        document.getElementById("netTotalCol").innerHTML = "Error";
					        }
					    }
					});
				//}catch(err) {
					//alert("1" + err);
				//}
			}

			function validatePassword(password, reTypePassword) {
				var A=AUI();
				var reqUrl = '<portlet:resourceURL id="" />';
				var pwdValue = document.getElementById(password).value;
				var rtPwdValue = document.getElementById(reTypePassword).value;
				var noOfpeopleVal = 1;
		    	if (document.getElementById("noOfPeople") != null) {
		    		noOfpeopleVal = document.getElementById("noOfPeople").value;
		    	}
				if (pwdValue == "") {
					alert("Password cannot be empty");
				}else {
					try{
					 	A.io.request(reqUrl, {
						    cache: false,
						    sync: true,
						    timeout: 1000,
						    dataType: 'json',
						    method: 'get',
						    data:{
						    	filter:"verifyPassword",
						    	password:pwdValue,
						     	noOfPeople:noOfpeopleVal,
						     	reTypePassword:rtPwdValue,
						    },
						    on: {
						        success: function() {
						        	var items = this.get('responseData');
						        	if (items != "Valid" && items != null) {
						        		document.getElementById("reTypePassword").value = "";
						        	}
						        },
						        failure: function() {
							        document.getElementById("reTypePassword").value = "Error";
						        }
						    }
						});
					}catch(err) {
						alert(err);
					}
				}
			}
		</script>
		<% } %>
	</c:otherwise>
</c:choose>
