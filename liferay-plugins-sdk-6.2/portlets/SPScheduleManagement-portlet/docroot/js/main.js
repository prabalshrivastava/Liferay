function displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg");
	alert_div.innerHTML = '<p>Please fix the following errors before submitting.</p><ul><li><strong>'+message+'</strong></li></ul>';
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