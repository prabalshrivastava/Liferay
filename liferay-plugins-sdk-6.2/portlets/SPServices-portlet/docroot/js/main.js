function initSubmitSPParameterForm(pns,submitId,formId){
	AUI().use('aui-node','aui-base',function(A){
		A.one('#' + submitId).on('click',function(){
			var validator = eval('Liferay.Form._INSTANCES.' + pns + formId + '.formValidator');
			validator.validate();
			if(validator.hasErrors()){
				
			}else{
				var formObj = A.one('#' + pns + formId);
				formObj.set('method','post');
				formObj.submit(); 
			}
		});
	});
}