<%@page import="java.text.*"%>
<%@page import="org.json.JSONException"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.lang.ClassCastException"%>

<%@page
	import="com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil"%>
<%@page
	import="com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.model.SPATOContacts"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.model.ApprovedMentors"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalService"%>
<%@page import="org.json.JSONObject"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.model.Organization"%>
<%@page
	import="com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<script async defer type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript"></script>
<link rel='stylesheet' type="text/css"
	href='/html/css/hook.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/add-erpec.css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'></link>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
    String mode = request.getParameter("mode");
    String rpecStatus = request.getParameter("rpecStatus");

    String loggedInUser = request.getParameter("loggedInUser");
    String candidateId = request.getParameter("candidateId");
    String userType = request.getParameter("userType");
    String isStandardReview = request.getParameter("isStandardReview");
    String isFinalReview = request.getParameter("isFinalReview");
    String isSignOff = request.getParameter("isSignOff");
    String reviewPeriodNumber = request.getParameter("reviewPeriod");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	String maximumCalendarDays = portletPreferences.getValue("maximumCalendarDays", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	String candidateRoleName = portletPreferences.getValue("candidateRole", "");
	String RELCUserRoleName = portletPreferences.getValue("relcUserRole", "");
	Long groupId = td.getLayout().getGroupId();
    String userName = td.getRealUser().getFullName();
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	String modelName = renderRequest.getPreferences().getValue("modelNamePref", "");
	String legendsLink = renderRequest.getPreferences().getValue("legendsLink","");
	String userDetails = SystemServiceUtil.getRecord(candidateId, "Candidate", Long.parseLong(candidateId), groupId);
	JSONObject candidateDetails = new JSONObject();
	JSONObject candidatesData = new JSONObject();
	if(userDetails != null && userDetails != "") {
		candidatesData = (JSONObject)new JSONObject(userDetails).get("contentJson");
	}
%>
<portlet:resourceURL var="resourceURL">

</portlet:resourceURL>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <sp-formio:MakeCopyTag cssClass="formContainer" formId="2074" --%>
<%-- 	readOnly="false" formStorageId="2074" /> --%>
<div style="display: none; margin-top: 45px;" class="alert"
	role="showAlert" id="alert_msg"></div>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<div class="row-fluid " id="">
					<div class="span10 text-center" id="">
						<h2>
							<span>SUBMIT RPEC RECORD</span>
						</h2>
					</div>
					<div class="span2 text-right" id="">
						<a href="/workspace" title="Back to Workspace">Back to Workspace</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="formContainer">
		<%
			if(PermissionUtil.canApprovedRPEC((PortletRequest) request.getAttribute("javax.portlet.request")) && rpecStatus != null && rpecStatus.equals("Pending Final Approval")){
		%>
		<div class="top-info">
			<img src="/html/images/blue-info.svg"
				style="float: left; margin-left: inherit; padding-left: 10px;" />
			<p style="color: #0a517b; size: 12px; display: inline;">Please
				take note that this candidate has referred this record for final
				review.</p>
			<img src="/html/images/close-minus.png"
				style="float: right; margin-right: inherit; padding-right: 10px;" />
		</div>
		<%
			}
		%>
		<div style="margin: 30px 0px;">
			<h4 class="rpec-record">
				RPEC Record - <span id="reviewPeriod"></span>
			</h4>
		</div>

		<div class="mb-2 card border panel panel-default ">
			<div class="card-header bg-default panel-heading formio-clickable"
				onclick="togglePanels('ATO' , null)">
				<h4 class="mb-0 card-title panel-title">
					<i class="glyphicon formio-collapse-icon expand" id="panelATOplus"></i>
					<i class="more pop collapse" style="display: none;"
						id="panelATOminus"></i> 01. ACCREDITED TRAINING ORGANISATION (ATO)
					DETAILS
				</h4>
			</div>

			<div class="card-body panel-body" style="display: hidden;"
				hidden="true" id="panelATODiv">
				<div
					class="row formio-component formio-component-columns formio-component-panelColumns "
					style="">
					<div
						class="col col-sm-6 col-sm-offset-0 col-sm-push-0 col-sm-pull-0"
						style="">
						<%
						try{
							if(userType != null && userType.toLowerCase().equals("relcuser") && userDetails!= null && !userDetails.equals("") &&
							((JSONObject)new JSONObject(userDetails).get("contentJson")).has("AtoDetails") &&
							((JSONArray)((JSONObject)new JSONObject(userDetails).get("contentJson")).get("AtoDetails")).length() > 1 &&
							formStorageId.equals("0")) {
						%>


						<div
							class="form-group has-feedback formio-component formio-component-textfield formio-component-panelAtoName "
							style="">
							<label cssClass="control-label">ATO Name</label>
							<aui:select name="" id="atoNames" cssClass="form-control"
								placeholder="Choose an ATO"
								onChange="propogateATODetails(this.value);">
								<aui:option value="" hidden="true">
								</aui:option>
							</aui:select>
						</div>


						<%
							} else {
						%>
						<div id="ekodyf"
							class="form-group has-feedback formio-component formio-component-textfield formio-component-panelAtoName "
							style="">
							<label class="control-label" style="">ATO Name</label> <input
								name="atoName" type="text" class="form-control" lang="en"
								spellcheck="true" id="atoName" readonly>
						</div>
						<%
							}
						}catch(ClassCastException ce)
						{
							%>
							<div id="ekodyf"
								class="form-group has-feedback formio-component formio-component-textfield formio-component-panelAtoName "
								style="">
								<label class="control-label" style="">ATO Name</label> <input
									name="atoName" type="text" class="form-control" lang="en"
									spellcheck="true" id="atoName" readonly>
							</div>
							<%
						}
						%>
					</div>
					<div
						class="col col-sm-6 col-sm-offset-0 col-sm-push-0 col-sm-pull-0"
						style="">
						<div id="eztu0i"
							class="form-group has-feedback formio-component formio-component-textfield formio-component-panelMentorName "
							style="">
							<label class="control-label" style="">Mentor Name</label><input
								name="mentorName" type="text" class="form-control" lang="en"
								spellcheck="true" id="mentorName" readonly>
						</div>
					</div>
				</div>
				<div id="eifdo6s"
					class="row formio-component formio-component-columns formio-component-panelColumns "
					style="">
					<div id="eo81xhi"
						class="col col-sm-6 col-sm-offset-0 col-sm-push-0 col-sm-pull-0"
						style="">
						<div id="enyet12"
							class="form-group has-feedback formio-component formio-component-textfield formio-component-panelColumnsCandidateJobRole "
							style="">
							<label class="control-label" style="">Candidate Job Role</label>
							<input name="jobRole" type="text" class="form-control" lang="en"
								spellcheck="true" id="jobRole" readonly>
						</div>
						<div id="eyzwzws"
							class="form-group has-feedback formio-component formio-component-datetime formio-component-panelColumnsDateFromJobRole "
							style="">
							<label class="control-label" style="">Date From (Job
								Role)</label>
							<div class="input-group">
								<input name="dateFromJobRole" type="hidden"
									class="form-control flatpickr-input" lang="en" value=""
									readonly> <input
									class="form-control flatpickr-input form-control input"
									tabindex="0" id="dateFromJobRole" type="text" readonly>
							</div>
						</div>
					</div>
					<div id="ebyzti"
						class="col col-sm-6 col-sm-offset-0 col-sm-push-0 col-sm-pull-0"
						style="">
						<div id="ewmge"
							class="form-group has-feedback formio-component formio-component-textfield formio-component-panelColumnsTrainingPrincipalName "
							style="">
							<label class="control-label" style="">Training Principal
								Name</label><input name="trainingPrincipal" type="text"
								class="form-control" lang="en" spellcheck="true"
								id="trainingPrincipal" readonly>
						</div>
						<div id="ep99l4"
							class="form-group has-feedback formio-component formio-component-datetime formio-component-panelColumnsDateToJobRole "
							style="display:none;">
							<label class="control-label" style="">Date To (Job Role)</label>
							<div class="input-group">
								<input name="dateToJobRole" type="hidden"
									class="form-control flatpickr-input" lang="en"
									placeholder="dd/MM/yyyy" value="" readonly><input
									class="form-control flatpickr-input form-control input"
									id="dateToJobRole" tabindex="0" type="text" readonly>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="mb-2 card border panel panel-default ">
			<div class="card-header bg-default panel-heading formio-clickable"
				onclick="togglePanels('Review' , null)">
				<h4 class="mb-0 card-title panel-title">
					<i class="glyphicon formio-collapse-icon expand"
						id="panelReviewplus"></i> <i class="more pop collapse"
						style="display: none;" id="panelReviewminus"></i> 02.REVIEW PERIOD
				</h4>
			</div>

			<div class="card-body panel-body" style="display: hidden;"
				hidden="true" id="panelReviewDiv">
				<div id="e6rmvr9"
					class="row formio-component formio-component-columns formio-component-panel2Columns "
					style="">
					<div id="e0nihn8"
						class="col col-sm-6 col-sm-offset-0 col-sm-push-0 col-sm-pull-0"
						style="">
						<div id="ewlqngd"
							class="form-group has-feedback formio-component formio-component-datetime formio-component-panel2ColumnsDateFrom "
							style="">
							<label class="control-label field-required" style=""
								id="yui_patched_v3_11_0_1_1554117516233_629">Date From</label>
							<div class="input-group"
								id="yui_patched_v3_11_0_1_1554117516233_564">
								<input name="data[panel2ColumnsDateFrom]" type="date"
									id="dateFrom" onchange="getDateFromDate()"
									class="form-control flatpickr-input" lang="en"
									placeholder="dd/MM/yyyy" value=""> <span
									id="mandatoryDateFrom" style="display: none; color: #c03643"><img
									src="/html/images/error.png"></img></span>
							</div>
						</div>
					</div>
					<div id="e599mxi"
						class="col col-sm-6 col-sm-offset-0 col-sm-push-0 col-sm-pull-0"
						style="">
						<div id="e7uw7007"
							class="form-group has-feedback formio-component formio-component-datetime formio-component-panel2ColumnsDateTo "
							style="">
							<label class="control-label field-required" style="">Date
								To</label>
							<div class="input-group"
								id="yui_patched_v3_11_0_1_1554117516233_598">
								<input name="data[panel2ColumnsDateTo]" type="date"
									class="form-control flatpickr-input" lang="en"
									placeholder="dd/MM/yyyy" value="" id="dateTo"
									onchange="getDateToDate()">
							</div>
							<span style="display: none; color: #c03643" id="error_date"><img
								src="/html/images/error.png"></img></span>
						</div>
					</div>
				</div>
				<div id="ey6xd9i"
					class="form-group has-feedback formio-component formio-component-number formio-component-panel2DaysspentonPracticalExperienceinthisAto "
					style="">
					<label class="control-label field-required" style="">Days
						spent on Practical Experience in this ATO</label><input
						name="data[panel2DaysspentonPracticalExperienceinthisAto]"
						type="text" class="form-control" lang="en"
						placeholder="Enter the number of days" inputmode="numeric"
						pattern="\d*" onchange="validatePracticalExperience()"
						id="practicalExp"> <span id="prcExp"
						style="display: none; color: #c03643"> <img
						src="/html/images/error.png"></img>
					</span>
				</div>
			</div>

			<div class="mb-2 card border panel panel-default ">
				<div class="card-header bg-default panel-heading formio-clickable"
					onclick="togglePanels('Competence' , 'CompetenceType')">
					<h4 class="mb-0 card-title panel-title">
						<i class="glyphicon formio-collapse-icon expand"
							id="panelCompetenceplus"></i> <i class="more pop collapse"
							style="display: none;" id="panelCompetenceminus"></i> 03.
						COMPETENCE DEVELOPMENT
					</h4>
				</div>

				<div class="card-body panel-body" style="display: hidden;"
					hidden="true" id="panelCompetenceDiv"></div>
			</div>

			<div class="info-block">
				<h4 class="info-header">IMPORTANT INFO:</h4>
				<p class="info-content">
					For more info on Competence Development, please refer to <a
						href="<%=legendsLink%>" target="_blank"> Legend. </a>
				</p>
			</div>

			<div class="remarks-div d-block col-sm-12 p-0" id="remark_Nullify"
				style="border: none; margin: 30px 0px;"></div>

			<%
				if(rpecStatus != null && rpecStatus.equals("Nullified")){
			%>
			<div class="status-info-block">
				<img src="/html/images/null.svg"
					style="width: 30px; height: 30px; margin: 10px;">
				<p style="font-size: 14px; margin: auto;" id="reviewNullified">

				</p>
			</div>
			<%
				}
			%>
			<%
				if(rpecStatus != null && (rpecStatus.equals("Approved")||rpecStatus.equals("Approved By Mentor"))){
			%>
			<div class="status-info-block">
				<img src="/html/images/success.png"
					style="width: 30px; height: 30px; margin: 10px;">
				<p style="font-size: 14px; margin: auto;" id="reviewApproved"></p>
			</div>
			<%
				}
			%>
			<%
				if(rpecStatus != null && rpecStatus.equals("Rejected")){
			%>
			<div class="status-info-block">
				<img src="/html/images/close-03.svg"
					style="width: 30px; height: 30px; margin: 10px;">
				<p style="font-size: 14px; margin: auto;" id="reviewRejected"></p>
			</div>
			<%
				}
			%>
			<div id="elt8o0g" class="col col-12 col-sm-12 text-center button-holder" style="padding-top: 40px;">
				<%
				if(PermissionUtil.canNullifyRecord((PortletRequest) request.getAttribute("javax.portlet.request")) && rpecStatus != null && rpecStatus.equals("Completed") && !mode.equals("view")){
				%>
				<button name="nullifyRecord" type="button"
					class="btn button-nullify button-text btn-md" lang="en"
					value="false" onclick="showPopUpNullify()">NULLIFY RECORD</button>
				<%
					}
							if((rpecStatus != null && (rpecStatus.equals("Approved")||rpecStatus.equals("Approved By Mentor")) && isSignOff != null && isSignOff.equals("true"))|| (rpecStatus != null && rpecStatus.equals("Completed")) || mode.equals("view")){
				%>
				<button name="save" type="button"
					class="btn button-summary button-text  btn-md" lang="en"
					value="false" onclick="onBackToSummary()">BACK TO SUMMARY</button>
				<%
					}
					else  {
				%>
				<%
					if(PermissionUtil.canSubmitRPEC((PortletRequest) request.getAttribute("javax.portlet.request")) && !mode.equals("view")){
				%>
				<button name="save" type="submit"
					class="btn button-save button-text btn-md" lang="en" value="false"
					id="save" onclick="validateMandatoryFields('Draft')">SAVE</button>
				<%
					}
								if(PermissionUtil.canApprovedRPEC((PortletRequest) request.getAttribute("javax.portlet.request")) && !mode.equals("view") && rpecStatus != null && !rpecStatus.endsWith("Approved") && !rpecStatus.equals("Pending Final Approval")){
				%>
				<button name="approveRecord" type="button" id="approveRecord"
					class="btn button-approved button-text btn-md" lang="en"
					value="false" onclick="validateUpdateStatus('Approved')">MARK AS
					APPROVED</button>
				<%
					} if(PermissionUtil.canFinalSignOff((PortletRequest) request.getAttribute("javax.portlet.request")) && rpecStatus != null && rpecStatus.equals("Pending Final Approval") && !mode.equals("view")){
				%>
				<button name="finalRecord" type="button"
					class="btn button-standard button-text btn-md" lang="en"
					value="false" onclick="validateUpdateStatus('Pending Sign Off')">SUBMIT
					FOR FINAL SIGN-OFF</button>
				<%
					} if(PermissionUtil.canNullifyRecord((PortletRequest) request.getAttribute("javax.portlet.request")) && rpecStatus != null && rpecStatus.equals("Completed") && !mode.equals("view")){
				%>
				<button name="nullifyRecord" type="button"
					class="btn button-nullify button-text btn-md" lang="en"
					value="false" onclick="showPopUpNullify()">NULLIFY RECORD</button>
				<%
					} if(PermissionUtil.canRejectRPEC((PortletRequest) request.getAttribute("javax.portlet.request")) && !mode.equals("view") && rpecStatus != null && !rpecStatus.endsWith("Approved")){
				%>
				<button name="rejectRecord" type="button" id="rejectRecord"
					class="btn button-rejected button-text btn-md" lang="en"
					value="false" onclick="validateUpdateStatus('Rejected')">REJECT</button>
				<%
					} if(PermissionUtil.canStandardReviewRPEC((PortletRequest) request.getAttribute("javax.portlet.request")) && !mode.equals("view")){
				%>
				<button name="submitForStandardReview" type="button"
					id="standardReview" class="btn button-standard button-text btn-md"
					lang="en" value="false"
					onclick="validateMandatoryFields('Pending Standard Approval')">SUBMIT
					FOR STANDARD REVIEW</button>
				<%
					} if(PermissionUtil.canFinalReview((PortletRequest) request.getAttribute("javax.portlet.request")) && !mode.equals("view")){
				%>
				<div class="add-tooltip" id="finalReviewtooltip" style="display: none;bottom: 37%;">
					<span style="vertical-align: middle;">Candidate must complete all the 9 Generic Competencies and atleast 4 out of 15 Technical Competencies</span>
				</div>
				<button name="submitForFinalReview" type="button"
					id="forFinalReview"
					class="btn button-final-review button-text btn-md" lang="en"
					value="false"
					onclick="validateMandatoryFields('Pending Final Approval')" onmouseover="showToolTip(true)" onmouseout="showToolTip(false)">SUBMIT
					FOR FINAL REVIEW</button>
				<%
					}

						}

				if(PermissionUtil.canPublishRPEC((PortletRequest) request.getAttribute("javax.portlet.request")) && (rpecStatus == null || !rpecStatus.equals("Completed")) && !mode.equals("view")){
				%>
					<button name="publishRecord" type="button" id="publishRecord"
						class="btn button-publish button-text btn-md" lang="en"
						value="false" onclick="validateMandatoryFields('Approved')">PUBLISH
						RECORD</button>
				<%
				}
				if((rpecStatus != null && !rpecStatus.equals("Completed") && !mode.equals("view")) || (rpecStatus == null))
				{
				%>
					<button name="cancel" type="button"
					class="btn button-cancel  button-text btn-md" lang="en"
					onclick="onCancel()">CANCEL</button>
				<%
					}
				%>
			</div>
		</div>
		<div class="yui3-skin-sam">
			<div id="success-submit" hidden="true" class="modalpopupBox">
				<div id="success-submit-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>RPEC Record Saved Successfully!</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn btn-primary popup-back-to-record-submit pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">BACK
									TO RPEC SUMMARY</button>
								<button type="button"
									class="btn btn-default popup-back-to-home-submit pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">GO
									TO HOME</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
		</div>

		<div class="yui3-skin-sam">
			<div id="success-review-approved" hidden="true" class="modalpopupBox">
				<div id="success-review-approved-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>RPEC review Approved!</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn btn-primary popup-back-to-record-submit-review pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">BACK
									TO RPEC SUMMARY</button>
								<button type="button"
									class="btn btn-default popup-back-to-home-submit-review pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">GO
									TO HOME</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
		</div>

		<div class="yui3-skin-sam">
			<div id="success-review-rejected" hidden="true" class="modalpopupBox">
				<div id="success-review-rejected-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>RPEC review Rejected!</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn btn-primary popup-back-to-record-submit-review-reject pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">BACK
									TO RPEC SUMMARY</button>
								<button type="button"
									class="btn btn-default popup-back-to-home-submit-review-reject pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">GO
									TO HOME</button>
							</aui:col>
						</aui:row>
                	</form>
				</div>
			</div>
		</div>

		<div class="yui3-skin-sam">
			<div id="success-status-update" hidden="true" class="modalpopupBox">
				<div id="success-status-update-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>RPEC Review Completed!</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn btn-primary popup-back-to-record-status pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">BACK
									TO RPEC SUMMARY</button>
								<button type="button"
									class="btn btn-default popup-back-to-home-status pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">GO
									TO HOME</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
		</div>


		<div class="yui3-skin-sam">
			<div id="submitting-fails" hidden="true" class="modalpopupBox">
				<div id="submitting-fails-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3 class="nullify-h3">Sorry! You are allowed for a submission only if you have selected at least one competency and under which you have marked the proficiency for at least one of its statements</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="button-center">
								<button type="button"
									class="btn btn-primary popup-ok"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">Ok</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
		</div>

		<div class="yui3-skin-sam">
			<div id="remarks-fails" hidden="true" class="modalpopupBox">
				<div id="remarks-fails-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3 class="nullify-h3">Are you sure, you want to save RPEC without saving the Remarks?</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="button-center">
								<button type="button"
									class="btn btn-primary popup-remarks-yes"
									style="margin-left: 0; margin-right: 0; font-size: 12px !important">Yes</button>

									<button type="button"
									class="btn btn-primary popup-remarks-no"
									style="margin-left: 0; margin-right: 0; font-size: 12px !important">No</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
		</div>



		<div class="yui3-skin-sam">
			<div id="success-Submit-for-final-sign-off" hidden="true" class="modalpopupBox">
				<div id="success-Submit-for-final-sign-off-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>RPEC Submitted for Final Sign Off Successfully!</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn btn-primary popup-back-to-record-sign-off pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">BACK
									TO RPEC SUMMARY</button>
								<button type="button"
									class="btn btn-default popup-back-to-home-sign-off pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">GO
									TO HOME</button>
							</aui:col>
						</aui:row>

					</form>
				</div>
			</div>
		</div>

		<div class="yui3-skin-sam">
			<div id="nullify-confirm" hidden="true" class="modalpopupBox nullify">
				<div id="nullify-confirm-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3 class="nullify-h3">Nullify this record?</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" style="text-align:center">
								<span class="nullify-text">Please provide your reasons
									justifying this action.</span>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<input type="text" name="nullify-reason" class="nullify-reason"
									id="nullifyreason" placeholder="Add your reasons here..." />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<button type="button"
									class="btn  btn-default popup-confirm-nullify pull-left"
									style="width: 200px; margin-left: 0; margin-right: 0; font-size: 12px !important">CONFIRM</button>
								<button type="button"
									class="btn btn-primary popup-cancel-nullify pull-right"
									style="width: 131px; margin-left: 0; margin-right: 0; font-size: 12px !important">CANCEL
								</button>
							</aui:col>
						</aui:row>

					</form>
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

	<script type="text/javascript">
var maximumDays = "<%=maximumCalendarDays%>";
	    var modelName = "<%=modelName%>";
	    var dashBoardLink  =  "<%=dashBoardLink%>";
	    var userType = "<%=userType%>";
	    var candidateRoleName = "<%=candidateRoleName%>";
	    var RELCUserRoleName = "<%=RELCUserRoleName%>";
	    var loggedInUser = "<%=loggedInUser%>";
	    var rpecStatus = "<%=rpecStatus%>";
	    var candidateId = "<%=candidateId%>";
	    var formStorageId = "<%=formStorageId%>";
	    var reviewPeriodNumber = "<%=reviewPeriodNumber%>";
	    var baseUrl = "<%=baseUrl%>";
	    if(reviewPeriodNumber === "null") {
	    	reviewPeriodNumber = "";
	    }
	    var selectedATO = {};
	    var finalData = {};

	function parseDateForRPECNotification(date) {
		if(date != "") {
		var t = new Date(date);
		var dt = ((t.getDate() + '').length === 1) ? '0' + t.getDate() : t
				.getDate();
		var month = t.getMonth() + 1;
		month = ((month + '').length === 1) ? '0' + month : month;
		var year = t.getFullYear();
		return dt + '/' + month + '/' + year;
		 }
		return "";
	}

	function populateDropDown(atoList) {
	   var elementDrpDwn = document.getElementById(namespace + "atoNames");
       var atoMap = new Map();
       for ( var i in atoList) {
    	    atoMap.set(atoList[i].AtoName.uuid , atoList[i].AtoName.name);
        	selectedATO[atoList[i].AtoName.uuid] = atoList[i];
		}
       atoMap.forEach(function(value, key, atoMap) {
     	var opt = new Option(value, key);
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		});
	}

	function propogateATODetails(ATOId) {
		finalData.CandidateRole = {};
		if(selectedATO[ATOId].TrainingPrincipal !== undefined &&  selectedATO[ATOId].TrainingPrincipal !== null) {
			finalData.CandidateRole.TrainingPrincipalUserId = selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserId;
    	}
		finalData.ApprovedMentors = {};

		if(selectedATO[ATOId].ApprovedMentors !== undefined && selectedATO[ATOId].ApprovedMentors !== null) {

			if(selectedATO[ATOId].ApprovedMentors.originalUserId !== undefined && selectedATO[ATOId].ApprovedMentors.originalUserId !== null) {
				finalData.ApprovedMentors.userId = selectedATO[ATOId].ApprovedMentors.originalUserId;
			} else {
				finalData.ApprovedMentors.userId = "";
			}

			if(selectedATO[ATOId].ApprovedMentors.firstName !== undefined && selectedATO[ATOId].ApprovedMentors.firstName !== null) {
				finalData.ApprovedMentors.firstName = selectedATO[ATOId].ApprovedMentors.firstName;
			} else {
				finalData.ApprovedMentors.firstName = "";
			}

			if(selectedATO[ATOId].ApprovedMentors.lastName !== undefined &&  selectedATO[ATOId].ApprovedMentors.lastName !== null) {
				 finalData.ApprovedMentors.lastName = selectedATO[ATOId].ApprovedMentors.lastName;
			} else {
				 finalData.ApprovedMentors.lastName = null;
			}
		} else {
			finalData.ApprovedMentors.userId = "";
			finalData.ApprovedMentors.firstName = "";
			finalData.ApprovedMentors.lastName = "";
		}
		finalData.AtoName = {};
		if(selectedATO[ATOId].AtoName !== undefined && selectedATO[ATOId].AtoName !== null) {
			if(selectedATO[ATOId].AtoName.organizationId !== undefined && selectedATO[ATOId].AtoName.organizationId !== null) {
				finalData.AtoName.organizationId = selectedATO[ATOId].AtoName.organizationId;
			} else {
				finalData.AtoName.organizationId = "";
			}
			if(selectedATO[ATOId].AtoName.name !== undefined && selectedATO[ATOId].AtoName.name !== null) {
				finalData.AtoName.name = selectedATO[ATOId].AtoName.name;
			} else {
				finalData.AtoName.name = "";
			}
		} else {
			finalData.AtoName.organizationId = "";
			finalData.AtoName.name = "";
		}
		if(selectedATO[ATOId].RoleDateFrom !== undefined && selectedATO[ATOId].RoleDateFrom !== null) {
			finalData.CandidateRole.RoleDateFrom = selectedATO[ATOId].RoleDateFrom;
		} else {
			finalData.CandidateRole .RoleDateFrom = "";
		}
		if(selectedATO[ATOId].RoleDateTo !== undefined && selectedATO[ATOId].RoleDateTo !== null) {
			finalData.CandidateRole.RoleDateTo = selectedATO[ATOId].RoleDateTo;
		} else  {
			finalData.CandidateRole.RoleDateTo = "";
		}

		if(selectedATO[ATOId].CandidateJobTitle !== undefined && selectedATO[ATOId].CandidateJobTitle !== null)
		{
			finalData.CandidateRole.CandidateJobTitle = selectedATO[ATOId].CandidateJobTitle;
		}
		else
		{
			finalData.CandidateRole.CandidateJobTitle = "";
		}
//			finalData.CandidateRole.CandidateJobTitle = candidatesData.CandidateJobTitle;

			if(selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserFirstName !== undefined && selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserFirstName !== null
					&& selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserLastName !== undefined && selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserLastName !== null)
			{
				finalData.CandidateRole.TrainingPrincipalName = selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserFirstName + " " + selectedATO[ATOId].TrainingPrincipal.primaryPrincipalUserLastName;
			}
			else
			{
				finalData.CandidateRole.TrainingPrincipalName = "";
			}
//			finalData.CandidateRole.TrainingPrincipalName = candidatesData.AtoDetails.TrainingPrincipalName;
		propogateSelectedATOData();
	}

	function sortByDate (resultObject) {
		return resultObject.sort(function(a,b){
	 		return a.RoleDateTo - b.RoleDateTo;
	 	}).reverse().slice(0,1);
	}

	function propogateSelectedATOData() {
		if(document.getElementById('atoName') != null) {
			document.getElementById('atoName').value = finalData.AtoName.name;
		}
		document.getElementById('mentorName').value = finalData.ApprovedMentors.firstName + " " + finalData.ApprovedMentors.lastName;
		document.getElementById('jobRole').value = finalData.CandidateRole.CandidateJobTitle;
		document.getElementById('trainingPrincipal').value = finalData.CandidateRole.TrainingPrincipalName;
		document.getElementById('dateFromJobRole').value = parseDateForRPECNotification(finalData.CandidateRole.RoleDateFrom);
		document.getElementById('dateToJobRole').value = parseDateForRPECNotification(finalData.CandidateRole.RoleDateTo);
	}
       document.getElementById("reviewPeriod").innerHTML = reviewPeriodNumber;
	var namespace = "<portlet:namespace />";
	var mode = "<%=mode%>";
	var userName = "<%=userName%>";
		if (userName === "null" || userName === undefined || userName === null) {
			userName = "";
		}
		var candidatesData = <%=candidatesData%>;
		if ((candidatesData != undefined && candidatesData != null ) &&  (candidatesData.AtoDetails !== undefined
				&& candidatesData.AtoDetails !== null
				&& candidatesData.AtoDetails !== "")) {
			if (userType.toLowerCase() === "relcuser" && formStorageId === "0"
					&& candidatesData.AtoDetails.length > 1) {
				populateDropDown(candidatesData.AtoDetails);
			}  else {
		    if(candidatesData.AtoDetails instanceof Array) {
		    	var resultObject = [];
				candidatesData.AtoDetails.forEach(function(ATODetails) {
					  resultObject.push(ATODetails);
			 	});
				candidatesData.AtoDetails = sortByDate(resultObject);
				//propogateSelectedATOData();


		    	if(candidatesData.AtoDetails.length === 1) {
		    		finalData.CandidateRole = {};
		    		if(candidatesData.AtoDetails[0].TrainingPrincipal !== undefined && candidatesData.AtoDetails[0].TrainingPrincipal !== null) {
					finalData.CandidateRole.TrainingPrincipalUserId = candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserId;
		    		} else {
		    		finalData.CandidateRole.TrainingPrincipalUserId = "";
		    		}
					finalData.ApprovedMentors = {};

					if(candidatesData.AtoDetails[0].ApprovedMentors !== undefined && candidatesData.AtoDetails[0].ApprovedMentors !== null) {

						if(candidatesData.AtoDetails[0].ApprovedMentors.originalUserId !== undefined && candidatesData.AtoDetails[0].ApprovedMentors.originalUserId !== null) {
							finalData.ApprovedMentors.userId = candidatesData.AtoDetails[0].ApprovedMentors.originalUserId;
						} else {
							finalData.ApprovedMentors.userId = "";
						}

						if(candidatesData.AtoDetails[0].ApprovedMentors.firstName !== undefined && candidatesData.AtoDetails[0].ApprovedMentors.firstName !== null) {
							finalData.ApprovedMentors.firstName = candidatesData.AtoDetails[0].ApprovedMentors.firstName;
						} else {
							finalData.ApprovedMentors.firstName = "";
						}

						if(candidatesData.AtoDetails[0].ApprovedMentors.lastName !== undefined &&  candidatesData.AtoDetails[0].ApprovedMentors.lastName !== null) {
							 finalData.ApprovedMentors.lastName = candidatesData.AtoDetails[0].ApprovedMentors.lastName;
						} else {
							 finalData.ApprovedMentors.lastName = null;
						}
					} else {
						finalData.ApprovedMentors.userId = "";
						finalData.ApprovedMentors.firstName = "";
						finalData.ApprovedMentors.lastName = "";
					}
					finalData.AtoName = {};
					if(candidatesData.AtoDetails[0].AtoName !== undefined && candidatesData.AtoDetails[0].AtoName !== null) {
						if(candidatesData.AtoDetails[0].AtoName.organizationId !== undefined && candidatesData.AtoDetails[0].AtoName.organizationId !== null) {
							finalData.AtoName.organizationId = candidatesData.AtoDetails[0].AtoName.organizationId;
						} else {
							finalData.AtoName.organizationId = "";
						}
						if(candidatesData.AtoDetails[0].AtoName.name !== undefined && candidatesData.AtoDetails[0].AtoName.name !== null) {
							finalData.AtoName.name = candidatesData.AtoDetails[0].AtoName.name;
						} else {
							finalData.AtoName.name = "";
						}
					} else {
						finalData.AtoName.organizationId = "";
						finalData.AtoName.name = "";
					}
					if(candidatesData.AtoDetails[0].RoleDateFrom !== undefined && candidatesData.AtoDetails[0].RoleDateFrom !== null) {
						finalData.CandidateRole.RoleDateFrom = candidatesData.AtoDetails[0].RoleDateFrom;
					} else {
						finalData.CandidateRole .RoleDateFrom = "";
					}
					if(candidatesData.AtoDetails[0].RoleDateTo !== undefined && candidatesData.AtoDetails[0].RoleDateTo !== null) {
						finalData.CandidateRole.RoleDateTo = candidatesData.AtoDetails[0].RoleDateTo;
					} else  {
						finalData.CandidateRole.RoleDateTo = "";
					}

					if(candidatesData.AtoDetails[0].CandidateJobTitle !== undefined && candidatesData.AtoDetails[0].CandidateJobTitle !== null)
					{
						finalData.CandidateRole.CandidateJobTitle = candidatesData.AtoDetails[0].CandidateJobTitle;
					}
					else
					{
						finalData.CandidateRole.CandidateJobTitle = "";
					}
//		  			finalData.CandidateRole.CandidateJobTitle = candidatesData.CandidateJobTitle;

		 			if(candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserFirstName !== undefined && candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserFirstName !== null
		 					&& candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserLastName !== undefined && candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserLastName !== null)
		 			{
		 				finalData.CandidateRole.TrainingPrincipalName = candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserFirstName + " " + candidatesData.AtoDetails[0].TrainingPrincipal.primaryPrincipalUserLastName;
		 			}
		 			else
		 			{
		 				finalData.CandidateRole.TrainingPrincipalName = "";
		 			}
//		 			finalData.CandidateRole.TrainingPrincipalName = candidatesData.AtoDetails.TrainingPrincipalName;
					propogateSelectedATOData();
				  }
		    	}
		     else {
			finalData.CandidateRole = {};
			finalData.CandidateRole.TrainingPrincipalUserId = candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserId;
			finalData.ApprovedMentors = {};

			if(candidatesData.AtoDetails.ApprovedMentors !== undefined && candidatesData.AtoDetails.ApprovedMentors !== null) {

				if(candidatesData.AtoDetails.ApprovedMentors.originalUserId !== undefined && candidatesData.AtoDetails.ApprovedMentors.originalUserId !== null) {
					finalData.ApprovedMentors.userId = candidatesData.AtoDetails.ApprovedMentors.originalUserId;
				} else {
					finalData.ApprovedMentors.userId = "";
				}

				if(candidatesData.AtoDetails.ApprovedMentors.firstName !== undefined && candidatesData.AtoDetails.ApprovedMentors.firstName !== null) {
					finalData.ApprovedMentors.firstName = candidatesData.AtoDetails.ApprovedMentors.firstName;
				} else {
					finalData.ApprovedMentors.firstName = "";
				}

				if(candidatesData.AtoDetails.ApprovedMentors.lastName !== undefined &&  candidatesData.AtoDetails.ApprovedMentors.lastName !== null) {
					 finalData.ApprovedMentors.lastName = candidatesData.AtoDetails.ApprovedMentors.lastName;
				} else {
					 finalData.ApprovedMentors.lastName = null;
				}
			} else {
				finalData.ApprovedMentors.userId = "";
				finalData.ApprovedMentors.firstName = "";
				finalData.ApprovedMentors.lastName = "";
			}
			finalData.AtoName = {};
			if(candidatesData.AtoDetails.AtoName !== undefined && candidatesData.AtoDetails.AtoName !== null) {
				if(candidatesData.AtoDetails.AtoName.organizationId !== undefined && candidatesData.AtoDetails.AtoName.organizationId !== null) {
					finalData.AtoName.organizationId = candidatesData.AtoDetails.AtoName.organizationId;
				} else {
					finalData.AtoName.organizationId = "";
				}
				if(candidatesData.AtoDetails.AtoName.name !== undefined && candidatesData.AtoDetails.AtoName.name !== null) {
					finalData.AtoName.name = candidatesData.AtoDetails.AtoName.name;
				} else {
					finalData.AtoName.name = "";
				}
			} else {
				finalData.AtoName.organizationId = "";
				finalData.AtoName.name = "";
			}
			if(candidatesData.AtoDetails.RoleDateFrom !== undefined && candidatesData.AtoDetails.RoleDateFrom !== null) {
				finalData.CandidateRole.RoleDateFrom = candidatesData.AtoDetails.RoleDateFrom;
			} else {
				finalData.CandidateRole .RoleDateFrom = "";
			}
			if(candidatesData.AtoDetails.RoleDateTo !== undefined && candidatesData.AtoDetails.RoleDateTo !== null) {
				finalData.CandidateRole.RoleDateTo = candidatesData.AtoDetails.RoleDateTo;
			} else  {
				finalData.CandidateRole.RoleDateTo = "";
			}

			if(candidatesData.CandidateJobTitle !== undefined && candidatesData.CandidateJobTitle !== null)
			{
				finalData.CandidateRole.CandidateJobTitle = candidatesData.CandidateJobTitle;
			}
			else
			{
				finalData.CandidateRole.CandidateJobTitle = "";
			}

			if(candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserFirstName !== undefined && candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserFirstName !== null
					&& candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserLastName !== undefined && candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserLastName !== null)
		 	{
		 		finalData.CandidateRole.TrainingPrincipalName = candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserFirstName + " " + candidatesData.AtoDetails.TrainingPrincipal.primaryPrincipalUserLastName;
		 	}
		 	else
		 	{
		 		finalData.CandidateRole.TrainingPrincipalName = "";
		 	}

			propogateSelectedATOData();
		  }

		}

	}else if (formStorageId === "0") {
			finalData.CandidateRole = {};
			finalData.CandidateRole.TrainingPrincipalUserId = "";
			finalData.ApprovedMentors = {};
			finalData.ApprovedMentors.userId = "";
			finalData.AtoName = {};
			finalData.AtoName.organizationId = "";
			finalData.CandidateRole.RoleDateFrom = "";
			finalData.CandidateRole.RoleDateTo = "";
			finalData.AtoName.name = "";
			finalData.ApprovedMentors.firstName = "";
			finalData.ApprovedMentors.lastName = "";
			finalData.CandidateRole.CandidateJobTitle = "";
			finalData.CandidateRole.TrainingPrincipalName = "";
		}

		var ajaxUrl = "${resourceURL}";
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/rpec-record/rpec-record.js?<%=System.currentTimeMillis()%>"
		language="javascript1.2"></script>