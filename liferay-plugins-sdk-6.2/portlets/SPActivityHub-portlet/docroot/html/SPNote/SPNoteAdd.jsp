<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil"%>
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


  
                            <div class="actTitle">
                                <input type="text" class="Requiredfield" name="" value="" id="noteTitle" placeholder="Add a Title" onchange="validate(this)">
                                <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                            </div>
                            <div class="actNotes">
                            	<div type="checkbox" id="selectPastedNote"> </div>
                                <div contenteditable="true" class="contentEditWrap contentEditError noteAddsec Requiredfield" id="noteTxtArea" >                                   
                                </div>
                                <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
                            </div>
                            <p class="file-return" id="fileUploadNote"></p>
                            <p id="myProgress"></p>
                            <div class="activityCreateActions ">
                             <div class="actactionsIcons" id="myToggler">
                                    <a href="#" class="actBtns inActiveBtn" onclick="toggleVisibility('linkToolsWrap')"><img src="/SPActivityHub-portlet/images/inactive.svg"></a>
                                    <a href="#" class="actBtns textFormatBtn" onclick="toggleVisibility('txttool')"><img src="/SPActivityHub-portlet/images/ac-icon-a.svg"></a>
                                    <a href="#" class="attachmentBtn" onclick="toggleVisibility('attachNotes')"><img src="/SPActivityHub-portlet/images/attachment.svg"></a>
                            
                                    <div class="actLink"></div>
                           
                                    <div class="linkTools" id="linkToolsWrap">
                                          <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                                        <h2>ADD LINK</h2>
                                        <input type="text" required="required" id="nLinkTxt" name="" value="" placeholder="Link Text">
                                        <input type="text" required="required" id="nLinkUrl" placeholder="URL">
                                        <div class="linkActions">
                                            <a href="#" class="linkAnchor" id="applyBtnNote">Apply</a>
                    						<a href="#" class="linkAnchor" id="cancelBtnLinkNote">Cancel</a>
                                        </div>
                                    </div>
                                    <div class="txtFormatTools" id="txttool">
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
                                     <div class="convAttchment" id="attachNotes">
                                         <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                                        <div class="input-file-container">
                                            <input type="hidden" id="uploadsFileEntryIdNote" value="0">
                                            <input class="input-file" type="file" id="noteFile" multiple />
                                            <label tabindex="0" for="noteFile" class="input-file-trigger">Upload from computer</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="actionLinkwrap">
                                   
                                    <a class="actionButton" href="#" id="saveNote">SAVE IT</a>
                                </div>
                            </div>


<script type="text/javascript" src="/SPActivityHub-portlet/js/SPNote/spNote.js?t=<%=DateUtil.newTime() %>"></script>
<script src="/SPActivityHub-portlet/js/fileUploadActivityHub.js?t=<%=DateUtil.newTime() %> "></script>

<script type="text/javascript">
var A;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
		'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A1) {
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
	var obj = new spNote({pns:pns, ajaxUrl:ajaxUrl, entityId:entityId, entityClassId:entityClassId, entityClassName:entityClassName, ajaxUrlFileUpload:ajaxUrlFileUpload, extUser:extUser, associatedWith:associatedWith, closedStageId:closedStageId});
});




</script>


