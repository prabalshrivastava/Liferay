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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/batchupload.css?<%=System.currentTimeMillis()%>'>
 
<%
 String uploadTransactId = StringPool.BLANK;
String totalRecords = StringPool.BLANK;
String successfulRecords = StringPool.BLANK;
String failedRecords = StringPool.BLANK;
JSONObject heading = JSONFactoryUtil.createJSONObject();
String sequence = StringPool.BLANK;
JSONArray invalidRecords = JSONFactoryUtil.createJSONArray();
 if(Validator.isNotNull(request.getParameter("uploadTransactId"))){
     uploadTransactId = (String) request.getParameter("uploadTransactId");
     
 }
 
 if(Validator.isNotNull(request.getParameter("totalRecords"))){
     totalRecords = (String) request.getParameter("totalRecords");
         
     }
 if(Validator.isNotNull(request.getParameter("successfulRecords"))){
     successfulRecords = (String) request.getParameter("successfulRecords");
         
     }
 if(Validator.isNotNull(request.getParameter("failedRecords"))){
     failedRecords = (String) request.getParameter("failedRecords");
         
     }
 if(Validator.isNotNull(request.getParameter("heading"))){
	 heading = JSONFactoryUtil.createJSONObject( request.getParameter("heading"));
         
     }
 if(Validator.isNotNull(request.getParameter("sequence"))){
	 sequence = (String) request.getParameter("sequence");
         
     }
 if(Validator.isNotNull(request.getParameter("invalidRecords"))){
	 invalidRecords = JSONFactoryUtil.createJSONArray(request.getParameter("invalidRecords"));
         
     }
 
%>
 
  <c:set var="totalRecords" value="${totalRecords}" />
  <c:set var="failedRecords" value="${failedRecords}" />
  <c:set var="successfulRecords" value="${successfulRecords}" />
 
<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/enrolment/batch/upload.jsp" />
</portlet:renderURL>
 
<liferay-portlet:renderURL varImpl="uploadStatURL">
    <portlet:param name="mvcPath" value="/html/enrolment/batch/uploadStat.jsp" />
    <portlet:param name="uploadTransactId" value="<%= uploadTransactId %>" />
</liferay-portlet:renderURL>
<portlet:resourceURL var="exportAsCSV">
    <portlet:param name="exportCSV" value="exportCSV"/>
</portlet:resourceURL>

<script>
var invalidRecords = <%= invalidRecords.toString() %>;
var heading = <%= heading.toString() %>;
</script>
<div class="newPortlets enrolment-body enrolment-center-align">
 
    <div class="subHeader">
        <div class="container">
            <aui:row>
 				<div class="inner-container">
	                <aui:col span="10" cssClass="text-center header-title">
	                    <h2><span>UPLOAD CANDIDATES</span></h2>
	                </aui:col>
	                <aui:col span="2" cssClass="text-righ header-home-link">
	                    <a href="<%=homePage%>" title="Back to Home">Back to Home</a>
	                </aui:col>
	            </div>
            </aui:row>
        </div>
    </div>
 
    <div class="container">
        <div class="tint-Overlay">
            <div class="d-flex flex-column mx-auto w-60">
                <div class="base-wrapper">
                    <div class="">
                       <div class="top-container d-flex justify-content-center">
                        <a href="<%=homePage%>" class="mx-auto base-button">START AGAIN</a>
                    </div>
                    </div>
                    <div class="w-100 bottom-container d-flex flex-column">
                        <button class="upload-btn">Upload Status</button>
                        <div class="d-flex justify-content-around records">
                            <div class="d-flex flex-column">
                                <label class="stat-label">TOTAL RECORDS</label>
                                <label class="total center"><%=totalRecords%></label>
                            </div>
                            <div class="v-line"></div>
                            <div class="d-flex flex-column">
                                <label class="stat-label">SUCCESSFUL RECORDS</label>
                                <label class="successful center"><%=successfulRecords%></label>
                            </div>
                            <div class="v-line"></div>
                            <div class="d-flex flex-column">
                                <label class="stat-label">FAILED RECORDS</label>
                                <label class="failed center"><%=failedRecords%></label>
                            </div>
                            <div class="v-line"></div>
                            <div class="d-flex flex-column">
                                <label class="stat-label">PENDING PROCESSING</label>
                                <label class="total center">0</label>
                            </div>
                        </div>
                    </div>
                </div>
                <% if(invalidRecords.length()>0) { %>
				<h4 class="color-blue error-summary">Error Summary</h4>
				<div style="width: 779px;">
					<table>
						<tr>
							<td>Row No</td>
							<td>Unique Key</td>
							<td>Failed Validation Reason</td>

						</tr>

						<% for(int i=0; i < invalidRecords.length(); i++){ %>
						<tr>
							<td><%= Integer.parseInt(invalidRecords.getJSONObject(i).getString("RowNo"))+1 %></td>
							<td><%= invalidRecords.getJSONObject(i).getString("sprCode") %>
								<br /> <%= invalidRecords.getJSONObject(i).getString("moduleCode") %></td>
							<td><%= invalidRecords.getJSONObject(i).getString("Reason") %></td>
						</tr>

						<% } %>
					</table>
				</div>
				<a href="javascript:void(0)" onclick="downloadCSV('gg')"
					class="btn download-btn btn-primary">DOWNLOAD FILE</a>
				<% } %>
			</div>
        </div>
 
    </div>
 
</div>
<script>
	//document.getElementsByClassName('taglib-search-iterator-page-iterator-bottom')[0].style.display = 'none';
	//document.getElementsByClassName('taglib-search-iterator-page-iterator-top')[0].style.display = 'none';
	var stockData = [ {
		Symbol : "AAPL",
		Company : "Apple Inc.",
		Price : 132.54
	}, {
		Symbol : "INTC",
		Company : "Intel Corporation",
		Price : 33.45
	}, {
		Symbol : "GOOG",
		Company : "Google Inc",
		Price : 554.52
	}, ];
	function convertArrayOfObjectsToCSV(args) {
		var result, ctr, keys, columnDelimiter, lineDelimiter, data;

		data = args.data || null;
		if (data == null || !data.length) {
			return null;
		}

		columnDelimiter = args.columnDelimiter || ',';
		lineDelimiter = args.lineDelimiter || '\n';

		keys = Object.keys(data[0]);

		result = '';
		result += keys.join(columnDelimiter);
		result += lineDelimiter;

		data.forEach(function(item) {
			ctr = 0;
			keys.forEach(function(key) {
				if (ctr > 0)
					result += columnDelimiter;

				result += item[key];
				ctr++;
			});
			result += lineDelimiter;
		});

		return result;
	}

	function downloadCSV(args) {
		var data, filename, link;
		var csv = convertArrayOfObjectsToCSV({
			data : stockData
		});

		csv = heading.entireRecord + "\r\n";
		for (var h = 0; h < invalidRecords.length; h++) {
			csv += invalidRecords[h].entireRecord + "\r\n";
		}

		csv = csv.replace(/#/g, '');

		if (csv == null)
			return;

		filename = args.filename || 'export.csv';

		if (!csv.match(/^data:text\/csv/i)) {
			csv = 'data:text/csv;charset=utf-8,' + csv;
		}
		data = encodeURI(csv);

		link = document.createElement('a');
		link.setAttribute('href', data);
		link.setAttribute('download', filename);
		link.click();
	}
</script>