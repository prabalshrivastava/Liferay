<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.model.Group" %>

<%@ page import="java.util.List" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
List<Group> lstGroup = null;
long groupId = -1;
if (request.getAttribute("resultGroup")!=null) {
	lstGroup = (List<Group>) request.getAttribute("resultGroup");
}
if (request.getAttribute("groupId")!=null) {
	if (!("".equals(request.getAttribute("groupId").toString().trim()))) {
		groupId = Long.parseLong(request.getAttribute("groupId").toString());
	}

}
%>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<form action="<%= editActionURL %>" method="post">
<div style="padding:10px;border:1px solid #666666;width:96%;">
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Minimum width</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />minWidth" id="minWidth" value="${minWidth}"/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Create Event PageName</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />createPage" id="createPage" value="${createPage}"/></div>
	</div>
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<input type="checkbox" name="<portlet:namespace />responsive" <c:if test="${responsive == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" style="margin-rigth:10px;"/><span style="padding-left:10px;">Responsive</span>
	</div>	
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<input type="checkbox" name="<portlet:namespace />liferaydetail" <c:if test="${liferaydetail == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">Detail Page From Liferay</span>
	</div>
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;">Page Name</div>
		<div style="width:80%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />pageName" id="pageName" value="${pageName}"/></div>
	</div>
		<div style="width:100%;padding:10px;" id="eventDiv">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Community Name</div>
		<div style="width:80%;display:inline;">
			<select id="groupId" name="<portlet:namespace />groupId">
			
			<c:forEach var="group" items="${resultGroup}">
				<option selected="true" value="${group.groupId}" <c:if test="${groupId == group.groupId}">selected="selected"</c:if> ><c:out value='${group.name }'/></option>
			</c:forEach>
			</select>
		</div>
	</div>

	<input type="submit" value="Save Changes" />

</div>

</form>
