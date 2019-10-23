<%@page import="com.sambaash.platform.srv.spasset.model.SPAssetEntry"%>
<%@ include file="/html/init.jsp"%>
<liferay-util:html-top>                                                                                                                                                    
        <meta property="og:title" content="${ogtitle}"/>                                                                                                                   
        <meta property="og:description" content="${ogdescription}"/>                                                                                                       
        <meta property="og:image" content="${ogimage}"/>                                                                                                                   
        <meta property="og:url" content="${ogurl}"/>                                                                                                                       
        <meta property="og:type" content="Gallery"/>                                                                                                                       
</liferay-util:html-top>  
<style>
	 #videoDiv .video-js .vjs-control-bar  {
	 	opacity : 1
	}
</style>
<c:choose>
	<c:when test="${assetEntryId gt 0}">
		<portlet:resourceURL var="resourceURL" id="myResourceID01" />
		<div id="galleryMainView" class="galleryMainView">
			<div class="header-bg align-center gallery-header">
				<div>
					<div class="header-title">
						<div class="inline-block galleryTitle">
							<span id="galleryTitle" class="h2"></span>
						</div>
						<div class="inline-block float-right gallery-header-nav">
							<c:if test="${ not empty galleryPageUrl }">
								<div class="inline-block icon-replys">
									<a href="/${galleryPageUrl }"><img
										src="/SPAsset-portlet/images/back.png" alt="Back"/></a>
								</div>
							</c:if>
							<c:if test ="${not empty previousGalleryUrl  }">
								<div class="inline-block icon-backwards">
									<a href="${previousGalleryUrl}">
										<img
											src="/SPAsset-portlet/images/previous.png" alt="Previous"/>
									</a>
								</div>
							</c:if>
							<c:if test ="${not empty nextGalleryUrl  }">
								<div class="inline-block icon-forwards">
									<a href="${nextGalleryUrl}">
										<img
											src="/SPAsset-portlet/images/next.png" alt="Next"/>
									</a>
								</div>
							</c:if>
						</div>
					</div>
				</div>
				<div>
					<div class="copy-caption">
						<div
							class="inline-block img-tn-circle-small vert-align-sub user-image">
							<img alt="Upload" src="" id="uploaderImg" class="txt-custom-color-3" />
						</div>
						<div class="inline-block">
							<a href="javascript:;" id="uploaderName"></a><br/> <span
								id="uploadedTime" class="uploadedTime"></span>
						</div>
					</div>
				</div>
			</div>
			<div id="galleryCoverDiv" class="galleryCoverDiv">
				<div class="coverImageDiv img-tn-large">
					<img src="" id="coverImage" class="coverImage" alt="Cover Image"/>
				</div>

				<div id="galleryInfo" class="galleryInfo">
					<div class="galleryDescriptionDiv">
						<span id="galleryDescription" class="p"></span>
					</div>
					<div class="spAssetLongLine hr"></div>
					<div id="galleryTagsSection">
						<div class="strong width-8"><%=LanguageUtil.get(pageContext,"label.tags")%></div>
						<div class="vr"></div>
						<div class="tagsList">
							<ul id="galleryTags" class="tags"></ul>
						</div>


					</div>
					<div class="spAssetLongLine hr"></div>
					<div id="galleryCatgsSection">
						<div class="strong width-8"><%=LanguageUtil.get(pageContext,"label.categories")%></div>
						<div class="vr"></div>
						<div class="catgList">
							<ul id="galleryCatgs" class="catgs">

							</ul>
						</div>

					</div>
					<div id="galleryCategoriesSection">
						<div id="galleryCategories"></div>
					</div>
					<div class="spAssetLongLine hr"></div>
					<div id="gallerySocialBookmarksDiv">
						<div class="strong width-8"><%=LanguageUtil.get(pageContext,"label.social")%></div>
						<div class="vr"></div>
						<div class="gallerySocialBookmarksList">
							<sp-ui:social-share url="${galleryUrl }" type="Gallery"
								description="${galleryDescription }"
								fileEntryId="${galleryCoverId }" title="${galleryTitle }"
								metadata="${assetEntry_setmetadata}" prefix="gallery"></sp-ui:social-share>
						</div>

					</div>
				</div>
			</div>
			<div id="thumbnailsDiv" class="thumbnailsDiv"></div>
			<div class="commentsDiv">
				<sp-ui:comment classPK="${assetEntryId }"
					className="<%= SPAssetEntry.class.getName() %>"
					ajaxUrl="<%= resourceURL %>" prefix="gallery"></sp-ui:comment>
			</div>
			<div id="thumbnailTemplate" class="thumbnailTemplate hide">
				<img alt="Thumbnail" src="" id="thumbnail" class="thumbnail" />
			</div>
		</div>

		<div id="galleryFileViewer" class="hidden galleryFileViewer"
			tabindex="0">
			<input type="hidden" value="${assetEntryId }" id="assetEntryId" /> <input
				type="hidden" value="${fileId }" id="fileId" />
			<div class="galleryFileViewer-popup">
				<div class="galleryFileViewer-nav">
					<div class="backTogalleryListing" id="backTogalleryListing">
						<a href="/${galleryPageUrl }"><img
							src="/${themeDisplay.getTheme().getName()}-theme/images/common/back.png" alt="Back"/></a>
					</div>
					<div id="closegalleryFileViewer" class="closegalleryFileViewer">
						<span>X</span>
					</div>
				</div>
				<div class="galleryFileViewer-content">
					<div id="fileSection" class="fileSection">
						<div id="leftArrow" class="leftArrow icon-angle-left"></div>
						<div id="fileDiv">
							<div id="imageDiv">
								<img alt="Gallery Image" id="imageFile" src="" />
							</div>
							<div id="pdfDiv" class="hide">
								<div>
									<input type="button" id="prev" value="Previous" /> <input
										type="button" id="next" value="Next" /> &nbsp; &nbsp; <span>Page:
										<span id="page_num"></span> / <span id="page_count"></span>
									</span>
								</div>
								<div>
									<canvas id="the-canvas" style="border: 1px solid black"></canvas>
								</div>
							</div>
							<div id="videoDiv" class="hide">
								<video id="videoTag"
									class="video-js vjs-default-skin vjs-big-play-centered "
									width="640" height="300" poster="">
									<!--  http://video-js.zencoder.com/oceans-clip.png -->
									<source src="" type='' id="videoSrc1" />
									<source src="" type='' id="videoSrc2" />
									<source src="" type='' id="videoSrc3" />
									<p class="vjs-no-js">
										To view this video please enable JavaScript, and consider
										upgrading to a web browser that <a
											href="http://videojs.com/html5-video-support/"
											target="_blank">supports HTML5 video</a>
									</p>
								</video>
							</div>
							<div id="documentDiv" class="hide">
								<iframe src="" width="100%" height="520" style="border: none;">
								</iframe>
							</div>
						</div>
						<div id="rightArrow" class="rightArrow icon-angle-right"></div>
						<div class="coverImageBtnDiv imageBtn" id="coverImageBtnDiv">
							<div Class="coverImage-galleryBtn"
								id="coverImage-galleryBtn">
								<%=LanguageUtil.get(pageContext,"label.set.cover.image")%>
							</div>
						</div>
					</div>
					<div class="infoSectionMainDiv">
						<div id="infoSection" class="infoSection">
							<div id='descriptionSection'>
								<span id="description" class="p"></span>
							</div>
							<div id="tagsSection">
								<div class="spAssetLongLine"></div>
								<div class="strong width-8"><%=LanguageUtil.get(pageContext,"label.tags")%></div>
								<div class="vr"></div>
								<ul id="tags" class="tags">

								</ul>
							</div>
							<div id="catgsSection">
								<div class="spAssetLongLine"></div>
								<div class="strong width-8"><%=LanguageUtil.get(pageContext,"label.categories")%></div>
								<div class="vr"></div>
								<ul id="catgs" class="catgs">

								</ul>
							</div>
							<div class="spAssetLongLine"></div>
							<div id="download">
								<liferay-ui:icon id="download" image="download"
									label="<%=true%>" message='<%=LanguageUtil.get(pageContext,"label.download")%>' url="javascript:;" />
							</div>
							<div class="spAssetLongLine"></div>
							<div id="socialBookmarksDiv">
								<div class="strong width-8"><%=LanguageUtil.get(pageContext,"label.social")%></div>
								<div class="vr"></div>
								<div class="gallerySocialBookmarksList">
									<sp-ui:social-share url="${url }" type="Gallery"
										description="${description }" fileEntryId="${fileId }"
										title="${title }" metadata="${fileEntry-setmetadata}"
										prefix="galleryFile"></sp-ui:social-share>
								</div>
							</div>
						</div>
						<div class="commentsDiv" id="fileCommentsDiv">
							<sp-ui:comment classPK="${fileId }" className="${className }"
								ajaxUrl="<%= resourceURL %>" prefix="galleryFile"></sp-ui:comment>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			var config = {
				ajaxUrl: "<%=resourceURL%>",
				namespace: "<%=renderResponse.getNamespace()%>",
				className: "<%=com.liferay.portlet.documentlibrary.model.DLFileEntry.class.getName()%>",
				galleryUrl : "${galleryUrl }"
			};
			initalizeDetailView(config)
			
			YUI().use('event-mouseenter','transition', function (Y) {
				if( Y.one('#fileSection')){
			        var tabItem =  Y.one('#fileSection');
			        var imageItem =  Y.one('#imageDiv');
			        var setAsCover =  Y.one("#coverImageBtnDiv");
			        tabItem.on('mouseenter', function () {
			            this.one('#coverImageBtnDiv').transition('fadeIn');
			        });

			        tabItem.on('mouseleave', function () {
			            this.one('#coverImageBtnDiv').transition('fadeOut');
			        });
			        
			        imageItem.on('mouseenter', function () {
			            this.one('#coverImageBtnDiv').transition('fadeIn');
			        });

			        imageItem.on('mouseleave', function () {
			            this.one('#coverImageBtnDiv').transition('fadeOut');
			        });
			        
			    }
				
			});
		</script>
	</c:when>
	<c:otherwise>
		<div class="error">Invalid URL."</div>
	</c:otherwise>
</c:choose>
