
<%@ include file="/html/portlet/document_library/init.jsp" %>

<link href="http://vjs.zencdn.net/c/video-js.css" rel="stylesheet">
<script src="http://vjs.zencdn.net/c/video.js"></script>

<%
boolean supportedAudio = GetterUtil.getBoolean((String)request.getAttribute("view_file_entry.jsp-supportedAudio"));
boolean supportedVideo = GetterUtil.getBoolean((String)request.getAttribute("view_file_entry.jsp-supportedVideo"));

String[] previewFileURLs = (String[])request.getAttribute("view_file_entry.jsp-previewFileURLs");
String videoThumbnailURL = (String)request.getAttribute("view_file_entry.jsp-videoThumbnailURL");

String mp4PreviewFileURL = null;
String oggPreviewFileURL = null;
String webmPreviewFileURL = null;

for (String previewFileURL : previewFileURLs) {
	if (previewFileURL.endsWith("mp4")){
		mp4PreviewFileURL = previewFileURL;
	}
	else if (previewFileURL.endsWith("ogg")){
		oggPreviewFileURL = previewFileURL;
	}
	else if (previewFileURL.endsWith("webm")){
		webmPreviewFileURL = previewFileURL;
	}
}
%>

<c:if test="<%= supportedAudio%>">
	<aui:script use="aui-swf-deprecated">
		new A.SWF(
			{
				boundingBox: '#<portlet:namespace />previewFileContent',
				fixedAttributes: {
					allowFullScreen: true,
					bgColor: '#000000'
				},
				flashVars: {
					'mp3': '<%= previewFileURLs[0] %>'
				},
				height: 27,
				url: '<%= themeDisplay.getPathJavaScript() %>/misc/video_player/mpw_player.swf',
				useExpressInstall: true,
				version: 9
			}
		);
	</aui:script>
</c:if>
<c:if test="<%= supportedVideo%>">
	<video class="video-js vjs-default-skin" controls preload="auto" width="640" height="264" data-setup="{}">
		<c:if test="<%= com.liferay.portal.kernel.util.Validator.isNotNull(mp4PreviewFileURL) %>">
	  		<source src="<%= mp4PreviewFileURL %>" type="video/mp4" />
		</c:if>
		<c:if test="<%= com.liferay.portal.kernel.util.Validator.isNotNull(oggPreviewFileURL) %>">
	  		<source src="<%= oggPreviewFileURL %>" type="video/ogg" />
		</c:if>
		<c:if test="<%= com.liferay.portal.kernel.util.Validator.isNotNull(webmPreviewFileURL) %>">
	  		<source src="<%= webmPreviewFileURL %>" type="video/webm" />
		</c:if>
	</video>
</c:if>