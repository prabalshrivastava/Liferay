<%--

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

--%>

<%@page import="com.sambaash.platform.srv.spgroup.NoSuchPrefException"%>
<%@page import="com.sambaash.platform.srv.spgroup.model.SPGroupPref"%>
<%@page import="com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalServiceUtil"%>
<%
SPGroupPref spGroupPref = null;
try{
	spGroupPref = SPGroupPrefLocalServiceUtil.getSPGroupPref(spGroup.getSpGroupId());
}catch(NoSuchPrefException nspe) {

}
boolean dIn = false;
boolean dGoogle = false;
boolean dFb = false;
boolean dTw = false;

boolean cIn = false;
boolean cGoogle = false;
boolean cFb = false;
boolean cTw = false;

boolean enableSubscribeToComments = false;
boolean enableGroupUpdateNotification = false;
boolean enableMemberUpdate = false;
boolean enableDiscussionUpdate = false;

String updateFrequency = "";

if (spGroupPref != null) {
	dIn = spGroupPref.getDIn();
	dGoogle = spGroupPref.getDGoogle();
	dFb = spGroupPref.getDFb();
	dTw = spGroupPref.getDTw();

	cIn = spGroupPref.getCIn();
	cGoogle = spGroupPref.getCGoogle();
	cFb = spGroupPref.getCFb();
	cTw = spGroupPref.getCTw();

	enableSubscribeToComments = spGroupPref.getEnableSubscribeToComments();
	enableGroupUpdateNotification = spGroupPref.getEnableGroupUpdateNotification();
	enableMemberUpdate = spGroupPref.getEnableMemberUpdate();
	enableDiscussionUpdate = spGroupPref.getEnableDiscussionUpdate();

	updateFrequency = spGroupPref.getUpdateFrequency();

}
%>

<c:if test="${isAdmin || isOwner}">

	<h2 class="sp-group-mbl" style="margin:0 12px"><liferay-ui:message key="label.settings" /></h2>

	<portlet:actionURL var="editSettingsURL">
		<portlet:param name="action" value="editSettings"></portlet:param>
	</portlet:actionURL>

	<aui:form action="<%=editSettingsURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>' style="margin:0 12px">
		<aui:input name="spGroupId" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
		<aui:input name="urlTitle" type="hidden" value="<%= spGroup.getUrlTitle() %>" />
		<div class="">
			<div class="sp-group-hr">
				<label class=""><liferay-ui:message key="label.post.discussion" /> :</label>
				<div class="">
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Linkedin" name="dIn" type="checkbox" value="<%=dIn %>" />
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Google" name="dGoogle" type="checkbox" value="<%=dGoogle %>" />
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Facebook" name="dFb" type="checkbox" value="<%=dFb %>" />
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Twitter" name="dTw" type="checkbox" value="<%=dTw %>" />
				</div>
			</div>
			<div class="sp-group-hr">
				<label class="sp-group-mbs"><liferay-ui:message key="label.post.comment" /> :</label>
				<div class="">
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Linkedin" name="cIn" type="checkbox" value="<%=cIn %>" />
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Google" name="cGoogle" type="checkbox" value="<%=cGoogle %>" />
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Facebook" name="cFb" type="checkbox" value="<%=cFb %>" />
					<aui:input inlineField="<%= true %>" inlineLabel="right" label="Twitter" name="cTw" type="checkbox" value="<%=cTw %>" />
				</div>
			</div>
			<div class="sp-group-hr">
				<aui:input inlineLabel="right" label="Enable subscribe to discussions" name="enableSubscribeToComments" type="checkbox" value="<%= enableSubscribeToComments %>" />
			</div>
			<div class="sp-group-hr">
				<aui:input inlineLabel="right" label="Enable group update notification" name="enableGroupUpdateNotification" type="checkbox" value="<%= enableGroupUpdateNotification %>" />
				<aui:select inlineLabel="left" label="Update frequency" name="updateFrequency">
					<aui:option selected='<%= updateFrequency.equals("daily") %>' value="daily"><liferay-ui:message key="label.daily" /></aui:option>
					<aui:option selected='<%= updateFrequency.equals("weekly") %>' value="weekly"><liferay-ui:message key="label.weekly" /></aui:option>
					<aui:option selected='<%= updateFrequency.equals("monthly") %>' value="monthly"><liferay-ui:message key="label.monthly" /></aui:option>
				</aui:select>
			</div>
		</div>
		<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveChangess();" %>' type="submit" value='<%= LanguageUtil.get(pageContext,"label.save.changes") %>' />
	</aui:form>

	<aui:script>

		Liferay.provide(
			window,
			'<portlet:namespace />saveChangess',
			function() {
				var A = AUI();

				submitForm(document.<portlet:namespace />fm);
			}
		);

	</aui:script>

</c:if>