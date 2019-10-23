<%@page import="com.sambaash.platform.model.SPGroupType"%>
<%@page import="com.sambaash.platform.srv.spgroup.SPGroupImageTypeException"%>
<%@page import="com.liferay.portal.kernel.upload.UploadException"%>
<%@page import="com.sambaash.platform.srv.spgroup.SPGroupTitleException"%>
<%@page import="com.sambaash.platform.srv.spgroup.SPGroupDescriptionException"%>
<%@page import="com.sambaash.platform.srv.spgroup.SPGroupImageSizeException"%>
<%@page import="com.sambaash.platform.srv.spgroup.SPGroupImageNameException"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="com.sambaash.platform.srv.spgroup.model.SPGroup" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<style type="text/css">

</style>

<c:choose>
<c:when test="${createServiceHasAccess}">

<%
String redirect = ParamUtil.getString(request, "redirect");

SPGroup spGroup = (SPGroup)request.getAttribute("SP_GROUP");

long spGroupId = ParamUtil.getLong(request, "spGroupId");
%>

<portlet:actionURL var="editSPGroupURL">
	<portlet:param name="action" value="edit_sp_group" />
</portlet:actionURL>

<%
if (spGroup != null) {
	%>

	<h2>Edit Group '<b><%= spGroup.getTitle() %>'</b></h2>

	<%
}else {
	%>

	<h2><%= LanguageUtil.get(pageContext,"label.create.group")%></h2>
	<c:set value="${true}" var="newGroup" />

	<%
}
%>

<br />

<c:choose>
	<c:when test="${newGroup || (!newGroup && allowToEdit)}">

		<aui:form action="<%= editSPGroupURL %>" enctype="multipart/form-data" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
			<aui:input name="spGroupId" type="hidden" value="<%= spGroupId %>" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
			<!-- <aui:input name="attachments" type="hidden" /> -->

			<liferay-ui:error exception="<%= SPGroupDescriptionException.class %>" message="please-enter-valid-content" />
			<liferay-ui:error exception="<%= SPGroupTitleException.class %>" message="please-enter-a-valid-title" />

			<liferay-ui:error exception="<%= UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />

			<liferay-ui:error exception="<%= SPGroupImageNameException.class %>" message = "invalid-image-name"/>

			<liferay-ui:error exception="<%= SPGroupImageSizeException.class %>">

				<%
				String spGroupImageMaxSizeStr = portletPreferences.getValue("spGroupImageMaxSize", "307200");
				long spGroupImageMaxSize = Long.valueOf(spGroupImageMaxSizeStr);
				%>

				<liferay-ui:message arguments="<%= spGroupImageMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= SPGroupImageTypeException.class %>" message="please-enter-a-file-with-a-valid-file-type" />

			<liferay-ui:asset-categories-error />
			<liferay-ui:asset-tags-error />

			<aui:model-context bean="<%= spGroup %>" model="<%= SPGroup.class %>" />

			<aui:fieldset>

				<aui:input checked="<%= (spGroup!= null && SPGroupType.PUBLIC.getValue() == spGroup.getType()) || spGroup == null %>" inlineField="true" label='<%= LanguageUtil.get(pageContext,"label.public")%>' name="type" type="radio" value="<%= SPGroupType.PUBLIC.getValue() %>" />
				<aui:input checked="<%= spGroup!= null && SPGroupType.MEMBERS_ONLY.getValue() == spGroup.getType() %>" inlineField="true" label='<%= LanguageUtil.get(pageContext,"label.private")%>' name="type" type="radio" value="<%= SPGroupType.MEMBERS_ONLY.getValue() %>" />
				<aui:input checked="<%= spGroup!= null && SPGroupType.ADMIN.getValue() == spGroup.getType() %>" inlineField="true" label='<%= LanguageUtil.get(pageContext,"label.admin")%>' name="type" type="radio" value="<%= SPGroupType.ADMIN.getValue() %>" />

				<label class="field-label" for="<portlet:namespace />fileName" ><liferay-ui:message key="label.image" /> <span class="sp-group-required">*</span></label>
				<aui:input label="" name="fileName" size="50" type="file"  />
				<div class="group-noteText control-group" style="margin-top:-30px">*Image Types : ${imageType}
				<br/>
				*Optimum Image size 250 X 250px. 
				<br/>
				*Subject in the image should be in center position for a better view on all devices
				</div>
				<label class="field-label" for="<portlet:namespace />title" ><liferay-ui:message key="label.title" /> <span class="sp-group-required">*</span></label>
				<aui:input cssClass="sp-group-box-sizing" label="" name="title" value='<%= renderRequest.getParameter("title") %>' maxlength="75"/>
				<div class="group-noteText control-group" style="margin-top:-35px">*Maximum of 75 characters</div>
				<label class="field-label" for="<portlet:namespace />description" ><liferay-ui:message key="label.description" /> <span class="sp-group-required">*</span></label>
				<aui:input cssClass="sp-group-box-sizing" label="" name="description" type="textarea" value='<%= renderRequest.getParameter("description") %>'/>
				<div class="group-noteText control-group" style="margin-top:-30px">*Maximum of 250 characters</div>
				<aui:input name="categories" type="assetCategories" />
				<aui:input name="tags" type="assetTags" />

				<aui:button-row>
					<aui:button name="saveButton" type="submit" value='<%= LanguageUtil.get(pageContext,"label.save") %>' />
					<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
				</aui:button-row>

			</aui:fieldset>

		</aui:form>

		<script type="text/javascript">

		AUI().ready('aui-form-validator', 'aui-io-request', function(A) {
			var validator = new A.FormValidator({
				boundingBox: '#<portlet:namespace />fm',
			       errorClass: 'form-validator-error',
				rules: {
					<portlet:namespace />title: {
						required: true,
						rangeLength: [1,150]
					},
					<portlet:namespace />description: {
						required: true,
						rangeLength: [1,255]
					}
				},
				fieldStrings: {
					<portlet:namespace />title: {
						required: 'Title is required',
						rangeLength: 'Title must be less than or equal to 150 characters'
					},
					<portlet:namespace />description: {
						required: 'Description is required',
						rangeLength: 'Description must be less than or equal to 255 characters'
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

			var validateEditSPGroupForm = function(event) {
				validator.validate();
				if (!validator.hasErrors()) {
					A.one("#<portlet:namespace />fm").submit();
				}
			}

			A.one("#<portlet:namespace />saveButton").on("click", validateEditSPGroupForm);

		});

		</script>

		<aui:script>

			function <portlet:namespace />getSuggestionsContent() {
				var content = '';

				content += document.<portlet:namespace />fm.<portlet:namespace />title.value + ' ';
				content += document.<portlet:namespace />fm.<portlet:namespace />description.value + ' ';

				return content;
			}

/* function <portlet:namespace />manageAttachments() {
				document.<portlet:namespace />fm.encoding = "multipart/form-data";
				document.<portlet:namespace />fm.<portlet:namespace />attachments.value = "true";
			} */

		</aui:script>

	</c:when>
	<c:otherwise>
		<div class="portlet-msg-alert">You don't have the permission to edit this group.</div>
	</c:otherwise>
</c:choose>

</c:when>
<c:otherwise>
	<div class="portlet-msg-alert"><c:out value="${createServiceUserStatus}"></c:out></div>
</c:otherwise>
</c:choose>