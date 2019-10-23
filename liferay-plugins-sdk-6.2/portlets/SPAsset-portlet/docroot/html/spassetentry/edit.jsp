
<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="saveAssetPreferenceActionURL"
	windowState="normal" name="saveAssetPreference" />
<aui:form action='<%=saveAssetPreferenceActionURL%>'
	name='<portlet:namespace />fm' method="post">
	<div class="control-group">
		<label class="control-label" for="spAssetTypeName">SPAssetType:</label>
		<div class="controls">
			<c:set value="${aType}" var="astType" />
			<select name="<portlet:namespace/>spAssetTypeName"
				id="<portlet:namespace/>spAssetTypeName" style="width:auto">

				<c:forEach var="assetType" items="${assetList}">
					<option value="${assetType.spAssetTypeId}"
						${assetType.spAssetTypeId == astType ? 'selected' : ''}>
						${assetType.spAssetTypeName}</option>
				</c:forEach>

			</select>
			
		</div>
		<div class="controls">
		<label class="control-label" for="Style">Select Gallery List Style:</label>
			<c:set value="${styleType}" var="selStyle" />
			<select name="<portlet:namespace/>Style"
				id="<portlet:namespace/>Style" style="width:auto">

					<option value="style1" ${selStyle == 'style1' ? 'selected' : ''}>
						Style1(linear)</option>
						<option value="style2" ${selStyle == 'style2' ? 'selected' : ''}>
						Style2(non-linear)</option>

			</select>
		</div>
		<div class="controls">
			<input type="checkbox" id="editIconsAlignment" name="editIconsAlignment" ${isEditIconOnTop} />Place Edit Icons on top of Image
		</div>
		<div class="controls">
			<label class="control-label" for="spAssetTypeName">Detail Page Name</label>
			<input type="text" id="detailPageName" name="detailPageName" value="${detailPageName }"/>
		</div>
		<div class="controls">
			<input type="checkbox" id="voting" name="voting" ${isVoting} />Enable Voting
		</div>
		<aui:button type="submit" value='<%=LanguageUtil.get(pageContext,"label.save") %>' onClick="submitForm();" />
	</div>
</aui:form>
