<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>

<script src="<%=request.getContextPath()%>/js/dropzone.js"></script>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createFramework">
	<portlet:param name="action" value="addFramework"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadFrameworkImage">
	<portlet:param name="action" value="uploadFrameworkImage"></portlet:param>
</portlet:resourceURL>


<%@ include file="/html/create/msg.jsp"%>

<div class="Product_Section screen-max-width">
	<div class="Product_Sidebar">
		<%@ include file="/html/create/navigation.jsp"%>
	</div>
	<div class="Product_wrapper">
		<div class="Border" id="mainContainer">
			<!--HEADER-->
			<div class="Product_header">
				<div class="Prod-Headtitle">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.framework")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listFramework%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>



				<div class="Prod-HeadContent">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/images/Product_create/Icon-Framework.svg" alt="Framework">
						<c:if test="${empty frameworkDetail.spFrameworkId }">
							<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.createFramework")%></h2>
						</c:if>
						<c:if test="${not empty frameworkDetail.spFrameworkId }">
							<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.updateFramework")%></h2>
						</c:if>
					</a>
				</div>
			</div>
			<div class="active-content-Sec  ProdBorder-active">
				<span></span>
			</div>
			<!--HEADER END-->
			<!--CONTENTSECTION FRAMEWORK-->
			<div class="Product_contsection">
				<div id="Product_framework">
					<div class="Form-Prodsection Form-padding ">
						<input type="hidden" id="spFrameworkId" name="spFrameworkId"
							value="${frameworkDetail.spFrameworkId}">
						<div class="Input_small">
							<input type="text" class="Requiredfield" name="frameworkCode"
								id="frameworkCodeId" value="${frameworkDetail.frameworkCode}"
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.frameworkCode")%> *" maxlength="75"
								onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.frameworkCode")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">

						</div>
						<div class="Input_Medium">
							<input type="text" class="Requiredfield" name="frameworkName"
								id="frameworkNameId" value="${frameworkDetail.frameworkName}"
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.frameworkName")%> *" maxlength="250"
								onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.frameworkCode")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">

						</div>
						<c:set var="frameworkImageId"
							value="${frameworkDetail.frameworkImageId }" />
						<%
							Long imgId = (Long) pageContext.getAttribute("frameworkImageId");
													String imgUrl = "";
													if (imgId != null && imgId.compareTo(Long.parseLong("0")) != 0 ) {
														imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(imgId),
																themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																themeDisplay.getPathContext(), 1);
													}
													if(imgUrl != ""){
						%>
						<div class="frameworkImages imageContainer" id="frameworkImageId">
							<div>
								<img src="<%=imgUrl%>" alt="Framework">
							</div>
							<div>
								<button onClick="removeImage('frameworkImageId','frameworkImageFileEntryId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
							</div>
						</div>
						<%
							}
						%>
						<div class="Image_upload" id="frameworkImage">
							<form action="${uploadFrameworkImage}" class="dropzone"
								id="frameworkImageDropzone">
								<input type="hidden" id="frameworkImageFileEntryId"
									name="frameworkImageFileEntry" class="imageField"
									value="${frameworkDetail.frameworkImageId}">
							</form>
						</div>
						<div class="footNoteMsg">
							<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes")%>
															<ol>
																<li> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes.message1")%></li>
																<li> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes.message3")%></li>
															</ol> 
						</div>
					</div>
					<div>
						<!--CONTENTSECTION FRAMEWORK-->
					</div>
				</div>
			</div>
		</div>
		<div class="Product_bottom">
			<a href="<%= listFramework %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
				onclick="saveframework();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
		</div>
	</div>
</div>

<script type="text/javascript">
	var minImageWidth = 60, minImageHeight = 25;

	Dropzone.options.frameworkImageDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		maxFilesize : 2, // MB
		dictDefaultMessage : "<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.imageslogo")%>",
		acceptedFiles : "image/*",

		init : function() {

			// Register for the thumbnail callback.
			// When the thumbnail is created the image dimensions are set.
			this.on("thumbnail",
					function(file) {
						// Do the dimension checks you want to do
							aspectRatio = minImageHeight / minImageWidth;
						if ((file.width < minImageWidth || file.height < minImageHeight) || ((file.height / file.width) != aspectRatio)){
							file.rejectDimensions()
						} else {
							if(file.acceptDimensions){
								file.acceptDimensions();
							}
						}
					});

			this.on("addedfile", function(file) {
				// Create the remove button
				var removeButton = Dropzone
						.createElement("<button>" + '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

				// Capture the Dropzone instance as closure.
				var _this = this;

				// Listen to the click event
				removeButton.addEventListener("click", function(e) {
					// Make sure the button click doesn't submit the form:
					e.preventDefault();
					e.stopPropagation();

					// Remove the file preview.
					_this.removeFile(file);
					// If you want to the delete the file on the server as well,
					// you can do the AJAX request here.
				});

				// Add the button to the file preview element.
				file.previewElement.appendChild(removeButton);
			});
			this
					.on(
							"success",
							function(file, responseText) {
								var items = JSON.parse(responseText);
								var tempFileEntryId = items["tempFileEntryId"];
								document
										.getElementById("frameworkImageFileEntryId").value = tempFileEntryId;
								if(document.getElementById("frameworkImageId")){
								document.getElementById("frameworkImageId").innerHTML = '';
								}
							});

		},

		// Instead of directly accepting / rejecting the file, setup two
		// functions on the file that can be called later to accept / reject
		// the file.
		accept : function(file, done) {
			file.acceptDimensions = done;
			file.rejectDimensions = function() {
				done('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.invalidDimension")%>');
			};
			// Of course you could also just put the `done` function in the file
			// and call it either with or without error in the `thumbnail` event
			// callback, but I think that this is cleaner.
		},
		error : function(file,message){
			displayErrorMsgUnderFilePreview(file, message);
		}
	};

	function saveframework() {
		var isValidate = validateForm("Product_framework",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		//alert("frameworkCodeId " + document.getElementById("frameworkCodeId").value);
		if (isValidate)
		{
			AUI().use('aui-node','aui-io-request',function(A){
				var items = null;
				var createFramework = '${createFramework}';
				startPreLoader("mainContainer");
				try {
					A.io
							.request(
									createFramework,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											spFrameworkId : document
													.getElementById("spFrameworkId").value,
											frameworkCode : document
													.getElementById("frameworkCodeId").value,
											frameworkName : document
													.getElementById("frameworkNameId").value,
											frameworkImageId : document
											.getElementById("frameworkImageFileEntryId").value		
										},
										on : {
											complete : function(){
												stopPreLoader("mainContainer");
											},
											success : function() {
												var data = this.get('responseData');
												if (data) {
													if(data.error){
														displayError(data.error);
													}else if(data.spFrameworkId > 0){
														// here data.spFrameworkId = value returned from server
														//  spFrameworkId is value submitted to server
														var spFrameworkIdNode = A.one("#spFrameworkId");
														var spFrameworkId = spFrameworkIdNode.val();
														spFrameworkIdNode.val(data.spFrameworkId);
														if(spFrameworkId > 0){ //existing
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.updated")%>');
														}else{
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.created")%>');
															A.one("#header").setContent('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.update")%>');
														}
													}else{
														// This case is very very rare
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
													}
												} else {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.save.error")%>');
												}
												window.scrollTo(0,0);
											},
											failure : function() {
												displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.framework.save.error")%>');
												window.scrollTo(0,0);
											}
										}
	
									});
				} catch (err) {
					console.log(err);
				}
				
			});
		}
	}
</script>
