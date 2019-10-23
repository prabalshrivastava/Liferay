<%@page import="com.sambaash.platform.enquiry.CapitalizeCharacter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.JSONArray"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page
	import="com.sambaash.platform.srv.processbuilder.model.PEProcessState"%>
<%@page
	import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>



<liferay-theme:defineObjects />
<portlet:defineObjects />


<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%= AuthTokenUtil.getToken(request) %>" />
</portlet:resourceURL>

<!-- Example style to set in portlet preference: "margin:5px auto; max-width: 640px" -->

<portlet:resourceURL var="ajaxUrl">

</portlet:resourceURL>
<portlet:resourceURL var="searchlisturl">
	<portlet:param name="action" value="searchList" />
</portlet:resourceURL>
<portlet:resourceURL var="elastisearchlisturl">
	<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>
<portlet:resourceURL var="filtercolumnlisturl">
	<portlet:param name="action" value="filterColumnList" />
</portlet:resourceURL>
<portlet:resourceURL var="fetchListAjaxResourceUrl">
	<portlet:param name="action" value="fetchList" />
</portlet:resourceURL>

<portlet:resourceURL var="updateSettingsAjaxResourceUrl">
	<portlet:param name="action" value="updateSettings" />
</portlet:resourceURL>

<portlet:renderURL var="CreateNewURL">
	<portlet:param name="jspPage" value="wwww" />
</portlet:renderURL>


<%
String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:EnquiryListing:cssClass"), "social-share text-center");
String modelName  = GetterUtil.getString(portletPreferences.getValue("modelName", "")) ;

if(request.getParameter("formTypeName") != "" && request.getParameter("formTypeName") != null){
	modelName = request.getParameter("formTypeName");
}

String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();

String userType = GetterUtil.getString(portletPreferences.getValue("userType", ""));
String selectDefault = "SELECT";
String select_1 = GetterUtil.getString(portletPreferences.getValue("select1", ""));
String select_2 = GetterUtil.getString(portletPreferences.getValue("select2", ""));
String select_3 = GetterUtil.getString(portletPreferences.getValue("select3", ""));
String select_4 = GetterUtil.getString(portletPreferences.getValue("select4", ""));

String processStateUrl = portletPreferences.getValue("processStateUrl", "");


 User u = themeDisplay.getUser(); 
 List<Role> roles = RoleServiceUtil.getUserRoles(u.getUserId());
 
 boolean validUser=false;
 String layoutURL="";
 if(userType.equalsIgnoreCase("User")){
	 validUser=true;
	 long layoutId = GetterUtil.getLong(portletPreferences.getValue("layout", "0"));
		if(layoutId>0){
			Layout layout1 = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), LayoutLocalServiceUtil.getLayout(themeDisplay.getPlid()).isPrivateLayout(), layoutId);
			layoutURL=PortalUtil.getLayoutFullURL(layout1, themeDisplay);
			
		}
 }else{
	 long RoleSize = GetterUtil.getLong(portletPreferences.getValue("RoleSize","0"));
		long[] RoleList = new long[(int) RoleSize];
		for(int i=0;i<RoleList.length;i++){
			RoleList[i] = GetterUtil.getLong(portletPreferences.getValue("RoleID_"+i,""));
			for (Role role : u.getRoles()) {
				if(RoleList[i]==role.getRoleId()){
					validUser=true;
					break;
				}
			 }
			if(validUser){
				break;
			}
		}
 }
	
	JSONArray jsonArray = new JSONArray(GetterUtil.getString(portletPreferences.getValue("dataOption", "[]")));
	
	List<String> list = new ArrayList<String>();
	for (int i=0; i<jsonArray.length(); i++) {
	    list.add( jsonArray.getString(i) );
	}

	 

	
%>





<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span><%= modelName.toUpperCase() %>
							LISTING</span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="formRoot">
	<div class="inne rFormRoot">
	<div id='formio1' class="<%= cssClass %> container enquiryForm">
		<%if(userType.equalsIgnoreCase( "Internal User")){ %>
		<div class="formContainer container enquiry-date">
			<div class="inner-container">
			<aui:row>
				<aui:col span="12" cssClass="text-left">
					<ul>
						<li>
							<div class="form-group formio-component-datetime">
								<input type="text" name="startDate" autocomplete= "off"
									class="form-control startDate" id="startDate"
									placeholder="Start Date" onChange="onDateSelect()" /><i
									class="dateIcon"></i>
							</div>
						</li>
						<li>-</li>
						<li>
							<div class="form-group formio-component-datetime">
								<input type="text" name="endDate" class="form-control endDate" autocomplete= "off"
									id="endDate" placeholder="End Date" onChange="onDateSelect()" /><i
									class="dateIcon"></i>
							</div>
						</li>
						<li><select id="lastActivity">
								<option>Last Activity Date</option>
						</select></li>
					</ul>
				</aui:col>
			</aui:row>
			</div>
		</div>
		<%} %>
		<div class="dataListing">
			<div id="searchContainer" class="search-container container tr ansparent">
				<div class="inner-container">
				<aui:row>
					<aui:col span="9">
						<div id="filterlist" class="selectedItem slectedItem">
							<ul>
								<li></li>
							</ul>
						</div>
						<aui:input cssClass="search-icon" id="inp_search" type="text"
							name="text-code" placeholder="Search ${modelName}"
							onkeypress="jsElasticSearchList(event,this.value);" />
					</aui:col>
					<aui:col span="3" cssClass="text-right">
						<div id="togglerSortColumn">
							<ul>
								<li>
									<h4 class="header toggler-header-collapsed orderIcon" style="display:none">
										<span></span>
									</h4>
									<div class="content toggler-content-collapsed">
										<div id="oredercolumn"
											cssClass="oredercolumn toggler-content-collapsed">
											<div class="column-list">
												<aui:form id="filtercolumnform">
													<aui:row class="filtercolumnheader">
														<aui:col span="12" cssClass="text-center">
															<p>Please select the values you would like to filter
																the columns by</p>
														</aui:col>
													</aui:row>
													<aui:row class="column-list-filter">
														<aui:col id="double-column-container" span="12"></aui:col>
													</aui:row>
												</aui:form>
											</div>
										</div>
									</div>
								</li>
								<li>
									<h4 class="header toggler-header-collapsed settingIcon ">
										<span></span>
									</h4>
									<div class="content toggler-content-collapsed">
										<div class="column-list">
											<aui:form>
												<aui:row>
													<aui:col span="12" cssClass="text-center">
														<div class="choose-col">
															<i></i>Choose Column fields in the order you would like
															them to be displayed in the table
														</div>
													</aui:col>
												</aui:row>
												<aui:row>
													<aui:col span="12">
														<aui:row>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="01"
																	id="select1">
																	<aui:option value="<%= selectDefault %>"
																		selected="<%=selectDefault.equalsIgnoreCase(select_1) %>"><%= CapitalizeCharacter.humanize(selectDefault) %></aui:option>
																	<%for(String s:list){ %>
																	<aui:option value="<%= s %>"
																		selected="<%=s.equalsIgnoreCase(select_1) %>"><%= CapitalizeCharacter.humanize(s) %></aui:option>
																	<%}%>
																</aui:select>
															</aui:col>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="02"
																	id="select2">
																	<aui:option value="<%= selectDefault %>"
																		selected="<%=selectDefault.equalsIgnoreCase(select_2) %>"><%= CapitalizeCharacter.humanize(selectDefault) %></aui:option>

																	<%for(String s:list){ %>
																	<aui:option value="<%= s %>"
																		selected="<%=s.equalsIgnoreCase(select_2) %>"><%= CapitalizeCharacter.humanize(s) %></aui:option>
																	<%}%>

																</aui:select>
															</aui:col>
														</aui:row>
														<aui:row>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="03"
																	id="select3">
																	<aui:option value="<%= selectDefault %>"
																		selected="<%=selectDefault.equalsIgnoreCase(select_3) %>"><%= CapitalizeCharacter.humanize(selectDefault) %></aui:option>

																	<%for(String s:list){ %>
																	<aui:option value="<%= s %>"
																		selected="<%=s.equalsIgnoreCase(select_3) %>"><%=CapitalizeCharacter.humanize(s) %></aui:option>
																	<%}%>
																</aui:select>
															</aui:col>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="04"
																	id="select4">
																	<aui:option value="<%= selectDefault %>"
																		selected="<%=selectDefault.equalsIgnoreCase(select_4) %>"><%= CapitalizeCharacter.humanize(selectDefault) %></aui:option>

																	<%for(String s:list){ %>
																	<aui:option value="<%= s %>"
																		selected="<%=s.equalsIgnoreCase(select_4) %>"><%= CapitalizeCharacter.humanize(s) %></aui:option>
																	<%}%>
																</aui:select>
															</aui:col>
														</aui:row>

													</aui:col>
												</aui:row>



												<aui:row>
													<aui:col span="12" cssClass="userAction text-center">
														<aui:button type="button" id="searchbtn"
															cssClass="btn-primary search" value="Save"></aui:button>

													</aui:col>
												</aui:row>
											</aui:form>
										</div>
									</div>
								</li>
								<% if(PermissionUtil.canExportModel((PortletRequest) request.getAttribute( "javax.portlet.request")) ||
										PermissionUtil.canActivateModel((PortletRequest) request.getAttribute( "javax.portlet.request")) ||  
										PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute( "javax.portlet.request"))){ %>
								<li>
									<button id="more-popover" Class="more"></button>
									<div id="MultirowPopAction" class="Multi-Pop-Action threedot hide">
										<ul>
											<% if(PermissionUtil.canExportModel((PortletRequest) request.getAttribute( "javax.portlet.request"))){ %>
											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);"
												onclick="globalExportList(event);">Export</a></li>
											<% } if(PermissionUtil.canActivateModel((PortletRequest) request.getAttribute( "javax.portlet.request"))){ %>
											<li class="deactivate"><img
												src="/html/images/deactivate.svg" alt="List Deactivate"><a
												href="javascript:void(0);"
												onclick="globalDeactivateList('Inactive');">Deactivate</a></li>
											<% } if(PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute( "javax.portlet.request"))){ %>
											<li><img src="/html/images/archive.png"
												alt="List Archive"><a href="javascript:void(0);"
												onclick="globalArchiveList();">Archive</a></li>
											<% } %>
										</ul>
									</div>
								</li>
								<% } %>
								<%if(userType.equalsIgnoreCase( "User")){ %>
								<li>
									<button id="addnew" Class="addNew" onclick="addNewRecord(this)">ADD
										NEW</button>
								</li>
								<% } %>
							</ul>
						</div>
					</aui:col>
				</aui:row>
				</div>
			</div>
			<div class="data-lising">
				<div class="timelineList">
					<%if(!validUser){ %>
					<label>Please goto preference and configure properly.</label>
					<%} %>
					<table id="tableId" class="aui">
						<thead>
							<tr class="Heading">
								<%if(select_1.length()>0&&!select_1.equalsIgnoreCase("SELECT")){ %>
								<th><%=CapitalizeCharacter.humanize(select_1) %></th>
								<%} %>
								<%if(select_2.length()>0&&!select_2.equalsIgnoreCase("SELECT")){ %>
								<th><%=CapitalizeCharacter.humanize(select_2) %></th>
								<%} %>
								<%if(select_3.length()>0&&!select_3.equalsIgnoreCase("SELECT")){ %>
								<th><%=CapitalizeCharacter.humanize(select_3) %></th>
								<%} %>
								<%if(select_4.length()>0&&!select_4.equalsIgnoreCase("SELECT")){ %>
								<th><%=CapitalizeCharacter.humanize(select_4) %></th>
								<%} %>
								<th>Created On</th>
								<th>Status</th>
								<th style="text-align: center;"></th>
							</tr>
						</thead>
						<tbody>
							<tr id="enquiry_table_row" class="enquiry_table_row Row">
								<%if(select_1.length()>0&&!select_1.equalsIgnoreCase("SELECT")){ %>
								<td><label id="select_1" class="select_1"> <%=select_1.toUpperCase() %>
								</label></td>
								<%} %>
								<%if(select_2.length()>0&&!select_2.equalsIgnoreCase("SELECT")){ %>
								<td><label id="select_2" class="select_2"> <%=select_2.toUpperCase() %>
								</label></td>
								<%} %>
								<%if(select_3.length()>0&&!select_3.equalsIgnoreCase("SELECT")){ %>
								<td><label id="select_3" class="select_3"> <%=select_3.toUpperCase() %>
								</label></td>
								<%} %>
								<%if(select_4.length()>0&&!select_4.equalsIgnoreCase("SELECT")){ %>
								<td><label id="select_4" class="select_4"> <%=select_4.toUpperCase() %>
								</label></td>
								<%} %>
								<td><label id="createdOn" class="createdOn">Created
										On</label> 
								<label id="process_ID" class="process_ID" style="display: none" />
								<span class="storageId"></span>
								</td>
								

								<td>
									<button id="status" class="status btn">Status</button>
								</td>
								<td></td>

							</tr>
						</tbody>
					</table>
					<label id="NoRecord">No records found</label>
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
									No
									<%= modelName %></h3>
								<p id="pmessage" class="no-data-listing-message">
									There aren't any records of existing
									<%=modelName %>s as of now. If you would like to create a new
									one, please click on the 'ADD NEW' button.
								</p>
								<a id="ahrefmessage" href="#link" title="BACK TO DASHBOARD"
									class="btn lightbluebtn">BACK TO DASHBOARD</a>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>
		</div>
		<div id="threedot">
			<a href="#" class="threedot addInfo"> <img
				src="/html/images/big.png" alt="Details">
			</a>
			<div id="popoverId" class="Pop-Action hide">
				<ul>
					<% if(PermissionUtil.canViewModel((PortletRequest) request.getAttribute( "javax.portlet.request"))){ %>
					<li><img src="/html/images/details.png" alt="Details"><a
						href="javascript:void(0);" onclick="doAction('detail',this);">Details</a>
					</li>
					<% } %>
				</ul>
			</div>
		</div>
	</div>
	</div></div>
</div>


<script type="text/javascript">

var namespace =  "<portlet:namespace/>";

var fetchListUrl = "${fetchListAjaxResourceUrl}";
var updateSettings = "${updateSettingsAjaxResourceUrl}";

var listOfEnquiry=[];
console.log("listOfEnquiry.size = "+listOfEnquiry.size);

var userType="<%=userType%>";
var validUser="<%=validUser%>";

var table=document.getElementById("tableId");
var tbody=table.getElementsByTagName("tbody")[0];


var baseRow=tbody.getElementsByClassName("enquiry_table_row")[0];
var threedot = document.getElementById("threedot");
var pageIndex=0;


AUI().use('event-base', function (A) {
	A.on('domready', function () {
		getProcessList();
		});    
	});

while (tbody.hasChildNodes()) {
	tbody.removeChild(tbody.lastChild);
}
var inp_search;
function jsElasticSearchList(event ,value){
	if (event.which !=13)
		return;
	getProcessList();
}
function showPageList(index){
	pageIndex=(index-1);
	getProcessList();
}
function changeItemsPerPage(){
	pageIndex=0;
	getProcessList();
}
function onDateSelect(){
	getProcessList();
}


AUI().use('event-base', function (A) {
    A.on('domready', function () {
    	var toDate = "<%= processStateUrl %>";
    	setMenuBar();
    	
    	
    });
});
function setMenuBar(){
	 YUI().use("node", "event",'aui-popover', function(A) {
		 var trigger = A.one('#more-popover');
		
	     A.one("#searchbtn").on('click',function(){
	     	updateFormFields();
	     });
	     A.one(".itemsPerPage").on('change',function(event){ 
	     	pageRequested = 1;	
	     	ajaxLock = 0;
	     	
	     });
	    
	 });
}

function updateFormFields(){
	AUI().use('aui-io-request', function(A) {

		var api_url = updateSettings;
		var _data = {};
		_data[namespace + 'action'] = "updateSettings";
		_data[namespace + 'select1'] = document.getElementById(namespace + 'select1').value;
		_data[namespace + 'select2'] = document.getElementById(namespace + 'select2').value;
		_data[namespace + 'select3'] = document.getElementById(namespace + 'select3').value;
		_data[namespace + 'select4'] = document.getElementById(namespace + 'select4').value;
		
		A.io.request(api_url, {
			method : 'GET',
			data : _data,
			on : {
				success : function() {
					var data = this.get('responseData');
					if (data.error) {
	                    console.log("error");
	                } else {   
	        	     	window.location.reload();
	                }
				},
				failure : function() {
					alert('bad request');
				}
			}
		});
	});
 }
 

function getProcessList() {
	if(validUser=="true"){
	AUI().use('aui-io-request', function(A) {

		var api_url = fetchListUrl;
		var _data = {};
		_data[namespace + 'action'] = "fetchList";
		_data[namespace + 'itemsPerPage'] = document.getElementsByClassName("itemsPerPage")[0].value;
		_data[namespace + 'pageIndex'] = pageIndex;
		_data[namespace + 'searchText'] = document.getElementById(namespace+"inp_search").value;
		
		if(userType=="Internal User"){
			_data[namespace + 'startDate'] = document.getElementById("startDate").value;
			_data[namespace + 'endDate'] = document.getElementById("endDate").value;
		}
		
		A.io.request(api_url, {
			method : 'GET',
			data : _data,
			on : {
				success : function() {
					var status = this.get('responseData');
					var jsonObj = JSON.parse(status);
					listOfEnquiry= jsonObj.List;
					drawListTable();
					makePaging(jsonObj.totalPage,(jsonObj.pageIndex));
				},
				failure : function() {
					alert('bad request');
				}
			}
		});
		
	});
	}
}

function drawListTable(){
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}
	for(var i=0;i<listOfEnquiry.length;i++){
		var cRow=baseRow.cloneNode(true);
		
		<%if(select_1.length()>0&&!select_1.equalsIgnoreCase("SELECT")){ %>
			cRow.getElementsByClassName("select_1")[0].innerHTML=listOfEnquiry[i].select1;				
		<%} %>
		<%if(select_2.length()>0&&!select_2.equalsIgnoreCase("SELECT")){ %>
			cRow.getElementsByClassName("select_2")[0].innerHTML=listOfEnquiry[i].select2;	
		<%} %>
		<%if(select_3.length()>0&&!select_3.equalsIgnoreCase("SELECT")){ %>
			cRow.getElementsByClassName("select_3")[0].innerHTML=listOfEnquiry[i].select3;
		<%} %>
		<%if(select_4.length()>0&&!select_4.equalsIgnoreCase("SELECT")){ %>
			cRow.getElementsByClassName("select_4")[0].innerHTML=listOfEnquiry[i].select4;
		<%} %>
		
		
		cRow.getElementsByClassName("storageId")[0].innerHTML=listOfEnquiry[i].PEProcessStateId;
		cRow.getElementsByClassName("createdOn")[0].innerHTML=listOfEnquiry[i].CreateDate;
		cRow.getElementsByClassName("status")[0].innerHTML=listOfEnquiry[i].Status;
		cRow.getElementsByClassName("process_ID")[0].innerHTML=listOfEnquiry[i].PEProcessStateId;
		
		switch (listOfEnquiry[i].Status) {
		case "Approved":
			cRow.getElementsByClassName("status")[0].classList.add("btn-success");
			break;
		case "Started":
			cRow.getElementsByClassName("status")[0].classList.add("btn-info");
			break;
		case "Rejected":
			cRow.getElementsByClassName("status")[0].classList.add("btn-default");
			break;

		default:
			break;
		}
		
 		
	        
        var td = cRow.lastElementChild;  
        var dot3=threedot.cloneNode(true);
        td.appendChild(dot3);
		tbody.appendChild(cRow);
	
		if(listOfEnquiry.length==0){
			document.getElementById("NoRecord").style.display="block";
		}else{
			document.getElementById("NoRecord").style.display="none";
		}
		
	
	}
	
	 YUI().use("node", "event", function(A) {
         var j = A.all(".threedot");
         j.on("click", function(o) {
             o.preventDefault();
             o.stopPropagation();
             var p = document.getElementsByClassName("Pop-Action");
             for (var l = 0; l < p.length; l++) {
                 p[l].classList.add("hide")
             }
             var m = o.currentTarget;
             var n = m.next();
             n.removeClass("hide")
         })
     })
     YUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
 				'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A){
 			
 			var container = A.one('body');
 			container.on('click', function(e){
 				var actionsBox = document.getElementsByClassName('Pop-Action');
 				for(var k = 0;k< actionsBox.length;k++){
 					actionsBox[k].classList.add('hide');
 				}
 			});
 			
 		});
}
function makePaging(totalPages, pageIndex) {
	var oPaging, i, j, k;
    var totalPages = parseInt(totalPages);
    pageIndex++;
    i = pageIndex;
    j = pageIndex - 1;
    k = pageIndex + 1;
    var oBefore = "", oAfter= "";
    var disable = false;
    if(i<=1) {
    	disable = true;
    }
    while (j != 0 && j != i - 6 && j>0) {
        oBefore = "<li id1='"+ j +"'><a  href='javascript:showPageList("+ j +")' data-index='" + (j - 1) + "'>" + j + "</a></li>" + oBefore;
        j--;
    }
    if(disable) {
    	oBefore = "<li id1='"+ (i-1) +"'><a class='prev' href='javascript:void(0)' data-index='" + (i-2) + "'>  </a></li>" + oBefore;
        oBefore = "<li id1='1'><a class='first' href='javascript:void(0)' data-index='1'>  </a></li>" + oBefore;
    } else {
    	oBefore = "<li id1='"+ (i-1) +"'><a class='prev' href='javascript:showPageList("+ (i-1) +")' data-index='" + (i-2) + "'>  </a></li>" + oBefore;
        oBefore = "<li id1='1'><a class='first' href='javascript:showPageList(1)' data-index='1'>  </a></li>" + oBefore;
    }
    for (; k <= totalPages && k < (i + 6) && k > 0; k++) {
        oAfter += "<li id2='"+ k +"'><a  href='javascript:showPageList("+ k +")' data-index='" + (k - 1) + "'>" + k + "</a></li>";
    }
    disable = false;
    if(i>=totalPages) {
    	disable = true;
    }
    if(disable) {
    	oAfter += "<li id2='"+ (i+1) +"'><a class='next' href='javascript:void(0)' data-index='" + (i) + "'>  </a></li>";
        oAfter += "<li id2='"+ (k-1) +"'><a class='last' href='javascript:void(0)' data-index='" + (k-2) + "'>  </a></li>";
    } else {
    	oAfter += "<li id2='"+ (i+1) +"'><a class='next' href='javascript:showPageList("+ (i+1) +")' data-index='" + (i) + "'>  </a></li>";
        oAfter += "<li id2='"+ (totalPages-1) +"'><a class='last' href='javascript:showPageList("+ totalPages +")' data-index='" + (totalPages-2) + "'>  </a></li>";
    }
    
    oPaging = "<ul  class='pagination-content'>" + oBefore + "<li id3='"+ i +"'><a class='selected' href='javascript:showPageList("+ i +")'>" + 
    i.toString() + "</a></li>" + oAfter + "</ul>";
    document.getElementById("jslarge").innerHTML = oPaging;
}

function doAction(action,d) {	
	AUI().use('liferay-portlet-url', function(A) {
	   var c = findAncestor(d, "Row");
	   var processId = c.getElementsByClassName("process_ID")[0].innerText;

	   var replaceDate = "<%=processStateUrl%>";
	   var res = replaceDate.replace("StorageId", processId);
	   console.log("rajjan"+ res);
	   window.location.href = res;
	});
}


function addNewRecord(d){
	AUI().use('liferay-portlet-url', function(A) {
	    var e =  Liferay.PortletURL.createRenderURL();
	    e.options.basePortletURL = "<%=layoutURL%>";
	    e.setWindowState("normal");
	    window.location.href = e.toString();
	 });
}
function findAncestor (el, cls) {
    while ((el = el.parentElement) && !el.classList.contains(cls));
    return el;
}
YUI().use('aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#startDate',
        mask : '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
        	  if (event.newSelection[0]) {
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
        trigger: '#endDate',
        mask : '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
        	  if (event.newSelection[0]) {
        		  setTimeout(function() { onDateSelect(); }, 500);
        	  }
            	console.log(event.newSelection)
          }
        }
      }
    );
  }
);


YUI().use('aui-toggler',
  function(Y) {
    new Y.TogglerDelegate(
      {
        animated: false,
        closeAllOnExpand: true,
        container: '#togglerSortColumn',
        content: '.content',
        expanded: false,
        header: '.header',
        transition: {
          duration: 0.2,
          easing: 'cubic-bezier(0, 0.1, 0, 1)'
        }
      }
    );
  }
);
		

</script>



