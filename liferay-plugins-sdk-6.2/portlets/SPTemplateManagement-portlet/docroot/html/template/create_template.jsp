<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@include file="/html/template/init.jsp" %>

<portlet:actionURL var="saveTemplate"></portlet:actionURL>

<portlet:resourceURL var="testAjaxResourceUrl" >
	<portlet:param name="action" value="createTemplate"/>
</portlet:resourceURL>
<portlet:actionURL name="viewTemplates"  var="viewTemplatesURL" >
	
</portlet:actionURL>

<script>
 var masterForm = [];
 </script>
 <%
String maxlevels = portletPreferences.getValue("maxlevels", "10");
%>
 <% 
 HashMap<String,JSONObject> systemtemplates = (HashMap) request.getAttribute("systemtemplates");
 HashMap<String,JSONObject> copiedtemplates = (HashMap) request.getAttribute("copiedtemplates");
 HashMap<String,JSONObject> formHashMap =new HashMap();
 for (Map.Entry<String, JSONObject> entry : systemtemplates.entrySet()) {
	JSONObject step2JsonObject = entry.getValue();
%>
<script>
	var arr = {"FormName":"<%= step2JsonObject.getString("formName") %>","ClassName":"<%= step2JsonObject.getString("className") %>","FormId":"<%= step2JsonObject.getString("htmlFormId") %>"};
	masterForm[<%= step2JsonObject.getInt("htmlFormId") %>] = arr;	
</script>
<%	 }	  %>

<script>
var maxLevels = <%= maxlevels %>;

</script>

<div class="container" style="width:89%">
<a class="view-template" href="<%=viewTemplatesURL.toString()%>">View Templates</a>	

<div class="alert alert-" role="alert" id="alert_msg" style="display:none">
	TaxCode for this Country and Start date Exists. 
</div>


<aui:form action="<%= saveTemplate %>" cssClass="container-fluid-1280" method="post" name="fm">
    <aui:fieldset>
    
    	<aui:input label="Name of the Template" name="templateName" type="text"></aui:input>
    	
    	<label class="control-label" for="_template_WAR_SPTemplateManagementportlet_parentTemplate">Select Parent Component Template *</label>
    	<select onchange="checkForm();" class="selectbox" label="Select Parent Component Template" id="parentTemplate" name="<portlet:namespace />parentTemplate" required="true" showEmptyOption="true">
            <option value='0'>Select</option>
        <%  
        for (Map.Entry<String, JSONObject> entry : systemtemplates.entrySet()) {
        	JSONObject step2JsonObject = entry.getValue();
        	
		 %>    
            <option  value='<%= step2JsonObject.getLong("htmlFormId") + "--" + step2JsonObject.getString("className") %>'><%= step2JsonObject.getString("formName") %><option>
        	
        <% } %>
        <select>
       
        
        
        <table>
	        <% for (int k = 1; k <= Integer.valueOf(maxlevels); k++) { %>
	        <tr>
		        <%	for (int j = 1; j <= Integer.valueOf(maxlevels); j++) {
		        	String selectcss =  "level" + j +" sublevel" + k + " fixedwidth selectbox";
		        	String selectDisplay = "style='display:none;'";
		        	if(k == 1 && j == 1){
		        		selectDisplay = "";
		        	}
				 %>  
				<td class="level">
				
		        <select onchange="checkForm();" <%= selectDisplay %> class='<%= selectcss %>' name='<portlet:namespace />selectField<%= j + "-" + k %>' id = 'selectField<%= j + "-" + k %>' >
		        	<option value='0'>Select</option>
		        <% for (Map.Entry<String, JSONObject> entry : systemtemplates.entrySet()) {
		        	JSONObject step2JsonObject = entry.getValue();
				 %>    
		            <option value='<%= step2JsonObject.getInt("htmlFormId") + "--" + step2JsonObject.getString("className") %>'><%= step2JsonObject.getString("formName") %></option>
		        <% } %>
		        </select>
				 </td>
		        <% } %>
		        <td>
		        <% if(k == 1){ %>
		        <input type="button" id="addlevelbtn" value="Add Level" onclick = "addlevel()" />
		        <%  } %>
		       
		        </td>
	        </tr>
	        <% } %>
	        <%	for (int j = 1; j <= Integer.valueOf(maxlevels); j++) {
	        	String selectDisplaySubLevel = "style='display:none;'";
	        	if(j == 1){
	        		selectDisplaySubLevel = "";
	        	}
			 %> 
	        	<td>
	        	<input type="button" id="subLevelBtn<%= j %>" value="Add Sub Level" <%= selectDisplaySubLevel %> onclick = "addsub('<%= j %>')" />
	        	</td>
	        	<script>
					var currentLevel<%= j %> = 1;
				</script>
	        <% } %>
        </table>
        <input type="hidden" id="activatedsubleveles" name= "<portlet:namespace />activatedsubleveles" value= "1" >
        
        <hr />
        <input type ="hidden" id="apiUrl" value = "${testAjaxResourceUrl}" > 
        <input type ="hidden" id="redirectUrl" value = "${viewTemplatesURL}" > 
        
        <aui:button value="Submit" cssClass="btn-primary" id="submitBtn" onClick="saveTemplate()"/>
    </aui:fieldset>
</aui:form>

</div>
<script>
window.onload = function() {
	document.getElementById("selectField1-1").style.display = "block";
	document.getElementById("subLevelBtn1").style.display = "block";
	checkForm();
};
</script>

