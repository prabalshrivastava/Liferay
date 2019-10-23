<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	int i = 0;
%>
<c:forEach var="progressionPathDetail" items="${progressionPathDetail}">
	<div class="prog_Wrapper" id="progWrapperId_<%=i%>">
		<div
			class="form-inner Border Form-pop-padding Form-bg FormBorder-active">
			<div class="close_button">
				<span onclick="javascript:removeByInstanceId('progWrapperId_<%=i%>');"><img
					src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
					alt="Close"></span>

			</div>
			<div class="form-summary-inner ">
				<input type="hidden" id="spCourseId" name="spCourseId"
					value="<%=spCourseId%>">
				<div class="Input_Smallexd margin-right-22">
					<input type="text" name="progressionLevel_<%=i%>"
						id="progressionLevelId_<%=i%>"
						value="${progressionPathDetail.level}" placeholder="Level"
						class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Level*', ' is required');">
				</div>
				<div class="Input_Smallexd margin-right-22 ">
					<input type="text" name="progressionSequence_<%=i%>"
						id="progressionSequenceId_<%=i%>"
						value="${progressionPathDetail.careerLevel}"
						placeholder="Sequence ID" class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Sequence ID*', ' is required');">
				</div>
				<div class="Input_HalfWidth">
					<div class="select_style">
						<select id="progressionCareerLevelId_<%=i%>"
							name="progressionCareerLevel_<%=i%>" class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Career Level*', ' is required');">
							<option selected disabled value="0">Career Level*</option>
							<c:forEach var="careerLevel" items="${careerLevelList}">
								<c:if
									test="${progressionPathDetail.careerLevel == careerLevel.categoryId}">
									<option value="${careerLevel.categoryId}" selected>${careerLevel.name}</option>
								</c:if>
								<c:if
									test="${progressionPathDetail.careerLevel != careerLevel.categoryId}">
									<option value="${careerLevel.categoryId}">${careerLevel.name}</option>
								</c:if>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_HalfWidth-right Margin-20">
					<div class="select_style">
						<select id="progressionCareerTypeId_<%=i%>"
							name="progressionCareerType_<%=i%>" class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Progression Type*', ' is required');">
							<option selected disabled value="0">Progression Type*</option>
							<c:forEach var="progressionType" items="${progressionTypeList}">
								<c:if
									test="${progressionPathDetail.progressionType == progressionType.categoryId}">
									<option value="${progressionType.categoryId}" selected>${progressionType.name}</option>
								</c:if>
								<c:if
									test="${progressionPathDetail.progressionType != progressionType.categoryId}">
									<option value="${progressionType.categoryId}">${progressionType.name}</option>
								</c:if>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_HalfWidth-right">
					<div class="select_style">
						<select id="progressionCategoryId_<%=i%>"
							name="progressionCategory_<%=i%>" class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Progression Category*', ' is required');">
							<option selected disabled value="0">Progression
								Category*</option>
							<c:forEach var="progressionCategoryList"
								items="${progressionCategoryList}">
								<c:if
									test="${progressionPathDetail.progressionCategory == progressionCategoryList.categoryId}">
									<option value="${progressionCategoryList.categoryId}" selected>${progressionCategoryList.name}</option>
								</c:if>
								<c:if
									test="${progressionPathDetail.progressionCategory != progressionCategoryList.categoryId}">
									<option value="${progressionCategoryList.categoryId}">${progressionCategoryList.name}</option>
								</c:if>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_HalfWidth Margin-20">
					<input type="text" name="progressionStMo_<%=i%>"
						id="progressionStMoId_<%=i%>"
						value="${progressionPathDetail.startMonth }"
						placeholder="Starting Month of Progression*" class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Starting Month of Progression*', ' is required');">
				</div>
				<div class="Input_HalfWidth ">
					<input type="text" name="progressionEnddMo_<%=i%>"
						id="progressionEnddMoId_<%=i%>"
						value="${progressionPathDetail.endMonth }"
						placeholder="Ending Month of Progression*" class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Ending Month of Progression*', ' is required');">
				</div>
				<div class="Input_HalfWidth Margin-20">
					<input type="text" name="progressionDuration_<%=i%>"
						id="progressionDurationId_<%=i%>"
						value="${progressionPathDetail.duration }" placeholder="Duration*"
						class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Duration*', ' is required');">
					<div class="icon-right" id="monthofspan_<%=i%>">month(s)</div>
				</div>
				<br>
				<div class="Input_HalfWidth ">
					<input type="text" name="progressionOptLevela_<%=i%>"
						id="progressionOptLevelaId_<%=i%>"
						value="${progressionPathDetail.optionalMandatory }"
						placeholder="Optional Level / Sequence*" class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Optional Level / Sequence*', ' is required');">
				</div>
				<%-- <div class="Input_HalfWidth ">
					<input type="text" name="progressionOptLevelb_<%=i%>"
						id="progressionOptLevelbId_<%=i%>" value=""
						placeholder="Optional Level / Sequence*" class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Optional Level / Sequence*', ' is required');">
				</div> --%>
			</div>
		</div>
	</div>
	<%
		i = i + 1;
	%>
</c:forEach>
