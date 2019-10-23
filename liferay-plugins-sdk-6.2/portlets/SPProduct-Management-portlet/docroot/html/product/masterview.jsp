<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>

<portlet:defineObjects />

<c:set var="formStorageId" value='<%= request.getParameter("storageId") %>' />
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />



<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<portlet:renderURL var="programmeDetailUrl">
	<portlet:param name="jspPage" value="/html/product/view.jsp" />
	<portlet:param name="formTypeName" value="Programme" />
	<portlet:param name="storageId" value="${formStorageId}" />
</portlet:renderURL>


<% String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();

%>


<div class ="programmeTr" style="display: none">
	<div class= "programmeTrKey">
		Code
	</div>
	<div class= "programmeTrValue">
		BSBFOO1
	</div>
</div>
<div class="newPortlets">

<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>Programme Master View</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</aui:a></aui:col>
			</aui:row>
		</div>
	</div>

 <h4 class="header toggler-header-collapsed subjectRecord" style="display:none;">
	<div class="" >
	  	<span class="subjectTitle">Subject Title</span>
	  	<span class="subjectType">Subject Type</span>
	  	<span class="subjectSubType">Subject Sub Type</span>
		<ul>
			<li>
				<span class="copy"></span>
			</li>
			<li>
				<span class="closed"></span>
			</li>
		</ul>
	</div>
						  	
</h4>	


	<div class="toggleList pricingRecord" style="display:none;">
	  	 <h4 class="header toggler-header-collapsed">
	  	 
	  	 	<span class="storageId" style="display:none;"></span>
	  	 	<span class="PricingTitle">Pricing Title</span>
	  	 	<span class="PricingType" style="margin-left: 79px;">Pricing Type</span></h4>
	  	  <div class="zindexChange">
		  			<ul>
		  			<li>
		  				<span class="copy" onclick="SchemeDetail(this)"></span>
		  			</li>
		  			<li>
		  				<span class="closed"></span>
		  			</li>
		  		</ul>
		  	</div>
	  		<div class="content toggler-content-collapsed subfeeList">	</div>  
			<div class="content toggler-content-collapsed">This option has been set to <span>false</span> so that content starts as toggled off on page load.</div>
	 </div>


<h4 class="header subpricingRecord" style="display:none;">
	<div class="" >
		<span class="storageId" style="display:none;"></span>
	  	<span class="PricingTitle">Pricing Title</span>
	  	<span class="PricingType" style="margin-left: 120px;">Pricing Type</span>
	  	<span class="PricingSubType" style="margin-left: 120px;">Pricing Sub Type</span>
		<ul>
			<li>
				<span class="copy" onclick="SubSchemeDetail(this)"></span>
			</li>
			<li>
				<span class="closed"></span>
			</li>
		</ul>
	</div>
						  	
</h4>	
<div class="moredetail" style="display:none" > <input type="button" class="btn btn-default" onclick="openDetailpage();" value = "MORE DETAILS" /> </div>

	<div class="sambaashContent">
		<div class="container masterView">
			<aui:row>
					<aui:col span="10" cssClass="offset1">
				<aui:row>
					<aui:col span="12" cssClass="text-center">
						<p id ="programmeName">BSBF001 - Bachelors of Science in Banking and Finance</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="text-center">
						<div id="myToggler">
							<div class="toggleList">
						  		<h4 class="header toggler-header-collapsed">Programme Overview</h4>
						 		<div class="zindexChange">
									 <ul class="dateSelect">
							  			<li class="schedule">
							  				<select name="schedules" id="schedules" onChange="getPricingSchemes()">
							  					<option>Select</option>
							  				</select>
							  			</li>
							  			<span class="shedule-close"></span></li>
							  			<li>
							  				<span class="copy"></span>
							  			</li>
							  			<li>
							  				<span class="closed"></span>
							  			</li>
							  		</ul>
						  		</div>
						 		<div class="content toggler-content-collapsed programmeDiv"></div>
						  </div>
						  <div class="toggleList">
						  	<h4 class="header toggler-header-collapsed">Subjects</h4>
							  <div class="zindexChange">
							  			<ul>
							  			<li>
							  				<span class="copy"></span>
							  			</li>
							  			<li>
							  				<span class="closed"></span>
							  			</li>
							  		</ul>
							  	</div>
						  		<div class="content toggler-content-collapsed subjectList">	</div>  
								<div class="content toggler-content-collapsed">This option has been set to <span>false</span> so that content starts as toggled off on page load.</div>
						  </div>
						  <div class="toggleList">
						  	 <h4 class="header toggler-header-collapsed">PRICING SCHEME</h4>
						  	  <div class="zindexChange">
							  			<ul>
							  			<li>
							  				<span class="copy"></span>
							  			</li>
							  			<li>
							  				<span class="closed"></span>
							  			</li>
							  		</ul>
							  	</div>
						  		<div class="content toggler-content-collapsed feeList">	</div>  
								<div class="content toggler-content-collapsed">This option has been set to <span>false</span> so that content starts as toggled off on page load.</div>
						 </div>
						 
						</div>
					</aui:col>
				</aui:row>
			</aui:col>
			</aui:row>
		</div>
	</div>
</div>
<!-- END PROGRAMME MASTER VIEW -->
<script>
YUI().use(
  'aui-toggler',
  function(Y) {
    new Y.TogglerDelegate(
      {
        animated: true,
        closeAllOnExpand: true,
        container: '#myToggler',
        content: '.content',
        expanded: false,
        header: '.header',
        transition: {
          duration: 0.2,
          easing: 'cubic-bezier(0, 0.1, 0, 1)'
        }
      }
    );
  }
);
		
var formType = "${formType}";
var namespace =  "<portlet:namespace />";
var formStorageId = "${formStorageId}";
var programmeCode = formStorageId;
var ajaxUrl =  "${resourceURL}";
var programmeDetailUrl = "${programmeDetailUrl}";
var programmeTr = document.getElementsByClassName("programmeTr")[0];
var programmeDiv = document.getElementsByClassName("programmeDiv")[0];
var subjectList =  document.getElementsByClassName("subjectList")[0];
var feeList =  document.getElementsByClassName("feeList")[0];
var subjectRecord =  document.getElementsByClassName("subjectRecord")[0];
var pricingRecord =  document.getElementsByClassName("pricingRecord")[0];
var subpricingRecord =  document.getElementsByClassName("subpricingRecord")[0];
var programmeData;
function getProgrammeDetail(){
	var data = {}; 
	mode = "edit";
	data.formStorageId = formStorageId; 
	data.formType = "programme";   
	ajaxCall('POST', "loadData",ajaxUrl, data, function() {
		var	data = this.get("responseData");
		if (data.error) {
			displayMessage('danger', data.error);
		} else { 
			console.log(data);
			programmeData = data.contentJson;
			var keys = ["ProgrammeCode","ProgrammeTitle","RegulationType","WithCoursework","Status"];
			document.getElementById("programmeName").innerHTML = programmeData[keys[0]] + "-"+ programmeData[keys[1]];
			for(var i = 0; i < keys.length; i++){
				var clone = programmeTr.cloneNode(true);
				clone.style.display = "block";
				
				clone.getElementsByClassName("programmeTrKey")[0].innerHTML =  capitalizeFirstLetter(keys[i].replace(/([A-Z])/g, " $1"));
				if(keys[i] == "Status"){
					clone.getElementsByClassName("programmeTrValue")[0].classList.add("formStatus");
					if(programmeData[keys[i]] == "Active"){
						clone.getElementsByClassName("programmeTrValue")[0].classList.add("form_active");
					}
					if(programmeData[keys[i]] == "Inactive"){
						clone.getElementsByClassName("programmeTrValue")[0].classList.add("form_inactive");
					}
				}
				clone.getElementsByClassName("programmeTrValue")[0].innerHTML = programmeData[keys[i]];
				programmeDiv.appendChild(clone);
				
			}
			
			
			getSubjects(formStorageId);
		}
	}, function() {
		displayMessage('danger',"Error in persisting dynamic form data.");
		// thisInstance.debug("Error in persisting dynamic form data.");
	});	
	
}
var routeCodes = [];
var routes = "";
function getSemesters(programmeCode){
	
	AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
		var _data = {};
		var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/21424/query-by-example-json-string/{   ModelLeft:'Schedule',   ModelRight:'Programme',StorageIdRight:'"+ programmeCode +"'}/-return-field-list/retrieve-model-details/ModelLeft,ModelRight/flatten/true";
		A.io.request(qq, {
			dataType : 'json',
			method : "GET",
			data : _data,
			on : {
				success : function() {
				      var data = this.get("responseData");
				      if (_.isEmpty(data)) {
				        console.log("error");
				      } else {
				    	  schedules = document.getElementById('schedules');
				    	  console.log(data);
				    	  
				    	  
				    	  for(var i =0; i < data.length; i++ ){
				    		  schedules.options[schedules.options.length] = new Option(data[i].ScheduleCode +" - " + data[i].Name, data[i].ScheduleCode);
				    		  routes += data[i].RouteCode + ", ";
				    		  routeCodes.push(data[i].RouteCode);
				    	  }
				    	  
				    	var clone = programmeTr.cloneNode(true);
						clone.style.display = "block";
						clone.classList.add("routeTr");
						clone.getElementsByClassName("programmeTrKey")[0].innerHTML =  "Route Code";
						clone.getElementsByClassName("programmeTrValue")[0].classList.add("routeTdValue");
						clone.getElementsByClassName("programmeTrValue")[0].innerHTML = routes;
						programmeDiv.appendChild(clone);
						
						moredetail = document.getElementsByClassName("moredetail")[0];
						moredetail.style.display = "block";
						programmeDiv.appendChild(moredetail);
				      }
				    },
				failure : function() {

				}
			}
		});
	});
}
function getPricingSchemes(){
	var schedules = document.getElementById('schedules');
	var scheduleCode  =  schedules.value;
	var selectedIndex = schedules.selectedIndex - 1 ;
	if(selectedIndex >= 0){
		var routeCode = routeCodes[selectedIndex];
		document.getElementsByClassName("routeTdValue")[0].innerHTML = routeCode;
	
		AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
			var _data = {};
			var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/21424/query-by-example-json-string/{   ModelLeft:'Schedule',   ModelRight:'PriceScheme',  ModelLeft1:'Programme',StorageIdLeft:'"+ scheduleCode +"',StorageIdLeft1:'"+ programmeCode +"'}/-return-field-list/retrieve-model-details/ModelLeft,ModelRight/flatten/true";
			A.io.request(qq, {
				dataType : 'json',
				method : "GET",
				data : _data,
				on : {
					success : function() {
					      var data = this.get("responseData");
					      if (_.isEmpty(data)) {
					        console.log("error");
					      } else {
					    	  console.log(data);
					    	  for(var i =0; i < data.length; i++ ){
					    		  
					    		var clone = pricingRecord.cloneNode(true);
			           			clone.style.display = "block";
			           			clone.getElementsByClassName("storageId")[0].innerHTML = data[i].PricingSchemeCode;
			    				clone.getElementsByClassName("PricingTitle")[0].innerHTML = data[i].PricingSchemeCode + " - " + data[i].PricingSchemeName;
			    				clone.getElementsByClassName("PricingType")[0].innerHTML = data[i].PricingType;
			    				//clone.getElementsByClassName("PricingSubType")[0].innerHTML = data[i].PricingType;
			    				var SubSchemeDetails = JSON.parse( data[i].SubSchemeDetails);
			    				
			    				for(var j =0; j < SubSchemeDetails.length; j++ ){
			    					var clone1 = subpricingRecord.cloneNode(true);
				           			clone1.style.display = "block";
				           			clone1.getElementsByClassName("storageId")[0].innerHTML = SubSchemeDetails[j].priceSubSchemeId;
				           			clone1.getElementsByClassName("PricingTitle")[0].innerHTML = SubSchemeDetails[j].priceSubSchemeId ;
				    				clone1.getElementsByClassName("PricingType")[0].innerHTML = SubSchemeDetails[j].ccyCode;
				    				clone1.getElementsByClassName("PricingSubType")[0].innerHTML = SubSchemeDetails[j].amount;
				    				
			    					clone.getElementsByClassName("subfeeList")[0].appendChild(clone1); 
			    					
			    				}
			    				
			    				feeList.appendChild(clone);
					    	  }
					      }
					    },
					failure : function() {
	
					}
				}
			});
		});
	}else{
		document.getElementsByClassName("routeTdValue")[0].innerHTML = routes;
	}
}

var response = "";
var subjectsList = [];
function getSubjects(programmeCode){
	
	AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
		var _data = {};
		var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/21424/query-by-example-json-string/{   ModelLeft:'Programme',   ModelRight:'Subject',StorageIdLeft:'"+ programmeCode +"'}/-return-field-list/retrieve-model-details/ModelLeft,ModelRight/flatten/true";
		A.io.request(qq, {
			dataType : 'json',
			method : "GET",
			data : _data,
			on : {
				success : function() {
				      var data = this.get("responseData");
				      if (_.isEmpty(data)) {
				        console.log("error");
				      } else {
				    	  
				    	  console.log(data);
				    	  for(var i =0; i < data.length; i++ ){
				    		  
				    		var clone = subjectRecord.cloneNode(true);
		           			clone.style.display = "block";
		    				clone.getElementsByClassName("subjectTitle")[0].innerHTML = data[i].SubjectCode + " - " + data[i].SubjectTitle;
		    				clone.getElementsByClassName("subjectType")[0].innerHTML = data[i].SubjectType;
		    				clone.getElementsByClassName("subjectSubType")[0].innerHTML = data[i].SubjectSubType;
		    				
		    				subjectList.appendChild(clone);
				    	  }
				      }
				    },
				failure : function() {

				}
			}
		});
	});

}
function getAllSubjects(programmeCode){
	
 	var data1 = {"limit":400,"modelName":"Subject","page":0,"formType":"Subject"};
 	data1.conditions = [];
 	data1.sortBy = "contentJson.SubjectCode";
 	ajaxCall('GET','searchList',ajaxUrl,data1,
		 function() {
           response = this.get("responseData");
           if (_.isEmpty(response)) {
               console.log("error");
           } else {
           	 console.log(response);
           	for(var i = 0; i < response.totalElements; i++){
           		if(subjectsList.indexOf( response.content[i].contentJson.SubjectCode) > -1){
           			var clone = subjectRecord.cloneNode(true);
           			clone.style.display = "block";
    				clone.getElementsByClassName("subjectTitle")[0].innerHTML = response.content[i].contentJson.SubjectTitle;
    				clone.getElementsByClassName("subjectType")[0].innerHTML = response.content[i].contentJson.SubjectType;
    				clone.getElementsByClassName("subjectSubType")[0].innerHTML = response.content[i].contentJson.SubjectSubType;
    				
    				subjectList.appendChild(clone);
           			
           		}
				
			}
           }
       },
       function() {
           
		});

}

AUI().use('event-base', function (A) {
	A.on('domready', function () {
		getProgrammeDetail();	
		getSemesters(formStorageId);
	});    
});

function openDetailpage(){
	window.location.href = programmeDetailUrl;
}
function SubSchemeDetail(elem){
	
	var subschemeId = elem.parentElement.parentElement.parentElement.getElementsByClassName("storageId")[0].innerText
	window.location.href="/price-sub-scheme?p_p_id=pricesubscheme_WAR_SPPricingEngineportlet&p_p_lifecycle=0&p_p_state=normal&_pricesubscheme_WAR_SPPricingEngineportlet_jspPage=%2Fhtml%2Fpricesubscheme%2Fview.jsp&_pricesubscheme_WAR_SPPricingEngineportlet_formTypeName=PriceSubScheme&_pricesubscheme_WAR_SPPricingEngineportlet_storageId="+subschemeId;
}
function SchemeDetail(elem){
	
	var schemeId = elem.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("storageId")[0].innerText
	window.location.href="/price-scheme?p_p_id=pricescheme_WAR_SPPricingEngineportlet&p_p_lifecycle=0&p_p_state=normal&_pricescheme_WAR_SPPricingEngineportlet_jspPage=%2Fhtml%2Fpricescheme%2Fview.jsp&_pricescheme_WAR_SPPricingEngineportlet_formTypeName=PriceScheme&_pricescheme_WAR_SPPricingEngineportlet_storageId="+schemeId;
}



</script>
<style>
.formStatus{
    width: 78px !important;
    padding: 4px 10px !important;
    border-radius: 24px;
    text-align: center !important;
    margin-top: 10px;

}
</style>