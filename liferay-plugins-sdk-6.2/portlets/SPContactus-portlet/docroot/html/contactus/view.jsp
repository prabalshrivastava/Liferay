<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@page import="com.liferay.portal.kernel.util.StringPool" %>

<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="com.liferay.portal.UserEmailAddressException" %>
<%@ page import="com.sambaash.platform.portlet.contactus.exception.ContactUsCategoryException" %>
<%@ page import="com.sambaash.platform.portlet.contactus.exception.ContactUsNameException" %>
<%@ page import="com.sambaash.platform.portlet.contactus.exception.ContactUsCommentException" %>
<%@ page import="com.sambaash.platform.portlet.contactus.exception.ContactUsCountryException" %>
<%@ page import="com.sambaash.platform.portlet.contactus.exception.ContactUsContactNumberException" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException" %>

<%@ page import= "com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@ page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.service.CountryServiceUtil" %>
<%@ page import="com.liferay.portal.model.Country" %>
<%@ page import="com.sambaash.platform.srv.spservices.model.SPListType" %>
<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />

<%

List<AssetCategory> lstCategories = (List<AssetCategory>) renderRequest.getAttribute("lstCategories");
List<AssetCategory> lstLocation = (List<AssetCategory>) renderRequest.getAttribute("lstLocation");

String category =(String)renderRequest.getAttribute("category");
if(Validator.isNull(category)){
	category="";
}

%>

<%

String defaultCommunityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());

if(defaultCommunityName.equals("em")) {
%>

<%@ include file="/html/contactus/view-emerio.jsp" %>

<% 
}
else if(defaultCommunityName.equals("mn")){
%>
<%@ include file="/html/contactus/view-menarini.jsp" %>

<% 
}else{
%>

<div> No Contact form found for this community</div>

<%
}
%>