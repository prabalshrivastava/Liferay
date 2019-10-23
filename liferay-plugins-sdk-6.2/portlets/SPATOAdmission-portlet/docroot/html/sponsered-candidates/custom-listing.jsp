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
<%@page
	import="com.sambaash.platform.ato.service.SPATOAdmissionServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>




<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/sponsered-candidates/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/sponsered-candidates/portlet.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>


<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
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
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<%
	String portalURL = themeDisplay.getPortalURL();
String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:Listing:cssClass"), "social-share margin-top-half text-center");
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();
String userType=(String)  request.getAttribute("userType");
String atoName=(String)  request.getAttribute("atoName");

%>


<portlet:renderURL var="CreateNewURL">
	<portlet:param name="jspPage" value="wwww" />
</portlet:renderURL>

<style>
/* 	#togglerSortColumn ul li .header{ */
/* 		position:relative; */
/* 	} */
.Heading>th {
	padding: 15px !important;
}

.disabled {
	pointer-events: none;
	opacity: 0.6;
}
</style>
<div style="display: none;" class="alert" role="showAlert"
	id="alert_msg"></div>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>LIST OF ATO SPONSORED CANDIDATES</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div id='formio1' class="<%=cssClass%> container">


		<div class="dataListing">
			<div id="searchContainer" class="search-container container">
				<aui:row>
					<aui:col span="10">
						<div id="filterlist" class="selectedItem slectedItem">
							<ul>

							</ul>
						</div>
						<aui:input id="searchtextbox" cssClass="search-icon" type="text"
							name="text-code" placeholder="Search for Candidates..."
							onKeyPress="jsElasticSearchList(event,this.value);" />
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<div id="togglerSortColumn">
							<ul>
								<li>
									<h4 class="header toggler-header-collapsed orderIcon">
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
														<aui:col id="double-column-container" span="12">

														</aui:col>
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
									<div class="columns content toggler-content-collapsed">
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
									<button id="more-popover" Class="more"></button>
									<div id="MultirowPopAction"
										class="Multi-Pop-Action threedot hide">
										<ul id="mainpopup">
											<%
												if(PermissionUtil.canMarkVerifiedModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
											%>
											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);"
												onclick="setMarkAsVerifiedPopup(this,true)">Mark as
													verified</a></li>
											
											<%
												}
											%>
											<%
												if(PermissionUtil.canMarkSelfSponsoredModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
											%>
											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);"
												onclick="archiveStorage1(this,true)">Mark as 'Self
													Sponsored'</a></li>
											<%
												}
											%>
											<%
												if(PermissionUtil.canSendInvoiceModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
											%>
											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);" onclick="sendInvoice(this);">Send
													Invoice(s)</a></li>
											<%
												}
											%>
											<%
												if(PermissionUtil.canMakePaymentModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
											%>

											<li><img src="/html/images/export.png"
												alt="Make Payment"><a href="javascript:void(0); "
												onclick="makePaymentArr();")>Make Payment(s)</a></li>
											<%
												}
											%>
											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);" onclick="downloadPDF(event);" target="_blank">Download
													Invoice(s)</a></li>

											<li><img src="/html/images/export.png" alt="List Export"><a
												href="javascript:void(0);"
												onclick="globalExportList(event);">Export</a></li>
										</ul>
									</div>

								</li>

							</ul>
						</div>
					</aui:col>
				</aui:row>
				<aui:row id="oredercolumn"
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
				</aui:row>

				<aui:row id="columns"
					cssClass="content columns toggler-content-collapsed">
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
			<div class="no-data-listing" style="display: none">

				<div class="sambaashContent">
					<div class="container nodates">
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<h3 id="h3message" class="no-data-listing-message">No</h3>
								<p id="pmessage" class="no-data-listing-message">There
									aren't any records of existing s as of now. If you would like
									to create a new one, please click on the 'ADD NEW' button.</p>
								<a id="ahrefmessage" href="<%=dashBoardLink%>"
									title="BACK TO DASHBOARD" class="btn btn-primary">BACK TO
									DASHBOARD</a>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>

		</div>
		<div id="check-box">
			<input type="checkbox" name="selectval"
				onclick="selectThisValue(this)" style="opacity: 1; display: block;" />
		</div>
		<div id="threedot">
			<a href="#" class="threedot addInfo"><img
				src="/html/images/big.png" alt="Details"></a>
			<div id="popoverId" class="Pop-Action listingPopover hide">
				<ul>
					<%
						if(PermissionUtil.canMarkVerifiedModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>
					 <li><img src="/html/images/export.png" alt="List Export"><a
						href="javascript:void(0);"
						onclick="setMarkAsVerifiedPopup(this,false)">Mark as verified</a></li> 
<!-- 							<li><img src="/html/images/export.png" alt="List Export"><a -->
<!-- 						href="javascript:void(0);" -->
<!-- 						onclick="singleMarkAsVerify(this)">Mark as verified</a></li> -->

					<%
						} if(PermissionUtil.canMarkSelfSponsoredModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>

					<li><img src="/html/images/export.png" alt="List Export"><a
						href="javascript:void(0);" onclick="archiveStorage1(this,false)">Mark as 'Self Sponsored'</a></li>
					<%
						} if(PermissionUtil.canSendInvoiceModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>

					<li><img src="/html/images/export.png" alt="Send Invoice"><a
						href="javascript:void(0);" onclick="singleSendInvoice(this);">Send
							Invoice(s)</a></li>
					<%
						} if(PermissionUtil.canMakePaymentModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>

					<li><img src="/html/images/export.png" alt="Make Payment"><a
						href="javascript:void(0);" onclick="payOnline(this);">Make
							Payment(s)</a></li>
					<%
						} if(PermissionUtil.canDownloadInvoiceModel((PortletRequest) request.getAttribute("javax.portlet.request"))){
					%>

					<li><img src="/html/images/export.png" alt="List Export"><a
						href="javascript:void(0);"
						onclick="singleDownloadPDF(this,event);" target="_blank">Download Invoice(s)</a></li>
					<%
						}
					%>
					<li><img src="/html/images/export.png" alt="List Export"><a
						href="javascript:void(0);" onclick="exportBystorageId(event, this);">Export</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="yui3-skin-sam">
		<div id="archive-record" hidden="true" class="modalpopupBox">
			<div id="archive-record-box"
				class="modalpopupContent warningImageContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Mark these record(s) as 'Self Sponsored' ?</h3>
							<p>This cannot be undone. Are you sure about this?</p>

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
		<div id="mark-verified-record" hidden="true" class="modalpopupBox">
			<div id="mark-verified-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Mark these record(s) as 'Verified' ?</h3>
							<p>This cannot be undone. Are you sure about this?</p>

						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-confirm-verified pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary popup-cancel-verified pull-right">Cancel</button>
						</aui:col>
					</aui:row>

				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="invoice-success" hidden="true" class="modalpopupBox">
			<div id="invoice-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Invoice Sent successfully!</h3>

					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>


			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">


		<div id="deactive-record" hidden="false" class="modalpopupBox">
			<div id="deactive-record-box" class="modalpopupContent">
				<form class="formContainer" action="">


					<aui:row>
						<aui:col span="12">
							<h3>Deactivate this record?</h3>
							<p id="deactivate_msg">Please provide your reasons for
								deactivating this record</p>
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
							<p id="blacklist_msg">Please provide your reasons for
								blacklisting this record</p>
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
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
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
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
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
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
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
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
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
namespace = "<portlet:namespace />",columnlist,totalRecords = 0,totalPages = 0;

var threedot = document.getElementById("threedot");
var checkbox = document.getElementById("check-box");
var portletns = "<portlet:namespace/>";
var ajaxurl = "<%=ajaxUrl.toString()%>";
var ajaxLock  = 0;
var userArray = [];
var baseUrl = "<%=portalURL + baseUrl%>";
var searchlisturl="<%=searchlisturl%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var filtercolumnlisturl="<%=filtercolumnlisturl%>";
var globalarchivelisturl="<%=globalarchivelisturl%>";
var globaldeactivatelisturl="<%=globaldeactivatelisturl%>";
var globalexportlisturl="<%=globalexportlisturl%>";
var exportstorageurl="<%=exportstorageurl%>";
var exportPdfUrl="<%=exportPdfUrl%>";
var downloadPdfUrl="<%=downloadPdfUrl%>";
var userType = "<%=userType%>";
var atoName = "<%=atoName%>";
</script>
<script>
	YUI().use('aui-toggler', function(Y) {
		new Y.TogglerDelegate({
			animated : false,
			closeAllOnExpand : true,
			container : '#togglerSortColumn',
			content : '.content',
			expanded : false,
			header : '.header',
			transition : {
				duration : 0.2,
				easing : 'cubic-bezier(0, 0.1, 0, 1)'
			}
		});
	});
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/sponsered-candidates/sponsered-candidates.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>