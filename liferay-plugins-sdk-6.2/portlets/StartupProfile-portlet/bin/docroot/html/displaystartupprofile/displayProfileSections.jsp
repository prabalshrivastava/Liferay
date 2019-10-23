<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.startupprofile.StartupConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page trimDirectiveWhitespaces="true" %>
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

<%
	boolean showAdminSection = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
			|| SambaashUtil.isFoundryAdmin(themeDisplay.getUser())
			|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
	boolean orgEnableContactName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_CONTACT_NAME, StringPool.FALSE));
	String orgLabelContactName = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_CONTACT_NAME, ""));
	String orgLabelFaxNumber = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_FAX_NUMBER, ""));
	boolean orgEnableFaxNumber = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FAX_NUMBER, StringPool.FALSE));
	String orgLabelDesignation = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_DESIGNATION, ""));
	boolean orgEnableDesignation = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_DESIGNATION, StringPool.FALSE));
	String orgLabelPipelineStatus = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_PIPELINE_STATUS, ""));
	boolean orgEnablePipelineStatus = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PIPELINE_STATUS, StringPool.FALSE));
	String orgLabelBusinessDevManager = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_BUSINESS_DEV_MANAGER, ""));
	boolean orgEnableBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_BUSINESS_DEV_MANAGER, StringPool.FALSE));
	String orgLabelPrevBusinessDevManager = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_PREV_BUSINESS_DEV_MANAGER, ""));
	boolean orgEnablePrevBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER, StringPool.FALSE));
	boolean orgEnableFirstLastName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FIRST_LAST_NAME, StringPool.FALSE));
%>

 <section class="form form_1 animated active" form-name="form_1">

    <div class="formContent">

        <div class="formTextField fw">
            <div id="orgNameError"></div>
            <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q1")%></p>
            <aui:input name="organization_name" label=''>
            </aui:input>
        </div>


        <div class="formGroupfield fw">
            <div class="formGroupTitle"><span><p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q2" )%>'/></p></span>
            </div>
            <div class="formTextField fw">
            <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.address")%></p>
                <aui:input name="hq_name" label=''>
        
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street1" label="">
                   
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street2" label="">
                   
                </aui:input>
            </div>

            <div class="formTextField fw">
            <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.city")%></p>
                <aui:input name="hq_city" label=''>
                   
                </aui:input>
            </div>

            <div class="formTextField">
            <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.country")%></p>
                <aui:select name="hq_country" label='' showEmptyOption="true" required="true">
                    <% StartupFormHelper.createCountryDDOptions( "", renderRequest, out);%>
                </aui:select>
            </div>

            <div class="formTextField">
            <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.postalcode")%></p>
                <aui:input name="hq_postalCode" label=''>
                    
                </aui:input>
            </div>

        </div>

		<!-- new field (category multiselect) -->
		 <div class="formSelectField">
<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q3")%></p>
            <aui:select name="asset_orgCategoryList" label='' showEmptyOption="false" multiple="true"> 
            	<% FormHelper.createDropDownOptions( "orgCategoryList", "cats", renderRequest, out);%>
            </aui:select>
        </div>

		 <div class="formTextField">
		 <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q4")%></p>
            <aui:input name="organization_foundedOn" label=''>
                
            </aui:input>
        </div> 
        
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q5")%></p>
            <aui:input name="organization_description" type="textarea" label='' rows="6">
               
            </aui:input>
        </div>
        
<!--         <div class="formTextField fw"> -->
<%--             <aui:select name="asset_orgLifecycleStageId" label="label.q6" showEmptyOption="true"> --%>
<%--                 <% FormHelper.createDropDownOptions( "orgLifecycleStageList", "cats", renderRequest, out);%> --%>
<%--             </aui:select> --%>
<!--         </div> -->
        
        <div class="formGroupfield fw" id="fundingRoundContainer">
            <div class="formGroupTitle">
                <span><p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q7")%>' /></p></span>
            </div>
            <div class="formGroupfield fw" id="fundingRound1" data-identifier="fundingRoundId">
                <div class="formSubTitle">
                    <p><span><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.round")%></span></p>
                    <div class="multipleCTA">
                        <a href="javascript:;" class="addButton">+</a> <a href="javascript:;" class="removeButton">x</a>
                    </div>
                </div>
                <div class="formTextField fw">
                <p></p>
                    <aui:input name="fundingRound1_name" label=''>
                        
                    </aui:input>
                </div>
                <div class="formTextField fw">
                <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.info")%></p>
                    <aui:input name="fundingRound1_description" type="textarea" row="4" label=''>
                       
                    </aui:input>
                </div>
                <aui:input name="fundingRound1_fundingRoundId" type="hidden" />
            </div>
        </div>

        <div class="formTextField">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q8")%></p>
            <aui:input name="organization_totalFunds" label=''>
               
            </aui:input>
        </div>

<!--         <div class="formSelectField raising-funds"> -->
<%--             <aui:select name="asset_orgRaisingFundsId" label="label.q9" showEmptyOption="true"> --%>
<%--                 <% FormHelper.createDropDownOptions( "orgRaisingFundsList", "cats", renderRequest, out);%> --%>
<%--             </aui:select> --%>
<!--         </div> -->
        
    </div>
    

</section>

<section class="form form_2 animated" form-name="form_2">
    <span class="formTitle"><p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-contacts")%>' /></p></span>
    <div class="formContent">
            
       <% if (orgEnableFirstLastName){ %>
            <div class="formTextField">
                <aui:input name="organization_fname" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.firstname")%>'>
                </aui:input>
            </div>

            <div class="formTextField">
                <aui:input name="organization_lname" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.lastname")%>'>
                </aui:input>
            </div>
          <%} %>
    
    <% if (orgEnableContactName){ 
    	if (Validator.isNull(orgLabelContactName)){ 
    			orgLabelContactName = LabelUtil.getLabel(pageContext, themeDisplay, "label.q19");
    		}%>
    	<div class="formTextField fw">
            <aui:input name="organization_contactName" label='<%=orgLabelContactName%>'>
                
            </aui:input>
        </div>
        <%} %>
        
        <% if (orgEnableDesignation){ 
    	if (Validator.isNull(orgLabelDesignation)){ 
    			orgLabelDesignation = LabelUtil.getLabel(pageContext, themeDisplay, "label.q20");
    		}%>
        <div class="formTextField fw">
            <aui:input name="organization_contactDesignation" label='<%=orgLabelDesignation%>'>
                
            </aui:input>
        </div>
        <%} %>
    
    	<div class="formTextField fw">
    	<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q11")%></p>
            <aui:input name="organization_website" label=''>
                
            </aui:input>
        </div>
        
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q12")%></p>
            <aui:input name="organization_mobile" label=''>
               
            </aui:input>
        </div>
        
        <% if (orgEnableFaxNumber){ 
    	if (Validator.isNull(orgLabelFaxNumber)){ 
    			orgLabelFaxNumber = LabelUtil.getLabel(pageContext, themeDisplay, "label.q18");
    		}%>
        <div class="formTextField fw">
<p><%=orgLabelFaxNumber%></p>
            <aui:input name="organization_faxNumber" label=''>
               
            </aui:input>
        </div>
        <%} %>
 <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q13")%></p>
            <aui:input name="organization_emailId" label=''>
               
            </aui:input>
        </div>
        
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q14")%></p>
            <aui:input name="organization_twitter" label=''>
               
            </aui:input>
        </div>
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q15")%></p>
            <aui:input name="organization_linkedIn" label=''>
               
            </aui:input>
        </div>
        <div class="formTextField fw">
<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q15")%></p>
            <aui:input name="organization_linkedIn" label=''>
               
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_facebook" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q16")%>'>
                
            </aui:input>
        </div>

    </div>
 
</section>

<% if (showAdminSection) { %>

<section class="form form_21 animated" form-name="form_21">
    <span class="formTitle"><p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-admin-section")%>' /></p></span>
    <div class="formContent">
        <div class="formTextField">
 <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.stage")%></p>
            <aui:select name="organization_stage" label='' showEmptyOption="true">
              	 <% FormHelper.createJsonSelectOptions( "orgStageList", "orgStage", renderRequest, out);%>
            </aui:select>
        </div>
    
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology.type")%></p>
            <aui:select name="organization_methodologyType" label='' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgMethodologyTypeList", "methodologyCats", renderRequest, out);%> 
            </aui:select>
        </div>

        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology.subtype")%></p>
            <aui:select name="organization_methodologySubType" label='' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgMethodologySubTypeList", "methodologyCats", renderRequest, out);%> 
            </aui:select>
        </div>
        
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.feedback")%></p>
            <aui:input name="organization_feedback" type="textarea" row="4" label=''>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        
        
         <% if (orgEnablePipelineStatus){ 
    	if (Validator.isNull(orgLabelPipelineStatus)){ 
    		orgLabelPipelineStatus = LabelUtil.getLabel(pageContext, themeDisplay, "label.pipeline.status");
    		}%>
        <div class="formTextField fw">
            <aui:select name="organization_pipelineStatus" label='<%=orgLabelPipelineStatus%>' showEmptyOption="true">
              	 <% FormHelper.createJsonSelectOptions( "pipelineStatusList", "pipelineStatus", renderRequest, out);%>
            </aui:select>
        </div>
        <%} %>
        
        
        
        <% if (orgEnableBusinessDevManager){ 
    	if (Validator.isNull(orgLabelBusinessDevManager)){ 
    		orgLabelBusinessDevManager = LabelUtil.getLabel(pageContext, themeDisplay, "label.business.dev.manager");
    		}%>
        <div class="formTextField fw">
            <aui:select name="organization_businessDevManager" label='<%=orgLabelBusinessDevManager%>' showEmptyOption="true">
              	 <% FormHelper.createJsonSelectOptions( "businessDevManagerList", "businessDevManager", renderRequest, out);%>
            </aui:select>
        </div>
        <%} %>
        
        
         <% if (orgEnablePrevBusinessDevManager){ 
    	if (Validator.isNull(orgLabelPrevBusinessDevManager)){ 
    		orgLabelPrevBusinessDevManager = LabelUtil.getLabel(pageContext, themeDisplay, "label.prev.business.dev.manager");
    		}%>
        <div class="formTextField fw">
            <aui:select name="organization_prevBusinessDevManager" label='<%=orgLabelPrevBusinessDevManager%>' showEmptyOption="true">
              	 <% FormHelper.createJsonSelectOptions( "prevBusinessDevManagerList", "prevBusinessDevManager", renderRequest, out);%>
            </aui:select>
        </div>
         <%} %>

    </div>
    <div class="formCTA fw">
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>

</section>
<% } %>

<%
	if (canViewComment){
%>
	<%@ include file="/html/common/comments.jspf"  %>
<% 	
	}
%>

<section class="form form_3 animated" form-name="form_3">
	<span class="formTitle"><p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-assessment")%>' /></p></span>
    <div class="formContent">
		 <div class="formTextField fw">
		 <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques1")%></p>
            <aui:select name="questionnaire_answer1" label='' showEmptyOption="true">
               <% FormHelper.createDropDownOptions("orgBenchmarkList", "", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques2")%></p>
            <aui:input name="questionnaire_answer2" type="textarea" row="4" label=''>
                
            </aui:input>
        </div>
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques3")%></p>
            <aui:select name="questionnaire_answer3" label='' showEmptyOption="true">
               <% FormHelper.createDropDownOptions( "orgCostBenchmarkList", "", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques4")%></p>
            <aui:input name="questionnaire_answer4" type="textarea" row="4" label=''>
               
            </aui:input>
        </div>
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques5")%></p>
            <aui:input name="questionnaire_answer5" type="textarea" row="4" label=''>
              
            </aui:input>
        </div>
        <div class="formTextField fw">
        <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques6")%></p>
            <aui:input name="questionnaire_answer6" type="textarea" row="4" label=''>
              
            </aui:input>
        </div>
         <div class="formTextField fw">
         <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques7")%></p>
            <aui:input name="questionnaire_answer7" type="text" row="4" label=''>
               
            </aui:input>
        </div>
         <div class="formTextField fw">
         <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques8")%></p>
            <aui:input name="questionnaire_answer8" type="text" row="4" label=''>
                
            </aui:input>
        </div>
         <div class="formTextField fw">
         <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques9")%></p>
            <aui:input name="questionnaire_answer9" type="text" row="4" label=''>
              
            </aui:input>
        </div>
         <div class="formTextField fw">
         <p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques10")%></p>
            <aui:input name="questionnaire_answer10" type="text" row="4" label=''>
                
            </aui:input>
        </div>
        
        
	</div>
	 
</section>
					
