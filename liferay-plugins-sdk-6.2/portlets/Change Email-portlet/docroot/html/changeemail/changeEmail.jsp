<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<liferay-theme:defineObjects/>
<portlet:defineObjects />

<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<%
String userId = request.getParameter("userId");
if(Validator.isNull(userId)) {
	userId = "0";
}
String redirect = themeDisplay.getPathMain()+"/portal/verify_email_address";
String log_email_id=themeDisplay.getUser().getDisplayEmailAddress();
%>
<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<portlet:actionURL var="updateEmailAddressURL" >
<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="updateEmailAddress" />
</portlet:actionURL>

<portlet:renderURL var="changepasswordURL" >
	<portlet:param name="jspPage" value="/html/changepassword/changepassword.jsp" />
	<portlet:param name="userId" value="<%= userId %>" />
</portlet:renderURL>



<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
		<aui:row>
			<aui:col span="12" cssClass="text-center"><h2><span>CHANGE EMAIL & PASSWORD</span></h2></aui:col>
		</aui:row>
		</div>
	</div>
</div>
<div class="formRoot">
<div class="innerFormRoot">
<div class="container">
		<div class="text-center">
			<div class="enrolment-center-align tabs mt-50">
			<aui:col span='10' cssClass="offset1 text-center userAction">
				<div class="tab tab-selected"><button  type="button" class="btn btn-primary" >EMAIL</button></div>
				<div class="tab"><button id="bt_password" type="button"  class="btn btn-default" onclick="callChangePassword()">PASSWORD</button></div>
			</aui:col>
			</div>
		</div>
</div>

<div style="display: none;" class="alert alert-danger" role="showAlert" id="alert_msg">Select Facility Type.</div>
<div id="formio" class="formContainer container null formio-form">
	<aui:form method="post" action="<%=updateEmailAddressURL.toString()%>" name="updatepassword" id="updateEmailAddress">   
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
				<aui:input label="Enter Current Email" cssClass="form-control" type="email" id="currentEmail" name="currentEmail" value="<%= log_email_id %>"  >
			
				</aui:input>
        
			</aui:col>
		</aui:row> 
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
				 <aui:input label="Enter New Email" type="email" cssClass="form-control" id="newEmail" name="newEmail" ></aui:input>
       		
       		</aui:col>
		</aui:row>
	<%-- 	<aui:row>
			<aui:col span="6" cssClass="formio-component-textfield"><aui:input label="Verification Code" type="text" cssClass="form-control" id="ticketKey" name="ticketKey" ></aui:input>
        	</aui:col>
        	<aui:col span="6"><aui:a href="Javascript:void(0);" onclick="sendVerificationCode()" title="Send Verification Code" cssClass="sendVCode">Send Verification Code</aui:a>
    		</aui:col>
		</aui:row> 
		<aui:row>
			<aui:col span="12">
				<label >A Verification Code has been emailed to your new email address. Please Click on active link or copy and pest in below text field.</label>
        	</aui:col>
		</aui:row> --%>
		<aui:row>
			<aui:col span="10" cssClass="offset1 text-center userAction">
				<%-- <aui:col span="5" cssClass="text-right">
					<aui:button type="button" onclick="verify()" label="" value="Save" cssClass="btn-primary"></aui:button>
				</aui:col> --%>
				
				<aui:a href="<%=redirect%>" onclick="sendVerificationCode()"  cssClass="btn btn-primary">Save</aui:a>
				
					<aui:button type="reset"   cssClass="btn-default" value="Clear"></aui:button>
				
			</aui:col>
        	
		</aui:row> 
       
    </aui:form> 

</div>
</div>
</div></div>

<script>
var ajaxUrl = "${resourceURL}";
var namespace =  "<portlet:namespace/>";

function callChangePassword(){
	location.href = "${changepasswordURL}"; 
}

function sendVerificationCode(){
	AUI().use('aui-base','aui-io-request-deprecated',function(A){
		 let _data = {};
	    _data[namespace + 'currentEmail'] = document.getElementById(namespace + "currentEmail").value;
        _data[namespace + 'newEmail'] = document.getElementById(namespace + "newEmail").value;	
      	_data[namespace + 'action'] = "sendVerificationCode";
		A.io.request(ajaxUrl,{
	        dataType : 'json', method : "GET",
	        data : _data,
	        on : {
	            success : function(){
	            	var response = this.get("responseData");
	            	console.log(response);
	            	
	           },
	            failure : function() {
	                thisInstance.debug("Error in the ajax call.");
	            }
	        }
	    }); 
	
	 });
}
</script>





