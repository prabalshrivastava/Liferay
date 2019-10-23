<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEJSP"%>
<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollRegisterInterestJSPHelper"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessAudit"%>
<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollEsignEngine"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.spservices.model.SPParameter" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>


<%@ include file="/html/init.jsp" %>

<%
   //PEDataSource dataSource = (PEDataSource)request.getAttribute(PEConstants.ATTR_DATA_SOURCE);
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
PEDataSource dataSource = output.getDataSource();
CourseEnrollRegisterInterestJSPHelper helper = CourseEnrollRegisterInterestJSPHelper.getInstance(dataSource,  
													(PEJSP) dataSource.getDirectory().getNode(output.getNodeId()));
String data = helper.getData().trim();
String productList = helper.loadProducts();
String hideIt = output.isCanEdit() ? "":"hide";
String param = SambaashUtil.getParameter(PEConstants.PERSONA_VOCABULARY_ID, 0);
List<AssetCategory> personaList = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, GetterUtil.getLong(param), -1, -1, null);
%>
<script>
  var savedData = <%=Validator.isNull(data)?"{}" : data%>;
</script>
<style type="text/css">
#myProgress {
  width: 100%;
  background-color: #4CAF50;
  padding: 2px 2px;
  color: #fff;
  font-size: 8pt;
  margin-top: 5px;
}

#myBar {
  width: 0%;
  height: 20px;
  background-color: #4CAF50;
  text-align: center;
  line-height: 15px;
 padding: 2px 2px;
  color: #fff;

}
</style>



<div id="registerInterestDiv" class="wrapperInput">
	<div class="has-float-label">
		<input type="text" id="firstName" placeholder="firstName" maxlength="75" class="Requiredfield" onchange="validate(this)"/>
		 <label for="fistname">First Name</label>
		<p id="firstNameErrorDiv" class="hide"></p>
  	</div>
    <div class="has-float-label">
    	<input type="text" class="Requiredfield" placeholder="lastName"  maxlength="75" id="lastName" onchange="validate(this)"/>
	<label for="lastname">Last Name</label>
    	<p id="lastNameErrorDiv" class="hide"></p>
  	</div>
  	<input type="text" class="hide" id="emailAddressVerification"/>
  	<div class="has-float-label">
  		<input type="text" class="Requiredfield" maxlength="75" placeholder="emailAddress"  id="emailAddress" onchange="validate(this);emailChange();"/>
		<label for="emailaddress">Email Address</label>
		<div id="emailAddressErrorDiv" class="hide"></div>
  	</div>
  	<div  class="has-float-label">
  		<input type="text" class="Requiredfield" placeholder="mobileNumber"  maxlength="20" id="mobileNumber" onchange="validate(this)"/>
		<label for="mobilenumber">Mobile Number</label>
		<p id="mobileNumberErrorDiv" class="hide"></p>
  	</div>
  	<label style="font-size: 9pt !important;padding: 0;" for="productName">Product</label>
	<div class="has-float-label margin-top-20">
	
		<input id="productId" type="hidden">
		<div id="SelectedProduct"
			class="SelectedProduct selectedList"></div>
	</div>
	<div class="has-float-label"> 
		<input name="productToBeSaved" id="productName"
			type="hidden" class="Requiredfield autoComplete"
			placeholder="Add a product"> 
		<input
			name="productList"
			class="productList selectedListInput"
			id="productListId" placeholder="Add a product">
		<div class="Icon-Search"><img src="/SPProcessEngine-portlet/images/ios-search-ion-icons.png" alt="Search"></div>
		<p id="productNameErrorDiv" class="hide"></p>
	</div>
	<label style="font-size: 9pt !important;padding: 0;" for="chooseFile">Recent Curriculum Vitae</label>
	<div class="has-float-label marginBottom10 marginTop20 <%=hideIt %>">
		<input type="hidden" id="CVFileEntryId">
		<input type="file" id="CV" class="hide">
		<button type="button" id="chooseFile" class="btn btn-default choose-btn">Choose File</button>
		<div id="CVSelected" class="download_label"></div>  
	<!-- <div id="myProgress">
             <div id="myBar">10%</div>
	</div> -->
	
	</div>
	<div id="CVInfo" class="hide  dowload_image"> <span id="CVTitle"></span> <a id="CVDownloadUrl" href="" target="_blank">Download</a> </div>
	<label for="persona" style="font-size: 9pt !important;padding: 0;">Persona</label>
	<div class="Filterdiv Span-width-25" style="width: 40%;">
		<select id="persona" onchange="loadSubPersona()" class="Requiredfield">
			<%
				for (AssetCategory persona : personaList){
					if(Validator.isNotNull(persona))
			%>
				 <option value="<%= persona.getCategoryId() %>"><%= persona.getName() %></option>
			<% 	  
				}
			%>
		</select>
		<p id="personaErrorDiv" class="hide"></p>
	</div>
	<br>
	<label for="subPersona" style="font-size: 9pt !important;padding: 0;">Sub Persona</label>
	<div class="Filterdiv Span-width-25" style="width: 40%;" class="Requiredfield">
		<select id="subPersona">
		</select>
		<p id="subPersonaErrorDiv" class="hide"></p>
	</div>
<div class="has-float-label marginTop30">
   <c:if test="<%= output.isCanEdit() %>">
   
   		<button type="button" class="btn btn-default material-btn" onclick="saveRegisterInterestData()" id="save">Save</button>
   </c:if>
   <c:if test="<%= output.isCanSubmit()%>">
   		<button type="button" class="btn btn-default material-btn"  onclick="submitRegisterInterestData()" id="convertOpportunity">Convert to Opportunity</button>
   </c:if>
   </div>
   </div>


<portlet:resourceURL var ="ajaxUrl">
	<portlet:param name="action" value="CourseEnrollmentProcess"/>
	<portlet:param name="resourceId" value="tes11"/>
</portlet:resourceURL>

<portlet:resourceURL var ="ajaxUrlFileUpload">
	<portlet:param name="action" value="uploadFileToTemp"/>
</portlet:resourceURL>

<portlet:resourceURL var ="ajaxUrlSubPersona">
</portlet:resourceURL>

<script src="/SPProcessEngine-portlet/js/typeAheadSearch.js?t=3"></script>
<script>
	
	initializeFuncs.push(initRegInterest);
	
	var productListJSON = <%= productList%>;
	
	
	var disabled = <%= !output.isCanEdit() && !output.isCanSubmit() %>;
	var ajaxUrlFileUpload = "<%= ajaxUrlFileUpload %>";
	var ajaxUrlSubPersona = "<%= ajaxUrlSubPersona %>";
    var saveUrl = "<%=ajaxUrl%>";
    var emailChangeFlag = false;
    var uploader = new fileUpload();
    var errorCode = null;
    var canEdit = <%= output.isCanEdit() %>;
    
    
    
    function loadSubPersona(){
    	AUI().use('aui-io-request', function(A){
    	var data = {};
		data.action = "getSubPersona";
		data.selectedPersona = document.getElementById("persona").value;
		
		A.io.request(ajaxUrlSubPersona,{
			dataType: 'json',
			method: 'POST',
			data: data,
			sync: true,
			on: {
			success: function() {
				var data=this.get('responseData');
				if (data) {
					if (data.error) {
						alert(data.error);
					}else {
						var subPersonas = data.subPersona;
						var out = "";
						for (var innerCntIndex = 0 ; innerCntIndex < subPersonas.length; innerCntIndex++ ) {
							out += "<option value=" + subPersonas[innerCntIndex].id + ">" + subPersonas[innerCntIndex].name + "</option>";
						}
						document.getElementById("subPersona").innerHTML = out;
					}
				}else {
					alert("Error while fetching Sub Persona");
				}
			  },
		    failure : function() {
		    	alert("Error while fetching Sub Persona");
		    }
			}
		});
    	});
	
	}
	
    
	function initRegInterest(){
		var mainDivNode = A.one("#registerInterestDiv");
		mainDivNode.all("input[type=text],input[type=hidden],select").each(function(node){
		 	node.set("disabled",disabled);
	 		node.val(savedData[node.get('id')]);
		 });
		
		initializeProductSearch();
		loadSubPersona();
		
		A.one("#emailAddressVerification").val(emailChangeFlag);
		A.one("#SelectedProduct").set("text",savedData.productName);
		A.one("#productId").val(savedData.productId);
		
		
		if (savedData.persona){
			A.one("#persona").val(savedData.persona);
		}else{
			document.getElementById("persona").selectedIndex = -1;
		}
		
		
		if (savedData.subPersona){
			A.one("#subPersona").val(savedData.subPersona);
		}else{
			document.getElementById("subPersona").selectedIndex = -1;
		}
		
		// Download link
		if(savedData["CVDownloadUrl"]){
			initializeDownloadUrls(savedData);
		}
	 	
		if(canEdit){
			var cvDom = document.getElementById("CV");
			var cv = A.one("#CV");
			cv.on("change",function(){
				A.one("#CVSelected").set("text",cv.val());
			});
			
			A.one("#chooseFile").on("click",function(){
				cvDom.click();
			});
			
		 	uploader.init(ajaxUrlFileUpload,pns,'CV','CVFileEntryId');
		}else{
			A.one("#productListId").set("disabled",true);
		}
	}
	function getRegisterInterestData(){
		var mainDiv = A.one("#registerInterestDiv");
		var data = {};
		mainDiv.all("input,select,textarea").each(function(node){
			data[node.get('id')] = node.val();
		});
		return data;
	}
	
	
	function saveRegisterInterestData(){
		if (emailChangeFlag){
			saveData();
		}else {
			if (errorCode != "Undeliverable"){
				saveData();
		}
			
		}
	}
	
	function saveData(){
		var mainDiv = A.one("#registerInterestDiv");
		var convertOpportunitybutton = A.one("#convertOpportunity");
		var validationResult = validateReqFieldOnSave(mainDiv);
		if (!validationResult){
			A.one("#save").set("disabled",true);
			if(convertOpportunitybutton && convertOpportunitybutton!= null){
				A.one("#convertOpportunity").set("disabled",true);	
			}
			clearMsgContainer();
			var task = 'saveRegisterInterestData';
			
			if(uploader.isInProgress()){
				displayNormalMsg("Upload is in progress...");
				//TODO: Temporary
				var intervalId = window.setInterval(function(){
					if(!uploader.isInProgress()){
						window.clearInterval(intervalId);
						displayNormalMsg("Saving the data...");
						var data = getRegisterInterestData();
						saveFormJspViaAjax(saveUrl,data,task,handlerSaveResponse);
					}
				},2000);	
			}else{
					var data = getRegisterInterestData();
					saveFormJspViaAjax(saveUrl,data,task,handlerSaveResponse);
			}
		}
	}
	
	function handlerSaveResponse(response){
		A.one("#save").set("disabled",false);
		var convertOpportunitybutton = A.one("#convertOpportunity");
		if(convertOpportunitybutton && convertOpportunitybutton!= null){
			A.one("#convertOpportunity").set("disabled",false);	
		}
		if(response){
			emailChangeFlag = false;
			A.one("#emailAddressVerification").val(emailChangeFlag);
			if(response.error){
				displayError(response.error);
			}
			if(response.errors){
				displayErrors(response.errors);
				var result = response.errors[0].split(" ");
				errorCode = result[0];
			}
			if(response.successMsg && response.successMsg.length > 0){
				displaySuccess("Your request successfully processed");
			}
		}else{
			displayError("Error while processing your request");
		}	
	}
	var convertOpportunityButtonSync = false;
	function submitRegisterInterestData(){
		A.one("#convertOpportunity").set("disabled",true);
		A.one("#save").set("disabled",true);
		if(!convertOpportunityButtonSync){
			convertOpportunityButtonSync = true;
		}else{
			return ;
		}
		var mainDiv = A.one("#registerInterestDiv");
		var validationResult = validateOnClickSave(mainDiv);
		if (!validationResult){
			var data = getRegisterInterestData();
			submitJSP(data);
		}else{
			convertOpportunityButtonSync = false;
			A.one("#save").set("disabled",false);
			A.one("#convertOpportunity").set("disabled",false);
		}
	}
	
	
	function emailChange() {
		emailChangeFlag = true;
		A.one("#emailAddressVerification").val(emailChangeFlag);
	}
	
	function validateReqFieldOnSave(contextNode){
		var nodes = contextNode.all("input[type=text],input[type=hidden],select");
		var result = false;
		nodes.each(function(node){
		var cn = node.getAttribute("class");
		var id = node.get("id");
			if (id != "productName" && id != "mobileNumber"){
			if(cn.includes("Requiredfield")){
				var temp = validateRequiredField(node);
				if (temp){
					result = true;
				}
			}
			}
		})
		return result;
	}

	function initializeProductSearch() {
		var className = ".productList";
		var sourceJSON = productListJSON;
		var valueToBeSaved = "productName";
		var idToBeSaved = "productId";
		var displayDiv = "SelectedProduct";
		var inputNodeId = "productListId";
		var placeHolder = "Add a product";
		var obj = new typeAheadSearch({
			className : className,
			sourceJSON : sourceJSON,
			valueToBeSaved : valueToBeSaved,
			idToBeSaved : idToBeSaved,
			displayDiv : displayDiv,
			inputNodeId : inputNodeId,
			placeHolder : placeHolder
		});
	}
</script>



		
