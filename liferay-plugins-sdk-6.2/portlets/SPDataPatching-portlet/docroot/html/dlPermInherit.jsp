<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="inheritPermURL" name="inheritParentPermissions">
</portlet:actionURL>

<aui:form name="addPortletPerm" action="<%=inheritPermURL%>" >
			
			<aui:fieldset>
		<!-- 		Note: 
				<b>Permission Operation : SET ##</b>
				<p>This will override childs permissions by direct parent permissions on role basis. Permission overriden happens only for roles having 
					some permission on parent.
					Let's say system has roleA, roleB,roleC and roleD and parent is folderA and child is folderB.
					roleA and roleB have VIEW and UPDATE on folderA
					roleC and roleD doesn't have any permission on folderA
					
					roleA and roleB have DELETE permission on folderB
					roleC and roleD have VIEW permission on folderB
					
					If we apply Permission operation SET , then result is
					roleA and roleB will have VIEW and UPDATE on folderB   ( child's permission will be overriden by parent)
					roleC and roleD will remains have VIEW permission on folderB   (roleC and roleD doesn't have any permissions on parent, hence these will not effected)
				 </p><br>
				<b>Permission Operation : MERGE ##</b>
				<p>This will merge childs permissions with direct parent permissions on role basis. Permission merge happens only for roles having 
					some permission on parent.
					Let's say system has roleA, roleB,roleC and roleD and parent is folderA and child is folderB.
					roleA and roleB have VIEW and UPDATE on folderA
					roleC have UPDATE permission on folderA
					roleD doesn't have any permission on folderA
					
					roleA and roleB have DELETE permission on folderB
					roleC doesn't have any permission on folderb
					roleD have VIEW permission on folderB
					
					If we apply Permission operation MERGE , then result is
					roleA and roleB will have VIEW , UPDATE and DELETE on folderB   ( child's and parents permissions will be merged)
					roleC will have UPDATE permission on folderB   (permission comes from parent - merged)
					roleD will remains have VIEW permission on folderB( roleD permission merged instead overriden. overriden happens in case of SET operation )
				 </p>
				<aui:input name="permissionOperation" type="text" label="Permission Operation ( set or merge)"></aui:input>
				<aui:input name="folderId" type="text" label="Folder Id ( Default is root)"></aui:input> -->
				<aui:button type="Submit" value="Do It !!"></aui:button>
			</aui:fieldset>
</aui:form>
<div>
	${log }
</div>