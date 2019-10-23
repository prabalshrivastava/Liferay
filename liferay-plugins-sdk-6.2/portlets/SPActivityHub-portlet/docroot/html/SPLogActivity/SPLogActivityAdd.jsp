<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.sambaash.platform.activityhub.helper.SPActivityHubHelper"%>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.model.UserConstants" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />



<liferay-portlet:resourceURL id="ajax" var="ajaxUrl">
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL var ="ajaxUrlFileUpload">
	<portlet:param name="action" value="uploadFileToTemp"/>
</liferay-portlet:resourceURL>



<% 
String entityId = renderRequest.getAttribute("_SPActivityHub_WAR_SPActivityHubportlet_entityId").toString(); 
String entityClassId = renderRequest.getAttribute("_SPActivityHub_WAR_SPActivityHubportlet_entityClassId").toString(); 
String entityClassName = renderRequest.getAttribute("_SPActivityHub_WAR_SPActivityHubportlet_entityClassName").toString();
String associatedWith = renderRequest.getAttribute("_SPActivityHub_WAR_SPActivityHubportlet_associatedWith").toString();

User loggedInUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
String extUserStr = SPActivityHubHelper.checkInternalOrExternal(renderRequest, loggedInUser);

long closedStageId = 0;
if (entityClassName.contains("ProcessState") && !entityId.equalsIgnoreCase("0")){
	closedStageId = PEProcessStateLocalServiceUtil.getPEProcessState(GetterUtil.getLong(entityId)).getClosedStageId();
}

%>


                            <div class="actLog">
                               <div class="actTypeClass">
                               <select class="dropdownSelectActive Requiredfield" id="normal-select-1" onchange="validate(this)">
                                   <option value="" class="select-dropdown__list-item" disabled selected="selected">Activity type</option>
                                    <option value="Log a Call" class="select-dropdown__list-item">Log a Call</option>
                                    <option value="Meeting" class="select-dropdown__list-item">Meeting</option>
                                    <option value="Email" class="select-dropdown__list-item">Email</option>
                                  
                                </select>
                                <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                               </div>
                               <div class="actOutcomeClass">
                                <select class="dropdownSelectActive Requiredfield"  id="normal-select-2" onchange="validate(this)">
                                    <option value="" class="select-dropdown__list-item" disabled selected="selected">Outcome</option>
                                    <option value="No Answer" class="select-dropdown__list-item">No Answer</option>
                                    <option value="Busy" class="select-dropdown__list-item">Busy</option>
                                    <option value="Wrong number" class="select-dropdown__list-item">Wrong number</option>
                                    <option value="Left live message" class="select-dropdown__list-item">Left live message</option>
                                    <option value="Left Voicemail" class="select-dropdown__list-item">Left Voicemail</option>
                                    <option value="Connected" class="select-dropdown__list-item">Connected</option>
                                </select>
                              <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                               </div>
                               
                               <span class="lfr-input-date datePos" id="logActivityDateContainer">
                                	<input type="text" class="notifyDateEdit Requiredfield" name="logActivityDate" id="logActivityDate" placeholder="Date">
                                    <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                               </span>
                                
                               <span class="lfr-input-date timePos" id="logActivityTimeContainer">
                                	<input type="text" class="timeSlct Requiredfield" name="logActivityTime" id="logActivityTime" placeholder="Time">
                                    <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                               </span>

                            </div>
                             <div class="actTitle">
                                <input type="text" name="" value="" class="Requiredfield" id="logActivityTitle" placeholder="Add a Title" onchange="validate(this)">
                                 <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                            </div>
                            <div class="logContentaddArea">
                            <div contenteditable="true" class="contentEditWrap contentEditError Requiredfield" id="logTxtArea" onchange="validateContentArea(this)">
                                    
                                </div>
                            <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                        </div>
                            <p class="file-return" id="fileUploadLogActivity"></p>
                            <div class="activityCreateActions ">
                             <div class="actactionsIcons" id="myToggler">
                            <a href="#" class="actBtns inActiveBtn" onclick="toggleVisibility('logAnchorLink')"><img src="/SPActivityHub-portlet/images/inactive.svg"></a>
                            <a href="#" class="actBtns textFormatBtn" onclick="toggleVisibility('logTxtTool')"><img src="/SPActivityHub-portlet/images/ac-icon-a.svg"></a>
                            <a href="#" class="attachmentBtn" onclick="toggleVisibility('logAttachment')"><img src="/SPActivityHub-portlet/images/attachment.svg"></a>
                           
                            <div class="actLink"></div>
                         
                            <div class="linkTools" id="logAnchorLink">
                                 <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                                <h2>ADD LINK</h2>
                                <input type="text"  required="required" name="" id="lLinkTxt" value="" placeholder="Link Text">
                                <input type="text"  required="required" name="" id="lLinkUrl" value="" placeholder="URL">
                                <div class="linkActions">
                                    <a href="#" class="linkAnchor" id="applyLogBtn">Apply</a>
                                    <a href="#" class="linkAnchor" id="applyLogAnchor">Cancel</a>
                                </div>
                            </div>
                            <div class="txtFormatTools" id="logTxtTool">
                                 <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                                <div class="formatter">
                                     <button class="btnAc btn-default" data-edit="bold">
                                                <img src="/SPActivityHub-portlet/images/textFormat-icons/bold.svg">
                                            </button>
                                            <button class="btnAc btn-default" data-edit="italic">
                                                <img src="/SPActivityHub-portlet/images/textFormat-icons/italic.svg">
                                            </button>
                                            <button class="btnAc btn-default" data-edit="underline">
                                                <img src="/SPActivityHub-portlet/images/textFormat-icons/underline.svg">
                                            </button>
                                            <button class="btnAc btn-default" data-edit="strikeThrough">
                                                <img src="/SPActivityHub-portlet/images/textFormat-icons/strikethrough.svg">
                                            </button>
                                              <button class="btnAc btn-default" data-edit="insertUnorderedList">  <img src="/SPActivityHub-portlet/images/textFormat-icons/ul-list.svg"></button>
                                                <button class="btnAc btn-default" data-edit="insertOrderedList">  <img src="/SPActivityHub-portlet/images/textFormat-icons/ol-list.svg"></button>
                                </div>
                            </div>
                            <div class="convAttchment" id="logAttachment">
                                 <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                                 <div class="input-file-container">
                                            <input type="hidden" id="uploadsFileEntryIdLogActivity" value="0">
                                            <input class="input-file" type="file" id="logActivityFile" multiple />
                                            <label tabindex="0" for="logActivityFile" class="input-file-trigger">Upload from computer</label>
                                 </div>
                            </div>
                        </div>
                        <div class="actionLinkwrap">
                        <% if (Validator.isNotNull(associatedWith) && !associatedWith.equalsIgnoreCase("0")) {%>
                            <div class="actAccociate">
                                <p>Associated<br> with</p>
                                <img src="/SPActivityHub-portlet/images/associate.png">
                            </div>
                            <%} %>
                            <a class="actionButton" href="#" id="saveLogActivity">LOG IT</a>
                        </div>
                    </div>
                    
<script type="text/javascript" src="/SPActivityHub-portlet/js/SPLogActivity/spLogActivity.js?t=<%=DateUtil.newTime() %>"></script>
<script src="/SPActivityHub-portlet/js/fileUploadActivityHub.js?t=<%=DateUtil.newTime() %> "></script>

<script type="text/javascript">
var A;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
		'stylesheet','aui-datepicker','aui-timepicker','overlay','event', 'widget-anim', function(A1) {
	A = A1;
	var pns ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	var entityId = "<%= entityId %>";
	var entityClassId = "<%= entityClassId %>";
	var entityClassName = "<%= entityClassName %>";
	var ajaxUrlFileUpload = "<%= ajaxUrlFileUpload %>";
	var associatedWith = "<%= associatedWith %>";
	var extUser = "<%= extUserStr %>";
	var closedStageId = "<%= closedStageId%>";
	var obj = new spLogActivity({pns:pns, ajaxUrl:ajaxUrl, entityId:entityId, entityClassId:entityClassId, entityClassName:entityClassName, ajaxUrlFileUpload:ajaxUrlFileUpload, extUser:extUser, associatedWith:associatedWith, closedStageId:closedStageId});
});
</script>                    
