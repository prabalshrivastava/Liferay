<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/html/common/init.jsp" %>
<portlet:defineObjects />

<%
	String totalCount = String.valueOf(renderRequest
			.getAttribute("totalCount"));
	String scheduleIcon = String.valueOf(renderRequest
			.getAttribute("scheduleIcon"));
	String previewIcon = String.valueOf(renderRequest
			.getAttribute("previewIcon"));
	String textcontentIcon = String.valueOf(renderRequest
			.getAttribute("textcontentIcon"));
	String createPageName = String.valueOf(renderRequest
			.getAttribute("createPageName"));
	String archiveIcon = String.valueOf(renderRequest
			.getAttribute("archiveIcon"));
	int totalCol = Integer.valueOf(String.valueOf(renderRequest
			.getAttribute("totalCol")));
	String chkEnableRem1 = String.valueOf(renderRequest.getAttribute("chkEnableRem1"));
	String chkEnableRem2 = String.valueOf(renderRequest.getAttribute("chkEnableRem2"));
	String chkEnableRem3 = String.valueOf(renderRequest.getAttribute("chkEnableRem3"));
	String chkEnableThankYou = String.valueOf(renderRequest.getAttribute("chkEnableThankYou"));
	String chkEnableMissYou = String.valueOf(renderRequest.getAttribute("chkEnableMissYou"));
%>

<c:choose>
	<c:when test="${!hasAccess}">
		<h3>You don't have the permission to access this url!"</h3>
	</c:when>
	<c:otherwise>
		<div class="rsvpbox-title" style="width: 100%;">Campaign</div>
		<div class="rsvp-preference-border screen-max-width"" style="min-height: 300px;">
			<div id="rsvpDiv" style="width: 100%; padding: 10px 0;">
				<div class="addClass">
					<span><a href="/create-campaign">+ Add Campaign</a></span>
				</div>
				
				<c:if test="${successMsgTemplate}">
						<div id="successMsgTemplate"
							style="background: #f2f2f2; color: green; font-weight: bold; margin-top: 10px; padding: 10px; height: 40px; width: 100%; margin-bottom: 10px;">
							Subscribers are added successfully for campaign "${campaignNameIp}"!</div>
</c:if>
				<c:if test="${updateMessage}">
					<div id="successMsgTemplate"
						style="background: #f2f2f2; color: green; font-weight: bold; margin-top: 10px; padding: 10px; height: 45px; width: 100%; margin-bottom: 10px;">
						Campaign is successfully updated.</div>
				</c:if>
				<div id="existingDiv" style="min-height: 200px;">
					<table id="rsvpDetails">
						<tr style="height: 30px; font-weight: bold;">
							<td class="template-list" colspan="${totalCol}">Mail
								Campaign List</td>
						</tr>

						<tr style="height: 30px; font-weight: bold;">
							<td class="mailtemplate-list-title">Campaign Name</td>
							<td class="mailtemplate-list-title ${chkEnableRem1} sdsdsdsd ${chkEnableRem2} wweeew ${chkEnableRem3}">Scheduled Date</td>
							<c:if test="${chkEnableRem1=='on'}">
								<td class="mailtemplate-list-title">Reminder1 Scheduled</td>
							</c:if>

							<c:if test="${chkEnableRem2=='on'}">
								<td class="mailtemplate-list-title">Reminder2 Scheduled</td>
							</c:if>

							<c:if test="${chkEnableRem3=='on'}">
								<td class="mailtemplate-list-title">Reminder3 Scheduled</td>
							</c:if>

							<c:if test="${chkEnableThankYou=='on'}">
								<td class="mailtemplate-list-title">Thank You Scheduled</td>
							</c:if>

							<c:if test="${chkEnableMissYou=='on'}">
								<td class="mailtemplate-list-title">Miss You Scheduled</td>
							</c:if>

							<!-- <td class="mailtemplate-list-title">Rsvp Name</td>-->
							<td class="mailtemplate-list-title">Send Date</td>
							<td class="mailtemplate-list-title">Status</td>
							<td class="mailtemplate-list-title">RSVP</td>
							<td class="mailtemplate-list-title">Subscriber</td>
							<!-- <td class="mailtemplate-list-title">Preview Content</td> -->
							<td class="mailtemplate-list-title">Archive</td>
						</tr>
						<tr>
							<td colspan="${totalCol}" class="template-list"
								style="padding: 10px">
								<div style="float: right;">
									<span>Page</span>

									<c:if test="${!empty totalCount}">
										<select id="pageNo" name="pageNo"
											onchange="loadMailTemplate();">

											<%
												for (int i = 1; i <= Integer.parseInt(request
																	.getAttribute("totalCount").toString()); i++) {
											%>

											<option value="<%= i %>"><%= i %></option>

											<%
												}
											%>

										</select>
									</c:if>
								</div>
							</td>
						</tr>

					</table>
				</div>
				<portlet:actionURL var="vieweventURL">
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="action" value="uploadFiles" />
				</portlet:actionURL>
				<form name="UploadForm" action="<%= vieweventURL %>"
					enctype="multipart/form-data" method="POST" id="fm1" name="fm1">
					<input name="<portlet:namespace />campaignId" type="hidden" id="campaignId"
						value="${campaignId}" />
						<input name="<portlet:namespace />campaignNameIp" type="hidden" id="campaignNameIp"
						value="${campaignNameIp}" />
						<input name="<portlet:namespace />successMsgTemplateIp" type="hidden" id="successMsgTemplateIp"
						value="${successMsgTemplate}" />
					<div id="mainCampaignDiv" style="display: none;">
						<div class="campaign-mainTitle">
							<div class="campaign-Title" id="campaignName">&nbsp;</div>

						</div>

						<div id="selectSubscriberType" style="margin: 10px;">
							<div>
								<input type="radio" name="<portlet:namespace />optionType"
									style="margin-bottom: 10px;" id="optionFilter"
									onchange="addSubscriberChange(this)"> Add subscribers
								by MyFavorite.
							</div>
							<div>
								<input name="<portlet:namespace />optionType" type="radio" id="optionUpload"
									onchange="addSubscriberChange(this)"> Add subscribers
								by uploading excel.
							</div>
						</div>

						<div id="addByFilter" style="margin: 10px 10px 10px 32px; display: none;">
							<label class="control-label">Search from MyFavorites</label>
							<div class="">
								<select id="filterId" name="<portlet:namespace />filterId">
									<option value=""></option>
									<c:forEach items="${lstSPSearchFilter}" var="spSearchFilter">
										<option value="${spSearchFilter.SPGSFavouriteId}">
											<c:out value="${spSearchFilter.name}" />
										</option>
									</c:forEach>
								</select>
							</div>
							<div>
								<input onclick="addSubByFilter()" type="button" value="Save" class="btn-primary" style="margin-top:10px"/>
							</div>
						</div>
						<div id="addByExcel" style="display: none;margin-left: 32px;">
							<div class="description-title"
								style="margin-top: 10px; width: 98%;">
								<span> Add subscribers</span><br/> <span
									style="font-size: 11px; font-weight: bold;">Please
									upload excel file.</span>
							</div>
							<div class="event-invite-pannel" style="width: 98%;" id="event-invite-pannel">
								<div
									style="display: inline-block; margin-top: 16px; width: 84%;">
									<input style="float: left;" name="<portlet:namespace />filesToUpload"
										id="filesToUpload" type="file" onchange="uploadExcel();" />
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="white_content" id="light">
			<div class="campaign-mainTitle">
				<div id="campaignSubject" class="campaignSubject"
					style="display: inline-block; width: 87%;">&nbsp;</div>
				<div
					style="display: inline-block; width: 11%; float: right; text-align: right; padding-right: 10px;">
					<a href="javascript:void(0)" onclick="closeTemplateScreen()">Close</a>
				</div>
			</div>
			<!-- <div style="width: 96%; padding-left: 10px; padding-top: 10px;">
					<div class="mailtemplate-subtitle"
						style="font-size: 15px; background: none repeat scroll 0% 0% transparent; text-align: left; padding-left: 0px;">Subject</div>
					<div id="campaignSubject">&nbsp;</div>
				</div>-->

			<div style="width: 96%; padding-left: 10px; padding-top: 10px;">
				<div class="mailtemplate-subtitle"
					style="font-size: 15px; background: none repeat scroll 0% 0% transparent; text-align: left; padding-left: 0px;">HTML
					Content</div>
				<div id="campaignHTMLContent">&nbsp;</div>
			</div>
		</div>
		<div class="black_overlay" id="fade"></div>
		<script>
		var A = AUI(); // initializing instead putting null into A. 
AUI().ready('aui-node','aui-io-request',function(A1) {
	var A=A1;
	if (document.getElementById("campaignId")) {
		if (document.getElementById("campaignId").value == "") {
			loadMailTemplate();
		}else {
			fetchSPMailCampaign(document.getElementById("campaignId").value,document.getElementById("campaignNameIp").value);
			loadMailTemplate();
			document.getElementById("event-invite-pannel").style.display="block";
		}

	}else {

	}
});

function startToArchive(obj) {
	var AI=AUI();
	var reqUrlis = '<portlet:resourceURL id="" />';

	try{
	 	AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'get',
		    data:{
				filterName:"archive",
			   	filterValue:obj,
		    },
		    on: {
		        success: function() {
					var archivedTblRow = getFirstElementsByAttribute(document, "tr", "data-campaign-id", obj);
					archivedTblRow.parentNode.removeChild(archivedTblRow);
					<portlet:namespace />callPopup("Success", "Your request has been processed successfully!");
		        },
		        failure: function() {
		        	<portlet:namespace />callPopup("Failure", "Oops! An error occurred while processing your request.");
		        }
		    }
		});

		return true;
	}catch(err) {
	}

}

function loadContent(obj) {
	var AI=AUI();
	var itemis = null;
	var subject = null;
	var htmlContent = null;
	var textContent = null;
	var campaignName = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
		//document.getElementById("light").style.display='block';
		//document.getElementById("fade").style.display='block'

			try{
			 	AI.io.request(reqUrlis, {
				    cache: false,
				    sync: true,
				    timeout: 1000,
				    dataType: 'json',
				    method: 'post',
				    data:{
				   	 filterName:"get",
				   	 filterValue:obj,
				    },

				    on: {
				        success: function() {
				       	 itemis = this.get('responseData');
				        if (itemis) {

				       		for (key in itemis) {
				       			var cellTextValues = itemis[key];
				       			for (key in cellTextValues) {
				       				switch(key) {
					       				case "subject": subject=cellTextValues[key];break;
					       				case "htmlContent": htmlContent=cellTextValues[key];break;
					       				case "textContent": textContent=cellTextValues[key];break;
				       				}
				       			}
				       		}
				       		//document.getElementById("campaignSubject").innerHTML=subject;
				       		//document.getElementById("campaignHTMLContent").innerHTML=htmlContent;
				       		var myWindow = window.open("", subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
				       		myWindow.document.write(htmlContent);
				       		document.getElementById("event-invite-pannel").style.display="none";

				       	}
				        },

				        failure: function() {
				        }
				    }
				});

		 	return true;
		}catch(err) {
		}

}

function addSubByFilter() {
	var filter = document.getElementById("filterId").value;
	var campaignId = document.getElementById("campaignId").value;
	var AI=AUI();
	var itemis = null;
	var reqUrlis = '<portlet:resourceURL id="" />';

	try{
	 	AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterName:"addByFilter",
		   	 filterValue:filter,
		   	 campaignId:campaignId,
		    },

		    on: {
		        success: function() {
		       	 itemis = this.get('responseData');
				document.getElementById("successMsgTemplate").style.display="block";

		        },

		        failure: function() {
		        }
		    }
		});

	return true;
}catch(err) {
}
}

function fetchSPMailCampaign(campaignId,campaignName) {
	var filter= campaignId;
	document.getElementById("campaignId").value=campaignId;
	document.getElementById("campaignNameIp").value=campaignName;
	document.getElementById("addByFilter").style.display="none";
	document.getElementById("addByExcel").style.display="none";
	document.getElementById("optionUpload").checked = false;
	document.getElementById("optionFilter").checked = false;
	var successMsgTemplateVal = document.getElementById("successMsgTemplateIp").value;
	/* if(document.getElementById("successMsgTemplate")){
	document.getElementById("successMsgTemplate").style.display="none";
	} */
	document.getElementById("mainCampaignDiv").style.display="block";
	if(successMsgTemplateVal != ""){
		document.getElementById("mainCampaignDiv").style.display="none";
		document.getElementById("successMsgTemplateIp").value = "";
	}
	if(campaignName != "" && campaignName != "undefined"){
	document.getElementById("campaignName").innerHTML=campaignName;
	}
	//document.getElementById("event-invite-pannel").style.display="none";
}

function uploadExcel() {
	document.getElementById("fm1").submit();
}

function loadMailTemplate() {
	var chkEnableRem1 = '<%= chkEnableRem1 %>';
	var chkEnableRem2 = '<%= chkEnableRem2 %>';
	var chkEnableRem3 = '<%= chkEnableRem3 %>';
	var chkEnableThankYou = '<%= chkEnableThankYou %>';
	var chkEnableMissYou = '<%= chkEnableMissYou %>';
	var totalCol = '<%= totalCol %>';
	var createPageName = '<%= createPageName %>';
	var scheduleIcon = '<%= scheduleIcon %>';
	var previewIcon = '<%= previewIcon %>';
	var textcontentIcon = '<%= textcontentIcon %>';
	var archiveIcon = '<%= archiveIcon %>';

	var AI=A;
	var jsonItems = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var e = document.getElementById("pageNo");
	var filter= e.options[e.selectedIndex].value;
	var existingDiv = document.getElementById("existingDiv");
	existingDiv.innerHTML = "";
	var totalCount = <%= totalCount %>;
	var templateTable = document.createElement("table");
	templateTable.setAttribute("id","rsvpDetails");
	var tblBody = document.createElement("tbody");
	var tblCRow = document.createElement("tr");
	tblCRow.setAttribute("style","height: 30px;font-weight:bold;");

	var tblCol = document.createElement("td");
	tblCol.setAttribute("class","template-list");
	tblCol.setAttribute("colspan",totalCol);
	var cellText = document.createTextNode("Mail Campaign List");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);
	tblBody.appendChild(tblCRow);
	templateTable.appendChild(tblBody);
	existingDiv.appendChild(templateTable);

	tblCRow = document.createElement("tr");
	tblCRow.setAttribute("style","height: 30px;font-weight:bold;");

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Campaign Name");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Scheduled Date");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	if (chkEnableRem1 == "on") {
		tblCol = document.createElement("td");
		tblCol.setAttribute("class","mailtemplate-list-title");
		cellText = document.createTextNode("Reminder1 Scheduled");
		tblCol.appendChild(cellText);
		tblCRow.appendChild(tblCol);
	}

	if (chkEnableRem2 == "on") {
		tblCol = document.createElement("td");
		tblCol.setAttribute("class","mailtemplate-list-title");
		cellText = document.createTextNode("Reminder2 Scheduled");
		tblCol.appendChild(cellText);
		tblCRow.appendChild(tblCol);
	}

	if (chkEnableRem3 == "on") {
		tblCol = document.createElement("td");
		tblCol.setAttribute("class","mailtemplate-list-title");
		cellText = document.createTextNode("Reminder3 Scheduled");
		tblCol.appendChild(cellText);
		tblCRow.appendChild(tblCol);
	}

	if (chkEnableThankYou == "on") {
		tblCol = document.createElement("td");
		tblCol.setAttribute("class","mailtemplate-list-title");
		cellText = document.createTextNode("Thank You Scheduled");
		tblCol.appendChild(cellText);
		tblCRow.appendChild(tblCol);
	}

	if (chkEnableMissYou == "on") {
		tblCol = document.createElement("td");
		tblCol.setAttribute("class","mailtemplate-list-title");
		cellText = document.createTextNode("Missed You Scheduled");
		tblCol.appendChild(cellText);
		tblCRow.appendChild(tblCol);
	}

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Send Date");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Status");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("RSVP");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Subscriber");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Archive");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblBody.appendChild(tblCRow);
	templateTable.appendChild(tblBody);
	existingDiv.appendChild(templateTable);

	try{
	 	A.io.request(reqUrl, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterName:"pageChange",
		   	 filterValue:filter,
		    },

		    on: {
		        success: function() {
		       	 jsonItems = this.get('responseData');
		       	console.log("jsonItems " + JSON.stringify(jsonItems));
		       	if (jsonItems) {
		       		try{
					for (key in jsonItems) {
						var tblRow = document.createElement("tr");
						tblBody.appendChild(tblRow);
						//jsonItems.sort(function(a, b){return a.order - b.order}); 
						var cellTextValues = jsonItems[key];
						//console.log("cellTextValues " + JSON.stringify(cellTextValues));
						tblRow.setAttribute("data-campaign-id", key);
						var nameCol = document.createElement("td");
						nameCol.setAttribute("class","mailtemplate-list-title");

						var mainScheduleCol = document.createElement("td");
						mainScheduleCol.setAttribute("class","mailtemplate-list-title");

						var rem1Col = document.createElement("td");
						rem1Col.setAttribute("class","mailtemplate-list-title");

						var rem2Col = document.createElement("td");
						rem2Col.setAttribute("class","mailtemplate-list-title");

						var rem3Col = document.createElement("td");
						rem3Col.setAttribute("class","mailtemplate-list-title");

						var thankYouCol = document.createElement("td");
						thankYouCol.setAttribute("class","mailtemplate-list-title");

						var missYouCol = document.createElement("td");
						missYouCol.setAttribute("class","mailtemplate-list-title");

						var sendDateCol = document.createElement("td");
						sendDateCol.setAttribute("class","mailtemplate-list-title");

						var statusCol = document.createElement("td");
						statusCol.setAttribute("class","mailtemplate-list-title");

						var rsvpCol = document.createElement("td");
						rsvpCol.setAttribute("class","mailtemplate-list-title");

						var scheduleCol = document.createElement("td");
						scheduleCol.setAttribute("class","mailtemplate-list-title");
						scheduleCol.setAttribute("style","text-align:center");

						var archiveCol = document.createElement("td");
						archiveCol.setAttribute("class","mailtemplate-list-title");
						archiveCol.setAttribute("style","text-align:center");

						tblRow.appendChild(nameCol);
						tblRow.appendChild(mainScheduleCol);
						if (chkEnableRem1 == "on") {
							tblRow.appendChild(rem1Col);
						}

						if (chkEnableRem2 == "on") {
							tblRow.appendChild(rem2Col);
						}

						if (chkEnableRem3 == "on") {
							tblRow.appendChild(rem3Col);
						}

						if (chkEnableThankYou == "on") {
							tblRow.appendChild(thankYouCol);
						}

						if (chkEnableMissYou == "on") {
							tblRow.appendChild(missYouCol);
						}

						tblRow.appendChild(sendDateCol);
						tblRow.appendChild(statusCol);
						tblRow.appendChild(rsvpCol);
						tblRow.appendChild(scheduleCol);
						tblRow.appendChild(archiveCol);

						for (key in cellTextValues) {
							switch(key) {
								case "campaignName":
									var cellText = document.createTextNode(cellTextValues[key]);
									var cmpName =  cellTextValues['campaignName'];
									var hrefElement = document.createElement("a");
									hrefElement.setAttribute("href","/"+createPageName+"?campaignId="+cellTextValues['id']);
									hrefElement.appendChild(cellText);
									nameCol.appendChild(hrefElement);

									var image = document.createElement("img");
									image.setAttribute("src",scheduleIcon);
									var hrefElement1 = document.createElement("a");
									hrefElement1.setAttribute("onclick","fetchSPMailCampaign("+cellTextValues['id']+",'"+cmpName+"')");
									hrefElement1.appendChild(image);
									scheduleCol.appendChild(hrefElement1);

									var archiveImage = document.createElement("img");
									archiveImage.setAttribute("src",archiveIcon);
									archiveImage.setAttribute("onclick", "startToArchive("+cellTextValues['id']+")");

									archiveCol.appendChild(archiveImage);

									break;

								case "mainSchedule":
/** merged from version-003 **/
									var jcamp = cellTextValues;
									var jedms = jcamp.edms; 
									if(jedms){
										var markupTmpl = "<span><a href='#' onclick='loadContent(TEMPLATEID)'><img alt='load' src='ICONURL' style='vertical-align:middle'></a></span><span style='margin-right : 10px'>NAME</span><span>DATE</span><br>";
										var SentmarkupTmpl = "<span>SENTDATE</span><br>";
										var statusmarkupTmpl = "<span>STATUS</span><br>";
										for(var i = 0 ; i < jedms.length; i++){
											var edm = jedms[i];
											var markup = markupTmpl;
											markup = markup.replace("NAME", edm.name);
											markup = markup.replace("DATE", edm.nextScheduleTime);
											markup = markup.replace("TEMPLATEID", edm.templateId);
											markup = markup.replace("ICONURL", previewIcon);
											mainScheduleCol.innerHTML = mainScheduleCol.innerHTML + markup;
											var sentMarkup = SentmarkupTmpl;
											sentMarkup = sentMarkup.replace("SENTDATE",edm.sentDate);
											sendDateCol.innerHTML = sendDateCol.innerHTML + sentMarkup;
											var statusMarkup = statusmarkupTmpl;
											var emdStatus = edm.status;
											statusMarkup = statusMarkup.replace("STATUS",edm.status);
											statusMarkup = statusMarkup.replace("undefined"," ");
											statusCol.innerHTML = statusCol.innerHTML + statusMarkup;
										}
									}else{
										var cellText = document.createTextNode(cellTextValues[key]);
										mainScheduleCol.appendChild(cellText);
									}
/** end **/
									break;
								case "rem1Schedule":
									var cellText = document.createTextNode(cellTextValues[key]);
									rem1Col.appendChild(cellText);
									break;
								case "rem2Schedule":
									var cellText = document.createTextNode(cellTextValues[key]);
									rem2Col.appendChild(cellText);
									break;
								case "rem3Schedule":
									var cellText = document.createTextNode(cellTextValues[key]);
									rem3Col.appendChild(cellText);
									break;
								case "thankYouSchedule":
									var cellText = document.createTextNode(cellTextValues[key]);
									thankYouCol.appendChild(cellText);
									break;
								case "missYouSchedule":
									var cellText = document.createTextNode(cellTextValues[key]);
									missYouCol.appendChild(cellText);
									break;
								/* case "sendDate":
/** merged from version-003 
									//if(!cellTextValues.edms){
										var cellText = document.createTextNode(cellTextValues[key]);
										sendDateCol.appendChild(cellText);
									//}
										break;
								case "status":
									//if(!cellTextValues.edms){
										var cellText = document.createTextNode(cellTextValues[key]);
										statusCol.appendChild(cellText);
									//}
/** end 									
									break; */
								case "rsvpName":
									var cellText = document.createTextNode(cellTextValues[key]);
									rsvpCol.appendChild(cellText);
									break;
							}

						}
					}
		       	}catch(error){
		       		console.log(error);
		       	}
		       	

					var attSel = document.createElement("select");
					attSel.setAttribute("name","pageNo");
					attSel.setAttribute("id","pageNo");
					attSel.setAttribute("onchange","javascript:loadMailTemplate()");
					var selectDiv = document.createElement("div");
					selectDiv.setAttribute("style","float:right");

					var selectSpan = document.createElement("span");
					selectSpan.appendChild(document.createTextNode("Page"))

					//alert("x " + x + " key " + key);

					//alert(totalCount);
					for (var i=1;i<=totalCount;i++) {

						 var attOpt;
							attOpt = document.createElement("option");
						attOpt.setAttribute("value",i);
						attOpt.innerHTML = i;
						if ((i==filter)) {
							attOpt.setAttribute("selected","selected");
						}
						attSel.appendChild(attOpt);
					}

					var tblRowPage = document.createElement("tr");
					var tblColPagge = document.createElement("td");
					tblColPagge.setAttribute("style","padding:10px;");
					tblColPagge.setAttribute("class","template-list");
					tblColPagge.setAttribute("colspan",totalCol);
					selectDiv.appendChild(selectSpan);
					selectDiv.appendChild(attSel);
					tblColPagge.appendChild(selectDiv);
					tblRowPage.appendChild(tblColPagge);
					tblBody.appendChild(tblRowPage);
		       	}
		        },
		        failure: function() {
		        }
		    }
		});

	return true;
}catch(err) {
}
}

function addSubscriberChange(obj) {
	if(document.getElementById("successMsgTemplate")){
	document.getElementById("successMsgTemplate").style.display="none";
	}
	if (document.getElementById("optionUpload").checked) {
		document.getElementById("addByExcel").style.display="block";
		document.getElementById("addByFilter").style.display="none";
	}else {
		document.getElementById("addByExcel").style.display="none";
		document.getElementById("addByFilter").style.display="block";
	}

}
function closeTemplateScreen() {
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none';
	document.getElementById("campaignSubject").innerHTML=" ";
	document.getElementById("campaignHTMLContent").innerHTML=" ";
}
</script>

<aui:script >

	function <portlet:namespace />callPopup(title, content) {

		AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {

			var dialog = Liferay.Util.Window.getWindow(
{
dialog: {

			title: title,

			centered: true,

			modal: true,

			width: 500,

			height: 250,

			bodyContent: content

			}}).render();

		});

	}

</aui:script >

	</c:otherwise>
</c:choose>
