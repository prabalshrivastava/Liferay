<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="createInventory">
	<portlet:param name="action" value="createInventory"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp"%>

<%
boolean hasInventory = Boolean.valueOf((String)renderRequest.getAttribute("hasInventory"));
String spProductId = request.getParameter("productId"); 
String sellItemId = request.getParameter("sellItemId"); 
%>

<div class="Product_Section screen-max-width">
<div class="Product_Sidebar">
	<%@ include file="/html/create/navigation.jsp"%>
	</div>

	<div class="Product_wrapper">
		<div class="Border" id="mainContainer">

			<!--HEADER-->
			<div class="Product_header">
				<div class="Prod-Headtitle">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.inventory")%></h2>
					<div class="Backtolist-btn">
						<a href="<%=listProduct%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
					</div>
				</div>
			</div>
		<!--HEADER END-->
		<!--CONTENTSECTION FRAMEWORK-->
		<form action="#" method="POST" id="inventoryFormId"
									name="inventoryForm">
		<div id="outline-section">
			<div class="Form-Prodsection Form-padding "></div>
			<div class="Product_contsection">
				<div id="Product_Outline" style="min-height:100px">
					<div style="margin-left:20px">
					<% if ((hasInventory) && Validator.isNotNull(hasInventory)){ %>
					   <input name="hasInventory" id="hasInventory" type="checkbox" checked onChange="javascript:showInventory()"/><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.hasInventory")%>
					<%}else {%>
						 <input name="hasInventory" id="hasInventory" type="checkbox" onChange="javascript:showInventory()"/><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.hasInventory")%>
					<%} %>
					</div>
		
					<% if ((hasInventory) && Validator.isNotNull(hasInventory)){ %>
					<div class="Outline_wrapper inventoryWrapper" id="inventoryWrapperId">
					<%}else {%>
					<div class="Outline_wrapper inventoryWrapper hide" id="inventoryWrapperId">
					<%} %>
					<div style="text-align:left"><input type="button" class="btn-primary" onClick="javascript:addInventory()" value="Add Inventory" style="margin:20px" id="addInventorybtn"></div>
					<input type="hidden" id="spProductId" name="spProductId" value="<%=spProductId%>">
					<input type="hidden" id="sellItemId" name="sellItemId" value="<%=sellItemId %>">
					<input type="hidden" id="globalCountId" name="globalCountId" value="0">
					
						
					</div>
					
				</div>

				</div>
			</div>
		</div>
		</form>
		<div class="Product_bottom">
			<a href="<%= listProduct %>"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%></a> <a href="javascript:;"
				onclick="saveInventory('inventoryFormId');"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%></a>
		</div>
	</div>
</div>

<div id="inventoryFields" class="hide">
								<div class="removeInstance"><input type="button" class="" value="X" onclick="removeInstance(this)" id="removeInstance" style="border:none;text-align: right;"></div>
							<input type="hidden" id="actualQuantity" name="actualQuantity">
							<input type="hidden" id="packageId" name="packageId">
							<div class="Input_HalfWidth">
							<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.inventoryValue")%><br/>
								<input type="text" value="${inventoryValue }" id="inventoryValue" name="inventoryValue">
								<div id="numbernValidationerror" class="validationMsg error hide"></div>
							</div>
							
							<div class="Input_HalfWidth">
							<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.existingInventoryValue")%><br/>
								<input type="text" value="${existingInventoryValue }" disabled id="existingInventoryValue">
							</div>	
							
							<div class="Calander_bar hide">
							
								<span id="inventoryStartDateContainer" class="Input_HalfWidth">
								<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.startDate")%>
									<div class="calander-section">
										<i class="Calander_icon"></i> <input class="calendarDate"
											type="text" name="startDate" id="startDate"
											placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.startDate")%>">
											<input class="calendarDate" type="hidden" name="startDateVal" id="startDateVal">
									</div>
								</span>
								<!-- <div class="separate-horizontal"></div> -->
								
								<span id="inventoryEndDateContainer" class="Input_HalfWidth">
								<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.endDate")%>
									<div class="calander-section">
										<i class="Calander_icon"></i> <input class="calendarDate"
											type="text" name="endDate" id="endDate" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.endDate")%>">
											<input class="calendarDate" type="hidden" name="endDateVal" id="endDateVal">
											<div id="dateValidationerror" class="validationMsg error hide">End Date cannot be before start date</div>
									</div>
								</span>
							</div>
						
						</div>

<script type="text/javascript">

var inventoryDetail = ${inventoryDetailListJSON};
var hasInventory = ${hasInventory};
showSubMenu("productSiderbar");

function addInventory(inventoryDetailVal, exstinventoryVal, startDate,endDate,packageIdVal){
	var instances = parseInt(document.getElementById("globalCountId").value);
	var totalInstances = instances;
	var basicInventoryElms = document.getElementById("inventoryFields").innerHTML;
	var inventoryElms = document.getElementById("inventoryWrapperId");
	
	var inventorySection = document.createElement("div");
	inventorySection.setAttribute("id","inventorySection"+totalInstances);
	inventorySection.setAttribute("class","inventorySection");
	inventorySection.setAttribute("style","border:1px solid #efefef;padding:20p");
	inventorySection.innerHTML = basicInventoryElms;
	
	inventoryElms.appendChild(inventorySection);
	
	 var inventoryValueIp = document.getElementById("inventoryValue");
	inventoryValueIp.setAttribute("id","inventoryValue"+totalInstances);
	inventoryValueIp.setAttribute("name","inventoryValue"+totalInstances); 
	inventoryValueIp.value = inventoryDetailVal?inventoryDetailVal:'';
	
	var packageId = document.getElementById("packageId");
	packageId.setAttribute("id","packageId"+totalInstances);
	packageId.setAttribute("name","packageId"+totalInstances); 
	packageId.value = packageIdVal?packageIdVal:'0';
	
	 var actualQuantity = document.getElementById("actualQuantity");
	 actualQuantity.setAttribute("id","actualQuantity"+totalInstances);
	 actualQuantity.setAttribute("name","actualQuantity"+totalInstances); 
	 actualQuantity.value = inventoryDetailVal?inventoryDetailVal:'';
	
	var existingInventoryValue = document.getElementById("existingInventoryValue");
	existingInventoryValue.setAttribute("id","existingInventoryValue"+totalInstances);
	existingInventoryValue.setAttribute("name","existingInventoryValue"+totalInstances);
	existingInventoryValue.value = exstinventoryVal?exstinventoryVal:'0';
	
	var startDateCont = document.getElementById("inventoryStartDateContainer");
	var invtId = "inventoryStartDateContainer"+totalInstances;
	startDateCont.setAttribute("id",invtId);
	var startDateIpVal = document.getElementById("startDateVal");
	var strDtId = "startDateVal"+totalInstances;
	startDateIpVal.setAttribute("id",strDtId);
	startDateIpVal.setAttribute("value",startDate?startDate:'');
	var startDateIp = document.getElementById("startDate");
	var sDtId = "startDate"+totalInstances;
	startDateIp.setAttribute("id", sDtId);
	startDateIp.setAttribute("name", sDtId);
	startDateIp.setAttribute("onClick","javascript:datePicker('"+invtId+ "'" + "," + "'"+sDtId+ "'" + "," + "'"+strDtId+ "')");
	startDateIp.setAttribute("placeholder",startDate);
	
	var endDateCont = document.getElementById("inventoryEndDateContainer");
	var einvtId = "inventoryEndDateContainer"+totalInstances;
	endDateCont.setAttribute("id",einvtId);
	var endDateIp = document.getElementById("endDate");
	var endDateIpVal = document.getElementById("endDateVal");
	var eDateId = "endDateVal"+totalInstances;
	endDateIpVal.setAttribute("id",eDateId);
	endDateIpVal.setAttribute("value",endDate?endDate:'');
	var eDtId = "endDate"+totalInstances;
	endDateIp.setAttribute("id",eDtId);
	endDateIp.setAttribute("name",eDtId);
	endDateIp.setAttribute("onClick","javascript:datePicker('"+einvtId+ "'" + "," + "'"+eDtId+ "'" + "," + "'"+eDateId+ "')");
	endDateIp.setAttribute("placeholder",endDate);
	
	var nValidIp = document.getElementById("numbernValidationerror");
	nValidIp.setAttribute("id","numbernValidationerror"+totalInstances);
	var nValidIp = document.getElementById("dateValidationerror");
	nValidIp.setAttribute("id","dateValidationerror"+totalInstances);
	
	var removeInstance = document.getElementById("removeInstance");
	removeInstance.setAttribute("id",totalInstances);
	document.getElementById("globalCountId").value = instances + 1;
	
	var addInventorybtn = document.getElementById("addInventorybtn");
	addInventorybtn.setAttribute("disabled","true");
	
}

function dateComparison(cnt){
	for(i=0;i<cnt;i++){
		var stDateIp = document.getElementById("startDateVal"+i);
		var enDateIp = document.getElementById("endDateVal"+i);
		var nValidIp = document.getElementById("dateValidationerror"+i);
		if(stDateIp && enDateIp){
			stDate = stDateIp.value;
			enDate = enDateIp.value;
			 var startDate = new Date(stDate);
			 var endDate = new Date(enDate);
			    if (startDate > endDate) {
			    	nValidIp.classList.remove("hide");
			    	return false;
			    }else{
			    	nValidIp.classList.add("hide");
			    	return true;
			    }
		}
	}	
}

function validateInventoryNumber(cnt){
	var exp = /^(\s*|\d+)$/;///^[0-9]*$/;
	var invElm;
	var invValid;
	var actualQuant;
	var validQuant;
	var remainingQuant;
	var packageId;
	for(var i=0;i<cnt;i++){
		invElm = document.getElementById("inventoryValue"+i);
		if(document.getElementById("actualQuantity"+i)){
			actualQuant = document.getElementById("actualQuantity"+i).value;
		}	
		invValid = document.getElementById("numbernValidationerror"+i);
		if(document.getElementById("existingInventoryValue"+i)){
			remainingQuant = document.getElementById("existingInventoryValue"+i).value;
		}	
		if(document.getElementById("packageId"+i)){
			packageId = document.getElementById("packageId"+i).value;
		}
		if(actualQuant > 0){
			validQuant = parseInt(actualQuant) - parseInt(remainingQuant);
		}else{
			validQuant = 0;
		}
		if(invElm){
			if(!exp.test(invElm.value)) {
				invValid.innerHTML = "Please enter only numbers";
				invValid.classList.remove("hide");
				return false;
			}else{	
				if(invElm.value > 0){
					if((invElm.value > validQuant)){
						invValid.classList.add("hide");
						return true;
					}else{
						invValid.innerHTML = "The Quantity entered is less than the already consumed quantity " + validQuant + ". Please give a value more than the consumed quantity.";
						invValid.classList.remove("hide");
						return false;
					}
				}else{
					invValid.innerHTML = "The quantity should be more than zero";
					invValid.classList.remove("hide");
					return false;
				}
			}
		}
	}
}

function removeInstance(obj){
	var inst = obj.getAttribute("id");
	var elmToRemove = document.getElementById("inventorySection"+inst);
	elmToRemove.remove();
	var addInventorybtn = document.getElementById("addInventorybtn");
	addInventorybtn.disabled = false;
}

function checkIfInventoryCanBeDeleted(cnt){
	var actualQuant;
	var remainingQuant;
		for(var i=0;i<=cnt;i++){
			if(document.getElementById("actualQuantity"+i)){
				actualQuant = document.getElementById("actualQuantity"+i).value;
			}	
			if(document.getElementById("existingInventoryValue"+i)){
				remainingQuant = document.getElementById("existingInventoryValue"+i);
			}	
			if(remainingQuant < actualQuant){
				alert("Inventory cannot be deleted, there are transactions for this product based on the inventory"); 
				return false;
			}else{
				return true;
			}
		}	
}

function saveInventory(fmId){ 
	var critInstancesCount =  parseInt(document.getElementById("globalCountId").value); 
	var spProductId = document.getElementById("spProductId").value;
	var enableChkBox = document.getElementById("hasInventory");
	var validity = false;
	var hasInventory = false;
	if(enableChkBox.checked == true) {
		hasInventory = true;
	}
	//var dateComp = dateComparison(critInstancesCount);
	var numValid = validateInventoryNumber(critInstancesCount);
	if(hasInventory == false){
		validity = checkIfInventoryCanBeDeleted(critInstancesCount);
		if(validity == true){
			//dateComp = true;
			numValid = true;
		}	
	}
	if(hasInventory == true){
		if (numValid == undefined) {
			alert("Please enter altleast 1 inventory (or) Unselect the 'Add Inventory' Option");
		}
	}
	if (numValid) {
	AUI().use('aui-io-request', function(A){
		startPreLoader("mainContainer");
		A.io.request('${createInventory}', 
				{ method: 'post', 
					form: { id: fmId }, 
					data:{
						critInstancesCount : critInstancesCount,
						spProductId : spProductId,
						hasInventory : hasInventory
					},
					on: {
					complete : function(){
						stopPreLoader("mainContainer");
					},
					success : function() {
						var data = this.get('responseData');
						if (data) {
							if(typeof data == "string"){
								// response is in string format
								data = JSON.parse(data);
							}
							for(j=0;j<=critInstancesCount;j++){
								var existingInventoryValue = document.getElementById("existingInventoryValue"+j);
								if(existingInventoryValue){
									existingInventoryValue.value = data.remainingInventory;
								}
							}
							if(data.error){
								displayError(data.error);
							}else if(data.saveFlag == 'success'){
								displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.inventory.updated")%>');
							}else{
								// This case is very very rare
								displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.inventory.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
							}
						} else {
							displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.inventory.save.error")%>');
						}
						window.scrollTo(0,0);
					},
					failure : function() {
						displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.inventory.save.error")%>');
						window.scrollTo(0,0);
					}
				} 
			}); 
		}); 
	}
}

function showInventory(){
	var inventoryWrapper = document.getElementById("inventoryWrapperId");
	
	var enableChkBox = document.getElementById("hasInventory");
	if(enableChkBox.checked == true) {
		inventoryWrapper.classList.remove("hide");
	}else{
		inventoryWrapper.classList.add("hide");
		document.getElementById("globalCountId").value = 0;
	}
}

function datePicker(containerId,triggerId,ipId){
	AUI().use('aui-node','aui-base','aui-io-request', 'aui-datepicker', function(A){
	var datePicker = new A.DatePicker(
			{
				container: '#' + containerId,
				mask: '%m/%d/%Y',
				popover: {
					zIndex: Liferay.zIndex.TOOLTIP
				},
				trigger: '#' + triggerId,
				calendar: {
				       // minimumDate: new Date(2011,00,01),
				       // maximumDate: new Date(2012,08,05),
				selectedDates:new Date(2012,08,05),
				    },
				on: {
			          selectionChange: function(event) {
			            console.log(event.newSelection)
			            document.getElementById(triggerId).value = event.newSelection;
			            document.getElementById(ipId).value = event.newSelection;
			          }
			        }
			}
		);
		//var calendar = datePicker.getCalendar();
		//alert(document.getElementById(triggerId).value);
		//calendar.after('dateClick', instance.dateSelectionChange, datePicker);
		//instance[triggerId+"Dp"] = datePicker;
	});
	
	}
	
	function initializeInvetoryFields(){
		console.log("inventoryDetailListJSON " + inventoryDetail);
		
		if (inventoryDetail) {
			if(hasInventory == true){
			 for (key in inventoryDetail) {
	             var inventoryDetailVal = inventoryDetail[key].quantity;
	             var exstinventoryVal = inventoryDetail[key].remainingInventory;
	             var startDate = inventoryDetail[key].startDate;
	             var endDate = inventoryDetail[key].endDate;
	             var packageId = inventoryDetail[key].packageId;
	             addInventory(inventoryDetailVal, exstinventoryVal, startDate,endDate,packageId);
	         }
			}
	    }
		else{
			addInventory('', '','','','');
	    }
	}

	AUI().ready(function(A) {

		initializeInvetoryFields();
	});
</script>
