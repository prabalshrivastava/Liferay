<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="testAjaxResourceUrl" >
</portlet:resourceURL>

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
	
	String preference = renderRequest.getPreferences().getValue("preference","");
	JSONObject prefData = JSONFactoryUtil.createJSONObject(preference);
	

	String templatename = prefData.getString("templatename","");
	String containerStyle = prefData.getString("containerStyle","");
	String baseUrl =  prefData.getString("baseUrl",""); 
	String modelName = prefData.getString("model1",""); 
	String modelNameCol2 = prefData.getString("model2",""); 
	String numColumns = prefData.getString("numColumns",""); 
	String column1links = prefData.getString("column1links",""); 
	
	String column2links = prefData.getString("column2links",""); 
	String outerListingLink = prefData.getString("outerListingLink",""); 
	
%>
<div class="newPortlets">
	<div class="formContainer container null formio-form">
			<div class="linksDivCol1Content" style="display:none;">
				<div class="form-group formio-component-textfield">
					<aui:input name="text" cssClass="text form-control" label="Text" value='' />
				</div>
				<div class="form-group formio-component-textfield">
					<aui:input name="link" cssClass="link form-control" label="Link" value='' />
				</div>
			</div>
			<div class="linksDivCol2Content" style="display:none;">
				<div class="form-group formio-component-textfield">
					<aui:input name="text" cssClass="text form-control" label="Text " value='' />
				</div>
				<div class="form-group formio-component-textfield">
					<aui:input name="link" cssClass="link form-control" label="Link" value='' />
				</div>
			</div>
			
			
			<aui:row>
				<aui:col span="8" cssClass="offset2">
					<div class="colConfig">
						<aui:row>
							<aui:col span="6">
							<div class="form-group formio-component-textfield">
								<aui:input name="htmlFormIdPref" cssClass="form-control" label="Load the template with this ID" value='<%=templatename%>' onblur="loadTemplate()" />
							</div>
							<div class="form-group formio-component-textfield">
								<aui:input name="containerStylePref" cssClass="form-control" label="Form Container Inline Style" value='<%=containerStyle%>'  />
							</div>
							<div class="form-group choices formio-choices">
								<aui:select name="modelNamePref" cssClass="form-control" label="Model for Column 1" onChange="populateValues()" >
								
							</aui:select>
							</div>
							</aui:col>
							<aui:col span="6">
								<div class="form-group formio-component-textfield">
									<aui:input name="successEntity" cssClass="form-control"  label="Number of Columns" value='<%=numColumns%>' onchange="showColumns()" />
								</div>
								<div class="form-group formio-component-textfield">
									<aui:input name="baseUrlPref" cssClass="form-control"  label="Base URL" value='<%=baseUrl%>'></aui:input>
								</div>
								<div class="form-group choices formio-choices">
									<aui:select name="modelNamePrefCol2" cssClass="form-control" label="Model for Column 2" onChange="populateValuesCol2()" >
								
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
							
							<div class="form-group choices formio-choices">
							<aui:input name="outerListingLink" id="outerListingLink" cssClass="form-control" label="Link for listing" value='<%=outerListingLink%>'  />
								
								
							
							</div>
							</aui:col>
							
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<h4>Column 1 Links</h4>
								<div class="linksDivCol1">
							
								</div>
								<div class="form-group">
									
									<aui:button type="button" cssClass="btn-default" onclick="addNewCol1()" value="Add New"></aui:button>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12">
								<h4>Column 2 Links</h4>
								<div class="linksDivCol2">
						
								</div>
								
										<aui:button type="button" cssClass="btn-default" onclick="addNewCol2()" value="Add New"></aui:button>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="8" cssClass="offset2 text-center">
								<aui:button name="saveButton" cssClass="btn btn-primary" type="button" value="label.save" onclick="savePreference()" />
								<aui:button type="button" cssClass="btn-default" value="cancel" onClick="cancel()" /> 
							</aui:col>
						</aui:row>
					</div>
				</aui:col>
			</aui:row>
			
			
			
			
			
		</div>
	</div>
<script>
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "<%= testAjaxResourceUrl %>";

var templateField = document.getElementById(namespace+'htmlFormIdPref');
var inpModelName = document.getElementById(namespace+'modelNamePref');
var outerListingLink = document.getElementById(namespace+'outerListingLink');
var inpModelNameCol2 = document.getElementById(namespace+'modelNamePrefCol2');

var inpcontainerStyle = document.getElementById(namespace+'containerStylePref');
var inpbaseUrlPref = document.getElementById(namespace+'baseUrlPref');
var inpModelNameCol2 = document.getElementById(namespace+'modelNamePrefCol2');


var inpNumColumns = document.getElementById(namespace+'successEntity');
var linksDivCol1 = document.getElementsByClassName("linksDivCol1")[0];
var linksDivCol2 = document.getElementsByClassName("linksDivCol2")[0];
var linksDivCol1Content = document.getElementsByClassName("linksDivCol1Content")[0];
var linksDivCol2Content = document.getElementsByClassName("linksDivCol2Content")[0];

var modelName = "<%= modelName %>";
var modelNameCol2 = "<%= modelNameCol2 %>";
var templatename = "<%= templatename %>";
var linkList =[] ;

var column1links =  '<%= column1links  %>';
var column2links =  '<%= column2links  %>';

if(column1links != ''){
	column1links =  JSON.parse(column1links);
}
if(column2links != ''){
	column2links =  JSON.parse(column2links);
}
console.log(column1links);console.log(column2links);
if(templateField != ""){
	loadTemplate();
}

function loadTemplate(){
	
	inpModelName.length = 0;
	inpModelNameCol2.length = 0;
	var opt = new Option("Programme","1787,Programme") ;
   	var opt2 = new Option("Programme","1787,Programme") ;
	inpModelName.options[inpModelName.options.length] = opt;
	inpModelNameCol2.options[inpModelNameCol2.options.length] = opt2;
	
	var opt = new Option("Subject","1786,Subject") ;
   	var opt2 = new Option("Subject","1786,Subject") ;
	inpModelName.options[inpModelName.options.length] = opt;
	inpModelNameCol2.options[inpModelNameCol2.options.length] = opt2;
	
	inpModelName.value =  modelName;
   	inpModelNameCol2.value =  modelNameCol2;
	
	var data1 = {"templateId":templateField.value};
 	ajaxCall('GET','getTemplateForms',ajaxUrl,data1,
		 function() {
           response = this.get("responseData");
           if (_.isEmpty(response)) {
               console.log("error");
           } else {
           	 console.log(response);
           	inpModelName.length = 0;   
           	inpModelNameCol2.length = 0;   
           	for (var i = 0; i < response.length; i++) {
				var opt = new Option(response[i].FormName,response[i].FormId + "," + response[i].FormName) ;
				var opt2 = new Option(response[i].FormName,response[i].FormId + "," + response[i].FormName) ;
				inpModelName.options[inpModelName.options.length] = opt;
				inpModelNameCol2.options[inpModelNameCol2.options.length] = opt2;
			}
           	
           	
           	inpModelName.value =  modelName;
           	inpModelNameCol2.value =  modelNameCol2;
           }
       },
       function() {
           
		});
}
function populateValues(){
	
}
function populateValuesCol2(){
	
}
function addNewCol1(){
	var newCol = linksDivCol1Content.cloneNode(true);
	newCol.style.display = "";
	linksDivCol1.appendChild(newCol);
	
}
function addNewCol2(){
	var newCol = linksDivCol2Content.cloneNode(true);
	newCol.style.display = "";
	linksDivCol2.appendChild(newCol);
	
}


function showColumns(){
	if(inpNumColumns.value == 2){
		document.getElementsByClassName("linksDivCol2")[0].style.display = "block"; 
	}else {
		document.getElementsByClassName("linksDivCol2")[0].style.display = "none";
	}
}
function Link(text,link) {
	this.Text = text;
	this.Link = link;
 }
function drawLinks(content,side){
	
	for(var i = 0 ; i < content.length; i++){
		if(side == "left"){
			var copyContent = linksDivCol1Content.cloneNode(true);
			copyContent.getElementsByClassName("text")[0].value = content[i].Text;
			copyContent.getElementsByClassName("link")[0].value = content[i].Link;
			linksDivCol1.appendChild(copyContent);
		}else{
			var copyContent = linksDivCol2Content.cloneNode(true);
			copyContent.getElementsByClassName("text")[0].value = content[i].Text;
			copyContent.getElementsByClassName("link")[0].value = content[i].Link;
			linksDivCol2.appendChild(copyContent);
		}
		copyContent.style.display = "";
	}
	
	
}
drawLinks(column1links,"left");
drawLinks(column2links,"right");
function savePreference(){
	
	if(templateField.value == ""){
		setAlert("","Please Fill up Template name");
	}
	else{
	 	var data = {"templatename":templateField.value,"numColumns":inpNumColumns.value,"containerStyle":inpcontainerStyle.value,"baseUrl":inpbaseUrlPref.value,"model1":inpModelName.value};
	 	 var _data = {};
	 	//if(inpNumColumns.value == 2){
	 		data.model2 = inpModelNameCol2.value;
	 	//}

		var list ;
	 	var allCol1inputs = document.getElementsByClassName("linksDivCol1Content");
	 	for(var i = 0; i < allCol1inputs.length; i++){
	 		var text = allCol1inputs[i].getElementsByClassName("text")[0].value;
	 		var link = allCol1inputs[i].getElementsByClassName("link")[0].value;
	 		list = new Link(text,link);
	 		if(text != "" && link != "")
	 		linkList.push(list);
	 	}
	 	data.column1links = linkList;
	 	linkList = [];
	 	var allCol1inputs = document.getElementsByClassName("linksDivCol2Content");
	 	for(var i = 0; i < allCol1inputs.length; i++){
	 		var text = allCol1inputs[i].getElementsByClassName("text")[0].value;
	 		var link = allCol1inputs[i].getElementsByClassName("link")[0].value;
	 		list = new Link(text,link);
	 		if(text != "" && link != "")
	 		linkList.push(list);
	 	}
	 	data.column2links = linkList;
	 	data.outerListingLink = outerListingLink.value;
	 	console.log(data);
	 	 _data[namespace + 'data'] = JSON.stringify(data); 
	 	 _data[namespace + 'action'] = "savePreference";
	 	console.log(_data); 
	 	AUI().use('aui-base','aui-io-request-deprecated',function(A){
		 	A.io.request(ajaxUrl,{
	            dataType : 'json', method : "POST",
	            data : _data,
	            on : {
	                success : function(){
	                	cancel();
	                },
	                failure :function() {
	                   
	                }
	            }
	        });  
		 });  
	}
	
}
function cancel(){
	window.location.href = "<%=viewURL%>";
}
</script>