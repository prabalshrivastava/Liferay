<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<portlet:renderURL var="editCourse">
	<portlet:param name="jspPage" value="/html/create/course.jsp" />
	<portlet:param name="action" value="editCourse"></portlet:param>
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>

<portlet:renderURL var="addBasicCourse">
	<portlet:param name="jspPage" value="/html/create/course.jsp" />
	<portlet:param name="activeCourse" value="courseMenu" />
</portlet:renderURL>

<portlet:renderURL var="addPersona">
	<portlet:param name="jspPage" value="/html/create/persona.jsp" />
	<portlet:param name="activeCourse" value="persona" />
</portlet:renderURL>

<portlet:renderURL var="addLearningDetails">
	<portlet:param name="jspPage" value="/html/create/learning.jsp" />
	<portlet:param name="activeCourse" value="learningDetails" />
</portlet:renderURL>
<portlet:renderURL var="addCareerDetails">
	<portlet:param name="jspPage" value="/html/create/career.jsp" />
	<portlet:param name="activeCourse" value="careerDetails" />
</portlet:renderURL>

<portlet:renderURL var="addGraduationCriteria">
	<portlet:param name="jspPage"
		value="/html/create/graduation_criteria.jsp" />
	<portlet:param name="activeCourse" value="graduationCriteria" />
</portlet:renderURL>

<portlet:renderURL var="addFunding">
	<portlet:param name="jspPage" value="/html/create/funding.jsp" />
	<portlet:param name="activeCourse" value="funding" />
</portlet:renderURL>

<portlet:renderURL var="addMiscFeeDetails">
	<portlet:param name="jspPage" value="/html/create/miscellaneous_fees.jsp" />
	<portlet:param name="activeCourse" value="miscFeeDetails" />
</portlet:renderURL>

<%
String courseId = request.getParameter("spCourseId");
String action = request.getParameter("action");
long tempCourseId = GetterUtil.getLong(request.getParameter("spCourseId"));
%>
<div class="Left_sidebar_section">
	<input type="hidden" name="spCourseId" id="spCourseId"
		value="<%=request.getParameter("spCourseId")%>">
	<ul class="Course-Menu">
	<%-- <c:if test="<%=themeDisplay.isSignedIn() %>">
		<li><a id="basicCourse" href="#"
			onClick="courseTabslink('<%=addBasicCourse%>');" class="courseMenu">Basic
				Course Data</a></li>
	</c:if>		 --%>
	<c:choose>
	<c:when test="<%= tempCourseId > 0 %>">
		<li><a id="persona" href="#"
			onClick="courseTabslink('<%=addPersona%>','editPersona','persona');"
			id="personna" class="courseMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.customerpersona")%></a></li>
		<li><a id="learningDetails" href="#"
			onClick="courseTabslink('<%=addLearningDetails%>','editLearningDetails','learningDetails');"
			class="courseMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.howyoulearn")%></a></li>
		<li><a id="careerDetails" href="#"
			onClick="courseTabslink('<%=addCareerDetails%>','editCareerDetails','careerDetails');"
			class="courseMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.advanceyoucareer")%></a></li>

		<li><a id="graduationCriteria" href="#"
			onClick="courseTabslink('<%=addGraduationCriteria%>','editGraduationCriteria','graduationCriteria');"
			class="courseMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.graduationcriteria")%></a></li>
		<li><a id="funding" href="#"
			onClick="courseTabslink('<%=addFunding%>','editFunding','funding');"
			class="courseMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.feesfunding")%></a></li>
		<li><a id="miscFeeDetails" href="#"
			onClick="courseTabslink('<%=addMiscFeeDetails%>','editMiscFeeDetails','miscFeeDetails');"
			class="courseMenu"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.miscelleneous")%></a></li>
	</c:when>	
	<c:otherwise>
		<li><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.customerpersona")%></li>
		<li><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.howyoulearn")%></li>
		<li><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.advanceyoucareer")%></li>
		<li><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.graduationcriteria")%></li>
		<li><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.feesfunding")%></li>
		<li><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.miscelleneous")%></li>
	</c:otherwise>
	</c:choose> 
	</ul>
</div>

<script>
	function courseTabslink(linkUrl, action, elem) {
		var spCourseId = document.getElementById("spCourseId").value;
		window.location = linkUrl + "&spCourseId=" + spCourseId + "&action="
				+ action;
	}

	function setCourseActiveClass() {
		var loc = document.URL;
		var courseParam = loc
				.split('_Product_WAR_SPProductportlet_activeCourse=')[1];
		var cMenuId = "";
		if (courseParam) {
			var cMenuId = courseParam.split('&')[0];
		}
		var menuUrl = document.getElementById(cMenuId);
		var menuCourse = document.getElementsByClassName('.courseMenu');
		for (var i = menuCourse.length - 1; i >= 0; i--) {
			menuCourse[i].setAttribute("class", "unactive courseMenu");
		}
		if (menuUrl) {
			menuUrl.setAttribute("class", "Active-CourseMenu courseMenu");
		}
	}
</script>

