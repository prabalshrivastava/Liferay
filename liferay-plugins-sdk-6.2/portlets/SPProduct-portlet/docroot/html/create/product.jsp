<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.model.Product"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcess"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Locale"%>


<script src="<%=request.getContextPath()%>/js/dropzone.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
 boolean showPersona = GetterUtil.getBoolean(portletPreferences.getValue("showPersona", ""));
%>

<portlet:resourceURL var="createProduct">
	<portlet:param name="action" value="addProduct"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadProductImage">
	<portlet:param name="action" value="uploadProductImage"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadProductBannerImage">
	<portlet:param name="action" value="uploadProductBannerImage"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadProductVideos">
	<portlet:param name="action" value="uploadProductVideos"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadProductBrochures">
	<portlet:param name="action" value="uploadProductBrochures"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadProductFormImage">
	<portlet:param name="action" value="uploadProductFormImage"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<div class="product_create screen-max-width margin-top-40">
	<div class="product_create_wrapper ">

		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>

		<div class="Right_content_section">
			<div class="Border" id="mainContainer">
				<div class="heading-title Border-bottom">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.product")%></h2>
					<div class="Backtolist-btn"><a href="<%=listProduct%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a></div>
				</div>

				<%-- <%@ include file="/html/create/navigation.jsp"%> --%>

				<div class="form-section ">
					<div class="Input_Fullwidth ">
						<div class="course-create" id="CourseNew_click">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/images/Product_create/Icon_Cproduct.png" alt="Product">
								<c:if test="${empty spProductId}">
									<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.createProduct")%></h2>
								</c:if>
								<c:if test="${not empty spProductId}">
									<h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.updateProduct")%></h2>
								</c:if>
							</a>
						</div>
					</div>
				</div>
				<div id="productInner">
					<div class="form-section ">
						<div class="Input_Fullwidth">
						<input type="hidden" value="${spProductId}" name="spProductIdValue" id="spProductIdValue">
							<input type="text" name="productName" id="productNameId"
								value="${productDetail.productName}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.productName")%>*"
								class="Requiredfield"
								onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.productName")%>*', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');" maxlength="500">
						</div>
						<c:set var="productImageId"
							value="${productDetail.productImageId }" />
						<%
							Long imgId = (Long) pageContext.getAttribute("productImageId");
													String imgUrl = "";
													if (imgId != null && imgId.compareTo(Long.parseLong("0")) != 0 ) {
														try{
														imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(imgId),
																themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																themeDisplay.getPathContext(), 1);
														}catch(Exception e){
															
														}
													}
													if(imgUrl != ""){
						%>
						<div class="productImages imageContainer" id="productImageId">
							<div>
								<img src="<%=imgUrl%>" alt="Product">
							</div>
							<div>
								<button onClick="removeImage('productImageId','productImageFileEntryId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
							</div>
						</div>
						<%} %>
						<div class="Image_upload" id="productImage">
							<form action="${uploadProductImage}" class="dropzone"
								id="productImageDropzone">
								<input type="hidden" id="productImageFileEntryId"
									name="productImageFileEntry" class="imageField"
									value="${productDetail.productImageId}">
							</form>
						</div>
						
						<%@include file="/html/create/imagespecNote.jsp" %>

						<div class="Input_Fullwidth margin-top-20">
							<div id="SelectedSpecialization"
								class="SelectedSpecialization selectedList"></div>
						</div>		
						<div class="Input_Fullwidth">
						<!-- Requiredfield -->
								<input name="specializationToBeSaved" id="specializationToBeSavedId" type="hidden" value="0" class=" autoComplete" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.addSpecialization")%>*">
							<input name="specializationList"
								class="specializationList selectedListInput"
								id="specializationListId" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.addSpecialization")%>*">
							<div class="search_icon">
								<img
									src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
							</div>
						</div>
						
						<c:if test="<%=showPersona %>">
						<div class="Input_Fullwidth margin-top-20">
							<div id="SelectedPersona"
								class="SelectedPersona selectedList"></div>
						</div>		
						<div class="Input_Fullwidth">
						<!-- Requiredfield -->
								<input name="personaToBeSaved" id="personaToBeSavedId" type="hidden" value="0" class=" autoComplete" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addPersona")%>*">
							<input name="personaList"
								class="personaList selectedListInput"
								id="personaListId" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addPersona")%>*">
							<div class="search_icon">
								<img
									src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
							</div>
						</div>
						</c:if>

						<div class="Input_HalfWidth Margin-20">
							<div class="select_style" id="Producttype1_select">
								<select id="countryListId" name="countryList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.originCountry")%>*', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
									<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.originCountry")%>
										*</option>
									<c:forEach var="country" items="${countryList}">
										<c:if test="${productDetail.countryId == country.categoryId }">
											<option value="${country.categoryId}" selected>${country.name}</option>
										</c:if>
										<c:if test="${productDetail.countryId != country.categoryId }">
											<option value="${country.categoryId}">${country.name}</option>
										</c:if>
									</c:forEach>
								</select> 
							</div>
						</div>
						<div class="Input_HalfWidth Summary_input">
							<input type="text" id="creditValueId"
								name="creditValue" value="${productDetail.creditValues}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.creditValue")%>*" class=" Requiredfield Numberfield" onblur="numberfieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.creditValue")%>*', '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.message")%>');">
							<div class="icon-right">Cvs</div>
						</div>
						<div class="Input_HalfWidth Margin-20">
							<div class="select_style" >
							<select id="PEProcessId" name="PEProcessId">
							<%
							   String OPTION  = "<option value=%s %s>%s</option>";
							   Product product = (Product)request.getAttribute("productDetail");
							   long slctProcessId = 0;
							   if(product != null){
								   slctProcessId = product.getPEProcessId();
							   }
							   List<PEProcess> processList = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
							   out.print(String.format(OPTION, StringPool.BLANK,StringPool.BLANK, LabelUtil.getLabel(pageContext, themeDisplay,"label.product.selectProcess")));
							   String selectd = StringPool.BLANK;
							   for(PEProcess process :processList){
								   selectd = StringPool.BLANK;
								   if(process.getSpPEProcessId() == slctProcessId){
									   selectd = "selected";
								   }
								   out.print(String.format(OPTION, process.getSpPEProcessId(),selectd,process.getName()));
							   }
							%>
							</select>
							</div>
						</div>
						<%-- <div class="Input_HalfWidth Margin-20" style="color:black;">
						<%
							long spProductId = Long.parseLong((String)renderRequest.getAttribute("spProductId"));
							long classNameId = ClassNameLocalServiceUtil.getClassNameId(Product.class);
							JSONArray invArr = SPShoppingLocalServiceUtil.retrieveProductInventory(classNameId, spProductId);
							int remInv = SPShoppingLocalServiceUtil.retrieveRemainingInventory(classNameId, spProductId);
							for (int i=0; i<invArr.length(); i++) {
								JSONObject invObj = invArr.getJSONObject(i);
						%>
							<p>
							startDate = <%= invObj.getString("startDate") %> <br>
							endDate = <%= invObj.getString("endDate") %> <br>
							quantity = <%= invObj.getInt("quantity") %> <br>
							</p>
							<br>
							<p>
								remaining inventory: <%= remInv %>
							</p>
						<% 
							}
						%>
						</div> --%>
						<div class="form-section Border Form-bg ">
							<div class="form-inner Form-padding">
								<div class="Input_Search_Fullwidth">
									<div class="select_style" id="Producttype1_select">
										<select id="courseListId" name="courseList"
											class="Requiredfield"
											onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.selectCourse")%>*', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');">
											<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.selectCourse")%>
												*</option>
											<c:forEach var="course" items="${courseList}">
												<c:if
													test="${productDetail.spCourseId == course.spCourseId }">
													<option value="${course.spCourseId}" selected>${course.courseName} [ ${course.courseCode} ]</option>
												</c:if>
												<c:if
													test="${productDetail.spCourseId != course.spCourseId }">
													<option value="${course.spCourseId}">${course.courseName} [ ${course.courseCode} ]</option>
												</c:if>
											</c:forEach>
										</select> 
									</div>
								</div>
							</div>
						</div>
						<div class="productVideos imageContainer" id="productVideoId">
						<c:set var="productVideoId"
							value="${productDetail.productVideoFolderId }" />
						<%
						if(pageContext.getAttribute("productVideoId") != null) {
							Long videoFolderId = (Long) pageContext.getAttribute("productVideoId");
							if(videoFolderId > 0) {
							List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), videoFolderId);
														String videoUrl = "";
														long videoId = 0;
														for(FileEntry fileEntry : fileEntryList){
															videoId = fileEntry.getFileEntryId();
														if (videoId > 0 ) {
															videoUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(videoId),
																	themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																	themeDisplay.getPathContext(), 1);
														}
														if(videoUrl != ""){
							%>
	
							
								<div>
									<img src="<%=videoUrl%>" alt="Product Video">
								</div>
								<div>
									<button onClick="removeImage('productVideoId','productVideosFolderId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
								</div>
							
							<%}
								}
							}
						}
						%>
						</div>
						<div class="Image_upload" id="productVideo">
							<form action="${uploadProductVideos}" class="dropzone"
								id="productVideosDropzone">
								<input type="hidden" id="productVideosFolderId"
									name="productVideosFolder"
									value="${productDetail.productVideoFolderId}">
							</form>
						</div>
						<div class="footNoteMsg"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.fileSize.message")%></div>
						<div class="productBrochures imageContainer" id="productBrochureId">
						<c:set var="productBrochureId"
							value="${productDetail.productBrochuresFolderId }" />
						<%
						String brochureUrl = "";
						if(pageContext.getAttribute("productBrochureId") != null) {
							Long brochureFolderId = (Long) pageContext.getAttribute("productBrochureId");
							if(brochureFolderId > 0) {
								List<FileEntry> fileEntryBList = null;
								try{
								fileEntryBList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), brochureFolderId);
								}catch(Exception e){
									
								}
								if(fileEntryBList != null){
														long brochureId = 0;
														for(FileEntry fileEntry : fileEntryBList){
															brochureId = fileEntry.getFileEntryId();
														if (brochureId > 0 ) {
															brochureUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(brochureId),
																	themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																	themeDisplay.getPathContext(), 1);
														}
														if(brochureUrl != ""){
							%>
							
								<div>
									<img src="<%=brochureUrl%>" alt="Product Brochure">
								</div>
								<div>
									<button onClick="removeImage('productBrochureId','productBrochuresFolderId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
								</div>
							
							<%
								}
														}
														}
							}
						}
						%>
						</div>
						<div class="Image_upload" id="productBrochure">
							<form action="${uploadProductBrochures}" class="dropzone"
								id="productBrochuresDropzone">
								<input type="hidden" id="productBrochuresFolderId"
									name="productBrochuresFolder"
									value="${productDetail.productBrochuresFolderId}">
							</form>
						</div>
						<div class="footNoteMsg"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.fileSize.message")%></div>
						
						<!-- banner Image -->
						
						<div class="productBannerImage" id="productBannerImageDivId">
						<c:set var="productBannerImageId"
							value="${productDetail.productBannerImageId }" />
						<%
						String bImgUrl = "";
						if(pageContext.getAttribute("productBannerImageId") != null) {
							try{
								Long bImgId = (Long) pageContext.getAttribute("productBannerImageId");
								
								if (bImgId != null && bImgId.compareTo(Long.parseLong("0")) != 0 ) {
									bImgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(bImgId),
											themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
											themeDisplay.getPathContext(), 1);
								}
								if(bImgUrl != ""){
							%>
	
							
								<div>
									<img src="<%=bImgUrl%>" alt="Product Banner">
								</div>
								<div>
									<button onClick="removeImage('productBannerImageDivId','productBannerImageFileEntryId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
								</div>
							
							<%}
							}catch(Exception e){
								
							}
						}
						%>
						</div>
						<div class="Image_upload" id="productBannerImageId">
							<form action="${uploadProductBannerImage}" class="dropzone"
								id="productBannerImageDropzone">
								<input type="hidden" id="productBannerImageFileEntryId"
									name="productBannerImageFileEntry" class=""
									value="${productDetail.productBannerImageId}">
							</form>
						</div>
						
						<!-- end banner Image -->
					</div>
				</div>
			</div>
			
			
			<!-- registration form & display template configurable fields ** Harini -->
			
			<div class="heading-title Border-bottom" style=" margin-top: 20px;">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.customization.fields")%></h2>
					
				</div>
			<div class="customizationFields" id="customizationFields">
			
				<div class="templateSelectionWrap Input_HalfWidth Margin-20">
				<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.select.productDetail.display.template")%>
				<div class="select_style">
				
					<select id="templateListId" name="templateList">
									<c:forEach var="template" items="${productTemplateList}">
										<c:if test="${template  == productDetail.productTemplateName }">
											<option selected value="${template }">${template }</option>
										</c:if>
										<c:if test="${template  != productDetail.productTemplateName }">
											<option value="${template }">${template }</option>
										</c:if> 
									</c:forEach>
					</select>	
					</div>				
				</div>
				<div class="LanguageSelectionWrap Input_HalfWidth">
				<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.select.language.display.template")%>
				<div class="select_style">
				
					<select id="templateLanguageListId" name="templateLanguageList">
									<c:forEach var="localeName" items="${localeList}">
									<c:choose>
										<c:when test="${localeName.displayLanguage  == 'English' && empty productDetail.productTemplateLanguage}">
											<option selected value="${localeName }">${localeName.displayLanguage }</option>
											</c:when>
										<c:when test="${localeName  == productDetail.productTemplateLanguage }">
											<option selected value="${localeName }">${localeName.displayLanguage }</option>
										</c:when>
										<c:otherwise>
											<option value="${localeName }">${localeName.displayLanguage }</option>
										</c:otherwise> 
										</c:choose>
									</c:forEach>
					</select>					
				</div>
				</div>
				<div>
				<c:if test="${productDetail.bannerDetailsEnabled  == 'true' || empty(productDetail.bannerDetailsEnabled)}">
					<input type="checkbox" class="enableBannerDetails" id="enableBannerDetails" name="enableBannerDetails" checked><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.enable.banner.details")%>
				</c:if>
				<c:if test="${productDetail.bannerDetailsEnabled  == 'false' }">
					<input type="checkbox" class="enableBannerDetails" id="enableBannerDetails" name="enableBannerDetails"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.enable.banner.details")%>
				</c:if>
				</div>
				<div class="Input_HalfWidth ${productDetail.samePageRegistration}">
				<c:if test="${productDetail.registrationEnabled  == 'true' }">
					<input type="checkbox" class="enableRegistration" id="enableRegistration" name="enableRegistration" checked disabled onChange="javascript:showRegistrationFields('registerFormOptionsWrap')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.enable.form.registration")%>
				</c:if>
				<c:if test="${productDetail.registrationEnabled  != 'true' }">
					<input type="checkbox" class="enableRegistration" id="enableRegistration" name="enableRegistration" checked disabled onChange="javascript:showRegistrationFields('registerFormOptionsWrap')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.enable.form.registration")%>
				</c:if>
				</div>
				<div class="registerFormOptionsWrap" id="registerFormOptionsWrap">
				<c:if test="${productDetail.samePageRegistration  == 'true' || empty(productDetail.samePageRegistration)}">
					<input type="radio" class="registerFormOptions" name="registerFormOptions" value="samePageForm" checked onChange="javascript:showRegistrationFields('calloutFieldsWrap')"/><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.same.page.registration")%>
					<input type="radio" class="registerFormOptions" name="registerFormOptions" value="callOutForm" onChange="javascript:showRegistrationFields('calloutFieldsWrap')"/><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.callout.form.registration")%>
				<%-- <%=LabelUtil.getLabel(portletConfig,Locale.CHINA, themeDisplay,"label.product.callout.form.registration")%> --%>
				</c:if>
				<c:if test="${productDetail.samePageRegistration  == 'false' }">
					<input type="radio" class="registerFormOptions" name="registerFormOptions" value="samePageForm" onChange="javascript:showRegistrationFields('calloutFieldsWrap')"/><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.same.page.registration")%>
					<input type="radio" class="registerFormOptions" name="registerFormOptions" value="callOutForm" checked onChange="javascript:showRegistrationFields('calloutFieldsWrap')"/><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.callout.form.registration")%>
				</c:if>
				</div>
				<c:if test="${productDetail.samePageRegistration  == 'true' || empty(productDetail.samePageRegistration)}">
				<div class="calloutFieldsWrap hide" id="calloutFieldsWrap">
				</c:if>
				<c:if test="${productDetail.samePageRegistration  == 'false' }">
				<div class="calloutFieldsWrap" id="calloutFieldsWrap">
				</c:if>
				<c:set var="callOutFormImageIdValue"
							value="${productDetail.productFormImageId }" />
					<div class="callOutFormImage" id="callOutFormImageId">
						<%
						String fImgUrl = "";
						if(pageContext.getAttribute("callOutFormImageIdValue") != null) {
							try{
								Long fImgId = (Long) pageContext.getAttribute("callOutFormImageIdValue");
								
								if (fImgId != null && fImgId.compareTo(Long.parseLong("0")) != 0 ) {
									fImgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(fImgId),
											themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
											themeDisplay.getPathContext(), 1);
								}
							}catch(Exception e){
							}
						}
								if(fImgUrl != ""){
							%>
	
							
								<div>
									<img src="<%=fImgUrl%>" alt="Product Callout Form">
								</div>
								<div>
									<button onClick="removeImage('callOutFormImageId','productFormImageFileEntryId')"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%></button>
								</div>
							
							<%}
							
						%>
						</div>
						<div class="Image_upload" id="productFormImageId">
							<form action="${uploadProductFormImage}" class="dropzone"
								id="productFormImageDropzone">
								<input type="hidden" id="productFormImageFileEntryId"
									name="productFormImageFileEntry" class=""
									value="${productDetail.productFormImageId}">
							</form>
						</div>
						<div class="Input_HalfWidth Margin-10">
							<input type="text" name="productFormName" class="productFormName" id="productFormNameId" value="${productDetail.productFormName}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.productFormName")%>*" maxlength="30">
						</div>
						<div class="Input_HalfWidth ">
							<input type="text" name="callOutBtnName" class="callOutBtnName" id="callOutBtnNameId" value="${productDetail.productFormButtonName}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.callOutButtonNameName")%>*" maxlength="12" >
						</div>
						<div class="Input_HalfWidth">
							<input type="text" name="productFormUrl" class="productFormUrl" id="productFormUrlId" value="${productDetail.productFormUrl}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.productFormUrl")%>*" maxlength="150">
						</div>
						
						
				</div>
			</div>
			<div class="Right_bottom">
				<a href="<%=listProduct%>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
					onclick="saveProduct();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	showSubMenu("productSiderbar");
	var specializationListJSON = ${specializationListJSON};
	var selectedSpecializationListJSON = ${selectedSpecializationListJSON};
	
	var personaListJSON = ${personaListJSON};
	var selectedPersonaListJSON = ${selectedPersonaListJSON};
	
	autoCompleteList('.specializationList', specializationListJSON,
			selectedSpecializationListJSON, 'specializationToBeSavedId',
			'SelectedSpecialization','specializationListId','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.addSpecialization")%>*');
	
	if (document.getElementById('personaToBeSavedId')){
	autoCompleteList('.personaList', personaListJSON,
			selectedPersonaListJSON, 'personaToBeSavedId',
			'SelectedPersona','personaListId','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addPersona")%>*');
	}
	
	function createSelectedList(listName, listId, displayDiv, valueDiv) {
		var selListDiv = document.getElementById(displayDiv);
		var div1 = document.createElement('div');
		div1.setAttribute("class", "selWrap");
		div1.setAttribute("id", "selWrap_" + listId);
		var div2 = document.createElement('div');
		div2.setAttribute("class", "sel-list-name");
		var span1 = document.createElement('span');
		var text1 = document.createTextNode(listName);
		span1.appendChild(text1);
		div2.appendChild(span1);
		var div3 = document.createElement('div');
		div3.setAttribute("class", "sel-list-remove");
		var span2 = document.createElement('span');
		var text2 = document.createTextNode("X");
		span2.setAttribute("class", "removeSelList");
		span2.setAttribute("onClick", "removeElement(" + listId + ","
				+ valueDiv + ")");
		span2.appendChild(text2);
		div3.appendChild(span2);
		div1.appendChild(div2);
		div1.appendChild(div3);
		if (selListDiv){
			selListDiv.appendChild(div1);
		}
	}

	function removeElement(listId, valueDivElem) {
		var elem = document.getElementById("selWrap_" + listId);
		var elemId = valueDivElem;//document.getElementById(valueDivElem);
		elemIdValues = elemId.value;
		if (elemIdValues.indexOf(listId) != -1) {
			var val = "," + listId;
			elemIdValues = elemIdValues.replace(new RegExp(val), '');
			elemId.value = elemIdValues;
		}
		elem.remove();
		return true;
	}

	function autoCompleteList(className, sourceJSON, extsourceJSON,
			valueToBeSaved, displayDiv,inputNodeId,placeHolder) {
		var items = extsourceJSON;
		var itemIds = "0";
		var itemNames = "";
		if (extsourceJSON != "0") {
			for (key in items) {
				var ss = items[key];
				itemIds += "," + ss.key;
				itemNames += "," + ss.code;
				//tag,className,id,name,type,placeholder,maxlength,event,eventValue,url,isMandatory,isNumberOnly,isTextOnly
				createSelectedList(ss.code, ss.key, displayDiv, valueToBeSaved);
			}

			//document.getElementById("selectedCompetency").innerHTML = itemNames;
			document.getElementById(valueToBeSaved).value = itemIds;
		}
		AUI().use(
				'aui-node',
				'aui-base',
				'aui-io-request',
				'autocomplete-list',
				'aui-io-request',
				'autocomplete-filters',
				'autocomplete-highlighters',
				function(A) {
					if (sourceJSON) {
						var autoComplete = new A.AutoCompleteList({
							allowBrowserAutocomplete : 'false',
							inputNode : className,
							activateFirstItem : 'true',
							source : sourceJSON,
							resultTextLocator : 'code',
							resultHighlighter : 'phraseMatch',
							resultFilters : 'phraseMatch',
							minQueryLength : 1,
							maxResults : 10,
							queryDelimiter : ',',
							on : {
								select : function(event) {
									var result = event.result.raw;
									var elementToSaveValues = document
											.getElementById(valueToBeSaved);
									createSelectedList(result.code, result.key,
											displayDiv, valueToBeSaved);
									elementToSaveValues.value += ","
											+ result.key;
									document.getElementById(inputNodeId).classList.remove("Error-success");
				    				document.getElementById(inputNodeId).classList.remove("Error");
				    				document.getElementById(inputNodeId).placeholder=placeHolder;
								}
							},
							 after: {
	                                select: function (event) {
	                                    clearAutoCompleteData(inputNodeId);
	                                }
	                            },
							render : 'true'
						}).render();
					}
				});
	}

	var minImageWidth = 100, minImageHeight = 100;

	Dropzone.options.productImageDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		maxFilesize : 2, // MB
		dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.imageslogo")%>',
		acceptedFiles : "image/*",

		init : function() {

			// Register for the thumbnail callback.
			// When the thumbnail is created the image dimensions are set.
			this.on("thumbnail",
					function(file) {
						// Do the dimension checks you want to do
						if (file.width < minImageWidth
								|| file.height < minImageHeight) {
							file.rejectDimensions();
						} else {
							if(file.acceptDimensions){
								file.acceptDimensions();
							}
						}
					});

			this.on("addedfile", function(file) {
				// Create the remove button
				var removeButton = Dropzone
						.createElement("<button>" + '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

				// Capture the Dropzone instance as closure.
				var _this = this;

				// Listen to the click event
				removeButton.addEventListener("click", function(e) {
					// Make sure the button click doesn't submit the form:
					e.preventDefault();
					e.stopPropagation();

					// Remove the file preview.
					_this.removeFile(file);
					// If you want to the delete the file on the server as well,
					// you can do the AJAX request here.
				});

				// Add the button to the file preview element.
				file.previewElement.appendChild(removeButton);
			});
			this
					.on(
							"success",
							function(file, responseText) {
								var items = JSON.parse(responseText);
								var tempFileEntryId = items["tempFileEntryId"];
								document
										.getElementById("productImageFileEntryId").value = tempFileEntryId;
								if(document.getElementById("productImageId")){
									document.getElementById("productImageId").innerHTML = '';
								}	
							});

		},

		// Instead of directly accepting / rejecting the file, setup two
		// functions on the file that can be called later to accept / reject
		// the file.
		accept : function(file, done) {
			file.acceptDimensions = done;
			file.rejectDimensions = function() {
				done("Invalid dimension.");
			};
			// Of course you could also just put the `done` function in the file
			// and call it either with or without error in the `thumbnail` event
			// callback, but I think that this is cleaner.
		},
		error : function(file,message){
			displayErrorMsgUnderFilePreview(file, message);
		}
	};
	
	
	//banner image for product
	Dropzone.options.productBannerImageDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		maxFilesize : 2, // MB
		dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.imageslogo.banner")%>',
		acceptedFiles : "image/*",

		init : function() {

			// Register for the thumbnail callback.
			// When the thumbnail is created the image dimensions are set.
			this.on("thumbnail",
					function(file) {
						// Do the dimension checks you want to do
						if (file.width < minImageWidth
								|| file.height < minImageHeight) {
							file.rejectDimensions();
						} else {
							if(file.acceptDimensions){
								file.acceptDimensions();
							}
						}
					});

			this.on("addedfile", function(file) {
				// Create the remove button
				var removeButton = Dropzone
						.createElement("<button>" + '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

				// Capture the Dropzone instance as closure.
				var _this = this;

				// Listen to the click event
				removeButton.addEventListener("click", function(e) {
					// Make sure the button click doesn't submit the form:
					e.preventDefault();
					e.stopPropagation();

					// Remove the file preview.
					_this.removeFile(file);
					// If you want to the delete the file on the server as well,
					// you can do the AJAX request here.
				});

				// Add the button to the file preview element.
				file.previewElement.appendChild(removeButton);
			});
			this
					.on(
							"success",
							function(file, responseText) {
								var items = JSON.parse(responseText);
								var tempFileEntryId = items["tempFileEntryId"];
								document
										.getElementById("productBannerImageFileEntryId").value = tempFileEntryId;
								if(document.getElementById("productBannerImageDivId")){
									document.getElementById("productBannerImageDivId").innerHTML = '';
								}	
							});

		},

		// Instead of directly accepting / rejecting the file, setup two
		// functions on the file that can be called later to accept / reject
		// the file.
		accept : function(file, done) {
			file.acceptDimensions = done;
			file.rejectDimensions = function() {
				done("Invalid dimension.");
			};
			// Of course you could also just put the `done` function in the file
			// and call it either with or without error in the `thumbnail` event
			// callback, but I think that this is cleaner.
		},
		error : function(file,message){
			displayErrorMsgUnderFilePreview(file, message);
		}
	};
	
	
	//image for registration form
	Dropzone.options.productFormImageDropzone = {
			thumbnailWidth : 300,
			thumbnailHeight : 300,
			maxFilesize : 2, // MB
			dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.imageslogo")%>',
			acceptedFiles : "image/*",

			init : function() {

				// Register for the thumbnail callback.
				// When the thumbnail is created the image dimensions are set.
				this.on("thumbnail",
						function(file) {
							// Do the dimension checks you want to do
							if (file.width < minImageWidth
									|| file.height < minImageHeight) {
								file.rejectDimensions();
							} else {
								if(file.acceptDimensions){
									file.acceptDimensions();
								}
							}
						});

				this.on("addedfile", function(file) {
					// Create the remove button
					var removeButton = Dropzone
							.createElement("<button>" + '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

					// Capture the Dropzone instance as closure.
					var _this = this;

					// Listen to the click event
					removeButton.addEventListener("click", function(e) {
						// Make sure the button click doesn't submit the form:
						e.preventDefault();
						e.stopPropagation();

						// Remove the file preview.
						_this.removeFile(file);
						// If you want to the delete the file on the server as well,
						// you can do the AJAX request here.
					});

					// Add the button to the file preview element.
					file.previewElement.appendChild(removeButton);
				});
				this
						.on(
								"success",
								function(file, responseText) {
									var items = JSON.parse(responseText);
									var tempFileEntryId = items["tempFileEntryId"];
									document
											.getElementById("productFormImageFileEntryId").value = tempFileEntryId;
									if(document.getElementById("callOutFormImageId")){
										document.getElementById("callOutFormImageId").innerHTML = '';
									}	
								});

			},

			// Instead of directly accepting / rejecting the file, setup two
			// functions on the file that can be called later to accept / reject
			// the file.
			accept : function(file, done) {
				file.acceptDimensions = done;
				file.rejectDimensions = function() {
					done("Invalid dimension.");
				};
				// Of course you could also just put the `done` function in the file
				// and call it either with or without error in the `thumbnail` event
				// callback, but I think that this is cleaner.
			},
			error : function(file,message){
				displayErrorMsgUnderFilePreview(file, message);
			}
		};
	

	Dropzone.options.productVideosDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.videos")%>',
		init : function() {

			this.on("addedfile", function(file) {
				// Create the remove button
				var removeButton = Dropzone
						.createElement("<button>" + '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

				// Capture the Dropzone instance as closure.
				var _this = this;

				// Listen to the click event
				removeButton.addEventListener("click", function(e) {
					// Make sure the button click doesn't submit the form:
					e.preventDefault();
					e.stopPropagation();

					// Remove the file preview.
					_this.removeFile(file);
					// If you want to the delete the file on the server as well,
					// you can do the AJAX request here.
				});

				// Add the button to the file preview element.
				file.previewElement.appendChild(removeButton);
			});
			this
					.on(
							"success",
							function(file, responseText) {
								var items = JSON.parse(responseText);
								var videoTempFolderId = items["tempFolderId"];
								document
										.getElementById("productVideosFolderId").value = videoTempFolderId;
								if(document.getElementById("productVideoId")){
									document.getElementById("productVideoId").innerHTML = '';
								}	
							});

		}
	};

	Dropzone.options.productBrochuresDropzone = {
		thumbnailWidth : 300,
		thumbnailHeight : 300,
		dictDefaultMessage : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.brocures")%>',
		init : function() {

			this.on("addedfile", function(file) {
				// Create the remove button
				var removeButton = Dropzone
						.createElement("<button>" + '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>' + "</button>");

				// Capture the Dropzone instance as closure.
				var _this = this;

				// Listen to the click event
				removeButton.addEventListener("click", function(e) {
					// Make sure the button click doesn't submit the form:
					e.preventDefault();
					e.stopPropagation();

					// Remove the file preview.
					_this.removeFile(file);
					// If you want to the delete the file on the server as well,
					// you can do the AJAX request here.
				});

				// Add the button to the file preview element.
				file.previewElement.appendChild(removeButton);
			});
			this
					.on(
							"success",
							function(file, responseText) {
								var items = JSON.parse(responseText);
								var brochuresTempFolderId = items["tempFolderId"];
								document
										.getElementById("productBrochuresFolderId").value = brochuresTempFolderId;
								if(document.getElementById("productBrochureId")){
									document.getElementById("productBrochureId").innerHTML = '';
								}	
							});

		}
	};

	function saveProduct() {

		var isValidate = validateForm("productInner",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		var isValidate1 = validateForm("customizationFields",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		var nameField = document.getElementById("productFormNameId");
		var attribute_class = nameField.getAttribute("class");
       	if(attribute_class.indexOf("Requiredfield") == -1){
       		isValidate1 = true;
        }
		
		if(isValidate && isValidate1){
			isValidate = true;
		}else{
			isValidate = false;
		}	
		if (isValidate) {

			AUI().use('aui-node','aui-io-request',function(A){
				var items = null;
				var createProduct = '${createProduct}';
				var countryListNode = document.getElementById("countryListId");
				var courseListNode = document.getElementById("courseListId");
				var templateListNode = document.getElementById("templateListId");
				var langListNode = document.getElementById("templateLanguageListId");
				var enableChkBox = document.getElementById("enableRegistration");
				var enableBannerDetailsChkBox = document.getElementById("enableBannerDetails");
				var enableChkBoxVal = "true";
			    if (enableChkBox.checked == false)
			    {
			    	enableChkBoxVal = "false";
			    }
			    var enableBannerDetailsChkBoxVal = "true";
			    if (enableBannerDetailsChkBox.checked == false)
			    {
			    	enableBannerDetailsChkBoxVal = "false";
			    }
			    var isSamePage = "true";
			    var regRadio = document.getElementsByName("registerFormOptions");
			   
			    for(var i = 0; i < regRadio.length; i++){
			        if(regRadio[i].checked){
			        	if("samePageForm" == regRadio[i].value){
			        		isSamePage = "true";
			        	}else{
			        		isSamePage = "false";
			        	}
			        }
			    }

				try {
					startPreLoader("mainContainer");
					A.io
							.request(
									createProduct,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										data : {
											productName : document
													.getElementById("productNameId").value,
											specializationArray : getAutoCompleteValues('specializationToBeSavedId'),
											personaArray : getAutoCompleteValues('personaToBeSavedId'),
											country : countryListNode.options[countryListNode.selectedIndex].value,
											course : courseListNode.options[courseListNode.selectedIndex].value,
											tempFileEntryId : document
													.getElementById("productImageFileEntryId").value,
											productVideosFolderId : document
													.getElementById("productVideosFolderId").value,
											productBrochuresFolderId : document
													.getElementById("productBrochuresFolderId").value,
											spProductId : document
													.getElementById("spProductIdValue").value,
											creditValue : document.getElementById("creditValueId").value,
											PEProcessId : document.getElementById("PEProcessId").value,
											templateName : templateListNode.options[templateListNode.selectedIndex].value,
											templateLanguage : langListNode.options[langListNode.selectedIndex].value,
											isRegistrationEnabled : enableChkBoxVal,
											isBannerDetailsEnabled : enableBannerDetailsChkBoxVal,
											isSamePageRegistration : isSamePage,
											tempFormImageFileEntryId : document.getElementById("productFormImageFileEntryId").value,
											tempBannerImageFileEntryId : document.getElementById("productBannerImageFileEntryId").value,
											productFormName : document.getElementById("productFormNameId").value,
											formButtonName : document.getElementById("callOutBtnNameId").value,
											formurl : document.getElementById("productFormUrlId").value
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
													}else if(data.spProductId > 0){
														// here data.spProductId = value returned from server
														//  spProductId is value submitted to server
														var productIdNdoe = A.one("#spProductIdValue");
														var spProductId = productIdNdoe.val();
														productIdNdoe.val(data.spProductId);
														if(spProductId > 0){ //existing
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.updated.message")%>');
														}else{
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.created.message")%>');
															
															//A.one("#header").setContent("Update Product");
															
														}
													}else{
														// This case is very very rare
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
													}
												} else {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.save.error")%>');
												}
												window.scrollTo(0,0);
											},
											failure : function() {
												displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.save.error")%>');
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
	
	function showRegistrationFields(id){
		var hideField = document.getElementById(id);
		var nameField = document.getElementById("productFormNameId");
		var btnField = document.getElementById("callOutBtnNameId");
		var urlField = document.getElementById("productFormUrlId");
		if(hideField){
			var attribute_class = hideField.getAttribute("class");
	        if(attribute_class.indexOf("hide") > -1){
	        	hideField.classList.remove("hide");
	        	nameField.classList.add("Requiredfield");
	        	btnField.classList.add("Requiredfield");
	        	urlField.classList.add("Requiredfield");
	        }else{
	        	hideField.classList.add("hide");
	        	nameField.classList.remove("Requiredfield");
	        	btnField.classList.remove("Requiredfield");
	        	urlField.classList.remove("Requiredfield");
	        }
		}
	}
</script>
