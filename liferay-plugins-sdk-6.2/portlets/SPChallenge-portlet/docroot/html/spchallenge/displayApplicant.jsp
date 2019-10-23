<%@page import="com.sambaash.platform.spchallenge.helper.SPChallengeConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="resourceURL" >
<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<div class="display_applicant sp_profile max-width padding-left-75 padding-right-75 full-width block box-sizing-border ">
	<div class='page_headTitle'>
		<div class="superTitle">
			<span><h1><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.application")%></h1></span>
		</div>
	</div>
	<section class="profile_content" style="display: block">
		<div class="profile_forms_wrap">
			 <div class="profile_form_navigation  animate">
                            	<span class="formNavTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.overview")%></span>
                            	<nav>
                            		<span class="mobileNavSelect"> <%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%> <span><a href="<%=renderRequest.getAttribute("startupUrl")%>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.details-view")%></a></span> </span>
                                    <ul>
                                        <li class=" animated" id="form_review" help-text=""><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%></span></li>
                                        <li class=" animated active" id="form_applyBrief" help-text=""><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.application")%></span></li>
                                    </ul>
                                </nav>
                                <div class="tab_helpText">
                                	
                                	<div class="title_helpText" style="display:none">
                                		<span><b><%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%></b></span>
                                	</div>
                                	
                                	<div class="challenge_link">
                                		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.application.received.for")%> </span><br/>
                                		<a target="_blank" href="<%=renderRequest.getAttribute(SPChallengeConstants.FRIENDLY_URL)%>"><span id="challengeName" class="superTitleVal chalTitle"></span></a>
                                	</div>
                                	<br/>
                                	<div class="startup_link">
                                		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup")%> </span><br/>
                                		<a target="_blank" href="<%=renderRequest.getAttribute("startupUrl")%>">
                                			<img alt="Applicant Image" class="applicantImage" src="<%=renderRequest.getAttribute(SPChallengeConstants.LOGO_URL)%>"/><%=renderRequest.getAttribute(SPChallengeConstants.ORGANIZATION_NAME) %>
                                		</a>
                                	</div>
                                	<br/>
                                	<div class="challenge_date">
                                		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.applied.on")%> <%=renderRequest.getAttribute("applicationDate")%></span>
                                	</div>
                                	
                                	<div class="arrow_helpText">
                                	</div>
                                </div>
              </div>

                <aui:form name="addStartup" action="" cssClass="profile_form profileData" style="display: none">

              	  <%@ include file="/html/common/startupProfileForm.jsp" %>

				</aui:form>
				<aui:form name="applyChallenge" action="" cssClass="profile_form smartForm">
              		<section class="form form_review form_disabled" form-name="form_review">
              			<span class="formTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup-profile")%></span>
              			<div class="formContent">

	              			<div class="formFields_data">

	              			</div>
              			</div>
              		</section>
              		<section class="form form_applyBrief form_disabled active" form-name="form_applyBrief">
              			<span class="formTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.details")%></span>
              			<div class="formContent">

	              			<!-- <div class="formFields_data"> -->
								<div class="formTextField fw">
									<aui:input name="applicant_q1" type="textarea" rows="5" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.how.technology.fit.this.challenge")%>'>
									</aui:input>
								</div>
							    <div class="formTextField fw">
									<aui:input name="applicant_q2" type="textarea" rows="5" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.deliver.pilot")%>'>
									</aui:input>
								</div>
								<div class="formTextField fw">
									<aui:input name="applicant_q3" type="textarea" rows="5" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.long.term.ambition")%>'>
									</aui:input>
								</div>
								
								<!-- remove below section after testing -->
								<div style="display:none">
								 <div class="formCheckField">
								 	<label><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.markets.of.interest")%></label><br>
										<% FormHelper.createCheckBoxes("regionList", "cats", renderRequest,renderResponse, out);%>
								 </div>
								 </div>
              			</div>
              		</section>

			  </aui:form>
		</div>
	</section>
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

<script src="/SPChallenge-portlet/js/script.js" type="text/javascript"></script>
<script src="/SPChallenge-portlet/js/apply.js" type="text/javascript"></script>
<script src="/SPChallenge-portlet/js/view.js" type="text/javascript"></script>

<script type="text/javascript">
var namespace = '<portlet:namespace/>';
var op = 'applyBrief';
var organization = <%=renderRequest.getAttribute("organization")%>;
var challenge = <%=renderRequest.getAttribute("challenge")%>;
var applicant = <%=renderRequest.getAttribute("applicant")%>;
var hq = <%=renderRequest.getAttribute("hq")%>;
var editOrgUrl = '<%=renderRequest.getAttribute("friendlyUrl")%>';
var dynaSectionCounters = {};
<%
FormHelper.toMultipleFieldHtml("office", renderRequest, out);
FormHelper.toMultipleFieldHtml("boardMember", renderRequest, out);
FormHelper.toMultipleFieldHtml("fundingRound", renderRequest, out);
FormHelper.toMultipleFieldHtml("competitor", renderRequest, out);
FormHelper.toMultipleFieldHtml("founder", renderRequest, out);
FormHelper.toMultipleFieldHtml("investor", renderRequest, out);%>
var fillBy = <%=renderRequest.getAttribute("fillBy") %>;

addMultiSectionsToForm("office");
addMultiSectionsToForm("boardMember");
addMultiSectionsToForm("fundingRound");
addMultiSectionsToForm("competitor");
addMultiSectionsToForm("founder");
addMultiSectionsToForm("investor");

initialize('<%=resourceURL%>','<%=viewURL%>');
// populate an empty form with data and then replicate fields..and remove aui classes
showReviewTab();
handleScroll(170.5, 2000);
disableAllFields('smartForm');
function handleScroll(offset, delay) {
	YUI().use('event-hover','node', 'transition', 'event', 'event-valuechange',  function (Y) {
		//sticky navigation bar isnt required when on lower resolutions
		if(document.scrollingElement && document.scrollingElement.clientWidth < 777) {
			console.log('mobile view..');
			return;
		}
		//coz some of the page elements are loaded 
		window.setTimeout(enableSticky, delay);
	
		function enableSticky(){
			var sticky = Y.one('.profile_form_navigation');
			window.scrollTo(0,0);
			var stickytop = sticky.getY();
			var contentHeight = document.scrollingElement.scrollHeight;
			var stickyheight = sticky.getDOMNode().offsetHeight;
			var maxScroll =  footer.offsetTop - stickyheight - offset;
			Y.on('scroll', function (e) {
				// contentHeight might change diff tabs are selected
				if (document.scrollingElement.scrollHeight != contentHeight) {
					contentHeight = document.scrollingElement.scrollHeight;
					maxScroll =  footer.offsetTop - stickyheight - offset - 24;
					console.log('content height change..recalculating');
				}
				var currPos = window.pageYOffset;
				if ((currPos >= (stickytop - offset)) && currPos < maxScroll) { // between
					sticky.setStyle('position', 'fixed');
	                sticky.setStyle('top', offset);
	                sticky.setStyle('margin-top', '0px');
				} else if (currPos >= maxScroll) { // reached bottom
					sticky.setStyle('position', 'absolute');
					sticky.setStyle('top', maxScroll);
				} else { // reached top
					sticky.setStyle('position', 'absolute');
					sticky.setStyle('top', 'auto');
				} 
			});
		}
	});
}
</script>
