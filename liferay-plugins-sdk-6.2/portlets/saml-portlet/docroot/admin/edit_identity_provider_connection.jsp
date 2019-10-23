<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

SamlSpIdpConnection samlSpIdpConnection = null;
long clockSkew = 0;
String nameIdFormat = StringPool.BLANK;
//String userAttributeMappings = StringPool.BLANK;
String primaryKeyType = "nameid";
String primaryKeyAttribute = StringPool.BLANK;
Map<String, String> userAttributeMap = SamlUtil.getEmptyAttributesMap();

String samlIdpEntityId = MetadataManagerUtil.getDefaultIdpEntityId(companyId, groupId);

if (Validator.isNotNull(samlIdpEntityId)) {
	try {
		samlSpIdpConnection = SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(companyId, groupId);
		clockSkew = samlSpIdpConnection.getClockSkew();
		nameIdFormat = samlSpIdpConnection.getNameIdFormat();
//		userAttributeMappings = samlSpIdpConnection.getUserAttributeMappings();
		
		primaryKeyType = samlSpIdpConnection.getPrimaryKeyType();
		if ((primaryKeyType == null) || (primaryKeyType.trim().length() < 1))
			primaryKeyType = "nameid";
		
		primaryKeyAttribute = samlSpIdpConnection.getPrimaryKeyAttribute();
		userAttributeMap = samlSpIdpConnection.getUserAttributeMap();
	}
	catch (Exception e) {
	}
}

%>

<portlet:actionURL name="updateIdentityProviderConnection" var="updateIdentityProviderConnectionURL">
	<portlet:param name="tabs1" value="identity-provider-connection" />
</portlet:actionURL>

<aui:form action="<%= updateIdentityProviderConnectionURL %>" enctype="multipart/form-data">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input type="hidden" name="doAsGroupId" value="<%= groupId %>" />

	<liferay-ui:error exception="<%= DuplicateSamlSpIdpConnectionSamlIdpEntityIdException.class %>" message="please-enter-a-unique-identity-provider-entity-id" />
	<liferay-ui:error exception="<%= SamlSpIdpConnectionMetadataUrlException.class %>" message="please-enter-a-valid-metadata-endpoint-url" />
	<liferay-ui:error exception="<%= SamlSpIdpConnectionMetadataXmlException.class %>" message="please-enter-a-valid-metadata-xml" />
	<liferay-ui:error exception="<%= SamlSpIdpConnectionSamlIdpEntityIdException.class %>" message="please-enter-a-valid-identity-provider-entity-id" />

	<aui:model-context bean="<%= samlSpIdpConnection %>" model="<%= SamlSpIdpConnection.class %>" />

	<aui:input name="samlSpIdpConnectionId" type="hidden" />

	<aui:fieldset label="general">
		<aui:input name="name" required="true" />

		<aui:input 
			helpMessage="identity-provider-connection-entity-id-help" 
			label="identity-provider-connection" 
			name="samlIdpEntityId" 
			required="true"
		/>
		
		<aui:input 
			helpMessage="clock-skew-help" 
			name="clockSkew" 
			value="<%= String.valueOf(clockSkew) %>" 
		/>

		<aui:input 
			helpMessage="keep-alive-url-help" 
			label="keep-alive-url" 
			name="keepAliveUrl" 
		/>
	</aui:fieldset>

	<aui:fieldset helpMessage="identity-provider-metadata-help" label="metadata">
		<aui:input name="metadataUrl" />

		<aui:button-row>
			<aui:button onClick='<%= renderResponse.getNamespace() + "uploadMetadataXml();" %>' value="upload-metadata-xml" />
		</aui:button-row>

		<div class="aui-helper-hidden hide" id="<portlet:namespace />uploadMetadataXmlForm">
			<aui:fieldset label="upload-metadata">
				<aui:input name="metadataXml" type="file" />
			</aui:fieldset>
		</div>
	</aui:fieldset>

	<aui:fieldset label="name-identifier">
		<aui:select label="name-identifier-format" name="nameIdFormat" onChange='<%= renderResponse.getNamespace() + "toggleMatchingKey();" %>'>
			<aui:option label="email-address" selected="<%= nameIdFormat.equals(NameIDType.EMAIL) %>" value="<%= NameIDType.EMAIL %>" />
			<aui:option label="encrypted" selected="<%= nameIdFormat.equals(NameIDType.ENCRYPTED) %>" value="<%= NameIDType.ENCRYPTED %>" />
			<aui:option label="entity" selected="<%= nameIdFormat.equals(NameIDType.ENTITY) %>" value="<%= NameIDType.ENTITY %>" />
			<aui:option label="kerberos" selected="<%= nameIdFormat.equals(NameIDType.KERBEROS) %>" value="<%= NameIDType.KERBEROS %>" />
			<aui:option label="persistent" selected="<%= nameIdFormat.equals(NameIDType.PERSISTENT) %>" value="<%= NameIDType.PERSISTENT %>" />
			<aui:option label="trancient" selected="<%= nameIdFormat.equals(NameIDType.TRANSIENT) %>" value="<%= NameIDType.TRANSIENT %>" />
			<aui:option label="unspecified" selected="<%= nameIdFormat.equals(NameIDType.UNSPECIFIED) %>" value="<%= NameIDType.UNSPECIFIED %>" />
			<aui:option label="windows-domain-qualified-name" selected="<%= nameIdFormat.equals(NameIDType.WIN_DOMAIN_QUALIFIED) %>" value="<%= NameIDType.WIN_DOMAIN_QUALIFIED %>" />
			<aui:option label="x509-subject-name" selected="<%= nameIdFormat.equals(NameIDType.X509_SUBJECT) %>" value="<%= NameIDType.X509_SUBJECT %>" />
		</aui:select>

		<div id="match-type-selector" onChange='<%= renderResponse.getNamespace() + "toggleMatchingKey();" %>'>
			<aui:field-wrapper name="matchType">
				<aui:input 
					inlineLabel="right" 
					label="match-using-nameid" 
					name="matchType" 
					id="matchType" 
					type="radio" 
					value="nameid" 
					checked='<%= "nameid".equals(primaryKeyType) %>'
				/>
				<aui:input 
					inlineLabel="right" 
					label="match-using-attribute" 
					name="matchType" 
					id="matchType" 
					type="radio" 
					value="attribute" 
					checked='<%= "attribute".equals(primaryKeyType) %>' 
				/>
			</aui:field-wrapper>
		</div>
		
		<div id="matching-key">
			<aui:select label="matching-key-attribute" name="primaryKeyAttribute">
				<aui:option 
					label="email-address" 
					selected="<%= SamlUtil.PrimaryKeyAttributeType.EMAIL_ADDRESS.equals(primaryKeyAttribute) %>" 
					value="<%= SamlUtil.PrimaryKeyAttributeType.EMAIL_ADDRESS.getValue() %>" 
				/>
				<aui:option 
					label="screen-name" 
					selected="<%= SamlUtil.PrimaryKeyAttributeType.SCREEN_NAME.equals(primaryKeyAttribute) %>" 
					value="<%= SamlUtil.PrimaryKeyAttributeType.SCREEN_NAME.getValue() %>" 
				/>
				<aui:option 
					label="uuid" 
					selected="<%= SamlUtil.PrimaryKeyAttributeType.UUID.equals(primaryKeyAttribute) %>" 
					value="<%= SamlUtil.PrimaryKeyAttributeType.UUID.getValue() %>" 
				/>
			</aui:select>
		</div>
	</aui:fieldset>

	<aui:fieldset label="attributes">
		<%--<aui:input helpMessage="attribute-mapping-help" label="attribute-mapping" name="userAttributeMappings" value="<%= userAttributeMappings %>" /> --%>
		<table>
			<%
			for (Map.Entry<String, String> entry : userAttributeMap.entrySet()) {
			%>
				<tr>
					<td><%= entry.getKey() %>&nbsp;&nbsp;<td>
					<td>
						<aui:input 
							type="text"
							style="width: 200px;"
							label=""
							name='<%= "userAttributeMapping-" + entry.getKey() %>' 
							value="<%= entry.getValue() %>" 
						/>
					</td>
				</tr>
			<%
			}
			%>
		</table>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="save" />
	</aui:button-row>
</aui:form>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />uploadMetadataXml',
		function() {
			var A = AUI();
			
			var uploadMetadataXmlForm = A.one("#<portlet:namespace />uploadMetadataXmlForm");
			
			if (uploadMetadataXmlForm) {
				uploadMetadataXmlForm.show();
			}
		},
		['aui-base']
	);
	Liferay.provide(
		window,
		'<portlet:namespace />toggleMatchingKey',
		function() {
			var A = AUI();
			
			var matchTypeSelector = A.one("#match-type-selector");
			var matchingKey = A.one("#matching-key");

			var formatValue = A.one("#<portlet:namespace />nameIdFormat").get('value');
			
			if (formatValue && (formatValue == "<%= NameIDType.EMAIL %>")) {
				matchTypeSelector.show();
				var matchingType = A.all("#<portlet:namespace />matchType");
				
				A.each(
					matchingType,
					function(item, index, collection) {
						if ((item.get('value') == 'nameid') && item.get('checked')) {
							matchingKey.hide();
						}
						if ((item.get('value') == 'attribute') && item.get('checked')) {
							matchingKey.show();
						}
					}
				);
			}
			else {
				matchTypeSelector.hide();
				matchingKey.show();
			}
		},
		['aui-base']
	);
	AUI().ready(<portlet:namespace />toggleMatchingKey);
</aui:script>