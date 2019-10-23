<c:if test="<%= roleId1 %>">
	<portlet:renderURL var="renderMemberFormURL">
		<portlet:param name="CMD" value="addNewPackage" />
	</portlet:renderURL>
	<input onClick="location.href='<%= renderMemberFormURL.toString() %>'" style="margin-bottom:5px" type="button" value="Add Membership Package" />
	<c:if test="<%= items.size()!=0 %>">
		<input onClick="return <%= plns %>confirmDel('delmultiple')" style="margin-bottom:5px" type="button" value="Delete Membership Package" />
	</c:if>
</c:if>
<portlet:renderURL var="renderAddonURL">
	<portlet:param name="CMD" value="addonlist" />
</portlet:renderURL>
<input onClick="location.href='<%= renderAddonURL.toString() %>'" style="margin-bottom:5px" type="button" value="View Membership Addons" />