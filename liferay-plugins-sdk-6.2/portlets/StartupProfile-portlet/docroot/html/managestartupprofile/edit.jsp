<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessStage"%>
<%@page import="com.sambaash.platform.startupprofile.helper.StartupFormHelper"%>
<%@page import="com.sambaash.platform.startupprofile.StartupConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil" %>
<%@page import="com.sambaash.platform.constant.SambaashConstants" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="com.sambaash.platform.util.SambaashUtil" %>
<%@page import="com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
boolean orgEnableMembers = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_MEMBERS, StringPool.FALSE));
boolean orgEnableContactName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_CONTACT_NAME, StringPool.FALSE));
boolean orgRequiredContactName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_CONTACT_NAME, StringPool.FALSE));
boolean orgEnableFirstLastName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FIRST_LAST_NAME, StringPool.FALSE));
boolean orgRequiredFirstLastName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_FIRST_LAST_NAME, StringPool.FALSE));
boolean orgEnableFaxNumber = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FAX_NUMBER, StringPool.FALSE));
boolean orgRequiredFaxNumber = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_FAX_NUMBER, StringPool.FALSE));
boolean orgEnableDesignation = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_DESIGNATION, StringPool.FALSE));
boolean orgEnableATO = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_ATO, StringPool.FALSE));
boolean orgEnablePrinciple1 = Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple1", StringPool.FALSE));
boolean orgEnablePrinciple2 = Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple2", StringPool.FALSE));
boolean orgEnablePrinciple3 = Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple3", StringPool.FALSE));
boolean orgEnablePrinciple4 = Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple4", StringPool.FALSE));
boolean orgEnablePrinciple5 = Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple5", StringPool.FALSE));
boolean orgEnablePrinciple6 = Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple6", StringPool.FALSE));

boolean orgRequiredDesignation = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_DESIGNATION, StringPool.FALSE));
boolean orgEnablePipelineStatus = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PIPELINE_STATUS, StringPool.FALSE));
boolean orgRequiredPipelineStatus = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_PIPELINE_STATUS, StringPool.FALSE));
boolean orgEnableBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_BUSINESS_DEV_MANAGER, StringPool.FALSE));
boolean orgRequiredBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_BUSINESS_DEV_MANAGER, StringPool.FALSE));
boolean orgEnablePrevBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER, StringPool.FALSE));
boolean orgRequiredPrevBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_PREV_BUSINESS_DEV_MANAGER, StringPool.FALSE));

boolean canViewAssesment = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_STARTUP_EVALUATION, StringPool.FALSE));
boolean canViewCorporate = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_CORPORATE, StringPool.FALSE));
boolean canViewHeadquater = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_HEADQUATER, StringPool.FALSE));
boolean canViewProjects = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PROJECTS, StringPool.FALSE));
boolean canViewFunding = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FUNDING, StringPool.FALSE));
boolean canViewAddress = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_ADDRESS, StringPool.FALSE));
boolean canViewOldContact = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_OLD_CONTACT, StringPool.FALSE));
boolean canViewNewContact = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_NEW_CONTACT, StringPool.FALSE));

boolean canViewPrinciple1 = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PRINCIPLE1, StringPool.FALSE));
boolean canViewPrinciple2 = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PRINCIPLE2, StringPool.FALSE));
boolean canViewPrinciple3	 = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PRINCIPLE3, StringPool.FALSE));
boolean canViewPrinciple4 = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PRINCIPLE4, StringPool.FALSE));

boolean isDocumentsMandatory = Boolean.valueOf(portletPreferences.getValue("isDocumentsMandatory", StringPool.TRUE));


List<User> userList = UserLocalServiceUtil.getRoleUsers(GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.SALES_AGENT_ROLE_ID, 0)));
List<PEProcessStage> processStageList = PEProcessStageLocalServiceUtil.getPEProcessStages(-1, -1);

String selectNamePrevBusinessDevManager = StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST;
String selectNameBusinessDevManager = StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST;
String selectNamePipelineStatus = StartupConstants.ORG_PIPELINE_STATUS_LIST;
String selectedPrevBusinessDevManager = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_PREV_BUSINESS_DEV_MANAGER_LIST, ""));
String selectedBusinessDevManager = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_BUSINESS_DEV_MANAGER_LIST, ""));
String selectedPipelineStatus = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_PIPELINE_STATUS_LIST, ""));
pageContext.setAttribute("selected", selectedPrevBusinessDevManager);
pageContext.setAttribute("selected", selectedBusinessDevManager);
pageContext.setAttribute("selected", selectedPipelineStatus);
%>

<div class="sp-startup-profile-add-preference block max-width padding-left-75 padding-right-75 box-sizing-border full-width padding-top-one padding-bottom-one">
<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">

	
	<h2><liferay-ui:message key="select-startup-sections" /></h2>
	<aui:fieldset>
	<div class="startup-create-prefrences">
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableAssesment")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableStartupEvaluation" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewAssesment%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableCorporate")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableCorporate" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewCorporate%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableHeadquater")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableHeadquater" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewHeadquater%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableProjects")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableProjects" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewProjects%>" />
				</div>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableFunding")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableFunding" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewFunding%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableAddress")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableAddress" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewAddress%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableOldContact")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableOldContact" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewOldContact%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableNewContact")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableNewContact" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewNewContact%>" />
				</div>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableATO")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnableATO" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnableATO%>" />
				</div>
			</aui:col>
			
		</aui:row>
		
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enablePrinciple1")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple1" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrinciple1%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enablePrinciple2")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple2" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrinciple2%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enablePrinciple3")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple3" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrinciple3%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enablePrinciple4")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple4" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrinciple4%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enablePrinciple5")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple5" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrinciple5%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enablePrinciple6")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple6" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrinciple6%>" />
				</div>
			</aui:col>
			
		</aui:row>
		
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableFunding")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple1" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewPrinciple1%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableAddress")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple2" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewPrinciple2%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableOldContact")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple3" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewPrinciple3%>" />
				</div>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.enableNewContact")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="orgEnablePrinciple4" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=canViewPrinciple4%>" />
				</div>
			</aui:col>
		</aui:row>
	</aui:fieldset>
	
	
	<aui:fieldset>
	<aui:row>
			
			<aui:col span="3" cssClass="choices formio-choices">
				<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.isDocumentsMandatory")%></span>
				<div class="startup-create-prefrences-fields">
				<aui:input name="isDocumentsMandatory" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=isDocumentsMandatory%>" />
				</div>
			</aui:col>
		</aui:row>
	</aui:fieldset>
	
	
	
	<h2><liferay-ui:message key="select-startup-vocabs" /></h2>

	<aui:fieldset>
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgCorporateTypeVocId"
					label="select-corporate-type-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgCorporateTypeVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgCorporateCategoryVocId" label="select-corporate-category-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgCorporateCategoryVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />  
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgSalutationVocId" label="select-corporate-salutation-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgSalutationVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgBenchmarkVocId" label="select-startup-benchmark-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgBenchmarkVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
				
			</aui:col>
			
		</aui:row>
		
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgCollabStageVocId" label="select-startup-collab-stage-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgCollabStageVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
				
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgLifecycleStageVocId"
					label="select-startup-lifesyle-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgLifecycleStageVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgRaisingFundsVocId"
					label="select-startup-raising-funds-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgRaisingFundsVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgIncorporatedVocId" label="select-startup-incorp-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgIncorporatedVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			
		</aui:row>
	
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
					<aui:select name="orgCostBenchmarkVocId" label="select-startup-benchmark-cost-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgCostBenchmarkVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
			
				<aui:select name="orgMethodologyVocId"
					label="select-startup-methodology-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgMethodologyVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgBrandVocId" label="select-startup-brand-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgBrandVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgProjectsVocId" label="select-startup-project-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgProjectsVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			
		</aui:row>
		
		<aui:row>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgTagsVocId" label="select-startup-tags-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgTagsVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			<aui:col span="3" cssClass="choices formio-choices">
				<aui:select name="orgCategoryVocId" label="select-startup-categ-vocab">
					<c:forEach var="assetVocabulary" items="${assetVocabularies}">
						<aui:option value="${assetVocabulary.vocabularyId}"
							selected="${orgCategoryVocId == assetVocabulary.vocabularyId}"
							label="${assetVocabulary.name}" />
					</c:forEach>
				</aui:select>
			</aui:col>
			
		</aui:row>
		

		<aui:input name="startupCreatePage" label="startup-create-url" value="${startupCreatePage}"></aui:input>
		
		<aui:input name="startupDisplayPage" label="startup-display-url" value="${startupDisplayPage}"></aui:input>
		
		<aui:input name="iframe_web_protocol" label="label.iframe.protocol" value="${iframe_web_protocol}"></aui:input>
		
		<aui:input name="commentDisplayDateFormat" label="label.comment.displayDate.format" value="${commentDisplayDateFormat}"></aui:input>

		<aui:input name="orgEnableMembers" type="checkbox" inlineLabel="right" label="label.org.enable.members" inlineField="<%= true %>" value="<%=orgEnableMembers%>" />
		<%@ include file="/html/managestartupprofile/edit-rating.jsp" %>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.first.last.name")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgEnableFirstLastName" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnableFirstLastName%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredFirstLastName" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredFirstLastName%>" /></div>
		</div>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.contact.name")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgLabelContactName" label="label" value="${orgLabelContactName}"></aui:input></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgEnableContactName" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnableContactName%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredContactName" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredContactName%>" /></div>
		</div>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fax.number")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgLabelFaxNumber" label="label" value="${orgLabelFaxNumber}"></aui:input></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgEnableFaxNumber" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnableFaxNumber%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredFaxNumber" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredFaxNumber%>" /></div>
		</div>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.designation")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgLabelDesignation" label="label" value="${orgLabelDesignation}"></aui:input></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgEnableDesignation" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnableDesignation%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredDesignation" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredDesignation%>" /></div>
		</div>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.pipeline.status")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgLabelPipelineStatus" label="label" value="${orgLabelPipelineStatus}"></aui:input></div>
		<div class="startup-create-prefrences-fields">
			<aui:select name="<%=selectNamePipelineStatus%>" label="label.select" multiple="true" cssClass="width-30" style="height: 120px;">
			<%for(PEProcessStage stage : processStageList) { %>
				<c:set var="isselected" value="false"></c:set>
				<% if(selectedPipelineStatus.contains(String.valueOf(stage.getSpPEProcessStageId()))) { %>
					<c:set var="isselected" value="true"></c:set>
				<% } %>
				<aui:option label="<%=stage.getName() %>" value="<%=stage.getSpPEProcessStageId() %>" selected="${isselected}"></aui:option>
			<%}%>
			</aui:select>
		</div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgEnablePipelineStatus" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePipelineStatus%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredPipelineStatus" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredPipelineStatus%>" /></div>
		</div>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.business.dev.manager")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgLabelBusinessDevManager" label="label" value="${orgLabelBusinessDevManager}"></aui:input></div>
		<div class="startup-create-prefrences-fields">
			<aui:select name="<%=selectNameBusinessDevManager%>" label="label.select" multiple="true" cssClass="width-30" style="height: 120px;">
			<%for(User user1 : userList) { %>
				<c:set var="isselected" value="false"></c:set>
				<% if(selectedBusinessDevManager.contains(String.valueOf(user1.getUserId()))) { %>
					<c:set var="isselected" value="true"></c:set>
				<% } %>
				<aui:option label="<%=user1.getFullName() %>" value="<%=user1.getUserId() %>" selected="${isselected}"></aui:option>
			<%}%>
			</aui:select>
		</div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgEnableBusinessDevManager" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnableBusinessDevManager%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredBusinessDevManager" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredBusinessDevManager%>" /></div>
		</div>
		
		<div class="startup-create-prefrences">
		<span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.prev.business.dev.manager")%></span>
		<div class="startup-create-prefrences-fields"><aui:input name="orgLabelPrevBusinessDevManager" label="label" value="${orgLabelPrevBusinessDevManager}"></aui:input></div>
		<div class="startup-create-prefrences-fields">
			<aui:select name="<%=selectNamePrevBusinessDevManager%>" label="label.select" multiple="true" cssClass="width-30" style="height: 120px;">
			<%for(User user1 : userList) { %>
				<c:set var="isselected" value="false"></c:set>
				<% if(selectedPrevBusinessDevManager.contains(String.valueOf(user1.getUserId()))) { %>
					<c:set var="isselected" value="true"></c:set>
				<% } %>
				<aui:option label="<%=user1.getFullName() %>" value="<%=user1.getUserId() %>" selected="${isselected}"></aui:option>
			<%}%>
			</aui:select>
		</div>

		<div class="startup-create-prefrences-fields"><aui:input name="orgEnablePrevBusinessDevManager" type="checkbox" inlineLabel="right" label="label.enable" inlineField="<%= true %>" value="<%=orgEnablePrevBusinessDevManager%>" /></div>
		<div class="startup-create-prefrences-fields"><aui:input name="orgRequiredPrevBusinessDevManager" type="checkbox" inlineLabel="right" label="label.required" inlineField="<%= true %>" value="<%=orgRequiredPrevBusinessDevManager%>" /></div>
		</div>
		
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="label.save" />
		<aui:button type="cancel" onClick="<%=viewURL%>" />
	</aui:button-row>
</aui:form>
</div>