<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<%
	String spCourseId = request.getParameter("spCourseId"); 
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createMiscFee">
	<portlet:param name="action" value="addMiscFee"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<div style="display:none">
 <select id="miscfeeTypeId">
                                                    <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>*</option>
                                                    <c:forEach var="miscFeeType" items="${miscFeeTypeList}">
														<option value="${miscFeeType.spFeeTypeId}">${miscFeeType.feeTypeName}</option>
													</c:forEach>
                                                </select>
                                                
                                                <select id="miscwhenPayableId">
                                                    <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>*</option>
                                                    <c:forEach var="miscWhenPayable" items="${miscWhenPayableList}">
														<option value="${miscWhenPayable.categoryId}">${miscWhenPayable.name}</option>
													</c:forEach>
                                                </select>
</div>

<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">
		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>

		<div class="Right_content_section">
			<%if(Validator.isNotNull(spCourseId)){ %>
				<div class="Border" id="mainContainer">
				
					<div class="form-section ">
						<div class="Input_Fullwidth componentTitle"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.miscellaneousFees")%></div>
						<form action="#" method="POST" id="miscfeeDetailFormId"
									name="feeDetailForm">
						<div class="form-inner Border Form-pop-padding bg_title" style="margin-bottom:20px;">
							<div class="Table-form_div ">
								<div class="Div_Head_row">
                                    <div class="Div_col2" style="float:left;width:30.5%;text-align:left;"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.feeType")%></div>
                                    <div class="Div_col3" style="float:left;width:20.5%;text-align:left;"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetail.amount")%></div>
                                    <div class="Div_col5" style="width: 48%;text-align: left;"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.remarks")%></div>
                                </div>
				
									<input type="hidden" id="globalCountId" name="globalCountId" value="0">
									<div id="miscfeeInner_0"></div>
									<div
										class="Input_Fullwidth Addproduct_click addFeeFunding-button">
										<div class="Add_button">
											<a href="javascript:addMiscFeeInstances('','','')"
												class="Button-green button-pos-center"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.addComponent")%></a>
										</div>
										<div id="errorMsg-Modal"></div>
									</div>
									
							</div>
						</div>
						<div class="Input_Fullwidth ">
				                       <div class="Admin-textarea">
				                       <c:choose>
				                       <c:when test="${miscFeeDetailListJSON == '0'}">
					                        <textarea class="miscGeneralNotes"  id="miscGeneralNotesId"  name="miscGeneralNotes" maxlength="1000" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.generalNotes")%>"> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.gst")%></textarea>
					                    </c:when>
					                    <c:otherwise>
					                    	<textarea class="miscGeneralNotes"  id="miscGeneralNotesId"  name="miscGeneralNotes" maxlength="1000" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.generalNotes")%>">${miscFeeDesc} </textarea>
					                    </c:otherwise>
					                    </c:choose>
					                   </div>
				                    </div> 
						</form>
					</div>
					
				</div>
				<div class="Right_bottom">
						<a href="<%=listCourse %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="#" onclick="submitForm('miscfeeDetailFormId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
						<div class="Prev-icon">
							<a href="javascript:courseTabslink('<%=addFunding%>','editFunding','funding');"></a>
						</div>
				</div>
			<%} %>
		</div>
	</div>
</div>		

<script>
showSubMenu("courseSiderbar");
var miscFeeDetail = ${miscFeeDetailListJSON};

function addMiscFeeInstances(feeTypeVal,amountVal,payableVal){
	var count = parseInt(document.getElementById("globalCountId").value);

	var mainFeeWrapper = document.getElementById("miscfeeInner_0");
	//main wrapper
	var feeWrap = createInstanceElements("div","feeSection","feeSectionId_"+count,'','','','','','','','','','','','');
	var secWrap = createInstanceElements("div","feeInnerData",'','','','','','','','','','','','','');
	feeWrap.appendChild(secWrap);
	 
	//close Button
    	var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId_"+count,'','','','','','','','','','','','');
    	var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeByInstanceIdWithMandatoryFields("feeSectionId_'+count+'","<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.required.message")%>")','','','','','','');
    	var clsButtonImg = createInstanceElements("img",'','','','','','','','','/SPProduct-portlet/images/Product_create/Close-icon.svg','','','','','');
    	clsButtonSpan.appendChild(clsButtonImg);
    	clsButtonDiv.appendChild(clsButtonSpan);
    	secWrap.appendChild(clsButtonDiv); //added button to schedule instance 
	mainFeeWrapper.appendChild(feeWrap);
	
	//div Coloumn row
	  
	var clsColRow = createInstanceElements("div","Div_Col_row",'','','','','','','','','','','','','');
	
	//Col2
	var feeDetailsOption = document.getElementById("miscfeeTypeId").innerHTML;
	var clsColoumn2 = createInstanceElements("div","Div_col2",'','','','','','','','','','','','','');
	var seldiv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
	var selectCol2 = createInstanceElements("select",'Requiredfield',"miscFeeTypeId_"+count,"miscFeeType_"+count,'','','','','','',true,'',true,' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>'
);
	selectCol2.setAttribute("onblur","requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>*', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');");
	selectCol2.innerHTML = feeDetailsOption;
	seldiv.appendChild(selectCol2);
	clsColoumn2.appendChild(seldiv);
	clsColRow.appendChild(clsColoumn2);
	
	//Col3
	var clsColoumn3 = createInstanceElements("div","Div_col3",'','','','','','','','','','','','','');
	var feeAmount = createInstanceElements("div",'',"feeAmountId_"+count,'','','','','','','','','','','','');
	var feeAmountDiv = createInstanceElements("div","Input_Fullwidth",'','','','','','','','','','','','','');
	var feeAmountData = createInstanceElements("input",'feeAmountData',"miscFeeAmountDataId_"+count,'miscFeeAmountData_'+count,'text','Fee Amount','10','oninput','decimalFieldValidation("miscFeeAmountDataId_' +count+ '","<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.decimal.message")%>")','','','','','','');
	feeAmountData.setAttribute('onblur','javascript:changetoDecimal("miscFeeAmountDataId_'+ count + '")');
	clsColoumn3.setAttribute("style","width:20.5%");
	if (amountVal >= 0) {
	feeAmountData.value = amountVal;
	}
	feeAmountDiv.appendChild(feeAmountData);
	clsColoumn3.appendChild(feeAmountDiv);
	clsColoumn3.appendChild(feeAmount);
	clsColRow.appendChild(clsColoumn3);
	
	
	//col4
	var whenPayableOption = document.getElementById("miscwhenPayableId").innerHTML;
	var clsColoumn4 = createInstanceElements("div","Div_col5",'','','','','','','','','','','','','');
	var seldiv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
	var selectCol4 = createInstanceElements("select",'Requiredfield',"whenPayable_"+count,"whenPayable_"+count,'','','','','','',true,'',true,' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>'
);
	selectCol4.setAttribute("onblur","requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>*', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');");
	clsColoumn4.setAttribute("style","width:48%");
	selectCol4.innerHTML = whenPayableOption;
	seldiv.appendChild(selectCol4);
	clsColoumn4.appendChild(seldiv);
	clsColRow.appendChild(clsColoumn4);
	
	
	secWrap.appendChild(clsColRow);
	
	var selecttypeElm = document.getElementById("miscFeeTypeId_"+count);
	if (feeTypeVal != '' && feeTypeVal != 'undefined') {
		for (i = 0; i < selecttypeElm.length; i++) {
	        if(feeTypeVal != selecttypeElm.options[i].value){
	        	
	        }else{
	        	selecttypeElm.options[i].selected = i;
	        }
	    }
	}
	
	var selectPayElm = document.getElementById("whenPayable_"+count);
	if (payableVal != '' && payableVal != 'undefined') {
		for (i = 1; i < selectPayElm.length; i++) {
	        if(payableVal != selectPayElm.options[i].value){
	        	
	        }else{
	        	selectPayElm.options[i].selected = i;
	        }
	    }
	}
	document.getElementById("globalCountId").value = count + 1;
	
}

function submitForm(fmId){ 
		var critInstancesCount =  parseInt(document.getElementById("globalCountId").value); 
		var spCourseId = document.getElementById("spCourseId").value;
		var isValidate = validateForm("miscfeeInner_0",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate) {
		AUI().use('aui-io-request', function(A){
			startPreLoader("mainContainer");
			A.io.request('${createMiscFee}', 
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
									displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.updated")%>');
								}else{
									// This case is very very rare
									displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
								}
							} else {
								displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.save.error")%>');
							}
							window.scrollTo(0,0);
						},
						failure : function() {
							displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.miscellaneousFees.save.error")%>');
							window.scrollTo(0,0);
						}
					} 
				}); 
			}); 
		}
	}
	
function initializeMiscFeeInstances(){
	//console.log("feeinstance " + feeDetail);
	if (miscFeeDetail) {
		 for (key in miscFeeDetail) {
             var miscFeeTypeVal = miscFeeDetail[key].miscFeeType;
             var amountVal = miscFeeDetail[key].amount;
             var payable = miscFeeDetail[key].payable;
             addMiscFeeInstances(miscFeeTypeVal, amountVal, payable);
         }
    }
	else{
    	addMiscFeeInstances('', '','');
    }
}

AUI().ready(function(A) {

	initializeMiscFeeInstances();
});

</script>	