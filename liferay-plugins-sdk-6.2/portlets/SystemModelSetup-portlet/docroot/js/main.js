function checkAMForm(thisInstance) {
	checkForm(thisInstance);
}
function checkForm(thisInstance) {
	if (thisInstance.components.Submit.buttonElement.disabled == false) {
		thisInstance.components.SaveDraft.disabled = false;
	} else {
		thisInstance.components.SaveDraft.disabled = true;
	}
}

function displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg");
	console.log("alert_div : "+alert_div);
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}
var timeOut;
function scrollToTop() {
	if (document.body.scrollTop != 0 || document.documentElement.scrollTop != 0) {
		window.scrollBy(0, -50);
		timeOut = setTimeout('scrollToTop()', 10);
	} else {
		clearTimeout(timeOut);
	}

}
function reloadPage() {
	window.location.reload();
}
function findAncestor(el, cls) {
	while ((el = el.parentElement) && !el.classList.contains(cls))
		;
	return el;
}