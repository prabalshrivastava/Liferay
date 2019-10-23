<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@	page import="com.sambaash.platform.activityhub.helper.SPActivityHubHelper"%>

<portlet:defineObjects />
<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
User loggedInUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
String extUserStr = SPActivityHubHelper.checkInternalOrExternal(renderRequest, loggedInUser);

%>

 <div class="intrWrapper ">
        <div class="interactionDiv open-activity">
            <img class="intIcon" src="/SPActivityHub-portlet/images/interaction.svg">
            <p class="intname">Interactions</p>
        </div>
        <section class="acContentContainer">
            <div class="actCloseIcon close-activity">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30">
                    <g fill="none" fill-rule="evenodd">
                        <circle cx="15" cy="15" r="15" fill="#C1CFE1" />
                        <g stroke="#FFF" stroke-linecap="square" stroke-width="2">
                            <path d="M19.192 11l-7.778 7.778M11.192 11l7.779 7.778" />
                        </g>
                    </g>
                </svg>
            </div>
            <div class="intrContentWrap">
                <!-- TOP SECTION -->
                <div id="myTab" class="aHtabcontWrapper">
                    <ul class="nav nav-tabs activityTabs" id="topActSectionTab">
                        <%if (extUserStr == "Internal"){ %>
                        	<li class="active"><a href="#tab-note" id="noteId">ADD NOTES</a></li>
                         	<li><a href="#tab-convos" id="converseId">CONVERSE</a></li>
                         	<li><a href="#tab-logActivity" id="logActivityId">LOG ACTIVITY</a></li>
                         <%} else { %>
                         	<li class="active"><a href="#tab-convos" id="converseId">CONVERSE</a></li>
                         <%}%>
                    </ul>
                    <div class="activitytab-content tab-content">
                    	<%if (extUserStr == "Internal"){ %>
                        <div id="tab-addnote" class="tab-pane">
                        	<jsp:include page="/html/SPNote/SPNoteAdd.jsp"  />
                        </div>
                        <div id="tab-convos" class="tab-pane">
                        	<jsp:include page="/html/SPConversation/SPConversationAdd.jsp"  />
                        </div>
                         <div id="tab-logActivity" class="tab-pane">
                        	<jsp:include page="/html/SPLogActivity/SPLogActivityAdd.jsp"  />
                        </div>
                        <%} else { %>
                         <div id="tab-convos" class="tab-pane">
                        	<jsp:include page="/html/SPConversation/SPConversationAdd.jsp"  />
                        </div>
                        <%}%>
                    </div>
                   
                </div>
                <!-- bottom SECTION -->
                <div id="myTab1" class="aHtabcontWrapper bgInside">
                    <ul class="activityTabs bg-tav2">
                       
                     <%if (extUserStr == "Internal"){ %>  
                        <li id="tabNotesListId" class="active"><a href="#tabNotes" id="notesLoad">NOTES</a></li> 
                        <li id="tabConvListId"><a href="#tabConvos" id="convLoad">CONVOS</a></li>
                        <li id="tabLogActivityListId"><a href="#tabActivity" id="logActivityLoad">ACTIVITY</a></li>
                     <%}else { %>
                     	<li id="tabConvListId" class="active"><a href="#tabConvos" id="convLoad">CONVOS</a></li>
                     <%}%>
                    </ul>
                    <div class="tab-content activitytab-content">
                    <%if (extUserStr == "Internal"){ %> 
                       <jsp:include page="/html/SPNote/SPNoteList.jsp"  /> 
                       <jsp:include page="/html/SPConversation/SPConversationList.jsp"  />
                       <jsp:include page="/html/SPLogActivity/SPLogActivityList.jsp"  />
                     <%}else { %>
                     	<jsp:include page="/html/SPConversation/SPConversationList.jsp"  /> 
                     <%}%>
                    </div>
                </div>
            </div>
        </section>
    </div>


 <script  type="text/javascript" src="/SPActivityHub-portlet/js/main.js?t=<%=DateUtil.newTime() %> "></script>
 



<script type="text/javascript">
    //TEXT FORMATS
document.querySelectorAll("[data-edit]").forEach(function (btn) {
     btn.addEventListener("click", editAct)
});

function editAct(ev) {
  ev.preventDefault();
  const cmd_val = this.getAttribute("data-edit").split(":");
  document.execCommand(cmd_val[0], false, cmd_val[1]);
}


//ACTIVITY OPEN AND CLOSE

if (document.getElementsByClassName("open-activity").length > 0){
    

var closeActivity = document.documentElement; 


var currentUrl = window.location.href;

if (currentUrl.includes("convUuid")){
	closeActivity.classList.add('activeintraction');
	var notesTab = document.getElementById('tabNotesListId');
	if (notesTab){
		notesTab.classList.remove('active');
		document.getElementById('tabNotes').classList.remove('active');
	}
	var convTab = document.getElementById('tabConvListId');
	if (convTab){
		convTab.classList.add('active');
		document.getElementById('tabConvos').classList.add('active');
	}
}


document.querySelector('.open-activity').onclick = function() {
    closeActivity.classList.add('activeintraction');

};

document.querySelector('.close-activity').onclick = function() {
    closeActivity.classList.remove('activeintraction');
    var dateLogAct = document.getElementById('logActivityDate');
    if (dateLogAct){
    	dateLogAct.value = "";
    }
    
    var timeLogAct = document.getElementById('logActivityTime');
    if (timeLogAct){
    	timeLogAct.value = "";
    }
    


};

closeActivity.onclick = function(event) {
    if (event.target === closeActivity) {
        closeActivity.classList.remove('acContentContainer');
    }
};

}
</script>

   
