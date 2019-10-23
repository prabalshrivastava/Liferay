<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	int i = 0;
%>
<input type="hidden" id="globalCountId"  name="globalCountId" value="${graduationCriteriaDetailListLength}">
<c:forEach var="graduationCriteriaDetail"
	items="${graduationCriteriaDetail}">
	<div class="Grad_wrapper" id="gradWrapperId_<%=i%>">
		<div class="form-inner Border  Form-bg FormBorder-active ">
			<div class="close_button">
				<span onclick="javascript:removeByInstanceIdWithMandatoryFields('gradWrapperId_<%=i%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.required.message")%>');"><img
					src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
					alt="Close"></span>

			</div>
			<div class="form-summary-inner" id="newboxes1-2">
				<div class="Input_HalfWidth Margin-20">
					<div class="select_style">
						<select id="criteriaTypeId_<%=i%>" name="criteriaType_<%=i%>"
							class="Requiredfield"
							onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.graduationType")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
							<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.graduationType")%> *</option>
							<c:forEach var="criteriaType" items="${criteriaTypeList}">
								<c:choose>
									<c:when test="${graduationCriteriaDetail.criteriaType == criteriaType.categoryId}">
										<option value="${criteriaType.categoryId}" selected>${criteriaType.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${criteriaType.categoryId}">${criteriaType.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_HalfWidth">
					<div class="select_style">
						<select id="criteriaLevelId_<%=i%>" name="criteriaLevel_<%=i%>"
							class="Requiredfield"
							onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaLevel")%> *', ' is required');">
							<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaLevel")%> *</option>
							<c:forEach var="criteriaLevel" items="${criteriaLevelList}">
								<c:choose>
									<c:when test="${graduationCriteriaDetail.criteriaLevel == criteriaLevel.categoryId}">
										<option value="${criteriaLevel.categoryId}" selected>${criteriaLevel.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${criteriaLevel.categoryId}">${criteriaLevel.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_Fullwidth">

					<input type="text" name="criteriaValue_<%=i %>"
						id="criteriaValueId_<%=i %>"
						value="${graduationCriteriaDetail.criteriaValueRange }"
						placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaValue")%> *" maxlength="75"
						class="Requiredfield"
						onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaValue")%> *', ' is required');">
				</div>
				<div class="Input_Fullwidth margin-20-topbottom">
					<div class="Admin-textarea">

						<textarea class="gradCriteria" name="gradCriteriaDesc_<%=i%>"
							id="gradCriteriaDescId_<%=i%>" maxlength="250"
							placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.graduation.criteriaDescription")%>">${graduationCriteriaDetail.criteriaDesc}</textarea>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		i = i + 1;
	%>
</c:forEach>
