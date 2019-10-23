<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
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
	String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
	String templateDescLabel = "Template content";
	if(Validator.isNotNull(renderRequest.getAttribute("emailTemplateContent"))){
		templateDescLabel = String.valueOf(renderRequest.getAttribute("emailTemplateContent"));
	}
	String url = PortalUtil.getPortalURL(themeDisplay);
	String totalCount = String.valueOf(renderRequest.getAttribute("totalCount"));
	String previewIcon = String.valueOf(renderRequest.getAttribute("previewIcon"));
%>

<c:choose>
	<c:when test="${!hasAccess}">
		<h3>You don't have the permission to access this url!"</h3>
	</c:when>
	<c:otherwise>

		<div class="rsvpbox-title" style="width: 100%;">Create Mail
			Template</div>
		<%-- <%!public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.spmailtemplatecreate.jsp"; %> --%>
		<portlet:defineObjects />
		<portlet:actionURL var="createNewTemplate">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="action" value="createTemplate" />
			<portlet:param name="rsvpRedirect" value="${rsvpRedirect}"></portlet:param>
		</portlet:actionURL>
		<div class="rsvp-preference-border screen-max-width" style="min-height: 300px;">
			<div id="rsvpDiv" style="width: 100%; padding: 10px 0;">
				<c:if test="${!empty success}">
					<div id="successMsgTemplate"
						style="background: #f2f2f2; color: green; font-weight: bold; margin-top: 10px; padding: 10px; height: 18px; width: 97%;">
						Mail Template is successfully created.</div>
					<c:if test="${!empty rsvpId}">
						<div
							style="float: right; margin-bottom: 10px; margin-top: 10px; padding-right: 14px; text-align: right; width: 100%;">
							<a href="${rsvpRedirectURL}&rsvpId=${rsvpId}">Back to Invite
								Rsvp page</a>
						</div>
					</c:if>
				</c:if>

				<c:if test="${empty success}">
					<c:if test="${!empty rsvpId}">
						<div
							style="float: right; margin-bottom: 10px; margin-top: 10px; padding-right: 14px; text-align: right; width: 100%;">
							<a href="${rsvpRedirect}&rsvpId=${rsvpId}">Back to Invite
								Rsvp page</a>
						</div>
					</c:if>
				</c:if>

				<div id="newTemplateDiv">
					<form action="<%= createNewTemplate %>"
						onSubmit="<portlet:namespace />extractCodeFromEditor();"
						method="post">
						<input type="hidden" id="attachmentsFileTotal"
							name="attachmentsFileTotal" /> <input type="hidden"
							id="imageFileTotal" name="imageFileTotal" /> <input type="hidden"
							name="attachmentsTotal" id="attachmentsTotal" /> <input
							type="hidden" id="rsvpId" name="<portlet:namespace />rsvpId" value="${rsvpId}" /> <input
							type="hidden" id="rsvpRedirect" name="<portlet:namespace />rsvpRedirect"
							value="${rsvpRedirect}" /> <input type="hidden" id="newFlag"
							name="newFlag" value="true" /> <input type="hidden"
							id="updateTemplateId" name="updateTemplateId" /> <input
							type="hidden" id="detailTemplateId" name="<portlet:namespace />detailTemplateId"
							value="${detailTemplateId}" /> <input type="hidden"
							id="campaignId" name="campaignId" value="${campaignId}" /> 
							 <input
							type="hidden" id="htmlUpload" name="htmlUpload" />

						<div style="padding-top: 10px; padding-bottom: 10px;">
							<label class="control-label">
								MailTemplate Title</label>
							<div>
								<c:if test="${empty detailTemplateId}">
									<input name="<portlet:namespace />templateTitle" type="text" id="templateTitle"
										style="width: 300px;" />
								</c:if>
								<c:if test="${!empty detailTemplateId}">
									<input name="<portlet:namespace />templateTitle" type="text" id="templateTitle"
										style="width: 300px;" readonly />
								</c:if>

							</div>
						</div>

						<div style="padding-top: 10px; padding-bottom: 10px;">
							<label class="control-label">
								Subject</label>
							<div>
								<input id="txtSubject" type="text" name="<portlet:namespace />txtSubject"
									value="${txtSubject}" style="width: 300px;" />
							</div>
						</div>


						<div style="padding-top: 10px; padding-bottom: 10px;">
							<div style="width: 100%;display: inline-block;">
								<label class="control-label">
									HTML Mail Content</label>
								<div id="previewIcon" style="width: 60%; display: none;">
									<a><img src="${previewIcon}" alt="Preview"/> </a>
								</div>
								<div id="emailTemplateName" style="display: none;">
									<a onclick="loadContent(${detailTemplateId})">${emailTemplateName}</a>
								</div>
							</div>

							<div id="selectSubscriberType" style="margin: 10px;">
								<div>
									<input type="radio" name="<portlet:namespace />optionType"
										style="margin-bottom: 10px;" id="optionFilter"
										onchange="addSubscriberChange(this)"> Add By Editor
								</div>
								<div>
									<input name="<portlet:namespace />optionType" type="radio" id="optionUpload"
										onchange="addSubscriberChange(this)"> Upload HTML
								</div>
							</div>

							<div id="addByFilter" style="width: 98%; display: none;">
								<%-- <liferay-ui:input-editor toolbarSet="liferay-article" /> --%>
								
								<liferay-ui:input-editor name='<%="template_content"%>'
									editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="toolbar_liferayArticle_withoutImage"
									initMethod='<%="initEditor_template_content"%>'
									cssClass="ckeditor" />
								<input name="<portlet:namespace />EditorContent" id="EditorContent" type="hidden" />
								<aui:script>
									function <portlet:namespace />initEditor_template_content() {
										return "<%=UnicodeFormatter.toString(templateDescLabel)%>";
									}
								</aui:script>
								
							</div>
							<div id="addByHtml" style="display: none;">
								<label class="control-label">
									HTML Upload</label>
								<div style="width: 50%; display: inline;">
									<input id="imageFilesHTML" name="<portlet:namespace />imageFilesHTML" type="file"
										onchange="performAjaxHTMLSubmitHTML()" />
								</div>

							</div>
						</div>

						<div style="padding-top: 10px; padding-bottom: 10px;">
							<label class="control-label" style="display: inline-block;">
								Images Upload  </label>
								<label class="control-label" style="font-size: 12px;display: inline-block;">   (**Please upload an image & use the url in the html code of the template)</label></br>
							<div style="width: 60%; display: inline;">
								<input id="imageFiles" name="<portlet:namespace />imageFiles" type="file"
									onchange="performAjaxSubmit()" />
							</div>
						</div>
						<div id="divImageFiles"></div>

						<div style="padding-top: 10px; padding-bottom: 10px;">
							<label class="control-label" style="display: inline-block;">
								Attachments Upload  </label><label class="control-label" style="font-size: 12px;display: inline-block;">   (**Please upload any file & use the url in the html code of the template as an attachment)</label>
							<div style="width: 60%;">
								<input style="padding:0px" id="attachmentFiles" name="<portlet:namespace />attachmentFiles" type="file"
									onchange="performAjaxSubmitPDF()" />
							</div>
						</div>
						<div id="divAttach"></div>

						<input onclick="saveData()" type="submit" value="Save"
							style="margin-right: 10px" class="btn-primary"/>
							<input type="button"
							onclick="resetNew()" value="Reset" class="btn-primary" style="margin-bottom:5px"/>
					</form>
				</div>
				<!-- end newTemplateDiv -->
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
		<div class="screen-max-width" style="padding: 0 20px 40px;">
		<div class="templateVariables" style="border:1px solid #ccc;padding: 10px;">
		##Note : List of Variables that can be used in the template.</br>
		[$TO_ADDRESS$] - To Email Address.</br>
		[$TO_FIRST_NAME$] - First name of the receiving user.</br>
		[$TO_LAST_NAME$] - Last name of the receiving user.</br>
		[$UNSUBSCRIBE_URL$] - URL Link for unsubscribe option.</br>
		[$WEBVERSION_LABEL$] - Label for webversion link.</br>
		[$WEBVERSION_URL$] - URL Link for webversion.</br>
		</div>
		</div>
		
		<script type="text/javascript">
		var AI = AUI();
AUI().ready('aui-node','aui-io-request',function(A) {
	AI = A;
	var detailTemplateId = document.getElementById("detailTemplateId").value;
	if (detailTemplateId=="") {

	}else {
		loadMailTemplateDetail(detailTemplateId);
	}

});

function saveData() {
	//var detailTemplateId = document.getElementById("detailTemplateId").value;
}
</script>
		<script type="text/javascript">
	function performAjaxSubmit() {
		var reqRenUrl = '<portlet:resourceURL id="" />'+'&cmd=imagesUpload';

	   // var sampleText = document.getElementById("sampleText").value;

		var sampleFile = document.getElementById("imageFiles").files[0];

		var formdata = new FormData();

		//formdata.append("sampleText", sampleText);

		formdata.append("sampleFile", sampleFile);

		var xhr = new XMLHttpRequest();

	   // xhr.open("POST","/fileUploadTester/FileUploader", true);

		if (window.XMLHttpRequest) {
			xhr.open("POST", reqRenUrl, true);
			//xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhr.onreadystatechange=function() {
	 			if (xhr.readyState==4 && xhr.status==200) {
	 					var data = xhr.responseText.split(":");

	 					if (imageEntryArray.length > 0) {
	 						imageEntryArray += ",";
	 					}
	 					imageEntryArray +=data[0].substring(2,data[0].length-1);
						document.getElementById("imageFileTotal").value=imageEntryArray;
	 					var imageURL = '<%= url %>'+data[1].substring(1,data[1].length-2);

	 					document.getElementById("divImageFiles").innerHTML += "<div id='"+data[0].substring(2,data[0].length-1)+"'><font style='padding-right:15px;font-weight:bold;'> image url :</font>" + imageURL + "<a onclick=deleteFile('"+data[0].substring(2,data[0].length-1)+"','imageFileTotal')> Delete</a><br /><img alt='Image' src='"+imageURL+"'' style='width:150px;height:100px;margin-top:10px;margin-bottom:10px;' />"+
	 					"</div><br />";
	 			}
	 		};
	 	}
		 xhr.send(formdata);

	}
</script>
		<script>
var count = 0;
var fileEntryArrays = "";
var imageEntryArray = "";
function performAjaxSubmitPDF() {
	var reqRenUrl = '<portlet:resourceURL id="" />'+'&pdfUpload=pdfUpload';

// var sampleText = document.getElementById("sampleText").value;

	var sampleFile = document.getElementById("attachmentFiles").files[0];
	var formdata = new FormData();

	//formdata.append("sampleText", sampleText);

	formdata.append("sampleFile", sampleFile);

	var xhr = new XMLHttpRequest();

// xhr.open("POST","/fileUploadTester/FileUploader", true);

	if (window.XMLHttpRequest) {
		xhr.open("POST", reqRenUrl, true);
		//xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function() {
			if (xhr.readyState==4 && xhr.status==200) {
					var data = xhr.responseText.split(":");
					if (fileEntryArrays.length > 0) {
						fileEntryArrays += ",";
					}
					fileEntryArrays += data[0].substring(2,data[0].length-1);
					document.getElementById("attachmentsFileTotal").value=fileEntryArrays;
					var imageURL = '<%= url %>'+data[1].substring(1,data[1].length-2);
					document.getElementById("divAttach").innerHTML += "<div id='"+data[0].substring(2,data[0].length-1)+"'><input type='hidden' value='"+imageURL+"' name='item"+count+"' id='item"+count+"'/><font style='padding-right:15px;font-weight:bold;'> Attachment url :</font>"  + "<br /><a href='"+
					imageURL+"' style='display:inline-block;padding-right:20px;' target='_blank'>"+ imageURL+"</a>"+
					"<a onclick='deleteFile("+data[0].substring(2,data[0].length-1)+",attachmentsFileTotal,)'> Delete</a></div>";

			}
		};
	}
	 xhr.send(formdata);
	 count++;

}

function <portlet:namespace />extractCodeFromEditor() {
	if (document.getElementById("optionFilter").checked) {
		document.getElementById("attachmentsTotal").value=count;
	    var x = window.<portlet:namespace />editor.getHTML();
	    document.getElementById("EditorContent").value=x;
	    document.<portlet:namespace />fm.EditorContent.value = x;
	}

}

function setContentFromEditor(content) {
	CKEDITOR.instances["_SPMailTemplateCreate_WAR_SPMailportlet_editor"].setData(content);
	//document.<portlet:namespace />fm.EditorContent.value = content;

}

</script>
		<script type="text/javascript">
function loadMailTemplateDetail(templateId) {
	//var AI=AUI();
	var itemis = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
	document.getElementById("newFlag").value="false";
	document.getElementById("updateTemplateId").value=templateId;

	var imageURL = '<%= previewIcon %>';

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
		       				//case "htmlContent":setContentFromEditor(cellTextValues[key]);break;
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
		       				case "images": var data1 = cellTextValues[key].split(",");
								var images = "";
								for (var i=0;i<data1.length;i++) {
									if (data1[i].length>0) {
										var fileEntryId1 = data1[i].split(":");
										imageEntryArray = "";

										if (imageEntryArray.indexOf(fileEntryId1[1])==-1) {
											imageEntryArray += fileEntryId1[1];
										}

					 					document.getElementById("imageFileTotal").value=imageEntryArray;
					 					images = "<div id='"+fileEntryId1[1]+"'>"  +
													"<a href='"+'<%= url %>'+fileEntryId1[0]+"' style='display:inline-block;padding-right:20px;' target='_blank'>"+'<%= url %>'+ fileEntryId1[0]+"</a>" +
													"<a onclick='deleteFile("+fileEntryId1[1]+")'> Delete</a></div>";
									}

								}
								document.getElementById("divImageFiles").innerHTML = images;
								break;
		       				case "htmlUpload":if (cellTextValues[key] == true) {
		       									document.getElementById("optionFilter").disabled = true;
		       									document.getElementById("optionUpload").checked=true;
		       									document.getElementById("htmlUpload").value="true";
		       									document.getElementById("addByFilter").style.display="none";
		       									document.getElementById("addByHtml").style.display="block";

		       									document.getElementById("previewIcon").innerHTML = "<a onclick='loadContent("+templateId+")'><img alt='Preview' src='"+imageURL + "'/></a>";
		       									document.getElementById("previewIcon").style.display="inline-block";
		       									document.getElementById("emailTemplateName").style.display="inline-block";

		       								}else {
		       									document.getElementById("optionFilter").checked=true;
		       									document.getElementById("addByFilter").style.display="block";
		       								}break;
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

function deleteFile(fileId,obj) {
	//var AI=AUI();
	var itemis = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
	var detailTemplateId = document.getElementById("detailTemplateId").value;
	
	try{
		AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterName:"deleteFile",
		   	 filterValue:fileId,
		   	detailTemplateId:detailTemplateId,
		    },

		    on: {
		        success: function() {
		        	document.getElementById(fileId).innerHTML = "";
		        	document.getElementById("imageFiles").value = "";
		        	document.getElementById("attachmentFiles").value = "";
		        	var fileString = document.getElementById("attachmentsFileTotal").value;
		        	document.getElementById("attachmentsFileTotal").value = fileString.replace(fileId," ");
		        }

		,

		failure: function() {
		}
		    }
		});

	return true;

	}catch(err) {
	}
}
function resetNew() {

	document.getElementById("newFlag").value="true";
	document.getElementById("templateTitle").value = "";
	document.getElementById("txtSubject").value = "";
	setContentFromEditor("");
	document.getElementById("divAttach").innerHTML = " ";
}

function addSubscriberChange(obj) {

	if (document.getElementById("optionUpload").checked) {
		document.getElementById("addByHtml").style.display="block";
		document.getElementById("addByFilter").style.display="none";
		document.getElementById("htmlUpload").value="true";
	}else {
		document.getElementById("addByHtml").style.display="none";
		document.getElementById("addByFilter").style.display="block";
		document.getElementById("htmlUpload").value="false";
	}

}

function performAjaxHTMLSubmitHTML() {
	var reqRenUrl = '<portlet:resourceURL id="" />'+'&filterName=imagesUploadHTML';

// var sampleText = document.getElementById("sampleText").value;

	var sampleFile = document.getElementById("imageFilesHTML").files[0];

	var formdata = new FormData();
	var imageURL = '<%= previewIcon %>';

	//formdata.append("sampleText", sampleText);

	formdata.append("sampleFile", sampleFile);

	var xhr = new XMLHttpRequest();

// xhr.open("POST","/fileUploadTester/FileUploader", true);

	if (window.XMLHttpRequest) {
		xhr.open("POST", reqRenUrl, true);
		//xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function() {
			if (xhr.readyState==4 && xhr.status==200) {
					var data = xhr.responseText;
					 document.getElementById("EditorContent").value=data;

						document.getElementById("previewIcon").innerHTML = "<a onclick='loadTemplate()'><img alt='Preview' src='"+imageURL + "'/></a>";
						document.getElementById("previewIcon").style.display="inline-block";
						document.getElementById("emailTemplateName").style.display="inline-block";

			}
		};
	}
	 xhr.send(formdata);

}

function loadTemplate() {
	document.getElementById("light").style.display='block';
	document.getElementById("fade").style.display='block'
	document.getElementById("campaignHTMLContent").innerHTML= document.getElementById("EditorContent").value;
}

</script>
		<script>
function loadContent(obj) {
	//var AI=AUI();
	var itemis = null;
	var subject = null;
	var htmlContent = null;
	var textContent = null;
	var campaignName = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
		/* document.getElementById("light").style.display='block';
		document.getElementById("fade").style.display='block' */

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
				       			for (key in cellTextValues) {
				       				switch(key) {
					       				case "subject": subject=cellTextValues[key];break;
					       				case "htmlContent": htmlContent=cellTextValues[key];break;
					       				case "textContent": textContent=cellTextValues[key];break;
				       				}
				       			}
				       		}
				       		/* document.getElementById("campaignSubject").innerHTML=subject;
				       		document.getElementById("campaignHTMLContent").innerHTML=htmlContent; */
				       		document.getElementById("light").style.display='none';
				    		document.getElementById("fade").style.display='none'
				       		var myWindow = window.open("", subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
				       		myWindow.document.write(htmlContent);
				       		document.getElementById("event-invite-pannel").style.display="none";

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

function closeTemplateScreen() {
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none';
	document.getElementById("campaignSubject").innerHTML=" ";
	document.getElementById("campaignHTMLContent").innerHTML=" ";
}
</script>
	</c:otherwise>
</c:choose>
