<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<liferay-theme:defineObjects/>
<portlet:defineObjects />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/facility.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<%
String currentUserEmail=null;
User currentUser = themeDisplay.getUser();
currentUserEmail=currentUser.getEmailAddress();
%>

<portlet:actionURL var="updateEmailAddressURL" >
<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="updateEmailAddress" />
</portlet:actionURL>


<%-- <portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL> --%>

<div class="newPortlets">

<div class="subHeaderNotFullwidth subHeader">
	<div class="container">
		<aui:row>
			<aui:col span="12" cssClass="text-center"><h2>CHANGE EMAIL</h2></aui:col>
		</aui:row>
	</div>
</div>

<div style="display: none;" class="alert alert-danger" role="showAlert" id="alert_msg">Select Facility Type.</div>
<div id="formio" class="formContainer container null formio-form">
	<aui:form method="post" action="<%=updateEmailAddressURL.toString()%>" name="updateEmailAddress" id="updateEmailAddress">   
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
				<aui:input label="Enter Current Email" cssClass="form-control" type="email" value="<%=currentUserEmail%>" required="true" showRequiredLabel="<%=false %>" readonly="true" id="currentEmail" name="currentEmail" >
				<aui:validator name="email"/>
				</aui:input>
        
			</aui:col>
		</aui:row> 
		<aui:row>
			<aui:col span="12" cssClass="formio-component-textfield">
				 <aui:input label="Enter New Email" type="email" cssClass="form-control"  required="true" showRequiredLabel="<%=false %>" id="newEmail" name="newEmail" >
       		<aui:validator name="email"/>
       		</aui:input>
       		</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="10" cssClass="offset1 text-center userAction">
				<aui:col span="5" cssClass="text-right">
				<aui:button type="submit"/> 
				</aui:col>
				<aui:col span="5" cssClass="offset1 text-left">
					<aui:button type="reset"  cssClass="btn-default" value="Clear"></aui:button>
				</aui:col> 
			</aui:col>
       	</aui:row> 
        </aui:form> 
</div>
</div>
<liferay-ui:success key="updated Successfully"  message="A verification code has been sent to new email address. Please click on the 'Activate' link"/>
<liferay-ui:error key="USER ALREADY IN USE" message="User Already in Use"/>
<liferay-ui:error key="USER NOT FOUND" message="User not exist"/>


