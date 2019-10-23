<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<div class="form_details form_details_desktop">
	<span class="form_Title">Contentious Proceedings Details</span>
	<table class='agencyDetailTable'>
	  <tr><td>Trademark Application Number / Country</td><td><c:out value="${litigation.trademark }"></c:out></td></tr>
	  <tr><td>Trademark</td><td><a href="<c:out value="${trademarkUrl}"></c:out>"><c:out escapeXml="false" value="${trademarkText}"></c:out></a></td></tr>
	  <tr><td>Proceedings</td><td><c:out value="${litigation.proceedingType }"></c:out></td></tr>
	  <tr><td>Status</td><td><c:out value="${litigation.status }"></c:out></td></tr>
	  <tr><td>Filed By</td><td><c:out value="${litigation.filedBy }"></c:out></td></tr>
	  <tr><td>Third Party Trademark Number</td><td><c:out value="${litigation.customField2 }"></c:out></td></tr>

	  <tr><td>Filed On</td><td><c:out value="${litigation.filedOn }"></c:out></td></tr>
	  <tr><td>Law Firm</td><td><c:out value="${litigation.customField1 }"></c:out></td></tr>
<!-- 
	  <tr><td>Response Deadline</td><td><c:out value="${litigation.responseDeadline }"></c:out></td></tr>
	  <tr><td>Alert Before</td><td><c:out value="${litigation.alertBefore }"></c:out></td></tr>
 -->
	  <tr><td>Version</td><td><c:out value="${litigation.version }"></c:out></td></tr>
	  <tr><td>Update By</td><td><c:out value="${litigation.userName }"></c:out></td></tr>
	  <tr><td>Last Updated</td><td><c:out value="${litigation.modifiedDate }"></c:out></td></tr>
	  <tr><td>Internal Reference Number</td><td><c:out value="${litigation.litigationId }"></c:out></td></tr>
	</table>
</div>
<div class="left20">
	<c:forEach var="rdl" items="${rdls}">
			<div class="classDescription">
				<table class="description_1">
					<tr>
						<td>
							<div class="classDescriptionLabel">Response Deadline :</div>
							<div class="classDescriptionContent">
								<c:out value="${rdl.responseDeadline }"></c:out>
								<c:if test="${empty rdl.responseDeadline }">
								  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
							</div>
						</td>
						
						<td>
							<div class="classDescriptionLabel">Alert Before :</div>
							<div class="classDescriptionContent">
								<c:out value="${rdl.alertBefore}"></c:out>
								<c:if test="${empty rdl.alertBefore }">
								  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
							</div>
						</td>
						
					</tr>
				</table>
			</div>
			<div class="classDescription">
				<div class="classDescriptionLabel">Remarks</div>
				<div class="classDescriptionContent">
					<c:out value="${rdl.claimsRemarks }" escapeXml="false"></c:out>
				</div>
	
			</div>
		</c:forEach>
	</div>
	<c:if test="${regionalRole }">
	 <div class="classDescription left20">
			<div class="classDescriptionLabel">
				Legal Confidential Remarks
			</div>
			<div class="classDescriptionContent">
				<c:out value="${litigation.legalConfRemarks }" escapeXml="false"></c:out>
			</div>
		
		</div>
	 </c:if>
<div class="form_details form_details_mobile">
	<span class="form_Title">Contentious Proceedings Details</span>
	<table>
	  <tr><td>Trademark Application Number / Country</td><td><c:out value="${litigation.trademark }"></c:out></td></tr>
	  <tr><td>Trademark</td><td><a href="<c:out value="${trademarkUrl}"></c:out>"><c:out escapeXml="false" value="${trademarkText}"></c:out></a></td></tr>
	  <tr><td>Proceedings</td><td><c:out value="${litigation.proceedingType }"></c:out></td></tr>
	  <tr><td>Status</td><td><c:out value="${litigation.status }"></c:out></td></tr>
	  <tr><td>Filed By</td><td><c:out value="${litigation.filedBy }"></c:out></td></tr>
	  <tr><td>Third Party Trademark Number</td><td><c:out value="${litigation.customField2 }"></c:out></td></tr>

	  <tr><td>Filed On</td><td><c:out value="${litigation.filedOn }"></c:out></td></tr>
	  <tr><td>Law Firm</td><td><c:out value="${litigation.customField1 }"></c:out></td></tr>
<!-- 
	  <tr><td>Response Deadline</td><td><c:out value="${litigation.responseDeadline }"></c:out></td></tr>
	  <tr><td>Alert Before</td><td><c:out value="${litigation.alertBefore }"></c:out></td></tr>
 -->
	  <tr><td>Version</td><td><c:out value="${litigation.version }"></c:out></td></tr>
	  <tr><td>Update By</td><td><c:out value="${litigation.userName }"></c:out></td></tr>
	  <tr><td>Last Updated</td><td><c:out value="${litigation.modifiedDate }"></c:out></td></tr>
	  <tr><td>Internal Reference Number</td><td><c:out value="${litigation.litigationId }"></c:out></td></tr>
	</table>
	<div class="left20">
	<c:forEach var="rdl" items="${rdls}">
			<div class="classDescription">
				<table class="description_1">
					<tr>
						<td>
							<div class="classDescriptionLabel">Response Deadline :</div>
							<div class="classDescriptionContent">
								<c:out value="${rdl.responseDeadline }"></c:out>
								<c:if test="${empty rdl.responseDeadline }">
								  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
							</div>
						</td>
						
						<td>
							<div class="classDescriptionLabel">Alert Before :</div>
							<div class="classDescriptionContent">
								<c:out value="${rdl.alertBefore}"></c:out>
								<c:if test="${empty rdl.alertBefore }">
								  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
							</div>
						</td>
						
					</tr>
				</table>
			</div>
			<div class="classDescription">
				<div class="classDescriptionLabel">Remarks</div>
				<div class="classDescriptionContent">
					<c:out value="${rdl.claimsRemarks }" escapeXml="false"></c:out>
				</div>
	
			</div>
		</c:forEach>
	</div>
	<c:if test="${regionalRole }">
	 <div class="classDescription left20">
			<div class="classDescriptionLabel">
				Legal Confidential Remarks
			</div>
			<div class="classDescriptionContent">
				<c:out value="${litigation.legalConfRemarks }" escapeXml="false"></c:out>
			</div>
		
		</div>
	 </c:if>
</div>
<div class="form_filesTable form_filesTable_details ">
			<label class="field-label">File Attachments</label>
		    <c:if test="${empty attachments}">
		    	<br><span style='font-weight:bold'> 0 Files </span>
		    </c:if>
		    <c:if test="${not empty attachments}">
			    <table id="filesTable">
			    	<tr class="filesTable_head">
			    	  <td >File Name</td>
			    	  <td >Version</td>
			    	  <td >Description</td>
			    	  <c:if test="${canDownloadFile }">
			    	  	<td >Download</td>
			    	  	</c:if>
			    	</tr>
				    <c:forEach var="file" items="${attachments}">
				      <tr id="row${file.fileEntryId}"> 
				      		<td >
				     		  <div style='font-weight:bold'><c:out value="${file.title}"></c:out> </div>
				   		   </td>
				   		   <td>
				   		     <c:out value="${file.version }"></c:out> 
				   		   </td>
				   		  <td>
				   		      <c:out value=" ${file.description }" escapeXml="false"></c:out>
				   		   </td>
				   		   <c:if test="${canDownloadFile }">
				   		     <td>
				   		     <a href="/FileSharing-portlet/download?fileEntryId=${file.fileEntryId}">Download</a>
				   		   </td>
				   		   </c:if>
				        </tr>
				    </c:forEach>
			    </table>
		    </c:if>
</div>	
<c:if test="${regionalRole }">

<div class="form_filesTable form_filesTable_details ">	    
			<label class="field-label">Confidential File Attachments</label>
		    <c:if test="${empty confAttachments}">
		    	<br><span style='font-weight:bold'> 0 Files </span>
		    </c:if>
		    <c:if test="${not empty confAttachments}">
			    <table id="filesTable">
			    	<tr class="filesTable_head">
			    	  <td >File Name</td>
			    	  <td >Version</td>
			    	  <td >Description</td>
			    	  <c:if test="${canDownloadFile }">
			    	  	<td >Download</td>
			    	  	</c:if>
			    	</tr>
				    <c:forEach var="file" items="${confAttachments}">
				      <tr id="row${file.fileEntryId}"> 
				      		<td >
				     		  <div style='font-weight:bold'><c:out value="${file.title}"></c:out> </div>
				   		   </td>
				   		   <td>
				   		     <c:out value="${file.version }"></c:out> 
				   		   </td>
				   		  <td>
				   		      <c:out value=" ${file.description }" escapeXml="false"></c:out>
				   		   </td>
				   		   <c:if test="${canDownloadFile }">
				   		    <td>
				   		     <a href="/FileSharing-portlet/download?fileEntryId=${file.fileEntryId}">Download</a>
				   		   </td>
				   		   </c:if>
				        </tr>
				    </c:forEach>
			    </table>
		    </c:if>
</div>
</c:if>

<aui:button type="cancel" id='cancel'/>
<aui:button type="button" name="export" id="export"
								value="Export PDF" label="" />
<aui:button type="button" name="exportXls" id="exportXls"
								value="Export XLS" label="" />
<%@ include file="/html/searchParams.jsp" %>								
<script>
var portletNs = "<portlet:namespace/>";
var ajaxUrl = "<%=resourceURL%>";
var litigationId = "${litigationId}";

initializeExport(portletNs,ajaxUrl);
function initializeExport(portletNs,ajaxUrl){
	
	var func = function(){
		AUI().use('aui-node','aui-base', 'aui-io-request-deprecated', function (A){
			var exptype = '';
			if(event.target.id == portletNs + "export")
				exptype = 'exportDetailsPdf';
			else 
				exptype = 'exportDetailsXls';
			
			A.io.request(ajaxUrl,{
				dataType : 'json',
				method : 'POST',
				data : {
					action: exptype,
					litigationId : litigationId
				},
				on : {
					success : function() {
						//var data = this.get('responseData');
						//var result = data.result;
						var data = this.get('responseData');
						if(data && data.errorMsg){
							alert(data.errorMsg);
						}else{
							document.location.href = "/LegalAndContract-portlet/download?fileName=" + data.fileName ;
						}
					},
					failure : function(){
						var data = this.get('responseData');
						if(data && data.errorMsg){
							alert(data.errorMsg);
						}else{
							alert("Error while generating the report");
						}
					}
				}
			});
			
		});
	};
	
	AUI().use('aui-node','aui-base',function(A){
		var buttonId = "#" + portletNs + "export";
		var buttonXlsId = "#" + portletNs + "exportXls";
		
		var exportObj = A.one(buttonId);
		var exportXlsObj = A.one(buttonXlsId);
		
		if(exportObj){
			exportObj.on("click", func);
		}
		if(exportXlsObj){
			exportXlsObj.on("click", func);
		}
		
	});
	
	
}

</script>
