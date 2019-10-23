<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
<%@page import="java.util.Calendar"%>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/appoint.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
Long groupId = td.getLayout().getGroupId();
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));  
String scheduleFacility = httpReq.getParameter("schedulefacility");
String groupNameValue = httpReq.getParameter("groupName");
String appointmentType = httpReq.getParameter("appointmentType");
if(scheduleFacility == null) scheduleFacility ="";
if(groupNameValue == null) groupNameValue ="";
if(appointmentType == null) appointmentType ="";
String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,SambaashConstants.DEFAULT_GROUP_ID_LONG);
int year = Calendar.getInstance().get(Calendar.YEAR);
String dashBoardLink = SambaashUtil.getDashBoard();
String userId = String.valueOf(themeDisplay.getUserId());
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


<div class="newPortlets">	

<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>APPOINT INVIGILATOR</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
			</aui:row>
		</div>
	</div>
</div>

<div class="InvigilatorManagement">
<div class="yui3-skin-sam">
	<div id="sucess-popup" hidden="true" class="modalpopupBox">
	   <div id="sucess-popup-box" class="modalpopupContent">
	   <form class="formContainer" >
	     <aui:row>
	         <aui:col span="12">
	       	  <h3 id="success-msg">Invigilators Appointed</h3>
	       	  </aui:col>
	       
	     </aui:row>
	     <aui:row>
	      	<aui:col span="12">
	      		<button class="btn btn-default popup-confirm-archive pull-left" type="button" onClick="reloadPage()">Start Again</button>
	      		<button class="btn cancel btn-primary popup-cancel pull-right" type="button" onClick="goBack()">Go Back</button>
	      	</aui:col>
	     </aui:row>
	           
	   </form>
	   </div>
	</div>
</div>

<div id="modal"></div>	
<div class="formRoot">
		<div class="innerFormRoot">
	<form id="myform" action="">
		<div  class="formContainer container null formio-form">
			<div class="InvigilatorManagementForm">
			<div class="row">
				<div class="col col-sm-12">
					<div class="alert alert-" role="alert" id="alert_msg" style="display:none">
						TaxCode for this Country and Start date Exists. 
					</div>
			
					<div class="row">
						<div class="col col-sm-12 text-center">
							<img src="<%=renderRequest.getContextPath()%>/images/bitmap.png" width="172" height="140"/>
							<h3>Appoint Invigilators!</h3>
							<p>Get started. Choose a schedule linked to a facility below</p>
						</div>
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
										<input list="GroupNameDL"  name="GroupName" class="form-control col-sm-12" oninput='onGroupSelect()'
										 placeholder="Group Name" id="groupName">
										  	<datalist id="GroupNameDL"></datalist>
										 </div>
							        </div>
									<div class="col-sm-6">
										<label>Appointment type <span style="color: red;">*</span></label>
										<div class="form-group formio-choices">
												<% if(!appointmentType.equalsIgnoreCase("")){ %>
													<select disabled="true" id="appointType"  class="form-control" onchange="visibleStep3()">
												<% } else { %>
													<select id="appointType"  class="form-control" onchange="visibleStep3()">
												<% }  %>
														<option disabled hidden value="Choose a type">Choose a type</option>
														<%
															List<SPListType> appointmentTypeList = SPListTypeLocalServiceUtil.getByKey("invigilators.appointment.type",
																	groupId);
															for (SPListType type : appointmentTypeList) {
																if(appointmentType.equalsIgnoreCase(type.getItemValue())){
																	%><option  selected value="<%=type.getItemValue()%>"><%=type.getDisplayName()%></option>
																	<%
																}else{
																	%><option value="<%=type.getItemValue()%>"><%=type.getDisplayName()%></option>
																	<%
																}
														
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
							                  <th>ID Number</th>
							                  <th>Yrs of Exp. (RELC)</th>
							                  <th>Eval. Score</th>
							                  <th>Int- Category</th>
							                  <th>Status</th>
							                  <th><input type="checkbox" id="chkAll" onclick='onChecked(this)' /><label for="chkAll"></label></th>
							               </tr>
							            </thead>
							            <tbody>
							           		<tr>
							           		 <td><input class="Lead" onclick='onChecked(this)' type="radio" id="r1" name="Lead">
							           		 <label class="LeadLBL" for="r1"/></td>
							                  <td><label class="Invigilator">Bruce Haynes</label></td>
							                  <td><label class="IONumber">S2707254B</label></td>
							                  <td><label class="YrsOfExp">10</label></td>
							                  <td><label class="EvalScore">81%</label></td>
							                  <td><label class="IntCategory">Unsuitable</label></td>
							                  <td><button class="btn btn-info Status">AVAILABLE</button></td>
							                  <td><input class="checked" onclick='onChecked(this)' type="checkbox" id="d1" /><label class="ChkLBL" for="d1"/></td>
							               		
							               </tr>
							            </tbody>
							           
			        			</table>
			        			<div class="dataFilter">
			        				 <input list="AppointToDL"  name="AppointTo" class="row col-sm-12" placeholder="Appoint to" 
			        				 id="appoint_to" oninput='addToAppointList(this)'>
									  <datalist id="AppointToDL"></datalist>
			        			</div>
		        			</div>
		        		</div>
					</div>
				</div>
			</div>
			</div>
			<div class="row" >
				<div class="col col-sm-6 col-sm-push-3">
					<div class="form-group">
						<div class="available">
							<ul>
								<li>Available: <span id="available">0</span></li>
								<li>Selected: <span id="selected">0</span></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row" >
				<div class="col col-sm-12" id="buttonHolder">
					<div class="form-group actionDiv">
							<aui:button id="bt_submit" type="button" onclick='submitForm(this)' value="Save" cssClass="btn-primary" style="display: none;" ></aui:button>
							<aui:button id="bt_clear" type="button" value="Clear" onclick="reload();" cssClass="btn-default" style="display: none;" ></aui:button>
							<aui:button id="bt_cancel" type="button" onclick="moveToDashboard();" value="Cancel" cssClass="btn-default"></aui:button>					
					</div>
				</div>
			</div>
		  </div>	
		
	</form>
	</div></div>
</div>
</div>






<script>
var dashBoardLink = "<%=dashBoardLink%>";
var ajaxUrl = "<%=ajaxUrl%>";
var resourceURL = "<%=resourceURL%>";
var esUrl = "<%=elastisearchlisturl%>";
var userId = "<%= userId %>";
var namespace =  "<portlet:namespace/>";
var mode ="edit"
var namespace='<portlet:namespace />';
var vocabularyURL = "<%= vocabularyURL %>";
var scheduleFacility = "<%= scheduleFacility %>";
var groupNameValue = "<%= groupNameValue %>";
var appointmentType = "<%= appointmentType %>";

	AUI().use('event-base', function (A) {
	A.on('domready', function () {
		init();
		});    
	});
	function loadInvigilatorSuggestion() {
		
		var val = document.getElementById("appoint_to").value;
		var opts = AppointToDL.childNodes;
		for (var i = 0; (i < opts.length  && i <= 10); i++) {
			var obj = JSONInvList[i];
			AppointToDL.removeChild(opts[i]);
			var pExist = false;
			for (var p = 0; p < selectedInvigilators.length; p++) {
				if (obj.UserId == selectedInvigilators[p].UserId) {
					pExist = true;
					break;
				}
			}
			
			if (!pExist) {
				obj.Lead = false;
				obj.checked = false;
				if(!obj.Score){
					obj.Score = 0;
				}
				selectedInvigilators.push(obj);
			}
		}
		planListShort();
		drawTable();
		appoint_to.value = "";
		
		var test = document.getElementById('available');
		test.innerText = selectedInvigilators.length;
		
	}
</script>
