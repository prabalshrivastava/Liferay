function checkATForm(thisInstance) {
	checkForm(thisInstance);
}
function checkForm(thisInstance) {
	if (thisInstance.components.Submit.buttonElement.disabled == false) {
		thisInstance.components.SaveDraft.disabled = false;
	} else {
		thisInstance.components.SaveDraft.disabled = true;
	}
}