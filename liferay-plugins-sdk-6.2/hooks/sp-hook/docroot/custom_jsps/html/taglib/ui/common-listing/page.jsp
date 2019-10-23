<%@page import="java.net.URLEncoder"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="/html/js/sp/listing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
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
<portlet:resourceURL var="exportPdfUrl">
	<portlet:param name="action" value="exportPdf" />
</portlet:resourceURL>
<%
String portalURL = themeDisplay.getPortalURL();
String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:Listing:cssClass"), "social-share margin-top-half text-center");
String modelName  = GetterUtil.getString((String)request.getAttribute("sp-formio:Listing:modelName")) ;
int cssClassDiv1 = 9;
int cssClassDiv2 = 3;
boolean canAdd = PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"));
boolean canPrint = PermissionUtil.canPrintModel((PortletRequest) request.getAttribute("javax.portlet.request"));
if(modelName.equals("ProctorRostor")) {
	canAdd = false;
	canPrint = false;
}
if(modelName.equals("MasterTimeTable")) {
	canAdd = false;
}
if(!canAdd) {
	cssClassDiv1 = 10;
	cssClassDiv2 = 2;
}
if(request.getParameter("formTypeName") != "" && request.getParameter("formTypeName") != null){
	modelName = request.getParameter("formTypeName");
}
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String selectedCategory = portletPreferences.getValue("selectedCategory" , "");
String selectedUserType = portletPreferences.getValue("selectedUserType" , "");
String listHeaderName = portletPreferences.getValue("listHeaderPref" , "");
if(StringUtils.isEmpty(listHeaderName)) {
	listHeaderName = StringUtils.join(modelName.split("(?=\\p{Lu})"), " ").toUpperCase() + " LISTING";
}
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
						<h2>
							<span><%= listHeaderName %></span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	


<div class="formRoot">
	<div id='formio1' class="<%= cssClass %> container">


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
							placeholder="Search ${modelName}"
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
						  			 <div class="selectcolumns content toggler-content-collapsed">
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
												<% if(PermissionUtil.canExportModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
												<li><img src="/html/images/export.png" alt="List Export"><a
													href="javascript:void(0);" onclick="globalExportList(event);">Export</a></li>
							
												<% } if(PermissionUtil.canActivateModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
												<li class="deactivate globalAction" style="display:none;"><img src="/html/images/deactivate.svg"
													alt="List Deactivate"><a href="javascript:void(0);"
													onclick="globalDeactivateList('Inactive');">Deactivate</a></li>
							
												<% } if(PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
												<li class="archive globalAction" style="display:none;"><img src="/html/images/archive.png" alt="List Archive"><a
													href="javascript:void(0);" onclick="globalArchiveList();">Archive</a></li>
<%-- 												<% }  %> --%>
												
												<% } if(PermissionUtil.canRecordManuallyModel((PortletRequest) request.getAttribute("javax.portlet.request"))){  %>
												<li><img src="/html/images/expand.svg" alt="Record Manually"><a id="recordManually"
													href="javascript:void(0);" onclick="doRecordManuallyAction('recordmanually');">Record Manually</a></li>
													
												<% } if(canPrint){  %>
												
												 <li><img src="/html/images/expand.svg" alt="Print"><a
													href="javascript:void(0);" onclick="doExportAsPDF(event);">Print</a></li>
													
												<% } if(PermissionUtil.canRecordByBarcodeModel((PortletRequest) request.getAttribute("javax.portlet.request"))){  %>
												<li><img src="/html/images/expand.svg" alt="Record by Barcode Reader"><a id="recordByBarcode"
													href="javascript:void(0);" onclick="doRecordByBarcodeReaderAction();">Record by Barcode Reader</a></li>
													
											     <% } if(PermissionUtil.canSendNotificationForAttendance((PortletRequest) request.getAttribute("javax.portlet.request"))){  %>
													<li class="print"><img src="/html/images/expand.svg" alt="sendNotification"><a
													href="javascript:void(0);" onclick="sendNotification('sendnotification',this);">Send Notification</a></li>
													<% }  %>
											</ul>
									</div>
								
								</li>
						<%  if(canAdd){  %>
							<li>
								<button id="addnew" Class="addNew" onclick="addNewRecord(this)">ADD	NEW</button>
							</li>
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
				<div class="inner-container">
					<table id="tableId" class="aui">
						<thead>
							<tr class="Heading">
	
							</tr>
						</thead>
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


					<% if(PermissionUtil.canViewModel((PortletRequest) request.getAttribute("javax.portlet.request"))
							&& !modelName.equals("invigilatorAttendance") && !modelName.equals("candidateAttendance")){ %>
					<li><img src="/html/images/details.png" alt="Details"><a
						href="javascript:void(0);" onclick="doAction('detail',this);">Details</a></li>

					<% } if(PermissionUtil.canMasterViewModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="masterview"><img src="/html/images/master-view.png" alt="Master View"><a
						href="javascript:void(0);" onclick="doAction('masterview',this);">Master
							View</a></li>

					<% } if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/edit.png" alt="Edit"><a
						href="javascript:void(0);" onclick="doAction('edit',this);">Edit</a></li>

					<% } if(PermissionUtil.canCopyModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/copy.png" alt="Make a Copy"><a
						href="javascript:void(0);" onclick="doAction('copy',this);">Make
							a Copy</a></li>

					<% } if(PermissionUtil.canExportModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/export.png" alt="Export"><a
						href="javascript:void(0);" onclick="exportStorage1(event,this);">Export</a></li>

					<% } if(PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/aduit.png" alt="Audit Trail"><a
						href="javascript:void(0);" onclick="">Audit Trail</a></li>

					<% } if(PermissionUtil.canActivateModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="deactivate"><img src="/html/images/de-active.png"
						alt="Deactivate"><a href="javascript:void(0);"
						onclick="storageStatus1('Inactive',this);">Deactivate</a></li>

					<% } if(PermissionUtil.canActivateModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="activate"><img src="/html/images/de-active.png"
						alt="Activate"><a href="javascript:void(0);"
						onclick="storageStatus1('Active',this);">Activate</a></li>

					<% } if(PermissionUtil.canBlacklistModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="blacklist"><img src="/html/images/de-active.png"
						alt="Blacklist"><a href="javascript:void(0);"
						onclick="storageStatus1('Blacklist',this);">Blacklist</a></li>

					<% } if(PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li><img src="/html/images/archive.png" alt="Archive"><a
						href="javascript:void(0);" onclick="archiveStorage1(this);">"Archive"</a></li>
					<% } if(PermissionUtil.canConfirmModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="confirmed"><img src="/html/images/edit.png"
						alt="confirmed"><a href="javascript:void(0);"
						onclick="storageStatus1('Confirmed',this);">Confirmed</a></li>
					<% } if(PermissionUtil.canCancelModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
					<li class="cancelled"><img src="/html/images/de-active.png"
						alt="Cancel"><a href="javascript:void(0);"
						onclick="storageStatus1('Cancelled',this);">Cancelled</a></li>
				   <% } if(PermissionUtil.canRecordManuallyModel((PortletRequest) request.getAttribute("javax.portlet.request"))){  %>
					<li class="recordmanually"><img src="/html/images/expand.svg" alt="Record Manually"><a
					href="javascript:void(0);" onclick="doActionPopup('recordmanually',this);">Record Manually</a></li>
				 <% } if(PermissionUtil.canPrintModel((PortletRequest) request.getAttribute("javax.portlet.request"))){  %>
					<li class="print"><img src="/html/images/expand.svg" alt="Print"><a
					href="javascript:void(0);">Print</a></li>
				<% }  %>
				</ul>
			</div>
		</div>
	</div>
</div>
	<div class="yui3-skin-sam">
		<div id="archive-record" hidden="true" class="modalpopupBox">
			<div id="archive-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id ="archive_title">Are you sure about archiving this record ?</h3>
							<p id="archive_msg">You may have to contact admin to retrieve this record post
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
							<h3 id ="deactivate_title">Deactivate this record?</h3>
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
		<div id="cancelled-record" hidden="true" class="modalpopupBox">
			<div id="cancelled-record-box" class="modalpopupContent">
				<form class="formContainer" action="">


					<aui:row>
						<aui:col span="12">
							<h3 id ="cancel_title">Cancel this record?</h3>
							<p id ="cancel_msg">Please provide your reasons for cancel this record</p>
							<textarea cols="" rows="" id="cancel_reason"></textarea>

						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-confirm-cancel pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary popup-cancel-cancel pull-right">Cancel</button>
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
						<button class="btn btn-primary cancel popup-reactivate pull-left"
								type="button" onClick="reloadPage()">Start Again</button>
						<button class="btn cancel btn-primary popup-cancel pull-right"
								type="button" onClick="moveToDashboard()">DashBoard</button>
					</aui:col>
				</aui:row>

			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="action-error" hidden="true" class="modalpopupBox">
			<div id="action-error-box" class="modalpopupContent">
				<aui:row>
					<aui:col span="12">
						<h3 class="message">De-activation successful!</h3>
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
								class="btn btn-primary cancel popup-cancel-blacklist pull-right">Cancel</button>
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
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
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
						<button type="button"
							class="btn btn-primary backtolisting popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
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
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="cancelled-success" hidden="true" class="modalpopupBox">
			<div id="cancelled-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Cancelled!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist" onclick= "reload();">BACK TO LISTING</button>
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
</div>

</div>

<script type="text/javascript">

var availableColumns,masterColumns,exForm = [],columnsToShow =[],tableData,pageRequested = 1,itemsPerPage = 2,
namespace = "<portlet:namespace />",columnlist,totalRecords = 0,totalPages = 0,modelName = "<%= modelName %>";
var cssClassDiv1 = "<%= cssClassDiv1 %>";
var threedot = document.getElementById("threedot");
var portletns = "<portlet:namespace/>";
var ajaxurl = "<%= ajaxUrl.toString() %>";
var ajaxLock  = 0;
var userArray = [];
var baseUrl = "<%= portalURL + baseUrl %>";
var searchlisturl="<%=searchlisturl%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var filtercolumnlisturl="<%=filtercolumnlisturl%>";
var globalarchivelisturl="<%=globalarchivelisturl%>";
var globaldeactivatelisturl="<%=globaldeactivatelisturl%>";
var globalexportlisturl="<%=globalexportlisturl%>";
var exportstorageurl="<%=exportstorageurl%>";
var selectedCategory = "<%=selectedCategory%>";
var exportPdfUrl="<%=exportPdfUrl%>";
var selectedUserType="<%=selectedUserType%>"; 
if(modelName.toLowerCase() == "invigilatorattendance" || 
		modelName.toLowerCase() == "candidateattendance"){
		document.getElementById("recordManually").style["pointer-events"] = "none";
		document.getElementById("recordManually").style["opacity"] = "0.6";
		document.getElementById("recordByBarcode").style["pointer-events"] = "none";
		document.getElementById("recordByBarcode").style["opacity"] = "0.6";
}
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
<script>
window.addEventListener('click', function(e){
	
	if (!document.getElementsByClassName('oredercolumn')[0].contains(e.target) && 
			!document.getElementsByClassName('selectcolumns')[0].contains(e.target)&& 
			!document.getElementsByClassName('settingIcon')[0].contains(e.target)&& 
			!document.getElementsByClassName('orderIcon')[0].contains(e.target)){
		
		var oredercolumn= document.getElementsByClassName('oredercolumn')[0];
		var column_list= document.getElementsByClassName('selectcolumns')[0];
		
		var settingIcon= document.getElementsByClassName("settingIcon")[0];
		var orderIcon= document.getElementsByClassName("orderIcon")[0];
		
		if(oredercolumn.classList.contains('toggler-content-expanded')){
			document.getElementsByClassName("orderIcon")[0].click();
		}
		if(column_list.classList.contains('toggler-content-expanded')){
			document.getElementsByClassName("settingIcon")[0].click();
		}
		
  	} else{
  		
  	}
})

</script>