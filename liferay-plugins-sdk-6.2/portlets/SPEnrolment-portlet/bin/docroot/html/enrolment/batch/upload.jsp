<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>
<portlet:defineObjects />
<portlet:renderURL var="homePage">
    <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>
<portlet:actionURL var="batchUploadURL" name="uploadFiles">
</portlet:actionURL>
<%
	String dashBoardLink = SambaashUtil.getDashBoard();
%>
<div class="newPortlets enrolment-body enrolment-center-align">
    <!-- header -->

    <div class="subHeader">
        <div class="container">
        	<div class="inner-container">
	            <aui:row>
	                <aui:col span="10" cssClass="text-center header-title">
	                    <h2><span>UPLOAD CANDIDATES</span></h2>
	                </aui:col>
	                <aui:col span="2" cssClass="text-right header-home-link">
	                    <a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
	                </aui:col>
	            </aui:row>
	         </div>
        </div>
    </div>
    <div class="container mt-100 ">
        <div class="uc-box enrolment-center-align">
            <aui:row>
                <aui:col span="12" cssClass="text-center">
                    <img src="<%=request.getContextPath()%>/img/background-batch-upload.png">
                </aui:col>
            </aui:row>
            <div class="uc-box-bottom">
                <sp-formio:FormIO  cssClass="formContainer" formId="1905" readOnly="false" formStorageId="0" />
                <aui:form action="<%=batchUploadURL %>" enctype="multipart/form-data" method="POST" id="fm" name="fm">
                    <div class="text-center">
                      
                        <br>
                        <aui:input type="hidden" name="formType" id="component" value="enrolment" label="Component"  />
                        <aui:input type="hidden" name="semester" id="semester" value="semester"  />
                        <aui:input type="hidden" name="formId" id="formId" value="1832"  />
                        <span class="btn-file">
    						UPLOAD <input type="file" name="myFile"  id="myFile" >
						</span>
						<br>
                        <br><a href="<%=request.getContextPath()%>/assets/sample.csv" target="_blank">[ Download sample CSV template]</a>
                    </div>
                </aui:form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var mode = "view";
    var formInstance;
    function afterFormLoadedFormIOForm(thisInstance) {
        formInstance = thisInstance;
    }
     document.getElementById("myFile").onchange = function () {
    	 if(!Validate(this)){
    		 form1.displayMessage("error","Invalid File");
    	 }
    	 else if(form1.components.semesterSchedule.value != "" && form1.components.semesterSchedule.value.length > 3){
    		document.getElementById(namespace+"semester").value = form1.components.semesterSchedule.value;
    	    this.form.submit();
    	 }
    	 else{
    		 document.getElementById("myFile").value = "";
    		 form1.displayMessage("error","Please Select Semester First");
    	 }
    	
    }; 
    
    var _validFileExtensions = [".csv"];    
    function Validate(oForm) {
        
            var oInput = oForm;
            if (oInput.type == "file") {
                var sFileName = oInput.value;
                if (sFileName.length > 0) {
                    var blnValid = false;
                    for (var j = 0; j < _validFileExtensions.length; j++) {
                        var sCurExtension = _validFileExtensions[j];
                        if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                            blnValid = true;
                            break;
                        }
                    }
                    
                    if (!blnValid) {
                        
                        return false;
                    }
                }
            }
        
      
        return true;
    }
</script>