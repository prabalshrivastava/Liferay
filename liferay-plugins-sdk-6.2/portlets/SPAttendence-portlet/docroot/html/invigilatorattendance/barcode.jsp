<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<portlet:defineObjects />
<%
	String formTypeName = request.getParameter("formTypeName");
	String filterData = request.getParameter("filterData");
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	String modelName = renderRequest.getPreferences().getValue("modelNamePref","");
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div class="newPortlets">
<div class="formContainer container formio-form">
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="12" cssClass="text-center">
					<h2>Record By Barcode Reader</h2>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div style="display: none;" class="alert"
							role="showAlert" id="alert_msg"></div>
	
	<div class="financeParameterSetup">
		
			<form class="aui" id="financeParameter_form1"
				name="financeParameter_form" action="">
				<aui:row>
							<aui:col span="1" cssClass="formio-component-textfield">
									<label cssClass="control-label" style="font-size: 15px;">NRIC</label>
							</aui:col>
							<aui:col span="11" cssClass="formio-component-textfield">
									<input type="text" name="" id="barcodeValue" class="form-control barcode-value span12" 
					placeholder="Scan Using Barcode Reader" oninput="saveScannedValue(event,'<%=filterData%>','<%=formTypeName%>');" autofocus tabindex="0"/>
							</aui:col>
						</aui:row>

<%-- 				<aui:row style="margin-top: 20px;"> --%>
<%-- 					<aui:col span="4" cssClass="control-label"> --%>
<%-- 					</aui:col> --%>
<%-- 					<aui:col span="4" cssClass="control-label" style="text-align: center;"> --%>
<!-- 						<button type="button" onclick="goBackAttendance(event);" class="btn btn-primary">Cancel</button> -->
<%-- 					</aui:col> --%>
<%-- 				</aui:row> --%>
			</form>
	
	</div>

		<div class="Table-Layout" id="entityLinkContainer">
			<div class="Heading">
				<div class="Cell Span-width-10">
					 <p>NRIC</p> 
					
				</div>
				<div class="Cell" id="stageClmn">
					 <p>Schedule</p> 
					
				</div>
				<div class="Cell Span-width-10">
					 <p>Name</p> 
					
				</div>
				<div class="Cell Span-width-15" id="applicantClmn">
					 <p>Time In</p> 
					
				</div>
				<div class="Cell">
					<p>Time Out</p> 
					
				</div>
				<div class="Cell" id="supervisorClmn">
					 <p>Subject Code</p> 
					
				</div>
				<div class="Cell" id="supervisorClmn">
					 <p>Sub Facility</p> 
					
				</div>
			
			</div>
		</div>



		<div class="Row hide addInfo" id="sampleEntityLinkRow">
			<input id="processStateId" type="hidden" value="" /> <input
				id="processId" type="hidden" value="" />

			<div class="Cell Celldata">
				<p id="nirc"></p>
			</div>
			<div class="Cell Celldata">
				<p id="schedule"></p>
			</div>
			<div class="Cell Celldata">
				<p id="name"></p>
			</div>
			<div class="Cell Celldata">
				<p id="timein"></p>
			</div>
			<div class="Cell Celldata">
				<p id=timeout></p>
			</div>
			<div class="Cell Celldata">
				<p id=subjectcode></p>
			</div>
			<div class="Cell Celldata">
				<p id=subfacility></p>
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
var vocabularyURL = "<%=vocabularyURL%>";
var mode = "view";
var baseUrl = "<%=baseUrl%>";
var modelName = "<%=modelName%>";
var filterData = "<%=filterData%>";

(function(){
	function setFocus() {
		var el = document.querySelector(".barcode-value");
		console.log(el.value);
		if(typeof el !== undefined && el !== null) {
			el.focus();
		}
	}
	var inter = setInterval(function() {
		if(document.querySelector(".barcode-value") !== null) {
			clearInterval(inter);	
		}
		setFocus();
	},1000);
})();
</script>