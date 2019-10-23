<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.sambaash.platform.model.RsvpStatus" %>
<%@ page import="com.sambaash.platform.model.RsvpAttendance" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sambaash.platform.model.RsvpAttendanceList" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>
<portlet:actionURL var="searchActionURL">
	<portlet:param name="action" value="<%= Constants.VIEW %>"></portlet:param>
</portlet:actionURL>
<portlet:resourceURL id="exportResource" var="exportResourceURL">
	<portlet:param name="action" value="<%= Constants.EXPORT %>"></portlet:param>
</portlet:resourceURL>
<portlet:renderURL var="viewURL"></portlet:renderURL>

<%
	String pageNameOfCoParticipantsDetail = portletPreferences.getValue("pageNameOfCoParticipantsDetail", "");
	List<RsvpAttendanceList> rsvpwrapperList = null;
	boolean isrsvpDetailList = false;
	if (Validator.isNotNull(renderRequest.getAttribute("rsvpwrapperList"))) {
		rsvpwrapperList = (List<RsvpAttendanceList>) renderRequest.getAttribute("rsvpwrapperList");
		isrsvpDetailList = true;
	}
	long selectedRsvp = (Long) renderRequest.getAttribute("selectedRsvp");
	String rsvpId = "0";
	String attendedName = RsvpAttendance.ATTENDING.getValue();
	String notAttendedName = RsvpAttendance.NOT_ATTENDING.getValue();
%>

<style type="text/css">
#rsvpDetails table,tr,td {
	border: 1px solid black;
}

#rsvpDetails table {
	margin-bottom: 10px;
	width: 150%;
}

#rsvpDetails td {
	text-align: center;
}
</style>



<script type="text/javascript">

<aui:script use="aui-base">
Liferay.provide(window, 'downloadExcel', function() {
	var e = document.getElementById("rsvpIdValues");
	var isSelected = e.options[e.selectedIndex].value;
	var filter = document.getElementById("selectFilterValue");
	var filterType = filter.options[filter.selectedIndex].value;
	var filterValue = document.getElementById("filterValue").value;

	if (isSelected == 0) {
		alert("Please select a RSVP");
	}else {
		var url = "<%= exportResourceURL %>";
		url+= "&rsvpId="+isSelected+"&filterType="+filterType+"&filterValue="+filterValue+"&includeCo=false";
		setTimeout(function(){document.location.href = url},200);
	}
});
Liferay.provide(window, 'downloadExcelIncludeCo', function() {
	var e = document.getElementById("rsvpIdValues");
	var isSelected = e.options[e.selectedIndex].value;
	var filter = document.getElementById("selectFilterValue");
	var filterType = filter.options[filter.selectedIndex].value;
	var filterValue = document.getElementById("filterValue").value;

	if (isSelected == 0) {
		alert("Please select a RSVP");
	}else {
		var url = "<%= exportResourceURL %>";
		url+= "&rsvpId="+isSelected+"&filterType="+filterType+"&filterValue="+filterValue+"&includeCo=true";
		setTimeout(function(){document.location.href = url},200);
	}
});
</aui:script>

function OnSubmitForm()
{
	var e = document.getElementById("rsvpIdValues");
	var isSelected = e.options[e.selectedIndex].value;
	if (isSelected == 0) {
	alert("Please select a RSVP to be saved");
	}else {
		var act = "<%= editActionURL %>";
		document.getElementById("rsvpDetail_<portlet:namespace/>").action= act;
	  	return true;
	}
}

function selectAllCheckBoxes() {
	var mainSel = document.getElementsByName("rsvpSelect");
	if (mainSel[0].checked == true) {
		for (var i=1;i<mainSel.length;i++) {
			mainSel[i].checked = true;
		}
	}else {
		for (var i=1;i<mainSel.length;i++) {
			mainSel[i].checked = false;
		}
	}
}

function selectCheckBoxes() {
	var selElm = document.getElementsByName("rsvpSelect");
	for (var i=1;i<selElm.length;i++) {
		if (selElm[i].checked == false) {
			selElm[0].checked = false;
		}
	}
}

function selectCheckBoxesByEvent(val) {
	var selElm = document.getElementsByName("rsvpSelect");
	for (var i=1;i<selElm.length;i++) {
		if (selElm[i].value==val) {
			selElm[i].checked = true;
		}

	}
}

function searchByfilter() {
	var e = document.getElementById("rsvpIdValues");
	var isSelected = e.options[e.selectedIndex].value;
	if (isSelected == 0) {
		alert("Please select a RSVP");
	}else {
		var searchAct = "<%= searchActionURL %>";
		document.getElementById("rsvpNextValue").value = 50;
		document.getElementById("rsvpSearch_<portlet:namespace/>").action = searchAct;
		return true;
	}
}

function resetForm() {
	document.getElementById("resetForm").submit();
}

function loadMore() {
	nextValue = document.getElementById("rsvpNextValue").value;
	document.getElementById("rsvpNextValue").value = parseInt(nextValue, 10) + parseInt(50, 10);
	var elem = document.getElementsByClassName("loadMore_hide");
	for (c = 1; c <= nextValue; c++) {
		elem[c].className = "loadMore_show";
	}
}
</script>

<c:choose>
	<c:when test="${hasAccess}">
		<div class="rsvp-maindiv">
			<form id="rsvpSearch_<portlet:namespace/>" method="post">
				<div class="rsvpbox-title">RSVP Details / Attendance</div>
				<div class="rsvp-filter-details">

					<div>
						<div class="rsvp-list-label">Select RSVP to see attendee
							list</div>
						<select name="rsvp_Names" id="rsvpIdValues">
							<option value="0"></option>
							<c:forEach items="${rsvpList}" var="rsvpList">
								<c:if test="${selectedRsvp == rsvpList.rsvpId}">
									<option label="" value="${rsvpList.rsvpId}" selected>${rsvpList.title}</option>
								</c:if>
								<c:if test="${selectedRsvp != rsvpList.rsvpId}">
									<option label="" value="${rsvpList.rsvpId}">${rsvpList.title}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div style="display: inline-block; margin-top: 20px; width: 100%;">
						<div class="rsvp-list-label">Filter by</div>
						<div class="rsvp-filter-list" style="display: inline-block;">
							<select name="filterNames" id="selectFilterValue">
								<option value="0"></option>
								<option value="email">Email Address</option>
								<option value="name">Name</option>
							</select>
						</div>
						<div class="rsvp-filter-list" style="display: inline-block;">
							<input type="text" name="filterValue" id="filterValue">
						</div>
					</div>
					<div class="rsvp-filter-button"
						style="margin: 0 auto; text-align: center; padding-top: 20px;">
						<input type="submit" value="Search" onclick="searchByfilter()" class="btn-primary">
						<input type="button" value="Reset"
							onClick="javascript:resetForm()" class="btn-primary" style="margin-top:-5px;"> <input type="hidden"
							value="50" name="nextValue" id="rsvpNextValue">
					</div>
					<div id="download_excel_include_co" style="float:right">
						<liferay-ui:icon url="javascript:downloadExcelIncludeCo()" image="export" />
						<a href="#" id="download_excel_link_include_co"
							onclick="javascript:downloadExcelIncludeCo()">Download Excel (Include Co-participants)</a>
					</div>
					<div id="download_excel" style="float: right; margin-right: 20px;">
						<liferay-ui:icon url="javascript:downloadExcel()" image="export" />
						<a href="#" id="download_excel_link"
							onclick="javascript:downloadExcel()">Download Excel</a>
					</div>
					<br> <br>
				</div>
			</form>
			<c:if test="<%=!isrsvpDetailList %>">
				<div id="rsvpDetailMessage"
					style="text-align: center; border: 1px solid">
					<span class="rsvp-list-label"> No records found. Please
						click here for new registration.</span>
				</div>
			</c:if> 
			<div id="rsvpDetailContents">
				<c:if test="<%=isrsvpDetailList %>">
					<form method="post" id="rsvpDetail_<portlet:namespace/>"
						onsubmit="return OnSubmitForm();">
						<div id="rsvpDetails">
							<table>
								<c:set var="rowCount" value="0" />
								<c:forEach items="${rsvpwrapperList}" var="rowList">
									<c:if test="${rowCount == 0 }">
										<thead>
											<tr style="height: 30px; font-weight: bold;">
												<c:forEach items="${rowList}" var="columnList">
													<c:choose>
														<c:when
															test="${columnList.getLabel() == 'Rsvp Detail ID'}">
															<td class="left-alignment"><input type="checkbox"
																name="rsvpSelect"
																onChange="javascript:selectAllCheckBoxes()"></td>
														</c:when>
														<c:when
															test="${columnList.getLabel() == 'Rsvp Payment ID'}">
														</c:when>
														<c:otherwise>
															<td>${columnList.getLabel()}</td>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</tr>
										</thead>
									</c:if>
									<c:set var="rowCount" value="${rowCount + 1}" />
									<c:if test="${rowCount == 1 }">
										<tbody id="rsvpDetailTable">
									</c:if>
									<tr style="height: 30px;">
										<c:forEach items="${rowList}" var="columnList">
											<c:choose>
												<c:when test="${columnList.getLabel() == 'Rsvp Detail ID'}">
													<td class="left-alignment"><input type="checkbox"
														name="rsvpSelect" value="${columnList.getValue()}"></td>
													<c:set var="rsvpDetailId" value="${columnList.getValue()}" />
												</c:when>
												<c:when test="${columnList.getLabel() == 'Rsvp Payment ID'}">
													<c:set var="rsvpPaymentId" value="${columnList.getValue()}" />
												</c:when>
												<c:when test="${columnList.getLabel() == 'Attended'}">
													<td><select name="rsvpAtt_${rsvpDetailId}">
															<c:if test="${columnList.getValue() == 0 }">
																<option label="${attendedName}" value="0"
																	selected>No</option>
																<option label="${notAttendedName}"
																	value="1">Yes</option>
															</c:if>
															<c:if test="${columnList.getValue() == 1 }">
																<option label="${attendedName}" value="0">No</option>
																<option label="${notAttendedName}"
																	value="1" selected>Yes</option>
															</c:if>
													</select></td>
												</c:when>
												<c:when
													test="${columnList.getLabel() == 'Number of people'}">
													<td><fmt:parseNumber var="numberOfPeople"
															type="number" value="${columnList.getValue()}" />
														${columnList.getValue()} <c:if
															test="${numberOfPeople gt 1}">
															<a
																href="/<%=pageNameOfCoParticipantsDetail %>?dId=${rsvpDetailId}&pId=${rsvpPaymentId}"
																style="margin-left: 5px;"> <liferay-ui:icon
																	image="edit" />
															</a>
														</c:if></td>
												</c:when>
												<c:otherwise>
													<td>${columnList.getValue()}</td>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
						<div style="padding: 5px; height: 40px;text-align:center;">
							<input type="submit" value="Save" class="btn-primary">
						</div>
					</form>
					<!-- <div class="sp-event-loadmorediv view-more-link" id="rsvpNext"
						onClick="javascript:loadMore()">
						<b>Load More</b>
					</div> -->
				</c:if>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div>You don't have required role to access this page</div>
	</c:otherwise>
</c:choose>
<form method="post" id="resetForm" action="<%=viewURL%>"></form>
