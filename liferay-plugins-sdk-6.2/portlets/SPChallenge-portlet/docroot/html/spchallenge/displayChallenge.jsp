<%@page import="com.sambaash.platform.spchallenge.helper.SPChallengeHelper"%>
<%@page import="com.sambaash.platform.util.SocialNetworkUtils"%>
<%@page import="com.sambaash.platform.spchallenge.helper.ChallengeFormHelper"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-util:html-top>                                                                                                                                                    
        <meta property="og:title" content="${ogtitle}"/>                                                                                                                   
        <meta property="og:description" content="${ogdescription}"/>                                                                                                       
        <meta property="og:image" content="${logoUrl}"/>                                                                                                                   
        <meta property="og:url" content="${ogurl}"/>                                                                                                                       
        <meta property="og:type" content="Challenge"/>                                                                                                                       
</liferay-util:html-top> 

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<portlet:renderURL portletMode="view" var="viewURL" />
<div id="displayChallengeContainer" class="white-bg hide">
<div class="innerPage_header big-banner full-width"
	style="background-image: url('${logoUrl}');">
		<div class="scrolldown Down-arrow-pos" > <a href="#bulletlink2" ><img alt="Scroll Down" src="${themeDisplay.getPathThemeImages()}/lp/scrolldown.png" ></a></div>
</div>
<div class="full-width header-cta-band" id="scroll_Challange">
	<div class="relative max-width">
	<div class="max-width padding-left-one padding-top-half">
		<div><h1 class="h3">${challengeName}</h1></div>

	
	</div>
	<div class="header_page_cta max-width padding-10-30-chanllenge ">
		<div class="apply-cta">
			<c:if test="${canApplyClosed}">
				<div class="inline-block margin-right-quarter margin-bottom-quarter">
					<a href="#" id="applyChallenge_CTA" class="btn-callout"><span><liferay-ui:message
								key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"apply.to.pitch")%>' /></span></a>
				</div>
			</c:if>
			<c:if test="${canApplyOpen}">
				<div class="inline-block margin-right-quarter margin-bottom-quarter">
					<a href="#" id="applyOpenChallenge_CTA" target="_blank"
						class="btn-callout"><span><liferay-ui:message
								key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"apply.here")%>' /></span></a>
				</div>
			</c:if>
			<c:if test="${not empty editfriendlyUrl}">
				<div class="inline-block">
					<a href="${editfriendlyUrl}" id="editChallenge_CTA" 
						class="btn-callout"><span><liferay-ui:message
								key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"edit.challenge")%>' /></span></a>
				</div>
			</c:if>
		</div>
	</div>
	
	<div class="header_page_infobar absolute pin-right zindex-2 pin-top  bulletlink2" id="bulletlink2">
		<div class="text-center challengDetail-disp">
			<c:if test="${not empty challengeBudget}">
				<div class="header-circle">
					<div>
						<span class="block text-center">
							<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"total.budget")%>' />
						</span>
						<span class="block light font-med text-center">${challengeBudgetCcySign} ${challengeBudget}</span>
					</div>
				</div>
			</c:if>
	
			<c:forEach items="${challengeTypeList}" var="challType">
				<div class="header-circle">
					<div>
						<span class="block">&nbsp;</span>
						<span class="block light font-med text-center">${challType}</span>
					</div>
				</div>
			</c:forEach>
			<div class="header-circle">
				<div>
				<span class="block text-center">
					<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"days.left")%>' />
				</span>
				<span class="block light font-med text-center">${challengeDaysLeft}</span>
				</div>
			</div>
		</div>
		<!-- <div class="categories margin-top-half white text-center">
			<span class="border-all padding-quarter margin-right-half">Creative</span>
		</div> -->
		<div class="social-share margin-top-half text-center">
			<a href="<%=SocialNetworkUtils.generateFacebookShareUrl(themeDisplay.getPortalURL()+themeDisplay.getURLCurrent())%>"  target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/fb.svg" alt="Share on Facebook" title=<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.share.on.facebook")%> />
			</a>
			<a href="<%=SocialNetworkUtils.generateTwitterShareUrl(themeDisplay.getPortalURL()+themeDisplay.getURLCurrent())%>" target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/twitter.svg" alt="Tweet" title=<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.tweet")%> />
			</a>
			<a href="<%=SocialNetworkUtils.generateGooglePlusShareUrl(themeDisplay.getPortalURL()+themeDisplay.getURLCurrent())%>" target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/gplus.svg" alt="Share on Google+" title=<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.share.on.google")%> />
			</a>
			<a href="<%=SocialNetworkUtils.generateLinkedInShareUrl(themeDisplay.getPortalURL()+themeDisplay.getURLCurrent())%>" target = "_blank">
				<img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/linkedin.svg" alt="Post on Linkedin" title=<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.post.on.linkedin")%> />
			</a> 
		</div>
	</div>
	</div>
</div>

<div class="navBar font-12" >
	<div class="max-width relative">
		<div class="inline-block">
			<nav>
				<ul class="margin-left-one">
					<li class="animated active inline-block" id="form_1"><span><liferay-ui:message
							key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"display.challenge.tab1")%>' /></span></li>
					<%-- <li class="animated inline-block" id="form_2"><span><liferay-ui:message
							key="display.challenge.tab2" /></span></li> --%>
				</ul>
			</nav>
		</div>
		
		<div class="nav-butts inline-block absolute pin-right zindex-3">
			<a href="${prevUrl}" title='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.previous.brief")%>'>
				<img alt="Previous" src="<%=themeDisplay.getPathThemeImages()%>/arrows/prev.svg"/>
			</a>
			
			<a href="${nextUrl}" title='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.next.brief")%>'>
				<img alt="Next" src="<%=themeDisplay.getPathThemeImages()%>/arrows/next.svg"/>
			</a>
			
<%-- 			<a href="<%=SPChallengeHelper.getChallengesPath()%>" title="Back to Brief">
				<img alt="Back" src="<%=themeDisplay.getPathThemeImages()%>/arrows/back.svg"/>
			</a> --%>
		</div>
	</div>
</div>

<div class="display_view max-width" >
	<div class="col_section col_section_80">
		<section class="tab form_1 animated active ">
				<aui:form name="addChallenge" cssClass="addChallenge">
					<div class="formTextField fw">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.background")%></h2>
						<p><aui:input name="challenge_background" label=''
							type="textarea" rows="1"></aui:input></p>
					</div>
					
					<!-- used by apply here button -->
					<div class="formTextField fw" style="display: none">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.open.collaboration.foundry.ideas.url")%></h2>
						<p><aui:input name="challenge_extras" label='' >
							<aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max200.characters")%>'>200</aui:validator>
						</aui:input></p>
					 </div> 

					<div class="formTextField fw">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.context.of.the.challenge")%></h2>
						<p><aui:input name="challenge_description"
							label='' type="textarea" rows="1"></aui:input></p>
					</div>

					<div class="formTextField fw">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.why.apply")%></h2>
						<p><aui:input name="challenge_benefits" type="textarea" rows="1"
							label=''></aui:input></p>
					</div>
				</aui:form>
		</section>

		<section class="tab form_2 animated"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.test")%></section>

	</div>

	<div class="col_section col_section_20">
	
		<div class="hide-content">
				<section class="result_item  animated animate" id="challengeSection" data-link="/challenge-link">
					<div class="result_item_content">
							<div class="result_item_image">
					        	<img id="challengeImage" alt="Challenge Image"></img>
					        </div>
					    	<div class="result_item_title">
					        	<span id="challengeName"></span>
					        </div>
					        <div class="result_item_author">
    							<span id="challengeAuthor"></span>
					        </div>
					  </div>
					  <div class="result_item_overlay">
					  		<div class="result_item_overlay_cta">
					  			<a id="challengeViewUrl" class="btn-chal-view btn-callout" href=""><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.view")%></a>
					  			<a id="challengeEditUrl" class="btn-chal-edit btn-callout" style="display:none" href=""><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.edit")%></a>
					  		</div>
					  </div>
				</section>
		</div>
	
		<div class="col_section_item">
			<div class="col_section_title Challenge-padBot-0">
				<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.similar.briefs")%></h2>
			</div>
			<div id="resultsContainer" class="sp_results_wrap">
				
			</div>
		</div>
	
	</div>

</div>
</div>


<div id="apply_popup" class="apply-popupoverlay">
          <div class="signin-container">
                <div class="signinbg">
                    <div class="detail-signin-header">
                        <h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.interested.to.apply.for.brief")%></h2>
                    </div>
                </div>
                <div class="box">
                	
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

<script src="/SPChallenge-portlet/js/main.js" type="text/javascript"></script>
<script src="/SPChallenge-portlet/js/view.js" type="text/javascript"></script>

<aui:script use="aui-node, aui-base">
	var applyInternal = <%=renderRequest.getAttribute("apply_internal")%>;
	var applyExternal = <%=renderRequest.getAttribute("apply_external")%>;
	if (applyInternal || applyExternal) {
		showChallengePage(false);
	} else {
		showChallengePage();
	}
</aui:script>

<script type="text/javascript">
	var namespace = '<portlet:namespace/>';
	var challengeId = <%=renderRequest.getAttribute("spChallengeId")%>
	var challenge = <%=renderRequest.getAttribute("challenge")%>
	var asset = {};
	var applyInternal = <%=renderRequest.getAttribute("apply_internal")%>;
	var applyExternal = <%=renderRequest.getAttribute("apply_external")%>;	
	initializeViewChallenge('<%=resourceURL%>','<%=viewURL%>');
	disableAllFields('addChallenge');
	initializeSimilarChallenges();
	initializeApply('<%=resourceURL%>' ,applyInternal, applyExternal);
</script>

<script type="text/javascript">
function findOffset(element) {
  var top = 0, left = 0;

  do {
    top += element.offsetTop  || 0;
    left += element.offsetLeft || 0;
    element = element.offsetParent;
  } while(element);

  return {
    top: top,
    left: left
  };
}

window.onload = function () {
  var stickyHeader = document.getElementById('scroll_Challange');
  var headerOffset = findOffset(stickyHeader);
  
  window.onscroll = function() {
    // body.scrollTop is deprecated and no longer available on Firefox
    var bodyScrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    var headerCircle = document.querySelector(".challengDetail-disp");
    var socialIconChallenge =  document.querySelector(".social-share");
    var displayContent =  document.querySelector(".navBar");
    if (bodyScrollTop > headerOffset.top ) {
   
      stickyHeader.classList.add('stick');
      headerCircle.classList.add('chal-none');
      socialIconChallenge.classList.add('Margin-Social');
      displayContent.classList.add('Margin-Content');
		
    } else {
      stickyHeader.classList.remove('stick');
       headerCircle.classList.remove('chal-none');
      socialIconChallenge.classList.remove('Margin-Social');
       displayContent.classList.remove('Margin-Content');

    }

  	}
};

</script>
