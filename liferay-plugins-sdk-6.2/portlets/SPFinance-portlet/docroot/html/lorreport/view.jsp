<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
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
	String formStorageId = request.getParameter("storageId");
	String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = themeDisplay.getLayout().getGroupId();
	String dashBoardLink = SambaashUtil.getDashBoard();
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span><%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.form.headertitle")%></span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="invoiceDetailsFormDiv">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div class="formContainer container formio-form">
			<form class="aui" id="invoiceDetailsForm" name="invoiceDetailsForm" action="">
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg"></div>
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.form.division")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="division" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.form.date")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly" id="date"
										cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.form.modeofpayment")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="modeofpayment" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.form.currency")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<aui:input type="text" name="" readonly="readonly"
										id="currency" cssClass="form-control" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="3">
								<div class="form-group">
									<label class="control-label"> <%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.form.processedby")%>
									</label>
								</div>
							</aui:col>
							<aui:col span="8" cssClass="formio-component-textfield">
								<div class="form-group">
									<textarea name="" readonly="readonly" style="overflow: hidden;resize:none"
										id="processedby" class="form-control"></textarea>
								</div>
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
			</form>
			<aui:row cssClass="userAction">
				<aui:col span="2"></aui:col>
				<aui:col span="8">
					<button type="button" style="width: 174px;"
						onclick="doLorAction('pdf')" class="btn btn-primary">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.lorreport.view")%>
					</button>
					<button type="button" style="width: 174px;"
						onclick="doLorAction('ppdf')" class="btn btn-primary">
						<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.lorreport.pview")%>
					</button>
				</aui:col>
				<aui:col span="2"></aui:col>
			</aui:row>
		</div>
		</div>
		</div>
	</div>
	<div class="remarksHeader">
		<div class="container">
			<aui:row>
				<aui:col span="12" cssClass="text-center">
					<h4 style="float: left"><%=LabelUtil.getLabel(pageContext, themeDisplay, "lordetail.remarks.title")%></h4>
					<h4 id="totalRemarks" style="float: right">(Total: 0 Remarks)</h4>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="invoiceRemarksDiv">
		<div class="formContainer container formio-form"
			id="invoiceRemarksContainer">
			<aui:row style="display:none" id="remarkTemplate">
				<aui:col span="12">
					<aui:row cssClass="dayRow">
						<aui:col span="12">
							<p class="dayText">Today</p>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="1" cssClass="bulletDiv">
							<p class="bullet"></p>
						</aui:col>
						<aui:col span="11">
							<aui:row>
								<p class="remarksAction">
									<b>Amy Marshall returned</b> for amendments
								</p>
								<p class="remarksTime">11:15</p>
							</aui:row>
							<aui:row>
								<p class="remarksText">This is sample remarks for
									testing.This is sample remarks for testing.This is sample
									remarks for testing.This is sample remarks for testing.123</p>
							</aui:row>
						</aui:col>
					</aui:row>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="invoiceDetailsButtonDiv" id="submitterButtons">
		<div class="formContainer container formio-form">
			<aui:row cssClass="userAction">
				<aui:col span="12" cssClass="buttonContainer">
					<div>
						<%
							if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_SUBMITTER_ROLE)) {
						%>
						<button type="button" class="btn btn-primary workflow-submit-for-approval" id="submita"
							onClick="doLorAction('submita')" style="display: none;width: 258px !important">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.approval")%>
						</button>
						<%
							}
						%>
						<%
							if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_VERIFIER_ROLE)) {
						%>
						<button type="button" class="btn btn-primary workflow-submit-for-approval" id="submitv"
							onClick="doLorAction('submitv')" style="display: none;width: 258px !important">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.submit.verification")%>
						</button>
						<%
							}
						%>
						<%
							if (SPFinanceLocalServiceUtil.checkRole(request, FinanceConstants.FINANCE_APPROVER_ROLE)) {
						%>
						<button type="button" class="btn btn-primary" id="approve"
							onClick="doLorAction('approve')" style="display: none">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.approve")%>
						</button>
						<%
							}
						%>
						<button type="button" class="btn btn-default workflow-return-for-amendments" id="return"
							onClick="doLorAction('return')" style="display: none">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.return.amendments")%>
						</button>
						<button type="button" class="btn btn-default" id="back"
							onclick="goBack();" style="width: 100px">
							<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.cancel")%>
						</button>
					</div>
				</aui:col>
			</aui:row>
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
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="lor-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="lor-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Submit for Approval ?</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="lor_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary lor-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default lor-action-dialog-cancel popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-feedback-dialog">
		<div id="action-feedback-dialog" hidden="true" class="modalpopupBox">
			<div id="action-feedback-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3><%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.feedback.title")%></h3>
						</aui:col>
					</aui:row>
					<br />
					<aui:row>
						<aui:col span="12">
							<button type="button" class="btn btn-default" onclick="goBack();"
								style="margin: 0 auto; display: block"><%=LabelUtil.getLabel(pageContext, themeDisplay, "workflow.feedback.backbtn")%></button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var modelName = "<%=modelName%>";
var baseUrl = "<%=baseUrl%>";
var mode = "view";
var downloadPdfUrl="<%=downloadPdfUrl%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/lorreport.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script> 