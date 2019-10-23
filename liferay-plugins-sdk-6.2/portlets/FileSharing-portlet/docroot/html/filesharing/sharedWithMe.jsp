<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<div id="errorMsgBox" style="font-color:red"><c:if test="${not empty error }">${error}</c:if></div>
<c:if test="${empty error }">
<portlet:resourceURL var="uploadFileResourceURL">
	<portlet:param name="action" value="uploadFile" />
</portlet:resourceURL>

<portlet:resourceURL var="removeFileResourceURL">
	<portlet:param name="action" value="removeFile" />
</portlet:resourceURL>

<portlet:resourceURL var="getFolderContentsURL">
</portlet:resourceURL>

<div id="outer" class="left-listItemsec">
<div id = "treeContainer">
</div>
</div>

<c:if test="${not empty sharedFolderId }">
<div class="hide sp_dragdrop_wrap boxPadding" id="<portlet:namespace />html5-uploader">
	<div class="sp_dragdrop" id="hide-content">
		<div id="select-zone">
			<label for="input-file">Upload your files to: <a href="javascript:" id="folderLabel"></a></label>
			<input id="input-file" style="width: 10px;" type="file" multiple
				onchange="handleFiles(this.files, '<%= uploadFileResourceURL %>', '<%= removeFileResourceURL %>', '<portlet:namespace />', 3080041824, 550, 450, 'image/jpeg,image/gif,image/png,image/x-ms-bmp,video/avi,video/mp4,video/mpeg,video/quicktime,video/x-ms-wmv,video/x-msvideo,video/ogg,video/webm,video/x-m4v,application/pdf,application/msword,application/vnd.openxmlformats-officedocument')" />
		</div>
		<ul id="asset-create-list">
		</ul>
		<div class="sp-mbl">
			<liferay-ui:icon-help
				message='You can select multiple files and drop them in this section' />
		</div>
	</div>
</div>
</c:if>
<script src="/FileSharing-portlet/js/main.js" type="text/javascript"></script>
<script>
var folderObj = {};
folderObj.currentFolderId = '${sharedFolderId}';
folderObj.currentName = '';
folderObj.currentType = '';
var fIds = [ ${folderIds} ];
var portletNs = "<portlet:namespace/>";
var ajaxUrl = "<%= getFolderContentsURL %>";
buildTree(ajaxUrl);
function getCurrentFolderId() {
	return folderObj.currentFolderId;
}
</script>
<c:if test="${not empty sharedFolderId }">
<aui:script use="liferay-upload">

			var uploadFileResourceURL = '<%= uploadFileResourceURL %>';
			var removeFileResourceURL = '<%= removeFileResourceURL %>';
			var browserIsSupported = !!window.FileReader && Modernizr.draganddrop;
			var html5Uploader = A.one('#<portlet:namespace />html5-uploader');

			var fileSizeMax = 3080041824;
			var imageWidthMin = 440;
			var imageHeightMin = 450;
			var allowedTypes = 'image/jpeg,image/gif,image/png,image/x-ms-bmp,video/avi,video/mp4,video/mpeg,video/quicktime,video/x-ms-wmv,video/x-msvideo,video/ogg,video/webm,video/x-m4v,application/pdf,application/msword,application/vnd.openxmlformats-officedocument';

			if (browserIsSupported) {
				html5Uploader.show();

				var dnd = {
				    init: function() {
				      //  var multiUpload = new DndUpload(document.querySelector('#input-file'), uploadFileResourceURL, removeFileResourceURL, '<portlet:namespace />', fileSizeMax, imageWidthMin, imageHeightMin,folderObj);
				    }
				};
				A.on("domready",function(){
				        var multiUpload = new DndUpload(document.querySelector('#input-file'), uploadFileResourceURL, removeFileResourceURL, '<portlet:namespace />', fileSizeMax, imageWidthMin, imageHeightMin,folderObj);
					
				});
/*				window.addEventListener('load', function() {
			        var multiUpload = new DndUpload(document.querySelector('#input-file'), uploadFileResourceURL, removeFileResourceURL, '<portlet:namespace />', fileSizeMax, imageWidthMin, imageHeightMin,folderObj);
			    }, false); */
			} else {
				conole.log('Browser not supported');
			}


</aui:script>
</c:if>
</c:if>