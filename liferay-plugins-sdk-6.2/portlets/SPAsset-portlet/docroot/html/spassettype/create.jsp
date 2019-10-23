
<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="addAssetTypeActionURL" windowState="normal"
	name="addAssetType" />

<aui:form action='<%=addAssetTypeActionURL%>'
	name='<portlet:namespace />fm' method="post">
	<div class="custom_asset_create">
		<div class="control-group">
			<label class="control-label" for="spAssetTypeName">SP Asset
				Type Name:</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>spAssetTypeName"
					id="<portlet:namespace/>spAssetTypeName"
					value="${assetType.spAssetTypeName}" /> <input type="hidden"
					name="<portlet:namespace/>spAssetTypeId"
					id="<portlet:namespace/>spAssetTypeId"
					value="${assetType.spAssetTypeId}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="allowedFileTypes">Allowed
				File Type:</label>
			<div class="controls">
				<select name="<portlet:namespace/>allowedFileTypes"
					id="<portlet:namespace/>allowedFileTypes" multiple="multiple">
					<c:set var="allTypes" value="${assetType.allowedFileTypes}"></c:set>
					<c:set var="allAvailableTypes"
						value="jpg,png,gif,jpeg,avi,m4v,mov,mp4,mpg,ogv,qt,rm,wmv,mkv,doc,pdf,docx,xlsx,xls,ppt,pptx"></c:set>
					<c:forTokens items="${allAvailableTypes}" delims=","
						var="allAvailableType">
						<c:set var="isFound" value="false"></c:set>
						<c:forTokens items="${allTypes}" delims="," var="allType">
							<c:choose>
								<c:when test="${allType == allAvailableType}">
									<c:set var="isFound" value="true"></c:set>
								</c:when>
							</c:choose>
						</c:forTokens>
						<c:choose>
							<c:when test="${isFound == 'true'}">
								<option value="${allAvailableType}" selected="selected">${allAvailableType}</option>
							</c:when>
							<c:otherwise>
								<option value="${allAvailableType}">${allAvailableType}</option>
							</c:otherwise>
						</c:choose>
					</c:forTokens>

				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="maxFileSize">Max File Size:</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>maxFileSize"
					id="<portlet:namespace/>maxFileSize"
					value="${assetType.maxFileSize}" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="minImageHeight">Minimum
				Image Height:</label>
			<div class="controls">
				<input type="text" value="${assetType.minImageHeight}"
					name="<portlet:namespace/>minImageHeight"
					id="<portlet:namespace/>minImageHeight" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="minImageWidth">Minimum
				Image Width:</label>
			<div class="controls">
				<input type="text" value="${assetType.minImageWidth}"
					name="<portlet:namespace/>minImageWidth"
					id="<portlet:namespace/>minImageWidth" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="notifyUponCreation">Notify
				Upon Creation:</label>
			<div class="controls">

				<c:choose>
					<c:when test="${assetType.notifyUponCreation == true}">
						<td><input type="checkbox"
							name="<portlet:namespace/>notifyUponCreation"
							id="<portlet:namespace/>notifyUponCreation" checked="checked" /></td>
					</c:when>
					<c:otherwise>
						<td><input type="checkbox" value="true"
							name="<portlet:namespace/>notifyUponCreation"
							id="<portlet:namespace/>notifyUponCreation" /></td>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="minImageWidth">Notification
				Template Id:</label>
			<div class="controls">
				<select name="<portlet:namespace/>notificationTemplateId"
					id="<portlet:namespace/>notificationTemplateId">

					<c:choose>
						<c:when test="${assetType.notificationTemplateId != ''}">
							<option value="12345678910"
								${assetType.notificationTemplateId == '12345678910' ? 'selected' : ''}>
								Value 1</option>
							<option value="22345678910"
								${assetType.notificationTemplateId == '22345678910' ? 'selected' : ''}>
								Value 2</option>
							<option value="33345678910"
								${assetType.notificationTemplateId == '33345678910' ? 'selected' : ''}>
								Value 3</option>
						</c:when>
					</c:choose>
				</select>
			</div>
		</div>
		<div class="main">
			<div class="row leftzero">
				<div class="col-md-12">
					<div class="col-md-3">
						Asset Type CreateURL <br> <input type="text"
							value="${assetType.spAssetTypeCreateUrl}"
							name="<portlet:namespace/>spAssetTypeCreateUrl"
							id="<portlet:namespace/>spAssetTypeCreateUrl" />
					</div>
					<div class="col-md-3">
						Asset Type DetailURL <br> <input type="text"
							value="${assetType.spAssetTypeDetailUrl}"
							name="<portlet:namespace/>spAssetTypeDetailUrl"
							id="<portlet:namespace/>spAssetTypeDetailUrl" />
					</div>
					<div class="col-md-3">
						Asset Type InnerURL <br> <input type="text"
							value="${assetType.spAssetTypeInnerDetailUrl}"
							name="<portlet:namespace/>spAssetTypeInnerDetailUrl"
							id="<portlet:namespace/>spAssetTypeInnerDetailUrl" />
					</div>

				</div>
			</div>
		</div>
		<div class="col-md-3">
			<c:choose>
				<c:when test="${assetType.requiredLogin == true}">
					<td><input type="checkbox"
						name="<portlet:namespace/>requiredLogin"
						id="<portlet:namespace/>requiredLogin" checked="checked" /></td>
				</c:when>
				<c:otherwise>
					<td><input type="checkbox" value="true"
						name="<portlet:namespace/>requiredLogin"
						id="<portlet:namespace/>requiredLogin" /></td>
				</c:otherwise>
			</c:choose>
			Requred Login <br>
		</div>
		<br>
		<aui:button type="submit" value="save" onClick="submitForm();" />

	</div>
</aui:form>
