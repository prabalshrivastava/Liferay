<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetEntry" %>
<%@ page import="com.liferay.portlet.blogs.model.BlogsEntry" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	PortletPreferences prefs = renderRequest.getPreferences();
%>

<%
List<AssetEntry> topAssetEntrys = (List<AssetEntry>)request.getAttribute("topTagsAssets");
%>

<%
String layoutURL = PortalUtil.getLayoutURL(themeDisplay);
String redirect = layoutURL;
%>

<%
String current_url = PortalUtil.getCurrentURL(request);
String renderURL = renderResponse.createRenderURL().toString();
String preURL = "";

String str = "";
if (renderURL.indexOf("?") != -1) {
	int i = renderURL.indexOf("?");
	preURL = renderURL.substring(0,i);
}else {
	preURL = current_url;
}
%>

<div>
<p><span class="mostPopularBlog-title">Most Popular Posts</span></p>

	<%
	for (AssetEntry assetEntry : topAssetEntrys) {
		BlogsEntry be = BlogsEntryLocalServiceUtil.getBlogsEntry(assetEntry.getClassPK());
		//String viewBlogsContentUrl = PortalUtil.getPortalURL(request) + layoutURL + "/-/blogs/" + be.getUrlTitle() + "?_33_redirect=" + redirect;

		String viewBlogsContentUrl = preURL + "/-/blogs/" + be.getUrlTitle() + "?_33_redirect=" + redirect;
	%>

	<%

		// if (BlogsEntryPermission.contains(themeDisplay.getPermissionChecker(), be, ActionKeys.VIEW)) {
	%>

		<p><a href="<%= viewBlogsContentUrl %>"><%= be.getTitle() %></a><span>(<%= assetEntry.getViewCount() %>)</span></p>

	<%

		// }
	}
	%>

</div>