<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="resourceURL" >
<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<div class="hide-content">
<!--  	<section class="result_item result_item_1 animated animate"
		id="challengeSection" data-link="/challenge-link">
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
				<a id="challengeViewUrl" class="genCTA" href="">View</a> <a
					id="challengeEditUrl" class="genCTA" style="display: none" href="">Edit</a>
			</div>
		</div>
	</section> -->
	<li id="challengeSectionListItem">
                	
                    <div class="section_box_content latestChallenges">
							
                            <section class="result_item  animated animate" id="challengeSection" data-link="/challenge-link">
                            	<div class="result_item_content">
                                	<div class="result_item_image"> <img id="challengeImage" alt="Challenge Image"> </div>
                                    
                                    <div class="result_item_date"> <span class='challengeApplyBy'><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.apply.by")%> :</span> <span id="challengeApplyDate"></span> </div>
                                    
                                    <div class="result_item_title"> <span id="challengeName"></span> </div>
                                    
                                    <div class="section_box_bd">
                                    	<p id="description"></p>
                                    </div>
                                    
                                    <div class="section_box_cta">
                                    	<a   id="challengeViewUrl" class="genCTA"  href="#"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.find.out.more")%></a>
                                    </div>
                                    
                                </div>
                            </section>
                            
                            
                    </div>
                    
       </li>
</div>




<!-- <div class="sp_profile sp_filter">
	<section class="profile_content" style="display: block">
		<div class="profile_forms_wrap">
			<div class="profile_form">
				<h2>Recommended <liferay-ui:message key="label.challenges.title" /></h2>
				<br>
				<div id="resultsContainer" class="sp_results_wrap">
				</div>
				<div class="loadMoreWrap" id="loadMoreDiv">
					<div id="loadPrev"><aui:button value="&lt;"/></div>
					<div id="loadMore"><aui:button value="&gt;"/></div>
				</div>
			</div>
		</div>
	</section>
</div>  -->


<section class="section_box">
	<div class="sectionSliderWrap">
    	<div class="section_title">
        	Recommended<b> <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.challenges.title")%>' /></b>
        </div>
        <div class="sectionSliderContent" id="latestChallengesSlider">
            <ul id="resultsContainer">
                
            </ul>
        </div>
    </div>
</section>
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
var missingInfo = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.missing.information")%>''
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


<script src="/SPChallenge-portlet/js/myChallenges.js?t=<%=DateUtil.newTime() %>" type="text/javascript"></script>
<script src="/SPChallenge-portlet/js/view.js?t=<%=DateUtil.newTime() %>" type="text/javascript"></script>

<script type="text/javascript">
	initializeMyChallenges('<%=resourceURL%>');
</script>
