<%@page import="java.util.Calendar"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
<%@page import="java.net.URI"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/report.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
Long groupId = td.getLayout().getGroupId();
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId); %>
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>



<portlet:resourceURL var="elastisearchlisturl">
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
	<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>

<portlet:resourceURL var="ajaxUrl">
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>

<% } %>

<% String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,SambaashConstants.DEFAULT_GROUP_ID_LONG);
int year = Calendar.getInstance().get(Calendar.YEAR);
String dashBoardLink = SambaashUtil.getDashBoard();
String userId = String.valueOf(themeDisplay.getUserId());


%>

<div class="newPortlets">	

<div class="subHeader">
	<div class="container">
		<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span>INVIGILATOR APPOINTMENT REPORT</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
		</aui:row>
		</div>
	</div>
</div>

<link rel="stylesheet" type="text/css" href="styles.css">
<div class="InvigilatorManagement">
<div id="modal"></div>
<div class="formRoot">
		<div class="innerFormRoot">	
	<aui:form>
		<div  class="formContainer container null formio-form">
			<div class="InvigilatorManagementForm">
			<div class="row">
				<div class="col col-sm-12">
					<div class="alert alert-" role="alert" id="alert_msg" style="display:none">
						
					</div>
			
					<div class="row">
						<div class="col col-sm-12">
							<label>Schedule + Facility</label>
							<div class="form-group formio-choices">
								<select id="scheduleFacility" class="form-control" onchange="getGroupNameBySchedule()">
								<option value="">Select Option</option>							
								</select>
							</div>
						</div>
					</div>
					<div id="step-2" style="display: none;">
						
						<div class="row">
							<div class="col col-sm-12">
									<div class=" col-sm-4 ">
							            <label>Group Name</label>
										<input list="GroupNameDL"  name="GroupName" class="row col-sm-6" oninput='generateReport()'
										 placeholder="Group Name" id="groupName">
										  	<datalist id="GroupNameDL"></datalist>
							        </div>
									<div class="col-sm-4">
										<label>Appointment type	<span style="color: red;">*</span></label>
										<div class="form-group formio-choices">
											<select id="appointType" class="form-control" onchange="generateReport()">
												<option selected disabled hidden>Select option</option>
															<%
																List<SPListType> appointmentTypeList = SPListTypeLocalServiceUtil
																			.getByKey("invigilators.appointment.type", groupId);
																	for (SPListType type : appointmentTypeList) {
															%><option value="<%=type.getItemValue()%>"><%=type.getDisplayName()%></option>
															<%
																}
															%>
														</select>
										</div>
									</div>
									<div class="col-sm-4">
										<label>Appointment status</label>
										<div class="form-group formio-choices">
											<select id="appointStatus" class="form-control" onchange="generateReport()">
												<option value="">Select Option</option>
												<option value="Accepted">Accepted</option>
												<option value="Pending Notification">Pending Notification</option>
												<option value="Pending Confirmation">Pending Confirmation</option>
												<option value="Rejected">Rejected</option>
												<option value="Confirmed">Confirmed</option>
											</select>
										</div>
									</div>
							</div>
						</div>
					</div>
					<div id="step-3" style="display: none;">
						<div class="row" >
							<div class="col col-sm-12 timelineList">
								<table id="tb_DateDescription"  class="aui">
						            <thead>
						               <tr>
						                 
						                  <th>Invigilator</th>
						                  <th>Contact Number</th>
						                  <th>Group name</th>
						                  <th>Appointment Type</th>
						                  <th>Invig. ID</th>
						                  <th>Status</th>
						                  <th>Reporting Start Time</th>
						                  
						               </tr>
						            </thead>
						            <tbody>
						           		<tr>
						           		
						           		 <label disabled class="LeadLBL" for="r1"/></td>
						                  <td><label class="Invigilator">Bruce Haynes</label></td>
						                  <td><label class="ContactNumber">S2707254B</label></td>
						                  <td><label class="GroupName">Group Name></td>
						                  <td><label class="AppType">Invigilator</label></td>
						                  <td><label class="InvID">81</label></td>
						                  <td><button class="btn btn-info Status">AVAILABLE</button></td>
						                  <td><label class="timeNotified">02/02/2018 09:00</label></td>
						                  
						               		
						               </tr>
						            </tbody>
							           
			        			</table>
			        			
		        			</div>
		        		</div>
		        		<div class="row" >
							<div class="col col-sm-12" id="buttonHolder" >
								<div class="form-group actionDiv">
										<aui:button id="export_btn" type="button" onclick='exportReport()' value="Export" cssClass="btn-default"></aui:button>
										
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
			
			
		  </div>	
		
	</aui:form>
	</div></div>
</div>
</div>






<script>
var ajaxUrl = "<%=ajaxUrl%>";
var resourceURL = "<%=resourceURL%>";
var esUrl = "<%=elastisearchlisturl%>";
var userId = "<%= userId %>";
var mode ="edit"
var namespace='<portlet:namespace />';
var vocabularyURL = "<%= vocabularyURL %>";

AUI().use('event-base', function (A) {
	A.on('domready', function () {
		init();
		});    
	});
 function addToAppointList1()
 {
	 alert();
 }
</script>
