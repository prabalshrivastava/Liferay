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


Long userAssociatedWithPortraitId = 0L;
if (!associatedWith.equalsIgnoreCase("0")){
userAssociatedWithPortraitId = UserLocalServiceUtil.getUser(Long.valueOf(associatedWith)).getPortraitId();
}

User loggedInUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
String extUserStr = SPActivityHubHelper.checkInternalOrExternal(renderRequest, loggedInUser);

SPActivityHubHelper helper = SPActivityHubHelper.getInstance();
String userList = helper.loadUsers(renderRequest, themeDisplay);

long closedStageId = 0;
if (entityClassName.contains("ProcessState") && !entityId.equalsIgnoreCase("0")){
	closedStageId = PEProcessStateLocalServiceUtil.getPEProcessState(GetterUtil.getLong(entityId)).getClosedStageId();
}

%>


    <div class="actConvs">
        <div type="checkbox" id="selectPasted"> </div>
        <div contenteditable="true" id="conversationTxtArea" class="contentEditWrap contentEditError conversation Requiredfield" onchange="validateContentArea(this)">
        </div>
        <span class="actErrorNotif"><img src="/SPActivityHub-portlet/images/act-error.svg">This field is required</span>
    </div>
    <p class="file-return" id="fp"></p>
    <div class="activityCreateActions ">
        <div class="actactionsIcons" id="myToggler">
            <a href="#" class="actBtns inActiveBtn" onclick="toggleVisibility('linkToolsWrap_1')"><img src="/SPActivityHub-portlet/images/inactive.svg"></a>
            <a href="#" class="actBtns textFormatBtn" onclick="toggleVisibility('txttool_1')"><img src="/SPActivityHub-portlet/images/ac-icon-a.svg"></a>
            <a href="#" class="attachmentBtn"  onclick="toggleVisibility('conatcTool')"><img src="/SPActivityHub-portlet/images/attachment.svg"></a>
            <% if (extUserStr == "Internal") {%>
            <a href="#" class="userLockBtn" id="userLockBtnId" onclick="toggleVisibilityUser('userSelectsec')"><img src="/SPActivityHub-portlet/images/lock-unclock.svg" alt="UnLock user" class="show" id="convLock">
            <img src='/SPActivityHub-portlet/images/lock.svg' class="hide" alt="Lock user" id="convunLock">
        </a>
            <%} %>
            <div class="actLink">
               
            </div>
            <div class="actPrivate" id="userSelectDiv">
                
            </div>
            <div class="linkTools" id="linkToolsWrap_1">
                <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                <h2>ADD LINK</h2>
                <input type="text" required="required" id="cLinkTxt" name="" value="" placeholder="Link Text">
                <input type="text" required="required" id="cLinkUrl" placeholder="URL">
                <div class="linkActions">
                    <a href="#" class="linkAnchor" id="applyBtn">Apply</a>
                    <a href="#" class="linkAnchor" id="cancelBtnLink">Cancel</a>
                </div>
            </div>
            <div class="txtFormatTools" id="txttool_1">
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
                                    <button class="btnAc btn-default" data-edit="insertUnorderedList"><img src="/SPActivityHub-portlet/images/textFormat-icons/ul-list.svg"></button>
                                    <button class="btnAc btn-default" data-edit="insertOrderedList"><img src="/SPActivityHub-portlet/images/textFormat-icons/ol-list.svg"></button>
                </div>
            </div>
            <div class="convAttchment" id="conatcTool">
                 <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                <div class="input-file-container">
                    <input type="hidden" id="uploadsFileEntryIdConv" value="0">
                    <input class="input-file" type="file" id="convFile" multiple />
                    <label tabindex="0" for="convFile" class="input-file-trigger">Upload from computer</label>
                </div>
            </div>
            <div class="inserUserWrap" id="inserUserWrap_id">
                 <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                <div class="listingUserContainer" id="inserUserWrapUL_id">
                </div>
            </div >
            <label for="enterpriseToBeSavedIdCreate"></label>
            <div class="userSelectsection" id="userSelectsec">
                 <span class="closePopupActions"><img src="/SPActivityHub-portlet/images/cancelactivity.svg"></span>
                <div class="has-float-label margin-top-20">
                   <input id="enterpriseIdCreate" type="hidden">
                    <div id="SelectedEnterpriseCreate" class="SelectedUserCreate selectedList"></div>
                </div>
                <div class="searchuserselect">
                    <img src="/SPActivityHub-portlet/images/searchuser.svg">
                    <input name="enterpriseToBeSavedCreate" id="enterpriseToBeSavedIdCreate" type="hidden" class="Requiredfield autoComplete" placeholder="Select User">
                    <input name="enterpriseListCreate" class="enterpriseListCreate selectedListInput" id="enterpriseListIdCreate" placeholder="Select User">
                </div>
            </div> 
        </div>
        
        <div class="actionLinkwrap">
        <% if (extUserStr == "Internal" && Validator.isNotNull(associatedWith) && !associatedWith.equalsIgnoreCase("0")) {%>
              <div class="actAccociate" id="asoociateAct">
                   <p>Associated<br> with</p>
                   <img src="<%=UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, userAssociatedWithPortraitId) %>">
                   <div class="activeIconAssociate" id="ascRemoveAction" onclick="associateRemove()"><img src="/SPActivityHub-portlet/images/associate-close.svg">

                   </div>
              </div>
         <%} %>
            <a class="actionButton" href="#" id="saveMessage">SHOOT IT</a>
        </div>
        
    </div>



<script type="text/javascript" src="/SPActivityHub-portlet/js/SPConversation/spConversation.js?t=<%=DateUtil.newTime() %>"></script>
<script src="/SPActivityHub-portlet/js/typeAheadSearch.js?t=<%=DateUtil.newTime() %> "></script>
<script src="/SPActivityHub-portlet/js/fileUploadActivityHub.js?t=<%=DateUtil.newTime() %> "></script>

<script type="text/javascript">

<%if (extUserStr == "Internal") {%>
var userListJSON = <%= userList%>;
initializeUserSearch();

function initializeUserSearch() {
    var className = ".enterpriseListCreate";
    var sourceJSON = userListJSON;
    var valueToBeSaved = "enterpriseToBeSavedIdCreate";
    var idToBeSaved = "enterpriseIdCreate";
    var displayDiv = "SelectedEnterpriseCreate";
    var inputNodeId = "enterpriseListIdCreate";
    var placeHolder = "Add a user";
    var obj = new typeAheadSearch({
        className : className,
        sourceJSON : sourceJSON,
        valueToBeSaved : valueToBeSaved,
        idToBeSaved : idToBeSaved,
        displayDiv : displayDiv,
        inputNodeId : inputNodeId,
        placeHolder : placeHolder
    });
}
<%}%>

var A;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
        'stylesheet','aui-datepicker','overlay','event', 'widget-anim', 'node-event-simulate', function(A1) {
    A = A1;
    var pns ="<portlet:namespace/>";
    var ajaxUrl = "<%= ajaxUrl %>";
    var entityId = "<%= entityId %>";
    var entityClassId = "<%= entityClassId %>";
    var entityClassName = "<%= entityClassName %>";
    var associatedWith = "<%= associatedWith %>";
    var ajaxUrlFileUpload = "<%= ajaxUrlFileUpload %>";
    var extUser = "<%= extUserStr %>";
    var closedStageId = "<%= closedStageId%>";
    var obj = new spConversation({pns:pns, ajaxUrl:ajaxUrl, entityId:entityId, entityClassId:entityClassId, entityClassName:entityClassName, ajaxUrlFileUpload:ajaxUrlFileUpload, extUser:extUser, associatedWith:associatedWith, closedStageId:closedStageId});
});




</script> 
