<!-- Basic html for fee detail with funding -->
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<div id="basicFeeInstance" style="display: none">
	<div class="form-inner Border Form-pop-padding bg_title paddingBottom-30">
	<div class="form-section-header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.feeStructure")%></div>
		<div class="Table-form_div ">
			<%@ include file="/html/create/fee_tableHeader.jsp"%>

			<div id="feeInner_Fund" class="feeInner_Fund">
				<input type="hidden" id="globalCountId_Fund" value="0"
					class="globalCountId_Fund">
			</div>
		</div>
	</div>
</div>
<!-- Basic html for button to add instance -->
<div id="feeInstButton" style="display: none">
	<div class="Input_Fullwidth Addproduct_click addFeeFunding-button align-margintop">
		<div class="Add_button">
			<a href="javascript:addFeeInstances('_Fund0','', '', '', '','');"
				class="Button-green button-pos-center feeInstButton"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeStructure.addFeeComponent")%></a>
		</div>
	</div>
</div>

<!-- select options for funding -->
<div style="display: none">
	<select id="fundingSponsoredId">
		<option selected disabled value=""><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeStructure.sponsored")%></option>
		<c:forEach var="sponsoredBy" items="${sponsoredByList}">
			<option value="${sponsoredBy.categoryId}">${sponsoredBy.name}</option>
		</c:forEach>
	</select> 
	
	<select id="fundingReslStatusId" multiple style="height:80px">
		<option value="NA" style="font-size: 10pt;opacity: 0.7;"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeStructure.residentialStatus")%></option>
		<c:forEach var="residentialStatus" items="${residentialStatusList}">
			<option value="${residentialStatus.categoryId}">${residentialStatus.name}</option>
		</c:forEach>
	</select> 
	<select id="fundingOperatorId">
		<option selected value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeStructure.operator")%></option>
		<option value="<%=SambaashConstants.GREATER_THAN_CODE%>"> 	&gt;</option>
		<option value="<%=SambaashConstants.LESS_THAN_CODE%>">  &lt; </option>
		<option value="<%=SambaashConstants.GREATER_THAN_OR_EQUAL_CODE%>">&gt;=</option>
		<option value="<%=SambaashConstants.LESS_THAN_OR_EQUAL_CODE%>">&lt;=</option>
		<option value="<%=SambaashConstants.EQUAL_CODE%>">=</option>
	</select>
	
	<select id="ageValueId">
		<option selected value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeStructure.value")%></option>
		<%for(int k=5;k<=80;k++){ 
		%>
		<option value="<%=k %>"> <%=k %></option>
		<%} %>
	</select>
	
<!--  basic html for notes textarea -->
	<div id="generalNotesTxt" >
		<div class="Input_Fullwidth" style = "margin-bottom:20px;">
			<div class="Admin-textarea">
				<textarea class="GeneralNotes fundingDescPostId"
					id="fundingDescPostId" name="fundingDescPost" maxlength="1000"
					placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes")%>"></textarea>
			</div>
		</div>
	</div>
</div>

<div style="display:none;">
                                        	<select id="feeTypeId">
                                                    <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>*</option>
                                                    <c:forEach var="feeType" items="${feeTypeList}">
														<option value="${feeType.spFeeTypeId}">${feeType.feeTypeName}</option>
													</c:forEach>
                                                </select>
                                                
                                        </div>