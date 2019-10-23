<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/html/init.jsp" %>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/listing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<% 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.referencenumber.categorytype",request);
String switchProgrammeUrl = portletPreferences.getValue("switchProgrammeUrlPref", "");
String switchSubjectUrl = portletPreferences.getValue("switchSubjectUrlPref", "");
String processEnrollmentUrl = portletPreferences.getValue("processEnrollmentUrlPref", "");
String sendNotificationUrl = portletPreferences.getValue("sendNotificationUrlPref", "");
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 

%>
<c:set var="formType" value='<%= modelName %>' />

<script>
var config = {
		createPage: "/html/enrolment/view.jsp",
	    editPage: "/html/enrolment/candidate.jsp",
	    documentPage: "/html/candidatedocument/edit.jsp",
	    detailPage: "/html/enrolment/program.jsp"
	};
var basePage = "<%= td.getURLPortal() %>/";
</script>








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
<portlet:resourceURL var="exportstorageurl">
	<portlet:param name="action" value="exportRow" />
</portlet:resourceURL>
<portlet:resourceURL var="globalexportlisturl">
	<portlet:param name="action" value="exportList" />
</portlet:resourceURL>
<portlet:resourceURL var="globalarchivelisturl">
	<portlet:param name="action" value="archiveList" />
</portlet:resourceURL>
<portlet:resourceURL var="globaldeactivatelisturl">
	<portlet:param name="action" value="deactivateList" />
</portlet:resourceURL>
<%
String portalURL = themeDisplay.getPortalURL();
int cssClassDiv1 = 9;
int cssClassDiv2 = 3;
boolean canAdd = PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"));
if(!canAdd) {
	cssClassDiv1 = 10;
	cssClassDiv2 = 2;
}
if(request.getParameter("formTypeName") != "" && request.getParameter("formTypeName") != null){
	modelName = request.getParameter("formTypeName");
}
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String documentUrl = portletPreferences.getValue("documentUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();
%>

<portlet:renderURL var="CreateNewURL">
	<portlet:param name="jspPage" value="wwww" />
</portlet:renderURL>

<style>
/* 	#togglerSortColumn ul li .header{ */
/* 		position:relative; */
/* 	} */
		
		
</style>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span>ENROLMENT LISTING</span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	



	<div id='formio1' class="container">


		<div class="dataListing">
			<div id="searchContainer" class="search-container container">
				<div class="inner-container">
				<aui:row>
					<aui:col span="<%= cssClassDiv1 %>">
					<div id="filterlist" class="selectedItem slectedItem">
						<ul>
							
						</ul>
					</div>
					<aui:input id="searchtextbox" cssClass="search-icon" type="text" name="text-code"
							placeholder="Search Candidate"
							onKeyPress="jsElasticSearchList(event,this.value);" />
					</aui:col>
					<aui:col span="<%= cssClassDiv2 %>" cssClass="text-right">
						<div id="togglerSortColumn">
							<ul>
								<li>
									<h4 class="header toggler-header-collapsed orderIcon"><span></span></h4>
						  			<div class="content toggler-content-collapsed">
						  				
						  					<div id="oredercolumn"
												cssClass="oredercolumn toggler-content-collapsed">
													<div class="column-list">
													
														<aui:form id="filtercolumnform">
															<aui:row class="filtercolumnheader">
																<aui:col span="12" cssClass="text-center">
																	<p>Please select the values you would like to filter the
																		columns by</p>
																</aui:col>
															</aui:row>
															<aui:row class="column-list-filter">
																<aui:col id="double-column-container" span="12">
								
																</aui:col>
															</aui:row>
														</aui:form>
													</div>
											</div>
						  			
						  			</div>
						 
								</li>
								<li>
									 <h4 class="header toggler-header-collapsed settingIcon "><span></span></h4>
						  			 <div class="columns content toggler-content-collapsed">
						  			 	<div class="column-list">
											<aui:form>
												<aui:row>
													<aui:col span="12" cssClass="text-center">
														<div class="choose-col">
															<i></i>Choose Column fields in the order you would like them
															to be displayed in the table
														</div>
													</aui:col>
												</aui:row>
												<aui:row>
													<aui:col span="12">
														<aui:row>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="01"
																	id="select1">
																	<aui:option value="">Select</aui:option>
																</aui:select>
															</aui:col>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="02"
																	id="select2">
																	<aui:option value="">Select</aui:option>
																</aui:select>
															</aui:col>
														</aui:row>
														<aui:row>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="03"
																	id="select3">
																	<aui:option value="">Select</aui:option>
																</aui:select>
															</aui:col>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="04"
																	id="select4">
																	<aui:option value="">Select</aui:option>
																</aui:select>
															</aui:col>
														</aui:row>
														<aui:row>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="05"
																	id="select5">
																	<aui:option value="">Select</aui:option>
																</aui:select>
															</aui:col>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="06"
																	id="select6">
																	<aui:option value="">Select</aui:option>
																</aui:select>
															</aui:col>
														</aui:row>
														<aui:row>
															<aui:col span="6">
																<aui:select cssClass="form-fields-select" name="07"
																	id="select7">
																	<aui:option value="">Select</aui:option>
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
								<li>
									<button id="more-popover" Class="more">								
									</button>
									<div id="MultirowPopAction" class="Multi-Pop-Action threedot hide" >
										<ul>
									
											<li class="ProgrammeContextMenu"><img src="/html/images/process-enrolment.svg" class="enrollselection" alt="Process Enrolment"><a
											href="javascript:void(0);" onclick="processEnrolment(event);">Process Enrolment</a></li>
													
											<li class="ProgrammeContextMenu"><img src="/html/images/switch.svg" class="enrollselection" alt="Switch Programme"><a
											href="javascript:void(0);" onclick="switchProgramme(event);">Switch Programme</a></li>
											
											<li class="ProgrammeContextMenu"><img src="/html/images/switch.svg" class="enrollselection" alt="Switch Subject"><a
											href="javascript:void(0);" onclick="switchSubject(event);">Switch Subject</a></li>
											
											<li class="ProgrammeContextMenu"><img src="/html/images/email.svg" class="enrollselection" alt="Send Notification"><a
											href="javascript:void(0);" onclick="showNotification(event);">Send Notification</a></li>
											
											<li class="ProgrammeContextMenu"><img src="/html/images/switch.svg" class="enrollselection" alt="Add Special Arrangement"><a
											href="javascript:void(0);" onclick="specialArrangement(event);">Add Special Arrangement</a></li>
																							
											<% if(PermissionUtil.canExportModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);" onclick="globalExportList(event);">Export</a></li>
						
											<% } if(PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
											<li><img src="/html/images/archive.png" alt="List Archive"><a
												href="javascript:void(0);" onclick="globalArchiveList();">Archive</a></li>

											
											<% }  %>
										</ul>
									</div>
								
								</li>
						<%  if(canAdd){  %>
							<li><button id="addnew" Class="addNew" onclick="addNewRecord(this)">ADD
							NEW</button></li>
							<% }  %>			
								
							</ul>
 						</div>

					</aui:col>
				</aui:row>
				
				<aui:row id="oredercolumn" cssClass="oredercolumn toggler-content-collapsed">
					<div class="column-list">
						<aui:form id="filtercolumnform">
							<aui:row class="filtercolumnheader">
								<aui:col span="12" cssClass="text-center">
									<p>Please select the values you would like to filter the
										columns by</p>
								</aui:col>
							</aui:row>
							<aui:row class="column-list-filter">
								<aui:col id="double-column-container" span="12">

								</aui:col>
							</aui:row>
						</aui:form>
					</div>
				</aui:row>

				<aui:row id="columns" cssClass="content columns toggler-content-collapsed">
					<div class="column-list">
						<aui:form>
							<aui:row>
								<aui:col span="12" cssClass="text-center">
									<div class="choose-col">
										<i></i>Choose Column fields in the order you would like them
										to be displayed in the table
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12">
									<aui:row>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="01"
												id="select1">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="02"
												id="select2">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="03"
												id="select3">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="04"
												id="select4">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="05"
												id="select5">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="06"
												id="select6">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="6">
											<aui:select cssClass="form-fields-select" name="07"
												id="select7">
												<aui:option value="">Select</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
								</aui:col>
							</aui:row>

							<aui:row>
								<aui:col span="12" cssClass="text-center">
									<aui:button type="button" id="searchbtn"
										cssClass="btn-primary search" value="Save"></aui:button>

								</aui:col>
							</aui:row>
						</aui:form>
					</div>
				</aui:row>
</div>
			</div>
			<div class="data-lising">
				<table id="tableId" class="aui">
					<thead>
						<tr class="Heading">

						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>

			</div>
			<div class="pagination">
				<div class="inner-container">
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select cssClass="itemsPerPage" name="itemsPerPage"
							label="Items per page:">
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
									<%= modelName %>s as of now. If you would like to create a new
									one, please click on the 'ADD NEW' button.
								</p>
								<a id="ahrefmessage" href="<%= dashBoardLink %>" title="BACK TO DASHBOARD"
									class="btn btn-primary">BACK TO DASHBOARD</a>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>

		</div>
		<div id="threedot">
			<a href="#" class="threedot addInfo"><img
				src="/html/images/big.png" alt="Details"></a>
			<div id="popoverId" class="Pop-Action listingPopover hide">
				<ul>


					
				
					<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="editEnrolment" style="display:none"><img src="/html/images/edit.png" alt="Edit"><a
						href="javascript:void(0);" onclick="doAction('edit',this);">Edit</a></li>

					<% } if(PermissionUtil.canViewModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/edit.png" alt="Detail"><a
						href="javascript:void(0);" onclick="doAction('detail',this);">Detail</a></li>

					<% } if(PermissionUtil.canExportModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/export.png" alt="Export"><a
						href="javascript:void(0);" onclick="exportStorage1(event,this);">Export</a></li>
					<% }%>
					
					<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="processEnrolment" style="display:none"><img src="/html/images/process-enrolment.svg" alt="Process Enrolment"><a
						href="javascript:void(0);" onclick="processEnrolmentI(this);">Process Enrolment</a></li>
					<li class="switchProgramme" style="display:none"><img src="/html/images/switch.svg" alt="Switch Programme"><a
						href="javascript:void(0);" onclick="switchProgrammeI(this);">Switch Programme</a></li>
					<li class="switchSubjects" style="display:none"><img src="/html/images/switch.svg" alt="Switch Subjects"><a
						href="javascript:void(0);" onclick="switchSubjectI(this);">Switch Subjects</a></li>
					<li class="cancelEnrolment" style="display:none"><img src="/html/images/archive.png" alt="Cancel Enrolment"><a
						href="javascript:void(0);" onclick="storageStatus1('Cancelled',this,'<%= switchProgrammeUrl %>');">Cancel Enrolment</a></li>
					<li class="sendNotification"><img src="/html/images/email.svg" alt="Send Enrolment Notification"><a
						href="javascript:void(0);" onclick="showNotificationI(this);">Send Enrolment Notification</a></li>
					<li class="withdrawEnrolment" style="display:none"><img src="/html/images/archive.png" alt="Withdraw Enrolment"><a
						href="javascript:void(0);" onclick="storageStatus1('Withdrawn',this,'<%= switchProgrammeUrl %>');">Withdraw Enrolment</a></li>
					<li class="specialArrangement"><img src="/html/images/switch.svg" alt="Add Special Arrangement"><a
						href="javascript:void(0);" onclick="specialArrangementI(this);">Add Special Arrangement</a></li>
					<% } %>
				</ul>
			</div>
		</div>
	</div>

	<div class="yui3-skin-sam">
		<div id="archive-record" hidden="true" class="modalpopupBox">
			<div id="archive-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Are you sure about archiving this record ?</h3>
							<p>You may have to contact admin to retrieve this record post
								archival</p>

						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-confirm-archive pull-left">Confirm</button>
							<button type="button" 
								class="btn btn-primary popup-cancel-archive pull-right">Cancel</button>
						</aui:col>
					</aui:row>

				</form>
			</div>
		</div>
	</div>

	<div class="yui3-skin-sam">


		<div id="deactive-record" hidden="true" class="modalpopupBox">
			<div id="deactive-record-box" class="modalpopupContent">
				<form class="formContainer" action="">


					<aui:row>
						<aui:col span="12">
							<h3>Deactivate this record?</h3>
							<p id ="deactivate_msg">Please provide your reasons for deactivating this record</p>
							<textarea cols="" rows="" id="deactivate_reason"></textarea>

						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-confirm-deactivate pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary popup-cancel-deactivate pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>

			</div>
		</div>
	</div>

	<div class="yui3-skin-sam">
		<div id="deactivation-success" hidden="true" class="modalpopupBox">
			<div id="inactive-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>De-activation successful!</h3>
						<p>This record will not be in use anymore</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<!-- <button class="btn btn-primary popup-reactivate">Re-active</button> -->
						<button class="btn btn-primary cancel popup-reactivate"
								type="button" onClick="reloadPage()">Start Again</button>
						<button class="btn cancel btn-primary popup-cancel pull-right"
								type="button" onClick="moveToDashboard()">DashBoard</button>
					</aui:col>
				</aui:row>

			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div class="yui3-skin-sam">


		<div id="blacklist-record" hidden="true" class="modalpopupBox">
			<div id="blacklist-record-box" class="modalpopupContent">
				<form class="formContainer" action="">


					<aui:row>
						<aui:col span="12">
							<h3>Blacklist this record?</h3>
							<p id ="blacklist_msg">Please provide your reasons for blacklisting this record</p>
							<textarea cols="" rows="" id="blacklist_reason"></textarea>

						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="userAction">
							<button type="button"
								class="btn btn-default popup-confirm-blacklist pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary cancel popup-cancel-blacklist">Cancel</button>
						</aui:col>
					</aui:row>
				</form>

			</div>
		</div>
	</div>

	<div class="yui3-skin-sam">
		<div id="blacklist-success" hidden="true" class="modalpopupBox">
			<div id="blacklist-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Blacklist successful!</h3>
						<p>This record will not be in use anymore</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button" style="width: auto;"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
				

			</div>
		</div>
	</div>
	
	<div class="yui3-skin-sam">
		<div id="notified-success" hidden="true" class="modalpopupBox">
			<div id="notified-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Entrolment Notification Successful!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-default cancel popup-cancel-blacklist" onclick= "reload();">ENROLMENT LISTING</button>
							
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "home();">GO TO HOME</button>
					</aui:col>
				</aui:row>
				

			</div>
		</div>
	</div>


 <div class="yui3-skin-sam"> 
		<div id="activation-success" hidden="true" class="modalpopupBox">
			<div id="active-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Activation successful!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button" style="width: auto;"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>

			</div>
		</div>
	</div> 
	<div class="yui3-skin-sam">
		<div id="confirmed-success" hidden="true" class="modalpopupBox">
			<div id="confirmed-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Confirmed!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button" style="width: auto;"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	
	<div class="yui3-skin-sam">


		<div id="cancel-record" hidden="true" class="modalpopupBox">
			<div id="cancel-record-box" class="modalpopupContent">
				<form class="formContainer" action="">


					<aui:row>
						<aui:col span="12">
							<h3>Cancel Enrolment ?</h3>
							<p id ="cancel_msg">Reason for cancellation</p>
							<textarea cols="" rows="" id="cancel_reason"></textarea>

						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="userAction">
							<button type="button"
								class="btn btn-primary popup-confirm-cancellation pull-left">Confirm</button>
							<button type="button"
								class="btn btn-default cancel popup-cancel-blacklist">Cancel</button>
						</aui:col>
					</aui:row>
				</form>

			</div>
		</div>
	</div>	
	
	<div class="yui3-skin-sam">
		<div id="cancelled-success" hidden="true" class="modalpopupBox">
			<div id="cancelled-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Enrolment Cancelled Successfully</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button" style="width: auto;"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="yui3-skin-sam">
		<div id="withdraw-record" hidden="true" class="modalpopupBox">
			<div id="withdraw-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Withdraw Enrolment ?</h3>
							<p id ="withdraw_msg">Reason for withdrawing</p>
							<textarea cols="" rows="" id="withdraw_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="userAction">
							<button type="button"
								class="btn btn-primary popup-confirm-withdraw pull-left">Confirm</button>
							<button type="button"
								class="btn btn-default cancel popup-withdraw-blacklist">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>	

	<div class="yui3-skin-sam">
		<div id="withdraw-success" hidden="true" class="modalpopupBox">
			<div id="withdraw-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Enrolment Withdrawn Successfully</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button" style="width: auto;"
							class="btn btn-primary cancel popup-withdraw-blacklist" onclick= "reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

<div class="loadingDiv" id="loadingDiv">
	<div class="m-blockui"
		style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
		<span>Please Wait</span> <span>
			<div class="m-loader m-loader--brand"></div>
		</span>
	</div>
</div>



<div class="addEntityDetails" id="notificationTypeDiv" style="display: none;">
	<div class="slideTop">
	   <div class="row-fluid " id="yui_patched_v3_11_0_1_1552481049704_753">
	      <div class="span12 text-center" id="yui_patched_v3_11_0_1_1552481049704_752">
	       <h2>CONFIGURE NOTIFICATIONS</h2>
	      </div>
	   </div>
	   <div class="row-fluid " id="">
	      <div class="span4" id="">
	      </div>
	      <div class="span4 text-center" id="">
	         <label class="text-left">Notification Type</label>
	         <select id="inp_notification_type">
	           <% for(SPListType notificationType: SPListTypeLocalServiceUtil.getByKey("enrolment.email.notification.type", themeDisplay.getScopeGroupId())) {%>
	           		<option value="<%=notificationType.getItemValue()%>" class="<%=notificationType.getItemValue()%>"><%=notificationType.getDisplayName()%></option>
	           <%}%>
	         </select>
	      </div>
	      
	   </div>
	   <div class="row-fluid userAction" id="">
	      <div class="span4 " id="">
	      </div>
	      <div class="span4 publishDetails text-center" id="">
	         <button class="btn btn-primary" type="button" onclick="sendNotificationListPage()" style="padding:10px 20px!important;">SEND EMAIL</button> 
	         <button class="btn btn-default" type="button" onclick="hidenotificationTypeDiv()">CANCEL</button>
	         <br/><br/>
	      </div>
	   </div>
	</div>
</div>

<div class="addEntityDetails" id="specialArrangementContainer" style="display: none;">
	<div class="slideTop">
	   <div class="row-fluid ">
	      <div class="span12 text-center">
	       <h2>SPECIAL ARRANGEMENT</h2>
	      </div>
	   </div>
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				<p id ="special_arrangement_label">Special Arrangement Remarks</p>
				<textarea class="span10" cols="" rows="" id="special_arrangement"></textarea>
			</aui:col>
		</aui:row>
	   <div class="row-fluid userAction">
	      <div class="span4 ">
	      </div>
	      <div class="span4 publishDetails text-center">
	         <button class="btn btn-primary" type="button" onclick="saveSpecialArrangement()" style="padding:10px 20px!important;">SAVE SPECIAL ARRANGEMENT</button> 
	         <button class="btn btn-default" type="button" onclick="hideSpecialArrangementContainer()">CANCEL</button>
	         <br/><br/>
	      </div>
	   </div>
	</div>
</div>

</div>

<script type="text/javascript">
const VIEW_MODE = "<%=EnrolmentConstants.VIEW_MODE%>";
const EDIT_MODE = "<%=EnrolmentConstants.EDIT_MODE%>";
const CANCEL_MODE = "<%=EnrolmentConstants.CANCEL_MODE%>";
const WITHDRAW_MODE = "<%=EnrolmentConstants.WITHDRAW_MODE%>";

var availableColumns,masterColumns,exForm = [],columnsToShow =[],tableData,pageRequested = 1,itemsPerPage = 2,
namespace = "<portlet:namespace />",columnlist,totalRecords = 0,totalPages = 0,modelName = "<%= modelName %>";
var cssClassDiv1 = "<%= cssClassDiv1 %>";
var threedot = document.getElementById("threedot");
var portletns = "<portlet:namespace/>";
var ajaxurl = "<%= ajaxUrl.toString() %>";
var ajaxLock  = 0;
var userArray = [];
var baseUrl = "<%= portalURL + baseUrl %>";
var editUrl = "<%= processEnrollmentUrl.substring(0, processEnrollmentUrl.indexOf('?'))  %>";
var documentUrl = "<%= portalURL + documentUrl %>";
var searchlisturl="<%=searchlisturl%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var filtercolumnlisturl="<%=filtercolumnlisturl%>";
var globalarchivelisturl="<%=globalarchivelisturl%>";
var globaldeactivatelisturl="<%=globaldeactivatelisturl%>";
var globalexportlisturl="<%=globalexportlisturl%>";
var exportstorageurl="<%=exportstorageurl%>";
var enrolmentIds = [];
var enrolmentIdsSelected;
var EMS_SCOPE_GROUP_ID = <%= SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()) %>;
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;

</script>
<script>
YUI().use(
		  'aui-toggler',
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


<% } %>	

<script>
function addNewRecord(d){
	AUI().use('liferay-portlet-url', function(A) {
	    var e =  Liferay.PortletURL.createRenderURL();
	    e.options.basePortletURL = baseUrl;
	    jspPage = config.createPage;
	    e.setParameter("formTypeName", modelName);
	    e.setParameter("jspPage", jspPage);
	    e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
	    e.setWindowState("normal");
	    //window.location.href = e.toString();
	    var pattern = /__/g;
	    var dd = e.toString();
	    window.location.href = dd.replace(pattern,"_").replace(/candidatelist/g, 'candidate');
	   
	 });
}

function doAction(action,d) {	
	AUI().use('liferay-portlet-url', function(A) {
	   var c = findAncestor(d, "Row");
	   var rownum = c.getAttribute("rownum");
	   var userId = tableData[rownum].contentJson.UserId;
	   var enrolmentId = tableData[rownum].contentJson.enrolmentId;
	   
	   var sponsorshipType = tableData[rownum].contentJson.SponsorshipType;
	   var corporateCode = tableData[rownum].contentJson.hasOwnProperty("CorporateCode") ? tableData[rownum].contentJson.CorporateCode : null;
	   var corporateName = tableData[rownum].contentJson.hasOwnProperty("CorporateName") ? tableData[rownum].contentJson.CorporateName : null;

	   var a = [];
	   for (var b = 0; b < c.childElementCount; b++) {
	       a.push(c.children[b].textContent.trim())
	   }
	   var e =  Liferay.PortletURL.createRenderURL();
	   e.options.basePortletURL = baseUrl;
	   if(action == 'masterview'){
		   openMaterView(userId);
	   }
	   else if(action == 'Cancelled' || action == 'Withdrawn'){
		   updateEnrolmentStatus(action,enrolmentId);
	   }
	   else{
		   console.log(action);console.log(config);
		   e.setParameter("formTypeName", modelName);
		   
		   e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		   e.setWindowState("normal");
		   
		   if(action == 'edit'){
			   e.options.basePortletURL = editUrl;
			   e.setParameter("jspPage", config.editPage);   
			   e.setParameter("userId", userId);
			   e.setParameter("storageId",userId );
			   e.setParameter("enrolmentId", enrolmentId);
			   e.setParameter("sponsorshiptype", sponsorshipType);
			   e.setParameter("<%=EnrolmentConstants.VIEW_MODE_PARAM%>", "<%=EnrolmentConstants.EDIT_MODE%>");
		   }
		   if(action == 'detail'){
			   e.options.basePortletURL = editUrl;
			   e.setParameter("jspPage", config.detailPage);
			   e.setParameter("candidateId", userId);
			   e.setParameter("storageId", enrolmentId);
			   e.setParameter("sponsorshiptype", sponsorshipType);
			   e.setParameter("<%=EnrolmentConstants.VIEW_MODE_PARAM%>", "<%=EnrolmentConstants.VIEW_MODE%>");
		   }else{
			   e.setParameter("storageId",userId );
		   }
		   if (sponsorshipType === "Corporate") {
			   e.setParameter("corporatecode", corporateCode);
			   e.setParameter("corporatename", corporateName);
		   }
		   console.log(e.toString().replace(/enrolmentlisting/g, 'enrolment'));
		   window.location.href =  e.toString().replace(/enrolmentlisting/g, 'enrolment');
	   
		   
	   }
	});
}
var ajaxUrl = ajaxurl;
var mode = "view";
function openMaterView(storageId){
	
	var data1 = {"formStorageId":storageId};
	ajaxCallAPI('GET','fetchScreenName',data1,
	 	function() {
			
              var response = this.get("responseData");
              
              if (_.isEmpty(response)) {
                  console.log("error");
                  
              } else {
            	  window.location.href = basePage + response;
              }
          },
          function() {
              
   		});
	
}
function updateEnrolmentStatus(action,enrolmentId){
	var data = {
	        "enrolmentId": enrolmentId,
	        "formType": "enrolment",
	        "endPoint": "updateEnrolment",
	        "EnrolmentStatus": action,
	        "categoryMap":JSON.stringify(categoryMap),
	        "reason":document.getElementById("cancel_reason").value
	    };
	ajaxCall(
	        "POST",
	        "sendRequest",
	        ajaxurl,
	        data,
	        function() {
	            var data = this.get("responseData");
	            if (_.isEmpty(data)) {
	                console.log("error");
	            } else {
	            	showPopupSuccess(action,"");
	            }
	        },
	        function() {

	        });
	
}
function processEnrolment(){
	var processEnrollmentUrl = "<%= processEnrollmentUrl %>" + "&schedule_code=" + filterStoreData["contentJson.ScheduleCode"][0] + "&programme_code=" + filterStoreData["contentJson.ProgrammeCode"][0] ;
	processEnrollmentUrl = addEnrolmentIdsStorageKey(processEnrollmentUrl);
	console.log(processEnrollmentUrl);
	window.location.href = processEnrollmentUrl;
}
function switchProgramme(){
	var switchProgrammeUrl = "<%= switchProgrammeUrl %>" + "&schedule_code=" + filterStoreData["contentJson.ScheduleCode"][0] + "&programme_code=" + filterStoreData["contentJson.ProgrammeCode"][0] ;
	switchProgrammeUrl = addEnrolmentIdsStorageKey(switchProgrammeUrl);
	console.log(switchProgrammeUrl);
	window.location.href = switchProgrammeUrl;
}
function switchSubject(){
	var switchSubjectUrl = "<%=  switchSubjectUrl %>" + "&schedule_code=" + filterStoreData["contentJson.ScheduleCode"][0] + "&programme_code=" + filterStoreData["contentJson.ProgrammeCode"][0] ;
	switchSubjectUrl = addEnrolmentIdsStorageKey(switchSubjectUrl);
	console.log(switchSubjectUrl);
	window.location.href = switchSubjectUrl;
}

function processEnrolmentI(d){
	var c = findAncestor(d, "Row");
	var rownum = c.getAttribute("rownum");
	var enrolmentId = tableData[rownum].contentJson.enrolmentId;
	var programmeCode = tableData[rownum].contentJson.ProgrammeCode;
	var scheduleCode = tableData[rownum].contentJson.ScheduleCode;
	//alert(enrolmentId);
	var processEnrollmentUrl = "<%= processEnrollmentUrl %>" + "&schedule_code=" + scheduleCode + "&programme_code=" + programmeCode+ "&enrolmentId=" + enrolmentId ;
	
	console.log(processEnrollmentUrl);
	window.location.href = processEnrollmentUrl;
}

function addEnrolmentIdsStorageKey(url){
	return url + "&enrolmentIdsKey=" + storeEnrolmentIdsInSessionAndReturnKey();
}

function switchProgrammeI(d){
	var c = findAncestor(d, "Row");
	var rownum = c.getAttribute("rownum");
	var enrolmentId = tableData[rownum].contentJson.enrolmentId;
	var programmeCode = tableData[rownum].contentJson.ProgrammeCode;
	var scheduleCode = tableData[rownum].contentJson.ScheduleCode;
	var switchProgrammeUrl = "<%= switchProgrammeUrl %>" + "&schedule_code=" + scheduleCode + "&programme_code=" + programmeCode+ "&enrolmentId=" + enrolmentId ;
	
	console.log(switchProgrammeUrl);
	window.location.href = switchProgrammeUrl;
}
function switchSubjectI(d){
	var c = findAncestor(d, "Row");
	var rownum = c.getAttribute("rownum");
	var enrolmentId = tableData[rownum].contentJson.enrolmentId;
	var programmeCode = tableData[rownum].contentJson.ProgrammeCode;
	var scheduleCode = tableData[rownum].contentJson.ScheduleCode;
	var switchSubjectUrl = "<%=  switchSubjectUrl %>" + "&schedule_code=" + scheduleCode + "&programme_code=" + programmeCode+ "&enrolmentId=" + enrolmentId ;
	
	console.log(switchSubjectUrl);
	window.location.href = switchSubjectUrl;
}
function specialArrangementI(d) {
	var c = findAncestor(d, "Row");
	var rownum = c.getAttribute("rownum");
	var enrolmentId = tableData[rownum].contentJson.enrolmentId;
	document.getElementById("specialArrangementContainer").style.display = "block";
	enrolmentIdsSelected = [];
	enrolmentIdsSelected[0] = enrolmentId;
}
function specialArrangement(){
	enrolmentIdsSelected = enrolmentIds;
	document.getElementById("specialArrangementContainer").style.display = "block";
}
function saveSpecialArrangement(){
	if (!AUI().one('#special_arrangement').val()) {
		AUI().one('#special_arrangement_label').addClass("alert alert-error");
		return;
	} else {
		AUI().one('#special_arrangement_label').removeClass("alert alert-error");
	}
	SambaashUtils.applyContentJsonPatch(EMS_SCOPE_GROUP_ID, 'enrolment', 
		enrolmentIdsSelected.join(), 
		{specialArrangement: true, specialArrangementRemarks: AUI().one('#special_arrangement').val()},
		function() {
			hideSpecialArrangementContainer();
			alert("Special Arrangement Saved.");
		}
	);
}
function hideSpecialArrangementContainer(){
	AUI().one('#special_arrangement_label').removeClass("alert alert-error");
	AUI().one('#special_arrangement').val("");
	document.getElementById("specialArrangementContainer").style.display = "none";
}

function showNotificationI(d){
	var c = findAncestor(d, "Row");
	var rownum = c.getAttribute("rownum");
	var enrolmentId = tableData[rownum].contentJson.enrolmentId;
	document.getElementById("notificationTypeDiv").style.display = "block";
	enrolmentIdsSelected = [];
	enrolmentIdsSelected[0] = enrolmentId;
	if (tableData[rownum].contentJson.EnrolmentStatus && tableData[rownum].contentJson.EnrolmentStatus === 'Verified') {
		AUI().one(".feesacknowledgement").show();
		AUI().one('#inp_notification_type').val("feesacknowledgement");
	} else {
		AUI().one(".feesacknowledgement").hide();
		AUI().one('#inp_notification_type').val("");
	}
}
function showNotification(){
	enrolmentIdsSelected = enrolmentIds;
	document.getElementById("notificationTypeDiv").style.display = "block";
}

function sendNotificationListPage(notificationType, storageIds){
	if (!notificationType) { // so we can pass specific notification as parameter
		notificationType = document.getElementById("inp_notification_type").value;
	}
	if (!storageIds) { // so we can pass specific enrolment id as parameter
		storageIds = enrolmentIdsSelected;
	}
	var data = {
	        "enrolmentIds": storageIds,
	        "formType": "enrolment",
	        "endPoint": "fetchEnrolments",
	        "notificationType": notificationType
	    };
	ajaxCall(
	        "POST",
	        "sendNotification",
	        ajaxurl,
	        data,
	        function() {
	            var data = this.get("responseData");
	            if (_.isEmpty(data)) {
	                console.log("error");
	            } else {
	                
	                updateBatchEnrolmentStatus("Notified",storageIds);
	            }
	        },
	        function() {

	        });
}
function updateBatchEnrolmentStatus(action,enrolmentIds){
	SambaashUtils.applyContentJsonPatch(EMS_SCOPE_GROUP_ID, 
		'enrolment', enrolmentIds.join(), {EnrolmentStatus: action},
        function(data) {
			try {
	            if (_.isEmpty(data) || data.hasOwnProperty("error")) {
	                console.log("error", data.error);
	            } else {
	            	showPopupSuccess(action,"");
	            }				
			} catch (e) {
				console.log("updateBatchEnrolmentStatus unhandled exception", e);
			}
        }
	);
}
function hidenotificationTypeDiv(){
	document.getElementById("notificationTypeDiv").style.display = "none";
}
function home(){
	window.location.href = "/";
}

</script>
<style>
.ProgrammeContextMenu{
	display:none;
}
</style>