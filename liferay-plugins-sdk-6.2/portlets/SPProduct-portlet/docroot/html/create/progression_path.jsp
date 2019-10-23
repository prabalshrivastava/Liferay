<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
	String courseDescriptionLabel = "Course Description";
	courseDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.course.courseDescription");
	String spCourseId = request.getParameter("spCourseId"); 
%>

<portlet:resourceURL var="createProgessionPath">
	<portlet:param name="action" value="addProgessionPath"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">
		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>

		<div class="Right_content_section">
			<%
				if (Validator.isNotNull(spCourseId)) {
			%>
			<div class="Border" id="mainContainer">
				<div class="heading-title Border-bottom">
					<h2>Progression Paths / Job Roles</h2>

				</div>



				<div class="form-section ">
					<div class="Input_Fullwidth text-right Progression_click">
						<div class="Add_button">
							<a href="javascript:addProgressionInstances()"
								class="Button-green button-pos-right">Add More</a>
						</div>
					</div>
					<form action="#" method="POST" id="progressionFormId"
						name="progressionForm">
						<div id="progressionInner_0">
							<c:if test="${!empty progressionPathDetail }">
								<%@ include file="/html/create/progression_path_edit.jsp"%>
							</c:if>
							<c:if test="${empty progressionPathDetail }">
								<div class="prog_Wrapper" id="progWrapperId_0">
									<div
										class="form-inner Border Form-pop-padding Form-bg FormBorder-active">
										<div class="close_button">
											<span onclick="javascript:removeByInstanceId('progWrapperId_0');"><img
												src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
												alt="Close"></span>
										</div>

										<div class="form-summary-inner ">
											<input type="hidden" id="spCourseId" name="spCourseId"
												value="<%=spCourseId%>">
											<div class="Input_Smallexd margin-right-22">
												<input type="text" name="progressionLevel_0"
													id="progressionLevelId_0"
													value="${progressionPathList.level }" placeholder="Level"
													class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Level*', ' is required');">
											</div>
											<div class="Input_Smallexd margin-right-22 ">
												<input type="text" name="progressionSequence_0"
													id="progressionSequenceId_0"
													value="${progressionPathList.careerLevel }"
													placeholder="Sequence ID" class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Sequence ID*', ' is required');">
											</div>
											<div class="Input_HalfWidth">
												<div class="select_style">
													<select id="progressionCareerLevelId_0"
														name="progressionCareerLevel_0" class="Requiredfield"
														onblur="requiredFieldValidation(this, 'Career Level*', ' is required');">
														<option selected disabled value="0">Career Level*</option>
														<c:forEach var="careerLevel" items="${careerLevelList}">
															<c:if
																test="${progressionPathList.careerLevel == careerLevel.categoryId}">
																<option value="${careerLevel.categoryId}" selected>${careerLevel.name}</option>
															</c:if>
															<c:if
																test="${progressionPathList.careerLevel != careerLevel.categoryId}">
																<option value="${careerLevel.categoryId}">${careerLevel.name}</option>
															</c:if>
														</c:forEach>
													</select> 
												</div>
											</div>
											<div class="Input_HalfWidth-right Margin-20">
												<div class="select_style">
													<select id="progressionCareerTypeId_0"
														name="progressionCareerType_0" class="Requiredfield"
														onblur="requiredFieldValidation(this, 'Progression Type*', ' is required');">
														<option selected disabled value="0">Progression
															Type*</option>
														<c:forEach var="progressionType"
															items="${progressionTypeList}">
															<c:if
																test="${progressionPathList.progressionType == progressionType.categoryId}">
																<option value="${progressionType.categoryId}" selected>${progressionType.name}</option>
															</c:if>
															<c:if
																test="${progressionPathList.progressionType != progressionType.categoryId}">
																<option value="${progressionType.categoryId}">${progressionType.name}</option>
															</c:if>
														</c:forEach>
													</select> 
												</div>
											</div>
											<div class="Input_HalfWidth-right">
												<div class="select_style">
													<select id="progressionCategoryId_0"
														name="progressionCategory_0" class="Requiredfield"
														onblur="requiredFieldValidation(this, 'Progression Category*', ' is required');">
														<option selected disabled value="0">Progression
															Category*</option>
														<c:forEach var="progressionCategoryList"
															items="${progressionCategoryList}">
															<c:if
																test="${progressionPathList.progressionCategory == progressionCategoryList.categoryId}">
																<option value="${progressionCategoryList.categoryId}"
																	selected>${progressionCategoryList.name}</option>
															</c:if>
															<c:if
																test="${progressionPathList.progressionCategory != progressionCategoryList.categoryId}">
																<option value="${progressionCategoryList.categoryId}">${progressionCategoryList.name}</option>
															</c:if>
														</c:forEach>
													</select> 
												</div>
											</div>
											<div class="Input_HalfWidth Margin-20">
												<input type="text" name="progressionStMo_0"
													id="progressionStMoId_0"
													value="${progressionPathList.startMonth }"
													placeholder="Starting Month of Progression*"
													class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Starting Month of Progression*', ' is required');">
											</div>
											<div class="Input_HalfWidth ">
												<input type="text" name="progressionEnddMo_0"
													id="progressionEnddMoId_0"
													value="${progressionPathList.endMonth }"
													placeholder="Ending Month of Progression*"
													class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Ending Month of Progression*', ' is required');">
											</div>
											<div class="Input_HalfWidth Margin-20">
												<input type="text" name="progressionDuration_0"
													id="progressionDurationId_0"
													value="${progressionPathList.duration }"
													placeholder="Duration*" class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Duration*', ' is required');">
												<div class="icon-right" id="monthofspan_0">month(s)</div>
											</div>
											<div class="Input_HalfWidth margin-right-22">
												<input type="text" name="progressionOptLevela_0"
													id="progressionOptLevelaId_0"
													value="${progressionPathList.optionalMandatory }"
													placeholder="Optional Level / Sequence*"
													class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Optional Level / Sequence*', ' is required');">
											</div>
											<!-- <div class="Input_HalfWidth ">
												<input type="text" name="progressionOptLevelb_0"
													id="progressionOptLevelbId_0" value=""
													placeholder="Optional Level / Sequence*"
													class="Requiredfield"
													onblur="requiredFieldValidation(this, 'Optional Level / Sequence*', 'This field is required');">
											</div> -->
										</div>
									</div>
								</div>
							</c:if>
						</div>
					</form>
				</div>
			</div>
			<div class="Right_bottom">
				<a href="<%=listCourse %>">Cancel</a>
				<a href="#"
					onclick="submitForm('progressionFormId','prog_Wrapper')">Save
					Changes</a>
				<div class="Prev-icon">
					<a href=""></a>
				</div>
				<div class="Next-icon">
					<a href=""></a>
				</div>
			</div>
			<%
				} else {
			%>
			<div>Please create a course.</div>
			<%
				}
			%>
		</div>
	</div>
</div>

<script type="text/javascript">
	 showSubMenu("courseSiderbar");
     function submitForm(fmId,wrapperInstance1){ 
 		var critInstancesCount = document.getElementsByClassName(wrapperInstance1).length; 
 		var spCourseId = document.getElementById("spCourseId").value;
 		
 		var isValidate = validateForm("progressionInner_0",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
 		if (isValidate) {
 		AUI().use('aui-io-request', function(A){
 			startPreLoader("mainContainer");
 			A.io.request('${createProgessionPath}', 
 					{ method: 'post', 
 						form: { id: fmId }, 
 						data:{
 							critInstancesCount : critInstancesCount,
 							spCourseId : spCourseId
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
										displaySuccess("Progression Path details updated successfully.");
										
									}else{
										// This case is very very rare
										displayError("Error while saving Progression Path details. Please refresh the screen and update");
									}
								} else {
									displayError("Error while saving Progression Path details.");
								}
								window.scrollTo(0,0);
							},
							failure : function() {
								displayError("Error while saving Progression Path details.");
								window.scrollTo(0,0);
							}
						} 
 				}); 
 			}); 
 		}
 	}
    
    function addProgressionInstances(){

		var progressionInstances = document.getElementsByClassName("prog_Wrapper");
		var count = progressionInstances.length;
		var mainprogressionWrapper = document.getElementById("progressionInner_0");
		//main wrapper
		var progressionWrap = createInstanceElements("div","prog_Wrapper","progWrapperId_"+count,'','','','','','','','','','');
		var secWrap = createInstanceElements("div","form-inner Border Form-pop-padding Form-bg FormBorder-active",'','','','','','','','','','','');
		progressionWrap.appendChild(secWrap);
		mainprogressionWrapper.appendChild(progressionWrap);
		
		//close Button
		var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId"+count,'','','','','','','','','','');
		var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeAddedInstance("prog_Wrapper")','','','','');
		var clsButtonImg = createInstanceElements("img",'','','','','','','','','/SPProduct-portlet/images/Product_create/Close-icon.svg','','','');
		clsButtonSpan.appendChild(clsButtonImg);
		clsButtonDiv.appendChild(clsButtonSpan);
		secWrap.appendChild(clsButtonDiv); //added button to Progression instance 
		var progressionFieldsWrap = createInstanceElements("div","form-summary-inner",'','','','','','','','','','','');
		
		//progressionLevel	
		var progressionLevel = createInstanceElements("div","Input_Smallexd margin-right-22",'','','','','','','','','','','');
		var progressionLevelIp = createInstanceElements("input","","progressionLevelId_"+count,'progressionLevel_'+count,'text','level*','','','','',true,'','');
		progressionLevel.appendChild(progressionLevelIp);
		progressionFieldsWrap.appendChild(progressionLevel);//added progressionLevel
		
		//progressionSequence	
		var progressionSequence = createInstanceElements("div","Input_Smallexd margin-right-22",'','','','','','','','','','','');
		var progressionSequenceIp = createInstanceElements("input","","progressionSequenceId_"+count,'progressionSequence_'+count,'text','Sequence ID*','','','','',true,'','');
		progressionSequence.appendChild(progressionSequenceIp);
		progressionFieldsWrap.appendChild(progressionSequence);//added progressionSequence
		
		 //progressionCareerLevel
        var progressionCareerLeveloptionlist = document.getElementById("progressionCareerLevelId_0").innerHTML;
        var selprogressionCareerLevel = createInstanceElements("div","Input_HalfWidth",'','','','','','','','','','','');
		var selprogressionCareerLeveldiv = createInstanceElements("div","select_style",'','','','','','','','','','','');
		var selectCriteriaLevel = createInstanceElements("select",'',"progressionCareerLevelId_"+count,"progressionCareerLevel_"+count,'','Career Level','','','','',true,'','');
		var selectprogressionCareerLevelSpan = createInstanceElements("span",'','','','','','','','','','','','');
		selectCriteriaLevel.innerHTML = progressionCareerLeveloptionlist;
		selprogressionCareerLeveldiv.appendChild(selectprogressionCareerLevelSpan);
		selprogressionCareerLeveldiv.appendChild(selectCriteriaLevel);
		selprogressionCareerLevel.appendChild(selprogressionCareerLeveldiv);
		progressionFieldsWrap.appendChild(selprogressionCareerLevel);
		
		 //ProgressionType
        var ProgressionTypeoptionlist = document.getElementById("progressionCareerTypeId_0").innerHTML;
        var selProgressionType = createInstanceElements("div","Input_HalfWidth-right margin-right-22",'','','','','','','','','','','');
		var selProgressionTypediv = createInstanceElements("div","select_style",'','','','','','','','','','','');
		var selectCriteriaLevel = createInstanceElements("select",'',"progressionCareerTypeId_"+count,"progressionCareerType_"+count,'','Progression Type*','','','','',true,'','');
		var selectProgressionTypeSpan = createInstanceElements("span",'','','','','','','','','','','','');
		selectCriteriaLevel.innerHTML = ProgressionTypeoptionlist;
		selProgressionTypediv.appendChild(selectProgressionTypeSpan);
		selProgressionTypediv.appendChild(selectCriteriaLevel);
		selProgressionType.appendChild(selProgressionTypediv);
		progressionFieldsWrap.appendChild(selProgressionType);
		
		 //progressionCategory
        var progressionCategoryoptionlist = document.getElementById("progressionCategoryId_0").innerHTML;
        var selprogressionCategory = createInstanceElements("div","Input_HalfWidth-right ",'','','','','','','','','','','');
		var selprogressionCategorydiv = createInstanceElements("div","select_style",'','','','','','','','','','','');
		var selectCriteriaLevel = createInstanceElements("select",'',"progressionCategoryId_"+count,"progressionCategory_"+count,'','Progression Category*','','','','',true,'','');
		var selectprogressionCategorySpan = createInstanceElements("span",'','','','','','','','','','','','');
		selectCriteriaLevel.innerHTML = progressionCategoryoptionlist;
		selprogressionCategorydiv.appendChild(selectprogressionCategorySpan);
		selprogressionCategorydiv.appendChild(selectCriteriaLevel);
		selprogressionCategory.appendChild(selprogressionCategorydiv);
		progressionFieldsWrap.appendChild(selprogressionCategory);
		
		//startingMonth 	
		var startingMonth  = createInstanceElements("div","Input_HalfWidth margin-right-22",'','','','','','','','','','','');
		var startingMonthIp = createInstanceElements("input","","progressionStMoId_"+count,'progressionStMo_'+count,'text','Starting Month of Progression*','','','','',true,'','');
		startingMonth.appendChild(startingMonthIp);
		progressionFieldsWrap.appendChild(startingMonth);//added startingMonth
		
		//endMonth 	
		var endMonth  = createInstanceElements("div","Input_HalfWidth",'','','','','','','','','','','');
		var endMonthIp = createInstanceElements("input","","progressionEnddMoId_"+count,'progressionEnddMo_'+count,'text','Ending Month of Progression*','','','','',true,'','');
		endMonth.appendChild(endMonthIp);
		progressionFieldsWrap.appendChild(endMonth);//added startingMonth
		
		//progressionDuration 
		var progressionDSpan = document.getElementById("monthofspan_0").innerHTML;
		var progressionDuration  = createInstanceElements("div","Input_HalfWidth margin-right-22",'','','','','','','','','','','');
		var progressionDurationIp = createInstanceElements("input","","progressionDurationId_"+count,'progressionDuration_'+count,'text','Duration*','','','','',true,'','');
		var progressionDspandiv  = createInstanceElements("div","icon-right",'','','','','','','','','','','');
		progressionDspandiv.innerHTML = progressionDSpan;
		progressionDuration.appendChild(progressionDspandiv);
		progressionDuration.appendChild(progressionDurationIp);
		progressionFieldsWrap.appendChild(progressionDuration);//added progressionDuration
		
		//optionalLevela 	
		var optionalLevela  = createInstanceElements("div","Input_HalfWidth margin-right-22",'','','','','','','','','','','');
		var optionalLevelaIp = createInstanceElements("input","","progressionOptLevelaId_"+count,'progressionOptLevela_'+count,'text','Optional Level / Sequence*','','','','',true,'','');
		optionalLevela.appendChild(optionalLevelaIp);
		progressionFieldsWrap.appendChild(optionalLevela);//added startingMonth
		
		//optionalLevelb 	
		var optionalLevelb  = createInstanceElements("div","Input_HalfWidth ",'','','','','','','','','','','');
		var optionalLevelbIp = createInstanceElements("input","","progressionOptLevelbId_"+count,'progressionOptLevelb_'+count,'text','Optional Level / Sequence1*','','','','',true,'','');
		optionalLevelb.appendChild(optionalLevelbIp);
		progressionFieldsWrap.appendChild(optionalLevelb);//added startingMonth
		
		secWrap.appendChild(progressionFieldsWrap);
		
    }
    
    function removeAddedInstance(instanceClass) {
		var elem = document.querySelectorAll("."+instanceClass)[1];
		elem.parentNode.removeChild(elem);
		return true;
	}
</script>



