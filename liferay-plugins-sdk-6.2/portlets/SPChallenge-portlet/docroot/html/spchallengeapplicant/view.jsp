<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.spchallenge.helper.SPChallengeConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<style>
.taglib-search-iterator-page-iterator-top .lfr-pagination {
	display: none;
}
</style>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:renderURL var="listRenderURL" portletMode="view">
	<portlet:param name="viewMode" value="List" />
</portlet:renderURL>
<portlet:renderURL var="sliderRenderURL" portletMode="view">
	<portlet:param name="viewMode" value="Slider" />
</portlet:renderURL>
<portlet:actionURL var="searchURL" name="searchAction">
	<portlet:param name="fromPage" value="search" />
	<portlet:param name="viewMode" value="List" />
</portlet:actionURL>
<portlet:resourceURL var="exportResultsURL">
	<portlet:param name="action" value="exportResults" />
</portlet:resourceURL>
<portlet:resourceURL var="respondURL">
	<portlet:param name="action" value="sendApplicationResponse" />
</portlet:resourceURL>

<%
	String viewMode = GetterUtil.getString(renderRequest
	.getAttribute(SPChallengeConstants.VOC_VIEW_MODE));

	if (Validator.isNull(viewMode)) {
		portletPreferences.getValue(SPChallengeConstants.VOC_VIEW_MODE,
		SPChallengeConstants.VOC_VIEW_SLIDER);
	}
	
	boolean inResponseMode = GetterUtil.getBoolean(renderRequest.getAttribute("responseMode"));
%>

<%
	if (!viewMode.equalsIgnoreCase(SPChallengeConstants.VOC_VIEW_SLIDER)) {
%>
<div class="challenge_applicants">
	<%if (inResponseMode) {%>
	<div class="page_headTitle">
		<h1><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"title.respond.to.applicants")%>' /></h1>
	</div>
	<div class="inline-block margin-left-half" style="width: 100%;">	
	<%} else {%>
	<div class="page_headTitle">
		<h1><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"challenge-applicants")%>' /></h1>
	</div>
	<div class="viewModeLink hide">
		<a href="${sliderRenderURL}"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.back")%>' /></a>
	</div>
	<div
		class="search_filters inline-block width-20 align-top margin-top-one">
		<aui:form action="${searchURL}" class="searchForm">
			<div class="search-criteria-row">
			<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"search-startup-name")%></p>
				<aui:input name="searchStartupName" label=''
					cssClass="full-width" />
			</div>
			<div class="search-criteria-row">
				<%@ include file="/html/spchallengeapplicant/briefSearchAutoComplete.jspf" %>
			</div>
			<div class="search-criteria-row text-center">
				<aui:button value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.search")%>' type="submit"></aui:button>
				<aui:button value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.reset")%>' onClick="window.location.href='${listRenderURL}'" cssClass="btn-primary"></aui:button>
			</div>
		</aui:form>
	</div>
	<div class="inline-block width-75 margin-left-half">	
	<%}%>
	<%if (!inResponseMode && GetterUtil.getBoolean(renderRequest.getAttribute("hasRows"))) { %>
			<div class="text-right margin-right-one">
				<liferay-ui:icon-list>
					<liferay-ui:icon image="download" message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.export")%>'
						url="${exportResultsURL}" id="exportResultsBtn"/>
				</liferay-ui:icon-list>
			</div>
		<% } %>
		<liferay-ui:search-iterator searchContainer="${searchContainer}" />
	</div>
	<%if (inResponseMode && GetterUtil.getBoolean(renderRequest.getAttribute("hasRows"))) { 
		String specificChallenge = GetterUtil.getString(renderRequest.getAttribute(SPChallengeConstants.PARAM_SEARCH_CHALLENGE));
	%>
	<div class="cmi-button-wrap" style="text-align: center;"> 
		<a href="#" class="cmi-button" onclick="sendBriefApplicationResponse(this,<%=specificChallenge%>);"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.send.response")%></a> 
	</div>
	<% } %>
</div>
<script>

var addBriefTitle = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.please.add.the.brief.title.to.save.as.draft")%>'
var publishedSuccessfully = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brief.has.been.published.successfully")%>'
var briefSavedDraft = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brief.has.been.saved.as.draft")%>'
var successMSg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.success")%>'
var errorMssg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error")%>'
var createChallenge ='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.creating.challenge")%>'
var saveInfoFailed = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.save.information")%>'
var messageLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.message")%>'
var okLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ok")%>'
var missingInfo = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.missing.information")%>'
var sessionTimeout = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.has.timed.out")%>'
var applSubmitSuccess = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.applcation.submitted.sucess")%>'
var saveApplFailed = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.save.application.information")%>'
var userAreadyUse = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.selected.user.already.added")%>'
var notValidEmail ='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.not.a.valid.email.address")%>'
var errorFetchingResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.fetching.result")%>'
var noActiveBrief = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.active.briefs.yet")%>'
var noApplReceived = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.applications.received")%>'
var noChallengeFound = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.challenges.found")%>'
var noStartupProfile = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.startup.profile.create.one")%>'
var alreadyApplied = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.you.already.applied.for.this.challenge")%>'
var selectStartup = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.startup.in.challenge")%>'
var startupIncomplete = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.startup.incomplete")%>'
var emailSendFailed = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.send.email")%>'
var createProfile = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.create.profile")%>'
var cancelLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>'
var profileIncomp = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.profile.incomplete")%>'
</script>

<script src="/SPChallenge-portlet/js/myChallenges.js?t=<%=DateUtil.newTime() %>"
	type="text/javascript"></script>
<script src="/SPChallenge-portlet/js/apply.js" type="text/javascript"></script>
<script type="text/javascript">
	setAjaxUrl('<%=resourceURL%>');
</script>
<%
	} else {
%>
<div class="challenge_applicants">
	<div class="hide-content">
		<li id="applicantSectionListItem">
			<div class="section_box_content challApplicant">
				<section class="tile_item  animated animate" id="applicantSection">
					<div class="tile_item_image">
						<img id="challengeImage" alt="Challenge Image">

						<div class="section_box_cta">
							<a id="applicantViewUrl" class="genCTA" href="#"><liferay-ui:message
									key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"view-application")%>' /></a>
						</div>
					</div>
					<div class="tile_item_content">

						<div class="tile_item_title">
							<a id="challengeUrl" href="#"><span id="challengeName"></span></a>
						</div>

						<div class="tile_details">

							<div class="applicantIcon">
								<img id="applicantImage" alt="Applicant Image">
							</div>

							<div class="applicantNameText">
								<a id="startupUrl" href="#"><span id="applicantName"></span></a>
							</div>

						</div>

					</div>

				</section>
			</div>
		</li>
	</div>

	<section class="section_box ">
		<div class="sectionSliderWrap">
			<div class="page_headTitle">
				<h1>
					<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"challenge-applicants")%>' />
				</h1>
			</div>
			<div class="viewModeLink">
				<a href="${listRenderURL}"><liferay-ui:message
						key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.list.view")%>' /></a>
			</div>
			<div class="sectionSliderContent" id="challengeApplicationSlider">
				<ul id="applicantResultsContainer">

				</ul>
			</div>
		</div>
	</section>
</div>
<script src="/SPChallenge-portlet/js/myChallenges.js?t=<%=DateUtil.newTime() %>"
	type="text/javascript"></script>
<script type="text/javascript">
	AUI().ready('' , function () {
		initChallengeApplicants('<%=resourceURL%>');
	});
</script>
<%
	}
%>
