<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@page import="com.sambaash.platform.srv.legalandcontract.model.Litigation"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="Litigation.filedon.date" message="Filed On is not valid" />
<liferay-ui:error key="Litigation.response.deadline" message="Response Deadline is not valid" />
<liferay-ui:error key="Litigation.custom.date1" message="Custom Date 1 is not valid" />
<liferay-ui:error key="Litigation.custom.date2" message="Custom Date 2 is not valid" />
<liferay-ui:error key="Litigation.custom.date3" message="Custom Date 3 is not valid" />
<liferay-ui:error key="Litigation.rdl.date" message="One or more Response Deadlines are not valid dates" />
<liferay-ui:error key="Litigation.rdl.date.empty" message="One or more Response Deadlines are blank. When Alert Before is set,corresponding Response Deadline can not be blank" />
<liferay-ui:error key="Litigation.not.working.copy" message="You are trying to update older version of Contentious Proceedings. Newer version of it is availble. Please work on it." />
<portlet:actionURL var="editLitigationActionURL" name="updateLitigation">
	<portlet:param name="litigationId" value="${litigationId}" />
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<link rel="stylesheet" type="text/css" media="all" href="/LegalAndContract-portlet/css/styles.css" />
<div>
	<span class="form_Title">Update Contentious Proceedings</span>

	<aui:form name="updateLitigation" action="<%=editLitigationActionURL%>">
		<aui:model-context bean="${litigation}" model="<%= Litigation.class %>" />
		<aui:input type="hidden" name="hiddenFileList" id="hiddenFileList" >
				    </aui:input>
		<aui:fieldset>
			<div class="form_fieldset_wrap">
				<!--<aui:input type="text" name="trademarkRegNumber" id="trademarkRegNumber" label="Trademark Registration Number" size="100">
					  <aui:validator name="required" errorMessage="Trademark Registration Number is required"></aui:validator>
			    </aui:input>-->
			    
			    <div class="form_dropD">
				    <aui:select name="trademarksIddd" label="Trademark Application Number" disabled="true">
						<c:forEach var="tm" items="${trademarks}">
							<aui:option value="${tm.key}" selected="${trademarksId == tm.key}" 
								label="${tm.value}"/>
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_field">
					<label class="field-label">Trademark</label>
					<a href="${trademarkUrl}" id="tmName" style="font-size: 15pt;">${trademarkText}</a>
			    </div>
			    
				<div class="form_dropD">
					<aui:select name="proceedingType" label="Proceedings" showEmptyOption="true">
						<c:forEach var="pt" items="${proceedingType}">
							<aui:option value="${pt.categoryId}" 
								selected="${proceddingsCatId == pt.categoryId}" 
								label="${pt.name}" />
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_field">
					<aui:input type="text" name="filedBy" id="filedBy" label="Filed By" size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
				<div class="form_field">
					<aui:input type="text" name="customField2" id="customField2"
						label="Third Party Trademark Number" size="100">
						<aui:validator name="rangeLength">[1,100]</aui:validator>
					</aui:input>
				</div>
				<div class="form_calendar_wrap">
					<ul>
						<li>
							<div class="form_calendar">
								<label class="field-label">Filed on</label>
								<liferay-ui:input-date dayValue="${filedOn.date }"
									dayParam="filedOnDay" disabled="false"
									monthParam="filedOnMonth" monthValue="${filedOn.month }"
									yearParam="filedOnYear" yearValue="${filedOn.year }"
									name="filedOn" nullable="${filedOn.nullable }"
									/>
							</div>
						</li>
					</ul>
				</div>

				<div class="form_field">
					<aui:input type="text" name="status" id="stauts" label="Status" size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    <div class="form_field">
					    <aui:input type="text" name="customField1" id="customField1" label="Law Firm" size="100">
					    <aui:validator name="rangeLength">[1,100]</aui:validator>
					    </aui:input>
				</div>
				<br/>
			 	<div>
					<aui:button type="button" id="addRdl" value="ADD"/>
				</div>
			   <br/>
					<div id="dynaRdlsContainer">
					<!-- ------------------------------- START SAMPLE CONTAINER, used to clone--------------------------------------------------->
						<div id="sampleRdlContainer" style='display: none'>
							<div class="form_calendar_wrap">
								<table>
									<tr>
										<td>
											<div class="form_calendar_wrap">
												<ul>
													<li>
														<div class="form_calendar">
															<label class="field-label">Response Deadline</label>
															<liferay-ui:input-date
																name="responseDeadline"
																dayValue="-1"
																dayParam="responseDeadlineDay" disabled="false"
																monthParam="responseDeadlineMonth"
																monthValue="-1"
																yearParam="responseDeadlineYear"
																yearValue="0"
																nullable="true"
																 />
														</div>
													</li>

												</ul>
											</div> <br />

											<div class="form_dropD">
												<aui:select name="alertBefore" label="Alert Before" >
													<c:forEach var="ab" items="${alertBefore}">
														<aui:option value="${ab.categoryId}" label="${ab.name}" />
													</c:forEach>
												</aui:select>
											</div>

										</td>
										<td>
											<div class="form_field">
												<aui:input type="textarea" name="claimsRemarks" 
													id="claimsRemarks" label="Remarks" rows="6" cols="30">
												</aui:input>
											</div>
										</td>
									</tr>
								</table>
							</div>
							<div class="form_calendar_wrap">
								<a id="rdlRemove" href="javascript:;" style='font-size: 10pt'>Remove</a>
							</div>
						</div>
						<!-- ------------------------------- END SAMPLE CONTAINER--------------------------------------------------->
						
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
															<label class="field-label">Response Deadline</label>
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
												<aui:select name="alertBefore${rdl.counter }" label="Alert Before" >
													<c:forEach var="ab" items="${alertBefore}">
														<aui:option value="${ab.categoryId}" selected="${ab.name == rdl.alertBefore}" label="${ab.name}" />
													</c:forEach>
												</aui:select>
											</div>

										</td>
										<td>
											<div class="form_field">
												<aui:input type="textarea" name="claimsRemarks${rdl.counter }" value = '${rdl.claimsRemarks}'
													id="claimsRemarks" label="Remarks" rows="6" cols="30"> 
												</aui:input>
											</div>
										</td>
									</tr>
								</table>
							</div>
							<div class="form_calendar_wrap">
								<a id="rdlRemove${rdl.counter }" href="javascript:;" style='font-size: 10pt'>Remove</a>
							</div>
						</div>
						<!-- ---------------------------------------END EXISTING RDLS ---------------------------- -->
						</c:forEach>
					</div>
		
			    <div class="form_filesTable">
					<label class="field-label">Files Associated with Contentious Proceeding</label>
				
				    <c:if test="${empty attachments}">
				    	<br><span style='font-weight:bold'> 0 Files </span>
				    </c:if>
				    <c:if test="${not empty attachments}">
					    <table id="filesTable">
					    	<tr class="filesTable_head">
					    	  <td>File Name</td>
					    	  <td>Version</td>
					    	  <td>Title</td>
					    	  <td>Description</td>
					    	  <td>Delete </td>
					    	</tr>
						    <c:forEach var="file" items="${attachments}">
						      	<tr id="row${file.fileEntryId}"> 
						      		<td>
						     		  <div style='font-weight:bold'>${file.title}</div>
						   		   </td>
						   		   <td>
						   		     ${file.version }
						   		   </td>
						   		   <td>
						      	      <aui:input name="title_${file.fileEntryId}" id="title_${file.fileEntryId}" type="text" size="100" value="${file.title }" label="">
						      	      <aui:validator name="rangeLength">[1,100]</aui:validator>
						      	      </aui:input>
						   		   </td>
						   		   <td>
						   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="5" cols="30" label=""></aui:input>
						   		   </td>
						   		   <td>
						   		      <a id="link${file.fileEntryId}"  href="javascript:;">Delete</a>
						   		   </td>
						        </tr>
						    </c:forEach>
					    </table>
				    </c:if>
			    </div>
			    <div class="forms_fileDrag_wrap">
					<label class="field-label">File Attachments:</label>
				    <input type="file" name="<portlet:namespace/>attachments" id="<portlet:namespace/>attachments" multiple><br>
				    <div id="filedrag1" class="form_fileDrag">or drop files here</div>
				   
				    <table id="filesTab1" class="form_filesTab">
				    </table>
			    </div>
			    
			    <div class="form_filesTable">
				    <c:if test="${empty prevAttachments}">
				    </c:if>
				    <c:if test="${not empty prevAttachments}">
				    	<span style='font-weight:bold'>Below files uploaded earlier but the transaction was not completed.These files will be included in this transaction.
				    	You can remove unwanted files.  </span>
					    <table id="preConfAttmntsTab">
					    	<tr class="filesTable_head">
					    	  <td>File Name</td>
					    	  <td>Title</td>
					    	  <td>Description</td>
					    	  <td>Delete</td>
					    	</tr>
						    <c:forEach var="file" items="${prevAttachments}">
						      <tr id="row${file.fileEntryId}"> 
						      	   <td>
						     		  <div style='font-weight:bold'>${file.title}</div>
						   		   </td>
						   		   <td>
						      	      <aui:input name="title_${file.fileEntryId}" id="title_${file.fileEntryId}" type="text" size="100" value="${file.title }" label="">
						      	      <aui:validator name="rangeLength">[1,100]</aui:validator>
						      	      </aui:input>
						   		   </td>
						   		    <td>
						   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="5" cols="30" label=""></aui:input>
						   		   </td>
						   		   <td>
						   		      <a id="link${file.fileEntryId}"  href="javascript:;">Remove</a>
						   		   </td>
						        </tr>
						    </c:forEach>
					    </table>
				    </c:if>
			   </div>
			   
			   <c:if test="${regionalRole}">
				<div class="form_field">
					<aui:input type="textarea" name="legalConfRemarks" id="legalConfRemarks" label="Legal Confidential Remarks" rows="5" cols="30">
				    </aui:input>
			    </div>
			   </c:if>
			    
			   <c:if test="${regionalRole}">
				    <div class="form_filesTable">
						<label class="field-label">Confidential Files Associated with Contentious Proceeding</label>
					    <c:if test="${empty confAttachments}">
					    	<br><span style='font-weight:bold'> 0 Files </span>
					    </c:if>
					    <c:if test="${not empty confAttachments}">
						    <table id="filesTable">
						    	<tr class="filesTable_head">
						    	  <td>File Name</td>
						    	  <td>Version</td>
						    	  <td>Title</td>
						    	  <td>Description</td>
						    	  <td>Delete </td>
						    	</tr>
							    <c:forEach var="file" items="${confAttachments}">
							      <tr id="row${file.fileEntryId}">
							      	   <td >
							     		  <div style='font-weight:bold'>${file.title}</div>
							   		   </td>
							   		   <td>
							   		     ${file.version }
							   		   </td>
							   		   <td>
							      	      <aui:input name="title_${file.fileEntryId}" id="title_${file.fileEntryId}" type="text" size="100" value="${file.title }" label="">
							      	      <aui:validator name="rangeLength">[1,100]</aui:validator>
							      	      </aui:input>
							   		   </td>
							   		   <td>
							   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="5" cols="30" label=""></aui:input>
							   		   </td>
							   		   <td >
							   		      <a id="link${file.fileEntryId}"  href="javascript:;">Delete</a>
							   		   </td>
							        </tr>
							    </c:forEach>
						    </table>
					    </c:if>
				    </div>
				     <div class="forms_fileDrag_wrap">
							<label class="field-label">Confidential File Attachments:</label><br>
						    <input type="file" name="<portlet:namespace/>confAttachments" id="<portlet:namespace/>confAttachments" multiple><br>
						     
						    <div id="filedrag2" class="form_fileDrag">or drop files here</div>
					    
						    <table id="filesTab2" class="form_filesTab">
						    </table>
				    
				    </div>
				    
				    
				    <div class="form_filesTable">
						<c:if test="${empty prevConfAttachments}">
					    </c:if>
					    <c:if test="${not empty prevConfAttachments}">
					    	<span style='font-weight:bold'>Below files uploaded earlier but the transaction was not completed.These files will be included in this transaction.
					    	You can remove unwanted files.  </span>
						    <table id="preAttmntsTab">
						    	<tr class="filesTable_head">
						    	  <td>File Name</td>
						    	  <td>Title</td>
						    	  <td>Description</td>
						    	  <td>Delete </td>
						    	</tr>
							    <c:forEach var="file" items="${prevConfAttachments}">
							      <tr id="row${file.fileEntryId}"> 
							      	   <td>
							     		  <div style='font-weight:bold'>${file.title}</div>
							   		   </td>
							      	   <td>
							      	      <aui:input name="title_${file.fileEntryId}" id="title_${file.fileEntryId}" type="text" size="100" value="${file.title }" label="">
							      	      <aui:validator name="rangeLength">[1,100]</aui:validator>
							      	      </aui:input>
							   		   </td>
							   		   <td>
							   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="5" cols="30" label=""></aui:input>
							   		   </td>
							   		   <td>
							   		      <a id="link${file.fileEntryId}"  href="javascript:;">Remove</a>
							   		   </td>
							        </tr>
							    </c:forEach>
						    </table>
					    </c:if>
					</div>
			    </c:if>
	
				<div class="form_CTA">
					<aui:button-row>
						<aui:button type="submit" name="updateLitigation" id="updateLitigation"
							value="Update Contentious Proceedings" label="" />
						 <aui:button type="cancel" id='cancel'/>
					</aui:button-row>
				</div>  
			</div>
			
		</aui:fieldset>
	</aui:form>

</div>
<%@ include file="/html/searchParams.jsp" %>
<script>
var deletedFiles = [];
var filesCount=0;
var pns = '<portlet:namespace/>';
AUI().use('aui-node','aui-base',function(A){
	var fileTable = A.all("#filesTable");
	var links = fileTable.all("a");
	links.each(function (link, index) {
	    link.on("click", function(em){
	    	deletedFiles[filesCount]=link.getAttribute('id').substring(4);
	    	A.one("#row" + deletedFiles[filesCount]).remove();
	    	var hiddenNode = A.one("#" + pns + "hiddenFileList");
	    	var clist = "" ;
	    	for	(i = 0; i < deletedFiles.length; i++) {
	    		clist = clist + deletedFiles[i] + ",";
	    	}
	    	hiddenNode.setAttribute("value",clist);
	    	filesCount = filesCount + 1;
	    });
	});
});
</script>
<script type="text/javascript" src="/LegalAndContract-portlet/js/misc.js" ></script>
<script>
var trdNs = "<portlet:namespace/>";
var ajaxurl = "<%=resourceURL %>";
removeFile('preAttmntsTab');
removeFile('preConfAttmntsTab');
var hasPerm = ${regionalRole};
try{
	//var rdlCount = ${rdlsCount};
	var tmprdlc = '${rdlsCount}';
	var rdlCount = 100;
	try{
		rdlCount = parseInt(tmprdlc);  
	}catch(err){
		
	}
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
	obj1.Init('filedrag1','filesTab1','attachments',ajaxurl,'draganddrop',pns);
	obj1.Init('filedrag1','filesTab1','attachments',ajaxurl,'fileInput',pns);
	if(hasPerm == true){
		var obj2 = new trademarkFileDrag();
		obj2.Init('filedrag2','filesTab2','confAttachments',ajaxurl,'draganddrop',pns);
		obj2.Init('filedrag2','filesTab2','confAttachments',ajaxurl,'fileInput',pns);
	}
}

</script>