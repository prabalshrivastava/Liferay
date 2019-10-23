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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/viewappoint.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
Long groupId = td.getLayout().getGroupId();
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
String editUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
%>
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
			<aui:col span="10" cssClass="text-center"><h2><span>VIEW APPOINTMENTS</span></h2></aui:col>
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
						TaxCode for this Country and Start date Exists. 
					</div>
			
					<div class="row">
						<div class="col col-sm-12">
							<label>Schedule + Facility</label>
							<div class="form-group formio-choices">
								<select id="scheduleFacility" class="form-control" onchange="getScheduleData()">
								<option value="">Select Option</option>							
								</select>
							</div>
						</div>
					</div>
					<div id="step-2" style="display: none;">
						<div class="row">
							<div class="col col-sm-12">
								<table id="DateDescription"  class="aui">
							            <thead>
							               <tr>
							                  <th>Date</th>
							                  <th>Session</th>
							                  <th>Time</th>
							                  
							               </tr>
							            </thead>
							            <tbody>
							               <tr id="table_row">
							                  <td><label id="Date">12-12-2018</label></td>
							                  <td><label id="Session">AM</label></td>
							                  <td><label id="Time">8:00-12:00</label></td>
							               </tr>
							            </tbody>
			        			</table>
							</div>
							</div>
							<div class="row">
						
									<div class="col col-sm-6 ">
							            <label>Group Name</label>
							            <div class="form-group formio-choices">
										<input list="GroupNameDL" multiple="multiple" onclick = "clearInputList()" class="form-control col-sm-12" name="GroupName"  oninput='onGroupSelect()'
										 placeholder="Group Name" id="groupName">
										  	<datalist id="GroupNameDL"></datalist>
										</div>
							        </div>
									<div class="col col-sm-6">
										<label>Appointment type	<span style="color: red;">*</span></label>
										<div class="form-group formio-choices">
											<select id="appointType" class="form-control" onchange="visibleStep3()">
												<option value = "" >All</option>
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
						
					</div>
					</div>
					<div id="step-3" style="display: none;">
						<div class="row" >
							<div class="col col-sm-12 timelineList">
								<table id="tb_DateDescription"  class="aui">
						            <thead>
						               <tr>
						                  <th>Lead</th>
						                  <th>Invigilator</th>
						                  <th>Contact Number</th>
						                  <th>Group name</th>
						                  <th>Appointment Type</th>
						                  <th>Invig. ID</th>
						                  <th>Int. Category</th>
						                  <th>Status</th>
						                  <th>Date & Time Notified</th>
						                  
						               </tr>
						            </thead>
						            <tbody>
						           		<tr>
						           		 <td><input disabled class="Lead"  type="radio" id="r1" name="Lead">
						           		 <label disabled class="LeadLBL" for="r1"/></td>
						                  <td><label class="Invigilator">Bruce Haynes</label></td>
						                  <td><label class="ContactNumber">S2707254B</label></td>
						                  <td><label class="GroupName">Group Name></td>
						                  <td><label class="AppType">Invigilator</label></td>
						                  <td><label class="InvID">81</label></td>
						                  <td><label class="IntCategory">Cat</label></td>
						                  <td><button class="btn btn-info Status">AVAILABLE</button></td>
						                  <td><label class="timeNotified">02/02/2018 09:00</label></td>
						                  
						               		
						               </tr>
						            </tbody>
							           
			        			</table>
			        			
		        			</div>
		        		</div>
					</div>
				</div>
			</div>
			</div>
			<div class="row" >
				<div class="col col-sm-6 col-sm-push-3">
					<div class="form-group">
						<div class="available" id="availableinvig" style="display:none">
							<ul>
								<li>Total selected Invigilators: <span id="totalseinvig">100</span></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row" >
				<div class="col col-sm-12" id="buttonHolder" >
					<div class="form-group actionDiv">
							<aui:button id="bt_edit" type="button" onclick='editAppointment()' value="EDIT" cssClass="btn-primary" disabled = "disabled"></aui:button>
							<aui:button id="bt_clear" type="button" onclick='moveToDashboard()' value="BACK TO WORKSPACE" cssClass="btn-default"></aui:button>
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
var editUrl = "<%= editUrl %>";
var mode ="edit"
var namespace='<portlet:namespace />';
var vocabularyURL = "<%= vocabularyURL %>";

	AUI().use('event-base', function (A) {
	A.on('domready', function () {
		init();
		});    
	});
function editAppointment(){
	editUrl = editUrl + "?schedulefacility="+scheduleFacility.value+ "&groupName="+ groupName.value + "&appointmentType="+ appointType.value ;
	console.log(editUrl);
	window.location.href = editUrl;
}
function clearInputList(){
	debugger;
	document.getElementById("groupName").value = "";
	onGroupSelect();
}
</script>
