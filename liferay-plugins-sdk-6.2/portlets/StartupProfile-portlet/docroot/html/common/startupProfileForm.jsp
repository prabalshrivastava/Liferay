<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.startupprofile.model.ATODocument"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.startupprofile.StartupConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.model.StrartupProfileBean"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="com.sambaash.platform.startupprofile.helper.StartupFormHelper"%>
<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.sambaash.platform.srv.startupprofile.model.Principles"%>
<%@page import="com.sambaash.platform.srv.startupprofile.model.ApprovedMentors"%>
<%@page import="com.sambaash.platform.srv.startupprofile.model.SPATOContacts"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>

<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>


<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.List"%>

<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@page import="java.lang.reflect.Method"%>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>


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
#drop_zone {
  border: 5px solid blue;
  width:  200px;
  height: 100px;
}
.search_icon{
	padding:5px;
}
.search_icon img {
	width: 20px;
}
.search_icon label {
	padding-left:10px;
	display: inline-block;
}
.yui3-aclist{
	width: 81%;
	z-index: 99999;
}
.sel-list-name {
    display: inline-block;
    width: 170px;
}
.sel-list-remove {
    display: inline-block;
}
.selWrap{
	display: inline-block;
    border-radius: 20px;
    padding: 3px 8px;
    margin: 0px 5px;
}
.row-fluid {
    font-size: 12px !important;
}
.SelectedMentors{
	margin-bottom: 6px;
}
.ra-upload-label{
	display: inline-block !important;
    padding-left: 10px;
}
.ra-upload-label i{
	color:#118ade;
	font-style:normal;
}
.ra-upload input[type="file"] {
    width: 100%;
    opacity: 1;
    padding: 0px !important;
    border: 0px !important;
}
.ra-upload {
	position:relative;
	padding:10px;
	box-sizing:border-box;
	border: 1px dashed #bbbbbb;
    border-radius: 3px;
    background-color: #f9fafc;
}
.ra-upload .control-group {
    display: inline-block;
    width: 100%;
    position: absolute;
    left: 0px;
    top:0px;
    opacity: 0;
}
.file-name{
	width:98%;
}
.file-name label {
    color: #ffffff;
    background-color: red;
    border-radius: 50%;
    display: inline-block;
    float: right;
    font-weight: bolder !important;
    width: 18px;
    height: 18px;
    vertical-align: top;
    text-align: center !important;
    font-size: 10px;
    clear: right;
}
.display_none{
	display: none !important ;
}
</style>

<%
List<StrartupProfileBean> dd = SambaashUtil.getUserStartupProfiles(themeDisplay);
	boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
	boolean showAdminSection = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
			|| SambaashUtil.isFoundryAdmin(themeDisplay.getUser())
			|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
	String membersDisplayStyle = "", memberDisplayProperty="";
	boolean isMembersEnabled = false;
	try {
		isMembersEnabled = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_MEMBERS, StringPool.FALSE));
	} catch (Exception e) {
		_log.error(e.getMessage());
	}
	memberDisplayProperty = (isMembersEnabled) ? "" : "display:none;";
	membersDisplayStyle = (isMembersEnabled) ? "" : "style='display:none'";

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
	
	boolean orgEnabledCorporate = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_CORPORATE, StringPool.FALSE)); 
	boolean orgEnabledHeadQuater = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_HEADQUATER, StringPool.FALSE));
	boolean orgEnabledProjects = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_PROJECTS, StringPool.FALSE));
	boolean orgEnabledFunding = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_FUNDING, StringPool.FALSE));
	boolean orgEnabledAddresses = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_ADDRESS, StringPool.FALSE));
	boolean orgEnableOldContact = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_OLD_CONTACT, StringPool.FALSE));
	boolean orgEnableNewContact = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_NEW_CONTACT, StringPool.FALSE));
	boolean orgEnabledTags = false;
	
	boolean enabledPriciple1 =  Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple1", StringPool.FALSE));
	boolean enabledPriciple2 =  Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple2", StringPool.FALSE));
	boolean enabledPriciple3 =  Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple3", StringPool.FALSE));
	boolean enabledPriciple4 =  Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple4", StringPool.FALSE));
	boolean enabledPriciple5 =  Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple5", StringPool.FALSE));
	boolean enabledPriciple6 =  Boolean.valueOf(portletPreferences.getValue("orgEnablePrinciple6", StringPool.FALSE));
	boolean isDocumentsMandatory = Boolean.valueOf(portletPreferences.getValue("isDocumentsMandatory", StringPool.TRUE));
	
	pageContext.setAttribute("enabledPriciple1", enabledPriciple1);
	pageContext.setAttribute("enabledPriciple2", enabledPriciple2);
	pageContext.setAttribute("enabledPriciple3", enabledPriciple3);
	pageContext.setAttribute("enabledPriciple4", enabledPriciple4);
	pageContext.setAttribute("enabledPriciple5", enabledPriciple5);
	pageContext.setAttribute("enabledPriciple6", enabledPriciple6);
%>
<script>

var enabledPriciple1 = <%= enabledPriciple1 %>;
var enabledPriciple2 = <%= enabledPriciple2 %>;
var enabledPriciple3 = <%= enabledPriciple3 %>;
var enabledPriciple4 = <%= enabledPriciple4 %>;
var enabledPriciple5 = <%= enabledPriciple5 %>;
var enabledPriciple6 = <%= enabledPriciple6 %>;
var isDocumentsMandatory = <%= isDocumentsMandatory %>;

var userId = <%= themeDisplay.getUserId() %>;


</script>
<portlet:resourceURL var="resourceURL" />

<portlet:resourceURL var="ajaxresourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
	<portlet:param name="action" value="uploadDoc" />
</portlet:resourceURL>

 <section class="form form_1 animated active" form-name="form_1">

    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>' />
    <input type="button" style="display:none" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceedFromTop" />
    </span>
	
    <div class="formContent">

        <div class="formTextField fw">
            <div id="orgNameError"></div> 
            <aui:row>
			<aui:col span="6" cssClass="choices formio-choices">
		
             <aui:input name="organization_uen" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.uen")%>' placeholder="Enter number">
            
             <aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.uen")%>' >
                    function (val, fieldNode, ruleValue) { if(val.length > 100) return false; return checkOrgUEN('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.get.user.info.refresh.page")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>'); }
                </aui:validator>
             <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
            </aui:input>           
            </aui:col>
            <aui:col span="6" cssClass="choices formio-choices">
            <aui:input name="organization_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q1")%>'>
                <aui:validator name="custom" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.q1")%>'>
                    function (val, fieldNode, ruleValue) { if(val.length > 100) return false; return checkOrgName('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.get.user.info.refresh.page")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>'); }
                </aui:validator>
                <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
            </aui:input>
            </aui:col>
            </aui:row>
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
                    <aui:input type="file" width="100%" name="startupLogo" accept="image/*" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile-logo")%>'>
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
                                <img id="logoImg" src="<%=request.getContextPath() + "/images/uploading.png"%>" style='max-width: 100%; max-height: 300px' alt="logo"/>
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
                                <img id="coverImg" src="<%=request.getContextPath() + "/images/uploading.png"%>" style='max-width: 100%; max-height: 300px' alt="Cover Image"/>
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
                                <img id="otherFilesImg" src="<%=request.getContextPath() + "/images/uploading.png"%>" style='max-width: 100%; max-height: 300px' alt="Other Files"/>
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


		<% if (orgEnabledCorporate){ %>
		<div class="formGroupfield fw">
         <!--  <div class="formGroupTitle">
            </div> -->  
            <aui:row>
				<aui:col span="6" cssClass="choices formio-choices">
		            <div class="formTextField fw">
		                <aui:select name="organization_corporateType" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.corporate_type")%>' showEmptyOption="true">
			            	<% FormHelper.createDropDownOptions("orgCorporateTypeList", "", renderRequest, out);%>
			            </aui:select>
		            </div>
				</aui:col>
				<aui:col span="6" cssClass="choices  formio-choices">
		            <div class="formTextField fw">
		                 <aui:select name="organization_corporateCategory" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.corporate_category")%>' showEmptyOption="true">
			            	<% FormHelper.createDropDownOptions("orgCorporateCategoryList", "", renderRequest, out);%>
			            </aui:select>
		            </div>
				</aui:col> 
			</aui:row>
			<aui:row>
				<aui:col span="6" cssClass="choices formio-choices">
		            <div class="formTextField fw">
		               <aui:input type="date" name="organization_foundedOn" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q4")%>' style="height: auto;">
			                <aui:validator name="maxLength">15</aui:validator>
			           </aui:input>
		            </div>
				</aui:col>
				<aui:col span="6" cssClass="choices  formio-choices">
		            <div class="formTextField fw">
		                <aui:input name="organization_website" placeholder="Enter URL (Eg: www.websitename.com)" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.website")%>'>
		                    <aui:validator name="maxLength">200</aui:validator>
		                </aui:input>
		            </div>
		            </aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6" cssClass="choices formio-choices">
		            <div class="formTextField fw">
		               <aui:input name="organization_mobile" placeholder="Enter Phone Number (Eg: +65 6876 5432)" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.telephoneNo")%>' >
			                <aui:validator name="maxLength">15</aui:validator>
			           </aui:input>
		            </div>
				</aui:col>
				<aui:col span="6" cssClass="choices  formio-choices">
		            <div class="formTextField fw">
		                <aui:input name="organization_faxNumber" placeholder="Enter Fax Number (Eg: +65 6876 5432)" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q18")%>'>
		                    <aui:validator name="maxLength">15</aui:validator>
		                </aui:input>
		            </div>
		            </aui:col>
			</aui:row>
			<aui:row>
				<aui:input cssClass="textarea" name="organization_description"  placeholder="Background Info" type="textarea" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q5")%>' rows="6">
	                <aui:validator name="maxLength">3000</aui:validator>
	            </aui:input>
	            <label class="textarea-counter" style="float:right">0/501</label>
			</aui:row>
        </div>
		<% } %>

		
		<% if (orgEnabledHeadQuater){  %>
        <div class="formGroupfield fw">
            <div class="formGroupTitle"><span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q2")%>' /></span>
            </div>
            <div class="formTextField fw">
            	<span></span>
                <aui:input name="hq_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.address")%>'>
                    <aui:validator name="maxLength">200</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street1" label="">
                    <aui:validator name="maxLength">200</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_street2" label="">
                    <aui:validator name="maxLength">200</aui:validator>
                </aui:input>
            </div>

            <div class="formTextField fw">
                <aui:input name="hq_city" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.city")%>'>
                    <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>'></aui:validator>
                    <aui:validator name="maxLength">200</aui:validator>
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
       <% } %>

        <% if (orgEnabledProjects){ %>
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
		
		<% } %>
			
		

          <% if (orgEnabledFunding){ %>
        <div class="formGroupfield fw" id="fundingRoundContainer">
            <div class="formGroupTitle">
                <span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q7")%>' /></span>
            </div>
            <div class="formGroupfield fw" id="fundingRound1" data-identifier="fundingRoundId">
                <div class="formSubTitle">
                    <h3>'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.round")%>'</h3>
                    <div class="multipleCTA">
                        <a href="javascript:;" class="addButton">+</a> <a href="javascript:;" class="removeButton btn removeBtn">Remove</a>
                    </div>
                </div>
                <div class="formTextField fw">
                    <aui:input name="fundingRound1_name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fundingrounds")%>'>
                        <aui:validator name="maxLength">200</aui:validator>
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
        
        <% } %>
        
        
        
          <% if (orgEnabledAddresses){ %>
        <div class="formGroupfield fw" id="addressContainer">
            <div class="formGroupTitle">
                <h3><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.addresses")%>' /></h3>
            </div>
            <div class="formGroupfield fw" id="address1" data-identifier="addressId">
                <div class="formSubTitle">
                    <h3><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.address")%></h3>
                    <div class="multipleCTA">
                        <a href="javascript:;" class="removeButton btn removeBtn">Remove</a>
                    </div>
                </div>
                <div class="formTextField fw">
                
                
                	<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				               <aui:input cssClass="field" name="address1_name" placeholder="Enter Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.name")%>'>
					                <aui:validator name="maxLength">200</aui:validator>
					              </aui:input>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices checkbox formio-choices">
				            <div class="formTextField fw">
				            	<label class="control-label">
				            		<input class="field" type="checkbox" name="<portlet:namespace />address1_hq" label='' />
				               		<span></span>
				            		<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.mainAddress")%>
				            	</label>
				            	   
				            </div>
						</aui:col> 
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				                <aui:select cssClass="field" name="address1_country" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.country")%>' showEmptyOption="true">
					            	 <% FormHelper.createCountryDDOptions( "", renderRequest, out);%>
					            </aui:select>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field" name="address1_postalCode" placeholder="Enter Postal Code" onBlur="populateAddress(this);" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.postalCode")%>'>
					                <aui:validator name="maxLength">20</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				                <aui:input cssClass="field" name="address1_street1" placeholder="Enter Block No" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.blockNo")%>'>
					                <aui:validator name="maxLength">20</aui:validator>
					              </aui:input>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field" name="address1_street2" placeholder="Enter Street Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.streetName")%>'>
					                <aui:validator name="maxLength">200</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				                <aui:input cssClass="field" name="address1_street3" placeholder="Enter Unit No" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.UnitNo")%>'>
					                <aui:validator name="maxLength">200</aui:validator>
					              </aui:input>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field" name="address1_street4" placeholder="Enter Building Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.buildingName")%>'>
					                <aui:validator name="maxLength">200</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
                </div>
               
            </div>
            
        </div>
        <aui:row cssClass="posRelative">
        	<aui:col span="12" cssClass="text-center">
        		 <a href="javascript:;" style="font-size:12px"  class="btn addAddressButton"><span>+</span>ADD ANOTHER ADDRESS</a> 
        	</aui:col>
        </aui:row>
       
        <% } %>

        
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
						<a href="javascript:;" class="removeButton btn removeBtn" style="padding: 6px;">Remove</a>
					</div>
				</div>
				
				<aui:input name="teamMember_memberId" type="hidden"></aui:input>
			</div>
		</div>

		 <% if (orgEnabledTags){ %>
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
        <% } %>
        
        
        
        
        <div class="formGroupfield  fwWidth50" id="startupTagContainer">
			<div class="formGroupfieldDummy formGroupfield fw hide" id="startupTag" data-identifier="tagId" style="padding: 0 20px 0px 20px; margin: 4px 0;background-color: #0066b3;color: #FFF;border-radius: 50px;">
				<div class="formSubTitle">
					<div>
						<span class="tagDisplayName" style="padding: 0 0 0 10px; color: #FFF; vertical-align: middle;"></span>
						<aui:input class="tagName" name="startupTag_tagName" type="hidden" value="-1"></aui:input>
					</div>
					<div class="multipleCTA">
						<a href="javascript:;" class="removeButton btn removeBtn" style="padding: 6px; color: #fff;border-color: #fff;">Remove</a>
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
                    <aui:validator name="maxLength">200</aui:validator>
                    <% if (orgRequiredFirstLastName){ %>
                    <aui:validator name="required" errorMessage='<%=LabelUtil.getLabel(pageContext, themeDisplay,"error.mandatory")%>' />
                	<%} %>
                </aui:input>
            </div>

            <div class="formTextField">
                <aui:input name="organization_lname" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.lastname")%>'>
                    <aui:validator name="maxLength">200</aui:validator>
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
     	<% if (orgEnableOldContact){ %>
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
        <% } %>
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
        
        <% if (orgEnableOldContact){ %>
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
        <% } %>
        
        <% if (orgEnableNewContact){ %>
        
        <div class="formGroupfield fw" id="contactContainer">
            <div class="formGroupTitle">
                <h3><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.contacts")%>' /></h3>
            </div>
            <div class="formGroupfield fw" id="contact1" data-identifier="contactId">
                <div class="formSubTitle">
                    <h3><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.contacts")%></h3>
                   <div class="multipleCTA">
                        <a href="javascript:;" class="removeButton btn removeBtn">Remove</a>
                    </div>
                </div>
                
                <div class="formTextField fw">
                
                
                	<aui:row>
                	
                		<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                 <aui:select name="contact1_salutation" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.salutation")%>' showEmptyOption="true">
					            	<% FormHelper.createDropDownOptions("orgSalutationList", "", renderRequest, out);%>
					            </aui:select>
				            </div>
						</aui:col>
                	
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field error-field" name="contact1_person" placeholder="Enter Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.contact.person")%>'>
					                <aui:validator name="maxLength">20</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				                <aui:input cssClass="field error-field" name="contact1_emailAddress" placeholder="Enter Email address" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.email")%>'>
					                <aui:validator name="maxLength">50</aui:validator>
					              </aui:input>
					              
					              
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field error-field" name="contact1_designation" placeholder="Enter Designation" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.designation")%>'>
					                <aui:validator name="maxLength">90</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				                <aui:input cssClass="field error-field" name="contact1_department" placeholder="Enter Department" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.department")%>'>
					                <aui:validator name="maxLength">20</aui:validator>
					              </aui:input>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field error-field" name="contact1_mobileNumber" placeholder="Enter Mobile Number (Eg: +65 6876 5432)" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.mobileNo")%>'>
					                <aui:validator name="maxLength">12</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
					<aui:row>
						<aui:col span="6" cssClass="choices formio-choices">
				            <div class="formTextField fw">
				                <aui:input cssClass="field error-field" name="contact1_telephoneNumber" placeholder="Enter Phone Number (Eg: +65 6876 5432)" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.telephoneNo")%>'>
					                <aui:validator name="maxLength">20</aui:validator>
					              </aui:input>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="choices  formio-choices">
				            <div class="formTextField fw">
				                  <aui:input cssClass="field error-field" name="contact1_faxNumber" placeholder="Enter Fax Number (Eg: +65 6876 5432)" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.faxNo")%>'>
					                <aui:validator name="maxLength">20</aui:validator>
					              </aui:input>
				            </div>
						</aui:col> 
					</aui:row>
					
					<aui:row>
						<aui:col span="6" cssClass="form-check radio">
				            <div class="formTextField fw">
				            	<label class="control-label">Billing Contact ?</label>
				               <div class="control-group form-inline">
	            					 
						             <label class="radio"><input type="radio" class="field" name="<portlet:namespace />contact1_billingContact" value="yes" /><span></span>Yes</label>
						             <label class="radio"><input type="radio" class="field" name="<portlet:namespace />contact1_billingContact" value="no" /><span></span>No</label>     
					      	 	</div>
				            </div>
						</aui:col>
						<aui:col span="6" cssClass="form-check radio">
				            <div class="formTextField fw">
				            	 <label class="control-label">Operations Contact ?</label>
				                  <div class="control-group form-inline">
            					 	<label class="radio"><input type="radio" class="field" name="<portlet:namespace />contact1_operationsContact"  value="yes" /><span></span>Yes</label>
					              	<label class="radio"><input type="radio" class="field" name="<portlet:namespace />contact1_operationsContact"  value="no" /><span></span>No</label>    
					        	  </div>
				            </div>
						</aui:col> 
					</aui:row>
					
                </div>
              
            </div>
        </div>
        <aui:row cssClass="posRelative">
       	 	<aui:col span="12" cssClass="text-center">
       	 		<a href="javascript:;" style="font-size:12px" class="btn addAddressButton addContactButton"><span>+</span>ADD ANOTHER CONTACT</a>
       	 	</aui:col>
       	</aui:row>
        
        <% } %>
        
        

    </div>
    <% if (orgEnableNewContact){ %>
    <div class="formCTA fw">
        <input type="button" id="form_2Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>
    <% } %>

</section>







































<% if (showAdminSection && false) { %>

<section class="form form_21 animated" form-name="form_21">
    <span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-admin-section")%>' />
    <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceedFromTop" />
    </span>
    <div class="formContent">
        <div class="formSelectField fw">
            <aui:select cssClass="field error-field" name="asset_orgCollabStageList" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.stage")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgCollabStageList", "cats", renderRequest, out);%> 
            </aui:select>
        </div>
    
        <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="organization_methodologyType" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology.type")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgMethodologyTypeList", "methodologyCats", renderRequest, out);%> 
            </aui:select>
        </div>

        <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="organization_methodologySubType" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology.subtype")%>' showEmptyOption="true">
              	 <% FormHelper.createDropDownOptions( "orgMethodologySubTypeList", "methodologyCats", renderRequest, out);%> 
            </aui:select>
        </div>
        
        <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="organization_feedback" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.feedback")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>

        <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="organization_showInBlackbook" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.display.in.blackbook")%>'>
              	 <option value="true"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.yes")%></option>
              	 <option value="false"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no")%></option>
            </aui:select>                   
         </div>
        
        <% if (orgEnablePipelineStatus){
    		if (Validator.isNull(orgLabelPipelineStatus)){ 
    			orgLabelPipelineStatus = LabelUtil.getLabel(pageContext, themeDisplay, "label.pipeline.status");
    		}%>
        <div class="formTextField fw">
          <aui:select cssClass="field error-field" name="organization_pipelineStatus" label='<%=orgLabelPipelineStatus%>' showEmptyOption="true" required='<%=orgRequiredPipelineStatus %>' id="organization_pipelineStatus">
              	 <% FormHelper.createJsonSelectOptions( "pipelineStatusList", "pipelineStatus", renderRequest, out);%> 
            </aui:select>
        </div>
        <%} %>
        
        <% if (orgEnableBusinessDevManager){
    		if (Validator.isNull(orgLabelBusinessDevManager)){ 
    			orgLabelBusinessDevManager = LabelUtil.getLabel(pageContext, themeDisplay, "label.business.dev.manager");
    		}%>
        <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="organization_businessDevManager" label='<%=orgLabelBusinessDevManager%>' showEmptyOption="true" required='<%=orgRequiredBusinessDevManager %>' id="organization_businessDevManager">
              	 <% FormHelper.createJsonSelectOptions( "businessDevManagerList", "businessDevManager", renderRequest, out);%> 
            </aui:select>
        </div>
        <%} %>
        
        <% if (orgEnablePrevBusinessDevManager){
    		if (Validator.isNull(orgLabelPrevBusinessDevManager)){ 
    			orgLabelPrevBusinessDevManager = LabelUtil.getLabel(pageContext, themeDisplay, "label.prev.business.dev.manager");
    		}%>
        <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="organization_prevBusinessDevManager" label='<%=orgLabelPrevBusinessDevManager%>' showEmptyOption="true" required='<%=orgRequiredPrevBusinessDevManager %>' id="organization_prevBusinessDevManager">
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
	if (canViewComment && false){
%>
	<%@ include file="/html/common/comments.jspf"  %>
<% 	
	}
%>
















<% if (true) { %>

<section class="form formContent form_23 animated " form-name="form_23">


    <aui:row>
	<aui:col span="6" cssClass="choices formio-choices">
     <aui:input name="organization_corporateCode" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.corporatecode")%>' placeholder="Enter number">
    
    </aui:input>           
    </aui:col>
    
    <aui:col span="6" cssClass="choices formio-choices">
     <aui:input name="organization_approvalDate" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.accreditationapprovaldate")%>' placeholder="Enter Date">
    
    </aui:input>           
    </aui:col>
   
    </aui:row>

        
    <aui:row>
		<aui:col span="12">
			<div id="ATODetails">
			  <h4 class="header toggler-header-expanded card-title panel-title"><span>ATO Contacts</span></h4>
			  <div class="content toggler-content-expanded">
			  	
			  	<h4 class="header toggler-header-collapsed card-title panel-title"><span>TRAINING PRINCIPAL DETAILS</span></h4>
			 	<div class="content toggler-content-collapsed">
			 		<aui:row>
				 		<aui:col span="12">
				 			<label>The Training Principal will be SAC's main point of contact for all matters concerning accreditation.</label>
				 		</aui:col>
			 		</aui:row>
			 		
					
					<div id = "primarySendInviteDiv" style="display:block">
					
						
						<% JSONObject sPATOContacts =  JSONFactoryUtil.createJSONObject();
							if(renderRequest.getAttribute(StartupConstants.ATTRIB_SPATO_CONTACTS) != null){
						
							try{
								sPATOContacts =  JSONFactoryUtil.createJSONObject(renderRequest.getAttribute(StartupConstants.ATTRIB_SPATO_CONTACTS).toString());
								
							}
							catch(Exception e){
								
							}
						}
						
						if( sPATOContacts.has("primaryFirstName") ){
						
						%>
						<aui:row>
						
							<aui:col span="6">
					          <label>
						           Training Principal :  <%= sPATOContacts.getString("primaryFirstName") %>
						      </label>
							</aui:col>
							
							
						</aui:row>
						
						<% } %>
						
						
						
						<aui:row>
							<aui:col span="6">
					            <div class="formTextField fw">
						            <aui:input cssClass="field error-field" name="atoContacts_primaryPrincipalUserFirstName" placeholder="Enter First Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.firstname")%>'>
	             					</aui:input>
						        </div>
							</aui:col>
							<aui:col span="6">
					            <div class="formTextField fw">
						            <aui:input cssClass="field error-field" name="atoContacts_primaryPrincipalUserLastName" placeholder="Enter Last Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.lastname")%>'>
						            </aui:input>
						        </div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
					            <div class="formTextField fw">
						            <aui:input cssClass="field error-field" name="atoContacts_primaryPrincipalUserEmail" onblur="checkEmailExists(this,'primary')" placeholder="Enter Email"  label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.email")%>'>
						            	
						            </aui:input>
						        </div>
						        <div class="formio-errors invalid-feedback" >
						        	<p class="help-block" style="display:none" id="primaryEmailValidDiv" >Email address already in use.</p>
						        </div>
							</aui:col>
							
						</aui:row>
					</div>
			 	</div>
			 	
			 	
			 	
			 	<h4 class="header toggler-header-collapsed card-title panel-title"><span>SECONDARY CONTACT DETAILS</span></h4>
			 	<div class="content toggler-content-collapsed">
			 		<aui:row>
				 		<aui:col span="12">
				 			<label>The secondary contact is the one SAC will use if the Training Principal is not available to discuss the accreditation.</label>
				 		</aui:col>
			 		</aui:row>
			 		
					
					<div id = "secondarySendInviteDiv" style="display:block">
						<%
						if(sPATOContacts.has("secondaryFirstName")){
						
						%>
						<aui:row>
							<aui:col span="6">
					          <label>
						           Secondary Contact :  <%= sPATOContacts.getString("secondaryFirstName") %>
						      </label>
							</aui:col>
							
						</aui:row>
						
						<% } %>
						
						<aui:row>
						<aui:col span="6">
				            <div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="atoContacts_secondaryPrincipalUserFirstName" placeholder="Enter First Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.firstname")%>'>
             					</aui:input>
					        </div>
						</aui:col>
						<aui:col span="6">
				            <div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="atoContacts_secondaryPrincipalUserLastName" placeholder="Enter Last Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.lastname")%>'>
					            </aui:input>
					        </div>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
				            <div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="atoContacts_secondaryPrincipalUserEmail" placeholder="Enter Email" onblur="checkEmailExists(this,'secondary')" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.email")%>'>
					            	
					            </aui:input>
					        </div>
					        <div class="formio-errors invalid-feedback" >
					        	<p class="help-block" style="display:none" id="secondaryEmailValidDiv" >Email address already in use.</p>
					        </div>
						</aui:col>
						
					</aui:row>
					</div>
			 	</div>

			    
			    <h4 class="header toggler-header-collapsed card-title panel-title"><span>APPROVED MENTOR DETAILS</span></h4>
			 	<div class="content toggler-content-collapsed">
					<aui:row>
				 		<aui:col span="12">
				 			<label>Approved Mentors will work with the Candidates to identify competences to be achieved and provide guidance through review meetings once every 6 months. Organisations may nominate more than 1 Approved Mentor. (Please refer to the Approved Mentor Guide to Practical Experience on www.sac.gov.sg/scaq for more details.)</label>
				 		</aui:col>
			 		</aui:row>
			 	
					<div id = "mentorsSendInviteDiv" style="display:block">
						<aui:row>
						
							<div  id="mentorContainer">
					           
					            <div class="formGroupfield fw" id="mentor1" data-identifier="mentorId">
					                <div class="formSubTitle">
					                    <h3><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.approvedmentor")%></h3>
					                   <div class="multipleCTA">
					                        <a href="javascript:;" class="removeButton btn removeBtn">Remove</a>
					                    </div>
					                </div>
					                
					                <div class="formTextField fw">
					                
					                
					                	<aui:row>
					                	
					                		<aui:col span="6" cssClass="choices  formio-choices">
									            <div class="formTextField fw">
									                 <aui:select name="mentor1_UserTitle" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.salutation")%>' showEmptyOption="true">
										            	<% FormHelper.createDropDownOptions("orgSalutationList", "", renderRequest, out);%>
										            </aui:select>
									            </div>
											</aui:col>
					                	
											<aui:col span="6" cssClass="choices  formio-choices">
									            <div class="formTextField fw">
									                  <aui:input cssClass="field error-field" name="mentor1_FirstName" placeholder="Enter First Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.firstname")%>'>
				            						  </aui:input>
									            </div>
											</aui:col> 
										</aui:row>
										
										<aui:row>
											<aui:col span="6" cssClass="choices formio-choices">
									            <div class="formTextField fw">
									                <aui:input cssClass="field error-field" name="mentor1_LastName" placeholder="Enter Last Name" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.lastname")%>'>
				             						</aui:input>
									            </div>
											</aui:col>
											<aui:col span="6" cssClass="choices  formio-choices">
									            <div class="formTextField fw">
									                  <aui:input cssClass="field error-field" name="mentor1_Email" onblur="checkEmailExists(this,'mentor')" placeholder="Enter Email" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.email")%>'>
				            						  </aui:input>
									            </div>
											</aui:col> 
											 <div class="formio-errors invalid-feedback" >
									        	<p class="help-block" style="display:none" id="mentorValidDiv" >Email address already in use.</p>
									        </div>
										</aui:row>
										
					                </div>
					              
					            </div>
		        			</div>
					        <aui:row cssClass="posRelative">
					       	 	<aui:col span="12" cssClass="text-center">
					       	 		<a href="javascript:;" style="font-size:12px" class="btn addAddressButton addMentorButton"><span>+</span>ADD MENTOR</a>
					       	 	</aui:col>
					       	</aui:row>
						
						</aui:row>
					</div>
					<table>
					<th>Approved Mentor Name</th><th>Email</th>
					<%
					
					JSONArray mentors = JSONFactoryUtil.createJSONArray();
					try{
						mentors = JSONFactoryUtil.createJSONArray(renderRequest.getAttribute("mentor").toString());
					}
					catch(Exception e){
						
						
					}
					if(mentors != null){
						for(int i = 0; i < mentors.length(); i++){
							if(!mentors.getJSONObject(i).getString("userId").equalsIgnoreCase("0")){
					%>
					<tr>
					<td><% User u = UserLocalServiceUtil.getUserById(Long.valueOf(mentors.getJSONObject(i).getString("userId"))); %>
					 <%= u.getFirstName() + " " + u.getLastName() %>
					 </td>
					<td> <%= u.getEmailAddress() %></td>
					
					</tr>
					
					<% } } } %>
					</table>
				</div>
			 	
			 	<h4 class="header toggler-header-collapsed card-title panel-title"><span>ATO PRACTICAL EXPERIENCE PRINCIPLES AND GUIDELINES</span></h4>
			 	<div class="content toggler-content-collapsed">
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	<% List<Principles> principles = (List<Principles>) renderRequest.getAttribute("principles");
			 	//principles.get(0).getPrincipleText()
			 	%>
			 	
			 		<label>Organisations applying to be accredited are assessed against a number of best practice learning and development Principles (P) and Guidelines (G). Please indicate the best practice statements your organisation can meet.</label>
			 		
			 		<% if(principles != null){
			 		
			 		for(int k = 0; k < principles.size(); k++){ %>
			 		
					<% if( Boolean.valueOf(pageContext.getAttribute("enabledPriciple"+ (k +1)).toString())){ %>
			 		<h4 class="header toggler-header-collapsed card-title panel-title"><span>Principle <%= k + 1 %></span></h4>
			 		<% Method method = principles.get(k).getClass().getMethod("getPrincipleText"); %>
				 	<div class="content toggler-content-collapsed enabled-priciple"><label style="font-weight: 600;"><%= method.invoke( principles.get(k)) %></label>
				 	<% for(int j = 1; j <= 8; j++){ 
				 		method = principles.get(k).getClass().getMethod("getGuideline"+j);
				 		String title = method.invoke( principles.get(k)).toString();
				 		if(!title.equalsIgnoreCase(StringPool.BLANK)){
				 	%>
				 	
				 	<aui:row>
				 			<aui:col span="10">
				 				<label><%= method.invoke( principles.get(k)) %></label>
				 			</aui:col>
				 			<aui:col span="2">
				 				<div class="divchoices checkbox formio-choices">
						            <div class="formTextField fw">
						            	<label class="control-label"> 
						            		<input class="field" type="checkbox" name="<portlet:namespace />guidelines<%= k + 1  %>_guideline<%= j  %>" value="true" label='' />
						               		<span></span>
						            	</label>
						            </div>
								</div> 
				 			</aui:col>
				 	</aui:row>
				 	
				 	
				 	<% } } %>
				 	<input class="field" name="<portlet:namespace />guidelines<%= k + 1  %>_principleId" value ="<%= k + 1  %>" type="hidden" label=''>
					</input>
					
			 		</div>
			 		<% } } } %>
			 		
			 		 <div class="formTextField fw">
			            <aui:input cssClass="field error-field" name="guidelines1_moreInfo" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.moreInfo")%>'>
			                <aui:validator name="maxLength">5000</aui:validator>
			            </aui:input>
			        </div>
			 		
			 	</div>
				
				<h4 class="header toggler-header-collapsed card-title panel-title"><span>EMPLOYEE INFORMATION - ALL APPLICANTS</span></h4>
			 	<div class="content toggler-content-collapsed">
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_employees" type="number"  onKeyUp="checkEmplyeeNumber(this)"  label='Employees'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_directors" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='Directors/partners'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_financeEmployees" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Finance Employees'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_professionalCandidates" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Potential / existing Singapore CA Qualification (Professional) Candidates'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_foundationCandidates" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Potential / existing Singapore CA Qualification (Foundation) Candidates'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_accountancyCandidates" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='Potential Advanced Diploma in Accountancy Candidates'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		
			 		
			 		
			 		
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_ISCAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Institute of Singapore Chartered Accountants (ISCA)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_ICASAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='Institute of Chartered Accountants of Scotland (ICAS)'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_ICAEWAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Institute of Chartered Accountants in England and Wales (ICEAW)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_CAIAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='Chartered Accountants Ireland (CAI)'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_ACCAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Association of Chartered Certified Accountants (ACCA)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_CPAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='CPA Australia'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		
			 		
			 		
			 		
			 		
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_CAANZAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Chartered Accountants Australia and New Zealand (CA ANZ)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_CPACanadaAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='Chartered Professional Accountants of Canada (CPA Canada)'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_HKCPAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Hong Kong Institute of Chartered Accountants (HKCPA)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_SAICAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='South African Institute of Chartered Accountants (SAICA)'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_JICPAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='The Japanese Institute of Certified Public Accountants (JICPA)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_AICPAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"    label='American Institute of Certified Public Accountants (AICPA)'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 		<aui:row>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_CIMAAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"   label='Chartered Institute of Management Accountants (CIMA)'>
					               <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 			<aui:col span="6">
			 				<div class="formTextField fw">
					            <aui:input cssClass="field error-field" name="employeeInfo_othersAccountants" type="number"  max="99999999999999999999" onKeyUp="checkEmplyeeNumber(this)"  label='Others (please specify)'>
					              <aui:validator name="maxLength">20</aui:validator>
					            </aui:input>
					        </div>
			 			</aui:col>
			 		</aui:row>
			 	</div>
				
				<h4 class="header toggler-header-collapsed card-title panel-title"><span>SCOPE OF ACCREDITATION</span></h4>
			 	<div class="content toggler-content-collapsed">
			 		<label>Please indicate the Scope of accreditation:</label>
			 			<aui:row>
			 				<aui:col span="12">
				 				<div class="divchoices checkbox formio-choices">
						            <div class="fw">
						            	<label class="control-label">
						            		<input class="field " type="checkbox" onchange="showAccred(this,'accreditation_avalue')" name="<portlet:namespace />accreditation_aselected" label='' />
						               		<span>A - Single department or function</span>
						            	</label>
						            </div>
								</div>

								<div class="fw">
						            <aui:input cssClass="field error-field display_none" id="accreditation_avalue" name="accreditation_avalue" type="text"  label='A single department or function should be indicated where the accreditation is only relevant to a specific department or function of the organisation where development is provided, for example an internal audit department.'>
						            </aui:input>
						        </div> 
					        </aui:col>
			 			</aui:row>
			 			<aui:row>
			 				<aui:col span="12">
				 				<div class="divchoices checkbox formio-choices">
						            <div class="fw">
						            	<label class="control-label">
						            		<input class="field" type="checkbox" onchange="showAccred(this,'accreditation_bvalue')"  name="<portlet:namespace />accreditation_bselected" label='' />
						               		<span>B - Single company</span>
						            	</label>
						            </div>
								</div>
								
								<div class="fw">
						            <aui:input cssClass="field error-field  display_none" id="accreditation_bvalue" name="accreditation_bvalue" type="text"  label='A single company should be indicated where the accreditation is only relevant to a single company based in a single geographic location.'>
						            </aui:input>
						        </div> 
					        </aui:col>
			 			</aui:row>
			 			<aui:row>
			 				<aui:col span="12">
				 				<div class="divchoices checkbox formio-choices">
						            <div class="fw">
						            	<label class="control-label">
						            		<input class="field" type="checkbox" onchange="showAccred(this,'accreditation_cvalue')"  name="<portlet:namespace />accreditation_cselected" label='' />
						               		<span>C - Organisation wide</span>
						            	</label>
						            </div>
								</div>
								
								<div class="fw">
						            <aui:input cssClass="field error-field  display_none" id="accreditation_cvalue" name="accreditation_cvalue" type="text"  label='Organisation wide should be indicated where the accreditation covers all companies.'>
						            </aui:input>
						        </div> 
					        </aui:col>
			 			</aui:row>
			 			
			 			<aui:row>
			 				<aui:col><label>For the inclusion of subsidiaries/affiliated companies under the scope of accreditation, please complete the following:</label>
								</aui:col>
			 			</aui:row>
			 			<aui:row>
			 				<aui:col span="6">
				 				<div class="formTextField fw">
						            <aui:input cssClass="field error-field" name="accreditation_ccompanyName" type="text"  label='Please provide the name of the department or function:'>
						            </aui:input>
						        </div> 
					        </aui:col>
					        <aui:col span="6" cssClass="form-check radio">
				            <div class="formTextField fw">
				            	<label class="control-label">Does it share the same policies in human resource and, training and development with the applying company?</label>
				               <div class="control-group form-inline">
	            					 
						             <label class="radio"><input type="radio" onclick="checkSamePolicy(this,'accreditation_celaborate')" class="field" name="<portlet:namespace />accreditation_csamepolicy" value="yes" data-val = "yes" /><span></span>Yes</label>
						             <label class="radio"><input type="radio" onclick="checkSamePolicy(this,'accreditation_celaborate')" class="field" name="<portlet:namespace />accreditation_csamepolicy" value="no" data-val = "no" /><span></span>No</label>     
					      	 	</div>
				            </div>
						</aui:col>
					        
			 			</aui:row>
			 			
			 			<aui:row>
			 				<aui:col span="12">
								<div class="fw">
						            <aui:input cssClass="field error-field display_none" id="accreditation_celaborate" name="accreditation_celaborate" type="text"  label='If "No", please elaborate on deviations in policies concerned.'>
						            </aui:input>
						        </div> 
					        </aui:col>
			 			</aui:row>
			 			
			 			<aui:row>
			 				<aui:col span="12">
				 				<div class="divchoices checkbox formio-choices">
						            <div class="fw">
						            	<label class="control-label">
						            		<input class="field" onchange="showAccred(this,'accreditation_dvalue')"  type="checkbox" name="<portlet:namespace />accreditation_dselected" label='' />
						               		<span>D - Others</span>
						            	</label>
						            </div>
								</div>
								
								<div class="fw">
						            <aui:input cssClass="field error-field display_none" id="accreditation_dvalue" name="accreditation_dvalue" type="text"  label='Please provide relevant Information.'>
						            </aui:input>
						        </div> 
					        </aui:col>
			 			</aui:row>
			 	</div>
				
				<h4 class="header toggler-header-collapsed card-title panel-title"><span>DOCUMENTS</span></h4>
				<% List<ATODocument> financialStatements = (List<ATODocument>) renderRequest.getAttribute("financialStatement");  %>
				<% List<ATODocument> policies = (List<ATODocument>) renderRequest.getAttribute("policy");  %>
				
				<% List<ATODocument> businessConducts = (List<ATODocument>) renderRequest.getAttribute("businessConduct");  %>
				<% List<ATODocument> jobDescription = (List<ATODocument>) renderRequest.getAttribute("jobDescription");  %>
				
				<% List<ATODocument> appraisalForms = (List<ATODocument>) renderRequest.getAttribute("appraisalForm");  %>
				<% List<ATODocument> timesheets = (List<ATODocument>) renderRequest.getAttribute("timesheets");  %>
				
				<% List<ATODocument> jobDescriptions = (List<ATODocument>) renderRequest.getAttribute("jobDescriptions");  %>
				<% List<ATODocument> businessRegistrations = (List<ATODocument>) renderRequest.getAttribute("businessRegistration");  %>
				
				<% List<ATODocument> supplementaryDocuments = (List<ATODocument>) renderRequest.getAttribute("supplementaryDocuments");  %>
			 	<div class="content toggler-content-collapsed"> 
			 		<h4 class="header toggler-header-collapsed card-title panel-title"><span>MANDATORY DOCUMENTS</span></h4>
				 	<div class="content toggler-content-collapsed">
						
						<aui:row>
							<aui:col span="12">
								<label>Organization financial statements / Annual report<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
								<div class="ra-upload">
									<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								
									<aui:input cssClass="field error-field" name="financialStatement" type="file" onChange="uploadDoc('financialStatement',this)"  label=''>
						              <% if(isDocumentsMandatory && (financialStatements == null || financialStatements.size() == 0)){ %>
						              	<aui:validator name="required" />
						              <% } %>
						            </aui:input>
						            
						        </div> 
						          
						        <label class="file-name">
									<% if(financialStatements != null){
									for(int i = 0; i < financialStatements.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(financialStatements.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= financialStatements.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= financialStatements.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
								</label>
							</aui:col>
							
							
						</aui:row>
						<aui:row>
						
						</aui:row>
						<aui:row>
							<aui:col span="12">
							<label>Formal written policy; study policies<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="policy" type="file" onChange="uploadDoc('policy',this)"  label=''>
					              <% if(isDocumentsMandatory && (policies == null || policies.size() == 0)){ %>
						              	<aui:validator name="required" />
						              <% } %>
					            </aui:input>
					        </div>
					        <label class="file-name">
								<% if(policies != null){
									for(int i = 0; i < policies.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(policies.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= policies.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= policies.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
							</label>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
							<label>Code of Business Conduct<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="businessConduct" type="file" onChange="uploadDoc('businessConduct',this)"  label=''>
					              <% if(isDocumentsMandatory && (businessConducts == null || businessConducts.size() == 0)){ %>
					              	<aui:validator name="required" />
					              <% } %>
					            </aui:input>
					        </div>
					        <label class="file-name">
								<% if(businessConducts != null){
									for(int i = 0; i < businessConducts.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(businessConducts.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= businessConducts.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= businessConducts.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
							</label>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
							<label>Job description of a potential Candidate<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="jobDescription" type="file" onChange="uploadDoc('jobDescription',this)"  label=''>
					               <% if(isDocumentsMandatory && (jobDescription == null || jobDescription.size() == 0)){ %>
					              	<aui:validator name="required" />
					              <% } %>
					            </aui:input>
					        </div>
					        <label class="file-name">
								<% if(jobDescription != null){
									for(int i = 0; i < jobDescription.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(jobDescription.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= jobDescription.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= jobDescription.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
							</label>
							</aui:col>
						</aui:row>	
						<aui:row>
							<aui:col span="12">
							<label>Blank employee appraisal form<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="appraisalForm" type="file" onChange="uploadDoc('appraisalForm',this)"  label=''>
					               <% if(isDocumentsMandatory && (appraisalForms == null || appraisalForms.size() == 0)){ %>
					              	<aui:validator name="required" />
					              <% } %>
					            </aui:input>
					        </div>
					        <label class="file-name">
								<% if(appraisalForms != null){
									for(int i = 0; i < appraisalForms.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(appraisalForms.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= appraisalForms.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= appraisalForms.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
							</label>
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col span="12">
							<label>CVs / Job Description<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="jobDescriptions" type="file" onChange="uploadDoc('jobDescriptions',this)"  label=''>
					               <% if(isDocumentsMandatory && (jobDescriptions == null || jobDescriptions.size() == 0)){ %>
					              	<aui:validator name="required" />
					              <% } %>
					            </aui:input>
					        </div>
					        <label class="file-name">
								<% if(jobDescriptions != null){
									for(int i = 0; i < jobDescriptions.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(jobDescriptions.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= jobDescriptions.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= jobDescriptions.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
							</label>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
							<label>Business Registration Information<span class="label-required" ><% if(isDocumentsMandatory){ %> * <% } %></span></label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="businessRegistration" type="file" onChange="uploadDoc('businessRegistration',this)"  label=''>
					               <% if(isDocumentsMandatory && (businessRegistrations == null || businessRegistrations.size() == 0)){ %>
					              	<aui:validator name="required" />
					              <% } %>
					            </aui:input>
					        </div>
					        <label class="file-name">
								<% if(businessRegistrations != null){
									for(int i = 0; i < businessRegistrations.size(); i++){
										try{
										DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(businessRegistrations.get(i).getDocumentFileId())); %>
									<div class="fileDiv file_<%= businessRegistrations.get(i).getAtoDocumentId() %>">
									<div style="float:left">
										<a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a>
									</div>
									<div style="text-align: right;">
										<a href="javascript:void(0)" onclick="deleteDocument(<%= businessRegistrations.get(i).getAtoDocumentId() %>)">Delete</a>
									</div>
									</div>
									<% } catch(Exception e){ } } } %>
							</label>
							</aui:col>
						</aui:row>
					 	
				 	</div>
				 	<h4 class="header toggler-header-collapsed card-title panel-title"><span>SUPPLEMENTARY DOCUMENTS</span></h4>
				 	<div class="content toggler-content-collapsed">
						<aui:row>
							<aui:col span="12">
								<ul>
							
									<li>
										<label>- Strategic obectives document / Evidence of communication</label> 
									</li>
									<li>
										<label>- Organisation chart/grading structure</label> 
									</li>
									<li>
										<label>- Sample employment contracts</label> 
									</li>
									<li>
										<label>- Employee induction course material / process</label> 
									</li>
									<li>
										<label>- Evidence of training budget proposal / sign off </label>
									</li>
									<li>
										<label>- Employee records of development activity completed </label> 
									</li>
									<li>
										<label>- Post training evaluation forms </label>
									</li>
									<li>
										<label>- Timesheets (if applicable to the organisation) </label>
									</li>
								</ul>
							</aui:col>
						</aui:row>	
						<aui:row>
							<aui:col span="12">
							<label>Supplementary Documents</label>
							<div class="ra-upload">
							<img src="<%=request.getContextPath()%>/images/upload.png"><label class="ra-upload-label">Drop Files to attach, or <i>browse</i></label>
								<aui:input cssClass="field error-field" name="supplementary" type="file" onChange="uploadDoc('supplementary',this)"  label=''>
					              
					            </aui:input>
					        </div>
					        
					        <label class="file-name">
								<% if(supplementaryDocuments != null){
								for(int i = 0; i < supplementaryDocuments.size(); i++){
									DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(Long.valueOf(supplementaryDocuments.get(i).getDocumentFileId())); %>
								<div><a href="<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + dl.getUuid() %>" > <%= dl.getTitle() %></a></div>
								<% } } %>
							</label>
							</aui:col>
						</aui:row> 	
					 	
				 	</div>
			 	</div>
			
				
			 	
			  </div>
			</div>
		</aui:col>
	</aui:row>
    
    <div class="formCTA fw" style="margin-top:30px;">
        <input type="button" id="form_23Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>

</section>
<% } %>





















<%
	if (canViewComment && false){
%>
<section class="form form_3 animated" form-name="form_3">
	<span class="formTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-assessment")%>'/>
	<input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>'/>" class="proceedFromTop" />
	</span>
	<p><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.self.assessment.warning")%>' /></p>	
    <div class="formContent">
		 <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="questionnaire_answer1" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques1")%>' showEmptyOption="true">
            	<% FormHelper.createDropDownOptions("orgBenchmarkList", "", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer2" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques2")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:select cssClass="field error-field" name="questionnaire_answer3" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques3")%>' showEmptyOption="true">
              	<% FormHelper.createDropDownOptions( "orgCostBenchmarkList", "", renderRequest, out);%>
            </aui:select>
        </div>
        <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer4" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques4")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer5" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques5")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
        <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer6" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques6")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer7" type="textarea" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques7")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer8" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques8")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer9" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques9")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
         <div class="formTextField fw">
            <aui:input cssClass="field error-field" name="questionnaire_answer10" type="text" row="4" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ques10")%>'>
                <aui:validator name="maxLength">5000</aui:validator>
            </aui:input>
        </div>
       
	
	</div>
	 <div class="formCTA fw">
        <input type="button" id="form_3Proceed" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save-n-proceed")%>' />" class="proceed" />
        <input type="button" value="<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>' />" class="cancel" onclick="cancel()" />
    </div>
</section>
<% } %>
<footer>

</footer>
	
	<script>
	var namespace = "<portlet:namespace />";
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
	
	var ajaxresourceURL = "<%= ajaxresourceURL %>";
	</script>
<script src="/StartupProfile-portlet/js/main.js" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/script.js" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/filedrag.js" type="text/javascript"></script>


<script>
function initDynamicSections(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3) {
	
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
 		 try {
 		 <% if (orgEnabledFunding){ %>
		  A.one('#fundingRound1 .addButton').on('click', function() {
			  
				addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,"fundingRound", A);
		  });
		   <% } %>
		   <% if (orgEnabledAddresses){ %>
		  A.one('.addAddressButton').on('click', function() {
			 
				addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,"address", A);
		  });
		   <% } %>
		   <% if (orgEnableNewContact){ %>
		  A.one('.addContactButton').on('click', function() {
				 
				addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,"contact", A);
		  });
		   <% } %>
		   A.one('.addMentorButton').on('click', function() {
				 
				addSection(deleteConfirmMsg,removeSuccessMsg,removeFailedMsg,removeFailRefreshMsg,successMessage,errorMessage,errorMessage3,"mentor", A);
		  });
		 
 		 } catch(err) {}
	 });
	if(organization !=  null){

		document.getElementById(namespace + "organization_uen").disabled = true;
		document.getElementById(namespace + "organization_name").disabled = true;
		
		document.getElementById(namespace + "organization_corporateCode").disabled = true;
		document.getElementById(namespace + "organization_approvalDate").disabled = true;
		
		<% if(!isAdmin){ %>
		
		document.getElementById(namespace + "atoContacts_primaryPrincipalUserFirstName").disabled = true;
		document.getElementById(namespace + "atoContacts_primaryPrincipalUserLastName").disabled = true;
		document.getElementById(namespace + "atoContacts_primaryPrincipalUserEmail").disabled = true;
		
		<% } %> 
		
		if(userId == atoContacts.secondaryPrincipalUserId){
			document.getElementById(namespace + "atoContacts_secondaryPrincipalUserFirstName").disabled = true;
			document.getElementById(namespace + "atoContacts_secondaryPrincipalUserLastName").disabled = true;
			document.getElementById(namespace + "atoContacts_secondaryPrincipalUserEmail").disabled = true;
		}
		
		setTimeout(function(){ 
			var ee = document.getElementsByName(namespace + "accreditation_aselected");
			if(ee[0].value == "true"){ document.getElementById(namespace + "accreditation_avalue").classList.remove("display_none"); }
			
			ee = document.getElementsByName(namespace + "accreditation_bselected");
			if(ee[0].value == "true"){ document.getElementById(namespace + "accreditation_bvalue").classList.remove("display_none"); }
			
			ee = document.getElementsByName(namespace + "accreditation_cselected");
			if(ee[0].value == "true"){ document.getElementById(namespace + "accreditation_cvalue").classList.remove("display_none"); }
			
			ee = document.getElementsByName(namespace + "accreditation_dselected");
			if(ee[0].value == "true"){ document.getElementById(namespace + "accreditation_dvalue").classList.remove("display_none"); }
			
		}, 3000);
		
		
	}
	
}

var ss = document.getElementsByClassName("usersList");
var jsonArr = [];
var usersList =[];
function pouplateusers(){
	
	var apiUrl = "/api/jsonws/UserProfile-portlet.socialprofile/get-company-users/company-id/20155/start/-1/end/-1?p_auth=<%= AuthTokenUtil.getToken(request) %>";
	var _data = {};
    AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
    
	    A.io.request(apiUrl,{
	        dataType : 'json', method : "GET",
	        data : _data,
	        on : {
	            success : function(){
	            	jsonArr = this.get("responseData");
	            	var optu = new Option( "","");
	            	for(var i = 0; i < jsonArr.length; i++){
						for(var j = 0; j < ss.length; j++){
							optu = new Option( jsonArr[i].firstName,jsonArr[i].userId);
							if(j == 0 && atoContacts != undefined &&  (jsonArr[i].userId == atoContacts.primaryPrincipalUserId)){
								optu.setAttribute("selected","selected");
							}
							if(j == 1 && atoContacts != undefined && (jsonArr[i].userId == atoContacts.secondaryPrincipalUserId)){
								optu.setAttribute("selected","selected");
							}
							ss[j].options[ss[j].options.length] = optu;
							
						}
						
						var user = {};
						user.key = jsonArr[i].userId;
						user.code = jsonArr[i].firstName;
						usersList.push(user);
	            	}
	            	

	            },
	            failure : function() {
	            	console.log("Unable to fetch users");
	            	
	            }
	        }
	    });
    });
}
// setTimeout(function(){ pouplateusers(); }, 3000);


function populateAddress(elem)
{
	var elemName = elem.name;
	//var str = "sssssaddress1rrr";
	var res = elemName.split("address");
	var number = res[1].charAt(0);
	var country = document.getElementById(namespace+"address"+ number +"_country"); 
	var postalCode = document.getElementById(namespace+"address"+ number +"_postalCode");
	var blockNo = document.getElementById(namespace+"address"+ number +"_street1");
	var streetName = document.getElementById(namespace+"address"+ number +"_street2");
	var unitNo = document.getElementById(namespace+"address"+ number +"_street3");
	var buildingName = document.getElementById(namespace+"address"+ number +"_street4");
		
	var _data = {};
	if (country[country.selectedIndex].text === "Singapore") {
        var apiUrl = "/api/jsonws/SPMicroservice-portlet.spmicroservice/get-postal-address/country-code/sg/postal-code/" + postalCode.value + "?p_auth=<%= AuthTokenUtil.getToken(request) %>";
        
        AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
        	
        
        A.io.request(apiUrl,{
            dataType : 'json', method : "GET",
            data : _data,
            on : {
                success : function(){
                	var jsonArr = this.get("responseData");
                	for (var i = 0; i < 1; i++) { // just first record for now
                        var addr = jsonArr[i];
                        if (!addr) {
                        	displayMessage("Postal address not found");
                            continue;
                        }
                        blockNo.value = addr.blockNo;
                        streetName.value = addr.roadName;
                        unitNo.value = "";
                        buildingName.value = addr.building;
                        
                    }
                	
                },
                failure : function() {
                	displayMessage("Currently available for Singapore only.");
                	document.getElementById(namespace +"address"+ number +"_street1").focus();
                }
            }
        });
        });
    } else {
        
    }	
	
	
}
function showHideATOContacts(type,selection){
	if(selection == "yes"){
		document.getElementById(type+"ExistingMemberDiv").style.display= "block";
		document.getElementById(type+"SendInviteDiv").style.display= "none";
	}else{
		document.getElementById(type+"SendInviteDiv").style.display= "block";
		document.getElementById(type+"ExistingMemberDiv").style.display= "none";
	}
	
}


YUI().use('aui-toggler',
  function(Y) {
    new Y.TogglerDelegate(
      {
        animated: true,
        closeAllOnExpand: true,
        container: '#ATODetails',
        content: '.content',
        expanded: false,
        header: '.header',
        transition: {
          duration: 0.2,
          easing: 'cubic-bezier(0, 0.1, 0, 1)'
        }
      }
    );
  }
);


function create_blob(file, callback) {
    var reader = new FileReader();
    reader.onload = function() { callback(reader.result) };
    reader.readAsDataURL(file);
}
var currentnode;
function uploadDoc(documentTitle,fileControl){
	
	currentnode = fileControl;
	formDirty = true;
	var form = document.createElement("form");
	var node = fileControl.cloneNode(true);
	var documentName = document.createElement("input");
	documentName.setAttribute("type", "hidden");
	documentName.setAttribute("name", "documentName");
	documentName.setAttribute("value", documentTitle);
	var fileName = document.createElement("input");
	fileName.setAttribute("type", "hidden");
	fileName.setAttribute("name", namespace+"fileName");
	fileName.setAttribute("value", Date.now()+"-"+node.files[0].name);
	var action = document.createElement("input");
	action.setAttribute("type", "hidden");
	action.setAttribute("name", "action");
	action.setAttribute("value", "uploadDoc");
	
	
	form.action = ajaxresourceURL;
	form.method = "post";
	form.enctype = "multipart/form-data";
	form.appendChild(node);
	form.appendChild(documentName);
	form.appendChild(fileName);
	form.appendChild(action);
	form.style.display = "none";

	var XHR = new XMLHttpRequest();
	var FD = new FormData(form);
	XHR.open("POST", ajaxresourceURL);
	XHR.addEventListener("load", function(event) {
		var resp = JSON.parse(event.target.responseText).result[0];
		var ff = currentnode.parentElement.parentElement.parentElement.getElementsByClassName("file-name");
		var gg = JSON.parse(event.target.responseText);
		ff[0].innerHTML=  ff[0].innerHTML + "<div style='float:left'> <a href = '"+ gg.data.url +"' target='_blank' > "+ gg.data.name +" </a></div><div style='float:right'><a href='javascript:void(0)' onclick='deleteDocument("+gg.data.fileEntryId+")' >Delete</a></div>";
		console.log("event.target.responseText : "+event.target.responseText);
		
	});
	XHR.addEventListener("error", function(event) {
		showLoading(false);
		console.log("Failed to load the file");
		
	});
	XHR.send(FD);
	
	
	
}

function deleteDocument(atoDocumentId){
	
	//alert(atoDocumentId);
	formDirty = true;
	var docs = document.getElementsByClassName("file_"+ atoDocumentId );
	if(docs.length > 0 ){
		documentsToDelete.push(atoDocumentId);
		docs[0].remove();
	}
// 	var obj = {};
// 	obj['action'] = 'deleteDocument';
// 	obj['documentId'] = atoDocumentId;
// 	obj['sp_p_auth'] = Liferay.authToken;
// 	AUI().use('aui-node', 'aui-base', function(A) {
// 		A.io.request(ajax,
// 		{
// 			dataType : 'json',
// 			method : 'POST',
// 			data : obj,
// 			on : {
// 				success : function() {
// 					this.get("responseData")
					
// 				},
// 				failure : function(e) {
					
// 				}
// 			}
// 		});
// 	});
}
var selectedSpecializationListJSON = [];

function createSelectedList(listName, listId, displayDiv, valueDiv) {
	var selListDiv = document.getElementById(displayDiv);
	var div1 = document.createElement('div');
	div1.setAttribute("class", "selWrap");
	div1.setAttribute("id", "selWrap_" + listId);
	var div2 = document.createElement('div');
	div2.setAttribute("class", "sel-list-name");
	var span1 = document.createElement('span');
	var text1 = document.createTextNode(listName);
	span1.appendChild(text1);
	div2.appendChild(span1);
	var div3 = document.createElement('div');
	div3.setAttribute("class", "sel-list-remove");
	var span2 = document.createElement('span');
	var text2 = document.createTextNode("X");
	span2.setAttribute("class", "removeSelList");
	span2.setAttribute("onClick", "removeElement(" + listId + ","
			+ valueDiv + ")");
	span2.appendChild(text2);
	div3.appendChild(span2);
	div1.appendChild(div2);
	div1.appendChild(div3);
	if (selListDiv){
		selListDiv.appendChild(div1);
	}
}

function removeElement(listId, valueDivElem) {
	var elem = document.getElementById("selWrap_" + listId);
	var elemId = valueDivElem;//document.getElementById(valueDivElem);
	elemIdValues = elemId.value;
	if (elemIdValues.indexOf(listId) != -1) {
		var val = "," + listId;
		elemIdValues = elemIdValues.replace(new RegExp(val), '');
		elemId.value = elemIdValues;
	}
	elem.remove();
	return true;
}
function autoCompleteList(className, sourceJSON, extsourceJSON,
		valueToBeSaved, displayDiv,inputNodeId,placeHolder) {
	var items = extsourceJSON;
	var itemIds = "0";
	var itemNames = "";
	if (extsourceJSON != "0") {
		for (key in items) {
			var ss = items[key];
			itemIds += "," + ss.key;
			itemNames += "," + ss.code;
			//tag,className,id,name,type,placeholder,maxlength,event,eventValue,url,isMandatory,isNumberOnly,isTextOnly
			createSelectedList(ss.code, ss.key, displayDiv, valueToBeSaved);
		}

		//document.getElementById("selectedCompetency").innerHTML = itemNames;
		document.getElementById(valueToBeSaved).value = itemIds;
	}
	AUI().use(
			'aui-node',
			'aui-base',
			'aui-io-request',
			'autocomplete-list',
			'aui-io-request',
			'autocomplete-filters',
			'autocomplete-highlighters',
			function(A) {
				if (sourceJSON) {
					var autoComplete = new A.AutoCompleteList({
						allowBrowserAutocomplete : 'false',
						inputNode : className,
						activateFirstItem : 'true',
						source : sourceJSON,
						resultTextLocator : 'code',
						resultHighlighter : 'phraseMatch',
						resultFilters : 'phraseMatch',
						minQueryLength : 1,
						maxResults : 10,
						queryDelimiter : ',',
						on : {
							select : function(event) {
								var result = event.result.raw;
								var elementToSaveValues = document
										.getElementById(valueToBeSaved);
								createSelectedList(result.code, result.key,
										displayDiv, valueToBeSaved);
								elementToSaveValues.value += ","
										+ result.key;
								document.getElementById(inputNodeId).classList.remove("Error-success");
			    				document.getElementById(inputNodeId).classList.remove("Error");
			    				document.getElementById(inputNodeId).placeholder=placeHolder;
							}
						},
						 after: {
                                select: function (event) {
                                    clearAutoCompleteData(inputNodeId);
                                }
                            },
						render : 'true'
					}).render();
				}
			});
}
function clearAutoCompleteData(id){
	var elm = document.getElementById(id);
	elm.value = '';
}
function showAccred(elem1,elem){
	if(elem1.checked){
		document.getElementById(namespace+elem).classList.remove("display_none");
	}else{
		document.getElementById(namespace+elem).classList.add("display_none");
	}
}
function checkSamePolicy(elem1,elemname){
	if(elem1.getAttribute('data-val') == "no"){
		document.getElementById(namespace+elemname).classList.remove("display_none");
	}else{
		document.getElementById(namespace+elemname).classList.add("display_none");
	}
	
}
function checkEmplyeeNumber(elem){
	if(elem.value.length > 20){
		var trimmedString = elem.value.substring(0, 20);
		elem.value = trimmedString;
		
	}
	
}
var primaryemailExists = 0;
var secondaryemailExists = 0;
var mentorExists = 0;
function checkEmailExists(elem,elemType){
	if(elemType == "primary"){
		primaryemailExists = 1;
	}
	if(elemType == "secondary"){
		secondaryemailExists = 1;
	}
	if(elemType == "mentor"){
		mentorExists = 1;
	}
	
	var obj = {};
	obj['action'] = 'checkEmailExists';
	obj['email'] = elem.value;
	obj['organizationId'] = organization.organizationId;
	obj['sp_p_auth'] = Liferay.authToken;
	AUI().use('aui-node', 'aui-base', function(A) {
		A.io.request(ajax,
		{
			dataType : 'json',
			method : 'POST',
			data : obj,
			on : {
				success : function() {
					var resp = this.get("responseData");
					console.log(resp);
					secondaryemailcheckresp = 0;
					if(resp.result == "Linked to an ATO" || resp.result == "Not Linked to any other ATO" ){
						if(elemType == "primary"){
							document.getElementById("primaryEmailValidDiv").style.display = "inline-block"; 
						}
						else if(elemType == "mentor"){
							document.getElementById("mentorValidDiv").style.display = "inline-block"; 
						}
						else{
							document.getElementById("secondaryEmailValidDiv").style.display = "inline-block"; 
						}
						
					}else{
						if(elemType == "primary"){
							document.getElementById("primaryEmailValidDiv").style.display = "none"; 
							primaryemailExists = 0;
						}
						else if(elemType == "mentor"){
							document.getElementById("mentorValidDiv").style.display = "none"; 
							mentorExists = 0;
						}
						else{
							document.getElementById("secondaryEmailValidDiv").style.display = "none"; 
							secondaryemailExists = 0;
						}
					}
					 
					
				},
				failure : function(e) {
					
				}
			}
		});
	});
}
</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.common.startupProfileForm_jsp");
%> 