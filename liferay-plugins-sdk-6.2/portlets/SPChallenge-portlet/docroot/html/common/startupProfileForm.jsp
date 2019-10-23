<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<style>
.fwWidth50
{
    width:50%;
}
@media screen and (max-width: 667px) and (min-width: 320px)
{
.fwWidth50
{
    width:100%;
}
    
}
</style>

<section class="form form_1 animated active" form-name="form_1">

    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>' /></span>

    <div class="formContent">

        <div class="formTextField fw">
            <div id="orgNameError"></div>
            <aui:input name="organization_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q1")%>'>
                <aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.q1")%>'>
                    function (val, fieldNode, ruleValue) { if(val.length > 100) return false; return checkOrgName(); }
                </aui:validator>
                <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
            </aui:input>
        </div>

        <div class="formGroupfield fw">
            <div class="formGroupTitle"><span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q2")%>' /></span>
            </div>
            <div class="formTextField fw">
                <aui:input name="hq_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.address")%>'>
                    <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max100.characters")%>'>100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street1" label="">
                    <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max100.characters")%>'>100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street2" label="">
                    <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max100.characters")%>'>100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_city" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.city")%>'>
                    <aui:validator name="required" errorMessage="error.mandatory"></aui:validator>
                    <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max100.characters")%>'>100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField challenge">
                <aui:select name="hq_country" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.country")%>' showEmptyOption="true" required="true">
                    <% FormHelper.createCountryDDOptions("", renderRequest, out);%>
                </aui:select>
            </div>

            <div class="formTextField">
                <aui:input name="hq_postalCode" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.postalcode")%>'>
                    <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max8.characters")%>'>8</aui:validator>
                </aui:input>
            </div>

        </div>
        
        <div class="formSelectField">
            <aui:select id="multiSelectCategory" name="asset_orgCategoryList" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q3")%>' showEmptyOption="true" multiple="true"> 
            	<% FormHelper.createDropDownOptions("orgCategoryList", "cats", renderRequest, out);%> 
            </aui:select>
        </div>

		 <div class="formTextField">
            <aui:input type="date" name="organization_foundedOn" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q4")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max15.characters")%>'>15</aui:validator>
            </aui:input>
        </div> 
        
        <div class="formTextField fw">
            <aui:input name="organization_description" type="textarea" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q5")%>' rows="6">
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max3000.characters")%>'>3000</aui:validator>
            </aui:input>
        </div>
        
        <div class="formTextField fw">
            <aui:select name="asset_orgLifecycleStageId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q6")%>' showEmptyOption="true" >
                 <% FormHelper.createDropDownOptions( "orgLifecycleStageList", "cats", renderRequest, out);%>
            </aui:select>
        </div>
        
        <div class="formGroupfield fw" id="fundingRoundContainer">
            <div class="formGroupTitle">
                <span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q7")%>' /></span>
            </div>
            <div class="formGroupfield fw" id="fundingRound1" data-identifier="fundingRoundId">
                <div class="formSubTitle">
                    <span>Round</span>
                    <div class="multipleCTA">
                        <a href="javascript:;" class="addButton">+</a> <a href="javascript:;" class="removeButton">x</a>
                    </div>
                </div>
                <div class="formTextField fw">
                    <aui:input name="fundingRound1_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fundingrounds")%>'>
                        <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max100.characters")%>'>100</aui:validator>
                    </aui:input>
                </div>
                <div class="formTextField fw">
                    <aui:input name="fundingRound1_description" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.info")%>'>
                        <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
                    </aui:input>
                </div>
                <aui:input name="fundingRound1_fundingRoundId" type="hidden" />
            </div>
        </div>

        <div class="formTextField">
            <aui:input name="organization_totalFunds" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q8")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max20.characters")%>'>20</aui:validator>
            </aui:input>
        </div>

        <div class="formSelectField raising-funds">
            <aui:select name="asset_orgRaisingFundsId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q9")%>' showEmptyOption="true">
                 <% FormHelper.createDropDownOptions( "orgRaisingFundsList", "cats", renderRequest, out);%>
            </aui:select>
        </div>
        
        <!--have to provide user search and then add-->
        <div class="formTextField">
            <aui:input id="memberSearch" name="" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q10")%>' placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.type.search")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max20.characters")%>'>20</aui:validator>
            </aui:input>
            
            <div id="dropDown" class="hide">
				
			</div>
            
        </div>
        
        <div class="formGroupfield  fwWidth50" id="teamMemberContainer">
			<div class="formGroupfieldDummy formGroupfield fw hide" id="teamMember" data-identifier="memberId" style="padding: 0 20px 0px 20px; margin: 4px 0;background-color: #0066b3;color: #FFF;border-radius: 50px;">
				<div class="formSubTitle">
					<div>
						<img class="profileImage"  alt="image" src="" width="30px" height="30px" style="border-radius:30px;">
						<span class="memberFullName" style="padding: 0 0 0 10px;   color: #FFF;   vertical-align: middle;"></span>
						<aui:input class="memberId" name="teamMember_memberUserId" type="hidden" value="-1"></aui:input>
						<aui:input class="memberName" name="teamMember_name" type="hidden" value="-1"></aui:input>
						<aui:input class="memberImageUrl" name="teamMember_imageUrl" type="hidden" value="-1"></aui:input>
						<aui:input class="memberEmail" name="teamMember_emailId" type="hidden" value="-1"></aui:input>
					</div>
					<div class="multipleCTA">
						<a href="javascript:;" class="removeButton" style="padding: 6px; color: #fff;border-color: #fff;">x</a>
					</div>
				</div>
				
				<aui:input name="teamMember_memberId" type="hidden"></aui:input>
			</div>
		</div>
        
    </div>
    <div class="formCTA fw chlprfoileform1">
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>

</section>

<section class="form form_2 animated" form-name="form_2">
    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-contacts")%>' /></span>
    <div class="formContent">
    
    	<div class="formTextField fw">
            <aui:input name="organization_website" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q11")%>'>
                <aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.q11")%>'>
                    function (val, fieldNode, ruleValue) { if(val.length == 0) return true; if(val.length > 50) return false; return isValidURL(val); }
                </aui:validator>
                <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'></aui:validator>
            </aui:input>
        </div>
        
        <div class="formTextField fw">
            <aui:input name="organization_mobile" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q12")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max12.characters")%>'>12</aui:validator>
            </aui:input>
        </div>
        
        <div class="formTextField fw">
            <aui:input name="organization_emailId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q13")%>'>
                <aui:validator name="email" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.valide.email")%>'/>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_twitter" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q14")%>'>
                <aui:validator name="website" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.valid.websiteurl")%>'/>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_linkedIn" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q15")%>'>
                <aui:validator name="website" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.valid.websiteurl")%>'/>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_facebook" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q16")%>'>
                <aui:validator name="website" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.valid.websiteurl")%>'/>
            </aui:input>
        </div>

    </div>
    <div class="formCTA fw chlprfoileform1">
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>

</section>

<section class="form form_3 animated" form-name="form_3">
	<span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-assessment")%>' /></span>
    <div class="formContent">
		 <div class="formTextField fw">
            <aui:select name="questionnaire_answer1" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques1")%>' showEmptyOption="true">
            	 <% FormHelper.createDropDownOptions("orgBenchmarkList", "cats", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer2" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques2")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:select name="questionnaire_answer3" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques3")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgCostBenchmarkList", "cats", renderRequest, out);%> 
            </aui:select>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer4" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques4")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer5" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques5")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer6" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques6")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer7" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques7")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer8" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques8")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer9" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques9")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer10" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques10")%>'>
                <aui:validator name="maxLength" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.max5000.characters")%>'>5000</aui:validator>
            </aui:input>
        </div>
       
	
	</div>
	 <div class="formCTA fw chlprfoileform3">
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>
</section>