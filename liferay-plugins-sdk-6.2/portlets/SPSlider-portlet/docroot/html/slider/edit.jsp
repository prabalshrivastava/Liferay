<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page
	import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants" %>
<%@ page
	import="com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants" %>
<%@ page import="java.util.List" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String allowedUploadTypes = "image/jpeg,image/gif,image/png,image/x-ms-bmp";
	List imageCatgList = (List) request.getAttribute("imageCatgList");
	String selectedCategoryId = (String) request
			.getAttribute("selectedCategoryId");
%>

<portlet:resourceURL var="uploadFileResourceURL">
	<portlet:param name="action" value="uploadFile" />
</portlet:resourceURL>

<portlet:resourceURL var="removeFileResourceURL">
	<portlet:param name="action" value="removeFile" />
</portlet:resourceURL>

<portlet:resourceURL var="saveLinkResourceUrl">
	<portlet:param name="action" value="saveLink" />
</portlet:resourceURL>

<portlet:actionURL var="imageUploadActionURL">
	<portlet:param name="action" value="imageUpload"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="reloadActionURL">
	<portlet:param name="action" value="reLoad"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<portlet:resourceURL id="myResourceID01" var="ajaxUrl">
</portlet:resourceURL>

<div id="RoleMapping_contents" style="margin:40px">

	<div class="maindiv" id="categorySel">
		<div class="slider-contentDiv">
			<%-- <input type="checkbox" value="${defaultCategoryId}" name="defaultCategorySelection" id="defaultCategorySelection" onChange="javascript:selectCategoryForSlider()">${defaultCategory} --%>
			<div>
				<div class="slider-content-title">
					Slider Settings
				</div>
				<%@ include file="/html/slider/edit-sliderSettings.jsp" %>
			</div>
			<div>
				<div class="slider-content-title">Slider Search Criteria</div>
				<form id="categorySelectForm" method="post" name="categorySelectForm">
					<input id="countryDeparment" type="radio" name="<portlet:namespace />feedSearchCriteria"
						value="countryRegion" ${countryRegion}
						style="margin: 0 10px 10px 0;"><b>Country or Region</b><br>
					<div id="cdDiv"
						class="maindivpersonalInfo search-stream-style2UI-content-desc">
						<input name="<portlet:namespace />searchPriority" type="radio" id="country"
							value="country" ${country} style="margin: 0 10px 10px 10px;">Search
						by Country first<br> <input type="radio"
							name="searchPriority" id="region" value="region" ${region}
							style="margin: 0 10px 10px 10px;">Search by Region first<br>
					</div>
					<input id="custom" type="radio" name="<portlet:namespace />feedSearchCriteria"
						value="custom" ${custom} style="margin: 0 10px 10px 0;"><b>Custom
					Value</b><br>
					<div
						style="text-align: center; background: #efefef; font-size: 18px; padding: 10px 10px 20px;">Select
						a category from below drop down to Upload Images for Slider</div>
					<div id="categoryListDiv" style="margin-top: 20px; display: none;">
						<c:choose>
							<c:when test="${true}">
								<div class="category_sel" id="Category_sel"
									style="display: inline-block; vertical-align: top; width: 45%;">
									<%-- <div class="content-title">
										${selectedCategoryName}${channel}
										<div class="seperatedline"></div>
									</div>${channel} --%>
									<select name="<portlet:namespace />defaultCategory_sel_list"
										id="defaultCategory_sel_list" style="display: inline-block;"
										onChange="javascript:defaultCategoryOnChange();">
										<option value=""></option>
										<c:forEach items="${allChannelWrappers}"
											var="allChannelWrapper">
											<optgroup label="${allChannelWrapper.vocabularyName}">
												<c:forEach items="${allChannelWrapper.channelWrappers}"
													var="channelWrapper">
													<option value="${channelWrapper.categoryId}"
														<c:if test="${channel == channelWrapper.categoryId}">selected="selected"</c:if>>
														<c:if test="${channelWrapper.child}">---</c:if>
														${channelWrapper.categoryName}
													</option>
												</c:forEach>
											</optgroup>
										</c:forEach>
									</select>
								</div>
							</c:when>
							<c:otherwise>
								<div class="error">No sufficient Access Permission for
									this portlet</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="criteriaDiv" style="display: none;margin-top: 20px;">
						<select id="feedSearchVocId" name="<portlet:namespace />feedSearchVocId">
							<c:forEach items="${assetVocabularies}" var="assetVocabulary">
								<c:if test="${feedSearchVocId == assetVocabulary.vocabularyId}">
									<option value="${assetVocabulary.vocabularyId}" selected>${assetVocabulary.name}</option>
								</c:if>
								<c:if test="${feedSearchVocId != assetVocabulary.vocabularyId}">
									<option value="${assetVocabulary.vocabularyId}">${assetVocabulary.name}</option>
								</c:if>
							</c:forEach>
						</select>
						<select id="feedSearchCatId" name="<portlet:namespace />feedSearchCatId" onChange="javascript:defaultCategoryOnChange();">
							<option value=""></option>
						</select>
					</div>
				</form>
			</div>

			<div class="imageUploadDiv" id="imageUploadDiv">
				<aui:form cssclass="gallery_upload_form" name="fm1">
					<div id="<portlet:namespace />liferay-uploader"
						class="lfr-dynamic-uploader">
						<!-- <div style="display:none;" id="dndUploadContainer"><input id="multi-upload" type="file" /></div> -->
						<div class="lfr-upload-container"
							id="<portlet:namespace />fileUpload"></div>
					</div>
					<div id="<portlet:namespace />html5-uploader" class=>
						<h2 style="display: inline-block;">Upload your files :</h2>
						<input id="multi-upload" type="file" />
						<div id="select-zone">
							<input id="input-file" type="file" multiple
								onchange="handleFiles(this.files, '<%= uploadFileResourceURL %>', '<%= removeFileResourceURL %>','<%= saveLinkResourceUrl %>', '<portlet:namespace />', 90080041824, 400, 300, '<%= allowedUploadTypes %>')" />
						</div>
						<div class="asset-create-or-hr"></div>
						<h2 class="sp-mbl">
							Drag and Drop
							<liferay-ui:icon-help
								message='You can select multiple files and drop them in the section below' />
						</h2>
					</div>
					<ul id="asset-create-list">
					</ul>
					<c:if test="${imageCatgList != ''}">
						<h2 class="sp-mbl sp-mtl">Existing files:</h2>
					</c:if>
					<ul id="asset-existing-list">
						<c:if test="${imageCatgList != ''}">

							<%
								int k = 0;
							%>

							<c:forEach items="${imageCatgList}" var="imageCatgList">
								<li class="uploader"><input type="checkbox"
									name="_SPSlider_WAR_SPSliderportlet_selectUploadedFileCheckbox"
									class="hide select-file" checked="checked">
									<div class="file-preview">

										<%
											List imgCatg = (List) imageCatgList.get(k);
														k = k + 1;
										%>

										<img alt="Preview Image" src="<%= imgCatg.get(0) %>">
										<div class="file-name"><%= imgCatg.get(1) %></div>
										<div id="linkUrl_editDiv<%= imgCatg.get(2) %>"><div id="linkUrl_span<%= imgCatg.get(2) %>"><%= imgCatg.get(3) %></div><a href="javascript:editLinkUrl(<%= imgCatg.get(2) %>)">Edit</a></div>
										<div id="linkUrl_saveDiv<%= imgCatg.get(2) %>" style="display:none;">
											<input id="imageLink<%= imgCatg.get(2) %>" name="imageLink" type="text" value="<%= imgCatg.get(3) %>">
											<a class="sp-mlm" data-file-entry-id="<%= imgCatg.get(2) %>" href="javascript:saveLinkUrl(<%= imgCatg.get(2) %>)" id="urlSaveLink<%= imgCatg.get(2) %>">Save</a>
											<div id="urlSaveIcon<%= imgCatg.get(2) %>" style="display:none;">Link Saved</div>
										</div>
										<a
											href="javascript:deleteExistingFileEntry('<%= imgCatg.get(2) %>');"
											data-file-entry-id="<%= imgCatg.get(2) %>"
											class="delete-existing-file-entry-button">Delete File</a>
									</div></li>
							</c:forEach>
						</c:if>
					</ul>
				</aui:form>
			</div>
			<div class="seperatedline"></div>
		</div>
	</div>

</div>

<aui:script use="liferay-upload">
	var uploadFileResourceURL = '<%= uploadFileResourceURL %>';
	var removeFileResourceURL = '<%= removeFileResourceURL %>';
	var saveLinkResourceUrl = '<%= saveLinkResourceUrl %>';
	var html5Uploader = A.one('#<portlet:namespace />html5-uploader');
	var liferayUploader = A.one('#<portlet:namespace />liferay-uploader');
	var commonFileMetadataContainer = document.getElementById('<portlet:namespace />commonFileMetadataContainer');
	var fileSizeMax = 90080041824;
	var imageWidthMin = 400;
	var imageHeightMin = 300;
	var allowedTypes = 'image/jpeg,image/gif,image/png,image/x-ms-bmp';
		html5Uploader.show();
		var html5UploaderSign = document.createElement('input');
		html5UploaderSign.setAttribute('name', '<portlet:namespace />isHtml5UploaderSupported');
		html5UploaderSign.setAttribute('type', 'hidden');
		html5UploaderSign.setAttribute('value', 'true');
		var fm2 = document.getElementById('<portlet:namespace />fm2');
		if (fm2 == null) {
			fm2 = document.getElementById('<portlet:namespace />fm');
		}else {
			fm2.appendChild(html5UploaderSign);
		}
		var dnd = {
		    init: function() {
		        var multiUpload = new DndUpload(document.querySelector('#multi-upload'), commonFileMetadataContainer, uploadFileResourceURL, removeFileResourceURL,saveLinkResourceUrl, '<portlet:namespace />', fileSizeMax, imageWidthMin, imageHeightMin, allowedTypes);
		    }
		};

	window.addEventListener('load', dnd.init, false);
</aui:script>
<script src="/SPSlider-portlet/js/main.js" type="text/javascript">
</script>
<script type="text/javascript">

	function deleteExistingFileEntry(fileEntryId) {
		var A = AUI();
		var reqUrl = '<portlet:resourceURL id="" />';
		var action = "removeFile";
		A.io.request(reqUrl, {
			cache : false,
			sync : true,
			timeout : 1000,
			dataType : 'json',
			method : 'post',
			data : {
				fileEntryId : fileEntryId,
				action : action
			},
			sync : true,
			on : {
				success : function() {
					var removeFileLink = getFirstElementsByAttribute(document,
							"a", "data-file-entry-id", fileEntryId);
					var uploader = getClosestParentByAttribute(removeFileLink,
							"class", "uploader");
					uploader.parentNode.removeChild(uploader);
				}
			}
		});
	}

function selectCategoryForSlider() {
	var defaultCategory = document.getElementById("countryDeparment");
	var categoryDiv = document.getElementById("categoryListDiv");
	if (defaultCategory.checked) {
		categoryDiv.style.display = "block";
	}else {
		categoryDiv.style.display = "none";
	}
	//alert("defaultCategory " +  defaultCategory + " chec " + defaultCategory.checked);
}

function defaultCategoryOnChange() {
	document.getElementById('categorySelectForm').action = "<%= imageUploadActionURL %>";
	document.categorySelectForm.submit();
	}

function saveSliderSettings() {
	var A = AUI();
	var reqUrl = '<portlet:resourceURL id="" />';
	var action = "saveSliderSettings";
	var licenseKey = document.getElementById("licenseKey").value;
	var sliderId = document.getElementById("sliderId").value;
	var effect = document.getElementById("effect").value;
	var autoAdvance = document.getElementById("autoAdvance").value;
	var pauseOnHover = document.getElementById("pauseOnHover").value;
	var pauseTime = document.getElementById("pauseTime").value;
	var speed = document.getElementById("speed").value;
	var startSlide = document.getElementById("startSlide").value;
	var circular = document.getElementById("circular").value;
	var touchCircular = document.getElementById("touchCircular").value;
	var mobileNavigation = document.getElementById("mobileNavigation").value;
	var before = document.getElementById("before").value;
	var after = document.getElementById("after").value;
	var multipleImages = document.getElementById("multipleImages").value;
	A.io.request(reqUrl, {
		cache : false,
		sync : true,
		timeout : 1000,
		dataType : 'json',
		method : 'post',
		data : {
			licenseKey : licenseKey,
			sliderId : sliderId,
			effect : effect,
			autoAdvance : autoAdvance,
			pauseOnHover : pauseOnHover,
			pauseTime : pauseTime,
			speed : speed,
			startSlide : startSlide,
			circular : circular,
			touchCircular : touchCircular,
			mobileNavigation : mobileNavigation,
			before : before,
			after : after,
			multipleImages : multipleImages,
			action : action
		},
		sync : true,
		on : {
			success : function() {
				alert("Slider Settings Saved Successfully");
			}
		}
	});
}

function editLinkUrl(fileEntryId) {
	document.getElementById("linkUrl_editDiv"+fileEntryId).style.display = "none";
	document.getElementById("linkUrl_saveDiv"+fileEntryId).style.display = "block";
}

function saveLinkUrl(fileEntryId) {
	//var fileEntryId = target.getAttribute("data-file-entry-id");
	var linkUrl = document.getElementById("imageLink"+fileEntryId).value;
	if ((linkUrl.indexOf("http://") == 0 ) || (linkUrl.indexOf("https://") == 0 ) || (linkUrl.indexOf("/") == 0 )) {
		var tempSaveLinkURL = '<%= saveLinkResourceUrl %>';
		tempSaveLinkURL += "&fileEntryId=" + fileEntryId + "&linkUrl=" + linkUrl;
		AjaxGet("GET", tempSaveLinkURL, saveSuccess, saveError);
	} else {
	    alert("Please enter a valid URL.\nFormat for: \nExternal links - 'https://www.example.com (OR) http://www.example.com'.\nInternal page links - '/page-name'");
	}
}
</script>

<script type="text/javascript">
var ajaxurl = '<%= ajaxUrl %>';
	selectCategoryForSlider();
	onchangeVocs(ajaxurl);
	fillCats("", ajaxurl, '${feedSearchCatId}');
	criteriaClickListener();
	showHideCriteriaDiv();
	//setCatgSelected()
</script>
