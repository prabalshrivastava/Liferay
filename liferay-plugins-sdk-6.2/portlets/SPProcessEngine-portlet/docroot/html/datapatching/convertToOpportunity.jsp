<%@ include file="/html/init.jsp" %>
<%@ include file="/html/msg.jsp" %>

<portlet:resourceURL var ="ajaxUrl">
	<portlet:param name="action" value="convertToOpportunity"/>
</portlet:resourceURL>
<liferay-portlet:resourceURL id="exportUrl" var="exportUrl">
   <portlet:param name="filePath" value="FILE_PATH"/>
   <portlet:param name="action" value="downloadFromTemp"/>
</liferay-portlet:resourceURL>



<div id="main">
  <textarea rows="50" cols="50" id="config">
  {
	"targetProcessId": "1",
	"processList": [{
		"processIds": "459021",
		"config": {
			"fieldMap": [{
				"srcField": "phone_number_3",
				"destField": "mobile_number_4",
				"type": "text"
			}, {

				"destField": "agree_to_terms_of_use_6",
				"type": "checkbox",
				"value": [{
					"value": "<html><body><p>Your registration will constitute your agreement to our <a href=\"https://www.lithan.com/terms-of-use\" target=\"_blank\">Terms of Use</a> and <a href=\"https://www.lithan.com/privacy-policy\" target=\"_blank\">Privacy Policy</a> </p></body></html>"
				}]

			}]
		}
	}]
}
  </textarea>
  <button type="button" onclick="convert()" id="convertButton">Convert</button>
</div>

<script>
var A;
var convertButton;
var config;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A1) {
	A = A1;
	convertButton = A.one("#convertButton");
	config = A.one("#config");
});
var ajaxUrl = "<%=ajaxUrl%>";

function convert(){
	convertButton.set("disabled",true);
	displayNormalMsg("Processing..");
	var data = {};
	data.config = config.val();
	
	A.io.request(ajaxUrl,{
        dataType: 'json',
        method: 'POST',
        data: data,
        sync: false,
        on: {
	        complete: function(){
	        	convertButton.set("disabled",false);
	        	displayNormalMsg("Processing Completed");	        	
	        },
	        success: function() {
	            var responseData=this.get('responseData');
	            handleResponse(responseData);
	          },
		    failure : function(){
		    	error = "Error while converting";
		    	alert(error);
		    }
        }
    });
}
var exportUrl = "<%= exportUrl%>";
function handleResponse(responseData){
	if(responseData){
		if(responseData.error){
			alert(responseData.error);
		}
		
		if(responseData.filePath){
			var url = exportUrl.replace("FILE_PATH", responseData.filePath);
			document.location.href = url;
		}else{
			alert("Could not export the results");
		}
	}else{
		alert("Error ");
	}
}
</script>

