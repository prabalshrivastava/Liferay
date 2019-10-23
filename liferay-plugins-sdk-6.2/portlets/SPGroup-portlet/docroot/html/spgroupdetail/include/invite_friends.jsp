<%@page import="com.sambaash.platform.model.SPGroupType"%>
<c:if test="<%= spGroup.getType() == SPGroupType.PUBLIC.getValue() || spGroup.getType() == SPGroupType.MEMBERS_ONLY.getValue() %>">
	<div align="center" class="sp-group-if-guideline">
		<div align="left" class="sp-group-clearfix" style="width: 400px">
			<div class="sp-group-lfloat sp-group-mrm" style="line-height: 1;"><img src="${ctx}/images/InviteFriends_icon.png" alt="Invite"/></div>
			<div class="sp-group-ui-oh">
				<div class="sp-group-ui-dib">
					<div class="sp-group-ui-dib sp-group-ui-vam" style="height: 51px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
						<h1 style="color: #FFFFFF; margin-bottom: 5px;;"><liferay-ui:message key="label.invite.friends" /></h1>
						<p><liferay-ui:message key="label.click.to.invite.friends" /></p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<ul class="sp-group-tabs horizontal" id="<portlet:namespace />inviteFriendsTabsContainer" style="padding-bottom: 8px; border-bottom: 0 none;">
		<li style="width: 25%;"><a id="<portlet:namespace />inviteFriendsGmailTab" href="javascript:;" style="background-color: #D45648; padding: 15px 0; text-align: center;"><img alt="Gmail" src="${ctx}/images/Gmail.png" /><span style="display: block;">Gmail</span></a></li><li style="width: 25%;">
			<a href="javascript:;" id="<portlet:namespace />inviteFriendsFacebookTab" style="background-color: #406290; padding: 15px 0; text-align: center;"><img alt="Facebook" src="${ctx}/images/Facebook.png" /><span style="display: block;">Facebook</span></a></li><li style="width: 25%;">
			<a href="javascript:;" id="<portlet:namespace />inviteFriendsTwitterTab" style="background-color: #56B0CA; padding: 15px 0; text-align: center;"><img alt="Twitter" src="${ctx}/images/Twitter.png" /><span style="display: block;">Twitter</span></a></li><li style="width: 25%;">
			<a href="javascript:;" id="<portlet:namespace />inviteFriendsEmailTab" style="background-color: #795B9B; padding: 15px 0; text-align: center;"><img alt="Email" src="${ctx}/images/email.png" /><span style="display: block;">Email</span></a></li>
	</ul>

	<div id="<portlet:namespace />inviteFriendsGmailContent" style="display: none;">

	</div>
	<div id="<portlet:namespace />inviteFriendsFacebookContent" style="display: none;">

	</div>
	<div id="<portlet:namespace />inviteFriendsTwitterContent" style="display: none;">

	</div>
	<div id="<portlet:namespace />inviteFriendsEmailContent" style="margin: 20px 14px;">
		<form action="<%= inviteFriendsByEmailURL %>" data-tf-class-pk="" data-tf-dom-id="tags-form" method="POST" name="<portlet:namespace/>editTagsForm" onsubmit="editTags(event)">
			<input name="<portlet:namespace />urlTitle" type="hidden" value="<%= spGroup.getUrlTitle() %>" />
			<input name="<portlet:namespace />spGroupId" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
			<div class="tagselector" data-tag-dom-id="tags-selector-container">
				<div class="tagselector-content textboxlist-content categoriesselector-content">
					<ul class="helper-clearfix textboxlistentry-holder" data-tag-dom-id="tags-selector-entries-holder">
						<li class="textboxlist-input-container">
							<input class="lfr-tag-selector-input field-input-text" data-tag-dom-id="tags-selector-input" size="25" title="Add Tags" type="text">
						</li>
					</ul>
					<a data-tag-dom-id="tags-selector-add-btn"><liferay-ui:message key="label.add" /></a>
				</div>
				<input data-tag-dom-id="tags-selector-hidden-input" name="<portlet:namespace />assetTagNames" type="hidden" value="" />
			</div>
			<input name="<portlet:namespace />saveTags" type="submit" value="Invite" />
		</form>

	</div>

	<script type="text/javascript">

		var inviteFriendsTabsContainer = document.getElementById("<portlet:namespace />inviteFriendsTabsContainer");

		var inviteFriendsGmailTab = document.getElementById("<portlet:namespace />inviteFriendsGmailTab");
		var inviteFriendsFacebookTab = document.getElementById("<portlet:namespace />inviteFriendsFacebookTab");
		var inviteFriendsTwitterTab = document.getElementById("<portlet:namespace />inviteFriendsTwitterTab");
		var inviteFriendsEmailTab = document.getElementById("<portlet:namespace />inviteFriendsEmailTab");

		var inviteFriendsGmailContent = document.getElementById("<portlet:namespace />inviteFriendsGmailContent");
		var inviteFriendsFacebookContent = document.getElementById("<portlet:namespace />inviteFriendsFacebookContent");
		var inviteFriendsTwitterContent = document.getElementById("<portlet:namespace />inviteFriendsTwitterContent");
		var inviteFriendsEmailContent = document.getElementById("<portlet:namespace />inviteFriendsEmailContent");

		addEventHandler(inviteFriendsGmailTab, "click", inviteFriendsGmailTabOnClick);
		addEventHandler(inviteFriendsFacebookTab, "click", inviteFriendsFacebookTabOnClick);
		addEventHandler(inviteFriendsTwitterTab, "click", inviteFriendsTwitterTabOnClick);
		addEventHandler(inviteFriendsEmailTab, "click", inviteFriendsEmailTabOnClick);

		function inviteFriendsGmailTabOnClick(e) {
		try{
			preventDefault(e);
			inviteFriendsTabsContainer.style.backgroundColor = "#D45648";

			addClass(inviteFriendsGmailTab, "active");
			removeClass(inviteFriendsFacebookTab, "active");
			removeClass(inviteFriendsTwitterTab, "active");
			removeClass(inviteFriendsEmailTab, "active");

			inviteFriendsGmailContent.style.display = "block";
			inviteFriendsFacebookContent.style.display = "none";
			inviteFriendsTwitterContent.style.display = "none";
			inviteFriendsEmailContent.style.display = "none";
		}catch(err) {
			alert(err);
		}
		}

		function inviteFriendsFacebookTabOnClick(e) {
		try{
			preventDefault(e);
			inviteFriendsTabsContainer.style.backgroundColor = "#406290";

			removeClass(inviteFriendsGmailTab, "active");
			addClass(inviteFriendsFacebookTab, "active");
			removeClass(inviteFriendsTwitterTab, "active");
			removeClass(inviteFriendsEmailTab, "active");

			inviteFriendsGmailContent.style.display = "none";
			inviteFriendsFacebookContent.style.display = "block";
			inviteFriendsTwitterContent.style.display = "none";
			inviteFriendsEmailContent.style.display = "none";
		}catch(err) {
			alert(err);
		}
		}

		function inviteFriendsTwitterTabOnClick(e) {
		try{
			preventDefault(e);
			inviteFriendsTabsContainer.style.backgroundColor = "#56B0CA";

			removeClass(inviteFriendsGmailTab, "active");
			removeClass(inviteFriendsFacebookTab, "active");
			addClass(inviteFriendsTwitterTab, "active");
			removeClass(inviteFriendsEmailTab, "active");

			inviteFriendsGmailContent.style.display = "none";
			inviteFriendsFacebookContent.style.display = "none";
			inviteFriendsTwitterContent.style.display = "block";
			inviteFriendsEmailContent.style.display = "none";
		}catch(err) {
			alert(err);
		}
		}

		function inviteFriendsEmailTabOnClick(e) {
		try{
			preventDefault(e);
			inviteFriendsTabsContainer.style.backgroundColor = "#795B9B";

			removeClass(inviteFriendsGmailTab, "active");
			removeClass(inviteFriendsFacebookTab, "active");
			removeClass(inviteFriendsTwitterTab, "active");
			addClass(inviteFriendsEmailTab, "active");

			inviteFriendsGmailContent.style.display = "none";
			inviteFriendsFacebookContent.style.display = "none";
			inviteFriendsTwitterContent.style.display = "none";
			inviteFriendsEmailContent.style.display = "block";
		}catch(err) {
			alert(err);
		}
		}

	</script>

	<script type="text/javascript">

		/**
		* Ajax Get
		*/
		function AjaxGet(url, successFunc, errorFunc) {
		try{
			if (window.XMLHttpRequest) {
				// code for IE7+, Firefox, Chrome, Opera, Safari
			  	xhr = new XMLHttpRequest();
			}
			else {
				// code for IE6, IE5
			 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
				    if (xhr.status == 200) {
				    	successFunc();
				    }
				    else {
				    	errorFunc();
				    }
				}
			};

		   xhr.open("GET", url, true);
		   xhr.send(null);

		}catch(err) {
			// alert("-AjaxGet: " + err);
		}
		}

		function editTags(e) {
		try{
			preventDefault(e);
			var tags_form = getEventTarget(e);
			var asset_tag_names = tags_form.elements["<portlet:namespace />assetTagNames"].value;
			var url_title = tags_form.elements["<portlet:namespace />urlTitle"].value;
			var sp_group_id = tags_form.elements["<portlet:namespace />spGroupId"].value;
	        if (asset_tag_names.length == 0) {
				alert("Please at least input one email address.");
	        }else {

				var temp_url = tags_form.getAttribute("action");
				temp_url += "&url_title=" + url_title + "&sp_group_id=" + sp_group_id + "&asset_tag_names=" + asset_tag_names;
				AjaxGet(temp_url, editTagsSuccess, editTagsError);

	        	//tags_form.submit();
	        }
		}catch(err) {
			alert("-editTags: " + err);
		}
		}

		function editTagsSuccess() {
		try{
			var data = JSON.parse(xhr.responseText);
			var success_msg = data.success_msg;
			alert(success_msg);
		}catch(err) {
			alert("-editTagsSuccess: " + err);
		}
		}

		function editTagsError() {
		try{
			alert("Oops! An error occurred while processing your request.");
		}catch(err) {
			alert("-editTagsError: " + err);
		}
		}

	</script>

	<style type="text/css">

		.textboxlistentry-close:hover {
			background-color: #CAD8F3;
		}
		.tagselector-content {
			border: 1px solid #DDDDDD;
			padding: 10px 10px 5px;
		}
		.categoriesselector-content .textboxlistentry-holder {
		    border-bottom: 1px solid #DDDDDD;
		    padding: 0 0 6px;
		    min-height: 28px;
		}

	</style>

</c:if>
