<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

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
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<liferay-theme:defineObjects />

<script>
var filter = ["contentJson.UserId="+"<%=  themeDisplay.getUserId() %>"];
</script>
<portlet:defineObjects />
<div class="topannouncement">

<div class="newPortlets1">
	<div class="inner-container W-1200">
	<div id='formio1' style="display: none;">
		<div class="dataListing">
			<div id="searchContainer" class="search-container container">
				
			</div>
			<div class="data-lising">
				<table id="tableIdTop" class="aui">
					<thead>
						<tr class="Heading">

						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<div class="pagination">
				<aui:row>
					<aui:col span="4" cssClass="text-left">


					</aui:col>
					<aui:col span="4">
						<ul>
							<li>
							
							<button class="btn btn-default" onclick="redirectannouncement()">SHOW ALL</button>
							
								
							</li>
							<li>
								<a href="javascript:void(0);" class="page-first" onclick="pageCall('first')"></a>
							</li>
							<li>
								<a href="javascript:void(0);" class="page-prev" onclick="pageCall('prev')"></a>
							</li>
							<li>
								<a href="javascript:void(0);" class="currentPage"  id="currentPage">1</a>
							</li>
							<li>
								<a href="javascript:void(0);" class="page-next" onclick="pageCall('next')"></a>
							</li>
							<li>
								<a href="javascript:void(0);" class="page-last"onclick="pageCall('last')"></a>
							</li>
							<li>
								<button class="btn btn-default" onclick="toggleNotifications()">CLOSE</button>
							</li>
						</ul>
					</aui:col>
					<aui:col span="4" cssClass="text-right myPagination aui-pagination">
						
					</aui:col>
				</aui:row>
			</div>
			<div class="no-data-listing" style="display: none">

				<div class="sambaashContent">
					<div class="container nodates">
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<h3 id="h3message" class="no-data-listing-message">
									No new Announcement</h3>
								<p id="pmessage" class="no-data-listing-message">
									There aren't any records of existing
									Announcements as of now. 
								</p>
								<a id="ahrefmessage" href="#link" title="BACK TO DASHBOARD"
									class="btn lightbluebtn">BACK TO DASHBOARD</a>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>

		</div>
		
	</div>
</div>
</div>
<portlet:resourceURL var="ajaxUrlTopAnnouncement">



</portlet:resourceURL>



<script type="text/javascript">
var namespaceTop = "<portlet:namespace/>";
var ajaxurlTop = "<%= ajaxUrlTopAnnouncement.toString() %>";
var pageRequestedTop = 1;
var modelNameTop = "UserAnnouncement";
var itemsPerPageTop = 10;
var currentPage=1;
var totalPages=1;

AUI().use('event-base', function (A) {
    A.on('domready', function () {
    	loadListTop();
    });
});

function pageCall(arg){
	console.log("Page Call = "+arg);
	switch (arg) {
	case "first":
		pageRequestedTop=1
		break;
	case "prev":
		if(pageRequestedTop>1){
			pageRequestedTop-=1;
		}
		break;
	case "next":
		if(totalPages>pageRequestedTop){
			pageRequestedTop+=1;
		}	
		break;
	case "last":
		pageRequestedTop=totalPages;
		break;

	default:
		break;
	}
	currentPage=pageRequestedTop;
	loadListTop();
}

function setItemsPerPage(e){
	var pageRequestedTop = 1;
	var currentPage=1;
	var totalPages=1;
	itemsPerPageTop=e.value;
	loadListTop();
}

function loadListTop(){
    
	itemsPerPageTop = 4;
 	var data = {"limit":itemsPerPageTop,"modelName":modelNameTop,"page":(pageRequestedTop - 1),"formType":modelNameTop}; 	
 	if( typeof filter !== 'undefined' && filter !== null ){ 
 		
 		data.conditions = filter;
 	}
 	
 	
 	data.sortBy = "contentJson.Message";
 	ajaxCallTop('GET','searchList',ajaxurlTop,data,
		 function() {
                var data = this.get("responseData");
                if (_.isEmpty(data)) {
                    console.log("error");
                    
                } else {
                	document.getElementById("currentPage").innerHTML=currentPage
                	tableData = data.content;
                	totalRecords = data.totalElements;
                	totalPages = data.totalPages;
                    reloadTableTop(tableData,false);
                    
                   
                }
            },
            function() {
                
     		});
	 
 
 }


function reloadTableTop(a,isSearchList) {
    var table = document.getElementById("tableIdTop");
    var tbody = document.querySelector("#tableIdTop tbody");
    var allheadings = document.querySelectorAll("#tableIdTop .Heading")[0];
   
    if(a.length > 0){
    	document.getElementById("formio1").style.display="block";
    	clearTableDataTop();
        var tr = document.createElement('tr');
        var td = document.createElement('td'); 
        var text = document.createTextNode("aaa"); 
        td.appendChild(text);
        td.className += "ann-category " ;
        tr.appendChild(td);
        for (var j = 1; j < 2; j++) {
    	    var td = document.createElement('td'); 
    	    var text = document.createTextNode("aaa");
    	    td.appendChild(text);
    	    td.className += "ann-message ";
    	    tr.appendChild(td);
    	}
        tr.className += "Row ";
        tr.style.display= "none";
        tbody.appendChild(tr);
        
        var e;
        var f = document.querySelector("#tableIdTop .Row").cloneNode(true);
        f.style.display= "";
        console.log(a);
        for (var c = 0; c < a.length; c++) {
        	var date1 = new Date(a[c].contentJson["BroadcastDateTime"]); 
            var rowclone = f.cloneNode(true);
            e = rowclone.querySelectorAll("td");
            e[0].innerHTML = a[c].contentJson["AnnouncementCategory"]; 
            e[1].innerHTML = "<div class='announcements'><div class='ann-time'>"+ date1.toDateString() + " " + date1.toLocaleTimeString()  +"</div><div class='ann-msg'>"+ a[c].contentJson["Message"] + "</div></div>";  
            table.appendChild(rowclone);
            
        }

        document.getElementsByClassName('data-lising')[0].style.display = "block";
        document.getElementsByClassName('pagination')[0].style.display = "block";
        document.getElementsByClassName('no-data-listing')[0].style.display = "none";
    }else{
    	document.getElementById("formio1").style.display="none";
    	document.getElementsByClassName('data-lising')[0].style.display = "none";
    	document.getElementsByClassName('pagination')[0].style.display = "none";
    	document.getElementsByClassName('no-data-listing')[0].style.display = "block";
    	if(!isSearchList) {	
    		document.querySelector("h3.no-data-listing-message").innerHTML="No " + modelNameTop  + " record present.";
    		document.querySelector("p.no-data-listing-message").innerHTML="There aren't any records of existing "+modelNameTop+"'s as of now.\nIf you would like to create a new one, please click on the 'ADD NEW' button.";
       	}
    	else {
    		document.querySelector("h3.no-data-listing-message").innerHTML="Search Results for " + modelNameTop;
    		document.querySelector("p.no-data-listing-message").innerHTML="No search results were found for your query"; 		
    	}    	
    }
    
}
function clearTableDataTop() {
    var a = document.getElementById("tableIdTop").getElementsByClassName("Row");
    while (a.length) {
        a[0].parentNode.removeChild(a[0])
    }
};
function ajaxCallTop(method, action,ajaxurlTop, data, successHandler, failHandler) {
	var thisInstance = this;
	
	thisInstance.namespaceTop = namespaceTop;
        AUI().use('aui-base','aui-io-request-deprecated',function(A){
            var _data = {};
            _data[thisInstance.namespaceTop + 'formStorageId'] = "";
            if(action == "update" || action == "loadData" || action == "loadList" || action == "archive"){
            	_data[thisInstance.namespaceTop + 'formStorageId'] =  data.formStorageId;
            }
            _data[thisInstance.namespaceTop + 'formType'] = data.formType;
            _data[thisInstance.namespaceTop + 'action'] = action;
            if(action == "update")
             _data[thisInstance.namespaceTop + 'action'] = "persist";
            if (data) {
                _data[thisInstance.namespaceTop + 'data'] = JSON.stringify(data);              
            }
            A.io.request(ajaxurlTop,{
                dataType : 'json', method : method,
                data : _data,
                on : {
                    success : successHandler,
                    failure : failHandler || function() {
                        thisInstance.debug("Error in the ajax call.");
                    }
                }
            });             
        });
}
function redirectannouncement(){
	window.location.href="<%= themeDisplay.getPortalURL()  %>/user-announcements";
}

</script>





</div>

