if (document.getElementById("myTab") != null){
	YUI().use(
	    'aui-tabview',
	    function(Y) {
	        new Y.TabView({
	            srcNode: '#myTab'
	        }).render();
	    }
	
	);
}

if (document.getElementById("myTab1") != null){
	YUI().use(
	    'aui-tabview',
	    function(Y) {
	        new Y.TabView({
	
	            srcNode: '#myTab1'
	        }).render();
	    }
	
	);
}
//Timepicker

//Link Actions

var divs = ["linkToolsWrap", "txttool", "linkToolsWrap_1", "txttool_1", "conatcTool", 'attachNotes', 'logAnchorLink', 'logTxtTool', 'logAttachment'];
var visibleDivId = null;

function toggleVisibility(divId) {
    if (visibleDivId === divId) {

    } else {
        visibleDivId = divId;

    }

    hideNonVisibleDivs();

}



function hideNonVisibleDivs(e) {
    var i, divId, div;
    for (i = 0; i < divs.length; i++) {
        divId = divs[i];
        div = document.getElementById(divId);

        if (visibleDivId === divId) {
            div.classList.add("activeAction");
        } else if (visibleDivId !== divId) {
            //element clicked wasn't the div; hide the div
            div.classList.remove("activeAction");
        }




    }
}

//CONVERSATION
var divsUser = ['userSelectsec'];
var visibledivId_UserUser = null;

function toggleVisibilityUser(divId_User) {
    if (visibledivId_UserUser === divId_User) {

    } else {
        visibledivId_UserUser = divId_User;

    }

    hideNonVisibledivsUser();

}



function hideNonVisibledivsUser(e) {
    var i, divId_User, divIUserWe;
    for (i = 0; i < divsUser.length; i++) {
        divId_User = divsUser[i];
        divIUserWe = document.getElementById(divId_User);

        if (visibledivId_UserUser === divId_User) {
            divIUserWe.classList.add("activeAction");
        } else if (visibledivId_UserUser !== divId_User) {
            //element clicked wasn't the div; hide the div
            divIUserWe.classList.remove("activeAction");
        }




    }
}




function associateRemove() {
    var elementassociateRemove = document.getElementById("ascRemoveAction");
    elementassociateRemove.classList.toggle("show");
}




//close
function closeDialog() {
    x.close();
}



function markUp(markup) {
    var url = document.querySelector('#url').value;
    document.execCommand(markup, false, url);
}


//CLICK OUTSIDE CLOSE


var closebtns = document.getElementsByClassName("closePopupActions");
var i;

for (i = 0; i < closebtns.length; i++) {
    closebtns[i].addEventListener("click", function() {
        this.parentElement.classList.remove("activeAction");
    });
}

//validate content area onchange
var contentValidateArea = document.getElementsByClassName("contentEditError");
for (var i = 0; i < contentValidateArea.length; i++) {
    contentValidateArea[i].addEventListener("input", function() {
        validateContentArea(this);
    }, false);
}


//Validate Activity Fileds

function validate(domNode) {
    var node = A.one("#" + domNode.id);
    var value = node.val();

    if (value.length == 0) {
        A.one("#" + domNode.id).ancestor().addClass('ErrorValidation');
        return true;
    } else {
        A.one("#" + domNode.id).ancestor().removeClass('ErrorValidation');
        return false;
    }

}

function validateContentArea(domNode) {
    var nodeCn = A.one("#" + domNode.id);
    var valueContent = document.getElementById(domNode.id).innerHTML;

    if (valueContent.trim() == "") {
        A.one("#" + domNode.id).ancestor().addClass('ErrorValidation');
        return true;
    } else {
        A.one("#" + domNode.id).ancestor().removeClass('ErrorValidation');
        return false;
    }

}



function validateReqField(id, counter){
	var contextNode = A.one("#" + id + counter);
	var nodes = contextNode.all("input[type=text],div,select,H2,P");
	var result = false;
	nodes.each(function(node){
	var cn = node.getAttribute("class");
		if(cn.includes("Requiredfield")){
			if (node.getAttribute('contenteditable') == "true"){
				var temp = validateContentArea(node.getDOMNode());
			}else{
				var temp = validate(node.getDOMNode());
			}
			
			if (temp){
				result = true;
			}
		}
	});
	
	return result;
}

