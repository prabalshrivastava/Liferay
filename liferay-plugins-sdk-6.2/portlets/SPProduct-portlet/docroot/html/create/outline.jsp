<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
	String outlineDescriptionLabel = "Outline Description (Knowledge / Skill)";
	outlineDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.outlineDescription");
%>


<portlet:resourceURL var="createOutline">
	<portlet:param name="action" value="addOutline"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<div class="Product_Section screen-max-width">
<div class="Product_Sidebar">
	<%@ include file="/html/create/navigation.jsp"%>
	</div>

	<div class="Product_wrapper">
		<div class="Border" id="mainContainer">

			<!--HEADER-->
			<div class="Product_header">
				<div class="Prod-Headtitle">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outline")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listOutline%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>
			</div>
<div class="form-section ">
					<div class="Input_Fullwidth ">
						<div class="course-create Prod-HeadContent" id="CourseNew_click">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/images/Product_create/create-new.png" alt="Create">
								<c:if test="${empty outlineDetail.spOutlineId}">
									<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outline.createOutline")%></h2>
								</c:if>
								<c:if test="${not empty outlineDetail.spOutlineId}">
									<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.updateOutline")%></h2>
								</c:if>
							</a>
						</div>
					</div>

		</div>
		<div class="active-content-Sec  ProdBorder-active">
			<span></span>
		</div>
		<!--HEADER END-->
		<!--CONTENTSECTION FRAMEWORK-->
		<div id="outline-section">
			<div class="Form-Prodsection Form-padding "></div>
			<div class="Product_contsection">
				<div id="Product_Outline">
					<div class="Outline_wrapper" id="outlineWrapperId">
						<div class="Form-Prodsection Form-padding   ">
							<input type="hidden" id="spOutlineId" name="spOutlineId"
								value="${outlineDetail.spOutlineId}">
							<div class="Input_Search_halfwidth Margin-20">
								<div class="select_style" id="Producttype1_select">
									<select id="competencyUnitCodeListId"
										name="competencyUnitCodeList" class="Requiredfield"
										onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.competencyUnitCode")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
										<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.competencyUnitCode")%> *</option>
										<c:forEach var="competencyUnitCode" items="${competencyUnitCodeList}">
											<c:if test="${outlineDetail.spCompetencyUnitId == competencyUnitCode.spCompetencyUnitId }">
												<option value="${competencyUnitCode.spCompetencyUnitId}" selected>${competencyUnitCode.competencyUnitCode}</option>
											</c:if>
											<c:if test="${outlineDetail.spCompetencyUnitId != competencyUnitCode.spCompetencyUnitId }">
												<option value="${competencyUnitCode.spCompetencyUnitId}">${competencyUnitCode.competencyUnitCode}</option>
											</c:if>
										</c:forEach>
									</select> 
								</div>
							</div>
							<div class="Input_Fullwidth">
								<div class="select_style" id="ProgressionCategory1_select">
									<select id="outlineTypeListId" name="outlineTypeList"
										class="outlineTypeList Requiredfield"
										onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outline.outlineType")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');" onchange="loadSkillsList()">
										<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outline.outlineType")%> *</option>
										<c:forEach var="outlineType" items="${outlineTypeList}">
											<c:if
												test="${outlineDetail.outlineType == outlineType.categoryId}">
												<option value="${outlineType.categoryId}" selected>${outlineType.name}</option>
												<c:set var="outLineTypeName" value="${outlineType.name}" scope="page"/> 
											</c:if>
											<c:if
												test="${outlineDetail.outlineType != outlineType.categoryId}">
												<option value="${outlineType.categoryId}">${outlineType.name}</option>
											</c:if>
										</c:forEach>
									</select> 

								</div>
							</div>
							<c:if test="${empty outlineDetail}">
								<div class="Input_Fullwidth margin-20-topbottom" id="outlineEditor">
									<liferay-ui:input-editor name='<%="outline_description"%>'
										editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
										initMethod='<%="initEditor_outline_description"%>'
										cssClass="ckeditor" />
									<aui:script>
										function <portlet:namespace />initEditor_outline_description() {
											return "<%=UnicodeFormatter.toString(outlineDescriptionLabel)%>";
										}
									</aui:script>
								</div>
							
								<div class="Display-none" id="outlineType_select">
									<div id="selectedSkills" class="selectedSkills selectedList"></div>
									<input name="skillsList" class="selectedListInput skillsList" id="skillsListId" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outline.addSkill")%> *">
									<div class="search_icon">
                                       <img src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
                                    </div>
									
								</div>
							</c:if>	
							
							<c:if test="${!empty outlineDetail}">
									<div class="Input_Fullwidth margin-20-topbottom" id="outlineEditor">
										<liferay-ui:input-editor name='<%="outline_description"%>'
											editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
											initMethod='<%="initEditor_outline_descriptions"%>'
											cssClass="ckeditor" />
											<c:set var="outlineDescription" value="${outlineDetail.outlineDesc }"/>
											<% String outLineDesc = (String) pageContext.getAttribute("outlineDescription"); %>
										<aui:script>
											function <portlet:namespace />initEditor_outline_descriptions() {
												return "<%=UnicodeFormatter.toString(outLineDesc)%>";
											}
										</aui:script>
									</div>
							</c:if>		
						</div>
					</div>
				</div>

				</div>
			</div>
		</div>
		<div class="Product_bottom">
			<a href="<%= listOutline %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
				onclick="saveOutline();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
		</div>
	</div>
</div>


<script type="text/javascript">

	function saveOutline() {

		var isValidate = validateForm("Product_Outline",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate) {
			AUI().use('aui-node','aui-io-request',function(A){
				var items = null;
				var createOutline = '${createOutline}';
				var outlineTypeListNode = document
						.getElementById("outlineTypeListId");
				var outlineDesc = "";
				if(window.<portlet:namespace />outline_description){
				 outlineDesc = window.<portlet:namespace />outline_description
						.getHTML();
				}
				var competencyUnitCodeListNode = document
						.getElementById("competencyUnitCodeListId");
				
	
				try {
					startPreLoader("mainContainer");
					A.io
							.request(
									createOutline,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											spOutlineId : document
													.getElementById("spOutlineId").value,
											outlineType : outlineTypeListNode.options[outlineTypeListNode.selectedIndex].value,
											competencyUnitCodeId : competencyUnitCodeListNode.options[competencyUnitCodeListNode.selectedIndex].value,
											outlineDescription : outlineDesc,
										},
										on : {
											complete : function(){
												stopPreLoader("mainContainer");
											},
											success : function() {
												var data = this.get('responseData');
												if (data) {
													if(data.error){
														displayError(data.error);
													}else if(data.spOutlineId > 0){
														// here data.spOutlineId = value returned from server
														//  spOutlineId is value submitted to server
														var spOutlineIdNode = A.one("#spOutlineId");
														var spOutlineId = spOutlineIdNode.val();
														spOutlineIdNode.val(data.spOutlineId);
														if(spOutlineId > 0){ //existing
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outline.updated")%>');
														}else{
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.outline.created")%>');
															A.one("#header").setContent('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.updateOutline")%>');
														}
													}else{
														// This case is very very rare
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.outline.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
													}
												} else {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.outline.save.error")%>');
												}
												window.scrollTo(0,0);
											},
											failure : function() {
												displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.outline.save.error")%>');
												window.scrollTo(0,0);
											}
										}
	
									});
				} catch (err) {
					alert(err);
				}
			});
		}

	}
</script>
