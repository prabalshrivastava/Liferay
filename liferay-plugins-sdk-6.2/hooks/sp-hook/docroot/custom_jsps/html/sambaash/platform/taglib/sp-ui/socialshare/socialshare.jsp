<%@ include file="/html/taglib/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sambaash.platform.util.SocialNetworkUtils"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
  User loggedInuser = themeDisplay.getUser();
 String url  = (String)request.getAttribute("sp-ui:socialshare:url");
 if(Validator.isNull(url)){
	url = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(); 
 }
 String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-ui:socialshare:cssClass"), "social-share margin-top-half text-center");
 String title  = GetterUtil.getString((String)request.getAttribute("sp-ui:socialshare:title")) ;
 String desc  = GetterUtil.getString((String)request.getAttribute("sp-ui:socialshare:description"));
 String type  = GetterUtil.getString((String)request.getAttribute("sp-ui:socialshare:type"));
 String prefix  = GetterUtil.getString((String)request.getAttribute("sp-ui:socialshare:prefix"));
 namespace = namespace + prefix;
 boolean setmetadata  = GetterUtil.getBoolean(request.getAttribute("sp-ui:socialshare:metadata") + "");
 long fileEntryId  = GetterUtil.getLong(request.getAttribute("sp-ui:socialshare:fileEntryId") + "");
 
 if(setmetadata){
	 SocialNetworkUtils.addSocialShareAttributes(renderRequest,
				title, desc, url, type,
				SocialNetworkUtils.TWITTER_TYPE_SUMMARY_LARGE_IMAGE,
				fileEntryId);
 }
 
 
 
%>

<div class="<%=cssClass%>">
			<a id="<%=namespace %>fbShare"
			   href="<%=SocialNetworkUtils.generateFacebookShareUrl(url)%>"
			   data-url-prefix="<%= SocialNetworkUtils.getFBShareUrlPrefix() %>" 
			   target = "_blank"  >
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/fb.png" alt="Share on Facebook" title="Share on Facebook" />
			</a>
			<a  id="<%=namespace %>twitterShare"
				href="<%=SocialNetworkUtils.generateTwitterShareUrl(url)%>"
				data-url-prefix="<%= SocialNetworkUtils.getTwitterShareUrlPrefix() %>" 
				target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/twitter.png" alt="Tweet" title="Tweet" />
			</a>
			<a id="<%=namespace %>googleShare"
			   href="<%=SocialNetworkUtils.generateGooglePlusShareUrl(url)%>"
			   data-url-prefix="<%= SocialNetworkUtils.getGooglePlusShareUrlPrefix() %>" 
			   target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/gplus.png" alt="Share on Google+" title="Share on Google+" />
			</a>
			<%-- <a  id="<%=namespace %>linkedInShare"
				href="<%=SocialNetworkUtils.generateLinkedInShareUrl(url)%>"
				data-url-prefix="<%= SocialNetworkUtils.getLinkedInShareUrlPrefix() %>" 
				target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/linkedin.png" alt="Post on Linkedin" title="Post on Linkedin" />
			</a>  --%>
</div>
<script>
AUI().use('aui-node','aui-base',function(A){
	var pns = "<%= namespace %>";
	Liferay[pns + "fbShare"] = A.one("#" + pns + "fbShare");
	Liferay[pns + "twitterShare"] = A.one("#" + pns + "twitterShare");
	Liferay[pns + "googleShare"] = A.one("#" + pns + "googleShare");
	Liferay[pns + "linkedInShare"] = A.one("#" + pns + "linkedInShare");
});
</script>