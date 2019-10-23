<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<div class="topannouncement hide">

<div class="newPortlets1">
	<div class="inner-container W-1200">
	<div id='formio1'>
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
						<!--<aui:select cssClass="itemsPerPageTop" name="itemsPerPageTop"
							label="Items per page:">
							<aui:option value="5">5</aui:option>
							<aui:option value="10" selected="true">10</aui:option>
							<aui:option value="20">20</aui:option>
							<aui:option value="50">50</aui:option>
							<aui:option value="100">100</aui:option>
						</aui:select>-->

					</aui:col>
					<aui:col span="4">
						<ul>
							<li>
								<button class="btn btn-default">SHOW ALL</button>
							</li>
							<li>
								<a href="#link" class="page-first"></a>
							</li>
							<li>
								<a href="#link" class="page-prev"></a>
							</li>
							<li>
								<a href="#link" class="page-next"></a>
							</li>
							<li>
								<a href="#link" class="page-last"></a>
							</li>
							<li>
								<button class="btn btn-default">CLOSE</button>
							</li>
						</ul>
					</aui:col>
					<aui:col span="4" cssClass="text-right myPagination aui-pagination">
						<!--<div id="jslargeTop" class="pagination myPagination pagination-large"></div>-->
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
var itemsPerPageTop;

AUI().use('event-base', function (A) {
    A.on('domready', function () {
    	loadListTop();
    });
});
function loadListTop(){
    
	itemsPerPageTop = 10;
 	
 	var data = {"limit":itemsPerPageTop,"modelName":modelNameTop,"page":(pageRequestedTop - 1),"formType":modelNameTop};
 	if( typeof filter !== 'undefined' && filter !== null ){ 
 		data.filterdata = filter;
 	}
 	ajaxCallTop('GET','loadList',ajaxurlTop,data,
		 function() {
                var data = this.get("responseData");
                if (_.isEmpty(data)) {
                    console.log("error");
                    
                } else {
                	tableData = data.content;
                	totalRecords = data.totalElements;
                	totalPages = data.totalPages;
                    reloadTableTop(tableData,false);
                    if(pageRequestedTop == 1){
                    	drawPaginationTop(pageRequestedTop)
                    }
                   
                }
            },
            function() {
                
     		});
	 
 
 }
function drawPaginationTop(pageRequested){
	document.getElementById("jslargeTop").innerHTML = "";
	pageRequested = 0;
	makePagingTop(totalPages,pageRequested);
}
function makePagingTop(totalPages, pageIndex) {
    var oPaging, i, j, k;
    var totalPages = parseInt(totalPages);
    pageIndex++;
    i = pageIndex;
    j = pageIndex - 1;
    k = pageIndex + 1;
    var oBefore = "", oAfter= "";
    while (j != 0 && j != i - 6) {
        oBefore = "<li id1='"+ j +"'><a  href='javascript:showPage("+ j +")' data-index='" + (j - 1) + "'>" + j + "</a></li>" + oBefore;
        j--;
    }
    for (; k <= totalPages && k < i + 6; k++) {
        oAfter += "<li id2='"+ k +"'><a  href='javascript:showPage("+ k +")' data-index='" + (k - 1) + "'>" + k + "</a></li>";
    }
    oPaging = "<ul  class='pagination-content'>" + oBefore + "<li id3='"+ i +"'><a href='javascript:showPage("+ i +")'>" + 
    i.toString() + "</a></li>" + oAfter + "</ul>";
    
    document.getElementById("jslargeTop").innerHTML = oPaging;
    
}
function reloadTableTop(a,isSearchList) {
    var table = document.getElementById("tableIdTop");
    var tbody = document.querySelector("#tableIdTop tbody");
    var allheadings = document.querySelectorAll("#tableIdTop .Heading")[0];
   
    if(a.length > 0){
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
    	document.getElementsByClassName('data-lising')[0].style.display = "none";
    	document.getElementsByClassName('pagination')[0].style.display = "none";
    	document.getElementsByClassName('no-data-listing')[0].style.display = "block";
    	if(!isSearchList) {	
    		document.querySelector("h3.no-data-listing-message").innerHTML="No " + modelName  + " record present.";
    		document.querySelector("p.no-data-listing-message").innerHTML="There aren't any records of existing "+modelName+"'s as of now.\nIf you would like to create a new one, please click on the 'ADD NEW' button.";
       	}
    	else {
    		document.querySelector("h3.no-data-listing-message").innerHTML="Search Results for " + modelName;
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
</script>





</div>

