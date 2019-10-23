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
	String feeDescriptionLabel = "Fee Description";
	feeDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.fee.feeDescription");
	String spCourseId = request.getParameter("spCourseId"); 
%>

<portlet:resourceURL var="createFunding">
	<portlet:param name="action" value="addFunding"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="createFeeDetail">
	<portlet:param name="action" value="addFeeDetail"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="getFeeType">
	<portlet:param name="action" value="getFeeType"></portlet:param>
</portlet:resourceURL>


<%@ include file="/html/create/msg.jsp"%>
<%@ include file="/html/create/fee_funding_basicHtml.jsp"%>

<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">
		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>

		<div class="Right_content_section">
			<%if(Validator.isNotNull(spCourseId)){ %>
			<div class="Border" id="mainContainer">

				<div class="heading-title Border-bottom">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.feesFunding")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listCourse%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>
				<div id="errorMsg-Modal"></div>
				
				<%@ include file="/html/create/fee_details.jsp"%>
				
				<form action="#" method="POST" id="fundingFormId" name="fundingForm">
					<div class="form-section fundingForm">
					<input type="hidden" id="fundglobalCountId"
								name="fundglobalCountId" value="0">
						<c:if test="${isShowFunding }">
						<div id="LastInstanceRemovalMessage"></div>
						<div class="Input_Fullwidth componentTitle" style="display: inline-block;  width: 26%;"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.withFunding")%></div>
							<div
							class="Input_Fullwidth Addcomponent_click align-margintop" style="width: 40%; vertical-align: baseline;">

							<div class="Add_button">
								<a id="showFundingButton" href="javascript:showFundingInstance()"
									class="Button-green button-pos-center" style="margin:0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.addFunding")%></a>
							</div>
						</div>
						
						<div id="fundingInner_0" class="funding-OuterWrap">
								
							
						</div>

						<div
							class="Input_Fullwidth Addcomponent_click addFeeFunding-button align-margintop hideFunding" id="addFundInstanceButton">

							<div class="Add_button">
								<a href="javascript:addFundingInstances('','','','','','','','','','false')"
									class="Button-green button-pos-center"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.addFunding")%></a>
							</div>
						</div>
						
						<div class="Input_Fullwidth ">
	                       <div class="Admin-textarea">
		                        <textarea class="fundingGeneralNotes"  id="fundingGeneralNotesId"  name="fundingGeneralNotes" maxlength="1000" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.generalNotes")%>">${fundingDescPost}</textarea>
		                        
		                   </div>
	                    </div> 
	                    </c:if>
					</div>
					
					<!-- General Notes section for fees -->
					
					<div class="Input_Fullwidth margin-20-topbottom">
								<liferay-ui:input-editor name='<%="fee_description"%>'
									editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
									initMethod='<%="initEditor_fee_descriptionn"%>'
									cssClass="ckeditor" />
								<input type="hidden" value="" name="feeEntryDesc"
									id="feeEntryDescId">
									<c:set var="feeDesc" value="${feeDesc}" />
								<%
									String feeDesc = (String) pageContext.getAttribute("feeDesc");
								%>
								<aui:script>
							function <portlet:namespace />initEditor_fee_descriptionn() {
								<c:choose>
								<c:when test="${empty feeDesc}">
									return "<%=UnicodeFormatter.toString(feeDescriptionLabel)%>";
								</c:when>
								<c:otherwise>
									return "<%=UnicodeFormatter.toString(feeDesc)%>";
								</c:otherwise> 
								</c:choose>
							}
						</aui:script>
							
							
						</div>
					<!--  -->

				</form>
			</div>
			<div class="Right_bottom">
				<a href="<%=listCourse %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="#"
					onclick="submitForm('fundingFormId','Funding_wrapper')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
				<div class="Prev-icon">
					<a
						href="javascript:courseTabslink('<%=addGraduationCriteria%>','editGraduationCriteria','graduationCriteria');"></a>
				</div>
				<div class="Next-icon">
					<a
						href="javascript:courseTabslink('<%=addMiscFeeDetails%>','editMiscFeeDetails','miscFeeDetails');"></a>
				</div>
			</div>
			<%}else{ %>
			<div>Please create a course.</div>
			<%} %>
		</div>
	</div>
</div>

<script type="text/javascript">
    showSubMenu("courseSiderbar");
    var feeDetail = ${feeDetailListJSON};
    console.log("feeDetail " + feeDetail);
    var feeFundingDetail = ${feeFundingDetailListJSON};
    var selfSponsorId = ${selfSponsorId};
    var isShowFunding = ${isShowFunding};
    
    function showFundingInstance(){
    	var firstFundInst = document.getElementById('fundingInner_0');
    	var addFundInstbtn = document.getElementById('addFundInstanceButton');
    	var showFundInstButton = document.getElementById('showFundingButton');
    	if(firstFundInst){
    		var fndClass = firstFundInst.className;
    		if(fndClass.indexOf('showAddFunding') != -1){
    			firstFundInst.innerHTML = "";
    			firstFundInst.classList.remove('showAddFunding');
    			addFundInstbtn.classList.remove('showFunding');
    			addFundInstbtn.classList.add('hideFunding'); 
    			showFundInstButton.classList.add('showFunding');
    			showFundInstButton.classList.remove('hideFunding'); 
    			showFundInstButton.innerHTML = "Add Funding Criteria";
    			document.getElementById("fundglobalCountId").value = 0;
    		}else{
    			firstFundInst.classList.add('showAddFunding');
    			addFundInstbtn.classList.add('showFunding');
    			addFundInstbtn.classList.remove('hideFunding'); 
    			showFundInstButton.classList.remove('showFunding');
    			showFundInstButton.classList.add('hideFunding'); 
    			initializeFeeFundInstances();
    			//showFundInstButton.innerHTML = "Remove All Funding Criteria";
    		}
    	}
    }
    
    function showFeeInstance(){
    	var firstFundInst = document.getElementById('feeInner_0');
    	var addFundInstbtn = document.getElementById('addFeeInstanceButton');
    	var showFundInstButton = document.getElementById('showFeeButton');
    	var feeConatiner = document.getElementById('form-inner-container');
    	if(firstFundInst){
    		var fndClass = firstFundInst.className;
    		if(fndClass.indexOf('showAddFunding') != -1){
	    			firstFundInst.innerHTML = "";
	    			firstFundInst.classList.remove('showAddFunding');
	    			feeConatiner.classList.remove('showFunding');
	    			feeConatiner.classList.add('hideFunding'); 
	    			addFundInstbtn.classList.remove('showFunding');
	    			addFundInstbtn.classList.add('hideFunding'); 
	    			showFundInstButton.innerHTML = "Add Fee Details";
	    			showFundInstButton.classList.add('showFunding');
	    			showFundInstButton.classList.remove('hideFunding'); 
	    			document.getElementById("globalCountId").value = 0;
    		}else{
    			firstFundInst.classList.add('showAddFunding');
    			feeConatiner.classList.add('showFunding');
    			feeConatiner.classList.remove('hideFunding'); 
    			addFundInstbtn.classList.add('showFunding');
    			addFundInstbtn.classList.remove('hideFunding'); 
    			showFundInstButton.classList.remove('showFunding');
    			showFundInstButton.classList.add('hideFunding'); 
    			initializeFeeInstances();
    		}
    	}
    }
    
    function removeFeeinstances(fundId,count){
    	if(fundId == "_Fund0"){
    		var fundCount = parseInt(document.getElementById("fundglobalCountId").value);
    		for(var f=0;f<fundCount;f++){
    			var feeSectionId = "feeSectionId_Fund"+f+"_"+count;
    			if(document.getElementById(feeSectionId)){
	    			var isremove = removeByInstanceIdWithMandatoryFields(feeSectionId,'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.required")%>');
	    			if(!isremove){
	    				break;	
	    			}
    			}
    		}
    	}else{
	    	var feeSectionId = "feeSectionId"+fundId+"_"+count;
	    	removeByInstanceId(feeSectionId);
	    	var feeinstanceCount = document.getElementsByClassName('feeSection');
	    	if(feeinstanceCount.length < 1){
		    	var feeConatiner = document.getElementById("form-inner-container");
		    	var showFeeButton =  document.getElementById("showFeeButton");
		    	feeConatiner.classList.remove('showFunding');
		    	feeConatiner.classList.add('hideFunding'); 
		    	showFeeButton.classList.add('showFunding');
		    	showFeeButton.classList.remove('hideFunding'); 
		    	document.getElementById("globalCountId").value = 0;
	    	}	
    	}	
    }
    
    function removeFundInsances(fundInstCount){
    	var closeButton = document.getElementById("closeButtonId0");
    	var addFundButton = document.getElementById("addFundInstanceButton");
    	
    	var showFundingButton =  document.getElementById("showFundingButton");;
		var fundCount = 0;
		
		var fundSectionId = "fundingWrapperId_" + fundInstCount;
		removeByInstanceId(fundSectionId);
		var fundingInstances = document.getElementsByClassName("Funding_wrapper");
		if(fundingInstances){
			fundCount = fundingInstances.length;
		}	
		
		if(fundCount <= 1){
			closeButton.style.display = "block";
		}
		if(fundCount < 1){
			addFundButton.classList.remove('showFunding');
			addFundButton.classList.add('hideFunding'); 
			showFundingButton.classList.add('showFunding');
			showFundingButton.classList.remove('hideFunding'); 
			document.getElementById("fundglobalCountId").value = 0;
		}
    }
    
    function validateDisplayOrder(fieldId,fundInstCount,feeInstCount){
    	var targetid = fieldId+fundInstCount+"_"+feeInstCount;
    	var displayField = document.getElementById(targetid);
    	var isValid = true;
    	if(displayField){
    		var displayFieldVal = displayField.value;
    		var displayfields = document.getElementsByClassName(fieldId+fundInstCount);
    		for(var k=0; k<displayfields.length;k++){
    			var loopTargetId = fieldId+fundInstCount+"_"+k;
    			var displayFieldinLoop = document.getElementById(loopTargetId);
    			if(displayFieldinLoop){
    				if(targetid != loopTargetId){
    					if(displayFieldVal != ''){
		    				if(displayFieldVal == displayFieldinLoop.value){
		    					alert('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.orderNumber.message")%>');
		    					displayField.value = "";
		    					isValid = false;
		    					break;
		    				}
    					}
    				}	
    			}
    		}
    	}
    	return isValid;
    }
    
    function validateFeeType(fundInstCount,feeInstCount){
    	var targetid = "feeTypeId"+fundInstCount+"_"+feeInstCount;
    	var targetDescid = "feeDescId"+fundInstCount+"_"+feeInstCount;
    	var feetypeField = document.getElementById(targetid);
    	var feetypeDesc= document.getElementById(targetDescid);
    	var isValid = true;
    	if(feetypeField){
    		var feetypeFieldVal = feetypeField.options[feetypeField.selectedIndex].value;
    		var feetypefields = document.getElementsByClassName("feeTypeId"+fundInstCount);
    		for(var k=0; k<feetypefields.length;k++){
    			var loopTargetId = "feeTypeId"+fundInstCount+"_"+k;
    			var feeTypeinLoop = document.getElementById(loopTargetId);
    			if(feeTypeinLoop.options[feeTypeinLoop.selectedIndex]){
	    			var feeTypeinLoopvalue = feeTypeinLoop.options[feeTypeinLoop.selectedIndex].value;
	    			if(feeTypeinLoop){
	    				if(targetid != loopTargetId){
	    					if(feetypeFieldVal != ''){
			    				if(feetypeFieldVal == feeTypeinLoopvalue){
			    					alert('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.sameFee.message")%>');
			    					feetypeField.selectedIndex = 0;
			    					feetypeDesc.innerHTML="";
			    					isValid = false;
			    					break;
			    				}
	    					}
	    				}	
	    			}
    			}	
    		}
    	}
    	return isValid;
    }
    
    
    function submitForm(fmId,wrapperInstance1){ 
		var critInstancesCount = parseInt(document.getElementById("fundglobalCountId").value); 
		var spCourseId = document.getElementById("spCourseId").value;
		var mainFeeWrappers = document.getElementsByClassName("feeSection");
		var mainFundingWrapper = document.getElementById("fundingWrapperId_0");
		var isfeeFormValidate = true;
		var isfundFormValidate = true;
		document.getElementById("feeEntryDescId").value = window.<portlet:namespace />fee_description
		.getHTML();
		var feeDesc = document.getElementById("feeEntryDescId").value;
		if(!mainFundingWrapper && mainFeeWrappers.length <= 0){
			/* alert("Please enter any of the Fee & Funding Detail values");
			return; */
			submitFeeForm('feeDetailFormId','feeSection',feeDesc);
			submitFundForm(fmId,wrapperInstance1,feeDesc);
		}else{
			var isMutualValid = operatorFieldMutualValidation();
			if(mainFeeWrappers.length > 0){
				isfeeFormValidate = validateForm("feeInner_0",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
			}
			
			if(mainFundingWrapper){
				if(isMutualValid){
					isfundFormValidate = validateForm("fundingInner_0",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
				}else{
					isfundFormValidate = false;
				}
			}
			if (isfeeFormValidate && isfundFormValidate) {
				submitFeeForm('feeDetailFormId','feeSection',feeDesc);
				submitFundForm(fmId,wrapperInstance1,feeDesc);
			}
		}
	}
    
    function submitFundForm(fmId,wrapperInstance1,feeDesc){
    	var critInstancesCount = parseInt(document.getElementById("fundglobalCountId").value); 
		var spCourseId = document.getElementById("spCourseId").value;
    	AUI().use('aui-io-request', function(A){
			startPreLoader("mainContainer");
			A.io.request('${createFunding}', 
					{ method: 'post', 
						form: { id: fmId }, 
						data:{
							critInstancesCount : critInstancesCount,
							spCourseId : spCourseId,
							feeDesc : feeDesc
						},
						on:  {
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
										displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.feeDetails.updated")%>');
										if(data.process == 'create'){
											courseTabslink('<%=addMiscFeeDetails%>','editMiscFeeDetails','miscFeeDetails');
										}	
									}else{
										// This case is very very rare  
										displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.save.error")%>.<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
									}
								} else {
									displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.save.error")%>');
								}
								window.scrollTo(0,0);
							},
							failure : function() {
								displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.save.error")%>');
								window.scrollTo(0,0);
							}
						} 
				}); 
			}); 
    }
    
    function operatorFieldMutualValidation(){
    	var salaryCrit = document.getElementsByClassName('salMutualValidation');
    	var ageCrit = document.getElementsByClassName('ageMutualValidation');
    	var count = parseInt(document.getElementById("fundglobalCountId").value);
    	var isMutualValid = false;
    	for(var s=0; s<count; s++){
    		var ageOpr = document.getElementById("fundingAgeOperatorId_"+s);
    		
    		if(ageOpr){
    			var ageOprval = ageOpr.value;
    			var ageVal = document.getElementById("fundingAgeValueId_"+s);
    			if((ageOprval > 0 && ageVal.value == 0) || (ageOprval == 0 && ageVal.value > 0)){
    				isMutualValid = false;
    				if(ageVal.value == 0){
    					ageVal.classList.remove("Error-success");
    					ageVal.classList.add("Error");
    				}
    				if(ageOprval == 0){
    					ageOpr.classList.remove("Error-success");
    					ageOpr.classList.add("Error");
    				}
    				alert("Select values for both Age Operator and Age Value");
    				break;
    			}else{
    				isMutualValid = true;
    			}
    			
    			var salOprval = document.getElementById("fundingSalaryOperatorId_"+s);
    			var salVal = document.getElementById("fundingSalaryMonthId_"+s);
    			if((salOprval.value > 0 && salVal.value == 0) || (salOprval.value == 0 && salVal.value > 0)){
    				isMutualValid = false;
    				if(salVal.value == 0){
    					salVal.classList.remove("Error-success");
    					salVal.classList.add("Error");
    				}
    				if(salOprval.value == 0){
    					salOprval.classList.remove("Error-success");
    					salOprval.classList.add("Error");
    				}
    				alert('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.salary.validation")%>');
    				break;
    			}else{
    				isMutualValid = true;
    			}
    		}
    	}
    	return isMutualValid;
    }
    
    function checkSponsorType(count){
    	var sponsorId = "fundingSponsoredId_"+count;
    	var sponsorElem = document.getElementById(sponsorId);
    	var sponsorValue = sponsorElem.options[sponsorElem.selectedIndex].value;
    	var residentStatId = "fundingReslStatusId_"+count;
		var residentElem = document.getElementById(residentStatId);
    	if(sponsorValue == selfSponsorId){
    		residentElem.classList.add("Requiredfield");
    	}else{
    		residentElem.classList.remove("Requiredfield");
    	}
    }
    
    function addFundingInstances(fundOrder,sponsoredBy,residentStatus,fundingDescription,ageOperator,ageGroup,salOperator,salary,feeItems,isfirstInst){

    	var fundingInstances = document.getElementsByClassName("Funding_wrapper");
		var count = parseInt(document.getElementById("fundglobalCountId").value);
		var mainFundingWrapper = document.getElementById("fundingInner_0");
		//main wrapper
		var fundingWrap = createInstanceElements("div","Funding_wrapper","fundingWrapperId_"+count,'','','','','','','','','','','','');
		var secWrapFunding = createInstanceElements("div","form-inner Border Form-pop-padding Form-bg",'','','','','','','','','','','','','');
	    fundingWrap.appendChild(secWrapFunding);
		mainFundingWrapper.appendChild(fundingWrap);
		
		var fundCount = 0;
		if(fundingInstances){
			fundCount = fundingInstances.length;
		}	
		//close Button
		
			var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId"+count,'','','','','','','','','','','','');
			var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeFundInsances("'+count+'")','','');
			var clsButtonImg = createInstanceElements("img",'','','','','','','','','<%=request.getContextPath()%>/images/Product_create/Close-icon.svg','','','','','');
			clsButtonSpan.appendChild(clsButtonImg);
			clsButtonDiv.appendChild(clsButtonSpan);
			var firstClsBtn = document.getElementById("closeButtonId0");
		if(fundCount > 1){
			if(firstClsBtn){
				firstClsBtn.setAttribute("style","display:none");
			}	
		}else{
			if(firstClsBtn){
				firstClsBtn.setAttribute("style","display:block");
			}	
		}
		//Funding & fee instance fields wrap
		var fundingFieldsWrap = createInstanceElements("div","form-summary-inner",'','','','','','','','','','','','','');
		
		var fundingStructureWrap = createInstanceElements("div","funding-structure",'','','','','','','','','','','','','');
		var sectionHeader = createInstanceElements("div","form-section-header",'','','','','','','','','','','','','');
		sectionHeader.innerHTML = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.fundingCriteria")%>';
		fundingStructureWrap.appendChild(sectionHeader);
		
		//Funding Sponsered select 
        var sponseredOption = document.getElementById("fundingSponsoredId").innerHTML;
        var selSponseredType = createInstanceElements("div","Input_HalfWidth margin-right-22",'','','','','','','','','','','','','');
		var selSponsereddiv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
		var selectSponsered = createInstanceElements("select",'Requiredfield',"fundingSponsoredId_"+count,"fundingSponsored_"+count,'','','','onChange','checkSponsorType("' +count +'")','','','','','','');
		selectSponsered.innerHTML = sponseredOption;
		selSponsereddiv.appendChild(selectSponsered);
		selSponseredType.appendChild(selSponsereddiv);
		fundingStructureWrap.appendChild(selSponseredType);
		
		 //Funding Residential select 
        var resOption = document.getElementById("fundingReslStatusId").innerHTML;
        var selResType = createInstanceElements("div","Input_HalfWidth",'','','','','','','','','','','','','');
		var selResdiv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
		var selectRes = createInstanceElements("select",'multiSelectFied',"fundingReslStatusId_"+count,"fundingResStatus_"+count,'','','','','','','','','','','');
		selectRes.setAttribute("style","height:80px;")
		selectRes.setAttribute("multiple","true");
		selectRes.innerHTML = resOption;
		
		selResdiv.appendChild(selectRes);
		selResType.appendChild(selResdiv);
		fundingStructureWrap.appendChild(selResType);

		// line break
		var brkLine = createInstanceElements("div","Breakline",'','','','','','','','','','','','','');
		fundingStructureWrap.appendChild(brkLine);
		
		//Funding age 	
		var fundAgeValue = createInstanceElements("div","Input_HalfWidth Margin-20 margin-bottom-10",'','','','','','','','','','','','','');
		var ageWrap = createInstanceElements("div","ageValuesWrap Border",'','','','','','','','','','','','','');
		var ageText = createInstanceElements("div","ageCriteriaText",'','','','','','','','','','','','','');
		ageText.innerHTML = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.ageCriteria")%>';
		//var fundAgeValueIp = createInstanceElements("input",'',"fundingAgeId_"+count,'fundingAge_'+count,'text','Age*','75','','','',true,'','');
		var ageOprtOption = document.getElementById("fundingOperatorId").innerHTML;
		var selectageOp = createInstanceElements("select",'ageMutualValidation',"fundingAgeOperatorId_"+count,"fundingAgeOperator_"+count,'','','','','','','','','','','');
		selectageOp.innerHTML = ageOprtOption;
		
		var ageValOption = document.getElementById("ageValueId").innerHTML;
		var selectageVal = createInstanceElements("select",'ageMutualValidation',"fundingAgeValueId_"+count,"fundingAgeValue_"+count,'','','','','','','','','','','');
		selectageVal.innerHTML = ageValOption;
		selectageVal.setAttribute('style','float:right');
		
		ageWrap.appendChild(ageText);
		ageWrap.appendChild(selectageOp);
		ageWrap.appendChild(selectageVal);
		fundAgeValue.appendChild(ageWrap);
		fundingStructureWrap.appendChild(fundAgeValue);//added grad value	
		
		//Funding Salary 	
		var fundSalaryValue = createInstanceElements("div","Input_HalfWidth Margin-20",'','','','','','','','','','','','','');
		
		var salWrap = createInstanceElements("div","ageValuesWrap Border",'','','','','','','','','','','','','');
		var salText = createInstanceElements("div","ageCriteriaText",'','','','','','','','','','','','','');
		salText.innerHTML = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.salaryCriteria")%>';
		var selectSalOp = createInstanceElements("select",'salMutualValidation',"fundingSalaryOperatorId_"+count,"fundingSalaryOperator_"+count,'','','','','','','','','','','');
		selectSalOp.innerHTML = ageOprtOption;
		var fundSalaryValueIp = createInstanceElements("input",'salMutualValidation',"fundingSalaryMonthId_"+count,'fundingSalaryMonth_'+count,'text','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.salary.month")%>','','oninput','decimalFieldValidation("fundingSalaryMonthId_' +count+ '","<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.decimal.message")%>")','','','','','','');
		fundSalaryValueIp.setAttribute('onblur','javascript:changetoDecimal("fundingSalaryMonthId_'+ count + '")');
		fundSalaryValueIp.setAttribute('style','float:right;width:48%!important;');
		if (salary != '' && salary != 'undefined') {
		fundSalaryValueIp.setAttribute('value',salary);
		}
		
		salWrap.appendChild(salText);
		salWrap.appendChild(selectSalOp);
		salWrap.appendChild(fundSalaryValueIp);
		fundSalaryValue.appendChild(salWrap);
		fundingStructureWrap.appendChild(fundSalaryValue);
		
		var textar = document.getElementById('generalNotesTxt').innerHTML;
		fundingStructureWrap.innerHTML += textar;
		
		//Order number
		var orderText = createInstanceElements("span","order-text",'','','','','','','','','','','','','');
		orderText.innerHTML='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.orderOfPriority")%>';
		fundingStructureWrap.appendChild(orderText);
		var orderNum = createInstanceElements("div","Input_Smallexd margin-right-22",'','','','','','','','','','','','','');
		orderNum.setAttribute('style','vertical-align: middle;');
		var orderNumdiv = createInstanceElements("div","",'','','','','','','','','','','','','');
		var OrderNumIP = createInstanceElements("input",'Requiredfield fundingOrderId',"fundingOrderId_"+count,'fundingOrderId_'+count,'text','Order*','','oninput','NumberValidation("fundingOrderId","","' +count+ '")','','','','','','');
		OrderNumIP.setAttribute('style','min-width:100px;max-width:100px;vertical-align: middle;');
		var ids = "'fundingOrderId'" + "," +"''"+","+count;
		OrderNumIP.setAttribute("onblur","validateDisplayOrder("+ids+")");
		OrderNumIP.setAttribute('value',count+1);
		
		orderNumdiv.appendChild(OrderNumIP);
		orderNum.appendChild(orderNumdiv);
		fundingStructureWrap.appendChild(orderNum);
		if (fundOrder != '' && fundOrder != 'undefined') {
			OrderNumIP.setAttribute('value',fundOrder);
			}
		
		fundingFieldsWrap.appendChild(fundingStructureWrap);
		secWrapFunding.appendChild(clsButtonDiv); //added button to close Funding instance 
		var feeInst = document.getElementById('basicFeeInstance').innerHTML;
		fundingFieldsWrap.innerHTML += feeInst;
		if(count == 0){
		var feeInstBttn = document.getElementById('feeInstButton').innerHTML;
		fundingFieldsWrap.innerHTML += feeInstBttn;
		}
		secWrapFunding.appendChild(fundingFieldsWrap);
		
		var selectSponseredElm = document.getElementById("fundingSponsoredId_"+count);
		if (sponsoredBy != '') {
			for (i = 0; i < selectSponseredElm.length; i++) {
		        if(sponsoredBy != selectSponseredElm.options[i].value){
		        	
		        }else{
		        	selectSponseredElm.selectedIndex = i;
		        }
		    }
		}
		
		var selectResElm = document.getElementById("fundingReslStatusId_"+count);
		if (residentStatus != '' && residentStatus != 'undefined' && residentStatus != 'NA') {
			for (i = 0; i < selectResElm.length; i++) {
				var rstat = residentStatus.split(",");
				for(var k=0;k<rstat.length;k++){
			        if(rstat[k] != selectResElm.options[i].value){
			        }else{
			        	selectResElm.options[i].selected = i;
			        }
				}    
		    }
		}
		
		if(sponsoredBy == selfSponsorId){
			selectResElm.classList.add("Requiredfield");
    	}else{
    		selectResElm.classList.remove("Requiredfield");
    	}
		
		var selectAgeElm = document.getElementById("fundingAgeOperatorId_"+count);
		if (ageOperator != '' && ageOperator != 'undefined') {
			for (i = 1; i < selectAgeElm.length; i++) {
		        if(ageOperator != selectAgeElm.options[i].value){
		        	
		        }else{
		        	selectAgeElm.options[i].selected = i;
		        }
		    }
		}
		
		var selectAgeValElm = document.getElementById("fundingAgeValueId_"+count);
		if (ageGroup != '' && ageGroup != 'undefined') {
			for (i = 1; i < selectAgeValElm.length; i++) {
		        if(ageGroup != selectAgeValElm.options[i].value){
		        	
		        }else{
		        	selectAgeValElm.options[i].selected = i;
		        }
		    }
		}
		
		var selectSalElm = document.getElementById("fundingSalaryOperatorId_"+count);
		if (salOperator != '' && salOperator != 'undefined') {
			for (i = 1; i < selectSalElm.length; i++) {
		        if(salOperator != selectSalElm.options[i].value){
		        	
		        }else{
		        	selectSalElm.options[i].selected = i;
		        }
		    }
		}

		var feeInstar = document.getElementsByClassName('feeInner_Fund');
		feeInstar[1].setAttribute("id","feeInner_Fund"+count+"_0");
		feeInstar[1].setAttribute("class","");
		
		if(count == 0){
		var feeInstBttn = document.getElementsByClassName('feeInstButton');
		feeInstBttn[1].setAttribute("id","feeInstButton_Fund"+count+"_0");
		feeInstBttn[1].setAttribute("href","javascript:addFeeInstances('_Fund"+count+"','', '', '', '','','')");
		feeInstBttn[1].setAttribute("class","Button-green button-pos-center");
		}
		
		var changeIdtextar = document.getElementsByClassName('fundingDescPostId');
		changeIdtextar[1].setAttribute("id","fundingDescPostId_"+count);
		changeIdtextar[1].setAttribute("name","fundingDescPost_"+count);
		changeIdtextar[1].setAttribute("class","GeneralNotes");
		if (fundingDescription != '') {
			document.getElementById("fundingDescPostId_"+count).innerHTML = fundingDescription;
		}

		var fndInstCnt = document.getElementsByClassName('globalCountId_Fund');
		fndInstCnt[1].setAttribute("id","globalCountId_Fund"+count+"_0");
		fndInstCnt[1].setAttribute("name","globalCountId_Fund"+count+"_0");
		fndInstCnt[1].setAttribute("class","");
		 if(feeItems != ''){
             for(key in feeItems){
             	var dispOrdVal = feeItems[key].displayOrder;
                 var feeTypeVal = feeItems[key].feeType;
                 var feeDescVal = feeItems[key].feeDesc;
                 var amountVal = feeItems[key].amount;
                 if(count == 0){
                 	addFeeInstances('_Fund'+count,dispOrdVal, feeTypeVal, feeDescVal, amountVal,'',''); //for adding fee instance "add component" button only for first fund criteria
                 }else{
                	 addFeeInstances('_Fund'+count,dispOrdVal, feeTypeVal, feeDescVal, amountVal,true,'');
                 }	
             }
         }else{
        	 if(isfirstInst == true){
        	 	addFeeInstances('_Fund'+count,'', '', '', '','','');
        	 }else{
        		 addFeeInstancesFromFirstFundingInstance('_Fund'+count);
        	}
         }
		
		
		document.getElementById("fundglobalCountId").value = count + 1;
		
    }
    
    function addFeeInstancesFromFirstFundingInstance(fundId){
    	var feeinstCount = document.getElementById("globalCountId_Fund0_0").value;
    	for(var k=0;k<feeinstCount;k++){
    		if(document.getElementById("displayOrderId_Fund0_"+k)){
	    		var displayOrder = document.getElementById("displayOrderId_Fund0_"+k).value;
	    		var feeTypeVal = document.getElementById("feeTypeId_Fund0_"+k).value;
	    		var feeDescVal = document.getElementById("feeDescDataId_Fund0_"+k).value;
	    		var amountVal = document.getElementById("feeAmountDataId_Fund0_"+k).value;
		    	addFeeInstances(fundId,displayOrder, feeTypeVal, feeDescVal, amountVal,true,k);
    		}	
    	}
    }
    
    function NumberValidation(dispid,fundId,cnt){
    	var z2 = /^[0-9]*$/;
    	var id = dispid+fundId+"_"+cnt;
    	var validateElem = document.getElementById(id);
    	//alert("id " + id + " validateElem " + validateElem);
    		if(!z2.test(validateElem.value)) { 
    			validateElem.classList.remove("Error-success");
    			validateElem.classList.add("Error");
    			validateElem.placeholder = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>';
    			validateElem.value = '';
    			return false;
    		}else{
    			if(fundId == "_Fund0"){
					var fundCount = parseInt(document.getElementById("fundglobalCountId").value);
		    		for(var f=1;f<fundCount;f++){
		    			var feeinstId = "_Fund"+f+"_"+cnt;
		    			if(document.getElementById(dispid+feeinstId)){
		    				document.getElementById(dispid+feeinstId).value = validateElem.value;
		    			}	
		    		}
				}
    			return true;
    		}
    }

    
    function submitFeeForm(fmId,wrapperInstance1,feeDesc){ 
 		var critInstancesCount =  parseInt(document.getElementById("globalCountId").value); 
 		var spCourseId = document.getElementById("spCourseId").value;
 		
 		AUI().use('aui-io-request', function(A){
 			startPreLoader("mainContainer");
 			A.io.request('${createFeeDetail}', 
 					{ method: 'post', 
 						form: { id: fmId }, 
 						data:{
 							critInstancesCount : critInstancesCount,
 							spCourseId : spCourseId,
 							feeDesc : feeDesc
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
										displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.feeDetails.feeupdated")%>');
									}else{
										// This case is very very rare
										displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.feesave.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
									}
								} else {
									displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.feesave.error")%>');
								}
								window.scrollTo(0,0);
							},
							failure : function() {
								displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.feesave.error")%>');
								window.scrollTo(0,0);
							}
						} 
 				}); 
 			}); 
 	}
    
    
    function addFeeInstances(fundId,dispOrdVal, feeTypeVal, feeDescVal, amountVal,isDisable,feeInst){
    	var fundCount = parseInt(document.getElementById("fundglobalCountId").value);
    	var countVal = document.getElementById("globalCountId"+fundId);
    	var count = 0;
    	if(fundId != ''){
    		count = parseInt(document.getElementById("globalCountId"+fundId+"_0").value);
    	}else{
    		count = parseInt(countVal.value);
    	}
    	if(feeInst != ''){
    		count = feeInst;
    	}
    	
    	var isDisplayOrderSeq = true;//validateDisplayOrder('displayOrderId',fundId,count);
    	if(isDisplayOrderSeq){
	    	var mainFeeWrapper = document.getElementById("feeInner"+fundId+"_0");
	    	//main wrapper
	    	var feeWrap = createInstanceElements("div","feeSection"+fundId,"feeSectionId"+fundId+"_"+count,'','','','','','','','','','','','');
	    	var secWrap = createInstanceElements("div","feeInnerData",'','','','','','','','','','','','','');
	    	feeWrap.appendChild(secWrap);
	    	 
	    	//close Button
	    	if(isDisable != true){
		    	var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId"+fundId+"_"+count,'','','','','','','','','','','','');
		    	var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeFeeinstances("'+fundId+'",'+count+');','','','','','','');
		    	var clsButtonImg = createInstanceElements("img",'','','','','','','','','/SPProduct-portlet/images/Product_create/Close-icon.svg','','','','','');
		    	clsButtonSpan.appendChild(clsButtonImg);
		    	clsButtonDiv.appendChild(clsButtonSpan);
		    	secWrap.appendChild(clsButtonDiv); //added button to schedule instance 
	    	}
	    	mainFeeWrapper.appendChild(feeWrap);
	    	
	    	//div Coloumn row
	    	  
	    	var clsColRow = createInstanceElements("div","Div_Col_row",'','','','','','','','','','','','','');
	    	
	     	//col1
	     	var clsColoumn1 = createInstanceElements("div","Div_col1",'','','','','','','','','','','','','');
	     	var dispOrd = createInstanceElements("input",'Requiredfield displayOrderId'+fundId,"displayOrderId"+fundId+"_"+count,'displayOrder'+fundId+'_'+count,'text','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.order.message")%> *','','oninput','NumberValidation("displayOrderId","'+fundId+'","' +count+ '")','','','','','','');
	     	var ids = "'" + fundId +"'"+","+count;
	     	ids = "'displayOrderId'" + "," + ids;
	     	dispOrd.setAttribute("onblur","validateDisplayOrder("+ids+")");
	     	if (dispOrdVal != '') {
	     	dispOrd.value = dispOrdVal;
	     	}
	     	if(isDisable == true){
	     		dispOrd.setAttribute("readOnly",true);
	     	}
	     	clsColoumn1.appendChild(dispOrd);
	    	clsColRow.appendChild(clsColoumn1);
	    	
	    	//Col2
	    	var feeDetailsOption = document.getElementById("feeTypeId").innerHTML;
	    	var clsColoumn2 = createInstanceElements("div","Div_col2",'','','','','','','','','','','','','');
	    	var seldiv = createInstanceElements("div","select_style",'','','','','','','','','','','','','');
	    	var selectCol2 = createInstanceElements("select",'Requiredfield feeTypeId'+fundId,"feeTypeId"+fundId+"_"+count,"feeType"+fundId+"_"+count,'','','','onChange','loadFeeTypeDecription("'+ fundId+'","' +count +'")','',true,'',true,' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>');
	    	selectCol2.setAttribute("onblur","requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>')");
	    	selectCol2.innerHTML = feeDetailsOption;
	    	if (feeTypeVal != '') {
	    	selectCol2.value =feeTypeVal;
	    	}
	    	if(isDisable == true){
	    		selectCol2.classList.add("selectDisabled");
	     	}
	    	seldiv.appendChild(selectCol2);
	    	clsColoumn2.appendChild(seldiv);
	    	clsColRow.appendChild(clsColoumn2);
	    	
	    	//Col3
	    	var clsColoumn3 = createInstanceElements("div","Div_col3",'','','','','','','','','','','','','');
	    	var feeDesc = createInstanceElements("div",'Div_col3_desc',"feeDescId"+fundId+"_"+count,'','','','','','','','','','','','');
	    	var feeDescDiv = createInstanceElements("div","Input_Fullwidth",'','','','','','','','','','','','','');
	    	var feeDescData = createInstanceElements("input",'',"feeDescDataId"+fundId+"_"+count,'feeDescData'+fundId+'_'+count,'hidden','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.feesDescription")%> *','','','','','','','','','');
	    	if (feeDescVal != '') {
	    		feeDesc.innerHTML = feeDescVal;
	    	feeDescData.value = feeDescVal;
	    	}
	    	feeDescDiv.appendChild(feeDescData);
	    	clsColoumn3.appendChild(feeDesc);
	    	clsColoumn3.appendChild(feeDescDiv);
	    	clsColRow.appendChild(clsColoumn3);
	
	    	//Col5
	    	var clsColoumn5 = createInstanceElements("div","Div_col5",'','','','','','','','','','','','','');
	    	var feeAmount = createInstanceElements("div",'',"feeAmountId_"+count,'','','','','','','','','','','','');
	    	var feeAmountDiv = createInstanceElements("div","Input_Fullwidth",'','','','','','','','','','','','','');
	    	var feeAmountData = createInstanceElements("input",'feeAmountData Requiredfield',"feeAmountDataId"+fundId+"_"+count,'feeAmountData'+fundId+'_'+count,'text','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fee.amount")%>*','10','oninput','decimalFieldValidation("feeAmountDataId'+fundId+'_' +count+ '","<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.decimal.message")%>")','','','','','','');
	    	feeAmountData.setAttribute('onblur','javascript:changetoDecimal("feeAmountDataId'+fundId+'_'+ count + '")');
	    	if (amountVal >= 0) {
	    	feeAmountData.value = amountVal;
	    	}
	    	feeAmountDiv.appendChild(feeAmountData);
	    	clsColoumn5.appendChild(feeAmountDiv);
	    	clsColoumn5.appendChild(feeAmount);
	    	clsColRow.appendChild(clsColoumn5);
	    	secWrap.appendChild(clsColRow);
	    	
	    	if(fundId != ''){
	    		document.getElementById("globalCountId"+fundId+"_0").value  = count + 1;
	    	}else{
	    		document.getElementById("globalCountId"+fundId).value = count + 1;
	    	}	
	    	
			if(fundId == "_Fund0"){
				var fundCount = parseInt(document.getElementById("fundglobalCountId").value);
				for(var f=1;f<fundCount;f++){
	    			var feeinstId = "_Fund"+f;
	    			addFeeInstances(feeinstId,'', '', '', '',true,'');
	    		}
				
	    	}
    	}	
    	
    }
    
    function loadFeeTypeDecription(fundId,cnt){
    	var isValidFeeType = validateFeeType(fundId,cnt);
    	if(isValidFeeType){
    	var count = fundId+"_"+cnt;
    	var feeType = document.getElementById("feeTypeId"+ count);
    	var feeTypeValue = feeType.options[feeType.selectedIndex].value;
    	var A = AUI();
    	var items = null;
    	var getFeeType = '${getFeeType}';
    	
    	A.io
    	.request(
    			getFeeType,
    			{
    				cache : false,
    				sync : true,
    				timeout : 1000,
    				dataType : 'json',
    				method : 'post',
    				data : {
    					feeTypeValue : feeTypeValue
    				},
    				on : {
    					success : function() {
    						items = this.get('responseData');
    						var feeTypeDesc = items["feeTypeDesc"];
    						if (items) {
    							document.getElementById("feeDescId"+count).innerHTML = feeTypeDesc;
    							document.getElementById("feeDescDataId"+count).value = feeTypeDesc;
    							if(fundId == "_Fund0"){
    								var fundCount = parseInt(document.getElementById("fundglobalCountId").value);
    					    		for(var f=1;f<fundCount;f++){
    					    			var feeinstId = "_Fund"+f+"_"+cnt;
    					    			document.getElementById("feeDescId"+feeinstId).innerHTML = feeTypeDesc;
    	    							document.getElementById("feeDescDataId"+feeinstId).value = feeTypeDesc;
    	    							var feeType = document.getElementById("feeTypeId"+ feeinstId);
    	    							feeType.value = feeTypeValue;
    					    		}
    							}
    						} else {

    						}

    					},
    					failure : function() {

    					}
    				}

    			});
    	}
    	
    }
    
    function initializeFeeInstances(){
    	console.log("feeinstance ");
    	if (feeDetail != 0) {
            for (key in feeDetail) {
                var items = feeDetail[key];
                console.log("items  " + key);
                for (key in items) {
                   var dispOrdVal = items[key].displayOrder;
                    var feeTypeVal = items[key].feeType;
                    var feeDescVal = items[key].feeDesc;
                    var amountVal = items[key].amount;

                    addFeeInstances('',dispOrdVal, feeTypeVal, feeDescVal, amountVal,'','');
                }
            }

        }else{
        	addFeeInstances('','', '', '', '','','');
        }
    }
    
    function initializeFeeFundInstances(){
    	console.log("fundinstance " + feeFundingDetail);
    	if (feeFundingDetail != 0) {
            for (key in feeFundingDetail) {
                var items = feeFundingDetail[key];
                console.log("fund items  " + key);
                 for (key in items) {
                    console.log("fund items key " + key);
                    console.log("fund activity " + items[key].feeDetails);
                    var fundOrder = items[key].fundOrder;
                    var sponsoredBy = items[key].sponsoredBy;
                    var residentStatus = items[key].residentStatus;
                    var fundingDescription = items[key].fundingDescription;
                    var ageOperator = items[key].ageOperator;
                    var ageGroup = items[key].ageGroup;
                    var salOperator = items[key].salOperator;
                    var salary = items[key].salary;
                    var feeItems = items[key].feeDetails;
                    addFundingInstances(fundOrder,sponsoredBy,residentStatus,fundingDescription,ageOperator,ageGroup,salOperator,salary,feeItems,true);
                } 
            }

        }else{
        	 addFundingInstances('','','','','','','','','',true);
        }
    }
    
    AUI().ready(function(A) {
    	//initializeFeeInstances();
    	if (feeDetail != 0) {
    		showFeeInstance();
    	}
    	if(isShowFunding){
	    	if (feeFundingDetail != 0) {
	    		showFundingInstance();
	    	}
    	}	
    });
    
    /* setTimeout(function(){ initializeFeeInstances(); }, 1000);
    setTimeout(function(){ initializeFeeFundInstances(); }, 1500); */
    
    </script>

