<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editCoParticipantsDetailURL">
	<portlet:param name="action" value="editCoParticipantsDetail"></portlet:param>
</portlet:actionURL>

<div style="background-color: #FFFFFF;">

	<c:choose>
		<c:when test="${isAdmin || isReport}">

			<c:choose>
				<c:when test="${fn:length(coParticipantsDetailList) > 0}">

					<h2>Edit details for co-participants.</h2>
					<br />
					<aui:form action="<%= editCoParticipantsDetailURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
						<input type="hidden" name="rsvpDetailId" value="${rsvpDetailId}" />
						<input type="hidden" name="rsvpPaymentId" value="${rsvpPaymentId}" />
						<input type="hidden" name="redirect" value="<%=themeDisplay.getURLCurrent() %>" />
						<c:forEach items="${coParticipantsDetailList}" var="coParticipantsDetail">
							<div style="margin-bottom: 15px; padding-bottom: 5px; border-bottom: 1px dotted rgb(204, 204, 204);">
								<div class="rsvp-label">
									<aui:input name="email_${coParticipantsDetail.rsvpCoParticipantDetailId}" label="Email" value="${coParticipantsDetail.emailAddress}" cssClass="rsvp-textbox" />
								</div>
								<div class="rsvp-label">
									<aui:input name="firstName_${coParticipantsDetail.rsvpCoParticipantDetailId}" label="First Name" value="${coParticipantsDetail.firstName}" cssClass="rsvp-textbox" />
								</div>
								<div class="rsvp-label">
									<aui:input name="lastName_${coParticipantsDetail.rsvpCoParticipantDetailId}" label="Last Name" value="${coParticipantsDetail.lastName}" cssClass="rsvp-textbox" />
								</div>
								<div class="rsvp-label">
									<aui:select name="identificationType_${coParticipantsDetail.rsvpCoParticipantDetailId}" label="Identification Type">
										<aui:option selected="${empty coParticipantsDetail.identificationType}" value=""></aui:option>
										<c:forEach items="${identificationTypeCategories}" var="identificationTypeCategory">
											<aui:option selected="${coParticipantsDetail.identificationType eq identificationTypeCategory.name}" label="${identificationTypeCategory.name}" value="${identificationTypeCategory.name}"></aui:option>
										</c:forEach>
									</aui:select>
								</div>
								<div class="rsvp-label">
									<aui:input name="identificationNumber_${coParticipantsDetail.rsvpCoParticipantDetailId}" label="Identification Number" value="${coParticipantsDetail.nric}" cssClass="rsvp-textbox" />
								</div>
							</div>
						</c:forEach>

						<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveChanges();" %>' type="submit" value="Save Chnages" />

					</aui:form>

					<aui:script>

						Liferay.provide(
							window,
							'<portlet:namespace />saveChanges',
							function() {
								var A = AUI();

								submitForm(document.<portlet:namespace />fm);
							}
						);

					</aui:script>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>

		</c:when>
		<c:otherwise>
			<div>You don't have required role to access this page</div>
		</c:otherwise>
	</c:choose>

</div>
