<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<portlet:renderURL var="summary">
	<portlet:param name="jspPage" value="/html/create/summary.jsp" />
	<portlet:param name="activeClass" value="summary" />
</portlet:renderURL>

<portlet:renderURL var="editInventory">
	<portlet:param name="jspPage" value="/html/create/inventory.jsp" />
	<portlet:param name="activeClass" value="editInventory" />
</portlet:renderURL>

<%
String spProductId1 = (String)renderRequest.getParameter("productId");
boolean showInventory = GetterUtil.getBoolean(portletPreferences.getValue("showInventory", ""));
long tempCourseId1 = 0;
if(spProductId1 != null){
 tempCourseId1 = GetterUtil.getLong(spProductId1);
}
%>

<div class="Left_sidebar_section">
<input type="hidden" value="<%=spProductId1 %>" name="spProductIdValue1" id="spProductIdValue1">
	<ul>
<%-- <c:choose>
	<c:when test="<%= tempCourseId1 > 0 %>">
		<li><a href="#" onClick="productTabslink('<%=summary %>','productSummary');" class="productMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.summary")%></a></li>
	</c:when>	
	<c:otherwise>
		<li id="summaryLink" class="productMenu Display-none"><a href="#" onClick="productTabslink('<%=summary %>','productSummary');"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.summary")%></a></li>
	<li id="summary-wo-link" class="productMenu">Summary</li>
	</c:otherwise>
	</c:choose>  --%>
	<% if ((showInventory) && Validator.isNotNull(showInventory)){ %>
		<li><a href="#" onClick="productTabslink('<%=editInventory %>','productInventory');" class="productMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.inventory")%></a></li>
	<%} %>
	</ul>
</div>

<script>
function productTabslink(linkUrl,action){
	var spProductId = document.getElementById("spProductIdValue1").value;
	 window.location=linkUrl+"&productId="+spProductId+"&action="+action;
}

function setProductActiveClass() {
	var loc = document.URL;
	var courseParam = loc
			.split('_Product_WAR_SPProductportlet_activeCourse=')[1];
	var cMenuId = "";
	if (courseParam) {
		var cMenuId = courseParam.split('&')[0];
	}
	var menuUrl = document.getElementById(cMenuId);
	var menuCourse = document.getElementsByClassName('.productMenu');
	for (var i = menuCourse.length - 1; i >= 0; i--) {
		menuCourse[i].setAttribute("class", "unactive productMenu");
	}
	if (menuUrl) {
		menuUrl.setAttribute("class", "Active-CourseMenu productMenu");
	}
}

setProductActiveClass();
</script>
