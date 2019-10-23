<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	int i = 0;
%>
<input type="hidden" id="globalCountId"  name="globalCountId" value="${fundingListLength}">
<c:forEach var="fundingDetail" items="${fundingDetail}">
	<div class="Funding_wrapper" id="fundingWrapperId_<%=i%>">
		<div
			class="form-inner Border Form-pop-padding Form-bg FormBorder-active">
			<div class="close_button">
				<span onclick="javascript:removeByInstanceIdWithMandatoryFields('fundingWrapperId_<%=i%>','Atleast one funding detail is required');"><img
					src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
					alt="Close"></span>
			</div>
			<div class="form-summary-inner">
				<div class="Input_Smallexd margin-right-22">
					<div class="select_style">
						<select id="fundingCourseTypeId_<%=i%>"
							name="fundingCourseType_<%=i%>" class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Course Type*', ' is required');">
							<option selected disabled value="0">Course Type*</option>
							<c:forEach var="courseType" items="${courseTypeList}">
								<c:choose>
									<c:when
										test="${fundingDetail.courseType == courseType.categoryId}">
										<option value="${courseType.categoryId}" selected>${courseType.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${courseType.categoryId}">${courseType.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_Smallexd margin-right-22">
					<div class="select_style" id="Sponsored1_select">
						<select id="fundingSponsoredId_<%=i%>"
							name="fundingSponsored_<%=i%>" class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Sponsored by*', ' is required');">
							<option selected disabled value="0">Sponsored by*</option>
							<c:forEach var="sponsoredBy" items="${sponsoredByList}">
								<c:choose>
									<c:when
										test="${fundingDetail.sponsoredBy == sponsoredBy.categoryId}">
										<option value="${sponsoredBy.categoryId}" selected>${sponsoredBy.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${sponsoredBy.categoryId}">${sponsoredBy.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Input_HalfWidth ">
					<div class="select_style">
						<select id="fundingReslStatusId_<%=i%>"
							name="fundingResStatus_<%=i%>" class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Residential Status*', ' is required');">
							<option selected disabled value="0">Residential Status*</option>
							<c:forEach var="residentialStatus"
								items="${residentialStatusList}">
								<c:if
									test="${fundingDetail.residenceStatus == residentialStatus.categoryId}">
									<option value="${residentialStatus.categoryId}" selected>${residentialStatus.name}</option>
								</c:if>
								<c:if
									test="${fundingDetail.residenceStatus != residentialStatus.categoryId}">
									<option value="${residentialStatus.categoryId}">${residentialStatus.name}</option>
								</c:if>
							</c:forEach>
						</select> 
					</div>
				</div>
				<div class="Breakline"></div>
				<div class="Input_HalfWidth Margin-20">
					<input type="text" name="fundingAge_<%=i %>"
						id="fundingAgeId_<%=i %>" value="${fundingDetail.ageGroup}"
						placeholder="Age*" class="Requiredfield" maxlength="75"
						onblur="requiredFieldValidation(this, 'Age*', ' is required');">
				</div>
				<div class="Input_HalfWidth">
					<input type="text" name="fundingEarningStatus_<%=i %>"
						id="fundingEarningStatusId_<%=i %>"
						class="Requiredfield"
						value="${fundingDetail.earningStatus}"
						placeholder="Earning Status*" maxlength="75"
						onblur="requiredFieldValidation(this, 'Earning Status*', ' is required');">
				</div>
				<div class="Input_HalfWidth Margin-20">
					<input type="text" name="fundingSalaryMonth_<%=i %>"
						id="fundingSalaryMonthId_<%=i %>"
						class="Requiredfield" value="${fundingDetail.salary}"
						placeholder="Salary / Month*" maxlength="75"
						onblur="requiredFieldValidation(this, 'Salary / Month*', ' is required');">
				</div>
								<div class="Input_HalfWidth">
					<input type="text" name="fundingHour_<%=i %>"
						id="fundingHourId_<%=i %>" class="Requiredfield"
						value="${fundingDetail.fundingHour}" placeholder="Funding / hour*"
						maxlength="75"
						onblur="requiredFieldValidation(this, 'Funding / hour*', ' is required');">
				</div>
				
				<div class="Input_Fullwidth margin-20-topbottom">
					<input type="text" name="fundingCourseFee_<%=i %>"
						id="fundingCourseFeeId_<%=i %>" class="Requiredfield"
						value="${fundingDetail.fundingCourseFee}"
						placeholder="Course Fee Funding*" maxlength="500"
						onblur="requiredFieldValidation(this, 'Course Fee Funding*', ' is required');">
				</div>
				<fmt:formatNumber var='fundingAmount' type="number" maxFractionDigits="2" minFractionDigits="2" groupingUsed="false" value="${fundingDetail.fundingAmount}" />
				<div class="Input_HalfWidth Margin-20">
					<input type="text" name="fundingAmount_<%=i %>"
						id="fundingAmountId_<%=i %>" class="Requiredfield"
						value="${fundingAmount}" maxlength="10"
						placeholder="Funding Amount*" oninput="decimalFieldValidation('fundingAmountId_<%=i %>')" onblur="requiredFieldValidation(this, 'Funding Amount*', ' is required');">
				</div>
				<fmt:formatNumber var='netFees' type="number" maxFractionDigits="2" minFractionDigits="2" groupingUsed="false" value="${fundingDetail.netFees}" />
				<div class="Input_HalfWidth">
					<input type="text" name="fundingNetFees_<%=i %>"
						id="fundingNetFeesId_<%=i %>" class="Requiredfield" maxlength="10"
						value="${netFees}" placeholder="Net Fees*" oninput="decimalFieldValidation('fundingNetFeesId_<%=i %>')" onblur="requiredFieldValidation(this, 'Net Fees*', ' is required');">
				</div>
				<div class="Input_Fullwidth margin-20-topbottom ">
					<input type="text" name="fundingAbsenteePayroll_<%=i %>"
						id="fundingAbsenteePayrollId_<%=i %>" class="Requiredfield"
						value="${fundingDetail.absenteePayroll}"
						placeholder="Absentee Payroll Funding*" maxlength="1000" onblur="requiredFieldValidation(this, 'Absentee Payroll Funding*', ' is required');">
				</div>

			</div>
		</div>
	</div>
	<%
		i = i + 1;
	%>
</c:forEach>
