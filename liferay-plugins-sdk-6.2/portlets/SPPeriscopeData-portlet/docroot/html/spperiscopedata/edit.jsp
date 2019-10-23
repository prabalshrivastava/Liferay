<%@page import="com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<aui:row cssClass="ps-pref-container">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
			<aui:fieldset>			
				<aui:input name="<%=SPPeriscopeDataConstant.API_KEY %>" label="label.api.key" value="${api_key}"></aui:input>
				<aui:input name="<%=SPPeriscopeDataConstant.EMBED_VERSION %>" label="label.embed.version" value="${embed_version}"></aui:input>
<%-- 				<aui:input name="<%=SPPeriscopeDataConstant.DASHBOARD_ID %>" label="label.dashboard.id" value="${dashboard_id}"></aui:input> --%>
<%-- 				<aui:input name="<%=SPPeriscopeDataConstant.VISIBLE_FILTER_LIST %>" label="label.visible.filters" value="${visible_filter_list}"></aui:input> --%>
			</aui:fieldset>
				
			<aui:input name="<%=SPPeriscopeDataConstant.NAV_CONFIG%>"
			label="label.nav.config" type="textarea" rows="20"
			required="true" value="${nav_config}" style="width:65%;" />
			
			<div>
				Note : Parameters to be added for Scheduling Finance Report,<br/>
					date:"21/03/2018",<br/>
					mailFrequency:"daily",<br/>
					email:"XXX@sambaash.com",<br/>
					bccEmail:"YYY@sambaash.com"<br/>
				Mail Frequency can be one of the following - daily,weekly,monthly,yearly.
				The next mail for the current parameter will be received on - 	${convertedDate} 11.55PM
				
			</div>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>