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

<portlet:resourceURL var="createGraduationCriteria">
	<portlet:param name="action" value="addGraduationCriteria"></portlet:param>
</portlet:resourceURL>

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
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.graduationCriteria")%></h2>
					<div class="Backtolist-btn"><a href="<%=listCourse%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a></div>
				</div>
				
				<div class="form-section ">
					
					<div class="Input_Fullwidth margin-20-topbottom">
						<div class="Admin-textarea">
							<textarea name="graduationCriteriaTitle" id="graduationCriteriaTitleId"
								placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.graduationCriteriaTitle")%>">${graduationCriteriaTitle}</textarea>
						</div>
					</div>
				
					<div class="Input_Fullwidth text-right Add_Gcretaria_click">
						<div class="Add_button">
							<a href="javascript:addGradInstances()"
								class="Button-green button-pos-right"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.addCriteria")%></a>
						</div>
						<div id="errorMsg-Modal"></div>
					</div>
					<form action="#" method="POST" id="progressionFormId"
						name="progressionForm">
						<div id="gradInner_0">
						<div style="display:none">
										<select id="criteriaTypeId">
														<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.graduationType")%> *</option>
														<c:forEach var="criteriaType" items="${criteriaTypeList}">
															<option value="${criteriaType.categoryId}">${criteriaType.name}</option>
														</c:forEach>
													</select> 
												<select id="criteriaLevelId">
														<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaLevel")%> *</option>
														<c:forEach var="criteriaLevel"
															items="${criteriaLevelList}">
															<option value="${criteriaLevel.categoryId}">${criteriaLevel.name}</option>
														</c:forEach>
													</select> 
													
										</div>
							<c:if test="${!empty graduationCriteriaDetail }">
								<%@ include file="/html/create/graduation_criteria_edit.jsp"%>
							</c:if>
							<c:if test="${empty graduationCriteriaDetail }">
							<input type="hidden" id="globalCountId"  name="globalCountId" value="1">
								<div class="Grad_wrapper" id="gradWrapperId_0">
									<div class="form-inner Border  Form-bg FormBorder-active ">
										<div class="close_button">
											<span onclick="javascript:removeByInstanceIdWithMandatoryFields('gradWrapperId_0','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.required.message")%>');"><img
												src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
												alt="Close"></span>
										</div>
										
										<div class="form-summary-inner" id="newboxes1-2">
											<div class="Input_HalfWidth Margin-20">
												<div class="select_style">
													<select id="criteriaTypeId_0" name="criteriaType_0"
														class="Requiredfield"
														onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.graduationType")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
														<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.graduationType")%> *</option>
														<c:forEach var="criteriaType" items="${criteriaTypeList}">
															<option value="${criteriaType.categoryId}">${criteriaType.name}</option>
														</c:forEach>
													</select> 
												</div>
											</div>
											<div class="Input_HalfWidth">
												<div class="select_style">
													<select id="criteriaLevelId_0" name="criteriaLevel_0"
														class="Requiredfield"
														onblur="requiredFieldValidation(this, 'Criteria Level*', ' is required');">
														<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaLevel")%> *</option>
														<c:forEach var="criteriaLevel"
															items="${criteriaLevelList}">
															<option value="${criteriaLevel.categoryId}">${criteriaLevel.name}</option>
														</c:forEach>
													</select> 
												</div>
											</div>
											<div class="Input_Fullwidth">

												<input type="text" name="criteriaValue_0"
													id="criteriaValueId_0" value=""
													placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaValue")%> *" maxlength="75"
													class="Requiredfield"
													onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaValue")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
											</div>
											<div class="Input_Fullwidth margin-20-topbottom">
												<div class="Admin-textarea">

													<textarea class="gradCriteria" name="gradCriteriaDesc_0"
														id="gradCriteriaDescId_0" maxlength="250"
														placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaDescription")%>"></textarea>

												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</div>
						<div id="Graduation_Append_sec"></div>
					</form>
				</div>

			</div>
			<div class="Right_bottom">
				<a href="<%=listCourse %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a>
				<a href="#"
					onclick="submitForm('progressionFormId','Grad_wrapper')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
				<div class="Prev-icon">
					<a href="javascript:courseTabslink('<%=addCareerDetails%>','editCareerDetails','careerDetails');"></a>
				</div>
				<div class="Next-icon">
					<a href="javascript:courseTabslink('<%=addFunding%>','editFunding','funding');"></a>
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
function addGradInstances(){

	var gradInstances = document.getElementsByClassName("Grad_wrapper");
	var count = parseInt(document.getElementById("globalCountId").value);
	var mainGradWrapper = document.getElementById("gradInner_0");
	//main wrapper
	var gradWrap = createInstanceElements("div","Grad_wrapper","gradWrapperId_"+count,'','','','','','','','','','','','');
	var secWrap = createInstanceElements("div","form-inner Border  Form-bg FormBorder-active",'','','','','','','','','','','','','');
	gradWrap.appendChild(secWrap);
	mainGradWrapper.appendChild(gradWrap);
	
	 
	//close Button
	var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId"+count,'','','','','','','','','','','','');
	var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeByInstanceIdWithMandatoryFields("gradWrapperId_'+count+'","<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.required.message")%>")','','','','','','');
	var clsButtonImg = createInstanceElements("img",'','','','','','','','','/SPProduct-portlet/images/Product_create/Close-icon.svg','','','','','');
	clsButtonSpan.appendChild(clsButtonImg);
	clsButtonDiv.appendChild(clsButtonSpan);
	secWrap.appendChild(clsButtonDiv); //added button to Graduation instance 
	
	//graduation fields wrap
	var gradFieldsWrap = createInstanceElements("div","form-summary-inner",'','','','','','','','','','','','','');
	


	
//grad criteriaTypeselect	
    var cTypeoptionlist = document.getElementById("criteriaTypeId").innerHTML;
    var selCtype = createInstanceElements("div","Input_HalfWidth Margin-20",'','','','','','','','','','','','','');
	var selCdiv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
	var selectCriteriaType = createInstanceElements("select",'',"criteriaTypeId_"+count,"criteriaType_"+count,'','','','','','',true,'','',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>');
	selectCriteriaType.innerHTML = cTypeoptionlist;
	selCdiv.appendChild(selectCriteriaType);
	selCtype.appendChild(selCdiv);
	gradFieldsWrap.appendChild(selCtype);
	
	
 
 //grad criteriaLevelselect	
    var cLeveloptionlist = document.getElementById("criteriaLevelId").innerHTML;
    var selcLevel = createInstanceElements("div","Input_HalfWidth",'','','','','','','','','','','');
	var selcLeveldiv = createInstanceElements("div","select_style",'','','','','','','','','','','');
	var selectCriteriaLevel = createInstanceElements("select",'',"criteriaLevelId_"+count,"criteriaLevel_"+count,'','','','','','',true,'','',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>');
	selectCriteriaLevel.innerHTML = cLeveloptionlist;
	selcLeveldiv.appendChild(selectCriteriaLevel);
	selcLevel.appendChild(selcLeveldiv);
	gradFieldsWrap.appendChild(selcLevel);
	

	//grad value	
	var gradValue = createInstanceElements("div","Input_Fullwidth",'','','','','','','','','','','','','');
	var gradValueIp = createInstanceElements("input","criteriavalue","criteriaValueId_"+count,'criteriaValue_'+count,'text','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaValue")%> *','75','','','',true,'','',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>');
	gradValue.appendChild(gradValueIp);
	gradFieldsWrap.appendChild(gradValue);//added grad value	

	//Grad creteria description
	 var gradDesc = createInstanceElements("div","Input_Fullwidth margin-20-topbottom",'','','','','','','','','','','','','');
	 var gradTareadiv = createInstanceElements("div","Admin-textarea",'','','','','','','','','','','','','');
     var gradDescTarea = createInstanceElements("textarea","gradCriteria","gradCriteriaDescId_"+count,'gradCriteriaDesc_'+count,'text','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaDescription")%>','250','','','','','','','','');
     gradTareadiv.appendChild(gradDescTarea);
     gradDesc.appendChild(gradTareadiv);
     gradFieldsWrap.appendChild(gradDesc);//added grad Desc	
	
	
	secWrap.appendChild(gradFieldsWrap);
	document.getElementById("globalCountId").value = count + 1;
	
}


function submitForm(fmId,wrapperInstance1){ 
	var critInstancesCount = parseInt(document.getElementById("globalCountId").value); 
	var spCourseId = document.getElementById("spCourseId").value;
	var isValidate = validateForm("gradInner_0",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
	if (isValidate) {

	AUI().use('aui-io-request', function(A){
		startPreLoader("mainContainer");
		A.io.request('${createGraduationCriteria}', 
				{ method: 'post', 
					form: { id: fmId }, 
					data:{
						critInstancesCount : critInstancesCount,
						spCourseId : spCourseId,
						graduationCriteriaTitle : document.getElementById("graduationCriteriaTitleId").value
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
									displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.updated")%>');
									if(data.process == 'create'){
										courseTabslink('<%=addFunding%>','editFunding','funding');
									}
								}else{
									// This case is very very rare
									displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
								}
							} else {
								displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.save.error")%>');
							}
							window.scrollTo(0,0);
						},
						failure : function() {
							displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.save.error")%>');
							window.scrollTo(0,0);
						}
					} 
			}); 
		}); 
	}
}
</script>





