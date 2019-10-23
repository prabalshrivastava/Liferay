<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%
	int i = 0;
%>
<input type="hidden" id="globalCountId"  name="globalCountId" value="${feeDetailListLength}">
<c:forEach var="feesDetail" items="${feesDetail}">
	<div class="feeSection" id="feeSectionId_<%=i%>">
		<div class="feeInnerData">
			<div class="close_button">
				<span onclick="javascript:removeByInstanceIdWithMandatoryFields('feeSectionId_<%=i%>','Atleast one Fees detail is required');"> <img
					src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
					alt="Close">
				</span>
			</div>
			<div class="Div_Col_row">

				<div class="Div_col2">
					<div class="select_style">
						<select id="feeTypeId_<%=i%>" name="feeType_<%=i%>"
							class="Requiredfield"
							onblur="requiredFieldValidation(this, 'Please select*', ' is required');"
							onChange="loadFeeTypeDecription(<%=i%>);">
							<option selected disabled value="0">Please select*</option>
							<c:forEach var="feeType" items="${feeTypeList}">
								<c:if test="${feesDetail.feeType == feeType.categoryId}">
									<option value="${feeType.categoryId}" selected>${feeType.name}</option>
								</c:if>
								<c:if test="${feesDetail.feeType != feeType.categoryId}">
									<option value="${feeType.categoryId}">${feeType.name}</option>
								</c:if>
							</c:forEach>
						</select>

					</div>
				</div>
				<div class="Div_col3">
					<div id="feeDescId_<%=i%>" class="Div_col3_desc">${feesDetail.feeDesc}</div>
					<div class="Input_Fullwidth">
						<input type="hidden" name="feeDescData_<%=i%>"
							id="feeDescDataId_<%=i%>" value="${feesDetail.feeDesc}"
							placeholder="Fee Description">
					</div>
				</div>
				<div class="Div_col4">
					<div id="feeCalcId_<%=i%>"></div>
					<div class="Input_Fullwidth">
						<input type="text" name="feeCalcData_<%=i%>"
							id="feeCalcDataId_<%=i%>" value="${feesDetail.calculationBase}"
							placeholder="Fee Calculation">
					</div>
				</div>
				<fmt:formatNumber var='feeAmountData' type="number" maxFractionDigits="2" minFractionDigits="2" groupingUsed="false" value="${feesDetail.amount}" />
				<div class="Div_col5">
					<div id="feeAmountId_<%=i%>"></div>
					<div class="Input_Fullwidth">
						<input type="text" class="feeAmountData" name="feeAmountData_<%=i%>"
							id="feeAmountDataId_<%=i%>" value="${feeAmountData}" maxlength="10"
							placeholder="Fee Amount" oninput="decimalFieldValidation('feeAmountDataId_<%=i%>')" onblur="javascript:changetoDecimal('feeAmountDataId_<%=i%>')">
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		i = i + 1;
	%>
</c:forEach>
