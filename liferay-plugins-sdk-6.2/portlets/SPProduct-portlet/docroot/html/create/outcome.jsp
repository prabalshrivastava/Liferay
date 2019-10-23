<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.sambaash.platform.srv.model.Outcome"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>

<script src="<%=request.getContextPath()%>/js/dropzone.js"></script>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
	String outcomeDescLabel = "Course Outcome Description";
	outcomeDescLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.outcome.outcomeDescription");
	Outcome outcome = (Outcome)request.getAttribute("outcomeDetail");
	if(Validator.isNotNull(outcome)){
		outcomeDescLabel = outcome.getOutcomeDesc();
	}
%>


<portlet:resourceURL var="createOutcome">
	<portlet:param name="action" value="addOutcome"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadOutcomeLogo">
	<portlet:param name="action" value="uploadOutcomeLogo"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<div class="Product_Section">
	<div class="Product_Sidebar">
		<%@ include file="/html/create/navigation.jsp"%>
	</div>
	<div class="Product_wrapper">
		<div class="Border" id="mainContainer">
			<!--HEADER-->
			<div class="Product_header">
				<div class="Prod-Headtitle">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listOutcome%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>

				</div>

				<div class="Prod-HeadContent">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/images/Product_create/Icon-Outcome.svg" alt="Outcome">
						<c:if test="${empty outcomeDetail.spOutcomeId}">
							<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.createOutcome")%></h2>
						</c:if>
						<c:if test="${not empty outcomeDetail.spOutcomeId}">
							<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.updateOutcome")%></h2>
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
				<div id="Product_Outcome">
					<div class="Form-Prodsection Form-padding ">
						<input type="hidden" id="spOutcomeId" name="spOutcomeId"
							value="${outcomeDetail.spOutcomeId}">

						<div class="Input_Search_halfwidth Margin-20">
							<div class="select_style" id="Producttype1_select">
								<select id="competencyUnitCodeListId"
									name="competencyUnitCodeList" class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.competencyUnitCode")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.competencyUnitCode")%> *</option>
									<c:forEach var="competencyUnitCode"
										items="${competencyUnitCodeList}">
										<c:if
											test="${outcomeDetail.spCompetencyUnitId == competencyUnitCode.spCompetencyUnitId}">
											<option value="${competencyUnitCode.spCompetencyUnitId}"
												selected>${competencyUnitCode.competencyUnitCode}</option>
										</c:if>
										<c:if
											test="${outcomeDetail.spCompetencyUnitId != competencyUnitCode.spCompetencyUnitId }">
											<option value="${competencyUnitCode.spCompetencyUnitId}">${competencyUnitCode.competencyUnitCode}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>
						</div>
						<div class="Input_HalfWidth Margin-20">
							<input type="text" id="courseOutcomeCodeId"
								name="courseOutcomeCode" value="${outcomeDetail.outcomeCode }"
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outcome.courseOutcomeCode")%> *" class="Requiredfield"
								onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outcome.courseOutcomeCode")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
							<div class="icon-right">COC</div>
						</div>
						<div class="Input_HalfWidth ">
							<div class="select_style" id="Producttype1_select">
								<select id="outcomeTypeListId" name="outcomeTypeList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outcome.courseOutcomeType")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outcome.courseOutcomeType")%> *</option>
									<c:forEach var="outcomeType" items="${outcomeTypeList}">
										<c:if
											test="${outcomeDetail.outcomeType == outcomeType.categoryId }">
											<option value="${outcomeType.categoryId}" selected>${outcomeType.name}</option>
										</c:if>
										<c:if
											test="${outcomeDetail.outcomeType != outcomeType.categoryId }">
											<option value="${outcomeType.categoryId}">${outcomeType.name}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>
						</div>
						<div class="Input_Fullwidth">
							<div class="Admin-textarea">
								<liferay-ui:input-editor name='<%="outcome_description"%>'
									editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
									initMethod='<%="initEditor_outcome_description"%>'
									cssClass="ckeditor" />
								<aui:input name="content" type="hidden" />
								<aui:script>
									function <portlet:namespace />initEditor_outcome_description() {
										return "<%=UnicodeFormatter.toString(outcomeDescLabel)%>";
									}
								</aui:script>
							</div>
						</div>
						<c:set var="outcomeImageId"
							value="${outcomeDetail.outcomeFolderId }" />
						<div class="outcomeImages imageContainer" id="outcomeImageId">
							<%
								Long imgId = 0L;
												if(Validator.isNotNull(pageContext.getAttribute("outcomeImageId"))){
													 imgId = (Long) pageContext.getAttribute("outcomeImageId");
												} 
														String imgUrl = "";
														if (imgId != null && imgId.compareTo(Long.parseLong("0")) != 0 ) {
															List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), imgId);
													
															for(FileEntry fileEntry : fileEntryList){
															imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()),
																	themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																	themeDisplay.getPathContext(), 1);
							%>
							<div>
								<img src="<%=imgUrl%>" alt="Outcome">
							</div>
							<div>
								<button onClick="removeImage('outcomeImageId','outcomeFolderId')">Remove file</button>
							</div>
							<%
								}}
							%>
						</div>
						<div class="Image_upload" id="uploadImageVal">
							<form action="${uploadOutcomeLogo}" class="dropzone"
								id="outcomeDropzone">
								<input type="hidden" id="outcomeFolderId" class="imageField"
									name="outcomeFolder" value="${outcomeDetail.outcomeFolderId}">
							</form>
						</div>
						<%@include file="/html/create/imagespecNote.jsp" %>
					</div>
					<div>
						<!--CONTENTSECTION FRAMEWORK-->
					</div>
				</div>
			</div>
		</div>
		<div class="Product_bottom">
			<a href="<%= listOutcome %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
				onclick="saveOutcome();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
		</div>
	</div>
</div>

<script type="text/javascript">
	Dropzone.options.outcomeDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		dictDefaultMessage :'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.images")%>',
		acceptedFiles : "image/*",

		init : function() {

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
								var tempOutcomeFolderId = items["tempFolderId"];
								document.getElementById("outcomeFolderId").value = tempOutcomeFolderId;
							});

		},
 		error : function(file,message){
			displayErrorMsgUnderFilePreview(file, message);
		}	
	};

	function saveOutcome() {

		var isValidate = validateForm("Product_Outcome",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate) {
			AUI().use('aui-node','aui-io-request',function(A){
				var items = null;
				var createOutcome = '${createOutcome}';
				var outcomeTypeListNode = document
						.getElementById("outcomeTypeListId");
				var competencyUnitCodeListNode = document
						.getElementById("competencyUnitCodeListId");
				var outcomeDesc = window.<portlet:namespace />outcome_description
						.getHTML();
				try {
					startPreLoader("mainContainer");
					A.io
							.request(
									createOutcome,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											spOutcomeId : document
													.getElementById("spOutcomeId").value,
											courseOutcomeCode : document
													.getElementById("courseOutcomeCodeId").value,
											outcomeType : outcomeTypeListNode.options[outcomeTypeListNode.selectedIndex].value,
											outcomeFolderId : document
													.getElementById("outcomeFolderId").value,
											competencyUnitCodeId : competencyUnitCodeListNode.options[competencyUnitCodeListNode.selectedIndex].value,
											outcomeDescription : outcomeDesc,
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
													}else if(data.spOutcomeId > 0){
														// here data.spOutcomeId = value returned from server
														//  spOutcomeId is value submitted to server
														var spOutcomeIdNode = A.one("#spOutcomeId");
														var spOutcomeId = spOutcomeIdNode.val();
														spOutcomeIdNode.val(data.spOutcomeId);
														if(spOutcomeId > 0){ //existing
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.oucome.updated")%>');
														}else{
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.oucome.created")%>');
															A.one("#header").setContent('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.oucome")%>');
														}
													}else{
														// This case is very very rare
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.outcome.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
													}
												} else {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.outcome.save.error")%>');
												}
	
											},
											failure : function() {
												displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.outcome.save.error")%>');
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

