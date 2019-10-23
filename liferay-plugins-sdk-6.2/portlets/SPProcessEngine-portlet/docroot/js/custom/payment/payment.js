/**
 * 
 */

var Payment = function(config){
	var A;
	var instance;
	this.init = function(config){
	   A = config.A;
	   //this.feeDetails = config.feeDetails;
	   this.defaultFeeRowsData = config.defaultFeeRows;
	   this.defaultInstmntRowsData = config.defaultInstmntRows;
	   
	   this.disabled = config.disabled;
	   this.insmntsExist = config.insmntsExist;
	   this.ajaxUrl = config.ajaxUrl;
	   instance = this;
	   this.feeRowContainer  = A.one("#feeRowContainer");
	   this.feeRowTemplate = A.one("#feeRowTemplate");
	   
	  var addFeeButoon =  A.one("#addFee");
	  if(addFeeButoon != null){
		  addFeeButoon.on("click",function(){
			  instance.addFeeRow();
		  });
		  
	  }
	   // submit button
	   var submitButton = A.one("#" + pns + "submit");
	   if(submitButton){
		   submitButton.on("click",function(){
			   instance.submitData();
		   });
	   }
	   // submit button
	   instance.saveButton = A.one("#" + pns + "save");
	   if(instance.saveButton){
		   instance.saveButton.on("click",function(){
			   instance.saveData();
		   });
	   }
	   // declared in jsp
	  // instance.addFeeRow(FEE_TYPE_COURSE_FEE,true);
	   //instance.addFeeRow(FEE_TYPE_WDA_GRANT,true);
	   
	   instance.addFeeRows();
	   
	   if(instance.insmntsExist){
		   /** Installements */
		   
		   this.noOfInsmnts = A.one("#noOfInsmnts");
		   this.instmntsContainer = A.one("#instmntRowContainer");
		   
		   this.noOfInsmnts.on("change",function(){
			   //	var count = this.val();
			   var total = instance.getTotalFee();
			   if(total == null){
				   alert("Please add Fee Type Total");
				   return;
			   }
			   instance.addInstmntRows();
		   });
		   if(instance.defaultInstmntRowsData && instance.defaultInstmntRowsData.length > 1){

			   instance.noOfInsmnts.val(instance.defaultInstmntRowsData.length);
		   }
		   this.addInstmntRows(instance.defaultInstmntRowsData);
	   }
	   
	   if(this.disabled){
		   A.all("input,select").each(function(node){node.set("disabled",instance.disabled);});
		   A.all("#remove").each(function(node){instance.hide(node);})
	   }
	};

	this.addFeeRows = function(){
		var defaultRows = instance.defaultFeeRowsData;
		if(defaultRows){
			A.Array.each(defaultRows,function(feeData){
				instance.addFeeRow(feeData);
			});
		}
	}
	this.getTotalFee = function(){
		var total = null;
		instance.getAllFeeRows().each(function(feeRow){
		     var feetypeNode = instance.getFeeType(feeRow);
		     if(feetypeNode.val() == TOTAL_FEE_PAYABLE_TO_LITHAN){
		    	 total = instance.getAmountNode(feeRow).val(); 
			}
		});
		return total;
	}
	this.isTotalAmountAddedAtLastRow = function(){
		var allRows = instance.getAllFeeRows();
		var last = allRows.item(allRows.size()-1);
		 var feetypeNode = instance.getFeeType(last);
	     if(feetypeNode.val() == TOTAL_FEE_PAYABLE_TO_LITHAN){
	    	 return true;
	     }else{
	    	 return false;
	     }
	}
	
	// feeData is not null, then fill the fee row fields with data.
	this.addFeeRow = function(feeData){
		// calculate next label. Ascii of last row label plus one
		var allLabels = instance.feeRowContainer.all("#feeLabel");
		var lastFeeRowLabelNode =  allLabels.item(allLabels.size()-1);
		if(instance.count){
			instance.count = instance.count + 1;
		}else{
			instance.count =  1;
		}
		
		var newRow = instance.feeRowTemplate.cloneNode(true);
		newRow.set("id","feeRow" + instance.count);
		instance.feeRowContainer.appendChild(newRow);

		var orderNode = instance.getFeeOrder(newRow);
		orderNode.val(instance.count);
		var feeLabel = instance.getFeeLabel(newRow);
		if(lastFeeRowLabelNode){
			var newLabel = String.fromCharCode((lastFeeRowLabelNode.val().charCodeAt(0)) + 1);
			feeLabel.val(newLabel);
		}
		
		var feeTypeNode = instance.getFeeType(newRow);
		feeTypeNode.on("change",function(){
			var feeRow = instance.getFeeRow(this);
			//instance.setDefaultFormulaAmount(this.val(), feeRow);
			instance.calculateAmount();
		});
		var amountNode = instance.getAmountNode(newRow);
		amountNode.on("change",function(){
			instance.calculateAmount();
		});

		var formulaNode = instance.getFormulaNode(newRow);
		formulaNode.on("change",function(){
			var feeRow = instance.getFeeRow(this);
			var amountNode = instance.getAmountNode(feeRow);
			if(this.val() == ""){
				amountNode.removeAttribute("disabled");
			}else{
				amountNode.setAttribute("disabled",true);
			}
			instance.calculateAmount();
		});
		var removeNode = instance.getRemoveNode(newRow);
		removeNode.on("click",function(){
			var feeRow = instance.getFeeRow(this);
			feeRow.remove();
			instance.calculateAmount();
		});
		if(feeData){
			newRow.all("input[type=text],select").each(function(node){
				node.val(feeData[node.get("id")]);
			});
			if(feeData["default"] == true){
				feeTypeNode.set("disabled",true); instance.hide(removeNode);
			}
		}
		instance.show(newRow);
	};
	
	/**
	 * sets the amount field based on fee type selected.
	 * amount corresponding to fee type is pulled from fee and funding screen.
	 */
	this.setDefaultFormulaAmount = function(feeType,feeRow){
		var formulaNode = instance.getFormulaNode(feeRow);
		var amountNode = instance.getAmountNode(feeRow);
		var feeData = instance.feeDetails[feeType];
		if(feeData){
			formulaNode.val('');
			amountNode.val(feeData["amount"]);
		}else{
			formulaNode.val('');
			amountNode.val('');
		}
	};
	
	this.getFeeDetailAsJsonObj = function(){
		var feeDetails = [];
		instance.getAllFeeRows().each(function(feeRow){
			var fee = instance.getFeeRowJson(feeRow);
			feeDetails.push(fee);
		});
		return feeDetails;
	};
	
	this.getFeeRowJson = function(feeRow){
		var fee = {};
		feeRow.all("input,select").each(function(node){
			fee[node.get('id')] = node.val();
		});
		return fee;
	}
	
	this.calculateAmount = function(){
		var data = {}; 
		data["feeDetails"] = JSON.stringify(instance.getFeeDetailAsJsonObj());
		data["task"] = "calculateFee";
		var contentId = instance.feeRowContainer.get("id");
		// used to determine if any calculation got failed.Used in validations
		var error = "";
		A.io.request(instance.ajaxUrl,{
            dataType: 'json',
            method: 'POST',
            data: data,
            sync: true,
            on: {
            complete: function(){
            	stopPreLoader(contentId);
            },
            success: function() {
                var responseData=this.get('responseData');
                if(responseData){
                	if(responseData.error){
                		error  = responseData.error; 
                		alert(responseData.error);
                	}else{
                		instance.populateCalculatedValues(responseData);
                	}
                }else{
                	//handle due to some reason data is null
                	error = "Error while calculating amount"; 
                	alert(error);
                }
              },
		    failure : function(){
		    	error = "Error while calculating amount";
		    	alert(error);
		    }
            }
        });
		return error;
	}
	// response must have calcualted value for each fee type
	this.populateCalculatedValues = function(response){
		var i = 0 ;
		var responseArray = response["calculatedAmounts"];
		instance.getAllFeeRows().each(function(feeRow){
			var feeData = responseArray[i];
			instance.getAmountNode(feeRow).val(feeData["calculatedAmount"]);
			i = i + 1;
		});
		
		instance.calculateInstmntAmount();
	}
	this.getAllFeeRows = function(){
		return instance.feeRowContainer.all("[data-id=feeRow]");
	}
	this.getFeeRow = function(node){
		return node.ancestor("[data-id=feeRow]");
	}
	this.getFormulaNode = function(feeRow){
		return feeRow.one("#formula");
	}
	this.getAmountNode = function(feeRow){
		return feeRow.one("#feeAmount");
	}
	this.getFeeType = function(feeRow){
		return feeRow.one("#feeType");
	}
	this.getFeeLabel = function(feeRow){
		return feeRow.one("#feeLabel");
	}
	this.getRemoveNode = function(feeRow){
		return feeRow.one("#remove");
	}
	this.getFeeOrder = function(feeRow){
		return feeRow.one("#order");
	}
	this.show = function(node){
		if(node) node.removeClass("hide");
	}
	this.hide = function(node){
		if(node) node.addClass("hide");
	}
	/**
	 * defaultInstmntRowsData, if it is not null then fill the fields with data.
	 */
	this.addInstmntRows = function(defaultInstmntRowsData){
		instance.instmntsContainer.all("*").remove();
		var rowTemplate = A.one("#insmntRowTemplate");
		var count = instance.noOfInsmnts.val();
		
		if(defaultInstmntRowsData && defaultInstmntRowsData.length > 0){
			count = instance.defaultInstmntRowsData.length;
		}
		for(var i = 0; i < count ; i++){
			var newRow = rowTemplate.cloneNode(true);
			instance.instmntsContainer.appendChild(newRow);
			newRow.one("#insmntNo").val(i+1);
			newRow.one("#insmntNoTxt").set('text',i+1 + instance.getNoSuffix(i+1));
			// unique ids are required for date componet
			var containerId = "dateContainer"+i;
			var triggerId = "date"+i;
			newRow.one("#dateContainer").set("id",containerId);
			newRow.one("#date").set("id",triggerId);
			instance.datePicker(containerId,triggerId);
			instance.show(newRow);
			
			
			if(defaultInstmntRowsData && defaultInstmntRowsData.length > 0){
				var data = defaultInstmntRowsData[i];
				newRow.all("input[type=text],select").each(function(node){
					node.val(data[node.get("id")]);
					if(node.getAttribute("data-id") == 'date'){
						node.val(data["date"]);
					}
				});
			}
		}
		// in this case amount is calculated already.
		if(!defaultInstmntRowsData || defaultInstmntRowsData.length <= 0){
			instance.calculateInstmntAmount();
		}
	};
	
	this.calculateInstmntAmount = function(total,noOfInstmnts){
		if(!instance.insmntsExist){
			return;
		}
		var data = {}; 
		if(instance.getTotalFee() == null) return;
		data["totalAmount"] = instance.getTotalFee();
		data["task"] = "calculateInstmnt";
		data["noOfInstmnts"] = instance.noOfInsmnts.val();;
		var contentId = instance.instmntsContainer.get("id");
		A.io.request(instance.ajaxUrl,{
            dataType: 'json', method: 'POST', sync: true, data: data,
            on: {
            		complete: function(){
            		stopPreLoader(contentId);
            },
            success: function() {
                var responseData=this.get('responseData');
                if(responseData){
                	if(responseData.error){
                		alert(responseData.error);
                	}else{
                		instance.instmntsContainer.all("#instmntAmount").val(responseData.instmntAmount);
                	}
                }else{
                	//handle due to some reason data is null
                	alert("Error while calculating installment amount");
                }
              },
		    failure : function(){
		    	alert("Error while calculating installment amount");
		    }
            }
        });
	}
	
	this.datePicker = function(containerId,triggerId){
		var datePicker = new A.DatePicker(
				{
					container: '#' + containerId,
					mask: '%m/%d/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#' + triggerId
				}
			);
			var calendar = datePicker.getCalendar();
//			calendar.after('dateClick', psInstance.dateSelectionChange, datePicker);
	//		instance[triggerId+"Dp"] = datePicker;
	}
	this.getNoSuffix = function(num){
		if(num == 1) return "st";
		if(num == 2) return "nd";
		if(num == 3) return "rd";
		if(num > 3) return "th";
	}
	
	this.getInstmntsJson =function(){
		var instmnts = [];
		var list = instance.instmntsContainer.all("[data-id=instmntRow]");
		for (var i = 0; i<list.size(); i++){
			var row = list.item(i);
			var rowData = {};
			row.all("input,select").each(function(node){
				var id = node.get('id');
				// check if date field
				if(node.getAttribute("data-id") == "date"){
					id = "date";
				}
				rowData[id] = node.val();
			});
			instmnts.push(rowData);
		
		}
		return instmnts;
	}
	
	this.validate = function(){
		var error  = instance.calculateAmount();
		if(error != ""){
			return false;
		}
		// checking for total fee payable to lithan exists
		if(instance.getTotalFee() == null){
			alert("'Fee component 'Total Fee payable to Lithan' is not present. Please add it to proceed with saving the fee details.");
			return false;
		}
		// checking that total fee payable to lithan must be last component
		if(!instance.isTotalAmountAddedAtLastRow()){
			alert("'Fee component 'Total Fee payable to Lithan' must be added as last fee component");
			return false;
		}
		
		// checking uniqueness of fee types
		try{
			var allFeeRows = instance.getAllFeeRows();
			for (var i = 0; i < allFeeRows.size(); i++){
				var outernode = allFeeRows.item(i);
				var feetypeNode1 = instance.getFeeType(outernode);
				for (var j = i+1; j < allFeeRows.size(); j++){
					var innerNode = allFeeRows.item(j);
					var feetypeNode2 = instance.getFeeType(innerNode);
					if(feetypeNode1.val() == feetypeNode2.val()){
						var option = feetypeNode1.one("[value=" + feetypeNode1.val() + "]");
						alert("Duplicate Fee " + option.text()+" found. Please remove the duplicate Fee Type to proceed");
						return false;
					}
				}
			}
			
		}catch(eror){
			console.log(eror);
		}
		
		if(instance.insmntsExist){
			var list = instance.instmntsContainer.all("[data-id=instmntRow]");
			for (var i = 0; i<list.size(); i++){
				var row = list.item(i);
				var dateNode = row.one("[data-id=date]");
				if(dateNode.val()==''){
					alert("Please provide valid date");
					dateNode.focus();
					return false;
				}
			}
		}
		return true;
	}
	
	this.getCompletePageData = function(){
		var data = {};
		data["feeDetails"]  = instance.getFeeDetailAsJsonObj();
		if(instance.insmntsExist){
			data["noOfInsmnts"] = instance.noOfInsmnts.val();
			data["instmnts"] = instance.getInstmntsJson();
		}
		return data;
	}
	
	this.submitData = function(){
		   var okTosubmit = instance.validate();
		   if(okTosubmit){
			   var data = instance.getCompletePageData();
			   submitJSP(data); // defined in formData.jsp
		   }
	}
	this.saveData = function(){
		var confirmationResult = confirm("Any change to the Funding criteria will not auto refresh the Fees & Funding. Please confirm if you would like to proceed.");
		if(confirmationResult){
			instance.saveButton.set("disabled", true);
			var okTosubmit = instance.validate();
			if (okTosubmit) {
				var data = instance.getCompletePageData();
				var task = 'saveFeeDetails';
				var saveCallBack = function(response) {
					instance.saveButton.set("disabled", false);
					if (response) {
						if (response.error) {
							displayError(response.error);
						}
						if (response.errors) {
							displayErrors(response.errors);
						}
						if (response.successMsg
								&& response.successMsg.length > 0) {
							displaySuccess("Your request successfully processed");
						}
					} else {
						displayError("Error while processing your request");
					}
				};
				saveFormJspViaAjax(instance.ajaxUrl, data, task, saveCallBack); // defined
																				// in
																				// formData.jsp
			} else {
				instance.saveButton.set("disabled", false);
			}
		}
	}
	
	this.init(config);
}
