<%@page import="com.sambaash.platform.spchallenge.helper.SPChallengeConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil"%>
<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@page import="com.sambaash.platform.spchallenge.helper.ChallengeFormHelper"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
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

<div class="sp_profile apply-challenge max-width block padding-left-75 padding-right-75 box-sizing-border full-width">
   <div class='page_headTitle'>
      <div class="superTitle"><h1><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.you.are.applying.for")%> :</span><span id="challengeName" class="superTitleVal chalTitle"></span></h1></div>
   </div>
   <section class="profile_content" style="display: block">
      <div class="profile_forms_wrap">
         <div class="profile_form_navigation posFixed stickyNav animate">
            <span class="formNavTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.overview")%></span>
            <nav>
               <span class="mobileNavSelect"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup.profile.review")%> </span>
               <ul>
                  <li class=" animated active" id="form_review" help-text='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.to.update.startup.info")%>'><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup.profile.review")%></span></li>
                  <li class=" animated " id="form_applyBrief" help-text='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fill.form.details")%>'><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.apply.for.brief")%></span></li>
                  <li class=" animated " id="brief_review" help-text='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.registered.verify.info")%>'><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"review-n-submit")%></span></li>
               </ul>
            </nav>
            <div class="tab_helpText">
               <div class="icon_helpText">
                  <span>?</span>
               </div>
               <div class="title_helpText">
                  <span><b><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup.profile.review")%></b></span>
               </div>
               <div class="content_helpText">
                  <span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.to.update.startup.info")%></span>
               </div>
               <div class="arrow_helpText">
               </div>
            </div>
         </div>
         <aui:form name="addStartup" action="" cssClass="profile_form profileData" style="display: none">
            <%@ include file="/html/common/startupProfileForm.jsp" %>
         </aui:form>
         <aui:form name="applyChallenge" action="" cssClass="profile_form smartForm">
            <section class="form form_review form_disabled active" form-name="form_review">
             	
               <span class="formTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup.profile.review")%></span>
               <div class="formContent">
                  <div class="formFields_data">
                  </div>
               </div>
               <div class="formCTA fw">
                  <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.edit.profile")%>' class="modifyOrg" />
                  <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.proceed")%>' class="proceed" />
               </div>
            </section>
            <section class="form form_applyBrief" form-name="form_applyBrief">
               <span class="formTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.apply.for.brief")%></span>
               <div class="formContent">
                  <!-- <div class="formFields_data"> -->
                  <div class="formTextField fw">
                     <aui:input name="applicant_q1" type="textarea" rows="5" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.how.technology.fit.this.challenge")%>'>
                        <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.mandatory")%>'></aui:validator>
                        <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max2000.characters")%>'>2000</aui:validator>
                     </aui:input>
                  </div>
                  <div class="formTextField fw">
                     <aui:input name="applicant_q2" type="textarea" rows="5" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.deliver.pilot")%>'>
                        <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.mandatory")%>'></aui:validator>
                        <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max2000.characters")%>'>2000</aui:validator>
                     </aui:input>
                  </div>
                  <div class="formTextField fw">
                     <aui:input name="applicant_q3" type="textarea" rows="5" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.long.term.ambition")%>'>
                        <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.mandatory")%>'></aui:validator>
                        <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max2000.characters")%>'>2000</aui:validator>
                     </aui:input>
                  </div>
                  <!-- remove below section after testing -->
                  <div style="display:none">
                     <div class="formCheckField">
                        <label><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.markets.of.interest")%></label><br>
                        <% FormHelper.createCheckBoxes("regionList", "cats", renderRequest,renderResponse, out);%>
                     </div>
                  </div>
                  <div class="formCTA fw">
                     <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save.and.review")%>' class="proceed" />
                  </div>
               </div>
            </section>
            <section class="form brief_review form_disabled" form-name="brief_review">
               <span class="formTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.review.application.information")%></span>
               <div class="formContent">
                  <div class="formFields_data">
                  </div>
                  <div class="formCTA fw">
                     <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.submit")%>' class="proceed" id="applyChallenge"/>
                     <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' class="cancel" id="cancelApply"/>
                  </div>
               </div>
            </section>
         </aui:form>
      </div>
   </section>
</div>
<div id="apply_popup" class="apply-popupoverlay">
   <div class="popup-details-page">
      <div class="close-popup">
      </div>
      <div class="pop-content-wrapper">
         <h1><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.you.have.successfully.applied")%></h1>
         <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.review.application")%><span id="challengeName" class="superTitleVal chalTitle"></span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.will.revert.soon")%></p>
         <p> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.what.would.you.like.to.do.next")%></p>
         <div class="btnDetails">
            <button type="button" class="Blue small" onclick="javascript:location.href=defaultDashBoardUrl"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.my.dashboard")%></button>
            <button type="button" class="Blue small" onclick="javascript:location.href='/challenges'"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.explore.briefs")%></button>
         </div>
      </div>
   </div>
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
<script type="text/javascript">
   var namespace = '<portlet:namespace/>';
   var op = 'applyBrief';
   var organization = <%=renderRequest.getAttribute("organization")%>;
   var challenge = <%=renderRequest.getAttribute("challenge")%>;
   var applicant = <%=renderRequest.getAttribute("applicant")%>;
   var hq = <%=renderRequest.getAttribute("hq")%>;
   var editOrgUrl = '<%=renderRequest.getAttribute("friendlyUrl")%>';
   var defaultDashBoardUrl = '<%=SambaashUtil.getDashboardUrl(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())%>';
   var dynaSectionCounters = {};
   
   <%ChallengeFormHelper.toMultipleFieldHtml("fundingRound", renderRequest, out);%>
   <%ChallengeFormHelper.toMultipleFieldHtml("teamMember", renderRequest, out);%>
   <%ChallengeFormHelper.toMultipleFieldHtml("questionnaire", renderRequest, out);%>
 
   
   var fillBy = <%=renderRequest.getAttribute("fillBy") %>;
   addMultiSectionsToForm("fundingRound");
   addTeamMembersToForm("teamMember");
   
   initialize('<%=resourceURL%>','<%=OrganizationLocalServiceUtil.displayFriendlyURL(themeDisplay, ParamUtil.getLong(request, SPChallengeConstants.ORGANIZATION_ID)).replace("/manage-profile/view/", "/manage-profile/applications/")%>');
   // populate an empty form with data and then replicate fields..and remove aui classes
   showReviewTab();
   AUI().use('aui-node', 'aui-base','node-event-simulate', function(A) {
	   A.one('#form_applyBrief').simulate('click');
	});
   //initStickyNav();
</script>
