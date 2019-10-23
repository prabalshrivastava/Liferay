<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactory"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sambaash.platform.srv.spasset.model.SPAssetEntry"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ include file="/html/init.jsp"%>

<%@page import="com.sambaash.platform.util.ThumbnailUtil"%>

<portlet:actionURL var="saveAssetEntryActionURL" windowState="normal" name="saveAssetEntry" />

<liferay-portlet:resourceURL id="uploadFile" var="uploadResourceURL"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="saveTitle" var="titleSaveResourceURL"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="removeFile" var="removeResourceURL"></liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="resourceUrl" var="resourceUrl"></liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="deleteFileUrl" var="deleteFileUrl">
 	<portlet:param name="action" value="delete"/>
</liferay-portlet:resourceURL>

<liferay-portlet:resourceURL id="uploadFileUrl" var="uploadFileUrl">
 	<portlet:param name="action" value="uploadFile"/>
</liferay-portlet:resourceURL>

<aui:form name='fm' method="post" action="<%= saveAssetEntryActionURL %>" id='fm'>
	
<aui:model-context bean='<%=request.getAttribute("assetEntry")%>' model="<%= SPAssetEntry.class %>" />

	<div class="control-group">
		<div class="controls">
				<aui:input type="text" name="title"  size="100" label='label.title'>
						  <aui:validator name="required" errorMessage='msg.title.required'></aui:validator>
						  <aui:validator name="rangeLength">[0,75]</aui:validator>
				</aui:input>
		</div>
	</div>
	<input type="hidden" name="<portlet:namespace/>spAssetEntryId"
				id="<portlet:namespace/>spAssetEntryId" value="${assetEntry.spAssetEntryId}"  />

    <%
    	String actionParam = "add";
    	if(request.getAttribute("assetEntry") != null){
    		actionParam = "update";
    	}
    	pageContext.setAttribute("actionParam", actionParam);
    %>
	<input type="hidden" name="<portlet:namespace/>actionParam"
				id="<portlet:namespace/>actionParam" value="${actionParam}"  />
				
	<div id="entryDetailsId">
	<div class="control-group">
		<label class="control-label" for="description strong"><%=LanguageUtil.get(pageContext,"label.description") %></label>
		<div class="controls">
			<textarea name="<portlet:namespace/>description"
				id="<portlet:namespace/>description">${assetEntry.description}</textarea> 
		</div>
	</div>
	
	<div class="control-group">
		<div class="controls strong">
			<aui:input name="tags" type="assetTags" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label strong" for="categories"><%=LanguageUtil.get(pageContext,"label.categories") %></label>
		<div class="controls">
			<aui:input name="categories" type="assetCategories" />
		</div>
	</div>
	<c:if test="${actionParam == 'add' }">
		<div class="control-group">
			<div class="controls strong">
			
				<aui:field-wrapper label='<%=LanguageUtil.get(pageContext,"label.embed") %>'>
					<liferay-ui:input-permissions modelName="<%= SPAssetEntry.class.getName() %>" />
				</aui:field-wrapper>
			</div>
		</div>
	</c:if>
	
	<div class="centerall ascolumn">
		<div class="lfr-dynamic-uploader">
						<div class="lfr-upload-container" id="<portlet:namespace />fileUpload"></div>
		</div>
	</div>
	
	<div>
		<div class="" id="existingFile-list">
			<ul class="unstyled multiple-files" id="_SPAssetEntry_WAR_SPAssetportlet_fileListContent">
				<c:forEach var="fileEntries" items="${fileEntries }">
					<c:set var="fileEntry" value="${fileEntries }" />
					<%
					FileEntry fileEntry = (FileEntry) pageContext.getAttribute("fileEntry");
					String fileName = "";
					long fileId = 0;
						if (fileEntry != null) {
							fileName = fileEntry.getTitle();
							fileId = fileEntry.getFileEntryId();
									}
					%>
					
					<li class="existingFile-list" data-filename="<%=fileName %>" data-title="<%=fileName %>">
						<span class="file-title" title="<%=fileName %>"><%=fileName %></span>
						<a class="lfr-button delete-button" href="javascript:deleteExistingFile(<%=fileId%>)" id="fileEntry_<%=fileId%>">Delete File</a>
					</li>
				</c:forEach>
			</ul>
		</div>	
	</div>
	
	<div class="control-group">
		<label class="control-label strong" for="embed"><%=LanguageUtil.get(pageContext,"label.embed") %> </label>
		<div class="controls">
			<input type="text" name="<portlet:namespace/>embed"
				id="<portlet:namespace/>embed" value="" />
		</div>
	</div>
	<aui:button type="button" value='<%=LanguageUtil.get(pageContext,"label.confirm") %>' id="confirmButton"  />
	</div>

	<input type="hidden" id="randId" value="1">
	<input type="hidden" id="dlFolderId" name="dlFolderId" value="0">
	<input type="hidden" id="coverFileEntryId" name="coverFileEntryId" value="0">
	<input type="hidden" id="removedFileEntriesId" name="removedFileEntriesId" value="0">
	

</aui:form>

<%--  <script src="<%=request.getContextPath()%>/js/script.js"></script> --%>

<script src="<%=request.getContextPath()%>/js/createAssetEntry.js"></script>
<script src="/html/js/liferay/upload.js"></script>
<script>

function deleteExistingFile(id){
	var clickElem = document.getElementById('fileEntry_'+id);
	var coverFileEntryId = document.getElementById("coverFileEntryId");
	var coverFileEntryIdValue = coverFileEntryId.value;
	var removedFileEntriesList = document.getElementById("removedFileEntriesId");
	if(coverFileEntryIdValue == id){
		coverFileEntryId.value = "0";
	}
	removedFileEntriesList.value += "," + id;
	var parentElem = clickElem.parentNode.parentNode.removeChild(clickElem.parentNode);
}

var A;
AUI().use('aui-node','aui-io-request', 'liferay-upload',function(A1){
	A = A1;
	var settings ={
			pns : "<portlet:namespace />",
			ajaxUrl : "<%= resourceUrl%>"
	};
	var uploadConfig =		{
				boundingBox: '#<portlet:namespace />fileUpload',
				deleteFile: '<%= deleteFileUrl %>',
				fileDescription: '',
				maxFileSize: '<%= PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE) %> B',
				namespace: '<portlet:namespace />',
				uploadFile: '<%=uploadFileUrl%>'
			};
	settings.uploadConfig = uploadConfig;
	var assetEntry = new createSPAssetEntry(settings);
});
</script>

