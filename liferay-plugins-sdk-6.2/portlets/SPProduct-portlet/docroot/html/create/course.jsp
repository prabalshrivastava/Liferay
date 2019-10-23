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
	String courseDescriptionLabel = "Course Description";
	courseDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.course.courseDescription");
%>


<portlet:resourceURL var="createCourse">
	<portlet:param name="action" value="addCourse"></portlet:param>
</portlet:resourceURL>


<%@ include file="/html/create/msg.jsp"%>

<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">
		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>


		<div class="Right_content_section" >


			<div class="Border" id="mainContainer">
				<div class="heading-title Border-bottom">
					<h2><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.course.details")%></h2>
					<div class="Backtolist-btn"><a href="<%=listCourse%>"><span><</span><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a></div>

				</div>

				<div class="form-section ">
					<div class="Input_Fullwidth ">
						<div class="course-create" id="CourseNew_click">
							<a href="#"> <img
								src="<%=request.getContextPath()%>/images/Product_create/create-new.png" alt="Create">
								<c:if test="${empty courseDetail.spCourseId}">
									<h2 id="header"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.createCourse")%></h2>
								</c:if>
								<c:if test="${not empty courseDetail.spCourseId}">
									<h2 id="header"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.updateCourse")%></h2>
								</c:if>
							</a>
						</div>
					</div>
				</div>
				<div class="active-content-Sec  ProdBorder-active">
					<span></span>
				</div>
				<div id="Coursenew_create">
					<div class="form-section  ">
					<input type="hidden" id="spCourseId" name="spCourseId" value="${courseDetail.spCourseId}">
						<div class="Input_small Margin-20">
							<input type="text" id="courseCodeId" name="courseCode" value="${courseDetail.courseCode}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseId")%> *" class="Requiredfield" onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseId")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>
						<div class="Input_Medium">
							<input type="text" id="courseNameId" name="courseName" value="${courseDetail.courseName}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseName")%> *" class="Requiredfield" onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseName")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');"  maxlength="500">
						</div>
						<div class="Input_Fullwidth margin-20-topbottom">
							<label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.displayCourseName")%></label> 
							<c:choose>
								<c:when test="${courseDetail.displayCourseName}">
									<input class="css-labelradio" type="radio" name="displayCourseName"
									value="yes" checked>  <label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.yes")%></label>
									<input class="css-labelradio" type="radio" name="displayCourseName"
									value="no">  <label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.no")%></label>
								</c:when>
								<c:otherwise>
									<input class="css-labelradio" type="radio" name="displayCourseName"
									value="yes">  <label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.yes")%></label>
									<input class="css-labelradio" type="radio" name="displayCourseName"
									value="no" checked>  <label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.no")%></label>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="Input_Fullwidth margin-20-topbottom">
							<liferay-ui:input-editor name='<%="course_description"%>'
								editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
								initMethod='<%="initEditor_course_description"%>'
								cssClass="ckeditor" />
								<c:set var="courseDesc" value="${courseDetail.courseDesc}" />
								<% String courseDesc = (String) pageContext.getAttribute("courseDesc"); %>
							<aui:script>
							function <portlet:namespace />initEditor_course_description() {
								<c:if test="${empty courseDetail}">
									return "<%=UnicodeFormatter.toString(courseDescriptionLabel)%>";
								</c:if>
								<c:if test="${!empty courseDetail}">
								return "<%=UnicodeFormatter.toString(courseDesc)%>";
								</c:if> 
							}
						</aui:script>
						</div>
						<div class="Input_HalfWidth Margin-20">
							<input type="text" id="courseDurationId" name="courseDuration"
								value="${courseDetail.courseDurationFullTime}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDurationFullTime")%> *" class="Requiredfield" onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDurationFullTime")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>
						<div class="Input_HalfWidth">
							<input type="text" id="learningDurationId"
								name="learningDuration" value="${courseDetail.learningDurationFullTime}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.learningDurationFullTime")%> *" class="Requiredfield" onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.learningDurationFullTime")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>
						<div class="Input_HalfWidth Margin-20">
							<input type="text" id="courseDurationPartId" name="courseDurationPart"
								value="${courseDetail.courseDurationPartTime}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDurationPartTime")%> *" class="Requiredfield" onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDurationPartTime")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>
						<div class="Input_HalfWidth">
							<input type="text" id="learningDurationPartId"
								name="learningDurationPart" value="${courseDetail.learningDurationPartTime}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.learningDurationPartTime")%> *" class="Requiredfield" onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.learningDurationPartTime")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>
						<div class="Input_HalfWidth Margin-20">
							<input type="text" id="complexityLevelId" name="complexityLevel"
								value="${courseDetail.complexityLevel}"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseComplexityLevel")%> *" class="Requiredfield"
								onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseComplexityLevel")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
						</div>
						<div class="Input_HalfWidth">
							<input type="text" id="testLink" name="testLink"
								value="${courseDetail.testLink}" placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.testLink")%>"
								class="Urlfield">
						</div>
						<div class="Input_HalfWidth Margin-20">
							<div class="select_style" id="Producttype1_select">
								<select id="courseTypeListId" name="courseTypeList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseType")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseType")%> *</option>
									<c:forEach var="courseType" items="${courseTypeList}">
										<c:if
											test="${courseDetail.courseType == courseType.categoryId}">
											<option value="${courseType.categoryId}" selected>${courseType.name}</option>
										</c:if>
										<c:if
											test="${courseDetail.courseType != courseType.categoryId}">
											<option value="${courseType.categoryId}">${courseType.name}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="Input_HalfWidth">
							<div class="select_style" id="Producttype1_select">
								<select id="countryListId" name="countryList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseOriginCountry")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseOriginCountry")%>
										*</option>
									<c:forEach var="country" items="${countryList}">
										<c:if test="${courseDetail.countryId == country.categoryId}">
											<option value="${country.categoryId}" selected>${country.name}</option>
										</c:if>
										<c:if test="${courseDetail.countryId != country.categoryId}">
											<option value="${country.categoryId}">${country.name}</option>
										</c:if>
									</c:forEach>

								</select>
							</div>
						</div>
						
						<div class="Input_HalfWidth Margin-20">
							<div class="select_style" id="Producttype1_select">
								<select id="awardingBodyId" name="awardingBody"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.awardingBody")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.awardingBody")%>
										*</option>
									<c:forEach var="award" items="${awardList}">
										<c:if test="${courseDetail.awardingBodyId == award.categoryId}">
											<option value="${award.categoryId}" selected>${award.name}</option>
										</c:if>
										<c:if test="${courseDetail.awardingBodyId != award.categoryId}">
											<option value="${award.categoryId}">${award.name}</option>
										</c:if>
									</c:forEach>

								</select>
							</div>
						</div>
						
						<div class="Input_HalfWidth">
							<div class="select_style" id="Producttype1_select">
								<select id="courseDeveloperListId" name="courseDeveloperList"
									class="Requiredfield"
									onblur="requiredFieldValidation(this, '<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDeveloper")%> *', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>');">
									<option selected disabled value="0"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDeveloper")%> *</option>
									<c:forEach var="courseDeveloper" items="${courseDeveloperList}">
										<c:if test="${courseDetail.courseDeveloperId == courseDeveloper.categoryId}">
											<option value="${courseDeveloper.categoryId}" selected>${courseDeveloper.name}</option>
										</c:if>
										<c:if test="${courseDetail.courseDeveloperId != courseDeveloper.categoryId}">
											<option value="${courseDeveloper.categoryId}">${courseDeveloper.name}</option>
										</c:if>
									</c:forEach>

								</select>
							</div>
						</div>
						
						<div class="Input_HalfWidth margin-20-topbottom">
							<label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.frameworkApprovalStatus")%></label>
							<c:choose>
								<c:when test="${courseDetail.frameworkApprovalStatus}">
									<input class="css-labelradio" type="radio"
										name="frameworkApprovalStatus" value="yes" checked>
									<label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.yes")%></label>
									<input class="css-labelradio" type="radio"
										name="frameworkApprovalStatus" value="no">
									<label> <%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.no")%></label>
								</c:when>
								<c:otherwise>
									<input class="css-labelradio" type="radio"
										name="frameworkApprovalStatus" value="yes">
									<label><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.yes")%></label>
									<input class="css-labelradio" type="radio"
										name="frameworkApprovalStatus" value="no" checked>
									<label> <%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.no")%></label>
								</c:otherwise>
							</c:choose>

						</div>
						
						<div class="Input_Fullwidth">
						<div id="selectedModules" class="selectedModules selectedList"></div>
						</div>
						<div class="Input_Fullwidth">
							<input name="moduleToBeSaved" id="moduleToBeSavedId"
								type="hidden" value="0" class="Requiredfield autoComplete"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addModule")%>*"> 
								<input name="moduleList"
								class="moduleList selectedListInput" id="moduleListId"
								placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addModule")%> *">
							<div class="search_icon">
								<img src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
							</div>
						</div>
						<div class="Input_Fullwidth margin-20-topbottom">
							<div class="Admin-textarea">
								<textarea name="certificateTitle" id="certificateTitleId"
									placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.certificateTitle")%> <%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.certificateMsg")%>">${courseDetail.certificateTitle}</textarea>
							</div>
						</div>
						<div class="Input_Fullwidth">
							<div id="selectedCertificates" class="selectedCertificates selectedList"></div>
						</div>
						<div class="Input_Fullwidth">
									<input name="certificateList"
										class="selectedListInput certificateList"
										id="certificateListId" placeholder="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addCertificate")%>">
									<div class="search_icon">
										<img
											src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
									</div>
									<input name="certValueToBeSaved" id="certValueToBeSavedId" class=""
										type="hidden" value="0">
						</div>
						
						<div class="Input_Fullwidth">
						
							<%@ include file="/html/create/course_outcome.jsp"%>
						</div>
						
					</div>
					
				
						
				</div>
			</div>
			<div class="Right_bottom">
				<a href="${listCourse}"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> 
				<a href="javascript:;" onclick="saveCourse();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
			<c:if test="${not empty courseDetail.spCourseId}">
			<div class="Next-icon">
					<a href="javascript:courseTabslink('<%=addPersona%>','editPersona','persona');"></a>
				</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	showSubMenu("courseSiderbar");
	var moduleListJSON = ${moduleListJSON};
	var moduleCourseListJSON = ${moduleCourseListJSON};
	autoCompleteList('.moduleList',moduleListJSON,moduleCourseListJSON,'moduleToBeSavedId','selectedModules','moduleListId','<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addModule")%> *');

	var certificatesListJSON = ${certificatesList};
	var courseCertificateListJSON = ${courseCertificateListJSON};
	autoCompleteList('.certificateList',certificatesListJSON,courseCertificateListJSON,'certValueToBeSavedId','selectedCertificates','certificateListId','<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addCertificate")%>');

	
	
	function createSelectedList(listName,listId,displayDiv,valueDiv){
		var selListDiv = document.getElementById(displayDiv);
		var div1 = document.createElement('div');
		div1.setAttribute("class","selWrap");
		div1.setAttribute("id","selWrap_"+listId);
		var div2 = document.createElement('div');
		div2.setAttribute("class","sel-list-name");
		var span1 = document.createElement('span');
		var text1 = document.createTextNode(listName);
		span1.appendChild(text1);
		div2.appendChild(span1);
		var div3 = document.createElement('div');
		div3.setAttribute("class","sel-list-remove");
		var span2 = document.createElement('span');
		var text2 = document.createTextNode("X");
		span2.setAttribute("class","removeSelList");
		span2.setAttribute("onClick","removeElement(" + listId + "," + valueDiv + ")");
		span2.appendChild(text2);
		div3.appendChild(span2);
		div1.appendChild(div2);
		div1.appendChild(div3);
		selListDiv.appendChild(div1);
	}
	
	function removeElement(listId,valueDivElem) {
		var elem = document.getElementById("selWrap_"+listId);
		var elemId = valueDivElem;//document.getElementById(valueDivElem);
		elemIdValues = elemId.value;
		if(elemIdValues.indexOf(listId) != -1){
			var val = "," + listId;
			elemIdValues = elemIdValues.replace(new RegExp(val), '');
			elemId.value = elemIdValues;
		}
		elem.remove();
		return true;
	}
	
	function autoCompleteList(className,sourceJSON,extsourceJSON,valueToBeSaved,displayDiv,ListId,placeHolder) {
		var items = extsourceJSON;
		var itemIds = "0";
		var itemNames = "";
		if(extsourceJSON != "0"){
			for(key in items){
				var ss = items[key];
				itemIds = itemIds + "," + ss.key;
				itemNames = itemNames + "," + ss.code;
				//tag,className,id,name,type,placeholder,maxlength,event,eventValue,url,isMandatory,isNumberOnly,isTextOnly
				createSelectedList(ss.code,ss.key,displayDiv,valueToBeSaved);
			}
			
			//document.getElementById("selectedCompetency").innerHTML = itemNames;
			document.getElementById(valueToBeSaved).value = itemIds;
		}
		AUI().use('aui-node', 'aui-base', 'aui-io-request','autocomplete-list','aui-io-request','autocomplete-filters','autocomplete-highlighters', function(A) {
			if(sourceJSON) {
				var autoComplete = new A.AutoCompleteList(
			      {
			    	allowBrowserAutocomplete: 'false',
			        inputNode: className,
			        activateFirstItem: 'true',
			        source: sourceJSON,
			        resultTextLocator: 'code',
			        resultHighlighter: 'startsWith',
			        resultFilters: 'startsWith',
			        minQueryLength: 0, 
			        maxResults: 10, 
			        queryDelimiter : ',',
			        focused:true,
			        on: {
			    		select: function(event) {
			    			var result = event.result.raw;
			    			var elementToSaveValues = document.getElementById(valueToBeSaved);
			    			var elemValues = elementToSaveValues.value;
			    			var reslt = "," + result.key + ","
			    			if(elemValues.indexOf(reslt) == -1){
			    				elementToSaveValues.value += "," + result.key;
			    				document.getElementById(ListId).classList.remove("Error-success");
			    				document.getElementById(ListId).classList.remove("Error");
			    				document.getElementById(ListId).placeholder=placeHolder;
			    				createSelectedList(result.code,result.key,displayDiv,valueToBeSaved);
			    			}	
			    		}
			    	},
			    	 after: {
				    		select: function(event) {
				    			clearAutoCompleteData(ListId);
				    		}
			    	 },
			    	render: 'true'
			      }).render();
			}
		});
	}
	
	function saveCourse() {
		hideMessage(); // msg.jsp
		var isValidate = validateForm("Coursenew_create",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
		if (isValidate)
		{
			AUI().use('aui-node','aui-io-request',function(A){
				var items = null;
				var createCourse = '${createCourse}';
				var courseTypeListNode = document.getElementById("courseTypeListId");
				var countryListNode = document.getElementById("countryListId");
				var courseDeveloperListNode = document.getElementById("courseDeveloperListId");
				var awardingBodyNode = document.getElementById("awardingBodyId");
				var courseDesc = window.<portlet:namespace />course_description
						.getHTML();
				var spCourseId = document.getElementById("spCourseId").value;
				var outcomeInstancesCount = parseInt(document.getElementById("globalCountId").value); 
				if(document.getElementById("Ip_outcome_description_0")){
					document.getElementById("Ip_outcome_description_0").value = window.<portlet:namespace />outcome_description_0.getHTML();
				}
				for(var i=0;i<outcomeInstancesCount;i++){
					
					setCKEditorValues('Ip_outcome_description_','outcome_description_',i);
				}
				startPreLoader("mainContainer");
				A.io
							.request(
									createCourse,
									{
										cache : false,
										sync : true,
										timeout : 1000,
										dataType : 'json',
										method : 'post',
										form: { id: outcomeFmId }, 
										data : {
											courseCode : document
													.getElementById("courseCodeId").value,
											courseName : document
													.getElementById("courseNameId").value,
											displayCourseName : document
													.querySelector('input[name=displayCourseName]:checked').value,
											courseDurationFullTime : document
													.getElementById("courseDurationId").value,
											learningDurationFullTime : document
													.getElementById("learningDurationId").value,
											courseDurationPartTime : document
													.getElementById("courseDurationPartId").value,
											learningDurationPartTime : document
													.getElementById("learningDurationPartId").value,		
											complexityLevel : document
													.getElementById("complexityLevelId").value,
											frameworkApprovalStatus : document
													.querySelector('input[name=frameworkApprovalStatus]:checked').value,
											testLink: document.getElementById("testLink").value,		
											courseType : courseTypeListNode.options[courseTypeListNode.selectedIndex].value,
											country : countryListNode.options[countryListNode.selectedIndex].value,
											award : awardingBodyNode.options[awardingBodyNode.selectedIndex].value,
											courseDeveloper : courseDeveloperListNode.options[courseDeveloperListNode.selectedIndex].value,
											moduleArray : getAutoCompleteValues('moduleToBeSavedId'),
											certValueToBeSaved: getAutoCompleteValues('certValueToBeSavedId'),
											courseDescription : courseDesc,
											spCourseId : spCourseId,
											outcomeDesc:document.getElementById("outcomeDescId").value,
											courseOutcomeTitle:document.getElementById("courseOutcomeTitleId").value,
											outcomeInstancesCount:outcomeInstancesCount,
											certificateTitle : document.getElementById("certificateTitleId").value
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
													}else if(data.spCourseId > 0){
														// here data.spCourseId = value returned from server
														//  spCourseId is value submitted to server
														A.one("#spCourseId").val(data.spCourseId);
														if(spCourseId > 0){ //existing
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.course.updated")%>');
														}else{
															displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.updated")%>');
															courseTabslink('<%=addPersona%>','editPersona','persona');
															//A.one("#header").setContent("Update Course");
														}
													}else{
														// This case is very very rare
														displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
													}
												} else {
													displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.save.error")%>');
												}
												window.scrollTo(0,0);
											},
											failure : function() {
												displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.save.error")%>');
												window.scrollTo(0,0);
											}
										}
		
									});
			});
		}
	}
</script>
