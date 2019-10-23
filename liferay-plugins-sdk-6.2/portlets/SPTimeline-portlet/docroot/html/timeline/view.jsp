<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>

<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'> 



<liferay-theme:defineObjects />
<portlet:defineObjects />


<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%= AuthTokenUtil.getToken(request) %>" />
</portlet:resourceURL>

<!-- Example style to set in portlet preference: "margin:5px auto; max-width: 640px" -->


<portlet:resourceURL var="processListAjaxResourceUrl">
	
</portlet:resourceURL>
<theme:defineObjects />
<style>
	.aui #wrapper .rightSide .timeLineOption h6 {
	    text-transform: unset !important;
	}
</style>
<%

String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:EnquiryListing:cssClass"), "social-share text-center");
String modelName  = GetterUtil.getString((String)request.getAttribute("sp-formio:EnquiryListing:modelName")) ;

if(request.getParameter("formTypeName") != "" && request.getParameter("formTypeName") != null){
	modelName = request.getParameter("formTypeName");
}
boolean adminUser=false;
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();
User u = themeDisplay.getUser(); 
long RoleSize = GetterUtil.getLong(portletPreferences.getValue("RoleSize","0"));
long[] RoleList = new long[(int) RoleSize];
for(int i=0;i<RoleList.length;i++){
	RoleList[i] = GetterUtil.getLong(portletPreferences.getValue("RoleID_"+i,""));
	for (Role role : u.getRoles()) {
		if(RoleList[i]==role.getRoleId()){
			adminUser=true;
			break;
		}
	 }
	if(adminUser){
		break;
	}
}
%>

<div class="newPortlets">
	<div class="formRoot">
		<div class="sptimeLine">
			<div id='formio1' class="<%= cssClass %> container">
				
				<div class="dataListing">
					<div class="data-lising padding0">
						<div class="timeLineOption padding0">
						<h6>Important Notifications
							<ul>
						
						<li>
						<div class="form-group formio-component-datetime">
							<input type="text" autocomplete="off"  name="startDateTimeline" class ="form-control startDateTimeline" id="startDateTimeline" placeholder="Start Date"  onChange="onDateSelect()"/><i class="dateIcon"></i>
						</div>
						</li>
						<li>
						<div class="form-group formio-component-datetime">
							<input type="text" autocomplete="off" name="endDateTimeline" class ="form-control endDateTimeline" id="endDateTimeline" placeholder="End Date" onChange="onDateSelect()"/><i class="dateIcon"></i>
						</div>
						</li>
						<li style="display:none">
							<select id="activity" onchange="getProcessList()">
								<option>All Activity</option>
								<option>To Do</option>
								<option>Other Activities</option>
							</select>
						</li>
						<li style="display:none">
							<select id="processes" onchange="getProcessList()">
								<option value="All">All Categories</option>
								<option value="SpecialRequestProcessId">Special Requests</option>
								<option value="EnquiryProcessId">Enquiry</option>
								<option value="FeedbackProcessId">Feedback</option>	
							</select>
						</li>
						<li style="display:none">
							<select id="ebs" onchange="getProcessList()">
								<option>All EBs</option>
							</select>
						</li>
						<li style="display:none">
							<select id="person">
								<option value="Candidate">Candidate</option>
								<option value="All">All Persons</option>
									
							</select>
						</li>
					</ul>
					
				</h6>
				</div>
				<table  style="display:none">
					<tr class="table_row">
						<td>
							<img src="<%=request.getContextPath()%>/images/tasks.png"/>
						</td>
						<td width="65%">
							<label class="info">Lois Mullins (RELC) assigned you to Update  </label>
						</td>
						<td style="display:none">
							<button class="btn btn-default status">In Progress</button>
						</td>
						<td width="10%"> <label class="info-date">12/08/2018</label></td>
						<td width="10%">
							<label class=""><a href="#" class="btn timeline-detail btn-default status">Details</a></label>
						</td>
					</tr>
				</table>
				<div class="timelineList">
					<table width="100%" id ="tableId">
					<tbody>
					
						
					</tbody>
					</table>
				</div>
			
		
					</div>
					<div class="pagination">
						<div class="inner-container">
						<aui:row>
							<aui:col span="6" cssClass="text-left">
								<aui:select cssClass="itemsPerPage" name="itemsPerPage"
									label="Items per page:" onChange="changeItemsPerPage()">
									<aui:option value="5">5</aui:option>
									<aui:option value="10" selected="true">10</aui:option>
									<aui:option value="20">20</aui:option>
									<aui:option value="50">50</aui:option>
									<aui:option value="100">100</aui:option>
								</aui:select>
		
							</aui:col>
							<aui:col span="6" cssClass="text-right myPagination aui-pagination">
								<div id="jslarge" class="pagination myPagination pagination-large"></div>
							</aui:col>
						</aui:row>
						</div>
					</div>
					<div class="no-data-listing" style="display: none">
		
						<div class="sambaashContent">
							<div class="container nodates">
								<aui:row>
									<aui:col span="12" cssClass="text-center">
										<h3 id="h3message" class="no-data-listing-message">
											No <%= modelName %></h3>
										<p id="pmessage" class="no-data-listing-message">
											There aren't any records of existing
											<%= modelName %>s as of now. If you would like to create a new
											one, please click on the 'ADD NEW' button.
										</p>
										<a id="ahrefmessage" href="<%= dashBoardLink %>" title="BACK TO DASHBOARD"
											class="btn lightbluebtn">BACK TO DASHBOARD</a>
									</aui:col>
								</aui:row>
							</div>
						</div>
					</div>
				</div>
			</div>
</div>
</div>
</div>

<script>
var namespace =  "<portlet:namespace/>";
var processListUrl = "${processListAjaxResourceUrl}";
var listOfEnquiry=[];
var table=document.getElementById("tableId");
var tbody=table.getElementsByTagName("tbody")[0]; 
var baseRow=document.getElementsByClassName("table_row")[0];
var threedot = document.getElementById("threedot");
var pageIndex=0;
var inp_search;
var activitylogLimit = 10;
var currentUserId = "<%= u.getUserId()  %>";
var adminUser = <%=adminUser%>;
AUI().use('event-base', function (A) {
	A.on('domready', function () {
		getProcessList();
	});    
});

while (tbody.hasChildNodes()) {
	tbody.removeChild(tbody.lastChild);
}
var data = {};
function getProcessList() {
	
	if(!inProcess){
		AUI().use('aui-io-request', function(A) {

			var api_url = processListUrl;
			var filterdataTimeline = [];
			var filterNewdataTimeline = [];
			var _data = {};
			
			_data[namespace + 'action'] = "elasticSearch";
			data.limit = document.getElementsByClassName("itemsPerPage")[0].value;
			data.page = pageIndex;
			data.startDate = document.getElementById("startDateTimeline").value;
			data.endDate = document.getElementById("endDateTimeline").value;
			data.activity = document.getElementById("activity").value;
			data.processes = document.getElementById("processes").value;
			data.ebs = document.getElementById("ebs").value;
			data.person = document.getElementById("person").value;
			if(!adminUser){
				data.userId = currentUserId;
			}
			data.modelName = "activitylog";
			data.formType = data.modelName;
			data.sortby = [{"direction":"desc","field":"modelId","contentJSON":"false"}]
			var obj = {};
			//currentUserId = 230112;
			obj["contentJson.assignedTo"] = [currentUserId];
			
			filterdataTimeline.push(obj);
			data.filterdata = filterdataTimeline;
			if(data.endDate != ""){
				var newobj = {};
				newobj["operator"] = "lte";
				newobj["column"] = "createdDate";
				newobj["value"] = data.endDate;
				
				filterNewdataTimeline.push(newobj);
				
			}
			if(data.startDate != ""){
				var newobj = {};
				newobj["operator"] = "gte";
				newobj["column"] = "createdDate";
				newobj["value"] = data.startDate;
				
				filterNewdataTimeline.push(newobj);
				
			}
			
			data.newFilter = filterNewdataTimeline;
			_data[namespace + 'data'] = JSON.stringify( data);

			inProcess = true;
			A.io.request(api_url, {
				method : 'GET',
				data : _data,
				on : {
					success : function() {
						inProcess = false;
						var status = this.get('responseData');
						var jsonObj = JSON.parse(status);
						if(jsonObj == undefined ){
							listOfEnquiry = [];
						}else{
							
							listOfEnquiry= jsonObj;
							drawListTable();
							makePaging(jsonObj.totalPages,pageIndex);   
						}
						
						
						
					},
					failure : function() {
						alert('bad request');
						inProcess = false;
					}
				}
			});
		});
	}
	
}
YUI().use('aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#startDateTimeline',
        mask : '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
        	  if (event.newSelection[0]) {
        		  debugger;
        		  setTimeout(function() { onDateSelect(); }, 500);
        	  }
            	console.log(event.newSelection);
          }
        }
      }
    );
  }
);
		
YUI().use('aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#endDateTimeline',
        mask : '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
        	  if (event.newSelection[0]) {
        		  debugger;
        		  setTimeout(function() { onDateSelect(); }, 500);
        	  }
            	console.log(event.newSelection)
          }
        }
      }
    );
  }
);


</script>
