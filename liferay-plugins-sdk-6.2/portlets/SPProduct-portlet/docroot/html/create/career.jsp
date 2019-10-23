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
	courseDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.course.courseDescription");
	String addTitle = "Add a Title (Eg: 'Choose Your Study Options:')";
	addTitle = LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.study.option");
	String spCourseId = request.getParameter("spCourseId");
%>


<portlet:resourceURL var="ajaxUrl">
	<portlet:param name="action" value="addCareerDetails"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="uploadStudyOptionCoverImage">
	<portlet:param name="action" value="uploadStudyOptionCoverImage"></portlet:param>
</portlet:resourceURL>

<script src="<%=request.getContextPath()%>/js/dropzone.js"></script>
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
			<div class="Border" id="mainContainer">
				<div class="heading-title Border-bottom">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.career")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listCourse%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>
				<form action="#" method="POST" id="careerForm" name="careerForm">
					<div class="form-section ">
						<div class="Input_Fullwidth margin-20-topbottom">
							<liferay-ui:input-editor name="introEditor"
								editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="<%= SPProductConstants.CK_EDITOR_TOOLBAR %>"
								initMethod='<%="initEditor_intro"%>'
								cssClass="ckeditor" />
								<aui:script>
									function <portlet:namespace />initEditor_intro() {
										var temp = "${career.intro}";
										if(temp.trim()==''){
											temp = "<%=addTitle%>";
										}
										return temp;
									}
								</aui:script>
						</div>
						<div id="studyOptionContainerOuter">
                                        <div class="Input_Fullwidth text-right add_td_button">
         								  	<div class="Add_button">
             									<a href="javascript:;" class="Button-green button-pos-right" id="addStudyOption"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.career.option")%></a>
             								</div>
             							</div>
        								
                                        <div id="studyOptionInner" >
                                        <!--  "_1" indicates it's first row. It's mandatory -->
                                        </div>
                                        <div class="studyOptionWrapper hide" id="studyOptionWrapper_0">
                                            	<input type="hidden" id="studyOptionId_0" />
                                            	<input type="hidden" id="counter_0" value="0" data-indicator="true"/>
                                                <div class="form-inner Border Form-pop-padding Form-bg  FormBorder-active">
                                                   <div class="close_button">
														<span id="close"><img src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
																alt="Close"></span>
													</div>
                                                    <div class="form-summary-inner">
                                                        <div class="Input_HalfWidth margin-right-22">
															<input type="text" name="title_0"
																id="title_0"	placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.title")%>" />
														</div>
														<!-- must follow below structure - dont change -->
														<div class="Input_Fullwidth margin-20-topbottom" data-editor="true" data-name="studyOptionDesc_" data-counter="0">
															<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.career.description")%>
														</div>
														<!--  existing image -->
														<div class="editClosebutton hide" id="coverImageDisplay_0" data-exstng-img-div="true">
														</div>
														<!-- image upload -->
														<div class="Image_upload" id="uploadCoverImageDiv">
															<div id="coverImageDropzone_0" data-dropzone="true" data-name="coverImageId_" data-counter="0" 
																data-exstng-img-div-id="coverImageDisplay_">
																<input type="hidden" id="coverImageId_0" name="coverImageId_0" class="imageField" value=""/>
															</div>
														</div>
														<div class="footNoteMsg">
															<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes")%>:
															<ol>
																<li> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes.message1")%></li>
																<li> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.notes.message2")%></li>
															</ol> 
															
														</div>
                                                    </div>
                                                </div>
                                            </div>
                           </div>
					</div>
				</form>
			</div>
			<div class="Right_bottom">
				<a href="<%=listCourse %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> 
				<a href="#"	id="saveForm"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
				<div class="Prev-icon">
					<a href="javascript:courseTabslink('<%=addLearningDetails%>','editLearningDetails','learningDetails');"></a>
				</div>
				<div class="Next-icon">
					<a href="javascript:courseTabslink('<%=addGraduationCriteria%>','editGraduationCriteria','graduationCriteria');"></a>
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
<script src="/SPProduct-portlet/js/career.js">
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
			addCoverImageUrl : '<%= uploadStudyOptionCoverImage %>',
			courseId : <%= spCourseId %>,
			linkUrl : '<%=addGraduationCriteria%>',
			studyOptions : '${studyOptions}',
			imageUploadMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.drop.images")%>',
			imageRemoveMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.certificate.removeFile")%>',
			successMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.career.updated")%>',
			editorErrorMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.editor.error")%>',
			saveErrorMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.save.error")%>',
			deleteErrorMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.delete.error")%>',
			processErrorMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.process.error")%>',
			studyDelErrorMsg : '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.delete.error1")%>'
			
	};
	var obj = new careerDetails(config);
});
</script>

