<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="java.util.*" %>

<%@ page
	import="com.sambaash.platform.srv.mail.SPMailCampaignSubscribersEmailException" %>
<%@ page
	import="com.sambaash.platform.srv.mail.SPMailCampaignSubscribersFirstNameException" %>
<%@ page
	import="com.sambaash.platform.srv.mail.SPMailCampaignSubscribersLastNameException" %>

<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<style>
.sp-newsletter-container {
	width: 250px;
	margin: 0 auto;
}

.sp-newsletter-container .form-validator-error-container .field-element
	{
	background-position: 100% 80%;
}

.sp-newsletter-container .sp-box-sizing input[type="text"],.sp-newsletter-container .sp-box-sizing textarea
	{
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	width: 100%;
	display: block;
}

.sp-newsletter-container .sp-box-sizing textarea {
	height: 75px;
}

.sp-newsletter-container .sp-full-width {
	width: 100%;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.sp-newsletter-container .sp-required {
	color: #C43B1D;
	display: none;
}
</style>

<portlet:actionURL var="addURL">
	<portlet:param name="action" value="add" />
</portlet:actionURL>

<div class="sp-newsletter-container">
	<c:choose>
		<c:when test="${not empty errorMsg}">
			<div class="portlet-msg-info">${errorMsg}</div>
		</c:when>
		<c:when test="${success eq 'true'}">
			<div class="portlet-msg-success">Thank you for subscribing.</div>
		</c:when>
		<c:otherwise>
			<aui:form action="<%= addURL %>" method="post" name="fm"
				onSubmit='<%= "event.preventDefault();" %>'>
				<aui:input name="redirect" type="hidden" value="" />

				<c:if test="${!emailOnly}">
					<liferay-ui:error
						exception="<%= SPMailCampaignSubscribersFirstNameException.class %>"
						message="please-enter-a-valid-first-name" />
					<liferay-ui:error
						exception="<%= SPMailCampaignSubscribersLastNameException.class %>"
						message="please-enter-a-valid-last-name" />
				</c:if>

				<c:if
					test="<%= SessionErrors
									.contains(
											renderRequest,
											SPMailCampaignSubscribersEmailException.class
													.getName()) %>">

					<%
						SPMailCampaignSubscribersEmailException nee = (SPMailCampaignSubscribersEmailException) SessionErrors
												.get(renderRequest,
														SPMailCampaignSubscribersEmailException.class
																.getName());
					%>

					<div class="portlet-msg-error">
						<c:if test='<%= nee.getMessage() == \"1\" %>'>
							<c:out value="Please enter valid email." />
						</c:if>
						<c:if test='<%= nee.getMessage() == \"2\" %>'>
							<c:out value="Email address is already subscribed." />
						</c:if>
					</div>
				</c:if>

				<aui:fieldset>
					<c:if test="${!emailOnly}">
						<label for="<portlet:namespace />firstName"
							class="field-label" style="margin-bottom: -6px;">First
							Name <span class="sp-required">*</span>
						</label>
						<aui:input label="" name="firstName" cssClass="sp-box-sizing"
							value="" />
						<label for="<portlet:namespace />lastName" class="field-label"
							style="margin-bottom: -6px;">Last Name <span
							class="sp-required">*</span></label>
						<aui:input label="" name="lastName" cssClass="sp-box-sizing"
							value="" />
					</c:if>
					<label for="<portlet:namespace />email" class="field-label"
						style="margin-bottom: -6px;">Email <span
						class="sp-required">*</span></label>
					<aui:input cssClass="sp-box-sizing" label="" name="email" value="" />
					<aui:button-row>
						<aui:button name="saveButton" type="submit" value="Save" />
					</aui:button-row>
				</aui:fieldset>
			</aui:form>
		</c:otherwise>
	</c:choose>
</div>

<c:choose>
	<c:when test="${emailOnly}">

		<script type="text/javascript">

			AUI().ready('aui-form-validator', 'aui-io-request', function(A) {
				var validator = new A.FormValidator({
					boundingBox: '#<portlet:namespace />fm',
				       errorClass: 'form-validator-error',
					rules: {
						<portlet:namespace />email: {
							required: true,
							email: true,
							rangeLength: [1,75]
						}
					},
					fieldStrings: {
						<portlet:namespace />email: {
							required: 'Email is required',
							email: 'Email is invalid',
							rangeLength: 'Email must be less than or equal to 75 characters'
						}
					},
					on: {
						blur: function(event) {
							var validator = event.validator;
							var field = validator.field;
						},
						validateField: function(event) {
							var validator = event.validator;
							var field = validator.field;
						},
						errorField: function(event) {
							var instance = this;
							var validator = event.validator;
							var field = validator.field;

							instance.highlight(field);
							if (instance.get('showMessages')) {
								var stackContainer = instance.getFieldStackErrorContainer(field);

								field.placeBefore(stackContainer);

								instance.printStackError(
									field,
									stackContainer,
									validator.errors
								);
								stackContainer.one("div").removeClass("form-validator-message");
							}
							event.halt();
						}
					}
				});

				var validateAddForm = function(event) {
					validator.validate();
					if (!validator.hasErrors()) {
						A.one("#<portlet:namespace />fm").submit();
					}
				}

				A.one("#<portlet:namespace />saveButton").on("click", validateAddForm);

			});

		</script>

	</c:when>
	<c:otherwise>

		<script type="text/javascript">

			AUI().ready('aui-form-validator', 'aui-io-request', function(A) {
				var validator = new A.FormValidator({
					boundingBox: '#<portlet:namespace />fm',
				       errorClass: 'form-validator-error',
					rules: {
						<portlet:namespace />firstName: {
							required: true,
							rangeLength: [1,75]
						},
						<portlet:namespace />lastName: {
							required: true,
							rangeLength: [1,75]
						},
						<portlet:namespace />email: {
							required: true,
							email: true,
							rangeLength: [1,75]
						}
					},
					fieldStrings: {
						<portlet:namespace />firstName: {
							required: 'First name is required',
							rangeLength: 'First name must be less than or equal to 75 characters'
						},
						<portlet:namespace />lastName: {
							required: 'Last name is required',
							rangeLength: 'Last name must be less than or equal to 75 characters'
						},
						<portlet:namespace />email: {
							required: 'Email is required',
							email: 'Email is invalid',
							rangeLength: 'Email must be less than or equal to 75 characters'
						}
					},
					on: {
						blur: function(event) {
							var validator = event.validator;
							var field = validator.field;
						},
						validateField: function(event) {
							var validator = event.validator;
							var field = validator.field;
						},
						errorField: function(event) {
							var instance = this;
							var validator = event.validator;
							var field = validator.field;

							instance.highlight(field);
							if (instance.get('showMessages')) {
								var stackContainer = instance.getFieldStackErrorContainer(field);

								field.placeBefore(stackContainer);

								instance.printStackError(
									field,
									stackContainer,
									validator.errors
								);
								stackContainer.one("div").removeClass("form-validator-message");
							}
							event.halt();
						}
					}
				});

				var validateAddForm = function(event) {
					validator.validate();
					if (!validator.hasErrors()) {
						A.one("#<portlet:namespace />fm").submit();
					}
				}

				A.one("#<portlet:namespace />saveButton").on("click", validateAddForm);

			});

		</script>

	</c:otherwise>
</c:choose>