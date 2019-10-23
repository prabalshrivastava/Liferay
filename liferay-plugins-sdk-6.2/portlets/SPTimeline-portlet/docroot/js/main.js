function jsElasticSearchList(event ,value){
	getProcessList();
}
function showPageList(index){
	pageIndex=(index-1);
	getProcessList();
}
function changeItemsPerPage(){
	activitylogLimit = this.value;
	pageIndex=0;
	getProcessList();
}
function onDateSelect(){
	getProcessList();
}

var inProcess = false;

function drawListTable(){
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}
	if(listOfEnquiry.length == 0 ){
		document.getElementsByClassName("no-data-listing")[0].style.display = "";
		document.getElementsByClassName("pagination")[0].style.display = "none";
	}else{
		document.getElementsByClassName("no-data-listing")[0].style.display = "none";
		document.getElementsByClassName("pagination")[0].style.display = "";
		for(var i=0;i< listOfEnquiry.content.length;i++){
			var cRow=baseRow.cloneNode(true);	
			var ee = new Date(Date.parse(listOfEnquiry.content[i].createdDate));
			var date = (ee.getDate()  + '/' + (ee.getMonth() + 1) +  '/' +  ee.getFullYear() + ' ' + ('0' +ee.getHours()).slice(-2) +":" + ('0' +ee.getMinutes()).slice(-2));
			
			cRow.getElementsByClassName("info")[0].innerHTML=listOfEnquiry.content[i].contentJson.title;
			cRow.getElementsByClassName("info-date")[0].innerHTML= date;
			//cRow.getElementsByClassName("status")[0].innerHTML=listOfEnquiry.content[i].contentJson.status;
			cRow.getElementsByClassName("timeline-detail")[0].setAttribute("href",listOfEnquiry.content[i].contentJson.actionLink);
			if(listOfEnquiry.content[i].contentJson.actionLink == ""){
				cRow.getElementsByClassName("timeline-detail")[0].setAttribute("href","javascript:void(0);");
			}
			switch (listOfEnquiry.content[i].contentJson.status) {
			case "Approved":
				cRow.getElementsByClassName("status")[0].classList.add("btn-success");
				break;
			case "Started":
				cRow.getElementsByClassName("status")[0].classList.add("btn-info");
				break;
			case "Rejected":
				cRow.getElementsByClassName("status")[0].classList.add("btn-default");
				break;
			default:
				break;
			}
			tbody.appendChild(cRow);
		}
	}
	

	YUI().use("node", "event", function(A) {
		var j = A.all(".threedot");
		j.on("click", function(o) {
			o.preventDefault();
			o.stopPropagation();
			var p = document.getElementsByClassName("Pop-Action");
			for (var l = 0; l < p.length; l++) {
				p[l].classList.add("hide")
			}
			var m = o.currentTarget;
			var n = m.next();
			n.removeClass("hide")
		})
	})
	YUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
			'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A){

		var container = A.one('body');
		container.on('click', function(e){
			var actionsBox = document.getElementsByClassName('Pop-Action');
			for(var k = 0;k< actionsBox.length;k++){
				actionsBox[k].classList.add('hide');
			}
		});

	});
}
function makePaging(totalPages, pageIndex) {
	var oPaging, i, j, k;
    var totalPages = parseInt(totalPages);
    pageIndex++;
    i = pageIndex;
    j = pageIndex - 1;
    k = pageIndex + 1;
    var oBefore = "", oAfter= "";
    var disable = false;
    if(i<=1) {
    	disable = true;
    }
    while (j != 0 && j != i - 6 && j>0) {
        oBefore = "<li id1='"+ j +"'><a  href='javascript:showPageList("+ j +")' data-index='" + (j - 1) + "'>" + j + "</a></li>" + oBefore;
        j--;
    }
    if(disable) {
    	oBefore = "<li id1='"+ (i-1) +"'><a class='prev' href='javascript:void(0)' data-index='" + (i-2) + "'>  </a></li>" + oBefore;
        oBefore = "<li id1='1'><a class='first' href='javascript:void(0)' data-index='1'>  </a></li>" + oBefore;
    } else {
    	oBefore = "<li id1='"+ (i-1) +"'><a class='prev' href='javascript:showPageList("+ (i-1) +")' data-index='" + (i-2) + "'>  </a></li>" + oBefore;
        oBefore = "<li id1='1'><a class='first' href='javascript:showPageList(1)' data-index='1'>  </a></li>" + oBefore;
    }
    for (; k <= totalPages && k < (i + 6) && k > 0; k++) {
        oAfter += "<li id2='"+ k +"'><a  href='javascript:showPageList("+ k +")' data-index='" + (k - 1) + "'>" + k + "</a></li>";
    }
    disable = false;
    if(i>=totalPages) {
    	disable = true;
    }
    if(disable) {
    	oAfter += "<li id2='"+ (i+1) +"'><a class='next' href='javascript:void(0)' data-index='" + (i) + "'>  </a></li>";
        oAfter += "<li id2='"+ (k-1) +"'><a class='last' href='javascript:void(0)' data-index='" + (k-2) + "'>  </a></li>";
    } else {
    	oAfter += "<li id2='"+ (i+1) +"'><a class='next' href='javascript:showPageList("+ (i+1) +")' data-index='" + (i) + "'>  </a></li>";
        oAfter += "<li id2='"+ (totalPages-1) +"'><a class='last' href='javascript:showPageList("+ totalPages +")' data-index='" + (totalPages-2) + "'>  </a></li>";
    }
    
    oPaging = "<ul  class='pagination-content'>" + oBefore + "<li id3='"+ i +"'><a class='selected' href='javascript:showPageList("+ i +")'>" + 
    i.toString() + "</a></li>" + oAfter + "</ul>";
    document.getElementById("jslarge").innerHTML = oPaging;
}

function doAction(action,d) {	 
	AUI().use('liferay-portlet-url', function(A) {
		var c = findAncestor(d, "Row");
		var a = [];
		for (var b = 0; b < c.childElementCount; b++) {
			a.push(c.children[b].textContent.trim())
		}
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		if(action == 'edit'){
			e.setParameter("jspPage", config.editPage);   
		}
		console.log(action);console.log(config);
		e.setParameter("formTypeName", modelName);

		e.setParameter("storageId", a[0]);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		console.log(e.toString());
		window.location.href = e.toString();
	});
}


function addNewRecord(d){
	AUI().use('liferay-portlet-url', function(A) {
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		jspPage = config.createPage;
		e.setParameter("formTypeName", modelName);
		e.setParameter("jspPage", jspPage);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		//window.location.href = e.toString();
		var pattern = /__/g;
		var dd = e.toString();
		window.location.href = dd.replace(pattern,"_");
	});
}
function findAncestor (el, cls) {
	while ((el = el.parentElement) && !el.classList.contains(cls));
	return el;
}
YUI().use(
		'aui-datepicker',
		function(Y) {
			new Y.DatePicker(
					{
						trigger: '#startDate',
						mask: '%d/%m/%Y',
						popover: {
							zIndex: 1
						},
						on: {
							selectionChange: function(event) {
								if (event.newSelection[0]) {
									setTimeout(function() { onDateSelect(); }, 500);
								}
								console.log(event.newSelection);
							}
						}
					}
			);
		}
);
YUI().use(
		'aui-datepicker',
		function(Y) {
			new Y.DatePicker(
					{
						trigger: '#endDate',
						mask: '%d/%m/%Y',
						popover: {
							zIndex: 1
						},
						on: {
							selectionChange: function(event) {
								if (event.newSelection[0]) {
									setTimeout(function() { onDateSelect(); }, 500);
								}
								console.log(event.newSelection)
							}
						}
					}
			);
		}
);