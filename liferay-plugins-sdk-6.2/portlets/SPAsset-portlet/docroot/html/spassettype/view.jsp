

<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="createAssestURL">
	<portlet:param name="mvcPath" value="/html/spassettype/create.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="editAssestURL">
	<portlet:param name="mvcPath" value="/html/spassettype/create.jsp"></portlet:param>
</portlet:renderURL>

<form id="myForm">
<div class="table_scroll">
	<table class="table table-condensed table-hover">
		<thead>
			<tr>
				<th><liferay-ui:message key="label.spassettype.name" /></th>
				<th><liferay-ui:message key="label.allowed.filetype" /></th>
				<th><liferay-ui:message key="label.max.file.size" /></th>
				<th><liferay-ui:message key="label.minumum.image.height" /></th>
				<th><liferay-ui:message key="label.minumum.image.width" /></th>
				<th><liferay-ui:message key="label.notify.upon.creation" /></th>
				<th><liferay-ui:message key="label.notification.template" /></th>
				<th><liferay-ui:message key="label.assettype.create.url" /></th>
				<th><liferay-ui:message key="label.assettype.detail.url" /></th>
				<th><liferay-ui:message key="label.assetype.inner.detail.url" /></th>
				<th><liferay-ui:message key="label.required.login" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="assetType" items="${assetTypeList}">
				<tr>
					<td>${assetType.spAssetTypeName}</td>
					<td><c:out value="${assetType.allowedFileTypes}"></c:out></td>
					<td>${assetType.maxFileSize}</td>
					<td>${assetType.minImageHeight}</td>
					<td>${assetType.minImageWidth}</td>
					<c:choose>
						<c:when test="${assetType.notifyUponCreation == true}">
							<td><input type="checkbox"
								name="<portlet:namespace/>notifyUponCreation"
								id="<portlet:namespace/>notifyUponCreation" checked="checked" /></td>
						</c:when>
						<c:otherwise>
							<td><input type="checkbox"
								name="<portlet:namespace/>notifyUponCreation"
								id="<portlet:namespace/>notifyUponCreation" /></td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when
							test="${assetType.notificationTemplateId == '12345678910'}">
							<td>Value 1</td>
						</c:when>
						<c:when
							test="${assetType.notificationTemplateId == '22345678910'}">
							<td>Value 2</td>
						</c:when>
						<c:otherwise>
							<td>Value 3</td>
						</c:otherwise>
					</c:choose>

					<td>${assetType.spAssetTypeCreateUrl}</td>
					<td>${assetType.spAssetTypeDetailUrl}</td>
					<td>${assetType.spAssetTypeInnerDetailUrl}</td>

					<c:choose>
						<c:when test="${assetType.requiredLogin == true}">
							<td><input type="checkbox"
								name="<portlet:namespace/>requiredLogin"
								id="<portlet:namespace/>requiredLogin" checked="checked" /></td>
						</c:when>
						<c:otherwise>
							<td><input type="checkbox"
								name="<portlet:namespace/>requiredLogin"
								id="<portlet:namespace/>requiredLogin" /></td>
						</c:otherwise>
					</c:choose>

					<td><aui:button class="btn btn-info"
							onClick="${editAssestURL}&spAssetTypeId=${assetType.spAssetTypeId}"
							value="label.edit.button" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<aui:button class="btn btn-info" onClick="<%= createAssestURL %>"
		value="label.add.button" />




</form>