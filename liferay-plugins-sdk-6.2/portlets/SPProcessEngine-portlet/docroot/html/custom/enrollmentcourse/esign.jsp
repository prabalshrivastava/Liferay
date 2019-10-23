<%@page import="com.sambaash.platform.pe.handlers.PEPaymentHandler"%>
<%@page import="com.sambaash.platform.pe.handlers.PEPreviewHandler"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEPreviewList"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEPreview"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEJSP"%>
<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollEsignEngine"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil" %>
<%@ page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter" %>
<%@ page import="com.sambaash.platform.pe.handlers.*" %>

<%@ include file="/html/init.jsp" %>

<%
   //PEDataSource dataSource = (PEDataSource)request.getAttribute(PEConstants.ATTR_DATA_SOURCE);
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
PEDataSource dataSource = output.getDataSource();
PEPreviewList pePreviewList = dataSource.getDirectory().getProcessDefinition().getPreviews();
PEProcessStateDataAdapter processStateDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
PEJSP jspNode = (PEJSP) dataSource.getDirectory().getNode(output.getNodeId());
CourseEnrollEsignEngine esignEngine = CourseEnrollEsignEngine.getInstance(output.getDataSource(),jspNode);
boolean isContractReleased = Boolean.valueOf(processStateDataAdapter.getDataFromProcessState("isContractReleased", true));

List<PEPreview> pePreviewNodes = pePreviewList.getList();  
String mergedContractUrl = StringPool.BLANK;
String enablePreview = "false";
String enableEsign = "false";
for (PEPreview pePreview : pePreviewNodes) {
	//if (pePreview.getPreviewJspNode().equalsIgnoreCase(String.valueOf(output.getNodeId()))){
		enablePreview = pePreview.getEnablePreview();
		enableEsign = pePreview.getEnableEsign();
		if (Boolean.valueOf(pePreview.getEnablePreview())){
				mergedContractUrl = PEPreviewHandler.mergeDoc(dataSource, processStateDataAdapter, pePreview);
				break;
		}
// 	}
}

try{
   if(esignEngine.isSigningCompleted()){
	//TODO:   
	 String filePath = esignEngine.downloadSignedDocuments();
     if(Validator.isNotNull(filePath)){
    	 
%>	   
<!--  BLOCK START FOR SIGNIN COMPLETED -->    
     <liferay-portlet:resourceURL var="download" >
        <liferay-portlet:param name="action" value="<%=PEConstants.ACTION_DOWNLOAD_FROM_TEMP %>"/>
        <liferay-portlet:param name="filePath" value="<%=filePath %>"/>
	 </liferay-portlet:resourceURL>
 
 	  Please click <a href="<%=download%>">here</a> to download the signed contract
<!--  in this case just display the contract in downloadable format -->

<!--  BLOCK END FOR SIGNIN COMPLETED -->
<%
     }else{
    	 out.write("Error while downloading the contract ");
     }
   }else if(output.isCanSubmit()) {
	   if (dataSource.isApplicantLoggedInUser()){
		   String url = esignEngine.getSignInUrl();
	   
		   
%>

	<!--  BLOCK START FOR SIGNIN IN PROGRESS. CONTRACT WILL BE DISPLAYED FOR SIGNING -->
	<script>
	   startPreLoader('mainContainer')
	</script>
      <iframe src="<%= url%>" width='100%' onload="stopPreLoader('mainContainer')" height="850px">
      
      </iframe>
      
    <!--  BLOCK END FOR SIGNIN IN PROGRESS -->  
<%		   

	    }  else{ 
		
			if (Boolean.valueOf(enablePreview)){		
%>

	<script>
	   startPreLoader('mainContainer')
	</script>
      <iframe src="<%= mergedContractUrl%>" width='100%' onload="stopPreLoader('mainContainer')" height="850px">
      
      </iframe>
	

	
	<% 
			}
			if (Boolean.valueOf(enableEsign)){
	%>
				<div class="btn-div">
	            <aui:button id="submit" name="submit"  value="release.contract.button.text" onClick="submitJSP()"></aui:button>
	         </div>
	 <% 
			}
		
					   
	   }
   } else{
	   if (!dataSource.isApplicantLoggedInUser()){
	   	if (Boolean.valueOf(enablePreview)){
	%>
		<script>
	  		 startPreLoader('mainContainer')
		</script>
      	<iframe src="<%= mergedContractUrl%>" width='100%' onload="stopPreLoader('mainContainer')" height="850px">
      
      	</iframe>
	
	<% 	   
	   }
	   //out.write(jspNode.getWaitMsg());
   	}
   }
}catch(Exception ex){
	_log.error(ex.getMessage());		   
%>			        
	<div>Error while processing the request. Please contact support</div>
	<!--  BLOCK START FOR EXCEPTION HANDLING -->

	<!--  BLOCK END EXCEPTION HANDLING -->

<%	   }
   
%>

<script>


window.addEventListener('message', receiveMessage, false);


function receiveMessage(event) {
    var origin = event.origin || event.originalEvent.origin;
    var data = event.data;

      switch (data) {
       case 'ESL:MESSAGE:REGISTER':       
        	event.source.postMessage('ESL:MESSAGE:ACTIVATE_EVENTS', origin);
        	break; 
       default:
         event.source.postMessage(data, origin);
         break;
    } 
      
     if (data === "ESL:MESSAGE:SUCCESS:SIGNER_COMPLETE"){
    		 submitJSP();
     }
  }
</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.custom.enrollmentcourse.esign_jsp");
%>
