<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="addPortletPermURL" name="addPortletPermissions">
</portlet:actionURL>

<aui:form name="addPortletPerm" action="<%=addPortletPermURL%>" >
			
			<aui:fieldset>
				<aui:input name="feedToVocId" type="text" label="Feed To Voc Id"></aui:input>
				<aui:input name="portletId" type="text" label="Portlet Id"></aui:input>
				<aui:input name="actionKey" type="text" label="Action Key"></aui:input>
				<aui:input name="countryDeptUser" type="checkbox" label="Assign Permissions to Country-Dept-User role"></aui:input>
				<aui:input name="countryDeptAdmin" type="checkbox" label="Assign Permissions to Country-Dept-Admin role"></aui:input>
				<aui:input name="countryDeptDocControl" type="checkbox" label="Assign Permissions to Country-Dept-Doc_Control role"></aui:input>
				<aui:button type="Submit" value="Do It !!"></aui:button>
				Note: Just to fetch the data like action keys, or feed to categories don't select the any checkbox and click do it.
			</aui:fieldset>
</aui:form>
<div>
	${log }
</div>