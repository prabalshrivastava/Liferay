<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page import="com.sambaash.platform.model.SPMailType" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>
<script src="//www.google.com/jsapi" type="text/javascript"  async=true></script>
<script src="<%= themeDisplay.getPathThemeJavaScript()+"/d3.v3.min.js" %>" type="text/javascript" async=true ></script>
<script src="<%= themeDisplay.getPathThemeJavaScript()+"/d3.tip.min.js" %>" type="text/javascript" async=true ></script>

<style type="text/css">

.slice text {
font-size: 10pt;
font-family: Arial;
}

.axis path,
.axis line {
fill: none;
stroke: #000;
shape-rendering: crispEdges;
}

.bar {
fill: #3182bd;
}

.bar:hover {
fill: #9ecae1 ;
}

.x.axis path {
display: none;
}

.d3-tip {
line-height: 1;
font-weight: bold;
padding: 12px;
background: rgba(0, 0, 0, 0.8);
color: #fff;
border-radius: 2px;
}

/* Creates a small triangle extender for the tooltip */
.d3-tip:after {
box-sizing: border-box;
display: inline;
font-size: 10px;
width: 100%;
line-height: 1;
color: rgba(0, 0, 0, 0.8);
content: "\25BC";
position: absolute;
text-align: center;
}

/* Style northward tooltips differently */
.d3-tip.n:after {
margin: -1px 0 0 0;
top: 100%;
left: 0;
}

.axis path, .axis line {
fill: none;
stroke: #000;
shape-rendering: crispEdges;
}

div.mask {
	z-index:1;
	width:100%;
	text-align:center;
}
</style>

<script type="text/javascript">

var eventsJSONObject = ${eventsJSONObject};
var rsvpJSONObject = ${rsvpJSONObject};
var assetJSONObject = ${assetJSONObject};
var campJSONObject = ${campJSONObject};
var m = 0;
function addFiltersHtml() {
	/* var eventDiv = document.getElementById("eventsDiv");
	var eventSelect = document.createElement("select");
	eventSelect.setAttribute("name","eventsSelect");
	eventSelect.setAttribute("id","eventsSelect");
	eventSelect.setAttribute("onChange","javascript:getRsvpDetail('filters')");
	var eventOption = document.createElement("Option");
	eventOption.setAttribute("value","0");
	eventSelect.appendChild(eventOption);
	for (key in eventsJSONObject) {
		eventOption=document.createElement("Option");
		eventOption.setAttribute("value",key);
		var optTextNode = document.createTextNode(eventsJSONObject[key]);
		eventOption.appendChild(optTextNode);
		eventSelect.appendChild(eventOption);
	}
	eventDiv.appendChild(eventSelect); */
	var campDiv = document.getElementById("campaignDiv");
	var rsvpDiv = document.getElementById("rsvpDiv");
	var campSelect = document.createElement("select");
	campSelect.setAttribute("name","campSelect");
	campSelect.setAttribute("id","campSelect");
	campSelect.setAttribute("onChange","javascript:getRsvpDetail('filters')");
	var campOption = document.createElement("Option");
	campOption.setAttribute("value","0");
	campSelect.appendChild(campOption);
	if ((Object.keys(campJSONObject).length) > 0) {
		for (key in campJSONObject) {
			campOption=document.createElement("Option");
			campOption.setAttribute("value",key);
			var optTextNode = document.createTextNode(campJSONObject[key]);
			campOption.appendChild(optTextNode);
			campSelect.appendChild(campOption);
		}
		campDiv.appendChild(campSelect)
	}else {
		document.getElementById("reportFilters").innerHTML = "No RSVP records available";
	}

	/* var assetDiv = document.getElementById("assetTypeDiv");
	var assetSelect = document.createElement("select");
	assetSelect.setAttribute("name","assetTypeSelect");
	assetSelect.setAttribute("id","assetTypeSelect");
	assetSelect.setAttribute("onChange","javascript:getRsvpDetail('filters')");
	var assetOption = document.createElement("Option");
	assetOption.setAttribute("value","0");
	assetSelect.appendChild(assetOption);
	for (key in assetJSONObject) {
		assetOption=document.createElement("Option");
		assetOption.setAttribute("value",key);
		var optTextNode = document.createTextNode(assetJSONObject[key]);
		assetOption.appendChild(optTextNode);
		assetSelect.appendChild(assetOption);
	}
	assetDiv.appendChild(assetSelect); */
}

function getRsvpDetail(type) {
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var type=type;

	var campSelect =0;
	var eventsSelect =0;
	var assetTypeSelect =0;
	var rsvpName = "RSVP - ";
	var eventName = "Event - ";
	var assetTypeName = "Contest - ";
	var chartName = "";
	var svg_xml1 = "";
	var svg_xml2 = "";
	var svg_xml3 = "";
	var svg_xml4 = "";
	var svg_xml5 = "";
	var svg_xml6 = "";
	var svg_xml7 = "";
	var svg_xml8 = "";
	var svg_xml9 = "";
	var svg_xml10 = "";
	var svg_xml11= "";
	var svgContent1 = "";
	var svgContent2 = "";
	var svgContent3 = "";
	var svgContent4 = "";
	var svgContent5 = "";
	var svgContent6 = "";
	var svgContent7 = "";
	var svgContent8 = "";
	var svgContent9 = "";
	var svgContent10 = "";
	var svgContent11 = "";
	var createChart = false;
	var mailSel = document.getElementById("mailType");
	mailType = mailSel.options[mailSel.selectedIndex].value;
	var chartTypeSel = document.getElementById("chartType");
	chartTypeSel = chartTypeSel.options[chartTypeSel.selectedIndex].value;
	var mailTypeSelected = mailSel.options[mailSel.selectedIndex].innerHTML;
	document.getElementById("noRecords").style.display="none";
	if (type == "htmltopdf") {
		var tmp = document.getElementById("graphChart");
		svgContent1 = tmp.getElementsByTagName("svg")[0];
		svgContent2 = tmp.getElementsByTagName("svg")[1];
		svgContent3 = tmp.getElementsByTagName("svg")[2];
		svgContent4 = tmp.getElementsByTagName("svg")[3];
		svgContent5 = tmp.getElementsByTagName("svg")[4];
		svgContent6 = tmp.getElementsByTagName("svg")[5];
		svgContent7 = tmp.getElementsByTagName("svg")[6];
		svgContent8 = tmp.getElementsByTagName("svg")[7];
		svgContent9 = tmp.getElementsByTagName("svg")[8];
		svgContent10 = tmp.getElementsByTagName("svg")[9];
		svgContent11 = tmp.getElementsByTagName("svg")[10];
		if (typeof(svgContent1) != "undefined")
		svg_xml1 = (new XMLSerializer).serializeToString(svgContent1);
		if (typeof(svgContent2) != "undefined")
		svg_xml2 = (new XMLSerializer).serializeToString(svgContent2);
		if (typeof(svgContent3) != "undefined")
		svg_xml3 = (new XMLSerializer).serializeToString(svgContent3);
		if (typeof(svgContent4) != "undefined")
		svg_xml4 = (new XMLSerializer).serializeToString(svgContent4);
		if (typeof(svgContent5) != "undefined")
		svg_xml5 = (new XMLSerializer).serializeToString(svgContent5);
		if (typeof(svgContent6) != "undefined")
		svg_xml6 = (new XMLSerializer).serializeToString(svgContent6);
		if (typeof(svgContent7) != "undefined")
			svg_xml7 = (new XMLSerializer).serializeToString(svgContent7);
		if (typeof(svgContent8) != "undefined")
			svg_xml8 = (new XMLSerializer).serializeToString(svgContent8);
		if (typeof(svgContent9) != "undefined")
			svg_xml9 = (new XMLSerializer).serializeToString(svgContent9);
		if (typeof(svgContent10) != "undefined")
			svg_xml10 = (new XMLSerializer).serializeToString(svgContent10);
		if (typeof(svgContent11) != "undefined")
			svg_xml11 = (new XMLSerializer).serializeToString(svgContent11);
	}
		var e = document.getElementById("campSelect");
		campSelect = e.options[e.selectedIndex].value;
		campName = e.options[e.selectedIndex].text;
		/* var e = document.getElementById("eventsSelect");
		eventsSelect = e.options[e.selectedIndex].value;
		eventName = e.options[e.selectedIndex].text;
		var e = document.getElementById("assetTypeSelect");
		assetTypeSelect = e.options[e.selectedIndex].value;
		assetTypeName = e.options[e.selectedIndex].text; */
	A.io.request(reqUrl, {
	    cache: false,
	    sync: true,
	    timeout: 1000,
	    dataType: 'json',
	    method: 'post',
	    data:{
	    	campSelect:campSelect,
	   	 	type:type,
	   	 	mailType:mailType,
	   	 	chartType:chartTypeSel,
	   	 	svg1:svg_xml1,
	   	 	svg2:svg_xml2,
	   	 	svg3:svg_xml3,
	   	 	svg4:svg_xml4,
	   	 	svg5:svg_xml5,
	   	 	svg6:svg_xml6,
	   		svg7:svg_xml7,
	   		svg8:svg_xml8,
	   		svg9:svg_xml9,
	   		svg10:svg_xml10,
	   		svg11:svg_xml11,
	   	 	/* eventsSelect:eventsSelect,
	   		assetTypeSelect:assetTypeSelect, */
	    },

	    on: {
	        success: function() {
	       	 items = this.get('responseData');
	       	var count = Object.keys(items).length;
	       	var x = 0;
	       	 if (items) {
	       		 document.getElementById("siteLoader").style.display = "block";
				for (key in items) {
					x=x+1;
					if ((key == "rsvp") || (key == "events") || (key == "assetType") || (key == "chartName") || (key == "selectedRsvpName")) {
						if (key == "rsvp") {
							var filterVaues = items[key];
							var rsvpSelect = document.getElementById("rsvpSelect");
							for (key in filterVaues) {
								for (var i = 0; i < rsvpSelect.options.length; i++)
						        {
						            if (rsvpSelect.options[i].value === key)
						            {
						            	rsvpSelect.selectedIndex = i;
						                break;
						            }
						        }
							}
						}/* else if (key == "events") {
							var filterVaues = items[key];
							var eventsSelect = document.getElementById("eventsSelect");
							for (key in filterVaues) {
								for (var i = 0; i < eventsSelect.options.length; i++)
						        {
						            if (eventsSelect.options[i].value === key)
						            {
						            	eventsSelect.selectedIndex = i;
						                break;
						            }
						        }
							}
						}else if (key == "assetType") {
							var filterVaues = items[key];
							var assetTypeSelect = document.getElementById("assetTypeSelect");
							for (key in filterVaues) {
								for (var i = 0; i < assetTypeSelect.options.length; i++)
						        {
						            if (assetTypeSelect.options[i].value === key)
						            {
						            	assetTypeSelect.selectedIndex = i;
						                break;
						            }
						        }
							}

						} */else if (key == "chartName") {
							var nameValues = items[key];
							var chartDiv = document.getElementById("graphChart");
							var chartNameDiv = document.getElementById("graphTitle");
							chartNameDiv.innerHTML = "";
							var tmp = document.getElementById("graphs");
							tmp.innerHTML="";
							var rsvpName = "";
							var eventName = "";
							var contest = "";
							var campaign = "";
							chartNameDiv.innerHTML = "<svg width='900' height='60' id='statistics'>";
							var textElm = "";
							y2=53;
							ht = 38;
							for (key in nameValues) {
								if ((key == "campaignName") && (nameValues[key] != "")) {
									if (nameValues[key].length >= 80) {
										var splitData = nameValues[key].match(/.{1,80}/g);
										for (k=0;k<splitData.length;k++) {
											textElm = textElm + "<text x='50%' y='" + y2 + "' style='font-size: 22px;' text-anchor='middle'>"  + splitData[k] + "</text>";
											ht=y2-10;
											y2=y2+32;
										}
									}else {
										textElm = "<text x='50%' y='" + y2 + "' style='font-size: 22px;' text-anchor='middle'>"  + nameValues[key] + "</text>";
									}
									campaign = "<rect x='0' y='25' width='900' height='" + ht + "' fill='#e1e1e1' ></rect>"  + textElm;
								}
								if ((key == "rsvpName") && (nameValues[key] != ""))
									rsvpName = "<text x='0' y='78' style='font-size: 16px;'> RSVP - "  + nameValues[key] + "</text>";
								if ((key == "eventName") && (nameValues[key] != ""))
									eventName = "<text x='0' y='103' style='font-size: 16px;'> Event - " + nameValues[key] + "</text>";
								if ((key == "contest") && (nameValues[key] != ""))
									contest = "<text x='0' y='128' style='font-size: 16px;'> Contest - " + nameValues[key] + "</text>";
							}
							chartNameDiv.innerHTML = "<svg width='900' height='140' id='statistics'>" + campaign + rsvpName + eventName + contest + "</svg>";
						}else if (key == "selectedRsvpName") {
							//var rsvpDiv = document.getElementById("rsvpDiv");
							//if (rsvpValues[key] != "") {
								var rsvpInput = document.getElementById("rsvpName");
								//rsvpInput.setAttribute("type","text");
								var rsvpValues = items[key];
								var tmp = document.getElementById("graphs");
								tmp.innerHTML="";
								rsvpInput.innerHTML = "";
								for (key in rsvpValues) {
									if (key > 0) {
										rsvpInput.innerHTML = rsvpValues[key];
									}else {
										//var chartNameDiv = document.getElementById("graphTitle");
										//chartNameDiv.innerHTML = "";
										rsvpInput.innerHTML = "No corresponding RSVP found"
									}
								}
							//}
							//rsvpDiv.appendChild(rsvpInput);
						}
					}else if (key == "zipFile") {

						document.location.href = "/SPReports-portlet/download?fileName=" + items[key];
					}
					else {
						if (x == 1) {
							var chartSel = document.getElementById("chartType");
							chartType = chartSel.options[chartSel.selectedIndex].value;
							var csvData = "RSVPType,Sent";
							var csvData1 = "RSVPType,Sent";
							var csvData2 = "RSVPType,Sent";
							var csvData3 = "RSVPType,Sent";
							var csvData4 = "RSVPType,Sent";
							var csvData5 = "RSVPType,Sent";
							var csvData6 = "RSVPType,Sent";
							var csvData7 = "RSVPType,Sent";
							var csvData8 = "RSVPType,Sent";
							var csvData9 = "RSVPType,Sent";
							var csvData10 = "RSVPType,Sent";
							var csvData11 = "RSVPType,Sent";
							var csvData12 = "RSVPType,Sent";
							var statData1="";
							var statData2="";
							var statData3="";
							var statData4="";
							var statData5="";
							var statData6="";
							var statData7="";
							var statData8="";
							var statData9="";
							var statData10="";
							var statData11="";
							var statData12="";
							var statData13="";
							var sent=0;
							var deliveredMail=0;
							var dMail = 0;
							var totalRsvp = 0;
							var tmp = document.getElementById("graphs");
							tmp.innerHTML="";
							for (key in items) {
								//if ((key == "Invitation") || (key == "Admin-Registration") || (key == "Registration"))
								if (key == "sourceCount") {
									var sourceCountValues = items[key];
									for (key in sourceCountValues) {
										var c = sourceCountValues[key];
										csvData = csvData + "\n" + key + "," + c;
										statData1 = statData1 + "**" + key + "**" + c;
									}
								}
								//if ((key == "Attending") || (key == "Not-Attending") || (key == "MayBe") || (key == "Waiting"))
								if (key == "statusCount") {
									var statusCountValues = items[key];
									for (key in statusCountValues) {
										var c = statusCountValues[key];
										csvData1 = csvData1 + "\n" + key + "," + c;
										statData2 = statData2 + "**" + key + "**" + c;
									}
								}
								//if ((key == "Attended") || (key == "Not-Attended"))
								if (key == "atdCount") {
									var atdCountValues = items[key];
									for (key in atdCountValues) {
										var c = atdCountValues[key];
										csvData2 = csvData2 + "\n" + key + "," + c;
										statData3 = statData3 + "**" + key + "**" + c;
									}
								}
								if (key == "totalRsvp") {
									totalRsvp = items[key];
									if (items[key] > 0) {
										var statDiv = d3.select('#statistics');
										statDiv.append("text")
									    .attr("x", 0)
									    .attr("y", 125)
									    .style("font-size", "16px")
									    .text("Total Number of RSVP - " + items[key]);
									}
								}
								//if ((key == "Sent") || (key == "Bounced") || (key == "Bounce-Soft") || (key == "Complain") || (key == "Opened") || (key == "Delivered")) {
								if (key == "mailCount") {
									var mailCountValues = items[key];
									var c = 0;
									for (key in mailCountValues) {
										c = mailCountValues[key];
										if (key != "Sent") {
											if (key == "Delivered") {
												deliveredMail = c + "**Total Mails Delivered";
												dMail = c;
											}
											if ((key == "Opened") || (key == "Not-Opened")) {
												csvData6 = csvData6 + "\n" + key + "," + c;
												statData7 = statData7 + "**" + key + "**" + c;
											}
											if ((key == "Bounced") || (key == "Bounce-Soft") || (key == "Complain") || (key == "Delivered")) {
												csvData3 = csvData3 + "\n" + key + "," + c;
												statData4 = statData4 + "**" + key + "**" + c;
											}
										}
										else {
											sent = c + "**Total Mails Sent";
										}
									}
									if (c > 0)
									getChartForDifferentReports("rsvpMailCsv",csvData3,chartType, "Mail Delivered Details",statData4,sent);
									if (c > 0)
									getChartForDifferentReports("cmpMailOpn",csvData6,chartType, "Mail Opened Details",statData7,deliveredMail);
									if (c==0) {
										document.getElementById("noRecords").style.display="block";
									}
								}
								if (key == "countryCount") {
									var countryCountValues = items[key];
									totalOpened = 0;
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										csvData4 = csvData4 + "\n" + key + "," + c;
										statData5 = statData5 + "**" + key + "**" + c;
										totalOpened= totalOpened + c;
									}
								}
								if (key == "linkJSONObject") {
									var countryCountValues = items[key];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										//alert("linkJSONObject " + key + " ### " + c);
										csvData5 = csvData5 + "\n" + key + "," + c;
										statData6 = statData6 + "**" + key + "**" + c;
									}
								}
								if (key == "typeNameJSONObject") {
									var uAValues = items[key];
									var values = [];
									for (var i in uAValues) {
									   values.push({ key: uAValues[i],value: i });
									}
									values.sort(function(a, b) { return a.value.localeCompare(b.value); });
									var str = values.map(function(kvp) {
										fValue = kvp.value + "**" + kvp.key;
										csvData7 = csvData7 + "\n" + kvp.value + "," + kvp.key;
										statData8 = statData8 + "**" + kvp.value + "**" + kvp.key;
										str1 = csvData7 + "$%" + statData8;
										return str1; });
									var splitstr = str1.split("$%");
									csvData7 = splitstr[0];
									statData8 = splitstr[1];
								}
								if (key == "oSJSONObject") {
									var uAValues = items[key];
									var values = [];
									for (var i in uAValues) {
									   values.push({ key: uAValues[i],value: i });
									}
									values.sort(function(a, b) { return a.value.localeCompare(b.value); });
									var str = values.map(function(kvp) {
										fValue = kvp.value + "**" + kvp.key;
										csvData8 = csvData8 + "\n" + kvp.value + "," + kvp.key;
										statData9 = statData9 + "**" + kvp.value + "**" + kvp.key;
										str1 = csvData8 + "$%" + statData9;
										return str1; });
									var splitstr = str1.split("$%");
									csvData8 = splitstr[0];
									statData9 = splitstr[1];
								}
								if (key == "familyJSONObject") {
									var uAValues = items[key];
									var values = [];
									for (var i in uAValues) {
									   values.push({ key: uAValues[i],value: i });
									}
									values.sort(function(a, b) { return a.value.localeCompare(b.value); });
									var str = values.map(function(kvp) {
										fValue = kvp.value + "**" + kvp.key;
										csvData9 = csvData9 + "\n" + kvp.value + "," + kvp.key;
										statData10 = statData10 + "**" + kvp.value + "**" + kvp.key;
										str1 = csvData9 + "$%" + statData10;
										return str1; });
									var splitstr = str1.split("$%");
									csvData9 = splitstr[0];
									statData10 = splitstr[1];
								}
								if (key == "deviceJSONObject") {
									var uAValues = items[key];
									var values = [];
									for (var i in uAValues) {
									   values.push({ key: uAValues[i],value: i });
									}
									values.sort(function(a, b) { return a.value.localeCompare(b.value); });
									var str = values.map(function(kvp) {
										fValue = kvp.value + "**" + kvp.key;
										csvData10 = csvData10 + "\n" + kvp.value + "," + kvp.key;
										statData11 = statData11 + "**" + kvp.value + "**" + kvp.key;
										str1 = csvData10 + "$%" + statData11;
										return str1; });
									var splitstr = str1.split("$%");
									csvData10 = splitstr[0];
									statData11 = splitstr[1];
								}
								if (key == "nameJSONObject") {
									var uAValues = items[key];
									var values = [];
									for (var i in uAValues) {
									   values.push({ key: uAValues[i],value: i });
									}
									values.sort(function(a, b) { return a.value.localeCompare(b.value); });
									var str = values.map(function(kvp) {
										fValue = kvp.value + "**" + kvp.key;
										csvData11 = csvData11 + "\n" + kvp.value + "," + kvp.key;
										statData12 = statData12 + "**" + kvp.value + "**" + kvp.key;
										str1 = csvData11 + "$%" + statData12;
										return str1; });
									var splitstr = str1.split("$%");
									csvData11 = splitstr[0];
									statData12 = splitstr[1];
								}
								if (key == "typeJSONObject") {
									var uAValues = items[key];
									var values = [];
									for (var i in uAValues) {
									   values.push({ key: uAValues[i],value: i });
									}
									values.sort(function(a, b) { return a.value.localeCompare(b.value); });
									var str = values.map(function(kvp) {
										fValue = kvp.value + "**" + kvp.key;
										csvData12 = csvData12 + "\n" + kvp.value + "," + kvp.key;
										statData13 = statData13 + "**" + kvp.value + "**" + kvp.key;
										str1 = csvData12 + "$%" + statData13;
										return str1; });
									var splitstr = str1.split("$%");
									csvData12 = splitstr[0];
									statData13 = splitstr[1];
								}
							}

							if (statData5 != "") {
								totalNotOpened = dMail - totalOpened;
								csvData4 = csvData4 + "\n" + "Mails Not Opened" + "," + totalNotOpened;
								statData5 = statData5 + "**" + "Mails Not Opened" + "**" + totalNotOpened;
								getChartForDifferentReports("rsvpCountryCsv",csvData4,chartType, "Mail Opened by Location",statData5,deliveredMail);
							}
							if (statData6 != "") {
								buildTable("mailLinkCsv","Mail Links Opened",csvData5,statData6,deliveredMail);
							}
							if (statData8 != "")
								buildUserTable("typeNameCsv","Statistics by Type Name",csvData7,statData8,"Type Name");
							if (statData12 != "")
								buildUserTable("nameCsv","Statistics by Name",csvData11,statData12,"Name");
							if (statData13 != "")
								buildUserTable("typeCsv","Statistics by Type",csvData12,statData13,"Type");
							if (statData9 != "")
								buildUserTable("oSCsv","Statistics by Operating System",csvData8,statData9,"Operating System");
							if (statData10 != "")
								buildUserTable("familyCsv","Statistics by Family",csvData9,statData10,"Family");
							if (statData11 != "")
								buildUserTable("deviceCsv","Statistics by Device Category",csvData10,statData11,"Device Category");

							//getChartForDifferentReports("mailLinkCsv",csvData5,chartType, "Mail Links Opened",statData6,deliveredMail);
							if (totalRsvp > 0) {
								if (statData1 != "")
								getChartForDifferentReports("rsvpTypeCsv",csvData,chartType,"RSVP Source",statData1);
								if (statData2 != "")
								getChartForDifferentReports("rsvpStatusCsv",csvData1,chartType,"RSVP Status",statData2);
								if (statData3 != "")
								getChartForDifferentReports("rsvpAttdCsv",csvData2,chartType,"RSVP Attendence",statData3);
							}
						}
					}
	       		 }
	       	}
	       	document.getElementById("siteLoader").style.display = "none";
	        },
	        failure: function() {
	        }
	    }
	});
	return true;
}

function getChartForDifferentReports(id,csvData,chartType,graphTitle,statData,sent) {
		var csvTag = document.getElementById(id);
		csvTag.text = csvData;
		if (chartType == "bar") {
			renderChart(id,graphTitle,statData,sent);
		}else if (chartType == "pie") {
			renderPieChart(id,graphTitle,statData,sent);
		}else if (chartType == "Vbar") {
			renderVBarChart(id,graphTitle,statData,sent);
		}else if (chartType == "doughnut") {
			renderDoughnutChart(id,graphTitle,statData,sent);
		}
}

function renderChart(id,graphTitle,statData,sent) {

	var data = d3.csv.parse(d3.select('#'+id).text());
	var valueLabelWidth = 40; // space reserved for value labels (right)
	var barHeight = 25; // height of one bar
	var barLabelWidth = 90; // space reserved for bar labels
	var barLabelPadding = 5; // padding between bar and bar labels (left)
	var gridLabelHeight = 45; // space reserved for gridline labels
	var gridChartOffset = 3; // space between start of grid and first bar
	var maxBarWidth = 420; // width of the bar with the max value

	var color = d3.scale.ordinal()
	.range(["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"]);
	//color = d3.scale.category20b(); //builtin range of colors
	// accessor functions
	var barLabel = function(d) { return d['RSVPType']; };
	var barValue = function(d) { return parseFloat(d['Sent']);};

	var sentData = sent.split("**");
	var sentVal = sentData[0];
	var sentName = sentData[1];
	var maxValue = parseFloat(sentVal);
	//alert("graphTitle " + sentVal + " " + sentName);
	// scales
	var yScale = d3.scale.ordinal().domain(d3.range(0, data.length)).rangeBands([0, data.length * barHeight]);
	var y = function(d, i) { return yScale(i); };
	var yText = function(d, i) { return y(d, i) + yScale.rangeBand() / 2; };
	var x = d3.scale.linear().domain([0, maxValue]).range([0, maxBarWidth]);
	// svg container element
	var svgHeight = (gridLabelHeight + gridChartOffset + data.length * barHeight) + 200;
	if (id == "rsvpCountryCsv") {
		svgHeight = data.length * 50;
	}
	if (svgHeight < 300) {
		svgHeight = 300;
	}
	var chart = d3.select('#graphs').append("svg")
	  .attr('width', 945)
	  .attr('height', svgHeight);

	chart.append("text")
	.attr("x", 300)
	.attr("y", barHeight)
	.style("font-size", "16px")
	.style("font-weight", "bold")
	.text(graphTitle);
	// grid line labels
	var gridContainer = chart.append('g')
	  .attr('transform', 'translate(' + barLabelWidth + ',' + gridLabelHeight + ')');
	gridContainer.selectAll("text").data(x.ticks(10)).enter().append("text")
	  .attr("x", x)
	  .attr("dy", -3);
	  //.attr("text-anchor", "middle")
	  //.text(String);
	// vertical grid lines
	gridContainer.selectAll("line").data(x.ticks(10)).enter().append("line")
	  .attr("x1", x)
	  .attr("x2", x)
	  .attr("y1", 0)
	  .attr("y2", yScale.rangeExtent()[1] + gridChartOffset)
	  .style("stroke", "#ccc");
	// bar labels
	var labelsContainer = chart.append('g')
	  .attr('transform', 'translate(' + (barLabelWidth - barLabelPadding) + ',' + (gridLabelHeight + gridChartOffset) + ')');
	labelsContainer.selectAll('text').data(data).enter().append('text')
	  .attr('y', yText)
	  .attr('stroke', 'none')
	  .attr('fill', 'black')
	  .attr("dy", ".35em") // vertical-align: middle
	  .attr('text-anchor', 'end')
	  .text();
	// bars
	var barsContainer = chart.append('g')
	  .attr('transform', 'translate(' + barLabelWidth + ',' + (gridLabelHeight + gridChartOffset) + ')');
	barsContainer.selectAll("rect").data(data).enter().append("rect")
	  .attr('y', y)
	  .attr('height', yScale.rangeBand())
	  .attr('width', function(d) { return x(barValue(d)); })
	  .attr('stroke', 'white')
	  .attr('fill', function(d, i) { return color(i); } );
	// bar value labels
	barsContainer.selectAll("text").data(data).enter().append("text")
	  .attr("x", function(d) { return x(barValue(d)); })
	  .attr("y", yText)
	  .attr("dx", 3) // padding-left
	  .attr("dy", ".35em") // vertical-align: middle
	  .attr("text-anchor", "start") // text-align: right
	  .attr("fill", "black")
	  .attr("stroke", "none")
	  .text(function(d) { return d3.round(barValue(d), 2); });

	// start line
	barsContainer.append("line")
	  .attr("y1", -gridChartOffset)
	  .attr("y2", yScale.rangeExtent()[1] + gridChartOffset)
	  .style("stroke", "#000");
	var color=["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"];
	var y = 45;
	var y1 = 60;
	var t=0;

	chart.append("rect")
	  .attr("fill","#F7D226" )
	  .attr("x","540")
	  .attr("y",y)
	  .attr("width","20")
	  .attr("height","20");
	chart.append("text")
	  .attr("x", 565)
	  .attr("y", y1)
	  .style("font-size", "14px")
	  .text(function(d, i) { return sentVal + "  " + sentName; });

	var stats = statData.split("**");
	for (l=0;l<data.length;l++) {
		y=y+40;
		y1=y1+40;
		t=t+2;
	var splitDqta = stats[t-1].match(/.{1,25}/g);
	chart.append("rect")
	.attr("fill",color[l] )
	.attr("x",540)
	.attr("y",y)
	.attr("width","20")
	.attr("height","20");
	if (stats[t-1].length >= 55) {
		var splitData = stats[t-1].match(/.{1,55}/g);
		chart.append("text")
		.attr("x", 565)
		.attr("y", y1)
		.attr("id", "link_"+m)
		.style("font-size", "14px")
		.text(function(d, i) { return stats[t]+ "  " + splitData[0]; });
		var lnks = d3.select("#link_"+m);
		y2=12;
		for (k=1;k<splitData.length;k++) {
			chart.append("text")
			.attr("x",565)
			.attr("y", y1+y2)
			.style("font-size", "14px")
			.text(function(d, i) { return splitData[k]; });
			y2=y2+12;
		}
	}else if (stats[t-1].length < 55) {
		chart.append("text")
		.attr("x", 565)
		.attr("y", y1)
		.attr("id", "link_"+m)
		.style("font-size", "14px")
		.text(function(d, i) { return stats[t]+ "  " + stats[t-1]; });
	}
	m=m+1;

	}

}


function renderPieChart(id,graphTitle,statData,sent) {
	var w = 800, //width
	h = 390, //height
	r = 140,//radius
	svgHeight=390,
	r1=160;
	var color = d3.scale.ordinal()
	.range(["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"]);
	var data = d3.csv.parse(d3.select('#'+id).text());
	if (id == "rsvpCountryCsv") {
		svgHeight = data.length * 47;
	}
	if (svgHeight < 390) {
		svgHeight = 390;
	}
	var vis = d3.select("#graphs")
	.append("svg:svg") //create the SVG element inside the <body>
	.data([data]) //associate our data with the document
	.attr("width", 900) //set the width and height of our visualization (these will be attributes of the <svg> tag
	.attr("height", svgHeight)
	.attr("style","margin-left:20px")
	.append("svg:g") //make a group to hold our pie chart
	.attr("transform", "translate(160," + r1 + ")"); //move the center of the pie chart from 0, 0 to radius, radius

	vis.append("text")
	.attr("x", 125)
	.attr("y", -128)
	.style("font-size", "16px")
	.style("font-weight", "bold")
	.text(graphTitle);

	var arc = d3.svg.arc() //this will create <path> elements for us using arc data
	.outerRadius(r);
	var pie = d3.layout.pie() //this will create arc data for us given a list of values
	.value(function(d) { return d.Sent; }); //we must tell it out to access the value of each element in our data array
	var arcs = vis.selectAll("g.slice") //this selects all <g> elements with class slice (there aren't any yet)
	.data(pie) //associate the generated pie data (an array of arcs, each having startAngle, endAngle and value properties)
	.enter() //this will create <g> elements for every "extra" data element that should be associated with a selection. The result is creating a <g> for every object in the data array
	.append("svg:g") //create a group to hold each slice (we will have a <path> and a <text> element associated with each slice)
	.attr("class", "slice"); //allow us to style things in the slices (like text)

	var arc1 = d3.svg.arc()
	.outerRadius(r)
	.innerRadius(r-5);

	arcs.append("svg:path")
	.attr("fill", function(d, i) { return color(i); } ) //set the color for each slice to be chosen from the color function defined above
	.attr("d", arc); //this creates the actual SVG path using the associated data (pie) with the arc drawing function

	/* arcs.append("svg:text") //add a label to each slice
	.attr("transform", function(d) { //set the label's origin to the center of the arc
	//we have to make sure to set these before calling arc.centroid
	d.innerRadius = 0;
	d.outerRadius = r;
	return "translate(" + arc.centroid(d) + ")"; //this gives us a pair of coordinates like [50, 50]
	})
	.attr("dy",".71em")
	.attr("text-anchor", "middle")//position of the text on it's origin
	.attr("display", function(d) { return d.value > 0 ? null :"none"; })
	.text(function(d, i) { return data[i].Sent; }); */

	arcs.append("path")
	  .attr("d", arc1)
	  .style("fill", "#F7D226" );
	/* var pos = d3.svg.arc().innerRadius(r + 50).outerRadius(r1 + 50);

	// Place Labels
	vis.append("svg:path")
	       .attr("transform", function(d) { return "translate(" +
	    pos.centroid(d) + ")"; })
	       .attr("dy", arc)
	       .attr("fill", "red"); */
	var sentData = sent.split("**");
	var sentVal = sentData[0];
	var sentName = sentData[1];

	var y = -80;
	var y1 = -65;
	var t=0;
	var color=["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"];
	vis.append("rect")
	  .attr("fill","#F7D226" )
	  .attr("x","300")
	  .attr("y",y)
	  .attr("width","20")
	  .attr("height","20");
	  vis.append("text")
	  .attr("x", 330)
	  .attr("y", y1)
	  .style("font-size", "14px")
	  .text(function(d, i) { return sentVal + "  " + sentName; });
	var stats = statData.split("**");
	for (l=0;l<data.length;l++) {
		y=y+40;
		y1=y1+40;
		t=t+2;
		vis.append("rect")
	.attr("fill",color[l] )
	.attr("x",300)
	.attr("y",y)
	.attr("width","20")
	.attr("height","20");
		if (stats[t-1].length >= 60) {
			var splitData = stats[t-1].match(/.{1,60}/g);
			vis.append("text")
			.attr("x", 330)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t]+ "  " + splitData[0]; });
			var lnks = d3.select("#link_"+m);
			y2=12;
			for (k=1;k<splitData.length;k++) {
				vis.append("text")
				.attr("x",330)
				.attr("y", y1+y2)
				.style("font-size", "14px")
				.text(function(d, i) { return splitData[k]; });
				y2=y2+12;
			}
		}else if (stats[t-1].length < 60) {
			vis.append("text")
			.attr("x", 330)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t]+ "  " + stats[t-1]; });
		}
		m=m+1;
	}

}

function renderVBarChart(id,graphTitle,statData,sent) {
	var margin = {top: 40, right: 40, bottom: 30, left: 40},
	width = 400 - margin.left - margin.right,
	height = 600 - margin.top - margin.bottom,
	svgHeight = 650;
	var data = d3.csv.parse(d3.select('#'+id).text());
	if (id == "rsvpCountryCsv") {
		svgHeight = data.length * 47;
	}
	if (svgHeight < 650) {
		svgHeight = 650;
	}
	var color = d3.scale.ordinal()
	.range(["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"]);
	var maxValue = parseFloat(sent);
var x = d3.scale.ordinal()
	.rangeRoundBands([0, width]);

var y = d3.scale.linear()
	.range([height, 0]);

var xAxis = d3.svg.axis()
	.scale(x)
	.orient("bottom");

var yAxis = d3.svg.axis()
	.scale(y)
	.orient("left")

var tip = d3.tip()
.attr('class', 'd3-tip')
.offset([-10, 0])
.html(function(d) {
	return "<strong>Count:</strong> <span style='color:red'>" + d.Sent + "</span>";
})

var svg = d3.select("#graphs").append("svg")
	.attr("width", 900)
	.attr("height", svgHeight)
.append("g")
	.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

svg.call(tip);

svg.append("text")
.attr("x", (width / 2))
.attr("y", -20)
.style("font-size", "16px")
.style("font-weight", "bold")
.text(graphTitle);

data.forEach(function(d) {

	    x.domain(data.map(function(d) { return d.RSVPType; }));
	    y.domain([0, maxValue]);

svg.append("g")
	  .attr("class", "x axis")
	  .attr("transform", "translate(0," + height + ")")
	  //.call(xAxis);

svg.append("g")
	  .attr("class", "y axis")
	  .call(yAxis)
	.append("text")
	  .attr("transform", "rotate(-90)")
	  .attr("y", 6)
	  .attr("dy", ".71em")
	  .style("text-anchor", "end")
	  .text("Sent");

svg.selectAll(".bar")
	  .data(data)
	.enter().append("rect")
	  //.attr("class", "bar")
	  //.attr("fill",function(d, i) { return color(i); })
	  .attr("x", function(d) { return x(d.RSVPType); })
	  .attr("width", x.rangeBand())
	  .attr("y", function(d) { return y(d.Sent); })
	  .attr("height", function(d) { return height - y(d.Sent); })
	  .attr('stroke', 'white')
	  .attr('fill', function(d, i) { return color(i); } )
	  .on('mouseover', tip.show)
	  .on('mouseout', tip.hide)

});

var y = 0;
var y1 = 15;
var t=0;
var sentData = sent.split("**");
var sentVal = sentData[0];
var sentName = sentData[1];
var color=["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"];
svg.append("rect")
.attr("fill","#F7D226" )
.attr("x","400")
.attr("y",y)
.attr("width","20")
.attr("height","20");
svg.append("text")
.attr("x", 430)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return sentVal + "  " + sentName; });
var stats = statData.split("**");
	for (l=0;l<data.length;l++) {
		y=y+40;
		y1=y1+40;
		t=t+2;
		svg.append("rect")
		.attr("fill",color[l] )
		.attr("x","400")
		.attr("y",y)
		.attr("width","20")
		.attr("height","20");
		if (stats[t-1].length >= 60) {
			var splitData = stats[t-1].match(/.{1,60}/g);
			svg.append("text")
			.attr("x", 430)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t]+ "  " + splitData[0]; });
			var lnks = d3.select("#link_"+m);
			y2=12;
			for (k=1;k<splitData.length;k++) {
				svg.append("text")
				.attr("x",430)
				.attr("y", y1+y2)
				.style("font-size", "14px")
				.text(function(d, i) { return splitData[k]; });
				y2=y2+12;
			}
		}else if (stats[t-1].length < 60) {
			svg.append("text")
			.attr("x", 430)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t]+ "  " + stats[t-1]; });
		}
		m=m+1;
	}
}

function renderDoughnutChart(id,graphTitle,statData,sent) {
	var width = 900,
	height = 400,
	svgHeight = 450,
	radius = Math.min(width, height) / 2;
	var data = d3.csv.parse(d3.select('#'+id).text());
	//alert( "data "+ data.size + " " + data.length);
	if (id == "rsvpCountryCsv") {
		svgHeight = data.length * 47;
	}
	if (svgHeight < 450) {
		svgHeight = 450;
	}
var color = d3.scale.ordinal()
	.range(["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"]);
//color = d3.scale.category20b(); //builtin range of colors
//var color=["#1f77b4", "#9467bd", "#e377c2", "#bcbd22", "#17becf", "#843c39", "#ad494a", "#a55194", "#ce6dbd", "#bd9e39", "#e7ba52", "#e7cb94"];

var arc = d3.svg.arc()
	.outerRadius(radius - 40)
	.innerRadius(radius - 100);

var arc1 = d3.svg.arc()
.outerRadius(radius-40)
.innerRadius(radius-35);

var pie = d3.layout.pie()
	.sort(null)
	.value(function(d) { return d.Sent; });

var svg = d3.select("#graphs").append("svg")
	.attr("width", 900)
	.attr("height", svgHeight)
.append("g")
	.attr("transform", "translate(220," + height / 2 + ")");

svg.append("text")
.attr("x", 100)
.attr("y", -185)
.style("font-size", "16px")
.style("font-weight", "bold")
.text(graphTitle);

data.forEach(function(d) {
	  d.Sent = +d.Sent;

var g = svg.selectAll(".arc")
	  .data(pie(data))
	.enter().append("g")
	  .attr("class", "arc");

g.append("path")
	  .attr("d", arc)
	  .style("fill", function(d,i) { return color(i); });

/* g.append("text")
	  .attr("transform", function(d) { return "translate(" + arc.centroid(d) + ")"; })
	  .attr("dy", ".35em")
	  .style("text-anchor", "middle")
	  .text(function(d) { return d.data.Sent; }); */

g.append("path")
.attr("d", arc1)
.style("fill", "#F7D226" );

});

var y = -150;
var y1 = -135;
var t=0;
var sentData = sent.split("**");
var sentVal = sentData[0];
var sentName = sentData[1];
var color=["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"];
svg.append("rect")
.attr("fill","#F7D226" )
.attr("x","220")
.attr("y",y)
.attr("width","20")
.attr("height","20");
svg.append("text")
.attr("x", 250)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return sentVal + "  " + sentName; });
var stats = statData.split("**");
for (l=0;l<data.length;l++) {
		y=y+40;
		y1=y1+40;
		t=t+2;
		svg.append("rect")
	.attr("fill",color[l] )
	.attr("x",220)
	.attr("y",y)
	.attr("width","20")
	.attr("height","20");
		if (stats[t-1].length >= 60) {
			var splitData = stats[t-1].match(/.{1,60}/g);
			svg.append("text")
			.attr("x", 250)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t]+ "  " + splitData[0]; });
			var lnks = d3.select("#link_"+m);
			y2=12;
			for (k=1;k<splitData.length;k++) {
				svg.append("text")
				.attr("x",250)
				.attr("y", y1+y2)
				.style("font-size", "14px")
				.text(function(d, i) { return splitData[k]; });
				y2=y2+12;
			}
		}else if (stats[t-1].length < 60) {
			svg.append("text")
			.attr("x", 250)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t]+ "  " + stats[t-1]; });
		}
		m=m+1;

	}
}

//google.setOnLoadCallback(drawRegionsMap);

/* function drawRegionsMap() {
	 google.load('visualization', '1', {'packages': ['geochart']});
var data = google.visualization.arrayToDataTable([
	 ['Country', 'Popularity'],
	 ['Germany', 200],
	 ['United States', 300],
	 ['Brazil', 400],
	 ['Canada', 500],
	 ['France', 600],
	 ['RU', 700]
]);

var options = {};

var chart = new google.visualization.GeoChart(document.getElementById('graphs'));
chart.draw(data, options);
google.setOnLoadCallback(drawRegionsMap);

};
 */

function buildTable(id,graphTitle,csvData,statData,sent) {
	 var width = 900,
	    height = 400;
	 var csvTag = document.getElementById(id);
		csvTag.text = csvData;
	 var data = d3.csv.parse(d3.select('#'+id).text());
	 var h1 = data.length*70;
	 if (h1 < 350) {
			h1 = 350;
		}
	var svg = d3.select("#graphs").append("svg")
	.attr("width", 900)
	.attr("height", h1)
.append("g")
	.attr("transform", "translate(220," + height / 2 + ")");
svg.append("text")
.attr("x", 100)
.attr("y", -185)
.style("font-size", "16px")
.style("font-weight", "bold")
.text(graphTitle);
var y = -150;
var y1 = -135;
var y2 = -70;
var t=0;
var sentData = sent.split("**");
var sentVal = sentData[0];
var sentName = sentData[1];
var color=["#F7E726", "#C5D936", "#A2BE56", "#69BE56", "#4BB2AE", "#4B9BB2", "#4B80B2", "#4B63B2", "#504BB2", "#744BB2", "#8B4B9D","#BF4888","#0578a6","#bf9649","#a66b37","#733612","#401809","#733d56","#246473","#0b8c8c","#459672","#48a4c2","#6188b0","#f9c991","#d98282"];
/* svg.append("rect")
.attr("fill","#F7D226" )
.attr("x",-175)
.attr("y",y)
.attr("width","20")
.attr("height","20"); */
svg.append("text")
.attr("x", -175)
.attr("y", y1)
.style("font-size", "14px")
.style("font-weight", "bold")
.text(function(d, i) { return sentName; });
svg.append("text")
.attr("x", 525)
.attr("y", y1)
.style("font-size", "14px")
.style("font-weight", "bold")
.text(function(d, i) { return sentVal; });
y1 = y1+50;
svg.append("line")
	.attr("x1","-175")
	.attr("y1",y2-40)
	.attr("x2","900")
	.attr("y2",y2-40)
	.style("stroke", "black");
svg.append("rect")
.attr("fill","#c6dbef" )
.attr("x",-175)
.attr("y",-109)
.attr("width","900")
.attr("height","38");
svg.append("text")
.attr("x", 50)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return "Link in Mail"; });

svg.append("text")
.attr("x", 505)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return "Opened"; });

svg.append("text")
.attr("x", 580)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return "Not-Opened"; });

svg.append("line")
	.attr("x1","-175")
	.attr("y1",y2)
	.attr("x2","900")
	.attr("y2",y2)
	.style("stroke", "black");

var stats = statData.split("**");
for (l=0;l<data.length;l++) {
		 y=y+40;
		y1=y1+40;
		y2=y2+40;
		t=t+2;
		/* svg.append("rect")
	.attr("fill","#c7e9c0" )
	.attr("x",220)
	.attr("y",y)
	.attr("width","900")
	.attr("height","40"); */
		svg.append("text")
		.attr("x", 525)
		.attr("y", y1)
		.attr("id", "link_"+m)
		.style("font-size", "14px")
		.text(function(d, i) { return stats[t]; });
		svg.append("text")
		.attr("x", 600)
		.attr("y", y1)
		.attr("id", "link_"+m)
		.style("font-size", "14px")
		.text(function(d, i) { return (sentVal - stats[t]); });
		if (stats[t-1].length >= 100) {
			var splitData = stats[t-1].match(/.{1,100}/g);
			svg.append("text")
			.attr("x", -175)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return splitData[0]; });
			var lnks = d3.select("#link_"+m);
			y2=12;
			for (k=1;k<splitData.length;k++) {
				svg.append("text")
				.attr("x",-175)
				.attr("y", y1+y2)
				.style("font-size", "14px")
				.text(function(d, i) { return splitData[k]; });
				y2=y2+12;
			}
		}else if (stats[t-1].length < 100) {
			svg.append("text")
			.attr("x", -175)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t-1]; });
		}
		m=m+1;
		svg.append("line")
		.attr("x1","-175")
		.attr("y1",y2)
		.attr("x2","900")
		.attr("y2",y2)
		.style("stroke", "black");
	}
}

function buildUserTable(id,graphTitle,csvData,statData,type) {
	 var width = 900,
	    height = 400;
	 var csvTag = document.getElementById(id);
		csvTag.text = csvData;
	 var data = d3.csv.parse(d3.select('#'+id).text());
	 var h2 = height / 2;
	 //if (data.length < 4) {
		 var h1 = data.length*40;
		 h1 = 150 + h1;
	/* }
	 else if (data.length > 4 && data.length < 10) {
	 	var h1 = data.length*70;
	 }else if (data.length > 10 && data.length < 20) {
		 var h1 = data.length*55;
	 } else {
		 var h1 = data.length*50;
	 } */
	var svg = d3.select("#graphs").append("svg")
	.attr("width", 900)
	.attr("height", h1)
	.append("g")
	.attr("transform", "translate(220," + h2 + ")");
svg.append("text")
.attr("x", 100)
.attr("y", -185)
.style("font-size", "16px")
.style("font-weight", "bold")
.text(graphTitle);
var y = -150;
var y1 = -135;
var y2 = -70;
var t=0;

y1 = y1+50;

svg.append("line")
	.attr("x1","-175")
	.attr("y1",y2-40)
	.attr("x2","900")
	.attr("y2",y2-40)
	.style("stroke", "black");
svg.append("rect")
.attr("fill","#c6dbef" )
.attr("x",-175)
.attr("y",-109)
.attr("width","900")
.attr("height","38");
svg.append("text")
.attr("x", 50)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return type; });

svg.append("text")
.attr("x", 505)
.attr("y", y1)
.style("font-size", "14px")
.text(function(d, i) { return "Count"; });

svg.append("line")
	.attr("x1","-175")
	.attr("y1",y2)
	.attr("x2","900")
	.attr("y2",y2)
	.style("stroke", "black");

var stats = statData.split("**");
for (l=0;l<data.length;l++) {
		 y=y+40;
		y1=y1+40;
		y2=y2+40;
		t=t+2;
		svg.append("text")
		.attr("x", 525)
		.attr("y", y1)
		.attr("id", "link_"+m)
		.style("font-size", "14px")
		.text(function(d, i) { return stats[t]; });

		if (stats[t-1].length >= 100) {
			var splitData = stats[t-1].match(/.{1,100}/g);
			svg.append("text")
			.attr("x", -175)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return splitData[0]; });
			var lnks = d3.select("#link_"+m);
			y2=12;
			for (k=1;k<splitData.length;k++) {
				svg.append("text")
				.attr("x",-175)
				.attr("y", y1+y2)
				.style("font-size", "14px")
				.text(function(d, i) { return splitData[k]; });
				y2=y2+12;
			}
		}else if (stats[t-1].length < 100) {
			svg.append("text")
			.attr("x", -175)
			.attr("y", y1)
			.attr("id", "link_"+m)
			.style("font-size", "14px")
			.text(function(d, i) { return stats[t-1]; });
		}
		m=m+1;
		svg.append("line")
		.attr("x1","-175")
		.attr("y1",y2)
		.attr("x2","900")
		.attr("y2",y2)
		.style("stroke", "black");
	}
}

</script>

<%
String mainMailName = SPMailType.MAIN.getValue();
int mainMailvalue = SPMailType.MAIN.ordinal();
String rem1MailName = SPMailType.REMINDER1.getValue();
int rem1MailValue = SPMailType.REMINDER1.ordinal();
String rem2MailName = SPMailType.REMINDER2.getValue();
int rem2MailValue = SPMailType.REMINDER2.ordinal();
String rem3MailName = SPMailType.REMINDER3.getValue();
int rem3MailValue = SPMailType.REMINDER3.ordinal();
%>

<div class="rsvpbox-title" style="width: 100%;">Mail Campaign - RSVP Reports</div>
<c:if test="${isAdmin || isReport}">
<div style="width:95% ; margin: 0 auto; padding: 15px 0px">
This report provides estimates and statistics to help guide, plan and improve your email campaigns. The reporting is based on (a) user-provided data and (b) the accuracy of an internal database with geolocation information maintained by the open source community. Users who opt-out or do not provide authorisation to load images will not be tracked. In this case, only the available data will be displayed.
</div>
<div style="border:1px solid #666666;padding:15px;">
	<div id="reportFilters">
		<!-- <div id="eventsDiv" style="margin-bottom:20px">
			<span style="padding-right: 20px; display: inline-block; width: 25%;font-weight:bold;">Filter by Event</span>
		</div>

		<div id="assetTypeDiv" style="margin-bottom:20px">
			<span style="padding-right: 20px; display: inline-block; width: 25%;font-weight:bold;">Filter by SPAssetType</span>
		</div> -->
		<div style="width:100%">
		<div id="campaignDiv" style="margin-bottom:20px;">
			<span style="padding-right: 20px; display: inline-block; width: 25%;font-weight:bold;">Filter by Campaign</span>
		</div>
		<div id="maiTypeDiv" style="margin-bottom:20px;">
			<span style="padding-right: 20px; display: inline-block; width: 25%;font-weight:bold;">Select Mail Type</span>
			<select id="mailType" style="display:inline-block;" OnChange = "javascript:getRsvpDetail('filters')">
				<option value="<%= mainMailvalue %>"><%= mainMailName %></option>
				<option value="<%= rem1MailValue %>"><%= rem1MailName %></option>
				<option value="<%= rem2MailValue %>"><%= rem2MailName %></option>
				<option value="<%= rem3MailValue %>"><%= rem3MailName %></option>
			</select>
		</div>
		</div>
		<div id="rsvpDiv" style="margin-bottom:20px;">
			<span style="padding-right: 22px; display: inline-block; width: 25%;font-weight:bold;">Filter by RSVP</span>
			<span id="rsvpName"></span>
		</div>
		<div>
			<span style="padding-right: 22px; display: inline-block; width: 25%;font-weight:bold;">Select a Chart Type</span>
			<select id="chartType" style="display:inline-block;" OnChange = "javascript:getRsvpDetail('getCount')">
				<option value="0"></option>
				<option value="bar">Horizontal Bar Chart</option>
				<option value="pie">Pie Chart</option>
				<option value="Vbar">Vertical Bar Chart</option>
				<option value="doughnut">Doughnut Chart</option>
			</select>
			<input type="button" value="Generate PDF" OnClick = "javascript:getRsvpDetail('htmltopdf')" style="display:inline-block;margin-left: 20px; ">
		</div>
	</div>
</div>
</c:if>
<c:if test="${!isAdmin && !isReport}">
<div>You don't have required role to access this page</div>
</c:if>
<div class="mask" id="siteLoader" style="display:none;">
		<div id="siteDetailLoader">
		Please wait while the page loads...<br /> <br />
		<img border="0" src="/SPReports-portlet/loading.gif" alt="loading">

		</div>
</div>
<div id="graphChart">
<div id="graphTitle" style="margin-top:20px;font-weight:bold;margin-left:10px;margin-bottom:30px"></div>
<div id="graphs">
</div>
<div id="noRecords" style="display: none;">
<div style="font-size: 20px; text-align: center; width: 71%;">Reports not available.</div>
</div>
</div>
<div id="pieLabel">
</div>

<script id="rsvpTypeCsv" type="text/csv"></script>
<script id="rsvpStatusCsv" type="text/csv"></script>
<script id="rsvpAttdCsv" type="text/csv"></script>
<script id="rsvpMailCsv" type="text/csv"></script>
<script id="rsvpCountryCsv" type="text/csv"></script>
<script id="mailLinkCsv" type="text/csv"></script>
<script id="typeNameCsv" type="text/csv"></script>
<script id="oSCsv" type="text/csv"></script>
<script id="familyCsv" type="text/csv"></script>
<script id="deviceCsv" type="text/csv"></script>
<script id="nameCsv" type="text/csv"></script>
<script id="typeCsv" type="text/csv"></script>
<script id="cmpMailOpn" type="text/csv"></script>
<script type="text/javascript">
addFiltersHtml();
</script>
