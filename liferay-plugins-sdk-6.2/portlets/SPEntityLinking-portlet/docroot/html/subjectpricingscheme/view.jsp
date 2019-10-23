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
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>


<portlet:defineObjects />
<portlet:resourceURL var="ajaxUrl" >

</portlet:resourceURL>

<portlet:resourceURL var="elastisearchlisturl">
		<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>
<%

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
			<aui:col span="10" cssClass="text-center"><h2><span>Subject - Pricing Linking</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Home</a></aui:col>
		</aui:row>
		</div>
	</div>
</div>


<ul>
	<li class="liAnchorElement" style="display:none" >
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
		<div id="myAutoComplete"></div>
		<aui:row cssClass="entitylinkBox">
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
					<aui:row>
						<aui:col span="12">
							<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="left" placeholder="Search for a ${leftModel} title or code" onchange="getList('Subject','left');"></aui:input>
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
			</aui:col>
			<aui:col span="6" cssClass="text-center rightside">
				<div class="entitySearch">
					<aui:row>
						<aui:col span="12">
						<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="right" placeholder="Search for a ${rightModel} title or code" onchange="getList('PriceScheme','right');"></aui:input>
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
			</aui:col>
			<div class="msg">Search and add entities for mapping</div>
		</aui:row>
		
		<aui:row cssClass="routeCode addEntityDetails" >
				
				<aui:col span="12" cssClass="text-center">
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					<aui:col span="4">
					<button class="btn btn-primary" id="next_btn" type="button" disabled="disabled" onClick="saveLink()">Save</button> 
				 	 <button class="btn btn-default"  onclick="reset1()" type="button">Clear</button>
					</aui:col>
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					 
	 			</aui:col>
			</aui:row>
			
		
		
		
	</div>
	</form>
	</div>
</div>


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
									Are you sure about delinking these intities.
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
       	  <h3>Choosing multiple "Schedule" will reset the previous links to this schedule. </h3>
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
</div>
</div>
<script type="text/javascript">
var modelLeft = "<%= leftModel %>";
var modelRight = "<%= rightModel %>";
var mode = "edit";
var namespace = "<portlet:namespace/>";

var formType="EntityLink";
var fetchLeftLinkType = "SubjectPriceSubSchemeEntityLink";
var leftSideList = [],rightSideList = [],selectedLeftModel = [],selectedRightModel = [],elem1;
var ajaxUrl = "<%= ajaxUrl.toString() %>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var listElement = document.getElementById("listElement");
var listElement = document.getElementById("listElement");

var liAnchorElement  = document.getElementsByClassName("liAnchorElement")[0];
var selectedItem;
var entitySearch;
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
	var sortby = [];
	if(side == "left"){
		data["sortby"] = [{"direction":"asc","field":"SubjectTitle","contentJSON":"true"}];	
		data["searchIn"]= ['contentJson.SubjectCode','contentJson.SubjectTitle'];
		
		filter["contentJson.Status"] = ["Active"];	
	}else{
		data["sortby"] = [{"direction":"asc","field":"PricingSchemeName","contentJSON":"true"}];	
		data["searchIn"]= ['contentJson.PricingSchemeCode','contentJson.PricingSchemeName'];
	}
	ajaxCall('GET','elastiSearchList',elastisearchlisturl,data,
	//ajaxCall('GET','loadList',ajaxUrl,data,
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
			var code = data[i].contentJson.SubjectCode
			var name = data[i].contentJson.SubjectTitle
			obj.key = code ;
			obj.value = name;
			
			leftSideList.push(obj);
			var clone = listElement.cloneNode(true);
			clone.style.display = "block";
			clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","showOverwiteAlert(this,'left');");
			clone.getElementsByClassName("listSpanTitle")[0].innerHTML =  "[" + obj.key + "] " + obj.value;
			clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
			document.getElementsByClassName(div)[0].appendChild(clone);
		}else if(div == "subjectDiv"){
			if(data[i].contentJson.hasOwnProperty('SubSchemeDetails')){
				var SFList=data[i].contentJson.SubSchemeDetails;
				for(var s =0; s <SFList.length; s++){
					var code = data[i].contentJson.PricingSchemeCode
					var name = data[i].contentJson.PricingSchemeName
					obj.key = code + ((SFList[s].priceSubSchemeId.length >0) ? ' -- '+ SFList[s].priceSubSchemeId : '');
					obj.value = name +((SFList[s].priceSubSchemeId.length >0) ? ' - '+SFList[s].priceSubSchemeId : '');
					rightSideList.push(obj);
					var clone = listElement.cloneNode(true);
					clone.style.display = "block";
					clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","checkmodifyList(this,'right');");
					clone.getElementsByClassName("listSpanTitle")[0].innerHTML =  "[" + obj.key + "] " + obj.value;
					clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
					document.getElementsByClassName(div)[0].appendChild(clone);
				}
			}else{
				obj.key = data[i].contentJson.PricingSchemeCode
				obj.value = data[i].contentJson.PricingSchemeName + rightSideList.push(obj);
				var clone = listElement.cloneNode(true);
				clone.style.display = "block";
				clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","modifyList(this,'right');");
				clone.getElementsByClassName("listSpanTitle")[0].innerHTML = obj.value;
				clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
				document.getElementsByClassName(div)[0].appendChild(clone);
			}
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
	document.getElementById("mappingform").reset();
	document.getElementById("next_btn").disabled = true;
}

AUI().use('event-base', function (A) {
	A.on('domready', function () {
		getList(modelLeft,"left");	
		getList(modelRight,"right");
		var data = document.getElementsByClassName('control-label');
		data[0].style.display = "none";
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
			"linkType":"SubjectPriceSubSchemeEntityLink",
			"formType":"EntityLink",
			"ModelRight":modelRight,
			"ModelLeft":modelLeft,
			"ModelLeft1":"",
			"ModelRight1":"PriceSubScheme",
			"records":records
			
			
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
}
</script>




<style>
.listSpanTitle{
    margin-left: 37px;
    width: 100% !important;
    text-align: left;
    margin-top: 20px !important;
   
}
.rightside .listSpanTitle{
	 height: 35px !important;
}

</style>
