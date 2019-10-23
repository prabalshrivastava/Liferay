<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<script src="<%=request.getContextPath()%>/js/dropzone.js"></script>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createPersonna">
	<portlet:param name="action" value="addPersonna"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadAttendeeImage">
	<portlet:param name="action" value="uploadAttendeeImage"></portlet:param>
</portlet:resourceURL>
<script>

var url = '<%=uploadAttendeeImage%>';

function addDropZone(dropZoneId,imageValueId,imgDivId){
	var dzElmnt =  document.getElementById(dropZoneId);
	dzElmnt.classList.add("dropzone"); // adding this class here instead in tag. Bcz dragdrop.js by default attaches dropzone on load of dom for elmns having dropzone class 
	var id = "div#"+dropZoneId;
var myDropzone = new Dropzone(id, { 
		url: url,
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.images")%>',
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
								var tempFileEntryId = items["tempFileEntryId"];
								document.getElementById(imageValueId).value = tempFileEntryId;
								if(imgDivId != ''){
									var imageDiv = document.getElementById(imgDivId);
									imageDiv.innerHTML = "";
								}	
							});

		},
		error : function(file,message){
			displayErrorMsgUnderFilePreview(file, message);
		}
});
}
</script>

<%
	String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
	String coursePersonaDescriptionLabel = "Entry requirements";
	coursePersonaDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.course.coursePersona");
%>

 <% String spCourseId = request.getParameter("spCourseId"); 
 %>

<%@ include file="/html/create/msg.jsp"%>
<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">

		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>

		<div class="Right_content_section">
			<%
				if(Validator.isNotNull(spCourseId)){
			%>
			<div class="Border" id="mainContainer">
				<div class="heading-title Border-bottom">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.persona")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listCourse%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>
				<div class="form-section ">
					<div class="Input_Fullwidth margin-20-topbottom">
								<liferay-ui:input-editor name='<%="persona_description"%>'
									editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
									initMethod='<%="initEditor_persona_description"%>'
									cssClass="ckeditor" />
								<input type="hidden" value="" name="personaEntryDesc"
									id="personaEntryDescId">
									<c:set var="personaCourseDesc" value="${personaCourseDesc}" />
								<%
									String personaCourseDesc = (String) pageContext.getAttribute("personaCourseDesc");
								%>
								<aui:script>
							function <portlet:namespace />initEditor_persona_description() {
								<c:choose>
								<c:when test="${empty personaCourseDesc}">
									return "<%=UnicodeFormatter.toString(coursePersonaDescriptionLabel)%>";
								</c:when>
								<c:otherwise>
									return "<%=UnicodeFormatter.toString(personaCourseDesc)%>";
								</c:otherwise> 
								</c:choose>
							}
						</aui:script>
							
							
						</div>
					<div class="Input_Fullwidth text-right Addpersona_click">
						<div class="Add_button">
							<a href="javascript:addPersonaInstances()"
								class="Button-green button-pos-right Add_persona_append"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addPersona")%></a>
								<div id="errorMsg-Modal"></div>
						</div>
					</div>
					<form action="#" method="POST" id="personaFormId" name="fm">
						<div id="personaInner_0">
							<input type="hidden" id="spCourseId" name="spCourseId"
								value="<%=spCourseId%>">
							<div id="commonPersonaTypeListId" style="display:none;">
												<select id="personaTypeListId" name="personaTypeList">
														<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.personaType")%>
															*</option>
														<c:forEach var="personaTypeList"
															items="${personaTypeList}">
															<option value="${personaTypeList.categoryId}">${personaTypeList.name}</option>
														</c:forEach>
													</select>
											</div>
							<c:if test="${!empty personaDetailList }">
								<%@ include file="/html/create/persona_edit.jsp"%>
							</c:if>

							<c:if test="${empty personaDetailList }">
							<input type="hidden" id="globalCountId"  name="globalCountId" value="1">
								<div class="personaWrapper" id="personaWrapperId_0">
									<div
										class="form-inner Border Form-pop-padding Form-bg  FormBorder-active">
										<div class="close_button">
											<span
												onclick="javascript:removeByInstanceIdWithMandatoryFields('personaWrapperId_0','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.persona.required.message")%>');"><img
												src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
												alt="Close"></span>
										</div>
										<div class="form-summary-inner">
											<div class="Input_HalfWidth">
												<div class="select_style">
													<select id="personaTypeListId_0" name="personaTypeList_0"
														class="Requiredfield"
														onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.personaType")%>*', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
														<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.personaType")%>
															*</option>
														<c:forEach var="personaTypeList"
															items="${personaTypeList}">
															<option value="${personaTypeList.categoryId}">${personaTypeList.name}</option>
														</c:forEach>
													</select>

												</div>
											</div>

										</div>

										<div class="form-summary-inner">
											<div class="Input_Fullwidth margin-20-topbottom">
												<div class="Admin-textarea">
													<textarea name="personaAttendanceDesc_0" id="personaAttendanceDescId_0"
														placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.personaDescription")%>*" maxlength="360"></textarea>
												</div>
												<div class="footNoteMsg">
													<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.description.maxChars")%>
												</div>
											</div>
											<div class="Image_upload" id="uploadImageVal">
												<div id="attendeeDropzone_0">
													<input type="hidden" id="attendAttachmentId_0"
														name="attendAttachment_0" class="imageField" value="">
												</div>
											</div>
											<%@include file="/html/create/imagespecNote.jsp" %>
										</div>
									</div>
								</div>
							</c:if>
						</div>
						<div id="attendAppendSectionId"></div>
					</form>
				</div>
			</div>
			<div class="Right_bottom">
				<a href="<%=listCourse%>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="#"
					onclick="submitForm('personaFormId','personaWrapper');"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
				<div class="Prev-icon">
					<a href="${editCourse}&<portlet:namespace />spCourseId=<%=spCourseId%>"></a>
				</div>
				<div class="Next-icon">
					<a href="javascript:courseTabslink('<%=addLearningDetails%>','editLearningDetails','learningDetails');"></a>
				</div>
				
			</div>
			<%
				}else{
			%>
			<div><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.message")%></div>
			<%
				}
			%>
		</div>
	</div>
</div>
<script type="text/javascript">
    showSubMenu("courseSiderbar");
    addDropZone('attendeeDropzone_0','attendAttachmentId_0','');
    function submitForm(fmId,wrapperInstance1){ 

		var prsnInstancesCount = parseInt(document.getElementById("globalCountId").value); 
		var spCourseId = document.getElementById("spCourseId").value;
		document.getElementById("personaEntryDescId").value = window.<portlet:namespace />persona_description
		.getHTML();
		var personaCourseDesc = document.getElementById("personaEntryDescId").value;
		var isValidate = validateForm("personaInner_0",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate) {
		AUI().use('aui-io-request', function(A){
			startPreLoader("mainContainer");
			A.io.request('${createPersonna}', 
					{ method: 'post', 
						form: { id: fmId }, 
						data:{
							prsnInstancesCount : prsnInstancesCount,
							spCourseId : spCourseId,
							personaCourseDesc:personaCourseDesc
						},
						on: {
							complete : function(){
								stopPreLoader("mainContainer");
							},
							success : function() {
								var data = this.get('responseData');
								if (data) {
									if(typeof data == "string"){
										// response is in string format
										data = JSON.parse(data);
									}
									if(data.error){
										displayError(data.error);
									}else if(data.saveFlag == 'success'){
										displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.persona.updated")%>');
										if(data.process == 'create'){
											courseTabslink('<%=addLearningDetails%>','editLearningDetails','learningDetails');
										}
									}else{
										// This case is very very rare
										displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.persona.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
									}
								} else {
									displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.persona.save.error")%>');
								}
								window.scrollTo(0,0);
							},
							failure : function() {
								displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.persona.save.error")%>');
								window.scrollTo(0,0);
							}
						} 
							
					}); }); 
			}
		} 
    
    function addPersonaInstances(){

		var personaInstances = document.getElementsByClassName("personaWrapper");
		var count = parseInt(document.getElementById("globalCountId").value);
		//var count = personaInstances.length;
		var mainPersonaWrapper = document.getElementById("personaInner_0");
		
		
		//main wrapper
		var personaWrap = createInstanceElements("div","personaWrapper","personaWrapperId_"+count,'','','','','','','','','','','','');
		var secWrap = createInstanceElements("div","form-inner Border Form-padding Form-bg  FormBorder-active",'','','','','','','','','','','','','');
		personaWrap.appendChild(secWrap);
		
		//close Button
		var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId"+count,'','','','','','','','','','','','');
		var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeByInstanceIdWithMandatoryFields("personaWrapperId_'+count+'","<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.persona.required.message")%>")','','','','','','');
		var clsButtonImg = createInstanceElements("img",'','','','','','','','','/SPProduct-portlet/images/Product_create/Close-icon.svg','','','','','');
		clsButtonSpan.appendChild(clsButtonImg);
		clsButtonDiv.appendChild(clsButtonSpan);
		secWrap.appendChild(clsButtonDiv); //added button to schedule instance 
		
		//persona fields wrap
		var personaFieldsWrap = createInstanceElements("div","form-summary-inner",'','','','','','','','','','','','','');
		
		 //progressionCategory
        var personaTypeoptionlist = document.getElementById("personaTypeListId").innerHTML;
        var selpersonaType = createInstanceElements("div","Input_HalfWidth ",'','','','','','','','','','','','','');
		var selpersonaTypediv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
		var selectPersonaType = createInstanceElements("select",'',"personaTypeListId_"+count,"personaTypeList_"+count,'','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.personaType")%> *','','','','',true,'','',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>');
		selectPersonaType.innerHTML = personaTypeoptionlist;
		selpersonaTypediv.appendChild(selectPersonaType);
		selpersonaType.appendChild(selpersonaTypediv);
		personaFieldsWrap.appendChild(selpersonaType);
		
		//personna description
		 var attendDesc = createInstanceElements("div","Input_Fullwidth margin-20-topbottom",'','','','','','','','','','','','','');
		 var attendTareadiv = createInstanceElements("div","Admin-textarea",'','','','','','','','','','','','','');
       var attendDescTarea = createInstanceElements("textarea",'',"personaAttendanceDescId_"+count,'personaAttendanceDesc_'+count,'text','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.personaDescription")%>*','360','','','','','','','','');
       attendTareadiv.appendChild(attendDescTarea);
       var msgDiv = createInstanceElements("div","footNoteMsg",'','','','','','','','','','','','','');
       msgDiv.innerHTML = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.description.maxChars")%>';
       attendDesc.appendChild(attendTareadiv);
       attendDesc.appendChild(msgDiv);
       personaFieldsWrap.appendChild(attendDesc);//added attendies description
       
     
	    
	    //personna file upload
	     var attendFile = createInstanceElements("div","Input_Fullwidth",'','','','','','','','','','','','','');
       var div1 = createInstanceElements("div","Image_upload","_uploadImageVal_"+count,'','','','','','','','','','','','');
       var dropZoneid = "_attendeeDropzone_"+count;
       var div2 = createInstanceElements("div","",dropZoneid,'','','','','','','','','','','','');
       var imageValueId = "attendAttachmentId_"+count;
       var imageValueIP = createInstanceElements("input","imageField",imageValueId,"attendAttachment_"+count,'hidden','','','','','','','','','','');
       imageValueIP.value="0";
	     div1.appendChild(div2);
	     div1.appendChild(imageValueIP);
	     attendFile.appendChild(div1);
	     personaFieldsWrap.appendChild(attendFile); //added attend file upload	
		
		//append all
		secWrap.appendChild(personaFieldsWrap);
		personaWrap.appendChild(secWrap);
		mainPersonaWrapper.appendChild(personaWrap);
		addDropZone(dropZoneid,imageValueId);
		document.getElementById("globalCountId").value = count + 1;
    }
    
    </script>
