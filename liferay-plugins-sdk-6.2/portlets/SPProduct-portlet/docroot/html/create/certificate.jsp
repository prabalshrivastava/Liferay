<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>


<script src="<%=request.getContextPath()%>/js/dropzone.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createCertificate">
	<portlet:param name="action" value="addCertificate"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadCertificates">
	<portlet:param name="action" value="uploadCertificates"></portlet:param>
</portlet:resourceURL>

<div class="Product_Section screen-max-width">
	<%@ include file="/html/create/msg.jsp"%>
	<div class="Product_Sidebar">
		<%@ include file="/html/create/navigation.jsp"%>
	</div>

	<div class="Product_wrapper">
		<div class="Border" id="mainContainer">
			<!--HEADER-->
			<div class="Product_header">
				<div class="Prod-Headtitle">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.certificate")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listCertificate%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>

				<div class="Prod-HeadContent">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/images/Product_create/Icon-CompetencyUnit.svg" alt="Competency">
						<c:if test="${empty certificateDetail.spCertificatetId}">
							<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.createCertificate")%></h2>
						</c:if>
						<c:if test="${not empty certificateDetail.spCertificatetId}">
							<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.updateCertificate")%></h2>
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
				<div id="Product_certificate">
					<div class="Form-Prodsection Form-padding ">
						<input type="hidden" id="spCertificatetId" name="spCertificatetId"
							value="${certificateDetail.spCertificatetId}">
						<div class="Input_small">
							<input type="text" id="certificateCodeId" name="certificateCode"
								value="${certificateDetail.certificateCode }"
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.certificateCode")%> *" class="Requiredfield"
								onblur="requiredFieldValidation(this, 'Certificate code* ', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>

						<div class="Input_Medium">
							<input type="text" id="certificateTitleId"
								name="certificateTitle" value="${certificateDetail.title }"
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.certificateTitle")%> *" class="Requiredfield"
								onblur="requiredFieldValidation(this, 'Certificate Title*' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>


						<div class="Input_HalfWidth Margin-20">
							<div class="select_style" id="Producttype1_select">
								<select id="certificateLevelListId" name="certificateLevelList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, 'Certificate Level*' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.certificateLevel")%>
										*</option>
									<c:forEach var="certificateLevel"
										items="${certificateLevelList}">
										<c:if
											test="${certificateDetail.level == certificateLevel.categoryId}">
											<option value="${certificateLevel.categoryId}" selected>${certificateLevel.name}</option>
										</c:if>
										<c:if
											test="${certificateDetail.level != certificateLevel.categoryId}">
											<option value="${certificateLevel.categoryId}">${certificateLevel.name}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>
						</div>
						<div class="Input_HalfWidth ">
							<div class="select_style" id="Producttype1_select">
								<select id="certificateTypeListId" name="certificateTypeList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, 'Certificate Type*' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.certificateType")%> *</option>
									<c:forEach var="certificateTypes"
										items="${certificateTypeList}">
										<c:if
											test="${certificateDetail.certificateType == certificateTypes.categoryId}">
											<option value="${certificateTypes.categoryId}" selected>${certificateTypes.name}</option>
										</c:if>
										<c:if
											test="${certificateDetail.certificateType != certificateTypes.categoryId}">
											<option value="${certificateTypes.categoryId}">${certificateTypes.name}</option>
										</c:if>
									</c:forEach>
								</select>  
							</div>
						</div>
						<div class="Input_Fullwidth">
							<div class="Admin-textarea">
								<textarea name="certificateDesc" id="certificateDescId"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.certificateDescription")%>">${certificateDetail.description }</textarea>
							</div>
						</div>
						<c:set var="certificateImageId"
							value="${certificateDetail.attachmentFolderId }" />

						<%
							Long imgId = 0L;
											String certificateUrl = "#";
											long groupId = 0;
											if(Validator.isNotNull(pageContext.getAttribute("certificateImageId"))){
												 imgId = (Long) pageContext.getAttribute("certificateImageId");
											} 
													String imgUrl = "";
													if (imgId != null && imgId.compareTo(Long.parseLong("0")) != 0 ) {
														List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), imgId);
												
														for(FileEntry fileEntry : fileEntryList){
														imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()),
																themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																themeDisplay.getPathContext(), 1);
														String certUrl = fileEntry.getUuid();
														groupId = fileEntry.getGroupId();
														certificateUrl = "/documents/" + groupId +"/" + certUrl;
						%>
						<div class="certificateImages imageContainer"
							id="certificateImageId">
							
							<div>
								<a href="<%=certificateUrl%>"> 
									<img src="<%=imgUrl%>" alt="Certificate">
								</a> 
							</div>
							<div>
								<button onClick="removeImage('certificateImageId','certificateFolderId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
							</div>
						</div>
						<%
							}}
						%>

						<div class="Image_upload">
							<form action="${uploadCertificates}" class="dropzone"
								id="certificateDropzone">
								<input type="hidden" id="certificateFolderId"
									name="certificateFolder"
									value="${certificateDetail.attachmentFolderId}">
							</form>
						</div>

					</div>
					<div>
						<!--CONTENTSECTION FRAMEWORK-->
					</div>
				</div>
			</div>
		</div>
		<div class="Product_bottom">
			<a href="<%= listCertificate %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
				onclick="saveCertificate();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
		</div>
	</div>

</div>

<script type="text/javascript">
	Dropzone.options.certificateDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.images.doc")%>',
		init : function() {

			this.on("addedfile", function(file) {
				// Create the remove button
				var removeButton = Dropzone
						.createElement("<button>"+ '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

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
								var certificateTempFolderId = items["tempFolderId"];
								document.getElementById("certificateFolderId").value = certificateTempFolderId;
								if(document.getElementById("certificateImageId")){
								document.getElementById("certificateImageId").innerHTML = '';
								}
							});

		},
		error : function(file,message){
			displayErrorMsgUnderFilePreview(file, message);
		}
	};

	function saveCertificate() {
		var isValidate = validateForm("Product_certificate",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate)

		{

			AUI().use('aui-node','aui-io-request',function(A){
				var createCompetency = '${createCertificate}';
	
				var certificateLevelListNode = document
						.getElementById("certificateLevelListId");
				var certificateTypeListNode = document
						.getElementById("certificateTypeListId");
	
				try {
					startPreLoader("mainContainer");
					A.io
							.request(
									createCompetency,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											spCertificatetId : document
													.getElementById("spCertificatetId").value,
											certificateCode : document
													.getElementById("certificateCodeId").value,
											certificateDesc : document
													.getElementById("certificateDescId").value,
											certificateTitle : document
													.getElementById("certificateTitleId").value,
											certificateFolderId : document
													.getElementById("certificateFolderId").value,
											certificateLevel : certificateLevelListNode.options[certificateLevelListNode.selectedIndex].value,
											certificateType : certificateTypeListNode.options[certificateTypeListNode.selectedIndex].value
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
													}else if(data.spCertificatetId > 0){
														// here data.spCertificatetId = value returned from server
														//  spCertificatetId is value submitted to server
														var spCertificatetIdNode = A.one("#spCertificatetId");
														var spCertificatetId = spCertificatetIdNode.val();
														spCertificatetIdNode.val(data.spCertificatetId);
														if(spCertificatetId > 0){ //existing
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.updated")%>');
														}else{
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.created")%>');
															A.one("#header").setContent('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.update")%>');
														}
													}else{
														// This case is very very rare
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
													}
												} else {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.save.error")%>');
												}
												window.scrollTo(0,0);
											},
											failure : function() {
												displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.save.error")%>');
												window.scrollTo(0,0);
											}
										}
	
									});
				} catch (err) {
					alert(err);
				}
				
			});
			
		}
	}
</script>
