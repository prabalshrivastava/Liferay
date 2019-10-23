<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<style>
.gecko .lfr-input-time,.ie .lfr-input-time {
	float: right;
	margin-top: 2px;
}

.cke_skin_kama a.cke_dialog_ui_button {
	display: none !important;
}
</style>

<%@ include file="/html/common/init.jsp" %>

<%
	String url = PortalUtil.getPortalURL(themeDisplay);
	String totalCount = String.valueOf(renderRequest
			.getAttribute("totalCount"));
	String previewIcon = String.valueOf(renderRequest
			.getAttribute("previewIcon"));
	String textcontentIcon = String.valueOf(renderRequest
			.getAttribute("textcontentIcon"));
	String testIcon = String.valueOf(renderRequest
			.getAttribute("testIcon"));
	String archiveIcon = String.valueOf(renderRequest
			.getAttribute("archiveIcon"));
%>

<c:choose>
	<c:when test="${!hasAccess}">
		<h3>You don't have the permission to access this url!"</h3>
	</c:when>
	<c:otherwise>

		<div class="rsvpbox-title" style="width: 100%;">Mail Template</div>
		<%!public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.upload-invitersvp.jsp"; %>
		<portlet:defineObjects />
		<input type="hidden" value="${templatePage}" name="templatePage"
			id="templatePage" />
		<div class="rsvp-preference-border screen-max-width" style="min-height: 300px;">
			<div id="rsvpDiv" style="width: 100%; padding: 10px 0;">
				<c:if test="${updateMessage}">
					<div id="successMsgTemplate">
						Mail Template is successfully updated.</div>
				</c:if>
				<div class="addClass">
						<span><a href="/${templatePage}?redirect=<%= currentURL %>">+
								Add new Mail Template</a></span>
					</div>
				<div id="existingDiv" style="min-height: 280px;">
					<table id="rsvpDetails">
						<tr style="height: 30px; font-weight: bold;">
							<td class="template-list" colspan="9">Template List</td>
						</tr>
						<tr>
							<td class="template-list" colspan="9" style="padding: 10px">
								<div style="float: right;">
									<span>Page</span>

									<c:if test="${!empty totalCount}">
										<select id="pageNo" name="pageNo"
											onchange="loadMailTemplate();">

											<%
												for (int i = 1; i <= Integer.parseInt(request
																	.getAttribute("totalCount").toString()); i++) {
											%>

											<option value="<%= i %>"><%= i %></option>

											<%
												}
											%>

										</select>
									</c:if>
								</div>
							</td>
						</tr>
					</table>

				</div>
			</div>
			<!-- end rsvpDiv -->
		</div>
		<!-- end rsvp-preference-border -->
		<div class="white_content" id="light">


			<div class="campaign-mainTitle">
				<div id="campaignSubject" class="campaignSubject"
					style="display: inline-block; width: 87%;">&nbsp;</div>
				<div
					style="display: inline-block; width: 11%; float: right; text-align: right; padding-right: 10px;">
					<a href="javascript:void(0)" onclick="closeTemplateScreen()">Close</a>
				</div>
			</div>
			<!-- <div style="width: 96%; padding-left: 10px; padding-top: 10px;">
					<div class="mailtemplate-subtitle"
						style="font-size: 15px; background: none repeat scroll 0% 0% transparent; text-align: left; padding-left: 0px;">Subject</div>
					<div id="campaignSubject">&nbsp;</div>
				</div>-->

			<div style="width: 96%; padding-left: 10px; padding-top: 10px;">
				<div class="mailtemplate-subtitle"
					style="font-size: 15px; background: none repeat scroll 0% 0% transparent; text-align: left; padding-left: 0px;">HTML
					Content</div>
				<div id="campaignHTMLContent">&nbsp;</div>
			</div>
		</div>

		<div class="black_overlay" id="fade"></div>

		<script>
		
		var A = AUI(); // initializing instead putting null into A. 
AUI().ready('aui-node','aui-io-request',function(A1) {
	A = A1;
	loadMailTemplate();
});
function loadMailTemplate() {
	var templatePage = document.getElementById("templatePage").value;
	var previewIcon = '<%= previewIcon %>';
	var textcontentIcon = '<%= textcontentIcon %>';
	var testIcon = '<%= testIcon %>';
	var archiveIcon = '<%= archiveIcon %>';
	var AI=A;
	var items = null;
	var arr = [];
	var reqUrl = '<portlet:resourceURL id="" />';
	var e = document.getElementById("pageNo");
	var filter;
	if (document.getElementById("pageNo")) {
		filter= e.options[e.selectedIndex].value;
	}else {
		filter=1;
	}
	var existingDiv = document.getElementById("existingDiv");
	existingDiv.innerHTML = "";
	var totalCount = <%= totalCount %>;
	var templateTable = document.createElement("table");
	templateTable.setAttribute("id","rsvpDetails");
	var tblBody = document.createElement("tbody");
	var tblCRow = document.createElement("tr");
	tblCRow.setAttribute("style","height: 30px;font-weight:bold;");

	var tblCol = document.createElement("td");
	tblCol.setAttribute("class","template-list");
	tblCol.setAttribute("colspan","9");
	var cellText = document.createTextNode("Template List");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);
	tblBody.appendChild(tblCRow);
	templateTable.appendChild(tblBody);
	existingDiv.appendChild(templateTable);

	tblCRow = document.createElement("tr");
	tblCRow.setAttribute("style","height: 30px;font-weight:bold;");

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Title");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Version");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Subject");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Modified By");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Modified Date");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("HTMLUpload");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Preview");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Test");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblCol = document.createElement("td");
	tblCol.setAttribute("class","mailtemplate-list-title");
	cellText = document.createTextNode("Archive");
	tblCol.appendChild(cellText);
	tblCRow.appendChild(tblCol);

	tblBody.appendChild(tblCRow);
	templateTable.appendChild(tblBody);
	existingDiv.appendChild(templateTable);
	try{
	 	AI.io.request(reqUrl, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterName:"pageChange",
		   	 filterValue:filter,
		    },

		    on: {
		        success: function() {
		       	 items = this.get('responseData');
		       	if (items) {
					for (key in items) {
						arr.push(items[key]);
					}
					for (var j=arr.length-1; j>=0; j--) {
						var tblRow = document.createElement("tr");
						tblBody.appendChild(tblRow);
						var cellTextValues = arr[j];
						tblRow.setAttribute("data-template-id", key);
						var titleCol = document.createElement("td");
						titleCol.setAttribute("class","mailtemplate-list-title");

						var versionCol = document.createElement("td");
						versionCol.setAttribute("class","mailtemplate-list-title");

						var subjectCol = document.createElement("td");
						subjectCol.setAttribute("class","mailtemplate-list-title");

						var modifiedByCol = document.createElement("td");
						modifiedByCol.setAttribute("class","mailtemplate-list-title");

						var modifiedDateCol = document.createElement("td");
						modifiedDateCol.setAttribute("class","mailtemplate-list-title");

						var htmlUploadCol = document.createElement("td");
						htmlUploadCol.setAttribute("class","mailtemplate-list-title");

						var previewCol = document.createElement("td");
						previewCol.setAttribute("class","mailtemplate-list-title");

						var testCol = document.createElement("td");
						testCol.setAttribute("class","mailtemplate-list-title");
						testCol.setAttribute("style","text-align:center");

						var archiveCol = document.createElement("td");
						archiveCol.setAttribute("class","mailtemplate-list-title");
						archiveCol.setAttribute("style","text-align:center");

						tblRow.appendChild(titleCol);
						tblRow.appendChild(versionCol);
						tblRow.appendChild(subjectCol);
						tblRow.appendChild(modifiedByCol);
						tblRow.appendChild(modifiedDateCol);
						tblRow.appendChild(htmlUploadCol);
						tblRow.appendChild(previewCol);
						tblRow.appendChild(testCol);
						tblRow.appendChild(archiveCol);

						for (key in cellTextValues) {
							//alert(key);
							//alert(cellTextValues['id']);
							//alert("******");
							switch(key) {
								case "title":
									var cellText = document.createTextNode(cellTextValues[key]);
									var hrefElement = document.createElement("a");
									hrefElement.setAttribute("href","/"+templatePage+"?detailTemplateId="+cellTextValues['id']);
									hrefElement.appendChild(cellText);
									titleCol.appendChild(hrefElement);

									var previewImage = document.createElement("img");
									previewImage.setAttribute("src",previewIcon);
									previewImage.setAttribute("style","vertical-align:middle");
									var previewHrefElement = document.createElement("a");
									previewHrefElement.setAttribute("onclick","loadContent("+cellTextValues['id']+")");
									previewHrefElement.setAttribute("id","htmlContent");
									var previewText = document.createTextNode(" HTML ");
									previewHrefElement.appendChild(previewImage);
									previewHrefElement.appendChild(previewText);

									var textCotentImage = document.createElement("img");
									textCotentImage.setAttribute("src",textcontentIcon);
									var textCotentHrefElement = document.createElement("a");
									//textCotentHrefElement.setAttribute("onclick","loadTextContent("+cellTextValues['id']+")");
									var textContentText = document.createTextNode(" Text ");
									textCotentHrefElement.appendChild(textCotentImage);
									textCotentHrefElement.appendChild(textContentText);

									previewCol.appendChild(previewHrefElement);

									var pinText = document.createTextNode(" | ");

									previewCol.appendChild(pinText);
									previewCol.appendChild(textCotentHrefElement);

									var testImage = document.createElement("img");
									testImage.setAttribute("src",testIcon);
									testImage.setAttribute("onclick", "startToTest("+cellTextValues['id']+")");

									testCol.appendChild(testImage);

									var archiveImage = document.createElement("img");
									archiveImage.setAttribute("src",archiveIcon);
									archiveImage.setAttribute("onclick", "startToArchive("+cellTextValues['id']+")");

									archiveCol.appendChild(archiveImage);

									break;
								case "version":
									var cellText = document.createTextNode(cellTextValues[key]);
									versionCol.appendChild(cellText);
									break;

								case "subject":
									var cellText = document.createTextNode(cellTextValues[key]);
									subjectCol.appendChild(cellText);
									break;
								case "modifiedBy":
									var cellText = document.createTextNode(cellTextValues[key]);
									modifiedByCol.appendChild(cellText);
									break;
								case "modifiedDate":
									var cellText = document.createTextNode(cellTextValues[key]);
									modifiedDateCol.appendChild(cellText);
									break;
								case "htmlUpload":
									var cellText = document.createTextNode(cellTextValues[key]);
									htmlUploadCol.appendChild(cellText);
									break;
							}

						}
					}


					var attSel = document.createElement("select");
					attSel.setAttribute("name","pageNo");
					attSel.setAttribute("id","pageNo");
					attSel.setAttribute("onchange","javascript:loadMailTemplate()");
					var selectDiv = document.createElement("div");
					selectDiv.setAttribute("style","float:right");

					var selectSpan = document.createElement("span");
					selectSpan.appendChild(document.createTextNode("Page"))

					//alert("x " + x + " key " + key);

					//alert(totalCount);
					for (var i=1;i<=totalCount;i++) {

						 var attOpt;
							attOpt = document.createElement("option");
						attOpt.setAttribute("value",i);
						attOpt.innerHTML = i;
						if ((i==filter)) {
							attOpt.setAttribute("selected","selected");
						}
						attSel.appendChild(attOpt);
					}

					var tblRowPage = document.createElement("tr");
					var tblColPagge = document.createElement("td");
					tblColPagge.setAttribute("style","padding:10px;");
					tblColPagge.setAttribute("class","template-list");
					tblColPagge.setAttribute("colspan","9");
					selectDiv.appendChild(selectSpan);
					selectDiv.appendChild(attSel);
					tblColPagge.appendChild(selectDiv);
					tblRowPage.appendChild(tblColPagge);
					tblBody.appendChild(tblRowPage);
		       	}
		        },
		        failure: function() {
		        }
		    }
		});

	return true;
}catch(err) {
} 
}
</script>

<script type="text/javascript">
function loadMailTemplateDetail(templateId) {
	var AI=A;
	var itemis = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
	document.getElementById("newFlag").value="flase";
	document.getElementById("updateTemplateId").value=templateId;

	try{
	 	AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterName:"templateDetail",
		   	 filterValue:templateId,
		    },

		    on: {
		        success: function() {
		       	 itemis = this.get('responseData');
		       	if (itemis) {
		       		for (key in itemis) {
		       			var cellTextValues = itemis[key];
		       			for (key in cellTextValues) {
		       				switch(key) {
		       				case "title":document.getElementById("templateTitle").value=cellTextValues[key];break;
		       				case "subject":document.getElementById("txtSubject").value=cellTextValues[key];break;
		       				case "htmlContent":setContentFromEditor(cellTextValues[key]);break;
		       				case "textContent":document.getElementById("txtHtmlContent").value=cellTextValues[key];break;
		       				case "attachment": var data = cellTextValues[key].split(",");
		       									var attachments = "";
		       									for (var i=0;i<data.length;i++) {
		       										if (data[i].length>0) {
		       											var fileEntryId = data[i].split(":");
		       											fileEntryArray = "";

		       											if (fileEntryArray.indexOf(fileEntryId[1])==-1) {
		       												fileEntryArray += fileEntryId[1];
		       											}

		       						 					document.getElementById("attachmentsFileTotal").value=fileEntryArray;
			       										attachments = "<div id='"+fileEntryId[1]+"'><input type='hidden' value='"+'<%= url %>'+fileEntryId[0]+"' name='item"+i+"' id='item"+i+"'/><font style='padding-right:15px;font-weight:bold;'> Attachment url :</font>"  +
			       													"<br /><a href='"+'<%= url %>'+fileEntryId[0]+"' style='display:inline-block;padding-right:20px;' target='_blank'>"+'<%= url %>'+ fileEntryId[0]+"</a>" +
			       													"<a onclick='deleteFile("+fileEntryId[1]+")'> Delete</a></div>";
		       										}

		       									}
		       									document.getElementById("divAttach").innerHTML = attachments;
		       									break;
		       				}
		       			}
		       		}

		       	}
		        },

		        failure: function() {
		        }
		    }
		});

	return true;
}catch(err) {
}
}
</script>
<script>
function loadContent(obj) {
	var AI= A;
	var itemis = null;
	var subject = null;
	var htmlContent = null;
	var textContent = null;
	var campaignName = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
		//document.getElementById("light").style.display='block';
		//document.getElementById("fade").style.display='block'

			try{
			 	AI.io.request(reqUrlis, {
				    cache: false,
				    sync: true,
				    timeout: 1000,
				    dataType: 'json',
				    method: 'post',
				    data:{
				   	 filterName:"templateDetail",
				   	 filterValue:obj,
				    },

				    on: {
				        success: function() {
				       	 itemis = this.get('responseData');
				        if (itemis) {
				       		for (key in itemis) {
				       			var cellTextValues = itemis[key];
				       			console.log("cellTextValues " +  JSON.stringify(cellTextValues));
				       			for (key in cellTextValues) {
				       				switch(key) {
					       				case "subject": subject=cellTextValues[key];break;
					       				case "htmlContent": htmlContent=cellTextValues[key];break;
					       				case "textContent": textContent=cellTextValues[key];break;
				       				}
				       			}
				       		}
				       		//zzzdocument.getElementById("campaignSubject").innerHTML=subject;
				       		//document.getElementById("campaignHTMLContent").innerHTML=htmlContent;
				       		var myWindow = window.open("", subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
				       		myWindow.document.write(htmlContent);
				       		//window.open(htmlContent,subject,'width=640,location=no,toolbar=no,menubar=no,status=no,resizable=1,scrollbars=yes,height=700,top=100,left=100');
				       	}
				        },

				        failure: function() {
				        }
				    }
				});

		 	return true;
		}catch(err) {
		}

}
function startToTest(obj) {
	var AI= A;
	var reqUrlis = '<portlet:resourceURL id="" />';

	try{
	 	AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'get',
		    data:{
				filterName:"testTemplate",
			   	filterValue:obj,
		    },
		    on: {
		        success: function() {
		        	<portlet:namespace />callPopup("Success", "Your request has been processed successfully!");
		        },
		        failure: function() {
		        	<portlet:namespace />callPopup("Failure", "Oops! An error occurred while processing your request.");
		        }
		    }
		});

		return true;
	}catch(err) {
	}

}

function startToArchive(obj) {
	var AI= A;
	var reqUrlis = '<portlet:resourceURL id="" />';

	try{
	 	AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'get',
		    data:{
				filterName:"archive",
			   	filterValue:obj,
		    },
		    on: {
		        success: function() {
					var archivedTblRow = getFirstElementsByAttribute(document, "tr", "data-template-id", obj);
					archivedTblRow.parentNode.removeChild(archivedTblRow);
					<portlet:namespace />callPopup("Success", "Your request has been processed successfully!");
		        },
		        failure: function() {
		        	<portlet:namespace />callPopup("Failure", "Oops! An error occurred while processing your request.");
		        }
		    }
		});

		return true;
	}catch(err) {
	}

}

function closeTemplateScreen() {
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none';
	document.getElementById("campaignSubject").innerHTML=" ";
	document.getElementById("campaignHTMLContent").innerHTML=" ";
}
</script>


<aui:script >

	function <portlet:namespace />callPopup(title, content) {

		AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {

			var dialog = Liferay.Util.Window.getWindow(
{
dialog: {

			title: title,

			centered: true,

			modal: true,

			width: 500,

			height: 250,

			bodyContent: content

			}}).render();

		});

	}

</aui:script >

<%-- <aui:script use="aui-button-item-deprecated,liferay-util-window">

AUI().use('aui-base', function(A) {

	var htmlpopupContent = A.one('#htmlpopupContent')
	alert("htmlpopupContent " +htmlpopupContent);
	if (htmlpopupContent) {
		htmlpopupContent.on(
			'click',
			function(event) {
			alert("dwfer");
				var name = document.getElementById("campaignSubject").innerHTML;
				var title = document.getElementById("campaignHTMLContent").innerHTML;
				_callPopup(name,title);
			},
			'.spjobs-service-access'
		);
	}

	function _callPopup(name, title) {
		var popup = Liferay.Util.Window.getWindow(
{
dialog: {
				centered: true,
				destroyOnClose: true,
				title: title,
				modal: true,
				height: 219,
				width: 515
			}}
		).render();

		popup.plug(
			A.Plugin.IO, {
				uri: name
			}
		);
	}

});
</aui:script> --%>

	</c:otherwise>
</c:choose>
