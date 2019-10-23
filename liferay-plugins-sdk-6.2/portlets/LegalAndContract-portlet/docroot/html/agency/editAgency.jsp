<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page import="java.util.*"%>
<%@ page import="com.sambaash.platform.srv.legalandcontract.model.Agency" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="unauthorized.agencye.update" message="You are not authorized update this Law Firm" />
<liferay-ui:error key="agency.name.required" message="Agency Name is required" />
<liferay-ui:error key="agency.update.failed" message="Error while updating Agency" />
<liferay-ui:error key="agency.number.required" message="Agency Number is required" />
<liferay-ui:error key="agency.country.required" message="Agency Country is required" />
<liferay-ui:error key="agency.reference.required" message="Agency Reference is required" />
<liferay-ui:error key="agency.address.required" message="Agency Address is required" />
<liferay-ui:error key="agency.remarks.required" message="Agency Remarks is required" />
<liferay-ui:error key="agency.status.required" message="Agency Status is required" />
<liferay-ui:error key="unauthorized.agency.country.update" message="You are not authorized to update Law Firm with selected country" />
<liferay-ui:error key="agency.custom.date1" message="Custom Date 1 is not valid" />
<liferay-ui:error key="agency.custom.date2" message="Custom Date 2 is not valid" />
<liferay-ui:error key="agency.custom.date3" message="Custom Date 3 is not valid" />
<liferay-ui:error key="agency.not.working.copy" message="You are trying to update older version of Law Firm. Newer version of it is availble. Please do update on it." />


<link rel="stylesheet" type="text/css" media="all" href="/LegalAndContract-portlet/css/styles.css" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />


<portlet:actionURL var="updateAgencyActionURL" name="updateAgency">
	<portlet:param name="agencyId" value="${agencyId}" />
</portlet:actionURL>

<portlet:renderURL portletMode="view" var="viewURL" />
<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<div>
	<span class="form_Title">Update Law Firm</span>

	<aui:form name="updateAgency" action="<%=updateAgencyActionURL%>">
		<aui:model-context bean="${agency}" model="<%= Agency.class %>" />
		
		
				
		<aui:fieldset>
			<div class="form_fieldset_wrap">
			<c:if test="${empty countryList}">Presently no countries are available with your roles. Contact Administrator</c:if>
			<c:if test="${not empty countryList}">
				<div class="form_field" style="display:none;">
					<aui:input type="hidden" name="hiddenFileList" id="hiddenFileList" label="Company Registration Number">
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					<aui:input type="text" name="number" id="number" label="Company Registration Number" size="100" disabled="true">
						  <aui:validator name="required" errorMessage="Company Registration Number is required"></aui:validator>
						  <aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
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
			    
			    <div class="form_field">
					<aui:input type="text" name="name" id="name" label="Name" size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					<aui:input type="text" name="reference" id="reference"
						label="Agreement Reference" size="100" >
						<aui:validator name="rangeLength">[1,100]</aui:validator>
						 <%-- <aui:validator name="required" errorMessage="Agency Reference is required"></aui:validator> --%>
					</aui:input>
				</div>
				
				  <div class="form_field">
					<aui:input type="text" name="startDate" id="startDate"
						label="Agreement Start Date" size="100" >
						<aui:validator name="rangeLength">[1,100]</aui:validator>
					</aui:input>
				</div>
			    <div class="form_field">
					<aui:input type="text" name="endDate" id="endDate"
						label="Agreement End Date" size="100" >
						<aui:validator name="rangeLength">[1,100]</aui:validator>
					</aui:input>
				</div>
				
				<div class="form_dropD">
					<aui:select name="classificationType" label="Type">
						<c:forEach var="classifications" items="${classificationTypeList}">
							<aui:option value="${classifications.categoryId}" 
									selected="${typeCatId == classifications.categoryId}"  
								    label="${classifications.name}" />
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_field">
					<aui:input type="textarea" name="address" id="address" label="Address" rows="8" cols="30">
						  <%-- <aui:validator name="required" errorMessage="Agency Address is required"></aui:validator> --%>
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
				    <aui:input type="textarea" name="remarks" id="remarks" label="Remarks" rows="8" cols="30">
						  <%-- <aui:validator name="required" errorMessage="Remarks is required"></aui:validator> --%>
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
				    <aui:input type="text" name="status" id="status" label="Status" size="100">
				    <aui:validator name="rangeLength">[1,100]</aui:validator>
						  <%-- <aui:validator name="required" errorMessage="Agency Status is required"></aui:validator> --%>
				    </aui:input>
			    </div>
		
			    <div class="form_filesTable">
				    <label class="field-label">Files associated with the Law Firm</label>
				    <c:if test="${empty files}">
				    	<br><span style='font-weight:bold'> 0 Files </span>
				    </c:if>
					<table id="filesTable">
				    <c:if test="${not empty files}">
					    	<tr class="filesTable_head">
					    	  <td>File Name</td>
					    	  <td>Version</td>
					    	  <td>Title</td>
						      <td>Description</td>
					    	  <td>Delete </td>
					    	</tr>
						    <c:forEach var="file" items="${files}">
						      <tr id="row${file.fileEntryId}"> <td >
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
							   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="8" cols="30" label=""></aui:input>
							   		</td>
						   		   <td >
						   		      <a id="link${file.fileEntryId}"  href="javascript:;">Delete</a>
						   		   </td>
						        </tr>
						    </c:forEach>
					    </c:if>
					    </table>
			    </div>
			    
			    <div class="forms_fileDrag_wrap">
					    <label class="field-label">File Attachments</label><br>
					    <input type="file" name="<portlet:namespace/>files" id="<portlet:namespace/>files" multiple>
			 			
			 			<div id="filedrag1" class="form_fileDrag">or drop files here</div>
				    
					    <table id="filesTab1" class="form_filesTab">
					    </table>
					    <c:if test="${empty previousfiles}">
				        </c:if>
				        <c:if test="${not empty previousfiles}">
					    	<span class="field-label">Below files uploaded earlier but the transaction was not completed.These files will be included in this transaction.
					    	You can remove unwanted files.  </span>
						    <table id="previousAttachmentsTable" >
						    	<tr class="tableHead">
						    	  <td >File Name</td>
						    	  <td >Title</td>
						    	  <td >Description</td>
						    	  <td >Delete </td>
						    	</tr>
							    <c:forEach var="file" items="${previousfiles}">
							      <tr id="row${file.fileEntryId}"> <td>
							     		  <div style='font-weight:bold'>${file.title}</div>
							   		   </td>
							   		    <td>
							      	      <aui:input name="title_${file.fileEntryId}" id="title_${file.fileEntryId}" type="text" size="100" value="${file.title }" label="">
							      	      <aui:validator name="rangeLength">[1,100]</aui:validator>
							      	      </aui:input>
							   		   </td>
							   		   <td>
							   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="8" cols="30" label=""></aui:input>
							   		   </td>
							   		   <td style='margin-left:20px'>
							   		      <a id="link${file.fileEntryId}"  href="javascript:;">Delete</a>
							   		   </td>
							        </tr>
							    </c:forEach>
						    </table>
				  	  </c:if>
			    
			 	
			 	</div>
			    
			    <div class="form_CTA">
					<aui:button-row>
						<c:if test="${not empty countryList}">
							<aui:button type="submit" name="updateAgency" id="updateAgency"
								value="Update Law Firm" label="" />
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
<script>
var deletedFiles = [];
var filesCount=0;
var pns = '<portlet:namespace/>';
AUI().use('aui-node','aui-base',function(A){
	var fileTable = A.one("#filesTable");
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
var ajaxurl = "<%=resourceURL %>";
var filesCount=0;
removeFile('previousAttachmentsTable');
</script>
<script type="text/javascript" src="/LegalAndContract-portlet/js/filedrag.js" ></script>
<script>
//call initialization file
if (window.File && window.FileList && window.FileReader) {
	var obj1 = new trademarkFileDrag();
	obj1.Init('filedrag1','filesTab1','files',ajaxurl,'draganddrop',pns);
	
	var obj3 = new trademarkFileDrag();
	obj1.Init('filedrag1','filesTab1','files',ajaxurl,'fileInput',pns);
}

</script>