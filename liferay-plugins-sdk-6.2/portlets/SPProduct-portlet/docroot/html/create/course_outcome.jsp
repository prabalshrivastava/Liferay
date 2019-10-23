<%@ page import="com.sambaash.platform.srv.model.Outcome"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="javax.portlet.PortletConfig"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String outcomeDescLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.outcome.outcomeDescription");
	 //outcomeDescLabel = "Outcome Description";
	Outcome outcome = (Outcome)request.getAttribute("outcomeDetail");
	if(Validator.isNotNull(outcome)){
		outcomeDescLabel = outcome.getOutcomeDesc();
	}
%>
<jsp:useBean id="unicodeFormatter" class="com.liferay.portal.kernel.util.UnicodeFormatter"/>
<div class="Input_Fullwidth margin-20-topbottom">
	<input type="text" id="courseOutcomeTitleId" name="courseOutcomeTitle" value="${courseDetail.courseOutcomeTitle}"
		placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.courseOutcomeTitle")%> *" class="Requiredfield">
</div>
<div class="Input_Fullwidth margin-20-topbottom">
	<div class="Admin-textarea">
		<textarea name="outcomeDesc" id="outcomeDescId"
			placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.courseOutcomeDescription")%>">${courseDetail.courseOutcomeDesc}</textarea>

	</div>
</div>
<form action="#" method="POST" id="outcomeFmId" name="outcomefm">
<div id="outcomeInstSection" class="outcomeInstSection">
	<div class="Input_Fullwidth text-right ">
		<a href="javascript:addOutcomeInstances()"
			class="Button-green button-pos-right Add_Schedule"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.addOutcome")%></a>
			<div id="errorMsg-Modal"></div>
	</div>
	
	<%
	int i = 0;
	%>
	<div id="outcomeInst">
	<c:if test="${!empty courseOutcomeList}">
	<input type="hidden" id="globalCountId"  name="globalCountId" value="${courseOutcomeListLength}">
	<c:forEach var="courseOutcome" items="${courseOutcomeList}" varStatus="countVar">
		<%
		String otcEditorId = "outcome_description_" + i;
		%>
		<div class="outcome_wrapper" id="outComewrapperId_<%=i%>">
			<div class="close_button" id="closeButtonId<%=i%>">
				<span onclick="javascript:removeByInstanceIdWithMandatoryFields('outComewrapperId_<%=i%>','<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.required")%>')">
					<img src="/SPProduct-portlet/images/Product_create/Close-icon.svg" alt="Close">
				</span>
			</div>
			<div class="Input_Fullwidth ">
				<div class="select_style " id="Producttype1_select">
					<select id="outcomeTypeListId_<%=i %>" name="outcomeTypeList_<%=i %>"
						class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Outcome Type *', ' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.required")%>');">
						<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.outcomeType")%> *</option>
						
							<c:forEach var="outcomeType" items="${outcomeTypeList}">
									<c:if test="${courseOutcome.outcomeId ==  outcomeType.categoryId}">
										<option value="${outcomeType.categoryId}" selected>${outcomeType.name}</option>
									</c:if>
									<c:if test="${courseOutcome.outcomeId !=  outcomeType.categoryId}">
										<option value="${outcomeType.categoryId}">${outcomeType.name}</option>
									</c:if>
							</c:forEach>
						
					</select>
				</div>
			</div>
			
			<div class="Input_Fullwidth">
				<div class="Admin-textarea">
				
					<liferay-ui:input-editor name='<%= otcEditorId%>'
						editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
						initMethod='<%=i+"_initEditor_outcome_description"%>'
						cssClass="ckeditor" />
						<c:set var="courseOtcDesc" value="${courseOutcome.outcomeDesc}" />
						<%
							String courseOtcDesc = (String) pageContext.getAttribute("courseOtcDesc");
						%>
					<input type="hidden" name="Ip_outcome_description_<%=i%>"
					id="Ip_outcome_description_<%=i%>" value="${courseOutcome.outcomeDesc}">
					<aui:script>
									function <portlet:namespace /><%=i%>_initEditor_outcome_description() {
										<c:if test="${empty courseOutcomeList}">
											return "<%=UnicodeFormatter.toString(outcomeDescLabel)%>";
										</c:if>
										<c:if test="${!empty courseOutcomeList}">
											return "<%=UnicodeFormatter.toString(courseOtcDesc)%>";
										</c:if> 
										
									}
								</aui:script>
				</div>
			</div>
			
		</div><!--outcome_wrapper  -->
		<%
		i = i + 1;
	%>
		</c:forEach>
		</c:if>
		<c:if test="${empty courseOutcomeList}">
		<input type="hidden" id="globalCountId"  name="globalCountId" value="1">
			<div class="outcome_wrapper">
		
			<div class="Input_Fullwidth ">
				<div class="select_style " id="Producttype1_select">
					<select id="outcomeTypeListId_0" name="outcomeTypeList_0"
						class="Requiredfield"
						onblur="requiredFieldValidation(this, 'Outcome Type *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
						<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.outcomeType")%> *</option>
						<c:forEach var="outcomeType" items="${outcomeTypeList}">
							<option value="${outcomeType.categoryId}">${outcomeType.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="Input_Fullwidth">
				<div class="Admin-textarea">
					<liferay-ui:input-editor name='<%="outcome_description_0"%>'
						editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
						initMethod='<%="initEditor_outcome_description"%>'
						cssClass="ckeditor" />
					<input type="hidden" name="Ip_outcome_description_0"
					id="Ip_outcome_description_0" value="">
					<aui:script>
									function <portlet:namespace />initEditor_outcome_description() {
										return "<%=UnicodeFormatter.toString(outcomeDescLabel)%>";
									}
								</aui:script>
				</div>
			</div>
			
		</div><!--outcome_wrapper  -->
		</c:if>
	</div>
</div>	
</form>
	<script>
						
						function addOutcomeInstances(){
							var outComeDesc = '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.outcomeDescription")%>';
							var isValidate = validateForm("outcomeInst",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
							
							if(isValidate){
								var outcomeInstances = document.getElementsByClassName("outcome_wrapper");
								var count = parseInt(document.getElementById("globalCountId").value);
								//validateForSelectedOutcome(count);
								var mainOtcWrapper = document.getElementById("outcomeInst");
								//main wrapper
								var otcWrap = createInstanceElements("div","outcome_wrapper","outComewrapperId_"+count,'','','','','','','','','','','','');
								
								//close Button
								var clsButtonDiv = createInstanceElements("div","close_button","closeButtonId"+count,'','','','','','','','','','','','');
								var clsButtonSpan = createInstanceElements("span",'','','','','','','onclick','javascript:removeByInstanceIdWithMandatoryFields("outComewrapperId_'+count+'","<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.required")%>")','','','','','','');
								var clsButtonImg = createInstanceElements("img",'','','','','','','','','/SPProduct-portlet/images/Product_create/Close-icon.svg','','','','','');
								clsButtonSpan.appendChild(clsButtonImg);
								clsButtonDiv.appendChild(clsButtonSpan);
								otcWrap.appendChild(clsButtonDiv); //added button to outcometype instance 
								
								//outcomeTypeList
								var optionList = document.getElementById("outcomeTypeListId_0").innerHTML;
								var otcTypeListWrp = createInstanceElements("div",'Input_Fullwidth','','','','','','','','','','','','','');
								var otcTypeListDiv = createInstanceElements("div",'select_style',"outcometype1_select_"+count,'','','','','','','','','','','','');
								var otcTypeListSelect = createInstanceElements("select","Requiredfield","outcomeTypeListId_"+count,'outcomeTypeList_'+count,'','','','','','',true,'','',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>');
								otcTypeListSelect.innerHTML = optionList;
								otcTypeListDiv.appendChild(otcTypeListSelect);
								otcTypeListWrp.appendChild(otcTypeListDiv);
								otcWrap.appendChild(otcTypeListWrp);//added outcomeTypeList
								//ck-editor
								
								var ckEditorDiv = createInstanceElements("div","Input_Fullwidth margin-20-topbottom",'','','','','','','','','','','','','');
								var edtrName = "outcome_description_"+count;
								var edtrTxtArea = createInstanceElements("textarea",'Admin-textarea','',edtrName,'','<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.outcome.outcomeDescription")%>','','','','','','','','','');
								//edtrTxtArea.setAttribute("style","height:159px");
								ckEditorDiv.appendChild(edtrTxtArea);
								otcWrap.appendChild(ckEditorDiv);//added ck editor
								mainOtcWrapper.appendChild(otcWrap);
								validateOtionList(otcTypeListSelect,count);
								addCKEditor(edtrName,false,ckEditorDiv,outComeDesc);
								document.getElementById("globalCountId").value = count + 1;
							}
							
						}
						
						function validateOtionList(otcTypeListSelect,count){
							for(var k = 0;k<count;k++){
								var selectedOutcomeNode = document.getElementById("outcomeTypeListId_"+k);
								if(selectedOutcomeNode){
									var selectedOption = selectedOutcomeNode.options[selectedOutcomeNode.selectedIndex].value;
									for (var i=0; i<otcTypeListSelect.length; i++){
										  if (otcTypeListSelect.options[i].value == selectedOption ){
											  otcTypeListSelect.remove(i);
											  otcTypeListSelect.value=0;
										  }
									}
								}	
							}
						}
						
						function validateForSelectedOutcome(count){
							for(var k = 0;k<count;k++){
								var selectedOutcomeNode = document.getElementById("outcomeTypeListId_"+i);
								var selectedOption = selectedOutcomeNode.options[selectedOutcomeNode.selectedIndex].value;
								if(selectedOption == ''){
									selectedOutcomeNode.classList.remove("Error-success");
									selectedOutcomeNode.classList.add("Error");
									 var formOption = selectedOutcomeNode.options;
									 formOption[0].innerHTML = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>';
								}
							}
							
						}
						</script>
