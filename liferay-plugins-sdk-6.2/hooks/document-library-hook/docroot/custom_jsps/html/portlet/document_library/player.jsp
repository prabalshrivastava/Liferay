<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
String randomNamespace = GetterUtil.getString(request.getAttribute("view_file_entry.jsp-randomNamespace"));

boolean supportedAudio = GetterUtil.getBoolean((String)request.getAttribute("view_file_entry.jsp-supportedAudio"));
boolean supportedVideo = GetterUtil.getBoolean((String)request.getAttribute("view_file_entry.jsp-supportedVideo"));

String[] previewFileURLs = (String[])request.getAttribute("view_file_entry.jsp-previewFileURLs");
String videoThumbnailURL = (String)request.getAttribute("view_file_entry.jsp-videoThumbnailURL");

String mp3PreviewFileURL = null;
String mp4PreviewFileURL = null;
String oggPreviewFileURL = null;
String ogvPreviewFileURL = null;
String webmPreviewFileURL = null;

for (String previewFileURL : previewFileURLs) {
	if (previewFileURL.endsWith("mp3")) {
		mp3PreviewFileURL = previewFileURL;
	}
	else if (previewFileURL.endsWith("mp4")) {
		mp4PreviewFileURL = previewFileURL;
	}
	else if (previewFileURL.endsWith("ogg")) {
		oggPreviewFileURL = previewFileURL;
	}
	else if (previewFileURL.endsWith("ogv")) {
		ogvPreviewFileURL = previewFileURL;
	}
	else if (previewFileURL.endsWith("webm")) {
		webmPreviewFileURL = previewFileURL;
	}
}
%>

<c:choose>
	<c:when test="<%= supportedAudio %>">
		<aui:script use="aui-audio">
			var audio = new A.Audio(
				{
					contentBox: '#<portlet:namespace /><%= randomNamespace %>previewFileContent',
					fixedAttributes: {
						allowfullscreen: 'true',
						wmode: 'opaque'
					}

					<c:if test="<%= Validator.isNotNull(oggPreviewFileURL) %>">
						, oggUrl: '<%= HtmlUtil.escapeJS(oggPreviewFileURL) %>'
					</c:if>

					<c:if test="<%= Validator.isNotNull(mp3PreviewFileURL) %>">
						, url: '<%= HtmlUtil.escapeJS(mp3PreviewFileURL) %>'
					</c:if>
				}
			).render();
		</aui:script>
	</c:when>
	<c:when test="<%= supportedVideo %>">
	<link href="/html/css/sp/video-js.min.css" rel="stylesheet" type="text/css">
	<script src="/html/js/sp/video.min.js" type="text/javascript"></script>
	<script>
	videojs.options.flash.swf = "/html/js/sp/video-js.swf";
	</script>
		<aui:script use="aui-base,aui-node">
			
				var vsrc  = A.one("#videoSrc1");
				vsrc.set("src","<%=mp4PreviewFileURL %>");
				vsrc.set("type","video/mp4");
				
				vsrc  = A.one("#videoSrc2");
				vsrc.set("src","<%=webmPreviewFileURL %>");
				vsrc.set("type","video/webm");
				
				vsrc  = A.one("#videoSrc3");
				vsrc.set("src","<%=oggPreviewFileURL %>");
				vsrc.set("type","video/ogg");
				
				
				videojs('videoTag', { "controls": true, "autoplay": false }, function() {
					console.log('Good to go!');
		
					//  this.play(); // if you don't trust autoplay for some reason
		
					// How about an event listener?
					this.on('ended', function() {
						console.log('awww...over so soon?');
					});
		
				});
	
				
		</aui:script>
	</c:when>
</c:choose>