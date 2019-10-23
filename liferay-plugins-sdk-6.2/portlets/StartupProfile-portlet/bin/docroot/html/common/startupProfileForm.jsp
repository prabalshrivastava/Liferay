<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.startupprofile.StartupConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
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
<style>
	.yui3-aclist{
		z-index:10;
		height: 200px;
		overflow: auto;
	}
	
	#dropDown{
		width:95%;
		max-height:220px;
		overflow:auto;
		position:absolute;
		display:block;
		z-index:10;
		background-color:rgb(249,249,249);
		border:1px solid #0000FF;
	}
	
	#dropDown li{
		margin-bottom:2px solid rgb(249,249,249);
		padding:5px;
	}
	#dropDown li span{
		margin-left:10px;
	}
	#dropDown li:hover{
		background-color:#0000FF;
		color:#FFFFFF;
		cursor:pointer;
	}

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

<%
	boolean showAdminSection = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
			|| SambaashUtil.isFoundryAdmin(themeDisplay.getUser())
			|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
	String membersDisplayStyle = "", memberDisplayProperty="";
	boolean isMembersEnabled = false;
	try {
		isMembersEnabled = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_MEMBERS, StringPool.FALSE));
	} catch (Exception e) {
		e.printStackTrace();
	}
	memberDisplayProperty = (isMembersEnabled) ? "" : "display:none;";
	membersDisplayStyle = (isMembersEnabled) ? "" : "style='display:none'";
// 	System.out.println(">>>>>>>>>>>>>> membersDisplayStyle : "+membersDisplayStyle);
	
	String orgLabelContactName = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_CONTACT_NAME, ""));
	boolean orgEnableContactName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_CONTACT_NAME, StringPool.FALSE));
	boolean orgRequiredContactName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_CONTACT_NAME, StringPool.FALSE));
	String orgLabelFaxNumber = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_FAX_NUMBER, ""));
	boolean orgEnableFaxNumber = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FAX_NUMBER, StringPool.FALSE));
	boolean orgRequiredFaxNumber = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_FAX_NUMBER, StringPool.FALSE));
	String orgLabelDesignation = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_DESIGNATION, ""));
	boolean orgEnableDesignation = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_DESIGNATION, StringPool.FALSE));
	boolean orgRequiredDesignation = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_DESIGNATION, StringPool.FALSE));
	String orgLabelPipelineStatus = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_PIPELINE_STATUS, ""));
	boolean orgEnablePipelineStatus = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PIPELINE_STATUS, StringPool.FALSE));
	boolean orgRequiredPipelineStatus = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_PIPELINE_STATUS, StringPool.FALSE));
	String orgLabelBusinessDevManager = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_BUSINESS_DEV_MANAGER, ""));
	boolean orgEnableBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_BUSINESS_DEV_MANAGER, StringPool.FALSE));
	String orgLabelPrevBusinessDevManager = GetterUtil.getString(portletPreferences.getValue(StartupConstants.ORG_LABEL_PREV_BUSINESS_DEV_MANAGER, ""));
	boolean orgEnablePrevBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER, StringPool.FALSE));
	boolean orgRequiredBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_BUSINESS_DEV_MANAGER, StringPool.FALSE));
	boolean orgRequiredPrevBusinessDevManager = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_PREV_BUSINESS_DEV_MANAGER, StringPool.FALSE));
	boolean orgEnableFirstLastName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FIRST_LAST_NAME, StringPool.FALSE));
	boolean orgRequiredFirstLastName = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_REQUIRED_FIRST_LAST_NAME, StringPool.FALSE));
	
%>

<portlet:resourceURL var="resourceURL" />

 <section class="form form_1 animated active" form-name="form_1">

    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>' />
    <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceedFromTop" />
    </span>
	
    <div class="formContent">

        <div class="formTextField fw">
            <div id="orgNameError"></div>
            <aui:input name="organization_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q1")%>'>
                <aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.q1")%>'>
                    function (val, fieldNode, ruleValue) { if(val.length > 100) return false; return checkOrgName('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.get.user.info.refresh.page")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>'); }
                </aui:validator>
                <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
            </aui:input>
        </div>

        <div class="sp_tab_buttons">
            <nav>
                <ul class="text-center">
                    <li class="animated sp_tab_button active" id="sp_tab_1">
                        <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.logo")%>'/>
                    </li>
                    <li class="animated sp_tab_button" id="sp_tab_2">
                        <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cover")%>' />
                    </li>
                    <li class="animated sp_tab_button" id="sp_tab_3">
                        <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.showcase")%>' />
                    </li>
                </ul>
            </nav>
        </div>
        <div class="sp_tabs">
            <section class="sp_tab sp_tab_1 animated active" form-name="sp_tab_1">
                <div id="logoMainDiv-EditPage">
                    <aui:input type="file" name="startupLogo" accept="image/*" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile-logo")%>'>
                        <aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"please-upload-logo")%>'>
                            function (val, fieldNode, ruleValue) { var hasImg = false; AUI().use('aui-node','aui-base', function(A){ var src = A.one("#logoImg").getAttribute("src"); if(src != "") { hasImg = true; } }); if (hasImg || val.length != 0) { return true; } else { return false; } }
                        </aui:validator>
                    </aui:input>
                    <aui:input type='hidden' name='orgId'></aui:input>
                    <div id='logoDiv'>
                        <div id="filedraglogo" class="fd_container">
                            <div class="fdWrap">
                                <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"or-drop-image")%>' />
                            </div>
                            <div class='imageContainer'>
                                <img id="logoImg" src="${logoUrl}" style='max-width: 100%; max-height: 300px' alt="logo"/>
                            </div>
                        </div>
                    </div>
                    <div id="removoLogoDiv">
                        <a href="javascript:deleteFileEntry(0, 'logo');" id="removeLogoLink" class="h6" style="float: right">
                            <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"remove-logo")%>' />
                        </a>
                        <aui:input name="removeLogo" type="hidden"></aui:input>
                    </div>

                </div>
            </section>
            <section class="sp_tab sp_tab_2 animated" form-name="sp_tab_2">
                <div id="coverMainDiv-EditPage">
                    <aui:input type="file" name="startupCover" accept="image/*" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile-cover")%>'>
                    </aui:input>
                    <div id='coverDiv'>
                        <div id="filedragcover" class="fd_container">
                            <div class="fdWrap">
                                <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"or-drop-image")%>'/>
                            </div>
                            <div class='imageContainer'>
                                <img id="coverImg" src="${coverUrl}" style='max-width: 100%; max-height: 300px' alt="Cover Image"/>
                            </div>
                        </div>
                    </div>
                    <div id="removoCoverDiv">
                        <a href="javascript:deleteFileEntry(0, 'cover');" id="removeCoverLink" class="h6" style="float: right">
                            <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"remove-cover")%>' />
                        </a>
                        <aui:input name="removeCover" type="hidden"></aui:input>
                    </div>

                </div>
            </section>
            <section class="sp_tab sp_tab_3 animated" form-name="sp_tab_3">
                <div id="otherFilesMainDiv-EditPage">
                    <aui:input type="file" name="startupOtherFiles" accept="image/*" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile-other")%>' multiple="true">
                    </aui:input>
                    <div id='otherFilesDiv'>
                        <div id="filedragotherFiles" class="fd_container">
                            <div class="fdWrap">
                                <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"or-drop-image")%>' />
                            </div>
                            <div class='imageContainer'>
                                <img id="otherFilesImg" src="${otherFilesUrl}" style='max-width: 100%; max-height: 300px' alt="Other Files"/>
                            </div>
                        </div>
                    </div>
                    <div class="fileEntry hide" id="sampleFileEntry">
                        <div class="inline-block fileEntryImg"><img src="" alt="File Image"/>
                        </div>
                        <div class="inline-block fileEntryTitle"></div>
                        <div class="inline-block fileEntryCta">
                            <a href="javascript:deleteFileEntry(this)">
								<img src="<%=themeDisplay.getPathThemeImages()%>/userprofile/delete.png" alt="Delete"/></a>
                        </div>
                    </div>
                    <div id="otherFilesTable">

                    </div>
                </div>
         <div class="formGroupfield fw">
            <div class="formGroupTitle auto-fields-border"><span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.showcase.video.link")%>' /></span>                
			  <div id="video-url-fields">
			     <%
			     List<String> videoLinkList = (List<String>) renderRequest.getAttribute(StartupConstants.ORG_VIDEO_LINK_LIST);
			     if (videoLinkList!=null && videoLinkList.size()>0) {
			         for (int i = 0; i < videoLinkList.size(); i++) {
	                     String videoLink = videoLinkList.get(i);
	    		 %>
    			     <div class="lfr-form-row lfr-form-row-inline">
    			         <div class="row-fields">
    			           <div class="formTextField fw">
    			             <aui:input name="videoUrl"
    			                fieldParam='<%= "videoUrl" + i %>'
    			                label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.video.link")%>' value="<%=videoLink %>" onFocus="this.select()"
    			                inlineLabel="left" >
    			             	<aui:validator name="website" />
    			             </aui:input>
    			           </div>
    			        </div>
	    			 </div>
	    		 <%
			         }
			     } else {
			     %>
				  	<div class="lfr-form-row lfr-form-row-inline">
				      <div class="row-fields">
				       <div class="formTextField fw">
				        <aui:input fieldParam='videoUrl0' id='videoUrl0' name="videoUrl0" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.video.link")%>' onFocus="this.select()" >
				        	<aui:validator name="website" />
				        </aui:input>
				       </div>
				      </div>
				    </div>
			    <%	 
			     }
			    %>			  
			  </div>
			</div>
		</div>
            </section>
        </div>

        <div class="formGroupfield fw">
            <div class="formGroupTitle"><span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q2")%>' /></span>
            </div>
            <div class="formTextField fw">
                <aui:input name="hq_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.address")%>'>
                    <aui:validator name="maxLength">100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street1" label="">
                    <aui:validator name="maxLength">100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street2" label="">
                    <aui:validator name="maxLength">100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_city" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.city")%>'>
                    <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'></aui:validator>
                    <aui:validator name="maxLength">100</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField">
                <aui:select name="hq_country" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.country")%>' showEmptyOption="true" required="true">
                    <% FormHelper.createCountryDDOptions( "", renderRequest, out);%>
                </aui:select>
            </div>

            <div class="formTextField">
                <aui:input name="hq_postalCode" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.postalcode")%>'>
                    <aui:validator name="maxLength">8</aui:validator>
                </aui:input>
            </div>

        </div>

		<!-- new field (category multiselect) -->
		<%-- <div class="formSelectField">
            
            <div class="multiCategorySelectDiv">
   				 <ul class="level-1">
   				 	<% StartupFormHelper.createMultiSelectDropDownOptions("orgCategoryList", "cats", renderRequest, out);%>
   			 	 </ul>
			</div>
        </div> --%>
        
        <div class="formSelectField">

            <aui:select id="multiSelectCategory" name="asset_orgCategoryList" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q3")%>' showEmptyOption="false" multiple="true" required="true" >
            	<% FormHelper.createDropDownOptions( "orgCategoryList", "cats", renderRequest, out);%>
            </aui:select>
        </div>

        <div class="formGroupfield fw">
            <div class="formGroupTitle auto-fields-border"><span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.project.worked.on")%>' /></span>
			  <div id="projects-auto-fields">

			     <%
			     List<String> brandList = (List<String>) renderRequest.getAttribute(StartupConstants.ORG_BRAND_LIST);
			     List<String> projectList = (List<String>) renderRequest.getAttribute(StartupConstants.ORG_PROJECT_LIST);
			     List<Long> current_brand_list = new ArrayList<Long>();
			     if (brandList !=null && brandList.size()>0 && projectList.size()>0) {
			         for (int i = 0; i < brandList.size(); i++) {
	                     String brand = brandList.get(i);
	                     String project = projectList.get(i);
	                     if (current_brand_list.size()>0) {
	                    	 current_brand_list.set(0, Long.parseLong(brand));
	                     } else {
	                    	 current_brand_list.add(Long.parseLong(brand));
	                     }
	                     renderRequest.setAttribute("_current_brand", current_brand_list);
	    		 %>
				  	<div class="lfr-form-row lfr-form-row-inline">
				      <div class="row-fields">
				      	<div class="formTextField">
		                    <aui:select fieldParam='<%= "projBrand" + i %>'
		                    	name='<%= "projBrand" + i %>' 
		                    	id='<%= "projBrand" + i %>'
		                    	value="<%=brand %>" 
		                    	label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.project.brand")%>' showEmptyOption="true" >
	              	 			<% FormHelper.createDropDownOptions( StartupConstants.BRAND_LIST, "_current_brand", renderRequest, out);%> 
	            			</aui:select>
            			</div>
            			<div class="formTextField">
		                    <aui:input fieldParam='<%= "projName" + i %>' 
		                    	name='<%= "projName" + i %>' 
		                    	id='<%= "projName" + i %>'
		                    	value="<%=project %>"
		                    	label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.project.name")%>' placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.search.or.add.project")%>' >
				                <aui:validator name="maxLength">50</aui:validator>
				            </aui:input>
            			</div>
				      </div>
				    </div>
	    		 <%
			         }
			     } else {
			     %>
				  	<div class="lfr-form-row lfr-form-row-inline">
				      <div class="row-fields">
				      	<div class="formTextField">
		                    <aui:select fieldParam="projBrand0" id="projBrand0" name="projBrand0" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.project.brand")%>' showEmptyOption="true" >
	              	 			<% FormHelper.createDropDownOptions( StartupConstants.BRAND_LIST, "", renderRequest, out);%> 
	            			</aui:select>
            			</div>
            			<div class="formTextField">
		                    <aui:input fieldParam="projName0" id="projName0" name="projName0" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.project.name")%>' placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.search.or.add.project")%>' >
				                <aui:validator name="maxLength">50</aui:validator>
				            </aui:input>
            			</div>
				      </div>
				    </div>
			    <%	 
			     }
			    %>
			  
			  </div>
			</div>
		</div>
			
		 <div class="formTextField">
            <aui:input type="date" name="organization_foundedOn" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q4")%>' style="height: auto;">
                <aui:validator name="maxLength">15</aui:validator>
            </aui:input>
        </div> 
        
        <div class="formTextField fw">
            <aui:input name="organization_description" type="textarea" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q5")%>' rows="6">
                <aui:validator name="maxLength">3000</aui:validator>
            </aui:input>
            <label class="textarea-counter" style="float:right">0/500</label>
        </div>
        
<!--         <div class="formTextField fw"> -->
<%--             <aui:select name="asset_orgLifecycleStageId" label="label.q6" showEmptyOption="true" > --%>
<%--                 <% FormHelper.createDropDownOptions( "orgLifecycleStageList", "cats", renderRequest, out);%> --%>
<%--             </aui:select> --%>
<!--         </div> -->
        
        <div class="formGroupfield fw" id="fundingRoundContainer">
            <div class="formGroupTitle">
                <span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q7")%>' /></span>
            </div>
            <div class="formGroupfield fw" id="fundingRound1" data-identifier="fundingRoundId">
                <div class="formSubTitle">
                    <span>'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.round")%>'</span>
                    <div class="multipleCTA">
                        <a href="javascript:;" class="addButton">+</a> <a href="javascript:;" class="removeButton">x</a>
                    </div>
                </div>
                <div class="formTextField fw">
                    <aui:input name="fundingRound1_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fundingrounds")%>'>
                        <aui:validator name="maxLength">100</aui:validator>
                    </aui:input>
                </div>
                <div class="formTextField fw">
                    <aui:input name="fundingRound1_description" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.info")%>'>
                        <aui:validator name="maxLength">5000</aui:validator>
                    </aui:input>
                </div>
                <aui:input name="fundingRound1_fundingRoundId" type="hidden" />
            </div>
        </div>

        <div class="formTextField">
            <aui:input name="organization_totalFunds" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q8")%>'>
                <aui:validator name="maxLength">20</aui:validator>
            </aui:input>
        </div>

<!--         <div class="formSelectField raising-funds"> -->
<%--             <aui:select name="asset_orgRaisingFundsId" label="label.q9" showEmptyOption="true"> --%>
<%--                 <% FormHelper.createDropDownOptions( "orgRaisingFundsList", "cats", renderRequest, out);%> --%>
<%--             </aui:select> --%>
<!--         </div> -->
        
        <!--have to provide user search and then add-->
        <div class="formTextField" <%= membersDisplayStyle%> >
            <aui:input id="memberSearch" name="" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q10")%>' placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"Type & search")%>'>
                <aui:validator name="maxLength">20</aui:validator>
            </aui:input>
            
            <div id="dropDown" class="hide">
				
			</div>
            
        </div>
        
        <div class="formGroupfield fw stFormtagUI" id="teamMemberContainer" style="<%= memberDisplayProperty%> ">
			<div class="formGroupfieldDummy formGroupfield fw  hide" id="teamMember" data-identifier="memberId" style="padding: 0 20px 0px 20px; margin: 4px 0;">
				<div class="formSubTitle">
					<div>
						<img class="profileImage"  alt="image" src="" width="30px" height="30px" style="border-radius:30px;">
						<span class="memberFullName" style="padding: 0 0 0 10px;  vertical-align: middle;"></span>
						<aui:input class="memberId" name="teamMember_memberUserId" type="hidden" value="-1"></aui:input>
						<aui:input class="memberName" name="teamMember_name" type="hidden" value="-1"></aui:input>
						<aui:input class="memberImageUrl" name="teamMember_imageUrl" type="hidden" value="-1"></aui:input>
						<aui:input class="memberEmail" name="teamMember_emailId" type="hidden" value="-1"></aui:input>
					</div>
					<div class="multipleCTA">
						<a href="javascript:;" class="removeButton" style="padding: 6px;">x</a>
					</div>
				</div>
				
				<aui:input name="teamMember_memberId" type="hidden"></aui:input>
			</div>
		</div>

<!--         tags -->
		<div class="formGroupfield fw">
        <div class="formTextField">
            <aui:input id="tagSearch" name="" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.tags")%>' placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"Type & search")%>'>
                <aui:validator name="maxLength">20</aui:validator>
            </aui:input>
            <span class="btn-icon icon icon-plus" id="addTagBtn" style="display:none;"></span>
            <div id="tagsDropDown" class="hide">
				
			</div>
            <aui:input name="startupTag_tagIdList" type="hidden"></aui:input>
        </div>
        </div>
        
        <div class="formGroupfield  fwWidth50" id="startupTagContainer">
			<div class="formGroupfieldDummy formGroupfield fw hide" id="startupTag" data-identifier="tagId" style="padding: 0 20px 0px 20px; margin: 4px 0;background-color: #0066b3;color: #FFF;border-radius: 50px;">
				<div class="formSubTitle">
					<div>
						<span class="tagDisplayName" style="padding: 0 0 0 10px; color: #FFF; vertical-align: middle;"></span>
						<aui:input class="tagName" name="startupTag_tagName" type="hidden" value="-1"></aui:input>
					</div>
					<div class="multipleCTA">
						<a href="javascript:;" class="removeButton" style="padding: 6px; color: #fff;border-color: #fff;">x</a>
					</div>
				</div>
				
				<aui:input name="startupTag_tagId" type="hidden"></aui:input>
			</div>
		</div>
        
    </div>
    <div class="formCTA fw">
        <input type="button" id="form_1Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>

</section>

<section class="form form_2 animated" form-name="form_2">
    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-contacts")%>' />
    <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceedFromTop" />
    </span>
    <div class="formContent">
    
    	
    	<% if (orgEnableFirstLastName){	%>
            <div class="formTextField">
                <aui:input name="organization_fname" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.firstname")%>'>
                    <aui:validator name="maxLength">100</aui:validator>
                    <% if (orgRequiredFirstLastName){ %>
                    <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
                	<%} %>
                </aui:input>
            </div>

            <div class="formTextField">
                <aui:input name="organization_lname" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.lastname")%>'>
                    <aui:validator name="maxLength">100</aui:validator>
                    <% if (orgRequiredFirstLastName){ %>
                    <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
                	<%} %>
                </aui:input>
            </div>
          <%} %>
    
    	<% if (orgEnableContactName){
    		if (Validator.isNull(orgLabelContactName)){ 
    			orgLabelContactName = LabelUtil.getLabel(pageContext, themeDisplay, "label.q19");
    		}%>
    	<div class="formTextField fw">
            <aui:input name="organization_contactName" label='<%=orgLabelContactName%>'>
            <% if (orgRequiredContactName){ %>
            <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'></aui:validator>
            <%} %>
             </aui:input>
        </div>
        <%} %>
        
        
        <% if (orgEnableDesignation){
    		if (Validator.isNull(orgLabelDesignation)){ 
    			orgLabelDesignation = LabelUtil.getLabel(pageContext, themeDisplay, "label.q20");
    		}%>
        <div class="formTextField fw">
            <aui:input name="organization_contactDesignation" label='<%=orgLabelDesignation%>'>
            <% if (orgRequiredDesignation){ %>
            <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'></aui:validator>
            <%} %>
            </aui:input>
        </div>
        <%} %>
    
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
                <aui:validator name="maxLength">18</aui:validator>
            </aui:input>
        </div>
        
        <% if (orgEnableFaxNumber){
    		if (Validator.isNull(orgLabelFaxNumber)){ 
    			orgLabelFaxNumber = LabelUtil.getLabel(pageContext, themeDisplay, "label.q18");
    		}%>
        <div class="formTextField fw">
            <aui:input name="organization_faxNumber" label='<%=orgLabelFaxNumber%>'>
            <% if (orgRequiredFaxNumber){ %>
                <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'></aui:validator>
            <%} %>
            </aui:input>
        </div>
        <%} %>
        
        
        <div class="formTextField fw">
            <aui:input name="organization_emailId" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q13")%>'>
                <aui:validator name="email" />
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_twitter" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q14")%>'>
                <aui:validator name="website" />
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_linkedIn" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q15")%>'>
                <aui:validator name="website" />
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="organization_facebook" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q16")%>'>
                <aui:validator name="website" />
            </aui:input>
        </div>

    </div>
    <div class="formCTA fw">
        <input type="button" id="form_2Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>

</section>

<% if (showAdminSection) { %>

<section class="form form_21 animated" form-name="form_21">
    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-admin-section")%>' />
    <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceedFromTop" />
    </span>
    <div class="formContent">
        <div class="formSelectField fw">
            <aui:select name="asset_orgCollabStageList" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.stage")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgCollabStageList", "cats", renderRequest, out);%> 
            </aui:select>
        </div>
    
        <div class="formTextField fw">
            <aui:select name="organization_methodologyType" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology.type")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgMethodologyTypeList", "methodologyCats", renderRequest, out);%> 
            </aui:select>
        </div>

        <div class="formTextField fw">
            <aui:select name="organization_methodologySubType" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology.subtype")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgMethodologySubTypeList", "methodologyCats", renderRequest, out);%> 
            </aui:select>
        </div>
        
        <div class="formTextField fw">
            <aui:input name="organization_feedback" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.feedback")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>

        <div class="formTextField fw">
            <aui:select name="organization_showInBlackbook" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.display.in.blackbook")%>'>
              	 <option value="true"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.yes")%></option>
              	 <option value="false"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no")%></option>
            </aui:select>                   
         </div>
        
        <% if (orgEnablePipelineStatus){
    		if (Validator.isNull(orgLabelPipelineStatus)){ 
    			orgLabelPipelineStatus = LabelUtil.getLabel(pageContext, themeDisplay, "label.pipeline.status");
    		}%>
        <div class="formTextField fw">
          <aui:select name="organization_pipelineStatus" label='<%=orgLabelPipelineStatus%>' showEmptyOption="true" required='<%=orgRequiredPipelineStatus %>' id="organization_pipelineStatus">
              	 <% FormHelper.createJsonSelectOptions( "pipelineStatusList", "pipelineStatus", renderRequest, out);%> 
            </aui:select>
        </div>
        <%} %>
        
        <% if (orgEnableBusinessDevManager){
    		if (Validator.isNull(orgLabelBusinessDevManager)){ 
    			orgLabelBusinessDevManager = LabelUtil.getLabel(pageContext, themeDisplay, "label.business.dev.manager");
    		}%>
        <div class="formTextField fw">
            <aui:select name="organization_businessDevManager" label='<%=orgLabelBusinessDevManager%>' showEmptyOption="true" required='<%=orgRequiredBusinessDevManager %>' id="organization_businessDevManager">
              	 <% FormHelper.createJsonSelectOptions( "businessDevManagerList", "businessDevManager", renderRequest, out);%> 
            </aui:select>
        </div>
        <%} %>
        
        <% if (orgEnablePrevBusinessDevManager){
    		if (Validator.isNull(orgLabelPrevBusinessDevManager)){ 
    			orgLabelPrevBusinessDevManager = LabelUtil.getLabel(pageContext, themeDisplay, "label.prev.business.dev.manager");
    		}%>
        <div class="formTextField fw">
            <aui:select name="organization_prevBusinessDevManager" label='<%=orgLabelPrevBusinessDevManager%>' showEmptyOption="true" required='<%=orgRequiredPrevBusinessDevManager %>' id="organization_prevBusinessDevManager">
              	 <% FormHelper.createJsonSelectOptions( "prevBusinessDevManagerList", "prevBusinessDevManager", renderRequest, out);%> 
            </aui:select>
        </div>
        <%} %>
        
    </div>
    <div class="formCTA fw">
        <input type="button" id="form_21Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
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
	<span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-assessment")%>'/>
	<input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>'/>" class="proceedFromTop" />
	</span>
	<p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.self.assessment.warning")%>' /></p>	
    <div class="formContent">
		 <div class="formTextField fw">
            <aui:select name="questionnaire_answer1" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques1")%>' showEmptyOption="true">
            	<% FormHelper.createDropDownOptions("orgBenchmarkList", "", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer2" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques2")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:select name="questionnaire_answer3" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques3")%>' showEmptyOption="true">
              	<% FormHelper.createDropDownOptions( "orgCostBenchmarkList", "", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer4" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques4")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer5" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques5")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input name="questionnaire_answer6" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques6")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer7" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques7")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer8" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques8")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer9" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques9")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input name="questionnaire_answer10" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques10")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
       
	
	</div>
	 <div class="formCTA fw">
        <input type="button" id="form_3Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>
</section>
	
	<script>
	var submitError = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.submit")%>';
	var successMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.success")%>';
	var errorMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error")%>';
	var sessionTimeOut = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>';
	var thankUMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.thankyou.create.account")%>';
	var startupSaveFail = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fail.save.information.startup")%>';
	var nameLogo = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.name.logo")%>';
	var warningLabel = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.warning")%>';
	var deleteConfirm = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.are.you.sure.want.to.delete.it")%>';
	var removeError = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.remove")%>';
	var removeSuccess = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.successfully.removed")%>';
	var removeFailrefresh = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.remove.refresh.page")%>';
	var errorAddingUser = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.adding.user")%>';
	var maxAllowedChars = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.allowed.maximimum.tags")%>';
	var duplicateTag = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.duplicate.tag")%>';
	var orgEnablePipelineStatus = <%=Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PIPELINE_STATUS, StringPool.FALSE))%>;
	var orgEnableBusinessDevManager = <%=Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_BUSINESS_DEV_MANAGER, StringPool.FALSE))%>;
	var orgEnablePrevBusinessDevManager = <%=Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER, StringPool.FALSE))%>;
</script>
<script src="/StartupProfile-portlet/js/main.js" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/script.js" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/filedrag.js" type="text/javascript"></script>

<aui:script use="aui-base">
AUI().ready(function(A){
	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters',function (A) {
		A.one('#<portlet:namespace />memberSearch').on('keyup',function(e){
			var key=this.val();
			if(key.length>2){
				getUserList(key);
			}else{
				A.one("#dropDown").addClass('hide');
			}
			
		});
	});

	AUI().use('liferay-auto-fields','autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters','datasource','datasource-get','datatable-datasource', function(A) {
		var methodologyDropDown = A.one('#<portlet:namespace />organization_methodologyType');
		if (methodologyDropDown) {
			methodologyDropDown.on('change',function(e){
				A.io.request(ajax,{
					dataType: 'json',
					method: 'POST',
					data:{
						action:'getMethodologySubTypes',
						parentCategoryId: methodologyDropDown.val(),
						sp_p_auth: getAuthToken()
					},
					on: {
						success: function() {
							var methodologySubTypeDropDown = A.one('#<portlet:namespace />organization_methodologySubType');
							var options = this.get('responseData');
							methodologySubTypeDropDown.empty();
							for(var i=0;i<options.length;i++){
								var dropDownItem=A.Node.create('<option value="'+options[i].categoryId+'">'+options[i].name+'</option>');
								dropDownItem.appendTo(methodologySubTypeDropDown);
							}
						},
						failure:function(){
							if (console) console.log('failure');
						}
					}
				});		
			});		
		}

	    var videoAutoFields = new Liferay.AutoFields(
		       {
		           contentBox: '#video-url-fields',
		           fieldIndexes: '<portlet:namespace />videoLinkRowIndexes'
		       }
		   );
		  videoAutoFields.on(['clone', 'delete'], function(e) {
			  toggleFormDirty(true);
		  });
		 videoAutoFields.render();

		 var projectAutoFields = new Liferay.AutoFields(
		       {
		           contentBox: '#projects-auto-fields',
		           fieldIndexes: '<portlet:namespace />projectsRowIndexes'
		       }
		   );
		 projectAutoFields.on(['clone', 'delete'], function(e) {
			  if (e.type === 'autofields:clone') {
				  var curNodeId = e.row._node.id;
				  var inputNode = AUI().one('#' + curNodeId +' input')._node.id;
				  initAutoCompleteFormField(AUI(), inputNode);
			  }
			  toggleFormDirty(true);
		 });
		 projectAutoFields.render(); 
		 var projNodeArr = AUI().all('#projects-auto-fields .lfr-form-row:visible input').get('id');
		 for (var i=0; i<projNodeArr.length; i++) {
			 var inputNode = projNodeArr[i];
			 if (inputNode && inputNode !== '') {
				 initAutoCompleteFormField(AUI(), inputNode);
			 }
		 }
			 
		var tagInputNode = A.one('#'+namespace+'tagSearch');
		var tagInputNodeId = tagInputNode._node.id;
		initAutoCompleteFormField(A, tagInputNodeId, 'get_tags', 
			function (e) {
				addAssetTag(e.result.raw.categoryId+":"+e.result.raw.name);
				tagInputNode.val('');
				toggleFormDirty(true);
			}
		);
		var addTagBtnNode = A.one('#addTagBtn');
		addTagBtnNode.on('click', function(e) {
			console.log('adding new tag');
			var newTag = tagInputNode.val();
			if (newTag && newTag !== '') {
				addAssetTag(newTag+":"+newTag);
				tagInputNode.val('');
				toggleFormDirty(true);
			}
		  });
		<%
		try {
		    List<String> tagsList = (List<String>) renderRequest.getAttribute(StartupConstants.ORG_TAG_LIST);
		for(String tagKeyData: tagsList) {
		%>
			addAssetTag('<%=tagKeyData%>');
		<%}
		} catch (Exception e) {}%>
	});

	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters',function (A) {
		A.all('select option[value=""]').html('<liferay-ui:message key="label.select.one.option" />');
		
		var descField = A.one('#'+namespace+'organization_description');
		descField.on('keyup',function(e){
			A.one('.textarea-counter').html(''+ this.val().length +'/500');			
		});
	});
	
	A.one('#'+namespace+'multiSelectCategory').setAttribute('onmouseover', "Liferay.Portal.ToolTip.show(this, '<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.select.multiple.tooltip")%>' />')");
	A.one('#'+namespace+'organization_description').setAttribute('onmouseover', "Liferay.Portal.ToolTip.show(this, '<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.description.tooltip")%>' />')");
});
</aui:script> 

