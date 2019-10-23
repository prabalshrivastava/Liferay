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
<liferay-ui:error key="trademarks.add.error" message='<%= LanguageUtil.get(pageContext,"error.while.adding.trademark")%>' />
<liferay-ui:error key="trademarks.country.required" message='<%= LanguageUtil.get(pageContext,"country.is.required")%>'/>
<liferay-ui:error key="trademarks.class.code.required" message='<%= LanguageUtil.get(pageContext,"class.is.required")%>' />
<liferay-ui:error key="trademarks.status.required" message='<%= LanguageUtil.get(pageContext,"status.is.required")%>' />
<liferay-ui:error key="trademarks.renewal.alert.before.required" message='<%= LanguageUtil.get(pageContext,"renewal.alert.before.is.required")%>' />
<liferay-ui:error key="trademarks.file.upload.error" message='<%= LanguageUtil.get(pageContext,"error.while.uploading.attachments")%>' />
<liferay-ui:error key="trademarks.duplicate" message='<%= LanguageUtil.get(pageContext,"trademark.already.exists.with.the.given.trademark.application.number.and.country")%>' />
<liferay-ui:error key="trademarks.regNum.required" message='<%= LanguageUtil.get(pageContext,"trademark.registration.number.required")%>' />
<liferay-ui:error key="trademarks.trademark.required" message='<%= LanguageUtil.get(pageContext,"trademark.is.required")%>' />
<liferay-ui:error key="trademarks.trademark.localized.required" message='<%= LanguageUtil.get(pageContext,"non.latin.chars.found")%>' />
<liferay-ui:error key="trademarks.applicationNo.required" message='<%= LanguageUtil.get(pageContext,"application.number.is.required")%>' />
<liferay-ui:error key="trademarks.pendingComments.required" message='<%= LanguageUtil.get(pageContext,"action.comments.required")%>' />
<liferay-ui:error key="trademarks.remarks.required" message='<%= LanguageUtil.get(pageContext,"legal.confidential.remarks.required")%>' />
<liferay-ui:error key="trademarks.applicaiton.date" message='<%= LanguageUtil.get(pageContext,"application.date.not.valid")%>' />
<liferay-ui:error key="trademarks.registration.date" message='<%= LanguageUtil.get(pageContext,"registration.date.not.valid")%>' />
<liferay-ui:error key="trademarks.expiry.date" message='<%= LanguageUtil.get(pageContext,"expiry.date.not.valid")%>' />
<liferay-ui:error key="trademarks.priority.date" message='<%= LanguageUtil.get(pageContext,"priority.date.not.valid")%>' />
<liferay-ui:error key="trademarks.custom.date2" message='<%= LanguageUtil.get(pageContext,"custom.date2.not.valid")%>' />
<liferay-ui:error key="trademarks.custom.date3" message='<%= LanguageUtil.get(pageContext,"custom.date3.not.valid")%>' />
<liferay-ui:error key="unauthorized.trademarks.country.add" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.add.trademarks.selected.country")%>' />


<portlet:actionURL var="addTrademarksActionURL" name="addTrademarks">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<link rel="stylesheet" type="text/css" media="all" href="/LegalAndContract-portlet/css/styles.css" />
<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<div>
	<span class="form_Title"><%= LanguageUtil.get(pageContext,"create.trademark")%></span>

	<aui:form name="createTrademark" action="<%=addTrademarksActionURL%>"  method="post">
	    <c:if test="${empty countryList}"><%= LanguageUtil.get(pageContext,"no.countries.available.for.role")%></c:if>
	     
		<aui:fieldset>
		<div class="form_fieldset_wrap">
	     <c:if test="${not empty countryList}">
				<div class="form_field">
					<aui:input type="text" name="applicationNo" id="applicationNo" label='<%= LanguageUtil.get(pageContext,"application.number")%>' size="100">
						  <aui:validator name="required" errorMessage='<%= LanguageUtil.get(pageContext,"application.number.is.required")%>'></aui:validator>
						  <aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    <div class="form_field">
					<aui:input type="text" name="registrationNumber" id="registrationNumber" label='<%= LanguageUtil.get(pageContext,"registration.number")%>' size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    
			     <div class="form_field">
					    <aui:input type="text" name="customField2" id="customField2" label='<%= LanguageUtil.get(pageContext,"international.registration.number")%>' size="100">
					    <aui:validator name="rangeLength">[1,100]</aui:validator>
					    </aui:input>
				    </div>
				    
			    <div class="form_dropD">
					    <aui:select name="customList1" label='<%= LanguageUtil.get(pageContext,"registered.owner")%>'>
							<c:forEach var="listEntry" items="${customList1}">
								<aui:option value="${listEntry.categoryId}"
									label="${listEntry.name}" />
							</c:forEach>
						</aui:select>
				</div>
				    
				<div class="form_dropD">
					<aui:select name="status" label='<%= LanguageUtil.get(pageContext,"status")%>'>
						<c:forEach var="catg" items="${status}">
							<aui:option value="${catg.categoryId}"
								label="${catg.name}" selected="${catg.name == 'Filed'}"/>
						</c:forEach>
					</aui:select>
				</div>
				    
			    <div class="form_dropD">
					<aui:select name="countryList" label='<%= LanguageUtil.get(pageContext,"country")%>' showEmptyOption="true">
						<c:forEach var="countries" items="${countryList}">
							<aui:option value="${countries.categoryId}"
								label="${countries.name}" />
						</c:forEach>
					</aui:select>
				</div>
			<!-- 	<div class="form_dropD">
					<aui:select name="classCode" label="Class Code">
						<c:forEach var="cc" items="${classCode}">
							<aui:option value="${cc.categoryId}" label="${cc.name}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="form_textA">
					<aui:input type="textarea" name="classDescription" id="classDescription" label="Class Specifications" rows="5" cols="30" >
						  <aui:validator name="required" errorMessage="Class Specifications is required"></aui:validator>
				    </aui:input>
				</div>     -->
				<div class="form_customList_wrap">
				<div class="form_dropD">
					<aui:select name="trademarkType" label='<%= LanguageUtil.get(pageContext,"trademark.type")%>'>
							<aui:option value="word" 			
								label='<%= LanguageUtil.get(pageContext,"word")%>' />
							<aui:option value="logo" 			
								label='<%= LanguageUtil.get(pageContext,"logo")%>' />
					</aui:select>
				</div>
			    <div id='wordDiv' class="form_field">
					<aui:input type="text" name="trademark" id="trademark" label='<%= LanguageUtil.get(pageContext,"trademark")%>' size="100">
					<aui:validator name="custom"
				                     errorMessage='<%= LanguageUtil.get(pageContext,"please.enter.trademark")%>'>
									function (val, fieldNode, ruleValue) {
										return validateTM(val, '<portlet:namespace/>');
									}
							</aui:validator>
				    </aui:input>
				    <span id="tmlocalized" style="display:none">
						<aui:input type="text" name="trademarkLocalized" id="trademarkLocalized" label='<%= LanguageUtil.get(pageContext,"trademark.latin")%>' size="100" >*
							<aui:validator name="custom"
				                     errorMessage='<%= LanguageUtil.get(pageContext,"enter.trademark.less.than.100.char")%>'>
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
				                     errorMessage='<%= LanguageUtil.get(pageContext,"please.enter.logo")%>'>
				                     function (val, fieldNode, ruleValue) {
										return validateLogo('<portlet:namespace/>');
									}
							</aui:validator>
				    </aui:input>
				    <br>
				    <div id="logo" class="logo"></div>
				    <table id="filesTable" class="form_filesTab">
				    </table>
			    </div>
			    </div>
				<div class="form_calendar">
					<label class="aui-field-label"><%= LanguageUtil.get(pageContext,"application.date")%>: </label>
					<liferay-ui:input-date
						dayValue="${applicationDate.date }" name="applicationDate"
						dayParam="applicationDateDay" disabled="false"
						monthParam="applicationDateMonth"
						monthValue="${applicationDate.month }"
						yearParam="applicationDateYear"
						yearValue="${applicationDate.year }" nullable="${applicationDate.nullable }"
						/>
				</div>
				<div class="form_calendar">	
					<label class="field-label"><%= LanguageUtil.get(pageContext,"registration.date")%>: </label>
					<liferay-ui:input-date
							dayValue="${firstRegDate.date }" name="firstRegDate"
							dayParam="firstRegDateDay"	disabled="false"
							monthParam="firstRegDateMonth"
							monthValue="${firstRegDate.month }"
							yearParam="firstRegDateYear"
							yearValue="${firstRegDate.year }" nullable="${firstRegDate.nullable }"
							/>
				</div>
				<div class="form_calendar">
					<label class="field-label"><%= LanguageUtil.get(pageContext,"priority.date")%></label>
					<liferay-ui:input-date
						dayValue="${customDate1.date }" name="customDate1"
						dayParam="customDay1" disabled="false"
						monthParam="customMonth1"
						monthValue="${customDate1.month }"
						yearParam="customYear1"
						yearValue="${customDate1.year }" nullable="${customDate1.nullable }"
						/>
				 </div>
				 <div class="form_calendar"> 
					<label class="field-label"><%= LanguageUtil.get(pageContext,"expiry.date")%>: </label>
					<liferay-ui:input-date
						dayValue="${renewalDate.date }" name="renewalDate"
						dayParam="renewalDateDay" disabled="false"
						monthParam="renewalDateMonth"
						monthValue="${renewalDate.month }"
						yearParam="renewalDateYear"
						yearValue="${renewalDate.year }" nullable="${renewalDate.nullable }"
						/>
				</div>
			    
				
				<div class="form_dropD" style="vertical-align:bottom;">
					<aui:select name="renewalAlertBefore" label='<%= LanguageUtil.get(pageContext,"renewal.alert.before")%>'>
						<c:forEach var="catg" items="${renewalAlertBefore}">
							<aui:option value="${catg.categoryId}"
								label="${catg.name}" selected="${catg.name == '60' }"/>
						</c:forEach>
					</aui:select>
				</div>
				
				 <div class="form_dropD">
				    <aui:select name="agencyIddd" label='<%= LanguageUtil.get(pageContext,"law.firm")%>' showEmptyOption="true">
						<c:forEach var="agency" items="${agencies}">
							<aui:option value="${agency.key}"
								label="${agency.value}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="form_group">
					<aui:button type="button" id="addClassCode" value='<%= LanguageUtil.get(pageContext,"add.classcode")%>'/>
					<br/>
					<div class="dynaClassCodeContainer">
						<div id='sampleClassCodeContainer' style='display:none'>
							<aui:select name="cCode" label='<%= LanguageUtil.get(pageContext,"class.code")%>'>
								<c:forEach var="attr" items="${classCode}">
	            					<aui:option value="${attr.categoryId}">${attr.name}</aui:option>
	        					</c:forEach>  
							</aui:select>
							<aui:input name="cSpec" type="textarea" rows="5" cols="30" label='<%= LanguageUtil.get(pageContext,"class.specification")%>'></aui:input>
							<a id="classCoderemove"  href="javascript:;" style='font-size:10pt'><%= LanguageUtil.get(pageContext,"remove")%></a>
						</div>
					</div>
					<c:forEach var="ccObj" items="${classcodes}">
							<div id='ccData${ccObj.counter}'>
								<aui:select name="cCode${ccObj.counter }" label='<%= LanguageUtil.get(pageContext,"class.code")%>'>
									<c:forEach var="attr" items="${classCode}">
		            					<aui:option value="${attr.categoryId}" selected="${attr.name == ccObj.cCode}">${attr.name}</aui:option>
		        					</c:forEach>  
								</aui:select>
								<aui:input name="cSpec${ccObj.counter }" type="textarea" rows="5" cols="30" label='<%= LanguageUtil.get(pageContext,"class.specification")%>' value='${ccObj.cSpec }'></aui:input>
								<a id="classCoderemove${ccObj.counter }"  href="javascript:;" style='font-size:10pt'><%= LanguageUtil.get(pageContext,"remove")%></a>
							</div>
						</c:forEach>
				</div>
			    <div class="form_customList_wrap">
			    <div class="form_field">
					<aui:input type="textarea" name="pendingComments" id="pendingComments" label='<%= LanguageUtil.get(pageContext,"remarks")%>'  rows="5" cols="30" >
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					    <aui:input type="textarea" name="customField1" id="customField1" label='<%= LanguageUtil.get(pageContext,"active.ingredients")%>' rows="5" cols="60">
					    </aui:input>
				</div>
				   
				<div class="form_field">
					    <aui:input type="textarea" rows="5" cols="30" name="customField3" id="customField3" label='<%= LanguageUtil.get(pageContext,"history")%>' >
					    </aui:input>
				</div>
				</div>
			   
				
				<div class="forms_fileDrag_wrap">
					
					<label class="field-label"><%= LanguageUtil.get(pageContext,"file.attachments")%>: </label>
				    <input type="file" name="<portlet:namespace/>attachments" id="<portlet:namespace/>attachments" multiple><br>
				   
				    <div id="filedrag1" class="form_fileDrag"><%= LanguageUtil.get(pageContext,"drop.files.here")%></div>
				   
				    <table id="filesTab1" class="form_filesTab">
				    </table>
					
					<c:if test="${empty attachments}">
				    </c:if>
				    <c:if test="${not empty attachments}">
				    	<div class="form_filesTable">
				    		<span><%= LanguageUtil.get(pageContext,"uploaded.earlier.but.transaction.not.complete")%> </span>
						    <table id="preConfAttmntsTab">
						    	<tr class="filesTable_head">
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"file.name")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"title")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"description")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"delete")%> </td>
						    	</tr>
							    <c:forEach var="file" items="${attachments}">
							      <tr id="row${file.fileEntryId}"> <td style='margin-left:20px'>
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
							   		   <td style='margin-left:20px'>
							   		      <a id="link${file.fileEntryId}"  href="javascript:;"><%= LanguageUtil.get(pageContext,"remove")%></a>
							   		   </td>
							        </tr>
							    </c:forEach>
						    </table>
				    	</div>
				    </c:if>
					
				</div>
				
				
				
			     <c:if test="${regionalRole}">
				
				<div class="form_field">
					<aui:input type="textarea" name="legalConfRemarks" id="legalConfRemarks" label='<%= LanguageUtil.get(pageContext,"legal.confidential.remarks")%>' rows="5" cols="50">
				    </aui:input>
			    </div>
				
				<div class="forms_fileDrag_wrap">
				
				
					<label class="field-label"><%= LanguageUtil.get(pageContext,"confidential.file.attachments")%>: </label>
				    <input type="file" name="<portlet:namespace/>confAttachments" id="<portlet:namespace/>confAttachments" multiple>
				    
				    <div id="filedrag2" class="form_fileDrag"><%= LanguageUtil.get(pageContext,"drop.files.here")%></div>
				    
				    <table id="filesTab2" class="form_filesTab">
				    </table>
					
					<c:if test="${empty confAttachments}">
				    </c:if>
				    <c:if test="${not empty confAttachments}">
				    	<div class="form_filesTable">
				    		<span><%= LanguageUtil.get(pageContext,"uploaded.earlier.but.transaction.not.complete")%></span>
						    <table id="preAttmntsTab">
						    	<tr class="filesTable_head">
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"file.name")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"title")%> </td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"description")%> </td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"delete")%> </td>
						    	</tr>
							    <c:forEach var="file" items="${confAttachments}">
							      <tr id="row${file.fileEntryId}"> <td style='margin-left:20px'>
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
							   		   <td style='margin-left:20px'>
							   		      <a id="link${file.fileEntryId}"  href="javascript:;"><%= LanguageUtil.get(pageContext,"remove")%></a>
							   		   </td>
							        </tr>
							    </c:forEach>
						    </table>
				    	</div>
				    </c:if>
				</div>
				</c:if>
				
				<br/>
				<div class="form_CTA">
					<aui:button-row>
							<input type="button" value="<%= LanguageUtil.get(pageContext,"add.trademark")%>" id="submitAddTrademark" class="submit" onclick='javascript:;'/>
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
var trdNs = "<portlet:namespace/>";
var ajaxurl = "<%=resourceURL %>";
var filesCount=0;
try{
	initSubmitTrademarkForm(trdNs,'submitAddTrademark','createTrademark');
}catch(error){
	console.log(error);
}
initalizeTmLocalized(trdNs);
showHideTMLocalized(trdNs);
removeFile('preAttmntsTab');
removeFile('preConfAttmntsTab');
trademarkTypeChangeEvnt(trdNs);
showHideLogoWord(trdNs);
var hasPerm = ${regionalRole};
/*var classCodeCount = 0;
initClassCodeButton();
*/

var classCodeCount = 1000;
try{
	var tmprccc = '${classcodesSize}';
	console.log("tmprdlc " + tmprccc);
	try{
		if(!isNaN(parseInt(tmprccc)))
			classCodeCount = parseInt(tmprccc);
		else 
			classCodeCount  = 1000;
	}catch(err){

	}
	//var rdlCount = ${rdlsCount};
	initClassCodeButton(trdNs);
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
	obj1.Init('filedrag1','filesTab1','attachments',ajaxurl,'draganddrop',trdNs);
	obj1.Init('filedrag1','filesTab1','attachments',ajaxurl,'fileInput',trdNs);
	if(hasPerm == true){
		var obj2 = new trademarkFileDrag();
		obj2.Init('filedrag2','filesTab2','confAttachments',ajaxurl,'draganddrop',trdNs);
		obj2.Init('filedrag2','filesTab2','confAttachments',ajaxurl,'fileInput',trdNs);
	}
	var obj5 = new trademarkFileDrag();
	obj5.Init('logo','filesTable','trademarkLogo',ajaxurl,'fileInput',trdNs);
}

</script>
