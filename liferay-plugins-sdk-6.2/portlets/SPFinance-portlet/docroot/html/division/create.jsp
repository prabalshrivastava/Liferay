<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
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
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/division.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span>DIVISION DEPARTMENT PROFIT CENTRE SETUP</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="divisionDepartmentSetup">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div class="formContainer container formio-form">
			<form class="aui" id="divisionForm"
				name="divisionForm" action="">
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<p id="formStatus" class="formStatus form_draft" style="padding: 2px 0px">
							Draft
						</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Division Code <span
										class="red-star">*</span></label>
									<aui:input type="text" name="" id="divisionCode"
										cssClass="form-control"
										placeholder="Enter a Code...">
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Division Description
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="divisionDescription"
										cssClass="form-control" placeholder="Enter a Description..." />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="department dashed-box">
									<div class="departmentHolder" id="departmentHolder">
										<div class="departmentContainer" id="departmentContainer" style="display:none">
											<h3 class="header toggler-header-collapsed" style="position: relative;top: 0;">
												<div class="headerText">Department</div>
												<ul class="nav">
													<li style="float:left"><a href="javascript:void(0);"
														class="btn removeBtn" onclick="removeDepartment(this)"
														style="top: 0px;padding-left: 16px !important;">Remove</a></li>
													<li><a href="javascript:void(0);"
														class="minusIcon" style="top: -2px;" onclick="closeDepartment(this)">Close</a></li>
													
												</ul>
											</h3>
											<div class="departmentContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:row>
														<aui:col span="6" cssClass="formio-component-textfield">
															<label cssClass="control-label">Department <span class="red-star">*</span></label>
															<aui:input type="text"  name=""
																cssClass="form-control department" id="department"
																placeholder="Enter Department" />
														</aui:col>
														<aui:col span="6" cssClass="formio-component-textfield">
															<label cssClass="control-label">Profit Centre 
																<span class="red-star">*</span></label>
															<aui:select name="" id="profitCentreCode"
																type="text" cssClass="profitCentreCode form-control"
																placeholder="Choose a Profit Centre Code">
																<aui:option value="" hidden="true">
															    	Choose a Profit Centre Code
															    </aui:option>
															</aui:select>
														</aui:col>
													</aui:row>
												</aui:row>
												<label style="display: none;" id="deleteStatus"
													class="deleteStatus"></label>
											</div>
											<br />
										</div>
									</div>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<aui:button cssClass="btn greenbtn" id="addDepartmentButton"
									value="ADD DEPARTMENT" onClick="addAnotherDepartment()"></aui:button>
							</aui:col>
						</aui:row>
						<aui:row cssClass="userAction">
							<aui:col span="1"></aui:col>
							<aui:col span="10">
								<aui:col span="3">
									<button type="button" class="btn btn-default" id="draft"
										onClick="validateFields('draft')">Save Draft</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" class="btn btn-primary" id="publish"
										onClick="validateFields('publish')">Publish</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" onclick="reset();"
										class="btn btn-default">Clear</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" onclick="goBack();"
										class="btn btn-default">Cancel</button>
								</aui:col>
							</aui:col>
							<aui:col span="1"></aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
			</form>
		</div>
		</div>
		</div>
	</div>


	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Division Created</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn cancel btn-primary popup-cancel pull-right"
							onClick="moveToList()">Go Back</button>
					</aui:col>
				</aui:row>

			</form>
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
var formStorageId = "<%=formStorageId%>";
var vocabularyURL = "<%=vocabularyURL%>";
var mode = "create";
var baseUrl = "<%=baseUrl%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/division.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>