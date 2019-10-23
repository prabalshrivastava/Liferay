<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ include file="/html/common/init-ext.jsp" %>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="loadTickets"></portlet:param>
</portlet:actionURL>

<c:choose>
	<c:when test="${hasAccess}">
		<form action="<%= editActionURL %>" id="fm" name="fm">
			<div class="rsvp-maindiv">
				<div class="rsvpbox-title">RSVP Ticket Listing</div>
				<div style="margin: 10px;">
					<div
						style='width: 20%; display: inline-block; vertical-align: top;'>
						<span class="rsvp-label">Select RSVP</span>
					</div>
					<div style='width: 79%; display: inline-block'>
						<select id="spRsvpId" name="<portlet:namespace />spRsvpId" onchange="loadTicketList()">
							<option value=""></option>
							<c:forEach var="rsvp" items="${lstRsvp}">
								<option value="${rsvp.rsvpId}">
									<c:out value="${rsvp.title}"></c:out>
							</c:forEach>
						</select>
					</div>
				</div>
				<div id="rsvpDetails">
					<table id="rsvpDetailTable" style="background: #f8f8f8;">
						<tr>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Price</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Quantity</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Sold
								Quantity</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Starting
								Ticket Sequence</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Current
								Ticket Sequence</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Create
								By</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Create
								Date</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Modified
								By</td>
							<td
								style="font-weight: bold; border: 1px solid #C5C5C5; padding: 5px;">Modified
								Date</td>
						</tr>

					</table>
				</div>
				<div style="float: right; font-weight: bold; margin-top: 15px;">
					<a href="${createPageName}">+ Add New Ticket</a>
				</div>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<div>You don't have required role to access this page</div>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	function loadTicketList() {
		var A = AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';

		var tableElement = document.createElement("table");
		tableElement.setAttribute("id", "rsvpDetailTable");
		tableElement.setAttribute("style", "background:#f8f8f8");

		var trElement = document.createElement("tr");

		var tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");

		var labelElement = document.createTextNode("Price");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Ticket Quantity");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Sold Quantity");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Starting Ticket Sequence");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Current Ticket Sequence");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Create By");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Create Date");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Modified By");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		tdElement.setAttribute("style",
				"font-weight:bold;border: 1px solid #C5C5C5;padding:5px;");
		labelElement = document.createTextNode("Modified Date");
		tdElement.appendChild(labelElement);
		trElement.appendChild(tdElement);

		tableElement.appendChild(trElement);
		document.getElementById("rsvpDetails").innerHTML = "";

		document.getElementById("rsvpDetails").appendChild(tableElement);

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
									action : "loadTickets",
									spRsvpId : document
											.getElementById("spRsvpId").value,

								},
								on : {
									success : function() {
										items = this.get('responseData');
										var count = Object.keys(items).length;
										if (count > 0) {
											if (items) {
												for (key in items) {

													var tblRow = document
															.createElement("tr");
													tableElement
															.appendChild(tblRow);

													var priceCol = document
															.createElement("td");
													priceCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var quantityCol = document
															.createElement("td");
													quantityCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var soldQuantityCol = document
															.createElement("td");
													soldQuantityCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var startingTicketSeqCol = document
															.createElement("td");
													startingTicketSeqCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var currentTicketSeqCol = document
															.createElement("td");
													currentTicketSeqCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var createByCol = document
															.createElement("td");
													createByCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var createDateCol = document
															.createElement("td");
													createDateCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var modifiedByCol = document
															.createElement("td");
													modifiedByCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													var modifiedDateCol = document
															.createElement("td");
													modifiedDateCol
															.setAttribute(
																	"style",
																	"border: 1px solid #F2F2F2;padding:5px;");

													tblRow
															.appendChild(priceCol);
													tblRow
															.appendChild(quantityCol);
													tblRow
															.appendChild(soldQuantityCol);
													tblRow
															.appendChild(startingTicketSeqCol);
													tblRow
															.appendChild(currentTicketSeqCol);
													tblRow
															.appendChild(createByCol);
													tblRow
															.appendChild(createDateCol);
													tblRow
															.appendChild(modifiedByCol);
													tblRow
															.appendChild(modifiedDateCol);

													var cellTextValues = items[key];
													for (key in cellTextValues) {
														switch (key) {
														case "price":
															var priceValue = document
																	.createTextNode(cellTextValues[key]);
															priceCol
																	.appendChild(priceValue);
															break;
														case "quantity":
															var quantityValue = document
																	.createTextNode(cellTextValues[key]);
															quantityCol
																	.appendChild(quantityValue);
															break;
														case "soldquantity":
															var soldquantityValue = document
																	.createTextNode(cellTextValues[key]);
															soldQuantityCol
																	.appendChild(soldquantityValue);
															break;
														case "startingticket":
															var startingticketValue = document
																	.createTextNode(cellTextValues[key]);
															startingTicketSeqCol
																	.appendChild(startingticketValue);
															break;
														case "currentticket":
															var currentticketValue = document
																	.createTextNode(cellTextValues[key]);
															currentTicketSeqCol
																	.appendChild(currentticketValue);
															break;
														case "createdBy":
															var createdByValue = document
																	.createTextNode(cellTextValues[key]);
															createByCol
																	.appendChild(createdByValue);
															break;
														case "createDate":
															var createDateValue = document
																	.createTextNode(cellTextValues[key]);
															createDateCol
																	.appendChild(createDateValue);
															break;
														case "modifiedBy":
															var modifiedByValue = document
																	.createTextNode(cellTextValues[key]);
															modifiedByCol
																	.appendChild(modifiedByValue);
															break;
														case "modifiedDate":
															var modifiedDateValue = document
																	.createTextNode(cellTextValues[key]);
															modifiedDateCol
																	.appendChild(modifiedDateValue);
															break;

														}
													}
												}
											}
										} else {
											document
													.getElementById("rsvpDetails").innerHTML = "";
											var msgSpan = document
													.createTextNode("No records found.");
											document.getElementById(
													"rsvpDetails").appendChild(
													msgSpan);
										}

									},
									failure : function() {

									}
								}

							});
		} catch (err) {

		}

	}
</script>
