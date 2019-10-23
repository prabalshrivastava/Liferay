<div id="msgContainer" class="hide msgContainer" tabindex="500"></div>

<script>
function displayError(msg){
	AUI().use('aui-node', 'aui-base', 'aui-io-request', function(A) {
		var msgNode = A.one("#msgContainer");
		msgNode.removeClass("hide");
		msgNode.removeClass("portlet-msg-success");
		msgNode.addClass("alert-error");
		msgNode.focus();
		msgNode.setContent(msg);
	});
}
function displaySuccess(msg){
	AUI().use('aui-node', 'aui-base', 'aui-io-request', function(A) {
		var msgNode = A.one("#msgContainer");
		msgNode.removeClass("hide");
		msgNode.addClass("portlet-msg-success");
		msgNode.removeClass("alert-error");
		msgNode.focus();
		msgNode.setContent(msg);
	});
}
function hideMessage(){
	AUI().use('aui-node', 'aui-base', 'aui-io-request', function(A) {
		var msgNode = A.one("#msgContainer");
		msgNode.addClass("hide");
	});
}
</script>
