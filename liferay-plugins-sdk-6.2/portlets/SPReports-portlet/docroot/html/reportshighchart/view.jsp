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

<script src="https://ajax.googleapis.com/ajax/libs/prototype/1.7/prototype.js"></script>
<script src="https://code.highcharts.com/adapters/prototype-adapter.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script type="text/javascript">

var eventsJSONObject = ${eventsJSONObject};
var rsvpJSONObject = ${rsvpJSONObject};
var assetJSONObject = ${assetJSONObject};
var campJSONObject = ${campJSONObject};

var m = 0;
var chartCategories=[];
var chartData = [];
var pieChartData = [];
var allCharts=[];
var chartTitle=[];
var chartSubTitle=[];
var multipleChartTitle="";

document.observe("dom:loaded", function() {
	$("genChart").on("click", function(event) {
		var mainDiv = document.getElementById("chartContainerDiv");
		var n = 0;
		var chartType = "";
		var inSize = "";
		var chartTypeElm = document.getElementById("chartType");
		var chartTypeSel = chartTypeElm.options[chartTypeElm.selectedIndex].value;
		if (chartTypeSel == "doughnut") {
			inSize = '50%';
		}
		if ((chartTypeSel == "pie") || (chartTypeSel == "doughnut")) {
			for (k=1;k<pieChartData.length;k++) {
				if (pieChartData[k].length > 0) {
					var container = "container" + k;
					var divElement = document.createElement("div");
					divElement.setAttribute("id",container);
					divElement.setAttribute("style","margin-top:40px;");
					mainDiv.appendChild(divElement);
					chart1 = new Highcharts.Chart({
						 chart: {
							 	renderTo: container,
					            plotBackgroundColor: null,
					            plotBorderWidth: 0,//null,
					            plotShadow: false,
					        },
					        credits: {
					        	enabled: false,
					        },	
					        title: {
					            text: chartTitle[k]
					        },
					        subtitle: {
					            text: chartSubTitle[k]
					        },
					        tooltip: {
					            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					        },
					        plotOptions: {
					            pie: {
					                allowPointSelect: true,
					                cursor: 'pointer',
					                dataLabels: {
					                    enabled: true,
					                    format: '<b>{point.name}</b>',
					                    style: {
					                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                    }
					                }
					            }
					        },
					        series: [{
					            type: 'pie',
					            name: chartTitle[k],
					            innerSize: inSize,
					            data: pieChartData[k]
					        }],
					        exporting: {
						         sourceWidth: 1200,
						        scale: 3

						        }
						});
					allCharts[n] = chart1;
					n=n+1;
				}
			}
		}else {
			if (chartTypeSel == "bar") {
				chartType='bar';
			}else if (chartTypeSel == "Vbar") {
				chartType='column';
			}

			for (k=1;k<chartCategories.length;k++) {
				if ((chartCategories[k] != undefined) && (chartCategories[k].length > 0)) {
					var container = "container" + k;
					var divElement = document.createElement("div");
					divElement.setAttribute("id",container);
					mainDiv.appendChild(divElement);
					chart1 = new Highcharts.Chart({

					    chart: {
					        renderTo: container,
					        type: chartType,
					    },
					    credits: {
				        	enabled: false,
				        },
					    title: {
				            text: chartTitle[k]
					    },
					    subtitle: {
				            text: chartSubTitle[k]
				        },

					    xAxis: {
					        categories: chartCategories[k]
					    },

					    series: [{
					        data: chartData[k]}],

					   	exporting: {
					         sourceWidth: 1200,
					        scale: 3

					        }

					});
					allCharts[n] = chart1;
					n=n+1;
				}
			}
		}
	});

	$("export").on("click", function(event) {
	    Highcharts.exportCharts(allCharts);
	});

});

Highcharts.getSVG = function(chart) {
	var svgArr = [],
		top = 0,
		width = 0;
//alert("charts " + chart.size());
for (i=0;i<chart.length;i++) {
		var svg = chart[i].getSVG();
		//alert("for " +  i + " " + chart[i]);
		svg = svg.replace('<svg', '<g transform="translate(0,' + top + ')" ');
		svg = svg.replace('</svg>', '</g>');
		top += chart[i].chartHeight;
		width = Math.max(width, chart[i].chartWidth);
		//top=3000;
		svgArr.push(svg);
	}
	return '<svg height="'+ top +'" width="' + width + '" version="1.1" xmlns="https://www.w3.org/2000/svg" style="padding-top:150px">' + svgArr.join('') + '<text class="highcharts-title" text-anchor="middle" y="-90" x="600"><tspan x="600">' + multipleChartTitle + '</tspan></text></svg>';
};

/**
 * Create a global exportCharts method that takes an array of charts as an argument,
 * and exporting options as the second argument
 */
Highcharts.exportCharts = function(charts, options) {
	var form
		svg = Highcharts.getSVG(charts);

	// merge the options
	options = Highcharts.merge(Highcharts.getOptions().exporting, options);

/* Highcharts.exportChart({
		type: 'application/pdf',
	}); */

	// create the form
	form = Highcharts.createElement('form', {
		method: 'post',
		action: options.url
	}, {
		display: 'none'
	}, document.body);

	// add the values
	Highcharts.each(['filename', 'type', 'width', 'svg'], function(name) {
		Highcharts.createElement('input', {
			type: 'hidden',
			name: name,
			value: {
				filename: options.filename || 'chart',
				type: 'application/pdf',
				title:'middle',
				width: options.width,
				svg: svg
			}[name]
		}, null, form);
	});
	//console.log(svg); return;
	// submit
	form.submit();

	// clean up
	form.parentNode.removeChild(form);
};

function addFiltersHtml() {

	var campDiv = document.getElementById("campaignDiv");
	var rsvpDiv = document.getElementById("rsvpDiv");
	var campSelect = document.createElement("select");
	campSelect.setAttribute("name","campSelect");
	campSelect.setAttribute("id","campSelect");
	campSelect.setAttribute("onChange","javascript:loadCampaignEDMS()");
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

}

function loadCampaignEDMS(){
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var mailTypeSel = document.getElementById("mailType");
	var selectedCampaign = document.getElementById("campSelect");
	var selectedCampaignValue = selectedCampaign.options[selectedCampaign.selectedIndex].value;
	mailTypeSel.innerHTML="";
	var A = AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	
	A.io
	.request(
			reqUrl,
			{
				cache : false,
				sync : true,
				timeout : 1000,
				dataType : 'json',
				method : 'post',
				data : {
					type : "getMailType",
			    	selectedCampaign : selectedCampaignValue
				},
				on : {
					success : function() {
						items = this.get('responseData');
						
						if (items) {
			        		for (key in items) {
			        			campOption=document.createElement("Option");
			        			campOption.setAttribute("value",key);
			        			var optTextNode = document.createTextNode(items[key]);
			        			campOption.appendChild(optTextNode);
			        			mailTypeSel.appendChild(campOption);
			        		}
			        		getRsvpDetail('filters');
			        	}else{
			        		alert("No EDMs found for the selected campaign. Please try another campaign.")
			        	}	

					},
					failure : function() {

					}
				}

			});
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
	var createChart = false;
	var mailSel = document.getElementById("mailType");
	mailType = mailSel.options[mailSel.selectedIndex].value;
	var chartTypeSel = document.getElementById("chartType");
	chartTypeSel = chartTypeSel.options[chartTypeSel.selectedIndex].value;
	var mailTypeSelected = mailSel.options[mailSel.selectedIndex].innerHTML;
	document.getElementById("noRecords").style.display="none";

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
	       //	var count = Object.keys(items).length;
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
										textElm= splitData;
									}else {
										textElm = nameValues[key];
									}
								}
								if ((key == "rsvpName") && (nameValues[key] != ""))
									rsvpName = nameValues[key];
								if ((key == "eventName") && (nameValues[key] != ""))
									eventName = nameValues[key];
								if ((key == "contest") && (nameValues[key] != ""))
									contest = nameValues[key];
							}
							multipleChartTitle = textElm + " " + rsvpName + " " + eventName + " " + contest;
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

							var sent=0;
							var deliveredMail=0;
							var dMail = 0;
							var totalRsvp = 0;
							var tmp = document.getElementById("graphs");
							tmp.innerHTML="";
							var j = 0;
							for (key in items) {
								//if ((key == "Invitation") || (key == "Admin-Registration") || (key == "Registration"))
								if (key == "sourceCount") {
									var sourceCountValues = items[key];
									for (key in sourceCountValues) {
										var c = sourceCountValues[key];
										//csvData = csvData + "\n" + key + "," + c;
										//statData1 = statData1 + "**" + key + "**" + c;
									}
								}
								//if ((key == "Attending") || (key == "Not-Attending") || (key == "MayBe") || (key == "Waiting"))
								if (key == "statusCount") {
									var statusCountValues = items[key];
									for (key in statusCountValues) {
										var c = statusCountValues[key];
										//csvData1 = csvData1 + "\n" + key + "," + c;
										//statData2 = statData2 + "**" + key + "**" + c;
									}
								}
								//if ((key == "Attended") || (key == "Not-Attended"))
								if (key == "atdCount") {
									var atdCountValues = items[key];
									for (key in atdCountValues) {
										var c = atdCountValues[key];
										//csvData2 = csvData2 + "\n" + key + "," + c;
										//statData3 = statData3 + "**" + key + "**" + c;
									}
								}
								if (key == "totalRsvp") {
									totalRsvp = items[key];
								}
								//if ((key == "Sent") || (key == "Bounced") || (key == "Bounce-Soft") || (key == "Complain") || (key == "Opened") || (key == "Delivered")) {
								if (key == "mailCount") {
									var mailCountValues = items[key];
									var c = 0;
									var i =0;
									var l =0;
									var pieData1 = [];
									var pieData2 = [];
									var categories1=[];
									var data1=[];
									var categories2=[];
									var data2=[];
									for (key in mailCountValues) {
										c = mailCountValues[key];
										if (key != "Sent") {
											if (key == "Delivered") {
												deliveredMail = "**Total Mails Delivered " + c;
												dMail = c;
											}
											if ((key == "Opened") || (key == "Not-Opened")) {
												/* csvData6 = csvData6 + "\n" + key + "," + c;
												statData7 = statData7 + "**" + key + "**" + c; */
												var pieCategories=[];
												var c = mailCountValues[key];
												categories2[l] = key;
												data2[l] = c;
												pieCategories[0] = key;
												pieCategories[1] = c;
												var actVal = pieCategories[0] + "-" + c;
												pieData2[i]=[actVal,pieCategories[1]];
												l=l+1;
											}
											if ((key == "Bounced") || (key == "Bounce-Soft") || (key == "Complain") || (key == "Delivered")) {
												/* csvData3 = csvData3 + "\n" + key + "," + c;
												statData4 = statData4 + "**" + key + "**" + c; */
												var pieCategories=[];
												var c = mailCountValues[key];
												categories1[i] = key;
												data1[i] = c;
												pieCategories[0] = key;
												pieCategories[1] = c;
												var actVal = pieCategories[0] + "-" + c;
												pieData1[i]=[actVal,pieCategories[1]];
												i=i+1;
											}
										}
										else {
											sent = "**Total Mails Sent " + c;
											chartSubTitle[j] = sent;
										}
									}
										chartCategories[j] = categories1;
										chartData[j] = data1;
										pieChartData[j] = pieData1;
										chartTitle[j] = "Mail Delivered Details";
										j=j+1;
										chartCategories[j] = categories2;
										chartData[j] = data2;
										pieChartData[j] = pieData2;
										chartTitle[j] = "Mail Opened Details";
										chartSubTitle[j] = deliveredMail;
								}
								if (key == "countryCount") {
									var countryCountValues = items[key];
									totalOpened = 0;
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var pieCategories=[];
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
										totalOpened= totalOpened + c;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									//alert("if pieChartData " + j + " " + pieChartData);
									chartTitle[j] = "Mail Opened by Location";
								}
								if (key == "linkJSONObject") {
									var pieCategories=[];
									var countryCountValues = items[key];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									//alert("if pieChartData " + j + " ggg " + pieChartData);
									chartTitle[j] = "Mail Links Opened";
								}
								 if (key == "typeNameJSONObject") {
									var countryCountValues = items[key];
									var pieCategories=[];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									chartTitle[j] = "Statistics by Type Name";
								}
								if (key == "oSJSONObject") {
									var countryCountValues = items[key];
									var pieCategories=[];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									chartTitle[j] = "Statistics by Operating System";
								}
								if (key == "familyJSONObject") {
									var countryCountValues = items[key];
									var pieCategories=[];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									chartTitle[j] = "Statistics by Family";
								}
								 if (key == "deviceJSONObject") {
									var countryCountValues = items[key];
									var pieCategories=[];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									chartTitle[j] = "Statistics by Device Category";
								}
								 if (key == "nameJSONObject") {
									var countryCountValues = items[key];
									var pieCategories=[];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									chartTitle[j] = "Statistics by Name";
								}
								 if (key == "typeJSONObject") {
									var countryCountValues = items[key];
									var pieCategories=[];
									var i =0;
									var pieData1 = [];
									var categories1=[];
									var data1=[];
									for (key in countryCountValues) {
										var c = countryCountValues[key];
										categories1[i] = key;
										data1[i] = c;
										pieCategories[0] = key;
										pieCategories[1] = c;
										var actVal = pieCategories[0] + "-" + c;
										pieData1[i]=[actVal,pieCategories[1]];
										i=i+1;
									}
									chartCategories[j] = categories1;
									chartData[j] = data1;
									pieChartData[j] = pieData1;
									chartTitle[j] = "Statistics by Type";
								}
								j=j+1;
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
<div style="margin: 0 auto; padding: 15px 0px">
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
			<span style="padding-right: 20px; display: inline-block; width: 25%;font-weight:bold;">Select EDM</span>
			<select id="mailType" style="display:inline-block;" OnChange = "javascript:getRsvpDetail('filters')">
			</select>
		</div>
		</div>
<div id="rsvpDiv" style="margin-bottom:20px;display:none">
			<span style="padding-right: 22px; display: inline-block; width: 25%;font-weight:bold;">Filter by RSVP</span>
			<span id="rsvpName"></span>
		</div>
		<div>
			<span style="padding-right: 22px; display: inline-block; width: 25%;font-weight:bold;">Select a Chart Type</span>
			<select id="chartType" style="display:inline-block;" OnChange = "javascript:getRsvpDetail('getCount')">
				<option value="0"></option>
				<option value="line">Simple Line</option>
				<option value="bar">Horizontal Bar Chart</option>
				<option value="pie">Pie Chart</option>
				<option value="Vbar">Vertical Bar Chart</option>
				<option value="doughnut">Doughnut Chart</option>
			</select>
		</div>
	</div>
	<div style="text-align:center;margin-top:20px;">
	<input id="genChart" type="button" value="Generate Chart" class="btn-primary">
	<button id="export" class="btn-primary">Export all</button>
</div>
</div>

<div id="chartContainerDiv">
</div>

</c:if>
<c:if test="${!isAdmin && !isReport}">
<div>You don't have required role to access this page</div>
</c:if>
<div class="mask" id="siteLoader" style="display:none;">
		<div id="siteDetailLoader">
		Please wait while the page loads...<br /> <br />
		<img border="0" src="/SPReports-portlet/loading.gif" alt="Loading">

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

<script type="text/javascript">
addFiltersHtml();

/* -- code for pie-donut chart
series: [{
type: 'pie',
categorieField: 'vendor',
dataField: 'share',
name: 'Browsers',
size: '60%',
totalDataField: true,
data: pieChartData[k]
}, {
type : 'pie',
categorieField : 'version',
dataField: 'share',
name: 'Versions',
innerSize: '60%',
dataLabels: data: pieChartData[k]
}]
*/
</script>
