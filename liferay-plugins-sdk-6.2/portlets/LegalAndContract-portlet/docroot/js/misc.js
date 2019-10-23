function removeFile(tableName){
	AUI().use('aui-node','aui-base',function(A){
		var fileTable = A.one("#" + tableName);
		if(fileTable){
			var links = fileTable.all("a");
			links.each(function (link, index) {
			    link.on("click", function(em){
			    	var fileEntryId = link.getAttribute('id').substring(4);
			    	link.ancestor("tr").remove();
			    	A.use('aui-io-request', function (){
						A.io.request(ajaxurl,{
							dataType : 'json',
							method : 'POST',
							data : {
								action: 'removeFile',
								fileEntryId: fileEntryId
							},
							on : {
							success : function() {
									var data = this.get('responseData');
									var result = data.result;
									}
							}
						});
						
					});
			    	
			    });
			});
		}
	});
}

function trademarkTypeChangeEvnt(pns){
	AUI().use("node","event",function(A){
		var typeId = "#" + pns + "trademarkType";
		A.one(typeId).on("change",function(){
			showHideLogoWord(pns);
		});
	});
}
function showHideLogoWord(pns){
	AUI().use('aui-node','aui-base',function(A){
		var typeId = "#" + pns + "trademarkType";
		var typeVal = A.one(typeId).get('value');
		var trademarkObj = A.one("#" +  "wordDiv");
		var fileObj =  A.one("#" +  "logoDiv");
		if(typeVal == 'word'){
			trademarkObj.setStyle('display','inline-block');
			fileObj.setStyle('display','none');
		}else{
			trademarkObj.setStyle('display','none');
			fileObj.setStyle('display','inline-block');
		}
	});
	
}
function showhidesearchValObj(classNs){
	AUI().use("node","event",function(A){
		var sfId = "#" + classNs + "searchField";
		var valId = "#" + classNs + "searchValue";
		var lastObj ;
		A.one(sfId).on("change",function(){
	        var value = this.get('value');		
	        var tid = "#" + classNs + "list_" + value;
	        var dobj = A.one(tid);
	        if(dobj){
	        	hideSearchDds(classNs);
	        	dobj.setStyle('display','inline');
	        	A.one(valId).setStyle('display','none');
	        }else{
	        	A.one(valId).setStyle('display','inline');
	        	hideSearchDds(classNs);
	        }
		});
	}
);
}
function hideSearchDds(portletNs){
	var sfId = "#" + portletNs + "searchField";
	AUI().use('node','event',function(A){
		var opts = A.all( sfId + " option");
		if(opts){
			opts.each(function(opt,indx){
				var optval = opt.get('value');
				var listId = "#" + portletNs + "list_" + optval;
				var listObj = A.one(listId);
				if(listObj){
					listObj.setStyle('display','none');
				}
			});
		}
	}
	);
}
function initializeSearchFields(portletNs){
	var sfId = "#" + portletNs + "searchField";
	AUI().use('node','event',function(A){
		hideSearchDds(portletNs);
		var  sopt = A.one(sfId + " option[selected]");
		if(sopt){
			var optval = sopt.get('value');
			var listId = "#" + portletNs + "list_" +  optval;
			var valId = "#" + portletNs + "searchValue";
			var listObj = A.one(listId);
			if(listObj){
				listObj.setStyle('display','inline');
				A.one(valId).setStyle('display','none');
			}else{
				A.one(valId).setStyle('display','inline');
			}
		}
	});
};

function initializeExport(portletNs,ajaxUrl){
	
	var func = function(event){
		AUI().use('aui-node','aui-base','aui-io-request-deprecated', function (A){
			var sfId = "#" + portletNs + "searchField";
			var valId = "#" + portletNs + "searchValue";
			var sfObj = A.one(sfId);
			var optval = sfObj.get("value");
			
			var listId = "#" + portletNs + "list_" + optval;
			var listObj = A.one(listId);
			var searchTextVal = A.one(valId).get("value");
			
			var listFVal = "";
			if(listObj){
				listFVal = listObj.get("value");
			}
			var exptype = '';
			if(event.target.get('id') == portletNs + "export")
				exptype = 'exportListPdf';
			else 
				exptype = 'exportListXls';
			var dataObj = {
					action: exptype
			};
			
			dataObj[portletNs + "searchField"] = optval;
			dataObj[portletNs + "searchValue"] = searchTextVal;
			dataObj["list_" + optval] = listFVal;
			
			A.io.request(ajaxUrl,{
				dataType : 'json',
				method : 'POST',
				data : dataObj,
				on : {
					success : function() {
						var data = this.get('responseData');
						if(data && data.errorMsg){
							alert(data.errorMsg);
						}else{
							document.location.href = "/LegalAndContract-portlet/download?fileName=" + data.fileName ;
						}
					},
					failure : function(){
						var data = this.get('responseData');
						if(data && data.errorMsg){
							alert(data.errorMsg);
						}else{
							alert("Error while generating the report");
						}
					}
				}
			});
			
		});
		
	};
	
	AUI().use('aui-node','aui-base',function(A){
		var buttonId = "#" + portletNs + "export";
		var buttonXlsId = "#" + portletNs + "exportXls";
		var exportObj = A.one(buttonId);
		var exportXlsObj = A.one(buttonXlsId);
		
		if(exportObj){
			exportObj.on("click", func);
		}
		
		if(exportXlsObj) {
			exportXlsObj.on("click", func);
		}
		
	});
}
	
function initializeUploadButton(pns,fupId,uploadBId){
	AUI().use('node',function(A){
		var fupObj = A.one(fupId);
		if(fupObj){
			 A.one(uploadBId).set('disabled',true);
			fupObj.on("change",function(){
				var fvalue = this.get('value');
				if(fvalue.length > 0){
					A.one(uploadBId).set('disabled',false);
				}else{
					A.one(uploadBId).set('disabled',true);
				}
				
			});
		}
	});
}

function initClassCodeButton(pns) {
	
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		 A.one('#addClassCode').on('click', function() {
			 if(!classCodeCount){
				 window.classCodeCount = 0;
			 }
			classCodeCount = classCodeCount + 1;
		/*	if(classCodeCount > 33) 
				alert('Maximum 33 class codes accepted');
			else {} */
			
			//var data = this.get('responseData');
			var sampleCont = A.one('#sampleClassCodeContainer');
			var container = A.one('.dynaClassCodeContainer');
			var dup = sampleCont.clone();
			dup.set('id', 'ccData' + classCodeCount);
			dup.setStyle('display', 'block');
			dup.one('#' + pns + 'cCode').set('name', dup.one('#' + pns + 'cCode').get('name') + classCodeCount);
			dup.one('#' + pns + 'cSpec').set('name', dup.one('#' + pns + 'cSpec').get('name') + classCodeCount);
			var removeLinkId = "classCoderemove" + classCodeCount;
			dup.one('#classCoderemove').set('id',removeLinkId );
			dup.appendTo(container);
			A.one("#" + removeLinkId).on("click",function(){
				//Length of classCoderemove is 15;
				var indexVal = this.get('id').substring(15);
				if(indexVal && indexVal != ''){
					A.one("#" + 'ccData' + indexVal).remove();
				}
			});
		
		 });
	 });
}
function initClassCodeRemoveLinks(){
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		var links = A.one(".dynaClassCodeContainer").all("a");
		links.each(function(link){
			link.on("click",function(){
				var indexVal = this.get('id').substring(15);
				if(indexVal && indexVal != ''){
					A.one("#" + 'ccData' + indexVal).remove();
				}
			});
		});
	});
}

function initrdlAddButton() {
	
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		A.one('#addRdl').on('click', function() {
			if(!rdlCount){
				window.rdlCount = 0;
			}
			rdlCount = rdlCount + 1;
			var container = A.one('#dynaRdlsContainer');
			var sampleCont = container.one('#sampleRdlContainer');
			var dup = sampleCont.clone();
			dup.set('id', 'rdl' + rdlCount);
			dup.setStyle('display', 'block');
			//dup.one('.field-input-select').set('name', dup.one('.field-input-select').get('name') + rdlCount);
			
			var pns = "_litigationaction_WAR_LegalAndContractportlet_";
			
			var monthId = pns + 'responseDeadlineMonth' + rdlCount;
			var dayId = pns + 'responseDeadlineDay' + rdlCount;
			var yearId = pns + 'responseDeadlineYear' + rdlCount;
		
			dup.one('#' + pns + 'responseDeadlineMonth').set('name', monthId);
			dup.one('#'+ pns + 'responseDeadlineDay').set('name', dayId);
			dup.one('#' + pns + 'responseDeadlineYear').set('name', yearId);
			
			dup.one('#' + pns + 'responseDeadlineMonth').set('id', monthId);
			dup.one('#'+ pns + 'responseDeadlineDay').set('id', dayId);
			dup.one('#' + pns + 'responseDeadlineYear').set('id', yearId);
			
			dup.one('#' + pns + 'claimsRemarks').set('name', pns + 'claimsRemarks' + rdlCount);
			dup.one('#' + pns + 'claimsRemarks').set('value', "");
			dup.one('#' + pns + 'alertBefore').set('name', pns + 'alertBefore' + rdlCount);
			
			
			var removeLinkId = "rdlRemove" + rdlCount;
			dup.one('#rdlRemove').set('id',removeLinkId );
			dup.appendTo(container);
			A.one("#" + removeLinkId).on("click",function(){
				//Length of rdlRemove is 9;
				var indexVal = this.get('id').substring(9);
				if(indexVal && indexVal != ''){
					A.one("#" + 'rdl' + indexVal).remove();
				}
			});
			
			try{
				// initialize calendar icon
				var datePickerContainer = dup.one(".lfr-input-date");
				var datePickerInput =  dup.one("#" + pns + "responseDeadline");
			//	var imageInputId =  dup.one("input[type='hidden']");

				var containerId = "displayDate" + rdlCount;
				var inputId =  pns + "responseDeadline" + rdlCount;//"datePickerContent" + rdlCount;
				//var iid = "imageInput" + rdlCount;
				
				datePickerContainer.set("id",containerId);
				datePickerInput.set("id",inputId);
				//imageInputId.set("id",iid);

				calenderHandler(containerId,inputId, dayId, monthId,yearId);
				
			}catch(err){
				console.log(err);
			}
			
			
		});
	});
}

function initRdlRemoveLinks(){
	AUI().use('aui-node','aui-base',function(A){
		var links = A.one("#dynaRdlsContainer").all("a");
		if(links){
			links.each(function(link){
				link.on("click",function(){
					//Length of rdlRemove is 9;
					var indexVal = this.get('id').substring(9);
					if(indexVal && indexVal != ''){
						A.one("#" + 'rdl' + indexVal).remove();
					}
				});
			});
		}
	});
}

function initalizeTmLocalized(pns){
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		var tmnode = A.one("#" + pns + "trademark");
		tmnode.on("keyup",function(event){
			showHideTMLocalized(pns);
		});
	});
}
function showHideTMLocalized(pns){
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		var tmLocalized = A.one("#tmlocalized");
		var value = A.one("#" + pns + "trademark").get('value');
		var allEnglish = true;
		for(var i = 0; i< value.length; i++){
			if(value.charCodeAt(i) > 879){
				tmLocalized.setStyle('display','inline');
				allEnglish= false;
				break;
			}
		}
		if(allEnglish){
			tmLocalized.setStyle('display','none');
		}
	
	});
}


function validateLogo(ns) {
	var retVal = false;
	AUI().use('aui-node','aui-base',function(A){
		var typeVal = A.one('#' + ns + 'trademarkType').get('value');
		var rowData = A.one("#logoDiv #filesTable tr");
		if(typeVal != 'logo') {
			retVal = true;
		} else if(rowData) {
		    retVal = true;
		} else {
			retVal = false;
		}
	});
	return retVal;
}


function validateTM(val, ns) {
	var retVal = false;
	var data = val;
	AUI().use('aui-node','aui-base',function(A){
		var typeVal = A.one('#' + ns + 'trademarkType').get('value');
		if(typeVal == 'logo') {
			retVal = true;
		} else if(data.length == 0) {
		    retVal = false;
		} else {
			retVal = true;
		}
	});
	return retVal;
}


function validateLocalizedTM(val, ns) {
	var retVal = false;
	var data = val;
	AUI().use('aui-node','aui-base',function(A){
		var typeVal = A.one('#' + ns + 'trademarkType').get('value');
		var value = A.one('#' + ns + 'trademark').get('value');
		allEnglish = true;
		if(typeVal == 'word'){
			for(var i = 0; i< value.length; i++){
				if(value.charCodeAt(i) > 200){
					allEnglish= false;
					break;
				}
			}
		}
		if(allEnglish || typeVal == 'logo') {
			retVal = true;
		} else if(data.length == 0) {
		    retVal = false;
		} else {
			retVal = true;
		}
	});
	return retVal;
}
function calenderHandler(datePickerId,nameId, dayParam, monthParam,yearParam){
	
	AUI().use('aui-datepicker', function(A) {
		Liferay.component(
				nameId ,
				function() {
					var datePicker = new A.DatePicker(
						{
							container: '#' + datePickerId,
							mask: '%m/%d/%Y',
							on: {
								disabledChange: function(event) {
									var instance = this;

									var container = instance.get('container');

									var newVal = event.newVal;

									container.one('#' + dayParam).attr('disabled', newVal);
									container.one('#' + monthParam).attr('disabled', newVal);
									container.one('#' + nameId).attr('disabled', newVal);
									container.one('#' + yearParam).attr('disabled', newVal);
								},
								selectionChange: function(event) {
									var instance = this;

									var container = instance.get('container');

									var date = event.newSelection[0];
									if (date) {
										container.one('#' + dayParam).val(date.getDate());
										container.one('#' + monthParam).val(date.getMonth());
										container.one('#' + yearParam).val(date.getFullYear());
									}else{
										container.one('#' + dayParam).val('0');
										container.one('#' + monthParam).val('-1');
										container.one('#' + yearParam).val('0');
										alert();
									}
								}
							},
							popover: {
								zIndex: Liferay.zIndex.TOOLTIP
							},
							trigger: '#' + nameId
						}
					);

					datePicker.getDate = function() {
						var instance = this;

						var container = instance.get('container');

						return new Date(container.one('#' + yearParam).val(), container.one('#' + monthParam).val(), container.one('#' + dayParam).val());
					};

					return datePicker;
				}
			);
			Liferay.component(nameId );
	});
	
	
}

function initTmDropDown(ajaxUrl, ns) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var selBox = A.one("#" + ns + 'trademarksIddd');
		selBox.on("change", function() {
			var trademarkId = this.get("value");
			A.io.request(ajaxUrl,{
				dataType : 'json',
				method : 'POST',
				data : {
					action: 'getTrademark',
					tmId: trademarkId
				},
				on : {
					success : function() {
						var data = this.get('responseData');
						if(data) {
							var str = data.trademarkText;
							var tmField = A.one("#tmName");
							if (str != undefined) {
								tmField.html(str);
								tmField.setAttribute('href' , data.trademarkUrl);
							}
						}
					}
				}
			});
		});
	});
}

function initSubmitTrademarkForm(pns,submitId,formId){
	AUI().use('aui-node','aui-base',function(A){
		A.one('#' + submitId).on('click',function(){
			var validator = eval('Liferay.Form._INSTANCES.' + pns + formId + '.formValidator');
			validator.validate();
			if(validator.hasErrors()){
				
			}else{
				var formObj = A.one('#' + pns + formId);
				formObj.set('method','post');
				formObj.submit(); 
				//document.getElementById(pns + formId).submit();	
			}
		});
	});
}