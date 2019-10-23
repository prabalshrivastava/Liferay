<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="javax.portlet.PortletURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/css/batchupload.css?<%=System.currentTimeMillis()%>'>

<%
	String uploadTransactId = StringPool.BLANK;
	String totalRecords = StringPool.BLANK;
	String successfulRecords = StringPool.BLANK;
	String failedRecords = StringPool.BLANK;
	String heading = StringPool.BLANK;
	String sequence = StringPool.BLANK;
	JSONArray invalidRecords = JSONFactoryUtil.createJSONArray();
	if (Validator.isNotNull(request.getParameter("uploadTransactId"))) {
		uploadTransactId = (String) request
				.getParameter("uploadTransactId");

	}

	if (Validator.isNotNull(request.getParameter("totalRecords"))) {
		totalRecords = (String) request.getParameter("totalRecords");

	}
	if (Validator.isNotNull(request.getParameter("successfulRecords"))) {
		successfulRecords = (String) request
				.getParameter("successfulRecords");

	}
	if (Validator.isNotNull(request.getParameter("failedRecords"))) {
		failedRecords = (String) request.getParameter("failedRecords");

	}
	if (Validator.isNotNull(request.getParameter("heading"))) {
		heading = (String) request.getParameter("heading");

	}
	if (Validator.isNotNull(request.getParameter("sequence"))) {
		sequence = (String) request.getParameter("sequence");

	}
	if (Validator.isNotNull(request.getParameter("invalidRecords"))) {
		invalidRecords = JSONFactoryUtil.createJSONArray(request
				.getParameter("invalidRecords"));

	}
%>

<c:set var="totalRecords" value="${totalRecords}" />
<c:set var="failedRecords" value="${failedRecords}" />
<c:set var="successfulRecords" value="${successfulRecords}" />

<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="/html/atoadmission/list.jsp" />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="uploadStatURL">
	<portlet:param name="mvcPath"
		value="/html/atoadmission/batch/uploadStat.jsp" />
	<portlet:param name="uploadTransactId" value="<%=uploadTransactId%>" />
</liferay-portlet:renderURL>
<portlet:resourceURL var="exportAsCSV">
	<portlet:param name="exportCSV" value="exportCSV" />
</portlet:resourceURL>
<portlet:resourceURL var="resourceUrl1">
	<portlet:param name="param1" value="value1" />
</portlet:resourceURL>
<div class="newPortlets enrolment-body enrolment-center-align"
	style="width: 1200px;">

	<div class="subHeader">
		<div class="container" style="width: 1200px;">
			<aui:row>

				<aui:col span="10" cssClass="text-center header-title">
					<h2>UPLOAD CANDIDATES</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-righ header-home-link">
					<aui:a href="<%=homePage%>" title="Back to Dashboard">Back to Home</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>

	<div class="container">
		<div class="tint-Overlay">
			<div class="d-flex flex-column mx-auto w-60">
				<div class="base-wrapper">
					<div class="">
						<div class="top-container d-flex justify-content-center">
							<a href="<%=homePage%>" class="mx-auto base-button">START
								AGAIN</a>
						</div>
					</div>
					<div class="w-100 bottom-container d-flex flex-column">
						<button class="upload-btn">Upload Status</button>
						<div class="d-flex justify-content-around records">
							<div class="d-flex flex-column">
								<label class="stat-label">TOTAL RECORDS</label> <label
									class="total center"><%=totalRecords%></label>
							</div>
							<div class="v-line"></div>
							<div class="d-flex flex-column">
								<label class="stat-label">SUCCESSFUL RECORDS</label> <label
									class="successful center"><%=successfulRecords%></label>
							</div>
							<div class="v-line"></div>
							<div class="d-flex flex-column">
								<label class="stat-label">FAILED RECORDS</label> <label
									class="failed center"><%=failedRecords%></label>
							</div>
							<!--  <div class="v-line"></div>
                            <div class="d-flex flex-column">
                                <label class="stat-label">PENDING PROCESSING</label>
                                <label class="total center">0</label>
                            </div> -->
						</div>
					</div>
				</div>
				<h4 class="color-blue error-summary">Error Summary</h4>
				<div class="w-100 d-flex flex-column">
					<table>
						<tr>
							<td>Row No</td>
							<td>Unique Key</td>
							<td>Reason</td>
						</tr>

						<%
							for (int i = 0; i < invalidRecords.length(); i++) {
						%>
						<tr>
							<td><%=invalidRecords.getJSONObject(i).getString("RowNo")%></td>
							<td><%=invalidRecords.getJSONObject(i).getString("email")%></td>
							<td><%=invalidRecords.getJSONObject(i).getString("Reason")%></td>
						</tr>

						<%
							}
						%>
					</table>
				</div>
				<%-- <a href="<%=resourceUrl1%>">This is resourceURL</a> --%>
				<button class="btn download-btn btn-primary" onclick="onDownloadErrorFile()">DOWNLOAD FILE</button>
				<%-- <a href="<%=exportAsCSV%>" class="btn download-btn btn-primary"
					title="DOWNLOAD FILE">DOWNLOAD FILE</a> --%>
				<%-- <a href="<%=exportAsCSV%>" class="btn download-btn btn-primary">DOWNLOAD FILE</a> --%>
			</div>
		</div>

	</div>

</div>
<script>
	document
			.getElementsByClassName('taglib-search-iterator-page-iterator-bottom')[0].style.display = 'none';
	document.getElementsByClassName('taglib-search-iterator-page-iterator-top')[0].style.display = 'none';
	function onDownloadErrorFile() { 
		var invalidRec=<%=invalidRecords%>;
		console.log("Invalid Records:"+JSON.stringify(invalidRec));
		JSONToCSVConvertor(invalidRec, "Error", false);
		}

	function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
	    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
	    var headers = ["firstName", "lastName","passport", "nirc", "telephone1", "telephone2", "email",
	   				"gender", "currentPrograme", "Salutation", "enrolmentStatus", "programSemester", "programmeCode",
					"scheduleCode", "feeType", "dueDate", "subjectList", "priceSubSchemeCode", "Reason"];
	    
	    var key = ["firstName", "lastName","IDNumber", "IDNumber2", "telephone1", "telephone2", "email",
		   				"gender", "currentPrograme", "salutation", "enrolmentStatus", "programSemester", "programmeCode",
						"scheduleCode", "feeType", "dueDate", "subjectList", "priceSubSchemeCode", "Reason"];
	    
	    var CSV = headers.join(',');
	    CSV += "\r\n"; 
	    CSV += arrData.map(function(i){
    		return key.map(function(j){
    			return i[j]
    		}).join(',')
	    }).join('\r\n');
	    
	    if (CSV == '') {        
	        alert("Invalid data");
	        return;
	    }   
	    var fileName = "";
	    fileName += ReportTitle.replace(/ /g,"_");   
	    
	    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
	    
	    var link = document.createElement("a");    
	    link.href = uri;
	    
	    link.style = "visibility:hidden";
	    link.download = fileName + ".csv";
	    
	    document.body.appendChild(link);
	    link.click();
	    document.body.removeChild(link);
	}
</script>