<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.sambaash.platform.dbutility.configuration.DB_Configuration" %>
<%@ page import="com.sambaash.platform.dbutility.portlet.DBUtilityPortlet" %>

<portlet:defineObjects />
<liferay-portlet:resourceURL var="connectionURL" />

<%  
	String connectionStatus = GetterUtil.getString(portletPreferences.getValue("connectionStatus", StringPool.FALSE));
	String formOptionPoll = DBUtilityPortlet.FORMOPTION_POLL;
	String completedString = DBUtilityPortlet.COMPLETED_STRING;
	ArrayList<String> databaseList = new ArrayList<String>();
	if(!connectionStatus.equals("true")){
		out.println("SQL Connection Failed: Check SQL connection at configuration");	
	}
	else{
		databaseList = (ArrayList<String>)renderRequest.getAttribute("databaseList");
%>	

<aui:script>
var running = false;
var errorCount = 0;
function ajaxCall() {
	if(!running){
		AUI().use('aui-io-request', function(A) {
			var interval = setInterval(function(){
				running = true;
				var database = A.one("select[data-id=database]");
				data = {};
				data.formOption = '<%=formOptionPoll%>';
				data.database = database.val();
				
				A.io.request('${connectionURL}', {
					method : 'post',
					data: data,
					dataType: "json",
					on : {
						success : function() {
							var res=this.get('responseData');
							var message = res.message
							addText(A,message);
							
							if(message.indexOf('<%=completedString%>') !== -1){
								clearInterval(interval);
								running = false;
							}
						},
						failure : function(event, id, xhr) {
							console.log('Error!');
							errorCount++;
							if(errorCount > 3){
								clearInterval(interval);
								running = false;
							}
						}
					}
				});
			}, 1000);
		});
	}
	else{
		alert("Process is running! Please wait");
	}
}

function addText(A,data){
	var textarea = A.one("textarea[data-id=message]")
	var message = textarea.val();
	if(!(data === undefined || data == null || data.length <= 0)){
		if(message == ""){
			textarea.val(data);
		}
		else{
			textarea.val(message+data);
		}
		textarea.blur();
		textarea.focus();
	}
	else{
		console.log('Message Queue is empty, no update from Server.');
	}
}
</aui:script>
	Select a Database: 
	<aui:form action="<%= connectionURL %>" method="post" name="fm">
		<input id="formOption"  name="formOption" type="hidden" value="<%=DBUtilityPortlet.FORMOPTION_POST %>">
		<select id="databaseDropdown" name="databaseDropdown" data-id="database">
<%
		for(String database :databaseList){
%>
			<option value="<%=database%>"><%=database%></option>
<%		
		}
%>
		</select>
		<textarea id="messageTextarea" data-id="message" rows="8" readonly autofocus></textarea>
	   	<aui:button data-id="submit" type="submit" value="Generate SQL Script" onClick='ajaxCall()'/>
	</aui:form>
		<div style=" color:red;">
		Constraint of extra.sql<br/>
	   	<ul>
	   		<li>&nbsp;&nbsp;&nbsp;* A table must have at least a PRI key.</li>
			<li>&nbsp;&nbsp;&nbsp;* Each line must start with either one of the following keyword:</li>
			<li>&nbsp;&nbsp;&nbsp;* Insert, Create, Use, Drop, Update, Delete, Alter.</li>
			<li>&nbsp;&nbsp;&nbsp;* Each line must end with a ;.</li>
			<li>&nbsp;&nbsp;&nbsp;* Does not support any form of SQL comment.</li>
			</ul>  
	</div>
<% 		
	}

%>