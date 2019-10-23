<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%int i=0; %>
<input type="hidden" id="globalCountId"  name="globalCountId" value="${personaDetailListLength}">
<c:forEach  var="personaDetail" items="${personaDetailList}">
<div class="personaWrapper" id="personaWrapperId_<%=i%>">
                                <div class="form-inner Border Form-pop-padding Form-bg  FormBorder-active">
                                    <div class="close_button">
                                        <span onclick="javascript:removeByInstanceIdWithMandatoryFields('personaWrapperId_<%=i%>','Atleast one Persona detail is required');"><img src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg" alt="Close"></span>
                                    </div>
                                    <div class="form-summary-inner">
                                     
                                        <div class="Input_HalfWidth">
                                            <div class="select_style" >
                                                <select id="personaTypeListId_<%=i%>" name="personaTypeList_<%=i%>" class="Requiredfield" onblur="requiredFieldValidation(this, 'Persona Type*', ' is required');">
                                                    <option selected disabled value="0">Persona Type *</option>
                                                    <c:forEach var="personaTypeList" items="${personaTypeList}">
                                                    	<c:if test="${personaDetail.personaType ==  personaTypeList.categoryId}">
															<option value="${personaTypeList.categoryId}" selected>${personaTypeList.name}</option>
														</c:if>
														<c:if test="${personaDetail.personaType !=  personaTypeList.categoryId}">
															<option value="${personaTypeList.categoryId}">${personaTypeList.name}</option>
														</c:if>
													</c:forEach>
                                                </select>
                                                
                                            </div>
                                        </div>
                                     
                                    </div>
                                  
                                                    <div class="form-summary-inner">
                                                    
			                                            <div class="Input_Fullwidth margin-20-topbottom">
															<div class="Admin-textarea">
																<textarea name="personaAttendanceDesc_<%=i%>" id="personaAttendanceDescId_<%=i%>"
																	placeholder="Persona Description*" maxlength="360">${personaDetail.personaDesc}</textarea>
															</div>
															<div class="footNoteMsg">
																Note:Maximum of 360 characters.
															</div>
														</div>
                                                     
														<c:set var="imageId"
															value="${personaDetail.personaImageId }" />
														<%
														    String imageDivId = "imageDiv_" + i; 
														%>
														<div id="<%= imageDivId %>">
														   <%
														   	 long imageId = GetterUtil.getLong((Long) pageContext.getAttribute("imageId"));
														   	 String imgUrl = "";
														   	pageContext.setAttribute("imageUrl", "");
														   	 if(imageId > 0){
														   		 try{
																     imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(imageId),
																			themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																			themeDisplay.getPathContext(), 1);
														   			 
														   		 }catch(Exception ex){
																	   			 
														   		 }
																   	pageContext.setAttribute("imageUrl", imgUrl);
														   	 }
														   %>
														   <%
														   	   String htmlIdImagTag = "attendAttachmentId_" + i ; 
														   %>
														   <c:if test="${not empty imageUrl }">
														   		<img src="${imageUrl }" alt="Persona">
														   		<div>
																	<button onClick="removeImage('<%= imageDivId %>' , '<%=htmlIdImagTag %>');return false;">Remove file</button>
																</div>
														   </c:if>
														   
														</div>
														<div class="Image_upload" id="uploadImageVal_<%=i%>">
															<div id="attendeeDropzone_<%=i%>">
																<input type="hidden" id="<%=htmlIdImagTag %>" name="attendAttachment_<%=i%>" class="imageField" value="${personaDetail.personaImageId}">
															</div>
														</div>
														<%@include file="/html/create/imagespecNote.jsp" %>
                                                    </div>
                                            <script>
                                            addDropZone('attendeeDropzone_<%=i%>','attendAttachmentId_<%=i%>','<%= imageDivId %>');
                                            </script>
                                  </div>
                            </div>
                            <%i=i+1; %>
                            </c:forEach>
