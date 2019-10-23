<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="Litigation.filedon.date" message='<%= LanguageUtil.get(pageContext,"filed.on.not.valid")%>' />
<liferay-ui:error key="Litigation.response.deadline" message='<%= LanguageUtil.get(pageContext,"response.deadline.not.valid")%>' />
<liferay-ui:error key="Litigation.custom.date1" message='<%= LanguageUtil.get(pageContext,"custom.date1.not.valid")%>' />
<liferay-ui:error key="Litigation.custom.date2" message='<%= LanguageUtil.get(pageContext,"custom.date2.not.valid")%>' />
<liferay-ui:error key="Litigation.custom.date3" message='<%= LanguageUtil.get(pageContext,"custom.date3.not.valid")%>' />
<liferay-ui:error key="litigaiton.trademarkId.required" message='<%= LanguageUtil.get(pageContext,"trademark.application.number.required")%>' />
<liferay-ui:error key="Litigation.rdl.date" message='<%= LanguageUtil.get(pageContext,"one.more.response.deadlines.not.valid")%>' />
<liferay-ui:error key="Litigation.rdl.date.empty" message='<%= LanguageUtil.get(pageContext,"one.more.response.deadlines.blank")%>' />


<portlet:actionURL var="addLitigationActionURL" name="addLitigation">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" />

<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<link rel="stylesheet" type="text/css" media="all" href="/LegalAndContract-portlet/css/styles.css" />
<div>
	<span class="form_Title"><%= LanguageUtil.get(pageContext,"create.contentious.proceedings")%></span>
	<c:if test="${empty trademarks }">
		<p><%= LanguageUtil.get(pageContext,"no.trademarks.available")%> </p>
	</c:if>
	<c:if test="${not empty trademarks}">
	<aui:form name="createLitigation" action="<%=addLitigationActionURL%>">
		<aui:fieldset>
			<div class="form_fieldset_wrap">
			 <!-- 	<aui:input type="text" name="trademarkRegNumber" id="trademarkRegNumber" label="Trademark Registration Number" size="100">
					  <aui:validator name="required" errorMessage="Trademark Registration Number is required"></aui:validator>
			    </aui:input> -->
			    <div class="form_dropD">
				    <aui:select name="trademarksIddd" label='<%= LanguageUtil.get(pageContext,"trademark.application.number")%>' showEmptyOption="true">
						<c:forEach var="tm" items="${trademarks}">
							<aui:option value="${tm.key}" selected="${trademarksId == tm.key}" 
								label="${tm.value}" />
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_field">
					<label class="field-label"><%= LanguageUtil.get(pageContext,"trademark")%></label>
					<a href="${trademarkUrl}" id="tmName" style="font-size: 15pt;">${trademarkText}</a>
			    </div>
				
				<div class="form_dropD">
					<aui:select name="proceedingType" label='<%= LanguageUtil.get(pageContext,"proceedings")%>' showEmptyOption="true">
						<c:forEach var="pt" items="${proceedingType}">
							<aui:option value="${pt.categoryId}"
								label="${pt.name}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="form_field">
					<aui:input type="text" name="filedBy" id="filedBy" label='<%= LanguageUtil.get(pageContext,"filed.by")%>' size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    <div class="form_field">
				    <aui:input type="text" name="customField2" id="customField2" label='<%= LanguageUtil.get(pageContext,"third.party.trademark.number")%>' size="100">
				    <aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
				</div>
					<div class="form_calendar_wrap">
						<ul>
							<li>
								<div class="form_calendar">
									<label class="field-label"><%= LanguageUtil.get(pageContext,"filed.on")%></label>
									<liferay-ui:input-date dayValue="${filedOn.date }"
										dayParam="filedOnDay" disabled="false"
										monthParam="filedOnMonth" monthValue="${filedOn.month }"
										yearParam="filedOnYear" yearValue="${filedOn.year }"
										name="filedOn"
										nullable="${filedOn.nullable }"
										/>
								</div>
							</li>
						</ul>
					</div>

				<div class="form_field">
					<aui:input type="text" name="status" id="stauts" label='<%= LanguageUtil.get(pageContext,"status")%>' size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    <div class="form_field">
					    <aui:input type="text" name="customField1" id="customField1" label='<%= LanguageUtil.get(pageContext,"law.firm")%>' size="100">
					    <aui:validator name="rangeLength">[1,100]</aui:validator>
					    </aui:input>
				</div>
			 
			    
			   
			   <br/>
			 	<div>
					<aui:button type="button" id="addRdl" value='<%= LanguageUtil.get(pageContext,"add")%>'/>
				</div>
				<br/>
					<div id="dynaRdlsContainer">
					<!-- ------------------------------START OF SAMPLE RDL CONTAINER ---------------------------------- -->
						<div id="sampleRdlContainer" style='display: none'>
							<div class="form_calendar_wrap">
								<table>
									<tr>
										<td>
											<div class="form_calendar_wrap">
												<ul>
													<li>
														<div class="form_calendar">
															<label class="field-label"><%= LanguageUtil.get(pageContext,"response.deadline")%></label>
															<liferay-ui:input-date
																name="responseDeadline"
																nullable="true"
																dayValue="0"
																dayParam="responseDeadlineDay" 
																monthParam="responseDeadlineMonth"
																monthValue="-1"
																yearParam="responseDeadlineYear"
																yearValue="0"
																/>
														</div>
													</li>

												</ul>
											</div> <br />

											<div class="form_dropD">
												<aui:select name="alertBefore" label='<%= LanguageUtil.get(pageContext,"alert.before")%>' >
													<c:forEach var="ab" items="${alertBefore}">
														<aui:option value="${ab.categoryId}" label="${ab.name}" />
													</c:forEach>
												</aui:select>
											</div>

										</td>
										<td>
											<div class="form_field">
												<aui:input type="textarea" name="claimsRemarks"
													id="claimsRemarks" label='<%= LanguageUtil.get(pageContext,"remarks")%>' rows="6" cols="30">
												</aui:input>
											</div>
										</td>
									</tr>
								</table>
							</div>
							<div class="form_calendar_wrap">
								<a id="rdlRemove" href="javascript:;" style='font-size: 10pt'><%= LanguageUtil.get(pageContext,"remove")%></a>
							</div>
						</div>
					<!-- --------------------- END OF SAMPLE RDL CONTAINER --------------------------- -->
					<!-- ---------------------------------------START EXISTING RDLS ---------------------------- -->
						<c:forEach var="rdl" items="${rdls}">
						 <div id="rdl${rdl.counter }">
							<div class="form_calendar_wrap">
								<table>
									<tr>
										<td>
											<div class="form_calendar_wrap">
												<ul>
													<li>
														<div class="form_calendar">
															<label class="aui-field-label"><%= LanguageUtil.get(pageContext,"response.deadline")%></label>
															<liferay-ui:input-date
																dayValue="${rdl.responseDeadlineDay}"
																dayParam="responseDeadlineDay${rdl.counter }" disabled="false"
																monthParam="responseDeadlineMonth${rdl.counter }"
																monthValue="${rdl.responseDeadlineMonth }"
																yearParam="responseDeadlineYear${rdl.counter }"
																yearValue="${rdl.responseDeadlineYear }"
																name="responseDeadline${rdl.counter }"
																 />
														</div>
													</li>

												</ul>
											</div> <br />

											<div class="form_dropD">
												<aui:select name="alertBefore${rdl.counter }" label='<%= LanguageUtil.get(pageContext,"alert.before")%>'>
													<c:forEach var="ab" items="${alertBefore}">
														<aui:option value="${ab.categoryId}" selected="${ab.name == rdl.alertBefore}" label="${ab.name}" />
													</c:forEach>
												</aui:select>
											</div>

										</td>
										<td>
											<div class="form_field">
												<aui:input type="textarea" name="claimsRemarks${rdl.counter }" value = '${rdl.claimsRemarks}'
													id="claimsRemarks" label='<%= LanguageUtil.get(pageContext,"remarks")%>' rows="6" cols="30" > 
												</aui:input>
											</div>
										</td>
									</tr>
								</table>
							</div>
							<div class="form_calendar_wrap">
								<a id="rdlRemove${rdl.counter }" href="javascript:;" style='font-size: 10pt'><%= LanguageUtil.get(pageContext,"remove")%></a>
							</div>
						</div>
						<!-- ---------------------------------------END EXISTING RDLS ---------------------------- -->
						</c:forEach>
					</div>
					<div class="forms_fileDrag_wrap">

							<label class="field-label"><%= LanguageUtil.get(pageContext,"file.attachments")%>: </label> <input
								type="file" name="<portlet:namespace/>attachments"
								id="<portlet:namespace/>attachments" multiple><br>

							<div id="filedrag1" class="form_fileDrag"><%= LanguageUtil.get(pageContext,"drop.files.here")%></div>

							<table id="filesTab1" class="form_filesTab">
							</table>

							<c:if test="${empty attachments}">
							</c:if>
							<c:if test="${not empty prevAttachments}">
								<div class="form_filesTable">
									<span><%= LanguageUtil.get(pageContext,"uploaded.earlier.but.transaction.not.complete")%></span>
									<table id="preConfAttmntsTab">
										<tr class="filesTable_head">
											<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"file.name")%></td>
											<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"title")%></td>
											<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"description")%></td>
											<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"delete")%>
											</td>
										</tr>
										<c:forEach var="file" items="${prevAttachments}">
											<tr id="row${file.fileEntryId}">
												<td style='margin-left: 20px'>
													<div style='font-weight: bold'>${file.title}</div>
												</td>
												<td><aui:input name="title_${file.fileEntryId}"
														id="title_${file.fileEntryId}" type="text" size="100"
														value="${file.title }" label="">
														<aui:validator name="rangeLength">[1,100]</aui:validator>
													</aui:input></td>
												<td><aui:input type="textarea"
														name="fileDesc_${file.fileEntryId}"
														id="fileDesc_${file.fileEntryId}"
														value="${file.description }" rows="5" cols="30" label=""></aui:input>
												</td>
												<td style='margin-left: 20px'><a
													id="link${file.fileEntryId}" href="javascript:;"><%= LanguageUtil.get(pageContext,"remove")%></a>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:if>

						</div>

						<c:if test="${regionalRole}">

							<div class="form_field">
								<aui:input type="textarea" name="legalConfRemarks"
									id="legalConfRemarks" label='<%= LanguageUtil.get(pageContext,"legal.confidential.remarks")%>'
									rows="5" cols="50">
								</aui:input>
							</div>


							<div class="forms_fileDrag_wrap">


								<label class="field-label"><%= LanguageUtil.get(pageContext,"confidential.file.attachments")%>:</label> <input type="file"
									name="<portlet:namespace/>confAttachments"
									id="<portlet:namespace/>confAttachments" multiple>

								<div id="filedrag2" class="form_fileDrag"><%= LanguageUtil.get(pageContext,"drop.files.here")%></div>

								<table id="filesTab2" class="form_filesTab">
								</table>

								<c:if test="${empty prevConfAttachments}">
								</c:if>
								<c:if test="${not empty prevConfAttachments}">
									<div class="form_filesTable">
										<span><%= LanguageUtil.get(pageContext,"uploaded.earlier.but.transaction.not.complete")%> </span>
										<table id="preAttmntsTab">
											<tr class="filesTable_head">
												<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"file.name")%>
													</td>
												<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"title")%>
												</td>
												<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"description")%>
												</td>
												<td style='font-weight: bold; margin-left: 20px'><%= LanguageUtil.get(pageContext,"delete")%>
												</td>
											</tr>
											<c:forEach var="file" items="${prevConfAttachments}">
												<tr id="row${file.fileEntryId}">
													<td style='margin-left: 20px'>
														<div style='font-weight: bold'>${file.title}</div>
													</td>
													<td><aui:input name="title_${file.fileEntryId}"
															id="title_${file.fileEntryId}" type="text" size="100"
															value="${file.title }" label="">
															<aui:validator name="rangeLength">[1,100]</aui:validator>
														</aui:input></td>
													<td><aui:input type="textarea"
															name="fileDesc_${file.fileEntryId}"
															id="fileDesc_${file.fileEntryId}"
															value="${file.description }" rows="5" cols="30" label=""></aui:input>
													</td>
													<td style='margin-left: 20px'><a
														id="link${file.fileEntryId}" href="javascript:;"><%= LanguageUtil.get(pageContext,"remove")%></a>
													</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</c:if>
							</div>
						</c:if>

						<div class="form_CTA">
							<aui:button-row>
								<aui:button type="submit" name="addLitigation"
									id="addLitigation" value='<%= LanguageUtil.get(pageContext,"add.contentious.proceedings")%>' label="" />
								<aui:button type="cancel" id='cancel'/>
							</aui:button-row>
						</div>
					</div></aui:fieldset>
	</aui:form>
	</c:if>
</div>
<%@ include file="/html/searchParams.jsp" %>
<script type="text/javascript" src="/LegalAndContract-portlet/js/misc.js" ></script>

<script>
var trdNs = "<portlet:namespace/>";
var ajaxurl = "<%=resourceURL %>";
var filesCount=0;
removeFile('preAttmntsTab');
removeFile('preConfAttmntsTab');
var hasPerm = ${regionalRole};
try{
	var tmprdlc = '${rdlsCount}';
	console.log("tmprdlc " + tmprdlc);
	var rdlCount = 100;
	try{
		rdlCount = parseInt(tmprdlc);  
	}catch(err){
		
	}
	//var rdlCount = ${rdlsCount};
	initrdlAddButton();
	initRdlRemoveLinks();
	initTmDropDown(ajaxurl, trdNs);
}catch(err){
	console.error(err);
}
</script>

<script type="text/javascript" src="/LegalAndContract-portlet/js/filedrag.js" ></script>
<script>
//call initialization file
if (window.File && window.FileList && window.FileReader) {
	var obj1 = new trademarkFileDrag();
	obj1.Init('filedrag1','filesTab1','attachments',ajaxurl,'draganddrop',trdNs);
	obj1.Init('filedrag1','filesTab1','attachments',ajaxurl,'fileInput',trdNs);
	if(hasPerm == true){
		var obj2 = new trademarkFileDrag();
		obj2.Init('filedrag2','filesTab2','confAttachments',ajaxurl,'draganddrop',trdNs);
		obj2.Init('filedrag2','filesTab2','confAttachments',ajaxurl,'fileInput',trdNs);
	}
}

</script>
