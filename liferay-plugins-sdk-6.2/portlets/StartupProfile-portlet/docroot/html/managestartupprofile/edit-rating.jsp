<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.portlet.WindowState"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:renderURL portletMode="view" var="viewURL" />
<liferay-theme:defineObjects />

<aui:select name="prefComponentId"  label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.rating.component.type")%>' showEmptyOption="true">
		<c:forEach var="rcomp" items="${ratingComponents}">
			<aui:option value="${rcomp.spRatingComponentId }" label="${rcomp.name }" selected="${rcomp.spRatingComponentId == componentId }"></aui:option>
		</c:forEach>
</aui:select>

<div class="new-comp-message"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"use-sprating-to-create-new-rating")%>' /></div>