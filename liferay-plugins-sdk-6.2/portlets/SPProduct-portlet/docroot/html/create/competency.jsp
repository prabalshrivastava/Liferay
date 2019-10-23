<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>



<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createCompetencyUnits">
	<portlet:param name="action" value="addCompetencyUnits"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<div class="Product_Section screen-max-width">
	<div class="Product_Sidebar">
		<%@ include file="/html/create/navigation.jsp"%>
	</div>

	<div class="Product_wrapper" id="mainContainer">
		<div class="Border">
			<!--HEADER-->
			<div class="Product_header">
				<div class="Prod-Headtitle">
					<h2><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.competencyUnit")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listCompetency%>"><span><</span><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>

				</div>

				<div class="Prod-HeadContent">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/images/Product_create/Icon-CompetencyUnit.svg" alt="Competency">
						<c:if test="${empty competencyDetail.spCompetencyUnitId}">
							<h2 id="header"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.competencyUnit.createCompetency")%></h2>
						</c:if>
						<c:if test="${not empty competencyDetail.spCompetencyUnitId}">
							<h2 id="header"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.updateCompetency")%></h2>
						</c:if>
						
						
					</a>
				</div>
			</div>
			<div class="active-content-Sec  ProdBorder-active">
				<span></span>
			</div>
			<!--HEADER END-->
			<!--CONTENTSECTION FRAMEWORK-->
			<div class="Product_contsection">
				<div id="Product_Competency">
					<div class="Form-Prodsection Form-padding ">
						<input type="hidden" id="spCompetencyUnitId"
							name="spCompetencyUnitId"
							value="${competencyDetail.spCompetencyUnitId}">
						<div class="Input_HalfWidth Margin-20">
							<input type="text" id="competencyUnitCodeId"
								value="${competencyDetail.competencyUnitCode }" maxlength="75"
								name="competencyUnitCode" class="Requiredfield "
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.competencyUnitCode")%> *"
								onblur="requiredFieldValidation( this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.competencyUnitCode")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
							<div class="icon-right">CUC</div>

						</div>
						<div class="Input_HalfWidth ">
							<div class="select_style" id="Producttype1_select">
								<select id="competencyLevelListId" name="competencyLevelList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.competencyLevel")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.competencyLevel")%> *</option>
									<c:forEach var="competencyLevel" items="${competencyLevelList}">
										<c:if
											test="${competencyDetail.competencyLevel == competencyLevel.categoryId}">
											<option value="${competencyLevel.categoryId}" selected>${competencyLevel.name}</option>
										</c:if>
										<c:if
											test="${competencyDetail.competencyLevel != competencyLevel.categoryId}">
											<option value="${competencyLevel.categoryId}">${competencyLevel.name}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>

						</div>
						<div class="Input_Fullwidth">
							<div class="Admin-textarea">
								<textarea name="competencyUnitDesc" maxlength="250"
									id="competencyUnitDescId"
									placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.competencyDescription")%>">${competencyDetail.competencyUnitDesc }</textarea>
							</div>

						</div>
						<div class="Input_HalfWidth Margin-20">
							<input type="text" id="cvsId" maxlength="75" name="cvs"
								value="${competencyDetail.creditValue }" placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.credits")%> *"
								class="Requiredfield Numberfield"
								onblur="numberfieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.credits")%> *', ' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.number.message")%>',' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.message")%>');">
							<div class="icon-right">CVs</div>

						</div>
						<div class="Input_HalfWidth ">
							<div class="select_style" id="Producttype1_select">
								<select id="jobFamilyListId" name="jobFamilyList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.jobFamily")%> *' , ' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.jobFamily")%> *</option>
									<c:forEach var="jobFamily" items="${jobFamilyList}">
										<c:if
											test="${competencyDetail.jobFamily == jobFamily.categoryId}">
											<option value="${jobFamily.categoryId}" selected>${jobFamily.name}</option>
										</c:if>
										<c:if
											test="${competencyDetail.jobFamily != jobFamily.categoryId}">
											<option value="${jobFamily.categoryId}">${jobFamily.name}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>

						</div>
						<div class="Input_HalfWidth Margin-20">
							<div class="select_style" id="Producttype1_select">
								<select id="frameworkListId" name="frameworkList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.frameworkCode")%> *' , ' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.frameworkCode")%> *</option>
									<c:forEach var="framework" items="${frameworkList}">
										<c:if
											test="${competencyDetail.spFrameworkId == framework.spFrameworkId}">
											<option value="${framework.spFrameworkId}" selected>${framework.frameworkCode}
												- ${framework.frameworkName}</option>
										</c:if>
										<c:if
											test="${competencyDetail.spFrameworkId != framework.spFrameworkId}">
											<option value="${framework.spFrameworkId}">${framework.frameworkCode}
												- ${framework.frameworkName}</option>
										</c:if>

									</c:forEach>
								</select> 
							</div>

						</div>
						<div class="Input_HalfWidth ">
							<div class="select_style" id="Producttype1_select">
								<select id="countryListId" name="countryList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.originCountry")%> *', ' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.originCountry")%>
										*</option>
									<c:forEach var="country" items="${countryList}">
										<c:if
											test="${competencyDetail.countryId == country.categoryId}">
											<option value="${country.categoryId}" selected>${country.name}</option>
										</c:if>
										<c:if
											test="${competencyDetail.countryId != country.categoryId}">
											<option value="${country.categoryId}">${country.name}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>

						</div>
					</div>
					<div>
						<!--CONTENTSECTION FRAMEWORK-->
					</div>
				</div>
			</div>
		</div>
		<div class="Product_bottom">
			<a href="<%=listCompetency%>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
				onclick="saveCompetency();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
		</div>
	</div>

</div>

<script type="text/javascript">


	/* var autoCompleteFrameworkList = "'" + ${autoCompleteFrameworkList} +"'";
	var res = autoCompleteFrameworkList.split(",");
	var dataList = autoCompleteFrameworkList;

	AUI().use('aui-autocomplete', function(A) {
		var continents = [ dataList ];

		new A.AutoComplete({
			contentBox : '#frameworkListId',
			dataSource : continents
		}).render();
	});
 */
 
	function saveCompetency() {
		var isValidate = validateForm("Product_Competency",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate) {

			AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A){
				var items = null;
				var createCompetency = '${createCompetencyUnits}';
	
				var compLevelListNode = document
						.getElementById("competencyLevelListId");
				var jobFamilyListNode = document.getElementById("jobFamilyListId");
				var frameworkListNode = document.getElementById("frameworkListId");
				var countryListNode = document.getElementById("countryListId");
	
				try {
					startPreLoader("mainContainer");
					A.io
							.request(
									createCompetency,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											spCompetencyUnitId : document
													.getElementById("spCompetencyUnitId").value,
											competencyUnitCode : document
													.getElementById("competencyUnitCodeId").value,
											competencyLevel : compLevelListNode.options[compLevelListNode.selectedIndex].value,
											competencyUnitDesc : document
													.getElementById("competencyUnitDescId").value,
											cvs : document.getElementById("cvsId").value,
											jobFamily : jobFamilyListNode.options[jobFamilyListNode.selectedIndex].value,
											framework : frameworkListNode.options[frameworkListNode.selectedIndex].value,
											country : countryListNode.options[countryListNode.selectedIndex].value,
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
														}else if(data.spCompetencyUnitId > 0){
															// here data.spCompetencyUnitId = value returned from server
															//  spCompetencyUnitId is value submitted to server
															var spCompetencyUnitIdNode = A.one("#spCompetencyUnitId");
															var spCompetencyUnitId = spCompetencyUnitIdNode.val();
															spCompetencyUnitIdNode.val(data.spCompetencyUnitId);
															if(spCompetencyUnitId > 0){ //existing
																displaySuccess('<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.updated")%>');
															}else{
																displaySuccess('<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.created")%>');
																A.one("#header").setContent('<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.competencyUnit.updateCompetency")%>');
															}
														}else{
															// This case is very very rare
															displayError('<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.competencyUnit.save.error")%><%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.screen.refresh")%>');
														}
													} else {
														displayError('<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.competencyUnit.save.error")%>');
													}
													window.scrollTo(0,0);
												},
												failure : function() {
													displayError('<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.competencyUnit.save.error")%>');
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

