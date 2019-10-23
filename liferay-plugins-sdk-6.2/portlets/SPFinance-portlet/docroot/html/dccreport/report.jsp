<%@page import="com.sambaash.platform.srv.startupprofile.model.Organization"%>
<%@page import="com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<portlet:defineObjects />
<%
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	User user = themeDisplay.getUser();
	String userName = user.getFullName();
	String designation = user.getJobTitle();
	Long groupId = themeDisplay.getLayout().getGroupId();
	String dashBoardLink = SambaashUtil.getDashBoard();

	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	List<Organization> organizationList = OrganizationLocalServiceUtil.getService().getAllActiveOrganizations();
	Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.transaction.sourcetype", request);
	List<SPListType> regulationTypeMap = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.subject.pricetype", groupId);
	List<SPListType> productSubTypeMap = SPListTypeLocalServiceUtil
			.getByKey("finance.accountingtable.exam.producsubtype", groupId);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<portlet:resourceURL var="exportPdfUrl">
	<portlet:param name="action" value="exportPdf" />
</portlet:resourceURL>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2>
							<span><%=LabelUtil.getLabel(pageContext, themeDisplay, "dcc.detail.title")%></span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="formRoot">
		<div class="invoiceDetailsFormDiv">
			<div class="">
				<div class="formContainer container formio-form">
					<form class="aui" id="invoiceDetailsForm" name="invoiceDetailsForm"
						action="">
						<aui:col span="10" cssClass="offset1">
							<div style="display: none;" class="alert alert-danger"
								role="showAlert" id="alert_msg_id"></div>
							<aui:row cssClass="formio-component-datetime">
								<aui:col span="4">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "report.type.name")%>
										</label>
										<aui:select name="" id="reportType"
											onChange="reportChange(this)" type="text"
											cssClass="report form-control" placeholder="Choose a Report">
										</aui:select>
									</div>
								</aui:col>
								<aui:col span="4" id="due-date-colId">
									<div class="form-group">
										<aui:input type="text" name="" label="Date"
											cssClass="form-control dueDate" id="dueDate"
											placeholder="dd/mm/yyyy" />
										<span class="input-group-addon" style="cursor: pointer">
											<i class="glyphicon glyphicon-calendar"
											style="top: 60px !important;"></i>
										</span>
									</div>
								</aui:col>
								<aui:col span="4" id="organisation-colId">
									<div class="form-group">
										<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, 
												
												"report.type.coporate")%>
										</label>
										<aui:select name="" id="organisationId" onChange=""
											type="text" cssClass="report form-control"
											placeholder="Choose a Corporate">
											<aui:option value="">
											  	Select Corporate...
											</aui:option>
										</aui:select>
									</div>
								</aui:col>
								<aui:col span="4" id="start-date-colId">
									<div class="form-group">
										<%-- <label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "report.type.sd")%>
										</label> --%>
										<aui:input type="text" name="" label="Start Date"
											cssClass="form-control startDate" id="startDate"
											placeholder="dd/mm/yyyy" />
										<span class="input-group-addon" style="cursor: pointer">
											<i class="glyphicon glyphicon-calendar"
											style="top: 60px !important;"></i>
										</span>
									</div>
								</aui:col>
								<aui:col span="4" id="end-date-colId">
									<div class="form-group">
										<aui:input type="text" cssClass="form-control endDate"
											label="End Date" id="endDate" name=""
											placeholder="dd/mm/yyyy" />
										<span class="input-group-addon" style="cursor: pointer">
											<i class="glyphicon glyphicon-calendar"
											style="top: 60px !important;"></i>
										</span>
									</div>
								</aui:col>
						</aui:row>
						<aui:row cssClass="formio-component">
							<aui:col span="4" id="exam-body-colId">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "report.type.body")%>
									</label>
									<aui:select name="" id="examBody" onChange=""
										type="text" cssClass="report form-control">
										<aui:option value="">
										  	Select Exam Body...
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col span="4" id="regulation-type-colId">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "report.type.regulation")%>
									</label>
									<aui:select name="" id="regulationType" onChange=""
										type="text" cssClass="report form-control"
										placeholder="Choose a regulation type">
										<aui:option value="">
										  	Select Regulation Type...
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
					</aui:col>
				</form>
				<aui:row cssClass="userAction">
					<aui:col span="2"></aui:col>
					<aui:col span="8">
						<button type="button" style="width: 200px;"
							onclick="generateReport()" class="btn btn-primary">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "report.btn.name")%>
						</button>
					</aui:col>
					<aui:col span="2"></aui:col>
				</aui:row>
				</div>
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
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "report";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var downloadPdfUrl="<%=downloadPdfUrl%>";
var userName = "<%=userName%>";
var designation = "<%=designation%>";
var regulationTypeMap =<%=objectMapper.writeValueAsString(regulationTypeMap)%>;
var productSubTypeMap =<%=objectMapper.writeValueAsString(productSubTypeMap)%>; 
var organizationList =<%=objectMapper.writeValueAsString(organizationList)%>;
var sourceType =<%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var exportPdfUrl ="<%=exportPdfUrl%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/report.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
