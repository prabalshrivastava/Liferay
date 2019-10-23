<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ include file="/html/common/init-ext.jsp" %>
<portlet:defineObjects />

<liferay-theme:defineObjects />
<c:choose>
	<c:when test="${hasAccess}">
		<div class="rsvp-maindiv">
			<div class="rsvpbox-title">RSVP Ticket Create</div>
			<div style="margin: 10px;">
				<div
					style='width: 20%; display: inline-block; vertical-align: top; padding-left: 12px;'>
					<span class="pets-rsvp-label">Select RSVP</span>
				</div>
				<div style="padding-right: 20px; display: inline-block">
					<select id="spRsvpId" name="spRsvpId" onchange="enableAddTicket()">
						<option value=""></option>
						<c:forEach items="${lstRsvp}" var="rsvp">
							<option value="${rsvp.rsvpId}">
								<c:out value="${rsvp.title}"></c:out>
						</c:forEach>
					</select>
				</div>
				<div id="addButtonDiv" style="width: 49%; display: none;">
					<input onclick="addTicket()" type="button" value="Add Ticket" />
				</div>
			</div>
			<div id="successMsgTemplate"
				style="background: #f2f2f2; color: green; font-weight: bold; margin-top: 10px; padding: 10px; height: 18px; width: 97%; display: none;">
				RSVP Ticket is successfully created.</div>
			<div id="addTicketDiv"
				style="display: none; background: #f8f8f8; margin: 10px; padding: 5px;">
				<div style="width: 100%; padding: 12px;">
					<div style="width: 20%; display: inline-block;">
						<span class="pets-rsvp-label">Price</span>
					</div>
					<div style="width: 79%; display: inline-block;">
						<input name="txtPrice" type="text" id="txtPrice"
							class="rsvp-textbox" style="margin-left: -6px;" /> <span
							id="txtPriceError">&nbsp;</span>
					</div>
				</div>
				<div style="widht: 100%; padding: 12px;">
					<div style="width: 20%; display: inline-block;">
						<span class="pets-rsvp-label">Quantity</span>
					</div>
					<div style="width: 79%; display: inline-block;">
						<input name="txtQuantity" type="text" id="txtQuantity"
							class="rsvp-textbox" /> <span id="txtQuantityError">&nbsp;</span>
					</div>
				</div>
				<div style="widht: 100%; padding: 12px;">
					<div style="width: 20%; display: inline-block;">
						<span class="pets-rsvp-label">Ticket Sequence</span>
					</div>
					<div style="width: 79%; display: inline-block;">
						<input name="txtTicketSeq" type="text" id="txtTicketSeq"
							class="rsvp-textbox" /> <span id="txtTicketSeqError">&nbsp;</span>
					</div>
				</div>
				<div style="widht: 100%; padding: 12px;">
					<div style="width: 20%; display: inline-block;">
						<span class="pets-rsvp-label">Sequence Prefix</span>
					</div>
					<div style="width: 79%; display: inline-block;">
						<input name="txtSeqPrefix" type="text" id="txtSeqPrefix"
							class="rsvp-textbox" /> <span id="txtSeqPrefixError">&nbsp;</span>
					</div>
				</div>
				<div style="widht: 100%; padding: 12px;">
					<div style="width: 20%; display: inline-block;">
						<span class="pets-rsvp-label">Sequence Suffix</span>
					</div>
					<div style="width: 79%; display: inline-block;">
						<input name="txtSeqPostfix" type="text" id="txtSeqPostfix"
							class="rsvp-textbox" /> <span id="txtSeqPostfixError">&nbsp;</span>
					</div>
				</div>
				<div style="widht: 100%; padding: 12px;">
					<div style="width: 20%; display: inline-block;">
						<span class="pets-rsvp-label">Ticket Template URL</span>
					</div>
					<div style="width: 79%; display: inline-block;">
						<input type="text" name="txtTicketTemplateURL"
							id="txtTicketTemplateURL" class="rsvp-textbox" /> <span
							id="txtTicketTemplateURLError">&nbsp;</span>
					</div>
				</div>
				<div style="wdith: 100%;">
					<input onclick="saveTicket()" type="button" value="Save" />
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div>You don't have required role to access this page</div>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	function addTicket() {
		document.getElementById("addTicketDiv").style.display = "block";
	}

	function saveTicket() {

		document.getElementById("txtPriceError").innerHTML = "";
		document.getElementById("txtQuantityError").innerHTML = "";
		document.getElementById("txtTicketSeqError").innerHTML = "";
		document.getElementById("txtSeqPrefixError").innerHTML = "";
		document.getElementById("txtSeqPostfixError").innerHTML = "";
		document.getElementById("txtTicketTemplateURLError").innerHTML = "";
		document.getElementById("successMsgTemplate").style.display = "none";

		var A = AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		try {
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
									txtPrice : document
											.getElementById("txtPrice").value,
									txtQuantity : document
											.getElementById("txtQuantity").value,
									txtTicketSeq : document
											.getElementById("txtTicketSeq").value,
									txtSeqPrefix : document
											.getElementById("txtSeqPrefix").value,
									txtSeqPostfix : document
											.getElementById("txtSeqPostfix").value,
									txtTicketTemplateURL : document
											.getElementById("txtTicketTemplateURL").value,
									spRsvpId : document
											.getElementById("spRsvpId").value,

								},
								on : {
									success : function() {
										items = this.get('responseData');
										var successFlag = items["saveFlag"];

										if (successFlag == 'success') {

											document.getElementById("txtPrice").value = "";
											document
													.getElementById("txtQuantity").value = "";
											document
													.getElementById("txtTicketSeq").value = "";
											document
													.getElementById("txtSeqPrefix").value = "";
											document
													.getElementById("txtSeqPostfix").value = "";
											document
													.getElementById("txtTicketTemplateURL").value = "";
											document
													.getElementById("successMsgTemplate").style.display = "block";
										} else {
											for (key in items) {
												if (key == "saveFlag") {

												} else {

													document.getElementById(key
															+ "Error").innerHTML = items[key];
													document.getElementById(key
															+ "Error").style.color = "red";
												}
											}
										}

									},
									failure : function() {

									}
								}

							});
		} catch (err) {

		}
	}

	function enableAddTicket() {
		if (document.getElementById("spRsvpId").value != "") {
			document.getElementById("addButtonDiv").style.display = "inline-block";
		} else {
			document.getElementById("addButtonDiv").style.display = "none";
		}

	}
</script>