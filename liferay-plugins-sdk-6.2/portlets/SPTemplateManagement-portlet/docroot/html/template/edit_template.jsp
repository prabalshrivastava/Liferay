<%@page import="java.util.ArrayList"%>
<%@page import="com.sambaash.platform.srv.template.model.SPComponentTemplate"%> 
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.template.model.SPTemplate"%>
<%@page import="java.util.Map"%>
   
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@include file="/html/template/init.jsp" %>

<portlet:actionURL var="saveTemplate"></portlet:actionURL> 

<portlet:resourceURL var="testAjaxResourceUrl" >
	<portlet:param name="action" value="editTemplate"/>
</portlet:resourceURL>
<portlet:actionURL name="viewTemplates"  var="viewTemplatesURL" >
	
</portlet:actionURL>
<script>
 var masterForm = [];
 </script>
 <%
String maxlevels = portletPreferences.getValue("maxlevels", "10");
SPTemplate template = (SPTemplate) request.getAttribute("template");
List<Long> formIdsOfCurrentTemplate = new ArrayList();
List<SPComponentTemplate> componentTemplates = new ArrayList();


if(request.getAttribute("componentTemplates") != null){
componentTemplates  = (List<SPComponentTemplate>) request.getAttribute("componentTemplates");

if(componentTemplates.size() > 0 && componentTemplates.get(0) != null){
	for(SPComponentTemplate entry : componentTemplates) {
		if(entry.getLevel0FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel0FormId());
		}
		if(entry.getLevel1FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel1FormId());
		}
		if(entry.getLevel2FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel2FormId());
		}
		if(entry.getLevel3FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel3FormId());
		}
		if(entry.getLevel4FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel4FormId());
		}
		if(entry.getLevel5FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel5FormId());
		}
		if(entry.getLevel6FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel6FormId());
		}
		if(entry.getLevel7FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel7FormId());
		}
		if(entry.getLevel8FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel8FormId());
		}
		if(entry.getLevel9FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel9FormId());
		}
		if(entry.getLevel10FormId() > 0){
			formIdsOfCurrentTemplate.add(entry.getLevel10FormId());
		}
	}
}
}

HashMap<String,JSONObject> systemtemplates = (HashMap) request.getAttribute("systemtemplates");
HashMap<String,JSONObject> copiedtemplates = (HashMap) request.getAttribute("copiedtemplates");



HashMap<String,JSONObject> formHashMap =new HashMap();
for (Map.Entry<String, JSONObject> entry : systemtemplates.entrySet()) {
	
	JSONObject step2JsonObject = entry.getValue();
	String className = step2JsonObject.getString("htmlFormId");
	if(step2JsonObject.getString("className") != null && !step2JsonObject.getString("className").equalsIgnoreCase("")){
		className = step2JsonObject.getString("className");
	}
	formHashMap.put(className, step2JsonObject);
}	  

String className = "";
for(long formId : formIdsOfCurrentTemplate){
	if(copiedtemplates.containsKey(String.valueOf(formId))){
		className = copiedtemplates.get(String.valueOf(formId)).getString("className");
		formHashMap.put(className, copiedtemplates.get(String.valueOf(formId)));
	}
}

///////  This block is for creating master list of Forms
for (Map.Entry<String, JSONObject> entry : formHashMap.entrySet()) {
	JSONObject step2JsonObject = entry.getValue();
	%>
	<script>
		var arr = {"FormName":"<%= step2JsonObject.getString("formName") %>","ClassName":"<%= step2JsonObject.getString("className") %>","FormId":"<%= step2JsonObject.getString("htmlFormId") %>"};
		console.log(arr);
		masterForm[<%= step2JsonObject.getInt("htmlFormId") %>] = arr;	
	</script>
	<%
}
////////////////////
%>





<script>
var maxLevels = <%= maxlevels %>;
</script>
<div class="container"  style="width:89%">
<div class="view-temp-con">
<a class="view-template" href="<%=viewTemplatesURL.toString()%>">View Templates</a>	
</div>
<div id="myAlert"></div>

<div class="alert alert-" role="alert" id="alert_msg" style="display:none">
	TaxCode for this Country and Start date Exists. 
</div>


<aui:form action="<%= saveTemplate %>" cssClass="container-fluid-1280" method="post" name="fm">
    <aui:fieldset>
    
    	<aui:input label="Name of the Template" name="templateName" type="text" value="<%= template.getTemplateName() %>"></aui:input>
    	<aui:input label="Name of the Template" name="templateId" type="hidden" value="<%= template.getSpTemplateId() %>"></aui:input>
    	
    	<label class="control-label" for="<portlet:namespace />parentTemplate">Select Parent Component Template *</label>
        <select onchange="checkForm();" class="selectbox" label="Select Parent Component Template" id="parentTemplate" name="<portlet:namespace />parentTemplate" required="true" showEmptyOption="true">
            <option value='0'>Select</option>
        <%  
        if(componentTemplates.size() > 0 && componentTemplates.get(0) != null){
        long parentFormId = componentTemplates.get(0).getLevel0FormId(); 
        for (Map.Entry<String, JSONObject> entry : formHashMap.entrySet()) {
        	JSONObject step2JsonObject = entry.getValue();
        	String selected = "";
        	String formname = step2JsonObject.getString("formName");
        	String[] parts = formname.split("-");
        	if(parentFormId == step2JsonObject.getLong("htmlFormId")) 
        		selected = "selected";
		 %>    
            <option <%=selected %>  value='<%= step2JsonObject.getLong("htmlFormId") + "--" + step2JsonObject.getString("className") %>'><%= parts[0] %><option>
        	
        <% } } %>
        <select>
        
        
        
        <table>
	        <% long selectedFormId = 0; int maxLevelssaved = 1; for (int k = 1; k <= Integer.valueOf(maxlevels); k++) { %>
	        <tr>
		        <%	for (int j = 1; j <= Integer.valueOf(maxlevels); j++) {
		        	String selectcss =  "level" + j +" sublevel" + k + " fixedwidth selectbox";
		        	String selectDisplay = "style='display:none;'";
		        	
		        	if(k <= componentTemplates.size() && componentTemplates.get(0) != null){
			        	if(j == 1) selectedFormId = componentTemplates.get(k -1).getLevel1FormId();
			        	else if(j == 2) selectedFormId = componentTemplates.get(k -1).getLevel2FormId();
			        	else if(j == 3) selectedFormId = componentTemplates.get(k -1).getLevel3FormId();
			        	else if(j == 4) selectedFormId = componentTemplates.get(k -1).getLevel4FormId();
			        	else if(j == 5) selectedFormId = componentTemplates.get(k -1).getLevel5FormId();
			        	else if(j == 6) selectedFormId = componentTemplates.get(k -1).getLevel6FormId();
			        	else if(j == 7) selectedFormId = componentTemplates.get(k -1).getLevel7FormId();
			        	else if(j == 8) selectedFormId = componentTemplates.get(k -1).getLevel8FormId();
			        	else if(j == 9) selectedFormId = componentTemplates.get(k -1).getLevel9FormId();
			        	else if(j == 10) selectedFormId = componentTemplates.get(k -1).getLevel10FormId();
		        	}
		        	
				 %>  
				 <td class="level">
				
				<% if(selectedFormId > 0){ selectDisplay =""; if(j > maxLevelssaved) maxLevelssaved = j;}  %>
		        <select onchange="checkForm();" <%= selectDisplay %>  class='<%= selectcss  %>' name='<portlet:namespace />selectField<%= j + "-" + k %>' id = 'selectField<%= j + "-" + k %>' >
		        	<option value='0'>Select</option>
		        <% for (Map.Entry<String, JSONObject> entry : formHashMap.entrySet()) {
		        	JSONObject step2JsonObject = entry.getValue();
		        	String selected = "";
		        	String formname = step2JsonObject.getString("formName");
		        	String[] parts = formname.split("-");
		        	
		        	if(selectedFormId == step2JsonObject.getLong("htmlFormId")) {
		        		selected = "selected";
		        		
		        	}
		        		
				 %>    
		            <option <%=selected %> value='<%= step2JsonObject.getLong("htmlFormId") + "--" + step2JsonObject.getString("className") %>'><%= parts[0] %></option>
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
	        <%  String showSublevelbtn = "style='display:none'";	for (int j = 1; j <= Integer.valueOf(maxlevels); j++) {
	        	showSublevelbtn = "style='display:none'";
	        	if(j <= maxLevelssaved ) showSublevelbtn = "style='display:block'";
			 %> 
	        	<td>
	        	<input type="button" id="subLevelBtn<%= j %>" value="Add Sub Level" <%= showSublevelbtn %> onclick = "addsub('<%= j %>')" />
	        	</td>
	        	<script>
					var currentLevel<%= j %> = 1;
				</script>
	        <% } %>
        </table>
        <input type="hidden"  id="activatedsubleveles" name= "<portlet:namespace />activatedsubleveles" value= "1" >
        <input type ="hidden" id="apiUrl" value = "${testAjaxResourceUrl}" > 
        <input type ="hidden" id="redirectUrl" value = "${viewTemplateURL}" > 
        <hr />
        <aui:button value="Submit" cssClass="btn-primary" id="submitBtn" onClick="saveTemplate()" />
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