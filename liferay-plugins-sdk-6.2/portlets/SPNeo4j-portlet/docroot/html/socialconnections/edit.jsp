<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<%
String groupDetailPageName = portletPreferences.getValue("groupDetailPageName", "group-detail");
String blogPageName = portletPreferences.getValue("blogPageName", "spblogs");
String showAboutTab = portletPreferences.getValue("showAboutTab", "false");
String showFollowersTab = portletPreferences.getValue("showFollowersTab", "false");
String showActivitiesTab = portletPreferences.getValue("showActivitiesTab", "false");
String showFollowingsTab = portletPreferences.getValue("showFollowingsTab", "false");
String showLikesTab = portletPreferences.getValue("showLikesTab", "false");
String showPostsTab = portletPreferences.getValue("showPostsTab", "false");
%>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
	<aui:input label="Name of Group Detail Page" name="groupDetailPageName" value="<%= groupDetailPageName %>" />
	<aui:input label="Name of Blog Page" name="blogPageName" value="<%= blogPageName %>" />
	
	<aui:layout>
		<aui:column>
			Show "About" Tab?
		</aui:column>
		<aui:column>
			<aui:input type="radio" inlineLabel="right"  label="Yes" name="showAboutTab" value="showAboutTab" checked="<%=showAboutTab.equalsIgnoreCase(\"showAboutTab\") %>"/>
		</aui:column>
		<aui:column>
			<aui:input type="radio" label="No" name="showAboutTab" value="false" checked="<%=showAboutTab.equalsIgnoreCase(\"false\") %>"/>
		</aui:column>
	</aui:layout>
	
	<aui:layout>
		<aui:column>
			Show "Likes" Tab?
		</aui:column>
		<aui:column>
			<aui:input type="radio" inlineLabel="right" label="Yes" name="showLikesTab" value="showLikesTab"  checked="<%= showLikesTab.equalsIgnoreCase(\"showLikesTab\") %>"/>
		</aui:column>
		<aui:column>
			<aui:input type="radio" label="No" name="showLikesTab" value="false" checked="<%=showLikesTab.equalsIgnoreCase(\"false\") %>" />
		</aui:column>
	</aui:layout>
	
	<aui:layout>
		<aui:column>
			Show "Posts" Tab?
		</aui:column>
		<aui:column>
			<aui:input type="radio" inlineLabel="right" label="Yes" name="showPostsTab" value="showPostsTab"  checked="<%= showPostsTab.equalsIgnoreCase(\"showPostsTab\") %>"/>
		</aui:column>
		<aui:column>
			<aui:input type="radio" label="No" name="showPostsTab" value="false" checked="<%=showPostsTab.equalsIgnoreCase(\"false\") %>" />
		</aui:column>
	</aui:layout>
	
	<aui:layout>
		<aui:column>
			Show "Activities" Tab?
		</aui:column>
		<aui:column>
			<aui:input type="radio" inlineLabel="right"  label="Yes" name="showActivitiesTab" value="showActivitiesTab"  checked="<%=showActivitiesTab.equalsIgnoreCase(\"showActivitiesTab\") %>" />
		</aui:column>
		<aui:column>
			<aui:input type="radio" label="No" name="showActivitiesTab" value="false"  checked="<%=showActivitiesTab.equalsIgnoreCase(\"false\") %>" />
		</aui:column>
	</aui:layout>
	
	<aui:layout>
		<aui:column>
			Show "Followings" Tab?
		</aui:column>
		<aui:column>
			<aui:input type="radio" inlineLabel="right"  label="Yes" name="showFollowingsTab" value="showFollowingsTab" checked="<%= showFollowingsTab.equalsIgnoreCase(\"showFollowingsTab\") %>" />
		</aui:column>
		<aui:column>
			<aui:input type="radio" label="No" name="showFollowingsTab" value="false" checked="<%=showFollowingsTab.equalsIgnoreCase(\"false\") %>"  />
		</aui:column>
	</aui:layout>
	
	
	<aui:layout>
		<aui:column>
			Show "Followers" Tab?
		</aui:column>
		<aui:column>
			<aui:input type="radio" inlineLabel="right"  label="Yes" name="showFollowersTab" value="showFollowersTab" checked="<%= showFollowersTab.equalsIgnoreCase(\"showFollowersTab\") %>" />
		</aui:column>
		<aui:column>
			<aui:input type="radio" label="No" name="showFollowersTab"  value="false" checked="<%=showFollowersTab.equalsIgnoreCase(\"false\") %>" />
		</aui:column>
	</aui:layout>
	
	
	<br /><br />
	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save Changes" />
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