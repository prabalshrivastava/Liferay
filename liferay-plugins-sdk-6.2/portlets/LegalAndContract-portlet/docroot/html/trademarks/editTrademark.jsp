<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sambaash.platform.srv.legalandcontract.model.Trademarks" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="trademarks.class.code.required" message="Class is required" />
<liferay-ui:error key="trademarks.status.required" message="Status is required" />
<liferay-ui:error key="trademarks.renewal.alert.before.required" message="Renewal Alert Before is required" />
<liferay-ui:error key="trademarks.trademark.required" message="Trademark is required" />
<liferay-ui:error key="trademarks.trademarksId.missing" message="Invalid trademarks update. Trademark Id is missing in the request. Please reopen the trademarks page from listing screen and update again." />
<liferay-ui:error key="trademarks.trademark.localized.required" message="Non Latin characters found in Trademark. So Trademark (Latin) is required." />
<liferay-ui:error key="trademarks.applicationNo.required" message="Application No is required" />
<liferay-ui:error key="trademarks.pendingComments.required" message="Pending Action/Comments is required" />
<liferay-ui:error key="trademarks.remarks.required" message="Legal Confidential Remarks is required" />
<liferay-ui:error key="trademarks.classDescription.required" message="Class Specifications is required" />
<liferay-ui:error key="unauthorized.trademarks.country.update" message="You are not authorized to update Trademarks with selected country" />
<liferay-ui:error key="trademarks.applicaiton.date" message="Application Date is not valid" />
<liferay-ui:error key="trademarks.registration.date" message="Registration Date is not valid" />
<liferay-ui:error key="trademarks.expiry.date" message="Expiry Date is not valid" />
<liferay-ui:error key="trademarks.priority.date" message="Priority Date is not valid" />
<liferay-ui:error key="trademarks.custom.date2" message="Custom Date2 is not valid" />
<liferay-ui:error key="trademarks.custom.date3" message="Custom Date3 is not valid" />
<liferay-ui:error key="trademarks.not.working.copy" message="You are trying to update older version of Trademark. Newer version of it is availble. Please do update on it." />


<portlet:actionURL var="updateTrademarkActionURL" name="updateTrademarks">
</portlet:actionURL>
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<portlet:renderURL portletMode="view" var="viewURL" />

<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<link rel="stylesheet" type="text/css" media="all" href="/LegalAndContract-portlet/css/styles.css" />
<div>
	<span class="form_Title">Update Trademark</span>
  	<c:if test="${empty countryList}">Presently no countries are available with your roles. Contact Administrator</c:if>
	<div class="form_field_logo" id="noI" >
				 	<c:if test="${trademark.trademarkType == 'logo'}">
				 	  <img alt="no logo available" src="${logoUrl }" >
				 	</c:if>
				 	<c:if test="${trademark.trademarkType != 'logo'}">
				 	  <c:out value="${trademark.trademark }"></c:out>
				 	</c:if>
	</div>
	
	<aui:form name="updateTrademarkForm" action="<%=updateTrademarkActionURL%>" method="post">
		<aui:model-context bean="${trademark}" model="<%= Trademarks.class %>" />
		<aui:fieldset>
			<div class="form_fieldset_wrap">
			 <c:if test="${not empty countryList}">
				
				<div class="form_field" style="display: none;">
					<aui:input type="hidden" name="hiddenFileList" id="hiddenFileList" label="TM AGENT Number">
				    </aui:input>
					<aui:input type="hidden" name="trademarksId" id="trademarksId" value="${trademarksId}">
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					<aui:input type="text" name="applicationNo" id="applicationNo" label="Application Number" size="100" disabled="true">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    
			     <div class="form_field">
					<aui:input type="text" name="registrationNumber" id="registrationNumber" label="Registration Number" size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					    <aui:input type="text" name="customField2" id="customField2" label="International Registration Number" size="100">
					    <aui:validator name="rangeLength">[1,100]</aui:validator>
					    </aui:input>
				</div>
				
				<div class="form_dropD">
					    <aui:select name="customList1" label="Registered Owner">
							<c:forEach var="listEntry" items="${customList1}">
								<aui:option value="${listEntry.categoryId}"
									selected="${customList1CatId == listEntry.categoryId}" 
									label="${listEntry.name}" />
							</c:forEach>
						</aui:select>
					</div>
			    
			    <div class="form_dropD">
					<aui:select name="status" label="STATUS">
						<c:forEach var="catg" items="${status}">
							<aui:option value="${catg.categoryId}"
								selected="${statusCatId == catg.categoryId}" 
								label="${catg.name}" />
						</c:forEach>
					</aui:select>
				</div>
			    
			    <div class="form_dropD">
					<aui:select name="countryList" label="Country" disabled="true">
						<c:forEach var="countries" items="${countryList}">
							<aui:option value="${countries.categoryId}" 
								 selected="${countryCatId == countries.categoryId}" 
								label="${countries.name}" />
						</c:forEach>
					</aui:select>
				</div>
				
			<!--  	<div class="form_dropD">
					<aui:select name="classCode" label="Class Code">
						<c:forEach var="cc" items="${classCode}">
							<aui:option value="${cc.categoryId}" 
								 selected="${categoryIds[1] == cc.categoryId}" 
								label="${cc.name}" />
						</c:forEach>
					</aui:select>
				</div> 
				
				<div class="form_textA">
					<aui:input type="textarea" name="classDescription" id="classDescription" label="Class Specifications" rows="5" cols="30" >
							  <aui:validator name="required" errorMessage="Class Specifications is required"></aui:validator>
					 </aui:input>
				 </div>
				 -->
			     <div class="form_dropD">
					<aui:select name="trademarkType" label="Trademark Type">
							<aui:option value="word" selected="${trademarkType == 'word'}"		
								label="Word" />
							<aui:option value="logo" selected="${trademarkType == 'logo'}" 			
								label="Logo" />
					</aui:select>
				</div>
				
			    
				<div id='wordDiv' class="form_field">
					<aui:input type="text" name="trademark" id="trademark" label="Trademark *" size="100">
					<aui:validator name="custom"
				                     errorMessage="Please enter Trademark">
									function (val, fieldNode, ruleValue) {
										return validateTM(val, '<portlet:namespace/>');
									}
							</aui:validator>
				    </aui:input>
				     <span id="tmlocalized" style="display:none">
						<aui:input type="text" name="trademarkLocalized" id="trademarkLocalized" label="Trademark (Latin) *" size="100" >
							<aui:validator name="custom"
				                     errorMessage="Please enter Trademark (Latin) in less than 100 chars">
									function (val, fieldNode, ruleValue) {
									    if(val.length > 100) {
									    	return false;
									    }
										return validateLocalizedTM(val, '<portlet:namespace/>');
									}
							</aui:validator>
					    </aui:input>
				    </span>
			    </div>
			     <div id='logoDiv' class="form_field">
				    <aui:input type="file" name="trademarkLogo" id="trademarkLogo" accept="image/*">
			    		<aui:validator name="custom"
			                     errorMessage="Please enter logo">
								function (val, fieldNode, ruleValue) {
									return validateLogo('<portlet:namespace/>');
								}
						</aui:validator>
				    </aui:input>
				    <table id="filesTable" class="form_filesTab">
				             <c:if test="${not empty logo}">
						      	<tr id="row${logo.fileEntryId}"> 
						      		<td>
						     		  <div style='font-weight:bold'>${logo.title}</div>
						   		   </td>
						   		   <td>
						      	      <aui:input name="title_${logo.fileEntryId}" id="title_${logo.fileEntryId}" type="text" size="100" value="${logo.title }" label="">
						      	      <aui:validator name="rangeLength">[1,100]</aui:validator>
						      	      </aui:input>
						   		   </td>
						   		   <td>
						   			   <aui:input type="textarea" name="fileDesc_${logo.fileEntryId}" id="fileDesc_${logo.fileEntryId}"  value="${logo.description }" rows="5" cols="30" label=""></aui:input>
						   		   </td>
						   		   <td>
						   		      <a id="link${logo.fileEntryId}"  href="javascript:;">Delete</a>
						   		   </td>
						        </tr>
				             </c:if>
				    </table>
			    </div>
			    
			    <div class="form_calendar_wrap">
					<ul>
						<li>
							<div class="form_calendar">
								<label class="field-label">Application Date</label>
								<liferay-ui:input-date
									dayValue="${applicationDate.date }"
									dayParam="applicationDateDay" disabled="false"
									monthParam="applicationDateMonth"
									monthValue="${applicationDate.month }"
									yearParam="applicationDateYear"
									yearValue="${applicationDate.year }"
									name="applicationDate"
									nullable="${applicationDate.nullable }"/>
							</div>
							<div class="form_calendar">
								
								<label class="field-label">Registration Date</label> 
								<liferay-ui:input-date
										dayValue="${firstRegDate.date }" 
										dayParam="firstRegDateDay"	disabled="false"
										monthParam="firstRegDateMonth"
										monthValue="${firstRegDate.month }"
										yearParam="firstRegDateYear"
										yearValue="${firstRegDate.year }"
										name="firstRegDate"
										nullable="${firstRegDate.nullable }"/>
								
							</div>
							<div class="form_calendar">
								<label class="field-label">Priority Date</label>
								<liferay-ui:input-date
									dayValue="${customDate1.date }"
									dayParam="customDay1" disabled="false"
									monthParam="customMonth1"
									monthValue="${customDate1.month }"
									yearParam="customYear1"
									yearValue="${customDate1.year }"
									name="customDate1"
									nullable="${customDate1.nullable }"/>
							</div>
							<div class="form_calendar"> 
								<label class="field-label">Expiry Date</label>
								<liferay-ui:input-date
									dayValue="${renewalDate.date }"
									dayParam="renewalDateDay" disabled="false"
									monthParam="renewalDateMonth"
									monthValue="${renewalDate.month }"
									yearParam="renewalDateYear"
									yearValue="${renewalDate.year }"
									name="renewalDate"
									nullable="${renewalDate.nullable }"/>
							</div>
						</li>
					</ul>
				</div>
				
				<div class="form_dropD">
					<aui:select name="renewalAlertBefore" label="Renewal Alert Before">
						<c:forEach var="catg" items="${renewalAlertBefore}">
							<aui:option value="${catg.categoryId}" 
								selected="${renewalAlertBeforeCatId == catg.categoryId}" 
								label="${catg.name}" />
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_dropD">
					<aui:select name="agencyIddd" label="Law Firm" showEmptyOption="true">
						<c:forEach var="agency" items="${agencies}">
							<aui:option value="${agency.key}" selected="${ agency.key == trademark.spAgencyId}" 
								label="${agency.value}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="form_group">
					<aui:button type="button" id="addClassCode" value="ADD CLASSCODE"/>
					<br/>
					<div class="dynaClassCodeContainer">
						<div id='sampleClassCodeContainer' style='display:none'>
							<aui:select name="cCode" label="Class Code">
								<c:forEach var="attr" items="${classCode}">
	            					<aui:option value="${attr.categoryId}">${attr.name}</aui:option>
	        					</c:forEach>  
							</aui:select>
							<aui:input name="cSpec" type="textarea" rows="5" cols="30" label="Class Specification"></aui:input>
							<a id="classCoderemove"  href="javascript:;" style='font-size:10pt'>Remove</a>
						</div>
						<c:forEach var="ccObj" items="${classcodes}">
							<div id='ccData${ccObj.counter}'>
								<aui:select name="cCode${ccObj.counter }" label="Class Code">
									<c:forEach var="attr" items="${classCode}">
		            					<aui:option value="${attr.categoryId}" selected="${attr.name == ccObj.cCode}">${attr.name}</aui:option>
		        					</c:forEach>  
								</aui:select>
								<aui:input name="cSpec${ccObj.counter }" type="textarea" rows="5" cols="30" label="Class Specification" value='${ccObj.cSpec }'></aui:input>
								<a id="classCoderemove${ccObj.counter }"  href="javascript:;" style='font-size:10pt'>Remove</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="form_customField_wrap">
					<div class="form_field">
						<aui:input type="textarea" name="pendingComments" id="pendingComments" label="Remarks"  rows="5" cols="30" >
					    </aui:input>
				    </div>
					<div class="form_field">
					    <aui:input type="textarea" name="customField1" id="customField1" label="Active Ingredients" rows="5" cols="30">
					    </aui:input>
				    </div>
				    
				    
				    
				    <div class="form_field">
					    <aui:input type="textarea" rows="5" cols="30" name="customField3" id="customField3" label="History" size="100">
					    </aui:input>
				    </div>
			    </div>
				
				
			    
				<div class="form_filesTable">
					<label class="field-label">Files attached to this trademark</label>
				<!-- 	<liferay-util:include page="/html/trademarks/sample.jsp"/>
					<liferay-util:include page="/html/trademarks/sample.jsp">
					  <liferay-util:param name="attributeName" value="attachments"></liferay-util:param>
					</liferay-util:include>
					<liferay-util:include page="/html/trademarks/sample.jsp" portletId="trademarksmaster_WAR_LegalAndContractportlet">
					  <liferay-util:param name="attributeName" value="trademarksmaster_WAR_LegalAndContractportlet"></liferay-util:param>
					</liferay-util:include>
				     -->
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
						<label class="field-label">Confidential Files attached to this trademark</label>
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
				<br/>
				<div class="form_CTA">
					<aui:button-row>
					<c:if test="${not empty countryList}">
						<input type="button" value="Update Trademark" id="submitUpddateTrademark" class="submit" onclick='javascript:;'/>
					</c:if>
						 <aui:button type="cancel" id='cancel'/>
					</aui:button-row>
				</div>
				</c:if>
			</div>
		</aui:fieldset>
	</aui:form>
</div>
<%@ include file="/html/searchParams.jsp" %>
<script type="text/javascript" src="/LegalAndContract-portlet/js/misc.js" ></script>
<script>
var deletedFiles = [];
var filesCount=0;
var pns = '<portlet:namespace/>';
try{
	initSubmitTrademarkForm(pns,'submitUpddateTrademark','updateTrademarkForm');
}catch(error){
	console.log(error);
}
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
<script>
var ajaxurl = "<%=resourceURL %>";
removeFile('preAttmntsTab');
removeFile('preConfAttmntsTab');
initalizeTmLocalized(pns);
showHideTMLocalized(pns);
trademarkTypeChangeEvnt(pns);
showHideLogoWord(pns);
var hasPerm = ${regionalRole};
/*var classCodeCount = ${classcodesSize};
initClassCodeButton();
initClassCodeRemoveLinks(); */

var classCodeCount = 100;
try{
	var tmprccc = '${classcodesSize}';
	console.log("tmprdlc " + tmprccc);
	try{
		classCodeCount = parseInt(tmprccc);  
	}catch(err){
		
	}
	//var rdlCount = ${rdlsCount};
	initClassCodeButton(pns);
	initClassCodeRemoveLinks();
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
	
	var obj5 = new trademarkFileDrag();
	obj5.Init('logo','filesTable','trademarkLogo',ajaxurl,'fileInput',pns);
}

</script>