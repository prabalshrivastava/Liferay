<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/css/batchupload.css?<%=System.currentTimeMillis()%>'>
<portlet:defineObjects />
<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>
<portlet:actionURL var="batchUploadURL" name="uploadFiles">
</portlet:actionURL>

<%
	String resultComponent = (String) request.getAttribute("component");
	String resultATO = (String) request.getAttribute("ato");
	String dashBoardLink = SambaashUtil.getDashBoard();
%>
<div class="newPortlets" id="div">
	<!-- header -->

	<div class="subHeader">
		<div class="container">

			<aui:row>
				<aui:col span="10" cssClass="text-center header-title">
					<h2>UPLOAD CANDIDATES</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right header-home-link">
					 <aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="container body-container">
		<div class="uc-box enrolment-center-align">
			<aui:row>
				<aui:col span="12" cssClass="text-center">
					<img
						src="<%=request.getContextPath()%>/img/background-batch-upload.png">
				</aui:col>
			</aui:row>
			<div class="uc-box-bottom">
				<aui:form action="<%=batchUploadURL%>" enctype="multipart/form-data"
					method="POST" id="fm" name="fm">
					<aui:row>
						<aui:col span="12" cssClass="choices formio-choices">
							<div class="form-group">
								<label cssClass="control-label">Component</label>
								<aui:select name="component" id="component"
									cssClass="form-control" placeholder="Choose a Session Schedule"
									onChange="fetchEntityLink(this.value);">
									<aui:option value="" hidden="true">
									</aui:option>

								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="choices formio-choices">
							<div class="form-group">
								<label cssClass="control-label">ATO Name</label>
								<aui:select name="ato" id="ato" cssClass="form-control"
									placeholder="Choose a Session Schedule"
									onChange="fetchEntityLink(this.value);">
									<aui:option value="" hidden="true">
									</aui:option>

								</aui:select>
							</div>
						</aui:col>
					</aui:row>


					<div class="text-center">
						<aui:input type="hidden" name="formId" id="formId" value="1832" />
						<br> <span class="btn-file" style="cursor: not-allowed;">
							UPLOAD <input disabled="disabled" type="file" name="myFile"
							id="myFile">
						</span> <br> <br> <a
							href="<%=request.getContextPath()%>/assets/sample.csv"
							target="_blank">[ Download sample CSV template ]</a>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<style>
.aui .aui-field-select {
	width: 50%;
	margin-left: 25%;
}

.aui label {
	margin-left: 25%;
}

.aui .row-fluid .span4 {
	width: 100% !important;
}
</style>
<script type="text/javascript">
var cols =     document.getElementsByClassName('control-label');
for(i=0; i<cols.length; i++) {
	console.log(cols[i]);
  cols[i].style.display = 'none';
}
	var namespace = "<portlet:namespace/>";
	var mode = "view";
	var formInstance;

	getList();
	function afterFormLoadedFormIOForm(thisInstance) {
		formInstance = thisInstance;
	}
	document.getElementById("myFile").onchange = function() {

		this.form.submit();
	};
	function getList() {

		var comp =<%=resultComponent%>;
		var compName = getEID(namespace + "component");

		populateDropDown(compName, comp);

		var ato = <%=resultATO%>;
		var atoName = getEID(namespace + "ato");

		populateDropDown(atoName, ato);
	}
	function populateDropDown(elementDrpDwn, data) {
		debugger
		var compMap = new Map();

		for ( var i in data) {

			compMap.set(i, data[i]);
		}

		compMap.forEach(function(value, key, compMap) {

			var opt = new Option(value, key);
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		})
	}

	function getEID(element) {
		return document.getElementById(element);
	}
	function fetchEntityLink(d) {
		document.getElementById("myFile").disabled = false;
		document.getElementById("myFile").style.cursor = 'pointer';

	}
</script>
