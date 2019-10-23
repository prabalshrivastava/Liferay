<%@page import="com.liferay.portal.model.UserConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<c:choose>
	<c:when test="${isSignedIn}">
	
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/yuiloader-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/event-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/dom-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/element-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/dragdrop-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/resize-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/imagecropper-min.js"></script>
	<script type="text/javascript" src="${renderRequest.getContextPath()}/js/button-min.js"></script>
	
	<style type="text/css">
	
	    #yui_results {
		    border: 1px solid black;
		    height: 100px;
		    overflow: hidden;
		    position: relative;
		    width: 100px;
		}
	    #yui_results img {
	        position: absolute;
	        top: 0px;
	        left: 0px;
	    }
	    
	    .yui-skin-sam .yui-crop .yui-crop-mask {
	    	background-color: transparent;
	    }
	
	</style>
	
	<script>
	
	(function() {
	    var Dom = YAHOO.util.Dom,
	        Event = YAHOO.util.Event,
	        results = null,
	        initWidth = 100,
	        initHeight = 100,
	        initialXY = [0, 0];
	    
	    Event.onDOMReady(function() {
	            results = Dom.get('yui_results');    
	            var crop = new YAHOO.widget.ImageCropper('yui_img', {
	                initialXY: initialXY,
	                initWidth: initWidth,
	                initHeight: initHeight,
	                keyTick: 5,
	                shiftKeyTick: 50
	            });
	            crop.on('moveEvent', function() {
	                var region = crop.getCropCoords();
	                results.firstChild.style.top = '-' + region.top + 'px';
	                results.firstChild.style.left = '-' + region.left + 'px';
	                results.style.height = region.height + 'px';
	                results.style.width = region.width + 'px';
	                
	                Dom.get('t').value = region.top;
	                Dom.get('l').value = region.left;
	                Dom.get('h').value = region.height;
	                Dom.get('w').value = region.width;
	                
	                /*
	                document.title += " -region.top: " + region.top;
	                document.title += " -region.left: " + region.left;
	                document.title += " -region.height: " + region.height;
	                document.title += " -region.width: " + region.width;
	                */
	                
	            });
	    });
	})();
	
	
	</script>
	
	<portlet:resourceURL var="uploadFileResourceURL">
		<portlet:param name="action" value="uploadFile" />
	</portlet:resourceURL>
	
	<portlet:actionURL var="editHtml5SupportedUserPortraitURL">
		<portlet:param name="action" value="editUserPortrait" />
		<portlet:param name="html5Supported" value="true" />
	</portlet:actionURL>
	
	<portlet:actionURL var="editNotHtml5SupportedUserPortraitURL">
		<portlet:param name="action" value="editUserPortrait" />
		<portlet:param name="html5Supported" value="false" />
	</portlet:actionURL>
	<div class="profile-image-container screen-max-width">
	<h2 class="sp-mbl"><b class="sp-mbl-bold">Add/Edit</b> Profile Picture</h2>
	<div class="profileimagewrapper">
	<section class="profile-currimg-wrapper">
		<div class="profile-currimg-container">
			<div class="profile-currimg-content">
				<span class="profile-currimg-text">Current Image</span>
				<img alt="User Image" id="pi_portrait" src="<%=UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, (Long)request.getAttribute("portraitId")) %>" />
				<div id="yui_results" class="sp-mbl hide"><img alt="User Image" src="<%=UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, (Long)request.getAttribute("portraitId")) %>" style="max-width: ${usersImageMaxWidth}px; max-height: ${usersImageMaxHeight}px;"/></div>
			</div>
		</div>
	</section>

	<section class="profile-upload-wrapper">
	
	<div class = "upload-top-container">
		<div class = "upload-top-content">
			<h3><img alt="Upload Image" src="<%=themeDisplay.getPathThemeImages()%>/icons/uploadImage.png"/>Upload New Image</h3>
			
			<div id="<portlet:namespace />pi-html5-not-supported-uploader" class="hide">
				<aui:form action="<%= editNotHtml5SupportedUserPortraitURL %>" enctype="multipart/form-data" method="post" name="fm">
					<liferay-ui:error exception="<%= com.liferay.portal.kernel.upload.UploadException.class %>" message="An unexpected error occurred while uploading your file." />
					<liferay-ui:error exception="<%= com.liferay.portal.UserPortraitSizeException.class %>" message="Please enter a file with a valid file size no larger than ${usersImageMaxSize}" />
					<liferay-ui:error exception="<%=com.liferay.portal.UserPortraitTypeException.class %>" message="Please enter a-file with a valid file type" />
				
					<aui:input name="fileName" size="50" type="file" />
					<aui:button type="submit" />
				</aui:form>
			</div>
		
	
			<div id="<portlet:namespace />pi-html5-supported-uploader" class="hide">
				<div class="yui-skin-sam">
					<p id="yui_img_container" class="sp-mbm hide"><img alt="User Image" id="yui_img" src="" style="max-width: ${usersImageMaxWidth}px; max-height: ${usersImageMaxHeight}px; width: auto; height: auto;"/></p>
					<div id="<portlet:namespace />pi-html5-uploader">
					    <input id="<portlet:namespace />pi-multi-upload" type="file" />
					    <div id="<portlet:namespace />pi-select-zone" style="display: inline-block;">
					    	<input type="file" id="<portlet:namespace />pi-input-file" multiple onchange="handleFiles(this.files, '<%=uploadFileResourceURL %>', '<portlet:namespace />', ${usersImageMaxSize}, ${usersImageMaxWidth}, ${usersImageMaxHeight})" />
					    </div>
					    
					    <div class="pi-or-hr"></div>
					    
					    
						<h3 class="sp-mbl"><img alt="Drag and Drop" src="<%=themeDisplay.getPathThemeImages()%>/icons/dragdrop.png"/>Drag & Drop</h3>
					</div>
					
					<div id="<portlet:namespace />pi-preview-container">
					
					</div>
					
					<aui:form action="<%=editHtml5SupportedUserPortraitURL %>" method="post" name="fm2">
						<input type="hidden" name="redirect" value="${redirect}"/>
						<input type="hidden" id="t" name="t" value="0"/>
						<input type="hidden" id="l" name="l" value="0"/>
						<input type="hidden" id="w" name="w" value="100"/>
						<input type="hidden" id="h" name="h" value="100"/>
						<input type="hidden" id="<portlet:namespace />pi-temp-input" name="tempFileEntryId" value=""/>
						<div class="sp-mtm button-disabled ">
							<input type="submit" class="btn-primary confirmButton" value="Confirm" id="<portlet:namespace />pi-save-button" disabled="disabled" /><a href="${redirect}"><input type="button" class="sp-mlm cancel btn-primary" value="  Back  "/></a>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
	</section>
	</div>
</div>	
	<script type="text/javascript">
		var uploadFileResourceURL = '<%=uploadFileResourceURL%>';
		var usersImageMaxWidth = ${usersImageMaxWidth};
		var usersImageMaxHeight = ${usersImageMaxHeight};
		var usersImageMaxSize = ${usersImageMaxSize};
	</script>
	
	<aui:script use="liferay-upload">
		var browserIsSupported = window.FileReader && Modernizr.draganddrop;
		var html5NotSupportedUploader = document.getElementById('<portlet:namespace />pi-html5-not-supported-uploader');
		var html5SupportedUploader = document.getElementById('<portlet:namespace />pi-html5-supported-uploader');
		var html5Uploader = document.getElementById('<portlet:namespace />pi-html5-uploader');
		
		var imageWidthMin = usersImageMaxWidth;
		var imageHeightMin = usersImageMaxHeight;
		
		//document.title += "-imageWidthMin: " + imageWidthMin + " -imageHeightMin: " + imageHeightMin + " -usersImageMaxSize: " + usersImageMaxSize;
		
		if(browserIsSupported) {
			removeClass(html5SupportedUploader, "hide");
			var html5UploaderSign = document.createElement('input');
			html5UploaderSign.setAttribute('name', '<portlet:namespace />isHtml5UploaderSupported');
			html5UploaderSign.setAttribute('type', 'hidden');
			html5UploaderSign.setAttribute('value', 'true');
			var fm2 = document.getElementById('<portlet:namespace />fm2');
			fm2.appendChild(html5UploaderSign);
			
			AUI().ready(function (A){
				new DndUpload(html5Uploader, document.getElementById('<portlet:namespace />pi-multi-upload'), uploadFileResourceURL, '<portlet:namespace />', usersImageMaxSize, imageWidthMin, imageHeightMin);
			});
		}else {
			removeClass(html5NotSupportedUploader, "hide");
		}
	</aui:script>
	</c:when>
	<c:otherwise>
		<c:out value="Please log in to view this part."></c:out>
	</c:otherwise>
</c:choose>


