<div id="msgContainer" class="hide msgContainer" tabindex="500">
</div>

<div id="sampleMsg" class="hide">

</div>

<script>
function clearMsgContainer(){
	msgContainerNode.removeClass("hide");
	msgContainerNode.all("*").remove();
}

function addMsgNode(msg,cssClass){
	var sampleNode = sampleMsgNode.cloneNode(true);
	sampleNode.setContent(msg);
	sampleNode.removeClass("hide");
	if(cssClass && cssClass != ""){
		sampleNode.addClass(cssClass);
	}
	sampleNode.focus();
	msgContainerNode.appendChild(sampleNode);
}

function displayError(error){
	clearMsgContainer();
	addMsgNode(error,"alert-error");
}
function displayErrors(errors){
	clearMsgContainer();
	if(errors){
		errors.forEach(function(error){
			addMsgNode(error,"alert-error");
		});
	}
}

function displaySuccess(msg){
	clearMsgContainer();
	addMsgNode(msg,"portlet-msg-success");
}
function displayNormalMsg(msg){
	clearMsgContainer();
	addMsgNode(msg,"");
}


function hideMessage(){
		var msgNode = A.one("#msgContainer");
		msgNode.addClass("hide");
}
var sampleMsgNode =null;
var msgContainerNode = null;

AUI().use('aui-node', 'aui-base', 'aui-io-request', function(A) {
	sampleMsgNode = A.one("#sampleMsg");
	msgContainerNode = A.one("#msgContainer");

});
</script>
