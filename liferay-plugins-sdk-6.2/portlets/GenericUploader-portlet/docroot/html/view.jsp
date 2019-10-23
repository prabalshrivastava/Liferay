<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ include file="init.jsp"%>

<% 
	String linkConfigTxt = SambaashUtil.getParameter("genericUpload.config.downloadLinks", themeDisplay.getScopeGroupId());
	boolean hasLinks = true;
	if (StringUtils.isEmpty(linkConfigTxt)) {
		linkConfigTxt = "[]";
		hasLinks = false;
	}
%>

<portlet:resourceURL var="downloadSampleTemplate">
	<portlet:param name="action" value="downloadFile" />
	<portlet:param name="file" value="sampleTemplate" />
</portlet:resourceURL>

<portlet:resourceURL var="upload">
	<portlet:param name="action" value="upload" />
</portlet:resourceURL>

<portlet:resourceURL var="uploadLog">
	<portlet:param name="action" value="getUploadLog" />
</portlet:resourceURL>
<style>
.paddingGup
{
	padding: 40px;
}
.downGU
{
	margin-bottom: 20px;
}
form.gu_UploadForm
{
	padding: 0 20px;
	display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;

}
form.gu_UploadForm p
{
font-size: 11pt;
font-weight: 600;
margin: auto;
text-align: center;
line-height: 1;
}

.aui form.gu_UploadForm input[type="file"]
{
	line-height: normal;
}

p#templateLinks {
    text-align: center;
}

</style>
<div class="max-width paddingGup">
<div class="downGU hide"><!-- Hiding based on feedback from testing team -->
	<a href="<%=downloadSampleTemplate%>" class="normal-cta">Download Sample Template</a>
</div>

<%@ include file="results.jsp" %>

</div>

<div class="container enrolment-enrolment-center-align">
    <div class="uc-box enrolment-center-align">
        <div class="row-fluid ">
            <div class="span12 text-center">
                <img src="/GenericUpload-portlet/img/background-batch-upload.png" id="yui_patched_v3_11_0_1_1563786406493_477">
            </div>
        </div>
        <div class="uc-box-bottom">
			<form name="uploadForm" class="gu_UploadForm" action="<%=upload%>" id="uploadForm"
				enctype="multipart/form-data">
				<div class="text-center ">
					 <div class="control-group customMargin">
                        <label class="control-label" for="uploadgeneric"> Upload the file and click submit </label>
                    </div>
					<span class="btn-file disable-css" id="file-upload-id">UPLOAD
                        <div class="control-group">
                            <input class="field"  name="file" id="file" type="file" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
                        </div>
                    </span> 

                     <button class="btn-submit" type="button" value="Upload !!" onclick="upload()" id="uploadButton">SUBMIT</button>
				     <br>
                     <br>
	                   <p id="templateLinks">
					   </p>
					
			    </div>
			</form>
	    </div>
		

	</div>
</div>



<script>
var A = null;
var uploadUrl = "<%=upload%>";
var uploadLogUrl = "<%=uploadLog%>";
var linkConfig = <%=linkConfigTxt%>;
	AUI().use('aui-node', 'aui-io-request', 'aui-io-plugin-deprecated',
			function(A1) {
				A = A1;
				//keepGettingLog();
				console.log(linkConfig);
				var currPageUri = window.location.pathname;
				var downloadLinksHtml = "";
				linkConfig.forEach(function(pageUriConfig) {
					if (pageUriConfig.pageUri == currPageUri) {
						pageUriConfig.downloadLinks.forEach(function(linkConfig) {
							downloadLinksHtml += "<br><a href='"+ linkConfig.url +"'>"+ linkConfig.label +"</a>";							
						});
						AUI().one("#templateLinks")._node.innerHTML = downloadLinksHtml;
					}
				});
			});
</script>