<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>

<portlet:defineObjects />
<liferay-theme:defineObjects /> --%>
<%@ page import="java.util.List" %>

<%
List finalRoleList= (List) request.getAttribute("finalRoleList");
%>

<div class="role-category-map" id="role-category-map">
	<c:if test="${selectedCategoryName != '0' && selectedCategoryMappedToName != 0}">
		<input id="mapView" type="button" value="Add Role / ${selectedCategoryName} / ${selectedCategoryMappedToName} Mapping" Onclick="javascript:toggleView('roleMap')" style="margin:40px 30px 20px;float:right;">
	</c:if>
	<c:if test="${selectedCategoryName != '0' && selectedCategoryMappedToName == 0}">
		<input id="mapView" type="button" value="Add Role / ${selectedCategoryName} Mapping" Onclick="javascript:toggleView('roleMap')" style="margin:40px 30px 20px;float:right;">
	</c:if>
		<table class="role-category-map-table" id="role-category-map-table" style="width: 98%;">
			<c:if test="${empty finalRoleList}">
				<c:if test="${selectedCategoryName != '0' }">
				<tr>
					<b>No Records Found</b>
				</tr>
				</c:if>
				<c:if test="${selectedCategoryName == '0' }">
				<tr>
					<b>Please set values in Preferences.</b>
				</tr>
				</c:if>
			</c:if>
			<c:if test="${!empty finalRoleList}">
				<tr>
					<td class="mailtemplate-list-title">
						<b>User Role</b>
					</td>
					<td class="mailtemplate-list-title">
						<b>${selectedCategoryName}</b>
					</td>
					<c:if test="${!empty assetCategory1}">
					<td class="mailtemplate-list-title">
						<b>${selectedCategoryMappedToName}</b>
					</td>
					</c:if>
					<td class="mailtemplate-list-title">
						<b>Edit</b>
					</td>
				</tr>
				<%int k = 0; %>
				<c:forEach items="${finalRoleList}" var="finalRoleList">
					<tr>
						<td class="template-list" style="padding: 10px">
							<%List selRoleList = (List) finalRoleList.get(k); %>
							<% k= k+1;
							int j = 0; %>
							<input id="selMappingRole_<%= k %>" type="hidden" value="<%= selRoleList.get(j) %>">
							<% j= j+1; %>
							<%= selRoleList.get(j) %>
							<% j= j+1; %>
						</td>
						<td class="template-list" style="padding: 10px">
							<input id="selMappingCatg1_<%= k %>" type="hidden" value="<%= selRoleList.get(j) %>">
							<% j= j+1; %>
							<%= selRoleList.get(j) %>
							<% j= j+1; %>
						</td>
						<c:if test="${!empty assetCategory1}">
						<td class="template-list" style="padding: 10px">
							<input id="selMappingCatg2_<%= k %>" type="hidden" value="<%= selRoleList.get(j) %>">
							<% j= j+1; %>
							<%= selRoleList.get(j) %>
							<% j= j+1; %>
						</td>
						</c:if>
						<td class="template-list" style="padding: 10px">
							<a href="javascript:editInfo('<%= k %>')">Edit</a>
							<!-- / <a href="javascript:deleteInfo('<%= k %>','deleteInfo','selMappingRole_','selMappingCatg1_','selMappingCatg2_')">Delete</a> -->
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>