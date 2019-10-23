<%@page import="com.sambaash.platform.util.NotificationUtils"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="resourceURL" >
</portlet:resourceURL>

<section class="sp-inbox max-width padding-left-75 padding-right-75 padding-top-one padding-bottom-one box-sizing-border block   font-none">
	<div class="sp-inbox-wrap relative block">
		<section class="sp-inbox-section sp-inbox-section-left font-std inline-block width-20 align-top box-sizing-border ">
			
			
			<div class="sp-inbox-menu white">
				<div class="sp-inbox-compose btn-callout full-width text-center"> 
					<span id="compose">Compose</span>
				</div>
				
				<nav class="sp-inbox-menu-list block">
					<ul>
					
						<li class="in-menu-item ">
							<span id="inbox">Inbox <span id="unreadInbCount" class="callout-notification-count"></span></span>
							
							<ul>
								<li class="in-menu-item"> <span id="requests">Request <span id="unreadReqCount" class="callout-notification-count"></span></span> </li>
								<li class="in-menu-item"> <span id="invitations">Invitations <span id="unreadInvCount" class="callout-notification-count"></span></span> </li>
								<li class="in-menu-item"> <span id="notifications">Notifications <span id="unreadNotfCount" class="callout-notification-count"></span></span></li>
								<li class="in-menu-item"> <span id="groupAlerts">Group alerts <span id="unreadGrpAlertCount" class="callout-notification-count"></span></span> </li>
								<li class="in-menu-item"> <span id="jobAlerts">Job alerts <span id="unreadJobAlertCount" class="callout-notification-count"></span></span> </li>
							</ul>
						</li>
						
						<li class="in-menu-item">
							<span id="sentMsgs">Sent</span>
						</li>
						<li  class="in-menu-item">
							<span id=draftMsgs>Drafts</span>
						</li>
						
						<li  class="in-menu-item">
							<span id="archivedMsgs">Archived</span>
						</li>
					
					</ul>
				</nav>
				
					
			</div>
		
		</section>
		<section class="sp-inbox-section sp-inbox-section-right font-std inline-block width-80 align-top box-sizing-border white-bg ">
		
			<div id="inboxDiv">
				<div id="contetHeaderDiv" class="block text-left">
					<div class="sp-inbox-head font-none padding-half block table-header-bg">
						<div id="folderHeading" class="sp-inbox-head-text h2 inline-block align-middle text-left width-60"></div>
						<div class="sp-inbox-search sp-inbox-head-search inline-block align-middle font-std text-right width-40">
								<input id="searchtext" type="text" class="inline-block align-middle font-std ">
								<button class="btn-primary" value="search"  id="searchB" class="inline-block align-middle font-std ">Search</button>
						</div>
					</div>
					<div id="filters" class="sp-inbox-filters">
						<div id="inboxFilters">
							<span>View message by</span>
							<select id="filter1">
								<option>All</option>
								<option>Read</option>
								<option>Unread</option>
								<option>Replied</option>
								<option>Forwarded</option>
							</select>
						</div>
					</div>
					<div id="actions" class="sp-inbox-actions">
							<div id="deleteSelectedDiv">
								<a href="javascript:;" id="delete">Delete</a>
							</div>
							<div id="archievSelectedDiv">
								<a href="javascript:;" id="archieve">Archive</a>
							</div>
					</div>
				</div>
				<div id="contentBodyDiv" class="full-width box-sizing-border">
					<table id="mailsTable" class="full-width">
						
					</table>
				</div>
				<div id="contentFooter" class="block font-none padding-left-half padding-right-half padding-bottom-half">
					<div class="inline-block half-width align-middle text-left font-10">
						<div id="showingMails" class="inline-block"></div>
						<div id="pageNumsDiv" class="inline-block">
						Page:
							<select id="pageNums">
							</select>
							<span id="totalPageCountSpan"></span>
						</div>
					</div>
					<div class="inline-block half-width align-middle text-right font-10">
						<div id="firstPageDiv" class="inline-block"> <a href="javascript:;" id="firstPage">First</a></div>
						<div id="nextPageDiv" class="inline-block"> <a href="javascript:;" id="nextPage">Next</a></div>
						<div id="prevPageDiv" class="inline-block"> <a href="javascript:;" id="prevPage">Prev</a></div>
						<div id="lastPageDiv" class="inline-block"> <a href="javascript:;" id="lastPage">Last</a></div>
					</div>
				</div>
			</div>
			
			<div id="samples" style="display: none">
				<table>
					<tr id="sampleMailRowHeader">
						<td id="selectAllTd"><input type="checkbox" id="sampleSelectAll" /></td>
						<td>From</td>
						<td>Subject</td>
						<td>Date</td>
					</tr>
					<tr id="sampleMailRow">
						<td><input type="checkbox" id="sampleSelect" /> <input
							type="hidden" id="sampleRowId" /></td>
						<td id="from"></td>
						<td id="subject"></td>
						<td id="date"></td>
					</tr>
					<tr id="nomessagesRow">
					  <td>No messages</td>
					</tr>
			
				</table>
				<div id="viewMsgDiv">
					<div>
					
						<div class="viewMsgHead block border-bottom padding-bottom-half">
							<span id="viewMsgSubjectValue" class="block font-18 bold padding-bottom-quarter	"></span>
							<div id="viewMsgFromDiv" class="formTextField fw">
								<label class="inline-block align-middle margin-none">From:</label> <span class="inline-block align-middle padding-left-quarter" id="viewMsgFromValue"></span>
							</div>
							<div id="viewMsgDateDiv" class="formTextField fw">
								<label class="inline-block align-middle margin-none">Date:</label> <span class="inline-block align-middle padding-left-quarter" id="viewMsgDateValue"></span>
							</div>
							<div id="viewMsgToDiv" class="formTextField fw">
								<label class="inline-block align-middle margin-none">To:</label> <span class="inline-block align-middle padding-left-quarter" id="viewMsgToValue"></span>
							</div>
						</div>
						<div id="viewMsgContentDiv" class="block align-middle padding-top-half padding-bottom-half"></div>
					</div>
				</div>
			</div>
			
			<div id="msgConversation" class="padding-half">
			
				<div id="viewMsgActionsDiv" class="block padding-top-half text-left">
								<div id="viewMsgCancelDiv" class="inline-block align-middle">
									<button class="btn-primary" id="viewMsgCancel">Cancel</button>
								</div>
								<div id="viewMsgForwardDiv" class="inline-block align-middle">
									<button class="btn-primary" id="viewMsgForward">Forward</button>
								</div>
								<div id="viewMsgReplyDiv" class="inline-block align-middle">
									<button class="btn-primary" id="viewMsgReply">Reply</button>
								</div>
								<div id="viewMsgReplyAllDiv" class="inline-block align-middle">
									<button class="btn-primary" id="viewMsgReplyAll">Reply To All</button>
								</div>
				</div>
			</div>
			
			<div id="cmpseMsgDiv">
				<div>
					<div id="cmpMsgFromDiv">
					<!-- 	<div class="formTextField fw">
							<label class="inline-block align-middle margin-none">From:</label>
							<span class="inline-block align-middle margin-none padding-left-quarter" id="cmpMsgFromValue"></span>
						</div>  -->
					</div>
					<div id="cmpMsgToDiv">
						<div class="formTextField fw">
							<input name="cmpMsgToValue" type="hidden" />
							<div id="cmpMsgToInnerDiv">
								<label for="ip_to" class="inline-block align-middle margin-none"> <span >To:</span></label>
								<div class="sp-group-nonuple-column sp-group-column sp-group-of-ten" >
									<div data-autocomplete-dom-id="sis-holder" data-group-id="0" class="ip-to">
										<ul data-autocomplete-dom-id="selected-items" class="horizontal sp-group-ui-dib sp-group-ui-vam">
											
										</ul>
										<span class="ip-to-input-outer block">
											<span class="hide" style="visibility: hidden; z-index: -10000; position: relative; width: 100%;">
												Add Email Address
											</span>
											<input data-autocomplete-dom-id="input" id="ip_to" type="text" tabindex="0" placeholder="Add Email Address" autocomplete="off" value="" class="ip-to-input" />
										</span>
									</div>
									<div data-autocomplete-dom-id="suggestions-board" class="ip-sb"
										style="display: none;">
										<div data-autocomplete-dom-id="close-btn" class="ip-sb-c"></div>
										<div data-autocomplete-dom-id="options" class="ip-sb-options"></div>
				
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="cmpMsgSubjectDiv" class="block padding-bottom-half">
						<div class="formTextField fw">
							<label>Subject:</label>
							<div id="cmpMsgSubjectDivInner">
								<input type="text" size="150" id="cmpMsgSubjectValue"></input>
							</div>
						</div>
					</div>
					<div id="cmpMsgContentDiv">
						<div id="cmpMsgContentDivInner">
						<form>
							<textarea name="<portlet:namespace />cmpMsgContent" id="cmpMsgContent" rows="20" cols="40">
							
							</textarea>
						</form>
						</div>
					</div>
					<div>
						<div>
						 	<input type="checkbox" id="cmpMsgAllowOpen" class="inline-block align-middle"/>
							<label for="openAdresses" class="inline-block align-middle">Allow recipients to see each other's names and email addresse</label>
						 </div>
						<div>
							<input type="checkbox" id="cmpMsgSendCopy" class="inline-block align-middle"/>
							<label for="sendCopy" class="inline-block align-middle">Send me a copy</label>
						</div>
					</div>
					<div id="cmpMsgActionsDiv" class="block padding-top-half">
						<div id="cmpMsgCancelDiv" class="inline-block">
							<button class="btn-primary" id="cmpMsgCancel">Cancel
							</button>
						</div>
						<div id="cmpMsgSaveDraftDiv" class="inline-block">
							<button class="btn-primary"  id="cmpMsgSaveDraft">Save as Draft
							</button>
						</div>
						<div id="cmpMsgSendDiv" class="inline-block">
							<button class="btn-primary" id="cmpMsgSend">Send
							</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</section>
<script src="<%= themeDisplay.getPathJavaScript() %>/editor/ckeditor/ckeditor.js" type="text/javascript">
</script>
<script src="/SPInbox-portlet/js/auto_complete.js" type="text/javascript"></script>
<script src="/SPInbox-portlet/js/inboxCons.js" type="text/javascript"></script>
<script src="/SPInbox-portlet/js/inbox.js" type="text/javascript"></script>
<script>
var ajax = '<%= resourceURL %>';
var screenName = '<%= themeDisplay.getUser().getScreenName() %>';
var communityName = '<%= SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId())%>';
var websocketUrl = '<%= NotificationUtils.getWebSocketUrl() %>';
var websockConfgObj = {
		screenName:screenName,
		communityName:communityName,
		websocketUrl:websocketUrl
}
initialize(ajax,'${initialView}',websockConfgObj);
</script>
