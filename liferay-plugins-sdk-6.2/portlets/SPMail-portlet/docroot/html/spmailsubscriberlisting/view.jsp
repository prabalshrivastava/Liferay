<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.sambaash.platform.model.SPMailType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />
<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.VIEW %>"></portlet:param>
</portlet:actionURL>
<c:choose>
	<c:when test="${!hasAccess}">
		<h3>You don't have the permission to access this url!"</h3>
	</c:when>
	<c:when test="${!empty campaignList}">
		<script type="text/javascript">
var subscriberJsonObject = ${subscriberJsonObject};
function populateSubscriberDetails() {
	var tblBody = document.getElementById("campaignDetailTable");

	var tblRow = document.createElement("tr");
	var chkCol = document.createElement("td");
	var typeCol = document.createElement("td");
	var fNameCol = document.createElement("td");
	var lNameCol = document.createElement("td");
	var emailCol = document.createElement("td");
	var statusCol = document.createElement("td");
	var delCol = document.createElement("td");
	var schCol = document.createElement("td");
	var opnCol = document.createElement("td");
	var opnMail = "";

	selElm = document.createElement("Select");
	selElm.setAttribute("id","mailSchStatus");
	selElm.setAttribute("name","mailSchStatus");
	selElm.setAttribute("disabled",true);
	optElm = document.createElement("option");
	optElm.setAttribute("value",-1);
	optTextNode = document.createTextNode("");
	optElm.appendChild(optTextNode);
	selElm.appendChild(optElm);
	schCol.appendChild(selElm);
	schCol.setAttribute("class","hide");

	for (campaignId in subscriberJsonObject) {
		//alert("campaignId " + subscriberJsonObject[campaignId]);
		tblRow = document.createElement("tr");
		chkCol = document.createElement("td");
		typeCol = document.createElement("td");
		fNameCol = document.createElement("td");
		lNameCol = document.createElement("td");
		emailCol = document.createElement("td");
		statusCol = document.createElement("td");
		delCol = document.createElement("td");
		opnCol = document.createElement("td");
		schCol = document.createElement("td");

		tblRow.setAttribute("style","height: 30px;");
		chkCol.setAttribute("class","mailtemplate-list-title");
		typeCol.setAttribute("class","mailtemplate-list-title");
		fNameCol.setAttribute("class","mailtemplate-list-title");
		lNameCol.setAttribute("class","mailtemplate-list-title");
		emailCol.setAttribute("class","mailtemplate-list-title");
		statusCol.setAttribute("class","mailtemplate-list-title");
		delCol.setAttribute("class","mailtemplate-list-title");
		opnCol.setAttribute("class","mailtemplate-list-title");
		opnCol.setAttribute("style","width: 50px;");
		schCol.setAttribute("class","mailtemplate-list-title");

		tblRow.appendChild(chkCol);
		tblRow.appendChild(typeCol);
		tblRow.appendChild(fNameCol);
		tblRow.appendChild(lNameCol);
		tblRow.appendChild(emailCol);
		tblRow.appendChild(statusCol);
		tblRow.appendChild(opnCol);
		tblRow.appendChild(schCol);
		tblRow.appendChild(delCol);

		var statusValue = 0;
		var subId = campaignId;
		var subscriberDetails = subscriberJsonObject[campaignId];
		for (key in subscriberDetails) {
			//alert("subscriberDetails " + subscriberDetails[key]);
			switch(key) {
			case "mailType":
				var cellText = document.createTextNode(subscriberDetails[key]);
				typeCol.appendChild(cellText);
				break;
			case "fName":
				var cellText = document.createTextNode(subscriberDetails[key]);
				fNameCol.appendChild(cellText);
				break;
			case "lName":
				var cellText = document.createTextNode(subscriberDetails[key]);
				lNameCol.appendChild(cellText);
				break;
			case "email":
				var cellText = document.createTextNode(subscriberDetails[key]);
				emailCol.appendChild(cellText);
				break;
			case "status":
				var cellText = document.createTextNode(subscriberDetails[key]);
				statusCol.appendChild(cellText);
				break;
			case "Opened":
				var cellText = document.createElement("input");
				cellText.setAttribute("type","text");
				cellText.setAttribute("disabled",true);
				cellText.setAttribute("name","viewSatus_"+subId);
				cellText.setAttribute("style","border:none;background:none");
				cellText.setAttribute("value",subscriberDetails[key]);
				opnMail = subscriberDetails[key];
				opnCol.appendChild(cellText);
				break;
			case "statusValue":
				statusValue = subscriberDetails[key];
				break;
			}
		}
		var chkElm = document.createElement("input");
		chkElm.setAttribute("type","checkbox");
		chkElm.setAttribute("value",key);
		chkElm.setAttribute("name","mailSelectCkhs");
		chkElm.setAttribute("id","mailSelectCkhs_"+key);
		chkElm.setAttribute("onChange","javascript:getMailSch("+key+")");
		if ((opnMail == "Bounced") || (opnMail == "Bounced-Soft") || (opnMail == "Complain"))
			chkElm.setAttribute("disabled",true);
		chkCol.appendChild(chkElm);
		if (statusValue < 1) {
			//alert("statusValue " + statusValue);
			var delRef = document.createElement("a");
			delRef.setAttribute("href","javascript:filterByAndLoadMore('delete',"+ subId +",'false','false');")
			delRef.innerHTML = "Delete";
			delCol.appendChild(delRef);
		}
		tblBody.appendChild(tblRow);
	}
}

function filterByAndLoadMore(type,cId,isLoadMore,isFilter) {
	
		var A=AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		var nextValue = 5;
		var prevValue = 5;
		var campaignId=0;
		var loadMore = isLoadMore;
		var mailTypeId = -1;
		var mailStatusId = -1;
		var tblBody = document.getElementById("rsvpDiv");
		tblBody.classList.remove("hide");
		var e = document.getElementById("campaignList");
		campaignId = e.options[e.selectedIndex].value;
		var e1 = document.getElementById("selectFilterValue");
		filterName = e1.options[e1.selectedIndex].value;
		
		if(type=="campaignList"){
			loadCampaignEDMS(campaignId);
			}

		var e2 = document.getElementById("filterValue");
		filterValue = e2.value;

		var loadMoreDiv = document.getElementById("loadMoreDiv");
		if (loadMoreDiv) {
			loadMoreDiv.style.display="block";
		}
		if (campaignId > 0) {
			var e1 = document.getElementById("mailType");
			mailTypeId = e1.options[e1.selectedIndex].value;
			var e2 = document.getElementById("mailViewStatus");
			mailStatusId = e2.options[e2.selectedIndex].value;
		}
		var tblBody = document.getElementById("campaignDetailTable");
		if (loadMore == "true") {
			if (type == "loadMore") {
				//alert("loadMore loadMore loadMore " + loadMore);
			nextValue = document.getElementById("campaignNextValue").value;
			document.getElementById("campaignNextValue").value = parseInt(nextValue,10) + parseInt(50,10);
			document.getElementById("campaignPrev").display="block";
			prevValue = document.getElementById("campaignPrevValue").value;
			document.getElementById("campaignPrevValue").value = parseInt(prevValue,10) + parseInt(50,10);
			}else {
				prevValue = document.getElementById("campaignPrevValue").value;
				document.getElementById("campaignNextValue").value = 50;
				document.getElementById("campaignPrevValue").value = parseInt(prevValue,10) - parseInt(50,10);
				prevValue = document.getElementById("campaignPrevValue").value;
			}
		}else {
			document.getElementById("campaignNextValue").value = 50;
		}
			var campDiv = document.getElementById("campaignTableDiv");
			campDiv.innerHTML = "";
			var campTable = document.createElement("table");
			campTable.setAttribute("id","subscriberDetails");
			campTable.setAttribute("style","width: 100%;");
			tblBody = document.createElement("tbody");
			tblBody.setAttribute("id","campaignDetailTable");
			var tblCRow = document.createElement("tr");
			tblCRow.setAttribute("style","height: 30px;font-weight:bold;");

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("Mail Type");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("First Name");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("Last Name");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("Email Address");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("Sent-Status");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("View-Status");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createElement("Select");
			cellText.setAttribute("id","mailSchStatus");
			tblCol.setAttribute("class","hide");
			cellText.setAttribute("name","mailSchStatus");
			if ((mailTypeId < 0) || (mailStatusId < 0)) {
				cellText.setAttribute("disabled",true);
			}
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblCol = document.createElement("td");
			tblCol.setAttribute("class","mailtemplate-list-title");
			cellText = document.createTextNode("Delete");
			tblCol.appendChild(cellText);
			tblCRow.appendChild(tblCol);

			tblBody.appendChild(tblCRow);
			campTable.appendChild(tblBody);
			campDiv.appendChild(campTable);
		A.io.request(reqUrl, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		     campaignId:campaignId,
		   	 type:type,
		   	 mailTypeId:mailTypeId,
		   	mailStatusId:mailStatusId,
		   	 nextValue:nextValue,
		   	prevValue:prevValue,
		   	 loadMore:loadMore,
		   	 cId:cId,
		   	filterName:filterName,
		   	filterValue:filterValue,
		    },

		    on: {
		        success: function() {
		       	 items = this.get('responseData');
		       	var count = Object.keys(items).length;
		       	var x = 0;
		       	var statusValue = 0;
		    	var isList = "false";
		    	var cmpId = 0;
		       	 if (count > 0) {
		       		var campDiv = document.getElementById("noResultsMsg");
		       		if(campDiv){
	    			campDiv.innerHTML = "";
		       		}
					for (key in items) {
						cmpId=key;
						//alert("campaignId " + cmpId);
						tblRow = document.createElement("tr");
						chkCol = document.createElement("td");
						typeCol = document.createElement("td");
						fNameCol = document.createElement("td");
						lNameCol = document.createElement("td");
						emailCol = document.createElement("td");
						statusCol = document.createElement("td");
						opnCol = document.createElement("td");
						schCol = document.createElement("td");
						delCol = document.createElement("td");

						tblRow.setAttribute("style","height: 30px;");
						chkCol.setAttribute("class","mailtemplate-list-title");
						typeCol.setAttribute("class","mailtemplate-list-title");
						fNameCol.setAttribute("class","mailtemplate-list-title");
						lNameCol.setAttribute("class","mailtemplate-list-title");
						emailCol.setAttribute("class","mailtemplate-list-title");
						statusCol.setAttribute("class","mailtemplate-list-title");
						delCol.setAttribute("class","mailtemplate-list-title");
						opnCol.setAttribute("class","mailtemplate-list-title");
						opnCol.setAttribute("name","viewSatus_"+cmpId);
						schCol.setAttribute("class","mailtemplate-list-title mail-schedule hide");
						schCol.setAttribute("id","mailSchStatus_"+cmpId);

						tblRow.appendChild(chkCol);
						tblRow.appendChild(typeCol);
						tblRow.appendChild(fNameCol);
						tblRow.appendChild(lNameCol);
						tblRow.appendChild(emailCol);
						tblRow.appendChild(statusCol);
						tblRow.appendChild(opnCol);
						tblRow.appendChild(schCol);
						tblRow.appendChild(delCol);
						if (x == 0) {
							var selElm = document.getElementById("mailSchStatus");
							selElm.setAttribute("onChange","Javascript:loadMailSchStatus()");
							optElm = document.createElement("option");
							optElm.setAttribute("value",-1);
							optTextNode = document.createTextNode("");
							optElm.appendChild(optTextNode);
							selElm.appendChild(optElm);

							if (mailTypeId != 0) {
								optElm = document.createElement("option");
								optElm.setAttribute("value",0);
								optTextNode = document.createTextNode("Main");
								optElm.appendChild(optTextNode);
								selElm.appendChild(optElm);
							}
							if (mailTypeId != 1) {
								optElm = document.createElement("option");
								optElm.setAttribute("value",1);
								optTextNode = document.createTextNode("Reminder1");
								optElm.appendChild(optTextNode);
								selElm.appendChild(optElm);
							}
							if (mailTypeId != 2) {
								optElm = document.createElement("option");
								optElm.setAttribute("value",2);
								optTextNode = document.createTextNode("Reminder2");
								optElm.appendChild(optTextNode);
								selElm.appendChild(optElm);
							}
							if (mailTypeId != 3) {
								optElm = document.createElement("option");
								optElm.setAttribute("value",3);
								optTextNode = document.createTextNode("Reminder3");
								optElm.appendChild(optTextNode);
								selElm.appendChild(optElm);
							}
							optElm = document.createElement("option");
							optElm.setAttribute("value",4);
							optTextNode = document.createTextNode("Thank-You");
							optElm.appendChild(optTextNode);
							selElm.appendChild(optElm);
							optElm = document.createElement("option");
							optElm.setAttribute("value",5);
							optTextNode = document.createTextNode("Missed-You");
							optElm.appendChild(optTextNode);
							selElm.appendChild(optElm);
						}
						var subscriberDetails = items[key];
						var subId = key;
						var opnMail = "";
						for (key in subscriberDetails) {
							//alert("subscriberDetails " + subscriberDetails[key]);
							switch(key) {
								case "mailType":
									var cellText = document.createTextNode(subscriberDetails[key]);
									typeCol.appendChild(cellText);
									break;
								case "fName":
									var cellText = document.createTextNode(subscriberDetails[key]);
									fNameCol.appendChild(cellText);
									break;
								case "lName":
									var cellText = document.createTextNode(subscriberDetails[key]);
									lNameCol.appendChild(cellText);
									break;
								case "email":
									var cellText = document.createTextNode(subscriberDetails[key]);
									emailCol.appendChild(cellText);
									break;
								case "status":
									var cellText = document.createTextNode(subscriberDetails[key]);
									statusCol.appendChild(cellText);
									break;
								case "Opened":
									var cellText = document.createElement("input");
									cellText.setAttribute("type","text");
									cellText.setAttribute("disabled",true);
									cellText.setAttribute("name","viewSatus_"+subId);
									cellText.setAttribute("style","border:none;background:none");
									cellText.setAttribute("value",subscriberDetails[key]);
									opnMail = subscriberDetails[key];
									opnCol.appendChild(cellText);
									break;
								case "statusValue":
									statusValue = subscriberDetails[key];
									break;
								case "isList":
									isList = subscriberDetails[key];
									break;
								case "tCount":
									tCount = subscriberDetails[key];
									break;
								}
						}
						var chkElm = document.createElement("input");
						chkElm.setAttribute("type","checkbox");
						chkElm.setAttribute("value",cmpId);
						chkElm.setAttribute("name","mailSelectCkhs");
						chkElm.setAttribute("id","mailSelectCkhs_" + cmpId);
						chkElm.setAttribute("onChange","javascript:getMailSch("+cmpId+")");
						if ((opnMail == "Bounced") || (opnMail == "Bounced-Soft") || (opnMail == "Complain"))
							chkElm.setAttribute("disabled",true);
						chkCol.appendChild(chkElm);
						if (statusValue < 1) {
							var delRef = document.createElement("a");
							delRef.setAttribute("href","javascript:filterByAndLoadMore('delete','" +subId + "','false','false');")
							delRef.innerHTML = "Delete";
							delCol.appendChild(delRef);
						}
						tblBody.appendChild(tblRow);
						x=x+1;
						}
							//alert("getAttribute " + document.getElementById("campaignNext").getAttribute("style"));
						 if (isList == "false") {
							 var loadMoreDiv = document.getElementById("campaignNext");
								if (loadMoreDiv) {
									loadMoreDiv.style.display="none";
								}
								
							var loadPrevElm = document.getElementById("campaignPrev");
							 if (loadPrevElm && nextValue > 49) {
								loadPrevElm.style.display="block";
							}
					     }else {
							var loadMoreElm = document.getElementById("campaignNext");
							var loadPrevElm = document.getElementById("campaignPrev");
							 if (loadPrevElm && nextValue > 49) {
									loadPrevElm.style.display="block";
								}
							 if(tCount == 0){
									loadPrevElm.style.display="none";
								}
							  if (loadMoreElm) {
								 loadMoreElm.style.display="block";
								} 
							if (isFilter == "true") {
								loadMoreElm.setAttribute("onClick","javascript:filterByAndLoadMore('loadMore','','true','true')");
								loadPrevElm.setAttribute("onClick","javascript:filterByAndLoadMore('loadPrev','','true','true')");
							}else {
								loadMoreElm.setAttribute("onClick","javascript:filterByAndLoadMore('loadMore','','true','false')");
								loadPrevElm.setAttribute("onClick","javascript:filterByAndLoadMore('loadPrev','','true','false')");
							}
					    }
		       		 } else {
		       			var campDiv = document.getElementById("campaignTableDiv");
		    			campDiv.innerHTML = "";
		    			campDiv.innerHTML = "No Subscriber list found";
		       		 }

		        },
		        failure: function() {
		        }
		    }
		});

	 	//return true;
	/* }catch(err) {
	} */

}
	
	function loadCampaignEDMS(campaignId){
		var A=AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		var mailTypeSel = document.getElementById("mailType");
		var selectedCampaign = document.getElementById("campaignList");
		var selectedCampaignValue = selectedCampaign.options[selectedCampaign.selectedIndex].value;
		//alert("selectedCampaignValue " + selectedCampaignValue);
		mailTypeSel.innerHTML="";
		var A = AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		
		A.io
		.request(
				reqUrl,
				{
					cache : false,
					sync : true,
					timeout : 1000,
					dataType : 'json',
					method : 'post',
					data : {
						type : "getMailType",
						campaignId : campaignId,
				    	selectedCampaign : selectedCampaignValue
					},
					on : {
						success : function() {
							items = this.get('responseData');
							
							if (items) {
				        		for (key in items) {
				        			campOption=document.createElement("Option");
				        			campOption.setAttribute("value",key);
				        			var optTextNode = document.createTextNode(items[key]);
				        			campOption.appendChild(optTextNode);
				        			mailTypeSel.appendChild(campOption);
				        		}
				        		//getRsvpDetail('filters');
				        	}else{
				        		alert("No EDMs found for the selected campaign. Please try another campaign.")
				        	}	

						},
						failure : function() {

						}
					}

				});
	}

function loadMailSchStatus() {
	var schElems = document.getElementsByClassName("mail-schedule");
	var selBox = document.getElementsByName("mailSelectCkhs");
	var e1 = document.getElementById("mailSchStatus");
	var selText = e1.options[e1.selectedIndex].text;
	var cellText = document.createTextNode(selText);
	for (i=0;i<schElems.length;i++) {
		schElems[i].innerHTML = "";
		selBox[i].checked = false;
		var cellText = document.createTextNode(selText);
		 schElems[i].appendChild(cellText);
	}
	document.getElementById("submitButton").disabled=false;
}

function OnSubmitForm()
{
	document.getElementById("subscriberDetail").action = "<%= editActionURL %>";
		return true;

}

function getMailSch(cmpId) {
	var e1 = document.getElementById("mailSchStatus");
	var schValue = e1.options[e1.selectedIndex].text;
	var selChks = document.getElementById("mailSelectCkhs_" + cmpId).checked;
	var schElems = document.getElementsByClassName("mail-schedule");
	var selBox = document.getElementsByName("mailSelectCkhs");
	var sel = false;
	if (selChks) {
		for (i=0;i<schElems.length;i++) {
			if (!selBox[i].checked) {
				schElems[i].innerHTML = "";
			}else {
				//if (schElems[i].innerHTML === '') {
					var cellText = document.createTextNode(schValue);
				 	schElems[i].innerHTML = schValue;
				//}
			}
		}

	} else {
		document.getElementById("mailSchStatus_" + cmpId).innerHTML = "";
		for (i=0;i<selBox.length;i++) {
			if (selBox[i].checked) {
				sel = true;
				break;
			}
		}
		if (!sel) {
			for (i=0;i<schElems.length;i++) {
				var cellText = document.createTextNode(schValue);
				 schElems[i].appendChild(cellText);
			}
		}
	}
}

</script>

		<%
			String mainMailName = SPMailType.MAIN.getValue();
					int mainMailvalue = SPMailType.MAIN.ordinal();
					String rem1MailName = SPMailType.REMINDER1.getValue();
					int rem1MailValue = SPMailType.REMINDER1.ordinal();
					String rem2MailName = SPMailType.REMINDER2.getValue();
					int rem2MailValue = SPMailType.REMINDER2.ordinal();
					String rem3MailName = SPMailType.REMINDER3.getValue();
					int rem3MailValue = SPMailType.REMINDER3.ordinal();
		%>

		<div class="rsvpbox-title" style="width: 100%; margin-bottom: 15px;">Campaign
			Subscribers</div>
			
		<div class="rsvp-preference-border screen-max-width" style="min-height: 300px;">

			<form method="post" id="subscriberDetail"
				onsubmit="return OnSubmitForm();">
				<div>
					<div style="margin-bottom: 20px;">
						<span
							style="padding-right: 22px; display: inline-block; width: 25%; font-weight: bold;">Filter
							By Campaign Name</span> <span> <select id="campaignList"
							onChange="javascript:filterByAndLoadMore('campaignList','','false','true')">
							<option value="0"></option>
								<c:forEach items="${campaignList}" var="spMailCampaign">
									<option value="${spMailCampaign.spMailCampaignId}">${spMailCampaign.campaignName}</option>
								</c:forEach>
						</select>
						</span>
					</div>
					<div style="margin-bottom: 20px;">
						<span
							style="padding-right: 20px; display: inline-block; width: 25%; font-weight: bold;">Select
							Mail Type</span> 
							<select id="mailType" style="display: inline-block;"
							onChange="javascript:filterByAndLoadMore('mailType','','false','true')">
							<c:if test="${!empty edmList}">
							<option value="0"></option>
								<c:forEach items="${edmList}" var="edmList">
									<option value="${edmList.seqNo}">${edmList.name}</option>
								</c:forEach>
							</c:if>
							<c:if test="${empty edmList}">
							<option value="-1">All</option>
							 <option value="<%= mainMailvalue %>"><%= mainMailName %></option>
							<option value="<%= rem1MailValue %>"><%= rem1MailName %></option>
							<option value="<%= rem2MailValue %>"><%= rem2MailName %></option>
							<option value="<%= rem3MailValue %>"><%= rem3MailName %></option>
							</c:if>
						</select>
					</div>
					<div style="margin-bottom: 20px;">
						<span
							style="padding-right: 20px; display: inline-block; width: 25%; font-weight: bold;">Select
							Mail Status</span> <select id="mailViewStatus"
							style="display: inline-block;"
							onChange="javascript:filterByAndLoadMore('mailViewStatus','','false','true')">
							<option value="-1">All</option>
							<option value="0">Not-Opened</option>
							<option value="1">Opened</option>
							<option value="2">Bounced</option>
							<option value="3">Bounced-Soft</option>
							<option value="4">Complain</option>
						</select>
					</div>
						<div style="display: inline-block; margin-bottom: 20px; width: 100%;">
							<span
							style="padding-right: 20px; display: inline-block; width: 25%; font-weight: bold;">Filter by</span>
							<div class="rsvp-filter-list" style="display: inline-block;">
								<select id="selectFilterValue" name="<portlet:namespace />filterNames">
									<option value="0"></option>
									<option value="email">Email Address</option>
									<option value="fname">First Name</option>
									<option value="lname">Last Name</option>
								</select>
							</div>
							<div class="rsvp-filter-list" style="display: inline-block;">
								<input id="filterValue" name="<portlet:namespace />filterValue" type="text">
							</div>
							<div class="rsvp-filter-button"
							style="margin: 0 auto; text-align: center;display:inline-block;margin-top: 6px;">
							<input onclick="javascript:filterByAndLoadMore('searchAction','','false','true')" type="button" value="Search" class="btn-primary">
						</div>
						</div>
					<div>
						<input type="submit" value="Update List" id="submitButton"
							disabled="true" class="hide">
					</div>
				</div>
		
				<div id="rsvpDiv" style="width: 100%; padding: 10px 0;" class="hide">
					<div id="existingDiv" style="min-height: 200px;">
						<div
							style="height: 45px; font-weight: bold; width: 100%; margin-bottom: 10px;"
							class="template-list">Campaign Name - Subscriber List</div>
						<div id="campaignTableDiv">
							<table id="subscriberDetails" style="width: 100%;">
								<tbody id="campaignDetailTable">
									<tr style="height: 30px; font-weight: bold;">
										<td class="mailtemplate-list-title"></td>
										<td class="mailtemplate-list-title">Mail Type</td>
										<td class="mailtemplate-list-title">First Name</td>
										<td class="mailtemplate-list-title">Last Name</td>
										<td class="mailtemplate-list-title">Email Address</td>
										<td class="mailtemplate-list-title">Sent-Status</td>
										<td class="mailtemplate-list-title">View-Status</td>
										<td class="mailtemplate-list-title hide"><select
											id="mailSchStatus" name="<portlet:namespace />mailSchStatusdddd" disabled="true">
												<option value=""></option>
												<option value="">options</option>
										</select></td>
										<td class="mailtemplate-list-title">Delete</td>
									</tr>
								</tbody>
							</table>
						</div>
			</form>
			<c:if test="${!empty noresults}">
				<div class="noResultsMsg" id="noResultsMsg">${noresults }</div>
			</c:if>
			<c:if test="${listCount > 50}">
				<div class="sp-event-loadmorediv" style="width: 100%"
					id="loadMoreDiv">
					<a id="campaignPrev" class=''
						onclick="javascript:filterByAndLoadMore('loadPrev','','true','false')"
						style="float: left; display: none;cursor: pointer; margin-top: 10px;"><< Prev</a> <a
						id="campaignNext" class=''
						onclick="javascript:filterByAndLoadMore('loadMore','','true','false')"
						style="float: right;display: none;cursor: pointer;margin-top: 10px;">>> Next</a>
				</div>
			</c:if>
			<input id="campaignNextValue" type="hidden" value="50"> 
			<input
				type="hidden" value="50" id="campaignPrevValue">
		</div>
		<script type="text/javascript">
			//populateSubscriberDetails();
		</script>
		</c:when>
	<c:otherwise>
	<div class="error-mesage">No Active Campaigns found</div>
	</c:otherwise>
</c:choose>
