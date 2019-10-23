function composeMsg(configObj){
	
	var ajax;
	var pns;
	var A;
	
	var cancel,saveDraft,send;
	var form;
	
	function intialize(configObj){
		A = AUI().use('aui-node','aui-base', 'aui-io-request-deprecated');
		ajax = configObj.ajax;
		pns = configObj.pns;
	}

	function initializePageElements(){
		cancel = A.one("#cmpMsgCancel");
		saveDraft = A.one("#cmpMsgSaveDraft");
		send = A.one("#cmpMsgSend");
		form = A.one("#cmpMsgForm");
		
	}
	function initializeActions(){
		
	}
	
	function initializeEditor(){
		var ckeditor = CKEDITOR.replace(pns + "cmpMsgContent",
				{
					resize_enabled: false,
					toolbar :
					[
					['Bold','Italic','NumberedList','BulletedList' ]
					]
				}); 
	}
}