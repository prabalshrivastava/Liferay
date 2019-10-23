<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="resourceURL" >
<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:actionURL var="uploadLogoActionURL" name="uploadLogoForLowerVersionBrowsers" />

<div class="form max-width padding-left-75 padding-right-75 box-sizing-border full-width block padding-top-one padding-bottom-one create-edit-wrap" id="add-challenge-form-wrapper">
<aui:form name="addChallenge"   action="<%=uploadLogoActionURL%>" cssClass="addChallenge commonForm form960" enctype="multipart/form-data">
<div class="page_headTitle">
	<i><img src="<%=themeDisplay.getPathThemeImages()%>/content/apply_icon.png" alt="Create Brief" /></i>
	<span>
		<h1><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.create")%> <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.challenge.title")%>' /></h1>
	</span>
</div>
<div>
<aui:input type='hidden' name='challengeId' > </aui:input>
<aui:input type="file" name="challengeLogo" accept="image/jpg,image/x-png,image/jpeg" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brief.image")%>' title='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.upload.image.with.dimension")%>'>  		
</aui:input>
			<div id='logoDiv'>
				<div id="filedrag1" class="fd_container">
					<div class="fdWrap">'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.or.drop.image.here")%>'</div>
					<div class='imageContainer' style='text-align: center'>
						<img alt="logoImg" id="logoImg" src="${logoUrl }"  style='max-width:100%; max-height:300px'  />
					</div>
				</div>
			</div>
		</div>
<div id='removoLogoDiv' class="font-10 text-right">
	<a href="javascript:;" id="removeLogoLink"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.remove.logo")%></a>
	<aui:input name="removeLogo" type="hidden"></aui:input>
</div>

<div class="formTextField fw">
	<aui:input name="challenge_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brief.title")%>'>
		<aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
		<aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max100.characters")%>'>100</aui:validator>
	</aui:input>
</div>

 <div class="formTextField" style="display:none">
	<aui:select name="asset_challengeTypeId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brief.type")%>' required="false" multiple="true" style="height:100px;">
<%-- 	<% FormHelper.createDropDownOptions("challengeTypeList", "cats", renderRequest, out);%> --%>
	</aui:select>
 </div>

 <div class="formTextField">
	<aui:select name="asset_challengeCategoryId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.challenge.category")%>' required="true" multiple="true" style="height:130px;">
		<% FormHelper.createDropDownOptions("challengeCategoryList", "cats", renderRequest, out);%>
	</aui:select>
 </div>
 
<div class="formTextField">
	<aui:select name="challenge_brand" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brand")%>' showEmptyOption="true" >
		<% FormHelper.createDropDownOptions("orgBrandList", "cats", renderRequest, out);%>
	</aui:select>
 </div>
  
<div class="formTextField fw">
	<aui:input name="challenge_background" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.background.on.your.brand.category")%>' type="textarea" rows="5">
		<aui:validator name="required" errorMessage="error.mandatory" />
		<aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
	</aui:input>
</div>

<div class="formTextField fw">
	<aui:input name="challenge_description" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.context.to.your.issue.challenge")%>' type="textarea" rows="5">
		<aui:validator name="required" errorMessage="error.mandatory" />
		<aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
	</aui:input>
</div>

<div class="formTextField">
	<aui:select name="asset_applicantTypesId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.applicant.type")%>' showEmptyOption="true"  required="true">
		<% FormHelper.createDropDownOptions("applicantTypesList", "cats", renderRequest, out);%>
	</aui:select>
 </div>
 
 <div class="formTextField">
	<aui:select name="asset_regionId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.location")%>' showEmptyOption="true" required="true">
		<% FormHelper.createDropDownOptions("regionList", "cats", renderRequest, out);%>
	</aui:select>
 </div>
 
 <div class="formTextField fw">
	<aui:select name="asset_collabTypeId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.brief.collaboration.type")%>' showEmptyOption="true" required="true">
		<% FormHelper.createDropDownOptions("collabTypeList", "cats", renderRequest, out);%>
	</aui:select>
 </div>
 
  <div class="formTextField fw" id="foundryIdeasUrlDiv"> 
	<aui:input name="challenge_extras" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.link")%>' type="text">
		<aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.please.enter.url.not.more.than.200.characters")%>' >
			function (val, fieldNode, ruleValue) {
				var A = AUI();
				var collabType = A.one("#" + namespace + "asset_collabTypeId");
				if(isCollabTypeExternal(collabType.val())){
					if (val.length > 200){
						return false;
					} else {
				 		return true;
					}
				}else{
				 	return true;
				}
			}
		</aui:validator>
		<aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.please.enter.valid.url")%>'>
			function (val, fieldNode, ruleValue) {
				var A = AUI();
				var collabType = A.one("#" + namespace + "asset_collabTypeId");
				if(isCollabTypeExternal(collabType.val())){
					if (val.length > 0){
						// this method is in pure_javascript_functions.js
						return validateURL(val);                     
					}
					return true;
				} else {
					return true;
				}
			}
		</aui:validator>
	</aui:input>
 </div>
 
		<div class="formTextField fw">
			<aui:input name="challenge_scout" type="hidden"></aui:input>
			<div id="scoutnotefDiv">
				<label for="scout-ip_to"> <span ><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.scout")%></span></label>
				<div class="sp-group-nonuple-column sp-group-column sp-group-of-ten full-width">
					<div data-autocomplete-dom-id="scout-sis-holder" data-group-id="0"
						class="ip-to">
						<ul data-autocomplete-dom-id="scout-selected-items"
							class="horizontal sp-group-ui-dib sp-group-ui-vam">

						</ul>
						<span class="ip-to-input-outer"><span
							style="display: none; z-index: -10000; position: relative; width: 100%;">'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.email.address.of.scout")%> </span><aui:input data-autocomplete-dom-id="scout-input"
							id="scout-ip_to" type="text" tabindex="0"
							placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.email.address.of.scout")%>' autocomplete="off" value=""
							class="ip-to-input" name="scout-ip_to" label="">
								<aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.please.select.a.scout")%>'>
									function (val, fieldNode, ruleValue) {
										var A = AUI().use('aui-node', 'aui-base');
										if(val.length > 0)
											return true;
										if(autoCompleteObj1) {
										 	if(autoCompleteObj1.getSelectedIds().length <= 0) {
												alert('Please assign this challenge to a scout');
												return false;
											}
										}
										return true;
									}
								</aui:validator>
							</aui:input>
							</span>
					</div>
					<div data-autocomplete-dom-id="scout-suggestions-board" class="ip-sb"
						style="display: none;">
						<div data-autocomplete-dom-id="scout-close-btn" class="ip-sb-c"></div>
						<div data-autocomplete-dom-id="scout-options" class="ip-sb-options"></div>

					</div>
				</div>
			</div>
		</div>
		
		<div class="formTextField fw">
			<aui:input name="challenge_notifyTo" type="hidden"></aui:input>
			<div id="notefDiv">
				<label for="ip_to"> <span ><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.send.notification")%></span></label>
				<div class="sp-group-nonuple-column sp-group-column sp-group-of-ten">
					<div data-autocomplete-dom-id="sis-holder" data-group-id="0"
						class="ip-to">
						<ul data-autocomplete-dom-id="selected-items"
							class="horizontal sp-group-ui-dib sp-group-ui-vam">

						</ul>
						<span class="ip-to-input-outer"><span
							style="display: none; z-index: -10000; position: relative; width: 100%;">'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.email.address")%>' </span><input data-autocomplete-dom-id="input"
							id="ip_to" type="text" tabindex="0"
							placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.email.address")%>' autocomplete="off" value=""
							class="ip-to-input" /></span>
					</div>
					<div data-autocomplete-dom-id="suggestions-board" class="ip-sb"
						style="display: none;">
						<div data-autocomplete-dom-id="close-btn" class="ip-sb-c"></div>
						<div data-autocomplete-dom-id="options" class="ip-sb-options"></div>

					</div>
				</div>
			</div>
		</div>

<div class="formTextField fw">
	<aui:input name="challenge_benefits" type="textarea" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.Why.startups.should.apply.and.what.opportunity.we.offer.them")%>' rows="5">
		<aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'	 />
		<aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
	</aui:input>
</div>

<div class="formGroupfield fw">
   	<div class="formGroupTitle"><label><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.total.budget")%>' /></label></div>
	<div class="formTextField" style="max-width: 70px !important;width: 30% !important;">
		<aui:input name="challenge_budgetCcySign" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.nothing")%>' >
			<aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max4.characters")%>'>4</aui:validator>
		</aui:input>
	</div>
	<div class="formTextField" style="width: 90% !important;">
		<aui:input name="challenge_budget" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.nothing")%>'>
			<aui:validator name="number" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.number")%>'></aui:validator>
		</aui:input>
	</div>
</div>

<div class="formTextField">
  <div id="startDatePicker" class="date helper-clearfix">
	<aui:input name="challenge_startDate" id="startDateInput" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.brief.start.date")%>'> 
		<aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
		<aui:validator name="maxLength">10</aui:validator>
		<aui:validator name="date"></aui:validator>
		<aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.start.date.cant.be.before.end.date")%>'>
			function (val, fieldNode, ruleValue) {
				return checkDate();
			}
		</aui:validator>
	</aui:input>
  </div>
</div>

<div class="formTextField">
  <div id="endDatePicker" class="date helper-clearfix">
	<aui:input name="challenge_endDate" id="endDateInput" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.brief.end.date")%>'>
		<aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
		<aui:validator name="maxLength">10</aui:validator>
		<aui:validator name="date"></aui:validator>
		<aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.end.date.cant.be.before.start.date")%>'>
			function (val, fieldNode, ruleValue) {
				return checkDate();
			}
		</aui:validator>
	</aui:input>
  </div>
</div>

<div class="formTextField fw">
    <aui:input name="challenge_vpApprover" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.vp.approver")%>'>
        <aui:validator name="email" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.valide.email")%>'/>
    </aui:input>
</div>

<div class="formTextField fw">
    <aui:input name="challenge_budgetApprover" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.budget.approver")%>'>
        <aui:validator name="email" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.valide.email")%>'/>
    </aui:input>
</div>

<div class="formCTA fw">
   <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save.as.draft")%>' class="draft btn-primary" />
   <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.publish")%>' class="submit btn-primary" />
   <input type="button" value='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' class="cancel btn-primary"  onclick="javascript:cancel();"/>
</div>
</aui:form>
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
<script src="/SPChallenge-portlet/js/auto_complete.js" type="text/javascript"></script>
<script src="/SPChallenge-portlet/js/filedrag.js" type="text/javascript"></script>

<script type="text/javascript">
var lowerVBrowser = '<%=renderRequest.getAttribute("lowerVBrowser") %>';
var logoError = '<%=renderRequest.getAttribute("logoError") %>';

var collabTypesProps = <%= renderRequest.getAttribute("collabTypesWithProps") %>; 

var namespace = '<portlet:namespace/>';
var challenge = <%=renderRequest.getAttribute("challenge")%>;
initializeAddChallenge('<%=resourceURL%>','<%=viewURL%>');
var ajaxUrl = '<%=resourceURL%>';
function cancel(){
	document.location.href = '<%=viewURL%>';
}
</script>
