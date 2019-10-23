<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<portlet:actionURL name="updatePassword" var="updatePassword"/>
<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<div class="newPortlets">
<div class="subHeaderNotFullwidth subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="12" cssClass="text-center"><h2><span>CHANGE PASSWORD</span></h2></aui:col>
			</aui:row>
		</div>
	</div>
</div>

<div class="formRoot">
<div class="innerFormRoot">
<div id="formio" class="formContainer container null formio-form">
<div style="display: none;" class="alert" role="showAlert" id="alert_msg_password">Select Facility Type.</div>
	<aui:form method="post" action="<%=updatePassword%>" name="updatepassword" id="updatepassword">    
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
			 <aui:input label="Enter Current Password" type="password" cssClass="form-control" required="true" id="current" name="current" >
			 		<aui:validator  name="required "  errorMessage="Enter Current Password" />
			 </aui:input>
       		</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
				 <aui:input label="Enter New Password" type="password" cssClass="form-control" required="true" id="password1" name="password1" >
				 	<aui:validator  name="required "  errorMessage="Enter New Password" />
				 </aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
				    <aui:input label="Confirm New Password" type="password" cssClass="form-control" required="true" id="password2" name="password2" >
				    	<aui:validator  name="required "  errorMessage="Confirm Your New Password" />
				    </aui:input>
			</aui:col>
		</aui:row>
       	<aui:row>
       		<aui:col span='10' cssClass="offset1 text-center userAction">
       			    <aui:button type="button" cssClass="btn-primary" onclick="submitUpdatePassword()" label="" value="Save"></aui:button>
       			    	<aui:button type="reset" onclick="clearFields()"  cssClass="btn-default" value="Clear"></aui:button>
			
	   		</aui:col>
       	</aui:row>
    
    </aui:form> 

</div>
</div></div>

</div>


<script>
var formsUrl = "${resourceURL}";
var namespace =  "<portlet:namespace/>";

</script>