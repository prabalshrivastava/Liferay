<%@page import="com.sambaash.platform.startupprofile.helper.StartupFormHelper"%>
<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
.taglib-search-iterator-page-iterator-top .lfr-pagination {
	display: none;
}
</style>
<portlet:actionURL var="searchURL" name="searchAction"/>
<portlet:renderURL var="resetURL"></portlet:renderURL>
<portlet:resourceURL var="exportResultsURL" >
	<portlet:param name="action" value="exportResults"/>
</portlet:resourceURL>

<div class="startup-profiles">
	<div class="page_headTitle">
		<h1><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profiles")%>' /></h1>
	</div>
	<%if (GetterUtil.getBoolean(renderRequest.getAttribute("hasRows"))) { %>
	<div class="text-right margin-right-one">
		<liferay-ui:icon-list>
			 <liferay-ui:icon image="download" message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.export")%>' url="${exportResultsURL}"/>
		</liferay-ui:icon-list>
	</div>
	<% } %>
	<div>
		<div class="search_filters inline-block width-20 align-top margin-top-one">
			<aui:form action="${searchURL}" class="searchForm">
				<div class="search-criteria-row">
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"search-startup-name")%></p>
						<aui:input name="searchStartupName" label=''></aui:input>
				</div>
				<div class="search-criteria-row">
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.email")%></p>
						<aui:input name="searchStartupEmail" label=''></aui:input>
				</div>
				<div class="search-criteria-row">
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"lifecycle-stage")%></p>
						<aui:select name="orgLifecycleStageId" label='' showEmptyOption="true" cssClass="full-width">
							<% FormHelper.createDropDownOptions("orgLifecycleStageList", "orgLifecycleStageId", renderRequest, out);%>
						</aui:select>
				</div>
				<div class="search-criteria-row">
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.country")%></p>
						<aui:select name="searchCountry" label='' showEmptyOption="true" cssClass="full-width">
							<% StartupFormHelper.createCountryDDOptions("searchCountry", renderRequest, out);%>
						</aui:select>
				</div>
				<div class="search-criteria-row">
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"area-of-interest")%></p>
						<aui:select name="orgCategoryId" label='' showEmptyOption="true" cssClass="full-width">
							<% FormHelper.createDropDownOptions("orgCategoryList", "orgCategoryId", renderRequest, out);%>
						</aui:select>
				</div>
				<div class="search-criteria-row text-center">
						<aui:button value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.search")%>' type="submit"></aui:button>
						<aui:button value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.reset")%>' onClick="window.location.href='${resetURL}'"></aui:button>
				</div>
			</aui:form>
		</div>
		<div class="inline-block width-75 margin-left-half">
			<liferay-ui:search-iterator searchContainer="${searchContainer}" />
		</div>
	</div>
</div>
<script>
	var msg = "${msg}";
	if(msg && msg.length > 0 ){
		alert(msg);
	}
</script>
