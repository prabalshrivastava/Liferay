<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<liferay-theme:defineObjects/>



<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1729");
Long groupId = themeDisplay.getLayout().getGroupId();
String baseCurrency = SambaashUtil.getParameter("base_currency", groupId);
String dashBoardLink = SambaashUtil.getDashBoard();
%>

<div class="newPortlets">	

<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>CURRENCY EXCHANGE SETUP</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
			</aui:row>
		</div>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer"  modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="0"  />
		</div>
	</div>
</div>

<script type="text/javascript">
var mode = "create";
var baseCurrency = "<%= baseCurrency %>";
function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.components["BaseCurrency"].setValue(baseCurrency);
	thisInstance.components.Deactivate.buttonElement.style.display = "none";
}
function validateFormIOForm(thisInstance){
	var formdata = thisInstance.form.submission.data;
	var today = new Date();
	var effectiveDate = formdata.EffectiveDate;
	var effectiveDateEncoded = new Date(effectiveDate);
	var currencyCode = formdata.CurrencyCode;
	var status = thisInstance.form.submission.data.Status;
	if(effectiveDateEncoded.getTime()  < today.getTime() && thisInstance.components['Status'].value == "active"){
		thisInstance.form.setAlert("","Effective Date < Current Date only if the Currency code is not being used");
	}else{
		var data1 = {"limit":4,"modelName":modelName,"page":0,"formType":modelName};
	 	data1.conditions = ["contentJson.CurrencyCode="+currencyCode,"contentJson.EffectiveDate="+ effectiveDate,"contentJson.Status="+ status];
	 	data1.sortBy = "contentJson.CurrencyCode";
	 	
		ajaxCallAPI('GET','searchList',data1,
			 function() {
					
	               var response = this.get("responseData");
	               
	               if (_.isEmpty(response)) {
	                   console.log("error");
	                   
	               } else {
	               	if(response.numberOfElements > 1){
	               		thisInstance.form.setAlert("","Duplicate Record");
	               	}else if(response.numberOfElements == 1){
	               		
	               		thisInstance.form.setAlert("","Duplicate Record");
	               	}
					else{
	               		thisInstance.customSubmission(thisInstance.form.submission);
	               	}
	               }
	           },
	           function() {
	               
	    		});
	}
}
</script>
<% } %>