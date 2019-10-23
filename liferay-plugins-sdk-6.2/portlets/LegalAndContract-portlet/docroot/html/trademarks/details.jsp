<%@page import="com.sambaash.platform.portlet.legalandcontract.util.Utils"%>
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

<portlet:actionURL var="agencyDetailURL" name="displayAgencyDetails">
 <portlet:param name="agencyId" value="${trademark.agencyId}"></portlet:param>
</portlet:actionURL>

<c:if test="${not empty statusMsg }">
		<script type="text/javascript">
			alert('${statusMsg }');
			document.location.href = '<%=Utils.getAddLitigationFriendlyUrl((Long)request.getAttribute("rootTMId"))%>';
		</script>
</c:if>
<div class="form_details form_details_desktop">
	<span class="form_Title">Trademarks Details</span>
	<div class="form_field_logo" >
				 	<c:if test="${trademark.trademarkType == 'logo'}">
				 	  <img alt="no logo available" src="${logoUrl }">
				 	</c:if>
				 	<c:if test="${trademark.trademarkType != 'logo'}">
				 	  <c:out value="${trademark.trademark }"></c:out>
				 	</c:if>
				 	
	</div><br>
	<table>
	  <tr><td>Application Number</td><td><c:out value="${trademark.applicationNo }"></c:out></td></tr>
	  <tr><td>Application Date</td><td><c:out value="${trademark.applicationDate }"></c:out></td></tr>
	  <c:if test="${trademark.trademarkType == 'logo'}">
	  	<tr><td>Logo Title</td><td><c:out value="${trademark.trademark}"></c:out></td></tr>
	  </c:if>
	  <c:if test="${not empty trademark.trademarkLocalized }">
	   <tr><td>Trademark (Latin)</td><td><c:out value="${trademark.trademarkLocalized }"></c:out></td></tr>
	  </c:if>
	  <tr><td>Country</td><td><c:out value="${trademark.country }"></c:out></td></tr>
	  <tr><td>Status</td><td><c:out value="${trademark.status }"></c:out></td></tr>
	  <tr><td>Registration Number</td><td><c:out value="${trademark.registrationNumber }"></c:out></td></tr>
	  <tr><td>Registration Date</td><td><c:out value="${trademark.firstRegDate }"></c:out></td></tr>
	  <tr><td>Expiry Date</td><td><c:out value="${trademark.renewalDate }"></c:out></td></tr>
	  <tr><td>International Registration Number</td><td><c:out value="${trademark.customField2 }"></c:out></td></tr>
	  <tr><td>Priority Date</td><td><c:out value="${trademark.customDate1 }"></c:out></td></tr>
	</table>
	<table> 
	  <tr><td>Registered Owner</td><td><c:out value="${trademark.registeredOwner }"></c:out></td></tr>
	  <tr><td>Active Ingredients</td><td><c:out value="${trademark.customField1 }" escapeXml="false"></c:out></td></tr>
	  <tr><td>Contentious Proceedings</td><td>
	  <c:forEach var="litigation" items="${contentiousProceedings }">
	  	<a href="${litigation.DetailsLink }">${litigation.customField2}</a><br>
	  </c:forEach></td></tr>
	  <tr><td>Renewal Alert Before</td><td><c:out value="${trademark.renewalAlertBefore }"></c:out></td></tr>
	  <tr><td>Law Firm</td><td><a href="${trademark.agencyDetailsLink }"><c:out value="${trademark.agency }"></c:out></a></td></tr>
	  <tr><td>Version</td><td><c:out value="${trademark.version }"></c:out></td></tr>
	  <tr><td>Update By</td><td><c:out value="${trademark.userName }"></c:out></td></tr>
	  <tr><td>Last Updated</td><td><c:out value="${trademark.modifiedDate }"></c:out></td></tr>
	  
	
	</table>
	
	<c:forEach var="ccObj" items="${classcodes}">
		<div class="classDescription">
		<div class="classDescriptionLabel">
			Class Code : ${ccObj.cCode}
		</div>
		<div class="classDescriptionContent">
			<c:out value="${ccObj.cSpec }" escapeXml="false"></c:out>
		</div>
	</div>
	</c:forEach>
	
    <div class="classDescription">
		<div class="classDescriptionLabel">
			History
		</div>
		<div class="classDescriptionContent">
			<c:out value="${trademark.customField3 }" escapeXml="false"></c:out>
		</div>
	
	</div>
    <div class="classDescription">
		<div class="classDescriptionLabel">
			Remarks
		</div>
		<div class="classDescriptionContent">
			<c:out value="${trademark.pendingComments }" escapeXml="false"></c:out>
		</div>
	
	</div>
    <c:if test="${regionalRole }">
		<div class="classDescription">
			<div class="classDescriptionLabel">
			  Legal Confidential Remarks
			</div>
			<div class="classDescriptionContent">
				<c:out value="${trademark.legalConfRemarks }" escapeXml="false"></c:out>
			</div>
		
		</div>
	  </c:if>
	
</div>
<div class="form_details form_details_mobile">
<span class="form_Title">Trademarks Details</span>
	<div class="form_field_logo" >
				 	<c:if test="${trademark.trademarkType == 'logo'}">
				 	  <img alt="no logo available" src="${logoUrl }">
				 	</c:if>
				 	<c:if test="${trademark.trademarkType != 'logo'}">
				 	  <c:out value="${trademark.trademark }"></c:out>
				 	</c:if>
				 	
	</div><br>
	<table>
	  <tr><td>Application Number</td><td><c:out value="${trademark.applicationNo }"></c:out></td></tr>
	  <tr><td>Application Date</td><td><c:out value="${trademark.applicationDate }"></c:out></td></tr>
	  <c:if test="${trademark.trademarkType == 'logo'}">
	  	<tr><td>Logo Title</td><td><c:out value="${trademark.trademark}"></c:out></td></tr>
	  </c:if>
	  <c:if test="${not empty trademark.trademarkLocalized }">
	   <tr><td>Trademark (Latin)</td><td><c:out value="${trademark.trademarkLocalized }"></c:out></td></tr>
	  </c:if>
	  <tr><td>Country</td><td><c:out value="${trademark.country }"></c:out></td></tr>
	  <tr><td>Status</td><td><c:out value="${trademark.status }"></c:out></td></tr>
	  <tr><td>Registration Number</td><td><c:out value="${trademark.registrationNumber }"></c:out></td></tr>
	  <tr><td>Registration Date</td><td><c:out value="${trademark.firstRegDate }"></c:out></td></tr>
	  <tr><td>Expiry Date</td><td><c:out value="${trademark.renewalDate }"></c:out></td></tr>
	  <tr><td>International Registration Number</td><td><c:out value="${trademark.customField2 }"></c:out></td></tr>
	  <tr><td>Priority Date</td><td><c:out value="${trademark.customDate1 }"></c:out></td></tr>
	  <tr><td>Registered Owner</td><td><c:out value="${trademark.registeredOwner }"></c:out></td></tr>
	  <tr><td>Active Ingredients</td><td><c:out value="${trademark.customField1 }" escapeXml="false"></c:out></td></tr>
	  <tr><td>Contentious Proceedings</td><td>
	  <c:forEach var="litigation" items="${contentiousProceedings }">
	  	<a href="${litigation.DetailsLink }">${litigation.customField2}</a><br>
	  </c:forEach></td></tr>
	  <tr><td>Renewal Alert Before</td><td><c:out value="${trademark.renewalAlertBefore }"></c:out></td></tr>
	  <tr><td>Law Firm</td><td><a href="${trademark.agencyDetailsLink }"><c:out value="${trademark.agency }"></c:out></a></td></tr>
	  <tr><td>Version</td><td><c:out value="${trademark.version }"></c:out></td></tr>
	  <tr><td>Update By</td><td><c:out value="${trademark.userName }"></c:out></td></tr>
	  <tr><td>Last Updated</td><td><c:out value="${trademark.modifiedDate }"></c:out></td></tr>
	  
	  
	</table>
	
	<c:forEach var="ccObj" items="${classcodes}">
		<div class="classDescription">
		<div class="classDescriptionLabel">
			Class Code : ${ccObj.cCode}
		</div>
		<div class="classDescriptionContent">
			<c:out value="${ccObj.cSpec }" escapeXml="false"></c:out>
		</div>
	</div>
	</c:forEach>
	
    <div class="classDescription">
		<div class="classDescriptionLabel">
			History
		</div>
		<div class="classDescriptionContent">
			<c:out value="${trademark.customField3 }" escapeXml="false"></c:out>
		</div>
	
	</div>
    <div class="classDescription">
		<div class="classDescriptionLabel">
			Remarks
		</div>
		<div class="classDescriptionContent">
			<c:out value="${trademark.pendingComments }" escapeXml="false"></c:out>
		</div>
	
	</div>
    <c:if test="${regionalRole }">
		<div class="classDescription">
			<div class="classDescriptionLabel">
			  Legal Confidential Remarks
			</div>
			<div class="classDescriptionContent">
				<c:out value="${trademark.legalConfRemarks }" escapeXml="false"></c:out>
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
				     		  <div style='font-weight:bold'><c:out value="${file.title}" ></c:out> </div>
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
var trademarksId = "${trademarksId}";



initializeExport(portletNs,ajaxUrl);
function initializeExport(portletNs,ajaxUrl){
	
	var func = function(event){
		AUI().use('aui-node','aui-base', 'aui-io-request-deprecated', function (A){
			var exptype = '';
			if(event.target.get('id') == portletNs + "export")
				exptype = 'exportDetailsPdf';
			else 
				exptype = 'exportDetailsXls';
			
			A.io.request(ajaxUrl,{
				dataType : 'json',
				method : 'POST',
				data : {
					action: exptype,
					trademarksId : trademarksId
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