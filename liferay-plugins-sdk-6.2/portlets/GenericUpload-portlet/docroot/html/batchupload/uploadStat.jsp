<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/batchupload.css?<%=System.currentTimeMillis()%>'>



<%

String responsee = request.getParameter("responsee");
JSONObject data = JSONFactoryUtil.createJSONObject(responsee);

String uploadTransactId = StringPool.BLANK;
String totalRecords = StringPool.BLANK;
String successfulRecords = StringPool.BLANK;
String failedRecords = StringPool.BLANK;
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
 if(Validator.isNotNull(request.getParameter("invalidRecords"))){
	 invalidRecords = JSONFactoryUtil.createJSONArray(request.getParameter("invalidRecords"));
	 	
	 }
%>

  <c:set var="totalRecords" value="${totalRecords}" />
  <c:set var="failedRecords" value="${failedRecords}" />
  <c:set var="successfulRecords" value="${successfulRecords}" />

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/batchupload/upload.jsp" />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="uploadStatURL">
    <portlet:param name="mvcPath" value="/html/batchupload/uploadStat.jsp" />
    <portlet:param name="uploadTransactId" value="<%= uploadTransactId %>" />
</liferay-portlet:renderURL>

<div class="newPortlets enrolment-body enrolment-center-align">

    <div class="subHeader">
        <div class="container">
        	<div class="inner-container">
	            <aui:row>
	
	                <aui:col span="10" cssClass="text-center header-title">
	                    <h2><span>BATCH UPLOADER</span></h2>
	                </aui:col>
	                <aui:col span="2" cssClass="text-righ header-home-link">
	                    <aui:a href="<%=homePage%>" title="Back to Home">Back to Home</aui:a>
	                </aui:col>
	            </aui:row>
	          </div>
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
               <h4 class="color-blue error-summary">Error Summary</h4>
                <div>
                
                <table>
                <thead>
                <tr><td>Row</td><td>Unique key</td><td>Failed Validation Reason</td></tr>
                </thead>
                
                <tbody>
                <%  for(int i = 0; i < invalidRecords.length(); i++){ %>
                
                <tr>
                	<td> <%= invalidRecords.getJSONObject(i).getString("RowNo") %></td>
                	<td>ddd</td>
                	<td> <%= invalidRecords.getJSONObject(i).getString("Reason") %></td> 
                </tr>
                
                
                <% } %>
                </tbody>
                
                
                </table>
                
                
                 
                   
                </div>
                <button class="btn download-btn btn-primary">DOWNLOAD FILE</button>
            </div>
        </div>

    </div>

</div>
<script>
document.getElementsByClassName('taglib-search-iterator-page-iterator-bottom')[0].style.display = 'none';
document.getElementsByClassName('taglib-search-iterator-page-iterator-top')[0].style.display = 'none';
var responsee = '<%= responsee %>';
</script>