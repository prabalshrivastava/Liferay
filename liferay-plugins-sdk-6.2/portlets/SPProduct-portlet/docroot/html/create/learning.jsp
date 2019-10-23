<%@page import="com.sambaash.platform.product.util.SPProductConstants"%>
<%@page import="com.sambaash.platform.srv.model.CourseLearning"%>
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
	String courseDescriptionLabel = "Course Description";
	String addOverview = "Add an Overview text (Eg: 'Guided lmmersive mode allows you to Personalize your Schedule...')";
	String col1Info = "Add 1st Column information (Eg: 'Full + PartTime Option')";
	String col2Info = "Add 2nd Column information (Eg: 'PartTime Only Option')";
	String concludingText = "Add a Concluding text (Eg: 'Tutoring support available on-campus...')";
	courseDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.course.courseDescription");
	addOverview = LabelUtil.getLabel(portletConfig, themeDisplay,"label.product.create.howYouLearn.addOverview");
	col1Info = LabelUtil.getLabel(portletConfig, themeDisplay,"label.product.create.howYouLearn.column1Information");
	col2Info = LabelUtil.getLabel(portletConfig, themeDisplay,"label.product.create.howYouLearn.column2Information");
	concludingText = LabelUtil.getLabel(portletConfig, themeDisplay,"label.product.create.howYouLearn.concludingText");
	String spCourseId = request.getParameter("spCourseId");
%>


<portlet:resourceURL var="ajaxUrl">
	<portlet:param name="action" value="addLearning"></portlet:param>
</portlet:resourceURL>

<div id="msgContainer" class="hide" tabindex="100"></div>

<div class="product_create screen-max-width">
	<div class="product_create_wrapper ">
		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>

		<div class="Right_content_section" id="formContainer">
			<%
				if (Validator.isNotNull(spCourseId)) {
			%>
			<div class="Border">
				<div class="heading-title Border-bottom">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.howYouLearn")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listCourse%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>
				<form action="#" method="POST" id="learningForm" name="learningForm">
					<div class="form-section ">
						<div class="Input_Fullwidth margin-20-topbottom">
							<liferay-ui:input-editor name="introEditor"
								editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="<%= SPProductConstants.CK_EDITOR_TOOLBAR %>"
								initMethod='<%="initEditor_learning_intro"%>'
								cssClass="ckeditor"/>
								<aui:script>
									function <portlet:namespace />initEditor_learning_intro() {
										var temp = "${learning.intro}";
										if(temp.trim()==''){
											temp = "<%= addOverview%>";
										}
										return temp;
									}
								</aui:script>
						</div>
					<div id="durationTypeContainerOuter">
										<div class="Input_HalfWidth">
											<input type="text" name="durationTitle" value="${learning.durationTitle}"
																id="durationTitle"	placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addTableTitle1")%>" />
										</div>
                                        <div class="Input_HalfWidth text-right add_td_button">
         								  	<div class="Add_button">
             									<a href="javascript:;" class="Button-green button-pos-right" id="addDuration"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addDurationType")%> </a>
             								</div>
             							</div>
                           </div>	
		  			<div id="durationTypeInner" >
                                    <!--  "_1" indicates it's first row. It's mandatory -->
                                        <div class="durationTypeWrapper" id="durationTypeWrapper_1">
                                        	<input type="hidden" id="durationTypeId_1" />
                                        	<input type="hidden" id="counter_1" value="1" data-indicator="true"/>
                                            <div class="form-inner Border Form-pop-padding Form-bg  FormBorder-active">
                                               <div class="close_button">
										<span id="close"><img src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
												alt="Close"></span>
									</div>
                                                <div class="form-summary-inner">
                                                    <div class="Input_HalfWidth margin-right-22">
											<input type="text" name="title1_1"
												id="title1_1"	placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addColumnTitle1")%>" />
										</div>
                                                    <div class="Input_HalfWidth">
											<input type="text" name="duration1_1" class="Requiredfield"
												id="duration1_1"	placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addValue")%> *" />
										</div>
                                                    <div class="Input_HalfWidth margin-right-22">
											<input type="text" name="title2_1"
												id="title2_1"	placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addColumnTitle2")%>" />
										</div>
                                                    <div class="Input_HalfWidth">
											<input type="text" name="duration2_1" class="Requiredfield"
												id="duration2_1"	placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addValue")%> *"/>
										</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
						<div class="Input_HalfWidth margin-right-22">
							<input type="text" name="optionTitle"
								id="optionTitle"
								value="${learning.optionTitle }"
									placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.howYouLearn.addTableTitle2")%>" />
						</div>
						<div class="Input_Fullwidth margin-20-topbottom">
							<liferay-ui:input-editor name="option1Editor"
								editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="<%= SPProductConstants.CK_EDITOR_TOOLBAR  %>"
								initMethod='<%="initEditor_learning_option1"%>'
								cssClass="ckeditor"  height="<%= SPProductConstants.CK_EDITOR_TOOLBAR_HEIGHT  %>"/>
								<aui:script>
									function <portlet:namespace />initEditor_learning_option1() {
										var temp = "${learning.option1}";
										if(temp.trim()==''){
											temp = "<%=col1Info%>";
										}
										return temp;
									}
								</aui:script>
						</div>
						<div class="Input_Fullwidth margin-20-topbottom">
							<liferay-ui:input-editor name="option2Editor"
								editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="<%= SPProductConstants.CK_EDITOR_TOOLBAR  %>"
								initMethod='<%="initEditor_learning_option2"%>'
								cssClass="ckeditor" height="<%= SPProductConstants.CK_EDITOR_TOOLBAR_HEIGHT  %>"/>
								<aui:script>
									function <portlet:namespace />initEditor_learning_option2() {
										var temp = "${learning.option2}";
										if(temp.trim()==''){
											temp = "<%=col2Info%>";
										}
										return temp;
									}
								</aui:script>
						</div>
						<div class="Input_Fullwidth margin-20-topbottom">
							<liferay-ui:input-editor name="noteEditor"
								editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="<%= SPProductConstants.CK_EDITOR_TOOLBAR  %>"
								initMethod='<%="initEditor_learning_note"%>'
								cssClass="ckeditor" height="<%= SPProductConstants.CK_EDITOR_TOOLBAR_HEIGHT  %>"/>
								<aui:script>
									function <portlet:namespace />initEditor_learning_note() {
										var temp = "${learning.note}";
										if(temp.trim()==''){
											temp = "<%=concludingText%>";
										}
										return temp;
									}
								</aui:script>
						</div>
						
					</div>
				</form>
			</div>
			<div class="Right_bottom">
				<a href="<%= listCourse %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> 
				<a href="javascript:;"	id="saveForm"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
				<div class="Prev-icon">
					<a href="javascript:courseTabslink('<%=addPersona%>','editPersona','persona');"></a>
				</div>
				<div class="Next-icon">
					<a href="javascript:courseTabslink('<%=addCareerDetails%>','editCareerDetails','careerDetails');"></a>
				</div>
			</div>
			<%
				} else {
			%>
			<div><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.message")%></div>
			<%
				}
			%>
		</div>
	</div>
</div>
<script src="/SPProduct-portlet/js/learning.js">
</script>
<script>
showSubMenu("courseSiderbar");
var A;
var	pns ="<portlet:namespace/>";
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A1){
	A = A1;
	var config = {
			pns : pns,
			ajaxUrl : '<%= ajaxUrl %>',
			courseId : <%= spCourseId %>,
			linkUrl : '<%=addCareerDetails%>',
			durationTypes : ${durationTypes},
			deleteError : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.delete.error")%>',
			durationRemoved : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.durationRemoved.message")%>',
			processError : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.process.error")%>',
			durationDelete : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.durationDelete.error.message")%>',
			learningUpdate : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.learning.update.message")%>'
			
	}
	new learingDetails(config);
});
</script>

