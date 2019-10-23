<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/main.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<portlet:resourceURL var="ajaxUrl" >

</portlet:resourceURL>

<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span>Entity Linking</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><aui:a href="#link" title="Back to Home">Back to Home</aui:a></aui:col>
		</aui:row>
		</div>
	</div>
</div>


<ul>
	<li id ="liAnchorElement" onclick="removeThis(this)" style="display:none" >
		<a>MSE002</a>
		<span  style="display:none">CC</span>
	</li>
	 
	<li id ="listElement" style="display:none">
		<label>
			<input type="checkbox"  name="programm" class="listCheckBox" onChange="modifyList(this,'left')"/>
			<span class="listSpanTitle">PP</span>
			<span class="listSpanCode" style="display:none">CC</span>
		</label>
	</li>
</ul>




<div class="sambaashContent ">
	<form class="formContainer" id="mappingform" >
	<div class="container entitylink">
		<aui:row cssClass="entityTab">
			<aui:col span="4" cssClass="text-center posRelative"><em class="progIcon"></em><select><option>SCHEDULE</option></select></aui:col>
			<aui:col span="4" cssClass="text-center"><div class="msg">Search and add entities for mapping</div></aui:col>
			<aui:col span="4" cssClass="text-center posRelative"><em class="subIcon"></em><select><option>PROGRAMME</option></select></aui:col>
		</aui:row>
		<aui:row cssClass="entitylinkBox">
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
					<aui:row>
						<aui:col span="12">
							<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="" placeholder="Search for a Programme title or code"></aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<div class="programmeDiv">
							<aui:col span="12">
							<ul>
							
								<li>
									<label> 
										<input type="checkbox" name="programm" class="checkNone" id="checkNoneLeft" onchange="checkNone(this,'left')"> 
										<span class="listSpanTitleDefault">None</span>
									</label> 
								</li>
								<li>
									<label> 
										<input type="checkbox" name="programm" class="checkAll" onchange="checkAll(this,'left')"> 
										<span class="listSpanTitleDefault">All</span>
									</label> 
								</li>
								
							</ul>
						</aui:col>
						</div>
					</aui:row>
				</div>
			</aui:col>
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
					<aui:row>
						<aui:col span="12">
						<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="" placeholder="Search for a Subject title or code"></aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<div class="subjectDiv"> 
							<aui:col span="12">
								<ul>
									<li>
									<label> 
										<input type="checkbox" name="programm" class="checkNone"  id="checkNoneRight"  onchange="checkNone(this,'right')"> 
										<span class="listSpanTitleDefault">None</span>
									</label> 
								</li>
								<li>
									<label> 
										<input type="checkbox" name="programm" class="checkAll" onchange="checkAll(this,'right')"> 
										<span class="listSpanTitleDefault">All</span>
									</label> 
								</li>
								
									
								</ul>
							</aui:col>
						</div>
					</aui:row>
					
				</div>
			</aui:col>
		</aui:row>
		
		<aui:row cssClass="routeCode">
				<aui:col span="12" cssClass="text-center routeCodeEnter">
					
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					<aui:col span="4">
						<aui:col span="2"></aui:col>
						<aui:col span="4">
							<label>Route Code</label>
						</aui:col>
						<aui:col span="4">
							<input type="text" id="RouteCode" name="RouteCode" class="form-control" />
						</aui:col>
					</aui:col>
					<aui:col span="4" cssClass="text-center">
					</aui:col>
				</aui:col>
				<aui:col span="12" cssClass="text-center">
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					<aui:col span="4">
					<button class="btn bluebtn" onClick="saveLink()">Save</button> 
				 	 <button class="btn lightbluebtn"  onclick="reset()">Clear</button>
					</aui:col>
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					 
	 			</aui:col>
			</aui:row>
			
		
		
		
	</div>
	</form>
	
</div>


<div id="sucess-popup" hidden="true" class="modalpopupBox">
   <div id="sucess-popup-box" class="modalpopupContent">
   <form class="formContainer" >
     <aui:row>
         <aui:col span="12">
       	  <h3>Mapping Successful!</h3>
       	  </aui:col>
       
     </aui:row>
     <aui:row>
      	<aui:col span="12">
      		<button class="btn lightbluebtn popup-confirm-archive pull-left" onClick="reloadPage()">Start Again</button>
      		<button class="btn cancel bluebtn popup-cancel pull-right">DashBoard</button>
      	</aui:col>
     </aui:row>
           
   </form>
   </div>
</div>

</div>
<script type="text/javascript">
var modelLeft = "Schedule";
var modelRight = "Programme";

var mode = "edit";
var namespace = "<portlet:namespace/>";

var leftSideList = [],rightSideList = [],selectedLeftModel = [],selectedRightModel = [],elem1;
var ajaxurl = "<%= ajaxUrl.toString() %>";
var listElement = document.getElementById("listElement");
var listElement = document.getElementById("listElement");
var liAnchorElement  = document.getElementById("liAnchorElement");
var selectedItem;
var entitySearch;
var inp_waivefee,inp_subject_sub_type;
function getList(modelName,side){
	var listingDiv;
	var data = {"limit":100,"modelName":modelName,"page":0,"formType":modelName};
	
	ajaxCall('GET','loadList',ajaxurl,data,
		 function() {
	            var data = this.get("responseData");
	            if (_.isEmpty(data)) {
	                console.log("error");
	                
	            } else {
	            	tableData = data.content;
	            	totalRecords = data.totalElements;
	            	totalPages = data.totalPages;
	                
	                if(side == "left"){
	                	listingDiv = "programmeDiv";
	                }else if(side == "right"){
	                	listingDiv = "subjectDiv";
	                }
	                //listElement
	                reloadListing(listingDiv,tableData);
	               
	            }
	        },
	        function() {
	            
	 		});
}

function reloadListing(div,data){
	for(var i =0; i <data.length; i++){
		var obj = {};
		if(div == "programmeDiv"){
			obj.key = data[i].contentJson.ScheduleCode;
			obj.value = data[i].contentJson.ScheduleCode;
			
			leftSideList.push(obj);
			console.log(leftSideList);
			var clone = listElement.cloneNode(true);
			clone.style.display = "block";
			clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","modifyList(this,'left');");
			clone.getElementsByClassName("listSpanTitle")[0].innerHTML = obj.value;
			clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
			document.getElementsByClassName(div)[0].appendChild(clone);
		}else if(div == "subjectDiv"){
			obj.key = data[i].contentJson.ProgrammeCode;
			obj.value = data[i].contentJson.ProgrammeTitle;
			
			rightSideList.push(obj);
			var clone = listElement.cloneNode(true);
			clone.style.display = "block";
			clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","modifyList(this,'right');");
			clone.getElementsByClassName("listSpanTitle")[0].innerHTML = obj.value;
			clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
			document.getElementsByClassName(div)[0].appendChild(clone);
		}
		
	}
}
function reset(){
	
	checkNone(document.getElementById("checkNoneLeft"),"left");
	checkNone(document.getElementById("checkNoneRight"),"right");
	document.getElementById("mappingform").reset();
	document.getElementById("next_btn").disabled = true;
}
window.onload = function() {
	getList(modelLeft,"left");	
	getList(modelRight,"right");
	
}
function modifyList(elem,side){
	elem1 = elem;
	var obj = {};
	var value = elem.parentElement.getElementsByClassName("listSpanTitle")[0].innerHTML;
	var key = elem.parentElement.getElementsByClassName("listSpanCode")[0].innerHTML;
	obj.key = key;obj.value = value;
	
	if(side == "left"){
		if(elem1.checked == true){
			selectedLeftModel.push(obj);
		}else{
			for( var i = 0; i < selectedLeftModel.length; i++){
			   if ( selectedLeftModel[i].value == value) {
				   selectedLeftModel.splice(i, 1); 
			   }
			}
		}
	}else{
		if(elem1.checked == true){
			selectedRightModel.push(obj);
		}else{
			for( var i = 0; i < selectedRightModel.length; i++){ 
			   if ( selectedRightModel[i].value == value) { 
			   		selectedRightModel.splice(i, 1); 
			   }
			}
		}
		showNextBtn();
	}
	
	drawFilter(elem,side);
	
}
function showNextBtn(){
	if(selectedLeftModel.length > 0 && selectedRightModel.length > 0){
		document.getElementById("next_btn").disabled = false;
	}else{
		document.getElementById("next_btn").disabled = true;
		document.getElementsByClassName("addEntityDetails")[0].style.display = "none";
	}
}

function checkAll(elem,side){
	entitySearch = findAncestor(elem,"entitySearch");
	var allcheckboxkeys = entitySearch.getElementsByClassName("listSpanCode");
	var allcheckboxvalues = entitySearch.getElementsByClassName("listSpanTitle");
	var allcheckbox = entitySearch.getElementsByClassName("listCheckBox"); 
	if(side == "left"){
		selectedLeftModel = [];
		for(var i =0;i< allcheckboxvalues.length; i++){
			var obj = {};
			var value = allcheckboxvalues[i].innerHTML;
			var key = allcheckboxkeys[i].innerHTML;
			allcheckbox[i].checked = true;
			obj.key = key;obj.value = value;
			selectedLeftModel.push(obj);
		}
	}else{
		selectedRightModel = [];
		for(var i =0;i< allcheckboxvalues.length; i++){
			var obj = {};
			var value = allcheckboxvalues[i].innerHTML;
			var key = allcheckboxkeys[i].innerHTML;
			allcheckbox[i].checked = true;
			obj.key = key;obj.value = value;
			selectedRightModel.push(obj);
		}
		showNextBtn();
	}
	drawFilter(elem,side);
}
function checkNone(elem,side){
	entitySearch = findAncestor(elem,"entitySearch");
	var allcheckbox = entitySearch.getElementsByClassName("listCheckBox");
	if(side == "left"){
		selectedLeftModel = [];
		for (var i = 0; i < allcheckbox.length; ++i) { allcheckbox[i].checked = false; }
	}else{
		selectedRightModel = [];
		for (var i = 0; i < allcheckbox.length; ++i) { allcheckbox[i].checked = false; }
	}
	drawFilter(elem,side);
}
function drawFilter(elem,side){
	entitySearch = findAncestor(elem,"entitySearch");
	selectedItem = entitySearch.getElementsByClassName("selectedItem")[0];
	selectedItem.getElementsByTagName("ul")[0].innerHTML = '';
	if(side == "left"){
		for(var i = 0; i < selectedLeftModel.length; i++){
			var clone = liAnchorElement.cloneNode(true);
			clone.style.display = "inline-block";
			clone.getElementsByTagName("a")[0].innerHTML = selectedLeftModel[i].value;
			clone.getElementsByTagName("span")[0].innerHTML = selectedLeftModel[i].key;
			clone.getElementsByTagName("a")[0].setAttribute("onClick","removeThis(this,'left');");
			selectedItem.getElementsByTagName("ul")[0].appendChild(clone);
		}
	}else{
		for(var i = 0; i < selectedRightModel.length; i++){
			var clone = liAnchorElement.cloneNode(true);
			clone.style.display = "inline-block";
			clone.getElementsByTagName("a")[0].innerHTML = selectedRightModel[i].value;
			clone.getElementsByTagName("span")[0].innerHTML = selectedRightModel[i].key;
			clone.getElementsByTagName("a")[0].setAttribute("onClick","removeThis(this,'right');");
			selectedItem.getElementsByTagName("ul")[0].appendChild(clone);
		}
	}
}

function saveLink(){
	var routeCode = document.getElementById("RouteCode");
	for(var i =0; i < selectedLeftModel.length; i++){
		for(var j =0; j < selectedRightModel.length; j++){
			var data = {"formType":"EntityLink","ModelRight":modelRight,"ModelLeft":modelLeft,"StorageIdRight":selectedRightModel[j].key,"StorageIdLeft":selectedLeftModel[i].key,"RouteCode":routeCode.value};
			ajaxCall('GET','persist',ajaxurl,data,
			 function() {
		            var data = this.get("responseData");
		            if (_.isEmpty(data)) {
		                console.log("error");
		            } else {
		            	console.log("saved");
		            	showSuccessfulMsg();
		               
		            }
		        },
		        function() {
		            
		 		});

		}
	}
	
}
function showSubType(){
	document.getElementsByClassName("addEntityDetails")[0].style.display = "block";	
}



function removeThis(elem,side){
	var value = elem.parentElement.getElementsByTagName("a")[0].innerHTML;
	if(side == "left"){
		for( var i = 0; i < selectedLeftModel.length; i++){ 
		   if ( selectedLeftModel[i] == value) { 
			   selectedLeftModel.splice(i, 1); 
		   }
		}
	}else{
		for( var i = 0; i < selectedRightModel.length; i++){ 
		   if ( selectedRightModel[i] == value) { 
		   		selectedRightModel.splice(i, 1); 
		   }
		}
	}
	drawFilter(elem,side);
}


</script>

<style>
.listSpanTitle{
    margin-left: 37px;
    width: 100% !important;
    text-align: left;
    margin-top: 20px !important;
    
}

</style>