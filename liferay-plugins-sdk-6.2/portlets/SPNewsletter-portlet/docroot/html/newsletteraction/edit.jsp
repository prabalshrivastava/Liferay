<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<style type="text/css">
.edit {
	padding: 20px;
	display: block;
}
</style>

<%
	String emailOnly = portletPreferences.getValue("emailOnly", StringPool.FALSE);
	String campaignId = portletPreferences.getValue("campaignId", StringPool.BLANK);
%>

<h1>Configurations</h1>

<aui:form action="<%= editActionURL %>" method="post" name="fm"
	onSubmit='<%= "event.preventDefault();" %>'>

	<div class="edit">
		<aui:input name="emailOnly" type="checkbox" inlineLabel="right"
			label="Email Only" inlineField="<%= true %>" value="<%= emailOnly %>" />
	</div>

	<div class="edit">
		<div>Select Campaign</div>
		<div>
			<select id="spMailCampaignId" name="spMailCampaignId">
				<option value=""></option>
				<c:forEach items="${lstMailCampaign}" var="spMailCampaign">
					<option value="${spMailCampaign.spMailCampaignId }"
						<c:if test="${spMailCampaignId == spMailCampaign.spMailCampaignId}">selected="selected"</c:if>>
						<c:out value="${spMailCampaign.campaignName}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<aui:button name="saveButton"
		onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>'
		type="submit" value="Save" />

</aui:form>

<aui:script>

	Liferay.provide(
		window,
		'<portlet:namespace />saveConfigurations',
		function() {
			var A = AUI();

			submitForm(document.<portlet:namespace />fm);
		}
	);

</aui:script>