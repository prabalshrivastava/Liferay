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
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>SEATING LAYOUT SETUP</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="seatingLayoutSetup">
		<div class="formContainer container formio-form">
			<form class="aui" id="seatingLayout_form"
				name="financeParameter_form" action="">
				<aui:input name="" type="hidden" id="seatingPlanLayoutCode" />
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
							role="showAlert" id="alert_msg">Select Facility Type</div>
						<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Facility Type <span
										class="red-star">*</span></label>
									<aui:select name="" id="facilityType"
										cssClass="form-control" onChange="downloadDropdownData(this.value);">
										<%
											List<SPListType> catList = 
												SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype", groupId);
											for(SPListType type : catList) {
												%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option><%
											}
										%>
									</aui:select>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Facility Name<span
										class="red-star">*</span>
									</label>
									<aui:select name="" id="facilityName"
										cssClass="form-control" onChange="loadSubFacilityDropdowns('subfacility',this.value)">
										<%-- <%
											List<SPListType> catList = 
												SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype", groupId);
											for(SPListType type : catList) {
												%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option><%
											}
										%> --%>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Sub-Facility Name<span
										class="red-star">*</span>
									</label>
									<aui:select name="" id="subFacilityName"
										cssClass="form-control" onChange="loadSeatCapacity(this.value)">
										<%-- <%
											List<SPListType> catList = 
												SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype", groupId);
											for(SPListType type : catList) {
												%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option><%
											}
										%> --%>
									</aui:select>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Seating Capacity
									</label>
									<aui:input type="text" name="" id="seatingCapacity"
										cssClass="form-control">
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Seating Layout Description
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="seatingLayoutDescription"
										cssClass="form-control" placeholder="Enter a description" >
										<aui:validator name="max">100</aui:validator>
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">No. of Rows<span
										class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="noOfRows"
										cssClass="form-control">
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">No. of Columns
									</label>
									<aui:input type="text" name="" id="noOfColumns"
										cssClass="form-control">
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-radio">
								<%-- <div id="invigilatorAutoAssignment"   class="form-group">
									<label class="control-label" style="">Invigilator Auto-Assignment</label>
									<aui:input name="invigilatorAutoAssignment" type="radio" class="form-check-input" id="invigilatorAutoAssignment-Yes" value="Yes">
									</aui:input>
									<span>Yes</span>
									<aui:input name="invigilatorAutoAssignment" type="radio" class="form-check-input" id="invigilatorAutoAssignment-No" value="No">
									</aui:input>
									<span>No</span>
								</div> --%>
								
								<div id="ej019hl" class="form-group has-feedback formio-component formio-component-radio formio-component-InvigilatorAutoAssignment invigilatorAutoAssignment" style="">
									<label class="control-label" style="">Invigilator Auto-Assignment</label>
									<div class="form-group" id="yui_patched_v3_11_0_1_1547210518655_1794">
									<div class="form-check form-check-inline radio-inline" id="yui_patched_v3_11_0_1_1547210518655_1793">
									<label class="control-label form-check-label" for="ej019hl-Yes" id="yui_patched_v3_11_0_1_1547210518655_1792">
									<input name="data[InvigilatorAutoAssignment][ej019hl]" type="radio" class="form-check-input" lang="en" id="ej019hl-Yes" value="Yes">
									<span id="yui_patched_v3_11_0_1_1547210518655_1791">Yes</span>
									</label>
									</div>
									<div class="form-check form-check-inline radio-inline radio-selected">
									<label class="control-label form-check-label" for="ej019hl-No">
									<input name="data[InvigilatorAutoAssignment][ej019hl]" type="radio" class="form-check-input" lang="en" id="ej019hl-No" value="No" checked="checked">
									<span>No</span>
									</label>
									</div>
									</div>
									</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-radio">
								<div id="ecmhdei" class="form-group has-feedback formio-component formio-component-radio formio-component-InvigilatorAutoAssignment invigilatorAutoAssignment" style="">
									<label class="control-label" style="">Candidate Seat Auto-Assignment</label>
									<div class="form-group" id="yui_patched_v3_11_0_1_1547210518655_17941">
									<div class="form-check form-check-inline radio-inline" id="yui_patched_v3_11_0_1_1547210518655_17931">
									<label class="control-label form-check-label" for="ecmhdei-Yes" id="yui_patched_v3_11_0_1_1547210518655_17921">
									<input name="data[CandidateAutoAssignment][ecmhdei]" type="radio" class="form-check-input" lang="en" id="ecmhdei-Yes" value="Yes" checked="checked">
									<span id="yui_patched_v3_11_0_1_1547210518655_17911">Yes</span>
									</label>
									</div>
									<div class="form-check form-check-inline radio-inline radio-selected">
									<label class="control-label form-check-label" for="ecmhdei-No">
									<input name="data[CandidateAutoAssignment][ecmhdei]" type="radio" class="form-check-input" lang="en" id="ecmhdei-No" value="No" >
									<span>No</span>
									</label>
									</div>
									</div>
									</div>
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col span="6" cssClass="formio-component-checkbox">
								<div id="evo2bkp" class="form-check form-group has-feedback formio-component formio-component-checkbox formio-component-AllowToOverrideSeatAutoAssignment seatautoAssign checkbox">
									<label class="control-label form-check-label" id="yui_patched_v3_11_0_1_1547210518655_1836">
										<span id="yui_patched_v3_11_0_1_1547210518655_1835">Allow to override Seat Auto-Assignment</span>
										<input id="allowToOverrideSeatAutoAssignment" name="data[AllowToOverrideSeatAutoAssignment]" type="checkbox" class="form-check-input" lang="en" value="1" checked="true" >
									</label>
								</div>
							</aui:col>
							
							<aui:col span="6" cssClass="formio-component-checkbox">
							
								<div id="exyep9k" class="form-check form-group has-feedback formio-component formio-component-checkbox formio-component-Validation validation checkbox">
								<label class="control-label form-check-label">
									<span>Validation</span>
									<input id="validation"  name="data[Validation]" type="checkbox" class="form-check-input" lang="en" value="1" checked="true">
								</label>
								</div>
							</aui:col>
							
						</aui:row>
						
						<aui:row cssClass="userAction">
							<aui:col span="1"></aui:col>
							<aui:col span="12">
								<aui:col span="4">
									<button type="button" class="btn btn-default" id="draft"
										onClick="validateFields('draft')">Save Draft</button>
								</aui:col>
								<aui:col span="4">
									<button type="button" class="btn btn-primary" id="publish"
										onClick="validateFields('publish')">Generate Layout</button>
								</aui:col>
								<aui:col span="4">
									<button type="button" onclick="reset();"
										class="btn btn-default">Clear</button>
								</aui:col>
							</aui:col>
							<aui:col span="1"></aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>
	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Seating Layout Created</h3>
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
	src="<%=request.getContextPath()%>/js/seatingplan-layout.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>