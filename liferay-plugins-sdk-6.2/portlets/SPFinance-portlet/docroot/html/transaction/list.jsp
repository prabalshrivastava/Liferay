<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/transaction.css?minifierType=css'></link>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
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
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<portlet:resourceURL var="exportPdfUrl">
	<portlet:param name="action" value="preparePdf" />
</portlet:resourceURL>
<portlet:resourceURL var="exportPaymentAdviceExcel">
	<portlet:param name="action" value="exportPaymentAdviceExcel" />
</portlet:resourceURL>
<%
String portalURL = themeDisplay.getPortalURL();
String userId = request.getParameter("userId");
String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:Listing:cssClass"), "social-share  text-center");
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "TransactionMaster");
String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
String listHeader = portletPreferences.getValue(FinanceConstants.PREF_LIST_HEADER, "LISTING OF INVOICES");
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();
Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
Map<String, String> claimMap = SPFinanceLocalServiceUtil.getClaimMap(request);
Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap(request);
Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.transaction.sourcetype", request);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
String serverCurrDate = sdf.format(new Date());
SPParameter baseCurrencyParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(), 
		"base_currency");
Long groupId = themeDisplay.getLayout().getGroupId();
List<SPListType> miscFeeList = SPListTypeLocalServiceUtil
.getByKey("priceengine.pricesubscheme.miscfees.pricesubtype", groupId);
%>
<portlet:renderURL var="CreateNewURL">
	<portlet:param name="jspPage" value="wwww" />
</portlet:renderURL>
<script>
var config = {
	    createPage: "/html/transaction/create.jsp",
	    editPage: "/html/transaction/edit.jsp",
	    detailPage: "/html/transaction/view.jsp",
	    copyPage: "/html/transaction/copy.jsp",
	    collectPaymentPage: "/html/transaction/collect-payment.jsp",
	    collectPaymentEditPage: "/html/transaction/collect-payment-edit.jsp",
	    paymentProcessPage: "/html/transaction/process-payment.jsp"
	};
</script>
<style>
.custom-tooltip {
    position: relative;
    display: inline-block;
    color: #006080;
}

.custom-tooltip .tooltiptext {
    visibility: hidden;
    position: absolute;
    width: 500px;
    background-color: #555;
    color: #fff;
    text-align: center;
    padding: 5px 0;
    border-radius: 6px;
    z-index: 1;
    opacity: 0;
    transition: opacity 0.8s;
}

.custom-tooltip:hover .tooltiptext {
    visibility: visible;
    opacity: 1;
}

.tooltip-left {
  top: 0px;
    bottom: auto;
    right: 110%;  
}
.tooltip-left::after {
    content: "";
    position: absolute;
    top: 50%;
    left: 100%;
    margin-top: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: transparent transparent transparent #555;
}
</style>
<% 
if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
%>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2><span><%=listHeader%></span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	</div>
	<div class="formRoot">
		
	<div id='formio1' class="<%=cssClass%> container">
		<div class="dataListing">
			<div id="searchContainer" class="search-container container">
				<div class="inner-container">
				<aui:row>
					<aui:col span="9">
						<div id="filterlist" class="selectedItem slectedItem">
							<ul>

							</ul>
						</div>
						<aui:input id="searchtextbox" cssClass="search-icon" type="text"
							name="text-code" placeholder="Search ${modelName}"
							onKeyPress="jsElasticSearchList(event,this.value);" />
					</aui:col>
					<aui:col span="3" cssClass="text-right">
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
										<ul>
											<% if(categoryType.equals("IN")) { %>
												<% if (PermissionUtil.canExportModel((PortletRequest) request.getAttribute("javax.portlet.request"))) { %>
													<li><img src="/html/images/export.png" alt="List Export"><a
														href="javascript:void(0);"
														onclick="globalExportList(event);">Export</a></li>

												<% } if (PermissionUtil.canActivateModel((PortletRequest) request.getAttribute("javax.portlet.request"))) { %>
													<!-- <li class="deactivate"><img
														src="/html/images/deactivate.svg" alt="List Deactivate"><a
														href="javascript:void(0);"
														onclick="globalDeactivateList('Inactive');">Deactivate</a></li> -->
												<% } if (PermissionUtil.canDeleteModel((PortletRequest) request.getAttribute("javax.portlet.request"))) { %>
													<!-- <li><img src="/html/images/archive.png"
														alt="List Archive"><a href="javascript:void(0);"
														onclick="globalArchiveList();">Archive</a></li> -->
												<% } %>
											<% } else if(categoryType.equals("RE")) { %>
												<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
													<li id="generateLORMenu" style="display:none">
														<img src="<%=request.getContextPath()%>/images/report.png" alt="Generate & Submit LOR">
														<a href="javascript:void(0);" onclick="checkAndSubmitLOR()">GENERATE AND SUBMIT LOR</a>
													</li>
													<li id="gvoid" style="display:none">
														<img src="<%=request.getContextPath()%>/images/remove.png" alt="Void/Cancel" />
														<a href="javascript:void(0);" onclick="doInvoiceGlobalAction('void');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.receipt.voidcancel")%>
														</a>
													</li>
													<li id="gcancel" class="" style="display:none">
														<img src="<%=request.getContextPath()%>/images/remove.png" alt="Void/Cancel" />
														<a href="javascript:void(0);" onclick="doInvoiceGlobalAction('cancel');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.receipt.voidcancel")%>
														</a>
														<span id="voidcanceltooltip" style="display:none" class="tooltiptext tooltip-left">This option is disabled due to results having mixed receipt functions</span>
													</li>
												<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
													<li id="gapprove" style="display:none">
														<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve" />
														<a href="javascript:void(0);" onclick="doInvoiceGlobalAction('approve');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
														</a>
													</li>
													<li id="greject" style="display:none">
														<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject" />
														<a href="javascript:void(0);" onclick="doInvoiceGlobalAction('reject');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.reject")%>
														</a>
													</li>
													<li id="greturn" style="display:none">
														<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
														<a href="javascript:void(0);" onclick="doInvoiceGlobalAction('return');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
														</a>
													</li>
												<% } %>
											<% } else if(categoryType.equals("PA")) { %>
													<li>
														<img src="/html/images/export.png" alt="List Export">
														<a href="javascript:void(0);" onclick="globalExportList(event);">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.global.contextmenu.export")%>
														</a>
													</li>
													<li>
														<img src="/html/images/export.png" alt="List PDF">
														<a href="javascript:void(0);" onclick="doPDFExport('PDF');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.global.contextmenu.exportPDF")%>
														</a>
													</li>
													<li>
														<img src="/html/images/export.png" alt="List CSV">
														<a href="javascript:void(0);" onclick="doPDFExport('CSV');">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.global.contextmenu.bif")%>
														</a>
													</li>
													<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
													<li id="massProcessPaymentMenu">
														<img src="<%=request.getContextPath()%>/images/payment.png" srcset="<%=request.getContextPath()%>/images/payment@2x.png 2x, <%=request.getContextPath()%>/images/payment@3x.png 3x" class="payment-icon">
														<a href="javascript:void(0);" onclick="doMassProcessPayment()">
															<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.global.contextmenu.processpayment")%>
														</a>
													</li>
													<% } %>
													<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
													<li id="gapprove"><img
														src="<%=request.getContextPath()%>/images/submit.png"
														alt="Approve"> <a href="javascript:void(0);"
														onclick="doPaymentProcessAction('gapprove',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%></a></li>
													<li id="greject">
														<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject">
														<a href="javascript:void(0);" onclick="doPaymentProcessAction('greject',this);">
														<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.reject")%></a></li>
													<li id="gsamendments"><img
														src="<%=request.getContextPath()%>/images/return.png"
														alt="Return to submitter for Amendments"> <a
														href="javascript:void(0);"
														onclick="doPaymentProcessAction('gsamendments',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay,
															"workflow.return.submitter")%></a></li>
													<li id="gvamendments"><img
														src="<%=request.getContextPath()%>/images/return.png"
														alt="Return to verifier for Amendments"> <a
														href="javascript:void(0);"
														onclick="doPaymentProcessAction('gvamendments',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay,
															"workflow.return.verifier")%></a></li>
													<% } %>
											<% } %>
										</ul>
									</div>
								</li>
							</ul>
						</div>
					</aui:col>
				</aui:row>
				</div>
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
			<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
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
									<%=modelName%></h3>
								<p id="pmessage" class="no-data-listing-message">
									There aren't any records of existing
									<%=modelName%>s as of now. If you would like to create a new
									one, please click on the 'ADD NEW' button.
								</p>
								<a id="ahrefmessage" href="<%=dashBoardLink%>"
									title="BACK TO DASHBOARD" class="btn btn-primary">BACK TO
									DASHBOARD</a>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>
		</div>
		
		<!-- context menu -->
		<div id="threedot">
			<a href="#" class="threedot addInfo"><img
				src="/html/images/big.png" alt="Details"></a>
			<div id="popoverId" class="Pop-Action listingPopover hide">
				<ul>
					<% if(categoryType.equals("IN")) { %>
						<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
						<li class="submit">
							<img src="<%=request.getContextPath()%>/images/submit.png" alt="Submit For Approval" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('submit',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.approval")%>
							</a>
						</li>
						<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE) || 
								SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<li class="view">
							<img src="<%=request.getContextPath()%>/images/detail.png" alt="Details" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('view',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.view.details")%>
							</a>
						</li>
						<li class="pdf">
							<img src="<%=request.getContextPath()%>/images/report.png" alt="View" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('pdf',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.invoice.view")%>
							</a>
						</li>
						<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<li class="approve">
							<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('approve',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
							</a>
						</li>
						<li class="reject">
							<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('reject',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.reject")%>
							</a>
						</li>
						<li class="return">
							<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('return',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
							</a>
						</li>
						<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
						<li class="void">
							<img src="<%=request.getContextPath()%>/images/remove.png" alt="Void" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('void',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.invoice.voidcancel")%>
							</a>
						</li>
						<li class="cancel">
							<img src="<%=request.getContextPath()%>/images/remove.png" alt="Void" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('cancel',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.invoice.voidcancel")%>
							</a>
						</li>
						<% } %>
					<% } else if(categoryType.equals("RE")) { %>
						<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE) || 
								SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<li class="view">
							<img src="<%=request.getContextPath()%>/images/detail.png" alt="Details" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('view',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.view.details")%>
							</a>
						</li>
						<li class="pdf">
							<img src="<%=request.getContextPath()%>/images/receipts.png" alt="View" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('pdf',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.receipt.view")%>
							</a>
						</li>
						<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
						<li class="edit">
							<img src="<%=request.getContextPath()%>/images/edit.png" alt="Edit" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('edit',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.receipt.edit")%>
							</a>
						</li>
						<li class="void">
							<img src="<%=request.getContextPath()%>/images/remove.png" alt="Void/Cancel" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('void',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.receipt.voidcancel")%>
							</a>
						</li>
						<li class="cancel">
							<img src="<%=request.getContextPath()%>/images/remove.png" alt="Void/Cancel" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('cancel',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.receipt.voidcancel")%>
							</a>
						</li>
						<% } if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<li class="approve">
							<img src="<%=request.getContextPath()%>/images/submit.png" alt="Approve" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('approve-receipt',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
							</a>
						</li>
						<li class="reject">
							<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('reject',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.reject")%>
							</a>
						</li>
						<li class="return">
							<img src="<%=request.getContextPath()%>/images/return.png" alt="Return" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('return',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
							</a>
						</li>
						<% } %>
					<% } else if(categoryType.equals("CN")) { %>
						<li class="view">
							<img src="<%=request.getContextPath()%>/images/detail.png" alt="Details" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('view',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.view.details")%>
							</a>
						</li>
						<li class="pdf">
							<img src="<%=request.getContextPath()%>/images/export.png" alt="Export" />
							<a href="javascript:void(0);" onclick="doInvoiceAction('pdf',this);">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.creditnote.view")%>
							</a>
						</li>
					<% } else if(categoryType.equals("PA")) { %>
						<style>
							.listingPopover {
								width : 236px !important;
								box-shadow: 0 0 15px 0 #e1e6eb;
							}
							.popover {
								box-shadow: 0 0 15px 0 #e1e6eb;
								width : 236px !important
							}
						</style>
						<li class="details"><img src="/html/images/details.png"
							alt="Details" /> <a href="javascript:void(0);"
							onclick="doInvoiceAction('view',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.details")%>
						</a></li>
						<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) { %>
						<li class="processPayment"><img
							src="<%=request.getContextPath()%>/images/payment.png"
							srcset="<%=request.getContextPath()%>/images/payment@2x.png 2x, <%=request.getContextPath()%>/images/payment@3x.png 3x"
							class="payment-icon"> <a href="javascript:void(0);"
							class="processPaymentLabel"
							onclick="doPaymentProcessAction(this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.global.contextmenu.processpayment")%>
						</a></li>
						<% } %>
						<% if(SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) { %>
						<li class="approve"><img
							src="<%=request.getContextPath()%>/images/submit.png"
							alt="Approve"> <a href="javascript:void(0);"
							onclick="doProcessPaymentAction('approve',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%></a></li>
						<li class="reject">
							<img src="<%=request.getContextPath()%>/images/invalid-records.png" alt="Reject">
							<a href="javascript:void(0);" onclick="doProcessPaymentAction('reject',this);">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.reject")%></a></li>
						<li class="samendments"><img
							src="<%=request.getContextPath()%>/images/return.png"
							alt="Return to submitter for Amendments"> <a
							href="javascript:void(0);"
							onclick="doProcessPaymentAction('samendments',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay,
								"workflow.return.submitter")%></a></li>
						<!-- <li class="vamendments"><img
							src="<%=request.getContextPath()%>/images/return.png"
							alt="Return to verifier for Amendments"> <a
							href="javascript:void(0);"
							onclick="doPaymentProcessAction('vamendments',this);"> <%=LabelUtil.getLabel(pageContext, themeDisplay,
								"workflow.return.verifier")%></a></li>  -->
						<% } %>
					<% } %>
				</ul>
			</div>
		</div>
	</div>
	
	</div>
	<!-- Dialogs -->
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
						<button class="btn btn-primary popup-reactivate">Re-active</button>
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
	
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="action-dialog" hidden="true" class="modalpopupBox">
			<div id="action-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Submit for Approval ?</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<div id="selectReasonDiv" style="display: none">
								<aui:row>
									<aui:col span="12">
									Choose a reason
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12">
										<input type="radio" name="reasonsCb" value="Cheque Dishonoured" checked="checked">
										Cheque Dishonoured<br />
										<input type="radio" name="reasonsCb" value="Cheque Rejected">
										Cheque Rejected<br />
										<input type="radio" name="reasonsCb" value="Others (Refund to Credit Balance)">
										Others (Refund to Credit Balance)
									</aui:col>
								</aui:row>
							</div>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary popup-submit-action pull-left" style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>

	<!-- Start Process Payment for Mass Process -->

	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="mass-process-action-dialog" hidden="true" class="modalpopupBox" style="min-width: 100%; left: 0px; top: 250px !important;">
			<div id="mass-process-action-dialog-box" class="modalpopupContent" style="min-width: 100%; padding: 0px;">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="2">
						</aui:col>
						<aui:col span="8">
							<aui:row>
								<aui:col span="6" cssClass="formio-component-textfield">
									<div class="form-group">
										<label class="control-label"><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.valuedate")%> <span class="red-star">*</span></label>
										<aui:input type="text" name=""
											cssClass="form-control mass-process-valueDate dtPicker" id="valueDate"
											placeholder=" dd/mm/yyyy"/>
										<span class="input-group-addon" style="cursor: pointer">
											<i class="glyphicon glyphicon-calendar dtPickerIcon"></i>
										</span>
										<div class="mass-process-valueDate-error error"></div>
									</div>
								</aui:col>
								<aui:col span="6" cssClass="formio-component-textfield">
									<div class="form-group">
									<label class="control-label"><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.creditdate")%> <span class="red-star">*</span></label>
										<aui:input type="text" name=""
											cssClass="form-control mass-process-creditDate dtPicker" id="creditDate"
											placeholder=" dd/mm/yyyy" />
										<span class="input-group-addon" style="cursor: pointer">
											<i class="glyphicon glyphicon-calendar dtPickerIcon"></i>
										</span>
										<div class="mass-process-creditDate-error error"></div>
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12" cssClass="formio-component-textfield">
									<div class="form-group">
										<label class="control-label"><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.paymentsetcode")%> <span class="red-star">*</span></label>
										<aui:input type="text" name=""
											cssClass="form-control mass-process-paymentSetCode" id="paymentSetCode"
											placeholder=" Add Payment Set Code" />
										<div class="mass-process-paymentSetCode-error error"></div>
									</div>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12" cssClass="formio-component-textfield">
									<div class="form-group">
										<label class="control-label"><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.notes")%> </label>
										<aui:input type="textarea" name="" rows="5" cssClass="form-control mass-process-notes" id="notes" style="height:100px" placeholder=" Enter important notes" />
									</div>
								</aui:col>
							</aui:row>
						</aui:col>
						<aui:col span="2">
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="3" >
						</aui:col>
						<aui:col span="3" >
							<button type="button" id="mass-process-popup-submit-action"
								class="btn-primary mass-process-popup-submit-action pull-left" style="float:right;width:220px;margin-left: 50px !important; padding: 8px 12px !important"><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.confirmpayment")%></button>
						</aui:col>
						<aui:col span="3" >
							<button type="button" id="mass-process-popup-cancel-action"
								class="btn-default mass-process-popup-cancel-action pull-right" style="float:left;margin-right: 50px !important; "><%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.cancel")%></button>
						</aui:col>
						
						<aui:col span="3" >
						</aui:col>
					</aui:row>
					<br />
				</form>
			</div>
		</div>
	</div>

	<!-- End Process Payment for Mass Process -->

	<div class="yui3-skin-sam invoice-action-feedback-dialog">
		<div id="action-feedback-dialog" hidden="true" class="modalpopupBox">
			<div id="action-feedback-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Action performed successfully.</h3>
						</aui:col>
					</aui:row>
					<br />
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-ok-action" style="margin: 0 auto; display:block">Back To List</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam lor-dialog">
		<div id="lor-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="lor-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<div class="action_title_container">
								<h3 id="action_title"><%=LabelUtil.getLabel(pageContext, themeDisplay, "receipthistory.lordialog.title")%></h3>
							</div>
							<p id="action_msg"><%=LabelUtil.getLabel(pageContext, themeDisplay, "receipthistory.lordialog.subtitle")%></p>
						</aui:col>
					</aui:row>
					<aui:row>
						<div
							style="text-align: center; margin-top: 10px; font-weight: 500;">
							<a href="javascript:void(0);" id="lor-pdf-link">VIEW LOR
								REPORT (.PDF)</a>
						</div>
					</aui:row>
					<br />
					<aui:row>
						<textarea
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay, "receipthistory.lordialog.inputplaceholder")%>"
								cols="" rows="" id="lor_action_reason"></textarea>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" style="width: 211px; margin-left: 0px" class="btn-primary lor-dialog-submit pull-left" id="submit">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.verification")%>
							</button>
							<button type="button" style="width: 114px; margin-right: 0px"
								class="btn cancel lightbluebtn lor-dialog-cancel pull-right">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.cancel")%>
							</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam message-failed-dialog">
		<div id="message-failed-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="message-failed-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12" style="text-align:center;">
							<h3>
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "receipthistory.lorvalidation.title")%>
							</h4>
						</aui:col>
					</aui:row>
					<aui:row>
						<p class="no-data-listing-message">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "receipthistory.lorvalidation.message")%>
						</p>
					</aui:row>
					<aui:row>
						<aui:col span="3">
						</aui:col>
						<aui:col span="6">
							<button type="button" style="width:100%;margin: 0 auto; display:block" class="btn-primary message-failed-dialog-submit">
								<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.ok")%>
							</button>
						</aui:col>
						<aui:col span="3">
						</aui:col>
					</aui:row>
				</form>
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
<script type="text/javascript">
var ajaxUrl = "${resourceURL}";
var availableColumns,masterColumns,exForm = [],columnsToShow =[],tableData,pageRequested = 1,itemsPerPage = 2,
namespace = "<portlet:namespace />",columnlist,totalRecords = 0,totalPages = 0,modelName = "<%= modelName %>";
console.log("modelname ::: " + modelName);
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
var exportPaymentAdviceExcel="<%=exportPaymentAdviceExcel%>";
var exportstorageurl="<%=exportstorageurl%>";
var downloadPdfUrl="<%=downloadPdfUrl%>";
var exportPdfUrl="<%=exportPdfUrl%>";
var UserId ="<%=userId%>";
var categoryType="<%=categoryType%>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var claimMap = <%=objectMapper.writeValueAsString(claimMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var functionalDispMap = <%=objectMapper.writeValueAsString(functionalComponentDisplayMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var serverCurrDate ="<%=serverCurrDate%>";
var disableLOR = false;
var baseCurrency = "<%=baseCurrencyParameter.getValue()%>";
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var palabelprocesspayment="<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.global.contextmenu.processpayment")%>";
var palabelreprocesspayment="<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.reprocesspayment")%>";
var palabelapprove="<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.row.contextmenu.approve")%>";
var palabelerrormsgrquired="<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.errormsg.rquired")%>";
var palabelerrormsgvaluedate="<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.errormsg.valuedate")%>";
var palabelexport="<%=LabelUtil.getLabel(pageContext, themeDisplay, "pa.mass.process.payment.valuedate")%>";

var miscFeeList = <%=objectMapper.writeValueAsString(miscFeeList)%>;
var miscFeeAllMap = {};

var candidateMap={};
var candidateDetailMap={};
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="/html/js/sp/listing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/invoice-listing.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-actions.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/lorreport.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
	<script>
	for(var i=0;i<miscFeeList.length;i++){
		var value = miscFeeList[i];
		miscFeeAllMap[value.itemValue] = value.displayName;
	}

	function getCandidateList(status){
		var datas = {};
		datas.formType = "candidate";
		//datas.conditions = ["contentJson.Status="+status,"contentJson.SponsorshipType="+sponsorshipType,"size="+2147483647];
		datas.conditions = ["contentJson.Status="+status,"size="+2147483647];
		ajaxCallAPI(
				'GET',
				"searchList",
				datas,
				function(response) {
					if(this.get("responseData") && this.get("responseData").content){
						valueList = this.get("responseData").content;
						var opt = "<option value='' hidden='true'> Choose a Candidate... </option>";
						for(var i=0; i<valueList.length; i++) {
							var val = valueList[i];
							if(val.hasOwnProperty("contentJson") && val.contentJson.hasOwnProperty("SponsorshipType") && (val.contentJson.SponsorshipType == "Self Sponsored" || val.contentJson.SponsorshipType == "Individual")){
								candidateMap[val.storageId] = val.firstName +' '+ (val.hasOwnProperty("lastName") && val.lastName!=null?val.lastName:"");
								candidateDetailMap[val.storageId] = val;
							}
						}
						for(var k in candidateMap){
							if(k != undefined){
								opt = opt + "<option value='"+k+"'>"+candidateMap[k]+"</option>";
							}
						}
						//getEID(namespace + "candidateids").innerHTML = opt;
					}
				}, function() {
					
				});
	}
	getCandidateList("active");
	getCandidateList("Active");
	</script>
<%}%>