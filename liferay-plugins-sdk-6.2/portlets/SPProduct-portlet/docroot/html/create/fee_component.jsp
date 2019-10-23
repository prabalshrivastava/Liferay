<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>



<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createFeeComponent">
	<portlet:param name="action" value="createFeeComponent"></portlet:param>
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
					<h2><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.feeTypeComponent")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=manageFeeComponent%>">
						<span></span><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>

				</div>

				<div class="Prod-HeadContent">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/images/Product_create/Icon-CompetencyUnit.svg">
						<c:if test="${empty feeComponentDetail.spFeeTypeId}">
							<h2 id="header">
							<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeComponent.createFeeComponent")%></h2>
						</c:if>
						<c:if test="${not empty feeComponentDetail.spFeeTypeId}">
							<h2 id="header">
							<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.feeComponent.updateFeeComponent")%></h2>
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
				<div id="Product_FeeComponent">
					<div class="Form-Prodsection Form-padding ">
						<input type="hidden" id="spFeeTypeId" name="spFeeTypeId" value="${feeComponentDetail.spFeeTypeId}">
						<div class="Input_HalfWidth Margin-20">
						
						<c:choose>
							<c:when test="${feeComponentDetail.spFeeTypeId > 0}">
							<input type="hidden" id="spFeeTypeCode" name="spFeeTypeCode" value="${feeComponentDetail.feeType}">
							<input type="text" id="spFeeTypeCode"  disabled="disabled"
								value="${feeComponentDetail.feeType}" maxlength="75"
								name="spFeeTypeCode" class="Requiredfield "
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.feeType")%> *"
								onblur="requiredFieldValidation( this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.feeType")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
							
							</c:when>
							<c:otherwise>
							<input type="text" id="spFeeTypeCode"
								value="${feeComponentDetail.feeType}" maxlength="75"
								name="spFeeTypeCode" class="Requiredfield "
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.feeType")%> *"
								onblur="requiredFieldValidation( this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.feeType")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
							
							</c:otherwise>
						</c:choose>
							

						</div>
						<div class="Input_HalfWidth ">
							<div class="select_style" id="Producttype1_select">
								<select id="feeTypeMisc" name="misc"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.misc")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected>
										<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.misc")%> *
									</option>
									<c:choose>
										<c:when test="${feeComponentDetail.misc == 'true'}">
											<option value="true" selected>Yes</option>
										</c:when>
										
										<c:otherwise>
											<option value="true">Yes</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${feeComponentDetail.misc == 'false'}">
											<option value="false" selected>No</option>
										</c:when>
										<c:otherwise>
											<option value="False">No</option>
										</c:otherwise>
									</c:choose>
								</select> 
							</div>

						</div>
						<div class="Input_Fullwidth">
							<div class="Admin-textarea">
								<input type="text" name="feeTypeName" maxlength="250"
									id="feeTypeName" value="${feeComponentDetail.feeTypeName }"
									placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.feeTypeName")%>"/>
							</div>

						</div>
						<div class="Input_Fullwidth">
							<div class="Admin-textarea">
								<textarea name="feeTypeDesc" maxlength="250"
									id="feeTypeDesc"
									placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.feeTypeDesc")%>">${feeComponentDetail.feeTypeDesc }</textarea>
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
			<a href="<%=manageFeeComponent%>">
			<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a>
			<a href="javascript:;" onclick="saveFeeCoomponent();">
			<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
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
 
	function saveFeeCoomponent() {
		var isValidate = validateForm("Product_FeeComponent",
				'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',
				'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>',
				'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>',
				'<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate) {

			AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A){
				var items = null;
				var createFeeComponent = '${createFeeComponent}';
	
				var spFeeTypeId = document.getElementById("spFeeTypeId");
				var spFeeTypeCode = document.getElementById("spFeeTypeCode");
				var feeTypeMisc = document.getElementById("feeTypeMisc");
				var feeTypeName = document.getElementById("feeTypeName");
				var feeTypeDesc = document.getElementById("feeTypeDesc");
	
				try {
					startPreLoader("mainContainer");
					A.io.request(createFeeComponent, {
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											spFeeTypeId : document.getElementById("spFeeTypeId").value,
											spFeeTypeCode : document.getElementById("spFeeTypeCode").value,
											feeTypeMisc : document.getElementById("feeTypeMisc").value,
											feeTypeDesc : document.getElementById("feeTypeDesc").value,
											feeTypeName : document.getElementById("feeTypeName").value
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
														}else if(data.spFeeTypeId > 0){
															// here data.spCompetencyUnitId = value returned from server
															//  spCompetencyUnitId is value submitted to server
															var spFeeTypeIdNode = A.one("#spFeeTypeId");
															var spFeeTypeId = spFeeTypeIdNode.val();
															spFeeTypeIdNode.val(data.spFeeTypeId);
															if(spFeeTypeId > 0){ //existing
																displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.updated")%>');
															}else{
																displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.created")%>');
																A.one("#header").setContent('<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.product.update.feeComponent.updateFeeComponent")%>');
															}
														}else{
															// This case is very very rare
															displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay, 
																	"label.product.create.feeComponent.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay, 
																			"label.product.screen.refresh")%>');
														}
													} else {
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.feeComponent.save.error")%>');
													}
													window.scrollTo(0,0);
												},
												failure : function() {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeComponent.save.error")%>');
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

