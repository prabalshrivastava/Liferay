<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">

		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>
		
		<div class="Right_content_section">
			<div class="Border">
				<div class="heading-title Border-bottom">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.summary")%></h2>
					<a href="#" class="Button-green-Header "><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.publish")%></a> <a href="#"
						class="Header-icon"><img
						src="<%=request.getContextPath()%>/images/Product_create/shapes1.svg"></a>
					<a href="#" class="Header-icon"><img
						src="<%=request.getContextPath()%>/images/Product_create/shapes2.svg"></a>
				</div>
				<div class="form-section">
					<!--****PRODUCT DATA***-->
					<div class="form-summary ">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.product")%></h2>

						<div class="form-summary-inner Summary_input">
							<div class="Input_small">
								<input type="text" disabled name="productValueName" id="productValueNameId" value="${productWrapper.product.productCode}" placeholder="">
							</div>
							<div class="Input_Medium">
								<input type="text" disabled name="productValueTitle" id="productValueTitleId" value="${productWrapper.product.productName}" placeholder="">
							</div>
							<div class="Image_summary">
								<div class="image_div">
									<img
										src="<%=request.getContextPath()%>/images/Product_create/Icon-Product.svg">
								</div>
							</div>
							<div class="Input_HalfWidth Margin-20">
								<div class="select_style" id="productTypeSelectId">
									<select disabled id="productDataTypeId" name="productDataType">
										<option><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.product.type")%>*</option>
										<option><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.product.type1")%></option>
										<option><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.product.type2")%></option>
										<option><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.product.type3")%></option>
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth">
								<input type="text" disabled name="productDataCvs" id="productDataCvsId" value="5" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.cvs.value")%>">
								<div class="icon-right">Cvs</div>
							</div>
						</div>
					</div>
					<!--****PRODUCT DATA END***-->

					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.course.details")%></h2>

						<div class="form-summary-inner Summary_input">
							<div class="Input_small">
								<input type="text" disabled name="summaryCourse" id="summaryCourseId" value="${productWrapper.course.courseCode}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseId")%>">
							</div>
							<div class="Input_Medium">
								<input type="text" disabled name="summaryCourseName" id="summaryCourseNameId" value="${productWrapper.course.courseName}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseName")%>*">
							</div>
							<div class="Input_Fullwidth margin-20-topbottom">
								<label>Display Course name :</label> 
								<c:choose>
								<c:when test="${productWrapper.course.displayCourseName}">
										<label>Yes</label>
								</c:when>
								<c:otherwise>
									<label> No</label>
								</c:otherwise>
							</c:choose>
							</div>
							<div class="Input_Fullwidth margin-20-topbottom">
								<div class="Admin-textarea">
									<textarea name="summaryCourseDesc" disabled id="summaryCourseDescId" value="course description" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDescription")%>">"${productWrapper.course.courseDesc}"</textarea>
								</div>
							</div>
							<div class="Input_HalfWidth Margin-20">
								<input type="text" name="summaryCourseMonth" disabled id="summaryCourseMonthId" value="${productWrapper.course.courseDuration}"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDuration")%>*">
								<div class="icon-right">month(s)</div>
							</div>
							<div class="Input_HalfWidth">
								<input type="text" name="summaryLearningDuration" disabled id="summaryLearningDurationId" value="${productWrapper.course.learningDuration}"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.learningDuration")%>*">
							</div>
							<div class="Input_HalfWidth Margin-20">
								<input type="text" name="summaryComplexityLevel" disabled id="summaryComplexityLevelid" value="${productWrapper.course.complexityLevel}"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.complexityLevel")%>*">
							</div>
							<div class="Input_HalfWidth">
								<div class="select_style" id="summaryCourseTypeSelectId">
									<select disabled id="summaryCourseTypeId" name="summaryCourseType">
									<c:forEach  var="courseType" items="${courseTypeList}">
										<c:if test="${productWrapper.course.courseType == courseType.categoryId}">
											<option  value="${courseType.categoryId}" selected>${courseType.name}</option>
										</c:if>
									</c:forEach>
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth Margin-20">
								<div class="select_style" id="summaryCourseCountrySelectId">
									<select disabled id="summaryCourseCountryId" name="summaryCourseCountry">
									<c:forEach var="country" items="${countryList}">
										<c:if test="${productWrapper.course.countryId == country.categoryId}"> 
											<option value="${country.categoryId}" selected>${country.name}</option>
										</c:if>
									</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth margin-20-topbottom">
								<label><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.frameworkApprovalStatus")%></label> 
								<c:choose>
								<c:when test="${productWrapper.course.frameworkApprovalStatus}">
										<label><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.yes")%></label>
								</c:when>
								<c:otherwise>
									<label> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.no")%></label>
								</c:otherwise>
							</c:choose>
							</div>
						</div>
					</div>
					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.modules")%></h2>
						<c:forEach var="moduleDetailsList" items="${productWrapper.moduleDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_small">
								<input type="text" disabled name="summaryModuleCode" id="summaryModuleCodeId" value="${moduleDetailsList.value[1] }" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleCode")%>">
								<div class="icon-right">MC</div>
							</div>
							<div class="Input_Medium">
								<input type="text" disabled name="summaryModuleName" id="summaryModuleName" value="${moduleDetailsList.value[2] }" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleName")%>">
							</div>
							<div class="Input_HalfWidth Margin-20">
								<div  class="select_style" id="summaryModuleTypeSelectId">
									<select disabled id="summaryCountryId" name="summaryCountry">
									<c:forEach var="country" items="${countryList}">
										<c:if test="${moduleDetailsList.value[3]  ==  country.categoryId}">
											<option value="${country.categoryId}" selected>${country.name}</option>
										</c:if>
									</c:forEach>
									</select> 
								</div>
							</div>
							<div class="Input_Fullwidth margin-20-topbottom">
								<div class="Admin-textarea">
									<textarea disabled name="summaryModuleDescId" value="${moduleDetailsList.value[4] }" id="summaryModuleDescId" disabled placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleDescription")%>"></textarea>
								</div>
							</div>
							<div class="Input_HalfWidth Margin-20">
								<div class="select_style" id="summaryModuleTypeSelectId">
									<select disabled id="summaryModuleTypeId" value="summaryModuleType">
										<c:forEach var="moduleType" items="${moduleTypeList}">
											<c:if test="${moduleDetailsList.value[5] ==  moduleType.categoryId}">
												<option value="${moduleType.categoryId}" selected>${moduleType.name}</option>
											</c:if>
										</c:forEach>
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth ">
								<input disabled type="text" name="summaryModuleCredits" id="summaryModuleCreditsId"  value="${moduleDetailsList.value[6] }" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.credits")%>*">
								<div class="icon-right">CVs</div>
							</div>
							<div class="Input_HalfWidth Margin-20">
								<input type="text" disabled name="summaryModuleDuration" id="summaryModuleDurationId"  value="${moduleDetailsList.value[7] }" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.duration")%>*">
								<div class="icon-right">Hr(s)</div>
							</div>
							<div class="Input_HalfWidth ">
								<input type="text" disabled name="summaryModuleSession" id="summaryModuleSessionId"  value="${moduleDetailsList.value[8] }"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessions")%>*">
								<div class="icon-right"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sessions")%></div>
							</div>
						</div>
						</c:forEach>
					</div>
					
					<!-- Outline -->
					 <c:forEach var="outlineDetailsList" items="${productWrapper.outlineDetailsList}">
					 <c:if test="${!empty outlineDetailsList.value[1] }">
					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.outline ")%></h2>

						<div class="form-summary-inner Summary_input">
							<div class="Input_Fullwidth">
								<div class="select_style" id="summaryOutlineSelectId">
									<select disabled  id="summaryOutlineTypeId" name="summaryOutlineType">
									<c:forEach var="outlineType" items="${outlineTypeList}">
											<c:if
												test="${outlineDetailsList.value[3] == outlineType.categoryId}">
												<option value="${outlineType.categoryId}" selected>${outlineType.name}</option>
											</c:if>
										</c:forEach>
									</select> 
								</div>
							</div>
							<c:if test="${outlineDetailsList.value[0] != 'Skill' }">
							<div class="Input_Fullwidth ">
								<div class="Admin-textarea">
									<textarea disabled name="summaryOutlineDesc" id="summaryOutlineDescId"
										placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.outlineDescription")%>">${outlineDetailsList.value[2]}</textarea>
								</div>
							</div>
							</c:if>
							<c:if test="${outlineDetailsList.value[0] == 'Skill' }">
								
									<div class="multiple-select" id="outlineType_select">
										<ul>
											${outlineDetailsList.value[1] }
											
										</ul> <span></span>
									</div>
								
							</c:if>	
						</div>
					</div>
					</c:if>
					</c:forEach>
					<!-- Certificates -->
					
					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.certificate")%></h2>
 						<c:forEach var="certificateDetailsList" items="${productWrapper.certificateDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Admin-textarea">
								<textarea disabled name="summaryCertificateDesc" id="summaryCertificateDescId"  placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.certifcateDescription")%>">${certificateDetailsList.value[2] }</textarea>
							</div>
							<div class="Input_small">
								<input type="text" disabled name="summaryCertificate" id="summaryCertificateId" value="${certificateDetailsList.value[0] }" placeholder="001">
							</div>
							<div class="Input_Medium">
								<input type="text" disabled name="summaryCertificateName" id="summarycertificateNameId"
									value="${certificateDetailsList.value[1] }">
							</div>
							<div class="Input_HalfWidth Margin-20">
								<div class="select_style" id="summaryCertificateLevelSelect">
									<select disabled id="summaryCertificateLevelId" name="summaryCertificateLevel">
										<c:forEach var="certificateLevel" items="${certificateLevelList}">
										<c:if test="${certificateDetailsList.value[3]  == certificateLevel.categoryId}">
											<option value="${certificateLevel.categoryId}" selected>${certificateLevel.name}</option>
										</c:if>
									</c:forEach>
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth">
								<input type="text" disabled name="summaryCertificateModule" id="summaryCertificateModuleId" value="${certificateDetailsList.value[5]}" placeholder="Module Name*">
							</div>
							<div class="Input_HalfWidth Margin-20">
								<div class="select_style" id="summaryCertificateTypeSelectId">
									<select disabled id="summaryCertificateTypeId" name="summaryCertificateType">
										<c:forEach var="certificateTypes" items="${certificateTypeList}">
											<c:if test="${certificateDetailsList.value[4] == certificateTypes.categoryId}">
												<option value="${certificateTypes.categoryId}" selected>${certificateTypes.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth">
								<input type="text" disabled name="summaryCertificateFile" id="summaryCertificateFileId" value="File"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.atatchCertificate")%>">
								<div class="Attachment_Icon">
									<a href="#"><img
										src="<%=request.getContextPath()%>/images/Product_create/clip.svg"
										alt="Attach Icon"></a>
								</div>
							</div>
							<div class="Admin-textarea">
								<textarea disabled name="summaryCertificateNotes" id="summaryCertificateNotes"  placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.generalNotes")%>">${certificateDetailsList.value[6]}</textarea>
							</div>
						</div>
						</c:forEach>
					</div>
					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.persona")%></h2>
					<c:forEach var="personaDetailsList" items="${productWrapper.personaDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_small">
								<input type="text" disabled name="summaryPersonaCode" id="summaryPersonaCodeId" value="Persona Code" placeholder="#">
							</div>
							<div class="Input_Medium">
								<div class="select_style" id="summaryPersonaTypeSelect">
									<select disabled id="summaryPersonaTypeId" name="summaryPersonaType">
										<c:forEach var="personaTypeList" items="${personaTypeList}">
                                                    	<c:if test="${personaDetailsList.value[1] ==  personaTypeList.categoryId}">
															<option value="${personaTypeList.categoryId}" selected>${personaTypeList.name}</option>
														</c:if>
										</c:forEach>				
									</select> 
								</div>
							</div>
							<div class="Input_small">
								<input type="text" disabled name="summaryPersonaAge" id="summaryPersonaAgeId" value="${personaDetailsList.value[2]}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.ageGroup")%>*">
							</div>
							<div class="Admin-textarea">
								<textarea name="summaryPersonaEntry" id="summaryPersonaEntryId" disabled placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.entryDescription")%>">${personaDetailsList.value[0]}</textarea>
							</div>
							<c:forEach var="attendeeDetailsList" items="${productWrapper.attendeeDetailsList}">
							<c:if test="${attendeeDetailsList.value[1] == personaDetailsList.value[3]}">
								<div class="Admin-textarea">
									<textarea name="summaryPersonaWho" id="summaryPersonaWhoId" disabled placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.attendDescription")%>">${attendeeDetailsList.value[0] }</textarea>
								</div>
								<div class="Image_upload">
									<div class="image_div">
										<img
											src="${attendeeDetailsList.value[1] }">
									</div>
								</div>
							</c:if>
							</c:forEach>
						</div>
						</c:forEach>
					</div>
					<%-- <div class="form-summary">
						<h2>Progression Paths & Job Roles</h2>
					<c:forEach var="personaDetailsList" items="${productWrapper.progressionDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_Smallexd margin-right-22">
								<input type="text" disabled  name="summaryProgressLevel" id="summaryProgressLevelId" value="${personaDetailsList.value[0] }" placeholder="Level">
							</div>
							<div class="Input_Smallexd margin-right-22 ">
								<input type="text" disabled name="summaryProgressSequence" id="summaryProgressSequenceId" value="${personaDetailsList.value[1] }" placeholder="Sequence ID">
							</div>
							<div class="Input_HalfWidth ">
								<div class="select_style" id="CareerLevel1_select">
									<select disabled name="summaryProgressCareerLevelId" id="summaryProgressCareerLevelId">
										<c:forEach var="careerLevel" items="${careerLevelList}">
											<c:if test="${personaDetailsList.value[1] == careerLevel.categoryId}">
												<option value="${careerLevel.categoryId}" selected>${careerLevel.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth-right margin-right-22">
								<div class="select_style" id="ProgressionType1_select">
									<select disabled name="summaryProgressType" id="summaryProgressTypeId">
										<c:forEach var="progressionType" items="${progressionTypeList}">
											<c:if test="${personaDetailsList.value[2] == progressionType.categoryId}">
												<option value="${progressionType.categoryId}" selected>${progressionType.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth-right">
								<div class="select_style" id="ProgressionCategory1_select">
									<select disabled name="summaryProgressCategory" id="summaryProgressCategory">
										<c:forEach var="progressionCategoryList" items="${progressionCategoryList}">
											<c:if test="${personaDetailsList.value[3] == progressionCategoryList.categoryId}">
												<option value="${progressionCategoryList.categoryId}" selected>${progressionCategoryList.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth margin-right-22">
								<input disabled type="text" name="summaryProgressSm" id="summaryProgressSmId" value="${personaDetailsList.value[4] }"
									placeholder="Starting Month of Progression*">
							</div>
							<div class="Input_HalfWidth ">
								<input disabled type="text" name="summaryProgressEm" id="summaryProgressEmId" value="${personaDetailsList.value[5] }"
									placeholder="Ending Month of Progression*">
							</div>
							<div class="Input_HalfWidth margin-right-22">
								<input disabled type="text" name="summaryProgressmonth" id="summaryProgressmonthId" value="${personaDetailsList.value[6] }" placeholder="Duration*">
								<div class="icon-right">month(s)</div>
							</div>
							<br>
							<div class="Input_HalfWidth margin-right-22">
								<input disabled type="text" name="summaryProgressOl2" id="summaryProgressOl1Id" value="${personaDetailsList.value[7] }"
									placeholder="Optional Level / Sequence*">
							</div>
						</div>
						</c:forEach>
					</div> --%>
					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.graduationcriteria")%></h2>
						<c:forEach var="graduationCriteriaDetailsList" items="${productWrapper.graduationCriteriaDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_HalfWidth margin-right-22">
								<div class="select_style" id="CriteriaType2_select">
									<select disabled name="summaryGradType" id="summaryGradTypeId">
										<c:forEach var="criteriaType" items="${criteriaTypeList}">
											<c:if test="${graduationCriteriaDetailsList.value[2]  == criteriaType.categoryId }">
												<option value="${criteriaType.categoryId}" selected>${criteriaType.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth">
								<div class="select_style" id="CriteriaLevel2_select">
									<select disabled name="summaryGradLevel" id="summaryGradLevelId">
										<c:forEach var="criteriaLevel" items="${criteriaLevelList}">
											<c:if test="${graduationCriteriaDetailsList.value[3] == criteriaLevel.categoryId }">
												<option value="${criteriaLevel.categoryId}" selected>${criteriaLevel.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_Fullwidth">
								<input type="text" disabled name="summaryGradCriteriaValue" id="summaryGradCriteriaValueId" value="${graduationCriteriaDetailsList.value[1] }"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaValue")%>*">
							</div>
							<div class="Admin-textarea">
								<textarea disabled name="summaryGradCriteria" id="summaryGradCriteriaId"  placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaExp")%>">${graduationCriteriaDetailsList.value[0] }</textarea>
							</div>
						</div>
						</c:forEach>
					</div>
					<div class="form-summary">
						<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.feesfunding")%></h2>
						<c:forEach var="fundingDetailsList" items="${productWrapper.fundingDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_Smallexd margin-right-22">
								<div class="select_style" id="CourseType2_select">
									<select disabled id="summaryFundCoursetypeId" name="summaryFundCoursetypeId">
										<c:forEach var="courseType" items="${courseTypeList}">
											<c:if test="${fundingDetailsList.value[3] == courseType.categoryId}">
												<option value="${courseType.categoryId}" selected>${courseType.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_Smallexd margin-right-22">
								<div class="select_style" id="Sponsored1_select">
									<select disabled id="summaryFundSponseredId" name="summaryFundSponseredId">
										<c:forEach var="sponsoredBy" items="${sponsoredByList}">
											<c:if test="${fundingDetailsList.value[4] == sponsoredBy.categoryId}">
												<option value="${sponsoredBy.categoryId}" selected>${sponsoredBy.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_HalfWidth ">
								<div class="select_style" id="Sponsored1_select">
									<select disabled id="summaryFundResidentialId" name="summaryFundResidentialId">
										<c:forEach var="residentialStatus" items="${residentialStatusList}">
											<c:if test="${fundingDetailsList.value[5] == residentialStatus.categoryId}">
												<option value="${residentialStatus.categoryId}" selected>${residentialStatus.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Breakline"></div>
							<div class="Input_Smallexd  margin-right-22">
								<input disabled  type="text" name="summaryFundAge" id="summaryFundAgeId" placeholder="Age*" value="${fundingDetailsList.value[1] }">
							</div>
							<div class="Input_Smallexd margin-right-22">
								<input disabled type="text" name="summaryFundEarning" id="summaryFundEarningId" value="${fundingDetailsList.value[6] }"
									placeholder="Earning Status*">
							</div>
							<div class="Input_Smallexd margin-right-22">
								<input disabled type="text" name="summaryFundSalary" id="summaryFundSalaryId" value="${fundingDetailsList.value[7] }"
									placeholder="Salary / Month*">
							</div>
							<div class="Input_Smallexd ">
								<input disabled type="text" name="summaryFundCoursefee" id="summaryFundCoursefeeId" value="${fundingDetailsList.value[2] }"
									placeholder="Course Fee Funding*">
							</div>
							<div class="Input_Smallexd margin-right-22">
								<input disabled type="text" name="summaryFundHour" id="summaryFundHourId" value="${fundingDetailsList.value[8] }"
									placeholder="Funding / hour*">
							</div>
							<div class="Input_Smallexd margin-right-22">
								<input disabled type="text" name="summaryFundAmount" id="summaryFundAmountId" value="${fundingDetailsList.value[9] }"
									placeholder="Funding Amount*">
							</div>
							<div class="Input_Smallexd margin-right-22">
								<input disabled type="text" name="summaryFundNetfee" id="summaryFundNetfeeId" value="${fundingDetailsList.value[10] }" placeholder="Net Fees*">
							</div>
							<div class="Input_Smallexd ">
								<input disabled type="text" name="summaryFundPayroll" id="summaryFundPayrollId" value="${fundingDetailsList.value[11] }"
									placeholder="Absentee Payroll Funding">
							</div>
						</div>
						</c:forEach>
					</div>
					<div class="form-summary">
						<h2>Fee Details</h2>

						<div class="form-inner Border Form-pop-padding bg_title ">
							<div class="Table-form Summary_input">
								<table>
									<thead>
										<tr>
											<th class="cellwidth2 ">Fee Component type</th>
											<th class="cellwidth3 ">Fee Description</th>
											<th class="cellwidth4 ">Calculation Base</th>
											<th class="cellwidth5 ">Amount</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="feeDetailsList" items="${productWrapper.feeDetailsList}">
										<tr>
											<td class="cellwidth2 ">
												<div class="select_style" id="Fullfees1_select">
													<select disabled id="summaryFeeFullfeeId" name="summaryFeeFull">
														<c:forEach var="careerLevel" items="${careerLevelList}">
		                                                    <c:if test="${feeDetailsList.value[2] == careerLevel.categoryId }">
																<option value="${careerLevel.categoryId}" selected>${careerLevel.name}</option>
															</c:if>
														</c:forEach>	
													</select> 
												</div>
											</td>
											<td class="cellwidth3 ">${feeDetailsList.value[3]}
											</td>
											<td class="cellwidth4 ">${feeDetailsList.value[4]}</td>
											<td class="cellwidth5 ">${feeDetailsList.value[1]}.</td>
										</tr>
									</c:forEach>	
									</tbody>
									<tfoot>
										<tr>
											<th class="cellwidth2 ">&nbsp;</th>
											<th class="cellwidth3 ">&nbsp;</th>
											<th class="cellwidth4 ">Total Fees</th>
											<th class="cellwidth5 ">${feeDetailsList.value[5]}</th>
										</tr>
									</tfoot>
								</table>
							</div>
							<div class="Input_Fullwidth margin-20-topbottom Summary_input">
								<div class="Admin-textarea">
									<textarea disabled name="summaryFeeNotes" id="summaryFeeNotesId" placeholder="General Notes">${productWrapper.course.feeDetailsDesc}</textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="form-summary">
						<h2>Outcomes</h2>
						<c:forEach var="outcomeDetailsList" items="${productWrapper.outcomeDetailsList}">
						<div class="form-summary-inner">
							<div class="Input_HalfWidth Margin-20">
								<input disabled type="text" name="summaryOutcomeCoc" id="summaryOutcomeCocId" value="${outcomeDetailsList.value[2] }" placeholder="#">
								<div class="icon-right">COC</div>
							</div>
							<div class="Input_HalfWidth ">
								<div class="select_style" id="Producttype1_select">
									<select disabled name="summaryOutcomeType" id="summaryOutcomeTypeId">
										<c:forEach var="outcomeType" items="${outcomeTypeList}">
											<c:if test="${outcomeDetailsList.value[3] == outcomeType.categoryId }">
												<option value="${outcomeType.categoryId}" selected>${outcomeType.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_Fullwidth Summary_input">
								<div class="Admin-textarea">
									<textarea name="summaryOutcomeDesc" id="summaryOutcomeDescId" placeholder="Outcome Description" disabled>${outcomeDetailsList.value[1] }</textarea>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
					<div class="form-summary">
						<h2>Competency Units</h2>
						<c:forEach var="competencyDetailsList" items="${productWrapper.competencyDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_HalfWidth Margin-20">
								<input disabled type="text" name="summaryCuUnitcode" id="summaryCuCvsUnitcodeId" value="${competencyDetailsList.value[0] }"
									placeholder="Competency Unit Code *">
								<div class="icon-right">CUC</div>
							</div>
							<div class="Input_HalfWidth ">
								<div class="select_style" id="competencyTypeSelect">
									<select disabled name="summaryCuLevel" id="summaryCuLevelId">
										<c:forEach var="competencyLevel" items="${competencyLevelList}">
											<c:if test="${competencyDetailsList.value[1] == competencyLevel.categoryId}">
												<option value="${competencyLevel.categoryId}" selected>${competencyLevel.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_Fullwidth">
								<div class="Admin-textarea">
									<textarea name="summaryCuCvsDesc" id="summaryCuCvsDescId" placeholder="Competency Unit Description" disabled>${competencyDetailsList.value[2] }</textarea>
								</div>
							</div>
							<div class="Input_HalfWidth Margin-20">
								<input disabled type="text" name="summaryCuCvs" id="summaryCuCvsId" value="${competencyDetailsList.value[3] }" placeholder="Credits*">
								<div class="icon-right">CVs</div>
							</div>
							<div class="Input_HalfWidth ">
								<div class="select_style" id="Producttype1_select">
									<select disabled name="summaryCuJob" id="summaryCuJobId">
										<c:forEach var="jobFamily" items="${jobFamilyList}">
											<c:if test="${competencyDetailsList.value[4]  == jobFamily.categoryId}">
												<option value="${jobFamily.categoryId}" selected>${jobFamily.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
							<div class="Input_Search_halfwidth Margin-20 hidden ">
								<input disabled type="text" name="summaryCuFile" id="summaryCuFileId" value="Files"
									placeholder=" Add a framework">
								<div class="search_icon">
									<img
										src="<%=request.getContextPath()%>/images/Product_create/search.svg">
								</div>
								<div class="Searchclose_button">
									<a href="#"><img
										src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
										alt="Close"></a>
								</div>
							</div>
							<div class="Input_HalfWidth ">
								<div class="select_style" id="Producttype1_select">
									<select disabled name="summaryCuCountry" id="summaryCuCountryId">
										<c:forEach var="country" items="${countryList}">
											<c:if test="${competencyDetailsList.value[5] == country.categoryId}">
												<option value="${country.categoryId}" selected>${country.name}</option>
											</c:if>
										</c:forEach>	
									</select> 
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
					<div class="form-summary">
						<h2>Framework</h2>
						<c:forEach var="frameworkDetailsList" items="${productWrapper.frameworkDetailsList}">
						<div class="form-summary-inner Summary_input">
							<div class="Input_small">
								<input disabled type="text" name="summaryFrameCode" id="summaryFrameCodeId" value="${frameworkDetailsList.value[0] }" placeholder="Framework Code">
							</div>
							<div class="Input_Medium">
								<input disabled type="text" name="summaryFrameName" id="summaryFrameNameId" value="${frameworkDetailsList.value[1] }"
									placeholder="Framework Name*">
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="Right_bottom">
				<a href="#">Cancel</a> <a href="#">Publish</a>
				<div class="Next-icon">
					<a href="Product_create.html"></a>
				</div>
				<div class="Prev-icon">
					<a href="Product_create.html"></a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
showSubMenu("productSiderbar");
</script>
