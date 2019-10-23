<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.sambaash.platform.srv.rsvp.model.Rsvp" %>
<%@ page import="com.sambaash.platform.srv.rsvp.model.RsvpTicket" %>
<%@ page import="com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.sambaash.platform.srv.rsvp.model.RsvpDiscount" %>
<%@ page import="com.sambaash.platform.srv.rsvp.model.RsvpPromoCode" %>
<%@ page import="java.text.SimpleDateFormat" %>

<script>

function selectExistingRsvp(cb) {

	if (cb.checked==false) {
		//document.getElementById("spAssetDiv").style.visibility = "hidden";
		document.getElementById("rsvpDiv").style.display = "none";
		document.getElementById("detailSection").style.visibility = "visible";
		document.getElementById("expandLink").innerHTML = "-<font style='font-size:12px;vertical-align:middle;padding-left:10px;'>Collapse to hide detail</font>";
		document.getElementById("detailSection").style.height = "auto";
	}else {
		//document.getElementById("serviceRSVP").style.visibility = "visible";
		document.getElementById("rsvpDiv").style.display = "block";
		document.getElementById("detailSection").style.visibility = "hidden";
		document.getElementById("expandLink").style.display = "block";
		document.getElementById("expandLink").innerHTML = "+<font style='font-size:12px;vertical-align:middle;padding-left:10px;'>Expand to dispaly detail</font>";
		document.getElementById("detailSection").style.height = "0";
		//fetchRsvp();
	}
}

function selectNewRsvp(cb) {

		//document.getElementById("spAssetDiv").style.visibility = "hidden";
		document.getElementById("rsvpDiv").style.display = "none";
		document.getElementById("detailSection").style.visibility = "visible";
		document.getElementById("expandLink").style.display = "none";
		document.getElementById("eventFlag").checked = false;
		document.getElementById("title").value = " ";
		document.getElementById("description").value = " ";
		document.getElementById("detailSection").style.height = "auto";
		document.getElementById("eventDiv").style.display = "none";
		document.getElementById("detailForm").style.visibility ="visible";
}

function assetRSVP(cb) {

	if (cb.checked==false) {
		//document.getElementById("serviceRSVP").style.visibility = "hidden";
		document.getElementById("spAssetDiv").style.display = "none";
	}else {
		//document.getElementById("serviceRSVP").style.visibility = "visible";
		document.getElementById("spAssetDiv").style.display = "block";
	}
}

function enablePayment(cb) {

	if (cb.checked==false) {
		document.getElementById("paymentDiv").style.display = "none";
	}else {
		document.getElementById("paymentDiv").style.display = "block";
	}
}
function handleClick(myRadio) {
	currentValue = myRadio.value;
	if (currentValue==1) {
		document.getElementById("eventDiv").style.display = "block";
		document.getElementById("spAssetDiv").style.display = "none";
	}else {
		document.getElementById("eventDiv").style.display = "none";
		document.getElementById("spAssetDiv").style.display = "block";
	}
}

function changeCampaign() {

}

function fetchRsvp() {
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var e = document.getElementById("rsvpId");
	var filter= e.options[e.selectedIndex].value;
	try{
	 	A.io.request(reqUrl, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterValue:filter,
		   	 filter:"changeRSVP",
		    },

		    on: {
		        success: function() {
		       	 items = this.get('responseData');
		       	if (items) {
		       		if (items["eventId"]!="0") {
		       			document.getElementById("eventFlag").checked = true;
		       			var canEdit = items["canEdit"];
		       			if (!canEdit) {
		       				document.getElementById("title").value = items["title"];
				       		document.getElementById("description").value = items["description"];
				       		document.getElementById("spMailCampaignId").value=items["spMailCampaignId"];

		       				document.getElementById("eventDivAll").style.display = "block";
		       				document.getElementById("eventDiv").style.display="none";
		       				var i=0;
							while ((document.fm1.alleventId.options[i].value != items["eventId"]) && (i < document.fm1.alleventId.options.length))
							  {i++;}
							if (i < document.fm1.alleventId.options.length)
							  {document.fm1.alleventId.selectedIndex = i;
							  document.getElementById("updateEventId").value=items["eventId"];}
				       		document.getElementById("successMsgTemplate").style.display="block";
				       		document.getElementById("canEdit").value="false";
				       		document.getElementById("detailForm").style.visibility ="hidden";

			       		}else {
			       			//alert("edit true");

			       			document.getElementById("eventDivAll").style.display = "none";
		       				document.getElementById("eventDiv").style.display="block";

			       			document.getElementById("title").value = items["title"];
				       		document.getElementById("description").value = items["description"];
				       		if (items["spMailCampaignId"] == 0) {
				       			//document.getElementById("spMailCampaignId").disabled = false;
				       			document.getElementById("spMailCampaignId").value="";
				       		}else {

				       			//document.getElementById("spMailCampaignId").disabled = true;
				       			document.getElementById("spMailCampaignId").value=items["spMailCampaignId"];
				       		}


				       		//document.getElementById("eventFlag").setAttribute("onclick","eventRSVP(this)");
				       		//document.getElementById("alleventId").setAttribute("onfocus","this.blur()");
				       		document.getElementById("successMsgTemplate").style.display="none";
				       		document.getElementById("canEdit").value="true";
				       		document.getElementById("detailForm").style.visibility ="visible";

			       			var i=0;
							while ((document.fm1.eventId.options[i].value != items["eventId"]) && (i < document.fm1.eventId.options.length))
							  {i++;}
							if (i < document.fm1.eventId.options.length)
							  {document.fm1.eventId.selectedIndex = i;
							  document.getElementById("updateEventId").value=items["eventId"];}
			       		}


					}else {
						document.getElementById("eventFlag").checked = false;
						document.getElementById("eventDiv").style.display = "none";
						document.getElementById("eventDivAll").style.display = "none";
						document.getElementById("detailForm").style.visibility ="vsible";
						document.getElementById("successMsgTemplate").style.display="none";
					}

		       		if (items["spAssetId"]!="0") {
						document.getElementById("spAssetFlag").checked = true;
						document.getElementById("spAsseDiv").style.display = "block";
						var i=0;
						while ((document.fm1.spAssetId.options[i].value != items["spAssetId"]) && (i < document.fm1.spAssetId.options.length))
						  {i++;}
						if (i < document.fm1.spAssetId.options.length)
						  {document.fm1.spAssetId.selectedIndex = i;
						  document.getElementById("updateAssetId").value=items["spAssetId"];}
					}else {
						document.getElementById("spAssetFlag").checked = false;
						document.getElementById("spAsseDiv").style.display = "none";
					}

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

function showPrice(priceValue) {
	if (priceValue.value == "minPrice") {
		//document.getElementById("priceList").style.display = "none";
		document.getElementById("minimumPriceDiv").style.display = "block";
		document.getElementById("miniPriceFlag").value = true;
		document.getElementById("priceListFlag").value = false;

	}else {
		document.getElementById("minimumPriceDiv").style.display = "none";
		document.getElementById("minimumPriceDiv").value = "";
		//document.getElementById("priceList").style.display = "block";
		document.getElementById("priceListFlag").value = true;
		document.getElementById("miniPriceFlag").value = false;
	}
}

</script>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String eventFlag = "";
if (request.getAttribute("eventFlag") != null) {
	eventFlag = request.getAttribute("eventFlag").toString();
}

boolean canEdit = false;
if (request.getAttribute("canEdit") != null) {
	canEdit = Boolean.parseBoolean(String.valueOf(request.getAttribute("canEdit")));
}

String spAssetFlag = "";
if (request.getAttribute("spAssetFlag") != null) {
	eventFlag = request.getAttribute("spAssetFlag").toString();
}

List<RsvpDiscount> lstRsvpDiscount = ( List<RsvpDiscount>)renderRequest.getAttribute("discountDetail");
List<RsvpPromoCode> lstRsvpPromoCode = ( List<RsvpPromoCode>)renderRequest.getAttribute("promoCodeDetail");
%>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<form action="<%=editActionURL %>" method="post" id="fm1" name="fm1" >
<input type="hidden" id="updateEventId" name="<portlet:namespace />updateEventId"/>
<input type="hidden" id="updatespAssetId" name="<portlet:namespace />updatespAssetId"/>
<input type="hidden" id="canEdit" name="<portlet:namespace />canEdit" value="<%= canEdit %>"/>
<input type="hidden" id="totalDiscount" name="<portlet:namespace />totalDiscount" value="${totalDiscount}"/>
<input type="hidden" id="totalPromoCode" name="<portlet:namespace />totalPromoCode" value="${totalDiscount}"/>
<input type="hidden" id="miniPriceFlag" name="<portlet:namespace />miniPriceFlag" value="${miniPriceFlag}"/>
<input type="hidden" id="priceListFlag" name="<portlet:namespace />priceListFlag" value="${priceListFlag}"/>


<div class="rsvp-preference-border">
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<input type="radio" name="<portlet:namespace />serviceFlag" id="editRsvp" value="ExistingRSVP"  <c:if test="${serviceFlag == 'ExistingRSVP'}">checked</c:if> style="margin-right:5px;" onclick="selectExistingRsvp(this)"/><span style="padding-rigth:5px">Select Existing RSVP</span>
		<input type="radio" name="<portlet:namespace />serviceFlag" id="newRsvp" value="NewRSVP" <c:if test="${serviceFlag == 'NewRSVP'}">checked</c:if> style="margin-left: 25px;margin-right:5px;" onclick="selectNewRsvp(this)"/><span style="padding-rigth:5px">Create RSVP</span>
	</div>
	<div id="successMsgTemplate" style="background:#f2f2f2;color:red;font-weight:bold;margin-top:10px;padding:10px;height:18px;width:97%;display:none;margin-left:10px;">
		For expired rsvp --> title, Description and subscription Event can not be updated.
	</div>
	<div style="width:100%;padding:10px;display:none;" id="rsvpDiv">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> Select Existing RSVP Title</div>
		<div style="width:70%;display:inline;">
			<select id="rsvpId" name="<portlet:namespace />rsvpId" onchange="fetchRsvp();">	
			<option value=""></option>
			<c:forEach var="rsvp" items="${lstRsvp}">
				<option value="${rsvp.rsvpId }" <c:if test="${rsvpId == rsvp.rsvpId}">selected="selected"</c:if> ><c:out value='${rsvp.title }'/></option>
			</c:forEach>	
			</select>
		</div>
	</div>

	<div id="detailForm" style="visibility:visible">
	<c:if test="${empty rsvpId}">
	<div  style="width:100%;padding:10px;">
		<a onclick="detailSection()" style="font-size:30px;text-decoration:none;float:right;width:63%;" id="expandLink">-<font style='font-size:12px;vertical-align:middle;padding-left:10px;'>Collapse to hide detail</font></a>
	</div>
		<div id="detailSection" style="visibility:visible;height:auto;clear:both;width:100%">
	</c:if>
	<c:if test="${!empty rsvpId}">
	<div  style="width:100%;padding:10px;">
		<a onclick="detailSection()" style="font-size:30px;text-decoration:none;float:right;width:63%;" id="expandLink">+<font style="font-size:12px;vertical-align:middle;padding-left:10px;">Expand to dispaly detail</font></a>
	</div>
		<div id="detailSection" style="visibility:hidden;height:0;clear:both;width:100%">
	</c:if>

	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Title</div>
		<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />title" id="title" value="${title}" style="width:220px;" required="required"/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Description</div>
		<div style="width:80%;display:inline;margin-bottom:5px;"><textarea name="<portlet:namespace />description" id="description" style="width:200px;" required="required">${description}</textarea></div>
	</div>

	</div>

	<div style="width:100%;padding:10px;display:block;">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> Select Campaign</div>
		<div style="width:70%;display:inline;">
			
			<select id="spMailCampaignId" name="<portlet:namespace />spMailCampaignId">
			<option value=""></option>
			<c:forEach var="spMailCampaign" items="${lstMailCampaign}">
				<option value="${spMailCampaign.spMailCampaignId }" <c:if test="${spMailCampaignId == spMailCampaign.spMailCampaignId}">selected="selected"</c:if> ><c:out value='${spMailCampaign.campaignName}'/></option>
			</c:forEach>
			</select>
		</div>
	</div>

	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label ${dynamicSectionName }">User Profile Dynamic Form Name</div>
		<div style="width:80%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />dynamicSectionName" id="dynamicSectionName" value="${dynamicSectionName}" style="width:220px;"/></div>
	</div>
	<!--  
	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Page name of Rsvp dyanamic fields</div>
		<div style="width:80%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />dynamicrsvp" id="dynamicrsvp" value="${dynamicrsvp}" style="width:220px;"/></div>
	</div>-->
	
	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">RSVP URL</div>
		<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />rsvpUrl" id="rsvpUrl" value="${rsvpUrl}" style="width:220px;" required="required"/></div>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="eventRSVP(this)" name="<portlet:namespace />eventFlag" id="eventFlag" <c:if test="${eventFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Event RSVP</span>
	</div>
	
	<div style="width:100%;padding:10px;display:none;" id="eventDiv">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> Events</div>
		<div style="width:70%;display:inline;">
			<select id="eventId" name="<portlet:namespace />eventId">	
			   <option value=""></option>
			  <c:forEach var="cal" items="${lstEvents}">
			  	<option value='${cal.calendarBookingId}' <c:if test="${eventId == cal.calendarBookingId}">selected="selected"</c:if> ><c:out value='${cal.title}'/></option>
			</c:forEach>
			</select>
		</div>
	</div>
	
	
	
		<div style="width:100%;padding:10px;display:block;" id="eventDivAll">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> Events</div>
		<div style="width:70%;display:inline;">
			<select id="alleventId" name="<portlet:namespace />alleventId">	
			   <option value=""></option>
			  <c:forEach var="cal" items="${lstEventsAll}">
			  	<option value='${cal.calendarBookingId}' <c:if test="${eventId == cal.calendarBookingId}">selected="selected"</c:if> ><c:out value='${cal.title}'/></option>
			</c:forEach>
			</select>
		</div>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="assetRSVP(this)" name="<portlet:namespace />spAssetFlag" id="spAssetFlag" <c:if test="${spAssetFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable SPAsset RSVP</span>
	</div>

	
	<div style="width:100%;padding:10px;display:none;" id="spAssetDiv">
		<div style="width:30%;display:inline-block;color:#000000;font-weight:bold;"> SPAsset</div>
		<div style="width:70%;display:inline;">
		
			<select id="spAssetId" name="<portlet:namespace />spAssetId">	
			   <option value=""></option>
			   <c:forEach var="spAsset" items="${lstSPAssets}">
			   <option value='${spAsset.spAssetTypeId}' <c:if test="${spAssetTypeId == spAsset.spAssetTypeId}">selected="selected"</c:if> ><c:out value='${spAsset.spAssetTypeName}'/></option>	
			</c:forEach>
			</select>
		</div>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="enablePayment(this)"  name="<portlet:namespace />paymentFlag" id="paymentFlag" <c:if test="${paymentFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Payment</span>
	</div>
	<c:choose>
		<c:when test="${paymentFlag == 'true'}">
			<div id="paymentDiv" style="display:block;">
		</c:when>
		<c:otherwise>
			<div id="paymentDiv" style="display:none;">
		</c:otherwise>
	</c:choose>

		<div style="width:100%;padding:10px;">
			<div class="rsvp-preference-label">Account ID</div>
			<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />accountID" id="accountID" value="${accountID}" style="width:220px;" /></div>
		</div>

		<div style="width:100%;padding:10px;">
			<div class="rsvp-preference-label">Logo URL to display on paypal page</div>
			<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />logoUrl" id="logoUrl" value="${logoUrl}" style="width:220px;" /></div>
		</div>

		<div style="width:100%;padding:10px;">
			<div class="rsvp-preference-label">Color Code</div>
			<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />colorCode" id="colorCode" value="${colorCode}" style="width:220px;" /></div>
		</div>

		<div style="width:100%;padding:10px; margin-bottom: 30px;">
			<div class="rsvp-preference-label">Price</div>
			<div style="width:70%;display:inline;margin-bottom:5px;">
				<input type="radio" name="<portlet:namespace />price" id="minPrice" value="minPrice" onclick="showPrice(this);" <c:if test="${miniPriceFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if>> Minimum Price</input>
				<input type="radio" name="<portlet:namespace />price" id="listPrice"  value="listPrice" onclick="showPrice(this);" <c:if test="${priceListFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if>> Price List</input>
			</div>
			<div style="width:70%;display:inline;margin-bottom:5px;margin-top:10px;float:right;">
				<c:choose>
					<c:when test="${miniPriceFlag == 'true'}">
						<div id="minimumPriceDiv" style="display:block;">
					</c:when>
					<c:otherwise>
						<div id="minimumPriceDiv" style="display:none;">
					</c:otherwise>
				</c:choose>

					<div style="display:100%;margin-bottom:10px;">
						<div class="rsvp-preference-label">Mininum Price</div>
						<div style="display:inline-block;"><input type="text" name="<portlet:namespace />priceField" id="priceField" value="${price}" style="width:220px;" /></div>
					</div>
					<div style="display:100%;">
						<div class="rsvp-preference-label">Default Price</div>
						<div style="display:inline-block;"><input type="text" name="<portlet:namespace />defaultPrice" id="defaultPrice" value="${defaultPrice}" style="width:220px;" /></div>
					</div>

				</div>

			</div>
		</div>

		<div style="width:100%;padding:10px;clear:both;">
			<div class="rsvp-preference-label">Currency</div>
			<div style="width:70%;display:inline;margin-bottom:5px;">
				<select id="categoryId" name="<portlet:namespace />categoryId">	
			   	<option value=""></option>
			    <c:forEach var="assetCategory" items="${lstAssetCategory}">
					<option value="${assetCategory.categoryId }" <c:if test="${categoryId == assetCategory.categoryId}">selected="selected"</c:if>><c:out value='${assetCategory.name }'/></option>
				</c:forEach>
				</select>

			</div>
		</div>

		<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
			 <input type="checkbox" name="<portlet:namespace />signInFlag" id="signInFlag" <c:if test="${signInFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">Enable Sign In</span>
		</div>
		
		<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
			 <input type="checkbox" name="<portlet:namespace />emailFlag" id="emailFlag" <c:if test="${emailFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">Email registration data to Admin (Enable only if payment is disabled)</span>
		</div>
		
		<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
			 <input type="checkbox" onclick="enableDiscount(this)"  name="<portlet:namespace />discountFlag" id="discountFlag" <c:if test="${discountFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
			Enable Discount</span>
		</div>
		<c:if test="${discountFlag}">
			<div style="width:100%;padding:10px;" id="discountDiv">
		</c:if>
		<c:if test="${!discountFlag}">
			<div style="width:100%;padding:10px;display:none;" id="discountDiv">
		</c:if>
		
			<div class="rsvp-preference-label">Discounts</div>
			<a href="javascript:addDiscountRow()">+ Add Row</a>
			<br>
			<div style="width:70%;display:inline;margin-bottom:5px;" id="discountDetails">
			<c:if test="${!empty discountDetail}">
				<table style="width:98%;margin-top:10px;margin-bottom:10px;">
					<tr style="border:1px solid #c5c5c5;">
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Price List</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Number of tickets</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Start Date</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">End Date</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Discount</td>
					</tr>

				<% if (lstRsvpDiscount != null) {
					 SimpleDateFormat format =
			                    new SimpleDateFormat("dd/MM/yyyy");
					for (int i=0;i<lstRsvpDiscount.size();i++) {
						RsvpDiscount rsvpDis = lstRsvpDiscount.get(i);
						RsvpTicket spRsvpTicket = RsvpTicketLocalServiceUtil.getRsvpTicket(rsvpDis.getRsvpTicketId());
				%>

				<tr>
					<td style="border:1px solid #c5c5c5;padding:5px;"><%= spRsvpTicket.getPrice() %></td>
					<td style="border:1px solid #c5c5c5;padding:5px;"><%= rsvpDis.getNoOfTickets() %></td>
					<td style="border:1px solid #c5c5c5;padding:5px;"><%= format.format(rsvpDis.getFromDate()) %></td>
					<td style="border:1px solid #c5c5c5;padding:5px;"><%= format.format(rsvpDis.getToDate()) %></td>
					<td style="border:1px solid #c5c5c5;padding:5px;"><%= rsvpDis.getDiscount() %></td>

				</tr>
				<% }} %>
				</table>
			</c:if>

			</div>
		</div>



		<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
			 <input type="checkbox" onclick="enablePromoCode(this)"  name="<portlet:namespace />promoCodeFlag" id="promoCodeFlag" <c:if test="${promoCodeFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">Enable Promo Code</span>
		</div>
		
		<div style="width:100%; padding:10px; <c:if test="${promoCodeFlag != 'true'}">display: none;</c:if>"  id="promoCodeDiv">
		
			<div class="rsvp-preference-label">Promo Codes</div>
			<a href="javascript:addPromoCodeRow()">+ Add Row</a>
			<br>
			<div style="width:70%; display:inline; margin-bottom:5px;" id="promoCodeDetails">
			<c:if test="${!empty promoCodeDetail}">
				<table style="width:98%; margin-top:10px; margin-bottom:10px;">
					<tr style="border:1px solid #c5c5c5;">
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Price List</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Number of tickets</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Promo Code</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Start Date</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">End Date</td>
						<td style="border:1px solid #c5c5c5;padding:5px; font-weight: bold;">Discount</td>
					</tr>

					<% if (lstRsvpPromoCode != null) {
						 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						for (int i=0;i<lstRsvpPromoCode.size();i++) {
							RsvpPromoCode rsvpPC = lstRsvpPromoCode.get(i);
							RsvpTicket spRsvpTicket = RsvpTicketLocalServiceUtil.getRsvpTicket(rsvpPC.getRsvpTicketId());
					%>

					<tr>
						<td style="border:1px solid #c5c5c5;padding:5px;"><%= spRsvpTicket.getPrice() %></td>
						<td style="border:1px solid #c5c5c5;padding:5px;"><%= rsvpPC.getNoOfTickets() %></td>
						<td style="border:1px solid #c5c5c5;padding:5px;"><%= rsvpPC.getPromoCode() %></td>
						<td style="border:1px solid #c5c5c5;padding:5px;"><%= format.format(rsvpPC.getFromDate()) %></td>
						<td style="border:1px solid #c5c5c5;padding:5px;"><%= format.format(rsvpPC.getToDate()) %></td>
						<td style="border:1px solid #c5c5c5;padding:5px;"><%= rsvpPC.getDiscount() %></td>

					</tr>
					<% }
					} %>

				</table>
			</c:if>

			</div>
		</div>

		<div style="width:100%;padding:10px;">
			<div class="rsvp-preference-label">Tax</div>
			<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />tax" id="tax" value="${tax}" style="width:220px;" /></div>
		</div>

	</div>

	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Display Fields Order</div>
		<div style="width:80%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />orderFields" id="orderFields" value="${orderFields}" style="width:220px;"/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Grouping</div>
		<div style="width:80%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />grouping" id="grouping" value="${grouping}" style="width:220px;"/></div>
	</div>	
	
	<div id="divPriceList" style="visibility:hidden;">
		<select id="priceListId" name="<portlet:namespace />priceListId" >
			<option value=""></option>
				<c:forEach var="pList" items="${priceList}">
					<option value="${pList.spRsvpTicketId }"><c:out value='${pList.price}'/></option>
				</c:forEach>
		</select>
	</div>

	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Enable / Disable Fields</div>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />registrationFlag" id="registrationFlag" <c:if test="${registrationFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable User Registration</span>
	</div>
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />multiRegFlag" id="multiRegFlag" <c:if test="${multiRegFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Co-participant Registration</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<input type="checkbox" onclick=""  name="<portlet:namespace />mandatoryFlagChild" id="mandatoryFlagChild" <c:if test="${mandatoryFlagChild == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
			Apply mandatory check for Co-participant Registration details</span>
	</div>
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />defaultStatusFlag" id="defaultStatusFlag" <c:if test="${defaultStatusFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Default Rsvp Status</span>
	</div>
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />countryFlag" id="countryFlag" <c:if test="${countryFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Country</span>
	</div>
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />genderFlag" id="genderFlag" <c:if test="${genderFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Gender</span>
	</div>
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />numberOfPeopleFlag" id="numberOfPeopleFlag" <c:if test="${numberOfPeopleFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable number of people</span>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />pdfTicket" id="pdfTicket" <c:if test="${pdfTicket == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Generate PDF Ticket</span>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />ccEmail" id="ccEmail" <c:if test="${ccEmail == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Send copy of thankyou email</span>
	</div>		

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />identificationTypeFlag" id="identificationTypeFlag" <c:if test="${identificationTypeFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Identification Type</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<div class="rsvp-preference-label">Identification type Vocabulary</div>
		<div style="width:70%;display:inline;margin-bottom:5px;">
			<select id="identificationTypeVocId" name="<portlet:namespace />identificationTypeVocId">    
	             <c:forEach var="assetVocabularyIType" items="${vocabularies}">
	                 <option value="${assetVocabularyIType.primaryKey}"<c:if test="${identificationTypeVocId == assetVocabularyIType.primaryKey}">selected="selected"</c:if> ><c:out value='${assetVocabularyIType.name}'/></option>
	             </c:forEach>
			</select>
		</div>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />identificationNumberFlag" id="identificationNumberFlag" <c:if test="${identificationNumberFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Identification Number</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />passwordFlag" id="passwordFlag" <c:if test="${passwordFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Password</span>
	</div>	
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />streetAddress1Flag" id="streetAddress1Flag" <c:if test="${streetAddress1Flag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Street Address 1</span>
	</div>	
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />streetAddress2Flag" id="streetAddress2Flag" <c:if test="${streetAddress2Flag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Street Address 2</span>
	</div>	
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />postalCodeFlag" id="postalCodeFlag" <c:if test="${postalCodeFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Postal Code</span>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />cityFlag" id="cityFlag" <c:if test="${cityFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable City </span>
	</div>
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />stateFlag" id="stateFlag" <c:if test="${stateFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable State</span>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />phoneNumber1Flag" id="phoneNumber1Flag" <c:if test="${phoneNumber1Flag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Phone Number 1</span>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />phoneNumber2Flag" id="phoneNumber2Flag" <c:if test="${phoneNumber2Flag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Phone Number 2</span>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />hearAboutUsFlag" id="hearAboutUsFlag" <c:if test="${hearAboutUsFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Hear About Us</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<div class="rsvp-preference-label">Hear about us Vocabulary</div>
		<div style="width:70%;display:inline;margin-bottom:5px;">
			<select id="hearAboutUsVocId" name="<portlet:namespace />hearAboutUsVocId">    
	             <c:forEach var="assetVocabularyHType" items="${vocabularies}">
	                 <option value="${assetVocabularyHType.primaryKey}"<c:if test="${hearAboutUsVocId == assetVocabularyHType.primaryKey}">selected="selected"</c:if> ><c:out value='${assetVocabularyHType.name}'/></option>
	             </c:forEach>
			</select>
		</div>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />attendedWebinarFlag" id="attendedWebinarFlag" <c:if test="${attendedWebinarFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Attended Webinar</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />termsOfUseFlag" id="termsOfUseFlag" <c:if test="${termsOfUseFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Terms of Use</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />ageRestrictionFlag" id="ageRestrictionFlag" <c:if test="${ageRestrictionFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Age Restriction</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />ageGroupFlag" id="ageGroupFlag" <c:if test="${ageGroupFlag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable Age Group</span>
	</div>

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<div class="rsvp-preference-label">Age Group Vocabulary</div>
		<div style="width:70%;display:inline;margin-bottom:5px;">
			<select id="ageGroupVocId" name="<portlet:namespace />ageGroupVocId">    
	             <c:forEach var="assetVocabularyAType" items="${vocabularies}">
	                 <option value="${assetVocabularyAType.primaryKey}"<c:if test="${ageGroupVocId == assetVocabularyAType.primaryKey}">selected="selected"</c:if> ><c:out value='${assetVocabularyAType.name}'/></option>
	             </c:forEach>
			</select>
		</div>
	</div>
	
	
	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		 <input type="checkbox" onclick="" name="<portlet:namespace />customList1Flag" id="customList1Flag" <c:if test="${customList1Flag == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> value="true" /><span style="padding-left:10px;">
		Enable CustomList1</span>
	</div>
	
	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">CustomList1 Label</div>
		<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />customList1Label" id="customList1Label" value="${customList1Label}" style="width:220px;" /></div>
	</div>	

	<div style="width:100%;padding:10px;color:#000000;font-weight:bold;">
		<div class="rsvp-preference-label">CustomList1 Vocabulary</div>
		<div style="width:70%;display:inline;margin-bottom:5px;">
			<select id="customList1VocId" name="<portlet:namespace />customList1VocId">    
	             <c:forEach var="assetVocabularyCustList" items="${vocabularies}">
	                 <option value="${assetVocabularyCustList.primaryKey}"<c:if test="${customList1VocId == assetVocabularyCustList.primaryKey}">selected="selected"</c:if> ><c:out value='${assetVocabularyCustList.name}'/></option>
	             </c:forEach>
			</select>
		</div>
	</div>
	
			
	<input type="button" value="Save Changes" onclick="ValidateForm()"/>
	
</div>	
</div>	
</form>
<script type="text/javascript">
var totalCount = 0;
function addDiscountRow() {
	var divElm = document.getElementById("discountDetails");

	totalCount++;
	document.getElementById("totalDiscount").value = totalCount;
	var table = null;

	if (totalCount == 1) {
		table = document.createElement("table");
		table.setAttribute("id","discountTable");
		table.setAttribute("style","margin-top: 10px;width:98%;");

		var tr = document.createElement("tr");
		tr.setAttribute("style","border:1px solid #c5c5c5");

		var td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		var lblNode = document.createTextNode("Price List");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		var lblNode = document.createTextNode("Number of tickets");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("Start Date (DD/MM/YYYY)");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("End Date (DD/MM/YYYY)");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("Discount percent");
		td.appendChild(lblNode);
		tr.appendChild(td);
		table.appendChild(tr);

	}else {
		table = document.getElementById("discountTable");
	}

	var childTr = document.createElement("tr");
	childTr.setAttribute("style","border:1px solid #c5c5c5;");

	var childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");

	var dropdownBox = document.getElementById("divPriceList").innerHTML;

	var re = /priceListId/gi;
	var newstr = dropdownBox.replace(re, "priceListId"+totalCount);
	childtd.innerHTML = newstr;
	childTr.appendChild(childtd);

	var childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");

	var tktElm = document.createElement("input");
	tktElm.setAttribute("type","text");
	tktElm.setAttribute("name","ticket"+totalCount);
	tktElm.setAttribute("id","ticket"+totalCount);
	tktElm.setAttribute("style","width:70px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(tktElm);
	childTr.appendChild(childtd);

	childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var fDateElm = document.createElement("input");
	fDateElm.setAttribute("name","fDate"+totalCount);
	fDateElm.setAttribute("id","fDate"+totalCount);
	fDateElm.setAttribute("type","text");
	fDateElm.setAttribute("style","width:170px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(fDateElm);
	childTr.appendChild(childtd);

	childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var tDateElm = document.createElement("input");
	tDateElm.setAttribute("name","tDate"+totalCount);
	tDateElm.setAttribute("id","tDate"+totalCount);
	tDateElm.setAttribute("type","text");
	tDateElm.setAttribute("style","width:170px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(tDateElm);
	childTr.appendChild(childtd);

	childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var discountElm = document.createElement("input");
	discountElm.setAttribute("name","discount"+totalCount);
	discountElm.setAttribute("id","discount"+totalCount);
	discountElm.setAttribute("type","text");
	discountElm.setAttribute("style","width:70px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(discountElm);
	childTr.appendChild(childtd);

	table.appendChild(childTr);


	divElm.appendChild(table);

	//divElm.appendChild(tktElm);
	//divElm.appendChild(fDateElm);
	//divElm.appendChild(tDateElm);
	//divElm.appendChild(discountElm);
	divElm.appendChild("<br>");
}

var totalPromoCodeCount = 0;
function addPromoCodeRow() {
	var divElm = document.getElementById("promoCodeDetails");

	totalPromoCodeCount++;
	document.getElementById("totalPromoCode").value = totalPromoCodeCount;
	var table = null;

	if (totalPromoCodeCount == 1) {
		table = document.createElement("table");
		table.setAttribute("id","promoCodeTable");
		table.setAttribute("style","margin-top: 10px; width:98%;");

		var tr = document.createElement("tr");
		tr.setAttribute("style","border:1px solid #c5c5c5");

		var td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		var lblNode = document.createTextNode("Price List");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("Number of tickets");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("Promo Code");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("Start Date (DD/MM/YYYY)");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("End Date (DD/MM/YYYY)");
		td.appendChild(lblNode);
		tr.appendChild(td);

		td = document.createElement("td");
		td.setAttribute("style","border:1px solid #c5c5c5;padding:5px; font-weight: bold;");
		lblNode = document.createTextNode("Discount percent");
		td.appendChild(lblNode);
		tr.appendChild(td);
		table.appendChild(tr);

	}else {
		table = document.getElementById("promoCodeTable");
	}

	var childTr = document.createElement("tr");
	childTr.setAttribute("style","border:1px solid #c5c5c5;");

	var childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");

	var dropdownBox = document.getElementById("divPriceList").innerHTML;

	var re = /priceListId/gi;
	var newstr = dropdownBox.replace(re, "priceListIdPC"+totalPromoCodeCount);
	childtd.innerHTML = newstr;
	childTr.appendChild(childtd);

	var childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var tktElm = document.createElement("input");
	tktElm.setAttribute("type","text");
	tktElm.setAttribute("name","ticketPC"+totalPromoCodeCount);
	tktElm.setAttribute("id","ticketPC"+totalPromoCodeCount);
	tktElm.setAttribute("style","width:70px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(tktElm);
	childTr.appendChild(childtd);

	var childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var pcElm = document.createElement("input");
	pcElm.setAttribute("type","text");
	pcElm.setAttribute("name","promoCodePC"+totalPromoCodeCount);
	pcElm.setAttribute("id","promoCodePC"+totalPromoCodeCount);
	pcElm.setAttribute("style","width:90px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(pcElm);
	childTr.appendChild(childtd);

	childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var fDateElm = document.createElement("input");
	fDateElm.setAttribute("name","fDatePC"+totalPromoCodeCount);
	fDateElm.setAttribute("id","fDatePC"+totalPromoCodeCount);
	fDateElm.setAttribute("type","text");
	fDateElm.setAttribute("style","width:90px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(fDateElm);
	childTr.appendChild(childtd);

	childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var tDateElm = document.createElement("input");
	tDateElm.setAttribute("name","tDatePC"+totalPromoCodeCount);
	tDateElm.setAttribute("id","tDatePC"+totalPromoCodeCount);
	tDateElm.setAttribute("type","text");
	tDateElm.setAttribute("style","width:90px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(tDateElm);
	childTr.appendChild(childtd);

	childtd = document.createElement("td");
	childtd.setAttribute("style","border:1px solid #c5c5c5;padding:5px;");
	var discountElm = document.createElement("input");
	discountElm.setAttribute("name","discountPC"+totalPromoCodeCount);
	discountElm.setAttribute("id","discountPC"+totalPromoCodeCount);
	discountElm.setAttribute("type","text");
	discountElm.setAttribute("style","width:70px;display:inline-block;margin-left: 0px;");
	childtd.appendChild(discountElm);
	childTr.appendChild(childtd);

	table.appendChild(childTr);


	divElm.appendChild(table);

	//divElm.appendChild(tktElm);
	//divElm.appendChild(fDateElm);
	//divElm.appendChild(tDateElm);
	//divElm.appendChild(discountElm);
	divElm.appendChild("<br>");
}

function replaceAll(find, replace, str)
{
while ( str.indexOf(find) > -1)
{
	str = str.replace(find, replace);
}
return str;
}

AUI().ready(function(A) {
	var serviceFlag= document.getElementById("editRsvp").checked;
	var eventFlag= document.getElementById("eventFlag");
	var spAssetFlag= document.getElementById("spAssetFlag");

	var e = document.getElementById("spMailCampaignId");
	var spMailCampaignId= e.options[e.selectedIndex].value;

	if (serviceFlag==true) {
		document.getElementById("rsvpDiv").style.display = "block";
		//document.getElementById("spMailCampaignId").disabled = true;

	}else {
		document.getElementById("expandLink").style.display = "none";
	}

	if (document.getElementById("discountFlag").checked == true) {
		fetchDiscount();
	}
	fetchRsvp();
	//loadDiscount();

	if (eventFlag.checked==true) {
		var canEdit = '<%= canEdit %>';
		if (canEdit.indexOf("false") > -1) {
			document.getElementById("eventDivAll").style.display = "block";
			document.getElementById("eventDiv").style.display = "none";
		}else {
			document.getElementById("eventDiv").style.display = "block";
			document.getElementById("eventDivAll").style.display = "none";
		}

	}

	if (spAssetFlag.checked==true) {
		document.getElementById("spAssetDiv").style.display = "block";
	}

});

function detailSection() {

	if (document.getElementById("detailSection").style.visibility == "visible") {
		document.getElementById("detailSection").style.height = "0";
		document.getElementById("detailSection").style.visibility = "hidden";
		document.getElementById("expandLink").innerHTML = "+<font style='font-size:12px;vertical-align:middle;padding-left:10px;'>Expand to dispaly detail</font>";
	}else {
		document.getElementById("detailSection").style.visibility = "visible";
		document.getElementById("detailSection").style.height = "auto";
		document.getElementById("expandLink").innerHTML = "-<font style='font-size:12px;vertical-align:middle;padding-left:10px;'>Collapse to hide detail</font>";
	}
}

function enableEventRSVP(cb) {

	if (cb.checked==false) {
		document.getElementById("eventDiv").style.visibility = "hidden";
	}else {
		document.getElementById("eventDiv").style.visibility = "visible";
	}
	}

function enableDiscount(cb) {

	if (cb.checked == false) {
		document.getElementById("discountDiv").style.display = "none";
	}else {
		document.getElementById("discountDiv").style.display = "block";
	}
}

function enablePromoCode(cb) {

	if (cb.checked == false) {
		document.getElementById("promoCodeDiv").style.display = "none";
	}else {
		document.getElementById("promoCodeDiv").style.display = "block";
	}
}

	function eventRSVP(cb) {

		if (cb.checked==false) {
			//document.getElementById("spAssetDiv").style.visibility = "hidden";

			document.getElementById("eventDiv").style.display = "none";
			document.getElementById("eventDivAll").style.display = "none";
		}else {
			//document.getElementById("serviceRSVP").style.visibility = "visible";
			<%-- var canEdit = '<%= canEdit %>';
			if (canEdit.indexOf("false") > -1) {
				document.getElementById("eventDivAll").style.display = "block";
				document.getElementById("eventDiv").style.display = "none";
			}else {
				document.getElementById("eventDiv").style.display = "block";
				document.getElementById("eventDivAll").style.display = "none";
			} --%>

			document.getElementById("eventDiv").style.display = "block";
			document.getElementById("eventDivAll").style.display = "none";

		}
	}

	function ValidateForm() {
		var validFlag = true;
		if (document.getElementById("paymentFlag").checked==true) {
			if (document.getElementById("accountID").value.length == 0) {
				alert("Account ID should not be empty.");
				validFlag = false;
			}else if ((document.getElementById("minPrice").checked == true) && (document.getElementById("priceField").value.length == 0)) {
				alert("Price should not be empty.");
				validFlag = false;
			}else if (document.getElementById("tax").value.length == 0) {
				alert("Tax should not be empty.");
				validFlag = false;
			}else if (document.getElementById("categoryId").value.length == 0) {
				alert("Currency should not be empty.");
				validFlag = false;
			}

		}
		if (validFlag==true) {
			document.getElementById("fm1").submit();
		}

	}

	function loadDiscount() {
		var A=AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';

	}
</script>
