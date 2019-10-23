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

<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>

<portlet:defineObjects />
<portlet:resourceURL var="ajaxUrl" >

</portlet:resourceURL>

<% String subjectSubTypeURL = SambaashUtil.getVocabularyUrl("Subject Sub Type"); 
String waiveFeeListURL = SambaashUtil.getVocabularyUrl("Fee Category");
String dashBoardLink = SambaashUtil.getDashBoard();

String leftModel = renderRequest.getPreferences().getValue("leftModel","");
String rightModel = renderRequest.getPreferences().getValue("rightModel","");
%>
<c:set var="leftModel" value="<%= leftModel %>"/>
<c:set var="rightModel" value="<%= rightModel %>"/>


<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span>Entity Linking</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
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
	<div class="formRoot">
		<div class="innerFormRoot">
	<form class="formContainer" id="mappingform" >
	<div class="container entitylink">
		<aui:row cssClass="entityTab">
			<aui:col span="6" cssClass="text-center posRelative"><em class="progIcon"></em><select><option><%= leftModel.toUpperCase() %></option></select></aui:col>
			<aui:col span="6" cssClass="text-center posRelative"><em class="subIcon"></em><select><option><%= rightModel.toUpperCase() %></option></select></aui:col>
		</aui:row>
		<aui:row cssClass="entitylinkBox">
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
				<div class="linkDot">
					<aui:row>
						<aui:col span="12">
							<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="left" placeholder="Search for a ${leftModel} title or code" onchange="getList('programme','left');"></aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						
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
						<div class="programmeDiv">
						</div>
					</aui:row>
				</div>
				</div>
			</aui:col>
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
				<div class="linkDot rightsidedot">
					<aui:row>
						<aui:col span="12">
						<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="right" placeholder="Search for a ${rightModel} title or code" onchange="getList('Subject','right');"></aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						 
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
							<div class="subjectDiv">
						</div>
					</aui:row>
					</div>
				</div>
			</aui:col>
			<div class="msg">Search and add entities for mapping</div>
		</aui:row>
		
			
		<aui:row cssClass="entityNextAction">
			<aui:col span="4"></aui:col>
			 <aui:col span="4" cssClass="text-center">
				<button class="btn btn-primary" type="button" id="next_btn" onclick="showSubType()">NEXT</button> 
				<button class="btn btn-default" type="button" onclick="reset1()">CANCEL</button>
			</aui:col>
			
		</aui:row>
		<aui:row cssClass="addEntityDetails" style="display:none">
			<aui:row><aui:col span="12" cssClass="text-center"><h2>ADD DETAILS</h2></aui:col></aui:row>
			<aui:row>
				<aui:col span="2"></aui:col>
				<aui:col span="4" cssClass="text-center">
					<label class="text-left">Subject Sub Type</label>
					<select id="inp_subject_sub_type"></select>
				</aui:col>
				<aui:col span="4" cssClass="text-center">
					<label class="text-left">Waive Fee</label>
					<select id="inp_waivefee"><option>Choose One or more fee category</option></select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="4"></aui:col>
				<aui:col span="4" cssClass="publishDetails text-center">
					 <button class="btn btn-primary" type="button" onClick="saveLink()">PUBLISH</button> 
				 	 <button class="btn btn-default" type="button" onclick="reset1()">CANCEL</button>
				</aui:col>
			</aui:row>
		</aui:row>
		
	</div>
	</form>
	</div>
	</div></div>
	
<div id="sucess-popup" hidden="true" class="modalpopupBox">
   <div id="sucess-popup-box" class="modalpopupContent">
   <form class="formContainer" >
     <aui:row>
         <aui:col span="12">
       	  <h3 id ="popup-msg">Linked Successful</h3>
       	  </aui:col>
       
     </aui:row>
     <aui:row>
      	<aui:col span="12">
      		<button class="btn btn-primary  pull-left" onClick="reloadPage()">Start Again</button>
      		<button class="btn btn-default pull-right" type="button" onClick="moveToDashboard()">BACK TO HOME</button>
      	</aui:col>
     </aui:row>
           
   </form>
   </div>

	



	</div>
		<div class="yui3-skin-sam">
			<div id="deactivation-success" hidden="true" class="modalpopupBox">
				<div id="inactive-success-box" class="modalpopupContent smilly-icon">
					<form class="formContainer ">
						<aui:row>
							<aui:col span="12" cssClass="text-center">

								<h3>
									Are you sure about delinking these entities.
								</h3>
								<p></p>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="userAction">
								<button type="button" class="btn btn-primary closeBtn"
									>yes</button>
									<button type="button" class="btn btn-primary noButton"
									>No</button>
							</aui:col>
						</aui:row>
					</form>
				</div>
			</div>
		</div>
<div id="overwrite-popup" hidden="true" class="modalpopupBox">
   <div id="overwrite-popup-box" class="modalpopupContent">
   <form class="formContainer" >
     <aui:row>
         <aui:col span="12">
       	  <h3>Choosing multiple "Programme" will reset the previous links to this Programme. </h3>
       	  </aui:col>
       
     </aui:row>
     <aui:row>
      	<aui:col span="12" cssClass="text-center">
      		<button type="button" class="btn btn-primary  closeBtn" >OK</button>
      		<button type="button" class="btn btn-default  cancelBtn" >CANCEL</button>
      	</aui:col>
     </aui:row>
           
   </form>
   </div>
</div>
<portlet:resourceURL var="elastisearchlisturl">
		<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>
</div>

<script type="text/javascript">
var modelLeft = "<%= leftModel %>";
var modelRight = "<%= rightModel %>";
var mode = "edit";
var formType="EntityLink";
var fetchLeftLinkType = "ProgrammeEntityLink";
var namespace = "<portlet:namespace/>";
var subjectSubTypeURL = "<%= subjectSubTypeURL%>";
var waiveFeeListURL = "<%= waiveFeeListURL%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var leftSideList = [],rightSideList = [],selectedLeftModel = [],selectedRightModel = [],elem1;
var ajaxUrl = "<%= ajaxUrl.toString() %>";
var listElement = document.getElementById("listElement");
var listElement = document.getElementById("listElement");
var liAnchorElement  = document.getElementById("liAnchorElement");
var selectedItem;
var entitySearch;
var eee;
var inp_waivefee,inp_subject_sub_type;




function getList(modelName,side){
	var listingDiv;
	var data = {"limit":1000,"modelName":modelName,"page":0,"formType":modelName};
	var jobValue = document.getElementById(namespace + side).value ;
	var filter = {};
	var filterdata = [];
	filter["contentJson.Status"] = ["Active"];	
	filterdata.push(filter);
	data["filterdata"]=filterdata;
	data["conditions"]=[jobValue];	
	data["searchIn"]=[];	
	var sortby = [];
	if(side == "left"){
		data["sortby"] = [{"direction":"asc","field":"ProgrammeTitle","contentJSON":"true"}];	
		data["searchIn"]= ['contentJson.ProgrammeTitle','contentJson.ProgrammeCode'];
	}else{
		data["sortby"] = [{"direction":"asc","field":"SubjectTitle","contentJSON":"true"}];	
		data["searchIn"]= ['contentJson.SubjectTitle','contentJson.SubjectCode'];
	}
	
	ajaxCall('GET','elastiSearchList',elastisearchlisturl,data,
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
	                reloadListing(listingDiv,tableData);
	               
	            }
	        },
	        function() {
	            
	 		});
}
function reloadListing(div,data){		
	if(div == "programmeDiv"){
		var myNode = document.getElementsByClassName("programmeDiv")[0];
		while (myNode.firstChild) {
		    myNode.removeChild(myNode.firstChild);
		}	
	}
	if(div == "subjectDiv"){
		var myNode = document.getElementsByClassName("subjectDiv")[0];
		while (myNode.firstChild) {
		    myNode.removeChild(myNode.firstChild);
		}	
	}
	for(var i =0; i <data.length; i++){
		var obj = {};
		if(div == "programmeDiv"){
			obj.key = data[i].contentJson.ProgrammeCode;
			obj.value = data[i].contentJson.ProgrammeTitle;
			leftSideList.push(obj);
			
			var clone = listElement.cloneNode(true);
			clone.style.display = "block";
			clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","showOverwiteAlert(this,'left');");
			clone.getElementsByClassName("listSpanTitle")[0].innerHTML =  "[" + obj.key + "] " + obj.value;
			clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
			document.getElementsByClassName(div)[0].appendChild(clone);
		}else if(div == "subjectDiv"){
			obj.key = data[i].contentJson.SubjectCode;
			obj.value = data[i].contentJson.SubjectTitle;
			rightSideList.push(obj);
			var clone = listElement.cloneNode(true);
			clone.style.display = "block";
			clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","checkmodifyList(this,'right');");
			clone.getElementsByClassName("listSpanTitle")[0].innerHTML =  "[" + obj.key + "] " + obj.value;
			clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
			document.getElementsByClassName(div)[0].appendChild(clone);
		}
		
	}
}
function reset1(){
	checkNone(document.getElementById("checkNoneLeft"),"left");
	checkNone(document.getElementById("checkNoneRight"),"right");
	var x = document.getElementsByClassName("selectedItem");
	var i;
	for (i = 0; i < x.length; i++) {
	    x[i].innerHTML= "<ul></ul>";
	}
	document.getElementsByClassName("entityNextAction")[0].style.display = "block";	
	document.getElementsByClassName("addEntityDetails")[0].style.display = "none";	
	document.getElementById("mappingform").reset();
	document.getElementById("next_btn").disabled = true;
}

AUI().use('event-base', function (A) {
	A.on('domready', function () {
		getList(modelLeft,"left");	
		getList(modelRight,"right");
		getSubjectSubType();
		getWaiveFee();
		var data = document.getElementsByClassName('control-label');
		data[0].style.display = "none";
		var data = document.getElementsByClassName('control-label');
		data[1].style.display = "none";
	});    
});
function showNextBtn(){
	if(selectedLeftModel.length > 0 && selectedRightModel.length > 0){
		document.getElementById("next_btn").disabled = false;
	}else{
		document.getElementById("next_btn").disabled = true;
		document.getElementsByClassName("addEntityDetails")[0].style.display = "none";
	}
}

function saveLink(){
	var records = [];
	
	for(var i =0; i < selectedLeftModel.length; i++){
		for(var j =0; j < selectedRightModel.length; j++){

			var StorageIdRight="";
			var StorageIdRight1="";
			var StorageIdLeft="";
			var StorageIdLeft1="";
			
			if (selectedRightModel[j].key.includes(' -- ')){
				StorageIdRight=selectedRightModel[j].key.substr(0, selectedRightModel[j].key.indexOf(' -- ')); 
				StorageIdRight1=selectedRightModel[j].key.substr(selectedRightModel[j].key.indexOf(' -- ')+4, selectedRightModel[j].key.length); 
			}else{
				StorageIdRight=selectedRightModel[j].key;
			}
			
			if (selectedLeftModel[i].key.includes(' -- ')){
				StorageIdLeft=selectedLeftModel[i].key.substr(0, selectedLeftModel[i].key.indexOf(' -- ')); 
				StorageIdLeft1=selectedLeftModel[i].key.substr(selectedLeftModel[i].key.indexOf(' -- ')+4, selectedLeftModel[i].key.length); 
			}else{
				StorageIdLeft=selectedLeftModel[i].key;
			}
			var record = {
					"StorageIdRight":StorageIdRight,
					"StorageIdRight1":StorageIdRight1,
					"StorageIdLeft":StorageIdLeft,
					"StorageIdLeft1":StorageIdLeft1,
			}
			records.push(record);
			
		}
	}
	var data = {
			"linkType":"ProgrammeEntityLink",
			"formType":"EntityLink",
			"ModelRight":modelRight,
			"ModelLeft":modelLeft,
			"ModelLeft1":"",
			"ModelRight1":"",
			"records":records,
			"SubjectSubType":inp_subject_sub_type.value,
			"WaiveFee":inp_waivefee.value
			
			
			};
	ajaxCall('GET','persist',ajaxUrl,data,
	function() {
        var data = this.get("responseData");
        if (_.isEmpty(data)) {
            console.log("error");
        } else {
        	var popup_msg = document.getElementById("popup-msg");
        	popup_msg.innerText = "Linked Successful";
        	showSuccessfulMsg();
        }
    },
    function() {
    	 console.log("error");
		});
	
}



function showSubType(){
	document.getElementsByClassName("addEntityDetails")[0].style.display = "block";	
	document.getElementsByClassName("entityNextAction")[0].style.display = "none";	

}
function getSubjectSubType(){
	ajaxCall('GET','vocabulary',subjectSubTypeURL,{},
	 function() {
          var data = this.get("responseData");
          if (_.isEmpty(data)) {
              console.log("error");
          } else {
        	inp_subject_sub_type = document.getElementById("inp_subject_sub_type");
  			for(var i = 0; i <  data.length; i++) {
  				inp_subject_sub_type.options[inp_subject_sub_type.options.length] = new Option(data[i].name, data[i].name);
  			}
          }
      },
      function() {
    	  
	});
}
function getWaiveFee(){
	ajaxCall('GET','vocabulary',waiveFeeListURL,{},
	 function() {
          var data = this.get("responseData");
          if (_.isEmpty(data)) {
              console.log("error");
          } else {
          	inp_waivefee = document.getElementById("inp_waivefee");
			for(var i = 0; i <  data.length; i++) {
				inp_waivefee.options[inp_waivefee.options.length] = new Option(data[i].name, data[i].name);
			}
          }
      },
      function() {
          
	});
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