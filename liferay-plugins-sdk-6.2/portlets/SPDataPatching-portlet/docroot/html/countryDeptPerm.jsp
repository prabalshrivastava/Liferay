<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="addCountryDeptPermURL" name="addCountryDeptPermissionsRolesFolders">
</portlet:actionURL>
<<portlet:renderURL>
</portlet:renderURL>

<aui:form name="addCountryDeptPermURL" action="<%=addCountryDeptPermURL%>" >
			
			<aui:fieldset>
				<aui:input name="feedToVocId" type="text" label="Feed To Voc Id"></aui:input>
				<aui:input name="createFolders" type="checkbox" label="Create Folders ( If Country-Dept Folder does not exist)"></aui:input>
				<aui:input name="assignPermission" type="checkbox" label="Assign Default Permissions on Country-Dept folder for roles (Country-Dept-User,Country-Dept-Admin,Country-Dept-Doc_Control)"></aui:input>
				<aui:input name="createRoles" type="checkbox" label="Create Roles if not exists (Country-Dept-User,Country-Dept-Admin,Country-Dept-Doc_Control)"></aui:input>
				<aui:input name="createSpRoles" type="checkbox" label="Create SPRole if not exists. for each role in (Country-Dept-User,Country-Dept-Admin,Country-Dept-Doc_Control)"></aui:input>
				<aui:button type="Submit" value="Do It !!"></aui:button>
			</aui:fieldset>
</aui:form>
<div>
	${log }
</div>