<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.model.Theme" %>
<%@ page import="com.liferay.portal.service.ThemeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import= "com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@ page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>

<%@ include file="/html/common/init-ext.jsp" %>
<style>
.gecko .lfr-input-time, .ie .lfr-input-time{
	float:right;
	margin-top: 2px;
}
.cke_skin_kama a.cke_dialog_ui_button{
		display:none !important;
}
</style>

<portlet:defineObjects />

<liferay-theme:defineObjects />
<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.upload-invitersvp.jsp";
%>

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm aa");

DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

String editorCnt = "";
%>

<body>
<div class="rsvpbox-title" style="width: 100%;">
		Upload Invite List & Schedule
	</div>
<div class="rsvp-preference-border" style="min-height:300px;">
	<div id="rsvpDiv" style="width:100%;padding:10px;">

		<portlet:actionURL var="vieweventURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="action" value="uploadFiles" />

</portlet:actionURL>
<c:if test="${!empty errorRow}">
	<div style="background:#f2f2f2;color:red;font-weight:bold;margin-top:10px;padding:10px;height:18px;width:97%;">
		Error occur at row number <c:out value="${errorRow}" />
	</div>
</c:if>
<c:if test="${isAdmin}">
<form action="<%= vieweventURL %>" enctype="multipart/form-data" id="fm1" method="POST" name="UploadForm" name="fm1">
	<div style="width:100%;clear:both;">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> Select Existing RSVP Title</div>
		<div style="width:70%;display:inline;">
				<select id="rsvpId" name="<portlet:namespace />rsvpId" onchange="fetchRsvp(this);">
				<option value=""></option>
				<c:forEach items="${lstRsvp}" var="rsvp">
					<option value="${rsvp.rsvpId }" <c:if test="${changeRsvp == rsvp.rsvpId}">selected="selected"</c:if>><c:out value='${rsvp.title }'/></option>
				</c:forEach>
				</select>
		</div>
	</div>
	<c:if test="${!empty changeRsvp}">
	<div style="width:100%;clear:both;margin-top:15px;">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> Select Existing Campaign</div>
		<div style="width:70%;display:inline;">
				<select id="campaignId" name="<portlet:namespace />campaignId" onchange="fetchCampaign(this);">	
				<option value=""></option>
				<c:forEach var="spMailCampaign" items="${lstSpMailCampaign}">
					<option value="${spMailCampaign.spMailCampaignId}" <c:if test="${spMailCampaignId == spMailCampaign.spMailCampaignId}">selected="selected"</c:if>><c:out value='${spMailCampaign.campaignName }'/></option>
				</c:forEach>
				</select>
		</div>
	</div>
	</c:if>
	<c:if test="${empty spMailCampaignId}">
		<div id="uploadDiv" style="width:99%;display:none;">
	</c:if>
	<c:if test="${!empty spMailCampaignId}">
		<div id="uploadDiv" style="width:99%;">
	</c:if>

	<c:if test="${templateEditFlag == 1}">
		<div style="color: #FF0000;font-weight: bold;height: 200px;letter-spacing: 1px;line-height: 200px;margin: 0 auto 0 20%;padding: 10px 10px 10px 0;width: 97%;">
			Previous Schedule Rsvp Invitation is under processing. Please try again later.
		</div>
	</c:if>
	<c:if test="${templateEditFlag == 0 }">
		<div class="description-title" style="margin-top:10px;">
			    <span> Invite Friends</span>
			    <span style="font-size:11px;font-weight:bold;float:right;">Please upload excel file to invite event.</span>
		</div>

		<div class="event-invite-pannel">
		    	<div style="display: inline-block;margin-top: 16px;width: 84%;margin-left:10px;">
					<input style="float:left;" name="<portlet:namespace />filesToUpload" id="filesToUpload" type="file" onchange="uploadExcel();"/>
				</div>

				<table style="width:97%;margin:10px;border:1px solid #ccc;">
				<tr>
				<td style="font-size:14px;font-weight:bold;padding-left:10px;"><span>First Name</span></td>
				<td style="font-size:14px;font-weight:bold;padding-left:10px;"><span>Last Name</span></td>
				<td style="font-size:14px;font-weight:bold;padding-left:10px;"><span>E-mail</span></td>
				</tr>
				<% //if (lstRsvpDetail != null) {
					//for (RsvpDetail rsvpDetail : lstRsvpDetail) {
				%>

				<c:forEach items="${lstRsvpDetail}" var="rsvpDetail">
				<tr>
					<td style="border:1px solid #ccc;padding:10px;"><c:out value='${rsvpDetail.firstName}'/></td>
					<td style="border:1px solid #ccc;padding:10px;"><c:out value='${rsvpDetail.lastName}'/></td>
					<td style="border:1px solid #ccc;padding:10px;"><c:out value='${rsvpDetail.emailAddress}'/></td>
				</tr>
				</c:forEach>

				</table>
		</div>
		</c:if>
	</div><!-- end uploadDiv -->
</form>
<portlet:actionURL var="editTemplate">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="action" value="editTemplate" />
</portlet:actionURL>

<c:if test="${templateEditFlag == 0}">
	<c:if test="${!empty scheduleTime}">
	<div id="successMsgTemplate" style="background:#f2f2f2;color:green;font-weight:bold;margin-top:10px;padding:10px;height:18px;width:97%;">

	<span style="float:left;">
	<c:choose>
		<c:when test="${!empty templateName}">
			<c:out value="${templateName}"></c:out> template is successfully created with the schedule [ <c:out value="${scheduleTime}"></c:out>]
		</c:when>
		<c:otherwise>
			<c:if test="${!empty mailTemplateId}">
			<c:out value="${templateTitle}"></c:out> template has been scheduled on [
			<c:out value="${schedularRSVP}"></c:out> ]. </c:if>
		</c:otherwise>
	</c:choose>
	</span>
	<span style="float:right;">
		<c:if test="${!empty changeRsvp}">
		<input id="rsvpId" name="rsvpId" type="hidden" value="${changeRsvp}" />
		</c:if>
		<c:if test="${empty changeRsvp}">
		<c:if test="${!empty rsvpId}">
		<input id="rsvpId" name="rsvpId" type="hidden" value="${rsvpId}" />
		</c:if>
		</c:if>
		<a onclick="editSchedule()">Edit Schedule</a>

	</span>

	</div>
	</c:if>

</c:if>

</c:if>
</div>
</div>
<portlet:actionURL var="changeURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="action" value="changeRSVP" />

</portlet:actionURL>
<form action="<%= changeURL %>" class="uni-form" method="post" name="fm2" id="fm2">
 <input type="hidden" name="<portlet:namespace />changeRsvp" id="changeRsvp" value="${changeRsvp}"/>
</form>

<portlet:actionURL var="changeCampaign">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="action" value="changeCampaign" />

</portlet:actionURL>

<form action="<%= changeCampaign %>" class="uni-form" method="post" name="fm3" id="fm3">
<input type="hidden" name="<portlet:namespace />changeRsvp1" id="changeRsvp1" value="${changeRsvp}"/>
<input type="hidden" name="<portlet:namespace />changeCampaignId" id="changeCampaignId" value="${spMailCampaignId}"/>
</form>
</body>

<script src="https://maps.google.com/maps/api/js?sensor=false" type="text/javascript"></script>
<script type="text/javascript">

function <portlet:namespace />initEditor() {
	var tmp =" <%= UnicodeFormatter.toString(editorCnt) %> ";
	    return tmp;
}

function selectSchedule(item) {

	if (item.selectedIndex > 0) {
		document.getElementById("scheduleDiv").style.display="inline-block";
	}else {
		document.getElementById("scheduleDiv").style.display="none";
	}
}

function selectByDate(cb) {
	document.getElementById("#<portlet:namespace />startDatePicker").style.display = "inline-block";
}

function uploadExcel() {
	document.getElementById("fm1").submit();
}

function fetchRsvp(item) {
	if (item.selectedIndex > 0) {
		//document.getElementById("uploadDiv").style.display = "block";
	}
	//var selectedRsvp = document.getElementById("uploadDiv").selectedIndex.value;
	//alert(selectedRsvp);
	var e = document.getElementById("rsvpId");
	var filter= e.options[e.selectedIndex].value;
	document.getElementById("changeRsvp").value=filter;
	document.getElementById("fm2").submit();

}

function fetchCampaign(item) {
	if (item.selectedIndex > 0) {
		//document.getElementById("uploadDiv").style.display = "block";
	}
	//var selectedRsvp = document.getElementById("uploadDiv").selectedIndex.value;
	//alert(selectedRsvp);
	var e = document.getElementById("campaignId");
	var filter= e.options[e.selectedIndex].value;
	document.getElementById("changeCampaignId").value=filter;
	document.getElementById("fm3").submit();

}

function editSchedule() {
	//document.getElementById("editTemplate").submit();
	document.getElementById("templateDiv").style.display="block";
}

</script>
<aui:script>
 
     AUI().use('aui-datepicker-deprecated', function(A) {

	   var simpleDatepicker1 = new A.DatePicker({

		 trigger: '#<portlet:namespace />startDate',

	   }).render('##<portlet:namespace />startDatePicker');

	});

</aui:script>
</html>
