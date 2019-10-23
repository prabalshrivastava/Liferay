<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.sambaash.platform.srv.spjob.model.SPJobApplicants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String spJobDetailPageName = portletPreferences.getValue("spJobDetailPageName", "job-detail");
%>
<c:choose>
<c:when test="<%= !themeDisplay.isSignedIn() %>">
	<div class="portlet-msg-error">Please Log in before attempting this operation.</div>
</c:when>
<c:when test="${step eq 'success'}">
	<div class="portlet-msg-success">Your application has been sent for consideration.</div>
</c:when>
<c:when test="${empty spJob}">
	<div class="portlet-msg-error">This job posting is closed or not available.</div>
</c:when>
<c:when test="${themeDisplay.userId == spJob.userId}">
	<div class="portlet-msg-error">The member who posted the job can't apply for it.</div>
</c:when>
<c:when test="${applyServiceHasAccess}">
	<portlet:actionURL var="applySPJobURL">
		<portlet:param name="action" value="applySPJob" />
	</portlet:actionURL>

	<h2><liferay-ui:message key="${communityName}.label.apply.apply.job" /> '<a href="/<%= spJobDetailPageName %>?id=${spJob.spJobId}"><b>${spJob.jobTitle}</b></a>'</h2>
	<br />

	<aui:form action="<%= applySPJobURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
		<aui:input name="jobId" type="hidden" value="${spJob.spJobId}" />
		<aui:input name="jobTitle" type="hidden" value="${spJob.jobTitle}" />
		<aui:input name="attachments" type="hidden" value="false" />

		<aui:model-context bean="<%= null %>" model="<%= SPJobApplicants.class %>" />

		<aui:fieldset>

			<label class="field-label" for="<portlet:namespace />firstName"><liferay-ui:message key="${communityName}.label.apply.first.name" /></label>
			<aui:input cssClass="spjob-box-sizing" label="" name="firstName" value="<%= themeDisplay.getUser().getFirstName() %>" />

			<label class="field-label" for="<portlet:namespace />lastName"><liferay-ui:message key="${communityName}.label.apply.last.name" />*</label>
			<aui:input cssClass="spjob-box-sizing" label="" name="lastName" value="<%= themeDisplay.getUser().getLastName() %>" />

			<label class="field-label" for="<portlet:namespace />emailAddress"><liferay-ui:message key="${communityName}.label.apply.email.address" />*</label>
			<aui:input cssClass="spjob-box-sizing" label="" name="emailAddress" value="<%= themeDisplay.getUser().getEmailAddress() %>" />

			<label class="field-label" for="<portlet:namespace />contactNumber"><liferay-ui:message key="${communityName}.label.apply.contact.number" /></label>
			<aui:input cssClass="spjob-box-sizing" label="" name="contactNumber" value="" />

			<label class="field-label" for="<portlet:namespace />coverLetter"><liferay-ui:message key="${communityName}.label.apply.cover.letter" /></label>
			<aui:field-wrapper label="">
				<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" height="120" initMethod='<%= "initEditor" %>' toolbarSet="editInPlaceWithLink" />
				<aui:input name="coverLetter" type="hidden" />
			</aui:field-wrapper>

			<label class="field-label" for="<portlet:namespace />fileName"><liferay-ui:message key="${communityName}.label.apply.upload.resume" /></label>
			<aui:input label="" name="fileName" onChange='<%= renderResponse.getNamespace() + "manageAttachments();" %>' size="50" type="file" cssClass="uploadBtn"/>
			<p>File size limit: 5MB</p>
			<p>Accepted formats: .doc, .docx, .pdf, .rtf, .txt</p>

			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="Save" />
				<aui:button href="/${spJobDetailPageName}?id=${spJob.spJobId}" name="cancelButton" type="cancel" />
			</aui:button-row>

		</aui:fieldset>

	</aui:form>

	<script type="text/javascript">

	AUI().ready('aui-form-validator', 'aui-io-request', function(A) {
		var validator = new A.FormValidator({
			boundingBox: '#<portlet:namespace />fm',
		       errorClass: 'form-validator-error',
			rules: {
				<portlet:namespace />firstName: {
					required: true,
					rangeLength: [1,100]
				},
				<portlet:namespace />lastName: {
					required: true,
					rangeLength: [1,100]
				},
				<portlet:namespace />emailAddress: {
					required: true,
					email: true,
					rangeLength: [1,75]
				}
			},
			fieldStrings: {
				<portlet:namespace />firstName: {
					required: 'First name is required',
					rangeLength: 'First name must be less than or equal to 100 characters'
				},
				<portlet:namespace />lastName: {
					required: 'Last name is required',
					rangeLength: 'Last name must be less than or equal to 100 characters'
				},
				<portlet:namespace />emailAddress: {
					required: 'Email address is required',
					email: 'Invalid email address',
					rangeLength: 'Email address must be less than or equal to 75 characters'
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

		var validateApplySPJobForm = function(event) {
			if (window.<portlet:namespace />editor) {
				document.<portlet:namespace />fm.<portlet:namespace />coverLetter.value = window.<portlet:namespace />editor.getHTML();
			}
			validator.validate();
			if (!validator.hasErrors()) {
				A.one("#<portlet:namespace />fm").submit();
			}
		}

		A.one("#<portlet:namespace />saveButton").on("click", validateApplySPJobForm);

	});

	</script>

	<aui:script>

		function <portlet:namespace />manageAttachments() {
			document.<portlet:namespace />fm.encoding = "multipart/form-data";
			document.<portlet:namespace />fm.<portlet:namespace />attachments.value = "true";
		}

		function <portlet:namespace />initEditor() {
			return "";
		}

	</aui:script>
</c:when>
<c:otherwise>
	<div class="portlet-msg-error">You don't have access to this page.</div>
</c:otherwise>
</c:choose>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.liferay-plugins-sdk-6.1.0.portlets.SPJob-portlet.docroot.view.apply.view.jsp";
%>
