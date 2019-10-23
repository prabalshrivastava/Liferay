<%@page import="java.util.Calendar"%>
<%@page import="java.net.URI"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/appoint.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
%>

<%
	}

%>
<%
	String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME,
			"InvigilatorAppointment");
	String dashBoardLink = SambaashUtil.getDashBoard();
	String storageId = request.getParameter("storageId");
	String userId = String.valueOf(themeDisplay.getUserId());
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	String formStorageId = request.getParameter("storageId");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,
			SambaashConstants.DEFAULT_GROUP_ID_LONG);
	Long groupId = td.getLayout().getGroupId();
%>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<sp-formio:FormIO cssClass="formContainer" modelName="${formType}"
	formId="${formId}" readOnly="false" formStorageId="${formStorageId}" />

<portlet:resourceURL var="elastisearchlisturl">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
	<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>

<portlet:resourceURL var="ajaxUrl">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2><span>PAST APPOINTMENTS</span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
				</aui:col>
			</aui:row>
			</div>
		</div>
	</div>
	<div class="formRoot">
		<div class="innerFormRoot">
		<div class="container formio-form">
			<div class="formSection">
				
					<div class="row">
						<div class="col col-sm-12 timelineList">
							<table id="myTable">
								<thead>
									<tr>
										<th>Date</th>
										<th>Session</th>
										<th>Appointment Type</th>
										<th>Venue</th>
										<th width="36%">Status</th>

									</tr>
								</thead>
								<tbody id="invigilator">

								</tbody>
							</table>
						</div>
					</div>
			
			</div>
		</div>
		</div></div>
	</div>



<script type="text/javascript">
var mode = "edit";
var documents;
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var userId = "<%=userId%>";
var formType = "<%=formType%>";  
var formStorageId = "<%=formStorageId%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";

var appointmenttStatus = document.getElementById(namespace+"appointmentstatus");
var userId = "<%=userId%>";
	var table = document.getElementById("myTable");
	AUI().use('event-base', function(A) {
		A.on('domready', function(thisInstance) {

			getUserAppointmentsList(thisInstance);
		});

	})

	function getUserAppointmentsList(thisInstance) {
		var inputData = {
				"InvigilatorId":userId,
				"formType":formType,
				"modelName":formType
		}
		ajaxCallAPI('GET', 'pastAppointmentData', inputData, function(){
			var response = this.get("responseData");
			console.log(response);
			if (_.isEmpty(response)) {
				console.log("error");
			} else {
				var rows = '';
				for (var i = 0; i < response.length; i++) {
					var appointmentDate = formatDate(new Date(response[i].contentJson.Date));
					var session = response[i].contentJson.Session;
					var appointType = response[i].contentJson.AppointType;
					var venue = response[i].contentJson.Venue;
					var appointmentStatus = response[i].contentJson.AppointmentStatus.toUpperCase();
					
					rows += '<tr><td>' + appointmentDate + '</td>';
					rows += '<td>' + session + '</td>';
					rows += '<td>' + appointType + '</td>';
					if (venue == undefined) {
						rows += '<td></td>';
					} else {
						rows += '<td>' + venue + '</td>';
					}
					if (appointmentStatus == "ACCEPTED") {
						rows += '<td><button class="btn btn-success">'
								+ appointmentStatus + '</button></td></tr>';
					}
					if (appointmentStatus == "REJECTED") {
						rows += '<td><button class="btn btn-incative">'
								+ appointmentStatus + '</button></td></tr>';
					}
					if (appointmentStatus != "REJECTED"
							&& appointmentStatus != "ACCEPTED") {
						rows += '<td><button class="btn btn-info">' + appointmentStatus + '</button></td></tr>';
					}
				}
				document.getElementById('invigilator').innerHTML = rows;
			}
		});
		
	}

	var responseData = [];
</script>

