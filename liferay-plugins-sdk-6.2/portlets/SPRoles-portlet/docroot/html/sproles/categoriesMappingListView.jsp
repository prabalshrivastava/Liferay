<%@ page import="java.util.List" %>

<%
List finalSelCatgMapList= (List) request.getAttribute("finalSelCatgMapList");
%>

<div class="role-category-map" id="role-category-map">
	<c:if test="${selectedMainCategoryName != '0' }">
		<input id="catgMapView" type="button" value="Add ${selectedMainCategoryName} / ${selectedSubCategoryName} Mapping" Onclick="javascript:toggleView('catgMap')" style="margin:40px 30px 20px;float:right;">
	</c:if>
		<table class="category-map-table" id="category-map-table" style="width: 98%;">
			<c:if test="${empty finalSelCatgMapList}">
				<c:if test="${selectedMainCategoryName != '0' }">
				<tr>
					No Records Found
				</tr>
				</c:if>
				<c:if test="${selectedMainCategoryName == '0' }">
				<tr>
					Please set values in Preferences.
				</tr>
				</c:if>
			</c:if>
			<c:if test="${!empty finalSelCatgMapList}">
				<tr>
					<td class="mailtemplate-list-title">
						<b>${selectedMainCategoryName}</b>
					</td>
					<c:if test="${selectedSubCategoryName != 0}">
					<td class="mailtemplate-list-title">
						<b>${selectedSubCategoryName}</b>
					</td>
					</c:if>
					<td class="mailtemplate-list-title">
						<b>Edit</b>
					</td>
				</tr>
				<%int k = 0; %>
				<c:forEach items="${finalSelCatgMapList}" var="finalSelCatgMapList">
					<tr>
						<td class="template-list" style="padding: 10px">
							<%List selRoleList = (List) finalSelCatgMapList.get(k); %>
							<% k= k+1;
							int j = 0; %>
							<input id="selCatgMappingMain_<%= k %>" type="hidden" value="<%= selRoleList.get(j) %>">
							<% j= j+1; %>
							<%= selRoleList.get(j) %>
							<% j= j+1; %>
						</td>
						<td class="template-list" style="padding: 10px">
							<input id="selCatgMappingSub_<%= k %>" type="hidden" value="<%= selRoleList.get(j) %>">
							<% j= j+1; %>
							<%= selRoleList.get(j) %>
							<% j= j+1; %>
						</td>
						<td class="template-list" style="padding: 10px">
							<a href="javascript:editCategoryInfo('<%= k %>')">Edit</a>
							<!-- / <a href="javascript:deleteInfo('<%= k %>','deleteCatgInfo','','selCatgMappingMain_','selCatgMappingSub_')">Delete</a> -->
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>