<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
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
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	List<SPListType> priceCatList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.category", groupId);
	List<SPListType> subjectPriceTypeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.subject.pricetype", groupId);
	List<SPListType> invigilatorPriceTypeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.invigilator.pricetype", groupId);
	List<SPListType> examFeesPriceSubTypeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.examfees.pricesubtype", groupId);
	List<SPListType> miscFeesPriceSubTypeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.miscfees.pricesubtype", groupId);
	List<SPListType> invigilatorPriceSubTypeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.invigilator.pricesubtype", groupId);
	List<SPListType> subjectTypeList = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.subjecttype", groupId);
	List<SPListType> nofFullUnits = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.fullunits", groupId);
	List<SPListType> nofHalfUnits = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.halfunits", groupId);
	List<SPListType> nofLawUnits = SPListTypeLocalServiceUtil
			.getByKey("priceengine.pricesubscheme.lawunits", groupId);
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
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>PRICE SUB-SCHEME Setup</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>

	<div class="priceSubSchemeSetup">
		<div class="formContainer container formio-form">
			<form class="aui" id="price_subscheme_form"
				name="price_subscheme_form" action="">
				<input type="hidden" id="status" />
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Pricing Sub-Scheme Code <span
										class="red-star">*</span></label>
									<aui:input type="text" name="" id="priceSubSchemeCode"
										cssClass="form-control"
										placeholder="Enter Pricing Sub-Schem Code">
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Pricing Sub-Scheme Name
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="priceSubSchemeName"
										cssClass="form-control" placeholder="Enter a name" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Pricing Category <span class="red-star">*</span></label>
									<aui:select name="" id="priceCategory"
										cssClass="form-control" onChange="changePriceCategory()">
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Pricing Type <span class="red-star">*</span></label>
									<aui:select name="" id="priceType"
										cssClass="form-control" onChange="changePriceType()">
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Pricing Sub-Type <span class="red-star">*</span></label>
									<aui:select name="" id="priceSubType"
										cssClass="form-control" onChange="changePriceSubType()">
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="subjectTypeRow">
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Subject Type <span class="red-star">*</span></label>
									<aui:select name="" id="subjectType"
										cssClass="form-control" onChange="changeSubjectType();">
										</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="noOfFullUnitsRow">
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Number of Full Units</label>
									<aui:select name="" id="noOfFullUnits" cssClass="form-control">
										
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="noOfHalfUnitsRow">
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Number of Half Units</label>
									<aui:select name="" id="noOfHalfUnits" cssClass="form-control">
										<
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="noOfLawUnitsRow">
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Number of Law Units</label>
									<aui:select name="" id="noOfLawUnits" cssClass="form-control">
										
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="userAction">
							<aui:col span="1"></aui:col>
							<aui:col span="10">
								<aui:col span="3">
									<button type="button" class="btn btn-md" id="deactivate"
										onClick="storageStatus1('Inactive','<%=formStorageId %>')" style="background-color: #ee3124;color: white;display:none">DEACTIVATE</button>
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
	</div>
	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Price Sub-Scheme Created</h3>
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
</div>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var baseUrl = "<%=baseUrl%>";
var mode = "edit";
var priceSubSchemeCategoryList = <%=objectMapper.writeValueAsString(priceCatList)%>;
var subjectPriceTypeList = <%=objectMapper.writeValueAsString(subjectPriceTypeList)%>;
var invigilatorPriceTypeList = <%=objectMapper.writeValueAsString(invigilatorPriceTypeList)%>;
var examFeesPriceSubTypeList = <%=objectMapper.writeValueAsString(examFeesPriceSubTypeList)%>;
var miscFeesPriceSubTypeList = <%=objectMapper.writeValueAsString(miscFeesPriceSubTypeList)%>;
var invigilatorPriceSubTypeList = <%=objectMapper.writeValueAsString(invigilatorPriceSubTypeList)%>;
var subjectTypeList = <%=objectMapper.writeValueAsString(subjectTypeList)%>;
var nofFullUnits = <%=objectMapper.writeValueAsString(nofFullUnits)%>;
var nofHalfUnits = <%=objectMapper.writeValueAsString(nofHalfUnits)%>;
var nofLawUnits = <%=objectMapper.writeValueAsString(nofLawUnits)%>;
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pricesubscheme.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>