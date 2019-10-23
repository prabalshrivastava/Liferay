<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/referencenumber.css?minifierType=css'></link>
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
	String dashBoardLink = SambaashUtil.getDashBoard();
	List<SPListType> productTypeList = SPListTypeLocalServiceUtil
			.getByKey("finance.accountingtable.productype", groupId);
	List<SPListType> functionalComponentList = SPListTypeLocalServiceUtil
			.getByKey("finance.referencenumber.functionalcomponent", groupId);
	List<SPListType> categoryTypeList = SPListTypeLocalServiceUtil
			.getByKey("finance.referencenumber.categorytype", groupId);
	List<SPListType> typeList = SPListTypeLocalServiceUtil
			.getByKey("finance.accountingtable.clienttype", groupId);
	List<SPListType> structurePartTypeList = SPListTypeLocalServiceUtil
			.getByKey("finance.referencenumber.structureparttype", groupId);
	List<SPListType> structurePartValueList = SPListTypeLocalServiceUtil
			.getByKey("finance.referencenumber.structurepartvalue", groupId);
	List<SPListType> frequencyList = SPListTypeLocalServiceUtil
			.getByKey("finance.referencenumber.frequency", groupId);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
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
						<h2><span>REFERENCE NUMBER STRUCTURE SETUP</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="referenceNumberStructureSetup">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div class="formContainer container formio-form">
			<form class="aui" id="billingForm"
				name="billingForm" action="">
				<aui:input name="" type="hidden" id="referenceNumberCode" />
				<aui:input name="" type="hidden" id="status" />
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
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Product Type <span
										class="red-star">*</span></label>
									<aui:select name="" id="productType"
										cssClass="form-control" onChange="downloadDropdownData(this.value);">
										<aui:option value="" hidden="true">
											Choose a Product Type...
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Product Sub-Type
									</label>
									<aui:select name="" id="productSubType"
										cssClass="form-control">
										<aui:option value="" hidden="true">
											Choose Product Sub-Type
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Functional Component
										<span class="red-star">*</span>
									</label>
									<aui:select name="" id="functionalComponent"
										cssClass="form-control">
										<aui:option value="" hidden="true">
											Choose a Functional Component...
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Category Type
										<span class="red-star">*</span>
									</label>
									<aui:select name="" id="categoryType"
										cssClass="form-control">
										<aui:option value="" hidden="true">
											Choose a Category Type...
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group" id="typeRadioDiv">
									<label cssClass="control-label">Type <span
										class="red-star">*</span></label>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-checkbox offset3">
								<label class="checkbox-custom-label sequenceNoResetClass"> <input type="checkbox"
										name="sequenceNoReset" class="form-control checkbox-custom sequeceNoReset" id="sequenceNoReset"
										onChange="showHideFrequencyDiv(this.checked);"> Sequence No. Reset
								</label>
							</aui:col>
						</aui:row>
						<aui:row style="display:none" id="frequencyDivId">
							<aui:col span="6" cssClass="formio-component-textfield offset3">
								<div class="form-group">
									<aui:select name="" id="frequency"
										cssClass="form-control">
										<aui:option value="" hidden="true">
											Choose a Frequency...
										</aui:option>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="structure dashed-box">
									<div class="structureHolder" id="structureHolder">
										<div class="structureContainer" id="structureContainer" style="display:none">
											<h3 class="header toggler-header-collapsed" style="position: relative;top: 0;">
												<div class="headerText">Structure</div>
												<ul class="nav">
													<li style="float:left"><a href="javascript:void(0);"
														class="btn removeBtn" onclick="removeReferenceStructure(this)"
														style="top: 0px;padding-left: 16px !important;">Remove</a></li>
													<li><a href="javascript:void(0);"
														class="minusIcon" style="top: -2px;" onclick="closeReferenceStructure(this)">Close</a></li>
												</ul>
											</h3>
											<div class="ReferenceStructureContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:col span="6" cssClass="formio-component-textfield">
														<div class="form-group">
															<label cssClass="control-label">Structure Part Type
																<span class="red-star">*</span>
															</label>
															<aui:select name="" id="structurePartType"
																cssClass="form-control structurePartType" onChange="changeStructurePartValue(this.value, this);">
																<aui:option value="" hidden="true">
																	Choose a Structure Part Type...
																</aui:option>
															</aui:select>
															
														</div>
													</aui:col>
													<aui:col span="6" cssClass="formio-component-textfield">
														<div class="form-group">
															<label cssClass="control-label">Structure Part Value
																<span class="red-star">*</span>
															</label>
															<aui:select name="" id="structurePartValue"
																cssClass="form-control structurePartValue">
																<aui:option value="" hidden="true">
																	Choose a Structure Part Value...
																</aui:option>
															</aui:select>
															<aui:input type="text" hidden="true" name="" id="structurePartValueText"
																cssClass="form-control structurePartValueText"
																placeholder="Enter a Value"/>
														
														</div>
													</aui:col>
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
								<aui:button cssClass="btn greenbtn" id="addStructureButton"
									value="ADD STRUCTURE" onClick="addAnotherStruture()"></aui:button>
							</aui:col>
						</aui:row>
						<aui:row cssClass="userAction">
							<aui:col span="1"></aui:col>
							<aui:col span="10">
								<aui:col span="3">
									<button type="button" class="btn btn-md" id="deactivate"
										onClick="storageStatus1('Inactive','<%=formStorageId %>')" style="background-color: #ffc48b;color: #703802;display:none">DEACTIVATE</button>
										<button type="button" class="btn btn-md" id="activate"
										onClick="storageStatus1('Active','<%=formStorageId %>')" style="background-color: #5cb85c;color: white;display:none">ACTIVATE</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" class="btn btn-primary btn-md" id="update"
										onClick="validateFields('update')">Update</button>
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
		<div class="formContainer container formio-form" 
		style="box-shadow: 1px 1px 1px 2px #eef3fc;background-color: 
		#f7f9fe;padding: 10px 160px;border: 1px solid #eef3fc;    font: 500 13px "Work Sans",sans-serif;">
			<form class="aui" id="headerForm">
				<aui:row class="header">
					<div class="headerText" style="color:#2d4eab;">NOTES :</div>
					<div>* If the value of <small> Structure Part Type </small> is chosen to be <small> Variable </small> and 
					<small> Structure Part Value </small> is entered as <small> Sequential running numeric number </small>, then the <small>Sequence No. Reset</small> function can be applied.</div>
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
						<h3 id="success-msg">Reference Number Created</h3>
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
					<br />
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn lightbluebtn popup-confirm-deactivate pull-left">Confirm</button>
							<button type="button"
								class="btn cancel bluebtn popup-cancel-deactivate pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>

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
								type="button" onClick="goBack()">Go Back</button>
					</aui:col>
				</aui:row>
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
				<br />
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
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn cancel btn-primary popup-cancel pull-right"
							onClick="moveToList()">Go Back</button>
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

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var productTypeList = <%=objectMapper.writeValueAsString(productTypeList)%>;
var functionalComponentList = <%=objectMapper.writeValueAsString(functionalComponentList)%>;
var categoryTypeList = <%=objectMapper.writeValueAsString(categoryTypeList)%>;
var typeList = <%=objectMapper.writeValueAsString(typeList)%>;
var structurePartTypeList = <%=objectMapper.writeValueAsString(structurePartTypeList)%>;
var structurePartValueList = <%=objectMapper.writeValueAsString(structurePartValueList)%>;
var frequencyList = <%=objectMapper.writeValueAsString(frequencyList)%>;
var baseUrl = "<%=baseUrl%>";
var mode = "edit";
var groupId = "<%=groupId%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/referencenumber.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>